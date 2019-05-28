package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.d;
import com.tencent.mm.at.e;
import com.tencent.mm.at.o;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vending.e.b;

public final class f extends c {
    private bi kua;
    private e kuf;

    public f(a aVar, a aVar2, b bVar) {
        super(aVar, aVar2, bVar);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean checkValid() {
        AppMethodBeat.i(54274);
        if (this.ktT == null || this.ktT.kua == null) {
            ab.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo is null, return");
            bfk();
            AppMethodBeat.o(54274);
            return false;
        }
        this.kua = this.ktT.kua;
        if (this.kua.dtH()) {
            ab.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo:%s is clean, return", this.kua);
            AppMethodBeat.o(54274);
            return false;
        } else if (!((com.tencent.mm.choosemsgfile.compat.b) g.K(com.tencent.mm.choosemsgfile.compat.b.class)).c(this.kua)) {
            ab.e("MicroMsg.MsgFileWorker_Image", "mMsgInfo is not img msg, return");
            AppMethodBeat.o(54274);
            return false;
        } else if (this.kua.getType() == 268435505) {
            AppMethodBeat.o(54274);
            return true;
        } else {
            this.kuf = ((com.tencent.mm.choosemsgfile.compat.b) g.K(com.tencent.mm.choosemsgfile.compat.b.class)).d(this.kua);
            if (this.kuf == null) {
                ab.e("MicroMsg.MsgFileWorker_Image", "mImgInfo is null, return");
                AppMethodBeat.o(54274);
                return false;
            }
            AppMethodBeat.o(54274);
            return true;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bfh() {
        AppMethodBeat.i(54275);
        if (this.kua.getType() == 268435505) {
            if (com.tencent.mm.vfs.e.ct(((com.tencent.mm.choosemsgfile.compat.b) g.K(com.tencent.mm.choosemsgfile.compat.b.class)).e(this.kua))) {
                if (this.ktT instanceof com.tencent.mm.plugin.choosemsgfile.b.b.b) {
                    a((com.tencent.mm.plugin.choosemsgfile.b.b.b) this.ktT);
                } else {
                    ab.e("MicroMsg.MsgFileWorker_Image", "mMsgItem isn't AppMsgImageMsgItem, err");
                    bfk();
                }
                AppMethodBeat.o(54275);
                return true;
            }
        } else if (this.kuf.agP()) {
            String a = ((com.tencent.mm.choosemsgfile.compat.b) g.K(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.kua, this.kuf);
            if (!bo.isNullOrNil(a)) {
                HI(a);
                AppMethodBeat.o(54275);
                return true;
            }
        }
        AppMethodBeat.o(54275);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bfi() {
        AppMethodBeat.i(54276);
        if (this.kua.getType() == 268435505) {
            ((com.tencent.mm.choosemsgfile.compat.b) g.K(com.tencent.mm.choosemsgfile.compat.b.class)).a(this.kua, new com.tencent.mm.choosemsgfile.compat.b.a() {
                public final void m(int i, String str) {
                    AppMethodBeat.i(54269);
                    ab.i("MicroMsg.MsgFileWorker_Image", "DownloadCallback errCode:%d, errMsg:%s", Integer.valueOf(i), str);
                    if (i != 0) {
                        ab.e("MicroMsg.MsgFileWorker_Image", "download fail");
                        f.this.bfk();
                        AppMethodBeat.o(54269);
                    } else if (f.this.ktT instanceof com.tencent.mm.plugin.choosemsgfile.b.b.b) {
                        ab.e("MicroMsg.MsgFileWorker_Image", "mMsgItem isn't AppMsgImageMsgItem, err");
                        f.a(f.this, (com.tencent.mm.plugin.choosemsgfile.b.b.b) f.this.ktT);
                        AppMethodBeat.o(54269);
                    } else {
                        f.this.bfk();
                        AppMethodBeat.o(54269);
                    }
                }

                public final void bQ(int i, int i2) {
                    AppMethodBeat.i(54270);
                    f.this.dL(i, i2);
                    AppMethodBeat.o(54270);
                }
            });
            AppMethodBeat.o(54276);
            return;
        }
        boolean a = o.ahm().a(this.kuf.fDy, this.kua.field_msgId, 0, Long.valueOf(this.kua.field_msgId), R.drawable.b0p, new d.a() {
            public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, m mVar) {
                AppMethodBeat.i(54271);
                ab.d("MicroMsg.MsgFileWorker_Image", "[onImgTaskProgress] offset:%s totalLen:%s", Integer.valueOf(i3), Integer.valueOf(i4));
                f.this.dL(i3, i4);
                AppMethodBeat.o(54271);
            }

            public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, m mVar) {
                AppMethodBeat.i(54272);
                ab.i("MicroMsg.MsgFileWorker_Image", "[onImgTaskEnd] imgLocalId:%s msgLocalId:%s err[%s:%s:%s]", Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4), str);
                String a = ((com.tencent.mm.choosemsgfile.compat.b) g.K(com.tencent.mm.choosemsgfile.compat.b.class)).a(f.this.kua, ((com.tencent.mm.choosemsgfile.compat.b) g.K(com.tencent.mm.choosemsgfile.compat.b.class)).d(f.this.kua));
                ab.i("MicroMsg.MsgFileWorker_Image", "imgPath:%s", a);
                if (bo.isNullOrNil(a)) {
                    f.this.bfk();
                    AppMethodBeat.o(54272);
                    return;
                }
                f.a(f.this, a);
                AppMethodBeat.o(54272);
            }

            public final void a(long j, long j2, int i, int i2, Object obj) {
                AppMethodBeat.i(54273);
                f.this.bfk();
                AppMethodBeat.o(54273);
            }
        });
        ab.i("MicroMsg.MsgFileWorker_Image", "isOk:%b", Boolean.valueOf(a));
        AppMethodBeat.o(54276);
    }

    private void a(com.tencent.mm.plugin.choosemsgfile.b.b.b bVar) {
        AppMethodBeat.i(54277);
        MsgFile msgFile = new MsgFile();
        msgFile.fileSize = bVar.bfp();
        msgFile.filePath = ((com.tencent.mm.choosemsgfile.compat.b) g.K(com.tencent.mm.choosemsgfile.compat.b.class)).e(this.kua);
        msgFile.fileName = bVar.getFileName() + "." + msgFile.eov;
        msgFile.type = "image";
        msgFile.eov = bVar.bfo();
        msgFile.timeStamp = bVar.getTimeStamp();
        b(msgFile);
        AppMethodBeat.o(54277);
    }

    private void HI(String str) {
        AppMethodBeat.i(54278);
        MsgFile msgFile = new MsgFile();
        msgFile.fileSize = (int) com.tencent.mm.vfs.e.asZ(str);
        msgFile.filePath = str;
        msgFile.fileName = this.kuf.fDz;
        msgFile.type = "image";
        msgFile.eov = com.tencent.mm.plugin.choosemsgfile.b.d.b.cv(msgFile.fileName);
        msgFile.timeStamp = (long) this.kuf.fDG;
        b(msgFile);
        AppMethodBeat.o(54278);
    }
}
