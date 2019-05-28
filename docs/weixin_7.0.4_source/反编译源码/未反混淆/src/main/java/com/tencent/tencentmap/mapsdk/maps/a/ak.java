package com.tencent.tencentmap.mapsdk.maps.a;

import java.io.Serializable;

public abstract class ak implements Serializable {
    public abstract void a(ai aiVar);

    public abstract void a(aj ajVar);

    public final byte[] a() {
        aj ajVar = new aj();
        a(ajVar);
        return ajVar.b();
    }
}
