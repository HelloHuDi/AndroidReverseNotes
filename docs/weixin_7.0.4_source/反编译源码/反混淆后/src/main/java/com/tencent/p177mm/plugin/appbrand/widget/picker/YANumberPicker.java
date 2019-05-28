package com.tencent.p177mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.widget.C0539p;
import android.support.p057v4.widget.C8415j;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.luggage.p1523b.p1524a.C37385a.C37386a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker */
public class YANumberPicker extends View {
    private int aKu;
    private int aKv;
    private int alw = 2;
    private float hkf = 0.0f;
    private int jlA = 0;
    private int jlB = 0;
    private int jlC = 0;
    private int jlD = 150;
    private int jlE = 8;
    private String jlF;
    private String jlG;
    private String jlH;
    private String jlI;
    private float jlJ = 1.0f;
    private float jlK = 0.0f;
    private float jlL = 0.0f;
    private float jlM = 0.0f;
    private boolean jlN = true;
    private boolean jlO = true;
    private boolean jlP = false;
    private boolean jlQ = true;
    private boolean jlR = false;
    private boolean jlS = false;
    private boolean jlT = true;
    private C0539p jlU;
    private Paint jlV = new Paint();
    private TextPaint jlW = new TextPaint();
    private Paint jlX = new Paint();
    private String[] jlY;
    private CharSequence[] jlZ;
    private int jlc = -13421773;
    private int jld = -695533;
    private int jle = -695533;
    private int jlf = 0;
    private int jlg = 0;
    private int jlh = 0;
    private int jli = 0;
    private int jlj = 0;
    private int jlk = 0;
    private int jll = 0;
    private int jlm = 0;
    private int jln = 0;
    private int jlo = -695533;
    private int jlp = 0;
    private int jlq = 0;
    private int jlr = 3;
    private int jls = 0;
    private int jlt = 0;
    private int jlu = -1;
    private int jlv = -1;
    private int jlw = 0;
    private int jlx = 0;
    private int jly = 0;
    private int jlz = 0;
    private CharSequence[] jma;
    private Handler jmb;
    private Handler jmc;
    private C27424d jmd;
    private C27425b jme;
    private C27423a jmf;
    private C27422c jmg;
    private int jmh;
    private int jmi;
    private int jmj;
    private int jmk;
    private float jml = 0.0f;
    private float jmm = 0.0f;
    private boolean jmn = false;
    private float jmo;
    private float jmp;
    private float jmq;
    private int jmr = 0;
    private int jms = 0;
    private int jmt = 0;
    private int jmu = 0;
    private int jmv = 0;
    /* renamed from: le */
    private int f13683le;
    private HandlerThread mHandlerThread;
    private boolean mHasInit = false;
    private int mScrollState = 0;
    private VelocityTracker mVelocityTracker;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker$2 */
    class C199052 extends Handler {
        C199052() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(126758);
            super.handleMessage(message);
            switch (message.what) {
                case 2:
                    YANumberPicker.m43506a(YANumberPicker.this, message.arg1, message.arg2, message.obj);
                    break;
                case 3:
                    YANumberPicker.this.requestLayout();
                    AppMethodBeat.m2505o(126758);
                    return;
            }
            AppMethodBeat.m2505o(126758);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker$c */
    public interface C27422c {
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker$a */
    public interface C27423a {
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker$d */
    public interface C27424d {
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker$b */
    public interface C27425b {
        /* renamed from: a */
        void mo45198a(YANumberPicker yANumberPicker, int i);
    }

    /* renamed from: c */
    static /* synthetic */ int m43511c(YANumberPicker yANumberPicker, int i) {
        AppMethodBeat.m2504i(126815);
        int qU = yANumberPicker.m43526qU(i);
        AppMethodBeat.m2505o(126815);
        return qU;
    }

    /* renamed from: c */
    static /* synthetic */ Message m43513c(int i, int i2, int i3, Object obj) {
        AppMethodBeat.m2504i(126814);
        Message b = YANumberPicker.m43508b(i, i2, i3, obj);
        AppMethodBeat.m2505o(126814);
        return b;
    }

    public YANumberPicker(Context context) {
        super(context);
        AppMethodBeat.m2504i(126759);
        init(context);
        AppMethodBeat.m2505o(126759);
    }

    public YANumberPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(126760);
        m43509b(context, attributeSet);
        init(context);
        AppMethodBeat.m2505o(126760);
    }

    public YANumberPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(126761);
        m43509b(context, attributeSet);
        init(context);
        AppMethodBeat.m2505o(126761);
    }

