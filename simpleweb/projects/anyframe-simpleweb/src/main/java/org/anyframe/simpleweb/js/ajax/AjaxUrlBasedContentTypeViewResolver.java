/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.anyframe.simpleweb.js.ajax;

import java.util.Locale;

import org.springframework.js.ajax.AjaxUrlBasedViewResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractView;

/**
 * 
 * @author Sooyeon Park
 *
 */
public class AjaxUrlBasedContentTypeViewResolver extends
		AjaxUrlBasedViewResolver {

	/**
	 * Overridden to implement check for "redirect:" prefix.
	 * <p>
	 * Redirect requires special behavior on an Ajax request.
	 */
	protected View createView(String viewName, Locale locale) throws Exception {
		View view = super.createView(viewName, locale);
		
		String contentType = getContentType();
		if (view != null && contentType != null) {
			((AbstractView)view).setContentType(contentType);
		}
		
		return view;
	}
}