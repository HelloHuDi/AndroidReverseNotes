package com.tencent.mm.plugin.fts.a.a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Comparator;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class i {
    private static final AtomicInteger mEo = new AtomicInteger(0);
    public ak handler = null;
    public int hbo = 0;
    public final int id = mEo.incrementAndGet();
    public String mEp = null;
    public String mEq = null;
    public int[] mEr = null;
    public int[] mEs = null;
    public int mEt = BaseClientBuilder.API_PRIORITY_OTHER;
    public HashSet<String> mEu = new HashSet();
    public Comparator<l> mEv = null;
    public l mEw = null;
    public String query = null;
    public int scene = -1;
    public String talker = null;

    static {
        AppMethodBeat.i(114271);
        AppMethodBeat.o(114271);
    }

    public i() {
        AppMethodBeat.i(114267);
        AppMethodBeat.o(114267);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(114269);
        if (this == obj) {
            AppMethodBeat.o(114269);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(114269);
            return false;
        } else {
            if (this.id != ((i) obj).id) {
                AppMethodBeat.o(114269);
                return false;
            }
            AppMethodBeat.o(114269);
            return true;
        }
    }

    public String toString() {
        AppMethodBeat.i(114270);
        String format = String.format("{id: %d, query: %s}", new Object[]{Integer.valueOf(this.id), this.query});
        AppMethodBeat.o(114270);
        return format;
    }

    public static i a(String str, int[] iArr, int[] iArr2, int i, HashSet<String> hashSet, Comparator<l> comparator, l lVar, ak akVar) {
        AppMethodBeat.i(114268);
        i iVar = new i();
        iVar.query = str;
        iVar.mEp = null;
        iVar.mEr = iArr;
        iVar.mEs = iArr2;
        iVar.mEt = i;
        iVar.mEu = hashSet;
        iVar.mEv = comparator;
        iVar.mEw = lVar;
        iVar.handler = akVar;
        AppMethodBeat.o(114268);
        return iVar;
    }
}
