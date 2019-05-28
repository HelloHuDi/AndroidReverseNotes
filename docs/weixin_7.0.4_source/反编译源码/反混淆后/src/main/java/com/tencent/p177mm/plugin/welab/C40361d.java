package com.tencent.p177mm.plugin.welab;

import com.facebook.internal.NativeProtocol;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelsns.C32831d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.welab.d */
public final class C40361d {

    /* renamed from: com.tencent.mm.plugin.welab.d$a */
    public static class C29976a {
        public int action;
        public String csB;
        public long timeStamp;
        public String uLT;
        public boolean uLU;
    }

    /* renamed from: a */
    public static void m69200a(C29976a c29976a) {
        int i;
        AppMethodBeat.m2504i(80540);
        C32831d c32831d = new C32831d();
        c32831d.mo53400l("expid", c29976a.uLT + ",");
        c32831d.mo53400l("appid", c29976a.csB + ",");
        c32831d.mo53400l(NativeProtocol.WEB_DIALOG_ACTION, c29976a.action + ",");
        c32831d.mo53400l(Param.TIMESTAMP, c29976a.timeStamp + ",");
        String str = "hasRedPoint";
        StringBuilder stringBuilder = new StringBuilder();
        if (c29976a.uLU) {
            i = 1;
        } else {
            i = 0;
        }
        c32831d.mo53400l(str, stringBuilder.append(i).append(",").toString());
        C4990ab.m7416i("WelabReporter", "report " + c32831d.mo53398Fk());
        C7060h.pYm.mo8381e(14206, c32831d);
        AppMethodBeat.m2505o(80540);
    }

    /* renamed from: t */
    public static void m69201t(String str, int i, boolean z) {
        AppMethodBeat.m2504i(80541);
        C29976a c29976a = new C29976a();
        c29976a.csB = str;
        c29976a.action = i;
        c29976a.timeStamp = System.currentTimeMillis();
        c29976a.uLT = C29974a.ddj().agI(str).field_expId;
        c29976a.uLU = z;
        C40361d.m69200a(c29976a);
        AppMethodBeat.m2505o(80541);
    }

    /* renamed from: A */
    public static void m69199A(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(80542);
        C29976a c29976a = new C29976a();
        c29976a.csB = str;
        c29976a.action = 8;
        c29976a.timeStamp = System.currentTimeMillis();
        c29976a.uLT = str2;
        c29976a.uLU = z;
        C40361d.m69200a(c29976a);
        AppMethodBeat.m2505o(80542);
    }
}
