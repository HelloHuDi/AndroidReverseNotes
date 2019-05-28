package com.tencent.p177mm.plugin.api.recordView;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.api.recordView.g */
final class C33059g implements OnTouchListener {
    private long gMr = -1;
    private float gMs = -1.0f;
    private int gMt = 0;
    C33060a gMu;

    /* renamed from: com.tencent.mm.plugin.api.recordView.g$a */
    public interface C33060a {
        void asw();

        void asx();

        void asy();
    }

    C33059g() {
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(76384);
        switch (motionEvent.getAction() & 255) {
            case 0:
                C4990ab.m7410d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_DOWN");
                if (this.gMr <= 0 || SystemClock.elapsedRealtime() - this.gMr >= 400) {
                    if (this.gMu != null) {
                        C33060a c33060a = this.gMu;
                        motionEvent.getX();
                        motionEvent.getY();
                        c33060a.asw();
                    }
                } else if (this.gMu != null) {
                }
                this.gMr = SystemClock.elapsedRealtime();
                this.gMs = -1.0f;
                this.gMt++;
                break;
            case 1:
                C4990ab.m7410d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_UP");
                this.gMs = -1.0f;
                this.gMt = 0;
                break;
            case 2:
                if (this.gMt >= 2) {
                    float x = m54046x(motionEvent);
                    C4990ab.m7419v("MicroMsg.MMSightRecordViewTouchListener", "distance: %s", Float.valueOf(x));
                    if (x > 0.0f) {
                        if (this.gMs > 0.0f) {
                            if (Math.abs(x - this.gMs) > 15.0f) {
                                if (x > this.gMs) {
                                    C4990ab.m7410d("MicroMsg.MMSightRecordViewTouchListener", "zoom out");
                                    if (this.gMu != null) {
                                        this.gMu.asx();
                                    }
                                } else {
                                    C4990ab.m7410d("MicroMsg.MMSightRecordViewTouchListener", "zoom in");
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
                C4990ab.m7410d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_DOWN");
                this.gMt++;
                break;
            case 6:
                C4990ab.m7410d("MicroMsg.MMSightRecordViewTouchListener", "ACTION_POINTER_UP");
                this.gMt--;
                break;
        }
        AppMethodBeat.m2505o(76384);
        return true;
    }

    /* renamed from: x */
    private float m54046x(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(76385);
        try {
            if (this.gMt >= 2) {
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                x = Math.abs(x - motionEvent.getX(1)) + Math.abs(y - motionEvent.getY(1));
                AppMethodBeat.m2505o(76385);
                return x;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMSightRecordViewTouchListener", "pointerDistance error: %s", e.getMessage());
        }
        AppMethodBeat.m2505o(76385);
        return 0.0f;
    }
}
