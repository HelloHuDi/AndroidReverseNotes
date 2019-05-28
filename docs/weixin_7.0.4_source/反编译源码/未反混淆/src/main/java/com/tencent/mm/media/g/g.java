package com.tencent.mm.media.g;

import a.f.b.k;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;

@l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JG\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002JW\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerFactory;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer$Factory;", "()V", "get", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "filePath", "", "outputFilePath", "outputWidth", "", "outputHeight", "outputBitrate", "outputFps", "callback", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer$FinishCallback;", "startTimeMs", "", "endTimeMs", "plugin-mediaeditor_release"})
public final class g implements com.tencent.mm.media.g.c.a {

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "path", "", "invoke"})
    static final class a extends k implements a.f.a.b<String, y> {
        final /* synthetic */ com.tencent.mm.media.g.c.b eYJ;

        a(com.tencent.mm.media.g.c.b bVar) {
            this.eYJ = bVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(13074);
            String str = (String) obj;
            com.tencent.mm.media.g.c.b bVar = this.eYJ;
            if (bVar != null) {
                bVar.lW(str);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(13074);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "path", "", "invoke"})
    static final class b extends k implements a.f.a.b<String, y> {
        final /* synthetic */ com.tencent.mm.media.g.c.b eYJ;

        b(com.tencent.mm.media.g.c.b bVar) {
            this.eYJ = bVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(13075);
            String str = (String) obj;
            com.tencent.mm.media.g.c.b bVar = this.eYJ;
            if (bVar != null) {
                bVar.lW(str);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(13075);
            return yVar;
        }
    }

    public final c a(String str, String str2, int i, int i2, int i3, int i4, com.tencent.mm.media.g.c.b bVar) {
        AppMethodBeat.i(13076);
        c eVar = new e(null, str == null ? "" : str, 1, str2 == null ? "" : str2, i, i2, i3, TXRecordCommon.AUDIO_SAMPLERATE_48000, TXRecordCommon.AUDIO_SAMPLERATE_44100, i4, 0, 0, new a(bVar));
        AppMethodBeat.o(13076);
        return eVar;
    }

    public final c a(String str, String str2, int i, int i2, int i3, int i4, long j, long j2, com.tencent.mm.media.g.c.b bVar) {
        AppMethodBeat.i(13077);
        c eVar = new e(null, str == null ? "" : str, 1, str2 == null ? "" : str2, i, i2, i3, TXRecordCommon.AUDIO_SAMPLERATE_48000, TXRecordCommon.AUDIO_SAMPLERATE_44100, i4, j, j2, new b(bVar));
        AppMethodBeat.o(13077);
        return eVar;
    }
}
