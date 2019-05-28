package com.tencent.p177mm.plugin.cloudvoip.cloudvoice.p365c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1923n;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.h */
enum C33833h {
    ;

    /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.h$a */
    static class C2823a implements C45413i<Bundle, Bundle> {
        private static String kzL;
        private static final C1923n kzM = null;

        /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.h$a$a */
        static class C2824a implements C45413i<Bundle, Bundle> {
            private C2824a() {
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo4785am(Object obj) {
                AppMethodBeat.m2504i(135499);
                int i = ((Bundle) obj).getInt("newState", 0);
                C33833h c33833h = C33833h.kzJ;
                C33833h.m55341tE(i);
                AppMethodBeat.m2505o(135499);
                return null;
            }
        }

        /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.h$a$1 */
        static class C28251 extends C1924a {
            C28251() {
            }

            /* renamed from: gl */
            public final void mo5192gl(int i) {
                AppMethodBeat.m2504i(135498);
                String gB = C5023at.m7471gB(C4996ah.getContext());
                C4990ab.m7417i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: on network changed: %d, changed to %s", Integer.valueOf(i), gB);
                C9549f.m17010a(C2823a.kzL, null, C2824a.class);
                AppMethodBeat.m2505o(135498);
            }
        }

        private C2823a() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(135501);
            Bundle s = C2823a.m5070s((Bundle) obj);
            AppMethodBeat.m2505o(135501);
            return s;
        }

        static {
            AppMethodBeat.m2504i(135502);
            kzM = new C28251();
            AppMethodBeat.m2505o(135502);
        }

        /* renamed from: s */
        private static Bundle m5070s(Bundle bundle) {
            AppMethodBeat.m2504i(135500);
            int i = bundle.getInt("opcode", -1);
            String string = bundle.getString("from_process", "");
            kzL = string;
            if (C5046bo.isNullOrNil(string) || !kzL.startsWith("com.tencent.mm")) {
                C4990ab.m7413e("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: invalid package name %s", kzL);
                AppMethodBeat.m2505o(135500);
            } else {
                if (i == 0) {
                    C1720g.m3535RO().mo5187a(kzM);
                } else if (i == 1) {
                    C1720g.m3535RO().mo5188b(kzM);
                } else {
                    C4990ab.m7420w("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: not valid op code");
                }
                AppMethodBeat.m2505o(135500);
            }
            return null;
        }
    }

    private C33833h(String str) {
    }

    static {
        AppMethodBeat.m2505o(135508);
    }

    static void bgr() {
        AppMethodBeat.m2504i(135505);
        C4990ab.m7416i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: stop listen to network change");
        C33833h.m55340tD(1);
        AppMethodBeat.m2505o(135505);
    }

    /* renamed from: tD */
    static void m55340tD(int i) {
        AppMethodBeat.m2504i(135506);
        C4990ab.m7417i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: operate network change: %d", Integer.valueOf(i));
        C4990ab.m7417i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: current process name is %s", C4996ah.getProcessName());
        Bundle bundle = new Bundle();
        bundle.putString("from_process", r0);
        bundle.putInt("opcode", i);
        C9549f.m17010a("com.tencent.mm", bundle, C2823a.class);
        AppMethodBeat.m2505o(135506);
    }
}
