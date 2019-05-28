package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.k;
import com.tencent.mm.plugin.appbrand.r.d;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.xweb.o;
import java.io.Closeable;
import java.io.InputStream;

public final class c {
    private static final String[] gTT = an.gTT;

    private static o bO(String str, String str2) {
        Throwable e;
        AppMethodBeat.i(10997);
        Closeable aoVar;
        Closeable xy;
        try {
            aoVar = new ao(str);
            try {
                aoVar.avW();
                xy = aoVar.xy(str2);
            } catch (Exception e2) {
                e = e2;
                xy = null;
            }
            try {
                bo.b(aoVar);
                o oVar = new o(b.ako(str2), "UTF-8", xy);
                AppMethodBeat.o(10997);
                return oVar;
            } catch (Exception e3) {
                e = e3;
                ab.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile with pkgPath(%s), exp = %s", str, bo.l(e));
                bo.b(aoVar);
                bo.b(xy);
                AppMethodBeat.o(10997);
                return null;
            }
        } catch (Exception e4) {
            e = e4;
            xy = null;
            aoVar = null;
            ab.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile with pkgPath(%s), exp = %s", str, bo.l(e));
            bo.b(aoVar);
            bo.b(xy);
            AppMethodBeat.o(10997);
            return null;
        }
    }

    public static String bR(String str, String str2) {
        AppMethodBeat.i(CdnLogic.kMediaTypeExposeImage);
        String str3;
        if (bo.isNullOrNil(str2)) {
            str3 = "";
            AppMethodBeat.o(CdnLogic.kMediaTypeExposeImage);
            return str3;
        }
        o bS = bS(str, str2);
        if (bS == null || bS.mInputStream == null) {
            ab.e("MicroMsg.ResPkgReader", "get cache content for id : %s from url : %s, failed", str, str2);
            str3 = "";
            AppMethodBeat.o(CdnLogic.kMediaTypeExposeImage);
            return str3;
        }
        try {
            ab.d("MicroMsg.ResPkgReader", "getCacheContent, dataStream available = %d, url = %s", Integer.valueOf(bS.mInputStream.available()), str2);
        } catch (Exception e) {
            ab.e("MicroMsg.ResPkgReader", "getCacheContent exp = %s, id = %s, url = %s", e, str, str2);
        }
        str3 = d.convertStreamToString(bS.mInputStream);
        AppMethodBeat.o(CdnLogic.kMediaTypeExposeImage);
        return str3;
    }

    public static o bS(String str, String str2) {
        AppMethodBeat.i(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS);
        ab.i("MicroMsg.ResPkgReader", "getCacheResource called, id = %s, reqURL = %s", str, str2);
        if (bo.isNullOrNil(str2)) {
            AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS);
            return null;
        } else if (u.t(str2, "about:blank")) {
            AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS);
            return null;
        } else if (d.Ed(str2)) {
            AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS);
            return null;
        } else {
            Object yk = l.yk(str2);
            if (a.contains(gTT, yk)) {
                o bQ = bQ(str, yk);
                AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS);
                return bQ;
            }
            o bP = bP(str, yk);
            if (bP == null) {
                Bundle bundle = new Bundle();
                bundle.putString("id", str);
                bundle.putInt("widgetState", TXLiveConstants.PLAY_WARNING_AUDIO_DECODE_FAIL);
                f.a(i.azC().zV(str), bundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.class, null);
            }
            AppMethodBeat.o(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS);
            return bP;
        }
    }

    private static o bP(String str, String str2) {
        WxaPkgWrappingInfo azF;
        AppMethodBeat.i(10998);
        WxaWidgetContext Aa = k.Aa(str);
        if (Aa != null) {
            azF = Aa.azF();
        } else {
            azF = null;
        }
        if (azF == null) {
            ab.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get null appInfo by id %s", str);
            AppMethodBeat.o(10998);
            return null;
        } else if (bo.isNullOrNil(azF.gSP)) {
            ab.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get Null Or Nil pkgPath[%s] by appId %s", azF.gSP, str);
            AppMethodBeat.o(10998);
            return null;
        } else {
            String str3 = azF.gSP;
            if (bo.isNullOrNil(str3)) {
                ab.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get null or nil pkgLocalPath");
                AppMethodBeat.o(10998);
                return null;
            }
            ab.d("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, id(%s), fileName(%s)", str, str2);
            o bO = bO(str3, str2);
            AppMethodBeat.o(10998);
            return bO;
        }
    }

    private static o bQ(String str, String str2) {
        WxaPkgWrappingInfo azG;
        AppMethodBeat.i(10999);
        WxaWidgetContext Aa = k.Aa(str);
        if (Aa != null) {
            azG = Aa.azG();
        } else {
            azG = null;
        }
        o oVar;
        if (azG == null) {
            AppMethodBeat.o(10999);
            return null;
        } else if (azG.gVw) {
            InputStream openRead = an.openRead(str2);
            if (openRead != null) {
                oVar = new o(b.ako(str2), "UTF-8", openRead);
                AppMethodBeat.o(10999);
                return oVar;
            }
            AppMethodBeat.o(10999);
            return null;
        } else if (bo.isNullOrNil(azG.gSP)) {
            ab.e("MicroMsg.ResPkgReader", "tryHitLibWxaPkgFile, pkgPath[%s] is Null Or Nil", azG.gSP);
            AppMethodBeat.o(10999);
            return null;
        } else {
            ab.d("MicroMsg.ResPkgReader", "tryHitLibWxaPkgFile, id(%s), fileName(%s)", str, str2);
            oVar = bO(azG.gSP, str2);
            AppMethodBeat.o(10999);
            return oVar;
        }
    }
}
