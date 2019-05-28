package com.tencent.p177mm.plugin.emojicapture.p389ui;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.emoji.p1598e.C41953a;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.smtt.sdk.WebView;
import p000a.C0220l;
import p000a.p001a.C36913i;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\u000e\u0010\u000b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001\u001a\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001\u001a\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\u0001*\u00020\u0012\u001a\n\u0010\u0013\u001a\u00020\u0001*\u00020\u0012\u001a\n\u0010\u0014\u001a\u00020\u0001*\u00020\u0012\u001a\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00012\b\b\u0002\u0010\u0019\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u001a"}, dWq = {"DEFAULT_STROKE_COLOR", "", "DEFAULT_TEXT_COLOR", "STROKE_COLORS", "", "getSTROKE_COLORS", "()[I", "TEXT_COLORS", "getTEXT_COLORS", "findStrokeColor", "textColor", "findTextColor", "isRedPackageScene", "", "scene", "waitUploading", "waitingMixing", "getIconNorColor", "Landroid/view/View;", "getIconSelColor", "getTextColor", "setSvgDrawable", "", "Landroid/widget/ImageView;", "resId", "color", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.ui.a */
public final class C20443a {
    private static final int[] lln = new int[]{-1, WebView.NIGHT_MODE_COLOR, -314573, -12493, -4920114, -4724993, -144437};
    private static final int[] llo = new int[]{WebView.NIGHT_MODE_COLOR, -1, -15616, -2724096, -16339626, -15954996, -298125};

    public static final int[] bnQ() {
        return lln;
    }

    public static final int[] bnR() {
        return llo;
    }

    /* renamed from: uA */
    public static final int m31594uA(int i) {
        int i2;
        Integer num;
        int i3 = 1;
        AppMethodBeat.m2504i(2889);
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
            int J = C36913i.m61676J(iArr);
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
            AppMethodBeat.m2505o(2889);
            return i2;
        }
        AppMethodBeat.m2505o(2889);
        return -1;
    }

    /* renamed from: uB */
    public static final int m31595uB(int i) {
        AppMethodBeat.m2504i(2890);
        int k = C36913i.m61701k(lln, i);
        if (k < 0) {
            AppMethodBeat.m2505o(2890);
            return WebView.NIGHT_MODE_COLOR;
        }
        k = llo[k];
        AppMethodBeat.m2505o(2890);
        return k;
    }

    /* renamed from: dg */
    public static final int m31592dg(View view) {
        AppMethodBeat.m2504i(2891);
        C25052j.m39376p(view, "receiver$0");
        Context context = view.getContext();
        C25052j.m39375o(context, "context");
        int color = context.getResources().getColor(C41953a.m74099y(view.getContext(), C25738R.attr.f5682fn));
        AppMethodBeat.m2505o(2891);
        return color;
    }

    /* renamed from: dh */
    public static final int m31593dh(View view) {
        AppMethodBeat.m2504i(2892);
        C25052j.m39376p(view, "receiver$0");
        Context context = view.getContext();
        C25052j.m39375o(context, "context");
        int color = context.getResources().getColor(C25738R.color.f11625j);
        AppMethodBeat.m2505o(2892);
        return color;
    }

    /* renamed from: a */
    public static final void m31591a(ImageView imageView, int i) {
        AppMethodBeat.m2504i(2893);
        C25052j.m39376p(imageView, "receiver$0");
        imageView.setImageDrawable(C5225ah.m7962f(imageView.getContext(), C1318a.icons_outlined_no_effect, i));
        AppMethodBeat.m2505o(2893);
    }

    /* renamed from: uD */
    public static final boolean m31597uD(int i) {
        AppMethodBeat.m2504i(2894);
        if (C20443a.m31596uC(i) && (i == 4 || i == 5)) {
            AppMethodBeat.m2505o(2894);
            return true;
        }
        AppMethodBeat.m2505o(2894);
        return false;
    }

    /* renamed from: uC */
    public static final boolean m31596uC(int i) {
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
