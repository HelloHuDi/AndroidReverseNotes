package com.tencent.p177mm.plugin.appbrand.jsapi;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b.C9557a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.constants.Build;
import com.tencent.p177mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C32579jc;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask.C19245a;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.p328r.C19679b;
import com.tencent.p177mm.plugin.appbrand.p336ui.C42696n;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.C2900e.C2901a;
import com.tencent.p177mm.pluginsdk.model.app.C14875aj;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.protocal.protobuf.avj;
import com.tencent.p177mm.protocal.protobuf.avk;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly */
public final class JsApiLaunchApplicationDirectly extends JsApiLaunchApplication {
    private static final int CTRL_INDEX = 620;
    private static final String NAME = "launchApplicationDirectly";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly$3 */
    class C21783 implements OnClickListener {
        final /* synthetic */ int eIl;
        final /* synthetic */ C38492q hsD;
        final /* synthetic */ String hxw;
        final /* synthetic */ String hxx;
        final /* synthetic */ String hxy;
        final /* synthetic */ String val$appId;
        final /* synthetic */ String val$packageName;

        C21783(C38492q c38492q, String str, String str2, String str3, String str4, String str5, int i) {
            this.hsD = c38492q;
            this.val$appId = str;
            this.hxw = str2;
            this.hxx = str3;
            this.hxy = str4;
            this.val$packageName = str5;
            this.eIl = i;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(130458);
            JsApiLaunchApplicationDirectly.m4388a(JsApiLaunchApplicationDirectly.this, this.hsD);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appId", this.val$appId);
                jSONObject.put("taskUrl", this.hxw);
                jSONObject.put("taskName", this.hxx);
                jSONObject.put("fileMd5", this.hxy);
                jSONObject.put(DownloadInfoColumns.PACKAGENAME, this.val$packageName);
                AppBrandMainProcessService.m54349a(new AddDownloadTaskStraightTask(JsApiLaunchApplicationDirectly.this, this.hsD, this.eIl, jSONObject));
                this.hsD.mo6107M(this.eIl, JsApiLaunchApplicationDirectly.this.mo73394j("ok:user downloaded app", null));
                AppMethodBeat.m2505o(130458);
            } catch (JSONException e) {
                C4990ab.m7413e("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication, download app fail", e);
                this.hsD.mo6107M(this.eIl, JsApiLaunchApplicationDirectly.this.mo73394j("fail:download app fail", null));
                AppMethodBeat.m2505o(130458);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly$4 */
    class C21794 implements OnClickListener {
        final /* synthetic */ int eIl;
        final /* synthetic */ C38492q hsD;

        C21794(C38492q c38492q, int i) {
            this.hsD = c38492q;
            this.eIl = i;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(130459);
            C4990ab.m7416i("MicroMsg.JsApiLaunchApplicationDirectly", "fail:user canceled install");
            JsApiLaunchApplicationDirectly.m4388a(JsApiLaunchApplicationDirectly.this, this.hsD);
            this.hsD.mo6107M(this.eIl, JsApiLaunchApplicationDirectly.this.mo73394j("fail:user canceled install", null));
            AppMethodBeat.m2505o(130459);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly$LaunchApplicationTask */
    static class LaunchApplicationTask extends AppBrandProxyTransparentUIProcessTask {
        public static final Creator<LaunchApplicationTask> CREATOR = new C21802();
        public String appId;
        public Bundle cvs;
        public String extInfo;
        public Runnable hww;
        public String hxq;
        public int showType;
        public boolean success;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly$LaunchApplicationTask$2 */
        static class C21802 implements Creator<LaunchApplicationTask> {
            C21802() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LaunchApplicationTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130469);
                LaunchApplicationTask launchApplicationTask = new LaunchApplicationTask(parcel, (byte) 0);
                AppMethodBeat.m2505o(130469);
                return launchApplicationTask;
            }
        }

        /* synthetic */ LaunchApplicationTask(Parcel parcel, byte b) {
            this(parcel);
        }

        /* renamed from: a */
        public final void mo6020a(Context context, final C19245a c19245a) {
            AppMethodBeat.m2504i(130470);
            C2188a c2188a = new C2188a(new C2189a() {
                /* renamed from: r */
                public final void mo6026r(boolean z, boolean z2) {
                    AppMethodBeat.m2504i(130468);
                    C4990ab.m7417i("MicroMsg.JsApiLaunchApplicationDirectly", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", Boolean.valueOf(z), Boolean.valueOf(z2));
                    if (z) {
                        LaunchApplicationTask.this.success = true;
                        c19245a.aBT();
                        AppMethodBeat.m2505o(130468);
                        return;
                    }
                    LaunchApplicationTask.this.success = false;
                    c19245a.aBT();
                    AppMethodBeat.m2505o(130468);
                }
            });
            WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
            wXAppExtendObject.extInfo = this.extInfo;
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
            wXMediaMessage.sdkVer = Build.SDK_INT;
            wXMediaMessage.messageExt = this.extInfo;
            C32579jc c32579jc = new C32579jc();
            c32579jc.cEj.cEl = wXMediaMessage;
            c32579jc.cEj.appId = this.appId;
            c32579jc.cEj.showType = this.showType;
            c32579jc.cEj.context = context;
            c32579jc.cEj.cvs = this.cvs;
            c32579jc.cEj.cEm = c2188a;
            C4879a.xxA.mo10055m(c32579jc);
            boolean z = c32579jc.cEk.cEn;
            if (!z) {
                if (C5046bo.isNullOrNil(this.appId) || C5046bo.isNullOrNil(this.hxq)) {
                    C4990ab.m7416i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication nil appId or parameter.");
                } else {
                    boolean a;
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.appId + "://" + this.hxq));
                    C4990ab.m7417i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication by opensdk failed, try to launch by scheme(%s).", r0);
                    intent.addFlags(268435456);
                    List H = C5046bo.m7502H(context, intent);
                    if (!(H == null || H.isEmpty())) {
                        Object b;
                        if (TextUtils.isEmpty(intent.getPackage()) && H.size() == 1) {
                            b = C46494g.m87734b((ResolveInfo) H.get(0));
                        } else {
                            b = intent.getPackage();
                        }
                        if (!C5046bo.nullAsNil(C4996ah.getPackageName()).equals(b)) {
                            c2188a.ftW = false;
                            c2188a.hxt = false;
                            c2188a.hxu = false;
                            c2188a.cEn = false;
                            a = C46494g.m87725a(context, intent, null, c2188a, this.cvs);
                            z = a;
                        }
                    }
                    a = z;
                    z = a;
                }
            }
            c2188a.mo6037dS(z);
            AppMethodBeat.m2505o(130470);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(130471);
            C4990ab.m7416i("MicroMsg.JsApiLaunchApplicationDirectly", "runInClientProcess");
            if (this.hww != null) {
                C4990ab.m7416i("MicroMsg.JsApiLaunchApplicationDirectly", "runInClientProcess asyncCallback != null");
                this.hww.run();
            }
            AppMethodBeat.m2505o(130471);
        }

        /* renamed from: g */
        public final void mo6022g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.m2504i(130472);
            this.showType = parcel.readInt();
            this.appId = parcel.readString();
            this.hxq = parcel.readString();
            this.extInfo = parcel.readString();
            this.cvs = parcel.readBundle();
            if (parcel.readByte() != (byte) 1) {
                z = false;
            }
            this.success = z;
            AppMethodBeat.m2505o(130472);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(130473);
            parcel.writeInt(this.showType);
            parcel.writeString(this.appId);
            parcel.writeString(this.hxq);
            parcel.writeString(this.extInfo);
            parcel.writeBundle(this.cvs);
            parcel.writeByte((byte) (this.success ? 1 : 0));
            AppMethodBeat.m2505o(130473);
        }

