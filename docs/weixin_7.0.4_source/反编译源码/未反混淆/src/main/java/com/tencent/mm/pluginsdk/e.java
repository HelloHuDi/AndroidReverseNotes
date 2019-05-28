package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.by;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.g.a.ik;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.topstory.ui.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.protocal.protobuf.df;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.s;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.view.d;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class e {
    private static boolean van = false;
    public static String vao = "";
    private static final Map<String, Long> vap;

    public interface a {
        void a(int i, int i2, String str, m mVar, boolean z);
    }

    static {
        AppMethodBeat.i(11681);
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
        vap.put("weixin://dl/groups", Long.valueOf(i.ACTION_MINI_PROGRAM_LAUNCH));
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
        AppMethodBeat.o(11681);
    }

    public static boolean aH(String str, long j) {
        boolean z;
        AppMethodBeat.i(11659);
        if (!bo.isNullOrNil(str)) {
            long longValue;
            String air = air(str);
            if (vap.containsKey(air)) {
                longValue = ((Long) vap.get(air)).longValue();
            } else {
                longValue = -1;
            }
            if (longValue != -1 && (longValue == 0 || (longValue & j) == longValue)) {
                z = true;
                AppMethodBeat.o(11659);
                return z;
            }
        }
        z = false;
        AppMethodBeat.o(11659);
        return z;
    }

    public static boolean aim(String str) {
        AppMethodBeat.i(11660);
        String air = air(str);
        if (!(vap.containsKey(air) || ain(air) || aio(air))) {
            boolean z;
            if (bo.isNullOrNil(air) || !(air.startsWith("weixin://dl/jumpFakeWxa/") || air.startsWith("weixin://dl/openNativeView/"))) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                AppMethodBeat.o(11660);
                return false;
            }
        }
        AppMethodBeat.o(11660);
        return true;
    }

    public static boolean ain(String str) {
        AppMethodBeat.i(11661);
        if (bo.isNullOrNil(str) || !str.startsWith("weixin://dl/business")) {
            AppMethodBeat.o(11661);
            return false;
        }
        AppMethodBeat.o(11661);
        return true;
    }

    public static boolean aio(String str) {
        AppMethodBeat.i(11662);
        if (bo.isNullOrNil(str) || !str.startsWith("weixin://dl/openbusinesswebview")) {
            AppMethodBeat.o(11662);
            return false;
        }
        AppMethodBeat.o(11662);
        return true;
    }

    public static boolean s(Uri uri) {
        AppMethodBeat.i(11663);
        if (uri == null) {
            AppMethodBeat.o(11663);
            return false;
        } else if (bo.isNullOrNil(uri.getQueryParameter("ticket"))) {
            boolean t = t(uri);
            AppMethodBeat.o(11663);
            return t;
        } else {
            AppMethodBeat.o(11663);
            return true;
        }
    }

    public static boolean t(Uri uri) {
        AppMethodBeat.i(11664);
        if (uri == null) {
            AppMethodBeat.o(11664);
            return false;
        } else if (uri.toString().startsWith("weixin://dl/business/tempsession/") || uri.toString().startsWith("weixin://dl/businessTempSession/")) {
            AppMethodBeat.o(11664);
            return true;
        } else {
            AppMethodBeat.o(11664);
            return false;
        }
    }

    private static boolean dgP() {
        AppMethodBeat.i(11665);
        if (!g.RK()) {
            AppMethodBeat.o(11665);
            return false;
        } else if (com.tencent.mm.m.g.Nu().getInt("WCOEntranceSwitch", 0) > 0) {
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.TRUE);
            AppMethodBeat.o(11665);
            return true;
        } else {
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.FALSE);
            AppMethodBeat.o(11665);
            return false;
        }
    }

    private static boolean aip(String str) {
        AppMethodBeat.i(11666);
        if ((str.equals("weixin://dl/wechatout") || str.equals("weixin://dl/wechatoutcoupon") || str.equals("weixin://dl/wechatoutshare")) && !dgP()) {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setClassName(ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
            intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
            ah.getContext().startActivity(intent);
            AppMethodBeat.o(11666);
            return true;
        }
        AppMethodBeat.o(11666);
        return false;
    }

    public static void a(Context context, String str, String str2, int i, String str3, a aVar) {
        AppMethodBeat.i(11667);
        String str4 = bo.isNullOrNil(str) ? str3 : str;
        if (aip(str4)) {
            AppMethodBeat.o(11667);
            return;
        }
        m hVar = new h(str4, str2, i, 0, (int) System.currentTimeMillis(), new byte[0]);
        final Context context2 = context;
        final int i2 = i;
        final String str5 = str2;
        final String str6 = str4;
        final a aVar2 = aVar;
        g.Rg().a((int) d.MIC_PTU_MEISHI, new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(11655);
                g.Rg().b((int) d.MIC_PTU_MEISHI, (f) this);
                ab.i("MicroMsg.DeepLinkHelper", "[oneliang][doDeepLink][onSceneEnd]:errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                boolean z = false;
                if (mVar != null && (mVar instanceof h)) {
                    h hVar = (h) mVar;
                    ab.d("MicroMsg.DeepLinkHelper", "bitset:" + hVar.aiZ());
                    long aiZ = hVar.aiZ();
                    String aiT = hVar.aiT();
                    if (e.aH(aiT, aiZ)) {
                        try {
                            ab.i("MicroMsg.DeepLinkHelper", "[oneliang] uri: %s", aiT);
                            z = e.a(context2, hVar.ajb(), hVar.ajc(), aiT);
                            com.tencent.mm.plugin.report.service.h.pYm.e(11405, aiT, Integer.valueOf(1), Integer.valueOf(i2), str5, bo.nullAsNil(str6));
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.DeepLinkHelper", e, "", "");
                            com.tencent.mm.plugin.report.service.h.pYm.e(11405, aiT, Integer.valueOf(0), Integer.valueOf(i2), str5, bo.nullAsNil(str6));
                        }
                    } else {
                        ab.i("MicroMsg.DeepLinkHelper", "[oneliang] no permission");
                        Intent intent = new Intent();
                        intent.setFlags(268435456);
                        intent.setClassName(ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                        intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
                        intent.putExtra("geta8key_session_id", hVar.ajb());
                        intent.putExtra("geta8key_cookie", hVar.ajc());
                        ah.getContext().startActivity(intent);
                        com.tencent.mm.plugin.report.service.h.pYm.e(11405, aiT, Integer.valueOf(0), Integer.valueOf(i2), str5, bo.nullAsNil(str6));
                        z = true;
                    }
                }
                if (aVar2 != null) {
                    aVar2.a(i, i2, str, mVar, z);
                }
                AppMethodBeat.o(11655);
            }
        });
        g.Rg().a(hVar, 0);
        AppMethodBeat.o(11667);
    }

    public static void a(Context context, String str, int i, a aVar, String str2, String str3) {
        AppMethodBeat.i(11668);
        a(context, str, i, null, aVar, str2, str3);
        AppMethodBeat.o(11668);
    }

    public static void a(Context context, String str, int i, Bundle bundle, a aVar, String str2, String str3) {
        AppMethodBeat.i(11669);
        LinkedList linkedList = new LinkedList();
        df dfVar = new df();
        if (!(bo.isNullOrNil(str2) || bo.isNullOrNil(str3))) {
            ab.i("MicroMsg.DeepLinkHelper", "package name = %s, package signature = %s", str2, str3);
            dfVar.kKO = str2;
            dfVar.signature = str3;
            linkedList.add(dfVar);
        }
        if (aip(str)) {
            AppMethodBeat.o(11669);
            return;
        }
        m zVar = new z(str, i, linkedList);
        final Bundle bundle2 = bundle;
        final Context context2 = context;
        final int i2 = i;
        final String str4 = str;
        final a aVar2 = aVar;
        g.Rg().a((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                String str2;
                AppMethodBeat.i(11656);
                g.Rg().b((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (f) this);
                ab.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: errType = %s; errCode = %s; errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                boolean z = false;
                if (mVar == null || !(mVar instanceof z)) {
                    str2 = str;
                } else {
                    String ajD = ((z) mVar).ajD();
                    if (e.aim(ajD)) {
                        try {
                            ab.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: deepLinkUri = %s", ajD);
                            ab.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink gotoUri extraData: %s", bundle2);
                            z = e.a(context2, ajD, i2, bundle2, str4);
                            com.tencent.mm.plugin.report.service.h.pYm.e(11405, str4, Integer.valueOf(i2), Integer.valueOf(1), ajD);
                            if (e.van) {
                                str = context2.getString(R.string.g8e);
                                e.van = false;
                            }
                            str2 = str;
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.DeepLinkHelper", e, "", "");
                            com.tencent.mm.plugin.report.service.h.pYm.e(11405, str4, Integer.valueOf(i2), Integer.valueOf(0), ajD);
                            str2 = str;
                        }
                    } else if (i2 != 1 || aVar2 == null) {
                        ab.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: translate failed");
                        Intent intent = new Intent();
                        intent.setFlags(268435456);
                        intent.setClassName(ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                        intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
                        intent.putExtra("showShare", false);
                        ab.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink goto WebViewUI extraData: %s", bundle2);
                        if (bundle2 != null) {
                            intent.putExtras(bundle2);
                        }
                        ah.getContext().startActivity(intent);
                        com.tencent.mm.plugin.report.service.h.pYm.e(11405, str4, Integer.valueOf(i2), Integer.valueOf(0), ajD);
                        z = true;
                        str2 = str;
                    } else {
                        com.tencent.mm.plugin.report.service.h.pYm.e(11405, str4, Integer.valueOf(i2), Integer.valueOf(0), ajD);
                        aVar2.a(i, i2, str, mVar, false);
                        AppMethodBeat.o(11656);
                        return;
                    }
                }
                if (aVar2 != null) {
                    aVar2.a(i, i2, str2, mVar, z);
                }
                AppMethodBeat.o(11656);
            }
        });
        g.Rg().a(zVar, 0);
        AppMethodBeat.o(11669);
    }

    public static void a(Context context, String str, int i, a aVar) {
        AppMethodBeat.i(11670);
        a(context, str, i, null, aVar, null, null);
        AppMethodBeat.o(11670);
    }

    public static void a(Context context, String str, int i, Bundle bundle, a aVar) {
        AppMethodBeat.i(11671);
        a(context, str, i, bundle, aVar, null, null);
        AppMethodBeat.o(11671);
    }

    public static boolean a(Context context, int i, byte[] bArr, String str) {
        AppMethodBeat.i(11673);
        boolean a = a(context, str, 0, null, i, bArr, null);
        AppMethodBeat.o(11673);
        return a;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(Context context, String str, int i, Bundle bundle, int i2, byte[] bArr, String str2) {
        AppMethodBeat.i(11675);
        String air = air(str);
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
        if (bo.isNullOrNil(air)) {
            AppMethodBeat.o(11675);
            return false;
        } else if (vap.containsKey(air)) {
            long longValue = ((Long) vap.get(air)).longValue();
            ab.i("MicroMsg.DeepLinkHelper", "gotoUri, deepLinkMap contains uri, result = %d", Long.valueOf(longValue));
            str3 = null;
            Intent intent2 = new Intent();
            intent2.setFlags(268435456);
            int QF;
            String encode3;
            if (longValue == 0) {
                str3 = "com.tencent.mm.ui.LauncherUI";
            } else if (longValue == 1) {
                str3 = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI";
                com.tencent.mm.plugin.report.service.h.pYm.e(12065, Integer.valueOf(7));
            } else if (longValue == 2) {
                intent2.putExtra("from_deeplink", true);
                intent2.putExtra("game_report_from_scene", 6);
                str3 = "com.tencent.mm.plugin.game.ui.GameCenterUI";
            } else if (longValue == 4) {
                if (((r.YK() & 32768) == 0 ? 1 : null) != null) {
                    str3 = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI";
                    intent2.putExtra("sns_timeline_NeedFirstLoadint", true);
                }
            } else if (longValue == 8) {
                str3 = "com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI";
            } else if (longValue == 16) {
                hv hvVar = new hv();
                com.tencent.mm.sdk.b.a.xxA.m(hvVar);
                str4 = hvVar.cCO.url;
                if (!bo.isNullOrNil(str4)) {
                    intent2.putExtra("rawUrl", str4);
                    intent2.putExtra("useJs", true);
                    intent2.putExtra("vertical_scroll", true);
                    intent2.putExtra("geta8key_session_id", i2);
                    intent2.putExtra("geta8key_cookie", bArr);
                    str3 = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
                }
            } else if (longValue == 32) {
                intent2.putExtra("titile", ah.getContext().getString(R.string.es));
                intent2.putExtra("list_type", 0);
                intent2.putExtra("list_attr", s.C(s.znG, 256, 512));
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
                ac(ah.getContext(), i2);
            } else if (longValue == 2048) {
                str3 = "com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI";
            } else if (longValue == 4096) {
                intent2.putExtra("title", ah.getContext().getResources().getString(R.string.dek));
                intent2.putExtra("rawUrl", ah.getContext().getResources().getString(R.string.ezj));
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
                    g.RN();
                    QF = com.tencent.mm.kernel.a.QF();
                    encode = URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, ProtocolPackage.ServerEncoding);
                    encode2 = URLEncoder.encode(bo.dpA(), ProtocolPackage.ServerEncoding);
                    air = URLEncoder.encode(q.LK(), ProtocolPackage.ServerEncoding);
                    String encode4 = URLEncoder.encode(com.tencent.mm.protocal.d.vxi, ProtocolPackage.ServerEncoding);
                    encode3 = URLEncoder.encode(com.tencent.mm.protocal.d.vxj, ProtocolPackage.ServerEncoding);
                    str4 = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index" + "&version=" + com.tencent.mm.protocal.d.vxo + "&lang=" + aa.gw(ah.getContext()) + "&" + bo.nullAsNil(substring) + ("&uin=" + QF + "&deviceName=" + encode + "&timeZone=" + encode2 + "&imei=" + air + "&deviceBrand=" + encode4 + "&deviceModel=" + encode3 + "&ostype=" + URLEncoder.encode(com.tencent.mm.protocal.d.vxk, ProtocolPackage.ServerEncoding) + "&clientSeqID=" + URLEncoder.encode(com.tencent.mm.kernel.a.Rb(), ProtocolPackage.ServerEncoding) + "&signature=" + URLEncoder.encode(bo.gS(ah.getContext()), ProtocolPackage.ServerEncoding) + "&scene=" + (bo.isNullOrNil(substring) ? 0 : 1));
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("rawUrl", str4);
                    intent2.putExtra("neverGetA8Key", true);
                    intent2.putExtra("geta8key_session_id", i2);
                    intent2.putExtra("geta8key_cookie", bArr);
                    intent2.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                    intent2.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                    str3 = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
                } catch (UnsupportedEncodingException e) {
                    ab.e("MicroMsg.DeepLinkHelper", "[oneliang]UnsupportedEncodingException:%s", e.getMessage());
                }
            } else if (longValue == 131072) {
                g.RN();
                QF = com.tencent.mm.kernel.a.QF();
                h = bo.h((Integer) g.RP().Ry().get(12304, null));
                str3 = ah.getContext().getString(R.string.ebk, new Object[]{Integer.valueOf(QF), Integer.valueOf(h)});
                intent2.putExtra("showShare", false);
                intent2.putExtra("rawUrl", str3);
                intent2.putExtra("geta8key_session_id", i2);
                intent2.putExtra("geta8key_cookie", bArr);
                str3 = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
            } else if (longValue == 262144) {
                str3 = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
            } else if (longValue == i.ACTION_MINI_PROGRAM_LAUNCH) {
                str3 = "com.tencent.mm.ui.contact.ChatroomContactUI";
            } else if (longValue == 1048576) {
                str3 = "com.tencent.mm.plugin.label.ui.ContactLabelManagerUI";
            } else if (longValue == 2097152) {
                str3 = "com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI";
            } else if (longValue == 268435456) {
                intent2.putExtra("IPCallAddressUI_KFrom", 1);
                com.tencent.mm.bp.d.b(ah.getContext(), "ipcall", ".ui.IPCallAddressUI", intent2);
                AppMethodBeat.o(11675);
                return true;
            } else if (longValue == 4194304) {
                intent2.putExtra("sns_userName", (String) g.RP().Ry().get(2, null));
                intent2.addFlags(67108864);
                intent2.putExtra("sns_adapter_type", 1);
                g.RP().Ry().set(68389, Integer.valueOf(bo.a((Integer) g.RP().Ry().get(68389, null), 0) + 1));
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
                if (!(context == null || bo.isNullOrNil(str))) {
                    if (str.startsWith("weixin://dl/businessPay")) {
                        parse = Uri.parse(str);
                        if (parse != null) {
                            str4 = parse.getQueryParameter("reqkey");
                            queryParameter = parse.getQueryParameter("appid");
                            if (bo.isNullOrNil(str4)) {
                                ab.w("MicroMsg.DeepLinkHelper", "reqkey null");
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
                                    ab.i("MicroMsg.DeepLinkHelper", "startPay context %s %s", context, Integer.valueOf(context.hashCode()));
                                }
                                if (r.YM()) {
                                    com.tencent.mm.bp.d.b(context, "wallet_payu", ".pay.ui.WalletPayUPayUI", intent2, 1);
                                } else {
                                    com.tencent.mm.bp.d.b(context, "wallet", ".pay.ui.WalletPayUI", intent2, 1);
                                }
                            }
                        } else {
                            ab.w("MicroMsg.DeepLinkHelper", "payUri null");
                        }
                    }
                }
                intent2 = null;
            } else if (longValue == 1073741824) {
                str3 = "com.tencent.mm.plugin.safedevice.ui.MySafeDeviceListUI";
            } else if (longValue == 2147483648L) {
                ab.i("MicroMsg.DeepLinkHelper", "enter to cardhome");
                ik ikVar = new ik();
                ikVar.cDz.context = context;
                com.tencent.mm.sdk.b.a.xxA.m(ikVar);
            } else if (longValue == 4294967296L) {
                intent2.putExtra("filter_type", com.tencent.mm.model.z.nY(ah.getContext().getString(R.string.c_1)).getType());
                intent2.putExtra("titile", ah.getContext().getString(R.string.e_n));
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
                intent2.setClassName(ah.getContext(), "com.tencent.mm.plugin.account.bind.ui.BindQQUI");
                MMWizardActivity.J(context, intent2);
                AppMethodBeat.o(11675);
                return true;
            } else if (longValue == 274877906944L) {
                intent2.setClassName(ah.getContext(), "com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI");
                MMWizardActivity.J(context, intent2);
                AppMethodBeat.o(11675);
                return true;
            } else if (longValue == 549755813888L) {
                str3 = "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI";
            } else if (longValue == 1099511627776L) {
                com.tencent.mm.bp.d.b(ah.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent2.putExtra("Contact_User", "qqsync"));
                AppMethodBeat.o(11675);
                return true;
            } else if (longValue == 2199023255552L) {
                str3 = "com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI";
            } else if (longValue == 4398046511104L) {
                str3 = "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI";
            } else if (longValue == 8796093022208L) {
                str3 = "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI";
            } else if (longValue == 17592186044416L) {
                intent2.putExtra("launch_from_webview", false);
                com.tencent.mm.bp.d.c(ah.getContext(), "address", ".ui.WalletSelectAddrUI", intent2);
                AppMethodBeat.o(11675);
                return true;
            } else if (longValue == 35184372088832L) {
                intent2.putExtra("k_sns_tag_id", 4);
                intent2.putExtra("k_sns_from_settings_about_sns", 1);
                com.tencent.mm.bp.d.b(ah.getContext(), "sns", ".ui.SnsBlackDetailUI", intent2);
                AppMethodBeat.o(11675);
                return true;
            } else if (longValue == 70368744177664L) {
                intent2.putExtra("k_sns_tag_id", 5);
                intent2.putExtra("k_sns_from_settings_about_sns", 2);
                intent2.putExtra("k_tag_detail_sns_block_scene", 8);
                com.tencent.mm.bp.d.b(ah.getContext(), "sns", ".ui.SnsTagDetailUI", intent2);
            } else if (longValue == 140737488355328L) {
                str3 = "com.tencent.mm.plugin.emoji.ui.EmojiMineUI";
            } else if (longValue == 281474976710656L) {
                by byVar = new by();
                byVar.cvf.cvh = "//uplog";
                byVar.cvf.context = ah.getContext();
                com.tencent.mm.sdk.b.a.xxA.m(byVar);
                AppMethodBeat.o(11675);
                return true;
            } else if (longValue == 562949953421312L) {
                intent2.putExtra("IPCallAddressUI_KFrom", 1);
                com.tencent.mm.bp.d.b(ah.getContext(), "ipcall", ".ui.IPCallAddressUI", intent2);
                com.tencent.mm.bp.d.b(ah.getContext(), "ipcall", ".ui.IPCallShareCouponUI", intent2);
                AppMethodBeat.o(11675);
                return true;
            } else if (longValue == 18014398509481984L) {
                intent2.putExtra("IPCallAddressUI_KFrom", 1);
                com.tencent.mm.bp.d.b(ah.getContext(), "ipcall", ".ui.IPCallAddressUI", intent2);
                com.tencent.mm.bp.d.b(ah.getContext(), "ipcall", ".ui.IPCallShareCouponUI", intent2);
                com.tencent.mm.bp.d.b(ah.getContext(), "ipcall", ".ui.IPCallShareCouponCardUI", intent2);
            } else if (longValue == 576460752303423488L) {
                intent2.putExtra("IPCallAddressUI_KFrom", 1);
                intent2.setClassName(ah.getContext(), "com.tencent.mm.plugin.sight.draft.ui.SightDraftUI");
                ah.getContext().startActivity(intent2);
            } else if (longValue == 1125899906842624L) {
                str3 = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI";
            } else if (longValue == 4503599627370496L) {
                intent2.putExtra("emoji_tab", 1);
                str3 = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI";
                com.tencent.mm.plugin.report.service.h.pYm.e(12065, Integer.valueOf(7));
            } else if (longValue == 9007199254740992L) {
                str3 = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI";
            } else if (longValue == 576460752303423489L) {
                parse2 = Uri.parse(str);
                String queryParameter2 = parse2.getQueryParameter("appid");
                str4 = parse2.getQueryParameter("userName");
                air = parse2.getQueryParameter("path");
                i3 = bo.getInt(bo.nullAsNil(parse2.getQueryParameter("pathType")), 0);
                String queryParameter3 = parse2.getQueryParameter("invokeData");
                substring = parse2.getQueryParameter("runtimeSessionId");
                encode2 = parse2.getQueryParameter("runtimeTicket");
                encode3 = parse2.getQueryParameter("runtimeAppid");
                i4 = 0;
                b y = v.Zp().y("key_data_center_session_id", false);
                if (y != null) {
                    i4 = ((Integer) y.get("key_launch_miniprogram_type", Integer.valueOf(0))).intValue();
                }
                ab.i("MicroMsg.DeepLinkHelper", "appid = %s, userName = %s, path = %s, translateLinkScene = %d, type = %d", queryParameter2, str4, air, Integer.valueOf(i), Integer.valueOf(i4));
                v.Zp().nV("key_data_center_session_id");
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.cst = URLEncoder.encode(str2);
                if (i == 2) {
                    appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_RUOZHU;
                    ((com.tencent.mm.plugin.appbrand.service.e) g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(context, str4, null, i4, 0, air, appBrandStatObject);
                } else if (i == 1) {
                    ab.d("MicroMsg.DeepLinkHelper", "pathType:%d invokeData:%s", Integer.valueOf(i3), queryParameter3);
                    if (i3 != 1 || bo.isNullOrNil(queryParameter3)) {
                        appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_SHUILAN;
                        appBrandStatObject.cst = queryParameter2;
                        ((com.tencent.mm.plugin.appbrand.service.e) g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(context, str4, null, i4, 0, air, appBrandStatObject, queryParameter2);
                    } else {
                        str3 = "";
                        try {
                            str3 = new com.tencent.mm.aa.i(queryParameter3).optString("name");
                        } catch (com.tencent.mm.aa.g e2) {
                            ab.printErrStackTrace("MicroMsg.DeepLinkHelper", e2, "", new Object[0]);
                        }
                        ab.i("MicroMsg.DeepLinkHelper", "runtimeSessionId:%s runtimeTicket:%s runtimeAppId:%s functionName:%s", substring, encode2, encode3, str3);
                        appBrandStatObject.scene = FaceManager.FACE_ACQUIRED_HACKER;
                        appBrandStatObject.cst = encode3 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str3;
                        ((com.tencent.mm.plugin.appbrand.service.e) g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(context, str4, i4, air, appBrandStatObject, queryParameter2, queryParameter3);
                    }
                } else if (i == 6) {
                    appBrandStatObject.scene = 1007;
                    ((com.tencent.mm.plugin.appbrand.service.e) g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(context, str4, null, i4, 0, air, appBrandStatObject);
                } else if (i == 7) {
                    appBrandStatObject.scene = 1008;
                    ((com.tencent.mm.plugin.appbrand.service.e) g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(context, str4, null, i4, 0, air, appBrandStatObject);
                } else {
                    appBrandStatObject.scene = 1000;
                    ((com.tencent.mm.plugin.appbrand.service.e) g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(context, str4, null, 0, 0, air, appBrandStatObject);
                }
                AppMethodBeat.o(11675);
                return true;
            } else if (longValue == 576460752303423490L) {
                str4 = Uri.parse(str).getQueryParameter("appid");
                Intent intent3 = new Intent();
                ab.d("MicroMsg.WalletManager", "start offline from sdk: %s", str4);
                intent3.putExtra("key_from_scene", 8);
                intent3.putExtra("key_appid", str4);
                com.tencent.mm.bp.d.b(context, "offline", ".ui.WalletOfflineEntranceUI", intent3, 0);
            }
            if (bo.isNullOrNil(str3)) {
                AppMethodBeat.o(11675);
                return false;
            }
            intent2.setClassName(ah.getContext(), str3);
            if (context != null) {
                try {
                    context.startActivity(intent2);
                } catch (Exception e3) {
                    ab.printErrStackTrace("MicroMsg.DeepLinkHelper", e3, "", "");
                }
            } else {
                ah.getContext().startActivity(intent2);
                com.tencent.mm.ui.base.b.K(ah.getContext(), intent2);
            }
            AppMethodBeat.o(11675);
            return true;
        } else if (air.startsWith("weixin://dl/businessTempSession/")) {
            intent = new Intent();
            intent.setFlags(268435456);
            Uri parse3 = Uri.parse(str);
            if (parse3 == null) {
                ab.e("MicroMsg.DeepLinkHelper", "tempsession uri is null");
                AppMethodBeat.o(11675);
                return false;
            }
            encode = parse3.getQueryParameter("sessionFrom");
            encode2 = parse3.getQueryParameter("showtype");
            str3 = parse3.getQueryParameter("username");
            if (bo.isNullOrNil(str3)) {
                queryParameter = parse3.getQueryParameter("userName");
            } else {
                queryParameter = str3;
            }
            if (bo.isNullOrNil(queryParameter)) {
                ab.e("MicroMsg.DeepLinkHelper", "tempsession user is null");
                AppMethodBeat.o(11675);
                return false;
            }
            h = bo.getInt(bo.nullAsNil(parse3.getQueryParameter("scene")), 0);
            if (h != 0 && i == 4) {
                ab.i("MicroMsg.DeepLinkHelper", "Jsapi assign scene to ".concat(String.valueOf(h)));
                i = h;
            }
            ab.i("MicroMsg.DeepLinkHelper", "tempsession jump, %s, %s, %s, %s, %s.", queryParameter, encode, Integer.valueOf(i), str, encode2);
            intent.setClassName(ah.getContext(), "com.tencent.mm.ui.chatting.ChattingUI");
            intent.putExtra("Chat_User", queryParameter);
            intent.putExtra("finish_direct", true);
            intent.putExtra("key_is_temp_session", true);
            intent.putExtra("key_temp_session_from", encode);
            intent.putExtra("key_temp_session_scene", i);
            intent.putExtra("key_temp_session_show_type", bo.getInt(encode2, 0));
            ad aoO = ((j) g.K(j.class)).XM().aoO(queryParameter);
            if (aoO == null || ((int) aoO.ewQ) <= 0) {
                final Context context2 = context;
                com.tencent.mm.model.ao.a.flu.a(queryParameter, "", new com.tencent.mm.model.ao.b.a() {
                    public final void o(String str, boolean z) {
                        AppMethodBeat.i(11657);
                        if (z) {
                            intent.putExtra("Chat_User", str);
                            try {
                                if (context2 != null) {
                                    context2.startActivity(intent);
                                    AppMethodBeat.o(11657);
                                    return;
                                }
                                ah.getContext().startActivity(intent);
                                AppMethodBeat.o(11657);
                                return;
                            } catch (Exception e) {
                                ab.printErrStackTrace("MicroMsg.DeepLinkHelper", e, "", "");
                                AppMethodBeat.o(11657);
                                return;
                            }
                        }
                        ab.e("MicroMsg.DeepLinkHelper", "getContact fail, %s", str);
                        AppMethodBeat.o(11657);
                    }
                });
            } else {
                context.startActivity(intent);
            }
            AppMethodBeat.o(11675);
            return true;
        } else if (air.startsWith("weixin://dl/businessGame/detail/") || air.startsWith("weixin://dl/businessGame/detail")) {
            ab.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith GAME_DETAIL");
            parse = Uri.parse(str);
            str3 = null;
            intent = new Intent();
            if (parse != null) {
                str3 = "com.tencent.mm.plugin.game.ui.GameDetailUI";
                intent.putExtra("game_app_id", parse.getQueryParameter("appid"));
                intent.putExtra("game_report_from_scene", 6);
            }
            if (bo.isNullOrNil(str3)) {
                AppMethodBeat.o(11675);
                return false;
            }
            intent.setClassName(ah.getContext(), str3);
            if (context != null) {
                try {
                    context.startActivity(intent);
                } catch (Exception e32) {
                    ab.printErrStackTrace("MicroMsg.DeepLinkHelper", e32, "", "");
                }
            } else {
                ah.getContext().startActivity(intent);
                com.tencent.mm.ui.base.b.K(ah.getContext(), intent);
            }
            AppMethodBeat.o(11675);
            return true;
        } else if (air.startsWith("weixin://dl/businessGame/library/") || air.startsWith("weixin://dl/businessGame/library")) {
            ab.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith GAME_LIBRARY");
            Intent intent4 = new Intent();
            queryParameter = "com.tencent.mm.plugin.game.ui.GameLibraryUI";
            if (bo.isNullOrNil(queryParameter)) {
                AppMethodBeat.o(11675);
                return false;
            }
            intent4.putExtra("game_report_from_scene", 6);
            intent4.setClassName(ah.getContext(), queryParameter);
            if (context != null) {
                try {
                    context.startActivity(intent4);
                } catch (Exception e322) {
                    ab.printErrStackTrace("MicroMsg.DeepLinkHelper", e322, "", "");
                }
            } else {
                ah.getContext().startActivity(intent4);
                com.tencent.mm.ui.base.b.K(ah.getContext(), intent4);
            }
            AppMethodBeat.o(11675);
            return true;
        } else if (air.startsWith("weixin://dl/businessWebview/link/") || air.startsWith("weixin://dl/businessWebview/link")) {
            ab.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith H5_LINK");
            parse = Uri.parse(str);
            intent = new Intent();
            str3 = null;
            if (parse != null) {
                substring = parse.getQueryParameter("url");
                i4 = bo.getInt(parse.getQueryParameter("type"), 0);
                encode2 = bo.nullAsNil(parse.getQueryParameter("appid"));
                i3 = bo.getInt(bo.nullAsNil(parse.getQueryParameter("outer")), 0);
                ab.i("MicroMsg.DeepLinkHelper", "gotoUri, rawUrl = %s, appId:%s, translateLinkScene: %s, outer:%d", substring, encode2, Integer.valueOf(i), Integer.valueOf(i3));
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
                    com.tencent.mm.pluginsdk.wallet.i.Lt(39);
                } else if (i == 2) {
                    if (i3 == 1) {
                        intent.putExtra("geta8key_open_webview_appid", encode2);
                        intent.putExtra("geta8key_scene", 52);
                    }
                    intent.putExtra("pay_channel", 39);
                    com.tencent.mm.pluginsdk.wallet.i.Lt(39);
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
            if (bo.isNullOrNil(str3)) {
                AppMethodBeat.o(11675);
                return false;
            }
            intent.setClassName(ah.getContext(), str3);
            if (context != null) {
                try {
                    context.startActivity(intent);
                } catch (Exception e3222) {
                    ab.printErrStackTrace("MicroMsg.DeepLinkHelper", e3222, "", "");
                }
            } else {
                ah.getContext().startActivity(intent);
                com.tencent.mm.ui.base.b.K(ah.getContext(), intent);
            }
            AppMethodBeat.o(11675);
            return true;
        } else if (air.startsWith("weixin://dl/openbusinesswebview/link/")) {
            ab.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith openbusinesswebview");
            parse = Uri.parse(str);
            intent = new Intent();
            str3 = null;
            if (parse != null) {
                substring = parse.getQueryParameter("url");
                i4 = bo.getInt(parse.getQueryParameter("type"), 0);
                queryParameter = bo.nullAsNil(parse.getQueryParameter("appid"));
                ab.i("MicroMsg.DeepLinkHelper", "gotoUri, rawUrl = %s, appId:%s, translateLinkScene: %s", substring, queryParameter, Integer.valueOf(i));
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
            if (bo.isNullOrNil(str3)) {
                AppMethodBeat.o(11675);
                return false;
            }
            intent.setClassName(ah.getContext(), str3);
            if (context != null) {
                try {
                    context.startActivity(intent);
                } catch (Exception e32222) {
                    ab.printErrStackTrace("MicroMsg.DeepLinkHelper", e32222, "", "");
                }
            } else {
                ah.getContext().startActivity(intent);
                com.tencent.mm.ui.base.b.K(ah.getContext(), intent);
            }
            AppMethodBeat.o(11675);
            return true;
        } else if (air.startsWith("weixin://dl/jumpFakeWxa/") || air.startsWith("weixin://dl/openNativeView/")) {
            parse2 = Uri.parse(str);
            str4 = parse2.getQueryParameter("appid");
            substring = parse2.getQueryParameter("businessType");
            encode = null;
            queryParameter = null;
            int i5 = 0;
            b y2 = v.Zp().y("key_data_center_session_id", false);
            if (y2 != null) {
                i5 = ((Integer) y2.get("key_launch_miniprogram_type", Integer.valueOf(0))).intValue();
                queryParameter = (String) y2.get("key_open_business_view_ext_info", "");
                encode = (String) y2.get("key_launch_miniprogram_query_info", "");
            }
            ab.i("MicroMsg.DeepLinkHelper", "appid = %s, translateLinkScene = %d, type = %d", str4, Integer.valueOf(i), Integer.valueOf(i5));
            v.Zp().nV("key_data_center_session_id");
            if (!air.startsWith("weixin://dl/jumpFakeWxa/")) {
                Object obj;
                com.tencent.mm.pluginsdk.b.a aVar = b.vaj;
                if (substring != null) {
                    switch (substring.hashCode()) {
                        case -1919727738:
                            if (substring.equals("nativeEmergencyContact")) {
                                a.f.b.j.p(substring, "businessType");
                                com.tencent.mm.pluginsdk.ui.tools.i.c(substring, "testExtMsg", str4, -3, "testErrMsg");
                                obj = 1;
                                break;
                            }
                        case 554520581:
                            if (substring.equals("nativeShareToHaokan")) {
                                a.f.b.j.p(substring, "businessType");
                                c.an(substring, str4, queryParameter);
                                obj = 1;
                                break;
                            }
                    }
                }
                obj = null;
                if (obj != null) {
                    AppMethodBeat.o(11675);
                    return true;
                }
                van = true;
                AppMethodBeat.o(11675);
                return false;
            } else if (i == 1) {
                ((com.tencent.mm.plugin.appbrand.service.e) g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(context, str4, substring, encode, i5);
                AppMethodBeat.o(11675);
                return true;
            } else {
                AppMethodBeat.o(11675);
                return false;
            }
        } else {
            AppMethodBeat.o(11675);
            return false;
        }
    }

    private static void ac(Context context, int i) {
        String string;
        AppMethodBeat.i(11677);
        if (!com.tencent.mm.sdk.platformtools.g.xyg && aa.dor().equals("zh_CN")) {
            string = context.getString(R.string.g0f);
        } else if (aa.dor().equals("zh_HK")) {
            string = context.getString(R.string.g0g);
        } else if (aa.dor().equals("zh_TW")) {
            string = context.getString(R.string.g0h);
        } else {
            string = context.getString(R.string.g0i);
        }
        ab.d("MicroMsg.DeepLinkHelper", "using faq webpage");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("show_feedback", false);
        intent.putExtra("KShowFixToolsBtn", true);
        intent.putExtra("geta8key_session_id", i);
        com.tencent.mm.bp.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(11677);
    }

    private static String air(String str) {
        AppMethodBeat.i(11678);
        String str2 = null;
        if (!bo.isNullOrNil(str)) {
            Uri parse = Uri.parse(str);
            str2 = parse.getScheme() + "://" + parse.getHost() + parse.getPath();
        }
        AppMethodBeat.o(11678);
        return str2;
    }

    public static void A(final Context context, String str, String str2) {
        AppMethodBeat.i(11679);
        if (aip(str2)) {
            AppMethodBeat.o(11679);
            return;
        }
        final p b = com.tencent.mm.ui.base.h.b(context, "", true, null);
        int i = 6;
        if (!bo.isNullOrNil(str)) {
            if (t.kH(str)) {
                i = 7;
            } else if (t.mZ(str)) {
                i = 9;
            }
        }
        a(context, str2, i, new a() {
            public final void a(int i, int i2, String str, m mVar, boolean z) {
                AppMethodBeat.i(11658);
                ab.i("MicroMsg.DeepLinkHelper", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                if (b != null && b.isShowing()) {
                    b.dismiss();
                }
                if (!(mVar == null || i == 0 || i2 == 0 || !(mVar instanceof z))) {
                    ciq ajE = ((z) mVar).ajE();
                    if (!(ajE == null || context == null)) {
                        com.tencent.mm.ui.base.t.makeText(context, context.getString(R.string.tz) + " : " + bo.nullAsNil(ajE.xhy), 0).show();
                    }
                }
                AppMethodBeat.o(11658);
            }
        });
        AppMethodBeat.o(11679);
    }

    public static void bu(Context context, String str) {
        AppMethodBeat.i(11680);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url is null. finish");
            AppMethodBeat.o(11680);
        } else if (str.startsWith("weixin://dl/login/phone_view")) {
            Uri parse = Uri.parse(str);
            ab.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI cc:%s num:%s", parse.getQueryParameter("cc"), parse.getQueryParameter("num"));
            Intent intent = new Intent();
            intent.putExtra("couttry_code", r1);
            intent.putExtra("input_mobile_number", r0);
            intent.putExtra("from_deep_link", true);
            intent.putExtra("mobile_input_purpose", 1);
            intent.addFlags(268435456);
            com.tencent.mm.bp.d.b(context, "account", ".ui.MobileInputUI", intent);
            AppMethodBeat.o(11680);
        } else if (str.startsWith("weixin://dl/login/common_view")) {
            ab.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI  username:%s", Uri.parse(str).getQueryParameter("username"));
            Intent intent2 = new Intent();
            intent2.putExtra("login_username", r0);
            intent2.putExtra("from_deep_link", true);
            intent2.addFlags(268435456);
            com.tencent.mm.bp.d.b(context, "account", ".ui.LoginUI", intent2);
            AppMethodBeat.o(11680);
        } else {
            ab.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url not Correct:%s", str);
            AppMethodBeat.o(11680);
        }
    }

    public static boolean aiq(String str) {
        AppMethodBeat.i(11672);
        boolean a = a(null, str, 0, null, (int) System.currentTimeMillis(), new byte[0], null);
        AppMethodBeat.o(11672);
        return a;
    }

    public static boolean a(Context context, String str, int i, Bundle bundle, String str2) {
        AppMethodBeat.i(11674);
        boolean a = a(context, str, i, bundle, (int) System.currentTimeMillis(), new byte[0], str2);
        AppMethodBeat.o(11674);
        return a;
    }

    public static void fC(Context context) {
        AppMethodBeat.i(11676);
        ac(context, (int) System.currentTimeMillis());
        AppMethodBeat.o(11676);
    }
}
