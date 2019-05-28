package com.tencent.p177mm.plugin.gallery.model;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;

@TargetApi(16)
/* renamed from: com.tencent.mm.plugin.gallery.model.m */
public final class C20911m implements Runnable {
    public VideoMediaItem mOA;
    public C20912a mOB;
    public MediaFormat mOy;
    public MediaFormat mOz;
    public String path;
    public int position;

    /* renamed from: com.tencent.mm.plugin.gallery.model.m$1 */
    class C209101 implements Runnable {
        C209101() {
        }

        public final void run() {
            AppMethodBeat.m2504i(21330);
            if (C20911m.this.mOB != null) {
                C20911m.this.mOB.mo36241a(C20911m.this);
            }
            AppMethodBeat.m2505o(21330);
        }
    }

    /* renamed from: com.tencent.mm.plugin.gallery.model.m$a */
    public interface C20912a {
        /* renamed from: a */
        void mo36241a(C20911m c20911m);
    }

    public C20911m(String str, int i, VideoMediaItem videoMediaItem, C20912a c20912a) {
        this.path = str;
        this.position = i;
        this.mOA = videoMediaItem;
        this.mOB = c20912a;
    }

    public final void run() {
        AppMethodBeat.m2504i(21331);
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(this.path);
            int trackCount = mediaExtractor.getTrackCount();
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                if (trackFormat.containsKey("mime")) {
                    String string = trackFormat.getString("mime");
                    C4990ab.m7411d("VideoAnalysisTask", "find video mime : %s", string);
                    if (string != null) {
                        if (string.startsWith("video/")) {
                            if (this.mOy == null) {
                                this.mOy = trackFormat;
                            }
                        } else if (string.startsWith("audio/") && this.mOz == null) {
                            this.mOz = trackFormat;
                        }
                        if (!(this.mOz == null || this.mOy == null)) {
                            break;
                        }
                    }
                    continue;
                } else {
                    C4990ab.m7410d("VideoAnalysisTask", "find video mime : not found.");
                }
            }
            if (this.mOA != null) {
                if (this.mOy != null) {
                    this.mOA.fPW = !this.mOy.containsKey("durationUs") ? 0 : (int) (this.mOy.getLong("durationUs") / 1000);
                    this.mOA.videoHeight = !this.mOy.containsKey("height") ? 0 : this.mOy.getInteger("height");
                    this.mOA.videoWidth = !this.mOy.containsKey("width") ? 0 : this.mOy.getInteger("width");
                    this.mOA.fPU = !this.mOy.containsKey("mime") ? "" : this.mOy.getString("mime");
                    this.mOA.videoBitRate = !this.mOy.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) ? 0 : this.mOy.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE);
                    this.mOA.fPX = !this.mOy.containsKey("i-frame-interval") ? 0 : this.mOy.getInteger("i-frame-interval");
                    this.mOA.videoFrameRate = !this.mOy.containsKey("frame-rate") ? 0 : this.mOy.getInteger("frame-rate");
                }
                if (this.mOz != null) {
                    this.mOA.fPV = !this.mOz.containsKey("mime") ? "" : this.mOz.getString("mime");
                }
            }
            mediaExtractor.release();
        } catch (Exception e) {
            C4990ab.m7411d("VideoAnalysisTask", "Video extractor init failed. video path = [%s] e = [%s]", this.path, e.getMessage());
            mediaExtractor.release();
        } catch (Throwable th) {
            mediaExtractor.release();
            AppMethodBeat.m2505o(21331);
        }
        if (this.mOB == null) {
            C4990ab.m7411d("VideoAnalysisTask", "video analysis end. observer == null, position = [%d], mediaItem = [%s]", Integer.valueOf(this.position), this.mOA);
            AppMethodBeat.m2505o(21331);
            return;
        }
        C5004al.m7441d(new C209101());
        AppMethodBeat.m2505o(21331);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(21332);
        if ((obj instanceof C20911m) && (this == obj || this.position == ((C20911m) obj).position || (this.path != null && this.path.equals(((C20911m) obj).path)))) {
            AppMethodBeat.m2505o(21332);
            return true;
        }
        AppMethodBeat.m2505o(21332);
        return false;
    }
}
