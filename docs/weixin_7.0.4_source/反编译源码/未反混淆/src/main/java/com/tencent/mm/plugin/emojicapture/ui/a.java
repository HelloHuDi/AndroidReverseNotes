package com.tencent.mm.plugin.emojicapture.ui;

import a.a.i;
import a.f.b.j;
import a.l;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.ah;
import com.tencent.smtt.sdk.WebView;

@l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\u000e\u0010\u000b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001\u001a\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001\u001a\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\u0001*\u00020\u0012\u001a\n\u0010\u0013\u001a\u00020\u0001*\u00020\u0012\u001a\n\u0010\u0014\u001a\u00020\u0001*\u00020\u0012\u001a\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00012\b\b\u0002\u0010\u0019\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u001a"}, dWq = {"DEFAULT_STROKE_COLOR", "", "DEFAULT_TEXT_COLOR", "STROKE_COLORS", "", "getSTROKE_COLORS", "()[I", "TEXT_COLORS", "getTEXT_COLORS", "findStrokeColor", "textColor", "findTextColor", "isRedPackageScene", "", "scene", "waitUploading", "waitingMixing", "getIconNorColor", "Landroid/view/View;", "getIconSelColor", "getTextColor", "setSvgDrawable", "", "Landroid/widget/ImageView;", "resId", "color", "plugin-emojicapture_release"})
public final class a {
    private static final int[] lln = new int[]{-1, WebView.NIGHT_MODE_COLOR, -314573, -12493, -4920114, -4724993, -144437};
    private static final int[] llo = new int[]{WebView.NIGHT_MODE_COLOR, -1, -15616, -2724096, -16339626, -15954996, -298125};

    public static final int[] bnQ() {
        return lln;
    }

    public static final int[] bnR() {
        return llo;
    }

    public static final int uA(int i) {
        int i2;
        Integer num;
        int i3 = 1;
        AppMethodBeat.i(2889);
        int[] iArr = lln;
        if (iArr.length == 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            num = null;
        } else {
            int i4 = iArr[0];
            i2 = Color.red(i) - Color.red(i4);
            int green = Color.green(i) - Color.green(i4);
            int blue = Color.blue(i) - Color.blue(i4);
            double sqrt = Math.sqrt((double) (((i2 * i2) + (green * green)) + (blue * blue)));
            int J = i.J(iArr);
            if (J > 0) {
                while (true) {
                    int i5 = iArr[i3];
                    blue = Color.red(i) - Color.red(i5);
                    int green2 = Color.green(i) - Color.green(i5);
                    int blue2 = Color.blue(i) - Color.blue(i5);
                    double sqrt2 = Math.sqrt((double) (((blue * blue) + (green2 * green2)) + (blue2 * blue2)));
                    if (Double.compare(sqrt, sqrt2) > 0) {
                        sqrt = sqrt2;
                        i4 = i5;
                    }
                    if (i3 == J) {
                        break;
                    }
                    i3++;
                }
            }
            num = Integer.valueOf(i4);
        }
        if (num != null) {
            i2 = num.intValue();
            AppMethodBeat.o(2889);
            return i2;
        }
        AppMethodBeat.o(2889);
        return -1;
    }

    public static final int uB(int i) {
        AppMethodBeat.i(2890);
        int k = i.k(lln, i);
        if (k < 0) {
            AppMethodBeat.o(2890);
            return WebView.NIGHT_MODE_COLOR;
        }
        k = llo[k];
        AppMethodBeat.o(2890);
        return k;
    }

    public static final int dg(View view) {
        AppMethodBeat.i(2891);
        j.p(view, "receiver$0");
        Context context = view.getContext();
        j.o(context, "context");
        int color = context.getResources().getColor(com.tencent.mm.emoji.e.a.y(view.getContext(), R.attr.fn));
        AppMethodBeat.o(2891);
        return color;
    }

    public static final int dh(View view) {
        AppMethodBeat.i(2892);
        j.p(view, "receiver$0");
        Context context = view.getContext();
        j.o(context, "context");
        int color = context.getResources().getColor(R.color.j);
        AppMethodBeat.o(2892);
        return color;
    }

    public static final void a(ImageView imageView, int i) {
        AppMethodBeat.i(2893);
        j.p(imageView, "receiver$0");
        imageView.setImageDrawable(ah.f(imageView.getContext(), R.raw.icons_outlined_no_effect, i));
        AppMethodBeat.o(2893);
    }

    public static final boolean uD(int i) {
        AppMethodBeat.i(2894);
        if (uC(i) && (i == 4 || i == 5)) {
            AppMethodBeat.o(2894);
            return true;
        }
        AppMethodBeat.o(2894);
        return false;
    }

    public static final boolean uC(int i) {
        switch (i) {
            case 3:
            case 4:
            case 5:
                return true;
            default:
                return false;
        }
    }
}
