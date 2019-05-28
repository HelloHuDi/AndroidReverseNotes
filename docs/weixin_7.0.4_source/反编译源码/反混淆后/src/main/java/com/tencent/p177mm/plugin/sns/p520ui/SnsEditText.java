package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsEditText */
public class SnsEditText extends MMEditText {
    private Context context;
    private int iHm = 0;
    private boolean nJS = false;
    private ClipboardManager rrN = null;
    private int rrO = 0;
    private int rrP = 0;
    private int rrQ = 10;
    /* renamed from: y */
    private float f4397y;

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsEditText$1 */
    class C135301 implements TextWatcher {
        C135301() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(38930);
            if (charSequence != null) {
                try {
                    if (charSequence.length() >= C24826a.qFE) {
                        if (charSequence.length() - SnsEditText.this.rrO > C24826a.qFE) {
                            SnsEditText.this.iHm = charSequence.length() - SnsEditText.this.rrO;
                        }
                        AppMethodBeat.m2505o(38930);
                        return;
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.SnsEditText", e, "", new Object[0]);
                    AppMethodBeat.m2505o(38930);
                    return;
                }
            }
            SnsEditText.this.iHm = 0;
            AppMethodBeat.m2505o(38930);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(38931);
            if (charSequence != null) {
                SnsEditText.this.rrO = charSequence.length();
            }
            AppMethodBeat.m2505o(38931);
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    public SnsEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(38932);
        this.context = context;
        this.rrN = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
        addTextChangedListener(new C135301());
        AppMethodBeat.m2505o(38932);
    }

    public int getPasterLen() {
        return this.iHm;
    }

    public void setPasterLen(int i) {
        this.iHm = i;
    }

    public boolean onTextContextMenuItem(int i) {
        AppMethodBeat.m2504i(38933);
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i);
        AppMethodBeat.m2505o(38933);
        return onTextContextMenuItem;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(38934);
        if (motionEvent.getAction() == 2) {
            if (Math.abs(this.f4397y - motionEvent.getY()) > ((float) this.rrQ)) {
                this.nJS = true;
            }
        } else if (motionEvent.getAction() != 1) {
            this.nJS = false;
        } else if (this.nJS) {
            this.nJS = false;
            AppMethodBeat.m2505o(38934);
            return true;
        }
        this.f4397y = motionEvent.getY();
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(38934);
        return onTouchEvent;
    }
}
