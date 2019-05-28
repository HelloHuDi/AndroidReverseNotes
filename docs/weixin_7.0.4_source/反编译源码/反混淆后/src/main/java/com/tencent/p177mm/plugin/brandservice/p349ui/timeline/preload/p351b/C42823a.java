package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p351b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C15383rw;
import com.tencent.p177mm.protocal.protobuf.C23436ry;
import com.tencent.p177mm.protocal.protobuf.C30222rx;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.a */
public final class C42823a extends C37440a<C23436ry> {
    public C42823a(LinkedList<C15383rw> linkedList, int i, String str) {
        AppMethodBeat.m2504i(14407);
        C1196a c1196a = new C1196a();
        c1196a.uri = "/cgi-bin/mmbiz-bin/checktmplver";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        C30222rx c30222rx = new C30222rx();
        c30222rx.Scene = i;
        c30222rx.vKt = str;
        c30222rx.vZl = linkedList;
        c1196a.fsJ = c30222rx;
        c1196a.fsK = new C23436ry();
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(14407);
    }
}
