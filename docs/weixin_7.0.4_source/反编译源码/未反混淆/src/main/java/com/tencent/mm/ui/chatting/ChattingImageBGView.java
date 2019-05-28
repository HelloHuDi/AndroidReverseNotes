package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class ChattingImageBGView extends ImageView {
    private int lastWidth = 0;
    private Bitmap mQQ;

    public ChattingImageBGView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(30689);
        setScaleType(ScaleType.CENTER_CROP);
        AppMethodBeat.o(30689);
    }

    public ChattingImageBGView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(30690);
        setScaleType(ScaleType.CENTER_CROP);
        AppMethodBeat.o(30690);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(30691);
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.lastWidth != i3 - i) {
            this.lastWidth = i3 - i;
            ab.d("MicroMsg.ChattingImageBGView", "on layout changed, %d, %d, %d, %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            dCq();
        }
        AppMethodBeat.o(30691);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(30692);
        this.mQQ = bitmap;
        super.setImageBitmap(bitmap);
        dCq();
        AppMethodBeat.o(30692);
    }

    private void dCq() {
        AppMethodBeat.i(30693);
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(30688);
                if (ChattingImageBGView.this.mQQ == null) {
                    ab.w("MicroMsg.ChattingImageBGView", "want to reset matrix, but bmp is null");
                    AppMethodBeat.o(30688);
                    return;
                }
                if (ChattingImageBGView.this.mQQ.getWidth() == 0) {
                    ab.w("MicroMsg.ChattingImageBGView", "want to reset matrix, but measured width error");
                }
                Matrix matrix = new Matrix();
                float measuredWidth = ((float) ChattingImageBGView.this.getMeasuredWidth()) / ((float) ChattingImageBGView.this.mQQ.getWidth());
                float measuredHeight = ((float) ChattingImageBGView.this.getMeasuredHeight()) / ((float) ChattingImageBGView.this.mQQ.getHeight());
                ab.d("MicroMsg.ChattingImageBGView", "scaleW[%f], scaleH[%f] measured width[%d] measured height[%d]", Float.valueOf(measuredWidth), Float.valueOf(measuredHeight), Integer.valueOf(ChattingImageBGView.this.getMeasuredWidth()), Integer.valueOf(ChattingImageBGView.this.getMeasuredHeight()));
                if (measuredWidth > measuredHeight) {
                    matrix.setScale(measuredWidth, measuredWidth);
                } else {
                    matrix.setScale(measuredHeight, measuredHeight);
                    matrix.postTranslate((((float) ChattingImageBGView.this.getMeasuredWidth()) - (((float) ChattingImageBGView.this.mQQ.getWidth()) * measuredHeight)) / 2.0f, 0.0f);
                }
                ChattingImageBGView.this.setImageMatrix(matrix);
                AppMethodBeat.o(30688);
            }
        });
        AppMethodBeat.o(30693);
    }
}
