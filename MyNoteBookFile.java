import java.io.*;
import java.util.*;
import java.io.File.*;
import java.nio.file.*;
import java.nio.file.attribute.*;




public class MyNoteBookFile{
 final static String NOTEBOOK = "F:\\javaproject\\scr\\com\\fencer\\su1\\MyNoteBook.TXT";
 private static String NOTEBOOK_COPY = "F:\\javaproject\\scr\\com\\fencer\\su1\\MyNoteBookCopy.TXT";
 private static  ArrayList<ContactFromFile>  contactAll = new ArrayList<ContactFromFile>();
 
 public MyNoteBookFile(){
 }
 
 public MyNoteBookFile(ArrayList<ContactFromFile>  contactAll){
     this.contactAll = contactAll;
 }
 
 public static ArrayList<Integer> readFromFile(){
   FileInputStream take;
   ArrayList<Integer> intFile = new ArrayList<Integer>();
   try{
   take = new FileInputStream(NOTEBOOK);
    
	while(true){
	 int ch = take.read();
	  if (ch != -1) {
	     intFile.add(ch);  
	   }
	  else{
	  break;
	  } 
     }
	take.close();
   } catch (IOException e){
     e.printStackTrace();
   }
    return intFile;
 }
 
 public static ArrayList<ContactFromFile> arrayListContact(ArrayList<Integer> intFile){
   ArrayList<String> strEmail = new  ArrayList<String>();
   ArrayList<String> strName = new  ArrayList<String>();
   ArrayList<String> char1 = new  ArrayList<String>();
  
   String stroka = "";
   String stroka1 = "";
   
   for (int i = 0; i < intFile.size(); i++){
     if ((char)(intFile.get(i).intValue()) == '\t' || (char)(intFile.get(i).intValue()) == '\n'){
	 char1.add(stroka); 
	 stroka = ""; 
	 }
	 else{
       char ch = (char)(intFile.get(i).intValue());
       stroka += new StringBuilder().append(ch);
     }	   
   }
   
   
   
   for (int i = 0; i < char1.size(); i++){
     if (i == 0){
	   strEmail.add(char1.get(i));
	   continue;
	 }
	 
	 if (i == 1){
	   strName.add(char1.get(i));
	   continue;
	 }
	 
     if ( i % 2 == 0){
	 strEmail.add(char1.get(i));
	 }
	 if ( i % 2 != 0){
	 strName.add(char1.get(i));
	 }
   }
   
   for (int i = 0; i < strEmail.size(); i++){
      contactAll.add(new ContactFromFile(strEmail.get(i), strName.get(i)));
   }
   
   return  contactAll;
 }
 
 public static void showContact(){
   arrayListContact(readFromFile());
   for (int i = 0; i < contactAll.size(); i++){
     System.out.println(contactAll.get(i).toString());
   }
 }
 
 public static void insertContact(String email, String name){
  FileOutputStream wr;
  String sos = email + "\t" + name + "\n";
  
   try{
     wr = new FileOutputStream(NOTEBOOK, true); 
	for (int i = 0; i < sos.length(); i++){
      int ch = (int)(sos.charAt(i));
	   wr.write(ch);
    }	
	 wr.close();
   }catch (Exception e){
      e.printStackTrace();
   }
 }
 
 public static void deleteContact(String email, String name){
   FileInputStream take;
   FileOutputStream give;
   ArrayList<Integer> intFile = new ArrayList<Integer>();
   try{
   take = new FileInputStream(NOTEBOOK);
    
	while(true){
	 int ch = take.read();
	  if (ch != -1) {
	     intFile.add(ch);  
	   }
	  else{
	  break;
	  } 
     }
	
	
	String allStr = "";
	 for (int i = 0; i < intFile.size(); i++){
	   allStr += (char)(intFile.get(i).intValue());
	 }
	 
	String delStr = email + "\t" + name + "\n";
	String allStrNew = allStr.replaceAll(delStr, "");
	
	give = new FileOutputStream(NOTEBOOK_COPY);
	 for (int i = 0; i < allStrNew.length(); i++){
	   int ch = (int)(allStrNew.charAt(i));
	   give.write(ch);
	 }
	 
	 give.close();
	 take.close();
	 
	FileInputStream take1 = new FileInputStream(NOTEBOOK_COPY);
    FileOutputStream give1 = new FileOutputStream(NOTEBOOK);
	
	while (true){
	  int ch = (int)(take1.read());
	   if (ch == -1){
	     break;
	   }
	  give1.write(ch); 
	}
	 
     give1.close();
	 take1.close();
	 
	 Path path = Paths.get("F:\\javaproject\\scr\\com\\fencer\\su1\\MyNoteBookCopy.TXT");
	 Files.delete(path);
	 
	 
   } catch (IOException e){
     e.printStackTrace();
   }
   
 }
 
 
 public static void deleteAllContact(){
   FileInputStream take;
   FileOutputStream give;
   ArrayList<Integer> intFile = new ArrayList<Integer>();
   try{
   take = new FileInputStream(NOTEBOOK);
    
	while(true){
	 int ch = take.read();
	  if (ch != -1) {
	     intFile.add(ch);  
	   }
	  else{
	  break;
	  } 
     }
	
	
	String allStr = "";
	 for (int i = 0; i < intFile.size(); i++){
	   allStr += (char)(intFile.get(i).intValue());
	 }
	 
	
	String allStrNew = allStr.replaceAll(allStr, "");
	
	give = new FileOutputStream(NOTEBOOK_COPY);
	 for (int i = 0; i < allStrNew.length(); i++){
	   int ch = (int)(allStrNew.charAt(i));
	   give.write(ch);
	 }
	 
	 give.close();
	 take.close();
	 
	FileInputStream take1 = new FileInputStream(NOTEBOOK_COPY);
    FileOutputStream give1 = new FileOutputStream(NOTEBOOK);
	
	while (true){
	  int ch = (int)(take1.read());
	   if (ch == -1){
	     break;
	   }
	  give1.write(ch); 
	}
	 
     give1.close();
	 take1.close();
	 
	 Path path = Paths.get("F:\\javaproject\\scr\\com\\fencer\\su1\\MyNoteBookCopy.TXT");
	 Files.delete(path);
	 
	 
   } catch (IOException e){
     e.printStackTrace();
   }
   
 }

 public static void main(String[] args){
  try{
      showContact();
  }catch (Exception e){
     e.printStackTrace();
  }
  
  

 }
}





