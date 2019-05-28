package com.google.android.exoplayer2.p110h;

import android.net.Uri;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.h.i */
public final class C17665i {
    public final long bgY;
    public final byte[] bpP;
    public final long bpQ;
    public final int flags;
    public final String key;
    public final long position;
    public final Uri uri;

    public C17665i(Uri uri) {
        this(uri, (byte) 0);
    }

    public C17665i(Uri uri, long j, long j2, String str) {
        this(uri, j, j, j2, str, 0);
        AppMethodBeat.m2504i(95801);
        AppMethodBeat.m2505o(95801);
    }

    public C17665i(Uri uri, byte b) {
        this(uri, 0, 0, -1, null, 1);
    }

    private C17665i(Uri uri, long j, long j2, long j3, String str, int i) {
        this(uri, null, j, j2, j3, str, i);
    }

    private C17665i(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        AppMethodBeat.m2504i(95802);
        C45039a.checkArgument(j >= 0);
        C45039a.checkArgument(j2 >= 0);
        boolean z = j3 > 0 || j3 == -1;
        C45039a.checkArgument(z);
        this.uri = uri;
        this.bpP = bArr;
        this.bpQ = j;
        this.position = j2;
        this.bgY = j3;
        this.key = str;
        this.flags = i;
        AppMethodBeat.m2505o(95802);
    }

    /* renamed from: to */
    public final boolean mo32359to() {
        return (this.flags & 1) == 1;
    }

    public final String toString() {
        AppMethodBeat.m2504i(95803);
        String str = "DataSpec[" + this.uri + ", " + Arrays.toString(this.bpP) + ", " + this.bpQ + ", " + this.position + ", " + this.bgY + ", " + this.key + ", " + this.flags + "]";
        AppMethodBeat.m2505o(95803);
        return str;
    }

    /* renamed from: am */
    public final C17665i mo32358am(long j) {
        long j2 = -1;
        AppMethodBeat.m2504i(95804);
        if (this.bgY != -1) {
            j2 = this.bgY - j;
        }
        C17665i k = m27539k(j, j2);
        AppMethodBeat.m2505o(95804);
        return k;
    }

    /* renamed from: k */
    private C17665i m27539k(long j, long j2) {
        AppMethodBeat.m2504i(95805);
        if (j == 0 && this.bgY == j2) {
            AppMethodBeat.m2505o(95805);
            return this;
        }
        C17665i c17665i = new C17665i(this.uri, this.bpP, this.bpQ + j, this.position + j, j2, this.key, this.flags);
        AppMethodBeat.m2505o(95805);
        return c17665i;
    }
}
