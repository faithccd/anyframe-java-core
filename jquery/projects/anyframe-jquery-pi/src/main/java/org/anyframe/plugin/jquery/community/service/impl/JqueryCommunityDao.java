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
package org.anyframe.plugin.jquery.community.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.anyframe.pagination.Page;
import org.anyframe.plugin.jquery.domain.JqueryCommunity;
import org.anyframe.query.QueryService;
import org.anyframe.query.dao.QueryServiceDaoSupport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * This class is a DAO class to provide community crud functionality.
 * 
 * @author Sujeong Lee
 *
 */
@Repository("jqueryCommunityDao")
public class JqueryCommunityDao extends QueryServiceDaoSupport {

	@Value("#{contextProperties['pageSize'] ?: 10}")
	int pageSize;

	@Value("#{contextProperties['pageUnit'] ?: 10}")
	int pageUnit;
	
	@Inject
	public void setQueryService(QueryService queryService) {
		super.setQueryService(queryService);
	}

	public int create(JqueryCommunity community) throws Exception {
		return create("createJqueryCommunity", community);
	}

	public int remove(JqueryCommunity community) throws Exception {
		return remove("removeJqueryCommunity", community);
	}

	public int update(JqueryCommunity community) throws Exception {
		return update("updateJqueryCommunity", community);
	}
	
	public int updateCell(JqueryCommunity community) throws Exception {
		return update("updateJqueryCommunityCell", community);
	}

	public JqueryCommunity get(JqueryCommunity community) throws Exception {
		return (JqueryCommunity) findByPk("findJqueryCommunityByPk", community);
	}
	
	public Page getPagingList(JqueryCommunity community, int pageIndex) throws Exception{
		return (Page) findListWithPaging("findJqueryCommunityList", community, pageIndex, pageSize, pageUnit);
	}

	@SuppressWarnings("unchecked")
	public List<JqueryCommunity> getList(JqueryCommunity community) throws Exception{
		return (List<JqueryCommunity>)findList("findJqueryCommunityList", community);
	}
}