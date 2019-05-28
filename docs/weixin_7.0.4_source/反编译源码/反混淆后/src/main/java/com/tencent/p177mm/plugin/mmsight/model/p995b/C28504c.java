package com.tencent.p177mm.plugin.mmsight.model.p995b;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p838bj.C17987e;
import com.tencent.p177mm.plugin.mmsight.api.C46074a;
import com.tencent.p177mm.plugin.mmsight.api.C46074a.C43299a;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43305j;
import com.tencent.p177mm.plugin.mmsight.model.p995b.C12561g.C12562a;
import com.tencent.p177mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C29014b;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.plugin.mmsight.model.b.c */
public final class C28504c extends C46074a {
    private int aOn;
    private MediaExtractor clX;
    private int eTa;
    private int eTt;
    private int eWK = -1;
    private int eXJ;
    private int eXK;
    private int eXL;
    private long eXM = -1;
    private long eXN = -1;
    private Bitmap eXi;
    private String eYj;
    private int eYk;
    private int eYl;
    private int eYm;
    private int eYp = -1;
    private Point fYS = null;
    private String filePath;
    private C46076a oxf;
    private byte[] oxj = null;
    private byte[] oxk = null;
    private C43299a oxl;
    private C12561g oxn;
    private int videoFps;

    /* renamed from: com.tencent.mm.plugin.mmsight.model.b.c$1 */
    class C285031 implements C46077h {
        C285031() {
        }

        /* renamed from: a */
        public final void mo46468a(byte[] bArr, boolean z, long j) {
            int rowBytes;
            AppMethodBeat.m2504i(76697);
            if (C28504c.this.fYS == null) {
                C28504c.this.fYS = C28504c.this.oxf.alJ();
            }
            if (C28504c.this.oxl != null) {
                Bitmap bPh = C28504c.this.oxl.bPh();
                if (bPh != null) {
                    rowBytes = bPh.getRowBytes() * bPh.getHeight();
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(rowBytes);
                    allocateDirect.position(0);
                    bPh.copyPixelsToBuffer(allocateDirect);
                    allocateDirect.position(0);
                    if (C28504c.this.oxk == null) {
                        C28504c.this.oxk = new byte[rowBytes];
                    }
                    allocateDirect.get(C28504c.this.oxk);
                    SightVideoJNI.blendYuvFrame(bArr, C28504c.this.oxk, C28504c.this.fYS.x, C28504c.this.fYS.y);
                }
            }
            if (C28504c.this.eXi != null) {
                if (C28504c.this.oxk == null) {
                    if (C28504c.this.eXL == 90 || C28504c.this.eXL == 270) {
                        C28504c.this.eXi = C5056d.m7648b(C28504c.this.eXi, (float) (360 - C28504c.this.eXL));
                    } else if (C28504c.this.eXL == 180) {
                        C28504c.this.eXi = C5056d.m7648b(C28504c.this.eXi, 180.0f);
                    }
                    C28504c.this.eXi = Bitmap.createScaledBitmap(C28504c.this.eXi, C28504c.this.fYS.x, C28504c.this.fYS.y, true);
                    ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(C28504c.this.eXi.getRowBytes() * C28504c.this.eXi.getHeight());
                    allocateDirect2.position(0);
                    C28504c.this.eXi.copyPixelsToBuffer(allocateDirect2);
                    allocateDirect2.position(0);
                    C28504c.this.oxk = new byte[allocateDirect2.remaining()];
                    allocateDirect2.get(C28504c.this.oxk);
                }
                SightVideoJNI.blendYuvFrame(bArr, C28504c.this.oxk, C28504c.this.fYS.x, C28504c.this.fYS.y);
            }
            if (C28504c.this.oxn != null) {
                C12561g g = C28504c.this.oxn;
                rowBytes = C28504c.this.fYS.x;
                int i = C28504c.this.fYS.y;
                int alK = C28504c.this.oxf.alK();
                if (bArr != null) {
                    boolean z2;
                    if (rowBytes == g.eTi && i == g.eTj) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    C4990ab.m7411d("MicroMsg.MMSightRemuxX264Encoder", "writeData, needScale: %s, srcSize: [%s, %s], targetSize: [%s, %s], pts: %s", Boolean.valueOf(z2), Integer.valueOf(rowBytes), Integer.valueOf(i), Integer.valueOf(g.eTi), Integer.valueOf(g.eTj), Long.valueOf(j));
                    MP4MuxerJNI.writeYuvDataForSegmentLock(bArr, rowBytes, i, g.eTi, g.eTj, alK, g.gLw, g.gLx);
                    g.frameCount++;
                }
            }
            C43305j.owk.mo68845g(bArr);
            if (z && C28504c.this.oxn != null) {
                C12561g g2 = C28504c.this.oxn;
                if (g2.oxv != null) {
                    g2.oxv.fYU = true;
                }
            }
            AppMethodBeat.m2505o(76697);
        }
    }

