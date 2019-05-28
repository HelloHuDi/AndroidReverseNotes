package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.input.C46899v.C2576a;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C11017h;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C16712e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.d */
final class C45725d extends C19871c<C11039s> {
    int jdr = 0;
    C11039s jds;
    C46899v jdt;
    C11017h jdu;
    boolean jdv;
    boolean jdw;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.d$1 */
    class C457241 implements C2576a {
        C457241() {
        }

        public final void onDone() {
            AppMethodBeat.m2504i(123582);
            C45725d.this.mo35096a(C45725d.this.awM());
            C45725d.this.mo35107fb(false);
            AppMethodBeat.m2505o(123582);
        }
    }

    C45725d(String str, C44709u c44709u, C16712e c16712e) {
        super(str, c44709u, c16712e.jdk);
        AppMethodBeat.m2504i(123583);
        this.jds = new C11039s(c44709u.mContext);
        this.jdr = C5046bo.m7512a((Integer) C42743o.jeS.get(str), 0);
        AppMethodBeat.m2505o(123583);
    }

    public final View getInputPanel() {
        AppMethodBeat.m2504i(123584);
        aQu();
        C46899v c46899v = this.jdt;
        AppMethodBeat.m2505o(123584);
        return c46899v;
    }

    public final boolean aQr() {
        AppMethodBeat.m2504i(123585);
        if (this.jdu == null || !C45720aj.m84478g(this.jdu.jjM)) {
            AppMethodBeat.m2505o(123585);
            return false;
        }
        AppMethodBeat.m2505o(123585);
        return true;
    }

    public final int aQs() {
        AppMethodBeat.m2504i(123586);
        if (this.jdu == null || this.jdu.jjJ == null) {
            AppMethodBeat.m2505o(123586);
            return 0;
        }
        int intValue = this.jdu.jjJ.intValue();
        AppMethodBeat.m2505o(123586);
        return intValue;
    }

    /* Access modifiers changed, original: final */
    public final Rect aQm() {
        AppMethodBeat.m2504i(123587);
        Rect rect = new Rect(this.jdu.jjs.intValue(), this.jdu.jjr.intValue(), this.jdu.jjs.intValue() + this.jdu.jjp.intValue(), this.jdu.jjr.intValue() + this.jdu.jjq.intValue());
        AppMethodBeat.m2505o(123587);
        return rect;
    }

    /* renamed from: b */
    public final C11017h mo35105b(C11017h c11017h) {
        AppMethodBeat.m2504i(123588);
        if (this.jdu == null) {
            this.jdu = c11017h;
            if (C45720aj.m84478g(c11017h.jjU) && this.jds != null) {
                this.jds.setPasswordMode(true);
            }
        } else {
            this.jdu.mo6559a(c11017h);
        }
        if (this.jds == null) {
            AppMethodBeat.m2505o(123588);
            return null;
        }
        C27407b.m43487a(this.jds, this.jdu);
        C11017h c11017h2 = this.jdu;
        AppMethodBeat.m2505o(123588);
        return c11017h2;
    }

    /* renamed from: EG */
    public final boolean mo35095EG(String str) {
        AppMethodBeat.m2504i(123589);
        if (this.jds == null) {
            AppMethodBeat.m2505o(123589);
            return false;
        }
        this.jds.mo6562B(str);
        AppMethodBeat.m2505o(123589);
        return true;
    }

