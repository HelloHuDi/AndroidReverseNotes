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
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QTextView extends View {
    private static HashMap<String, a> rmt = new HashMap();
    private Context context;
    private String mText = "";
    private int nnY;
    private TextPaint oz;
    private int rmm;
    private String rmn;
    private String rmo;
    private boolean rmp;
    private int rmq;
    private boolean rmr;
    boolean rms;
    private a rmu;
    private a rmv;
    int rmw = 0;
    private int textSize = -1;

    static class a {
        private static HashMap<String, Integer> rmC = new HashMap();
        private String key = "";
        float rmA;
        float rmB;
        private int rmw = 0;
        boolean rmx = false;
        ArrayList<int[]> rmy = new ArrayList();
        float rmz;

        public a() {
            AppMethodBeat.i(38525);
            AppMethodBeat.o(38525);
        }

        public final int a(String str, int i, TextPaint textPaint) {
            AppMethodBeat.i(38526);
            int a = a(str, null, null, -1, i, textPaint);
            AppMethodBeat.o(38526);
            return a;
        }

        static {
            AppMethodBeat.i(38528);
            AppMethodBeat.o(38528);
        }

        public final int a(String str, String str2, String str3, int i, int i2, TextPaint textPaint) {
            AppMethodBeat.i(38527);
            String str4 = str + str2 + str3 + i + i2;
            int i3;
            if (str4.equals(this.key)) {
                i3 = this.rmw;
                AppMethodBeat.o(38527);
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
                AppMethodBeat.o(38527);
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
                AppMethodBeat.o(38527);
                return i3;
            } else if (this.rmy.size() == 1) {
                this.rmw = (int) (textPaint.measureText(str) + 0.5f);
                i3 = this.rmw;
                AppMethodBeat.o(38527);
                return i3;
            } else {
                this.rmw = i2;
                i3 = this.rmw;
                AppMethodBeat.o(38527);
                return i3;
            }
        }
    }

    static {
        AppMethodBeat.i(38538);
        AppMethodBeat.o(38538);
    }

    public QTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38529);
        this.context = context;
        init();
        AppMethodBeat.o(38529);
    }

    public QTextView(Context context) {
        super(context);
        AppMethodBeat.i(38530);
        this.context = context;
        init();
        AppMethodBeat.o(38530);
    }

    private void init() {
        AppMethodBeat.i(38531);
        this.rms = false;
        this.rmp = true;
        this.rmr = false;
        this.nnY = -1;
        this.rmn = "...";
        this.rmo = "";
        this.rmq = -16776961;
        this.rmu = new a();
        this.rmv = new a();
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
        AppMethodBeat.o(38531);
    }

    public void setText(String str) {
        AppMethodBeat.i(38532);
        if (bo.isNullOrNil(this.mText)) {
            this.mText = "";
        }
        this.mText = str;
        this.rmu.key = "";
        this.rmv.key = "";
        requestLayout();
        invalidate();
        AppMethodBeat.o(38532);
    }

    public String getText() {
        return this.mText;
    }

    public void setTextSize(int i) {
        AppMethodBeat.i(38533);
        this.oz.setTextSize((float) i);
        requestLayout();
        invalidate();
        AppMethodBeat.o(38533);
    }

    public void setTextColor(int i) {
        AppMethodBeat.i(38534);
        this.oz.setColor(i);
        invalidate();
        AppMethodBeat.o(38534);
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
        AppMethodBeat.i(38536);
        super.onDraw(canvas);
        a aVar2;
        if (this.rms) {
            aVar2 = this.rmu;
            list = this.rmu.rmy;
            aVar = aVar2;
        } else {
            aVar2 = this.rmv;
            Object list2 = this.rmv.rmy;
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
        AppMethodBeat.o(38536);
    }

    public boolean getIsExpanded() {
        return this.rms;
    }

    private int DU(int i) {
        AppMethodBeat.i(38537);
        if (this.rms) {
            if (bo.isNullOrNil(this.rmu.key)) {
                this.rmw = this.rmu.a(this.mText, (i - getPaddingLeft()) - getPaddingRight(), this.oz);
            }
        } else if (bo.isNullOrNil(this.rmv.key)) {
            this.rmw = this.rmv.a(this.mText, this.rmn, this.rmo, this.nnY, (i - getPaddingLeft()) - getPaddingRight(), this.oz);
        }
        int paddingLeft = (this.rmw + getPaddingLeft()) + getPaddingRight();
        AppMethodBeat.o(38537);
        return paddingLeft;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        AppMethodBeat.i(38535);
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
                i3 = this.rmu.rmy.size();
            } else {
                i3 = this.rmv.rmy.size();
            }
            i3 = ((i3 * ((int) (((float) (-this.rmm)) + this.oz.descent()))) + getPaddingTop()) + getPaddingBottom();
            if (mode2 == j.INVALID_ID) {
                i3 = Math.min(i3, mode);
            }
        }
        setMeasuredDimension(size, i3);
        AppMethodBeat.o(38535);
    }
}
