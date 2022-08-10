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
        test.setFirstname(jsonObject.getString("firstname"));
        test.setLastname(jsonObject.getString("lastname"));
        test.setAge(jsonObject.getInt("age"));

        //reading inner object from json object
        JsonObject nestedAddressObject=jsonObject.getJsonObject("address");
        address=new Address();
        address.setStreetaddress(nestedAddressObject.getString("streetaddress"));
        address.setCity(nestedAddressObject.getString("city"));
        address.setState(nestedAddressObject.getString("state"));
        address.setPostalcode(nestedAddressObject.getString("postalcode"));
        test.setAddress(address);

        //reading arrays from json
        JsonArray array=jsonObject.getJsonArray("companylist");
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
    public static void readJSON() throws IOException {

        test=getData();
        System.out.println(test);
    }

    @Test
    public static void writeJsonWithGson() throws IOException {

        test=getData();
        file.write(String.valueOf(new Gson().toJson(test)));
        file.close();
    }

    public static void main(String[] args) throws IOException {
        readJSON();
        writeJsonWithGson();

    }

}
