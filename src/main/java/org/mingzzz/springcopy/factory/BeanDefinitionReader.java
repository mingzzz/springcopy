package org.mingzzz.springcopy.factory;

public interface BeanDefinitionReader {
	// 根据路径获取传入资源文件
	public int loadBeanDefinition(String path);
}
