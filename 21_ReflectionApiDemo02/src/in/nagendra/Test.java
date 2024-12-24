package in.nagendra;

import java.lang.reflect.Field;

public class Test {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		
		Class<?> forName = Class.forName("in.nagendra.Employee");
		
		Field field = forName.getDeclaredField("id");
		
        field.setAccessible(true);
        
        Object object = forName.newInstance();
        
        Employee e = (Employee)object;
        
        field.set(object, 19387);
        
        e.getId();
        
        }

}
