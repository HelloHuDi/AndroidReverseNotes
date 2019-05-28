package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b.C9557a;
import com.tencent.p177mm.opensdk.constants.Build;
import com.tencent.p177mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C32579jc;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask.C19245a;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication */
public class JsApiLaunchApplication extends C10296a<C38492q> {
    private static final int CTRL_INDEX = 427;
    private static final String NAME = "launchApplication";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication$a */
    static class C19267a implements C14875aj {
        volatile boolean cEn;
        volatile boolean ftW;
        volatile boolean hxt;
        volatile boolean hxu;
        C19268a hxv;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication$a$a */
        interface C19268a {
            /* renamed from: r */
            void mo34467r(boolean z, boolean z2);
        }

        C19267a(C19268a c19268a) {
            this.hxv = c19268a;
        }

        /* renamed from: dR */
        public final void mo6036dR(boolean z) {
            AppMethodBeat.m2504i(130448);
            this.ftW = true;
            this.hxt = z;
            if (this.hxu && this.hxv != null) {
                this.hxv.mo34467r(this.cEn, z);
            }
            AppMethodBeat.m2505o(130448);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: dS */
        public final void mo34470dS(boolean z) {
            AppMethodBeat.m2504i(130449);
            this.cEn = z;
            this.hxu = true;
            if (this.ftW && this.hxv != null) {
                this.hxv.mo34467r(z, this.hxt);
            }
            AppMethodBeat.m2505o(130449);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication$LaunchApplicationTask */
    static class LaunchApplicationTask extends AppBrandProxyTransparentUIProcessTask {
        public static final Creator<LaunchApplicationTask> CREATOR = new C192662();
        public String appId;
        public Bundle cvs;
        public String extInfo;
        public Runnable hww;
        public String hxq;
        public int showType;
        public boolean success;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication$LaunchApplicationTask$2 */
        static class C192662 implements Creator<LaunchApplicationTask> {
            C192662() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LaunchApplicationTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130441);
                LaunchApplicationTask launchApplicationTask = new LaunchApplicationTask(parcel, (byte) 0);
                AppMethodBeat.m2505o(130441);
                return launchApplicationTask;
            }
        }

        /* synthetic */ LaunchApplicationTask(Parcel parcel, byte b) {
            this(parcel);
        }

        /* renamed from: a */
        public final void mo6020a(Context context, final C19245a c19245a) {
            AppMethodBeat.m2504i(130442);
            C19267a c19267a = new C19267a(new C19268a() {
                /* renamed from: r */
                public final void mo34467r(boolean z, boolean z2) {
                    AppMethodBeat.m2504i(130440);
                    C4990ab.m7417i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", Boolean.valueOf(z), Boolean.valueOf(z2));
                    if (z) {
                        LaunchApplicationTask.this.success = true;
                        c19245a.aBT();
                        AppMethodBeat.m2505o(130440);
                        return;
                    }
                    LaunchApplicationTask.this.success = false;
                    c19245a.aBT();
                    AppMethodBeat.m2505o(130440);
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
            c32579jc.cEj.cEm = c19267a;
            C4879a.xxA.mo10055m(c32579jc);
            boolean z = c32579jc.cEk.cEn;
            if (!z) {
                if (C5046bo.isNullOrNil(this.appId) || C5046bo.isNullOrNil(this.hxq)) {
                    C4990ab.m7416i("MicroMsg.JsApiLaunchApplication", "launchApplication nil appId or parameter.");
                } else {
                    boolean a;
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.appId + "://" + this.hxq));
                    C4990ab.m7417i("MicroMsg.JsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", r0);
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
                            c19267a.ftW = false;
                            c19267a.hxt = false;
                            c19267a.hxu = false;
                            c19267a.cEn = false;
                            a = C46494g.m87725a(context, intent, null, c19267a, this.cvs);
                            z = a;
                        }
                    }
                    a = z;
                    z = a;
                }
            }
            c19267a.mo34470dS(z);
            AppMethodBeat.m2505o(130442);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(130443);
            C4990ab.m7416i("MicroMsg.JsApiLaunchApplication", "runInClientProcess");
            if (this.hww != null) {
                C4990ab.m7416i("MicroMsg.JsApiLaunchApplication", "runInClientProcess asyncCallback != null");
                this.hww.run();
            }
            AppMethodBeat.m2505o(130443);
        }

        /* renamed from: g */
        public final void mo6022g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.m2504i(130444);
            this.showType = parcel.readInt();
            this.appId = parcel.readString();
            this.hxq = parcel.readString();
            this.extInfo = parcel.readString();
            this.cvs = parcel.readBundle();
            if (parcel.readByte() != (byte) 1) {
                z = false;
            }
            this.success = z;
            AppMethodBeat.m2505o(130444);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(130445);
            parcel.writeInt(this.showType);
            parcel.writeString(this.appId);
            parcel.writeString(this.hxq);
            parcel.writeString(this.extInfo);
            parcel.writeBundle(this.cvs);
            parcel.writeByte((byte) (this.success ? 1 : 0));
            AppMethodBeat.m2505o(130445);
        }

        public LaunchApplicationTask(MMActivity mMActivity) {
            super(mMActivity);
        }

        private LaunchApplicationTask(Parcel parcel) {
            AppMethodBeat.m2504i(130446);
            mo6022g(parcel);
            AppMethodBeat.m2505o(130446);
        }

