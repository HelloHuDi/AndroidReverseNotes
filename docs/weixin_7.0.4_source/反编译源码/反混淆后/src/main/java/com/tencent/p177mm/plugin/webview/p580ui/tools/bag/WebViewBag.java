package com.tencent.p177mm.plugin.webview.p580ui.tools.bag;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.C46700c;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.WebViewBagBgView.C145861;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBag */
public class WebViewBag extends FrameLayout {
    private static final int uze = (((C1338a.m2869ge(C4996ah.getContext()) - C29876b.uyh) - C29876b.uyj) - C29876b.uyk);
    private ImageView iUn;
    private Runnable iYR = new C229301();
    private View kRR;
    private WindowManager lca;
    protected C7306ak lda;
    private OnClickListener mOnClickListener;
    private long mStartTime;
    private PointF tbX = new PointF();
    private Point tbY = new Point();
    private Point tbZ = new Point();
    private Point tca = new Point();
    private Point tcb;
    private C22931a uzb;
    private WebViewBagBgView uzc;
    private boolean uzd;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBag$1 */
    class C229301 implements Runnable {
        C229301() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8184);
            float currentTimeMillis = (((float) (System.currentTimeMillis() - WebViewBag.this.mStartTime)) * 1.0f) / 200.0f;
            if (currentTimeMillis <= 1.0f) {
                WebViewBag.this.lda.postDelayed(WebViewBag.this.iYR, 5);
                WebViewBag.m34796a(WebViewBag.this, WebViewBag.this.tbZ.x + ((int) (((((float) WebViewBag.this.tca.x) * 1.0f) - ((float) WebViewBag.this.tbZ.x)) * currentTimeMillis)), ((int) (currentTimeMillis * ((((float) WebViewBag.this.tca.y) * 1.0f) - ((float) WebViewBag.this.tbZ.y)))) + WebViewBag.this.tbZ.y);
                AppMethodBeat.m2505o(8184);
                return;
            }
            WebViewBag.m34796a(WebViewBag.this, WebViewBag.this.tca.x, WebViewBag.this.tca.y);
            WebViewBag.m34800e(WebViewBag.this);
            AppMethodBeat.m2505o(8184);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBag$a */
    public interface C22931a {
        /* renamed from: gz */
        void mo38511gz(int i, int i2);

        void onTouchEvent(MotionEvent motionEvent);
    }

    /* renamed from: a */
    static /* synthetic */ void m34796a(WebViewBag webViewBag, int i, int i2) {
        AppMethodBeat.m2504i(8194);
        webViewBag.m34801gd(i, i2);
        AppMethodBeat.m2505o(8194);
    }

    /* renamed from: e */
    static /* synthetic */ void m34800e(WebViewBag webViewBag) {
        AppMethodBeat.m2504i(8195);
        webViewBag.onAnimationEnd();
        AppMethodBeat.m2505o(8195);
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(8185);
        C4990ab.m7417i("MicroMsg.WebViewBag", "onConfigurationChanged orientation:%d", Integer.valueOf(configuration.orientation));
        this.tcb.x = C1338a.m2868gd(C4996ah.getContext());
        this.tcb.y = C1338a.m2869ge(C4996ah.getContext());
        AppMethodBeat.m2505o(8185);
    }

    public WebViewBag(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(8186);
        this.lca = (WindowManager) context.getSystemService("window");
        this.lda = new C7306ak();
        this.tcb = new Point(C1338a.m2868gd(C4996ah.getContext()), C1338a.m2869ge(C4996ah.getContext()));
        LayoutInflater.from(context).inflate(2130971209, this);
        this.iUn = (ImageView) findViewById(2131820915);
        this.uzc = (WebViewBagBgView) findViewById(2131829163);
        this.kRR = findViewById(2131820987);
        this.uzc.setStartColor(context.getResources().getColor(C25738R.color.a5u));
        this.uzc.setAngryColor(context.getResources().getColor(C25738R.color.a5t));
        AppMethodBeat.m2505o(8186);
    }

    public final void dbe() {
        AppMethodBeat.m2504i(8187);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(100);
        animationSet.restrictDuration(150);
        animationSet.setFillAfter(true);
        this.kRR.startAnimation(animationSet);
        AppMethodBeat.m2505o(8187);
    }

