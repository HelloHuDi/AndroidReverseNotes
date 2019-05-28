package com.tencent.p177mm.plugin.emoji.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C18232da;
import com.tencent.p177mm.sdk.p600b.C4879a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.emoji.model.e */
public final class C20382e {
    private C18232da kVn = new C18232da();
    public final Map<String, Integer> kVo = new HashMap();

    public C20382e() {
        AppMethodBeat.m2504i(53045);
        AppMethodBeat.m2505o(53045);
    }

    /* renamed from: g */
    public final void mo35678g(String str, int i, int i2, String str2) {
        AppMethodBeat.m2504i(53046);
        this.kVn.cwf.cwg = str;
        this.kVn.cwf.status = i;
        this.kVn.cwf.progress = i2;
        this.kVn.cwf.cwh = str2;
        C4879a.xxA.mo10055m(this.kVn);
        if (i != 6) {
            this.kVo.remove(str);
            AppMethodBeat.m2505o(53046);
        } else if (i2 < 0 || i2 >= 100) {
            this.kVo.remove(str);
            AppMethodBeat.m2505o(53046);
        } else {
            this.kVo.put(str, Integer.valueOf(i2));
            AppMethodBeat.m2505o(53046);
        }
    }
}
