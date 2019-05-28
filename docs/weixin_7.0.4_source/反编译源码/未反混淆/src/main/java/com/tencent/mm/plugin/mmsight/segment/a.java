package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@TargetApi(16)
public abstract class a implements f {
    private String eys;
    private List<a> fYm = new ArrayList();
    private List<a> fYn = new ArrayList();
    String fYo;
    String fYp;
    VideoTransPara fYq;
    long fYr;
    long fYs;
    int fYt = -1;
    private boolean isInited = false;
    private MediaExtractor mMediaExtractor;
    int mRotationDegree = -1;

    class a {
        int index;
        MediaFormat mediaFormat;

        a(MediaFormat mediaFormat, int i) {
            this.mediaFormat = mediaFormat;
            this.index = i;
        }
    }

    public abstract int uG(String str);

    public void b(String str, String str2, VideoTransPara videoTransPara) {
        ab.d("BaseMediaCodecClipper", "init() called with: src = [" + str + "], dst = [" + str2 + "], para = [" + videoTransPara + "]");
        long yz = bo.yz();
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || videoTransPara == null) {
            throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument's null or nil. src = %s; dst = %s; param = %s", new Object[]{str, str2, videoTransPara}));
        }
        b bVar = new b(str);
        b bVar2 = new b(str2);
        if (!bVar.canRead() || bVar.length() == 0) {
            throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument src video file can not be read or empty %s", new Object[]{str}));
        }
        this.fYo = str;
        this.fYp = str2;
        this.fYq = videoTransPara;
        this.mMediaExtractor = new MediaExtractor();
        this.mMediaExtractor.setDataSource(str);
        a(this.mMediaExtractor);
        if (this.fYm == null || this.fYm.size() == 0) {
            throw new p("Can not find video or audio track in this video file.");
        }
        this.fYt = alM();
        this.mRotationDegree = uG(str);
        this.isInited = true;
        ab.e("BaseMediaCodecClipper", "init cost time %dms", Long.valueOf(bo.az(yz)));
    }

    private void a(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
            if (trackFormat.containsKey("mime") && !bo.isNullOrNil(trackFormat.getString("mime"))) {
                String string = trackFormat.getString("mime");
                ab.i("BaseMediaCodecClipper", "mime: %s", string);
                if (string.startsWith("audio/")) {
                    this.fYn.add(new a(trackFormat, i));
                } else if (string.startsWith("video/")) {
                    this.fYm.add(new a(trackFormat, i));
                }
            }
        }
        ab.i("BaseMediaCodecClipper", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", Integer.valueOf(this.fYn.size()), Integer.valueOf(this.fYm.size()));
    }

    public int O(long j, long j2) {
        if (this.isInited) {
            if (j < 0) {
                j = 0;
            }
            this.fYr = j;
            MediaFormat mediaFormat = ((a) this.fYm.get(0)).mediaFormat;
            if (mediaFormat.containsKey("durationUs")) {
                if (j2 <= 0 || j2 > mediaFormat.getLong("durationUs") / 1000) {
                    j2 = mediaFormat.getLong("durationUs") / 1000;
                }
                this.fYs = j2;
                return a(this.mMediaExtractor, this.fYn, this.fYm);
            }
            throw new p("Can not find duration.");
        }
        ab.e("BaseMediaCodecClipper", "checkTimeParameter has not been initialized.");
        throw new IllegalStateException("Please init this component first.");
    }

    /* Access modifiers changed, original: protected */
    public int a(MediaExtractor mediaExtractor, List<a> list, List<a> list2) {
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
        a aVar;
        int i2 = -1;
        if (!(this.fYn == null || this.fYn.size() == 0)) {
            it = this.fYn.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                aVar = (a) it.next();
                if (aVar.mediaFormat.containsKey("max-input-size")) {
                    i2 = Math.max(aVar.mediaFormat.getInteger("max-input-size"), i);
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
            aVar = (a) it.next();
            if (aVar.mediaFormat.containsKey("max-input-size")) {
                i2 = Math.max(aVar.mediaFormat.getInteger("max-input-size"), i);
            } else {
                i2 = i;
            }
        }
    }
}
