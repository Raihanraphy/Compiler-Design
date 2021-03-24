


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Raphy
 */
public class Specifier {
    public static void main(String args[]) throws FileNotFoundException  {
    
    ArrayList<String> mainlist = new ArrayList<String>();
    Scanner temporary_input = new Scanner(new FileReader("keyword.txt"));
    while(temporary_input.hasNext()){
      mainlist.add(temporary_input.next());
    }
                                    
                                    
    Scanner input = new Scanner(new FileReader("input.txt"));
    
    ArrayList<String> keyword;
      keyword = new ArrayList<String>();
    ArrayList<String> identifiers; 
          identifiers  = new ArrayList<String>();
    ArrayList<String> math;
      math = new ArrayList<String>();
    ArrayList<String> logical;
      logical = new ArrayList<String>();
    ArrayList<String> bol;
      bol = new ArrayList<String>();
    ArrayList<String> number;
      number = new ArrayList<String>();
    ArrayList<String> other;
      other = new ArrayList<String>();
    
    while(input.hasNext()) {
      String temp = input.next();
      if(temp.equals("==")||temp.equals(">")||temp.equals(">=")||temp.equals("<")||temp.equals("<=")||temp.equals("!=")) {
        if(!logical.equals(temp))
          logical.add(temp);  
      }
      
      else if(temp.equals("true")||temp.equals("false")) {
        if(!bol.equals(temp))
          bol.add(temp);
      }
      else if(mainlist.contains(temp)) {
        if(!keyword.contains(temp))
          keyword.add(temp);
      }
      else if(temp.equals("+")||temp.equals("-")||temp.equals("=")) {
        if(!math.contains(temp))
          math.add(temp);
      }
      
      else if(((int)temp.charAt(0)>=65&&(int)temp.charAt(0)<=90)||((int)temp.charAt(0)>=97&&(int)temp.charAt(0)<=122)) {
        boolean flag=false;
        for(int i=0;i<temp.length();i++){
          if((((int)temp.charAt(i)>=65&&(int)temp.charAt(i)<=90)||((int)temp.charAt(i)>=97&&(int)temp.charAt(i)<=122) || ((int)temp.charAt(i)>=48&&(int)temp.charAt(i)<=57))==false){
            flag=true;
            break;
          }
        }
        if(!identifiers.contains(temp) && flag==false)
          identifiers.add(temp);
        
      }
      else if((int)temp.charAt(0)>=48 && (int)temp.charAt(0)<=57) {
        boolean flag=false;
        int c=0;
        for(int i=0;i<temp.length();i++){
          if((((int)temp.charAt(i)>=48&&(int)temp.charAt(i)<=57)==false)&&temp.charAt(i)!='.'){
            if(temp.charAt(i)=='.'){
              c++;
            }
            flag=true;
            break;
          }
        }
        if(!identifiers.contains(temp) && flag==false && c<=1)
          number.add(temp);
      }
      else {
        if(!other.contains(temp))
          other.add(temp);
      }
      
    }
    
    System.out.print("Key words : ");
    for(int i=0;i<keyword.size();i++) {
      System.out.print(keyword.get(i)+" ");
    }
    
    System.out.println();
    
    System.out.print("Math Operators : ");
    for(int i=0;i<math.size();i++) {
      System.out.print(math.get(i)+" ");
    }
    
    System.out.println();
    System.out.print("Identifiers : ");
    for(int i=0;i<identifiers.size();i++) {
      System.out.print(identifiers.get(i)+" ");
    }
    
    System.out.println();
    System.out.print("Logical Operators : ");
    for(int i=0;i<logical.size();i++) {
      System.out.print(logical.get(i)+" ");
    }
    
    System.out.println();
    System.out.print("Numerical Values : ");
    for(int i=0;i<number.size();i++) {
      System.out.print(number.get(i)+" ");
    }
    
    System.out.println();
    System.out.print("Others : ");
    for(int i=0;i<other.size();i++) {
      System.out.print(other.get(i)+" ");
    }
  }
  
}
