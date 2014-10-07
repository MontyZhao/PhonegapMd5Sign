package com.ouxuan.md5sign;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Md5Sign extends CordovaPlugin{
	@Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("sign")) {   //action=echo 
         
		/*  String uid = args.getString(0);  //用户id
            String username = args.getString(1);  //用户名
            String salt = args.getString(2);  //用户名 */
            
        	
        	
        	
        	
     /*   	StringBuffer sss=new StringBuffer();
        	
        	for(int i=0;i<=args.length()-1;i++)
        	{
        		sss.append(args.getString(i));
        	}*/
        	
        	String message="";
            message=Md5(args.getString(0)+"ouxuan1234"); 
        	//message=args.getString(0)+"ouxuan1234"; 
            
            //System.out.println("MD5加密后的结果为"+message);
            
            this.echo(message, callbackContext);
            return true;
        }else{
    	 	callbackContext.error("这不是一个echo操作");
    	 	return false;
        }
        
    }
    private void echo(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }    
    //md5加密
    public String Md5(String plainText) { 
    	try { 
	    	MessageDigest md = MessageDigest.getInstance("MD5"); 
	    	md.update(plainText.getBytes()); 
	    	byte b[] = md.digest(); 
	
	    	int i; 
	
	    	StringBuffer buf = new StringBuffer(""); 
	    	for (int offset = 0; offset < b.length; offset++) { 
	    	i = b[offset]; 
	    	if(i<0) i+= 256; 
	    	if(i<16) 
	    	buf.append("0"); 
	    	buf.append(Integer.toHexString(i)); 
    	} 

	    	//System.out.println("result: " + buf.toString());//32位的加密 
	
	    	//System.out.println("result: " + buf.toString().substring(8,24));//16位的加密 
    		plainText=buf.toString();
    	} catch (NoSuchAlgorithmException e) { 
    		// TODO Auto-generated catch block 
    		e.printStackTrace(); 
    	}    	
		return plainText; 
    } 
	
}
