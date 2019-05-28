package com.tencent.p177mm.plugin.downloader.p943h;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.api.C45405b;
import com.tencent.p177mm.opensdk.constants.Build;
import com.tencent.p177mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.pluginsdk.model.app.C14875aj;
import com.tencent.p177mm.pluginsdk.model.app.C35800q;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.permission.C14900a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.downloader.h.a */
public final class C33913a {
    /* renamed from: a */
    public static void m55499a(long j, final boolean z, final C14900a c14900a) {
        AppMethodBeat.m2504i(2525);
        final C42911a hv = C2895c.m5147hv(j);
        if (hv != null && hv.field_status == 3 && C5730e.m8628ct(hv.field_filePath)) {
            C33913a.m55501a(hv.field_filePath, new C14900a() {
                /* renamed from: dT */
                public final void mo9734dT(boolean z) {
                    AppMethodBeat.m2504i(2522);
                    if (z) {
                        String str = hv.field_packageName;
                        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("install_begin_time", 0);
                        if (sharedPreferences != null) {
                            sharedPreferences.edit().putLong(str, System.currentTimeMillis()).apply();
                        }
                        C45405b.eBF.mo60569a(hv.field_appId, hv.field_scene, 4, hv.field_md5, hv.field_downloadUrl, null, hv.field_extInfo);
                        C45405b.eBF.mo60568a(hv.field_appId, hv.field_scene, 4, hv.field_startSize, hv.field_downloadedSize - hv.field_startSize, hv.field_totalSize, hv.field_downloadUrl, hv.field_errCode, hv.field_downloaderType, hv.field_channelId, (System.currentTimeMillis() - hv.field_startTime) / 1000, hv.field_startState, hv.field_downloadId, hv.field_extInfo, hv.field_reserveInWifi ? 1 : 0);
                        if (z) {
                            C45405b.eBF.mo60568a(hv.field_appId, hv.field_scene, 15, hv.field_startSize, hv.field_downloadedSize - hv.field_startSize, hv.field_totalSize, hv.field_downloadUrl, hv.field_errCode, hv.field_downloaderType, hv.field_channelId, (System.currentTimeMillis() - hv.field_startTime) / 1000, hv.field_startState, hv.field_downloadId, hv.field_extInfo, hv.field_reserveInWifi ? 1 : 0);
                        } else {
                            C45405b.eBF.mo60568a(hv.field_appId, hv.field_scene, 16, hv.field_startSize, hv.field_downloadedSize - hv.field_startSize, hv.field_totalSize, hv.field_downloadUrl, hv.field_errCode, hv.field_downloaderType, hv.field_channelId, (System.currentTimeMillis() - hv.field_startTime) / 1000, hv.field_startState, hv.field_downloadId, hv.field_extInfo, hv.field_reserveInWifi ? 1 : 0);
                        }
                    }
                    if (c14900a != null) {
                        c14900a.mo9734dT(z);
                    }
                    AppMethodBeat.m2505o(2522);
                }
            });
            AppMethodBeat.m2505o(2525);
            return;
        }
        if (c14900a != null) {
            c14900a.mo9734dT(false);
        }
        AppMethodBeat.m2505o(2525);
    }

    /* renamed from: a */
    public static void m55501a(String str, C14900a c14900a) {
        AppMethodBeat.m2504i(2526);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.DownloadAppUtil", "installApk, path is null");
            if (c14900a != null) {
                c14900a.mo9734dT(false);
            }
            AppMethodBeat.m2505o(2526);
            return;
        }
        C4990ab.m7416i("MicroMsg.DownloadAppUtil", "installApk, path = ".concat(String.valueOf(str)));
        if (C5730e.m8628ct(str)) {
            C35800q.m58698a(C4996ah.getContext(), new File(str), c14900a, true);
            AppMethodBeat.m2505o(2526);
            return;
        }
        C4990ab.m7412e("MicroMsg.DownloadAppUtil", "installApk, path not exists");
        if (c14900a != null) {
            c14900a.mo9734dT(false);
        }
        AppMethodBeat.m2505o(2526);
    }

    /* renamed from: a */
    public static void m55500a(final Context context, String str, final C14875aj c14875aj) {
        AppMethodBeat.m2504i(2527);
        String str2 = "WX_GameCenter";
        final C339162 c339162 = new C14875aj() {
            /* renamed from: dR */
            public final void mo6036dR(boolean z) {
                AppMethodBeat.m2504i(2523);
                if (c14875aj != null) {
                    c14875aj.mo6036dR(z);
                }
                AppMethodBeat.m2505o(2523);
            }
        };
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.DownloadAppUtil", "null or nil appid");
            c339162.mo6036dR(false);
        }
        final C40439f bT = C46494g.m87739bT(str, true);
        if (bT == null || C5046bo.isNullOrNil(bT.field_appId)) {
            C4990ab.m7412e("MicroMsg.DownloadAppUtil", "appinfo is null or appid is null");
            c339162.mo6036dR(false);
            AppMethodBeat.m2505o(2527);
            return;
        }
        final WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXAppExtendObject());
        wXMediaMessage.sdkVer = Build.SDK_INT;
        wXMediaMessage.messageAction = null;
        wXMediaMessage.messageExt = str2;
        C4990ab.m7411d("MicroMsg.DownloadAppUtil", "launch game app from wx: appid: [%s], appname:[%s], openid:[%s]", bT.field_appId, bT.field_appName, bT.field_openId);
        if (C5046bo.isNullOrNil(bT.field_openId)) {
            C4990ab.m7417i("MicroMsg.DownloadAppUtil", "open id is null or nil, try to get from server:[%s]", bT.field_appName);
            C34832a.bYL().mo9878wy(bT.field_appId);
        }
        C26006a.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(2524);
                C46494g.m87728a(context, bT.field_packageName, wXMediaMessage, bT.field_appId, bT.field_openId, 0, c339162, null);
                AppMethodBeat.m2505o(2524);
            }
        });
        AppMethodBeat.m2505o(2527);
    }
}
