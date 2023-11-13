package in.ineuron.Test;
import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.model.ProgrammerProjId;
import in.ineuron.model.ProgrammerProjInfo;
import in.ineuron.util.HibernateUtil;


public class SelectRecordApp {

	public static void main(String[] args) {
		
		Session session = null; 

		
		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {
				ProgrammerProjId id = new ProgrammerProjId();
				id.setPid(107);
				id.setProjId(501);
				
				ProgrammerProjInfo info = session.get(ProgrammerProjInfo.class, id);
				
				if(info != null) {
					System.out.println(info);
				}
				else {
					System.out.println("Record Not Available for:: " + id);
				}
			}
			
			
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
