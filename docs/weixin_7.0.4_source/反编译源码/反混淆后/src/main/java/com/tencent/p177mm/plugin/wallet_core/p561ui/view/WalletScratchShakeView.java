package com.tencent.p177mm.plugin.wallet_core.p561ui.view;

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
import com.tencent.p177mm.pluginsdk.p1082i.C30050d;
import com.tencent.p177mm.pluginsdk.p1082i.C30050d.C30051a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView */
public class WalletScratchShakeView extends FrameLayout {
    C4458b tNW;
    boolean tNX;
    boolean tNY;
    private C4457a tNZ;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView$a */
    public interface C4457a {
        void cSD();

        /* renamed from: nt */
        void mo9504nt(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView$b */
    class C4458b extends View {
        Paint aKf;
        private int hQr = 0;
        private Bitmap maskBitmap;
        long mfT;
        int nfE;
        C30050d oOS;
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

        /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView$b$1 */
        class C44591 extends C30051a {
            C44591() {
            }

            public final void bUT() {
                AppMethodBeat.m2504i(47923);
                long az = C5046bo.m7525az(C4458b.this.mfT);
                if (C4458b.this.tND) {
                    if (az < 80) {
                        AppMethodBeat.m2505o(47923);
                        return;
                    }
                } else if (az < 1200) {
                    AppMethodBeat.m2505o(47923);
                    return;
                }
                C4458b.this.mfT = C5046bo.m7588yz();
                C4458b.this.tND = true;
                C4458b.m6838d(C4458b.this);
                AppMethodBeat.m2505o(47923);
            }
        }

        /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView$b$2 */
        class C44602 implements Runnable {
            C44602() {
            }

            public final void run() {
                AppMethodBeat.m2504i(47924);
                if (WalletScratchShakeView.this.tNZ != null) {
                    WalletScratchShakeView.this.tNZ.mo9504nt(false);
                }
                AppMethodBeat.m2505o(47924);
            }
        }

        /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView$b$3 */
        class C44613 implements Runnable {
            C44613() {
            }

            public final void run() {
                AppMethodBeat.m2504i(47925);
                if (WalletScratchShakeView.this.tNZ != null) {
                    WalletScratchShakeView.this.tNZ.mo9504nt(true);
                }
                AppMethodBeat.m2505o(47925);
            }
        }

        /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView$b$4 */
        class C44624 implements Runnable {
            C44624() {
            }

            public final void run() {
                AppMethodBeat.m2504i(47926);
                C4458b.m6839e(C4458b.this);
                AppMethodBeat.m2505o(47926);
            }
        }

        /* renamed from: com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView$b$5 */
        class C44635 implements Runnable {
            C44635() {
            }

            public final void run() {
                AppMethodBeat.m2504i(47927);
                C4458b.this.animate().alpha(0.0f).setDuration(100);
                if (WalletScratchShakeView.this.tNZ != null) {
                    WalletScratchShakeView.this.tNZ.cSD();
                }
                AppMethodBeat.m2505o(47927);
            }
        }

        public C4458b(Context context) {
            super(context);
        }

        /* renamed from: ab */
        static byte[] m6835ab(Bitmap bitmap) {
            int i = 0;
            AppMethodBeat.m2504i(47928);
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
            AppMethodBeat.m2505o(47928);
            return array;
        }

        private boolean cSE() {
            AppMethodBeat.m2504i(47929);
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
                AppMethodBeat.m2505o(47929);
                return true;
            }
            AppMethodBeat.m2505o(47929);
            return false;
        }

        private void cSF() {
            AppMethodBeat.m2504i(47930);
            if (this.tOa != null) {
                this.tOf.reset();
                this.tOf.moveTo(0.0f, this.tOn);
                this.tOf.cubicTo((float) (getWidth() / 2), (float) getHeight(), (float) (getWidth() / 2), 0.0f, (float) getWidth(), this.tOm);
                this.tOf.lineTo((float) getWidth(), 0.0f);
                this.tOf.lineTo(0.0f, 0.0f);
                this.tOa.drawPath(this.tOf, this.tOd);
            }
            invalidate();
            AppMethodBeat.m2505o(47930);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onDraw(Canvas canvas) {
            AppMethodBeat.m2504i(47931);
            canvas.save();
            if (this.maskBitmap == null) {
                int width = getWidth();
                int height = getHeight();
                C4990ab.m7417i("MicroMsg.WalletScratchShakeView", "createMasker width: %s, height: %s, waterMark: %s", Integer.valueOf(width), Integer.valueOf(height), this.tOb);
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
            AppMethodBeat.m2505o(47931);
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(47932);
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
                            C5004al.m7442n(new C44613(), 50);
                            this.tOk = true;
                            z = true;
                            break;
                        }
                    case 1:
                    case 3:
                        this.tOg = 0.0f;
                        this.tOh = 0.0f;
                        this.tOe.reset();
                        C7305d.post(new C44624(), "ScratchShakeView_calcErasePercentAndCallEnd");
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
                if (this.tOq || mo9505K(motionEvent) || !z) {
                    onTouchEvent = super.onTouchEvent(motionEvent);
                    AppMethodBeat.m2505o(47932);
                    return onTouchEvent;
                }
                AppMethodBeat.m2505o(47932);
                return true;
            }
            onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.m2505o(47932);
            return onTouchEvent;
        }

        /* renamed from: K */
        public final boolean mo9505K(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(47933);
            if (this.maskBitmap != null && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 0)) {
                int width = getWidth();
                int height = getHeight();
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int width2 = getWidth() * getHeight();
                C4990ab.m7411d("MicroMsg.WalletScratchShakeView", "checkIsTouchEraseArea, x: %s, y: %s, width: %s, height: %s, index: %s, len: %s", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()), Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf((y * width) + x), Integer.valueOf(width2));
                if ((y * width) + x > 0 && x > 0 && y > 0 && x < getWidth() && y < getHeight()) {
                    if (this.maskBitmap.getPixel(x, y) == 0) {
                        AppMethodBeat.m2505o(47933);
                        return true;
                    }
                    AppMethodBeat.m2505o(47933);
                    return false;
                }
            }
            AppMethodBeat.m2505o(47933);
            return false;
        }

