package a.i.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public class m {
    private d BAb;
    private g BAc;
    private volatile boolean BAd;
    protected volatile q BAe;

    public final q e(q qVar) {
        q qVar2 = this.BAe;
        this.BAe = qVar;
        this.BAb = null;
        this.BAd = true;
        return qVar2;
    }

    public final int vq() {
        AppMethodBeat.i(121550);
        int vq;
        if (this.BAd) {
            vq = this.BAe.vq();
            AppMethodBeat.o(121550);
            return vq;
        }
        vq = this.BAb.size();
        AppMethodBeat.o(121550);
        return vq;
    }

    public final q d(q qVar) {
        AppMethodBeat.i(121549);
        if (this.BAe == null) {
            synchronized (this) {
                try {
                    if (this.BAe != null) {
                    } else {
                        try {
                            if (this.BAb != null) {
                                this.BAe = (q) qVar.ecy().b(this.BAb, this.BAc);
                            } else {
                                this.BAe = qVar;
                            }
                        } catch (IOException e) {
                        }
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(121549);
                }
            }
        }
        q qVar2 = this.BAe;
        AppMethodBeat.o(121549);
        return qVar2;
    }
}
