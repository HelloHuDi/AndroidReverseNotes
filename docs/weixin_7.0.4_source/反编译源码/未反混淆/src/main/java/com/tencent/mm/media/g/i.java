package com.tencent.mm.media.g;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/media/remuxer/RemuxConfig;", "", "()V", "Companion", "plugin-mediaeditor_release"})
public final class i {
    public static final a eYK = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"Lcom/tencent/mm/media/remuxer/RemuxConfig$Companion;", "", "()V", "useAudioRecord", "", "getAudioCpFile", "", "filePath", "getCpVideoFile", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static String lX(String str) {
            AppMethodBeat.i(13083);
            j.p(str, "filePath");
            String str2 = str + "_audio.aac";
            AppMethodBeat.o(13083);
            return str2;
        }

        public static String lY(String str) {
            AppMethodBeat.i(13084);
            j.p(str, "filePath");
            String str2 = str + "_cp_video.temp";
            AppMethodBeat.o(13084);
            return str2;
        }
    }

    static {
        AppMethodBeat.i(13085);
        AppMethodBeat.o(13085);
    }
}
