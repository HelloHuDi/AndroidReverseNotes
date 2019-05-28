package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.g.a.uv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.appbrand.jsapi.k.ad;
import com.tencent.mm.plugin.appbrand.jsapi.lab.JsApiGetLabInfo;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.plugin.product.b.h;
import com.tencent.mm.plugin.product.b.i;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.b.k;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.bpz;
import com.tencent.mm.protocal.protobuf.cx;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.LinkedList;

public final class f implements com.tencent.mm.ai.f {
    static int gOW = 0;
    Activity gNy;
    boolean piI = false;
    private boolean piJ = false;
    c piK;
    private a piL;
    private com.tencent.mm.sdk.b.c piM = new com.tencent.mm.sdk.b.c<uv>() {
        {
            AppMethodBeat.i(44058);
            this.xxI = uv.class.getName().hashCode();
            AppMethodBeat.o(44058);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(44059);
            uv uvVar = (uv) bVar;
            if (uvVar instanceof uv) {
                if (uvVar.cRF.result != -1) {
                    ab.i("MicroMsg.MallProductUI", "MallProduct pay result : cancel");
                } else if (!f.this.piJ) {
                    ab.i("MicroMsg.MallProductUI", "MallProduct pay result : ok");
                    f.f(f.this);
                    f.this.piJ = true;
                }
                AppMethodBeat.o(44059);
                return true;
            }
            ab.f("MicroMsg.MallProductUI", "mismatched event");
            AppMethodBeat.o(44059);
            return false;
        }
    };

    /* renamed from: com.tencent.mm.plugin.product.ui.f$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ nd piP;

        AnonymousClass2(nd ndVar) {
            this.piP = ndVar;
        }

        public final void run() {
            AppMethodBeat.i(44057);
            ab.d("MicroMsg.MallProductUI", "JSOAUTH errCode[%s], isAccept[%s]", Integer.valueOf(this.piP.cJm.errCode), Boolean.valueOf(this.piP.cJm.cJn));
            if (this.piP.cJm.errCode == 0) {
                c c = f.this.piK;
                nd ndVar = this.piP;
                cx cxVar = new cx();
                cxVar.jBB = ndVar.cJm.userName;
                cxVar.vEV = ndVar.cJm.cJp;
                cxVar.vEW = ndVar.cJm.cJq;
                cxVar.guO = ndVar.cJm.cJr;
                cxVar.guP = ndVar.cJm.cJs;
                cxVar.guW = ndVar.cJm.cJt;
                cxVar.naq = ndVar.cJm.cJu;
                if (!(bo.isNullOrNil(cxVar.jBB) || bo.isNullOrNil(cxVar.vEV))) {
                    c.pgU = cxVar;
                }
            }
            f.this.piI = false;
            AppMethodBeat.o(44057);
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.f$1 */
    class AnonymousClass1 implements com.tencent.mm.sdk.platformtools.al.a {
        final /* synthetic */ m piN;
        private volatile int result;
        final /* synthetic */ Intent val$intent;

        AnonymousClass1(Intent intent, m mVar) {
            this.val$intent = intent;
            this.piN = mVar;
        }

        public final boolean acf() {
            AppMethodBeat.i(44054);
            this.result = f.a(f.this, this.val$intent, this.piN);
            AppMethodBeat.o(44054);
            return true;
        }

