package com.tencent.p177mm.plugin.appbrand.widget.input.autofill;

import android.support.p057v4.widget.C8415j;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Filter.FilterListener;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p336ui.C42696n;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38595ab;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38595ab.C11008c;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38595ab.C27398a;
import com.tencent.p177mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.C2564a;
import com.tencent.p177mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.C2565c;
import com.tencent.p177mm.plugin.appbrand.widget.input.autofill.C33622h.C27406a;
import com.tencent.p177mm.plugin.appbrand.widget.input.autofill.C45722c.C385982;
import com.tencent.p177mm.plugin.appbrand.widget.input.p341d.C33623a.C11016b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.b */
public final class C42736b {
    final C38595ab jhB;
    public final C33621e jhC;
    private final FilterListener jhD;
    public final C45722c jhE;
    private final C36740a jhF;
    private C11014f jhG = C11014f.VIEW;
    public C42732a jhH;
    private int jhI;
    private int jhJ;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.b$6 */
    class C198646 extends C36740a {
        C198646() {
            super();
        }

        /* renamed from: a */
        public final void mo35093a(String str, C27406a c27406a) {
            AppMethodBeat.m2504i(123887);
            if (c27406a == C27406a.DELETE) {
                C42736b.this.mo68178E(C42736b.this.jhB.getText());
            }
            super.mo35093a(str, c27406a);
            AppMethodBeat.m2505o(123887);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.b$5 */
    class C274035 implements FilterListener {
        C274035() {
        }

        public final void onFilterComplete(int i) {
            AppMethodBeat.m2504i(123886);
            if (i <= 0) {
                C42736b.this.jhC.dismiss();
                AppMethodBeat.m2505o(123886);
                return;
            }
            if (C42736b.this.jhC.amH.isShowing()) {
                C42736b.this.jhC.show();
            }
            AppMethodBeat.m2505o(123886);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.b$a */
    static class C36740a implements C33622h {
        C33622h jhN;

        private C36740a() {
        }

        /* synthetic */ C36740a(byte b) {
            this();
        }

        /* renamed from: a */
        public void mo35093a(String str, C27406a c27406a) {
            AppMethodBeat.m2504i(123889);
            if (this.jhN != null) {
                this.jhN.mo35093a(str, c27406a);
            }
            AppMethodBeat.m2505o(123889);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.b$2 */
    class C385972 implements C11008c {
        C385972() {
        }

        public final void aQS() {
            AppMethodBeat.m2504i(123882);
            C42736b.this.aRv();
            AppMethodBeat.m2505o(123882);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.b$3 */
    class C427343 implements OnFocusChangeListener {
        C427343() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(123883);
            if (z) {
                C42736b.this.aRw();
                AppMethodBeat.m2505o(123883);
                return;
            }
            C42736b c42736b = C42736b.this;
            if (c42736b.jhC.amH.isShowing()) {
                C27405g c27405g = (C27405g) c42736b.jhC.jhV.getAdapter();
                c42736b.jhC.dismiss();
                c27405g.aRu();
            }
            AppMethodBeat.m2505o(123883);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.b$4 */
    class C427354 implements TextWatcher {
        private boolean jhL = false;

        C427354() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(123884);
            this.jhL = C42736b.this.jhC.amH.isShowing();
            AppMethodBeat.m2505o(123884);
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(123885);
            if (!this.jhL || C42736b.this.jhC.amH.isShowing()) {
                if (!C42736b.this.jhC.amH.isShowing()) {
                    C42736b.this.aRw();
                }
                C42736b.this.mo68178E(editable);
                AppMethodBeat.m2505o(123885);
                return;
            }
            AppMethodBeat.m2505o(123885);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.b$1 */
    class C427371 implements C27398a {
        C427371() {
        }

        /* renamed from: gY */
        public final void mo45133gY() {
            AppMethodBeat.m2504i(123881);
            C42736b.this.aRv();
            AppMethodBeat.m2505o(123881);
        }
    }

    public C42736b(C38595ab c38595ab) {
        AppMethodBeat.m2504i(123890);
        this.jhB = c38595ab;
        this.jhC = new C33621e(c38595ab.getContext());
        this.jhE = new C45722c(c38595ab, this.jhC);
        this.jhB.mo6565a(new C427371());
        this.jhB.mo6566a(new C385972());
        this.jhB.mo6564a(new C427343());
        this.jhB.addTextChangedListener(new C427354());
        this.jhD = new C274035();
        this.jhF = new C198646();
        AppMethodBeat.m2505o(123890);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: E */
    public final void mo68178E(CharSequence charSequence) {
        AppMethodBeat.m2504i(123891);
        if (this.jhH == null) {
            AppMethodBeat.m2505o(123891);
            return;
        }
        this.jhH.getFilter().filter(charSequence, this.jhD);
        AppMethodBeat.m2505o(123891);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: s */
    public final void mo68183s(ArrayList<C11016b> arrayList) {
        AppMethodBeat.m2504i(123892);
        this.jhH = new C42732a(this.jhB.getContext(), arrayList);
        this.jhH.jhu = this.jhF;
        C33621e c33621e = this.jhC;
        C42732a c42732a = this.jhH;
        if (c33621e.mObserver == null) {
            c33621e.mObserver = new C2565c(c33621e, (byte) 0);
        } else if (c33621e.f1259Ei != null) {
            c33621e.f1259Ei.unregisterDataSetObserver(c33621e.mObserver);
        }
        c33621e.f1259Ei = c42732a;
        if (c33621e.f1259Ei != null) {
            c42732a.registerDataSetObserver(c33621e.mObserver);
        }
        if (c33621e.jhV != null) {
            c33621e.jhV.setAdapter(c33621e.f1259Ei);
        }
        AppMethodBeat.m2505o(123892);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo68180a(C33622h c33622h) {
        this.jhF.jhN = c33622h;
    }

    /* Access modifiers changed, original: final */
    public final void aRv() {
        AppMethodBeat.m2504i(123893);
        switch (this.jhG) {
            case SCREEN:
                this.jhC.age = C42696n.aMw()[0];
                break;
            case VIEW:
                this.jhC.age = this.jhB.getView().getMeasuredWidth();
                break;
        }
        if (this.jhI != 0) {
            this.jhC.amm = this.jhI;
            this.jhC.age -= this.jhI;
        }
        if (this.jhJ != 0) {
            this.jhC.age -= this.jhJ;
        }
        AppMethodBeat.m2505o(123893);
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        AppMethodBeat.m2504i(123894);
        this.jhC.setOnDismissListener(onDismissListener);
        AppMethodBeat.m2505o(123894);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo68179a(C11014f c11014f) {
        AppMethodBeat.m2504i(123895);
        if (c11014f != null) {
            this.jhG = c11014f;
        }
        aRv();
        AppMethodBeat.m2505o(123895);
    }

    /* Access modifiers changed, original: final */
    public final void aRw() {
        AppMethodBeat.m2504i(123896);
        if (this.jhH == null) {
            AppMethodBeat.m2505o(123896);
            return;
        }
        CharSequence text = this.jhB.getText();
        if (!C5046bo.m7519ac(text)) {
            mo68178E(text);
        }
        this.jhC.amx = this.jhB.getView();
        this.jhC.show();
        ((C27405g) this.jhC.jhV.getAdapter()).mo45140a(this);
        C45722c c45722c = this.jhE;
        c45722c.mo73520qM(2);
        c45722c.jhQ = C8415j.INVALID_ID;
        if (!C5046bo.m7519ac(text)) {
            c45722c.jhR = true;
        }
        C2564a c2564a = c45722c.jhC.jhV;
        if (c2564a != null) {
            c2564a.getAdapter().registerDataSetObserver(new C385982());
        }
        AppMethodBeat.m2505o(123896);
    }
}
