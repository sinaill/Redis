package util;

import java.io.ByteArrayInputStream;  
import java.io.ByteArrayOutputStream;  
import java.io.IOException;  
import java.io.ObjectInputStream;  
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;  
public class SerializeUtils {  
public static byte[] serialize(Object obj){  
byte[] bytes = null;  
try {  
ByteArrayOutputStream baos=new ByteArrayOutputStream();;  
ObjectOutputStream oos=new ObjectOutputStream(baos);  
oos.writeObject(obj);  
bytes=baos.toByteArray();  
baos.close();  
oos.close();  
} catch (IOException e) {  
e.printStackTrace();  
}  
return bytes;  
}  
public static Object deSerialize(byte[] bytes){  
Object obj=null;  
try {  
ByteArrayInputStream bais=new ByteArrayInputStream(bytes);  
ObjectInputStream ois=new ObjectInputStream(bais);  
obj=ois.readObject();  
} catch (Exception e) {  
e.printStackTrace();  
}  
return obj;  
} 

/** 
 * 序列化 list 集合 
 *  
 * @param list 
 * @return 
 */  
public static byte[] serializeList(List<?> list) {  

    if (list.isEmpty()) {  
        return null;  
    }  
    ObjectOutputStream oos = null;  
    ByteArrayOutputStream baos = null;  
    byte[] bytes = null;  
    try {  
        baos = new ByteArrayOutputStream();  
        oos = new ObjectOutputStream(baos);  
        for (Object obj : list) {  
            oos.writeObject(obj);  
        }  
        bytes = baos.toByteArray();  
    } catch (Exception e) {  
        e.printStackTrace();  
    } finally {  
        try {
			oos.close();
			baos.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
    }  
    return bytes;  
}  

/** 
 * 反序列化 list 集合 
 *  
 * @param lb 
 * @return 
 */  
public static List<?> unserializeList(byte[] bytes) {  
    if (bytes == null) {  
        return null;  
    }  

    List<Object> list = new ArrayList<Object>();  
    ByteArrayInputStream bais = null;  
    ObjectInputStream ois = null;  
    try {  
        // 反序列化  
        bais = new ByteArrayInputStream(bytes);  
        ois = new ObjectInputStream(bais);  
        while (bais.available() > 0) {  
            Object obj = (Object) ois.readObject();  
            if (obj == null) {  
                break;  
            }  
            list.add(obj);  
        }  
    } catch (Exception e) {  
        e.printStackTrace();  
    } finally {  
        try {
			bais.close();
			bais.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
    }  
    return list;  
}  


}  