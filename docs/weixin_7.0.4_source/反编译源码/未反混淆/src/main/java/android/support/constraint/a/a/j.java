package android.support.constraint.a.a;

import java.util.Arrays;

public class j extends f {
    protected int hn = 0;
    protected f[] kh = new f[4];

    public final void e(f fVar) {
        if (this.hn + 1 > this.kh.length) {
            this.kh = (f[]) Arrays.copyOf(this.kh, this.kh.length * 2);
        }
        this.kh[this.hn] = fVar;
        this.hn++;
    }

    public final void bd() {
        this.hn = 0;
    }
}
