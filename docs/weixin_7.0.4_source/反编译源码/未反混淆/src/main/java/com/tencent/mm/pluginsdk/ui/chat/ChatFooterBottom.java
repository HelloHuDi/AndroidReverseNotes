package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class ChatFooterBottom extends FrameLayout {
    private boolean cPo = false;

    public ChatFooterBottom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChatFooterBottom(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(27937);
        super.draw(canvas);
        AppMethodBeat.o(27937);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(27938);
        ab.d("MicroMsg.ChatFooterBottom", "jacks onMeasure  width:%d, height:%d, isHide: %B", Integer.valueOf(MeasureSpec.getSize(i)), Integer.valueOf(MeasureSpec.getSize(i2)), Boolean.valueOf(this.cPo));
        if (this.cPo) {
            setVisibility(8);
            i = MeasureSpec.makeMeasureSpec(0, ErrorDialogData.SUPPRESSED);
            i2 = MeasureSpec.makeMeasureSpec(0, ErrorDialogData.SUPPRESSED);
        }
        super.onMeasure(i, i2);
        AppMethodBeat.o(27938);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(27939);
        ab.d("MicroMsg.ChatFooterBottom", "jacks onLayout change: %B, l:%d, t:%d, r:%d, b:%d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.o(27939);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(27940);
        super.onDraw(canvas);
        AppMethodBeat.o(27940);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(27941);
        ab.d("MicroMsg.ChatFooterBottom", "jacks onSizeChanged  w:%d, h:%d, oldw:%d, oldh:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        super.onSizeChanged(i, i2, i3, i4);
        AppMethodBeat.o(27941);
    }

    public void setIsHide(boolean z) {
        this.cPo = z;
    }

    public void setVisibility(int i) {
        AppMethodBeat.i(27942);
        if (i == 0) {
            this.cPo = false;
        }
        super.setVisibility(i);
        AppMethodBeat.o(27942);
    }

    public final boolean dkH() {
        AppMethodBeat.i(27943);
        if (this.cPo || getVisibility() == 8) {
            AppMethodBeat.o(27943);
            return true;
        }
        AppMethodBeat.o(27943);
        return false;
    }
}
