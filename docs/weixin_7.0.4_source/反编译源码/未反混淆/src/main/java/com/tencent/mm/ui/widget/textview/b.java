package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.text.Layout;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.layout.a;
import com.tencent.neattextview.textview.view.NeatTextView;

public final class b {
    public static int getScreenWidth(Context context) {
        AppMethodBeat.i(113159);
        int i = context.getResources().getDisplayMetrics().widthPixels;
        AppMethodBeat.o(113159);
        return i;
    }

    public static int d(View view, int i, int i2, int i3) {
        int ay;
        AppMethodBeat.i(113160);
        int ax = ax(view, i2);
        if (ap(view, i3)) {
            ay = (int) ay(view, ax);
            if (i > ay - ((ay - ((int) as(view, i3 - 1))) / 2)) {
                i3--;
            }
        }
        int ar = ar(view, i3);
        ay = at(view, ar);
        int au = au(view, ar);
        int i4 = (au - ay) / 2;
        if ((ax != ar + 1 || i2 - au >= i4) && (ax != ar - 1 || ay - i2 >= i4)) {
            ar = ax;
        }
        ax = a(view, ar, (float) i);
        if (ax < fs(view).length() - 1 && ap(view, ax + 1)) {
            ar = (int) ay(view, ar);
            if (i > ar - ((ar - ((int) as(view, ax))) / 2)) {
                ar = ax + 1;
                AppMethodBeat.o(113160);
                return ar;
            }
        }
        ar = ax;
        AppMethodBeat.o(113160);
        return ar;
    }

    private static boolean ap(View view, int i) {
        AppMethodBeat.i(113161);
        if (i <= 0 || ar(view, i) != ar(view, i - 1) + 1) {
            AppMethodBeat.o(113161);
            return false;
        }
        AppMethodBeat.o(113161);
        return true;
    }

    public static CharSequence fs(View view) {
        AppMethodBeat.i(113162);
        CharSequence dPr;
        if (view instanceof NeatTextView) {
            dPr = ((NeatTextView) view).dPr();
            AppMethodBeat.o(113162);
            return dPr;
        } else if (view instanceof TextView) {
            dPr = ((TextView) view).getText();
            AppMethodBeat.o(113162);
            return dPr;
        } else {
            dPr = "";
            AppMethodBeat.o(113162);
            return dPr;
        }
    }

    public static void a(View view, CharSequence charSequence, BufferType bufferType) {
        AppMethodBeat.i(113163);
        if (view instanceof NeatTextView) {
            ((NeatTextView) view).a(charSequence, bufferType);
            AppMethodBeat.o(113163);
            return;
        }
        if (view instanceof TextView) {
            ((TextView) view).setText(charSequence, bufferType);
        }
        AppMethodBeat.o(113163);
    }

    public static TextPaint ft(View view) {
        AppMethodBeat.i(113164);
        TextPaint paint;
        if (view instanceof NeatTextView) {
            paint = ((NeatTextView) view).getPaint();
            AppMethodBeat.o(113164);
            return paint;
        } else if (view instanceof TextView) {
            paint = ((TextView) view).getPaint();
            AppMethodBeat.o(113164);
            return paint;
        } else {
            AppMethodBeat.o(113164);
            return null;
        }
    }

    public static int aq(View view, int i) {
        AppMethodBeat.i(113165);
        int lineBaseline;
        if (view instanceof NeatTextView) {
            a layout = ((NeatTextView) view).getLayout();
            if (layout != null) {
                lineBaseline = layout.getLineBaseline(i);
                AppMethodBeat.o(113165);
                return lineBaseline;
            }
        } else if (view instanceof TextView) {
            Layout layout2 = ((TextView) view).getLayout();
            if (layout2 != null) {
                lineBaseline = layout2.getLineBaseline(i);
                AppMethodBeat.o(113165);
                return lineBaseline;
            }
        }
        AppMethodBeat.o(113165);
        return 0;
    }

    public static int ar(View view, int i) {
        AppMethodBeat.i(113166);
        int lineForOffset;
        if (view instanceof NeatTextView) {
            a layout = ((NeatTextView) view).getLayout();
            if (layout != null) {
                lineForOffset = layout.getLineForOffset(i);
                AppMethodBeat.o(113166);
                return lineForOffset;
            }
        } else if (view instanceof TextView) {
            Layout layout2 = ((TextView) view).getLayout();
            if (layout2 != null) {
                lineForOffset = layout2.getLineForOffset(i);
                AppMethodBeat.o(113166);
                return lineForOffset;
            }
        }
        AppMethodBeat.o(113166);
        return 0;
    }

    public static float as(View view, int i) {
        AppMethodBeat.i(113167);
        float primaryHorizontal;
        if (view instanceof NeatTextView) {
            a layout = ((NeatTextView) view).getLayout();
            if (layout != null) {
                primaryHorizontal = layout.getPrimaryHorizontal(i);
                AppMethodBeat.o(113167);
                return primaryHorizontal;
            }
        } else if (view instanceof TextView) {
            Layout layout2 = ((TextView) view).getLayout();
            if (layout2 != null) {
                primaryHorizontal = layout2.getPrimaryHorizontal(i);
                AppMethodBeat.o(113167);
                return primaryHorizontal;
            }
        }
        AppMethodBeat.o(113167);
        return 0.0f;
    }

