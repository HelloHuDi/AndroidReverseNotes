package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.api;
import com.tencent.mm.protocal.protobuf.apj;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.hl;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

public final class b extends c {
    private String[] bQQ;
    private byte[] cPB;
    private byte[] gcA;
    private byte[] gcE;
    private int uin;
    private int woP = 0;
    private int xvP = 0;
    private final int xvQ = 5;
    private com.tencent.mm.sandbox.b.a xvR;
    private a xvS = null;
    private com.tencent.mm.sandbox.b.a xvT = new com.tencent.mm.sandbox.b.a() {
        public final void b(int i, int i2, btd btd) {
            AppMethodBeat.i(28843);
            if (i == 200 && i2 == 0 && (btd == null || btd.getBaseResponse().Ret == 0)) {
                apj apj = (apj) btd;
                ab.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : file dir = " + e.eSl);
                ab.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : total len = " + apj.ptw);
                ab.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : start pos = " + apj.ptx);
                ab.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : data len = " + apj.pty);
                if (apj.pty <= 0 || apj.ptz == null) {
                    ab.e("MicroMsg.NetSceneGetUpdatePack", "data is null");
                    b.this.xvR.b(i, -1, null);
                    AppMethodBeat.o(28843);
                } else if (apj.ptz.getILen() != apj.pty) {
                    ab.e("MicroMsg.NetSceneGetUpdatePack", "data len not match with data buf, dataLen = " + apj.pty + " data buf len = " + apj.ptz.getILen());
                    b.this.xvR.b(4, -1, null);
                    AppMethodBeat.o(28843);
                } else if (apj.ptx < 0 || apj.ptx + apj.pty > apj.ptw) {
                    ab.e("MicroMsg.NetSceneGetUpdatePack", "startPos = " + apj.ptx + " dataLen = " + apj.pty + " totalLen = " + apj.ptw);
                    b.this.xvR.b(4, -1, null);
                    AppMethodBeat.o(28843);
                } else if (apj.ptw <= 0) {
                    ab.e("MicroMsg.NetSceneGetUpdatePack", "totalLen is invalid: totalLen = " + apj.ptw);
                    b.this.xvR.b(4, -1, null);
                    AppMethodBeat.o(28843);
                } else {
                    String str = c.xvv;
                    String d = b.this.xvz;
                    int b = com.tencent.mm.a.e.b(str, d + ".temp", apj.ptz.getBuffer().toByteArray());
                    if (b != 0) {
                        ab.e("MicroMsg.NetSceneGetUpdatePack", "appendBuf failed : ".concat(String.valueOf(b)));
                        b.this.xvR.b(4, -1, null);
                        AppMethodBeat.o(28843);
                        return;
                    }
                    b.this.xvy = apj.pty + apj.ptx;
                    b.this.xvx = apj.ptw;
                    b.this.xvR.dN(apj.ptw, apj.ptx);
                    if (apj.ptx + apj.pty >= apj.ptw) {
                        try {
                            if (b.this.xvz.equalsIgnoreCase(g.cz(b.e(b.this)))) {
                                com.tencent.mm.a.e.h(c.xvv, b.this.xvz + ".temp", b.this.xvz + ".apk");
                                b.this.xvR.b(200, 0, btd);
                                AppMethodBeat.o(28843);
                                return;
                            }
                            ab.e("MicroMsg.NetSceneGetUpdatePack", "update pack check error");
                            new File(b.i(b.this)).delete();
                            b.this.xvR.b(-1, -1, btd);
                            AppMethodBeat.o(28843);
                            return;
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e, "", new Object[0]);
                            AppMethodBeat.o(28843);
                            return;
                        }
                    }
                    b.this.a(b.this.xvR);
                    AppMethodBeat.o(28843);
                }
            } else if (b.this.dnf() || b.a(b.this) >= b.this.bQQ.length * 5) {
                b.this.xvR.b(i, i2, btd);
                AppMethodBeat.o(28843);
            } else {
                b.this.a(b.this.xvR);
                AppMethodBeat.o(28843);
            }
        }

