package com.tencent.tencentmap.mapsdk.maps.a;

import java.io.Serializable;
import java.util.Map;

public class av implements Serializable {
    private long a = -1;
    private String b;
    private long c;
    private String d;
    private Map<String, String> e;
    private boolean f;

    public final synchronized long a() {
        return this.a;
    }

    public final synchronized void a(long j) {
        this.a = j;
    }

    public final synchronized String b() {
        return this.b;
    }

    public final synchronized void a(String str) {
        this.b = str;
    }

    public final synchronized long c() {
        return this.c;
    }

    public final synchronized void b(long j) {
        this.c = j;
    }

    public final synchronized String d() {
        return this.d;
    }

    public final synchronized void b(String str) {
        this.d = str;
    }

    public final synchronized Map<String, String> e() {
        return this.e;
    }

    public final synchronized void a(Map<String, String> map) {
        this.e = map;
    }

    public final boolean f() {
        return this.f;
    }

    public final void a(boolean z) {
        this.f = z;
    }
}
