package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.LinkedList;

public final class a implements OnClickListener {
    private Context context;
    private a gwN;

    public interface a {
        void W(String str, boolean z);

        void wk(String str);
    }

    public static class b {
        public int gwP;
        public int position;
        public String username;
    }

    public a(Context context, a aVar) {
        this.context = context;
        this.gwN = aVar;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(108512);
        b bVar = (b) view.getTag();
        final String str = bVar.username;
        int i = bVar.gwP;
        final int i2 = bVar.position;
        final ad aoO = ((j) g.K(j.class)).XM().aoO(str);
        if (bo.isNullOrNil(aoO.field_username)) {
            aoO.setUsername(str);
        }
        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.context, new com.tencent.mm.pluginsdk.ui.applet.a.a() {
            public final void a(boolean z, boolean z2, String str, String str2) {
                AppMethodBeat.i(108511);
                if (z) {
                    a.B(aoO);
                    a.this.gwN.wk(str);
                    AppMethodBeat.o(108511);
                    return;
                }
                a.this.gwN.W(str, z2);
                AppMethodBeat.o(108511);
            }
        });
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(i));
        aVar.e(str, linkedList);
        AppMethodBeat.o(108512);
    }

    static /* synthetic */ void B(ad adVar) {
        com.tencent.mm.n.a adVar2;
        AppMethodBeat.i(108513);
        if (((int) adVar2.ewQ) == 0) {
            ((j) g.K(j.class)).XM().aa(adVar2);
            if (!bo.isNullOrNil(adVar2.field_username)) {
                adVar2 = ((j) g.K(j.class)).XM().aoO(adVar2.field_username);
            }
            AppMethodBeat.o(108513);
        }
        if (((int) adVar2.ewQ) <= 0) {
            ab.e("MicroMsg.AddContactListener", "addContact : insert contact failed");
            AppMethodBeat.o(108513);
            return;
        }
        t.q(adVar2);
        AppMethodBeat.o(108513);
    }
}
