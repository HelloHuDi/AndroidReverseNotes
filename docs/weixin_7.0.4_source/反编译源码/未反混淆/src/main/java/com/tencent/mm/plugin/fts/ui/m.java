package com.tencent.mm.plugin.fts.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.c.a;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONObject;

public final class m {
    public static boolean a(CharSequence charSequence, TextView textView) {
        AppMethodBeat.i(61956);
        if (charSequence == null || charSequence.length() == 0) {
            textView.setVisibility(8);
            AppMethodBeat.o(61956);
            return false;
        }
        textView.setText(charSequence, BufferType.SPANNABLE);
        textView.setVisibility(0);
        AppMethodBeat.o(61956);
        return true;
    }

    public static boolean b(String str, TextView textView) {
        AppMethodBeat.i(61957);
        if (str == null || str.length() == 0) {
            textView.setVisibility(8);
            AppMethodBeat.o(61957);
            return false;
        }
        textView.setText(str);
        textView.setVisibility(0);
        AppMethodBeat.o(61957);
        return true;
    }

    public static void a(Context context, ImageView imageView, String str, String str2, int i) {
        AppMethodBeat.i(61958);
        a(context, imageView, str, str2, i, true, 0, 0);
        AppMethodBeat.o(61958);
    }

    public static void a(Context context, ImageView imageView, String str, String str2, int i, boolean z, int i2, int i3) {
        AppMethodBeat.i(61959);
        ((n) g.M(n.class)).getFTSImageLoader().a(imageView, str, str2, z, i2, i3);
        if (!bo.isNullOrNil(str) || !bo.isNullOrNil(str2)) {
            Bitmap a = ((n) g.M(n.class)).getFTSImageLoader().a(str, str2, z, i2, i3);
            if (a == null || a.isRecycled()) {
                if (i > 0) {
                    imageView.setImageResource(i);
                } else {
                    imageView.setImageResource(R.color.a3p);
                }
                ((n) g.M(n.class)).getFTSImageLoader().a(context, imageView, str, str2, z, i2, i3);
            } else {
                a.a(context.getResources(), a, imageView);
            }
            imageView.setVisibility(0);
            AppMethodBeat.o(61959);
        } else if (i <= 0 || (bo.isNullOrNil(str) && bo.isNullOrNil(str2))) {
            imageView.setVisibility(8);
            AppMethodBeat.o(61959);
        } else {
            imageView.setImageResource(i);
            AppMethodBeat.o(61959);
        }
    }

    public static String wf(int i) {
        AppMethodBeat.i(61960);
        int i2 = 0;
        switch (i) {
            case -15:
                i2 = R.string.c1s;
                break;
            case -13:
                i2 = R.string.c21;
                break;
            case -11:
                i2 = R.string.c1t;
                break;
            case -8:
                i2 = R.string.c20;
                break;
            case -7:
                i2 = R.string.c1p;
                break;
            case -6:
                i2 = R.string.c1o;
                break;
            case -5:
                i2 = R.string.c1q;
                break;
            case -4:
                i2 = R.string.c1k;
                break;
            case -3:
                i2 = R.string.c1j;
                break;
            case -2:
                i2 = R.string.c1r;
                break;
            case -1:
                i2 = R.string.c1n;
                break;
        }
        if (i2 == 0) {
            AppMethodBeat.o(61960);
            return null;
        }
        String string = ah.getContext().getString(i2);
        AppMethodBeat.o(61960);
        return string;
    }

