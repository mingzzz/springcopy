package org.mingzzz.spring.io;

import java.io.IOException;
import java.io.InputStream;

public interface Resource {
	//�ļ��Ƿ����
	public boolean isExist();
	
	//�ļ�����·��
	public String getAbsolutely();
	
	//��ȡ������
	public InputStream getInputStream() throws IOException;
}
