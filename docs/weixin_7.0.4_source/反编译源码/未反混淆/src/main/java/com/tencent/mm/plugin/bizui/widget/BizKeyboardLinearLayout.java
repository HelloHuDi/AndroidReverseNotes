package com.tencent.mm.plugin.bizui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.KeyboardLinearLayout;

public class BizKeyboardLinearLayout extends KeyboardLinearLayout {
    private boolean jED;
    private int jEE;
    private int jEF;
    private int jEG;
    private boolean mHasInit = false;
    private int mHeight;

    public BizKeyboardLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BizKeyboardLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(70045);
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.o(70045);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(70046);
        super.onMeasure(i, i2);
        AppMethodBeat.o(70046);
    }

    public final void rP(int i) {
        AppMethodBeat.i(70047);
        ab.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout : b: " + i + " mHasInit: " + this.mHasInit + " mHasKeyboard: " + this.jED);
        Rect rect = new Rect();
        getWindowVisibleDisplayFrame(rect);
        int height = getRootView().getHeight();
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.mHeight = i;
            ab.i("MicroMsg.WebViewKeyboardLinearLayout", "init height:%d", Integer.valueOf(this.mHeight));
            sD(-1);
            this.jEG = height - rect.bottom;
        }
        ab.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, current rect = %s", rect.toString());
        height = rect.height();
        this.mHeight = height;
        ab.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, usableHeightNow = %d, previousUsableHeight = %d", Integer.valueOf(height), Integer.valueOf(this.jEE));
        if (this.jEE != height) {
            int height2 = (getRootView().getHeight() - this.jEG) - rect.top;
            int i2 = height2 - height;
            if (i2 > height2 / 4) {
                this.jED = true;
                this.jEF = i2;
                sD(-3);
                ab.w("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, show keyboard!! mHeight: " + this.mHeight + " b: " + i + " mKBHeight: " + this.jEF);
            } else {
                this.jED = false;
                sD(-2);
                ab.w("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, hide keyboard!! mHeight: " + this.mHeight + " b: " + i);
            }
            this.jEE = height;
        }
        AppMethodBeat.o(70047);
    }

    public final int getKeyBoardHeight() {
        return this.jEF;
    }
}
