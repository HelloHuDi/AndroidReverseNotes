package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzzr {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final byte[] zzbsq;
    private static final ByteBuffer zzbsr;
    private static final zzze zzbss;

    static {
        AppMethodBeat.m2504i(3587);
        byte[] bArr = new byte[0];
        zzbsq = bArr;
        zzbsr = ByteBuffer.wrap(bArr);
        bArr = zzbsq;
        zzbss = zzze.zza(bArr, 0, bArr.length, false);
        AppMethodBeat.m2505o(3587);
    }

    static <T> T checkNotNull(T t) {
        AppMethodBeat.m2504i(3585);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.m2505o(3585);
            throw nullPointerException;
        }
        AppMethodBeat.m2505o(3585);
        return t;
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static <T> T zza(T t, String str) {
        AppMethodBeat.m2504i(3586);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException(str);
            AppMethodBeat.m2505o(3586);
            throw nullPointerException;
        }
        AppMethodBeat.m2505o(3586);
        return t;
    }
}