    private static int a(View view, int i, float f) {
        AppMethodBeat.i(113168);
        int offsetForHorizontal;
        if (view instanceof NeatTextView) {
            a layout = ((NeatTextView) view).getLayout();
            if (layout != null) {
                offsetForHorizontal = layout.getOffsetForHorizontal(i, f);
                AppMethodBeat.o(113168);
                return offsetForHorizontal;
            }
        } else if (view instanceof TextView) {
            Layout layout2 = ((TextView) view).getLayout();
            if (layout2 != null) {
                offsetForHorizontal = layout2.getOffsetForHorizontal(i, f);
                AppMethodBeat.o(113168);
                return offsetForHorizontal;
            }
        }
        AppMethodBeat.o(113168);
        return 0;
    }

    public static int at(View view, int i) {
        AppMethodBeat.i(113169);
        int lineTop;
        if (view instanceof NeatTextView) {
            a layout = ((NeatTextView) view).getLayout();
            if (layout != null) {
                lineTop = layout.getLineTop(i);
                AppMethodBeat.o(113169);
                return lineTop;
            }
        } else if (view instanceof TextView) {
            Layout layout2 = ((TextView) view).getLayout();
            if (layout2 != null) {
                lineTop = layout2.getLineTop(i);
                AppMethodBeat.o(113169);
                return lineTop;
            }
        }
        AppMethodBeat.o(113169);
        return 0;
    }

    private static int au(View view, int i) {
        AppMethodBeat.i(113170);
        int lineBottom;
        if (view instanceof NeatTextView) {
            a layout = ((NeatTextView) view).getLayout();
            if (layout != null) {
                lineBottom = layout.getLineBottom(i);
                AppMethodBeat.o(113170);
                return lineBottom;
            }
        } else if (view instanceof TextView) {
            Layout layout2 = ((TextView) view).getLayout();
            if (layout2 != null) {
                lineBottom = layout2.getLineBottom(i);
                AppMethodBeat.o(113170);
                return lineBottom;
            }
        }
        AppMethodBeat.o(113170);
        return 0;
    }

    public static float av(View view, int i) {
        AppMethodBeat.i(113171);
        float lineWidth;
        if (view instanceof NeatTextView) {
            a layout = ((NeatTextView) view).getLayout();
            if (layout != null) {
                lineWidth = layout.getLineWidth(i);
                AppMethodBeat.o(113171);
                return lineWidth;
            }
        } else if (view instanceof TextView) {
            Layout layout2 = ((TextView) view).getLayout();
            if (layout2 != null) {
                lineWidth = layout2.getLineWidth(i);
                AppMethodBeat.o(113171);
                return lineWidth;
            }
        }
        AppMethodBeat.o(113171);
        return 0.0f;
    }

    public static int aw(View view, int i) {
        AppMethodBeat.i(113172);
        int lineStart;
        if (view instanceof NeatTextView) {
            a layout = ((NeatTextView) view).getLayout();
            if (layout != null) {
                lineStart = layout.getLineStart(i);
                AppMethodBeat.o(113172);
                return lineStart;
            }
        } else if (view instanceof TextView) {
            Layout layout2 = ((TextView) view).getLayout();
            if (layout2 != null) {
                lineStart = layout2.getLineStart(i);
                AppMethodBeat.o(113172);
                return lineStart;
            }
        }
        AppMethodBeat.o(113172);
        return 0;
    }

    private static int ax(View view, int i) {
        AppMethodBeat.i(113173);
        int lineForVertical;
        if (view instanceof NeatTextView) {
            a layout = ((NeatTextView) view).getLayout();
            if (layout != null) {
                lineForVertical = layout.getLineForVertical(i);
                AppMethodBeat.o(113173);
                return lineForVertical;
            }
        } else if (view instanceof TextView) {
            Layout layout2 = ((TextView) view).getLayout();
            if (layout2 != null) {
                lineForVertical = layout2.getLineForVertical(i);
                AppMethodBeat.o(113173);
                return lineForVertical;
            }
        }
        AppMethodBeat.o(113173);
        return 0;
    }

    private static float ay(View view, int i) {
        AppMethodBeat.i(113174);
        float lineRight;
        if (view instanceof NeatTextView) {
            a layout = ((NeatTextView) view).getLayout();
            if (layout != null) {
                lineRight = layout.getLineRight(i);
                AppMethodBeat.o(113174);
                return lineRight;
            }
        } else if (view instanceof TextView) {
            Layout layout2 = ((TextView) view).getLayout();
            if (layout2 != null) {
                lineRight = layout2.getLineRight(i);
                AppMethodBeat.o(113174);
                return lineRight;
            }
        }
        AppMethodBeat.o(113174);
        return 0.0f;
    }
}
