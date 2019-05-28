package com.tencent.p177mm.plugin.topstory.p541ui.video;

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
import com.tencent.p177mm.plugin.websearch.p1066ui.C14430a;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.k */
public final class C13963k {
    /* renamed from: JB */
    int f2944JB = 0;
    float hXK = 0.0f;
    private float iaA = 0.0f;
    int iaB = -1;
    int iaC = 0;
    Runnable iaD = new C139661();
    View iaw;
    private GestureDetector iay;
    Context mContext;
    C13964a sEC = C13964a.None;
    C13953c sED;
    boolean sEE;
    boolean sEF;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.k$a */
    enum C13964a {
        None,
        Volume,
        Brightness,
        FastBackwardOrForward;

        static {
            AppMethodBeat.m2505o(1738);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.k$2 */
    class C139652 extends SimpleOnGestureListener {
        C139652() {
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(1733);
            C13963k.this.iaw.postDelayed(C13963k.this.iaD, 200);
            AppMethodBeat.m2505o(1733);
            return true;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(1734);
            C13963k.this.iaw.removeCallbacks(C13963k.this.iaD);
            C13963k.this.sED.aFj();
            AppMethodBeat.m2505o(1734);
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:58:0x0129  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x011c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            float f3 = 1.0f;
            float f4 = 0.0f;
            AppMethodBeat.m2504i(1735);
            if (motionEvent == null || motionEvent2 == null) {
                AppMethodBeat.m2505o(1735);
            } else {
                if (C13963k.this.sEC == C13964a.None) {
                    if (Math.abs(f) > Math.abs(f2)) {
                        C13963k.this.sEC = C13964a.FastBackwardOrForward;
                    } else if (motionEvent.getX() < ((float) (C13963k.this.iaw.getMeasuredWidth() / 2))) {
                        C13963k.this.sEC = C13964a.Brightness;
                    } else {
                        C13963k.this.sEC = C13964a.Volume;
                    }
                }
                float x = motionEvent2.getX() - motionEvent.getX();
                float y = motionEvent2.getY() - motionEvent.getY();
                C13963k c13963k = C13963k.this;
                if (c13963k.sEC == C13964a.FastBackwardOrForward) {
                    if (c13963k.iaB == -1) {
                        c13963k.sED.aFk();
                        c13963k.iaB = c13963k.sED.getCurrentPosition();
                    }
                    c13963k.iaC = c13963k.sED.mo26183be(x);
                } else if (c13963k.sEC == C13964a.Brightness && c13963k.sEF) {
                    x = (((y * -1.0f) / ((float) c13963k.iaw.getMeasuredHeight())) * 1.2f) + c13963k.hXK;
                    if (x >= 0.0f) {
                        if (x > 1.0f) {
                            f4 = 1.0f;
                        } else {
                            f4 = x;
                        }
                    }
                    Context context = c13963k.mContext;
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
                    AppMethodBeat.m2505o(1735);
                } else if (c13963k.sEC == C13964a.Volume && c13963k.sEE) {
                    int i;
                    float f5 = y * -1.0f;
                    f3 = f5 / ((float) c13963k.iaw.getMeasuredHeight());
                    AudioManager audioManager = (AudioManager) c13963k.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                    int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                    float f6 = 1.2f * (f3 * ((float) streamMaxVolume));
                    int i2 = (int) f6;
                    if (i2 == 0 && Math.abs(f6) > 0.2f) {
                        if (f5 > 0.0f) {
                            i = 1;
                        } else if (f5 < 0.0f) {
                            i = -1;
                        }
                        i += c13963k.f2944JB;
                        if (i >= 0) {
                            i = 0;
                        } else if (i >= streamMaxVolume) {
                            i = streamMaxVolume;
                        }
                        C1397a.m2944b(audioManager, 3, i);
                    }
                    i = i2;
                    i += c13963k.f2944JB;
                    if (i >= 0) {
                    }
                    C1397a.m2944b(audioManager, 3, i);
                }
                AppMethodBeat.m2505o(1735);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.video.k$1 */
    class C139661 implements Runnable {
        C139661() {
        }

        public final void run() {
            AppMethodBeat.m2504i(1732);
            C13963k.this.sED.aFi();
            AppMethodBeat.m2505o(1732);
        }
    }

    public C13963k(Context context, View view, C13953c c13953c) {
        AppMethodBeat.m2504i(1739);
        this.mContext = context;
        this.sED = c13953c;
        this.iaw = view;
        this.iay = new GestureDetector(this.mContext, new C139652());
        this.hXK = C14430a.m22662cN(context);
        AppMethodBeat.m2505o(1739);
    }

    /* renamed from: z */
    public final void mo26196z(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(1740);
        if (this.sED.cGl()) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.iaA = motionEvent.getRawX();
                this.f2944JB = ((AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
                this.hXK = C14430a.m22662cN(this.mContext);
            }
            this.iay.onTouchEvent(motionEvent);
            if (actionMasked == 1 || actionMasked == 3) {
                if (this.sEC == C13964a.FastBackwardOrForward) {
                    C13953c c13953c = this.sED;
                    actionMasked = this.iaC;
                    motionEvent.getRawX();
                    c13953c.mo26179FF(actionMasked);
                    this.iaB = -1;
                    this.iaC = 0;
                    this.iaA = 0.0f;
                } else if (this.sEC == C13964a.Volume) {
                    ((AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamMaxVolume(3);
                } else {
                    C13964a c13964a = C13964a.Brightness;
                }
                this.sEC = C13964a.None;
            }
            AppMethodBeat.m2505o(1740);
            return;
        }
        this.sEC = C13964a.None;
        AppMethodBeat.m2505o(1740);
    }

    public final void aFY() {
        this.iaB = -1;
        this.iaC = 0;
        this.iaA = 0.0f;
    }
}
