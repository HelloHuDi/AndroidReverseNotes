package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

final class c extends d {
    long aOz = -9223372036854775807L;

    public c() {
        super(null);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(l lVar) {
        return true;
    }

    private static Boolean b(l lVar) {
        boolean z = true;
        AppMethodBeat.i(94870);
        if (lVar.readUnsignedByte() != 1) {
            z = false;
        }
        Boolean valueOf = Boolean.valueOf(z);
        AppMethodBeat.o(94870);
        return valueOf;
    }

    private static Double c(l lVar) {
        AppMethodBeat.i(94871);
        Double valueOf = Double.valueOf(Double.longBitsToDouble(lVar.readLong()));
        AppMethodBeat.o(94871);
        return valueOf;
    }

    private static String d(l lVar) {
        AppMethodBeat.i(94872);
        int readUnsignedShort = lVar.readUnsignedShort();
        int i = lVar.position;
        lVar.eM(readUnsignedShort);
        String str = new String(lVar.data, i, readUnsignedShort);
        AppMethodBeat.o(94872);
        return str;
    }

    private static ArrayList<Object> e(l lVar) {
        AppMethodBeat.i(94873);
        int tI = lVar.tI();
        ArrayList arrayList = new ArrayList(tI);
        for (int i = 0; i < tI; i++) {
            arrayList.add(b(lVar, lVar.readUnsignedByte()));
        }
        AppMethodBeat.o(94873);
        return arrayList;
    }

    private static HashMap<String, Object> f(l lVar) {
        AppMethodBeat.i(94874);
        HashMap hashMap = new HashMap();
        while (true) {
            String d = d(lVar);
            int readUnsignedByte = lVar.readUnsignedByte();
            if (readUnsignedByte != 9) {
                hashMap.put(d, b(lVar, readUnsignedByte));
            } else {
                AppMethodBeat.o(94874);
                return hashMap;
            }
        }
    }

    private static HashMap<String, Object> g(l lVar) {
        AppMethodBeat.i(94875);
        int tI = lVar.tI();
        HashMap hashMap = new HashMap(tI);
        for (int i = 0; i < tI; i++) {
            hashMap.put(d(lVar), b(lVar, lVar.readUnsignedByte()));
        }
        AppMethodBeat.o(94875);
        return hashMap;
    }

    private static Date h(l lVar) {
        AppMethodBeat.i(94876);
        Date date = new Date((long) c(lVar).doubleValue());
        lVar.eM(2);
        AppMethodBeat.o(94876);
        return date;
    }

    private static Object b(l lVar, int i) {
        AppMethodBeat.i(94877);
        Object c;
        switch (i) {
            case 0:
                c = c(lVar);
                AppMethodBeat.o(94877);
                return c;
            case 1:
                c = b(lVar);
                AppMethodBeat.o(94877);
                return c;
            case 2:
                c = d(lVar);
                AppMethodBeat.o(94877);
                return c;
            case 3:
                c = f(lVar);
                AppMethodBeat.o(94877);
                return c;
            case 8:
                c = g(lVar);
                AppMethodBeat.o(94877);
                return c;
            case 10:
                c = e(lVar);
                AppMethodBeat.o(94877);
                return c;
            case 11:
                c = h(lVar);
                AppMethodBeat.o(94877);
                return c;
            default:
                AppMethodBeat.o(94877);
                return null;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(l lVar, long j) {
        AppMethodBeat.i(94869);
        if (lVar.readUnsignedByte() != 2) {
            o oVar = new o();
            AppMethodBeat.o(94869);
            throw oVar;
        }
        if (!"onMetaData".equals(d(lVar))) {
            AppMethodBeat.o(94869);
        } else if (lVar.readUnsignedByte() != 8) {
            AppMethodBeat.o(94869);
        } else {
            HashMap g = g(lVar);
            if (g.containsKey(FFmpegMetadataRetriever.METADATA_KEY_DURATION)) {
                double doubleValue = ((Double) g.get(FFmpegMetadataRetriever.METADATA_KEY_DURATION)).doubleValue();
                if (doubleValue > 0.0d) {
                    this.aOz = (long) (doubleValue * 1000000.0d);
                }
            }
            AppMethodBeat.o(94869);
        }
    }
}
