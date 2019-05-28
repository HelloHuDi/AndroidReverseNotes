package com.tencent.mm.plugin.gallery.stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.iu;
import com.tencent.mm.m.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.gallery.stub.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;

public class GalleryStubService extends Service {
    private a mOD = new a() {
        public final void aK(int i, String str) {
            AppMethodBeat.i(21341);
            h.pYm.X(i, str);
            AppMethodBeat.o(21341);
        }

        public final void a(String str, String str2, boolean z, int i, boolean z2) {
            AppMethodBeat.i(21342);
            if (com.tencent.mm.sdk.b.a.xxA != null) {
                iu iuVar = new iu();
                iuVar.cDU.cDV = Boolean.valueOf(z);
                iuVar.cDU.imagePath = str;
                iuVar.cDU.cDW = i;
                iuVar.cDU.toUser = str2;
                iuVar.cDU.cDX = Boolean.valueOf(z2);
                com.tencent.mm.sdk.b.a.xxA.m(iuVar);
            }
            AppMethodBeat.o(21342);
        }

        public final void bCv() {
            AppMethodBeat.i(21343);
            g.BO(19);
            AppMethodBeat.o(21343);
        }

        public final int Nd() {
            AppMethodBeat.i(21344);
            int Nd = b.Nd();
            AppMethodBeat.o(21344);
            return Nd;
        }

        public final int Nb() {
            AppMethodBeat.i(21345);
            int Nb = b.Nb();
            AppMethodBeat.o(21345);
            return Nb;
        }

        public final int Na() {
            AppMethodBeat.i(21346);
            int Na = b.Na();
            AppMethodBeat.o(21346);
            return Na;
        }

        public final boolean hC(boolean z) {
            AppMethodBeat.i(21347);
            aw.ZK();
            boolean z2 = c.Ry().getBoolean(ac.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, z);
            AppMethodBeat.o(21347);
            return z2;
        }

        public final int ND(String str) {
            AppMethodBeat.i(21348);
            PInt pInt = new PInt();
            u.a(str, pInt, new PInt());
            int i = pInt.value;
            AppMethodBeat.o(21348);
            return i;
        }
    };

    public GalleryStubService() {
        AppMethodBeat.i(21349);
        AppMethodBeat.o(21349);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(21350);
        ab.d("MicroMsg.GalleryStubService", "on bind, intent[%s]", intent);
        a aVar = this.mOD;
        AppMethodBeat.o(21350);
        return aVar;
    }
}