        public LaunchApplicationTask(MMActivity mMActivity) {
            super(mMActivity);
        }

        private LaunchApplicationTask(Parcel parcel) {
            AppMethodBeat.m2504i(130474);
            mo6022g(parcel);
            AppMethodBeat.m2505o(130474);
        }

        static {
            AppMethodBeat.m2504i(130475);
            AppMethodBeat.m2505o(130475);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly$AddDownloadTaskStraightTask */
    static class AddDownloadTaskStraightTask extends MainProcessTask {
        public static final Creator<AddDownloadTaskStraightTask> CREATOR = new C21871();
        private int bOs;
        private C38492q gNC;
        private C45608m hxE;
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

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly$AddDownloadTaskStraightTask$1 */
        static class C21871 implements Creator<AddDownloadTaskStraightTask> {
            C21871() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AddDownloadTaskStraightTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130460);
                AddDownloadTaskStraightTask addDownloadTaskStraightTask = new AddDownloadTaskStraightTask(parcel);
                AppMethodBeat.m2505o(130460);
                return addDownloadTaskStraightTask;
            }
        }

        public AddDownloadTaskStraightTask(C45608m c45608m, C38492q c38492q, int i, JSONObject jSONObject) {
            AppMethodBeat.m2504i(130461);
            this.hxE = c45608m;
            this.gNC = c38492q;
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
            AppMethodBeat.m2505o(130461);
        }

