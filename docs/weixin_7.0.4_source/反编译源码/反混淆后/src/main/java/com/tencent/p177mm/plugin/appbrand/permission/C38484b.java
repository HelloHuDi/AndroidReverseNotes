package com.tencent.p177mm.plugin.appbrand.permission;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2206au;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33246ax;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38269bc;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38271be;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42464aa;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45579bb;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45580bd;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.C33279c;
import com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram;
import com.tencent.p177mm.plugin.appbrand.jsapi.offlinevoice.C42558b;
import com.tencent.p177mm.plugin.appbrand.jsapi.offlinevoice.C42559c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C19410e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C38323g;
import com.tencent.p177mm.plugin.appbrand.jsapi.share.C27077c;
import com.tencent.p177mm.plugin.appbrand.jsapi.share.C42568d;
import com.tencent.p177mm.plugin.appbrand.jsapi.share.C42571f;
import com.tencent.p177mm.plugin.appbrand.menu.C19610j.C19613a;
import com.tencent.p177mm.plugin.appbrand.menu.C27208k.C27207a;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.page.C19640n;
import com.tencent.p177mm.plugin.appbrand.page.C38470q;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.p1236f.C42725a;
import com.tencent.p177mm.plugin.appbrand.widget.p1236f.C42728b;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.permission.b */
final class C38484b {
    private static final SparseIntArray iwg = new C24281();
    private static final Set<String> iwh = new HashSet();

    /* renamed from: com.tencent.mm.plugin.appbrand.permission.b$1 */
    static class C24281 extends SparseIntArray {
        C24281() {
        }

        public final int get(int i) {
            AppMethodBeat.m2504i(132505);
            int i2 = super.get(i, C25738R.string.f8939k1);
            AppMethodBeat.m2505o(132505);
            return i2;
        }
    }

    static {
        AppMethodBeat.m2504i(132508);
        iwg.put(C19410e.NAME.hashCode(), C25738R.string.f8935jx);
        iwg.put(C38323g.NAME.hashCode(), C25738R.string.f8935jx);
        iwg.put(JsApiStartPlayVoice.NAME.hashCode(), C25738R.string.f8936jy);
        iwg.put(JsApiOperateMusicPlayer.NAME.hashCode(), C25738R.string.f8936jy);
        iwg.put(C27077c.NAME.hashCode(), C25738R.string.f8937jz);
        iwg.put(C19613a.NAME.hashCode(), C25738R.string.f8937jz);
        iwg.put(C42568d.NAME.hashCode(), C25738R.string.f8937jz);
        iwg.put(C42571f.NAME.hashCode(), C25738R.string.f8937jz);
        iwg.put(C27207a.NAME.hashCode(), C25738R.string.f8937jz);
        iwg.put(JsApiLaunchMiniProgram.NAME.hashCode(), C25738R.string.f8934jw);
        iwh.add(C19410e.NAME);
        iwh.add(C38323g.NAME);
        iwh.add(JsApiStartPlayVoice.NAME);
        iwh.add(JsApiOperateMusicPlayer.NAME);
        iwh.add(C27077c.NAME);
        iwh.add(C19613a.NAME);
        iwh.add(C42568d.NAME);
        iwh.add(C42571f.NAME);
        iwh.add(C27207a.NAME);
        iwh.add(JsApiLaunchMiniProgram.NAME);
        iwh.add(JsApiMakeVoIPCall.NAME);
        iwh.add(C42464aa.NAME);
        iwh.add(C33279c.NAME);
        iwh.add(C2206au.NAME);
        iwh.add(C33246ax.NAME);
        iwh.add(C45579bb.NAME);
        iwh.add(C38269bc.NAME);
        iwh.add(C45580bd.NAME);
        iwh.add(C38271be.NAME);
        iwh.add(C42558b.NAME);
        iwh.add(C42559c.NAME);
        AppMethodBeat.m2505o(132508);
    }

    /* renamed from: k */
    static void m65118k(final C6750i c6750i, String str) {
        AppMethodBeat.m2504i(132507);
        if (c6750i == null || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(132507);
            return;
        }
        String string = C4996ah.getResources().getString(iwg.get(str.hashCode()));
        string = C4996ah.getResources().getString(C25738R.string.f8938k0, new Object[]{string});
        C45673m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(132506);
                C38470q asV = c6750i.asV();
                if (asV != null) {
                    C19640n currentPage = asV.getCurrentPage();
                    if (currentPage != null) {
                        C44709u currentPageView = currentPage.getCurrentPageView();
                        if (currentPageView != null) {
                            C42728b c42728b = currentPageView.isS;
                            String str = string;
                            if (c42728b.jmB.aBk() == null || c42728b.jmB.mContext == null) {
                                AppMethodBeat.m2505o(132506);
                                return;
                            }
                            if (c42728b.jmC == null) {
                                c42728b.jmC = new C42725a(c42728b.jmB.mContext);
                                c42728b.jmC.mo35078a(c42728b.jmB.aBk());
                            }
                            c42728b.jmB.aBk().bringChildToFront(c42728b.jmC.getView());
                            c42728b.jmC.mo35077EQ(str);
                        }
                    }
                }
                AppMethodBeat.m2505o(132506);
            }
        });
        AppMethodBeat.m2505o(132507);
    }
}