    /* renamed from: b */
    private void m43509b(Context context, AttributeSet attributeSet) {
        AppMethodBeat.m2504i(126762);
        if (attributeSet == null) {
            AppMethodBeat.m2505o(126762);
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C37386a.YANumberPicker);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 0) {
                this.jlr = obtainStyledAttributes.getInt(index, 3);
            } else if (index == 2) {
                this.jlo = obtainStyledAttributes.getColor(index, -695533);
            } else if (index == 5) {
                this.alw = obtainStyledAttributes.getDimensionPixelSize(index, 2);
            } else if (index == 3) {
                this.jlp = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == 4) {
                this.jlq = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == 12) {
                String[] strArr;
                CharSequence[] textArray = obtainStyledAttributes.getTextArray(index);
                if (textArray == null) {
                    strArr = null;
                } else {
                    String[] strArr2 = new String[textArray.length];
                    for (index = 0; index < textArray.length; index++) {
                        strArr2[index] = textArray[index].toString();
                    }
                    strArr = strArr2;
                }
                this.jlY = strArr;
            } else if (index == 6) {
                this.jlc = obtainStyledAttributes.getColor(index, -13421773);
            } else if (index == 7) {
                this.jld = obtainStyledAttributes.getColor(index, -695533);
            } else if (index == 8) {
                this.jle = obtainStyledAttributes.getColor(index, -695533);
            } else if (index == 9) {
                this.jlf = obtainStyledAttributes.getDimensionPixelSize(index, YANumberPicker.m43515e(context, 13.0f));
            } else if (index == 10) {
                this.jlg = obtainStyledAttributes.getDimensionPixelSize(index, YANumberPicker.m43515e(context, 15.0f));
            } else if (index == 11) {
                this.jlh = obtainStyledAttributes.getDimensionPixelSize(index, YANumberPicker.m43515e(context, 14.0f));
            } else if (index == 13) {
                this.jlu = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == 14) {
                this.jlv = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == 15) {
                this.jlO = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == 1) {
                this.jlN = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == 17) {
                this.jlF = obtainStyledAttributes.getString(index);
            } else if (index == 27) {
                this.jlI = obtainStyledAttributes.getString(index);
            } else if (index == 18) {
                this.jlH = obtainStyledAttributes.getString(index);
            } else if (index == 19) {
                this.jlk = obtainStyledAttributes.getDimensionPixelSize(index, YANumberPicker.m43517f(context, 8.0f));
            } else if (index == 20) {
                this.jll = obtainStyledAttributes.getDimensionPixelSize(index, YANumberPicker.m43517f(context, 8.0f));
            } else if (index == 22) {
                this.jlm = obtainStyledAttributes.getDimensionPixelSize(index, YANumberPicker.m43517f(context, 2.0f));
            } else if (index == 21) {
                this.jln = obtainStyledAttributes.getDimensionPixelSize(index, YANumberPicker.m43517f(context, 5.0f));
            } else if (index == 25) {
                this.jlZ = obtainStyledAttributes.getTextArray(index);
            } else if (index == 26) {
                this.jma = obtainStyledAttributes.getTextArray(index);
            } else if (index == 16) {
                this.jlS = obtainStyledAttributes.getBoolean(index, false);
            } else if (index == 23) {
                this.jlT = obtainStyledAttributes.getBoolean(index, true);
            } else if (index == 24) {
                this.jlG = obtainStyledAttributes.getString(index);
            }
        }
        obtainStyledAttributes.recycle();
        AppMethodBeat.m2505o(126762);
    }

    private void aRN() {
        AppMethodBeat.m2504i(126764);
        this.mHandlerThread = new HandlerThread("HandlerThread-For-Refreshing");
        this.mHandlerThread.start();
        this.jmb = new Handler(this.mHandlerThread.getLooper()) {
            public final void handleMessage(Message message) {
                int i = 0;
                AppMethodBeat.m2504i(126757);
                switch (message.what) {
                    case 1:
                        if (YANumberPicker.this.jlU.f710qN.isFinished()) {
                            int c;
                            if (YANumberPicker.this.jms != 0) {
                                if (YANumberPicker.this.mScrollState == 0) {
                                    YANumberPicker.m43510b(YANumberPicker.this, 1);
                                }
                                int e;
                                if (YANumberPicker.this.jms < (-YANumberPicker.this.f13683le) / 2) {
                                    e = (int) ((((float) (YANumberPicker.this.f13683le + YANumberPicker.this.jms)) * 300.0f) / ((float) YANumberPicker.this.f13683le));
                                    int i2 = 0;
                                    YANumberPicker.this.jlU.startScroll(0, YANumberPicker.this.jmt, i2, YANumberPicker.this.jms + YANumberPicker.this.f13683le, e * 3);
                                    c = YANumberPicker.m43511c(YANumberPicker.this, (YANumberPicker.this.jmt + YANumberPicker.this.f13683le) + YANumberPicker.this.jms);
                                    i = e;
                                } else {
                                    e = (int) ((((float) (-YANumberPicker.this.jms)) * 300.0f) / ((float) YANumberPicker.this.f13683le));
                                    YANumberPicker.this.jlU.startScroll(0, YANumberPicker.this.jmt, 0, YANumberPicker.this.jms, e * 3);
                                    c = YANumberPicker.m43511c(YANumberPicker.this, YANumberPicker.this.jmt + YANumberPicker.this.jms);
                                    i = e;
                                }
                                YANumberPicker.this.postInvalidate();
                            } else {
                                YANumberPicker.m43510b(YANumberPicker.this, 0);
                                c = YANumberPicker.m43511c(YANumberPicker.this, YANumberPicker.this.jmt);
                            }
                            Message c2 = YANumberPicker.m43513c(2, YANumberPicker.this.jlC, c, message.obj);
                            if (YANumberPicker.this.jlT) {
                                YANumberPicker.this.jmc.sendMessageDelayed(c2, (long) (i * 2));
                                AppMethodBeat.m2505o(126757);
                                return;
                            }
                            YANumberPicker.this.jmb.sendMessageDelayed(c2, (long) (i * 2));
                            AppMethodBeat.m2505o(126757);
                            return;
                        }
                        if (YANumberPicker.this.mScrollState == 0) {
                            YANumberPicker.m43510b(YANumberPicker.this, 1);
                        }
                        YANumberPicker.this.jmb.sendMessageDelayed(YANumberPicker.m43513c(1, 0, 0, message.obj), 32);
                        AppMethodBeat.m2505o(126757);
                        return;
                    case 2:
                        YANumberPicker.m43506a(YANumberPicker.this, message.arg1, message.arg2, message.obj);
                        break;
                }
                AppMethodBeat.m2505o(126757);
            }
        };
        this.jmc = new C199052();
        AppMethodBeat.m2505o(126764);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        AppMethodBeat.m2504i(126765);
        super.onMeasure(i, i2);
        m43519fg(false);
        int mode = MeasureSpec.getMode(i);
        this.jmu = mode;
        int size = MeasureSpec.getSize(i);
        if (mode == ErrorDialogData.SUPPRESSED) {
            i3 = size;
        } else {
            i3 = Math.max(this.jli, this.jlj) == 0 ? 0 : this.jll;
            if (Math.max(this.jli, this.jlj) != 0) {
                i4 = this.jlk;
            }
            i3 = Math.max(this.jlA, (((i3 + (i4 + Math.max(this.jli, this.jlj))) + (this.jln * 2)) * 2) + Math.max(this.jly, this.jlB)) + (getPaddingLeft() + getPaddingRight());
            if (mode == C8415j.INVALID_ID) {
                i3 = Math.min(i3, size);
            }
        }
        mode = MeasureSpec.getMode(i2);
        this.jmv = mode;
        i4 = MeasureSpec.getSize(i2);
        if (mode != ErrorDialogData.SUPPRESSED) {
            size = (this.jlr * (this.jlz + (this.jlm * 2))) + (getPaddingTop() + getPaddingBottom());
            i4 = mode == C8415j.INVALID_ID ? Math.min(size, i4) : size;
        }
        setMeasuredDimension(i3, i4);
        AppMethodBeat.m2505o(126765);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z;
        AppMethodBeat.m2504i(126766);
        super.onSizeChanged(i, i2, i3, i4);
        this.aKu = i;
        this.aKv = i2;
        this.f13683le = this.aKv / this.jlr;
        this.jmq = ((float) ((this.aKu + getPaddingLeft()) - getPaddingRight())) / 2.0f;
        int value = getOneRecycleSize() > 1 ? this.mHasInit ? getValue() - this.jlw : this.jlP ? this.jmr + ((this.jlr - 1) / 2) : 0 : 0;
        if (this.jlO && this.jlQ) {
            z = true;
        } else {
            z = false;
        }
        m43500M(value, z);
        if (this.jlf > this.f13683le) {
            this.jlf = this.f13683le;
        }
        if (this.jlg > this.f13683le) {
            this.jlg = this.f13683le;
        }
        IllegalArgumentException illegalArgumentException;
        if (this.jlX == null) {
            illegalArgumentException = new IllegalArgumentException("mPaintHint should not be null.");
            AppMethodBeat.m2505o(126766);
            throw illegalArgumentException;
        }
        this.jlX.setTextSize((float) this.jlh);
        this.jlM = YANumberPicker.m43501a(this.jlX.getFontMetrics());
        this.jli = YANumberPicker.m43503a(this.jlF, this.jlX);
        if (this.jlW == null) {
            illegalArgumentException = new IllegalArgumentException("mPaintText should not be null.");
            AppMethodBeat.m2505o(126766);
            throw illegalArgumentException;
        }
        this.jlW.setTextSize((float) this.jlg);
        this.jlL = YANumberPicker.m43501a(this.jlW.getFontMetrics());
        this.jlW.setTextSize((float) this.jlf);
        this.jlK = YANumberPicker.m43501a(this.jlW.getFontMetrics());
        aRP();
        this.jls = this.jlr / 2;
        this.jlt = this.jls + 1;
        this.jmo = (float) ((this.jls * this.aKv) / this.jlr);
        this.jmp = (float) ((this.jlt * this.aKv) / this.jlr);
        if (this.jlp < 0) {
            this.jlp = 0;
        }
        if (this.jlq < 0) {
            this.jlq = 0;
        }
        if (this.jlp + this.jlq != 0 && getPaddingLeft() + this.jlp >= (this.aKu - getPaddingRight()) - this.jlq) {
            value = (((getPaddingLeft() + this.jlp) + getPaddingRight()) + this.jlq) - this.aKu;
            this.jlp = (int) (((float) this.jlp) - ((((float) value) * ((float) this.jlp)) / ((float) (this.jlp + this.jlq))));
            this.jlq = (int) (((float) this.jlq) - ((((float) value) * ((float) this.jlq)) / ((float) (this.jlp + this.jlq))));
        }
        this.mHasInit = true;
        AppMethodBeat.m2505o(126766);
    }

