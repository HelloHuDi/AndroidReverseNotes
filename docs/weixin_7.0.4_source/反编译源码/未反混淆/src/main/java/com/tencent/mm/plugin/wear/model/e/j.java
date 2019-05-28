package com.tencent.mm.plugin.wear.model.e;

import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.cud;
import com.tencent.mm.protocal.protobuf.cue;
import com.tencent.mm.protocal.protobuf.cui;
import com.tencent.mm.protocal.protobuf.cuj;
import com.tencent.mm.protocal.protobuf.cul;
import com.tencent.mm.protocal.protobuf.cum;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class j extends a {
    public String tYA = "";

    public final List<Integer> cUA() {
        AppMethodBeat.i(26405);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_INVALID_ADDRESS));
        arrayList.add(Integer.valueOf(11020));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_IN));
        arrayList.add(Integer.valueOf(11031));
        AppMethodBeat.o(26405);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final byte[] p(int i, byte[] bArr) {
        boolean z = true;
        AppMethodBeat.i(26406);
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
                    aw.ZK();
                    U = c.XO().U(cud.vHl, cud.wOP);
                } else {
                    aw.ZK();
                    U = c.XO().T(cud.vHl, cud.wOP);
                }
                int i2 = 0;
                while (i2 < 10 && i2 < U.size()) {
                    cue.wtc.add(h.aj((bi) U.get(i2)));
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
                    AppMethodBeat.o(26406);
                    return toByteArray;
                } catch (IOException e2) {
                    ab.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", e2, "", new Object[0]);
                    break;
                }
                break;
            case 11020:
                a.gn(9, 0);
                a.HH(8);
                cui cui = new cui();
                try {
                    cui.parseFrom(bArr);
                    this.tYA = cui.vHl;
                    cuj cuj = new cuj();
                    aw.ZK();
                    List T = c.XO().T(cui.vHl, cui.wOP);
                    int i3 = 0;
                    while (i3 < 10 && i3 < T.size()) {
                        cuj.wtc.add(h.aj((bi) T.get(i3)));
                        i3++;
                    }
                    if (T.size() <= 10) {
                        z = false;
                    }
                    cuj.xqq = z;
                    try {
                        toByteArray = cuj.toByteArray();
                        AppMethodBeat.o(26406);
                        return toByteArray;
                    } catch (IOException e22) {
                        ab.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", e22, "", new Object[0]);
                        break;
                    }
                } catch (IOException e3) {
                    AppMethodBeat.o(26406);
                    return null;
                }
            case TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_IN /*11021*/:
                this.tYA = "";
                break;
            case 11031:
                a.gn(12, 0);
                a.HH(14);
                cul cul = new cul();
                try {
                    cul.parseFrom(bArr);
                } catch (IOException e4) {
                }
                aw.ZK();
                bi jf = c.XO().jf(cul.vIs);
                cum cum = new cum();
                String fullPath = q.getFullPath(jf.field_imgPath);
                cum.xqP = o.g(fullPath, 0, true);
                cum.vIs = cul.vIs;
                cum.vHn = new b(e.e(fullPath, 0, -1));
                q.M(jf);
                try {
                    toByteArray = cum.toByteArray();
                    AppMethodBeat.o(26406);
                    return toByteArray;
                } catch (IOException e5) {
                    AppMethodBeat.o(26406);
                    return null;
                }
        }
        AppMethodBeat.o(26406);
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean HJ(int i) {
        switch (i) {
            case TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_IN /*11021*/:
            case 11031:
                return false;
            default:
                return true;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean HI(int i) {
        switch (i) {
            case TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_IN /*11021*/:
            case 11031:
                return false;
            default:
                return true;
        }
    }
}