        static {
            AppMethodBeat.m2504i(130447);
            AppMethodBeat.m2505o(130447);
        }
    }

    /* renamed from: a */
    public void mo6018a(C38492q c38492q, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130450);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiLaunchApplication", "data is null");
            c38492q.mo6107M(i, mo73394j("fail:data is null", null));
            AppMethodBeat.m2505o(130450);
            return;
        }
        final String optString = jSONObject.optString("appId");
        final String optString2 = jSONObject.optString("schemeUrl");
        final String optString3 = jSONObject.optString("parameter");
        int i2 = C5046bo.getInt(jSONObject.optString("alertType"), 0);
        int i3 = C5046bo.getInt(jSONObject.optString("operateDirectly"), 0);
        final String optString4 = jSONObject.optString(IssueStorage.COLUMN_EXT_INFO);
        C4990ab.m7417i("MicroMsg.JsApiLaunchApplication", "appid : %s, scheme : %s, extinfo:[%s], parameter : %s", optString, optString2, optString4, optString3);
        if (C5046bo.isNullOrNil(optString) && C5046bo.isNullOrNil(optString2)) {
            C4990ab.m7412e("MicroMsg.JsApiLaunchApplication", "appid and scheme is null or nil");
            c38492q.mo6107M(i, mo73394j("fail:appid and scheme is null or nil", null));
            AppMethodBeat.m2505o(130450);
            return;
        }
        String url;
        String appId = c38492q.getAppId();
        C44709u currentPageView = c38492q.getCurrentPageView();
        if (currentPageView != null) {
            url = currentPageView.getURL();
        } else {
            C4990ab.m7412e("MicroMsg.JsApiLaunchApplication", "getCurrentPageView is null");
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
        C4990ab.m7417i("MicroMsg.JsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s, operateDirectly : %s)", appId, optString, Integer.valueOf(avj.scene), avj.url, avj.wzo, Integer.valueOf(avj.kCo), Integer.valueOf(avj.wzq));
        final C38492q c38492q2 = c38492q;
        i2 = i;
        C42146b.m74301a(c1196a.acD(), new C9557a() {
            /* renamed from: a */
            public final void mo5951a(final int i, final int i2, String str, final C7472b c7472b) {
                AppMethodBeat.m2504i(130439);
                C4990ab.m7417i("MicroMsg.JsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                C26006a.post(new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication$1$1$1 */
                    class C192641 implements C19268a {
                        C192641() {
                        }

                        /* renamed from: r */
                        public final void mo34467r(boolean z, boolean z2) {
                            AppMethodBeat.m2504i(130435);
                            C4990ab.m7417i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", Boolean.valueOf(z), Boolean.valueOf(z2));
                            if (z) {
                                c38492q2.mo6107M(i2, JsApiLaunchApplication.this.mo73394j("ok", null));
                                AppMethodBeat.m2505o(130435);
                                return;
                            }
                            c38492q2.mo6107M(i2, JsApiLaunchApplication.this.mo73394j("fail:scheme launch fail", null));
                            AppMethodBeat.m2505o(130435);
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(130438);
                        if (i == 0 && i2 == 0) {
                            final avk avk = (avk) c7472b.fsH.fsP;
                            switch (avk.cyE) {
                                case 0:
                                    final C19267a c19267a = new C19267a(new C192641());
                                    C4990ab.m7417i("MicroMsg.JsApiLaunchApplication", "launchApplication check result(showType : %d, errCode : %d)", Integer.valueOf(avk.wzs), Integer.valueOf(avk.cyE));
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
                                                        AppMethodBeat.m2504i(130436);
                                                        c19267a.mo34470dS(C46494g.m87723a(c38492q2.getContext(), intent, null, avk.wzs, c19267a, bundle));
                                                        AppMethodBeat.m2505o(130436);
                                                    }
                                                });
                                                AppMethodBeat.m2505o(130438);
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
                                            AppMethodBeat.m2504i(130437);
                                            C4990ab.m7417i("MicroMsg.JsApiLaunchApplication", "callback task.success:%b", Boolean.valueOf(launchApplicationTask.success));
                                            launchApplicationTask.aBW();
                                            if (launchApplicationTask.success) {
                                                c38492q2.mo6107M(i2, JsApiLaunchApplication.this.mo73394j("ok", null));
                                                AppMethodBeat.m2505o(130437);
                                                return;
                                            }
                                            c38492q2.mo6107M(i2, JsApiLaunchApplication.this.mo73394j("fail:sdk launch fail", null));
                                            AppMethodBeat.m2505o(130437);
                                        }
                                    };
                                    launchApplicationTask.aBV();
                                    launchApplicationTask.aBU();
                                    AppMethodBeat.m2505o(130438);
                                    return;
                                case 2:
                                    c38492q2.mo6107M(i2, JsApiLaunchApplication.this.mo73394j("fail:check fail forbidden scene 2", null));
                                    AppMethodBeat.m2505o(130438);
                                    return;
                                default:
                                    c38492q2.mo6107M(i2, JsApiLaunchApplication.this.mo73394j("fail:check fail 1", null));
                                    AppMethodBeat.m2505o(130438);
                                    return;
                            }
                        }
                        c38492q2.mo6107M(i2, JsApiLaunchApplication.this.mo73394j("fail:check fail", null));
                        AppMethodBeat.m2505o(130438);
                    }
                });
                AppMethodBeat.m2505o(130439);
            }
        });
        AppMethodBeat.m2505o(130450);
    }
}
