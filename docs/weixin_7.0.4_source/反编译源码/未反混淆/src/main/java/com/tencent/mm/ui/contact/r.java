package com.tencent.mm.ui.contact;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.m.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class r extends q {
    private ak handler = new ak(Looper.getMainLooper());
    private String query;
    private a zmU;
    private Map<String, String> znB = new HashMap();
    private List<String> znC = new ArrayList();
    private List<String> znn;

    public r(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, String str) {
        super(mMBaseSelectContactUI, list, z, 0);
        AppMethodBeat.i(105251);
        this.znn = list;
        if (!bo.isNullOrNil(str)) {
            this.znC = bo.P(str.split(","));
            if (this.znC != null) {
                for (String str2 : this.znC) {
                    String mJ = ((b) g.K(b.class)).mJ(str2);
                    if (!bo.isNullOrNil(mJ)) {
                        this.znB.put(mJ, str2);
                    }
                }
            }
        }
        Kh();
        AppMethodBeat.o(105251);
    }

    public final void a(a aVar) {
        this.zmU = aVar;
    }

    public final void ci(String str, boolean z) {
        AppMethodBeat.i(105252);
        if (this.zmU != null) {
            this.zmU.w(str, getCount(), z);
        }
        AppMethodBeat.o(105252);
    }

    private void Kh() {
        AppMethodBeat.i(105253);
        this.query = null;
        clearCache();
        AppMethodBeat.o(105253);
    }

    public final int getCount() {
        AppMethodBeat.i(105254);
        if (this.znC == null) {
            AppMethodBeat.o(105254);
            return 0;
        }
        int size = this.znC.size();
        AppMethodBeat.o(105254);
        return size;
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.ui.contact.a.a mP(int i) {
        AppMethodBeat.i(105255);
        e eVar = new e(i);
        eVar.query = this.query;
        g.RQ();
        eVar.ehM = ((j) g.K(j.class)).XM().aoM((String) this.znC.get(i));
        eVar.zmW = clI();
        AppMethodBeat.o(105255);
        return eVar;
    }

    public final void finish() {
        AppMethodBeat.i(105256);
        super.finish();
        Kh();
        AppMethodBeat.o(105256);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        return true;
    }
}
