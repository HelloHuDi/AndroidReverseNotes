package com.google.android.exoplayer2.p105f.p108g;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.p105f.C17659d;
import com.google.android.exoplayer2.p105f.C32044a;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.f.g.i */
final class C45033i implements C17659d {
    private final List<C0858e> blz;
    private final long[] bnA = new long[(this.boR * 2)];
    private final int boR;
    private final long[] boS;

    public C45033i(List<C0858e> list) {
        AppMethodBeat.m2504i(95749);
        this.blz = list;
        this.boR = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.boR) {
                C0858e c0858e = (C0858e) list.get(i2);
                int i3 = i2 * 2;
                this.bnA[i3] = c0858e.startTime;
                this.bnA[i3 + 1] = c0858e.endTime;
                i = i2 + 1;
            } else {
                this.boS = Arrays.copyOf(this.bnA, this.bnA.length);
                Arrays.sort(this.boS);
                AppMethodBeat.m2505o(95749);
                return;
            }
        }
    }

    /* renamed from: aj */
    public final int mo2575aj(long j) {
        AppMethodBeat.m2504i(95750);
        int a = C17675v.m27554a(this.boS, j, false, false);
        if (a < this.boS.length) {
            AppMethodBeat.m2505o(95750);
            return a;
        }
        AppMethodBeat.m2505o(95750);
        return -1;
    }

    /* renamed from: sG */
    public final int mo2578sG() {
        return this.boS.length;
    }

    /* renamed from: et */
    public final long mo2577et(int i) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(95751);
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        C45039a.checkArgument(z);
        if (i >= this.boS.length) {
            z2 = false;
        }
        C45039a.checkArgument(z2);
        long j = this.boS[i];
        AppMethodBeat.m2505o(95751);
        return j;
    }

    /* renamed from: ak */
    public final List<C32044a> mo2576ak(long j) {
        AppMethodBeat.m2504i(95752);
        int i = 0;
        SpannableStringBuilder spannableStringBuilder = null;
        C0858e c0858e = null;
        ArrayList arrayList = null;
        while (i < this.boR) {
            C0858e c0858e2;
            if (this.bnA[i * 2] <= j && j < this.bnA[(i * 2) + 1]) {
                Object obj;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                c0858e2 = (C0858e) this.blz.get(i);
                if (c0858e2.bkW == Float.MIN_VALUE && c0858e2.bkY == Float.MIN_VALUE) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    if (c0858e != null) {
                        if (spannableStringBuilder == null) {
                            spannableStringBuilder = new SpannableStringBuilder();
                            spannableStringBuilder.append(c0858e.text).append(IOUtils.LINE_SEPARATOR_UNIX).append(c0858e2.text);
                            c0858e2 = c0858e;
                        } else {
                            spannableStringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX).append(c0858e2.text);
                            c0858e2 = c0858e;
                        }
                    }
                    i++;
                    c0858e = c0858e2;
                } else {
                    arrayList.add(c0858e2);
                }
            }
            c0858e2 = c0858e;
            i++;
            c0858e = c0858e2;
        }
        if (spannableStringBuilder != null) {
            arrayList.add(new C0858e(spannableStringBuilder));
        } else if (c0858e != null) {
            arrayList.add(c0858e);
        }
        if (arrayList != null) {
            AppMethodBeat.m2505o(95752);
            return arrayList;
        }
        List<C32044a> emptyList = Collections.emptyList();
        AppMethodBeat.m2505o(95752);
        return emptyList;
    }
}
