package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bv;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Resp;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.q;
import java.util.HashSet;
import java.util.Set;

public final class ar implements ab {
    private static l<ab, Bundle> yMP = new l<ab, Bundle>() {
        public final /* synthetic */ void w(Object obj, Object obj2) {
            AppMethodBeat.i(31074);
            ((ab) obj).ay((Bundle) obj2);
            AppMethodBeat.o(31074);
        }
    };
    private a cgL;
    private MMFragment yMN;
    private final Set<String> yMO = new HashSet();

    static {
        AppMethodBeat.i(31085);
        AppMethodBeat.o(31085);
    }

    public ar(a aVar) {
        AppMethodBeat.i(31076);
        this.yMN = aVar.yTx;
        AppMethodBeat.o(31076);
    }

    public static void az(Bundle bundle) {
        AppMethodBeat.i(31077);
        yMP.cF(bundle);
        yMP.doNotify();
        AppMethodBeat.o(31077);
    }

    public final void ay(Bundle bundle) {
        int i = 1;
        int i2 = false;
        AppMethodBeat.i(31078);
        if (this.cgL.caA) {
            String string;
            int type;
            String queryParameter = Uri.parse(bundle.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid");
            Resp resp = new Resp(bundle);
            WXMediaMessage wXMediaMessage = resp.message;
            if (this.yMO.size() == 0) {
                Activity context = this.yMN.getContext();
                HashSet hashSet = new HashSet();
                string = context.getSharedPreferences(ah.doD(), 0).getString("transactions_array_key", null);
                if (string != null && string.length() > 0) {
                    for (Object add : string.split(";")) {
                        hashSet.add(add);
                    }
                }
                this.yMO.addAll(hashSet);
            }
            if (this.yMO.contains(resp.transaction)) {
                this.yMO.remove(resp.transaction);
                b(this.yMN.getContext(), this.yMO);
                f fVar = new f();
                fVar.field_appId = queryParameter;
                ab.d("MicroMsg.WXAppMessageReceiver", "handleResp, appId = ".concat(String.valueOf(queryParameter)));
                if (am.bYJ().b((c) fVar, new String[0])) {
                    type = wXMediaMessage.getType();
                    q controller;
                    com.tencent.mm.ui.widget.a.c b;
                    byte[] bArr;
                    String str;
                    switch (type) {
                        case 1:
                            controller = this.yMN.getController();
                            queryParameter = wXMediaMessage.description;
                            p(fVar);
                            if (g.a(controller, queryParameter, false, a(wXMediaMessage, fVar)) != null) {
                                type = 1;
                            } else {
                                boolean z = false;
                            }
                            i = type;
                            break;
                        case 2:
                            if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                                WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                                q controller2;
                                if (wXImageObject.imageData == null || wXImageObject.imageData.length <= 0) {
                                    controller2 = this.yMN.getController();
                                    string = wXImageObject.imagePath;
                                    p(fVar);
                                    b = g.b(controller2, string, false, a(wXMediaMessage, fVar));
                                } else {
                                    controller2 = this.yMN.getController();
                                    byte[] bArr2 = wXImageObject.imageData;
                                    p(fVar);
                                    b = g.a(controller2, bArr2, false, a(wXMediaMessage, fVar));
                                }
                            } else {
                                controller = this.yMN.getController();
                                bArr = wXMediaMessage.thumbData;
                                p(fVar);
                                b = g.a(controller, bArr, false, a(wXMediaMessage, fVar));
                            }
                            if (b == null) {
                                ab.e("MicroMsg.WXAppMessageReceiver", "showDialogItem3 fail, invalid argument");
                            } else {
                                i2 = 1;
                            }
                            i = i2;
                            break;
                        case 3:
                            if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                                controller = this.yMN.getController();
                                str = wXMediaMessage.title;
                                p(fVar);
                                b = g.a(controller, (int) R.raw.app_attach_file_icon_music, str, false, a(wXMediaMessage, fVar));
                            } else {
                                controller = this.yMN.getController();
                                queryParameter = wXMediaMessage.title;
                                p(fVar);
                                b = g.a(controller, queryParameter, false, 2, a(wXMediaMessage, fVar));
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
                                p(fVar);
                                b = g.a(controller, (int) R.raw.app_attach_file_icon_video, str, false, a(wXMediaMessage, fVar));
                            } else {
                                controller = this.yMN.getController();
                                queryParameter = wXMediaMessage.title;
                                p(fVar);
                                b = g.a(controller, queryParameter, false, 1, a(wXMediaMessage, fVar));
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
                            p(fVar);
                            if (g.a(controller, queryParameter, str, a(wXMediaMessage, fVar)) == null) {
                                i = 0;
                                break;
                            }
                            break;
                        case 7:
                            if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                                controller = this.yMN.getController();
                                queryParameter = wXMediaMessage.title;
                                p(fVar);
                                b = g.a(controller, (int) R.raw.app_attach_file_icon_webpage, queryParameter, false, a(wXMediaMessage, fVar));
                            } else {
                                controller = this.yMN.getController();
                                queryParameter = wXMediaMessage.title;
                                p(fVar);
                                b = g.a(controller, queryParameter, false, 0, a(wXMediaMessage, fVar));
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
                                p(fVar);
                                b = g.a(controller, (int) R.raw.app_attach_file_icon_webpage, queryParameter, false, a(wXMediaMessage, fVar));
                            } else {
                                controller = this.yMN.getController();
                                bArr = wXMediaMessage.thumbData;
                                p(fVar);
                                b = g.a(controller, bArr, false, a(wXMediaMessage, fVar));
                            }
                            if (b == null) {
                                i = 0;
                                break;
                            }
                            break;
                        default:
                            ab.e("MicroMsg.WXAppMessageReceiver", "unknown type = ".concat(String.valueOf(type)));
                            i = 0;
                            break;
                    }
                    if (i == 0) {
                        ab.e("MicroMsg.WXAppMessageReceiver", "deal fail, result is false");
                    }
                    AppMethodBeat.o(31078);
                    return;
                }
                ab.e("MicroMsg.WXAppMessageReceiver", "unregistered app, ignore request, appId = ".concat(String.valueOf(queryParameter)));
                AppMethodBeat.o(31078);
                return;
            }
            ab.e("MicroMsg.WXAppMessageReceiver", "invalid resp, check transaction failed, transaction=" + resp.transaction);
            AppMethodBeat.o(31078);
            return;
        }
        ab.v("MicroMsg.WXAppMessageReceiver", "handleResp Chatting is a fragment but not foregound");
        AppMethodBeat.o(31078);
    }

    public final boolean im(String str, String str2) {
        AppMethodBeat.i(31079);
        ab.d("MicroMsg.WXAppMessageReceiver", "request, pkg = " + str + ", openId = " + str2);
        Req req = new Req();
        req.username = this.cgL.getTalkerUserName();
        req.transaction = com.tencent.mm.a.g.x((com.tencent.mm.platformtools.ah.anU()).getBytes());
        req.openId = str2;
        SharedPreferences sharedPreferences = this.yMN.getSharedPreferences(ah.doA(), 0);
        this.yMN.getContext();
        req.lang = aa.g(sharedPreferences);
        aw.ZK();
        req.country = (String) com.tencent.mm.model.c.Ry().get(274436, null);
        Bundle bundle = new Bundle();
        req.toBundle(bundle);
        p.at(bundle);
        p.au(bundle);
        Args args = new Args();
        args.targetPkgName = str;
        args.bundle = bundle;
        boolean send = MMessageActV2.send(this.yMN.getContext(), args);
        this.yMO.add(req.transaction);
        b(this.yMN.getContext(), this.yMO);
        AppMethodBeat.o(31079);
        return send;
    }

    public static void a(ar arVar) {
        AppMethodBeat.i(31080);
        yMP.a(arVar, null);
        AppMethodBeat.o(31080);
    }

    public static void b(ar arVar) {
        AppMethodBeat.i(31081);
        yMP.remove(arVar);
        arVar.yMO.clear();
        b(arVar.yMN.getContext(), null);
        AppMethodBeat.o(31081);
    }

    private String p(f fVar) {
        AppMethodBeat.i(31082);
        String string = this.yMN.getString(R.string.atg, com.tencent.mm.pluginsdk.model.app.g.b(this.yMN.getContext(), fVar, null));
        AppMethodBeat.o(31082);
        return string;
    }

    private com.tencent.mm.pluginsdk.ui.applet.q.a a(final WXMediaMessage wXMediaMessage, final f fVar) {
        AppMethodBeat.i(31083);
        AnonymousClass2 anonymousClass2 = new com.tencent.mm.pluginsdk.ui.applet.q.a() {
            public final void a(boolean z, String str, int i) {
                AppMethodBeat.i(31075);
                if (z) {
                    String str2 = null;
                    if (wXMediaMessage.getType() == 8) {
                        if (wXMediaMessage.thumbData == null) {
                            ab.e("MicroMsg.WXAppMessageReceiver", "code should not reach here due to WXMediaMessage::checkArgs, sendEmoji Fail cause thumbData is null");
                            AppMethodBeat.o(31075);
                            return;
                        }
                        str2 = ((d) com.tencent.mm.kernel.g.M(d.class)).getEmojiMgr().a(ar.this.yMN.getContext(), wXMediaMessage, fVar.field_appId);
                        if (str2 == null) {
                            ab.v("MicroMsg.WXAppMessageReceiver", "sendEmoji Fail cause emojiconmd5 is null");
                            AppMethodBeat.o(31075);
                            return;
                        }
                    }
                    bv.aaq().c(27, Integer.valueOf(1));
                    ab.v("MicroMsg.WXAppMessageReceiver", "onDialogClick, messageAction = %s, messageExt = %s", wXMediaMessage.messageAction, wXMediaMessage.messageExt);
                    com.tencent.mm.pluginsdk.model.app.l.a(wXMediaMessage, fVar.field_appId, fVar.field_appName, ar.this.cgL.getTalkerUserName(), 1, str2);
                }
                AppMethodBeat.o(31075);
            }
        };
        AppMethodBeat.o(31083);
        return anonymousClass2;
    }

    @TargetApi(9)
    private static void b(Context context, Set<String> set) {
        AppMethodBeat.i(31084);
        String str = null;
        if (set != null && set.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String str2 : set) {
                stringBuilder.append(str2);
                stringBuilder.append(";");
            }
            str2 = stringBuilder.toString();
        }
        Editor edit = context.getSharedPreferences(ah.doD(), 0).edit();
        edit.putString("transactions_array_key", str2);
        if (VERSION.SDK_INT > 8) {
            edit.apply();
            AppMethodBeat.o(31084);
            return;
        }
        edit.commit();
        AppMethodBeat.o(31084);
    }
}