    public C28504c(String str, String str2, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(76698);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || i <= 0 || i2 <= 0) {
            C4990ab.m7413e("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4));
            AppMethodBeat.m2505o(76698);
            return;
        }
        this.filePath = str;
        this.eYj = str2;
        this.eYk = i;
        this.eYl = i2;
        this.eYm = i3;
        this.eYp = i4;
        this.eXL = SightVideoJNI.getMp4Rotate(str);
        C43528a WR = C21846d.m33388WR(str);
        if (WR != null) {
            this.eXJ = WR.width;
            this.eXK = WR.height;
            this.eWK = WR.eWK;
            this.videoFps = WR.eTk;
        }
        this.eXM = 0;
        this.eXN = (long) this.eWK;
        C4990ab.m7417i("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegX264Remuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s", str, str2, Integer.valueOf(this.eXJ), Integer.valueOf(this.eXK), Integer.valueOf(this.eXL), Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(76698);
    }

    public C28504c(String str, String str2, int i, int i2, int i3, int i4, long j, long j2) {
        AppMethodBeat.m2504i(76699);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || i <= 0 || i2 <= 0) {
            C4990ab.m7413e("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4));
            AppMethodBeat.m2505o(76699);
            return;
        }
        this.filePath = str;
        this.eYj = str2;
        this.eYk = i;
        this.eYl = i2;
        this.eYm = i3;
        this.eYp = i4;
        this.eXL = SightVideoJNI.getMp4Rotate(str);
        C43528a WR = C21846d.m33388WR(str);
        if (WR != null) {
            this.eXJ = WR.width;
            this.eXK = WR.height;
            this.videoFps = WR.eTk;
        }
        this.eXM = j;
        this.eXN = j2;
        C4990ab.m7417i("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegX264Remuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s, startTimeMs: %s, endTimeMs: %s", str, str2, Integer.valueOf(this.eXJ), Integer.valueOf(this.eXK), Integer.valueOf(this.eXL), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2));
        AppMethodBeat.m2505o(76699);
    }

    /* renamed from: r */
    public final void mo46471r(Bitmap bitmap) {
        if (bitmap != null) {
            this.eXi = bitmap;
        }
    }

