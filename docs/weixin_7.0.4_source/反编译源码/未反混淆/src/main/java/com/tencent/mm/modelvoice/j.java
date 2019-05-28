package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.d.a;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ugc.TXRecordCommon;
import java.io.IOException;
import java.io.InputStream;
import org.xwalk.core.XWalkUpdater;

public final class j implements d {
    AudioTrack aQf;
    private int cIb;
    b cop;
    boolean fZC;
    OnCompletionListener fZE;
    OnErrorListener fZF;
    a fZI;
    d.b fZJ;
    private int fZK;
    private int fZL;
    private Runnable fZM;
    com.tencent.qqpinyin.voicerecoapi.a fZN;
    private int fZO;
    int fZP;
    boolean fZQ;
    byte[] fZR;
    int fZS;
    InputStream fZT;
    int fZU;
    String fZt;
    String fZu;
    String fileName;
    private int nSamplerate;
    volatile int status;

    public final int getStatus() {
        return this.status;
    }

    public j() {
        int i = 0;
        AppMethodBeat.i(55819);
        this.fileName = "";
        this.fZI = null;
        this.fZJ = null;
        this.status = 0;
        this.fZK = 2;
        this.nSamplerate = TXRecordCommon.AUDIO_SAMPLERATE_16000;
        this.cIb = 1;
        this.fZL = 20;
        this.fZN = null;
        this.fZP = 0;
        this.fZQ = false;
        this.fZt = "";
        this.fZu = "";
        this.fZC = true;
        this.fZR = new byte[com.tencent.qqpinyin.voicerecoapi.a.MAX_FRAME_SIZE];
        this.fZS = 0;
        this.fZT = null;
        this.fZU = 314;
        this.fZE = new OnCompletionListener() {
            public final void onCompletion(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(55816);
                if (j.this.cop != null && j.this.fZC) {
                    j.this.cop.Mm();
                }
                try {
                    j.this.status = 0;
                    j.this.alX();
                    try {
                        j.a(j.this);
                        AppMethodBeat.o(55816);
                    } catch (InterruptedException e) {
                        ab.e("MicroMsg.SpeexPlayer", "exception:%s", bo.l(e));
                        AppMethodBeat.o(55816);
                    }
                } catch (Exception e2) {
                    ab.e("MicroMsg.SpeexPlayer", "exception:%s", bo.l(e2));
                    ab.e("MicroMsg.SpeexPlayer", "setCompletion File[" + j.this.fileName + "] ErrMsg[" + e2.getStackTrace() + "]");
                    AppMethodBeat.o(55816);
                }
            }
        };
        this.fZF = new OnErrorListener() {
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                AppMethodBeat.i(55817);
                ab.d("MicroMsg.SpeexPlayer", "onError");
                if (j.this.cop != null && j.this.fZC) {
                    j.this.cop.Mm();
                }
                if (j.this.fZJ != null) {
                    j.this.fZJ.onError();
                }
                try {
                    j.this.status = -1;
                    j.this.alX();
                    try {
                        j.a(j.this);
                    } catch (InterruptedException e) {
                        ab.e("MicroMsg.SpeexPlayer", "exception:%s", bo.l(e));
                    }
                } catch (Exception e2) {
                    ab.e("MicroMsg.SpeexPlayer", "setErrorListener File[" + j.this.fileName + "] ErrMsg[" + e2.getStackTrace() + "]");
                }
                AppMethodBeat.o(55817);
                return false;
            }
        };
        this.fZN = new com.tencent.qqpinyin.voicerecoapi.a();
        com.tencent.qqpinyin.voicerecoapi.a aVar = this.fZN;
        if (aVar.AqB != 0) {
            i = ZipJNI.UNZ_BADZIPFILE;
        } else {
            int nativeTRSpeexDecodeInit = aVar.AqC.nativeTRSpeexDecodeInit();
            if (nativeTRSpeexDecodeInit == -1 || nativeTRSpeexDecodeInit == -100 || nativeTRSpeexDecodeInit == XWalkUpdater.ERROR_SET_VERNUM || nativeTRSpeexDecodeInit == ZipJNI.UNZ_PARAMERROR) {
                i = nativeTRSpeexDecodeInit;
            } else {
                aVar.AqB = nativeTRSpeexDecodeInit;
                aVar.Aqz = new byte[(com.tencent.qqpinyin.voicerecoapi.a.MAX_FRAME_SIZE * 15)];
            }
        }
        if (i != 0) {
            ab.e("speex", "res: ".concat(String.valueOf(i)));
        }
        AppMethodBeat.o(55819);
    }

    public j(Context context) {
        this();
        AppMethodBeat.i(55820);
        this.cop = new b(context);
        AppMethodBeat.o(55820);
    }

    public final void a(a aVar) {
        this.fZI = aVar;
    }

    public final void a(d.b bVar) {
        this.fZJ = bVar;
    }

    /* Access modifiers changed, original: final */
    public final void alX() {
        AppMethodBeat.i(55821);
        if (this.aQf != null) {
            this.aQf.stop();
            this.aQf.release();
            this.aQf = null;
        }
        AppMethodBeat.o(55821);
    }

    public final void bo(boolean z) {
        int i;
        AppMethodBeat.i(55822);
        this.fZQ = true;
        if (this.cIb == 2) {
            this.fZK = 3;
        } else {
            this.fZK = 2;
        }
        this.fZO = AudioTrack.getMinBufferSize(this.nSamplerate, this.fZK, 2);
        if (this.aQf != null) {
            try {
                this.aQf.stop();
                this.aQf.release();
                this.aQf = null;
            } catch (Exception e) {
                ab.e("MicroMsg.SpeexPlayer", e.getMessage());
                this.aQf = null;
            } catch (Throwable th) {
                this.aQf = null;
                AppMethodBeat.o(55822);
            }
        }
        if (z) {
            i = 3;
        } else {
            i = 0;
        }
        if (q.etd.epG) {
            q.etd.dump();
            if (q.etd.epN == 1) {
                i = 3;
            }
        }
        this.aQf = new e(i, this.nSamplerate, this.fZK, this.fZO * 8);
        try {
            this.aQf.play();
        } catch (Exception e2) {
            ab.e("MicroMsg.SpeexPlayer", "audioTrack error:%s", e2.getMessage());
        }
        this.fZQ = false;
        AppMethodBeat.o(55822);
    }

    public final boolean S(String str, boolean z) {
        AppMethodBeat.i(55823);
        boolean T = T(str, z);
        AppMethodBeat.o(55823);
        return T;
    }

    public final boolean c(String str, boolean z, int i) {
        AppMethodBeat.i(55824);
        boolean T = T(str, z);
        AppMethodBeat.o(55824);
        return T;
    }

    private boolean T(String str, boolean z) {
        AppMethodBeat.i(55825);
        if (this.status != 0) {
            ab.e("MicroMsg.SpeexPlayer", "startPlay error status:" + this.status);
            AppMethodBeat.o(55825);
            return false;
        }
        ab.i("MicroMsg.SpeexPlayer", "startPlay");
        this.status = 1;
        this.fileName = str;
        try {
            db(z);
        } catch (Exception e) {
            try {
                db(true);
            } catch (Exception e2) {
                ab.e("MicroMsg.SpeexPlayer", "startPlay File[" + this.fileName + "] failed");
                ab.e("MicroMsg.SpeexPlayer", "exception:%s", bo.l(e));
                this.status = -1;
                AppMethodBeat.o(55825);
                return false;
            }
        }
        AppMethodBeat.o(55825);
        return true;
    }

    /* JADX WARNING: Missing block: B:9:0x0027, code skipped:
            if (com.tencent.mm.compatible.e.q.etd.epN == 1) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void db(boolean z) {
        int i = 3;
        AppMethodBeat.i(55826);
        if (com.tencent.mm.vfs.e.ct(this.fileName)) {
            int i2 = z ? 3 : 0;
            try {
                if (q.etd.epG) {
                    q.etd.dump();
                }
                i = i2;
                this.fZO = AudioTrack.getMinBufferSize(this.nSamplerate, this.fZK, 2);
                alX();
                this.aQf = new e(i, this.nSamplerate, this.fZK, this.fZO * 8);
                this.fZU = (((this.nSamplerate / 1000) * this.cIb) * this.fZL) * 2;
                if (this.cop != null && this.fZC) {
                    this.cop.requestFocus();
                }
                alY();
                AppMethodBeat.o(55826);
                return;
            } catch (Exception e) {
                if (this.cop != null && this.fZC) {
                    this.cop.Mm();
                }
                alX();
                ab.e("MicroMsg.SpeexPlayer", "playImp : fail, exception = " + e.getMessage());
                ab.e("MicroMsg.SpeexPlayer", "exception:%s", bo.l(e));
                AppMethodBeat.o(55826);
                return;
            }
        }
        AppMethodBeat.o(55826);
    }

    private void alY() {
        AppMethodBeat.i(55827);
        if (this.aQf != null) {
            try {
                this.aQf.play();
                this.fZM = new Runnable() {
                    /* JADX WARNING: Removed duplicated region for block: B:35:0x00be  */
                    /* JADX WARNING: Removed duplicated region for block: B:131:0x0241  */
                    /* JADX WARNING: Removed duplicated region for block: B:25:0x009a  */
                    /* JADX WARNING: Removed duplicated region for block: B:132:0x024f A:{SYNTHETIC, Splitter:B:132:0x024f} */
                    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a2  */
                    /* JADX WARNING: Removed duplicated region for block: B:35:0x00be  */
                    /* JADX WARNING: Missing block: B:127:0x0224, code skipped:
            if (r12.fZV.status == 3) goto L_0x0081;
     */
                    /* JADX WARNING: Missing block: B:128:0x0226, code skipped:
            java.lang.Thread.sleep(1000);
     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        int i;
                        AppMethodBeat.i(55818);
                        try {
                            com.tencent.qqpinyin.voicerecoapi.b bVar;
                            Process.setThreadPriority(-16);
                            j.this.fZT = com.tencent.mm.vfs.e.openRead(j.this.fileName);
                            while (true) {
                                if (j.this.status != 1 && j.this.status != 2) {
                                    break;
                                }
                                j.this.fZS = j.this.fZT.read(j.this.fZR);
                                if (j.this.fZS != -1) {
                                    com.tencent.qqpinyin.voicerecoapi.a aVar = j.this.fZN;
                                    byte[] bArr = j.this.fZR;
                                    int i2 = j.this.fZS;
                                    if (aVar.AqB != 0) {
                                        if (bArr == null) {
                                            break;
                                        } else if (bArr.length == 0) {
                                            break;
                                        } else {
                                            int nativeTRSpeexDecode = aVar.AqC.nativeTRSpeexDecode(aVar.AqB, bArr, 0, i2, aVar.Aqz);
                                            if (nativeTRSpeexDecode < 0) {
                                                bVar = new com.tencent.qqpinyin.voicerecoapi.b(nativeTRSpeexDecode);
                                                AppMethodBeat.o(55818);
                                                throw bVar;
                                            }
                                            if (nativeTRSpeexDecode == 0) {
                                                bArr = null;
                                            } else {
                                                byte[] bArr2 = new byte[nativeTRSpeexDecode];
                                                System.arraycopy(aVar.Aqz, 0, bArr2, 0, nativeTRSpeexDecode);
                                                bArr = bArr2;
                                            }
                                            if (bArr == null || nativeTRSpeexDecode == 0) {
                                                j.this.status = 0;
                                            } else {
                                                nativeTRSpeexDecode = bArr.length;
                                                i = 0;
                                                while (nativeTRSpeexDecode >= j.this.fZU && j.this.status == 1) {
                                                    if (j.this.fZQ) {
                                                        Thread.sleep(20);
                                                    } else if (!(j.this.aQf == null || j.this.fZQ)) {
                                                        j.this.aQf.write(bArr, i, j.this.fZU);
                                                        i += j.this.fZU;
                                                        nativeTRSpeexDecode -= j.this.fZU;
                                                    }
                                                }
                                                if (nativeTRSpeexDecode < j.this.fZU && nativeTRSpeexDecode > 0 && j.this.aQf != null) {
                                                    j.this.aQf.write(bArr, i, nativeTRSpeexDecode);
                                                }
                                            }
                                        }
                                    } else {
                                        bVar = new com.tencent.qqpinyin.voicerecoapi.b(ZipJNI.UNZ_PARAMERROR);
                                        AppMethodBeat.o(55818);
                                        throw bVar;
                                    }
                                }
                                j.this.status = 0;
                                if (j.this.status == 2) {
                                    synchronized (j.this.fZu) {
                                        try {
                                            ab.v("MicroMsg.SpeexPlayer", "before mOk.notify");
                                            j.this.fZu.notify();
                                            ab.v("MicroMsg.SpeexPlayer", "after mOk.notify");
                                        } catch (Exception e) {
                                            ab.e("MicroMsg.SpeexPlayer", "exception:%s", bo.l(e));
                                        } catch (Throwable th) {
                                            AppMethodBeat.o(55818);
                                        }
                                    }
                                    synchronized (j.this.fZt) {
                                        try {
                                            ab.v("MicroMsg.SpeexPlayer", "before mpause.wait");
                                            j.this.fZt.wait();
                                            ab.v("MicroMsg.SpeexPlayer", "after mpause.wait");
                                        } catch (Exception e2) {
                                            ab.e("MicroMsg.SpeexPlayer", "exception:%s", bo.l(e2));
                                        }
                                    }
                                } else {
                                    synchronized (j.this.fZu) {
                                        try {
                                            j.this.fZu.notify();
                                        } catch (Exception e22) {
                                            ab.e("MicroMsg.SpeexPlayer", "exception:%s", bo.l(e22));
                                        }
                                    }
                                }
                            }
                            bVar = new com.tencent.qqpinyin.voicerecoapi.b(ZipJNI.UNZ_INTERNALERROR);
                            AppMethodBeat.o(55818);
                            throw bVar;
                        } catch (Exception e222) {
                            ab.e("MicroMsg.SpeexPlayer", "exception:%s", bo.l(e222));
                            if (j.this.fZF != null) {
                                j.this.fZF.onError(null, 0, 0);
                            }
                            j.this.status = 0;
                        } catch (Throwable th2) {
                            AppMethodBeat.o(55818);
                        }
                        com.tencent.qqpinyin.voicerecoapi.a aVar2;
                        if (j.this.fZT != null) {
                            try {
                                j.this.fZT.close();
                            } catch (IOException e3) {
                                ab.e("MicroMsg.SpeexPlayer", "exception:%s", bo.l(e3));
                            }
                            j.this.fZT = null;
                        }
                        aVar2 = j.this.fZN;
                        if (aVar2.AqB != 0) {
                            i = ZipJNI.UNZ_PARAMERROR;
                        } else {
                            aVar2.Aqz = null;
                            i = aVar2.AqC.nativeTRSpeexDecodeRelease(aVar2.AqB);
                            aVar2.AqB = 0;
                        }
                        if (j.this.status == 3) {
                            if (j.this.fZI != null) {
                                j.this.fZI.EA();
                            }
                            if (j.this.fZE != null) {
                                j.this.fZE.onCompletion(null);
                            }
                        } else {
                            try {
                                j.this.alX();
                            } catch (Exception e4) {
                            }
                        }
                        if (i != 0) {
                            ab.e("MicroMsg.SpeexPlayer", "res: ".concat(String.valueOf(i)));
                        }
                        AppMethodBeat.o(55818);
                        if (i != 0) {
                        }
                        AppMethodBeat.o(55818);
                        j.this.fZT = null;
                        aVar2 = j.this.fZN;
                        if (aVar2.AqB != 0) {
                        }
                        if (j.this.status == 3) {
                        }
                        if (i != 0) {
                        }
                        AppMethodBeat.o(55818);
                    }
                };
                d.post(this.fZM, "SpeexPlayer_play");
            } catch (Exception e) {
                ab.e("MicroMsg.SpeexPlayer", "audioTrack error:%s", e.getMessage());
                AppMethodBeat.o(55827);
                return;
            }
        }
        AppMethodBeat.o(55827);
    }

    public final boolean bn(boolean z) {
        AppMethodBeat.i(55828);
        if (this.status != 1) {
            AppMethodBeat.o(55828);
            return false;
        }
        this.status = 2;
        synchronized (this.fZu) {
            try {
                ab.v("MicroMsg.SpeexPlayer", "before mOk.wait");
                long currentTimeMillis = System.currentTimeMillis();
                this.fZu.wait();
                ab.v("MicroMsg.SpeexPlayer", "after mOk.wait time:" + (System.currentTimeMillis() - currentTimeMillis));
                if (this.cop != null && z && this.fZC) {
                    this.cop.Mm();
                }
            } catch (Exception e) {
                ab.e("MicroMsg.SpeexPlayer", "exception:%s", bo.l(e));
                if (this.cop != null && z && this.fZC) {
                    this.cop.Mm();
                }
                AppMethodBeat.o(55828);
                return false;
            } catch (Throwable th) {
                AppMethodBeat.o(55828);
                throw th;
            }
        }
        AppMethodBeat.o(55828);
        return true;
    }

    public final boolean Ew() {
        AppMethodBeat.i(55829);
        if (this.status != 2) {
            AppMethodBeat.o(55829);
            return false;
        }
        this.status = 1;
        synchronized (this.fZt) {
            try {
                ab.v("MicroMsg.SpeexPlayer", "before mpause.notify");
                this.fZt.notify();
                ab.v("MicroMsg.SpeexPlayer", "after mpause.notify");
                if (this.cop != null && this.fZC) {
                    this.cop.requestFocus();
                }
            } catch (Exception e) {
                ab.e("MicroMsg.SpeexPlayer", "exception:%s", bo.l(e));
                if (this.cop != null && this.fZC) {
                    this.cop.requestFocus();
                }
                AppMethodBeat.o(55829);
                return false;
            } catch (Throwable th) {
                AppMethodBeat.o(55829);
                throw th;
            }
        }
        AppMethodBeat.o(55829);
        return true;
    }

    public final boolean isPlaying() {
        return this.status == 1;
    }

    public final boolean EH() {
        AppMethodBeat.i(55830);
        ab.e("MicroMsg.SpeexPlayer", "stop  status:" + this.status);
        if (this.status == 1 || this.status == 2) {
            this.status = 3;
            synchronized (this.fZt) {
                try {
                    this.fZt.notify();
                    if (this.cop != null && this.fZC) {
                        this.cop.Mm();
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.SpeexPlayer", "exception:%s", bo.l(e));
                    alX();
                    if (this.cop != null && this.fZC) {
                        this.cop.Mm();
                    }
                    AppMethodBeat.o(55830);
                    return false;
                } catch (Throwable th) {
                    AppMethodBeat.o(55830);
                    throw th;
                }
            }
            AppMethodBeat.o(55830);
            return true;
        }
        ab.e("MicroMsg.SpeexPlayer", "stop  error status:" + this.status);
        try {
            synchronized (this.fZt) {
                this.fZt.notify();
            }
            synchronized (this.fZu) {
                this.fZu.notify();
            }
        } catch (Exception e2) {
        } catch (Throwable th2) {
            while (true) {
                AppMethodBeat.o(55830);
                throw th2;
            }
        }
        this.status = 3;
        AppMethodBeat.o(55830);
        return false;
    }

    public final double Ez() {
        return 0.0d;
    }

    public final void b(b.a aVar) {
        AppMethodBeat.i(55831);
        if (!(aVar == null || this.cop == null)) {
            this.cop.a(aVar);
        }
        AppMethodBeat.o(55831);
    }

    public final void alP() {
        this.fZC = false;
    }
}
