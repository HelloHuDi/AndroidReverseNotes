package com.tencent.p177mm.plugin.mmsight.model.p995b;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p838bj.C17987e;
import com.tencent.p177mm.plugin.mmsight.api.C46074a;
import com.tencent.p177mm.plugin.mmsight.api.C46074a.C43299a;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43305j;
import com.tencent.p177mm.plugin.mmsight.model.p995b.C28507f.C28506a;
import com.tencent.p177mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.plugin.mmsight.model.b.b */
public final class C39381b extends C46074a {
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
    private C28507f oxg;
    private HandlerThread oxh;
    private C28502a oxi;
    private byte[] oxj = null;
    private byte[] oxk = null;
    private C43299a oxl;
    private int videoFps;

    /* renamed from: com.tencent.mm.plugin.mmsight.model.b.b$a */
    class C28502a extends C7306ak {
        public C28502a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(76693);
            if (message.what == 1) {
                byte[] bArr = (byte[]) message.obj;
                Object obj = message.arg1 == 1 ? 1 : null;
                long j = (long) message.arg2;
                if (C39381b.this.oxg != null) {
                    if (C39381b.this.fYS == null) {
                        C39381b.this.fYS = C39381b.this.oxf.alJ();
                    }
                    if (C39381b.this.oxl != null) {
                        Bitmap bPh = C39381b.this.oxl.bPh();
                        if (bPh != null) {
                            int rowBytes = bPh.getRowBytes() * bPh.getHeight();
                            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(rowBytes);
                            allocateDirect.position(0);
                            bPh.copyPixelsToBuffer(allocateDirect);
                            allocateDirect.position(0);
                            if (C39381b.this.oxk == null) {
                                C39381b.this.oxk = new byte[rowBytes];
                            }
                            allocateDirect.get(C39381b.this.oxk);
                            SightVideoJNI.blendYuvFrame(bArr, C39381b.this.oxk, C39381b.this.fYS.x, C39381b.this.fYS.y);
                        }
                    }
                    if (C39381b.this.eXi != null) {
                        if (C39381b.this.oxk == null) {
                            if (C39381b.this.eXL == 90 || C39381b.this.eXL == 270) {
                                C39381b.this.eXi = C5056d.m7648b(C39381b.this.eXi, (float) (360 - C39381b.this.eXL));
                            } else if (C39381b.this.eXL == 180) {
                                C39381b.this.eXi = C5056d.m7648b(C39381b.this.eXi, 180.0f);
                            }
                            C39381b.this.eXi = Bitmap.createScaledBitmap(C39381b.this.eXi, C39381b.this.fYS.x, C39381b.this.fYS.y, true);
                            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(C39381b.this.eXi.getRowBytes() * C39381b.this.eXi.getHeight());
                            allocateDirect2.position(0);
                            C39381b.this.eXi.copyPixelsToBuffer(allocateDirect2);
                            allocateDirect2.position(0);
                            C39381b.this.oxk = new byte[allocateDirect2.remaining()];
                            allocateDirect2.get(C39381b.this.oxk);
                        }
                        SightVideoJNI.blendYuvFrame(bArr, C39381b.this.oxk, C39381b.this.fYS.x, C39381b.this.fYS.y);
                    }
                    C28507f c = C39381b.this.oxg;
                    int i = C39381b.this.fYS.x;
                    int i2 = C39381b.this.fYS.y;
                    if (obj != null || bArr == null) {
                        c.mo46473b(c.fXZ, true, j);
                    } else {
                        boolean z;
                        if (i == c.eTi && i2 == c.eTj) {
                            z = false;
                        } else {
                            z = true;
                        }
                        C4990ab.m7411d("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData, needScale: %s, srcSize: [%s, %s], targetSize: [%s, %s], pts: %s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(c.eTi), Integer.valueOf(c.eTj), Long.valueOf(j));
                        if (c.fXZ == null) {
                            c.fXZ = new byte[(((c.eTi * c.eTj) * 3) >> 1)];
                        }
                        if (c.eTl != 19 || z) {
                            MP4MuxerJNI.yuv420pTo420XXAndScaleLock(bArr, 2, c.fXZ, c.fYa, i, i2, i, i2, c.eTi, c.eTj);
                        } else {
                            System.arraycopy(bArr, 0, c.fXZ, 0, bArr.length);
                        }
                        c.fXV++;
                        c.mo46473b(c.fXZ, false, j);
                    }
                    C43305j.owk.mo68845g(bArr);
                }
            }
            AppMethodBeat.m2505o(76693);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.b.b$2 */
    class C393802 implements C28506a {
        C393802() {
        }

        /* renamed from: a */
        public final void mo46472a(int i, ByteBuffer byteBuffer, int i2) {
            AppMethodBeat.m2504i(76692);
            MP4MuxerJNI.writeH264DataLock(i, byteBuffer, i2);
            AppMethodBeat.m2505o(76692);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.b.b$1 */
    class C393821 implements C46077h {
        C393821() {
        }

        /* renamed from: a */
        public final void mo46468a(byte[] bArr, boolean z, long j) {
            int i = 1;
            AppMethodBeat.m2504i(76691);
            if (C39381b.this.oxh == null) {
                C39381b.this.oxh = C7305d.m12297ek("remuxer_encode", -2);
                C39381b.this.oxh.start();
                C39381b.this.oxi = new C28502a(C39381b.this.oxh.getLooper());
            }
            if (C39381b.this.oxi != null) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                Object g = bArr != null ? C43305j.owk.mo68846g(Integer.valueOf(bArr.length)) : null;
                if (g != null) {
                    System.arraycopy(bArr, 0, g, 0, g.length);
                }
                obtain.obj = g;
                if (!z) {
                    i = 0;
                }
                obtain.arg1 = i;
                obtain.arg2 = (int) j;
                C39381b.this.oxi.sendMessage(obtain);
            }
            AppMethodBeat.m2505o(76691);
        }
    }

    public C39381b(String str, String str2, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(76694);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || i <= 0 || i2 <= 0) {
            C4990ab.m7413e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4));
            AppMethodBeat.m2505o(76694);
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
        C4990ab.m7417i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s", str, str2, Integer.valueOf(this.eXJ), Integer.valueOf(this.eXK), Integer.valueOf(this.eXL), Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(76694);
    }

