package com.tencent.mm.plugin.appbrand.permission;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.ax;
import com.tencent.mm.plugin.appbrand.jsapi.bb;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.bd;
import com.tencent.mm.plugin.appbrand.jsapi.be;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.plugin.appbrand.jsapi.l.g;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram;
import com.tencent.mm.plugin.appbrand.jsapi.share.c;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.mm.plugin.appbrand.menu.j.a;
import com.tencent.mm.plugin.appbrand.menu.k;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Set;

final class b {
    private static final SparseIntArray iwg = new SparseIntArray() {
        public final int get(int i) {
            AppMethodBeat.i(132505);
            int i2 = super.get(i, R.string.k1);
            AppMethodBeat.o(132505);
            return i2;
        }
    };
    private static final Set<String> iwh = new HashSet();

    static {
        AppMethodBeat.i(132508);
        iwg.put(e.NAME.hashCode(), R.string.jx);
        iwg.put(g.NAME.hashCode(), R.string.jx);
        iwg.put(JsApiStartPlayVoice.NAME.hashCode(), R.string.jy);
        iwg.put(JsApiOperateMusicPlayer.NAME.hashCode(), R.string.jy);
        iwg.put(c.NAME.hashCode(), R.string.jz);
        iwg.put(a.NAME.hashCode(), R.string.jz);
        iwg.put(d.NAME.hashCode(), R.string.jz);
        iwg.put(f.NAME.hashCode(), R.string.jz);
        iwg.put(k.a.NAME.hashCode(), R.string.jz);
        iwg.put(JsApiLaunchMiniProgram.NAME.hashCode(), R.string.jw);
        iwh.add(e.NAME);
        iwh.add(g.NAME);
        iwh.add(JsApiStartPlayVoice.NAME);
        iwh.add(JsApiOperateMusicPlayer.NAME);
        iwh.add(c.NAME);
        iwh.add(a.NAME);
        iwh.add(d.NAME);
        iwh.add(f.NAME);
        iwh.add(k.a.NAME);
        iwh.add(JsApiLaunchMiniProgram.NAME);
        iwh.add(JsApiMakeVoIPCall.NAME);
        iwh.add(aa.NAME);
        iwh.add(com.tencent.mm.plugin.appbrand.jsapi.contact.c.NAME);
        iwh.add(au.NAME);
        iwh.add(ax.NAME);
        iwh.add(bb.NAME);
        iwh.add(bc.NAME);
        iwh.add(bd.NAME);
        iwh.add(be.NAME);
        iwh.add(com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.NAME);
        iwh.add(com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.c.NAME);
        AppMethodBeat.o(132508);
    }

    static void k(final i iVar, String str) {
        AppMethodBeat.i(132507);
        if (iVar == null || bo.isNullOrNil(str)) {
            AppMethodBeat.o(132507);
            return;
        }
        String string = ah.getResources().getString(iwg.get(str.hashCode()));
        string = ah.getResources().getString(R.string.k0, new Object[]{string});
        m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(132506);
                q asV = iVar.asV();
                if (asV != null) {
                    n currentPage = asV.getCurrentPage();
                    if (currentPage != null) {
                        u currentPageView = currentPage.getCurrentPageView();
                        if (currentPageView != null) {
                            com.tencent.mm.plugin.appbrand.widget.f.b bVar = currentPageView.isS;
                            String str = string;
                            if (bVar.jmB.aBk() == null || bVar.jmB.mContext == null) {
                                AppMethodBeat.o(132506);
                                return;
                            }
                            if (bVar.jmC == null) {
                                bVar.jmC = new com.tencent.mm.plugin.appbrand.widget.f.a(bVar.jmB.mContext);
                                bVar.jmC.a(bVar.jmB.aBk());
                            }
                            bVar.jmB.aBk().bringChildToFront(bVar.jmC.getView());
                            bVar.jmC.EQ(str);
                        }
                    }
                }
                AppMethodBeat.o(132506);
            }
        });
        AppMethodBeat.o(132507);
    }
}
