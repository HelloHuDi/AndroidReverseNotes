package com.tencent.mm.plugin.wenote.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.ae;
import com.tencent.mm.g.a.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

public final class c implements at {
    private static HashMap<Integer, d> eaA = new HashMap();
    private com.tencent.mm.sdk.b.c gRa = new com.tencent.mm.sdk.b.c<ae>() {
        {
            AppMethodBeat.i(26598);
            this.xxI = ae.class.getName().hashCode();
            AppMethodBeat.o(26598);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(26599);
            af afVar = new af();
            afVar.csZ.ctb = new com.tencent.mm.plugin.wenote.ui.nativenote.b(ah.getContext());
            a.xxA.m(afVar);
            AppMethodBeat.o(26599);
            return false;
        }
    };
    private com.tencent.mm.plugin.wenote.a.b uMK = new com.tencent.mm.plugin.wenote.a.b();
    private com.tencent.mm.plugin.wenote.a.c uML = new com.tencent.mm.plugin.wenote.a.c();
    private com.tencent.mm.plugin.wenote.a.a uMM = new com.tencent.mm.plugin.wenote.a.a();
    public d uMN = null;

    public c() {
        AppMethodBeat.i(26600);
        AppMethodBeat.o(26600);
    }

    public static c ddG() {
        AppMethodBeat.i(26601);
        aw.ZE();
        c cVar = (c) bw.oJ("plugin.wenote");
        if (cVar == null) {
            cVar = new c();
            aw.ZE().a("plugin.wenote", cVar);
        }
        AppMethodBeat.o(26601);
        return cVar;
    }

    static {
        AppMethodBeat.i(26604);
        AppMethodBeat.o(26604);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        Closeable open;
        OutputStream outputStream = null;
        AppMethodBeat.i(26602);
        ab.d("MicroMsg.SubCoreWNNoteMsg", "on account post reset");
        a.xxA.c(this.uMK);
        ((com.tencent.mm.plugin.record.a.a) g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this.uML);
        ((com.tencent.mm.plugin.fav.a.ae) g.M(com.tencent.mm.plugin.fav.a.ae.class)).getFavCdnStorage().a(this.uML);
        a.xxA.c(this.uMM);
        a.xxA.c(this.gRa);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(i.Yi());
        if (!(bVar.exists() && bVar.isDirectory())) {
            ab.d("MicroMsg.SubCoreWNNoteMsg", "record stg dir[%s] not exsit, create it");
            bVar.mkdirs();
        }
        com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(an.bvi());
        ab.i("MicroMsg.SubCoreWNNoteMsg", "copy to path %s", j.w(bVar2.dMD()));
        if (com.tencent.mm.protocal.d.vxr) {
            ab.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile develop version delete template");
            e.N(j.w(bVar2.mUri), true);
        } else {
            an.mgz = an.afW();
            if (z) {
                ab.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need update assetVersion=%d currentVersion=%d", Integer.valueOf(an.afX()), Integer.valueOf(an.mgz));
                if (an.mgz < an.afX()) {
                    e.N(j.w(bVar2.mUri), true);
                }
            } else if (an.mgz == 1) {
                ab.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need init template");
                e.N(j.w(bVar2.mUri), true);
            } else {
                ab.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile currentVersion=%d", Integer.valueOf(an.mgz));
            }
        }
        if (!bVar2.exists()) {
            bVar2.mkdirs();
        }
        try {
            open = ah.getContext().getAssets().open("WNNote.zip");
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", e, "", new Object[0]);
            open = null;
        }
        if (open == null) {
            ab.e("MicroMsg.SubCoreWNNoteMsg", "file inputStream not found");
            AppMethodBeat.o(26602);
            return;
        }
        com.tencent.mm.vfs.b bVar3 = new com.tencent.mm.vfs.b(bVar2, "WNNote.zip");
        if (bVar3.exists()) {
            ab.i("MicroMsg.SubCoreWNNoteMsg", "wenote template already exists");
            bo.b(open);
            AppMethodBeat.o(26602);
            return;
        }
        try {
            outputStream = e.q(bVar3);
        } catch (FileNotFoundException e2) {
            ab.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", e2, "", new Object[0]);
        }
        if (outputStream != null) {
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    int read = open.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                }
            } catch (IOException e3) {
                ab.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", e3, "", new Object[0]);
            }
        }
        bo.b(open);
        bo.b(outputStream);
        int iu = e.iu(j.w(bVar3.dMD()), bVar3.getParent());
        if (iu < 0) {
            ab.e("MicroMsg.SubCoreWNNoteMsg", "unzip fail, ret = " + iu + ", zipFilePath = " + j.w(bVar3.dMD()) + ", unzipPath = " + bVar3.getParent());
        }
        AppMethodBeat.o(26602);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(26603);
        ab.d("MicroMsg.SubCoreWNNoteMsg", "on account post release");
        a.xxA.d(this.uMK);
        if (((com.tencent.mm.plugin.record.a.a) g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage() != null) {
            ((com.tencent.mm.plugin.record.a.a) g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this.uML);
        }
        if (((com.tencent.mm.plugin.fav.a.ae) g.M(com.tencent.mm.plugin.fav.a.ae.class)).getFavCdnStorage() != null) {
            ((com.tencent.mm.plugin.fav.a.ae) g.M(com.tencent.mm.plugin.fav.a.ae.class)).getFavCdnStorage().b(this.uML);
        }
        a.xxA.d(this.uMM);
        a.xxA.d(this.gRa);
        AppMethodBeat.o(26603);
    }
}
