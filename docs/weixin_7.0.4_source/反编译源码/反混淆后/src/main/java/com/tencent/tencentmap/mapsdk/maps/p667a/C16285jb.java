package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.graphics.Rect;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jb */
public abstract class C16285jb implements Comparable<C16285jb> {
    /* renamed from: a */
    public abstract Rect mo12518a();

    /* renamed from: b */
    public abstract String mo12519b();

    /* renamed from: c */
    public abstract void mo12520c();

    /* renamed from: a */
    public int compareTo(C16285jb c16285jb) {
        Rect a = mo12518a();
        Rect a2 = c16285jb.mo12518a();
        if (a.top != a2.top) {
            return a.top - a2.top;
        }
        return a.left - a2.left;
    }
}
