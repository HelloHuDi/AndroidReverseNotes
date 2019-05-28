package com.tencent.p177mm.plugin.choosemsgfile.p358b.p722a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.choosemsgfile.compat.C32464b;
import com.tencent.p177mm.choosemsgfile.compat.C32464b.C32465a;
import com.tencent.p177mm.choosemsgfile.compat.MsgFile;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C17940d.C9017a;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p1605d.C42887b;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C11376a;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C11377b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vending.p639e.C5685b;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.a.f */
public final class C42880f extends C6824c {
    private C7620bi kua;
    private C25822e kuf;

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.a.f$1 */
    class C202081 implements C32465a {
        C202081() {
        }

        /* renamed from: m */
        public final void mo35450m(int i, String str) {
            AppMethodBeat.m2504i(54269);
            C4990ab.m7417i("MicroMsg.MsgFileWorker_Image", "DownloadCallback errCode:%d, errMsg:%s", Integer.valueOf(i), str);
            if (i != 0) {
                C4990ab.m7412e("MicroMsg.MsgFileWorker_Image", "download fail");
                C42880f.this.bfk();
                AppMethodBeat.m2505o(54269);
            } else if (C42880f.this.ktT instanceof C11377b) {
                C4990ab.m7412e("MicroMsg.MsgFileWorker_Image", "mMsgItem isn't AppMsgImageMsgItem, err");
                C42880f.m76135a(C42880f.this, (C11377b) C42880f.this.ktT);
                AppMethodBeat.m2505o(54269);
            } else {
                C42880f.this.bfk();
                AppMethodBeat.m2505o(54269);
            }
        }

        /* renamed from: bQ */
        public final void mo35449bQ(int i, int i2) {
            AppMethodBeat.m2504i(54270);
            C42880f.this.mo15099dL(i, i2);
            AppMethodBeat.m2505o(54270);
        }
    }

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.a.f$2 */
    class C428792 implements C9017a {
        C428792() {
        }

        /* renamed from: a */
        public final void mo20450a(long j, long j2, int i, int i2, Object obj, int i3, int i4, C1207m c1207m) {
            AppMethodBeat.m2504i(54271);
            C4990ab.m7411d("MicroMsg.MsgFileWorker_Image", "[onImgTaskProgress] offset:%s totalLen:%s", Integer.valueOf(i3), Integer.valueOf(i4));
            C42880f.this.mo15099dL(i3, i4);
            AppMethodBeat.m2505o(54271);
        }

