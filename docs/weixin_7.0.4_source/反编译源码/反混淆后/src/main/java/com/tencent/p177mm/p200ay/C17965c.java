package com.tencent.p177mm.p200ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.storage.C7620bi;
import java.util.Map;

/* renamed from: com.tencent.mm.ay.c */
public final class C17965c extends C1304a {
    public C17965c(Map<String, String> map, C7620bi c7620bi) {
        super(map, c7620bi);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Yt */
    public final boolean mo4614Yt() {
        AppMethodBeat.m2504i(5555);
        if (this.values == null) {
            AppMethodBeat.m2505o(5555);
        } else if (this.TYPE.equals("chatroommuteexpt")) {
            String str = (String) this.values.get(".sysmsg.chatroommuteexpt.link.text");
            String str2 = ((String) this.values.get(".sysmsg.chatroommuteexpt.text")) + str;
            this.fKY.add(str);
            this.fKZ.addFirst(Integer.valueOf(str2.length() - str.length()));
            this.fLa.add(Integer.valueOf(str2.length()));
            this.fKW = str2;
            AppMethodBeat.m2505o(5555);
        } else {
            AppMethodBeat.m2505o(5555);
        }
        return false;
    }
}
