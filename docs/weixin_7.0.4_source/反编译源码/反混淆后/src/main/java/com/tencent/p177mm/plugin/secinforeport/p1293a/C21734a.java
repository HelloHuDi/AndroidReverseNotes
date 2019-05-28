package com.tencent.p177mm.plugin.secinforeport.p1293a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.bbi;
import com.tencent.p177mm.protocal.protobuf.cvl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.secinforeport.a.a */
public enum C21734a {
    ;
    
    private static C43499b qjn;

    /* renamed from: com.tencent.mm.plugin.secinforeport.a.a$1 */
    static class C217351 implements C43499b {
        C217351() {
        }

        /* renamed from: a */
        public final void mo8445a(int i, String str, int i2, byte[] bArr) {
            AppMethodBeat.m2504i(126171);
            C4990ab.m7416i("MicroMsg.ClipBordReport", "!! Dummy implementation !!");
            AppMethodBeat.m2505o(126171);
        }
    }

    private C21734a(String str) {
    }

    static {
        qjn = new C217351();
        AppMethodBeat.m2505o(126177);
    }

    /* renamed from: a */
    public static void m33274a(C43499b c43499b) {
        if (c43499b != null) {
            qjn = c43499b;
        }
    }

    /* renamed from: h */
    public static void m33275h(int i, String str, int i2) {
        AppMethodBeat.m2504i(126174);
        C4990ab.m7419v("MicroMsg.ClipBordReport", "report ClipboardOperation %d, %s, %d", Integer.valueOf(i), str, Integer.valueOf(i2));
        qjn.mo8445a(i, str, i2, null);
        AppMethodBeat.m2505o(126174);
    }

    /* renamed from: i */
    public static void m33276i(String str, int i, int i2, String str2) {
        AppMethodBeat.m2504i(126175);
        C4990ab.m7419v("MicroMsg.ClipBordReport", "report ClipboardOperation %d, %s, %d, %d, %s", Integer.valueOf(3), str, Integer.valueOf(i), Integer.valueOf(i2), str2);
        cvl cvl = new cvl();
        cvl.wDR = i2;
        cvl.xrw = str2;
        byte[] bArr = null;
        try {
            bArr = cvl.toByteArray();
        } catch (IOException e) {
            C4990ab.m7421w("MicroMsg.ClipBordReport", "getExtInfo exp %s", e.getMessage());
        }
        qjn.mo8445a(3, str, i, bArr);
        AppMethodBeat.m2505o(126175);
    }

    /* renamed from: D */
    public static void m33273D(int i, String str, String str2) {
        AppMethodBeat.m2504i(126176);
        C4990ab.m7419v("MicroMsg.ClipBordReport", "report reportMiniProgram %d, %d, %s, %s", Integer.valueOf(5), Integer.valueOf(i), str, str2);
        bbi bbi = new bbi();
        bbi.csB = str;
        bbi.pQw = str2;
        byte[] bArr = null;
        try {
            bArr = bbi.toByteArray();
        } catch (IOException e) {
            C4990ab.m7421w("MicroMsg.ClipBordReport", "getExtInfo exp %s", e.getMessage());
        }
        qjn.mo8445a(5, "", i, bArr);
        AppMethodBeat.m2505o(126176);
    }
}
