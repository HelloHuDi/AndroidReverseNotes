package com.tencent.p177mm.audio.p1180d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p1180d.C25835a.C17952a;
import com.tencent.p177mm.audio.p195b.C32304g.C32305a;
import com.tencent.p177mm.compatible.p221e.C45290m;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelvoice.MediaRecorder;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.vfs.C5730e;
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

/* renamed from: com.tencent.mm.audio.d.c */
public final class C45163c implements C25835a {
    private static C17952a crz = new C17952a();
    public BlockingQueue<C32305a> crn = new ArrayBlockingQueue(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    public boolean cro = false;
    private String crp;
    private int crq = 0;
    private byte[] crr = null;
    private int crs = TXRecordCommon.AUDIO_SAMPLERATE_16000;
    private Object crt = new Object();
    public C41767a cru = null;
    private boolean crv = false;
    private OutputStream crw;
    private int crx;
    private boolean cry = false;
    private int mSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_16000;

    /* renamed from: com.tencent.mm.audio.d.c$a */
    public final class C41767a implements Runnable {
        private C41767a() {
        }

        public /* synthetic */ C41767a(C45163c c45163c, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(55765);
            C4990ab.m7416i("MicroMsg.SilkWriter", "Silk Thread start run");
            while (true) {
                boolean a;
                synchronized (C45163c.this) {
                    try {
                        a = C45163c.this.cro;
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(55765);
                    }
                }
                C4990ab.m7410d("MicroMsg.SilkWriter", "ThreadSilk in :" + a + " cnt :" + C45163c.this.crn.size());
                if (a && C45163c.this.crn.isEmpty()) {
                    break;
                }
                try {
                    C32305a c32305a = (C32305a) C45163c.this.crn.poll(200, TimeUnit.MILLISECONDS);
                    if (c32305a == null) {
                        C4990ab.m7416i("MicroMsg.SilkWriter", "poll byte null file:" + C45163c.this.crp);
                    } else {
                        int size = C45163c.this.crn.size();
                        if (size > 10 || a) {
                            C4990ab.m7420w("MicroMsg.SilkWriter", "speed up silkcodec queue:" + size + " stop:" + a);
                            size = false;
                        } else if (size < 9) {
                            size = 1;
                        } else {
                            size = 1;
                        }
                        if (C45163c.crz.count >= 10 && C45163c.crz.crk > 240) {
                            size = 0;
                        }
                        C45163c.this.mo43823a(c32305a, size, false);
                    }
                } catch (InterruptedException e) {
                    C4990ab.m7416i("MicroMsg.SilkWriter", "ThreadAmr poll null");
                }
            }
        }
    }

    public C45163c(int i, int i2) {
        AppMethodBeat.m2504i(55766);
        this.mSampleRate = i;
        this.crs = i2;
        AppMethodBeat.m2505o(55766);
    }

    /* renamed from: eo */
    public final boolean mo43824eo(String str) {
        AppMethodBeat.m2504i(55767);
        C4990ab.m7416i("MicroMsg.SilkWriter", "initWriter path: ".concat(String.valueOf(str)));
        if (str == null) {
            C4990ab.m7412e("MicroMsg.SilkWriter", "path is null");
            AppMethodBeat.m2505o(55767);
            return false;
        }
        OutputStream outputStream = null;
        try {
            outputStream = C5730e.m8617L(str, false);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SilkWriter", e, "initWriter openWrite failed: %s", e.getMessage());
            C7060h.pYm.mo15419k(357, 55, 1);
            if (C7243d.vxr) {
                HashMap hashMap = new HashMap();
                hashMap.put(SharePluginInfo.ISSUE_KEY_STACK, e.getMessage());
                C7060h.pYm.mo8382g("Record", "Write failed", hashMap);
            }
        }
        if (outputStream != null) {
            try {
                this.crp = str;
                this.crw = outputStream;
                this.crv = false;
                int Lw = C45290m.m83509Lw();
                if ((Lw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                    this.crx = 4;
                } else if ((Lw & 512) != 0) {
                    this.crx = 2;
                } else {
                    C4990ab.m7412e("TAG", "initWriter cpuType error! silk don't support arm_v5!!!!");
                    AppMethodBeat.m2505o(55767);
                    return false;
                }
                if (MediaRecorder.SilkEncInit(this.mSampleRate, this.crs, this.crx) != 0) {
                    C4990ab.m7413e("MicroMsg.SilkWriter", "initWriter SilkEncoderInit Error:%d", Integer.valueOf(MediaRecorder.SilkEncInit(this.mSampleRate, this.crs, this.crx)));
                    AppMethodBeat.m2505o(55767);
                    return false;
                }
                this.crr = new byte[(((this.mSampleRate * 20) * 2) / 1000)];
                Lw = -1;
                C5141c ll = C18624c.abi().mo17131ll("100279");
                if (ll.isValid()) {
                    Lw = C5046bo.getInt((String) ll.dru().get("isVoiceMsgOptOpen"), 0);
                }
                if (1 == Lw) {
                    this.cry = true;
                }
                if (Lw == 0) {
                    this.cry = false;
                }
                if (this.cry) {
                    MediaRecorder.SetVoiceSilkControl(200, 1);
                    C4990ab.m7416i("MicroMsg.SilkWriter", "Voice Message Compression Optimization is Open !");
                } else {
                    MediaRecorder.SetVoiceSilkControl(200, 0);
                    C4990ab.m7416i("MicroMsg.SilkWriter", "Voice Message Compression Optimization is Close !");
                }
                AppMethodBeat.m2505o(55767);
                return true;
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.SilkWriter", "initWriter FileOutputStream error:%s", e2.getMessage());
                AppMethodBeat.m2505o(55767);
                return false;
            }
        }
        AppMethodBeat.m2505o(55767);
        return false;
    }

    /* renamed from: Fe */
    public final void mo43820Fe() {
        AppMethodBeat.m2504i(55768);
        C4990ab.m7416i("MicroMsg.SilkWriter", "waitStop");
        synchronized (this) {
            try {
                this.cro = true;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(55768);
                }
            }
        }
        if (this.cru != null) {
            try {
                C7305d.xDG.mo10149an(this.cru);
            } catch (InterruptedException e) {
                C4990ab.m7413e("MicroMsg.SilkWriter", "exception:%s", C5046bo.m7574l(e));
            } catch (ExecutionException e2) {
                C4990ab.m7413e("MicroMsg.SilkWriter", "exception:%s", C5046bo.m7574l(e2));
            }
        }
        m83157Fh();
        AppMethodBeat.m2505o(55768);
    }

    /* renamed from: Fh */
    private void m83157Fh() {
        AppMethodBeat.m2504i(55769);
        synchronized (this.crt) {
            try {
                MediaRecorder.SilkEncUnInit();
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(55769);
                }
            }
        }
        C4990ab.m7416i("MicroMsg.SilkWriter", "finish Thread file:" + this.crp);
        if (this.crw != null) {
            try {
                this.crw.close();
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.SilkWriter", "close silk file:" + this.crp + "msg:" + e.getMessage());
            }
            this.crw = null;
        }
        AppMethodBeat.m2505o(55769);
    }

