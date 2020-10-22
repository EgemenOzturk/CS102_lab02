import cs1.SimpleURLReader;

/**
 * A class for testing SimpleURLReader and reader classes
 * @author Egemen Öztürk
 * @version 22.10.2020
 */
public class URLTest
{
  public static void main( String[] args)
  {
    // variables
    String url;
    String url2;
    String url3;
    String url4;
    String url5;
    SimpleURLReader reader;
    MySimpleURLReader reader2;
    MySimpleURLReader reader3;
    HTMLFilteredReader reader4;
    HTMLFilteredReader reader5;
    
    // program code
    // PART A Testing SimpleURLReader class
    
    url = "http://www.cs.bilkent.edu.tr/~ozturk/cs102/housman.txt";
    reader = new SimpleURLReader( url );
    
    System.out.println( "" );
    System.out.println( "The text is" + "\n" + reader.getPageContents());
    System.out.println( "The text has " + reader.getLineCount() + " lines.");
    System.out.println( "" );
    
    //PART B Testing MySimpleURLReader class with the link
    
    url2 = "http://www.cs.bilkent.edu.tr/~ozturk/cs102/scrapethissite.html";
    reader2 = new MySimpleURLReader( url2 );
    
    System.out.println( "Link of the text is " + reader2.getURL());
    System.out.println("");
    
    //PART C Testing MySimpleURLReader and calling getNumberOfCSSLinks() method
    
    url3 = "http://www.cs.bilkent.edu.tr/~ozturk/cs102/scrapethissite.html";
    reader3 = new MySimpleURLReader( url3 );
    
    System.out.println( "The count of CSS Files in the link is " + reader3.getNumberOfCSSLinks() );
    System.out.println("");
    
    //PART D Testing HTMLFilteredReader class with the link
    
    url4 = "http://www.cs.bilkent.edu.tr/~ozturk/cs102/scrapethissite.html";    
    reader4 = new HTMLFilteredReader( url4 );
    
    System.out.println( "The filtered text is" + "\n" + reader4.getPageContents());
    //System.out.println( "The unfiltered text is" + "\n" + reader4.getUnfilteredPageContents());
    System.out.println();
    
    
    //PART E testing WordSearch Class with the link
    
    url5 = "http://www.cs.bilkent.edu.tr/~ozturk/cs102/scrapethissite.html";
    reader5 = new HTMLFilteredReader( url5 );
    reader5.wordSearch("Turkey");
    reader5.wordSearch("London");
  }
}