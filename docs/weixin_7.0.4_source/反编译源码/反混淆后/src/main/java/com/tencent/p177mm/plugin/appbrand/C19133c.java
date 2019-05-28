package com.tencent.p177mm.plugin.appbrand;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10332b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c.C2242a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c.C2243b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.p281b.C10136c;
import com.tencent.p177mm.plugin.appbrand.p281b.C45524b;
import com.tencent.p177mm.plugin.appbrand.permission.C31331g;
import com.tencent.p177mm.plugin.appbrand.permission.C33491e;
import com.tencent.p177mm.plugin.appbrand.permission.C33491e.C33493a;
import com.tencent.p177mm.plugin.appbrand.permission.C33491e.C33494b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5047bp;

/* renamed from: com.tencent.mm.plugin.appbrand.c */
public class C19133c implements C2243b {
    private final C6750i gMH;
    private final C33491e gMI;
    final C2241c gMJ;

    public C19133c(C6750i c6750i, C2241c c2241c, C33491e c33491e) {
        this.gMH = c6750i;
        this.gMJ = c2241c;
        this.gMI = c33491e;
    }

    /* renamed from: D */
    public void mo6120D(int i, String str) {
    }

    /* renamed from: a */
    public boolean mo6123a(final C45608m c45608m, String str, int i, final C2242a c2242a) {
        AppMethodBeat.m2504i(101710);
        C33493a a = this.gMI.mo53977a(this.gMJ, (C10332b) c45608m, str, new C33494b() {
            /* renamed from: a */
            public final void mo5871a(C33493a c33493a) {
                AppMethodBeat.m2504i(101709);
                if (C19133c.this.gMJ == null || !C19133c.this.gMJ.isRunning()) {
                    AppMethodBeat.m2505o(101709);
                } else if (c33493a.ret == 0) {
                    c2242a.proceed();
                    AppMethodBeat.m2505o(101709);
                } else {
                    String str;
                    if (TextUtils.isEmpty(c33493a.bzH)) {
                        str = "fail:internal error";
                    } else {
                        str = c33493a.bzH;
                    }
                    c2242a.mo6118AH(c45608m.mo73394j(str, null));
                    AppMethodBeat.m2505o(101709);
                }
            }
        });
        if (-2 == a.ret) {
            AppMethodBeat.m2505o(101710);
            return true;
        } else if (a.ret != 0) {
            c2242a.mo6118AH(c45608m.mo73394j(a.bzH, null));
            AppMethodBeat.m2505o(101710);
            return true;
        } else {
            AppMethodBeat.m2505o(101710);
            return false;
        }
    }

    /* renamed from: a */
    public void mo6122a(C45608m c45608m, String str, int i, String str2) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005e A:{Catch:{ NullPointerException -> 0x00f7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029 A:{Catch:{ NullPointerException -> 0x00f7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0060 A:{Catch:{ NullPointerException -> 0x00f7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c A:{Catch:{ NullPointerException -> 0x00f7 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo6121a(C42467ah c42467ah, C2242a c2242a) {
        AppMethodBeat.m2504i(101711);
        C10136c c10136c = null;
        try {
            int i;
            C10136c c10136c2;
            int i2;
            if (this.gMH != null) {
                c10136c = this.gMH.gNN;
                if (c10136c != null) {
                    i = 1;
                    c10136c2 = c10136c;
                    if (!(i == 0 || c10136c2.gWy.gWG.get())) {
                        if (this.gMJ.isRunning()) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        boolean z;
                        if (i2 == 0) {
                            C4990ab.m7413e("MicroMsg.AppBrandComponentInterceptor", "onDispatch, event[%s], appId[%s], runtimeStopped[%b], envStopped[%b]", c42467ah.getName(), this.gMJ.getAppId(), Boolean.valueOf(z), Boolean.TRUE);
                            AppMethodBeat.m2505o(101711);
                            return;
                        }
                        C33491e c33491e = this.gMI;
                        boolean z2 = c10136c2.gWy.awz() == C45524b.SUSPEND;
                        boolean a = c33491e.mo53979a(this.gMJ, (C10332b) c42467ah);
                        if (z2 || a) {
                            z = true;
                        } else {
                            z = false;
                        }
                        C31331g c31331g = (C31331g) this.gMJ.mo5936B(C31331g.class);
                        if (c31331g == null || !c31331g.mo51294a(c42467ah)) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        if (i2 != 0) {
                            int a2 = c33491e.mo53976a(this.gMJ, (C10332b) c42467ah, null, false);
                            C4990ab.m7417i("MicroMsg.AppBrandComponentInterceptor", "dispatchToService, canSend %B, event %s, index %d, suspend %b, hasPermission %b", Boolean.valueOf(z), c42467ah.getName(), Integer.valueOf(a2), Boolean.valueOf(z2), Boolean.valueOf(a));
                            if (i2 != 0 && C5047bp.dpJ()) {
                                C4990ab.m7411d("MicroMsg.AppBrandComponentInterceptor", "dispatchToAutoTest, event %s, data %s, ", c42467ah.getName(), c42467ah.getData());
                            }
                        }
                        if (z) {
                            c2242a.proceed();
                        }
                    }
                    AppMethodBeat.m2505o(101711);
                    return;
                }
            }
            i = 0;
            c10136c2 = c10136c;
            if (this.gMJ.isRunning()) {
            }
            if (i2 == 0) {
            }
        } catch (NullPointerException e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandComponentInterceptor", e, "onDispatchImpl %s", c42467ah.getName());
            AppMethodBeat.m2505o(101711);
        }
    }
}
