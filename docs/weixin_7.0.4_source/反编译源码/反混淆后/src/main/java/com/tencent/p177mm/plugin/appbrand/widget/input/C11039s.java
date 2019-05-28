package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.Rect;
import android.text.InputFilter;
import android.text.InputFilter.AllCaps;
import android.text.method.NumberKeyListener;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.input.numberpad.C42741a;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.s */
public final class C11039s extends C27417r implements C42741a {
    private InputConnection jfm;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.s$1 */
    class C110401 extends NumberKeyListener {
        C110401() {
        }

        /* Access modifiers changed, original: protected|final */
        public final char[] getAcceptedChars() {
            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.', 'X', 'x'};
        }

        public final int getInputType() {
            return (C11039s.this.jgd ? 16 : 0) | 2;
        }
    }

    public final /* bridge */ /* synthetic */ boolean aQT() {
        AppMethodBeat.m2504i(123736);
        boolean aQT = super.aQT();
        AppMethodBeat.m2505o(123736);
        return aQT;
    }

    public final /* bridge */ /* synthetic */ boolean canScrollVertically(int i) {
        AppMethodBeat.m2504i(123735);
        boolean canScrollVertically = super.canScrollVertically(i);
        AppMethodBeat.m2505o(123735);
        return canScrollVertically;
    }

    public final /* bridge */ /* synthetic */ void setGravity(int i) {
        AppMethodBeat.m2504i(123737);
        super.setGravity(i);
        AppMethodBeat.m2505o(123737);
    }

    public C11039s(Context context) {
        super(context);
        AppMethodBeat.m2504i(123727);
        super.setKeyListener(new C110401());
        AppMethodBeat.m2505o(123727);
    }

    public final void clearFocus() {
        AppMethodBeat.m2504i(123728);
        aRo();
        AppMethodBeat.m2505o(123728);
    }

    public final boolean requestFocus(int i, Rect rect) {
        AppMethodBeat.m2504i(123729);
        boolean a = mo6567a(i, rect);
        AppMethodBeat.m2505o(123729);
        return a;
    }

    public final void setFilters(InputFilter[] inputFilterArr) {
        int i = 0;
        AppMethodBeat.m2504i(123730);
        if (inputFilterArr == null) {
            inputFilterArr = new InputFilter[0];
        }
        InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
        while (i < inputFilterArr.length) {
            inputFilterArr2[i] = inputFilterArr[i];
            i++;
        }
        inputFilterArr2[i] = new AllCaps();
        super.setFilters(inputFilterArr2);
        AppMethodBeat.m2505o(123730);
    }

    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return null;
    }

    public final InputConnection aQU() {
        AppMethodBeat.m2504i(123731);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(new EditorInfo());
        this.jfm = onCreateInputConnection;
        AppMethodBeat.m2505o(123731);
        return onCreateInputConnection;
    }

    public final void setPasswordMode(boolean z) {
        AppMethodBeat.m2504i(123732);
        aRm();
        int inputType = getInputType() | 2;
        if (z) {
            inputType |= 16;
        } else {
            inputType &= -17;
        }
        setInputType(inputType);
        super.setPasswordMode(z);
        aRn();
        AppMethodBeat.m2505o(123732);
    }

    public final View getInputPanel() {
        AppMethodBeat.m2504i(123733);
        C46899v cL = C46899v.m89263cL(this);
        AppMethodBeat.m2505o(123733);
        return cL;
    }

    public final void aQR() {
        AppMethodBeat.m2504i(123734);
        ((C46899v) getInputPanel()).setInputEditText(this);
        AppMethodBeat.m2505o(123734);
    }
}
