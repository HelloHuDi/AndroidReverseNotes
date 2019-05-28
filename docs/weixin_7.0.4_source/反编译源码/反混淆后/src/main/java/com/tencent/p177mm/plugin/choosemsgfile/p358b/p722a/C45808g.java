package com.tencent.p177mm.plugin.choosemsgfile.p358b.p722a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.choosemsgfile.compat.C32464b;
import com.tencent.p177mm.choosemsgfile.compat.MsgFile;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.modelvideo.C9720t.C9721a;
import com.tencent.p177mm.modelvideo.C9720t.C9721a.C9718a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C27011o;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p1605d.C42887b;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C11376a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vending.p639e.C5685b;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.a.g */
public final class C45808g extends C6824c {
    private C7620bi kua;
    private C26493s kuh;

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.a.g$1 */
    class C428811 implements C9721a {
        C428811() {
        }

        /* renamed from: a */
        public final void mo11381a(C9718a c9718a) {
            AppMethodBeat.m2504i(54281);
            C26493s ut = C26494u.m42268ut(c9718a.fileName);
            if (ut != null) {
                C45808g.this.mo15099dL(ut.fWY, ut.frO);
                if (ut.alz()) {
                    C37961o.all();
                    String uh = C9720t.m17303uh(C45808g.this.kua.field_imgPath);
                    if (C5730e.m8628ct(uh)) {
                        C45808g.m84728a(C45808g.this, ut, uh);
                        AppMethodBeat.m2505o(54281);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.MsgFileWorker_Video", "video isn't exist, return");
                    C45808g.this.bfk();
                }
            }
            AppMethodBeat.m2505o(54281);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m84728a(C45808g c45808g, C26493s c26493s, String str) {
        AppMethodBeat.m2504i(54286);
        c45808g.m84727a(c26493s, str);
        AppMethodBeat.m2505o(54286);
    }

    public C45808g(C11376a c11376a, C11372a c11372a, C5685b c5685b) {
        super(c11376a, c11372a, c5685b);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean checkValid() {
        AppMethodBeat.m2504i(54282);
        if (this.ktT == null || this.ktT.kua == null) {
            C4990ab.m7412e("MicroMsg.MsgFileWorker_Video", "mMsgInfo is null, return");
            AppMethodBeat.m2505o(54282);
            return false;
        }
        this.kua = this.ktT.kua;
        if (this.kua.dtH()) {
            C4990ab.m7413e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s is clean, return", this.kua);
            AppMethodBeat.m2505o(54282);
            return false;
        } else if (((C32464b) C1720g.m3528K(C32464b.class)).mo39542f(this.kua)) {
            this.kuh = C26494u.m42268ut(this.kua.field_imgPath);
            if (this.kuh == null) {
                C4990ab.m7413e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s videoInfo is null, return", this.kua);
                AppMethodBeat.m2505o(54282);
                return false;
            } else if (this.kuh.status == C27011o.CTRL_INDEX) {
                C4990ab.m7413e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s videoInfo is invalid, return", this.kua);
                AppMethodBeat.m2505o(54282);
                return false;
            } else {
                AppMethodBeat.m2505o(54282);
                return true;
            }
        } else {
            C4990ab.m7413e("MicroMsg.MsgFileWorker_Video", "mMsgInfo:%s is not video, return", this.kua);
            AppMethodBeat.m2505o(54282);
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bfh() {
        AppMethodBeat.m2504i(54283);
        if (this.kuh.alz()) {
            C37961o.all();
            String uh = C9720t.m17303uh(this.kua.field_imgPath);
            if (C5730e.m8628ct(uh)) {
                m84727a(this.kuh, uh);
                AppMethodBeat.m2505o(54283);
                return true;
            }
        }
        AppMethodBeat.m2505o(54283);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bfi() {
        AppMethodBeat.m2504i(54284);
        C37961o.all().mo21053a(new C428811(), Looper.getMainLooper());
        if (this.kuh.aly()) {
            C4990ab.m7416i("MicroMsg.MsgFileWorker_Video", "start complete online video");
            C26494u.m42259uA(this.kua.field_imgPath);
            AppMethodBeat.m2505o(54284);
            return;
        }
        C4990ab.m7416i("MicroMsg.MsgFileWorker_Video", "start complete offline video");
        C26494u.m42244ag(this.kua.field_imgPath, 10);
        C26494u.m42264up(this.kua.field_imgPath);
        AppMethodBeat.m2505o(54284);
    }

    /* renamed from: a */
    private void m84727a(C26493s c26493s, String str) {
        AppMethodBeat.m2504i(54285);
        MsgFile msgFile = new MsgFile();
        msgFile.fileSize = c26493s.frO;
        msgFile.filePath = str;
        msgFile.eov = C42887b.m76162cv(msgFile.filePath);
        msgFile.type = "video";
        msgFile.fileName = c26493s.getFileName() + "." + msgFile.eov;
        msgFile.timeStamp = c26493s.createTime;
        mo15093b(msgFile);
        AppMethodBeat.m2505o(54285);
    }
}
