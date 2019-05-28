package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.g.b;

public final class a extends d {
    private static a jyV;
    private e jyW;
    private c jyX;
    private b jyY;

    public static a aUB() {
        a aVar;
        AppMethodBeat.i(17802);
        if (jyV == null) {
            aVar = new a();
            jyV = aVar;
            com.tencent.mm.plugin.backup.b.a.a(aVar);
        }
        aVar = jyV;
        AppMethodBeat.o(17802);
        return aVar;
    }

    public final void aSp() {
        jyV = null;
    }

    public final void m(Object... objArr) {
        AppMethodBeat.i(17803);
        Context context = (Context) objArr[0];
        aUB().aUE().aUF();
        b.clear();
        com.tencent.mm.bp.d.aI(new Intent().setClassName(context, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService"));
        AppMethodBeat.o(17803);
    }

    public final e aUC() {
        AppMethodBeat.i(17804);
        if (this.jyW == null) {
            this.jyW = new e();
        }
        e eVar = this.jyW;
        AppMethodBeat.o(17804);
        return eVar;
    }

    public final c aUD() {
        AppMethodBeat.i(17805);
        if (this.jyX == null) {
            this.jyX = new c();
        }
        c cVar = this.jyX;
        AppMethodBeat.o(17805);
        return cVar;
    }

    public final b aUE() {
        AppMethodBeat.i(17806);
        if (this.jyY == null) {
            this.jyY = new b();
        }
        b bVar = this.jyY;
        AppMethodBeat.o(17806);
        return bVar;
    }

    public final void aSv() {
    }

    public final void aSw() {
    }
}
