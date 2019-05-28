package com.tencent.p177mm.p612ui;

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
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p612ui.C5510e.C5497d;
import com.tencent.p177mm.p612ui.chatting.C5306ap;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.ui.SplashWelcomeView */
public class SplashWelcomeView extends FrameLayout implements C5306ap {
    private Bitmap bitmap;
    private boolean hasDrawed;
    private volatile boolean yqu;
    private volatile boolean yqv;
    private ImageView yqw;
    private int yqx;

    /* renamed from: com.tencent.mm.ui.SplashWelcomeView$2 */
    class C52132 implements Runnable {
        C52132() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29914);
            C4990ab.m7410d("SplashWelcomeView", "set top imageView");
            final ImageView imageView = new ImageView(SplashWelcomeView.this.getContext());
            imageView.setScaleType(ScaleType.CENTER_CROP);
            imageView.setImageBitmap(SplashWelcomeView.this.bitmap);
            imageView.setAlpha(0.0f);
            SplashWelcomeView.this.addView(imageView, new LayoutParams(-1, -1));
            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(1000);
            duration.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.m2504i(29913);
                    imageView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    AppMethodBeat.m2505o(29913);
                }
            });
            duration.start();
            C4990ab.m7416i("SplashWelcomeView", "start play animation");
            AppMethodBeat.m2505o(29914);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m12398c(SplashWelcomeView splashWelcomeView) {
        AppMethodBeat.m2504i(29921);
        splashWelcomeView.dzd();
        AppMethodBeat.m2505o(29921);
    }

    public SplashWelcomeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(29915);
        m12400hv(context);
        AppMethodBeat.m2505o(29915);
    }

    public SplashWelcomeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(29916);
        m12400hv(context);
        AppMethodBeat.m2505o(29916);
    }

    /* renamed from: i */
    private boolean m12401i(SharedPreferences sharedPreferences) {
        AppMethodBeat.m2504i(29917);
        this.yqx = sharedPreferences.getInt("launch_fail_times", 0);
        int i = sharedPreferences.getInt("launch_last_status", 0);
        if (i == 1) {
            C4990ab.m7416i("SplashWelcomeView", "last launch status is 'start'.");
            this.yqx++;
            sharedPreferences.edit().putInt("launch_fail_times", this.yqx).commit();
        } else if (i == 2) {
            C4990ab.m7416i("SplashWelcomeView", "last launch status is 'end'.");
        }
        sharedPreferences.edit().putInt("launch_last_status", 1).apply();
        if (this.yqx >= 3) {
            C4990ab.m7417i("SplashWelcomeView", "launch exceed max failed times, %d", Integer.valueOf(this.yqx));
            AppMethodBeat.m2505o(29917);
            return false;
        }
        AppMethodBeat.m2505o(29917);
        return true;
    }

    /* renamed from: hv */
    private void m12400hv(Context context) {
        AppMethodBeat.m2504i(29918);
        this.yqw = new SplashImageView(context);
        this.yqw.setScaleType(ScaleType.CENTER_CROP);
        ((SplashImageView) this.yqw).setOnDrawListener(this);
        if (C4996ah.bqo()) {
            try {
                C4990ab.m7417i("SplashWelcomeView", "transit to switch account %s", Boolean.valueOf(C4996ah.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("transit_to_switch_account", false)));
                if (C4996ah.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("transit_to_switch_account", false)) {
                    byte[] e = C5730e.m8632e(C5497d.yfV, 0, C1173e.m2560cs(C5497d.yfV));
                    if (e != null && e.length > 0) {
                        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(e, 0, e.length);
                        if (decodeByteArray != null) {
                            this.yqw.setImageBitmap(decodeByteArray);
                        } else {
                            C4990ab.m7412e("SplashWelcomeView", "get switch account bg null!");
                        }
                    }
                }
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("SplashWelcomeView", e2, "show switch account view with exception!", new Object[0]);
            }
        }
        addView(this.yqw, new LayoutParams(-1, -1));
        try {
            if (C4996ah.bqo()) {
                SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("system_config_prefs", 0);
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                C4990ab.m7417i("SplashWelcomeView", "beginTime:%s,endTime:%s,currentTime:%s", Long.valueOf(sharedPreferences.getLong("new_launch_image_begin_time", 0)), Long.valueOf(sharedPreferences.getLong("new_launch_image_end_time", 0)), Long.valueOf(currentTimeMillis));
                final String str = C1761b.eSj + "splashWelcomeImg";
                if (currentTimeMillis <= sharedPreferences.getLong("new_launch_image_begin_time", 0) || currentTimeMillis >= r4) {
                    C4990ab.m7416i("SplashWelcomeView", "change launch image activity is finished!");
                    C1173e.deleteFile(str);
                    AppMethodBeat.m2505o(29918);
                    return;
                } else if (m12401i(sharedPreferences)) {
                    C7305d.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(29912);
                            if (C1173e.m2561ct(str)) {
                                try {
                                    byte[] e = C1173e.m2569e(str, 0, C1173e.m2560cs(str));
                                    if (e != null && e.length > 0) {
                                        SplashWelcomeView.this.bitmap = BitmapFactory.decodeByteArray(e, 0, e.length);
                                        C4990ab.m7417i("SplashWelcomeView", "ready to play animation, hasDrawed %s", Boolean.valueOf(SplashWelcomeView.this.hasDrawed));
                                        SplashWelcomeView.this.yqv = true;
                                    }
                                    if (SplashWelcomeView.this.hasDrawed) {
                                        SplashWelcomeView.m12398c(SplashWelcomeView.this);
                                        AppMethodBeat.m2505o(29912);
                                        return;
                                    }
                                } catch (Exception e2) {
                                    C4990ab.printErrStackTrace("SplashWelcomeView", e2, "decode new welcome image error: %s", e2.getMessage());
                                    if (SplashWelcomeView.this.hasDrawed) {
                                        SplashWelcomeView.m12398c(SplashWelcomeView.this);
                                        AppMethodBeat.m2505o(29912);
                                        return;
                                    }
                                } catch (Throwable th) {
                                    if (SplashWelcomeView.this.hasDrawed) {
                                        SplashWelcomeView.m12398c(SplashWelcomeView.this);
                                    }
                                    AppMethodBeat.m2505o(29912);
                                }
                                AppMethodBeat.m2505o(29912);
                                return;
                            }
                            C4990ab.m7417i("SplashWelcomeView", "cannot find %s", str);
                            AppMethodBeat.m2505o(29912);
                        }
                    }, "readWelcomeBg");
                    AppMethodBeat.m2505o(29918);
                    return;
                } else {
                    AppMethodBeat.m2505o(29918);
                    return;
                }
            }
            C4990ab.m7416i("SplashWelcomeView", "not main process, only load default splash bitmap.");
            AppMethodBeat.m2505o(29918);
        } catch (Exception e22) {
            C4990ab.printErrStackTrace("SplashWelcomeView", e22, "%s", e22.getMessage());
            AppMethodBeat.m2505o(29918);
        }
    }

    private synchronized void dzd() {
        AppMethodBeat.m2504i(29919);
        if (!this.yqu) {
            this.yqu = true;
            if (this.bitmap != null) {
                try {
                    C5004al.m7441d(new C52132());
                    AppMethodBeat.m2505o(29919);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("SplashWelcomeView", e, "%s", e.getMessage());
                }
            }
        }
        AppMethodBeat.m2505o(29919);
    }

    public final void bCv() {
        AppMethodBeat.m2504i(29920);
        C4990ab.m7417i("SplashWelcomeView", "hasDrawed:%s", Boolean.valueOf(this.hasDrawed));
        if (!this.hasDrawed) {
            this.hasDrawed = true;
            if (this.yqv && !this.yqu) {
                dzd();
            }
        }
        AppMethodBeat.m2505o(29920);
    }
}
