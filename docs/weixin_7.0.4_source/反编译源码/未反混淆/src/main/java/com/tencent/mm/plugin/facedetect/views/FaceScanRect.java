package com.tencent.mm.plugin.facedetect.views;

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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;

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
    private b mbK;
    private ViewGroup mbL;
    public View mbM;
    public a mbN;
    public View mbv;
    private ImageView mbw;
    private ImageView mbx;
    private ImageView mby;
    private ImageView mbz;

    public enum a {
        OPENED,
        CLOSED,
        INIT;

        static {
            AppMethodBeat.o(664);
        }
    }

    public interface b {
        void btt();
    }

    public FaceScanRect(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceScanRect(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(665);
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
        LayoutInflater.from(context).inflate(R.layout.xl, this, true);
        this.mbv = findViewById(R.id.bnf);
        this.mbw = (ImageView) findViewById(R.id.bnh);
        this.mbx = (ImageView) findViewById(R.id.bni);
        this.mby = (ImageView) findViewById(R.id.bnl);
        this.mbz = (ImageView) findViewById(R.id.bnm);
        this.mbA = (ImageView) findViewById(R.id.bnn);
        this.mbB = (ImageView) findViewById(R.id.bno);
        this.mbC = (ImageView) findViewById(R.id.bnj);
        this.mbD = (ImageView) findViewById(R.id.bnk);
        this.mbM = findViewById(R.id.bng);
        this.mbL = (ViewGroup) findViewById(R.id.bnp);
        this.mbE = new ImageView[]{this.mbw, this.mbx, this.mby, this.mbz, this.mbA, this.mbB, this.mbC, this.mbD};
        this.mbN = a.INIT;
        this.mbJ = new TranslateAnimation(2, 0.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
        this.mbJ.setRepeatCount(-1);
        this.mbJ.setRepeatMode(1);
        this.mbJ.setDuration(1000);
        AppMethodBeat.o(665);
    }

    public void setOnRefreshRectListener(b bVar) {
        this.mbK = bVar;
    }

    public ViewGroup getCenterHintHolder() {
        return this.mbL;
    }

    private void btN() {
        AppMethodBeat.i(666);
        this.mbM.setVisibility(8);
        this.mbv.setBackground(null);
        this.mbM.clearAnimation();
        AppMethodBeat.o(666);
    }

    public final void b(AnimationListener animationListener) {
        AppMethodBeat.i(667);
        if (this.mbN == a.CLOSED) {
            ab.w("MicroMsg.FaceScanRect", "hy: already closed");
            if (animationListener != null) {
                animationListener.onAnimationEnd(null);
            }
            AppMethodBeat.o(667);
            return;
        }
        this.mbN = a.CLOSED;
        c(animationListener);
        this.mbw.startAnimation(this.mbF);
        this.mbz.startAnimation(this.mbI);
        this.mbA.startAnimation(this.mbH);
        this.mbD.startAnimation(this.mbG);
        btN();
        for (ImageView backgroundColor : this.mbE) {
            backgroundColor.setBackgroundColor(getResources().getColor(R.color.om));
        }
        AppMethodBeat.o(667);
    }

    private void c(AnimationListener animationListener) {
        AppMethodBeat.i(668);
        int width = getWidth();
        int height = getHeight();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.a1x);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.a1y);
        float f = ((float) (((width - (dimensionPixelSize * 2)) - (dimensionPixelSize2 * 2)) + dimensionPixelSize2)) / ((float) dimensionPixelSize2);
        float f2 = ((float) (((height - (dimensionPixelSize * 2)) - (dimensionPixelSize2 * 2)) + dimensionPixelSize2)) / ((float) dimensionPixelSize2);
        ab.i("MicroMsg.FaceScanRect", "hy: horizontalScale : %f, verticalScale : %f", Float.valueOf(f), Float.valueOf(f2));
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
        AppMethodBeat.o(668);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(669);
        super.onMeasure(i, i2);
        if (this.mbK != null) {
            this.mbK.btt();
        }
        AppMethodBeat.o(669);
    }
}
