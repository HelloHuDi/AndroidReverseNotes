package com.tencent.p177mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.ipcall.d */
public final class C21098d {
    public static boolean bGW() {
        AppMethodBeat.m2504i(21702);
        if (!C9638aw.m17179RK()) {
            AppMethodBeat.m2505o(21702);
            return false;
        } else if (C26373g.m41964Nu().getInt("WCOEntranceSwitch", 0) > 0) {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.TRUE);
            AppMethodBeat.m2505o(21702);
            return true;
        } else {
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.FALSE);
            AppMethodBeat.m2505o(21702);
            return false;
        }
    }
}
