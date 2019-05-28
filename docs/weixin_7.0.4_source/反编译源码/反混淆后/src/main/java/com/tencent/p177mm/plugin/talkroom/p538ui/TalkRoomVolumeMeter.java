package com.tencent.p177mm.plugin.talkroom.p538ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomVolumeMeter */
public class TalkRoomVolumeMeter extends FrameLayout {
    private C35290a szK;
    private ImageView szL;
    private ImageView szM;
    private ImageView szN;
    private FrameLayout szO;

    /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomVolumeMeter$a */
    class C35290a extends SurfaceView implements Callback {
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
        C7564ap szY;
        private boolean szZ = false;
        int value = 0;

        /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomVolumeMeter$a$1 */
        class C352911 implements C5015a {
            C352911() {
            }

            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(25959);
                C35290a.m57952a(C35290a.this);
                boolean b = C35290a.this.szZ;
                AppMethodBeat.m2505o(25959);
                return b;
            }
        }

        public C35290a(Context context) {
            super(context);
            AppMethodBeat.m2504i(25960);
            this.szR.addCallback(this);
            this.aFY = new Paint();
            this.aFY.setAntiAlias(true);
            this.sAc = new PaintFlagsDrawFilter(0, 3);
            this.szY = new C7564ap(new C352911(), true);
            AppMethodBeat.m2505o(25960);
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            AppMethodBeat.m2504i(25961);
            C4990ab.m7418v("MicroMsg.TalkRoomVoiceMeter", "surfaceCreated");
            this.szS = BitmapFactory.decodeResource(getResources(), C25738R.drawable.apw);
            this.szU = BitmapFactory.decodeResource(getResources(), C25738R.drawable.apv);
            this.szT = BitmapFactory.decodeResource(getResources(), C25738R.drawable.apx);
            AppMethodBeat.m2505o(25961);
        }

        private int cEM() {
            AppMethodBeat.m2504i(25962);
            if (this.szS == null) {
                AppMethodBeat.m2505o(25962);
                return FacebookRequestErrorClassification.EC_INVALID_TOKEN;
            }
            int height = this.szS.getHeight();
            AppMethodBeat.m2505o(25962);
            return height;
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            AppMethodBeat.m2504i(25963);
            C4990ab.m7418v("MicroMsg.TalkRoomVoiceMeter", "surfaceChanged, width = " + i2 + " height = " + i3);
            this.szQ = 0.0f;
            this.szP = (float) (i3 - cEM());
            this.sAa = this.szQ;
            this.sAb = this.szQ;
            this.szX = i2;
            this.szW = cEM();
            this.szV = new Rect(0, (int) this.sAa, this.szX, ((int) this.sAa) + this.szW);
            this.szZ = true;
            AppMethodBeat.m2505o(25963);
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            AppMethodBeat.m2504i(25964);
            C4990ab.m7418v("MicroMsg.TalkRoomVoiceMeter", "surfaceDestroyed");
            this.szZ = false;
            this.szY.stopTimer();
            if (this.szS != null) {
                C4990ab.m7417i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", this.szS.toString());
                this.szS.recycle();
                this.szS = null;
            }
            if (this.szU != null) {
                C4990ab.m7417i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", this.szU.toString());
                this.szU.recycle();
                this.szU = null;
            }
            if (this.szT != null) {
                C4990ab.m7417i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", this.szT.toString());
                this.szT.recycle();
                this.szT = null;
            }
            AppMethodBeat.m2505o(25964);
        }

