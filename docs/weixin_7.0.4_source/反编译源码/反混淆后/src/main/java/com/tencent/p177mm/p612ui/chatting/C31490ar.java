package com.tencent.p177mm.p612ui.chatting;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37907bv;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.channel.MMessageActV2;
import com.tencent.p177mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI;
import com.tencent.p177mm.opensdk.modelmsg.GetMessageFromWX.Req;
import com.tencent.p177mm.opensdk.modelmsg.GetMessageFromWX.Resp;
import com.tencent.p177mm.opensdk.modelmsg.WXImageObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p612ui.C5536q;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35844g;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4934l;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.ui.chatting.ar */
public final class C31490ar implements C30457ab {
    private static C4934l<C30457ab, Bundle> yMP = new C155831();
    private C46650a cgL;
    private MMFragment yMN;
    private final Set<String> yMO = new HashSet();

    /* renamed from: com.tencent.mm.ui.chatting.ar$1 */
    static class C155831 extends C4934l<C30457ab, Bundle> {
        C155831() {
        }

        /* renamed from: w */
        public final /* synthetic */ void mo10134w(Object obj, Object obj2) {
            AppMethodBeat.m2504i(31074);
            ((C30457ab) obj).mo27754ay((Bundle) obj2);
            AppMethodBeat.m2505o(31074);
        }
    }

    static {
        AppMethodBeat.m2504i(31085);
        AppMethodBeat.m2505o(31085);
    }

    public C31490ar(C46650a c46650a) {
        AppMethodBeat.m2504i(31076);
        this.yMN = c46650a.yTx;
        AppMethodBeat.m2505o(31076);
    }

    /* renamed from: az */
    public static void m50970az(Bundle bundle) {
        AppMethodBeat.m2504i(31077);
        yMP.mo10126cF(bundle);
        yMP.doNotify();
        AppMethodBeat.m2505o(31077);
    }

