package com.tencent.mm.plugin.webview.ui.tools;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class l implements b {
    static final int utW = R.drawable.bm1;
    private boolean aIA = false;
    boolean hfA = false;
    a utS;
    ImageView utT;
    LogoWebViewWrapper utU;
    int utV = 0;
    private boolean utX = false;
    private int utY = 0;
    private float utZ = 0.0f;
    private ValueAnimator uua;
    private ViewPropertyAnimator uub;
    private float uuc;
    View uud;
    View uue;
    TextView uuf;
    boolean uug = true;
    boolean uuh = false;

    public interface a {
        void cZV();
    }

    public final void cZU() {
        AppMethodBeat.i(7698);
        this.hfA = false;
        stopLoading();
        if (!(!this.uug || this.uue == null || this.uuh)) {
            nM(false);
            this.utU.setReleaseTargetHeight(0);
            this.uue.setVisibility(0);
        }
        AppMethodBeat.o(7698);
    }

    public final void startLoading() {
        AppMethodBeat.i(7699);
        if (this.aIA) {
            AppMethodBeat.o(7699);
        } else if (this.utT == null || this.utU == null) {
            AppMethodBeat.o(7699);
        } else {
            this.aIA = true;
            this.utU.nM(true);
            this.utT.clearAnimation();
            if (this.uua != null) {
                this.uua.cancel();
            }
            this.uua = ObjectAnimator.ofFloat(this, "startLoadingStep", new float[]{this.utZ + 0.0f, this.utZ + 354.0f});
            this.uua.setDuration(960);
            this.uua.setRepeatMode(1);
            this.uua.setRepeatCount(-1);
            this.uua.setInterpolator(new LinearInterpolator());
            this.uua.start();
            if (this.utS != null) {
                this.utS.cZV();
            }
            AppMethodBeat.o(7699);
        }
    }

    public final void stopLoading() {
        AppMethodBeat.i(7700);
        if (this.aIA) {
            ab.d("MicroMsg.WebViewPullDownLogoDelegate", "stopLoading()");
            this.utX = true;
            this.aIA = false;
            if (this.utU != null && this.hfA) {
                this.utU.nM(false);
            }
            if (this.uua != null) {
                this.uua.cancel();
            }
            if (this.utU != null) {
                this.utU.z(0, 250);
            }
            if (this.utT != null) {
                ab.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage, alpha to 0f");
                this.utT.animate().alpha(0.0f).setDuration(500).start();
            }
            AppMethodBeat.o(7700);
            return;
        }
        AppMethodBeat.o(7700);
    }

    public final void release() {
        AppMethodBeat.i(7701);
        if (this.utU != null) {
            LogoWebViewWrapper logoWebViewWrapper = this.utU;
            if (logoWebViewWrapper.uro != null) {
                logoWebViewWrapper.uro.removeView(logoWebViewWrapper.ejN);
                logoWebViewWrapper.ejN = null;
            }
            logoWebViewWrapper = this.utU;
            logoWebViewWrapper.ury = null;
            logoWebViewWrapper.urx = null;
        }
        if (this.uud != null) {
            ((ViewGroup) this.uud).removeAllViews();
        }
        this.utU = null;
        this.utT = null;
        this.utY = 0;
        if (this.uua != null) {
            this.uua.cancel();
            this.uua = null;
        }
        AppMethodBeat.o(7701);
    }

    public final void Jp(int i) {
        AppMethodBeat.i(7702);
        if (this.uud != null) {
            this.uud.setBackgroundColor(i);
        }
        AppMethodBeat.o(7702);
    }

    public final void as(int i, boolean z) {
        String str;
        AppMethodBeat.i(7703);
        String str2 = "MicroMsg.WebViewPullDownLogoDelegate";
        String str3 = "onOverScrollOffset, offset = %d, pointerDown = %b, refreshImage.visibility = %s, refreshImage.drawable = %s, refreshImage.alpha = %s";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(z);
        if (this.utT == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = String.valueOf(this.utT.getVisibility());
        }
        objArr[2] = str;
        if (this.utT == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = this.utT.getDrawable().toString();
        }
        objArr[3] = str;
        if (this.utT == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = String.valueOf(this.utT.getAlpha());
        }
        objArr[4] = str;
        ab.v(str2, str3, objArr);
        if (this.hfA) {
            if (i == 0) {
                this.utX = false;
            }
            if (this.utT == null) {
                AppMethodBeat.o(7703);
                return;
            }
            if (z) {
                if (Math.abs(i) >= this.utV) {
                    if (this.utU != null) {
                        this.utU.setReleaseTargetHeight(this.utV);
                    }
                } else if (this.utU != null) {
                    this.utU.setReleaseTargetHeight(0);
                }
            } else if (Math.abs(i) > this.utV && !this.aIA) {
                ab.d("MicroMsg.WebViewPullDownLogoDelegate", "startLoading()");
                startLoading();
                AppMethodBeat.o(7703);
                return;
            } else if (this.aIA) {
                AppMethodBeat.o(7703);
                return;
            }
            if (this.utT != null && this.utT.getAlpha() < 1.0f && this.uub == null && z) {
                ab.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage alpha to 1.0f");
                this.uub = this.utT.animate().alpha(1.0f).setDuration(500);
                this.uub.setListener(new AnimatorListenerAdapter() {
                    public final void onAnimationCancel(Animator animator) {
                        AppMethodBeat.i(7696);
                        super.onAnimationCancel(animator);
                        l.this.uub = null;
                        AppMethodBeat.o(7696);
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(7697);
                        super.onAnimationEnd(animator);
                        l.this.uub = null;
                        AppMethodBeat.o(7697);
                    }
                });
                this.uub.start();
            }
            if (!this.utX) {
                int i2 = (-i) - this.utY;
                if (Math.abs(i) >= this.utV) {
                    i2 *= 5;
                } else {
                    i2 *= 2;
                }
                this.utY = -i;
                float height = ((float) this.utT.getHeight()) / 2.0f;
                float width = ((float) this.utT.getWidth()) / 2.0f;
                this.utZ -= (float) i2;
                this.utT.setScaleType(ScaleType.MATRIX);
                Matrix imageMatrix = this.utT.getImageMatrix();
                imageMatrix.postRotate((float) (-i2), width, height);
                this.utT.setImageMatrix(imageMatrix);
                this.utT.setImageResource(utW);
            }
            this.utT.invalidate();
            AppMethodBeat.o(7703);
            return;
        }
        AppMethodBeat.o(7703);
    }

    public final float getStartLoadingStep() {
        return this.uuc;
    }

    public final void setStartLoadingStep(float f) {
        float f2;
        float f3 = 0.0f;
        AppMethodBeat.i(7704);
        this.uuc = f;
        this.utT.setScaleType(ScaleType.MATRIX);
        Matrix imageMatrix = this.utT.getImageMatrix();
        if (this.utT == null) {
            f2 = 0.0f;
        } else {
            f2 = ((float) this.utT.getWidth()) / 2.0f;
        }
        if (this.utT != null) {
            f3 = ((float) this.utT.getHeight()) / 2.0f;
        }
        imageMatrix.setRotate(f, f2, f3);
        this.utZ = f;
        this.utT.invalidate();
        AppMethodBeat.o(7704);
    }

    public final void nM(boolean z) {
        AppMethodBeat.i(7705);
        if (!(this.utU == null || this.utU.uru == z)) {
            this.utU.nM(z);
            if (this.uue != null) {
                this.uue.setVisibility(8);
            }
            this.uuh = z;
        }
        AppMethodBeat.o(7705);
    }

    public final void setCurrentURL(String str) {
        AppMethodBeat.i(7706);
        if (!this.uug || this.uuh) {
            nM(true);
            if (this.uue != null && this.uue.getVisibility() == 0) {
                this.uue.setVisibility(8);
            }
            AppMethodBeat.o(7706);
            return;
        }
        if (this.uuf != null) {
            if (!bo.isNullOrNil(str)) {
                if (!bo.isNullOrNil(Uri.parse(str).getHost())) {
                    String string = this.uuf.getContext().getString(R.string.fyz, new Object[]{string});
                    this.uuf.setVisibility(0);
                    this.uuf.setText(string);
                    nM(false);
                    AppMethodBeat.o(7706);
                    return;
                }
            }
            this.uuf.setVisibility(8);
        }
        AppMethodBeat.o(7706);
    }
}
