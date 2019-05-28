package com.tencent.p177mm.p612ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.contact.p625a.C40843e;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.contact.h */
public final class C23922h extends C40845o {
    private Cursor gnQ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15760ew(this.zmn);
    private List<String> zmn;

    public C23922h(MMBaseSelectContactUI mMBaseSelectContactUI, boolean z, List<String> list) {
        super(mMBaseSelectContactUI, new ArrayList(), true, z);
        AppMethodBeat.m2504i(105204);
        this.zmn = list;
        C1720g.m3537RQ();
        AppMethodBeat.m2505o(105204);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(105205);
        int count = this.gnQ.getCount();
        AppMethodBeat.m2505o(105205);
        return count;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: mP */
    public final C5445a mo8217mP(int i) {
        AppMethodBeat.m2504i(105206);
        C5445a c5445a = null;
        if (i < 0 || !this.gnQ.moveToPosition(i)) {
            C4990ab.m7413e("MicroMsg.CustomContactAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
        } else {
            c5445a = new C40843e(i);
            C7616ad c7616ad = new C7616ad();
            c7616ad.mo8995d(this.gnQ);
            c5445a.ehM = c7616ad;
            c5445a.zmW = clI();
        }
        AppMethodBeat.m2505o(105206);
        return c5445a;
    }

    public final void finish() {
        AppMethodBeat.m2504i(105207);
        super.finish();
        C4990ab.m7416i("MicroMsg.CustomContactAdapter", "finish!");
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        AppMethodBeat.m2505o(105207);
    }
}
