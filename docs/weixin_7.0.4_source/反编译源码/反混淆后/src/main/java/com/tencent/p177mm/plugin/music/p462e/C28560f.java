package com.tencent.p177mm.plugin.music.p462e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p230g.p231a.C45337kd;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.music.e.f */
public final class C28560f extends C4884c<C45337kd> {
    public C28560f() {
        AppMethodBeat.m2504i(137529);
        this.xxI = C45337kd.class.getName().hashCode();
        AppMethodBeat.m2505o(137529);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        boolean z;
        AppMethodBeat.m2504i(137530);
        C45337kd c45337kd = (C45337kd) c4883b;
        if (C39435k.oLY != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            C39435k bUf;
            switch (c45337kd.cFz.action) {
                case -3:
                    c45337kd.cFA.csN = C39435k.bUf().bTS().aie();
                    break;
                case -2:
                    c45337kd.cFA.cFB = C39435k.bUf().bTQ();
                    break;
                case -1:
                    C39435k.bUf().aic();
                    break;
                case 0:
                    C39435k.bUf().mo62388p(c45337kd.cFz.cFB);
                    break;
                case 1:
                    C39435k.bUf().bTS().bTb();
                    break;
                case 2:
                    C39435k.bUf().bTS().resume();
                    break;
                case 3:
                    bUf = C39435k.bUf();
                    bUf.oLX.mo46662j(c45337kd.cFz.cFB);
                    break;
                case 4:
                    bUf = C39435k.bUf();
                    List list = c45337kd.cFz.cAV;
                    int i = c45337kd.cFz.cFC;
                    C4990ab.m7416i("MicroMsg.Music.MusicPlayerManager", "startPlayNewMusicList");
                    bUf.mo62389t(bUf.oLX.mo46665m(list, i));
                    break;
                case 5:
                    bUf = C39435k.bUf();
                    bUf.oLX.mo46657d(c45337kd.cFz.cAV, c45337kd.cFz.cFD);
                    break;
                case 6:
                    bUf = C39435k.bUf();
                    C9058e c9058e = c45337kd.cFz.cFB;
                    if (c9058e != null) {
                        C4990ab.m7416i("MicroMsg.Music.MusicPlayerManager", "startMusicInList");
                        bUf.mo62389t(bUf.oLX.mo46659h(c9058e));
                        break;
                    }
                    C4990ab.m7416i("MicroMsg.Music.MusicPlayerManager", "musicWrapper is null");
                    break;
                case 7:
                    c45337kd.cFA.csN = C39435k.bUf().bTS().mo8037lP(c45337kd.cFz.position);
                    break;
                case 8:
                    c45337kd.cFA.cFF = C39435k.bUf().bTS().bSP();
                    break;
                case 9:
                    c45337kd.cFA.csN = C39435k.bUf().bTS().aig();
                    break;
                case 10:
                    c45337kd.cFA.csN = C39435k.bUf().bTS().aif();
                    break;
                case 11:
                    C39435k.bUf().mo46678zI(600000);
                    break;
            }
        }
        C4990ab.m7412e("MicroMsg.Music.MusicActionListener", "don't anything, must init MusicPlayerManager first with MusicLogic before!");
        AppMethodBeat.m2505o(137530);
        return false;
    }
}
