package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.g.a.jp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public abstract class a extends c<jp> {
    protected ArrayList<String> vaJ;

    public abstract void j(b bVar);

    public a() {
        this.vaJ = new ArrayList(3);
        this.xxI = jp.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        jp jpVar = (jp) bVar;
        if ((jpVar instanceof jp) && jpVar.cEP.cEQ != null && this.vaJ.contains(jpVar.cEP.cEQ.getClass().getName())) {
            j(jpVar.cEP.cEQ);
        }
        return false;
    }

    public static void a(String str, a aVar) {
        if (!aVar.vaJ.contains(str)) {
            aVar.vaJ.add(str);
        }
        com.tencent.mm.sdk.b.a.xxA.c(aVar);
        e.ait(str);
    }

    public static void b(String str, a aVar) {
        e.aiu(str);
        com.tencent.mm.sdk.b.a.xxA.d(aVar);
        if (aVar.vaJ.contains(str)) {
            aVar.vaJ.remove(str);
        }
    }
}
