package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Point;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

public class ExdeviceStepChartView extends View {
    Paint aFY;
    private int iZn;
    private int iZo;
    private final int lDV;
    private final int lDW;
    private final int lDX;
    private final float lDY;
    private final float lDZ;
    private final int lEA;
    private final float lEB;
    private final int lEC;
    private final float lED;
    private final int lEE;
    private final float lEF;
    private final int lEG;
    private final float lEH;
    private final float lEI;
    private final float lEJ;
    private final float lEK;
    private final int lEL;
    private final int lEM;
    private final int lEN;
    private final int lEO;
    private final float lEP;
    private final int lEQ;
    private final float lER;
    private final int lES;
    private final float lET;
    private final int lEU;
    private final float lEV;
    private final int lEW;
    private final float lEX;
    private final int lEY;
    private final int lEZ;
    private final float lEa;
    private final float lEb;
    private final float lEc;
    private final int lEd;
    private final int lEe;
    private final int lEf;
    private final int lEg;
    private int lEh;
    private final float lEi;
    private final float lEj;
    private final int lEk;
    private final float lEl;
    private final int lEm;
    private final float lEn;
    private final int lEo;
    private final float lEp;
    private final int lEq;
    private final float lEr;
    private final int lEs;
    private final float lEt;
    private final int lEu;
    private final float lEv;
    private final int lEw;
    private final float lEx;
    private final int lEy;
    private final float lEz;
    private final int lFa;
    private final int lFb;
    private final int lFc;
    private final int lFd;
    private final int lFe;
    private final int lFf;
    private final int lFg;
    private int lFh;
    private final Typeface lFi;
    private final Typeface lFj;
    private int lFk;
    private int lFl;
    private int[] lFm;
    private final int lFn;
    private float[] lFo;
    private float[] lFp;
    private boolean[] lFq;
    Path lFr;
    Path lFs;
    List<String> lFt;
    private boolean lFu;
    PathEffect lFv;
    private int lFw;
    private boolean lFx;
    List<Point> points;
    private int startY;

