package com.tencent.p177mm.plugin.appbrand.jsapi.p304e;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p329s.p331b.C33523a;
import com.tencent.p177mm.sdk.p602d.C4886a;
import com.tencent.p177mm.sdk.p602d.C4887d;
import com.tencent.p177mm.sdk.p602d.C7292c;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.e.l */
final class C33299l extends C4887d {
    Bundle fPq;
    final C26967b hKU;
    public C19358a hKV;
    final C7292c hKW = new C333001();
    final C7292c hKX = new C333022();
    final C7292c hKY = new C333013();

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.e.l$a */
    public interface C19358a {
        /* renamed from: Bb */
        void mo6148Bb(String str);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.e.l$1 */
    class C333001 extends C7292c {
        C333001() {
        }

        public final String getName() {
            AppMethodBeat.m2504i(93827);
            String str = C33299l.this.mName + "$StateListening";
            AppMethodBeat.m2505o(93827);
            return str;
        }

        /* renamed from: k */
        public final boolean mo10090k(Message message) {
            AppMethodBeat.m2504i(93828);
            if (1 == message.what) {
                C33299l.this.mo10075b((C4886a) C33299l.this.hKX);
                AppMethodBeat.m2505o(93828);
                return true;
            }
            boolean k = super.mo10090k(message);
            AppMethodBeat.m2505o(93828);
            return k;
        }

        public final void enter() {
            AppMethodBeat.m2504i(93829);
            super.enter();
            ((C33523a) C37384e.m62985B(C33523a.class)).mo20056c("gcj02", C33299l.this.hKU, C33299l.this.fPq);
            if (C33299l.this.hKV != null) {
                C33299l.this.hKV.mo6148Bb("StateNotListening");
            }
            AppMethodBeat.m2505o(93829);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.e.l$3 */
    class C333013 extends C7292c {
        C333013() {
        }

        public final String getName() {
            AppMethodBeat.m2504i(93834);
            String str = C33299l.this.mName + "$StateSuspend";
            AppMethodBeat.m2505o(93834);
            return str;
        }

        /* renamed from: k */
        public final boolean mo10090k(Message message) {
            AppMethodBeat.m2504i(93835);
            if (2 == message.what) {
                C33299l.this.mo10075b((C4886a) C33299l.this.hKW);
                AppMethodBeat.m2505o(93835);
                return true;
            } else if (4 == message.what) {
                C33299l.this.mo10075b((C4886a) C33299l.this.hKX);
                AppMethodBeat.m2505o(93835);
                return true;
            } else {
                boolean k = super.mo10090k(message);
                AppMethodBeat.m2505o(93835);
                return k;
            }
        }

        public final void enter() {
            AppMethodBeat.m2504i(93836);
            super.enter();
            if (C33299l.this.hKV != null) {
                C33299l.this.hKV.mo6148Bb("StateSuspend");
            }
            AppMethodBeat.m2505o(93836);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.e.l$2 */
    class C333022 extends C7292c {
        C333022() {
        }

        public final String getName() {
            AppMethodBeat.m2504i(93830);
            String str = C33299l.this.mName + "$StateNotListening";
            AppMethodBeat.m2505o(93830);
            return str;
        }

        public final void enter() {
            AppMethodBeat.m2504i(93831);
            super.enter();
            ((C33523a) C37384e.m62985B(C33523a.class)).mo20055b("gcj02", C33299l.this.hKU, C33299l.this.fPq);
            if (C33299l.this.hKV != null) {
                C33299l.this.hKV.mo6148Bb("StateListening");
            }
            AppMethodBeat.m2505o(93831);
        }

        public final void exit() {
            AppMethodBeat.m2504i(93832);
            super.exit();
            ((C33523a) C37384e.m62985B(C33523a.class)).mo20056c("gcj02", C33299l.this.hKU, C33299l.this.fPq);
            AppMethodBeat.m2505o(93832);
        }

        /* renamed from: k */
        public final boolean mo10090k(Message message) {
            AppMethodBeat.m2504i(93833);
            if (2 == message.what) {
                C33299l.this.mo10075b((C4886a) C33299l.this.hKW);
                AppMethodBeat.m2505o(93833);
                return true;
            } else if (3 == message.what) {
                C33299l.this.mo10075b((C4886a) C33299l.this.hKY);
                AppMethodBeat.m2505o(93833);
                return true;
            } else {
                boolean k = super.mo10090k(message);
                AppMethodBeat.m2505o(93833);
                return k;
            }
        }
    }

    C33299l(C2241c c2241c) {
        super("RuntimeLocationUpdateStateManager[" + c2241c.getAppId() + "]", Looper.getMainLooper());
        AppMethodBeat.m2504i(93837);
        this.hKU = new C26967b(c2241c);
        mo10073a(this.hKW);
        mo10073a(this.hKX);
        mo10073a(this.hKY);
        mo10076b(this.hKW);
        AppMethodBeat.m2505o(93837);
    }
}
