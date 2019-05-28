package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.base.o;
import com.tencent.rtmp.sharp.jni.QLog;

public class IPCallCountryCodeScrollbar extends View {
    public static final String[] nBP = new String[]{"A", "B", "C", QLog.TAG_REPORTLEVEL_DEVELOPER, QLog.TAG_REPORTLEVEL_USER, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", QLog.TAG_REPORTLEVEL_COLORUSER, "X", "Y", "Z"};
    private Paint aFY;
    private int biG;
    private float eOg;
    private float faL;
    protected float nBQ = 1.3f;
    protected int nBR = 79;
    protected String[] nBS = new String[]{"↑"};
    private float nBT = 0.0f;
    private o nBU;
    private TextView nBV;
    private int nBW;
    private a nBX;

    public interface a {
        void kp(String str);
    }

    public final void Pf(String str) {
        Object str2;
        AppMethodBeat.i(22107);
        Object obj = null;
        for (String equals : nBP) {
            if (equals.equals(str2)) {
                obj = 1;
            }
        }
        if (obj == null) {
            str2 = "#";
        }
        int length = this.nBS.length + 1;
        String[] strArr = new String[length];
        String[] strArr2 = this.nBS;
        int length2 = strArr2.length;
        int i = 0;
        int i2 = 0;
        while (i < length2) {
            String str3 = strArr2[i];
            if (str3.equals(str2)) {
                AppMethodBeat.o(22107);
                return;
            }
            strArr[i2] = str3;
            i++;
            i2++;
        }
        strArr[length - 1] = str2;
        this.nBS = strArr;
        AppMethodBeat.o(22107);
    }

    /* Access modifiers changed, original: protected */
    public int getToastLayoutId() {
        return R.layout.asw;
    }

    public IPCallCountryCodeScrollbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(22108);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.nBW = b.b(context, 3.0f);
        View inflate = inflate(context, getToastLayoutId(), null);
        int b = b.b(context, (float) this.nBR);
        this.nBU = new o(inflate, b, b);
        this.nBV = (TextView) inflate.findViewById(R.id.edn);
        this.aFY = new Paint();
        this.aFY.setAntiAlias(true);
        this.aFY.setColor(-11119018);
        this.aFY.setTextAlign(Align.CENTER);
        AppMethodBeat.o(22108);
    }

    public void setOnScrollBarTouchListener(a aVar) {
        this.nBX = aVar;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        int i = 0;
        AppMethodBeat.i(22109);
        super.onDraw(canvas);
        final int measuredHeight = getMeasuredHeight();
        final int measuredWidth = getMeasuredWidth();
        this.eOg = ((float) measuredHeight) / (((float) this.nBS.length) * this.nBQ);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.m5);
        if (this.eOg > ((float) dimensionPixelSize)) {
            this.eOg = (float) dimensionPixelSize;
        }
        this.aFY.setTextSize(this.eOg);
        if (this.nBT != this.eOg) {
            this.nBT = this.eOg;
            post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(22106);
                    if (IPCallCountryCodeScrollbar.this.nBS.length <= 0) {
                        AppMethodBeat.o(22106);
                        return;
                    }
                    int measureText = ((int) IPCallCountryCodeScrollbar.this.aFY.measureText(IPCallCountryCodeScrollbar.this.nBS[IPCallCountryCodeScrollbar.this.nBS.length - 1])) + com.tencent.mm.bz.a.fromDPToPix(IPCallCountryCodeScrollbar.this.getContext(), 8);
                    if (measureText > measuredWidth) {
                        LayoutParams layoutParams = IPCallCountryCodeScrollbar.this.getLayoutParams();
                        layoutParams.width = measureText;
                        layoutParams.height = measuredHeight;
                        IPCallCountryCodeScrollbar.this.setLayoutParams(layoutParams);
                    }
                    AppMethodBeat.o(22106);
                }
            });
        }
        if (this.eOg == ((float) dimensionPixelSize)) {
            float length = (((float) measuredHeight) - ((((float) this.nBS.length) * this.eOg) * this.nBQ)) / 2.0f;
            while (i < this.nBS.length) {
                canvas.drawText(this.nBS[i], ((float) measuredWidth) / 2.0f, (this.eOg + length) + ((((float) i) * this.eOg) * this.nBQ), this.aFY);
                i++;
            }
            AppMethodBeat.o(22109);
            return;
        }
        while (i < this.nBS.length) {
            canvas.drawText(this.nBS[i], ((float) measuredWidth) / 2.0f, this.eOg + ((((float) i) * this.eOg) * this.nBQ), this.aFY);
            i++;
        }
        AppMethodBeat.o(22109);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(22110);
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
            this.faL = motionEvent.getY();
            if (this.faL < 0.0f) {
                this.faL = 0.0f;
            }
            if (this.faL > ((float) getMeasuredHeight())) {
                this.faL = (float) getMeasuredHeight();
            }
            setBackgroundDrawable(com.tencent.mm.bz.a.g(getContext(), R.drawable.z6));
            float f = this.eOg * this.nBQ;
            int measuredHeight = (int) ((this.faL - ((((float) getMeasuredHeight()) - (((float) this.nBS.length) * f)) / 2.0f)) / f);
            if (measuredHeight < 0) {
                measuredHeight = 0;
            }
            if (measuredHeight >= this.nBS.length) {
                measuredHeight = this.nBS.length - 1;
            }
            this.biG = measuredHeight;
            if (this.biG == -1) {
                this.nBV.setText(R.string.dz6);
            } else {
                this.nBV.setText(this.nBS[this.biG]);
            }
            this.nBU.showAtLocation(this, 17, 0, 0);
            if (this.nBX != null) {
                if (this.biG == -1) {
                    this.nBX.kp(com.tencent.mm.bz.a.an(getContext(), R.string.dz6));
                } else {
                    this.nBX.kp(this.nBS[this.biG]);
                }
            }
            invalidate();
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            setBackgroundResource(0);
            this.nBU.dismiss();
        }
        AppMethodBeat.o(22110);
        return true;
    }
}
