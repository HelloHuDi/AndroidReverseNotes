package com.tencent.p177mm.plugin.p268aa.p270ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.contact.C36251l;
import com.tencent.p177mm.p612ui.contact.C40845o;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.p268aa.p269a.C9797h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.aa.ui.d */
public final class C41217d extends C40845o {
    private String chatroomName;
    private List<String> gnO = C9797h.m17462vE(this.chatroomName);

    public C41217d(C36251l c36251l, String str) {
        super(c36251l, null, true, true);
        AppMethodBeat.m2504i(40767);
        this.chatroomName = str;
        C4990ab.m7416i("MicroMsg.AASelectInitAdapter", "resetData");
        AppMethodBeat.m2505o(40767);
    }

    /* renamed from: mP */
    public final C5445a mo8217mP(int i) {
        AppMethodBeat.m2504i(40768);
        String str = (String) this.gnO.get(i);
        C1720g.m3537RQ();
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        C26544c c26544c = new C26544c(i);
        c26544c.cuP = this.chatroomName;
        c26544c.ehM = aoO;
        c26544c.zmW = true;
        AppMethodBeat.m2505o(40768);
        return c26544c;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(40769);
        int size = this.gnO.size();
        AppMethodBeat.m2505o(40769);
        return size;
    }
}
