package com.tencent.mm.plugin.appbrand.app;

import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.i;
import com.tencent.mm.ai.m;
import com.tencent.mm.ci.f;
import com.tencent.mm.ci.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.j;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.AppBrandOnOpReportStartEvent;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.c;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.ByRuntimeQrcodeResult;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.a;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.e;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;

class d implements a {
    d() {
    }

    public e<Integer> xk(final String str) {
        AppMethodBeat.i(129243);
        f b = g.dOW().b(new com.tencent.mm.vending.c.a<Integer, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(129239);
                Integer auI = auI();
                AppMethodBeat.o(129239);
                return auI;
            }

            private Integer auI() {
                AppMethodBeat.i(129238);
                if (com.tencent.mm.kernel.g.RN().QY()) {
                    AppBrandOnOpReportStartEvent.BI(str);
                    final b dMo = com.tencent.mm.vending.g.f.dMo();
                    com.tencent.mm.kernel.g.RO().eJo.a(1345, new com.tencent.mm.ai.f() {
                        public final void onSceneEnd(int i, int i2, String str, m mVar) {
                            AppMethodBeat.i(129237);
                            if (c.b(mVar, str)) {
                                com.tencent.mm.kernel.g.RO().eJo.b(1345, (com.tencent.mm.ai.f) this);
                                try {
                                    dMo.B(Integer.valueOf(c.h(mVar)));
                                    AppMethodBeat.o(129237);
                                    return;
                                } catch (Exception e) {
                                    dMo.cR(e);
                                }
                            }
                            AppMethodBeat.o(129237);
                        }
                    });
                    AppMethodBeat.o(129238);
                } else {
                    com.tencent.mm.vending.g.f.dMj().cR(new com.tencent.mm.model.b());
                    AppMethodBeat.o(129238);
                }
                return null;
            }
        });
        AppMethodBeat.o(129243);
        return b;
    }

    public void xl(String str) {
        AppMethodBeat.i(129244);
        v.avL();
        h.b(com.tencent.mm.plugin.appbrand.task.g.WASERVICE);
        AppMethodBeat.o(129244);
    }

    public void i(String str, String str2, int i) {
        AppMethodBeat.i(129245);
        SendDataToMiniProgramFromH5Event sendDataToMiniProgramFromH5Event = new SendDataToMiniProgramFromH5Event();
        sendDataToMiniProgramFromH5Event.hJW = str;
        sendDataToMiniProgramFromH5Event.data = str2;
        sendDataToMiniProgramFromH5Event.hJX = i;
        com.tencent.mm.plugin.appbrand.ipc.d.a(str, sendDataToMiniProgramFromH5Event);
        AppMethodBeat.o(129245);
    }

    public void ax(List<String> list) {
        AppMethodBeat.i(129246);
        r.a(list, j.a.MP_PRELOAD);
        AppMethodBeat.o(129246);
    }

    public final int auH() {
        AppMethodBeat.i(129247);
        int i = WxaCommLibRuntimeReader.avQ().gVu;
        AppMethodBeat.o(129247);
        return i;
    }

    public void bq(final String str, final String str2) {
        AppMethodBeat.i(129248);
        g.dOW().h(new com.tencent.mm.vending.c.a<Void, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(129242);
                Void asR = asR();
                AppMethodBeat.o(129242);
                return asR;
            }

            private Void asR() {
                AppMethodBeat.i(129241);
                com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b.Cq(str).acy();
                try {
                    i iVar = new i(str2);
                    i iVar2 = new i(iVar.optString("invokeData"));
                    String optString = iVar2.optString("miniprogramAppID");
                    Void voidR;
                    if (TextUtils.isEmpty(optString)) {
                        ab.e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage, invalid miniprogramAppId");
                        com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b.Cp(str).acy();
                        voidR = zXH;
                        AppMethodBeat.o(129241);
                        return voidR;
                    }
                    String optString2 = iVar2.optString("name");
                    String optString3 = iVar.optString("runtimeAppid");
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = FaceManager.FACE_ACQUIRED_HACKER;
                    appBrandStatObject.cst = optString3 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + optString2;
                    AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
                    appBrandLaunchReferrer.hgQ = 7;
                    appBrandLaunchReferrer.appId = null;
                    appBrandLaunchReferrer.hgT = iVar2.toString();
                    LaunchParcel launchParcel = new LaunchParcel();
                    launchParcel.appId = optString;
                    launchParcel.hgC = "__wx__/open-api-redirecting-page";
                    launchParcel.ijy = appBrandStatObject;
                    launchParcel.hgF = appBrandLaunchReferrer;
                    launchParcel.ijB = new com.tencent.luggage.sdk.launching.b<ByRuntimeQrcodeResult>() {
                        public final /* synthetic */ void a(Parcelable parcelable) {
                            AppMethodBeat.i(129240);
                            ByRuntimeQrcodeResult byRuntimeQrcodeResult = (ByRuntimeQrcodeResult) parcelable;
                            com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b.cx(str, byRuntimeQrcodeResult == null ? "{}" : byRuntimeQrcodeResult.aHQ()).acy();
                            AppMethodBeat.o(129240);
                        }
                    };
                    com.tencent.mm.plugin.appbrand.launching.precondition.f.ijT.a(ah.getContext(), launchParcel);
                    voidR = zXH;
                    AppMethodBeat.o(129241);
                    return voidR;
                } catch (Exception e) {
                    ab.e("MicroMsg.AppBrand.ServiceForWebView", "privateOpenWeappFunctionalPage, parse failed e = %s, uuid = %s, json = %s", e, str, str2);
                    com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b.Cp(str).acy();
                }
            }
        }).dMk();
        AppMethodBeat.o(129248);
    }
}
