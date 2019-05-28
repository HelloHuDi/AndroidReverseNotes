package com.tencent.p177mm.plugin.appbrand.game.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p211cb.C37626b;
import com.tencent.p177mm.plugin.appbrand.widget.input.C2583z;
import com.tencent.p177mm.plugin.appbrand.widget.input.p762c.C45723b;
import com.tencent.p177mm.pointers.PInt;

@SuppressLint({"AppCompatCustomView"})
/* renamed from: com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText */
public class WAGamePanelInputEditText extends EditText {
    private final Factory huA;
    private final C2583z hux;
    private final InputFilter huy;
    private int huz;

    /* renamed from: com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText$1 */
    class C21651 extends Editable.Factory {
        C21651() {
        }

        public final Editable newEditable(CharSequence charSequence) {
            AppMethodBeat.m2504i(130355);
            Editable c = WAGamePanelInputEditText.this.hux.mo6631c((Editable) WAGamePanelInputEditText.m4384a(WAGamePanelInputEditText.this, super.newEditable(charSequence)));
            AppMethodBeat.m2505o(130355);
            return c;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText$2 */
    class C21662 implements InputFilter {
        C21662() {
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            Spannable spannable;
            AppMethodBeat.m2504i(130356);
            CharSequence subSequence = charSequence.subSequence(i, i2);
            if (subSequence instanceof Spannable) {
                spannable = (Spannable) subSequence;
            } else {
                Object spannable2 = new SpannableStringBuilder(subSequence);
            }
            spannable2 = WAGamePanelInputEditText.m4384a(WAGamePanelInputEditText.this, spannable2);
            AppMethodBeat.m2505o(130356);
            return spannable2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText$3 */
    class C21673 extends Factory {
        C21673() {
        }

        public final Spannable newSpannable(CharSequence charSequence) {
            AppMethodBeat.m2504i(130357);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            AppMethodBeat.m2505o(130357);
            return spannableStringBuilder;
        }
    }

    public WAGamePanelInputEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C25738R.attr.f5703g8);
    }

    public WAGamePanelInputEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(130358);
        this.huy = new C21662();
        this.huz = BaseClientBuilder.API_PRIORITY_OTHER;
        this.huA = new C21673();
        this.hux = new C2583z(this);
        super.setEditableFactory(new C21651());
        AppMethodBeat.m2505o(130358);
    }

    public void setComposingDismissedListener(C45723b c45723b) {
        this.hux.jgz = c45723b;
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        int i = 0;
        AppMethodBeat.m2504i(130359);
        if (this.huy != null) {
            if (inputFilterArr == null) {
                inputFilterArr = new InputFilter[0];
            }
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
            while (i < inputFilterArr.length) {
                inputFilterArr2[i] = inputFilterArr[i];
                i++;
            }
            inputFilterArr2[i] = this.huy;
            inputFilterArr = inputFilterArr2;
        }
        super.setFilters(inputFilterArr);
        AppMethodBeat.m2505o(130359);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        AppMethodBeat.m2504i(130360);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        editorInfo.imeOptions |= 268435456;
        AppMethodBeat.m2505o(130360);
        return onCreateInputConnection;
    }

    public void setMaxLength(int i) {
        this.huz = i;
    }

    public int getMaxLength() {
        return this.huz;
    }

    /* renamed from: a */
    static /* synthetic */ Spannable m4384a(WAGamePanelInputEditText wAGamePanelInputEditText, Spannable spannable) {
        AppMethodBeat.m2504i(130361);
        PInt pInt = new PInt();
        pInt.value = wAGamePanelInputEditText.huz;
        C37626b dqD = C37626b.dqD();
        wAGamePanelInputEditText.getContext();
        Spannable a = dqD.mo60448a(spannable, Math.round(wAGamePanelInputEditText.getTextSize()), pInt, wAGamePanelInputEditText.huA);
        AppMethodBeat.m2505o(130361);
        return a;
    }
}
