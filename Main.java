import java.io.*;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Main
{
    public static void main(String[] args)
    {
// This audio file has metadata embedded in XMP (Extensible Metadata Platform) standard
// created by Adobe Systems Inc. XMP standardizes the definition, creation, and
// processing of extensible metadata.

        String audioFileLoc = "C:\\Pop\\BackstreetBoys_ShowMeTheMeaningOfBeingLonely.mp3";

        try
        {

            InputStream input = new FileInputStream(new File(audioFileLoc));
            ContentHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new Mp3Parser();
            ParseContext parseCtx = new ParseContext();
            parser.parse(input, handler, metadata, parseCtx);
            input.close();

// List all metadata
            String[] metadataNames = metadata.names();

            for(String name : metadataNames){
                System.out.println(name + ": " + metadata.get(name));
            }
    }
    catch (FileNotFoundException e)
    {
        e.printStackTrace();
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
    catch (SAXException e)
    {
        e.printStackTrace();
    }
    catch (TikaException e)
    {
    e.printStackTrace();
    }
}
