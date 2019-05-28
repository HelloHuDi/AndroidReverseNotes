package com.tencent.mm.plugin.hp.tinker;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.plugin.hp.b.b.b;
import com.tencent.mm.plugin.hp.d.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.lib.service.a;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Properties;

public class TinkerPatchResultService extends DefaultTinkerResultService {
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(a aVar) {
        AppMethodBeat.i(90663);
        if (aVar == null) {
            com.tencent.tinker.lib.util.a.e("Tinker.TinkerPatchResultService", "TinkerPatchResultService received null result!!!!", new Object[0]);
            AppMethodBeat.o(90663);
            return;
        }
        int i;
        com.tencent.tinker.lib.util.a.i("Tinker.TinkerPatchResultService", "TinkerPatchResultService receive result: %s", aVar.toString());
        ab.i("Tinker.TinkerPatchResultService", "onPatchResult on service");
        Properties S = c.S(new File(aVar.ABv));
        if (S != null) {
            String str = f.CLIENT_VERSION;
            String property = S.getProperty("patch.client.ver");
            String property2 = S.getProperty("NEW_TINKER_ID");
            int i2 = b.SCENE_PATCH.value;
            if (aVar.cxT) {
                i = com.tencent.mm.plugin.hp.b.b.a.SUCCESS.value;
            } else {
                i = com.tencent.mm.plugin.hp.b.b.a.FAILED.value;
            }
            com.tencent.mm.plugin.hp.b.b.e(str, property, property2, i2, i);
        } else {
            ab.i("Tinker.TinkerPatchResultService", "onPatchResult properties is null.");
        }
        new ak(Looper.getMainLooper()).postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(90661);
                com.tencent.tinker.lib.util.a.w("Tinker.TinkerPatchResultService", "actually kill tinker patch service!", new Object[0]);
                com.tencent.tinker.lib.util.b.iY(TinkerPatchResultService.this.getApplicationContext());
                AppMethodBeat.o(90661);
            }
        }, 10000);
        if (aVar.cxT) {
            ApplicationLike applicationLike = com.tencent.mm.app.b.cdV;
            if (com.tencent.tinker.lib.e.b.c(applicationLike)) {
                String d = com.tencent.tinker.lib.e.b.d(applicationLike);
                if (!(ShareTinkerInternals.isNullOrNil(d) || aVar.ABw == null || !aVar.ABw.equals(d))) {
                    i = 0;
                    if (i == 0) {
                        l lVar = new l(ah.getContext(), new l.a() {
                            public final void cO(boolean z) {
                                AppMethodBeat.i(90662);
                                boolean access$000 = TinkerPatchResultService.access$000();
                                boolean Oo = com.tencent.mm.r.a.Oo();
                                if (z || access$000 || Oo) {
                                    com.tencent.tinker.lib.util.a.w("Tinker.TinkerPatchResultService", "not hit condition, skip suicide this time. cond: screenOn: %s, voip: %s, multiTalk: %s", Boolean.valueOf(z), Boolean.valueOf(access$000), Boolean.valueOf(Oo));
                                    AppMethodBeat.o(90662);
                                    return;
                                }
                                TinkerPatchResultService.a(TinkerPatchResultService.this);
                                AppMethodBeat.o(90662);
                            }
                        });
                        AppMethodBeat.o(90663);
                        return;
                    }
                    com.tencent.tinker.lib.util.a.i("Tinker.TinkerPatchResultService", "I have already install the newly patch version!", new Object[0]);
                }
            }
            i = 1;
            if (i == 0) {
            }
        }
        AppMethodBeat.o(90663);
    }

    static /* synthetic */ boolean access$000() {
        AppMethodBeat.i(90664);
        ui uiVar = new ui();
        uiVar.cQx.cAd = 2;
        com.tencent.mm.sdk.b.a.xxA.m(uiVar);
        boolean z = uiVar.cQy.cQz;
        AppMethodBeat.o(90664);
        return z;
    }
}
