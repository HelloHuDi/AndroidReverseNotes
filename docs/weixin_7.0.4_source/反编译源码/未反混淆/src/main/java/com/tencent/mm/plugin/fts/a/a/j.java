package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class j {
    public int bFZ;
    public i mAJ;
    public g mDz;
    public a mEx;
    public List<l> mEy = new ArrayList();

    public j(i iVar) {
        AppMethodBeat.i(114272);
        this.mAJ = iVar;
        AppMethodBeat.o(114272);
    }

    public final String toString() {
        int i = 0;
        AppMethodBeat.i(114273);
        String str = "{resultCode: %d, resultSize: %d}";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.bFZ);
        if (this.mEy != null) {
            i = this.mEy.size();
        }
        objArr[1] = Integer.valueOf(i);
        String format = String.format(str, objArr);
        AppMethodBeat.o(114273);
        return format;
    }
}
