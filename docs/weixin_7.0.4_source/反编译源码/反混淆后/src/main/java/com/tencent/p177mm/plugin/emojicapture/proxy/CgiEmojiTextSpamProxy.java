package com.tencent.p177mm.plugin.emojicapture.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.plugin.emojicapture.p1608a.C42968a;
import com.tencent.p177mm.protocal.protobuf.C40589yb;
import com.tencent.p177mm.remoteservice.C31577a;
import com.tencent.p177mm.remoteservice.C40602e;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.remoteservice.C46608f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.vending.p637c.C5681a;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J5\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062#\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bJ\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\tH\u0007J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0007R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R7\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/proxy/CgiEmojiTextSpamProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "TAG", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "shouldBlock", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "cgiEmojiTextSpam", "text", "cgiEmojiTextSpamCallback", "cgiEmojiTextSpamRemote", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.proxy.CgiEmojiTextSpamProxy */
public final class CgiEmojiTextSpamProxy extends C31577a {
    private final String TAG = "MicroMsg.CgiEmojiTextSpamProxy";
    private C17126b<? super Boolean, C37091y> exD;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.proxy.CgiEmojiTextSpamProxy$a */
    static final class C31578a implements Runnable {
        final /* synthetic */ String lkF;
        final /* synthetic */ CgiEmojiTextSpamProxy lkJ;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "kotlin.jvm.PlatformType", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/EmojiTextAntiSpamResponse;", "call"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.proxy.CgiEmojiTextSpamProxy$a$1 */
        static final class C204361<_Ret, _Var> implements C5681a<_Ret, _Var> {
            final /* synthetic */ C31578a lkK;

            C204361(C31578a c31578a) {
                this.lkK = c31578a;
            }

            public final /* synthetic */ Object call(Object obj) {
                boolean z;
                AppMethodBeat.m2504i(2798);
                C37441a c37441a = (C37441a) obj;
                C25052j.m39376p(c37441a, "cgiBack");
                if (c37441a.errType == 0 && c37441a.errCode == 0) {
                    C40589yb c40589yb = (C40589yb) c37441a.fsy;
                    C4990ab.m7416i(this.lkK.lkJ.TAG, "CgiTextAntiSpam " + c40589yb.wdL + ' ' + c40589yb.wdM + ' ' + c40589yb.wdN);
                    z = c40589yb.wdL;
                } else {
                    C4990ab.m7420w(this.lkK.lkJ.TAG, "CgiTextAntiSpam error " + c37441a.errType + ' ' + c37441a.errCode);
                    z = false;
                }
                Object CLIENT_CALL = this.lkK.lkJ.CLIENT_CALL("cgiEmojiTextSpamCallback", Boolean.valueOf(z));
                AppMethodBeat.m2505o(2798);
                return CLIENT_CALL;
            }
        }

        C31578a(CgiEmojiTextSpamProxy cgiEmojiTextSpamProxy, String str) {
            this.lkJ = cgiEmojiTextSpamProxy;
            this.lkF = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(2799);
            new C42968a(this.lkF).acy().mo60491g(new C204361(this));
            AppMethodBeat.m2505o(2799);
        }
    }

    public CgiEmojiTextSpamProxy(C46607d c46607d) {
        super(c46607d);
    }

    public final C17126b<Boolean, C37091y> getCallback() {
        return this.exD;
    }

    public final void setCallback(C17126b<? super Boolean, C37091y> c17126b) {
        this.exD = c17126b;
    }

    public final void cgiEmojiTextSpam(String str, C17126b<? super Boolean, C37091y> c17126b) {
        AppMethodBeat.m2504i(2800);
        C4990ab.m7416i(this.TAG, "cgiEmojiTextSpam ".concat(String.valueOf(str)));
        REMOTE_CALL("cgiEmojiTextSpamRemote", str);
        this.exD = c17126b;
        AppMethodBeat.m2505o(2800);
    }

    @C40602e
    public final void cgiEmojiTextSpamCallback(boolean z) {
        AppMethodBeat.m2504i(2801);
        C4990ab.m7416i(this.TAG, "cgiEmojiTextSpamCallback ".concat(String.valueOf(z)));
        C17126b c17126b = this.exD;
        if (c17126b != null) {
            c17126b.mo50am(Boolean.valueOf(z));
            AppMethodBeat.m2505o(2801);
            return;
        }
        AppMethodBeat.m2505o(2801);
    }

    @C46608f
    public final void cgiEmojiTextSpamRemote(String str) {
        AppMethodBeat.m2504i(2802);
        C5004al.m7441d(new C31578a(this, str));
        AppMethodBeat.m2505o(2802);
    }
}
