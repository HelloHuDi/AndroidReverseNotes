package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.R;
import com.tencent.rtmp.sharp.jni.QLog;

public class AlphabetScrollBar extends VerticalScrollBar {
    /* Access modifiers changed, original: protected */
    public void Ky() {
        this.nBS = new String[]{"↑", "☆", "A", "B", "C", QLog.TAG_REPORTLEVEL_DEVELOPER, QLog.TAG_REPORTLEVEL_USER, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", QLog.TAG_REPORTLEVEL_COLORUSER, "X", "Y", "Z", "#"};
        this.nBQ = 1.6f;
        this.nBR = 79;
    }

    public AlphabetScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public int getToastLayoutId() {
        return R.layout.asw;
    }
}
