package com.tencent.p177mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p232b.p233a.C46882cf;
import com.tencent.p177mm.p230g.p232b.p233a.C46882cf.C26283c;
import com.tencent.p177mm.p230g.p232b.p233a.C46882cf.C9510b;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e.C45513b;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p883c.C19050a;
import com.tencent.p177mm.plugin.appbrand.config.C42406r;
import com.tencent.p177mm.plugin.appbrand.config.C42406r.C38170b;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.jsapi.version.C42591a;
import com.tencent.p177mm.plugin.appbrand.report.quality.C2453g;
import com.tencent.p177mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.i */
final class C45639i {
    final QualitySession hgN;
    final int hgQ;
    final WxaAttributes igX;
    final C27172a igY;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.i$a */
    public interface C27172a {
        /* renamed from: b */
        void mo6249b(C42591a c42591a);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.i$2 */
    class C412392 implements C38170b<WxaAttributes> {
        final /* synthetic */ String eiH;
        final /* synthetic */ long iha;

        C412392(String str, long j) {
            this.eiH = str;
            this.iha = j;
        }

        /* renamed from: f */
        public final /* synthetic */ void mo5935f(int i, Object obj) {
            AppMethodBeat.m2504i(131812);
            WxaAttributes wxaAttributes = (WxaAttributes) obj;
            if (wxaAttributes == null) {
                C4990ab.m7413e("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", "onGetContact with username(%s) maybeNew == NULL", this.eiH);
                try {
                    C45639i.this.igY.mo6249b(C42591a.NO_UPDATE);
                    AppMethodBeat.m2505o(131812);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", e, "onGetContact with username(%s) maybeNew == NULL", this.eiH);
                    AppMethodBeat.m2505o(131812);
                }
            } else if (wxaAttributes.ayL() == null) {
                String format = String.format(Locale.US, "onGetContact with username(%s), maybeNew.versionInfo == NULL", new Object[]{this.eiH});
                C4990ab.m7412e("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", format);
                try {
                    C45639i.this.igY.mo6249b(C42591a.NO_UPDATE);
                    AppMethodBeat.m2505o(131812);
                } catch (Exception e2) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", e2, format, new Object[0]);
                    AppMethodBeat.m2505o(131812);
                }
            } else {
                C4990ab.m7417i("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", "[appversion] onGetContact(%s), result %d, maybeNew.ver %d", this.eiH, Integer.valueOf(i), Integer.valueOf(wxaAttributes.ayL().axy));
                switch (i) {
                    case 2:
                    case 3:
                        C26283c c26283c;
                        long anU = C5046bo.anU();
                        C46882cf ea = C2453g.m4693a(C45639i.this.hgN).mo76066ec(this.iha).mo76067ed(anU).mo76064ea(anU - this.iha);
                        if (i == 2) {
                            c26283c = C26283c.ok;
                        } else {
                            c26283c = C26283c.common_fail;
                        }
                        ea.dfE = c26283c;
                        ea.dfF = C9510b.async;
                        ea.cXm = (long) C2453g.getNetworkType();
                        ea.ajK();
                        break;
                }
                WxaAttributes wxaAttributes2 = C45639i.this.igX;
                if (wxaAttributes.ayL().bQl != 0) {
                    C45639i.this.igY.mo6249b(C42591a.NO_UPDATE);
                    AppMethodBeat.m2505o(131812);
                } else if (wxaAttributes2.ayL().axy >= wxaAttributes.ayL().axy) {
                    C45639i.this.igY.mo6249b(C42591a.NO_UPDATE);
                    AppMethodBeat.m2505o(131812);
                } else {
                    WxaPkgWrappingInfo azZ;
                    C42591a c42591a;
                    C45639i.this.igY.mo6249b(C42591a.UPDATING);
                    try {
                        azZ = new C19559ai(wxaAttributes.field_appId, 0, "", C45639i.this.hgQ, wxaAttributes).azZ();
                    } catch (Exception e22) {
                        C4990ab.m7413e("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", "%s, prepare pkg exp = %s", wxaAttributes.field_appId, e22);
                        azZ = null;
                    }
                    C27172a c27172a = C45639i.this.igY;
                    if (azZ == null) {
                        c42591a = C42591a.UPDATE_FAILED;
                    } else {
                        c42591a = C42591a.UPDATE_READY;
                    }
                    c27172a.mo6249b(c42591a);
                    AppMethodBeat.m2505o(131812);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.i$1 */
    class C456381 implements Runnable {
        C456381() {
        }

        public final void run() {
            AppMethodBeat.m2504i(131811);
            C45639i c45639i = C45639i.this;
            C45513b c45513b = (C45513b) C42340f.m74878E(C45513b.class);
            String str = c45639i.igX.field_username;
            Pair x = c45513b.mo73325x(str, 1, c45639i.hgQ);
            if (((Boolean) x.first).booleanValue()) {
                C4990ab.m7417i("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", "sync blocked with username(%s) scene(%d)", str, Integer.valueOf(c45639i.hgQ));
                C19050a c19050a = C19050a.gWl;
                C19050a.m29623z((long) ((Integer) x.second).intValue(), 164);
                AppMethodBeat.m2505o(131811);
                return;
            }
            C4990ab.m7417i("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", "[appversion] start() username %s, scene %d", str, Integer.valueOf(c45639i.hgQ));
            C42406r.m75072a(c45639i.igX.field_username, true, new C412392(str, C5046bo.anU()));
            AppMethodBeat.m2505o(131811);
        }
    }

    C45639i(String str, int i, C27172a c27172a, QualitySession qualitySession) {
        AppMethodBeat.m2504i(131813);
        this.hgQ = i;
        this.igX = C42340f.auO().mo21572d(str, new String[0]);
        this.igY = c27172a;
        this.hgN = qualitySession;
        if (this.igX == null) {
            C4990ab.m7413e("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", " <init> get NULL record by username %s", str);
        }
        AppMethodBeat.m2505o(131813);
    }
}
