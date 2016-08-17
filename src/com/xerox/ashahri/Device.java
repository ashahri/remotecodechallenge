package com.xerox.ashahri;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Device {

@SerializedName("brand")
@Expose
private String brand;
@SerializedName("model")
@Expose
private String model;
@SerializedName("formFactor")
@Expose
private String formFactor;
@SerializedName("attributes")
@Expose
private List<Attribute> attributes = new ArrayList<Attribute>();

/**
* 
* @return
* The brand
*/
public String getBrand() {
return brand;
}

/**
* 
* @param brand
* The brand
*/
public void setBrand(String brand) {
this.brand = brand;
}

/**
* 
* @return
* The model
*/
public String getModel() {
return model;
}

/**
* 
* @param model
* The model
*/
public void setModel(String model) {
this.model = model;
}

/**
* 
* @return
* The formFactor
*/
public String getFormFactor() {
return formFactor;
}

/**
* 
* @param formFactor
* The formFactor
*/
public void setFormFactor(String formFactor) {
this.formFactor = formFactor;
}

/**
* 
* @return
* The attributes
*/
public List<Attribute> getAttributes() {
return attributes;
}

/**
* 
* @param attributes
* The attributes
*/
public void setAttributes(List<Attribute> attributes) {
this.attributes = attributes;
}

}