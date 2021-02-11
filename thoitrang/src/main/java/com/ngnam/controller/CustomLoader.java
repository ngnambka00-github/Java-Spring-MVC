package com.ngnam.controller;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class CustomLoader implements ResourceLoaderAware {

	private ResourceLoader resourceLoader;
	
	public void setResourceLoader(ResourceLoader arg0) {
		resourceLoader = arg0;
	}

	public Resource getResource(String path) {
		return resourceLoader.getResource(path);
	}
}
