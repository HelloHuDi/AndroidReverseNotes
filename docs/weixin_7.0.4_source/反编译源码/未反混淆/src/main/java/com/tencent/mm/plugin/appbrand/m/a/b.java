package com.tencent.mm.plugin.appbrand.m.a;

import com.tencent.mm.aa.g;
import com.tencent.mm.aa.i;

public abstract class b implements a {

    public interface a {
        void Y(int i, String str);
    }

    public abstract void a(i iVar, c cVar);

    public final String a(String str, c cVar) {
        try {
            a(new i(str), cVar);
            return null;
        } catch (g e) {
            return cVar.aIU();
        }
    }
}
