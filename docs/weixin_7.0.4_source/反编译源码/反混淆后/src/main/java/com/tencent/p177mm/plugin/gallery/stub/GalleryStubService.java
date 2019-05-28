package com.tencent.p177mm.plugin.gallery.stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.p230g.p231a.C37739iu;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.plugin.gallery.stub.C34241a.C34242a;
import com.tencent.p177mm.plugin.report.service.C34830g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.gallery.stub.GalleryStubService */
public class GalleryStubService extends Service {
    private C34242a mOD = new C209131();

    /* renamed from: com.tencent.mm.plugin.gallery.stub.GalleryStubService$1 */
    class C209131 extends C34242a {
        C209131() {
        }

        /* renamed from: aK */
        public final void mo36247aK(int i, String str) {
            AppMethodBeat.m2504i(21341);
            C7060h.pYm.mo8374X(i, str);
            AppMethodBeat.m2505o(21341);
        }

        /* renamed from: a */
        public final void mo36246a(String str, String str2, boolean z, int i, boolean z2) {
            AppMethodBeat.m2504i(21342);
            if (C4879a.xxA != null) {
                C37739iu c37739iu = new C37739iu();
                c37739iu.cDU.cDV = Boolean.valueOf(z);
                c37739iu.cDU.imagePath = str;
                c37739iu.cDU.cDW = i;
                c37739iu.cDU.toUser = str2;
                c37739iu.cDU.cDX = Boolean.valueOf(z2);
                C4879a.xxA.mo10055m(c37739iu);
            }
            AppMethodBeat.m2505o(21342);
        }

        public final void bCv() {
            AppMethodBeat.m2504i(21343);
            C34830g.m57195BO(19);
            AppMethodBeat.m2505o(21343);
        }

        /* renamed from: Nd */
        public final int mo36245Nd() {
            AppMethodBeat.m2504i(21344);
            int Nd = C42164b.m74342Nd();
            AppMethodBeat.m2505o(21344);
            return Nd;
        }

        /* renamed from: Nb */
        public final int mo36244Nb() {
            AppMethodBeat.m2504i(21345);
            int Nb = C42164b.m74340Nb();
            AppMethodBeat.m2505o(21345);
            return Nb;
        }

        /* renamed from: Na */
        public final int mo36243Na() {
            AppMethodBeat.m2504i(21346);
            int Na = C42164b.m74339Na();
            AppMethodBeat.m2505o(21346);
            return Na;
        }

        /* renamed from: hC */
        public final boolean mo36249hC(boolean z) {
            AppMethodBeat.m2504i(21347);
            C9638aw.m17190ZK();
            boolean z2 = C18628c.m29072Ry().getBoolean(C5127a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, z);
            AppMethodBeat.m2505o(21347);
            return z2;
        }

        /* renamed from: ND */
        public final int mo36242ND(String str) {
            AppMethodBeat.m2504i(21348);
            PInt pInt = new PInt();
            C26494u.m42241a(str, pInt, new PInt());
            int i = pInt.value;
            AppMethodBeat.m2505o(21348);
            return i;
        }
    }

    public GalleryStubService() {
        AppMethodBeat.m2504i(21349);
        AppMethodBeat.m2505o(21349);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.m2504i(21350);
        C4990ab.m7411d("MicroMsg.GalleryStubService", "on bind, intent[%s]", intent);
        C34242a c34242a = this.mOD;
        AppMethodBeat.m2505o(21350);
        return c34242a;
    }
}
