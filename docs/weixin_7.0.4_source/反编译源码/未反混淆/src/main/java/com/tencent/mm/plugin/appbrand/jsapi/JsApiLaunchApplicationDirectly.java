package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.jc;
import com.tencent.mm.ipcinvoker.wx_extension.b;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.ui.n;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.pluginsdk.model.app.aj;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.protocal.protobuf.avk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiLaunchApplicationDirectly extends JsApiLaunchApplication {
    private static final int CTRL_INDEX = 620;
    private static final String NAME = "launchApplicationDirectly";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly$3 */
    class AnonymousClass3 implements OnClickListener {
        final /* synthetic */ int eIl;
        final /* synthetic */ q hsD;
        final /* synthetic */ String hxw;
        final /* synthetic */ String hxx;
        final /* synthetic */ String hxy;
        final /* synthetic */ String val$appId;
        final /* synthetic */ String val$packageName;

        AnonymousClass3(q qVar, String str, String str2, String str3, String str4, String str5, int i) {
            this.hsD = qVar;
            this.val$appId = str;
            this.hxw = str2;
            this.hxx = str3;
            this.hxy = str4;
            this.val$packageName = str5;
            this.eIl = i;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(130458);
            JsApiLaunchApplicationDirectly.a(JsApiLaunchApplicationDirectly.this, this.hsD);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appId", this.val$appId);
                jSONObject.put("taskUrl", this.hxw);
                jSONObject.put("taskName", this.hxx);
                jSONObject.put("fileMd5", this.hxy);
                jSONObject.put(DownloadInfoColumns.PACKAGENAME, this.val$packageName);
                AppBrandMainProcessService.a(new AddDownloadTaskStraightTask(JsApiLaunchApplicationDirectly.this, this.hsD, this.eIl, jSONObject));
                this.hsD.M(this.eIl, JsApiLaunchApplicationDirectly.this.j("ok:user downloaded app", null));
                AppMethodBeat.o(130458);
            } catch (JSONException e) {
                ab.e("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication, download app fail", e);
                this.hsD.M(this.eIl, JsApiLaunchApplicationDirectly.this.j("fail:download app fail", null));
                AppMethodBeat.o(130458);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly$4 */
    class AnonymousClass4 implements OnClickListener {
        final /* synthetic */ int eIl;
        final /* synthetic */ q hsD;

        AnonymousClass4(q qVar, int i) {
            this.hsD = qVar;
            this.eIl = i;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(130459);
            ab.i("MicroMsg.JsApiLaunchApplicationDirectly", "fail:user canceled install");
            JsApiLaunchApplicationDirectly.a(JsApiLaunchApplicationDirectly.this, this.hsD);
            this.hsD.M(this.eIl, JsApiLaunchApplicationDirectly.this.j("fail:user canceled install", null));
            AppMethodBeat.o(130459);
        }
    }

    static class LaunchApplicationTask extends AppBrandProxyTransparentUIProcessTask {
        public static final Creator<LaunchApplicationTask> CREATOR = new Creator<LaunchApplicationTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LaunchApplicationTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130469);
                LaunchApplicationTask launchApplicationTask = new LaunchApplicationTask(parcel, (byte) 0);
                AppMethodBeat.o(130469);
                return launchApplicationTask;
            }
        };
        public String appId;
        public Bundle cvs;
        public String extInfo;
        public Runnable hww;
        public String hxq;
        public int showType;
        public boolean success;

        /* synthetic */ LaunchApplicationTask(Parcel parcel, byte b) {
            this(parcel);
        }

        public final void a(Context context, final com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask.a aVar) {
            AppMethodBeat.i(130470);
            a aVar2 = new a(new a() {
                public final void r(boolean z, boolean z2) {
                    AppMethodBeat.i(130468);
                    ab.i("MicroMsg.JsApiLaunchApplicationDirectly", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", Boolean.valueOf(z), Boolean.valueOf(z2));
                    if (z) {
                        LaunchApplicationTask.this.success = true;
                        aVar.aBT();
                        AppMethodBeat.o(130468);
                        return;
                    }
                    LaunchApplicationTask.this.success = false;
                    aVar.aBT();
                    AppMethodBeat.o(130468);
                }
            });
            WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
            wXAppExtendObject.extInfo = this.extInfo;
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
            wXMediaMessage.sdkVer = Build.SDK_INT;
            wXMediaMessage.messageExt = this.extInfo;
            jc jcVar = new jc();
            jcVar.cEj.cEl = wXMediaMessage;
            jcVar.cEj.appId = this.appId;
            jcVar.cEj.showType = this.showType;
            jcVar.cEj.context = context;
            jcVar.cEj.cvs = this.cvs;
            jcVar.cEj.cEm = aVar2;
            com.tencent.mm.sdk.b.a.xxA.m(jcVar);
            boolean z = jcVar.cEk.cEn;
            if (!z) {
                if (bo.isNullOrNil(this.appId) || bo.isNullOrNil(this.hxq)) {
                    ab.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication nil appId or parameter.");
                } else {
                    boolean a;
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.appId + "://" + this.hxq));
                    ab.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication by opensdk failed, try to launch by scheme(%s).", r0);
                    intent.addFlags(268435456);
                    List H = bo.H(context, intent);
                    if (!(H == null || H.isEmpty())) {
                        Object b;
                        if (TextUtils.isEmpty(intent.getPackage()) && H.size() == 1) {
                            b = g.b((ResolveInfo) H.get(0));
                        } else {
                            b = intent.getPackage();
                        }
                        if (!bo.nullAsNil(ah.getPackageName()).equals(b)) {
                            aVar2.ftW = false;
                            aVar2.hxt = false;
                            aVar2.hxu = false;
                            aVar2.cEn = false;
                            a = g.a(context, intent, null, aVar2, this.cvs);
                            z = a;
                        }
                    }
                    a = z;
                    z = a;
                }
            }
            aVar2.dS(z);
            AppMethodBeat.o(130470);
        }

        public final void asQ() {
            AppMethodBeat.i(130471);
            ab.i("MicroMsg.JsApiLaunchApplicationDirectly", "runInClientProcess");
            if (this.hww != null) {
                ab.i("MicroMsg.JsApiLaunchApplicationDirectly", "runInClientProcess asyncCallback != null");
                this.hww.run();
            }
            AppMethodBeat.o(130471);
        }

        public final void g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(130472);
            this.showType = parcel.readInt();
            this.appId = parcel.readString();
            this.hxq = parcel.readString();
            this.extInfo = parcel.readString();
            this.cvs = parcel.readBundle();
            if (parcel.readByte() != (byte) 1) {
                z = false;
            }
            this.success = z;
            AppMethodBeat.o(130472);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(130473);
            parcel.writeInt(this.showType);
            parcel.writeString(this.appId);
            parcel.writeString(this.hxq);
            parcel.writeString(this.extInfo);
            parcel.writeBundle(this.cvs);
            parcel.writeByte((byte) (this.success ? 1 : 0));
            AppMethodBeat.o(130473);
        }

        public LaunchApplicationTask(MMActivity mMActivity) {
            super(mMActivity);
        }

        private LaunchApplicationTask(Parcel parcel) {
            AppMethodBeat.i(130474);
            g(parcel);
            AppMethodBeat.o(130474);
        }

        static {
            AppMethodBeat.i(130475);
            AppMethodBeat.o(130475);
        }
    }

    static class AddDownloadTaskStraightTask extends MainProcessTask {
        public static final Creator<AddDownloadTaskStraightTask> CREATOR = new Creator<AddDownloadTaskStraightTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AddDownloadTaskStraightTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130460);
                AddDownloadTaskStraightTask addDownloadTaskStraightTask = new AddDownloadTaskStraightTask(parcel);
                AppMethodBeat.o(130460);
                return addDownloadTaskStraightTask;
            }
        };
        private int bOs;
        private q gNC;
        private m hxE;
        private String hxF;
        private String hxG;
        private String hxH;
        private String hxI;
        private long hxJ;
        private String hxK;
        private String hxL;
        private boolean hxM;
        private String hxN;
        private long hxO;
        private String mAppId;
        private String mPackageName;

        public AddDownloadTaskStraightTask(m mVar, q qVar, int i, JSONObject jSONObject) {
            AppMethodBeat.i(130461);
            this.hxE = mVar;
            this.gNC = qVar;
            this.bOs = i;
            this.hxF = jSONObject.optString("taskName");
            this.hxG = jSONObject.optString("taskUrl");
            this.hxH = jSONObject.optString("fileMd5");
            this.hxI = jSONObject.optString("alternativeUrl");
            this.hxJ = (long) jSONObject.optInt("taskSize", 0);
            this.hxK = jSONObject.optString(IssueStorage.COLUMN_EXT_INFO);
            this.hxL = jSONObject.optString("fileType");
            this.mAppId = jSONObject.optString("appId");
            this.mPackageName = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
            this.hxM = true;
            AppMethodBeat.o(130461);
        }

        public AddDownloadTaskStraightTask(Parcel parcel) {
            AppMethodBeat.i(130462);
            g(parcel);
            AppMethodBeat.o(130462);
        }

        public final void asQ() {
            AppMethodBeat.i(130464);
            if (this.hxM) {
                String str;
                if (bo.isNullOrNil(this.hxN)) {
                    str = "fail";
                } else {
                    str = String.format("fail:%s", new Object[]{this.hxN});
                }
                this.gNC.M(this.bOs, this.hxE.j(str, null));
                AppMethodBeat.o(130464);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("downloadId", Long.valueOf(this.hxO));
            this.gNC.M(this.bOs, this.hxE.j("ok", hashMap));
            AppMethodBeat.o(130464);
        }

        public final void g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(130465);
            this.hxF = parcel.readString();
            this.hxG = parcel.readString();
            this.hxH = parcel.readString();
            this.hxI = parcel.readString();
            this.hxJ = parcel.readLong();
            this.hxK = parcel.readString();
            this.hxL = parcel.readString();
            this.mAppId = parcel.readString();
            this.mPackageName = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.hxM = z;
            this.hxN = parcel.readString();
            this.hxO = parcel.readLong();
            AppMethodBeat.o(130465);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(130466);
            parcel.writeString(this.hxF);
            parcel.writeString(this.hxG);
            parcel.writeString(this.hxH);
            parcel.writeString(this.hxI);
            parcel.writeLong(this.hxJ);
            parcel.writeString(this.hxK);
            parcel.writeString(this.hxL);
            parcel.writeString(this.mAppId);
            parcel.writeString(this.mPackageName);
            parcel.writeInt(this.hxM ? 1 : 0);
            parcel.writeString(this.hxN);
            parcel.writeLong(this.hxO);
            AppMethodBeat.o(130466);
        }

        static {
            AppMethodBeat.i(130467);
            AppMethodBeat.o(130467);
        }

        public final void asP() {
            AppMethodBeat.i(130463);
            com.tencent.mm.kernel.g.RQ();
            if (!com.tencent.mm.kernel.g.RP().isSDCardAvailable()) {
                this.hxN = "fail_sdcard_not_ready";
            } else if (this.hxJ > 0 && !f.eW(this.hxJ)) {
                this.hxN = "fail_sdcard_has_not_enough_space";
            } else if (bo.isNullOrNil(this.hxG)) {
                this.hxN = "fail_invalid_url";
            } else {
                ab.i("MicroMsg.JsApiLaunchApplicationDirectly", "runInMainProcess taskUrl:%s md5:%s", this.hxG, this.hxH);
                com.tencent.mm.plugin.downloader.model.e.a aVar = new com.tencent.mm.plugin.downloader.model.e.a();
                aVar.It(this.hxG);
                aVar.Iu(this.hxI);
                aVar.hA(this.hxJ);
                aVar.Iv(this.hxF);
                aVar.Iw(this.hxH);
                aVar.setAppId(this.mAppId);
                aVar.cY(this.mPackageName);
                aVar.ga(true);
                aVar.tN(bo.getInt(this.hxL, 1));
                aVar.setScene(6001);
                aVar.Ix(this.hxK);
                long a = d.bij().a(aVar.kNl);
                ab.i("MicroMsg.JsApiLaunchApplicationDirectly", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(a)));
                if (a <= 0) {
                    ab.e("MicroMsg.JsApiLaunchApplicationDirectly", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(a)));
                    this.hxN = "";
                } else {
                    this.hxM = false;
                    this.hxO = a;
                }
            }
            aCb();
            AppMethodBeat.o(130463);
        }
    }

    static class a implements aj {
        volatile boolean cEn;
        volatile boolean ftW;
        a hxQ;
        volatile boolean hxt;
        volatile boolean hxu;

        interface a {
            void r(boolean z, boolean z2);
        }

        a(a aVar) {
            this.hxQ = aVar;
        }

        public final void dR(boolean z) {
            AppMethodBeat.i(130476);
            this.ftW = true;
            this.hxt = z;
            if (this.hxu && this.hxQ != null) {
                this.hxQ.r(this.cEn, z);
            }
            AppMethodBeat.o(130476);
        }

        /* Access modifiers changed, original: final */
        public final void dS(boolean z) {
            AppMethodBeat.i(130477);
            this.cEn = z;
            this.hxu = true;
            if (this.ftW && this.hxQ != null) {
                this.hxQ.r(z, this.hxt);
            }
            AppMethodBeat.o(130477);
        }
    }

    public final void a(q qVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130478);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiLaunchApplicationDirectly", "data is null");
            qVar.M(i, j("fail:data is null", null));
            AppMethodBeat.o(130478);
            return;
        }
        final String optString = jSONObject.optString("appId");
        final String optString2 = jSONObject.optString("schemeUrl");
        final String optString3 = jSONObject.optString("parameter");
        int i2 = bo.getInt(jSONObject.optString("alertType"), 0);
        int i3 = bo.getInt(jSONObject.optString("operateDirectly"), 0);
        final String optString4 = jSONObject.optString(IssueStorage.COLUMN_EXT_INFO);
        final String optString5 = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
        final String optString6 = jSONObject.optString("installSchemeUrl");
        final String optString7 = jSONObject.optString("fileMd5");
        final String optString8 = jSONObject.optString("taskName");
        ab.i("MicroMsg.JsApiLaunchApplicationDirectly", "appid : %s, scheme : %s, extinfo:[%s], parameter : %s", optString, optString2, optString4, optString3);
        if (bo.isNullOrNil(optString) && bo.isNullOrNil(optString2)) {
            ab.e("MicroMsg.JsApiLaunchApplicationDirectly", "appid and scheme is null or nil");
            qVar.M(i, j("fail:appid and scheme is null or nil", null));
            AppMethodBeat.o(130478);
            return;
        }
        String url;
        String appId = qVar.getAppId();
        u currentPageView = qVar.getCurrentPageView();
        if (currentPageView != null) {
            url = currentPageView.getURL();
        } else {
            ab.e("MicroMsg.JsApiLaunchApplicationDirectly", "getCurrentPageView is null");
            url = null;
        }
        final Bundle bundle = new Bundle();
        if (!bo.isNullOrNil(url)) {
            try {
                bundle.putString("current_page_url", URLEncoder.encode(url, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
            }
        }
        bundle.putString("current_page_appid", appId);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new avj();
        aVar.fsK = new avk();
        aVar.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        aVar.fsI = 1125;
        avj avj = (avj) aVar.acD().fsG.fsP;
        avj.csB = appId;
        avj.wzn = optString;
        avj.scene = ((o) qVar.getRuntime()).ya().bQn.scene;
        avj.url = url;
        avj.wzo = optString2;
        avj.kCo = i2;
        avj.wzp = 1;
        avj.wzq = i3;
        avj.wzr = optString6;
        ab.i("MicroMsg.JsApiLaunchApplicationDirectly", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s, operateDirectly : %s)", appId, optString, Integer.valueOf(avj.scene), avj.url, avj.wzo, Integer.valueOf(avj.kCo), Integer.valueOf(avj.wzq));
        final q qVar2 = qVar;
        i2 = i;
        b.a(aVar.acD(), new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
            public final void a(final int i, final int i2, String str, final com.tencent.mm.ai.b bVar) {
                AppMethodBeat.i(130456);
                ab.i("MicroMsg.JsApiLaunchApplicationDirectly", "on RunCgi callback errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                com.tencent.mm.ce.a.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(130455);
                        if (i == 0 && i2 == 0) {
                            final avk avk = (avk) bVar.fsH.fsP;
                            switch (avk.cyE) {
                                case 0:
                                    if (avk.wzt == 1) {
                                        qVar2.M(i2, JsApiLaunchApplicationDirectly.this.j("fail:install app denied", null));
                                        AppMethodBeat.o(130455);
                                        return;
                                    }
                                    ab.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication check result(showType:%d, errCode:%d, jumpFlog:%d)", Integer.valueOf(avk.wzs), Integer.valueOf(avk.cyE), Integer.valueOf(avk.wzt));
                                    if (com.tencent.mm.plugin.appbrand.r.b.getPackageInfo(ah.getContext(), optString5) == null) {
                                        JsApiLaunchApplicationDirectly jsApiLaunchApplicationDirectly = JsApiLaunchApplicationDirectly.this;
                                        String str = optString6;
                                        String str2 = optString;
                                        String str3 = optString8;
                                        String str4 = optString7;
                                        String str5 = optString5;
                                        q qVar = qVar2;
                                        int i = i2;
                                        h.a(qVar.getContext(), qVar.getContext().getString(R.string.vi), "", qVar.getContext().getString(R.string.hg), qVar.getContext().getString(R.string.h8), false, (OnClickListener) new AnonymousClass3(qVar, str2, str, str3, str4, str5, i), (OnClickListener) new AnonymousClass4(qVar, i));
                                        AppMethodBeat.o(130455);
                                        return;
                                    }
                                    final a aVar = new a(new a() {
                                        public final void r(boolean z, boolean z2) {
                                            AppMethodBeat.i(130452);
                                            ab.i("MicroMsg.JsApiLaunchApplicationDirectly", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", Boolean.valueOf(z), Boolean.valueOf(z2));
                                            JsApiLaunchApplicationDirectly.a(JsApiLaunchApplicationDirectly.this, qVar2);
                                            if (z) {
                                                qVar2.M(i2, JsApiLaunchApplicationDirectly.this.j("ok", null));
                                                AppMethodBeat.o(130452);
                                                return;
                                            }
                                            qVar2.M(i2, JsApiLaunchApplicationDirectly.this.j("fail:scheme launch fail", null));
                                            AppMethodBeat.o(130452);
                                        }
                                    });
                                    if (!bo.isNullOrNil(optString2)) {
                                        final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(optString2));
                                        intent.addFlags(268435456);
                                        List H = bo.H(qVar2.getContext(), intent);
                                        if (!(H == null || H.isEmpty())) {
                                            Object b;
                                            if (TextUtils.isEmpty(intent.getPackage()) && H.size() == 1) {
                                                b = g.b((ResolveInfo) H.get(0));
                                            } else {
                                                b = intent.getPackage();
                                            }
                                            if (!bo.nullAsNil(ah.getPackageName()).equals(b)) {
                                                al.d(new Runnable() {
                                                    public final void run() {
                                                        AppMethodBeat.i(130453);
                                                        aVar.dS(g.a(qVar2.getContext(), intent, null, avk.wzs, aVar, bundle));
                                                        AppMethodBeat.o(130453);
                                                    }
                                                });
                                                AppMethodBeat.o(130455);
                                                return;
                                            }
                                        }
                                    }
                                    final LaunchApplicationTask launchApplicationTask = new LaunchApplicationTask((MMActivity) qVar2.getContext());
                                    launchApplicationTask.appId = optString;
                                    launchApplicationTask.hxq = optString3;
                                    launchApplicationTask.extInfo = optString4;
                                    launchApplicationTask.cvs = bundle;
                                    launchApplicationTask.showType = avk.wzs;
                                    launchApplicationTask.hww = new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(130454);
                                            ab.i("MicroMsg.JsApiLaunchApplicationDirectly", "callback task.success:%b", Boolean.valueOf(launchApplicationTask.success));
                                            launchApplicationTask.aBW();
                                            if (launchApplicationTask.success) {
                                                qVar2.M(i2, JsApiLaunchApplicationDirectly.this.j("ok", null));
                                                AppMethodBeat.o(130454);
                                                return;
                                            }
                                            qVar2.M(i2, JsApiLaunchApplicationDirectly.this.j("fail:sdk launch fail", null));
                                            AppMethodBeat.o(130454);
                                        }
                                    };
                                    launchApplicationTask.aBV();
                                    launchApplicationTask.aBU();
                                    AppMethodBeat.o(130455);
                                    return;
                                case 2:
                                    qVar2.M(i2, JsApiLaunchApplicationDirectly.this.j("fail:check fail forbidden scene 2", null));
                                    AppMethodBeat.o(130455);
                                    return;
                                default:
                                    qVar2.M(i2, JsApiLaunchApplicationDirectly.this.j("fail:check fail 1", null));
                                    AppMethodBeat.o(130455);
                                    return;
                            }
                        }
                        qVar2.M(i2, JsApiLaunchApplicationDirectly.this.j("fail:check fail", null));
                        AppMethodBeat.o(130455);
                    }
                });
                AppMethodBeat.o(130456);
            }
        });
        AppMethodBeat.o(130478);
    }

    static /* synthetic */ void a(JsApiLaunchApplicationDirectly jsApiLaunchApplicationDirectly, final q qVar) {
        AppMethodBeat.i(130480);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(130457);
                if (qVar != null) {
                    if ("wxfe02ecfe70800f46".equalsIgnoreCase(qVar.getAppId()) && qVar.getContext() != null && (qVar.getContext() instanceof Activity)) {
                        n.c(((Activity) qVar.getContext()).getWindow(), true);
                    }
                }
                AppMethodBeat.o(130457);
            }
        });
        AppMethodBeat.o(130480);
    }
}
