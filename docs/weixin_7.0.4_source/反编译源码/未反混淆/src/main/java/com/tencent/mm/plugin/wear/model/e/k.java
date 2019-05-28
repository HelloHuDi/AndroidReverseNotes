package com.tencent.mm.plugin.wear.model.e;

import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.e.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.protocal.protobuf.cuh;
import com.tencent.mm.storage.ad;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class k extends a {
    public final List<Integer> cUA() {
        AppMethodBeat.i(26407);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_ALLADDRESS_FAILED));
        arrayList.add(Integer.valueOf(11010));
        AppMethodBeat.o(26407);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final byte[] p(int i, byte[] bArr) {
        AppMethodBeat.i(26408);
        switch (i) {
            case 11010:
                cuh cuh = new cuh();
                try {
                    cuh.parseFrom(bArr);
                } catch (IOException e) {
                }
                a.cUn().tXv.dv(cuh.wyw, cuh.wXt);
                AppMethodBeat.o(26408);
                break;
            case TXCStreamUploader.TXE_UPLOAD_ERROR_ALLADDRESS_FAILED /*11011*/:
                String str;
                String str2 = "";
                try {
                    str = new String(bArr, "utf8");
                } catch (UnsupportedEncodingException e2) {
                    str = str2;
                }
                aw.ZK();
                ad aoO = c.XM().aoO(str);
                if (t.kH(str)) {
                    aw.ZK();
                    aoO = c.XM().aoO(str);
                    aoO.hE(0);
                    aw.ZK();
                    c.XM().b(str, aoO);
                    aw.ZK();
                    c.XL().c(new b(str, 0));
                } else {
                    t.o(aoO);
                }
                com.tencent.mm.plugin.wear.model.c.a.gn(4, 0);
                break;
        }
        AppMethodBeat.o(26408);
        return null;
    }
}
