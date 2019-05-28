package com.tencent.mm.plugin.emojicapture.model;

import a.f.b.j;
import a.k.v;
import a.l;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureUtil;", "", "()V", "TAG", "", "checkVideoValid", "", "videoPath", "plugin-emojicapture_release"})
public final class e {
    private static final String TAG = TAG;
    public static final e lhA = new e();

    static {
        AppMethodBeat.i(2616);
        AppMethodBeat.o(2616);
    }

    private e() {
    }

    public static boolean Kb(String str) {
        AppMethodBeat.i(2615);
        j.p(str, "videoPath");
        if (com.tencent.mm.vfs.e.asZ(str) <= 0) {
            AppMethodBeat.o(2615);
            return false;
        }
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(str);
            if (mediaExtractor.getTrackCount() <= 0) {
                try {
                    mediaExtractor.release();
                } catch (Exception e) {
                    ab.printErrStackTrace(TAG, e, "checkVideoValid, release extractor error", new Object[0]);
                }
                AppMethodBeat.o(2615);
                return false;
            }
            int trackCount = mediaExtractor.getTrackCount();
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                if (trackFormat != null && trackFormat.containsKey("mime")) {
                    String string = trackFormat.getString("mime");
                    if (string != null && v.d((CharSequence) string, (CharSequence) "video")) {
                        try {
                            mediaExtractor.release();
                        } catch (Exception e2) {
                            ab.printErrStackTrace(TAG, e2, "checkVideoValid, release extractor error", new Object[0]);
                        }
                        AppMethodBeat.o(2615);
                        return true;
                    }
                }
            }
            try {
                mediaExtractor.release();
            } catch (Exception e22) {
                ab.printErrStackTrace(TAG, e22, "checkVideoValid, release extractor error", new Object[0]);
            }
            AppMethodBeat.o(2615);
            return false;
        } catch (Exception e222) {
            ab.printErrStackTrace(TAG, e222, "checkVideoValid error", new Object[0]);
            try {
                mediaExtractor.release();
            } catch (Exception e2222) {
                ab.printErrStackTrace(TAG, e2222, "checkVideoValid, release extractor error", new Object[0]);
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            try {
                mediaExtractor.release();
            } catch (Exception e22222) {
                ab.printErrStackTrace(TAG, e22222, "checkVideoValid, release extractor error", new Object[0]);
            }
            AppMethodBeat.o(2615);
        }
    }
}
