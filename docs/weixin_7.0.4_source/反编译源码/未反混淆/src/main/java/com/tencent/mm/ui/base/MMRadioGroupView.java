package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.LinearLayout;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMRadioGroupView extends LinearLayout {
    private int ywN = -1;
    private int ywO = -1;
    private com.tencent.mm.ui.base.MMRadioImageButton.a ywP = new a();
    private b ywQ;
    private c ywR = new c(this, (byte) 0);
    private MMRadioImageButton ywS;
    private d ywT;

    class c implements OnHierarchyChangeListener {
        private OnHierarchyChangeListener pD;

        private c() {
        }

        /* synthetic */ c(MMRadioGroupView mMRadioGroupView, byte b) {
            this();
        }

        public final void onChildViewAdded(View view, View view2) {
            AppMethodBeat.i(106749);
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
            if (this.pD != null) {
                this.pD.onChildViewAdded(view, view2);
            }
            AppMethodBeat.o(106749);
        }

        public final void onChildViewRemoved(View view, View view2) {
            AppMethodBeat.i(106750);
            if (view == MMRadioGroupView.this && (view2 instanceof MMRadioImageButton)) {
                ((MMRadioImageButton) view2).setOnOtherMMRadioButtonCheckedChangeListener(null);
            }
            if (this.pD != null) {
                this.pD.onChildViewRemoved(view, view2);
            }
            AppMethodBeat.o(106750);
        }
    }

    public interface b {
    }

    class a implements com.tencent.mm.ui.base.MMRadioImageButton.a {
        a() {
        }

        public final void a(MMRadioImageButton mMRadioImageButton) {
            AppMethodBeat.i(106747);
            if (MMRadioGroupView.this.ywN != -1) {
                MMRadioGroupView.a(MMRadioGroupView.this, MMRadioGroupView.this.ywN);
            }
            int id = mMRadioImageButton.getId();
            MMRadioGroupView.a(MMRadioGroupView.this, mMRadioImageButton);
            MMRadioGroupView.b(MMRadioGroupView.this, id);
            AppMethodBeat.o(106747);
        }

        public final void b(MMRadioImageButton mMRadioImageButton) {
            AppMethodBeat.i(106748);
            MMRadioGroupView.c(MMRadioGroupView.this, mMRadioImageButton.getId());
            AppMethodBeat.o(106748);
        }
    }

    public interface d {
        void NJ(int i);
    }

    static /* synthetic */ void b(MMRadioGroupView mMRadioGroupView, int i) {
        AppMethodBeat.i(106758);
        mMRadioGroupView.setCheckedId(i);
        AppMethodBeat.o(106758);
    }

    static /* synthetic */ void c(MMRadioGroupView mMRadioGroupView, int i) {
        AppMethodBeat.i(106759);
        mMRadioGroupView.setClickedId(i);
        AppMethodBeat.o(106759);
    }

    public MMRadioGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106751);
        super.setOnHierarchyChangeListener(this.ywR);
        AppMethodBeat.o(106751);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(106752);
        super.onFinishInflate();
        if (this.ywN != -1) {
            aD(this.ywN, true);
            setCheckedId(this.ywN);
        }
        AppMethodBeat.o(106752);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        AppMethodBeat.i(106753);
        if (view instanceof MMRadioImageButton) {
            MMRadioImageButton mMRadioImageButton = (MMRadioImageButton) view;
            if (mMRadioImageButton.isChecked()) {
                if (this.ywN != -1) {
                    aD(this.ywN, false);
                }
                setCheckedId(mMRadioImageButton.getId());
                setCheckedButton(mMRadioImageButton);
            }
        }
        super.addView(view, i, layoutParams);
        AppMethodBeat.o(106753);
    }

    private void aD(int i, boolean z) {
        AppMethodBeat.i(106754);
        View findViewById = findViewById(i);
        if (findViewById != null && (findViewById instanceof MMRadioImageButton)) {
            ((MMRadioImageButton) findViewById).setChecked(z);
        }
        AppMethodBeat.o(106754);
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

    public void setOnMMRadioGroupCheckedChangeListener(b bVar) {
        this.ywQ = bVar;
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

    public void setOnSizeChangeObserver(d dVar) {
        this.ywT = dVar;
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(106755);
        super.onSizeChanged(i, i2, i3, i4);
        if ((i > 0 || i2 > 0) && this.ywT != null) {
            this.ywT.NJ(i);
        }
        AppMethodBeat.o(106755);
    }
}
