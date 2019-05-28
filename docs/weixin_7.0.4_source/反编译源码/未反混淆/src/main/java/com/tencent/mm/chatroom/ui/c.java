package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import java.security.InvalidParameterException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;

public final class c extends View {
    protected static int eng = 32;
    protected static int enh;
    protected static int eni = 1;
    protected static int enj;
    protected static int enk = 10;
    protected static int enl;
    protected static int enm;
    protected static int enn;
    Collection<com.tencent.mm.chatroom.c.a> ejb = new ArrayList();
    protected int enA;
    protected int enB;
    protected int enC;
    private final StringBuilder enD;
    protected boolean enE = false;
    protected boolean enF = false;
    protected int enG = -1;
    protected int enH = -1;
    protected int enI = -1;
    protected int enJ = -1;
    protected int enK = -1;
    protected int enL = -1;
    protected int enM = -1;
    protected int enN = 1;
    protected int enO = 7;
    protected int enP = this.enO;
    private int enQ = 0;
    protected int enR;
    protected Boolean enS;
    protected int enT = eng;
    protected int enU = 0;
    protected int enV;
    final Time enW;
    private final Calendar enX;
    private final Calendar enY;
    private final Boolean enZ;
    protected int eno = 80;
    protected Paint enp;
    protected Paint enq;
    protected Paint enr;
    protected Paint ens;
    protected Paint ent;
    protected int enu;
    protected int env;
    protected int enw;
    protected int enx;
    protected int eny;
    protected int enz;
    private DateFormatSymbols eoa = new DateFormatSymbols();
    private a eob;
    public int fW = 6;
    private Context mContext;
    protected int mWidth;

    public interface a {
        void b(com.tencent.mm.chatroom.c.a aVar);
    }

    public c(Context context, TypedArray typedArray) {
        super(context);
        AppMethodBeat.i(104451);
        this.mContext = context;
        Resources resources = context.getResources();
        this.enY = Calendar.getInstance();
        this.enX = Calendar.getInstance();
        this.enW = new Time(Time.getCurrentTimezone());
        this.enW.setToNow();
        this.enu = typedArray.getColor(0, resources.getColor(R.color.w1));
        this.env = typedArray.getColor(6, resources.getColor(R.color.w1));
        this.enw = typedArray.getColor(7, resources.getColor(R.color.w1));
        this.enx = typedArray.getColor(7, resources.getColor(R.color.w2));
        this.eny = typedArray.getColor(5, resources.getColor(R.color.w1));
        this.enA = typedArray.getColor(3, resources.getColor(R.color.w1));
        this.enB = typedArray.getColor(4, resources.getColor(R.color.uv));
        this.enC = typedArray.getColor(1, resources.getColor(R.color.z2));
        this.enz = typedArray.getColor(2, resources.getColor(R.color.z3));
        this.enS = Boolean.valueOf(typedArray.getBoolean(17, false));
        this.enD = new StringBuilder(50);
        enj = typedArray.getDimensionPixelSize(8, resources.getDimensionPixelSize(R.dimen.a_e));
        enn = typedArray.getDimensionPixelSize(9, resources.getDimensionPixelSize(R.dimen.a_g));
        enl = typedArray.getDimensionPixelSize(10, resources.getDimensionPixelSize(R.dimen.a_f));
        enm = typedArray.getDimensionPixelOffset(11, resources.getDimensionPixelOffset(R.dimen.a2y));
        enh = typedArray.getDimensionPixelSize(12, resources.getDimensionPixelOffset(R.dimen.a7x));
        this.enT = (typedArray.getDimensionPixelSize(13, resources.getDimensionPixelOffset(R.dimen.v4)) - enm) / 6;
        this.enU = typedArray.getDimensionPixelSize(14, resources.getDimensionPixelOffset(R.dimen.wm));
        this.enZ = Boolean.valueOf(typedArray.getBoolean(15, true));
        this.ens = new Paint();
        this.ens.setAntiAlias(true);
        this.ens.setTextSize((float) enn);
        this.ens.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        this.ens.setColor(this.enx);
        this.ens.setTextAlign(Align.LEFT);
        this.ens.setStyle(Style.FILL);
        this.enr = new Paint();
        this.enr.setFakeBoldText(true);
        this.enr.setAntiAlias(true);
        this.enr.setColor(this.enz);
        this.enr.setTextAlign(Align.CENTER);
        this.enr.setStyle(Style.FILL);
        this.ent = new Paint();
        this.ent.setFakeBoldText(true);
        this.ent.setAntiAlias(true);
        this.ent.setColor(this.enC);
        this.ent.setTextAlign(Align.CENTER);
        this.ent.setStyle(Style.FILL);
        this.enp = new Paint();
        this.enp.setAntiAlias(true);
        this.enp.setTextSize((float) enl);
        this.enp.setColor(this.enx);
        this.enp.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        this.enp.setStyle(Style.FILL);
        this.enp.setTextAlign(Align.CENTER);
        this.enp.setFakeBoldText(true);
        this.enq = new Paint();
        this.enq.setAntiAlias(true);
        this.enq.setTextSize((float) enj);
        this.enq.setStyle(Style.FILL);
        this.enq.setTextAlign(Align.CENTER);
        this.enq.setFakeBoldText(false);
        AppMethodBeat.o(104451);
    }

