package com.tencent.p177mm.p612ui.chatting;

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
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelappbrand.C32809i;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelsimple.C37947g;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p230g.p231a.C18361p;
import com.tencent.p177mm.p230g.p231a.C26186l;
import com.tencent.p177mm.p230g.p231a.C45335jj;
import com.tencent.p177mm.p612ui.appbrand.C36039c;
import com.tencent.p177mm.p612ui.appbrand.C36039c.C360414;
import com.tencent.p177mm.p612ui.appbrand.C36039c.C5233a;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p1364c.C40728a;
import com.tencent.p177mm.p612ui.chatting.p616c.p1364c.C41345b;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15614o;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40722a;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5387d;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C26832b;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C26832b.C26833a;
import com.tencent.p177mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C42686d;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14932m;
import com.tencent.p177mm.pluginsdk.p597ui.chat.ChatFooter;
import com.tencent.p177mm.pluginsdk.p597ui.chat.ChatFooter.C35868e;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44086g;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.io.ByteArrayOutputStream;

/* renamed from: com.tencent.mm.ui.chatting.AppBrandServiceChattingUI */
public class AppBrandServiceChattingUI extends ChattingUI {

    @SuppressLint({"ValidFragment"})
    /* renamed from: com.tencent.mm.ui.chatting.AppBrandServiceChattingUI$AppBrandServiceChattingFmUI */
    public static class AppBrandServiceChattingFmUI extends ChattingUIFragment {
        private String appId;
        private int fromScene;
        private String hIn;
        private String hIo;
        private String hIp;
        private boolean hIq;
        private String hIr;
        private boolean hIs;
        private C26832b hhQ;
        private WxaExposedParams iIa;
        private String mSceneId;
        private C41345b yGA = new C41345b(new C40728a());
        private final C35868e yGx = new C304161();
        private C44086g yGy = new C155522();
        private C36039c yGz;

        /* renamed from: com.tencent.mm.ui.chatting.AppBrandServiceChattingUI$AppBrandServiceChattingFmUI$2 */
        class C155522 implements C44086g {
            C155522() {
            }

            /* renamed from: a */
            public final Object mo27726a(C14932m c14932m) {
                AppMethodBeat.m2504i(30349);
                switch (c14932m.type) {
                    case 1:
                    case 25:
                    case 30:
                    case 31:
                        Object talkerUserName = AppBrandServiceChattingFmUI.this.cgL.getTalkerUserName();
                        AppMethodBeat.m2505o(30349);
                        return talkerUserName;
                    default:
                        AppMethodBeat.m2505o(30349);
                        return null;
                }
            }

            /* renamed from: b */
            public final Object mo27727b(C14932m c14932m) {
                AppMethodBeat.m2504i(30350);
                if (c14932m.type == 45) {
                    String str = new String(Base64.decode(c14932m.url, 0));
                    String str2 = new String(Base64.decode(C5046bo.m7532bc((String) c14932m.mo27270au(String.class), ""), 0));
                    C4990ab.m7411d("MicroMsg.AppBrandServiceChattingUI", "appId:%s,path:%s", str, str2);
                    if (AppBrandServiceChattingFmUI.this.fromScene == 2 && AppBrandServiceChattingFmUI.this.iIa.appId.equals(str)) {
                        C4990ab.m7417i("MicroMsg.AppBrandServiceChattingUI", "onBackFromContact appId:%s path:%s", str, str2);
                        AppBrandServiceChattingFmUI.m48507a(AppBrandServiceChattingFmUI.this, str2);
                        Boolean bool = Boolean.TRUE;
                        AppMethodBeat.m2505o(30350);
                        return bool;
                    }
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_QINGCHE;
                    ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(AppBrandServiceChattingFmUI.this.getContext(), null, str, 0, 0, str2, appBrandStatObject);
                }
                AppMethodBeat.m2505o(30350);
                return null;
            }
        }

        /* renamed from: com.tencent.mm.ui.chatting.AppBrandServiceChattingUI$AppBrandServiceChattingFmUI$3 */
        public class C155533 extends C5387d {
            public C155533(C46650a c46650a, C5378c c5378c) {
                super(c46650a, c5378c);
            }

