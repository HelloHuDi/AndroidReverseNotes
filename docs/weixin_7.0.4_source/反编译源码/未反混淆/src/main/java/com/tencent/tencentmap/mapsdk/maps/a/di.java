package com.tencent.tencentmap.mapsdk.maps.a;

import java.io.Serializable;
import java.util.Map;

public final class di implements Serializable {
    private long a;
    private String b;
    private Map<String, String> c;
    private String d;
    private String e;

    public final String a() {
        return this.e;
    }

    public final void a(long j) {
        this.a = j;
    }

    public final void a(String str) {
        this.e = str;
    }

    public final synchronized void a(Map<String, String> map) {
        this.c = map;
    }

    public final String b() {
        return this.d;
    }

    public final void b(String str) {
        this.d = str;
    }

    public final long c() {
        return this.a;
    }

    public final synchronized void c(String str) {
        this.b = str;
    }

    public final synchronized String d() {
        return this.b;
    }

    public final synchronized Map<String, String> e() {
        return this.c;
    }
}
