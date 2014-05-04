package eventoris;

import java.io.ObjectInputStream.GetField;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import eventoris.dao.EventJDBCTemplate;
import eventoris.datatypes.EventInfo;

public class App 
{
	public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        
        EventJDBCTemplate eventJdbcTemplate = (EventJDBCTemplate)context.getBean("eventJDBCTemplate");
        EventInfo event = new EventInfo();
        Date tempDate = new Date();
        SimpleDateFormat formatedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        //--------------------- SET OBJECT ATRIBUTES --------------------//
        
        event.setAddress("Bubuieci");
        event.setOwnerID(12);
        event.setCategoryID(1);
        event.setDateCreated(formatedDate.format(tempDate)); // date format?
        event.setDateOfEvent(formatedDate.format(tempDate)); //date format?
        event.setDescription("Teambuilding");
        event.setTitle("PaintBall");
        
        
        //---------------------------Insert-----------------------------//
        eventJdbcTemplate.create(event);
        
        //--------------------- LISTING ALL EVENTS ---------------------//
        /*List<EventInfo> events = eventJdbcTemplate.getAll();
        
        for(EventInfo record:events){
        	System.out.println("Id: " + record.getEventID());
        	System.out.println("Title: " + record.getTitle());
        	System.out.println("Category ID: " + record.getCategoryID());
        	System.out.println("Description: " + record.getDescription());
        	System.out.println("Date created: " + record.getDateCreated());
        	System.out.println("Date of event: " + record.getDateOfEvent());
        	System.out.println("Address: " + record.getAddress());
        	System.out.println("Author ID: " + record.getAuthorID());
        }
        */
        
        //--------------------- SELECT ONE EVENT -----------------------//        
        /*event = eventJdbcTemplate.getEvent(2);
        
        System.out.println("Id: " + event.getEventID());
    	System.out.println("Title: " + event.getTitle());
    	System.out.println("Category ID: " + event.getCategoryID());
    	System.out.println("Description: " + event.getDescription());
    	System.out.println("Date created: " + event.getDateCreated());
    	System.out.println("Date of event: " + event.getDateOfEvent());
    	System.out.println("Address: " + event.getAddress());
    	System.out.println("Author ID: " + event.getAuthorID());
    	*/
        
        //--------------------- UPDATE OF EVENT ------------------------//
        /*event.setEventID(2);
        event.setAddress("Petricani 12");
        event.setAuthorID(12);
        event.setCategoryID(3);
        event.setDateCreated(formatedDate.format(tempDate)); // date format?
        event.setDateOfEvent(formatedDate.format(tempDate)); //date format?
        event.setDescription("Joaca la aer curat");
        event.setTitle("Basketball");
        
        eventJdbcTemplate.update(event);\
        */
        
        //------------------------ DELETE EVENT ------------------------//
        //eventJdbcTemplate.delete(2);
    }
}
