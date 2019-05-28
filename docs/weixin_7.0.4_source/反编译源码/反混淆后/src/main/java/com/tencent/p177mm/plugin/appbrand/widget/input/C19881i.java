package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.os.Looper;
import android.support.p057v4.view.C0477s;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.TextView.OnEditorActionListener;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.statusbar.C5546d;
import com.tencent.p177mm.p612ui.tools.C5584f.C5583a;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c.C5581a;
import com.tencent.p177mm.p612ui.widget.C16003g;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.p336ui.C42696n;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38595ab.C27399b;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38609w.C33634c;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38609w.C33635d;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38609w.C33636e;
import com.tencent.p177mm.plugin.appbrand.widget.input.C42744p.C38603a;
import com.tencent.p177mm.plugin.appbrand.widget.input.autofill.C19866d;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C16712e;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C33624b;
import com.tencent.p177mm.plugin.appbrand.widget.input.p762c.C11015a;
import com.tencent.p177mm.plugin.appbrand.widget.input.p762c.C45723b;
import com.tencent.p177mm.pointers.PBool;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.lang.ref.WeakReference;
import java.util.Locale;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.i */
public abstract class C19881i implements C45718aa<C2577y> {
    public volatile C19884c jdM;
    private volatile C11021a jdN;
    public volatile C11022b jdO;
    final OnFocusChangeListener jdP = new C198931();
    private int jdQ = -1;
    private int jdR = -1;
    C19888d jdS = null;
    public C16712e jdT;
    public int jdU;
    protected WeakReference<C44709u> jdV;
    public C2577y jdW;
    C38609w jdX;
    private C46899v jdY;
    private final Runnable jdZ = new C1988911();
    private final C5581a jdp = new C1987610();
    public final C11015a jea = new C11015a();
    boolean jeb = false;
    final C7306ak jec = new C7306ak(Looper.getMainLooper());
    final Runnable jed = new C1989012();
    private final C33635d jee = new C198825();
    private final C33634c jef = new C110206();
    private final C33636e jkt = new C198837();

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.i$6 */
    class C110206 implements C33634c {
        C110206() {
        }

