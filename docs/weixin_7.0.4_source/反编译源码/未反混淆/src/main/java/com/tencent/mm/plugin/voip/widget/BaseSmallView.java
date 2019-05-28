package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.MMTextureView;
import java.lang.ref.WeakReference;

public abstract class BaseSmallView extends FrameLayout {
    private Runnable iYR = new Runnable() {
        public final void run() {
            AppMethodBeat.i(5136);
            float currentTimeMillis = (((float) (System.currentTimeMillis() - BaseSmallView.this.mStartTime)) * 1.0f) / 200.0f;
            if (currentTimeMillis <= 1.0f) {
                BaseSmallView.this.lda.postDelayed(BaseSmallView.this.iYR, 5);
                BaseSmallView.this.gd(BaseSmallView.this.tbZ.x + ((int) (((((float) BaseSmallView.this.tca.x) * 1.0f) - ((float) BaseSmallView.this.tbZ.x)) * currentTimeMillis)), ((int) (currentTimeMillis * ((((float) BaseSmallView.this.tca.y) * 1.0f) - ((float) BaseSmallView.this.tbZ.y)))) + BaseSmallView.this.tbZ.y);
                AppMethodBeat.o(5136);
                return;
            }
            BaseSmallView.this.gd(BaseSmallView.this.tca.x, BaseSmallView.this.tca.y);
            BaseSmallView.this.onAnimationEnd();
            AppMethodBeat.o(5136);
        }
    };
    private WindowManager lca;
    protected ak lda;
    private OnClickListener mOnClickListener;
    private long mStartTime;
    CaptureView sRg;
    protected long sRs;
    protected WeakReference<c> sVY;
    public MMTextureView sXQ;
    private PointF tbX = new PointF();
    private Point tbY = new Point();
    private Point tbZ = new Point();
    private Point tca = new Point();
    private Point tcb;

    public abstract void cLq();

    public abstract void cLr();

    public abstract OpenGlRender getFilterData();

    public abstract void onAnimationEnd();

    public abstract void setCaptureView(CaptureView captureView);

    public void c(int i, int i2, int[] iArr) {
    }

    public void cJD() {
    }

    public void setVoipBeauty(int i) {
    }

    public void setHWDecMode(int i) {
    }

    public void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5) {
    }

    public void dY(int i, int i2) {
    }

    public void uninit() {
        this.lda.removeCallbacks(this.iYR);
        this.lca = null;
        if (this.sRg != null) {
            removeView(this.sRg);
            this.sRg = null;
            ab.d("MicroMsg.Voip.BaseSmallView", "CaptureView removed");
        }
    }

    public BaseSmallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lca = (WindowManager) context.getSystemService("window");
        this.lda = new ak();
        this.tcb = new Point(this.lca.getDefaultDisplay().getWidth(), this.lca.getDefaultDisplay().getHeight());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.tbX.x = motionEvent.getRawX();
                this.tbX.y = motionEvent.getRawY();
                LayoutParams layoutParams = (LayoutParams) getLayoutParams();
                this.tbY.x = layoutParams.x;
                this.tbY.y = layoutParams.y;
                break;
            case 1:
                if (Math.abs(motionEvent.getRawX() - this.tbX.x) < ((float) b.b(getContext(), 3.0f)) && Math.abs(motionEvent.getRawY() - this.tbX.y) < ((float) b.b(getContext(), 3.0f)) && this.mOnClickListener != null) {
                    this.mOnClickListener.onClick(this);
                }
                cLq();
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                this.tbZ.x = (int) Math.max(Math.min((rawX + ((float) this.tbY.x)) - this.tbX.x, (float) this.tcb.x), 0.0f);
                this.tbZ.y = (int) Math.max(Math.min((rawY + ((float) this.tbY.y)) - this.tbX.y, (float) this.tcb.y), 0.0f);
                int b = b.b(getContext(), 5.0f);
                if (this.tbZ.x + (getWidth() / 2) <= this.tcb.x / 2) {
                    this.tca.x = b;
                } else {
                    this.tca.x = (this.tcb.x - getWidth()) - b;
                }
                this.tca.y = this.tbZ.y;
                this.mStartTime = System.currentTimeMillis();
                this.lda.postDelayed(this.iYR, 5);
                cLr();
                break;
            case 2:
                gd((int) Math.max(Math.min((((float) this.tbY.x) + motionEvent.getRawX()) - this.tbX.x, (float) this.tcb.x), 0.0f), (int) Math.max(Math.min((((float) this.tbY.y) + motionEvent.getRawY()) - this.tbX.y, (float) this.tcb.y), 0.0f));
                break;
        }
        return true;
    }

    private void gd(int i, int i2) {
        if (this.lca != null) {
            LayoutParams layoutParams = (LayoutParams) getLayoutParams();
            layoutParams.x = i;
            layoutParams.y = i2;
            ab.d("MicroMsg.Voip.BaseSmallView", "updateWindowPosition, x: %d, y: %d", Integer.valueOf(layoutParams.x), Integer.valueOf(layoutParams.y));
            try {
                this.lca.updateViewLayout(this, layoutParams);
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.Voip.BaseSmallView", th, "", new Object[0]);
            }
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setConnectSec(long j) {
        this.sRs = j;
    }

    public void setVoipUIListener(c cVar) {
        ab.i("MicroMsg.Voip.BaseSmallView", "hwViewSmall setVoipUIListener, before initHWView");
        this.sVY = new WeakReference(cVar);
        ((c) this.sVY.get()).b(this.sXQ);
    }
}
