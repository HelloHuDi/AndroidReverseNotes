package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p200ay.C1304a;
import com.tencent.p177mm.p200ay.C1304a.C1302a;
import com.tencent.p177mm.storage.C7620bi;
import java.util.Map;

/* renamed from: com.tencent.mm.model.k */
public final class C26429k extends C1304a {

    /* renamed from: com.tencent.mm.model.k$1 */
    static class C264301 extends C1302a {
        C264301() {
        }

        /* renamed from: a */
        public final C1304a mo4612a(Map<String, String> map, C7620bi c7620bi) {
            AppMethodBeat.m2504i(11234);
            C26429k c26429k = new C26429k(map, c7620bi);
            AppMethodBeat.m2505o(11234);
            return c26429k;
        }
    }

    public C26429k(Map<String, String> map, C7620bi c7620bi) {
        super(map, c7620bi);
    }

    /* renamed from: Yt */
    public final boolean mo4614Yt() {
        AppMethodBeat.m2504i(11235);
        if (this.values == null) {
            AppMethodBeat.m2505o(11235);
        } else if (this.TYPE.equals("biz_services_mute")) {
            String str = (String) this.values.get(".sysmsg.biz_services_mute.link.text");
            String str2 = ((String) this.values.get(".sysmsg.biz_services_mute.text")) + str;
            this.fKY.add(str);
            this.fKZ.addFirst(Integer.valueOf(str2.length() - str.length()));
            this.fLa.add(Integer.valueOf(str2.length()));
            this.fKW = str2;
            AppMethodBeat.m2505o(11235);
        } else {
            AppMethodBeat.m2505o(11235);
        }
        return false;
    }

    /* renamed from: Yu */
    public static void m42085Yu() {
        AppMethodBeat.m2504i(11236);
        C1302a.m2777a("biz_services_mute", new C264301());
        AppMethodBeat.m2505o(11236);
    }
}
