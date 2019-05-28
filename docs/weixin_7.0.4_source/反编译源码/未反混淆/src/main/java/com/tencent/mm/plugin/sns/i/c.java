package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    private static Map<String, a> qSP = new ConcurrentHashMap();
    private static volatile long qSQ = 0;

    static class b {
        int mHeight;
        String mMimeType;
        int mWidth;
        String qSR;
        int qST;
        long qSU;

        private b() {
            this.qSR = "";
            this.mMimeType = "";
            this.mWidth = -1;
            this.mHeight = -1;
            this.qST = -1;
            this.qSU = -1;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static class a {
        int mHeight;
        String mMimeType;
        int mWidth;
        String qSR;
        int qSS;
        int qST;
        long qSU;
        long qSV;
        long qSW;

        private a() {
            this.qSR = "";
            this.qSS = 0;
            this.mMimeType = "";
            this.mWidth = -1;
            this.mHeight = -1;
            this.qST = -1;
            this.qSU = -1;
            this.qSV = -1;
            this.qSW = -1;
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(36872);
        AppMethodBeat.o(36872);
    }

    private static void coD() {
        AppMethodBeat.i(36867);
        synchronized (qSP) {
            try {
                if (bo.az(qSQ) <= 120000) {
                } else {
                    qSQ = bo.yz();
                    qSP.clear();
                    AppMethodBeat.o(36867);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(36867);
            }
        }
    }

    private static String YG(String str) {
        AppMethodBeat.i(36868);
        int indexOf = str.indexOf(63);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        indexOf = str.indexOf("://");
        if (indexOf >= 0) {
            str = str.substring(indexOf + 3);
        }
        indexOf = str.indexOf(47);
        if (indexOf >= 0) {
            str = str.substring(indexOf + 1);
            AppMethodBeat.o(36868);
            return str;
        }
        AppMethodBeat.o(36868);
        return str;
    }

    public static void a(String str, String str2, int i, int i2, int i3, long j) {
        AppMethodBeat.i(36869);
        try {
            b bVar = new b();
            bVar.qSR = YG(str);
            bVar.mMimeType = str2;
            bVar.mWidth = i;
            bVar.mHeight = i2;
            bVar.qST = i3;
            bVar.qSU = j;
            StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            stringBuilder.append(bVar.qSR).append(',').append(bVar.mMimeType).append(',').append(bVar.mWidth).append(',').append(bVar.mHeight).append(',').append(bVar.qST).append(',').append(bVar.qSU);
            String stringBuilder2 = stringBuilder.toString();
            ab.i("MicroMsg.SnsImgStats", "report up: ".concat(String.valueOf(stringBuilder2)));
            h.pYm.X(13512, stringBuilder2);
            AppMethodBeat.o(36869);
        } catch (Exception e) {
            AppMethodBeat.o(36869);
        }
    }

    public static void a(String str, String str2, int i, String str3, int i2, int i3, int i4, long j, long j2) {
        AppMethodBeat.i(36870);
        try {
            a aVar = new a();
            aVar.qSR = YG(str2);
            aVar.qSS = i;
            aVar.mMimeType = str3;
            aVar.mWidth = i2;
            aVar.mHeight = i3;
            aVar.qST = i4;
            aVar.qSU = j;
            aVar.qSV = j2;
            qSP.put(str, aVar);
            AppMethodBeat.o(36870);
        } catch (Exception e) {
            AppMethodBeat.o(36870);
        }
    }

    public static void an(String str, long j) {
        AppMethodBeat.i(36871);
        try {
            a aVar = (a) qSP.remove(str);
            if (aVar != null) {
                aVar.qSW = j;
                StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                stringBuilder.append(aVar.qSR).append(',').append(aVar.qSS).append(',').append(aVar.mMimeType).append(',').append(aVar.mWidth).append(',').append(aVar.mHeight).append(',').append(aVar.qST).append(',').append(aVar.qSU).append(',').append(aVar.qSV).append(',').append(aVar.qSW);
                String stringBuilder2 = stringBuilder.toString();
                ab.i("MicroMsg.SnsImgStats", "report dl: ".concat(String.valueOf(stringBuilder2)));
                h.pYm.X(13513, stringBuilder2);
                coD();
                AppMethodBeat.o(36871);
            }
        } catch (Exception e) {
        } finally {
            coD();
            AppMethodBeat.o(36871);
        }
    }
}
