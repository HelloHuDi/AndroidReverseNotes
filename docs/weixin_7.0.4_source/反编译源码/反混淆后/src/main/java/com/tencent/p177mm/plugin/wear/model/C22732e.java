package com.tencent.p177mm.plugin.wear.model;

import android.app.KeyguardManager;
import android.os.Looper;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.blink.C1314b;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.p230g.p231a.C37781pe;
import com.tencent.p177mm.p230g.p231a.C42073vg;
import com.tencent.p177mm.p230g.p231a.C45379vj;
import com.tencent.p177mm.p230g.p231a.C6504k;
import com.tencent.p177mm.p230g.p231a.C6512kz;
import com.tencent.p177mm.p230g.p231a.C6513ls;
import com.tencent.p177mm.p230g.p231a.C6541qc;
import com.tencent.p177mm.p230g.p231a.C9405ks;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3457a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3460c;
import com.tencent.p177mm.plugin.wear.model.p575e.C40185r;
import com.tencent.p177mm.plugin.wear.model.p576f.C14414i;
import com.tencent.p177mm.plugin.wear.model.p576f.C29724c;
import com.tencent.p177mm.plugin.wear.model.p576f.C29725j;
import com.tencent.p177mm.plugin.wear.model.p576f.C31470a;
import com.tencent.p177mm.plugin.wear.model.p576f.C40187e;
import com.tencent.p177mm.plugin.wear.model.p576f.C40188g;
import com.tencent.p177mm.plugin.wear.model.p576f.C4508k;
import com.tencent.p177mm.plugin.wear.model.p576f.C4509l;
import com.tencent.p177mm.plugin.wear.model.p576f.C46396f;
import com.tencent.p177mm.plugin.wear.model.p576f.C46397h;
import com.tencent.p177mm.protocal.protobuf.cpm;
import com.tencent.p177mm.protocal.protobuf.ctv;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.wear.model.e */
public final class C22732e {
    C4884c edy = new C2273811();
    C7564ap gyS = new C7564ap(Looper.getMainLooper(), new C227407(), true);
    C4884c ilT = new C227396();
    C3457a lPn = new C227332();
    C4884c nZv = new C144063();
    C4884c ryO = new C227351();
    private PowerManager tXN;
    private KeyguardManager tXO;
    C4884c tXP = new C227344();
    C4884c tXQ = new C144075();
    C4884c tXR = new C227368();
    C4884c tXS = new C227419();
    C4884c tXT = new C2273710();

