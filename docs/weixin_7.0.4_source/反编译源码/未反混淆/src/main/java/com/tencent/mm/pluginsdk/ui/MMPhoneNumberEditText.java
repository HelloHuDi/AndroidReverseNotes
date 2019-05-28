package com.tencent.mm.pluginsdk.ui;

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
import com.tencent.mm.cb.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class MMPhoneNumberEditText extends EditText {
    public String jjo = "";
    private OnFocusChangeListener pIq = null;
    int uQn = 0;
    public boolean vhQ = false;
    public Drawable vhR;
    private a vhS;
    public boolean vhT;
    private boolean vhU = false;

    public interface a {
        void djd();

        void dje();

        void f(MMPhoneNumberEditText mMPhoneNumberEditText);

        void g(MMPhoneNumberEditText mMPhoneNumberEditText);
    }

    static /* synthetic */ void a(MMPhoneNumberEditText mMPhoneNumberEditText) {
        AppMethodBeat.i(27505);
        mMPhoneNumberEditText.djc();
        AppMethodBeat.o(27505);
    }

    static /* synthetic */ void c(MMPhoneNumberEditText mMPhoneNumberEditText) {
        AppMethodBeat.i(27506);
        mMPhoneNumberEditText.dja();
        AppMethodBeat.o(27506);
    }

    public MMPhoneNumberEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(27495);
        init();
        AppMethodBeat.o(27495);
    }

    public MMPhoneNumberEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(27496);
        init();
        AppMethodBeat.o(27496);
    }

    public final void diZ() {
        AppMethodBeat.i(27497);
        this.vhT = true;
        this.vhR = getResources().getDrawable(R.raw.info_icon);
        this.vhR.setBounds(0, 0, this.vhR.getIntrinsicWidth(), this.vhR.getIntrinsicHeight());
        setFocusable(false);
        djb();
        AppMethodBeat.o(27497);
    }

    private void init() {
        AppMethodBeat.i(27498);
        this.vhR = getResources().getDrawable(R.drawable.r8);
        this.vhR.setBounds(0, 0, this.vhR.getIntrinsicWidth(), this.vhR.getIntrinsicHeight());
        ab.d("MicroMsg.MMClearEditText", "imgX width %d height %d", Integer.valueOf(this.vhR.getIntrinsicWidth()), Integer.valueOf(this.vhR.getIntrinsicHeight()));
        dja();
        setHeight(this.vhR.getIntrinsicHeight() + (getResources().getDimensionPixelSize(R.dimen.m7) * 5));
        clearFocus();
        setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(27491);
                MMPhoneNumberEditText mMPhoneNumberEditText = MMPhoneNumberEditText.this;
                if (mMPhoneNumberEditText.getCompoundDrawables()[2] == null) {
                    AppMethodBeat.o(27491);
                } else {
                    if (motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((mMPhoneNumberEditText.getWidth() - mMPhoneNumberEditText.getPaddingRight()) - MMPhoneNumberEditText.this.vhR.getIntrinsicWidth()))) {
                        if (mMPhoneNumberEditText.isFocused()) {
                            mMPhoneNumberEditText.setText("");
                            MMPhoneNumberEditText.a(mMPhoneNumberEditText);
                        } else if (MMPhoneNumberEditText.this.vhS != null) {
                            MMPhoneNumberEditText.this.vhS.f(mMPhoneNumberEditText);
                        }
                    }
                    AppMethodBeat.o(27491);
                }
                return false;
            }
        });
        addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(27492);
                MMPhoneNumberEditText.c(MMPhoneNumberEditText.this);
                if (!charSequence.toString().equals("") || MMPhoneNumberEditText.this.vhU) {
                    if (charSequence.toString().equals("") || !MMPhoneNumberEditText.this.vhU) {
                        if (MMPhoneNumberEditText.this.vhS != null && MMPhoneNumberEditText.this.isFocused()) {
                            MMPhoneNumberEditText.this.vhS.dje();
                        }
                    } else if (MMPhoneNumberEditText.this.vhS != null && MMPhoneNumberEditText.this.isFocused()) {
                        MMPhoneNumberEditText.this.vhS.djd();
                        AppMethodBeat.o(27492);
                        return;
                    }
                } else if (MMPhoneNumberEditText.this.vhS != null && MMPhoneNumberEditText.this.isFocused()) {
                    MMPhoneNumberEditText.this.vhS.g(MMPhoneNumberEditText.this);
                    AppMethodBeat.o(27492);
                    return;
                }
                AppMethodBeat.o(27492);
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(27493);
                if (bo.isNullOrNil(charSequence.toString())) {
                    MMPhoneNumberEditText.this.vhU = true;
                    AppMethodBeat.o(27493);
                    return;
                }
                MMPhoneNumberEditText.this.vhU = false;
                AppMethodBeat.o(27493);
            }
        });
        super.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(27494);
                if (MMPhoneNumberEditText.this.pIq != null) {
                    MMPhoneNumberEditText.this.pIq.onFocusChange(view, z);
                }
                MMPhoneNumberEditText.c(MMPhoneNumberEditText.this);
                AppMethodBeat.o(27494);
            }
        });
        AppMethodBeat.o(27498);
    }

    public boolean onTextContextMenuItem(int i) {
        AppMethodBeat.i(27499);
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
        AppMethodBeat.o(27499);
        return onTextContextMenuItem;
    }

    private void ajp(String str) {
        AppMethodBeat.i(27500);
        int selectionStart = getSelectionStart();
        g dqQ = g.dqQ();
        getContext();
        setText(dqQ.b(str, getTextSize()));
        int length = getText().length() - str.length();
        if (length > 0) {
            selectionStart += length;
            if (selectionStart <= getText().length()) {
                setSelection(selectionStart);
            }
            AppMethodBeat.o(27500);
            return;
        }
        setSelection(selectionStart);
        AppMethodBeat.o(27500);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.pIq = onFocusChangeListener;
    }

    private void dja() {
        AppMethodBeat.i(27501);
        if (getText().toString().equals("")) {
            djc();
            AppMethodBeat.o(27501);
            return;
        }
        djb();
        AppMethodBeat.o(27501);
    }

    private void djb() {
        AppMethodBeat.i(27502);
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.vhR, getCompoundDrawables()[3]);
        AppMethodBeat.o(27502);
    }

    private void djc() {
        AppMethodBeat.i(27503);
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
        AppMethodBeat.o(27503);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(27504);
        if (parcelable instanceof SavedState) {
            if (!this.vhQ) {
                parcelable = BaseSavedState.EMPTY_STATE;
            }
            super.onRestoreInstanceState(parcelable);
            AppMethodBeat.o(27504);
            return;
        }
        super.onRestoreInstanceState(parcelable);
        AppMethodBeat.o(27504);
    }

    public void setCallback(a aVar) {
        this.vhS = aVar;
    }
}
