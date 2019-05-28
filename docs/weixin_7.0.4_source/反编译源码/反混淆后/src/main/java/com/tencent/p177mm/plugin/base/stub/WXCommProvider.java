package com.tencent.p177mm.plugin.base.stub;

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
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.app.WorkerProfile;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.p230g.p231a.C18273g;
import com.tencent.p177mm.p230g.p231a.C18298il;
import com.tencent.p177mm.p230g.p231a.C18424vf;
import com.tencent.p177mm.p230g.p231a.C26100ce;
import com.tencent.p177mm.p230g.p231a.C26215pi;
import com.tencent.p177mm.p230g.p231a.C32548fc;
import com.tencent.p177mm.p230g.p231a.C32550fd;
import com.tencent.p177mm.p230g.p231a.C32614pk;
import com.tencent.p177mm.p230g.p231a.C9302bl;
import com.tencent.p177mm.p230g.p231a.C9339fj;
import com.tencent.p177mm.p230g.p231a.C9440ph;
import com.tencent.p177mm.p230g.p231a.C9443pj;
import com.tencent.p177mm.plugin.account.p275ui.LoginUI;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.p177mm.plugin.appbrand.jsapi.fakenative.C19365c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.C16681c;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.C19523a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C14827e;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C44058ao;
import com.tencent.p177mm.pluginsdk.p1568d.p1569a.C46484b;
import com.tencent.p177mm.protocal.C35900b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5039bj;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.C31128d;
import org.xwalk.core.XWalkEnvironment;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.PROVIDERCHECK})
/* renamed from: com.tencent.mm.plugin.base.stub.WXCommProvider */
public class WXCommProvider extends ContentProvider {
    public static final String jDL = (C4996ah.getPackageName() + "_comm_preferences");
    private static final String[] jDM = new String[]{DownloadInfoColumns.PACKAGENAME, "data"};
    private static final UriMatcher jDO = new UriMatcher(-1);
    private static volatile boolean jDP = false;
    protected static boolean jDQ = false;
    private static final Object lock = new Object();
    private SharedPreferences ehZ;
    private C7306ak handler;
    protected MatrixCursor jDN = new MatrixCursor(new String[0]);

    /* renamed from: com.tencent.mm.plugin.base.stub.WXCommProvider$1 */
    public class C26621 extends BroadcastReceiver {
        C26621() {
        }

        public void onReceive(Context context, Intent intent) {
            C44058ao c44058ao;
            AppMethodBeat.m2504i(18162);
            if (System.currentTimeMillis() - C44058ao.vdh >= 600000) {
                C4990ab.m7412e("MicroMsg.AppUtil", "hy: get comm model time expired");
                c44058ao = null;
            } else {
                c44058ao = C44058ao.vdg;
            }
            if (c44058ao != null) {
                C4990ab.m7416i("MicroMsg.WXCommProvider", "hy: has wxcomm query request. start to continue requesting");
                Cursor a = WXCommProvider.this.mo6726a(c44058ao.uri, c44058ao.projection, c44058ao.selection, c44058ao.selectionArgs, c44058ao.vde, c44058ao.code, c44058ao.vdf);
                if (a != null) {
                    a.close();
                }
                C35799p.dhH();
            }
            AppMethodBeat.m2505o(18162);
        }
    }

