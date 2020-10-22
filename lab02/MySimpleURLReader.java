import cs1.SimpleURLReader;

/**
 * MySimpleURLReader class that extends the SimpleURLReader class
 * @author Egemen Öztürk
 * @version 22.10.2020
 */
public class MySimpleURLReader extends SimpleURLReader
{
  // properties
  private String url;
  
  // constructors
  public MySimpleURLReader( String url)
  {
    super( url);
    this.url = url;
  }
  
  // methods
  
  /**
   * URL Getter Method
   * @return url
   */
  public String getURL()
  {
    return url;
  }
  
  /**
   * 
   * Name Getter Method
   * @return filename part of the url
   */
  public String getName()
  {
    return url.substring( url.lastIndexOf('/') + 1, url.length());
  }
  
  public int getNumberOfCSSLinks() {
    
    String text = getPageContents();
    String string1 = "";
    String string2 = "";
    boolean check = true;
    int counter = 0;
    
    for ( int i = 0 ; i < text.length(); i++) {
      if ( text.charAt(i) == '<')
        
        check = true; 
      
      if ( check ) 
        string1 += text.charAt(i);
      
      if ( text.charAt(i) == '>' )
        
        check = false;
      
    }
    
    check = true;
    
    for ( int j = 0 ; j <= string1.length(); j++ ) {
      
      if ( string2.equals(".css")) {
        
        counter++;
      }
      if ( j == string1.length() - 4 ) {
        
        check = false ;
      }
      if ( check ) {
        
        string2 = string1.substring( j , j + 4 );
      }
      
      
    }
    return counter;
  }
  
  /**
   * This method fixes the "null" bug of the SimpleURLReader's getPageContents()
   * @return page content without "null"
   */
  public String getPageContents() {
    
    String content = super.getPageContents();
    
    if ( content.substring( 0, 3 ) == ( "null") ) {
      
      content = content.substring( 4);
    }
    
    return content;
  }
}