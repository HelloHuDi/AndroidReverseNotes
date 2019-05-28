package com.google.android.exoplayer2.p105f.p799e;

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
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

/* renamed from: com.google.android.exoplayer2.f.e.b */
final class C25535b {
    public final long bif;
    public final long big;
    public final boolean bnL;
    public final C8674d bnM;
    public final String bnN;
    private final String[] bnO;
    private final HashMap<String, Integer> bnP;
    private final HashMap<String, Integer> bnQ;
    private List<C25535b> bnR;
    public final String tag;
    public final String text;

    C25535b(String str, String str2, long j, long j2, C8674d c8674d, String[] strArr, String str3) {
        AppMethodBeat.m2504i(95680);
        this.tag = str;
        this.text = str2;
        this.bnM = c8674d;
        this.bnO = strArr;
        this.bnL = str2 != null;
        this.bif = j;
        this.big = j2;
        this.bnN = (String) C45039a.checkNotNull(str3);
        this.bnP = new HashMap();
        this.bnQ = new HashMap();
        AppMethodBeat.m2505o(95680);
    }

    /* renamed from: a */
    public final void mo42789a(C25535b c25535b) {
        AppMethodBeat.m2504i(95681);
        if (this.bnR == null) {
            this.bnR = new ArrayList();
        }
        this.bnR.add(c25535b);
        AppMethodBeat.m2505o(95681);
    }

