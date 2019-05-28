package android.support.p069v7.p075h;

/* renamed from: android.support.v7.h.b */
public final class C8421b implements C44964d {
    /* renamed from: Yr */
    final C44964d f2405Yr;
    /* renamed from: Ys */
    int f2406Ys = 0;
    /* renamed from: Yt */
    int f2407Yt = -1;
    /* renamed from: Yu */
    int f2408Yu = -1;
    /* renamed from: Yv */
    Object f2409Yv = null;

    public C8421b(C44964d c44964d) {
        this.f2405Yr = c44964d;
    }

    /* renamed from: fU */
    public final void mo18390fU() {
        if (this.f2406Ys != 0) {
            switch (this.f2406Ys) {
                case 1:
                    this.f2405Yr.mo1469G(this.f2407Yt, this.f2408Yu);
                    break;
                case 2:
                    this.f2405Yr.mo1470H(this.f2407Yt, this.f2408Yu);
                    break;
                case 3:
                    this.f2405Yr.mo1472a(this.f2407Yt, this.f2408Yu, this.f2409Yv);
                    break;
            }
            this.f2409Yv = null;
            this.f2406Ys = 0;
        }
    }

    /* renamed from: G */
    public final void mo1469G(int i, int i2) {
        if (this.f2406Ys != 1 || i < this.f2407Yt || i > this.f2407Yt + this.f2408Yu) {
            mo18390fU();
            this.f2407Yt = i;
            this.f2408Yu = i2;
            this.f2406Ys = 1;
            return;
        }
        this.f2408Yu += i2;
        this.f2407Yt = Math.min(i, this.f2407Yt);
    }

    /* renamed from: H */
    public final void mo1470H(int i, int i2) {
        if (this.f2406Ys != 2 || this.f2407Yt < i || this.f2407Yt > i + i2) {
            mo18390fU();
            this.f2407Yt = i;
            this.f2408Yu = i2;
            this.f2406Ys = 2;
            return;
        }
        this.f2408Yu += i2;
        this.f2407Yt = i;
    }

    /* renamed from: I */
    public final void mo1471I(int i, int i2) {
        mo18390fU();
        this.f2405Yr.mo1471I(i, i2);
    }

    /* renamed from: a */
    public final void mo1472a(int i, int i2, Object obj) {
        if (this.f2406Ys != 3 || i > this.f2407Yt + this.f2408Yu || i + i2 < this.f2407Yt || this.f2409Yv != obj) {
            mo18390fU();
            this.f2407Yt = i;
            this.f2408Yu = i2;
            this.f2409Yv = obj;
            this.f2406Ys = 3;
            return;
        }
        int i3 = this.f2407Yt + this.f2408Yu;
        this.f2407Yt = Math.min(i, this.f2407Yt);
        this.f2408Yu = Math.max(i3, i + i2) - this.f2407Yt;
    }
}
