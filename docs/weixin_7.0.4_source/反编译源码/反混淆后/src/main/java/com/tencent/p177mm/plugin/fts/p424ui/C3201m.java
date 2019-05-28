package com.tencent.p177mm.plugin.fts.p424ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C34204f;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C43121f;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C3159c.C3160a;
import com.tencent.p177mm.plugin.fts.p424ui.C45976b.C20875a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.fts.ui.m */
public final class C3201m {

    /* renamed from: com.tencent.mm.plugin.fts.ui.m$2 */
    static class C32022 implements Comparator<C43121f> {
        C32022() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((C43121f) obj2).mDW - ((C43121f) obj).mDW;
        }
    }

    /* renamed from: a */
    public static boolean m5501a(CharSequence charSequence, TextView textView) {
        AppMethodBeat.m2504i(61956);
        if (charSequence == null || charSequence.length() == 0) {
            textView.setVisibility(8);
            AppMethodBeat.m2505o(61956);
            return false;
        }
        textView.setText(charSequence, BufferType.SPANNABLE);
        textView.setVisibility(0);
        AppMethodBeat.m2505o(61956);
        return true;
    }

    /* renamed from: b */
    public static boolean m5502b(String str, TextView textView) {
        AppMethodBeat.m2504i(61957);
        if (str == null || str.length() == 0) {
            textView.setVisibility(8);
            AppMethodBeat.m2505o(61957);
            return false;
        }
        textView.setText(str);
        textView.setVisibility(0);
        AppMethodBeat.m2505o(61957);
        return true;
    }

    /* renamed from: a */
    public static void m5499a(Context context, ImageView imageView, String str, String str2, int i) {
        AppMethodBeat.m2504i(61958);
        C3201m.m5500a(context, imageView, str, str2, i, true, 0, 0);
        AppMethodBeat.m2505o(61958);
    }

    /* renamed from: a */
    public static void m5500a(Context context, ImageView imageView, String str, String str2, int i, boolean z, int i2, int i3) {
        AppMethodBeat.m2504i(61959);
        ((C12029n) C1720g.m3530M(C12029n.class)).getFTSImageLoader().mo7426a(imageView, str, str2, z, i2, i3);
        if (!C5046bo.isNullOrNil(str) || !C5046bo.isNullOrNil(str2)) {
            Bitmap a = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSImageLoader().mo7425a(str, str2, z, i2, i3);
            if (a == null || a.isRecycled()) {
                if (i > 0) {
                    imageView.setImageResource(i);
                } else {
                    imageView.setImageResource(C25738R.color.a3p);
                }
                ((C12029n) C1720g.m3530M(C12029n.class)).getFTSImageLoader().mo7427a(context, imageView, str, str2, z, i2, i3);
            } else {
                C3160a.m5397a(context.getResources(), a, imageView);
            }
            imageView.setVisibility(0);
            AppMethodBeat.m2505o(61959);
        } else if (i <= 0 || (C5046bo.isNullOrNil(str) && C5046bo.isNullOrNil(str2))) {
            imageView.setVisibility(8);
            AppMethodBeat.m2505o(61959);
        } else {
            imageView.setImageResource(i);
            AppMethodBeat.m2505o(61959);
        }
    }

    /* renamed from: wf */
    public static String m5505wf(int i) {
        AppMethodBeat.m2504i(61960);
        int i2 = 0;
        switch (i) {
            case -15:
                i2 = C25738R.string.c1s;
                break;
            case -13:
                i2 = C25738R.string.c21;
                break;
            case -11:
                i2 = C25738R.string.c1t;
                break;
            case -8:
                i2 = C25738R.string.c20;
                break;
            case -7:
                i2 = C25738R.string.c1p;
                break;
            case -6:
                i2 = C25738R.string.c1o;
                break;
            case -5:
                i2 = C25738R.string.c1q;
                break;
            case -4:
                i2 = C25738R.string.c1k;
                break;
            case -3:
                i2 = C25738R.string.c1j;
                break;
            case -2:
                i2 = C25738R.string.c1r;
                break;
            case -1:
                i2 = C25738R.string.c1n;
                break;
        }
        if (i2 == 0) {
            AppMethodBeat.m2505o(61960);
            return null;
        }
        String string = C4996ah.getContext().getString(i2);
        AppMethodBeat.m2505o(61960);
        return string;
    }

    /* JADX WARNING: Missing block: B:12:0x005c, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r0.mDU) != false) goto L_0x006e;
     */
    /* JADX WARNING: Missing block: B:14:0x0066, code skipped:
            if (r0.mDU.contains(r13.mDY) == false) goto L_0x006e;
     */
    /* JADX WARNING: Missing block: B:15:0x0068, code skipped:
            r0.mDW += 10;
     */
    /* JADX WARNING: Missing block: B:19:0x0081, code skipped:
            r0.mDA = true;
     */
    /* JADX WARNING: Missing block: B:20:0x0083, code skipped:
            r0.mDU = r1.field_nickname;
     */
    /* JADX WARNING: Missing block: B:21:0x008d, code skipped:
            if (r1.field_nickname.equals(r6) != false) goto L_0x0056;
     */
    /* JADX WARNING: Missing block: B:22:0x008f, code skipped:
            r0.mDV = r6;
     */
    /* JADX WARNING: Missing block: B:24:0x0094, code skipped:
            r0.mDA = true;
     */
    /* JADX WARNING: Missing block: B:25:0x0096, code skipped:
            r0.mDU = r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static CharSequence m5498a(Context context, List<C43121f> list, String[] strArr, C20840g c20840g, TextPaint textPaint) {
        C43121f c43121f;
        AppMethodBeat.m2504i(61961);
        final C12029n c12029n = (C12029n) C1720g.m3530M(C12029n.class);
        Arrays.sort(strArr, new Comparator<String>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.m2504i(61955);
                int stringCompareUtfBinary = c12029n.stringCompareUtfBinary((String) obj, (String) obj2);
                AppMethodBeat.m2505o(61955);
                return stringCompareUtfBinary;
            }
        });
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            c43121f = (C43121f) list.get(i);
            if (c43121f.mDS < strArr.length) {
                String str = strArr[c43121f.mDS];
                if (!C5046bo.isNullOrNil(str)) {
                    C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
                    if (aoO != null) {
                        str = aoO.field_username;
                        String a = C1855t.m3879a(aoO, str);
                        switch (c43121f.mDw) {
                            case 29:
                                break;
                            case 30:
                                break;
                            case 31:
                                c43121f.mDX = true;
                                break;
                            case 32:
                                c43121f.mDU = aoO.dul;
                                c43121f.mDV = a;
                                break;
                            case 33:
                                c43121f.mDU = c43121f.content;
                                c43121f.mDV = a;
                                break;
                            case 34:
                                break;
                            case 35:
                                break;
                            case 36:
                                c43121f.mDX = true;
                                break;
                            case C2275g.CTRL_INDEX /*37*/:
                                c43121f.mDU = C3161d.m5415eu(str, aoO.mo14673Hq());
                                c43121f.mDV = a;
                                break;
                        }
                    }
                }
            }
        }
        Collections.sort(list, new C32022());
        int i2 = 0;
        float f = 0.0f;
        while (i2 < list.size() && i2 < c20840g.mEa.length) {
            f = ((float) (C20875a.mHq - 100)) - f;
            if (f > 100.0f) {
                c43121f = (C43121f) list.get(i2);
                SpannableString b = C44089j.m79293b(context, c43121f.mDU, textPaint.getTextSize());
                if (spannableStringBuilder.length() > 0) {
                    spannableStringBuilder.append(", ");
                }
                C39127d c39127d = new C39127d();
                c39127d.mDy = b;
                c39127d.mDz = c20840g;
                c39127d.mDA = c43121f.mDA;
                c39127d.mDC = c43121f.mDX;
                c39127d.mDF = f;
                c39127d.eNN = textPaint;
                if (!C5046bo.isNullOrNil(c43121f.mDV)) {
                    SpannableString b2 = C44089j.m79293b(context, c43121f.mDV, textPaint.getTextSize());
                    c39127d.mDG = TextUtils.concat(new CharSequence[]{b2, "("});
                    c39127d.mDH = ")";
                }
                spannableStringBuilder.append(C34204f.m56086a(c39127d).mDR);
                f = textPaint.measureText(spannableStringBuilder.toString());
                i2++;
            }
        }
        AppMethodBeat.m2505o(61961);
        return spannableStringBuilder;
    }

    /* renamed from: p */
    public static final void m5503p(View view, boolean z) {
        AppMethodBeat.m2504i(61962);
        if (z) {
            view.setBackgroundResource(C25738R.drawable.f6623k5);
            AppMethodBeat.m2505o(61962);
            return;
        }
        view.setBackgroundResource(C25738R.drawable.f6625k7);
        AppMethodBeat.m2505o(61962);
    }

    /* renamed from: q */
    public static final void m5504q(View view, boolean z) {
        AppMethodBeat.m2504i(61963);
        if (z) {
            view.setBackgroundResource(C25738R.drawable.a_q);
            AppMethodBeat.m2505o(61963);
            return;
        }
        view.setBackgroundResource(C25738R.drawable.f6900uv);
        AppMethodBeat.m2505o(61963);
    }

    /* renamed from: a */
    public static int m5497a(JSONObject jSONObject, String str, Context context) {
        AppMethodBeat.m2504i(61964);
        int optInt = jSONObject == null ? 0 : jSONObject.optInt("businessType");
        if (optInt == 0) {
            if (str.equals(context.getString(C25738R.string.e0b))) {
                optInt = 2;
            } else if (str.equals(context.getString(C25738R.string.e0f))) {
                optInt = 8;
            } else if (str.equals(context.getString(C25738R.string.e0c))) {
                optInt = 1;
            } else {
                C4990ab.m7416i("MicroMsg.FTS.FTSUIApiLogic", "option " + str + " no type");
            }
        }
        AppMethodBeat.m2505o(61964);
        return optInt;
    }
}
