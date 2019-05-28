package com.tencent.p177mm.plugin.voiceprint.p545ui;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.voiceprint.ui.a */
public final class C43725a {

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.a$7 */
    static class C140317 implements AnimationListener {
        final /* synthetic */ C29486a sMU;

        C140317(C29486a c29486a) {
            this.sMU = c29486a;
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.m2504i(26258);
            if (this.sMU != null) {
                this.sMU.cHV();
            }
            AppMethodBeat.m2505o(26258);
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(26259);
            if (this.sMU != null) {
                this.sMU.cHW();
            }
            AppMethodBeat.m2505o(26259);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.a$6 */
    static class C294856 implements AnimationListener {
        final /* synthetic */ C29486a sMU;

        C294856(C29486a c29486a) {
            this.sMU = c29486a;
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.m2504i(26256);
            if (this.sMU != null) {
                this.sMU.cHV();
            }
            AppMethodBeat.m2505o(26256);
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(26257);
            if (this.sMU != null) {
                this.sMU.cHW();
            }
            AppMethodBeat.m2505o(26257);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.a$a */
    public interface C29486a {
        void cHV();

        void cHW();
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.a$1 */
    static class C353471 implements AnimationListener {
        final /* synthetic */ C29486a sMU;

        C353471(C29486a c29486a) {
            this.sMU = c29486a;
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(26249);
            if (this.sMU != null) {
                this.sMU.cHW();
            }
            C4990ab.m7410d("MicroMsg.VoiceViewAnimationHelper", "playTipAnim end");
            AppMethodBeat.m2505o(26249);
        }
    }

    /* renamed from: a */
    public static void m78384a(final View view, final C29486a c29486a) {
        AppMethodBeat.m2504i(26260);
        float width = (float) view.getWidth();
        C4990ab.m7410d("MicroMsg.VoiceViewAnimationHelper", "target ".concat(String.valueOf(width)));
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        final int i = (int) (width + ((float) iArr[0]));
        C4990ab.m7411d("MicroMsg.VoiceViewAnimationHelper", "location %d %d preX=%d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(i));
        view.getParent();
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, (float) (-i), 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setStartOffset(0);
        translateAnimation.setRepeatMode(-1);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new AnimationListener() {

            /* renamed from: com.tencent.mm.plugin.voiceprint.ui.a$2$1 */
            class C140291 implements AnimationListener {
                C140291() {
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.m2504i(26250);
                    C4990ab.m7416i("MicroMsg.VoiceViewAnimationHelper", "next end");
                    if (c29486a != null) {
                        c29486a.cHW();
                    }
                    AppMethodBeat.m2505o(26250);
                }
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(26251);
                if (c29486a != null) {
                    c29486a.cHV();
                }
                C4990ab.m7410d("MicroMsg.VoiceViewAnimationHelper", "onAnimationEnd ");
                TranslateAnimation translateAnimation = new TranslateAnimation(0, (float) i, 0, 0.0f, 1, 0.0f, 1, 0.0f);
                translateAnimation.setDuration(200);
                translateAnimation.setStartOffset(0);
                translateAnimation.setRepeatMode(-1);
                translateAnimation.setRepeatCount(0);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(new C140291());
                view.startAnimation(translateAnimation);
                AppMethodBeat.m2505o(26251);
            }
        });
        view.startAnimation(translateAnimation);
        AppMethodBeat.m2505o(26260);
    }

    /* renamed from: a */
    public static void m78383a(View view, Context context, final C29486a c29486a) {
        AppMethodBeat.m2504i(26261);
        Animation loadAnimation = AnimationUtils.loadAnimation(context, C25738R.anim.f8327ay);
        loadAnimation.setDuration(300);
        loadAnimation.setFillAfter(true);
        loadAnimation.setRepeatCount(0);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(26252);
                if (c29486a != null) {
                    c29486a.cHW();
                }
                AppMethodBeat.m2505o(26252);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(loadAnimation);
        AppMethodBeat.m2505o(26261);
    }

    /* renamed from: b */
    public static void m78385b(View view, Context context, final C29486a c29486a) {
        AppMethodBeat.m2504i(26262);
        Animation loadAnimation = AnimationUtils.loadAnimation(context, C25738R.anim.f8332b5);
        loadAnimation.setDuration(300);
        loadAnimation.setFillAfter(true);
        loadAnimation.setRepeatCount(0);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(26253);
                if (c29486a != null) {
                    c29486a.cHW();
                }
                AppMethodBeat.m2505o(26253);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(loadAnimation);
        AppMethodBeat.m2505o(26262);
    }

    /* renamed from: b */
    public static void m78386b(View view, final C29486a c29486a) {
        AppMethodBeat.m2504i(26263);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setFillAfter(true);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.m2504i(26254);
                if (c29486a != null) {
                    c29486a.cHV();
                }
                AppMethodBeat.m2505o(26254);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(26255);
                if (c29486a != null) {
                    c29486a.cHW();
                }
                AppMethodBeat.m2505o(26255);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(translateAnimation);
        AppMethodBeat.m2505o(26263);
    }
}
