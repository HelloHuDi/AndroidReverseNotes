package com.tencent.p177mm.plugin.account.friend.p273ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14916a.C14917a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.account.friend.ui.a */
public final class C26595a implements OnClickListener {
    private Context context;
    private C26596a gwN;

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.a$a */
    public interface C26596a {
        /* renamed from: W */
        void mo44376W(String str, boolean z);

        /* renamed from: wk */
        void mo44377wk(String str);
    }

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.a$b */
    public static class C26597b {
        public int gwP;
        public int position;
        public String username;
    }

    public C26595a(Context context, C26596a c26596a) {
        this.context = context;
        this.gwN = c26596a;
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(108512);
        C26597b c26597b = (C26597b) view.getTag();
        final String str = c26597b.username;
        int i = c26597b.gwP;
        final int i2 = c26597b.position;
        final C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (C5046bo.isNullOrNil(aoO.field_username)) {
            aoO.setUsername(str);
        }
        C14916a c14916a = new C14916a(this.context, new C14917a() {
            /* renamed from: a */
            public final void mo5739a(boolean z, boolean z2, String str, String str2) {
                AppMethodBeat.m2504i(108511);
                if (z) {
                    C26595a.m42456B(aoO);
                    C26595a.this.gwN.mo44377wk(str);
                    AppMethodBeat.m2505o(108511);
                    return;
                }
                C26595a.this.gwN.mo44376W(str, z2);
                AppMethodBeat.m2505o(108511);
            }
        });
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(i));
        c14916a.mo27244e(str, linkedList);
        AppMethodBeat.m2505o(108512);
    }

    /* renamed from: B */
    static /* synthetic */ void m42456B(C7616ad c7616ad) {
        C7486a c7616ad2;
        AppMethodBeat.m2504i(108513);
        if (((int) c7616ad2.ewQ) == 0) {
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15708aa(c7616ad2);
            if (!C5046bo.isNullOrNil(c7616ad2.field_username)) {
                c7616ad2 = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c7616ad2.field_username);
            }
            AppMethodBeat.m2505o(108513);
        }
        if (((int) c7616ad2.ewQ) <= 0) {
            C4990ab.m7412e("MicroMsg.AddContactListener", "addContact : insert contact failed");
            AppMethodBeat.m2505o(108513);
            return;
        }
        C1855t.m3960q(c7616ad2);
        AppMethodBeat.m2505o(108513);
    }
}
