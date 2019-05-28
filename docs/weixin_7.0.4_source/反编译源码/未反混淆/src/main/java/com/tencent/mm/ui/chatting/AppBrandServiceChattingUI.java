package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.TypedValue;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j;
import com.tencent.mm.g.a.jj;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.b;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.appbrand.c;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.c.c.a;
import com.tencent.mm.ui.chatting.viewitems.c.d;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.io.ByteArrayOutputStream;

public class AppBrandServiceChattingUI extends ChattingUI {

    @SuppressLint({"ValidFragment"})
    public static class AppBrandServiceChattingFmUI extends ChattingUIFragment {
        private String appId;
        private int fromScene;
        private String hIn;
        private String hIo;
        private String hIp;
        private boolean hIq;
        private String hIr;
        private boolean hIs;
        private b hhQ;
        private WxaExposedParams iIa;
        private String mSceneId;
        private com.tencent.mm.ui.chatting.c.c.b yGA = new com.tencent.mm.ui.chatting.c.c.b(new a());
        private final e yGx = new e() {
            public final boolean oS(boolean z) {
                AppMethodBeat.i(30348);
                if (AppBrandServiceChattingFmUI.this.hhQ != null) {
                    b.a aVar = (b.a) AppBrandServiceChattingFmUI.this.hhQ.hhZ.get(0);
                    if (AppBrandServiceChattingFmUI.this.fromScene == 2 && AppBrandServiceChattingFmUI.this.iIa.username.equals(aVar.userName)) {
                        ab.i("MicroMsg.AppBrandServiceChattingUI", "[bizmenu]onBackFromContact username:%s path:%s", aVar.userName, aVar.csu);
                        AppBrandServiceChattingFmUI.a(AppBrandServiceChattingFmUI.this, aVar.csu);
                        AppMethodBeat.o(30348);
                    } else {
                        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                        appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
                        ((com.tencent.mm.plugin.appbrand.service.e) g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(AppBrandServiceChattingFmUI.this.getContext(), aVar.userName, "", 0, aVar.version, aVar.csu, appBrandStatObject, AppBrandServiceChattingFmUI.d(AppBrandServiceChattingFmUI.this));
                        AppMethodBeat.o(30348);
                    }
                } else {
                    ab.e("MicroMsg.AppBrandServiceChattingUI", "[mOnOpenMiniProgramBtnClickListener]wxaBizMenu or wxaBizMenu.ButtonList is empty, error");
                    AppMethodBeat.o(30348);
                }
                return true;
            }
        };
        private com.tencent.mm.pluginsdk.ui.e.g yGy = new com.tencent.mm.pluginsdk.ui.e.g() {
            public final Object a(m mVar) {
                AppMethodBeat.i(30349);
                switch (mVar.type) {
                    case 1:
                    case 25:
                    case 30:
                    case 31:
                        Object talkerUserName = AppBrandServiceChattingFmUI.this.cgL.getTalkerUserName();
                        AppMethodBeat.o(30349);
                        return talkerUserName;
                    default:
                        AppMethodBeat.o(30349);
                        return null;
                }
            }

            public final Object b(m mVar) {
                AppMethodBeat.i(30350);
                if (mVar.type == 45) {
                    String str = new String(Base64.decode(mVar.url, 0));
                    String str2 = new String(Base64.decode(bo.bc((String) mVar.au(String.class), ""), 0));
                    ab.d("MicroMsg.AppBrandServiceChattingUI", "appId:%s,path:%s", str, str2);
                    if (AppBrandServiceChattingFmUI.this.fromScene == 2 && AppBrandServiceChattingFmUI.this.iIa.appId.equals(str)) {
                        ab.i("MicroMsg.AppBrandServiceChattingUI", "onBackFromContact appId:%s path:%s", str, str2);
                        AppBrandServiceChattingFmUI.a(AppBrandServiceChattingFmUI.this, str2);
                        Boolean bool = Boolean.TRUE;
                        AppMethodBeat.o(30350);
                        return bool;
                    }
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHE;
                    ((com.tencent.mm.plugin.appbrand.service.e) g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(AppBrandServiceChattingFmUI.this.getContext(), null, str, 0, 0, str2, appBrandStatObject);
                }
                AppMethodBeat.o(30350);
                return null;
            }
        };
        private c yGz;

        /* renamed from: com.tencent.mm.ui.chatting.AppBrandServiceChattingUI$AppBrandServiceChattingFmUI$3 */
        public class AnonymousClass3 extends d {
            public AnonymousClass3(com.tencent.mm.ui.chatting.d.a aVar, com.tencent.mm.ui.chatting.viewitems.c cVar) {
                super(aVar, cVar);
            }

            public final void a(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
                AppMethodBeat.i(30351);
                ab.d("MicroMsg.AppBrandServiceChattingUI", "clickListener ChattingListClickListener onClick");
                view.getTag();
                if (biVar.drE()) {
                    super.a(view, aVar, biVar);
                    AppMethodBeat.o(30351);
                } else if (biVar.bAA()) {
                    String str = biVar.field_content;
                    if (str == null) {
                        AppMethodBeat.o(30351);
                        return;
                    }
                    j.b me = j.b.me(str);
                    if (me == null) {
                        AppMethodBeat.o(30351);
                    } else if (AppBrandServiceChattingFmUI.this.fromScene == 2 && me.type == 33 && AppBrandServiceChattingFmUI.this.iIa.appId.equals(me.fiQ)) {
                        AppBrandServiceChattingFmUI.a(AppBrandServiceChattingFmUI.this, me.fiO);
                        AppMethodBeat.o(30351);
                    } else {
                        super.a(view, aVar, biVar);
                        AppMethodBeat.o(30351);
                    }
                } else {
                    super.a(view, aVar, biVar);
                    AppMethodBeat.o(30351);
                }
            }
        }

        static /* synthetic */ String d(AppBrandServiceChattingFmUI appBrandServiceChattingFmUI) {
            AppMethodBeat.i(30366);
            String appId = appBrandServiceChattingFmUI.getAppId();
            AppMethodBeat.o(30366);
            return appId;
        }

        public AppBrandServiceChattingFmUI() {
            AppMethodBeat.i(30354);
            AppMethodBeat.o(30354);
        }

        public AppBrandServiceChattingFmUI(byte b) {
            super((byte) 0);
            AppMethodBeat.i(30355);
            AppMethodBeat.o(30355);
        }

        public final void dBr() {
            AppMethodBeat.i(30357);
            super.dBr();
            com.tencent.mm.pluginsdk.ui.e.j.a(this.yGy);
            AppMethodBeat.o(30357);
        }

        public final void onEnterBegin() {
            b bVar;
            AppMethodBeat.i(30358);
            super.onEnterBegin();
            String talkerUserName = this.cgL.getTalkerUserName();
            if (TextUtils.isEmpty(talkerUserName)) {
                bVar = null;
            } else {
                WxaAttributes zb = ((com.tencent.mm.plugin.appbrand.service.d) g.K(com.tencent.mm.plugin.appbrand.service.d.class)).zb(talkerUserName);
                if (zb != null) {
                    bVar = zb.ayN();
                } else {
                    ab.e("MicroMsg.AppBrandServiceHelper", "username:%s, attr is null or getWxaBizMenuByUsername return null", talkerUserName);
                    bVar = null;
                }
            }
            this.hhQ = bVar;
            if (this.hhQ != null && this.hhQ.hhZ.size() == 1) {
                ChatFooter dDX = ((o) this.cgL.aF(o.class)).dDX();
                dDX.setSwitchButtonMode(1);
                dDX.setOnFooterSwitchListener(this.yGx);
            } else if (this.hhQ == null || this.hhQ.hhZ == null) {
                ab.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu or wxaBizMenu.buttonList is empty");
            } else {
                ab.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu.buttonList.size():%d", Integer.valueOf(this.hhQ.hhZ.size()));
            }
            if (this.fromScene == 2) {
                aw.Rg().a(new com.tencent.mm.modelsimple.g(this.cgL.getTalkerUserName(), 19, getStringExtra("key_temp_session_from")), 0);
                String appId = getAppId();
                talkerUserName = this.cgL.getTalkerUserName();
                int i = this.fromScene;
                aw.ZK();
                ak aoZ = com.tencent.mm.model.c.XR().aoZ(talkerUserName);
                if (aoZ == null) {
                    ab.e("MicroMsg.AppBrandServiceChattingUI", "cvs:%s is null, error", talkerUserName);
                } else {
                    int i2 = aoZ.field_unReadCount;
                    String nullAsNil = bo.nullAsNil(this.mSceneId);
                    ab.d("MicroMsg.AppBrandServiceChattingUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", Integer.valueOf(13799), appId, Integer.valueOf(i), Integer.valueOf(i2), nullAsNil);
                    h.pYm.e(13799, appId, Integer.valueOf(i), Integer.valueOf(i2), nullAsNil, Long.valueOf(bo.anT()));
                }
                ab.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onActivityCreated NetSceneEnterTempSession");
            }
            AppMethodBeat.o(30358);
        }

        private String getAppId() {
            AppMethodBeat.i(30359);
            if (bo.isNullOrNil(this.appId)) {
                WxaAttributes zb = ((com.tencent.mm.plugin.appbrand.service.d) g.K(com.tencent.mm.plugin.appbrand.service.d.class)).zb(this.cgL.getTalkerUserName());
                this.appId = zb == null ? null : zb.field_appId;
            }
            if (bo.isNullOrNil(this.appId)) {
                ab.e("MicroMsg.AppBrandServiceChattingUI", "error, appId is null");
            }
            String str = this.appId;
            AppMethodBeat.o(30359);
            return str;
        }

        /* Access modifiers changed, original: protected|final */
        public final void dBs() {
            AppMethodBeat.i(30360);
            super.dBs();
            jj jjVar = new jj();
            jjVar.cEF.cEA = 0;
            jjVar.cEF.aOt = aa.dor();
            if (t.kH(this.cgL.getTalkerUserName())) {
                jjVar.cEF.cEH = true;
            } else {
                jjVar.cEF.cEH = false;
            }
            com.tencent.mm.sdk.b.a.xxA.m(jjVar);
            AppMethodBeat.o(30360);
        }

        public final void cch() {
            AppMethodBeat.i(30361);
            p pVar;
            if (this.fromScene == 2) {
                aw.ZK();
                ak aoZ = com.tencent.mm.model.c.XR().aoZ("appbrandcustomerservicemsg");
                if (aoZ == null || bo.isNullOrNil(aoZ.field_username)) {
                    ab.e("MicroMsg.AppBrandServiceChattingUI", "update Unread: can not find SPUSER_APP_BRAND_SERVICE cvs");
                } else {
                    int i = aoZ.field_unReadCount;
                    l lVar = new l();
                    lVar.csj.csl = this.cgL.getTalkerUserName();
                    com.tencent.mm.sdk.b.a.xxA.m(lVar);
                    ab.i("MicroMsg.AppBrandServiceChattingUI", "parUnReadCount:%d, unReadCount:%d", Integer.valueOf(i), Integer.valueOf(lVar.csk.csm));
                    aoZ.hM(Math.max(0, i - r2));
                    aw.ZK();
                    if (com.tencent.mm.model.c.XR().a(aoZ, aoZ.field_username) == -1) {
                        ab.e("MicroMsg.AppBrandServiceChattingUI", "update SPUSER_APP_BRAND_SERVICE cvs unread failed");
                    } else {
                        pVar = new p();
                        pVar.csz.csl = this.cgL.getTalkerUserName();
                        pVar.csz.csm = 0;
                        com.tencent.mm.sdk.b.a.xxA.m(pVar);
                    }
                }
            } else {
                ab.i("MicroMsg.AppBrandServiceChattingUI", "writeOpLogAndMarkRead clear AppBrandKvData username:%s", this.cgL.getTalkerUserName());
                pVar = new p();
                pVar.csz.csl = this.cgL.getTalkerUserName();
                pVar.csz.csm = 0;
                com.tencent.mm.sdk.b.a.xxA.m(pVar);
            }
            super.cch();
            AppMethodBeat.o(30361);
        }

        public void onViewAttachedToWindow(View view) {
            AppMethodBeat.i(30362);
            super.onViewAttachedToWindow(view);
            if (this.fromScene == 2 && this.hIq) {
                if (this.yGz == null) {
                    ChatFooter dDX = ((o) this.cgL.aF(o.class)).dDX();
                    this.yGz = new c(getActivity(), dDX.getRootView(), dDX, !bo.isNullOrNil(dDX.getLastText()));
                    this.yGz.vou = false;
                }
                if (bo.isNullOrNil(this.hIr)) {
                    com.tencent.mm.modelappbrand.a.b.abR().a(this.yGz, this.hIp, null, ((i) g.K(i.class)).cq((int) Li(75), (int) Li(60)));
                } else {
                    com.tencent.mm.modelappbrand.a.b.abR().a(this.yGz, "file://" + this.hIr, null, ((i) g.K(i.class)).cq((int) Li(75), (int) Li(60)));
                }
                this.yGz.yrt = new c.a() {
                    public final void dzn() {
                        AppMethodBeat.i(30353);
                        AppBrandServiceChattingFmUI.this.hideVKB();
                        aw.RS().aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(30352);
                                AppBrandServiceChattingFmUI.e(AppBrandServiceChattingFmUI.this);
                                AppMethodBeat.o(30352);
                            }
                        });
                        AppMethodBeat.o(30353);
                    }
                };
                c cVar = this.yGz;
                ab.d("MicroMsg.AppBrandServiceImageBubble", "show");
                aw.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(29961);
                        c.this.yru.sendEmptyMessage(0);
                        AppMethodBeat.o(29961);
                    }

