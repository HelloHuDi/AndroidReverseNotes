package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.rtmp.sharp.jni.QLog;

/* renamed from: com.tencent.mm.ui.base.RealAlphabetScrollBar */
public class RealAlphabetScrollBar extends VerticalScrollBar {
    /* Access modifiers changed, original: protected|final */
    /* renamed from: Ky */
    public final void mo24098Ky() {
        this.nBS = new String[]{"A", "B", "C", QLog.TAG_REPORTLEVEL_DEVELOPER, QLog.TAG_REPORTLEVEL_USER, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", QLog.TAG_REPORTLEVEL_COLORUSER, "X", "Y", "Z", "#"};
        this.nBQ = 1.3f;
        this.nBR = 79;
    }

    public RealAlphabetScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public int getToastLayoutId() {
        return 2130970675;
    }
}
