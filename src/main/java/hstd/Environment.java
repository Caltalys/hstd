package hstd;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionOperations;
import org.springframework.transaction.support.TransactionTemplate;

public class Environment {

	static Environment env;
	
	EntityManager em;
	
	public PlatformTransactionManager transactionManager;
	
	protected Environment(){
		super();
		env = this;
	}
	
	public Environment(EntityManager em_, PlatformTransactionManager transactionManager_){
		this();
		em = em_;
		transactionManager = transactionManager_;
	}
	
	@Value("${conf.defaultpagesize:10}")
	int defaultPageSize;

	@Value("${conf.defcacheable:true}")
	public boolean defCacheable;

	@Value("${conf.defnotifyposition:top_center}")
	public String defNotifyPos = "";

	@Value("${conf.defnotifyduration:5000}")
	public int defNotifyTime;

	@Value("${conf.pagesizename:pagesize}")
	String pageSizeName = "";

	@Value("${conf.idname:id}")
	String idName = "";

	@Value("${conf.idfield:id}")
	String idField = "";

	@Value("${conf.idfield:ma}")
	String maField = "";

	@Value("${conf.pageName:page}")
	String pageName = "";
	
	public int defaultPageSize() {
		return defaultPageSize;
	}
	
	public EntityManager em() {
		return em;
	}
	
	public TransactionTemplate transactioner(){
		return new TransactionTemplate(transactionManager);
	}
	
	public Session session(){
		return (Session) em().getDelegate();
	}
	
	public TransactionOperations transactionero() {
		TransactionTemplate result = transactioner();
		result.setReadOnly(true);
		return result;
	}
	
	
}