        /* renamed from: fd */
        public final void mo22677fd(boolean z) {
            AppMethodBeat.m2504i(123632);
            if (z) {
                C19881i.this.jdS = C19888d.CONFIRM_CLICKED;
            }
            C19881i.m30776f(C19881i.this);
            C19881i.this.jdS = null;
            AppMethodBeat.m2505o(123632);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.i$a */
    public interface C11021a {
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.i$b */
    public interface C11022b {
        /* renamed from: a */
        void mo22678a(C45718aa c45718aa, int i);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.i$10 */
    class C1987610 extends C38603a {
        C1987610() {
        }

        /* renamed from: JX */
        public final void mo11316JX() {
            AppMethodBeat.m2504i(123636);
            if (C19881i.this.jdW != null) {
                try {
                    C19881i.this.jea.mo22672a(C19881i.this.jdW.getEditableText(), false);
                    AppMethodBeat.m2505o(123636);
                    return;
                } catch (Exception e) {
                }
            }
            AppMethodBeat.m2505o(123636);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.i$15 */
    class C1987715 implements C27399b {
        C1987715() {
        }

        /* renamed from: qy */
        public final boolean mo35115qy(int i) {
            AppMethodBeat.m2504i(123640);
            if (i != 67) {
                AppMethodBeat.m2505o(123640);
                return false;
            } else if (C45720aj.m84473D(C19881i.this.jdW.getText())) {
                AppMethodBeat.m2505o(123640);
                return false;
            } else {
                C19881i.this.mo21851Ba(C19881i.this.jdW.getText().toString());
                AppMethodBeat.m2505o(123640);
                return true;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.i$16 */
    class C1987816 implements Runnable {
        C1987816() {
        }

        public final void run() {
            AppMethodBeat.m2504i(123641);
            C19881i.this.aQz();
            AppMethodBeat.m2505o(123641);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.i$17 */
    class C1987917 implements OnClickListener {
        C1987917() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(123642);
            if (C19881i.this.jdW == null) {
                AppMethodBeat.m2505o(123642);
            } else if (C19881i.this.jdW.hasFocus()) {
                C19881i.this.aQB();
                AppMethodBeat.m2505o(123642);
            } else {
                if (C19881i.this.jdW == view) {
                    C19881i.this.aQD();
                }
                AppMethodBeat.m2505o(123642);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.i$5 */
    class C198825 implements C33635d {
        C198825() {
        }

        /* renamed from: EH */
        public final boolean mo35131EH(String str) {
            AppMethodBeat.m2504i(123631);
            if (C19881i.this.jdW != null) {
                C2577y c2577y;
                if ("[DELETE_EMOTION]".equalsIgnoreCase(str)) {
                    c2577y = C19881i.this.jdW;
                    if (c2577y.jfF == null) {
                        c2577y.dispatchKeyEvent(new KeyEvent(0, 67));
                        c2577y.dispatchKeyEvent(new KeyEvent(1, 67));
                    } else if (!C5046bo.m7519ac(c2577y.getEditableText())) {
                        c2577y.jfF.deleteSurroundingText(c2577y.getEditableText().length(), c2577y.getEditableText().length() - 1);
                    }
                } else {
                    c2577y = C19881i.this.jdW;
                    C42738f.aQv();
                    if (c2577y.getEditableText() == null) {
                        c2577y.setText(str, BufferType.EDITABLE);
                    } else {
                        c2577y.getEditableText().append(str);
                    }
                    c2577y.setSelection(c2577y.getEditableText().length());
                }
            }
            AppMethodBeat.m2505o(123631);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.i$7 */
    class C198837 implements C33636e {
        C198837() {
        }

        /* renamed from: nS */
        public final void mo35132nS(int i) {
            AppMethodBeat.m2504i(123633);
            C4990ab.m7411d("MicroMsg.AppBrandInputInvokeHandler", "[appInput], onSmileyPanelVisibilityChanged = %d", Integer.valueOf(i));
            if (i != 2) {
                if (i == 0 && C19881i.this.jdW != null) {
                    C19881i.this.jdW.requestFocus();
                }
                C19881i.this.aQH();
                if (!(C19881i.this.jdV == null || C19881i.this.jdV.get() == null)) {
                    C42743o.m75750a((C44709u) C19881i.this.jdV.get(), C19881i.this.jdW);
                    AppMethodBeat.m2505o(123633);
                    return;
                }
            }
            C19881i.this.jdS = C19888d.PANEL_HIDDEN;
            C19881i.m30776f(C19881i.this);
            C19881i.this.jdS = null;
            AppMethodBeat.m2505o(123633);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.i$c */
    public interface C19884c {
        /* renamed from: db */
        void mo35133db(int i, int i2);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.i$8 */
    class C198868 implements OnKeyListener {
        C198868() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            boolean z;
            AppMethodBeat.m2504i(123634);
            C19881i c19881i = C19881i.this;
            if (67 == i) {
                z = true;
            } else {
                z = false;
            }
            c19881i.jeb = z;
            if (C19881i.this.jeb) {
                C19881i.this.jec.removeCallbacks(C19881i.this.jed);
                C19881i.this.jec.postDelayed(C19881i.this.jed, 1000);
            } else {
                C19881i.this.jed.run();
            }
            AppMethodBeat.m2505o(123634);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.i$d */
    enum C19888d {
        PANEL_HIDDEN,
        CONFIRM_CLICKED;

        static {
            AppMethodBeat.m2505o(123645);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.i$11 */
    class C1988911 implements Runnable {
        C1988911() {
        }

        public final void run() {
            AppMethodBeat.m2504i(123637);
            C19881i.this.aQA();
            AppMethodBeat.m2505o(123637);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.i$12 */
    class C1989012 implements Runnable {
        C1989012() {
        }

        public final void run() {
            C19881i.this.jeb = false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.i$13 */
    class C1989113 extends C16003g {
        C1989113() {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(123638);
            if (C19881i.this.jdV == null || C19881i.this.jdV.get() == null || C19881i.this.jdW == null) {
                AppMethodBeat.m2505o(123638);
                return;
            }
            C19881i.this.aQz();
            if (C45720aj.m84473D(editable)) {
                C4990ab.m7411d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] text composing %s", editable);
                AppMethodBeat.m2505o(123638);
                return;
            }
            C4990ab.m7411d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] not composing text %s", editable);
            C19881i.this.jea.mo22672a(C19881i.this.jdW.getEditableText(), C19881i.this.jeb);
            AppMethodBeat.m2505o(123638);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.i$14 */
    class C1989214 implements C45723b {
        C1989214() {
        }

        public final void aAL() {
            AppMethodBeat.m2504i(123639);
            if (C19881i.this.jdW == null) {
                AppMethodBeat.m2505o(123639);
                return;
            }
            C4990ab.m7411d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] onComposingDismissed %s", C19881i.this.jdW.getEditableText());
            C19881i.this.jea.mo22672a(C19881i.this.jdW.getEditableText(), false);
            AppMethodBeat.m2505o(123639);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.i$1 */
    class C198931 implements OnFocusChangeListener {
        C198931() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(123627);
            if (z) {
                C42743o.m75754b((C44709u) C19881i.this.jdV.get(), C19881i.this);
            }
            C19881i.m30770a(C19881i.this, z);
            Object obj = (!z || (C19881i.this.jdT.jjl && !C42696n.m75622ct(C19881i.this.jdW))) ? null : 1;
            if (!(obj == null || C19881i.this.jdW == null || C19881i.this.jdX == null)) {
                C19881i.this.jdW.requestFocus();
                C19881i.this.jdX.show();
            }
            AppMethodBeat.m2505o(123627);
        }
    }

    /* renamed from: Ba */
    public abstract void mo21851Ba(String str);

    public abstract void aDA();

    public abstract void aDB();

    /* renamed from: b */
    public abstract void mo21854b(String str, int i, boolean z, boolean z2);

    /* renamed from: f */
    static /* synthetic */ void m30776f(C19881i c19881i) {
        boolean z = c19881i.jdS == C19888d.CONFIRM_CLICKED && C45720aj.m84478g(c19881i.jdT.jjL);
        if (!z) {
            if (c19881i.aQG() != null) {
                c19881i.jdX.hide();
            } else if (c19881i.jdV != null) {
                C44709u c44709u = (C44709u) c19881i.jdV.get();
                if (c44709u != null) {
                    C2559ad aJw = c44709u.aJw();
                    if (aJw != null) {
                        aJw.aqX();
                    }
                }
            }
            C33627k.m54902a(c19881i.jdV).mo45143qB(c19881i.jdU);
        }
        if (c19881i.jdW != null) {
            if (c19881i.jdW.hasFocus()) {
                c19881i.m30777fc(z);
            }
            if (!z) {
                c19881i.jdW.mo6581b(c19881i.jdP);
                if (c19881i.jdX != null && c19881i.jdX.mo61408b(c19881i.jdW)) {
                    c19881i.jdX.hide();
                }
                c19881i.jdW.setFocusable(false);
                c19881i.jdW.setFocusableInTouchMode(false);
                if (c19881i.jdT.jjl) {
                    c19881i.aQC();
                }
            }
        }
    }

    /* renamed from: s */
    public final boolean mo35110s(C44709u c44709u) {
        return (c44709u == null || this.jdV == null || c44709u != this.jdV.get()) ? false : true;
    }

    public final boolean aQt() {
        boolean z;
        if (this.jdW == null || (!this.jdW.isFocused() && (aQG() == null || aQG().getAttachedEditText() != this.jdW))) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            C38609w aQG = aQG();
            if (aQG != null) {
                aQG.setVisibility(8);
            }
        } else {
            C4990ab.m7410d("MicroMsg.AppBrandInputInvokeHandler", "doHideKeyboard, not focused, return");
        }
        return true;
    }

    /* renamed from: a */
    public final void mo35097a(String str, Integer num) {
        if (this.jdW != null) {
            this.jdW.mo6562B(str);
            Integer valueOf = Integer.valueOf(num == null ? -1 : num.intValue());
            m30774dq(valueOf.intValue(), valueOf.intValue());
            aQz();
        }
    }

    public final boolean aQn() {
        Object obj;
        if (this.jdW == null || this.jdV == null || this.jdV.get() == null) {
            obj = null;
        } else {
            this.jdW.destroy();
            C44719g c44719g = (C44719g) ((C44709u) this.jdV.get()).aAY();
            if (c44719g == null) {
                obj = null;
            } else {
                if (this.jdW.hasFocus()) {
                    if (this.jdY != null) {
                        this.jdY.setVisibility(8);
                    }
                    aQG();
                    if (this.jdX != null) {
                        this.jdX.setVisibility(8);
                    }
                }
                c44719g.mo71786cF(this.jdW);
                int obj2 = 1;
            }
        }
        if (obj2 == null) {
            return false;
        }
        onDestroy();
        return true;
    }

    public final <P extends View & C45719ac> P getInputPanel() {
        return this.jdX;
    }

    public final boolean aQr() {
        return this.jdT != null && C45720aj.m84478g(this.jdT.jjM);
    }

    public final int aQs() {
        if (this.jdT != null && this.jdT.jjJ != null) {
            return this.jdT.jjJ.intValue();
        }
        if (this.jdW == null || !this.jdW.aQP()) {
            return 0;
        }
        return 5;
    }

    private void onDestroy() {
        this.jdW = null;
        C42677e.m75579at(this);
    }

    public final int getInputId() {
        return this.jdU;
    }

    /* renamed from: qx */
    public final void mo35109qx(int i) {
        C11022b c11022b = this.jdO;
        if (c11022b != null) {
            c11022b.mo22678a(this, i);
        }
    }

    public final void aQq() {
        if (this.jdW != null && C45720aj.m84478g(this.jdT.jjH) && C45720aj.m84478g(this.jdT.jjF)) {
            ((C11034q) this.jdW).setAutoHeight(true);
            int lineHeight = this.jdW.getLineHeight();
            int aRh = this.jdW.aRh();
            int intValue = (this.jdT.jjt == null || this.jdT.jjt.intValue() <= 0) ? lineHeight : this.jdT.jjt.intValue();
            lineHeight = (this.jdT.jju == null || this.jdT.jju.intValue() <= 0) ? BaseClientBuilder.API_PRIORITY_OTHER : Math.max(this.jdT.jju.intValue(), lineHeight);
            this.jdW.setMinHeight(intValue);
            this.jdW.setMaxHeight(lineHeight);
            this.jdT.jjq = Integer.valueOf(Math.max(intValue, Math.min(aRh, lineHeight)));
            mo35127b(this.jdW, this.jdT);
        }
    }

    public final void aQy() {
        C27407b.m43487a(this.jdW, this.jdT);
        if (this.jdT.jjy == null) {
            this.jdT.jjy = Integer.valueOf(140);
        } else if (this.jdT.jjy.intValue() <= 0) {
            this.jdT.jjy = Integer.valueOf(BaseClientBuilder.API_PRIORITY_OTHER);
        }
        C7357c PM = C42744p.m75759a(this.jdW).mo15877PM(this.jdT.jjy.intValue());
        PM.zIx = false;
        PM.jeZ = C5583a.MODE_CHINESE_AS_1;
        PM.mo15879a(this.jdp);
        this.jdW.setPasswordMode(this.jdT.jjk);
        if (C45720aj.m84478g(this.jdT.jjD)) {
            this.jdW.setEnabled(false);
            this.jdW.setFocusable(false);
            this.jdW.setFocusableInTouchMode(false);
            this.jdW.setClickable(false);
        } else {
            this.jdW.setEnabled(true);
            this.jdW.setClickable(true);
        }
        if (this.jdW instanceof C11034q) {
            if (this.jdT.jjN != null) {
                ((C11034q) this.jdW).setLineSpace((float) this.jdT.jjN.intValue());
            }
            if (this.jdT.jjO != null) {
                ((C11034q) this.jdW).setLineHeight((float) this.jdT.jjO.intValue());
            }
        }
    }

    /* renamed from: dq */
    private void m30774dq(int i, int i2) {
        C27407b.m43486a(this.jdW, i, i2);
        aQA();
    }

    public final void aQz() {
        if (this.jdW != null) {
            if (this.jdW.getLineCount() != this.jdQ || this.jdW.aRh() != this.jdR) {
                Object obj = this.jdQ == -1 ? 1 : null;
                this.jdQ = this.jdW.getLineCount();
                this.jdR = this.jdW.aRh();
                if (this.jdM != null) {
                    this.jdM.mo35133db(this.jdQ, this.jdR);
                }
                if (this.jdT.jjF.booleanValue() && obj == null) {
                    aQq();
                    aQA();
                }
            }
        }
    }

    private void aQA() {
        if (this.jdT.jjF.booleanValue() && this.jdX != null && this.jdX.isShown() && this.jdW != null && this.jdW == this.jdX.getAttachedEditText()) {
            C33627k.m54902a(this.jdV).mo45142qA(this.jdU);
        }
    }

    private void aQB() {
        if (this.jdT.jjF.booleanValue()) {
            aQG();
        }
        if (this.jdX != null && this.jdW != null) {
            this.jdX.jfW = this.jdW;
            this.jdX.setShowDoneButton(C45720aj.m84478g(this.jdT.jjG));
            aQE();
            if (C42696n.m75622ct(this.jdW) && this.jdW.hasFocus()) {
                this.jdX.show();
            }
        }
    }

    private void aQC() {
        this.jdX.mo61408b(this.jdW);
        mo35119a(this.jdW);
        this.jdW.destroy();
        onDestroy();
    }

    /* renamed from: ds */
    public final void mo35129ds(int i, int i2) {
        this.jdV = this.jdT.jdm;
        C44709u c44709u = this.jdV == null ? null : (C44709u) this.jdV.get();
        if (c44709u == null || c44709u.aJz() == null) {
            C4990ab.m7412e("MicroMsg.AppBrandInputInvokeHandler", "insertInputImpl, view not ready, return fail");
            aDB();
            return;
        }
        C2577y c11034q;
        if (C45720aj.m84478g(this.jdT.jjF)) {
            c11034q = new C11034q(c44709u.mContext);
        } else {
            c11034q = new C31335t(c44709u.mContext);
        }
        this.jdW = c11034q;
        this.jdU = this.jdT.jdk;
        this.jdW.setInputId(this.jdU);
        C42743o.m75754b(c44709u, (C45718aa) this);
        aQy();
        this.jdW.setText(C5046bo.nullAsNil(this.jdT.jjo));
        if (C45720aj.m84478g(this.jdT.jjH)) {
            aQz();
        }
        this.jdW.addTextChangedListener(new C1989113());
        this.jdW.setOnComposingDismissedListener(new C1989214());
        this.jdW.setOnKeyUpPostImeListener(new C1987715());
        if (mo35120a(this.jdW, this.jdT)) {
            if (!(this.jdT.jjn == null || C5046bo.m7548ek(this.jdT.jjn.jiX))) {
                C19866d.m30749a(c44709u, this.jdW, this.jdT.jjn);
            }
            if (!C45720aj.m84478g(this.jdT.jjF)) {
                C27407b.m43486a(this.jdW, i, i2);
            }
            if (C45720aj.m84478g(this.jdT.jjF)) {
                this.jdW.post(new C1987816());
            }
            if ("text".equalsIgnoreCase(this.jdT.jjj) || "emoji".equalsIgnoreCase(this.jdT.jjj)) {
                aQF();
            } else {
                Assert.assertTrue(String.format(Locale.US, "Unrecognized type(%s) implementation removed from here", new Object[]{this.jdT.jjj}), true);
                aQF();
            }
            this.jdW.setOnClickListener(new C1987917());
            aDA();
            return;
        }
        C4990ab.m7412e("MicroMsg.AppBrandInputInvokeHandler", "add custom view into webView failed");
        aDB();
    }

    private void aQD() {
        boolean z;
        boolean z2 = true;
        C44709u c44709u = this.jdV == null ? null : (C44709u) this.jdV.get();
        if (this.jdX == null) {
            aQG();
        }
        String str = "MicroMsg.AppBrandInputInvokeHandler";
        String str2 = "ensureInputFocusedWithSoftKeyboard, null==mInput[%b], null==page[%b], null==mSmileyPanel[%b]";
        Object[] objArr = new Object[3];
        if (this.jdW == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        if (c44709u == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        if (this.jdX != null) {
            z2 = false;
        }
        objArr[2] = Boolean.valueOf(z2);
        C4990ab.m7417i(str, str2, objArr);
        if (c44709u != null && this.jdW != null && this.jdX != null) {
            C42743o.m75750a(c44709u, this.jdW);
            final PBool pBool = new PBool();
            pBool.value = false;
            final C198852 c198852 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(123628);
                    C4990ab.m7416i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, before run checkForInput");
                    pBool.value = true;
                    C44709u c44709u = C19881i.this.jdV == null ? null : (C44709u) C19881i.this.jdV.get();
                    if (c44709u == null || C19881i.this.jdW == null) {
                        AppMethodBeat.m2505o(123628);
                    } else if (C42743o.m75758x(c44709u) != C19881i.this) {
                        AppMethodBeat.m2505o(123628);
                    } else {
                        C4990ab.m7416i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, run checkForInput");
                        C19875h.aQx().mo35113c(c44709u.aJz());
                        C45720aj.m84476cT(C19881i.this.jdW);
                        if (C19881i.this.jdX != null && C19881i.this.jdX.mo61408b(null)) {
                            C19881i.this.jdX.hide();
                        }
                        C19881i.this.jdW.mo6564a(C19881i.this.jdP);
                        C19881i.this.jdW.setFocusable(true);
                        C19881i.this.jdW.setFocusableInTouchMode(true);
                        C19881i.this.jdX.jfW = C19881i.this.jdW;
                        C19881i.this.jdW.requestFocus();
                        C45720aj.m84476cT(C19881i.this.jdW);
                        if (C19881i.this.jdX != null) {
                            C19881i.this.jdX.show();
                        }
                        AppMethodBeat.m2505o(123628);
                    }
                }
            };
            Activity cY = C5546d.m8371cY(c44709u.mContext);
            if (!(cY == null || cY.getCurrentFocus() == null)) {
                View currentFocus = cY.getCurrentFocus();
                boolean isActive = C45720aj.m84475cS(currentFocus).isActive(currentFocus);
                boolean f = C45720aj.m84477f(c44709u.aJz().getWrapperView(), currentFocus);
                if (isActive && f) {
                    C4990ab.m7416i("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, servedConnecting && servedForWebView, delay checkForInput");
                    this.jdX.setOnVisibilityChangedListener(new C33636e() {
                        /* renamed from: nS */
                        public final void mo35132nS(int i) {
                            AppMethodBeat.m2504i(123629);
                            if (pBool.value || i != 2) {
                                AppMethodBeat.m2505o(123629);
                                return;
                            }
                            c198852.run();
                            AppMethodBeat.m2505o(123629);
                        }
                    });
                    C7305d.xDG.mo10160q(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(123630);
                            if (pBool.value) {
                                AppMethodBeat.m2505o(123630);
                                return;
                            }
                            c198852.run();
                            AppMethodBeat.m2505o(123630);
                        }
                    }, 100);
                    return;
                }
            }
            c198852.run();
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public boolean mo35120a(C2577y c2577y, C16712e c16712e) {
        if (c2577y == null || this.jdV == null || this.jdV.get() == null) {
            return false;
        }
        C44719g c44719g = (C44719g) ((C44709u) this.jdV.get()).aAY();
        if (c44719g != null) {
            if (c44719g.mo71784a(((C44709u) this.jdV.get()).aJz(), c2577y, c16712e.jjp.intValue(), c16712e.jjq.intValue(), c16712e.jjs.intValue(), c16712e.jjr.intValue())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public boolean mo35127b(C2577y c2577y, C16712e c16712e) {
        if (c2577y == null || this.jdV == null || this.jdV.get() == null) {
            return false;
        }
        C44719g c44719g = (C44719g) ((C44709u) this.jdV.get()).aAY();
        if (c44719g != null) {
            if (c44719g.mo71785c(((C44709u) this.jdV.get()).aJz(), c2577y, c16712e.jjp.intValue(), c16712e.jjq.intValue(), c16712e.jjs.intValue(), c16712e.jjr.intValue())) {
                return true;
            }
        }
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo35119a(C2577y c2577y) {
        if (c2577y != null) {
            c2577y.mo6581b(this.jdP);
            C44709u c44709u = this.jdV == null ? null : (C44709u) this.jdV.get();
            if (c44709u != null) {
                C44719g c44719g = (C44719g) c44709u.aAY();
                if (c44719g != null) {
                    c44719g.mo71786cF(c2577y);
                }
            }
        }
    }

    private void aQE() {
        if (this.jdX != null) {
            this.jdX.setOnSmileyChosenListener(this.jee);
            this.jdX.setOnDoneListener(this.jef);
            this.jdX.setOnVisibilityChangedListener(this.jkt);
        }
    }

    private void aQF() {
        C44709u c44709u = (C44709u) this.jdV.get();
        if (C0477s.m930av(c44709u.getContentView())) {
            this.jdX = C38609w.m65442cO(c44709u.getContentView());
            if (this.jdT.jjl) {
                aQE();
                aQH();
            }
            this.jdW.mo6564a(this.jdP);
            this.jdW.setOnKeyListener(new C198868());
            if (this.jdT.jjl) {
                C42743o.m75750a((C44709u) this.jdV.get(), this.jdW);
            }
            C38609w c38609w = this.jdX;
            boolean z = !this.jdT.jjk && "emoji".equals(this.jdT.jjj);
            c38609w.setCanSmileyInput(z);
            if (this.jdT.jjF.booleanValue()) {
                this.jdW.setOnEditorActionListener(null);
                this.jdW.setImeOptions(0);
            } else {
                C33624b aRI;
                if (this.jdT.jjK == null) {
                    aRI = C33624b.aRI();
                } else {
                    aRI = this.jdT.jjK;
                }
                final int i = aRI.jjd;
                this.jdW.setImeOptions(i);
                this.jdW.setOnEditorActionListener(new OnEditorActionListener() {
                    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        AppMethodBeat.m2504i(123635);
                        if (i == i) {
                            C19881i.this.jdS = C19888d.CONFIRM_CLICKED;
                            C19881i.m30776f(C19881i.this);
                            C19881i.this.jdS = null;
                            AppMethodBeat.m2505o(123635);
                            return true;
                        }
                        AppMethodBeat.m2505o(123635);
                        return false;
                    }
                });
            }
            this.jdX.setShowDoneButton(this.jdT.jjG.booleanValue());
            this.jdX.jfW = this.jdW;
            if (this.jdT.jjl) {
                aQD();
            } else {
                this.jdW.setFocusable(false);
                this.jdW.setFocusableInTouchMode(false);
                this.jdX.hide();
            }
            if (this.jdT.jjl) {
                C33627k.m54902a(this.jdV).mo45142qA(this.jdU);
            }
        }
    }

    /* renamed from: fc */
    private void m30777fc(boolean z) {
        if (this.jdW != null) {
            mo21854b(this.jdW.getText().toString(), this.jdW.getSelectionEnd(), this.jdS == C19888d.CONFIRM_CLICKED, z);
        }
    }

    private C38609w aQG() {
        if (this.jdX != null) {
            return this.jdX;
        }
        if (this.jdV != null) {
            C44709u c44709u = (C44709u) this.jdV.get();
            if (c44709u != null) {
                C38609w cN = C38609w.m65441cN(c44709u.getContentView());
                this.jdX = cN;
                return cN;
            }
        }
        return null;
    }

    private C46899v aQu() {
        if (this.jdY != null) {
            return this.jdY;
        }
        if (this.jdV != null) {
            C44709u c44709u = (C44709u) this.jdV.get();
            if (c44709u != null) {
                C46899v cL = C46899v.m89263cL(c44709u.getContentView());
                this.jdY = cL;
                return cL;
            }
        }
        return null;
    }

    private void aQH() {
        if (aQu() != null) {
            this.jdY.setVisibility(8);
        }
    }

    /* renamed from: dr */
    public final boolean mo35128dr(int i, int i2) {
        if (!(this.jdW == null || this.jdV == null || this.jdV.get() == null)) {
            this.jdW.performClick();
        }
        m30774dq(i, i2);
        return true;
    }

    public final /* bridge */ /* synthetic */ EditText aQo() {
        return this.jdW;
    }
}
