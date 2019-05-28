package com.tencent.p177mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.gif.f */
public final class C3276f {
    public final int[] noD = new int[6];

    public C3276f(String str) {
        AppMethodBeat.m2504i(62420);
        try {
            MMGIFJNI.recycle(MMGIFJNI.openByFilePath(str, this.noD));
            C4990ab.m7417i("MMGIFInfo", "width:%d height:%d", Integer.valueOf(this.noD[0]), Integer.valueOf(this.noD[1]));
            AppMethodBeat.m2505o(62420);
        } catch (MMGIFException e) {
            C4990ab.m7412e("MMGIFInfo", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(62420);
        }
    }
}
