package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class FaceNumberItemView extends View {
    static final long maX = 29;
    Timer maW;
    private boolean maY;
    private Paint maZ;
    private RectF mba;
    private Bitmap mbb;
    private int mbc;
    int mbd;
    Runnable mbe;

    class a extends TimerTask {
        private WeakReference<Runnable> mbg;

        /* synthetic */ a(FaceNumberItemView faceNumberItemView, Runnable runnable, byte b) {
            this(runnable);
        }

        private a(Runnable runnable) {
            AppMethodBeat.i(643);
            this.mbg = null;
            this.mbg = new WeakReference(runnable);
            AppMethodBeat.o(643);
        }

        public final void run() {
            AppMethodBeat.i(644);
            if (this.mbg == null || this.mbg.get() == null) {
                cancel();
                AppMethodBeat.o(644);
                return;
            }
            al.d((Runnable) this.mbg.get());
            AppMethodBeat.o(644);
        }
    }

    public FaceNumberItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceNumberItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(645);
        this.maW = null;
        this.maY = false;
        this.maZ = null;
        this.mba = null;
        this.mbb = null;
        this.mbc = 17;
        this.mbd = 0;
        this.mbe = new Runnable() {
            public final void run() {
                AppMethodBeat.i(642);
                if (FaceNumberItemView.this.mbd <= 30) {
                    FaceNumberItemView.this.mbd = FaceNumberItemView.this.mbd + 1;
                    FaceNumberItemView.this.invalidate();
                    AppMethodBeat.o(642);
                    return;
                }
                FaceNumberItemView.this.btK();
                AppMethodBeat.o(642);
            }
        };
        setLayerType(1, null);
        this.maZ = new Paint();
        this.maZ.setColor(context.getResources().getColor(R.color.ob));
        this.maZ.setXfermode(new PorterDuffXfermode(Mode.SRC_ATOP));
        this.mba = new RectF();
        AppMethodBeat.o(645);
    }

    public void setImageResource(int i) {
        AppMethodBeat.i(646);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i);
        if (i == R.drawable.b3k) {
            int dimensionPixelSize = (getResources().getDimensionPixelSize(R.dimen.a1w) - com.tencent.mm.bz.a.fromDPToPix(getContext(), 8)) / 2;
            Bitmap createBitmap = Bitmap.createBitmap(decodeResource.getWidth() + (dimensionPixelSize * 2), decodeResource.getHeight() + 0, Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawARGB(0, 255, 255, 255);
            canvas.drawBitmap(decodeResource, (float) dimensionPixelSize, 0.0f, null);
            this.mbb = createBitmap;
            AppMethodBeat.o(646);
            return;
        }
        this.mbb = Bitmap.createScaledBitmap(decodeResource, com.tencent.mm.bz.a.fromDPToPix(getContext(), 48), decodeResource.getHeight(), false);
        AppMethodBeat.o(646);
    }

    public void setGravity(int i) {
        AppMethodBeat.i(647);
        ab.i("MicroMsg.FaceNumberItemView", "hy: setting gravity");
        this.mbc = i;
        AppMethodBeat.o(647);
    }

    public final void btK() {
        AppMethodBeat.i(648);
        if (this.maW != null) {
            this.maW.cancel();
            this.maW = null;
        }
        AppMethodBeat.o(648);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        float width;
        float height;
        AppMethodBeat.i(649);
        super.onDraw(canvas);
        if (this.mbc == 17) {
            width = (float) ((getWidth() - this.mbb.getWidth()) >> 1);
            height = (float) ((getHeight() - this.mbb.getHeight()) >> 1);
        } else if (this.mbc == 3) {
            height = (float) ((getHeight() - this.mbb.getHeight()) >> 1);
            width = 0.0f;
        } else if (this.mbc == 5) {
            width = (float) (getWidth() - this.mbb.getWidth());
            height = (float) ((getHeight() - this.mbb.getHeight()) >> 1);
        } else {
            ab.e("MicroMsg.FaceNumberItemView", "hy: not support gravity! treat as center");
            width = (float) ((getWidth() - this.mbb.getWidth()) >> 1);
            height = (float) ((getHeight() - this.mbb.getHeight()) >> 1);
        }
        if (!this.maY) {
            canvas.drawBitmap(this.mbb, width, height, null);
        }
        this.mba.set(width, 0.0f, ((((float) this.mbb.getWidth()) * ((float) this.mbd)) / 30.0f) + width, (float) getHeight());
        canvas.drawRect(this.mba, this.maZ);
        AppMethodBeat.o(649);
    }
}
