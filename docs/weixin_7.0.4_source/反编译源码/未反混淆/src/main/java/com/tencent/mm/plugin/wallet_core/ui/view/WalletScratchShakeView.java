package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class WalletScratchShakeView extends FrameLayout {
    b tNW;
    boolean tNX;
    boolean tNY;
    private a tNZ;

    public interface a {
        void cSD();

        void nt(boolean z);
    }

    class b extends View {
        Paint aKf;
        private int hQr = 0;
        private Bitmap maskBitmap;
        long mfT;
        int nfE;
        d oOS;
        private boolean tND = false;
        private Canvas tOa;
        Drawable tOb;
        Paint tOc;
        Paint tOd;
        Path tOe;
        Path tOf;
        private float tOg;
        private float tOh;
        private int[] tOi;
        private int tOj = -1;
        boolean tOk;
        boolean tOl;
        float tOm;
        float tOn;
        int tOo;
        private boolean tOp;
        boolean tOq;
        private float tOr = 0.9f;

        public b(Context context) {
            super(context);
        }

        static byte[] ab(Bitmap bitmap) {
            int i = 0;
            AppMethodBeat.i(47928);
            int[] iArr = new int[]{30, bitmap.getWidth() / 3, bitmap.getWidth() - (bitmap.getWidth() / 3), bitmap.getWidth() - 30};
            int[] iArr2 = new int[]{0, bitmap.getHeight()};
            ByteBuffer order = ByteBuffer.allocate(92).order(ByteOrder.nativeOrder());
            order.put((byte) 1);
            order.put((byte) 4);
            order.put((byte) 2);
            order.put((byte) 9);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(iArr[0]);
            order.putInt(iArr[1]);
            order.putInt(iArr[2]);
            order.putInt(iArr[3]);
            order.putInt(iArr2[0]);
            order.putInt(iArr2[1]);
            while (i < 9) {
                order.putInt(1);
                i++;
            }
            byte[] array = order.array();
            AppMethodBeat.o(47928);
            return array;
        }

        private boolean cSE() {
            AppMethodBeat.i(47929);
            if (this.tOn >= ((float) getHeight())) {
                this.tOq = true;
                if (!this.tOl) {
                    if (WalletScratchShakeView.this.tNZ != null) {
                        WalletScratchShakeView.this.tNZ.cSD();
                    }
                    this.tOl = true;
                }
                if (this.tOa != null) {
                    this.tOf.reset();
                    this.tOf.moveTo(0.0f, 0.0f);
                    this.tOf.lineTo((float) getWidth(), 0.0f);
                    this.tOf.lineTo((float) getWidth(), (float) getHeight());
                    this.tOf.lineTo(0.0f, (float) getHeight());
                    this.tOa.drawPath(this.tOf, this.tOd);
                }
                invalidate();
                AppMethodBeat.o(47929);
                return true;
            }
            AppMethodBeat.o(47929);
            return false;
        }

        private void cSF() {
            AppMethodBeat.i(47930);
            if (this.tOa != null) {
                this.tOf.reset();
                this.tOf.moveTo(0.0f, this.tOn);
                this.tOf.cubicTo((float) (getWidth() / 2), (float) getHeight(), (float) (getWidth() / 2), 0.0f, (float) getWidth(), this.tOm);
                this.tOf.lineTo((float) getWidth(), 0.0f);
                this.tOf.lineTo(0.0f, 0.0f);
                this.tOa.drawPath(this.tOf, this.tOd);
            }
            invalidate();
            AppMethodBeat.o(47930);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onDraw(Canvas canvas) {
            AppMethodBeat.i(47931);
            canvas.save();
            if (this.maskBitmap == null) {
                int width = getWidth();
                int height = getHeight();
                ab.i("MicroMsg.WalletScratchShakeView", "createMasker width: %s, height: %s, waterMark: %s", Integer.valueOf(width), Integer.valueOf(height), this.tOb);
                this.maskBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
                this.tOa = new Canvas(this.maskBitmap);
                if (this.tOb != null) {
                    this.tOb.setBounds(new Rect(0, 0, width, height));
                    this.tOb.draw(this.tOa);
                }
                this.tOi = new int[(width * height)];
            }
            canvas.drawBitmap(this.maskBitmap, 0.0f, 0.0f, this.aKf);
            canvas.restore();
            AppMethodBeat.o(47931);
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.i(47932);
            boolean onTouchEvent;
            if (WalletScratchShakeView.this.tNY) {
                boolean z = false;
                float x;
                float y;
                switch (motionEvent.getAction()) {
                    case 0:
                        x = motionEvent.getX();
                        y = motionEvent.getY();
                        this.tOe.reset();
                        this.tOe.moveTo(x, y);
                        this.tOg = x;
                        this.tOh = y;
                        invalidate();
                        if (!this.tOk) {
                            al.n(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(47925);
                                    if (WalletScratchShakeView.this.tNZ != null) {
                                        WalletScratchShakeView.this.tNZ.nt(true);
                                    }
                                    AppMethodBeat.o(47925);
                                }
                            }, 50);
                            this.tOk = true;
                            z = true;
                            break;
                        }
                    case 1:
                    case 3:
                        this.tOg = 0.0f;
                        this.tOh = 0.0f;
                        this.tOe.reset();
                        com.tencent.mm.sdk.g.d.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(47926);
                                b.e(b.this);
                                AppMethodBeat.o(47926);
                            }
                        }, "ScratchShakeView_calcErasePercentAndCallEnd");
                        invalidate();
                        z = true;
                        break;
                    case 2:
                        x = motionEvent.getX();
                        y = motionEvent.getY();
                        if (this.tOa != null) {
                            int abs = (int) Math.abs(y - this.tOh);
                            if (((int) Math.abs(x - this.tOg)) >= this.nfE || abs >= this.nfE) {
                                this.tOg = x;
                                this.tOh = y;
                                this.tOe.quadTo((this.tOg + x) / 2.0f, (this.tOh + y) / 2.0f, x, y);
                                this.tOa.drawPath(this.tOe, this.tOc);
                                this.tOe.reset();
                                this.tOe.moveTo(this.tOg, this.tOh);
                            }
                        }
                        invalidate();
                        z = true;
                        break;
                }
                z = true;
                if (this.tOq || K(motionEvent) || !z) {
                    onTouchEvent = super.onTouchEvent(motionEvent);
                    AppMethodBeat.o(47932);
                    return onTouchEvent;
                }
                AppMethodBeat.o(47932);
                return true;
            }
            onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(47932);
            return onTouchEvent;
        }

        public final boolean K(MotionEvent motionEvent) {
            AppMethodBeat.i(47933);
            if (this.maskBitmap != null && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 0)) {
                int width = getWidth();
                int height = getHeight();
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int width2 = getWidth() * getHeight();
                ab.d("MicroMsg.WalletScratchShakeView", "checkIsTouchEraseArea, x: %s, y: %s, width: %s, height: %s, index: %s, len: %s", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()), Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf((y * width) + x), Integer.valueOf(width2));
                if ((y * width) + x > 0 && x > 0 && y > 0 && x < getWidth() && y < getHeight()) {
                    if (this.maskBitmap.getPixel(x, y) == 0) {
                        AppMethodBeat.o(47933);
                        return true;
                    }
                    AppMethodBeat.o(47933);
                    return false;
                }
            }
            AppMethodBeat.o(47933);
            return false;
        }

        static /* synthetic */ void d(b bVar) {
            AppMethodBeat.i(47934);
            if (bVar.tOq) {
                ab.i("MicroMsg.WalletScratchShakeView", "onStartShakeOrClick, already finish clear mask");
                AppMethodBeat.o(47934);
                return;
            }
            if (!bVar.cSE()) {
                if (bVar.tOp) {
                    bVar.tOn += (float) (bVar.getHeight() / 6);
                    bVar.cSF();
                } else {
                    bVar.tOm += (float) (bVar.getHeight() / 6);
                    bVar.cSF();
                }
                bVar.tOp = !bVar.tOp;
                if (!bVar.tOk) {
                    al.n(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(47924);
                            if (WalletScratchShakeView.this.tNZ != null) {
                                WalletScratchShakeView.this.tNZ.nt(false);
                            }
                            AppMethodBeat.o(47924);
                        }
                    }, 50);
                    bVar.tOk = true;
                }
                bVar.cSE();
            }
            AppMethodBeat.o(47934);
        }

        static /* synthetic */ void e(b bVar) {
            AppMethodBeat.i(47935);
            int width = bVar.getWidth();
            int height = bVar.getHeight();
            bVar.maskBitmap.getPixels(bVar.tOi, 0, width, 0, 0, width, height);
            float f = (float) (width * height);
            float f2 = 0.0f;
            for (int i = 0; ((float) i) < f; i++) {
                if (bVar.tOi[i] == 0) {
                    f2 += 1.0f;
                }
            }
            if (f2 < 0.0f || f <= 0.0f) {
                f2 = 0.0f;
            } else {
                f2 /= f;
            }
            ab.i("MicroMsg.WalletScratchShakeView", "erasePercent: %s", Float.valueOf(f2));
            ab.i("MicroMsg.WalletScratchShakeView", "");
            if (f2 >= bVar.tOr) {
                bVar.tOq = true;
                if (!bVar.tOl) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(47927);
                            b.this.animate().alpha(0.0f).setDuration(100);
                            if (WalletScratchShakeView.this.tNZ != null) {
                                WalletScratchShakeView.this.tNZ.cSD();
                            }
                            AppMethodBeat.o(47927);
                        }
                    });
                    bVar.tOl = true;
                }
            }
            AppMethodBeat.o(47935);
        }
    }

    public WalletScratchShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletScratchShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setScratchShakeCallback(a aVar) {
        this.tNZ = aVar;
    }

    public final void onDestroy() {
        AppMethodBeat.i(47936);
        if (this.tNW != null) {
            b bVar = this.tNW;
            ab.i("MicroMsg.WalletScratchShakeView", "onDestroy");
            if (bVar.oOS != null) {
                bVar.oOS.bgr();
            }
        }
        AppMethodBeat.o(47936);
    }
}
