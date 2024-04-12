import java.nio.file.FileSystems;

public class CrossPath {
    public String getAutomaticPath (String path){
        String separador = FileSystems.getDefault().getSeparator();
        String sistemaOperativo = System.getProperty("os.name");

        System.out.println(separador);

        if (sistemaOperativo.toLowerCase().contains("linux")) {
            path = path.replace("\\", separador);
        } else if (sistemaOperativo.toLowerCase().contains("windows")) {
            path = path.replace("/", separador);
        }
        return path;
    }
}
