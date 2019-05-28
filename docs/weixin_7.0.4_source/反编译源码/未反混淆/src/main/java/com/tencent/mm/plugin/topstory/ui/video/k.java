package com.tencent.mm.plugin.topstory.ui.video;

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

public final class k {
    int JB = 0;
    float hXK = 0.0f;
    private float iaA = 0.0f;
    int iaB = -1;
    int iaC = 0;
    Runnable iaD = new Runnable() {
        public final void run() {
            AppMethodBeat.i(1732);
            k.this.sED.aFi();
            AppMethodBeat.o(1732);
        }
    };
    View iaw;
    private GestureDetector iay;
    Context mContext;
    a sEC = a.None;
    c sED;
    boolean sEE;
    boolean sEF;

    enum a {
        None,
        Volume,
        Brightness,
        FastBackwardOrForward;

        static {
            AppMethodBeat.o(1738);
        }
    }

    public k(Context context, View view, c cVar) {
        AppMethodBeat.i(1739);
        this.mContext = context;
        this.sED = cVar;
        this.iaw = view;
        this.iay = new GestureDetector(this.mContext, new SimpleOnGestureListener() {
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                AppMethodBeat.i(1733);
                k.this.iaw.postDelayed(k.this.iaD, 200);
                AppMethodBeat.o(1733);
                return true;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                AppMethodBeat.i(1734);
                k.this.iaw.removeCallbacks(k.this.iaD);
                k.this.sED.aFj();
                AppMethodBeat.o(1734);
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:58:0x0129  */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x011c  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                float f3 = 1.0f;
                float f4 = 0.0f;
                AppMethodBeat.i(1735);
                if (motionEvent == null || motionEvent2 == null) {
                    AppMethodBeat.o(1735);
                } else {
                    if (k.this.sEC == a.None) {
                        if (Math.abs(f) > Math.abs(f2)) {
                            k.this.sEC = a.FastBackwardOrForward;
                        } else if (motionEvent.getX() < ((float) (k.this.iaw.getMeasuredWidth() / 2))) {
                            k.this.sEC = a.Brightness;
                        } else {
                            k.this.sEC = a.Volume;
                        }
                    }
                    float x = motionEvent2.getX() - motionEvent.getX();
                    float y = motionEvent2.getY() - motionEvent.getY();
                    k kVar = k.this;
                    if (kVar.sEC == a.FastBackwardOrForward) {
                        if (kVar.iaB == -1) {
                            kVar.sED.aFk();
                            kVar.iaB = kVar.sED.getCurrentPosition();
                        }
                        kVar.iaC = kVar.sED.be(x);
                    } else if (kVar.sEC == a.Brightness && kVar.sEF) {
                        x = (((y * -1.0f) / ((float) kVar.iaw.getMeasuredHeight())) * 1.2f) + kVar.hXK;
                        if (x >= 0.0f) {
                            if (x > 1.0f) {
                                f4 = 1.0f;
                            } else {
                                f4 = x;
                            }
                        }
                        Context context = kVar.mContext;
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
                        AppMethodBeat.o(1735);
                    } else if (kVar.sEC == a.Volume && kVar.sEE) {
                        int i;
                        float f5 = y * -1.0f;
                        f3 = f5 / ((float) kVar.iaw.getMeasuredHeight());
                        AudioManager audioManager = (AudioManager) kVar.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                        float f6 = 1.2f * (f3 * ((float) streamMaxVolume));
                        int i2 = (int) f6;
                        if (i2 == 0 && Math.abs(f6) > 0.2f) {
                            if (f5 > 0.0f) {
                                i = 1;
                            } else if (f5 < 0.0f) {
                                i = -1;
                            }
                            i += kVar.JB;
                            if (i >= 0) {
                                i = 0;
                            } else if (i >= streamMaxVolume) {
                                i = streamMaxVolume;
                            }
                            com.tencent.mm.compatible.b.a.b(audioManager, 3, i);
                        }
                        i = i2;
                        i += kVar.JB;
                        if (i >= 0) {
                        }
                        com.tencent.mm.compatible.b.a.b(audioManager, 3, i);
                    }
                    AppMethodBeat.o(1735);
                }
                return true;
            }
        });
        this.hXK = com.tencent.mm.plugin.websearch.ui.a.cN(context);
        AppMethodBeat.o(1739);
    }

    public final void z(MotionEvent motionEvent) {
        AppMethodBeat.i(1740);
        if (this.sED.cGl()) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.iaA = motionEvent.getRawX();
                this.JB = ((AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
                this.hXK = com.tencent.mm.plugin.websearch.ui.a.cN(this.mContext);
            }
            this.iay.onTouchEvent(motionEvent);
            if (actionMasked == 1 || actionMasked == 3) {
                if (this.sEC == a.FastBackwardOrForward) {
                    c cVar = this.sED;
                    actionMasked = this.iaC;
                    motionEvent.getRawX();
                    cVar.FF(actionMasked);
                    this.iaB = -1;
                    this.iaC = 0;
                    this.iaA = 0.0f;
                } else if (this.sEC == a.Volume) {
                    ((AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamMaxVolume(3);
                } else {
                    a aVar = a.Brightness;
                }
                this.sEC = a.None;
            }
            AppMethodBeat.o(1740);
            return;
        }
        this.sEC = a.None;
        AppMethodBeat.o(1740);
    }

    public final void aFY() {
        this.iaB = -1;
        this.iaC = 0;
        this.iaA = 0.0f;
    }
}
