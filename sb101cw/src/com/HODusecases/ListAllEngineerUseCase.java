package com.HODusecases;


import java.util.List;


import com.dao.HODdao;
import com.dao.HODdaoImpl;
import com.exception.EngineerException;
import com.model.Engineer;


public class ListAllEngineerUseCase {
     public static void main(String[] args) {
    	
         
         HODdao dao = new HODdaoImpl();
           try {
			List<Engineer> result =dao.GetAllEnggDetails();
			
			result.forEach(el->System.out.println(el));
		} catch (EngineerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
        
     
     
}