        /* renamed from: a */
        static /* synthetic */ void m57952a(C35290a c35290a) {
            AppMethodBeat.m2504i(25965);
            if (c35290a.sAb < c35290a.szP || c35290a.sAb > c35290a.szQ) {
                AppMethodBeat.m2505o(25965);
            } else if (c35290a.szT == null || c35290a.szS == null) {
                AppMethodBeat.m2505o(25965);
            } else {
                Canvas lockCanvas = c35290a.szR.lockCanvas();
                if (!(lockCanvas == null || c35290a.szV == null)) {
                    lockCanvas.setDrawFilter(c35290a.sAc);
                    float f = c35290a.sAb;
                    if (c35290a.positions == null) {
                        c35290a.positions = new float[]{c35290a.szQ, c35290a.szQ, c35290a.szQ, c35290a.szQ, c35290a.szQ};
                    }
                    int i = 0;
                    while (i < c35290a.positions.length - 1) {
                        float[] fArr = c35290a.positions;
                        fArr[i] = fArr[i + 1];
                        i++;
                    }
                    c35290a.positions[i] = f;
                    c35290a.sAa = ((((c35290a.positions[0] + (c35290a.positions[1] * 4.0f)) + (c35290a.positions[2] * 6.0f)) + (c35290a.positions[3] * 4.0f)) + (c35290a.positions[4] * 1.0f)) / 16.0f;
                    c35290a.szV.set(0, (int) c35290a.sAa, c35290a.szX, ((int) c35290a.sAa) + c35290a.szW);
                    lockCanvas.drawBitmap(c35290a.sAd ? c35290a.szT : c35290a.szS, null, c35290a.szV, c35290a.aFY);
                    c35290a.szR.unlockCanvasAndPost(lockCanvas);
                }
                AppMethodBeat.m2505o(25965);
            }
        }
    }

    public TalkRoomVolumeMeter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(25966);
        initView();
        AppMethodBeat.m2505o(25966);
    }

    public TalkRoomVolumeMeter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(25967);
        initView();
        AppMethodBeat.m2505o(25967);
    }

    private void initView() {
        AppMethodBeat.m2504i(25968);
        this.szK = new C35290a(getContext());
        this.szL = new ImageView(getContext());
        this.szL.setScaleType(ScaleType.FIT_XY);
        this.szL.setImageResource(C25738R.drawable.apz);
        this.szL.setVisibility(0);
        this.szM = new ImageView(getContext());
        this.szM.setScaleType(ScaleType.FIT_CENTER);
        this.szM.setImageResource(C25738R.drawable.apy);
        this.szM.setVisibility(8);
        this.szN = new ImageView(getContext());
        this.szN.setScaleType(ScaleType.FIT_CENTER);
        this.szN.setImageResource(C25738R.drawable.apv);
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
        AppMethodBeat.m2505o(25968);
    }

    private void setShowErr(boolean z) {
        AppMethodBeat.m2504i(25969);
        this.szN.setVisibility(z ? 0 : 8);
        AppMethodBeat.m2505o(25969);
    }

    public void setShowFlame(boolean z) {
        AppMethodBeat.m2504i(25970);
        this.szO.setVisibility(z ? 0 : 8);
        if (z) {
            C35290a c35290a = this.szK;
            if (!c35290a.started) {
                c35290a.started = true;
                c35290a.szY.mo16770ae(100, 100);
            }
            AppMethodBeat.m2505o(25970);
            return;
        }
        C35290a c35290a2 = this.szK;
        if (c35290a2.started) {
            c35290a2.started = false;
            if (c35290a2.sAb >= c35290a2.szP && c35290a2.sAb <= c35290a2.szQ && c35290a2.szT != null && c35290a2.szS != null) {
                Canvas lockCanvas = c35290a2.szR.lockCanvas();
                if (!(lockCanvas == null || c35290a2.szV == null)) {
                    lockCanvas.setDrawFilter(c35290a2.sAc);
                    c35290a2.szV.set(0, 0, c35290a2.szX, c35290a2.szW + 0);
                    lockCanvas.drawBitmap(c35290a2.sAd ? c35290a2.szT : c35290a2.szS, null, c35290a2.szV, c35290a2.aFY);
                    c35290a2.szR.unlockCanvasAndPost(lockCanvas);
                }
            }
            c35290a2.szY.stopTimer();
        }
        AppMethodBeat.m2505o(25970);
    }

    private void setShowRed(boolean z) {
        this.szK.sAd = z;
    }

    public void setMax(int i) {
        this.szK.max = i;
    }

    public void setValue(int i) {
        C35290a c35290a = this.szK;
        if (i < 0) {
            i = 0;
        } else if (i > c35290a.max) {
            i = c35290a.max;
        }
        c35290a.value = i;
        c35290a.sAb = c35290a.szQ - ((c35290a.szQ - c35290a.szP) * ((((float) c35290a.value) * 1.0f) / ((float) c35290a.max)));
    }

    public void setMinPos(int i) {
        this.szK.szP = (float) i;
    }

    public void setMaxPos(int i) {
        this.szK.szQ = (float) i;
    }
}
