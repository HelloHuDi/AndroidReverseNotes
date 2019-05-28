package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.base.MMVisiblePasswordEditText */
public class MMVisiblePasswordEditText extends EditText {
    public String jjo = "";
    final Drawable yyM = getResources().getDrawable(C1318a.login_showpassword_icon);
    final Drawable yyN = getResources().getDrawable(C1318a.login_showpassword_icon_activa);
    private boolean yyO = false;

    /* renamed from: com.tencent.mm.ui.base.MMVisiblePasswordEditText$1 */
    class C52681 implements OnTouchListener {
        C52681() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z = true;
            AppMethodBeat.m2504i(106954);
            MMVisiblePasswordEditText mMVisiblePasswordEditText = MMVisiblePasswordEditText.this;
            if (mMVisiblePasswordEditText.getCompoundDrawables()[2] == null) {
                AppMethodBeat.m2505o(106954);
            } else if (motionEvent.getAction() != 1) {
                AppMethodBeat.m2505o(106954);
            } else {
                if (motionEvent.getX() > ((float) ((mMVisiblePasswordEditText.getWidth() - mMVisiblePasswordEditText.getPaddingRight()) - MMVisiblePasswordEditText.this.yyM.getIntrinsicWidth()))) {
                    mMVisiblePasswordEditText = MMVisiblePasswordEditText.this;
                    if (MMVisiblePasswordEditText.this.yyO) {
                        z = false;
                    }
                    mMVisiblePasswordEditText.yyO = z;
                    MMVisiblePasswordEditText.m70243b(MMVisiblePasswordEditText.this);
                }
                AppMethodBeat.m2505o(106954);
            }
            return false;
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m70243b(MMVisiblePasswordEditText mMVisiblePasswordEditText) {
        AppMethodBeat.m2504i(106961);
        mMVisiblePasswordEditText.dAl();
        AppMethodBeat.m2505o(106961);
    }

    public MMVisiblePasswordEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106955);
        dzF();
        AppMethodBeat.m2505o(106955);
    }

    public MMVisiblePasswordEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(106956);
        dzF();
        AppMethodBeat.m2505o(106956);
    }

    private void dzF() {
        AppMethodBeat.m2504i(106957);
        this.yyM.setBounds(0, 0, this.yyM.getIntrinsicWidth(), this.yyM.getIntrinsicHeight());
        this.yyN.setBounds(0, 0, this.yyN.getIntrinsicWidth(), this.yyN.getIntrinsicHeight());
        C4990ab.m7411d("MicroMsg.MMVisiblePasswordEditText", "closeEye width %d height %d", Integer.valueOf(this.yyM.getIntrinsicWidth()), Integer.valueOf(this.yyM.getIntrinsicHeight()));
        dAl();
        setHeight(this.yyM.getIntrinsicHeight() + (getResources().getDimensionPixelSize(C25738R.dimen.f9981m7) * 5));
        setOnTouchListener(new C52681());
        AppMethodBeat.m2505o(106957);
    }

    private void dAl() {
        AppMethodBeat.m2504i(106958);
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
        AppMethodBeat.m2505o(106958);
    }

    private void dAm() {
        AppMethodBeat.m2504i(106959);
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.yyN, getCompoundDrawables()[3]);
        AppMethodBeat.m2505o(106959);
    }

    private void dAn() {
        AppMethodBeat.m2504i(106960);
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.yyM, getCompoundDrawables()[3]);
        AppMethodBeat.m2505o(106960);
    }
}
