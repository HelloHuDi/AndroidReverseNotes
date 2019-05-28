package com.tencent.p177mm.plugin.base.stub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.NotifyReceiver;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI;
import com.tencent.p177mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.p177mm.opensdk.modelmsg.WXImageObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.chatting.C15584as;
import com.tencent.p177mm.p612ui.chatting.C31490ar;
import com.tencent.p177mm.p612ui.chatting.ChattingUI;
import com.tencent.p177mm.p612ui.transmit.SelectConversationUI;
import com.tencent.p177mm.p612ui.transmit.SendAppMessageWrapperUI;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.base.stub.C38669d.C27497a;
import com.tencent.p177mm.plugin.game.p1268a.C43155a;
import com.tencent.p177mm.plugin.game.p1268a.C43155a.C20928a;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.model.app.ReportUtil;
import com.tencent.p177mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5141c;
import java.util.Map;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.base.stub.UIEntryStub */
public class UIEntryStub extends Activity {
    /* renamed from: Iw */
    private String f16159Iw;
    private Intent cEp;
    private int jDs;
    private boolean jDt;

    /* renamed from: com.tencent.mm.plugin.base.stub.UIEntryStub$1 */
    class C337111 implements C1835a {
        C337111() {
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
            AppMethodBeat.m2504i(18126);
            if (c1902e == null) {
                UIEntryStub.this.finish();
                AppMethodBeat.m2505o(18126);
                return;
            }
            C4990ab.m7417i("MicroMsg.UIEntryStub", "onResume mHasHandled: %b", Boolean.valueOf(UIEntryStub.this.jDt));
            if (!UIEntryStub.this.jDt) {
                UIEntryStub.this.jDt = true;
                UIEntryStub.m65578a(UIEntryStub.this, UIEntryStub.this.cEp.getExtras());
            }
            AppMethodBeat.m2505o(18126);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(18131);
        super.onCreate(bundle);
        NotifyReceiver.m41396Io();
        this.jDt = false;
        AppMethodBeat.m2505o(18131);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(18132);
        super.onNewIntent(intent);
        this.cEp = intent;
        C4990ab.m7417i("MicroMsg.UIEntryStub", "onNewIntent mHasHandled: %b", Boolean.valueOf(this.jDt));
        this.jDt = false;
        AppMethodBeat.m2505o(18132);
    }

    public void onResume() {
        AppMethodBeat.m2504i(18133);
        super.onResume();
        if (this.cEp == null) {
            this.cEp = getIntent();
        }
        C9638aw.m17182Rg().mo14541a(new C6668bk(new C337111()), 0);
        AppMethodBeat.m2505o(18133);
    }

