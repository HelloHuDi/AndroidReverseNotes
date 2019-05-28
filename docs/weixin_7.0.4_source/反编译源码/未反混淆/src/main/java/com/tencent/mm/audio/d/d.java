package com.tencent.mm.audio.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public final class d implements a {
    private com.tencent.qqpinyin.voicerecoapi.a crB;
    private a crC;
    BlockingQueue<com.tencent.mm.audio.b.g.a> crn = new ArrayBlockingQueue(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    boolean cro = false;
    String crp;
    private OutputStream crw;

    final class a implements Runnable {
        final /* synthetic */ d crD;

        public final void run() {
            AppMethodBeat.i(55774);
            while (true) {
                boolean z;
                synchronized (this.crD) {
                    try {
                        z = this.crD.cro;
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(55774);
                    }
                }
                ab.d("MicroMsg.SpeexWriter", "ThreadSpeex in: " + z + " queueLen: " + this.crD.crn.size());
                if (z && this.crD.crn.isEmpty()) {
                    break;
                }
                try {
                    com.tencent.mm.audio.b.g.a aVar = (com.tencent.mm.audio.b.g.a) this.crD.crn.poll(200, TimeUnit.MILLISECONDS);
                    if (aVar == null) {
                        ab.e("MicroMsg.SpeexWriter", "poll byteBuf is null, " + this.crD.crp);
                    } else {
                        this.crD.a(aVar, 0, false);
                    }
                } catch (InterruptedException e) {
                    ab.i("MicroMsg.SpeexWriter", "ThreadSpeex poll null");
                }
            }
        }
    }

    public d() {
        AppMethodBeat.i(55775);
        AppMethodBeat.o(55775);
    }

    public final boolean eo(String str) {
        AppMethodBeat.i(55776);
        ab.i("MicroMsg.SpeexWriter", "initWriter, path: ".concat(String.valueOf(str)));
        if (str == null) {
            AppMethodBeat.o(55776);
            return false;
        }
        this.crp = str;
        try {
            this.crw = e.L(str, false);
            this.crB = new com.tencent.qqpinyin.voicerecoapi.a();
            int dPS = this.crB.dPS();
            if (dPS != 0) {
                ab.e("MicroMsg.SpeexWriter", "speexInit failed: ".concat(String.valueOf(dPS)));
                AppMethodBeat.o(55776);
                return false;
            }
            AppMethodBeat.o(55776);
            return true;
        } catch (Exception e) {
            if (this.crw != null) {
                try {
                    this.crw.close();
                } catch (IOException e2) {
                }
            }
            ab.e("MicroMsg.SpeexWriter", "Error on init file: ", e);
            AppMethodBeat.o(55776);
            return false;
        }
    }

    public final int a(com.tencent.mm.audio.b.g.a aVar) {
        AppMethodBeat.i(55777);
        int a = a(aVar, 0, false);
        AppMethodBeat.o(55777);
        return a;
    }

    public final int a(com.tencent.mm.audio.b.g.a aVar, int i, boolean z) {
        int i2 = -1;
        AppMethodBeat.i(55778);
        if (this.crB == null || aVar.buf == null || aVar.cqs == 0) {
            ab.e("MicroMsg.SpeexWriter", "try write invalid data to file");
            AppMethodBeat.o(55778);
        } else {
            try {
                byte[] Z = this.crB.Z(aVar.buf, aVar.cqs);
                if (Z == null || Z.length <= 0) {
                    ab.e("MicroMsg.SpeexWriter", "convert failed: " + (Z == null ? "outBuffer is null" : "size is zero"));
                    AppMethodBeat.o(55778);
                } else {
                    ab.d("MicroMsg.SpeexWriter", "write to file, len: %d", Integer.valueOf(Z.length));
                    this.crw.write(Z);
                    this.crw.flush();
                    i2 = Z.length;
                    AppMethodBeat.o(55778);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.SpeexWriter", "write to file failed", e);
                AppMethodBeat.o(55778);
            }
        }
        return i2;
    }

    public final void Fe() {
        AppMethodBeat.i(55779);
        ab.i("MicroMsg.SpeexWriter", "wait Stop");
        synchronized (this) {
            try {
                this.cro = true;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(55779);
                }
            }
        }
        if (this.crC != null) {
            try {
                com.tencent.mm.sdk.g.d.xDG.an(this.crC);
                this.crC = null;
            } catch (InterruptedException e) {
                ab.e("MicroMsg.SpeexWriter", "thread speex interrupted");
            } catch (ExecutionException e2) {
                ab.e("MicroMsg.SpeexWriter", "ExecutionException:%s", e2.toString());
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
                ab.e("MicroMsg.SpeexWriter", "close silk file: " + this.crp + "msg: " + e3.getMessage());
            }
            this.crw = null;
        }
        AppMethodBeat.o(55779);
    }

    public final boolean Ff() {
        AppMethodBeat.i(55780);
        if (this.crB != null) {
            this.crB.dPT();
            this.crB = null;
        }
        this.crB = new com.tencent.qqpinyin.voicerecoapi.a();
        int dPS = this.crB.dPS();
        if (dPS != 0) {
            ab.e("MicroMsg.SpeexWriter", "resetWriter speexInit failed: ".concat(String.valueOf(dPS)));
            AppMethodBeat.o(55780);
            return false;
        }
        AppMethodBeat.o(55780);
        return true;
    }

    public static boolean G(String str, String str2) {
        AppMethodBeat.i(55781);
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() <= 0) {
            ab.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
            AppMethodBeat.o(55781);
            return false;
        }
        b bVar = new b(str);
        if (bVar.exists()) {
            ab.i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex pcmLen = " + bVar.length());
            try {
                com.tencent.qqpinyin.voicerecoapi.a aVar = new com.tencent.qqpinyin.voicerecoapi.a();
                if (aVar.dPS() != 0) {
                    ab.e("MicroMsg.SpeexWriter", "[voiceControl] speexInit fail");
                    aVar.dPT();
                    AppMethodBeat.o(55781);
                    return false;
                }
                e.deleteFile(str2);
                new b(str2).createNewFile();
                InputStream inputStream = null;
                try {
                    byte[] bArr = new byte[4096];
                    inputStream = e.openRead(str);
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            byte[] Z = aVar.Z(bArr, read);
                            if (Z == null) {
                                inputStream.close();
                                AppMethodBeat.o(55781);
                                return false;
                            }
                            ab.i("MicroMsg.SpeexWriter", "[voiceControl] appendToFile " + e.a(str2, Z, Z.length) + ", readLen = " + read);
                        } else {
                            inputStream.close();
                            aVar.dPT();
                            ab.i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex = " + (System.currentTimeMillis() - currentTimeMillis));
                            AppMethodBeat.o(55781);
                            return true;
                        }
                    }
                } catch (Exception e) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    aVar.dPT();
                    AppMethodBeat.o(55781);
                    return false;
                }
            } catch (Exception e2) {
                ab.e("MicroMsg.SpeexWriter", "[voiceControl] Exception in decodePCMToSpeex, " + e2.getMessage());
                AppMethodBeat.o(55781);
                return false;
            }
        }
        ab.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
        AppMethodBeat.o(55781);
        return false;
    }
}
