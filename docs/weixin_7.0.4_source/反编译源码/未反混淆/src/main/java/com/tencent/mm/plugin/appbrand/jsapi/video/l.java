package com.tencent.mm.plugin.appbrand.jsapi.video;

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

public final class l {
    int JB = 0;
    float hXK = 0.0f;
    private float iaA = 0.0f;
    int iaB = -1;
    int iaC = 0;
    Runnable iaD = new Runnable() {
        public final void run() {
            AppMethodBeat.i(126580);
            l.this.iaz.aFi();
            AppMethodBeat.o(126580);
        }
    };
    View iaw;
    a iax = a.None;
    private GestureDetector iay;
    b iaz;
    Context mContext;

    enum a {
        None,
        Volume,
        Brightness,
        FastBackwardOrForward;

        static {
            AppMethodBeat.o(126586);
        }
    }

    public interface b {
        void aFi();

        void aFj();

        void aFk();

        void aFl();

        void aFm();

        boolean aFn();

        boolean aFo();

        boolean aFp();

        void aq(float f);

        void ar(float f);

        int getCurrentPosition();

        int i(int i, float f);

        void j(int i, float f);
    }

    public l(Context context, View view, b bVar) {
        AppMethodBeat.i(126587);
        this.mContext = context;
        this.iaz = bVar;
        this.iaw = view;
        this.iay = new GestureDetector(this.mContext, new SimpleOnGestureListener() {
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                AppMethodBeat.i(126581);
                l.this.iaw.postDelayed(l.this.iaD, 200);
                AppMethodBeat.o(126581);
                return true;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                AppMethodBeat.i(126582);
                l.this.iaw.removeCallbacks(l.this.iaD);
                l.this.iaz.aFj();
                AppMethodBeat.o(126582);
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:61:0x0160  */
            /* JADX WARNING: Removed duplicated region for block: B:56:0x0148  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                float f3 = 1.0f;
                float f4 = 0.0f;
                AppMethodBeat.i(126583);
                if (motionEvent == null || motionEvent2 == null) {
                    AppMethodBeat.o(126583);
                    return true;
                }
                if (l.this.iax == a.None) {
                    if (Math.abs(f) > Math.abs(f2)) {
                        l.this.iax = a.FastBackwardOrForward;
                    } else if (motionEvent.getX() < ((float) (l.this.iaw.getMeasuredWidth() / 2))) {
                        l.this.iax = a.Brightness;
                    } else {
                        l.this.iax = a.Volume;
                    }
                }
                float x = motionEvent2.getX() - motionEvent.getX();
                float y = motionEvent2.getY() - motionEvent.getY();
                l lVar = l.this;
                if (lVar.iax == a.FastBackwardOrForward) {
                    if (lVar.iaz.aFp()) {
                        if (lVar.iaB == -1) {
                            lVar.iaz.aFk();
                            lVar.iaB = lVar.iaz.getCurrentPosition();
                        }
                        lVar.iaC = lVar.iaz.i(lVar.iaB, x);
                        AppMethodBeat.o(126583);
                        return true;
                    }
                    AppMethodBeat.o(126583);
                    return false;
                } else if (lVar.iax == a.Brightness) {
                    if (lVar.iaz.aFn()) {
                        x = (((-1.0f * y) / ((float) lVar.iaw.getMeasuredHeight())) * 1.2f) + lVar.hXK;
                        if (x >= 0.0f) {
                            if (x > 1.0f) {
                                f4 = 1.0f;
                            } else {
                                f4 = x;
                            }
                        }
                        Context context = lVar.mContext;
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
                        lVar.iaz.ar(f4);
                        AppMethodBeat.o(126583);
                        return true;
                    }
                    AppMethodBeat.o(126583);
                    return false;
                } else if (lVar.iax != a.Volume) {
                    AppMethodBeat.o(126583);
                    return true;
                } else if (lVar.iaz.aFo()) {
                    int i;
                    float f5 = y * -1.0f;
                    f3 = f5 / ((float) lVar.iaw.getMeasuredHeight());
                    AudioManager audioManager = (AudioManager) lVar.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                    int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                    float f6 = 1.2f * (f3 * ((float) streamMaxVolume));
                    int i2 = (int) f6;
                    if (i2 == 0 && Math.abs(f6) > 0.2f) {
                        if (f5 > 0.0f) {
                            i = 1;
                        } else if (f5 < 0.0f) {
                            i = -1;
                        }
                        i += lVar.JB;
                        if (i >= 0) {
                            i = 0;
                        } else if (i >= streamMaxVolume) {
                            i = streamMaxVolume;
                        }
                        com.tencent.mm.compatible.b.a.b(audioManager, 3, i);
                        lVar.iaz.aq(((float) i) / ((float) streamMaxVolume));
                        AppMethodBeat.o(126583);
                        return true;
                    }
                    i = i2;
                    i += lVar.JB;
                    if (i >= 0) {
                    }
                    com.tencent.mm.compatible.b.a.b(audioManager, 3, i);
                    lVar.iaz.aq(((float) i) / ((float) streamMaxVolume));
                    AppMethodBeat.o(126583);
                    return true;
                } else {
                    AppMethodBeat.o(126583);
                    return false;
                }
            }
        });
        this.hXK = m.cN(context);
        AppMethodBeat.o(126587);
    }

    public final void z(MotionEvent motionEvent) {
        AppMethodBeat.i(126588);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.iaA = motionEvent.getRawX();
            aFZ();
        }
        this.iay.onTouchEvent(motionEvent);
        if (actionMasked == 1 || actionMasked == 3) {
            if (this.iax == a.FastBackwardOrForward) {
                this.iaz.j(this.iaC, motionEvent.getRawX() - this.iaA);
                this.iaB = -1;
                this.iaC = 0;
                this.iaA = 0.0f;
            } else if (this.iax == a.Volume) {
                ((AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamMaxVolume(3);
                this.iaz.aFl();
            } else if (this.iax == a.Brightness) {
                this.iaz.aFm();
            }
            this.iax = a.None;
        }
        AppMethodBeat.o(126588);
    }

    public final void aFY() {
        this.iaB = -1;
        this.iaC = 0;
        this.iaA = 0.0f;
    }

    private void aFZ() {
        AppMethodBeat.i(126589);
        this.JB = ((AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
        this.hXK = m.cN(this.mContext);
        AppMethodBeat.o(126589);
    }
}
