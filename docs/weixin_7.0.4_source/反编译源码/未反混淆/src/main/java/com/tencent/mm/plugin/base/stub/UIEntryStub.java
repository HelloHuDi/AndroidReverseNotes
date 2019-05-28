package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bk;
import com.tencent.mm.network.e;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.ar;
import com.tencent.mm.ui.chatting.as;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;
import java.util.Map;

@a(7)
public class UIEntryStub extends Activity {
    private String Iw;
    private Intent cEp;
    private int jDs;
    private boolean jDt;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(18131);
        super.onCreate(bundle);
        NotifyReceiver.Io();
        this.jDt = false;
        AppMethodBeat.o(18131);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(18132);
        super.onNewIntent(intent);
        this.cEp = intent;
        ab.i("MicroMsg.UIEntryStub", "onNewIntent mHasHandled: %b", Boolean.valueOf(this.jDt));
        this.jDt = false;
        AppMethodBeat.o(18132);
    }

    public void onResume() {
        AppMethodBeat.i(18133);
        super.onResume();
        if (this.cEp == null) {
            this.cEp = getIntent();
        }
        aw.Rg().a(new bk(new bk.a() {
            public final void a(e eVar) {
                AppMethodBeat.i(18126);
                if (eVar == null) {
                    UIEntryStub.this.finish();
                    AppMethodBeat.o(18126);
                    return;
                }
                ab.i("MicroMsg.UIEntryStub", "onResume mHasHandled: %b", Boolean.valueOf(UIEntryStub.this.jDt));
                if (!UIEntryStub.this.jDt) {
                    UIEntryStub.this.jDt = true;
                    UIEntryStub.a(UIEntryStub.this, UIEntryStub.this.cEp.getExtras());
                }
                AppMethodBeat.o(18126);
            }
        }), 0);
        AppMethodBeat.o(18133);
    }

    static /* synthetic */ void a(UIEntryStub uIEntryStub, final Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(18134);
        uIEntryStub.Iw = bundle.getString(ConstantsAPI.APP_PACKAGE);
        uIEntryStub.jDs = bundle.getInt(ConstantsAPI.SDK_VERSION);
        String queryParameter = Uri.parse(bundle.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid");
        ab.d("MicroMsg.UIEntryStub", "handleWXAppMessage, appId = ".concat(String.valueOf(queryParameter)));
        if (g.dk(queryParameter)) {
            com.tencent.mm.plugin.game.a.a bDb = com.tencent.mm.plugin.game.a.a.a.bDb();
            if (bDb != null) {
                bDb.j(uIEntryStub, queryParameter, uIEntryStub.Iw);
            }
        }
        int i = bundle.getInt("_wxapi_command_type");
        ab.i("MicroMsg.UIEntryStub", "handle wxapp message: " + uIEntryStub.Iw + ", sdkver=" + uIEntryStub.jDs + ", cmd=" + i);
        switch (i) {
            case 1:
                if (aw.RK() && !aw.QT()) {
                    c ll = com.tencent.mm.model.c.c.abi().ll("100273");
                    if (ll.isValid()) {
                        Map dru = ll.dru();
                        if (dru == null) {
                            ab.i("MicroMsg.UIEntryStub", "isSDKOauthNative args == null");
                        } else if (dru.containsKey("isUseNative") && "1".equals(dru.get("isUseNative"))) {
                            z = true;
                        } else {
                            ab.i("MicroMsg.UIEntryStub", "isSDKOauthNative not contain the isUseNative key or the value is not 1");
                        }
                    } else {
                        ab.i("MicroMsg.UIEntryStub", "isSDKOauthNative item.isValid is false");
                    }
                    if (!z) {
                        Intent putExtras = new Intent().putExtras(bundle);
                        putExtras.putExtra("mode", 1);
                        putExtras.putExtra("forceHideShare", true);
                        putExtras.putExtra("neverGetA8Key", true);
                        putExtras.putExtra("geta8key_scene", 6);
                        putExtras.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                        putExtras.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                        d.b((Context) uIEntryStub, "webview", ".ui.tools.OAuthUI", putExtras);
                        break;
                    }
                    d.b((Context) uIEntryStub, "webview", ".ui.tools.SDKOAuthUI", new Intent().putExtras(bundle));
                    break;
                }
                ab.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                break;
                break;
            case 2:
                final Req req = new Req(bundle);
                if (req.message != null && req.message.getType() == 2) {
                    WXImageObject wXImageObject = (WXImageObject) req.message.mediaObject;
                    if (!(wXImageObject == null || wXImageObject.checkArgs())) {
                        ab.e("MicroMsg.UIEntryStub", "dealSendMsgToWx fail, WXImageObject checkArgs fail, maybe use deprecated field imageUrl");
                        ReportUtil.a(uIEntryStub, ReportUtil.c(uIEntryStub.getIntent().getExtras(), -5), false);
                        uIEntryStub.finish();
                        AppMethodBeat.o(18134);
                        return;
                    }
                }
                if (req.message.getType() != 38 || req.scene == 1) {
                    if (req.scene == 1) {
                        ab.i("MicroMsg.UIEntryStub", "sendMessageToWx, req.scene = send to timeline");
                        if (req.message.getType() == 8) {
                            ab.e("MicroMsg.UIEntryStub", "sendMessageToWx fail, emoji does not support WXSceneTimeline");
                            ReportUtil.a(uIEntryStub, ReportUtil.c(uIEntryStub.getIntent().getExtras(), -5), false);
                        } else {
                            new d(uIEntryStub, queryParameter, req.openId, new d.a() {
                                public final void ft(boolean z) {
                                    AppMethodBeat.i(18128);
                                    boolean isFinishing = UIEntryStub.this.isFinishing();
                                    ab.d("MicroMsg.UIEntryStub", "onCheckEnd, isPass = " + z + ", isFinishing = " + isFinishing);
                                    if (!z || isFinishing) {
                                        ReportUtil.a(UIEntryStub.this, ReportUtil.c(UIEntryStub.this.getIntent().getExtras(), -3), false);
                                    } else {
                                        Intent intent = new Intent(UIEntryStub.this, SendAppMessageWrapperUI.class);
                                        intent.putExtras(bundle);
                                        intent.putExtra("Select_Conv_User", "weixinfile");
                                        intent.putExtra("SendAppMessageWrapper_Scene", req.scene);
                                        UIEntryStub.this.startActivity(intent);
                                    }
                                    new ak().postDelayed(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(18127);
                                            UIEntryStub.this.finish();
                                            AppMethodBeat.o(18127);
                                        }
                                    }, 1000);
                                    AppMethodBeat.o(18128);
                                }
                            }).aVi();
                            AppMethodBeat.o(18134);
                            return;
                        }
                    } else if (req.scene == 3) {
                        new d(uIEntryStub, queryParameter, req.openId, new d.a() {
                            public final void ft(boolean z) {
                                AppMethodBeat.i(18130);
                                boolean isFinishing = UIEntryStub.this.isFinishing();
                                String string = bundle.getString("SendAppMessageWrapper_UserName", "");
                                ab.i("MicroMsg.UIEntryStub", "onCheckEnd, isPass = " + z + ", isFinishing = " + isFinishing + ", username = " + string);
                                if (!z || isFinishing || bo.isNullOrNil(string)) {
                                    ReportUtil.a(UIEntryStub.this, ReportUtil.c(UIEntryStub.this.getIntent().getExtras(), -3), false);
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
                                new ak().postDelayed(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(18129);
                                        UIEntryStub.this.finish();
                                        AppMethodBeat.o(18129);
                                    }
                                }, 1000);
                                AppMethodBeat.o(18130);
                            }
                        }).aVi();
                        AppMethodBeat.o(18134);
                        return;
                    } else {
                        ReportArgs c = ReportUtil.c(bundle, -2);
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
                        if (!aw.RK() || aw.QT()) {
                            ab.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                        } else {
                            uIEntryStub.startActivity(intent);
                        }
                    }
                    uIEntryStub.finish();
                    AppMethodBeat.o(18134);
                    return;
                }
                ab.e("MicroMsg.UIEntryStub", "dealSendMsgToWx fail, video file object only supported share to timeline");
                ReportUtil.a(uIEntryStub, ReportUtil.c(uIEntryStub.getIntent().getExtras(), -5), false);
                uIEntryStub.finish();
                AppMethodBeat.o(18134);
                return;
            case 3:
                if (aw.RK() && !aw.QT()) {
                    ar.az(bundle);
                    break;
                } else {
                    ab.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                    break;
                }
            case 4:
                if (aw.RK() && !aw.QT()) {
                    as.az(bundle);
                    break;
                } else {
                    ab.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                    break;
                }
        }
        uIEntryStub.finish();
        AppMethodBeat.o(18134);
    }
}
