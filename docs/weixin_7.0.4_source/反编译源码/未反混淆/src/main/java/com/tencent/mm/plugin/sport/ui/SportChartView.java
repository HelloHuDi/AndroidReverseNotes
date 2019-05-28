package com.tencent.mm.plugin.sport.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sport.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

public class SportChartView extends View {
    Paint aFY;
    private int iZn;
    private int iZo;
    private GestureDetector lCs;
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
    Path lFr;
    Path lFs;
    private int lFw;
    private boolean lFx;
    private int nWb;
    private SimpleDateFormat rPW;
    private SimpleDateFormat rPX;
    private boolean rPY;
    private int rPZ;
    private int rQa;
    private a rQb;
    private int rQc;
    private List<e> rQd;
    private b[] rQe;
    private int rQf;
    private boolean rQg;
    private OnGestureListener rQh;
    private int startY;

    class b {
        int hzv;
        String qkq;
        boolean rQn;
        long timestamp;
        float x;
        float y;

        private b() {
            this.qkq = "";
        }

        /* synthetic */ b(SportChartView sportChartView, byte b) {
            this();
        }
    }

    public enum a {
        WEEK,
        MONTH;

        static {
            AppMethodBeat.o(65425);
        }
    }

    static /* synthetic */ void h(SportChartView sportChartView) {
        AppMethodBeat.i(65442);
        sportChartView.lq(false);
        AppMethodBeat.o(65442);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(65426);
        this.rQb = aVar;
        if (aVar == a.WEEK) {
            this.rQc = 7;
        } else {
            this.rQc = 30;
        }
        this.rQe = new b[this.rQc];
        cwI();
        AppMethodBeat.o(65426);
    }

    private void cwI() {
        AppMethodBeat.i(65427);
        for (int i = 0; i < this.rQe.length; i++) {
            this.rQe[i] = new b(this, (byte) 0);
        }
        AppMethodBeat.o(65427);
    }