    public C39381b(String str, String str2, int i, int i2, int i3, int i4, long j, long j2) {
        AppMethodBeat.m2504i(76695);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2) || i <= 0 || i2 <= 0) {
            C4990ab.m7413e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4));
            AppMethodBeat.m2505o(76695);
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
        C4990ab.m7417i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s, startTimeMs: %s, endTimeMs: %s", str, str2, Integer.valueOf(this.eXJ), Integer.valueOf(this.eXK), Integer.valueOf(this.eXL), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2));
        AppMethodBeat.m2505o(76695);
    }

    /* renamed from: r */
    public final void mo46471r(Bitmap bitmap) {
        if (bitmap != null) {
            this.eXi = bitmap;
        }
    }

    /* renamed from: Va */
    public final int mo46469Va() {
        AppMethodBeat.m2504i(76696);
        int round = Math.round(((float) this.eWK) / 1000.0f);
        if (this.eXM >= 0 && this.eXN >= 0) {
            round = Math.round(((float) (this.eXN - this.eXM)) / 1000.0f) + 1;
        }
        this.eTa = MP4MuxerJNI.initDataBufLock(round);
        if (C17987e.m28307uD(this.filePath)) {
            C4990ab.m7416i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "ish265, create mediacodec decoder");
            this.oxf = new C12559e();
        } else {
            this.oxf = new C28505d();
        }
        if (this.eWK > 0) {
            round = this.oxf.mo24485e(this.filePath, 0, (long) this.eWK, this.videoFps);
        } else if (this.eXM < 0 || this.eXN < 0) {
            C4990ab.m7413e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "remux time error, videoDuration: %s, remuxStartTime: %s, remuxEndTime: %s", Integer.valueOf(this.eWK), Long.valueOf(this.eXM), Long.valueOf(this.eXN));
            MP4MuxerJNI.releaseDataBufLock(this.eTa);
            AppMethodBeat.m2505o(76696);
            return -1;
        } else {
            round = this.oxf.mo24485e(this.filePath, this.eXM, this.eXN, this.videoFps);
        }
        C4990ab.m7417i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "decoder init ret: %s", Integer.valueOf(round));
        if (round < 0) {
            MP4MuxerJNI.releaseDataBufLock(this.eTa);
            AppMethodBeat.m2505o(76696);
            return -1;
        }
        if (this.eYp > 0 && this.eYp < this.videoFps) {
            this.oxf.mo24486mp((int) Math.ceil((double) (((float) this.videoFps) / ((float) this.eYp))));
        }
        this.oxg = new C28507f(this.eXJ, this.eXK, this.eYk, this.eYl, this.eYm, this.eYp > 0 ? Math.min(this.eYp, this.videoFps) : this.videoFps);
        this.oxf.mo24481a(new C393821());
        this.oxg.oxu = new C393802();
        try {
            long j;
            this.oxg.mo46474mq(this.eTa);
            C28507f c28507f = this.oxg;
            C4990ab.m7416i("MicroMsg.MMSightRemuxMediaCodecEncoder", "Start");
            c28507f.cFy = true;
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
                        C4990ab.m7411d("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "sampleSize: %d", Integer.valueOf(readSampleData));
                        if (readSampleData <= 0) {
                            C4990ab.m7417i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "muxAudio size = %d. Saw eos.", Integer.valueOf(readSampleData));
                            break;
                        } else if (this.clX.getSampleTime() >= this.eXN * 1000) {
                            break;
                        } else if (this.clX.getSampleTrackIndex() != i) {
                            C4990ab.m7412e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "track index not match! break");
                            break;
                        } else {
                            allocateDirect.position(0);
                            MP4MuxerJNI.writeAACDataLock(this.eTa, allocateDirect, readSampleData);
                            this.clX.advance();
                        }
                    }
                }
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.MMSightFFMpegMediaCodecRemuxer", e, "muxAudio create extractor failed: %s", e.getMessage());
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
            C4990ab.m7417i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "muxing ret: %s", Integer.valueOf(MP4MuxerJNI.muxingLock(this.eTa, this.eTt, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, this.aOn, str2, (((float) this.oxg.frameCount) * 1000.0f) / ((float) j), null, 0)));
            if (this.eXL > 0) {
                SightVideoJNI.tagRotateVideo(str2, this.eYj, this.eXL);
                C5730e.deleteFile(str2);
            }
            MP4MuxerJNI.releaseDataBufLock(this.eTa);
            C43305j.owk.mo45830WY();
            AppMethodBeat.m2505o(76696);
            return round;
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.MMSightFFMpegMediaCodecRemuxer", e2, "decode error: %s", e2.getMessage());
            AppMethodBeat.m2505o(76696);
            return -1;
        }
    }

    public final int getType() {
        return 1;
    }
}
