package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.Paint;
import android.support.v4.widget.j;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class AutoHintSizeEditText extends EditText {
    private float yBi;
    private Paint yBj;
    private String yBk = "";
    private int yBl = j.INVALID_ID;
    private float yBm;

    static /* synthetic */ void a(AutoHintSizeEditText autoHintSizeEditText, Editable editable, CharSequence charSequence, int i) {
        AppMethodBeat.i(107129);
        autoHintSizeEditText.a(editable, charSequence, i);
        AppMethodBeat.o(107129);
    }

    public AutoHintSizeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107124);
        init();
        AppMethodBeat.o(107124);
    }

    public AutoHintSizeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(107125);
        init();
        AppMethodBeat.o(107125);
    }

    private void init() {
        AppMethodBeat.i(107126);
        this.yBi = getTextSize();
        this.yBm = this.yBi;
        this.yBj = new Paint(getPaint());
        addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(107123);
                AutoHintSizeEditText.a(AutoHintSizeEditText.this, editable, AutoHintSizeEditText.this.getHint(), (AutoHintSizeEditText.this.getWidth() - AutoHintSizeEditText.this.getPaddingLeft()) - AutoHintSizeEditText.this.getPaddingRight());
                AppMethodBeat.o(107123);
            }
        });
        AppMethodBeat.o(107126);
    }

    private void a(Editable editable, CharSequence charSequence, int i) {
        AppMethodBeat.i(107127);
        if (editable != null && !bo.isNullOrNil(editable.toString())) {
            if (getTextSize() != this.yBi) {
                ab.v("MicroMsg.AutoHintSizeEdittext", "content not null, reset text size %f", Float.valueOf(this.yBi));
                setTextSize(0, this.yBi);
            }
            AppMethodBeat.o(107127);
        } else if (charSequence == null || bo.isNullOrNil(charSequence.toString())) {
            if (getTextSize() != this.yBi) {
                ab.v("MicroMsg.AutoHintSizeEdittext", "hint is null, reset text size %f", Float.valueOf(this.yBi));
                setTextSize(0, this.yBi);
            }
            AppMethodBeat.o(107127);
        } else {
            String charSequence2 = charSequence.toString();
            if (this.yBk.equals(charSequence2) && this.yBl == i) {
                if (getTextSize() != this.yBm) {
                    ab.v("MicroMsg.AutoHintSizeEdittext", "use last hint text size %f", Float.valueOf(this.yBm));
                    setTextSize(0, this.yBm);
                }
                AppMethodBeat.o(107127);
                return;
            }
            this.yBk = charSequence2;
            this.yBl = i;
            if (getPaint().measureText(charSequence2) > ((float) i)) {
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.nk);
                int fromDPToPix = a.fromDPToPix(getContext(), 1);
                for (int i2 = ((int) this.yBi) - fromDPToPix; i2 > dimensionPixelSize; i2 -= fromDPToPix) {
                    this.yBj.setTextSize((float) i2);
                    if (this.yBj.measureText(charSequence2) < ((float) i)) {
                        ab.v("MicroMsg.AutoHintSizeEdittext", "get new hint text size %d", Integer.valueOf(i2));
                        this.yBm = (float) i2;
                        setTextSize(0, (float) i2);
                        AppMethodBeat.o(107127);
                        return;
                    }
                }
            }
            AppMethodBeat.o(107127);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(107128);
        ab.d("MicroMsg.AutoHintSizeEdittext", "on layout, changed %B", Boolean.valueOf(z));
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            a(getText(), getHint(), ((i3 - i) - getPaddingLeft()) - getPaddingRight());
        }
        AppMethodBeat.o(107128);
    }
}