    /* renamed from: eD */
    private C25535b m40366eD(int i) {
        AppMethodBeat.m2504i(95682);
        if (this.bnR == null) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.m2505o(95682);
            throw indexOutOfBoundsException;
        }
        C25535b c25535b = (C25535b) this.bnR.get(i);
        AppMethodBeat.m2505o(95682);
        return c25535b;
    }

    private int getChildCount() {
        AppMethodBeat.m2504i(95683);
        if (this.bnR == null) {
            AppMethodBeat.m2505o(95683);
            return 0;
        }
        int size = this.bnR.size();
        AppMethodBeat.m2505o(95683);
        return size;
    }

    /* renamed from: tb */
    public final long[] mo42791tb() {
        boolean z = false;
        AppMethodBeat.m2504i(95684);
        TreeSet treeSet = new TreeSet();
        m40364a(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (true) {
            boolean z2 = z;
            if (it.hasNext()) {
                z = z2 + 1;
                jArr[z2] = ((Long) it.next()).longValue();
            } else {
                AppMethodBeat.m2505o(95684);
                return jArr;
            }
        }
    }

    /* renamed from: a */
    private void m40364a(TreeSet<Long> treeSet, boolean z) {
        AppMethodBeat.m2504i(95685);
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
            AppMethodBeat.m2505o(95685);
            return;
        }
        for (int i = 0; i < this.bnR.size(); i++) {
            boolean z2;
            C25535b c25535b = (C25535b) this.bnR.get(i);
            if (z || equals) {
                z2 = true;
            } else {
                z2 = false;
            }
            c25535b.m40364a(treeSet, z2);
        }
        AppMethodBeat.m2505o(95685);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo42788a(long j, boolean z, String str, Map<String, SpannableStringBuilder> map) {
        AppMethodBeat.m2504i(95686);
        this.bnP.clear();
        this.bnQ.clear();
        String str2 = this.bnN;
        if ("".equals(str2)) {
            str2 = str;
        }
        if (this.bnL && z) {
            C25535b.m40365b(str2, (Map) map).append(this.text);
            AppMethodBeat.m2505o(95686);
        } else if ("br".equals(this.tag) && z) {
            C25535b.m40365b(str2, (Map) map).append(10);
            AppMethodBeat.m2505o(95686);
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
                        C25535b eD = m40366eD(i);
                        boolean z2 = z || equals;
                        eD.mo42788a(j, z2, str2, map);
                    }
                    if (equals) {
                        SpannableStringBuilder b = C25535b.m40365b(str2, (Map) map);
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
            AppMethodBeat.m2505o(95686);
        }
    }

    /* renamed from: b */
    private static SpannableStringBuilder m40365b(String str, Map<String, SpannableStringBuilder> map) {
        AppMethodBeat.m2504i(95687);
        if (!map.containsKey(str)) {
            map.put(str, new SpannableStringBuilder());
        }
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) map.get(str);
        AppMethodBeat.m2505o(95687);
        return spannableStringBuilder;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo42790b(Map<String, C8674d> map, Map<String, SpannableStringBuilder> map2) {
        AppMethodBeat.m2504i(95688);
        for (Entry entry : this.bnQ.entrySet()) {
            String str = (String) entry.getKey();
            int intValue = this.bnP.containsKey(str) ? ((Integer) this.bnP.get(str)).intValue() : 0;
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) map2.get(str);
            int intValue2 = ((Integer) entry.getValue()).intValue();
            if (intValue != intValue2) {
                C8674d c8674d = this.bnM;
                String[] strArr = this.bnO;
                if (c8674d == null && strArr == null) {
                    c8674d = null;
                } else if (c8674d == null && strArr.length == 1) {
                    c8674d = (C8674d) map.get(strArr[0]);
                } else if (c8674d == null && strArr.length > 1) {
                    c8674d = new C8674d();
                    for (Object obj : strArr) {
                        c8674d.mo19193b((C8674d) map.get(obj));
                    }
                } else if (c8674d != null && strArr != null && strArr.length == 1) {
                    c8674d = c8674d.mo19193b((C8674d) map.get(strArr[0]));
                } else if (!(c8674d == null || strArr == null || strArr.length <= 1)) {
                    for (Object obj2 : strArr) {
                        c8674d.mo19193b((C8674d) map.get(obj2));
                    }
                }
                if (c8674d != null) {
                    boolean z;
                    IllegalStateException illegalStateException;
                    if (c8674d.getStyle() != -1) {
                        spannableStringBuilder.setSpan(new StyleSpan(c8674d.getStyle()), intValue, intValue2, 33);
                    }
                    if (c8674d.bnW == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        spannableStringBuilder.setSpan(new StrikethroughSpan(), intValue, intValue2, 33);
                    }
                    if (c8674d.bnX == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        spannableStringBuilder.setSpan(new UnderlineSpan(), intValue, intValue2, 33);
                    }
                    if (c8674d.bnU) {
                        if (c8674d.bnU) {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(c8674d.bnT), intValue, intValue2, 33);
                        } else {
                            illegalStateException = new IllegalStateException("Font color has not been defined.");
                            AppMethodBeat.m2505o(95688);
                            throw illegalStateException;
                        }
                    }
                    if (c8674d.bnV) {
                        if (c8674d.bnV) {
                            spannableStringBuilder.setSpan(new BackgroundColorSpan(c8674d.backgroundColor), intValue, intValue2, 33);
                        } else {
                            illegalStateException = new IllegalStateException("Background color has not been defined.");
                            AppMethodBeat.m2505o(95688);
                            throw illegalStateException;
                        }
                    }
                    if (c8674d.bnS != null) {
                        spannableStringBuilder.setSpan(new TypefaceSpan(c8674d.bnS), intValue, intValue2, 33);
                    }
                    if (c8674d.boc != null) {
                        spannableStringBuilder.setSpan(new Standard(c8674d.boc), intValue, intValue2, 33);
                    }
                    switch (c8674d.boa) {
                        case 1:
                            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) c8674d.fontSize, true), intValue, intValue2, 33);
                            break;
                        case 2:
                            spannableStringBuilder.setSpan(new RelativeSizeSpan(c8674d.fontSize), intValue, intValue2, 33);
                            break;
                        case 3:
                            spannableStringBuilder.setSpan(new RelativeSizeSpan(c8674d.fontSize / 100.0f), intValue, intValue2, 33);
                            break;
                    }
                }
            }
            for (int i = 0; i < getChildCount(); i++) {
                m40366eD(i).mo42790b((Map) map, (Map) map2);
            }
        }
        AppMethodBeat.m2505o(95688);
    }

    /* renamed from: a */
    static SpannableStringBuilder m40363a(SpannableStringBuilder spannableStringBuilder) {
        int i;
        AppMethodBeat.m2504i(95689);
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
        AppMethodBeat.m2505o(95689);
        return spannableStringBuilder;
    }
}
