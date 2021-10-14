package com.example.calculatordemo01.Bean;

public class Operators implements Comparator<String>{
    @SuppressWarnings("unused")
    private String[] operator = {"*","/","%","+","-","&","^","|"};//运算符集合
    private int[] priority = {3,3,3,4,4,8,9,10};//运算符权值
    private SeqList<String> operlist;
    public Operators() {
        this.operlist=new SeqList<String>(this.operator);
        // TODO Auto-generated constructor stub
    }
    @Override
    public  int compare(String obj1, String obj2) {  //比较两个运算符的优先级
        // TODO Auto-generated method stub
        int i=operlist.search(obj1), j=operlist.search(obj2);
        return this.priority[i]-this.priority[j];
    }
    public int operate (int x, int y, String oper) { //返回(x oper y)运算结果
        int value =0;
        switch(oper)
        {
            case"+": value=x+y;break;
            case"-": value=x-y;break;
            case"*": value=x*y;break;
            case"/": value=x/y;break;
            case"%": value=x%y;break;
            case"&": value=x&y;break;
            case"|": value=x|y;break;
            case"^": value=x^y;break;
        }
        return value;
    }
}
