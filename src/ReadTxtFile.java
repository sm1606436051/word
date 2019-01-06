import java.io.*;
public class ReadTxtFile
{
    public static String readTxt(String filePath)
    {
        try
        {
            File file = new File(filePath);
            StringBuffer stb = new StringBuffer();
            if(file.isFile() && file.exists())
            {
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader br = new BufferedReader(isr);
                String lineTxt = null;
                while ((lineTxt = br.readLine()) != null)
                {
                    stb=stb.append(lineTxt);

                }
                String st= stb.toString();
                br.close();
                return st;
            }
            else {
                System.out.println("出现异常!");
                return null;
            }
        }
        catch (Exception e)
        {
            System.out.println("出现了一个问题!");
        }
        return null;
    }


}