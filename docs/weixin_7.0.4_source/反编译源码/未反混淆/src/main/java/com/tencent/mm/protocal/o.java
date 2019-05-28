package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o {
    public String host = "";
    public String nJq = "";
    private int port = 80;
    private int type = 0;

    public static class a {
        public final int[] vys = null;
        public final int[] vyt;
        public final int vyu;
        public final int vyv;

        public a(int[] iArr, int i, int i2) {
            this.vyt = iArr;
            this.vyu = i;
            this.vyv = i2;
        }
    }

    public o(int i, String str, int i2, String str2) {
        this.type = i;
        this.nJq = str;
        this.port = i2;
        this.host = str2;
    }

    public final String toString() {
        AppMethodBeat.i(58843);
        String str = this.type + "," + this.nJq + "," + this.port + "," + this.host;
        AppMethodBeat.o(58843);
        return str;
    }

    private static o akE(String str) {
        AppMethodBeat.i(58844);
        String[] split = str.split(",");
        if (split.length < 4) {
            AppMethodBeat.o(58844);
            return null;
        }
        o oVar = new o();
        try {
            oVar.type = bo.getInt(split[0], 0);
            oVar.nJq = bo.nullAsNil(split[1]);
            oVar.port = bo.getInt(split[2], 0);
            oVar.host = bo.nullAsNil(split[3]);
            AppMethodBeat.o(58844);
            return oVar;
        } catch (NumberFormatException e) {
            ab.e("MicroMsg.MMBuiltInIP", "exception:%s", bo.l(e));
            AppMethodBeat.o(58844);
            return null;
        }
    }

    public static String ei(List<o> list) {
        AppMethodBeat.i(58845);
        String str = "";
        Iterator it = list.iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                str = str2 + ((o) it.next()).toString() + "|";
            } else {
                AppMethodBeat.o(58845);
                return str2;
            }
        }
    }

    public static List<o> akF(String str) {
        AppMethodBeat.i(58846);
        LinkedList linkedList = new LinkedList();
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(58846);
        } else {
            try {
                for (String akE : str.split("\\|")) {
                    o akE2 = akE(akE);
                    if (akE2 != null) {
                        linkedList.add(akE2);
                    }
                }
            } catch (Exception e) {
                ab.d("MicroMsg.MMBuiltInIP", "unserialize split failed str[%s]", str);
                ab.e("MicroMsg.MMBuiltInIP", "exception:%s", bo.l(e));
            }
            AppMethodBeat.o(58846);
        }
        return linkedList;
    }

    public static a hN(String str, String str2) {
        AppMethodBeat.i(58847);
        ab.d("MicroMsg.MMBuiltInIP", "parsing network control params:");
        ab.d("MicroMsg.MMBuiltInIP", "ports = ".concat(String.valueOf(str)));
        ab.d("MicroMsg.MMBuiltInIP", "timeouts = ".concat(String.valueOf(str2)));
        int[] ang = bo.ang(str);
        int[] ang2 = bo.ang(str2);
        if (ang2 == null || ang2.length < 2) {
            ang2 = new int[]{0, 0};
            ab.e("MicroMsg.MMBuiltInIP", "invalid timeouts");
        }
        a aVar = new a(ang, (int) (((long) ang2[0]) * 1000), (int) (((long) ang2[1]) * 1000));
        AppMethodBeat.o(58847);
        return aVar;
    }
}