    /* JADX WARNING: Missing block: B:12:0x005c, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(r0.mDU) != false) goto L_0x006e;
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
    public static CharSequence a(Context context, List<f> list, String[] strArr, com.tencent.mm.plugin.fts.a.a.g gVar, TextPaint textPaint) {
        f fVar;
        AppMethodBeat.i(61961);
        final n nVar = (n) g.M(n.class);
        Arrays.sort(strArr, new Comparator<String>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.i(61955);
                int stringCompareUtfBinary = nVar.stringCompareUtfBinary((String) obj, (String) obj2);
                AppMethodBeat.o(61955);
                return stringCompareUtfBinary;
            }
        });
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            fVar = (f) list.get(i);
            if (fVar.mDS < strArr.length) {
                String str = strArr[fVar.mDS];
                if (!bo.isNullOrNil(str)) {
                    ad aoO = ((j) g.K(j.class)).XM().aoO(str);
                    if (aoO != null) {
                        str = aoO.field_username;
                        String a = t.a(aoO, str);
                        switch (fVar.mDw) {
                            case 29:
                                break;
                            case 30:
                                break;
                            case 31:
                                fVar.mDX = true;
                                break;
                            case 32:
                                fVar.mDU = aoO.dul;
                                fVar.mDV = a;
                                break;
                            case 33:
                                fVar.mDU = fVar.content;
                                fVar.mDV = a;
                                break;
                            case 34:
                                break;
                            case 35:
                                break;
                            case 36:
                                fVar.mDX = true;
                                break;
                            case com.tencent.mm.plugin.appbrand.jsapi.e.g.CTRL_INDEX /*37*/:
                                fVar.mDU = d.eu(str, aoO.Hq());
                                fVar.mDV = a;
                                break;
                        }
                    }
                }
            }
        }
        Collections.sort(list, new Comparator<f>() {
            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return ((f) obj2).mDW - ((f) obj).mDW;
            }
        });
        int i2 = 0;
        float f = 0.0f;
        while (i2 < list.size() && i2 < gVar.mEa.length) {
            f = ((float) (b.a.mHq - 100)) - f;
            if (f > 100.0f) {
                fVar = (f) list.get(i2);
                SpannableString b = com.tencent.mm.pluginsdk.ui.e.j.b(context, fVar.mDU, textPaint.getTextSize());
                if (spannableStringBuilder.length() > 0) {
                    spannableStringBuilder.append(", ");
                }
                com.tencent.mm.plugin.fts.a.a.d dVar = new com.tencent.mm.plugin.fts.a.a.d();
                dVar.mDy = b;
                dVar.mDz = gVar;
                dVar.mDA = fVar.mDA;
                dVar.mDC = fVar.mDX;
                dVar.mDF = f;
                dVar.eNN = textPaint;
                if (!bo.isNullOrNil(fVar.mDV)) {
                    SpannableString b2 = com.tencent.mm.pluginsdk.ui.e.j.b(context, fVar.mDV, textPaint.getTextSize());
                    dVar.mDG = TextUtils.concat(new CharSequence[]{b2, "("});
                    dVar.mDH = ")";
                }
                spannableStringBuilder.append(com.tencent.mm.plugin.fts.a.f.a(dVar).mDR);
                f = textPaint.measureText(spannableStringBuilder.toString());
                i2++;
            }
        }
        AppMethodBeat.o(61961);
        return spannableStringBuilder;
    }

    public static final void p(View view, boolean z) {
        AppMethodBeat.i(61962);
        if (z) {
            view.setBackgroundResource(R.drawable.k5);
            AppMethodBeat.o(61962);
            return;
        }
        view.setBackgroundResource(R.drawable.k7);
        AppMethodBeat.o(61962);
    }

    public static final void q(View view, boolean z) {
        AppMethodBeat.i(61963);
        if (z) {
            view.setBackgroundResource(R.drawable.a_q);
            AppMethodBeat.o(61963);
            return;
        }
        view.setBackgroundResource(R.drawable.uv);
        AppMethodBeat.o(61963);
    }

    public static int a(JSONObject jSONObject, String str, Context context) {
        AppMethodBeat.i(61964);
        int optInt = jSONObject == null ? 0 : jSONObject.optInt("businessType");
        if (optInt == 0) {
            if (str.equals(context.getString(R.string.e0b))) {
                optInt = 2;
            } else if (str.equals(context.getString(R.string.e0f))) {
                optInt = 8;
            } else if (str.equals(context.getString(R.string.e0c))) {
                optInt = 1;
            } else {
                ab.i("MicroMsg.FTS.FTSUIApiLogic", "option " + str + " no type");
            }
        }
        AppMethodBeat.o(61964);
        return optInt;
    }
}
