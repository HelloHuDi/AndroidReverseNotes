package com.tencent.p177mm.blink;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.blink.FirstScreenFrameLayout */
public class FirstScreenFrameLayout extends FrameLayout {
    public C17991a ebs;

    /* renamed from: com.tencent.mm.blink.FirstScreenFrameLayout$1 */
    class C179901 implements Runnable {
        C179901() {
        }

        public final void run() {
            AppMethodBeat.m2504i(57720);
            if (FirstScreenFrameLayout.this.ebs != null) {
                FirstScreenFrameLayout.this.ebs.mo33533Ia();
                FirstScreenFrameLayout.this.ebs = null;
            }
            AppMethodBeat.m2505o(57720);
        }
    }

    /* renamed from: com.tencent.mm.blink.FirstScreenFrameLayout$a */
    public interface C17991a {
        /* renamed from: Ia */
        void mo33533Ia();
    }

    public FirstScreenFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FirstScreenFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.m2504i(57721);
        super.dispatchDraw(canvas);
        if (this.ebs != null) {
            new C7306ak(Looper.getMainLooper()).postAtFrontOfQueueV2(new C179901());
        }
        AppMethodBeat.m2505o(57721);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(57722);
        super.setPadding(i, i2, i3, i4);
        AppMethodBeat.m2505o(57722);
    }
}
