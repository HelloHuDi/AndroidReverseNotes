package com.tencent.mm.at.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.a;
import com.tencent.mm.at.a.c.h;
import com.tencent.mm.at.a.f.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class b {
    public com.tencent.mm.at.a.a.b fGK;
    h fGL;
    private Executor fGM;
    public final Map<Integer, String> fGN = Collections.synchronizedMap(new HashMap());
    public HashMap<Integer, com.tencent.mm.at.a.f.b> fGO = new HashMap();

    public b(com.tencent.mm.at.a.a.b bVar) {
        AppMethodBeat.i(116037);
        this.fGK = bVar;
        this.fGL = bVar.fHa;
        this.fGM = bVar.fHb;
        this.fGK.fGU.a(this.fGK.fGW);
        AppMethodBeat.o(116037);
    }

    public final void a(com.tencent.mm.at.a.f.b bVar, boolean z) {
        AppMethodBeat.i(116038);
        Td();
        this.fGL.execute(bVar);
        if (z && com.tencent.mm.at.a.g.b.Us()) {
            this.fGM.execute(new d());
        }
        AppMethodBeat.o(116038);
    }

    public final boolean DA() {
        AppMethodBeat.i(116039);
        boolean DA = this.fGL.DA();
        AppMethodBeat.o(116039);
        return DA;
    }

    public final Bitmap sB(String str) {
        AppMethodBeat.i(116040);
        if (this.fGK != null) {
            Bitmap kR = this.fGK.fGT.kR(str);
            AppMethodBeat.o(116040);
            return kR;
        }
        AppMethodBeat.o(116040);
        return null;
    }

    public final void ahw() {
        AppMethodBeat.i(116041);
        if (this.fGK != null) {
            this.fGK.fGT.clear();
            this.fGK.fGU.ahH();
        }
        AppMethodBeat.o(116041);
    }

    private void Td() {
        AppMethodBeat.i(116042);
        if (this.fGK.fHa.isShutdown()) {
            this.fGL = a.cs(this.fGK.fGQ, this.fGK.fGR);
        }
        AppMethodBeat.o(116042);
    }

    public final boolean a(c cVar, String str) {
        AppMethodBeat.i(116043);
        if (!bo.isNullOrNil(str)) {
            String str2 = (String) this.fGN.get(Integer.valueOf(cVar.eQF));
            if (bo.isNullOrNil(str2) || !str.equals(str2)) {
                this.fGN.put(Integer.valueOf(cVar.eQF), str);
                AppMethodBeat.o(116043);
                return true;
            }
        }
        AppMethodBeat.o(116043);
        return false;
    }

    public final void a(c cVar) {
        AppMethodBeat.i(116044);
        this.fGN.remove(Integer.valueOf(cVar.eQF));
        ab.d("MicroMsg.imageloader.ImageLoaderManager", "[cpan] remove image weak holder size:%d viewcode:%s", Integer.valueOf(this.fGN.size()), Integer.valueOf(cVar.eQF));
        AppMethodBeat.o(116044);
    }

    public final void a(com.tencent.mm.at.a.f.b bVar) {
        AppMethodBeat.i(116045);
        if (!(this.fGO == null || bVar.fHr == null)) {
            com.tencent.mm.at.a.f.b bVar2 = (com.tencent.mm.at.a.f.b) this.fGO.get(Integer.valueOf(bVar.fHr.eQF));
            if (!(bVar2 == null || bVar2.fHr == null || bVar.fHr.eQF != bVar2.fHr.eQF)) {
                this.fGL.remove(bVar2);
                ab.d("MicroMsg.imageloader.ImageLoaderManager", "remove taks url:%s", bVar2.url);
            }
            this.fGO.put(Integer.valueOf(bVar.fHr.eQF), bVar);
        }
        AppMethodBeat.o(116045);
    }
}
