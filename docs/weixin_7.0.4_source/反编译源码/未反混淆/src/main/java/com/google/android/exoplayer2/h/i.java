package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class i {
    public final long bgY;
    public final byte[] bpP;
    public final long bpQ;
    public final int flags;
    public final String key;
    public final long position;
    public final Uri uri;

    public i(Uri uri) {
        this(uri, (byte) 0);
    }

    public i(Uri uri, long j, long j2, String str) {
        this(uri, j, j, j2, str, 0);
        AppMethodBeat.i(95801);
        AppMethodBeat.o(95801);
    }

    public i(Uri uri, byte b) {
        this(uri, 0, 0, -1, null, 1);
    }

    private i(Uri uri, long j, long j2, long j3, String str, int i) {
        this(uri, null, j, j2, j3, str, i);
    }

    private i(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        AppMethodBeat.i(95802);
        a.checkArgument(j >= 0);
        a.checkArgument(j2 >= 0);
        boolean z = j3 > 0 || j3 == -1;
        a.checkArgument(z);
        this.uri = uri;
        this.bpP = bArr;
        this.bpQ = j;
        this.position = j2;
        this.bgY = j3;
        this.key = str;
        this.flags = i;
        AppMethodBeat.o(95802);
    }

    public final boolean to() {
        return (this.flags & 1) == 1;
    }

    public final String toString() {
        AppMethodBeat.i(95803);
        String str = "DataSpec[" + this.uri + ", " + Arrays.toString(this.bpP) + ", " + this.bpQ + ", " + this.position + ", " + this.bgY + ", " + this.key + ", " + this.flags + "]";
        AppMethodBeat.o(95803);
        return str;
    }

    public final i am(long j) {
        long j2 = -1;
        AppMethodBeat.i(95804);
        if (this.bgY != -1) {
            j2 = this.bgY - j;
        }
        i k = k(j, j2);
        AppMethodBeat.o(95804);
        return k;
    }

    private i k(long j, long j2) {
        AppMethodBeat.i(95805);
        if (j == 0 && this.bgY == j2) {
            AppMethodBeat.o(95805);
            return this;
        }
        i iVar = new i(this.uri, this.bpP, this.bpQ + j, this.position + j, j2, this.key, this.flags);
        AppMethodBeat.o(95805);
        return iVar;
    }
}
