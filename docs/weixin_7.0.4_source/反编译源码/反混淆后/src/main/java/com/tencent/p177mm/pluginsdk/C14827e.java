package com.tencent.p177mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18643z;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.modelsimple.C26475z;
import com.tencent.p177mm.modelsimple.C6681h;
import com.tencent.p177mm.p1174aa.C41724g;
import com.tencent.p177mm.p1174aa.C41726i;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18296ik;
import com.tencent.p177mm.p230g.p231a.C45313by;
import com.tencent.p177mm.p230g.p231a.C6489hv;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.topstory.p541ui.C4210c;
import com.tencent.p177mm.pluginsdk.C40416b.C40417a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C35892i;
import com.tencent.p177mm.pluginsdk.wallet.C14991i;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.protocal.protobuf.C35913df;
import com.tencent.p177mm.protocal.protobuf.ciq;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.view.C31128d;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import p000a.p005f.p007b.C25052j;

/* renamed from: com.tencent.mm.pluginsdk.e */
public final class C14827e {
    private static boolean van = false;
    public static String vao = "";
    private static final Map<String, Long> vap;

    /* renamed from: com.tencent.mm.pluginsdk.e$a */
    public interface C14831a {
        /* renamed from: a */
        void mo6738a(int i, int i2, String str, C1207m c1207m, boolean z);
    }

    static {
        AppMethodBeat.m2504i(11681);
        HashMap hashMap = new HashMap();
        vap = hashMap;
        hashMap.put("weixin://", Long.valueOf(0));
        vap.put("weixin://dl/stickers", Long.valueOf(1));
        vap.put("weixin://dl/games", Long.valueOf(2));
        vap.put("weixin://dl/moments", Long.valueOf(4));
        vap.put("weixin://dl/add", Long.valueOf(8));
        vap.put("weixin://dl/shopping", Long.valueOf(16));
        vap.put("weixin://dl/groupchat", Long.valueOf(32));
        vap.put("weixin://dl/scan", Long.valueOf(64));
        vap.put("weixin://dl/profile", Long.valueOf(128));
        vap.put("weixin://dl/settings", Long.valueOf(256));
        vap.put("weixin://dl/general", Long.valueOf(512));
        vap.put("weixin://dl/help", Long.valueOf(1024));
        vap.put("weixin://dl/notifications", Long.valueOf(2048));
        vap.put("weixin://dl/terms", Long.valueOf(4096));
        vap.put("weixin://dl/chat", Long.valueOf(8192));
        vap.put("weixin://dl/features", Long.valueOf(16384));
        vap.put("weixin://dl/clear", Long.valueOf(32768));
        vap.put("weixin://dl/feedback", Long.valueOf(65536));
        vap.put("weixin://dl/faq", Long.valueOf(131072));
        vap.put("weixin://dl/recommendation", Long.valueOf(262144));
        vap.put("weixin://dl/groups", Long.valueOf(C1625i.ACTION_MINI_PROGRAM_LAUNCH));
        vap.put("weixin://dl/tags", Long.valueOf(1048576));
        vap.put("weixin://dl/officialaccounts", Long.valueOf(2097152));
        vap.put("weixin://dl/posts", Long.valueOf(4194304));
        vap.put("weixin://dl/favorites", Long.valueOf(8388608));
        vap.put("weixin://dl/privacy", Long.valueOf(16777216));
        vap.put("weixin://dl/security", Long.valueOf(33554432));
        vap.put("weixin://dl/wallet", Long.valueOf(67108864));
        vap.put("weixin://dl/businessPay", Long.valueOf(134217728));
        vap.put("weixin://dl/businessPay/", Long.valueOf(134217728));
        vap.put("weixin://dl/wechatout", Long.valueOf(268435456));
        vap.put("weixin://dl/protection", Long.valueOf(1073741824));
        vap.put("weixin://dl/card", Long.valueOf(2147483648L));
        vap.put("weixin://dl/about", Long.valueOf(1125899906842624L));
        vap.put("weixin://dl/blacklist", Long.valueOf(4294967296L));
        vap.put("weixin://dl/textsize", Long.valueOf(8589934592L));
        vap.put("weixin://dl/sight", Long.valueOf(17179869184L));
        vap.put("weixin://dl/languages", Long.valueOf(34359738368L));
        vap.put("weixin://dl/chathistory", Long.valueOf(68719476736L));
        vap.put("weixin://dl/bindqq", Long.valueOf(137438953472L));
        vap.put("weixin://dl/bindmobile", Long.valueOf(274877906944L));
        vap.put("weixin://dl/bindemail", Long.valueOf(549755813888L));
        vap.put("weixin://dl/securityassistant", Long.valueOf(1099511627776L));
        vap.put("weixin://dl/broadcastmessage", Long.valueOf(2199023255552L));
        vap.put("weixin://dl/setname", Long.valueOf(4398046511104L));
        vap.put("weixin://dl/myQRcode", Long.valueOf(8796093022208L));
        vap.put("weixin://dl/myaddress", Long.valueOf(17592186044416L));
        vap.put("weixin://dl/hidemoments", Long.valueOf(35184372088832L));
        vap.put("weixin://dl/blockmoments", Long.valueOf(70368744177664L));
        vap.put("weixin://dl/stickersetting", Long.valueOf(140737488355328L));
        vap.put("weixin://dl/log", Long.valueOf(281474976710656L));
        vap.put("weixin://dl/wechatoutcoupon", Long.valueOf(562949953421312L));
        vap.put("weixin://dl/wechatoutshare", Long.valueOf(18014398509481984L));
        vap.put("weixin://dl/personalemoticon", Long.valueOf(4503599627370496L));
        vap.put("weixin://dl/designeremoji", Long.valueOf(9007199254740992L));
        vap.put("weixin://dl/sightdraft", Long.valueOf(576460752303423488L));
        vap.put("weixin://dl/jumpWxa/", Long.valueOf(576460752303423489L));
        vap.put("weixin://dl/offlinepay/", Long.valueOf(576460752303423490L));
        AppMethodBeat.m2505o(11681);
    }

    /* renamed from: aH */
    public static boolean m23075aH(String str, long j) {
        boolean z;
        AppMethodBeat.m2504i(11659);
        if (!C5046bo.isNullOrNil(str)) {
            long longValue;
            String air = C14827e.air(str);
            if (vap.containsKey(air)) {
                longValue = ((Long) vap.get(air)).longValue();
            } else {
                longValue = -1;
            }
            if (longValue != -1 && (longValue == 0 || (longValue & j) == longValue)) {
                z = true;
                AppMethodBeat.m2505o(11659);
                return z;
            }
        }
        z = false;
        AppMethodBeat.m2505o(11659);
        return z;
    }

