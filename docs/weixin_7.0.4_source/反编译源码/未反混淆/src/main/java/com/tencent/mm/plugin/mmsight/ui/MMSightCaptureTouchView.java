package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.Log;

public class MMSightCaptureTouchView extends RelativeLayout {
    private float gMs;
    private int gMt;
    private GestureDetector lCs;
    private long oAE;
    private a oAF;

    public interface a {
        void P(float f, float f2);

        void asx();

        void asy();

        void bnY();
    }

    public MMSightCaptureTouchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMSightCaptureTouchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(55076);
        this.oAE = 0;
        this.gMs = -1.0f;
        this.gMt = 0;
        this.lCs = new GestureDetector(getContext(), new SimpleOnGestureListener() {
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                AppMethodBeat.i(55073);
                Log.i("MicroMsg.MMSightCaptureTouchView", "onSingleTapUp");
                if (MMSightCaptureTouchView.this.oAF != null) {
                    MMSightCaptureTouchView.this.oAF.P(motionEvent.getX(), motionEvent.getY());
                }
                AppMethodBeat.o(55073);
                return false;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                AppMethodBeat.i(55074);
                Log.i("MicroMsg.MMSightCaptureTouchView", "onDoubleTap");
                if (System.currentTimeMillis() - MMSightCaptureTouchView.this.oAE > 1000) {
                    if (MMSightCaptureTouchView.this.oAF != null) {
                        MMSightCaptureTouchView.this.oAF.bnY();
                    }
                    MMSightCaptureTouchView.this.oAE = System.currentTimeMillis();
                }
                AppMethodBeat.o(55074);
                return false;
            }

            public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                AppMethodBeat.i(55075);
                Log.i("MicroMsg.MMSightCaptureTouchView", "onSingleTapConfirmed");
                AppMethodBeat.o(55075);
                return true;
            }
        });
        this.lCs.setIsLongpressEnabled(false);
        AppMethodBeat.o(55076);
    }

    public void setTouchCallback(a aVar) {
        this.oAF = aVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(55077);
        this.lCs.onTouchEvent(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_DOWN");
                this.gMs = -1.0f;
                this.gMt++;
                break;
            case 1:
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_UP");
                this.gMs = -1.0f;
                this.gMt = 0;
                break;
            case 2:
                if (this.gMt >= 2) {
                    float x = x(motionEvent);
                    Log.v("MicroMsg.MMSightCaptureTouchView", "distance: %s", Float.valueOf(x));
                    if (x > 0.0f) {
                        if (this.gMs > 0.0f) {
                            if (Math.abs(x - this.gMs) > 15.0f) {
                                if (x > this.gMs) {
                                    Log.d("MicroMsg.MMSightCaptureTouchView", "zoom out");
                                    if (this.oAF != null) {
                                        this.oAF.asx();
                                    }
                                } else {
                                    Log.d("MicroMsg.MMSightCaptureTouchView", "zoom in");
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
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_DOWN");
                this.gMt++;
                break;
            case 6:
                Log.d("MicroMsg.MMSightCaptureTouchView", "ACTION_POINTER_UP");
                this.gMt--;
                break;
        }
        AppMethodBeat.o(55077);
        return true;
    }

    private float x(MotionEvent motionEvent) {
        AppMethodBeat.i(55078);
        try {
            if (this.gMt >= 2) {
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                x = Math.abs(x - motionEvent.getX(1)) + Math.abs(y - motionEvent.getY(1));
                AppMethodBeat.o(55078);
                return x;
            }
        } catch (Exception e) {
            Log.e("MicroMsg.MMSightCaptureTouchView", "pointerDistance error: %s", e.getMessage());
        }
        AppMethodBeat.o(55078);
        return 0.0f;
    }
}
