package com.tencent.p177mm.plugin.appbrand.jsapi.video;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C1397a;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.l */
public final class C33414l {
    /* renamed from: JB */
    int f15034JB = 0;
    float hXK = 0.0f;
    private float iaA = 0.0f;
    int iaB = -1;
    int iaC = 0;
    Runnable iaD = new C334151();
    View iaw;
    C19521a iax = C19521a.None;
    private GestureDetector iay;
    C33416b iaz;
    Context mContext;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.l$a */
    enum C19521a {
        None,
        Volume,
        Brightness,
        FastBackwardOrForward;

        static {
            AppMethodBeat.m2505o(126586);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.l$2 */
    class C334132 extends SimpleOnGestureListener {
        C334132() {
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(126581);
            C33414l.this.iaw.postDelayed(C33414l.this.iaD, 200);
            AppMethodBeat.m2505o(126581);
            return true;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(126582);
            C33414l.this.iaw.removeCallbacks(C33414l.this.iaD);
            C33414l.this.iaz.aFj();
            AppMethodBeat.m2505o(126582);
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:61:0x0160  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x0148  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            float f3 = 1.0f;
            float f4 = 0.0f;
            AppMethodBeat.m2504i(126583);
            if (motionEvent == null || motionEvent2 == null) {
                AppMethodBeat.m2505o(126583);
                return true;
            }
            if (C33414l.this.iax == C19521a.None) {
                if (Math.abs(f) > Math.abs(f2)) {
                    C33414l.this.iax = C19521a.FastBackwardOrForward;
                } else if (motionEvent.getX() < ((float) (C33414l.this.iaw.getMeasuredWidth() / 2))) {
                    C33414l.this.iax = C19521a.Brightness;
                } else {
                    C33414l.this.iax = C19521a.Volume;
                }
            }
            float x = motionEvent2.getX() - motionEvent.getX();
            float y = motionEvent2.getY() - motionEvent.getY();
            C33414l c33414l = C33414l.this;
            if (c33414l.iax == C19521a.FastBackwardOrForward) {
                if (c33414l.iaz.aFp()) {
                    if (c33414l.iaB == -1) {
                        c33414l.iaz.aFk();
                        c33414l.iaB = c33414l.iaz.getCurrentPosition();
                    }
                    c33414l.iaC = c33414l.iaz.mo34699i(c33414l.iaB, x);
                    AppMethodBeat.m2505o(126583);
                    return true;
                }
                AppMethodBeat.m2505o(126583);
                return false;
            } else if (c33414l.iax == C19521a.Brightness) {
                if (c33414l.iaz.aFn()) {
                    x = (((-1.0f * y) / ((float) c33414l.iaw.getMeasuredHeight())) * 1.2f) + c33414l.hXK;
                    if (x >= 0.0f) {
                        if (x > 1.0f) {
                            f4 = 1.0f;
                        } else {
                            f4 = x;
                        }
                    }
                    Context context = c33414l.mContext;
                    if (context instanceof Activity) {
                        if (f4 < 0.01f) {
                            f3 = 0.01f;
                        } else if (f4 <= 1.0f) {
                            f3 = f4;
                        }
                        Activity activity = (Activity) context;
                        LayoutParams attributes = activity.getWindow().getAttributes();
                        attributes.screenBrightness = f3;
                        activity.getWindow().setAttributes(attributes);
                    }
                    c33414l.iaz.mo34697ar(f4);
                    AppMethodBeat.m2505o(126583);
                    return true;
                }
                AppMethodBeat.m2505o(126583);
                return false;
            } else if (c33414l.iax != C19521a.Volume) {
                AppMethodBeat.m2505o(126583);
                return true;
            } else if (c33414l.iaz.aFo()) {
                int i;
                float f5 = y * -1.0f;
                f3 = f5 / ((float) c33414l.iaw.getMeasuredHeight());
                AudioManager audioManager = (AudioManager) c33414l.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                float f6 = 1.2f * (f3 * ((float) streamMaxVolume));
                int i2 = (int) f6;
                if (i2 == 0 && Math.abs(f6) > 0.2f) {
                    if (f5 > 0.0f) {
                        i = 1;
                    } else if (f5 < 0.0f) {
                        i = -1;
                    }
                    i += c33414l.f15034JB;
                    if (i >= 0) {
                        i = 0;
                    } else if (i >= streamMaxVolume) {
                        i = streamMaxVolume;
                    }
                    C1397a.m2944b(audioManager, 3, i);
                    c33414l.iaz.mo34696aq(((float) i) / ((float) streamMaxVolume));
                    AppMethodBeat.m2505o(126583);
                    return true;
                }
                i = i2;
                i += c33414l.f15034JB;
                if (i >= 0) {
                }
                C1397a.m2944b(audioManager, 3, i);
                c33414l.iaz.mo34696aq(((float) i) / ((float) streamMaxVolume));
                AppMethodBeat.m2505o(126583);
                return true;
            } else {
                AppMethodBeat.m2505o(126583);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.l$1 */
    class C334151 implements Runnable {
        C334151() {
        }

        public final void run() {
            AppMethodBeat.m2504i(126580);
            C33414l.this.iaz.aFi();
            AppMethodBeat.m2505o(126580);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.l$b */
    public interface C33416b {
        void aFi();

        void aFj();

        void aFk();

        void aFl();

        void aFm();

        boolean aFn();

        boolean aFo();

        boolean aFp();

        /* renamed from: aq */
        void mo34696aq(float f);

        /* renamed from: ar */
        void mo34697ar(float f);

        int getCurrentPosition();

        /* renamed from: i */
        int mo34699i(int i, float f);

        /* renamed from: j */
        void mo34700j(int i, float f);
    }

    public C33414l(Context context, View view, C33416b c33416b) {
        AppMethodBeat.m2504i(126587);
        this.mContext = context;
        this.iaz = c33416b;
        this.iaw = view;
        this.iay = new GestureDetector(this.mContext, new C334132());
        this.hXK = C33417m.m54608cN(context);
        AppMethodBeat.m2505o(126587);
    }

    /* renamed from: z */
    public final void mo53904z(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(126588);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.iaA = motionEvent.getRawX();
            aFZ();
        }
        this.iay.onTouchEvent(motionEvent);
        if (actionMasked == 1 || actionMasked == 3) {
            if (this.iax == C19521a.FastBackwardOrForward) {
                this.iaz.mo34700j(this.iaC, motionEvent.getRawX() - this.iaA);
                this.iaB = -1;
                this.iaC = 0;
                this.iaA = 0.0f;
            } else if (this.iax == C19521a.Volume) {
                ((AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamMaxVolume(3);
                this.iaz.aFl();
            } else if (this.iax == C19521a.Brightness) {
                this.iaz.aFm();
            }
            this.iax = C19521a.None;
        }
        AppMethodBeat.m2505o(126588);
    }

    public final void aFY() {
        this.iaB = -1;
        this.iaC = 0;
        this.iaA = 0.0f;
    }

    private void aFZ() {
        AppMethodBeat.m2504i(126589);
        this.f15034JB = ((AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
        this.hXK = C33417m.m54608cN(this.mContext);
        AppMethodBeat.m2505o(126589);
    }
}
