package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jc;
import com.tencent.mm.ipcinvoker.wx_extension.b;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.pluginsdk.model.app.aj;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.protocal.protobuf.avk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public class JsApiLaunchApplication extends a<q> {
    private static final int CTRL_INDEX = 427;
    private static final String NAME = "launchApplication";

    static class a implements aj {
        volatile boolean cEn;
        volatile boolean ftW;
        volatile boolean hxt;
        volatile boolean hxu;
        a hxv;

        interface a {
            void r(boolean z, boolean z2);
        }

        a(a aVar) {
            this.hxv = aVar;
        }

        public final void dR(boolean z) {
            AppMethodBeat.i(130448);
            this.ftW = true;
            this.hxt = z;
            if (this.hxu && this.hxv != null) {
                this.hxv.r(this.cEn, z);
            }
            AppMethodBeat.o(130448);
        }

        /* Access modifiers changed, original: final */
        public final void dS(boolean z) {
            AppMethodBeat.i(130449);
            this.cEn = z;
            this.hxu = true;
            if (this.ftW && this.hxv != null) {
                this.hxv.r(z, this.hxt);
            }
            AppMethodBeat.o(130449);
        }
    }

    static class LaunchApplicationTask extends AppBrandProxyTransparentUIProcessTask {
        public static final Creator<LaunchApplicationTask> CREATOR = new Creator<LaunchApplicationTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LaunchApplicationTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130441);
                LaunchApplicationTask launchApplicationTask = new LaunchApplicationTask(parcel, (byte) 0);
                AppMethodBeat.o(130441);
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
            AppMethodBeat.i(130442);
            a aVar2 = new a(new a() {
                public final void r(boolean z, boolean z2) {
                    AppMethodBeat.i(130440);
                    ab.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", Boolean.valueOf(z), Boolean.valueOf(z2));
                    if (z) {
                        LaunchApplicationTask.this.success = true;
                        aVar.aBT();
                        AppMethodBeat.o(130440);
                        return;
                    }
                    LaunchApplicationTask.this.success = false;
                    aVar.aBT();
                    AppMethodBeat.o(130440);
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
                    ab.i("MicroMsg.JsApiLaunchApplication", "launchApplication nil appId or parameter.");
                } else {
                    boolean a;
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.appId + "://" + this.hxq));
                    ab.i("MicroMsg.JsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", r0);
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
            AppMethodBeat.o(130442);
        }

        public final void asQ() {
            AppMethodBeat.i(130443);
            ab.i("MicroMsg.JsApiLaunchApplication", "runInClientProcess");
            if (this.hww != null) {
                ab.i("MicroMsg.JsApiLaunchApplication", "runInClientProcess asyncCallback != null");
                this.hww.run();
            }
            AppMethodBeat.o(130443);
        }

        public final void g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(130444);
            this.showType = parcel.readInt();
            this.appId = parcel.readString();
            this.hxq = parcel.readString();
            this.extInfo = parcel.readString();
            this.cvs = parcel.readBundle();
            if (parcel.readByte() != (byte) 1) {
                z = false;
            }
            this.success = z;
            AppMethodBeat.o(130444);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(130445);
            parcel.writeInt(this.showType);
            parcel.writeString(this.appId);
            parcel.writeString(this.hxq);
            parcel.writeString(this.extInfo);
            parcel.writeBundle(this.cvs);
            parcel.writeByte((byte) (this.success ? 1 : 0));
            AppMethodBeat.o(130445);
        }

        public LaunchApplicationTask(MMActivity mMActivity) {
            super(mMActivity);
        }

        private LaunchApplicationTask(Parcel parcel) {
            AppMethodBeat.i(130446);
            g(parcel);
            AppMethodBeat.o(130446);
        }

        static {
            AppMethodBeat.i(130447);
            AppMethodBeat.o(130447);
        }
    }

    public void a(q qVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130450);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiLaunchApplication", "data is null");
            qVar.M(i, j("fail:data is null", null));
            AppMethodBeat.o(130450);
            return;
        }
        final String optString = jSONObject.optString("appId");
        final String optString2 = jSONObject.optString("schemeUrl");
        final String optString3 = jSONObject.optString("parameter");
        int i2 = bo.getInt(jSONObject.optString("alertType"), 0);
        int i3 = bo.getInt(jSONObject.optString("operateDirectly"), 0);
        final String optString4 = jSONObject.optString(IssueStorage.COLUMN_EXT_INFO);
        ab.i("MicroMsg.JsApiLaunchApplication", "appid : %s, scheme : %s, extinfo:[%s], parameter : %s", optString, optString2, optString4, optString3);
        if (bo.isNullOrNil(optString) && bo.isNullOrNil(optString2)) {
            ab.e("MicroMsg.JsApiLaunchApplication", "appid and scheme is null or nil");
            qVar.M(i, j("fail:appid and scheme is null or nil", null));
            AppMethodBeat.o(130450);
            return;
        }
        String url;
        String appId = qVar.getAppId();
        u currentPageView = qVar.getCurrentPageView();
        if (currentPageView != null) {
            url = currentPageView.getURL();
        } else {
            ab.e("MicroMsg.JsApiLaunchApplication", "getCurrentPageView is null");
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
        ab.i("MicroMsg.JsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s, operateDirectly : %s)", appId, optString, Integer.valueOf(avj.scene), avj.url, avj.wzo, Integer.valueOf(avj.kCo), Integer.valueOf(avj.wzq));
        final q qVar2 = qVar;
        i2 = i;
        b.a(aVar.acD(), new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
            public final void a(final int i, final int i2, String str, final com.tencent.mm.ai.b bVar) {
                AppMethodBeat.i(130439);
                ab.i("MicroMsg.JsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                com.tencent.mm.ce.a.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(130438);
                        if (i == 0 && i2 == 0) {
                            final avk avk = (avk) bVar.fsH.fsP;
                            switch (avk.cyE) {
                                case 0:
                                    final a aVar = new a(new a() {
                                        public final void r(boolean z, boolean z2) {
                                            AppMethodBeat.i(130435);
                                            ab.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", Boolean.valueOf(z), Boolean.valueOf(z2));
                                            if (z) {
                                                qVar2.M(i2, JsApiLaunchApplication.this.j("ok", null));
                                                AppMethodBeat.o(130435);
                                                return;
                                            }
                                            qVar2.M(i2, JsApiLaunchApplication.this.j("fail:scheme launch fail", null));
                                            AppMethodBeat.o(130435);
                                        }
                                    });
                                    ab.i("MicroMsg.JsApiLaunchApplication", "launchApplication check result(showType : %d, errCode : %d)", Integer.valueOf(avk.wzs), Integer.valueOf(avk.cyE));
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
                                                        AppMethodBeat.i(130436);
                                                        aVar.dS(g.a(qVar2.getContext(), intent, null, avk.wzs, aVar, bundle));
                                                        AppMethodBeat.o(130436);
                                                    }
                                                });
                                                AppMethodBeat.o(130438);
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
                                            AppMethodBeat.i(130437);
                                            ab.i("MicroMsg.JsApiLaunchApplication", "callback task.success:%b", Boolean.valueOf(launchApplicationTask.success));
                                            launchApplicationTask.aBW();
                                            if (launchApplicationTask.success) {
                                                qVar2.M(i2, JsApiLaunchApplication.this.j("ok", null));
                                                AppMethodBeat.o(130437);
                                                return;
                                            }
                                            qVar2.M(i2, JsApiLaunchApplication.this.j("fail:sdk launch fail", null));
                                            AppMethodBeat.o(130437);
                                        }
                                    };
                                    launchApplicationTask.aBV();
                                    launchApplicationTask.aBU();
                                    AppMethodBeat.o(130438);
                                    return;
                                case 2:
                                    qVar2.M(i2, JsApiLaunchApplication.this.j("fail:check fail forbidden scene 2", null));
                                    AppMethodBeat.o(130438);
                                    return;
                                default:
                                    qVar2.M(i2, JsApiLaunchApplication.this.j("fail:check fail 1", null));
                                    AppMethodBeat.o(130438);
                                    return;
                            }
                        }
                        qVar2.M(i2, JsApiLaunchApplication.this.j("fail:check fail", null));
                        AppMethodBeat.o(130438);
                    }
                });
                AppMethodBeat.o(130439);
            }
        });
        AppMethodBeat.o(130450);
    }
}
