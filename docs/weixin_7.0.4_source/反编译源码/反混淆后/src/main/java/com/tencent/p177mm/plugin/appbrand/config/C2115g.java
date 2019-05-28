package com.tencent.p177mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1812ai;
import com.tencent.p177mm.platformtools.C1952t.C1953a;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.config.g */
public final class C2115g {

    /* renamed from: com.tencent.mm.plugin.appbrand.config.g$1 */
    public class C21161 extends C1812ai {
        public final void transfer(int i) {
            AppMethodBeat.m2504i(129842);
            if (mo5386kw(i)) {
                try {
                    C4990ab.m7410d("MicroMsg.AppBrandNewContactFixVersionStateTransfer", "doFix()");
                    C42340f auL = C42340f.auL();
                    if (auL != null) {
                        C1953a auM = auL.auM();
                        C42340f.auO();
                        auM.mo10108hY("WxaAttributesTable", String.format(Locale.US, "update %s set %s='' where %s is null or %s=''", new Object[]{"WxaAttributesTable", "syncVersion", "versionInfo", "versionInfo"}));
                        AppMethodBeat.m2505o(129842);
                        return;
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.AppBrandNewContactFixVersionStateTransfer", "doFix e = %s", e);
                }
                AppMethodBeat.m2505o(129842);
                return;
            }
            AppMethodBeat.m2505o(129842);
        }

        /* renamed from: kw */
        public final boolean mo5386kw(int i) {
            return i >= 637863936 && i <= 637863988;
        }

        public final String getTag() {
            return "MicroMsg.AppBrandNewContactFixVersionStateTransfer";
        }
    }
}
