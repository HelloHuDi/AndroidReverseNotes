package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.test.suitebuilder.annotation.Suppress;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class MMTextView extends TextView {
    private long edW = -1;
    private b zNj = null;
    private boolean zNk = false;
    private boolean zNl = false;
    private boolean zNm = false;
    private a zNn = null;
    private boolean zhd = false;
    private GestureDetector zhe = null;

    public interface a {
        void a(CharSequence charSequence, long j);
    }

    public interface b {
        boolean eL(View view);
    }

    public void setMsgId(long j) {
        this.edW = j;
    }

    public MMTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(107922);
        init();
        AppMethodBeat.o(107922);
    }

    public MMTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107923);
        init();
        AppMethodBeat.o(107923);
    }

    public void setMMTextViewCallBack(a aVar) {
        if (!this.zNm && aVar != null) {
            this.zNn = aVar;
            this.zNm = true;
        }
    }

    public void setIsFromChatting(boolean z) {
        if (!this.zNk) {
            this.zNk = z;
        }
    }

    private void init() {
        AppMethodBeat.i(107924);
        this.zhe = new GestureDetector(getContext(), new SimpleOnGestureListener() {
            public final boolean onDoubleTap(MotionEvent motionEvent) {
                AppMethodBeat.i(107921);
                if (MMTextView.this.zNj == null) {
                    AppMethodBeat.o(107921);
                    return false;
                }
                boolean eL = MMTextView.this.zNj.eL(MMTextView.this);
                AppMethodBeat.o(107921);
                return eL;
            }
        });
        AppMethodBeat.o(107924);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        AppMethodBeat.i(107925);
        int action = motionEvent.getAction();
        boolean z2 = action == 1 && this.zhd;
        if (z2) {
            ab.d("MicroMsg.MMTextView", "ignore Action Up Event this time");
            AppMethodBeat.o(107925);
        } else {
            if (action == 0) {
                this.zhd = false;
            }
            if (this.zNj == null || this.zhe == null) {
                z = false;
            } else {
                z = this.zhe.onTouchEvent(motionEvent);
            }
            if (!z) {
                z = super.onTouchEvent(motionEvent);
            }
            AppMethodBeat.o(107925);
        }
        return z;
    }

    public void setOnDoubleClickLitsener(b bVar) {
        this.zNj = bVar;
    }

    public void setTextInternal(CharSequence charSequence) {
        AppMethodBeat.i(107926);
        this.zNl = true;
        setText(charSequence);
        AppMethodBeat.o(107926);
    }

    @Suppress
    public void setText(CharSequence charSequence, BufferType bufferType) {
        AppMethodBeat.i(107927);
        super.setText(charSequence, bufferType);
        if (this.zNn != null && this.zNk && (charSequence instanceof Spannable) && ((Spannable) charSequence).getSpans(0, charSequence.length(), Object.class) != null) {
            this.zNn.a(charSequence, this.edW);
        }
        this.zNl = false;
        AppMethodBeat.o(107927);
    }

    public void cancelLongPress() {
        AppMethodBeat.i(107928);
        ab.d("MicroMsg.MMTextView", "cancelLongPress , should ignore Action Up Event next time");
        this.zhd = true;
        super.cancelLongPress();
        AppMethodBeat.o(107928);
    }

    public boolean performLongClick() {
        AppMethodBeat.i(107929);
        ab.d("MicroMsg.MMTextView", "performLongClick , should ignore Action Up Event next time");
        this.zhd = true;
        boolean performLongClick = super.performLongClick();
        AppMethodBeat.o(107929);
        return performLongClick;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(107930);
        try {
            super.onMeasure(i, i2);
            AppMethodBeat.o(107930);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.MMTextView", th, "", new Object[0]);
            AppMethodBeat.o(107930);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(107931);
        try {
            super.onDraw(canvas);
            AppMethodBeat.o(107931);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.MMTextView", th, "", new Object[0]);
            AppMethodBeat.o(107931);
        }
    }

    public boolean onPreDraw() {
        AppMethodBeat.i(107932);
        try {
            boolean onPreDraw = super.onPreDraw();
            AppMethodBeat.o(107932);
            return onPreDraw;
        } catch (Throwable th) {
            AppMethodBeat.o(107932);
            return true;
        }
    }

    public int getBaseline() {
        AppMethodBeat.i(107933);
        try {
            int baseline = super.getBaseline();
            AppMethodBeat.o(107933);
            return baseline;
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.MMTextView", th, "", new Object[0]);
            AppMethodBeat.o(107933);
            return -1;
        }
    }
}
