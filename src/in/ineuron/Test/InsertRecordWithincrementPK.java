package in.ineuron.Test;
import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.model.ProgrammerProjId;
import in.ineuron.model.ProgrammerProjInfo;
import in.ineuron.util.HibernateUtil;


public class InsertRecordWithincrementPK {

	public static void main(String[] args) {
		
		Session session = null; 
		Transaction transaction = null;
		boolean flag = false;
		ProgrammerProjId pk = null;
		
		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {
				 transaction = session.beginTransaction();
			}
			
			if(transaction != null) {
				
				ProgrammerProjId projId = new ProgrammerProjId();
				projId.setPid(101);
				projId.setProjId(504);
				
				ProgrammerProjInfo info = new ProgrammerProjInfo();
				info.setId(projId);
				info.setPname("Ritankar");
				info.setDeptNo(12);
				info.setProjName("Health & Safety");
				
				pk = (ProgrammerProjId) session.save(info);
				flag = true;
			}
			
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			if(flag) {
				transaction.commit();
				System.out.println("Object updated to the database with the PK ID:: " + pk);
			}
			else {
				transaction.rollback();
				System.out.println("Object failed to update...");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
