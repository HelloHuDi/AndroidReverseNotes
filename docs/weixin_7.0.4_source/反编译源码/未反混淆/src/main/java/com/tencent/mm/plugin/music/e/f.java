package com.tencent.mm.plugin.music.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.g.a.kd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public final class f extends c<kd> {
    public f() {
        AppMethodBeat.i(137529);
        this.xxI = kd.class.getName().hashCode();
        AppMethodBeat.o(137529);
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z;
        AppMethodBeat.i(137530);
        kd kdVar = (kd) bVar;
        if (k.oLY != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            k bUf;
            switch (kdVar.cFz.action) {
                case -3:
                    kdVar.cFA.csN = k.bUf().bTS().aie();
                    break;
                case -2:
                    kdVar.cFA.cFB = k.bUf().bTQ();
                    break;
                case -1:
                    k.bUf().aic();
                    break;
                case 0:
                    k.bUf().p(kdVar.cFz.cFB);
                    break;
                case 1:
                    k.bUf().bTS().bTb();
                    break;
                case 2:
                    k.bUf().bTS().resume();
                    break;
                case 3:
                    bUf = k.bUf();
                    bUf.oLX.j(kdVar.cFz.cFB);
                    break;
                case 4:
                    bUf = k.bUf();
                    List list = kdVar.cFz.cAV;
                    int i = kdVar.cFz.cFC;
                    ab.i("MicroMsg.Music.MusicPlayerManager", "startPlayNewMusicList");
                    bUf.t(bUf.oLX.m(list, i));
                    break;
                case 5:
                    bUf = k.bUf();
                    bUf.oLX.d(kdVar.cFz.cAV, kdVar.cFz.cFD);
                    break;
                case 6:
                    bUf = k.bUf();
                    e eVar = kdVar.cFz.cFB;
                    if (eVar != null) {
                        ab.i("MicroMsg.Music.MusicPlayerManager", "startMusicInList");
                        bUf.t(bUf.oLX.h(eVar));
                        break;
                    }
                    ab.i("MicroMsg.Music.MusicPlayerManager", "musicWrapper is null");
                    break;
                case 7:
                    kdVar.cFA.csN = k.bUf().bTS().lP(kdVar.cFz.position);
                    break;
                case 8:
                    kdVar.cFA.cFF = k.bUf().bTS().bSP();
                    break;
                case 9:
                    kdVar.cFA.csN = k.bUf().bTS().aig();
                    break;
                case 10:
                    kdVar.cFA.csN = k.bUf().bTS().aif();
                    break;
                case 11:
                    k.bUf().zI(600000);
                    break;
            }
        }
        ab.e("MicroMsg.Music.MusicActionListener", "don't anything, must init MusicPlayerManager first with MusicLogic before!");
        AppMethodBeat.o(137530);
        return false;
    }
}