    /* renamed from: Ff */
    public final boolean mo43821Ff() {
        AppMethodBeat.m2504i(55770);
        C4990ab.m7416i("MicroMsg.SilkWriter", "resetWriter");
        synchronized (this.crt) {
            try {
                MediaRecorder.SilkEncUnInit();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(55770);
            }
        }
        if (MediaRecorder.SilkEncInit(this.mSampleRate, this.crs, this.crx) != 0) {
            C4990ab.m7413e("MicroMsg.SilkWriter", "resetWriter SilkEncoderInit Error:%d", Integer.valueOf(MediaRecorder.SilkEncInit(this.mSampleRate, this.crs, this.crx)));
            return false;
        }
        AppMethodBeat.m2505o(55770);
        return true;
    }

    /* renamed from: a */
    public final int mo43822a(C32305a c32305a) {
        AppMethodBeat.m2504i(55771);
        int a = mo43823a(c32305a, 0, false);
        AppMethodBeat.m2505o(55771);
        return a;
    }

    /* renamed from: a */
    public final int mo43823a(C32305a c32305a, int i, boolean z) {
        AppMethodBeat.m2504i(55772);
        C1446a c1446a = new C1446a();
        short s = (short) (((this.mSampleRate * 20) * 2) / 1000);
        short s2 = this.crq + c32305a.cqs;
        int i2 = 0;
        byte[] bArr = new byte[s];
        byte[] bArr2 = new byte[((this.cry ? 6 : 1) * s)];
        String value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("VoiceNoiseSuppression");
        boolean z2 = !C5046bo.isNullOrNil(value) ? C5046bo.getInt(value, 1) == 1 : true;
        if (z) {
            z2 = false;
        }
        C4990ab.m7411d("MicroMsg.SilkWriter", "noise suppression: %b", Boolean.valueOf(z2));
        int i3 = 0;
        while (s2 >= s) {
            int i4;
            if (this.crq > 0) {
                try {
                    System.arraycopy(this.crr, 0, bArr, 0, this.crq);
                    byte[] bArr3 = c32305a.buf;
                    i4 = this.crq;
                    System.arraycopy(bArr3, 0, bArr, i4, s - i4);
                    i2 += s - this.crq;
                    this.crq = 0;
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, leftBufSize:%d copySize:%d error:%s", Integer.valueOf(this.crq), Integer.valueOf(s - this.crq), e.getMessage());
                    AppMethodBeat.m2505o(55772);
                    return -1;
                }
            }
            try {
                System.arraycopy(c32305a.buf, i2, bArr, 0, s);
                i2 += s;
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, offset:%d framelen:%d error:%s", Integer.valueOf(i2), Short.valueOf(s), e2.getMessage());
                AppMethodBeat.m2505o(55772);
                return -1;
            }
            short s3 = s2 - s;
            short[] sArr = new short[1];
            synchronized (this.crt) {
                try {
                    if (this.cry) {
                        if (s3 >= s || !c32305a.cqt) {
                            MediaRecorder.SetVoiceSilkControl(201, 0);
                        } else {
                            MediaRecorder.SetVoiceSilkControl(201, 1);
                            C4990ab.m7416i("MicroMsg.SilkWriter", "silk do encode mark last frame");
                        }
                    }
                    i4 = MediaRecorder.SilkDoEnc(bArr, s, bArr2, sArr, z2);
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(55772);
                }
            }
            Object obj = null;
            if (z && sArr[0] >= (short) 10 && bArr2[0] == (byte) 2 && bArr2[1] == (byte) 35 && bArr2[2] == (byte) 33 && bArr2[3] == (byte) 83 && bArr2[4] == (byte) 73 && bArr2[5] == (byte) 76 && bArr2[6] == (byte) 75 && bArr2[7] == (byte) 95 && bArr2[8] == (byte) 86 && bArr2[9] == (byte) 51) {
                C4990ab.m7416i("MicroMsg.SilkWriter", "writeSilkFile deleteHead & bDeleteHead true");
                obj = 1;
            }
            if (i4 != 0) {
                this.crq = 0;
                C4990ab.m7413e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode failed, ret:%d", Integer.valueOf(i4));
                if (!this.crv) {
                    C7060h.pYm.mo15419k(357, 56, 1);
                    this.crv = true;
                    if (C7243d.vxr) {
                        C7060h.pYm.mo8382g("Record", "Encode failed", null);
                    }
                }
                AppMethodBeat.m2505o(55772);
                return -1;
            }
            C4990ab.m7419v("MicroMsg.SilkWriter", "encoutdatalen: %s, framelen: %s, lastframe: %s, byteBuf.len: %s", Short.valueOf(sArr[0]), Short.valueOf(s), Boolean.valueOf(c32305a.cqt), Integer.valueOf(c32305a.cqs));
            try {
                if (sArr[0] < bArr2.length && sArr[0] > (short) 0 && this.crw != null) {
                    if (!z || obj == null) {
                        this.crw.write(bArr2, 0, sArr[0]);
                        i3 += sArr[0];
                    } else {
                        C4990ab.m7416i("MicroMsg.SilkWriter", "writeSilkFile bDeleteHead copyOfRange");
                        this.crw.write(Arrays.copyOfRange(bArr2, 1, bArr2.length), 0, sArr[0] - 1);
                        i3 += sArr[0] - 1;
                        s2 = s3;
                    }
                }
                s2 = s3;
            } catch (IOException e3) {
                C4990ab.m7413e("MicroMsg.SilkWriter", "writeSilkFile Write File Error file:%s", this.crp);
                AppMethodBeat.m2505o(55772);
                return -1;
            }
        }
        try {
            this.crw.flush();
            try {
                System.arraycopy(c32305a.buf, i2, this.crr, this.crq, s2);
                this.crq += s2;
                long Mr = c1446a.mo4908Mr();
                if (i == 1) {
                    C17952a c17952a = crz;
                    c17952a.crk = ((c17952a.crk * ((long) c17952a.count)) + Mr) / ((long) (c17952a.count + 1));
                    c17952a.count++;
                }
                C4990ab.m7410d("MicroMsg.SilkWriter", "writeSilkFile append2silkfile silkTime:" + Mr + " useFloat:" + i + " avg:" + crz.crk + " cnt:" + crz.count);
                AppMethodBeat.m2505o(55772);
                return i3;
            } catch (Exception e22) {
                C4990ab.m7413e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, offset:%d leftBufSize:%d leftSize:%d error:%s", Integer.valueOf(i2), Integer.valueOf(this.crq), Integer.valueOf(s2), e22.getMessage());
                AppMethodBeat.m2505o(55772);
                return -1;
            }
        } catch (IOException e4) {
            C4990ab.m7413e("MicroMsg.SilkWriter", "writeSilkFile flush File Error file:%s", this.crp);
            AppMethodBeat.m2505o(55772);
            return -1;
        }
    }

    static {
        AppMethodBeat.m2504i(55773);
        AppMethodBeat.m2505o(55773);
    }
}