    /* renamed from: com.tencent.mm.plugin.base.stub.WXCommProvider$2 */
    class C26642 implements C5015a {
        C26642() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(18163);
            if (C4879a.xxA == null || !C4879a.xxA.mo10050av(C32548fc.class)) {
                AppMethodBeat.m2505o(18163);
                return true;
            }
            synchronized (WXCommProvider.lock) {
                try {
                    C4990ab.m7416i("MicroMsg.WXCommProvider", "The lock was released.");
                    WXCommProvider.jDP = true;
                    WXCommProvider.lock.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(18163);
                }
            }
            return false;
        }
    }

    public WXCommProvider() {
        AppMethodBeat.m2504i(18172);
        AppMethodBeat.m2505o(18172);
    }

    static {
        AppMethodBeat.m2504i(18180);
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
        jDO.addURI("com.tencent.mm.sdk.comm.provider", C16681c.NAME, 37);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", C19523a.NAME, 38);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "chooseCardFromWX", 39);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "openOfflinePay", 42);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "setWechatSportStep", 40);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "getWechatSportConfig", 41);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "handleScanResult", 44);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "openTypeWebview", 45);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "openCleanUI", 46);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "launchWXMiniprogram", 47);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", C19365c.NAME, 53);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "genTokenForOpenSdk", 43);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "qrcodeEvent", 48);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "jumpToOfflinePay", 49);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "openBusinessWebview", 50);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "getWxaInfo", 51);
        jDO.addURI("com.tencent.mm.sdk.comm.provider", "openWxaDesktopOrWxaMyFavorite", 52);
        AppMethodBeat.m2505o(18180);
    }

    public boolean onCreate() {
        AppMethodBeat.m2504i(18173);
        C4990ab.m7410d("MicroMsg.WXCommProvider", "onCreate");
        this.handler = new C7306ak();
        C4990ab.m7416i("MicroMsg.WXCommProvider", "pid = " + Process.myPid() + ", tid : = " + Process.myTid());
        this.ehZ = getContext().getSharedPreferences(jDL, 0);
        getContext().registerReceiver(new C26621(), new IntentFilter(ConstantsAPI.ACTION_REFRESH_WXAPP));
        if (this.ehZ != null) {
            AppMethodBeat.m2505o(18173);
            return true;
        }
        AppMethodBeat.m2505o(18173);
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.m2504i(18174);
        C4990ab.m7417i("MicroMsg.WXCommProvider", "uri:%s", uri);
        if (uri == null) {
            C4990ab.m7412e("MicroMsg.WXCommProvider", "query fail, uri is null return null");
            AppMethodBeat.m2505o(18174);
            return null;
        }
        String[] aVj = aVj();
        if (aVj == null || aVj.length <= 0) {
            C4990ab.m7412e("MicroMsg.WXCommProvider", "CallingPackages is null return null");
            AppMethodBeat.m2505o(18174);
            return null;
        }
        int match = jDO.match(uri);
        if (WorkerProfile.m16161Ca() == null || !WorkerProfile.m16161Ca().cfM) {
            new C7564ap(Looper.getMainLooper(), new C26642(), true).mo16770ae(50, 50);
            try {
                synchronized (lock) {
                    C4990ab.m7416i("MicroMsg.WXCommProvider", "Lock to wait for the first initialize of the Application.");
                    while (!jDP) {
                        lock.wait();
                    }
                    jDP = false;
                }
            } catch (InterruptedException e) {
                C4990ab.m7412e("MicroMsg.WXCommProvider", "the lock may have some problem," + e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.WXCommProvider", e, "", new Object[0]);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(18174);
            }
        }
        Cursor a = mo6726a(uri, strArr, str, strArr2, str2, match, aVj);
        AppMethodBeat.m2505o(18174);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0220  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final Cursor mo6726a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, int i, String[] strArr3) {
        AppMethodBeat.m2504i(18175);
        Cursor cursor;
        C32548fc c32548fc;
        C26100ce c26100ce;
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
            case C2275g.CTRL_INDEX /*37*/:
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
                    C9339fj c9339fj = new C9339fj();
                    c9339fj.czd.cyy = i;
                    c9339fj.czd.uri = uri;
                    c9339fj.czd.selectionArgs = strArr2;
                    c9339fj.czd.context = getContext();
                    c9339fj.czd.crW = strArr3;
                    if (C4879a.xxA.mo10055m(c9339fj)) {
                        C4990ab.m7417i("MicroMsg.WXCommProvider", "[extApiCost] total cost = %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        cursor = c9339fj.cze.cyz;
                        AppMethodBeat.m2505o(18175);
                        return cursor;
                    }
                    C4990ab.m7412e("MicroMsg.WXCommProvider", "ExtCallEvent fail return code = 8");
                    cursor = new MatrixCursor(C35900b.lPA);
                    cursor.addRow(new Object[]{Integer.valueOf(8)});
                    AppMethodBeat.m2505o(18175);
                    return cursor;
                }
                String nullAsNil = C5046bo.nullAsNil(uri.getQueryParameter("appid"));
                if ("1".equals(C5046bo.m7532bc(uri.getQueryParameter("autoLogin"), AppEventsConstants.EVENT_PARAM_VALUE_NO))) {
                    C4990ab.m7416i("MicroMsg.WXCommProvider", "hy: not login. try to login return code = 9");
                    C44058ao.vdg = new C44058ao(uri, strArr, str, strArr2, str2, i, strArr3);
                    C44058ao.vdh = System.currentTimeMillis();
                    Intent intent = new Intent(getContext(), LoginUI.class);
                    intent.addFlags(268435456);
                    getContext().startActivity(intent);
                    cursor = new MatrixCursor(C35900b.lPA);
                    cursor.addRow(new Object[]{Integer.valueOf(9)});
                    AppMethodBeat.m2505o(18175);
                    return cursor;
                }
                C4990ab.m7417i("MicroMsg.WXCommProvider", "not login, appID = %s, apiID = %s return code =%s ", nullAsNil, Integer.valueOf(i), Integer.valueOf(3));
                C7060h.pYm.mo8381e(10505, C5046bo.nullAsNil(strArr3[0]), nullAsNil, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                cursor = new MatrixCursor(C35900b.lPA);
                cursor.addRow(new Object[]{Integer.valueOf(3)});
                AppMethodBeat.m2505o(18175);
                return cursor;
            case 18:
            case 19:
            case 20:
                if (aVk()) {
                    C32550fd c32550fd = new C32550fd();
                    c32550fd.cyw.cyy = i;
                    c32550fd.cyw.uri = uri;
                    c32550fd.cyw.selectionArgs = strArr2;
                    c32550fd.cyw.context = getContext();
                    c32550fd.cyw.crW = strArr3;
                    if (C4879a.xxA.mo10055m(c32550fd)) {
                        cursor = c32550fd.cyx.cyz;
                        AppMethodBeat.m2505o(18175);
                        return cursor;
                    }
                    C4990ab.m7412e("MicroMsg.WXCommProvider", "ExtCallEvent fail");
                    AppMethodBeat.m2505o(18175);
                    return null;
                }
                AppMethodBeat.m2505o(18175);
                return null;
            case 21:
                c32548fc = new C32548fc();
                c32548fc.cyu.f2860op = 21;
                c32548fc.cyu.cvd = 1;
                c32548fc.cyu.selectionArgs = strArr2;
                c32548fc.cyu.context = getContext();
                c32548fc.cyu.crW = strArr3;
                if (!C4879a.xxA.mo10055m(c32548fc)) {
                    C4990ab.m7412e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                AppMethodBeat.m2505o(18175);
                return null;
            case 24:
                if (aVk()) {
                    C18424vf c18424vf = new C18424vf();
                    c18424vf.cSc.cyy = i;
                    c18424vf.cSc.uri = uri;
                    c18424vf.cSc.context = getContext();
                    for (int i2 = 0; i2 < strArr3.length; i2++) {
                        if (strArr3[i2] != null) {
                            c18424vf.cSc.callingPackage = strArr3[i2];
                            if (C4879a.xxA.mo10055m(c18424vf)) {
                                C4990ab.m7412e("MicroMsg.WXCommProvider", "WatchAppIdRegEvent fail");
                                AppMethodBeat.m2505o(18175);
                                return null;
                            }
                            cursor = c18424vf.cSd.cyz;
                            AppMethodBeat.m2505o(18175);
                            return cursor;
                        }
                    }
                    if (C4879a.xxA.mo10055m(c18424vf)) {
                    }
                } else {
                    cursor = this.jDN;
                    AppMethodBeat.m2505o(18175);
                    return cursor;
                }
            case 26:
                C18273g c18273g = new C18273g();
                c18273g.crV.selectionArgs = strArr2;
                c18273g.crV.crW = strArr3;
                c18273g.crV.context = getContext();
                if (!C4879a.xxA.mo10055m(c18273g)) {
                    C4990ab.m7412e("MicroMsg.WXCommProvider", "add card to wx fail");
                }
                AppMethodBeat.m2505o(18175);
                return null;
            case 27:
                if (strArr2 == null || strArr2.length < 2) {
                    C4990ab.m7412e("MicroMsg.WXCommProvider", "wrong args");
                    AppMethodBeat.m2505o(18175);
                    return null;
                }
                c32548fc = new C32548fc();
                c32548fc.cyu.f2860op = 27;
                c32548fc.cyu.cvd = 1;
                c32548fc.cyu.selectionArgs = strArr2;
                c32548fc.cyu.context = getContext();
                c32548fc.cyu.crW = strArr3;
                if (!C4879a.xxA.mo10055m(c32548fc)) {
                    C4990ab.m7412e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                AppMethodBeat.m2505o(18175);
                return null;
            case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                c32548fc = new C32548fc();
                c32548fc.cyu.f2860op = i;
                c32548fc.cyu.selectionArgs = strArr2;
                c32548fc.cyu.context = getContext();
                c32548fc.cyu.crW = strArr3;
                if (!C4879a.xxA.mo10055m(c32548fc)) {
                    C4990ab.m7412e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                AppMethodBeat.m2505o(18175);
                return null;
            case 30:
            case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                C32614pk c32614pk = new C32614pk();
                c32614pk.cLC.selectionArgs = strArr2;
                c32614pk.cLC.crW = strArr3;
                c32614pk.cLC.context = getContext();
                c32614pk.cLC.cLD = i == 45;
                if (i == 30 && strArr2 != null && strArr2.length > 2) {
                    C14827e.vao = strArr2[2];
                }
                if (!C4879a.xxA.mo10055m(c32614pk)) {
                    C4990ab.m7412e("MicroMsg.WXCommProvider", "open webview fail");
                }
                AppMethodBeat.m2505o(18175);
                return null;
            case 31:
                C26215pi c26215pi = new C26215pi();
                c26215pi.cLA.selectionArgs = strArr2;
                c26215pi.cLA.crW = strArr3;
                c26215pi.cLA.context = getContext();
                if (!C4879a.xxA.mo10055m(c26215pi)) {
                    C4990ab.m7412e("MicroMsg.WXCommProvider", "open busi luckymoney fail");
                }
                AppMethodBeat.m2505o(18175);
                return null;
            case 32:
                c26100ce = new C26100ce();
                c26100ce.cvl.action = 1;
                c26100ce.cvl.selectionArgs = strArr2;
                c26100ce.cvl.crW = strArr3;
                c26100ce.cvl.context = getContext();
                if (!C4879a.xxA.mo10055m(c26100ce)) {
                    C4990ab.m7412e("MicroMsg.WXCommProvider", "open webview fail");
                }
                AppMethodBeat.m2505o(18175);
                return null;
            case 33:
                c26100ce = new C26100ce();
                c26100ce.cvl.action = 2;
                c26100ce.cvl.selectionArgs = strArr2;
                c26100ce.cvl.crW = strArr3;
                c26100ce.cvl.context = getContext();
                if (!C4879a.xxA.mo10055m(c26100ce)) {
                    C4990ab.m7412e("MicroMsg.WXCommProvider", "open webview fail");
                }
                AppMethodBeat.m2505o(18175);
                return null;
            case 39:
                C9302bl c9302bl = new C9302bl();
                c9302bl.cuK.selectionArgs = strArr2;
                c9302bl.cuK.crW = strArr3;
                c9302bl.cuK.context = getContext();
                if (!C4879a.xxA.mo10055m(c9302bl)) {
                    C4990ab.m7412e("MicroMsg.WXCommProvider", "choose card from wx fail");
                }
                AppMethodBeat.m2505o(18175);
                return null;
            case 43:
                if (strArr3.length > 0) {
                    C37922v.m64076Zp().mo60676y("OpenSdkToken@" + C5046bo.anU(), true).mo53356j("open_sdk_token_package_name", strArr3[0]);
                    C4990ab.m7417i("MicroMsg.WXCommProvider", "gen token for opensdk ,package = %s", strArr3[0]);
                    cursor = new MatrixCursor(new String[]{"token"});
                    cursor.addRow(new String[]{r3});
                    AppMethodBeat.m2505o(18175);
                    return cursor;
                }
                AppMethodBeat.m2505o(18175);
                return null;
            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                final C18298il c18298il = new C18298il();
                c18298il.cDC.selectionArgs = strArr2;
                c18298il.cDC.crW = strArr3;
                c18298il.cDC.context = getContext();
                if (!C4879a.xxA.mo10055m(c18298il)) {
                    C4990ab.m7412e("MicroMsg.WXCommProvider", "handle scan result failed try again");
                    C5004al.m7442n(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(18164);
                            if (!C4879a.xxA.mo10055m(c18298il)) {
                                C4990ab.m7412e("MicroMsg.WXCommProvider", "handle scan result failed again");
                            }
                            AppMethodBeat.m2505o(18164);
                        }
                    }, 200);
                }
                AppMethodBeat.m2505o(18175);
                return null;
            case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                C9440ph c9440ph = new C9440ph();
                c9440ph.cLz.selectionArgs = strArr2;
                c9440ph.cLz.crW = strArr3;
                c9440ph.cLz.context = getContext();
                if (!C4879a.xxA.mo10055m(c9440ph)) {
                    C4990ab.m7412e("MicroMsg.WXCommProvider", "launch wx miniprogram fail");
                }
                AppMethodBeat.m2505o(18175);
                return null;
            case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                C9443pj c9443pj = new C9443pj();
                c9443pj.cLB.selectionArgs = strArr2;
                c9443pj.cLB.crW = strArr3;
                c9443pj.cLB.context = getContext();
                if (!C4879a.xxA.mo10055m(c9443pj)) {
                    C4990ab.m7412e("MicroMsg.WXCommProvider", "open offline pay fail");
                }
                AppMethodBeat.m2505o(18175);
                return null;
            case 50:
                C33716e.m55098a(getContext(), strArr2, strArr3);
                AppMethodBeat.m2505o(18175);
                return null;
            case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                C33716e.m55099b(getContext(), strArr2, strArr3);
                AppMethodBeat.m2505o(18175);
                return null;
            default:
                final MatrixCursor matrixCursor = new MatrixCursor(jDM);
                final Uri uri2 = uri;
                final int i3 = i;
                final String[] strArr4 = strArr3;
                cursor = (Cursor) new C5039bj<Cursor>() {
                    public final /* synthetic */ Object run() {
                        AppMethodBeat.m2504i(18165);
                        C4990ab.m7411d("MicroMsg.WXCommProvider", "query, uri = %s, code = %d", uri2.toString(), Integer.valueOf(i3));
                        if (i3 != 1) {
                            C4990ab.m7413e("MicroMsg.WXCommProvider", "query fail, invalid code = %d", Integer.valueOf(i3));
                            AppMethodBeat.m2505o(18165);
                            return null;
                        }
                        for (String string : strArr4) {
                            String string2 = WXCommProvider.this.ehZ.getString(string, "");
                            matrixCursor.addRow(new String[]{string, string2});
                        }
                        C4990ab.m7411d("MicroMsg.WXCommProvider", "query size = %d", Integer.valueOf(matrixCursor.getCount()));
                        Object obj = matrixCursor;
                        AppMethodBeat.m2505o(18165);
                        return obj;
                    }
                }.mo10372b(this.handler);
                if (cursor == null) {
                    matrixCursor.close();
                }
                AppMethodBeat.m2505o(18175);
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
        AppMethodBeat.m2504i(18176);
        if (uri == null) {
            C4990ab.m7412e("MicroMsg.WXCommProvider", "delete fail, uri is null");
            AppMethodBeat.m2505o(18176);
            return 0;
        }
        final int match = jDO.match(uri);
        final String[] aVj = aVj();
        final Uri uri2 = uri;
        int intValue = ((Integer) new C5039bj<Integer>(Integer.valueOf(0)) {
            public final /* synthetic */ Object run() {
                AppMethodBeat.m2504i(18166);
                C4990ab.m7411d("MicroMsg.WXCommProvider", "delete, uri = %s, code = %d", uri2.toString(), Integer.valueOf(match));
                if (match != 1) {
                    C4990ab.m7413e("MicroMsg.WXCommProvider", "delete fail, invalid code = %d", Integer.valueOf(match));
                    AppMethodBeat.m2505o(18166);
                    return null;
                }
                int i = 0;
                for (String str : aVj) {
                    if (!C5046bo.isNullOrNil(str)) {
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
                C4990ab.m7411d("MicroMsg.WXCommProvider", "delete result = %d", Integer.valueOf(i));
                Object valueOf = Integer.valueOf(i);
                AppMethodBeat.m2505o(18166);
                return valueOf;
            }
        }.mo10372b(this.handler)).intValue();
        AppMethodBeat.m2505o(18176);
        return intValue;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private String[] aVj() {
        AppMethodBeat.m2504i(18177);
        String[] packagesForUid;
        try {
            int callingUid = Binder.getCallingUid();
            packagesForUid = getContext().getPackageManager().getPackagesForUid(Binder.getCallingUid());
            String str = "MicroMsg.WXCommProvider";
            String str2 = "getCallingPackages, callingUid = %d, packages size = %d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(callingUid);
            objArr[1] = Integer.valueOf(packagesForUid == null ? 0 : packagesForUid.length);
            C4990ab.m7417i(str, str2, objArr);
            if (packagesForUid == null) {
                C4990ab.m7420w("MicroMsg.WXCommProvider", "getCallingPackages fail, packages is null");
                packagesForUid = new String[0];
                AppMethodBeat.m2505o(18177);
                return packagesForUid;
            }
            int length = packagesForUid.length;
            for (callingUid = 0; callingUid < length; callingUid++) {
                C4990ab.m7417i("MicroMsg.WXCommProvider", "getCallingPackages = %s", packagesForUid[callingUid]);
            }
            AppMethodBeat.m2505o(18177);
            return packagesForUid;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WXCommProvider", "getCallingPackages, ex = %s", e.getMessage());
            packagesForUid = new String[0];
            AppMethodBeat.m2505o(18177);
            return packagesForUid;
        }
    }

    private boolean aVk() {
        AppMethodBeat.m2504i(18178);
        try {
            C4990ab.m7416i("MicroMsg.WXCommProvider", "checkIsLogin()");
            if (jDQ || ((Boolean) new C5039bj<Boolean>(Boolean.FALSE) {

                /* renamed from: com.tencent.mm.plugin.base.stub.WXCommProvider$6$1 */
                class C26671 implements C1835a {
                    C26671() {
                    }

                    /* renamed from: a */
                    public final void mo4918a(C1902e c1902e) {
                        AppMethodBeat.m2504i(18167);
                        C4990ab.m7417i("MicroMsg.WXCommProvider", "checkIsLogin onSceneEnd() hasLogin:%s", Boolean.valueOf(WXCommProvider.jDQ));
                        C26666.this.mo10373cC(Boolean.TRUE);
                        AppMethodBeat.m2505o(18167);
                    }
                }

                public final /* synthetic */ Object run() {
                    AppMethodBeat.m2504i(18169);
                    Boolean aKg = aKg();
                    AppMethodBeat.m2505o(18169);
                    return aKg;
                }

                private Boolean aKg() {
                    AppMethodBeat.m2504i(18168);
                    Boolean valueOf;
                    try {
                        C4990ab.m7416i("MicroMsg.WXCommProvider", "checkIsLogin run");
                        if (C9638aw.m17179RK()) {
                            C4990ab.m7416i("MicroMsg.WXCommProvider", "checkIsLogin doScene");
                            valueOf = Boolean.valueOf(C9638aw.m17182Rg().mo14541a(new C6668bk(new C26671()), 0));
                            AppMethodBeat.m2505o(18168);
                            return valueOf;
                        }
                        valueOf = Boolean.FALSE;
                        AppMethodBeat.m2505o(18168);
                        return valueOf;
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.WXCommProvider", "exception in NetSceneLocalProxy.");
                        mo10373cC(Boolean.FALSE);
                        valueOf = Boolean.FALSE;
                        AppMethodBeat.m2505o(18168);
                        return valueOf;
                    }
                }
            }.mo10372b(this.handler)).booleanValue()) {
                if (C9638aw.m17179RK() && C9638aw.m17192ZM() && !C9638aw.m17178QT()) {
                    jDQ = true;
                } else {
                    jDQ = false;
                }
                C4990ab.m7416i("MicroMsg.WXCommProvider", "hasLogin = " + jDQ);
                boolean z = jDQ;
                AppMethodBeat.m2505o(18178);
                return z;
            }
            C4990ab.m7416i("MicroMsg.WXCommProvider", "checkIsLogin !syncTaskRet");
            jDQ = false;
            AppMethodBeat.m2505o(18178);
            return false;
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.WXCommProvider", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.WXCommProvider", e, "", new Object[0]);
            AppMethodBeat.m2505o(18178);
            return false;
        }
    }

    private boolean aVl() {
        boolean z = false;
        AppMethodBeat.m2504i(18179);
        try {
            C4990ab.m7416i("MicroMsg.WXCommProvider", "checkIsLogin()");
            if (!jDQ) {
                final C46484b c46484b = new C46484b();
                c46484b.mo74707b(4000, new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.base.stub.WXCommProvider$7$1 */
                    class C26691 implements C1835a {
                        C26691() {
                        }

                        /* renamed from: a */
                        public final void mo4918a(C1902e c1902e) {
                            AppMethodBeat.m2504i(18170);
                            C4990ab.m7416i("MicroMsg.WXCommProvider", "checkIsLogin() onSceneEnd()");
                            c46484b.countDown();
                            AppMethodBeat.m2505o(18170);
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(18171);
                        try {
                            if (C9638aw.m17179RK()) {
                                C9638aw.m17182Rg().mo14541a(new C6668bk(new C26691()), 0);
                                AppMethodBeat.m2505o(18171);
                                return;
                            }
                            AppMethodBeat.m2505o(18171);
                        } catch (Exception e) {
                            C4990ab.m7412e("MicroMsg.WXCommProvider", "exception in NetSceneLocalProxy");
                            c46484b.countDown();
                            AppMethodBeat.m2505o(18171);
                        }
                    }
                });
            }
            if (C9638aw.m17179RK() && C9638aw.m17192ZM() && !C9638aw.m17178QT()) {
                jDQ = true;
            } else {
                jDQ = false;
            }
            C4990ab.m7416i("MicroMsg.WXCommProvider", "hasLogin = " + jDQ);
            z = jDQ;
            AppMethodBeat.m2505o(18179);
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.WXCommProvider", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.WXCommProvider", e, "", new Object[0]);
            AppMethodBeat.m2505o(18179);
        }
        return z;
    }
}
