package com.tencent.p177mm.plugin.appbrand.debugger;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView */
public class RemoteDebugMoveView extends FrameLayout {
    int hkc;
    int hkd;
    float hke;
    float hkf;
    float hkg;
    float hkh;

    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView$1 */
    class C21201 implements Runnable {
        C21201() {
        }

        public final void run() {
            AppMethodBeat.m2504i(101851);
            RemoteDebugMoveView.this.setX((float) (RemoteDebugMoveView.this.hkc - RemoteDebugMoveView.m83978b(RemoteDebugMoveView.this)));
            RemoteDebugMoveView.this.setY((float) ((int) (C1338a.getDensity(C4996ah.getContext()) * 120.0f)));
            AppMethodBeat.m2505o(101851);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView$3 */
    class C21213 implements Runnable {
        C21213() {
        }

        public final void run() {
            AppMethodBeat.m2504i(101854);
            if (RemoteDebugMoveView.this.getY() + ((float) RemoteDebugMoveView.this.getHeight()) > ((float) RemoteDebugMoveView.this.hkd)) {
                RemoteDebugMoveView.this.setY((float) (RemoteDebugMoveView.this.hkd - RemoteDebugMoveView.this.getHeight()));
            }
            AppMethodBeat.m2505o(101854);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView$2 */
    class C101842 implements OnGlobalLayoutListener {
        private int counter = 0;

        /* renamed from: com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView$2$1 */
        class C101851 implements Runnable {
            C101851() {
            }

            public final void run() {
                AppMethodBeat.m2504i(101852);
                if (RemoteDebugMoveView.this.getParent() instanceof View) {
                    View view = (View) RemoteDebugMoveView.this.getParent();
                    RemoteDebugMoveView.this.hkc = view.getMeasuredWidth();
                    RemoteDebugMoveView.this.hkd = view.getMeasuredHeight();
                    float max = Math.max(0.0f, Math.min((float) (RemoteDebugMoveView.this.hkc - RemoteDebugMoveView.this.getWidth()), RemoteDebugMoveView.this.getX()));
                    float max2 = Math.max(0.0f, Math.min((float) (RemoteDebugMoveView.this.hkd - RemoteDebugMoveView.this.getHeight()), RemoteDebugMoveView.this.getY()));
                    RemoteDebugMoveView.this.setX(max);
                    RemoteDebugMoveView.this.setY(max2);
                    RemoteDebugMoveView.this.requestLayout();
                }
                AppMethodBeat.m2505o(101852);
            }
        }

        C101842() {
        }

        public final void onGlobalLayout() {
            AppMethodBeat.m2504i(101853);
            int i = this.counter + 1;
            this.counter = i;
            if (i < 2) {
                AppMethodBeat.m2505o(101853);
                return;
            }
            RemoteDebugMoveView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            RemoteDebugMoveView.this.post(new C101851());
            AppMethodBeat.m2505o(101853);
        }
    }

    public RemoteDebugMoveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RemoteDebugMoveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(101855);
        super.onConfigurationChanged(configuration);
        getViewTreeObserver().addOnGlobalLayoutListener(new C101842());
        AppMethodBeat.m2505o(101855);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(101856);
        switch (motionEvent.getAction()) {
            case 0:
                this.hke = motionEvent.getRawX();
                this.hkf = motionEvent.getRawY();
                break;
            case 2:
                this.hkg = motionEvent.getRawX();
                this.hkh = motionEvent.getRawY();
                float x = getX() + (this.hkg - this.hke);
                if (0.0f < x && x < ((float) (this.hkc - getWidth()))) {
                    setX(x);
                }
                x = this.hkh - this.hkf;
                float height = (float) (this.hkd - getHeight());
                float y = getY() + x;
                if ((0.0f < y && y < height) || ((y <= 0.0f && x > 0.0f) || (y >= height && x < 0.0f))) {
                    setY(y);
                }
                this.hke = this.hkg;
                this.hkf = this.hkh;
                break;
        }
        AppMethodBeat.m2505o(101856);
        return true;
    }

    /* renamed from: b */
    static /* synthetic */ int m83978b(RemoteDebugMoveView remoteDebugMoveView) {
        AppMethodBeat.m2504i(101857);
        int width = remoteDebugMoveView.getWidth();
        if (width > 0) {
            AppMethodBeat.m2505o(101857);
            return width;
        }
        width = C1338a.fromDPToPix(remoteDebugMoveView.getContext(), 200);
        AppMethodBeat.m2505o(101857);
        return width;
    }
}
