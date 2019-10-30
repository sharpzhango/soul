/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * Contributor license agreements.See the NOTICE file distributed with
 * This work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * he License.You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.dromara.soul.dashboard.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.dromara.soul.dashboard.entity.AppAuthDO;
import org.dromara.soul.dashboard.query.AppAuthQuery;

import java.util.List;

/**
 * AppAuthMapper.
 *
 * @author xiaoyu(Myth)
 */
@Mapper
public interface AppAuthMapper {


    /**
     * insert application authority.
     *
     * @param appAuthDO {@linkplain AppAuthDO}
     * @return rows int
     */
    int insert(AppAuthDO appAuthDO);

    /**
     * update application authority.
     *
     * @param appAuthDO {@linkplain AppAuthDO}
     * @return rows int
     */
    int update(AppAuthDO appAuthDO);

    /**
     * select application authority by id.
     *
     * @param id pk.
     * @return {@linkplain AppAuthDO}
     */
    AppAuthDO findById(String id);

    /**
     * select application authority by query.
     *
     * @param appAuthQuery {@linkplain AppAuthQuery}
     * @return {@linkplain List}
     */
    List<AppAuthDO> findListByQuery(AppAuthQuery appAuthQuery);

    /**
     * select all {@linkplain AppAuthDO}
     *
     * @return {@linkplain List}
     */
    List<AppAuthDO> selectAll();

    /**
     * count application authority by query.
     *
     * @param appAuthQuery {@linkplain AppAuthQuery}
     * @return {@linkplain Integer}
     */
    Integer countByQuery(AppAuthQuery appAuthQuery);

    /**
     * delete application authority.
     *
     * @param ids primary key list.
     * @return rows int
     */
    int batchDelete(@Param("ids") List<String> ids);

    /**
     * Batch enable int.
     *
     * @param ids    the ids
     * @param enabled the enabled
     * @return the int
     */
    int batchEnable(@Param("ids") List<String> ids, @Param("enabled") Boolean enabled);
}