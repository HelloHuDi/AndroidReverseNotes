package com.tencent.mm.kiss.widget.textview;

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
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class d {
    private static e eNv = new e();
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
        AppMethodBeat.i(105713);
        AppMethodBeat.o(105713);
    }

    public static d a(CharSequence charSequence, int i, a aVar) {
        boolean z = false;
        AppMethodBeat.i(105709);
        if (charSequence == null) {
            charSequence = "";
        }
        int length = charSequence.length();
        if (charSequence == null) {
            charSequence = "";
        }
        d SP = eNv.SP();
        if (SP == null) {
            SP = new d();
        }
        SP.eNx = charSequence.toString();
        SP.eNy = charSequence;
        SP.eNz = 0;
        SP.eNA = length;
        SP.width = i;
        SP.eNB = new TextPaint();
        if (aVar.maxLines != -1) {
            length = aVar.maxLines;
            if (length >= 0) {
                SP.maxLines = length;
            }
        }
        if (aVar.maxLength != -1) {
            length = aVar.maxLength;
            if (length >= 0) {
                SP.maxLength = length;
                SP.eNJ = new LengthFilter(SP.maxLength);
            }
        }
        Alignment alignment = aVar.eNC;
        if (alignment != null) {
            SP.eNC = alignment;
        }
        if (aVar.eND != null) {
            TruncateAt truncateAt = aVar.eND;
            if (truncateAt != null) {
                SP.eND = truncateAt;
            }
        }
        SP.gravity = aVar.gravity;
        if (aVar.eOf != -1) {
            length = aVar.eOf;
            if (length >= 0) {
                SP.eNE = length;
            }
        }
        if (aVar.eNF != null) {
            TextDirectionHeuristic textDirectionHeuristic = aVar.eNF;
            if (VERSION.SDK_INT >= 18) {
                SP.eNF = textDirectionHeuristic;
            }
        }
        float f = aVar.eNG;
        float f2 = aVar.eNH;
        SP.eNG = f;
        SP.eNH = f2;
        SP.eNI = aVar.eNI;
        if (aVar.bTq != null) {
            if (aVar.fontStyle != -1) {
                Typeface typeface = aVar.bTq;
                int i2 = aVar.fontStyle;
                if (i2 > 0) {
                    if (typeface == null) {
                        typeface = Typeface.defaultFromStyle(i2);
                    } else {
                        typeface = Typeface.create(typeface, i2);
                    }
                    SP.c(typeface);
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
                    SP.c(typeface);
                }
            } else {
                SP.c(aVar.bTq);
            }
        }
        if (aVar.eOg != -1.0f) {
            SP.eNB.setTextSize(aVar.eOg);
        }
        if (aVar.textColor != -1) {
            SP.eNB.setColor(aVar.textColor);
        }
        if (aVar.linkColor != -1) {
            SP.eNB.linkColor = aVar.linkColor;
        }
        if (aVar.eNN != null) {
            SP.eNB = aVar.eNN;
        }
        AppMethodBeat.o(105709);
        return SP;
    }

    private d c(Typeface typeface) {
        AppMethodBeat.i(105710);
        this.eNB.setTypeface(typeface);
        AppMethodBeat.o(105710);
        return this;
    }

    @TargetApi(18)
    public final f SO() {
        int i;
        boolean z;
        StaticLayout a;
        AppMethodBeat.i(105711);
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
        if (h.DEBUG) {
            ab.i("StaticTextView.StaticLayoutBuilder", "StaticLayoutWrapper build " + this.eNy + " " + this.width);
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
        if ((this.eNF == null || (com.tencent.mm.compatible.util.d.iW(18) && this.eNF == TextDirectionHeuristics.FIRSTSTRONG_LTR)) && (this.maxLines == BaseClientBuilder.API_PRIORITY_OTHER || this.maxLines == -1)) {
            z = true;
        } else {
            z = false;
        }
        try {
            a = a(this.eNy, z, i);
        } catch (Exception e) {
            ab.i("StaticTextView.StaticLayoutBuilder", "build static layout error: %s", e.getMessage());
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
                    staticLayout = a(this.eNy, z, i);
                    ab.i("StaticTextView.StaticLayoutBuilder", "fix from build static layout, fixCount: %s", Integer.valueOf(i2));
                    a = staticLayout;
                } catch (Exception e2) {
                    ab.i("StaticTextView.StaticLayoutBuilder", "fix, build static layout error: %s, fixCount: %s", e2.getMessage(), Integer.valueOf(i2));
                }
            }
            a = staticLayout;
        }
        if (a == null) {
            this.eNy = this.eNy.toString();
            a = a(this.eNy, z, i);
        }
        f fVar = new f(a);
        fVar.eNM = this.eNx;
        fVar.text = this.eNy;
        fVar.maxLength = this.maxLength;
        fVar.maxLines = this.maxLines;
        fVar.eNC = this.eNC;
        fVar.eND = this.eND;
        fVar.eNN = this.eNB;
        fVar.gravity = this.gravity;
        eNv.a(this);
        AppMethodBeat.o(105711);
        return fVar;
    }

    private StaticLayout a(CharSequence charSequence, boolean z, int i) {
        StaticLayout staticLayout;
        AppMethodBeat.i(105712);
        if (z) {
            staticLayout = new StaticLayout(charSequence, this.eNz, this.eNA, this.eNB, this.width, this.eNC, this.eNH, this.eNG, this.eNI, this.eND, i);
        } else if (VERSION.SDK_INT >= 18) {
            if (this.eNF == null) {
                this.eNF = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
            staticLayout = com.tencent.mm.kiss.widget.textview.b.a.a(charSequence, this.eNz, this.eNA, this.eNB, this.width, this.eNC, this.eNF, this.eNH, this.eNG, this.eNI, this.eND, i, this.maxLines);
        } else {
            staticLayout = com.tencent.mm.kiss.widget.textview.b.a.a(charSequence, this.eNz, this.eNA, this.eNB, this.width, this.eNC, this.eNH, this.eNG, this.eNI, this.eND, i, this.maxLines);
        }
        AppMethodBeat.o(105712);
        return staticLayout;
    }
}
