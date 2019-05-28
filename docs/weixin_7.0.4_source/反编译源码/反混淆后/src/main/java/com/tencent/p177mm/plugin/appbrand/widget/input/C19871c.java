package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.tools.C5584f.C5583a;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c.C5581a;
import com.tencent.p177mm.p612ui.widget.C16003g;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.input.C11009af.C11010a;
import com.tencent.p177mm.plugin.appbrand.widget.input.C42744p.C38603a;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C11017h;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C16712e;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.c */
public abstract class C19871c<Input extends EditText & C38595ab> extends C16003g implements C45718aa {
    public C11009af jdj;
    public final int jdk;
    public C27400ae jdl;
    public final WeakReference<C44709u> jdm;
    final String jdn;
    public final OnFocusChangeListener jdo = new C198701();
    private final C5581a jdp = new C198722();

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.c$1 */
    class C198701 implements OnFocusChangeListener {
        C198701() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(123577);
            C19871c.this.mo35107fb(z);
            if (z) {
                C42743o.m75750a((C44709u) C19871c.this.jdm.get(), (C38595ab) C19871c.this.aQl());
                ((C38595ab) C19871c.this.aQl()).setInputId(C19871c.this.jdk);
                C42743o.m75754b((C44709u) C19871c.this.jdm.get(), C19871c.this);
            }
            AppMethodBeat.m2505o(123577);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.c$2 */
    class C198722 extends C38603a {
        C198722() {
        }

        /* renamed from: JX */
        public final void mo11316JX() {
            AppMethodBeat.m2504i(123578);
            if (C19871c.this.aQl() != null) {
                C19871c.this.m30752b(C19871c.this.aQl().getEditableText());
            }
            AppMethodBeat.m2505o(123578);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.c$a */
    public enum C19873a {
        ;

        /* renamed from: a */
        public static C19871c m30763a(String str, C44709u c44709u, C16712e c16712e) {
            AppMethodBeat.m2504i(123581);
            if ("digit".equalsIgnoreCase(str) || "idcard".equalsIgnoreCase(str) || "number".equalsIgnoreCase(str)) {
                C45725d c45725d = new C45725d(str, c44709u, c16712e);
                AppMethodBeat.m2505o(123581);
                return c45725d;
            }
            AppMethodBeat.m2505o(123581);
            return null;
        }
    }

    /* renamed from: EG */
    public abstract boolean mo35095EG(String str);

    public abstract Input aQl();

    public abstract Rect aQm();

    /* renamed from: b */
    public abstract C11017h mo35105b(C11017h c11017h);

    /* renamed from: fb */
    public abstract boolean mo35107fb(boolean z);

    C19871c(String str, C44709u c44709u, int i) {
        this.jdn = str;
        this.jdm = new WeakReference(c44709u);
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
        ((C38595ab) aQl).mo6581b(this.jdo);
        aQl.removeTextChangedListener(this);
        ((C38595ab) aQl).destroy();
        C44709u c44709u = (C44709u) this.jdm.get();
        if (c44709u == null) {
            return false;
        }
        C44719g c44719g = (C44719g) c44709u.aAY();
        if (c44719g == null) {
            return false;
        }
        c44719g.mo71786cF(aQl);
        return true;
    }

    /* renamed from: s */
    public final boolean mo35110s(C44709u c44709u) {
        return c44709u != null && c44709u == this.jdm.get();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo35096a(Editable editable) {
        if (this.jdj != null) {
            this.jdj.mo22667a(editable == null ? "" : editable.toString(), Selection.getSelectionEnd(editable), C11010a.COMPLETE);
        }
    }

    /* renamed from: qx */
    public final void mo35109qx(int i) {
        if (this.jdl != null) {
            this.jdl.mo35141qz(i);
        }
    }

    public final void afterTextChanged(Editable editable) {
        m30752b(editable);
    }

    /* renamed from: b */
    private void m30752b(Editable editable) {
        if (this.jdj != null) {
            this.jdj.mo22667a(editable == null ? "" : editable.toString(), Selection.getSelectionEnd(editable), C11010a.CHANGED);
        }
    }

    /* renamed from: a */
    public final boolean mo35098a(C11017h c11017h) {
        C11017h b = mo35105b(c11017h);
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
        C7357c PM = C42744p.m75759a(aQl()).mo15877PM(b.jjy.intValue());
        PM.zIx = false;
        PM.jeZ = C5583a.MODE_CHINESE_AS_1;
        PM.mo15879a(this.jdp);
        return true;
    }

    /* renamed from: a */
    public final void mo35097a(String str, Integer num) {
        mo35095EG(str);
        Integer valueOf = Integer.valueOf(num == null ? -1 : num.intValue());
        mo35106dq(valueOf.intValue(), valueOf.intValue());
    }

    public final Editable awM() {
        return aQl() == null ? null : aQl().getEditableText();
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: dq */
    public final void mo35106dq(int i, int i2) {
        C27407b.m43486a(aQl(), i, i2);
    }
}
