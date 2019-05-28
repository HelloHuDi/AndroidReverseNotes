package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.wxmm.v2encoder;
import java.util.Locale;

public final class i {
    static final byte[] vem = new byte[]{(byte) 48, (byte) -126, (byte) 1, (byte) 75, (byte) 48, (byte) -126, (byte) 1, (byte) 3, (byte) 6, (byte) 7, (byte) 42, (byte) -122, (byte) 72, (byte) -50, (byte) 61, (byte) 2, (byte) 1, (byte) 48, (byte) -127, (byte) -9, (byte) 2, (byte) 1, (byte) 1, (byte) 48, (byte) 44, (byte) 6, (byte) 7, (byte) 42, (byte) -122, (byte) 72, (byte) -50, (byte) 61, (byte) 1, (byte) 1, (byte) 2, (byte) 33, (byte) 0, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 48, (byte) 91, (byte) 4, (byte) 32, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -4, (byte) 4, (byte) 32, (byte) 90, (byte) -58, (byte) 53, (byte) -40, (byte) -86, (byte) 58, (byte) -109, (byte) -25, (byte) -77, (byte) -21, (byte) -67, (byte) 85, (byte) 118, (byte) -104, (byte) -122, (byte) -68, (byte) 101, (byte) 29, (byte) 6, (byte) -80, (byte) -52, (byte) 83, (byte) -80, (byte) -10, (byte) 59, (byte) -50, (byte) 60, (byte) 62, (byte) 39, (byte) -46, (byte) 96, (byte) 75, (byte) 3, (byte) 21, (byte) 0, (byte) -60, (byte) -99, (byte) 54, (byte) 8, (byte) -122, (byte) -25, (byte) 4, (byte) -109, (byte) 106, (byte) 102, (byte) 120, (byte) -31, (byte) 19, (byte) -99, (byte) 38, (byte) -73, (byte) -127, (byte) -97, (byte) 126, (byte) -112, (byte) 4, (byte) 65, (byte) 4, (byte) 107, (byte) 23, (byte) -47, (byte) -14, (byte) -31, (byte) 44, (byte) 66, (byte) 71, (byte) -8, (byte) -68, (byte) -26, (byte) -27, (byte) 99, (byte) -92, (byte) 64, (byte) -14, (byte) 119, (byte) 3, (byte) 125, (byte) -127, (byte) 45, (byte) -21, (byte) 51, (byte) -96, (byte) -12, (byte) -95, (byte) 57, (byte) 69, (byte) -40, (byte) -104, (byte) -62, (byte) -106, (byte) 79, (byte) -29, (byte) 66, (byte) -30, (byte) -2, (byte) 26, Byte.MAX_VALUE, (byte) -101, (byte) -114, (byte) -25, (byte) -21, (byte) 74, (byte) 124, (byte) 15, (byte) -98, (byte) 22, (byte) 43, (byte) -50, (byte) 51, (byte) 87, (byte) 107, (byte) 49, (byte) 94, (byte) -50, (byte) -53, (byte) -74, (byte) 64, (byte) 104, (byte) 55, (byte) -65, (byte) 81, (byte) -11, (byte) 2, (byte) 33, (byte) 0, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -68, (byte) -26, (byte) -6, (byte) -83, (byte) -89, (byte) 23, (byte) -98, (byte) -124, (byte) -13, (byte) -71, (byte) -54, (byte) -62, (byte) -4, (byte) 99, (byte) 37, (byte) 81, (byte) 2, (byte) 1, (byte) 1, (byte) 3, (byte) 66, (byte) 0, (byte) 4, (byte) 52, (byte) 4, (byte) -14, (byte) 45, (byte) -10, (byte) -68, (byte) -118, (byte) -59, (byte) 62, (byte) 64, (byte) -101, (byte) 93, (byte) 6, (byte) -54, (byte) -27, (byte) 79, (byte) 94, (byte) 126, (byte) -9, (byte) -80, (byte) -61, (byte) -63, (byte) -38, (byte) 115, (byte) -53, (byte) 70, (byte) -63, v2encoder.enumCODEC_vcodec2, (byte) -20, (byte) -32, (byte) -80, (byte) -80, (byte) 38, (byte) 102, v2encoder.enumCODEC_vcodec2, (byte) 27, (byte) 28, (byte) 61, (byte) -60, (byte) -33, (byte) 65, (byte) 93, (byte) -25, (byte) 30, (byte) 83, (byte) 66, (byte) -24, (byte) 28, (byte) 39, (byte) 24, (byte) 69, (byte) -104, (byte) 55, (byte) -63, (byte) 108, (byte) 5, (byte) 56, (byte) -63, (byte) -4, (byte) -5, (byte) 88, (byte) -49, (byte) -126, (byte) 85};
    private static final String ven = (e.eSn + "CheckResUpdate/");
    private static final String veo = (e.eSk + "CheckResUpdate/");
    static final int[] vep = new int[]{27, 35, 29, 38, 40, 33, 37, 39, 49, 46, 47, 56, 59};

