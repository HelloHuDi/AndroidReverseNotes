package com.tencent.p177mm.plugin.product.p482ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p230g.p231a.C32652uv;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C9421nd;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.appbrand.jsapi.lab.JsApiGetLabInfo;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33337c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C42524ad;
import com.tencent.p177mm.plugin.product.p1498a.C34676a;
import com.tencent.p177mm.plugin.product.p481b.C12808c;
import com.tencent.p177mm.plugin.product.p481b.C12810d;
import com.tencent.p177mm.plugin.product.p481b.C12811k;
import com.tencent.p177mm.plugin.product.p481b.C12812m;
import com.tencent.p177mm.plugin.product.p481b.C34677f;
import com.tencent.p177mm.plugin.product.p481b.C34678g;
import com.tencent.p177mm.plugin.product.p481b.C34679h;
import com.tencent.p177mm.plugin.product.p481b.C34680i;
import com.tencent.p177mm.plugin.product.p481b.C34681j;
import com.tencent.p177mm.plugin.product.p481b.C7016l;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.protocal.protobuf.C40508cx;
import com.tencent.p177mm.protocal.protobuf.abe;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.protocal.protobuf.bpz;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al.C5002a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.product.ui.f */
public final class C39496f implements C1202f {
    static int gOW = 0;
    Activity gNy;
    boolean piI = false;
    private boolean piJ = false;
    C12808c piK;
    private C39497a piL;
    private C4884c piM = new C214483();

