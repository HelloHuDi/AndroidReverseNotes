package com.tencent.p177mm.p612ui.widget.textview;

import android.content.Context;
import android.text.Layout;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.layout.C5782a;
import com.tencent.neattextview.textview.view.NeatTextView;

/* renamed from: com.tencent.mm.ui.widget.textview.b */
public final class C40917b {
    public static int getScreenWidth(Context context) {
        AppMethodBeat.m2504i(113159);
        int i = context.getResources().getDisplayMetrics().widthPixels;
        AppMethodBeat.m2505o(113159);
        return i;
    }

    /* renamed from: d */
    public static int m70928d(View view, int i, int i2, int i3) {
        int ay;
        AppMethodBeat.m2504i(113160);
        int ax = C40917b.m70926ax(view, i2);
        if (C40917b.m70918ap(view, i3)) {
            ay = (int) C40917b.m70927ay(view, ax);
            if (i > ay - ((ay - ((int) C40917b.m70921as(view, i3 - 1))) / 2)) {
                i3--;
            }
        }
        int ar = C40917b.m70920ar(view, i3);
        ay = C40917b.m70922at(view, ar);
        int au = C40917b.m70923au(view, ar);
        int i4 = (au - ay) / 2;
        if ((ax != ar + 1 || i2 - au >= i4) && (ax != ar - 1 || ay - i2 >= i4)) {
            ar = ax;
        }
        ax = C40917b.m70916a(view, ar, (float) i);
        if (ax < C40917b.m70929fs(view).length() - 1 && C40917b.m70918ap(view, ax + 1)) {
            ar = (int) C40917b.m70927ay(view, ar);
            if (i > ar - ((ar - ((int) C40917b.m70921as(view, ax))) / 2)) {
                ar = ax + 1;
                AppMethodBeat.m2505o(113160);
                return ar;
            }
        }
        ar = ax;
        AppMethodBeat.m2505o(113160);
        return ar;
    }

    /* renamed from: ap */
    private static boolean m70918ap(View view, int i) {
        AppMethodBeat.m2504i(113161);
        if (i <= 0 || C40917b.m70920ar(view, i) != C40917b.m70920ar(view, i - 1) + 1) {
            AppMethodBeat.m2505o(113161);
            return false;
        }
        AppMethodBeat.m2505o(113161);
        return true;
    }

    /* renamed from: fs */
    public static CharSequence m70929fs(View view) {
        AppMethodBeat.m2504i(113162);
        CharSequence dPr;
        if (view instanceof NeatTextView) {
            dPr = ((NeatTextView) view).dPr();
            AppMethodBeat.m2505o(113162);
            return dPr;
        } else if (view instanceof TextView) {
            dPr = ((TextView) view).getText();
            AppMethodBeat.m2505o(113162);
            return dPr;
        } else {
            dPr = "";
            AppMethodBeat.m2505o(113162);
            return dPr;
        }
    }

    /* renamed from: a */
    public static void m70917a(View view, CharSequence charSequence, BufferType bufferType) {
        AppMethodBeat.m2504i(113163);
        if (view instanceof NeatTextView) {
            ((NeatTextView) view).mo15920a(charSequence, bufferType);
            AppMethodBeat.m2505o(113163);
            return;
        }
        if (view instanceof TextView) {
            ((TextView) view).setText(charSequence, bufferType);
        }
        AppMethodBeat.m2505o(113163);
    }

    /* renamed from: ft */
    public static TextPaint m70930ft(View view) {
        AppMethodBeat.m2504i(113164);
        TextPaint paint;
        if (view instanceof NeatTextView) {
            paint = ((NeatTextView) view).getPaint();
            AppMethodBeat.m2505o(113164);
            return paint;
        } else if (view instanceof TextView) {
            paint = ((TextView) view).getPaint();
            AppMethodBeat.m2505o(113164);
            return paint;
        } else {
            AppMethodBeat.m2505o(113164);
            return null;
        }
    }

    /* renamed from: aq */
    public static int m70919aq(View view, int i) {
        AppMethodBeat.m2504i(113165);
        int lineBaseline;
        if (view instanceof NeatTextView) {
            C5782a layout = ((NeatTextView) view).getLayout();
            if (layout != null) {
                lineBaseline = layout.getLineBaseline(i);
                AppMethodBeat.m2505o(113165);
                return lineBaseline;
            }
        } else if (view instanceof TextView) {
            Layout layout2 = ((TextView) view).getLayout();
            if (layout2 != null) {
                lineBaseline = layout2.getLineBaseline(i);
                AppMethodBeat.m2505o(113165);
                return lineBaseline;
            }
        }
        AppMethodBeat.m2505o(113165);
        return 0;
    }

    /* renamed from: ar */
    public static int m70920ar(View view, int i) {
        AppMethodBeat.m2504i(113166);
        int lineForOffset;
        if (view instanceof NeatTextView) {
            C5782a layout = ((NeatTextView) view).getLayout();
            if (layout != null) {
                lineForOffset = layout.getLineForOffset(i);
                AppMethodBeat.m2505o(113166);
                return lineForOffset;
            }
        } else if (view instanceof TextView) {
            Layout layout2 = ((TextView) view).getLayout();
            if (layout2 != null) {
                lineForOffset = layout2.getLineForOffset(i);
                AppMethodBeat.m2505o(113166);
                return lineForOffset;
            }
        }
        AppMethodBeat.m2505o(113166);
        return 0;
    }