    public void postInvalidate() {
        AppMethodBeat.m2504i(126767);
        if (C0477s.m930av(this)) {
            super.postInvalidate();
            AppMethodBeat.m2505o(126767);
            return;
        }
        AppMethodBeat.m2505o(126767);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(126768);
        super.onAttachedToWindow();
        if (this.mHandlerThread == null || !this.mHandlerThread.isAlive()) {
            aRN();
        }
        AppMethodBeat.m2505o(126768);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(126769);
        super.onDetachedFromWindow();
        this.mHandlerThread.quit();
        if (this.f13683le == 0) {
            AppMethodBeat.m2505o(126769);
            return;
        }
        if (!this.jlU.f710qN.isFinished()) {
            this.jlU.f710qN.abortAnimation();
            this.jmt = this.jlU.f710qN.getCurrY();
            aRQ();
            if (this.jms != 0) {
                if (this.jms < (-this.f13683le) / 2) {
                    this.jmt = (this.jmt + this.f13683le) + this.jms;
                } else {
                    this.jmt += this.jms;
                }
                aRQ();
            }
            m43525qT(0);
        }
        int qU = m43526qU(this.jmt);
        if (qU != this.jlC && this.jlS) {
            try {
                if (this.jme != null) {
                    this.jme.mo45198a(this, this.jlw + qU);
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.YANumberPicker", e, "", new Object[0]);
            }
        }
        this.jlC = qU;
        AppMethodBeat.m2505o(126769);
    }

    public int getOneRecycleSize() {
        return (this.jlv - this.jlu) + 1;
    }

    public int getRawContentSize() {
        if (this.jlY != null) {
            return this.jlY.length;
        }
        return 0;
    }

    public String[] getDisplayedValues() {
        return this.jlY;
    }

    public void setWrapSelectorWheel(boolean z) {
        AppMethodBeat.m2504i(126771);
        if (this.jlO != z) {
            if (z) {
                this.jlO = z;
                aRV();
                postInvalidate();
            } else if (this.mScrollState == 0) {
                aRO();
                AppMethodBeat.m2505o(126771);
                return;
            } else {
                this.jlR = true;
                AppMethodBeat.m2505o(126771);
                return;
            }
        }
        AppMethodBeat.m2505o(126771);
    }

    public int getMinValue() {
        return this.jlw;
    }

    public int getMaxValue() {
        return this.jlx;
    }

    public void setMinValue(int i) {
        AppMethodBeat.m2504i(126772);
        this.jlw = i;
        this.jlu = 0;
        aRP();
        AppMethodBeat.m2505o(126772);
    }

    public void setMaxValue(int i) {
        AppMethodBeat.m2504i(126773);
        if (this.jlY == null) {
            NullPointerException nullPointerException = new NullPointerException("mDisplayedValues should not be null");
            AppMethodBeat.m2505o(126773);
            throw nullPointerException;
        } else if ((i - this.jlw) + 1 > this.jlY.length) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("(maxValue - mMinValue + 1) should not be greater than mDisplayedValues.length now  (maxValue - mMinValue + 1) is " + ((i - this.jlw) + 1) + " and mDisplayedValues.length is " + this.jlY.length);
            AppMethodBeat.m2505o(126773);
            throw illegalArgumentException;
        } else {
            this.jlx = i;
            this.jlv = (this.jlx - this.jlw) + this.jlu;
            m43523j(this.jlu, this.jlv, true);
            aRP();
            AppMethodBeat.m2505o(126773);
        }
    }

