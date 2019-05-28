package com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b.C9557a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.ahk;
import com.tencent.p177mm.protocal.protobuf.ahl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.l */
final class C27673l {
    final Map<String, C11413k> kBt = new ConcurrentHashMap(1);

    /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.l$a */
    public interface C27675a {
        /* renamed from: a */
        void mo45520a(int i, int i2, String str, C11413k c11413k, boolean z);
    }

    /* renamed from: a */
    static /* synthetic */ void m43989a(C27673l c27673l, int i, int i2, String str, C11413k c11413k, boolean z, C27675a c27675a) {
        AppMethodBeat.m2504i(135596);
        c27673l.m43988a(i, i2, str, c11413k, z, c27675a);
        AppMethodBeat.m2505o(135596);
    }

    C27673l() {
        AppMethodBeat.m2504i(135591);
        AppMethodBeat.m2505o(135591);
    }

    /* renamed from: a */
    public final void mo45521a(String str, C27675a c27675a) {
        AppMethodBeat.m2504i(135592);
        C11413k c11413k = (C11413k) this.kBt.get(str);
        if (c11413k == null || !c11413k.isValid()) {
            this.kBt.remove(str);
            m43990b(str, c27675a);
            AppMethodBeat.m2505o(135592);
            return;
        }
        C4990ab.m7410d("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: has valid sessionKey");
        m43988a(0, 0, "", c11413k, false, c27675a);
        AppMethodBeat.m2505o(135592);
    }

    /* renamed from: a */
    private void m43988a(int i, int i2, String str, C11413k c11413k, boolean z, C27675a c27675a) {
        AppMethodBeat.m2504i(135593);
        final C27675a c27675a2 = c27675a;
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        final C11413k c11413k2 = c11413k;
        final boolean z2 = z;
        C33836j.kzW.mo54393R(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(135589);
                c27675a2.mo45520a(i3, i4, str2, c11413k2, z2);
                AppMethodBeat.m2505o(135589);
            }
        });
        AppMethodBeat.m2505o(135593);
    }

    /* renamed from: b */
    private void m43990b(final String str, final C27675a c27675a) {
        AppMethodBeat.m2504i(135594);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ahk();
        c1196a.fsK = new ahl();
        c1196a.fsI = 2985;
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getcloudimsession";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        C7472b acD = c1196a.acD();
        ((ahk) acD.fsG.fsP).csB = str;
        C42146b.m74301a(acD, new C9557a() {
            /* renamed from: a */
            public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
                AppMethodBeat.m2504i(135590);
                if (i == 0 && i2 == 0 && c7472b.fsH.fsP != null) {
                    ahl ahl = (ahl) c7472b.fsH.fsP;
                    C11413k c11413k = new C11413k();
                    c11413k.kBq = ahl.wcw;
                    c11413k.kBs = C5046bo.m7588yz();
                    c11413k.kBr = (long) ahl.wnU;
                    C4990ab.m7417i("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: getSession sessionKey: %s", c11413k);
                    C27673l.this.kBt.put(str, c11413k);
                    C27673l.m43989a(C27673l.this, 0, 0, "", c11413k, true, c27675a);
                    AppMethodBeat.m2505o(135590);
                    return;
                }
                C4990ab.m7412e("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: get sessionkey fail,errType:" + i + ",errCode:" + i2);
                C27673l.m43989a(C27673l.this, i, i2, str, null, false, c27675a);
                AppMethodBeat.m2505o(135590);
            }
        });
        AppMethodBeat.m2505o(135594);
    }

    public final void reset(String str) {
        AppMethodBeat.m2504i(135595);
        C4990ab.m7416i("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: on exit");
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(135595);
            return;
        }
        this.kBt.remove(str);
        AppMethodBeat.m2505o(135595);
    }
}
