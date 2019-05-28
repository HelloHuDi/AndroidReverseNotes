package com.tencent.p177mm.plugin.appbrand.dynamic.p289j;

import android.os.Bundle;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.loader.C32473a;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.plugin.appbrand.appcache.C38104an;
import com.tencent.p177mm.plugin.appbrand.appcache.C45512ao;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42367l;
import com.tencent.p177mm.plugin.appbrand.dynamic.C10211f.C10213a;
import com.tencent.p177mm.plugin.appbrand.dynamic.C33164i;
import com.tencent.p177mm.plugin.appbrand.dynamic.C45548k;
import com.tencent.p177mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.p177mm.plugin.appbrand.p328r.C45672d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.sdk.p1574f.C44216b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.xweb.C31147o;
import java.io.Closeable;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.j.c */
public final class C2151c {
    private static final String[] gTT = C38104an.gTT;

    /* renamed from: bO */
    private static C31147o m4360bO(String str, String str2) {
        Throwable e;
        AppMethodBeat.m2504i(10997);
        Closeable c45512ao;
        Closeable xy;
        try {
            c45512ao = new C45512ao(str);
            try {
                c45512ao.avW();
                xy = c45512ao.mo73324xy(str2);
            } catch (Exception e2) {
                e = e2;
                xy = null;
            }
            try {
                C5046bo.m7527b(c45512ao);
                C31147o c31147o = new C31147o(C44216b.ako(str2), "UTF-8", xy);
                AppMethodBeat.m2505o(10997);
                return c31147o;
            } catch (Exception e3) {
                e = e3;
                C4990ab.m7413e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile with pkgPath(%s), exp = %s", str, C5046bo.m7574l(e));
                C5046bo.m7527b(c45512ao);
                C5046bo.m7527b(xy);
                AppMethodBeat.m2505o(10997);
                return null;
            }
        } catch (Exception e4) {
            e = e4;
            xy = null;
            c45512ao = null;
            C4990ab.m7413e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile with pkgPath(%s), exp = %s", str, C5046bo.m7574l(e));
            C5046bo.m7527b(c45512ao);
            C5046bo.m7527b(xy);
            AppMethodBeat.m2505o(10997);
            return null;
        }
    }

    /* renamed from: bR */
    public static String m4363bR(String str, String str2) {
        AppMethodBeat.m2504i(CdnLogic.kMediaTypeExposeImage);
        String str3;
        if (C5046bo.isNullOrNil(str2)) {
            str3 = "";
            AppMethodBeat.m2505o(CdnLogic.kMediaTypeExposeImage);
            return str3;
        }
        C31147o bS = C2151c.m4364bS(str, str2);
        if (bS == null || bS.mInputStream == null) {
            C4990ab.m7413e("MicroMsg.ResPkgReader", "get cache content for id : %s from url : %s, failed", str, str2);
            str3 = "";
            AppMethodBeat.m2505o(CdnLogic.kMediaTypeExposeImage);
            return str3;
        }
        try {
            C4990ab.m7411d("MicroMsg.ResPkgReader", "getCacheContent, dataStream available = %d, url = %s", Integer.valueOf(bS.mInputStream.available()), str2);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ResPkgReader", "getCacheContent exp = %s, id = %s, url = %s", e, str, str2);
        }
        str3 = C45672d.convertStreamToString(bS.mInputStream);
        AppMethodBeat.m2505o(CdnLogic.kMediaTypeExposeImage);
        return str3;
    }

    /* renamed from: bS */
    public static C31147o m4364bS(String str, String str2) {
        AppMethodBeat.m2504i(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS);
        C4990ab.m7417i("MicroMsg.ResPkgReader", "getCacheResource called, id = %s, reqURL = %s", str, str2);
        if (C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS);
            return null;
        } else if (C30152u.m47751t(str2, "about:blank")) {
            AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS);
            return null;
        } else if (C45672d.m84372Ed(str2)) {
            AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS);
            return null;
        } else {
            Object yk = C42367l.m74946yk(str2);
            if (C32473a.contains(gTT, yk)) {
                C31147o bQ = C2151c.m4362bQ(str, yk);
                AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS);
                return bQ;
            }
            C31147o bP = C2151c.m4361bP(str, yk);
            if (bP == null) {
                Bundle bundle = new Bundle();
                bundle.putString("id", str);
                bundle.putInt("widgetState", TXLiveConstants.PLAY_WARNING_AUDIO_DECODE_FAIL);
                C9549f.m17012a(C33164i.azC().mo53694zV(str), bundle, C10213a.class, null);
            }
            AppMethodBeat.m2505o(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS);
            return bP;
        }
    }

    /* renamed from: bP */
    private static C31147o m4361bP(String str, String str2) {
        WxaPkgWrappingInfo azF;
        AppMethodBeat.m2504i(10998);
        WxaWidgetContext Aa = C45548k.m83998Aa(str);
        if (Aa != null) {
            azF = Aa.azF();
        } else {
            azF = null;
        }
        if (azF == null) {
            C4990ab.m7413e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get null appInfo by id %s", str);
            AppMethodBeat.m2505o(10998);
            return null;
        } else if (C5046bo.isNullOrNil(azF.gSP)) {
            C4990ab.m7413e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get Null Or Nil pkgPath[%s] by appId %s", azF.gSP, str);
            AppMethodBeat.m2505o(10998);
            return null;
        } else {
            String str3 = azF.gSP;
            if (C5046bo.isNullOrNil(str3)) {
                C4990ab.m7412e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get null or nil pkgLocalPath");
                AppMethodBeat.m2505o(10998);
                return null;
            }
            C4990ab.m7411d("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, id(%s), fileName(%s)", str, str2);
            C31147o bO = C2151c.m4360bO(str3, str2);
            AppMethodBeat.m2505o(10998);
            return bO;
        }
    }

    /* renamed from: bQ */
    private static C31147o m4362bQ(String str, String str2) {
        WxaPkgWrappingInfo azG;
        AppMethodBeat.m2504i(10999);
        WxaWidgetContext Aa = C45548k.m83998Aa(str);
        if (Aa != null) {
            azG = Aa.azG();
        } else {
            azG = null;
        }
        C31147o c31147o;
        if (azG == null) {
            AppMethodBeat.m2505o(10999);
            return null;
        } else if (azG.gVw) {
            InputStream openRead = C38104an.openRead(str2);
            if (openRead != null) {
                c31147o = new C31147o(C44216b.ako(str2), "UTF-8", openRead);
                AppMethodBeat.m2505o(10999);
                return c31147o;
            }
            AppMethodBeat.m2505o(10999);
            return null;
        } else if (C5046bo.isNullOrNil(azG.gSP)) {
            C4990ab.m7413e("MicroMsg.ResPkgReader", "tryHitLibWxaPkgFile, pkgPath[%s] is Null Or Nil", azG.gSP);
            AppMethodBeat.m2505o(10999);
            return null;
        } else {
            C4990ab.m7411d("MicroMsg.ResPkgReader", "tryHitLibWxaPkgFile, id(%s), fileName(%s)", str, str2);
            c31147o = C2151c.m4360bO(azG.gSP, str2);
            AppMethodBeat.m2505o(10999);
            return c31147o;
        }
    }
}
