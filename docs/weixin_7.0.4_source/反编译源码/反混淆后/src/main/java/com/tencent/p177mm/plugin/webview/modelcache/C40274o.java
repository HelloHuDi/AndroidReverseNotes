package com.tencent.p177mm.plugin.webview.modelcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p230g.p231a.C18431vn;
import com.tencent.p177mm.p230g.p231a.C37694bo;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.webview.modelcache.o */
public final class C40274o {
    public final C1837a unU = new C145231();
    public final C4884c unV = new C356172();
    public final C4884c unW = new C145243();

    /* renamed from: com.tencent.mm.plugin.webview.modelcache.o$1 */
    class C145231 implements C1837a {
        C145231() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(6858);
            C7254cm c7254cm = c1197a.eAB;
            if (c7254cm.vED == null) {
                AppMethodBeat.m2505o(6858);
            } else if (C5046bo.isNullOrNil(C1946aa.m4148a(c7254cm.vED))) {
                AppMethodBeat.m2505o(6858);
            } else {
                C29824c.cYm();
                C4990ab.m7410d("MicroMsg.WebViewCacheSubCoreToolsExtension", "can not do brand pre-push");
                AppMethodBeat.m2505o(6858);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modelcache.o$3 */
    class C145243 extends C4884c<C37694bo> {
        C145243() {
            AppMethodBeat.m2504i(6861);
            this.xxI = C37694bo.class.getName().hashCode();
            AppMethodBeat.m2505o(6861);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(6862);
            C37694bo c37694bo = (C37694bo) c4883b;
            if (c37694bo == null || !(c37694bo instanceof C37694bo)) {
                AppMethodBeat.m2505o(6862);
            } else {
                if (C4996ah.getContext() != null) {
                    C45287c.atD("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                }
                C5730e.m8618N(C6457e.evd, true);
                WebViewCacheDownloadHelper.cYs();
                AppMethodBeat.m2505o(6862);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modelcache.o$2 */
    class C356172 extends C4884c<C18431vn> {
        C356172() {
            AppMethodBeat.m2504i(6859);
            this.xxI = C18431vn.class.getName().hashCode();
            AppMethodBeat.m2505o(6859);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(6860);
            C18431vn c18431vn = (C18431vn) c4883b;
            if (c18431vn == null || !(c18431vn instanceof C18431vn)) {
                AppMethodBeat.m2505o(6860);
            } else if (C5046bo.isNullOrNil(c18431vn.cSA.cHz)) {
                AppMethodBeat.m2505o(6860);
            } else {
                C29824c.cYm();
                C4990ab.m7410d("MicroMsg.WebViewCacheSubCoreToolsExtension", "can not do brand pre-push");
                AppMethodBeat.m2505o(6860);
            }
            return false;
        }
    }

    public C40274o() {
        AppMethodBeat.m2504i(6863);
        AppMethodBeat.m2505o(6863);
    }
}
