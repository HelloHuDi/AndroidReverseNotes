package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;

public class DoubleTabView extends RelativeLayout {
    private int lfN;
    private int lfO = 0;
    private Bitmap lfP;
    private LinearLayout lfQ;
    private ImageView lfR;
    protected OnClickListener lfV = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(105955);
            int intValue = ((Integer) view.getTag()).intValue();
            if (DoubleTabView.this.ygX != null) {
                DoubleTabView.this.ygX.onTabClick(intValue);
            }
            AppMethodBeat.o(105955);
        }
    };
    private Matrix mMatrix = new Matrix();
    private MMTabView ygT;
    private MMTabView ygU;
    private String ygV;
    private String ygW;
    private a ygX;

    public interface a {
        void onTabClick(int i);
    }

    public DoubleTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(105956);
        init();
        AppMethodBeat.o(105956);
    }

    public DoubleTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(105957);
        init();
        AppMethodBeat.o(105957);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(105958);
        super.onLayout(z, i, i2, i3, i4);
        this.lfN = (i3 - i) / 2;
        int i5 = this.lfN;
        if (this.lfP == null || this.lfP.getWidth() != i5) {
            String str = "MicroMsg.DoubleTabView";
            String str2 = "sharp width changed, from %d to %d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.lfP == null ? -1 : this.lfP.getWidth());
            objArr[1] = Integer.valueOf(i5);
            ab.w(str, str2, objArr);
            this.lfP = Bitmap.createBitmap(i5, com.tencent.mm.bz.a.fromDPToPix(getContext(), 3), Config.ARGB_8888);
            new Canvas(this.lfP).drawColor(getResources().getColor(R.color.a61));
            l(this.lfO, 0.0f);
            this.lfR.setImageBitmap(this.lfP);
        }
        setTo(this.lfO);
        AppMethodBeat.o(105958);
    }

    private void init() {
        AppMethodBeat.i(105959);
        bmo();
        bmp();
        dwP();
        dwQ();
        AppMethodBeat.o(105959);
    }

    private void bmo() {
        AppMethodBeat.i(105960);
        this.lfQ = new LinearLayout(getContext());
        this.lfQ.setBackgroundResource(R.color.a69);
        this.lfQ.setId(R.id.al);
        this.lfQ.setOrientation(0);
        addView(this.lfQ, new LayoutParams(-1, -2));
        AppMethodBeat.o(105960);
    }

    private void bmp() {
        AppMethodBeat.i(105961);
        this.lfR = new ImageView(getContext());
        this.lfR.setImageMatrix(this.mMatrix);
        this.lfR.setScaleType(ScaleType.MATRIX);
        this.lfR.setId(R.id.am);
        LayoutParams layoutParams = new LayoutParams(-1, com.tencent.mm.bz.a.fromDPToPix(getContext(), 3));
        layoutParams.addRule(8, R.id.al);
        addView(this.lfR, layoutParams);
        AppMethodBeat.o(105961);
    }

    public void setFirstTabString(String str) {
        AppMethodBeat.i(105962);
        this.ygV = str;
        this.ygT.setText(str);
        requestLayout();
        AppMethodBeat.o(105962);
    }

    public void setSecondTabString(String str) {
        AppMethodBeat.i(105963);
        this.ygW = str;
        this.ygU.setText(str);
        requestLayout();
        AppMethodBeat.o(105963);
    }

    private void dwP() {
        AppMethodBeat.i(105964);
        this.ygT = ul(0);
        this.ygT.setText(this.ygV);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.dimen.a_s));
        layoutParams.weight = 1.0f;
        this.lfQ.addView(this.ygT, layoutParams);
        AppMethodBeat.o(105964);
    }

    private void dwQ() {
        AppMethodBeat.i(105965);
        this.ygU = ul(1);
        this.ygU.setText(this.ygW);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.dimen.a_s));
        layoutParams.weight = 1.0f;
        this.lfQ.addView(this.ygU, layoutParams);
        AppMethodBeat.o(105965);
    }

    private MMTabView ul(int i) {
        AppMethodBeat.i(105966);
        MMTabView mMTabView = new MMTabView(getContext(), i);
        mMTabView.setTag(Integer.valueOf(i));
        mMTabView.setOnClickListener(this.lfV);
        AppMethodBeat.o(105966);
        return mMTabView;
    }

    public void setOnTabClickListener(a aVar) {
        this.ygX = aVar;
    }

    public int getCurentIndex() {
        return this.lfO;
    }

    public final void l(int i, float f) {
        AppMethodBeat.i(105967);
        this.mMatrix.setTranslate(((float) this.lfN) * (((float) i) + f), 0.0f);
        this.lfR.setImageMatrix(this.mMatrix);
        AppMethodBeat.o(105967);
    }

    public void setTo(int i) {
        AppMethodBeat.i(105968);
        this.lfO = i;
        this.ygT.setTextColor(this.lfO == 0 ? getResources().getColorStateList(R.color.a61) : getResources().getColorStateList(R.color.a7k));
        this.ygU.setTextColor(this.lfO == 1 ? getResources().getColorStateList(R.color.a61) : getResources().getColorStateList(R.color.a7k));
        AppMethodBeat.o(105968);
    }

    public void setFirstTabUnReadCount(String str) {
        AppMethodBeat.i(105969);
        if (this.ygT != null) {
            this.ygT.setUnread(str);
        }
        AppMethodBeat.o(105969);
    }

    public void setSecondTabUnReadCount(String str) {
        AppMethodBeat.i(105970);
        if (this.ygU != null) {
            this.ygU.setUnread(str);
        }
        AppMethodBeat.o(105970);
    }

    public final void pC(boolean z) {
        AppMethodBeat.i(105971);
        if (this.ygU != null) {
            this.ygU.pR(z);
        }
        AppMethodBeat.o(105971);
    }
}
