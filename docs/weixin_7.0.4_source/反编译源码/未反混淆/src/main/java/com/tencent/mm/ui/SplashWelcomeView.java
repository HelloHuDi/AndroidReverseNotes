package com.tencent.mm.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.chatting.ap;
import com.tencent.mm.ui.e.d;
import com.tencent.mm.vfs.e;

public class SplashWelcomeView extends FrameLayout implements ap {
    private Bitmap bitmap;
    private boolean hasDrawed;
    private volatile boolean yqu;
    private volatile boolean yqv;
    private ImageView yqw;
    private int yqx;

    static /* synthetic */ void c(SplashWelcomeView splashWelcomeView) {
        AppMethodBeat.i(29921);
        splashWelcomeView.dzd();
        AppMethodBeat.o(29921);
    }

    public SplashWelcomeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(29915);
        hv(context);
        AppMethodBeat.o(29915);
    }

    public SplashWelcomeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(29916);
        hv(context);
        AppMethodBeat.o(29916);
    }

    private boolean i(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(29917);
        this.yqx = sharedPreferences.getInt("launch_fail_times", 0);
        int i = sharedPreferences.getInt("launch_last_status", 0);
        if (i == 1) {
            ab.i("SplashWelcomeView", "last launch status is 'start'.");
            this.yqx++;
            sharedPreferences.edit().putInt("launch_fail_times", this.yqx).commit();
        } else if (i == 2) {
            ab.i("SplashWelcomeView", "last launch status is 'end'.");
        }
        sharedPreferences.edit().putInt("launch_last_status", 1).apply();
        if (this.yqx >= 3) {
            ab.i("SplashWelcomeView", "launch exceed max failed times, %d", Integer.valueOf(this.yqx));
            AppMethodBeat.o(29917);
            return false;
        }
        AppMethodBeat.o(29917);
        return true;
    }

    private void hv(Context context) {
        AppMethodBeat.i(29918);
        this.yqw = new SplashImageView(context);
        this.yqw.setScaleType(ScaleType.CENTER_CROP);
        ((SplashImageView) this.yqw).setOnDrawListener(this);
        if (ah.bqo()) {
            try {
                ab.i("SplashWelcomeView", "transit to switch account %s", Boolean.valueOf(ah.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("transit_to_switch_account", false)));
                if (ah.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("transit_to_switch_account", false)) {
                    byte[] e = e.e(d.yfV, 0, com.tencent.mm.a.e.cs(d.yfV));
                    if (e != null && e.length > 0) {
                        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(e, 0, e.length);
                        if (decodeByteArray != null) {
                            this.yqw.setImageBitmap(decodeByteArray);
                        } else {
                            ab.e("SplashWelcomeView", "get switch account bg null!");
                        }
                    }
                }
            } catch (Exception e2) {
                ab.printErrStackTrace("SplashWelcomeView", e2, "show switch account view with exception!", new Object[0]);
            }
        }
        addView(this.yqw, new LayoutParams(-1, -1));
        try {
            if (ah.bqo()) {
                SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("system_config_prefs", 0);
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                ab.i("SplashWelcomeView", "beginTime:%s,endTime:%s,currentTime:%s", Long.valueOf(sharedPreferences.getLong("new_launch_image_begin_time", 0)), Long.valueOf(sharedPreferences.getLong("new_launch_image_end_time", 0)), Long.valueOf(currentTimeMillis));
                final String str = b.eSj + "splashWelcomeImg";
                if (currentTimeMillis <= sharedPreferences.getLong("new_launch_image_begin_time", 0) || currentTimeMillis >= r4) {
                    ab.i("SplashWelcomeView", "change launch image activity is finished!");
                    com.tencent.mm.a.e.deleteFile(str);
                    AppMethodBeat.o(29918);
                    return;
                } else if (i(sharedPreferences)) {
                    com.tencent.mm.sdk.g.d.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(29912);
                            if (com.tencent.mm.a.e.ct(str)) {
                                try {
                                    byte[] e = com.tencent.mm.a.e.e(str, 0, com.tencent.mm.a.e.cs(str));
                                    if (e != null && e.length > 0) {
                                        SplashWelcomeView.this.bitmap = BitmapFactory.decodeByteArray(e, 0, e.length);
                                        ab.i("SplashWelcomeView", "ready to play animation, hasDrawed %s", Boolean.valueOf(SplashWelcomeView.this.hasDrawed));
                                        SplashWelcomeView.this.yqv = true;
                                    }
                                    if (SplashWelcomeView.this.hasDrawed) {
                                        SplashWelcomeView.c(SplashWelcomeView.this);
                                        AppMethodBeat.o(29912);
                                        return;
                                    }
                                } catch (Exception e2) {
                                    ab.printErrStackTrace("SplashWelcomeView", e2, "decode new welcome image error: %s", e2.getMessage());
                                    if (SplashWelcomeView.this.hasDrawed) {
                                        SplashWelcomeView.c(SplashWelcomeView.this);
                                        AppMethodBeat.o(29912);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    if (SplashWelcomeView.this.hasDrawed) {
                                        SplashWelcomeView.c(SplashWelcomeView.this);
                                    }
                                    AppMethodBeat.o(29912);
                                }
                                AppMethodBeat.o(29912);
                                return;
                            }
                            ab.i("SplashWelcomeView", "cannot find %s", str);
                            AppMethodBeat.o(29912);
                        }
                    }, "readWelcomeBg");
                    AppMethodBeat.o(29918);
                    return;
                } else {
                    AppMethodBeat.o(29918);
                    return;
                }
            }
            ab.i("SplashWelcomeView", "not main process, only load default splash bitmap.");
            AppMethodBeat.o(29918);
        } catch (Exception e22) {
            ab.printErrStackTrace("SplashWelcomeView", e22, "%s", e22.getMessage());
            AppMethodBeat.o(29918);
        }
    }

    private synchronized void dzd() {
        AppMethodBeat.i(29919);
        if (!this.yqu) {
            this.yqu = true;
            if (this.bitmap != null) {
                try {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(29914);
                            ab.d("SplashWelcomeView", "set top imageView");
                            final ImageView imageView = new ImageView(SplashWelcomeView.this.getContext());
                            imageView.setScaleType(ScaleType.CENTER_CROP);
                            imageView.setImageBitmap(SplashWelcomeView.this.bitmap);
                            imageView.setAlpha(0.0f);
                            SplashWelcomeView.this.addView(imageView, new LayoutParams(-1, -1));
                            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(1000);
                            duration.addUpdateListener(new AnimatorUpdateListener() {
                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    AppMethodBeat.i(29913);
                                    imageView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                                    AppMethodBeat.o(29913);
                                }
                            });
                            duration.start();
                            ab.i("SplashWelcomeView", "start play animation");
                            AppMethodBeat.o(29914);
                        }
                    });
                    AppMethodBeat.o(29919);
                } catch (Exception e) {
                    ab.printErrStackTrace("SplashWelcomeView", e, "%s", e.getMessage());
                }
            }
        }
        AppMethodBeat.o(29919);
    }

    public final void bCv() {
        AppMethodBeat.i(29920);
        ab.i("SplashWelcomeView", "hasDrawed:%s", Boolean.valueOf(this.hasDrawed));
        if (!this.hasDrawed) {
            this.hasDrawed = true;
            if (this.yqv && !this.yqu) {
                dzd();
            }
        }
        AppMethodBeat.o(29920);
    }
}
