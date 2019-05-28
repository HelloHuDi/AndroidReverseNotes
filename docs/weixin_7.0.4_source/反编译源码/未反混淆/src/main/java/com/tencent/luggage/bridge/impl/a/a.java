package com.tencent.luggage.bridge.impl.a;

import com.tencent.mm.plugin.appbrand.d.a.b;

public abstract class a implements b {
    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (wP().equalsIgnoreCase(((b) obj).wP())) {
            return true;
        }
        return super.equals(obj);
    }

    public void a(String str, com.tencent.mm.plugin.appbrand.d.a.a aVar) {
        if (aVar != null) {
            aVar.Q(new byte[0]);
        }
    }
}
