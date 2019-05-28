package com.tencent.mm.plugin.ext.openapi.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.Scopes;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.fe;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.a.sg;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.mm.plugin.ext.c.d.b;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.plugin.ext.ui.RedirectToQrCodeStubUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.c;
import com.tencent.mm.pluginsdk.d.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bz;
import com.tencent.mm.vfs.e;
import com.tencent.rtmp.TXLiveConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtControlProviderOpenApi extends ExtContentProviderBase {
    public static boolean lPG = false;
    private static final String[] lPH = new String[]{"retCode", "selfId"};
    private static final String[] lPI = new String[]{"retCode", "sportConfig"};
    private static final String[] lPJ = new String[]{Scopes.OPEN_ID, "avatar"};
    private static final String[] lPK = new String[]{"voiceType", "sampleRateInHz", "channelConfig", "audioFormat", "filePath"};
    private static final String[] lPL = new String[]{"ssid", "macAddress", "isSupportWechat", "name"};
    private static final String[] lPM = new String[]{"username", "appId", "versionType", "nickname", "shortNickname", "iconURL", "collection", "runningFlag", "wechatPkg", NativeProtocol.WEB_DIALOG_ACTION, "intentInfo"};
    private Context context;
    private ak handler;
    private String[] lPN = null;
    private int lPO = -1;

    public ExtControlProviderOpenApi(String[] strArr, int i, Context context) {
        this.lPN = strArr;
        this.lPO = i;
        this.context = context;
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        AppMethodBeat.i(20315);
        this.handler = new ak();
        AppMethodBeat.o(20315);
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(20316);
        ab.i("MicroMsg.ExtControlProviderOpenApi", "query(), ApiId = %s", Integer.valueOf(this.lPO));
        a(uri, this.context, this.lPO, this.lPN);
        String str3 = this.lPW;
        MatrixCursor Kn;
        Cursor Kn2;
        if (uri == null) {
            ab.e("MicroMsg.ExtControlProviderOpenApi", "uri == null return code = 5");
            dZ(3, 5);
            Kn = a.Kn(5);
            AppMethodBeat.o(20316);
            return Kn;
        } else if (bo.isNullOrNil(this.lPW)) {
            ab.e("MicroMsg.ExtControlProviderOpenApi", "AppID == null return code = 7");
            dZ(3, 7);
            Kn2 = a.Kn(7);
            AppMethodBeat.o(20316);
            return Kn2;
        } else if (bo.isNullOrNil(brL())) {
            ab.e("MicroMsg.ExtControlProviderOpenApi", "PkgName == null return code = 6");
            dZ(3, 6);
            Kn2 = a.Kn(6);
            AppMethodBeat.o(20316);
            return Kn2;
        } else if (aVl()) {
            int i = 1;
            if (!lPG) {
                i = brM();
            }
            if (i != 1) {
                ab.e("MicroMsg.ExtControlProviderOpenApi", "invalid appid ! return code = ".concat(String.valueOf(i)));
                dZ(2, i);
                Kn2 = a.Kn(i);
                AppMethodBeat.o(20316);
                return Kn2;
            }
            String str4;
            String str5;
            Intent intent;
            final String[] strArr3;
            long j;
            Intent intent2;
            switch (this.lPO) {
                case 22:
                    Kn2 = m(uri.getQueryParameter("op"), uri.getQueryParameter("scene"), uri.getQueryParameter("msgType"), uri.getQueryParameter("msgState"));
                    AppMethodBeat.o(20316);
                    return Kn2;
                case 23:
                    Kn2 = r(strArr2);
                    AppMethodBeat.o(20316);
                    return Kn2;
                case 25:
                    Kn2 = s(strArr2);
                    AppMethodBeat.o(20316);
                    return Kn2;
                case 34:
                    ab.i("MicroMsg.ExtControlProviderOpenApi", "sendSight ");
                    if (strArr2 == null || strArr2.length <= 0 || strArr2[0].length() <= 0) {
                        str3 = "MicroMsg.ExtControlProviderOpenApi";
                        str4 = "sendSight wrong args,args == null:%s";
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(strArr2 == null);
                        ab.e(str3, str4, objArr);
                        dZ(3, 3401);
                        Kn2 = a.Kn(3401);
                        AppMethodBeat.o(20316);
                        return Kn2;
                    }
                    Object obj;
                    str5 = strArr2[0];
                    if (bo.isNullOrNil(str5) || !e.ct(str5)) {
                        obj = null;
                    } else {
                        c cVar = new c();
                        obj = SightVideoJNI.isSightOk(str5, cVar.qxg, cVar.qxh, cVar.qxi, cVar.qxk, cVar.qxj, cVar.qxj.length) == 0 ? 1 : null;
                    }
                    if (obj == null) {
                        ab.e("MicroMsg.ExtControlProviderOpenApi", "isSightOk wrong args");
                        dZ(3, 3402);
                        Kn2 = a.Kn(3402);
                        AppMethodBeat.o(20316);
                        return Kn2;
                    }
                    intent = new Intent();
                    intent.addFlags(268435456);
                    intent.addFlags(67108864);
                    intent.putExtra("sight_local_path", str5);
                    d.f(this.context, ".ui.transmit.SightForwardUI", intent);
                    T(12, 0, 1);
                    Kn2 = a.Kn(1);
                    AppMethodBeat.o(20316);
                    return Kn2;
                case 35:
                    ab.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to chatting by phone num");
                    if (strArr2 == null || strArr2.length <= 0 || bo.isNullOrNil(strArr2[0])) {
                        ab.e("MicroMsg.ExtControlProviderOpenApi", "hy: args error: no phone num or phone num is null or nil");
                        dZ(3, 3201);
                        Kn2 = a.Kn(3201);
                        AppMethodBeat.o(20316);
                        return Kn2;
                    }
                    ab.i("MicroMsg.ExtControlProviderOpenApi", "hy: start searching for phone num: %s", strArr2[0]);
                    i = new com.tencent.mm.plugin.ext.b.c(this.context, str5).brH();
                    ab.i("MicroMsg.ExtControlProviderOpenApi", " ret =  ", Integer.valueOf(i));
                    if (i != -1) {
                        T(14, 0, i);
                        i = 0;
                    } else {
                        T(15, 0, i);
                    }
                    Kn2 = a.Kn(i);
                    AppMethodBeat.o(20316);
                    return Kn2;
                case 36:
                    ab.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to wechat out by phone num");
                    if (strArr2 == null || strArr2.length < 3) {
                        ab.e("MicroMsg.ExtControlProviderOpenApi", "hy: wechat out args error: args length error");
                        dZ(3, 3301);
                        Kn2 = a.Kn(3301);
                        AppMethodBeat.o(20316);
                        return Kn2;
                    }
                    str5 = strArr2[0];
                    int i2 = bo.getInt(strArr2[1], -1);
                    str4 = strArr2[2];
                    ab.i("MicroMsg.ExtControlProviderOpenApi", "hy: start wechat out: contactid: %s, countrycode: %s,  phone num: %s", str5, Integer.valueOf(i2), str4);
                    if (bo.isNullOrNil(str5) || i2 < 0 || bo.isNullOrNil(str4)) {
                        ab.i("MicroMsg.ExtControlProviderOpenApi", "hy: param err");
                        dZ(3, 3302);
                        Kn2 = a.Kn(3302);
                        AppMethodBeat.o(20316);
                        return Kn2;
                    }
                    sg sgVar = new sg();
                    sgVar.cOy.cOz = str5;
                    sgVar.cOy.cOA = i2;
                    sgVar.cOy.cMQ = str4;
                    sgVar.cOy.bCu = com.tencent.mm.pluginsdk.a.i(str5, this.context);
                    com.tencent.mm.sdk.b.a.xxA.m(sgVar);
                    T(16, 0, 1);
                    Kn2 = a.Kn(1);
                    AppMethodBeat.o(20316);
                    return Kn2;
                case g.CTRL_INDEX /*37*/:
                    ab.d("MicroMsg.ExtControlProviderOpenApi", com.tencent.mm.plugin.appbrand.jsapi.wifi.c.NAME);
                    this.handler = new ak(Looper.getMainLooper());
                    strArr3 = strArr2;
                    Kn = (MatrixCursor) new bj<MatrixCursor>() {
                        public final /* synthetic */ Object run() {
                            AppMethodBeat.i(20311);
                            MatrixCursor brJ = brJ();
                            AppMethodBeat.o(20311);
                            return brJ;
                        }

                        private MatrixCursor brJ() {
                            AppMethodBeat.i(CdnLogic.kMediaTypeNearEvent);
                            try {
                                ab.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
                                final fh fhVar = new fh();
                                fhVar.cyW.cyY = strArr3;
                                fhVar.callback = new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(20309);
                                        ab.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList run");
                                        if (fhVar == null || fhVar.cyX == null || fhVar.cyX.cyD == 0) {
                                            AppMethodBeat.o(20309);
                                            return;
                                        }
                                        ab.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList return cursor");
                                        AnonymousClass1.this.cC(fhVar.cyX.cyZ);
                                        AppMethodBeat.o(20309);
                                    }
                                };
                                if (!com.tencent.mm.sdk.b.a.xxA.m(fhVar)) {
                                    ab.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList publish getWifiListEvent fail");
                                    cC(a.Kn(8));
                                }
                            } catch (Exception e) {
                                ab.e("MicroMsg.ExtControlProviderOpenApi", "exception in getWifiList syncTaskCur.", e);
                                cC(a.Kn(12));
                            }
                            AppMethodBeat.o(CdnLogic.kMediaTypeNearEvent);
                            return null;
                        }
                    }.b(this.handler);
                    if (Kn == null) {
                        T(19, 4, 14);
                        Kn2 = a.Kn(14);
                        AppMethodBeat.o(20316);
                        return Kn2;
                    }
                    T(18, 0, 1);
                    ab.i("MicroMsg.ExtControlProviderOpenApi", "returnMatrix syncTaskCur");
                    AppMethodBeat.o(20316);
                    return Kn;
                case 38:
                    ab.d("MicroMsg.ExtControlProviderOpenApi", com.tencent.mm.plugin.appbrand.jsapi.wifi.a.NAME);
                    this.handler = new ak(Looper.getMainLooper());
                    strArr3 = strArr2;
                    Integer num = (Integer) new bj<Integer>() {
                        public final /* synthetic */ Object run() {
                            AppMethodBeat.i(20314);
                            Integer amW = amW();
                            AppMethodBeat.o(20314);
                            return amW;
                        }

                        private Integer amW() {
                            AppMethodBeat.i(20313);
                            try {
                                ab.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
                                final fe feVar = new fe();
                                feVar.cyA.version = bo.getInt(strArr3[0], 0);
                                feVar.cyA.ssid = strArr3[1];
                                feVar.cyA.bssid = strArr3[2];
                                feVar.cyA.cyC = bo.getInt(strArr3[3], 0);
                                feVar.callback = new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(20312);
                                        ab.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi run");
                                        if (feVar == null || feVar.cyB == null || feVar.cyB.cyD == 0) {
                                            AppMethodBeat.o(20312);
                                            return;
                                        }
                                        ab.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi errcode = %s,errmsg = %s", Integer.valueOf(feVar.cyB.cyE), feVar.cyB.cyF);
                                        AnonymousClass2.this.cC(Integer.valueOf(feVar.cyB.cyE));
                                        AppMethodBeat.o(20312);
                                    }
                                };
                                if (!com.tencent.mm.sdk.b.a.xxA.m(feVar)) {
                                    ab.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi publish getWifiListEvent fail");
                                    cC(Integer.valueOf(8));
                                }
                            } catch (Exception e) {
                                ab.e("MicroMsg.ExtControlProviderOpenApi", "exception in connectWifi syncTaskInt.", e);
                                cC(Integer.valueOf(12));
                            }
                            Integer valueOf = Integer.valueOf(0);
                            AppMethodBeat.o(20313);
                            return valueOf;
                        }
                    }.b(this.handler);
                    if (num == null) {
                        T(21, 4, 14);
                        Kn2 = a.Kn(14);
                        AppMethodBeat.o(20316);
                        return Kn2;
                    }
                    T(20, 0, num.intValue());
                    Kn2 = a.Kn(num.intValue());
                    AppMethodBeat.o(20316);
                    return Kn2;
                case 40:
                    ab.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep start");
                    if (strArr2 == null || strArr2.length < 3) {
                        ab.e("MicroMsg.ExtControlProviderOpenApi", "args error: args length error");
                        T(23, 3, 2);
                        Kn2 = a.Kn(2);
                        AppMethodBeat.o(20316);
                        return Kn2;
                    }
                    long j2 = bo.getLong(strArr2[0], -1);
                    j = bo.getLong(strArr2[1], -1);
                    long j3 = bo.getLong(strArr2[2], -1);
                    ab.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep: timestampe: %s, stepcount: %s,  version: %s", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
                    if (j < 0 || j2 < 0 || j3 < 0) {
                        ab.i("MicroMsg.ExtControlProviderOpenApi", "param err");
                        T(23, 3, 2);
                        Kn2 = a.Kn(2);
                        AppMethodBeat.o(20316);
                        return Kn2;
                    }
                    brI();
                    fp fpVar = new fp();
                    fpVar.czu.action = 2;
                    fpVar.czu.czw = j;
                    fpVar.czu.czx = j2;
                    fpVar.czu.baZ = j3;
                    if (com.tencent.mm.sdk.b.a.xxA.m(fpVar) && fpVar.czv.czz) {
                        T(22, 0, fpVar.czv.czA);
                        Kn2 = a.Kn(fpVar.czv.czA);
                        AppMethodBeat.o(20316);
                        return Kn2;
                    }
                    T(23, 4, 8);
                    Kn2 = a.Kn(8);
                    AppMethodBeat.o(20316);
                    return Kn2;
                case 41:
                    ab.i("MicroMsg.ExtControlProviderOpenApi", "getSportConfig start");
                    brI();
                    fp fpVar2 = new fp();
                    fpVar2.czu.action = 3;
                    if (com.tencent.mm.sdk.b.a.xxA.m(fpVar2) && fpVar2.czv.czz) {
                        str4 = fpVar2.czv.czy;
                        Kn2 = new MatrixCursor(lPI);
                        Kn2.addRow(new Object[]{Integer.valueOf(fpVar2.czv.czA), bo.nullAsNil(str4)});
                        T(22, 0, fpVar2.czv.czA);
                        ab.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", Integer.valueOf(fpVar2.czv.czA));
                        AppMethodBeat.o(20316);
                        return Kn2;
                    }
                    T(23, 4, 8);
                    Kn2 = a.Kn(8);
                    AppMethodBeat.o(20316);
                    return Kn2;
                case 42:
                    intent2 = new Intent();
                    intent2.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                    intent2.putExtra("key_from_scene", 4);
                    if (strArr2 == null || strArr2.length <= 0 || strArr2[0].length() <= 0) {
                        ab.i("MicroMsg.ExtControlProviderOpenApi", "openOffline appid:%s", str3);
                    } else {
                        ab.i("MicroMsg.ExtControlProviderOpenApi", "openOffline business_attach:%s,appid:%s", strArr2[0], str3);
                        intent2.putExtra("key_business_attach", strArr2[0]);
                    }
                    intent2.putExtra("key_appid", str3);
                    d.b(this.context, "offline", ".ui.WalletOfflineEntranceUI", intent2);
                    h.pYm.e(12097, Integer.valueOf(9), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
                    T(24, 0, 1);
                    Kn2 = a.Kn(1);
                    AppMethodBeat.o(20316);
                    return Kn2;
                case 46:
                    ab.d("MicroMsg.ExtControlProviderOpenApi", "openClean appid:%s", str3);
                    aw.ZK();
                    if (com.tencent.mm.model.c.isSDCardAvailable()) {
                        intent2 = new Intent();
                        intent2.putExtra("key_from_openapi", true);
                        intent2.putExtra("key_openapi_appid", str3);
                        d.b(this.context, "clean", ".ui.CleanUI", intent2);
                        T(26, 0, 1);
                        Kn2 = a.Kn(1);
                        AppMethodBeat.o(20316);
                        return Kn2;
                    }
                    T(27, 5, 4);
                    Kn2 = a.Kn(4101);
                    AppMethodBeat.o(20316);
                    return Kn2;
                case 48:
                    com.tencent.mm.plugin.ext.c.e.brW().mContext = this.context;
                    if (strArr2 == null || strArr2.length <= 0) {
                        ab.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
                        Kn2 = a.Kn(4201);
                        AppMethodBeat.o(20316);
                        return Kn2;
                    }
                    int i3 = bo.getInt(strArr2[0], -1);
                    if (i3 < 0 || !(i3 == 0 || i3 == 1 || i3 == 2)) {
                        ab.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid command!");
                        T(32, 3, 2);
                        Kn2 = a.Kn(4201);
                        AppMethodBeat.o(20316);
                        return Kn2;
                    }
                    str5 = null;
                    if (i3 != 0 && i3 != 1) {
                        str4 = null;
                    } else if (strArr2.length < 2) {
                        ab.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length when check or open!");
                        Kn2 = a.Kn(4205);
                        AppMethodBeat.o(20316);
                        return Kn2;
                    } else {
                        str3 = strArr2[1];
                        if (i3 != 1) {
                            str4 = str3;
                        } else if (strArr2.length < 3) {
                            ab.w("MicroMsg.ExtControlProviderOpenApi", "hy: not providing md5!");
                            Kn2 = a.Kn(4208);
                            AppMethodBeat.o(20316);
                            return Kn2;
                        } else {
                            str5 = strArr2[2];
                            str4 = str3;
                        }
                    }
                    ab.i("MicroMsg.ExtControlProviderOpenApi", "hy: cmdid: %d, yuvHandle: %s", Integer.valueOf(i3), str4);
                    com.tencent.mm.plugin.ext.c.e.a Lj;
                    switch (i3) {
                        case 0:
                            com.tencent.mm.plugin.ext.c.e brW = com.tencent.mm.plugin.ext.c.e.brW();
                            if (bo.isNullOrNil(str4)) {
                                ab.w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleCheckQrCode");
                                com.tencent.mm.plugin.ext.c.e.Q(null, -1, 4205);
                                Kn2 = a.Kn(4205);
                                AppMethodBeat.o(20316);
                                return Kn2;
                            }
                            com.tencent.mm.plugin.ext.c.e.a aVar;
                            Lj = com.tencent.mm.plugin.ext.c.c.Lj(str4);
                            if (Lj == null || bo.isNullOrNil(Lj.url)) {
                                b aH = com.tencent.mm.plugin.ext.c.e.aH(str4, false);
                                if (aH == null) {
                                    ab.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleCheckQrCode");
                                    com.tencent.mm.plugin.ext.c.e.Q(null, -1, 4206);
                                    Kn2 = a.Kn(4206);
                                    AppMethodBeat.o(20316);
                                    return Kn2;
                                }
                                Lj = brW.a(aH);
                                if (Lj == null || bo.isNullOrNil(Lj.url)) {
                                    ab.w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
                                    Kn2 = a.Kn(4203);
                                    AppMethodBeat.o(20316);
                                    return Kn2;
                                }
                                aVar = Lj;
                            } else {
                                ab.i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", str4, Lj);
                                aVar = Lj;
                            }
                            if (aVar.type != 19) {
                                ab.i("MicroMsg.ExtQrCodeHandler", "hy: subapp code. can open");
                                Kn2 = a.Kn(1);
                                AppMethodBeat.o(20316);
                                return Kn2;
                            } else if (com.tencent.mm.plugin.ext.c.c.Ll(aVar.url)) {
                                ab.i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", aVar.url.toUpperCase());
                                com.tencent.mm.plugin.ext.c.e.Q(aVar.url, aVar.type, 4207);
                                Kn2 = a.aiv(aVar.url);
                                AppMethodBeat.o(20316);
                                return Kn2;
                            } else if (com.tencent.mm.plugin.ext.c.c.Lk(aVar.url)) {
                                ab.i("MicroMsg.ExtQrCodeHandler", "hy: wechat can open: %s", aVar.url);
                                com.tencent.mm.plugin.ext.c.e.Q(aVar.url, aVar.type, 1);
                                Kn2 = a.Kn(1);
                                AppMethodBeat.o(20316);
                                return Kn2;
                            } else {
                                j = bo.yz();
                                com.tencent.mm.plugin.ext.c.b.b Lm = com.tencent.mm.plugin.ext.c.c.Lm(aVar.url);
                                ab.i("MicroMsg.ExtQrCodeHandler", "hy: resolve config: %s, using: %d ms", Lm.toString(), Long.valueOf(bo.az(j)));
                                if (Lm == com.tencent.mm.plugin.ext.c.b.b.WHITE) {
                                    com.tencent.mm.plugin.ext.c.c.Lh(aVar.url);
                                    com.tencent.mm.plugin.ext.c.e.Q(aVar.url, aVar.type, 1);
                                    Kn2 = a.Kn(1);
                                    AppMethodBeat.o(20316);
                                    return Kn2;
                                }
                                if (Lm != com.tencent.mm.plugin.ext.c.b.b.BLACK) {
                                    String str6 = aVar.url;
                                    int i4 = aVar.type;
                                    int i5 = aVar.lRd;
                                    ab.i("MicroMsg.ExtQrCodeHandler", "hy: start remote judge url: %s", str6);
                                    long currentTimeMillis = System.currentTimeMillis();
                                    ab.i("MicroMsg.ExtQrCodeHandler", "hy: can open: %b, using %d ms", (Boolean) new com.tencent.mm.plugin.ext.c.e.AnonymousClass2(Boolean.TRUE, str6, i4, i5).b(com.tencent.mm.plugin.ext.c.e.brY()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    if (((Boolean) new com.tencent.mm.plugin.ext.c.e.AnonymousClass2(Boolean.TRUE, str6, i4, i5).b(com.tencent.mm.plugin.ext.c.e.brY())).booleanValue()) {
                                        com.tencent.mm.plugin.ext.c.c.Lh(aVar.url);
                                        com.tencent.mm.plugin.ext.c.e.Q(aVar.url, aVar.type, 1);
                                        Kn2 = a.Kn(1);
                                        AppMethodBeat.o(20316);
                                        return Kn2;
                                    }
                                }
                                com.tencent.mm.plugin.ext.c.c.Li(aVar.url);
                                ab.w("MicroMsg.ExtQrCodeHandler", "hy: remote wechat cannot open: %s", aVar.url);
                                com.tencent.mm.plugin.ext.c.e.Q(aVar.url, aVar.type, 4207);
                                Kn2 = a.aiv(aVar.url);
                                AppMethodBeat.o(20316);
                                return Kn2;
                            }
                        case 1:
                            com.tencent.mm.plugin.ext.c.e brW2 = com.tencent.mm.plugin.ext.c.e.brW();
                            if (bo.isNullOrNil(str4)) {
                                ab.w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleOpenQrCode");
                                com.tencent.mm.plugin.ext.c.e.R(null, -1, 4205);
                                Kn2 = a.Kn(4205);
                                AppMethodBeat.o(20316);
                                return Kn2;
                            }
                            com.tencent.mm.plugin.ext.c.e.a Lj2 = com.tencent.mm.plugin.ext.c.c.Lj(str4);
                            if (Lj2 != null && !bo.isNullOrNil(Lj2.url)) {
                                ab.i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", str4, Lj2);
                                Lj = Lj2;
                            } else if (bo.isNullOrNil(str5)) {
                                ab.w("MicroMsg.ExtQrCodeHandler", "hy: md5 not correct!!");
                                com.tencent.mm.plugin.ext.c.e.R(null, -1, 4208);
                                Kn2 = a.Kn(4208);
                                AppMethodBeat.o(20316);
                                return Kn2;
                            } else {
                                b aH2 = com.tencent.mm.plugin.ext.c.e.aH(str4, true);
                                if (aH2 == null) {
                                    ab.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleOpenQrCode");
                                    com.tencent.mm.plugin.ext.c.e.R(null, -1, 4206);
                                    Kn2 = a.Kn(4206);
                                    AppMethodBeat.o(20316);
                                    return Kn2;
                                } else if (bo.isNullOrNil(aH2.cvZ)) {
                                    ab.w("MicroMsg.ExtQrCodeHandler", "hy: cannot retrieve md5 from yuv!");
                                    com.tencent.mm.plugin.ext.c.e.R(null, -1, 4210);
                                    Kn2 = a.Kn(4210);
                                    AppMethodBeat.o(20316);
                                    return Kn2;
                                } else if (aH2.cvZ.equalsIgnoreCase(str5)) {
                                    Lj = brW2.a(aH2);
                                    if (Lj == null || bo.isNullOrNil(Lj.url)) {
                                        ab.w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
                                        com.tencent.mm.plugin.ext.c.e.R(null, -1, 4203);
                                        Kn2 = a.Kn(4203);
                                        AppMethodBeat.o(20316);
                                        return Kn2;
                                    }
                                    com.tencent.mm.plugin.ext.c.c.a(str4, Lj);
                                } else {
                                    ab.w("MicroMsg.ExtQrCodeHandler", "hy: yuv data not match!!");
                                    com.tencent.mm.plugin.ext.c.e.R(null, -1, 4209);
                                    Kn2 = a.Kn(4209);
                                    AppMethodBeat.o(20316);
                                    return Kn2;
                                }
                            }
                            if (Lj.type == 19 && com.tencent.mm.plugin.ext.c.c.Ll(Lj.url)) {
                                ab.i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", Lj.url);
                                com.tencent.mm.plugin.ext.c.e.R(Lj.url, Lj.type, 4207);
                                Kn2 = a.Kn(4207);
                                AppMethodBeat.o(20316);
                                return Kn2;
                            }
                            ab.i("MicroMsg.ExtQrCodeHandler", "hy: do open");
                            ab.i("MicroMsg.ExtQrCodeHandler", "hy: start open: %s", Lj.toString());
                            intent = new Intent(brW2.mContext, RedirectToQrCodeStubUI.class);
                            intent.putExtra("K_STR", Lj.url);
                            intent.putExtra("K_TYPE", Lj.type);
                            intent.putExtra("K_VERSION", Lj.lRd);
                            intent.addFlags(268435456);
                            brW2.mContext.startActivity(intent);
                            com.tencent.mm.plugin.ext.c.e.R(Lj.url, Lj.type, 1);
                            Kn2 = a.Kn(1);
                            AppMethodBeat.o(20316);
                            return Kn2;
                        case 2:
                            com.tencent.mm.plugin.ext.c.e.brW();
                            Kn2 = com.tencent.mm.plugin.ext.c.e.brX();
                            AppMethodBeat.o(20316);
                            return Kn2;
                        default:
                            AppMethodBeat.o(20316);
                            return null;
                    }
                case 51:
                    Kn2 = q(strArr2);
                    AppMethodBeat.o(20316);
                    return Kn2;
                case 52:
                    Kn2 = p(strArr2);
                    AppMethodBeat.o(20316);
                    return Kn2;
                default:
                    dZ(3, 15);
                    AppMethodBeat.o(20316);
                    return null;
            }
        } else {
            ab.e("MicroMsg.ExtControlProviderOpenApi", "not login return code = 3");
            dZ(1, 3);
            Kn2 = a.Kn(3);
            AppMethodBeat.o(20316);
            return Kn2;
        }
    }

    private Cursor p(String[] strArr) {
        AppMethodBeat.i(20317);
        if (strArr == null || strArr.length == 0) {
            ab.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
            MatrixCursor Kn = a.Kn(2);
            AppMethodBeat.o(20317);
            return Kn;
        }
        Cursor Kn2;
        try {
            int parseInt = Integer.parseInt(strArr[0]);
            if (1 == parseInt) {
                try {
                    int parseInt2 = Integer.parseInt(strArr[1]);
                    if (1 == parseInt2 || 2 == parseInt2) {
                        ((com.tencent.mm.plugin.appbrand.service.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.b.class)).F(this.context, parseInt2);
                    } else {
                        Kn2 = a.Kn(2);
                        AppMethodBeat.o(20317);
                        return Kn2;
                    }
                } catch (NumberFormatException e) {
                    ab.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", e, "", new Object[0]);
                    Kn2 = a.Kn(2);
                    AppMethodBeat.o(20317);
                    return Kn2;
                }
            } else if (2 == parseInt) {
                ((com.tencent.mm.plugin.appbrand.service.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.b.class)).cX(this.context);
            } else {
                Kn2 = a.Kn(2);
                AppMethodBeat.o(20317);
                return Kn2;
            }
            Kn2 = a.Kn(1);
            AppMethodBeat.o(20317);
            return Kn2;
        } catch (NumberFormatException e2) {
            ab.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", e2, "", new Object[0]);
            Kn2 = a.Kn(2);
            AppMethodBeat.o(20317);
            return Kn2;
        }
    }

    private static Cursor q(String[] strArr) {
        AppMethodBeat.i(20318);
        if (strArr == null || strArr.length < 2) {
            ab.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
            MatrixCursor Kn = a.Kn(2);
            AppMethodBeat.o(20318);
            return Kn;
        }
        MatrixCursor matrixCursor = new MatrixCursor(lPM);
        try {
            int parseInt = Integer.parseInt(strArr[0]);
            int parseInt2 = Integer.parseInt(strArr[1]);
            List list = null;
            if (1 == parseInt) {
                list = ((ag) com.tencent.mm.kernel.g.K(ag.class)).nA(parseInt2);
            } else if (2 == parseInt) {
                list = ((af) com.tencent.mm.kernel.g.K(af.class)).a(parseInt2, null);
            }
            for (LocalUsageInfo localUsageInfo : com.tencent.luggage.g.c.C(list)) {
                WxaAttributes zc = ((com.tencent.mm.plugin.appbrand.service.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.d.class)).zc(localUsageInfo.appId);
                if (zc != null) {
                    String[] strArr2 = new String[]{zc.field_roundedSquareIconURL, zc.field_brandIconURL, zc.field_bigHeadURL};
                    com.tencent.mm.modelappbrand.b.a aVar = (com.tencent.mm.modelappbrand.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.modelappbrand.b.a.class);
                    String packageName = ah.getPackageName();
                    parseInt2 = localUsageInfo.har;
                    String str = zc.field_username;
                    String str2 = zc.field_nickname;
                    String str3 = zc.field_appId;
                    com.tencent.mm.kernel.g.RN();
                    Intent a = aVar.a(packageName, parseInt2, str, str2, strArr2, str3, com.tencent.mm.kernel.a.QF(), 3);
                    if (a != null) {
                        Bundle extras = a.getExtras();
                        if (extras != null) {
                            Map hashMap = new HashMap();
                            for (String str4 : extras.keySet()) {
                                hashMap.put(str4, extras.get(str4));
                            }
                            Object[] objArr = new Object[11];
                            objArr[0] = localUsageInfo.username;
                            objArr[1] = localUsageInfo.appId;
                            objArr[2] = Integer.valueOf(localUsageInfo.har);
                            objArr[3] = localUsageInfo.nickname;
                            objArr[4] = localUsageInfo.bQo;
                            objArr[5] = zc.field_brandIconURL;
                            objArr[6] = Integer.valueOf(localUsageInfo.haP ? 1 : 0);
                            objArr[7] = Long.valueOf(localUsageInfo.haQ);
                            objArr[8] = a.getPackage();
                            objArr[9] = a.getAction();
                            objArr[10] = new i(hashMap).toString();
                            matrixCursor.addRow(objArr);
                        }
                    }
                }
            }
            AppMethodBeat.o(20318);
            return matrixCursor;
        } catch (NumberFormatException e) {
            ab.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", e, "", new Object[0]);
            Cursor Kn2 = a.Kn(2);
            AppMethodBeat.o(20318);
            return Kn2;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private Cursor m(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(20319);
        ab.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver, op = %s", str);
        Cursor Kn;
        if (this.context == null) {
            ab.e("MicroMsg.ExtControlProviderOpenApi", "context == null return code = 2001");
            dZ(4, 2001);
            MatrixCursor Kn2 = a.Kn(2001);
            AppMethodBeat.o(20319);
            return Kn2;
        } else if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, op is null return code = 2002");
            dZ(3, 2002);
            Kn = a.Kn(2002);
            AppMethodBeat.o(20319);
            return Kn;
        } else {
            int i = -1;
            try {
                i = bo.getInt(str, -1);
            } catch (Exception e) {
            }
            if (i == 1) {
                Kn = P(str2, str3, str4);
                AppMethodBeat.o(20319);
                return Kn;
            } else if (i == 2) {
                ab.d("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener");
                if (com.tencent.mm.plugin.ext.b.brA().apN(this.lPW) == null) {
                    ab.w("MicroMsg.ExtControlProviderOpenApi", "This app never been registered, appId = %s, pkg = %s", this.lPW, brL());
                    Kn = a.Kn(TXLiveConstants.PLAY_EVT_PLAY_LOADING);
                    AppMethodBeat.o(20319);
                    return Kn;
                }
                boolean z;
                bp brA = com.tencent.mm.plugin.ext.b.brA();
                String str5 = this.lPW;
                if (str5 == null || str5.length() <= 0) {
                    z = false;
                } else {
                    if (brA.bSd.delete("OpenMsgListener", "appId=?", new String[]{bo.vA(str5)}) <= 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                }
                ab.i("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener ret = %s, appId = %s, pkg = %s", Boolean.valueOf(z), this.lPW, brL());
                if (z) {
                    T(0, 0, 1);
                    Kn = a.Kn(1);
                    AppMethodBeat.o(20319);
                    return Kn;
                }
                Kn = a.Kn(2008);
                AppMethodBeat.o(20319);
                return Kn;
            } else {
                ab.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, no such op, %s", Integer.valueOf(i));
                dZ(3, 2003);
                Kn = a.Kn(2003);
                AppMethodBeat.o(20319);
                return Kn;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0124  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Cursor P(String str, String str2, String str3) {
        Exception e;
        AppMethodBeat.i(20320);
        ab.i("MicroMsg.ExtControlProviderOpenApi", "doRegisterMsgListener");
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || bo.isNullOrNil(str3)) {
            ab.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, scene = %s, msgType = %s, msgState = %s", str, str2, str3);
            dZ(3, 2004);
            MatrixCursor Kn = a.Kn(2004);
            AppMethodBeat.o(20320);
            return Kn;
        }
        MatrixCursor matrixCursor = null;
        Cursor Kn2;
        try {
            int parseInt = Integer.parseInt(str3);
            int parseInt2 = Integer.parseInt(str);
            int parseInt3 = Integer.parseInt(str2);
            if (parseInt != 2) {
                ab.e("MicroMsg.ExtControlProviderOpenApi", "wrong msgState: ".concat(String.valueOf(parseInt)));
                dZ(3, TXLiveConstants.PLAY_EVT_PLAY_PROGRESS);
                Kn2 = a.Kn(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS);
                AppMethodBeat.o(20320);
                return Kn2;
            }
            if (com.tencent.mm.plugin.ext.b.brA().apN(this.lPW) == null) {
                boolean z;
                com.tencent.mm.storage.bo boVar = new com.tencent.mm.storage.bo();
                boVar.field_appId = this.lPW;
                boVar.field_packageName = brL();
                String str4 = this.lPW;
                if (bo.isNullOrNil(str4)) {
                    z = false;
                } else {
                    z = com.tencent.mm.pluginsdk.model.app.g.k(com.tencent.mm.pluginsdk.model.app.g.bT(str4, true));
                }
                if (z) {
                    boVar.field_status = 1;
                } else {
                    boVar.field_status = 0;
                }
                boVar.field_sceneFlag = parseInt2;
                boVar.field_msgTypeFlag = parseInt3;
                boVar.field_msgState = parseInt;
                ab.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver ret = %s, pkgName = %s, scene = %s, msgType = %s, msgState = %s, appStatus = %s", Boolean.valueOf(com.tencent.mm.plugin.ext.b.brA().b((com.tencent.mm.sdk.e.c) boVar)), brL(), Integer.valueOf(parseInt2), Integer.valueOf(parseInt), Integer.valueOf(parseInt), Integer.valueOf(boVar.field_status));
                if (!com.tencent.mm.plugin.ext.b.brA().b((com.tencent.mm.sdk.e.c) boVar)) {
                    Kn2 = a.Kn(TXLiveConstants.PLAY_EVT_PLAY_END);
                    AppMethodBeat.o(20320);
                    return Kn2;
                }
            }
            ab.w("MicroMsg.ExtControlProviderOpenApi", "This app had already been registered, appId = %s, pkg = %s", this.lPW, brL());
            StringBuilder append = new StringBuilder().append(r.Yz());
            aw.ZK();
            String ck = com.tencent.mm.sdk.platformtools.ag.ck(append.append(com.tencent.mm.model.c.QF()).toString());
            Kn2 = new MatrixCursor(lPH);
            try {
                Kn2.addRow(new Object[]{Integer.valueOf(1), bo.nullAsNil(ck)});
                T(0, 0, 1);
                ab.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", Integer.valueOf(1));
                AppMethodBeat.o(20320);
                return Kn2;
            } catch (Exception e2) {
                e = e2;
                Cursor matrixCursor2 = Kn2;
                T(1, 4, 12);
                ab.e("MicroMsg.ExtControlProviderOpenApi", "exception in doRegisterMsgListener, %s", e.getMessage());
                if (matrixCursor2 != null) {
                    matrixCursor2.close();
                }
                Kn2 = a.Kn(12);
                AppMethodBeat.o(20320);
                return Kn2;
            }
        } catch (Exception e3) {
            e = e3;
            T(1, 4, 12);
            ab.e("MicroMsg.ExtControlProviderOpenApi", "exception in doRegisterMsgListener, %s", e.getMessage());
            if (matrixCursor2 != null) {
            }
            Kn2 = a.Kn(12);
            AppMethodBeat.o(20320);
            return Kn2;
        }
    }

    private Cursor r(String[] strArr) {
        AppMethodBeat.i(CdnLogic.kMediaTypeSmartHwPage);
        ab.i("MicroMsg.ExtControlProviderOpenApi", "getUserAvatarByOpenId");
        if (strArr == null || strArr.length <= 0) {
            ab.e("MicroMsg.ExtControlProviderOpenApi", "wrong args");
            dZ(3, 3001);
            MatrixCursor Kn = a.Kn(3001);
            AppMethodBeat.o(CdnLogic.kMediaTypeSmartHwPage);
            return Kn;
        }
        Cursor matrixCursor = new MatrixCursor(lPJ);
        int i = 0;
        while (i < strArr.length && i < 5) {
            try {
                if (!bo.isNullOrNil(strArr[i])) {
                    bz apZ = com.tencent.mm.plugin.ext.b.brB().apZ(strArr[i]);
                    if (apZ == null || bo.isNullOrNil(apZ.field_openId) || bo.isNullOrNil(apZ.field_username)) {
                        ab.e("MicroMsg.ExtControlProviderOpenApi", "openidInApp is null");
                    } else {
                        aw.ZK();
                        ad aoO = com.tencent.mm.model.c.XM().aoO(apZ.field_username);
                        if (aoO == null || aoO.field_username == null || aoO.field_username.length() <= 0) {
                            ab.e("MicroMsg.ExtControlProviderOpenApi", "contact is null");
                        } else {
                            o.acd();
                            String D = com.tencent.mm.ah.d.D(aoO.field_username, false);
                            if (bo.isNullOrNil(D)) {
                                ab.w("MicroMsg.ExtControlProviderOpenApi", "hy: get avatar sfs path is null or nil");
                            } else {
                                String str;
                                if (D.startsWith(com.tencent.mm.kernel.g.RP().cachePath)) {
                                    str = com.tencent.mm.kernel.g.RP().eJM + D.substring(com.tencent.mm.kernel.g.RP().cachePath.length());
                                    e.tf(e.atb(str));
                                    e.y(D, str);
                                } else {
                                    str = D;
                                }
                                com.tencent.mm.ah.d.b.qk(str);
                                matrixCursor.addRow(new Object[]{strArr[i], str});
                            }
                        }
                    }
                }
                i++;
            } catch (Exception e) {
                ab.e("MicroMsg.ExtControlProviderOpenApi", "Exception occur, %s", e.getMessage());
                T(7, 4, 12);
                matrixCursor.close();
                matrixCursor = a.Kn(12);
                AppMethodBeat.o(CdnLogic.kMediaTypeSmartHwPage);
                return matrixCursor;
            }
        }
        T(6, 0, 1);
        AppMethodBeat.o(CdnLogic.kMediaTypeSmartHwPage);
        return matrixCursor;
    }

    private Cursor s(String[] strArr) {
        AppMethodBeat.i(CdnLogic.kMediaTypeHWDevice);
        ab.i("MicroMsg.ExtControlProviderOpenApi", "decodeVoice");
        MatrixCursor Kn;
        if (strArr == null || strArr.length <= 0 || strArr[0].length() <= 0) {
            ab.e("MicroMsg.ExtControlProviderOpenApi", "decodeVoice wrong args");
            dZ(3, 3101);
            Kn = a.Kn(3101);
            AppMethodBeat.o(CdnLogic.kMediaTypeHWDevice);
            return Kn;
        }
        Kn = null;
        int i = 0;
        while (i < 5 && i < strArr.length) {
            String str = strArr[i];
            try {
                if (com.tencent.mm.modelvoice.o.i(str, 0, true)) {
                    String str2;
                    if (Kn == null) {
                        Kn = new MatrixCursor(lPK);
                    }
                    com.tencent.mm.modelvoice.i iVar = new com.tencent.mm.modelvoice.i();
                    String str3 = com.tencent.mm.plugin.ext.b.brD() + "/" + com.tencent.mm.sdk.platformtools.ag.ck(str);
                    ab.i("MicroMsg.ExtControlProviderOpenApi", "summerpcm pcmPath[%s]", str3);
                    if (e.asZ(str3) > 0) {
                        ab.d("MicroMsg.ExtControlProviderOpenApi", "pcm already exist");
                        str2 = str3;
                    } else {
                        str2 = iVar.aX(str, str3);
                    }
                    if (e.asZ(str3) == 0) {
                        str2 = iVar.aX(str, str3);
                    }
                    if (bo.isNullOrNil(str2)) {
                        ab.w("MicroMsg.ExtControlProviderOpenApi", "wrong args targetFilePath is null");
                    } else {
                        ab.d("MicroMsg.ExtControlProviderOpenApi", "decode to pcm success %d", Integer.valueOf(i));
                        Kn.addRow(new Object[]{Integer.valueOf(1), Integer.valueOf(iVar.mSampleRate), Integer.valueOf(iVar.cpQ), Integer.valueOf(2), str2});
                    }
                } else {
                    ab.w("MicroMsg.ExtControlProviderOpenApi", "wrong args : %s", strArr[i]);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.ExtControlProviderOpenApi", "Exception in decodeVoice, %s", e.getMessage());
            }
            i++;
        }
        if (Kn != null) {
            T(8, 0, 1);
            AppMethodBeat.o(CdnLogic.kMediaTypeHWDevice);
            return Kn;
        }
        T(9, 3, 4);
        Cursor Kn2 = a.Kn(4);
        AppMethodBeat.o(CdnLogic.kMediaTypeHWDevice);
        return Kn2;
    }

    private void brI() {
        AppMethodBeat.i(20323);
        String str = (String) com.tencent.mm.plugin.ext.b.brz().get(ac.a.USERINFO_EXT_SPORT_PKGNAME_STRING, null);
        ab.i("MicroMsg.ExtControlProviderOpenApi", "setSportBroadPkg: pkgNames: %s, pkg: %s", str, brL());
        if (str != null) {
            if (!com.tencent.mm.compatible.loader.a.contains(str.split(";"), r1)) {
                com.tencent.mm.plugin.ext.b.brz().set(ac.a.USERINFO_EXT_SPORT_PKGNAME_STRING, str + ";" + brL());
            }
            AppMethodBeat.o(20323);
            return;
        }
        com.tencent.mm.plugin.ext.b.brz().set(ac.a.USERINFO_EXT_SPORT_PKGNAME_STRING, brL());
        AppMethodBeat.o(20323);
    }
}
