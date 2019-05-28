package com.tencent.mm.plugin.gallery.model;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

@TargetApi(16)
public final class m implements Runnable {
    public VideoMediaItem mOA;
    public a mOB;
    public MediaFormat mOy;
    public MediaFormat mOz;
    public String path;
    public int position;

    public interface a {
        void a(m mVar);
    }

    public m(String str, int i, VideoMediaItem videoMediaItem, a aVar) {
        this.path = str;
        this.position = i;
        this.mOA = videoMediaItem;
        this.mOB = aVar;
    }

    public final void run() {
        AppMethodBeat.i(21331);
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(this.path);
            int trackCount = mediaExtractor.getTrackCount();
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                if (trackFormat.containsKey("mime")) {
                    String string = trackFormat.getString("mime");
                    ab.d("VideoAnalysisTask", "find video mime : %s", string);
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
                    ab.d("VideoAnalysisTask", "find video mime : not found.");
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
            ab.d("VideoAnalysisTask", "Video extractor init failed. video path = [%s] e = [%s]", this.path, e.getMessage());
            mediaExtractor.release();
        } catch (Throwable th) {
            mediaExtractor.release();
            AppMethodBeat.o(21331);
        }
        if (this.mOB == null) {
            ab.d("VideoAnalysisTask", "video analysis end. observer == null, position = [%d], mediaItem = [%s]", Integer.valueOf(this.position), this.mOA);
            AppMethodBeat.o(21331);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(21330);
                if (m.this.mOB != null) {
                    m.this.mOB.a(m.this);
                }
                AppMethodBeat.o(21330);
            }
        });
        AppMethodBeat.o(21331);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(21332);
        if ((obj instanceof m) && (this == obj || this.position == ((m) obj).position || (this.path != null && this.path.equals(((m) obj).path)))) {
            AppMethodBeat.o(21332);
            return true;
        }
        AppMethodBeat.o(21332);
        return false;
    }
}
