package android.support.v7.h;

public final class b implements d {
    final d Yr;
    int Ys = 0;
    int Yt = -1;
    int Yu = -1;
    Object Yv = null;

    public b(d dVar) {
        this.Yr = dVar;
    }

    public final void fU() {
        if (this.Ys != 0) {
            switch (this.Ys) {
                case 1:
                    this.Yr.G(this.Yt, this.Yu);
                    break;
                case 2:
                    this.Yr.H(this.Yt, this.Yu);
                    break;
                case 3:
                    this.Yr.a(this.Yt, this.Yu, this.Yv);
                    break;
            }
            this.Yv = null;
            this.Ys = 0;
        }
    }

    public final void G(int i, int i2) {
        if (this.Ys != 1 || i < this.Yt || i > this.Yt + this.Yu) {
            fU();
            this.Yt = i;
            this.Yu = i2;
            this.Ys = 1;
            return;
        }
        this.Yu += i2;
        this.Yt = Math.min(i, this.Yt);
    }

    public final void H(int i, int i2) {
        if (this.Ys != 2 || this.Yt < i || this.Yt > i + i2) {
            fU();
            this.Yt = i;
            this.Yu = i2;
            this.Ys = 2;
            return;
        }
        this.Yu += i2;
        this.Yt = i;
    }

    public final void I(int i, int i2) {
        fU();
        this.Yr.I(i, i2);
    }

    public final void a(int i, int i2, Object obj) {
        if (this.Ys != 3 || i > this.Yt + this.Yu || i + i2 < this.Yt || this.Yv != obj) {
            fU();
            this.Yt = i;
            this.Yu = i2;
            this.Yv = obj;
            this.Ys = 3;
            return;
        }
        int i3 = this.Yt + this.Yu;
        this.Yt = Math.min(i, this.Yt);
        this.Yu = Math.max(i3, i + i2) - this.Yt;
    }
}
