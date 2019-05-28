package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.bm;
import com.tencent.mm.plugin.game.d.cr;
import com.tencent.mm.plugin.game.d.dc;
import com.tencent.mm.plugin.game.d.l;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.plugin.game.ui.GameLibraryCategoriesView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.core.biometric.FaceManager;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class ae extends x {
    private int mXJ;
    public bm mYe;
    public LinkedList<c> mYf;
    public LinkedList<c> mYg;

    public ae(a aVar, boolean z, int i) {
        AppMethodBeat.i(111378);
        this.mXJ = 0;
        if (aVar == null) {
            this.mYe = new bm();
            AppMethodBeat.o(111378);
            return;
        }
        this.mYe = (bm) aVar;
        this.mXJ = i;
        this.mYf = bEM();
        this.mYg = bEN();
        if (z) {
            ((c) g.K(c.class)).bCZ().b("pb_library", aVar);
        }
        d.ac(this.mYf);
        d.ac(this.mYg);
        AppMethodBeat.o(111378);
    }

    public ae(byte[] bArr) {
        AppMethodBeat.i(111379);
        this.mXJ = 0;
        this.mYe = new bm();
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(111379);
            return;
        }
        try {
            this.mYe.parseFrom(bArr);
        } catch (IOException e) {
            ab.e("MicroMsg.GamePBDataLibrary", "Parsing Failed: %s", e.getMessage());
        }
        this.mYf = bEM();
        this.mYg = bEN();
        d.ac(this.mYf);
        d.ac(this.mYg);
        AppMethodBeat.o(111379);
    }

    private LinkedList<c> bEM() {
        AppMethodBeat.i(111380);
        LinkedList<c> linkedList = new LinkedList();
        if (this.mYe.ncr == null || this.mYe.ncr.ncV == null || this.mYe.ncr.ncV.ndk == null) {
            AppMethodBeat.o(111380);
            return linkedList;
        }
        Iterator it = this.mYe.ncr.ncV.ndk.iterator();
        int i = 1;
        while (it.hasNext()) {
            cr crVar = (cr) it.next();
            c a = x.a(crVar.mZk);
            if (a != null) {
                a.mVu = crVar.mZk.mZz;
                a.scene = 11;
                a.cKG = FaceManager.FACE_ACQUIRED_DARK;
                int i2 = i + 1;
                a.position = i;
                linkedList.add(a);
                i = i2;
            }
        }
        AppMethodBeat.o(111380);
        return linkedList;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private LinkedList<c> bEN() {
        AppMethodBeat.i(111381);
        LinkedList<c> linkedList = new LinkedList();
        if (this.mYe.ncs == null) {
            AppMethodBeat.o(111381);
            return linkedList;
        }
        int i = this.mXJ + 1;
        int i2 = (this.mXJ / 15) + 901;
        Iterator it = this.mYe.ncs.iterator();
        while (true) {
            int i3 = i2;
            if (it.hasNext()) {
                com.tencent.mm.plugin.game.d.c cVar = (com.tencent.mm.plugin.game.d.c) it.next();
                c cVar2 = null;
                switch (cVar.jCt) {
                    case 1:
                        cVar2 = x.a(cVar.mZk);
                        if (cVar2 != null) {
                            int i4 = i + 1;
                            cVar2.position = i;
                            i2 = i3;
                            i = i4;
                            break;
                        }
                    case 2:
                        if (cVar.mZn != null) {
                            cVar2 = x.a(cVar.mZn.mZk);
                            if (cVar2 != null) {
                                cVar2.type = 1;
                                cVar2.mVm = cVar.mZn.mZm;
                                cVar2.mVn = cVar.mZn.mZl;
                                i2 = i3 + 1;
                                cVar2.position = i3;
                                break;
                            }
                        }
                    default:
                        i2 = i3;
                        break;
                }
                if (cVar2 != null) {
                    cVar2.scene = 11;
                    cVar2.cKG = FaceManager.FACE_ACQUIRED_HACKER;
                    linkedList.add(cVar2);
                }
            } else {
                AppMethodBeat.o(111381);
                return linkedList;
            }
        }
    }

    public final HashMap<Integer, String> bEO() {
        AppMethodBeat.i(111382);
        HashMap<Integer, String> linkedHashMap = new LinkedHashMap();
        if (this.mYe.ncr == null || this.mYe.ncr.ncY == null) {
            AppMethodBeat.o(111382);
            return linkedHashMap;
        }
        Iterator it = this.mYe.ncr.ncY.iterator();
        while (it.hasNext()) {
            dc dcVar = (dc) it.next();
            int i = dcVar.ncp;
            linkedHashMap.put(Integer.valueOf(i), dcVar.Name);
        }
        AppMethodBeat.o(111382);
        return linkedHashMap;
    }

    public final LinkedList<GameLibraryCategoriesView.a> bEP() {
        AppMethodBeat.i(111383);
        if (this.mYe.ncr == null || this.mYe.ncr.ncW == null) {
            AppMethodBeat.o(111383);
            return null;
        }
        int i = 0;
        LinkedList<GameLibraryCategoriesView.a> linkedList = new LinkedList();
        Iterator it = this.mYe.ncr.ncW.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                l lVar = (l) it.next();
                GameLibraryCategoriesView.a aVar = new GameLibraryCategoriesView.a();
                aVar.njM = lVar.mZU;
                aVar.njN = lVar.Name;
                aVar.njO = lVar.mZm;
                aVar.haO = lVar.mZs;
                i = i2 + 1;
                aVar.position = i;
                linkedList.add(aVar);
            } else {
                AppMethodBeat.o(111383);
                return linkedList;
            }
        }
    }
}
