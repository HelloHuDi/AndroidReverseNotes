package com.google.android.exoplayer2.p101c.p795a;

import com.google.android.exoplayer2.C37269o;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/* renamed from: com.google.android.exoplayer2.c.a.c */
final class C17632c extends C41592d {
    long aOz = -9223372036854775807L;

    public C17632c() {
        super(null);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final boolean mo32314a(C32065l c32065l) {
        return true;
    }

    /* renamed from: b */
    private static Boolean m27445b(C32065l c32065l) {
        boolean z = true;
        AppMethodBeat.m2504i(94870);
        if (c32065l.readUnsignedByte() != 1) {
            z = false;
        }
        Boolean valueOf = Boolean.valueOf(z);
        AppMethodBeat.m2505o(94870);
        return valueOf;
    }

    /* renamed from: c */
    private static Double m27447c(C32065l c32065l) {
        AppMethodBeat.m2504i(94871);
        Double valueOf = Double.valueOf(Double.longBitsToDouble(c32065l.readLong()));
        AppMethodBeat.m2505o(94871);
        return valueOf;
    }

    /* renamed from: d */
    private static String m27448d(C32065l c32065l) {
        AppMethodBeat.m2504i(94872);
        int readUnsignedShort = c32065l.readUnsignedShort();
        int i = c32065l.position;
        c32065l.mo52369eM(readUnsignedShort);
        String str = new String(c32065l.data, i, readUnsignedShort);
        AppMethodBeat.m2505o(94872);
        return str;
    }

    /* renamed from: e */
    private static ArrayList<Object> m27449e(C32065l c32065l) {
        AppMethodBeat.m2504i(94873);
        int tI = c32065l.mo52389tI();
        ArrayList arrayList = new ArrayList(tI);
        for (int i = 0; i < tI; i++) {
            arrayList.add(C17632c.m27446b(c32065l, c32065l.readUnsignedByte()));
        }
        AppMethodBeat.m2505o(94873);
        return arrayList;
    }

    /* renamed from: f */
    private static HashMap<String, Object> m27450f(C32065l c32065l) {
        AppMethodBeat.m2504i(94874);
        HashMap hashMap = new HashMap();
        while (true) {
            String d = C17632c.m27448d(c32065l);
            int readUnsignedByte = c32065l.readUnsignedByte();
            if (readUnsignedByte != 9) {
                hashMap.put(d, C17632c.m27446b(c32065l, readUnsignedByte));
            } else {
                AppMethodBeat.m2505o(94874);
                return hashMap;
            }
        }
    }

    /* renamed from: g */
    private static HashMap<String, Object> m27451g(C32065l c32065l) {
        AppMethodBeat.m2504i(94875);
        int tI = c32065l.mo52389tI();
        HashMap hashMap = new HashMap(tI);
        for (int i = 0; i < tI; i++) {
            hashMap.put(C17632c.m27448d(c32065l), C17632c.m27446b(c32065l, c32065l.readUnsignedByte()));
        }
        AppMethodBeat.m2505o(94875);
        return hashMap;
    }

    /* renamed from: h */
    private static Date m27452h(C32065l c32065l) {
        AppMethodBeat.m2504i(94876);
        Date date = new Date((long) C17632c.m27447c(c32065l).doubleValue());
        c32065l.mo52369eM(2);
        AppMethodBeat.m2505o(94876);
        return date;
    }

    /* renamed from: b */
    private static Object m27446b(C32065l c32065l, int i) {
        AppMethodBeat.m2504i(94877);
        Object c;
        switch (i) {
            case 0:
                c = C17632c.m27447c(c32065l);
                AppMethodBeat.m2505o(94877);
                return c;
            case 1:
                c = C17632c.m27445b(c32065l);
                AppMethodBeat.m2505o(94877);
                return c;
            case 2:
                c = C17632c.m27448d(c32065l);
                AppMethodBeat.m2505o(94877);
                return c;
            case 3:
                c = C17632c.m27450f(c32065l);
                AppMethodBeat.m2505o(94877);
                return c;
            case 8:
                c = C17632c.m27451g(c32065l);
                AppMethodBeat.m2505o(94877);
                return c;
            case 10:
                c = C17632c.m27449e(c32065l);
                AppMethodBeat.m2505o(94877);
                return c;
            case 11:
                c = C17632c.m27452h(c32065l);
                AppMethodBeat.m2505o(94877);
                return c;
            default:
                AppMethodBeat.m2505o(94877);
                return null;
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo32313a(C32065l c32065l, long j) {
        AppMethodBeat.m2504i(94869);
        if (c32065l.readUnsignedByte() != 2) {
            C37269o c37269o = new C37269o();
            AppMethodBeat.m2505o(94869);
            throw c37269o;
        }
        if (!"onMetaData".equals(C17632c.m27448d(c32065l))) {
            AppMethodBeat.m2505o(94869);
        } else if (c32065l.readUnsignedByte() != 8) {
            AppMethodBeat.m2505o(94869);
        } else {
            HashMap g = C17632c.m27451g(c32065l);
            if (g.containsKey(FFmpegMetadataRetriever.METADATA_KEY_DURATION)) {
                double doubleValue = ((Double) g.get(FFmpegMetadataRetriever.METADATA_KEY_DURATION)).doubleValue();
                if (doubleValue > 0.0d) {
                    this.aOz = (long) (doubleValue * 1000000.0d);
                }
            }
            AppMethodBeat.m2505o(94869);
        }
    }
}