            /* renamed from: a */
            public final void mo10992a(View view, C46650a c46650a, C7620bi c7620bi) {
                AppMethodBeat.m2504i(30351);
                C4990ab.m7410d("MicroMsg.AppBrandServiceChattingUI", "clickListener ChattingListClickListener onClick");
                view.getTag();
                if (c7620bi.drE()) {
                    super.mo10992a(view, c46650a, c7620bi);
                    AppMethodBeat.m2505o(30351);
                } else if (c7620bi.bAA()) {
                    String str = c7620bi.field_content;
                    if (str == null) {
                        AppMethodBeat.m2505o(30351);
                        return;
                    }
                    C8910b me = C8910b.m16064me(str);
                    if (me == null) {
                        AppMethodBeat.m2505o(30351);
                    } else if (AppBrandServiceChattingFmUI.this.fromScene == 2 && me.type == 33 && AppBrandServiceChattingFmUI.this.iIa.appId.equals(me.fiQ)) {
                        AppBrandServiceChattingFmUI.m48507a(AppBrandServiceChattingFmUI.this, me.fiO);
                        AppMethodBeat.m2505o(30351);
                    } else {
                        super.mo10992a(view, c46650a, c7620bi);
                        AppMethodBeat.m2505o(30351);
                    }
                } else {
                    super.mo10992a(view, c46650a, c7620bi);
                    AppMethodBeat.m2505o(30351);
                }
            }
        }

        /* renamed from: com.tencent.mm.ui.chatting.AppBrandServiceChattingUI$AppBrandServiceChattingFmUI$1 */
        class C304161 implements C35868e {
            C304161() {
            }

            /* renamed from: oS */
            public final boolean mo48814oS(boolean z) {
                AppMethodBeat.m2504i(30348);
                if (AppBrandServiceChattingFmUI.this.hhQ != null) {
                    C26833a c26833a = (C26833a) AppBrandServiceChattingFmUI.this.hhQ.hhZ.get(0);
                    if (AppBrandServiceChattingFmUI.this.fromScene == 2 && AppBrandServiceChattingFmUI.this.iIa.username.equals(c26833a.userName)) {
                        C4990ab.m7417i("MicroMsg.AppBrandServiceChattingUI", "[bizmenu]onBackFromContact username:%s path:%s", c26833a.userName, c26833a.csu);
                        AppBrandServiceChattingFmUI.m48507a(AppBrandServiceChattingFmUI.this, c26833a.csu);
                        AppMethodBeat.m2505o(30348);
                    } else {
                        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                        appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
                        ((C45691e) C1720g.m3528K(C45691e.class)).mo68046a(AppBrandServiceChattingFmUI.this.getContext(), c26833a.userName, "", 0, c26833a.version, c26833a.csu, appBrandStatObject, AppBrandServiceChattingFmUI.m48510d(AppBrandServiceChattingFmUI.this));
                        AppMethodBeat.m2505o(30348);
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.AppBrandServiceChattingUI", "[mOnOpenMiniProgramBtnClickListener]wxaBizMenu or wxaBizMenu.ButtonList is empty, error");
                    AppMethodBeat.m2505o(30348);
                }
                return true;
            }
        }

        /* renamed from: com.tencent.mm.ui.chatting.AppBrandServiceChattingUI$AppBrandServiceChattingFmUI$4 */
        class C304184 implements C5233a {

            /* renamed from: com.tencent.mm.ui.chatting.AppBrandServiceChattingUI$AppBrandServiceChattingFmUI$4$1 */
            class C304171 implements Runnable {
                C304171() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(30352);
                    AppBrandServiceChattingFmUI.m48511e(AppBrandServiceChattingFmUI.this);
                    AppMethodBeat.m2505o(30352);
                }
            }

            C304184() {
            }

            public final void dzn() {
                AppMethodBeat.m2504i(30353);
                AppBrandServiceChattingFmUI.this.hideVKB();
                C9638aw.m17180RS().mo10302aa(new C304171());
                AppMethodBeat.m2505o(30353);
            }
        }

        /* renamed from: d */
        static /* synthetic */ String m48510d(AppBrandServiceChattingFmUI appBrandServiceChattingFmUI) {
            AppMethodBeat.m2504i(30366);
            String appId = appBrandServiceChattingFmUI.getAppId();
            AppMethodBeat.m2505o(30366);
            return appId;
        }

        public AppBrandServiceChattingFmUI() {
            AppMethodBeat.m2504i(30354);
            AppMethodBeat.m2505o(30354);
        }

        public AppBrandServiceChattingFmUI(byte b) {
            super((byte) 0);
            AppMethodBeat.m2504i(30355);
            AppMethodBeat.m2505o(30355);
        }

