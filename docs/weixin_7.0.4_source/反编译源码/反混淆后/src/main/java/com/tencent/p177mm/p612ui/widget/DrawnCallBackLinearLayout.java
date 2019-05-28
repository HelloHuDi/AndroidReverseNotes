package com.tencent.p177mm.p612ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

/* renamed from: com.tencent.mm.ui.widget.DrawnCallBackLinearLayout */
public class DrawnCallBackLinearLayout extends LinearLayout {
    public final boolean DEBUG = true;
    public final String TAG = "MicroMsg.TestTimeForChatting";
    private C24083a zLR;
    private C30794b zLS;

    /* renamed from: com.tencent.mm.ui.widget.DrawnCallBackLinearLayout$a */
    public interface C24083a {
        void dEX();
    }

    /* renamed from: com.tencent.mm.ui.widget.DrawnCallBackLinearLayout$b */
    public interface C30794b {
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
        AppMethodBeat.m2504i(107843);
        if (this.zLS != null) {
            this.zLS = null;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(107843);
        return dispatchTouchEvent;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(107844);
        long currentTimeMillis = System.currentTimeMillis();
        super.onLayout(z, i, i2, i3, i4);
        Log.m81049i("MicroMsg.TestTimeForChatting", "[onLayout] " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(107844);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.m2504i(107845);
        super.dispatchDraw(canvas);
        if (this.zLR != null) {
            this.zLR.dEX();
            this.zLR = null;
        }
        AppMethodBeat.m2505o(107845);
    }

    public void setListener(C24083a c24083a) {
        this.zLR = c24083a;
    }

    public void setTouchedCallback(C30794b c30794b) {
        this.zLS = c30794b;
    }
}
