package com.tencent.p177mm.plugin.p369d.p370a.p372b.p373a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.C38832h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.d.a.b.a.f */
public class C24737f extends C20287a {
    static final String TAG = C24737f.class.getName();
    public static String jIf = C38832h.jGK;
    public static String jIg = C38832h.jGL;
    public int jIh;
    public int jIi;
    public int jIj;
    public long jIk;
    public long jIl;

    static {
        AppMethodBeat.m2504i(18473);
        AppMethodBeat.m2505o(18473);
    }

    public C24737f() {
        this.jHc = null;
        this.jHd = 8;
        this.jGw = 1;
        this.jIh = -1;
        this.jIi = -1;
        this.jIj = -1;
        this.jIk = 0;
        this.jIl = 0;
    }

    public final byte[] aVE() {
        AppMethodBeat.m2504i(18472);
        if (this.jIh < 0) {
            C4990ab.m7412e(TAG, "stepCount is invalid");
            AppMethodBeat.m2505o(18472);
            return null;
        }
        int i;
        int i2;
        if (this.jIi >= 0) {
            i = 7;
        } else {
            i = 4;
        }
        if (this.jIj >= 0) {
            i += 3;
        }
        byte[] bArr = new byte[i];
        bArr[0] = (byte) 1;
        i = 1;
        for (i2 = 0; i2 < 3; i2++) {
            bArr[i] = (byte) ((this.jIh >> (i2 * 8)) & 255);
            i++;
        }
        if (this.jIi >= 0) {
            bArr[0] = (byte) (bArr[0] | 2);
            for (i2 = 0; i2 < 3; i2++) {
                bArr[i] = (byte) ((this.jIi >> (i2 * 8)) & 255);
                i++;
            }
        }
        if (this.jIj >= 0) {
            bArr[0] = (byte) 4;
            int i3 = 0;
            i2 = i;
            while (i3 < 3) {
                bArr[i2] = (byte) ((this.jIj >> (i3 * 8)) & 255);
                i3++;
                i2++;
            }
        }
        AppMethodBeat.m2505o(18472);
        return bArr;
    }
}
