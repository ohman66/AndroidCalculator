package com.example.calculatordemo01.Bean;

public interface Stack<T>{//栈的接口
    public abstract boolean empty();//判断栈是否为空
    public abstract void push(T x);//入栈
    public abstract T peek();//输出但不删除栈中的元素
    public abstract T pop();//输出栈顶元素（删除元素）
}
