package com.tencent.p177mm.plugin.appbrand.canvas;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.p282a.C26813i;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.p282a.C33121e;
import com.tencent.p177mm.plugin.appbrand.canvas.p885a.C10148a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import java.util.Stack;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.d */
public final class C2102d implements C33116a {
    public final C32800b eIo = new C32800b();
    public C10148a hcE;
    public C10148a hcF;
    private Stack<C10148a> hcG;
    private Stack<C10148a> hcH;
    public Paint hcI = new Paint();
    public Paint hcJ;
    public C2103e hcK;
    private C33116a hcL;
    public C2241c hcM;
    boolean hcN = true;

    public C2102d(C33116a c33116a) {
        C10148a ayh;
        AppMethodBeat.m2504i(103165);
        this.hcL = c33116a;
        if (this.hcN) {
            ayh = C26813i.ayp().ayh();
        } else {
            ayh = new C10148a();
        }
        this.hcE = ayh;
        this.hcF = this.hcN ? C33121e.ayl().ayh() : new C10148a();
        this.hcE.setStyle(Style.STROKE);
        this.hcF.setStyle(Style.FILL);
        this.hcE.setAntiAlias(true);
        this.hcF.setAntiAlias(true);
        this.hcE.setStrokeWidth((float) C42668g.m75571qb(1));
        this.hcF.setStrokeWidth((float) C42668g.m75571qb(1));
        this.hcG = new Stack();
        this.hcH = new Stack();
        this.hcI.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        AppMethodBeat.m2505o(103165);
    }

    public final void reset() {
        AppMethodBeat.m2504i(103166);
        this.hcG.clear();
        this.hcH.clear();
        this.hcE.reset();
        this.hcF.reset();
        this.hcE.setStyle(Style.STROKE);
        this.hcF.setStyle(Style.FILL);
        this.hcE.setAntiAlias(true);
        this.hcF.setAntiAlias(true);
        this.hcE.setStrokeWidth((float) C42668g.m75571qb(1));
        this.hcF.setStrokeWidth((float) C42668g.m75571qb(1));
        AppMethodBeat.m2505o(103166);
    }

    public final void save() {
        AppMethodBeat.m2504i(103167);
        C10148a c10148a = this.hcE;
        this.hcG.push(this.hcE);
        if (this.hcN) {
            this.hcE = C26813i.ayp().ayh();
            c10148a.mo21505b(this.hcE);
        } else {
            this.hcE = c10148a.ayq();
        }
        if (this.hcE == null) {
            this.hcE = c10148a;
        }
        c10148a = this.hcF;
        this.hcH.push(this.hcF);
        if (this.hcN) {
            this.hcF = C33121e.ayl().ayh();
        } else {
            this.hcF = c10148a.ayq();
        }
        c10148a.mo21505b(this.hcF);
        if (this.hcF == null) {
            this.hcF = c10148a;
        }
        AppMethodBeat.m2505o(103167);
    }

    public final void restore() {
        AppMethodBeat.m2504i(103168);
        if (this.hcG.isEmpty()) {
            AppMethodBeat.m2505o(103168);
            return;
        }
        C10148a c10148a = this.hcE;
        C10148a c10148a2 = this.hcF;
        this.hcE = (C10148a) this.hcG.pop();
        this.hcF = (C10148a) this.hcH.pop();
        if (this.hcN) {
            if (this.hcE != c10148a) {
                C26813i.ayp().mo5900a(c10148a);
            }
            if (this.hcF != c10148a2) {
                C33121e.ayl().mo5900a(c10148a2);
            }
        }
        AppMethodBeat.m2505o(103168);
    }

    public final void invalidate() {
        AppMethodBeat.m2504i(103169);
        this.hcL.invalidate();
        AppMethodBeat.m2505o(103169);
    }
}
