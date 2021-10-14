package com.example.calculatordemo01.Bean;

public class SeqStack<T> implements Stack<T>{
    private SeqList<T> list;
    public SeqStack(int length) {
        this.list=new SeqList<T>(length);
    }
    public SeqStack() {
        this(64);
    }
    @Override
    public boolean empty() {
        return this.list.isEmpty();
    }
    @Override
    public void push(T x) {
        this.list.insert(x);
    }
    @Override
    public T peek() {
        // TODO Auto-generated method stub

        return this.list.get(list.size()-1);
    }
    @Override
    public T pop() {
        return this.list.remove(list.size()-1);
    }
    public static void main(String[] arg) {
        SeqStack<Integer> s=new SeqStack<Integer>();
        for(int i=0;i<5;i++) {
            s.push(i);
        }
        for(int j=0;j<5;j++) {
            System.out.println(s.pop());
        }
    }

}
