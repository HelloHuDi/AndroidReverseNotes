package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.Stack;

public final class b implements d<com.tencent.mm.y.b> {
    private Stack<com.tencent.mm.y.b> efp;
    public Stack<com.tencent.mm.y.b> efq;
    public int efs;

    public final /* synthetic */ void add(Object obj) {
        AppMethodBeat.i(116233);
        com.tencent.mm.y.b bVar = (com.tencent.mm.y.b) obj;
        if (this.efp != null) {
            this.efp.push(bVar);
        }
        AppMethodBeat.o(116233);
    }

    public final void onCreate() {
        AppMethodBeat.i(116226);
        this.efp = new Stack();
        AppMethodBeat.o(116226);
    }

    public final void onDestroy() {
        AppMethodBeat.i(116227);
        ab.i("MicroMsg.DoodleCache", "[onDestroy]");
        if (this.efp != null) {
            this.efp.clear();
        }
        if (this.efq != null) {
            this.efq.clear();
        }
        AppMethodBeat.o(116227);
    }

    public final void by(boolean z) {
        AppMethodBeat.i(116228);
        ab.i("MicroMsg.DoodleCache", "[onSave] size:%s", Integer.valueOf(this.efp.size()));
        if (this.efq != null) {
            this.efq.clear();
        }
        this.efq = (Stack) this.efp.clone();
        if (z) {
            this.efp.clear();
        }
        AppMethodBeat.o(116228);
    }

    public final void Je() {
        AppMethodBeat.i(116229);
        ab.i("MicroMsg.DoodleCache", "[onRestore] size:%s", Integer.valueOf(this.efp.size()));
        this.efp.clear();
        if (this.efq != null) {
            ab.i("MicroMsg.DoodleCache", "[onRestore] %s", Integer.valueOf(this.efq.size()));
            this.efp.addAll(this.efq);
        }
        AppMethodBeat.o(116229);
    }

    public final void a(Canvas canvas, boolean z) {
        AppMethodBeat.i(116230);
        if (z) {
            canvas.drawColor(0, Mode.CLEAR);
            Iterator it = this.efp.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.y.b) it.next()).draw(canvas);
            }
            AppMethodBeat.o(116230);
            return;
        }
        com.tencent.mm.y.b bVar;
        if (this.efp == null || this.efp.size() <= 0) {
            bVar = null;
        } else {
            bVar = (com.tencent.mm.y.b) this.efp.peek();
        }
        if (bVar != null) {
            bVar.draw(canvas);
        }
        AppMethodBeat.o(116230);
    }

    public final void b(Canvas canvas) {
        AppMethodBeat.i(116231);
        Iterator it = this.efp.iterator();
        while (it.hasNext()) {
            ((com.tencent.mm.y.b) it.next()).draw(canvas);
        }
        AppMethodBeat.o(116231);
    }

    public final int ac(boolean z) {
        AppMethodBeat.i(116232);
        int size;
        if (z) {
            if (this.efp != null) {
                size = this.efp.size();
                AppMethodBeat.o(116232);
                return size;
            }
            AppMethodBeat.o(116232);
            return 0;
        } else if (this.efq != null) {
            size = this.efq.size();
            AppMethodBeat.o(116232);
            return size;
        } else {
            AppMethodBeat.o(116232);
            return 0;
        }
    }

    public final void CO() {
        this.efs++;
    }

    public final /* synthetic */ Object pop() {
        AppMethodBeat.i(116234);
        if (this.efp.size() <= 0) {
            AppMethodBeat.o(116234);
            return null;
        }
        com.tencent.mm.y.b bVar = (com.tencent.mm.y.b) this.efp.pop();
        AppMethodBeat.o(116234);
        return bVar;
    }
}
