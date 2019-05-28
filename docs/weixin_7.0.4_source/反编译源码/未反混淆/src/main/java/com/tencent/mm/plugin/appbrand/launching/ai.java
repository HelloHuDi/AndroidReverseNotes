package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.h;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import org.json.JSONObject;

public class ai extends af<WxaPkgWrappingInfo> implements m {
    public static volatile boolean iiB = false;
    private m iiC = null;

    public /* synthetic */ Object call() {
        AppMethodBeat.i(131984);
        WxaPkgWrappingInfo azZ = azZ();
        AppMethodBeat.o(131984);
        return azZ;
    }

    ai(String str, int i, String str2, int i2, WxaAttributes wxaAttributes) {
        Object obj;
        List list;
        String str3;
        int i3;
        List list2;
        AppMethodBeat.i(131982);
        e ayL = wxaAttributes.ayL();
        List list3;
        if (a.np(i)) {
            obj = (ayL.hio || (iiB && !bo.ek(ayL.hin))) ? 1 : null;
            list = ayL.hin;
            str3 = ayL.hip;
            list3 = ayL.hil;
            i3 = ayL.him;
            list2 = list3;
        } else {
            JSONObject lw;
            Object obj2;
            List list4;
            String str4;
            try {
                lw = h.lw(((l) f.E(l.class)).bn(str, i));
            } catch (Exception e) {
                lw = null;
            }
            if (lw == null) {
                obj2 = null;
                list4 = null;
                str4 = null;
                list3 = null;
            } else {
                list4 = WxaAttributes.f.zA(lw.optString("module_list"));
                list3 = c.zy(lw.optString("wxacode_lib_info_list"));
                obj2 = !bo.ek(list4) ? 1 : null;
                str4 = obj2 != null ? lw.optString("entrance_module") : "";
            }
            i3 = 0;
            list2 = list3;
            str3 = str4;
            list = list4;
            obj = obj2;
        }
        if (!wxaAttributes.ayJ().xy() || !r.avH() || list2 == null || list2.size() <= 0) {
            if (obj == null || bo.ek(list) || !r.avF()) {
                ab.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgIntegratedHandler");
                this.iiC = new p(str, i, ayL.axy, i2, ayL) {
                    public final void aHe() {
                        AppMethodBeat.i(131979);
                        ai.this.aHe();
                        AppMethodBeat.o(131979);
                    }

                    public final void aHj() {
                        AppMethodBeat.i(131980);
                        ai.this.aHj();
                        AppMethodBeat.o(131980);
                    }

                    public final void onDownloadProgress(int i) {
                        AppMethodBeat.i(131981);
                        ai.this.onDownloadProgress(i);
                        AppMethodBeat.o(131981);
                    }
                };
                AppMethodBeat.o(131982);
                return;
            }
            ab.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgModularizingHandler");
            this.iiC = new q(str, i, str2, i2, ayL.axy, i3, str3, list) {
                public final void aHe() {
                    AppMethodBeat.i(131976);
                    super.aHe();
                    ai.this.aHe();
                    AppMethodBeat.o(131976);
                }

                public final void aHj() {
                    AppMethodBeat.i(131977);
                    super.aHj();
                    ai.this.aHj();
                    AppMethodBeat.o(131977);
                }

                public final void onDownloadProgress(int i) {
                    AppMethodBeat.i(131978);
                    ai.this.onDownloadProgress(i);
                    AppMethodBeat.o(131978);
                }
            };
            AppMethodBeat.o(131982);
        } else if (obj == null || bo.ek(list) || !r.avF()) {
            ab.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgSplitCodeLibHandler");
            this.iiC = new r(str, i, ayL.axy, list2) {
                public final void aHe() {
                    AppMethodBeat.i(131973);
                    super.aHe();
                    ai.this.aHe();
                    AppMethodBeat.o(131973);
                }

                public final void aHj() {
                    AppMethodBeat.i(131974);
                    super.aHj();
                    ai.this.aHj();
                    AppMethodBeat.o(131974);
                }

                public final void onDownloadProgress(int i) {
                    AppMethodBeat.i(131975);
                    ai.this.onDownloadProgress(i);
                    AppMethodBeat.o(131975);
                }
            };
            AppMethodBeat.o(131982);
        } else {
            ab.i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgSplitCodeLibModuleHandler");
            this.iiC = new s(str, i, ayL.axy, list) {
                public final void aHe() {
                    AppMethodBeat.i(131970);
                    super.aHe();
                    ai.this.aHe();
                    AppMethodBeat.o(131970);
                }

                public final void aHj() {
                    AppMethodBeat.i(131971);
                    super.aHj();
                    ai.this.aHj();
                    AppMethodBeat.o(131971);
                }

                public final void onDownloadProgress(int i) {
                    AppMethodBeat.i(131972);
                    ai.this.onDownloadProgress(i);
                    AppMethodBeat.o(131972);
                }
            };
            AppMethodBeat.o(131982);
        }
    }

    /* Access modifiers changed, original: final */
    public final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper";
    }

    public void aHe() {
    }

    public void aHj() {
    }

    public void onDownloadProgress(int i) {
    }

    public final WxaPkgWrappingInfo azZ() {
        AppMethodBeat.i(131983);
        WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) this.iiC.call();
        AppMethodBeat.o(131983);
        return wxaPkgWrappingInfo;
    }
}
