package com.tencent.p177mm.sandbox.updater;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.network.C1936u;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.MMProtocalJni;
import com.tencent.p177mm.protocal.protobuf.C15318api;
import com.tencent.p177mm.protocal.protobuf.C7267hl;
import com.tencent.p177mm.protocal.protobuf.apj;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.sandbox.C35974b.C30268a;
import com.tencent.p177mm.sandbox.monitor.C15412c;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

/* renamed from: com.tencent.mm.sandbox.updater.b */
public final class C46611b extends C15412c {
    private String[] bQQ;
    private byte[] cPB;
    private byte[] gcA;
    private byte[] gcE;
    private int uin;
    private int woP = 0;
    private int xvP = 0;
    private final int xvQ = 5;
    private C30268a xvR;
    private C35978a xvS = null;
    private C30268a xvT = new C154161();

    /* renamed from: com.tencent.mm.sandbox.updater.b$1 */
    class C154161 implements C30268a {
        C154161() {
        }

        /* renamed from: b */
        public final void mo27462b(int i, int i2, btd btd) {
            AppMethodBeat.m2504i(28843);
            if (i == 200 && i2 == 0 && (btd == null || btd.getBaseResponse().Ret == 0)) {
                apj apj = (apj) btd;
                C4990ab.m7410d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : file dir = " + C6457e.eSl);
                C4990ab.m7410d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : total len = " + apj.ptw);
                C4990ab.m7410d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : start pos = " + apj.ptx);
                C4990ab.m7410d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : data len = " + apj.pty);
                if (apj.pty <= 0 || apj.ptz == null) {
                    C4990ab.m7412e("MicroMsg.NetSceneGetUpdatePack", "data is null");
                    C46611b.this.xvR.mo27462b(i, -1, null);
                    AppMethodBeat.m2505o(28843);
                } else if (apj.ptz.getILen() != apj.pty) {
                    C4990ab.m7412e("MicroMsg.NetSceneGetUpdatePack", "data len not match with data buf, dataLen = " + apj.pty + " data buf len = " + apj.ptz.getILen());
                    C46611b.this.xvR.mo27462b(4, -1, null);
                    AppMethodBeat.m2505o(28843);
                } else if (apj.ptx < 0 || apj.ptx + apj.pty > apj.ptw) {
                    C4990ab.m7412e("MicroMsg.NetSceneGetUpdatePack", "startPos = " + apj.ptx + " dataLen = " + apj.pty + " totalLen = " + apj.ptw);
                    C46611b.this.xvR.mo27462b(4, -1, null);
                    AppMethodBeat.m2505o(28843);
                } else if (apj.ptw <= 0) {
                    C4990ab.m7412e("MicroMsg.NetSceneGetUpdatePack", "totalLen is invalid: totalLen = " + apj.ptw);
                    C46611b.this.xvR.mo27462b(4, -1, null);
                    AppMethodBeat.m2505o(28843);
                } else {
                    String str = C15412c.xvv;
                    String d = C46611b.this.xvz;
                    int b = C1173e.m2558b(str, d + ".temp", apj.ptz.getBuffer().toByteArray());
                    if (b != 0) {
                        C4990ab.m7412e("MicroMsg.NetSceneGetUpdatePack", "appendBuf failed : ".concat(String.valueOf(b)));
                        C46611b.this.xvR.mo27462b(4, -1, null);
                        AppMethodBeat.m2505o(28843);
                        return;
                    }
                    C46611b.this.xvy = apj.pty + apj.ptx;
                    C46611b.this.xvx = apj.ptw;
                    C46611b.this.xvR.mo27463dN(apj.ptw, apj.ptx);
                    if (apj.ptx + apj.pty >= apj.ptw) {
                        try {
                            if (C46611b.this.xvz.equalsIgnoreCase(C1178g.m2587cz(C46611b.m88155e(C46611b.this)))) {
                                C1173e.m2572h(C15412c.xvv, C46611b.this.xvz + ".temp", C46611b.this.xvz + ".apk");
                                C46611b.this.xvR.mo27462b(200, 0, btd);
                                AppMethodBeat.m2505o(28843);
                                return;
                            }
                            C4990ab.m7412e("MicroMsg.NetSceneGetUpdatePack", "update pack check error");
                            new File(C46611b.m88159i(C46611b.this)).delete();
                            C46611b.this.xvR.mo27462b(-1, -1, btd);
                            AppMethodBeat.m2505o(28843);
                            return;
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e, "", new Object[0]);
                            AppMethodBeat.m2505o(28843);
                            return;
                        }
                    }
                    C46611b.this.mo56706a(C46611b.this.xvR);
                    AppMethodBeat.m2505o(28843);
                }
            } else if (C46611b.this.dnf() || C46611b.m88149a(C46611b.this) >= C46611b.this.bQQ.length * 5) {
                C46611b.this.xvR.mo27462b(i, i2, btd);
                AppMethodBeat.m2505o(28843);
            } else {
                C46611b.this.mo56706a(C46611b.this.xvR);
                AppMethodBeat.m2505o(28843);
            }
        }

