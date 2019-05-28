package com.tencent.mm.plugin.n;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Pair;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public abstract class h {
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
    protected FileDescriptor fd;
    private ByteBuffer[] inputBuffers;
    private volatile Object lock = new Object();
    protected g orH;
    protected ak orI;
    private boolean orJ = false;
    b orK = null;
    protected long orL = 0;
    MediaFormat orM;
    int orN;
    private f orO;
    private boolean orP = false;
    private boolean orQ = false;
    protected String path;
    protected int state;

    public abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, BufferInfo bufferInfo);

    public abstract boolean b(MediaCodec mediaCodec);

    public abstract String type();

    public h(g gVar, ak akVar) {
        this.orH = gVar;
        this.orI = akVar;
        this.state = 0;
        this.bew = -1;
        this.bex = -1;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    public final void a(FileDescriptor fileDescriptor, long j, long j2) {
        this.fd = fileDescriptor;
        this.bfp = j;
        this.bgY = j2;
    }

    private void bOX() {
        if (this.orK != null) {
            this.orL = this.orK.bOR() * 1000;
        }
    }

    public final void bOY() {
        ab.i("MicroMsg.TrackDataSource", "%s flush codec", aZm());
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
        ab.i("MicroMsg.TrackDataSource", "%s release", aZm());
        if (this.clX != null) {
            this.clX.release();
            this.clX = null;
        }
        if (this.eTq != null) {
            this.eTq.release();
            this.eTq = null;
        }
        if (this.orO != null) {
            f fVar = this.orO;
            if (fVar.ort != null) {
                try {
                    fVar.ort.close();
                } catch (IOException e) {
                }
            }
            fVar.gkn.clear();
            fVar.gkn = null;
            fVar.gko.clear();
            fVar.gko = null;
            fVar.oru = null;
        }
        ab.i("MicroMsg.TrackDataSource", "%s finish release", aZm());
    }

    /* Access modifiers changed, original: protected|final */
    public final void sI() {
        if (this.eTq != null) {
            ab.i("MicroMsg.TrackDataSource", "%s release decoder", aZm());
            bOY();
            this.aQJ = null;
            this.inputBuffers = null;
            long yz = bo.yz();
            synchronized (this.lock) {
                ab.i("MicroMsg.TrackDataSource", "%s wait lock cost[%d]", aZm(), Long.valueOf(bo.az(yz)));
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
            ab.i("MicroMsg.TrackDataSource", "%s finish release decoder [%d]", aZm(), Long.valueOf(bo.az(yz)));
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bOZ() {
        try {
            ab.i("MicroMsg.TrackDataSource", "%s start to prepare decoder mime[%s]", aZm(), this.clY);
            this.eTq = MediaCodec.createDecoderByType(this.clY);
            b(this.eTq);
            this.eTq.start();
            this.inputBuffers = this.eTq.getInputBuffers();
            this.aQJ = this.eTq.getOutputBuffers();
            return true;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.TrackDataSource", e, "%s prepare decoder init decoder error ", aZm());
            this.orH.RI(type());
            return false;
        }
    }

    public final void start() {
        ab.i("MicroMsg.TrackDataSource", "%s start to play", aZm());
        setState(3);
        onStart();
    }

    public final void pause() {
        ab.i("MicroMsg.TrackDataSource", "%s start to pause", aZm());
        setState(4);
        onPause();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x007c A:{Catch:{ Exception -> 0x00ef }} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x008f A:{Catch:{ Exception -> 0x00ef }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long yH(int i) {
        ab.i("MicroMsg.TrackDataSource", "%s start to seek to ms[%d] isFeedEnd[%b]", aZm(), Integer.valueOf(i), Boolean.valueOf(this.orJ));
        bOY();
        this.orJ = false;
        if (this.orO != null) {
            try {
                f fVar = this.orO;
                long j = (long) (i * 1000);
                int i2 = 0;
                while (i2 < fVar.gko.size()) {
                    Pair pair = (Pair) fVar.gko.get(i2);
                    if (j < ((Long) pair.second).longValue()) {
                        break;
                    } else if (j == ((Long) pair.second).longValue()) {
                        fVar.orv = ((Integer) pair.first).intValue();
                        fVar.oru = (g) fVar.gkn.get(fVar.orv);
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 0 || i2 == fVar.gko.size() - 1) {
                    fVar.orv = ((Integer) ((Pair) fVar.gko.get(i2)).first).intValue();
                    fVar.oru = (g) fVar.gkn.get(fVar.orv);
                    if (this.orO.oru.gkq < 0) {
                        N(((long) i) * 1000, -1);
                    }
                    if (this.orO.oru.gkq < 0) {
                        N(0, -1);
                        this.orH.bOW();
                    }
                    ab.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d]", aZm(), Long.valueOf(this.orO.oru.gkq));
                    return this.orO.oru.gkq / 1000;
                }
                fVar.orv = ((Integer) ((Pair) fVar.gko.get(i2 - 1)).first).intValue();
                fVar.oru = (g) fVar.gkn.get(fVar.orv);
                if (this.orO.oru.gkq < 0) {
                }
                if (this.orO.oru.gkq < 0) {
                }
                ab.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d]", aZm(), Long.valueOf(this.orO.oru.gkq));
                return this.orO.oru.gkq / 1000;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.TrackDataSource", e, "%s extractor seek exception %s", aZm(), e.toString());
                return 0;
            }
        }
        try {
            this.clX.seekTo((long) (i * 1000), 0);
            if (this.clX.getSampleTime() < 0) {
                N(((long) i) * 1000, -1);
            }
            if (this.clX.getSampleTime() < 0) {
                N(0, -1);
                this.orH.bOW();
            }
            ab.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d, %d]", aZm(), Long.valueOf(this.clX.getSampleTime()), Long.valueOf(this.clX.getCachedDuration()));
            return this.clX.getSampleTime() / 1000;
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.TrackDataSource", e2, "%s extractor seek exception %s", aZm(), e2.toString());
            return 0;
        }
    }

    public final boolean prepare() {
        ab.i("MicroMsg.TrackDataSource", "%s start to prepare path %s", aZm(), this.path);
        long yz = bo.yz();
        try {
            ab.i("MicroMsg.TrackDataSource", "%s start to init extractor", aZm());
            this.clX = new MediaExtractor();
            if (!bo.isNullOrNil(this.path)) {
                RandomAccessFile ck = e.ck(this.path, false);
                this.fd = ck.getFD();
                if (q.ete.euc == 1) {
                    this.clX.setDataSource(this.fd, 0, e.asZ(this.path));
                } else {
                    this.clX.setDataSource(this.fd);
                }
                ck.close();
            } else if (this.fd != null && this.fd.valid()) {
                this.clX.setDataSource(this.fd, this.bfp, this.bgY);
            }
            int trackCount = this.clX.getTrackCount();
            this.orN = -1;
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = this.clX.getTrackFormat(i);
                String string = trackFormat.getString("mime");
                if (string != null && string.contains(type())) {
                    b(trackFormat, string, i);
                    break;
                }
            }
            if (this.orN < 0) {
                ab.w("MicroMsg.TrackDataSource", "%s prepare track but can not find track index.[%d, %d]", aZm(), Integer.valueOf(trackCount), Integer.valueOf(this.orN));
                this.orH.RH("can not find ");
                return false;
            }
            this.clX.selectTrack(this.orN);
            if (!bo.isNullOrNil(this.path)) {
                this.orO = null;
            }
            long yz2 = bo.yz();
            try {
                long j;
                ab.i("MicroMsg.TrackDataSource", "%s start to init decoder mime[%s] state[%d]", aZm(), this.clY, Integer.valueOf(this.state));
                if (d.yD(this.state)) {
                    j = 0;
                } else {
                    synchronized (this.lock) {
                        this.eTq = MediaCodec.createDecoderByType(this.clY);
                        b(this.eTq);
                        this.eTq.start();
                        this.inputBuffers = this.eTq.getInputBuffers();
                        this.aQJ = this.eTq.getOutputBuffers();
                    }
                    j = bo.yz();
                }
                setState(1);
                ab.i("MicroMsg.TrackDataSource", "%s finish to prepare cost[%d %d %d]", aZm(), Long.valueOf(bo.az(yz)), Long.valueOf(yz2 - yz), Long.valueOf(j - yz));
                return true;
            } catch (Exception e) {
                ab.e("MicroMsg.TrackDataSource", "%s prepare init decoder error %s", aZm(), e.toString());
                this.orH.RI(type());
                return false;
            }
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.TrackDataSource", e2, "%s prepare init extractor error", aZm());
            this.orH.RH(e2.toString());
            return false;
        } catch (Throwable th) {
            ab.e("MicroMsg.TrackDataSource", "%s prepare init extractor error %s", aZm(), th.toString());
            this.orH.RH(th.toString());
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final int M(long j, long j2) {
        g gVar;
        String type;
        ab.d("MicroMsg.TrackDataSource", "%s start to do some work time[%d %d] state %d", aZm(), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(this.state));
        if (this.eTq != null) {
            do {
                try {
                    if (h(j, j2)) {
                    }
                } catch (Exception e) {
                    if (this.orP) {
                        ab.e("MicroMsg.TrackDataSource", "%s do some work drain output buffer error %s", aZm(), e.toString());
                    } else {
                        this.orP = true;
                        ab.printErrStackTrace("MicroMsg.TrackDataSource", e, "%s do some work drain output buffer error", aZm());
                    }
                    if (!d.yD(this.state)) {
                        bOY();
                    }
                    gVar = this.orH;
                    type = type();
                    if (!gVar.orG && gVar.orD) {
                        com.tencent.mm.plugin.report.service.h.pYm.a(354, 158, 1, false);
                        com.tencent.mm.plugin.report.service.h.pYm.e(13836, Integer.valueOf(506), Long.valueOf(bo.anT()), type);
                        gVar.orG = true;
                    }
                }
                break;
            } while (!d.yD(this.state));
            try {
                rG();
            } catch (Exception e2) {
                if (this.orQ) {
                    ab.e("MicroMsg.TrackDataSource", "%s do some work feed input buffer error %s", aZm(), e2.toString());
                } else {
                    this.orQ = true;
                    ab.printErrStackTrace("MicroMsg.TrackDataSource", e2, "%s do some work feed input buffer error", aZm());
                }
                if (!d.yD(this.state)) {
                    bOY();
                }
                gVar = this.orH;
                type = type();
                if (!gVar.orF && gVar.orD) {
                    com.tencent.mm.plugin.report.service.h.pYm.a(354, 157, 1, false);
                    com.tencent.mm.plugin.report.service.h.pYm.e(13836, Integer.valueOf(505), Long.valueOf(bo.anT()), type);
                    gVar.orF = true;
                }
            }
        }
        ab.d("MicroMsg.TrackDataSource", "%s finish to do some work. state %d", aZm(), Integer.valueOf(this.state));
        return this.state;
    }

    private boolean h(long j, long j2) {
        Object obj;
        ab.d("MicroMsg.TrackDataSource", "%s drain output buffer time[%d %d] index %d", aZm(), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(this.bex));
        if (this.bex < 0) {
            synchronized (this.lock) {
                this.bex = this.eTq.dequeueOutputBuffer(this.beh, orR);
            }
            if (this.bex >= 0) {
                if ((this.beh.flags & 4) != 0) {
                    ab.i("MicroMsg.TrackDataSource", "%s process end of stream", aZm());
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
                c(this.eTq);
                return true;
            } else if (this.bex == -3) {
                this.aQJ = this.eTq.getOutputBuffers();
                return true;
            } else {
                ab.d("MicroMsg.TrackDataSource", "%s drain output buffer error outputIndex[%d]", aZm(), Integer.valueOf(this.bex));
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
        ab.d("MicroMsg.TrackDataSource", "%s process output buffer index %d ", aZm(), Integer.valueOf(this.bex));
        synchronized (this.lock) {
            if (a(j, j2, this.eTq, this.aQJ[this.bex], this.bex, this.beh)) {
                this.bex = -1;
                return true;
            }
            return false;
        }
    }

    private boolean rG() {
        ab.d("MicroMsg.TrackDataSource", "%s start to feed input buffer index %d [%d, %b]", aZm(), Integer.valueOf(this.bew), Integer.valueOf(this.state), Boolean.valueOf(this.orJ));
        if (d.yD(this.state) || this.orJ) {
            ab.i("MicroMsg.TrackDataSource", "%s feed input buffer is end.", aZm());
            return false;
        }
        if (this.bew < 0) {
            this.bew = this.eTq.dequeueInputBuffer(0);
            if (this.bew < 0) {
                ab.d("MicroMsg.TrackDataSource", "%s can not dequeue effect input buffer", aZm());
                return false;
            }
        }
        ByteBuffer byteBuffer = this.inputBuffers[this.bew];
        int J;
        long j;
        int i;
        if (this.orO != null) {
            J = this.orO.J(byteBuffer);
            j = this.orO.oru.gkq;
            i = this.orO.oru.gkr;
            ab.d("MicroMsg.TrackDataSource", "%s read data index[%d, %d] sample info[%d, %d]", aZm(), Integer.valueOf(this.bew), Integer.valueOf(J), Long.valueOf(j), Integer.valueOf(i));
            if (J <= 0) {
                this.eTq.queueInputBuffer(this.bew, 0, 0, 0, 4);
                this.orJ = true;
                return false;
            }
            this.eTq.queueInputBuffer(this.bew, 0, J, j, 0);
            this.bew = -1;
            f fVar = this.orO;
            fVar.orv++;
            if (fVar.orv < fVar.orw) {
                fVar.oru = (g) fVar.gkn.get(fVar.orv);
                ab.d("MicroMsg.Mp4Extractor", "curr sample [%s]", fVar.oru);
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
                ab.printErrStackTrace("MicroMsg.TrackDataSource", e, "MediaExtractor get sample data error: %s", e.getMessage());
            }
            ab.d("MicroMsg.TrackDataSource", "%s read data index[%d, %d] sample info[%d, %d]", aZm(), Integer.valueOf(this.bew), Integer.valueOf(J), Long.valueOf(j), Integer.valueOf(i));
            R(i, j);
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
                    if (N(j, sampleTime)) {
                        ab.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", aZm(), Long.valueOf(sampleTime), Long.valueOf(this.orL));
                        if (Math.abs(this.clX.getSampleTime() - j) >= 3000000) {
                            ab.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", aZm(), Long.valueOf(this.clX.getSampleTime()), Long.valueOf(j));
                            this.orI.obtainMessage(5, -2, -2).sendToTarget();
                        }
                        bOX();
                    }
                } else if (sampleTime < 0 || (sampleTime / 1000) + 1200 > this.orL) {
                    ab.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", aZm(), Long.valueOf(sampleTime), Long.valueOf(this.orL));
                    if (N(j, -1)) {
                        this.orI.obtainMessage(5, -3, -3).sendToTarget();
                    }
                    bOX();
                }
            } else if (N(j, sampleTime)) {
                ab.w("MicroMsg.TrackDataSource", "%s feed input buffer isOnlineVideo[%b] next[%d] onlineCacheMs[%d]", aZm(), Boolean.valueOf(this.orH.llJ), Long.valueOf(sampleTime), Long.valueOf(this.orL));
                if (Math.abs(this.clX.getSampleTime() - j) >= 1000000) {
                    ab.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", aZm(), Long.valueOf(this.clX.getSampleTime()), Long.valueOf(j));
                    this.orH.orE = true;
                }
            }
            ab.d("MicroMsg.TrackDataSource", "%s finish to feed input buffer [%d, %d]", aZm(), Long.valueOf(j), Long.valueOf(sampleTime));
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean N(long j, long j2) {
        long yz = bo.yz();
        try {
            if ((j / 1000) + 1000 < this.bfi && j2 == -1) {
                this.orH.llI = true;
                this.orJ = false;
                this.clX.release();
                this.clX = new MediaExtractor();
                if (!bo.isNullOrNil(this.path)) {
                    RandomAccessFile ck = e.ck(this.path, false);
                    FileDescriptor fd = ck.getFD();
                    if (q.ete.euc == 1) {
                        this.clX.setDataSource(fd, 0, e.asZ(this.path));
                    } else {
                        this.clX.setDataSource(fd);
                    }
                    ck.close();
                } else if (this.fd != null && this.fd.valid()) {
                    this.clX.setDataSource(this.fd, this.bfp, this.bgY);
                }
                this.clX.selectTrack(this.orN);
                this.clX.seekTo(j, 2);
                long sampleTime = this.clX.getSampleTime();
                ab.w("MicroMsg.TrackDataSource", "%s it don't play end. currTime[%d] afterSeek[%d] nextSampleTime[%d] onlineCacheMs[%d] cost[%d]", aZm(), Long.valueOf(j), Long.valueOf(sampleTime), Long.valueOf(j2), Long.valueOf(this.orL), Long.valueOf(bo.az(yz)));
                return true;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.TrackDataSource", "%s reset extractor error %s", aZm(), e.toString());
        }
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean R(int i, long j) {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void b(MediaFormat mediaFormat, String str, int i) {
        ab.i("MicroMsg.TrackDataSource", "%s found media format mime[%s] track[%d]", aZm(), str, Integer.valueOf(i));
        this.orN = i;
        this.clY = str;
        this.bfi = mediaFormat.getLong("durationUs") / 1000;
        this.orM = mediaFormat;
    }

    /* Access modifiers changed, original: protected */
    public void c(MediaCodec mediaCodec) {
    }

    /* Access modifiers changed, original: protected */
    public void onStart() {
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void setState(int i) {
        ab.i("MicroMsg.TrackDataSource", "%s set state old %d new %d", aZm(), Integer.valueOf(this.state), Integer.valueOf(i));
        this.state = i;
    }

    public final String aZm() {
        return type() + "_" + this.orH.aZm();
    }
}
