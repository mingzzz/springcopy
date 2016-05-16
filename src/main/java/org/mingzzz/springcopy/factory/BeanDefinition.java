package org.mingzzz.springcopy.factory;

/**
 * ��xml�����õ�bean��Ϣ�������װ��������У�����ע���ʱ�����ݸ������ע��
 * @author Avalon
 */
public class BeanDefinition {
	
	private String single;
	private String prototype;
	private String id;
	private String beanClass;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getBeanClass() {
		return beanClass;
	}
	
	public void setBeanClass(String beanClass) {
		this.beanClass = beanClass;
	}

	public String getSingle() {
		return single;
	}

	public void setSingle(String single) {
		this.single = single;
	}

	public String getPrototype() {
		return prototype;
	}

	public void setPrototype(String prototype) {
		this.prototype = prototype;
	}
}
