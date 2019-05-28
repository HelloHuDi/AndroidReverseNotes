package com.tencent.p177mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.protocal.o */
public final class C4838o {
    public String host = "";
    public String nJq = "";
    private int port = 80;
    private int type = 0;

    /* renamed from: com.tencent.mm.protocal.o$a */
    public static class C4837a {
        public final int[] vys = null;
        public final int[] vyt;
        public final int vyu;
        public final int vyv;

        public C4837a(int[] iArr, int i, int i2) {
            this.vyt = iArr;
            this.vyu = i;
            this.vyv = i2;
        }
    }

    public C4838o(int i, String str, int i2, String str2) {
        this.type = i;
        this.nJq = str;
        this.port = i2;
        this.host = str2;
    }

    public final String toString() {
        AppMethodBeat.m2504i(58843);
        String str = this.type + "," + this.nJq + "," + this.port + "," + this.host;
        AppMethodBeat.m2505o(58843);
        return str;
    }

    private static C4838o akE(String str) {
        AppMethodBeat.m2504i(58844);
        String[] split = str.split(",");
        if (split.length < 4) {
            AppMethodBeat.m2505o(58844);
            return null;
        }
        C4838o c4838o = new C4838o();
        try {
            c4838o.type = C5046bo.getInt(split[0], 0);
            c4838o.nJq = C5046bo.nullAsNil(split[1]);
            c4838o.port = C5046bo.getInt(split[2], 0);
            c4838o.host = C5046bo.nullAsNil(split[3]);
            AppMethodBeat.m2505o(58844);
            return c4838o;
        } catch (NumberFormatException e) {
            C4990ab.m7413e("MicroMsg.MMBuiltInIP", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58844);
            return null;
        }
    }

    /* renamed from: ei */
    public static String m7196ei(List<C4838o> list) {
        AppMethodBeat.m2504i(58845);
        String str = "";
        Iterator it = list.iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                str = str2 + ((C4838o) it.next()).toString() + "|";
            } else {
                AppMethodBeat.m2505o(58845);
                return str2;
            }
        }
    }

    public static List<C4838o> akF(String str) {
        AppMethodBeat.m2504i(58846);
        LinkedList linkedList = new LinkedList();
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(58846);
        } else {
            try {
                for (String akE : str.split("\\|")) {
                    C4838o akE2 = C4838o.akE(akE);
                    if (akE2 != null) {
                        linkedList.add(akE2);
                    }
                }
            } catch (Exception e) {
                C4990ab.m7411d("MicroMsg.MMBuiltInIP", "unserialize split failed str[%s]", str);
                C4990ab.m7413e("MicroMsg.MMBuiltInIP", "exception:%s", C5046bo.m7574l(e));
            }
            AppMethodBeat.m2505o(58846);
        }
        return linkedList;
    }

    /* renamed from: hN */
    public static C4837a m7197hN(String str, String str2) {
        AppMethodBeat.m2504i(58847);
        C4990ab.m7410d("MicroMsg.MMBuiltInIP", "parsing network control params:");
        C4990ab.m7410d("MicroMsg.MMBuiltInIP", "ports = ".concat(String.valueOf(str)));
        C4990ab.m7410d("MicroMsg.MMBuiltInIP", "timeouts = ".concat(String.valueOf(str2)));
        int[] ang = C5046bo.ang(str);
        int[] ang2 = C5046bo.ang(str2);
        if (ang2 == null || ang2.length < 2) {
            ang2 = new int[]{0, 0};
            C4990ab.m7412e("MicroMsg.MMBuiltInIP", "invalid timeouts");
        }
        C4837a c4837a = new C4837a(ang, (int) (((long) ang2[0]) * 1000), (int) (((long) ang2[1]) * 1000));
        AppMethodBeat.m2505o(58847);
        return c4837a;
    }
}
