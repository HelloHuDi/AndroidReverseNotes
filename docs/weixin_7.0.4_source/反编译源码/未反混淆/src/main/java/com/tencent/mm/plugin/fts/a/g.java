package com.tencent.mm.plugin.fts.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.b.b;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class g {
    public static HashMap<String, String> ghK = new HashMap();
    public static final a mCS = new a(19968, 40869);
    public static final a mCT = new a(40870, 40907);
    public static final a mCU = new a(13312, 19893);
    public static final a mCV = new a(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 173782);
    public static final a mCW = new a(173824, 177972);
    public static final a mCX = new a(177984, 178205);
    public static final a mCY = new a(12032, 12245);
    public static final a mCZ = new a(63744, 64217);
    public static final a mDa = new a(194560, 195101);
    public static final a mDc = new a(59413, 59503);
    public static final a mDd = new a(58368, 58856);
    public static final a mDe = new a(58880, 59087);
    public static final a mDf = new a(12736, 12771);
    public static final a mDg = new a(12272, 12283);
    public static final a mDh = new a(12549, 12576);
    public static final a mDi = new a(12704, 12730);
    public static final a mDj = new a(65, 90);
    public static final a mDk = new a(97, 122);
    public static final a mDl = new a(48, 57);
    public static b mDm = new b();
    public static HashMap<String, String[]> mDn = new HashMap();

    public static class a {
        int bottom;
        int mDo;

        public a(int i, int i2) {
            this.bottom = i;
            this.mDo = i2;
        }

        public final boolean vX(int i) {
            return i >= this.bottom && i <= this.mDo;
        }
    }

    static {
        AppMethodBeat.i(114234);
        AppMethodBeat.o(114234);
    }

    public static boolean t(char c) {
        AppMethodBeat.i(114230);
        if (mCS.vX(c) || mCT.vX(c) || mCU.vX(c) || mCV.vX(c) || mCW.vX(c) || mCX.vX(c)) {
            AppMethodBeat.o(114230);
            return true;
        }
        AppMethodBeat.o(114230);
        return false;
    }

    public static boolean u(char c) {
        AppMethodBeat.i(114231);
        if (mDj.vX(c) || mDk.vX(c)) {
            AppMethodBeat.o(114231);
            return true;
        }
        AppMethodBeat.o(114231);
        return false;
    }

    public static boolean v(char c) {
        AppMethodBeat.i(114232);
        boolean vX = mDl.vX(c);
        AppMethodBeat.o(114232);
        return vX;
    }

    public static final String Nf(String str) {
        String str2;
        AppMethodBeat.i(114233);
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : str.toCharArray()) {
            if (t(c)) {
                str2 = (String) ghK.get(String.valueOf(c));
                if (!bo.isNullOrNil(str2)) {
                    stringBuffer.append(str2);
                }
            }
            stringBuffer.append(c);
        }
        str2 = stringBuffer.toString();
        AppMethodBeat.o(114233);
        return str2;
    }
}
