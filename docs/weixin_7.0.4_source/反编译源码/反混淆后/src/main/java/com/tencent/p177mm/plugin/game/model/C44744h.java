package com.tencent.p177mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.p428f.C20964d;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.model.h */
public final class C44744h extends C43190g {

    /* renamed from: com.tencent.mm.plugin.game.model.h$1 */
    static class C121691 implements Runnable {
        final /* synthetic */ LinkedList mVS;

        C121691(LinkedList linkedList) {
            this.mVS = linkedList;
        }

        public final void run() {
            AppMethodBeat.m2504i(111245);
            LinkedList linkedList = new LinkedList();
            Iterator it = this.mVS.iterator();
            while (it.hasNext()) {
                Iterator it2 = C43190g.m76768s(((C44744h) it.next()).optJSONArray("items")).iterator();
                while (it2.hasNext()) {
                    C20992c c20992c = (C20992c) it2.next();
                    if (!C5046bo.isNullOrNil(c20992c.field_appId)) {
                        linkedList.add(c20992c.field_appId);
                    }
                }
            }
            it = C46001c.bFF().iterator();
            while (it.hasNext()) {
                C40439f c40439f = (C40439f) it.next();
                if (!linkedList.contains(c40439f.field_appId)) {
                    C34832a.bYJ().mo56568b(c40439f, new String[0]);
                    C4990ab.m7416i("MicroMsg.GameDataSearchGameList", "delete appid : " + c40439f.field_appId);
                }
            }
            AppMethodBeat.m2505o(111245);
        }
    }

    protected C44744h(String str) {
        super(str);
    }

    public final void bEf() {
        AppMethodBeat.m2504i(111246);
        LinkedList s = C43190g.m76768s(optJSONArray("items"));
        Iterator it = s.iterator();
        while (it.hasNext()) {
            C20992c c20992c = (C20992c) it.next();
            c20992c.mo44077ii(c20992c.mVk);
        }
        C20964d.m32220ac(s);
        AppMethodBeat.m2505o(111246);
    }
}