    private void c(Canvas canvas) {
        AppMethodBeat.i(104452);
        int i = enm - (enl / 2);
        int i2 = (this.mWidth - (this.eno * 2)) / (this.enO * 2);
        for (int i3 = 0; i3 < this.enO; i3++) {
            int i4 = (((i3 * 2) + 1) * i2) + this.eno;
            this.enY.set(7, (this.enN + i3) % this.enO);
            canvas.drawText(this.eoa.getShortWeekdays()[this.enY.get(7)].toUpperCase(Locale.getDefault()), (float) i4, (float) i, this.enp);
        }
        AppMethodBeat.o(104452);
    }

    private int KE() {
        return (this.enQ < this.enN ? this.enQ + this.enO : this.enQ) - this.enN;
    }

    private String getMonthAndYearString() {
        AppMethodBeat.i(104453);
        this.enD.setLength(0);
        long timeInMillis = this.enX.getTimeInMillis();
        String formatDateRange = DateUtils.formatDateRange(getContext(), timeInMillis, timeInMillis, 52);
        AppMethodBeat.o(104453);
        return formatDateRange;
    }

    private boolean a(int i, Time time) {
        return this.enV < time.year || ((this.enV == time.year && this.enR < time.month) || (this.enR == time.month && i < time.monthDay));
    }

