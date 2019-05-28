package com.tencent.p177mm.plugin.emojicapture.p1608a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.C42541c;
import com.tencent.p177mm.protocal.protobuf.C40589yb;
import com.tencent.p177mm.protocal.protobuf.C46600ya;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/cgi/CgiTextAntiSpam;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/EmojiTextAntiSpamResponse;", "text", "", "(Ljava/lang/String;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getText", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.a.a */
public final class C42968a extends C37440a<C40589yb> {
    private final String TAG = "MicroMsg.CgiTextAntiSpam";
    private final String text;

    public C42968a(String str) {
        AppMethodBeat.m2504i(2568);
        this.text = str;
        C1196a c1196a = new C1196a();
        C46600ya c46600ya = new C46600ya();
        c46600ya.wdK = this.text;
        c1196a.mo4444a(c46600ya);
        c1196a.mo4446b(new C40589yb());
        c1196a.mo4450qq("/cgi-bin/micromsg-bin/mmemojitextantispam");
        c1196a.mo4447kU(C42541c.CTRL_INDEX);
        mo60331a(c1196a.acD());
        C4990ab.m7416i(this.TAG, "Check text anti spam " + this.text);
        AppMethodBeat.m2505o(2568);
    }
}
