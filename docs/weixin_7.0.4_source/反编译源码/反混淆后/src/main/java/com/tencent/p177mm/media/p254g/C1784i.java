package com.tencent.p177mm.media.p254g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/media/remuxer/RemuxConfig;", "", "()V", "Companion", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.g.i */
public final class C1784i {
    public static final C1785a eYK = new C1785a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"Lcom/tencent/mm/media/remuxer/RemuxConfig$Companion;", "", "()V", "useAudioRecord", "", "getAudioCpFile", "", "filePath", "getCpVideoFile", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.g.i$a */
    public static final class C1785a {
        private C1785a() {
        }

        public /* synthetic */ C1785a(byte b) {
            this();
        }

        /* renamed from: lX */
        public static String m3670lX(String str) {
            AppMethodBeat.m2504i(13083);
            C25052j.m39376p(str, "filePath");
            String str2 = str + "_audio.aac";
            AppMethodBeat.m2505o(13083);
            return str2;
        }

        /* renamed from: lY */
        public static String m3671lY(String str) {
            AppMethodBeat.m2504i(13084);
            C25052j.m39376p(str, "filePath");
            String str2 = str + "_cp_video.temp";
            AppMethodBeat.m2505o(13084);
            return str2;
        }
    }

    static {
        AppMethodBeat.m2504i(13085);
        AppMethodBeat.m2505o(13085);
    }
}