    enum b {
        DoNothing(0),
        DoCache(1),
        DoDecrypt(2),
        DoDelete(4);
        
        final int bJt;

        static {
            AppMethodBeat.o(79530);
        }

        private b(int i) {
            this.bJt = i;
        }

        static boolean KC(int i) {
            return i == DoNothing.bJt;
        }

        static boolean KD(int i) {
            return (DoCache.bJt & i) > 0;
        }

        static boolean KE(int i) {
            return (DoDecrypt.bJt & i) > 0;
        }

        static boolean KF(int i) {
            return (DoDelete.bJt & i) > 0;
        }

        static int aiZ(String str) {
            AppMethodBeat.i(79529);
            int i;
            if ("cache".equals(str)) {
                i = DoCache.bJt;
                AppMethodBeat.o(79529);
                return i;
            } else if ("delete".equals(str)) {
                i = DoDelete.bJt;
                AppMethodBeat.o(79529);
                return i;
            } else if ("decrypt".equals(str)) {
                i = DoDecrypt.bJt;
                AppMethodBeat.o(79529);
                return i;
            } else {
                i = DoNothing.bJt;
                AppMethodBeat.o(79529);
                return i;
            }
        }
    }

    enum a {
        ENCRYPTION(1),
        COMPRESSION(2);
        
        final int bJt;

        static {
            AppMethodBeat.o(79526);
        }

        private a(int i) {
            this.bJt = i;
        }

        static boolean Kz(int i) {
            return (ENCRYPTION.bJt & i) > 0;
        }

        static boolean KA(int i) {
            return (COMPRESSION.bJt & i) > 0;
        }

        static int dij() {
            return ENCRYPTION.bJt | 0;
        }

        static int KB(int i) {
            return COMPRESSION.bJt | i;
        }
    }

    static {
        AppMethodBeat.i(79534);
        AppMethodBeat.o(79534);
    }

    static String aiX(String str) {
        String str2;
        AppMethodBeat.i(79531);
        if (str.startsWith("38.") || str.startsWith("56.")) {
            str2 = veo;
        } else {
            str2 = ven;
        }
        j.aih(str2);
        str2 = str2 + str;
        AppMethodBeat.o(79531);
        return str2;
    }

    public static String gN(int i, int i2) {
        AppMethodBeat.i(79532);
        String format = String.format(Locale.US, "%d.%d.data", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        AppMethodBeat.o(79532);
        return format;
    }

    static boolean aiY(String str) {
        AppMethodBeat.i(79533);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(79533);
            return false;
        }
        String aiX = aiX(str);
        boolean ajj = com.tencent.mm.pluginsdk.g.a.d.a.ajj(aiX + ".decrypted") & ((com.tencent.mm.pluginsdk.g.a.d.a.ajj(aiX) & 1) & com.tencent.mm.pluginsdk.g.a.d.a.ajj(aiX + ".decompressed"));
        AppMethodBeat.o(79533);
        return ajj;
    }
}
