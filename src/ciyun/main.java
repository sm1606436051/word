package ciyun;



import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class main {

    public static void main(String[] args) throws IOException, RowsExceededException, WriteException
    {

        String filePath = "C:\\Users\\Ragna\\Desktop\\work\\路透社新闻.txt";
        String st = ReadTxtFile.readTxt(filePath);
        String[] array=st.split(" ");

        String[] stoparray= {"的","地","得","，","。","【","】","·","１","２","","4","5","６","７","８","9","0","“","：","”"};

        //声明线性表
        WordFreqList wfl = new WordFreqList(array.length);
        //判断array[n]中的元素是否在线性表中
        for(int n =0;n<array.length;n++)
        {
            int x=wfl.find(array[n]);//标记字符串在线性表中的位置
            if(x==-1)
            {
                WordFreq temp = new WordFreq(array[n],1);
                wfl.set(temp);
            }
            else
            {
                wfl.element[x].number++;
            }
        }

        //利用停用词表删除
        for(int i =0;i<stoparray.length;i++)
        {
            int x=wfl.find(stoparray[i]);
            if(x>-1)
            {
                wfl.remove(stoparray[i]);
            }
        }

        for(int n =0;n<wfl.n;n++)
        {
            System.out.println(wfl.element[n].word +" " +wfl.element[n].number);
        }

    }



}