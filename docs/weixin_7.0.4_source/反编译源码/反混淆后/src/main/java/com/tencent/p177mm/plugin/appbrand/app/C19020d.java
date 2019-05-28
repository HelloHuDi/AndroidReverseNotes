package com.tencent.p177mm.plugin.appbrand.app;

import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.luggage.sdk.launching.C17829b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.p1174aa.C41726i;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p217ci.C37654f;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.plugin.appbrand.appcache.C45516v;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.p177mm.plugin.appbrand.config.C33138j.C33137a;
import com.tencent.p177mm.plugin.appbrand.config.C42406r;
import com.tencent.p177mm.plugin.appbrand.ipc.C10276d;
import com.tencent.p177mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event;
import com.tencent.p177mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.AppBrandOnOpReportStartEvent;
import com.tencent.p177mm.plugin.appbrand.jsapi.op_report.C19464c;
import com.tencent.p177mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.p177mm.plugin.appbrand.launching.precondition.C10600f;
import com.tencent.p177mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult;
import com.tencent.p177mm.plugin.appbrand.luggage.export.functionalpage.C10608b;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C27297a;
import com.tencent.p177mm.plugin.appbrand.task.C38519g;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p641g.C7582e;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.app.d */
class C19020d implements C27297a {
    C19020d() {
    }

    /* renamed from: xk */
    public C7582e<Integer> mo34268xk(final String str) {
        AppMethodBeat.m2504i(129243);
        C37654f b = C41930g.dOW().mo60487b(new C5681a<Integer, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(129239);
                Integer auI = auI();
                AppMethodBeat.m2505o(129239);
                return auI;
            }

            private Integer auI() {
                AppMethodBeat.m2504i(129238);
                if (C1720g.m3534RN().mo5161QY()) {
                    AppBrandOnOpReportStartEvent.m43000BI(str);
                    final C5688b dMo = C5698f.dMo();
                    C1720g.m3535RO().eJo.mo14539a(1345, new C1202f() {
                        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                            AppMethodBeat.m2504i(129237);
                            if (C19464c.m30140b(c1207m, str)) {
                                C1720g.m3535RO().eJo.mo14546b(1345, (C1202f) this);
                                try {
                                    dMo.mo11581B(Integer.valueOf(C19464c.m30141h(c1207m)));
                                    AppMethodBeat.m2505o(129237);
                                    return;
                                } catch (Exception e) {
                                    dMo.mo11582cR(e);
                                }
                            }
                            AppMethodBeat.m2505o(129237);
                        }
                    });
                    AppMethodBeat.m2505o(129238);
                } else {
                    C5698f.dMj().mo11582cR(new C1819b());
                    AppMethodBeat.m2505o(129238);
                }
                return null;
            }
        });
        AppMethodBeat.m2505o(129243);
        return b;
    }

    /* renamed from: xl */
    public void mo34269xl(String str) {
        AppMethodBeat.m2504i(129244);
        C45516v.avL();
        C45694h.m84420b(C38519g.WASERVICE);
        AppMethodBeat.m2505o(129244);
    }

    /* renamed from: i */
    public void mo34267i(String str, String str2, int i) {
        AppMethodBeat.m2504i(129245);
        SendDataToMiniProgramFromH5Event sendDataToMiniProgramFromH5Event = new SendDataToMiniProgramFromH5Event();
        sendDataToMiniProgramFromH5Event.hJW = str;
        sendDataToMiniProgramFromH5Event.data = str2;
        sendDataToMiniProgramFromH5Event.hJX = i;
        C10276d.m17931a(str, sendDataToMiniProgramFromH5Event);
        AppMethodBeat.m2505o(129245);
    }

    /* renamed from: ax */
    public void mo34265ax(List<String> list) {
        AppMethodBeat.m2504i(129246);
        C42406r.m75073a(list, C33137a.MP_PRELOAD);
        AppMethodBeat.m2505o(129246);
    }

    public final int auH() {
        AppMethodBeat.m2504i(129247);
        int i = WxaCommLibRuntimeReader.avQ().gVu;
        AppMethodBeat.m2505o(129247);
        return i;
    }

    /* renamed from: bq */
    public void mo34266bq(final String str, final String str2) {
        AppMethodBeat.m2504i(129248);
        C41930g.dOW().mo60492h(new C5681a<Void, Void>() {

            /* renamed from: com.tencent.mm.plugin.appbrand.app.d$2$1 */
            class C190191 implements C17829b<ByRuntimeQrcodeResult> {
                C190191() {
                }

                /* renamed from: a */
                public final /* synthetic */ void mo20080a(Parcelable parcelable) {
                    AppMethodBeat.m2504i(129240);
                    ByRuntimeQrcodeResult byRuntimeQrcodeResult = (ByRuntimeQrcodeResult) parcelable;
                    C10608b.m18292cx(str, byRuntimeQrcodeResult == null ? "{}" : byRuntimeQrcodeResult.aHQ()).acy();
                    AppMethodBeat.m2505o(129240);
                }
            }

            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(129242);
                Void asR = asR();
                AppMethodBeat.m2505o(129242);
                return asR;
            }

            private Void asR() {
                AppMethodBeat.m2504i(129241);
                C10608b.m18291Cq(str).acy();
                try {
                    C41726i c41726i = new C41726i(str2);
                    C41726i c41726i2 = new C41726i(c41726i.optString("invokeData"));
                    String optString = c41726i2.optString("miniprogramAppID");
                    Void voidR;
                    if (TextUtils.isEmpty(optString)) {
                        C4990ab.m7412e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage, invalid miniprogramAppId");
                        C10608b.m18290Cp(str).acy();
                        voidR = zXH;
                        AppMethodBeat.m2505o(129241);
                        return voidR;
                    }
                    String optString2 = c41726i2.optString("name");
                    String optString3 = c41726i.optString("runtimeAppid");
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = FaceManager.FACE_ACQUIRED_HACKER;
                    appBrandStatObject.cst = optString3 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + optString2;
                    AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
                    appBrandLaunchReferrer.hgQ = 7;
                    appBrandLaunchReferrer.appId = null;
                    appBrandLaunchReferrer.hgT = c41726i2.toString();
                    LaunchParcel launchParcel = new LaunchParcel();
                    launchParcel.appId = optString;
                    launchParcel.hgC = "__wx__/open-api-redirecting-page";
                    launchParcel.ijy = appBrandStatObject;
                    launchParcel.hgF = appBrandLaunchReferrer;
                    launchParcel.ijB = new C190191();
                    C10600f.ijT.mo33002a(C4996ah.getContext(), launchParcel);
                    voidR = zXH;
                    AppMethodBeat.m2505o(129241);
                    return voidR;
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage, parse failed e = %s, uuid = %s, json = %s", e, str, str2);
                    C10608b.m18290Cp(str).acy();
                }
            }
        }).dMk();
        AppMethodBeat.m2505o(129248);
    }
}