        /* renamed from: a */
        public final void mo20451a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(54272);
            C4990ab.m7417i("MicroMsg.MsgFileWorker_Image", "[onImgTaskEnd] imgLocalId:%s msgLocalId:%s err[%s:%s:%s]", Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4), str);
            String a = ((C32464b) C1720g.m3528K(C32464b.class)).mo39534a(C42880f.this.kua, ((C32464b) C1720g.m3528K(C32464b.class)).mo39540d(C42880f.this.kua));
            C4990ab.m7417i("MicroMsg.MsgFileWorker_Image", "imgPath:%s", a);
            if (C5046bo.isNullOrNil(a)) {
                C42880f.this.bfk();
                AppMethodBeat.m2505o(54272);
                return;
            }
            C42880f.m76136a(C42880f.this, a);
            AppMethodBeat.m2505o(54272);
        }

        /* renamed from: a */
        public final void mo20449a(long j, long j2, int i, int i2, Object obj) {
            AppMethodBeat.m2504i(54273);
            C42880f.this.bfk();
            AppMethodBeat.m2505o(54273);
        }
    }

    public C42880f(C11376a c11376a, C11372a c11372a, C5685b c5685b) {
        super(c11376a, c11372a, c5685b);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean checkValid() {
        AppMethodBeat.m2504i(54274);
        if (this.ktT == null || this.ktT.kua == null) {
            C4990ab.m7412e("MicroMsg.MsgFileWorker_Image", "mMsgInfo is null, return");
            bfk();
            AppMethodBeat.m2505o(54274);
            return false;
        }
        this.kua = this.ktT.kua;
        if (this.kua.dtH()) {
            C4990ab.m7413e("MicroMsg.MsgFileWorker_Image", "mMsgInfo:%s is clean, return", this.kua);
            AppMethodBeat.m2505o(54274);
            return false;
        } else if (!((C32464b) C1720g.m3528K(C32464b.class)).mo39539c(this.kua)) {
            C4990ab.m7412e("MicroMsg.MsgFileWorker_Image", "mMsgInfo is not img msg, return");
            AppMethodBeat.m2505o(54274);
            return false;
        } else if (this.kua.getType() == 268435505) {
            AppMethodBeat.m2505o(54274);
            return true;
        } else {
            this.kuf = ((C32464b) C1720g.m3528K(C32464b.class)).mo39540d(this.kua);
            if (this.kuf == null) {
                C4990ab.m7412e("MicroMsg.MsgFileWorker_Image", "mImgInfo is null, return");
                AppMethodBeat.m2505o(54274);
                return false;
            }
            AppMethodBeat.m2505o(54274);
            return true;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bfh() {
        AppMethodBeat.m2504i(54275);
        if (this.kua.getType() == 268435505) {
            if (C5730e.m8628ct(((C32464b) C1720g.m3528K(C32464b.class)).mo39541e(this.kua))) {
                if (this.ktT instanceof C11377b) {
                    m76137a((C11377b) this.ktT);
                } else {
                    C4990ab.m7412e("MicroMsg.MsgFileWorker_Image", "mMsgItem isn't AppMsgImageMsgItem, err");
                    bfk();
                }
                AppMethodBeat.m2505o(54275);
                return true;
            }
        } else if (this.kuf.agP()) {
            String a = ((C32464b) C1720g.m3528K(C32464b.class)).mo39534a(this.kua, this.kuf);
            if (!C5046bo.isNullOrNil(a)) {
                m76133HI(a);
                AppMethodBeat.m2505o(54275);
                return true;
            }
        }
        AppMethodBeat.m2505o(54275);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bfi() {
        AppMethodBeat.m2504i(54276);
        if (this.kua.getType() == 268435505) {
            ((C32464b) C1720g.m3528K(C32464b.class)).mo39536a(this.kua, new C202081());
            AppMethodBeat.m2505o(54276);
            return;
        }
        boolean a = C32291o.ahm().mo33467a(this.kuf.fDy, this.kua.field_msgId, 0, Long.valueOf(this.kua.field_msgId), C25738R.drawable.b0p, new C428792());
        C4990ab.m7417i("MicroMsg.MsgFileWorker_Image", "isOk:%b", Boolean.valueOf(a));
        AppMethodBeat.m2505o(54276);
    }

    /* renamed from: a */
    private void m76137a(C11377b c11377b) {
        AppMethodBeat.m2504i(54277);
        MsgFile msgFile = new MsgFile();
        msgFile.fileSize = c11377b.bfp();
        msgFile.filePath = ((C32464b) C1720g.m3528K(C32464b.class)).mo39541e(this.kua);
        msgFile.fileName = c11377b.getFileName() + "." + msgFile.eov;
        msgFile.type = "image";
        msgFile.eov = c11377b.bfo();
        msgFile.timeStamp = c11377b.getTimeStamp();
        mo15093b(msgFile);
        AppMethodBeat.m2505o(54277);
    }

    /* renamed from: HI */
    private void m76133HI(String str) {
        AppMethodBeat.m2504i(54278);
        MsgFile msgFile = new MsgFile();
        msgFile.fileSize = (int) C5730e.asZ(str);
        msgFile.filePath = str;
        msgFile.fileName = this.kuf.fDz;
        msgFile.type = "image";
        msgFile.eov = C42887b.m76162cv(msgFile.fileName);
        msgFile.timeStamp = (long) this.kuf.fDG;
        mo15093b(msgFile);
        AppMethodBeat.m2505o(54278);
    }
}
