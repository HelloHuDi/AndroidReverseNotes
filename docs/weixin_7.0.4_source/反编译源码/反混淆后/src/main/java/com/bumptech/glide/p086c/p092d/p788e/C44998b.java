package com.bumptech.glide.p086c.p092d.p788e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.p085b.C25400a.C25401a;
import com.bumptech.glide.p086c.p088b.p089a.C31925e;
import com.bumptech.glide.p086c.p088b.p089a.C8515b;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.c.d.e.b */
public final class C44998b implements C25401a {
    private final C31925e awf;
    private final C8515b awk;

    public C44998b(C31925e c31925e, C8515b c8515b) {
        this.awf = c31925e;
        this.awk = c8515b;
    }

    /* renamed from: b */
    public final Bitmap mo42440b(int i, int i2, Config config) {
        AppMethodBeat.m2504i(92307);
        Bitmap h = this.awf.mo2200h(i, i2, config);
        AppMethodBeat.m2505o(92307);
        return h;
    }

    /* renamed from: f */
    public final void mo42443f(Bitmap bitmap) {
        AppMethodBeat.m2504i(92308);
        this.awf.mo2199g(bitmap);
        AppMethodBeat.m2505o(92308);
    }

    /* renamed from: da */
    public final byte[] mo42441da(int i) {
        AppMethodBeat.m2504i(92309);
        byte[] bArr;
        if (this.awk == null) {
            bArr = new byte[i];
            AppMethodBeat.m2505o(92309);
            return bArr;
        }
        bArr = (byte[]) this.awk.mo18608a(i, byte[].class);
        AppMethodBeat.m2505o(92309);
        return bArr;
    }

    /* renamed from: g */
    public final void mo42444g(byte[] bArr) {
        AppMethodBeat.m2504i(92310);
        if (this.awk == null) {
            AppMethodBeat.m2505o(92310);
            return;
        }
        this.awk.put(bArr);
        AppMethodBeat.m2505o(92310);
    }

    /* renamed from: db */
    public final int[] mo42442db(int i) {
        AppMethodBeat.m2504i(92311);
        int[] iArr;
        if (this.awk == null) {
            iArr = new int[i];
            AppMethodBeat.m2505o(92311);
            return iArr;
        }
        iArr = (int[]) this.awk.mo18608a(i, int[].class);
        AppMethodBeat.m2505o(92311);
        return iArr;
    }

    /* renamed from: k */
    public final void mo42445k(int[] iArr) {
        AppMethodBeat.m2504i(92312);
        if (this.awk == null) {
            AppMethodBeat.m2505o(92312);
            return;
        }
        this.awk.put(iArr);
        AppMethodBeat.m2505o(92312);
    }
}
