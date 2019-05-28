package com.tencent.p127d.p132e.p133a.p134a;

/* renamed from: com.tencent.d.e.a.a.c */
public abstract class C25600c implements Runnable {
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