                    public final String toString() {
                        AppMethodBeat.i(29962);
                        String str = super.toString() + "MicroMsg.AppBrandServiceImageBubbleshow";
                        AppMethodBeat.o(29962);
                        return str;
                    }
                });
            }
            AppMethodBeat.o(30362);
        }

        private float Li(int i) {
            AppMethodBeat.i(30363);
            float applyDimension = TypedValue.applyDimension(1, (float) i, getContext().getResources().getDisplayMetrics());
            AppMethodBeat.o(30363);
            return applyDimension;
        }

        public final void dBt() {
            AppMethodBeat.i(30364);
            super.dBt();
            com.tencent.mm.pluginsdk.ui.e.j.b(this.yGy);
            AppMethodBeat.o(30364);
        }

        public final void dBq() {
            AppMethodBeat.i(30356);
            if (!this.cgL.yTu.yYL.containsKey(com.tencent.mm.ui.chatting.c.b.a.class)) {
                this.cgL.a(com.tencent.mm.ui.chatting.c.b.a.class, this.yGA);
            }
            super.dBq();
            this.fromScene = getIntExtra("app_brand_chatting_from_scene", 1);
            this.iIa = (WxaExposedParams) getParcelableExtra("app_brand_chatting_expose_params");
            this.mSceneId = bo.nullAsNil(getStringExtra("key_scene_id"));
            this.hIn = getStringExtra("sendMessageTitle");
            this.hIo = getStringExtra("sendMessagePath");
            this.hIp = getStringExtra("sendMessageImg");
            this.hIr = getStringExtra("sendMessageLocalImg");
            this.hIq = getBooleanExtra("showMessageCard", false).booleanValue();
            this.hIs = getBooleanExtra("needDelThumb", false).booleanValue();
            ab.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate fromScene:%d", Integer.valueOf(this.fromScene));
            ab.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate wxaExposedParams:%s", this.iIa);
            ab.i("MicroMsg.AppBrandServiceChattingUI", "mSceneId:%s, sendMessageTitle:%s, sendMessagePath:%s, sendMessageImg:%s, showMessageCard:%b, needDelThumb:%b", this.mSceneId, this.hIn, this.hIo, this.hIp, Boolean.valueOf(this.hIq), Boolean.valueOf(this.hIs));
            AppMethodBeat.o(30356);
        }

        static /* synthetic */ void a(AppBrandServiceChattingFmUI appBrandServiceChattingFmUI, String str) {
            AppMethodBeat.i(30365);
            Intent intent = new Intent();
            intent.putExtra("keyOutPagePath", str);
            appBrandServiceChattingFmUI.thisActivity().setResult(-1, intent);
            appBrandServiceChattingFmUI.finish();
            AppMethodBeat.o(30365);
        }

        static /* synthetic */ void e(AppBrandServiceChattingFmUI appBrandServiceChattingFmUI) {
            Bitmap a;
            AppMethodBeat.i(30367);
            j.b bVar = new j.b();
            bVar.title = appBrandServiceChattingFmUI.hIn;
            bVar.type = 33;
            bVar.fiP = appBrandServiceChattingFmUI.iIa.username;
            bVar.fiO = bo.isNullOrNil(appBrandServiceChattingFmUI.hIo) ? appBrandServiceChattingFmUI.iIa.pageId : appBrandServiceChattingFmUI.hIo;
            bVar.fiQ = appBrandServiceChattingFmUI.iIa.appId;
            bVar.fiZ = appBrandServiceChattingFmUI.iIa.gVt;
            bVar.fja = appBrandServiceChattingFmUI.iIa.gVu;
            bVar.fiS = appBrandServiceChattingFmUI.iIa.hiv;
            bVar.fiR = 2;
            bVar.url = appBrandServiceChattingFmUI.iIa.hiw;
            bVar.fjb = appBrandServiceChattingFmUI.iIa.iconUrl;
            bVar.cMm = "wxapp_" + appBrandServiceChattingFmUI.iIa.appId + appBrandServiceChattingFmUI.iIa.pageId;
            bVar.cMg = appBrandServiceChattingFmUI.iIa.username;
            bVar.cMh = appBrandServiceChattingFmUI.iIa.nickname;
            byte[] bArr = new byte[0];
            if (bo.isNullOrNil(appBrandServiceChattingFmUI.hIr)) {
                a = com.tencent.mm.modelappbrand.a.b.abR().a(appBrandServiceChattingFmUI.hIp, null);
            } else {
                a = com.tencent.mm.modelappbrand.a.b.abR().a("file://" + appBrandServiceChattingFmUI.hIr, null);
                if (a == null || a.isRecycled()) {
                    a = com.tencent.mm.sdk.platformtools.d.aml(appBrandServiceChattingFmUI.hIp);
                    if (appBrandServiceChattingFmUI.hIs) {
                        boolean deleteFile = com.tencent.mm.vfs.e.deleteFile(appBrandServiceChattingFmUI.hIr);
                        ab.v("MicroMsg.AppBrandServiceChattingUI", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", appBrandServiceChattingFmUI.hIp, Boolean.valueOf(deleteFile));
                    }
                }
            }
            if (a == null || a.isRecycled()) {
                ab.e("MicroMsg.AppBrandServiceChattingUI", "thumb image is null");
            } else {
                ab.i("MicroMsg.AppBrandServiceChattingUI", "thumb image is not null ");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                a.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
            }
            com.tencent.mm.pluginsdk.model.app.l.a(bVar, appBrandServiceChattingFmUI.getAppId(), appBrandServiceChattingFmUI.hIn, appBrandServiceChattingFmUI.cgL.getTalkerUserName(), null, bArr);
            AppMethodBeat.o(30367);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(30368);
        overridePendingTransition(0, 0);
        super.onCreate(null);
        AppMethodBeat.o(30368);
    }

    /* Access modifiers changed, original: protected|final */
    public final ChattingUIFragment dBp() {
        AppMethodBeat.i(30369);
        AppBrandServiceChattingFmUI appBrandServiceChattingFmUI = new AppBrandServiceChattingFmUI((byte) 0);
        AppMethodBeat.o(30369);
        return appBrandServiceChattingFmUI;
    }
}
