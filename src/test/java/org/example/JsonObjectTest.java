package org.example;

import com.google.gson.Gson;
import org.testng.annotations.Test;
import javax.json.*;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class JsonObjectTest {
    static PojoJSONTest test;
    static FileInputStream fis;
    static JsonReader reader;
    static JsonObject  jsonObject;
    static final String path=System.getProperty("user.dir").concat("\\src\\main\\resources\\sampleJSON.json");
    static final FileWriter file;
    static {
        try {
            file = new FileWriter(System.getProperty("user.dir").concat("\\src\\main\\resources\\sampleJSONOutput.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static Address address;
    static String firstname=jsonObject.getString("firstname");
    static String lastname=jsonObject.getString("lastname");
    static int age=jsonObject.getInt("age");
    static JsonObject nestedAddressObject=jsonObject.getJsonObject("address");
    static String streetaddress=nestedAddressObject.getString("streetaddress");
    static String city=nestedAddressObject.getString("city");
    static String state=nestedAddressObject.getString("state");
    static String postalcode=nestedAddressObject.getString("postalcode");
    static JsonArray array=jsonObject.getJsonArray("companylist");
    @Test
    public static PojoJSONTest getData() throws IOException {
        fis=new FileInputStream(path);
        reader= Json.createReader(fis);
        jsonObject= reader.readObject();

        //we can close IO resource and JsonReader now
        reader.close();
        fis.close();

        //Retrieve data from JsonObject and create pojo object
        test=new PojoJSONTest();
        test.setFirstname(firstname);
        test.setLastname(lastname);
        test.setAge(age);

        //reading inner object from json object
        address=new Address();
        address.setStreetaddress(streetaddress);
        address.setCity(city);
        address.setState(state);
        address.setPostalcode(postalcode);
        test.setAddress(address);

        //reading arrays from json
        String[] companylist=new String[array.size()];
        int i=0;
        for(JsonValue value:array)
        {
            companylist[i++]=value.toString();
        }
        test.setCompanylist(companylist);
        return test;
    }

    @Test
    public void readJSON() throws IOException {

        test=getData();
        System.out.println(test);
    }

    @Test
    public void writeJsonWithGson() throws IOException {

        test=getData();
        file.write(String.valueOf(new Gson().toJson(test)));
        file.close();
    }

}
