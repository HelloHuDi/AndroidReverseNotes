package com.tencent.p177mm.audio.p1180d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p195b.C32304g.C32305a;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.qqpinyin.voicerecoapi.C36413a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.audio.d.d */
public final class C41768d implements C25835a {
    private C36413a crB;
    private C37483a crC;
    BlockingQueue<C32305a> crn = new ArrayBlockingQueue(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    boolean cro = false;
    String crp;
    private OutputStream crw;

    /* renamed from: com.tencent.mm.audio.d.d$a */
    final class C37483a implements Runnable {
        final /* synthetic */ C41768d crD;

        public final void run() {
            AppMethodBeat.m2504i(55774);
            while (true) {
                boolean z;
                synchronized (this.crD) {
                    try {
                        z = this.crD.cro;
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(55774);
                    }
                }
                C4990ab.m7410d("MicroMsg.SpeexWriter", "ThreadSpeex in: " + z + " queueLen: " + this.crD.crn.size());
                if (z && this.crD.crn.isEmpty()) {
                    break;
                }
                try {
                    C32305a c32305a = (C32305a) this.crD.crn.poll(200, TimeUnit.MILLISECONDS);
                    if (c32305a == null) {
                        C4990ab.m7412e("MicroMsg.SpeexWriter", "poll byteBuf is null, " + this.crD.crp);
                    } else {
                        this.crD.mo43823a(c32305a, 0, false);
                    }
                } catch (InterruptedException e) {
                    C4990ab.m7416i("MicroMsg.SpeexWriter", "ThreadSpeex poll null");
                }
            }
        }
    }

    public C41768d() {
        AppMethodBeat.m2504i(55775);
        AppMethodBeat.m2505o(55775);
    }

    /* renamed from: eo */
    public final boolean mo43824eo(String str) {
        AppMethodBeat.m2504i(55776);
        C4990ab.m7416i("MicroMsg.SpeexWriter", "initWriter, path: ".concat(String.valueOf(str)));
        if (str == null) {
            AppMethodBeat.m2505o(55776);
            return false;
        }
        this.crp = str;
        try {
            this.crw = C5730e.m8617L(str, false);
            this.crB = new C36413a();
            int dPS = this.crB.dPS();
            if (dPS != 0) {
                C4990ab.m7412e("MicroMsg.SpeexWriter", "speexInit failed: ".concat(String.valueOf(dPS)));
                AppMethodBeat.m2505o(55776);
                return false;
            }
            AppMethodBeat.m2505o(55776);
            return true;
        } catch (Exception e) {
            if (this.crw != null) {
                try {
                    this.crw.close();
                } catch (IOException e2) {
                }
            }
            C4990ab.m7413e("MicroMsg.SpeexWriter", "Error on init file: ", e);
            AppMethodBeat.m2505o(55776);
            return false;
        }
    }

    /* renamed from: a */
    public final int mo43822a(C32305a c32305a) {
        AppMethodBeat.m2504i(55777);
        int a = mo43823a(c32305a, 0, false);
        AppMethodBeat.m2505o(55777);
        return a;
    }

    /* renamed from: a */
    public final int mo43823a(C32305a c32305a, int i, boolean z) {
        int i2 = -1;
        AppMethodBeat.m2504i(55778);
        if (this.crB == null || c32305a.buf == null || c32305a.cqs == 0) {
            C4990ab.m7412e("MicroMsg.SpeexWriter", "try write invalid data to file");
            AppMethodBeat.m2505o(55778);
        } else {
            try {
                byte[] Z = this.crB.mo57384Z(c32305a.buf, c32305a.cqs);
                if (Z == null || Z.length <= 0) {
                    C4990ab.m7412e("MicroMsg.SpeexWriter", "convert failed: " + (Z == null ? "outBuffer is null" : "size is zero"));
                    AppMethodBeat.m2505o(55778);
                } else {
                    C4990ab.m7411d("MicroMsg.SpeexWriter", "write to file, len: %d", Integer.valueOf(Z.length));
                    this.crw.write(Z);
                    this.crw.flush();
                    i2 = Z.length;
                    AppMethodBeat.m2505o(55778);
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.SpeexWriter", "write to file failed", e);
                AppMethodBeat.m2505o(55778);
            }
        }
        return i2;
    }

    /* renamed from: Fe */
    public final void mo43820Fe() {
        AppMethodBeat.m2504i(55779);
        C4990ab.m7416i("MicroMsg.SpeexWriter", "wait Stop");
        synchronized (this) {
            try {
                this.cro = true;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(55779);
                }
            }
        }
        if (this.crC != null) {
            try {
                C7305d.xDG.mo10149an(this.crC);
                this.crC = null;
            } catch (InterruptedException e) {
                C4990ab.m7412e("MicroMsg.SpeexWriter", "thread speex interrupted");
            } catch (ExecutionException e2) {
                C4990ab.m7413e("MicroMsg.SpeexWriter", "ExecutionException:%s", e2.toString());
            }
        }
        if (this.crB != null) {
            this.crB.dPT();
            this.crB = null;
        }
        if (this.crw != null) {
            try {
                this.crw.close();
            } catch (Exception e3) {
                C4990ab.m7412e("MicroMsg.SpeexWriter", "close silk file: " + this.crp + "msg: " + e3.getMessage());
            }
            this.crw = null;
        }
        AppMethodBeat.m2505o(55779);
    }

    /* renamed from: Ff */
    public final boolean mo43821Ff() {
        AppMethodBeat.m2504i(55780);
        if (this.crB != null) {
            this.crB.dPT();
            this.crB = null;
        }
        this.crB = new C36413a();
        int dPS = this.crB.dPS();
        if (dPS != 0) {
            C4990ab.m7412e("MicroMsg.SpeexWriter", "resetWriter speexInit failed: ".concat(String.valueOf(dPS)));
            AppMethodBeat.m2505o(55780);
            return false;
        }
        AppMethodBeat.m2505o(55780);
        return true;
    }

    /* renamed from: G */
    public static boolean m73722G(String str, String str2) {
        AppMethodBeat.m2504i(55781);
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() <= 0) {
            C4990ab.m7412e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
            AppMethodBeat.m2505o(55781);
            return false;
        }
        C5728b c5728b = new C5728b(str);
        if (c5728b.exists()) {
            C4990ab.m7416i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex pcmLen = " + c5728b.length());
            try {
                C36413a c36413a = new C36413a();
                if (c36413a.dPS() != 0) {
                    C4990ab.m7412e("MicroMsg.SpeexWriter", "[voiceControl] speexInit fail");
                    c36413a.dPT();
                    AppMethodBeat.m2505o(55781);
                    return false;
                }
                C5730e.deleteFile(str2);
                new C5728b(str2).createNewFile();
                InputStream inputStream = null;
                try {
                    byte[] bArr = new byte[4096];
                    inputStream = C5730e.openRead(str);
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            byte[] Z = c36413a.mo57384Z(bArr, read);
                            if (Z == null) {
                                inputStream.close();
                                AppMethodBeat.m2505o(55781);
                                return false;
                            }
                            C4990ab.m7416i("MicroMsg.SpeexWriter", "[voiceControl] appendToFile " + C5730e.m8619a(str2, Z, Z.length) + ", readLen = " + read);
                        } else {
                            inputStream.close();
                            c36413a.dPT();
                            C4990ab.m7416i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex = " + (System.currentTimeMillis() - currentTimeMillis));
                            AppMethodBeat.m2505o(55781);
                            return true;
                        }
                    }
                } catch (Exception e) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    c36413a.dPT();
                    AppMethodBeat.m2505o(55781);
                    return false;
                }
            } catch (Exception e2) {
                C4990ab.m7412e("MicroMsg.SpeexWriter", "[voiceControl] Exception in decodePCMToSpeex, " + e2.getMessage());
                AppMethodBeat.m2505o(55781);
                return false;
            }
        }
        C4990ab.m7412e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
        AppMethodBeat.m2505o(55781);
        return false;
    }
}
