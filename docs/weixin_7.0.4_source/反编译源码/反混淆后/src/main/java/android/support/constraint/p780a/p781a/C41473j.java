package android.support.constraint.p780a.p781a;

import java.util.Arrays;

/* renamed from: android.support.constraint.a.a.j */
public class C41473j extends C17368f {
    /* renamed from: hn */
    protected int f16635hn = 0;
    /* renamed from: kh */
    protected C17368f[] f16636kh = new C17368f[4];

    /* renamed from: e */
    public final void mo66146e(C17368f c17368f) {
        if (this.f16635hn + 1 > this.f16636kh.length) {
            this.f16636kh = (C17368f[]) Arrays.copyOf(this.f16636kh, this.f16636kh.length * 2);
        }
        this.f16636kh[this.f16635hn] = c17368f;
        this.f16635hn++;
    }

    /* renamed from: bd */
    public final void mo66145bd() {
        this.f16635hn = 0;
    }
}
