package com.tencent.mm.plugin.wear.model;

import android.app.KeyguardManager;
import android.os.Looper;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.g.a.kz;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.g.a.vg;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f.f;
import com.tencent.mm.plugin.wear.model.f.i;
import com.tencent.mm.plugin.wear.model.f.j;
import com.tencent.mm.plugin.wear.model.f.k;
import com.tencent.mm.plugin.wear.model.f.l;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public final class e {
    c edy = new c<pe>() {
        {
            AppMethodBeat.i(26316);
            this.xxI = pe.class.getName().hashCode();
            AppMethodBeat.o(26316);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(26317);
            pe peVar = (pe) bVar;
            if (e.a(e.this)) {
                aw.ZK();
                ak aoZ = com.tencent.mm.model.c.XR().aoZ(peVar.cLt.cKd.field_talker);
                if (aoZ != null) {
                    int i = aoZ.field_unReadCount;
                    f adr = a.cUn().tXv.adr(peVar.cLt.cKd.field_talker);
                    if (i - adr.tYc > 0) {
                        e.s(peVar.cLt.cKd.field_talker, i, false);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(Integer.valueOf(adr.id));
                        a.cUn().tXz.a(new i(arrayList));
                    }
                }
            }
            AppMethodBeat.o(26317);
            return false;
        }
    };
    ap gyS = new ap(Looper.getMainLooper(), new a() {
        public final boolean BI() {
            AppMethodBeat.i(26309);
            a.cUn().tXz.a(new com.tencent.mm.plugin.wear.model.f.a());
            AppMethodBeat.o(26309);
            return true;
        }
    }, true);
    c ilT = new c<ui>() {
        {
            AppMethodBeat.i(26306);
            this.xxI = ui.class.getName().hashCode();
            AppMethodBeat.o(26306);
        }

        private static boolean a(ui uiVar) {
            AppMethodBeat.i(26307);
            switch (uiVar.cQx.cAd) {
                case 3:
                    byte[] bArr = uiVar.cQx.cQr;
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
                            ab.i("MicroMsg.Wear.WearLogic", "voip invite talker=%s | type=%s", str, Integer.valueOf(i));
                            a.cUn().tXz.a(new l(20010, str));
                            break;
                        }
                    }
                    break;
            }
            AppMethodBeat.o(26307);
            return false;
        }
    };
    h.a lPn = new h.a() {
        public final void a(h hVar, h.c cVar) {
            AppMethodBeat.i(26298);
            if (cVar == null) {
                AppMethodBeat.o(26298);
                return;
            }
            if (cVar.oqM > 0 && a.cUn().tXt.tXL.tYA.equals(cVar.talker)) {
                a.cUn().tXz.a(new com.tencent.mm.plugin.wear.model.f.c() {
                    public final String getName() {
                        return "SendMsgSyncTask";
                    }

                    public final void send() {
                        AppMethodBeat.i(26297);
                        try {
                            a.cUn();
                            r.b(20007, a.cUn().tXt.tXL.tYA.getBytes("utf8"), false);
                            AppMethodBeat.o(26297);
                        } catch (UnsupportedEncodingException e) {
                            AppMethodBeat.o(26297);
                        }
                    }
                });
            }
            AppMethodBeat.o(26298);
        }
    };
    c nZv = new c<vg>() {
        {
            AppMethodBeat.i(26299);
            this.xxI = vg.class.getName().hashCode();
            AppMethodBeat.o(26299);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(26300);
            vg vgVar = (vg) bVar;
            switch (vgVar.cSe.action) {
                case 2:
                    a.cUn().tXz.a(new com.tencent.mm.plugin.wear.model.f.h(vgVar.cSf.cuQ, vgVar.cSf.cSh, vgVar.cSf.cSi, vgVar.cSf.cSj));
                    break;
                case 4:
                    if (g.Nu().getInt("WearPayBlock", 0) == 0) {
                        a.cUn().tXz.a(new k(vgVar.cSe.cSg, vgVar.cSe.content));
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(26300);
            return false;
        }
    };
    c ryO = new c<ks>() {
        {
            AppMethodBeat.i(26295);
            this.xxI = ks.class.getName().hashCode();
            AppMethodBeat.o(26295);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(26296);
            ks ksVar = (ks) bVar;
            if (e.a(e.this) && !"gh_3dfda90e39d6".equals(ksVar.cGF.talker)) {
                aw.ZK();
                bi Rb = com.tencent.mm.model.c.XO().Rb(ksVar.cGF.talker);
                boolean z = Rb != null ? g.Nu().getInt("WearLuckyBlock", 0) == 0 && (Rb.dtp() || Rb.dtq()) : false;
                if (z) {
                    a.cUn().tXz.a(new com.tencent.mm.plugin.wear.model.f.g(Rb));
                    if (ksVar.cGF.csm > 1) {
                        e.s(ksVar.cGF.talker, ksVar.cGF.csm, false);
                    }
                } else {
                    e.s(ksVar.cGF.talker, ksVar.cGF.csm, true);
                }
            }
            AppMethodBeat.o(26296);
            return false;
        }
    };
    private PowerManager tXN;
    private KeyguardManager tXO;
    c tXP = new c<com.tencent.mm.g.a.k>() {
        {
            AppMethodBeat.i(26301);
            this.xxI = com.tencent.mm.g.a.k.class.getName().hashCode();
            AppMethodBeat.o(26301);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(26302);
            if (((com.tencent.mm.g.a.k) bVar).csh.csi) {
                a.cUn().tXz.a(new i());
            }
            AppMethodBeat.o(26302);
            return false;
        }
    };
    c tXQ = new c<ls>() {
        {
            AppMethodBeat.i(26304);
            this.xxI = ls.class.getName().hashCode();
            AppMethodBeat.o(26304);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(26305);
            final ls lsVar = (ls) bVar;
            com.tencent.mm.blink.b.HQ().o(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(26303);
                    a.cUn().tXv.ads(lsVar.cHA.talker);
                    f adr = a.cUn().tXv.adr(lsVar.cHA.talker);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Integer.valueOf(adr.id));
                    a.cUn().tXz.a(new i(arrayList));
                    if (lsVar.cHA.talker.equals("gh_43f2581f6fd6")) {
                        ctv ctv = a.cUn().tXt.tXK.tYz;
                        if (ctv != null) {
                            Object obj;
                            b bVar = a.cUn().tXw;
                            if (ctv != null && bVar.tXD && b.adq(ctv.xqs)) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj != null) {
                                a.cUn();
                                b.a(ctv);
                                AppMethodBeat.o(26303);
                                return;
                            }
                            a.cUn().tXw.connect();
                        }
                    }
                    AppMethodBeat.o(26303);
                }
            });
            AppMethodBeat.o(26305);
            return false;
        }
    };
    c tXR = new c<vj>() {
        {
            AppMethodBeat.i(26310);
            this.xxI = vj.class.getName().hashCode();
            AppMethodBeat.o(26310);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(26311);
            switch (((vj) bVar).cSr.cuy) {
                case 5:
                    a.cUn().tXz.a(new l(20011, ""));
                    break;
                case 6:
                case 7:
                    a.cUn().tXz.a(new l(20012, ""));
                    break;
            }
            AppMethodBeat.o(26311);
            return false;
        }
    };
    c tXS = new c<kz>() {
        {
            AppMethodBeat.i(26312);
            this.xxI = kz.class.getName().hashCode();
            AppMethodBeat.o(26312);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(26313);
            kz kzVar = (kz) bVar;
            if (e.a(e.this)) {
                a.cUn().tXz.a(new f(kzVar.cGR.userName, kzVar.cGR.bCu, kzVar.cGR.type));
            }
            AppMethodBeat.o(26313);
            return false;
        }
    };
    c tXT = new c<qc>() {
        {
            AppMethodBeat.i(26314);
            this.xxI = qc.class.getName().hashCode();
            AppMethodBeat.o(26314);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(26315);
            if (e.a(e.this)) {
                a.cUn().tXz.a(new com.tencent.mm.plugin.wear.model.f.e());
            }
            AppMethodBeat.o(26315);
            return false;
        }
    };

    public e() {
        AppMethodBeat.i(26318);
        ab.i("MicroMsg.Wear.WearLogic", "Create!");
        this.ryO.dnU();
        this.tXP.dnU();
        this.tXQ.dnU();
        this.ilT.dnU();
        this.tXR.dnU();
        this.tXS.dnU();
        this.tXT.dnU();
        this.edy.dnU();
        this.nZv.dnU();
        this.gyS.ae(1800000, 1800000);
        this.tXN = (PowerManager) ah.getContext().getSystemService("power");
        this.tXO = (KeyguardManager) ah.getContext().getSystemService("keyguard");
        aw.ZK();
        com.tencent.mm.model.c.XO().a(this.lPn, null);
        AppMethodBeat.o(26318);
    }

    public static void s(String str, int i, boolean z) {
        AppMethodBeat.i(26319);
        a.cUn().tXz.a(new j(str, i, z));
        AppMethodBeat.o(26319);
    }

    static /* synthetic */ boolean a(e eVar) {
        AppMethodBeat.i(26320);
        if (eVar.tXO.inKeyguardRestrictedInputMode() || !eVar.tXN.isScreenOn()) {
            AppMethodBeat.o(26320);
            return true;
        }
        AppMethodBeat.o(26320);
        return false;
    }
}