    public ExdeviceStepChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(20223);
        this.lDV = -1;
        this.lDW = -1;
        this.lDX = getResources().getColor(R.color.ng);
        this.lDY = 12.0f;
        this.lDZ = 28.0f;
        this.lEa = 33.0f;
        this.lEb = 12.0f;
        this.lEc = 12.0f;
        this.lEd = getResources().getColor(R.color.nh);
        this.lEe = -1;
        this.lEf = getResources().getColor(R.color.nh);
        this.lEg = -1;
        this.lEh = BaseClientBuilder.API_PRIORITY_OTHER;
        this.iZn = 0;
        this.iZo = 0;
        this.lEi = 10.0f;
        this.lEj = 2.5f;
        this.lEk = (int) m(1, 2.5f);
        this.lEl = 4.0f;
        this.lEm = (int) m(1, 4.0f);
        this.lEn = 1.8f;
        this.lEo = (int) m(1, 1.8f);
        this.lEp = 1.0f;
        this.lEq = (int) m(1, 1.0f);
        this.lEr = 8.0f;
        this.lEs = (int) m(1, 8.0f);
        this.lEt = 22.0f;
        this.lEu = (int) m(1, 22.0f);
        this.lEv = 67.0f;
        this.lEw = (int) m(1, 67.0f);
        this.lEx = 40.0f;
        this.lEy = (int) m(1, 40.0f);
        this.lEz = 22.0f;
        this.lEA = (int) m(1, 22.0f);
        this.lEB = 55.0f;
        this.lEC = (int) m(1, 55.0f);
        this.lED = 35.0f;
        this.lEE = (int) m(1, 35.0f);
        this.lEF = 45.0f;
        this.lEG = (int) m(1, 45.0f);
        this.lEH = 8.0f;
        this.lEI = (float) ((int) m(1, 8.0f));
        this.lEJ = 8.0f;
        this.lEK = (float) ((int) m(1, 8.0f));
        this.lEL = 2;
        this.lEM = (int) m(1, 2.0f);
        this.lEN = 15;
        this.lEO = (int) m(1, 15.0f);
        this.lEP = 33.0f;
        this.lEQ = (int) m(1, 33.0f);
        this.lER = 8.0f;
        this.lES = (int) m(1, 8.0f);
        this.lET = 35.0f;
        this.lEU = (int) m(1, 35.0f);
        this.lEV = 10.0f;
        this.lEW = (int) m(1, 10.0f);
        this.lEX = 58.0f;
        this.lEY = (int) m(1, 58.0f);
        this.lEZ = (int) m(1, 1.0f);
        this.lFa = 102;
        this.lFb = 102;
        this.lFc = XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION;
        this.lFd = 102;
        this.lFe = 102;
        this.lFf = 102;
        this.lFg = 204;
        this.lFh = 0;
        this.lFi = Typeface.create(Typeface.DEFAULT_BOLD, 0);
        this.lFj = Typeface.create(Typeface.DEFAULT_BOLD, 1);
        this.lFk = 0;
        this.lFl = 0;
        this.lFm = new int[]{0, 0, 0, 0, 0, 0, 0};
        this.lFn = 7;
        this.lFo = new float[7];
        this.lFp = new float[7];
        this.lFq = new boolean[7];
        this.lFu = false;
        this.lFv = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
        bqd();
        AppMethodBeat.o(20223);
    }

    public ExdeviceStepChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(20224);
        this.lDV = -1;
        this.lDW = -1;
        this.lDX = getResources().getColor(R.color.ng);
        this.lDY = 12.0f;
        this.lDZ = 28.0f;
        this.lEa = 33.0f;
        this.lEb = 12.0f;
        this.lEc = 12.0f;
        this.lEd = getResources().getColor(R.color.nh);
        this.lEe = -1;
        this.lEf = getResources().getColor(R.color.nh);
        this.lEg = -1;
        this.lEh = BaseClientBuilder.API_PRIORITY_OTHER;
        this.iZn = 0;
        this.iZo = 0;
        this.lEi = 10.0f;
        this.lEj = 2.5f;
        this.lEk = (int) m(1, 2.5f);
        this.lEl = 4.0f;
        this.lEm = (int) m(1, 4.0f);
        this.lEn = 1.8f;
        this.lEo = (int) m(1, 1.8f);
        this.lEp = 1.0f;
        this.lEq = (int) m(1, 1.0f);
        this.lEr = 8.0f;
        this.lEs = (int) m(1, 8.0f);
        this.lEt = 22.0f;
        this.lEu = (int) m(1, 22.0f);
        this.lEv = 67.0f;
        this.lEw = (int) m(1, 67.0f);
        this.lEx = 40.0f;
        this.lEy = (int) m(1, 40.0f);
        this.lEz = 22.0f;
        this.lEA = (int) m(1, 22.0f);
        this.lEB = 55.0f;
        this.lEC = (int) m(1, 55.0f);
        this.lED = 35.0f;
        this.lEE = (int) m(1, 35.0f);
        this.lEF = 45.0f;
        this.lEG = (int) m(1, 45.0f);
        this.lEH = 8.0f;
        this.lEI = (float) ((int) m(1, 8.0f));
        this.lEJ = 8.0f;
        this.lEK = (float) ((int) m(1, 8.0f));
        this.lEL = 2;
        this.lEM = (int) m(1, 2.0f);
        this.lEN = 15;
        this.lEO = (int) m(1, 15.0f);
        this.lEP = 33.0f;
        this.lEQ = (int) m(1, 33.0f);
        this.lER = 8.0f;
        this.lES = (int) m(1, 8.0f);
        this.lET = 35.0f;
        this.lEU = (int) m(1, 35.0f);
        this.lEV = 10.0f;
        this.lEW = (int) m(1, 10.0f);
        this.lEX = 58.0f;
        this.lEY = (int) m(1, 58.0f);
        this.lEZ = (int) m(1, 1.0f);
        this.lFa = 102;
        this.lFb = 102;
        this.lFc = XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION;
        this.lFd = 102;
        this.lFe = 102;
        this.lFf = 102;
        this.lFg = 204;
        this.lFh = 0;
        this.lFi = Typeface.create(Typeface.DEFAULT_BOLD, 0);
        this.lFj = Typeface.create(Typeface.DEFAULT_BOLD, 1);
        this.lFk = 0;
        this.lFl = 0;
        this.lFm = new int[]{0, 0, 0, 0, 0, 0, 0};
        this.lFn = 7;
        this.lFo = new float[7];
        this.lFp = new float[7];
        this.lFq = new boolean[7];
        this.lFu = false;
        this.lFv = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
        bqd();
        AppMethodBeat.o(20224);
    }

    private void c(Canvas canvas, boolean z) {
        int i = 0;
        AppMethodBeat.i(20225);
        if (z) {
            this.lFs.reset();
            this.lFs.moveTo((float) ((Point) this.points.get(0)).x, (float) ((Point) this.points.get(0)).y);
            for (int i2 = 0; i2 < this.points.size(); i2++) {
                this.lFs.lineTo((float) ((Point) this.points.get(i2)).x, (float) ((Point) this.points.get(i2)).y);
            }
            this.lFs.lineTo(this.lFo[this.lFo.length - 1], (float) ((this.iZo - this.lEE) - 1));
            this.lFs.lineTo((float) this.lEs, (float) ((this.iZo - this.lEE) - 1));
            this.lFs.lineTo((float) this.lEs, this.lFp[0]);
            canvas.drawPath(this.lFs, this.aFY);
            AppMethodBeat.o(20225);
            return;
        }
        this.lFs.reset();
        this.lFs.moveTo((float) ((Point) this.points.get(0)).x, (float) ((Point) this.points.get(0)).y);
        while (i < this.points.size()) {
            if (i <= 0) {
                bqf();
            } else if (((Point) this.points.get(i - 1)).y == this.iZo - this.lEy) {
                this.aFY.reset();
                this.aFY.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
                this.aFY.setAntiAlias(true);
                this.aFY.setStrokeWidth((float) this.lEo);
                this.aFY.setStyle(Style.STROKE);
                this.aFY.setColor(-1);
            } else {
                bqf();
            }
            this.lFs.lineTo((float) ((Point) this.points.get(i)).x, (float) ((Point) this.points.get(i)).y);
            canvas.drawPath(this.lFs, this.aFY);
            this.lFs.reset();
            this.lFs.moveTo((float) ((Point) this.points.get(i)).x, (float) ((Point) this.points.get(i)).y);
            i++;
        }
        AppMethodBeat.o(20225);
    }

    private float m(int i, float f) {
        Resources system;
        AppMethodBeat.i(20226);
        Context context = getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i, f, system.getDisplayMetrics());
        AppMethodBeat.o(20226);
        return applyDimension;
    }

    private void a(Canvas canvas, List<String> list) {
        AppMethodBeat.i(20227);
        if (list != null && list.size() == 7) {
            this.aFY.reset();
            this.aFY.setAntiAlias(true);
            this.aFY.setStrokeWidth(0.0f);
            this.aFY.setTextSize(m(2, 12.0f));
            this.aFY.setAlpha(XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                if (i2 == 0) {
                    this.aFY.setTextAlign(Align.LEFT);
                } else {
                    this.aFY.setTextAlign(Align.CENTER);
                }
                if (this.lFq[i2]) {
                    this.aFY.setColor(-1);
                } else {
                    this.aFY.setColor(this.lEd);
                }
                canvas.drawText((String) list.get(i2), (float) ((Point) this.points.get(i2)).x, (float) (this.iZo - this.lEO), this.aFY);
                i = i2 + 1;
            }
        }
        AppMethodBeat.o(20227);
    }

    private void bqd() {
        AppMethodBeat.i(20228);
        this.aFY = new Paint();
        this.lFr = new Path();
        this.lFs = new Path();
        this.points = new LinkedList();
        this.lFt = new LinkedList();
        bqe();
        AppMethodBeat.o(20228);
    }

    private void bqe() {
        for (int i = 0; i < 7; i++) {
            if (i == 6) {
                this.lFq[i] = true;
            } else {
                this.lFq[i] = false;
            }
        }
    }

    private void bqf() {
        AppMethodBeat.i(20229);
        this.aFY.reset();
        this.aFY.setAntiAlias(true);
        this.aFY.setStrokeWidth((float) this.lEo);
        this.aFY.setStyle(Style.STROKE);
        this.aFY.setColor(-1);
        AppMethodBeat.o(20229);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(20230);
        getData();
        super.onDraw(canvas);
        if (!this.lFu) {
            int i;
            this.aFY.reset();
            this.aFY.setAntiAlias(true);
            this.aFY.setColor(-1);
            this.aFY.setStrokeWidth(0.0f);
            this.aFY.setStyle(Style.FILL);
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.points.size()) {
                    break;
                }
                Point point = (Point) this.points.get(i);
                if (i == this.points.size() - 1) {
                    canvas.drawCircle((float) point.x, (float) point.y, (float) this.lEm, this.aFY);
                } else {
                    canvas.drawCircle((float) point.x, (float) point.y, (float) this.lEk, this.aFY);
                }
                i2 = i + 1;
            }
            if (this.lEh != BaseClientBuilder.API_PRIORITY_OTHER) {
                i = this.lEh;
                this.aFY.reset();
                this.aFY.setColor(this.lEd);
                this.aFY.setAntiAlias(true);
                this.aFY.setStrokeWidth(0.0f);
                this.aFY.setTextSize(m(2, 12.0f));
                this.aFY.setTextAlign(Align.CENTER);
                if (i >= 0 && i <= 6) {
                    if (i == 0) {
                        this.aFY.setTextAlign(Align.LEFT);
                    }
                    if (i == 6) {
                        this.aFY.setTextAlign(Align.RIGHT);
                    }
                    if (!this.lFx) {
                        this.lFw = ((Point) this.points.get(i)).y - this.lEY;
                        this.startY = this.lFw;
                        this.lFx = true;
                    }
                    if (this.lFx) {
                        float f = (float) (((double) this.startY) / 8.0d);
                        if (this.lFw > 0) {
                            this.aFY.setAlpha(((this.startY - this.lFw) * 255) / this.startY);
                        }
                        canvas.drawText(this.lFm[i], (float) ((Point) this.points.get(i)).x, (float) (this.lFw + this.lEY), this.aFY);
                        if (this.lFw > 0) {
                            if (((float) this.lFw) / ((float) this.startY) <= 1.0f / f) {
                                this.lFw--;
                            } else {
                                this.lFw = (int) (((float) this.lFw) - ((((float) this.lFw) / ((float) this.startY)) * f));
                            }
                            invalidate();
                        } else {
                            this.lFx = false;
                        }
                    }
                }
                i2 = this.lEh;
                if (i2 >= 0 && i2 <= 6) {
                    this.lFq[i2] = true;
                }
            }
        }
        this.aFY.reset();
        this.lFr.reset();
        this.aFY.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
        this.aFY.setColor(this.lDX);
        this.aFY.setStrokeWidth((float) this.lEq);
        this.aFY.setAlpha(102);
        this.aFY.setStyle(Style.STROKE);
        if (!(this.lFh == 0 || this.lFu)) {
            this.lFr.moveTo((float) this.lEs, (float) this.lFh);
            this.lFr.lineTo((float) (this.iZn - this.lEA), (float) this.lFh);
            canvas.drawPath(this.lFr, this.aFY);
        }
        this.aFY.reset();
        this.lFr.reset();
        this.aFY.setColor(this.lDX);
        this.aFY.setStrokeWidth((float) this.lEq);
        this.aFY.setStyle(Style.STROKE);
        this.aFY.setAlpha(102);
        this.lFr.reset();
        this.lFr.moveTo(this.lEI, (float) (this.iZo - this.lEE));
        this.lFr.lineTo(((float) this.iZn) - this.lEK, (float) (this.iZo - this.lEE));
        this.lFr.moveTo(this.lEI, (float) this.lEG);
        this.lFr.lineTo(((float) this.iZn) - this.lEK, (float) this.lEG);
        canvas.drawPath(this.lFr, this.aFY);
        if (!this.lFu) {
            this.aFY.reset();
            this.aFY.setColor(this.lEf);
            this.aFY.setAntiAlias(true);
            this.aFY.setAlpha(102);
            this.aFY.setStrokeWidth(0.0f);
            this.aFY.setTextSize(m(2, 12.0f));
            this.aFY.setTextAlign(Align.RIGHT);
            canvas.drawText(getResources().getString(R.string.bhh), (float) (this.iZn - this.lEM), (float) (((double) this.lFh) + (((double) this.aFY.getTextSize()) * 0.34d)), this.aFY);
        }
        this.aFY.reset();
        this.aFY.setColor(-1);
        this.aFY.setAntiAlias(true);
        this.aFY.setStrokeWidth(0.0f);
        this.aFY.setTypeface(this.lFi);
        this.aFY.setTextSize(m(2, 28.0f));
        canvas.drawText(getResources().getString(R.string.bhj), (float) this.lES, (float) this.lEQ, this.aFY);
        this.aFY.setTextAlign(Align.RIGHT);
        this.aFY.setTextSize(m(2, 33.0f));
        canvas.drawText(this.lFm[this.lFm.length - 1], (float) (this.iZn - this.lEW), (float) this.lEU, this.aFY);
        if (this.points.size() > 2) {
            this.aFY.reset();
            this.aFY.setAntiAlias(true);
            this.aFY.setStrokeWidth(0.0f);
            this.aFY.setAlpha(102);
            this.aFY.setStyle(Style.FILL_AND_STROKE);
            this.aFY.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, (float) (this.iZo - this.lEE), -1, 16777215, TileMode.REPEAT));
            this.aFY.setColor(-1);
            c(canvas, true);
            bqf();
            if (!this.lFu) {
                c(canvas, false);
            }
        }
        a(canvas, this.lFt);
        AppMethodBeat.o(20230);
    }

    private void getData() {
        int i;
        int i2 = 0;
        AppMethodBeat.i(20231);
        this.points.clear();
        View findViewById = findViewById(R.id.bk6);
        this.iZn = findViewById.getWidth();
        this.iZo = findViewById.getHeight();
        this.lFk = ((this.iZn - this.lEs) - this.lEu) / 6;
        this.lFl = ((this.iZo - this.lEw) - this.lEy) / 2;
        for (i = 0; i < this.lFo.length; i++) {
            this.lFo[i] = (float) (this.lEs + (this.lFk * i));
        }
        i = this.lFm.length;
        if (i > 7) {
            i = 7;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            if (this.lFm[i4] > 100000) {
                this.lFm[i4] = 100000;
            }
            if (this.lFm[i4] < 0) {
                this.lFm[i4] = 0;
            }
            if (this.lFm[i4] > i3) {
                i3 = this.lFm[i4];
            }
        }
        if (i3 <= 15000 && i3 >= 0) {
            i3 = 15000;
        } else if (i3 <= 15000 || i3 > 100000) {
            i3 = 0;
        } else if (((double) i3) / 5000.0d > ((double) (((float) i3) / 5000.0f))) {
            i3 = ((i3 / 5000) + 1) * 5000;
        }
        this.lFh = (((this.iZo - this.lEw) - this.lEy) * Downloads.MIN_WAIT_FOR_NETWORK) / i3;
        this.lFh = (this.iZo - this.lEy) - this.lFh;
        while (i2 < i) {
            this.lFp[i2] = ((float) (this.iZo - this.lEy)) - ((((float) this.lFm[i2]) / ((float) i3)) * ((float) ((this.iZo - this.lEw) - this.lEy)));
            this.points.add(new Point((int) this.lFo[i2], (int) this.lFp[i2]));
            i2++;
        }
        AppMethodBeat.o(20231);
    }

    private int aB(float f) {
        int i;
        AppMethodBeat.i(20232);
        this.lEh = BaseClientBuilder.API_PRIORITY_OTHER;
        if (this.points.size() > 0) {
            i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.points.size()) {
                    break;
                }
                if (i2 != 0) {
                    if (i2 > 0 && i2 < this.points.size() - 1) {
                        if (f < ((float) (((Point) this.points.get(i2)).x + (this.lFk / 2))) && f > ((float) (((Point) this.points.get(i2)).x - (this.lFk / 2)))) {
                            this.lEh = i2;
                            invalidate();
                            break;
                        }
                    } else if (i2 == this.points.size() - 1) {
                        if (f < ((float) this.iZn) && f > ((float) (((Point) this.points.get(i2)).x - (this.lFk / 2)))) {
                            this.lEh = i2;
                            invalidate();
                            break;
                        }
                    } else {
                        this.lEh = BaseClientBuilder.API_PRIORITY_OTHER;
                        break;
                    }
                } else if (f < ((float) (((Point) this.points.get(i2)).x + (this.lFk / 2))) && f > 0.0f) {
                    this.lEh = i2;
                    invalidate();
                    break;
                }
                i = i2 + 1;
            }
        }
        i = this.lEh;
        AppMethodBeat.o(20232);
        return i;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(20233);
        float x = motionEvent.getX();
        motionEvent.getY();
        ab.i("MicroMsg.exdevice.ExdeviceStepChartView", "mOnTouchLinePsition:" + this.lEh);
        switch (motionEvent.getAction()) {
            case 0:
                ab.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_DOWN");
                AppMethodBeat.o(20233);
                return true;
            case 1:
                ab.d("MicroMsg.exdevice.ExdeviceStepChartView", "ACTION_UP");
                this.lEh = aB(x);
                bqe();
                this.lFx = false;
                invalidate();
                AppMethodBeat.o(20233);
                return false;
            default:
                ab.d("MicroMsg.exdevice.ExdeviceStepChartView", "default");
                AppMethodBeat.o(20233);
                return false;
        }
    }
}
