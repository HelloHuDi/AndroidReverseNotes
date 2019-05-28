package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bo;

public class MMAutoCompleteTextView extends AutoCompleteTextView {
    final Drawable vhR = getResources().getDrawable(R.drawable.r8);
    private a ytE;

    class a implements TextWatcher {
        private String ytG;

        public a(String str) {
            this.ytG = str;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(106475);
            if (editable.toString().endsWith(this.ytG)) {
                MMAutoCompleteTextView.this.showDropDown();
            }
            AppMethodBeat.o(106475);
        }
    }

    static /* synthetic */ void a(MMAutoCompleteTextView mMAutoCompleteTextView) {
        AppMethodBeat.i(106481);
        mMAutoCompleteTextView.djc();
        AppMethodBeat.o(106481);
    }

    static /* synthetic */ void b(MMAutoCompleteTextView mMAutoCompleteTextView) {
        AppMethodBeat.i(106482);
        mMAutoCompleteTextView.dja();
        AppMethodBeat.o(106482);
    }

    public MMAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106476);
        this.vhR.setBounds(0, 0, this.vhR.getIntrinsicWidth(), this.vhR.getIntrinsicHeight());
        dja();
        setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(106472);
                MMAutoCompleteTextView mMAutoCompleteTextView = MMAutoCompleteTextView.this;
                if (mMAutoCompleteTextView.getCompoundDrawables()[2] == null) {
                    AppMethodBeat.o(106472);
                } else if (motionEvent.getAction() != 1) {
                    AppMethodBeat.o(106472);
                } else {
                    if (motionEvent.getX() > ((float) ((mMAutoCompleteTextView.getWidth() - mMAutoCompleteTextView.getPaddingRight()) - MMAutoCompleteTextView.this.vhR.getIntrinsicWidth()))) {
                        mMAutoCompleteTextView.setText("");
                        MMAutoCompleteTextView.a(MMAutoCompleteTextView.this);
                    }
                    AppMethodBeat.o(106472);
                }
                return false;
            }
        });
        addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(106473);
                MMAutoCompleteTextView.b(MMAutoCompleteTextView.this);
                AppMethodBeat.o(106473);
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(106474);
                MMAutoCompleteTextView.b(MMAutoCompleteTextView.this);
                AppMethodBeat.o(106474);
            }
        });
        AppMethodBeat.o(106476);
    }

    private void dja() {
        AppMethodBeat.i(106477);
        if (getText().toString().equals("") || !isFocused()) {
            djc();
            AppMethodBeat.o(106477);
            return;
        }
        djb();
        AppMethodBeat.o(106477);
    }

    private void djb() {
        AppMethodBeat.i(106478);
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.vhR, getCompoundDrawables()[3]);
        AppMethodBeat.o(106478);
    }

    private void djc() {
        AppMethodBeat.i(106479);
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
        AppMethodBeat.o(106479);
    }

    public void setSpilter(String str) {
        AppMethodBeat.i(106480);
        if (!bo.isNullOrNil(str)) {
            this.ytE = new a(str);
            addTextChangedListener(this.ytE);
        }
        AppMethodBeat.o(106480);
    }
}
