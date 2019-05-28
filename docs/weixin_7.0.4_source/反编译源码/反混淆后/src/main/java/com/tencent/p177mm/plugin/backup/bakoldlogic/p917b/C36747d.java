package com.tencent.p177mm.plugin.backup.bakoldlogic.p917b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.backup.p342b.C33660a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.b.d */
public final class C36747d extends C33660a {
    private static String TAG = "MicroMsg.BakOldItemFactory";
    private static C36747d jyU;
    private HashMap<Integer, C45737j> jvv;

    public static C36747d aUA() {
        C36747d c36747d;
        AppMethodBeat.m2504i(17786);
        if (jyU == null) {
            c36747d = new C36747d();
            jyU = c36747d;
            C33660a.m54968a(c36747d);
        }
        c36747d = jyU;
        AppMethodBeat.m2505o(17786);
        return c36747d;
    }

    public final void aSp() {
        jyU = null;
    }

    /* renamed from: rD */
    public final C45737j mo58597rD(int i) {
        AppMethodBeat.m2504i(17787);
        if (this.jvv == null) {
            this.jvv = new HashMap();
            this.jvv.put(Integer.valueOf(3), new C33676e());
            this.jvv.put(Integer.valueOf(47), new C33675c());
            this.jvv.put(Integer.valueOf(49), new C38641b());
            this.jvv.put(Integer.valueOf(34), new C27453h());
            C11110g c11110g = new C11110g();
            this.jvv.put(Integer.valueOf(43), c11110g);
            this.jvv.put(Integer.valueOf(44), c11110g);
            this.jvv.put(Integer.valueOf(62), c11110g);
            C11109f c11109f = new C11109f();
            this.jvv.put(Integer.valueOf(48), c11109f);
            this.jvv.put(Integer.valueOf(42), c11109f);
            this.jvv.put(Integer.valueOf(66), c11109f);
            this.jvv.put(Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK), c11109f);
            this.jvv.put(Integer.valueOf(1), c11109f);
            this.jvv.put(Integer.valueOf(37), c11109f);
            this.jvv.put(Integer.valueOf(40), c11109f);
            this.jvv.put(Integer.valueOf(50), c11109f);
        }
        C45737j c45737j = (C45737j) this.jvv.get(Integer.valueOf(i));
        AppMethodBeat.m2505o(17787);
        return c45737j;
    }
}
