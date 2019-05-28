package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.rtmp.sharp.jni.QLog;

public class IPCallAddressScrollbar extends VerticalScrollBar {
    public final void Ky() {
        this.nBS = new String[]{"↑", "A", "B", "C", QLog.TAG_REPORTLEVEL_DEVELOPER, QLog.TAG_REPORTLEVEL_USER, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", QLog.TAG_REPORTLEVEL_COLORUSER, "X", "Y", "Z", "#"};
        this.nBQ = 1.3f;
        this.nBR = 66;
    }

    public IPCallAddressScrollbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int getToastLayoutId() {
        return R.layout.asw;
    }
}
