package com.tencent.p177mm.p612ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.chatting.HardDeviceChattingItemView */
public class HardDeviceChattingItemView extends LinearLayout {
    private boolean mHasInit;

    public HardDeviceChattingItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onFinishInflate() {
        AppMethodBeat.m2504i(30940);
        super.onFinishInflate();
        if (!this.mHasInit) {
            this.mHasInit = true;
        }
        AppMethodBeat.m2505o(30940);
    }
}
