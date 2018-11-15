package org.izv.aad.pspnavegacion;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navegar();
    }

    private void navegar(){
        AsyncTask task = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                try {
                    URL url = new URL("https://www.bing.com/ttranslate?&category=&IG=51C950C044BE4176885CCAFA7B90FD83&IID=translator.5034.22");
                    URLConnection conexion = url.openConnection();
                    conexion.setDoOutput(true);
                    OutputStreamWriter out = new OutputStreamWriter(
                            conexion.getOutputStream());
                    out.write("&text=i%20am%20the%20one%20that%20do%20this%20request.%20&from=en&to=es");
                    out.close();
                    BufferedReader in = new BufferedReader(new InputStreamReader(
                            conexion.getInputStream()));
                    String linea;
                    while ((linea = in.readLine()) != null) {
                    }
                    in.close();
                }catch (Exception e){
                    System.out.println(e.toString());
                }
                return null;
            }
        };
        task.execute();
    }
}