    public void setValue(int i) {
        AppMethodBeat.m2504i(126774);
        IllegalArgumentException illegalArgumentException;
        if (i < this.jlw) {
            illegalArgumentException = new IllegalArgumentException("should not set a value less than mMinValue, value is ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(126774);
            throw illegalArgumentException;
        } else if (i > this.jlx) {
            illegalArgumentException = new IllegalArgumentException("should not set a value greater than mMaxValue, value is ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(126774);
            throw illegalArgumentException;
        } else {
            setPickedIndexRelativeToRaw(i - this.jlw);
            AppMethodBeat.m2505o(126774);
        }
    }

    public int getValue() {
        AppMethodBeat.m2504i(126775);
        int pickedIndexRelativeToRaw = getPickedIndexRelativeToRaw() + this.jlw;
        AppMethodBeat.m2505o(126775);
        return pickedIndexRelativeToRaw;
    }

    public String getContentByCurrValue() {
        AppMethodBeat.m2504i(126776);
        String str = this.jlY[getValue() - this.jlw];
        AppMethodBeat.m2505o(126776);
        return str;
    }

    public boolean getWrapSelectorWheel() {
        return this.jlO;
    }

    public boolean getWrapSelectorWheelAbsolutely() {
        return this.jlO && this.jlQ;
    }

    public void setHintText(String str) {
        boolean equals;
        AppMethodBeat.m2504i(126777);
        String str2 = this.jlF;
        if (str2 != null) {
            equals = str2.equals(str);
        } else if (str == null) {
            equals = true;
        } else {
            equals = false;
        }
        if (equals) {
            AppMethodBeat.m2505o(126777);
            return;
        }
        this.jlF = str;
        this.jlM = YANumberPicker.m43501a(this.jlX.getFontMetrics());
        this.jli = YANumberPicker.m43503a(this.jlF, this.jlX);
        this.jmc.sendEmptyMessage(3);
        AppMethodBeat.m2505o(126777);
    }

    public void setPickedIndexRelativeToMin(int i) {
        AppMethodBeat.m2504i(126778);
        if (i >= 0 && i < getOneRecycleSize()) {
            this.jlC = this.jlu + i;
            boolean z = this.jlO && this.jlQ;
            m43500M(i, z);
            postInvalidate();
        }
        AppMethodBeat.m2505o(126778);
    }

    public void setNormalTextColor(int i) {
        AppMethodBeat.m2504i(126779);
        if (this.jlc == i) {
            AppMethodBeat.m2505o(126779);
            return;
        }
        this.jlc = i;
        postInvalidate();
        AppMethodBeat.m2505o(126779);
    }

    public void setSelectedTextColor(int i) {
        AppMethodBeat.m2504i(126780);
        if (this.jld == i) {
            AppMethodBeat.m2505o(126780);
            return;
        }
        this.jld = i;
        postInvalidate();
        AppMethodBeat.m2505o(126780);
    }

    public void setHintTextColor(int i) {
        AppMethodBeat.m2504i(126781);
        if (this.jle == i) {
            AppMethodBeat.m2505o(126781);
            return;
        }
        this.jle = i;
        this.jlX.setColor(this.jle);
        postInvalidate();
        AppMethodBeat.m2505o(126781);
    }

    public void setDividerColor(int i) {
        AppMethodBeat.m2504i(126782);
        if (this.jlo == i) {
            AppMethodBeat.m2505o(126782);
            return;
        }
        this.jlo = i;
        this.jlV.setColor(this.jlo);
        postInvalidate();
        AppMethodBeat.m2505o(126782);
    }

    public void setDividerHeight(int i) {
        AppMethodBeat.m2504i(126783);
        if (i == this.alw) {
            AppMethodBeat.m2505o(126783);
            return;
        }
        this.alw = i;
        this.jlV.setStrokeWidth((float) this.alw);
        postInvalidate();
        AppMethodBeat.m2505o(126783);
    }

    public void setItemPaddingVertical(int i) {
        AppMethodBeat.m2504i(126784);
        if (this.jlm == i) {
            AppMethodBeat.m2505o(126784);
            return;
        }
        this.jlm = i;
        postInvalidate();
        AppMethodBeat.m2505o(126784);
    }

    public void setPickedIndexRelativeToRaw(int i) {
        AppMethodBeat.m2504i(126785);
        if (this.jlu >= 0 && this.jlu <= i && i <= this.jlv) {
            this.jlC = i;
            int i2 = i - this.jlu;
            boolean z = this.jlO && this.jlQ;
            m43500M(i2, z);
            postInvalidate();
        }
        AppMethodBeat.m2505o(126785);
    }

    public int getPickedIndexRelativeToRaw() {
        int qU;
        AppMethodBeat.m2504i(126786);
        if (this.jms == 0) {
            qU = m43526qU(this.jmt);
        } else if (this.jms < (-this.f13683le) / 2) {
            qU = m43526qU((this.jmt + this.f13683le) + this.jms);
        } else {
            qU = m43526qU(this.jmt + this.jms);
        }
        AppMethodBeat.m2505o(126786);
        return qU;
    }

    /* renamed from: j */
    private void m43523j(int i, int i2, boolean z) {
        AppMethodBeat.m2504i(126787);
        IllegalArgumentException illegalArgumentException;
        if (i > i2) {
            illegalArgumentException = new IllegalArgumentException("minShowIndex should be less than maxShowIndex, minShowIndex is " + i + ", maxShowIndex is " + i2 + ".");
            AppMethodBeat.m2505o(126787);
            throw illegalArgumentException;
        } else if (this.jlY == null) {
            illegalArgumentException = new IllegalArgumentException("mDisplayedValues should not be null, you need to set mDisplayedValues first.");
            AppMethodBeat.m2505o(126787);
            throw illegalArgumentException;
        } else if (i < 0) {
            illegalArgumentException = new IllegalArgumentException("minShowIndex should not be less than 0, now minShowIndex is ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(126787);
            throw illegalArgumentException;
        } else if (i > this.jlY.length - 1) {
            illegalArgumentException = new IllegalArgumentException("minShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.jlY.length - 1) + " minShowIndex is " + i);
            AppMethodBeat.m2505o(126787);
            throw illegalArgumentException;
        } else if (i2 < 0) {
            illegalArgumentException = new IllegalArgumentException("maxShowIndex should not be less than 0, now maxShowIndex is ".concat(String.valueOf(i2)));
            AppMethodBeat.m2505o(126787);
            throw illegalArgumentException;
        } else if (i2 > this.jlY.length - 1) {
            illegalArgumentException = new IllegalArgumentException("maxShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.jlY.length - 1) + " maxShowIndex is " + i2);
            AppMethodBeat.m2505o(126787);
            throw illegalArgumentException;
        } else {
            this.jlu = i;
            this.jlv = i2;
            if (z) {
                boolean z2;
                this.jlC = this.jlu + 0;
                if (this.jlO && this.jlQ) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                m43500M(0, z2);
                postInvalidate();
            }
            AppMethodBeat.m2505o(126787);
        }
    }

    public void setFriction(float f) {
        AppMethodBeat.m2504i(126788);
        if (f <= 0.0f) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("you should set a a positive float friction, now friction is ".concat(String.valueOf(f)));
            AppMethodBeat.m2505o(126788);
            throw illegalArgumentException;
        }
        ViewConfiguration.get(getContext());
        this.jlJ = ViewConfiguration.getScrollFriction() / f;
        AppMethodBeat.m2505o(126788);
    }

    /* renamed from: qT */
    private void m43525qT(int i) {
        if (this.mScrollState != i) {
            this.mScrollState = i;
        }
    }

    public void setOnScrollListener(C27423a c27423a) {
        this.jmf = c27423a;
    }

    public void setOnValueChangedListener(C27425b c27425b) {
        this.jme = c27425b;
    }

    public void setOnValueChangedListenerRelativeToRaw(C27424d c27424d) {
        this.jmd = c27424d;
    }

    public void setOnValueChangeListenerInScrolling(C27422c c27422c) {
        this.jmg = c27422c;
    }

    public void setContentTextTypeface(Typeface typeface) {
        AppMethodBeat.m2504i(126789);
        this.jlW.setTypeface(typeface);
        AppMethodBeat.m2505o(126789);
    }

    public void setHintTextTypeface(Typeface typeface) {
        AppMethodBeat.m2504i(126790);
        this.jlX.setTypeface(typeface);
        AppMethodBeat.m2505o(126790);
    }

    /* renamed from: qU */
    private int m43526qU(int i) {
        boolean z = false;
        AppMethodBeat.m2504i(126791);
        if (this.f13683le == 0) {
            AppMethodBeat.m2505o(126791);
            return 0;
        }
        int i2 = (i / this.f13683le) + (this.jlr / 2);
        int oneRecycleSize = getOneRecycleSize();
        if (this.jlO && this.jlQ) {
            z = true;
        }
        int k = YANumberPicker.m43524k(i2, oneRecycleSize, z);
        if (k < 0 || k >= getOneRecycleSize()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("getWillPickIndexByGlobalY illegal index : " + k + " getOneRecycleSize() : " + getOneRecycleSize() + " mWrapSelectorWheel : " + this.jlO);
            AppMethodBeat.m2505o(126791);
            throw illegalArgumentException;
        }
        k += this.jlu;
        AppMethodBeat.m2505o(126791);
        return k;
    }

    /* renamed from: k */
    private static int m43524k(int i, int i2, boolean z) {
        if (i2 <= 0) {
            return 0;
        }
        if (!z) {
            return i;
        }
        int i3 = i % i2;
        if (i3 < 0) {
            return i3 + i2;
        }
        return i3;
    }

    private void aRO() {
        AppMethodBeat.m2504i(126792);
        m43500M(getPickedIndexRelativeToRaw() - this.jlu, false);
        this.jlO = false;
        postInvalidate();
        AppMethodBeat.m2505o(126792);
    }

    private void aRP() {
        AppMethodBeat.m2504i(126793);
        this.jmj = 0;
        this.jmk = (-this.jlr) * this.f13683le;
        if (this.jlY != null) {
            this.jmj = ((getOneRecycleSize() - (this.jlr / 2)) - 1) * this.f13683le;
            this.jmk = (-(this.jlr / 2)) * this.f13683le;
        }
        AppMethodBeat.m2505o(126793);
    }

    /* renamed from: qV */
    private int m43527qV(int i) {
        if (this.jlO && this.jlQ) {
            return i;
        }
        if (i < this.jmk) {
            return this.jmk;
        }
        if (i > this.jmj) {
            return this.jmj;
        }
        return i;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(126794);
        if (this.f13683le == 0) {
            AppMethodBeat.m2505o(126794);
        } else {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            this.jmm = motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.jmn = true;
                    this.jmb.removeMessages(1);
                    aRW();
                    this.hkf = this.jmm;
                    this.jml = (float) this.jmt;
                    m43525qT(0);
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                case 1:
                    int yVelocity;
                    if (!this.jmn) {
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        velocityTracker.computeCurrentVelocity(1000);
                        yVelocity = (int) (velocityTracker.getYVelocity() * this.jlJ);
                        if (Math.abs(yVelocity) > this.jlD) {
                            C0539p c0539p = this.jlU;
                            c0539p.f710qN.fling(0, this.jmt, 0, -yVelocity, C8415j.INVALID_ID, BaseClientBuilder.API_PRIORITY_OTHER, m43527qV(C8415j.INVALID_ID), m43527qV(BaseClientBuilder.API_PRIORITY_OTHER));
                            invalidate();
                            m43525qT(2);
                        }
                        this.jmb.sendMessageDelayed(YANumberPicker.m43508b(1, 0, 0, null), 0);
                        if (this.mVelocityTracker != null) {
                            this.mVelocityTracker.clear();
                            this.mVelocityTracker.recycle();
                            this.mVelocityTracker = null;
                            break;
                        }
                    }
                    float y = motionEvent.getY();
                    yVelocity = 0;
                    while (yVelocity < this.jlr) {
                        if (((float) (this.f13683le * yVelocity)) <= y && y < ((float) (this.f13683le * (yVelocity + 1)))) {
                            if (yVelocity >= 0 && yVelocity < this.jlr) {
                                int pickedIndexRelativeToRaw;
                                int i;
                                int i2;
                                yVelocity -= this.jlr / 2;
                                if (!(this.jlO && this.jlQ)) {
                                    pickedIndexRelativeToRaw = getPickedIndexRelativeToRaw();
                                    if (pickedIndexRelativeToRaw + yVelocity > this.jlv) {
                                        yVelocity = this.jlv - pickedIndexRelativeToRaw;
                                    } else if (pickedIndexRelativeToRaw + yVelocity < this.jlu) {
                                        yVelocity = this.jlu - pickedIndexRelativeToRaw;
                                    }
                                }
                                if (this.jms < (-this.f13683le) / 2) {
                                    pickedIndexRelativeToRaw = this.f13683le + this.jms;
                                    i = (int) ((((float) (this.f13683le + this.jms)) * 300.0f) / ((float) this.f13683le));
                                    if (yVelocity < 0) {
                                        i = (-i) - (yVelocity * 300);
                                    } else {
                                        i += yVelocity * 300;
                                    }
                                } else {
                                    pickedIndexRelativeToRaw = this.jms;
                                    i = (int) ((((float) (-this.jms)) * 300.0f) / ((float) this.f13683le));
                                    if (yVelocity < 0) {
                                        i -= yVelocity * 300;
                                    } else {
                                        i += yVelocity * 300;
                                    }
                                }
                                int i3 = pickedIndexRelativeToRaw + (yVelocity * this.f13683le);
                                if (i < 300) {
                                    i2 = 300;
                                } else {
                                    i2 = i;
                                }
                                if (i2 > 600) {
                                    i2 = 600;
                                }
                                this.jlU.startScroll(0, this.jmt, 0, i3, i2);
                                this.jmb.sendMessageDelayed(YANumberPicker.m43508b(1, 0, 0, null), (long) (i2 / 4));
                                postInvalidate();
                                break;
                            }
                        }
                        yVelocity++;
                    }
                    break;
                    break;
                case 2:
                    float f = this.hkf - this.jmm;
                    if (!this.jmn || ((float) (-this.jlE)) >= f || f >= ((float) this.jlE)) {
                        this.jmn = false;
                        this.jmt = m43527qV((int) (f + this.jml));
                        aRQ();
                        invalidate();
                    }
                    m43525qT(1);
                    break;
                case 3:
                    this.jml = (float) this.jmt;
                    aRW();
                    this.jmb.sendMessageDelayed(YANumberPicker.m43508b(1, 0, 0, null), 0);
                    break;
            }
            AppMethodBeat.m2505o(126794);
        }
        return true;
    }

    /* renamed from: a */
    private static float m43501a(FontMetrics fontMetrics) {
        AppMethodBeat.m2504i(126795);
        if (fontMetrics == null) {
            AppMethodBeat.m2505o(126795);
            return 0.0f;
        }
        float abs = Math.abs(fontMetrics.top + fontMetrics.bottom) / 2.0f;
        AppMethodBeat.m2505o(126795);
        return abs;
    }

    /* renamed from: M */
    private void m43500M(int i, boolean z) {
        AppMethodBeat.m2504i(126796);
        this.jmr = i - ((this.jlr - 1) / 2);
        this.jmr = YANumberPicker.m43524k(this.jmr, getOneRecycleSize(), z);
        if (this.f13683le == 0) {
            this.jlP = true;
            AppMethodBeat.m2505o(126796);
            return;
        }
        this.jmt = this.jmr * this.f13683le;
        this.jmh = this.jmr + (this.jlr / 2);
        this.jmh %= getOneRecycleSize();
        if (this.jmh < 0) {
            this.jmh += getOneRecycleSize();
        }
        this.jmi = this.jmh;
        aRQ();
        AppMethodBeat.m2505o(126796);
    }

    public void computeScroll() {
        AppMethodBeat.m2504i(126797);
        if (this.f13683le == 0) {
            AppMethodBeat.m2505o(126797);
            return;
        }
        if (this.jlU.f710qN.computeScrollOffset()) {
            this.jmt = this.jlU.f710qN.getCurrY();
            aRQ();
            postInvalidate();
        }
        AppMethodBeat.m2505o(126797);
    }

    private void aRQ() {
        AppMethodBeat.m2504i(126798);
        this.jmr = (int) Math.floor((double) (((float) this.jmt) / ((float) this.f13683le)));
        this.jms = -(this.jmt - (this.jmr * this.f13683le));
        if (this.jmg != null) {
            if ((-this.jms) > this.f13683le / 2) {
                this.jmi = (this.jmr + 1) + (this.jlr / 2);
            } else {
                this.jmi = this.jmr + (this.jlr / 2);
            }
            this.jmi %= getOneRecycleSize();
            if (this.jmi < 0) {
                this.jmi += getOneRecycleSize();
            }
            this.jmh = this.jmi;
        }
        AppMethodBeat.m2505o(126798);
    }

    /* renamed from: fg */
    private void m43519fg(boolean z) {
        AppMethodBeat.m2504i(126799);
        aRR();
        aRS();
        if (z && (this.jmu == C8415j.INVALID_ID || this.jmv == C8415j.INVALID_ID)) {
            this.jmc.sendEmptyMessage(3);
        }
        AppMethodBeat.m2505o(126799);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(126800);
        super.onDraw(canvas);
        float f = 0.0f;
        for (int i = 0; i < this.jlr + 1; i++) {
            boolean z;
            float f2;
            float f3;
            float f4 = (float) (this.jms + (this.f13683le * i));
            int i2 = this.jmr + i;
            int oneRecycleSize = getOneRecycleSize();
            if (this.jlO && this.jlQ) {
                z = true;
            } else {
                z = false;
            }
            int k = YANumberPicker.m43524k(i2, oneRecycleSize, z);
            if (i == this.jlr / 2) {
                f = ((float) (this.f13683le + this.jms)) / ((float) this.f13683le);
                oneRecycleSize = YANumberPicker.m43502a(f, this.jlc, this.jld);
                f2 = (float) this.jlf;
                f2 += (((float) this.jlg) - f2) * f;
                f3 = this.jlK;
                f3 += (this.jlL - f3) * f;
            } else if (i == (this.jlr / 2) + 1) {
                oneRecycleSize = YANumberPicker.m43502a(1.0f - f, this.jlc, this.jld);
                f3 = (float) this.jlf;
                f2 = ((1.0f - f) * (((float) this.jlg) - f3)) + f3;
                f3 = 1.0f - f;
                float f5 = this.jlK;
                f3 = (f3 * (this.jlL - f5)) + f5;
            } else {
                oneRecycleSize = this.jlc;
                f2 = (float) this.jlf;
                f3 = this.jlK;
            }
            this.jlW.setColor(oneRecycleSize);
            this.jlW.setTextSize(f2);
            if (k >= 0 && k < getOneRecycleSize()) {
                CharSequence charSequence = this.jlY[this.jlu + k];
                if (this.jlG != null) {
                    charSequence = TextUtils.ellipsize(charSequence, this.jlW, (float) (getWidth() - (this.jln * 2)), getEllipsizeType());
                }
                canvas.drawText(charSequence.toString(), this.jmq, f3 + (f4 + ((float) (this.f13683le / 2))), this.jlW);
            } else if (!TextUtils.isEmpty(this.jlH)) {
                canvas.drawText(this.jlH, this.jmq, f3 + (f4 + ((float) (this.f13683le / 2))), this.jlW);
            }
        }
        if (this.jlN) {
            canvas.drawLine((float) (getPaddingLeft() + this.jlp), this.jmo, (float) ((this.aKu - getPaddingRight()) - this.jlq), this.jmo, this.jlV);
            canvas.drawLine((float) (getPaddingLeft() + this.jlp), this.jmp, (float) ((this.aKu - getPaddingRight()) - this.jlq), this.jmp, this.jlV);
        }
        if (!TextUtils.isEmpty(this.jlF)) {
            canvas.drawText(this.jlF, (this.jmq + ((float) ((this.jly + this.jli) / 2))) + ((float) this.jlk), ((this.jmo + this.jmp) / 2.0f) + this.jlM, this.jlX);
        }
        AppMethodBeat.m2505o(126800);
    }

    public void setEllipsizeType(String str) {
        int i = 0;
        AppMethodBeat.m2504i(126801);
        String[] strArr = new String[]{"end", "middle", "start"};
        while (i < 3) {
            if (strArr[i].equals(str)) {
                this.jlG = str;
                AppMethodBeat.m2505o(126801);
                return;
            }
            i++;
        }
        this.jlG = "end";
        AppMethodBeat.m2505o(126801);
    }

    private TruncateAt getEllipsizeType() {
        AppMethodBeat.m2504i(126802);
        String str = this.jlG;
        Object obj = -1;
        switch (str.hashCode()) {
            case -1074341483:
                if (str.equals("middle")) {
                    obj = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    obj = 2;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    obj = null;
                    break;
                }
                break;
        }
        TruncateAt truncateAt;
        switch (obj) {
            case null:
                truncateAt = TruncateAt.START;
                AppMethodBeat.m2505o(126802);
                return truncateAt;
            case 1:
                truncateAt = TruncateAt.MIDDLE;
                AppMethodBeat.m2505o(126802);
                return truncateAt;
            case 2:
                truncateAt = TruncateAt.END;
                AppMethodBeat.m2505o(126802);
                return truncateAt;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Illegal text ellipsize type.");
                AppMethodBeat.m2505o(126802);
                throw illegalArgumentException;
        }
    }

    private void aRR() {
        AppMethodBeat.m2504i(126803);
        float textSize = this.jlW.getTextSize();
        this.jlW.setTextSize((float) this.jlg);
        this.jly = YANumberPicker.m43504a(this.jlY, this.jlW);
        this.jlA = YANumberPicker.m43504a(this.jlZ, this.jlW);
        this.jlB = YANumberPicker.m43504a(this.jma, this.jlW);
        this.jlW.setTextSize((float) this.jlh);
        this.jlj = YANumberPicker.m43503a(this.jlI, this.jlW);
        this.jlW.setTextSize(textSize);
        AppMethodBeat.m2505o(126803);
    }

    /* renamed from: a */
    private static int m43504a(CharSequence[] charSequenceArr, Paint paint) {
        AppMethodBeat.m2504i(126804);
        if (charSequenceArr == null) {
            AppMethodBeat.m2505o(126804);
            return 0;
        }
        int i = 0;
        for (CharSequence charSequence : charSequenceArr) {
            if (charSequence != null) {
                i = Math.max(YANumberPicker.m43503a(charSequence, paint), i);
            }
        }
        AppMethodBeat.m2505o(126804);
        return i;
    }

    /* renamed from: a */
    private static int m43503a(CharSequence charSequence, Paint paint) {
        AppMethodBeat.m2504i(126805);
        if (TextUtils.isEmpty(charSequence)) {
            AppMethodBeat.m2505o(126805);
            return 0;
        }
        int measureText = (int) (paint.measureText(charSequence.toString()) + 0.5f);
        AppMethodBeat.m2505o(126805);
        return measureText;
    }

    private void aRS() {
        AppMethodBeat.m2504i(126806);
        float textSize = this.jlW.getTextSize();
        this.jlW.setTextSize((float) this.jlg);
        this.jlz = (int) (((double) (this.jlW.getFontMetrics().bottom - this.jlW.getFontMetrics().top)) + 0.5d);
        this.jlW.setTextSize(textSize);
        AppMethodBeat.m2505o(126806);
    }

    private void aRT() {
        AppMethodBeat.m2504i(126807);
        aRU();
        aRV();
        if (this.jlu == -1) {
            this.jlu = 0;
        }
        if (this.jlv == -1) {
            this.jlv = this.jlY.length - 1;
        }
        m43523j(this.jlu, this.jlv, false);
        AppMethodBeat.m2505o(126807);
    }

    private void aRU() {
        if (this.jlY == null) {
            this.jlY = new String[1];
            this.jlY[0] = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
    }

    private void aRV() {
        this.jlQ = this.jlY.length > this.jlr;
    }

    private void aRW() {
        AppMethodBeat.m2504i(126808);
        if (!(this.jlU == null || this.jlU.f710qN.isFinished())) {
            this.jlU.startScroll(0, this.jlU.f710qN.getCurrY(), 0, 0, 1);
            this.jlU.f710qN.abortAnimation();
            postInvalidate();
        }
        AppMethodBeat.m2505o(126808);
    }

    public final void aRX() {
        AppMethodBeat.m2504i(126809);
        aRW();
        if (this.jmb != null) {
            this.jmb.sendMessageDelayed(YANumberPicker.m43508b(1, 0, 0, null), 0);
        }
        AppMethodBeat.m2505o(126809);
    }

    /* renamed from: b */
    private static Message m43508b(int i, int i2, int i3, Object obj) {
        AppMethodBeat.m2504i(126810);
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = i2;
        obtain.arg2 = i3;
        obtain.obj = obj;
        AppMethodBeat.m2505o(126810);
        return obtain;
    }

    /* renamed from: e */
    private static int m43515e(Context context, float f) {
        AppMethodBeat.m2504i(126811);
        int i = (int) ((context.getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
        AppMethodBeat.m2505o(126811);
        return i;
    }

    /* renamed from: f */
    private static int m43517f(Context context, float f) {
        AppMethodBeat.m2504i(126812);
        int i = (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
        AppMethodBeat.m2505o(126812);
        return i;
    }

    /* renamed from: a */
    private static int m43502a(float f, int i, int i2) {
        int i3 = (i & WebView.NIGHT_MODE_COLOR) >>> 24;
        int i4 = (i & 16711680) >>> 16;
        int i5 = (i & 65280) >>> 8;
        int i6 = (i & 255) >>> 0;
        return (((((int) ((((float) (((WebView.NIGHT_MODE_COLOR & i2) >>> 24) - i3)) * f) + ((float) i3))) << 24) | (((int) ((((float) (((16711680 & i2) >>> 16) - i4)) * f) + ((float) i4))) << 16)) | (((int) ((((float) (((65280 & i2) >>> 8) - i5)) * f) + ((float) i5))) << 8)) | ((int) ((((float) (((i2 & 255) >>> 0) - i6)) * f) + ((float) i6)));
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(126763);
        this.jlU = C0539p.m1164a(context, null);
        this.jlD = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
        this.jlE = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (this.jlf == 0) {
            this.jlf = YANumberPicker.m43515e(context, 13.0f);
        }
        if (this.jlg == 0) {
            this.jlg = YANumberPicker.m43515e(context, 15.0f);
        }
        if (this.jlh == 0) {
            this.jlh = YANumberPicker.m43515e(context, 14.0f);
        }
        if (this.jlk == 0) {
            this.jlk = YANumberPicker.m43517f(context, 8.0f);
        }
        if (this.jll == 0) {
            this.jll = YANumberPicker.m43517f(context, 8.0f);
        }
        this.jlV.setColor(this.jlo);
        this.jlV.setAntiAlias(true);
        this.jlV.setStyle(Style.STROKE);
        this.jlV.setStrokeWidth((float) this.alw);
        this.jlW.setColor(this.jlc);
        this.jlW.setAntiAlias(true);
        this.jlW.setTextAlign(Align.CENTER);
        this.jlX.setColor(this.jle);
        this.jlX.setAntiAlias(true);
        this.jlX.setTextAlign(Align.CENTER);
        this.jlX.setTextSize((float) this.jlh);
        if (this.jlr % 2 == 0) {
            this.jlr++;
        }
        if (this.jlu == -1 || this.jlv == -1) {
            aRT();
        }
        aRN();
        AppMethodBeat.m2505o(126763);
    }

    public void setDisplayedValues(String[] strArr) {
        boolean z = true;
        AppMethodBeat.m2504i(126770);
        if (this.jmb != null) {
            this.jmb.removeMessages(1);
        }
        aRW();
        IllegalArgumentException illegalArgumentException;
        if (strArr == null) {
            illegalArgumentException = new IllegalArgumentException("newDisplayedValues should not be null.");
            AppMethodBeat.m2505o(126770);
            throw illegalArgumentException;
        } else if ((this.jlx - this.jlw) + 1 > strArr.length) {
            illegalArgumentException = new IllegalArgumentException("mMaxValue - mMinValue + 1 should not be greater than mDisplayedValues.length, now ((mMaxValue - mMinValue + 1) is " + ((this.jlx - this.jlw) + 1) + " newDisplayedValues.length is " + strArr.length + ", you need to set MaxValue and MinValue before setDisplayedValues(String[])");
            AppMethodBeat.m2505o(126770);
            throw illegalArgumentException;
        } else {
            this.jlY = strArr;
            aRV();
            m43519fg(true);
            this.jlC = this.jlu + 0;
            if (!(this.jlO && this.jlQ)) {
                z = false;
            }
            m43500M(0, z);
            postInvalidate();
            this.jmc.sendEmptyMessage(3);
            AppMethodBeat.m2505o(126770);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m43506a(YANumberPicker yANumberPicker, int i, int i2, Object obj) {
        AppMethodBeat.m2504i(126816);
        yANumberPicker.m43525qT(0);
        if (i != i2 && ((obj == null || !(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) && yANumberPicker.jme != null)) {
            yANumberPicker.jme.mo45198a(yANumberPicker, yANumberPicker.jlw + i2);
        }
        yANumberPicker.jlC = i2;
        if (yANumberPicker.jlR) {
            yANumberPicker.jlR = false;
            yANumberPicker.aRO();
        }
        AppMethodBeat.m2505o(126816);
    }
}
