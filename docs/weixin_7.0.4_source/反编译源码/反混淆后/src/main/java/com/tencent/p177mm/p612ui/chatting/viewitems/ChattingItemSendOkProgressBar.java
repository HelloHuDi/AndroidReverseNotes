package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.wxmm.v2helper;
import java.lang.ref.SoftReference;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.ChattingItemSendOkProgressBar */
public class ChattingItemSendOkProgressBar extends ProgressBar {
    private static SoftReference<Bitmap> zgq = null;
    private static SoftReference<Bitmap> zgr = null;
    private static SoftReference<Bitmap> zgs = null;
    private static int zgy;
    private static int zgz;
    private boolean fAA = false;
    private float rotation = 0.0f;
    private int zgm = 0;
    private int zgn = 0;
    private boolean zgo = false;
    private boolean zgp = false;
    private Bitmap zgt = null;
    private Bitmap zgu = null;
    private Bitmap zgv = null;
    private boolean zgw = false;
    private C44330a zgx = null;

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ChattingItemSendOkProgressBar$a */
    public interface C44330a {
    }

    static {
        AppMethodBeat.m2504i(33278);
        zgy = 0;
        zgz = 0;
        zgy = C1338a.fromDPToPix(C4996ah.getContext(), 1);
        zgz = C1338a.fromDPToPix(C4996ah.getContext(), 6);
        AppMethodBeat.m2505o(33278);
    }

    public ChattingItemSendOkProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChattingItemSendOkProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* Access modifiers changed, original: protected */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(33277);
        if (this.zgw) {
            canvas.saveLayerAlpha(new RectF(0.0f, 0.0f, (float) this.zgt.getWidth(), (float) this.zgt.getHeight()), 255, 31);
            if (!this.fAA) {
                canvas.drawBitmap(this.zgv, new Rect(0, 0, this.zgv.getWidth(), this.zgv.getHeight()), new Rect(zgy, zgz, this.zgv.getWidth() + zgy, this.zgv.getHeight() + zgz), null);
                AppMethodBeat.m2505o(33277);
                return;
            } else if (this.zgo) {
                if (this.zgm <= this.zgu.getWidth()) {
                    Matrix matrix = new Matrix();
                    this.rotation += 6.0f;
                    matrix.setRotate(this.rotation, (float) (this.zgt.getWidth() / 2), (float) (this.zgt.getHeight() / 2));
                    int i = ((int) this.rotation) % v2helper.VOIP_ENC_HEIGHT_LV1;
                    if (i < 270) {
                        i += v2helper.VOIP_ENC_HEIGHT_LV1;
                    }
                    if (i >= 270 && i < 450) {
                        Paint paint = new Paint();
                        paint.setColor(-16776961);
                        canvas.drawBitmap(this.zgt, matrix, paint);
                        paint.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
                        canvas.drawRect(0.0f, 0.0f, (float) this.zgt.getWidth(), (float) (this.zgt.getHeight() / 2), paint);
                    }
                    canvas.drawBitmap(this.zgu, new Rect(0, 0, this.zgm, this.zgu.getHeight()), new Rect(zgy, zgz, this.zgm + zgy, this.zgu.getHeight() + zgz), null);
                    this.zgm += 2;
                    invalidate();
                    AppMethodBeat.m2505o(33277);
                    return;
                }
                Rect rect = new Rect(0, 0, this.zgu.getWidth(), this.zgu.getHeight());
                Rect rect2 = new Rect(zgy, zgz, this.zgu.getWidth() + zgy, this.zgu.getHeight() + zgz);
                canvas.drawBitmap(this.zgu, rect, rect2, null);
                if (this.zgn < 255) {
                    Paint paint2 = new Paint();
                    paint2.setAlpha(this.zgn);
                    canvas.drawBitmap(this.zgv, rect, rect2, paint2);
                    this.zgn += 20;
                    invalidate();
                    AppMethodBeat.m2505o(33277);
                    return;
                }
                canvas.drawBitmap(this.zgv, rect, rect2, null);
                this.fAA = false;
                this.rotation = 0.0f;
                this.zgm = 0;
                this.zgn = 0;
                this.zgp = false;
                this.zgo = false;
                AppMethodBeat.m2505o(33277);
                return;
            } else if (((int) (this.rotation - 270.0f)) % v2helper.VOIP_ENC_HEIGHT_LV1 == 0 && this.zgp) {
                this.zgo = true;
                invalidate();
                AppMethodBeat.m2505o(33277);
                return;
            } else {
                Matrix matrix2 = new Matrix();
                matrix2.setRotate(this.rotation, (float) (this.zgt.getWidth() / 2), (float) (this.zgt.getHeight() / 2));
                canvas.drawBitmap(this.zgt, matrix2, null);
                this.rotation += 6.0f;
                invalidate();
                AppMethodBeat.m2505o(33277);
                return;
            }
        }
        super.onDraw(canvas);
        AppMethodBeat.m2505o(33277);
    }

    public void setDrawListener(C44330a c44330a) {
        this.zgx = c44330a;
    }

    public C44330a getDrawListener() {
        return this.zgx;
    }
}
