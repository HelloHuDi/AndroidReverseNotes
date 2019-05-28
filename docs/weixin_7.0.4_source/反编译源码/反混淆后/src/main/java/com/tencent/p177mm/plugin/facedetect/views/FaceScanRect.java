package com.tencent.p177mm.plugin.facedetect.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.facedetect.views.FaceScanRect */
public class FaceScanRect extends RelativeLayout {
    private ImageView mbA;
    private ImageView mbB;
    private ImageView mbC;
    private ImageView mbD;
    public ImageView[] mbE;
    private ScaleAnimation mbF;
    private ScaleAnimation mbG;
    private ScaleAnimation mbH;
    private ScaleAnimation mbI;
    public TranslateAnimation mbJ;
    private C20664b mbK;
    private ViewGroup mbL;
    public View mbM;
    public C20663a mbN;
    public View mbv;
    private ImageView mbw;
    private ImageView mbx;
    private ImageView mby;
    private ImageView mbz;

    /* renamed from: com.tencent.mm.plugin.facedetect.views.FaceScanRect$a */
    public enum C20663a {
        OPENED,
        CLOSED,
        INIT;

        static {
            AppMethodBeat.m2505o(664);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.views.FaceScanRect$b */
    public interface C20664b {
        void btt();
    }

    public FaceScanRect(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceScanRect(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(665);
        this.mbv = null;
        this.mbw = null;
        this.mbx = null;
        this.mby = null;
        this.mbz = null;
        this.mbA = null;
        this.mbB = null;
        this.mbC = null;
        this.mbD = null;
        this.mbE = null;
        this.mbF = null;
        this.mbG = null;
        this.mbH = null;
        this.mbI = null;
        this.mbJ = null;
        this.mbK = null;
        this.mbL = null;
        this.mbM = null;
        LayoutInflater.from(context).inflate(2130969477, this, true);
        this.mbv = findViewById(2131823816);
        this.mbw = (ImageView) findViewById(2131823818);
        this.mbx = (ImageView) findViewById(2131823819);
        this.mby = (ImageView) findViewById(2131823822);
        this.mbz = (ImageView) findViewById(2131823823);
        this.mbA = (ImageView) findViewById(2131823824);
        this.mbB = (ImageView) findViewById(2131823825);
        this.mbC = (ImageView) findViewById(2131823820);
        this.mbD = (ImageView) findViewById(2131823821);
        this.mbM = findViewById(2131823817);
        this.mbL = (ViewGroup) findViewById(2131823826);
        this.mbE = new ImageView[]{this.mbw, this.mbx, this.mby, this.mbz, this.mbA, this.mbB, this.mbC, this.mbD};
        this.mbN = C20663a.INIT;
        this.mbJ = new TranslateAnimation(2, 0.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
        this.mbJ.setRepeatCount(-1);
        this.mbJ.setRepeatMode(1);
        this.mbJ.setDuration(1000);
        AppMethodBeat.m2505o(665);
    }

    public void setOnRefreshRectListener(C20664b c20664b) {
        this.mbK = c20664b;
    }

    public ViewGroup getCenterHintHolder() {
        return this.mbL;
    }

    private void btN() {
        AppMethodBeat.m2504i(666);
        this.mbM.setVisibility(8);
        this.mbv.setBackground(null);
        this.mbM.clearAnimation();
        AppMethodBeat.m2505o(666);
    }

    /* renamed from: b */
    public final void mo35958b(AnimationListener animationListener) {
        AppMethodBeat.m2504i(667);
        if (this.mbN == C20663a.CLOSED) {
            C4990ab.m7420w("MicroMsg.FaceScanRect", "hy: already closed");
            if (animationListener != null) {
                animationListener.onAnimationEnd(null);
            }
            AppMethodBeat.m2505o(667);
            return;
        }
        this.mbN = C20663a.CLOSED;
        m31914c(animationListener);
        this.mbw.startAnimation(this.mbF);
        this.mbz.startAnimation(this.mbI);
        this.mbA.startAnimation(this.mbH);
        this.mbD.startAnimation(this.mbG);
        btN();
        for (ImageView backgroundColor : this.mbE) {
            backgroundColor.setBackgroundColor(getResources().getColor(C25738R.color.f11991om));
        }
        AppMethodBeat.m2505o(667);
    }

    /* renamed from: c */
    private void m31914c(AnimationListener animationListener) {
        AppMethodBeat.m2504i(668);
        int width = getWidth();
        int height = getHeight();
        int dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.a1x);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C25738R.dimen.a1y);
        float f = ((float) (((width - (dimensionPixelSize * 2)) - (dimensionPixelSize2 * 2)) + dimensionPixelSize2)) / ((float) dimensionPixelSize2);
        float f2 = ((float) (((height - (dimensionPixelSize * 2)) - (dimensionPixelSize2 * 2)) + dimensionPixelSize2)) / ((float) dimensionPixelSize2);
        C4990ab.m7417i("MicroMsg.FaceScanRect", "hy: horizontalScale : %f, verticalScale : %f", Float.valueOf(f), Float.valueOf(f2));
        this.mbF = new ScaleAnimation(1.0f, f, 1.0f, 1.0f, 1, 0.0f, 1, 0.0f);
        this.mbF.setFillAfter(true);
        this.mbF.setDuration(1500);
        this.mbF.setInterpolator(getContext(), 17563654);
        this.mbF.setAnimationListener(animationListener);
        this.mbG = new ScaleAnimation(1.0f, f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.mbG.setFillAfter(true);
        this.mbG.setDuration(1500);
        this.mbG.setInterpolator(getContext(), 17563654);
        this.mbH = new ScaleAnimation(1.0f, 1.0f, 1.0f, f2, 1, 0.0f, 1, 0.0f);
        this.mbH.setFillAfter(true);
        this.mbH.setDuration(1500);
        this.mbH.setInterpolator(getContext(), 17563654);
        this.mbI = new ScaleAnimation(1.0f, 1.0f, 1.0f, f2, 1, 0.0f, 1, 1.0f);
        this.mbI.setFillAfter(true);
        this.mbI.setDuration(1500);
        this.mbI.setInterpolator(getContext(), 17563654);
        AppMethodBeat.m2505o(668);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(669);
        super.onMeasure(i, i2);
        if (this.mbK != null) {
            this.mbK.btt();
        }
        AppMethodBeat.m2505o(669);
    }
}