    /* renamed from: com.tencent.mm.plugin.wear.model.e$3 */
    class C144063 extends C4884c<C42073vg> {
        C144063() {
            AppMethodBeat.m2504i(26299);
            this.xxI = C42073vg.class.getName().hashCode();
            AppMethodBeat.m2505o(26299);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(26300);
            C42073vg c42073vg = (C42073vg) c4883b;
            switch (c42073vg.cSe.action) {
                case 2:
                    C43841a.cUn().tXz.mo69532a(new C46397h(c42073vg.cSf.cuQ, c42073vg.cSf.cSh, c42073vg.cSf.cSi, c42073vg.cSf.cSj));
                    break;
                case 4:
                    if (C26373g.m41964Nu().getInt("WearPayBlock", 0) == 0) {
                        C43841a.cUn().tXz.mo69532a(new C4508k(c42073vg.cSe.cSg, c42073vg.cSe.content));
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(26300);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.e$5 */
    class C144075 extends C4884c<C6513ls> {
        C144075() {
            AppMethodBeat.m2504i(26304);
            this.xxI = C6513ls.class.getName().hashCode();
            AppMethodBeat.m2505o(26304);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(26305);
            final C6513ls c6513ls = (C6513ls) c4883b;
            C1314b.m2812HQ().mo4642o(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(26303);
                    C43841a.cUn().tXv.ads(c6513ls.cHA.talker);
                    C22742f adr = C43841a.cUn().tXv.adr(c6513ls.cHA.talker);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Integer.valueOf(adr.f4403id));
                    C43841a.cUn().tXz.mo69532a(new C14414i(arrayList));
                    if (c6513ls.cHA.talker.equals("gh_43f2581f6fd6")) {
                        ctv ctv = C43841a.cUn().tXt.tXK.tYz;
                        if (ctv != null) {
                            Object obj;
                            C43842b c43842b = C43841a.cUn().tXw;
                            if (ctv != null && c43842b.tXD && C43842b.adq(ctv.xqs)) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj != null) {
                                C43841a.cUn();
                                C43842b.m78623a(ctv);
                                AppMethodBeat.m2505o(26303);
                                return;
                            }
                            C43841a.cUn().tXw.connect();
                        }
                    }
                    AppMethodBeat.m2505o(26303);
                }
            });
            AppMethodBeat.m2505o(26305);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.e$2 */
    class C227332 implements C3457a {

        /* renamed from: com.tencent.mm.plugin.wear.model.e$2$1 */
        class C227301 extends C29724c {
            C227301() {
            }

            public final String getName() {
                return "SendMsgSyncTask";
            }

            public final void send() {
                AppMethodBeat.m2504i(26297);
                try {
                    C43841a.cUn();
                    C40185r.m68920b(20007, C43841a.cUn().tXt.tXL.tYA.getBytes("utf8"), false);
                    AppMethodBeat.m2505o(26297);
                } catch (UnsupportedEncodingException e) {
                    AppMethodBeat.m2505o(26297);
                }
            }
        }

        C227332() {
        }

        /* renamed from: a */
        public final void mo7913a(C6977h c6977h, C3460c c3460c) {
            AppMethodBeat.m2504i(26298);
            if (c3460c == null) {
                AppMethodBeat.m2505o(26298);
                return;
            }
            if (c3460c.oqM > 0 && C43841a.cUn().tXt.tXL.tYA.equals(c3460c.talker)) {
                C43841a.cUn().tXz.mo69532a(new C227301());
            }
            AppMethodBeat.m2505o(26298);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.e$4 */
    class C227344 extends C4884c<C6504k> {
        C227344() {
            AppMethodBeat.m2504i(26301);
            this.xxI = C6504k.class.getName().hashCode();
            AppMethodBeat.m2505o(26301);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(26302);
            if (((C6504k) c4883b).csh.csi) {
                C43841a.cUn().tXz.mo69532a(new C14414i());
            }
            AppMethodBeat.m2505o(26302);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.e$1 */
    class C227351 extends C4884c<C9405ks> {
        C227351() {
            AppMethodBeat.m2504i(26295);
            this.xxI = C9405ks.class.getName().hashCode();
            AppMethodBeat.m2505o(26295);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(26296);
            C9405ks c9405ks = (C9405ks) c4883b;
            if (C22732e.m34514a(C22732e.this) && !"gh_3dfda90e39d6".equals(c9405ks.cGF.talker)) {
                C9638aw.m17190ZK();
                C7620bi Rb = C18628c.m29080XO().mo15248Rb(c9405ks.cGF.talker);
                boolean z = Rb != null ? C26373g.m41964Nu().getInt("WearLuckyBlock", 0) == 0 && (Rb.dtp() || Rb.dtq()) : false;
                if (z) {
                    C43841a.cUn().tXz.mo69532a(new C40188g(Rb));
                    if (c9405ks.cGF.csm > 1) {
                        C22732e.m34515s(c9405ks.cGF.talker, c9405ks.cGF.csm, false);
                    }
                } else {
                    C22732e.m34515s(c9405ks.cGF.talker, c9405ks.cGF.csm, true);
                }
            }
            AppMethodBeat.m2505o(26296);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.e$8 */
    class C227368 extends C4884c<C45379vj> {
        C227368() {
            super(0);
            AppMethodBeat.m2504i(26310);
            this.xxI = C45379vj.class.getName().hashCode();
            AppMethodBeat.m2505o(26310);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(26311);
            switch (((C45379vj) c4883b).cSr.cuy) {
                case 5:
                    C43841a.cUn().tXz.mo69532a(new C4509l(20011, ""));
                    break;
                case 6:
                case 7:
                    C43841a.cUn().tXz.mo69532a(new C4509l(20012, ""));
                    break;
            }
            AppMethodBeat.m2505o(26311);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.e$10 */
    class C2273710 extends C4884c<C6541qc> {
        C2273710() {
            AppMethodBeat.m2504i(26314);
            this.xxI = C6541qc.class.getName().hashCode();
            AppMethodBeat.m2505o(26314);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(26315);
            if (C22732e.m34514a(C22732e.this)) {
                C43841a.cUn().tXz.mo69532a(new C40187e());
            }
            AppMethodBeat.m2505o(26315);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.e$11 */
    class C2273811 extends C4884c<C37781pe> {
        C2273811() {
            AppMethodBeat.m2504i(26316);
            this.xxI = C37781pe.class.getName().hashCode();
            AppMethodBeat.m2505o(26316);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(26317);
            C37781pe c37781pe = (C37781pe) c4883b;
            if (C22732e.m34514a(C22732e.this)) {
                C9638aw.m17190ZK();
                C7617ak aoZ = C18628c.m29083XR().aoZ(c37781pe.cLt.cKd.field_talker);
                if (aoZ != null) {
                    int i = aoZ.field_unReadCount;
                    C22742f adr = C43841a.cUn().tXv.adr(c37781pe.cLt.cKd.field_talker);
                    if (i - adr.tYc > 0) {
                        C22732e.m34515s(c37781pe.cLt.cKd.field_talker, i, false);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(Integer.valueOf(adr.f4403id));
                        C43841a.cUn().tXz.mo69532a(new C14414i(arrayList));
                    }
                }
            }
            AppMethodBeat.m2505o(26317);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.e$6 */
    class C227396 extends C4884c<C26250ui> {
        C227396() {
            AppMethodBeat.m2504i(26306);
            this.xxI = C26250ui.class.getName().hashCode();
            AppMethodBeat.m2505o(26306);
        }

        /* renamed from: a */
        private static boolean m34522a(C26250ui c26250ui) {
            AppMethodBeat.m2504i(26307);
            switch (c26250ui.cQx.cAd) {
                case 3:
                    byte[] bArr = c26250ui.cQx.cQr;
                    if (bArr != null && bArr.length >= 10 && bArr[0] == (byte) 1) {
                        cpm cpm;
                        byte[] bArr2 = new byte[(bArr.length - 1)];
                        System.arraycopy(bArr, 1, bArr2, 0, bArr2.length);
                        try {
                            cpm = (cpm) new cpm().parseFrom(bArr2);
                        } catch (IOException e) {
                            cpm = null;
                        }
                        if (cpm != null) {
                            String str = cpm.xmT;
                            int i = cpm.xmL;
                            C4990ab.m7417i("MicroMsg.Wear.WearLogic", "voip invite talker=%s | type=%s", str, Integer.valueOf(i));
                            C43841a.cUn().tXz.mo69532a(new C4509l(20010, str));
                            break;
                        }
                    }
                    break;
            }
            AppMethodBeat.m2505o(26307);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.e$7 */
    class C227407 implements C5015a {
        C227407() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(26309);
            C43841a.cUn().tXz.mo69532a(new C31470a());
            AppMethodBeat.m2505o(26309);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.e$9 */
    class C227419 extends C4884c<C6512kz> {
        C227419() {
            AppMethodBeat.m2504i(26312);
            this.xxI = C6512kz.class.getName().hashCode();
            AppMethodBeat.m2505o(26312);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(26313);
            C6512kz c6512kz = (C6512kz) c4883b;
            if (C22732e.m34514a(C22732e.this)) {
                C43841a.cUn().tXz.mo69532a(new C46396f(c6512kz.cGR.userName, c6512kz.cGR.bCu, c6512kz.cGR.type));
            }
            AppMethodBeat.m2505o(26313);
            return false;
        }
    }

    public C22732e() {
        AppMethodBeat.m2504i(26318);
        C4990ab.m7416i("MicroMsg.Wear.WearLogic", "Create!");
        this.ryO.dnU();
        this.tXP.dnU();
        this.tXQ.dnU();
        this.ilT.dnU();
        this.tXR.dnU();
        this.tXS.dnU();
        this.tXT.dnU();
        this.edy.dnU();
        this.nZv.dnU();
        this.gyS.mo16770ae(1800000, 1800000);
        this.tXN = (PowerManager) C4996ah.getContext().getSystemService("power");
        this.tXO = (KeyguardManager) C4996ah.getContext().getSystemService("keyguard");
        C9638aw.m17190ZK();
        C18628c.m29080XO().mo15287a(this.lPn, null);
        AppMethodBeat.m2505o(26318);
    }

    /* renamed from: s */
    public static void m34515s(String str, int i, boolean z) {
        AppMethodBeat.m2504i(26319);
        C43841a.cUn().tXz.mo69532a(new C29725j(str, i, z));
        AppMethodBeat.m2505o(26319);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m34514a(C22732e c22732e) {
        AppMethodBeat.m2504i(26320);
        if (c22732e.tXO.inKeyguardRestrictedInputMode() || !c22732e.tXN.isScreenOn()) {
            AppMethodBeat.m2505o(26320);
            return true;
        }
        AppMethodBeat.m2505o(26320);
        return false;
    }
}
