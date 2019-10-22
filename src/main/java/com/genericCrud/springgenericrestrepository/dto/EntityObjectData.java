package com.genericCrud.springgenericrestrepository.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
@Setter
public class EntityObjectData {
    String className;
    ArrayList<HashMap<String,Object>> entityObjectList;
}
