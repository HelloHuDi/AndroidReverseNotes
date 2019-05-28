package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

public class DrawnCallBackLinearLayout extends LinearLayout {
    public final boolean DEBUG = true;
    public final String TAG = "MicroMsg.TestTimeForChatting";
    private a zLR;
    private b zLS;

    public interface a {
        void dEX();
    }

    public interface b {
    }

    public DrawnCallBackLinearLayout(Context context) {
        super(context);
    }

    public DrawnCallBackLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @TargetApi(11)
    public DrawnCallBackLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(107843);
        if (this.zLS != null) {
            this.zLS = null;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(107843);
        return dispatchTouchEvent;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(107844);
        long currentTimeMillis = System.currentTimeMillis();
        super.onLayout(z, i, i2, i3, i4);
        Log.i("MicroMsg.TestTimeForChatting", "[onLayout] " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(107844);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(107845);
        super.dispatchDraw(canvas);
        if (this.zLR != null) {
            this.zLR.dEX();
            this.zLR = null;
        }
        AppMethodBeat.o(107845);
    }

    public void setListener(a aVar) {
        this.zLR = aVar;
    }

    public void setTouchedCallback(b bVar) {
        this.zLS = bVar;
    }
}
