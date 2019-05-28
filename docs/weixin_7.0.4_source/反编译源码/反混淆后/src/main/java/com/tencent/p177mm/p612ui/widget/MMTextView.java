package com.tencent.p177mm.p612ui.widget;

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
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.widget.MMTextView */
public class MMTextView extends TextView {
    private long edW = -1;
    private C15988b zNj = null;
    private boolean zNk = false;
    private boolean zNl = false;
    private boolean zNm = false;
    private C15987a zNn = null;
    private boolean zhd = false;
    private GestureDetector zhe = null;

    /* renamed from: com.tencent.mm.ui.widget.MMTextView$a */
    public interface C15987a {
        /* renamed from: a */
        void mo10976a(CharSequence charSequence, long j);
    }

    /* renamed from: com.tencent.mm.ui.widget.MMTextView$b */
    public interface C15988b {
        /* renamed from: eL */
        boolean mo28264eL(View view);
    }

    /* renamed from: com.tencent.mm.ui.widget.MMTextView$1 */
    class C159891 extends SimpleOnGestureListener {
        C159891() {
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(107921);
            if (MMTextView.this.zNj == null) {
                AppMethodBeat.m2505o(107921);
                return false;
            }
            boolean eL = MMTextView.this.zNj.mo28264eL(MMTextView.this);
            AppMethodBeat.m2505o(107921);
            return eL;
        }
    }

    public void setMsgId(long j) {
        this.edW = j;
    }

    public MMTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(107922);
        init();
        AppMethodBeat.m2505o(107922);
    }

    public MMTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(107923);
        init();
        AppMethodBeat.m2505o(107923);
    }

    public void setMMTextViewCallBack(C15987a c15987a) {
        if (!this.zNm && c15987a != null) {
            this.zNn = c15987a;
            this.zNm = true;
        }
    }

    public void setIsFromChatting(boolean z) {
        if (!this.zNk) {
            this.zNk = z;
        }
    }

    private void init() {
        AppMethodBeat.m2504i(107924);
        this.zhe = new GestureDetector(getContext(), new C159891());
        AppMethodBeat.m2505o(107924);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        AppMethodBeat.m2504i(107925);
        int action = motionEvent.getAction();
        boolean z2 = action == 1 && this.zhd;
        if (z2) {
            C4990ab.m7410d("MicroMsg.MMTextView", "ignore Action Up Event this time");
            AppMethodBeat.m2505o(107925);
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
            AppMethodBeat.m2505o(107925);
        }
        return z;
    }

    public void setOnDoubleClickLitsener(C15988b c15988b) {
        this.zNj = c15988b;
    }

    public void setTextInternal(CharSequence charSequence) {
        AppMethodBeat.m2504i(107926);
        this.zNl = true;
        setText(charSequence);
        AppMethodBeat.m2505o(107926);
    }

    @Suppress
    public void setText(CharSequence charSequence, BufferType bufferType) {
        AppMethodBeat.m2504i(107927);
        super.setText(charSequence, bufferType);
        if (this.zNn != null && this.zNk && (charSequence instanceof Spannable) && ((Spannable) charSequence).getSpans(0, charSequence.length(), Object.class) != null) {
            this.zNn.mo10976a(charSequence, this.edW);
        }
        this.zNl = false;
        AppMethodBeat.m2505o(107927);
    }

    public void cancelLongPress() {
        AppMethodBeat.m2504i(107928);
        C4990ab.m7410d("MicroMsg.MMTextView", "cancelLongPress , should ignore Action Up Event next time");
        this.zhd = true;
        super.cancelLongPress();
        AppMethodBeat.m2505o(107928);
    }

    public boolean performLongClick() {
        AppMethodBeat.m2504i(107929);
        C4990ab.m7410d("MicroMsg.MMTextView", "performLongClick , should ignore Action Up Event next time");
        this.zhd = true;
        boolean performLongClick = super.performLongClick();
        AppMethodBeat.m2505o(107929);
        return performLongClick;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(107930);
        try {
            super.onMeasure(i, i2);
            AppMethodBeat.m2505o(107930);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.MMTextView", th, "", new Object[0]);
            AppMethodBeat.m2505o(107930);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(107931);
        try {
            super.onDraw(canvas);
            AppMethodBeat.m2505o(107931);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.MMTextView", th, "", new Object[0]);
            AppMethodBeat.m2505o(107931);
        }
    }

    public boolean onPreDraw() {
        AppMethodBeat.m2504i(107932);
        try {
            boolean onPreDraw = super.onPreDraw();
            AppMethodBeat.m2505o(107932);
            return onPreDraw;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(107932);
            return true;
        }
    }

    public int getBaseline() {
        AppMethodBeat.m2504i(107933);
        try {
            int baseline = super.getBaseline();
            AppMethodBeat.m2505o(107933);
            return baseline;
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.MMTextView", th, "", new Object[0]);
            AppMethodBeat.m2505o(107933);
            return -1;
        }
    }
}
