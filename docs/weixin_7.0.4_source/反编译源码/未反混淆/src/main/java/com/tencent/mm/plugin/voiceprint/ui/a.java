package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.a$7 */
    static class AnonymousClass7 implements AnimationListener {
        final /* synthetic */ a sMU;

        AnonymousClass7(a aVar) {
            this.sMU = aVar;
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.i(26258);
            if (this.sMU != null) {
                this.sMU.cHV();
            }
            AppMethodBeat.o(26258);
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(26259);
            if (this.sMU != null) {
                this.sMU.cHW();
            }
            AppMethodBeat.o(26259);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.a$6 */
    static class AnonymousClass6 implements AnimationListener {
        final /* synthetic */ a sMU;

        AnonymousClass6(a aVar) {
            this.sMU = aVar;
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.i(26256);
            if (this.sMU != null) {
                this.sMU.cHV();
            }
            AppMethodBeat.o(26256);
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(26257);
            if (this.sMU != null) {
                this.sMU.cHW();
            }
            AppMethodBeat.o(26257);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    public interface a {
        void cHV();

        void cHW();
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.a$1 */
    static class AnonymousClass1 implements AnimationListener {
        final /* synthetic */ a sMU;

        AnonymousClass1(a aVar) {
            this.sMU = aVar;
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(26249);
            if (this.sMU != null) {
                this.sMU.cHW();
            }
            ab.d("MicroMsg.VoiceViewAnimationHelper", "playTipAnim end");
            AppMethodBeat.o(26249);
        }
    }

    public static void a(final View view, final a aVar) {
        AppMethodBeat.i(26260);
        float width = (float) view.getWidth();
        ab.d("MicroMsg.VoiceViewAnimationHelper", "target ".concat(String.valueOf(width)));
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        final int i = (int) (width + ((float) iArr[0]));
        ab.d("MicroMsg.VoiceViewAnimationHelper", "location %d %d preX=%d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(i));
        view.getParent();
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, (float) (-i), 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setStartOffset(0);
        translateAnimation.setRepeatMode(-1);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(26251);
                if (aVar != null) {
                    aVar.cHV();
                }
                ab.d("MicroMsg.VoiceViewAnimationHelper", "onAnimationEnd ");
                TranslateAnimation translateAnimation = new TranslateAnimation(0, (float) i, 0, 0.0f, 1, 0.0f, 1, 0.0f);
                translateAnimation.setDuration(200);
                translateAnimation.setStartOffset(0);
                translateAnimation.setRepeatMode(-1);
                translateAnimation.setRepeatCount(0);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(26250);
                        ab.i("MicroMsg.VoiceViewAnimationHelper", "next end");
                        if (aVar != null) {
                            aVar.cHW();
                        }
                        AppMethodBeat.o(26250);
                    }
                });
                view.startAnimation(translateAnimation);
                AppMethodBeat.o(26251);
            }
        });
        view.startAnimation(translateAnimation);
        AppMethodBeat.o(26260);
    }

    public static void a(View view, Context context, final a aVar) {
        AppMethodBeat.i(26261);
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.ay);
        loadAnimation.setDuration(300);
        loadAnimation.setFillAfter(true);
        loadAnimation.setRepeatCount(0);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(26252);
                if (aVar != null) {
                    aVar.cHW();
                }
                AppMethodBeat.o(26252);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(loadAnimation);
        AppMethodBeat.o(26261);
    }

    public static void b(View view, Context context, final a aVar) {
        AppMethodBeat.i(26262);
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.b5);
        loadAnimation.setDuration(300);
        loadAnimation.setFillAfter(true);
        loadAnimation.setRepeatCount(0);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(26253);
                if (aVar != null) {
                    aVar.cHW();
                }
                AppMethodBeat.o(26253);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(loadAnimation);
        AppMethodBeat.o(26262);
    }

    public static void b(View view, final a aVar) {
        AppMethodBeat.i(26263);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setFillAfter(true);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(26254);
                if (aVar != null) {
                    aVar.cHV();
                }
                AppMethodBeat.o(26254);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(26255);
                if (aVar != null) {
                    aVar.cHW();
                }
                AppMethodBeat.o(26255);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(translateAnimation);
        AppMethodBeat.o(26263);
    }
}