        public AddDownloadTaskStraightTask(Parcel parcel) {
            AppMethodBeat.m2504i(130462);
            mo6032g(parcel);
            AppMethodBeat.m2505o(130462);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(130464);
            if (this.hxM) {
                String str;
                if (C5046bo.isNullOrNil(this.hxN)) {
                    str = "fail";
                } else {
                    str = String.format("fail:%s", new Object[]{this.hxN});
                }
                this.gNC.mo6107M(this.bOs, this.hxE.mo73394j(str, null));
                AppMethodBeat.m2505o(130464);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("downloadId", Long.valueOf(this.hxO));
            this.gNC.mo6107M(this.bOs, this.hxE.mo73394j("ok", hashMap));
            AppMethodBeat.m2505o(130464);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.m2504i(130465);
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
            AppMethodBeat.m2505o(130465);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(130466);
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
            AppMethodBeat.m2505o(130466);
        }

        static {
            AppMethodBeat.m2504i(130467);
            AppMethodBeat.m2505o(130467);
        }

        public final void asP() {
            AppMethodBeat.m2504i(130463);
            C1720g.m3537RQ();
            if (!C1720g.m3536RP().isSDCardAvailable()) {
                this.hxN = "fail_sdcard_not_ready";
            } else if (this.hxJ > 0 && !C1445f.m3072eW(this.hxJ)) {
                this.hxN = "fail_sdcard_has_not_enough_space";
            } else if (C5046bo.isNullOrNil(this.hxG)) {
                this.hxN = "fail_invalid_url";
            } else {
                C4990ab.m7417i("MicroMsg.JsApiLaunchApplicationDirectly", "runInMainProcess taskUrl:%s md5:%s", this.hxG, this.hxH);
                C2901a c2901a = new C2901a();
                c2901a.mo7055It(this.hxG);
                c2901a.mo7056Iu(this.hxI);
                c2901a.mo7066hA(this.hxJ);
                c2901a.mo7057Iv(this.hxF);
                c2901a.mo7058Iw(this.hxH);
                c2901a.setAppId(this.mAppId);
                c2901a.mo7062cY(this.mPackageName);
                c2901a.mo7063ga(true);
                c2901a.mo7069tN(C5046bo.getInt(this.hxL, 1));
                c2901a.setScene(6001);
                c2901a.mo7059Ix(this.hxK);
                long a = C2896d.bij().mo7042a(c2901a.kNl);
                C4990ab.m7416i("MicroMsg.JsApiLaunchApplicationDirectly", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(a)));
                if (a <= 0) {
                    C4990ab.m7412e("MicroMsg.JsApiLaunchApplicationDirectly", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(a)));
                    this.hxN = "";
                } else {
                    this.hxM = false;
                    this.hxO = a;
                }
            }
            aCb();
            AppMethodBeat.m2505o(130463);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly$a */
    static class C2188a implements C14875aj {
        volatile boolean cEn;
        volatile boolean ftW;
        C2189a hxQ;
        volatile boolean hxt;
        volatile boolean hxu;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly$a$a */
        interface C2189a {
            /* renamed from: r */
            void mo6026r(boolean z, boolean z2);
        }

        C2188a(C2189a c2189a) {
            this.hxQ = c2189a;
        }

        /* renamed from: dR */
        public final void mo6036dR(boolean z) {
            AppMethodBeat.m2504i(130476);
            this.ftW = true;
            this.hxt = z;
            if (this.hxu && this.hxQ != null) {
                this.hxQ.mo6026r(this.cEn, z);
            }
            AppMethodBeat.m2505o(130476);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dS */
        public final void mo6037dS(boolean z) {
            AppMethodBeat.m2504i(130477);
            this.cEn = z;
            this.hxu = true;
            if (this.ftW && this.hxQ != null) {
                this.hxQ.mo6026r(z, this.hxt);
            }
            AppMethodBeat.m2505o(130477);
        }
    }

