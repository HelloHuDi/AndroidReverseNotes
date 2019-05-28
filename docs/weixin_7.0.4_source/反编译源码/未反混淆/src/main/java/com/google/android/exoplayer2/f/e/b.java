package com.google.android.exoplayer2.f.e;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan.Standard;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

final class b {
    public final long bif;
    public final long big;
    public final boolean bnL;
    public final d bnM;
    public final String bnN;
    private final String[] bnO;
    private final HashMap<String, Integer> bnP;
    private final HashMap<String, Integer> bnQ;
    private List<b> bnR;
    public final String tag;
    public final String text;

    b(String str, String str2, long j, long j2, d dVar, String[] strArr, String str3) {
        AppMethodBeat.i(95680);
        this.tag = str;
        this.text = str2;
        this.bnM = dVar;
        this.bnO = strArr;
        this.bnL = str2 != null;
        this.bif = j;
        this.big = j2;
        this.bnN = (String) a.checkNotNull(str3);
        this.bnP = new HashMap();
        this.bnQ = new HashMap();
        AppMethodBeat.o(95680);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(95681);
        if (this.bnR == null) {
            this.bnR = new ArrayList();
        }
        this.bnR.add(bVar);
        AppMethodBeat.o(95681);
    }

    private b eD(int i) {
        AppMethodBeat.i(95682);
        if (this.bnR == null) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.o(95682);
            throw indexOutOfBoundsException;
        }
        b bVar = (b) this.bnR.get(i);
        AppMethodBeat.o(95682);
        return bVar;
    }

    private int getChildCount() {
        AppMethodBeat.i(95683);
        if (this.bnR == null) {
            AppMethodBeat.o(95683);
            return 0;
        }
        int size = this.bnR.size();
        AppMethodBeat.o(95683);
        return size;
    }

    public final long[] tb() {
        boolean z = false;
        AppMethodBeat.i(95684);
        TreeSet treeSet = new TreeSet();
        a(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (true) {
            boolean z2 = z;
            if (it.hasNext()) {
                z = z2 + 1;
                jArr[z2] = ((Long) it.next()).longValue();
            } else {
                AppMethodBeat.o(95684);
                return jArr;
            }
        }
    }

    private void a(TreeSet<Long> treeSet, boolean z) {
        AppMethodBeat.i(95685);
        boolean equals = "p".equals(this.tag);
        if (z || equals) {
            if (this.bif != -9223372036854775807L) {
                treeSet.add(Long.valueOf(this.bif));
            }
            if (this.big != -9223372036854775807L) {
                treeSet.add(Long.valueOf(this.big));
            }
        }
        if (this.bnR == null) {
            AppMethodBeat.o(95685);
            return;
        }
        for (int i = 0; i < this.bnR.size(); i++) {
            boolean z2;
            b bVar = (b) this.bnR.get(i);
            if (z || equals) {
                z2 = true;
            } else {
                z2 = false;
            }
            bVar.a(treeSet, z2);
        }
        AppMethodBeat.o(95685);
    }

    /* Access modifiers changed, original: final */
    public final void a(long j, boolean z, String str, Map<String, SpannableStringBuilder> map) {
        AppMethodBeat.i(95686);
        this.bnP.clear();
        this.bnQ.clear();
        String str2 = this.bnN;
        if ("".equals(str2)) {
            str2 = str;
        }
        if (this.bnL && z) {
            b(str2, (Map) map).append(this.text);
            AppMethodBeat.o(95686);
        } else if ("br".equals(this.tag) && z) {
            b(str2, (Map) map).append(10);
            AppMethodBeat.o(95686);
        } else {
            if (!"metadata".equals(this.tag)) {
                Object obj;
                if (!(this.bif == -9223372036854775807L && this.big == -9223372036854775807L) && ((this.bif > j || this.big != -9223372036854775807L) && ((this.bif != -9223372036854775807L || j >= this.big) && (this.bif > j || j >= this.big)))) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    int i;
                    boolean equals = "p".equals(this.tag);
                    for (Entry entry : map.entrySet()) {
                        this.bnP.put(entry.getKey(), Integer.valueOf(((SpannableStringBuilder) entry.getValue()).length()));
                    }
                    for (i = 0; i < getChildCount(); i++) {
                        b eD = eD(i);
                        boolean z2 = z || equals;
                        eD.a(j, z2, str2, map);
                    }
                    if (equals) {
                        SpannableStringBuilder b = b(str2, (Map) map);
                        i = b.length() - 1;
                        while (i >= 0 && b.charAt(i) == ' ') {
                            i--;
                        }
                        if (i >= 0 && b.charAt(i) != 10) {
                            b.append(10);
                        }
                    }
                    for (Entry entry2 : map.entrySet()) {
                        this.bnQ.put(entry2.getKey(), Integer.valueOf(((SpannableStringBuilder) entry2.getValue()).length()));
                    }
                }
            }
            AppMethodBeat.o(95686);
        }
    }

    private static SpannableStringBuilder b(String str, Map<String, SpannableStringBuilder> map) {
        AppMethodBeat.i(95687);
        if (!map.containsKey(str)) {
            map.put(str, new SpannableStringBuilder());
        }
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) map.get(str);
        AppMethodBeat.o(95687);
        return spannableStringBuilder;
    }

    /* Access modifiers changed, original: final */
    public final void b(Map<String, d> map, Map<String, SpannableStringBuilder> map2) {
        AppMethodBeat.i(95688);
        for (Entry entry : this.bnQ.entrySet()) {
            String str = (String) entry.getKey();
            int intValue = this.bnP.containsKey(str) ? ((Integer) this.bnP.get(str)).intValue() : 0;
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) map2.get(str);
            int intValue2 = ((Integer) entry.getValue()).intValue();
            if (intValue != intValue2) {
                d dVar = this.bnM;
                String[] strArr = this.bnO;
                if (dVar == null && strArr == null) {
                    dVar = null;
                } else if (dVar == null && strArr.length == 1) {
                    dVar = (d) map.get(strArr[0]);
                } else if (dVar == null && strArr.length > 1) {
                    dVar = new d();
                    for (Object obj : strArr) {
                        dVar.b((d) map.get(obj));
                    }
                } else if (dVar != null && strArr != null && strArr.length == 1) {
                    dVar = dVar.b((d) map.get(strArr[0]));
                } else if (!(dVar == null || strArr == null || strArr.length <= 1)) {
                    for (Object obj2 : strArr) {
                        dVar.b((d) map.get(obj2));
                    }
                }
                if (dVar != null) {
                    boolean z;
                    IllegalStateException illegalStateException;
                    if (dVar.getStyle() != -1) {
                        spannableStringBuilder.setSpan(new StyleSpan(dVar.getStyle()), intValue, intValue2, 33);
                    }
                    if (dVar.bnW == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        spannableStringBuilder.setSpan(new StrikethroughSpan(), intValue, intValue2, 33);
                    }
                    if (dVar.bnX == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        spannableStringBuilder.setSpan(new UnderlineSpan(), intValue, intValue2, 33);
                    }
                    if (dVar.bnU) {
                        if (dVar.bnU) {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(dVar.bnT), intValue, intValue2, 33);
                        } else {
                            illegalStateException = new IllegalStateException("Font color has not been defined.");
                            AppMethodBeat.o(95688);
                            throw illegalStateException;
                        }
                    }
                    if (dVar.bnV) {
                        if (dVar.bnV) {
                            spannableStringBuilder.setSpan(new BackgroundColorSpan(dVar.backgroundColor), intValue, intValue2, 33);
                        } else {
                            illegalStateException = new IllegalStateException("Background color has not been defined.");
                            AppMethodBeat.o(95688);
                            throw illegalStateException;
                        }
                    }
                    if (dVar.bnS != null) {
                        spannableStringBuilder.setSpan(new TypefaceSpan(dVar.bnS), intValue, intValue2, 33);
                    }
                    if (dVar.boc != null) {
                        spannableStringBuilder.setSpan(new Standard(dVar.boc), intValue, intValue2, 33);
                    }
                    switch (dVar.boa) {
                        case 1:
                            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) dVar.fontSize, true), intValue, intValue2, 33);
                            break;
                        case 2:
                            spannableStringBuilder.setSpan(new RelativeSizeSpan(dVar.fontSize), intValue, intValue2, 33);
                            break;
                        case 3:
                            spannableStringBuilder.setSpan(new RelativeSizeSpan(dVar.fontSize / 100.0f), intValue, intValue2, 33);
                            break;
                    }
                }
            }
            for (int i = 0; i < getChildCount(); i++) {
                eD(i).b((Map) map, (Map) map2);
            }
        }
        AppMethodBeat.o(95688);
    }

    static SpannableStringBuilder a(SpannableStringBuilder spannableStringBuilder) {
        int i;
        AppMethodBeat.i(95689);
        int length = spannableStringBuilder.length();
        int i2 = 0;
        while (i2 < length) {
            if (spannableStringBuilder.charAt(i2) == ' ') {
                i = i2 + 1;
                while (i < spannableStringBuilder.length() && spannableStringBuilder.charAt(i) == ' ') {
                    i++;
                }
                i -= i2 + 1;
                if (i > 0) {
                    spannableStringBuilder.delete(i2, i2 + i);
                    i = length - i;
                    i2++;
                    length = i;
                }
            }
            i = length;
            i2++;
            length = i;
        }
        if (length > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
            length--;
        }
        i2 = 0;
        i = length;
        while (i2 < i - 1) {
            if (spannableStringBuilder.charAt(i2) == 10 && spannableStringBuilder.charAt(i2 + 1) == ' ') {
                spannableStringBuilder.delete(i2 + 1, i2 + 2);
                i--;
            }
            i2++;
        }
        if (i > 0 && spannableStringBuilder.charAt(i - 1) == ' ') {
            spannableStringBuilder.delete(i - 1, i);
            i--;
        }
        length = 0;
        while (length < i - 1) {
            if (spannableStringBuilder.charAt(length) == ' ' && spannableStringBuilder.charAt(length + 1) == 10) {
                spannableStringBuilder.delete(length, length + 1);
                i--;
            }
            length++;
        }
        if (i > 0 && spannableStringBuilder.charAt(i - 1) == 10) {
            spannableStringBuilder.delete(i - 1, i);
        }
        AppMethodBeat.o(95689);
        return spannableStringBuilder;
    }
}
