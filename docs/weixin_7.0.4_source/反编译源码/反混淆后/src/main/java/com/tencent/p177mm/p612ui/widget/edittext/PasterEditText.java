package com.tencent.p177mm.p612ui.widget.edittext;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.widget.edittext.PasterEditText */
public class PasterEditText extends EditText {
    private Context context;
    private int iHm = 0;
    private ClipboardManager rrN = null;

    public PasterEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(112701);
        this.context = context;
        init();
        AppMethodBeat.m2505o(112701);
    }

    public PasterEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(112702);
        init();
        AppMethodBeat.m2505o(112702);
    }

    public int getPasterLen() {
        return this.iHm;
    }

    private void init() {
        AppMethodBeat.m2504i(112703);
        this.rrN = (ClipboardManager) this.context.getApplicationContext().getSystemService("clipboard");
        AppMethodBeat.m2505o(112703);
    }

    public boolean onTextContextMenuItem(int i) {
        boolean onTextContextMenuItem;
        AppMethodBeat.m2504i(112704);
        if (i == 16908322) {
            if (!(this.rrN == null || this.rrN.getText() == null || !(this.rrN.getText() instanceof String) || this.rrN.getText() == null || this.rrN.getText().length() <= 0)) {
                this.iHm += this.rrN.getText().length();
            }
            onTextContextMenuItem = super.onTextContextMenuItem(i);
        } else {
            onTextContextMenuItem = super.onTextContextMenuItem(i);
        }
        AppMethodBeat.m2505o(112704);
        return onTextContextMenuItem;
    }
}
