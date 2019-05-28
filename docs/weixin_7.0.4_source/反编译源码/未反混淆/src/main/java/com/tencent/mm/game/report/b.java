package com.tencent.mm.game.report;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.game.report.api.c;
import com.tencent.mm.game.report.api.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class b extends c {

    static class a implements com.tencent.mm.ipcinvoker.a<GameWebPerformanceInfo, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(59572);
            b.b((GameWebPerformanceInfo) obj);
            if (cVar != null) {
                cVar.ao(null);
            }
            AppMethodBeat.o(59572);
        }
    }

    public final void a(d dVar) {
        AppMethodBeat.i(59573);
        c.a(dVar);
        AppMethodBeat.o(59573);
    }

    public final void a(String str, String str2, int i, int i2, String str3, int i3) {
        AppMethodBeat.i(59574);
        ab.d("MicroMsg.GameReportImpl", "rejectGameMsg, fromUserName = " + str + ", appId = " + str2 + ", msgType = " + i + ", scene = " + i2 + ", actionName = " + str3);
        if (bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.GameReportImpl", "rejectGameMsg fail, appId is null");
            AppMethodBeat.o(59574);
            return;
        }
        h.pYm.e(10546, str, str2, Integer.valueOf(i), com.tencent.mm.game.report.b.a.Pv(), Integer.valueOf(i2), str3, Integer.valueOf(i3));
        AppMethodBeat.o(59574);
    }

    public final void a(Context context, String str, String str2, String str3, int i, String str4, int i2) {
        AppMethodBeat.i(59575);
        ab.d("MicroMsg.GameReportImpl", "reportMsgClick, appId = " + str + ", pkgName = " + str2);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.GameReportImpl", "reportDelGameMsg fail, appId is null");
            AppMethodBeat.o(59575);
            return;
        }
        if (context == null) {
            context = ah.getContext();
        }
        c.a(d.b(10583, str, Integer.valueOf(com.tencent.mm.game.report.b.a.F(context, str2)), com.tencent.mm.game.report.b.a.Pv(), str3, Integer.valueOf(i), str4, Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(com.tencent.mm.game.report.b.a.getNetworkType(context))));
        AppMethodBeat.o(59575);
    }

    public final void a(String str, String str2, int i, int i2, String str3, long j, boolean z, String str4) {
        AppMethodBeat.i(59576);
        ab.d("MicroMsg.GameReportImpl", "reportReadMsg, appId = ".concat(String.valueOf(str)));
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.GameReportImpl", "reportReadMsg fail, appId is null");
            AppMethodBeat.o(59576);
            return;
        }
        String fa = com.tencent.mm.game.report.b.a.fa(j);
        String str5 = "MicroMsg.reportReadMsg";
        String str6 = "%s,%s,%s,%s,%s,%s,%s,%s";
        Object[] objArr = new Object[8];
        objArr[0] = str;
        objArr[1] = fa;
        objArr[2] = str2;
        objArr[3] = Integer.valueOf(i);
        objArr[4] = str3;
        objArr[5] = Integer.valueOf(i2);
        objArr[6] = Integer.valueOf(z ? 1 : 0);
        objArr[7] = str4;
        ab.i(str5, str6, objArr);
        h hVar = h.pYm;
        objArr = new Object[8];
        objArr[0] = str;
        objArr[1] = fa;
        objArr[2] = str2;
        objArr[3] = Integer.valueOf(i);
        objArr[4] = str3;
        objArr[5] = Integer.valueOf(i2);
        objArr[6] = Integer.valueOf(z ? 1 : 0);
        objArr[7] = str4;
        hVar.e(10532, objArr);
        AppMethodBeat.o(59576);
    }

    public final void i(String str, int i, int i2) {
        AppMethodBeat.i(59577);
        ab.d("MicroMsg.GameReportImpl", "reportGameDetail, appId = " + str + ", scene = " + i);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.GameReportImpl", "reportGameDetail fail, appId is null");
            AppMethodBeat.o(59577);
            return;
        }
        h.pYm.e(10700, str, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(59577);
    }

    public final void m(String str, String str2, String str3) {
        AppMethodBeat.i(59578);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.GameReportImpl", "null open or null username");
            AppMethodBeat.o(59578);
            return;
        }
        h.pYm.e(10738, str, str2, str, str3);
        AppMethodBeat.o(59578);
    }

    public final void j(Context context, String str, String str2) {
        AppMethodBeat.i(59579);
        ab.d("MicroMsg.GameReportImpl", "reportRegToWx, appId = " + str + ", pkgName = " + str2);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.GameReportImpl", "reportRegToWx fail, appId is null");
            AppMethodBeat.o(59579);
            return;
        }
        h.pYm.e(10534, str, Integer.valueOf(com.tencent.mm.game.report.b.a.F(context, str2)), com.tencent.mm.game.report.b.a.Pv(), Long.valueOf(System.currentTimeMillis() / 1000));
        AppMethodBeat.o(59579);
    }

    public final void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, long j, String str5, String str6) {
        AppMethodBeat.i(59580);
        ab.d("MicroMsg.GameReportImpl", "reportMsgClick 10531, appId = %s, pkgName = %s, msgSvrId:%d, snsOgjId:%s", str, str2, Long.valueOf(j), str5);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.GameReportImpl", "reportMsgClick fail, appId is null");
            AppMethodBeat.o(59580);
            return;
        }
        if (context == null) {
            context = ah.getContext();
        }
        f bT = g.bT(str, false);
        if (bT == null) {
            ab.e("MicroMsg.GameReportImpl", "reportMsgClick fail, appinfo is null");
            AppMethodBeat.o(59580);
            return;
        }
        Object[] objArr = new Object[17];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(com.tencent.mm.game.report.b.a.F(context, str2));
        objArr[2] = com.tencent.mm.game.report.b.a.Pv();
        objArr[3] = str3;
        objArr[4] = Integer.valueOf(i);
        objArr[5] = str4;
        objArr[6] = Integer.valueOf(i2);
        objArr[7] = Integer.valueOf(i3);
        objArr[8] = Integer.valueOf(com.tencent.mm.game.report.b.a.getNetworkType(context));
        objArr[9] = bo.nullAsNil(bT.field_packageName);
        objArr[10] = bo.nullAsNil(bT.field_signature);
        objArr[11] = Long.toString(j);
        objArr[12] = "";
        objArr[13] = str5;
        objArr[14] = "";
        objArr[15] = Integer.valueOf(bT.xy() ? 1 : 0);
        objArr[16] = str6;
        d b = d.b(10531, objArr);
        ab.i("MicroMsg.reportMsgClick", b.eBI);
        c.a(b);
        AppMethodBeat.o(59580);
    }

    public final void a(GameWebPerformanceInfo gameWebPerformanceInfo) {
        AppMethodBeat.i(59581);
        if (gameWebPerformanceInfo == null || bo.isNullOrNil(gameWebPerformanceInfo.url)) {
            ab.e("MicroMsg.GameReportImpl", "info is null");
            AppMethodBeat.o(59581);
        } else if (ah.bqo()) {
            b(gameWebPerformanceInfo);
            AppMethodBeat.o(59581);
        } else {
            com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", gameWebPerformanceInfo, a.class, null);
            AppMethodBeat.o(59581);
        }
    }

    public final void g(int i, String str, String str2) {
        AppMethodBeat.i(59582);
        h.pYm.e(16171, Integer.valueOf(0), Integer.valueOf(i), str, str2, Long.valueOf(0));
        AppMethodBeat.o(59582);
    }

    static void b(GameWebPerformanceInfo gameWebPerformanceInfo) {
        int i;
        AppMethodBeat.i(59583);
        ab.i("MicroMsg.GameReportImpl", "reportWebPerformanceInMM, %s", gameWebPerformanceInfo.toString());
        long j = gameWebPerformanceInfo.eBT - gameWebPerformanceInfo.startTime > 0 ? gameWebPerformanceInfo.eBT - gameWebPerformanceInfo.startTime : 0;
        long j2 = gameWebPerformanceInfo.eBU - gameWebPerformanceInfo.startTime;
        if (gameWebPerformanceInfo.eBV > 0) {
            i = 1;
        } else {
            i = 0;
        }
        long j3 = 0;
        long j4 = 0;
        if (i == 1) {
            j3 = gameWebPerformanceInfo.eBV - gameWebPerformanceInfo.startTime;
            j4 = gameWebPerformanceInfo.eBW - gameWebPerformanceInfo.startTime;
        }
        long j5 = 0;
        long j6 = 0;
        if (gameWebPerformanceInfo.eBM == 1) {
            j5 = gameWebPerformanceInfo.eBX - gameWebPerformanceInfo.startTime;
            j6 = gameWebPerformanceInfo.eBY - gameWebPerformanceInfo.startTime;
        }
        long j7 = gameWebPerformanceInfo.eBZ - gameWebPerformanceInfo.startTime;
        long j8 = gameWebPerformanceInfo.eCa - gameWebPerformanceInfo.startTime;
        long j9 = gameWebPerformanceInfo.eCb - gameWebPerformanceInfo.startTime;
        long j10 = gameWebPerformanceInfo.eCc - gameWebPerformanceInfo.startTime;
        long j11 = 0;
        if (gameWebPerformanceInfo.eCd != 0) {
            j11 = gameWebPerformanceInfo.eCd - gameWebPerformanceInfo.startTime;
            if (gameWebPerformanceInfo.eBM == 0 && j11 < 0) {
                j11 = -1;
            }
        }
        long j12 = gameWebPerformanceInfo.eCe - gameWebPerformanceInfo.startTime;
        long j13 = gameWebPerformanceInfo.eCf - gameWebPerformanceInfo.startTime;
        if (gameWebPerformanceInfo.eBM == 0 && j13 <= 0) {
            j13 = -1;
        }
        int i2 = gameWebPerformanceInfo.eCg > 0 ? 1 : 0;
        long j14 = gameWebPerformanceInfo.eCg - gameWebPerformanceInfo.startTime;
        if (i2 == 0 || (gameWebPerformanceInfo.eBM == 0 && j14 <= 0)) {
            j14 = -1;
        }
        long j15 = 0;
        long j16 = 0;
        if (gameWebPerformanceInfo.eBO == 0) {
            j15 = gameWebPerformanceInfo.eCh - gameWebPerformanceInfo.startTime;
            if (j15 <= 0) {
                j15 = -1;
            }
            j16 = gameWebPerformanceInfo.eCi - gameWebPerformanceInfo.startTime;
            if (j16 <= 0) {
                j16 = -1;
            }
        }
        long j17 = gameWebPerformanceInfo.eCk - gameWebPerformanceInfo.startTime;
        ab.i("MicroMsg.GameReportImpl", "url : %s, pkgId: %s, isLuggage : %d, isWePkg: %d, isPreloadWePkg: %d, isPreloadWebCore: %d, hasLoadFinished: %d, gameCenterUICreate: %d, startWebUI: %d,preloadWePkgBgn: %d, preloadWePkgEnd: %d, preloadWebCoreBgn: %d, preloadWebCoreEnd: %d,webUICreate: %d, webUIOnshowBgn: %d, createViewBgn: %d, createViewEnd: %d, jsbridgeInject: %d, loadUrlBgn: %d, onPageStarted: %d, onPageFinished: %d, getA8keyBgn: %d, getA8keyEnd: %d, webUIInfront: %d,webUIDestroy: %d", gameWebPerformanceInfo.url, gameWebPerformanceInfo.eBS, Integer.valueOf(gameWebPerformanceInfo.eBK), Integer.valueOf(gameWebPerformanceInfo.eBL), Integer.valueOf(i), Integer.valueOf(gameWebPerformanceInfo.eBM), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j8), Long.valueOf(j9), Long.valueOf(j10), Long.valueOf(j11), Long.valueOf(j12), Long.valueOf(j13), Long.valueOf(j14), Long.valueOf(j15), Long.valueOf(j16), Long.valueOf(gameWebPerformanceInfo.eCj), Long.valueOf(j17));
        String str = "";
        try {
            str = URLEncoder.encode(gameWebPerformanceInfo.url, ProtocolPackage.ServerEncoding);
        } catch (UnsupportedEncodingException e) {
        }
        h.pYm.e(16141, str, Integer.valueOf(gameWebPerformanceInfo.eBK), Integer.valueOf(gameWebPerformanceInfo.eBL), Integer.valueOf(i), Integer.valueOf(gameWebPerformanceInfo.eBM), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j8), Long.valueOf(j9), Long.valueOf(j10), Long.valueOf(j11), Long.valueOf(j12), Long.valueOf(j13), Long.valueOf(j14), Long.valueOf(j15), Long.valueOf(j16), Long.valueOf(gameWebPerformanceInfo.eCj), Long.valueOf(j17), Integer.valueOf(i2), gameWebPerformanceInfo.eBS, Integer.valueOf(gameWebPerformanceInfo.eBN), gameWebPerformanceInfo.eBJ, at.gB(ah.getContext()), Integer.valueOf(gameWebPerformanceInfo.eBQ), Integer.valueOf(gameWebPerformanceInfo.eBO), Integer.valueOf(gameWebPerformanceInfo.eBR), gameWebPerformanceInfo.eCn, gameWebPerformanceInfo.eCo);
        if (i2 == 1) {
            if (gameWebPerformanceInfo.eBQ == 0) {
                h.pYm.k(949, 4, 1);
            }
            if (gameWebPerformanceInfo.eCi == -1) {
                h.pYm.k(949, 7, 1);
                AppMethodBeat.o(59583);
                return;
            }
        } else if (gameWebPerformanceInfo.eBL == 1) {
            h.pYm.k(949, 5, 1);
            AppMethodBeat.o(59583);
            return;
        } else {
            h.pYm.k(949, 6, 1);
        }
        AppMethodBeat.o(59583);
    }
}