    /* renamed from: Va */
    public final int mo46469Va() {
        AppMethodBeat.m2504i(76700);
        int round = Math.round(((float) this.eWK) / 1000.0f);
        if (this.eXM >= 0 && this.eXN >= 0) {
            round = Math.round(((float) (this.eXN - this.eXM)) / 1000.0f) + 1;
        }
        this.eTa = MP4MuxerJNI.initDataBufLock(round);
        if (C17987e.m28307uD(this.filePath)) {
            C4990ab.m7416i("MicroMsg.MMSightFFMpegX264Remuxer", "ish265, create mediacodec decoder");
            this.oxf = new C12559e();
        } else {
            this.oxf = new C28505d();
        }
        if (this.eWK > 0) {
            round = this.oxf.mo24485e(this.filePath, 0, (long) this.eWK, this.videoFps);
        } else if (this.eXM < 0 || this.eXN < 0) {
            C4990ab.m7413e("MicroMsg.MMSightFFMpegX264Remuxer", "remux time error, videoDuration: %s, remuxStartTime: %s, remuxEndTime: %s", Integer.valueOf(this.eWK), Long.valueOf(this.eXM), Long.valueOf(this.eXN));
            MP4MuxerJNI.releaseDataBufLock(this.eTa);
            AppMethodBeat.m2505o(76700);
            return -1;
        } else {
            round = this.oxf.mo24485e(this.filePath, this.eXM, this.eXN, this.videoFps);
        }
        C4990ab.m7417i("MicroMsg.MMSightFFMpegX264Remuxer", "decoder init ret: %s", Integer.valueOf(round));
        if (round < 0) {
            MP4MuxerJNI.releaseDataBufLock(this.eTa);
            AppMethodBeat.m2505o(76700);
            return -1;
        }
        if (this.eYp > 0 && this.eYp < this.videoFps) {
            this.oxf.mo24486mp((int) Math.ceil((double) (((float) this.videoFps) / ((float) this.eYp))));
        }
        int min = this.eYp > 0 ? Math.min(this.eYp, this.videoFps) : this.videoFps;
        this.oxf.mo24481a(new C285031());
        this.oxn = new C12561g(this.eXJ, this.eXK, this.eYk, this.eYl, this.eYm, min, C29014b.qwY);
        C12561g c12561g = this.oxn;
        c12561g.frameCount = 0;
        MP4MuxerJNI.initH264EncoderLock(c12561g.eTi, c12561g.eTj, (float) c12561g.eTk, c12561g.bitrate, c12561g.fzV, 8, c12561g.fzU, 23.0f);
        c12561g.oxv = new C12562a(c12561g, (byte) 0);
        c12561g.eVR = C7305d.m12301h(c12561g.oxv, "MediaCodecFFMpegTranscoder_Encoder");
        c12561g.eVR.start();
        c12561g.cFy = false;
        C4990ab.m7416i("MicroMsg.MMSightRemuxX264Encoder", "initAndStartEncoder");
        this.oxf.bPZ();
        C12561g c12561g2 = this.oxn;
        if (!(c12561g2.oxv == null || c12561g2.eVR == null)) {
            c12561g2.oxv.fYU = true;
            try {
                c12561g2.eVR.join();
                C7305d.xDG.remove(c12561g2.oxv);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MMSightRemuxX264Encoder", e, "waitEncoderFinish, join error: %s", e.getMessage());
            }
        }
        try {
            long j;
            this.clX = new MediaExtractor();
            try {
                MediaFormat trackFormat;
                this.clX.setDataSource(this.filePath);
                String str = null;
                int i = 0;
                while (i < this.clX.getTrackCount()) {
                    trackFormat = this.clX.getTrackFormat(i);
                    str = trackFormat.getString("mime");
                    if (str.startsWith("audio/")) {
                        break;
                    }
                    i++;
                }
                trackFormat = null;
                i = -1;
                if (i >= 0 && trackFormat != null && !C5046bo.isNullOrNil(r2)) {
                    this.aOn = trackFormat.getInteger("channel-count");
                    this.eTt = trackFormat.getInteger("sample-rate");
                    this.clX.selectTrack(i);
                    if (this.eXM > 0) {
                        this.clX.seekTo(this.eXM * 1000, 0);
                    }
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(trackFormat.getInteger("max-input-size"));
                    while (true) {
                        allocateDirect.clear();
                        int readSampleData = this.clX.readSampleData(allocateDirect, 0);
                        C4990ab.m7411d("MicroMsg.MMSightFFMpegX264Remuxer", "sampleSize: %d", Integer.valueOf(readSampleData));
                        if (readSampleData <= 0) {
                            C4990ab.m7417i("MicroMsg.MMSightFFMpegX264Remuxer", "muxAudio size = %d. Saw eos.", Integer.valueOf(readSampleData));
                            break;
                        } else if (this.clX.getSampleTime() >= this.eXN * 1000) {
                            break;
                        } else if (this.clX.getSampleTrackIndex() != i) {
                            C4990ab.m7412e("MicroMsg.MMSightFFMpegX264Remuxer", "track index not match! break");
                            break;
                        } else {
                            allocateDirect.position(0);
                            MP4MuxerJNI.writeAACDataLock(this.eTa, allocateDirect, readSampleData);
                            this.clX.advance();
                        }
                    }
                }
            } catch (IOException e2) {
                C4990ab.printErrStackTrace("MicroMsg.MMSightFFMpegX264Remuxer", e2, "muxAudio create extractor failed: %s", e2.getMessage());
            }
            String str2 = this.eYj;
            if (this.eXL > 0) {
                str2 = str2 + "tempRotate.mp4";
            }
            long j2 = (long) this.eWK;
            if (j2 <= 0) {
                j = this.eXN - this.eXM;
            } else {
                j = j2;
            }
            C4990ab.m7417i("MicroMsg.MMSightFFMpegX264Remuxer", "muxing ret: %s", Integer.valueOf(MP4MuxerJNI.muxingForX264Lock(this.eTt, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, this.aOn, str2, (((float) this.oxn.frameCount) * 1000.0f) / ((float) j), (int) j, null, 0)));
            if (this.eXL > 0) {
                SightVideoJNI.tagRotateVideo(str2, this.eYj, this.eXL);
                C5730e.deleteFile(str2);
            }
            MP4MuxerJNI.releaseDataBufLock(this.eTa);
            C43305j.owk.mo45830WY();
            AppMethodBeat.m2505o(76700);
            return round;
        } catch (Exception e3) {
            C4990ab.printErrStackTrace("MicroMsg.MMSightFFMpegX264Remuxer", e3, "decode error: %s", e3.getMessage());
            AppMethodBeat.m2505o(76700);
            return -1;
        }
    }

    public final int getType() {
        return 3;
    }
}
