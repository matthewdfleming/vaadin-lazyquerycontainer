/**
 * Copyright 2010 Tommi S.E. Laukkanen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.vaadin.addons.lazyquerycontainer;

import java.io.Serializable;

/**
 * Query factory to be used with EntityQuery.
 * @author Tommi Laukkanen
 */
public final class EntityQueryFactory implements QueryFactory, Serializable {
    /** Java serialization version UID. */
    private static final long serialVersionUID = 1L;
    /** The query definition. */
    private EntityQueryDefinition entityQueryDefinition;

    /**
     * Gets the definition of properties to be queried.
     * @param queryDefinition The query definition.
     */
    @Override
    public void setQueryDefinition(final QueryDefinition queryDefinition) {
        entityQueryDefinition = (EntityQueryDefinition) queryDefinition;
    }

    /**
     * Constructs a new query according to the given sort state.
     * @param sortPropertyIds Properties participating in the sorting.
     * @param sortStates List of sort order for the properties. True corresponds
     *            ascending and false descending.
     * @return A new query constructed according to the given sort state.
     */
    @Override
    public Query constructQuery(final Object[] sortPropertyIds, final boolean[] sortStates) {
        entityQueryDefinition.setSortState(sortPropertyIds, sortStates);
        return new EntityQuery(entityQueryDefinition);
    }

}
