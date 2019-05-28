package com.tencent.p177mm.plugin.choosemsgfile.p358b.p722a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.choosemsgfile.compat.C32464b;
import com.tencent.p177mm.choosemsgfile.compat.C32464b.C32465a;
import com.tencent.p177mm.choosemsgfile.compat.C32464b.C32466b;
import com.tencent.p177mm.choosemsgfile.compat.MsgFile;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C11376a;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vending.p639e.C5684a;
import com.tencent.p177mm.vending.p639e.C5685b;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.a.e */
public final class C45807e extends C6824c {
    /* renamed from: IS */
    private String f17892IS;
    private long edW;
    private C7620bi kua;
    private C5684a kub;

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.a.e$1 */
    class C276361 implements C32466b {
        C276361() {
        }

        /* renamed from: n */
        public final void mo45482n(int i, String str) {
            AppMethodBeat.m2504i(54264);
            C4990ab.m7417i("MicroMsg.MsgFileWorker_File", "InitAttachInfoCallback errCode:%d, errMsg:%s", Integer.valueOf(i), str);
            if (i == 0) {
                final C30065b i2 = ((C32464b) C1720g.m3528K(C32464b.class)).mo39543i(C45807e.this.f17892IS, C45807e.this.edW);
                ((C32464b) C1720g.m3528K(C32464b.class)).mo39535a(i2);
                C45807e.this.kub = ((C32464b) C1720g.m3528K(C32464b.class)).mo39533a(C45807e.this.edW, C45807e.this.f17892IS, new C32465a() {
                    /* renamed from: m */
                    public final void mo35450m(int i, String str) {
                        AppMethodBeat.m2504i(54262);
                        C4990ab.m7417i("MicroMsg.MsgFileWorker_File", "DownloadCallback errCode:%d, errMsg:%s", Integer.valueOf(i), str);
                        if (i == 0) {
                            MsgFile msgFile = new MsgFile();
                            msgFile.fileSize = C45807e.this.ktT.bfp();
                            msgFile.filePath = i2.field_fileFullPath;
                            msgFile.fileName = C45807e.this.ktT.getFileName();
                            msgFile.type = "file";
                            msgFile.eov = C45807e.this.ktT.bfo();
                            msgFile.timeStamp = C45807e.this.ktT.getTimeStamp() / 1000;
                            C45807e.this.mo15093b(msgFile);
                            AppMethodBeat.m2505o(54262);
                        } else if (i == 1) {
                            C45807e.this.bfj();
                            AppMethodBeat.m2505o(54262);
                        } else {
                            C4990ab.m7413e("MicroMsg.MsgFileWorker_File", "download %s fail", C45807e.this.ktT);
                            C45807e.this.bfk();
                            AppMethodBeat.m2505o(54262);
                        }
                    }

                    /* renamed from: bQ */
                    public final void mo35449bQ(int i, int i2) {
                        AppMethodBeat.m2504i(54263);
                        C45807e.this.mo15099dL(i, i2);
                        AppMethodBeat.m2505o(54263);
                    }
                });
                AppMethodBeat.m2505o(54264);
                return;
            }
            C4990ab.m7413e("MicroMsg.MsgFileWorker_File", "init %s fail", C45807e.this.ktT);
            C45807e.this.bfk();
            AppMethodBeat.m2505o(54264);
        }
    }

    public C45807e(C11376a c11376a, C11372a c11372a, C5685b c5685b) {
        super(c11376a, c11372a, c5685b);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean checkValid() {
        AppMethodBeat.m2504i(54265);
        C4990ab.m7417i("MicroMsg.MsgFileWorker_File", "start %s", this);
        if (this.ktT == null || this.ktT.kua == null) {
            C4990ab.m7412e("MicroMsg.MsgFileWorker_File", "mMsgInfo is null, err");
            AppMethodBeat.m2505o(54265);
            return false;
        }
        this.kua = this.ktT.kua;
        this.edW = this.ktT.kua.field_msgId;
        C8910b me = C8910b.m16064me(this.kua.field_content);
        if (me == null) {
            C4990ab.m7413e("MicroMsg.MsgFileWorker_File", "parse msgContent error, %s", this.kua.field_content);
            AppMethodBeat.m2505o(54265);
            return false;
        }
        if (C5046bo.isNullOrNil(me.csD) && !C5046bo.isNullOrNil(me.fgD)) {
            C4990ab.m7413e("MicroMsg.MsgFileWorker_File", "msgContent format error, %s", this.kua.field_content);
            me.csD = me.fgD.hashCode();
        }
        this.f17892IS = me.csD;
        if (C5046bo.isNullOrNil(this.f17892IS)) {
            C4990ab.m7412e("MicroMsg.MsgFileWorker_File", "MediaId is null, err return");
            AppMethodBeat.m2505o(54265);
            return false;
        }
        AppMethodBeat.m2505o(54265);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bfh() {
        AppMethodBeat.m2504i(54266);
        C30065b i = ((C32464b) C1720g.m3528K(C32464b.class)).mo39543i(this.f17892IS, this.edW);
        if (((C32464b) C1720g.m3528K(C32464b.class)).mo39537a(this.kua, i)) {
            MsgFile msgFile = new MsgFile();
            msgFile.fileSize = this.ktT.bfp();
            msgFile.filePath = i.field_fileFullPath;
            msgFile.fileName = this.ktT.getFileName();
            msgFile.type = "file";
            msgFile.eov = this.ktT.bfo();
            msgFile.timeStamp = this.ktT.getTimeStamp() / 1000;
            mo15093b(msgFile);
            AppMethodBeat.m2505o(54266);
            return true;
        }
        AppMethodBeat.m2505o(54266);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bfi() {
        AppMethodBeat.m2504i(54267);
        C4990ab.m7417i("MicroMsg.MsgFileWorker_File", "initOk:%b", Boolean.valueOf(((C32464b) C1720g.m3528K(C32464b.class)).mo39538a(this.f17892IS, this.kua, new C276361())));
        if (!((C32464b) C1720g.m3528K(C32464b.class)).mo39538a(this.f17892IS, this.kua, new C276361())) {
            C4990ab.m7416i("MicroMsg.MsgFileWorker_File", "initOk fail");
            bfk();
        }
        AppMethodBeat.m2505o(54267);
    }

    public final void dead() {
        AppMethodBeat.m2504i(54268);
        C4990ab.m7416i("MicroMsg.MsgFileWorker_File", "dead");
        if (this.kub != null) {
            this.kub.dead();
        }
        AppMethodBeat.m2505o(54268);
    }
}
