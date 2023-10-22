package in.smartprogramming.main;
import in.smartprogramming.beans.Student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.BeanFactory;


public class Main
{
	public static void main(String[] args) 
	{
		/* -------------- Using ApplicationContext IOC container -------------- */
		
		// To invoke injection code of ApplicationContext.xml.
		String config_location = "/in/smartprogramming/resources/ApplicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(config_location);
		
		// Access injected bean object present in spring container using unique bean id given during injection.
		Student std = (Student) context.getBean("StudentOb1");
		
		System.out.println(std);
		System.out.println(std.getId());
		System.out.println(std.getName());
		System.out.println(std.getEmail());	
		
		((ConfigurableApplicationContext)context).close();
		
		/* -------------- Using BeanFactory IOC container -------------- */
		BeanFactory factory = null;
		try
		{
			factory = new ClassPathXmlApplicationContext(config_location);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		Student s = factory.getBean("StudentOb2", Student.class); 
		System.out.println(s);
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println(s.getEmail());
		((ConfigurableApplicationContext) factory).close();
	}
}


/* Steps to close the ApplicationContext Object
	a) Type Cast the ApplicationContext Object to ConfigurableApplicationContext object.
	b) Then call the close object on that.
	i.e ((ConfigurableApplicationContext)context).close();
*/
