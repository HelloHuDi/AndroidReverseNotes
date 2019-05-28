package com.tencent.mm.plugin.fav.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ge;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;

public final class a extends c<ge> {
    private l mhy;
    private ae<Long, g> moD;

    public a() {
        AppMethodBeat.i(74609);
        this.moD = new ae(10);
        this.xxI = ge.class.getName().hashCode();
        AppMethodBeat.o(74609);
    }

    private boolean a(ge geVar) {
        g gVar;
        AppMethodBeat.i(74610);
        if (geVar.cAt.cvv == 0) {
            gVar = null;
        } else if (geVar.cAt.cAA) {
            gVar = ((com.tencent.mm.plugin.fav.a.ae) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fav.a.ae.class)).getFavItemInfoStorage().iE(geVar.cAt.cvv);
            if (gVar != null) {
                this.moD.put(Long.valueOf(geVar.cAt.cvv), gVar);
            }
        } else {
            boolean z;
            g gVar2 = (g) this.moD.get(Long.valueOf(geVar.cAt.cvv));
            String str = "MicroMsg.FavImageServiceListener";
            String str2 = "get item from cache itemInfo is null? %B";
            Object[] objArr = new Object[1];
            if (gVar2 == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            ab.d(str, str2, objArr);
            if (gVar2 == null) {
                gVar = ((com.tencent.mm.plugin.fav.a.ae) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fav.a.ae.class)).getFavItemInfoStorage().iE(geVar.cAt.cvv);
                if (gVar != null) {
                    this.moD.put(Long.valueOf(geVar.cAt.cvv), gVar);
                }
            } else {
                gVar = gVar2;
            }
        }
        ab.d("MicroMsg.FavImageServiceListener", "image serivce callback type %d, localId %d", Integer.valueOf(geVar.cAt.opType), Long.valueOf(geVar.cAt.cvv));
        if (gVar != null || geVar.cAt.opType == 3 || geVar.cAt.opType == 4) {
            switch (geVar.cAt.opType) {
                case 0:
                    geVar.cAu.cAB = l.a(geVar.cAt.cAv, gVar);
                    break;
                case 1:
                    if (this.mhy != null) {
                        this.mhy.b(geVar.cAt.cAw, geVar.cAt.cAv, gVar, geVar.cAt.cAx, geVar.cAt.width, geVar.cAt.height);
                        break;
                    }
                    ab.w("MicroMsg.FavImageServiceListener", "imageServer is null");
                    break;
                case 2:
                    ab.d("MicroMsg.FavImageServiceListener", "get img from Cache %s", Boolean.valueOf(geVar.cAt.cAy));
                    if (!geVar.cAt.cAy) {
                        geVar.cAu.cAB = l.b(geVar.cAt.cAv, gVar, geVar.cAt.maxWidth);
                        break;
                    }
                    geVar.cAu.cAB = l.j(geVar.cAt.cAv);
                    break;
                case 3:
                    ab.d("MicroMsg.FavImageServiceListener", "create image server");
                    if (this.mhy != null) {
                        this.mhy.destory();
                    }
                    this.mhy = new l(geVar.cAt.context, 16);
                    break;
                case 4:
                    ab.d("MicroMsg.FavImageServiceListener", "destroy image server");
                    if (this.mhy != null) {
                        this.mhy.destory();
                        this.mhy = null;
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(74610);
        } else {
            AppMethodBeat.o(74610);
        }
        return false;
    }
}
