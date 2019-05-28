package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.smtt.sdk.WebView;

public class TalkRoomVolumeMeter extends FrameLayout {
    private a szK;
    private ImageView szL;
    private ImageView szM;
    private ImageView szN;
    private FrameLayout szO;

    class a extends SurfaceView implements Callback {
        Paint aFY;
        int max = 100;
        private float[] positions;
        private float sAa = this.szQ;
        float sAb = this.szQ;
        PaintFlagsDrawFilter sAc;
        boolean sAd = false;
        boolean started = false;
        float szP = 0.0f;
        float szQ = 0.0f;
        SurfaceHolder szR = getHolder();
        Bitmap szS;
        Bitmap szT;
        private Bitmap szU;
        Rect szV;
        int szW;
        int szX;
        ap szY;
        private boolean szZ = false;
        int value = 0;

        public a(Context context) {
            super(context);
            AppMethodBeat.i(25960);
            this.szR.addCallback(this);
            this.aFY = new Paint();
            this.aFY.setAntiAlias(true);
            this.sAc = new PaintFlagsDrawFilter(0, 3);
            this.szY = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(25959);
                    a.a(a.this);
                    boolean b = a.this.szZ;
                    AppMethodBeat.o(25959);
                    return b;
                }
            }, true);
            AppMethodBeat.o(25960);
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            AppMethodBeat.i(25961);
            ab.v("MicroMsg.TalkRoomVoiceMeter", "surfaceCreated");
            this.szS = BitmapFactory.decodeResource(getResources(), R.drawable.apw);
            this.szU = BitmapFactory.decodeResource(getResources(), R.drawable.apv);
            this.szT = BitmapFactory.decodeResource(getResources(), R.drawable.apx);
            AppMethodBeat.o(25961);
        }

        private int cEM() {
            AppMethodBeat.i(25962);
            if (this.szS == null) {
                AppMethodBeat.o(25962);
                return FacebookRequestErrorClassification.EC_INVALID_TOKEN;
            }
            int height = this.szS.getHeight();
            AppMethodBeat.o(25962);
            return height;
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            AppMethodBeat.i(25963);
            ab.v("MicroMsg.TalkRoomVoiceMeter", "surfaceChanged, width = " + i2 + " height = " + i3);
            this.szQ = 0.0f;
            this.szP = (float) (i3 - cEM());
            this.sAa = this.szQ;
            this.sAb = this.szQ;
            this.szX = i2;
            this.szW = cEM();
            this.szV = new Rect(0, (int) this.sAa, this.szX, ((int) this.sAa) + this.szW);
            this.szZ = true;
            AppMethodBeat.o(25963);
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            AppMethodBeat.i(25964);
            ab.v("MicroMsg.TalkRoomVoiceMeter", "surfaceDestroyed");
            this.szZ = false;
            this.szY.stopTimer();
            if (this.szS != null) {
                ab.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", this.szS.toString());
                this.szS.recycle();
                this.szS = null;
            }
            if (this.szU != null) {
                ab.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", this.szU.toString());
                this.szU.recycle();
                this.szU = null;
            }
            if (this.szT != null) {
                ab.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", this.szT.toString());
                this.szT.recycle();
                this.szT = null;
            }
            AppMethodBeat.o(25964);
        }

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(25965);
            if (aVar.sAb < aVar.szP || aVar.sAb > aVar.szQ) {
                AppMethodBeat.o(25965);
            } else if (aVar.szT == null || aVar.szS == null) {
                AppMethodBeat.o(25965);
            } else {
                Canvas lockCanvas = aVar.szR.lockCanvas();
                if (!(lockCanvas == null || aVar.szV == null)) {
                    lockCanvas.setDrawFilter(aVar.sAc);
                    float f = aVar.sAb;
                    if (aVar.positions == null) {
                        aVar.positions = new float[]{aVar.szQ, aVar.szQ, aVar.szQ, aVar.szQ, aVar.szQ};
                    }
                    int i = 0;
                    while (i < aVar.positions.length - 1) {
                        float[] fArr = aVar.positions;
                        fArr[i] = fArr[i + 1];
                        i++;
                    }
                    aVar.positions[i] = f;
                    aVar.sAa = ((((aVar.positions[0] + (aVar.positions[1] * 4.0f)) + (aVar.positions[2] * 6.0f)) + (aVar.positions[3] * 4.0f)) + (aVar.positions[4] * 1.0f)) / 16.0f;
                    aVar.szV.set(0, (int) aVar.sAa, aVar.szX, ((int) aVar.sAa) + aVar.szW);
                    lockCanvas.drawBitmap(aVar.sAd ? aVar.szT : aVar.szS, null, aVar.szV, aVar.aFY);
                    aVar.szR.unlockCanvasAndPost(lockCanvas);
                }
                AppMethodBeat.o(25965);
            }
        }
    }

    public TalkRoomVolumeMeter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(25966);
        initView();
        AppMethodBeat.o(25966);
    }

    public TalkRoomVolumeMeter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(25967);
        initView();
        AppMethodBeat.o(25967);
    }

    private void initView() {
        AppMethodBeat.i(25968);
        this.szK = new a(getContext());
        this.szL = new ImageView(getContext());
        this.szL.setScaleType(ScaleType.FIT_XY);
        this.szL.setImageResource(R.drawable.apz);
        this.szL.setVisibility(0);
        this.szM = new ImageView(getContext());
        this.szM.setScaleType(ScaleType.FIT_CENTER);
        this.szM.setImageResource(R.drawable.apy);
        this.szM.setVisibility(8);
        this.szN = new ImageView(getContext());
        this.szN.setScaleType(ScaleType.FIT_CENTER);
        this.szN.setImageResource(R.drawable.apv);
        this.szN.setVisibility(8);
        this.szO = new FrameLayout(getContext());
        this.szO.addView(this.szK);
        this.szO.addView(this.szM);
        this.szO.setVisibility(8);
        addView(this.szO);
        addView(this.szN);
        addView(this.szL);
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        bringChildToFront(this.szL);
        AppMethodBeat.o(25968);
    }

    private void setShowErr(boolean z) {
        AppMethodBeat.i(25969);
        this.szN.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(25969);
    }

    public void setShowFlame(boolean z) {
        AppMethodBeat.i(25970);
        this.szO.setVisibility(z ? 0 : 8);
        if (z) {
            a aVar = this.szK;
            if (!aVar.started) {
                aVar.started = true;
                aVar.szY.ae(100, 100);
            }
            AppMethodBeat.o(25970);
            return;
        }
        a aVar2 = this.szK;
        if (aVar2.started) {
            aVar2.started = false;
            if (aVar2.sAb >= aVar2.szP && aVar2.sAb <= aVar2.szQ && aVar2.szT != null && aVar2.szS != null) {
                Canvas lockCanvas = aVar2.szR.lockCanvas();
                if (!(lockCanvas == null || aVar2.szV == null)) {
                    lockCanvas.setDrawFilter(aVar2.sAc);
                    aVar2.szV.set(0, 0, aVar2.szX, aVar2.szW + 0);
                    lockCanvas.drawBitmap(aVar2.sAd ? aVar2.szT : aVar2.szS, null, aVar2.szV, aVar2.aFY);
                    aVar2.szR.unlockCanvasAndPost(lockCanvas);
                }
            }
            aVar2.szY.stopTimer();
        }
        AppMethodBeat.o(25970);
    }

    private void setShowRed(boolean z) {
        this.szK.sAd = z;
    }

    public void setMax(int i) {
        this.szK.max = i;
    }

    public void setValue(int i) {
        a aVar = this.szK;
        if (i < 0) {
            i = 0;
        } else if (i > aVar.max) {
            i = aVar.max;
        }
        aVar.value = i;
        aVar.sAb = aVar.szQ - ((aVar.szQ - aVar.szP) * ((((float) aVar.value) * 1.0f) / ((float) aVar.max)));
    }

    public void setMinPos(int i) {
        this.szK.szP = (float) i;
    }

    public void setMaxPos(int i) {
        this.szK.szQ = (float) i;
    }
}
