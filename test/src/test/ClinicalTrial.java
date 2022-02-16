package test;
import java.io.File;import java.sql.Connection;import java.sql.DriverManager;import java.util.Vector;import javax.crypto.spec.PBEParameterSpec;
public class ClinicalTrial {
	public String[] getPatients(String s){
        String[] patientList = {new String("p1"),"p2","p3"};
        String str="object.obj ";
        String str1=s;
        s.trim();
        if(str!=s&&s!=null) {
            str=str1.trim();
        }
        int[] a = new int[10];
        int[] b = new int[10];
        for (int i=0;i<10;i++) {
            b[i]=a[i];
        }
        Vector<String> vector=new Vector<>();
        vector.add(s);
        Connection conn=null;
        byte[] salt = "notrandom".getBytes();
        PBEParameterSpec cipherSpec = new PBEParameterSpec(salt, 10000);
        vector.set(cipherSpec.getIterationCount(), str1);
        try{
            File file = new File("object.obj");
            file = File.createTempFile("", ".");
            if(file.delete()) {
                file.mkdir();
            }
            conn = DriverManager.getConnection("jdbc:derby:memory:myDB;create=true", "login", "");
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            return patientList;
        }
    }
	public static void main(String[] args) {
		
	}
}
