// Generated by the WebObjects Wizard Sun Mar 21 11:15:00 US/Central 1999
package er.reporting.examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSData;

public class Menu extends WOComponent {

    public Menu(WOContext c){
        super(c);
    }

    protected String excelSheetLocation;

    public WOComponent gotoGroupByPage() {
	Target p = (Target)pageWithName("Target") /* JC_WARNING - Please check: since WO4.5, using pageWithName on the application or session instance requires two parameters (the name of the page and a WOContext). If this pageWithName is in a component or direct action instance, it is valid as is. */;
	p. topPageName = "GroupByPageDoc";
	p.bottomPageName = "GroupByPage";
        return p;
    }

    public WOComponent gotoQuickReportTest() {
	Target p = (Target)pageWithName("Target") /* JC_WARNING - Please check: since WO4.5, using pageWithName on the application or session instance requires two parameters (the name of the page and a WOContext). If this pageWithName is in a component or direct action instance, it is valid as is. */;
	p. topPageName = "QuickReportTestDoc";
	p.bottomPageName = "QuickReportTest";
        return p;
    }

    public WOComponent gotoCustomPresoTest() {
	Target p = (Target)pageWithName("Target") /* JC_WARNING - Please check: since WO4.5, using pageWithName on the application or session instance requires two parameters (the name of the page and a WOContext). If this pageWithName is in a component or direct action instance, it is valid as is. */;
	p. topPageName = "GroupingOnlyDoc";
	p.bottomPageName = "GroupingOnly";
        return p;
    }

    public NSData dataFromFile(File f) throws IOException {
        if (f==null)
            throw new IOException("null file");
        int size=(int) f.length();
        FileInputStream fis=new FileInputStream(f);
        byte [] data = new byte[size];
        int bytesRead=0;
        while (bytesRead<size)
            bytesRead+=fis.read(data,bytesRead,size-bytesRead);
        fis.close();
        return new NSData(data);
    }
 
    public NSData excelSheetLocation() throws IOException {
        String path = application().resourceManager().pathForResourceNamed("DynaReporter.ppt", null, null);
	//System.out.println("excelSheetLocation: path:"+path);
        File file = new File(path);
        NSData data = dataFromFile (file);
	//System.out.println("excelSheetLocation: data:"+ data);
	return data;
    }

}
