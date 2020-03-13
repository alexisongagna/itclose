package com.itclose.itclose.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.NoOpResponseParser;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.request.QueryRequest;

public class SolrConfig {

    private final static String SOLR_URL = "http://185.181.11.120:8983/solr/";
    private final static String SOLR_FORMAT_OUTPUT = "json";


    public static HttpSolrClient getSolrClient(String collectionName)
    {

        HttpSolrClient solr = new HttpSolrClient.Builder(SOLR_URL+collectionName).build();
        solr.setParser(new XMLResponseParser());
        return solr;
    }

    public static QueryRequest getRequest(SolrQuery query)
    {

        NoOpResponseParser rawJsonResponseParser = new NoOpResponseParser();
        rawJsonResponseParser.setWriterType(SOLR_FORMAT_OUTPUT);
        QueryRequest req = new QueryRequest(query);
        req.setResponseParser(rawJsonResponseParser);
        return req ;
    }

}
