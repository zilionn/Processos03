package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DistroController {

    private String os() {
        return System.getProperty("os.name");
    }

    public void exibeDistro() {
        if (os().contains("Linux")) {
            String command = "cat /etc/os-release";
            try {
                Process process = Runtime.getRuntime().exec(command);
                InputStream inputStream = process.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }

                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("O SO não é Linux.");
        }
    }
}