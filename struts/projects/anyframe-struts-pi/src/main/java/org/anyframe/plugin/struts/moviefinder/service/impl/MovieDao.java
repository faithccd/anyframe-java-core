/*
 * Copyright 2008-2012 the original author or authors.
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
package org.anyframe.plugin.struts.moviefinder.service.impl;

import javax.inject.Inject;

import org.anyframe.pagination.Page;
import org.anyframe.plugin.struts.domain.Movie;
import org.anyframe.query.QueryService;
import org.anyframe.query.dao.AbstractDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * This MovieDao class is a DAO class to provide movie crud functionality.
 * 
 * @author Hyunjung Jeong
 */
@Repository("strutsMovieDao")
public class MovieDao extends AbstractDao {
	@Value("#{contextProperties['pageSize'] ?: 10}")
	int pageSize;

	@Value("#{contextProperties['pageUnit'] ?: 10}")
	int pageUnit;

	@Inject
	public void setQueryService(QueryService queryService) {
		super.setQueryService(queryService);
	}

	public void create(Movie movie) throws Exception {
		movie.setMovieId("MV-" + System.currentTimeMillis());
		create("StrutsMovie", movie);
	}

	public void remove(String movieId) throws Exception {
		Movie movie = new Movie();
		movie.setMovieId(movieId);
		remove("StrutsMovie", movie);
	}

	public void update(Movie movie) throws Exception {
		update("StrutsMovie", movie);
	}

	public Movie get(String movieId) throws Exception {
		Movie movie = new Movie();
		movie.setMovieId(movieId);
		return (Movie) findByPk("StrutsMovie", movie);
	}

	public Page getPagingList(Movie movie, int pageIndex) throws Exception {
		return this.findListWithPaging("StrutsMovie", movie, pageIndex, pageSize,
				pageUnit);
	}
}