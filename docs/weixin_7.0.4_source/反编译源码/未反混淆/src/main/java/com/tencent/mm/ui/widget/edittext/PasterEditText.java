package com.tencent.mm.ui.widget.edittext;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PasterEditText extends EditText {
    private Context context;
    private int iHm = 0;
    private ClipboardManager rrN = null;

    public PasterEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(112701);
        this.context = context;
        init();
        AppMethodBeat.o(112701);
    }

    public PasterEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(112702);
        init();
        AppMethodBeat.o(112702);
    }

    public int getPasterLen() {
        return this.iHm;
    }

    private void init() {
        AppMethodBeat.i(112703);
        this.rrN = (ClipboardManager) this.context.getApplicationContext().getSystemService("clipboard");
        AppMethodBeat.o(112703);
    }

    public boolean onTextContextMenuItem(int i) {
        boolean onTextContextMenuItem;
        AppMethodBeat.i(112704);
        if (i == 16908322) {
            if (!(this.rrN == null || this.rrN.getText() == null || !(this.rrN.getText() instanceof String) || this.rrN.getText() == null || this.rrN.getText().length() <= 0)) {
                this.iHm += this.rrN.getText().length();
            }
            onTextContextMenuItem = super.onTextContextMenuItem(i);
        } else {
            onTextContextMenuItem = super.onTextContextMenuItem(i);
        }
        AppMethodBeat.o(112704);
        return onTextContextMenuItem;
    }
}
