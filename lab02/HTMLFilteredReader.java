import cs1.SimpleURLReader;

/**
 * HTMLFilteredReader class that extends MySimpleURLReader class
 * @author Egemen Öztürk
 * @version 22.10.2020
 */
public class HTMLFilteredReader extends MySimpleURLReader
{
   // properties
   
   // constructors
   public HTMLFilteredReader( String url)
   {
      super( url);
   }
   
   /**
    * This method returns only the text after removing the html
    * @return theContent
    */
   public String getPageContents() {
      
      String content, theContent;
      int index;
      
      content = super.getPageContents();
      theContent = "";
      index = 0;
      
      while ( index < content.length() ) {
         while( content.charAt( index) == '<' || content.charAt(index) == '&' ) {
            
            if( content.charAt( index) == '<' && content.substring( index, index + 3 ) == "Cap" && content.substring(index,index + 3 ) == "Pop" && content.substring(index,index + 4 ) == "Area" ) {
               
               do {
                  index++;
                  
               } while( content.charAt( index) != '>' );
            }
            
            else if( content.charAt( index) == '&' ) {
               
               do {
                  index++;
                  
               } while( content.charAt( index) != ';' );
            }
            
            index++;
         }
         
         theContent = theContent + content.charAt( index);
         index++;
      }
      
      return theContent;
   }
   public void wordSearch( String word) {
     
     String content;
      int counter;
      
      content = super.getPageContents();
      counter = 0;
      
      for ( int i = 0; i < content.length(); i++ ) {
         
         if ( word.substring( 0, 1 ).equals( content.substring( i, i + 1 ) ) ) {
            if ( content.substring( i , i + word.length() ).equals( word) ) {
               
               System.out.println( word + " was found in the index " + i + "-" + ( i + word.length() - 1 ) );
               counter++;
            }            
         }
         
         
      }
     
      if ( counter == 0 ) {
            System.out.println( "This word does not occur in the given content");  
         }
         else {
            System.out.println( word + " was found " + counter + " times in the given content ");
         }
   }
}