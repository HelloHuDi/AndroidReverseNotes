package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.widget.c;

public class WebViewBag extends FrameLayout {
    private static final int uze = (((com.tencent.mm.bz.a.ge(ah.getContext()) - b.uyh) - b.uyj) - b.uyk);
    private ImageView iUn;
    private Runnable iYR = new Runnable() {
        public final void run() {
            AppMethodBeat.i(8184);
            float currentTimeMillis = (((float) (System.currentTimeMillis() - WebViewBag.this.mStartTime)) * 1.0f) / 200.0f;
            if (currentTimeMillis <= 1.0f) {
                WebViewBag.this.lda.postDelayed(WebViewBag.this.iYR, 5);
                WebViewBag.a(WebViewBag.this, WebViewBag.this.tbZ.x + ((int) (((((float) WebViewBag.this.tca.x) * 1.0f) - ((float) WebViewBag.this.tbZ.x)) * currentTimeMillis)), ((int) (currentTimeMillis * ((((float) WebViewBag.this.tca.y) * 1.0f) - ((float) WebViewBag.this.tbZ.y)))) + WebViewBag.this.tbZ.y);
                AppMethodBeat.o(8184);
                return;
            }
            WebViewBag.a(WebViewBag.this, WebViewBag.this.tca.x, WebViewBag.this.tca.y);
            WebViewBag.e(WebViewBag.this);
            AppMethodBeat.o(8184);
        }
    };
    private View kRR;
    private WindowManager lca;
    protected ak lda;
    private OnClickListener mOnClickListener;
    private long mStartTime;
    private PointF tbX = new PointF();
    private Point tbY = new Point();
    private Point tbZ = new Point();
    private Point tca = new Point();
    private Point tcb;
    private a uzb;
    private WebViewBagBgView uzc;
    private boolean uzd;

    public interface a {
        void gz(int i, int i2);

        void onTouchEvent(MotionEvent motionEvent);
    }

    static /* synthetic */ void a(WebViewBag webViewBag, int i, int i2) {
        AppMethodBeat.i(8194);
        webViewBag.gd(i, i2);
        AppMethodBeat.o(8194);
    }

    static /* synthetic */ void e(WebViewBag webViewBag) {
        AppMethodBeat.i(8195);
        webViewBag.onAnimationEnd();
        AppMethodBeat.o(8195);
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(8185);
        ab.i("MicroMsg.WebViewBag", "onConfigurationChanged orientation:%d", Integer.valueOf(configuration.orientation));
        this.tcb.x = com.tencent.mm.bz.a.gd(ah.getContext());
        this.tcb.y = com.tencent.mm.bz.a.ge(ah.getContext());
        AppMethodBeat.o(8185);
    }

    public WebViewBag(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(8186);
        this.lca = (WindowManager) context.getSystemService("window");
        this.lda = new ak();
        this.tcb = new Point(com.tencent.mm.bz.a.gd(ah.getContext()), com.tencent.mm.bz.a.ge(ah.getContext()));
        LayoutInflater.from(context).inflate(R.layout.b79, this);
        this.iUn = (ImageView) findViewById(R.id.jb);
        this.uzc = (WebViewBagBgView) findViewById(R.id.fjz);
        this.kRR = findViewById(R.id.l_);
        this.uzc.setStartColor(context.getResources().getColor(R.color.a5u));
        this.uzc.setAngryColor(context.getResources().getColor(R.color.a5t));
        AppMethodBeat.o(8186);
    }

    public final void dbe() {
        AppMethodBeat.i(8187);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(100);
        animationSet.restrictDuration(150);
        animationSet.setFillAfter(true);
        this.kRR.startAnimation(animationSet);
        AppMethodBeat.o(8187);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(8188);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(80);
        animationSet.restrictDuration(100);
        animationSet.setAnimationListener(cVar);
        animationSet.setFillAfter(true);
        this.kRR.startAnimation(animationSet);
        AppMethodBeat.o(8188);
    }

    public void setIcon(String str) {
        AppMethodBeat.i(8189);
        com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
        aVar.eQf = true;
        aVar.ePH = true;
        aVar.ePK = com.tencent.mm.plugin.i.c.XW();
        aVar.ePT = R.raw.webview_bag_default_icon;
        o.ahp().a(str, this.iUn, aVar.ahG());
        AppMethodBeat.o(8189);
    }

