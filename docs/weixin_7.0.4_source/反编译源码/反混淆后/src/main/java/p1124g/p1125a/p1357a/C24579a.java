package p1124g.p1125a.p1357a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

/* renamed from: g.a.a.a */
public final class C24579a {
    public int BUo;
    public byte[] BZr;
    public int BZs = 0;
    public int BZt;
    public OutputStream BZu;

    public final void eno() {
        AppMethodBeat.m2504i(86235);
        enp();
        this.BZu = null;
        AppMethodBeat.m2505o(86235);
    }

    public final void enp() {
        AppMethodBeat.m2504i(86236);
        int i = this.BUo - this.BZt;
        if (i == 0) {
            AppMethodBeat.m2505o(86236);
            return;
        }
        this.BZu.write(this.BZr, this.BZt, i);
        if (this.BUo >= this.BZs) {
            this.BUo = 0;
        }
        this.BZt = this.BUo;
        AppMethodBeat.m2505o(86236);
    }

    /* renamed from: Vn */
    public final byte mo41362Vn(int i) {
        int i2 = (this.BUo - i) - 1;
        if (i2 < 0) {
            i2 += this.BZs;
        }
        return this.BZr[i2];
    }
}
