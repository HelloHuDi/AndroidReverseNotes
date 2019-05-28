package com.tencent.p177mm.game.report;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.api.C37860c;
import com.tencent.p177mm.game.report.api.C45406d;
import com.tencent.p177mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.p177mm.game.report.p1382b.C26319a;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* renamed from: com.tencent.mm.game.report.b */
public final class C45407b extends C37860c {

    /* renamed from: com.tencent.mm.game.report.b$a */
    static class C41210a implements C37866a<GameWebPerformanceInfo, Bundle> {
        private C41210a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(59572);
            C45407b.m83612b((GameWebPerformanceInfo) obj);
            if (c18507c != null) {
                c18507c.mo5960ao(null);
            }
            AppMethodBeat.m2505o(59572);
        }
    }

    /* renamed from: a */
    public final void mo60578a(C45406d c45406d) {
        AppMethodBeat.m2504i(59573);
        C18488c.m28787a(c45406d);
        AppMethodBeat.m2505o(59573);
    }

    /* renamed from: a */
    public final void mo60579a(String str, String str2, int i, int i2, String str3, int i3) {
        AppMethodBeat.m2504i(59574);
        C4990ab.m7410d("MicroMsg.GameReportImpl", "rejectGameMsg, fromUserName = " + str + ", appId = " + str2 + ", msgType = " + i + ", scene = " + i2 + ", actionName = " + str3);
        if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7412e("MicroMsg.GameReportImpl", "rejectGameMsg fail, appId is null");
            AppMethodBeat.m2505o(59574);
            return;
        }
        C7060h.pYm.mo8381e(10546, str, str2, Integer.valueOf(i), C26319a.m41873Pv(), Integer.valueOf(i2), str3, Integer.valueOf(i3));
        AppMethodBeat.m2505o(59574);
    }

    /* renamed from: a */
    public final void mo60576a(Context context, String str, String str2, String str3, int i, String str4, int i2) {
        AppMethodBeat.m2504i(59575);
        C4990ab.m7410d("MicroMsg.GameReportImpl", "reportMsgClick, appId = " + str + ", pkgName = " + str2);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.GameReportImpl", "reportDelGameMsg fail, appId is null");
            AppMethodBeat.m2505o(59575);
            return;
        }
        if (context == null) {
            context = C4996ah.getContext();
        }
        C18488c.m28787a(C45406d.m83611b(10583, str, Integer.valueOf(C26319a.m41871F(context, str2)), C26319a.m41873Pv(), str3, Integer.valueOf(i), str4, Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(C26319a.getNetworkType(context))));
        AppMethodBeat.m2505o(59575);
    }

    /* renamed from: a */
    public final void mo60580a(String str, String str2, int i, int i2, String str3, long j, boolean z, String str4) {
        AppMethodBeat.m2504i(59576);
        C4990ab.m7410d("MicroMsg.GameReportImpl", "reportReadMsg, appId = ".concat(String.valueOf(str)));
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.GameReportImpl", "reportReadMsg fail, appId is null");
            AppMethodBeat.m2505o(59576);
            return;
        }
        String fa = C26319a.m41874fa(j);
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
        C4990ab.m7417i(str5, str6, objArr);
        C7060h c7060h = C7060h.pYm;
        objArr = new Object[8];
        objArr[0] = str;
        objArr[1] = fa;
        objArr[2] = str2;
        objArr[3] = Integer.valueOf(i);
        objArr[4] = str3;
        objArr[5] = Integer.valueOf(i2);
        objArr[6] = Integer.valueOf(z ? 1 : 0);
        objArr[7] = str4;
        c7060h.mo8381e(10532, objArr);
        AppMethodBeat.m2505o(59576);
    }

    /* renamed from: i */
    public final void mo60582i(String str, int i, int i2) {
        AppMethodBeat.m2504i(59577);
        C4990ab.m7410d("MicroMsg.GameReportImpl", "reportGameDetail, appId = " + str + ", scene = " + i);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.GameReportImpl", "reportGameDetail fail, appId is null");
            AppMethodBeat.m2505o(59577);
            return;
        }
        C7060h.pYm.mo8381e(10700, str, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(59577);
    }

    /* renamed from: m */
    public final void mo60584m(String str, String str2, String str3) {
        AppMethodBeat.m2504i(59578);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            C4990ab.m7412e("MicroMsg.GameReportImpl", "null open or null username");
            AppMethodBeat.m2505o(59578);
            return;
        }
        C7060h.pYm.mo8381e(10738, str, str2, str, str3);
        AppMethodBeat.m2505o(59578);
    }

    /* renamed from: j */
    public final void mo60583j(Context context, String str, String str2) {
        AppMethodBeat.m2504i(59579);
        C4990ab.m7410d("MicroMsg.GameReportImpl", "reportRegToWx, appId = " + str + ", pkgName = " + str2);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.GameReportImpl", "reportRegToWx fail, appId is null");
            AppMethodBeat.m2505o(59579);
            return;
        }
        C7060h.pYm.mo8381e(10534, str, Integer.valueOf(C26319a.m41871F(context, str2)), C26319a.m41873Pv(), Long.valueOf(System.currentTimeMillis() / 1000));
        AppMethodBeat.m2505o(59579);
    }

    /* renamed from: a */
    public final void mo60575a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, long j, String str5, String str6) {
        AppMethodBeat.m2504i(59580);
        C4990ab.m7411d("MicroMsg.GameReportImpl", "reportMsgClick 10531, appId = %s, pkgName = %s, msgSvrId:%d, snsOgjId:%s", str, str2, Long.valueOf(j), str5);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.GameReportImpl", "reportMsgClick fail, appId is null");
            AppMethodBeat.m2505o(59580);
            return;
        }
        if (context == null) {
            context = C4996ah.getContext();
        }
        C40439f bT = C46494g.m87739bT(str, false);
        if (bT == null) {
            C4990ab.m7412e("MicroMsg.GameReportImpl", "reportMsgClick fail, appinfo is null");
            AppMethodBeat.m2505o(59580);
            return;
        }
        Object[] objArr = new Object[17];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(C26319a.m41871F(context, str2));
        objArr[2] = C26319a.m41873Pv();
        objArr[3] = str3;
        objArr[4] = Integer.valueOf(i);
        objArr[5] = str4;
        objArr[6] = Integer.valueOf(i2);
        objArr[7] = Integer.valueOf(i3);
        objArr[8] = Integer.valueOf(C26319a.getNetworkType(context));
        objArr[9] = C5046bo.nullAsNil(bT.field_packageName);
        objArr[10] = C5046bo.nullAsNil(bT.field_signature);
        objArr[11] = Long.toString(j);
        objArr[12] = "";
        objArr[13] = str5;
        objArr[14] = "";
        objArr[15] = Integer.valueOf(bT.mo63847xy() ? 1 : 0);
        objArr[16] = str6;
        C45406d b = C45406d.m83611b(10531, objArr);
        C4990ab.m7416i("MicroMsg.reportMsgClick", b.eBI);
        C18488c.m28787a(b);
        AppMethodBeat.m2505o(59580);
    }

    /* renamed from: a */
    public final void mo60577a(GameWebPerformanceInfo gameWebPerformanceInfo) {
        AppMethodBeat.m2504i(59581);
        if (gameWebPerformanceInfo == null || C5046bo.isNullOrNil(gameWebPerformanceInfo.url)) {
            C4990ab.m7412e("MicroMsg.GameReportImpl", "info is null");
            AppMethodBeat.m2505o(59581);
        } else if (C4996ah.bqo()) {
            C45407b.m83612b(gameWebPerformanceInfo);
            AppMethodBeat.m2505o(59581);
        } else {
            C9549f.m17012a("com.tencent.mm", gameWebPerformanceInfo, C41210a.class, null);
            AppMethodBeat.m2505o(59581);
        }
    }

    /* renamed from: g */
    public final void mo60581g(int i, String str, String str2) {
        AppMethodBeat.m2504i(59582);
        C7060h.pYm.mo8381e(16171, Integer.valueOf(0), Integer.valueOf(i), str, str2, Long.valueOf(0));
        AppMethodBeat.m2505o(59582);
    }

    /* renamed from: b */
    static void m83612b(GameWebPerformanceInfo gameWebPerformanceInfo) {
        int i;
        AppMethodBeat.m2504i(59583);
        C4990ab.m7417i("MicroMsg.GameReportImpl", "reportWebPerformanceInMM, %s", gameWebPerformanceInfo.toString());
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
        C4990ab.m7417i("MicroMsg.GameReportImpl", "url : %s, pkgId: %s, isLuggage : %d, isWePkg: %d, isPreloadWePkg: %d, isPreloadWebCore: %d, hasLoadFinished: %d, gameCenterUICreate: %d, startWebUI: %d,preloadWePkgBgn: %d, preloadWePkgEnd: %d, preloadWebCoreBgn: %d, preloadWebCoreEnd: %d,webUICreate: %d, webUIOnshowBgn: %d, createViewBgn: %d, createViewEnd: %d, jsbridgeInject: %d, loadUrlBgn: %d, onPageStarted: %d, onPageFinished: %d, getA8keyBgn: %d, getA8keyEnd: %d, webUIInfront: %d,webUIDestroy: %d", gameWebPerformanceInfo.url, gameWebPerformanceInfo.eBS, Integer.valueOf(gameWebPerformanceInfo.eBK), Integer.valueOf(gameWebPerformanceInfo.eBL), Integer.valueOf(i), Integer.valueOf(gameWebPerformanceInfo.eBM), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j8), Long.valueOf(j9), Long.valueOf(j10), Long.valueOf(j11), Long.valueOf(j12), Long.valueOf(j13), Long.valueOf(j14), Long.valueOf(j15), Long.valueOf(j16), Long.valueOf(gameWebPerformanceInfo.eCj), Long.valueOf(j17));
        String str = "";
        try {
            str = URLEncoder.encode(gameWebPerformanceInfo.url, ProtocolPackage.ServerEncoding);
        } catch (UnsupportedEncodingException e) {
        }
        C7060h.pYm.mo8381e(16141, str, Integer.valueOf(gameWebPerformanceInfo.eBK), Integer.valueOf(gameWebPerformanceInfo.eBL), Integer.valueOf(i), Integer.valueOf(gameWebPerformanceInfo.eBM), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j8), Long.valueOf(j9), Long.valueOf(j10), Long.valueOf(j11), Long.valueOf(j12), Long.valueOf(j13), Long.valueOf(j14), Long.valueOf(j15), Long.valueOf(j16), Long.valueOf(gameWebPerformanceInfo.eCj), Long.valueOf(j17), Integer.valueOf(i2), gameWebPerformanceInfo.eBS, Integer.valueOf(gameWebPerformanceInfo.eBN), gameWebPerformanceInfo.eBJ, C5023at.m7471gB(C4996ah.getContext()), Integer.valueOf(gameWebPerformanceInfo.eBQ), Integer.valueOf(gameWebPerformanceInfo.eBO), Integer.valueOf(gameWebPerformanceInfo.eBR), gameWebPerformanceInfo.eCn, gameWebPerformanceInfo.eCo);
        if (i2 == 1) {
            if (gameWebPerformanceInfo.eBQ == 0) {
                C7060h.pYm.mo15419k(949, 4, 1);
            }
            if (gameWebPerformanceInfo.eCi == -1) {
                C7060h.pYm.mo15419k(949, 7, 1);
                AppMethodBeat.m2505o(59583);
                return;
            }
        } else if (gameWebPerformanceInfo.eBL == 1) {
            C7060h.pYm.mo15419k(949, 5, 1);
            AppMethodBeat.m2505o(59583);
            return;
        } else {
            C7060h.pYm.mo15419k(949, 6, 1);
        }
        AppMethodBeat.m2505o(59583);
    }
}
