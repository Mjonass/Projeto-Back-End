package br.iesp.edu.api.callout;


import br.iesp.edu.api.TO.CompositeRequestTO;
import br.iesp.edu.api.TO.ResponseCompositeTO;
import com.google.gson.Gson;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Callout {
    private static final String POST_URL = "https://curious-goat-cs3atg-dev-ed.my.salesforce.com/services/apexrest/testEnviaEmail/";

    private static final String POST_COMPOSITE = "https://curious-goat-cs3atg-dev-ed.my.salesforce.com/services/data/v56.0/composite";

    private static final String TOKEN_AUTHSF = "Bearer 00D8c000004w5Xc!ARIAQHwvPPP.oVLRmIYQT39SjYvTXiLr.bnyjuF1ToAH_Sa82ePpLCDnVXMequNonMyyg6BRD1yOvFA95TovxJ74.Pa7BUSG";

    public static void main(String[] args) throws IOException {
        sendEmail("igorassisvilar@gmail.com","60");
    }
    private static String generateBody(Object obj){
       return new Gson().toJson(obj);
    }

    private static String generateBodyComposite(Object body, String method){
        CompositeRequestTO.CompositeTO compositeTO = new CompositeRequestTO.CompositeTO();
        CompositeRequestTO.CompositeAttRequestTO compositeRequestTO = new CompositeRequestTO.CompositeAttRequestTO();
        ArrayList<CompositeRequestTO.CompositeAttRequestTO> lstComposite = new ArrayList<CompositeRequestTO.CompositeAttRequestTO>();
        compositeRequestTO.url = "/services/data/v56.0/sobjects/" + body.getClass().getSimpleName() + "__c";
        compositeRequestTO.method = method;
        compositeRequestTO.body = body;
        compositeRequestTO.referenceId = "ref"+body.getClass().getSimpleName();
        lstComposite.add(compositeRequestTO);

        compositeTO.compositeRequest = lstComposite;
        return new Gson().toJson(compositeTO);

    }
    public static void sendEmail(String email,String preco) throws IOException {
        EmailTO emailTO = new EmailTO();
        emailTO.address = email;
        emailTO.ammount = preco;
        URL obj = new URL(POST_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization",TOKEN_AUTHSF);
        con.getOutputStream().write(generateBody(emailTO).getBytes());

        int responseCode = con.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            System.out.println(responseCode);
        } else {
            System.out.println("Falhou ein.");
        }

    }

    public static String dataPersistenceSF(Object body, String method) throws Exception {

        URL obj = new URL(POST_COMPOSITE);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestProperty("Authorization",TOKEN_AUTHSF);
        con.getOutputStream().write(generateBodyComposite(body,method).getBytes());

        int responseCode = con.getResponseCode();
        String result;
        BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        int result2 = bis.read();
        while(result2 != -1) {
            buf.write((byte) result2);
            result2 = bis.read();
        }
        result = buf.toString();

        //CompositeResponseTO responseRequest =  (CompositeResponseTO)new Gson().fromJson(result, CompositeResponseTO.class);
         var json = new Gson();
         ResponseCompositeTO.ResponseBodyTO resposta = json.fromJson(result, ResponseCompositeTO.ResponseBodyTO.class);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            return resposta.compositeResponse.get(0).body.id;

        } else {
            throw new Exception( con.getResponseMessage());
        }
    }

    public static class EmailTO{
        String ammount;
        String address;


    }
}
