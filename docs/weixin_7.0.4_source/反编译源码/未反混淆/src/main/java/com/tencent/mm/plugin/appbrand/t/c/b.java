package com.tencent.mm.plugin.appbrand.t.c;

public class b extends Exception {
    public int iTp;

    public b() {
        this.iTp = 1002;
    }

    public b(String str) {
        super(str);
        this.iTp = 1002;
    }

    public b(int i, Throwable th) {
        super(th);
        this.iTp = i;
    }
}
