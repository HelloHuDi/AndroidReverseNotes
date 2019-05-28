package com.tencent.p177mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41725h;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C19071r;
import com.tencent.p177mm.plugin.appbrand.appcache.C45515j.C33097a;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C10173c;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C31283e;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C31284f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.ai */
public class C19559ai extends C42607af<WxaPkgWrappingInfo> implements C27173m {
    public static volatile boolean iiB = false;
    private C27173m iiC = null;

    public /* synthetic */ Object call() {
        AppMethodBeat.m2504i(131984);
        WxaPkgWrappingInfo azZ = azZ();
        AppMethodBeat.m2505o(131984);
        return azZ;
    }

    C19559ai(String str, int i, String str2, int i2, WxaAttributes wxaAttributes) {
        Object obj;
        List list;
        String str3;
        int i3;
        List list2;
        AppMethodBeat.m2504i(131982);
        C31283e ayL = wxaAttributes.ayL();
        List list3;
        if (C33097a.m54090np(i)) {
            obj = (ayL.hio || (iiB && !C5046bo.m7548ek(ayL.hin))) ? 1 : null;
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
                lw = C41725h.m73457lw(((C42611l) C42340f.m74878E(C42611l.class)).mo68052bn(str, i));
            } catch (Exception e) {
                lw = null;
            }
            if (lw == null) {
                obj2 = null;
                list4 = null;
                str4 = null;
                list3 = null;
            } else {
                list4 = C31284f.m50509zA(lw.optString("module_list"));
                list3 = C10173c.m17798zy(lw.optString("wxacode_lib_info_list"));
                obj2 = !C5046bo.m7548ek(list4) ? 1 : null;
                str4 = obj2 != null ? lw.optString("entrance_module") : "";
            }
            i3 = 0;
            list2 = list3;
            str3 = str4;
            list = list4;
            obj = obj2;
        }
        if (!wxaAttributes.ayJ().mo21563xy() || !C19071r.avH() || list2 == null || list2.size() <= 0) {
            if (obj == null || C5046bo.m7548ek(list) || !C19071r.avF()) {
                C4990ab.m7416i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgIntegratedHandler");
                this.iiC = new C19579p(str, i, ayL.axy, i2, ayL) {
                    public final void aHe() {
                        AppMethodBeat.m2504i(131979);
                        C19559ai.this.aHe();
                        AppMethodBeat.m2505o(131979);
                    }

                    public final void aHj() {
                        AppMethodBeat.m2504i(131980);
                        C19559ai.this.aHj();
                        AppMethodBeat.m2505o(131980);
                    }

                    public final void onDownloadProgress(int i) {
                        AppMethodBeat.m2504i(131981);
                        C19559ai.this.onDownloadProgress(i);
                        AppMethodBeat.m2505o(131981);
                    }
                };
                AppMethodBeat.m2505o(131982);
                return;
            }
            C4990ab.m7416i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgModularizingHandler");
            this.iiC = new C38427q(str, i, str2, i2, ayL.axy, i3, str3, list) {
                public final void aHe() {
                    AppMethodBeat.m2504i(131976);
                    super.aHe();
                    C19559ai.this.aHe();
                    AppMethodBeat.m2505o(131976);
                }

                public final void aHj() {
                    AppMethodBeat.m2504i(131977);
                    super.aHj();
                    C19559ai.this.aHj();
                    AppMethodBeat.m2505o(131977);
                }

                public final void onDownloadProgress(int i) {
                    AppMethodBeat.m2504i(131978);
                    C19559ai.this.onDownloadProgress(i);
                    AppMethodBeat.m2505o(131978);
                }
            };
            AppMethodBeat.m2505o(131982);
        } else if (obj == null || C5046bo.m7548ek(list) || !C19071r.avF()) {
            C4990ab.m7416i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgSplitCodeLibHandler");
            this.iiC = new C45642r(str, i, ayL.axy, list2) {
                public final void aHe() {
                    AppMethodBeat.m2504i(131973);
                    super.aHe();
                    C19559ai.this.aHe();
                    AppMethodBeat.m2505o(131973);
                }

                public final void aHj() {
                    AppMethodBeat.m2504i(131974);
                    super.aHj();
                    C19559ai.this.aHj();
                    AppMethodBeat.m2505o(131974);
                }

                public final void onDownloadProgress(int i) {
                    AppMethodBeat.m2504i(131975);
                    C19559ai.this.onDownloadProgress(i);
                    AppMethodBeat.m2505o(131975);
                }
            };
            AppMethodBeat.m2505o(131982);
        } else {
            C4990ab.m7416i("MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper", "LaunchCheckPkgSplitCodeLibModuleHandler");
            this.iiC = new C42616s(str, i, ayL.axy, list) {
                public final void aHe() {
                    AppMethodBeat.m2504i(131970);
                    super.aHe();
                    C19559ai.this.aHe();
                    AppMethodBeat.m2505o(131970);
                }

                public final void aHj() {
                    AppMethodBeat.m2504i(131971);
                    super.aHj();
                    C19559ai.this.aHj();
                    AppMethodBeat.m2505o(131971);
                }

                public final void onDownloadProgress(int i) {
                    AppMethodBeat.m2504i(131972);
                    C19559ai.this.onDownloadProgress(i);
                    AppMethodBeat.m2505o(131972);
                }
            };
            AppMethodBeat.m2505o(131982);
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
        AppMethodBeat.m2504i(131983);
        WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) this.iiC.call();
        AppMethodBeat.m2505o(131983);
        return wxaPkgWrappingInfo;
    }
}
