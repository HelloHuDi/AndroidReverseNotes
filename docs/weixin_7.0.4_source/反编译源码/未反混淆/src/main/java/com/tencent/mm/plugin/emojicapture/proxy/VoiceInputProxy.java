package com.tencent.mm.plugin.emojicapture.proxy;

import a.f.b.j;
import a.k.v;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u000eH\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0007J\b\u0010\u0014\u001a\u00020\u0011H\u0007J\b\u0010\u0015\u001a\u00020\u0011H\u0007J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0007R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "uiCallback", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "TAG", "", "getUiCallback", "()Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "setUiCallback", "(Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;)V", "getMaxAmplitudeRate", "", "getMaxAmplitudeRateRemote", "onRecongnizeFinish", "", "onRes", "voiceText", "start", "startRemote", "stop", "fromUI", "", "stopRemote", "Companion", "UICallback", "plugin-emojicapture_release"})
public final class VoiceInputProxy extends com.tencent.mm.remoteservice.a {
    private static g lkR;
    public static final a lkS = new a();
    private final String TAG = "MicroMsg.VoiceInputProxy";
    private b lkQ;

    @l(dWo = {1, 1, 13}, dWp = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J/\u0010\f\u001a\u00020\u00032\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u000e2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, dWq = {"com/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$startRemote$uiCallback$1", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-emojicapture_release"})
    public static final class c implements com.tencent.mm.modelvoiceaddr.g.b {
        final /* synthetic */ VoiceInputProxy lkT;

        c(VoiceInputProxy voiceInputProxy) {
            this.lkT = voiceInputProxy;
        }

        public final void b(String[] strArr, List<String> list) {
            AppMethodBeat.i(138029);
            if (strArr != null) {
                if (((strArr.length == 0 ? 1 : 0) == 0 ? 1 : 0) != 0) {
                    if ((((CharSequence) strArr[0]).length() > 0 ? 1 : 0) != 0) {
                        Object obj = strArr[0];
                        ab.i(this.lkT.TAG, "onRes remote ".concat(String.valueOf(obj)));
                        int d = v.d((CharSequence) obj, "。");
                        if (d >= 0) {
                            if (obj == null) {
                                a.v vVar = new a.v("null cannot be cast to non-null type java.lang.String");
                                AppMethodBeat.o(138029);
                                throw vVar;
                            }
                            obj = obj.substring(0, d);
                            j.o(obj, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        }
                        this.lkT.CLIENT_CALL("onRes", obj);
                    }
                }
            }
            AppMethodBeat.o(138029);
        }

        public final void c(int i, int i2, int i3, long j) {
            AppMethodBeat.i(2844);
            ab.w(this.lkT.TAG, "onError " + i + ' ' + i2 + ' ' + i3 + ' ' + j);
            AppMethodBeat.o(2844);
        }

        public final void ams() {
            AppMethodBeat.i(2845);
            ab.i(this.lkT.TAG, "onRecordFin");
            AppMethodBeat.o(2845);
        }

        public final void amw() {
            AppMethodBeat.i(2846);
            ab.i(this.lkT.TAG, "onRecognizeFinish");
            this.lkT.CLIENT_CALL("onRecognizeFinish", new Object[0]);
            AppMethodBeat.o(2846);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$Companion;", "", "()V", "voiceInputRemote", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr;", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "", "onRecognizeFinish", "", "onRes", "voiceText", "", "plugin-emojicapture_release"})
    public interface b {
        void amw();

        void onRes(String str);
    }

    static {
        AppMethodBeat.i(2855);
        AppMethodBeat.o(2855);
    }

    public final b getUiCallback() {
        return this.lkQ;
    }

    public final void setUiCallback(b bVar) {
        this.lkQ = bVar;
    }

    public VoiceInputProxy(b bVar, d dVar) {
        super(dVar);
        this.lkQ = bVar;
    }

    @e
    public final void start() {
        AppMethodBeat.i(2847);
        REMOTE_CALL("startRemote", new Object[0]);
        AppMethodBeat.o(2847);
    }

    @e
    public final void stop(boolean z) {
        AppMethodBeat.i(2848);
        REMOTE_CALL("stopRemote", Boolean.valueOf(z));
        AppMethodBeat.o(2848);
    }

    @e
    public final void onRes(String str) {
        AppMethodBeat.i(2849);
        b bVar = this.lkQ;
        if (bVar != null) {
            bVar.onRes(str);
            AppMethodBeat.o(2849);
            return;
        }
        AppMethodBeat.o(2849);
    }

    @e
    public final void onRecongnizeFinish() {
        AppMethodBeat.i(2850);
        b bVar = this.lkQ;
        if (bVar != null) {
            bVar.amw();
            AppMethodBeat.o(2850);
            return;
        }
        AppMethodBeat.o(2850);
    }

    @e
    public final int getMaxAmplitudeRate() {
        AppMethodBeat.i(2851);
        Object REMOTE_CALL = REMOTE_CALL("getMaxAmplitudeRateRemote", new Object[0]);
        if (REMOTE_CALL == null || !(REMOTE_CALL instanceof Integer)) {
            AppMethodBeat.o(2851);
            return 0;
        }
        int intValue = ((Number) REMOTE_CALL).intValue();
        AppMethodBeat.o(2851);
        return intValue;
    }

    @f
    public final void startRemote() {
        AppMethodBeat.i(2852);
        g gVar = new g(g.gbc, 9, new c(this));
        lkR = gVar;
        gVar.start();
        AppMethodBeat.o(2852);
    }

    @f
    public final int getMaxAmplitudeRateRemote() {
        AppMethodBeat.i(2853);
        ab.d(this.TAG, "getMaxAmplitudeRateRemote call " + lkR);
        if (lkR != null) {
            g gVar = lkR;
            if (gVar == null) {
                j.dWJ();
            }
            int maxAmplitudeRate = gVar.getMaxAmplitudeRate();
            AppMethodBeat.o(2853);
            return maxAmplitudeRate;
        }
        AppMethodBeat.o(2853);
        return 0;
    }

    @f
    public final void stopRemote(boolean z) {
        AppMethodBeat.i(2854);
        g gVar = lkR;
        if (gVar != null) {
            gVar.stop(z);
        }
        lkR = null;
        AppMethodBeat.o(2854);
    }
}
