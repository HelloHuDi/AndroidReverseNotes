package com.tencent.p177mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.modelsfs.FileOp;
import com.tencent.p177mm.p838bj.C17987e;
import com.tencent.p177mm.plugin.p991m.p1488a.C34506a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.base.C29014b;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.pluginsdk.model.C30076j;
import com.tencent.p177mm.protocal.protobuf.baa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.Arrays;

/* renamed from: com.tencent.mm.modelvideo.p */
public final class C46887p implements C45460w {
    private VideoTransPara fWR = null;
    private VideoTransPara fWS = null;
    private String fWT;
    private String fWU;
    Boolean fWV = Boolean.FALSE;

    /* renamed from: tZ */
    public final void mo7943tZ(String str) {
        AppMethodBeat.m2504i(50779);
        C37961o.all();
        this.fWT = C9720t.m17303uh(str);
        StringBuilder stringBuilder = new StringBuilder();
        C37961o.all();
        this.fWU = stringBuilder.append(C9720t.m17303uh(str)).append(".tmp").toString();
        C4990ab.m7417i("MicroMsg.TransferVideoMsgSendCallback", "srcPath： %s", this.fWT);
        C4990ab.m7417i("MicroMsg.TransferVideoMsgSendCallback", "dstPath：%s", this.fWU);
        this.fWV = Boolean.valueOf(C17987e.m28307uD(this.fWT));
        if (C5730e.m8628ct(this.fWT) && this.fWV.booleanValue()) {
            C4990ab.m7416i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265");
            long yz = C5046bo.m7588yz();
            if (C5730e.m8628ct(this.fWT)) {
                C7060h.pYm.mo8378a(354, 249, 1, false);
                this.fWS = C17987e.m28308uE(this.fWT);
                this.fWR = C17987e.m28301a(this.fWS, this.fWT);
                if (!(this.fWS == null || this.fWR == null)) {
                    if (C17987e.m28300a(this.fWT, this.fWU, this.fWR) < 0) {
                        C7060h.pYm.mo8378a(354, 250, 1, false);
                    }
                    FileOp.m64136aQ(this.fWU, this.fWT);
                    FileOp.deleteFile(this.fWU);
                    C26493s ut = C26494u.m42268ut(str);
                    if (ut != null) {
                        ut.videoFormat = 1;
                        ut.bJt = 2;
                        C37961o.all().mo21060c(ut);
                    }
                    C4990ab.m7417i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms", Long.valueOf(C5046bo.m7525az(yz)));
                }
                AppMethodBeat.m2505o(50779);
                return;
            }
            C4990ab.m7412e("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265 file not exist!");
            AppMethodBeat.m2505o(50779);
            return;
        }
        C4990ab.m7416i("MicroMsg.TransferVideoMsgSendCallback", "video format is h264，do not need to tranfer");
        C26493s ut2 = C26494u.m42268ut(str);
        if (!(ut2 == null || C5046bo.isNullOrNil(ut2.alv()) || !C5730e.m8628ct(ut2.alv()))) {
            baa baa = ut2.fXn;
            if (baa == null || !baa.wDP) {
                String alv = ut2.alv();
                C37961o.all();
                String uh = C9720t.m17303uh(str);
                this.fWS = C17987e.m28308uE(alv);
                this.fWR = C17987e.m28301a(this.fWS, alv);
                if (C5730e.m8628ct(uh) || this.fWS == null || this.fWR == null) {
                    C4990ab.m7416i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is a local capture video, do nothing");
                } else {
                    int[] iArr = new int[2];
                    C30076j.m47631c(alv, iArr);
                    long yz2 = C5046bo.m7588yz();
                    this.fWV = Boolean.valueOf(C17987e.m28307uD(alv));
                    C4990ab.m7417i("MicroMsg.TransferVideoMsgSendCallback", "before video send, local remux file path not exist, do remux here, outsize: %s, localDstFilePath: %s, importPath: %s, isH265: %s", Arrays.toString(iArr), uh, alv, this.fWV);
                    if (this.fWV.booleanValue()) {
                        int a = C17987e.m28300a(alv, uh, this.fWR);
                        C4990ab.m7417i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms %s", Long.valueOf(C5046bo.m7525az(yz2)), Integer.valueOf(a));
                    } else {
                        C4990ab.m7417i("MicroMsg.TransferVideoMsgSendCallback", "remux finish: %s, used %sms", Integer.valueOf(SightVideoJNI.remuxing(alv, uh, iArr[0], iArr[1], this.fWR.videoBitrate, this.fWR.fzV, 8, this.fWR.fzU, 25.0f, (float) this.fWR.fps, null, 0, C29014b.qwX)), Long.valueOf(C5046bo.m7525az(yz2)));
                        ((C34506a) C1720g.m3528K(C34506a.class)).mo24388XT().mo16776P(alv, uh, r5);
                    }
                    if (this.fWS.duration > 0) {
                        ut2.fXd = this.fWS.duration;
                        C37961o.all().mo21060c(ut2);
                    }
                    AppMethodBeat.m2505o(50779);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(50779);
    }
}
