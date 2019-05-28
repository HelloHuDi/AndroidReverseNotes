package com.tencent.mm.plugin.choosemsgfile.b.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.appbrand.jsapi.k.o;
import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vending.e.b;
import com.tencent.mm.vfs.e;

public final class g extends c {
    private bi kua;
    private s kuh;

    static /* synthetic */ void a(g gVar, s sVar, String str) {
        AppMethodBeat.i(54286);
        gVar.a(sVar, str);
        AppMethodBeat.o(54286);
    }

    public g(a aVar, a aVar2, b bVar) {
        super(aVar, aVar2, bVar);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean checkValid() {
        AppMethodBeat.i(54282);
        if (this.ktT == null || this.ktT.kua == null) {
            ab.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo is null, return");
            AppMethodBeat.o(54282);
            return false;
        }
        this.kua = this.ktT.kua;
        if (this.kua.dtH()) {
            ab.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s is clean, return", this.kua);
            AppMethodBeat.o(54282);
            return false;
        } else if (((com.tencent.mm.choosemsgfile.compat.b) com.tencent.mm.kernel.g.K(com.tencent.mm.choosemsgfile.compat.b.class)).f(this.kua)) {
            this.kuh = u.ut(this.kua.field_imgPath);
            if (this.kuh == null) {
                ab.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s videoInfo is null, return", this.kua);
                AppMethodBeat.o(54282);
                return false;
            } else if (this.kuh.status == o.CTRL_INDEX) {
                ab.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s videoInfo is invalid, return", this.kua);
                AppMethodBeat.o(54282);
                return false;
            } else {
                AppMethodBeat.o(54282);
                return true;
            }
        } else {
            ab.e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s is not video, return", this.kua);
            AppMethodBeat.o(54282);
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bfh() {
        AppMethodBeat.i(54283);
        if (this.kuh.alz()) {
            com.tencent.mm.modelvideo.o.all();
            String uh = t.uh(this.kua.field_imgPath);
            if (e.ct(uh)) {
                a(this.kuh, uh);
                AppMethodBeat.o(54283);
                return true;
            }
        }
        AppMethodBeat.o(54283);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bfi() {
        AppMethodBeat.i(54284);
        com.tencent.mm.modelvideo.o.all().a(new t.a() {
            public final void a(t.a.a aVar) {
                AppMethodBeat.i(54281);
                s ut = u.ut(aVar.fileName);
                if (ut != null) {
                    g.this.dL(ut.fWY, ut.frO);
                    if (ut.alz()) {
                        com.tencent.mm.modelvideo.o.all();
                        String uh = t.uh(g.this.kua.field_imgPath);
                        if (e.ct(uh)) {
                            g.a(g.this, ut, uh);
                            AppMethodBeat.o(54281);
                            return;
                        }
                        ab.e("MicroMsg.MsgFileWorker_Video", "video isn't exist, return");
                        g.this.bfk();
                    }
                }
                AppMethodBeat.o(54281);
            }
        }, Looper.getMainLooper());
        if (this.kuh.aly()) {
            ab.i("MicroMsg.MsgFileWorker_Video", "start complete online video");
            u.uA(this.kua.field_imgPath);
            AppMethodBeat.o(54284);
            return;
        }
        ab.i("MicroMsg.MsgFileWorker_Video", "start complete offline video");
        u.ag(this.kua.field_imgPath, 10);
        u.up(this.kua.field_imgPath);
        AppMethodBeat.o(54284);
    }

    private void a(s sVar, String str) {
        AppMethodBeat.i(54285);
        MsgFile msgFile = new MsgFile();
        msgFile.fileSize = sVar.frO;
        msgFile.filePath = str;
        msgFile.eov = com.tencent.mm.plugin.choosemsgfile.b.d.b.cv(msgFile.filePath);
        msgFile.type = "video";
        msgFile.fileName = sVar.getFileName() + "." + msgFile.eov;
        msgFile.timeStamp = sVar.createTime;
        b(msgFile);
        AppMethodBeat.o(54285);
    }
}