        /* renamed from: mm */
        public final void mo27453mm(long j) {
            AppMethodBeat.m2504i(28844);
            C46611b.this.xvR.mo27453mm(j);
            AppMethodBeat.m2505o(28844);
        }

        /* renamed from: mn */
        public final void mo27454mn(long j) {
            AppMethodBeat.m2504i(28845);
            C46611b.this.xvR.mo27454mn(j);
            AppMethodBeat.m2505o(28845);
        }

        /* renamed from: dN */
        public final void mo27463dN(int i, int i2) {
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.b$a */
    class C35978a extends AsyncTask<C15318api, Integer, apj> {
        private String host = null;
        private C1936u pvF = null;
        private C30268a xvR = null;
        private int xvV = 200;
        private PInt xvW = new PInt();

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.m2504i(28850);
            apj a = m59185a((C15318api[]) objArr);
            AppMethodBeat.m2505o(28850);
            return a;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(28849);
            apj apj = (apj) obj;
            C4990ab.m7410d("MicroMsg.NetSceneGetUpdatePack", "onPostExecute, netRet=" + this.xvV + ", svrRet=" + this.xvW.value + ", result=" + apj);
            this.xvR.mo27462b(this.xvV, this.xvW.value, apj);
            AppMethodBeat.m2505o(28849);
        }

        public C35978a(String str, C30268a c30268a) {
            AppMethodBeat.m2504i(28846);
            this.host = str;
            this.xvR = c30268a;
            AppMethodBeat.m2505o(28846);
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
        /* renamed from: a */
        private apj m59185a(C15318api... c15318apiArr) {
            Exception e;
            InputStream inputStream;
            Throwable th;
            AppMethodBeat.m2504i(28847);
            if (c15318apiArr.length == 0 || c15318apiArr[0] == null) {
                this.xvV = -1;
                AppMethodBeat.m2505o(28847);
                return null;
            }
            C4990ab.m7410d("MicroMsg.NetSceneGetUpdatePack", "doInBackground, params=" + c15318apiArr[0]);
            C15318api c15318api = c15318apiArr[0];
            PByteArray pByteArray = new PByteArray();
            int i = 6;
            if (C4872b.foreground) {
                i = 7;
            }
            try {
                byte[] toByteArray = c15318api.toByteArray();
                int i2 = 0;
                if (!(C5046bo.m7540cb(C46611b.this.gcE) || C5046bo.m7540cb(toByteArray))) {
                    i2 = MMProtocalJni.genSignature(C46611b.this.uin, C46611b.this.gcE, toByteArray);
                }
                MMProtocalJni.pack(toByteArray, pByteArray, C46611b.this.gcA, 0, C46611b.this.cPB, C1427q.m3028LM(), C46611b.this.uin, 113, 0, new byte[0], new byte[0], i2, i, 0);
                OutputStream outputStream = null;
                InputStream inputStream2 = null;
                try {
                    this.pvF = C1897b.m4020a("http://" + this.host + "/cgi-bin/micromsg-bin/getupdatepack", null);
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
                        this.xvR.mo27453mm(150 + ((long) pByteArray.value.length));
                        this.xvV = this.pvF.getResponseCode();
                        if (this.xvV != 200) {
                            if (outputStream2 != null) {
                                try {
                                    outputStream2.close();
                                } catch (IOException e2) {
                                    C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e2, "", new Object[0]);
                                }
                            }
                            if (this.pvF != null) {
                                this.pvF.connection.disconnect();
                                this.pvF = null;
                            }
                            AppMethodBeat.m2505o(28847);
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
                                this.xvR.mo27454mn(j);
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
                                this.xvR.mo27454mn(j);
                            }
                            PByteArray pByteArray2 = new PByteArray();
                            MMProtocalJni.unpack(pByteArray2, byteArrayOutputStream.toByteArray(), C46611b.this.gcA, new PByteArray(), this.xvW, new PInt(), new PInt(0), new PInt(255));
                            apj apj = (apj) new apj().parseFrom(pByteArray2.value);
                            if (outputStream2 != null) {
                                try {
                                    outputStream2.close();
                                } catch (IOException e3) {
                                    C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e3, "", new Object[0]);
                                }
                            }
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (IOException e32) {
                                    C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e32, "", new Object[0]);
                                }
                            }
                            if (this.pvF != null) {
                                this.pvF.connection.disconnect();
                                this.pvF = null;
                            }
                            AppMethodBeat.m2505o(28847);
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
                                    C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e322, "", new Object[0]);
                                }
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException e3222) {
                                    C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e3222, "", new Object[0]);
                                }
                            }
                            if (this.pvF != null) {
                                this.pvF.connection.disconnect();
                                this.pvF = null;
                            }
                            AppMethodBeat.m2505o(28847);
                            throw th;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        inputStream = null;
                        outputStream = outputStream2;
                        try {
                            C4990ab.m7413e("MicroMsg.NetSceneGetUpdatePack", "Exception in doInBackground, [%s]", e.getMessage());
                            C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e, "", new Object[0]);
                            this.xvV = -1;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e22) {
                                    C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e22, "", new Object[0]);
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e222) {
                                    C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e222, "", new Object[0]);
                                }
                            }
                            if (this.pvF != null) {
                                this.pvF.connection.disconnect();
                                this.pvF = null;
                            }
                            AppMethodBeat.m2505o(28847);
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
                            AppMethodBeat.m2505o(28847);
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
                        AppMethodBeat.m2505o(28847);
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
                    AppMethodBeat.m2505o(28847);
                    throw th;
                }
            } catch (Exception e7) {
                C4990ab.m7413e("MicroMsg.NetSceneGetUpdatePack", "Exception in MMProtocalJni.pack(), [%s]", e7.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e7, "", new Object[0]);
                AppMethodBeat.m2505o(28847);
                return null;
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final void onCancelled() {
            AppMethodBeat.m2504i(28848);
            C4990ab.m7410d("MicroMsg.NetSceneGetUpdatePack", "task had been cancelled.");
            if (this.pvF != null) {
                this.pvF.connection.disconnect();
            }
            AppMethodBeat.m2505o(28848);
        }
    }

    /* renamed from: e */
    static /* synthetic */ String m88155e(C46611b c46611b) {
        AppMethodBeat.m2504i(28854);
        String alN = c46611b.alN();
        AppMethodBeat.m2505o(28854);
        return alN;
    }

    /* renamed from: i */
    static /* synthetic */ String m88159i(C46611b c46611b) {
        AppMethodBeat.m2504i(28855);
        String alN = c46611b.alN();
        AppMethodBeat.m2505o(28855);
        return alN;
    }

    public C46611b(int i, String str, int i2, int i3, byte[] bArr, byte[] bArr2, String[] strArr, boolean z) {
        super(i, str, i2, z);
        AppMethodBeat.m2504i(28851);
        this.bQQ = strArr;
        if (strArr == null || strArr.length == 0) {
            this.bQQ = new String[]{"short.weixin.qq.com"};
        }
        this.uin = i3;
        this.gcA = bArr;
        this.cPB = bArr2;
        AppMethodBeat.m2505o(28851);
    }

    /* renamed from: a */
    public final void mo56706a(C30268a c30268a) {
        AppMethodBeat.m2504i(28852);
        this.xvR = c30268a;
        int i = this.xvP + 1;
        this.xvP = i;
        if (i > 1000) {
            C4990ab.m7410d("MicroMsg.NetSceneGetUpdatePack", "doSceneCnt > DOSCENE_LIMIT, return");
            this.xvR.mo27462b(-1, -1, null);
            AppMethodBeat.m2505o(28852);
        } else if (C1445f.m3072eW((long) this.xvx)) {
            C15318api c15318api = new C15318api();
            C7267hl c7267hl = new C7267hl();
            c7267hl.vKd = C7243d.vxo;
            c7267hl.Scene = 0;
            c7267hl.luF = this.uin;
            c7267hl.vKc = C1332b.m2847bI(C1427q.m3028LM().getBytes());
            if (c7267hl.vKc.f1226wR.length >= 16) {
                c7267hl.vKc = c7267hl.vKc.mo4675Lv(16);
            }
            c7267hl.vKe = C1332b.m2847bI(C7243d.eSg.getBytes());
            if (c7267hl.vKe.f1226wR.length >= 132) {
                c7267hl.vKe = c7267hl.vKe.mo4675Lv(132);
            }
            c7267hl.vKb = C1332b.m2847bI(this.gcA);
            if (c7267hl.vKb.f1226wR.length >= 36) {
                c7267hl.vKb = c7267hl.vKb.mo4675Lv(36);
            }
            c15318api.setBaseRequest(c7267hl);
            c15318api.wth = this.xvw;
            c15318api.ptx = this.xvy;
            c15318api.ptw = this.xvx;
            C35978a c35978a = new C35978a(this.bQQ[this.woP / 5], this.xvT);
            this.xvS = c35978a;
            c35978a.execute(new C15318api[]{c15318api});
            AppMethodBeat.m2505o(28852);
        } else {
            C4990ab.m7413e("MicroMsg.NetSceneGetUpdatePack", "SDCard full, packSize=[%s]", Integer.valueOf(this.xvx));
            c30268a.mo27462b(-1, -1, null);
            AppMethodBeat.m2505o(28852);
        }
    }

    public final void cancel() {
        AppMethodBeat.m2504i(28853);
        C4990ab.m7416i("MicroMsg.NetSceneGetUpdatePack", "do cancel, updateType = " + this.xvw);
        if (!(this.xvS == null || this.xvS.isCancelled())) {
            this.xvS.cancel(true);
        }
        AppMethodBeat.m2505o(28853);
    }
}
