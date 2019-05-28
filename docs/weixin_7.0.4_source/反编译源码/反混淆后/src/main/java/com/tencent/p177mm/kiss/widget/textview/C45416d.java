package com.tencent.p177mm.kiss.widget.textview;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.InputFilter.LengthFilter;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.style.MetricAffectingSpan;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kiss.widget.textview.p1194a.C42149a;
import com.tencent.p177mm.kiss.widget.textview.p857b.C26348a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.kiss.widget.textview.d */
public final class C45416d {
    private static C42150e eNv = new C42150e();
    private static final SpannableString eNw = new SpannableString("");
    int eNA = 0;
    TextPaint eNB = null;
    Alignment eNC = Alignment.ALIGN_NORMAL;
    TruncateAt eND = null;
    int eNE = -1;
    TextDirectionHeuristic eNF = null;
    float eNG = 0.0f;
    float eNH = 1.0f;
    boolean eNI = false;
    LengthFilter eNJ = null;
    CharSequence eNx = null;
    CharSequence eNy = null;
    int eNz = 0;
    int gravity = 51;
    int maxLength = -1;
    int maxLines = BaseClientBuilder.API_PRIORITY_OTHER;
    int width = 0;

    static {
        AppMethodBeat.m2504i(105713);
        AppMethodBeat.m2505o(105713);
    }

    /* renamed from: a */
    public static C45416d m83643a(CharSequence charSequence, int i, C42149a c42149a) {
        boolean z = false;
        AppMethodBeat.m2504i(105709);
        if (charSequence == null) {
            charSequence = "";
        }
        int length = charSequence.length();
        if (charSequence == null) {
            charSequence = "";
        }
        C45416d SP = eNv.mo67689SP();
        if (SP == null) {
            SP = new C45416d();
        }
        SP.eNx = charSequence.toString();
        SP.eNy = charSequence;
        SP.eNz = 0;
        SP.eNA = length;
        SP.width = i;
        SP.eNB = new TextPaint();
        if (c42149a.maxLines != -1) {
            length = c42149a.maxLines;
            if (length >= 0) {
                SP.maxLines = length;
            }
        }
        if (c42149a.maxLength != -1) {
            length = c42149a.maxLength;
            if (length >= 0) {
                SP.maxLength = length;
                SP.eNJ = new LengthFilter(SP.maxLength);
            }
        }
        Alignment alignment = c42149a.eNC;
        if (alignment != null) {
            SP.eNC = alignment;
        }
        if (c42149a.eND != null) {
            TruncateAt truncateAt = c42149a.eND;
            if (truncateAt != null) {
                SP.eND = truncateAt;
            }
        }
        SP.gravity = c42149a.gravity;
        if (c42149a.eOf != -1) {
            length = c42149a.eOf;
            if (length >= 0) {
                SP.eNE = length;
            }
        }
        if (c42149a.eNF != null) {
            TextDirectionHeuristic textDirectionHeuristic = c42149a.eNF;
            if (VERSION.SDK_INT >= 18) {
                SP.eNF = textDirectionHeuristic;
            }
        }
        float f = c42149a.eNG;
        float f2 = c42149a.eNH;
        SP.eNG = f;
        SP.eNH = f2;
        SP.eNI = c42149a.eNI;
        if (c42149a.bTq != null) {
            if (c42149a.fontStyle != -1) {
                Typeface typeface = c42149a.bTq;
                int i2 = c42149a.fontStyle;
                if (i2 > 0) {
                    if (typeface == null) {
                        typeface = Typeface.defaultFromStyle(i2);
                    } else {
                        typeface = Typeface.create(typeface, i2);
                    }
                    SP.m83644c(typeface);
                    if (typeface != null) {
                        length = typeface.getStyle();
                    } else {
                        length = 0;
                    }
                    length = (length ^ -1) & i2;
                    TextPaint textPaint = SP.eNB;
                    if ((length & 1) != 0) {
                        z = true;
                    }
                    textPaint.setFakeBoldText(z);
                    TextPaint textPaint2 = SP.eNB;
                    if ((length & 2) != 0) {
                        f = -0.25f;
                    } else {
                        f = 0.0f;
                    }
                    textPaint2.setTextSkewX(f);
                } else {
                    SP.eNB.setFakeBoldText(false);
                    SP.eNB.setTextSkewX(0.0f);
                    SP.m83644c(typeface);
                }
            } else {
                SP.m83644c(c42149a.bTq);
            }
        }
        if (c42149a.eOg != -1.0f) {
            SP.eNB.setTextSize(c42149a.eOg);
        }
        if (c42149a.textColor != -1) {
            SP.eNB.setColor(c42149a.textColor);
        }
        if (c42149a.linkColor != -1) {
            SP.eNB.linkColor = c42149a.linkColor;
        }
        if (c42149a.eNN != null) {
            SP.eNB = c42149a.eNN;
        }
        AppMethodBeat.m2505o(105709);
        return SP;
    }

