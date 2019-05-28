package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.support.p057v4.widget.C8415j;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.QTextView */
public class QTextView extends View {
    private static HashMap<String, C3969a> rmt = new HashMap();
    private Context context;
    private String mText = "";
    private int nnY;
    /* renamed from: oz */
    private TextPaint f16182oz;
    private int rmm;
    private String rmn;
    private String rmo;
    private boolean rmp;
    private int rmq;
    private boolean rmr;
    boolean rms;
    private C3969a rmu;
    private C3969a rmv;
    int rmw = 0;
    private int textSize = -1;

    /* renamed from: com.tencent.mm.plugin.sns.ui.QTextView$a */
    static class C3969a {
        private static HashMap<String, Integer> rmC = new HashMap();
        private String key = "";
        float rmA;
        float rmB;
        private int rmw = 0;
        boolean rmx = false;
        ArrayList<int[]> rmy = new ArrayList();
        float rmz;

        public C3969a() {
            AppMethodBeat.m2504i(38525);
            AppMethodBeat.m2505o(38525);
        }

        /* renamed from: a */
        public final int mo8760a(String str, int i, TextPaint textPaint) {
            AppMethodBeat.m2504i(38526);
            int a = mo8761a(str, null, null, -1, i, textPaint);
            AppMethodBeat.m2505o(38526);
            return a;
        }

        static {
            AppMethodBeat.m2504i(38528);
            AppMethodBeat.m2505o(38528);
        }

        /* renamed from: a */
        public final int mo8761a(String str, String str2, String str3, int i, int i2, TextPaint textPaint) {
            AppMethodBeat.m2504i(38527);
            String str4 = str + str2 + str3 + i + i2;
            int i3;
            if (str4.equals(this.key)) {
                i3 = this.rmw;
                AppMethodBeat.m2505o(38527);
                return i3;
            }
            this.key = str4;
            this.rmy.clear();
            this.rmx = false;
            this.rmz = 0.0f;
            this.rmA = 0.0f;
            this.rmB = 0.0f;
            if (i2 == -1) {
                this.rmy.add(new int[]{0, str.length()});
                this.rmw = (int) (textPaint.measureText(str) + 0.5f);
                i3 = this.rmw;
                AppMethodBeat.m2505o(38527);
                return i3;
            }
            if (str2 != null) {
                this.rmA = textPaint.measureText(str2);
            }
            if (str3 != null) {
                this.rmB = textPaint.measureText(str3);
            }
            int i4 = -1;
            float f = 0.0f;
            Object obj = 1;
            i3 = 0;
            while (i3 < str.length()) {
                if (i4 == -1) {
                    i4 = i3;
                }
                if (this.rmy.size() == i) {
                    this.rmx = true;
                    break;
                }
                float measureText = textPaint.measureText(str.charAt(i3));
                Object obj2 = null;
                if (str.charAt(i3) == 10) {
                    obj2 = 1;
                    this.rmy.add(new int[]{i4, i3 - 1});
                } else if (f + measureText >= ((float) i2)) {
                    obj2 = 1;
                    if (str.charAt(i3) == ' ' || obj == null) {
                        i3--;
                        this.rmy.add(new int[]{i4, i3});
                    } else {
                        while (str.charAt(i3) != ' ') {
                            i3--;
                            if (i3 == 0) {
                                break;
                            }
                        }
                        this.rmy.add(new int[]{i4, i3});
                    }
                }
                if (obj2 != null) {
                    i4 = -1;
                    f = 0.0f;
                    if (this.rmy.size() == i - 1) {
                        i2 = (int) (((float) i2) - (this.rmA + this.rmB));
                        obj = null;
                    }
                } else {
                    f += measureText;
                    if (i3 == str.length() - 1) {
                        this.rmy.add(new int[]{i4, i3});
                    }
                }
                i3++;
            }
            if (this.rmx) {
                int[] iArr = (int[]) this.rmy.get(this.rmy.size() - 1);
                this.rmz = textPaint.measureText(str.substring(iArr[0], iArr[1] + 1));
            }
            if (this.rmy.size() == 0) {
                this.rmw = 0;
                i3 = this.rmw;
                AppMethodBeat.m2505o(38527);
                return i3;
            } else if (this.rmy.size() == 1) {
                this.rmw = (int) (textPaint.measureText(str) + 0.5f);
                i3 = this.rmw;
                AppMethodBeat.m2505o(38527);
                return i3;
            } else {
                this.rmw = i2;
                i3 = this.rmw;
                AppMethodBeat.m2505o(38527);
                return i3;
            }
        }
    }

    static {
        AppMethodBeat.m2504i(38538);
        AppMethodBeat.m2505o(38538);
    }

