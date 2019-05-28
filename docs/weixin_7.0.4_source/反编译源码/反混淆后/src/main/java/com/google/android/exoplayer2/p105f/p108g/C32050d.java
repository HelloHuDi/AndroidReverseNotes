package com.google.android.exoplayer2.p105f.p108g;

import android.text.Layout.Alignment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.f.g.d */
final class C32050d {
    int backgroundColor;
    String bnS = null;
    int bnT;
    boolean bnU = false;
    boolean bnV = false;
    int bnW = -1;
    int bnX = -1;
    int bnY = -1;
    int bnZ = -1;
    List<String> boA = Collections.emptyList();
    String boB = "";
    int boa = -1;
    Alignment boc = null;
    String boy = "";
    String boz = "";
    float fontSize;

    public C32050d() {
        AppMethodBeat.m2504i(95723);
        AppMethodBeat.m2505o(95723);
    }

    public final int getStyle() {
        int i = 0;
        if (this.bnY == -1 && this.bnZ == -1) {
            return -1;
        }
        int i2 = this.bnY == 1 ? 1 : 0;
        if (this.bnZ == 1) {
            i = 2;
        }
        return i2 | i;
    }

    /* renamed from: a */
    static int m52101a(int i, String str, String str2, int i2) {
        AppMethodBeat.m2504i(95724);
        if (str.isEmpty() || i == -1) {
            AppMethodBeat.m2505o(95724);
            return i;
        } else if (str.equals(str2)) {
            i += i2;
            AppMethodBeat.m2505o(95724);
            return i;
        } else {
            AppMethodBeat.m2505o(95724);
            return -1;
        }
    }
}
