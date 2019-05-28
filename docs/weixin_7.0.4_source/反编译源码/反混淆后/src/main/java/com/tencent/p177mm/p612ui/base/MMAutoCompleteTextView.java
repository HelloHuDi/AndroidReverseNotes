package com.tencent.p177mm.p612ui.base;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.base.MMAutoCompleteTextView */
public class MMAutoCompleteTextView extends AutoCompleteTextView {
    final Drawable vhR = getResources().getDrawable(C25738R.drawable.f6801r8);
    private C36053a ytE;

    /* renamed from: com.tencent.mm.ui.base.MMAutoCompleteTextView$1 */
    class C303631 implements OnTouchListener {
        C303631() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(106472);
            MMAutoCompleteTextView mMAutoCompleteTextView = MMAutoCompleteTextView.this;
            if (mMAutoCompleteTextView.getCompoundDrawables()[2] == null) {
                AppMethodBeat.m2505o(106472);
            } else if (motionEvent.getAction() != 1) {
                AppMethodBeat.m2505o(106472);
            } else {
                if (motionEvent.getX() > ((float) ((mMAutoCompleteTextView.getWidth() - mMAutoCompleteTextView.getPaddingRight()) - MMAutoCompleteTextView.this.vhR.getIntrinsicWidth()))) {
                    mMAutoCompleteTextView.setText("");
                    MMAutoCompleteTextView.m59341a(MMAutoCompleteTextView.this);
                }
                AppMethodBeat.m2505o(106472);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMAutoCompleteTextView$2 */
    class C360522 implements TextWatcher {
        C360522() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(106473);
            MMAutoCompleteTextView.m59342b(MMAutoCompleteTextView.this);
            AppMethodBeat.m2505o(106473);
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMAutoCompleteTextView$a */
    class C36053a implements TextWatcher {
        private String ytG;

        public C36053a(String str) {
            this.ytG = str;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(106475);
            if (editable.toString().endsWith(this.ytG)) {
                MMAutoCompleteTextView.this.showDropDown();
            }
            AppMethodBeat.m2505o(106475);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMAutoCompleteTextView$3 */
    class C360543 implements OnFocusChangeListener {
        C360543() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(106474);
            MMAutoCompleteTextView.m59342b(MMAutoCompleteTextView.this);
            AppMethodBeat.m2505o(106474);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m59341a(MMAutoCompleteTextView mMAutoCompleteTextView) {
        AppMethodBeat.m2504i(106481);
        mMAutoCompleteTextView.djc();
        AppMethodBeat.m2505o(106481);
    }

    /* renamed from: b */
    static /* synthetic */ void m59342b(MMAutoCompleteTextView mMAutoCompleteTextView) {
        AppMethodBeat.m2504i(106482);
        mMAutoCompleteTextView.dja();
        AppMethodBeat.m2505o(106482);
    }

    public MMAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106476);
        this.vhR.setBounds(0, 0, this.vhR.getIntrinsicWidth(), this.vhR.getIntrinsicHeight());
        dja();
        setOnTouchListener(new C303631());
        addTextChangedListener(new C360522());
        setOnFocusChangeListener(new C360543());
        AppMethodBeat.m2505o(106476);
    }

    private void dja() {
        AppMethodBeat.m2504i(106477);
        if (getText().toString().equals("") || !isFocused()) {
            djc();
            AppMethodBeat.m2505o(106477);
            return;
        }
        djb();
        AppMethodBeat.m2505o(106477);
    }

    private void djb() {
        AppMethodBeat.m2504i(106478);
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.vhR, getCompoundDrawables()[3]);
        AppMethodBeat.m2505o(106478);
    }

    private void djc() {
        AppMethodBeat.m2504i(106479);
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
        AppMethodBeat.m2505o(106479);
    }

    public void setSpilter(String str) {
        AppMethodBeat.m2504i(106480);
        if (!C5046bo.isNullOrNil(str)) {
            this.ytE = new C36053a(str);
            addTextChangedListener(this.ytE);
        }
        AppMethodBeat.m2505o(106480);
    }
}
