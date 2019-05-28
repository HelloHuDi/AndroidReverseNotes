package com.tencent.mm.plugin.sight.encode.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

public abstract class SightCameraView extends FrameLayout implements com.tencent.mm.model.d.a {
    protected int fcL;
    private long iQb;
    private d iaf;
    private Animation nCY;
    protected boolean qBA;
    protected boolean qBB;
    protected int qBC;
    protected a qBD;
    private ap qBE;
    private int qBF;
    private Runnable qBG;
    private Runnable qBH;
    protected e qBu;
    protected com.tencent.mm.plugin.sight.encode.a.a qBv;
    protected ImageView qBw;
    protected Runnable qBx;
    protected long qBy;
    protected b qBz;

    protected enum b {
        CREATE,
        CHANGED,
        DESTORY;

        static {
            AppMethodBeat.o(25114);
        }
    }

    public interface a {
    }

    public abstract void bg(String str, boolean z);

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
        ab.i("MicroMsg.SightCameraView", "resizeLayout width:%d, height:%d, previewRate %f", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height), Float.valueOf(f));
        postInvalidate();
    }

    public void setTargetWidth(int i) {
        this.fcL = i;
    }

    public void setRecordMaxDuring(int i) {
        ab.d("MicroMsg.SightCameraView", "setRecordMaxDuring recordMaxDuring : ".concat(String.valueOf(i)));
        this.qBC = i;
    }

    public SightCameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qBy = -1;
        this.qBz = b.DESTORY;
        this.qBA = false;
        this.qBB = false;
        this.fcL = 320;
        this.qBC = 6500;
        this.iQb = 0;
        this.qBE = new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(25108);
                float clz = ((float) SightCameraView.this.qBv.clz()) / ((float) SightCameraView.this.qBC);
                if (Float.compare(clz, 0.0f) > 0 || System.currentTimeMillis() - SightCameraView.this.iQb <= 20000) {
                    if (Float.compare(clz, 1.0f) <= 0 || SightCameraView.this.qBv.clA() != com.tencent.mm.plugin.sight.encode.a.a.a.Start) {
                        SightCameraView.this.aW(clz);
                    } else if (!SightCameraView.this.qBv.Cw()) {
                        SightCameraView.b(SightCameraView.this);
                    }
                    AppMethodBeat.o(25108);
                    return true;
                }
                ab.e("MicroMsg.SightCameraView", "ERROR record duration, %dms !!!", Long.valueOf(20000));
                SightCameraView.this.bty();
                AppMethodBeat.o(25108);
                return false;
            }
        }, true);
        this.qBF = -1;
        this.qBG = new Runnable() {
            public final void run() {
            }

            public final String toString() {
                AppMethodBeat.i(25109);
                String str = super.toString() + "|startRecord";
                AppMethodBeat.o(25109);
                return str;
            }
        };
        this.qBH = new Runnable() {
            public final void run() {
            }

            public final String toString() {
                AppMethodBeat.i(25110);
                String str = super.toString() + "|cancelRecord";
                AppMethodBeat.o(25110);
                return str;
            }
        };
        this.iaf = new d();
        if (com.tencent.mm.plugin.sight.base.d.ckV()) {
            inflate(getContext(), R.layout.at6, this);
        } else {
            inflate(getContext(), R.layout.at5, this);
        }
        this.qBA = false;
        this.qBB = false;
        this.qBu = new e();
        e eVar = this.qBu;
        ab.i("MicroMsg.SightCamera", "init needRotate %s", Boolean.FALSE);
        if (q.ete.etU) {
            eVar.qBs.ouT = q.ete.mVideoHeight;
            eVar.qBs.ouU = q.ete.mVideoWidth;
            eVar.qBs.ouS = q.ete.etW;
        }
        eVar.qBs.ovd = com.tencent.mm.compatible.e.d.getNumberOfCameras();
        eVar.qBs.rotate = 0;
        this.qBw = (ImageView) findViewById(R.id.ed7);
        clT();
    }

    public SightCameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setSightMedia(com.tencent.mm.plugin.sight.encode.a.a aVar) {
        this.qBv = aVar;
        if (this.qBv != null && this.qBu != null) {
            this.qBu.mPreviewCallback = this.qBv.clB();
        }
    }

    public void setSightCameraUIIm(a aVar) {
        this.qBD = aVar;
    }

    public final void aW(float f) {
        ab.d("MicroMsg.SightCameraView", "update progress %f", Float.valueOf(f));
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

    public com.tencent.mm.plugin.sight.encode.a.a.a getCurMediaStatus() {
        return this.qBv.clA();
    }

    /* Access modifiers changed, original: protected|final */
    public final void bty() {
        ab.w("MicroMsg.SightCameraView", "cancel record");
        if (this.qBv == null) {
            throw new IllegalStateException("The mSightMedia must be set!");
        }
        aw.RS().doN().removeCallbacks(this.qBG);
        aw.RS().aa(this.qBH);
        this.qBE.stopTimer();
        aW(0.0f);
        clT();
        setKeepScreenOn(false);
    }

    /* Access modifiers changed, original: protected */
    public void setStopCallback(Runnable runnable) {
        this.qBx = runnable;
    }

    /* Access modifiers changed, original: protected|final */
    public final void clU() {
        this.iaf.a(this);
    }

    /* Access modifiers changed, original: protected|final */
    public final void clV() {
        this.iaf.cy(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent.getAction() == 0 && this.qBA && this.qBB) {
            ab.i("MicroMsg.SightCameraView", "check double click %dms", Long.valueOf(SystemClock.elapsedRealtime() - this.qBy));
            if (SystemClock.elapsedRealtime() - this.qBy < 400) {
                this.qBu.qBt.removeMessages(4354);
                e eVar = this.qBu;
                if (eVar.otL) {
                    Parameters parameters;
                    try {
                        parameters = eVar.erH.getParameters();
                    } catch (Exception e) {
                        ab.e("MicroMsg.SightCamera", "getParameters failed %s", e.getMessage());
                        ab.printErrStackTrace("MicroMsg.SightCamera", e, "", new Object[0]);
                        parameters = null;
                    }
                    if (parameters != null) {
                        ab.i("MicroMsg.SightCamera", "trigger zoom, has zoomed %B, isSupported %B", Boolean.valueOf(eVar.faH), Boolean.valueOf(parameters.isZoomSupported()));
                        if (parameters.isZoomSupported()) {
                            eVar.qBt.removeMessages(4353);
                            if (eVar.faH) {
                                eVar.qBt.faI = false;
                                eVar.qBt.faH = false;
                                eVar.qBt.faG = a.f(parameters) * -1;
                                eVar.qBt.sendMessage(eVar.qBt.obtainMessage(4353, eVar.erH));
                            } else {
                                eVar.qBt.faI = false;
                                eVar.qBt.faH = true;
                                eVar.qBt.faG = a.f(parameters);
                                eVar.qBt.sendMessage(eVar.qBt.obtainMessage(4353, eVar.erH));
                            }
                            if (!eVar.faH) {
                                z = true;
                            }
                            eVar.faH = z;
                        }
                    }
                } else {
                    ab.w("MicroMsg.SightCamera", "want to trigger zoom, but current status is not preview");
                }
            } else {
                e eVar2 = this.qBu;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int surfaceWidth = getSurfaceWidth();
                int surfaceHeight = getSurfaceHeight();
                if (!com.tencent.mm.compatible.util.d.fP(14)) {
                    eVar2.qBt.removeMessages(4354);
                    eVar2.qBt.faK = x;
                    eVar2.qBt.faL = y;
                    eVar2.qBt.faM = surfaceWidth;
                    eVar2.qBt.faN = surfaceHeight;
                    eVar2.qBt.sendMessageDelayed(eVar2.qBt.obtainMessage(4354, eVar2.erH), 400);
                }
            }
            this.qBy = SystemClock.elapsedRealtime();
            motionEvent.getX();
            motionEvent.getY();
            com.tencent.mm.compatible.util.d.fP(14);
        }
        return true;
    }

    public String getRecordPath() {
        return this.qBv.getRecordPath();
    }

    public int getDuration() {
        return this.qBv.getDuration();
    }

    static /* synthetic */ void b(SightCameraView sightCameraView) {
        ab.i("MicroMsg.SightCameraView", "stop record");
        if (sightCameraView.qBv == null) {
            throw new IllegalStateException("The mSightMedia must be set!");
        }
        aw.RS().aa(new Runnable() {
            final /* synthetic */ Runnable eGq = null;

            public final void run() {
            }

            public final String toString() {
                AppMethodBeat.i(25111);
                String str = super.toString() + "|stopRecord";
                AppMethodBeat.o(25111);
                return str;
            }
        });
        sightCameraView.qBE.stopTimer();
        sightCameraView.aW(0.0f);
        sightCameraView.clT();
        sightCameraView.setKeepScreenOn(false);
    }
}
