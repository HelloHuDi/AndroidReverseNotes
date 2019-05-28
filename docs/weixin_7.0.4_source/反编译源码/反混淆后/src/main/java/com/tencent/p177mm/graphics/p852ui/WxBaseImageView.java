package com.tencent.p177mm.graphics.p852ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnLongClickListener;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.davemorrissey.labs.subscaleview.p1158a.C25467c;
import com.davemorrissey.labs.subscaleview.p1447d.C31984a;
import com.davemorrissey.labs.subscaleview.view.C31985a;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.C0791c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.graphics.p1191a.C18490a;
import com.tencent.p177mm.graphics.p1191a.C18491c;
import com.tencent.p177mm.graphics.p1191a.C36695b;
import com.tencent.p177mm.graphics.p234b.C37861c;
import com.tencent.p177mm.graphics.p234b.C42123d;
import com.tencent.p177mm.graphics.p234b.C42123d.C16021;
import com.tencent.p177mm.graphics.p234b.C45408b;
import com.tencent.p177mm.graphics.p851c.C37862a;
import com.tencent.p177mm.graphics.p851c.C37862a.C9543a;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.util.Timer;

/* renamed from: com.tencent.mm.graphics.ui.WxBaseImageView */
public class WxBaseImageView extends FrameLayout {
    private long aIv;
    private boolean cph;
    private ViewStub eDd;
    private ViewStub eDe;
    private ImageView eDf;
    private SubsamplingScaleImageView eDg;
    private C36695b eDh;
    private C9544a eDi;
    private C18491c eDj;
    private boolean eDk;
    private C9543a eDl;
    private C9543a eDm;
    private boolean eDn;
    private boolean eDo;
    private boolean eDp;
    private boolean eDq;
    private boolean eDr;
    private boolean eDs;
    private C5004al eDt;
    protected int imageHeight;
    protected int imageWidth;
    private Context mContext;
    private Rect mRect;

    /* renamed from: com.tencent.mm.graphics.ui.WxBaseImageView$2 */
    class C184932 implements Runnable {
        C184932() {
        }

