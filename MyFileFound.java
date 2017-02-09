



import java.util.ArrayList;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.FileVisitResult;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;
import java.nio.file.AccessDeniedException;


public class MyFileFound extends SimpleFileVisitor<Path>{
  private static Path pathSearch = Paths.get("MySendMail.java");
  private static ArrayList<File> fileMas = new ArrayList<File>();
  private static File fileForContact;
  
  public ArrayList<File> getFileMas(){
     return fileMas;
  }
  
  public FileVisitResult visitFile(Path path, BasicFileAttributes attributs) throws IOException{
    if (!path.toFile().isDirectory()){  
	 System.out.println("ALL file:" + path.getFileName()); 	
	
	if (pathSearch.getFileName().equals(path.getFileName())){
	   System.out.println("ALL path:\n" + path.toFile().getCanonicalPath()); 	
	   fileMas.add(path.toFile()); 
	}
 }
	return FileVisitResult.CONTINUE;
  }
  
   
  
  public static void searchFile(String str){
     Path dir = Paths.get(str);
     System.out.println("Start " + dir + "\n");
    
     try{
         Files.walkFileTree(dir, new MyFileFound());	 
     }catch (AccessDeniedException e){
         System.out.println("ERROR\n No ACCESS");		 
     } 
      catch (IOException e){
         System.out.println("ERROR");
		  e.printStackTrace();
     }
  }
  
  
   public static File fileForContactReturn(){
      try {
	    fileForContact = fileMas.get(0);
       for (int i = 1; i < fileMas.size(); i++){  
		  if (fileMas.get(1) == null) break;
		  if (fileForContact.lastModified() < fileMas.get(i).lastModified()){
		     fileForContact = fileMas.get(i);
		  }
		}  			
	} catch (Exception e) {
	  e.printStackTrace();
	}
	
	return  fileForContact;
  }
}