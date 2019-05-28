package com.tencent.p177mm.p612ui.chatting.p616c.p1364c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C37758lo;
import com.tencent.p177mm.p612ui.C24020t;
import com.tencent.p177mm.p612ui.appbrand.C40661a;
import com.tencent.p177mm.p612ui.appbrand.C40663b;
import com.tencent.p177mm.p612ui.appbrand.C40663b.C154912;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44299r;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.p177mm.plugin.appbrand.config.WxaExposedParams.C19154a;
import com.tencent.p177mm.plugin.appbrand.service.C42686d;
import com.tencent.p177mm.protocal.protobuf.ajz;
import com.tencent.p177mm.protocal.protobuf.aka;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.chatting.c.c.a */
public final class C40728a extends C46645c {
    private C40661a appBrandServiceActionSheet;
    private String appId;
    private int emC;
    private String hID;
    private String hIE;
    private String hIF;
    private String hIG;
    private String hIH;
    private String mSceneId;
    private WxaExposedParams yTl;
    private boolean yTm;
    private C4884c<C37758lo> yTn = new C304741();
    private String yTo = "";

    /* renamed from: com.tencent.mm.ui.chatting.c.c.a$2 */
    class C249592 extends C24020t {

        /* renamed from: com.tencent.mm.ui.chatting.c.c.a$2$1 */
        class C249601 implements Runnable {
            C249601() {
            }

            public final void run() {
                String aqK;
                AppMethodBeat.m2504i(31889);
                String aqJ = C40663b.aqJ(C40728a.this.cgL.getTalkerUserName());
                if (C5046bo.isNullOrNil(aqJ)) {
                    aqJ = C40728a.this.cgL.getTalkerUserName();
                    if (C5046bo.isNullOrNil(C40728a.this.cgL.dDw())) {
                        aqK = C40663b.aqK(C40728a.this.cgL.getTalkerUserName());
                    } else {
                        aqK = C40728a.this.cgL.dDw();
                    }
                } else {
                    aqK = C40663b.aqK(aqJ);
                }
                C40728a.this.appBrandServiceActionSheet.username = C40728a.this.cgL.getTalkerUserName();
                C40728a.this.appBrandServiceActionSheet.jnK = false;
                C40728a.this.appBrandServiceActionSheet.scene = C40728a.this.emC;
                C40728a.this.appBrandServiceActionSheet.yrk = C40728a.this.mSceneId;
                if (C40728a.this.emC == 2) {
                    C40728a.this.appBrandServiceActionSheet.iIa = C40728a.this.yTl;
                    if (C40728a.this.yTm) {
                        C40728a.this.appBrandServiceActionSheet.show(1);
                        AppMethodBeat.m2505o(31889);
                        return;
                    }
                    C40728a.this.appBrandServiceActionSheet.show(2);
                    AppMethodBeat.m2505o(31889);
                    return;
                }
                C19154a c19154a = new C19154a();
                c19154a.appId = C40663b.m70235zm(aqJ);
                c19154a.from = 4;
                c19154a.username = aqJ;
                c19154a.nickname = aqK;
                C40728a.this.appBrandServiceActionSheet.iIa = c19154a.ayP();
                C40728a.this.appBrandServiceActionSheet.appId = C40728a.this.getAppId();
                if (C40728a.this.yTm) {
                    C40728a.this.appBrandServiceActionSheet.show(5);
                    AppMethodBeat.m2505o(31889);
                    return;
                }
                C40728a.this.appBrandServiceActionSheet.show(6);
                AppMethodBeat.m2505o(31889);
            }
        }

        C249592() {
        }

