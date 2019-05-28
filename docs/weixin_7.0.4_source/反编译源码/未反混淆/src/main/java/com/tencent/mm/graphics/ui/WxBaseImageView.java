package com.tencent.mm.graphics.ui;

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
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.graphics.a.b;
import com.tencent.mm.graphics.a.c;
import com.tencent.mm.graphics.b.d;
import com.tencent.mm.graphics.c.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class WxBaseImageView extends FrameLayout {
    private long aIv;
    private boolean cph;
    private ViewStub eDd;
    private ViewStub eDe;
    private ImageView eDf;
    private SubsamplingScaleImageView eDg;
    private b eDh;
    private a eDi;
    private c eDj;
    private boolean eDk;
    private a eDl;
    private a eDm;
    private boolean eDn;
    private boolean eDo;
    private boolean eDp;
    private boolean eDq;
    private boolean eDr;
    private boolean eDs;
    private al eDt;
    protected int imageHeight;
    protected int imageWidth;
    private Context mContext;
    private Rect mRect;

    public WxBaseImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public WxBaseImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(57110);
        this.eDd = null;
        this.eDe = null;
        this.eDf = null;
        this.eDg = null;
        this.eDh = null;
        this.eDi = null;
        this.eDj = c.Tile;
        this.eDk = false;
        this.mRect = new Rect();
        this.eDr = false;
        this.eDs = false;
        this.eDt = null;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(R.layout.b1s, this, true);
        this.eDd = (ViewStub) findViewById(R.id.f1d);
        View inflate = this.eDd.inflate();
        if (inflate != null) {
            this.eDg = (SubsamplingScaleImageView) inflate;
            this.eDg.setVisibility(0);
        }
        com.tencent.mm.graphics.b.c cVar = com.tencent.mm.graphics.b.c.eCI;
        if (!cVar.eCM) {
            cVar.eCM = true;
            ab.i("MicroMsg.Metronome", "[start] stack:%s", bo.dpG());
            cVar.bsZ.postFrameCallback(cVar);
        }
        d.eCO.eCP = new WeakReference(this.mContext);
        this.eDg.setOnAttachStateChangeListener(new OnAttachStateChangeListener() {
            public final void onViewAttachedToWindow(View view) {
            }

            public final void onViewDetachedFromWindow(View view) {
                AppMethodBeat.i(57102);
                d.eCO.Pz();
                WxBaseImageView.a(WxBaseImageView.this);
                AppMethodBeat.o(57102);
            }
        });
        AppMethodBeat.o(57110);
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(57111);
        super.onMeasure(i, i2);
        this.mRect.left = getLeft();
        this.mRect.right = getRight();
        this.mRect.top = getTop();
        this.mRect.bottom = getBottom();
        if (getGlobalVisibleRect(this.mRect)) {
            ab.d("MicroMsg.WxBaseImageView", "alvinluo ImageView visible, can report");
            this.eDk = true;
            if (!this.eDs) {
                this.eDs = true;
                d dVar = d.eCO;
                synchronized (dVar.eCR) {
                    try {
                        if (dVar.isRunning) {
                            ab.w("MicroMsg.PerformanceMonitor", "hy: already running. stop last and run new");
                            dVar.isRunning = false;
                        }
                        if (dVar.mTimer != null) {
                            dVar.mTimer.cancel();
                        }
                        System.gc();
                        dVar.mTimer = new Timer("Handle_Monitor_mem_cpu", true);
                        dVar.eCQ.clear();
                        if (!(dVar.eCP == null || dVar.eCP.get() == null)) {
                            dVar.eCQ.put(Integer.valueOf(2), new com.tencent.mm.graphics.b.b((Context) dVar.eCP.get()));
                        }
                        dVar.mTimer.scheduleAtFixedRate(new TimerTask() {
                            public final void run() {
                                AppMethodBeat.i(57086);
                                synchronized (d.this.eCR) {
                                    try {
                                        if (d.this.isRunning) {
                                            for (a Px : d.this.eCQ.values()) {
                                                Px.Px();
                                            }
                                        } else {
                                            ab.w("MicroMsg.PerformanceMonitor", "hy: already stopped");
                                            cancel();
                                        }
                                    } finally {
                                        AppMethodBeat.o(57086);
                                    }
                                }
                            }
                        }, 0, 5);
                        dVar.isRunning = true;
                    } catch (Throwable th) {
                        AppMethodBeat.o(57111);
                    }
                }
            }
        } else {
            this.eDk = false;
        }
        PB();
        AppMethodBeat.o(57111);
    }

    public void setForceTileFlag(c cVar) {
        AppMethodBeat.i(57112);
        ab.d("MicroMsg.WxBaseImageView", "hy: setting force tile flag; %s", cVar);
        this.eDj = cVar;
        AppMethodBeat.o(57112);
    }

    public final void a(String str, com.davemorrissey.labs.subscaleview.view.a aVar) {
        AppMethodBeat.i(57113);
        ab.d("MicroMsg.WxBaseImageView", "alvinluo: loading from local file: %s, width: %d, height: %d", str, Integer.valueOf(this.imageWidth), Integer.valueOf(this.imageHeight));
        if (this.eDj == c.Tile) {
            if (this.eDg == null) {
                ab.e("MicroMsg.WxBaseImageView", "alvinluo WxBaseImageView laodFile mTileIv is null");
                AppMethodBeat.o(57113);
                return;
            } else if (str == null) {
                ab.i("MicroMsg.WxBaseImageView", "alvinluo WxBaseImageView loadFile path is null");
                AppMethodBeat.o(57113);
                return;
            } else {
                this.eDd.setVisibility(0);
                com.davemorrissey.labs.subscaleview.view.a af = com.davemorrissey.labs.subscaleview.view.a.af(str);
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
                ab.i("MicroMsg.WxBaseImageView", "alvinluo onStartLoad imagePath: %s, mStartLoadTime: %d", str, Long.valueOf(this.aIv));
                this.eDm = new a();
                this.eDm.eCW = 22;
                this.eDm.imagePath = str;
                this.eDm.cKf = getActivityName();
                this.eDo = true;
                if (aVar != null) {
                    this.eDl = new a();
                    if (aVar.uri != null) {
                        this.eDl.imagePath = aVar.uri.toString();
                    } else {
                        this.eDl.imagePath = "";
                    }
                    this.eDl.eCW = 21;
                    this.eDl.cKf = getActivityName();
                    this.eDn = true;
                } else {
                    this.eDn = false;
                }
                if (aVar != null) {
                    this.eDg.a(af, aVar);
                    AppMethodBeat.o(57113);
                    return;
                }
                this.eDg.setImage(af);
            }
        }
        AppMethodBeat.o(57113);
    }

    public final void bW(int i, int i2) {
        this.imageWidth = i;
        this.imageHeight = i2;
    }

    public void setScaleRate(float f) {
        AppMethodBeat.i(57114);
        if (this.eDg != null) {
            this.eDg.setScaleRate(f);
        }
        AppMethodBeat.o(57114);
    }

    public void setEdgeSwipeListener(SubsamplingScaleImageView.c cVar) {
        AppMethodBeat.i(57115);
        this.eDg.setEdgeSwipeListener(cVar);
        AppMethodBeat.o(57115);
    }

    public void setAnimateMode(com.tencent.mm.graphics.a.a aVar) {
        AppMethodBeat.i(57116);
        ab.d("MicroMsg.WxBaseImageView", "hy: set current animation mode: %s", aVar);
        AppMethodBeat.o(57116);
    }

    public void setFitType(ScaleType scaleType) {
        AppMethodBeat.i(57117);
        ab.d("MicroMsg.WxBaseImageView", "hy: set fit type: %s", scaleType);
        AppMethodBeat.o(57117);
    }

    public Bitmap getFullImageBitmap() {
        AppMethodBeat.i(57118);
        if (this.eDg != null) {
            Bitmap fullImageBitmap = this.eDg.getFullImageBitmap();
            AppMethodBeat.o(57118);
            return fullImageBitmap;
        }
        AppMethodBeat.o(57118);
        return null;
    }

    public void setImageMatrix(Matrix matrix) {
    }

    public void setGestureDetectorListener(SimpleOnGestureListener simpleOnGestureListener) {
        AppMethodBeat.i(57119);
        if (this.eDg != null) {
            this.eDg.setGestureDetectorListener(simpleOnGestureListener);
        }
        AppMethodBeat.o(57119);
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        AppMethodBeat.i(57120);
        if (this.eDg != null) {
            this.eDg.setOnLongClickListener(onLongClickListener);
        }
        AppMethodBeat.o(57120);
    }

    public void setOnImageLoadEventListener(final b bVar) {
        AppMethodBeat.i(57121);
        if (this.eDg != null) {
            this.eDh = new b() {
                public final void oL() {
                    AppMethodBeat.i(57104);
                    WxBaseImageView.d(WxBaseImageView.this);
                    if (bVar != null) {
                        bVar.oL();
                    }
                    AppMethodBeat.o(57104);
                }

                public final void l(Bitmap bitmap) {
                    AppMethodBeat.i(57105);
                    WxBaseImageView.e(WxBaseImageView.this);
                    if (bVar != null) {
                        bVar.l(bitmap);
                    }
                    AppMethodBeat.o(57105);
                }

                public final void a(com.davemorrissey.labs.subscaleview.a.c cVar) {
                    AppMethodBeat.i(57106);
                    WxBaseImageView.a(WxBaseImageView.this, cVar);
                    if (bVar != null) {
                        bVar.a(cVar);
                    }
                    AppMethodBeat.o(57106);
                }

                public final void b(com.davemorrissey.labs.subscaleview.a.c cVar) {
                    AppMethodBeat.i(57107);
                    WxBaseImageView.b(WxBaseImageView.this, cVar);
                    if (bVar != null) {
                        bVar.b(cVar);
                    }
                    AppMethodBeat.o(57107);
                }

                public final void c(com.davemorrissey.labs.subscaleview.a.c cVar) {
                    AppMethodBeat.i(57108);
                    WxBaseImageView.b(WxBaseImageView.this, cVar);
                    if (bVar != null) {
                        bVar.c(cVar);
                    }
                    AppMethodBeat.o(57108);
                }

                public final void oM() {
                    AppMethodBeat.i(57109);
                    ab.i("MicroMsg.WxBaseImageView", "alvinluo onPreviewReleased");
                    if (bVar != null) {
                        bVar.oM();
                    }
                    AppMethodBeat.o(57109);
                }
            };
            this.eDg.setOnImageEventListener(this.eDh);
        }
        AppMethodBeat.o(57121);
    }

    public float getScale() {
        AppMethodBeat.i(57122);
        if (this.eDg != null) {
            float scale = this.eDg.getScale();
            AppMethodBeat.o(57122);
            return scale;
        }
        AppMethodBeat.o(57122);
        return 1.0f;
    }

    public final void PA() {
        AppMethodBeat.i(57123);
        if (this.eDg != null) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.eDg;
            subsamplingScaleImageView.a(subsamplingScaleImageView.aKy, new PointF(0.0f, 0.0f));
        }
        AppMethodBeat.o(57123);
    }

    private String getActivityName() {
        AppMethodBeat.i(57124);
        String str;
        if (this.mContext == null || !(this.mContext instanceof Activity)) {
            str = "Default";
            AppMethodBeat.o(57124);
            return str;
        }
        str = ((Activity) this.mContext).getClass().getSimpleName();
        AppMethodBeat.o(57124);
        return str;
    }

    private void jp(int i) {
        AppMethodBeat.i(57125);
        try {
            if (!(this.eDg == null || this.eDl == null)) {
                this.eDl.eCY = (int) (System.currentTimeMillis() - this.aIv);
                com.davemorrissey.labs.subscaleview.d.a imageDecodeRecord = this.eDg.getImageDecodeRecord();
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
                this.eDl.fileSize = e.cs(this.eDl.imagePath);
            }
            AppMethodBeat.o(57125);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WxBaseImageView", e, "alvinluo fillPreviewInfo exception", new Object[0]);
            AppMethodBeat.o(57125);
        }
    }

    private void jq(int i) {
        AppMethodBeat.i(57126);
        try {
            if (!(this.eDg == null || this.eDm == null)) {
                this.eDm.eCY = (int) (System.currentTimeMillis() - this.aIv);
                com.davemorrissey.labs.subscaleview.d.a imageDecodeRecord = this.eDg.getImageDecodeRecord();
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
                this.eDm.fileSize = e.cs(this.eDm.imagePath);
            }
            AppMethodBeat.o(57126);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WxBaseImageView", e, "alvinluo fillMainInfo exception", new Object[0]);
            AppMethodBeat.o(57126);
        }
    }

    private void PB() {
        AppMethodBeat.i(57127);
        if (!this.eDk) {
            AppMethodBeat.o(57127);
        } else if (this.cph) {
            AppMethodBeat.o(57127);
        } else if (this.eDn && !this.eDp) {
            AppMethodBeat.o(57127);
        } else if (!this.eDo || this.eDq) {
            ab.i("MicroMsg.WxBaseImageView", "alvinluo reportImageInfo info ready and report");
            com.tencent.mm.graphics.c.a aVar = com.tencent.mm.graphics.c.a.eCU;
            com.tencent.mm.graphics.c.a.a(this.eDm, this.eDl);
            this.cph = true;
            AppMethodBeat.o(57127);
        } else {
            AppMethodBeat.o(57127);
        }
    }

    static /* synthetic */ void a(WxBaseImageView wxBaseImageView) {
        AppMethodBeat.i(57128);
        if (com.tencent.mm.graphics.b.c.eCI.eCM) {
            com.tencent.mm.graphics.b.c.eCI.stop();
        }
        if (!wxBaseImageView.eDk) {
            ab.i("MicroMsg.WxBaseImageView", "alvinluo hasReportPerformance can't report");
            AppMethodBeat.o(57128);
        } else if (wxBaseImageView.eDr) {
            ab.i("MicroMsg.WxBaseImageView", "alvinluo hasReportPerformance and return");
            AppMethodBeat.o(57128);
        } else {
            if (wxBaseImageView.eDt == null) {
                wxBaseImageView.eDt = new al("WxBaseImageViewReport");
            }
            wxBaseImageView.eDt.aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(57103);
                    synchronized (this) {
                        try {
                            ab.i("MicroMsg.WxBaseImageView", "alvinluo reportPerformanceInfo threadId: %d", Long.valueOf(Thread.currentThread().getId()));
                            com.tencent.mm.graphics.b.b Py = d.eCO.Py();
                            com.tencent.mm.graphics.c.a aVar = com.tencent.mm.graphics.c.a.eCU;
                            com.tencent.mm.graphics.c.a.a(Py);
                            WxBaseImageView.this.eDr = true;
                            WxBaseImageView.c(WxBaseImageView.this);
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(57103);
                        }
                    }
                }
            });
            AppMethodBeat.o(57128);
        }
    }

    static /* synthetic */ void c(WxBaseImageView wxBaseImageView) {
        AppMethodBeat.i(57129);
        try {
            if (wxBaseImageView.eDt != null) {
                wxBaseImageView.eDt.oAl.quit();
            }
            AppMethodBeat.o(57129);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WxBaseImageView", e, "alvinluo quitReportThread exception", new Object[0]);
            AppMethodBeat.o(57129);
        }
    }

    static /* synthetic */ void d(WxBaseImageView wxBaseImageView) {
        AppMethodBeat.i(57130);
        if (!(wxBaseImageView.eDg == null || wxBaseImageView.eDl == null || !wxBaseImageView.eDn)) {
            wxBaseImageView.jp(0);
            wxBaseImageView.eDl.eCX = 0;
            wxBaseImageView.eDp = true;
            wxBaseImageView.PB();
        }
        AppMethodBeat.o(57130);
    }

    static /* synthetic */ void e(WxBaseImageView wxBaseImageView) {
        AppMethodBeat.i(57131);
        if (!(wxBaseImageView.eDg == null || wxBaseImageView.eDm == null || !wxBaseImageView.eDo)) {
            wxBaseImageView.jq(0);
            wxBaseImageView.eDq = true;
            wxBaseImageView.PB();
        }
        AppMethodBeat.o(57131);
    }

    static /* synthetic */ void b(WxBaseImageView wxBaseImageView, com.davemorrissey.labs.subscaleview.a.c cVar) {
        AppMethodBeat.i(57133);
        if (wxBaseImageView.eDm != null) {
            wxBaseImageView.jq(cVar.errCode);
            wxBaseImageView.eDq = true;
            wxBaseImageView.PB();
        }
        AppMethodBeat.o(57133);
    }
}
