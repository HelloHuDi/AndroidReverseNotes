package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;

public final class e extends c {
    private String IS;
    private long edW;
    private bi kua;
    private a kub;

    public e(com.tencent.mm.plugin.choosemsgfile.b.b.a aVar, a aVar2, b bVar) {
        super(aVar, aVar2, bVar);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean checkValid() {
        AppMethodBeat.i(54265);
        ab.i("MicroMsg.MsgFileWorker_File", "start %s", this);
        if (this.ktT == null || this.ktT.kua == null) {
            ab.e("MicroMsg.MsgFileWorker_File", "mMsgInfo is null, err");
            AppMethodBeat.o(54265);
            return false;
        }
        this.kua = this.ktT.kua;
        this.edW = this.ktT.kua.field_msgId;
        j.b me = j.b.me(this.kua.field_content);
        if (me == null) {
            ab.e("MicroMsg.MsgFileWorker_File", "parse msgContent error, %s", this.kua.field_content);
            AppMethodBeat.o(54265);
            return false;
        }
        if (bo.isNullOrNil(me.csD) && !bo.isNullOrNil(me.fgD)) {
            ab.e("MicroMsg.MsgFileWorker_File", "msgContent format error, %s", this.kua.field_content);
            me.csD = me.fgD.hashCode();
        }
        this.IS = me.csD;
        if (bo.isNullOrNil(this.IS)) {
            ab.e("MicroMsg.MsgFileWorker_File", "MediaId is null, err return");
            AppMethodBeat.o(54265);
            return false;
        }
        AppMethodBeat.o(54265);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bfh() {
        AppMethodBeat.i(54266);
        com.tencent.mm.pluginsdk.model.app.b i = ((com.tencent.mm.choosemsgfile.compat.b) g.K(com.tencent.mm.choosemsgfile.compat.b.class)).i(this.IS, this.edW);
        if (((com.tencent.mm.choosemsgfile.compat.b) g.K(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.kua, i)) {
            MsgFile msgFile = new MsgFile();
            msgFile.fileSize = this.ktT.bfp();
            msgFile.filePath = i.field_fileFullPath;
            msgFile.fileName = this.ktT.getFileName();
            msgFile.type = "file";
            msgFile.eov = this.ktT.bfo();
            msgFile.timeStamp = this.ktT.getTimeStamp() / 1000;
            b(msgFile);
            AppMethodBeat.o(54266);
            return true;
        }
        AppMethodBeat.o(54266);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bfi() {
        AppMethodBeat.i(54267);
        ab.i("MicroMsg.MsgFileWorker_File", "initOk:%b", Boolean.valueOf(((com.tencent.mm.choosemsgfile.compat.b) g.K(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.IS, this.kua, new com.tencent.mm.choosemsgfile.compat.b.b() {
            public final void n(int i, String str) {
                AppMethodBeat.i(54264);
                ab.i("MicroMsg.MsgFileWorker_File", "InitAttachInfoCallback errCode:%d, errMsg:%s", Integer.valueOf(i), str);
                if (i == 0) {
                    final com.tencent.mm.pluginsdk.model.app.b i2 = ((com.tencent.mm.choosemsgfile.compat.b) g.K(com.tencent.mm.choosemsgfile.compat.b.class)).i(e.this.IS, e.this.edW);
                    ((com.tencent.mm.choosemsgfile.compat.b) g.K(com.tencent.mm.choosemsgfile.compat.b.class)).a(i2);
                    e.this.kub = ((com.tencent.mm.choosemsgfile.compat.b) g.K(com.tencent.mm.choosemsgfile.compat.b.class)).a(e.this.edW, e.this.IS, new com.tencent.mm.choosemsgfile.compat.b.a() {
                        public final void m(int i, String str) {
                            AppMethodBeat.i(54262);
                            ab.i("MicroMsg.MsgFileWorker_File", "DownloadCallback errCode:%d, errMsg:%s", Integer.valueOf(i), str);
                            if (i == 0) {
                                MsgFile msgFile = new MsgFile();
                                msgFile.fileSize = e.this.ktT.bfp();
                                msgFile.filePath = i2.field_fileFullPath;
                                msgFile.fileName = e.this.ktT.getFileName();
                                msgFile.type = "file";
                                msgFile.eov = e.this.ktT.bfo();
                                msgFile.timeStamp = e.this.ktT.getTimeStamp() / 1000;
                                e.this.b(msgFile);
                                AppMethodBeat.o(54262);
                            } else if (i == 1) {
                                e.this.bfj();
                                AppMethodBeat.o(54262);
                            } else {
                                ab.e("MicroMsg.MsgFileWorker_File", "download %s fail", e.this.ktT);
                                e.this.bfk();
                                AppMethodBeat.o(54262);
                            }
                        }

                        public final void bQ(int i, int i2) {
                            AppMethodBeat.i(54263);
                            e.this.dL(i, i2);
                            AppMethodBeat.o(54263);
                        }
                    });
                    AppMethodBeat.o(54264);
                    return;
                }
                ab.e("MicroMsg.MsgFileWorker_File", "init %s fail", e.this.ktT);
                e.this.bfk();
                AppMethodBeat.o(54264);
            }
        })));
        if (!((com.tencent.mm.choosemsgfile.compat.b) g.K(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.IS, this.kua, /* anonymous class already generated */)) {
            ab.i("MicroMsg.MsgFileWorker_File", "initOk fail");
            bfk();
        }
        AppMethodBeat.o(54267);
    }

    public final void dead() {
        AppMethodBeat.i(54268);
        ab.i("MicroMsg.MsgFileWorker_File", "dead");
        if (this.kub != null) {
            this.kub.dead();
        }
        AppMethodBeat.o(54268);
    }
}
