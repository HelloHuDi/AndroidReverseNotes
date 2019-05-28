package com.tencent.tencentmap.mapsdk.maps.p667a;

import java.io.Serializable;
import java.util.Map;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.di */
public final class C24364di implements Serializable {
    /* renamed from: a */
    private long f4659a;
    /* renamed from: b */
    private String f4660b;
    /* renamed from: c */
    private Map<String, String> f4661c;
    /* renamed from: d */
    private String f4662d;
    /* renamed from: e */
    private String f4663e;

    /* renamed from: a */
    public final String mo40553a() {
        return this.f4663e;
    }

    /* renamed from: a */
    public final void mo40554a(long j) {
        this.f4659a = j;
    }

    /* renamed from: a */
    public final void mo40555a(String str) {
        this.f4663e = str;
    }

    /* renamed from: a */
    public final synchronized void mo40556a(Map<String, String> map) {
        this.f4661c = map;
    }

    /* renamed from: b */
    public final String mo40557b() {
        return this.f4662d;
    }

    /* renamed from: b */
    public final void mo40558b(String str) {
        this.f4662d = str;
    }

    /* renamed from: c */
    public final long mo40559c() {
        return this.f4659a;
    }

    /* renamed from: c */
    public final synchronized void mo40560c(String str) {
        this.f4660b = str;
    }

    /* renamed from: d */
    public final synchronized String mo40561d() {
        return this.f4660b;
    }

    /* renamed from: e */
    public final synchronized Map<String, String> mo40562e() {
        return this.f4661c;
    }
}