    public SportChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(65428);
        this.rPW = new SimpleDateFormat(getResources().getString(R.string.ers));
        this.rPX = new SimpleDateFormat("d");
        this.lDV = -1;
        this.lDW = -1;
        this.lDX = getResources().getColor(R.color.a1b);
        this.lDY = 12.0f;
        this.lDZ = 24.0f;
        this.lEa = 28.0f;
        this.lEb = 12.0f;
        this.lEc = 12.0f;
        this.lEd = getResources().getColor(R.color.a1c);
        this.lEe = -1;
        this.lEf = getResources().getColor(R.color.a1c);
        this.lEg = -1;
        this.nWb = BaseClientBuilder.API_PRIORITY_OTHER;
        this.iZn = 0;
        this.iZo = 0;
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
        this.rPZ = -1;
        this.rQa = -1;
        this.rQb = a.WEEK;
        this.rQc = 7;
        this.rQe = new b[this.rQc];
        this.rQh = new SimpleOnGestureListener() {
            private long rQi;

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                AppMethodBeat.i(65421);
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                SportChartView.this.nWb = SportChartView.a(SportChartView.this, x);
                SportChartView.a(SportChartView.this);
                SportChartView.this.lFx = false;
                ab.i("MicroMsg.Sport.SportChartView", "onSingleTapUp %s %s %d", Float.valueOf(x), Float.valueOf(y), Integer.valueOf(SportChartView.this.nWb));
                SportChartView.this.invalidate();
                AppMethodBeat.o(65421);
                return true;
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                AppMethodBeat.i(65422);
                ab.i("MicroMsg.Sport.SportChartView", "onScroll %.2f", Float.valueOf(f));
                if (System.currentTimeMillis() - this.rQi < 500 || !SportChartView.this.rQg) {
                    AppMethodBeat.o(65422);
                    return false;
                }
                this.rQi = System.currentTimeMillis();
                if (f > 0.0f) {
                    SportChartView.this.rPZ = SportChartView.this.rPZ + 1;
                    if (SportChartView.this.rPZ > SportChartView.this.rQa) {
                        SportChartView.this.rPZ = SportChartView.this.rQa;
                    }
                    SportChartView.h(SportChartView.this);
                    SportChartView.this.invalidate();
                    AppMethodBeat.o(65422);
                    return true;
                } else if (f < 0.0f) {
                    SportChartView.this.rPZ = SportChartView.this.rPZ - 1;
                    if (SportChartView.this.rPZ <= 0) {
                        SportChartView.this.rPZ = 1;
                    }
                    SportChartView.h(SportChartView.this);
                    SportChartView.this.invalidate();
                    AppMethodBeat.o(65422);
                    return true;
                } else {
                    AppMethodBeat.o(65422);
                    return false;
                }
            }
        };
        bqd();
        AppMethodBeat.o(65428);
    }

    public SportChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(65429);
        this.rPW = new SimpleDateFormat(getResources().getString(R.string.ers));
        this.rPX = new SimpleDateFormat("d");
        this.lDV = -1;
        this.lDW = -1;
        this.lDX = getResources().getColor(R.color.a1b);
        this.lDY = 12.0f;
        this.lDZ = 24.0f;
        this.lEa = 28.0f;
        this.lEb = 12.0f;
        this.lEc = 12.0f;
        this.lEd = getResources().getColor(R.color.a1c);
        this.lEe = -1;
        this.lEf = getResources().getColor(R.color.a1c);
        this.lEg = -1;
        this.nWb = BaseClientBuilder.API_PRIORITY_OTHER;
        this.iZn = 0;
        this.iZo = 0;
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
        this.rPZ = -1;
        this.rQa = -1;
        this.rQb = a.WEEK;
        this.rQc = 7;
        this.rQe = new b[this.rQc];
        this.rQh = /* anonymous class already generated */;
        bqd();
        AppMethodBeat.o(65429);
    }

    public void setTodayStep(int i) {
        this.rQf = i;
    }

    private void c(Canvas canvas, boolean z) {
        int i = 0;
        AppMethodBeat.i(65430);
        if (z) {
            this.lFs.reset();
            this.lFs.moveTo(this.rQe[0].x, this.rQe[0].y);
            for (int i2 = 0; i2 < this.rQe.length; i2++) {
                this.lFs.lineTo(this.rQe[i2].x, this.rQe[i2].y);
            }
            this.lFs.lineTo(this.rQe[this.rQe.length - 1].x, (float) ((this.iZo - this.lEE) - 1));
            this.lFs.lineTo((float) this.lEs, (float) ((this.iZo - this.lEE) - 1));
            this.lFs.lineTo((float) this.lEs, this.rQe[0].y);
            canvas.drawPath(this.lFs, this.aFY);
            AppMethodBeat.o(65430);
            return;
        }
        this.lFs.reset();
        this.lFs.moveTo(this.rQe[0].x, this.rQe[0].y);
        while (i < this.rQe.length) {
            if (i <= 0) {
                bqf();
            } else if (this.rQe[i - 1].y == ((float) (this.iZo - this.lEy))) {
                this.aFY.reset();
                this.aFY.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
                this.aFY.setAntiAlias(true);
                this.aFY.setStrokeWidth((float) this.lEo);
                this.aFY.setStyle(Style.STROKE);
                this.aFY.setColor(-1);
            } else {
                bqf();
            }
            this.lFs.lineTo(this.rQe[i].x, this.rQe[i].y);
            canvas.drawPath(this.lFs, this.aFY);
            this.lFs.reset();
            this.lFs.moveTo(this.rQe[i].x, this.rQe[i].y);
            i++;
        }
        AppMethodBeat.o(65430);
    }

    private void k(Canvas canvas) {
        AppMethodBeat.i(65431);
        this.aFY.reset();
        this.aFY.setAntiAlias(true);
        this.aFY.setColor(-1);
        this.aFY.setStrokeWidth(0.0f);
        this.aFY.setStyle(Style.FILL);
        for (int i = 0; i < this.rQe.length; i++) {
            if (i == this.rQe.length - 1) {
                canvas.drawCircle(this.rQe[i].x, this.rQe[i].y, (float) this.lEm, this.aFY);
            } else {
                canvas.drawCircle(this.rQe[i].x, this.rQe[i].y, (float) this.lEk, this.aFY);
            }
        }
        AppMethodBeat.o(65431);
    }

    public final void dD(List<e> list) {
        AppMethodBeat.i(65432);
        this.rQd = list;
        lq(true);
        invalidate();
        AppMethodBeat.o(65432);
    }

    private float m(int i, float f) {
        Resources system;
        AppMethodBeat.i(65433);
        Context context = getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i, f, system.getDisplayMetrics());
        AppMethodBeat.o(65433);
        return applyDimension;
    }

    private void l(Canvas canvas) {
        AppMethodBeat.i(65434);
        this.aFY.reset();
        this.aFY.setAntiAlias(true);
        this.aFY.setStrokeWidth(0.0f);
        this.aFY.setTextSize(m(2, 12.0f));
        this.aFY.setAlpha(XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION);
        for (int i = 0; i < this.rQe.length; i++) {
            if (i == 0) {
                this.aFY.setTextAlign(Align.LEFT);
            } else {
                this.aFY.setTextAlign(Align.CENTER);
            }
            if (this.rQe[i].rQn) {
                this.aFY.setColor(-1);
            } else {
                this.aFY.setColor(this.lEd);
            }
            canvas.drawText(this.rQe[i].qkq, this.rQe[i].x, (float) (this.iZo - this.lEO), this.aFY);
        }
        AppMethodBeat.o(65434);
    }

    private void bqd() {
        AppMethodBeat.i(65435);
        this.aFY = new Paint();
        this.lFr = new Path();
        this.lFs = new Path();
        this.rQe = new b[this.rQc];
        cwI();
        cwJ();
        this.lCs = new GestureDetector(getContext(), this.rQh);
        AppMethodBeat.o(65435);
    }

    private void cwJ() {
        for (int i = 0; i < this.rQc; i++) {
            if (i == this.rQc - 1) {
                this.rQe[i].rQn = true;
            } else {
                this.rQe[i].rQn = false;
            }
        }
    }

    private void bqf() {
        AppMethodBeat.i(65436);
        this.aFY.reset();
        this.aFY.setAntiAlias(true);
        this.aFY.setStrokeWidth((float) this.lEo);
        this.aFY.setStyle(Style.STROKE);
        this.aFY.setColor(-1);
        AppMethodBeat.o(65436);
    }

    private void lq(boolean z) {
        int i = 0;
        AppMethodBeat.i(65438);
        this.nWb = BaseClientBuilder.API_PRIORITY_OTHER;
        Calendar instance = Calendar.getInstance();
        this.rQe = new b[this.rQc];
        cwI();
        int i2;
        if (this.rQd == null || this.rQd.size() <= 0) {
            this.rPY = true;
            instance.add(5, -this.rQc);
            for (i2 = 0; i2 < this.rQe.length; i2++) {
                instance.add(5, 1);
                this.rQe[i2].timestamp = instance.getTimeInMillis();
                this.rQe[i2].hzv = 0;
            }
            AppMethodBeat.o(65438);
            return;
        }
        this.rPY = false;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.rQd);
        Collections.sort(arrayList);
        int size = arrayList.size();
        if (z || this.rQa == -1) {
            i2 = size / this.rQc;
            if (size % this.rQc != 0) {
                this.rQa = i2 + 1;
            } else {
                this.rQa = i2;
            }
            if (this.rQa > 4) {
                this.rQa = 4;
            }
            this.rPZ = this.rQa;
        }
        i2 = size - (this.rQc * ((this.rQa - this.rPZ) + 1));
        if (i2 < 0) {
            i2 = 0;
        }
        ab.i("MicroMsg.Sport.SportChartView", "updateViewItems beginIndex:%d endIndex:%d", Integer.valueOf(i2), Integer.valueOf(size - (this.rQc * (this.rQa - this.rPZ))));
        List subList = arrayList.subList(i2, size);
        size = subList.size();
        if (size < this.rQc) {
            instance.setTimeInMillis(((e) subList.get(0)).field_timestamp);
            for (i2 = 0; i2 < this.rQc - size; i2++) {
                instance.add(5, -1);
                e eVar = new e();
                eVar.field_timestamp = instance.getTimeInMillis();
                eVar.field_step = 0;
                subList.add(0, eVar);
            }
        }
        while (i < this.rQc) {
            e eVar2 = (e) subList.get(i);
            this.rQe[i].hzv = eVar2.field_step;
            this.rQe[i].timestamp = eVar2.field_timestamp;
            i++;
        }
        AppMethodBeat.o(65438);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(65439);
        this.lCs.onTouchEvent(motionEvent);
        AppMethodBeat.o(65439);
        return true;
    }

    public void setHasSwitchBtn(boolean z) {
        this.rQg = z;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        int i;
        AppMethodBeat.i(65437);
        this.iZn = getWidth();
        this.iZo = getHeight();
        this.lFk = ((this.iZn - this.lEs) - this.lEu) / (this.rQc - 1);
        this.lFl = ((this.iZo - this.lEw) - this.lEy) / 2;
        for (i = 0; i < this.rQe.length; i++) {
            this.rQe[i].x = (float) (this.lEs + (this.lFk * i));
        }
        i = this.rQe.length;
        if (i > this.rQc) {
            i = this.rQc;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (this.rQe[i3].hzv > 100000) {
                this.rQe[i3].hzv = 100000;
            }
            if (this.rQe[i3].hzv < 0) {
                this.rQe[i3].hzv = 0;
            }
            if (this.rQe[i3].hzv > i2) {
                i2 = this.rQe[i3].hzv;
            }
        }
        if (i2 <= 15000 && i2 >= 0) {
            i2 = 15000;
        } else if (i2 <= 15000 || i2 > 100000) {
            i2 = 0;
        } else if (((double) i2) / 5000.0d > ((double) (((float) i2) / 5000.0f))) {
            i2 = ((i2 / 5000) + 1) * 5000;
        }
        this.lFh = (((this.iZo - this.lEw) - this.lEy) * Downloads.MIN_WAIT_FOR_NETWORK) / i2;
        this.lFh = (this.iZo - this.lEy) - this.lFh;
        for (int i4 = 0; i4 < i; i4++) {
            this.rQe[i4].y = ((float) (this.iZo - this.lEy)) - ((((float) this.rQe[i4].hzv) / ((float) i2)) * ((float) ((this.iZo - this.lEw) - this.lEy)));
        }
        for (i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                this.rQe[i2].qkq = this.rPW.format(new Date(this.rQe[i2].timestamp));
            } else if (this.rQb != a.MONTH) {
                this.rQe[i2].qkq = this.rPX.format(new Date(this.rQe[i2].timestamp));
            } else if (i2 % 6 == 5) {
                this.rQe[i2].qkq = this.rPX.format(new Date(this.rQe[i2].timestamp));
            } else {
                this.rQe[i2].qkq = "";
            }
        }
        super.onDraw(canvas);
        if (!this.rPY) {
            k(canvas);
            if (this.nWb != BaseClientBuilder.API_PRIORITY_OTHER) {
                i = this.nWb;
                if (i >= 0 && i <= this.rQc - 1) {
                    this.aFY.reset();
                    this.aFY.setColor(this.lEd);
                    this.aFY.setAntiAlias(true);
                    this.aFY.setStrokeWidth(0.0f);
                    this.aFY.setTextSize(m(2, 12.0f));
                    this.aFY.setTextAlign(Align.CENTER);
                    if (i == 0) {
                        this.aFY.setTextAlign(Align.LEFT);
                    }
                    if (i == this.rQc - 1) {
                        this.aFY.setTextAlign(Align.RIGHT);
                    }
                    if (!this.lFx) {
                        this.lFw = ((int) this.rQe[i].y) - this.lEY;
                        this.startY = this.lFw;
                        this.lFx = true;
                    }
                    if (this.lFx) {
                        float f = (float) (((double) this.startY) / 8.0d);
                        if (this.lFw > 0) {
                            this.aFY.setAlpha(((this.startY - this.lFw) * 255) / this.startY);
                        }
                        canvas.drawText(this.rQe[i].hzv, this.rQe[i].x, (float) (this.lFw + this.lEY), this.aFY);
                        if (this.rQb == a.MONTH) {
                            this.aFY.reset();
                            this.lFr.reset();
                            this.aFY.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
                            this.aFY.setColor(this.lDX);
                            this.aFY.setStrokeWidth((float) this.lEq);
                            this.aFY.setStyle(Style.STROKE);
                            this.aFY.setAlpha(102);
                            this.lFr.moveTo(this.rQe[i].x, (float) (this.iZo - this.lEE));
                            this.lFr.lineTo(this.rQe[i].x, (float) ((this.lFw + this.lEY) + this.lEm));
                            canvas.drawPath(this.lFr, this.aFY);
                        }
                        if (this.lFw > 0) {
                            if (((float) this.lFw) / ((float) this.startY) <= 1.0f / f) {
                                this.lFw--;
                            } else {
                                this.lFw = (int) (((float) this.lFw) - (f * (((float) this.lFw) / ((float) this.startY))));
                            }
                            invalidate();
                        } else {
                            this.lFx = false;
                        }
                    }
                }
                i = this.nWb;
                if (i >= 0 && i <= this.rQc - 1) {
                    this.rQe[i].rQn = true;
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
        if (!(this.lFh == 0 || this.rPY)) {
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
        if (!this.rPY) {
            this.aFY.reset();
            this.aFY.setColor(this.lEf);
            this.aFY.setAntiAlias(true);
            this.aFY.setAlpha(102);
            this.aFY.setStrokeWidth(0.0f);
            this.aFY.setTextSize(m(2, 12.0f));
            this.aFY.setTextAlign(Align.RIGHT);
            canvas.drawText(getResources().getString(R.string.err), (float) (this.iZn - this.lEM), (float) (((double) this.lFh) + (((double) this.aFY.getTextSize()) * 0.34d)), this.aFY);
        }
        if (this.rQg) {
            this.aFY.reset();
            this.aFY.setColor(-1);
            this.aFY.setAntiAlias(true);
            this.aFY.setStrokeWidth(0.0f);
            this.aFY.setTypeface(this.lFi);
            this.aFY.setTextAlign(Align.RIGHT);
            this.aFY.setTextSize(m(2, 28.0f));
            String valueOf = String.valueOf(this.rQf);
            canvas.drawText(valueOf, (float) (this.iZn - this.lEW), (float) this.lEU, this.aFY);
            float measureText = this.aFY.measureText(valueOf);
            this.aFY.setTextSize(m(2, 24.0f));
            canvas.drawText(getResources().getString(R.string.eru), ((float) (this.iZn - this.lEW)) - measureText, (float) this.lEQ, this.aFY);
        } else {
            this.aFY.reset();
            this.aFY.setColor(-1);
            this.aFY.setAntiAlias(true);
            this.aFY.setStrokeWidth(0.0f);
            this.aFY.setTypeface(this.lFi);
            this.aFY.setTextSize(m(2, 24.0f));
            canvas.drawText(getResources().getString(R.string.ert), (float) this.lES, (float) this.lEQ, this.aFY);
            this.aFY.setTextAlign(Align.RIGHT);
            this.aFY.setTextSize(m(2, 28.0f));
            canvas.drawText(this.rQf, (float) (this.iZn - this.lEW), (float) this.lEU, this.aFY);
        }
        if (this.rQe.length > 2) {
            this.aFY.reset();
            this.aFY.setAntiAlias(true);
            this.aFY.setStrokeWidth(0.0f);
            this.aFY.setAlpha(102);
            this.aFY.setStyle(Style.FILL_AND_STROKE);
            this.aFY.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, (float) (this.iZo - this.lEE), -1, 16777215, TileMode.REPEAT));
            this.aFY.setColor(-1);
            c(canvas, true);
            bqf();
            if (!this.rPY) {
                c(canvas, false);
            }
        }
        l(canvas);
        AppMethodBeat.o(65437);
    }
}
