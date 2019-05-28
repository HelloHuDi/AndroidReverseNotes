package com.tencent.mm.ui.chatting.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.g.a.lo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.service.d;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.t;
import java.util.Iterator;

public final class a extends c {
    private com.tencent.mm.ui.appbrand.a appBrandServiceActionSheet;
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
    private c<lo> yTn = new c<lo>() {
        {
            AppMethodBeat.i(31887);
            this.xxI = lo.class.getName().hashCode();
            AppMethodBeat.o(31887);
        }

        public final /* synthetic */ boolean a(b bVar) {
            boolean z = false;
            AppMethodBeat.i(31888);
            lo loVar = (lo) bVar;
            if (loVar.cHo == null || loVar.cHo.csl == null) {
                ab.e("MicroMsg.AppBrandServiceComponent", "OnWxaOptionsChangedEvent event is empty");
                AppMethodBeat.o(31888);
                return false;
            }
            ab.d("MicroMsg.AppBrandServiceComponent", "OnWxaOptionsChangedEvent username:%s,event.brandId:%s,event.newValue:%d", a.this.cgL.getTalkerUserName(), loVar.cHo.csl, Integer.valueOf(loVar.cHo.cHp));
            if (loVar.cHo.csl.equals(a.this.cgL.getTalkerUserName())) {
                a aVar = a.this;
                if ((loVar.cHo.cHp & 2) > 0) {
                    z = true;
                }
                aVar.yTm = z;
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(31886);
                        if (a.this.yTm) {
                            ab.d("MicroMsg.AppBrandServiceComponent", "OnWxaOptionsChangedEvent refuse:%b, setRejectIcon View.Visible", Boolean.valueOf(a.this.yTm));
                            ((r) a.this.cgL.aF(r.class)).OA(0);
                            AppMethodBeat.o(31886);
                            return;
                        }
                        ab.d("MicroMsg.AppBrandServiceComponent", "OnWxaOptionsChangedEvent refuse:%b, setRejectIcon View.GONE", Boolean.valueOf(a.this.yTm));
                        ((r) a.this.cgL.aF(r.class)).OA(8);
                        AppMethodBeat.o(31886);
                    }
                });
            }
            AppMethodBeat.o(31888);
            return true;
        }
    };
    private String yTo = "";

    public a() {
        AppMethodBeat.i(31891);
        AppMethodBeat.o(31891);
    }

    public final void dxx() {
        AppMethodBeat.i(31892);
        this.emC = this.cgL.yTx.getIntExtra("app_brand_chatting_from_scene", 1);
        this.yTl = (WxaExposedParams) this.cgL.yTx.getParcelableExtra("app_brand_chatting_expose_params");
        this.mSceneId = bo.nullAsNil(this.cgL.yTx.getStringExtra("key_scene_id"));
        ab.i("MicroMsg.AppBrandServiceComponent", "onChattingInit() fromScene:%d wxaExposedParams:%s mSceneId:%s", Integer.valueOf(this.emC), this.yTl, this.mSceneId);
        this.hID = this.cgL.yTx.getStringExtra("keyPrivateAppId");
        if (!bo.isNullOrNil(this.hID)) {
            this.hIE = this.cgL.yTx.getStringExtra("keyPrivateUserName");
            this.hIF = this.cgL.yTx.getStringExtra("keyPrivateTitle");
            this.hIG = this.cgL.yTx.getStringExtra("keyPrivateSubTitle");
            this.hIH = this.cgL.yTx.getStringExtra("keyPrivateHeadImage");
            ab.i("MicroMsg.AppBrandServiceComponent", "onChattingInit customized appId:%s, username:%s, title:%s, subtitle:%s, headImage:%s", this.hID, this.hIE, this.hIF, this.hIG, this.hIH);
        }
        this.appBrandServiceActionSheet = new com.tencent.mm.ui.appbrand.a(this.cgL.yTx.getContext());
        WxaAttributes zb = ((d) g.K(d.class)).zb(this.cgL.getTalkerUserName());
        boolean z = zb != null && (zb.field_appOpt & 2) > 0;
        this.yTm = z;
        String talkerUserName = this.cgL.getTalkerUserName();
        String appId = getAppId();
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsI = 2912;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getkefusessioninfo";
        aVar.fsL = 0;
        aVar.fsM = 0;
        ajz ajz = new ajz();
        talkerUserName = com.tencent.mm.ui.appbrand.b.aqJ(talkerUserName);
        if (bo.isNullOrNil(talkerUserName)) {
            ajz.csB = appId;
            ajz.wpz = "";
        } else {
            ajz.csB = com.tencent.mm.ui.appbrand.b.zm(talkerUserName);
            ajz.wpz = appId;
        }
        aVar.fsJ = ajz;
        aVar.fsK = new aka();
        w.a(aVar.acD(), new com.tencent.mm.ai.w.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                AppMethodBeat.i(29953);
                ab.i("MicroMsg.AppBrandServiceHelper", "callback, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                aka aka = (aka) bVar.fsH.fsP;
                if (i == 0 && i2 == 0 && aka != null && aka.wpA != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    Iterator it = aka.wpA.iterator();
                    while (it.hasNext()) {
                        stringBuilder.append(((String) it.next()) + "|");
                    }
                    ab.d("MicroMsg.AppBrandServiceHelper", "block_qr_prefix:%s, size:%d", stringBuilder.toString(), Integer.valueOf(aka.wpA.size()));
                    g.RP().Ry().set(a.APPBRAND_BLOCK_QRCODE_PREFIX_STRING_SYNC, stringBuilder.toString());
                }
                AppMethodBeat.o(29953);
                return 0;
            }
        });
        AppMethodBeat.o(31892);
    }

    public final void dxA() {
        AppMethodBeat.i(31893);
        this.yTn.dnU();
        AppMethodBeat.o(31893);
    }

    public final void dxB() {
        AppMethodBeat.i(31894);
        this.yTn.dead();
        AppMethodBeat.o(31894);
    }

    public final void dEm() {
        AppMethodBeat.i(31895);
        ab.i("MicroMsg.AppBrandServiceComponent", "updateStaticTitle()");
        if (bo.isNullOrNil(this.hIF)) {
            this.cgL.yTx.setMMTitle(this.cgL.dDw());
        } else {
            this.cgL.yTx.setMMTitle(this.hIF);
        }
        if (bo.isNullOrNil(this.hIG)) {
            this.yTo = com.tencent.mm.ui.appbrand.b.aqK(com.tencent.mm.ui.appbrand.b.aqJ(this.cgL.getTalkerUserName()));
            if (bo.isNullOrNil(this.yTo)) {
                this.cgL.yTx.setMMSubTitle((int) R.string.ny);
            } else {
                this.cgL.yTx.setMMSubTitle(ah.getContext().getString(R.string.ny) + "-" + this.yTo);
            }
        } else {
            this.cgL.yTx.setMMSubTitle(this.hIG);
        }
        if (this.yTm) {
            ((r) this.cgL.aF(r.class)).OA(0);
            AppMethodBeat.o(31895);
            return;
        }
        ((r) this.cgL.aF(r.class)).OA(8);
        AppMethodBeat.o(31895);
    }

    public final void dFq() {
        AppMethodBeat.i(31896);
        this.cgL.yTx.addIconOptionMenu(0, (int) R.string.l9, (int) R.drawable.uu, new t() {
            public final void Kp() {
                AppMethodBeat.i(31890);
                a.this.cgL.aqX();
                al.d(new Runnable() {
                    public final void run() {
                        String aqK;
                        AppMethodBeat.i(31889);
                        String aqJ = com.tencent.mm.ui.appbrand.b.aqJ(a.this.cgL.getTalkerUserName());
                        if (bo.isNullOrNil(aqJ)) {
                            aqJ = a.this.cgL.getTalkerUserName();
                            if (bo.isNullOrNil(a.this.cgL.dDw())) {
                                aqK = com.tencent.mm.ui.appbrand.b.aqK(a.this.cgL.getTalkerUserName());
                            } else {
                                aqK = a.this.cgL.dDw();
                            }
                        } else {
                            aqK = com.tencent.mm.ui.appbrand.b.aqK(aqJ);
                        }
                        a.this.appBrandServiceActionSheet.username = a.this.cgL.getTalkerUserName();
                        a.this.appBrandServiceActionSheet.jnK = false;
                        a.this.appBrandServiceActionSheet.scene = a.this.emC;
                        a.this.appBrandServiceActionSheet.yrk = a.this.mSceneId;
                        if (a.this.emC == 2) {
                            a.this.appBrandServiceActionSheet.iIa = a.this.yTl;
                            if (a.this.yTm) {
                                a.this.appBrandServiceActionSheet.show(1);
                                AppMethodBeat.o(31889);
                                return;
                            }
                            a.this.appBrandServiceActionSheet.show(2);
                            AppMethodBeat.o(31889);
                            return;
                        }
                        com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a aVar = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a();
                        aVar.appId = com.tencent.mm.ui.appbrand.b.zm(aqJ);
                        aVar.from = 4;
                        aVar.username = aqJ;
                        aVar.nickname = aqK;
                        a.this.appBrandServiceActionSheet.iIa = aVar.ayP();
                        a.this.appBrandServiceActionSheet.appId = a.this.getAppId();
                        if (a.this.yTm) {
                            a.this.appBrandServiceActionSheet.show(5);
                            AppMethodBeat.o(31889);
                            return;
                        }
                        a.this.appBrandServiceActionSheet.show(6);
                        AppMethodBeat.o(31889);
                    }
                });
                AppMethodBeat.o(31890);
            }
        });
        AppMethodBeat.o(31896);
    }

    /* Access modifiers changed, original: protected|final */
    public final String getAppId() {
        AppMethodBeat.i(31897);
        if (!bo.isNullOrNil(this.hID)) {
            this.appId = this.hID;
        }
        if (bo.isNullOrNil(this.appId)) {
            WxaAttributes zb = ((d) g.K(d.class)).zb(this.cgL.getTalkerUserName());
            this.appId = zb == null ? null : zb.field_appId;
        }
        if (bo.isNullOrNil(this.appId)) {
            ab.e("MicroMsg.AppBrandServiceComponent", "error, appId is null");
        }
        String str = this.appId;
        AppMethodBeat.o(31897);
        return str;
    }

    public final String dFr() {
        return this.hIH;
    }
}