        public final void run() {
            AppMethodBeat.m2504i(57103);
            synchronized (this) {
                try {
                    C4990ab.m7417i("MicroMsg.WxBaseImageView", "alvinluo reportPerformanceInfo threadId: %d", Long.valueOf(Thread.currentThread().getId()));
                    C45408b Py = C42123d.eCO.mo67666Py();
                    C37862a c37862a = C37862a.eCU;
                    C37862a.m63892a(Py);
                    WxBaseImageView.this.eDr = true;
                    WxBaseImageView.m41883c(WxBaseImageView.this);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(57103);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.graphics.ui.WxBaseImageView$1 */
    class C263211 implements OnAttachStateChangeListener {
        C263211() {
        }

        public final void onViewAttachedToWindow(View view) {
        }

        public final void onViewDetachedFromWindow(View view) {
            AppMethodBeat.m2504i(57102);
            C42123d.eCO.mo67667Pz();
            WxBaseImageView.m41879a(WxBaseImageView.this);
            AppMethodBeat.m2505o(57102);
        }
    }

    public WxBaseImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public WxBaseImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(57110);
        this.eDd = null;
        this.eDe = null;
        this.eDf = null;
        this.eDg = null;
        this.eDh = null;
        this.eDi = null;
        this.eDj = C18491c.Tile;
        this.eDk = false;
        this.mRect = new Rect();
        this.eDr = false;
        this.eDs = false;
        this.eDt = null;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(2130971005, this, true);
        this.eDd = (ViewStub) findViewById(2131828438);
        View inflate = this.eDd.inflate();
        if (inflate != null) {
            this.eDg = (SubsamplingScaleImageView) inflate;
            this.eDg.setVisibility(0);
        }
        C37861c c37861c = C37861c.eCI;
        if (!c37861c.eCM) {
            c37861c.eCM = true;
            C4990ab.m7417i("MicroMsg.Metronome", "[start] stack:%s", C5046bo.dpG());
            c37861c.bsZ.postFrameCallback(c37861c);
        }
        C42123d.eCO.eCP = new WeakReference(this.mContext);
        this.eDg.setOnAttachStateChangeListener(new C263211());
        AppMethodBeat.m2505o(57110);
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(57111);
        super.onMeasure(i, i2);
        this.mRect.left = getLeft();
        this.mRect.right = getRight();
        this.mRect.top = getTop();
        this.mRect.bottom = getBottom();
        if (getGlobalVisibleRect(this.mRect)) {
            C4990ab.m7410d("MicroMsg.WxBaseImageView", "alvinluo ImageView visible, can report");
            this.eDk = true;
            if (!this.eDs) {
                this.eDs = true;
                C42123d c42123d = C42123d.eCO;
                synchronized (c42123d.eCR) {
                    try {
                        if (c42123d.isRunning) {
                            C4990ab.m7420w("MicroMsg.PerformanceMonitor", "hy: already running. stop last and run new");
                            c42123d.isRunning = false;
                        }
                        if (c42123d.mTimer != null) {
                            c42123d.mTimer.cancel();
                        }
                        System.gc();
                        c42123d.mTimer = new Timer("Handle_Monitor_mem_cpu", true);
                        c42123d.eCQ.clear();
                        if (!(c42123d.eCP == null || c42123d.eCP.get() == null)) {
                            c42123d.eCQ.put(Integer.valueOf(2), new C45408b((Context) c42123d.eCP.get()));
                        }
                        c42123d.mTimer.scheduleAtFixedRate(new C16021(), 0, 5);
                        c42123d.isRunning = true;
                    } catch (Throwable th) {
                        AppMethodBeat.m2505o(57111);
                    }
                }
            }
        } else {
            this.eDk = false;
        }
        m41878PB();
        AppMethodBeat.m2505o(57111);
    }

    public void setForceTileFlag(C18491c c18491c) {
        AppMethodBeat.m2504i(57112);
        C4990ab.m7411d("MicroMsg.WxBaseImageView", "hy: setting force tile flag; %s", c18491c);
        this.eDj = c18491c;
        AppMethodBeat.m2505o(57112);
    }

    /* renamed from: a */
    public final void mo44097a(String str, C31985a c31985a) {
        AppMethodBeat.m2504i(57113);
        C4990ab.m7411d("MicroMsg.WxBaseImageView", "alvinluo: loading from local file: %s, width: %d, height: %d", str, Integer.valueOf(this.imageWidth), Integer.valueOf(this.imageHeight));
        if (this.eDj == C18491c.Tile) {
            if (this.eDg == null) {
                C4990ab.m7412e("MicroMsg.WxBaseImageView", "alvinluo WxBaseImageView laodFile mTileIv is null");
                AppMethodBeat.m2505o(57113);
                return;
            } else if (str == null) {
                C4990ab.m7416i("MicroMsg.WxBaseImageView", "alvinluo WxBaseImageView loadFile path is null");
                AppMethodBeat.m2505o(57113);
                return;
            } else {
                this.eDd.setVisibility(0);
                C31985a af = C31985a.m51974af(str);
                int i = this.imageWidth;
                int i2 = this.imageHeight;
                if (af.bitmap == null) {
                    af.aIJ = i;
                    af.aIK = i2;
                }
                if (af.aIL != null) {
                    af.aII = true;
                    af.aIJ = af.aIL.width();
                    af.aIK = af.aIL.height();
                }
                this.aIv = System.currentTimeMillis();
                C4990ab.m7417i("MicroMsg.WxBaseImageView", "alvinluo onStartLoad imagePath: %s, mStartLoadTime: %d", str, Long.valueOf(this.aIv));
                this.eDm = new C9543a();
                this.eDm.eCW = 22;
                this.eDm.imagePath = str;
                this.eDm.cKf = getActivityName();
                this.eDo = true;
                if (c31985a != null) {
                    this.eDl = new C9543a();
                    if (c31985a.uri != null) {
                        this.eDl.imagePath = c31985a.uri.toString();
                    } else {
                        this.eDl.imagePath = "";
                    }
                    this.eDl.eCW = 21;
                    this.eDl.cKf = getActivityName();
                    this.eDn = true;
                } else {
                    this.eDn = false;
                }
                if (c31985a != null) {
                    this.eDg.mo2264a(af, c31985a);
                    AppMethodBeat.m2505o(57113);
                    return;
                }
                this.eDg.setImage(af);
            }
        }
        AppMethodBeat.m2505o(57113);
    }

    /* renamed from: bW */
    public final void mo44098bW(int i, int i2) {
        this.imageWidth = i;
        this.imageHeight = i2;
    }

    public void setScaleRate(float f) {
        AppMethodBeat.m2504i(57114);
        if (this.eDg != null) {
            this.eDg.setScaleRate(f);
        }
        AppMethodBeat.m2505o(57114);
    }

    public void setEdgeSwipeListener(C0791c c0791c) {
        AppMethodBeat.m2504i(57115);
        this.eDg.setEdgeSwipeListener(c0791c);
        AppMethodBeat.m2505o(57115);
    }

    public void setAnimateMode(C18490a c18490a) {
        AppMethodBeat.m2504i(57116);
        C4990ab.m7411d("MicroMsg.WxBaseImageView", "hy: set current animation mode: %s", c18490a);
        AppMethodBeat.m2505o(57116);
    }

    public void setFitType(ScaleType scaleType) {
        AppMethodBeat.m2504i(57117);
        C4990ab.m7411d("MicroMsg.WxBaseImageView", "hy: set fit type: %s", scaleType);
        AppMethodBeat.m2505o(57117);
    }

    public Bitmap getFullImageBitmap() {
        AppMethodBeat.m2504i(57118);
        if (this.eDg != null) {
            Bitmap fullImageBitmap = this.eDg.getFullImageBitmap();
            AppMethodBeat.m2505o(57118);
            return fullImageBitmap;
        }
        AppMethodBeat.m2505o(57118);
        return null;
    }

    public void setImageMatrix(Matrix matrix) {
    }

    public void setGestureDetectorListener(SimpleOnGestureListener simpleOnGestureListener) {
        AppMethodBeat.m2504i(57119);
        if (this.eDg != null) {
            this.eDg.setGestureDetectorListener(simpleOnGestureListener);
        }
        AppMethodBeat.m2505o(57119);
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        AppMethodBeat.m2504i(57120);
        if (this.eDg != null) {
            this.eDg.setOnLongClickListener(onLongClickListener);
        }
        AppMethodBeat.m2505o(57120);
    }

    public void setOnImageLoadEventListener(final C36695b c36695b) {
        AppMethodBeat.m2504i(57121);
        if (this.eDg != null) {
            this.eDh = new C36695b() {
                /* renamed from: oL */
                public final void mo2345oL() {
                    AppMethodBeat.m2504i(57104);
                    WxBaseImageView.m41884d(WxBaseImageView.this);
                    if (c36695b != null) {
                        c36695b.mo2345oL();
                    }
                    AppMethodBeat.m2505o(57104);
                }

                /* renamed from: l */
                public final void mo2344l(Bitmap bitmap) {
                    AppMethodBeat.m2504i(57105);
                    WxBaseImageView.m41885e(WxBaseImageView.this);
                    if (c36695b != null) {
                        c36695b.mo2344l(bitmap);
                    }
                    AppMethodBeat.m2505o(57105);
                }

                /* renamed from: a */
                public final void mo2341a(C25467c c25467c) {
                    AppMethodBeat.m2504i(57106);
                    WxBaseImageView.m41880a(WxBaseImageView.this, c25467c);
                    if (c36695b != null) {
                        c36695b.mo2341a(c25467c);
                    }
                    AppMethodBeat.m2505o(57106);
                }

                /* renamed from: b */
                public final void mo2342b(C25467c c25467c) {
                    AppMethodBeat.m2504i(57107);
                    WxBaseImageView.m41881b(WxBaseImageView.this, c25467c);
                    if (c36695b != null) {
                        c36695b.mo2342b(c25467c);
                    }
                    AppMethodBeat.m2505o(57107);
                }

                /* renamed from: c */
                public final void mo2343c(C25467c c25467c) {
                    AppMethodBeat.m2504i(57108);
                    WxBaseImageView.m41881b(WxBaseImageView.this, c25467c);
                    if (c36695b != null) {
                        c36695b.mo2343c(c25467c);
                    }
                    AppMethodBeat.m2505o(57108);
                }

                /* renamed from: oM */
                public final void mo2346oM() {
                    AppMethodBeat.m2504i(57109);
                    C4990ab.m7416i("MicroMsg.WxBaseImageView", "alvinluo onPreviewReleased");
                    if (c36695b != null) {
                        c36695b.mo2346oM();
                    }
                    AppMethodBeat.m2505o(57109);
                }
            };
            this.eDg.setOnImageEventListener(this.eDh);
        }
        AppMethodBeat.m2505o(57121);
    }

    public float getScale() {
        AppMethodBeat.m2504i(57122);
        if (this.eDg != null) {
            float scale = this.eDg.getScale();
            AppMethodBeat.m2505o(57122);
            return scale;
        }
        AppMethodBeat.m2505o(57122);
        return 1.0f;
    }

    /* renamed from: PA */
    public final void mo44096PA() {
        AppMethodBeat.m2504i(57123);
        if (this.eDg != null) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.eDg;
            subsamplingScaleImageView.mo2261a(subsamplingScaleImageView.aKy, new PointF(0.0f, 0.0f));
        }
        AppMethodBeat.m2505o(57123);
    }

    private String getActivityName() {
        AppMethodBeat.m2504i(57124);
        String str;
        if (this.mContext == null || !(this.mContext instanceof Activity)) {
            str = "Default";
            AppMethodBeat.m2505o(57124);
            return str;
        }
        str = ((Activity) this.mContext).getClass().getSimpleName();
        AppMethodBeat.m2505o(57124);
        return str;
    }

    /* renamed from: jp */
    private void m41886jp(int i) {
        AppMethodBeat.m2504i(57125);
        try {
            if (!(this.eDg == null || this.eDl == null)) {
                this.eDl.eCY = (int) (System.currentTimeMillis() - this.aIv);
                C31984a imageDecodeRecord = this.eDg.getImageDecodeRecord();
                if (imageDecodeRecord != null) {
                    this.eDl.eCZ = imageDecodeRecord.aIE;
                } else {
                    this.eDl.eCZ = 0;
                }
                this.eDl.eCX = i;
                this.eDl.orientation = this.eDg.getPreviewOrientation();
                this.eDl.width = this.eDg.getPreviewWidth();
                this.eDl.height = this.eDg.getPreviewHeight();
                this.eDl.aIY = 1;
                this.eDl.fileSize = C1173e.m2560cs(this.eDl.imagePath);
            }
            AppMethodBeat.m2505o(57125);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WxBaseImageView", e, "alvinluo fillPreviewInfo exception", new Object[0]);
            AppMethodBeat.m2505o(57125);
        }
    }

    /* renamed from: jq */
    private void m41887jq(int i) {
        AppMethodBeat.m2504i(57126);
        try {
            if (!(this.eDg == null || this.eDm == null)) {
                this.eDm.eCY = (int) (System.currentTimeMillis() - this.aIv);
                C31984a imageDecodeRecord = this.eDg.getImageDecodeRecord();
                if (imageDecodeRecord != null) {
                    this.eDm.eCZ = imageDecodeRecord.aIG + imageDecodeRecord.aIF;
                } else {
                    this.eDl.eCZ = 0;
                }
                this.eDm.eCX = i;
                this.eDm.orientation = this.eDg.getRequiredRotation();
                this.eDm.width = this.eDg.getSWidth();
                this.eDm.height = this.eDg.getSHeight();
                this.eDm.aIY = this.eDg.getFullImageSampleSize();
                this.eDm.fileSize = C1173e.m2560cs(this.eDm.imagePath);
            }
            AppMethodBeat.m2505o(57126);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WxBaseImageView", e, "alvinluo fillMainInfo exception", new Object[0]);
            AppMethodBeat.m2505o(57126);
        }
    }

    /* renamed from: PB */
    private void m41878PB() {
        AppMethodBeat.m2504i(57127);
        if (!this.eDk) {
            AppMethodBeat.m2505o(57127);
        } else if (this.cph) {
            AppMethodBeat.m2505o(57127);
        } else if (this.eDn && !this.eDp) {
            AppMethodBeat.m2505o(57127);
        } else if (!this.eDo || this.eDq) {
            C4990ab.m7416i("MicroMsg.WxBaseImageView", "alvinluo reportImageInfo info ready and report");
            C37862a c37862a = C37862a.eCU;
            C37862a.m63893a(this.eDm, this.eDl);
            this.cph = true;
            AppMethodBeat.m2505o(57127);
        } else {
            AppMethodBeat.m2505o(57127);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m41879a(WxBaseImageView wxBaseImageView) {
        AppMethodBeat.m2504i(57128);
        if (C37861c.eCI.eCM) {
            C37861c.eCI.stop();
        }
        if (!wxBaseImageView.eDk) {
            C4990ab.m7416i("MicroMsg.WxBaseImageView", "alvinluo hasReportPerformance can't report");
            AppMethodBeat.m2505o(57128);
        } else if (wxBaseImageView.eDr) {
            C4990ab.m7416i("MicroMsg.WxBaseImageView", "alvinluo hasReportPerformance and return");
            AppMethodBeat.m2505o(57128);
        } else {
            if (wxBaseImageView.eDt == null) {
                wxBaseImageView.eDt = new C5004al("WxBaseImageViewReport");
            }
            wxBaseImageView.eDt.mo10302aa(new C184932());
            AppMethodBeat.m2505o(57128);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m41883c(WxBaseImageView wxBaseImageView) {
        AppMethodBeat.m2504i(57129);
        try {
            if (wxBaseImageView.eDt != null) {
                wxBaseImageView.eDt.oAl.quit();
            }
            AppMethodBeat.m2505o(57129);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WxBaseImageView", e, "alvinluo quitReportThread exception", new Object[0]);
            AppMethodBeat.m2505o(57129);
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m41884d(WxBaseImageView wxBaseImageView) {
        AppMethodBeat.m2504i(57130);
        if (!(wxBaseImageView.eDg == null || wxBaseImageView.eDl == null || !wxBaseImageView.eDn)) {
            wxBaseImageView.m41886jp(0);
            wxBaseImageView.eDl.eCX = 0;
            wxBaseImageView.eDp = true;
            wxBaseImageView.m41878PB();
        }
        AppMethodBeat.m2505o(57130);
    }

    /* renamed from: e */
    static /* synthetic */ void m41885e(WxBaseImageView wxBaseImageView) {
        AppMethodBeat.m2504i(57131);
        if (!(wxBaseImageView.eDg == null || wxBaseImageView.eDm == null || !wxBaseImageView.eDo)) {
            wxBaseImageView.m41887jq(0);
            wxBaseImageView.eDq = true;
            wxBaseImageView.m41878PB();
        }
        AppMethodBeat.m2505o(57131);
    }

    /* renamed from: b */
    static /* synthetic */ void m41881b(WxBaseImageView wxBaseImageView, C25467c c25467c) {
        AppMethodBeat.m2504i(57133);
        if (wxBaseImageView.eDm != null) {
            wxBaseImageView.m41887jq(c25467c.errCode);
            wxBaseImageView.eDq = true;
            wxBaseImageView.m41878PB();
        }
        AppMethodBeat.m2505o(57133);
    }
}