        public final void dBr() {
            AppMethodBeat.m2504i(30357);
            super.dBr();
            C44089j.m79291a(this.yGy);
            AppMethodBeat.m2505o(30357);
        }

        public final void onEnterBegin() {
            C26832b c26832b;
            AppMethodBeat.m2504i(30358);
            super.onEnterBegin();
            String talkerUserName = this.cgL.getTalkerUserName();
            if (TextUtils.isEmpty(talkerUserName)) {
                c26832b = null;
            } else {
                WxaAttributes zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(talkerUserName);
                if (zb != null) {
                    c26832b = zb.ayN();
                } else {
                    C4990ab.m7413e("MicroMsg.AppBrandServiceHelper", "username:%s, attr is null or getWxaBizMenuByUsername return null", talkerUserName);
                    c26832b = null;
                }
            }
            this.hhQ = c26832b;
            if (this.hhQ != null && this.hhQ.hhZ.size() == 1) {
                ChatFooter dDX = ((C15614o) this.cgL.mo74857aF(C15614o.class)).dDX();
                dDX.setSwitchButtonMode(1);
                dDX.setOnFooterSwitchListener(this.yGx);
            } else if (this.hhQ == null || this.hhQ.hhZ == null) {
                C4990ab.m7412e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu or wxaBizMenu.buttonList is empty");
            } else {
                C4990ab.m7413e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu.buttonList.size():%d", Integer.valueOf(this.hhQ.hhZ.size()));
            }
            if (this.fromScene == 2) {
                C9638aw.m17182Rg().mo14541a(new C37947g(this.cgL.getTalkerUserName(), 19, getStringExtra("key_temp_session_from")), 0);
                String appId = getAppId();
                talkerUserName = this.cgL.getTalkerUserName();
                int i = this.fromScene;
                C9638aw.m17190ZK();
                C7617ak aoZ = C18628c.m29083XR().aoZ(talkerUserName);
                if (aoZ == null) {
                    C4990ab.m7413e("MicroMsg.AppBrandServiceChattingUI", "cvs:%s is null, error", talkerUserName);
                } else {
                    int i2 = aoZ.field_unReadCount;
                    String nullAsNil = C5046bo.nullAsNil(this.mSceneId);
                    C4990ab.m7411d("MicroMsg.AppBrandServiceChattingUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", Integer.valueOf(13799), appId, Integer.valueOf(i), Integer.valueOf(i2), nullAsNil);
                    C7060h.pYm.mo8381e(13799, appId, Integer.valueOf(i), Integer.valueOf(i2), nullAsNil, Long.valueOf(C5046bo.anT()));
                }
                C4990ab.m7416i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onActivityCreated NetSceneEnterTempSession");
            }
            AppMethodBeat.m2505o(30358);
        }

        private String getAppId() {
            AppMethodBeat.m2504i(30359);
            if (C5046bo.isNullOrNil(this.appId)) {
                WxaAttributes zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(this.cgL.getTalkerUserName());
                this.appId = zb == null ? null : zb.field_appId;
            }
            if (C5046bo.isNullOrNil(this.appId)) {
                C4990ab.m7412e("MicroMsg.AppBrandServiceChattingUI", "error, appId is null");
            }
            String str = this.appId;
            AppMethodBeat.m2505o(30359);
            return str;
        }

        /* Access modifiers changed, original: protected|final */
        public final void dBs() {
            AppMethodBeat.m2504i(30360);
            super.dBs();
            C45335jj c45335jj = new C45335jj();
            c45335jj.cEF.cEA = 0;
            c45335jj.cEF.aOt = C4988aa.dor();
            if (C1855t.m3896kH(this.cgL.getTalkerUserName())) {
                c45335jj.cEF.cEH = true;
            } else {
                c45335jj.cEF.cEH = false;
            }
            C4879a.xxA.mo10055m(c45335jj);
            AppMethodBeat.m2505o(30360);
        }

