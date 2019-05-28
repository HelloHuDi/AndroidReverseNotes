package com.tencent.p177mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@TargetApi(16)
/* renamed from: com.tencent.mm.plugin.mmsight.segment.a */
public abstract class C3491a implements C39400f {
    private String eys;
    private List<C3492a> fYm = new ArrayList();
    private List<C3492a> fYn = new ArrayList();
    String fYo;
    String fYp;
    VideoTransPara fYq;
    long fYr;
    long fYs;
    int fYt = -1;
    private boolean isInited = false;
    private MediaExtractor mMediaExtractor;
    int mRotationDegree = -1;

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.a$a */
    class C3492a {
        int index;
        MediaFormat mediaFormat;

        C3492a(MediaFormat mediaFormat, int i) {
            this.mediaFormat = mediaFormat;
            this.index = i;
        }
    }

    /* renamed from: uG */
    public abstract int mo7958uG(String str);

    /* renamed from: b */
    public void mo7956b(String str, String str2, VideoTransPara videoTransPara) {
        C4990ab.m7410d("BaseMediaCodecClipper", "init() called with: src = [" + str + "], dst = [" + str2 + "], para = [" + videoTransPara + "]");
        long yz = C5046bo.m7588yz();
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || videoTransPara == null) {
            throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument's null or nil. src = %s; dst = %s; param = %s", new Object[]{str, str2, videoTransPara}));
        }
        C5728b c5728b = new C5728b(str);
        C5728b c5728b2 = new C5728b(str2);
        if (!c5728b.canRead() || c5728b.length() == 0) {
            throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument src video file can not be read or empty %s", new Object[]{str}));
        }
        this.fYo = str;
        this.fYp = str2;
        this.fYq = videoTransPara;
        this.mMediaExtractor = new MediaExtractor();
        this.mMediaExtractor.setDataSource(str);
        m5794a(this.mMediaExtractor);
        if (this.fYm == null || this.fYm.size() == 0) {
            throw new C43314p("Can not find video or audio track in this video file.");
        }
        this.fYt = alM();
        this.mRotationDegree = mo7958uG(str);
        this.isInited = true;
        C4990ab.m7413e("BaseMediaCodecClipper", "init cost time %dms", Long.valueOf(C5046bo.m7525az(yz)));
    }

    /* renamed from: a */
    private void m5794a(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
            if (trackFormat.containsKey("mime") && !C5046bo.isNullOrNil(trackFormat.getString("mime"))) {
                String string = trackFormat.getString("mime");
                C4990ab.m7417i("BaseMediaCodecClipper", "mime: %s", string);
                if (string.startsWith("audio/")) {
                    this.fYn.add(new C3492a(trackFormat, i));
                } else if (string.startsWith("video/")) {
                    this.fYm.add(new C3492a(trackFormat, i));
                }
            }
        }
        C4990ab.m7417i("BaseMediaCodecClipper", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", Integer.valueOf(this.fYn.size()), Integer.valueOf(this.fYm.size()));
    }

    /* renamed from: O */
    public int mo7953O(long j, long j2) {
        if (this.isInited) {
            if (j < 0) {
                j = 0;
            }
            this.fYr = j;
            MediaFormat mediaFormat = ((C3492a) this.fYm.get(0)).mediaFormat;
            if (mediaFormat.containsKey("durationUs")) {
                if (j2 <= 0 || j2 > mediaFormat.getLong("durationUs") / 1000) {
                    j2 = mediaFormat.getLong("durationUs") / 1000;
                }
                this.fYs = j2;
                return mo7954a(this.mMediaExtractor, this.fYn, this.fYm);
            }
            throw new C43314p("Can not find duration.");
        }
        C4990ab.m7412e("BaseMediaCodecClipper", "checkTimeParameter has not been initialized.");
        throw new IllegalStateException("Please init this component first.");
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public int mo7954a(MediaExtractor mediaExtractor, List<C3492a> list, List<C3492a> list2) {
        return 0;
    }

    /* Access modifiers changed, original: protected|final */
    public final String alN() {
        if (this.eys == null) {
            this.eys = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_clip_temp.mp4";
        }
        return this.eys;
    }

    public final void release() {
        this.isInited = false;
        if (this.mMediaExtractor != null) {
            this.mMediaExtractor.release();
        }
    }

    private int alM() {
        Iterator it;
        int i;
        C3492a c3492a;
        int i2 = -1;
        if (!(this.fYn == null || this.fYn.size() == 0)) {
            it = this.fYn.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                c3492a = (C3492a) it.next();
                if (c3492a.mediaFormat.containsKey("max-input-size")) {
                    i2 = Math.max(c3492a.mediaFormat.getInteger("max-input-size"), i);
                } else {
                    i2 = i;
                }
            }
            i2 = i;
        }
        if (this.fYm == null || this.fYm.size() == 0) {
            return i2;
        }
        it = this.fYm.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                return i;
            }
            c3492a = (C3492a) it.next();
            if (c3492a.mediaFormat.containsKey("max-input-size")) {
                i2 = Math.max(c3492a.mediaFormat.getInteger("max-input-size"), i);
            } else {
                i2 = i;
            }
        }
    }
}
