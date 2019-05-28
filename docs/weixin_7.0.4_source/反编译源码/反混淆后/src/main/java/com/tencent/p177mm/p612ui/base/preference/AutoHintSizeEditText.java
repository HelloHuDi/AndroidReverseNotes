package com.tencent.p177mm.p612ui.base.preference;

import android.content.Context;
import android.graphics.Paint;
import android.support.p057v4.widget.C8415j;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.base.preference.AutoHintSizeEditText */
public class AutoHintSizeEditText extends EditText {
    private float yBi;
    private Paint yBj;
    private String yBk = "";
    private int yBl = C8415j.INVALID_ID;
    private float yBm;

    /* renamed from: com.tencent.mm.ui.base.preference.AutoHintSizeEditText$1 */
    class C236301 implements TextWatcher {
        C236301() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(107123);
            AutoHintSizeEditText.m36477a(AutoHintSizeEditText.this, editable, AutoHintSizeEditText.this.getHint(), (AutoHintSizeEditText.this.getWidth() - AutoHintSizeEditText.this.getPaddingLeft()) - AutoHintSizeEditText.this.getPaddingRight());
            AppMethodBeat.m2505o(107123);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m36477a(AutoHintSizeEditText autoHintSizeEditText, Editable editable, CharSequence charSequence, int i) {
        AppMethodBeat.m2504i(107129);
        autoHintSizeEditText.m36476a(editable, charSequence, i);
        AppMethodBeat.m2505o(107129);
    }

    public AutoHintSizeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(107124);
        init();
        AppMethodBeat.m2505o(107124);
    }

    public AutoHintSizeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(107125);
        init();
        AppMethodBeat.m2505o(107125);
    }

    private void init() {
        AppMethodBeat.m2504i(107126);
        this.yBi = getTextSize();
        this.yBm = this.yBi;
        this.yBj = new Paint(getPaint());
        addTextChangedListener(new C236301());
        AppMethodBeat.m2505o(107126);
    }

    /* renamed from: a */
    private void m36476a(Editable editable, CharSequence charSequence, int i) {
        AppMethodBeat.m2504i(107127);
        if (editable != null && !C5046bo.isNullOrNil(editable.toString())) {
            if (getTextSize() != this.yBi) {
                C4990ab.m7419v("MicroMsg.AutoHintSizeEdittext", "content not null, reset text size %f", Float.valueOf(this.yBi));
                setTextSize(0, this.yBi);
            }
            AppMethodBeat.m2505o(107127);
        } else if (charSequence == null || C5046bo.isNullOrNil(charSequence.toString())) {
            if (getTextSize() != this.yBi) {
                C4990ab.m7419v("MicroMsg.AutoHintSizeEdittext", "hint is null, reset text size %f", Float.valueOf(this.yBi));
                setTextSize(0, this.yBi);
            }
            AppMethodBeat.m2505o(107127);
        } else {
            String charSequence2 = charSequence.toString();
            if (this.yBk.equals(charSequence2) && this.yBl == i) {
                if (getTextSize() != this.yBm) {
                    C4990ab.m7419v("MicroMsg.AutoHintSizeEdittext", "use last hint text size %f", Float.valueOf(this.yBm));
                    setTextSize(0, this.yBm);
                }
                AppMethodBeat.m2505o(107127);
                return;
            }
            this.yBk = charSequence2;
            this.yBl = i;
            if (getPaint().measureText(charSequence2) > ((float) i)) {
                int dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f10018nk);
                int fromDPToPix = C1338a.fromDPToPix(getContext(), 1);
                for (int i2 = ((int) this.yBi) - fromDPToPix; i2 > dimensionPixelSize; i2 -= fromDPToPix) {
                    this.yBj.setTextSize((float) i2);
                    if (this.yBj.measureText(charSequence2) < ((float) i)) {
                        C4990ab.m7419v("MicroMsg.AutoHintSizeEdittext", "get new hint text size %d", Integer.valueOf(i2));
                        this.yBm = (float) i2;
                        setTextSize(0, (float) i2);
                        AppMethodBeat.m2505o(107127);
                        return;
                    }
                }
            }
            AppMethodBeat.m2505o(107127);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(107128);
        C4990ab.m7411d("MicroMsg.AutoHintSizeEdittext", "on layout, changed %B", Boolean.valueOf(z));
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            m36476a(getText(), getHint(), ((i3 - i) - getPaddingLeft()) - getPaddingRight());
        }
        AppMethodBeat.m2505o(107128);
    }
}
