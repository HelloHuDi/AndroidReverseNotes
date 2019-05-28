package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.aj;

public abstract class VerticalScrollBar extends View {
    private Paint aFY;
    private int backgroundColor;
    private int biG;
    private float eOg;
    private float faL;
    View hVf;
    private int ieu;
    private Context mContext;
    protected float nBQ;
    protected int nBR;
    protected String[] nBS;
    private float nBT = 0.0f;
    private o nBU;
    private TextView nBV;
    private int nBW;
    private int textColor;
    private boolean yAT = false;
    public a yAU;
    private int yAV;
    private int yAW;
    private int yAX;

    public interface a {
        void kp(String str);
    }

    public abstract void Ky();

    public abstract int getToastLayoutId();

    public VerticalScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Ky();
        this.mContext = context;
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.nBW = b.b(context, 3.0f);
        this.hVf = inflate(context, getToastLayoutId(), null);
        this.yAX = b.b(context, (float) this.nBR);
        this.ieu = this.mContext.getResources().getDisplayMetrics().widthPixels;
        this.nBU = new o(this.hVf, this.yAX, this.yAX);
        this.nBV = (TextView) this.hVf.findViewById(R.id.edn);
        this.textColor = context.getResources().getColor(R.color.w4);
        this.yAV = this.mContext.getResources().getColor(R.color.a6a);
        this.backgroundColor = context.getResources().getColor(R.color.a61);
        this.yAW = aj.fromDPToPix(getContext(), 7);
        this.aFY = new Paint();
        this.aFY.setAntiAlias(true);
    }

    public void setOnScrollBarTouchListener(a aVar) {
        this.yAU = aVar;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final int measuredHeight = getMeasuredHeight();
        final int measuredWidth = getMeasuredWidth();
        float length = ((float) measuredHeight) / (((float) this.nBS.length) * this.nBQ);
        float fromDPToPix = (float) aj.fromDPToPix(getContext(), 9);
        this.eOg = (float) aj.fromDPToPix(getContext(), 11);
        if (this.eOg <= length) {
            length = this.eOg;
        }
        this.eOg = length;
        this.eOg = this.eOg < fromDPToPix ? fromDPToPix : this.eOg;
        this.aFY.setTextSize(this.eOg);
        if (this.nBT != this.eOg) {
            this.nBT = this.eOg;
            post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(107087);
                    if (VerticalScrollBar.this.nBS.length <= 0) {
                        AppMethodBeat.o(107087);
                        return;
                    }
                    int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(VerticalScrollBar.this.getContext(), 16) + ((int) VerticalScrollBar.this.aFY.measureText(VerticalScrollBar.this.nBS[VerticalScrollBar.this.nBS.length - 1]));
                    int length = (int) ((((float) VerticalScrollBar.this.nBS.length) * VerticalScrollBar.this.eOg) * VerticalScrollBar.this.nBQ);
                    if (length > measuredHeight || length == 0) {
                        length = measuredHeight;
                    }
                    if (fromDPToPix > measuredWidth) {
                        fromDPToPix = measuredWidth;
                    }
                    LayoutParams layoutParams = VerticalScrollBar.this.getLayoutParams();
                    layoutParams.width = fromDPToPix;
                    layoutParams.height = length;
                    VerticalScrollBar.this.setLayoutParams(layoutParams);
                    AppMethodBeat.o(107087);
                }
            });
        }
        if (this.yAT && this.biG != 0) {
            this.aFY.setStyle(Style.FILL);
            this.aFY.setColor(this.backgroundColor);
            canvas.drawCircle(((float) measuredWidth) / 2.0f, ((this.eOg / 2.0f) + ((((float) this.biG) * this.eOg) * this.nBQ)) + ((float) aj.fromDPToPix(this.mContext, 1)), (float) this.yAW, this.aFY);
        }
        this.aFY.setTextAlign(Align.CENTER);
        int i = 0;
        while (i < this.nBS.length) {
            if (this.yAT && this.biG != 0 && this.biG == i) {
                this.aFY.setColor(this.yAV);
            } else {
                this.aFY.setColor(this.textColor);
            }
            canvas.drawText(this.nBS[i], ((float) measuredWidth) / 2.0f, this.eOg + ((((float) i) * this.eOg) * this.nBQ), this.aFY);
            i++;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
            this.yAT = true;
            this.faL = motionEvent.getY();
            if (this.faL < 0.0f) {
                this.faL = 0.0f;
            }
            if (this.faL > ((float) getMeasuredHeight())) {
                this.faL = (float) getMeasuredHeight();
            }
            int i = (int) (this.faL / (this.eOg * this.nBQ));
            if (i >= this.nBS.length) {
                i = this.nBS.length - 1;
            }
            this.biG = i;
            if (this.biG == -1) {
                this.nBV.setText(R.string.dz6);
            } else {
                this.nBV.setText(this.nBS[this.biG]);
            }
            i = this.ieu - aj.fromDPToPix(getContext(), 120);
            int rawY = (int) ((((double) ((this.eOg / 2.0f) + ((((float) this.biG) * this.eOg) * this.nBQ))) - (((double) this.yAX) / 2.0d)) + ((double) (motionEvent.getRawY() - motionEvent.getY())));
            if (motionEvent.getAction() == 0) {
                this.nBU.showAtLocation(this, 0, i, rawY);
            }
            if (motionEvent.getAction() == 2) {
                this.nBU.update(i, rawY, this.yAX, this.yAX);
            }
            if (this.yAU != null) {
                if (this.biG == -1) {
                    this.yAU.kp(com.tencent.mm.bz.a.an(getContext(), R.string.dz6));
                } else {
                    this.yAU.kp(this.nBS[this.biG]);
                }
            }
            invalidate();
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.nBU.dismiss();
            this.yAT = false;
        }
        return true;
    }
}