    public QTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(38529);
        this.context = context;
        init();
        AppMethodBeat.m2505o(38529);
    }

    public QTextView(Context context) {
        super(context);
        AppMethodBeat.m2504i(38530);
        this.context = context;
        init();
        AppMethodBeat.m2505o(38530);
    }

    private void init() {
        AppMethodBeat.m2504i(38531);
        this.rms = false;
        this.rmp = true;
        this.rmr = false;
        this.nnY = -1;
        this.rmn = "...";
        this.rmo = "";
        this.rmq = -16776961;
        this.rmu = new C3969a();
        this.rmv = new C3969a();
        this.f16182oz = new TextPaint();
        this.f16182oz.setAntiAlias(true);
        if (this.textSize == -1) {
            this.textSize = C4977b.m7371b(this.context, 12.0f);
            this.f16182oz.setTextSize((float) this.textSize);
        } else {
            this.f16182oz.setTextSize(13.0f);
        }
        this.f16182oz.setColor(WebView.NIGHT_MODE_COLOR);
        this.f16182oz.setTextAlign(Align.LEFT);
        AppMethodBeat.m2505o(38531);
    }

    public void setText(String str) {
        AppMethodBeat.m2504i(38532);
        if (C5046bo.isNullOrNil(this.mText)) {
            this.mText = "";
        }
        this.mText = str;
        this.rmu.key = "";
        this.rmv.key = "";
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(38532);
    }

    public String getText() {
        return this.mText;
    }

    public void setTextSize(int i) {
        AppMethodBeat.m2504i(38533);
        this.f16182oz.setTextSize((float) i);
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(38533);
    }

    public void setTextColor(int i) {
        AppMethodBeat.m2504i(38534);
        this.f16182oz.setColor(i);
        invalidate();
        AppMethodBeat.m2505o(38534);
    }

    public void setEllipsis(String str) {
        this.rmn = str;
    }

    public void setEllipsisMore(String str) {
        this.rmo = str;
    }

    public void setMaxLines(int i) {
        this.nnY = i;
    }

    public void setDrawEllipsizeMoreString(boolean z) {
        this.rmp = z;
    }

    public void setColorEllpsizeMore(int i) {
        this.rmq = i;
    }

    public void setRightAlignEllipsizeMoreString(boolean z) {
        this.rmr = z;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        List list;
        C3969a c3969a;
        AppMethodBeat.m2504i(38536);
        super.onDraw(canvas);
        C3969a c3969a2;
        if (this.rms) {
            c3969a2 = this.rmu;
            list = this.rmu.rmy;
            c3969a = c3969a2;
        } else {
            c3969a2 = this.rmv;
            Object list2 = this.rmv.rmy;
            c3969a = c3969a2;
        }
        float paddingLeft = (float) getPaddingLeft();
        float paddingTop = (float) (getPaddingTop() + (-this.rmm));
        for (int i = 0; i < list2.size(); i++) {
            int[] iArr = (int[]) list2.get(i);
            canvas.drawText(this.mText, iArr[0], iArr[1] + 1, paddingLeft, paddingTop, this.f16182oz);
            if (i == list2.size() - 1 && c3969a.rmx) {
                canvas.drawText(this.rmn, c3969a.rmz + paddingLeft, paddingTop, this.f16182oz);
                if (this.rmp) {
                    int color = this.f16182oz.getColor();
                    this.f16182oz.setColor(this.rmq);
                    if (this.rmr) {
                        canvas.drawText(this.rmo, ((float) canvas.getWidth()) - ((c3969a.rmB + ((float) getPaddingRight())) + ((float) getPaddingLeft())), paddingTop, this.f16182oz);
                    } else {
                        canvas.drawText(this.rmo, (c3969a.rmz + c3969a.rmA) + paddingLeft, paddingTop, this.f16182oz);
                    }
                    this.f16182oz.setColor(color);
                }
            }
            paddingTop += ((float) (-this.rmm)) + this.f16182oz.descent();
            if (paddingTop > ((float) canvas.getHeight())) {
                break;
            }
        }
        AppMethodBeat.m2505o(38536);
    }

    public boolean getIsExpanded() {
        return this.rms;
    }

    /* renamed from: DU */
    private int m68124DU(int i) {
        AppMethodBeat.m2504i(38537);
        if (this.rms) {
            if (C5046bo.isNullOrNil(this.rmu.key)) {
                this.rmw = this.rmu.mo8760a(this.mText, (i - getPaddingLeft()) - getPaddingRight(), this.f16182oz);
            }
        } else if (C5046bo.isNullOrNil(this.rmv.key)) {
            this.rmw = this.rmv.mo8761a(this.mText, this.rmn, this.rmo, this.nnY, (i - getPaddingLeft()) - getPaddingRight(), this.f16182oz);
        }
        int paddingLeft = (this.rmw + getPaddingLeft()) + getPaddingRight();
        AppMethodBeat.m2505o(38537);
        return paddingLeft;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        AppMethodBeat.m2504i(38535);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == ErrorDialogData.SUPPRESSED) {
            m68124DU(size);
        } else if (mode == C8415j.INVALID_ID) {
            size = Math.min(m68124DU(size), size);
        } else {
            m68124DU(size);
            size = 0;
        }
        int mode2 = MeasureSpec.getMode(i2);
        mode = MeasureSpec.getSize(i2);
        this.rmm = (int) this.f16182oz.ascent();
        if (mode2 == ErrorDialogData.SUPPRESSED) {
            i3 = mode;
        } else {
            if (this.rms) {
                i3 = this.rmu.rmy.size();
            } else {
                i3 = this.rmv.rmy.size();
            }
            i3 = ((i3 * ((int) (((float) (-this.rmm)) + this.f16182oz.descent()))) + getPaddingTop()) + getPaddingBottom();
            if (mode2 == C8415j.INVALID_ID) {
                i3 = Math.min(i3, mode);
            }
        }
        setMeasuredDimension(size, i3);
        AppMethodBeat.m2505o(38535);
    }
}
