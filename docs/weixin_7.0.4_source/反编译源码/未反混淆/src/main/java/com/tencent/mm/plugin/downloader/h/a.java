package com.tencent.mm.plugin.downloader.h;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.pluginsdk.model.app.aj;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.File;

public final class a {
    public static void a(long j, final boolean z, final com.tencent.mm.pluginsdk.permission.a aVar) {
        AppMethodBeat.i(2525);
        final com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv != null && hv.field_status == 3 && e.ct(hv.field_filePath)) {
            a(hv.field_filePath, new com.tencent.mm.pluginsdk.permission.a() {
                public final void dT(boolean z) {
                    AppMethodBeat.i(2522);
                    if (z) {
                        String str = hv.field_packageName;
                        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("install_begin_time", 0);
                        if (sharedPreferences != null) {
                            sharedPreferences.edit().putLong(str, System.currentTimeMillis()).apply();
                        }
                        b.eBF.a(hv.field_appId, hv.field_scene, 4, hv.field_md5, hv.field_downloadUrl, null, hv.field_extInfo);
                        b.eBF.a(hv.field_appId, hv.field_scene, 4, hv.field_startSize, hv.field_downloadedSize - hv.field_startSize, hv.field_totalSize, hv.field_downloadUrl, hv.field_errCode, hv.field_downloaderType, hv.field_channelId, (System.currentTimeMillis() - hv.field_startTime) / 1000, hv.field_startState, hv.field_downloadId, hv.field_extInfo, hv.field_reserveInWifi ? 1 : 0);
                        if (z) {
                            b.eBF.a(hv.field_appId, hv.field_scene, 15, hv.field_startSize, hv.field_downloadedSize - hv.field_startSize, hv.field_totalSize, hv.field_downloadUrl, hv.field_errCode, hv.field_downloaderType, hv.field_channelId, (System.currentTimeMillis() - hv.field_startTime) / 1000, hv.field_startState, hv.field_downloadId, hv.field_extInfo, hv.field_reserveInWifi ? 1 : 0);
                        } else {
                            b.eBF.a(hv.field_appId, hv.field_scene, 16, hv.field_startSize, hv.field_downloadedSize - hv.field_startSize, hv.field_totalSize, hv.field_downloadUrl, hv.field_errCode, hv.field_downloaderType, hv.field_channelId, (System.currentTimeMillis() - hv.field_startTime) / 1000, hv.field_startState, hv.field_downloadId, hv.field_extInfo, hv.field_reserveInWifi ? 1 : 0);
                        }
                    }
                    if (aVar != null) {
                        aVar.dT(z);
                    }
                    AppMethodBeat.o(2522);
                }
            });
            AppMethodBeat.o(2525);
            return;
        }
        if (aVar != null) {
            aVar.dT(false);
        }
        AppMethodBeat.o(2525);
    }

    public static void a(String str, com.tencent.mm.pluginsdk.permission.a aVar) {
        AppMethodBeat.i(2526);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.DownloadAppUtil", "installApk, path is null");
            if (aVar != null) {
                aVar.dT(false);
            }
            AppMethodBeat.o(2526);
            return;
        }
        ab.i("MicroMsg.DownloadAppUtil", "installApk, path = ".concat(String.valueOf(str)));
        if (e.ct(str)) {
            q.a(ah.getContext(), new File(str), aVar, true);
            AppMethodBeat.o(2526);
            return;
        }
        ab.e("MicroMsg.DownloadAppUtil", "installApk, path not exists");
        if (aVar != null) {
            aVar.dT(false);
        }
        AppMethodBeat.o(2526);
    }

    public static void a(final Context context, String str, final aj ajVar) {
        AppMethodBeat.i(2527);
        String str2 = "WX_GameCenter";
        final AnonymousClass2 anonymousClass2 = new aj() {
            public final void dR(boolean z) {
                AppMethodBeat.i(2523);
                if (ajVar != null) {
                    ajVar.dR(z);
                }
                AppMethodBeat.o(2523);
            }
        };
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.DownloadAppUtil", "null or nil appid");
            anonymousClass2.dR(false);
        }
        final f bT = g.bT(str, true);
        if (bT == null || bo.isNullOrNil(bT.field_appId)) {
            ab.e("MicroMsg.DownloadAppUtil", "appinfo is null or appid is null");
            anonymousClass2.dR(false);
            AppMethodBeat.o(2527);
            return;
        }
        final WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXAppExtendObject());
        wXMediaMessage.sdkVer = Build.SDK_INT;
        wXMediaMessage.messageAction = null;
        wXMediaMessage.messageExt = str2;
        ab.d("MicroMsg.DownloadAppUtil", "launch game app from wx: appid: [%s], appname:[%s], openid:[%s]", bT.field_appId, bT.field_appName, bT.field_openId);
        if (bo.isNullOrNil(bT.field_openId)) {
            ab.i("MicroMsg.DownloadAppUtil", "open id is null or nil, try to get from server:[%s]", bT.field_appName);
            com.tencent.mm.plugin.s.a.bYL().wy(bT.field_appId);
        }
        com.tencent.mm.ce.a.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(2524);
                g.a(context, bT.field_packageName, wXMediaMessage, bT.field_appId, bT.field_openId, 0, anonymousClass2, null);
                AppMethodBeat.o(2524);
            }
        });
        AppMethodBeat.o(2527);
    }
}
