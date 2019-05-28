package com.tencent.p177mm.plugin.sight.encode.p513ui;

import android.content.Context;
import android.hardware.Camera.Parameters;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.p221e.C32468d;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.model.C42192d;
import com.tencent.p177mm.model.C42192d.C42190a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.encode.p1022a.C34922a;
import com.tencent.p177mm.plugin.sight.encode.p1022a.C34922a.C21852a;
import com.tencent.p177mm.plugin.sight.encode.p513ui.C21860e.C21858a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.plugin.sight.encode.ui.SightCameraView */
public abstract class SightCameraView extends FrameLayout implements C42190a {
    protected int fcL;
    private long iQb;
    private C42192d iaf;
    private Animation nCY;
    protected boolean qBA;
    protected boolean qBB;
    protected int qBC;
    protected C46205a qBD;
    private C7564ap qBE;
    private int qBF;
    private Runnable qBG;
    private Runnable qBH;
    protected C21860e qBu;
    protected C34922a qBv;
    protected ImageView qBw;
    protected Runnable qBx;
    protected long qBy;
    protected C43532b qBz;

    /* renamed from: com.tencent.mm.plugin.sight.encode.ui.SightCameraView$2 */
    class C133372 implements Runnable {
        C133372() {
        }

        public final void run() {
        }

