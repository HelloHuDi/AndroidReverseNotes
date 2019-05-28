package com.tencent.p177mm.plugin.wallet.balance.p550a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C40556pb;
import com.tencent.p177mm.protocal.protobuf.C40557pc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.b */
public final class C4320b extends C37440a<C40557pc> {
    public C4320b(long j, String str, String str2) {
        AppMethodBeat.m2504i(45220);
        C1196a c1196a = new C1196a();
        C40556pb c40556pb = new C40556pb();
        c40556pb.vWl = j;
        c40556pb.vWm = str;
        c40556pb.vWn = str2;
        c1196a.fsJ = c40556pb;
        c1196a.fsK = new C40557pc();
        c1196a.uri = "/cgi-bin/mmpay-bin/tenpay/getfreefeedetail";
        this.ehh = c1196a.acD();
        C4990ab.m7417i("MicroMsg.CgiGetFreeFeeDetail", "get free fee detail: %s, %s, %s", Long.valueOf(j), str, str2);
        AppMethodBeat.m2505o(45220);
    }
}
