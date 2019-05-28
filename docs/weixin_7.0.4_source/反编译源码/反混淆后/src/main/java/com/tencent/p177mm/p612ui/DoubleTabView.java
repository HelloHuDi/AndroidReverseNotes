package com.tencent.p177mm.p612ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.DoubleTabView */
public class DoubleTabView extends RelativeLayout {
    private int lfN;
    private int lfO = 0;
    private Bitmap lfP;
    private LinearLayout lfQ;
    private ImageView lfR;
    protected OnClickListener lfV = new C466281();
    private Matrix mMatrix = new Matrix();
    private MMTabView ygT;
    private MMTabView ygU;
    private String ygV;
    private String ygW;
    private C23529a ygX;

    /* renamed from: com.tencent.mm.ui.DoubleTabView$a */
    public interface C23529a {
        void onTabClick(int i);
    }

    /* renamed from: com.tencent.mm.ui.DoubleTabView$1 */
    class C466281 implements OnClickListener {
        C466281() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(105955);
            int intValue = ((Integer) view.getTag()).intValue();
            if (DoubleTabView.this.ygX != null) {
                DoubleTabView.this.ygX.onTabClick(intValue);
            }
            AppMethodBeat.m2505o(105955);
        }
    }

    public DoubleTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(105956);
        init();
        AppMethodBeat.m2505o(105956);
    }

    public DoubleTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(105957);
        init();
        AppMethodBeat.m2505o(105957);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(105958);
        super.onLayout(z, i, i2, i3, i4);
        this.lfN = (i3 - i) / 2;
        int i5 = this.lfN;
        if (this.lfP == null || this.lfP.getWidth() != i5) {
            String str = "MicroMsg.DoubleTabView";
            String str2 = "sharp width changed, from %d to %d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.lfP == null ? -1 : this.lfP.getWidth());
            objArr[1] = Integer.valueOf(i5);
            C4990ab.m7421w(str, str2, objArr);
            this.lfP = Bitmap.createBitmap(i5, C1338a.fromDPToPix(getContext(), 3), Config.ARGB_8888);
            new Canvas(this.lfP).drawColor(getResources().getColor(C25738R.color.a61));
            mo74815l(this.lfO, 0.0f);
            this.lfR.setImageBitmap(this.lfP);
        }
        setTo(this.lfO);
        AppMethodBeat.m2505o(105958);
    }

    private void init() {
        AppMethodBeat.m2504i(105959);
        bmo();
        bmp();
        dwP();
        dwQ();
        AppMethodBeat.m2505o(105959);
    }

    private void bmo() {
        AppMethodBeat.m2504i(105960);
        this.lfQ = new LinearLayout(getContext());
        this.lfQ.setBackgroundResource(C25738R.color.a69);
        this.lfQ.setId(2131820592);
        this.lfQ.setOrientation(0);
        addView(this.lfQ, new LayoutParams(-1, -2));
        AppMethodBeat.m2505o(105960);
    }

    private void bmp() {
        AppMethodBeat.m2504i(105961);
        this.lfR = new ImageView(getContext());
        this.lfR.setImageMatrix(this.mMatrix);
        this.lfR.setScaleType(ScaleType.MATRIX);
        this.lfR.setId(2131820593);
        LayoutParams layoutParams = new LayoutParams(-1, C1338a.fromDPToPix(getContext(), 3));
        layoutParams.addRule(8, 2131820592);
        addView(this.lfR, layoutParams);
        AppMethodBeat.m2505o(105961);
    }

    public void setFirstTabString(String str) {
        AppMethodBeat.m2504i(105962);
        this.ygV = str;
        this.ygT.setText(str);
        requestLayout();
        AppMethodBeat.m2505o(105962);
    }

    public void setSecondTabString(String str) {
        AppMethodBeat.m2504i(105963);
        this.ygW = str;
        this.ygU.setText(str);
        requestLayout();
        AppMethodBeat.m2505o(105963);
    }

    private void dwP() {
        AppMethodBeat.m2504i(105964);
        this.ygT = m88220ul(0);
        this.ygT.setText(this.ygV);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(C25738R.dimen.a_s));
        layoutParams.weight = 1.0f;
        this.lfQ.addView(this.ygT, layoutParams);
        AppMethodBeat.m2505o(105964);
    }

    private void dwQ() {
        AppMethodBeat.m2504i(105965);
        this.ygU = m88220ul(1);
        this.ygU.setText(this.ygW);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(C25738R.dimen.a_s));
        layoutParams.weight = 1.0f;
        this.lfQ.addView(this.ygU, layoutParams);
        AppMethodBeat.m2505o(105965);
    }

    /* renamed from: ul */
    private MMTabView m88220ul(int i) {
        AppMethodBeat.m2504i(105966);
        MMTabView mMTabView = new MMTabView(getContext(), i);
        mMTabView.setTag(Integer.valueOf(i));
        mMTabView.setOnClickListener(this.lfV);
        AppMethodBeat.m2505o(105966);
        return mMTabView;
    }

    public void setOnTabClickListener(C23529a c23529a) {
        this.ygX = c23529a;
    }

    public int getCurentIndex() {
        return this.lfO;
    }

    /* renamed from: l */
    public final void mo74815l(int i, float f) {
        AppMethodBeat.m2504i(105967);
        this.mMatrix.setTranslate(((float) this.lfN) * (((float) i) + f), 0.0f);
        this.lfR.setImageMatrix(this.mMatrix);
        AppMethodBeat.m2505o(105967);
    }

    public void setTo(int i) {
        AppMethodBeat.m2504i(105968);
        this.lfO = i;
        this.ygT.setTextColor(this.lfO == 0 ? getResources().getColorStateList(C25738R.color.a61) : getResources().getColorStateList(C25738R.color.a7k));
        this.ygU.setTextColor(this.lfO == 1 ? getResources().getColorStateList(C25738R.color.a61) : getResources().getColorStateList(C25738R.color.a7k));
        AppMethodBeat.m2505o(105968);
    }

    public void setFirstTabUnReadCount(String str) {
        AppMethodBeat.m2504i(105969);
        if (this.ygT != null) {
            this.ygT.setUnread(str);
        }
        AppMethodBeat.m2505o(105969);
    }

    public void setSecondTabUnReadCount(String str) {
        AppMethodBeat.m2504i(105970);
        if (this.ygU != null) {
            this.ygU.setUnread(str);
        }
        AppMethodBeat.m2505o(105970);
    }

    /* renamed from: pC */
    public final void mo74817pC(boolean z) {
        AppMethodBeat.m2504i(105971);
        if (this.ygU != null) {
            this.ygU.mo10695pR(z);
        }
        AppMethodBeat.m2505o(105971);
    }
}
