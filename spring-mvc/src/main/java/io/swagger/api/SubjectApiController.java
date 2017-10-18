package io.swagger.api;


import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-11T10:26:38.488-04:00")

@Controller
public class SubjectApiController implements SubjectApi {
    private final ObjectMapper objectMapper;

    int size = 10;
    int currentlast = 0;
    Subject[] Subjects = new Subject[size];

    public SubjectApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public int getPosition(int id){
      for(int i = 0; i < 10; i++){
        if(id.equals(Subjects[i].ID)){
          return i;
        }
      }
      return -1;
    }

    public ResponseEntity<Void> addItemInSubject(@ApiParam(value = "item's identification",required=true ) @PathVariable("itemID") String itemID,
    @NotNull@ApiParam(value = "subject's ID", required = true) @Valid @RequestParam(value = "subjectID", required = true) String subjectID,
    @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
      int pos = getPosition(subjectID);
      if(pos != -1){
        Subjects[pos].addItem(itemID);
      }
      return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> addSubject( @NotNull@ApiParam(value = "Subject/Item object that will be added in the store", required = true) @Valid @RequestParam(value = "subjectURL", required = true) String subjectURL,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        if(getPosition(subjectID) == -1){
          Subjects[currentlast].ID = subjectURL;
          currentlast++;
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteItemInSubject(@ApiParam(value = "item's identification",required=true ) @PathVariable("itemID") String itemID,
         @NotNull@ApiParam(value = "subject's ID", required = true) @Valid @RequestParam(value = "subjectID", required = true) String subjectID,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
          int pos = getPosition(subjectID);
          if(pos != -1){
            Subjects[pos].deleteItem(itemID);
          }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteSubject( @NotNull@ApiParam(value = "Subject id to delete", required = true) @Valid @RequestParam(value = "subjectID", required = true) String subjectID,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
          int pos = getPosition(subjectID);
          if(pos != -1){
            for(int i = pos; i < currentlast-1; i++){
              Subjects[i] = Subjects[i+1];
            }
            currentlast--;
          }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
