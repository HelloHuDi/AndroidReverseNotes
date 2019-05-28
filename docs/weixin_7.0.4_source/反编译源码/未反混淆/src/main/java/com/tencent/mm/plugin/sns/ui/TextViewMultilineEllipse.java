package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.support.v4.widget.j;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

public class TextViewMultilineEllipse extends View {
    private Context context;
    private String mText;
    private int nnY;
    private TextPaint oz;
    private a rDf;
    private a rDg;
    private int rmm;
    private String rmn;
    private String rmo;
    private boolean rmp;
    private int rmq;
    private boolean rmr;
    private boolean rms;
    private int textSize = -1;

    static class a {
        float rmA;
        float rmB;
        boolean rmx = false;
        ArrayList<int[]> rmy = new ArrayList();
        float rmz;

        public a() {
            AppMethodBeat.i(39843);
            AppMethodBeat.o(39843);
        }

        public final int a(String str, int i, TextPaint textPaint) {
            AppMethodBeat.i(39844);
            int a = a(str, null, null, -1, i, textPaint);
            AppMethodBeat.o(39844);
            return a;
        }

        public final int a(String str, String str2, String str3, int i, int i2, TextPaint textPaint) {
            AppMethodBeat.i(39845);
            this.rmy.clear();
            this.rmx = false;
            this.rmz = 0.0f;
            this.rmA = 0.0f;
            this.rmB = 0.0f;
            if (i2 == -1) {
                this.rmy.add(new int[]{0, str.length()});
                i2 = (int) (textPaint.measureText(str) + 0.5f);
                AppMethodBeat.o(39845);
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
                AppMethodBeat.o(39845);
                return 0;
            } else if (this.rmy.size() == 1) {
                i2 = (int) (textPaint.measureText(str) + 0.5f);
                AppMethodBeat.o(39845);
                return i2;
            } else {
                AppMethodBeat.o(39845);
                return i2;
            }
        }
    }

    public TextViewMultilineEllipse(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(39846);
        this.context = context;
        this.rms = false;
        this.rmp = true;
        this.rmr = false;
        this.nnY = -1;
        this.rmn = "...";
        this.rmo = "";
        this.rmq = -16776961;
        this.rDf = new a();
        this.rDg = new a();
        this.oz = new TextPaint();
        this.oz.setAntiAlias(true);
        if (this.textSize == -1) {
            this.textSize = b.b(this.context, 12.0f);
            this.oz.setTextSize((float) this.textSize);
        } else {
            this.oz.setTextSize(13.0f);
        }
        this.oz.setColor(WebView.NIGHT_MODE_COLOR);
        this.oz.setTextAlign(Align.LEFT);
        AppMethodBeat.o(39846);
    }

    public void setText(String str) {
        AppMethodBeat.i(39847);
        this.mText = str;
        requestLayout();
        invalidate();
        AppMethodBeat.o(39847);
    }

    public void setTextSize(int i) {
        AppMethodBeat.i(39848);
        this.oz.setTextSize((float) i);
        requestLayout();
        invalidate();
        AppMethodBeat.o(39848);
    }

    public void setTextColor(int i) {
        AppMethodBeat.i(39849);
        this.oz.setColor(i);
        invalidate();
        AppMethodBeat.o(39849);
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
        a aVar;
        AppMethodBeat.i(39851);
        super.onDraw(canvas);
        a aVar2;
        if (this.rms) {
            aVar2 = this.rDf;
            list = this.rDf.rmy;
            aVar = aVar2;
        } else {
            aVar2 = this.rDg;
            Object list2 = this.rDg.rmy;
            aVar = aVar2;
        }
        float paddingLeft = (float) getPaddingLeft();
        float paddingTop = (float) (getPaddingTop() + (-this.rmm));
        for (int i = 0; i < list2.size(); i++) {
            int[] iArr = (int[]) list2.get(i);
            canvas.drawText(this.mText, iArr[0], iArr[1] + 1, paddingLeft, paddingTop, this.oz);
            if (i == list2.size() - 1 && aVar.rmx) {
                canvas.drawText(this.rmn, aVar.rmz + paddingLeft, paddingTop, this.oz);
                if (this.rmp) {
                    int color = this.oz.getColor();
                    this.oz.setColor(this.rmq);
                    if (this.rmr) {
                        canvas.drawText(this.rmo, ((float) canvas.getWidth()) - ((aVar.rmB + ((float) getPaddingRight())) + ((float) getPaddingLeft())), paddingTop, this.oz);
                    } else {
                        canvas.drawText(this.rmo, (aVar.rmz + aVar.rmA) + paddingLeft, paddingTop, this.oz);
                    }
                    this.oz.setColor(color);
                }
            }
            paddingTop += ((float) (-this.rmm)) + this.oz.descent();
            if (paddingTop > ((float) canvas.getHeight())) {
                break;
            }
        }
        AppMethodBeat.o(39851);
    }

    public boolean getIsExpanded() {
        return this.rms;
    }

    private int DU(int i) {
        int a;
        AppMethodBeat.i(39852);
        if (this.rms) {
            a = this.rDf.a(this.mText, (i - getPaddingLeft()) - getPaddingRight(), this.oz);
        } else {
            a = this.rDg.a(this.mText, this.rmn, this.rmo, this.nnY, (i - getPaddingLeft()) - getPaddingRight(), this.oz);
        }
        a = (a + getPaddingLeft()) + getPaddingRight();
        AppMethodBeat.o(39852);
        return a;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        AppMethodBeat.i(39850);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == ErrorDialogData.SUPPRESSED) {
            DU(size);
        } else if (mode == j.INVALID_ID) {
            size = Math.min(DU(size), size);
        } else {
            DU(size);
            size = 0;
        }
        int mode2 = MeasureSpec.getMode(i2);
        mode = MeasureSpec.getSize(i2);
        this.rmm = (int) this.oz.ascent();
        if (mode2 == ErrorDialogData.SUPPRESSED) {
            i3 = mode;
        } else {
            if (this.rms) {
                i3 = this.rDf.rmy.size();
            } else {
                i3 = this.rDg.rmy.size();
            }
            i3 = ((i3 * ((int) (((float) (-this.rmm)) + this.oz.descent()))) + getPaddingTop()) + getPaddingBottom();
            if (mode2 == j.INVALID_ID) {
                i3 = Math.min(i3, mode);
            }
        }
        setMeasuredDimension(size, i3);
        AppMethodBeat.o(39850);
    }
}
