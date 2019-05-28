package com.tencent.neattextview.textview.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.LruCache;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.C5780a.C5778a;
import com.tencent.neattextview.textview.layout.C5782a;
import com.tencent.neattextview.textview.layout.C7377c;
import com.tencent.neattextview.textview.layout.NeatLayout;
import com.tencent.neattextview.textview.p658b.C7376c;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import java.util.List;

public class NeatTextView extends View implements C5791a {
    private static final LruCache<String, C5790e> AkU = new LruCache(800);
    private static Handler AkV;
    private static final HandlerThread pfg;
    private C7377c AkB;
    public boolean AkW;
    private TextView AkX;
    private C5786a AkY = new C5786a(this, (byte) 0);
    private ColorStateList AkZ;
    private int Akm = 8388659;
    private ColorStateList Ala;
    private int Alb;
    private BufferType Alc = BufferType.NORMAL;
    private C7380b Ald;
    private boolean Ale = true;
    private C5787b Alf;
    private float Alg;
    private boolean Alh = true;
    private C5789d Ali;
    private C5782a Alj;
    /* renamed from: dg */
    private int f2012dg = 0;
    /* renamed from: dh */
    private int f2013dh = 0;
    /* renamed from: di */
    private int f2014di = BaseClientBuilder.API_PRIORITY_OTHER;
    /* renamed from: dj */
    private int f2015dj = BaseClientBuilder.API_PRIORITY_OTHER;
    /* renamed from: lP */
    private ColorStateList f2016lP;
    private CharSequence mText = "";
    private int nnY = BaseClientBuilder.API_PRIORITY_OTHER;
    /* renamed from: oz */
    private TextPaint f2017oz;
    /* renamed from: tf */
    private CharSequence f2018tf;
    private float yzE = 0.0f;
    private int yzv;
    private Factory yzx = Factory.getInstance();
    private TruncateAt yzy;

    /* renamed from: com.tencent.neattextview.textview.view.NeatTextView$a */
    class C5786a implements SpanWatcher {
        WeakReference<C7377c> All;

        private C5786a() {
        }

        /* synthetic */ C5786a(NeatTextView neatTextView, byte b) {
            this();
        }

        public final void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
            AppMethodBeat.m2504i(3272);
            m8694g(spannable);
            AppMethodBeat.m2505o(3272);
        }

