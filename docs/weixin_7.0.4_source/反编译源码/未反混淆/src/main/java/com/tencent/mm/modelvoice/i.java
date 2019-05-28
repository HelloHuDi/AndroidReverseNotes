package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Process;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.audio.d.b;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;
import com.tencent.mm.vfs.e;
import com.tencent.ugc.TXRecordCommon;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class i implements d {
    private static int fZD = 100;
    private static Object fZv = new Object();
    private static int fZw = -1;
    private static int fZx;
    public int cpQ;
    private b fZA;
    private int fZB;
    private boolean fZC;
    private OnCompletionListener fZE;
    private OnErrorListener fZF;
    private a fZn;
    private com.tencent.mm.compatible.util.b fZo;
    private com.tencent.mm.modelvoice.d.a fZp;
    private d.b fZq;
    private int fZr;
    private volatile boolean fZs;
    private String fZt;
    private String fZu;
    private int fZy;
    private int fZz;
    private AudioTrack mAudioTrack;
    private String mFileName;
    public int mSampleRate;
    private volatile int mStatus;

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(i iVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(55796);
            Process.setThreadPriority(-16);
            byte[] bArr = new byte[(AudioTrack.getMinBufferSize(i.this.mSampleRate, 2, 2) * 2)];
            short g = (short) ((i.this.mSampleRate * 20) / 1000);
            ab.d("MicroMsg.SilkPlayer", "frameLen: %d, playBufferSize: %d", Short.valueOf(g), Integer.valueOf(AudioTrack.getMinBufferSize(i.this.mSampleRate, 2, 2) * 2));
            ab.i("MicroMsg.SilkPlayer", "Thread start");
            while (true) {
                if (i.this.mStatus != 1 && i.this.mStatus != 2) {
                    break;
                }
                synchronized (i.fZv) {
                    try {
                        if (i.fZx != i.this.fZy) {
                            ab.i("MicroMsg.SilkPlayer", "[%d] diff id, useDeocder: %d", Integer.valueOf(i.this.fZy), Integer.valueOf(i.fZx));
                            i.this.fZr = i.this.fZr + 1;
                            if (i.this.fZr > 3) {
                                h.pYm.a(161, 17, 1, false);
                            }
                            i.a(i.this, i.this.mFileName);
                        }
                    } catch (Exception e) {
                        h.pYm.a(161, 0, 1, false);
                        ab.e("MicroMsg.SilkPlayer", "exception:%s", bo.l(e));
                        if (i.this.fZF != null) {
                            i.this.fZF.onError(null, 0, 0);
                        }
                        i.this.mStatus = 0;
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(55796);
                            throw th;
                        }
                    }
                }
                while (i.this.fZs) {
                    ab.d("MicroMsg.SilkPlayer", "waitting for switching complete");
                    Thread.sleep(20);
                }
                int SilkDoDec = MediaRecorder.SilkDoDec(bArr, g);
                if (SilkDoDec < 0) {
                    i.this.mStatus = 0;
                    h.pYm.a(161, 0, 1, false);
                    h.pYm.a(161, 4, 1, false);
                    ab.e("MicroMsg.SilkPlayer", "[%d] SilkDoDec failed: %d", Integer.valueOf(i.this.fZy), Integer.valueOf(SilkDoDec));
                    if (i.this.fZA != null && ae.gjd) {
                        i.this.fZA.Fg();
                    }
                } else {
                    if (ae.gjd && i.this.fZA != null) {
                        i.this.fZA.y(bArr, g * 2);
                    }
                    try {
                        i.this.mAudioTrack.write(bArr, 0, g * 2);
                    } catch (Exception e2) {
                        ab.e("MicroMsg.SilkPlayer", "write audio track failed: %s", e2.getMessage());
                        h.pYm.a(161, 0, 1, false);
                        h.pYm.a(161, 5, 1, false);
                    }
                    i.this.fZz = i.this.fZz + 1;
                    if (SilkDoDec == 0) {
                        i.this.mStatus = 0;
                        ab.i("MicroMsg.SilkPlayer", "[%d] play completed", Integer.valueOf(i.this.fZy));
                        if (i.this.fZA != null && ae.gjd) {
                            i.this.fZA.Fg();
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(55795);
                                    Toast.makeText(ah.getContext(), "Save to: " + i.this.fZA.mFilePath, 1).show();
                                    AppMethodBeat.o(55795);
                                }
                            });
                        }
                    } else if (i.this.mStatus == 2) {
                        synchronized (i.this.fZu) {
                            try {
                                ab.v("MicroMsg.SilkPlayer", "before mOk.notify");
                                i.this.fZu.notify();
                                ab.v("MicroMsg.SilkPlayer", "after mOk.notify");
                            } catch (Exception e22) {
                                ab.e("MicroMsg.SilkPlayer", "exception:%s", bo.l(e22));
                            } catch (Throwable th2) {
                                AppMethodBeat.o(55796);
                                throw th2;
                            }
                        }
                        synchronized (i.this.fZt) {
                            try {
                                ab.v("MicroMsg.SilkPlayer", "before mpause.wait");
                                i.this.fZt.wait();
                                ab.v("MicroMsg.SilkPlayer", "after mpause.wait");
                            } catch (Exception e222) {
                                ab.e("MicroMsg.SilkPlayer", "exception:%s", bo.l(e222));
                            }
                        }
                    } else {
                        synchronized (i.this.fZu) {
                            try {
                                i.this.fZu.notify();
                            } catch (Exception e2222) {
                                ab.e("MicroMsg.SilkPlayer", "exception:%s", bo.l(e2222));
                            }
                        }
                    }
                }
            }
            if (i.this.mStatus != 3) {
                Thread.sleep(1000);
            }
            synchronized (i.fZv) {
                try {
                    if (i.fZx == i.this.fZy) {
                        MediaRecorder.SilkDecUnInit();
                        ab.i("MicroMsg.SilkPlayer", "[%d] SilkDecUnInit", Integer.valueOf(i.this.fZy));
                        i.fZx = -1;
                        i.this.fZr = 0;
                    }
                } catch (Throwable th22) {
                    while (true) {
                        AppMethodBeat.o(55796);
                        throw th22;
                    }
                }
            }
            if (i.this.mStatus != 3) {
                if (i.this.fZp != null) {
                    i.this.fZp.EA();
                }
                if (i.this.fZE != null) {
                    i.this.fZE.onCompletion(null);
                    AppMethodBeat.o(55796);
                    return;
                }
            } else if (i.this.mAudioTrack != null) {
                ab.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
                i.this.mAudioTrack.stop();
                i.this.mAudioTrack.release();
                i.this.mAudioTrack = null;
            }
            AppMethodBeat.o(55796);
        }
    }

    static {
        AppMethodBeat.i(55815);
        AppMethodBeat.o(55815);
    }

    public final int getStatus() {
        return this.mStatus;
    }

    public i() {
        AppMethodBeat.i(55797);
        this.fZp = null;
        this.fZq = null;
        this.cpQ = 2;
        this.mSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_16000;
        this.mFileName = "";
        this.mStatus = 0;
        this.fZr = 0;
        this.fZs = false;
        this.fZt = "";
        this.fZu = "";
        this.fZz = 0;
        this.fZA = null;
        this.fZB = 8;
        this.fZC = true;
        this.fZE = new OnCompletionListener() {
            public final void onCompletion(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(55793);
                if (i.this.fZo != null && i.this.fZC) {
                    ab.i("MicroMsg.SilkPlayer", "silkPlayer play onCompletion abandonFocus");
                    i.this.fZo.Mm();
                }
                try {
                    i.this.mStatus = 0;
                    if (i.this.mAudioTrack != null) {
                        ab.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
                        i.this.mAudioTrack.stop();
                        i.this.mAudioTrack.release();
                        i.this.mAudioTrack = null;
                    }
                    AppMethodBeat.o(55793);
                } catch (Exception e) {
                    ab.e("MicroMsg.SilkPlayer", "exception:%s", bo.l(e));
                    ab.e("MicroMsg.SilkPlayer", "setCompletion File[" + i.this.mFileName + "] ErrMsg[" + e.getStackTrace() + "]");
                    AppMethodBeat.o(55793);
                }
            }
        };
        this.fZF = new OnErrorListener() {
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                AppMethodBeat.i(55794);
                ab.i("MicroMsg.SilkPlayer", "onError");
                if (i.this.fZo != null && i.this.fZC) {
                    i.this.fZo.Mm();
                }
                if (i.this.fZq != null) {
                    i.this.fZq.onError();
                }
                try {
                    i.this.mStatus = -1;
                    if (i.this.mAudioTrack != null) {
                        ab.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
                        i.this.mAudioTrack.stop();
                        i.this.mAudioTrack.release();
                        i.this.mAudioTrack = null;
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.SilkPlayer", "setErrorListener File[" + i.this.mFileName + "] ErrMsg[" + e.getStackTrace() + "]");
                }
                AppMethodBeat.o(55794);
                return false;
            }
        };
        fZw++;
        this.fZy = fZw;
        ab.i("MicroMsg.SilkPlayer", "[%d] new Instance", Integer.valueOf(this.fZy));
        AppMethodBeat.o(55797);
    }

    public i(Context context) {
        this();
        AppMethodBeat.i(55798);
        this.fZo = new com.tencent.mm.compatible.util.b(context);
        AppMethodBeat.o(55798);
    }

    public final void a(com.tencent.mm.modelvoice.d.a aVar) {
        this.fZp = aVar;
    }

    public final void a(d.b bVar) {
        this.fZq = bVar;
    }

    public final void bo(boolean z) {
        AppMethodBeat.i(55799);
        ab.d("MicroMsg.SilkPlayer", "setSpeakerOn: %b", Boolean.valueOf(z));
        this.fZs = true;
        this.cpQ = 2;
        cZ(z);
        try {
            this.mAudioTrack.play();
        } catch (Exception e) {
            h.pYm.a(161, 0, 1, false);
            h.pYm.a(161, 3, 1, false);
            ab.e("MicroMsg.SilkPlayer", "audioTrack error:%s", e.getMessage());
        }
        this.fZs = false;
        AppMethodBeat.o(55799);
    }

    private void cZ(boolean z) {
        AppMethodBeat.i(55800);
        if (this.mAudioTrack != null) {
            ab.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
            try {
                this.mAudioTrack.stop();
                this.mAudioTrack.release();
            } catch (Exception e) {
                ab.e("MicroMsg.SilkPlayer", "mAudioTrack.stop() error: %s", e.getMessage());
            }
            this.mAudioTrack = null;
        }
        this.mAudioTrack = com.tencent.mm.audio.c.a.a(z, this.mSampleRate, this.cpQ, this.fZB);
        if (this.mAudioTrack == null || this.mAudioTrack.getState() == 0) {
            h.pYm.a(161, 0, 1, false);
            h.pYm.a(161, 2, 1, false);
            try {
                if (this.mAudioTrack != null) {
                    this.mAudioTrack.release();
                    this.mAudioTrack = null;
                }
                AppMethodBeat.o(55800);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(55800);
    }

    public final boolean S(String str, boolean z) {
        AppMethodBeat.i(55801);
        boolean T = T(str, z);
        AppMethodBeat.o(55801);
        return T;
    }

    public final boolean c(String str, boolean z, int i) {
        AppMethodBeat.i(55802);
        boolean T = T(str, z);
        AppMethodBeat.o(55802);
        return T;
    }

    private boolean T(String str, boolean z) {
        int i = 2;
        AppMethodBeat.i(55803);
        if (this.mStatus != 0) {
            ab.e("MicroMsg.SilkPlayer", "startPlay error status:" + this.mStatus);
            AppMethodBeat.o(55803);
            return false;
        }
        boolean da;
        if (ae.gjd) {
            aX(str, g.cqr);
        }
        ab.i("MicroMsg.SilkPlayer", "startPlay");
        this.mStatus = 1;
        this.mFileName = str;
        synchronized (fZv) {
            try {
                uH(str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(55803);
                }
            }
        }
        if (ae.gjd) {
            int i2;
            String str2 = g.cqq;
            if (this.cpQ == 2) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            this.fZA = new b(str2, i2, this.mSampleRate);
        }
        String str3 = "MicroMsg.SilkPlayer";
        String str4 = "startPlay, sampleRate: %d, channelCnt: %d ";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.mSampleRate);
        if (this.cpQ == 2) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        ab.d(str3, str4, objArr);
        try {
            da = da(z);
        } catch (Exception e) {
            try {
                da = da(true);
            } catch (Exception e2) {
                ab.e("MicroMsg.SilkPlayer", "startPlay File[" + this.mFileName + "] failed");
                ab.e("MicroMsg.SilkPlayer", "exception:%s", bo.l(e));
                this.mStatus = -1;
                AppMethodBeat.o(55803);
                return false;
            }
        }
        AppMethodBeat.o(55803);
        return da;
    }

    private void uH(String str) {
        int available;
        AppMethodBeat.i(55804);
        fZx = this.fZy;
        ab.i("MicroMsg.SilkPlayer", "[%d] SilkDecInit", Integer.valueOf(this.fZy));
        try {
            InputStream openRead = e.openRead(str);
            available = openRead.available();
            ab.d("MicroMsg.SilkPlayer", "SilkDecInit streamlen:%d", Integer.valueOf(available));
            int minBufferSize = AudioTrack.getMinBufferSize(this.mSampleRate, 2, 2) * 2;
            if (!com.tencent.mm.compatible.b.g.KK().KP() || available >= minBufferSize) {
                this.fZB = 8;
            } else {
                this.fZB = 1;
            }
            byte[] bArr = new byte[available];
            openRead.read(bArr, 0, available);
            this.mSampleRate = MediaRecorder.SilkGetEncSampleRate(new byte[]{bArr[0]});
            ab.i("MicroMsg.SilkPlayer", "silkdec uninit success: %d".concat(String.valueOf(MediaRecorder.SilkDecUnInit())));
            MediaRecorder.SilkDecInit(this.mSampleRate, bArr, available);
            available = -1;
            c ll = com.tencent.mm.model.c.c.abi().ll("100268");
            if (ll.isValid()) {
                available = bo.getInt((String) ll.dru().get("SilkAudioPlayerAgcOn"), 0);
            }
            if (1 == available || available == 0) {
                MediaRecorder.SetVoiceSilkDecControl(fZD, new byte[]{(byte) available}, 1);
            }
            openRead.close();
        } catch (Exception e) {
            h.pYm.a(161, 0, 1, false);
            h.pYm.a(161, 1, 1, false);
            ab.e("MicroMsg.SilkPlayer", "exception:%s", bo.l(e));
        }
        ab.d("MicroMsg.SilkPlayer", "[%d] skip %d frames", Integer.valueOf(this.fZy), Integer.valueOf(this.fZz));
        byte[] bArr2 = new byte[(AudioTrack.getMinBufferSize(this.mSampleRate, 2, 2) * 2)];
        short s = (short) ((this.mSampleRate * 20) / 1000);
        for (available = 0; available < this.fZz; available++) {
            if (MediaRecorder.SilkDoDec(bArr2, s) <= 0) {
                ab.e("MicroMsg.SilkPlayer", "[%d], skip frame failed: %d", Integer.valueOf(this.fZy), Integer.valueOf(MediaRecorder.SilkDoDec(bArr2, s)));
                AppMethodBeat.o(55804);
                return;
            }
        }
        AppMethodBeat.o(55804);
    }

    private boolean da(boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(55805);
        if (e.ct(this.mFileName)) {
            try {
                cZ(z);
                if (this.mAudioTrack != null) {
                    if (this.fZo != null && this.fZC) {
                        this.fZo.requestFocus();
                    }
                    z2 = alT();
                    AppMethodBeat.o(55805);
                }
            } catch (Exception e) {
                if (this.fZo != null && this.fZC) {
                    this.fZo.Mm();
                }
                ab.e("MicroMsg.SilkPlayer", "playImp : fail, exception = " + e.getMessage());
                ab.e("MicroMsg.SilkPlayer", "exception:%s", bo.l(e));
            }
            AppMethodBeat.o(55805);
        } else {
            AppMethodBeat.o(55805);
        }
        return z2;
    }

    private boolean alT() {
        AppMethodBeat.i(55806);
        if (this.mAudioTrack != null) {
            try {
                ab.i("MicroMsg.SilkPlayer", "play");
                this.mAudioTrack.play();
                this.fZn = new a(this, (byte) 0);
                d.f(this.fZn, "SilkPlayer_play_" + this.fZy);
                AppMethodBeat.o(55806);
                return true;
            } catch (Exception e) {
                ab.e("MicroMsg.SilkPlayer", "audioTrack error:%s", e.getMessage());
                h.pYm.a(161, 0, 1, false);
                h.pYm.a(161, 3, 1, false);
                AppMethodBeat.o(55806);
                return false;
            }
        }
        AppMethodBeat.o(55806);
        return false;
    }

    public final boolean bn(boolean z) {
        AppMethodBeat.i(55807);
        if (this.mStatus != 1) {
            AppMethodBeat.o(55807);
            return false;
        }
        this.mStatus = 2;
        synchronized (this.fZu) {
            try {
                ab.v("MicroMsg.SilkPlayer", "before mOk.wait");
                long currentTimeMillis = System.currentTimeMillis();
                this.fZu.wait();
                ab.v("MicroMsg.SilkPlayer", "after mOk.wait time:" + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Exception e) {
                ab.e("MicroMsg.SilkPlayer", "exception:%s", bo.l(e));
                AppMethodBeat.o(55807);
                return false;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(55807);
                    throw th;
                }
            }
        }
        if (this.fZo != null && z) {
            this.fZo.Mm();
        }
        AppMethodBeat.o(55807);
        return true;
    }

    public final boolean Ew() {
        AppMethodBeat.i(55808);
        if (this.mStatus != 2) {
            AppMethodBeat.o(55808);
            return false;
        }
        this.mStatus = 1;
        synchronized (this.fZt) {
            try {
                ab.v("MicroMsg.SilkPlayer", "before mpause.notify");
                this.fZt.notify();
                ab.v("MicroMsg.SilkPlayer", "after mpause.notify");
            } catch (Exception e) {
                ab.e("MicroMsg.SilkPlayer", "exception:%s", bo.l(e));
                AppMethodBeat.o(55808);
                return false;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(55808);
                    throw th;
                }
            }
        }
        if (this.fZo != null && this.fZC) {
            this.fZo.requestFocus();
        }
        AppMethodBeat.o(55808);
        return true;
    }

    public final boolean isPlaying() {
        return this.mStatus == 1;
    }

    public final boolean EH() {
        AppMethodBeat.i(55809);
        ab.i("MicroMsg.SilkPlayer", "stop  status:" + this.mStatus);
        if (this.mStatus == 1 || this.mStatus == 2) {
            this.mStatus = 3;
            synchronized (this.fZt) {
                try {
                    this.fZt.notify();
                    if (this.fZo != null && this.fZC) {
                        this.fZo.Mm();
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.SilkPlayer", "exception:%s", bo.l(e));
                    if (this.fZo != null && this.fZC) {
                        this.fZo.Mm();
                    }
                    AppMethodBeat.o(55809);
                    return false;
                } catch (Throwable th) {
                    AppMethodBeat.o(55809);
                    throw th;
                }
            }
            AppMethodBeat.o(55809);
            return true;
        }
        ab.e("MicroMsg.SilkPlayer", "stop  error status:" + this.mStatus);
        AppMethodBeat.o(55809);
        return false;
    }

    public final double Ez() {
        return 0.0d;
    }

    public final void b(com.tencent.mm.compatible.util.b.a aVar) {
        AppMethodBeat.i(55810);
        if (!(aVar == null || this.fZo == null)) {
            this.fZo.a(aVar);
        }
        AppMethodBeat.o(55810);
    }

    public final void alP() {
        this.fZC = false;
    }

    public final String aX(String str, String str2) {
        Exception e;
        String str3 = null;
        AppMethodBeat.i(55811);
        if (this.mStatus != 0) {
            ab.e("MicroMsg.SilkPlayer", "startPlay error status:" + this.mStatus);
            AppMethodBeat.o(55811);
        } else {
            this.mStatus = 1;
            this.mFileName = str;
            InputStream openRead;
            try {
                openRead = e.openRead(str);
                try {
                    int available = openRead.available();
                    byte[] bArr = new byte[available];
                    openRead.read(bArr, 0, available);
                    this.mSampleRate = MediaRecorder.SilkGetEncSampleRate(new byte[]{bArr[0]});
                    MediaRecorder.SilkDecInit(this.mSampleRate, bArr, available);
                    ab.i("MicroMsg.SilkPlayer", "[%d] SilkDecInit in silkToPcm", Integer.valueOf(this.fZy));
                    openRead.close();
                    str3 = uI(str2);
                    AppMethodBeat.o(55811);
                } catch (Exception e2) {
                    e = e2;
                    ab.e("MicroMsg.SilkPlayer", "silkToPcm, file[%s], exception: %s", this.mFileName, e.getMessage());
                    ab.e("MicroMsg.SilkPlayer", "exception:%s", bo.l(e));
                    this.mStatus = -1;
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e3) {
                            ab.printErrStackTrace("MicroMsg.SilkPlayer", e3, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.o(55811);
                    return str3;
                }
            } catch (Exception e4) {
                e = e4;
                openRead = str3;
            }
        }
        return str3;
    }

    private String uI(String str) {
        OutputStream L;
        Exception e;
        AppMethodBeat.i(55812);
        ab.d("MicroMsg.SilkPlayer", "hakon silkToPcmImpl()");
        if (e.ct(this.mFileName)) {
            try {
                ab.d("MicroMsg.SilkPlayer", "hakon silkToPcmImpl thread start");
                Process.setThreadPriority(-16);
                byte[] bArr = new byte[(AudioTrack.getMinBufferSize(this.mSampleRate, 2, 2) << 1)];
                short s = (short) ((this.mSampleRate * 20) / 1000);
                uJ(str);
                L = e.L(str, false);
                while (true) {
                    if (this.mStatus != 1 && this.mStatus != 2) {
                        break;
                    }
                    int SilkDoDec = MediaRecorder.SilkDoDec(bArr, s);
                    if (SilkDoDec < 0) {
                        this.mStatus = 0;
                    } else {
                        while (this.fZs) {
                            try {
                                Thread.sleep(20);
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    ab.e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl thread exception: " + e.getMessage());
                                    ab.e("MicroMsg.SilkPlayer", "exception:%s", bo.l(e));
                                    this.mStatus = 0;
                                    if (L != null) {
                                        try {
                                            L.close();
                                        } catch (IOException e3) {
                                            ab.printErrStackTrace("MicroMsg.SilkPlayer", e3, "", new Object[0]);
                                        }
                                    }
                                    AppMethodBeat.o(55812);
                                    return null;
                                } catch (Exception e4) {
                                    ab.e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl exception: " + e4.getMessage());
                                    ab.e("MicroMsg.SilkPlayer", "exception:%s", bo.l(e4));
                                    AppMethodBeat.o(55812);
                                    return null;
                                }
                            }
                        }
                        L.write(bArr, 0, s * 2);
                        L.flush();
                        if (SilkDoDec == 0) {
                            this.mStatus = 0;
                        }
                    }
                }
                ab.d("MicroMsg.SilkPlayer", "hakon silkToPcmImpl thread end");
                L.close();
                int SilkDecUnInit = MediaRecorder.SilkDecUnInit();
                ab.i("MicroMsg.SilkPlayer", "[%d] SilkDecUnInit in silkToPcmImpl", Integer.valueOf(this.fZy));
                if (SilkDecUnInit != 0) {
                    ab.e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl res: ".concat(String.valueOf(SilkDecUnInit)));
                }
                AppMethodBeat.o(55812);
                return str;
            } catch (Exception e5) {
                e4 = e5;
                L = null;
            }
        } else {
            ab.e("MicroMsg.SilkPlayer", "hakon silkToPcmImpl(), file not exist, fileName = %s", this.mFileName);
            AppMethodBeat.o(55812);
            return null;
        }
    }

    private static boolean uJ(String str) {
        AppMethodBeat.i(55813);
        if (str == null) {
            AppMethodBeat.o(55813);
            return false;
        }
        try {
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf == -1) {
                ab.w("MicroMsg.SilkPlayer", "ensureFileFloder end == -1");
                AppMethodBeat.o(55813);
                return false;
            }
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str.substring(0, lastIndexOf + 1));
            if (!bVar.exists()) {
                boolean z = bVar.mkdirs() || bVar.isDirectory();
                ab.i("MicroMsg.SilkPlayer", "ensureFileFloder mkdir:%s,sucess:%s", r3, Boolean.valueOf(z));
            }
            AppMethodBeat.o(55813);
            return true;
        } catch (Exception e) {
            ab.w("MicroMsg.SilkPlayer", "ensureFileFloder Exception:", e.getMessage());
            AppMethodBeat.o(55813);
            return false;
        }
    }
}
