package com.tencent.mm.storage;

import com.tencent.mm.model.bf.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;

public abstract class e {
    public static l xHP;
    protected h xHO;

    public abstract String aog(String str);

    /* Access modifiers changed, original: protected */
    public boolean a(bi biVar, b bVar) {
        return true;
    }

    public e(h hVar) {
        this.xHO = hVar;
    }

    public final com.tencent.mm.cd.h bOy() {
        return this.xHO.bOy();
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(com.tencent.mm.cd.h hVar, String str) {
        this.xHO.a(hVar, str);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(h.b bVar) {
        this.xHO.a(bVar);
    }

    /* Access modifiers changed, original: protected|final */
    public final String Rr(String str) {
        return this.xHO.Rr(str);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar) {
        this.xHO.a(cVar);
    }

    /* Access modifiers changed, original: protected|final */
    public final void hZ(String str, String str2) {
        this.xHO.b(str, str2, null);
    }
}
