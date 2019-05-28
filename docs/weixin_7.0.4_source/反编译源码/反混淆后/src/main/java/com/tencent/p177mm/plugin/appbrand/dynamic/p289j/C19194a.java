package com.tencent.p177mm.plugin.appbrand.dynamic.p289j;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C32710b;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.C18652u;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p183ai.C8920x;
import com.tencent.p177mm.plugin.appbrand.appcache.C19035as;
import com.tencent.p177mm.plugin.appbrand.appcache.C2055az;
import com.tencent.p177mm.plugin.appbrand.appcache.C2055az.C2057a;
import com.tencent.p177mm.plugin.appbrand.appcache.C31281at;
import com.tencent.p177mm.plugin.appbrand.appcache.C45515j.C33097a;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C26735b.C26734a.C10067a;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.p177mm.plugin.appbrand.dynamic.C10211f.C10213a;
import com.tencent.p177mm.plugin.appbrand.dynamic.C33164i;
import com.tencent.p177mm.plugin.appbrand.dynamic.C38203j;
import com.tencent.p177mm.plugin.appbrand.dynamic.debugger.C42423b;
import com.tencent.p177mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.p177mm.plugin.appbrand.dynamic.launching.C38207a;
import com.tencent.p177mm.plugin.appbrand.dynamic.launching.C42428c;
import com.tencent.p177mm.plugin.appbrand.dynamic.launching.C42428c.C26870a;
import com.tencent.p177mm.plugin.appbrand.dynamic.launching.C45549b;
import com.tencent.p177mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.p177mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.p177mm.plugin.appbrand.dynamic.p1221i.C26868b;
import com.tencent.p177mm.plugin.appbrand.dynamic.p284b.C33147e;
import com.tencent.p177mm.plugin.appbrand.dynamic.p892k.C10218a;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet;
import com.tencent.p177mm.plugin.appbrand.p1468a.C33065d;
import com.tencent.p177mm.plugin.appbrand.widget.C27420j;
import com.tencent.p177mm.plugin.appbrand.widget.C33638l;
import com.tencent.p177mm.plugin.appbrand.widget.p1473a.C33574a;
import com.tencent.p177mm.protocal.protobuf.C15381rg;
import com.tencent.p177mm.protocal.protobuf.aqz;
import com.tencent.p177mm.protocal.protobuf.ara;
import com.tencent.p177mm.protocal.protobuf.cvw;
import com.tencent.p177mm.protocal.protobuf.cvx;
import com.tencent.p177mm.protocal.protobuf.cvy;
import com.tencent.p177mm.protocal.protobuf.cyd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.IOException;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.j.a */
public final class C19194a {

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.j.a$c */
    static class C19190c implements C45413i<Bundle, Bundle> {
        private C19190c() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(10986);
            Bundle s = C19190c.m29843s((Bundle) obj);
            AppMethodBeat.m2505o(10986);
            return s;
        }