    /* renamed from: a */
    public final void mo6018a(C38492q c38492q, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130478);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiLaunchApplicationDirectly", "data is null");
            c38492q.mo6107M(i, mo73394j("fail:data is null", null));
            AppMethodBeat.m2505o(130478);
            return;
        }
        final String optString = jSONObject.optString("appId");
        final String optString2 = jSONObject.optString("schemeUrl");
        final String optString3 = jSONObject.optString("parameter");
        int i2 = C5046bo.getInt(jSONObject.optString("alertType"), 0);
        int i3 = C5046bo.getInt(jSONObject.optString("operateDirectly"), 0);
        final String optString4 = jSONObject.optString(IssueStorage.COLUMN_EXT_INFO);
        final String optString5 = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
        final String optString6 = jSONObject.optString("installSchemeUrl");
        final String optString7 = jSONObject.optString("fileMd5");
        final String optString8 = jSONObject.optString("taskName");
        C4990ab.m7417i("MicroMsg.JsApiLaunchApplicationDirectly", "appid : %s, scheme : %s, extinfo:[%s], parameter : %s", optString, optString2, optString4, optString3);
        if (C5046bo.isNullOrNil(optString) && C5046bo.isNullOrNil(optString2)) {
            C4990ab.m7412e("MicroMsg.JsApiLaunchApplicationDirectly", "appid and scheme is null or nil");
            c38492q.mo6107M(i, mo73394j("fail:appid and scheme is null or nil", null));
            AppMethodBeat.m2505o(130478);
            return;
        }
        String url;
        String appId = c38492q.getAppId();
        C44709u currentPageView = c38492q.getCurrentPageView();
        if (currentPageView != null) {
            url = currentPageView.getURL();
        } else {
            C4990ab.m7412e("MicroMsg.JsApiLaunchApplicationDirectly", "getCurrentPageView is null");
            url = null;
        }
        final Bundle bundle = new Bundle();
        if (!C5046bo.isNullOrNil(url)) {
            try {
                bundle.putString("current_page_url", URLEncoder.encode(url, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
            }
        }
        bundle.putString("current_page_appid", appId);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new avj();
        c1196a.fsK = new avk();
        c1196a.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        c1196a.fsI = 1125;
        avj avj = (avj) c1196a.acD().fsG.fsP;
        avj.csB = appId;
        avj.wzn = optString;
        avj.scene = ((C41243o) c38492q.getRuntime()).mo43491ya().bQn.scene;
        avj.url = url;
        avj.wzo = optString2;
        avj.kCo = i2;
        avj.wzp = 1;
        avj.wzq = i3;
        avj.wzr = optString6;
        C4990ab.m7417i("MicroMsg.JsApiLaunchApplicationDirectly", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s, operateDirectly : %s)", appId, optString, Integer.valueOf(avj.scene), avj.url, avj.wzo, Integer.valueOf(avj.kCo), Integer.valueOf(avj.wzq));
        final C38492q c38492q2 = c38492q;
        i2 = i;
        C42146b.m74301a(c1196a.acD(), new C9557a() {
            /* renamed from: a */
            public final void mo5951a(final int i, final int i2, String str, final C7472b c7472b) {
                AppMethodBeat.m2504i(130456);
                C4990ab.m7417i("MicroMsg.JsApiLaunchApplicationDirectly", "on RunCgi callback errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                C26006a.post(new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly$1$1$1 */
                    class C21861 implements C2189a {
                        C21861() {
                        }

                        /* renamed from: r */
                        public final void mo6026r(boolean z, boolean z2) {
                            AppMethodBeat.m2504i(130452);
                            C4990ab.m7417i("MicroMsg.JsApiLaunchApplicationDirectly", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", Boolean.valueOf(z), Boolean.valueOf(z2));
                            JsApiLaunchApplicationDirectly.m4388a(JsApiLaunchApplicationDirectly.this, c38492q2);
                            if (z) {
                                c38492q2.mo6107M(i2, JsApiLaunchApplicationDirectly.this.mo73394j("ok", null));
                                AppMethodBeat.m2505o(130452);
                                return;
                            }
                            c38492q2.mo6107M(i2, JsApiLaunchApplicationDirectly.this.mo73394j("fail:scheme launch fail", null));
                            AppMethodBeat.m2505o(130452);
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(130455);
                        if (i == 0 && i2 == 0) {
                            final avk avk = (avk) c7472b.fsH.fsP;
                            switch (avk.cyE) {
                                case 0:
                                    if (avk.wzt == 1) {
                                        c38492q2.mo6107M(i2, JsApiLaunchApplicationDirectly.this.mo73394j("fail:install app denied", null));
                                        AppMethodBeat.m2505o(130455);
                                        return;
                                    }
                                    C4990ab.m7417i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication check result(showType:%d, errCode:%d, jumpFlog:%d)", Integer.valueOf(avk.wzs), Integer.valueOf(avk.cyE), Integer.valueOf(avk.wzt));
                                    if (C19679b.getPackageInfo(C4996ah.getContext(), optString5) == null) {
                                        JsApiLaunchApplicationDirectly jsApiLaunchApplicationDirectly = JsApiLaunchApplicationDirectly.this;
                                        String str = optString6;
                                        String str2 = optString;
                                        String str3 = optString8;
                                        String str4 = optString7;
                                        String str5 = optString5;
                                        C38492q c38492q = c38492q2;
                                        int i = i2;
                                        C30379h.m48445a(c38492q.getContext(), c38492q.getContext().getString(C25738R.string.f9284vi), "", c38492q.getContext().getString(C25738R.string.f8863hg), c38492q.getContext().getString(C25738R.string.f8856h8), false, (OnClickListener) new C21783(c38492q, str2, str, str3, str4, str5, i), (OnClickListener) new C21794(c38492q, i));
                                        AppMethodBeat.m2505o(130455);
                                        return;
                                    }
                                    final C2188a c2188a = new C2188a(new C21861());
                                    if (!C5046bo.isNullOrNil(optString2)) {
                                        final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(optString2));
                                        intent.addFlags(268435456);
                                        List H = C5046bo.m7502H(c38492q2.getContext(), intent);
                                        if (!(H == null || H.isEmpty())) {
                                            Object b;
                                            if (TextUtils.isEmpty(intent.getPackage()) && H.size() == 1) {
                                                b = C46494g.m87734b((ResolveInfo) H.get(0));
                                            } else {
                                                b = intent.getPackage();
                                            }
                                            if (!C5046bo.nullAsNil(C4996ah.getPackageName()).equals(b)) {
                                                C5004al.m7441d(new Runnable() {
                                                    public final void run() {
                                                        AppMethodBeat.m2504i(130453);
                                                        c2188a.mo6037dS(C46494g.m87723a(c38492q2.getContext(), intent, null, avk.wzs, c2188a, bundle));
                                                        AppMethodBeat.m2505o(130453);
                                                    }
                                                });
                                                AppMethodBeat.m2505o(130455);
                                                return;
                                            }
                                        }
                                    }
                                    final LaunchApplicationTask launchApplicationTask = new LaunchApplicationTask((MMActivity) c38492q2.getContext());
                                    launchApplicationTask.appId = optString;
                                    launchApplicationTask.hxq = optString3;
                                    launchApplicationTask.extInfo = optString4;
                                    launchApplicationTask.cvs = bundle;
                                    launchApplicationTask.showType = avk.wzs;
                                    launchApplicationTask.hww = new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.m2504i(130454);
                                            C4990ab.m7417i("MicroMsg.JsApiLaunchApplicationDirectly", "callback task.success:%b", Boolean.valueOf(launchApplicationTask.success));
                                            launchApplicationTask.aBW();
                                            if (launchApplicationTask.success) {
                                                c38492q2.mo6107M(i2, JsApiLaunchApplicationDirectly.this.mo73394j("ok", null));
                                                AppMethodBeat.m2505o(130454);
                                                return;
                                            }
                                            c38492q2.mo6107M(i2, JsApiLaunchApplicationDirectly.this.mo73394j("fail:sdk launch fail", null));
                                            AppMethodBeat.m2505o(130454);
                                        }
                                    };
                                    launchApplicationTask.aBV();
                                    launchApplicationTask.aBU();
                                    AppMethodBeat.m2505o(130455);
                                    return;
                                case 2:
                                    c38492q2.mo6107M(i2, JsApiLaunchApplicationDirectly.this.mo73394j("fail:check fail forbidden scene 2", null));
                                    AppMethodBeat.m2505o(130455);
                                    return;
                                default:
                                    c38492q2.mo6107M(i2, JsApiLaunchApplicationDirectly.this.mo73394j("fail:check fail 1", null));
                                    AppMethodBeat.m2505o(130455);
                                    return;
                            }
                        }
                        c38492q2.mo6107M(i2, JsApiLaunchApplicationDirectly.this.mo73394j("fail:check fail", null));
                        AppMethodBeat.m2505o(130455);
                    }
                });
                AppMethodBeat.m2505o(130456);
            }
        });
        AppMethodBeat.m2505o(130478);
    }

    /* renamed from: a */
    static /* synthetic */ void m4388a(JsApiLaunchApplicationDirectly jsApiLaunchApplicationDirectly, final C38492q c38492q) {
        AppMethodBeat.m2504i(130480);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(130457);
                if (c38492q != null) {
                    if ("wxfe02ecfe70800f46".equalsIgnoreCase(c38492q.getAppId()) && c38492q.getContext() != null && (c38492q.getContext() instanceof Activity)) {
                        C42696n.m75620c(((Activity) c38492q.getContext()).getWindow(), true);
                    }
                }
                AppMethodBeat.m2505o(130457);
            }
        });
        AppMethodBeat.m2505o(130480);
    }
}