    public final void j(int i, int i2, long j) {
        AppMethodBeat.i(8190);
        WebViewBagBgView webViewBagBgView = this.uzc;
        webViewBagBgView.uzn = false;
        long currentTimeMillis = System.currentTimeMillis();
        ab.i("MicroMsg.WebViewBagBgView", "setAngryInfo:%d now:%d", Long.valueOf(j), Long.valueOf(currentTimeMillis));
        webViewBagBgView.mDuration = i;
        webViewBagBgView.svV = i2;
        webViewBagBgView.mStartTime = j;
        webViewBagBgView.lT(currentTimeMillis);
        if (j > currentTimeMillis) {
            webViewBagBgView.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8197);
                    WebViewBagBgView.this.uzn = true;
                    WebViewBagBgView.this.invalidate();
                    AppMethodBeat.o(8197);
                }
            }, j - currentTimeMillis);
        } else {
            webViewBagBgView.uzn = true;
        }
        webViewBagBgView.invalidate();
        AppMethodBeat.o(8190);
    }

    public void setListener(a aVar) {
        this.uzb = aVar;
    }

    public void setTouchEnable(boolean z) {
        AppMethodBeat.i(8191);
        ab.i("MicroMsg.WebViewBag", "setTouchEnable enable:%b", Boolean.valueOf(z));
        this.uzd = z;
        AppMethodBeat.o(8191);
    }

    /* Access modifiers changed, original: protected */
    public Point getLastTouchDownViewPos() {
        return this.tbY;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(Utility.DEFAULT_STREAM_BUFFER_SIZE);
        if (this.uzd) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.tbX.x = motionEvent.getRawX();
                    this.tbX.y = motionEvent.getRawY();
                    LayoutParams layoutParams = (LayoutParams) getLayoutParams();
                    this.tbY.x = layoutParams.x;
                    this.tbY.y = layoutParams.y;
                    break;
                case 1:
                    if (Math.abs(motionEvent.getRawX() - this.tbX.x) < ((float) b.b(getContext(), 3.0f)) && Math.abs(motionEvent.getRawY() - this.tbX.y) < ((float) b.b(getContext(), 3.0f))) {
                        if (this.mOnClickListener != null) {
                            this.mOnClickListener.onClick(this);
                            break;
                        }
                    }
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    this.tbZ.x = (int) Math.max(Math.min((rawX + ((float) this.tbY.x)) - this.tbX.x, (float) this.tcb.x), 0.0f);
                    this.tbZ.y = (int) Math.max(Math.min((rawY + ((float) this.tbY.y)) - this.tbX.y, (float) this.tcb.y), 0.0f);
                    if (this.tbZ.x + (getWidth() / 2) <= this.tcb.x / 2) {
                        this.tca.x = b.uyk;
                    } else {
                        this.tca.x = (this.tcb.x - getWidth()) - b.uyk;
                    }
                    this.tca.y = this.tbZ.y;
                    if (this.tca.y == 0) {
                        this.tca.y = b.uyk;
                    } else if (this.tca.y > uze) {
                        this.tca.y = uze;
                    }
                    this.mStartTime = System.currentTimeMillis();
                    this.lda.postDelayed(this.iYR, 5);
                    if (this.uzb != null) {
                        this.uzb.gz(this.tca.x, this.tca.y);
                        break;
                    }
                    break;
                case 2:
                    gd((int) Math.max(Math.min((((float) this.tbY.x) + motionEvent.getRawX()) - this.tbX.x, (float) this.tcb.x), 0.0f), (int) Math.max(Math.min((((float) this.tbY.y) + motionEvent.getRawY()) - this.tbX.y, (float) this.tcb.y), 0.0f));
                    break;
            }
            if (this.uzb != null) {
                this.uzb.onTouchEvent(motionEvent);
            }
            AppMethodBeat.o(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(Utility.DEFAULT_STREAM_BUFFER_SIZE);
        return onTouchEvent;
    }

    static {
        AppMethodBeat.i(8196);
        AppMethodBeat.o(8196);
    }

    private void gd(int i, int i2) {
        AppMethodBeat.i(8193);
        if (this.lca != null) {
            LayoutParams layoutParams = (LayoutParams) getLayoutParams();
            layoutParams.x = i;
            layoutParams.y = i2;
            try {
                this.lca.updateViewLayout(this, layoutParams);
                AppMethodBeat.o(8193);
                return;
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.WebViewBag", th, "", new Object[0]);
            }
        }
        AppMethodBeat.o(8193);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
