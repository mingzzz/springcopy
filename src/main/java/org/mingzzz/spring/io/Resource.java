package org.mingzzz.spring.io;

import java.io.IOException;
import java.io.InputStream;

public interface Resource {
	//文件是否存在
	public boolean isExist();
	
	//文件绝对路径
	public String getAbsolutely();
	
	//获取输入流
	public InputStream getInputStream() throws IOException;
}
