package com.tencent.p177mm.plugin.luckymoney.appbrand.p988a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.bom;
import com.tencent.p177mm.protocal.protobuf.bon;
import com.tencent.p177mm.protocal.protobuf.btd;

/* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.a.c */
public final class C28394c extends C46056a<bom, bon> {
    public C28394c(String str, String str2, int i) {
        AppMethodBeat.m2504i(41987);
        bom bom = new bom();
        bom.csB = str;
        bom.wKw = str2;
        bom.offset = i;
        this.nRK = bom;
        AppMethodBeat.m2505o(41987);
    }

    /* Access modifiers changed, original: protected|final */
    public final String getUri() {
        return "/cgi-bin/mmbiz-bin/wxahb/querywxaapphbdetail";
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: ZU */
    public final int mo24259ZU() {
        return 2949;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ btd bKR() {
        AppMethodBeat.m2504i(41988);
        bon bon = new bon();
        AppMethodBeat.m2505o(41988);
        return bon;
    }
}