        public final boolean acg() {
            AppMethodBeat.i(44055);
            switch (this.result) {
                case -1:
                    if (f.this.piL != null) {
                        f.this.piL.t(0, -1, f.this.gNy.getString(R.string.cxc));
                        break;
                    }
                    break;
                case 0:
                    if (f.this.piL != null) {
                        f.this.piL.t(0, 0, "");
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(44055);
            return true;
        }

        public final String toString() {
            AppMethodBeat.i(44056);
            String str = super.toString() + "|initData";
            AppMethodBeat.o(44056);
            return str;
        }
    }

    public interface a {
        void t(int i, int i2, String str);
    }

    static /* synthetic */ void f(f fVar) {
        AppMethodBeat.i(44068);
        fVar.cae();
        AppMethodBeat.o(44068);
    }

    public f(Activity activity, a aVar) {
        AppMethodBeat.i(44060);
        this.gNy = activity;
        com.tencent.mm.plugin.product.a.a.bZC();
        this.piK = com.tencent.mm.plugin.product.a.a.bZD();
        this.piL = aVar;
        AppMethodBeat.o(44060);
    }

    public final void onStart() {
        AppMethodBeat.i(44061);
        g.RQ();
        g.RO().eJo.a(553, (com.tencent.mm.ai.f) this);
        g.RQ();
        g.RO().eJo.a(554, (com.tencent.mm.ai.f) this);
        g.RQ();
        g.RO().eJo.a(555, (com.tencent.mm.ai.f) this);
        g.RQ();
        g.RO().eJo.a(556, (com.tencent.mm.ai.f) this);
        g.RQ();
        g.RO().eJo.a((int) JsApiGetLabInfo.CTRL_INDEX, (com.tencent.mm.ai.f) this);
        g.RQ();
        g.RO().eJo.a((int) com.tencent.mm.plugin.appbrand.jsapi.k.c.CTRL_INDEX, (com.tencent.mm.ai.f) this);
        g.RQ();
        g.RO().eJo.a((int) ad.CTRL_INDEX, (com.tencent.mm.ai.f) this);
        AppMethodBeat.o(44061);
    }

    public final void onStop() {
        AppMethodBeat.i(44062);
        g.RQ();
        g.RO().eJo.b(553, (com.tencent.mm.ai.f) this);
        g.RQ();
        g.RO().eJo.b(554, (com.tencent.mm.ai.f) this);
        g.RQ();
        g.RO().eJo.b(555, (com.tencent.mm.ai.f) this);
        g.RQ();
        g.RO().eJo.b(556, (com.tencent.mm.ai.f) this);
        g.RQ();
        g.RO().eJo.b((int) JsApiGetLabInfo.CTRL_INDEX, (com.tencent.mm.ai.f) this);
        g.RQ();
        g.RO().eJo.b((int) com.tencent.mm.plugin.appbrand.jsapi.k.c.CTRL_INDEX, (com.tencent.mm.ai.f) this);
        g.RQ();
        g.RO().eJo.b((int) ad.CTRL_INDEX, (com.tencent.mm.ai.f) this);
        AppMethodBeat.o(44062);
    }

    public final void cad() {
        AppMethodBeat.i(44063);
        m mVar = this.piK.pgO;
        cl clVar = new cl();
        abf abf = new abf();
        abl abl = new abl();
        abe abe = new abe();
        abl.alD(r.Yz());
        abl.alE(r.Yz());
        abl.LN(11);
        abl.ml(bo.anU());
        abe.alw(mVar.phs.name);
        abe.alx(this.piK.bZW());
        abe.LK(mVar.php);
        abe.alz(this.piK.a(mVar));
        abe.aly(mVar.bZY());
        clVar.cvA.title = mVar.phs.name;
        clVar.cvA.desc = this.piK.bZW();
        clVar.cvA.cvC = abf;
        clVar.cvA.type = 11;
        abf.a(abl);
        abf.b(abe);
        clVar.cvA.activity = this.gNy;
        clVar.cvA.cvH = 5;
        com.tencent.mm.sdk.b.a.xxA.m(clVar);
        AppMethodBeat.o(44063);
    }

    private void cae() {
        AppMethodBeat.i(44064);
        d bZE = com.tencent.mm.plugin.product.a.a.bZC().bZE();
        bpz bZK = this.piK.bZK();
        if (!(bZK == null || bo.isNullOrNil(bZK.naq) || bZK.naq.contains(";"))) {
            bZE.phg.remove(bZK.naq);
            bZE.phg.add(bZK.naq);
            bZE.bZX();
        }
        Intent intent = new Intent(this.gNy, MallProductUI.class);
        intent.putExtra("key_go_finish", true);
        intent.addFlags(67108864);
        this.gNy.startActivity(intent);
        AppMethodBeat.o(44064);
    }

    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(44065);
        ab.d("MicroMsg.MallProductUI", "errCode: " + i2 + ", errMsg: " + str);
        h hVar;
        c cVar;
        String str2;
        LinkedList linkedList;
        if (i != 0 || i2 != 0) {
            switch (i2) {
                case -10010003:
                    ab.i("MicroMsg.MallProductUI", "deal with MMBIZPAY_FUNC_ERR_NO_EXISTED_PRODUCT");
                    if (mVar instanceof h) {
                        hVar = (h) mVar;
                        this.piK.a(hVar.phk, hVar.phl);
                        if (this.piL != null) {
                            this.piL.t(i, i2, str);
                        }
                        AppMethodBeat.o(44065);
                        return;
                    }
                    break;
                default:
                    ab.i("MicroMsg.MallProductUI", "unkown errCode ".concat(String.valueOf(i2)));
                    if (bo.isNullOrNil(str)) {
                        str = i2 + " : " + this.gNy.getString(R.string.cxc);
                    }
                    if (this.piL != null) {
                        this.piL.t(i, i2, str);
                        break;
                    }
                    break;
            }
        } else if (mVar instanceof h) {
            hVar = (h) mVar;
            this.piK.a(hVar.phk, hVar.phl);
            if (this.piL != null) {
                this.piL.t(i, i2, str);
            }
            if (bo.isNullOrNil(hVar.phk.pho)) {
                com.tencent.mm.plugin.report.service.h.pYm.e(TXCStreamUploader.TXE_UPLOAD_INFO_SERVER_REFUSE, this.piK.bZL(), hVar.phj, Integer.valueOf(gOW), Integer.valueOf(1));
                AppMethodBeat.o(44065);
                return;
            }
            com.tencent.mm.plugin.report.service.h.pYm.e(TXCStreamUploader.TXE_UPLOAD_INFO_SERVER_REFUSE, this.piK.bZL(), hVar.phk.pho, Integer.valueOf(gOW), Integer.valueOf(1));
            AppMethodBeat.o(44065);
            return;
        } else if (mVar instanceof j) {
            j jVar = (j) mVar;
            cVar = this.piK;
            str2 = jVar.pgQ;
            linkedList = jVar.phb;
            LinkedList linkedList2 = jVar.phc;
            cVar.pgQ = str2;
            cVar.phc = linkedList2;
            cVar.phb = linkedList;
            cVar.AL(0);
            this.gNy.startActivity(new Intent(this.gNy, MallProductSubmitUI.class));
            com.tencent.mm.plugin.report.service.h.pYm.e(11009, this.piK.bZL(), this.piK.pgO.pho, Integer.valueOf(gOW), Integer.valueOf(1));
            AppMethodBeat.o(44065);
            return;
        } else if (!(mVar instanceof com.tencent.mm.plugin.product.b.f)) {
            if (mVar instanceof l) {
                str2 = ((l) mVar).phn;
                int i3 = 6;
                if (gOW == 7) {
                    i3 = 1001;
                }
                ab.d("MicroMsg.MallProductUI", "payScene:".concat(String.valueOf(i3)));
                com.tencent.mm.pluginsdk.wallet.h.a(this.gNy, str2, this.piK.getAppId(), i3, 3);
                com.tencent.mm.sdk.b.a.xxA.c(this.piM);
                AppMethodBeat.o(44065);
                return;
            } else if (mVar instanceof k) {
                com.tencent.mm.ui.base.h.bQ(this.gNy, this.gNy.getString(R.string.cxv));
                cae();
                AppMethodBeat.o(44065);
                return;
            } else if (mVar instanceof com.tencent.mm.plugin.product.b.g) {
                try {
                    this.gNy.dismissDialog(-10002);
                } catch (Exception e) {
                    ab.e("MicroMsg.MallProductUI", e.toString());
                }
                cVar = this.piK;
                cVar.phb = ((com.tencent.mm.plugin.product.b.g) mVar).phb;
                cVar.AL(0);
                AppMethodBeat.o(44065);
                return;
            } else if (mVar instanceof i) {
                try {
                    this.gNy.dismissDialog(-10002);
                } catch (Exception e2) {
                    ab.e("MicroMsg.MallProductUI", e2.toString());
                }
                i iVar = (i) mVar;
                cVar = this.piK;
                str2 = iVar.mUrl;
                linkedList = iVar.phm;
                if (!(bo.isNullOrNil(str2) || linkedList == null || linkedList.size() <= 0)) {
                    if (cVar.phf == null) {
                        cVar.phf = new HashMap();
                    }
                    cVar.phf.put(str2, linkedList);
                }
                if (this.piL != null) {
                    this.piL.t(i, i2, str);
                }
                AppMethodBeat.o(44065);
                return;
            }
        }
        AppMethodBeat.o(44065);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(44066);
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String str;
                    this.piK.al(intent);
                    if (this.piL != null) {
                        this.piL.t(0, 0, "");
                    }
                    g.RQ();
                    p pVar = g.RO().eJo;
                    c cVar = this.piK;
                    if (cVar.pgO != null) {
                        str = cVar.pgO.pho;
                    } else {
                        str = "";
                    }
                    pVar.a(new com.tencent.mm.plugin.product.b.g(str, this.piK.pgQ, this.piK.pgU), 0);
                    AppMethodBeat.o(44066);
                    return;
                }
            case 2:
                if (i2 == -1 && intent != null) {
                    this.piK.al(intent);
                    g.RQ();
                    g.RO().eJo.a(new j(this.piK.bZS(), gOW), 0);
                    break;
                }
            case 3:
                uv uvVar = new uv();
                uvVar.cRF.result = i;
                uvVar.cRF.intent = intent;
                this.piM.a(uvVar);
                AppMethodBeat.o(44066);
                return;
            case 4:
                if (this.piL != null) {
                    this.piL.t(0, 0, "");
                    AppMethodBeat.o(44066);
                    return;
                }
                break;
            case Downloads.MIN_WAIT_FOR_NETWORK /*10000*/:
                this.gNy.showDialog(-10002);
                g.RQ();
                g.RO().eJo.a(new i(this.piK.pgQ, this.piK.pgX), 0);
                AppMethodBeat.o(44066);
                return;
        }
        AppMethodBeat.o(44066);
    }

    static /* synthetic */ int a(f fVar, Intent intent, m mVar) {
        AppMethodBeat.i(44067);
        gOW = intent.getIntExtra("key_product_scene", 3);
        String stringExtra = intent.getStringExtra("key_product_info");
        String stringExtra2 = intent.getStringExtra("key_product_id");
        String stringExtra3 = intent.getStringExtra("key_source_url");
        c cVar = fVar.piK;
        if (!bo.isNullOrNil(stringExtra3)) {
            cVar.pgR = stringExtra3;
        }
        int i = -2;
        ab.i("MicroMsg.MallProductUI", "Scene : " + gOW);
        switch (gOW) {
            case 1:
            case 2:
            case 4:
                if (!bo.isNullOrNil(stringExtra)) {
                    mVar = m.b(mVar, stringExtra);
                    if (mVar == null) {
                        i = -1;
                        break;
                    }
                    fVar.piK.a(mVar, null);
                    stringExtra2 = mVar.pho;
                    i = 0;
                    break;
                }
                break;
            case 3:
                if (!bo.isNullOrNil(stringExtra)) {
                    mVar = m.a(mVar, stringExtra);
                    if (mVar == null) {
                        i = -1;
                        break;
                    }
                    fVar.piK.a(mVar, null);
                    stringExtra2 = mVar.pho;
                    i = 0;
                    break;
                }
                break;
        }
        if (bo.isNullOrNil(stringExtra2)) {
            i = -1;
        } else {
            g.RQ();
            g.RO().eJo.a(new h(mVar, stringExtra2), 0);
        }
        AppMethodBeat.o(44067);
        return i;
    }
}
