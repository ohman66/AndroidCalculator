package com.example.calculatordemo01.Bean;

class Node<T> extends Object{//链表节点类，T指定结点的元素类型
    public T data;//数据域，存储数据元素
    public Node<T> next;//地址域，引用后继结点
    public Node(T data,Node<T> next) {//构造结点，data指定数据元素，next指定后继结点
        this.data=data;//T对象引用赋值
        this.next=next;//Node<T>对象引用赋值
    }
    public Node() {
        this(null,null);
    }
    public String toString() {//返回结点数据域的描述字符串
        return this.data.toString();
    }
}
public class SinglyList<T> extends Object{//单链表类，T表示数据元素的数据类型;默认继分
    public Node<T> head;//头指针，指向单链表的头结点
    public SinglyList() {//构造方法，构造空单链表。O(1)
        this.head=new Node<T>();//创建头结点，data 和next值均为null
    }
    public SinglyList(T[] v) {//构造单链表，尾插入v数组元素
        this();//创建空单链表，只有头结点
        Node<T> rear=this.head;//rear尾指针指向单链表最后一个结点
        for(int i=0;i<v.length;i++) {//若values.length==0，则构造空链表
            if(v[i]!=null) {
                rear.next=new Node<T>(v[i],null);//尾插入，创建结点链入rear结点之后
                rear=rear.next;//rear指向新的链尾结点
            }
        }
    }
    public String toString() {//返回所有元素的描述字符串
        String str=this.getClass().getName();//返回类名
        for(Node<T> p=this.head.next;p!=null;p=p.next) {//p遍历单链表
            str+=" "+p.data.toString()+(p.next!=null?",":"");//不是最后一个结点时、加分隔符
        }
        return str;//空表返回
    }
    public boolean enmpty(){//判断链表是否为空
        return this.head.next==null;
    }
    public T get(int i) {//返回第i个元素，0≤i<单链表长度
        Node<T> p=this.head.next;
        for(int j = 0;p!=null&&j<i;j++) {//遍历单链表，寻找第i个结点
            p=p.next;
        }
        if(i>=0&&p!=null) {//若p指向第i个结点，则返回其元素值
            return p.data;
        }
        return null;
    }
    public Node<T> insert(int i,T x) {
        if(x==null) {
            return null;
        }
        Node<T> f=this.head;//f指向头结点
        for(int j=0;f.next!=null&&j<i;j++) {//寻找第i-1个或最后一个结点
            f=f.next;
        }
        f.next=new Node<T>(x,f.next);//在f后插入值为×结点
        return f.next;
    }
    public Node<T> insert(T x){//单链表尾插入x，O(n)，重载
        return insert(Integer.MAX_VALUE,x);
    }
    public T move(int i) {//删除第i个元素
        Node<T> f=this.head;//f指向头结点
        for(int j=0;f.next!=null&&j<i;j++) {//遍历寻找第i-1结点
            f=f.next;
        }
        if(i>=0&&f.next!=null) {//若f的后继结点存在，删除
            T x=f.next.data;
            f.next=f.next.next;
            return x;//获得待删除结点引用的对象
        }
        return null;
    }
    public void clear() {//删除单链表所有元素
        this.head.next=null;
    }
    public int search(T k){//查找
        int i=0;
        Node<T> f=this.head.next;
        while(f!=null) {//遍历寻找与k相同的数值
            if(f.data==k) {//判断值是否相同
                return i;
            }
            f=f.next;
            i++;
        }
        return 0;
    }
    public SinglyList(SinglyList<T> t){
        this.head=t.head;
    }
}
