package com.tencent.p177mm.plugin.multitalk.p459ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.contact.C36251l;
import com.tencent.p177mm.p612ui.contact.C40845o;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.multitalk.p459ui.widget.C21335a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.multitalk.ui.a */
public final class C34576a extends C40845o {
    private String chatroomName;
    private List<String> gnO = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14889oe(this.chatroomName);

    public C34576a(C36251l c36251l, String str) {
        super(c36251l, null, true, true);
        AppMethodBeat.m2504i(54174);
        this.chatroomName = str;
        C4990ab.m7416i("MicroMsg.multitalk.MultiTalkSelectInitAdapter", "resetData");
        if (this.gnO == null) {
            this.gnO = new ArrayList();
        }
        AppMethodBeat.m2505o(54174);
    }

    /* renamed from: mP */
    public final C5445a mo8217mP(int i) {
        AppMethodBeat.m2504i(54175);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO((String) this.gnO.get(i));
        C21335a c21335a = new C21335a(i);
        c21335a.ehM = aoO;
        c21335a.zmW = clI();
        AppMethodBeat.m2505o(54175);
        return c21335a;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(54176);
        int size = this.gnO.size();
        AppMethodBeat.m2505o(54176);
        return size;
    }
}
