package com.tencent.p177mm.plugin.mmsight.p458ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.Log;

/* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView */
public class MMSightCaptureTouchView extends RelativeLayout {
    private float gMs;
    private int gMt;
    private GestureDetector lCs;
    private long oAE;
    private C43316a oAF;

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView$1 */
    class C213091 extends SimpleOnGestureListener {
        C213091() {
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(55073);
            Log.m9448i("MicroMsg.MMSightCaptureTouchView", "onSingleTapUp");
            if (MMSightCaptureTouchView.this.oAF != null) {
                MMSightCaptureTouchView.this.oAF.mo30817P(motionEvent.getX(), motionEvent.getY());
            }
            AppMethodBeat.m2505o(55073);
            return false;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(55074);
            Log.m9448i("MicroMsg.MMSightCaptureTouchView", "onDoubleTap");
            if (System.currentTimeMillis() - MMSightCaptureTouchView.this.oAE > 1000) {
                if (MMSightCaptureTouchView.this.oAF != null) {
                    MMSightCaptureTouchView.this.oAF.bnY();
                }
                MMSightCaptureTouchView.this.oAE = System.currentTimeMillis();
            }
            AppMethodBeat.m2505o(55074);
            return false;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(55075);
            Log.m9448i("MicroMsg.MMSightCaptureTouchView", "onSingleTapConfirmed");
            AppMethodBeat.m2505o(55075);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView$a */
    public interface C43316a {
        /* renamed from: P */
        void mo30817P(float f, float f2);

        void asx();

        void asy();

        void bnY();
    }

    public MMSightCaptureTouchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMSightCaptureTouchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(55076);
        this.oAE = 0;
        this.gMs = -1.0f;
        this.gMt = 0;
        this.lCs = new GestureDetector(getContext(), new C213091());
        this.lCs.setIsLongpressEnabled(false);
        AppMethodBeat.m2505o(55076);
    }

    public void setTouchCallback(C43316a c43316a) {
        this.oAF = c43316a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(55077);
        this.lCs.onTouchEvent(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                Log.m9442d("MicroMsg.MMSightCaptureTouchView", "ACTION_DOWN");
                this.gMs = -1.0f;
                this.gMt++;
                break;
            case 1:
                Log.m9442d("MicroMsg.MMSightCaptureTouchView", "ACTION_UP");
                this.gMs = -1.0f;
                this.gMt = 0;
                break;
            case 2:
                if (this.gMt >= 2) {
                    float x = m85903x(motionEvent);
                    Log.m9451v("MicroMsg.MMSightCaptureTouchView", "distance: %s", Float.valueOf(x));
                    if (x > 0.0f) {
                        if (this.gMs > 0.0f) {
                            if (Math.abs(x - this.gMs) > 15.0f) {
                                if (x > this.gMs) {
                                    Log.m9442d("MicroMsg.MMSightCaptureTouchView", "zoom out");
                                    if (this.oAF != null) {
                                        this.oAF.asx();
                                    }
                                } else {
                                    Log.m9442d("MicroMsg.MMSightCaptureTouchView", "zoom in");
                                    if (this.oAF != null) {
                                        this.oAF.asy();
                                    }
                                }
                            }
                        }
                        this.gMs = x;
                        break;
                    }
                }
                break;
            case 5:
                Log.m9442d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_DOWN");
                this.gMt++;
                break;
            case 6:
                Log.m9442d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_UP");
                this.gMt--;
                break;
        }
        AppMethodBeat.m2505o(55077);
        return true;
    }

    /* renamed from: x */
    private float m85903x(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(55078);
        try {
            if (this.gMt >= 2) {
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                x = Math.abs(x - motionEvent.getX(1)) + Math.abs(y - motionEvent.getY(1));
                AppMethodBeat.m2505o(55078);
                return x;
            }
        } catch (Exception e) {
            Log.m9445e("MicroMsg.MMSightCaptureTouchView", "pointerDistance error: %s", e.getMessage());
        }
        AppMethodBeat.m2505o(55078);
        return 0.0f;
    }
}
