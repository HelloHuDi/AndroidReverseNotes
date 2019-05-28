package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.e;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.i;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.r.g;
import java.util.Stack;

public final class d implements a {
    public final b eIo = new b();
    public a hcE;
    public a hcF;
    private Stack<a> hcG;
    private Stack<a> hcH;
    public Paint hcI = new Paint();
    public Paint hcJ;
    public e hcK;
    private a hcL;
    public c hcM;
    boolean hcN = true;

    public d(a aVar) {
        a ayh;
        AppMethodBeat.i(103165);
        this.hcL = aVar;
        if (this.hcN) {
            ayh = i.ayp().ayh();
        } else {
            ayh = new a();
        }
        this.hcE = ayh;
        this.hcF = this.hcN ? e.ayl().ayh() : new a();
        this.hcE.setStyle(Style.STROKE);
        this.hcF.setStyle(Style.FILL);
        this.hcE.setAntiAlias(true);
        this.hcF.setAntiAlias(true);
        this.hcE.setStrokeWidth((float) g.qb(1));
        this.hcF.setStrokeWidth((float) g.qb(1));
        this.hcG = new Stack();
        this.hcH = new Stack();
        this.hcI.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        AppMethodBeat.o(103165);
    }

    public final void reset() {
        AppMethodBeat.i(103166);
        this.hcG.clear();
        this.hcH.clear();
        this.hcE.reset();
        this.hcF.reset();
        this.hcE.setStyle(Style.STROKE);
        this.hcF.setStyle(Style.FILL);
        this.hcE.setAntiAlias(true);
        this.hcF.setAntiAlias(true);
        this.hcE.setStrokeWidth((float) g.qb(1));
        this.hcF.setStrokeWidth((float) g.qb(1));
        AppMethodBeat.o(103166);
    }

    public final void save() {
        AppMethodBeat.i(103167);
        a aVar = this.hcE;
        this.hcG.push(this.hcE);
        if (this.hcN) {
            this.hcE = i.ayp().ayh();
            aVar.b(this.hcE);
        } else {
            this.hcE = aVar.ayq();
        }
        if (this.hcE == null) {
            this.hcE = aVar;
        }
        aVar = this.hcF;
        this.hcH.push(this.hcF);
        if (this.hcN) {
            this.hcF = e.ayl().ayh();
        } else {
            this.hcF = aVar.ayq();
        }
        aVar.b(this.hcF);
        if (this.hcF == null) {
            this.hcF = aVar;
        }
        AppMethodBeat.o(103167);
    }

    public final void restore() {
        AppMethodBeat.i(103168);
        if (this.hcG.isEmpty()) {
            AppMethodBeat.o(103168);
            return;
        }
        a aVar = this.hcE;
        a aVar2 = this.hcF;
        this.hcE = (a) this.hcG.pop();
        this.hcF = (a) this.hcH.pop();
        if (this.hcN) {
            if (this.hcE != aVar) {
                i.ayp().a(aVar);
            }
            if (this.hcF != aVar2) {
                e.ayl().a(aVar2);
            }
        }
        AppMethodBeat.o(103168);
    }

    public final void invalidate() {
        AppMethodBeat.i(103169);
        this.hcL.invalidate();
        AppMethodBeat.o(103169);
    }
}
