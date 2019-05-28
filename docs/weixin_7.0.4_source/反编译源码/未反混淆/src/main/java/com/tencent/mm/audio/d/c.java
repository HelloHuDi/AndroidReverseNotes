package com.tencent.mm.audio.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.MediaRecorder;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.ugc.TXRecordCommon;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public final class c implements a {
    private static com.tencent.mm.audio.d.a.a crz = new com.tencent.mm.audio.d.a.a();
    public BlockingQueue<com.tencent.mm.audio.b.g.a> crn = new ArrayBlockingQueue(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    public boolean cro = false;
    private String crp;
    private int crq = 0;
    private byte[] crr = null;
    private int crs = TXRecordCommon.AUDIO_SAMPLERATE_16000;
    private Object crt = new Object();
    public a cru = null;
    private boolean crv = false;
    private OutputStream crw;
    private int crx;
    private boolean cry = false;
    private int mSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_16000;

    public final class a implements Runnable {
        private a() {
        }

        public /* synthetic */ a(c cVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(55765);
            ab.i("MicroMsg.SilkWriter", "Silk Thread start run");
            while (true) {
                boolean a;
                synchronized (c.this) {
                    try {
                        a = c.this.cro;
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(55765);
                    }
                }
                ab.d("MicroMsg.SilkWriter", "ThreadSilk in :" + a + " cnt :" + c.this.crn.size());
                if (a && c.this.crn.isEmpty()) {
                    break;
                }
                try {
                    com.tencent.mm.audio.b.g.a aVar = (com.tencent.mm.audio.b.g.a) c.this.crn.poll(200, TimeUnit.MILLISECONDS);
                    if (aVar == null) {
                        ab.i("MicroMsg.SilkWriter", "poll byte null file:" + c.this.crp);
                    } else {
                        int size = c.this.crn.size();
                        if (size > 10 || a) {
                            ab.w("MicroMsg.SilkWriter", "speed up silkcodec queue:" + size + " stop:" + a);
                            size = false;
                        } else if (size < 9) {
                            size = 1;
                        } else {
                            size = 1;
                        }
                        if (c.crz.count >= 10 && c.crz.crk > 240) {
                            size = 0;
                        }
                        c.this.a(aVar, size, false);
                    }
                } catch (InterruptedException e) {
                    ab.i("MicroMsg.SilkWriter", "ThreadAmr poll null");
                }
            }
        }
    }

    public c(int i, int i2) {
        AppMethodBeat.i(55766);
        this.mSampleRate = i;
        this.crs = i2;
        AppMethodBeat.o(55766);
    }

    public final boolean eo(String str) {
        AppMethodBeat.i(55767);
        ab.i("MicroMsg.SilkWriter", "initWriter path: ".concat(String.valueOf(str)));
        if (str == null) {
            ab.e("MicroMsg.SilkWriter", "path is null");
            AppMethodBeat.o(55767);
            return false;
        }
        OutputStream outputStream = null;
        try {
            outputStream = e.L(str, false);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SilkWriter", e, "initWriter openWrite failed: %s", e.getMessage());
            h.pYm.k(357, 55, 1);
            if (d.vxr) {
                HashMap hashMap = new HashMap();
                hashMap.put(SharePluginInfo.ISSUE_KEY_STACK, e.getMessage());
                h.pYm.g("Record", "Write failed", hashMap);
            }
        }
        if (outputStream != null) {
            try {
                this.crp = str;
                this.crw = outputStream;
                this.crv = false;
                int Lw = m.Lw();
                if ((Lw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                    this.crx = 4;
                } else if ((Lw & 512) != 0) {
                    this.crx = 2;
                } else {
                    ab.e("TAG", "initWriter cpuType error! silk don't support arm_v5!!!!");
                    AppMethodBeat.o(55767);
                    return false;
                }
                if (MediaRecorder.SilkEncInit(this.mSampleRate, this.crs, this.crx) != 0) {
                    ab.e("MicroMsg.SilkWriter", "initWriter SilkEncoderInit Error:%d", Integer.valueOf(MediaRecorder.SilkEncInit(this.mSampleRate, this.crs, this.crx)));
                    AppMethodBeat.o(55767);
                    return false;
                }
                this.crr = new byte[(((this.mSampleRate * 20) * 2) / 1000)];
                Lw = -1;
                com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100279");
                if (ll.isValid()) {
                    Lw = bo.getInt((String) ll.dru().get("isVoiceMsgOptOpen"), 0);
                }
                if (1 == Lw) {
                    this.cry = true;
                }
                if (Lw == 0) {
                    this.cry = false;
                }
                if (this.cry) {
                    MediaRecorder.SetVoiceSilkControl(200, 1);
                    ab.i("MicroMsg.SilkWriter", "Voice Message Compression Optimization is Open !");
                } else {
                    MediaRecorder.SetVoiceSilkControl(200, 0);
                    ab.i("MicroMsg.SilkWriter", "Voice Message Compression Optimization is Close !");
                }
                AppMethodBeat.o(55767);
                return true;
            } catch (Exception e2) {
                ab.e("MicroMsg.SilkWriter", "initWriter FileOutputStream error:%s", e2.getMessage());
                AppMethodBeat.o(55767);
                return false;
            }
        }
        AppMethodBeat.o(55767);
        return false;
    }

    public final void Fe() {
        AppMethodBeat.i(55768);
        ab.i("MicroMsg.SilkWriter", "waitStop");
        synchronized (this) {
            try {
                this.cro = true;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(55768);
                }
            }
        }
        if (this.cru != null) {
            try {
                com.tencent.mm.sdk.g.d.xDG.an(this.cru);
            } catch (InterruptedException e) {
                ab.e("MicroMsg.SilkWriter", "exception:%s", bo.l(e));
            } catch (ExecutionException e2) {
                ab.e("MicroMsg.SilkWriter", "exception:%s", bo.l(e2));
            }
        }
        Fh();
        AppMethodBeat.o(55768);
    }

    private void Fh() {
        AppMethodBeat.i(55769);
        synchronized (this.crt) {
            try {
                MediaRecorder.SilkEncUnInit();
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(55769);
                }
            }
        }
        ab.i("MicroMsg.SilkWriter", "finish Thread file:" + this.crp);
        if (this.crw != null) {
            try {
                this.crw.close();
            } catch (Exception e) {
                ab.e("MicroMsg.SilkWriter", "close silk file:" + this.crp + "msg:" + e.getMessage());
            }
            this.crw = null;
        }
        AppMethodBeat.o(55769);
    }

    public final boolean Ff() {
        AppMethodBeat.i(55770);
        ab.i("MicroMsg.SilkWriter", "resetWriter");
        synchronized (this.crt) {
            try {
                MediaRecorder.SilkEncUnInit();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(55770);
            }
        }
        if (MediaRecorder.SilkEncInit(this.mSampleRate, this.crs, this.crx) != 0) {
            ab.e("MicroMsg.SilkWriter", "resetWriter SilkEncoderInit Error:%d", Integer.valueOf(MediaRecorder.SilkEncInit(this.mSampleRate, this.crs, this.crx)));
            return false;
        }
        AppMethodBeat.o(55770);
        return true;
    }

    public final int a(com.tencent.mm.audio.b.g.a aVar) {
        AppMethodBeat.i(55771);
        int a = a(aVar, 0, false);
        AppMethodBeat.o(55771);
        return a;
    }

    public final int a(com.tencent.mm.audio.b.g.a aVar, int i, boolean z) {
        AppMethodBeat.i(55772);
        com.tencent.mm.compatible.util.g.a aVar2 = new com.tencent.mm.compatible.util.g.a();
        short s = (short) (((this.mSampleRate * 20) * 2) / 1000);
        short s2 = this.crq + aVar.cqs;
        int i2 = 0;
        byte[] bArr = new byte[s];
        byte[] bArr2 = new byte[((this.cry ? 6 : 1) * s)];
        String value = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("VoiceNoiseSuppression");
        boolean z2 = !bo.isNullOrNil(value) ? bo.getInt(value, 1) == 1 : true;
        if (z) {
            z2 = false;
        }
        ab.d("MicroMsg.SilkWriter", "noise suppression: %b", Boolean.valueOf(z2));
        int i3 = 0;
        while (s2 >= s) {
            int i4;
            if (this.crq > 0) {
                try {
                    System.arraycopy(this.crr, 0, bArr, 0, this.crq);
                    byte[] bArr3 = aVar.buf;
                    i4 = this.crq;
                    System.arraycopy(bArr3, 0, bArr, i4, s - i4);
                    i2 += s - this.crq;
                    this.crq = 0;
                } catch (Exception e) {
                    ab.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, leftBufSize:%d copySize:%d error:%s", Integer.valueOf(this.crq), Integer.valueOf(s - this.crq), e.getMessage());
                    AppMethodBeat.o(55772);
                    return -1;
                }
            }
            try {
                System.arraycopy(aVar.buf, i2, bArr, 0, s);
                i2 += s;
            } catch (Exception e2) {
                ab.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, offset:%d framelen:%d error:%s", Integer.valueOf(i2), Short.valueOf(s), e2.getMessage());
                AppMethodBeat.o(55772);
                return -1;
            }
            short s3 = s2 - s;
            short[] sArr = new short[1];
            synchronized (this.crt) {
                try {
                    if (this.cry) {
                        if (s3 >= s || !aVar.cqt) {
                            MediaRecorder.SetVoiceSilkControl(201, 0);
                        } else {
                            MediaRecorder.SetVoiceSilkControl(201, 1);
                            ab.i("MicroMsg.SilkWriter", "silk do encode mark last frame");
                        }
                    }
                    i4 = MediaRecorder.SilkDoEnc(bArr, s, bArr2, sArr, z2);
                } catch (Throwable th) {
                    AppMethodBeat.o(55772);
                }
            }
            Object obj = null;
            if (z && sArr[0] >= (short) 10 && bArr2[0] == (byte) 2 && bArr2[1] == (byte) 35 && bArr2[2] == (byte) 33 && bArr2[3] == (byte) 83 && bArr2[4] == (byte) 73 && bArr2[5] == (byte) 76 && bArr2[6] == (byte) 75 && bArr2[7] == (byte) 95 && bArr2[8] == (byte) 86 && bArr2[9] == (byte) 51) {
                ab.i("MicroMsg.SilkWriter", "writeSilkFile deleteHead & bDeleteHead true");
                obj = 1;
            }
            if (i4 != 0) {
                this.crq = 0;
                ab.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode failed, ret:%d", Integer.valueOf(i4));
                if (!this.crv) {
                    h.pYm.k(357, 56, 1);
                    this.crv = true;
                    if (d.vxr) {
                        h.pYm.g("Record", "Encode failed", null);
                    }
                }
                AppMethodBeat.o(55772);
                return -1;
            }
            ab.v("MicroMsg.SilkWriter", "encoutdatalen: %s, framelen: %s, lastframe: %s, byteBuf.len: %s", Short.valueOf(sArr[0]), Short.valueOf(s), Boolean.valueOf(aVar.cqt), Integer.valueOf(aVar.cqs));
            try {
                if (sArr[0] < bArr2.length && sArr[0] > (short) 0 && this.crw != null) {
                    if (!z || obj == null) {
                        this.crw.write(bArr2, 0, sArr[0]);
                        i3 += sArr[0];
                    } else {
                        ab.i("MicroMsg.SilkWriter", "writeSilkFile bDeleteHead copyOfRange");
                        this.crw.write(Arrays.copyOfRange(bArr2, 1, bArr2.length), 0, sArr[0] - 1);
                        i3 += sArr[0] - 1;
                        s2 = s3;
                    }
                }
                s2 = s3;
            } catch (IOException e3) {
                ab.e("MicroMsg.SilkWriter", "writeSilkFile Write File Error file:%s", this.crp);
                AppMethodBeat.o(55772);
                return -1;
            }
        }
        try {
            this.crw.flush();
            try {
                System.arraycopy(aVar.buf, i2, this.crr, this.crq, s2);
                this.crq += s2;
                long Mr = aVar2.Mr();
                if (i == 1) {
                    com.tencent.mm.audio.d.a.a aVar3 = crz;
                    aVar3.crk = ((aVar3.crk * ((long) aVar3.count)) + Mr) / ((long) (aVar3.count + 1));
                    aVar3.count++;
                }
                ab.d("MicroMsg.SilkWriter", "writeSilkFile append2silkfile silkTime:" + Mr + " useFloat:" + i + " avg:" + crz.crk + " cnt:" + crz.count);
                AppMethodBeat.o(55772);
                return i3;
            } catch (Exception e22) {
                ab.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, offset:%d leftBufSize:%d leftSize:%d error:%s", Integer.valueOf(i2), Integer.valueOf(this.crq), Integer.valueOf(s2), e22.getMessage());
                AppMethodBeat.o(55772);
                return -1;
            }
        } catch (IOException e4) {
            ab.e("MicroMsg.SilkWriter", "writeSilkFile flush File Error file:%s", this.crp);
            AppMethodBeat.o(55772);
            return -1;
        }
    }

    static {
        AppMethodBeat.i(55773);
        AppMethodBeat.o(55773);
    }
}
