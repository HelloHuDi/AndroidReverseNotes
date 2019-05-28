package com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.backup.p342b.C33660a;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.plugin.backup.p920g.C19978b;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a */
public final class C41257a extends C38634d {
    private static C41257a jyV;
    private C27460e jyW;
    private C38643c jyX;
    private C45738b jyY;

    public static C41257a aUB() {
        C41257a c41257a;
        AppMethodBeat.m2504i(17802);
        if (jyV == null) {
            c41257a = new C41257a();
            jyV = c41257a;
            C33660a.m54968a(c41257a);
        }
        c41257a = jyV;
        AppMethodBeat.m2505o(17802);
        return c41257a;
    }

    public final void aSp() {
        jyV = null;
    }

    /* renamed from: m */
    public final void mo61481m(Object... objArr) {
        AppMethodBeat.m2504i(17803);
        Context context = (Context) objArr[0];
        C41257a.aUB().aUE().aUF();
        C19978b.clear();
        C25985d.m41464aI(new Intent().setClassName(context, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService"));
        AppMethodBeat.m2505o(17803);
    }

    public final C27460e aUC() {
        AppMethodBeat.m2504i(17804);
        if (this.jyW == null) {
            this.jyW = new C27460e();
        }
        C27460e c27460e = this.jyW;
        AppMethodBeat.m2505o(17804);
        return c27460e;
    }

    public final C38643c aUD() {
        AppMethodBeat.m2504i(17805);
        if (this.jyX == null) {
            this.jyX = new C38643c();
        }
        C38643c c38643c = this.jyX;
        AppMethodBeat.m2505o(17805);
        return c38643c;
    }

    public final C45738b aUE() {
        AppMethodBeat.m2504i(17806);
        if (this.jyY == null) {
            this.jyY = new C45738b();
        }
        C45738b c45738b = this.jyY;
        AppMethodBeat.m2505o(17806);
        return c45738b;
    }

    public final void aSv() {
    }

    public final void aSw() {
    }
}
