package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import com.tencent.mm.ui.widget.g;
import java.lang.ref.WeakReference;

public abstract class c<Input extends EditText & ab> extends g implements aa {
    public af jdj;
    public final int jdk;
    public ae jdl;
    public final WeakReference<u> jdm;
    final String jdn;
    public final OnFocusChangeListener jdo = new OnFocusChangeListener() {
        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.i(123577);
            c.this.fb(z);
            if (z) {
                o.a((u) c.this.jdm.get(), (ab) c.this.aQl());
                ((ab) c.this.aQl()).setInputId(c.this.jdk);
                o.b((u) c.this.jdm.get(), c.this);
            }
            AppMethodBeat.o(123577);
        }
    };
    private final com.tencent.mm.ui.tools.b.c.a jdp = new com.tencent.mm.plugin.appbrand.widget.input.p.a() {
        public final void JX() {
            AppMethodBeat.i(123578);
            if (c.this.aQl() != null) {
                c.this.b(c.this.aQl().getEditableText());
            }
            AppMethodBeat.o(123578);
        }
    };

    public enum a {
        ;

        public static c a(String str, u uVar, e eVar) {
            AppMethodBeat.i(123581);
            if ("digit".equalsIgnoreCase(str) || "idcard".equalsIgnoreCase(str) || "number".equalsIgnoreCase(str)) {
                d dVar = new d(str, uVar, eVar);
                AppMethodBeat.o(123581);
                return dVar;
            }
            AppMethodBeat.o(123581);
            return null;
        }
    }

    public abstract boolean EG(String str);

    public abstract Input aQl();

    public abstract Rect aQm();

    public abstract h b(h hVar);

    public abstract boolean fb(boolean z);

    c(String str, u uVar, int i) {
        this.jdn = str;
        this.jdm = new WeakReference(uVar);
        this.jdk = i;
    }

    public final int getInputId() {
        return this.jdk;
    }

    public final boolean aQn() {
        return aQp();
    }

    public final Input aQo() {
        return aQl();
    }

    public final boolean aQp() {
        EditText aQl = aQl();
        if (aQl == null) {
            return false;
        }
        ((ab) aQl).b(this.jdo);
        aQl.removeTextChangedListener(this);
        ((ab) aQl).destroy();
        u uVar = (u) this.jdm.get();
        if (uVar == null) {
            return false;
        }
        g gVar = (g) uVar.aAY();
        if (gVar == null) {
            return false;
        }
        gVar.cF(aQl);
        return true;
    }

    public final boolean s(u uVar) {
        return uVar != null && uVar == this.jdm.get();
    }

    /* Access modifiers changed, original: final */
    public final void a(Editable editable) {
        if (this.jdj != null) {
            this.jdj.a(editable == null ? "" : editable.toString(), Selection.getSelectionEnd(editable), com.tencent.mm.plugin.appbrand.widget.input.af.a.COMPLETE);
        }
    }

    public final void qx(int i) {
        if (this.jdl != null) {
            this.jdl.qz(i);
        }
    }

    public final void afterTextChanged(Editable editable) {
        b(editable);
    }

    private void b(Editable editable) {
        if (this.jdj != null) {
            this.jdj.a(editable == null ? "" : editable.toString(), Selection.getSelectionEnd(editable), com.tencent.mm.plugin.appbrand.widget.input.af.a.CHANGED);
        }
    }

    public final boolean a(h hVar) {
        h b = b(hVar);
        if (b == null) {
            return false;
        }
        if (b.jjy == null) {
            b.jjy = Integer.valueOf(140);
        } else if (b.jjy.intValue() <= 0) {
            b.jjy = Integer.valueOf(BaseClientBuilder.API_PRIORITY_OTHER);
        }
        if (aQl() == null) {
            return false;
        }
        com.tencent.mm.ui.tools.b.c PM = p.a(aQl()).PM(b.jjy.intValue());
        PM.zIx = false;
        PM.jeZ = com.tencent.mm.ui.tools.f.a.MODE_CHINESE_AS_1;
        PM.a(this.jdp);
        return true;
    }

    public final void a(String str, Integer num) {
        EG(str);
        Integer valueOf = Integer.valueOf(num == null ? -1 : num.intValue());
        dq(valueOf.intValue(), valueOf.intValue());
    }

    public final Editable awM() {
        return aQl() == null ? null : aQl().getEditableText();
    }

    /* Access modifiers changed, original: protected|final */
    public final void dq(int i, int i2) {
        b.a(aQl(), i, i2);
    }
}
