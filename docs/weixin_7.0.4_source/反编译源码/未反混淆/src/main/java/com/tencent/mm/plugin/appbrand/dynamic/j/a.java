package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.x;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.az;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet;
import com.tencent.mm.plugin.appbrand.widget.j;
import com.tencent.mm.plugin.appbrand.widget.l;
import com.tencent.mm.protocal.protobuf.aqz;
import com.tencent.mm.protocal.protobuf.ara;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cvx;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.protocal.protobuf.rg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.IOException;
import java.util.LinkedList;

public final class a {

    static class c implements i<Bundle, Bundle> {
        private c() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(10986);
            Bundle s = s((Bundle) obj);
            AppMethodBeat.o(10986);
            return s;
        }

        private static Bundle s(Bundle bundle) {
            boolean z = true;
            AppMethodBeat.i(10985);
            String string = bundle.getString("appId");
            int i = bundle.getInt("pkgType");
            int i2 = bundle.getInt("pkgVersion");
            int i3 = bundle.getInt("scene");
            int i4 = bundle.getInt("widgetType");
            String string2 = bundle.getString("preloadLaunchData", "");
            Bundle bundle2 = new Bundle();
            try {
                j azY = new com.tencent.mm.plugin.appbrand.dynamic.launching.a(string, i, i2, i3, i4, string2).azY();
                if (azY == null) {
                    AppMethodBeat.o(10985);
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
                com.tencent.mm.plugin.appbrand.widget.a.a aVar = (com.tencent.mm.plugin.appbrand.widget.a.a) com.tencent.mm.plugin.appbrand.dynamic.k.a.ag(com.tencent.mm.plugin.appbrand.widget.a.a.class);
                if (aVar == null) {
                    AppMethodBeat.o(10985);
                    return bundle2;
                }
                l Ev = aVar.auR().Ev(string);
                DebuggerInfo Ad = com.tencent.mm.plugin.appbrand.dynamic.debugger.b.Ad(string);
                DebuggerInfo debuggerInfo = new DebuggerInfo();
                boolean z2 = Ev != null && Ev.field_openDebug;
                debuggerInfo.hmE = z2;
                if (com.tencent.mm.plugin.appbrand.appcache.j.a.kR(i) || (Ad != null && Ad.hmD)) {
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
                AppMethodBeat.o(10985);
                return bundle2;
            } catch (Exception e) {
                ab.w("MicroMsg.DynamicPkgUpdater", "check widget launch info error : %s", e);
            }
        }
    }

    public static class d implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private d() {
        }

        public final /* synthetic */ void a(Object obj, final com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(10988);
            Bundle bundle = (Bundle) obj;
            final String string = bundle.getString("id");
            String string2 = bundle.getString("appId");
            int i = bundle.getInt("debugType");
            at a = ((com.tencent.mm.plugin.appbrand.a.d) g.K(com.tencent.mm.plugin.appbrand.a.d.class)).xF().a(string2, i, "downloadURL");
            String str = a != null ? a.field_downloadURL : null;
            if (a == null) {
                ab.e("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", string2, Integer.valueOf(i));
                u.i("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", string2, Integer.valueOf(i));
                if (cVar != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("appId", string2);
                    bundle2.putBoolean("result", false);
                    cVar.ao(bundle2);
                }
                AppMethodBeat.o(10988);
                return;
            }
            if (!bo.isNullOrNil(str)) {
                az.a(string2, i, str, new com.tencent.mm.plugin.appbrand.appcache.az.a() {
                    public final /* bridge */ /* synthetic */ void bl(Object obj) {
                    }

                    public final /* synthetic */ void a(String str, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a aVar, Object obj) {
                        Bundle bundle;
                        AppMethodBeat.i(10987);
                        u.i("MicroMsg.DynamicPkgUpdater", "pkg download return %s", aVar);
                        if (!com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.OK.equals(aVar)) {
                            bundle = new Bundle();
                            bundle.putString("id", string);
                            bundle.putInt("widgetState", TXLiveConstants.PLAY_WARNING_HW_ACCELERATION_FAIL);
                            f.a(com.tencent.mm.plugin.appbrand.dynamic.i.azC().zV(string), bundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.class, null);
                            com.tencent.mm.plugin.appbrand.dynamic.j.azE().E(string, JsApiShowImageOperateSheet.CTRL_INDEX, 16);
                        }
                        if (cVar != null) {
                            bundle = new Bundle();
                            bundle.putString("appId", str);
                            bundle.putBoolean("result", com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.OK.equals(aVar));
                            cVar.ao(bundle);
                        }
                        AppMethodBeat.o(10987);
                    }
                });
            }
            AppMethodBeat.o(10988);
        }
    }

