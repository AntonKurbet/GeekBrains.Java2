package ru.geekbrains.java2.lesson5;

public class ThreadWorker extends Thread{
    private int begin;
    private int size;
    ThreadWorker(String name, int begin, int size) {
        super(name);
        this.begin = begin;
        this.size = size;
    }

    @Override
    public void run() {
        //System.out.println(this.getName() + " starts");
        ArraysWorks.multiThreadWork(begin,size);
        //System.out.println(this.getName() + " ends");
    }
}
