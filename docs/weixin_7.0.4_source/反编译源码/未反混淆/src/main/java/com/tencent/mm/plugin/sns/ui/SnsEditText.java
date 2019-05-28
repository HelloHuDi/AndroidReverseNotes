package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.MMEditText;

public class SnsEditText extends MMEditText {
    private Context context;
    private int iHm = 0;
    private boolean nJS = false;
    private ClipboardManager rrN = null;
    private int rrO = 0;
    private int rrP = 0;
    private int rrQ = 10;
    private float y;

    public SnsEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38932);
        this.context = context;
        this.rrN = (ClipboardManager) ah.getContext().getSystemService("clipboard");
        addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(38930);
                if (charSequence != null) {
                    try {
                        if (charSequence.length() >= a.qFE) {
                            if (charSequence.length() - SnsEditText.this.rrO > a.qFE) {
                                SnsEditText.this.iHm = charSequence.length() - SnsEditText.this.rrO;
                            }
                            AppMethodBeat.o(38930);
                            return;
                        }
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.SnsEditText", e, "", new Object[0]);
                        AppMethodBeat.o(38930);
                        return;
                    }
                }
                SnsEditText.this.iHm = 0;
                AppMethodBeat.o(38930);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(38931);
                if (charSequence != null) {
                    SnsEditText.this.rrO = charSequence.length();
                }
                AppMethodBeat.o(38931);
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        AppMethodBeat.o(38932);
    }

    public int getPasterLen() {
        return this.iHm;
    }

    public void setPasterLen(int i) {
        this.iHm = i;
    }

    public boolean onTextContextMenuItem(int i) {
        AppMethodBeat.i(38933);
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i);
        AppMethodBeat.o(38933);
        return onTextContextMenuItem;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(38934);
        if (motionEvent.getAction() == 2) {
            if (Math.abs(this.y - motionEvent.getY()) > ((float) this.rrQ)) {
                this.nJS = true;
            }
        } else if (motionEvent.getAction() != 1) {
            this.nJS = false;
        } else if (this.nJS) {
            this.nJS = false;
            AppMethodBeat.o(38934);
            return true;
        }
        this.y = motionEvent.getY();
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(38934);
        return onTouchEvent;
    }
}
