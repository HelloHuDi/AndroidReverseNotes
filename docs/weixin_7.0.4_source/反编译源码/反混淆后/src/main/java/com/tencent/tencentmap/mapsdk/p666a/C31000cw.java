package com.tencent.tencentmap.mapsdk.p666a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.a.cw */
public final class C31000cw {
    /* renamed from: a */
    private String f13970a;
    /* renamed from: b */
    private String f13971b;
    /* renamed from: c */
    private int f13972c;
    /* renamed from: d */
    private List<C36473cy> f13973d;

    public C31000cw(String str, String str2, List<C36473cy> list, int i) {
        this.f13970a = str;
        this.f13971b = str2;
        this.f13973d = list;
        this.f13972c = i;
    }

    /* renamed from: a */
    public final String mo50190a() {
        return this.f13970a;
    }

    /* renamed from: b */
    public final String mo50191b() {
        return this.f13971b;
    }

    /* renamed from: c */
    public final List<C36473cy> mo50192c() {
        return this.f13973d;
    }

    /* renamed from: d */
    public final int mo50193d() {
        return this.f13972c;
    }

    public final String toString() {
        AppMethodBeat.m2504i(100976);
        String str;
        if (this.f13970a == null || this.f13973d == null || this.f13973d.size() <= this.f13972c) {
            str = "";
            AppMethodBeat.m2505o(100976);
            return str;
        }
        str = this.f13970a + "_" + ((C36473cy) this.f13973d.get(this.f13972c)).mo57703a();
        AppMethodBeat.m2505o(100976);
        return str;
    }
}
