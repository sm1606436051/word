package ciyun;

public class WordFreqList extends Object{
    public  WordFreq[] element;
    public  int n;
    public WordFreqList(int length){
        this.element=new WordFreq[length];
        this.n=n;
    }
    public WordFreqList() {

    }

    public void set(WordFreq wf)
    {
        this.element[n]=wf;
        this.n++;
    }

    public int find(String st)
    {
        for(int i =0;i<this.n;i++)
        {
            if(this.element[i].word.equals(st))
                return i;
        }
        return -1;
    }
    public void remove(String st)
    {
        int x = this.find(st);
        for(int j=x;j<this.n;j++)
            this.element[j]=this.element[j+1];
        this.element[this.n-1]=null;
        this.n--;


    }

}