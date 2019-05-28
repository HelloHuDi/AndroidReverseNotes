package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bz.a;
import com.tencent.mm.sdk.platformtools.ab;

public class MovingImageButton extends ImageView {
    private int ieu;
    private int iev;
    private int itQ;
    private int itR;
    private Context mContext;
    private int nfE;
    private int uJR;
    private int uJS;
    private int uJT = 0;
    private int uJU = 0;
    private MarginLayoutParams uJV;
    private final int uJW = 100;
    private int uJX;
    private boolean uJY = false;
    private boolean uJZ = true;
    private int x;
    private int y;

    public MovingImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public MovingImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(10056);
        super.onFinishInflate();
        this.uJX = a.fromDPToPix(this.mContext, 100);
        this.ieu = a.gd(this.mContext);
        this.iev = a.ge(this.mContext);
        this.nfE = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
        AppMethodBeat.o(10056);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(10057);
        if (this.uJZ) {
            if (this.uJT == 0 || this.uJU == 0) {
                Rect rect = new Rect();
                getWindowVisibleDisplayFrame(rect);
                this.uJT = rect.right - rect.left;
                this.uJU = rect.bottom - rect.top;
                ab.d("MicroMsg.MovingImageButton", "right = %d, top = %d, left = %d, bottom = %d, screenX = %d, screenY = %d", Integer.valueOf(rect.right), Integer.valueOf(rect.top), Integer.valueOf(rect.left), Integer.valueOf(rect.bottom), Integer.valueOf(this.uJT), Integer.valueOf(this.uJU));
            }
            this.x = (int) motionEvent.getRawX();
            this.y = (int) motionEvent.getRawY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.uJR = this.x;
                    this.uJS = this.y;
                    break;
                case 1:
                    if (Math.abs(this.uJR - this.x) + Math.abs(this.uJS - this.y) <= this.nfE) {
                        performClick();
                        break;
                    }
                    if (this.y < this.uJX) {
                        this.uJV.topMargin = 0;
                    } else if (this.y > this.uJU - this.uJX) {
                        this.uJV.topMargin = this.uJU - getHeight();
                    } else if (this.x > this.uJT / 2) {
                        this.uJV.rightMargin = 0;
                    } else {
                        this.uJV.rightMargin = this.uJT - getWidth();
                    }
                    requestLayout();
                    break;
                case 2:
                    int i = this.x - this.itQ;
                    int i2 = this.y - this.itR;
                    if (!(i == 0 && i2 == 0)) {
                        this.uJV = (MarginLayoutParams) getLayoutParams();
                        MarginLayoutParams marginLayoutParams = this.uJV;
                        marginLayoutParams.rightMargin = (-i) + marginLayoutParams.rightMargin;
                        marginLayoutParams = this.uJV;
                        marginLayoutParams.topMargin += i2;
                        if (this.uJV.rightMargin < 0) {
                            this.uJV.rightMargin = 0;
                        } else if (this.uJV.rightMargin > this.uJT - getWidth()) {
                            this.uJV.rightMargin = this.uJT - getWidth();
                        }
                        if (this.uJV.topMargin < 0) {
                            this.uJV.topMargin = 0;
                        } else if (this.uJV.topMargin > this.uJU - getHeight()) {
                            this.uJV.topMargin = this.uJU - getHeight();
                        }
                        requestLayout();
                        break;
                    }
            }
            this.itQ = this.x;
            this.itR = this.y;
            AppMethodBeat.o(10057);
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(10057);
        return onTouchEvent;
    }

    public void setCanMove(boolean z) {
        this.uJZ = z;
    }
}
