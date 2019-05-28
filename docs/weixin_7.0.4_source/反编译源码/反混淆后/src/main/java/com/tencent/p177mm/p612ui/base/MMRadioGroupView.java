package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.LinearLayout;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.MMRadioImageButton.C30371a;

/* renamed from: com.tencent.mm.ui.base.MMRadioGroupView */
public class MMRadioGroupView extends LinearLayout {
    private int ywN = -1;
    private int ywO = -1;
    private C30371a ywP = new C36059a();
    private C36058b ywQ;
    private C36057c ywR = new C36057c(this, (byte) 0);
    private MMRadioImageButton ywS;
    private C36060d ywT;

    /* renamed from: com.tencent.mm.ui.base.MMRadioGroupView$c */
    class C36057c implements OnHierarchyChangeListener {
        /* renamed from: pD */
        private OnHierarchyChangeListener f15083pD;

        private C36057c() {
        }

        /* synthetic */ C36057c(MMRadioGroupView mMRadioGroupView, byte b) {
            this();
        }

        public final void onChildViewAdded(View view, View view2) {
            AppMethodBeat.m2504i(106749);
            if (view == MMRadioGroupView.this && (view2 instanceof MMRadioImageButton)) {
                if (view2.getId() == -1) {
                    int hashCode = view2.hashCode();
                    if (hashCode < 0) {
                        hashCode &= BaseClientBuilder.API_PRIORITY_OTHER;
                    }
                    view2.setId(hashCode);
                }
                ((MMRadioImageButton) view2).setOnOtherMMRadioButtonCheckedChangeListener(MMRadioGroupView.this.ywP);
            }
            if (this.f15083pD != null) {
                this.f15083pD.onChildViewAdded(view, view2);
            }
            AppMethodBeat.m2505o(106749);
        }

        public final void onChildViewRemoved(View view, View view2) {
            AppMethodBeat.m2504i(106750);
            if (view == MMRadioGroupView.this && (view2 instanceof MMRadioImageButton)) {
                ((MMRadioImageButton) view2).setOnOtherMMRadioButtonCheckedChangeListener(null);
            }
            if (this.f15083pD != null) {
                this.f15083pD.onChildViewRemoved(view, view2);
            }
            AppMethodBeat.m2505o(106750);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMRadioGroupView$b */
    public interface C36058b {
    }

    /* renamed from: com.tencent.mm.ui.base.MMRadioGroupView$a */
    class C36059a implements C30371a {
        C36059a() {
        }

        /* renamed from: a */
        public final void mo48738a(MMRadioImageButton mMRadioImageButton) {
            AppMethodBeat.m2504i(106747);
            if (MMRadioGroupView.this.ywN != -1) {
                MMRadioGroupView.m59352a(MMRadioGroupView.this, MMRadioGroupView.this.ywN);
            }
            int id = mMRadioImageButton.getId();
            MMRadioGroupView.m59353a(MMRadioGroupView.this, mMRadioImageButton);
            MMRadioGroupView.m59356b(MMRadioGroupView.this, id);
            AppMethodBeat.m2505o(106747);
        }

        /* renamed from: b */
        public final void mo48739b(MMRadioImageButton mMRadioImageButton) {
            AppMethodBeat.m2504i(106748);
            MMRadioGroupView.m59357c(MMRadioGroupView.this, mMRadioImageButton.getId());
            AppMethodBeat.m2505o(106748);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMRadioGroupView$d */
    public interface C36060d {
        /* renamed from: NJ */
        void mo31131NJ(int i);
    }

    /* renamed from: b */
    static /* synthetic */ void m59356b(MMRadioGroupView mMRadioGroupView, int i) {
        AppMethodBeat.m2504i(106758);
        mMRadioGroupView.setCheckedId(i);
        AppMethodBeat.m2505o(106758);
    }

    /* renamed from: c */
    static /* synthetic */ void m59357c(MMRadioGroupView mMRadioGroupView, int i) {
        AppMethodBeat.m2504i(106759);
        mMRadioGroupView.setClickedId(i);
        AppMethodBeat.m2505o(106759);
    }

    public MMRadioGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106751);
        super.setOnHierarchyChangeListener(this.ywR);
        AppMethodBeat.m2505o(106751);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(106752);
        super.onFinishInflate();
        if (this.ywN != -1) {
            m59354aD(this.ywN, true);
            setCheckedId(this.ywN);
        }
        AppMethodBeat.m2505o(106752);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        AppMethodBeat.m2504i(106753);
        if (view instanceof MMRadioImageButton) {
            MMRadioImageButton mMRadioImageButton = (MMRadioImageButton) view;
            if (mMRadioImageButton.isChecked()) {
                if (this.ywN != -1) {
                    m59354aD(this.ywN, false);
                }
                setCheckedId(mMRadioImageButton.getId());
                setCheckedButton(mMRadioImageButton);
            }
        }
        super.addView(view, i, layoutParams);
        AppMethodBeat.m2505o(106753);
    }

    /* renamed from: aD */
    private void m59354aD(int i, boolean z) {
        AppMethodBeat.m2504i(106754);
        View findViewById = findViewById(i);
        if (findViewById != null && (findViewById instanceof MMRadioImageButton)) {
            ((MMRadioImageButton) findViewById).setChecked(z);
        }
        AppMethodBeat.m2505o(106754);
    }

    private void setCheckedId(int i) {
        this.ywN = i;
    }

    private void setClickedId(int i) {
        this.ywO = i;
    }

    private void setCheckedButton(MMRadioImageButton mMRadioImageButton) {
        this.ywS = mMRadioImageButton;
    }

    public void setOnMMRadioGroupCheckedChangeListener(C36058b c36058b) {
        this.ywQ = c36058b;
    }

    public int getCheckedRadioButtonId() {
        return this.ywN;
    }

    public int getClickedRadioButtonId() {
        return this.ywO;
    }

    public MMRadioImageButton getCheckedRadioButton() {
        return this.ywS;
    }

    public void setOnSizeChangeObserver(C36060d c36060d) {
        this.ywT = c36060d;
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(106755);
        super.onSizeChanged(i, i2, i3, i4);
        if ((i > 0 || i2 > 0) && this.ywT != null) {
            this.ywT.mo31131NJ(i);
        }
        AppMethodBeat.m2505o(106755);
    }
}
