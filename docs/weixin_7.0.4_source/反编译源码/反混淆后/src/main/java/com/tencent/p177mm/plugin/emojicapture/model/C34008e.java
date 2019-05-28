package com.tencent.p177mm.plugin.emojicapture.model;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C31820v;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureUtil;", "", "()V", "TAG", "", "checkVideoValid", "", "videoPath", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.model.e */
public final class C34008e {
    private static final String TAG = TAG;
    public static final C34008e lhA = new C34008e();

    static {
        AppMethodBeat.m2504i(2616);
        AppMethodBeat.m2505o(2616);
    }

    private C34008e() {
    }

    /* renamed from: Kb */
    public static boolean m55709Kb(String str) {
        AppMethodBeat.m2504i(2615);
        C25052j.m39376p(str, "videoPath");
        if (C5730e.asZ(str) <= 0) {
            AppMethodBeat.m2505o(2615);
            return false;
        }
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(str);
            if (mediaExtractor.getTrackCount() <= 0) {
                try {
                    mediaExtractor.release();
                } catch (Exception e) {
                    C4990ab.printErrStackTrace(TAG, e, "checkVideoValid, release extractor error", new Object[0]);
                }
                AppMethodBeat.m2505o(2615);
                return false;
            }
            int trackCount = mediaExtractor.getTrackCount();
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                if (trackFormat != null && trackFormat.containsKey("mime")) {
                    String string = trackFormat.getString("mime");
                    if (string != null && C31820v.m51540d((CharSequence) string, (CharSequence) "video")) {
                        try {
                            mediaExtractor.release();
                        } catch (Exception e2) {
                            C4990ab.printErrStackTrace(TAG, e2, "checkVideoValid, release extractor error", new Object[0]);
                        }
                        AppMethodBeat.m2505o(2615);
                        return true;
                    }
                }
            }
            try {
                mediaExtractor.release();
            } catch (Exception e22) {
                C4990ab.printErrStackTrace(TAG, e22, "checkVideoValid, release extractor error", new Object[0]);
            }
            AppMethodBeat.m2505o(2615);
            return false;
        } catch (Exception e222) {
            C4990ab.printErrStackTrace(TAG, e222, "checkVideoValid error", new Object[0]);
            try {
                mediaExtractor.release();
            } catch (Exception e2222) {
                C4990ab.printErrStackTrace(TAG, e2222, "checkVideoValid, release extractor error", new Object[0]);
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            try {
                mediaExtractor.release();
            } catch (Exception e22222) {
                C4990ab.printErrStackTrace(TAG, e22222, "checkVideoValid, release extractor error", new Object[0]);
            }
            AppMethodBeat.m2505o(2615);
        }
    }
}