    public interface e {
        void ac(String str, boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.j.a$2 */
    public static class AnonymousClass2 implements com.tencent.mm.ipcinvoker.c<Bundle> {
        final /* synthetic */ e hoR;

        public AnonymousClass2(e eVar) {
            this.hoR = eVar;
        }

        public final /* synthetic */ void ao(Object obj) {
            AppMethodBeat.i(10981);
            Bundle bundle = (Bundle) obj;
            if (this.hoR != null) {
                this.hoR.ac(bundle.getString("appId"), bundle.getBoolean("result"));
            }
            AppMethodBeat.o(10981);
        }
    }

    static class b implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(10984);
            com.tencent.mm.plugin.appbrand.dynamic.b.e.removeAll();
            ab.v("MicroMsg.DynamicPkgUpdater", "clearCache");
            com.tencent.mm.plugin.appbrand.dynamic.i.b.aAj();
            AppMethodBeat.o(10984);
        }
    }

    static class a implements i<Bundle, WxaPkgWrappingInfo> {
        private a() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(10983);
            WxaPkgWrappingInfo r = r((Bundle) obj);
            AppMethodBeat.o(10983);
            return r;
        }

        private static WxaPkgWrappingInfo r(Bundle bundle) {
            AppMethodBeat.i(10982);
            String string = bundle.getString("id");
            String string2 = bundle.getString("appId");
            int i = bundle.getInt("pkgType");
            int i2 = bundle.getInt("pkgVersion");
            bundle.getInt("scene");
            String string3 = bundle.getString("searchId");
            String string4 = bundle.getString("preload_download_data");
            WxaPkgWrappingInfo wxaPkgWrappingInfo;
            at a;
            String str;
            switch (i) {
                case Downloads.MIN_WAIT_FOR_NETWORK /*10000*/:
                    wxaPkgWrappingInfo = (WxaPkgWrappingInfo) as.v(string2, i, i2).second;
                    AppMethodBeat.o(10982);
                    return wxaPkgWrappingInfo;
                case 10001:
                    if (new com.tencent.mm.plugin.appbrand.dynamic.launching.c(string2, "", "", (byte) 0).aAa() == com.tencent.mm.plugin.appbrand.dynamic.launching.c.a.Ok.ordinal()) {
                        at a2 = ((com.tencent.mm.plugin.appbrand.a.d) g.K(com.tencent.mm.plugin.appbrand.a.d.class)).xF().a(string2, i, "downloadURL");
                        if (a2 == null) {
                            ab.e("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", string2, Integer.valueOf(i));
                            AppMethodBeat.o(10982);
                            return null;
                        }
                        try {
                            wxaPkgWrappingInfo = new com.tencent.mm.plugin.appbrand.dynamic.launching.b(string, string2, string3, i, i2, com.tencent.mm.plugin.appbrand.dynamic.launching.b.hoi, a2.field_downloadURL).azZ();
                            AppMethodBeat.o(10982);
                            return wxaPkgWrappingInfo;
                        } catch (Exception e) {
                            ab.e("MicroMsg.DynamicPkgUpdater", "getWxaPkgInfo(%s, %d) error : %s", string2, Integer.valueOf(i), e);
                            AppMethodBeat.o(10982);
                            return null;
                        }
                    }
                    break;
                case 10100:
                case 10101:
                    a = ((com.tencent.mm.plugin.appbrand.a.d) g.K(com.tencent.mm.plugin.appbrand.a.d.class)).xF().a(string2, i, "downloadURL");
                    g.RN();
                    int QF = com.tencent.mm.kernel.a.QF();
                    com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
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
                    aVar.fsJ = aqz;
                    aVar.fsK = new ara();
                    aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwidgetinfo";
                    aVar.fsI = 1186;
                    com.tencent.mm.ai.a.a c = x.c(aVar.acD());
                    if (c.errType == 0 && c.errCode == 0) {
                        ara ara = (ara) c.fsy;
                        if (!(ara == null || ara.wuK == null || ara.wuK.size() <= 0)) {
                            cvw cvw2 = (cvw) ara.wuK.getFirst();
                            u.i("MicroMsg.DynamicPkgUpdater", "getWidgetInfo debugType %d, md5 %s, url %s", Integer.valueOf(i), cvw2.cvZ, cvw2.url);
                            if (cvw2.url != null && cvw2.url.length() > 0) {
                                switch (i) {
                                    case Downloads.MIN_WAIT_FOR_NETWORK /*10000*/:
                                    case 10001:
                                    case 10100:
                                    case 10101:
                                        ((com.tencent.mm.plugin.appbrand.a.d) g.K(com.tencent.mm.plugin.appbrand.a.d.class)).xF().a(string2, i, cvw2.url, cvw2.cvZ, 0, 0);
                                        break;
                                }
                            }
                        }
                    }
                    ab.i("MicroMsg.DynamicPkgUpdater", "cgi fail errType %d, errCode %d,errMsg %s, appid %s , pkgType %d", Integer.valueOf(c.errType), Integer.valueOf(c.errCode), c.aIm, string2, Integer.valueOf(i));
                    u.i("MicroMsg.DynamicPkgUpdater", "cgi fail errType %d, errCode %d,errMsg %s, appid %s , pkgType %d", Integer.valueOf(c.errType), Integer.valueOf(c.errCode), c.aIm, string2, Integer.valueOf(i));
                    wxaPkgWrappingInfo = (WxaPkgWrappingInfo) as.v(string2, i, i2).second;
                    AppMethodBeat.o(10982);
                    return wxaPkgWrappingInfo;
                case 10102:
                    try {
                        str = "";
                        a = ((com.tencent.mm.plugin.appbrand.a.d) g.K(com.tencent.mm.plugin.appbrand.a.d.class)).xF().a(string2, i, "downloadURL", "version");
                        if (a != null) {
                            str = a.field_downloadURL;
                            i2 = a.field_version;
                        }
                        wxaPkgWrappingInfo = new com.tencent.mm.plugin.appbrand.dynamic.launching.b(string, string2, string3, i, i2, com.tencent.mm.plugin.appbrand.dynamic.launching.b.hoj, str, string4).azZ();
                        AppMethodBeat.o(10982);
                        return wxaPkgWrappingInfo;
                    } catch (Exception e2) {
                        ab.e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", e2);
                        break;
                    }
                default:
                    try {
                        str = "";
                        a = ((com.tencent.mm.plugin.appbrand.a.d) g.K(com.tencent.mm.plugin.appbrand.a.d.class)).xF().a(string2, i, "downloadURL", "version");
                        if (a != null) {
                            str = a.field_downloadURL;
                            i2 = a.field_version;
                        }
                        wxaPkgWrappingInfo = new com.tencent.mm.plugin.appbrand.dynamic.launching.b(string, string2, string3, i, i2, com.tencent.mm.plugin.appbrand.dynamic.launching.b.hoi, str).azZ();
                        AppMethodBeat.o(10982);
                        return wxaPkgWrappingInfo;
                    } catch (Exception e22) {
                        ab.e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", e22);
                        break;
                    }
            }
            AppMethodBeat.o(10982);
            return null;
        }
    }

    public static WxaPkgWrappingInfo b(String str, String str2, String str3, int i) {
        AppMethodBeat.i(10989);
        WxaPkgWrappingInfo a = a(str, str2, str3, i, 0, null);
        AppMethodBeat.o(10989);
        return a;
    }

    public static WxaPkgWrappingInfo a(String str, String str2, String str3, int i, int i2, String str4) {
        WxaPkgWrappingInfo Ac;
        AppMethodBeat.i(10990);
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putString("appId", str2);
        bundle.putInt("pkgType", i);
        bundle.putInt("pkgVersion", i2);
        bundle.putString("searchId", str3);
        bundle.putString("preload_download_data", str4);
        if (i == 10102) {
            Ac = com.tencent.mm.plugin.appbrand.dynamic.b.e.Ac(F(str2, i, i2));
            if (Ac != null) {
                u.i("MicroMsg.DynamicPkgUpdater", "get wxaPkgInfo from cache", new Object[0]);
                AppMethodBeat.o(10990);
                return Ac;
            }
        }
        Ac = (WxaPkgWrappingInfo) f.a("com.tencent.mm", bundle, a.class);
        if (Ac != null) {
            com.tencent.mm.plugin.appbrand.dynamic.b.e.a(F(str2, i, i2), Ac);
        }
        AppMethodBeat.o(10990);
        return Ac;
    }

    public static d a(String str, int i, int i2, int i3, int i4, String str2) {
        AppMethodBeat.i(10991);
        Bundle bundle = new Bundle();
        bundle.putString("appId", str);
        bundle.putInt("pkgType", i);
        bundle.putInt("pkgVersion", i2);
        bundle.putInt("widgetType", i3);
        bundle.putInt("scene", i4);
        bundle.putString("preloadLaunchData", str2);
        bundle = (Bundle) f.a("com.tencent.mm", bundle, c.class);
        if (bundle == null) {
            AppMethodBeat.o(10991);
            return null;
        }
        d dVar = new d();
        dVar.appId = str;
        dVar.hoT = (DebuggerInfo) bundle.getParcelable("debuggerInfo");
        byte[] byteArray = bundle.getByteArray("jsApiInfo");
        if (byteArray != null) {
            dVar.hoX = new rg();
            try {
                dVar.hoX.parseFrom(byteArray);
            } catch (IOException e) {
                ab.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", e);
            }
        }
        byteArray = bundle.getByteArray("launchAction");
        if (byteArray != null) {
            dVar.hoW = new cvx();
            try {
                dVar.hoW.parseFrom(byteArray);
            } catch (IOException e2) {
                ab.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", e2);
            }
        }
        byteArray = bundle.getByteArray("versionInfo");
        dVar.hoY = new cvy();
        if (byteArray != null) {
            try {
                dVar.hoY.parseFrom(byteArray);
            } catch (IOException e22) {
                ab.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", e22);
            }
        }
        dVar.hoU = (WidgetSysConfig) bundle.getParcelable("sysConfig");
        dVar.hoV = (WidgetRuntimeConfig) bundle.getParcelable("runtimeConfig");
        if (dVar.hoV == null) {
            dVar.hoV = new WidgetRuntimeConfig();
        }
        AppMethodBeat.o(10991);
        return dVar;
    }

    private static String F(String str, int i, int i2) {
        AppMethodBeat.i(10992);
        String str2 = str + "#" + i + "#" + i2;
        AppMethodBeat.o(10992);
        return str2;
    }
}
