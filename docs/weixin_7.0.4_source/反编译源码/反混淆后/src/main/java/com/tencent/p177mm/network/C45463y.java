package com.tencent.p177mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C37432o;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.network.y */
public final class C45463y {
    private static final byte[] gdN = C37432o.m63091fZ(7);
    public C1922m gdO;

    static {
        AppMethodBeat.m2504i(58643);
        AppMethodBeat.m2505o(58643);
    }

    public final void onPush(int i, byte[] bArr) {
        AppMethodBeat.m2504i(58642);
        C4990ab.m7416i("MicroMsg.MMNativeNetNotifyAdapter", "onNotify, datalen=" + (bArr == null ? 0 : bArr.length) + " cmd= " + i);
        switch (i) {
            case 5:
                C4990ab.m7416i("MicroMsg.MMNativeNetNotifyAdapter", "old notify");
                this.gdO.mo5610e(138, gdN);
                AppMethodBeat.m2505o(58642);
                return;
            case 8:
                if (bArr.length > 0) {
                    this.gdO.mo5610e(10, bArr);
                    AppMethodBeat.m2505o(58642);
                    return;
                }
                break;
            case 11:
                AppMethodBeat.m2505o(58642);
                return;
            case 12:
                AppMethodBeat.m2505o(58642);
                return;
            case 24:
                C4990ab.m7417i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush new notify [%s]", C5046bo.m7539ca(bArr));
                this.gdO.mo5610e(138, bArr);
                AppMethodBeat.m2505o(58642);
                return;
            case 39:
                C4990ab.m7416i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do synccheck");
                this.gdO.mo5610e(39, null);
                AppMethodBeat.m2505o(58642);
                return;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                this.gdO.mo5610e(ErrorCode.NEEDDOWNLOAD_FALSE_4, bArr);
                AppMethodBeat.m2505o(58642);
                return;
            case 120:
                C4990ab.m7416i("MicroMsg.MMNativeNetNotifyAdapter", "MM_PKT_VOIP_REQ");
                if (bArr.length > 0) {
                    this.gdO.mo5610e(120, bArr);
                    AppMethodBeat.m2505o(58642);
                    return;
                }
                break;
            case 122:
                C4990ab.m7416i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush MM_PKT_PUSH_DATA_REQ");
                if (bArr.length > 0) {
                    this.gdO.mo5610e(268369921, bArr);
                    AppMethodBeat.m2505o(58642);
                    return;
                }
                break;
            case C33250az.CTRL_INDEX /*192*/:
                this.gdO.mo5610e(C33250az.CTRL_INDEX, bArr);
                AppMethodBeat.m2505o(58642);
                return;
            case C31128d.MIC_PTU_QINGCONG /*241*/:
                C4990ab.m7416i("MicroMsg.MMNativeNetNotifyAdapter", "jacks do voice notify PUSH");
                this.gdO.mo5610e(C31128d.MIC_PTU_QINGCONG, bArr);
                AppMethodBeat.m2505o(58642);
                return;
            case 244:
                C4990ab.m7416i("MicroMsg.MMNativeNetNotifyAdapter", "pandy do gamesync notify");
                this.gdO.mo5610e(244, bArr);
                AppMethodBeat.m2505o(58642);
                return;
            case C31128d.MIC_PTU_HONGKONG /*311*/:
                C4990ab.m7416i("MicroMsg.MMNativeNetNotifyAdapter", "on notify F2F data");
                this.gdO.mo5610e(C31128d.MIC_PTU_HONGKONG, bArr);
                AppMethodBeat.m2505o(58642);
                return;
            case 318:
                C4990ab.m7416i("MicroMsg.MMNativeNetNotifyAdapter", "summerbadcr on silence notify");
                this.gdO.mo5610e(318, bArr);
                break;
            case ErrorCode.ERROR_QBSDK_INIT_CANLOADX5 /*319*/:
                C4990ab.m7416i("MicroMsg.MMNativeNetNotifyAdapter", "hy: on notify new year shake");
                this.gdO.mo5610e(ErrorCode.ERROR_QBSDK_INIT_CANLOADX5, bArr);
                AppMethodBeat.m2505o(58642);
                return;
            case 268369923:
                C4990ab.m7416i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do oob do notify");
                this.gdO.mo5610e(268369923, bArr);
                AppMethodBeat.m2505o(58642);
                return;
            case 1000000205:
                this.gdO.mo5610e(1000000205, bArr);
                AppMethodBeat.m2505o(58642);
                return;
        }
        AppMethodBeat.m2505o(58642);
    }
}
