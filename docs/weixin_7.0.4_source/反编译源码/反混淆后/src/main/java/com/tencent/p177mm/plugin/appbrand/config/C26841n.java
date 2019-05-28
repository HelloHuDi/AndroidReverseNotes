package com.tencent.p177mm.plugin.appbrand.config;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p217ci.C37654f;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.config.C33138j.C33137a;
import com.tencent.p177mm.plugin.appbrand.config.C42406r.C38170b;
import com.tencent.p177mm.plugin.appbrand.service.C42686d;
import com.tencent.p177mm.plugin.appbrand.service.C42686d.C38509a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p641g.C7582e;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.config.n */
public final class C26841n implements C42686d {
    /* renamed from: zb */
    public final WxaAttributes mo44618zb(String str) {
        AppMethodBeat.m2504i(129876);
        WxaAttributes d = C42340f.auO().mo21572d(str, new String[0]);
        AppMethodBeat.m2505o(129876);
        return d;
    }

    /* renamed from: zc */
    public final WxaAttributes mo44619zc(String str) {
        AppMethodBeat.m2504i(129877);
        WxaAttributes e = C42340f.auO().mo21573e(str, new String[0]);
        AppMethodBeat.m2505o(129877);
        return e;
    }

    /* renamed from: a */
    public final void mo44615a(String str, final C38509a c38509a) {
        AppMethodBeat.m2504i(129878);
        C42406r.m75072a(str, false, new C38170b<WxaAttributes>() {
            /* renamed from: f */
            public final /* synthetic */ void mo5935f(int i, Object obj) {
                AppMethodBeat.m2504i(129870);
                WxaAttributes wxaAttributes = (WxaAttributes) obj;
                if (c38509a != null) {
                    c38509a.mo21701d(wxaAttributes);
                }
                AppMethodBeat.m2505o(129870);
            }
        });
        AppMethodBeat.m2505o(129878);
    }

    /* renamed from: zd */
    public final C7582e<WxaAttributes> mo44620zd(final String str) {
        AppMethodBeat.m2504i(129879);
        C37654f b = C41930g.m74067da(str).mo60487b(new C5681a<WxaAttributes, String>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(129872);
                final C5688b dMo = C5698f.dMo();
                C42406r.m75072a(str, false, new C38170b<WxaAttributes>() {
                    /* renamed from: f */
                    public final /* synthetic */ void mo5935f(int i, Object obj) {
                        AppMethodBeat.m2504i(129871);
                        WxaAttributes wxaAttributes = (WxaAttributes) obj;
                        dMo.mo11581B(wxaAttributes);
                        AppMethodBeat.m2505o(129871);
                    }
                });
                AppMethodBeat.m2505o(129872);
                return null;
            }
        });
        AppMethodBeat.m2505o(129879);
        return b;
    }

    /* renamed from: b */
    public final void mo44617b(final String str, final C38509a c38509a) {
        AppMethodBeat.m2504i(129880);
        if (C5046bo.isNullOrNil(str)) {
            if (c38509a != null) {
                c38509a.mo21701d(null);
            }
            AppMethodBeat.m2505o(129880);
            return;
        }
        final C5004al c5004al = new C5004al();
        new C7306ak(c5004al.oAl.getLooper()).post(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.appbrand.config.n$3$2 */
            class C101812 implements IdleHandler {
                C101812() {
                }

                public final boolean queueIdle() {
                    AppMethodBeat.m2504i(129874);
                    c5004al.oAl.quit();
                    AppMethodBeat.m2505o(129874);
                    return false;
                }
            }

            /* renamed from: com.tencent.mm.plugin.appbrand.config.n$3$1 */
            class C101821 implements C38170b<WxaAttributes> {
                C101821() {
                }

                /* renamed from: f */
                public final /* synthetic */ void mo5935f(int i, Object obj) {
                    AppMethodBeat.m2504i(129873);
                    WxaAttributes wxaAttributes = (WxaAttributes) obj;
                    if (c38509a != null) {
                        c38509a.mo21701d(wxaAttributes);
                    }
                    AppMethodBeat.m2505o(129873);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(129875);
                if (C1720g.m3534RN().mo5161QY()) {
                    if (C42406r.m75077zr(str)) {
                        C42406r.m75072a(str, false, new C101821());
                    } else if (c38509a != null) {
                        c38509a.mo21701d(C26841n.this.mo44618zb(str));
                    }
                    Looper.myQueue().addIdleHandler(new C101812());
                    AppMethodBeat.m2505o(129875);
                    return;
                }
                if (c38509a != null) {
                    c38509a.mo21701d(null);
                }
                AppMethodBeat.m2505o(129875);
            }
        });
        AppMethodBeat.m2505o(129880);
    }

    /* renamed from: aE */
    public final void mo44616aE(List<String> list) {
        AppMethodBeat.m2504i(129881);
        if (C5046bo.m7548ek(list)) {
            AppMethodBeat.m2505o(129881);
            return;
        }
        C4990ab.m7417i("MicroMsg.AppBrand.WxaAttrExportService", "batchSync list %s", C5046bo.m7536c((List) list, ", "));
        C42406r.m75073a(list, C33137a.WXA_CUSTOMER_SERVICE);
        AppMethodBeat.m2505o(129881);
    }
}
