package com.tencent.mm.media.widget.camerarecordview.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0005H&¨\u0006\n"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "", "getAudioBitrate", "", "getFilePath", "", "getRecordType", "getSampleRate", "getThumbPath", "Companion", "plugin-mediaeditor_release"})
public interface b {
    public static final a fbW = a.fbX;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig$Companion;", "", "()V", "RECORDER_TYPE_FFMPEG", "", "RECORDER_TYPE_MEDIACODEC", "plugin-mediaeditor_release"})
    public static final class a {
        static final /* synthetic */ a fbX = new a();

        static {
            AppMethodBeat.i(13261);
            AppMethodBeat.o(13261);
        }

        private a() {
        }
    }

    int Ww();

    int Wx();

    String Wy();

    String getFilePath();

    int getSampleRate();
}
