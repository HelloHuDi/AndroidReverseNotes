package com.tencent.d.e.a.a;

public abstract class c implements Runnable {
    public abstract void dQt();

    public abstract void dQu();

    public void run() {
        try {
            dQt();
        } catch (Throwable th) {
            dQu();
        }
    }
}
