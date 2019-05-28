package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.m.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Arrays;

public final class p implements w {
    private VideoTransPara fWR = null;
    private VideoTransPara fWS = null;
    private String fWT;
    private String fWU;
    Boolean fWV = Boolean.FALSE;

    public final void tZ(String str) {
        AppMethodBeat.i(50779);
        o.all();
        this.fWT = t.uh(str);
        StringBuilder stringBuilder = new StringBuilder();
        o.all();
        this.fWU = stringBuilder.append(t.uh(str)).append(".tmp").toString();
        ab.i("MicroMsg.TransferVideoMsgSendCallback", "srcPath： %s", this.fWT);
        ab.i("MicroMsg.TransferVideoMsgSendCallback", "dstPath：%s", this.fWU);
        this.fWV = Boolean.valueOf(e.uD(this.fWT));
        if (com.tencent.mm.vfs.e.ct(this.fWT) && this.fWV.booleanValue()) {
            ab.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265");
            long yz = bo.yz();
            if (com.tencent.mm.vfs.e.ct(this.fWT)) {
                h.pYm.a(354, 249, 1, false);
                this.fWS = e.uE(this.fWT);
                this.fWR = e.a(this.fWS, this.fWT);
                if (!(this.fWS == null || this.fWR == null)) {
                    if (e.a(this.fWT, this.fWU, this.fWR) < 0) {
                        h.pYm.a(354, 250, 1, false);
                    }
                    FileOp.aQ(this.fWU, this.fWT);
                    FileOp.deleteFile(this.fWU);
                    s ut = u.ut(str);
                    if (ut != null) {
                        ut.videoFormat = 1;
                        ut.bJt = 2;
                        o.all().c(ut);
                    }
                    ab.i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms", Long.valueOf(bo.az(yz)));
                }
                AppMethodBeat.o(50779);
                return;
            }
            ab.e("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265 file not exist!");
            AppMethodBeat.o(50779);
            return;
        }
        ab.i("MicroMsg.TransferVideoMsgSendCallback", "video format is h264，do not need to tranfer");
        s ut2 = u.ut(str);
        if (!(ut2 == null || bo.isNullOrNil(ut2.alv()) || !com.tencent.mm.vfs.e.ct(ut2.alv()))) {
            baa baa = ut2.fXn;
            if (baa == null || !baa.wDP) {
                String alv = ut2.alv();
                o.all();
                String uh = t.uh(str);
                this.fWS = e.uE(alv);
                this.fWR = e.a(this.fWS, alv);
                if (com.tencent.mm.vfs.e.ct(uh) || this.fWS == null || this.fWR == null) {
                    ab.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is a local capture video, do nothing");
                } else {
                    int[] iArr = new int[2];
                    j.c(alv, iArr);
                    long yz2 = bo.yz();
                    this.fWV = Boolean.valueOf(e.uD(alv));
                    ab.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, local remux file path not exist, do remux here, outsize: %s, localDstFilePath: %s, importPath: %s, isH265: %s", Arrays.toString(iArr), uh, alv, this.fWV);
                    if (this.fWV.booleanValue()) {
                        int a = e.a(alv, uh, this.fWR);
                        ab.i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms %s", Long.valueOf(bo.az(yz2)), Integer.valueOf(a));
                    } else {
                        ab.i("MicroMsg.TransferVideoMsgSendCallback", "remux finish: %s, used %sms", Integer.valueOf(SightVideoJNI.remuxing(alv, uh, iArr[0], iArr[1], this.fWR.videoBitrate, this.fWR.fzV, 8, this.fWR.fzU, 25.0f, (float) this.fWR.fps, null, 0, b.qwX)), Long.valueOf(bo.az(yz2)));
                        ((a) g.K(a.class)).XT().P(alv, uh, r5);
                    }
                    if (this.fWS.duration > 0) {
                        ut2.fXd = this.fWS.duration;
                        o.all().c(ut2);
                    }
                    AppMethodBeat.o(50779);
                    return;
                }
            }
        }
        AppMethodBeat.o(50779);
    }
}
