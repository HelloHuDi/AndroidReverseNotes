package com.tencent.p177mm.media.p1464e;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.nio.ByteBuffer;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C31820v;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 .2\u00020\u0001:\u0001.B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\u0003J\u0006\u0010\u001a\u001a\u00020\u0003J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\bJ\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u001f\u001a\u00020\bJ\b\u0010 \u001a\u0004\u0018\u00010\u0003J\u0006\u0010!\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\"\u001a\u00020\nJ\u000e\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u001cJ\u0006\u0010*\u001a\u00020'J\u0006\u0010\u000f\u001a\u00020'J\u000e\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\bJ\b\u0010-\u001a\u00020\u0003H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, dWq = {"Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "", "filePath", "", "(Ljava/lang/String;)V", "audioTrackForamt", "Landroid/media/MediaFormat;", "audioTrackIndex", "", "hasError", "", "isRelease", "mediaExtractor", "Landroid/media/MediaExtractor;", "sampleSize", "selectVideo", "videoBitrate", "videoTrackFormat", "videoTrackIndex", "getAudioFormat", "getAudioMIME", "getAudioTrackIndex", "getBitrate", "getCurrentSampleSize", "getDuration", "getFile", "getFilePath", "getSampleTime", "", "getSampleTrackIndex", "getVideoFormat", "getVideoHeight", "getVideoMIME", "getVideoWidth", "isSelectVideo", "readNextSampleData", "byteBuffer", "Ljava/nio/ByteBuffer;", "release", "", "seek", "startTime", "selectAudio", "setBitrate", "bitrate", "toString", "Companion", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.e.a */
public final class C32742a {
    public static final C32743a eWj = new C32743a();
    public final MediaExtractor eWb = new MediaExtractor();
    private int eWc = -1;
    public int eWd = -1;
    public MediaFormat eWe;
    public MediaFormat eWf;
    private boolean eWg;
    public boolean eWh;
    private boolean eWi;
    public final String filePath;
    public int sampleSize;
    private int videoBitrate;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/media/extractor/MediaExtractorWrapper$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.e.a$a */
    public static final class C32743a {
        private C32743a() {
        }

        public /* synthetic */ C32743a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(12981);
        AppMethodBeat.m2505o(12981);
    }

