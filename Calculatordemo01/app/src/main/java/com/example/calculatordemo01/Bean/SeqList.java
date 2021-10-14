package com.example.calculatordemo01.Bean;

public class SeqList<T> extends Object {
    protected int n;
    protected Object[] element;
    private static final int MIN_CAPACITY=16;
    public SeqList(int length) {
        if(length<MIN_CAPACITY)
            length = MIN_CAPACITY;
        this.element = new Object[length];
        this.n=0;
        // TODO Auto-generated constructor stub
    }
    public SeqList() {
        this(MIN_CAPACITY);
        // TODO Auto-generated constructor stub
    }
    public SeqList(T[] values) {
        this(values.length*2);
        for(int i=0;i<values.length;i++) {
            if(values[i]!=null)
                this.element[this.n++]=values[i];
        }
        // TODO Auto-generated constructor stub
    }
    public boolean isEmpty() {
        return this.n==0;
    }
    public int size() {
        return this.n;
    }
    public T get(int i) {
        if(i>=0&&i<this.n)
            return (T)this.element[i];
        return null;
    }
    public void set(int x,T y) {
        if(y==null)
            throw new NullPointerException("null");
        if(x>=0&&x<this.n)
            this.element[x]=y;
        else
            throw new java.lang.IndexOutOfBoundsException(x+"");
    }
    public int insert(int i, T x) {//插入x为第i个元素
        if(x==null)
            return -1;
        if(i<0)
            i=0;
        if(i>this.n)
            i=this.n;
        Object[] source = this.element;
        if(this.n==element.length) {
            this.element=new Object[source.length*2];
            for(int j=0;j<source.length;j++)
                this.element[j]=source[j];
        }
        for(int j =this.n-1;j>=i;j--) {
            this.element[j+1]=source[j];
        }
        this.element[i]=x;
        this.n++;
        return i;
    }
    public int insert(T x) {
        return this.insert(this.n,x);
    }
    public T remove(int i) {
        if(i>=0&&i<this.n) {
            @SuppressWarnings("unchecked")
            T x=(T)this.element[i];
            for(int j=i;j<this.n-1;j++) {
                this.element[j]=this.element[j+1];
            }
            this.element[n-1]=null;
            n--;
            return x;
        }
        return null;
    }
    public void clear() {
        this.n=0;
    }
    public int search(T key) {
        for(int i=0;i<this.n;i++) {
            if(key.equals(this.element[i]))
                return i;
        }
        return -1;
    }
    public String toString() {
        String str= this.getClass().getName()+"(";
        if(this.n>0)
            str+=this.element[0].toString();
        for(int i=1;i<this.n;i++) {
            str+=","+this.element[i].toString();
        }
        return str+")";
    }
}
