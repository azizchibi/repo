package com.paloit.entities;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

public class PersonDataModel extends ListDataModel<Person> implements  SelectableDataModel<Person>{

	  public PersonDataModel() {  
	  
	  }  
	  
    public PersonDataModel(List<Person> data) {  
        super(data);  
    }  
	    
	@Override
	public Person getRowData(String rowKey) {
		 List<Person> persons = (List<Person>) getWrappedData();  
         
	        for(Person person : persons) {  
	            if(person.getId().equals(rowKey))  
	                return person;  
	        }  
		return null;
	}

	@Override
	public Object getRowKey(Person person) {
		return person.getId();
	}

}
