package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;

public class MMVisiblePasswordEditText extends EditText {
    public String jjo = "";
    final Drawable yyM = getResources().getDrawable(R.raw.login_showpassword_icon);
    final Drawable yyN = getResources().getDrawable(R.raw.login_showpassword_icon_activa);
    private boolean yyO = false;

    static /* synthetic */ void b(MMVisiblePasswordEditText mMVisiblePasswordEditText) {
        AppMethodBeat.i(106961);
        mMVisiblePasswordEditText.dAl();
        AppMethodBeat.o(106961);
    }

    public MMVisiblePasswordEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106955);
        dzF();
        AppMethodBeat.o(106955);
    }

    public MMVisiblePasswordEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(106956);
        dzF();
        AppMethodBeat.o(106956);
    }

    private void dzF() {
        AppMethodBeat.i(106957);
        this.yyM.setBounds(0, 0, this.yyM.getIntrinsicWidth(), this.yyM.getIntrinsicHeight());
        this.yyN.setBounds(0, 0, this.yyN.getIntrinsicWidth(), this.yyN.getIntrinsicHeight());
        ab.d("MicroMsg.MMVisiblePasswordEditText", "closeEye width %d height %d", Integer.valueOf(this.yyM.getIntrinsicWidth()), Integer.valueOf(this.yyM.getIntrinsicHeight()));
        dAl();
        setHeight(this.yyM.getIntrinsicHeight() + (getResources().getDimensionPixelSize(R.dimen.m7) * 5));
        setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z = true;
                AppMethodBeat.i(106954);
                MMVisiblePasswordEditText mMVisiblePasswordEditText = MMVisiblePasswordEditText.this;
                if (mMVisiblePasswordEditText.getCompoundDrawables()[2] == null) {
                    AppMethodBeat.o(106954);
                } else if (motionEvent.getAction() != 1) {
                    AppMethodBeat.o(106954);
                } else {
                    if (motionEvent.getX() > ((float) ((mMVisiblePasswordEditText.getWidth() - mMVisiblePasswordEditText.getPaddingRight()) - MMVisiblePasswordEditText.this.yyM.getIntrinsicWidth()))) {
                        mMVisiblePasswordEditText = MMVisiblePasswordEditText.this;
                        if (MMVisiblePasswordEditText.this.yyO) {
                            z = false;
                        }
                        mMVisiblePasswordEditText.yyO = z;
                        MMVisiblePasswordEditText.b(MMVisiblePasswordEditText.this);
                    }
                    AppMethodBeat.o(106954);
                }
                return false;
            }
        });
        AppMethodBeat.o(106957);
    }

    private void dAl() {
        AppMethodBeat.i(106958);
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if (this.yyO) {
            setInputType(1);
            dAm();
        } else {
            setInputType(GmsClientSupervisor.DEFAULT_BIND_FLAGS);
            dAn();
        }
        setSelection(selectionStart, selectionEnd);
        AppMethodBeat.o(106958);
    }

    private void dAm() {
        AppMethodBeat.i(106959);
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.yyN, getCompoundDrawables()[3]);
        AppMethodBeat.o(106959);
    }

    private void dAn() {
        AppMethodBeat.i(106960);
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.yyM, getCompoundDrawables()[3]);
        AppMethodBeat.o(106960);
    }
}
