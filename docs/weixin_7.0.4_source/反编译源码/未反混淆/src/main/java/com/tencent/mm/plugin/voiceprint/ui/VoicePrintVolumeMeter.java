package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.view.d;

public class VoicePrintVolumeMeter extends View {
    static int nOt = 20;
    private static float sMG = 1.5f;
    private static float sMH = 2.0f;
    private static float sMI = 0.1f;
    private static float sMJ = 0.05f;
    private static int sMx = Color.rgb(240, 250, d.MIC_PTU_AUTOLEVEL);
    private static int sMy = Color.rgb(210, 240, 200);
    private static int sMz = 100;
    private Context mContext;
    boolean mIsPlaying = false;
    private Paint mPaint;
    private float mVolume = -1.0f;
    private View nOh;
    private float sMA = 0.0f;
    private float sMB = 0.0f;
    private float sMC = 0.0f;
    private float sMD = 0.0f;
    private float sME = 0.0f;
    private float sMF = 0.0f;
    private boolean sMK = true;
    private int sMt = -1;
    private int sMu = -1;
    al sMv = null;
    ap sMw = null;

    static {
        AppMethodBeat.i(26218);
        AppMethodBeat.o(26218);
    }

    public VoicePrintVolumeMeter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(26210);
        init(context);
        AppMethodBeat.o(26210);
    }

    public VoicePrintVolumeMeter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(26211);
        init(context);
        AppMethodBeat.o(26211);
    }

    private void init(Context context) {
        AppMethodBeat.i(26212);
        this.mContext = context;
        this.mPaint = new Paint();
        this.sMv = new al("VoicePrintVolumeMeter");
        this.sMw = new ap(this.sMv.oAl.getLooper(), new a() {
            public final boolean BI() {
                AppMethodBeat.i(26209);
                VoicePrintVolumeMeter.a(VoicePrintVolumeMeter.this);
                boolean b = VoicePrintVolumeMeter.this.mIsPlaying;
                AppMethodBeat.o(26209);
                return b;
            }
        }, true);
        AppMethodBeat.o(26212);
    }

    public void setArchView(View view) {
        this.nOh = view;
    }

    /* Access modifiers changed, original: final */
    public final void cIc() {
        AppMethodBeat.i(26213);
        if (this.nOh == null || this.nOh.getVisibility() == 8) {
            AppMethodBeat.o(26213);
            return;
        }
        int[] iArr = new int[2];
        this.nOh.getLocationOnScreen(iArr);
        if (iArr[0] == 0 || iArr[1] == 0) {
            ab.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView location");
            AppMethodBeat.o(26213);
            return;
        }
        int width = this.nOh.getWidth();
        int height = this.nOh.getHeight();
        if (height == 0 || width == 0) {
            ab.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView size");
            AppMethodBeat.o(26213);
            return;
        }
        this.sMt = iArr[0] + (width / 2);
        this.sMu = (iArr[1] + (height / 2)) - com.tencent.mm.bz.a.fromDPToPix(this.mContext, 25);
        ab.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, mCenterX:%d, mCenterY:%d", Integer.valueOf(this.sMt), Integer.valueOf(this.sMu));
        this.sMA = ((float) width) / 2.0f;
        this.sMB = this.sMA * sMG;
        this.sMC = this.sMA * sMH;
        this.sMD = this.sMB * sMH;
        this.sMF = this.sMB;
        this.sME = this.sMA;
        AppMethodBeat.o(26213);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(26214);
        super.onDraw(canvas);
        if (this.mIsPlaying) {
            if (this.sMt == -1 || this.sMu == -1) {
                cIc();
            }
            this.mPaint.setAlpha(sMz);
            if (this.sMF > this.sMD) {
                this.sMF = this.sMD;
            }
            if (this.sMF < this.sMB) {
                this.sMF = this.sMB;
            }
            this.mPaint.setColor(sMx);
            canvas.drawCircle((float) this.sMt, (float) this.sMu, this.sMF, this.mPaint);
            if (this.sME > this.sMC) {
                this.sME = this.sMC;
            }
            if (this.sME < this.sMA) {
                this.sME = this.sMA;
            }
            this.mPaint.setColor(sMy);
            canvas.drawCircle((float) this.sMt, (float) this.sMu, this.sME, this.mPaint);
            AppMethodBeat.o(26214);
            return;
        }
        AppMethodBeat.o(26214);
    }

    public final void stop() {
        AppMethodBeat.i(26215);
        reset();
        this.mIsPlaying = false;
        this.sMw.stopTimer();
        postInvalidate();
        AppMethodBeat.o(26215);
    }

    public void setVolume(float f) {
        if (f > this.mVolume) {
            this.sMK = true;
        } else {
            this.sMK = false;
        }
        this.mVolume = f;
    }

    public final void reset() {
        AppMethodBeat.i(26216);
        this.sMK = false;
        this.mVolume = -1.0f;
        this.mIsPlaying = false;
        this.sME = 0.0f;
        this.sMF = 0.0f;
        postInvalidate();
        AppMethodBeat.o(26216);
    }

    static /* synthetic */ void a(VoicePrintVolumeMeter voicePrintVolumeMeter) {
        AppMethodBeat.i(26217);
        if (voicePrintVolumeMeter.mIsPlaying) {
            if (voicePrintVolumeMeter.sMK) {
                voicePrintVolumeMeter.sME *= sMI + 1.0f;
                voicePrintVolumeMeter.sMF = voicePrintVolumeMeter.sME * sMG;
            } else {
                voicePrintVolumeMeter.sME *= 1.0f - sMJ;
                voicePrintVolumeMeter.sMF = voicePrintVolumeMeter.sME * sMG;
            }
            voicePrintVolumeMeter.postInvalidate();
        }
        AppMethodBeat.o(26217);
    }
}
