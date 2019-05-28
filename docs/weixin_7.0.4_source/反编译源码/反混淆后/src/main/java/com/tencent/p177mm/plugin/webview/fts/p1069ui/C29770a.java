package com.tencent.p177mm.plugin.webview.fts.p1069ui;

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
import com.tencent.p177mm.plugin.webview.fts.p752c.C43875c;

/* renamed from: com.tencent.mm.plugin.webview.fts.ui.a */
public final class C29770a {
    /* renamed from: JB */
    int f13721JB = 0;
    float hXK = 0.0f;
    float iaA = 0.0f;
    int iaB = -1;
    int iaC = 0;
    Runnable iaD = new C297711();
    View iaw;
    GestureDetector iay;
    Context mContext;
    C22808a ugG = C22808a.None;
    C22809b ugH;

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.a$a */
    enum C22808a {
        None,
        Volume,
        Brightness,
        FastBackwardOrForward;

        static {
            AppMethodBeat.m2505o(5821);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.a$b */
    public interface C22809b {
        void aFi();

        void aFj();

        void aFk();

        void aFl();

        void aFm();

        /* renamed from: aq */
        void mo38411aq(float f);

        /* renamed from: ar */
        void mo38412ar(float f);

        boolean cGl();

        int getCurrentPosition();

        /* renamed from: i */
        int mo38415i(int i, float f);

        /* renamed from: j */
        void mo38416j(int i, float f);
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.a$1 */
    class C297711 implements Runnable {
        C297711() {
        }

        public final void run() {
            AppMethodBeat.m2504i(5815);
            C29770a.this.ugH.aFi();
            AppMethodBeat.m2505o(5815);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.a$2 */
    class C297722 extends SimpleOnGestureListener {
        C297722() {
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(5816);
            C29770a.this.iaw.postDelayed(C29770a.this.iaD, 200);
            AppMethodBeat.m2505o(5816);
            return true;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(5817);
            C29770a.this.iaw.removeCallbacks(C29770a.this.iaD);
            C29770a.this.ugH.aFj();
            AppMethodBeat.m2505o(5817);
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:54:0x012c  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0117  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            float f3 = 1.0f;
            float f4 = 0.0f;
            AppMethodBeat.m2504i(5818);
            if (motionEvent == null || motionEvent2 == null) {
                AppMethodBeat.m2505o(5818);
            } else {
                if (C29770a.this.ugG == C22808a.None) {
                    if (Math.abs(f) > Math.abs(f2)) {
                        C29770a.this.ugG = C22808a.FastBackwardOrForward;
                    } else if (motionEvent.getX() < ((float) (C29770a.this.iaw.getMeasuredWidth() / 2))) {
                        C29770a.this.ugG = C22808a.Brightness;
                    } else {
                        C29770a.this.ugG = C22808a.Volume;
                    }
                }
                float x = motionEvent2.getX() - motionEvent.getX();
                float y = motionEvent2.getY() - motionEvent.getY();
                C29770a c29770a = C29770a.this;
                if (c29770a.ugG == C22808a.FastBackwardOrForward) {
                    if (c29770a.iaB == -1) {
                        c29770a.ugH.aFk();
                        c29770a.iaB = c29770a.ugH.getCurrentPosition();
                    }
                    c29770a.iaC = c29770a.ugH.mo38415i(c29770a.iaB, x);
                } else if (c29770a.ugG == C22808a.Brightness) {
                    x = (((y * -1.0f) / ((float) c29770a.iaw.getMeasuredHeight())) * 1.2f) + c29770a.hXK;
                    if (x >= 0.0f) {
                        if (x > 1.0f) {
                            f4 = 1.0f;
                        } else {
                            f4 = x;
                        }
                    }
                    Context context = c29770a.mContext;
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
                    c29770a.ugH.mo38412ar(f4);
                } else if (c29770a.ugG == C22808a.Volume) {
                    int i;
                    float f5 = y * -1.0f;
                    f3 = f5 / ((float) c29770a.iaw.getMeasuredHeight());
                    AudioManager audioManager = (AudioManager) c29770a.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                    int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                    float f6 = 1.2f * (f3 * ((float) streamMaxVolume));
                    int i2 = (int) f6;
                    if (i2 == 0 && Math.abs(f6) > 0.2f) {
                        if (f5 > 0.0f) {
                            i = 1;
                        } else if (f5 < 0.0f) {
                            i = -1;
                        }
                        i += c29770a.f13721JB;
                        if (i >= 0) {
                            i = 0;
                        } else if (i >= streamMaxVolume) {
                            i = streamMaxVolume;
                        }
                        C1397a.m2944b(audioManager, 3, i);
                        c29770a.ugH.mo38411aq(((float) i) / ((float) streamMaxVolume));
                    }
                    i = i2;
                    i += c29770a.f13721JB;
                    if (i >= 0) {
                    }
                    C1397a.m2944b(audioManager, 3, i);
                    c29770a.ugH.mo38411aq(((float) i) / ((float) streamMaxVolume));
                }
                AppMethodBeat.m2505o(5818);
            }
            return true;
        }
    }

    public C29770a(Context context, View view, C22809b c22809b) {
        AppMethodBeat.m2504i(5822);
        this.mContext = context;
        this.ugH = c22809b;
        this.iaw = view;
        this.iay = new GestureDetector(this.mContext, new C297722());
        this.hXK = C43875c.m78694cN(context);
        AppMethodBeat.m2505o(5822);
    }
}
