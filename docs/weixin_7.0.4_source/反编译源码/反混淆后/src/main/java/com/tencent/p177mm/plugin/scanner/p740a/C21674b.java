package com.tencent.p177mm.plugin.scanner.p740a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C26102cf;
import com.tencent.p177mm.p230g.p231a.C41964am;
import com.tencent.p177mm.p230g.p231a.C42019kv;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.scanner.util.C13175a;
import com.tencent.p177mm.plugin.scanner.util.C13175a.C131761;
import com.tencent.p177mm.plugin.scanner.util.C28923r;
import com.tencent.p177mm.plugin.scanner.util.C46189e;
import com.tencent.p177mm.plugin.scanner.util.C46189e.C21729a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.scanner.a.b */
public final class C21674b {
    Activity mActivity;
    String pZu;
    C46189e pZv;
    C13175a pZw;
    C21729a pZx = new C216751();
    public C4884c pZy = new C131162();
    public C4884c pZz = new C216763();

    /* renamed from: com.tencent.mm.plugin.scanner.a.b$2 */
    class C131162 extends C4884c<C26102cf> {
        C131162() {
            AppMethodBeat.m2504i(80825);
            this.xxI = C26102cf.class.getName().hashCode();
            AppMethodBeat.m2505o(80825);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            int i = 2;
            AppMethodBeat.m2504i(80826);
            C26102cf c26102cf = (C26102cf) c4883b;
            if (c26102cf == null || !(c26102cf instanceof C26102cf)) {
                C4990ab.m7412e("MicroMsg.ExternRequestDealQBarStrHandler", "event is null or not a DealQBarStrEvent instance");
            } else {
                C21674b.this.cgE();
                C21674b.this.pZu = c26102cf.cvm.ctB;
                C21674b.this.mActivity = c26102cf.cvm.activity;
                C4990ab.m7417i("MicroMsg.ExternRequestDealQBarStrHandler", "request deal qbar, activity:%s, str:%s, codeType: %s, codeVersion: %s, from : %d", C21674b.this.mActivity, C21674b.this.pZu, Integer.valueOf(c26102cf.cvm.cvn), Integer.valueOf(c26102cf.cvm.cvo), Integer.valueOf(c26102cf.cvm.from));
                if (c26102cf.cvm.cvn == 19 || c26102cf.cvm.cvn == 22) {
                    C21674b.this.pZv = new C46189e();
                    C21674b.this.pZv.cvp = c26102cf.cvm.cvp;
                    C21674b.this.pZv.imagePath = c26102cf.cvm.imagePath;
                    C21674b.this.pZv.cvr = c26102cf.cvm.cvr;
                    C21674b.this.pZv.source = c26102cf.cvm.source;
                    if (c26102cf.cvm.from >= 0) {
                        i = 3;
                    }
                    if (c26102cf.cvm.scene > 0) {
                        C21674b.this.pZv.jSW = c26102cf.cvm.scene;
                    }
                    if (i == 3) {
                        C21674b.this.pZv.appId = c26102cf.cvm.cvq;
                    }
                    C21674b.this.pZv.mo74179a(C21674b.this.mActivity, C21674b.this.pZu, i, c26102cf.cvm.cvn, c26102cf.cvm.cvo, C21674b.this.pZx, c26102cf.cvm.cvs);
                } else {
                    C21674b.this.pZw = new C13175a();
                    C1202f c1202f = C21674b.this.pZw;
                    Context context = C21674b.this.mActivity;
                    String str = C21674b.this.pZu;
                    int i2 = c26102cf.cvm.cvn;
                    int i3 = c26102cf.cvm.cvo;
                    Bundle bundle = c26102cf.cvm.cvs;
                    if (!C5046bo.isNullOrNil(str)) {
                        String[] split = str.split(",");
                        if (split == null || split.length < 2) {
                            C4990ab.m7412e("MicroMsg.BarcodeStringHandler", "wrong zbar format");
                        } else {
                            c1202f.czX = context;
                            c1202f.cvs = bundle;
                            C1207m c43483g = new C43483g(C28923r.m45942Ws(split[0]), split[1], i2, i3);
                            C1720g.m3540Rg().mo14539a((int) FilterEnum4Shaka.MIC_WEISHI_QINSHUI, c1202f);
                            C1720g.m3540Rg().mo14541a(c43483g, 0);
                            context.getString(C25738R.string.f9238tz);
                            c1202f.ehJ = C30379h.m48458b(context, context.getString(C25738R.string.dgn), true, new C131761(c43483g));
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(80826);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.a.b$1 */
    class C216751 implements C21729a {
        C216751() {
        }

        /* renamed from: o */
        public final void mo8437o(int i, Bundle bundle) {
            AppMethodBeat.m2504i(80824);
            C4990ab.m7417i("MicroMsg.ExternRequestDealQBarStrHandler", "Deal QBar String notify, id:%d", Integer.valueOf(i));
            C42019kv c42019kv = new C42019kv();
            c42019kv.cGM.cGK = i;
            c42019kv.cGM.activity = C21674b.this.mActivity;
            c42019kv.cGM.ctB = C21674b.this.pZu;
            c42019kv.cGM.cGN = bundle;
            C4879a.xxA.mo10055m(c42019kv);
            AppMethodBeat.m2505o(80824);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.a.b$3 */
    class C216763 extends C4884c<C41964am> {
        C216763() {
            AppMethodBeat.m2504i(80827);
            this.xxI = C41964am.class.getName().hashCode();
            AppMethodBeat.m2505o(80827);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(80828);
            C41964am c41964am = (C41964am) c4883b;
            if (c41964am == null || !(c41964am instanceof C41964am)) {
                C4990ab.m7412e("MicroMsg.ExternRequestDealQBarStrHandler", "event is null or not a CancelDealQBarStrEvent instance");
                AppMethodBeat.m2505o(80828);
            } else {
                C4990ab.m7417i("MicroMsg.ExternRequestDealQBarStrHandler", "cancel deal qbar, activity:%s, str:%s", C21674b.this.mActivity, C21674b.this.pZu);
                if (c41964am.ctA.activity == C21674b.this.mActivity && c41964am.ctA.ctB.equals(C21674b.this.pZu)) {
                    C21674b.this.cgE();
                    AppMethodBeat.m2505o(80828);
                } else {
                    C4990ab.m7412e("MicroMsg.ExternRequestDealQBarStrHandler", "not same as string that are dealing");
                    AppMethodBeat.m2505o(80828);
                }
            }
            return false;
        }
    }

    public C21674b() {
        AppMethodBeat.m2504i(80829);
        AppMethodBeat.m2505o(80829);
    }

    public final void cgE() {
        AppMethodBeat.m2504i(80830);
        if (this.pZv != null) {
            this.pZv.chU();
            this.pZv = null;
        }
        this.mActivity = null;
        this.pZu = null;
        AppMethodBeat.m2505o(80830);
    }
}
