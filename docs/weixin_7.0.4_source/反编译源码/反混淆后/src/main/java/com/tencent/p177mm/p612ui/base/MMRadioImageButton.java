package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.base.MMRadioImageButton */
public class MMRadioImageButton extends ImageButton implements Checkable {
    /* renamed from: lB */
    private boolean f13739lB;
    /* renamed from: nG */
    private boolean f13740nG;
    private boolean ywV;
    private C30371a ywW;
    private C30371a ywX;

    /* renamed from: com.tencent.mm.ui.base.MMRadioImageButton$a */
    public interface C30371a {
        /* renamed from: a */
        void mo48738a(MMRadioImageButton mMRadioImageButton);

        /* renamed from: b */
        void mo48739b(MMRadioImageButton mMRadioImageButton);
    }

    public MMRadioImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMRadioImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13739lB = true;
    }

    public boolean performClick() {
        AppMethodBeat.m2504i(106761);
        toggle();
        AppMethodBeat.m2505o(106761);
        return false;
    }

    public boolean isChecked() {
        return this.f13740nG;
    }

    public void setChecked(boolean z) {
        AppMethodBeat.m2504i(106762);
        if (this.f13740nG != z) {
            this.f13740nG = z;
            setSelected(this.f13740nG);
            refreshDrawableState();
            if (this.ywV) {
                AppMethodBeat.m2505o(106762);
                return;
            }
            this.ywV = true;
            if (this.ywW != null) {
                this.ywW.mo48738a(this);
            }
            if (this.ywX != null) {
                this.ywX.mo48738a(this);
            }
            this.ywV = false;
        }
        AppMethodBeat.m2505o(106762);
    }

    public void setCheckable(boolean z) {
        this.f13739lB = z;
    }

    public void setOnMMRadioButtonCheckedChangeListener(C30371a c30371a) {
        this.ywW = c30371a;
    }

    public void setOnOtherMMRadioButtonCheckedChangeListener(C30371a c30371a) {
        this.ywX = c30371a;
    }

    public void toggle() {
        AppMethodBeat.m2504i(106760);
        if (!this.f13739lB) {
            if (this.ywW != null) {
                this.ywW.mo48739b(this);
            }
            if (this.ywX != null) {
                this.ywX.mo48739b(this);
            }
        } else if (!isChecked()) {
            setChecked(!this.f13740nG);
            AppMethodBeat.m2505o(106760);
            return;
        }
        AppMethodBeat.m2505o(106760);
    }
}
