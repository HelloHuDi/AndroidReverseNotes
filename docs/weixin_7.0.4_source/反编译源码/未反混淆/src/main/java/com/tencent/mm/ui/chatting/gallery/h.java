package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Iterator;

public final class h {
    public ArrayList<bi> mnX;
    public boolean mnY;
    ArrayList<b> mnZ;

    public static final class a {
        private static final h yVE = new h();

        static {
            AppMethodBeat.i(32165);
            AppMethodBeat.o(32165);
        }
    }

    public interface b {
        void clear();

        void dFU();
    }

    /* synthetic */ h(byte b) {
        this();
    }

    private h() {
        AppMethodBeat.i(32166);
        this.mnX = new ArrayList();
        this.mnY = false;
        this.mnZ = new ArrayList();
        AppMethodBeat.o(32166);
    }

    public final void bC(bi biVar) {
        AppMethodBeat.i(32167);
        if (biVar == null) {
            AppMethodBeat.o(32167);
            return;
        }
        ab.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", Long.valueOf(biVar.field_msgId));
        this.mnX.remove(biVar);
        this.mnX.remove(no(biVar.field_msgId));
        this.mnX.add(biVar);
        dFW();
        AppMethodBeat.o(32167);
    }

    private bi no(long j) {
        AppMethodBeat.i(32168);
        Iterator it = this.mnX.iterator();
        while (it.hasNext()) {
            bi biVar = (bi) it.next();
            if (biVar.field_msgId == j) {
                AppMethodBeat.o(32168);
                return biVar;
            }
        }
        AppMethodBeat.o(32168);
        return null;
    }

    public final void bD(bi biVar) {
        AppMethodBeat.i(32169);
        if (biVar == null) {
            AppMethodBeat.o(32169);
            return;
        }
        ab.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", Long.valueOf(biVar.field_msgId));
        this.mnX.remove(biVar);
        this.mnX.remove(no(biVar.field_msgId));
        dFW();
        AppMethodBeat.o(32169);
    }

    public final void clear() {
        AppMethodBeat.i(32170);
        ab.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
        this.mnX.clear();
        bfa();
        AppMethodBeat.o(32170);
    }

    public final void detach() {
        AppMethodBeat.i(32171);
        this.mnZ.clear();
        clear();
        this.mnY = false;
        AppMethodBeat.o(32171);
    }

    public final boolean bE(bi biVar) {
        AppMethodBeat.i(32172);
        if (biVar == null) {
            AppMethodBeat.o(32172);
            return false;
        }
        Iterator it = this.mnX.iterator();
        while (it.hasNext()) {
            if (((bi) it.next()).field_msgId == biVar.field_msgId) {
                AppMethodBeat.o(32172);
                return true;
            }
        }
        AppMethodBeat.o(32172);
        return false;
    }

    private void dFW() {
        AppMethodBeat.i(32173);
        Iterator it = this.mnZ.iterator();
        while (it.hasNext()) {
            ((b) it.next()).dFU();
        }
        AppMethodBeat.o(32173);
    }

    private void bfa() {
        AppMethodBeat.i(32174);
        Iterator it = this.mnZ.iterator();
        while (it.hasNext()) {
            ((b) it.next()).clear();
        }
        AppMethodBeat.o(32174);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(32175);
        this.mnZ.remove(bVar);
        this.mnZ.add(bVar);
        AppMethodBeat.o(32175);
    }
}
