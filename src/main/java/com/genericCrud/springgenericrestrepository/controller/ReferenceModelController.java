package com.genericCrud.springgenericrestrepository.controller;
import com.genericCrud.springgenericrestrepository.dto.CommonResponse;
import com.genericCrud.springgenericrestrepository.dto.EntityObjectData;
import com.genericCrud.springgenericrestrepository.service.ReferenceModelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

/**
 * *
 *
 * @author : Dushman Nalin
 * @version : 1.0
 * @date : September 23, 2019
 */
@CrossOrigin
@RestController
@RequestMapping("/commonEntities")
public class ReferenceModelController {

    @Autowired
    ReferenceModelServiceImpl referenceModelService;

    @GetMapping("/{tableName}/{id}")
    public <T> ResponseEntity<T> getObject(@PathVariable("tableName") String tableName, @PathVariable("id") Integer id) throws ClassNotFoundException {
        T entityObject = referenceModelService.getEntityCategory(tableName, id);

        if (entityObject != null) {
            return new ResponseEntity<>(entityObject, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/{tableName}")
//    public Object getAll(@PathVariable("tableName") String tableName) {
//        Object commonResponse = referenceModelService.getEntityCategoryList(tableName);
//        return commonResponse;
//    }

    @PostMapping
    public ResponseEntity<CommonResponse> postEntityCategory(@RequestBody EntityObjectData entityObjectData) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        CommonResponse commonResponse = referenceModelService.addEntityCategory(entityObjectData);
        return new ResponseEntity<>(commonResponse, HttpStatus.valueOf(commonResponse.getStatusCode()));
    }

    @PutMapping
    public ResponseEntity<CommonResponse> updateEntityCategory(@RequestBody EntityObjectData entityObjectData) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        CommonResponse commonResponse = referenceModelService.updateEntityCategory(entityObjectData);
        return new ResponseEntity<>(commonResponse, HttpStatus.valueOf(commonResponse.getStatusCode()));
    }

    @DeleteMapping
    public ResponseEntity<CommonResponse> deleteEntityCategory(@RequestBody EntityObjectData entityObjectData) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        CommonResponse commonResponse = referenceModelService.deleteEntityCategory(entityObjectData);
        return new ResponseEntity<>(commonResponse, HttpStatus.valueOf(commonResponse.getStatusCode()));
    }
}
