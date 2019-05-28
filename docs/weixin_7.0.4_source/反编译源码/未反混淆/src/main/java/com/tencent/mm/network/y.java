package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.o;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.d;

public final class y {
    private static final byte[] gdN = o.fZ(7);
    public m gdO;

    static {
        AppMethodBeat.i(58643);
        AppMethodBeat.o(58643);
    }

    public final void onPush(int i, byte[] bArr) {
        AppMethodBeat.i(58642);
        ab.i("MicroMsg.MMNativeNetNotifyAdapter", "onNotify, datalen=" + (bArr == null ? 0 : bArr.length) + " cmd= " + i);
        switch (i) {
            case 5:
                ab.i("MicroMsg.MMNativeNetNotifyAdapter", "old notify");
                this.gdO.e(138, gdN);
                AppMethodBeat.o(58642);
                return;
            case 8:
                if (bArr.length > 0) {
                    this.gdO.e(10, bArr);
                    AppMethodBeat.o(58642);
                    return;
                }
                break;
            case 11:
                AppMethodBeat.o(58642);
                return;
            case 12:
                AppMethodBeat.o(58642);
                return;
            case 24:
                ab.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush new notify [%s]", bo.ca(bArr));
                this.gdO.e(138, bArr);
                AppMethodBeat.o(58642);
                return;
            case 39:
                ab.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do synccheck");
                this.gdO.e(39, null);
                AppMethodBeat.o(58642);
                return;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                this.gdO.e(ErrorCode.NEEDDOWNLOAD_FALSE_4, bArr);
                AppMethodBeat.o(58642);
                return;
            case 120:
                ab.i("MicroMsg.MMNativeNetNotifyAdapter", "MM_PKT_VOIP_REQ");
                if (bArr.length > 0) {
                    this.gdO.e(120, bArr);
                    AppMethodBeat.o(58642);
                    return;
                }
                break;
            case 122:
                ab.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush MM_PKT_PUSH_DATA_REQ");
                if (bArr.length > 0) {
                    this.gdO.e(268369921, bArr);
                    AppMethodBeat.o(58642);
                    return;
                }
                break;
            case az.CTRL_INDEX /*192*/:
                this.gdO.e(az.CTRL_INDEX, bArr);
                AppMethodBeat.o(58642);
                return;
            case d.MIC_PTU_QINGCONG /*241*/:
                ab.i("MicroMsg.MMNativeNetNotifyAdapter", "jacks do voice notify PUSH");
                this.gdO.e(d.MIC_PTU_QINGCONG, bArr);
                AppMethodBeat.o(58642);
                return;
            case 244:
                ab.i("MicroMsg.MMNativeNetNotifyAdapter", "pandy do gamesync notify");
                this.gdO.e(244, bArr);
                AppMethodBeat.o(58642);
                return;
            case d.MIC_PTU_HONGKONG /*311*/:
                ab.i("MicroMsg.MMNativeNetNotifyAdapter", "on notify F2F data");
                this.gdO.e(d.MIC_PTU_HONGKONG, bArr);
                AppMethodBeat.o(58642);
                return;
            case 318:
                ab.i("MicroMsg.MMNativeNetNotifyAdapter", "summerbadcr on silence notify");
                this.gdO.e(318, bArr);
                break;
            case ErrorCode.ERROR_QBSDK_INIT_CANLOADX5 /*319*/:
                ab.i("MicroMsg.MMNativeNetNotifyAdapter", "hy: on notify new year shake");
                this.gdO.e(ErrorCode.ERROR_QBSDK_INIT_CANLOADX5, bArr);
                AppMethodBeat.o(58642);
                return;
            case 268369923:
                ab.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do oob do notify");
                this.gdO.e(268369923, bArr);
                AppMethodBeat.o(58642);
                return;
            case 1000000205:
                this.gdO.e(1000000205, bArr);
                AppMethodBeat.o(58642);
                return;
        }
        AppMethodBeat.o(58642);
    }
}
