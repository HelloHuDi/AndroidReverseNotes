package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Stack;

public final class a implements d<com.tencent.mm.y.a> {
    public Stack<com.tencent.mm.y.a> efp;
    private Stack<com.tencent.mm.y.a> efq;
    public Matrix efr = new Matrix();
    private int efs;

    public a() {
        AppMethodBeat.i(116215);
        AppMethodBeat.o(116215);
    }

    public final /* synthetic */ void add(Object obj) {
        AppMethodBeat.i(116224);
        a((com.tencent.mm.y.a) obj);
        AppMethodBeat.o(116224);
    }

    public final /* synthetic */ Object pop() {
        AppMethodBeat.i(116225);
        com.tencent.mm.y.a Jf = Jf();
        AppMethodBeat.o(116225);
        return Jf;
    }

    public final void onCreate() {
        AppMethodBeat.i(116216);
        ab.i("MicroMsg.CropCache", "[onCreate]");
        this.efp = new Stack();
        AppMethodBeat.o(116216);
    }

    public final void onDestroy() {
        AppMethodBeat.i(116217);
        if (this.efp != null) {
            this.efp.clear();
        }
        if (this.efq != null) {
            this.efq.clear();
        }
        this.efr.reset();
        AppMethodBeat.o(116217);
    }

    public final void by(boolean z) {
        AppMethodBeat.i(116218);
        ab.i("MicroMsg.CropCache", "[onSave] size:%s", Integer.valueOf(this.efp.size()));
        if (this.efq != null) {
            this.efq.clear();
        }
        this.efq = (Stack) this.efp.clone();
        if (z) {
            this.efp.clear();
        }
        AppMethodBeat.o(116218);
    }

    public final void Je() {
        AppMethodBeat.i(116219);
        ab.i("MicroMsg.CropCache", "[onRestore] size:%s", Integer.valueOf(this.efp.size()));
        this.efp.clear();
        if (this.efq != null) {
            ab.i("MicroMsg.CropCache", "[onRestore] %s", Integer.valueOf(this.efq.size()));
            this.efp.addAll(this.efq);
        }
        AppMethodBeat.o(116219);
    }

    public final void a(Canvas canvas, boolean z) {
    }

    public final void b(Canvas canvas) {
    }

    public final com.tencent.mm.y.a Jf() {
        AppMethodBeat.i(116220);
        if (this.efp.size() <= 0) {
            ab.e("MicroMsg.CropCache", "[pop]");
            AppMethodBeat.o(116220);
            return null;
        }
        com.tencent.mm.y.a aVar = (com.tencent.mm.y.a) this.efp.pop();
        AppMethodBeat.o(116220);
        return aVar;
    }

    public final void a(com.tencent.mm.y.a aVar) {
        AppMethodBeat.i(116221);
        if (this.efp != null) {
            this.efp.push(aVar);
        }
        AppMethodBeat.o(116221);
    }

    public final com.tencent.mm.y.a Jg() {
        AppMethodBeat.i(116222);
        if (this.efp == null || this.efp.size() <= 0) {
            AppMethodBeat.o(116222);
            return null;
        }
        com.tencent.mm.y.a aVar = (com.tencent.mm.y.a) this.efp.peek();
        AppMethodBeat.o(116222);
        return aVar;
    }

    public final int ac(boolean z) {
        AppMethodBeat.i(116223);
        int size;
        if (z) {
            if (this.efp != null) {
                size = this.efp.size();
                AppMethodBeat.o(116223);
                return size;
            }
            AppMethodBeat.o(116223);
            return 0;
        } else if (this.efq != null) {
            size = this.efq.size();
            AppMethodBeat.o(116223);
            return size;
        } else {
            AppMethodBeat.o(116223);
            return 0;
        }
    }

    public final void CO() {
        this.efs++;
    }
}