    public static boolean aim(String str) {
        AppMethodBeat.m2504i(11660);
        String air = C14827e.air(str);
        if (!(vap.containsKey(air) || C14827e.ain(air) || C14827e.aio(air))) {
            boolean z;
            if (C5046bo.isNullOrNil(air) || !(air.startsWith("weixin://dl/jumpFakeWxa/") || air.startsWith("weixin://dl/openNativeView/"))) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                AppMethodBeat.m2505o(11660);
                return false;
            }
        }
        AppMethodBeat.m2505o(11660);
        return true;
    }

    public static boolean ain(String str) {
        AppMethodBeat.m2504i(11661);
        if (C5046bo.isNullOrNil(str) || !str.startsWith("weixin://dl/business")) {
            AppMethodBeat.m2505o(11661);
            return false;
        }
        AppMethodBeat.m2505o(11661);
        return true;
    }

    public static boolean aio(String str) {
        AppMethodBeat.m2504i(11662);
        if (C5046bo.isNullOrNil(str) || !str.startsWith("weixin://dl/openbusinesswebview")) {
            AppMethodBeat.m2505o(11662);
            return false;
        }
        AppMethodBeat.m2505o(11662);
        return true;
    }

    /* renamed from: s */
    public static boolean m23079s(Uri uri) {
        AppMethodBeat.m2504i(11663);
        if (uri == null) {
            AppMethodBeat.m2505o(11663);
            return false;
        } else if (C5046bo.isNullOrNil(uri.getQueryParameter("ticket"))) {
            boolean t = C14827e.m23080t(uri);
            AppMethodBeat.m2505o(11663);
            return t;
        } else {
            AppMethodBeat.m2505o(11663);
            return true;
        }
    }

    /* renamed from: t */
    public static boolean m23080t(Uri uri) {
        AppMethodBeat.m2504i(11664);
        if (uri == null) {
            AppMethodBeat.m2505o(11664);
            return false;
        } else if (uri.toString().startsWith("weixin://dl/business/tempsession/") || uri.toString().startsWith("weixin://dl/businessTempSession/")) {
            AppMethodBeat.m2505o(11664);
            return true;
        } else {
            AppMethodBeat.m2505o(11664);
            return false;
        }
    }

    private static boolean dgP() {
        AppMethodBeat.m2504i(11665);
        if (!C1720g.m3531RK()) {
            AppMethodBeat.m2505o(11665);
            return false;
        } else if (C26373g.m41964Nu().getInt("WCOEntranceSwitch", 0) > 0) {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.TRUE);
            AppMethodBeat.m2505o(11665);
            return true;
        } else {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.FALSE);
            AppMethodBeat.m2505o(11665);
            return false;
        }
    }

    private static boolean aip(String str) {
        AppMethodBeat.m2504i(11666);
        if ((str.equals("weixin://dl/wechatout") || str.equals("weixin://dl/wechatoutcoupon") || str.equals("weixin://dl/wechatoutshare")) && !C14827e.dgP()) {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setClassName(C4996ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
            intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
            C4996ah.getContext().startActivity(intent);
            AppMethodBeat.m2505o(11666);
            return true;
        }
        AppMethodBeat.m2505o(11666);
        return false;
    }

    /* renamed from: a */
    public static void m23071a(Context context, String str, String str2, int i, String str3, C14831a c14831a) {
        AppMethodBeat.m2504i(11667);
        String str4 = C5046bo.isNullOrNil(str) ? str3 : str;
        if (C14827e.aip(str4)) {
            AppMethodBeat.m2505o(11667);
            return;
        }
        C1207m c6681h = new C6681h(str4, str2, i, 0, (int) System.currentTimeMillis(), new byte[0]);
        final Context context2 = context;
        final int i2 = i;
        final String str5 = str2;
        final String str6 = str4;
        final C14831a c14831a2 = c14831a;
        C1720g.m3540Rg().mo14539a((int) C31128d.MIC_PTU_MEISHI, new C1202f() {
            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                AppMethodBeat.m2504i(11655);
                C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_MEISHI, (C1202f) this);
                C4990ab.m7417i("MicroMsg.DeepLinkHelper", "[oneliang][doDeepLink][onSceneEnd]:errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                boolean z = false;
                if (c1207m != null && (c1207m instanceof C6681h)) {
                    C6681h c6681h = (C6681h) c1207m;
                    C4990ab.m7410d("MicroMsg.DeepLinkHelper", "bitset:" + c6681h.aiZ());
                    long aiZ = c6681h.aiZ();
                    String aiT = c6681h.aiT();
                    if (C14827e.m23075aH(aiT, aiZ)) {
                        try {
                            C4990ab.m7417i("MicroMsg.DeepLinkHelper", "[oneliang] uri: %s", aiT);
                            z = C14827e.m23072a(context2, c6681h.ajb(), c6681h.ajc(), aiT);
                            C7060h.pYm.mo8381e(11405, aiT, Integer.valueOf(1), Integer.valueOf(i2), str5, C5046bo.nullAsNil(str6));
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.DeepLinkHelper", e, "", "");
                            C7060h.pYm.mo8381e(11405, aiT, Integer.valueOf(0), Integer.valueOf(i2), str5, C5046bo.nullAsNil(str6));
                        }
                    } else {
                        C4990ab.m7416i("MicroMsg.DeepLinkHelper", "[oneliang] no permission");
                        Intent intent = new Intent();
                        intent.setFlags(268435456);
                        intent.setClassName(C4996ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                        intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
                        intent.putExtra("geta8key_session_id", c6681h.ajb());
                        intent.putExtra("geta8key_cookie", c6681h.ajc());
                        C4996ah.getContext().startActivity(intent);
                        C7060h.pYm.mo8381e(11405, aiT, Integer.valueOf(0), Integer.valueOf(i2), str5, C5046bo.nullAsNil(str6));
                        z = true;
                    }
                }
                if (c14831a2 != null) {
                    c14831a2.mo6738a(i, i2, str, c1207m, z);
                }
                AppMethodBeat.m2505o(11655);
            }
        });
        C1720g.m3540Rg().mo14541a(c6681h, 0);
        AppMethodBeat.m2505o(11667);
    }

    /* renamed from: a */
    public static void m23070a(Context context, String str, int i, C14831a c14831a, String str2, String str3) {
        AppMethodBeat.m2504i(11668);
        C14827e.m23068a(context, str, i, null, c14831a, str2, str3);
        AppMethodBeat.m2505o(11668);
    }

    /* renamed from: a */
    public static void m23068a(Context context, String str, int i, Bundle bundle, C14831a c14831a, String str2, String str3) {
        AppMethodBeat.m2504i(11669);
        LinkedList linkedList = new LinkedList();
        C35913df c35913df = new C35913df();
        if (!(C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3))) {
            C4990ab.m7417i("MicroMsg.DeepLinkHelper", "package name = %s, package signature = %s", str2, str3);
            c35913df.kKO = str2;
            c35913df.signature = str3;
            linkedList.add(c35913df);
        }
        if (C14827e.aip(str)) {
            AppMethodBeat.m2505o(11669);
            return;
        }
        C1207m c26475z = new C26475z(str, i, linkedList);
        final Bundle bundle2 = bundle;
        final Context context2 = context;
        final int i2 = i;
        final String str4 = str;
        final C14831a c14831a2 = c14831a;
        C1720g.m3540Rg().mo14539a((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, new C1202f() {
            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                String str2;
                AppMethodBeat.m2504i(11656);
                C1720g.m3540Rg().mo14546b((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (C1202f) this);
                C4990ab.m7417i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: errType = %s; errCode = %s; errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                boolean z = false;
                if (c1207m == null || !(c1207m instanceof C26475z)) {
                    str2 = str;
                } else {
                    String ajD = ((C26475z) c1207m).ajD();
                    if (C14827e.aim(ajD)) {
                        try {
                            C4990ab.m7417i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: deepLinkUri = %s", ajD);
                            C4990ab.m7417i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink gotoUri extraData: %s", bundle2);
                            z = C14827e.m23074a(context2, ajD, i2, bundle2, str4);
                            C7060h.pYm.mo8381e(11405, str4, Integer.valueOf(i2), Integer.valueOf(1), ajD);
                            if (C14827e.van) {
                                str = context2.getString(C25738R.string.g8e);
                                C14827e.van = false;
                            }
                            str2 = str;
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.DeepLinkHelper", e, "", "");
                            C7060h.pYm.mo8381e(11405, str4, Integer.valueOf(i2), Integer.valueOf(0), ajD);
                            str2 = str;
                        }
                    } else if (i2 != 1 || c14831a2 == null) {
                        C4990ab.m7416i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: translate failed");
                        Intent intent = new Intent();
                        intent.setFlags(268435456);
                        intent.setClassName(C4996ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                        intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
                        intent.putExtra("showShare", false);
                        C4990ab.m7417i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink goto WebViewUI extraData: %s", bundle2);
                        if (bundle2 != null) {
                            intent.putExtras(bundle2);
                        }
                        C4996ah.getContext().startActivity(intent);
                        C7060h.pYm.mo8381e(11405, str4, Integer.valueOf(i2), Integer.valueOf(0), ajD);
                        z = true;
                        str2 = str;
                    } else {
                        C7060h.pYm.mo8381e(11405, str4, Integer.valueOf(i2), Integer.valueOf(0), ajD);
                        c14831a2.mo6738a(i, i2, str, c1207m, false);
                        AppMethodBeat.m2505o(11656);
                        return;
                    }
                }
                if (c14831a2 != null) {
                    c14831a2.mo6738a(i, i2, str2, c1207m, z);
                }
                AppMethodBeat.m2505o(11656);
            }
        });
        C1720g.m3540Rg().mo14541a(c26475z, 0);
        AppMethodBeat.m2505o(11669);
    }

    /* renamed from: a */
    public static void m23069a(Context context, String str, int i, C14831a c14831a) {
        AppMethodBeat.m2504i(11670);
        C14827e.m23068a(context, str, i, null, c14831a, null, null);
        AppMethodBeat.m2505o(11670);
    }

    /* renamed from: a */
    public static void m23067a(Context context, String str, int i, Bundle bundle, C14831a c14831a) {
        AppMethodBeat.m2504i(11671);
        C14827e.m23068a(context, str, i, bundle, c14831a, null, null);
        AppMethodBeat.m2505o(11671);
    }

    /* renamed from: a */
    public static boolean m23072a(Context context, int i, byte[] bArr, String str) {
        AppMethodBeat.m2504i(11673);
        boolean a = C14827e.m23073a(context, str, 0, null, i, bArr, null);
        AppMethodBeat.m2505o(11673);
        return a;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static boolean m23073a(Context context, String str, int i, Bundle bundle, int i2, byte[] bArr, String str2) {
        AppMethodBeat.m2504i(11675);
        String air = C14827e.air(str);
        String str3;
        String str4;
        String substring;
        String encode;
        String encode2;
        int h;
        Uri parse;
        String queryParameter;
        Uri parse2;
        int i3;
        int i4;
        final Intent intent;
        if (C5046bo.isNullOrNil(air)) {
            AppMethodBeat.m2505o(11675);
            return false;
        } else if (vap.containsKey(air)) {
            long longValue = ((Long) vap.get(air)).longValue();
            C4990ab.m7417i("MicroMsg.DeepLinkHelper", "gotoUri, deepLinkMap contains uri, result = %d", Long.valueOf(longValue));
            str3 = null;
            Intent intent2 = new Intent();
            intent2.setFlags(268435456);
            int QF;
            String encode3;
            if (longValue == 0) {
                str3 = "com.tencent.mm.ui.LauncherUI";
            } else if (longValue == 1) {
                str3 = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI";
                C7060h.pYm.mo8381e(12065, Integer.valueOf(7));
            } else if (longValue == 2) {
                intent2.putExtra("from_deeplink", true);
                intent2.putExtra("game_report_from_scene", 6);
                str3 = "com.tencent.mm.plugin.game.ui.GameCenterUI";
            } else if (longValue == 4) {
                if (((C1853r.m3829YK() & 32768) == 0 ? 1 : null) != null) {
                    str3 = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI";
                    intent2.putExtra("sns_timeline_NeedFirstLoadint", true);
                }
            } else if (longValue == 8) {
                str3 = "com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI";
            } else if (longValue == 16) {
                C6489hv c6489hv = new C6489hv();
                C4879a.xxA.mo10055m(c6489hv);
                str4 = c6489hv.cCO.url;
                if (!C5046bo.isNullOrNil(str4)) {
                    intent2.putExtra("rawUrl", str4);
                    intent2.putExtra("useJs", true);
                    intent2.putExtra("vertical_scroll", true);
                    intent2.putExtra("geta8key_session_id", i2);
                    intent2.putExtra("geta8key_cookie", bArr);
                    str3 = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
                }
            } else if (longValue == 32) {
                intent2.putExtra("titile", C4996ah.getContext().getString(C25738R.string.f8781es));
                intent2.putExtra("list_type", 0);
                intent2.putExtra("list_attr", C15830s.m24190C(C15830s.znG, 256, 512));
                str3 = "com.tencent.mm.ui.contact.SelectContactUI";
            } else if (longValue == 64) {
                str3 = "com.tencent.mm.plugin.scanner.ui.BaseScanUI";
                intent2.putExtra("animation_pop_in", true);
            } else if (longValue == 128) {
                str3 = "com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI";
            } else if (longValue == 256) {
                str3 = "com.tencent.mm.plugin.setting.ui.setting.SettingsUI";
            } else if (longValue == 512) {
                str3 = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI";
            } else if (longValue == 1024) {
                C14827e.m23076ac(C4996ah.getContext(), i2);
            } else if (longValue == 2048) {
                str3 = "com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI";
            } else if (longValue == 4096) {
                intent2.putExtra("title", C4996ah.getContext().getResources().getString(C25738R.string.dek));
                intent2.putExtra("rawUrl", C4996ah.getContext().getResources().getString(C25738R.string.ezj));
                intent2.putExtra("showShare", false);
                intent2.putExtra("geta8key_session_id", i2);
                intent2.putExtra("geta8key_cookie", bArr);
                str3 = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
            } else if (longValue == 8192) {
                str3 = "com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI";
            } else if (longValue == 16384) {
                str3 = "com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsUI";
            } else if (longValue == 32768) {
                str3 = "com.tencent.mm.plugin.clean.ui.CleanUI";
            } else if (longValue == 65536) {
                try {
                    str4 = "";
                    int indexOf = str.indexOf("?");
                    if (indexOf > 0) {
                        substring = str.substring(indexOf + 1);
                    } else {
                        substring = str4;
                    }
                    C1720g.m3534RN();
                    QF = C1668a.m3383QF();
                    encode = URLEncoder.encode(C7243d.DEVICE_NAME, ProtocolPackage.ServerEncoding);
                    encode2 = URLEncoder.encode(C5046bo.dpA(), ProtocolPackage.ServerEncoding);
                    air = URLEncoder.encode(C1427q.m3026LK(), ProtocolPackage.ServerEncoding);
                    String encode4 = URLEncoder.encode(C7243d.vxi, ProtocolPackage.ServerEncoding);
                    encode3 = URLEncoder.encode(C7243d.vxj, ProtocolPackage.ServerEncoding);
                    str4 = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index" + "&version=" + C7243d.vxo + "&lang=" + C4988aa.m7403gw(C4996ah.getContext()) + "&" + C5046bo.nullAsNil(substring) + ("&uin=" + QF + "&deviceName=" + encode + "&timeZone=" + encode2 + "&imei=" + air + "&deviceBrand=" + encode4 + "&deviceModel=" + encode3 + "&ostype=" + URLEncoder.encode(C7243d.vxk, ProtocolPackage.ServerEncoding) + "&clientSeqID=" + URLEncoder.encode(C1668a.m3397Rb(), ProtocolPackage.ServerEncoding) + "&signature=" + URLEncoder.encode(C5046bo.m7557gS(C4996ah.getContext()), ProtocolPackage.ServerEncoding) + "&scene=" + (C5046bo.isNullOrNil(substring) ? 0 : 1));
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("rawUrl", str4);
                    intent2.putExtra("neverGetA8Key", true);
                    intent2.putExtra("geta8key_session_id", i2);
                    intent2.putExtra("geta8key_cookie", bArr);
                    intent2.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                    intent2.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                    str3 = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
                } catch (UnsupportedEncodingException e) {
                    C4990ab.m7413e("MicroMsg.DeepLinkHelper", "[oneliang]UnsupportedEncodingException:%s", e.getMessage());
                }
            } else if (longValue == 131072) {
                C1720g.m3534RN();
                QF = C1668a.m3383QF();
                h = C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(12304, null));
                str3 = C4996ah.getContext().getString(C25738R.string.ebk, new Object[]{Integer.valueOf(QF), Integer.valueOf(h)});
                intent2.putExtra("showShare", false);
                intent2.putExtra("rawUrl", str3);
                intent2.putExtra("geta8key_session_id", i2);
                intent2.putExtra("geta8key_cookie", bArr);
                str3 = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
            } else if (longValue == 262144) {
                str3 = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
            } else if (longValue == C1625i.ACTION_MINI_PROGRAM_LAUNCH) {
                str3 = "com.tencent.mm.ui.contact.ChatroomContactUI";
            } else if (longValue == 1048576) {
                str3 = "com.tencent.mm.plugin.label.ui.ContactLabelManagerUI";
            } else if (longValue == 2097152) {
                str3 = "com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI";
            } else if (longValue == 268435456) {
                intent2.putExtra("IPCallAddressUI_KFrom", 1);
                C25985d.m41467b(C4996ah.getContext(), "ipcall", ".ui.IPCallAddressUI", intent2);
                AppMethodBeat.m2505o(11675);
                return true;
            } else if (longValue == 4194304) {
                intent2.putExtra("sns_userName", (String) C1720g.m3536RP().mo5239Ry().get(2, null));
                intent2.addFlags(67108864);
                intent2.putExtra("sns_adapter_type", 1);
                C1720g.m3536RP().mo5239Ry().set(68389, Integer.valueOf(C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(68389, null), 0) + 1));
                str3 = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUserPagerUI";
            } else if (longValue == 8388608) {
                str3 = "com.tencent.mm.plugin.fav.ui.FavoriteIndexUI";
            } else if (longValue == 16777216) {
                str3 = "com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI";
            } else if (longValue == 33554432) {
                str3 = "com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI";
            } else if (longValue == 67108864) {
                str3 = "com.tencent.mm.plugin.mall.ui.MallIndexUI";
            } else if (longValue == 134217728) {
                if (!(context == null || C5046bo.isNullOrNil(str))) {
                    if (str.startsWith("weixin://dl/businessPay")) {
                        parse = Uri.parse(str);
                        if (parse != null) {
                            str4 = parse.getQueryParameter("reqkey");
                            queryParameter = parse.getQueryParameter("appid");
                            if (C5046bo.isNullOrNil(str4)) {
                                C4990ab.m7420w("MicroMsg.DeepLinkHelper", "reqkey null");
                            } else {
                                PayInfo payInfo = new PayInfo();
                                payInfo.czZ = str4;
                                payInfo.appId = queryParameter;
                                payInfo.cIf = 36;
                                payInfo.mXg = false;
                                intent2 = new Intent();
                                intent2.putExtra("key_pay_info", payInfo);
                                if (context instanceof Activity) {
                                    intent2.putExtra("key_context_hashcode", context.hashCode());
                                    C4990ab.m7417i("MicroMsg.DeepLinkHelper", "startPay context %s %s", context, Integer.valueOf(context.hashCode()));
                                }
                                if (C1853r.m3831YM()) {
                                    C25985d.m41468b(context, "wallet_payu", ".pay.ui.WalletPayUPayUI", intent2, 1);
                                } else {
                                    C25985d.m41468b(context, "wallet", ".pay.ui.WalletPayUI", intent2, 1);
                                }
                            }
                        } else {
                            C4990ab.m7420w("MicroMsg.DeepLinkHelper", "payUri null");
                        }
                    }
                }
                intent2 = null;
            } else if (longValue == 1073741824) {
                str3 = "com.tencent.mm.plugin.safedevice.ui.MySafeDeviceListUI";
            } else if (longValue == 2147483648L) {
                C4990ab.m7416i("MicroMsg.DeepLinkHelper", "enter to cardhome");
                C18296ik c18296ik = new C18296ik();
                c18296ik.cDz.context = context;
                C4879a.xxA.mo10055m(c18296ik);
            } else if (longValue == 4294967296L) {
                intent2.putExtra("filter_type", C18643z.m29128nY(C4996ah.getContext().getString(C25738R.string.c_1)).getType());
                intent2.putExtra("titile", C4996ah.getContext().getString(C25738R.string.e_n));
                intent2.putExtra("list_attr", 32768);
                str3 = "com.tencent.mm.ui.contact.SelectSpecialContactUI";
            } else if (longValue == 8589934592L) {
                str3 = "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI";
            } else if (longValue == 17179869184L) {
                str3 = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI";
            } else if (longValue == 34359738368L) {
                str3 = "com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI";
            } else if (longValue == 68719476736L) {
                str3 = "com.tencent.mm.plugin.backup.backupmoveui.BackupUI";
            } else if (longValue == 137438953472L) {
                intent2.setClassName(C4996ah.getContext(), "com.tencent.mm.plugin.account.bind.ui.BindQQUI");
                MMWizardActivity.m23791J(context, intent2);
                AppMethodBeat.m2505o(11675);
                return true;
            } else if (longValue == 274877906944L) {
                intent2.setClassName(C4996ah.getContext(), "com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI");
                MMWizardActivity.m23791J(context, intent2);
                AppMethodBeat.m2505o(11675);
                return true;
            } else if (longValue == 549755813888L) {
                str3 = "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI";
            } else if (longValue == 1099511627776L) {
                C25985d.m41467b(C4996ah.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent2.putExtra("Contact_User", "qqsync"));
                AppMethodBeat.m2505o(11675);
                return true;
            } else if (longValue == 2199023255552L) {
                str3 = "com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI";
            } else if (longValue == 4398046511104L) {
                str3 = "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI";
            } else if (longValue == 8796093022208L) {
                str3 = "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI";
            } else if (longValue == 17592186044416L) {
                intent2.putExtra("launch_from_webview", false);
                C25985d.m41472c(C4996ah.getContext(), "address", ".ui.WalletSelectAddrUI", intent2);
                AppMethodBeat.m2505o(11675);
                return true;
            } else if (longValue == 35184372088832L) {
                intent2.putExtra("k_sns_tag_id", 4);
                intent2.putExtra("k_sns_from_settings_about_sns", 1);
                C25985d.m41467b(C4996ah.getContext(), "sns", ".ui.SnsBlackDetailUI", intent2);
                AppMethodBeat.m2505o(11675);
                return true;
            } else if (longValue == 70368744177664L) {
                intent2.putExtra("k_sns_tag_id", 5);
                intent2.putExtra("k_sns_from_settings_about_sns", 2);
                intent2.putExtra("k_tag_detail_sns_block_scene", 8);
                C25985d.m41467b(C4996ah.getContext(), "sns", ".ui.SnsTagDetailUI", intent2);
            } else if (longValue == 140737488355328L) {
                str3 = "com.tencent.mm.plugin.emoji.ui.EmojiMineUI";
            } else if (longValue == 281474976710656L) {
                C45313by c45313by = new C45313by();
                c45313by.cvf.cvh = "//uplog";
                c45313by.cvf.context = C4996ah.getContext();
                C4879a.xxA.mo10055m(c45313by);
                AppMethodBeat.m2505o(11675);
                return true;
            } else if (longValue == 562949953421312L) {
                intent2.putExtra("IPCallAddressUI_KFrom", 1);
                C25985d.m41467b(C4996ah.getContext(), "ipcall", ".ui.IPCallAddressUI", intent2);
                C25985d.m41467b(C4996ah.getContext(), "ipcall", ".ui.IPCallShareCouponUI", intent2);
                AppMethodBeat.m2505o(11675);
                return true;
            } else if (longValue == 18014398509481984L) {
                intent2.putExtra("IPCallAddressUI_KFrom", 1);
                C25985d.m41467b(C4996ah.getContext(), "ipcall", ".ui.IPCallAddressUI", intent2);
                C25985d.m41467b(C4996ah.getContext(), "ipcall", ".ui.IPCallShareCouponUI", intent2);
                C25985d.m41467b(C4996ah.getContext(), "ipcall", ".ui.IPCallShareCouponCardUI", intent2);
            } else if (longValue == 576460752303423488L) {
                intent2.putExtra("IPCallAddressUI_KFrom", 1);
                intent2.setClassName(C4996ah.getContext(), "com.tencent.mm.plugin.sight.draft.ui.SightDraftUI");
                C4996ah.getContext().startActivity(intent2);
            } else if (longValue == 1125899906842624L) {
                str3 = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI";
            } else if (longValue == 4503599627370496L) {
                intent2.putExtra("emoji_tab", 1);
                str3 = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI";
                C7060h.pYm.mo8381e(12065, Integer.valueOf(7));
            } else if (longValue == 9007199254740992L) {
                str3 = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI";
            } else if (longValue == 576460752303423489L) {
                parse2 = Uri.parse(str);
                String queryParameter2 = parse2.getQueryParameter("appid");
                str4 = parse2.getQueryParameter("userName");
                air = parse2.getQueryParameter("path");
                i3 = C5046bo.getInt(C5046bo.nullAsNil(parse2.getQueryParameter("pathType")), 0);
                String queryParameter3 = parse2.getQueryParameter("invokeData");
                substring = parse2.getQueryParameter("runtimeSessionId");
                encode2 = parse2.getQueryParameter("runtimeTicket");
                encode3 = parse2.getQueryParameter("runtimeAppid");
                i4 = 0;
                C32800b y = C37922v.m64076Zp().mo60676y("key_data_center_session_id", false);
                if (y != null) {
                    i4 = ((Integer) y.get("key_launch_miniprogram_type", Integer.valueOf(0))).intValue();
                }
                C4990ab.m7417i("MicroMsg.DeepLinkHelper", "appid = %s, userName = %s, path = %s, translateLinkScene = %d, type = %d", queryParameter2, str4, air, Integer.valueOf(i), Integer.valueOf(i4));
                C37922v.m64076Zp().mo60674nV("key_data_center_session_id");
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.cst = URLEncoder.encode(str2);
                if (i == 2) {
                    appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_RUOZHU;
                    ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(context, str4, null, i4, 0, air, appBrandStatObject);
                } else if (i == 1) {
                    C4990ab.m7411d("MicroMsg.DeepLinkHelper", "pathType:%d invokeData:%s", Integer.valueOf(i3), queryParameter3);
                    if (i3 != 1 || C5046bo.isNullOrNil(queryParameter3)) {
                        appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_SHUILAN;
                        appBrandStatObject.cst = queryParameter2;
                        ((C45691e) C1720g.m3528K(C45691e.class)).mo68046a(context, str4, null, i4, 0, air, appBrandStatObject, queryParameter2);
                    } else {
                        str3 = "";
                        try {
                            str3 = new C41726i(queryParameter3).optString("name");
                        } catch (C41724g e2) {
                            C4990ab.printErrStackTrace("MicroMsg.DeepLinkHelper", e2, "", new Object[0]);
                        }
                        C4990ab.m7417i("MicroMsg.DeepLinkHelper", "runtimeSessionId:%s runtimeTicket:%s runtimeAppId:%s functionName:%s", substring, encode2, encode3, str3);
                        appBrandStatObject.scene = FaceManager.FACE_ACQUIRED_HACKER;
                        appBrandStatObject.cst = encode3 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str3;
                        ((C45691e) C1720g.m3528K(C45691e.class)).mo68044a(context, str4, i4, air, appBrandStatObject, queryParameter2, queryParameter3);
                    }
                } else if (i == 6) {
                    appBrandStatObject.scene = 1007;
                    ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(context, str4, null, i4, 0, air, appBrandStatObject);
                } else if (i == 7) {
                    appBrandStatObject.scene = 1008;
                    ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(context, str4, null, i4, 0, air, appBrandStatObject);
                } else {
                    appBrandStatObject.scene = 1000;
                    ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(context, str4, null, 0, 0, air, appBrandStatObject);
                }
                AppMethodBeat.m2505o(11675);
                return true;
            } else if (longValue == 576460752303423490L) {
                str4 = Uri.parse(str).getQueryParameter("appid");
                Intent intent3 = new Intent();
                C4990ab.m7411d("MicroMsg.WalletManager", "start offline from sdk: %s", str4);
                intent3.putExtra("key_from_scene", 8);
                intent3.putExtra("key_appid", str4);
                C25985d.m41468b(context, "offline", ".ui.WalletOfflineEntranceUI", intent3, 0);
            }
            if (C5046bo.isNullOrNil(str3)) {
                AppMethodBeat.m2505o(11675);
                return false;
            }
            intent2.setClassName(C4996ah.getContext(), str3);
            if (context != null) {
                try {
                    context.startActivity(intent2);
                } catch (Exception e3) {
                    C4990ab.printErrStackTrace("MicroMsg.DeepLinkHelper", e3, "", "");
                }
            } else {
                C4996ah.getContext().startActivity(intent2);
                C5274b.m8044K(C4996ah.getContext(), intent2);
            }
            AppMethodBeat.m2505o(11675);
            return true;
        } else if (air.startsWith("weixin://dl/businessTempSession/")) {
            intent = new Intent();
            intent.setFlags(268435456);
            Uri parse3 = Uri.parse(str);
            if (parse3 == null) {
                C4990ab.m7412e("MicroMsg.DeepLinkHelper", "tempsession uri is null");
                AppMethodBeat.m2505o(11675);
                return false;
            }
            encode = parse3.getQueryParameter("sessionFrom");
            encode2 = parse3.getQueryParameter("showtype");
            str3 = parse3.getQueryParameter("username");
            if (C5046bo.isNullOrNil(str3)) {
                queryParameter = parse3.getQueryParameter("userName");
            } else {
                queryParameter = str3;
            }
            if (C5046bo.isNullOrNil(queryParameter)) {
                C4990ab.m7412e("MicroMsg.DeepLinkHelper", "tempsession user is null");
                AppMethodBeat.m2505o(11675);
                return false;
            }
            h = C5046bo.getInt(C5046bo.nullAsNil(parse3.getQueryParameter("scene")), 0);
            if (h != 0 && i == 4) {
                C4990ab.m7416i("MicroMsg.DeepLinkHelper", "Jsapi assign scene to ".concat(String.valueOf(h)));
                i = h;
            }
            C4990ab.m7417i("MicroMsg.DeepLinkHelper", "tempsession jump, %s, %s, %s, %s, %s.", queryParameter, encode, Integer.valueOf(i), str, encode2);
            intent.setClassName(C4996ah.getContext(), "com.tencent.mm.ui.chatting.ChattingUI");
            intent.putExtra("Chat_User", queryParameter);
            intent.putExtra("finish_direct", true);
            intent.putExtra("key_is_temp_session", true);
            intent.putExtra("key_temp_session_from", encode);
            intent.putExtra("key_temp_session_scene", i);
            intent.putExtra("key_temp_session_show_type", C5046bo.getInt(encode2, 0));
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(queryParameter);
            if (aoO == null || ((int) aoO.ewQ) <= 0) {
                final Context context2 = context;
                C26417a.flu.mo20966a(queryParameter, "", new C9636a() {
                    /* renamed from: o */
                    public final void mo6218o(String str, boolean z) {
                        AppMethodBeat.m2504i(11657);
                        if (z) {
                            intent.putExtra("Chat_User", str);
                            try {
                                if (context2 != null) {
                                    context2.startActivity(intent);
                                    AppMethodBeat.m2505o(11657);
                                    return;
                                }
                                C4996ah.getContext().startActivity(intent);
                                AppMethodBeat.m2505o(11657);
                                return;
                            } catch (Exception e) {
                                C4990ab.printErrStackTrace("MicroMsg.DeepLinkHelper", e, "", "");
                                AppMethodBeat.m2505o(11657);
                                return;
                            }
                        }
                        C4990ab.m7413e("MicroMsg.DeepLinkHelper", "getContact fail, %s", str);
                        AppMethodBeat.m2505o(11657);
                    }
                });
            } else {
                context.startActivity(intent);
            }
            AppMethodBeat.m2505o(11675);
            return true;
        } else if (air.startsWith("weixin://dl/businessGame/detail/") || air.startsWith("weixin://dl/businessGame/detail")) {
            C4990ab.m7416i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith GAME_DETAIL");
            parse = Uri.parse(str);
            str3 = null;
            intent = new Intent();
            if (parse != null) {
                str3 = "com.tencent.mm.plugin.game.ui.GameDetailUI";
                intent.putExtra("game_app_id", parse.getQueryParameter("appid"));
                intent.putExtra("game_report_from_scene", 6);
            }
            if (C5046bo.isNullOrNil(str3)) {
                AppMethodBeat.m2505o(11675);
                return false;
            }
            intent.setClassName(C4996ah.getContext(), str3);
            if (context != null) {
                try {
                    context.startActivity(intent);
                } catch (Exception e32) {
                    C4990ab.printErrStackTrace("MicroMsg.DeepLinkHelper", e32, "", "");
                }
            } else {
                C4996ah.getContext().startActivity(intent);
                C5274b.m8044K(C4996ah.getContext(), intent);
            }
            AppMethodBeat.m2505o(11675);
            return true;
        } else if (air.startsWith("weixin://dl/businessGame/library/") || air.startsWith("weixin://dl/businessGame/library")) {
            C4990ab.m7416i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith GAME_LIBRARY");
            Intent intent4 = new Intent();
            queryParameter = "com.tencent.mm.plugin.game.ui.GameLibraryUI";
            if (C5046bo.isNullOrNil(queryParameter)) {
                AppMethodBeat.m2505o(11675);
                return false;
            }
            intent4.putExtra("game_report_from_scene", 6);
            intent4.setClassName(C4996ah.getContext(), queryParameter);
            if (context != null) {
                try {
                    context.startActivity(intent4);
                } catch (Exception e322) {
                    C4990ab.printErrStackTrace("MicroMsg.DeepLinkHelper", e322, "", "");
                }
            } else {
                C4996ah.getContext().startActivity(intent4);
                C5274b.m8044K(C4996ah.getContext(), intent4);
            }
            AppMethodBeat.m2505o(11675);
            return true;
        } else if (air.startsWith("weixin://dl/businessWebview/link/") || air.startsWith("weixin://dl/businessWebview/link")) {
            C4990ab.m7416i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith H5_LINK");
            parse = Uri.parse(str);
            intent = new Intent();
            str3 = null;
            if (parse != null) {
                substring = parse.getQueryParameter("url");
                i4 = C5046bo.getInt(parse.getQueryParameter("type"), 0);
                encode2 = C5046bo.nullAsNil(parse.getQueryParameter("appid"));
                i3 = C5046bo.getInt(C5046bo.nullAsNil(parse.getQueryParameter("outer")), 0);
                C4990ab.m7417i("MicroMsg.DeepLinkHelper", "gotoUri, rawUrl = %s, appId:%s, translateLinkScene: %s, outer:%d", substring, encode2, Integer.valueOf(i), Integer.valueOf(i3));
                str3 = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
                intent.putExtra("rawUrl", substring);
                intent.putExtra("geta8key_session_id", i2);
                intent.putExtra("geta8key_cookie", bArr);
                if (i == 1) {
                    if (i3 == 1) {
                        intent.putExtra("geta8key_open_webview_appid", encode2);
                        intent.putExtra("geta8key_scene", 53);
                    }
                    intent.putExtra("show_openapp_dialog", false);
                    intent.putExtra("pay_channel", 40);
                    C14991i.m23324Lt(39);
                } else if (i == 2) {
                    if (i3 == 1) {
                        intent.putExtra("geta8key_open_webview_appid", encode2);
                        intent.putExtra("geta8key_scene", 52);
                    }
                    intent.putExtra("pay_channel", 39);
                    C14991i.m23324Lt(39);
                }
                if (i4 == 5) {
                    intent.putExtra("webview_invoke_launch_app_when_back", true);
                    intent.putExtra("webview_invoke_launch_app_ext_info_when_back", String.format("%s://opentypewebview?wx_internal_resptype=%d&ret=%d", new Object[]{encode2, Integer.valueOf(i4), Integer.valueOf(-2)}));
                    intent.putExtra("KAppId", encode2);
                }
                intent.putExtra("transaction_for_openapi_openwebview", vao);
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
            }
            if (C5046bo.isNullOrNil(str3)) {
                AppMethodBeat.m2505o(11675);
                return false;
            }
            intent.setClassName(C4996ah.getContext(), str3);
            if (context != null) {
                try {
                    context.startActivity(intent);
                } catch (Exception e3222) {
                    C4990ab.printErrStackTrace("MicroMsg.DeepLinkHelper", e3222, "", "");
                }
            } else {
                C4996ah.getContext().startActivity(intent);
                C5274b.m8044K(C4996ah.getContext(), intent);
            }
            AppMethodBeat.m2505o(11675);
            return true;
        } else if (air.startsWith("weixin://dl/openbusinesswebview/link/")) {
            C4990ab.m7416i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith openbusinesswebview");
            parse = Uri.parse(str);
            intent = new Intent();
            str3 = null;
            if (parse != null) {
                substring = parse.getQueryParameter("url");
                i4 = C5046bo.getInt(parse.getQueryParameter("type"), 0);
                queryParameter = C5046bo.nullAsNil(parse.getQueryParameter("appid"));
                C4990ab.m7417i("MicroMsg.DeepLinkHelper", "gotoUri, rawUrl = %s, appId:%s, translateLinkScene: %s", substring, queryParameter, Integer.valueOf(i));
                str3 = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
                intent.putExtra("rawUrl", substring);
                intent.putExtra("geta8key_session_id", i2);
                intent.putExtra("geta8key_cookie", bArr);
                intent.putExtra("geta8key_open_webview_appid", queryParameter);
                intent.putExtra("geta8key_scene", 57);
                intent.putExtra("show_openapp_dialog", false);
                intent.putExtra("webview_invoke_launch_app_when_back", true);
                intent.putExtra("webview_invoke_launch_app_ext_info_when_back", String.format("%s://openbusinesswebview?type=%d&ret=%d", new Object[]{queryParameter, Integer.valueOf(i4), Integer.valueOf(-2)}));
                intent.putExtra("KAppId", queryParameter);
                intent.putExtra("transaction_for_openapi_openwebview", vao);
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
            }
            if (C5046bo.isNullOrNil(str3)) {
                AppMethodBeat.m2505o(11675);
                return false;
            }
            intent.setClassName(C4996ah.getContext(), str3);
            if (context != null) {
                try {
                    context.startActivity(intent);
                } catch (Exception e32222) {
                    C4990ab.printErrStackTrace("MicroMsg.DeepLinkHelper", e32222, "", "");
                }
            } else {
                C4996ah.getContext().startActivity(intent);
                C5274b.m8044K(C4996ah.getContext(), intent);
            }
            AppMethodBeat.m2505o(11675);
            return true;
        } else if (air.startsWith("weixin://dl/jumpFakeWxa/") || air.startsWith("weixin://dl/openNativeView/")) {
            parse2 = Uri.parse(str);
            str4 = parse2.getQueryParameter("appid");
            substring = parse2.getQueryParameter("businessType");
            encode = null;
            queryParameter = null;
            int i5 = 0;
            C32800b y2 = C37922v.m64076Zp().mo60676y("key_data_center_session_id", false);
            if (y2 != null) {
                i5 = ((Integer) y2.get("key_launch_miniprogram_type", Integer.valueOf(0))).intValue();
                queryParameter = (String) y2.get("key_open_business_view_ext_info", "");
                encode = (String) y2.get("key_launch_miniprogram_query_info", "");
            }
            C4990ab.m7417i("MicroMsg.DeepLinkHelper", "appid = %s, translateLinkScene = %d, type = %d", str4, Integer.valueOf(i), Integer.valueOf(i5));
            C37922v.m64076Zp().mo60674nV("key_data_center_session_id");
            if (!air.startsWith("weixin://dl/jumpFakeWxa/")) {
                Object obj;
                C40417a c40417a = C40416b.vaj;
                if (substring != null) {
                    switch (substring.hashCode()) {
                        case -1919727738:
                            if (substring.equals("nativeEmergencyContact")) {
                                C25052j.m39376p(substring, "businessType");
                                C35892i.m58841c(substring, "testExtMsg", str4, -3, "testErrMsg");
                                obj = 1;
                                break;
                            }
                        case 554520581:
                            if (substring.equals("nativeShareToHaokan")) {
                                C25052j.m39376p(substring, "businessType");
                                C4210c.m6558an(substring, str4, queryParameter);
                                obj = 1;
                                break;
                            }
                    }
                }
                obj = null;
                if (obj != null) {
                    AppMethodBeat.m2505o(11675);
                    return true;
                }
                van = true;
                AppMethodBeat.m2505o(11675);
                return false;
            } else if (i == 1) {
                ((C45691e) C1720g.m3528K(C45691e.class)).mo68047a(context, str4, substring, encode, i5);
                AppMethodBeat.m2505o(11675);
                return true;
            } else {
                AppMethodBeat.m2505o(11675);
                return false;
            }
        } else {
            AppMethodBeat.m2505o(11675);
            return false;
        }
    }

    /* renamed from: ac */
    private static void m23076ac(Context context, int i) {
        String string;
        AppMethodBeat.m2504i(11677);
        if (!C5059g.xyg && C4988aa.dor().equals("zh_CN")) {
            string = context.getString(C25738R.string.g0f);
        } else if (C4988aa.dor().equals("zh_HK")) {
            string = context.getString(C25738R.string.g0g);
        } else if (C4988aa.dor().equals("zh_TW")) {
            string = context.getString(C25738R.string.g0h);
        } else {
            string = context.getString(C25738R.string.g0i);
        }
        C4990ab.m7410d("MicroMsg.DeepLinkHelper", "using faq webpage");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("show_feedback", false);
        intent.putExtra("KShowFixToolsBtn", true);
        intent.putExtra("geta8key_session_id", i);
        C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(11677);
    }

    private static String air(String str) {
        AppMethodBeat.m2504i(11678);
        String str2 = null;
        if (!C5046bo.isNullOrNil(str)) {
            Uri parse = Uri.parse(str);
            str2 = parse.getScheme() + "://" + parse.getHost() + parse.getPath();
        }
        AppMethodBeat.m2505o(11678);
        return str2;
    }

    /* renamed from: A */
    public static void m23065A(final Context context, String str, String str2) {
        AppMethodBeat.m2504i(11679);
        if (C14827e.aip(str2)) {
            AppMethodBeat.m2505o(11679);
            return;
        }
        final C44275p b = C30379h.m48458b(context, "", true, null);
        int i = 6;
        if (!C5046bo.isNullOrNil(str)) {
            if (C1855t.m3896kH(str)) {
                i = 7;
            } else if (C1855t.m3913mZ(str)) {
                i = 9;
            }
        }
        C14827e.m23069a(context, str2, i, new C14831a() {
            /* renamed from: a */
            public final void mo6738a(int i, int i2, String str, C1207m c1207m, boolean z) {
                AppMethodBeat.m2504i(11658);
                C4990ab.m7417i("MicroMsg.DeepLinkHelper", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                if (b != null && b.isShowing()) {
                    b.dismiss();
                }
                if (!(c1207m == null || i == 0 || i2 == 0 || !(c1207m instanceof C26475z))) {
                    ciq ajE = ((C26475z) c1207m).ajE();
                    if (!(ajE == null || context == null)) {
                        C23639t.makeText(context, context.getString(C25738R.string.f9238tz) + " : " + C5046bo.nullAsNil(ajE.xhy), 0).show();
                    }
                }
                AppMethodBeat.m2505o(11658);
            }
        });
        AppMethodBeat.m2505o(11679);
    }

    /* renamed from: bu */
    public static void m23077bu(Context context, String str) {
        AppMethodBeat.m2504i(11680);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url is null. finish");
            AppMethodBeat.m2505o(11680);
        } else if (str.startsWith("weixin://dl/login/phone_view")) {
            Uri parse = Uri.parse(str);
            C4990ab.m7411d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI cc:%s num:%s", parse.getQueryParameter("cc"), parse.getQueryParameter("num"));
            Intent intent = new Intent();
            intent.putExtra("couttry_code", r1);
            intent.putExtra("input_mobile_number", r0);
            intent.putExtra("from_deep_link", true);
            intent.putExtra("mobile_input_purpose", 1);
            intent.addFlags(268435456);
            C25985d.m41467b(context, "account", ".ui.MobileInputUI", intent);
            AppMethodBeat.m2505o(11680);
        } else if (str.startsWith("weixin://dl/login/common_view")) {
            C4990ab.m7411d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI  username:%s", Uri.parse(str).getQueryParameter("username"));
            Intent intent2 = new Intent();
            intent2.putExtra("login_username", r0);
            intent2.putExtra("from_deep_link", true);
            intent2.addFlags(268435456);
            C25985d.m41467b(context, "account", ".ui.LoginUI", intent2);
            AppMethodBeat.m2505o(11680);
        } else {
            C4990ab.m7413e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url not Correct:%s", str);
            AppMethodBeat.m2505o(11680);
        }
    }

    public static boolean aiq(String str) {
        AppMethodBeat.m2504i(11672);
        boolean a = C14827e.m23073a(null, str, 0, null, (int) System.currentTimeMillis(), new byte[0], null);
        AppMethodBeat.m2505o(11672);
        return a;
    }

    /* renamed from: a */
    public static boolean m23074a(Context context, String str, int i, Bundle bundle, String str2) {
        AppMethodBeat.m2504i(11674);
        boolean a = C14827e.m23073a(context, str, i, bundle, (int) System.currentTimeMillis(), new byte[0], str2);
        AppMethodBeat.m2505o(11674);
        return a;
    }

    /* renamed from: fC */
    public static void m23078fC(Context context) {
        AppMethodBeat.m2504i(11676);
        C14827e.m23076ac(context, (int) System.currentTimeMillis());
        AppMethodBeat.m2505o(11676);
    }
}
