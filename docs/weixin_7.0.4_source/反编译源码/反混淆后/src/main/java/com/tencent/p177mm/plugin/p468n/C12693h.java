package com.tencent.p177mm.plugin.p468n;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Pair;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.plugin.p878a.C26533g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.plugin.n.h */
public abstract class C12693h {
    private static long orR = 0;
    private ByteBuffer[] aQJ;
    private BufferInfo beh = new BufferInfo();
    private int bew;
    private int bex;
    long bfi;
    protected long bfp;
    protected long bgY;
    MediaExtractor clX;
    private String clY;
    protected MediaCodec eTq;
    /* renamed from: fd */
    protected FileDescriptor f2915fd;
    private ByteBuffer[] inputBuffers;
    private volatile Object lock = new Object();
    protected C3546g orH;
    protected C7306ak orI;
    private boolean orJ = false;
    C43332b orK = null;
    protected long orL = 0;
    MediaFormat orM;
    int orN;
    private C12692f orO;
    private boolean orP = false;
    private boolean orQ = false;
    protected String path;
    protected int state;

    /* renamed from: a */
    public abstract boolean mo24680a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, BufferInfo bufferInfo);

    /* renamed from: b */
    public abstract boolean mo24683b(MediaCodec mediaCodec);

    public abstract String type();

    public C12693h(C3546g c3546g, C7306ak c7306ak) {
        this.orH = c3546g;
        this.orI = c7306ak;
        this.state = 0;
        this.bew = -1;
        this.bex = -1;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    /* renamed from: a */
    public final void mo24679a(FileDescriptor fileDescriptor, long j, long j2) {
        this.f2915fd = fileDescriptor;
        this.bfp = j;
        this.bgY = j2;
    }

    private void bOX() {
        if (this.orK != null) {
            this.orL = this.orK.bOR() * 1000;
        }
    }

    public final void bOY() {
        C4990ab.m7417i("MicroMsg.TrackDataSource", "%s flush codec", aZm());
        this.bex = -1;
        this.bew = -1;
        try {
            if (this.eTq != null) {
                this.eTq.flush();
            }
        } catch (Exception e) {
        }
    }

    public void release() {
        C4990ab.m7417i("MicroMsg.TrackDataSource", "%s release", aZm());
        if (this.clX != null) {
            this.clX.release();
            this.clX = null;
        }
        if (this.eTq != null) {
            this.eTq.release();
            this.eTq = null;
        }
        if (this.orO != null) {
            C12692f c12692f = this.orO;
            if (c12692f.ort != null) {
                try {
                    c12692f.ort.close();
                } catch (IOException e) {
                }
            }
            c12692f.gkn.clear();
            c12692f.gkn = null;
            c12692f.gko.clear();
            c12692f.gko = null;
            c12692f.oru = null;
        }
        C4990ab.m7417i("MicroMsg.TrackDataSource", "%s finish release", aZm());
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: sI */
    public final void mo24692sI() {
        if (this.eTq != null) {
            C4990ab.m7417i("MicroMsg.TrackDataSource", "%s release decoder", aZm());
            bOY();
            this.aQJ = null;
            this.inputBuffers = null;
            long yz = C5046bo.m7588yz();
            synchronized (this.lock) {
                C4990ab.m7417i("MicroMsg.TrackDataSource", "%s wait lock cost[%d]", aZm(), Long.valueOf(C5046bo.m7525az(yz)));
                try {
                    this.eTq.stop();
                    this.eTq.release();
                    this.eTq = null;
                } catch (Exception e) {
                    this.eTq.release();
                    this.eTq = null;
                } catch (Throwable th) {
                    this.eTq = null;
                }
            }
            C4990ab.m7417i("MicroMsg.TrackDataSource", "%s finish release decoder [%d]", aZm(), Long.valueOf(C5046bo.m7525az(yz)));
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bOZ() {
        try {
            C4990ab.m7417i("MicroMsg.TrackDataSource", "%s start to prepare decoder mime[%s]", aZm(), this.clY);
            this.eTq = MediaCodec.createDecoderByType(this.clY);
            mo24683b(this.eTq);
            this.eTq.start();
            this.inputBuffers = this.eTq.getInputBuffers();
            this.aQJ = this.eTq.getOutputBuffers();
            return true;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.TrackDataSource", e, "%s prepare decoder init decoder error ", aZm());
            this.orH.mo8070RI(type());
            return false;
        }
    }

    public final void start() {
        C4990ab.m7417i("MicroMsg.TrackDataSource", "%s start to play", aZm());
        setState(3);
        onStart();
    }

    public final void pause() {
        C4990ab.m7417i("MicroMsg.TrackDataSource", "%s start to pause", aZm());
        setState(4);
        onPause();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x007c A:{Catch:{ Exception -> 0x00ef }} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x008f A:{Catch:{ Exception -> 0x00ef }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: yH */
    public final long mo24697yH(int i) {
        C4990ab.m7417i("MicroMsg.TrackDataSource", "%s start to seek to ms[%d] isFeedEnd[%b]", aZm(), Integer.valueOf(i), Boolean.valueOf(this.orJ));
        bOY();
        this.orJ = false;
        if (this.orO != null) {
            try {
                C12692f c12692f = this.orO;
                long j = (long) (i * 1000);
                int i2 = 0;
                while (i2 < c12692f.gko.size()) {
                    Pair pair = (Pair) c12692f.gko.get(i2);
                    if (j < ((Long) pair.second).longValue()) {
                        break;
                    } else if (j == ((Long) pair.second).longValue()) {
                        c12692f.orv = ((Integer) pair.first).intValue();
                        c12692f.oru = (C26533g) c12692f.gkn.get(c12692f.orv);
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 0 || i2 == c12692f.gko.size() - 1) {
                    c12692f.orv = ((Integer) ((Pair) c12692f.gko.get(i2)).first).intValue();
                    c12692f.oru = (C26533g) c12692f.gkn.get(c12692f.orv);
                    if (this.orO.oru.gkq < 0) {
                        mo24677N(((long) i) * 1000, -1);
                    }
                    if (this.orO.oru.gkq < 0) {
                        mo24677N(0, -1);
                        this.orH.bOW();
                    }
                    C4990ab.m7417i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d]", aZm(), Long.valueOf(this.orO.oru.gkq));
                    return this.orO.oru.gkq / 1000;
                }
                c12692f.orv = ((Integer) ((Pair) c12692f.gko.get(i2 - 1)).first).intValue();
                c12692f.oru = (C26533g) c12692f.gkn.get(c12692f.orv);
                if (this.orO.oru.gkq < 0) {
                }
                if (this.orO.oru.gkq < 0) {
                }
                C4990ab.m7417i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d]", aZm(), Long.valueOf(this.orO.oru.gkq));
                return this.orO.oru.gkq / 1000;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.TrackDataSource", e, "%s extractor seek exception %s", aZm(), e.toString());
                return 0;
            }
        }
        try {
            this.clX.seekTo((long) (i * 1000), 0);
            if (this.clX.getSampleTime() < 0) {
                mo24677N(((long) i) * 1000, -1);
            }
            if (this.clX.getSampleTime() < 0) {
                mo24677N(0, -1);
                this.orH.bOW();
            }
            C4990ab.m7417i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d, %d]", aZm(), Long.valueOf(this.clX.getSampleTime()), Long.valueOf(this.clX.getCachedDuration()));
            return this.clX.getSampleTime() / 1000;
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.TrackDataSource", e2, "%s extractor seek exception %s", aZm(), e2.toString());
            return 0;
        }
    }

    public final boolean prepare() {
        C4990ab.m7417i("MicroMsg.TrackDataSource", "%s start to prepare path %s", aZm(), this.path);
        long yz = C5046bo.m7588yz();
        try {
            C4990ab.m7417i("MicroMsg.TrackDataSource", "%s start to init extractor", aZm());
            this.clX = new MediaExtractor();
            if (!C5046bo.isNullOrNil(this.path)) {
                RandomAccessFile ck = C5730e.m8626ck(this.path, false);
                this.f2915fd = ck.getFD();
                if (C1427q.ete.euc == 1) {
                    this.clX.setDataSource(this.f2915fd, 0, C5730e.asZ(this.path));
                } else {
                    this.clX.setDataSource(this.f2915fd);
                }
                ck.close();
            } else if (this.f2915fd != null && this.f2915fd.valid()) {
                this.clX.setDataSource(this.f2915fd, this.bfp, this.bgY);
            }
            int trackCount = this.clX.getTrackCount();
            this.orN = -1;
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = this.clX.getTrackFormat(i);
                String string = trackFormat.getString("mime");
                if (string != null && string.contains(type())) {
                    mo24682b(trackFormat, string, i);
                    break;
                }
            }
            if (this.orN < 0) {
                C4990ab.m7421w("MicroMsg.TrackDataSource", "%s prepare track but can not find track index.[%d, %d]", aZm(), Integer.valueOf(trackCount), Integer.valueOf(this.orN));
                this.orH.mo8069RH("can not find ");
                return false;
            }
            this.clX.selectTrack(this.orN);
            if (!C5046bo.isNullOrNil(this.path)) {
                this.orO = null;
            }
            long yz2 = C5046bo.m7588yz();
            try {
                long j;
                C4990ab.m7417i("MicroMsg.TrackDataSource", "%s start to init decoder mime[%s] state[%d]", aZm(), this.clY, Integer.valueOf(this.state));
                if (C46107d.m86022yD(this.state)) {
                    j = 0;
                } else {
                    synchronized (this.lock) {
                        this.eTq = MediaCodec.createDecoderByType(this.clY);
                        mo24683b(this.eTq);
                        this.eTq.start();
                        this.inputBuffers = this.eTq.getInputBuffers();
                        this.aQJ = this.eTq.getOutputBuffers();
                    }
                    j = C5046bo.m7588yz();
                }
                setState(1);
                C4990ab.m7417i("MicroMsg.TrackDataSource", "%s finish to prepare cost[%d %d %d]", aZm(), Long.valueOf(C5046bo.m7525az(yz)), Long.valueOf(yz2 - yz), Long.valueOf(j - yz));
                return true;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.TrackDataSource", "%s prepare init decoder error %s", aZm(), e.toString());
                this.orH.mo8070RI(type());
                return false;
            }
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.TrackDataSource", e2, "%s prepare init extractor error", aZm());
            this.orH.mo8069RH(e2.toString());
            return false;
        } catch (Throwable th) {
            C4990ab.m7413e("MicroMsg.TrackDataSource", "%s prepare init extractor error %s", aZm(), th.toString());
            this.orH.mo8069RH(th.toString());
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: M */
    public final int mo24676M(long j, long j2) {
        C3546g c3546g;
        String type;
        C4990ab.m7411d("MicroMsg.TrackDataSource", "%s start to do some work time[%d %d] state %d", aZm(), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(this.state));
        if (this.eTq != null) {
            do {
                try {
                    if (m20703h(j, j2)) {
                    }
                } catch (Exception e) {
                    if (this.orP) {
                        C4990ab.m7413e("MicroMsg.TrackDataSource", "%s do some work drain output buffer error %s", aZm(), e.toString());
                    } else {
                        this.orP = true;
                        C4990ab.printErrStackTrace("MicroMsg.TrackDataSource", e, "%s do some work drain output buffer error", aZm());
                    }
                    if (!C46107d.m86022yD(this.state)) {
                        bOY();
                    }
                    c3546g = this.orH;
                    type = type();
                    if (!c3546g.orG && c3546g.orD) {
                        C7060h.pYm.mo8378a(354, 158, 1, false);
                        C7060h.pYm.mo8381e(13836, Integer.valueOf(506), Long.valueOf(C5046bo.anT()), type);
                        c3546g.orG = true;
                    }
                }
                break;
            } while (!C46107d.m86022yD(this.state));
            try {
                m20704rG();
            } catch (Exception e2) {
                if (this.orQ) {
                    C4990ab.m7413e("MicroMsg.TrackDataSource", "%s do some work feed input buffer error %s", aZm(), e2.toString());
                } else {
                    this.orQ = true;
                    C4990ab.printErrStackTrace("MicroMsg.TrackDataSource", e2, "%s do some work feed input buffer error", aZm());
                }
                if (!C46107d.m86022yD(this.state)) {
                    bOY();
                }
                c3546g = this.orH;
                type = type();
                if (!c3546g.orF && c3546g.orD) {
                    C7060h.pYm.mo8378a(354, 157, 1, false);
                    C7060h.pYm.mo8381e(13836, Integer.valueOf(505), Long.valueOf(C5046bo.anT()), type);
                    c3546g.orF = true;
                }
            }
        }
        C4990ab.m7411d("MicroMsg.TrackDataSource", "%s finish to do some work. state %d", aZm(), Integer.valueOf(this.state));
        return this.state;
    }

    /* renamed from: h */
    private boolean m20703h(long j, long j2) {
        Object obj;
        C4990ab.m7411d("MicroMsg.TrackDataSource", "%s drain output buffer time[%d %d] index %d", aZm(), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(this.bex));
        if (this.bex < 0) {
            synchronized (this.lock) {
                this.bex = this.eTq.dequeueOutputBuffer(this.beh, orR);
            }
            if (this.bex >= 0) {
                if ((this.beh.flags & 4) != 0) {
                    C4990ab.m7417i("MicroMsg.TrackDataSource", "%s process end of stream", aZm());
                    setState(9);
                    this.bex = -1;
                    return false;
                }
                ByteBuffer byteBuffer = this.aQJ[this.bex];
                if (byteBuffer != null) {
                    byteBuffer.position(this.beh.offset);
                    byteBuffer.limit(this.beh.offset + this.beh.size);
                }
            } else if (this.bex == -2) {
                this.orM = this.eTq.getOutputFormat();
                mo24686c(this.eTq);
                return true;
            } else if (this.bex == -3) {
                this.aQJ = this.eTq.getOutputBuffers();
                return true;
            } else {
                C4990ab.m7411d("MicroMsg.TrackDataSource", "%s drain output buffer error outputIndex[%d]", aZm(), Integer.valueOf(this.bex));
                return false;
            }
        }
        if (this.state == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            setState(2);
        }
        C4990ab.m7411d("MicroMsg.TrackDataSource", "%s process output buffer index %d ", aZm(), Integer.valueOf(this.bex));
        synchronized (this.lock) {
            if (mo24680a(j, j2, this.eTq, this.aQJ[this.bex], this.bex, this.beh)) {
                this.bex = -1;
                return true;
            }
            return false;
        }
    }

    /* renamed from: rG */
    private boolean m20704rG() {
        C4990ab.m7411d("MicroMsg.TrackDataSource", "%s start to feed input buffer index %d [%d, %b]", aZm(), Integer.valueOf(this.bew), Integer.valueOf(this.state), Boolean.valueOf(this.orJ));
        if (C46107d.m86022yD(this.state) || this.orJ) {
            C4990ab.m7417i("MicroMsg.TrackDataSource", "%s feed input buffer is end.", aZm());
            return false;
        }
        if (this.bew < 0) {
            this.bew = this.eTq.dequeueInputBuffer(0);
            if (this.bew < 0) {
                C4990ab.m7411d("MicroMsg.TrackDataSource", "%s can not dequeue effect input buffer", aZm());
                return false;
            }
        }
        ByteBuffer byteBuffer = this.inputBuffers[this.bew];
        int J;
        long j;
        int i;
        if (this.orO != null) {
            J = this.orO.mo24675J(byteBuffer);
            j = this.orO.oru.gkq;
            i = this.orO.oru.gkr;
            C4990ab.m7411d("MicroMsg.TrackDataSource", "%s read data index[%d, %d] sample info[%d, %d]", aZm(), Integer.valueOf(this.bew), Integer.valueOf(J), Long.valueOf(j), Integer.valueOf(i));
            if (J <= 0) {
                this.eTq.queueInputBuffer(this.bew, 0, 0, 0, 4);
                this.orJ = true;
                return false;
            }
            this.eTq.queueInputBuffer(this.bew, 0, J, j, 0);
            this.bew = -1;
            C12692f c12692f = this.orO;
            c12692f.orv++;
            if (c12692f.orv < c12692f.orw) {
                c12692f.oru = (C26533g) c12692f.gkn.get(c12692f.orv);
                C4990ab.m7411d("MicroMsg.Mp4Extractor", "curr sample [%s]", c12692f.oru);
            }
            return false;
        } else if (this.orH.orE) {
            this.eTq.queueInputBuffer(this.bew, 0, 0, this.bfi * 1000, 4);
            this.orJ = true;
            this.orH.orE = false;
            return false;
        } else {
            J = 0;
            j = 0;
            i = 0;
            try {
                J = this.clX.readSampleData(byteBuffer, 0);
                j = this.clX.getSampleTime();
                i = this.clX.getSampleFlags();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.TrackDataSource", e, "MediaExtractor get sample data error: %s", e.getMessage());
            }
            C4990ab.m7411d("MicroMsg.TrackDataSource", "%s read data index[%d, %d] sample info[%d, %d]", aZm(), Integer.valueOf(this.bew), Integer.valueOf(J), Long.valueOf(j), Integer.valueOf(i));
            mo24678R(i, j);
            if (J <= 0) {
                this.eTq.queueInputBuffer(this.bew, 0, 0, this.bfi * 1000, 4);
                this.orJ = true;
                return false;
            }
            this.eTq.queueInputBuffer(this.bew, 0, J, j, 0);
            this.bew = -1;
            this.clX.advance();
            long sampleTime = this.clX.getSampleTime();
            if (this.orH.llJ) {
                if (this.orL == 0) {
                    if (mo24677N(j, sampleTime)) {
                        C4990ab.m7421w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", aZm(), Long.valueOf(sampleTime), Long.valueOf(this.orL));
                        if (Math.abs(this.clX.getSampleTime() - j) >= 3000000) {
                            C4990ab.m7421w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", aZm(), Long.valueOf(this.clX.getSampleTime()), Long.valueOf(j));
                            this.orI.obtainMessage(5, -2, -2).sendToTarget();
                        }
                        bOX();
                    }
                } else if (sampleTime < 0 || (sampleTime / 1000) + 1200 > this.orL) {
                    C4990ab.m7421w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", aZm(), Long.valueOf(sampleTime), Long.valueOf(this.orL));
                    if (mo24677N(j, -1)) {
                        this.orI.obtainMessage(5, -3, -3).sendToTarget();
                    }
                    bOX();
                }
            } else if (mo24677N(j, sampleTime)) {
                C4990ab.m7421w("MicroMsg.TrackDataSource", "%s feed input buffer isOnlineVideo[%b] next[%d] onlineCacheMs[%d]", aZm(), Boolean.valueOf(this.orH.llJ), Long.valueOf(sampleTime), Long.valueOf(this.orL));
                if (Math.abs(this.clX.getSampleTime() - j) >= 1000000) {
                    C4990ab.m7421w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", aZm(), Long.valueOf(this.clX.getSampleTime()), Long.valueOf(j));
                    this.orH.orE = true;
                }
            }
            C4990ab.m7411d("MicroMsg.TrackDataSource", "%s finish to feed input buffer [%d, %d]", aZm(), Long.valueOf(j), Long.valueOf(sampleTime));
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: N */
    public final boolean mo24677N(long j, long j2) {
        long yz = C5046bo.m7588yz();
        try {
            if ((j / 1000) + 1000 < this.bfi && j2 == -1) {
                this.orH.llI = true;
                this.orJ = false;
                this.clX.release();
                this.clX = new MediaExtractor();
                if (!C5046bo.isNullOrNil(this.path)) {
                    RandomAccessFile ck = C5730e.m8626ck(this.path, false);
                    FileDescriptor fd = ck.getFD();
                    if (C1427q.ete.euc == 1) {
                        this.clX.setDataSource(fd, 0, C5730e.asZ(this.path));
                    } else {
                        this.clX.setDataSource(fd);
                    }
                    ck.close();
                } else if (this.f2915fd != null && this.f2915fd.valid()) {
                    this.clX.setDataSource(this.f2915fd, this.bfp, this.bgY);
                }
                this.clX.selectTrack(this.orN);
                this.clX.seekTo(j, 2);
                long sampleTime = this.clX.getSampleTime();
                C4990ab.m7421w("MicroMsg.TrackDataSource", "%s it don't play end. currTime[%d] afterSeek[%d] nextSampleTime[%d] onlineCacheMs[%d] cost[%d]", aZm(), Long.valueOf(j), Long.valueOf(sampleTime), Long.valueOf(j2), Long.valueOf(this.orL), Long.valueOf(C5046bo.m7525az(yz)));
                return true;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.TrackDataSource", "%s reset extractor error %s", aZm(), e.toString());
        }
        return false;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: R */
    public boolean mo24678R(int i, long j) {
        return false;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public void mo24682b(MediaFormat mediaFormat, String str, int i) {
        C4990ab.m7417i("MicroMsg.TrackDataSource", "%s found media format mime[%s] track[%d]", aZm(), str, Integer.valueOf(i));
        this.orN = i;
        this.clY = str;
        this.bfi = mediaFormat.getLong("durationUs") / 1000;
        this.orM = mediaFormat;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: c */
    public void mo24686c(MediaCodec mediaCodec) {
    }

    /* Access modifiers changed, original: protected */
    public void onStart() {
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void setState(int i) {
        C4990ab.m7417i("MicroMsg.TrackDataSource", "%s set state old %d new %d", aZm(), Integer.valueOf(this.state), Integer.valueOf(i));
        this.state = i;
    }

    public final String aZm() {
        return type() + "_" + this.orH.aZm();
    }
}
