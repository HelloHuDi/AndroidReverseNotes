package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.api.a;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class c extends a {
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
    private a oxf;
    private byte[] oxj = null;
    private byte[] oxk = null;
    private a.a oxl;
    private g oxn;
    private int videoFps;

    public c(String str, String str2, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(76698);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || i <= 0 || i2 <= 0) {
            ab.e("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4));
            AppMethodBeat.o(76698);
            return;
        }
        this.filePath = str;
        this.eYj = str2;
        this.eYk = i;
        this.eYl = i2;
        this.eYm = i3;
        this.eYp = i4;
        this.eXL = SightVideoJNI.getMp4Rotate(str);
        com.tencent.mm.plugin.sight.base.a WR = d.WR(str);
        if (WR != null) {
            this.eXJ = WR.width;
            this.eXK = WR.height;
            this.eWK = WR.eWK;
            this.videoFps = WR.eTk;
        }
        this.eXM = 0;
        this.eXN = (long) this.eWK;
        ab.i("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegX264Remuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s", str, str2, Integer.valueOf(this.eXJ), Integer.valueOf(this.eXK), Integer.valueOf(this.eXL), Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(76698);
    }

    public c(String str, String str2, int i, int i2, int i3, int i4, long j, long j2) {
        AppMethodBeat.i(76699);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || i <= 0 || i2 <= 0) {
            ab.e("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4));
            AppMethodBeat.o(76699);
            return;
        }
        this.filePath = str;
        this.eYj = str2;
        this.eYk = i;
        this.eYl = i2;
        this.eYm = i3;
        this.eYp = i4;
        this.eXL = SightVideoJNI.getMp4Rotate(str);
        com.tencent.mm.plugin.sight.base.a WR = d.WR(str);
        if (WR != null) {
            this.eXJ = WR.width;
            this.eXK = WR.height;
            this.videoFps = WR.eTk;
        }
        this.eXM = j;
        this.eXN = j2;
        ab.i("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegX264Remuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s, startTimeMs: %s, endTimeMs: %s", str, str2, Integer.valueOf(this.eXJ), Integer.valueOf(this.eXK), Integer.valueOf(this.eXL), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2));
        AppMethodBeat.o(76699);
    }

    public final void r(Bitmap bitmap) {
        if (bitmap != null) {
            this.eXi = bitmap;
        }
    }

    public final int Va() {
        AppMethodBeat.i(76700);
        int round = Math.round(((float) this.eWK) / 1000.0f);
        if (this.eXM >= 0 && this.eXN >= 0) {
            round = Math.round(((float) (this.eXN - this.eXM)) / 1000.0f) + 1;
        }
        this.eTa = MP4MuxerJNI.initDataBufLock(round);
        if (e.uD(this.filePath)) {
            ab.i("MicroMsg.MMSightFFMpegX264Remuxer", "ish265, create mediacodec decoder");
            this.oxf = new e();
        } else {
            this.oxf = new d();
        }
        if (this.eWK > 0) {
            round = this.oxf.e(this.filePath, 0, (long) this.eWK, this.videoFps);
        } else if (this.eXM < 0 || this.eXN < 0) {
            ab.e("MicroMsg.MMSightFFMpegX264Remuxer", "remux time error, videoDuration: %s, remuxStartTime: %s, remuxEndTime: %s", Integer.valueOf(this.eWK), Long.valueOf(this.eXM), Long.valueOf(this.eXN));
            MP4MuxerJNI.releaseDataBufLock(this.eTa);
            AppMethodBeat.o(76700);
            return -1;
        } else {
            round = this.oxf.e(this.filePath, this.eXM, this.eXN, this.videoFps);
        }
        ab.i("MicroMsg.MMSightFFMpegX264Remuxer", "decoder init ret: %s", Integer.valueOf(round));
        if (round < 0) {
            MP4MuxerJNI.releaseDataBufLock(this.eTa);
            AppMethodBeat.o(76700);
            return -1;
        }
        if (this.eYp > 0 && this.eYp < this.videoFps) {
            this.oxf.mp((int) Math.ceil((double) (((float) this.videoFps) / ((float) this.eYp))));
        }
        int min = this.eYp > 0 ? Math.min(this.eYp, this.videoFps) : this.videoFps;
        this.oxf.a(new h() {
            public final void a(byte[] bArr, boolean z, long j) {
                int rowBytes;
                AppMethodBeat.i(76697);
                if (c.this.fYS == null) {
                    c.this.fYS = c.this.oxf.alJ();
                }
                if (c.this.oxl != null) {
                    Bitmap bPh = c.this.oxl.bPh();
                    if (bPh != null) {
                        rowBytes = bPh.getRowBytes() * bPh.getHeight();
                        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(rowBytes);
                        allocateDirect.position(0);
                        bPh.copyPixelsToBuffer(allocateDirect);
                        allocateDirect.position(0);
                        if (c.this.oxk == null) {
                            c.this.oxk = new byte[rowBytes];
                        }
                        allocateDirect.get(c.this.oxk);
                        SightVideoJNI.blendYuvFrame(bArr, c.this.oxk, c.this.fYS.x, c.this.fYS.y);
                    }
                }
                if (c.this.eXi != null) {
                    if (c.this.oxk == null) {
                        if (c.this.eXL == 90 || c.this.eXL == 270) {
                            c.this.eXi = com.tencent.mm.sdk.platformtools.d.b(c.this.eXi, (float) (360 - c.this.eXL));
                        } else if (c.this.eXL == 180) {
                            c.this.eXi = com.tencent.mm.sdk.platformtools.d.b(c.this.eXi, 180.0f);
                        }
                        c.this.eXi = Bitmap.createScaledBitmap(c.this.eXi, c.this.fYS.x, c.this.fYS.y, true);
                        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(c.this.eXi.getRowBytes() * c.this.eXi.getHeight());
                        allocateDirect2.position(0);
                        c.this.eXi.copyPixelsToBuffer(allocateDirect2);
                        allocateDirect2.position(0);
                        c.this.oxk = new byte[allocateDirect2.remaining()];
                        allocateDirect2.get(c.this.oxk);
                    }
                    SightVideoJNI.blendYuvFrame(bArr, c.this.oxk, c.this.fYS.x, c.this.fYS.y);
                }
                if (c.this.oxn != null) {
                    g g = c.this.oxn;
                    rowBytes = c.this.fYS.x;
                    int i = c.this.fYS.y;
                    int alK = c.this.oxf.alK();
                    if (bArr != null) {
                        boolean z2;
                        if (rowBytes == g.eTi && i == g.eTj) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        ab.d("MicroMsg.MMSightRemuxX264Encoder", "writeData, needScale: %s, srcSize: [%s, %s], targetSize: [%s, %s], pts: %s", Boolean.valueOf(z2), Integer.valueOf(rowBytes), Integer.valueOf(i), Integer.valueOf(g.eTi), Integer.valueOf(g.eTj), Long.valueOf(j));
                        MP4MuxerJNI.writeYuvDataForSegmentLock(bArr, rowBytes, i, g.eTi, g.eTj, alK, g.gLw, g.gLx);
                        g.frameCount++;
                    }
                }
                j.owk.g(bArr);
                if (z && c.this.oxn != null) {
                    g g2 = c.this.oxn;
                    if (g2.oxv != null) {
                        g2.oxv.fYU = true;
                    }
                }
                AppMethodBeat.o(76697);
            }
        });
        this.oxn = new g(this.eXJ, this.eXK, this.eYk, this.eYl, this.eYm, min, b.qwY);
        g gVar = this.oxn;
        gVar.frameCount = 0;
        MP4MuxerJNI.initH264EncoderLock(gVar.eTi, gVar.eTj, (float) gVar.eTk, gVar.bitrate, gVar.fzV, 8, gVar.fzU, 23.0f);
        gVar.oxv = new a(gVar, (byte) 0);
        gVar.eVR = com.tencent.mm.sdk.g.d.h(gVar.oxv, "MediaCodecFFMpegTranscoder_Encoder");
        gVar.eVR.start();
        gVar.cFy = false;
        ab.i("MicroMsg.MMSightRemuxX264Encoder", "initAndStartEncoder");
        this.oxf.bPZ();
        g gVar2 = this.oxn;
        if (!(gVar2.oxv == null || gVar2.eVR == null)) {
            gVar2.oxv.fYU = true;
            try {
                gVar2.eVR.join();
                com.tencent.mm.sdk.g.d.xDG.remove(gVar2.oxv);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MMSightRemuxX264Encoder", e, "waitEncoderFinish, join error: %s", e.getMessage());
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
                if (i >= 0 && trackFormat != null && !bo.isNullOrNil(r2)) {
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
                        ab.d("MicroMsg.MMSightFFMpegX264Remuxer", "sampleSize: %d", Integer.valueOf(readSampleData));
                        if (readSampleData <= 0) {
                            ab.i("MicroMsg.MMSightFFMpegX264Remuxer", "muxAudio size = %d. Saw eos.", Integer.valueOf(readSampleData));
                            break;
                        } else if (this.clX.getSampleTime() >= this.eXN * 1000) {
                            break;
                        } else if (this.clX.getSampleTrackIndex() != i) {
                            ab.e("MicroMsg.MMSightFFMpegX264Remuxer", "track index not match! break");
                            break;
                        } else {
                            allocateDirect.position(0);
                            MP4MuxerJNI.writeAACDataLock(this.eTa, allocateDirect, readSampleData);
                            this.clX.advance();
                        }
                    }
                }
            } catch (IOException e2) {
                ab.printErrStackTrace("MicroMsg.MMSightFFMpegX264Remuxer", e2, "muxAudio create extractor failed: %s", e2.getMessage());
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
            ab.i("MicroMsg.MMSightFFMpegX264Remuxer", "muxing ret: %s", Integer.valueOf(MP4MuxerJNI.muxingForX264Lock(this.eTt, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, this.aOn, str2, (((float) this.oxn.frameCount) * 1000.0f) / ((float) j), (int) j, null, 0)));
            if (this.eXL > 0) {
                SightVideoJNI.tagRotateVideo(str2, this.eYj, this.eXL);
                com.tencent.mm.vfs.e.deleteFile(str2);
            }
            MP4MuxerJNI.releaseDataBufLock(this.eTa);
            j.owk.WY();
            AppMethodBeat.o(76700);
            return round;
        } catch (Exception e3) {
            ab.printErrStackTrace("MicroMsg.MMSightFFMpegX264Remuxer", e3, "decode error: %s", e3.getMessage());
            AppMethodBeat.o(76700);
            return -1;
        }
    }

    public final int getType() {
        return 3;
    }
}
