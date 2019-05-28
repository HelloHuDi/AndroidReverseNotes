package com.tencent.mm.plugin.webview.fts.ui;

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
import com.tencent.mm.plugin.webview.fts.c.c;

public final class a {
    int JB = 0;
    float hXK = 0.0f;
    float iaA = 0.0f;
    int iaB = -1;
    int iaC = 0;
    Runnable iaD = new Runnable() {
        public final void run() {
            AppMethodBeat.i(5815);
            a.this.ugH.aFi();
            AppMethodBeat.o(5815);
        }
    };
    View iaw;
    GestureDetector iay;
    Context mContext;
    a ugG = a.None;
    b ugH;

    enum a {
        None,
        Volume,
        Brightness,
        FastBackwardOrForward;

        static {
            AppMethodBeat.o(5821);
        }
    }

    public interface b {
        void aFi();

        void aFj();

        void aFk();

        void aFl();

        void aFm();

        void aq(float f);

        void ar(float f);

        boolean cGl();

        int getCurrentPosition();

        int i(int i, float f);

        void j(int i, float f);
    }

    public a(Context context, View view, b bVar) {
        AppMethodBeat.i(5822);
        this.mContext = context;
        this.ugH = bVar;
        this.iaw = view;
        this.iay = new GestureDetector(this.mContext, new SimpleOnGestureListener() {
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                AppMethodBeat.i(5816);
                a.this.iaw.postDelayed(a.this.iaD, 200);
                AppMethodBeat.o(5816);
                return true;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                AppMethodBeat.i(5817);
                a.this.iaw.removeCallbacks(a.this.iaD);
                a.this.ugH.aFj();
                AppMethodBeat.o(5817);
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:54:0x012c  */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x0117  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                float f3 = 1.0f;
                float f4 = 0.0f;
                AppMethodBeat.i(5818);
                if (motionEvent == null || motionEvent2 == null) {
                    AppMethodBeat.o(5818);
                } else {
                    if (a.this.ugG == a.None) {
                        if (Math.abs(f) > Math.abs(f2)) {
                            a.this.ugG = a.FastBackwardOrForward;
                        } else if (motionEvent.getX() < ((float) (a.this.iaw.getMeasuredWidth() / 2))) {
                            a.this.ugG = a.Brightness;
                        } else {
                            a.this.ugG = a.Volume;
                        }
                    }
                    float x = motionEvent2.getX() - motionEvent.getX();
                    float y = motionEvent2.getY() - motionEvent.getY();
                    a aVar = a.this;
                    if (aVar.ugG == a.FastBackwardOrForward) {
                        if (aVar.iaB == -1) {
                            aVar.ugH.aFk();
                            aVar.iaB = aVar.ugH.getCurrentPosition();
                        }
                        aVar.iaC = aVar.ugH.i(aVar.iaB, x);
                    } else if (aVar.ugG == a.Brightness) {
                        x = (((y * -1.0f) / ((float) aVar.iaw.getMeasuredHeight())) * 1.2f) + aVar.hXK;
                        if (x >= 0.0f) {
                            if (x > 1.0f) {
                                f4 = 1.0f;
                            } else {
                                f4 = x;
                            }
                        }
                        Context context = aVar.mContext;
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
                        aVar.ugH.ar(f4);
                    } else if (aVar.ugG == a.Volume) {
                        int i;
                        float f5 = y * -1.0f;
                        f3 = f5 / ((float) aVar.iaw.getMeasuredHeight());
                        AudioManager audioManager = (AudioManager) aVar.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                        float f6 = 1.2f * (f3 * ((float) streamMaxVolume));
                        int i2 = (int) f6;
                        if (i2 == 0 && Math.abs(f6) > 0.2f) {
                            if (f5 > 0.0f) {
                                i = 1;
                            } else if (f5 < 0.0f) {
                                i = -1;
                            }
                            i += aVar.JB;
                            if (i >= 0) {
                                i = 0;
                            } else if (i >= streamMaxVolume) {
                                i = streamMaxVolume;
                            }
                            com.tencent.mm.compatible.b.a.b(audioManager, 3, i);
                            aVar.ugH.aq(((float) i) / ((float) streamMaxVolume));
                        }
                        i = i2;
                        i += aVar.JB;
                        if (i >= 0) {
                        }
                        com.tencent.mm.compatible.b.a.b(audioManager, 3, i);
                        aVar.ugH.aq(((float) i) / ((float) streamMaxVolume));
                    }
                    AppMethodBeat.o(5818);
                }
                return true;
            }
        });
        this.hXK = c.cN(context);
        AppMethodBeat.o(5822);
    }
}
