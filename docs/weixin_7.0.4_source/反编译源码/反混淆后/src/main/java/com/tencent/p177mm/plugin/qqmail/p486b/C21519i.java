package com.tencent.p177mm.plugin.qqmail.p486b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.qqmail.b.i */
public final class C21519i {
    public C28741k ptG;

    public C21519i(String str) {
        AppMethodBeat.m2504i(67928);
        this.ptG = new C28741k(str, 10);
        AppMethodBeat.m2505o(67928);
    }

    /* renamed from: cQ */
    public final C21520j mo36996cQ(String str, int i) {
        AppMethodBeat.m2504i(67929);
        byte[] readFromFile = C28741k.readFromFile(this.ptG.ptQ + C21519i.m32973cR(str, i));
        if (readFromFile == null || readFromFile.length == 0) {
            AppMethodBeat.m2505o(67929);
            return null;
        }
        try {
            C21520j c21520j = (C21520j) new C21520j().parseFrom(readFromFile);
            AppMethodBeat.m2505o(67929);
            return c21520j;
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.DraftBoxMgr", e, "", new Object[0]);
            AppMethodBeat.m2505o(67929);
            return null;
        }
    }

    /* renamed from: cR */
    public static String m32973cR(String str, int i) {
        String str2;
        AppMethodBeat.m2504i(67930);
        if (str == null || str.length() == 0) {
            str2 = C1720g.m3536RP().mo5239Ry().get(9, null);
        } else {
            str2 = str + "_" + i;
        }
        AppMethodBeat.m2505o(67930);
        return str2;
    }
}