        public final void mm(long j) {
            AppMethodBeat.i(28844);
            b.this.xvR.mm(j);
            AppMethodBeat.o(28844);
        }

        public final void mn(long j) {
            AppMethodBeat.i(28845);
            b.this.xvR.mn(j);
            AppMethodBeat.o(28845);
        }

        public final void dN(int i, int i2) {
        }
    };

    class a extends AsyncTask<api, Integer, apj> {
        private String host = null;
        private u pvF = null;
        private com.tencent.mm.sandbox.b.a xvR = null;
        private int xvV = 200;
        private PInt xvW = new PInt();

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.i(28850);
            apj a = a((api[]) objArr);
            AppMethodBeat.o(28850);
            return a;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(28849);
            apj apj = (apj) obj;
            ab.d("MicroMsg.NetSceneGetUpdatePack", "onPostExecute, netRet=" + this.xvV + ", svrRet=" + this.xvW.value + ", result=" + apj);
            this.xvR.b(this.xvV, this.xvW.value, apj);
            AppMethodBeat.o(28849);
        }

        public a(String str, com.tencent.mm.sandbox.b.a aVar) {
            AppMethodBeat.i(28846);
            this.host = str;
            this.xvR = aVar;
            AppMethodBeat.o(28846);
        }

        /* JADX WARNING: Removed duplicated region for block: B:91:0x02bf A:{SYNTHETIC, Splitter:B:91:0x02bf} */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x02c4 A:{SYNTHETIC, Splitter:B:94:0x02c4} */
        /* JADX WARNING: Removed duplicated region for block: B:98:0x02cb  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x02bf A:{SYNTHETIC, Splitter:B:91:0x02bf} */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x02c4 A:{SYNTHETIC, Splitter:B:94:0x02c4} */
        /* JADX WARNING: Removed duplicated region for block: B:98:0x02cb  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x02bf A:{SYNTHETIC, Splitter:B:91:0x02bf} */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x02c4 A:{SYNTHETIC, Splitter:B:94:0x02c4} */
        /* JADX WARNING: Removed duplicated region for block: B:98:0x02cb  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private apj a(api... apiArr) {
            Exception e;
            InputStream inputStream;
            Throwable th;
            AppMethodBeat.i(28847);
            if (apiArr.length == 0 || apiArr[0] == null) {
                this.xvV = -1;
                AppMethodBeat.o(28847);
                return null;
            }
            ab.d("MicroMsg.NetSceneGetUpdatePack", "doInBackground, params=" + apiArr[0]);
            api api = apiArr[0];
            PByteArray pByteArray = new PByteArray();
            int i = 6;
            if (com.tencent.mm.sdk.a.b.foreground) {
                i = 7;
            }
            try {
                byte[] toByteArray = api.toByteArray();
                int i2 = 0;
                if (!(bo.cb(b.this.gcE) || bo.cb(toByteArray))) {
                    i2 = MMProtocalJni.genSignature(b.this.uin, b.this.gcE, toByteArray);
                }
                MMProtocalJni.pack(toByteArray, pByteArray, b.this.gcA, 0, b.this.cPB, q.LM(), b.this.uin, 113, 0, new byte[0], new byte[0], i2, i, 0);
                OutputStream outputStream = null;
                InputStream inputStream2 = null;
                try {
                    this.pvF = com.tencent.mm.network.b.a("http://" + this.host + "/cgi-bin/micromsg-bin/getupdatepack", null);
                    this.pvF.setRequestMethod("POST");
                    this.pvF.amX();
                    this.pvF.amY();
                    this.pvF.setUseCaches(false);
                    this.pvF.setRequestProperty("User-Agent", "Android QQMail HTTP Client");
                    this.pvF.setRequestProperty("Connection", "Keep-Alive");
                    this.pvF.setRequestProperty("Cache-Control", "no-cache");
                    this.pvF.setRequestProperty("Content-Type", "application/octet-stream");
                    this.pvF.setRequestProperty("accept", "*/*");
                    this.pvF.setRequestProperty("Accept-Charset", "UTF-8");
                    this.pvF.setConnectTimeout(15000);
                    this.pvF.connect();
                    OutputStream outputStream2 = this.pvF.getOutputStream();
                    try {
                        outputStream2.write(pByteArray.value);
                        outputStream2.flush();
                        this.xvR.mm(150 + ((long) pByteArray.value.length));
                        this.xvV = this.pvF.getResponseCode();
                        if (this.xvV != 200) {
                            if (outputStream2 != null) {
                                try {
                                    outputStream2.close();
                                } catch (IOException e2) {
                                    ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e2, "", new Object[0]);
                                }
                            }
                            if (this.pvF != null) {
                                this.pvF.connection.disconnect();
                                this.pvF = null;
                            }
                            AppMethodBeat.o(28847);
                            return null;
                        }
                        Object obj;
                        InputStream inputStream3;
                        String headerField = this.pvF.getHeaderField("Content-Encoding");
                        InputStream inputStream4 = this.pvF.getInputStream();
                        long j = 150;
                        if (headerField == null || !headerField.contains("gzip")) {
                            obj = null;
                            inputStream3 = inputStream4;
                        } else {
                            inputStream3 = new GZIPInputStream(inputStream4);
                            obj = 1;
                        }
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                            while (true) {
                                int read = inputStream3.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                                j += (long) read;
                            }
                            if (obj == null || !inputStream4.markSupported()) {
                                this.xvR.mn(j);
                            } else {
                                inputStream4.mark(1);
                                j = 150;
                                while (true) {
                                    int read2 = inputStream4.read(bArr);
                                    if (read2 <= 0) {
                                        break;
                                    }
                                    j += (long) read2;
                                }
                                this.xvR.mn(j);
                            }
                            PByteArray pByteArray2 = new PByteArray();
                            MMProtocalJni.unpack(pByteArray2, byteArrayOutputStream.toByteArray(), b.this.gcA, new PByteArray(), this.xvW, new PInt(), new PInt(0), new PInt(255));
                            apj apj = (apj) new apj().parseFrom(pByteArray2.value);
                            if (outputStream2 != null) {
                                try {
                                    outputStream2.close();
                                } catch (IOException e3) {
                                    ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e3, "", new Object[0]);
                                }
                            }
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (IOException e32) {
                                    ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e32, "", new Object[0]);
                                }
                            }
                            if (this.pvF != null) {
                                this.pvF.connection.disconnect();
                                this.pvF = null;
                            }
                            AppMethodBeat.o(28847);
                            return apj;
                        } catch (Exception e4) {
                            e = e4;
                            inputStream = inputStream3;
                            outputStream = outputStream2;
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream2 = inputStream3;
                            outputStream = outputStream2;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e322) {
                                    ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e322, "", new Object[0]);
                                }
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException e3222) {
                                    ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e3222, "", new Object[0]);
                                }
                            }
                            if (this.pvF != null) {
                                this.pvF.connection.disconnect();
                                this.pvF = null;
                            }
                            AppMethodBeat.o(28847);
                            throw th;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        inputStream = null;
                        outputStream = outputStream2;
                        try {
                            ab.e("MicroMsg.NetSceneGetUpdatePack", "Exception in doInBackground, [%s]", e.getMessage());
                            ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e, "", new Object[0]);
                            this.xvV = -1;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e22) {
                                    ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e22, "", new Object[0]);
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e222) {
                                    ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e222, "", new Object[0]);
                                }
                            }
                            if (this.pvF != null) {
                                this.pvF.connection.disconnect();
                                this.pvF = null;
                            }
                            AppMethodBeat.o(28847);
                            return null;
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream2 = inputStream;
                            if (outputStream != null) {
                            }
                            if (inputStream2 != null) {
                            }
                            if (this.pvF != null) {
                            }
                            AppMethodBeat.o(28847);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        outputStream = outputStream2;
                        if (outputStream != null) {
                        }
                        if (inputStream2 != null) {
                        }
                        if (this.pvF != null) {
                        }
                        AppMethodBeat.o(28847);
                        throw th;
                    }
                } catch (Exception e6) {
                    e = e6;
                    inputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (outputStream != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    if (this.pvF != null) {
                    }
                    AppMethodBeat.o(28847);
                    throw th;
                }
            } catch (Exception e7) {
                ab.e("MicroMsg.NetSceneGetUpdatePack", "Exception in MMProtocalJni.pack(), [%s]", e7.getMessage());
                ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e7, "", new Object[0]);
                AppMethodBeat.o(28847);
                return null;
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final void onCancelled() {
            AppMethodBeat.i(28848);
            ab.d("MicroMsg.NetSceneGetUpdatePack", "task had been cancelled.");
            if (this.pvF != null) {
                this.pvF.connection.disconnect();
            }
            AppMethodBeat.o(28848);
        }
    }

    static /* synthetic */ String e(b bVar) {
        AppMethodBeat.i(28854);
        String alN = bVar.alN();
        AppMethodBeat.o(28854);
        return alN;
    }

    static /* synthetic */ String i(b bVar) {
        AppMethodBeat.i(28855);
        String alN = bVar.alN();
        AppMethodBeat.o(28855);
        return alN;
    }

    public b(int i, String str, int i2, int i3, byte[] bArr, byte[] bArr2, String[] strArr, boolean z) {
        super(i, str, i2, z);
        AppMethodBeat.i(28851);
        this.bQQ = strArr;
        if (strArr == null || strArr.length == 0) {
            this.bQQ = new String[]{"short.weixin.qq.com"};
        }
        this.uin = i3;
        this.gcA = bArr;
        this.cPB = bArr2;
        AppMethodBeat.o(28851);
    }

    public final void a(com.tencent.mm.sandbox.b.a aVar) {
        AppMethodBeat.i(28852);
        this.xvR = aVar;
        int i = this.xvP + 1;
        this.xvP = i;
        if (i > 1000) {
            ab.d("MicroMsg.NetSceneGetUpdatePack", "doSceneCnt > DOSCENE_LIMIT, return");
            this.xvR.b(-1, -1, null);
            AppMethodBeat.o(28852);
        } else if (f.eW((long) this.xvx)) {
            api api = new api();
            hl hlVar = new hl();
            hlVar.vKd = d.vxo;
            hlVar.Scene = 0;
            hlVar.luF = this.uin;
            hlVar.vKc = com.tencent.mm.bt.b.bI(q.LM().getBytes());
            if (hlVar.vKc.wR.length >= 16) {
                hlVar.vKc = hlVar.vKc.Lv(16);
            }
            hlVar.vKe = com.tencent.mm.bt.b.bI(d.eSg.getBytes());
            if (hlVar.vKe.wR.length >= 132) {
                hlVar.vKe = hlVar.vKe.Lv(132);
            }
            hlVar.vKb = com.tencent.mm.bt.b.bI(this.gcA);
            if (hlVar.vKb.wR.length >= 36) {
                hlVar.vKb = hlVar.vKb.Lv(36);
            }
            api.setBaseRequest(hlVar);
            api.wth = this.xvw;
            api.ptx = this.xvy;
            api.ptw = this.xvx;
            a aVar2 = new a(this.bQQ[this.woP / 5], this.xvT);
            this.xvS = aVar2;
            aVar2.execute(new api[]{api});
            AppMethodBeat.o(28852);
        } else {
            ab.e("MicroMsg.NetSceneGetUpdatePack", "SDCard full, packSize=[%s]", Integer.valueOf(this.xvx));
            aVar.b(-1, -1, null);
            AppMethodBeat.o(28852);
        }
    }

    public final void cancel() {
        AppMethodBeat.i(28853);
        ab.i("MicroMsg.NetSceneGetUpdatePack", "do cancel, updateType = " + this.xvw);
        if (!(this.xvS == null || this.xvS.isCancelled())) {
            this.xvS.cancel(true);
        }
        AppMethodBeat.o(28853);
    }
}
