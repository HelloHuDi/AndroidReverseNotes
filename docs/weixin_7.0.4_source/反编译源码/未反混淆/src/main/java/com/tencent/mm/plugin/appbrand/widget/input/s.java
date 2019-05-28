package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.Rect;
import android.text.InputFilter;
import android.text.InputFilter.AllCaps;
import android.text.method.NumberKeyListener;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.numberpad.a;

public final class s extends r implements a {
    private InputConnection jfm;

    public final /* bridge */ /* synthetic */ boolean aQT() {
        AppMethodBeat.i(123736);
        boolean aQT = super.aQT();
        AppMethodBeat.o(123736);
        return aQT;
    }

    public final /* bridge */ /* synthetic */ boolean canScrollVertically(int i) {
        AppMethodBeat.i(123735);
        boolean canScrollVertically = super.canScrollVertically(i);
        AppMethodBeat.o(123735);
        return canScrollVertically;
    }

    public final /* bridge */ /* synthetic */ void setGravity(int i) {
        AppMethodBeat.i(123737);
        super.setGravity(i);
        AppMethodBeat.o(123737);
    }

    public s(Context context) {
        super(context);
        AppMethodBeat.i(123727);
        super.setKeyListener(new NumberKeyListener() {
            /* Access modifiers changed, original: protected|final */
            public final char[] getAcceptedChars() {
                return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.', 'X', 'x'};
            }

            public final int getInputType() {
                return (s.this.jgd ? 16 : 0) | 2;
            }
        });
        AppMethodBeat.o(123727);
    }

    public final void clearFocus() {
        AppMethodBeat.i(123728);
        aRo();
        AppMethodBeat.o(123728);
    }

    public final boolean requestFocus(int i, Rect rect) {
        AppMethodBeat.i(123729);
        boolean a = a(i, rect);
        AppMethodBeat.o(123729);
        return a;
    }

    public final void setFilters(InputFilter[] inputFilterArr) {
        int i = 0;
        AppMethodBeat.i(123730);
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
        AppMethodBeat.o(123730);
    }

    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return null;
    }

    public final InputConnection aQU() {
        AppMethodBeat.i(123731);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(new EditorInfo());
        this.jfm = onCreateInputConnection;
        AppMethodBeat.o(123731);
        return onCreateInputConnection;
    }

    public final void setPasswordMode(boolean z) {
        AppMethodBeat.i(123732);
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
        AppMethodBeat.o(123732);
    }

    public final View getInputPanel() {
        AppMethodBeat.i(123733);
        v cL = v.cL(this);
        AppMethodBeat.o(123733);
        return cL;
    }

    public final void aQR() {
        AppMethodBeat.i(123734);
        ((v) getInputPanel()).setInputEditText(this);
        AppMethodBeat.o(123734);
    }
}
