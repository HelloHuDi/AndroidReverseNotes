package com.tencent.p177mm.plugin.p268aa.p269a.p1215a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C44106c;
import com.tencent.p177mm.protocal.protobuf.C46525b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.aa.a.a.d */
public final class C18769d extends C37440a<C44106c> {
    public C18769d(String str, String str2) {
        AppMethodBeat.m2504i(40643);
        C1196a c1196a = new C1196a();
        C46525b c46525b = new C46525b();
        c46525b.vzL = str;
        c46525b.vzM = str2;
        c1196a.fsJ = c46525b;
        c1196a.fsK = new C44106c();
        c1196a.uri = "/cgi-bin/mmpay-bin/newaaclosenotify";
        this.ehh = c1196a.acD();
        C4990ab.m7417i("MicroMsg.CgiCloseAAUrgeNotify", "CgiCloseAAUrgeNotify, billNo: %s, chatroom: %s", str, str2);
        AppMethodBeat.m2505o(40643);
    }
}
