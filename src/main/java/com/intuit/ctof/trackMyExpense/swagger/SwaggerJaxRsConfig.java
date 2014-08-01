package com.intuit.ctof.trackMyExpense.swagger;

import com.wordnik.swagger.converter.ModelConverters;
import com.wordnik.swagger.converter.OverrideConverter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created with IntelliJ IDEA.
 * User: sn1
 * Date: 4/15/14
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class SwaggerJaxRsConfig extends HttpServlet {
    static {
        new DateSerializer();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}

class DateSerializer {
    public DateSerializer() {


        String jsonString = "\n" +
                "{\n" +
                "  \"id\": \"Date\",\n" +
                "  \"properties\": { " +
                "  \"value\": { " +
                "      \"description\": \"Date in milliseconds since epoch\",\n" +
                "      \"notes\": \"Add any notes you like here\",\n" +
                "      \"type\": \"string\"\n" +
                "    }\n" +
                "   }" +
                "}\n";
        try {
            OverrideConverter converter = new OverrideConverter();
            converter.add("java.util.Date", jsonString);
            ModelConverters.addConverter(converter, true);
        } catch (Exception e) {
        }
    }
}
