import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2017/2/23.
 */
public class IOReadFile {

    public static void main(String[] args){
        String filePath="src/test.txt";
        File file=new File(filePath);
        IOReadFile readFile=new IOReadFile();
        try {
            readFile.readAllNumericalLine(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readAllNumericalLine(File file) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader(file));
        String line=null;
        while((line=br.readLine())!=null){
            boolean ret=isDigit(line);
            if(ret) System.out.println(line);
        }
        br.close();

    }

    private boolean isDigit(String str){
        /*boolean ret=true;
        char[] array=str.toCharArray();
        for(int i=0;i<array.length;i++){
            if (!Character.isDigit(array[i])) ret=false;
        }
        return ret;*/

        /**********************************************/

      /*  Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;*/

        boolean ret=true;
        char[] array=str.toCharArray();
        for(int i=0;i<array.length;i++){
            if (array[i]<'0'||array[i]>'9') {
                ret=false;
                break;
            }

        }
        return ret;
    }
    public interface Test{
        public int i=0;
    }
}
