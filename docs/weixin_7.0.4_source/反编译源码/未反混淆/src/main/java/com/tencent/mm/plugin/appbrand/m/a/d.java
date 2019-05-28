package com.tencent.mm.plugin.appbrand.m.a;

import com.tencent.mm.aa.g;
import com.tencent.mm.aa.i;

public abstract class d implements a {
    public abstract String b(i iVar, c cVar);

    public final String a(String str, c cVar) {
        try {
            return b(new i(str), cVar);
        } catch (g e) {
            return cVar.aIU();
        }
    }
}
