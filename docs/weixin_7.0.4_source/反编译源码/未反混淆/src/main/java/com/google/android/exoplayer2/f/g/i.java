package com.google.android.exoplayer2.f.g;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class i implements d {
    private final List<e> blz;
    private final long[] bnA = new long[(this.boR * 2)];
    private final int boR;
    private final long[] boS;

    public i(List<e> list) {
        AppMethodBeat.i(95749);
        this.blz = list;
        this.boR = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.boR) {
                e eVar = (e) list.get(i2);
                int i3 = i2 * 2;
                this.bnA[i3] = eVar.startTime;
                this.bnA[i3 + 1] = eVar.endTime;
                i = i2 + 1;
            } else {
                this.boS = Arrays.copyOf(this.bnA, this.bnA.length);
                Arrays.sort(this.boS);
                AppMethodBeat.o(95749);
                return;
            }
        }
    }

    public final int aj(long j) {
        AppMethodBeat.i(95750);
        int a = v.a(this.boS, j, false, false);
        if (a < this.boS.length) {
            AppMethodBeat.o(95750);
            return a;
        }
        AppMethodBeat.o(95750);
        return -1;
    }

    public final int sG() {
        return this.boS.length;
    }

    public final long et(int i) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(95751);
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        a.checkArgument(z);
        if (i >= this.boS.length) {
            z2 = false;
        }
        a.checkArgument(z2);
        long j = this.boS[i];
        AppMethodBeat.o(95751);
        return j;
    }

    public final List<com.google.android.exoplayer2.f.a> ak(long j) {
        AppMethodBeat.i(95752);
        int i = 0;
        SpannableStringBuilder spannableStringBuilder = null;
        e eVar = null;
        ArrayList arrayList = null;
        while (i < this.boR) {
            e eVar2;
            if (this.bnA[i * 2] <= j && j < this.bnA[(i * 2) + 1]) {
                Object obj;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                eVar2 = (e) this.blz.get(i);
                if (eVar2.bkW == Float.MIN_VALUE && eVar2.bkY == Float.MIN_VALUE) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    if (eVar != null) {
                        if (spannableStringBuilder == null) {
                            spannableStringBuilder = new SpannableStringBuilder();
                            spannableStringBuilder.append(eVar.text).append(IOUtils.LINE_SEPARATOR_UNIX).append(eVar2.text);
                            eVar2 = eVar;
                        } else {
                            spannableStringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX).append(eVar2.text);
                            eVar2 = eVar;
                        }
                    }
                    i++;
                    eVar = eVar2;
                } else {
                    arrayList.add(eVar2);
                }
            }
            eVar2 = eVar;
            i++;
            eVar = eVar2;
        }
        if (spannableStringBuilder != null) {
            arrayList.add(new e(spannableStringBuilder));
        } else if (eVar != null) {
            arrayList.add(eVar);
        }
        if (arrayList != null) {
            AppMethodBeat.o(95752);
            return arrayList;
        }
        List<com.google.android.exoplayer2.f.a> emptyList = Collections.emptyList();
        AppMethodBeat.o(95752);
        return emptyList;
    }
}
