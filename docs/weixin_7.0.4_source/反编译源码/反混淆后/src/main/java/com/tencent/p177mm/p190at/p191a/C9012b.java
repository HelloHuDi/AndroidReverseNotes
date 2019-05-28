package com.tencent.p177mm.p190at.p191a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.p191a.p193c.C1281h;
import com.tencent.p177mm.p190at.p191a.p827a.C17926b;
import com.tencent.p177mm.p190at.p191a.p827a.C25813a;
import com.tencent.p177mm.p190at.p191a.p828f.C17930d;
import com.tencent.p177mm.p190at.p191a.p828f.C9015b;
import com.tencent.p177mm.p190at.p191a.p829g.C9016b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* renamed from: com.tencent.mm.at.a.b */
public final class C9012b {
    public C17926b fGK;
    C1281h fGL;
    private Executor fGM;
    public final Map<Integer, String> fGN = Collections.synchronizedMap(new HashMap());
    public HashMap<Integer, C9015b> fGO = new HashMap();

    public C9012b(C17926b c17926b) {
        AppMethodBeat.m2504i(116037);
        this.fGK = c17926b;
        this.fGL = c17926b.fHa;
        this.fGM = c17926b.fHb;
        this.fGK.fGU.mo43777a(this.fGK.fGW);
        AppMethodBeat.m2505o(116037);
    }

    /* renamed from: a */
    public final void mo20441a(C9015b c9015b, boolean z) {
        AppMethodBeat.m2504i(116038);
        m16269Td();
        this.fGL.execute(c9015b);
        if (z && C9016b.m16285Us()) {
            this.fGM.execute(new C17930d());
        }
        AppMethodBeat.m2505o(116038);
    }

    /* renamed from: DA */
    public final boolean mo20438DA() {
        AppMethodBeat.m2504i(116039);
        boolean DA = this.fGL.mo4576DA();
        AppMethodBeat.m2505o(116039);
        return DA;
    }

    /* renamed from: sB */
    public final Bitmap mo20444sB(String str) {
        AppMethodBeat.m2504i(116040);
        if (this.fGK != null) {
            Bitmap kR = this.fGK.fGT.mo52991kR(str);
            AppMethodBeat.m2505o(116040);
            return kR;
        }
        AppMethodBeat.m2505o(116040);
        return null;
    }

    public final void ahw() {
        AppMethodBeat.m2504i(116041);
        if (this.fGK != null) {
            this.fGK.fGT.clear();
            this.fGK.fGU.ahH();
        }
        AppMethodBeat.m2505o(116041);
    }

    /* renamed from: Td */
    private void m16269Td() {
        AppMethodBeat.m2504i(116042);
        if (this.fGK.fHa.isShutdown()) {
            this.fGL = C25813a.m41070cs(this.fGK.fGQ, this.fGK.fGR);
        }
        AppMethodBeat.m2505o(116042);
    }

    /* renamed from: a */
    public final boolean mo20442a(C25817c c25817c, String str) {
        AppMethodBeat.m2504i(116043);
        if (!C5046bo.isNullOrNil(str)) {
            String str2 = (String) this.fGN.get(Integer.valueOf(c25817c.eQF));
            if (C5046bo.isNullOrNil(str2) || !str.equals(str2)) {
                this.fGN.put(Integer.valueOf(c25817c.eQF), str);
                AppMethodBeat.m2505o(116043);
                return true;
            }
        }
        AppMethodBeat.m2505o(116043);
        return false;
    }

    /* renamed from: a */
    public final void mo20439a(C25817c c25817c) {
        AppMethodBeat.m2504i(116044);
        this.fGN.remove(Integer.valueOf(c25817c.eQF));
        C4990ab.m7411d("MicroMsg.imageloader.ImageLoaderManager", "[cpan] remove image weak holder size:%d viewcode:%s", Integer.valueOf(this.fGN.size()), Integer.valueOf(c25817c.eQF));
        AppMethodBeat.m2505o(116044);
    }

    /* renamed from: a */
    public final void mo20440a(C9015b c9015b) {
        AppMethodBeat.m2504i(116045);
        if (!(this.fGO == null || c9015b.fHr == null)) {
            C9015b c9015b2 = (C9015b) this.fGO.get(Integer.valueOf(c9015b.fHr.eQF));
            if (!(c9015b2 == null || c9015b2.fHr == null || c9015b.fHr.eQF != c9015b2.fHr.eQF)) {
                this.fGL.remove(c9015b2);
                C4990ab.m7411d("MicroMsg.imageloader.ImageLoaderManager", "remove taks url:%s", c9015b2.url);
            }
            this.fGO.put(Integer.valueOf(c9015b.fHr.eQF), c9015b);
        }
        AppMethodBeat.m2505o(116045);
    }
}
