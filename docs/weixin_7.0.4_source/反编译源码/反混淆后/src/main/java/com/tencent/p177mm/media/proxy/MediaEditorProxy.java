package com.tencent.p177mm.media.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.remoteservice.C31577a;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.remoteservice.C46608f;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\t"}, dWq = {"Lcom/tencent/mm/media/proxy/MediaEditorProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "getAccPath", "", "getAccPathRemote", "Companion", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.proxy.MediaEditorProxy */
public final class MediaEditorProxy extends C31577a {
    private static final String RESULT_KEY = RESULT_KEY;
    private static final String TAG = TAG;
    public static MediaEditorProxy eWY;
    public static final C32762a eWZ = new C32762a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/media/proxy/MediaEditorProxy$Companion;", "", "()V", "RESULT_KEY", "", "TAG", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/media/proxy/MediaEditorProxy;", "getInstance", "()Lcom/tencent/mm/media/proxy/MediaEditorProxy;", "setInstance", "(Lcom/tencent/mm/media/proxy/MediaEditorProxy;)V", "createInstance", "", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.proxy.MediaEditorProxy$a */
    public static final class C32762a {
        private C32762a() {
        }

        public /* synthetic */ C32762a(byte b) {
            this();
        }

        /* renamed from: a */
        private static void m53494a(MediaEditorProxy mediaEditorProxy) {
            AppMethodBeat.m2504i(13000);
            C25052j.m39376p(mediaEditorProxy, "<set-?>");
            MediaEditorProxy.eWY = mediaEditorProxy;
            AppMethodBeat.m2505o(13000);
        }

        public static void createInstance(C46607d c46607d) {
            AppMethodBeat.m2504i(13001);
            C32762a.m53494a(new MediaEditorProxy(c46607d));
            AppMethodBeat.m2505o(13001);
        }
    }

    public static final void createInstance(C46607d c46607d) {
        AppMethodBeat.m2504i(13006);
        C32762a.createInstance(c46607d);
        AppMethodBeat.m2505o(13006);
    }

    public MediaEditorProxy(C46607d c46607d) {
        super(c46607d);
    }

    public static final /* synthetic */ MediaEditorProxy access$getInstance$cp() {
        AppMethodBeat.m2504i(13005);
        MediaEditorProxy mediaEditorProxy = eWY;
        if (mediaEditorProxy == null) {
            C25052j.avw("instance");
        }
        AppMethodBeat.m2505o(13005);
        return mediaEditorProxy;
    }

    static {
        AppMethodBeat.m2504i(13004);
        AppMethodBeat.m2505o(13004);
    }

    public final String getAccPath() {
        AppMethodBeat.m2504i(13002);
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        String accPath = RP.getAccPath();
        C25052j.m39375o(accPath, "MMKernel.storage().accPath");
        AppMethodBeat.m2505o(13002);
        return accPath;
    }

    @C46608f
    public final String getAccPathRemote() {
        AppMethodBeat.m2504i(13003);
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        String accPath = RP.getAccPath();
        C25052j.m39375o(accPath, "MMKernel.storage().accPath");
        AppMethodBeat.m2505o(13003);
        return accPath;
    }
}
