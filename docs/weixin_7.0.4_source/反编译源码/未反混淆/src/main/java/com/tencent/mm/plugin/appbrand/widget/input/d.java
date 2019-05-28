package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import com.tencent.mm.plugin.appbrand.widget.input.v.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class d extends c<s> {
    int jdr = 0;
    s jds;
    v jdt;
    h jdu;
    boolean jdv;
    boolean jdw;

    d(String str, u uVar, e eVar) {
        super(str, uVar, eVar.jdk);
        AppMethodBeat.i(123583);
        this.jds = new s(uVar.mContext);
        this.jdr = bo.a((Integer) o.jeS.get(str), 0);
        AppMethodBeat.o(123583);
    }

    public final View getInputPanel() {
        AppMethodBeat.i(123584);
        aQu();
        v vVar = this.jdt;
        AppMethodBeat.o(123584);
        return vVar;
    }

    public final boolean aQr() {
        AppMethodBeat.i(123585);
        if (this.jdu == null || !aj.g(this.jdu.jjM)) {
            AppMethodBeat.o(123585);
            return false;
        }
        AppMethodBeat.o(123585);
        return true;
    }

    public final int aQs() {
        AppMethodBeat.i(123586);
        if (this.jdu == null || this.jdu.jjJ == null) {
            AppMethodBeat.o(123586);
            return 0;
        }
        int intValue = this.jdu.jjJ.intValue();
        AppMethodBeat.o(123586);
        return intValue;
    }

    /* Access modifiers changed, original: final */
    public final Rect aQm() {
        AppMethodBeat.i(123587);
        Rect rect = new Rect(this.jdu.jjs.intValue(), this.jdu.jjr.intValue(), this.jdu.jjs.intValue() + this.jdu.jjp.intValue(), this.jdu.jjr.intValue() + this.jdu.jjq.intValue());
        AppMethodBeat.o(123587);
        return rect;
    }

    public final h b(h hVar) {
        AppMethodBeat.i(123588);
        if (this.jdu == null) {
            this.jdu = hVar;
            if (aj.g(hVar.jjU) && this.jds != null) {
                this.jds.setPasswordMode(true);
            }
        } else {
            this.jdu.a(hVar);
        }
        if (this.jds == null) {
            AppMethodBeat.o(123588);
            return null;
        }
        b.a(this.jds, this.jdu);
        h hVar2 = this.jdu;
        AppMethodBeat.o(123588);
        return hVar2;
    }

    public final boolean EG(String str) {
        AppMethodBeat.i(123589);
        if (this.jds == null) {
            AppMethodBeat.o(123589);
            return false;
        }
        this.jds.B(str);
        AppMethodBeat.o(123589);
        return true;
    }

    public final boolean dr(int i, int i2) {
        AppMethodBeat.i(123590);
        if (this.jds == null) {
            AppMethodBeat.o(123590);
            return false;
        }
        this.jdt = v.cM(((u) this.jdm.get()).getContentView());
        if (this.jdt == null) {
            AppMethodBeat.o(123590);
            return false;
        }
        this.jdw = true;
        u uVar = (u) this.jdm.get();
        if (!(uVar == null || uVar.aJz() == null)) {
            h.aQx().c(uVar.aJz());
        }
        this.jdt.setXMode(this.jdr);
        v vVar = this.jdt;
        EditText editText = this.jds;
        if (editText != null) {
            if (vVar.tc != editText) {
                vVar.aQW();
            }
            vVar.setInputEditText(editText);
            vVar.setVisibility(0);
        }
        this.jdt.setOnDoneListener(new a() {
            public final void onDone() {
                AppMethodBeat.i(123582);
                d.this.a(d.this.awM());
                d.this.fb(false);
                AppMethodBeat.o(123582);
            }
        });
        dq(i, i2);
        k.a(this.jdm).qA(this.jdk);
        this.jdw = false;
        AppMethodBeat.o(123590);
        return true;
    }

    public final boolean aQt() {
        AppMethodBeat.i(123591);
        if (aQu() == null) {
            AppMethodBeat.o(123591);
            return false;
        } else if (isFocused()) {
            v vVar = this.jdt;
            vVar.setVisibility(8);
            vVar.aQW();
            ab.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] disableInputFocus %s", this.jds);
            if (this.jds != null) {
                this.jds.setFocusable(false);
                this.jds.setFocusableInTouchMode(false);
                this.jds.setEnabled(false);
            }
            u uVar = (u) this.jdm.get();
            if (!(uVar == null || uVar.aJz() == null)) {
                h.aQx().d(uVar.aJz());
            }
            k.a(this.jdm).qB(this.jdk);
            AppMethodBeat.o(123591);
            return true;
        } else {
            AppMethodBeat.o(123591);
            return false;
        }
    }

    private boolean isFocused() {
        AppMethodBeat.i(123592);
        if (this.jds == null) {
            AppMethodBeat.o(123592);
            return false;
        } else if (this.jds.isFocused()) {
            AppMethodBeat.o(123592);
            return true;
        } else if (aQu() == null) {
            AppMethodBeat.o(123592);
            return false;
        } else if (!aQu().isShown()) {
            AppMethodBeat.o(123592);
            return false;
        } else if (this.jdt.getAttachedEditText() == this.jds) {
            AppMethodBeat.o(123592);
            return true;
        } else {
            AppMethodBeat.o(123592);
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean fb(boolean z) {
        AppMethodBeat.i(123593);
        ab.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] onFocusChanged hasFocus %b, isFocused %b", Boolean.valueOf(z), Boolean.valueOf(isFocused()));
        if (z) {
            if (this.jdw) {
                AppMethodBeat.o(123593);
            } else if (isFocused()) {
                AppMethodBeat.o(123593);
            } else {
                this.jdw = true;
                dr(-2, -2);
                this.jdw = false;
                AppMethodBeat.o(123593);
            }
        } else if (this.jdv) {
            AppMethodBeat.o(123593);
        } else if (isFocused()) {
            this.jdv = true;
            a(awM());
            aQt();
            aQp();
            this.jdv = false;
            this.jds = null;
            AppMethodBeat.o(123593);
        } else {
            AppMethodBeat.o(123593);
        }
        return true;
    }

    private v aQu() {
        AppMethodBeat.i(123594);
        v vVar;
        if (this.jdt != null) {
            vVar = this.jdt;
            AppMethodBeat.o(123594);
            return vVar;
        }
        vVar = (v) this.jds.getInputPanel();
        this.jdt = vVar;
        AppMethodBeat.o(123594);
        return vVar;
    }

    /* Access modifiers changed, original: final|bridge|synthetic */
    public final /* bridge */ /* synthetic */ EditText aQl() {
        return this.jds;
    }
}
