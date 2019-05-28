package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView.SavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.e.c.b;

public class MMClearEditText extends EditText {
    private OnTouchListener jZu = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(106506);
            MMClearEditText mMClearEditText = MMClearEditText.this;
            if (mMClearEditText.getCompoundDrawables()[2] == null) {
                AppMethodBeat.o(106506);
            } else if (motionEvent.getAction() != 1) {
                AppMethodBeat.o(106506);
            } else {
                if (motionEvent.getX() > ((float) ((mMClearEditText.getWidth() - mMClearEditText.getPaddingRight()) - MMClearEditText.this.vhR.getIntrinsicWidth()))) {
                    mMClearEditText.setText("");
                    MMClearEditText.c(MMClearEditText.this);
                }
                AppMethodBeat.o(106506);
            }
            return false;
        }
    };
    public String jjo = "";
    private OnFocusChangeListener pIq = null;
    int uQn = 0;
    public boolean vhQ = false;
    final Drawable vhR = getResources().getDrawable(R.drawable.r8);
    private boolean ytV = false;

    static /* synthetic */ void a(MMClearEditText mMClearEditText) {
        AppMethodBeat.i(106516);
        mMClearEditText.dja();
        AppMethodBeat.o(106516);
    }

    static /* synthetic */ void c(MMClearEditText mMClearEditText) {
        AppMethodBeat.i(106517);
        mMClearEditText.djc();
        AppMethodBeat.o(106517);
    }

    public MMClearEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106507);
        dzF();
        AppMethodBeat.o(106507);
    }

    public MMClearEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(106508);
        dzF();
        AppMethodBeat.o(106508);
    }

    private void dzF() {
        AppMethodBeat.i(106509);
        this.vhR.setBounds(0, 0, this.vhR.getIntrinsicWidth(), this.vhR.getIntrinsicHeight());
        ab.d("MicroMsg.MMClearEditText", "imgX width %d height %d", Integer.valueOf(this.vhR.getIntrinsicWidth()), Integer.valueOf(this.vhR.getIntrinsicHeight()));
        dja();
        setHeight(this.vhR.getIntrinsicHeight() + (getResources().getDimensionPixelSize(R.dimen.m7) * 5));
        setOnTouchListener(this.jZu);
        addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(106504);
                MMClearEditText.a(MMClearEditText.this);
                AppMethodBeat.o(106504);
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        super.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(106505);
                if (MMClearEditText.this.pIq != null) {
                    MMClearEditText.this.pIq.onFocusChange(view, z);
                }
                MMClearEditText.a(MMClearEditText.this);
                AppMethodBeat.o(106505);
            }
        });
        AppMethodBeat.o(106509);
    }

    public boolean onTextContextMenuItem(int i) {
        AppMethodBeat.i(106510);
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i);
        if (i == 16908322) {
            this.uQn = 0;
            String obj = getText().toString();
            try {
                ajp(obj);
            } catch (IndexOutOfBoundsException e) {
                ab.e("MicroMsg.MMClearEditText", "!!MMClearEditText Exception %d", Integer.valueOf(this.uQn));
                if (this.uQn < 3) {
                    this.uQn++;
                    ajp(" ".concat(String.valueOf(obj)));
                } else {
                    ab.e("MicroMsg.MMClearEditText", "!!MMClearEditText, IndexOutOfBoundsException cannot fix");
                }
            }
        }
        AppMethodBeat.o(106510);
        return onTextContextMenuItem;
    }

    private void ajp(String str) {
        AppMethodBeat.i(106511);
        int selectionStart = getSelectionStart();
        setText(b.c(getContext(), str, getTextSize()));
        int length = getText().length() - str.length();
        if (length > 0) {
            selectionStart += length;
            if (selectionStart <= getText().length()) {
                setSelection(selectionStart);
            }
            AppMethodBeat.o(106511);
            return;
        }
        setSelection(selectionStart);
        AppMethodBeat.o(106511);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.pIq = onFocusChangeListener;
    }

    public OnTouchListener getDefaultOnTouchListener() {
        return this.jZu;
    }

    private void dja() {
        AppMethodBeat.i(106512);
        if (getText().toString().equals("") || !isFocused()) {
            djc();
            AppMethodBeat.o(106512);
            return;
        }
        djb();
        AppMethodBeat.o(106512);
    }

    private void djb() {
        AppMethodBeat.i(106513);
        if (!this.ytV) {
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.vhR, getCompoundDrawables()[3]);
        }
        AppMethodBeat.o(106513);
    }

    private void djc() {
        AppMethodBeat.i(106514);
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
        AppMethodBeat.o(106514);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(106515);
        if (parcelable instanceof SavedState) {
            if (!this.vhQ) {
                parcelable = BaseSavedState.EMPTY_STATE;
            }
            super.onRestoreInstanceState(parcelable);
            AppMethodBeat.o(106515);
            return;
        }
        super.onRestoreInstanceState(parcelable);
        AppMethodBeat.o(106515);
    }
}
