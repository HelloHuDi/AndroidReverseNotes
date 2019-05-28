package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMRadioImageButton extends ImageButton implements Checkable {
    private boolean lB;
    private boolean nG;
    private boolean ywV;
    private a ywW;
    private a ywX;

    public interface a {
        void a(MMRadioImageButton mMRadioImageButton);

        void b(MMRadioImageButton mMRadioImageButton);
    }

    public MMRadioImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMRadioImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lB = true;
    }

    public boolean performClick() {
        AppMethodBeat.i(106761);
        toggle();
        AppMethodBeat.o(106761);
        return false;
    }

    public boolean isChecked() {
        return this.nG;
    }

    public void setChecked(boolean z) {
        AppMethodBeat.i(106762);
        if (this.nG != z) {
            this.nG = z;
            setSelected(this.nG);
            refreshDrawableState();
            if (this.ywV) {
                AppMethodBeat.o(106762);
                return;
            }
            this.ywV = true;
            if (this.ywW != null) {
                this.ywW.a(this);
            }
            if (this.ywX != null) {
                this.ywX.a(this);
            }
            this.ywV = false;
        }
        AppMethodBeat.o(106762);
    }

    public void setCheckable(boolean z) {
        this.lB = z;
    }

    public void setOnMMRadioButtonCheckedChangeListener(a aVar) {
        this.ywW = aVar;
    }

    public void setOnOtherMMRadioButtonCheckedChangeListener(a aVar) {
        this.ywX = aVar;
    }

    public void toggle() {
        AppMethodBeat.i(106760);
        if (!this.lB) {
            if (this.ywW != null) {
                this.ywW.b(this);
            }
            if (this.ywX != null) {
                this.ywX.b(this);
            }
        } else if (!isChecked()) {
            setChecked(!this.nG);
            AppMethodBeat.o(106760);
            return;
        }
        AppMethodBeat.o(106760);
    }
}
