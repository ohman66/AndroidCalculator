package com.example.calculatordemo01.Bean;

public class LinkedStack<T> implements Stack<T>{
    private SinglyList<T> list;
    public LinkedStack() {
        this.list = new SinglyList<T>();
    }
    @Override
    public boolean empty() {
        // TODO Auto-generated method stub
        return this.list.enmpty();
    }

    @Override
    public void push(T x) {
        // TODO Auto-generated method stub
        this.list.insert(0, x);
    }
    @Override
    public T peek() {
        // TODO Auto-generated method stub
        return this.list.get(0);
    }
    @Override
    public T pop() {
        // TODO Auto-generated method stub
        return this.list.move(0);
    }
}
