package com.codecity.web.model.nodes;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.support.index.IndexType;

@NodeEntity
public class User {

    @GraphId
    Long id;

    @Indexed(indexType = IndexType.FULLTEXT, indexName = "search")
    String title;

}