        public final void cch() {
            AppMethodBeat.m2504i(30361);
            C18361p c18361p;
            if (this.fromScene == 2) {
                C9638aw.m17190ZK();
                C7617ak aoZ = C18628c.m29083XR().aoZ("appbrandcustomerservicemsg");
                if (aoZ == null || C5046bo.isNullOrNil(aoZ.field_username)) {
                    C4990ab.m7412e("MicroMsg.AppBrandServiceChattingUI", "update Unread: can not find SPUSER_APP_BRAND_SERVICE cvs");
                } else {
                    int i = aoZ.field_unReadCount;
                    C26186l c26186l = new C26186l();
                    c26186l.csj.csl = this.cgL.getTalkerUserName();
                    C4879a.xxA.mo10055m(c26186l);
                    C4990ab.m7417i("MicroMsg.AppBrandServiceChattingUI", "parUnReadCount:%d, unReadCount:%d", Integer.valueOf(i), Integer.valueOf(c26186l.csk.csm));
                    aoZ.mo14748hM(Math.max(0, i - r2));
                    C9638aw.m17190ZK();
                    if (C18628c.m29083XR().mo15767a(aoZ, aoZ.field_username) == -1) {
                        C4990ab.m7412e("MicroMsg.AppBrandServiceChattingUI", "update SPUSER_APP_BRAND_SERVICE cvs unread failed");
                    } else {
                        c18361p = new C18361p();
                        c18361p.csz.csl = this.cgL.getTalkerUserName();
                        c18361p.csz.csm = 0;
                        C4879a.xxA.mo10055m(c18361p);
                    }
                }
            } else {
                C4990ab.m7417i("MicroMsg.AppBrandServiceChattingUI", "writeOpLogAndMarkRead clear AppBrandKvData username:%s", this.cgL.getTalkerUserName());
                c18361p = new C18361p();
                c18361p.csz.csl = this.cgL.getTalkerUserName();
                c18361p.csz.csm = 0;
                C4879a.xxA.mo10055m(c18361p);
            }
            super.cch();
            AppMethodBeat.m2505o(30361);
        }

        public void onViewAttachedToWindow(View view) {
            AppMethodBeat.m2504i(30362);
            super.onViewAttachedToWindow(view);
            if (this.fromScene == 2 && this.hIq) {
                if (this.yGz == null) {
                    ChatFooter dDX = ((C15614o) this.cgL.mo74857aF(C15614o.class)).dDX();
                    this.yGz = new C36039c(getActivity(), dDX.getRootView(), dDX, !C5046bo.isNullOrNil(dDX.getLastText()));
                    this.yGz.vou = false;
                }
                if (C5046bo.isNullOrNil(this.hIr)) {
                    C37926b.abR().mo60686a(this.yGz, this.hIp, null, ((C32809i) C1720g.m3528K(C32809i.class)).mo22292cq((int) m48505Li(75), (int) m48505Li(60)));
                } else {
                    C37926b.abR().mo60686a(this.yGz, "file://" + this.hIr, null, ((C32809i) C1720g.m3528K(C32809i.class)).mo22292cq((int) m48505Li(75), (int) m48505Li(60)));
                }
                this.yGz.yrt = new C304184();
                C36039c c36039c = this.yGz;
                C4990ab.m7410d("MicroMsg.AppBrandServiceImageBubble", "show");
                C9638aw.m17180RS().mo10302aa(new C360414());
            }
            AppMethodBeat.m2505o(30362);
        }

        /* renamed from: Li */
        private float m48505Li(int i) {
            AppMethodBeat.m2504i(30363);
            float applyDimension = TypedValue.applyDimension(1, (float) i, getContext().getResources().getDisplayMetrics());
            AppMethodBeat.m2505o(30363);
            return applyDimension;
        }

        public final void dBt() {
            AppMethodBeat.m2504i(30364);
            super.dBt();
            C44089j.m79297b(this.yGy);
            AppMethodBeat.m2505o(30364);
        }

        public final void dBq() {
            AppMethodBeat.m2504i(30356);
            if (!this.cgL.yTu.yYL.containsKey(C40722a.class)) {
                this.cgL.mo74856a(C40722a.class, this.yGA);
            }
            super.dBq();
            this.fromScene = getIntExtra("app_brand_chatting_from_scene", 1);
            this.iIa = (WxaExposedParams) getParcelableExtra("app_brand_chatting_expose_params");
            this.mSceneId = C5046bo.nullAsNil(getStringExtra("key_scene_id"));
            this.hIn = getStringExtra("sendMessageTitle");
            this.hIo = getStringExtra("sendMessagePath");
            this.hIp = getStringExtra("sendMessageImg");
            this.hIr = getStringExtra("sendMessageLocalImg");
            this.hIq = getBooleanExtra("showMessageCard", false).booleanValue();
            this.hIs = getBooleanExtra("needDelThumb", false).booleanValue();
            C4990ab.m7417i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate fromScene:%d", Integer.valueOf(this.fromScene));
            C4990ab.m7417i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate wxaExposedParams:%s", this.iIa);
            C4990ab.m7417i("MicroMsg.AppBrandServiceChattingUI", "mSceneId:%s, sendMessageTitle:%s, sendMessagePath:%s, sendMessageImg:%s, showMessageCard:%b, needDelThumb:%b", this.mSceneId, this.hIn, this.hIo, this.hIp, Boolean.valueOf(this.hIq), Boolean.valueOf(this.hIs));
            AppMethodBeat.m2505o(30356);
        }

