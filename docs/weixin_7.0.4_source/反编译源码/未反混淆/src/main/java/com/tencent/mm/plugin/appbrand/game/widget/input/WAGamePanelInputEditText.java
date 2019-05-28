package com.tencent.mm.plugin.appbrand.game.widget.input;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.input.c.b;
import com.tencent.mm.plugin.appbrand.widget.input.z;
import com.tencent.mm.pointers.PInt;

@SuppressLint({"AppCompatCustomView"})
public class WAGamePanelInputEditText extends EditText {
    private final Factory huA;
    private final z hux;
    private final InputFilter huy;
    private int huz;

    public WAGamePanelInputEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.g8);
    }

    public WAGamePanelInputEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(130358);
        this.huy = new InputFilter() {
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                Spannable spannable;
                AppMethodBeat.i(130356);
                CharSequence subSequence = charSequence.subSequence(i, i2);
                if (subSequence instanceof Spannable) {
                    spannable = (Spannable) subSequence;
                } else {
                    Object spannable2 = new SpannableStringBuilder(subSequence);
                }
                spannable2 = WAGamePanelInputEditText.a(WAGamePanelInputEditText.this, spannable2);
                AppMethodBeat.o(130356);
                return spannable2;
            }
        };
        this.huz = BaseClientBuilder.API_PRIORITY_OTHER;
        this.huA = new Factory() {
            public final Spannable newSpannable(CharSequence charSequence) {
                AppMethodBeat.i(130357);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
                AppMethodBeat.o(130357);
                return spannableStringBuilder;
            }
        };
        this.hux = new z(this);
        super.setEditableFactory(new Editable.Factory() {
            public final Editable newEditable(CharSequence charSequence) {
                AppMethodBeat.i(130355);
                Editable c = WAGamePanelInputEditText.this.hux.c((Editable) WAGamePanelInputEditText.a(WAGamePanelInputEditText.this, super.newEditable(charSequence)));
                AppMethodBeat.o(130355);
                return c;
            }
        });
        AppMethodBeat.o(130358);
    }

    public void setComposingDismissedListener(b bVar) {
        this.hux.jgz = bVar;
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        int i = 0;
        AppMethodBeat.i(130359);
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
        AppMethodBeat.o(130359);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        AppMethodBeat.i(130360);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        editorInfo.imeOptions |= 268435456;
        AppMethodBeat.o(130360);
        return onCreateInputConnection;
    }

    public void setMaxLength(int i) {
        this.huz = i;
    }

    public int getMaxLength() {
        return this.huz;
    }

    static /* synthetic */ Spannable a(WAGamePanelInputEditText wAGamePanelInputEditText, Spannable spannable) {
        AppMethodBeat.i(130361);
        PInt pInt = new PInt();
        pInt.value = wAGamePanelInputEditText.huz;
        com.tencent.mm.cb.b dqD = com.tencent.mm.cb.b.dqD();
        wAGamePanelInputEditText.getContext();
        Spannable a = dqD.a(spannable, Math.round(wAGamePanelInputEditText.getTextSize()), pInt, wAGamePanelInputEditText.huA);
        AppMethodBeat.o(130361);
        return a;
    }
}
