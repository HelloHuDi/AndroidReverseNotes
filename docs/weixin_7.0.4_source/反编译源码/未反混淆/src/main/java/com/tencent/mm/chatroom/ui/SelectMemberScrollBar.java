package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.rtmp.sharp.jni.QLog;

public class SelectMemberScrollBar extends AlphabetScrollBar {
    public SelectMemberScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void Ky() {
        this.nBS = new String[]{"A", "B", "C", QLog.TAG_REPORTLEVEL_DEVELOPER, QLog.TAG_REPORTLEVEL_USER, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", QLog.TAG_REPORTLEVEL_COLORUSER, "X", "Y", "Z", "#"};
        this.nBQ = 1.45f;
        this.nBR = 79;
    }
}
