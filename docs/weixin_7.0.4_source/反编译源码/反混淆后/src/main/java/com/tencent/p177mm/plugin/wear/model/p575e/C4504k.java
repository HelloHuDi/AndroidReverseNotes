package com.tencent.p177mm.plugin.wear.model.p575e;

import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.chatroom.p1596e.C41925b;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.wear.model.C43841a;
import com.tencent.p177mm.plugin.wear.model.p1662c.C46393a;
import com.tencent.p177mm.protocal.protobuf.cuh;
import com.tencent.p177mm.storage.C7616ad;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wear.model.e.k */
public final class C4504k extends C46394a {
    public final List<Integer> cUA() {
        AppMethodBeat.m2504i(26407);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_ALLADDRESS_FAILED));
        arrayList.add(Integer.valueOf(11010));
        AppMethodBeat.m2505o(26407);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: p */
    public final byte[] mo9572p(int i, byte[] bArr) {
        AppMethodBeat.m2504i(26408);
        switch (i) {
            case 11010:
                cuh cuh = new cuh();
                try {
                    cuh.parseFrom(bArr);
                } catch (IOException e) {
                }
                C43841a.cUn().tXv.mo38317dv(cuh.wyw, cuh.wXt);
                AppMethodBeat.m2505o(26408);
                break;
            case TXCStreamUploader.TXE_UPLOAD_ERROR_ALLADDRESS_FAILED /*11011*/:
                String str;
                String str2 = "";
                try {
                    str = new String(bArr, "utf8");
                } catch (UnsupportedEncodingException e2) {
                    str = str2;
                }
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO(str);
                if (C1855t.m3896kH(str)) {
                    C9638aw.m17190ZK();
                    aoO = C18628c.m29078XM().aoO(str);
                    aoO.mo14689hE(0);
                    C9638aw.m17190ZK();
                    C18628c.m29078XM().mo15724b(str, aoO);
                    C9638aw.m17190ZK();
                    C18628c.m29077XL().mo7920c(new C41925b(str, 0));
                } else {
                    C1855t.m3958o(aoO);
                }
                C46393a.m87276gn(4, 0);
                break;
        }
        AppMethodBeat.m2505o(26408);
        return null;
    }
}
