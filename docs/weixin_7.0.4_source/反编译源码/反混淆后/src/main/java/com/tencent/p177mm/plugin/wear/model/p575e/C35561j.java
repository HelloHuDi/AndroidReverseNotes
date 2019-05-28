package com.tencent.p177mm.plugin.wear.model.p575e;

import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoice.C32848o;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.wear.model.C43845h;
import com.tencent.p177mm.plugin.wear.model.p1662c.C46393a;
import com.tencent.p177mm.protocal.protobuf.cud;
import com.tencent.p177mm.protocal.protobuf.cue;
import com.tencent.p177mm.protocal.protobuf.cui;
import com.tencent.p177mm.protocal.protobuf.cuj;
import com.tencent.p177mm.protocal.protobuf.cul;
import com.tencent.p177mm.protocal.protobuf.cum;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wear.model.e.j */
public final class C35561j extends C46394a {
    public String tYA = "";

    public final List<Integer> cUA() {
        AppMethodBeat.m2504i(26405);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_INVALID_ADDRESS));
        arrayList.add(Integer.valueOf(11020));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_IN));
        arrayList.add(Integer.valueOf(11031));
        AppMethodBeat.m2505o(26405);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: p */
    public final byte[] mo9572p(int i, byte[] bArr) {
        boolean z = true;
        AppMethodBeat.m2504i(26406);
        byte[] toByteArray;
        switch (i) {
            case TXCStreamUploader.TXE_UPLOAD_ERROR_INVALID_ADDRESS /*11019*/:
                List U;
                boolean z2;
                cud cud = new cud();
                try {
                    cud.parseFrom(bArr);
                } catch (IOException e) {
                }
                cue cue = new cue();
                cue.xqF = cud.xqF;
                if (cue.xqF) {
                    C9638aw.m17190ZK();
                    U = C18628c.m29080XO().mo15275U(cud.vHl, cud.wOP);
                } else {
                    C9638aw.m17190ZK();
                    U = C18628c.m29080XO().mo15274T(cud.vHl, cud.wOP);
                }
                int i2 = 0;
                while (i2 < 10 && i2 < U.size()) {
                    cue.wtc.add(C43845h.m78628aj((C7620bi) U.get(i2)));
                    i2++;
                }
                if (U.size() > 10) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                cue.xqq = z2;
                try {
                    toByteArray = cue.toByteArray();
                    AppMethodBeat.m2505o(26406);
                    return toByteArray;
                } catch (IOException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", e2, "", new Object[0]);
                    break;
                }
                break;
            case 11020:
                C46393a.m87276gn(9, 0);
                C46393a.m87275HH(8);
                cui cui = new cui();
                try {
                    cui.parseFrom(bArr);
                    this.tYA = cui.vHl;
                    cuj cuj = new cuj();
                    C9638aw.m17190ZK();
                    List T = C18628c.m29080XO().mo15274T(cui.vHl, cui.wOP);
                    int i3 = 0;
                    while (i3 < 10 && i3 < T.size()) {
                        cuj.wtc.add(C43845h.m78628aj((C7620bi) T.get(i3)));
                        i3++;
                    }
                    if (T.size() <= 10) {
                        z = false;
                    }
                    cuj.xqq = z;
                    try {
                        toByteArray = cuj.toByteArray();
                        AppMethodBeat.m2505o(26406);
                        return toByteArray;
                    } catch (IOException e22) {
                        C4990ab.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", e22, "", new Object[0]);
                        break;
                    }
                } catch (IOException e3) {
                    AppMethodBeat.m2505o(26406);
                    return null;
                }
            case TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_IN /*11021*/:
                this.tYA = "";
                break;
            case 11031:
                C46393a.m87276gn(12, 0);
                C46393a.m87275HH(14);
                cul cul = new cul();
                try {
                    cul.parseFrom(bArr);
                } catch (IOException e4) {
                }
                C9638aw.m17190ZK();
                C7620bi jf = C18628c.m29080XO().mo15340jf(cul.vIs);
                cum cum = new cum();
                String fullPath = C32850q.getFullPath(jf.field_imgPath);
                cum.xqP = C32848o.m53696g(fullPath, 0, true);
                cum.vIs = cul.vIs;
                cum.vHn = new C1332b(C5730e.m8632e(fullPath, 0, -1));
                C32850q.m53706M(jf);
                try {
                    toByteArray = cum.toByteArray();
                    AppMethodBeat.m2505o(26406);
                    return toByteArray;
                } catch (IOException e5) {
                    AppMethodBeat.m2505o(26406);
                    return null;
                }
        }
        AppMethodBeat.m2505o(26406);
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: HJ */
    public final boolean mo9570HJ(int i) {
        switch (i) {
            case TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_IN /*11021*/:
            case 11031:
                return false;
            default:
                return true;
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: HI */
    public final boolean mo9569HI(int i) {
        switch (i) {
            case TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_IN /*11021*/:
            case 11031:
                return false;
            default:
                return true;
        }
    }
}
