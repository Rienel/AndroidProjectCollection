package com.example.androidprojectcollection;

public class Stack {
    int a[]=new int[100];
    public int top=-1;

    public void push(int data) {
        if(top<99) {
            top++;
            a[top]=data;
        } else {
            System.out.println("Stack is full");
        }
    }
    public int pop()
    {
        int ch=0;

        if(top!=-1) {
            ch=a[top];
            top--;
        }

        return ch;
    }
}