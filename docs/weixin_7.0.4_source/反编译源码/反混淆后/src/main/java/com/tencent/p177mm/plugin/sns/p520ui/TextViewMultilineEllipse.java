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
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.TextViewMultilineEllipse */
public class TextViewMultilineEllipse extends View {
    private Context context;
    private String mText;
    private int nnY;
    /* renamed from: oz */
    private TextPaint f13703oz;
    private C29166a rDf;
    private C29166a rDg;
    private int rmm;
    private String rmn;
    private String rmo;
    private boolean rmp;
    private int rmq;
    private boolean rmr;
    private boolean rms;
    private int textSize = -1;

    /* renamed from: com.tencent.mm.plugin.sns.ui.TextViewMultilineEllipse$a */
    static class C29166a {
        float rmA;
        float rmB;
        boolean rmx = false;
        ArrayList<int[]> rmy = new ArrayList();
        float rmz;

        public C29166a() {
            AppMethodBeat.m2504i(39843);
            AppMethodBeat.m2505o(39843);
        }

        /* renamed from: a */
        public final int mo47317a(String str, int i, TextPaint textPaint) {
            AppMethodBeat.m2504i(39844);
            int a = mo47318a(str, null, null, -1, i, textPaint);
            AppMethodBeat.m2505o(39844);
            return a;
        }

        /* renamed from: a */
        public final int mo47318a(String str, String str2, String str3, int i, int i2, TextPaint textPaint) {
            AppMethodBeat.m2504i(39845);
            this.rmy.clear();
            this.rmx = false;
            this.rmz = 0.0f;
            this.rmA = 0.0f;
            this.rmB = 0.0f;
            if (i2 == -1) {
                this.rmy.add(new int[]{0, str.length()});
                i2 = (int) (textPaint.measureText(str) + 0.5f);
                AppMethodBeat.m2505o(39845);
                return i2;
            }
            if (str2 != null) {
                this.rmA = textPaint.measureText(str2);
            }
            if (str3 != null) {
                this.rmB = textPaint.measureText(str3);
            }
            int i3 = -1;
            float f = 0.0f;
            Object obj = 1;
            int i4 = 0;
            while (i4 < str.length()) {
                if (i3 == -1) {
                    i3 = i4;
                }
                if (this.rmy.size() == i) {
                    this.rmx = true;
                    break;
                }
                float measureText = textPaint.measureText(str.charAt(i4));
                Object obj2 = null;
                if (str.charAt(i4) == 10) {
                    obj2 = 1;
                    this.rmy.add(new int[]{i3, i4 - 1});
                } else if (f + measureText >= ((float) i2)) {
                    obj2 = 1;
                    if (str.charAt(i4) == ' ' || obj == null) {
                        i4--;
                        this.rmy.add(new int[]{i3, i4});
                    } else {
                        while (str.charAt(i4) != ' ') {
                            i4--;
                        }
                        this.rmy.add(new int[]{i3, i4});
                    }
                }
                if (obj2 != null) {
                    i3 = -1;
                    f = 0.0f;
                    if (this.rmy.size() == i - 1) {
                        i2 = (int) (((float) i2) - (this.rmA + this.rmB));
                        obj = null;
                    }
                } else {
                    f += measureText;
                    if (i4 == str.length() - 1) {
                        this.rmy.add(new int[]{i3, i4});
                    }
                }
                i4++;
            }
            if (this.rmx) {
                int[] iArr = (int[]) this.rmy.get(this.rmy.size() - 1);
                this.rmz = textPaint.measureText(str.substring(iArr[0], iArr[1] + 1));
            }
            if (this.rmy.size() == 0) {
                AppMethodBeat.m2505o(39845);
                return 0;
            } else if (this.rmy.size() == 1) {
                i2 = (int) (textPaint.measureText(str) + 0.5f);
                AppMethodBeat.m2505o(39845);
                return i2;
            } else {
                AppMethodBeat.m2505o(39845);
                return i2;
            }
        }
    }

    public TextViewMultilineEllipse(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(39846);
        this.context = context;
        this.rms = false;
        this.rmp = true;
        this.rmr = false;
        this.nnY = -1;
        this.rmn = "...";
        this.rmo = "";
        this.rmq = -16776961;
        this.rDf = new C29166a();
        this.rDg = new C29166a();
        this.f13703oz = new TextPaint();
        this.f13703oz.setAntiAlias(true);
        if (this.textSize == -1) {
            this.textSize = C4977b.m7371b(this.context, 12.0f);
            this.f13703oz.setTextSize((float) this.textSize);
        } else {
            this.f13703oz.setTextSize(13.0f);
        }
        this.f13703oz.setColor(WebView.NIGHT_MODE_COLOR);
        this.f13703oz.setTextAlign(Align.LEFT);
        AppMethodBeat.m2505o(39846);
    }

