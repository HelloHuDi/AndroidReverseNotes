package com.tencent.p177mm.media.p254g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.p254g.C37894c.C37893a;
import com.tencent.p177mm.media.p254g.C37894c.C37895b;
import com.tencent.ugc.TXRecordCommon;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JG\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002JW\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerFactory;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer$Factory;", "()V", "get", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "filePath", "", "outputFilePath", "outputWidth", "", "outputHeight", "outputBitrate", "outputFps", "callback", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer$FinishCallback;", "startTimeMs", "", "endTimeMs", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.g.g */
public final class C9605g implements C37893a {

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "path", "", "invoke"})
    /* renamed from: com.tencent.mm.media.g.g$a */
    static final class C9606a extends C25053k implements C17126b<String, C37091y> {
        final /* synthetic */ C37895b eYJ;

        C9606a(C37895b c37895b) {
            this.eYJ = c37895b;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(13074);
            String str = (String) obj;
            C37895b c37895b = this.eYJ;
            if (c37895b != null) {
                c37895b.mo21981lW(str);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13074);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "path", "", "invoke"})
    /* renamed from: com.tencent.mm.media.g.g$b */
    static final class C9607b extends C25053k implements C17126b<String, C37091y> {
        final /* synthetic */ C37895b eYJ;

        C9607b(C37895b c37895b) {
            this.eYJ = c37895b;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(13075);
            String str = (String) obj;
            C37895b c37895b = this.eYJ;
            if (c37895b != null) {
                c37895b.mo21981lW(str);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(13075);
            return c37091y;
        }
    }

    /* renamed from: a */
    public final C37894c mo20921a(String str, String str2, int i, int i2, int i3, int i4, C37895b c37895b) {
        AppMethodBeat.m2504i(13076);
        C37894c c32751e = new C32751e(null, str == null ? "" : str, 1, str2 == null ? "" : str2, i, i2, i3, TXRecordCommon.AUDIO_SAMPLERATE_48000, TXRecordCommon.AUDIO_SAMPLERATE_44100, i4, 0, 0, new C9606a(c37895b));
        AppMethodBeat.m2505o(13076);
        return c32751e;
    }

    /* renamed from: a */
    public final C37894c mo20920a(String str, String str2, int i, int i2, int i3, int i4, long j, long j2, C37895b c37895b) {
        AppMethodBeat.m2504i(13077);
        C37894c c32751e = new C32751e(null, str == null ? "" : str, 1, str2 == null ? "" : str2, i, i2, i3, TXRecordCommon.AUDIO_SAMPLERATE_48000, TXRecordCommon.AUDIO_SAMPLERATE_44100, i4, j, j2, new C9607b(c37895b));
        AppMethodBeat.m2505o(13077);
        return c32751e;
    }
}
