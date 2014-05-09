package eventoris;

import java.io.ObjectInputStream.GetField;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import eventoris.dao.EventJDBCTemplate;
import eventoris.datatypes.*;

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
        /*
        event.setAddress("Bd. Moscovei");
        event.setOwnerID(2);
        event.setCategoryID(3);
        event.setDateCreated(formatedDate.format(tempDate)); // date format?
        event.setDateOfEvent("2014-12-25 14:00:00"); //date format?
        event.setDescription("Umarm Menschen!!!");
        event.setTitle("Free hugs!");
        */
        
        //---------------------------Insert-----------------------------//
       /* eventJdbcTemplate.create(event);*/
        
        //--------------------- LISTING ALL EVENTS ---------------------//
        /*List<EventInfo> events = eventJdbcTemplate.getAll();
        
        for(EventInfo record:events){
        	System.out.println(record);
        }
        */
        
        //--------------------- SELECT ONE EVENT -----------------------//        
        /*event = eventJdbcTemplate.getEvent(2);
        
			System.out.println(event);
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
        /*eventJdbcTemplate.delete(3);*/
        
        //-------------------SELELECT LAST 3 EVENTS---------------------//
       /* int EVENTS_COUNT = 3;
        List<EventInfo> events = eventJdbcTemplate.getLastEventsByDate(EVENTS_COUNT);
        for(EventInfo record:events){
        	System.out.println(record);
        }
        */
        
        //-------------------SELECT CATEGORY BY ID---------------------//
        /*int categoryID = 3;
        CategoryInfo category = new CategoryInfo();
        category = eventJdbcTemplate.getCategory(categoryID);
        System.out.println(category);*/
        
        //-------------------SELELECT TOP 3 EVENTS---------------------//
        int EVENTS_COUNT = 3;
        List<EventInfo> events = eventJdbcTemplate.getTopEvents(EVENTS_COUNT);
        for(EventInfo record:events){
        	System.out.println(record);
        }
    }
}
