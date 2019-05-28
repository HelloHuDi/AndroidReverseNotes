package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Rect;

public abstract class jb implements Comparable<jb> {
    public abstract Rect a();

    public abstract String b();

    public abstract void c();

    /* renamed from: a */
    public int compareTo(jb jbVar) {
        Rect a = a();
        Rect a2 = jbVar.a();
        if (a.top != a2.top) {
            return a.top - a2.top;
        }
        return a.left - a2.left;
    }
}
