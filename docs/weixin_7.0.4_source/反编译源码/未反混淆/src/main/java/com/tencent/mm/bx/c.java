package com.tencent.mm.bx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.e;
import com.tencent.mm.api.p;
import com.tencent.mm.br.b;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.cache.g;
import com.tencent.mm.e.a;
import java.util.Iterator;
import java.util.Stack;

public final class c implements p {
    private b cjc;

    public c(b bVar) {
        this.cjc = bVar;
    }

    public final int Ar() {
        AppMethodBeat.i(116356);
        com.tencent.mm.cache.c cVar = (com.tencent.mm.cache.c) ArtistCacheManager.Jc().a(a.EMOJI_AND_TEXT);
        if (cVar == null) {
            AppMethodBeat.o(116356);
            return 0;
        }
        int i = cVar.Jk()[1];
        AppMethodBeat.o(116356);
        return i;
    }

    public final int As() {
        AppMethodBeat.i(116357);
        com.tencent.mm.cache.c cVar = (com.tencent.mm.cache.c) ArtistCacheManager.Jc().a(a.EMOJI_AND_TEXT);
        if (cVar == null) {
            AppMethodBeat.o(116357);
            return 0;
        }
        int i = cVar.Jk()[0];
        AppMethodBeat.o(116357);
        return i;
    }

    public final int At() {
        AppMethodBeat.i(116358);
        g gVar = (g) ArtistCacheManager.Jc().a(a.MOSAIC);
        if (gVar == null) {
            AppMethodBeat.o(116358);
            return 0;
        }
        int ac = gVar.ac(false);
        AppMethodBeat.o(116358);
        return ac;
    }

    public final int Au() {
        AppMethodBeat.i(116359);
        com.tencent.mm.cache.b bVar = (com.tencent.mm.cache.b) ArtistCacheManager.Jc().a(a.DOODLE);
        if (bVar == null) {
            AppMethodBeat.o(116359);
            return 0;
        }
        int ac = bVar.ac(false);
        AppMethodBeat.o(116359);
        return ac;
    }

    public final int Av() {
        AppMethodBeat.i(116360);
        int i = 0;
        com.tencent.mm.cache.b bVar = (com.tencent.mm.cache.b) ArtistCacheManager.Jc().a(a.DOODLE);
        if (bVar != null) {
            i = bVar.efs + 0;
        }
        g gVar = (g) ArtistCacheManager.Jc().a(a.MOSAIC);
        if (gVar != null) {
            i += gVar.efs;
        }
        AppMethodBeat.o(116360);
        return i;
    }

    public final boolean isCropped() {
        AppMethodBeat.i(116361);
        com.tencent.mm.cache.a aVar = (com.tencent.mm.cache.a) ArtistCacheManager.Jc().a(a.CROP_PHOTO);
        if (aVar == null) {
            AppMethodBeat.o(116361);
            return false;
        } else if (aVar.ac(false) > 0) {
            AppMethodBeat.o(116361);
            return true;
        } else {
            AppMethodBeat.o(116361);
            return false;
        }
    }

    public final boolean Aw() {
        boolean z = false;
        AppMethodBeat.i(116362);
        com.tencent.mm.e.b b = this.cjc.b(e.CROP_PHOTO);
        if (b != null && b.CG() == a.CROP_PHOTO) {
            boolean z2;
            if (((com.tencent.mm.e.c) b).cjO > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            z = z2;
        }
        AppMethodBeat.o(116362);
        return z;
    }

    public final int getTextColor() {
        AppMethodBeat.i(116363);
        com.tencent.mm.cache.c cVar = (com.tencent.mm.cache.c) ArtistCacheManager.Jc().a(a.EMOJI_AND_TEXT);
        if (cVar == null) {
            AppMethodBeat.o(116363);
            return 0;
        }
        int i;
        Stack stack = cVar.efq;
        if (stack != null) {
            Iterator it = stack.iterator();
            i = 0;
            while (it.hasNext()) {
                com.tencent.mm.y.c cVar2 = (com.tencent.mm.y.c) it.next();
                if (cVar2 instanceof com.tencent.mm.y.e) {
                    com.tencent.mm.y.e eVar = (com.tencent.mm.y.e) cVar2;
                    int[] iArr = com.tencent.mm.view.footer.a.AcD;
                    for (int i2 = 0; i2 < iArr.length; i2++) {
                        if (eVar.mColor == iArr[i2]) {
                            i = (1 << i2) | i;
                            break;
                        }
                    }
                }
            }
        } else {
            i = 0;
        }
        AppMethodBeat.o(116363);
        return i;
    }

    public final int Ax() {
        AppMethodBeat.i(116364);
        com.tencent.mm.cache.b bVar = (com.tencent.mm.cache.b) ArtistCacheManager.Jc().a(a.DOODLE);
        if (bVar == null) {
            AppMethodBeat.o(116364);
            return 0;
        }
        int i;
        Stack stack = bVar.efq;
        if (stack != null) {
            Iterator it = stack.iterator();
            i = 0;
            while (it.hasNext()) {
                com.tencent.mm.y.b bVar2 = (com.tencent.mm.y.b) it.next();
                int[] iArr = com.tencent.mm.view.footer.a.AcD;
                for (int i2 = 0; i2 < iArr.length; i2++) {
                    if (bVar2.mColor == iArr[i2]) {
                        i = (1 << i2) | i;
                        break;
                    }
                }
            }
        } else {
            i = 0;
        }
        AppMethodBeat.o(116364);
        return i;
    }

    public final boolean Ay() {
        AppMethodBeat.i(116365);
        com.tencent.mm.cache.b bVar = (com.tencent.mm.cache.b) ArtistCacheManager.Jc().a(a.DOODLE);
        g gVar = (g) ArtistCacheManager.Jc().a(a.MOSAIC);
        com.tencent.mm.cache.a aVar = (com.tencent.mm.cache.a) ArtistCacheManager.Jc().a(a.CROP_PHOTO);
        com.tencent.mm.cache.c cVar = (com.tencent.mm.cache.c) ArtistCacheManager.Jc().a(a.EMOJI_AND_TEXT);
        if ((bVar == null || bVar.ac(true) <= 0) && ((gVar == null || gVar.ac(true) <= 0) && ((cVar == null || cVar.ac(true) <= 0) && (aVar == null || aVar.ac(true) <= 0)))) {
            AppMethodBeat.o(116365);
            return false;
        }
        AppMethodBeat.o(116365);
        return true;
    }

    public final String Az() {
        AppMethodBeat.i(116366);
        String str = ((com.tencent.mm.cache.c) ArtistCacheManager.Jc().a(a.EMOJI_AND_TEXT)).kb(",")[0];
        AppMethodBeat.o(116366);
        return str;
    }

    public final String AA() {
        AppMethodBeat.i(116367);
        String str = ((com.tencent.mm.cache.c) ArtistCacheManager.Jc().a(a.EMOJI_AND_TEXT)).kb("||")[1];
        AppMethodBeat.o(116367);
        return str;
    }
}