    public void setText(String str) {
        AppMethodBeat.m2504i(39847);
        this.mText = str;
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(39847);
    }

    public void setTextSize(int i) {
        AppMethodBeat.m2504i(39848);
        this.f13703oz.setTextSize((float) i);
        requestLayout();
        invalidate();
        AppMethodBeat.m2505o(39848);
    }

    public void setTextColor(int i) {
        AppMethodBeat.m2504i(39849);
        this.f13703oz.setColor(i);
        invalidate();
        AppMethodBeat.m2505o(39849);
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
        C29166a c29166a;
        AppMethodBeat.m2504i(39851);
        super.onDraw(canvas);
        C29166a c29166a2;
        if (this.rms) {
            c29166a2 = this.rDf;
            list = this.rDf.rmy;
            c29166a = c29166a2;
        } else {
            c29166a2 = this.rDg;
            Object list2 = this.rDg.rmy;
            c29166a = c29166a2;
        }
        float paddingLeft = (float) getPaddingLeft();
        float paddingTop = (float) (getPaddingTop() + (-this.rmm));
        for (int i = 0; i < list2.size(); i++) {
            int[] iArr = (int[]) list2.get(i);
            canvas.drawText(this.mText, iArr[0], iArr[1] + 1, paddingLeft, paddingTop, this.f13703oz);
            if (i == list2.size() - 1 && c29166a.rmx) {
                canvas.drawText(this.rmn, c29166a.rmz + paddingLeft, paddingTop, this.f13703oz);
                if (this.rmp) {
                    int color = this.f13703oz.getColor();
                    this.f13703oz.setColor(this.rmq);
                    if (this.rmr) {
                        canvas.drawText(this.rmo, ((float) canvas.getWidth()) - ((c29166a.rmB + ((float) getPaddingRight())) + ((float) getPaddingLeft())), paddingTop, this.f13703oz);
                    } else {
                        canvas.drawText(this.rmo, (c29166a.rmz + c29166a.rmA) + paddingLeft, paddingTop, this.f13703oz);
                    }
                    this.f13703oz.setColor(color);
                }
            }
            paddingTop += ((float) (-this.rmm)) + this.f13703oz.descent();
            if (paddingTop > ((float) canvas.getHeight())) {
                break;
            }
        }
        AppMethodBeat.m2505o(39851);
    }

    public boolean getIsExpanded() {
        return this.rms;
    }

    /* renamed from: DU */
    private int m46333DU(int i) {
        int a;
        AppMethodBeat.m2504i(39852);
        if (this.rms) {
            a = this.rDf.mo47317a(this.mText, (i - getPaddingLeft()) - getPaddingRight(), this.f13703oz);
        } else {
            a = this.rDg.mo47318a(this.mText, this.rmn, this.rmo, this.nnY, (i - getPaddingLeft()) - getPaddingRight(), this.f13703oz);
        }
        a = (a + getPaddingLeft()) + getPaddingRight();
        AppMethodBeat.m2505o(39852);
        return a;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        AppMethodBeat.m2504i(39850);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == ErrorDialogData.SUPPRESSED) {
            m46333DU(size);
        } else if (mode == C8415j.INVALID_ID) {
            size = Math.min(m46333DU(size), size);
        } else {
            m46333DU(size);
            size = 0;
        }
        int mode2 = MeasureSpec.getMode(i2);
        mode = MeasureSpec.getSize(i2);
        this.rmm = (int) this.f13703oz.ascent();
        if (mode2 == ErrorDialogData.SUPPRESSED) {
            i3 = mode;
        } else {
            if (this.rms) {
                i3 = this.rDf.rmy.size();
            } else {
                i3 = this.rDg.rmy.size();
            }
            i3 = ((i3 * ((int) (((float) (-this.rmm)) + this.f13703oz.descent()))) + getPaddingTop()) + getPaddingBottom();
            if (mode2 == C8415j.INVALID_ID) {
                i3 = Math.min(i3, mode);
            }
        }
        setMeasuredDimension(size, i3);
        AppMethodBeat.m2505o(39850);
    }
}
