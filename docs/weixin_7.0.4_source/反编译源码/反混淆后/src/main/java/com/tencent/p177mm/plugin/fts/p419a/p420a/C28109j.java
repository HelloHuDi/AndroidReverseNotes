package com.tencent.p177mm.plugin.fts.p419a.p420a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.a.a.j */
public final class C28109j {
    public int bFZ;
    public C20846i mAJ;
    public C20840g mDz;
    public C28106a mEx;
    public List<C45966l> mEy = new ArrayList();

    public C28109j(C20846i c20846i) {
        AppMethodBeat.m2504i(114272);
        this.mAJ = c20846i;
        AppMethodBeat.m2505o(114272);
    }

    public final String toString() {
        int i = 0;
        AppMethodBeat.m2504i(114273);
        String str = "{resultCode: %d, resultSize: %d}";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.bFZ);
        if (this.mEy != null) {
            i = this.mEy.size();
        }
        objArr[1] = Integer.valueOf(i);
        String format = String.format(str, objArr);
        AppMethodBeat.m2505o(114273);
        return format;
    }
}
