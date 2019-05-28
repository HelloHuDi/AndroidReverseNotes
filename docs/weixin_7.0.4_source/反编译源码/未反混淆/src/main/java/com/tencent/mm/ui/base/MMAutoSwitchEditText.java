package com.tencent.mm.ui.base;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

class MMAutoSwitchEditText extends EditText {
    a ytJ = new a(this);

    public interface b {
        void ND(int i);
    }

    public interface d {
        void dzE();
    }

    public static class a implements TextWatcher, OnKeyListener {
        int mIndex = 0;
        private String mText;
        private EditText tc;
        c ytK;
        b ytL;
        d ytM;
        int ytN = 4;

        public a(EditText editText) {
            this.tc = editText;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(106495);
            this.mText = editable.toString();
            String str = "";
            if (this.ytM != null) {
                this.ytM.dzE();
            }
            int i = 0;
            int i2 = 0;
            while (i < this.mText.length()) {
                i2++;
                if (i2 > this.ytN) {
                    break;
                }
                i++;
                str = str + this.mText.charAt(i);
            }
            if (i2 > this.ytN) {
                this.tc.setText(str);
                this.tc.setSelection(str.length());
            }
            if (i2 >= this.ytN && this.ytK != null) {
                this.ytK.NE(this.mIndex);
            }
            AppMethodBeat.o(106495);
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.i(106496);
            if (i == 67 && this.tc.getText().toString().trim().length() == 0 && this.ytL != null) {
                this.ytL.ND(this.mIndex);
            }
            AppMethodBeat.o(106496);
            return false;
        }
    }

    public interface c {
        void NE(int i);
    }

    public MMAutoSwitchEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106497);
        addTextChangedListener(this.ytJ);
        setOnKeyListener(this.ytJ);
        AppMethodBeat.o(106497);
    }
}
