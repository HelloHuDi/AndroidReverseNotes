package com.tencent.mm.plugin.api.recordView;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class g implements OnTouchListener {
    private long gMr = -1;
    private float gMs = -1.0f;
    private int gMt = 0;
    a gMu;

    public interface a {
        void asw();

        void asx();

        void asy();
    }

    g() {
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(76384);
        switch (motionEvent.getAction() & 255) {
            case 0:
                ab.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_DOWN");
                if (this.gMr <= 0 || SystemClock.elapsedRealtime() - this.gMr >= 400) {
                    if (this.gMu != null) {
                        a aVar = this.gMu;
                        motionEvent.getX();
                        motionEvent.getY();
                        aVar.asw();
                    }
                } else if (this.gMu != null) {
                }
                this.gMr = SystemClock.elapsedRealtime();
                this.gMs = -1.0f;
                this.gMt++;
                break;
            case 1:
                ab.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_UP");
                this.gMs = -1.0f;
                this.gMt = 0;
                break;
            case 2:
                if (this.gMt >= 2) {
                    float x = x(motionEvent);
                    ab.v("MicroMsg.MMSightRecordViewTouchListener", "distance: %s", Float.valueOf(x));
                    if (x > 0.0f) {
                        if (this.gMs > 0.0f) {
                            if (Math.abs(x - this.gMs) > 15.0f) {
                                if (x > this.gMs) {
                                    ab.d("MicroMsg.MMSightRecordViewTouchListener", "zoom out");
                                    if (this.gMu != null) {
                                        this.gMu.asx();
                                    }
                                } else {
                                    ab.d("MicroMsg.MMSightRecordViewTouchListener", "zoom in");
                                    if (this.gMu != null) {
                                        this.gMu.asy();
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
                ab.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_DOWN");
                this.gMt++;
                break;
            case 6:
                ab.d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_UP");
                this.gMt--;
                break;
        }
        AppMethodBeat.o(76384);
        return true;
    }

    private float x(MotionEvent motionEvent) {
        AppMethodBeat.i(76385);
        try {
            if (this.gMt >= 2) {
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                x = Math.abs(x - motionEvent.getX(1)) + Math.abs(y - motionEvent.getY(1));
                AppMethodBeat.o(76385);
                return x;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.MMSightRecordViewTouchListener", "pointerDistance error: %s", e.getMessage());
        }
        AppMethodBeat.o(76385);
        return 0.0f;
    }
}
