package com.tencent.mm.plugin.emojicapture.proxy;

import a.f.a.b;
import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.yb;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

@l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J5\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062#\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bJ\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\tH\u0007J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0007R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R7\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/proxy/CgiEmojiTextSpamProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "TAG", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "shouldBlock", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "cgiEmojiTextSpam", "text", "cgiEmojiTextSpamCallback", "cgiEmojiTextSpamRemote", "plugin-emojicapture_release"})
public final class CgiEmojiTextSpamProxy extends com.tencent.mm.remoteservice.a {
    private final String TAG = "MicroMsg.CgiEmojiTextSpamProxy";
    private b<? super Boolean, y> exD;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ String lkF;
        final /* synthetic */ CgiEmojiTextSpamProxy lkJ;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "kotlin.jvm.PlatformType", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/EmojiTextAntiSpamResponse;", "call"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.proxy.CgiEmojiTextSpamProxy$a$1 */
        static final class AnonymousClass1<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
            final /* synthetic */ a lkK;

            AnonymousClass1(a aVar) {
                this.lkK = aVar;
            }

            public final /* synthetic */ Object call(Object obj) {
                boolean z;
                AppMethodBeat.i(2798);
                com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                j.p(aVar, "cgiBack");
                if (aVar.errType == 0 && aVar.errCode == 0) {
                    yb ybVar = (yb) aVar.fsy;
                    ab.i(this.lkK.lkJ.TAG, "CgiTextAntiSpam " + ybVar.wdL + ' ' + ybVar.wdM + ' ' + ybVar.wdN);
                    z = ybVar.wdL;
                } else {
                    ab.w(this.lkK.lkJ.TAG, "CgiTextAntiSpam error " + aVar.errType + ' ' + aVar.errCode);
                    z = false;
                }
                Object CLIENT_CALL = this.lkK.lkJ.CLIENT_CALL("cgiEmojiTextSpamCallback", Boolean.valueOf(z));
                AppMethodBeat.o(2798);
                return CLIENT_CALL;
            }
        }

        a(CgiEmojiTextSpamProxy cgiEmojiTextSpamProxy, String str) {
            this.lkJ = cgiEmojiTextSpamProxy;
            this.lkF = str;
        }

        public final void run() {
            AppMethodBeat.i(2799);
            new com.tencent.mm.plugin.emojicapture.a.a(this.lkF).acy().g(new AnonymousClass1(this));
            AppMethodBeat.o(2799);
        }
    }

    public CgiEmojiTextSpamProxy(d dVar) {
        super(dVar);
    }

    public final b<Boolean, y> getCallback() {
        return this.exD;
    }

    public final void setCallback(b<? super Boolean, y> bVar) {
        this.exD = bVar;
    }

    public final void cgiEmojiTextSpam(String str, b<? super Boolean, y> bVar) {
        AppMethodBeat.i(2800);
        ab.i(this.TAG, "cgiEmojiTextSpam ".concat(String.valueOf(str)));
        REMOTE_CALL("cgiEmojiTextSpamRemote", str);
        this.exD = bVar;
        AppMethodBeat.o(2800);
    }

    @e
    public final void cgiEmojiTextSpamCallback(boolean z) {
        AppMethodBeat.i(2801);
        ab.i(this.TAG, "cgiEmojiTextSpamCallback ".concat(String.valueOf(z)));
        b bVar = this.exD;
        if (bVar != null) {
            bVar.am(Boolean.valueOf(z));
            AppMethodBeat.o(2801);
            return;
        }
        AppMethodBeat.o(2801);
    }

    @f
    public final void cgiEmojiTextSpamRemote(String str) {
        AppMethodBeat.i(2802);
        al.d(new a(this, str));
        AppMethodBeat.o(2802);
    }
}