        /* renamed from: s */
        private static Bundle m29843s(Bundle bundle) {
            boolean z = true;
            AppMethodBeat.m2504i(10985);
            String string = bundle.getString("appId");
            int i = bundle.getInt("pkgType");
            int i2 = bundle.getInt("pkgVersion");
            int i3 = bundle.getInt("scene");
            int i4 = bundle.getInt("widgetType");
            String string2 = bundle.getString("preloadLaunchData", "");
            Bundle bundle2 = new Bundle();
            try {
                C27420j azY = new C38207a(string, i, i2, i3, i4, string2).azY();
                if (azY == null) {
                    AppMethodBeat.m2505o(10985);
                    return bundle2;
                }
                if (azY.field_jsApiInfo != null) {
                    bundle2.putByteArray("jsApiInfo", azY.field_jsApiInfo.toByteArray());
                }
                if (azY.field_launchAction != null) {
                    bundle2.putByteArray("launchAction", azY.field_launchAction.toByteArray());
                }
                if (azY.field_versionInfo != null) {
                    bundle2.putByteArray("versionInfo", azY.field_versionInfo.toByteArray());
                }
                WidgetRuntimeConfig widgetRuntimeConfig = new WidgetRuntimeConfig();
                widgetRuntimeConfig.appId = string;
                widgetRuntimeConfig.hog = i4;
                cyd cyd = azY.field_widgetSetting;
                if (cyd != null) {
                    widgetRuntimeConfig.hox = cyd.xty;
                    widgetRuntimeConfig.hoz = cyd.xtA;
                    widgetRuntimeConfig.hoy = cyd.xtz;
                }
                bundle2.putParcelable("runtimeConfig", widgetRuntimeConfig);
                C33574a c33574a = (C33574a) C10218a.m17859ag(C33574a.class);
                if (c33574a == null) {
                    AppMethodBeat.m2505o(10985);
                    return bundle2;
                }
                C33638l Ev = c33574a.auR().mo54196Ev(string);
                DebuggerInfo Ad = C42423b.m75141Ad(string);
                DebuggerInfo debuggerInfo = new DebuggerInfo();
                boolean z2 = Ev != null && Ev.field_openDebug;
                debuggerInfo.hmE = z2;
                if (C33097a.m54089kR(i) || (Ad != null && Ad.hmD)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                debuggerInfo.hmD = z2;
                if (Ad == null || !Ad.hmF) {
                    z = false;
                }
                debuggerInfo.hmF = z;
                bundle2.putParcelable("debuggerInfo", debuggerInfo);
                AppBrandGlobalSystemConfig ayC = AppBrandGlobalSystemConfig.ayC();
                WidgetSysConfig widgetSysConfig = new WidgetSysConfig();
                widgetSysConfig.hfU = ayC.hfU;
                widgetSysConfig.hfV = ayC.hfV;
                widgetSysConfig.hfW = ayC.hfW;
                bundle2.putParcelable("sysConfig", widgetSysConfig);
                AppMethodBeat.m2505o(10985);
                return bundle2;
            } catch (Exception e) {
                C4990ab.m7421w("MicroMsg.DynamicPkgUpdater", "check widget launch info error : %s", e);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.j.a$d */
    public static class C19191d implements C37866a<Bundle, Bundle> {
        private C19191d() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, final C18507c c18507c) {
            AppMethodBeat.m2504i(10988);
            Bundle bundle = (Bundle) obj;
            final String string = bundle.getString("id");
            String string2 = bundle.getString("appId");
            int i = bundle.getInt("debugType");
            C31281at a = ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF().mo60842a(string2, i, "downloadURL");
            String str = a != null ? a.field_downloadURL : null;
            if (a == null) {
                C4990ab.m7413e("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", string2, Integer.valueOf(i));
                C18652u.m29151i("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", string2, Integer.valueOf(i));
                if (c18507c != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("appId", string2);
                    bundle2.putBoolean("result", false);
                    c18507c.mo5960ao(bundle2);
                }
                AppMethodBeat.m2505o(10988);
                return;
            }
            if (!C5046bo.isNullOrNil(str)) {
                C2055az.m4222a(string2, i, str, new C2057a() {
                    /* renamed from: bl */
                    public final /* bridge */ /* synthetic */ void mo14966bl(Object obj) {
                    }

                    /* renamed from: a */
                    public final /* synthetic */ void mo14965a(String str, C10067a c10067a, Object obj) {
                        Bundle bundle;
                        AppMethodBeat.m2504i(10987);
                        C18652u.m29151i("MicroMsg.DynamicPkgUpdater", "pkg download return %s", c10067a);
                        if (!C10067a.OK.equals(c10067a)) {
                            bundle = new Bundle();
                            bundle.putString("id", string);
                            bundle.putInt("widgetState", TXLiveConstants.PLAY_WARNING_HW_ACCELERATION_FAIL);
                            C9549f.m17012a(C33164i.azC().mo53694zV(string), bundle, C10213a.class, null);
                            C38203j.azE().mo60938E(string, JsApiShowImageOperateSheet.CTRL_INDEX, 16);
                        }
                        if (c18507c != null) {
                            bundle = new Bundle();
                            bundle.putString("appId", str);
                            bundle.putBoolean("result", C10067a.OK.equals(c10067a));
                            c18507c.mo5960ao(bundle);
                        }
                        AppMethodBeat.m2505o(10987);
                    }
                });
            }
            AppMethodBeat.m2505o(10988);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.j.a$e */
    public interface C19193e {
        /* renamed from: ac */
        void mo21606ac(String str, boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.j.a$2 */
    public static class C191952 implements C18507c<Bundle> {
        final /* synthetic */ C19193e hoR;

        public C191952(C19193e c19193e) {
            this.hoR = c19193e;
        }

        /* renamed from: ao */
        public final /* synthetic */ void mo5960ao(Object obj) {
            AppMethodBeat.m2504i(10981);
            Bundle bundle = (Bundle) obj;
            if (this.hoR != null) {
                this.hoR.mo21606ac(bundle.getString("appId"), bundle.getBoolean("result"));
            }
            AppMethodBeat.m2505o(10981);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.j.a$1 */
    public static class C191961 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(10980);
            for (String str : C33164i.azC().azD()) {
                if (C32710b.m53380PL().mo53222le(str)) {
                    C9549f.m17012a(str, null, C19197b.class, null);
                } else {
                    C4990ab.m7416i("MicroMsg.DynamicPkgUpdater", "has not Connected RemoteService, abort clearCache");
                    AppMethodBeat.m2505o(10980);
                    return;
                }
            }
            AppMethodBeat.m2505o(10980);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.j.a$b */
    static class C19197b implements C37866a<Bundle, Bundle> {
        private C19197b() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(10984);
            C33147e.removeAll();
            C4990ab.m7418v("MicroMsg.DynamicPkgUpdater", "clearCache");
            C26868b.aAj();
            AppMethodBeat.m2505o(10984);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.j.a$a */
    static class C19198a implements C45413i<Bundle, WxaPkgWrappingInfo> {
        private C19198a() {
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(10983);
            WxaPkgWrappingInfo r = C19198a.m29855r((Bundle) obj);
            AppMethodBeat.m2505o(10983);
            return r;
        }

        /* renamed from: r */
        private static WxaPkgWrappingInfo m29855r(Bundle bundle) {
            AppMethodBeat.m2504i(10982);
            String string = bundle.getString("id");
            String string2 = bundle.getString("appId");
            int i = bundle.getInt("pkgType");
            int i2 = bundle.getInt("pkgVersion");
            bundle.getInt("scene");
            String string3 = bundle.getString("searchId");
            String string4 = bundle.getString("preload_download_data");
            WxaPkgWrappingInfo wxaPkgWrappingInfo;
            C31281at a;
            String str;
            switch (i) {
                case Downloads.MIN_WAIT_FOR_NETWORK /*10000*/:
                    wxaPkgWrappingInfo = (WxaPkgWrappingInfo) C19035as.m29615v(string2, i, i2).second;
                    AppMethodBeat.m2505o(10982);
                    return wxaPkgWrappingInfo;
                case 10001:
                    if (new C42428c(string2, "", "", (byte) 0).aAa() == C26870a.Ok.ordinal()) {
                        C31281at a2 = ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF().mo60842a(string2, i, "downloadURL");
                        if (a2 == null) {
                            C4990ab.m7413e("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", string2, Integer.valueOf(i));
                            AppMethodBeat.m2505o(10982);
                            return null;
                        }
                        try {
                            wxaPkgWrappingInfo = new C45549b(string, string2, string3, i, i2, C45549b.hoi, a2.field_downloadURL).azZ();
                            AppMethodBeat.m2505o(10982);
                            return wxaPkgWrappingInfo;
                        } catch (Exception e) {
                            C4990ab.m7413e("MicroMsg.DynamicPkgUpdater", "getWxaPkgInfo(%s, %d) error : %s", string2, Integer.valueOf(i), e);
                            AppMethodBeat.m2505o(10982);
                            return null;
                        }
                    }
                    break;
                case 10100:
                case 10101:
                    a = ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF().mo60842a(string2, i, "downloadURL");
                    C1720g.m3534RN();
                    int QF = C1668a.m3383QF();
                    C1196a c1196a = new C1196a();
                    aqz aqz = new aqz();
                    aqz.csB = string2;
                    aqz.wuJ = QF;
                    cvw cvw = new cvw();
                    switch (i) {
                        case 10100:
                            cvw.vOO = 1;
                            cvw.xrP = 1;
                            break;
                        case 10101:
                            cvw.vOO = 2;
                            cvw.xrP = 1;
                            break;
                        default:
                            cvw.vOO = 0;
                            cvw.xrP = 0;
                            break;
                    }
                    if (a != null) {
                        cvw.cvZ = a.field_versionMd5;
                    } else {
                        cvw.cvZ = "";
                    }
                    aqz.wuK = new LinkedList();
                    aqz.wuK.add(cvw);
                    c1196a.fsJ = aqz;
                    c1196a.fsK = new ara();
                    c1196a.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwidgetinfo";
                    c1196a.fsI = 1186;
                    C37441a c = C8920x.m16082c(c1196a.acD());
                    if (c.errType == 0 && c.errCode == 0) {
                        ara ara = (ara) c.fsy;
                        if (!(ara == null || ara.wuK == null || ara.wuK.size() <= 0)) {
                            cvw cvw2 = (cvw) ara.wuK.getFirst();
                            C18652u.m29151i("MicroMsg.DynamicPkgUpdater", "getWidgetInfo debugType %d, md5 %s, url %s", Integer.valueOf(i), cvw2.cvZ, cvw2.url);
                            if (cvw2.url != null && cvw2.url.length() > 0) {
                                switch (i) {
                                    case Downloads.MIN_WAIT_FOR_NETWORK /*10000*/:
                                    case 10001:
                                    case 10100:
                                    case 10101:
                                        ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF().mo60848a(string2, i, cvw2.url, cvw2.cvZ, 0, 0);
                                        break;
                                }
                            }
                        }
                    }
                    C4990ab.m7417i("MicroMsg.DynamicPkgUpdater", "cgi fail errType %d, errCode %d,errMsg %s, appid %s , pkgType %d", Integer.valueOf(c.errType), Integer.valueOf(c.errCode), c.aIm, string2, Integer.valueOf(i));
                    C18652u.m29151i("MicroMsg.DynamicPkgUpdater", "cgi fail errType %d, errCode %d,errMsg %s, appid %s , pkgType %d", Integer.valueOf(c.errType), Integer.valueOf(c.errCode), c.aIm, string2, Integer.valueOf(i));
                    wxaPkgWrappingInfo = (WxaPkgWrappingInfo) C19035as.m29615v(string2, i, i2).second;
                    AppMethodBeat.m2505o(10982);
                    return wxaPkgWrappingInfo;
                case 10102:
                    try {
                        str = "";
                        a = ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF().mo60842a(string2, i, "downloadURL", "version");
                        if (a != null) {
                            str = a.field_downloadURL;
                            i2 = a.field_version;
                        }
                        wxaPkgWrappingInfo = new C45549b(string, string2, string3, i, i2, C45549b.hoj, str, string4).azZ();
                        AppMethodBeat.m2505o(10982);
                        return wxaPkgWrappingInfo;
                    } catch (Exception e2) {
                        C4990ab.m7413e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", e2);
                        break;
                    }
                default:
                    try {
                        str = "";
                        a = ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF().mo60842a(string2, i, "downloadURL", "version");
                        if (a != null) {
                            str = a.field_downloadURL;
                            i2 = a.field_version;
                        }
                        wxaPkgWrappingInfo = new C45549b(string, string2, string3, i, i2, C45549b.hoi, str).azZ();
                        AppMethodBeat.m2505o(10982);
                        return wxaPkgWrappingInfo;
                    } catch (Exception e22) {
                        C4990ab.m7413e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", e22);
                        break;
                    }
            }
            AppMethodBeat.m2505o(10982);
            return null;
        }
    }

    /* renamed from: b */
    public static WxaPkgWrappingInfo m29852b(String str, String str2, String str3, int i) {
        AppMethodBeat.m2504i(10989);
        WxaPkgWrappingInfo a = C19194a.m29850a(str, str2, str3, i, 0, null);
        AppMethodBeat.m2505o(10989);
        return a;
    }

    /* renamed from: a */
    public static WxaPkgWrappingInfo m29850a(String str, String str2, String str3, int i, int i2, String str4) {
        WxaPkgWrappingInfo Ac;
        AppMethodBeat.m2504i(10990);
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putString("appId", str2);
        bundle.putInt("pkgType", i);
        bundle.putInt("pkgVersion", i2);
        bundle.putString("searchId", str3);
        bundle.putString("preload_download_data", str4);
        if (i == 10102) {
            Ac = C33147e.m54189Ac(C19194a.m29849F(str2, i, i2));
            if (Ac != null) {
                C18652u.m29151i("MicroMsg.DynamicPkgUpdater", "get wxaPkgInfo from cache", new Object[0]);
                AppMethodBeat.m2505o(10990);
                return Ac;
            }
        }
        Ac = (WxaPkgWrappingInfo) C9549f.m17010a("com.tencent.mm", bundle, C19198a.class);
        if (Ac != null) {
            C33147e.m54190a(C19194a.m29849F(str2, i, i2), Ac);
        }
        AppMethodBeat.m2505o(10990);
        return Ac;
    }

    /* renamed from: a */
    public static C2152d m29851a(String str, int i, int i2, int i3, int i4, String str2) {
        AppMethodBeat.m2504i(10991);
        Bundle bundle = new Bundle();
        bundle.putString("appId", str);
        bundle.putInt("pkgType", i);
        bundle.putInt("pkgVersion", i2);
        bundle.putInt("widgetType", i3);
        bundle.putInt("scene", i4);
        bundle.putString("preloadLaunchData", str2);
        bundle = (Bundle) C9549f.m17010a("com.tencent.mm", bundle, C19190c.class);
        if (bundle == null) {
            AppMethodBeat.m2505o(10991);
            return null;
        }
        C2152d c2152d = new C2152d();
        c2152d.appId = str;
        c2152d.hoT = (DebuggerInfo) bundle.getParcelable("debuggerInfo");
        byte[] byteArray = bundle.getByteArray("jsApiInfo");
        if (byteArray != null) {
            c2152d.hoX = new C15381rg();
            try {
                c2152d.hoX.parseFrom(byteArray);
            } catch (IOException e) {
                C4990ab.m7419v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", e);
            }
        }
        byteArray = bundle.getByteArray("launchAction");
        if (byteArray != null) {
            c2152d.hoW = new cvx();
            try {
                c2152d.hoW.parseFrom(byteArray);
            } catch (IOException e2) {
                C4990ab.m7419v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", e2);
            }
        }
        byteArray = bundle.getByteArray("versionInfo");
        c2152d.hoY = new cvy();
        if (byteArray != null) {
            try {
                c2152d.hoY.parseFrom(byteArray);
            } catch (IOException e22) {
                C4990ab.m7419v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", e22);
            }
        }
        c2152d.hoU = (WidgetSysConfig) bundle.getParcelable("sysConfig");
        c2152d.hoV = (WidgetRuntimeConfig) bundle.getParcelable("runtimeConfig");
        if (c2152d.hoV == null) {
            c2152d.hoV = new WidgetRuntimeConfig();
        }
        AppMethodBeat.m2505o(10991);
        return c2152d;
    }

    /* renamed from: F */
    private static String m29849F(String str, int i, int i2) {
        AppMethodBeat.m2504i(10992);
        String str2 = str + "#" + i + "#" + i2;
        AppMethodBeat.m2505o(10992);
        return str2;
    }
}
