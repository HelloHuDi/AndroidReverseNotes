package com.tencent.p177mm.pluginsdk.p597ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7580z;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.b */
public final class C44095b {

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.b$a */
    static class C14975a {
        List<String> qnw;

        private C14975a() {
            AppMethodBeat.m2504i(79908);
            this.qnw = new ArrayList();
            AppMethodBeat.m2505o(79908);
        }

        /* synthetic */ C14975a(byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final String dll() {
            AppMethodBeat.m2504i(79909);
            String str;
            if (this.qnw == null || this.qnw.size() == 0) {
                str = "";
                AppMethodBeat.m2505o(79909);
                return str;
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : this.qnw) {
                stringBuffer.append(str2);
                stringBuffer.append(";");
            }
            str2 = stringBuffer.toString();
            AppMethodBeat.m2505o(79909);
            return str2;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: We */
        public final void mo27345We(String str) {
            AppMethodBeat.m2504i(79910);
            this.qnw = new ArrayList();
            if (str == null || str.length() == 0) {
                AppMethodBeat.m2505o(79910);
                return;
            }
            for (Object add : str.split(";")) {
                this.qnw.add(add);
            }
            AppMethodBeat.m2505o(79910);
        }
    }

    public static boolean ajU(String str) {
        AppMethodBeat.m2504i(79911);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.AppNewIconUtil", "markNew fail, appId is empty");
            AppMethodBeat.m2505o(79911);
            return false;
        }
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        if (Ry == null) {
            C4990ab.m7412e("MicroMsg.AppNewIconUtil", "markNew fail, cfgStg is null");
            AppMethodBeat.m2505o(79911);
            return false;
        }
        C14975a c14975a = new C14975a();
        c14975a.mo27345We((String) Ry.get(69121, null));
        if (!c14975a.qnw.contains(str)) {
            c14975a.qnw.add(str);
        }
        Ry.set(69121, c14975a.dll());
        AppMethodBeat.m2505o(79911);
        return true;
    }

    public static boolean ajV(String str) {
        AppMethodBeat.m2504i(79912);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.AppNewIconUtil", "unmarkNew fail, appId is empty");
            AppMethodBeat.m2505o(79912);
            return false;
        }
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        if (Ry == null) {
            C4990ab.m7412e("MicroMsg.AppNewIconUtil", "unmarkNew fail, cfgStg is null");
            AppMethodBeat.m2505o(79912);
            return false;
        }
        C14975a c14975a = new C14975a();
        c14975a.mo27345We((String) Ry.get(69121, null));
        if (c14975a.qnw.contains(str)) {
            c14975a.qnw.remove(str);
        }
        Ry.set(69121, c14975a.dll());
        AppMethodBeat.m2505o(79912);
        return true;
    }
}
