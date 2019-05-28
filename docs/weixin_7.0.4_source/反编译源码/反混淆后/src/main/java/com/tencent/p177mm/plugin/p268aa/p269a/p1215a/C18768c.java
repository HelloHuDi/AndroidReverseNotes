package com.tencent.p177mm.plugin.p268aa.p269a.p1215a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C7556w;
import com.tencent.p177mm.protocal.protobuf.C7559x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.aa.a.a.c */
public final class C18768c extends C37440a<C7559x> {
    public C18768c(int i, int i2, int i3, String str, int i4, int i5, String str2) {
        AppMethodBeat.m2504i(40641);
        C1196a c1196a = new C1196a();
        C7556w c7556w = new C7556w();
        c7556w.limit = i;
        c7556w.offset = i2;
        c7556w.type = i3;
        c7556w.vAz = str;
        c7556w.vAA = i4;
        c7556w.vAB = i5;
        c7556w.vAC = str2;
        c1196a.fsJ = c7556w;
        c1196a.fsK = new C7559x();
        c1196a.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
        this.ehh = c1196a.acD();
        C4990ab.m7417i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s, bill_id: %s, trans_id: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, str2);
        AppMethodBeat.m2505o(40641);
    }

    public C18768c(int i, int i2, int i3) {
        AppMethodBeat.m2504i(40642);
        C1196a c1196a = new C1196a();
        C7556w c7556w = new C7556w();
        c7556w.limit = i;
        c7556w.offset = i2;
        c7556w.type = i3;
        c1196a.fsJ = c7556w;
        c1196a.fsK = new C7559x();
        c1196a.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
        this.ehh = c1196a.acD();
        C4990ab.m7417i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.m2505o(40642);
    }
}
