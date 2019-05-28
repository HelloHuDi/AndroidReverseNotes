package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p200ay.C1304a;
import com.tencent.p177mm.p200ay.C1304a.C1302a;
import com.tencent.p177mm.storage.C7620bi;
import java.util.Map;

/* renamed from: com.tencent.mm.model.bo */
public final class C37904bo extends C1304a {

    /* renamed from: com.tencent.mm.model.bo$1 */
    static class C66691 extends C1302a {
        C66691() {
        }

        /* renamed from: a */
        public final C1304a mo4612a(Map<String, String> map, C7620bi c7620bi) {
            AppMethodBeat.m2504i(11237);
            C37904bo c37904bo = new C37904bo(map, c7620bi);
            AppMethodBeat.m2505o(11237);
            return c37904bo;
        }
    }

    public C37904bo(Map<String, String> map, C7620bi c7620bi) {
        super(map, c7620bi);
    }

    /* renamed from: Yt */
    public final boolean mo4614Yt() {
        AppMethodBeat.m2504i(11238);
        if (this.values == null) {
            AppMethodBeat.m2505o(11238);
        } else if (this.TYPE.equals("reportbizlocation")) {
            String str = (String) this.values.get(".sysmsg.reportbizlocation.link.text");
            String str2 = ((String) this.values.get(".sysmsg.reportbizlocation.text")) + str;
            this.fKY.add(str);
            this.fKZ.addFirst(Integer.valueOf(str2.length() - str.length()));
            this.fLa.add(Integer.valueOf(str2.length()));
            this.fKW = str2;
            AppMethodBeat.m2505o(11238);
        } else {
            AppMethodBeat.m2505o(11238);
        }
        return false;
    }

    /* renamed from: Yu */
    public static void m64014Yu() {
        AppMethodBeat.m2504i(11239);
        C1302a.m2777a("reportbizlocation", new C66691());
        AppMethodBeat.m2505o(11239);
    }
}
