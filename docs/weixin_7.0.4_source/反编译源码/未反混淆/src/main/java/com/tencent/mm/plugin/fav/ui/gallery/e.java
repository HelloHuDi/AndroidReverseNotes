package com.tencent.mm.plugin.fav.ui.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;

public final class e {
    ArrayList<d> mnX;
    boolean mnY;
    ArrayList<b> mnZ;

    static final class a {
        private static final e moa = new e();

        static {
            AppMethodBeat.i(74560);
            AppMethodBeat.o(74560);
        }
    }

    public interface b {
        void bww();
    }

    /* synthetic */ e(byte b) {
        this();
    }

    private e() {
        AppMethodBeat.i(74561);
        this.mnX = new ArrayList();
        this.mnY = false;
        this.mnZ = new ArrayList();
        AppMethodBeat.o(74561);
    }

    public final d Mg(String str) {
        AppMethodBeat.i(74562);
        Iterator it = this.mnX.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.cAJ.mnd.equals(str)) {
                AppMethodBeat.o(74562);
                return dVar;
            }
        }
        AppMethodBeat.o(74562);
        return null;
    }

    public final void clear() {
        AppMethodBeat.i(74563);
        ab.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
        this.mnX.clear();
        Iterator it = this.mnZ.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(74563);
    }

    public final void bwu() {
        AppMethodBeat.i(74564);
        Iterator it = this.mnZ.iterator();
        while (it.hasNext()) {
            ((b) it.next()).bww();
        }
        AppMethodBeat.o(74564);
    }
}
