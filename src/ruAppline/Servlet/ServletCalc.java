package ruAppline.Servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import netscape.javascript.JSObject;
import org.ietf.jgss.GSSContext;
import ruAppline.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;

@WebServlet(urlPatterns = "/calc")
public class ServletCalc extends HttpServlet {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuffer bf = new StringBuffer();
        String line;

        try{
            BufferedReader br = request.getReader();
            while((line = br.readLine()) != null){
                bf.append(line);
            }
        } catch (Exception e){
            System.out.println("Error");
        }

        System.out.println(bf);

        JsonObject jsobject = gson.fromJson(String.valueOf(bf),JsonObject.class);

        double x = jsobject.get("x").getAsDouble();
        double y = jsobject.get("y").getAsDouble();
        String proc = jsobject.get("math").getAsString();

        Calculator calculator = new Calculator(x,y,proc);

        PrintWriter pw = response.getWriter();
        response.setContentType("application/json");

        pw.print(gson.toJson(calculator.calc()));


    }


}