    /* renamed from: c */
    private C45416d m83644c(Typeface typeface) {
        AppMethodBeat.m2504i(105710);
        this.eNB.setTypeface(typeface);
        AppMethodBeat.m2505o(105710);
        return this;
    }

    @TargetApi(18)
    /* renamed from: SO */
    public final C37874f mo73210SO() {
        int i;
        boolean z;
        StaticLayout a;
        AppMethodBeat.m2504i(105711);
        if (this.eND == null || this.eNE <= 0) {
            i = this.width;
        } else {
            i = this.eNE;
        }
        if (this.eND == null && this.maxLines == 1) {
            this.eND = TruncateAt.END;
        }
        if (this.maxLength > 0 && this.eNJ != null) {
            CharSequence filter = this.eNJ.filter(this.eNy, 0, this.eNy.length(), eNw, 0, 0);
            if (filter != null) {
                this.eNy = filter;
                if (this.eNA > this.eNy.length()) {
                    this.eNA = this.eNy.length();
                }
            }
        }
        if (C18527h.DEBUG) {
            C4990ab.m7416i("StaticTextView.StaticLayoutBuilder", "StaticLayoutWrapper build " + this.eNy + " " + this.width);
        }
        if (this.eNC == Alignment.ALIGN_NORMAL) {
            switch (this.gravity & 8388615) {
                case 1:
                    this.eNC = Alignment.ALIGN_CENTER;
                    break;
                case 3:
                case 8388611:
                    this.eNC = Alignment.ALIGN_NORMAL;
                    break;
                case 5:
                case 8388613:
                    this.eNC = Alignment.ALIGN_OPPOSITE;
                    break;
                default:
                    this.eNC = Alignment.ALIGN_NORMAL;
                    break;
            }
        }
        this.eNB.setAntiAlias(true);
        StaticLayout staticLayout = null;
        if ((this.eNF == null || (C1443d.m3068iW(18) && this.eNF == TextDirectionHeuristics.FIRSTSTRONG_LTR)) && (this.maxLines == BaseClientBuilder.API_PRIORITY_OTHER || this.maxLines == -1)) {
            z = true;
        } else {
            z = false;
        }
        try {
            a = m83642a(this.eNy, z, i);
        } catch (Exception e) {
            C4990ab.m7417i("StaticTextView.StaticLayoutBuilder", "build static layout error: %s", e.getMessage());
            int i2 = 0;
            while (i2 < 3) {
                try {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.eNy);
                    MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MetricAffectingSpan.class);
                    if (metricAffectingSpanArr == null || metricAffectingSpanArr.length <= 0) {
                        i2 = 100;
                    } else {
                        spannableStringBuilder.insert(spannableStringBuilder.getSpanStart(metricAffectingSpanArr[0]) - 1, " ");
                        i2++;
                    }
                    this.eNy = spannableStringBuilder;
                    staticLayout = m83642a(this.eNy, z, i);
                    C4990ab.m7417i("StaticTextView.StaticLayoutBuilder", "fix from build static layout, fixCount: %s", Integer.valueOf(i2));
                    a = staticLayout;
                } catch (Exception e2) {
                    C4990ab.m7417i("StaticTextView.StaticLayoutBuilder", "fix, build static layout error: %s, fixCount: %s", e2.getMessage(), Integer.valueOf(i2));
                }
            }
            a = staticLayout;
        }
        if (a == null) {
            this.eNy = this.eNy.toString();
            a = m83642a(this.eNy, z, i);
        }
        C37874f c37874f = new C37874f(a);
        c37874f.eNM = this.eNx;
        c37874f.text = this.eNy;
        c37874f.maxLength = this.maxLength;
        c37874f.maxLines = this.maxLines;
        c37874f.eNC = this.eNC;
        c37874f.eND = this.eND;
        c37874f.eNN = this.eNB;
        c37874f.gravity = this.gravity;
        eNv.mo67690a(this);
        AppMethodBeat.m2505o(105711);
        return c37874f;
    }

    /* renamed from: a */
    private StaticLayout m83642a(CharSequence charSequence, boolean z, int i) {
        StaticLayout staticLayout;
        AppMethodBeat.m2504i(105712);
        if (z) {
            staticLayout = new StaticLayout(charSequence, this.eNz, this.eNA, this.eNB, this.width, this.eNC, this.eNH, this.eNG, this.eNI, this.eND, i);
        } else if (VERSION.SDK_INT >= 18) {
            if (this.eNF == null) {
                this.eNF = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
            staticLayout = C26348a.m41925a(charSequence, this.eNz, this.eNA, this.eNB, this.width, this.eNC, this.eNF, this.eNH, this.eNG, this.eNI, this.eND, i, this.maxLines);
        } else {
            staticLayout = C26348a.m41924a(charSequence, this.eNz, this.eNA, this.eNB, this.width, this.eNC, this.eNH, this.eNG, this.eNI, this.eND, i, this.maxLines);
        }
        AppMethodBeat.m2505o(105712);
        return staticLayout;
    }
}
