package com.tencent.p177mm.booter.notification.p841a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.notification.p841a.C9192f.C9196a;

/* renamed from: com.tencent.mm.booter.notification.a.g */
public final class C25977g {
    public C41901c eeA;
    public C18100d eeB;
    public C37622h eeC;
    private C9192f eeD;
    public C37621a eeE;
    public int eeF;
    public int eeG;
    public int eeH;
    public int eeI;
    public boolean eeJ;
    private int eeK = -1;
    private int eeL = -1;
    public boolean eeM;
    public boolean eeN;
    public C45272b eez;
    public Context mContext;

    public C25977g(Context context) {
        AppMethodBeat.m2504i(16035);
        this.mContext = context;
        this.eez = new C45272b();
        this.eeA = new C41901c();
        this.eeB = new C18100d();
        this.eeC = new C37622h();
        this.eeE = new C37621a();
        this.eeD = C9196a.eey;
        AppMethodBeat.m2505o(16035);
    }

    /* renamed from: jU */
    public final void mo43865jU(String str) {
        AppMethodBeat.m2504i(16036);
        this.eeD.mo20593jT(str);
        AppMethodBeat.m2505o(16036);
    }

    /* renamed from: b */
    public static String m41436b(long[] jArr) {
        AppMethodBeat.m2504i(16037);
        if (jArr == null) {
            AppMethodBeat.m2505o(16037);
            return null;
        }
        String str = "";
        for (long valueOf : jArr) {
            str = str + String.valueOf(valueOf) + ",";
        }
        if (str.isEmpty()) {
            AppMethodBeat.m2505o(16037);
            return str;
        }
        str = str.substring(0, str.length() - 1);
        AppMethodBeat.m2505o(16037);
        return str;
    }
}
