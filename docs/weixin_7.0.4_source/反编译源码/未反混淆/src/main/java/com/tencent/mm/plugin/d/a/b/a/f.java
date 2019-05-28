package com.tencent.mm.plugin.d.a.b.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d.a.b.h;
import com.tencent.mm.sdk.platformtools.ab;

@TargetApi(18)
public class f extends a {
    static final String TAG = f.class.getName();
    public static String jIf = h.jGK;
    public static String jIg = h.jGL;
    public int jIh;
    public int jIi;
    public int jIj;
    public long jIk;
    public long jIl;

    static {
        AppMethodBeat.i(18473);
        AppMethodBeat.o(18473);
    }

    public f() {
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
        AppMethodBeat.i(18472);
        if (this.jIh < 0) {
            ab.e(TAG, "stepCount is invalid");
            AppMethodBeat.o(18472);
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
        AppMethodBeat.o(18472);
        return bArr;
    }
}
