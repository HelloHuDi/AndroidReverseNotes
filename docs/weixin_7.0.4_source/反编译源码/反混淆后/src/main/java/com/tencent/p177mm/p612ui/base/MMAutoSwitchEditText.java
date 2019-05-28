package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.base.MMAutoSwitchEditText */
class MMAutoSwitchEditText extends EditText {
    C30364a ytJ = new C30364a(this);

    /* renamed from: com.tencent.mm.ui.base.MMAutoSwitchEditText$b */
    public interface C15507b {
        /* renamed from: ND */
        void mo10756ND(int i);
    }

    /* renamed from: com.tencent.mm.ui.base.MMAutoSwitchEditText$d */
    public interface C23583d {
        void dzE();
    }

    /* renamed from: com.tencent.mm.ui.base.MMAutoSwitchEditText$a */
    public static class C30364a implements TextWatcher, OnKeyListener {
        int mIndex = 0;
        private String mText;
        /* renamed from: tc */
        private EditText f13736tc;
        C30365c ytK;
        C15507b ytL;
        C23583d ytM;
        int ytN = 4;

        public C30364a(EditText editText) {
            this.f13736tc = editText;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(106495);
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
                this.f13736tc.setText(str);
                this.f13736tc.setSelection(str.length());
            }
            if (i2 >= this.ytN && this.ytK != null) {
                this.ytK.mo10757NE(this.mIndex);
            }
            AppMethodBeat.m2505o(106495);
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(106496);
            if (i == 67 && this.f13736tc.getText().toString().trim().length() == 0 && this.ytL != null) {
                this.ytL.mo10756ND(this.mIndex);
            }
            AppMethodBeat.m2505o(106496);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMAutoSwitchEditText$c */
    public interface C30365c {
        /* renamed from: NE */
        void mo10757NE(int i);
    }

    public MMAutoSwitchEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106497);
        addTextChangedListener(this.ytJ);
        setOnKeyListener(this.ytJ);
        AppMethodBeat.m2505o(106497);
    }
}
