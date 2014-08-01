package com.intuit;

import com.intuit.ctof.trackMyExpense.provider.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 5/21/14
 * Time: 9:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    public WebResource getResource(){
        ClientConfig cc = new DefaultClientConfig();
        cc.getClasses().add(JacksonJsonProvider.class);
        Client client = Client.create(cc);
        return  client.resource("http://pppdipcal1tq:8080");
    }

    @org.testng.annotations.Test
    public void createDocumentWithSource(){

    }




}