    /* renamed from: a */
    static /* synthetic */ void m65578a(UIEntryStub uIEntryStub, final Bundle bundle) {
        boolean z = false;
        AppMethodBeat.m2504i(18134);
        uIEntryStub.f16159Iw = bundle.getString(ConstantsAPI.APP_PACKAGE);
        uIEntryStub.jDs = bundle.getInt(ConstantsAPI.SDK_VERSION);
        String queryParameter = Uri.parse(bundle.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid");
        C4990ab.m7410d("MicroMsg.UIEntryStub", "handleWXAppMessage, appId = ".concat(String.valueOf(queryParameter)));
        if (C46494g.m87744dk(queryParameter)) {
            C43155a bDb = C20928a.bDb();
            if (bDb != null) {
                bDb.mo36281j(uIEntryStub, queryParameter, uIEntryStub.f16159Iw);
            }
        }
        int i = bundle.getInt("_wxapi_command_type");
        C4990ab.m7416i("MicroMsg.UIEntryStub", "handle wxapp message: " + uIEntryStub.f16159Iw + ", sdkver=" + uIEntryStub.jDs + ", cmd=" + i);
        switch (i) {
            case 1:
                if (C9638aw.m17179RK() && !C9638aw.m17178QT()) {
                    C5141c ll = C18624c.abi().mo17131ll("100273");
                    if (ll.isValid()) {
                        Map dru = ll.dru();
                        if (dru == null) {
                            C4990ab.m7416i("MicroMsg.UIEntryStub", "isSDKOauthNative args == null");
                        } else if (dru.containsKey("isUseNative") && "1".equals(dru.get("isUseNative"))) {
                            z = true;
                        } else {
                            C4990ab.m7416i("MicroMsg.UIEntryStub", "isSDKOauthNative not contain the isUseNative key or the value is not 1");
                        }
                    } else {
                        C4990ab.m7416i("MicroMsg.UIEntryStub", "isSDKOauthNative item.isValid is false");
                    }
                    if (!z) {
                        Intent putExtras = new Intent().putExtras(bundle);
                        putExtras.putExtra("mode", 1);
                        putExtras.putExtra("forceHideShare", true);
                        putExtras.putExtra("neverGetA8Key", true);
                        putExtras.putExtra("geta8key_scene", 6);
                        putExtras.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                        putExtras.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                        C25985d.m41467b((Context) uIEntryStub, "webview", ".ui.tools.OAuthUI", putExtras);
                        break;
                    }
                    C25985d.m41467b((Context) uIEntryStub, "webview", ".ui.tools.SDKOAuthUI", new Intent().putExtras(bundle));
                    break;
                }
                C4990ab.m7412e("MicroMsg.UIEntryStub", "not logged in, ignore");
                break;
                break;
            case 2:
                final Req req = new Req(bundle);
                if (req.message != null && req.message.getType() == 2) {
                    WXImageObject wXImageObject = (WXImageObject) req.message.mediaObject;
                    if (!(wXImageObject == null || wXImageObject.checkArgs())) {
                        C4990ab.m7412e("MicroMsg.UIEntryStub", "dealSendMsgToWx fail, WXImageObject checkArgs fail, maybe use deprecated field imageUrl");
                        ReportUtil.m79192a(uIEntryStub, ReportUtil.m79195c(uIEntryStub.getIntent().getExtras(), -5), false);
                        uIEntryStub.finish();
                        AppMethodBeat.m2505o(18134);
                        return;
                    }
                }
                if (req.message.getType() != 38 || req.scene == 1) {
                    if (req.scene == 1) {
                        C4990ab.m7416i("MicroMsg.UIEntryStub", "sendMessageToWx, req.scene = send to timeline");
                        if (req.message.getType() == 8) {
                            C4990ab.m7412e("MicroMsg.UIEntryStub", "sendMessageToWx fail, emoji does not support WXSceneTimeline");
                            ReportUtil.m79192a(uIEntryStub, ReportUtil.m79195c(uIEntryStub.getIntent().getExtras(), -5), false);
                        } else {
                            new C38669d(uIEntryStub, queryParameter, req.openId, new C27497a() {

                                /* renamed from: com.tencent.mm.plugin.base.stub.UIEntryStub$2$1 */
                                class C386671 implements Runnable {
                                    C386671() {
                                    }

                                    public final void run() {
                                        AppMethodBeat.m2504i(18127);
                                        UIEntryStub.this.finish();
                                        AppMethodBeat.m2505o(18127);
                                    }
                                }

                                /* renamed from: ft */
                                public final void mo11382ft(boolean z) {
                                    AppMethodBeat.m2504i(18128);
                                    boolean isFinishing = UIEntryStub.this.isFinishing();
                                    C4990ab.m7410d("MicroMsg.UIEntryStub", "onCheckEnd, isPass = " + z + ", isFinishing = " + isFinishing);
                                    if (!z || isFinishing) {
                                        ReportUtil.m79192a(UIEntryStub.this, ReportUtil.m79195c(UIEntryStub.this.getIntent().getExtras(), -3), false);
                                    } else {
                                        Intent intent = new Intent(UIEntryStub.this, SendAppMessageWrapperUI.class);
                                        intent.putExtras(bundle);
                                        intent.putExtra("Select_Conv_User", "weixinfile");
                                        intent.putExtra("SendAppMessageWrapper_Scene", req.scene);
                                        UIEntryStub.this.startActivity(intent);
                                    }
                                    new C7306ak().postDelayed(new C386671(), 1000);
                                    AppMethodBeat.m2505o(18128);
                                }
                            }).aVi();
                            AppMethodBeat.m2505o(18134);
                            return;
                        }
                    } else if (req.scene == 3) {
                        new C38669d(uIEntryStub, queryParameter, req.openId, new C27497a() {

                            /* renamed from: com.tencent.mm.plugin.base.stub.UIEntryStub$3$1 */
                            class C337121 implements Runnable {
                                C337121() {
                                }

                                public final void run() {
                                    AppMethodBeat.m2504i(18129);
                                    UIEntryStub.this.finish();
                                    AppMethodBeat.m2505o(18129);
                                }
                            }

                            /* renamed from: ft */
                            public final void mo11382ft(boolean z) {
                                AppMethodBeat.m2504i(18130);
                                boolean isFinishing = UIEntryStub.this.isFinishing();
                                String string = bundle.getString("SendAppMessageWrapper_UserName", "");
                                C4990ab.m7416i("MicroMsg.UIEntryStub", "onCheckEnd, isPass = " + z + ", isFinishing = " + isFinishing + ", username = " + string);
                                if (!z || isFinishing || C5046bo.isNullOrNil(string)) {
                                    ReportUtil.m79192a(UIEntryStub.this, ReportUtil.m79195c(UIEntryStub.this.getIntent().getExtras(), -3), false);
                                } else {
                                    Intent intent = new Intent(UIEntryStub.this, ChattingUI.class);
                                    intent.putExtras(bundle);
                                    intent.putExtra("finish_direct", false);
                                    intent.putExtra("Chat_User", string);
                                    intent.putExtra("SendAppMessageWrapper_Scene", req.scene);
                                    if (req.message.getType() == 45) {
                                        intent.putExtra("Select_Send_Card", true);
                                    }
                                    UIEntryStub.this.startActivity(intent);
                                }
                                new C7306ak().postDelayed(new C337121(), 1000);
                                AppMethodBeat.m2505o(18130);
                            }
                        }).aVi();
                        AppMethodBeat.m2505o(18134);
                        return;
                    } else {
                        ReportArgs c = ReportUtil.m79195c(bundle, -2);
                        Intent intent = new Intent(uIEntryStub, SelectConversationUI.class);
                        intent.putExtra("Select_Report_Args", c);
                        intent.putExtra("Select_Conv_NextStep", new Intent(uIEntryStub, SendAppMessageWrapperUI.class).putExtras(bundle).putExtra("SendAppMessageWrapper_Scene", req.scene).putExtra("animation_pop_in", true));
                        intent.putExtra("Select_App_Id", queryParameter);
                        intent.putExtra("Select_Open_Id", req.openId);
                        intent.putExtra("Select_Conv_Type", 3);
                        if (req.message.getType() == 36 || req.message.getType() == 46) {
                            intent.putExtra("mutil_select_is_ret", !((WXMiniProgramObject) req.message.mediaObject).withShareTicket);
                        } else {
                            intent.putExtra("mutil_select_is_ret", true);
                        }
                        if (req.message.getType() == 45) {
                            intent.putExtra("Select_Send_Card", true);
                        }
                        if (!C9638aw.m17179RK() || C9638aw.m17178QT()) {
                            C4990ab.m7412e("MicroMsg.UIEntryStub", "not logged in, ignore");
                        } else {
                            uIEntryStub.startActivity(intent);
                        }
                    }
                    uIEntryStub.finish();
                    AppMethodBeat.m2505o(18134);
                    return;
                }
                C4990ab.m7412e("MicroMsg.UIEntryStub", "dealSendMsgToWx fail, video file object only supported share to timeline");
                ReportUtil.m79192a(uIEntryStub, ReportUtil.m79195c(uIEntryStub.getIntent().getExtras(), -5), false);
                uIEntryStub.finish();
                AppMethodBeat.m2505o(18134);
                return;
            case 3:
                if (C9638aw.m17179RK() && !C9638aw.m17178QT()) {
                    C31490ar.m50970az(bundle);
                    break;
                } else {
                    C4990ab.m7412e("MicroMsg.UIEntryStub", "not logged in, ignore");
                    break;
                }
            case 4:
                if (C9638aw.m17179RK() && !C9638aw.m17178QT()) {
                    C15584as.m23881az(bundle);
                    break;
                } else {
                    C4990ab.m7412e("MicroMsg.UIEntryStub", "not logged in, ignore");
                    break;
                }
        }
        uIEntryStub.finish();
        AppMethodBeat.m2505o(18134);
    }
}
