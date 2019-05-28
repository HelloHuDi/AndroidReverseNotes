package com.tencent.p177mm.plugin.p436hp.tinker;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.app.C1244b;
import com.tencent.p177mm.modelmulti.C37943l;
import com.tencent.p177mm.modelmulti.C37943l.C26455a;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.plugin.p436hp.p1273d.C21071c;
import com.tencent.p177mm.plugin.p436hp.p437b.C46028b;
import com.tencent.p177mm.plugin.p436hp.p437b.C46028b.C12240b;
import com.tencent.p177mm.plugin.p436hp.p437b.C46028b.C46027a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.p679e.C5941b;
import com.tencent.tinker.lib.service.C46819a;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.lib.util.C31098b;
import com.tencent.tinker.lib.util.C5952a;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Properties;

/* renamed from: com.tencent.mm.plugin.hp.tinker.TinkerPatchResultService */
public class TinkerPatchResultService extends DefaultTinkerResultService {

    /* renamed from: com.tencent.mm.plugin.hp.tinker.TinkerPatchResultService$2 */
    class C122412 implements C26455a {
        C122412() {
        }

        /* renamed from: cO */
        public final void mo7663cO(boolean z) {
            AppMethodBeat.m2504i(90662);
            boolean access$000 = TinkerPatchResultService.access$000();
            boolean Oo = C35973a.m59176Oo();
            if (z || access$000 || Oo) {
                C5952a.m9285w("Tinker.TinkerPatchResultService", "not hit condition, skip suicide this time. cond: screenOn: %s, voip: %s, multiTalk: %s", Boolean.valueOf(z), Boolean.valueOf(access$000), Boolean.valueOf(Oo));
                AppMethodBeat.m2505o(90662);
                return;
            }
            TinkerPatchResultService.m76856a(TinkerPatchResultService.this);
            AppMethodBeat.m2505o(90662);
        }
    }

    /* renamed from: com.tencent.mm.plugin.hp.tinker.TinkerPatchResultService$1 */
    class C283191 implements Runnable {
        C283191() {
        }

        public final void run() {
            AppMethodBeat.m2504i(90661);
            C5952a.m9285w("Tinker.TinkerPatchResultService", "actually kill tinker patch service!", new Object[0]);
            C31098b.m50186iY(TinkerPatchResultService.this.getApplicationContext());
            AppMethodBeat.m2505o(90661);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo33931a(C46819a c46819a) {
        AppMethodBeat.m2504i(90663);
        if (c46819a == null) {
            C5952a.m9283e("Tinker.TinkerPatchResultService", "TinkerPatchResultService received null result!!!!", new Object[0]);
            AppMethodBeat.m2505o(90663);
            return;
        }
        int i;
        C5952a.m9284i("Tinker.TinkerPatchResultService", "TinkerPatchResultService receive result: %s", c46819a.toString());
        C4990ab.m7416i("Tinker.TinkerPatchResultService", "onPatchResult on service");
        Properties S = C21071c.m32376S(new File(c46819a.ABv));
        if (S != null) {
            String str = C5058f.CLIENT_VERSION;
            String property = S.getProperty("patch.client.ver");
            String property2 = S.getProperty("NEW_TINKER_ID");
            int i2 = C12240b.SCENE_PATCH.value;
            if (c46819a.cxT) {
                i = C46027a.SUCCESS.value;
            } else {
                i = C46027a.FAILED.value;
            }
            C46028b.m85596e(str, property, property2, i2, i);
        } else {
            C4990ab.m7416i("Tinker.TinkerPatchResultService", "onPatchResult properties is null.");
        }
        new C7306ak(Looper.getMainLooper()).postDelayed(new C283191(), 10000);
        if (c46819a.cxT) {
            ApplicationLike applicationLike = C1244b.cdV;
            if (C5941b.m9259c(applicationLike)) {
                String d = C5941b.m9260d(applicationLike);
                if (!(ShareTinkerInternals.isNullOrNil(d) || c46819a.ABw == null || !c46819a.ABw.equals(d))) {
                    i = 0;
                    if (i == 0) {
                        C37943l c37943l = new C37943l(C4996ah.getContext(), new C122412());
                        AppMethodBeat.m2505o(90663);
                        return;
                    }
                    C5952a.m9284i("Tinker.TinkerPatchResultService", "I have already install the newly patch version!", new Object[0]);
                }
            }
            i = 1;
            if (i == 0) {
            }
        }
        AppMethodBeat.m2505o(90663);
    }

    static /* synthetic */ boolean access$000() {
        AppMethodBeat.m2504i(90664);
        C26250ui c26250ui = new C26250ui();
        c26250ui.cQx.cAd = 2;
        C4879a.xxA.mo10055m(c26250ui);
        boolean z = c26250ui.cQy.cQz;
        AppMethodBeat.m2505o(90664);
        return z;
    }
}
