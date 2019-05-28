package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class b extends com.tencent.mm.plugin.mmsight.api.a {
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
    private f oxg;
    private HandlerThread oxh;
    private a oxi;
    private byte[] oxj = null;
    private byte[] oxk = null;
    private com.tencent.mm.plugin.mmsight.api.a.a oxl;
    private int videoFps;

    class a extends ak {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(76693);
            if (message.what == 1) {
                byte[] bArr = (byte[]) message.obj;
                Object obj = message.arg1 == 1 ? 1 : null;
                long j = (long) message.arg2;
                if (b.this.oxg != null) {
                    if (b.this.fYS == null) {
                        b.this.fYS = b.this.oxf.alJ();
                    }
                    if (b.this.oxl != null) {
                        Bitmap bPh = b.this.oxl.bPh();
                        if (bPh != null) {
                            int rowBytes = bPh.getRowBytes() * bPh.getHeight();
                            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(rowBytes);
                            allocateDirect.position(0);
                            bPh.copyPixelsToBuffer(allocateDirect);
                            allocateDirect.position(0);
                            if (b.this.oxk == null) {
                                b.this.oxk = new byte[rowBytes];
                            }
                            allocateDirect.get(b.this.oxk);
                            SightVideoJNI.blendYuvFrame(bArr, b.this.oxk, b.this.fYS.x, b.this.fYS.y);
                        }
                    }
                    if (b.this.eXi != null) {
                        if (b.this.oxk == null) {
                            if (b.this.eXL == 90 || b.this.eXL == 270) {
                                b.this.eXi = d.b(b.this.eXi, (float) (360 - b.this.eXL));
                            } else if (b.this.eXL == 180) {
                                b.this.eXi = d.b(b.this.eXi, 180.0f);
                            }
                            b.this.eXi = Bitmap.createScaledBitmap(b.this.eXi, b.this.fYS.x, b.this.fYS.y, true);
                            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(b.this.eXi.getRowBytes() * b.this.eXi.getHeight());
                            allocateDirect2.position(0);
                            b.this.eXi.copyPixelsToBuffer(allocateDirect2);
                            allocateDirect2.position(0);
                            b.this.oxk = new byte[allocateDirect2.remaining()];
                            allocateDirect2.get(b.this.oxk);
                        }
                        SightVideoJNI.blendYuvFrame(bArr, b.this.oxk, b.this.fYS.x, b.this.fYS.y);
                    }
                    f c = b.this.oxg;
                    int i = b.this.fYS.x;
                    int i2 = b.this.fYS.y;
                    if (obj != null || bArr == null) {
                        c.b(c.fXZ, true, j);
                    } else {
                        boolean z;
                        if (i == c.eTi && i2 == c.eTj) {
                            z = false;
                        } else {
                            z = true;
                        }
                        ab.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData, needScale: %s, srcSize: [%s, %s], targetSize: [%s, %s], pts: %s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(c.eTi), Integer.valueOf(c.eTj), Long.valueOf(j));
                        if (c.fXZ == null) {
                            c.fXZ = new byte[(((c.eTi * c.eTj) * 3) >> 1)];
                        }
                        if (c.eTl != 19 || z) {
                            MP4MuxerJNI.yuv420pTo420XXAndScaleLock(bArr, 2, c.fXZ, c.fYa, i, i2, i, i2, c.eTi, c.eTj);
                        } else {
                            System.arraycopy(bArr, 0, c.fXZ, 0, bArr.length);
                        }
                        c.fXV++;
                        c.b(c.fXZ, false, j);
                    }
                    j.owk.g(bArr);
                }
            }
            AppMethodBeat.o(76693);
        }
    }

    public b(String str, String str2, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(76694);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || i <= 0 || i2 <= 0) {
            ab.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4));
            AppMethodBeat.o(76694);
            return;
        }
        this.filePath = str;
        this.eYj = str2;
        this.eYk = i;
        this.eYl = i2;
        this.eYm = i3;
        this.eYp = i4;
        this.eXL = SightVideoJNI.getMp4Rotate(str);
        com.tencent.mm.plugin.sight.base.a WR = com.tencent.mm.plugin.sight.base.d.WR(str);
        if (WR != null) {
            this.eXJ = WR.width;
            this.eXK = WR.height;
            this.eWK = WR.eWK;
            this.videoFps = WR.eTk;
        }
        this.eXM = 0;
        this.eXN = (long) this.eWK;
        ab.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s", str, str2, Integer.valueOf(this.eXJ), Integer.valueOf(this.eXK), Integer.valueOf(this.eXL), Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(76694);
    }

    public b(String str, String str2, int i, int i2, int i3, int i4, long j, long j2) {
        AppMethodBeat.i(76695);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || i <= 0 || i2 <= 0) {
            ab.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4));
            AppMethodBeat.o(76695);
            return;
        }
        this.filePath = str;
        this.eYj = str2;
        this.eYk = i;
        this.eYl = i2;
        this.eYm = i3;
        this.eYp = i4;
        this.eXL = SightVideoJNI.getMp4Rotate(str);
        com.tencent.mm.plugin.sight.base.a WR = com.tencent.mm.plugin.sight.base.d.WR(str);
        if (WR != null) {
            this.eXJ = WR.width;
            this.eXK = WR.height;
            this.videoFps = WR.eTk;
        }
        this.eXM = j;
        this.eXN = j2;
        ab.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s, startTimeMs: %s, endTimeMs: %s", str, str2, Integer.valueOf(this.eXJ), Integer.valueOf(this.eXK), Integer.valueOf(this.eXL), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2));
        AppMethodBeat.o(76695);
    }

    public final void r(Bitmap bitmap) {
        if (bitmap != null) {
            this.eXi = bitmap;
        }
    }

    public final int Va() {
        AppMethodBeat.i(76696);
        int round = Math.round(((float) this.eWK) / 1000.0f);
        if (this.eXM >= 0 && this.eXN >= 0) {
            round = Math.round(((float) (this.eXN - this.eXM)) / 1000.0f) + 1;
        }
        this.eTa = MP4MuxerJNI.initDataBufLock(round);
        if (e.uD(this.filePath)) {
            ab.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "ish265, create mediacodec decoder");
            this.oxf = new e();
        } else {
            this.oxf = new d();
        }
        if (this.eWK > 0) {
            round = this.oxf.e(this.filePath, 0, (long) this.eWK, this.videoFps);
        } else if (this.eXM < 0 || this.eXN < 0) {
            ab.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "remux time error, videoDuration: %s, remuxStartTime: %s, remuxEndTime: %s", Integer.valueOf(this.eWK), Long.valueOf(this.eXM), Long.valueOf(this.eXN));
            MP4MuxerJNI.releaseDataBufLock(this.eTa);
            AppMethodBeat.o(76696);
            return -1;
        } else {
            round = this.oxf.e(this.filePath, this.eXM, this.eXN, this.videoFps);
        }
        ab.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "decoder init ret: %s", Integer.valueOf(round));
        if (round < 0) {
            MP4MuxerJNI.releaseDataBufLock(this.eTa);
            AppMethodBeat.o(76696);
            return -1;
        }
        if (this.eYp > 0 && this.eYp < this.videoFps) {
            this.oxf.mp((int) Math.ceil((double) (((float) this.videoFps) / ((float) this.eYp))));
        }
        this.oxg = new f(this.eXJ, this.eXK, this.eYk, this.eYl, this.eYm, this.eYp > 0 ? Math.min(this.eYp, this.videoFps) : this.videoFps);
        this.oxf.a(new h() {
            public final void a(byte[] bArr, boolean z, long j) {
                int i = 1;
                AppMethodBeat.i(76691);
                if (b.this.oxh == null) {
                    b.this.oxh = com.tencent.mm.sdk.g.d.ek("remuxer_encode", -2);
                    b.this.oxh.start();
                    b.this.oxi = new a(b.this.oxh.getLooper());
                }
                if (b.this.oxi != null) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    Object g = bArr != null ? j.owk.g(Integer.valueOf(bArr.length)) : null;
                    if (g != null) {
                        System.arraycopy(bArr, 0, g, 0, g.length);
                    }
                    obtain.obj = g;
                    if (!z) {
                        i = 0;
                    }
                    obtain.arg1 = i;
                    obtain.arg2 = (int) j;
                    b.this.oxi.sendMessage(obtain);
                }
                AppMethodBeat.o(76691);
            }
        });
        this.oxg.oxu = new com.tencent.mm.plugin.mmsight.model.b.f.a() {
            public final void a(int i, ByteBuffer byteBuffer, int i2) {
                AppMethodBeat.i(76692);
                MP4MuxerJNI.writeH264DataLock(i, byteBuffer, i2);
                AppMethodBeat.o(76692);
            }
        };
        try {
            long j;
            this.oxg.mq(this.eTa);
            f fVar = this.oxg;
            ab.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "Start");
            fVar.cFy = true;
            this.oxf.bPZ();
            this.oxh.quitSafely();
            this.oxh.join();
            this.oxi = null;
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
                        ab.d("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "sampleSize: %d", Integer.valueOf(readSampleData));
                        if (readSampleData <= 0) {
                            ab.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "muxAudio size = %d. Saw eos.", Integer.valueOf(readSampleData));
                            break;
                        } else if (this.clX.getSampleTime() >= this.eXN * 1000) {
                            break;
                        } else if (this.clX.getSampleTrackIndex() != i) {
                            ab.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "track index not match! break");
                            break;
                        } else {
                            allocateDirect.position(0);
                            MP4MuxerJNI.writeAACDataLock(this.eTa, allocateDirect, readSampleData);
                            this.clX.advance();
                        }
                    }
                }
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.MMSightFFMpegMediaCodecRemuxer", e, "muxAudio create extractor failed: %s", e.getMessage());
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
            ab.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "muxing ret: %s", Integer.valueOf(MP4MuxerJNI.muxingLock(this.eTa, this.eTt, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, this.aOn, str2, (((float) this.oxg.frameCount) * 1000.0f) / ((float) j), null, 0)));
            if (this.eXL > 0) {
                SightVideoJNI.tagRotateVideo(str2, this.eYj, this.eXL);
                com.tencent.mm.vfs.e.deleteFile(str2);
            }
            MP4MuxerJNI.releaseDataBufLock(this.eTa);
            j.owk.WY();
            AppMethodBeat.o(76696);
            return round;
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.MMSightFFMpegMediaCodecRemuxer", e2, "decode error: %s", e2.getMessage());
            AppMethodBeat.o(76696);
            return -1;
        }
    }

    public final int getType() {
        return 1;
    }
}
