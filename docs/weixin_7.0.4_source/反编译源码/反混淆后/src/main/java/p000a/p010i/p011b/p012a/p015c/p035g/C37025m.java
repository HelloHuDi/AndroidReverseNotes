package p000a.p010i.p011b.p012a.p015c.p035g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

/* renamed from: a.i.b.a.c.g.m */
public class C37025m {
    private C31710d BAb;
    private C31715g BAc;
    private volatile boolean BAd;
    protected volatile C8185q BAe;

    /* renamed from: e */
    public final C8185q mo59065e(C8185q c8185q) {
        C8185q c8185q2 = this.BAe;
        this.BAe = c8185q;
        this.BAb = null;
        this.BAd = true;
        return c8185q2;
    }

    /* renamed from: vq */
    public final int mo59066vq() {
        AppMethodBeat.m2504i(121550);
        int vq;
        if (this.BAd) {
            vq = this.BAe.mo144vq();
            AppMethodBeat.m2505o(121550);
            return vq;
        }
        vq = this.BAb.size();
        AppMethodBeat.m2505o(121550);
        return vq;
    }

    /* renamed from: d */
    public final C8185q mo59064d(C8185q c8185q) {
        AppMethodBeat.m2504i(121549);
        if (this.BAe == null) {
            synchronized (this) {
                try {
                    if (this.BAe != null) {
                    } else {
                        try {
                            if (this.BAb != null) {
                                this.BAe = (C8185q) c8185q.ecy().mo188b(this.BAb, this.BAc);
                            } else {
                                this.BAe = c8185q;
                            }
                        } catch (IOException e) {
                        }
                    }
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(121549);
                }
            }
        }
        C8185q c8185q2 = this.BAe;
        AppMethodBeat.m2505o(121549);
        return c8185q2;
    }
}
