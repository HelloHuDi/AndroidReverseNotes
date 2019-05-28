package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.b */
public final class C43281b {
    private List<C39342c> oeL = new LinkedList();
    private boolean oeM = false;
    private boolean oeN = false;
    private TextView oeO;

    public C43281b() {
        AppMethodBeat.m2504i(42732);
        AppMethodBeat.m2505o(42732);
    }

    /* renamed from: a */
    public final void mo68830a(C39342c c39342c) {
        AppMethodBeat.m2504i(42733);
        if (c39342c == null) {
            AppMethodBeat.m2505o(42733);
            return;
        }
        this.oeL.add(c39342c);
        AppMethodBeat.m2505o(42733);
    }

    /* renamed from: i */
    public final void mo68834i(TextView textView) {
        if (textView != null) {
            this.oeO = textView;
        }
    }

    public final void clear() {
        AppMethodBeat.m2504i(42734);
        this.oeL.clear();
        this.oeO = null;
        AppMethodBeat.m2505o(42734);
    }

    public final boolean bMy() {
        AppMethodBeat.m2504i(42735);
        this.oeN = false;
        this.oeM = false;
        for (int i = 0; i < this.oeL.size(); i++) {
            C39342c c39342c = (C39342c) this.oeL.get(i);
            int bKW = c39342c.bKW();
            if (bKW != 0) {
                c39342c.onError();
                m77146Qn(c39342c.mo36557xH(bKW));
                this.oeN = true;
            } else {
                c39342c.restore();
            }
        }
        if (!(this.oeN || this.oeO == null)) {
            this.oeO.setVisibility(8);
            this.oeM = false;
        }
        boolean z = this.oeN;
        AppMethodBeat.m2505o(42735);
        return z;
    }

    public final boolean bMz() {
        AppMethodBeat.m2504i(42736);
        for (int i = 0; i < this.oeL.size(); i++) {
            if (((C39342c) this.oeL.get(i)).bKW() != 0) {
                AppMethodBeat.m2505o(42736);
                return true;
            }
        }
        AppMethodBeat.m2505o(42736);
        return false;
    }

    /* renamed from: Qn */
    private void m77146Qn(String str) {
        AppMethodBeat.m2504i(42737);
        if (!(this.oeO == null || C5046bo.isNullOrNil(str))) {
            if (!this.oeM) {
                this.oeO.setText(str);
            }
            this.oeO.setVisibility(0);
            this.oeM = true;
        }
        AppMethodBeat.m2505o(42737);
    }

    /* renamed from: Dv */
    public final void mo68829Dv(String str) {
        AppMethodBeat.m2504i(42738);
        if (this.oeO == null || C5046bo.isNullOrNil(str)) {
            if (this.oeO != null) {
                this.oeO.setVisibility(8);
                this.oeM = false;
            }
            AppMethodBeat.m2505o(42738);
            return;
        }
        this.oeO.setText(str);
        this.oeO.setVisibility(0);
        this.oeM = true;
        AppMethodBeat.m2505o(42738);
    }
}
