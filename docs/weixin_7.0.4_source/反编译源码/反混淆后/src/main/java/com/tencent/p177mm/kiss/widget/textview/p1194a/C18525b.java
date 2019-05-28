package com.tencent.p177mm.kiss.widget.textview.p1194a;

import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.kiss.widget.textview.a.b */
public final class C18525b {
    public C42149a eNR;

    /* renamed from: ST */
    public static C18525b m28828ST() {
        AppMethodBeat.m2504i(105816);
        C18525b c18525b = new C18525b();
        c18525b.eNR = new C42149a();
        AppMethodBeat.m2505o(105816);
        return c18525b;
    }

    /* renamed from: SU */
    public final C18525b mo33775SU() {
        this.eNR.maxLines = 6;
        return this;
    }

    /* renamed from: a */
    public final C18525b mo33776a(TruncateAt truncateAt) {
        this.eNR.eND = truncateAt;
        return this;
    }

    /* renamed from: jU */
    public final C18525b mo33778jU(int i) {
        this.eNR.gravity = i;
        return this;
    }

    /* renamed from: ad */
    public final C18525b mo33777ad(float f) {
        this.eNR.eOg = f;
        return this;
    }

    /* renamed from: jV */
    public final C18525b mo33779jV(int i) {
        this.eNR.textColor = i;
        return this;
    }
}