        public final void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
            AppMethodBeat.m2504i(3273);
            m8694g(spannable);
            AppMethodBeat.m2505o(3273);
        }

        public final void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(3274);
            m8694g(spannable);
            AppMethodBeat.m2505o(3274);
        }

        /* renamed from: g */
        private void m8694g(Spannable spannable) {
            AppMethodBeat.m2504i(3275);
            if (NeatTextView.this.AkW) {
                NeatTextView.this.postInvalidate();
                AppMethodBeat.m2505o(3275);
            } else if (this.All == null) {
                AppMethodBeat.m2505o(3275);
            } else {
                C7377c c7377c = (C7377c) this.All.get();
                if (c7377c != null && c7377c.getText() == spannable) {
                    c7377c.mo15907an(spannable);
                    NeatTextView.this.postInvalidate();
                }
                AppMethodBeat.m2505o(3275);
            }
        }
    }

    /* renamed from: com.tencent.neattextview.textview.view.NeatTextView$b */
    public interface C5787b {
        /* renamed from: fi */
        boolean mo11868fi(View view);
    }

    /* renamed from: com.tencent.neattextview.textview.view.NeatTextView$c */
    public interface C5788c extends OnTouchListener {
    }

    /* renamed from: com.tencent.neattextview.textview.view.NeatTextView$d */
    static final class C5789d implements Runnable {
        float[] Alm;
        TextPaint eNB = new TextPaint();
        volatile boolean foa = false;
        String text;

        C5789d(String str, TextPaint textPaint) {
            AppMethodBeat.m2504i(3276);
            this.eNB.set(textPaint);
            this.text = str;
            AppMethodBeat.m2505o(3276);
        }

        public final void run() {
            AppMethodBeat.m2504i(3277);
            this.Alm = new float[this.text.length()];
            this.eNB.getTextWidths(this.text, this.Alm);
            this.foa = true;
            AppMethodBeat.m2505o(3277);
        }
    }

    /* renamed from: com.tencent.neattextview.textview.view.NeatTextView$e */
    static class C5790e {
        public boolean AkW;
        public float[] Alm;

        public C5790e(boolean z, float[] fArr) {
            this.AkW = z;
            this.Alm = fArr;
        }
    }

    /* renamed from: com.tencent.neattextview.textview.view.NeatTextView$1 */
    class C73791 implements C5782a {
        C73791() {
        }

        public final int getLineBaseline(int i) {
            AppMethodBeat.m2504i(3259);
            int lineBaseline;
            if (NeatTextView.this.AkW) {
                lineBaseline = NeatTextView.this.getWrappedTextView().getLayout().getLineBaseline(i);
                AppMethodBeat.m2505o(3259);
                return lineBaseline;
            } else if (NeatTextView.this.AkB == null) {
                AppMethodBeat.m2505o(3259);
                return -1;
            } else {
                lineBaseline = NeatTextView.this.AkB.getLineBaseline(i);
                AppMethodBeat.m2505o(3259);
                return lineBaseline;
            }
        }

        public final int getLineTop(int i) {
            AppMethodBeat.m2504i(3260);
            int lineTop;
            if (NeatTextView.this.AkW) {
                lineTop = NeatTextView.this.getWrappedTextView().getLayout().getLineTop(i);
                AppMethodBeat.m2505o(3260);
                return lineTop;
            } else if (NeatTextView.this.AkB == null) {
                AppMethodBeat.m2505o(3260);
                return -1;
            } else {
                lineTop = NeatTextView.this.AkB.getLineTop(i);
                AppMethodBeat.m2505o(3260);
                return lineTop;
            }
        }

        public final int getLineBottom(int i) {
            AppMethodBeat.m2504i(3261);
            int lineBottom;
            if (NeatTextView.this.AkW) {
                lineBottom = NeatTextView.this.getWrappedTextView().getLayout().getLineBottom(i);
                AppMethodBeat.m2505o(3261);
                return lineBottom;
            } else if (NeatTextView.this.AkB == null) {
                AppMethodBeat.m2505o(3261);
                return -1;
            } else {
                lineBottom = NeatTextView.this.AkB.getLineBottom(i);
                AppMethodBeat.m2505o(3261);
                return lineBottom;
            }
        }

        public final int getLineForOffset(int i) {
            AppMethodBeat.m2504i(3262);
            int lineForOffset;
            if (NeatTextView.this.AkW) {
                lineForOffset = NeatTextView.this.getWrappedTextView().getLayout().getLineForOffset(i);
                AppMethodBeat.m2505o(3262);
                return lineForOffset;
            } else if (NeatTextView.this.AkB == null) {
                AppMethodBeat.m2505o(3262);
                return -1;
            } else {
                lineForOffset = NeatTextView.this.AkB.getLineForOffset(i);
                AppMethodBeat.m2505o(3262);
                return lineForOffset;
            }
        }

        public final float getPrimaryHorizontal(int i) {
            AppMethodBeat.m2504i(3263);
            float primaryHorizontal;
            if (NeatTextView.this.AkW) {
                TextView wrappedTextView = NeatTextView.this.getWrappedTextView();
                if (!(wrappedTextView == null || wrappedTextView.getLayout() == null)) {
                    primaryHorizontal = wrappedTextView.getLayout().getPrimaryHorizontal(i);
                    AppMethodBeat.m2505o(3263);
                    return primaryHorizontal;
                }
            } else if (NeatTextView.this.AkB != null) {
                primaryHorizontal = NeatTextView.this.AkB.getPrimaryHorizontal(i);
                AppMethodBeat.m2505o(3263);
                return primaryHorizontal;
            }
            AppMethodBeat.m2505o(3263);
            return -1.0f;
        }

        public final int getOffsetForHorizontal(int i, float f) {
            AppMethodBeat.m2504i(3264);
            int offsetForHorizontal;
            if (NeatTextView.this.AkW) {
                offsetForHorizontal = NeatTextView.this.getWrappedTextView().getLayout().getOffsetForHorizontal(i, f);
                AppMethodBeat.m2505o(3264);
                return offsetForHorizontal;
            } else if (NeatTextView.this.AkB == null) {
                AppMethodBeat.m2505o(3264);
                return -1;
            } else {
                offsetForHorizontal = NeatTextView.this.AkB.getOffsetForHorizontal(i, f);
                AppMethodBeat.m2505o(3264);
                return offsetForHorizontal;
            }
        }

        public final float getLineWidth(int i) {
            AppMethodBeat.m2504i(3265);
            float lineWidth;
            if (NeatTextView.this.AkW) {
                lineWidth = NeatTextView.this.getWrappedTextView().getLayout().getLineWidth(i);
                AppMethodBeat.m2505o(3265);
                return lineWidth;
            } else if (NeatTextView.this.AkB == null) {
                AppMethodBeat.m2505o(3265);
                return -1.0f;
            } else {
                lineWidth = NeatTextView.this.AkB.getLineWidth(i);
                AppMethodBeat.m2505o(3265);
                return lineWidth;
            }
        }

        public final int getLineStart(int i) {
            AppMethodBeat.m2504i(3266);
            int lineStart;
            if (NeatTextView.this.AkW) {
                lineStart = NeatTextView.this.getWrappedTextView().getLayout().getLineStart(i);
                AppMethodBeat.m2505o(3266);
                return lineStart;
            } else if (NeatTextView.this.AkB == null) {
                AppMethodBeat.m2505o(3266);
                return -1;
            } else {
                lineStart = NeatTextView.this.AkB.getLineStart(i);
                AppMethodBeat.m2505o(3266);
                return lineStart;
            }
        }

        public final int getLineForVertical(int i) {
            AppMethodBeat.m2504i(3267);
            int lineForVertical;
            if (NeatTextView.this.AkW) {
                lineForVertical = NeatTextView.this.getWrappedTextView().getLayout().getLineForVertical(i);
                AppMethodBeat.m2505o(3267);
                return lineForVertical;
            } else if (NeatTextView.this.AkB == null) {
                AppMethodBeat.m2505o(3267);
                return -1;
            } else {
                lineForVertical = NeatTextView.this.AkB.getLineForVertical(i);
                AppMethodBeat.m2505o(3267);
                return lineForVertical;
            }
        }

        public final float getLineRight(int i) {
            AppMethodBeat.m2504i(3268);
            float lineRight;
            if (NeatTextView.this.AkW) {
                lineRight = NeatTextView.this.getWrappedTextView().getLayout().getLineRight(i);
                AppMethodBeat.m2505o(3268);
                return lineRight;
            } else if (NeatTextView.this.AkB == null) {
                AppMethodBeat.m2505o(3268);
                return -1.0f;
            } else {
                lineRight = NeatTextView.this.AkB.getLineRight(i);
                AppMethodBeat.m2505o(3268);
                return lineRight;
            }
        }

        public final int dPe() {
            AppMethodBeat.m2504i(3269);
            int lineCount;
            if (NeatTextView.this.AkW) {
                lineCount = NeatTextView.this.getWrappedTextView().getLayout().getLineCount();
                AppMethodBeat.m2505o(3269);
                return lineCount;
            } else if (NeatTextView.this.AkB == null) {
                AppMethodBeat.m2505o(3269);
                return -1;
            } else {
                lineCount = NeatTextView.this.AkB.dPe();
                AppMethodBeat.m2505o(3269);
                return lineCount;
            }
        }

        /* renamed from: hQ */
        public final int mo11847hQ(int i, int i2) {
            AppMethodBeat.m2504i(3270);
            int offsetForHorizontal;
            if (NeatTextView.this.AkW) {
                int paddingLeft = i - NeatTextView.this.getPaddingLeft();
                int paddingTop = i2 - NeatTextView.this.getPaddingTop();
                Layout layout = NeatTextView.this.getWrappedTextView().getLayout();
                if (layout != null) {
                    offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(paddingTop), (float) paddingLeft);
                    if (((int) layout.getPrimaryHorizontal(offsetForHorizontal)) > paddingLeft) {
                        offsetForHorizontal = layout.getOffsetToLeftOf(offsetForHorizontal);
                        AppMethodBeat.m2505o(3270);
                        return offsetForHorizontal;
                    }
                    AppMethodBeat.m2505o(3270);
                    return offsetForHorizontal;
                }
                AppMethodBeat.m2505o(3270);
                return -1;
            } else if (NeatTextView.this.AkB == null) {
                AppMethodBeat.m2505o(3270);
                return -1;
            } else {
                offsetForHorizontal = NeatTextView.this.AkB.mo11847hQ(i, i2);
                AppMethodBeat.m2505o(3270);
                return offsetForHorizontal;
            }
        }

        public final List<C7376c> dPf() {
            AppMethodBeat.m2504i(3271);
            if (NeatTextView.this.AkW) {
                AppMethodBeat.m2505o(3271);
                return null;
            } else if (NeatTextView.this.AkB == null) {
                AppMethodBeat.m2505o(3271);
                return null;
            } else {
                List<C7376c> dPf = NeatTextView.this.AkB.dPf();
                AppMethodBeat.m2505o(3271);
                return dPf;
            }
        }
    }

    static {
        AppMethodBeat.m2504i(3319);
        HandlerThread handlerThread = new HandlerThread("PreMeasuredThread", -8);
        pfg = handlerThread;
        handlerThread.start();
        Looper looper = pfg.getLooper();
        if (looper != null) {
            AkV = new Handler(looper);
        }
        AppMethodBeat.m2505o(3319);
    }

    public NeatTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(3278);
        m12607c(context, attributeSet, 0);
        AppMethodBeat.m2505o(3278);
    }

    public NeatTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(3279);
        m12607c(context, attributeSet, i);
        AppMethodBeat.m2505o(3279);
    }

    /* renamed from: c */
    private void m12607c(Context context, AttributeSet attributeSet, int i) {
        AppMethodBeat.m2504i(3280);
        this.Ald = new C7380b(getContext(), this);
        TextView textView = new TextView(context);
        textView.setClickable(true);
        textView.setFocusable(true);
        this.AkX = textView;
        this.f2017oz = getWrappedTextView().getPaint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C5778a.NeatTextView, i, 0);
        int i2 = 15;
        int i3 = WebView.NIGHT_MODE_COLOR;
        int i4 = -7829368;
        int i5 = -16776961;
        int i6 = -1;
        CharSequence charSequence = null;
        try {
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = obtainStyledAttributes.getIndex(i7);
                if (index == 0) {
                    i2 = obtainStyledAttributes.getDimensionPixelSize(index, 15);
                } else if (index == 3) {
                    i3 = obtainStyledAttributes.getColor(index, WebView.NIGHT_MODE_COLOR);
                } else if (index == 23) {
                    if (obtainStyledAttributes.getBoolean(index, false)) {
                        index = 1;
                    } else {
                        index = this.nnY;
                    }
                    setMaxLines(index);
                } else if (index == 20) {
                    setLines(obtainStyledAttributes.getInt(index, BaseClientBuilder.API_PRIORITY_OTHER));
                } else if (index == 7) {
                    setTextGravity(obtainStyledAttributes.getInt(index, 16));
                } else if (index == 13) {
                    setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(index, this.f2014di));
                } else if (index == 24) {
                    setSpacingAdd(obtainStyledAttributes.getDimensionPixelSize(index, (int) this.yzE));
                } else if (index == 15) {
                    setMinWidth(obtainStyledAttributes.getDimensionPixelSize(index, this.f2012dg));
                } else if (index == 16) {
                    setMinHeight(obtainStyledAttributes.getDimensionPixelSize(index, this.f2013dh));
                } else if (index == 14) {
                    setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(index, this.f2015dj));
                } else if (index == 19) {
                    setMaxLines(obtainStyledAttributes.getInt(index, BaseClientBuilder.API_PRIORITY_OTHER));
                } else if (index == 17) {
                    charSequence = obtainStyledAttributes.getString(index);
                } else if (index == 22) {
                    setWidth(obtainStyledAttributes.getDimensionPixelSize(index, -1));
                } else if (index == 21) {
                    setHeight(obtainStyledAttributes.getDimensionPixelSize(index, -1));
                } else if (index == 18) {
                    setHint(obtainStyledAttributes.getText(index));
                } else if (index == 4) {
                    i4 = obtainStyledAttributes.getColor(index, -7829368);
                } else if (index == 5) {
                    i5 = obtainStyledAttributes.getColor(index, -16776961);
                } else if (index == 6) {
                    i6 = obtainStyledAttributes.getInt(index, i6);
                } else if (index == 26) {
                    this.Alh = obtainStyledAttributes.getBoolean(index, true);
                }
            }
            obtainStyledAttributes.recycle();
            setTextColor(i3);
            setRawTextSize((float) i2);
            setLinkTextColor(i5);
            setHintTextColor(i4);
            switch (i6) {
                case 1:
                    setEllipsize(TruncateAt.START);
                    break;
                case 2:
                    setEllipsize(TruncateAt.MIDDLE);
                    break;
                case 3:
                    setEllipsize(TruncateAt.END);
                    break;
            }
            if (!TextUtils.isEmpty(charSequence)) {
                mo15921ah(charSequence);
            }
            getWrappedTextView().setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
            AppMethodBeat.m2505o(3280);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            AppMethodBeat.m2505o(3280);
        }
    }

    public C5787b getOnDoubleClickListener() {
        return this.Alf;
    }

    public void setOnDoubleClickListener(C5787b c5787b) {
        this.Alf = c5787b;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(3281);
        if (this.Ald == null || !this.Ald.onTouch(this, motionEvent)) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.m2505o(3281);
            return onTouchEvent;
        }
        AppMethodBeat.m2505o(3281);
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(3282);
        if (this.AkW) {
            getWrappedTextView().measure(i, i2);
            setMeasuredDimension(getWrappedTextView().getMeasuredWidth(), getWrappedTextView().getMeasuredHeight());
            AppMethodBeat.m2505o(3282);
            return;
        }
        int i3;
        int i4;
        float[] fArr;
        Object obj;
        CharSequence charSequence;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (size <= 0 && mode2 == 0) {
            size = getResources().getDisplayMetrics().widthPixels;
        }
        if (size2 <= 0 && mode2 == 0) {
            size2 = BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (this.f2014di <= 0 || this.f2014di >= size) {
            i3 = size;
        } else {
            i3 = this.f2014di;
        }
        if (this.f2015dj <= 0 || this.f2015dj >= size2) {
            i4 = size2;
        } else {
            i4 = this.f2015dj;
        }
        float paddingLeft = (float) ((i3 - getPaddingLeft()) - getPaddingRight());
        float paddingTop = (float) ((i4 - getPaddingTop()) - getPaddingBottom());
        CharSequence charSequence2 = TextUtils.isEmpty(this.mText) ? this.f2018tf : this.mText;
        if (TextUtils.isEmpty(charSequence2)) {
            fArr = null;
            obj = null;
            Object charSequence3 = "";
        } else {
            C5790e c5790e = (C5790e) AkU.get(atH(charSequence2.toString()));
            if (c5790e != null) {
                fArr = c5790e.Alm;
                obj = null;
                charSequence3 = charSequence2;
            } else {
                if (this.Ali != null) {
                    C5789d c5789d = this.Ali;
                    if (this.f2017oz.getTextSize() == c5789d.eNB.getTextSize() && c5789d.foa) {
                        fArr = c5789d.Alm;
                    } else {
                        fArr = null;
                    }
                } else {
                    fArr = null;
                }
                int obj2 = 1;
                charSequence3 = charSequence2;
            }
        }
        this.AkB = new NeatLayout(charSequence3, fArr);
        this.AkB.mo15904a(getPaint(), paddingLeft, paddingTop, (float) getPaddingLeft(), (float) getPaddingTop(), this.yzE, this.nnY, this.yzy, this.Alg, this.Alh, this.Akm);
        if (obj2 != null) {
            AkU.put(atH(this.AkB.dPn()), new C5790e(this.AkW, this.AkB.dPg()));
        }
        this.AkY.All = new WeakReference(this.AkB);
        fArr = this.AkB.dPo();
        if (mode != 1073741824) {
            i3 = (int) Math.min((fArr[0] + ((float) getPaddingLeft())) + ((float) getPaddingRight()), (float) this.f2014di);
        }
        if (mode2 != 1073741824) {
            i4 = (int) Math.min((fArr[1] + ((float) getPaddingTop())) + ((float) getPaddingBottom()), (float) this.f2015dj);
        }
        setMeasuredDimension(Math.max(i3, this.f2012dg), Math.max(i4, this.f2013dh));
        AppMethodBeat.m2505o(3282);
    }

    /* renamed from: QV */
    public final C5782a mo15918QV(int i) {
        C5782a c5782a;
        AppMethodBeat.m2504i(3283);
        if (TextUtils.isEmpty(this.mText)) {
            c5782a = null;
        } else {
            c5782a = new NeatLayout(this.mText, null);
            c5782a.mo15904a(getPaint(), (float) i, 2.14748365E9f, (float) getPaddingLeft(), (float) getPaddingTop(), this.yzE, this.nnY, this.yzy, this.Alg, this.Alh, this.Akm);
        }
        AppMethodBeat.m2505o(3283);
        return c5782a;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(3284);
        super.onDraw(canvas);
        int i = this.yzv;
        if (!(TextUtils.isEmpty(this.f2018tf) || !TextUtils.isEmpty(this.mText) || this.AkZ == null)) {
            i = this.Alb;
        }
        this.f2017oz.setColor(i);
        this.f2017oz.drawableState = getDrawableState();
        if (this.AkW) {
            canvas.save();
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            Layout layout = getWrappedTextView().getLayout();
            if (layout != null) {
                layout.draw(canvas);
            }
            canvas.restore();
            AppMethodBeat.m2505o(3284);
            return;
        }
        if (this.AkB != null) {
            if (this.AkB.getTextPaint() != null) {
                this.AkB.getTextPaint().set(this.f2017oz);
            }
            this.AkB.mo15903a(canvas, (float) getPaddingLeft(), getVerticalOffset());
        }
        AppMethodBeat.m2505o(3284);
    }

    public TextView getWrappedTextView() {
        return this.AkX;
    }

    public final CharSequence dPr() {
        return this.mText == null ? "" : this.mText;
    }

    /* renamed from: ah */
    public void mo15921ah(CharSequence charSequence) {
        AppMethodBeat.m2504i(3285);
        mo15920a(charSequence, BufferType.NORMAL);
        AppMethodBeat.m2505o(3285);
    }

    /* renamed from: a */
    public void mo15920a(CharSequence charSequence, BufferType bufferType) {
        boolean z = true;
        AppMethodBeat.m2504i(3286);
        this.Alc = bufferType;
        if (charSequence == null) {
            charSequence = "";
        }
        if (bufferType == BufferType.NORMAL) {
            charSequence = TextUtils.stringOrSpannedString(charSequence);
        } else if (bufferType == BufferType.SPANNABLE) {
            charSequence = this.yzx.newSpannable(charSequence);
        }
        this.mText = charSequence;
        if (dKA()) {
            boolean z2;
            String charSequence2 = charSequence.toString();
            C5790e c5790e = (C5790e) AkU.get(atH(charSequence2));
            if (c5790e == null) {
                z2 = !charSequence2.matches("^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$");
                AkU.put(atH(charSequence2), new C5790e(z2, null));
            } else {
                z2 = c5790e.AkW;
            }
            if (!z2) {
                z = false;
            }
        }
        this.AkW = z;
        if (this.AkW) {
            if (getLayoutParams() != null) {
                getWrappedTextView().setLayoutParams(getLayoutParams());
            }
            getWrappedTextView().setText(charSequence, bufferType);
            this.mText = getWrappedTextView().getText();
            requestLayout();
            invalidate();
        } else {
            dPs();
        }
        if (this.mText instanceof Spannable) {
            ((Spannable) this.mText).setSpan(this.AkY, 0, charSequence.length(), 18);
        }
        AppMethodBeat.m2505o(3286);
    }

    public float getVerticalOffset() {
        AppMethodBeat.m2504i(3287);
        float paddingTop;
        if ((this.Akm & 112) == 48 || this.AkB == null) {
            paddingTop = (float) getPaddingTop();
            AppMethodBeat.m2505o(3287);
            return paddingTop;
        }
        paddingTop = (((float) getMeasuredHeight()) - this.AkB.dPo()[1]) / 2.0f;
        AppMethodBeat.m2505o(3287);
        return paddingTop;
    }

    public float getHorizontalOffset() {
        AppMethodBeat.m2504i(3288);
        float paddingLeft;
        if ((this.Akm & 7) == 3 || this.AkB == null) {
            paddingLeft = (float) getPaddingLeft();
            AppMethodBeat.m2505o(3288);
            return paddingLeft;
        }
        paddingLeft = (((float) getMeasuredWidth()) - this.AkB.dPo()[0]) / 2.0f;
        AppMethodBeat.m2505o(3288);
        return paddingLeft;
    }

    public void setEllipsize(TruncateAt truncateAt) {
        AppMethodBeat.m2504i(3289);
        if (this.yzy != truncateAt) {
            this.yzy = truncateAt;
            if (this.AkB != null) {
                this.AkB = null;
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.m2505o(3289);
    }

    /* renamed from: a */
    public final void mo15919a(TruncateAt truncateAt, float f) {
        AppMethodBeat.m2504i(3290);
        this.Alg = f;
        setEllipsize(truncateAt);
        AppMethodBeat.m2505o(3290);
    }

    public final boolean dPq() {
        return this.AkW;
    }

    public int getTextGravity() {
        return this.Akm;
    }

    public void setTextGravity(int i) {
        int i2;
        AppMethodBeat.m2504i(3291);
        getWrappedTextView().setGravity(i);
        if ((8388615 & i) == 0) {
            i2 = 8388611 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 112) == 0) {
            i2 |= 48;
        }
        this.Akm = i2;
        if (i2 != this.Akm) {
            invalidate();
        }
        AppMethodBeat.m2505o(3291);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(3292);
        if (!(i == getPaddingLeft() && i3 == getPaddingRight() && i2 == getPaddingTop() && i4 == getPaddingBottom())) {
            this.AkB = null;
        }
        super.setPadding(i, i2, i3, i4);
        getWrappedTextView().setPadding(i, i2, i3, i4);
        invalidate();
        AppMethodBeat.m2505o(3292);
    }

    public TextPaint getPaint() {
        return this.f2017oz;
    }

    public int getLineCount() {
        AppMethodBeat.m2504i(3293);
        if (this.AkB != null) {
            int size = this.AkB.Akg.size();
            AppMethodBeat.m2505o(3293);
            return size;
        }
        AppMethodBeat.m2505o(3293);
        return 0;
    }

    public CharSequence getHint() {
        return this.f2018tf;
    }

    public final void setHint(int i) {
        AppMethodBeat.m2504i(3294);
        setHint(getContext().getResources().getText(i));
        AppMethodBeat.m2505o(3294);
    }

    public final void setHint(CharSequence charSequence) {
        AppMethodBeat.m2504i(3295);
        this.f2018tf = TextUtils.stringOrSpannedString(charSequence);
        getWrappedTextView().setHint(this.f2018tf);
        if (TextUtils.isEmpty(this.mText)) {
            dPs();
        }
        AppMethodBeat.m2505o(3295);
    }

    public boolean dKA() {
        return this.Ale;
    }

    public void setNeatEnable(boolean z) {
        this.Ale = z;
    }

    public void setSmartLetterEnable(boolean z) {
        this.Alh = z;
    }

    public void setWidth(int i) {
        AppMethodBeat.m2504i(3296);
        this.f2014di = i;
        getWrappedTextView().setMaxWidth(i);
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(3296);
    }

    public void setHeight(int i) {
        AppMethodBeat.m2504i(3297);
        this.f2015dj = i;
        getWrappedTextView().setMaxHeight(i);
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(3297);
    }

    public void setMinHeight(int i) {
        AppMethodBeat.m2504i(3298);
        this.f2013dh = i;
        getWrappedTextView().setMinHeight(i);
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(3298);
    }

    public void setMaxHeight(int i) {
        AppMethodBeat.m2504i(3299);
        this.f2015dj = i;
        getWrappedTextView().setMaxHeight(i);
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(3299);
    }

    public void setMaxWidth(int i) {
        AppMethodBeat.m2504i(3300);
        this.f2014di = i;
        getWrappedTextView().setMaxWidth(i);
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(3300);
    }

    public void setSpacingAdd(int i) {
        AppMethodBeat.m2504i(3301);
        this.yzE = (float) i;
        getWrappedTextView().setLineSpacing((float) i, 1.0f);
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(3301);
    }

    public void setMinWidth(int i) {
        AppMethodBeat.m2504i(3302);
        this.f2012dg = i;
        getWrappedTextView().setMinWidth(i);
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(3302);
    }

    public void setMaxLines(int i) {
        AppMethodBeat.m2504i(3303);
        this.nnY = i;
        getWrappedTextView().setMaxLines(i);
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(3303);
    }

    public void setLines(int i) {
        AppMethodBeat.m2504i(3304);
        this.nnY = i;
        getWrappedTextView().setLines(i);
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(3304);
    }

    public void setTextColor(int i) {
        AppMethodBeat.m2504i(3305);
        this.f2016lP = ColorStateList.valueOf(i);
        getWrappedTextView().setTextColor(i);
        updateTextColors();
        AppMethodBeat.m2505o(3305);
    }

    public final void setLinkTextColor(int i) {
        AppMethodBeat.m2504i(3306);
        this.Ala = ColorStateList.valueOf(i);
        updateTextColors();
        AppMethodBeat.m2505o(3306);
    }

    public final void setHintTextColor(int i) {
        AppMethodBeat.m2504i(3307);
        this.AkZ = ColorStateList.valueOf(i);
        getWrappedTextView().setHintTextColor(i);
        updateTextColors();
        AppMethodBeat.m2505o(3307);
    }

    public final int getCurrentHintTextColor() {
        return this.AkZ != null ? this.Alb : this.yzv;
    }

    public final int getCurrentTextColor() {
        return this.yzv;
    }

    private String atH(String str) {
        AppMethodBeat.m2504i(3308);
        String str2 = str + "#" + this.f2017oz.getTextSize();
        AppMethodBeat.m2505o(3308);
        return str2;
    }

    private void dPs() {
        AppMethodBeat.m2504i(3309);
        this.AkB = null;
        if (AkV != null) {
            Handler handler;
            C5789d c5789d;
            if (this.mText == null && this.f2018tf != null) {
                handler = AkV;
                c5789d = new C5789d(this.f2018tf.toString(), this.f2017oz);
                this.Ali = c5789d;
                handler.post(c5789d);
            } else if (this.mText != null) {
                handler = AkV;
                c5789d = new C5789d(this.mText.toString(), this.f2017oz);
                this.Ali = c5789d;
                handler.post(c5789d);
            } else {
                AppMethodBeat.m2505o(3309);
                return;
            }
        }
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(3309);
    }

    private void updateTextColors() {
        AppMethodBeat.m2504i(3310);
        int colorForState = this.f2016lP.getColorForState(getDrawableState(), 0);
        if (colorForState != this.yzv) {
            this.yzv = colorForState;
            colorForState = 1;
        } else {
            colorForState = 0;
        }
        if (this.Ala != null) {
            int colorForState2 = this.Ala.getColorForState(getDrawableState(), 0);
            if (colorForState2 != this.f2017oz.linkColor) {
                this.f2017oz.linkColor = colorForState2;
                colorForState = 1;
            }
        }
        if (this.AkZ != null) {
            int colorForState3 = this.AkZ.getColorForState(getDrawableState(), 0);
            if (colorForState3 != this.Alb) {
                this.Alb = colorForState3;
                if (this.mText == null || this.mText.length() == 0) {
                    colorForState = 1;
                }
            }
        }
        if (colorForState != 0) {
            invalidate();
        }
        AppMethodBeat.m2505o(3310);
    }

    public float getTextSize() {
        AppMethodBeat.m2504i(3311);
        float textSize = getPaint().getTextSize();
        AppMethodBeat.m2505o(3311);
        return textSize;
    }

    public void setTextSize(float f) {
        AppMethodBeat.m2504i(3312);
        setTextSize(2, f);
        AppMethodBeat.m2505o(3312);
    }

    public final void setTextSize(int i, float f) {
        Resources system;
        AppMethodBeat.m2504i(3313);
        Context context = getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        setRawTextSize(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        AppMethodBeat.m2505o(3313);
    }

    private void setRawTextSize(float f) {
        AppMethodBeat.m2504i(3314);
        if (f != this.f2017oz.getTextSize()) {
            this.f2017oz.setTextSize(f);
            if (this.AkB != null) {
                dPs();
                requestLayout();
                invalidate();
            }
        }
        AppMethodBeat.m2505o(3314);
    }

    public void invalidate() {
        AppMethodBeat.m2504i(3315);
        super.invalidate();
        AppMethodBeat.m2505o(3315);
    }

    public void postInvalidate() {
        AppMethodBeat.m2504i(3316);
        super.postInvalidate();
        AppMethodBeat.m2505o(3316);
    }

    public C5782a getLayout() {
        AppMethodBeat.m2504i(3317);
        C5782a c5782a;
        if (this.Alj != null) {
            c5782a = this.Alj;
            AppMethodBeat.m2505o(3317);
            return c5782a;
        }
        c5782a = new C73791();
        this.Alj = c5782a;
        AppMethodBeat.m2505o(3317);
        return c5782a;
    }

    public int getLineHeight() {
        AppMethodBeat.m2504i(3318);
        int round = Math.round(((float) this.f2017oz.getFontMetricsInt(null)) + this.yzE);
        AppMethodBeat.m2505o(3318);
        return round;
    }
}