    /* renamed from: com.tencent.mm.plugin.product.ui.f$3 */
    class C214483 extends C4884c<C32652uv> {
        C214483() {
            AppMethodBeat.m2504i(44058);
            this.xxI = C32652uv.class.getName().hashCode();
            AppMethodBeat.m2505o(44058);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(44059);
            C32652uv c32652uv = (C32652uv) c4883b;
            if (c32652uv instanceof C32652uv) {
                if (c32652uv.cRF.result != -1) {
                    C4990ab.m7416i("MicroMsg.MallProductUI", "MallProduct pay result : cancel");
                } else if (!C39496f.this.piJ) {
                    C4990ab.m7416i("MicroMsg.MallProductUI", "MallProduct pay result : ok");
                    C39496f.m67485f(C39496f.this);
                    C39496f.this.piJ = true;
                }
                AppMethodBeat.m2505o(44059);
                return true;
            }
            C4990ab.m7414f("MicroMsg.MallProductUI", "mismatched event");
            AppMethodBeat.m2505o(44059);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.f$2 */
    class C286762 implements Runnable {
        final /* synthetic */ C9421nd piP;

        C286762(C9421nd c9421nd) {
            this.piP = c9421nd;
        }

        public final void run() {
            AppMethodBeat.m2504i(44057);
            C4990ab.m7411d("MicroMsg.MallProductUI", "JSOAUTH errCode[%s], isAccept[%s]", Integer.valueOf(this.piP.cJm.errCode), Boolean.valueOf(this.piP.cJm.cJn));
            if (this.piP.cJm.errCode == 0) {
                C12808c c = C39496f.this.piK;
                C9421nd c9421nd = this.piP;
                C40508cx c40508cx = new C40508cx();
                c40508cx.jBB = c9421nd.cJm.userName;
                c40508cx.vEV = c9421nd.cJm.cJp;
                c40508cx.vEW = c9421nd.cJm.cJq;
                c40508cx.guO = c9421nd.cJm.cJr;
                c40508cx.guP = c9421nd.cJm.cJs;
                c40508cx.guW = c9421nd.cJm.cJt;
                c40508cx.naq = c9421nd.cJm.cJu;
                if (!(C5046bo.isNullOrNil(c40508cx.jBB) || C5046bo.isNullOrNil(c40508cx.vEV))) {
                    c.pgU = c40508cx;
                }
            }
            C39496f.this.piI = false;
            AppMethodBeat.m2505o(44057);
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.f$1 */
    class C394951 implements C5002a {
        final /* synthetic */ C12812m piN;
        private volatile int result;
        final /* synthetic */ Intent val$intent;

        C394951(Intent intent, C12812m c12812m) {
            this.val$intent = intent;
            this.piN = c12812m;
        }

        public final boolean acf() {
            AppMethodBeat.m2504i(44054);
            this.result = C39496f.m67479a(C39496f.this, this.val$intent, this.piN);
            AppMethodBeat.m2505o(44054);
            return true;
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(44055);
            switch (this.result) {
                case -1:
                    if (C39496f.this.piL != null) {
                        C39496f.this.piL.mo8191t(0, -1, C39496f.this.gNy.getString(C25738R.string.cxc));
                        break;
                    }
                    break;
                case 0:
                    if (C39496f.this.piL != null) {
                        C39496f.this.piL.mo8191t(0, 0, "");
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(44055);
            return true;
        }

        public final String toString() {
            AppMethodBeat.m2504i(44056);
            String str = super.toString() + "|initData";
            AppMethodBeat.m2505o(44056);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.f$a */
    public interface C39497a {
        /* renamed from: t */
        void mo8191t(int i, int i2, String str);
    }

    /* renamed from: f */
    static /* synthetic */ void m67485f(C39496f c39496f) {
        AppMethodBeat.m2504i(44068);
        c39496f.cae();
        AppMethodBeat.m2505o(44068);
    }

    public C39496f(Activity activity, C39497a c39497a) {
        AppMethodBeat.m2504i(44060);
        this.gNy = activity;
        C34676a.bZC();
        this.piK = C34676a.bZD();
        this.piL = c39497a;
        AppMethodBeat.m2505o(44060);
    }

    public final void onStart() {
        AppMethodBeat.m2504i(44061);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(553, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(554, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(555, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(556, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a((int) JsApiGetLabInfo.CTRL_INDEX, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a((int) C33337c.CTRL_INDEX, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a((int) C42524ad.CTRL_INDEX, (C1202f) this);
        AppMethodBeat.m2505o(44061);
    }

    public final void onStop() {
        AppMethodBeat.m2504i(44062);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(553, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(554, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(555, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(556, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b((int) JsApiGetLabInfo.CTRL_INDEX, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b((int) C33337c.CTRL_INDEX, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b((int) C42524ad.CTRL_INDEX, (C1202f) this);
        AppMethodBeat.m2505o(44062);
    }

    public final void cad() {
        AppMethodBeat.m2504i(44063);
        C12812m c12812m = this.piK.pgO;
        C45316cl c45316cl = new C45316cl();
        abf abf = new abf();
        abl abl = new abl();
        abe abe = new abe();
        abl.alD(C1853r.m3846Yz());
        abl.alE(C1853r.m3846Yz());
        abl.mo39126LN(11);
        abl.mo39136ml(C5046bo.anU());
        abe.alw(c12812m.phs.name);
        abe.alx(this.piK.bZW());
        abe.mo27436LK(c12812m.php);
        abe.alz(this.piK.mo24810a(c12812m));
        abe.aly(c12812m.bZY());
        c45316cl.cvA.title = c12812m.phs.name;
        c45316cl.cvA.desc = this.piK.bZW();
        c45316cl.cvA.cvC = abf;
        c45316cl.cvA.type = 11;
        abf.mo74737a(abl);
        abf.mo74744b(abe);
        c45316cl.cvA.activity = this.gNy;
        c45316cl.cvA.cvH = 5;
        C4879a.xxA.mo10055m(c45316cl);
        AppMethodBeat.m2505o(44063);
    }

    private void cae() {
        AppMethodBeat.m2504i(44064);
        C12810d bZE = C34676a.bZC().bZE();
        bpz bZK = this.piK.bZK();
        if (!(bZK == null || C5046bo.isNullOrNil(bZK.naq) || bZK.naq.contains(";"))) {
            bZE.phg.remove(bZK.naq);
            bZE.phg.add(bZK.naq);
            bZE.bZX();
        }
        Intent intent = new Intent(this.gNy, MallProductUI.class);
        intent.putExtra("key_go_finish", true);
        intent.addFlags(67108864);
        this.gNy.startActivity(intent);
        AppMethodBeat.m2505o(44064);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(44065);
        C4990ab.m7410d("MicroMsg.MallProductUI", "errCode: " + i2 + ", errMsg: " + str);
        C34679h c34679h;
        C12808c c12808c;
        String str2;
        LinkedList linkedList;
        if (i != 0 || i2 != 0) {
            switch (i2) {
                case -10010003:
                    C4990ab.m7416i("MicroMsg.MallProductUI", "deal with MMBIZPAY_FUNC_ERR_NO_EXISTED_PRODUCT");
                    if (c1207m instanceof C34679h) {
                        c34679h = (C34679h) c1207m;
                        this.piK.mo24811a(c34679h.phk, c34679h.phl);
                        if (this.piL != null) {
                            this.piL.mo8191t(i, i2, str);
                        }
                        AppMethodBeat.m2505o(44065);
                        return;
                    }
                    break;
                default:
                    C4990ab.m7416i("MicroMsg.MallProductUI", "unkown errCode ".concat(String.valueOf(i2)));
                    if (C5046bo.isNullOrNil(str)) {
                        str = i2 + " : " + this.gNy.getString(C25738R.string.cxc);
                    }
                    if (this.piL != null) {
                        this.piL.mo8191t(i, i2, str);
                        break;
                    }
                    break;
            }
        } else if (c1207m instanceof C34679h) {
            c34679h = (C34679h) c1207m;
            this.piK.mo24811a(c34679h.phk, c34679h.phl);
            if (this.piL != null) {
                this.piL.mo8191t(i, i2, str);
            }
            if (C5046bo.isNullOrNil(c34679h.phk.pho)) {
                C7060h.pYm.mo8381e(TXCStreamUploader.TXE_UPLOAD_INFO_SERVER_REFUSE, this.piK.bZL(), c34679h.phj, Integer.valueOf(gOW), Integer.valueOf(1));
                AppMethodBeat.m2505o(44065);
                return;
            }
            C7060h.pYm.mo8381e(TXCStreamUploader.TXE_UPLOAD_INFO_SERVER_REFUSE, this.piK.bZL(), c34679h.phk.pho, Integer.valueOf(gOW), Integer.valueOf(1));
            AppMethodBeat.m2505o(44065);
            return;
        } else if (c1207m instanceof C34681j) {
            C34681j c34681j = (C34681j) c1207m;
            c12808c = this.piK;
            str2 = c34681j.pgQ;
            linkedList = c34681j.phb;
            LinkedList linkedList2 = c34681j.phc;
            c12808c.pgQ = str2;
            c12808c.phc = linkedList2;
            c12808c.phb = linkedList;
            c12808c.mo24808AL(0);
            this.gNy.startActivity(new Intent(this.gNy, MallProductSubmitUI.class));
            C7060h.pYm.mo8381e(11009, this.piK.bZL(), this.piK.pgO.pho, Integer.valueOf(gOW), Integer.valueOf(1));
            AppMethodBeat.m2505o(44065);
            return;
        } else if (!(c1207m instanceof C34677f)) {
            if (c1207m instanceof C7016l) {
                str2 = ((C7016l) c1207m).phn;
                int i3 = 6;
                if (gOW == 7) {
                    i3 = 1001;
                }
                C4990ab.m7410d("MicroMsg.MallProductUI", "payScene:".concat(String.valueOf(i3)));
                C35899h.m58854a(this.gNy, str2, this.piK.getAppId(), i3, 3);
                C4879a.xxA.mo10052c(this.piM);
                AppMethodBeat.m2505o(44065);
                return;
            } else if (c1207m instanceof C12811k) {
                C30379h.m48465bQ(this.gNy, this.gNy.getString(C25738R.string.cxv));
                cae();
                AppMethodBeat.m2505o(44065);
                return;
            } else if (c1207m instanceof C34678g) {
                try {
                    this.gNy.dismissDialog(-10002);
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.MallProductUI", e.toString());
                }
                c12808c = this.piK;
                c12808c.phb = ((C34678g) c1207m).phb;
                c12808c.mo24808AL(0);
                AppMethodBeat.m2505o(44065);
                return;
            } else if (c1207m instanceof C34680i) {
                try {
                    this.gNy.dismissDialog(-10002);
                } catch (Exception e2) {
                    C4990ab.m7412e("MicroMsg.MallProductUI", e2.toString());
                }
                C34680i c34680i = (C34680i) c1207m;
                c12808c = this.piK;
                str2 = c34680i.mUrl;
                linkedList = c34680i.phm;
                if (!(C5046bo.isNullOrNil(str2) || linkedList == null || linkedList.size() <= 0)) {
                    if (c12808c.phf == null) {
                        c12808c.phf = new HashMap();
                    }
                    c12808c.phf.put(str2, linkedList);
                }
                if (this.piL != null) {
                    this.piL.mo8191t(i, i2, str);
                }
                AppMethodBeat.m2505o(44065);
                return;
            }
        }
        AppMethodBeat.m2505o(44065);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(44066);
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String str;
                    this.piK.mo24812al(intent);
                    if (this.piL != null) {
                        this.piL.mo8191t(0, 0, "");
                    }
                    C1720g.m3537RQ();
                    C6300p c6300p = C1720g.m3535RO().eJo;
                    C12808c c12808c = this.piK;
                    if (c12808c.pgO != null) {
                        str = c12808c.pgO.pho;
                    } else {
                        str = "";
                    }
                    c6300p.mo14541a(new C34678g(str, this.piK.pgQ, this.piK.pgU), 0);
                    AppMethodBeat.m2505o(44066);
                    return;
                }
            case 2:
                if (i2 == -1 && intent != null) {
                    this.piK.mo24812al(intent);
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14541a(new C34681j(this.piK.bZS(), gOW), 0);
                    break;
                }
            case 3:
                C32652uv c32652uv = new C32652uv();
                c32652uv.cRF.result = i;
                c32652uv.cRF.intent = intent;
                this.piM.mo4653a(c32652uv);
                AppMethodBeat.m2505o(44066);
                return;
            case 4:
                if (this.piL != null) {
                    this.piL.mo8191t(0, 0, "");
                    AppMethodBeat.m2505o(44066);
                    return;
                }
                break;
            case Downloads.MIN_WAIT_FOR_NETWORK /*10000*/:
                this.gNy.showDialog(-10002);
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(new C34680i(this.piK.pgQ, this.piK.pgX), 0);
                AppMethodBeat.m2505o(44066);
                return;
        }
        AppMethodBeat.m2505o(44066);
    }

    /* renamed from: a */
    static /* synthetic */ int m67479a(C39496f c39496f, Intent intent, C12812m c12812m) {
        AppMethodBeat.m2504i(44067);
        gOW = intent.getIntExtra("key_product_scene", 3);
        String stringExtra = intent.getStringExtra("key_product_info");
        String stringExtra2 = intent.getStringExtra("key_product_id");
        String stringExtra3 = intent.getStringExtra("key_source_url");
        C12808c c12808c = c39496f.piK;
        if (!C5046bo.isNullOrNil(stringExtra3)) {
            c12808c.pgR = stringExtra3;
        }
        int i = -2;
        C4990ab.m7416i("MicroMsg.MallProductUI", "Scene : " + gOW);
        switch (gOW) {
            case 1:
            case 2:
            case 4:
                if (!C5046bo.isNullOrNil(stringExtra)) {
                    c12812m = C12812m.m20813b(c12812m, stringExtra);
                    if (c12812m == null) {
                        i = -1;
                        break;
                    }
                    c39496f.piK.mo24811a(c12812m, null);
                    stringExtra2 = c12812m.pho;
                    i = 0;
                    break;
                }
                break;
            case 3:
                if (!C5046bo.isNullOrNil(stringExtra)) {
                    c12812m = C12812m.m20812a(c12812m, stringExtra);
                    if (c12812m == null) {
                        i = -1;
                        break;
                    }
                    c39496f.piK.mo24811a(c12812m, null);
                    stringExtra2 = c12812m.pho;
                    i = 0;
                    break;
                }
                break;
        }
        if (C5046bo.isNullOrNil(stringExtra2)) {
            i = -1;
        } else {
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(new C34679h(c12812m, stringExtra2), 0);
        }
        AppMethodBeat.m2505o(44067);
        return i;
    }
}
