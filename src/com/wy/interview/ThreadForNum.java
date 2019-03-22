package com.wy.interview;

/**
 * @Author WangYang
 * @Description:双线程打印奇偶数
 * @Date Created in 10:46 2019/3/15
 */
public class ThreadForNum {

    private  static int count = 0;

    private static  final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        //test1();
        test2();
    }

    public static  void test1(){
        Thread ou  =new Thread(()->{
            while(count<100){
                synchronized (lock){
                    if((count&1)==0){
                        System.out.println(Thread.currentThread().getName()+" : "+count++);
                    }
                }

            }
        },"偶数");

        Thread ji  =new Thread(()->{
            while(count<100){
                synchronized (lock){
                    if((count&1)==1){
                        System.out.println(Thread.currentThread().getName()+" : "+count++);
                    }
                }

            }
        },"奇数");
        ou.start();
        ji.start();
    }

    public static void test2() throws InterruptedException{
        Thread ou = new Thread(()->{
            while(count<100){
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+" : "+count++);
                    lock.notifyAll();
                    if(count<100){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },"偶数");

        Thread ji = new Thread(()->{
            while(count<100){
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+" : "+count++);
                    lock.notifyAll();
                    if(count<100){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },"奇数");
        ou.start();
        Thread.sleep(1);
        ji.start();
    }
}