    /* renamed from: dr */
    public final boolean mo35128dr(int i, int i2) {
        AppMethodBeat.m2504i(123590);
        if (this.jds == null) {
            AppMethodBeat.m2505o(123590);
            return false;
        }
        this.jdt = C46899v.m89264cM(((C44709u) this.jdm.get()).getContentView());
        if (this.jdt == null) {
            AppMethodBeat.m2505o(123590);
            return false;
        }
        this.jdw = true;
        C44709u c44709u = (C44709u) this.jdm.get();
        if (!(c44709u == null || c44709u.aJz() == null)) {
            C19875h.aQx().mo35113c(c44709u.aJz());
        }
        this.jdt.setXMode(this.jdr);
        C46899v c46899v = this.jdt;
        EditText editText = this.jds;
        if (editText != null) {
            if (c46899v.f18290tc != editText) {
                c46899v.aQW();
            }
            c46899v.setInputEditText(editText);
            c46899v.setVisibility(0);
        }
        this.jdt.setOnDoneListener(new C457241());
        mo35106dq(i, i2);
        C33627k.m54902a(this.jdm).mo45142qA(this.jdk);
        this.jdw = false;
        AppMethodBeat.m2505o(123590);
        return true;
    }

    public final boolean aQt() {
        AppMethodBeat.m2504i(123591);
        if (aQu() == null) {
            AppMethodBeat.m2505o(123591);
            return false;
        } else if (isFocused()) {
            C46899v c46899v = this.jdt;
            c46899v.setVisibility(8);
            c46899v.aQW();
            C4990ab.m7411d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] disableInputFocus %s", this.jds);
            if (this.jds != null) {
                this.jds.setFocusable(false);
                this.jds.setFocusableInTouchMode(false);
                this.jds.setEnabled(false);
            }
            C44709u c44709u = (C44709u) this.jdm.get();
            if (!(c44709u == null || c44709u.aJz() == null)) {
                C19875h.aQx().mo35114d(c44709u.aJz());
            }
            C33627k.m54902a(this.jdm).mo45143qB(this.jdk);
            AppMethodBeat.m2505o(123591);
            return true;
        } else {
            AppMethodBeat.m2505o(123591);
            return false;
        }
    }

    private boolean isFocused() {
        AppMethodBeat.m2504i(123592);
        if (this.jds == null) {
            AppMethodBeat.m2505o(123592);
            return false;
        } else if (this.jds.isFocused()) {
            AppMethodBeat.m2505o(123592);
            return true;
        } else if (aQu() == null) {
            AppMethodBeat.m2505o(123592);
            return false;
        } else if (!aQu().isShown()) {
            AppMethodBeat.m2505o(123592);
            return false;
        } else if (this.jdt.getAttachedEditText() == this.jds) {
            AppMethodBeat.m2505o(123592);
            return true;
        } else {
            AppMethodBeat.m2505o(123592);
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: fb */
    public final boolean mo35107fb(boolean z) {
        AppMethodBeat.m2504i(123593);
        C4990ab.m7411d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] onFocusChanged hasFocus %b, isFocused %b", Boolean.valueOf(z), Boolean.valueOf(isFocused()));
        if (z) {
            if (this.jdw) {
                AppMethodBeat.m2505o(123593);
            } else if (isFocused()) {
                AppMethodBeat.m2505o(123593);
            } else {
                this.jdw = true;
                mo35128dr(-2, -2);
                this.jdw = false;
                AppMethodBeat.m2505o(123593);
            }
        } else if (this.jdv) {
            AppMethodBeat.m2505o(123593);
        } else if (isFocused()) {
            this.jdv = true;
            mo35096a(awM());
            aQt();
            aQp();
            this.jdv = false;
            this.jds = null;
            AppMethodBeat.m2505o(123593);
        } else {
            AppMethodBeat.m2505o(123593);
        }
        return true;
    }

    private C46899v aQu() {
        AppMethodBeat.m2504i(123594);
        C46899v c46899v;
        if (this.jdt != null) {
            c46899v = this.jdt;
            AppMethodBeat.m2505o(123594);
            return c46899v;
        }
        c46899v = (C46899v) this.jds.getInputPanel();
        this.jdt = c46899v;
        AppMethodBeat.m2505o(123594);
        return c46899v;
    }

    /* Access modifiers changed, original: final|bridge|synthetic */
    public final /* bridge */ /* synthetic */ EditText aQl() {
        return this.jds;
    }
}
