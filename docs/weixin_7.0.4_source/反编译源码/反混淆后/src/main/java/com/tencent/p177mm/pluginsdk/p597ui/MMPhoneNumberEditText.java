package com.tencent.p177mm.pluginsdk.p597ui;

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
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p211cb.C9212g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText */
public class MMPhoneNumberEditText extends EditText {
    public String jjo = "";
    private OnFocusChangeListener pIq = null;
    int uQn = 0;
    public boolean vhQ = false;
    public Drawable vhR;
    private C35816a vhS;
    public boolean vhT;
    private boolean vhU = false;

    /* renamed from: com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText$1 */
    class C358141 implements OnTouchListener {
        C358141() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(27491);
            MMPhoneNumberEditText mMPhoneNumberEditText = MMPhoneNumberEditText.this;
            if (mMPhoneNumberEditText.getCompoundDrawables()[2] == null) {
                AppMethodBeat.m2505o(27491);
            } else {
                if (motionEvent.getAction() == 1 && motionEvent.getX() > ((float) ((mMPhoneNumberEditText.getWidth() - mMPhoneNumberEditText.getPaddingRight()) - MMPhoneNumberEditText.this.vhR.getIntrinsicWidth()))) {
                    if (mMPhoneNumberEditText.isFocused()) {
                        mMPhoneNumberEditText.setText("");
                        MMPhoneNumberEditText.m79227a(mMPhoneNumberEditText);
                    } else if (MMPhoneNumberEditText.this.vhS != null) {
                        MMPhoneNumberEditText.this.vhS.mo56597f(mMPhoneNumberEditText);
                    }
                }
                AppMethodBeat.m2505o(27491);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText$3 */
    class C358153 implements OnFocusChangeListener {
        C358153() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(27494);
            if (MMPhoneNumberEditText.this.pIq != null) {
                MMPhoneNumberEditText.this.pIq.onFocusChange(view, z);
            }
            MMPhoneNumberEditText.m79230c(MMPhoneNumberEditText.this);
            AppMethodBeat.m2505o(27494);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText$a */
    public interface C35816a {
        void djd();

        void dje();

        /* renamed from: f */
        void mo56597f(MMPhoneNumberEditText mMPhoneNumberEditText);

        /* renamed from: g */
        void mo56598g(MMPhoneNumberEditText mMPhoneNumberEditText);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText$2 */
    class C404522 implements TextWatcher {
        C404522() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(27492);
            MMPhoneNumberEditText.m79230c(MMPhoneNumberEditText.this);
            if (!charSequence.toString().equals("") || MMPhoneNumberEditText.this.vhU) {
                if (charSequence.toString().equals("") || !MMPhoneNumberEditText.this.vhU) {
                    if (MMPhoneNumberEditText.this.vhS != null && MMPhoneNumberEditText.this.isFocused()) {
                        MMPhoneNumberEditText.this.vhS.dje();
                    }
                } else if (MMPhoneNumberEditText.this.vhS != null && MMPhoneNumberEditText.this.isFocused()) {
                    MMPhoneNumberEditText.this.vhS.djd();
                    AppMethodBeat.m2505o(27492);
                    return;
                }
            } else if (MMPhoneNumberEditText.this.vhS != null && MMPhoneNumberEditText.this.isFocused()) {
                MMPhoneNumberEditText.this.vhS.mo56598g(MMPhoneNumberEditText.this);
                AppMethodBeat.m2505o(27492);
                return;
            }
            AppMethodBeat.m2505o(27492);
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(27493);
            if (C5046bo.isNullOrNil(charSequence.toString())) {
                MMPhoneNumberEditText.this.vhU = true;
                AppMethodBeat.m2505o(27493);
                return;
            }
            MMPhoneNumberEditText.this.vhU = false;
            AppMethodBeat.m2505o(27493);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m79227a(MMPhoneNumberEditText mMPhoneNumberEditText) {
        AppMethodBeat.m2504i(27505);
        mMPhoneNumberEditText.djc();
        AppMethodBeat.m2505o(27505);
    }

    /* renamed from: c */
    static /* synthetic */ void m79230c(MMPhoneNumberEditText mMPhoneNumberEditText) {
        AppMethodBeat.m2504i(27506);
        mMPhoneNumberEditText.dja();
        AppMethodBeat.m2505o(27506);
    }

    public MMPhoneNumberEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(27495);
        init();
        AppMethodBeat.m2505o(27495);
    }

    public MMPhoneNumberEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(27496);
        init();
        AppMethodBeat.m2505o(27496);
    }

    public final void diZ() {
        AppMethodBeat.m2504i(27497);
        this.vhT = true;
        this.vhR = getResources().getDrawable(C1318a.info_icon);
        this.vhR.setBounds(0, 0, this.vhR.getIntrinsicWidth(), this.vhR.getIntrinsicHeight());
        setFocusable(false);
        djb();
        AppMethodBeat.m2505o(27497);
    }

    private void init() {
        AppMethodBeat.m2504i(27498);
        this.vhR = getResources().getDrawable(C25738R.drawable.f6801r8);
        this.vhR.setBounds(0, 0, this.vhR.getIntrinsicWidth(), this.vhR.getIntrinsicHeight());
        C4990ab.m7411d("MicroMsg.MMClearEditText", "imgX width %d height %d", Integer.valueOf(this.vhR.getIntrinsicWidth()), Integer.valueOf(this.vhR.getIntrinsicHeight()));
        dja();
        setHeight(this.vhR.getIntrinsicHeight() + (getResources().getDimensionPixelSize(C25738R.dimen.f9981m7) * 5));
        clearFocus();
        setOnTouchListener(new C358141());
        addTextChangedListener(new C404522());
        super.setOnFocusChangeListener(new C358153());
        AppMethodBeat.m2505o(27498);
    }

    public boolean onTextContextMenuItem(int i) {
        AppMethodBeat.m2504i(27499);
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
        AppMethodBeat.m2505o(27499);
        return onTextContextMenuItem;
    }

    private void ajp(String str) {
        AppMethodBeat.m2504i(27500);
        int selectionStart = getSelectionStart();
        C9212g dqQ = C9212g.dqQ();
        getContext();
        setText(dqQ.mo20622b(str, getTextSize()));
        int length = getText().length() - str.length();
        if (length > 0) {
            selectionStart += length;
            if (selectionStart <= getText().length()) {
                setSelection(selectionStart);
            }
            AppMethodBeat.m2505o(27500);
            return;
        }
        setSelection(selectionStart);
        AppMethodBeat.m2505o(27500);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.pIq = onFocusChangeListener;
    }

    private void dja() {
        AppMethodBeat.m2504i(27501);
        if (getText().toString().equals("")) {
            djc();
            AppMethodBeat.m2505o(27501);
            return;
        }
        djb();
        AppMethodBeat.m2505o(27501);
    }

    private void djb() {
        AppMethodBeat.m2504i(27502);
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.vhR, getCompoundDrawables()[3]);
        AppMethodBeat.m2505o(27502);
    }

    private void djc() {
        AppMethodBeat.m2504i(27503);
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
        AppMethodBeat.m2505o(27503);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.m2504i(27504);
        if (parcelable instanceof SavedState) {
            if (!this.vhQ) {
                parcelable = BaseSavedState.EMPTY_STATE;
            }
            super.onRestoreInstanceState(parcelable);
            AppMethodBeat.m2505o(27504);
            return;
        }
        super.onRestoreInstanceState(parcelable);
        AppMethodBeat.m2505o(27504);
    }

    public void setCallback(C35816a c35816a) {
        this.vhS = c35816a;
    }
}