        /* renamed from: a */
        static /* synthetic */ void m48507a(AppBrandServiceChattingFmUI appBrandServiceChattingFmUI, String str) {
            AppMethodBeat.m2504i(30365);
            Intent intent = new Intent();
            intent.putExtra("keyOutPagePath", str);
            appBrandServiceChattingFmUI.thisActivity().setResult(-1, intent);
            appBrandServiceChattingFmUI.finish();
            AppMethodBeat.m2505o(30365);
        }

        /* renamed from: e */
        static /* synthetic */ void m48511e(AppBrandServiceChattingFmUI appBrandServiceChattingFmUI) {
            Bitmap a;
            AppMethodBeat.m2504i(30367);
            C8910b c8910b = new C8910b();
            c8910b.title = appBrandServiceChattingFmUI.hIn;
            c8910b.type = 33;
            c8910b.fiP = appBrandServiceChattingFmUI.iIa.username;
            c8910b.fiO = C5046bo.isNullOrNil(appBrandServiceChattingFmUI.hIo) ? appBrandServiceChattingFmUI.iIa.pageId : appBrandServiceChattingFmUI.hIo;
            c8910b.fiQ = appBrandServiceChattingFmUI.iIa.appId;
            c8910b.fiZ = appBrandServiceChattingFmUI.iIa.gVt;
            c8910b.fja = appBrandServiceChattingFmUI.iIa.gVu;
            c8910b.fiS = appBrandServiceChattingFmUI.iIa.hiv;
            c8910b.fiR = 2;
            c8910b.url = appBrandServiceChattingFmUI.iIa.hiw;
            c8910b.fjb = appBrandServiceChattingFmUI.iIa.iconUrl;
            c8910b.cMm = "wxapp_" + appBrandServiceChattingFmUI.iIa.appId + appBrandServiceChattingFmUI.iIa.pageId;
            c8910b.cMg = appBrandServiceChattingFmUI.iIa.username;
            c8910b.cMh = appBrandServiceChattingFmUI.iIa.nickname;
            byte[] bArr = new byte[0];
            if (C5046bo.isNullOrNil(appBrandServiceChattingFmUI.hIr)) {
                a = C37926b.abR().mo60681a(appBrandServiceChattingFmUI.hIp, null);
            } else {
                a = C37926b.abR().mo60681a("file://" + appBrandServiceChattingFmUI.hIr, null);
                if (a == null || a.isRecycled()) {
                    a = C5056d.aml(appBrandServiceChattingFmUI.hIp);
                    if (appBrandServiceChattingFmUI.hIs) {
                        boolean deleteFile = C5730e.deleteFile(appBrandServiceChattingFmUI.hIr);
                        C4990ab.m7419v("MicroMsg.AppBrandServiceChattingUI", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", appBrandServiceChattingFmUI.hIp, Boolean.valueOf(deleteFile));
                    }
                }
            }
            if (a == null || a.isRecycled()) {
                C4990ab.m7412e("MicroMsg.AppBrandServiceChattingUI", "thumb image is null");
            } else {
                C4990ab.m7416i("MicroMsg.AppBrandServiceChattingUI", "thumb image is not null ");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                a.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
            }
            C4733l.m7087a(c8910b, appBrandServiceChattingFmUI.getAppId(), appBrandServiceChattingFmUI.hIn, appBrandServiceChattingFmUI.cgL.getTalkerUserName(), null, bArr);
            AppMethodBeat.m2505o(30367);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(30368);
        overridePendingTransition(0, 0);
        super.onCreate(null);
        AppMethodBeat.m2505o(30368);
    }

    /* Access modifiers changed, original: protected|final */
    public final ChattingUIFragment dBp() {
        AppMethodBeat.m2504i(30369);
        AppBrandServiceChattingFmUI appBrandServiceChattingFmUI = new AppBrandServiceChattingFmUI((byte) 0);
        AppMethodBeat.m2505o(30369);
        return appBrandServiceChattingFmUI;
    }
}
