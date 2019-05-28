package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.kp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public abstract class b extends c<kp> {
    protected ArrayList<String> vaJ;

    public abstract void a(int i, int i2, String str, com.tencent.mm.sdk.b.b bVar);

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        kp kpVar = (kp) bVar;
        if ((kpVar instanceof kp) && kpVar.cGw.cGx != null && this.vaJ.contains(kpVar.cGw.cGx.getClass().getName())) {
            a(kpVar.cGw.errType, kpVar.cGw.errCode, kpVar.cGw.aIm, kpVar.cGw.cGx);
        }
        return false;
    }

    public b() {
        super(0);
        this.vaJ = new ArrayList(3);
        this.xxI = kp.class.getName().hashCode();
    }

    public static void a(String str, b bVar) {
        if (!bVar.vaJ.contains(str)) {
            bVar.vaJ.add(str);
        }
        a.xxA.c(bVar);
        e.ait(str);
    }

    public static void b(String str, b bVar) {
        e.aiu(str);
        a.xxA.d(bVar);
        if (bVar.vaJ.contains(str)) {
            bVar.vaJ.remove(str);
        }
    }
}