    /* renamed from: a */
    public final void mo38513a(C46700c c46700c) {
        AppMethodBeat.m2504i(8188);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(80);
        animationSet.restrictDuration(100);
        animationSet.setAnimationListener(c46700c);
        animationSet.setFillAfter(true);
        this.kRR.startAnimation(animationSet);
        AppMethodBeat.m2505o(8188);
    }

    public void setIcon(String str) {
        AppMethodBeat.m2504i(8189);
        C17927a c17927a = new C17927a();
        c17927a.eQf = true;
        c17927a.ePH = true;
        c17927a.ePK = C43217c.m76863XW();
        c17927a.ePT = C1318a.webview_bag_default_icon;
        C32291o.ahp().mo43766a(str, this.iUn, c17927a.ahG());
        AppMethodBeat.m2505o(8189);
    }

    /* renamed from: j */
    public final void mo38516j(int i, int i2, long j) {
        AppMethodBeat.m2504i(8190);
        WebViewBagBgView webViewBagBgView = this.uzc;
        webViewBagBgView.uzn = false;
        long currentTimeMillis = System.currentTimeMillis();
        C4990ab.m7417i("MicroMsg.WebViewBagBgView", "setAngryInfo:%d now:%d", Long.valueOf(j), Long.valueOf(currentTimeMillis));
        webViewBagBgView.mDuration = i;
        webViewBagBgView.svV = i2;
        webViewBagBgView.mStartTime = j;
        webViewBagBgView.mo26825lT(currentTimeMillis);
        if (j > currentTimeMillis) {
            webViewBagBgView.postDelayed(new C145861(), j - currentTimeMillis);
        } else {
            webViewBagBgView.uzn = true;
        }
        webViewBagBgView.invalidate();
        AppMethodBeat.m2505o(8190);
    }

    public void setListener(C22931a c22931a) {
        this.uzb = c22931a;
    }

    public void setTouchEnable(boolean z) {
        AppMethodBeat.m2504i(8191);
        C4990ab.m7417i("MicroMsg.WebViewBag", "setTouchEnable enable:%b", Boolean.valueOf(z));
        this.uzd = z;
        AppMethodBeat.m2505o(8191);
    }

    /* Access modifiers changed, original: protected */
    public Point getLastTouchDownViewPos() {
        return this.tbY;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(Utility.DEFAULT_STREAM_BUFFER_SIZE);
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
                    if (Math.abs(motionEvent.getRawX() - this.tbX.x) < ((float) C4977b.m7371b(getContext(), 3.0f)) && Math.abs(motionEvent.getRawY() - this.tbX.y) < ((float) C4977b.m7371b(getContext(), 3.0f))) {
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
                        this.tca.x = C29876b.uyk;
                    } else {
                        this.tca.x = (this.tcb.x - getWidth()) - C29876b.uyk;
                    }
                    this.tca.y = this.tbZ.y;
                    if (this.tca.y == 0) {
                        this.tca.y = C29876b.uyk;
                    } else if (this.tca.y > uze) {
                        this.tca.y = uze;
                    }
                    this.mStartTime = System.currentTimeMillis();
                    this.lda.postDelayed(this.iYR, 5);
                    if (this.uzb != null) {
                        this.uzb.mo38511gz(this.tca.x, this.tca.y);
                        break;
                    }
                    break;
                case 2:
                    m34801gd((int) Math.max(Math.min((((float) this.tbY.x) + motionEvent.getRawX()) - this.tbX.x, (float) this.tcb.x), 0.0f), (int) Math.max(Math.min((((float) this.tbY.y) + motionEvent.getRawY()) - this.tbX.y, (float) this.tcb.y), 0.0f));
                    break;
            }
            if (this.uzb != null) {
                this.uzb.onTouchEvent(motionEvent);
            }
            AppMethodBeat.m2505o(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(Utility.DEFAULT_STREAM_BUFFER_SIZE);
        return onTouchEvent;
    }

    static {
        AppMethodBeat.m2504i(8196);
        AppMethodBeat.m2505o(8196);
    }

    /* renamed from: gd */
    private void m34801gd(int i, int i2) {
        AppMethodBeat.m2504i(8193);
        if (this.lca != null) {
            LayoutParams layoutParams = (LayoutParams) getLayoutParams();
            layoutParams.x = i;
            layoutParams.y = i2;
            try {
                this.lca.updateViewLayout(this, layoutParams);
                AppMethodBeat.m2505o(8193);
                return;
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.WebViewBag", th, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(8193);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
