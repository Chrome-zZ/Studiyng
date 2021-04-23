import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter source path: ");
        File source = new File(br.readLine());

        System.out.print("Enter destination path: ");
        File destination = new File(br.readLine());

        FileUtils.copyFolder(source.toPath(), destination.toPath());
    }
}
