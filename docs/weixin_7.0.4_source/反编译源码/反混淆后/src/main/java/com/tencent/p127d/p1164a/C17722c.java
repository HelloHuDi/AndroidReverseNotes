package com.tencent.p127d.p1164a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p127d.p128c.p1450b.C32109c;
import com.tencent.p127d.p128c.p1450b.C41203a;
import com.tencent.p127d.p135f.C41669a;
import com.tencent.p127d.p807b.C37315a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.d.a.c */
public final class C17722c {
    private static C37315a ArE = null;

    /* renamed from: com.tencent.d.a.c$a */
    public interface C17723a {
        /* renamed from: f */
        void mo32829f(int i, byte[] bArr);
    }

    /* renamed from: a */
    public static void m27645a(Context context, C17723a c17723a) {
        AppMethodBeat.m2504i(114464);
        if (ArE == null) {
            ArE = new C37315a(context);
        }
        C37315a c37315a = ArE;
        try {
            List iJ = C41669a.m73071iJ(c37315a.mContext);
            if (iJ.size() == 0) {
                c17723a.mo32829f(-10, null);
                AppMethodBeat.m2505o(114464);
                return;
            }
            C41203a c41203a = new C41203a();
            c41203a.Asl = C37315a.dQj();
            c41203a.Asj = new C32109c();
            c41203a.Asj.AsM = 6;
            c41203a.Asj.Ase = 1;
            c41203a.Asj.requestType = 0;
            c41203a.Asj.AsN = 0;
            c41203a.Asj.AsO = 0;
            c41203a.Asj.AsP = null;
            c41203a.Asj.AsQ = 0;
            c41203a.Asj.AsU = 1;
            c41203a.Ask = new ArrayList();
            for (int i = 0; i < iJ.size(); i++) {
                c41203a.Ask.add(C37315a.m62717a(c37315a.mContext, (C41659a) iJ.get(i), i));
            }
            byte[] a = c37315a.ArH.mo43325a(c41203a);
            if (a == null) {
                c17723a.mo32829f(-20, null);
                AppMethodBeat.m2505o(114464);
                return;
            }
            c17723a.mo32829f(0, a);
            AppMethodBeat.m2505o(114464);
        } catch (Throwable th) {
            c17723a.mo32829f(-100, null);
            AppMethodBeat.m2505o(114464);
        }
    }
}
