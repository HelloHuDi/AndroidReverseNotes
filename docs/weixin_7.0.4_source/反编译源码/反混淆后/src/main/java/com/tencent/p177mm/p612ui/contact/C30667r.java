package com.tencent.p177mm.p612ui.contact;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.contact.C36877m.C36878a;
import com.tencent.p177mm.p612ui.contact.p625a.C40843e;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.contact.r */
public final class C30667r extends C23923q {
    private C7306ak handler = new C7306ak(Looper.getMainLooper());
    private String query;
    private C36878a zmU;
    private Map<String, String> znB = new HashMap();
    private List<String> znC = new ArrayList();
    private List<String> znn;

    public C30667r(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, String str) {
        super(mMBaseSelectContactUI, list, z, 0);
        AppMethodBeat.m2504i(105251);
        this.znn = list;
        if (!C5046bo.isNullOrNil(str)) {
            this.znC = C5046bo.m7508P(str.split(","));
            if (this.znC != null) {
                for (String str2 : this.znC) {
                    String mJ = ((C34530b) C1720g.m3528K(C34530b.class)).mo55066mJ(str2);
                    if (!C5046bo.isNullOrNil(mJ)) {
                        this.znB.put(mJ, str2);
                    }
                }
            }
        }
        m48894Kh();
        AppMethodBeat.m2505o(105251);
    }

    /* renamed from: a */
    public final void mo49041a(C36878a c36878a) {
        this.zmU = c36878a;
    }

    /* renamed from: ci */
    public final void mo39697ci(String str, boolean z) {
        AppMethodBeat.m2504i(105252);
        if (this.zmU != null) {
            this.zmU.mo28008w(str, getCount(), z);
        }
        AppMethodBeat.m2505o(105252);
    }

    /* renamed from: Kh */
    private void m48894Kh() {
        AppMethodBeat.m2504i(105253);
        this.query = null;
        clearCache();
        AppMethodBeat.m2505o(105253);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(105254);
        if (this.znC == null) {
            AppMethodBeat.m2505o(105254);
            return 0;
        }
        int size = this.znC.size();
        AppMethodBeat.m2505o(105254);
        return size;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: mP */
    public final C5445a mo8217mP(int i) {
        AppMethodBeat.m2504i(105255);
        C40843e c40843e = new C40843e(i);
        c40843e.query = this.query;
        C1720g.m3537RQ();
        c40843e.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoM((String) this.znC.get(i));
        c40843e.zmW = clI();
        AppMethodBeat.m2505o(105255);
        return c40843e;
    }

    public final void finish() {
        AppMethodBeat.m2504i(105256);
        super.finish();
        m48894Kh();
        AppMethodBeat.m2505o(105256);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final boolean mo39696c(C5445a c5445a) {
        return true;
    }
}