    private void d(Canvas canvas) {
        AppMethodBeat.i(104454);
        int i = (((this.enT + enj) / 2) - eni) + enm;
        int i2 = (this.mWidth - (this.eno * 2)) / (this.enO * 2);
        int KE = KE();
        int i3 = 1;
        while (true) {
            int i4 = i3;
            if (i4 > this.enP || (i4 > this.enM && -1 != this.enM)) {
                AppMethodBeat.o(104454);
            } else {
                int i5 = this.eno + (((KE * 2) + 1) * i2);
                if ((this.enR == this.enI && this.enG == i4 && this.enK == this.enV) || ((this.enR == this.enJ && this.enH == i4 && this.enL == this.enV) || (this.enE && this.enM == i4 && this.enG == -1))) {
                    if (this.enS.booleanValue()) {
                        canvas.drawRoundRect(new RectF((float) (i5 - enh), (float) ((i - (enj / 3)) - enh), (float) (enh + i5), (float) ((i - (enj / 3)) + enh)), 10.0f, 10.0f, this.ent);
                    } else {
                        canvas.drawCircle((float) i5, (float) (i - (enj / 3)), (float) enh, this.ent);
                    }
                    if (this.enE && this.enM == i4 && this.enG == -1) {
                        this.enq.setColor(this.enC);
                        this.enq.setTypeface(Typeface.defaultFromStyle(0));
                        this.enq.setTextSize(30.0f);
                        canvas.drawText(this.mContext.getResources().getString(R.string.ewk), (float) i5, (float) ((i + 12) + enh), this.enq);
                    }
                }
                this.enq.setTextSize((float) enj);
                if (!(this.enE && this.enM == i4)) {
                    this.enq.setColor(this.eny);
                    this.enq.setTypeface(Typeface.defaultFromStyle(0));
                }
                if (this.enG != -1 && this.enH != -1 && this.enK == this.enL && this.enI == this.enJ && this.enG == this.enH && i4 == this.enG && this.enR == this.enI && this.enV == this.enK) {
                    this.enq.setColor(this.enC);
                }
                if (this.enG != -1 && this.enH != -1 && this.enK == this.enL && this.enK == this.enV && ((this.enR == this.enI && this.enJ == this.enI && ((this.enG < this.enH && i4 > this.enG && i4 < this.enH) || (this.enG > this.enH && i4 < this.enG && i4 > this.enH))) || ((this.enI < this.enJ && this.enR == this.enI && i4 > this.enG) || ((this.enI < this.enJ && this.enR == this.enJ && i4 < this.enH) || ((this.enI > this.enJ && this.enR == this.enI && i4 < this.enG) || (this.enI > this.enJ && this.enR == this.enJ && i4 > this.enH)))))) {
                    this.enq.setColor(this.enC);
                }
                if (!(this.enG == -1 || this.enH == -1 || this.enK == this.enL || (((this.enK != this.enV || this.enR != this.enI) && (this.enL != this.enV || this.enR != this.enJ)) || ((this.enI >= this.enJ || this.enR != this.enI || i4 >= this.enG) && ((this.enI >= this.enJ || this.enR != this.enJ || i4 <= this.enH) && ((this.enI <= this.enJ || this.enR != this.enI || i4 <= this.enG) && (this.enI <= this.enJ || this.enR != this.enJ || i4 >= this.enH))))))) {
                    this.enq.setColor(this.enC);
                }
                if (this.enG != -1 && this.enH != -1 && this.enK == this.enL && this.enV == this.enK && ((this.enR > this.enI && this.enR < this.enJ && this.enI < this.enJ) || (this.enR < this.enI && this.enR > this.enJ && this.enI > this.enJ))) {
                    this.enq.setColor(this.enC);
                }
                if (!(this.enG == -1 || this.enH == -1 || this.enK == this.enL || ((this.enK >= this.enL || ((this.enR <= this.enI || this.enV != this.enK) && (this.enR >= this.enJ || this.enV != this.enL))) && (this.enK <= this.enL || ((this.enR >= this.enI || this.enV != this.enK) && (this.enR <= this.enJ || this.enV != this.enL)))))) {
                    this.enq.setColor(this.enC);
                }
                if (!this.enZ.booleanValue() && a(i4, this.enW) && this.enW.month == this.enR && this.enW.year == this.enV) {
                    this.enq.setColor(this.enA);
                    this.enq.setTypeface(Typeface.defaultFromStyle(2));
                }
                for (com.tencent.mm.chatroom.c.a aVar : this.ejb) {
                    if (aVar.ehf == i4 && aVar.month == this.enR && aVar.year == this.enV) {
                        this.enq.setColor(this.enB);
                        this.enq.setTypeface(Typeface.defaultFromStyle(0));
                    }
                }
                if ((this.enR == this.enI && this.enG == i4 && this.enK == this.enV) || ((this.enR == this.enJ && this.enH == i4 && this.enL == this.enV) || (this.enE && this.enM == i4 && this.enG == -1))) {
                    this.enq.setTypeface(Typeface.defaultFromStyle(0));
                    this.enq.setColor(-1);
                }
                canvas.drawText(String.format("%d", new Object[]{Integer.valueOf(i4)}), (float) i5, (float) i, this.enq);
                KE++;
                if (KE == this.enO) {
                    KE = 0;
                    i += this.enT;
                }
                i3 = i4 + 1;
            }
        }
        AppMethodBeat.o(104454);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.i(104456);
        setMeasuredDimension(MeasureSpec.getSize(i), ((this.enT * this.fW) + enm) + this.enU);
        AppMethodBeat.o(104456);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mWidth = i;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(104457);
        if (motionEvent.getAction() == 1) {
            com.tencent.mm.chatroom.c.a aVar;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int i = this.eno;
            if (x < ((float) i) || x > ((float) (this.mWidth - this.eno))) {
                aVar = null;
            } else {
                int KE = ((((int) (((x - ((float) i)) * ((float) this.enO)) / ((float) ((this.mWidth - i) - this.eno)))) - KE()) + 1) + ((((int) (y - ((float) enm))) / this.enT) * this.enO);
                if (this.enR > 11 || this.enR < 0 || com.tencent.mm.chatroom.f.a.bP(this.enR, this.enV) < KE || KE <= 0) {
                    aVar = null;
                } else {
                    com.tencent.mm.chatroom.c.a aVar2 = new com.tencent.mm.chatroom.c.a(this.enV, this.enR, KE);
                    for (com.tencent.mm.chatroom.c.a aVar3 : this.ejb) {
                        if (aVar3.equals(aVar2)) {
                            break;
                        }
                    }
                    aVar3 = null;
                }
            }
            if (!(aVar3 == null || this.eob == null || (!this.enZ.booleanValue() && aVar3.month == this.enW.month && aVar3.year == this.enW.year && aVar3.ehf < this.enW.monthDay))) {
                this.eob.b(aVar3);
            }
        }
        AppMethodBeat.o(104457);
        return true;
    }

