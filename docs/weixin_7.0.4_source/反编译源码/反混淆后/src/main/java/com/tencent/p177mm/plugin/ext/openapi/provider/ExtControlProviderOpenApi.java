package com.tencent.p177mm.plugin.ext.openapi.provider;

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
import com.tencent.luggage.p147g.C37400c;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.loader.C32473a;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelappbrand.p1642b.C45444a;
import com.tencent.p177mm.modelvoice.C32848o;
import com.tencent.p177mm.modelvoice.C9732i;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1174aa.C41726i;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.p182ah.C41732d.C1195b;
import com.tencent.p177mm.p230g.p231a.C32552fe;
import com.tencent.p177mm.p230g.p231a.C45365sg;
import com.tencent.p177mm.p230g.p231a.C6480fh;
import com.tencent.p177mm.p230g.p231a.C9345fp;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af;
import com.tencent.p177mm.plugin.appbrand.appusage.C26767ag;
import com.tencent.p177mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.C16681c;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.C19523a;
import com.tencent.p177mm.plugin.appbrand.service.C10733b;
import com.tencent.p177mm.plugin.appbrand.service.C42686d;
import com.tencent.p177mm.plugin.ext.C6875b;
import com.tencent.p177mm.plugin.ext.p730c.C27905e;
import com.tencent.p177mm.plugin.ext.p730c.C27905e.C27906a;
import com.tencent.p177mm.plugin.ext.p730c.C27905e.C68892;
import com.tencent.p177mm.plugin.ext.p730c.C38993b.C11773b;
import com.tencent.p177mm.plugin.ext.p730c.C38994d.C38995b;
import com.tencent.p177mm.plugin.ext.p730c.C45907c;
import com.tencent.p177mm.plugin.ext.p962b.C45906c;
import com.tencent.p177mm.plugin.ext.p964ui.RedirectToQrCodeStubUI;
import com.tencent.p177mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.base.C29015c;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.pluginsdk.C46482a;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p1568d.p1569a.C40420a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5039bj;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C23511bo;
import com.tencent.p177mm.storage.C23512bz;
import com.tencent.p177mm.storage.C30298bp;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.rtmp.TXLiveConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi */
public class ExtControlProviderOpenApi extends ExtContentProviderBase {
    public static boolean lPG = false;
    private static final String[] lPH = new String[]{"retCode", "selfId"};
    private static final String[] lPI = new String[]{"retCode", "sportConfig"};
    private static final String[] lPJ = new String[]{Scopes.OPEN_ID, "avatar"};
    private static final String[] lPK = new String[]{"voiceType", "sampleRateInHz", "channelConfig", "audioFormat", "filePath"};
    private static final String[] lPL = new String[]{"ssid", "macAddress", "isSupportWechat", "name"};
    private static final String[] lPM = new String[]{"username", "appId", "versionType", "nickname", "shortNickname", "iconURL", "collection", "runningFlag", "wechatPkg", NativeProtocol.WEB_DIALOG_ACTION, "intentInfo"};
    private Context context;
    private C7306ak handler;
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
        AppMethodBeat.m2504i(20315);
        this.handler = new C7306ak();
        AppMethodBeat.m2505o(20315);
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.m2504i(20316);
        C4990ab.m7417i("MicroMsg.ExtControlProviderOpenApi", "query(), ApiId = %s", Integer.valueOf(this.lPO));
        mo61883a(uri, this.context, this.lPO, this.lPN);
        String str3 = this.lPW;
        MatrixCursor Kn;
        Cursor Kn2;
        if (uri == null) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderOpenApi", "uri == null return code = 5");
            mo61889dZ(3, 5);
            Kn = C40420a.m69330Kn(5);
            AppMethodBeat.m2505o(20316);
            return Kn;
        } else if (C5046bo.isNullOrNil(this.lPW)) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderOpenApi", "AppID == null return code = 7");
            mo61889dZ(3, 7);
            Kn2 = C40420a.m69330Kn(7);
            AppMethodBeat.m2505o(20316);
            return Kn2;
        } else if (C5046bo.isNullOrNil(brL())) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderOpenApi", "PkgName == null return code = 6");
            mo61889dZ(3, 6);
            Kn2 = C40420a.m69330Kn(6);
            AppMethodBeat.m2505o(20316);
            return Kn2;
        } else if (aVl()) {
            int i = 1;
            if (!lPG) {
                i = brM();
            }
            if (i != 1) {
                C4990ab.m7412e("MicroMsg.ExtControlProviderOpenApi", "invalid appid ! return code = ".concat(String.valueOf(i)));
                mo61889dZ(2, i);
                Kn2 = C40420a.m69330Kn(i);
                AppMethodBeat.m2505o(20316);
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
                    Kn2 = m19610m(uri.getQueryParameter("op"), uri.getQueryParameter("scene"), uri.getQueryParameter("msgType"), uri.getQueryParameter("msgState"));
                    AppMethodBeat.m2505o(20316);
                    return Kn2;
                case 23:
                    Kn2 = m19613r(strArr2);
                    AppMethodBeat.m2505o(20316);
                    return Kn2;
                case 25:
                    Kn2 = m19614s(strArr2);
                    AppMethodBeat.m2505o(20316);
                    return Kn2;
                case 34:
                    C4990ab.m7416i("MicroMsg.ExtControlProviderOpenApi", "sendSight ");
                    if (strArr2 == null || strArr2.length <= 0 || strArr2[0].length() <= 0) {
                        str3 = "MicroMsg.ExtControlProviderOpenApi";
                        str4 = "sendSight wrong args,args == null:%s";
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(strArr2 == null);
                        C4990ab.m7413e(str3, str4, objArr);
                        mo61889dZ(3, 3401);
                        Kn2 = C40420a.m69330Kn(3401);
                        AppMethodBeat.m2505o(20316);
                        return Kn2;
                    }
                    Object obj;
                    str5 = strArr2[0];
                    if (C5046bo.isNullOrNil(str5) || !C5730e.m8628ct(str5)) {
                        obj = null;
                    } else {
                        C29015c c29015c = new C29015c();
                        obj = SightVideoJNI.isSightOk(str5, c29015c.qxg, c29015c.qxh, c29015c.qxi, c29015c.qxk, c29015c.qxj, c29015c.qxj.length) == 0 ? 1 : null;
                    }
                    if (obj == null) {
                        C4990ab.m7412e("MicroMsg.ExtControlProviderOpenApi", "isSightOk wrong args");
                        mo61889dZ(3, 3402);
                        Kn2 = C40420a.m69330Kn(3402);
                        AppMethodBeat.m2505o(20316);
                        return Kn2;
                    }
                    intent = new Intent();
                    intent.addFlags(268435456);
                    intent.addFlags(67108864);
                    intent.putExtra("sight_local_path", str5);
                    C25985d.m41473f(this.context, ".ui.transmit.SightForwardUI", intent);
                    mo61881T(12, 0, 1);
                    Kn2 = C40420a.m69330Kn(1);
                    AppMethodBeat.m2505o(20316);
                    return Kn2;
                case 35:
                    C4990ab.m7416i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to chatting by phone num");
                    if (strArr2 == null || strArr2.length <= 0 || C5046bo.isNullOrNil(strArr2[0])) {
                        C4990ab.m7412e("MicroMsg.ExtControlProviderOpenApi", "hy: args error: no phone num or phone num is null or nil");
                        mo61889dZ(3, 3201);
                        Kn2 = C40420a.m69330Kn(3201);
                        AppMethodBeat.m2505o(20316);
                        return Kn2;
                    }
                    C4990ab.m7417i("MicroMsg.ExtControlProviderOpenApi", "hy: start searching for phone num: %s", strArr2[0]);
                    i = new C45906c(this.context, str5).brH();
                    C4990ab.m7417i("MicroMsg.ExtControlProviderOpenApi", " ret =  ", Integer.valueOf(i));
                    if (i != -1) {
                        mo61881T(14, 0, i);
                        i = 0;
                    } else {
                        mo61881T(15, 0, i);
                    }
                    Kn2 = C40420a.m69330Kn(i);
                    AppMethodBeat.m2505o(20316);
                    return Kn2;
                case 36:
                    C4990ab.m7416i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to wechat out by phone num");
                    if (strArr2 == null || strArr2.length < 3) {
                        C4990ab.m7412e("MicroMsg.ExtControlProviderOpenApi", "hy: wechat out args error: args length error");
                        mo61889dZ(3, 3301);
                        Kn2 = C40420a.m69330Kn(3301);
                        AppMethodBeat.m2505o(20316);
                        return Kn2;
                    }
                    str5 = strArr2[0];
                    int i2 = C5046bo.getInt(strArr2[1], -1);
                    str4 = strArr2[2];
                    C4990ab.m7417i("MicroMsg.ExtControlProviderOpenApi", "hy: start wechat out: contactid: %s, countrycode: %s,  phone num: %s", str5, Integer.valueOf(i2), str4);
                    if (C5046bo.isNullOrNil(str5) || i2 < 0 || C5046bo.isNullOrNil(str4)) {
                        C4990ab.m7416i("MicroMsg.ExtControlProviderOpenApi", "hy: param err");
                        mo61889dZ(3, 3302);
                        Kn2 = C40420a.m69330Kn(3302);
                        AppMethodBeat.m2505o(20316);
                        return Kn2;
                    }
                    C45365sg c45365sg = new C45365sg();
                    c45365sg.cOy.cOz = str5;
                    c45365sg.cOy.cOA = i2;
                    c45365sg.cOy.cMQ = str4;
                    c45365sg.cOy.bCu = C46482a.m87697i(str5, this.context);
                    C4879a.xxA.mo10055m(c45365sg);
                    mo61881T(16, 0, 1);
                    Kn2 = C40420a.m69330Kn(1);
                    AppMethodBeat.m2505o(20316);
                    return Kn2;
                case C2275g.CTRL_INDEX /*37*/:
                    C4990ab.m7410d("MicroMsg.ExtControlProviderOpenApi", C16681c.NAME);
                    this.handler = new C7306ak(Looper.getMainLooper());
                    strArr3 = strArr2;
                    Kn = (MatrixCursor) new C5039bj<MatrixCursor>() {
                        public final /* synthetic */ Object run() {
                            AppMethodBeat.m2504i(20311);
                            MatrixCursor brJ = brJ();
                            AppMethodBeat.m2505o(20311);
                            return brJ;
                        }

                        private MatrixCursor brJ() {
                            AppMethodBeat.m2504i(CdnLogic.kMediaTypeNearEvent);
                            try {
                                C4990ab.m7410d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
                                final C6480fh c6480fh = new C6480fh();
                                c6480fh.cyW.cyY = strArr3;
                                c6480fh.callback = new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.m2504i(20309);
                                        C4990ab.m7416i("MicroMsg.ExtControlProviderOpenApi", "getWifiList run");
                                        if (c6480fh == null || c6480fh.cyX == null || c6480fh.cyX.cyD == 0) {
                                            AppMethodBeat.m2505o(20309);
                                            return;
                                        }
                                        C4990ab.m7416i("MicroMsg.ExtControlProviderOpenApi", "getWifiList return cursor");
                                        C117761.this.mo10373cC(c6480fh.cyX.cyZ);
                                        AppMethodBeat.m2505o(20309);
                                    }
                                };
                                if (!C4879a.xxA.mo10055m(c6480fh)) {
                                    C4990ab.m7416i("MicroMsg.ExtControlProviderOpenApi", "getWifiList publish getWifiListEvent fail");
                                    mo10373cC(C40420a.m69330Kn(8));
                                }
                            } catch (Exception e) {
                                C4990ab.m7413e("MicroMsg.ExtControlProviderOpenApi", "exception in getWifiList syncTaskCur.", e);
                                mo10373cC(C40420a.m69330Kn(12));
                            }
                            AppMethodBeat.m2505o(CdnLogic.kMediaTypeNearEvent);
                            return null;
                        }
                    }.mo10372b(this.handler);
                    if (Kn == null) {
                        mo61881T(19, 4, 14);
                        Kn2 = C40420a.m69330Kn(14);
                        AppMethodBeat.m2505o(20316);
                        return Kn2;
                    }
                    mo61881T(18, 0, 1);
                    C4990ab.m7416i("MicroMsg.ExtControlProviderOpenApi", "returnMatrix syncTaskCur");
                    AppMethodBeat.m2505o(20316);
                    return Kn;
                case 38:
                    C4990ab.m7410d("MicroMsg.ExtControlProviderOpenApi", C19523a.NAME);
                    this.handler = new C7306ak(Looper.getMainLooper());
                    strArr3 = strArr2;
                    Integer num = (Integer) new C5039bj<Integer>() {
                        public final /* synthetic */ Object run() {
                            AppMethodBeat.m2504i(20314);
                            Integer amW = amW();
                            AppMethodBeat.m2505o(20314);
                            return amW;
                        }

                        private Integer amW() {
                            AppMethodBeat.m2504i(20313);
                            try {
                                C4990ab.m7410d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
                                final C32552fe c32552fe = new C32552fe();
                                c32552fe.cyA.version = C5046bo.getInt(strArr3[0], 0);
                                c32552fe.cyA.ssid = strArr3[1];
                                c32552fe.cyA.bssid = strArr3[2];
                                c32552fe.cyA.cyC = C5046bo.getInt(strArr3[3], 0);
                                c32552fe.callback = new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.m2504i(20312);
                                        C4990ab.m7416i("MicroMsg.ExtControlProviderOpenApi", "connectWifi run");
                                        if (c32552fe == null || c32552fe.cyB == null || c32552fe.cyB.cyD == 0) {
                                            AppMethodBeat.m2505o(20312);
                                            return;
                                        }
                                        C4990ab.m7417i("MicroMsg.ExtControlProviderOpenApi", "connectWifi errcode = %s,errmsg = %s", Integer.valueOf(c32552fe.cyB.cyE), c32552fe.cyB.cyF);
                                        C117782.this.mo10373cC(Integer.valueOf(c32552fe.cyB.cyE));
                                        AppMethodBeat.m2505o(20312);
                                    }
                                };
                                if (!C4879a.xxA.mo10055m(c32552fe)) {
                                    C4990ab.m7416i("MicroMsg.ExtControlProviderOpenApi", "connectWifi publish getWifiListEvent fail");
                                    mo10373cC(Integer.valueOf(8));
                                }
                            } catch (Exception e) {
                                C4990ab.m7413e("MicroMsg.ExtControlProviderOpenApi", "exception in connectWifi syncTaskInt.", e);
                                mo10373cC(Integer.valueOf(12));
                            }
                            Integer valueOf = Integer.valueOf(0);
                            AppMethodBeat.m2505o(20313);
                            return valueOf;
                        }
                    }.mo10372b(this.handler);
                    if (num == null) {
                        mo61881T(21, 4, 14);
                        Kn2 = C40420a.m69330Kn(14);
                        AppMethodBeat.m2505o(20316);
                        return Kn2;
                    }
                    mo61881T(20, 0, num.intValue());
                    Kn2 = C40420a.m69330Kn(num.intValue());
                    AppMethodBeat.m2505o(20316);
                    return Kn2;
                case 40:
                    C4990ab.m7416i("MicroMsg.ExtControlProviderOpenApi", "setSportStep start");
                    if (strArr2 == null || strArr2.length < 3) {
                        C4990ab.m7412e("MicroMsg.ExtControlProviderOpenApi", "args error: args length error");
                        mo61881T(23, 3, 2);
                        Kn2 = C40420a.m69330Kn(2);
                        AppMethodBeat.m2505o(20316);
                        return Kn2;
                    }
                    long j2 = C5046bo.getLong(strArr2[0], -1);
                    j = C5046bo.getLong(strArr2[1], -1);
                    long j3 = C5046bo.getLong(strArr2[2], -1);
                    C4990ab.m7417i("MicroMsg.ExtControlProviderOpenApi", "setSportStep: timestampe: %s, stepcount: %s,  version: %s", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
                    if (j < 0 || j2 < 0 || j3 < 0) {
                        C4990ab.m7416i("MicroMsg.ExtControlProviderOpenApi", "param err");
                        mo61881T(23, 3, 2);
                        Kn2 = C40420a.m69330Kn(2);
                        AppMethodBeat.m2505o(20316);
                        return Kn2;
                    }
                    brI();
                    C9345fp c9345fp = new C9345fp();
                    c9345fp.czu.action = 2;
                    c9345fp.czu.czw = j;
                    c9345fp.czu.czx = j2;
                    c9345fp.czu.baZ = j3;
                    if (C4879a.xxA.mo10055m(c9345fp) && c9345fp.czv.czz) {
                        mo61881T(22, 0, c9345fp.czv.czA);
                        Kn2 = C40420a.m69330Kn(c9345fp.czv.czA);
                        AppMethodBeat.m2505o(20316);
                        return Kn2;
                    }
                    mo61881T(23, 4, 8);
                    Kn2 = C40420a.m69330Kn(8);
                    AppMethodBeat.m2505o(20316);
                    return Kn2;
                case 41:
                    C4990ab.m7416i("MicroMsg.ExtControlProviderOpenApi", "getSportConfig start");
                    brI();
                    C9345fp c9345fp2 = new C9345fp();
                    c9345fp2.czu.action = 3;
                    if (C4879a.xxA.mo10055m(c9345fp2) && c9345fp2.czv.czz) {
                        str4 = c9345fp2.czv.czy;
                        Kn2 = new MatrixCursor(lPI);
                        Kn2.addRow(new Object[]{Integer.valueOf(c9345fp2.czv.czA), C5046bo.nullAsNil(str4)});
                        mo61881T(22, 0, c9345fp2.czv.czA);
                        C4990ab.m7417i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", Integer.valueOf(c9345fp2.czv.czA));
                        AppMethodBeat.m2505o(20316);
                        return Kn2;
                    }
                    mo61881T(23, 4, 8);
                    Kn2 = C40420a.m69330Kn(8);
                    AppMethodBeat.m2505o(20316);
                    return Kn2;
                case 42:
                    intent2 = new Intent();
                    intent2.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                    intent2.putExtra("key_from_scene", 4);
                    if (strArr2 == null || strArr2.length <= 0 || strArr2[0].length() <= 0) {
                        C4990ab.m7417i("MicroMsg.ExtControlProviderOpenApi", "openOffline appid:%s", str3);
                    } else {
                        C4990ab.m7417i("MicroMsg.ExtControlProviderOpenApi", "openOffline business_attach:%s,appid:%s", strArr2[0], str3);
                        intent2.putExtra("key_business_attach", strArr2[0]);
                    }
                    intent2.putExtra("key_appid", str3);
                    C25985d.m41467b(this.context, "offline", ".ui.WalletOfflineEntranceUI", intent2);
                    C7060h.pYm.mo8381e(12097, Integer.valueOf(9), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
                    mo61881T(24, 0, 1);
                    Kn2 = C40420a.m69330Kn(1);
                    AppMethodBeat.m2505o(20316);
                    return Kn2;
                case 46:
                    C4990ab.m7411d("MicroMsg.ExtControlProviderOpenApi", "openClean appid:%s", str3);
                    C9638aw.m17190ZK();
                    if (C18628c.isSDCardAvailable()) {
                        intent2 = new Intent();
                        intent2.putExtra("key_from_openapi", true);
                        intent2.putExtra("key_openapi_appid", str3);
                        C25985d.m41467b(this.context, "clean", ".ui.CleanUI", intent2);
                        mo61881T(26, 0, 1);
                        Kn2 = C40420a.m69330Kn(1);
                        AppMethodBeat.m2505o(20316);
                        return Kn2;
                    }
                    mo61881T(27, 5, 4);
                    Kn2 = C40420a.m69330Kn(4101);
                    AppMethodBeat.m2505o(20316);
                    return Kn2;
                case 48:
                    C27905e.brW().mContext = this.context;
                    if (strArr2 == null || strArr2.length <= 0) {
                        C4990ab.m7420w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
                        Kn2 = C40420a.m69330Kn(4201);
                        AppMethodBeat.m2505o(20316);
                        return Kn2;
                    }
                    int i3 = C5046bo.getInt(strArr2[0], -1);
                    if (i3 < 0 || !(i3 == 0 || i3 == 1 || i3 == 2)) {
                        C4990ab.m7420w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid command!");
                        mo61881T(32, 3, 2);
                        Kn2 = C40420a.m69330Kn(4201);
                        AppMethodBeat.m2505o(20316);
                        return Kn2;
                    }
                    str5 = null;
                    if (i3 != 0 && i3 != 1) {
                        str4 = null;
                    } else if (strArr2.length < 2) {
                        C4990ab.m7420w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length when check or open!");
                        Kn2 = C40420a.m69330Kn(4205);
                        AppMethodBeat.m2505o(20316);
                        return Kn2;
                    } else {
                        str3 = strArr2[1];
                        if (i3 != 1) {
                            str4 = str3;
                        } else if (strArr2.length < 3) {
                            C4990ab.m7420w("MicroMsg.ExtControlProviderOpenApi", "hy: not providing md5!");
                            Kn2 = C40420a.m69330Kn(4208);
                            AppMethodBeat.m2505o(20316);
                            return Kn2;
                        } else {
                            str5 = strArr2[2];
                            str4 = str3;
                        }
                    }
                    C4990ab.m7417i("MicroMsg.ExtControlProviderOpenApi", "hy: cmdid: %d, yuvHandle: %s", Integer.valueOf(i3), str4);
                    C27906a Lj;
                    switch (i3) {
                        case 0:
                            C27905e brW = C27905e.brW();
                            if (C5046bo.isNullOrNil(str4)) {
                                C4990ab.m7420w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleCheckQrCode");
                                C27905e.m44383Q(null, -1, 4205);
                                Kn2 = C40420a.m69330Kn(4205);
                                AppMethodBeat.m2505o(20316);
                                return Kn2;
                            }
                            C27906a c27906a;
                            Lj = C45907c.m85121Lj(str4);
                            if (Lj == null || C5046bo.isNullOrNil(Lj.url)) {
                                C38995b aH = C27905e.m44385aH(str4, false);
                                if (aH == null) {
                                    C4990ab.m7420w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleCheckQrCode");
                                    C27905e.m44383Q(null, -1, 4206);
                                    Kn2 = C40420a.m69330Kn(4206);
                                    AppMethodBeat.m2505o(20316);
                                    return Kn2;
                                }
                                Lj = brW.mo45807a(aH);
                                if (Lj == null || C5046bo.isNullOrNil(Lj.url)) {
                                    C4990ab.m7420w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
                                    Kn2 = C40420a.m69330Kn(4203);
                                    AppMethodBeat.m2505o(20316);
                                    return Kn2;
                                }
                                c27906a = Lj;
                            } else {
                                C4990ab.m7417i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", str4, Lj);
                                c27906a = Lj;
                            }
                            if (c27906a.type != 19) {
                                C4990ab.m7416i("MicroMsg.ExtQrCodeHandler", "hy: subapp code. can open");
                                Kn2 = C40420a.m69330Kn(1);
                                AppMethodBeat.m2505o(20316);
                                return Kn2;
                            } else if (C45907c.m85123Ll(c27906a.url)) {
                                C4990ab.m7417i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", c27906a.url.toUpperCase());
                                C27905e.m44383Q(c27906a.url, c27906a.type, 4207);
                                Kn2 = C40420a.aiv(c27906a.url);
                                AppMethodBeat.m2505o(20316);
                                return Kn2;
                            } else if (C45907c.m85122Lk(c27906a.url)) {
                                C4990ab.m7417i("MicroMsg.ExtQrCodeHandler", "hy: wechat can open: %s", c27906a.url);
                                C27905e.m44383Q(c27906a.url, c27906a.type, 1);
                                Kn2 = C40420a.m69330Kn(1);
                                AppMethodBeat.m2505o(20316);
                                return Kn2;
                            } else {
                                j = C5046bo.m7588yz();
                                C11773b Lm = C45907c.m85124Lm(c27906a.url);
                                C4990ab.m7417i("MicroMsg.ExtQrCodeHandler", "hy: resolve config: %s, using: %d ms", Lm.toString(), Long.valueOf(C5046bo.m7525az(j)));
                                if (Lm == C11773b.WHITE) {
                                    C45907c.m85119Lh(c27906a.url);
                                    C27905e.m44383Q(c27906a.url, c27906a.type, 1);
                                    Kn2 = C40420a.m69330Kn(1);
                                    AppMethodBeat.m2505o(20316);
                                    return Kn2;
                                }
                                if (Lm != C11773b.BLACK) {
                                    String str6 = c27906a.url;
                                    int i4 = c27906a.type;
                                    int i5 = c27906a.lRd;
                                    C4990ab.m7417i("MicroMsg.ExtQrCodeHandler", "hy: start remote judge url: %s", str6);
                                    long currentTimeMillis = System.currentTimeMillis();
                                    C4990ab.m7417i("MicroMsg.ExtQrCodeHandler", "hy: can open: %b, using %d ms", (Boolean) new C68892(Boolean.TRUE, str6, i4, i5).mo10372b(C27905e.brY()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    if (((Boolean) new C68892(Boolean.TRUE, str6, i4, i5).mo10372b(C27905e.brY())).booleanValue()) {
                                        C45907c.m85119Lh(c27906a.url);
                                        C27905e.m44383Q(c27906a.url, c27906a.type, 1);
                                        Kn2 = C40420a.m69330Kn(1);
                                        AppMethodBeat.m2505o(20316);
                                        return Kn2;
                                    }
                                }
                                C45907c.m85120Li(c27906a.url);
                                C4990ab.m7421w("MicroMsg.ExtQrCodeHandler", "hy: remote wechat cannot open: %s", c27906a.url);
                                C27905e.m44383Q(c27906a.url, c27906a.type, 4207);
                                Kn2 = C40420a.aiv(c27906a.url);
                                AppMethodBeat.m2505o(20316);
                                return Kn2;
                            }
                        case 1:
                            C27905e brW2 = C27905e.brW();
                            if (C5046bo.isNullOrNil(str4)) {
                                C4990ab.m7420w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleOpenQrCode");
                                C27905e.m44384R(null, -1, 4205);
                                Kn2 = C40420a.m69330Kn(4205);
                                AppMethodBeat.m2505o(20316);
                                return Kn2;
                            }
                            C27906a Lj2 = C45907c.m85121Lj(str4);
                            if (Lj2 != null && !C5046bo.isNullOrNil(Lj2.url)) {
                                C4990ab.m7417i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", str4, Lj2);
                                Lj = Lj2;
                            } else if (C5046bo.isNullOrNil(str5)) {
                                C4990ab.m7420w("MicroMsg.ExtQrCodeHandler", "hy: md5 not correct!!");
                                C27905e.m44384R(null, -1, 4208);
                                Kn2 = C40420a.m69330Kn(4208);
                                AppMethodBeat.m2505o(20316);
                                return Kn2;
                            } else {
                                C38995b aH2 = C27905e.m44385aH(str4, true);
                                if (aH2 == null) {
                                    C4990ab.m7420w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleOpenQrCode");
                                    C27905e.m44384R(null, -1, 4206);
                                    Kn2 = C40420a.m69330Kn(4206);
                                    AppMethodBeat.m2505o(20316);
                                    return Kn2;
                                } else if (C5046bo.isNullOrNil(aH2.cvZ)) {
                                    C4990ab.m7420w("MicroMsg.ExtQrCodeHandler", "hy: cannot retrieve md5 from yuv!");
                                    C27905e.m44384R(null, -1, 4210);
                                    Kn2 = C40420a.m69330Kn(4210);
                                    AppMethodBeat.m2505o(20316);
                                    return Kn2;
                                } else if (aH2.cvZ.equalsIgnoreCase(str5)) {
                                    Lj = brW2.mo45807a(aH2);
                                    if (Lj == null || C5046bo.isNullOrNil(Lj.url)) {
                                        C4990ab.m7420w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
                                        C27905e.m44384R(null, -1, 4203);
                                        Kn2 = C40420a.m69330Kn(4203);
                                        AppMethodBeat.m2505o(20316);
                                        return Kn2;
                                    }
                                    C45907c.m85125a(str4, Lj);
                                } else {
                                    C4990ab.m7420w("MicroMsg.ExtQrCodeHandler", "hy: yuv data not match!!");
                                    C27905e.m44384R(null, -1, 4209);
                                    Kn2 = C40420a.m69330Kn(4209);
                                    AppMethodBeat.m2505o(20316);
                                    return Kn2;
                                }
                            }
                            if (Lj.type == 19 && C45907c.m85123Ll(Lj.url)) {
                                C4990ab.m7417i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", Lj.url);
                                C27905e.m44384R(Lj.url, Lj.type, 4207);
                                Kn2 = C40420a.m69330Kn(4207);
                                AppMethodBeat.m2505o(20316);
                                return Kn2;
                            }
                            C4990ab.m7416i("MicroMsg.ExtQrCodeHandler", "hy: do open");
                            C4990ab.m7417i("MicroMsg.ExtQrCodeHandler", "hy: start open: %s", Lj.toString());
                            intent = new Intent(brW2.mContext, RedirectToQrCodeStubUI.class);
                            intent.putExtra("K_STR", Lj.url);
                            intent.putExtra("K_TYPE", Lj.type);
                            intent.putExtra("K_VERSION", Lj.lRd);
                            intent.addFlags(268435456);
                            brW2.mContext.startActivity(intent);
                            C27905e.m44384R(Lj.url, Lj.type, 1);
                            Kn2 = C40420a.m69330Kn(1);
                            AppMethodBeat.m2505o(20316);
                            return Kn2;
                        case 2:
                            C27905e.brW();
                            Kn2 = C27905e.brX();
                            AppMethodBeat.m2505o(20316);
                            return Kn2;
                        default:
                            AppMethodBeat.m2505o(20316);
                            return null;
                    }
                case 51:
                    Kn2 = ExtControlProviderOpenApi.m19612q(strArr2);
                    AppMethodBeat.m2505o(20316);
                    return Kn2;
                case 52:
                    Kn2 = m19611p(strArr2);
                    AppMethodBeat.m2505o(20316);
                    return Kn2;
                default:
                    mo61889dZ(3, 15);
                    AppMethodBeat.m2505o(20316);
                    return null;
            }
        } else {
            C4990ab.m7412e("MicroMsg.ExtControlProviderOpenApi", "not login return code = 3");
            mo61889dZ(1, 3);
            Kn2 = C40420a.m69330Kn(3);
            AppMethodBeat.m2505o(20316);
            return Kn2;
        }
    }

    /* renamed from: p */
    private Cursor m19611p(String[] strArr) {
        AppMethodBeat.m2504i(20317);
        if (strArr == null || strArr.length == 0) {
            C4990ab.m7420w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
            MatrixCursor Kn = C40420a.m69330Kn(2);
            AppMethodBeat.m2505o(20317);
            return Kn;
        }
        Cursor Kn2;
        try {
            int parseInt = Integer.parseInt(strArr[0]);
            if (1 == parseInt) {
                try {
                    int parseInt2 = Integer.parseInt(strArr[1]);
                    if (1 == parseInt2 || 2 == parseInt2) {
                        ((C10733b) C1720g.m3528K(C10733b.class)).mo22284F(this.context, parseInt2);
                    } else {
                        Kn2 = C40420a.m69330Kn(2);
                        AppMethodBeat.m2505o(20317);
                        return Kn2;
                    }
                } catch (NumberFormatException e) {
                    C4990ab.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", e, "", new Object[0]);
                    Kn2 = C40420a.m69330Kn(2);
                    AppMethodBeat.m2505o(20317);
                    return Kn2;
                }
            } else if (2 == parseInt) {
                ((C10733b) C1720g.m3528K(C10733b.class)).mo22285cX(this.context);
            } else {
                Kn2 = C40420a.m69330Kn(2);
                AppMethodBeat.m2505o(20317);
                return Kn2;
            }
            Kn2 = C40420a.m69330Kn(1);
            AppMethodBeat.m2505o(20317);
            return Kn2;
        } catch (NumberFormatException e2) {
            C4990ab.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", e2, "", new Object[0]);
            Kn2 = C40420a.m69330Kn(2);
            AppMethodBeat.m2505o(20317);
            return Kn2;
        }
    }

    /* renamed from: q */
    private static Cursor m19612q(String[] strArr) {
        AppMethodBeat.m2504i(20318);
        if (strArr == null || strArr.length < 2) {
            C4990ab.m7420w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
            MatrixCursor Kn = C40420a.m69330Kn(2);
            AppMethodBeat.m2505o(20318);
            return Kn;
        }
        MatrixCursor matrixCursor = new MatrixCursor(lPM);
        try {
            int parseInt = Integer.parseInt(strArr[0]);
            int parseInt2 = Integer.parseInt(strArr[1]);
            List list = null;
            if (1 == parseInt) {
                list = ((C26767ag) C1720g.m3528K(C26767ag.class)).mo44540nA(parseInt2);
            } else if (2 == parseInt) {
                list = ((C10118af) C1720g.m3528K(C10118af.class)).mo21470a(parseInt2, null);
            }
            for (LocalUsageInfo localUsageInfo : C37400c.m63004C(list)) {
                WxaAttributes zc = ((C42686d) C1720g.m3528K(C42686d.class)).mo44619zc(localUsageInfo.appId);
                if (zc != null) {
                    String[] strArr2 = new String[]{zc.field_roundedSquareIconURL, zc.field_brandIconURL, zc.field_bigHeadURL};
                    C45444a c45444a = (C45444a) C1720g.m3528K(C45444a.class);
                    String packageName = C4996ah.getPackageName();
                    parseInt2 = localUsageInfo.har;
                    String str = zc.field_username;
                    String str2 = zc.field_nickname;
                    String str3 = zc.field_appId;
                    C1720g.m3534RN();
                    Intent a = c45444a.mo45003a(packageName, parseInt2, str, str2, strArr2, str3, C1668a.m3383QF(), 3);
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
                            objArr[10] = new C41726i(hashMap).toString();
                            matrixCursor.addRow(objArr);
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(20318);
            return matrixCursor;
        } catch (NumberFormatException e) {
            C4990ab.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", e, "", new Object[0]);
            Cursor Kn2 = C40420a.m69330Kn(2);
            AppMethodBeat.m2505o(20318);
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

    /* renamed from: m */
    private Cursor m19610m(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(20319);
        C4990ab.m7417i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver, op = %s", str);
        Cursor Kn;
        if (this.context == null) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderOpenApi", "context == null return code = 2001");
            mo61889dZ(4, 2001);
            MatrixCursor Kn2 = C40420a.m69330Kn(2001);
            AppMethodBeat.m2505o(20319);
            return Kn2;
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderOpenApi", "wrong args, op is null return code = 2002");
            mo61889dZ(3, 2002);
            Kn = C40420a.m69330Kn(2002);
            AppMethodBeat.m2505o(20319);
            return Kn;
        } else {
            int i = -1;
            try {
                i = C5046bo.getInt(str, -1);
            } catch (Exception e) {
            }
            if (i == 1) {
                Kn = m19609P(str2, str3, str4);
                AppMethodBeat.m2505o(20319);
                return Kn;
            } else if (i == 2) {
                C4990ab.m7410d("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener");
                if (C6875b.brA().apN(this.lPW) == null) {
                    C4990ab.m7421w("MicroMsg.ExtControlProviderOpenApi", "This app never been registered, appId = %s, pkg = %s", this.lPW, brL());
                    Kn = C40420a.m69330Kn(TXLiveConstants.PLAY_EVT_PLAY_LOADING);
                    AppMethodBeat.m2505o(20319);
                    return Kn;
                }
                boolean z;
                C30298bp brA = C6875b.brA();
                String str5 = this.lPW;
                if (str5 == null || str5.length() <= 0) {
                    z = false;
                } else {
                    if (brA.bSd.delete("OpenMsgListener", "appId=?", new String[]{C5046bo.m7586vA(str5)}) <= 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                }
                C4990ab.m7417i("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener ret = %s, appId = %s, pkg = %s", Boolean.valueOf(z), this.lPW, brL());
                if (z) {
                    mo61881T(0, 0, 1);
                    Kn = C40420a.m69330Kn(1);
                    AppMethodBeat.m2505o(20319);
                    return Kn;
                }
                Kn = C40420a.m69330Kn(2008);
                AppMethodBeat.m2505o(20319);
                return Kn;
            } else {
                C4990ab.m7413e("MicroMsg.ExtControlProviderOpenApi", "wrong args, no such op, %s", Integer.valueOf(i));
                mo61889dZ(3, 2003);
                Kn = C40420a.m69330Kn(2003);
                AppMethodBeat.m2505o(20319);
                return Kn;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0124  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: P */
    private Cursor m19609P(String str, String str2, String str3) {
        Exception e;
        AppMethodBeat.m2504i(20320);
        C4990ab.m7416i("MicroMsg.ExtControlProviderOpenApi", "doRegisterMsgListener");
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3)) {
            C4990ab.m7413e("MicroMsg.ExtControlProviderOpenApi", "wrong args, scene = %s, msgType = %s, msgState = %s", str, str2, str3);
            mo61889dZ(3, 2004);
            MatrixCursor Kn = C40420a.m69330Kn(2004);
            AppMethodBeat.m2505o(20320);
            return Kn;
        }
        MatrixCursor matrixCursor = null;
        Cursor Kn2;
        try {
            int parseInt = Integer.parseInt(str3);
            int parseInt2 = Integer.parseInt(str);
            int parseInt3 = Integer.parseInt(str2);
            if (parseInt != 2) {
                C4990ab.m7412e("MicroMsg.ExtControlProviderOpenApi", "wrong msgState: ".concat(String.valueOf(parseInt)));
                mo61889dZ(3, TXLiveConstants.PLAY_EVT_PLAY_PROGRESS);
                Kn2 = C40420a.m69330Kn(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS);
                AppMethodBeat.m2505o(20320);
                return Kn2;
            }
            if (C6875b.brA().apN(this.lPW) == null) {
                boolean z;
                C23511bo c23511bo = new C23511bo();
                c23511bo.field_appId = this.lPW;
                c23511bo.field_packageName = brL();
                String str4 = this.lPW;
                if (C5046bo.isNullOrNil(str4)) {
                    z = false;
                } else {
                    z = C46494g.m87752k(C46494g.m87739bT(str4, true));
                }
                if (z) {
                    c23511bo.field_status = 1;
                } else {
                    c23511bo.field_status = 0;
                }
                c23511bo.field_sceneFlag = parseInt2;
                c23511bo.field_msgTypeFlag = parseInt3;
                c23511bo.field_msgState = parseInt;
                C4990ab.m7417i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver ret = %s, pkgName = %s, scene = %s, msgType = %s, msgState = %s, appStatus = %s", Boolean.valueOf(C6875b.brA().mo10101b((C4925c) c23511bo)), brL(), Integer.valueOf(parseInt2), Integer.valueOf(parseInt), Integer.valueOf(parseInt), Integer.valueOf(c23511bo.field_status));
                if (!C6875b.brA().mo10101b((C4925c) c23511bo)) {
                    Kn2 = C40420a.m69330Kn(TXLiveConstants.PLAY_EVT_PLAY_END);
                    AppMethodBeat.m2505o(20320);
                    return Kn2;
                }
            }
            C4990ab.m7421w("MicroMsg.ExtControlProviderOpenApi", "This app had already been registered, appId = %s, pkg = %s", this.lPW, brL());
            StringBuilder append = new StringBuilder().append(C1853r.m3846Yz());
            C9638aw.m17190ZK();
            String ck = C4995ag.m7428ck(append.append(C18628c.m29064QF()).toString());
            Kn2 = new MatrixCursor(lPH);
            try {
                Kn2.addRow(new Object[]{Integer.valueOf(1), C5046bo.nullAsNil(ck)});
                mo61881T(0, 0, 1);
                C4990ab.m7417i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", Integer.valueOf(1));
                AppMethodBeat.m2505o(20320);
                return Kn2;
            } catch (Exception e2) {
                e = e2;
                Cursor matrixCursor2 = Kn2;
                mo61881T(1, 4, 12);
                C4990ab.m7413e("MicroMsg.ExtControlProviderOpenApi", "exception in doRegisterMsgListener, %s", e.getMessage());
                if (matrixCursor2 != null) {
                    matrixCursor2.close();
                }
                Kn2 = C40420a.m69330Kn(12);
                AppMethodBeat.m2505o(20320);
                return Kn2;
            }
        } catch (Exception e3) {
            e = e3;
            mo61881T(1, 4, 12);
            C4990ab.m7413e("MicroMsg.ExtControlProviderOpenApi", "exception in doRegisterMsgListener, %s", e.getMessage());
            if (matrixCursor2 != null) {
            }
            Kn2 = C40420a.m69330Kn(12);
            AppMethodBeat.m2505o(20320);
            return Kn2;
        }
    }

    /* renamed from: r */
    private Cursor m19613r(String[] strArr) {
        AppMethodBeat.m2504i(CdnLogic.kMediaTypeSmartHwPage);
        C4990ab.m7416i("MicroMsg.ExtControlProviderOpenApi", "getUserAvatarByOpenId");
        if (strArr == null || strArr.length <= 0) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderOpenApi", "wrong args");
            mo61889dZ(3, 3001);
            MatrixCursor Kn = C40420a.m69330Kn(3001);
            AppMethodBeat.m2505o(CdnLogic.kMediaTypeSmartHwPage);
            return Kn;
        }
        Cursor matrixCursor = new MatrixCursor(lPJ);
        int i = 0;
        while (i < strArr.length && i < 5) {
            try {
                if (!C5046bo.isNullOrNil(strArr[i])) {
                    C23512bz apZ = C6875b.brB().apZ(strArr[i]);
                    if (apZ == null || C5046bo.isNullOrNil(apZ.field_openId) || C5046bo.isNullOrNil(apZ.field_username)) {
                        C4990ab.m7412e("MicroMsg.ExtControlProviderOpenApi", "openidInApp is null");
                    } else {
                        C9638aw.m17190ZK();
                        C7616ad aoO = C18628c.m29078XM().aoO(apZ.field_username);
                        if (aoO == null || aoO.field_username == null || aoO.field_username.length() <= 0) {
                            C4990ab.m7412e("MicroMsg.ExtControlProviderOpenApi", "contact is null");
                        } else {
                            C17884o.acd();
                            String D = C41732d.m73515D(aoO.field_username, false);
                            if (C5046bo.isNullOrNil(D)) {
                                C4990ab.m7420w("MicroMsg.ExtControlProviderOpenApi", "hy: get avatar sfs path is null or nil");
                            } else {
                                String str;
                                if (D.startsWith(C1720g.m3536RP().cachePath)) {
                                    str = C1720g.m3536RP().eJM + D.substring(C1720g.m3536RP().cachePath.length());
                                    C5730e.m8643tf(C5730e.atb(str));
                                    C5730e.m8644y(D, str);
                                } else {
                                    str = D;
                                }
                                C1195b.m2628qk(str);
                                matrixCursor.addRow(new Object[]{strArr[i], str});
                            }
                        }
                    }
                }
                i++;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.ExtControlProviderOpenApi", "Exception occur, %s", e.getMessage());
                mo61881T(7, 4, 12);
                matrixCursor.close();
                matrixCursor = C40420a.m69330Kn(12);
                AppMethodBeat.m2505o(CdnLogic.kMediaTypeSmartHwPage);
                return matrixCursor;
            }
        }
        mo61881T(6, 0, 1);
        AppMethodBeat.m2505o(CdnLogic.kMediaTypeSmartHwPage);
        return matrixCursor;
    }

    /* renamed from: s */
    private Cursor m19614s(String[] strArr) {
        AppMethodBeat.m2504i(CdnLogic.kMediaTypeHWDevice);
        C4990ab.m7416i("MicroMsg.ExtControlProviderOpenApi", "decodeVoice");
        MatrixCursor Kn;
        if (strArr == null || strArr.length <= 0 || strArr[0].length() <= 0) {
            C4990ab.m7412e("MicroMsg.ExtControlProviderOpenApi", "decodeVoice wrong args");
            mo61889dZ(3, 3101);
            Kn = C40420a.m69330Kn(3101);
            AppMethodBeat.m2505o(CdnLogic.kMediaTypeHWDevice);
            return Kn;
        }
        Kn = null;
        int i = 0;
        while (i < 5 && i < strArr.length) {
            String str = strArr[i];
            try {
                if (C32848o.m53698i(str, 0, true)) {
                    String str2;
                    if (Kn == null) {
                        Kn = new MatrixCursor(lPK);
                    }
                    C9732i c9732i = new C9732i();
                    String str3 = C6875b.brD() + "/" + C4995ag.m7428ck(str);
                    C4990ab.m7417i("MicroMsg.ExtControlProviderOpenApi", "summerpcm pcmPath[%s]", str3);
                    if (C5730e.asZ(str3) > 0) {
                        C4990ab.m7410d("MicroMsg.ExtControlProviderOpenApi", "pcm already exist");
                        str2 = str3;
                    } else {
                        str2 = c9732i.mo21078aX(str, str3);
                    }
                    if (C5730e.asZ(str3) == 0) {
                        str2 = c9732i.mo21078aX(str, str3);
                    }
                    if (C5046bo.isNullOrNil(str2)) {
                        C4990ab.m7420w("MicroMsg.ExtControlProviderOpenApi", "wrong args targetFilePath is null");
                    } else {
                        C4990ab.m7411d("MicroMsg.ExtControlProviderOpenApi", "decode to pcm success %d", Integer.valueOf(i));
                        Kn.addRow(new Object[]{Integer.valueOf(1), Integer.valueOf(c9732i.mSampleRate), Integer.valueOf(c9732i.cpQ), Integer.valueOf(2), str2});
                    }
                } else {
                    C4990ab.m7421w("MicroMsg.ExtControlProviderOpenApi", "wrong args : %s", strArr[i]);
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.ExtControlProviderOpenApi", "Exception in decodeVoice, %s", e.getMessage());
            }
            i++;
        }
        if (Kn != null) {
            mo61881T(8, 0, 1);
            AppMethodBeat.m2505o(CdnLogic.kMediaTypeHWDevice);
            return Kn;
        }
        mo61881T(9, 3, 4);
        Cursor Kn2 = C40420a.m69330Kn(4);
        AppMethodBeat.m2505o(CdnLogic.kMediaTypeHWDevice);
        return Kn2;
    }

    private void brI() {
        AppMethodBeat.m2504i(20323);
        String str = (String) C6875b.brz().get(C5127a.USERINFO_EXT_SPORT_PKGNAME_STRING, null);
        C4990ab.m7417i("MicroMsg.ExtControlProviderOpenApi", "setSportBroadPkg: pkgNames: %s, pkg: %s", str, brL());
        if (str != null) {
            if (!C32473a.contains(str.split(";"), r1)) {
                C6875b.brz().set(C5127a.USERINFO_EXT_SPORT_PKGNAME_STRING, str + ";" + brL());
            }
            AppMethodBeat.m2505o(20323);
            return;
        }
        C6875b.brz().set(C5127a.USERINFO_EXT_SPORT_PKGNAME_STRING, brL());
        AppMethodBeat.m2505o(20323);
    }
}
