package com.tencent.p177mm.p205bt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;

/* renamed from: com.tencent.mm.bt.b */
public final class C1332b {
    /* renamed from: wR */
    public byte[] f1226wR;

    private C1332b() {
    }

    public C1332b(byte[] bArr) {
        this(bArr, 0, bArr.length);
        AppMethodBeat.m2504i(51823);
        AppMethodBeat.m2505o(51823);
    }

    public C1332b(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(51824);
        this.f1226wR = new byte[i2];
        System.arraycopy(bArr, i, this.f1226wR, 0, i2);
        AppMethodBeat.m2505o(51824);
    }

    /* renamed from: y */
    public static C1332b m2848y(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(51825);
        C1332b c1332b = new C1332b(bArr, i, i2);
        AppMethodBeat.m2505o(51825);
        return c1332b;
    }

    /* renamed from: bI */
    public static C1332b m2847bI(byte[] bArr) {
        AppMethodBeat.m2504i(51826);
        if (bArr == null) {
            bArr = new byte[0];
        }
        C1332b c1332b = new C1332b(bArr);
        AppMethodBeat.m2505o(51826);
        return c1332b;
    }

    public static C1332b akB(String str) {
        AppMethodBeat.m2504i(51827);
        try {
            C1332b c1332b = new C1332b();
            c1332b.f1226wR = str.getBytes("UTF-8");
            AppMethodBeat.m2505o(51827);
            return c1332b;
        } catch (UnsupportedEncodingException e) {
            RuntimeException runtimeException = new RuntimeException("UTF-8 not supported?", e);
            AppMethodBeat.m2505o(51827);
            throw runtimeException;
        }
    }

    /* renamed from: Lv */
    public final C1332b mo4675Lv(int i) {
        AppMethodBeat.m2504i(51828);
        byte[] bArr = new byte[i];
        if (this.f1226wR.length >= i) {
            System.arraycopy(this.f1226wR, 0, bArr, 0, i - 1);
            this.f1226wR = bArr;
        } else {
            System.arraycopy(this.f1226wR, 0, bArr, 0, this.f1226wR.length);
            this.f1226wR = bArr;
        }
        AppMethodBeat.m2505o(51828);
        return this;
    }

    /* renamed from: bJ */
    public final void mo4676bJ(byte[] bArr) {
        AppMethodBeat.m2504i(51829);
        System.arraycopy(this.f1226wR, 0, bArr, 4, this.f1226wR.length);
        AppMethodBeat.m2505o(51829);
    }

    /* renamed from: f */
    public final void mo4678f(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.m2504i(51830);
        System.arraycopy(this.f1226wR, i, bArr, i2, i3);
        AppMethodBeat.m2505o(51830);
    }

    public final byte[] toByteArray() {
        AppMethodBeat.m2504i(51831);
        int length = this.f1226wR.length;
        byte[] bArr = new byte[length];
        System.arraycopy(this.f1226wR, 0, bArr, 0, length);
        AppMethodBeat.m2505o(51831);
        return bArr;
    }

    public final byte[] getBytes() {
        return this.f1226wR;
    }

    public final String dlY() {
        int i = 0;
        AppMethodBeat.m2504i(51832);
        while (i < this.f1226wR.length) {
            try {
                if (this.f1226wR[i] == (byte) 0) {
                    break;
                }
                i++;
            } catch (UnsupportedEncodingException e) {
                RuntimeException runtimeException = new RuntimeException("UTF-8 not supported?");
                AppMethodBeat.m2505o(51832);
                throw runtimeException;
            }
        }
        String str = new String(this.f1226wR, 0, i, "UTF-8");
        AppMethodBeat.m2505o(51832);
        return str;
    }
}
