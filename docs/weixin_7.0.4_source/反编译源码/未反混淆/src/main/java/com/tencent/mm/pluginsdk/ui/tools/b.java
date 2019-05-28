package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.List;

public final class b {

    static class a {
        List<String> qnw;

        private a() {
            AppMethodBeat.i(79908);
            this.qnw = new ArrayList();
            AppMethodBeat.o(79908);
        }

        /* synthetic */ a(byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        public final String dll() {
            AppMethodBeat.i(79909);
            String str;
            if (this.qnw == null || this.qnw.size() == 0) {
                str = "";
                AppMethodBeat.o(79909);
                return str;
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : this.qnw) {
                stringBuffer.append(str2);
                stringBuffer.append(";");
            }
            str2 = stringBuffer.toString();
            AppMethodBeat.o(79909);
            return str2;
        }

        /* Access modifiers changed, original: final */
        public final void We(String str) {
            AppMethodBeat.i(79910);
            this.qnw = new ArrayList();
            if (str == null || str.length() == 0) {
                AppMethodBeat.o(79910);
                return;
            }
            for (Object add : str.split(";")) {
                this.qnw.add(add);
            }
            AppMethodBeat.o(79910);
        }
    }

    public static boolean ajU(String str) {
        AppMethodBeat.i(79911);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.AppNewIconUtil", "markNew fail, appId is empty");
            AppMethodBeat.o(79911);
            return false;
        }
        z Ry = g.RP().Ry();
        if (Ry == null) {
            ab.e("MicroMsg.AppNewIconUtil", "markNew fail, cfgStg is null");
            AppMethodBeat.o(79911);
            return false;
        }
        a aVar = new a();
        aVar.We((String) Ry.get(69121, null));
        if (!aVar.qnw.contains(str)) {
            aVar.qnw.add(str);
        }
        Ry.set(69121, aVar.dll());
        AppMethodBeat.o(79911);
        return true;
    }

    public static boolean ajV(String str) {
        AppMethodBeat.i(79912);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, appId is empty");
            AppMethodBeat.o(79912);
            return false;
        }
        z Ry = g.RP().Ry();
        if (Ry == null) {
            ab.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, cfgStg is null");
            AppMethodBeat.o(79912);
            return false;
        }
        a aVar = new a();
        aVar.We((String) Ry.get(69121, null));
        if (aVar.qnw.contains(str)) {
            aVar.qnw.remove(str);
        }
        Ry.set(69121, aVar.dll());
        AppMethodBeat.o(79912);
        return true;
    }
}
