package com.tencent.mm.plugin.fts.a;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.d.a;
import com.tencent.mm.plugin.fts.a.a.d.b;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.g.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class f {
    public static final e a(String str, String str2, d dVar) {
        AppMethodBeat.i(114218);
        e a = a(dVar);
        a.mDR = TextUtils.concat(new CharSequence[]{str, a.mDR, str2});
        AppMethodBeat.o(114218);
        return a;
    }

    public static final SpannableString j(CharSequence charSequence, int i) {
        AppMethodBeat.i(114219);
        SpannableString spannableString = new SpannableString(charSequence);
        b bVar = new b();
        bVar.mDP = 0;
        bVar.mDQ = i;
        b(spannableString, bVar, new d());
        AppMethodBeat.o(114219);
        return spannableString;
    }

    public static final e a(d dVar) {
        int i;
        int i2 = 1;
        AppMethodBeat.i(114220);
        e eVar = new e();
        Spannable spannableString = new SpannableString(TextUtils.concat(new CharSequence[]{dVar.mDG, dVar.mDy, dVar.mDH}));
        eVar.bFZ = -1;
        eVar.mDR = spannableString;
        if (bo.ac(dVar.mDy) || dVar.mDz == null) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            AppMethodBeat.o(114220);
            return eVar;
        }
        List aM;
        Object aM2;
        String Nb = d.Nb(dVar.mDy.toString());
        ArrayList arrayList = new ArrayList();
        if (dVar.mDA) {
            aM2 = aM(Nb, dVar.mDC);
        } else {
            aM2 = arrayList;
        }
        b bVar;
        e b;
        if (dVar.mDz.mEc.size() == 1 || a(spannableString, dVar)) {
            bVar = new b();
            if (dVar.mDz.mEc.size() == 1) {
                bVar.mDO = (c) dVar.mDz.mEc.get(0);
                if (dVar.mDA) {
                    a(aM2, bVar, dVar);
                } else {
                    a(Nb, bVar, dVar);
                }
                if (bVar.isAvailable()) {
                    try {
                        b = b(spannableString, bVar, dVar);
                    } catch (Exception e) {
                        eVar.mDR = spannableString;
                        b = eVar;
                    }
                    AppMethodBeat.o(114220);
                    return b;
                }
                AppMethodBeat.o(114220);
                return eVar;
            }
            bVar.mDO = (c) dVar.mDz.mEc.get(0);
            if (dVar.mDA) {
                a(aM2, bVar, dVar);
            } else {
                a(Nb, bVar, dVar);
            }
            if (bVar.isAvailable()) {
                try {
                    eVar = b(spannableString, bVar, dVar);
                } catch (Exception e2) {
                    eVar.mDR = spannableString;
                }
            }
            String charSequence = eVar.mDR.toString();
            arrayList = new ArrayList();
            if (dVar.mDA) {
                aM2 = aM(charSequence, dVar.mDC);
            } else {
                aM2 = arrayList;
            }
            while (i2 < dVar.mDz.mEc.size()) {
                bVar.mDO = (c) dVar.mDz.mEc.get(i2);
                if (dVar.mDA) {
                    a(aM2, bVar, dVar);
                } else {
                    a(charSequence, bVar, dVar);
                }
                if (bVar.isAvailable()) {
                    try {
                        eVar = b((Spannable) eVar.mDR, bVar, dVar);
                    } catch (Exception e3) {
                        eVar.mDR = spannableString;
                    }
                }
                i2++;
            }
            AppMethodBeat.o(114220);
            return eVar;
        }
        b bVar2 = new b();
        bVar2.mDO = new c();
        g.b bVar3 = new g.b();
        bVar3.mEe = g.d.OTHER;
        bVar3.content = dVar.mDz.mDZ;
        bVar2.mDO.mEg.add(bVar3);
        if (dVar.mDA) {
            a(aM2, bVar2, dVar);
        } else {
            a(Nb, bVar2, dVar);
        }
        if (bVar2.isAvailable()) {
            try {
                eVar = b(spannableString, bVar2, dVar);
            } catch (Exception e4) {
                eVar.mDR = spannableString;
            }
            AppMethodBeat.o(114220);
            return eVar;
        }
        ArrayList<b> arrayList2 = new ArrayList();
        for (c cVar : dVar.mDz.mEc) {
            bVar = new b();
            bVar.mDO = cVar;
            arrayList2.add(bVar);
        }
        for (b bVar22 : arrayList2) {
            if (dVar.mDA) {
                a(aM2, bVar22, dVar);
            } else {
                a(Nb, bVar22, dVar);
            }
        }
        for (b bVar222 : arrayList2) {
            if (bVar222.isAvailable()) {
                b = b(spannableString, bVar222, dVar);
                if (b.bFZ == 0) {
                    eVar = b;
                }
            }
        }
        AppMethodBeat.o(114220);
        return eVar;
    }

    private static boolean a(Spannable spannable, d dVar) {
        AppMethodBeat.i(114221);
        if (dVar.mDF <= 0.0f || dVar.eNN == null) {
            AppMethodBeat.o(114221);
            return false;
        } else if (dVar.mDF - (dVar.eNN.getTextSize() * 2.0f) < dVar.eNN.measureText(spannable.toString())) {
            AppMethodBeat.o(114221);
            return true;
        } else {
            AppMethodBeat.o(114221);
            return false;
        }
    }

    private static e a(Spannable spannable, b bVar, d dVar) {
        AppMethodBeat.i(114222);
        e eVar = new e();
        float textSize = dVar.mDF - (dVar.eNN.getTextSize() * 2.0f);
        float measureText = dVar.eNN.measureText("…");
        float measureText2 = dVar.eNN.measureText(spannable, 0, bVar.mDP);
        float measureText3 = dVar.eNN.measureText(spannable, bVar.mDP, bVar.mDQ);
        float measureText4 = dVar.eNN.measureText(spannable, bVar.mDQ, spannable.length());
        if ((measureText2 + measureText3) + measureText4 < textSize) {
            e c = c(spannable, bVar, dVar);
            AppMethodBeat.o(114222);
            return c;
        }
        CharSequence spannableString;
        CharSequence subSequence = spannable.subSequence(bVar.mDP, bVar.mDQ);
        if (dVar.mDD == a.CustomTag) {
            spannableString = new SpannableString(TextUtils.concat(new CharSequence[]{dVar.mDI, subSequence, dVar.mDJ}));
        } else {
            Object backgroundColorSpan;
            if (dVar.mDD == a.Background) {
                backgroundColorSpan = new BackgroundColorSpan(dVar.mDE);
            } else {
                backgroundColorSpan = new ForegroundColorSpan(dVar.mDE);
            }
            CharSequence spannableString2 = new SpannableString(subSequence);
            try {
                spannableString2.setSpan(backgroundColorSpan, 0, spannableString2.length(), 33);
                spannableString = spannableString2;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.FTS.FTSUIHLLogic", e, "setSpan %s", bVar.toString());
                eVar.bFZ = -1;
                eVar.mDR = spannable;
                AppMethodBeat.o(114222);
                return eVar;
            }
        }
        SpannableStringBuilder spannableStringBuilder;
        if ((measureText2 + measureText3) + measureText < textSize) {
            spannableStringBuilder = new SpannableStringBuilder(spannable, 0, bVar.mDP);
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append(TextUtils.ellipsize(spannable.subSequence(bVar.mDQ, spannable.length()), dVar.eNN, (textSize - measureText2) - measureText3, TruncateAt.END));
            eVar.mDR = spannableStringBuilder;
        } else if ((measureText + measureText3) + measureText4 < textSize) {
            spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(TextUtils.ellipsize(spannable.subSequence(0, bVar.mDP), dVar.eNN, (textSize - measureText3) - measureText4, TruncateAt.START));
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append(spannable, bVar.mDQ, spannable.length());
            eVar.mDR = spannableStringBuilder;
        } else if ((measureText + measureText3) + measureText >= textSize) {
            spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(TextUtils.ellipsize(spannableString, dVar.eNN, textSize, TruncateAt.END));
            eVar.mDR = spannableStringBuilder;
        } else {
            spannableStringBuilder = new SpannableStringBuilder();
            textSize = (textSize - measureText3) / 2.0f;
            CharSequence subSequence2 = spannable.subSequence(0, bVar.mDP);
            CharSequence subSequence3 = spannable.subSequence(bVar.mDQ, spannable.length());
            spannableStringBuilder.append(TextUtils.ellipsize(subSequence2, dVar.eNN, textSize, TruncateAt.START));
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append(TextUtils.ellipsize(subSequence3, dVar.eNN, textSize, TruncateAt.END));
            eVar.mDR = spannableStringBuilder;
        }
        eVar.bFZ = 0;
        AppMethodBeat.o(114222);
        return eVar;
    }

    private static e b(Spannable spannable, b bVar, d dVar) {
        AppMethodBeat.i(114223);
        e a;
        if (a(spannable, dVar)) {
            a = a(spannable, bVar, dVar);
            AppMethodBeat.o(114223);
            return a;
        }
        a = c(spannable, bVar, dVar);
        AppMethodBeat.o(114223);
        return a;
    }

    private static e c(Spannable spannable, b bVar, d dVar) {
        AppMethodBeat.i(114224);
        e eVar = new e();
        if (dVar.mDD == a.CustomTag) {
            String obj = spannable.toString();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(obj.substring(0, bVar.mDP));
            stringBuffer.append(dVar.mDI);
            stringBuffer.append(obj.substring(bVar.mDP, bVar.mDQ));
            stringBuffer.append(dVar.mDJ);
            if (bVar.mDQ < obj.length()) {
                stringBuffer.append(obj.substring(bVar.mDQ, obj.length()));
            }
            eVar.mDR = stringBuffer.toString();
            eVar.bFZ = 0;
        } else {
            Object backgroundColorSpan;
            if (dVar.mDD == a.Background) {
                backgroundColorSpan = new BackgroundColorSpan(dVar.mDE);
            } else {
                backgroundColorSpan = new ForegroundColorSpan(dVar.mDE);
            }
            try {
                spannable.setSpan(backgroundColorSpan, bVar.mDP, bVar.mDQ, 18);
                eVar.mDR = spannable;
                eVar.bFZ = 0;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.FTS.FTSUIHLLogic", e, "setSpan %s", bVar.toString());
                eVar.mDR = spannable;
                eVar.bFZ = -1;
            }
        }
        AppMethodBeat.o(114224);
        return eVar;
    }

    private static void a(String str, b bVar, d dVar) {
        AppMethodBeat.i(114225);
        String bAk = bVar.bAk();
        if (bo.isNullOrNil(bAk)) {
            AppMethodBeat.o(114225);
            return;
        }
        int indexOf = str.indexOf(bAk);
        if (indexOf >= 0) {
            bVar.mDP = indexOf;
            bVar.mDQ = bAk.length() + indexOf;
        }
        if (bVar.isAvailable() && dVar.mDG != null) {
            bVar.mDP += dVar.mDG.length();
            bVar.mDQ += dVar.mDG.length();
        }
        AppMethodBeat.o(114225);
    }

    private static void a(List<List<String>> list, b bVar, d dVar) {
        AppMethodBeat.i(114226);
        g.b bVar2;
        if (dVar.mDC) {
            for (g.b bVar22 : bVar.mDO.mEg) {
                if (bVar22.mEe == g.d.ShortPY) {
                    break;
                }
            }
            bVar22 = null;
            if (bVar22 == null) {
                AppMethodBeat.o(114226);
                return;
            }
            int h = h(list, bVar22.mEf);
            if (h >= 0) {
                bVar.mDP = h;
                bVar.mDQ = bVar22.mEf.size() + h;
            }
        } else {
            for (g.b bVar222 : bVar.mDO.mEg) {
                if (bVar222.mEe == g.d.FullPY) {
                    int h2 = h(list, bVar222.mEf);
                    if (h2 >= 0) {
                        bVar.mDP = h2;
                        bVar.mDQ = bVar222.mEf.size() + h2;
                        break;
                    }
                }
            }
        }
        if (bVar.isAvailable() && dVar.mDG != null) {
            bVar.mDP += dVar.mDG.length();
            bVar.mDQ += dVar.mDG.length();
        }
        AppMethodBeat.o(114226);
    }

    private static int h(List<List<String>> list, List<String> list2) {
        AppMethodBeat.i(114227);
        int i = 0;
        int i2 = 0;
        while (i < (list.size() - list2.size()) + 1) {
            Object obj;
            while (true) {
                int i3 = i2;
                if (i3 >= list2.size()) {
                    int obj2 = 1;
                    i2 = i3;
                    break;
                }
                List<String> list3 = (List) list.get(i + i3);
                String str = (String) list2.get(i3);
                if (!list3.contains(str)) {
                    if (i3 != list2.size() - 1) {
                        obj2 = null;
                        i2 = 0;
                        break;
                    }
                    for (String startsWith : list3) {
                        if (startsWith.startsWith(str)) {
                            obj2 = 1;
                            break;
                        }
                    }
                    obj2 = null;
                    if (obj2 == null) {
                        obj2 = null;
                        i2 = 0;
                        break;
                    }
                    i2 = i3 + 1;
                } else {
                    i2 = i3 + 1;
                }
            }
            if (obj2 != null) {
                break;
            }
            i++;
        }
        i = -1;
        AppMethodBeat.o(114227);
        return i;
    }

    private static List<List<String>> aM(String str, boolean z) {
        AppMethodBeat.i(114228);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            ArrayList arrayList2 = new ArrayList(2);
            if (g.t(charAt)) {
                String[] strArr = (String[]) g.mDn.get(String.valueOf(charAt));
                if (strArr == null || strArr.length <= 0 || strArr[0].length() <= 0) {
                    arrayList.add(arrayList2);
                } else {
                    for (Object obj : strArr) {
                        Object obj2;
                        if (z) {
                            obj2 = obj2.substring(0, 1);
                        }
                        if (!arrayList2.contains(obj2)) {
                            arrayList2.add(obj2);
                        }
                    }
                    arrayList.add(arrayList2);
                }
            } else {
                arrayList.add(arrayList2);
            }
        }
        AppMethodBeat.o(114228);
        return arrayList;
    }

    @Deprecated
    public static Spannable a(CharSequence charSequence, String str) {
        AppMethodBeat.i(114229);
        e a = a(d.b(charSequence, str));
        Spannable spannable;
        if (a.mDR instanceof Spannable) {
            spannable = (Spannable) a.mDR;
            AppMethodBeat.o(114229);
            return spannable;
        }
        spannable = new SpannableString(a.mDR);
        AppMethodBeat.o(114229);
        return spannable;
    }
}
