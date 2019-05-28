package com.tencent.mm.media.proxy;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.f;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\t"}, dWq = {"Lcom/tencent/mm/media/proxy/MediaEditorProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "getAccPath", "", "getAccPathRemote", "Companion", "plugin-mediaeditor_release"})
public final class MediaEditorProxy extends com.tencent.mm.remoteservice.a {
    private static final String RESULT_KEY = RESULT_KEY;
    private static final String TAG = TAG;
    public static MediaEditorProxy eWY;
    public static final a eWZ = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/media/proxy/MediaEditorProxy$Companion;", "", "()V", "RESULT_KEY", "", "TAG", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/media/proxy/MediaEditorProxy;", "getInstance", "()Lcom/tencent/mm/media/proxy/MediaEditorProxy;", "setInstance", "(Lcom/tencent/mm/media/proxy/MediaEditorProxy;)V", "createInstance", "", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        private static void a(MediaEditorProxy mediaEditorProxy) {
            AppMethodBeat.i(13000);
            j.p(mediaEditorProxy, "<set-?>");
            MediaEditorProxy.eWY = mediaEditorProxy;
            AppMethodBeat.o(13000);
        }

        public static void createInstance(d dVar) {
            AppMethodBeat.i(13001);
            a(new MediaEditorProxy(dVar));
            AppMethodBeat.o(13001);
        }
    }

    public static final void createInstance(d dVar) {
        AppMethodBeat.i(13006);
        a.createInstance(dVar);
        AppMethodBeat.o(13006);
    }

    public MediaEditorProxy(d dVar) {
        super(dVar);
    }

    public static final /* synthetic */ MediaEditorProxy access$getInstance$cp() {
        AppMethodBeat.i(13005);
        MediaEditorProxy mediaEditorProxy = eWY;
        if (mediaEditorProxy == null) {
            j.avw("instance");
        }
        AppMethodBeat.o(13005);
        return mediaEditorProxy;
    }

    static {
        AppMethodBeat.i(13004);
        AppMethodBeat.o(13004);
    }

    public final String getAccPath() {
        AppMethodBeat.i(13002);
        e RP = g.RP();
        j.o(RP, "MMKernel.storage()");
        String accPath = RP.getAccPath();
        j.o(accPath, "MMKernel.storage().accPath");
        AppMethodBeat.o(13002);
        return accPath;
    }

    @f
    public final String getAccPathRemote() {
        AppMethodBeat.i(13003);
        e RP = g.RP();
        j.o(RP, "MMKernel.storage()");
        String accPath = RP.getAccPath();
        j.o(accPath, "MMKernel.storage().accPath");
        AppMethodBeat.o(13003);
        return accPath;
    }
}
