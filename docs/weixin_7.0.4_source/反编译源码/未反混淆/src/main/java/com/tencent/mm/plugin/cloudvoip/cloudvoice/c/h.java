package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

enum h {
    ;

    static class a implements i<Bundle, Bundle> {
        private static String kzL;
        private static final n kzM = null;

        static class a implements i<Bundle, Bundle> {
            private a() {
            }

            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(135499);
                int i = ((Bundle) obj).getInt("newState", 0);
                h hVar = h.kzJ;
                h.tE(i);
                AppMethodBeat.o(135499);
                return null;
            }
        }

        private a() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(135501);
            Bundle s = s((Bundle) obj);
            AppMethodBeat.o(135501);
            return s;
        }

        static {
            AppMethodBeat.i(135502);
            kzM = new com.tencent.mm.network.n.a() {
                public final void gl(int i) {
                    AppMethodBeat.i(135498);
                    String gB = at.gB(ah.getContext());
                    ab.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: on network changed: %d, changed to %s", Integer.valueOf(i), gB);
                    f.a(a.kzL, null, a.class);
                    AppMethodBeat.o(135498);
                }
            };
            AppMethodBeat.o(135502);
        }

        private static Bundle s(Bundle bundle) {
            AppMethodBeat.i(135500);
            int i = bundle.getInt("opcode", -1);
            String string = bundle.getString("from_process", "");
            kzL = string;
            if (bo.isNullOrNil(string) || !kzL.startsWith("com.tencent.mm")) {
                ab.e("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: invalid package name %s", kzL);
                AppMethodBeat.o(135500);
            } else {
                if (i == 0) {
                    g.RO().a(kzM);
                } else if (i == 1) {
                    g.RO().b(kzM);
                } else {
                    ab.w("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: not valid op code");
                }
                AppMethodBeat.o(135500);
            }
            return null;
        }
    }

    private h(String str) {
    }

    static {
        AppMethodBeat.o(135508);
    }

    static void bgr() {
        AppMethodBeat.i(135505);
        ab.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: stop listen to network change");
        tD(1);
        AppMethodBeat.o(135505);
    }

    static void tD(int i) {
        AppMethodBeat.i(135506);
        ab.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: operate network change: %d", Integer.valueOf(i));
        ab.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: current process name is %s", ah.getProcessName());
        Bundle bundle = new Bundle();
        bundle.putString("from_process", r0);
        bundle.putInt("opcode", i);
        f.a("com.tencent.mm", bundle, a.class);
        AppMethodBeat.o(135506);
    }
}
