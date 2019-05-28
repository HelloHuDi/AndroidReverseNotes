package com.tencent.mm.plugin.base.stub;

import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Looper;
import android.os.Process;
import com.facebook.appevents.AppEventsConstants;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.g.a.bl;
import com.tencent.mm.g.a.ce;
import com.tencent.mm.g.a.fc;
import com.tencent.mm.g.a.fd;
import com.tencent.mm.g.a.fj;
import com.tencent.mm.g.a.il;
import com.tencent.mm.g.a.ph;
import com.tencent.mm.g.a.pi;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.g.a.pk;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.v;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.account.ui.LoginUI;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.a;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.d;
import org.xwalk.core.XWalkEnvironment;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class WXCommProvider extends ContentProvider {
    public static final String jDL = (ah.getPackageName() + "_comm_preferences");
    private static final String[] jDM = new String[]{DownloadInfoColumns.PACKAGENAME, "data"};
    private static final UriMatcher jDO = new UriMatcher(-1);
    private static volatile boolean jDP = false;
    protected static boolean jDQ = false;
    private static final Object lock = new Object();
    private SharedPreferences ehZ;
    private ak handler;
    protected MatrixCursor jDN = new MatrixCursor(new String[0]);

    public WXCommProvider() {
        AppMethodBeat.i(18172);
        AppMethodBeat.o(18172);
    }

    static {
        AppMethodBeat.i(18180);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "pref", 1);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "openQRCodeScan", 18);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "batchAddShortcut", 19);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "getUnreadCount", 20);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "jumpToBizProfile", 21);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "jumpToBizTempSession", 27);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "registerMsgListener", 22);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "getAvatar", 23);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "regWatchAppId", 24);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "decodeVoice", 25);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "addCardToWX", 26);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "unReadMsgs", 9);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "to_chatting", 3);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "setReaded", 13);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "voiceControl", 29);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "openRankList", 28);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "openWebview", 30);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "openBusiLuckyMoney", 31);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "createChatroom", 32);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "joinChatroom", 33);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "sendSight", 34);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "redirectToChattingByPhoneNumber", 35);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "redirectToWechatOutByPhoneNumber", 36);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", c.NAME, 37);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", a.NAME, 38);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "chooseCardFromWX", 39);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "openOfflinePay", 42);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "setWechatSportStep", 40);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "getWechatSportConfig", 41);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "handleScanResult", 44);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "openTypeWebview", 45);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "openCleanUI", 46);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "launchWXMiniprogram", 47);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", com.tencent.mm.plugin.appbrand.jsapi.fakenative.c.NAME, 53);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "genTokenForOpenSdk", 43);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "qrcodeEvent", 48);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "jumpToOfflinePay", 49);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "openBusinessWebview", 50);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "getWxaInfo", 51);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "openWxaDesktopOrWxaMyFavorite", 52);
        AppMethodBeat.o(18180);
    }

    public boolean onCreate() {
        AppMethodBeat.i(18173);
        ab.d("MicroMsg.WXCommProvider", "onCreate");
        this.handler = new ak();
        ab.i("MicroMsg.WXCommProvider", "pid = " + Process.myPid() + ", tid : = " + Process.myTid());
        this.ehZ = getContext().getSharedPreferences(jDL, 0);
        getContext().registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                ao aoVar;
                AppMethodBeat.i(18162);
                if (System.currentTimeMillis() - ao.vdh >= 600000) {
                    ab.e("MicroMsg.AppUtil", "hy: get comm model time expired");
                    aoVar = null;
                } else {
                    aoVar = ao.vdg;
                }
                if (aoVar != null) {
                    ab.i("MicroMsg.WXCommProvider", "hy: has wxcomm query request. start to continue requesting");
                    Cursor a = WXCommProvider.this.a(aoVar.uri, aoVar.projection, aoVar.selection, aoVar.selectionArgs, aoVar.vde, aoVar.code, aoVar.vdf);
                    if (a != null) {
                        a.close();
                    }
                    p.dhH();
                }
                AppMethodBeat.o(18162);
            }
        }, new IntentFilter(ConstantsAPI.ACTION_REFRESH_WXAPP));
        if (this.ehZ != null) {
            AppMethodBeat.o(18173);
            return true;
        }
        AppMethodBeat.o(18173);
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(18174);
        ab.i("MicroMsg.WXCommProvider", "uri:%s", uri);
        if (uri == null) {
            ab.e("MicroMsg.WXCommProvider", "query fail, uri is null return null");
            AppMethodBeat.o(18174);
            return null;
        }
        String[] aVj = aVj();
        if (aVj == null || aVj.length <= 0) {
            ab.e("MicroMsg.WXCommProvider", "CallingPackages is null return null");
            AppMethodBeat.o(18174);
            return null;
        }
        int match = jDO.match(uri);
        if (WorkerProfile.Ca() == null || !WorkerProfile.Ca().cfM) {
            new ap(Looper.getMainLooper(), new ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(18163);
                    if (com.tencent.mm.sdk.b.a.xxA == null || !com.tencent.mm.sdk.b.a.xxA.av(fc.class)) {
                        AppMethodBeat.o(18163);
                        return true;
                    }
                    synchronized (WXCommProvider.lock) {
                        try {
                            ab.i("MicroMsg.WXCommProvider", "The lock was released.");
                            WXCommProvider.jDP = true;
                            WXCommProvider.lock.notifyAll();
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(18163);
                        }
                    }
                    return false;
                }
            }, true).ae(50, 50);
            try {
                synchronized (lock) {
                    ab.i("MicroMsg.WXCommProvider", "Lock to wait for the first initialize of the Application.");
                    while (!jDP) {
                        lock.wait();
                    }
                    jDP = false;
                }
            } catch (InterruptedException e) {
                ab.e("MicroMsg.WXCommProvider", "the lock may have some problem," + e.getMessage());
                ab.printErrStackTrace("MicroMsg.WXCommProvider", e, "", new Object[0]);
            } catch (Throwable th) {
                AppMethodBeat.o(18174);
            }
        }
        Cursor a = a(uri, strArr, str, strArr2, str2, match, aVj);
        AppMethodBeat.o(18174);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0220  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, int i, String[] strArr3) {
        AppMethodBeat.i(18175);
        Cursor cursor;
        fc fcVar;
        ce ceVar;
        switch (i) {
            case 3:
            case 9:
            case 13:
            case 22:
            case 23:
            case 25:
            case 29:
            case 34:
            case 35:
            case 36:
            case g.CTRL_INDEX /*37*/:
            case 38:
            case 40:
            case 41:
            case 42:
            case 46:
            case 48:
            case 51:
            case 52:
                long currentTimeMillis = System.currentTimeMillis();
                if (aVl()) {
                    fj fjVar = new fj();
                    fjVar.czd.cyy = i;
                    fjVar.czd.uri = uri;
                    fjVar.czd.selectionArgs = strArr2;
                    fjVar.czd.context = getContext();
                    fjVar.czd.crW = strArr3;
                    if (com.tencent.mm.sdk.b.a.xxA.m(fjVar)) {
                        ab.i("MicroMsg.WXCommProvider", "[extApiCost] total cost = %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        cursor = fjVar.cze.cyz;
                        AppMethodBeat.o(18175);
                        return cursor;
                    }
                    ab.e("MicroMsg.WXCommProvider", "ExtCallEvent fail return code = 8");
                    cursor = new MatrixCursor(b.lPA);
                    cursor.addRow(new Object[]{Integer.valueOf(8)});
                    AppMethodBeat.o(18175);
                    return cursor;
                }
                String nullAsNil = bo.nullAsNil(uri.getQueryParameter("appid"));
                if ("1".equals(bo.bc(uri.getQueryParameter("autoLogin"), AppEventsConstants.EVENT_PARAM_VALUE_NO))) {
                    ab.i("MicroMsg.WXCommProvider", "hy: not login. try to login return code = 9");
                    ao.vdg = new ao(uri, strArr, str, strArr2, str2, i, strArr3);
                    ao.vdh = System.currentTimeMillis();
                    Intent intent = new Intent(getContext(), LoginUI.class);
                    intent.addFlags(268435456);
                    getContext().startActivity(intent);
                    cursor = new MatrixCursor(b.lPA);
                    cursor.addRow(new Object[]{Integer.valueOf(9)});
                    AppMethodBeat.o(18175);
                    return cursor;
                }
                ab.i("MicroMsg.WXCommProvider", "not login, appID = %s, apiID = %s return code =%s ", nullAsNil, Integer.valueOf(i), Integer.valueOf(3));
                h.pYm.e(10505, bo.nullAsNil(strArr3[0]), nullAsNil, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                cursor = new MatrixCursor(b.lPA);
                cursor.addRow(new Object[]{Integer.valueOf(3)});
                AppMethodBeat.o(18175);
                return cursor;
            case 18:
            case 19:
            case 20:
                if (aVk()) {
                    fd fdVar = new fd();
                    fdVar.cyw.cyy = i;
                    fdVar.cyw.uri = uri;
                    fdVar.cyw.selectionArgs = strArr2;
                    fdVar.cyw.context = getContext();
                    fdVar.cyw.crW = strArr3;
                    if (com.tencent.mm.sdk.b.a.xxA.m(fdVar)) {
                        cursor = fdVar.cyx.cyz;
                        AppMethodBeat.o(18175);
                        return cursor;
                    }
                    ab.e("MicroMsg.WXCommProvider", "ExtCallEvent fail");
                    AppMethodBeat.o(18175);
                    return null;
                }
                AppMethodBeat.o(18175);
                return null;
            case 21:
                fcVar = new fc();
                fcVar.cyu.op = 21;
                fcVar.cyu.cvd = 1;
                fcVar.cyu.selectionArgs = strArr2;
                fcVar.cyu.context = getContext();
                fcVar.cyu.crW = strArr3;
                if (!com.tencent.mm.sdk.b.a.xxA.m(fcVar)) {
                    ab.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                AppMethodBeat.o(18175);
                return null;
            case 24:
                if (aVk()) {
                    vf vfVar = new vf();
                    vfVar.cSc.cyy = i;
                    vfVar.cSc.uri = uri;
                    vfVar.cSc.context = getContext();
                    for (int i2 = 0; i2 < strArr3.length; i2++) {
                        if (strArr3[i2] != null) {
                            vfVar.cSc.callingPackage = strArr3[i2];
                            if (com.tencent.mm.sdk.b.a.xxA.m(vfVar)) {
                                ab.e("MicroMsg.WXCommProvider", "WatchAppIdRegEvent fail");
                                AppMethodBeat.o(18175);
                                return null;
                            }
                            cursor = vfVar.cSd.cyz;
                            AppMethodBeat.o(18175);
                            return cursor;
                        }
                    }
                    if (com.tencent.mm.sdk.b.a.xxA.m(vfVar)) {
                    }
                } else {
                    cursor = this.jDN;
                    AppMethodBeat.o(18175);
                    return cursor;
                }
            case 26:
                com.tencent.mm.g.a.g gVar = new com.tencent.mm.g.a.g();
                gVar.crV.selectionArgs = strArr2;
                gVar.crV.crW = strArr3;
                gVar.crV.context = getContext();
                if (!com.tencent.mm.sdk.b.a.xxA.m(gVar)) {
                    ab.e("MicroMsg.WXCommProvider", "add card to wx fail");
                }
                AppMethodBeat.o(18175);
                return null;
            case 27:
                if (strArr2 == null || strArr2.length < 2) {
                    ab.e("MicroMsg.WXCommProvider", "wrong args");
                    AppMethodBeat.o(18175);
                    return null;
                }
                fcVar = new fc();
                fcVar.cyu.op = 27;
                fcVar.cyu.cvd = 1;
                fcVar.cyu.selectionArgs = strArr2;
                fcVar.cyu.context = getContext();
                fcVar.cyu.crW = strArr3;
                if (!com.tencent.mm.sdk.b.a.xxA.m(fcVar)) {
                    ab.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                AppMethodBeat.o(18175);
                return null;
            case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                fcVar = new fc();
                fcVar.cyu.op = i;
                fcVar.cyu.selectionArgs = strArr2;
                fcVar.cyu.context = getContext();
                fcVar.cyu.crW = strArr3;
                if (!com.tencent.mm.sdk.b.a.xxA.m(fcVar)) {
                    ab.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                AppMethodBeat.o(18175);
                return null;
            case 30:
            case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                pk pkVar = new pk();
                pkVar.cLC.selectionArgs = strArr2;
                pkVar.cLC.crW = strArr3;
                pkVar.cLC.context = getContext();
                pkVar.cLC.cLD = i == 45;
                if (i == 30 && strArr2 != null && strArr2.length > 2) {
                    e.vao = strArr2[2];
                }
                if (!com.tencent.mm.sdk.b.a.xxA.m(pkVar)) {
                    ab.e("MicroMsg.WXCommProvider", "open webview fail");
                }
                AppMethodBeat.o(18175);
                return null;
            case 31:
                pi piVar = new pi();
                piVar.cLA.selectionArgs = strArr2;
                piVar.cLA.crW = strArr3;
                piVar.cLA.context = getContext();
                if (!com.tencent.mm.sdk.b.a.xxA.m(piVar)) {
                    ab.e("MicroMsg.WXCommProvider", "open busi luckymoney fail");
                }
                AppMethodBeat.o(18175);
                return null;
            case 32:
                ceVar = new ce();
                ceVar.cvl.action = 1;
                ceVar.cvl.selectionArgs = strArr2;
                ceVar.cvl.crW = strArr3;
                ceVar.cvl.context = getContext();
                if (!com.tencent.mm.sdk.b.a.xxA.m(ceVar)) {
                    ab.e("MicroMsg.WXCommProvider", "open webview fail");
                }
                AppMethodBeat.o(18175);
                return null;
            case 33:
                ceVar = new ce();
                ceVar.cvl.action = 2;
                ceVar.cvl.selectionArgs = strArr2;
                ceVar.cvl.crW = strArr3;
                ceVar.cvl.context = getContext();
                if (!com.tencent.mm.sdk.b.a.xxA.m(ceVar)) {
                    ab.e("MicroMsg.WXCommProvider", "open webview fail");
                }
                AppMethodBeat.o(18175);
                return null;
            case 39:
                bl blVar = new bl();
                blVar.cuK.selectionArgs = strArr2;
                blVar.cuK.crW = strArr3;
                blVar.cuK.context = getContext();
                if (!com.tencent.mm.sdk.b.a.xxA.m(blVar)) {
                    ab.e("MicroMsg.WXCommProvider", "choose card from wx fail");
                }
                AppMethodBeat.o(18175);
                return null;
            case 43:
                if (strArr3.length > 0) {
                    v.Zp().y("OpenSdkToken@" + bo.anU(), true).j("open_sdk_token_package_name", strArr3[0]);
                    ab.i("MicroMsg.WXCommProvider", "gen token for opensdk ,package = %s", strArr3[0]);
                    cursor = new MatrixCursor(new String[]{"token"});
                    cursor.addRow(new String[]{r3});
                    AppMethodBeat.o(18175);
                    return cursor;
                }
                AppMethodBeat.o(18175);
                return null;
            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                final il ilVar = new il();
                ilVar.cDC.selectionArgs = strArr2;
                ilVar.cDC.crW = strArr3;
                ilVar.cDC.context = getContext();
                if (!com.tencent.mm.sdk.b.a.xxA.m(ilVar)) {
                    ab.e("MicroMsg.WXCommProvider", "handle scan result failed try again");
                    al.n(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(18164);
                            if (!com.tencent.mm.sdk.b.a.xxA.m(ilVar)) {
                                ab.e("MicroMsg.WXCommProvider", "handle scan result failed again");
                            }
                            AppMethodBeat.o(18164);
                        }
                    }, 200);
                }
                AppMethodBeat.o(18175);
                return null;
            case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                ph phVar = new ph();
                phVar.cLz.selectionArgs = strArr2;
                phVar.cLz.crW = strArr3;
                phVar.cLz.context = getContext();
                if (!com.tencent.mm.sdk.b.a.xxA.m(phVar)) {
                    ab.e("MicroMsg.WXCommProvider", "launch wx miniprogram fail");
                }
                AppMethodBeat.o(18175);
                return null;
            case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                pj pjVar = new pj();
                pjVar.cLB.selectionArgs = strArr2;
                pjVar.cLB.crW = strArr3;
                pjVar.cLB.context = getContext();
                if (!com.tencent.mm.sdk.b.a.xxA.m(pjVar)) {
                    ab.e("MicroMsg.WXCommProvider", "open offline pay fail");
                }
                AppMethodBeat.o(18175);
                return null;
            case 50:
                e.a(getContext(), strArr2, strArr3);
                AppMethodBeat.o(18175);
                return null;
            case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                e.b(getContext(), strArr2, strArr3);
                AppMethodBeat.o(18175);
                return null;
            default:
                final MatrixCursor matrixCursor = new MatrixCursor(jDM);
                final Uri uri2 = uri;
                final int i3 = i;
                final String[] strArr4 = strArr3;
                cursor = (Cursor) new bj<Cursor>() {
                    public final /* synthetic */ Object run() {
                        AppMethodBeat.i(18165);
                        ab.d("MicroMsg.WXCommProvider", "query, uri = %s, code = %d", uri2.toString(), Integer.valueOf(i3));
                        if (i3 != 1) {
                            ab.e("MicroMsg.WXCommProvider", "query fail, invalid code = %d", Integer.valueOf(i3));
                            AppMethodBeat.o(18165);
                            return null;
                        }
                        for (String string : strArr4) {
                            String string2 = WXCommProvider.this.ehZ.getString(string, "");
                            matrixCursor.addRow(new String[]{string, string2});
                        }
                        ab.d("MicroMsg.WXCommProvider", "query size = %d", Integer.valueOf(matrixCursor.getCount()));
                        Object obj = matrixCursor;
                        AppMethodBeat.o(18165);
                        return obj;
                    }
                }.b(this.handler);
                if (cursor == null) {
                    matrixCursor.close();
                }
                AppMethodBeat.o(18175);
                return cursor;
        }
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        AppMethodBeat.i(18176);
        if (uri == null) {
            ab.e("MicroMsg.WXCommProvider", "delete fail, uri is null");
            AppMethodBeat.o(18176);
            return 0;
        }
        final int match = jDO.match(uri);
        final String[] aVj = aVj();
        final Uri uri2 = uri;
        int intValue = ((Integer) new bj<Integer>(Integer.valueOf(0)) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.i(18166);
                ab.d("MicroMsg.WXCommProvider", "delete, uri = %s, code = %d", uri2.toString(), Integer.valueOf(match));
                if (match != 1) {
                    ab.e("MicroMsg.WXCommProvider", "delete fail, invalid code = %d", Integer.valueOf(match));
                    AppMethodBeat.o(18166);
                    return null;
                }
                int i = 0;
                for (String str : aVj) {
                    if (!bo.isNullOrNil(str)) {
                        int i2;
                        if (WXCommProvider.this.ehZ.contains(str) && WXCommProvider.this.ehZ.edit().remove(str).commit()) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        if (i2 != 0) {
                            i++;
                        }
                    }
                }
                ab.d("MicroMsg.WXCommProvider", "delete result = %d", Integer.valueOf(i));
                Object valueOf = Integer.valueOf(i);
                AppMethodBeat.o(18166);
                return valueOf;
            }
        }.b(this.handler)).intValue();
        AppMethodBeat.o(18176);
        return intValue;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private String[] aVj() {
        AppMethodBeat.i(18177);
        String[] packagesForUid;
        try {
            int callingUid = Binder.getCallingUid();
            packagesForUid = getContext().getPackageManager().getPackagesForUid(Binder.getCallingUid());
            String str = "MicroMsg.WXCommProvider";
            String str2 = "getCallingPackages, callingUid = %d, packages size = %d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(callingUid);
            objArr[1] = Integer.valueOf(packagesForUid == null ? 0 : packagesForUid.length);
            ab.i(str, str2, objArr);
            if (packagesForUid == null) {
                ab.w("MicroMsg.WXCommProvider", "getCallingPackages fail, packages is null");
                packagesForUid = new String[0];
                AppMethodBeat.o(18177);
                return packagesForUid;
            }
            int length = packagesForUid.length;
            for (callingUid = 0; callingUid < length; callingUid++) {
                ab.i("MicroMsg.WXCommProvider", "getCallingPackages = %s", packagesForUid[callingUid]);
            }
            AppMethodBeat.o(18177);
            return packagesForUid;
        } catch (Exception e) {
            ab.e("MicroMsg.WXCommProvider", "getCallingPackages, ex = %s", e.getMessage());
            packagesForUid = new String[0];
            AppMethodBeat.o(18177);
            return packagesForUid;
        }
    }

    private boolean aVk() {
        AppMethodBeat.i(18178);
        try {
            ab.i("MicroMsg.WXCommProvider", "checkIsLogin()");
            if (jDQ || ((Boolean) new bj<Boolean>(Boolean.FALSE) {
                public final /* synthetic */ Object run() {
                    AppMethodBeat.i(18169);
                    Boolean aKg = aKg();
                    AppMethodBeat.o(18169);
                    return aKg;
                }

                private Boolean aKg() {
                    AppMethodBeat.i(18168);
                    Boolean valueOf;
                    try {
                        ab.i("MicroMsg.WXCommProvider", "checkIsLogin run");
                        if (aw.RK()) {
                            ab.i("MicroMsg.WXCommProvider", "checkIsLogin doScene");
                            valueOf = Boolean.valueOf(aw.Rg().a(new bk(new bk.a() {
                                public final void a(com.tencent.mm.network.e eVar) {
                                    AppMethodBeat.i(18167);
                                    ab.i("MicroMsg.WXCommProvider", "checkIsLogin onSceneEnd() hasLogin:%s", Boolean.valueOf(WXCommProvider.jDQ));
                                    AnonymousClass6.this.cC(Boolean.TRUE);
                                    AppMethodBeat.o(18167);
                                }
                            }), 0));
                            AppMethodBeat.o(18168);
                            return valueOf;
                        }
                        valueOf = Boolean.FALSE;
                        AppMethodBeat.o(18168);
                        return valueOf;
                    } catch (Exception e) {
                        ab.e("MicroMsg.WXCommProvider", "exception in NetSceneLocalProxy.");
                        cC(Boolean.FALSE);
                        valueOf = Boolean.FALSE;
                        AppMethodBeat.o(18168);
                        return valueOf;
                    }
                }
            }.b(this.handler)).booleanValue()) {
                if (aw.RK() && aw.ZM() && !aw.QT()) {
                    jDQ = true;
                } else {
                    jDQ = false;
                }
                ab.i("MicroMsg.WXCommProvider", "hasLogin = " + jDQ);
                boolean z = jDQ;
                AppMethodBeat.o(18178);
                return z;
            }
            ab.i("MicroMsg.WXCommProvider", "checkIsLogin !syncTaskRet");
            jDQ = false;
            AppMethodBeat.o(18178);
            return false;
        } catch (Exception e) {
            ab.w("MicroMsg.WXCommProvider", e.getMessage());
            ab.printErrStackTrace("MicroMsg.WXCommProvider", e, "", new Object[0]);
            AppMethodBeat.o(18178);
            return false;
        }
    }

    private boolean aVl() {
        boolean z = false;
        AppMethodBeat.i(18179);
        try {
            ab.i("MicroMsg.WXCommProvider", "checkIsLogin()");
            if (!jDQ) {
                final com.tencent.mm.pluginsdk.d.a.b bVar = new com.tencent.mm.pluginsdk.d.a.b();
                bVar.b(4000, new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(18171);
                        try {
                            if (aw.RK()) {
                                aw.Rg().a(new bk(new bk.a() {
                                    public final void a(com.tencent.mm.network.e eVar) {
                                        AppMethodBeat.i(18170);
                                        ab.i("MicroMsg.WXCommProvider", "checkIsLogin() onSceneEnd()");
                                        bVar.countDown();
                                        AppMethodBeat.o(18170);
                                    }
                                }), 0);
                                AppMethodBeat.o(18171);
                                return;
                            }
                            AppMethodBeat.o(18171);
                        } catch (Exception e) {
                            ab.e("MicroMsg.WXCommProvider", "exception in NetSceneLocalProxy");
                            bVar.countDown();
                            AppMethodBeat.o(18171);
                        }
                    }
                });
            }
            if (aw.RK() && aw.ZM() && !aw.QT()) {
                jDQ = true;
            } else {
                jDQ = false;
            }
            ab.i("MicroMsg.WXCommProvider", "hasLogin = " + jDQ);
            z = jDQ;
            AppMethodBeat.o(18179);
        } catch (Exception e) {
            ab.w("MicroMsg.WXCommProvider", e.getMessage());
            ab.printErrStackTrace("MicroMsg.WXCommProvider", e, "", new Object[0]);
            AppMethodBeat.o(18179);
        }
        return z;
    }
}