    public C32742a(String str) {
        C25052j.m39376p(str, "filePath");
        AppMethodBeat.m2504i(12980);
        this.filePath = str;
        try {
            C4990ab.m7409c("MicroMsg.MediaExtractorWrapper", "filePath :" + this.filePath, new Object[0]);
            this.eWb.setDataSource(this.filePath);
            int trackCount = this.eWb.getTrackCount();
            C4990ab.m7409c("MicroMsg.MediaExtractorWrapper", "trackCount :".concat(String.valueOf(trackCount)), new Object[0]);
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = this.eWb.getTrackFormat(i);
                String string = trackFormat.getString("mime");
                C25052j.m39375o(string, "mime");
                if (C31820v.m51540d((CharSequence) string, (CharSequence) "video")) {
                    this.eWe = trackFormat;
                    this.eWc = i;
                } else if (C31820v.m51540d((CharSequence) string, (CharSequence) SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)) {
                    this.eWf = trackFormat;
                    this.eWd = i;
                }
            }
            if (this.eWc >= 0) {
                this.eWb.selectTrack(this.eWc);
                this.eWg = true;
            }
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.filePath);
            this.videoBitrate = Integer.parseInt(mediaMetadataRetriever.extractMetadata(20));
            C4990ab.m7410d("MicroMsg.MediaExtractorWrapper", "current info :" + toString());
            AppMethodBeat.m2505o(12980);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MediaExtractorWrapper", e, "", new Object[0]);
            this.eWh = true;
            AppMethodBeat.m2505o(12980);
        }
    }

    /* renamed from: UT */
    public final void mo53290UT() {
        AppMethodBeat.m2504i(12970);
        try {
            if (this.eWd >= 0) {
                this.eWb.unselectTrack(this.eWd);
            }
            if (this.eWc >= 0) {
                this.eWg = true;
                this.eWb.selectTrack(this.eWc);
                this.sampleSize = 0;
                AppMethodBeat.m2505o(12970);
                return;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MediaExtractorWrapper", e, "selectVideo error", new Object[0]);
        }
        AppMethodBeat.m2505o(12970);
    }

    /* renamed from: UU */
    public final void mo53291UU() {
        AppMethodBeat.m2504i(12971);
        try {
            if (this.eWc >= 0) {
                this.eWb.unselectTrack(this.eWc);
            }
            if (this.eWd >= 0) {
                this.eWg = false;
                this.eWb.selectTrack(this.eWd);
                this.sampleSize = 0;
                AppMethodBeat.m2505o(12971);
                return;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MediaExtractorWrapper", e, "selectAudio error", new Object[0]);
        }
        AppMethodBeat.m2505o(12971);
    }

    /* renamed from: UV */
    public final String mo53292UV() {
        AppMethodBeat.m2504i(12972);
        MediaFormat mediaFormat = this.eWe;
        if (mediaFormat != null) {
            String string = mediaFormat.getString("mime");
            AppMethodBeat.m2505o(12972);
            return string;
        }
        AppMethodBeat.m2505o(12972);
        return null;
    }

    /* renamed from: UW */
    public final String mo53293UW() {
        AppMethodBeat.m2504i(12973);
        MediaFormat mediaFormat = this.eWf;
        if (mediaFormat != null) {
            String string = mediaFormat.getString("mime");
            AppMethodBeat.m2505o(12973);
            return string;
        }
        AppMethodBeat.m2505o(12973);
        return null;
    }

    public final long getSampleTime() {
        AppMethodBeat.m2504i(12974);
        try {
            long sampleTime = this.eWb.getSampleTime();
            AppMethodBeat.m2505o(12974);
            return sampleTime;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MediaExtractorWrapper", e, "getSampleTime error", new Object[0]);
            AppMethodBeat.m2505o(12974);
            return -1;
        }
    }

    public final void seek(long j) {
        AppMethodBeat.m2504i(12975);
        this.eWb.seekTo(j, 0);
        AppMethodBeat.m2505o(12975);
    }

    /* renamed from: k */
    public final boolean mo53296k(ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(12976);
        C25052j.m39376p(byteBuffer, "byteBuffer");
        try {
            if (this.eWi) {
                C4990ab.m7412e("MicroMsg.MediaExtractorWrapper", "readNextSampleData already release");
                AppMethodBeat.m2505o(12976);
                return false;
            }
            this.sampleSize = this.eWb.readSampleData(byteBuffer, 0);
            this.eWb.advance();
            if (this.eWb.getSampleTrackIndex() != (this.eWg ? this.eWc : this.eWd)) {
                AppMethodBeat.m2505o(12976);
                return false;
            }
            AppMethodBeat.m2505o(12976);
            return true;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MediaExtractorWrapper", e, "readNextSampleData", new Object[0]);
            AppMethodBeat.m2505o(12976);
            return false;
        }
    }

    public final void release() {
        AppMethodBeat.m2504i(12977);
        this.eWb.release();
        this.eWi = true;
        AppMethodBeat.m2505o(12977);
    }

    public final int getDuration() {
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(12978);
        MediaFormat mediaFormat = this.eWe;
        if (mediaFormat != null) {
            i = (int) mediaFormat.getLong("durationUs");
        } else {
            i = 0;
        }
        if (i <= 0) {
            mediaFormat = this.eWf;
            if (mediaFormat != null) {
                i2 = (int) mediaFormat.getLong("durationUs");
            }
        } else {
            i2 = i;
        }
        AppMethodBeat.m2505o(12978);
        return i2;
    }

    public final String toString() {
        AppMethodBeat.m2504i(12979);
        String str = "MediaExtractorWrapper(filePath='" + this.filePath + "', mediaExtractor=" + this.eWb + ", videoTrackIndex=" + this.eWc + ", audioTrackIndex=" + this.eWd + ", videoTrackFormat=" + this.eWe + ", audioTrackForamt=" + this.eWf + ", videoBitrate=" + this.videoBitrate + ", selectVideo=" + this.eWg + ", sampleSize=" + this.sampleSize + ", hasError=" + this.eWh + ", isRelease=" + this.eWi + ')';
        AppMethodBeat.m2505o(12979);
        return str;
    }
}
