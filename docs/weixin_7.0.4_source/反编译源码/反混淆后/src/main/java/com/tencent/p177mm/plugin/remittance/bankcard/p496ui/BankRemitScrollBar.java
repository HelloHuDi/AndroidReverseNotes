package com.tencent.p177mm.plugin.remittance.bankcard.p496ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.AlphabetScrollBar;
import com.tencent.rtmp.sharp.jni.QLog;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitScrollBar */
public class BankRemitScrollBar extends AlphabetScrollBar {
    public BankRemitScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: Ky */
    public final void mo24098Ky() {
        AppMethodBeat.m2504i(44658);
        super.mo24098Ky();
        this.nBS = new String[]{"☆", "A", "B", "C", QLog.TAG_REPORTLEVEL_DEVELOPER, QLog.TAG_REPORTLEVEL_USER, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", QLog.TAG_REPORTLEVEL_COLORUSER, "X", "Y", "Z", "#"};
        AppMethodBeat.m2505o(44658);
    }
}