    /* renamed from: ay */
    public final void mo27754ay(Bundle bundle) {
        int i = 1;
        int i2 = false;
        AppMethodBeat.m2504i(31078);
        if (this.cgL.caA) {
            String string;
            int type;
            String queryParameter = Uri.parse(bundle.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid");
            Resp resp = new Resp(bundle);
            WXMediaMessage wXMediaMessage = resp.message;
            if (this.yMO.size() == 0) {
                Activity context = this.yMN.getContext();
                HashSet hashSet = new HashSet();
                string = context.getSharedPreferences(C4996ah.doD(), 0).getString("transactions_array_key", null);
                if (string != null && string.length() > 0) {
                    for (Object add : string.split(";")) {
                        hashSet.add(add);
                    }
                }
                this.yMO.addAll(hashSet);
            }
            if (this.yMO.contains(resp.transaction)) {
                this.yMO.remove(resp.transaction);
                C31490ar.m50971b(this.yMN.getContext(), this.yMO);
                C40439f c40439f = new C40439f();
                c40439f.field_appId = queryParameter;
                C4990ab.m7410d("MicroMsg.WXAppMessageReceiver", "handleResp, appId = ".concat(String.valueOf(queryParameter)));
                if (C14877am.bYJ().mo10102b((C4925c) c40439f, new String[0])) {
                    type = wXMediaMessage.getType();
                    C5536q controller;
                    C5653c b;
                    byte[] bArr;
                    String str;
                    switch (type) {
                        case 1:
                            controller = this.yMN.getController();
                            queryParameter = wXMediaMessage.description;
                            m50975p(c40439f);
                            if (C35844g.m58770a(controller, queryParameter, false, m50968a(wXMediaMessage, c40439f)) != null) {
                                type = 1;
                            } else {
                                boolean z = false;
                            }
                            i = type;
                            break;
                        case 2:
                            if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                                WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                                C5536q controller2;
                                if (wXImageObject.imageData == null || wXImageObject.imageData.length <= 0) {
                                    controller2 = this.yMN.getController();
                                    string = wXImageObject.imagePath;
                                    m50975p(c40439f);
                                    b = C35844g.m58788b(controller2, string, false, m50968a(wXMediaMessage, c40439f));
                                } else {
                                    controller2 = this.yMN.getController();
                                    byte[] bArr2 = wXImageObject.imageData;
                                    m50975p(c40439f);
                                    b = C35844g.m58772a(controller2, bArr2, false, m50968a(wXMediaMessage, c40439f));
                                }
                            } else {
                                controller = this.yMN.getController();
                                bArr = wXMediaMessage.thumbData;
                                m50975p(c40439f);
                                b = C35844g.m58772a(controller, bArr, false, m50968a(wXMediaMessage, c40439f));
                            }
                            if (b == null) {
                                C4990ab.m7412e("MicroMsg.WXAppMessageReceiver", "showDialogItem3 fail, invalid argument");
                            } else {
                                i2 = 1;
                            }
                            i = i2;
                            break;
                        case 3:
                            if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                                controller = this.yMN.getController();
                                str = wXMediaMessage.title;
                                m50975p(c40439f);
                                b = C35844g.m58759a(controller, (int) C1318a.app_attach_file_icon_music, str, false, m50968a(wXMediaMessage, c40439f));
                            } else {
                                controller = this.yMN.getController();
                                queryParameter = wXMediaMessage.title;
                                m50975p(c40439f);
                                b = C35844g.m58768a(controller, queryParameter, false, 2, m50968a(wXMediaMessage, c40439f));
                            }
                            if (b == null) {
                                i = 0;
                                break;
                            }
                            break;
                        case 4:
                            if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                                controller = this.yMN.getController();
                                str = wXMediaMessage.title;
                                m50975p(c40439f);
                                b = C35844g.m58759a(controller, (int) C1318a.app_attach_file_icon_video, str, false, m50968a(wXMediaMessage, c40439f));
                            } else {
                                controller = this.yMN.getController();
                                queryParameter = wXMediaMessage.title;
                                m50975p(c40439f);
                                b = C35844g.m58768a(controller, queryParameter, false, 1, m50968a(wXMediaMessage, c40439f));
                            }
                            if (b == null) {
                                i = 0;
                                break;
                            }
                            break;
                        case 5:
                            controller = this.yMN.getController();
                            queryParameter = wXMediaMessage.title;
                            str = wXMediaMessage.description;
                            m50975p(c40439f);
                            if (C35844g.m58764a(controller, queryParameter, str, m50968a(wXMediaMessage, c40439f)) == null) {
                                i = 0;
                                break;
                            }
                            break;
                        case 7:
                            if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                                controller = this.yMN.getController();
                                queryParameter = wXMediaMessage.title;
                                m50975p(c40439f);
                                b = C35844g.m58759a(controller, (int) C1318a.app_attach_file_icon_webpage, queryParameter, false, m50968a(wXMediaMessage, c40439f));
                            } else {
                                controller = this.yMN.getController();
                                queryParameter = wXMediaMessage.title;
                                m50975p(c40439f);
                                b = C35844g.m58768a(controller, queryParameter, false, 0, m50968a(wXMediaMessage, c40439f));
                            }
                            if (b == null) {
                                i = 0;
                                break;
                            }
                            break;
                        case 8:
                            if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                                controller = this.yMN.getController();
                                queryParameter = wXMediaMessage.title;
                                m50975p(c40439f);
                                b = C35844g.m58759a(controller, (int) C1318a.app_attach_file_icon_webpage, queryParameter, false, m50968a(wXMediaMessage, c40439f));
                            } else {
                                controller = this.yMN.getController();
                                bArr = wXMediaMessage.thumbData;
                                m50975p(c40439f);
                                b = C35844g.m58772a(controller, bArr, false, m50968a(wXMediaMessage, c40439f));
                            }
                            if (b == null) {
                                i = 0;
                                break;
                            }
                            break;
                        default:
                            C4990ab.m7412e("MicroMsg.WXAppMessageReceiver", "unknown type = ".concat(String.valueOf(type)));
                            i = 0;
                            break;
                    }
                    if (i == 0) {
                        C4990ab.m7412e("MicroMsg.WXAppMessageReceiver", "deal fail, result is false");
                    }
                    AppMethodBeat.m2505o(31078);
                    return;
                }
                C4990ab.m7412e("MicroMsg.WXAppMessageReceiver", "unregistered app, ignore request, appId = ".concat(String.valueOf(queryParameter)));
                AppMethodBeat.m2505o(31078);
                return;
            }
            C4990ab.m7412e("MicroMsg.WXAppMessageReceiver", "invalid resp, check transaction failed, transaction=" + resp.transaction);
            AppMethodBeat.m2505o(31078);
            return;
        }
        C4990ab.m7418v("MicroMsg.WXAppMessageReceiver", "handleResp Chatting is a fragment but not foregound");
        AppMethodBeat.m2505o(31078);
    }

    /* renamed from: im */
    public final boolean mo51422im(String str, String str2) {
        AppMethodBeat.m2504i(31079);
        C4990ab.m7410d("MicroMsg.WXAppMessageReceiver", "request, pkg = " + str + ", openId = " + str2);
        Req req = new Req();
        req.username = this.cgL.getTalkerUserName();
        req.transaction = C1178g.m2591x((C42252ah.anU()).getBytes());
        req.openId = str2;
        SharedPreferences sharedPreferences = this.yMN.getSharedPreferences(C4996ah.doA(), 0);
        this.yMN.getContext();
        req.lang = C4988aa.m7402g(sharedPreferences);
        C9638aw.m17190ZK();
        req.country = (String) C18628c.m29072Ry().get(274436, null);
        Bundle bundle = new Bundle();
        req.toBundle(bundle);
        C35799p.m58687at(bundle);
        C35799p.m58688au(bundle);
        Args args = new Args();
        args.targetPkgName = str;
        args.bundle = bundle;
        boolean send = MMessageActV2.send(this.yMN.getContext(), args);
        this.yMO.add(req.transaction);
        C31490ar.m50971b(this.yMN.getContext(), this.yMO);
        AppMethodBeat.m2505o(31079);
        return send;
    }

    /* renamed from: a */
    public static void m50969a(C31490ar c31490ar) {
        AppMethodBeat.m2504i(31080);
        yMP.mo10125a(c31490ar, null);
        AppMethodBeat.m2505o(31080);
    }

    /* renamed from: b */
    public static void m50972b(C31490ar c31490ar) {
        AppMethodBeat.m2504i(31081);
        yMP.remove(c31490ar);
        c31490ar.yMO.clear();
        C31490ar.m50971b(c31490ar.yMN.getContext(), null);
        AppMethodBeat.m2505o(31081);
    }

    /* renamed from: p */
    private String m50975p(C40439f c40439f) {
        AppMethodBeat.m2504i(31082);
        String string = this.yMN.getString(C25738R.string.atg, C46494g.m87733b(this.yMN.getContext(), c40439f, null));
        AppMethodBeat.m2505o(31082);
        return string;
    }

    /* renamed from: a */
    private C30111a m50968a(final WXMediaMessage wXMediaMessage, final C40439f c40439f) {
        AppMethodBeat.m2504i(31083);
        C314912 c314912 = new C30111a() {
            /* renamed from: a */
            public final void mo6399a(boolean z, String str, int i) {
                AppMethodBeat.m2504i(31075);
                if (z) {
                    String str2 = null;
                    if (wXMediaMessage.getType() == 8) {
                        if (wXMediaMessage.thumbData == null) {
                            C4990ab.m7412e("MicroMsg.WXAppMessageReceiver", "code should not reach here due to WXMediaMessage::checkArgs, sendEmoji Fail cause thumbData is null");
                            AppMethodBeat.m2505o(31075);
                            return;
                        }
                        str2 = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35616a(C31490ar.this.yMN.getContext(), wXMediaMessage, c40439f.field_appId);
                        if (str2 == null) {
                            C4990ab.m7418v("MicroMsg.WXAppMessageReceiver", "sendEmoji Fail cause emojiconmd5 is null");
                            AppMethodBeat.m2505o(31075);
                            return;
                        }
                    }
                    C37907bv.aaq().mo60662c(27, Integer.valueOf(1));
                    C4990ab.m7419v("MicroMsg.WXAppMessageReceiver", "onDialogClick, messageAction = %s, messageExt = %s", wXMediaMessage.messageAction, wXMediaMessage.messageExt);
                    C4733l.m7090a(wXMediaMessage, c40439f.field_appId, c40439f.field_appName, C31490ar.this.cgL.getTalkerUserName(), 1, str2);
                }
                AppMethodBeat.m2505o(31075);
            }
        };
        AppMethodBeat.m2505o(31083);
        return c314912;
    }

    @TargetApi(9)
    /* renamed from: b */
    private static void m50971b(Context context, Set<String> set) {
        AppMethodBeat.m2504i(31084);
        String str = null;
        if (set != null && set.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String str2 : set) {
                stringBuilder.append(str2);
                stringBuilder.append(";");
            }
            str2 = stringBuilder.toString();
        }
        Editor edit = context.getSharedPreferences(C4996ah.doD(), 0).edit();
        edit.putString("transactions_array_key", str2);
        if (VERSION.SDK_INT > 8) {
            edit.apply();
            AppMethodBeat.m2505o(31084);
            return;
        }
        edit.commit();
        AppMethodBeat.m2505o(31084);
    }
}