    public final void setMarkDate(Collection<com.tencent.mm.chatroom.c.a> collection) {
        AppMethodBeat.i(104458);
        if (collection != null) {
            this.ejb = collection;
            AppMethodBeat.o(104458);
            return;
        }
        ab.e("MicroMsg.SimpleMonthView", "markDateList is null");
        AppMethodBeat.o(104458);
    }

    public final void setMonthParams(HashMap<String, Integer> hashMap) {
        int i = 0;
        AppMethodBeat.i(104459);
        if (hashMap.containsKey("month") || hashMap.containsKey("year")) {
            int i2;
            int i3;
            setTag(hashMap);
            if (hashMap.containsKey("height")) {
                this.enT = ((Integer) hashMap.get("height")).intValue();
                if (this.enT < enk) {
                    this.enT = enk;
                }
            }
            if (hashMap.containsKey("selected_begin_day")) {
                this.enG = ((Integer) hashMap.get("selected_begin_day")).intValue();
            }
            if (hashMap.containsKey("selected_last_day")) {
                this.enH = ((Integer) hashMap.get("selected_last_day")).intValue();
            }
            if (hashMap.containsKey("selected_begin_month")) {
                this.enI = ((Integer) hashMap.get("selected_begin_month")).intValue();
            }
            if (hashMap.containsKey("selected_last_month")) {
                this.enJ = ((Integer) hashMap.get("selected_last_month")).intValue();
            }
            if (hashMap.containsKey("selected_begin_year")) {
                this.enK = ((Integer) hashMap.get("selected_begin_year")).intValue();
            }
            if (hashMap.containsKey("selected_last_year")) {
                this.enL = ((Integer) hashMap.get("selected_last_year")).intValue();
            }
            this.enR = ((Integer) hashMap.get("month")).intValue();
            this.enV = ((Integer) hashMap.get("year")).intValue();
            this.enE = false;
            this.enM = -1;
            this.enX.set(2, this.enR);
            this.enX.set(1, this.enV);
            this.enX.set(5, 1);
            this.enQ = this.enX.get(7);
            if (hashMap.containsKey("week_start")) {
                this.enN = ((Integer) hashMap.get("week_start")).intValue();
            } else {
                this.enN = this.enX.getFirstDayOfWeek();
            }
            this.enP = com.tencent.mm.chatroom.f.a.bP(this.enR, this.enV);
            for (i2 = 0; i2 < this.enP; i2++) {
                int i4 = i2 + 1;
                Time time = this.enW;
                if (this.enV == time.year && this.enR == time.month && i4 == time.monthDay) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (i3 != 0) {
                    this.enE = true;
                    this.enM = i4;
                }
                this.enF = a(i4, this.enW);
            }
            i2 = KE();
            i3 = (this.enP + i2) / this.enO;
            if ((i2 + this.enP) % this.enO > 0) {
                i = 1;
            }
            this.fW = i3 + i;
            AppMethodBeat.o(104459);
            return;
        }
        InvalidParameterException invalidParameterException = new InvalidParameterException("You must specify month and year for this view");
        AppMethodBeat.o(104459);
        throw invalidParameterException;
    }

    public final void setOnDayClickListener(a aVar) {
        this.eob = aVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(104455);
        int i = (((this.mWidth - (this.eno * 2)) / (this.enO * 2)) + this.eno) - (enn / 2);
        int i2 = ((enm - enn) / 2) + enn;
        StringBuilder stringBuilder = new StringBuilder(getMonthAndYearString().toLowerCase());
        stringBuilder.setCharAt(0, Character.toUpperCase(stringBuilder.charAt(0)));
        canvas.drawText(stringBuilder.toString(), (float) i, (float) i2, this.ens);
        canvas.drawLine(0.0f, (float) enm, (float) this.mWidth, (float) (enm + 1), this.ens);
        c(canvas);
        d(canvas);
        AppMethodBeat.o(104455);
    }
}