    /* renamed from: as */
    public static float m70921as(View view, int i) {
        AppMethodBeat.m2504i(113167);
        float primaryHorizontal;
        if (view instanceof NeatTextView) {
            C5782a layout = ((NeatTextView) view).getLayout();
            if (layout != null) {
                primaryHorizontal = layout.getPrimaryHorizontal(i);
                AppMethodBeat.m2505o(113167);
                return primaryHorizontal;
            }
        } else if (view instanceof TextView) {
            Layout layout2 = ((TextView) view).getLayout();
            if (layout2 != null) {
                primaryHorizontal = layout2.getPrimaryHorizontal(i);
                AppMethodBeat.m2505o(113167);
                return primaryHorizontal;
            }
        }
        AppMethodBeat.m2505o(113167);
        return 0.0f;
    }

    /* renamed from: a */
    private static int m70916a(View view, int i, float f) {
        AppMethodBeat.m2504i(113168);
        int offsetForHorizontal;
        if (view instanceof NeatTextView) {
            C5782a layout = ((NeatTextView) view).getLayout();
            if (layout != null) {
                offsetForHorizontal = layout.getOffsetForHorizontal(i, f);
                AppMethodBeat.m2505o(113168);
                return offsetForHorizontal;
            }
        } else if (view instanceof TextView) {
            Layout layout2 = ((TextView) view).getLayout();
            if (layout2 != null) {
                offsetForHorizontal = layout2.getOffsetForHorizontal(i, f);
                AppMethodBeat.m2505o(113168);
                return offsetForHorizontal;
            }
        }
        AppMethodBeat.m2505o(113168);
        return 0;
    }

    /* renamed from: at */
    public static int m70922at(View view, int i) {
        AppMethodBeat.m2504i(113169);
        int lineTop;
        if (view instanceof NeatTextView) {
            C5782a layout = ((NeatTextView) view).getLayout();
            if (layout != null) {
                lineTop = layout.getLineTop(i);
                AppMethodBeat.m2505o(113169);
                return lineTop;
            }
        } else if (view instanceof TextView) {
            Layout layout2 = ((TextView) view).getLayout();
            if (layout2 != null) {
                lineTop = layout2.getLineTop(i);
                AppMethodBeat.m2505o(113169);
                return lineTop;
            }
        }
        AppMethodBeat.m2505o(113169);
        return 0;
    }

    /* renamed from: au */
    private static int m70923au(View view, int i) {
        AppMethodBeat.m2504i(113170);
        int lineBottom;
        if (view instanceof NeatTextView) {
            C5782a layout = ((NeatTextView) view).getLayout();
            if (layout != null) {
                lineBottom = layout.getLineBottom(i);
                AppMethodBeat.m2505o(113170);
                return lineBottom;
            }
        } else if (view instanceof TextView) {
            Layout layout2 = ((TextView) view).getLayout();
            if (layout2 != null) {
                lineBottom = layout2.getLineBottom(i);
                AppMethodBeat.m2505o(113170);
                return lineBottom;
            }
        }
        AppMethodBeat.m2505o(113170);
        return 0;
    }

    /* renamed from: av */
    public static float m70924av(View view, int i) {
        AppMethodBeat.m2504i(113171);
        float lineWidth;
        if (view instanceof NeatTextView) {
            C5782a layout = ((NeatTextView) view).getLayout();
            if (layout != null) {
                lineWidth = layout.getLineWidth(i);
                AppMethodBeat.m2505o(113171);
                return lineWidth;
            }
        } else if (view instanceof TextView) {
            Layout layout2 = ((TextView) view).getLayout();
            if (layout2 != null) {
                lineWidth = layout2.getLineWidth(i);
                AppMethodBeat.m2505o(113171);
                return lineWidth;
            }
        }
        AppMethodBeat.m2505o(113171);
        return 0.0f;
    }

    /* renamed from: aw */
    public static int m70925aw(View view, int i) {
        AppMethodBeat.m2504i(113172);
        int lineStart;
        if (view instanceof NeatTextView) {
            C5782a layout = ((NeatTextView) view).getLayout();
            if (layout != null) {
                lineStart = layout.getLineStart(i);
                AppMethodBeat.m2505o(113172);
                return lineStart;
            }
        } else if (view instanceof TextView) {
            Layout layout2 = ((TextView) view).getLayout();
            if (layout2 != null) {
                lineStart = layout2.getLineStart(i);
                AppMethodBeat.m2505o(113172);
                return lineStart;
            }
        }
        AppMethodBeat.m2505o(113172);
        return 0;
    }

    /* renamed from: ax */
    private static int m70926ax(View view, int i) {
        AppMethodBeat.m2504i(113173);
        int lineForVertical;
        if (view instanceof NeatTextView) {
            C5782a layout = ((NeatTextView) view).getLayout();
            if (layout != null) {
                lineForVertical = layout.getLineForVertical(i);
                AppMethodBeat.m2505o(113173);
                return lineForVertical;
            }
        } else if (view instanceof TextView) {
            Layout layout2 = ((TextView) view).getLayout();
            if (layout2 != null) {
                lineForVertical = layout2.getLineForVertical(i);
                AppMethodBeat.m2505o(113173);
                return lineForVertical;
            }
        }
        AppMethodBeat.m2505o(113173);
        return 0;
    }

    /* renamed from: ay */
    private static float m70927ay(View view, int i) {
        AppMethodBeat.m2504i(113174);
        float lineRight;
        if (view instanceof NeatTextView) {
            C5782a layout = ((NeatTextView) view).getLayout();
            if (layout != null) {
                lineRight = layout.getLineRight(i);
                AppMethodBeat.m2505o(113174);
                return lineRight;
            }
        } else if (view instanceof TextView) {
            Layout layout2 = ((TextView) view).getLayout();
            if (layout2 != null) {
                lineRight = layout2.getLineRight(i);
                AppMethodBeat.m2505o(113174);
                return lineRight;
            }
        }
        AppMethodBeat.m2505o(113174);
        return 0.0f;
    }
}
