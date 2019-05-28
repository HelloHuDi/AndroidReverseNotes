package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class HardDeviceChattingItemView extends LinearLayout {
    private boolean mHasInit;

    public HardDeviceChattingItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onFinishInflate() {
        AppMethodBeat.i(30940);
        super.onFinishInflate();
        if (!this.mHasInit) {
            this.mHasInit = true;
        }
        AppMethodBeat.o(30940);
    }
}