        /* renamed from: Kp */
        public final void mo39830Kp() {
            AppMethodBeat.m2504i(31890);
            C40728a.this.cgL.aqX();
            C5004al.m7441d(new C249601());
            AppMethodBeat.m2505o(31890);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.c.a$1 */
    class C304741 extends C4884c<C37758lo> {

        /* renamed from: com.tencent.mm.ui.chatting.c.c.a$1$1 */
        class C304751 implements Runnable {
            C304751() {
            }

            public final void run() {
                AppMethodBeat.m2504i(31886);
                if (C40728a.this.yTm) {
                    C4990ab.m7411d("MicroMsg.AppBrandServiceComponent", "OnWxaOptionsChangedEvent refuse:%b, setRejectIcon View.Visible", Boolean.valueOf(C40728a.this.yTm));
                    ((C44299r) C40728a.this.cgL.mo74857aF(C44299r.class)).mo64257OA(0);
                    AppMethodBeat.m2505o(31886);
                    return;
                }
                C4990ab.m7411d("MicroMsg.AppBrandServiceComponent", "OnWxaOptionsChangedEvent refuse:%b, setRejectIcon View.GONE", Boolean.valueOf(C40728a.this.yTm));
                ((C44299r) C40728a.this.cgL.mo74857aF(C44299r.class)).mo64257OA(8);
                AppMethodBeat.m2505o(31886);
            }
        }

        C304741() {
            AppMethodBeat.m2504i(31887);
            this.xxI = C37758lo.class.getName().hashCode();
            AppMethodBeat.m2505o(31887);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            boolean z = false;
            AppMethodBeat.m2504i(31888);
            C37758lo c37758lo = (C37758lo) c4883b;
            if (c37758lo.cHo == null || c37758lo.cHo.csl == null) {
                C4990ab.m7412e("MicroMsg.AppBrandServiceComponent", "OnWxaOptionsChangedEvent event is empty");
                AppMethodBeat.m2505o(31888);
                return false;
            }
            C4990ab.m7411d("MicroMsg.AppBrandServiceComponent", "OnWxaOptionsChangedEvent username:%s,event.brandId:%s,event.newValue:%d", C40728a.this.cgL.getTalkerUserName(), c37758lo.cHo.csl, Integer.valueOf(c37758lo.cHo.cHp));
            if (c37758lo.cHo.csl.equals(C40728a.this.cgL.getTalkerUserName())) {
                C40728a c40728a = C40728a.this;
                if ((c37758lo.cHo.cHp & 2) > 0) {
                    z = true;
                }
                c40728a.yTm = z;
                C5004al.m7441d(new C304751());
            }
            AppMethodBeat.m2505o(31888);
            return true;
        }
    }

    public C40728a() {
        AppMethodBeat.m2504i(31891);
        AppMethodBeat.m2505o(31891);
    }

    public final void dxx() {
        AppMethodBeat.m2504i(31892);
        this.emC = this.cgL.yTx.getIntExtra("app_brand_chatting_from_scene", 1);
        this.yTl = (WxaExposedParams) this.cgL.yTx.getParcelableExtra("app_brand_chatting_expose_params");
        this.mSceneId = C5046bo.nullAsNil(this.cgL.yTx.getStringExtra("key_scene_id"));
        C4990ab.m7417i("MicroMsg.AppBrandServiceComponent", "onChattingInit() fromScene:%d wxaExposedParams:%s mSceneId:%s", Integer.valueOf(this.emC), this.yTl, this.mSceneId);
        this.hID = this.cgL.yTx.getStringExtra("keyPrivateAppId");
        if (!C5046bo.isNullOrNil(this.hID)) {
            this.hIE = this.cgL.yTx.getStringExtra("keyPrivateUserName");
            this.hIF = this.cgL.yTx.getStringExtra("keyPrivateTitle");
            this.hIG = this.cgL.yTx.getStringExtra("keyPrivateSubTitle");
            this.hIH = this.cgL.yTx.getStringExtra("keyPrivateHeadImage");
            C4990ab.m7417i("MicroMsg.AppBrandServiceComponent", "onChattingInit customized appId:%s, username:%s, title:%s, subtitle:%s, headImage:%s", this.hID, this.hIE, this.hIF, this.hIG, this.hIH);
        }
        this.appBrandServiceActionSheet = new C40661a(this.cgL.yTx.getContext());
        WxaAttributes zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(this.cgL.getTalkerUserName());
        boolean z = zb != null && (zb.field_appOpt & 2) > 0;
        this.yTm = z;
        String talkerUserName = this.cgL.getTalkerUserName();
        String appId = getAppId();
        C1196a c1196a = new C1196a();
        c1196a.fsI = 2912;
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getkefusessioninfo";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        ajz ajz = new ajz();
        talkerUserName = C40663b.aqJ(talkerUserName);
        if (C5046bo.isNullOrNil(talkerUserName)) {
            ajz.csB = appId;
            ajz.wpz = "";
        } else {
            ajz.csB = C40663b.m70235zm(talkerUserName);
            ajz.wpz = appId;
        }
        c1196a.fsJ = ajz;
        c1196a.fsK = new aka();
        C1226w.m2654a(c1196a.acD(), new C154912());
        AppMethodBeat.m2505o(31892);
    }

    public final void dxA() {
        AppMethodBeat.m2504i(31893);
        this.yTn.dnU();
        AppMethodBeat.m2505o(31893);
    }

    public final void dxB() {
        AppMethodBeat.m2504i(31894);
        this.yTn.dead();
        AppMethodBeat.m2505o(31894);
    }

    public final void dEm() {
        AppMethodBeat.m2504i(31895);
        C4990ab.m7416i("MicroMsg.AppBrandServiceComponent", "updateStaticTitle()");
        if (C5046bo.isNullOrNil(this.hIF)) {
            this.cgL.yTx.setMMTitle(this.cgL.dDw());
        } else {
            this.cgL.yTx.setMMTitle(this.hIF);
        }
        if (C5046bo.isNullOrNil(this.hIG)) {
            this.yTo = C40663b.aqK(C40663b.aqJ(this.cgL.getTalkerUserName()));
            if (C5046bo.isNullOrNil(this.yTo)) {
                this.cgL.yTx.setMMSubTitle((int) C25738R.string.f9054ny);
            } else {
                this.cgL.yTx.setMMSubTitle(C4996ah.getContext().getString(C25738R.string.f9054ny) + "-" + this.yTo);
            }
        } else {
            this.cgL.yTx.setMMSubTitle(this.hIG);
        }
        if (this.yTm) {
            ((C44299r) this.cgL.mo74857aF(C44299r.class)).mo64257OA(0);
            AppMethodBeat.m2505o(31895);
            return;
        }
        ((C44299r) this.cgL.mo74857aF(C44299r.class)).mo64257OA(8);
        AppMethodBeat.m2505o(31895);
    }

    public final void dFq() {
        AppMethodBeat.m2504i(31896);
        this.cgL.yTx.addIconOptionMenu(0, (int) C25738R.string.f8971l9, (int) C25738R.drawable.f6899uu, new C249592());
        AppMethodBeat.m2505o(31896);
    }

    /* Access modifiers changed, original: protected|final */
    public final String getAppId() {
        AppMethodBeat.m2504i(31897);
        if (!C5046bo.isNullOrNil(this.hID)) {
            this.appId = this.hID;
        }
        if (C5046bo.isNullOrNil(this.appId)) {
            WxaAttributes zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(this.cgL.getTalkerUserName());
            this.appId = zb == null ? null : zb.field_appId;
        }
        if (C5046bo.isNullOrNil(this.appId)) {
            C4990ab.m7412e("MicroMsg.AppBrandServiceComponent", "error, appId is null");
        }
        String str = this.appId;
        AppMethodBeat.m2505o(31897);
        return str;
    }

    public final String dFr() {
        return this.hIH;
    }
}
