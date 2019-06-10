package com.techouts.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.techouts.hibernate.pojo.ChequePayment;
import com.techouts.hibernate.pojo.CreditCard;

public class Main 
{
    public static void main( String[] args )
    {

    	Configuration config=new Configuration().configure("hibernate.cfg.xml");
		SessionFactory fact=config.buildSessionFactory();
		Session session=fact.openSession(); 
		Transaction tx=session.beginTransaction();
		
		CreditCard cc=new CreditCard();
		cc.setPayId(1);
		cc.setAmount(2000);
		cc.setCardType("VISA");
		
		
		ChequePayment cp=new ChequePayment();
		cp.setPayId(2);
		cp.setAmount(3000);
		cp.setChequetype("CHEQUE");
		
		
		CreditCard cc1=new CreditCard();
		cc1.setPayId(3);
		cc1.setAmount(4000);
		cc1.setCardType("MASTER");
		
		session.save(cc);
		session.save(cp);
		session.save(cc1);
		

		tx.commit();
		session.close();
    }
}
