package com.tencent.p177mm.plugin.emojicapture.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvoiceaddr.C42236g;
import com.tencent.p177mm.modelvoiceaddr.C42236g.C32852b;
import com.tencent.p177mm.remoteservice.C31577a;
import com.tencent.p177mm.remoteservice.C40602e;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.remoteservice.C46608f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C31820v;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u000eH\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0007J\b\u0010\u0014\u001a\u00020\u0011H\u0007J\b\u0010\u0015\u001a\u00020\u0011H\u0007J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0007R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "uiCallback", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "TAG", "", "getUiCallback", "()Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "setUiCallback", "(Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;)V", "getMaxAmplitudeRate", "", "getMaxAmplitudeRateRemote", "onRecongnizeFinish", "", "onRes", "voiceText", "start", "startRemote", "stop", "fromUI", "", "stopRemote", "Companion", "UICallback", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy */
public final class VoiceInputProxy extends C31577a {
    private static C42236g lkR;
    public static final C11619a lkS = new C11619a();
    private final String TAG = "MicroMsg.VoiceInputProxy";
    private C11620b lkQ;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J/\u0010\f\u001a\u00020\u00032\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u000e2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, dWq = {"com/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$startRemote$uiCallback$1", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy$c */
    public static final class C11618c implements C32852b {
        final /* synthetic */ VoiceInputProxy lkT;

        C11618c(VoiceInputProxy voiceInputProxy) {
            this.lkT = voiceInputProxy;
        }

        /* renamed from: b */
        public final void mo21116b(String[] strArr, List<String> list) {
            AppMethodBeat.m2504i(138029);
            if (strArr != null) {
                if (((strArr.length == 0 ? 1 : 0) == 0 ? 1 : 0) != 0) {
                    if ((((CharSequence) strArr[0]).length() > 0 ? 1 : 0) != 0) {
                        Object obj = strArr[0];
                        C4990ab.m7416i(this.lkT.TAG, "onRes remote ".concat(String.valueOf(obj)));
                        int d = C31820v.m51539d((CharSequence) obj, "。");
                        if (d >= 0) {
                            if (obj == null) {
                                C44941v c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
                                AppMethodBeat.m2505o(138029);
                                throw c44941v;
                            }
                            obj = obj.substring(0, d);
                            C25052j.m39375o(obj, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        }
                        this.lkT.CLIENT_CALL("onRes", obj);
                    }
                }
            }
            AppMethodBeat.m2505o(138029);
        }

        /* renamed from: c */
        public final void mo21117c(int i, int i2, int i3, long j) {
            AppMethodBeat.m2504i(2844);
            C4990ab.m7420w(this.lkT.TAG, "onError " + i + ' ' + i2 + ' ' + i3 + ' ' + j);
            AppMethodBeat.m2505o(2844);
        }

        public final void ams() {
            AppMethodBeat.m2504i(2845);
            C4990ab.m7416i(this.lkT.TAG, "onRecordFin");
            AppMethodBeat.m2505o(2845);
        }

        public final void amw() {
            AppMethodBeat.m2504i(2846);
            C4990ab.m7416i(this.lkT.TAG, "onRecognizeFinish");
            this.lkT.CLIENT_CALL("onRecognizeFinish", new Object[0]);
            AppMethodBeat.m2505o(2846);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$Companion;", "", "()V", "voiceInputRemote", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr;", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy$a */
    public static final class C11619a {
        private C11619a() {
        }

        public /* synthetic */ C11619a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "", "onRecognizeFinish", "", "onRes", "voiceText", "", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy$b */
    public interface C11620b {
        void amw();

        void onRes(String str);
    }

    static {
        AppMethodBeat.m2504i(2855);
        AppMethodBeat.m2505o(2855);
    }

    public final C11620b getUiCallback() {
        return this.lkQ;
    }

    public final void setUiCallback(C11620b c11620b) {
        this.lkQ = c11620b;
    }

    public VoiceInputProxy(C11620b c11620b, C46607d c46607d) {
        super(c46607d);
        this.lkQ = c11620b;
    }

    @C40602e
    public final void start() {
        AppMethodBeat.m2504i(2847);
        REMOTE_CALL("startRemote", new Object[0]);
        AppMethodBeat.m2505o(2847);
    }

    @C40602e
    public final void stop(boolean z) {
        AppMethodBeat.m2504i(2848);
        REMOTE_CALL("stopRemote", Boolean.valueOf(z));
        AppMethodBeat.m2505o(2848);
    }

    @C40602e
    public final void onRes(String str) {
        AppMethodBeat.m2504i(2849);
        C11620b c11620b = this.lkQ;
        if (c11620b != null) {
            c11620b.onRes(str);
            AppMethodBeat.m2505o(2849);
            return;
        }
        AppMethodBeat.m2505o(2849);
    }

    @C40602e
    public final void onRecongnizeFinish() {
        AppMethodBeat.m2504i(2850);
        C11620b c11620b = this.lkQ;
        if (c11620b != null) {
            c11620b.amw();
            AppMethodBeat.m2505o(2850);
            return;
        }
        AppMethodBeat.m2505o(2850);
    }

    @C40602e
    public final int getMaxAmplitudeRate() {
        AppMethodBeat.m2504i(2851);
        Object REMOTE_CALL = REMOTE_CALL("getMaxAmplitudeRateRemote", new Object[0]);
        if (REMOTE_CALL == null || !(REMOTE_CALL instanceof Integer)) {
            AppMethodBeat.m2505o(2851);
            return 0;
        }
        int intValue = ((Number) REMOTE_CALL).intValue();
        AppMethodBeat.m2505o(2851);
        return intValue;
    }

    @C46608f
    public final void startRemote() {
        AppMethodBeat.m2504i(2852);
        C42236g c42236g = new C42236g(C42236g.gbc, 9, new C11618c(this));
        lkR = c42236g;
        c42236g.start();
        AppMethodBeat.m2505o(2852);
    }

    @C46608f
    public final int getMaxAmplitudeRateRemote() {
        AppMethodBeat.m2504i(2853);
        C4990ab.m7410d(this.TAG, "getMaxAmplitudeRateRemote call " + lkR);
        if (lkR != null) {
            C42236g c42236g = lkR;
            if (c42236g == null) {
                C25052j.dWJ();
            }
            int maxAmplitudeRate = c42236g.getMaxAmplitudeRate();
            AppMethodBeat.m2505o(2853);
            return maxAmplitudeRate;
        }
        AppMethodBeat.m2505o(2853);
        return 0;
    }

    @C46608f
    public final void stopRemote(boolean z) {
        AppMethodBeat.m2504i(2854);
        C42236g c42236g = lkR;
        if (c42236g != null) {
            c42236g.stop(z);
        }
        lkR = null;
        AppMethodBeat.m2505o(2854);
    }
}
