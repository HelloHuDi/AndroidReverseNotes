package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.p177mm.p612ui.base.VerticalScrollBar;
import com.tencent.rtmp.sharp.jni.QLog;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallAddressScrollbar */
public class IPCallAddressScrollbar extends VerticalScrollBar {
    /* renamed from: Ky */
    public final void mo24098Ky() {
        this.nBS = new String[]{"↑", "A", "B", "C", QLog.TAG_REPORTLEVEL_DEVELOPER, QLog.TAG_REPORTLEVEL_USER, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", QLog.TAG_REPORTLEVEL_COLORUSER, "X", "Y", "Z", "#"};
        this.nBQ = 1.3f;
        this.nBR = 66;
    }

    public IPCallAddressScrollbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int getToastLayoutId() {
        return 2130970675;
    }
}