        /* renamed from: d */
        static /* synthetic */ void m6838d(C4458b c4458b) {
            AppMethodBeat.m2504i(47934);
            if (c4458b.tOq) {
                C4990ab.m7416i("MicroMsg.WalletScratchShakeView", "onStartShakeOrClick, already finish clear mask");
                AppMethodBeat.m2505o(47934);
                return;
            }
            if (!c4458b.cSE()) {
                if (c4458b.tOp) {
                    c4458b.tOn += (float) (c4458b.getHeight() / 6);
                    c4458b.cSF();
                } else {
                    c4458b.tOm += (float) (c4458b.getHeight() / 6);
                    c4458b.cSF();
                }
                c4458b.tOp = !c4458b.tOp;
                if (!c4458b.tOk) {
                    C5004al.m7442n(new C44602(), 50);
                    c4458b.tOk = true;
                }
                c4458b.cSE();
            }
            AppMethodBeat.m2505o(47934);
        }

        /* renamed from: e */
        static /* synthetic */ void m6839e(C4458b c4458b) {
            AppMethodBeat.m2504i(47935);
            int width = c4458b.getWidth();
            int height = c4458b.getHeight();
            c4458b.maskBitmap.getPixels(c4458b.tOi, 0, width, 0, 0, width, height);
            float f = (float) (width * height);
            float f2 = 0.0f;
            for (int i = 0; ((float) i) < f; i++) {
                if (c4458b.tOi[i] == 0) {
                    f2 += 1.0f;
                }
            }
            if (f2 < 0.0f || f <= 0.0f) {
                f2 = 0.0f;
            } else {
                f2 /= f;
            }
            C4990ab.m7417i("MicroMsg.WalletScratchShakeView", "erasePercent: %s", Float.valueOf(f2));
            C4990ab.m7416i("MicroMsg.WalletScratchShakeView", "");
            if (f2 >= c4458b.tOr) {
                c4458b.tOq = true;
                if (!c4458b.tOl) {
                    C5004al.m7441d(new C44635());
                    c4458b.tOl = true;
                }
            }
            AppMethodBeat.m2505o(47935);
        }
    }

    public WalletScratchShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletScratchShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setScratchShakeCallback(C4457a c4457a) {
        this.tNZ = c4457a;
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(47936);
        if (this.tNW != null) {
            C4458b c4458b = this.tNW;
            C4990ab.m7416i("MicroMsg.WalletScratchShakeView", "onDestroy");
            if (c4458b.oOS != null) {
                c4458b.oOS.bgr();
            }
        }
        AppMethodBeat.m2505o(47936);
    }
}