        public final String toString() {
            AppMethodBeat.m2504i(25109);
            String str = super.toString() + "|startRecord";
            AppMethodBeat.m2505o(25109);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.encode.ui.SightCameraView$3 */
    class C133383 implements Runnable {
        C133383() {
        }

        public final void run() {
        }

        public final String toString() {
            AppMethodBeat.m2504i(25110);
            String str = super.toString() + "|cancelRecord";
            AppMethodBeat.m2505o(25110);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.encode.ui.SightCameraView$1 */
    class C290251 implements C5015a {
        C290251() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(25108);
            float clz = ((float) SightCameraView.this.qBv.clz()) / ((float) SightCameraView.this.qBC);
            if (Float.compare(clz, 0.0f) > 0 || System.currentTimeMillis() - SightCameraView.this.iQb <= 20000) {
                if (Float.compare(clz, 1.0f) <= 0 || SightCameraView.this.qBv.clA() != C21852a.Start) {
                    SightCameraView.this.mo74206aW(clz);
                } else if (!SightCameraView.this.qBv.mo55517Cw()) {
                    SightCameraView.m86399b(SightCameraView.this);
                }
                AppMethodBeat.m2505o(25108);
                return true;
            }
            C4990ab.m7413e("MicroMsg.SightCameraView", "ERROR record duration, %dms !!!", Long.valueOf(20000));
            SightCameraView.this.bty();
            AppMethodBeat.m2505o(25108);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.encode.ui.SightCameraView$b */
    protected enum C43532b {
        CREATE,
        CHANGED,
        DESTORY;

        static {
            AppMethodBeat.m2505o(25114);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.encode.ui.SightCameraView$4 */
    class C462044 implements Runnable {
        final /* synthetic */ Runnable eGq = null;

        C462044() {
        }

        public final void run() {
        }

        public final String toString() {
            AppMethodBeat.m2504i(25111);
            String str = super.toString() + "|stopRecord";
            AppMethodBeat.m2505o(25111);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.encode.ui.SightCameraView$a */
    public interface C46205a {
    }

    /* renamed from: bg */
    public abstract void mo74207bg(String str, boolean z);

    public abstract void clS();

    public abstract Surface getPreviewSurface();

    public abstract int getSurfaceHeight();

    public abstract int getSurfaceWidth();

    public abstract boolean isPlaying();

    public abstract void setFixPreviewRate(float f);

    public abstract void setIsMute(boolean z);

    public void setPreviewRate(float f) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = (int) (((float) displayMetrics.widthPixels) / f);
        C4990ab.m7417i("MicroMsg.SightCameraView", "resizeLayout width:%d, height:%d, previewRate %f", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height), Float.valueOf(f));
        postInvalidate();
    }

    public void setTargetWidth(int i) {
        this.fcL = i;
    }

    public void setRecordMaxDuring(int i) {
        C4990ab.m7410d("MicroMsg.SightCameraView", "setRecordMaxDuring recordMaxDuring : ".concat(String.valueOf(i)));
        this.qBC = i;
    }

    public SightCameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qBy = -1;
        this.qBz = C43532b.DESTORY;
        this.qBA = false;
        this.qBB = false;
        this.fcL = 320;
        this.qBC = 6500;
        this.iQb = 0;
        this.qBE = new C7564ap(Looper.getMainLooper(), new C290251(), true);
        this.qBF = -1;
        this.qBG = new C133372();
        this.qBH = new C133383();
        this.iaf = new C42192d();
        if (C21846d.ckV()) {
            SightCameraView.inflate(getContext(), 2130970685, this);
        } else {
            SightCameraView.inflate(getContext(), 2130970684, this);
        }
        this.qBA = false;
        this.qBB = false;
        this.qBu = new C21860e();
        C21860e c21860e = this.qBu;
        C4990ab.m7417i("MicroMsg.SightCamera", "init needRotate %s", Boolean.FALSE);
        if (C1427q.ete.etU) {
            c21860e.qBs.ouT = C1427q.ete.mVideoHeight;
            c21860e.qBs.ouU = C1427q.ete.mVideoWidth;
            c21860e.qBs.ouS = C1427q.ete.etW;
        }
        c21860e.qBs.ovd = C32468d.getNumberOfCameras();
        c21860e.qBs.rotate = 0;
        this.qBw = (ImageView) findViewById(2131827543);
        clT();
    }

    public SightCameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setSightMedia(C34922a c34922a) {
        this.qBv = c34922a;
        if (this.qBv != null && this.qBu != null) {
            this.qBu.mPreviewCallback = this.qBv.clB();
        }
    }

    public void setSightCameraUIIm(C46205a c46205a) {
        this.qBD = c46205a;
    }

    /* renamed from: aW */
    public final void mo74206aW(float f) {
        C4990ab.m7411d("MicroMsg.SightCameraView", "update progress %f", Float.valueOf(f));
        if (this.qBF < 0) {
            this.qBF = getResources().getDisplayMetrics().widthPixels;
        }
        int i;
        LayoutParams layoutParams;
        if (f < 0.0f) {
            LayoutParams layoutParams2 = this.qBw.getLayoutParams();
            layoutParams2.width = this.qBF;
            this.qBw.setLayoutParams(layoutParams2);
        } else if (f > 1.0f) {
            i = (this.qBF / 2) - 1;
            layoutParams = this.qBw.getLayoutParams();
            layoutParams.width = this.qBF - (i * 2);
            this.qBw.setLayoutParams(layoutParams);
        } else {
            i = (int) ((((float) getResources().getDisplayMetrics().widthPixels) * f) / 2.0f);
            layoutParams = this.qBw.getLayoutParams();
            layoutParams.width = this.qBF - (i * 2);
            this.qBw.setLayoutParams(layoutParams);
        }
    }

    private void clT() {
        if (this.qBw.getVisibility() != 4) {
            if (this.nCY != null) {
                this.nCY.cancel();
            }
            this.qBw.setVisibility(4);
        }
    }

    public C21852a getCurMediaStatus() {
        return this.qBv.clA();
    }

    /* Access modifiers changed, original: protected|final */
    public final void bty() {
        C4990ab.m7420w("MicroMsg.SightCameraView", "cancel record");
        if (this.qBv == null) {
            throw new IllegalStateException("The mSightMedia must be set!");
        }
        C9638aw.m17180RS().doN().removeCallbacks(this.qBG);
        C9638aw.m17180RS().mo10302aa(this.qBH);
        this.qBE.stopTimer();
        mo74206aW(0.0f);
        clT();
        setKeepScreenOn(false);
    }

    /* Access modifiers changed, original: protected */
    public void setStopCallback(Runnable runnable) {
        this.qBx = runnable;
    }

    /* Access modifiers changed, original: protected|final */
    public final void clU() {
        this.iaf.mo67732a(this);
    }

    /* Access modifiers changed, original: protected|final */
    public final void clV() {
        this.iaf.mo67733cy(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent.getAction() == 0 && this.qBA && this.qBB) {
            C4990ab.m7417i("MicroMsg.SightCameraView", "check double click %dms", Long.valueOf(SystemClock.elapsedRealtime() - this.qBy));
            if (SystemClock.elapsedRealtime() - this.qBy < 400) {
                this.qBu.qBt.removeMessages(4354);
                C21860e c21860e = this.qBu;
                if (c21860e.otL) {
                    Parameters parameters;
                    try {
                        parameters = c21860e.erH.getParameters();
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.SightCamera", "getParameters failed %s", e.getMessage());
                        C4990ab.printErrStackTrace("MicroMsg.SightCamera", e, "", new Object[0]);
                        parameters = null;
                    }
                    if (parameters != null) {
                        C4990ab.m7417i("MicroMsg.SightCamera", "trigger zoom, has zoomed %B, isSupported %B", Boolean.valueOf(c21860e.faH), Boolean.valueOf(parameters.isZoomSupported()));
                        if (parameters.isZoomSupported()) {
                            c21860e.qBt.removeMessages(4353);
                            if (c21860e.faH) {
                                c21860e.qBt.faI = false;
                                c21860e.qBt.faH = false;
                                c21860e.qBt.faG = C21858a.m33398f(parameters) * -1;
                                c21860e.qBt.sendMessage(c21860e.qBt.obtainMessage(4353, c21860e.erH));
                            } else {
                                c21860e.qBt.faI = false;
                                c21860e.qBt.faH = true;
                                c21860e.qBt.faG = C21858a.m33398f(parameters);
                                c21860e.qBt.sendMessage(c21860e.qBt.obtainMessage(4353, c21860e.erH));
                            }
                            if (!c21860e.faH) {
                                z = true;
                            }
                            c21860e.faH = z;
                        }
                    }
                } else {
                    C4990ab.m7420w("MicroMsg.SightCamera", "want to trigger zoom, but current status is not preview");
                }
            } else {
                C21860e c21860e2 = this.qBu;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int surfaceWidth = getSurfaceWidth();
                int surfaceHeight = getSurfaceHeight();
                if (!C1443d.m3067fP(14)) {
                    c21860e2.qBt.removeMessages(4354);
                    c21860e2.qBt.faK = x;
                    c21860e2.qBt.faL = y;
                    c21860e2.qBt.faM = surfaceWidth;
                    c21860e2.qBt.faN = surfaceHeight;
                    c21860e2.qBt.sendMessageDelayed(c21860e2.qBt.obtainMessage(4354, c21860e2.erH), 400);
                }
            }
            this.qBy = SystemClock.elapsedRealtime();
            motionEvent.getX();
            motionEvent.getY();
            C1443d.m3067fP(14);
        }
        return true;
    }

    public String getRecordPath() {
        return this.qBv.getRecordPath();
    }

    public int getDuration() {
        return this.qBv.getDuration();
    }

    /* renamed from: b */
    static /* synthetic */ void m86399b(SightCameraView sightCameraView) {
        C4990ab.m7416i("MicroMsg.SightCameraView", "stop record");
        if (sightCameraView.qBv == null) {
            throw new IllegalStateException("The mSightMedia must be set!");
        }
        C9638aw.m17180RS().mo10302aa(new C462044());
        sightCameraView.qBE.stopTimer();
        sightCameraView.mo74206aW(0.0f);
        sightCameraView.clT();
        sightCameraView.setKeepScreenOn(false);
    }
}
