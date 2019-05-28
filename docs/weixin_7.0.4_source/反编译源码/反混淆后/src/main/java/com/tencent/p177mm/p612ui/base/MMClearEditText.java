package com.tencent.p177mm.p612ui.base;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.p627e.p628c.C5509b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.base.MMClearEditText */
public class MMClearEditText extends EditText {
    private OnTouchListener jZu = new C52483();
    public String jjo = "";
    private OnFocusChangeListener pIq = null;
    int uQn = 0;
    public boolean vhQ = false;
    final Drawable vhR = getResources().getDrawable(C25738R.drawable.f6801r8);
    private boolean ytV = false;

    /* renamed from: com.tencent.mm.ui.base.MMClearEditText$1 */
    class C52461 implements TextWatcher {
        C52461() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(106504);
            MMClearEditText.m8018a(MMClearEditText.this);
            AppMethodBeat.m2505o(106504);
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMClearEditText$2 */
    class C52472 implements OnFocusChangeListener {
        C52472() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(106505);
            if (MMClearEditText.this.pIq != null) {
                MMClearEditText.this.pIq.onFocusChange(view, z);
            }
            MMClearEditText.m8018a(MMClearEditText.this);
            AppMethodBeat.m2505o(106505);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMClearEditText$3 */
    class C52483 implements OnTouchListener {
        C52483() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(106506);
            MMClearEditText mMClearEditText = MMClearEditText.this;
            if (mMClearEditText.getCompoundDrawables()[2] == null) {
                AppMethodBeat.m2505o(106506);
            } else if (motionEvent.getAction() != 1) {
                AppMethodBeat.m2505o(106506);
            } else {
                if (motionEvent.getX() > ((float) ((mMClearEditText.getWidth() - mMClearEditText.getPaddingRight()) - MMClearEditText.this.vhR.getIntrinsicWidth()))) {
                    mMClearEditText.setText("");
                    MMClearEditText.m8020c(MMClearEditText.this);
                }
                AppMethodBeat.m2505o(106506);
            }
            return false;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m8018a(MMClearEditText mMClearEditText) {
        AppMethodBeat.m2504i(106516);
        mMClearEditText.dja();
        AppMethodBeat.m2505o(106516);
    }

    /* renamed from: c */
    static /* synthetic */ void m8020c(MMClearEditText mMClearEditText) {
        AppMethodBeat.m2504i(106517);
        mMClearEditText.djc();
        AppMethodBeat.m2505o(106517);
    }

    public MMClearEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106507);
        dzF();
        AppMethodBeat.m2505o(106507);
    }

    public MMClearEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(106508);
        dzF();
        AppMethodBeat.m2505o(106508);
    }

    private void dzF() {
        AppMethodBeat.m2504i(106509);
        this.vhR.setBounds(0, 0, this.vhR.getIntrinsicWidth(), this.vhR.getIntrinsicHeight());
        C4990ab.m7411d("MicroMsg.MMClearEditText", "imgX width %d height %d", Integer.valueOf(this.vhR.getIntrinsicWidth()), Integer.valueOf(this.vhR.getIntrinsicHeight()));
        dja();
        setHeight(this.vhR.getIntrinsicHeight() + (getResources().getDimensionPixelSize(C25738R.dimen.f9981m7) * 5));
        setOnTouchListener(this.jZu);
        addTextChangedListener(new C52461());
        super.setOnFocusChangeListener(new C52472());
        AppMethodBeat.m2505o(106509);
    }

    public boolean onTextContextMenuItem(int i) {
        AppMethodBeat.m2504i(106510);
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i);
        if (i == 16908322) {
            this.uQn = 0;
            String obj = getText().toString();
            try {
                ajp(obj);
            } catch (IndexOutOfBoundsException e) {
                C4990ab.m7413e("MicroMsg.MMClearEditText", "!!MMClearEditText Exception %d", Integer.valueOf(this.uQn));
                if (this.uQn < 3) {
                    this.uQn++;
                    ajp(" ".concat(String.valueOf(obj)));
                } else {
                    C4990ab.m7412e("MicroMsg.MMClearEditText", "!!MMClearEditText, IndexOutOfBoundsException cannot fix");
                }
            }
        }
        AppMethodBeat.m2505o(106510);
        return onTextContextMenuItem;
    }

    private void ajp(String str) {
        AppMethodBeat.m2504i(106511);
        int selectionStart = getSelectionStart();
        setText(C5509b.m8295c(getContext(), str, getTextSize()));
        int length = getText().length() - str.length();
        if (length > 0) {
            selectionStart += length;
            if (selectionStart <= getText().length()) {
                setSelection(selectionStart);
            }
            AppMethodBeat.m2505o(106511);
            return;
        }
        setSelection(selectionStart);
        AppMethodBeat.m2505o(106511);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.pIq = onFocusChangeListener;
    }

    public OnTouchListener getDefaultOnTouchListener() {
        return this.jZu;
    }

    private void dja() {
        AppMethodBeat.m2504i(106512);
        if (getText().toString().equals("") || !isFocused()) {
            djc();
            AppMethodBeat.m2505o(106512);
            return;
        }
        djb();
        AppMethodBeat.m2505o(106512);
    }

    private void djb() {
        AppMethodBeat.m2504i(106513);
        if (!this.ytV) {
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.vhR, getCompoundDrawables()[3]);
        }
        AppMethodBeat.m2505o(106513);
    }

    private void djc() {
        AppMethodBeat.m2504i(106514);
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
        AppMethodBeat.m2505o(106514);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.m2504i(106515);
        if (parcelable instanceof SavedState) {
            if (!this.vhQ) {
                parcelable = BaseSavedState.EMPTY_STATE;
            }
            super.onRestoreInstanceState(parcelable);
            AppMethodBeat.m2505o(106515);
            return;
        }
        super.onRestoreInstanceState(parcelable);
        AppMethodBeat.m2505o(106515);
    }
}
