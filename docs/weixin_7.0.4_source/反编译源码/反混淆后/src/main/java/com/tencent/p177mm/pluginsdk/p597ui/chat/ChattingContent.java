package com.tencent.p177mm.pluginsdk.p597ui.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChattingContent */
public class ChattingContent extends FrameLayout {
    private int voj = -1;
    private int vok = 0;

    public ChattingContent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChattingContent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(27944);
        C4990ab.m7411d("MicroMsg.ChattingContent", "jacks onMeasure  width:%d, height:%d", Integer.valueOf(MeasureSpec.getSize(i)), Integer.valueOf(MeasureSpec.getSize(i2)));
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(27944);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(27945);
        C4990ab.m7411d("MicroMsg.ChattingContent", "jacks onLayout change: %B, l:%d, t:%d, r:%d, b:%d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.m2505o(27945);
    }
}
