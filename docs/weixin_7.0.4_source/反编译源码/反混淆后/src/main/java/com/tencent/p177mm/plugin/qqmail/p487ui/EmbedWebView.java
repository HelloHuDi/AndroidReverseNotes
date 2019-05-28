package com.tencent.p177mm.plugin.qqmail.p487ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.qqmail.ui.EmbedWebView */
public class EmbedWebView extends MMWebView {
    private GestureDetector pxH = new GestureDetector(new C36561());
    private boolean pxI = false;
    private float[] pxJ = new float[2];
    private float[] pxK = new float[2];
    private float[] pxL = new float[2];
    private float[] pxM = new float[2];

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.EmbedWebView$1 */
    class C36561 extends SimpleOnGestureListener {
        C36561() {
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(68277);
            EmbedWebView embedWebView = EmbedWebView.this;
            C4990ab.m7410d("MicroMsg.EmbedWebView", "onDoubleTapm, before scale:" + embedWebView.getScale());
            int i = 10;
            while (embedWebView.getScale() != 1.0f) {
                i--;
                if (i <= 0) {
                    break;
                } else if (embedWebView.getScale() > 1.0f) {
                    embedWebView.zoomOut();
                } else {
                    embedWebView.zoomIn();
                }
            }
            C4990ab.m7410d("MicroMsg.EmbedWebView", "onDoubleTapm, after scale:" + EmbedWebView.this.getScale());
            AppMethodBeat.m2505o(68277);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.EmbedWebView$2 */
    class C36572 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.EmbedWebView$2$1 */
        class C36581 implements OnTouchListener {
            C36581() {
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.m2504i(68278);
                if (motionEvent.getPointerCount() == 2) {
                    EmbedWebView.this.onTouchEvent(motionEvent);
                }
                AppMethodBeat.m2505o(68278);
                return false;
            }
        }

        C36572() {
        }

        public final void run() {
            AppMethodBeat.m2504i(68279);
            View view = (View) EmbedWebView.this.getParent();
            if (view == null) {
                AppMethodBeat.m2505o(68279);
                return;
            }
            view = (View) view.getParent();
            if (view != null && (view instanceof ScrollView)) {
                EmbedWebView.this.pxI = true;
                view.setOnTouchListener(new C36581());
            }
            AppMethodBeat.m2505o(68279);
        }
    }

    public EmbedWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(68280);
        postDelayed(new C36572(), 100);
        AppMethodBeat.m2505o(68280);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        AppMethodBeat.m2504i(68281);
        this.pxH.onTouchEvent(motionEvent);
        if (this.pxI) {
            int action = motionEvent.getAction() & 255;
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount == 2) {
                switch (action) {
                    case 2:
                        for (action = 0; action < pointerCount; action++) {
                            this.pxL[action] = motionEvent.getX(action);
                            this.pxM[action] = motionEvent.getY(action);
                        }
                        float pow = (float) (Math.pow((double) (this.pxJ[1] - this.pxJ[0]), 2.0d) + Math.pow((double) (this.pxK[1] - this.pxK[0]), 2.0d));
                        float pow2 = (float) (Math.pow((double) (this.pxL[1] - this.pxL[0]), 2.0d) + Math.pow((double) (this.pxM[1] - this.pxM[0]), 2.0d));
                        if (pow - pow2 > 20000.0f) {
                            zoomOut();
                        } else if (pow2 - pow > 20000.0f) {
                            zoomIn();
                        }
                        this.pxJ[0] = this.pxL[0];
                        this.pxJ[1] = this.pxL[1];
                        this.pxK[0] = this.pxM[0];
                        this.pxK[1] = this.pxM[1];
                        break;
                    case 5:
                        while (i < pointerCount) {
                            this.pxJ[i] = motionEvent.getX(i);
                            this.pxK[i] = motionEvent.getY(i);
                            i++;
                        }
                        break;
                }
                i = 1;
            }
            if (i != 0) {
                AppMethodBeat.m2505o(68281);
                return true;
            }
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(68281);
        return onTouchEvent;
    }
}
