package com.tencent.p177mm.sandbox.updater;

import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.sandbox.C35974b.C30268a;
import com.tencent.p177mm.sandbox.monitor.C15412c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/* renamed from: com.tencent.mm.sandbox.updater.c */
public final class C40609c extends C15412c {
    private String cdy;
    private int exv = 0;
    private boolean fIa = false;
    private String nun;
    private C30268a xvR;
    private String[] xvX;
    private C40607a xvY = null;
    private boolean xvZ = false;
    private C7306ak xwa = new C234831();
    private C30268a xwb = new C314893();

    /* renamed from: com.tencent.mm.sandbox.updater.c$1 */
    class C234831 extends C7306ak {
        C234831() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(28856);
            if (1 == message.what && !C40609c.this.fIa) {
                new File(C40609c.this.alN()).delete();
                if (message.arg1 == 0) {
                    C4990ab.m7410d("MicroMsg.NetSceneGetUpdatePackFromCDN", "patch ok");
                    C40609c.this.xvR.mo27462b(200, 0, (btd) message.obj);
                } else if (message.arg1 == 3) {
                    C40609c.this.xvR.mo27462b(3, -1, (btd) message.obj);
                } else if (message.arg1 == 4) {
                    C40609c.this.xvR.mo27462b(4, -1, (btd) message.obj);
                }
            }
            super.handleMessage(message);
            AppMethodBeat.m2505o(28856);
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.c$3 */
    class C314893 implements C30268a {
        C314893() {
        }

        /* renamed from: dN */
        public final void mo27463dN(int i, int i2) {
            AppMethodBeat.m2504i(28858);
            C4990ab.m7410d("MicroMsg.NetSceneGetUpdatePackFromCDN", "progress, total=" + i + ", offset=" + i2);
            C40609c.this.xvR.mo27463dN(i, i2);
            AppMethodBeat.m2505o(28858);
        }

        /* renamed from: b */
        public final void mo27462b(int i, int i2, btd btd) {
            AppMethodBeat.m2504i(28859);
            if (i != 0) {
                C4990ab.m7412e("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene error. netRet=".concat(String.valueOf(i)));
                if (i == -2) {
                    new File(C40609c.this.alN()).delete();
                }
                C40609c.this.exv = C40609c.this.exv + 1;
                C40609c.this.mo56706a(C40609c.this.xvR);
                AppMethodBeat.m2505o(28859);
                return;
            }
            C4990ab.m7416i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene success");
            try {
                if (C1173e.m2560cs(C40609c.this.alN()) < C40609c.this.xvx) {
                    C4990ab.m7416i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene continue;");
                    C40609c.this.mo56706a(C40609c.this.xvR);
                    AppMethodBeat.m2505o(28859);
                } else if (C40609c.this.xvZ) {
                    if (C40609c.this.cdy.equalsIgnoreCase(C1178g.m2587cz(C40609c.this.alN()))) {
                        C40609c.m70028a(C40609c.this, btd);
                        AppMethodBeat.m2505o(28859);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.NetSceneGetUpdatePackFromCDN", "pack md5 check error");
                    new File(C40609c.this.alN()).delete();
                    C40609c.this.xvR.mo27462b(2, -1, btd);
                    AppMethodBeat.m2505o(28859);
                } else if (C40609c.this.xvz.equalsIgnoreCase(C1178g.m2587cz(C40609c.this.alN()))) {
                    C1173e.m2572h(C15412c.xvv, C40609c.this.xvz + ".temp", C40609c.this.xvz + ".apk");
                    C40609c.this.xvR.mo27462b(200, 0, btd);
                    AppMethodBeat.m2505o(28859);
                } else {
                    C4990ab.m7412e("MicroMsg.NetSceneGetUpdatePackFromCDN", "update pack check error");
                    new File(C40609c.this.alN()).delete();
                    C40609c.this.xvR.mo27462b(-1, -1, btd);
                    AppMethodBeat.m2505o(28859);
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.NetSceneGetUpdatePackFromCDN", "error occured during pack processing");
                C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e, "", new Object[0]);
                C40609c.this.xvR.mo27462b(-1, -1, btd);
                AppMethodBeat.m2505o(28859);
            }
        }

        /* renamed from: mm */
        public final void mo27453mm(long j) {
            AppMethodBeat.m2504i(28860);
            C40609c.this.xvR.mo27453mm(j);
            AppMethodBeat.m2505o(28860);
        }

        /* renamed from: mn */
        public final void mo27454mn(long j) {
            AppMethodBeat.m2504i(28861);
            C40609c.this.xvR.mo27454mn(j);
            AppMethodBeat.m2505o(28861);
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.c$a */
    class C40607a extends AsyncTask<String, Integer, Integer> {
        private int bIF;
        private HttpClient ptV = null;
        private OutputStream sOI = new C406081();
        private int size;
        private C30268a xvR;
        private HttpGet xwe = null;
        private HttpResponse xwf = null;
        private HttpEntity xwg = null;

        /* renamed from: com.tencent.mm.sandbox.updater.c$a$1 */
        class C406081 extends OutputStream {
            private C7306ak handler = new C7306ak(Looper.getMainLooper());
            private ByteArrayOutputStream xwh = new ByteArrayOutputStream();

            C406081() {
                AppMethodBeat.m2504i(28863);
                AppMethodBeat.m2505o(28863);
            }

            public final void write(byte[] bArr, int i, int i2) {
                AppMethodBeat.m2504i(28864);
                this.xwh.write(bArr, i, i2);
                if (this.xwh.size() >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || C40607a.this.bIF + this.xwh.size() >= C40607a.this.size) {
                    final int size = this.xwh.size();
                    int a = C1173e.m2557a(C40609c.this.alN(), this.xwh.toByteArray(), size);
                    this.xwh.reset();
                    IOException iOException;
                    if (a != 0) {
                        iOException = new IOException("appendToFile failed :".concat(String.valueOf(a)));
                        AppMethodBeat.m2505o(28864);
                        throw iOException;
                    }
                    C40607a.this.bIF = C40607a.this.bIF + size;
                    this.handler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(28862);
                            if (C40607a.this.bIF <= C40607a.this.size) {
                                C40607a.this.xvR.mo27463dN(C40607a.this.size, C40607a.this.bIF);
                            }
                            C40607a.this.xvR.mo27454mn((long) size);
                            AppMethodBeat.m2505o(28862);
                        }
                    });
                    if (C40609c.this.fIa) {
                        iOException = new IOException("manual force cancel!");
                        AppMethodBeat.m2505o(28864);
                        throw iOException;
                    }
                    AppMethodBeat.m2505o(28864);
                    return;
                }
                AppMethodBeat.m2505o(28864);
            }

            public final void write(int i) {
                AppMethodBeat.m2504i(28865);
                IOException iOException = new IOException("unexpected operation");
                AppMethodBeat.m2505o(28865);
                throw iOException;
            }
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.m2504i(28870);
            Integer O = m70023O((String[]) objArr);
            AppMethodBeat.m2505o(28870);
            return O;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(28869);
            this.xvR.mo27462b(((Integer) obj).intValue(), 0, null);
            AppMethodBeat.m2505o(28869);
        }

        public C40607a(int i, int i2, C30268a c30268a) {
            AppMethodBeat.m2504i(28866);
            this.size = i;
            this.bIF = i2;
            this.xvR = c30268a;
            AppMethodBeat.m2505o(28866);
        }

        /* renamed from: O */
        private Integer m70023O(String... strArr) {
            AppMethodBeat.m2504i(28867);
            String str = strArr[0];
            Integer valueOf;
            if (str == null || str.length() == 0) {
                valueOf = Integer.valueOf(-1);
                AppMethodBeat.m2505o(28867);
                return valueOf;
            }
            C4990ab.m7416i("MicroMsg.NetSceneGetUpdatePackFromCDN", "current download url=" + str + ", range=" + this.bIF);
            this.ptV = new DefaultHttpClient();
            this.ptV.getParams().setIntParameter("http.connection.timeout", 15000);
            this.xwe = new HttpGet(str);
            this.xwe.addHeader("RANGE", "bytes=" + this.bIF + "-" + (this.size - this.bIF > 1048576 ? Integer.valueOf((this.bIF + 1048576) - 1) : ""));
            this.xvR.mo27453mm(50);
            this.xwf = this.ptV.execute(this.xwe);
            int statusCode = this.xwf.getStatusLine().getStatusCode();
            if (statusCode == 200 || statusCode == 206) {
                try {
                    if (C40609c.this.xvZ && C1947ae.gio && Math.random() > 0.2d) {
                        C4990ab.m7410d("MicroMsg.NetSceneGetUpdatePackFromCDN", "simulateNetworkFault");
                        valueOf = Integer.valueOf(-1);
                        if (this.xwe != null) {
                            this.xwe.abort();
                        }
                        if (this.xwg != null) {
                            try {
                                this.xwg.consumeContent();
                            } catch (IOException e) {
                                C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e, "", new Object[0]);
                            }
                        }
                        if (this.ptV != null) {
                            this.ptV.getConnectionManager().shutdown();
                        }
                        AppMethodBeat.m2505o(28867);
                        return valueOf;
                    }
                    this.xwf.getHeaders("Content-Length");
                    if (this.bIF > this.size) {
                        C4990ab.m7412e("MicroMsg.NetSceneGetUpdatePackFromCDN", "range out of size");
                        valueOf = Integer.valueOf(-2);
                        if (this.xwe != null) {
                            this.xwe.abort();
                        }
                        if (this.xwg != null) {
                            try {
                                this.xwg.consumeContent();
                            } catch (IOException e2) {
                                C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e2, "", new Object[0]);
                            }
                        }
                        if (this.ptV != null) {
                            this.ptV.getConnectionManager().shutdown();
                        }
                        AppMethodBeat.m2505o(28867);
                        return valueOf;
                    }
                    this.xwg = this.xwf.getEntity();
                    this.xwg.writeTo(this.sOI);
                    this.xwg.consumeContent();
                    valueOf = Integer.valueOf(0);
                    if (this.xwe != null) {
                        this.xwe.abort();
                    }
                    if (this.xwg != null) {
                        try {
                            this.xwg.consumeContent();
                        } catch (IOException e22) {
                            C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e22, "", new Object[0]);
                        }
                    }
                    if (this.ptV != null) {
                        this.ptV.getConnectionManager().shutdown();
                    }
                    AppMethodBeat.m2505o(28867);
                    return valueOf;
                } catch (Exception e3) {
                    C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e3, "", new Object[0]);
                    C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e3, "exception current in download pack", new Object[0]);
                    if (this.xwe != null) {
                        this.xwe.abort();
                    }
                    if (this.xwg != null) {
                        try {
                            this.xwg.consumeContent();
                        } catch (IOException e4) {
                            C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e4, "", new Object[0]);
                        }
                    }
                    if (this.ptV != null) {
                        this.ptV.getConnectionManager().shutdown();
                    }
                    valueOf = Integer.valueOf(-1);
                    AppMethodBeat.m2505o(28867);
                    return valueOf;
                } catch (Throwable th) {
                    if (this.xwe != null) {
                        this.xwe.abort();
                    }
                    if (this.xwg != null) {
                        try {
                            this.xwg.consumeContent();
                        } catch (IOException e222) {
                            C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e222, "", new Object[0]);
                        }
                    }
                    if (this.ptV != null) {
                        this.ptV.getConnectionManager().shutdown();
                    }
                    AppMethodBeat.m2505o(28867);
                }
            } else {
                C4990ab.m7412e("MicroMsg.NetSceneGetUpdatePackFromCDN", "HttpClient return code:".concat(String.valueOf(statusCode)));
                if (statusCode == 416) {
                    valueOf = Integer.valueOf(-2);
                    if (this.xwe != null) {
                        this.xwe.abort();
                    }
                    if (this.xwg != null) {
                        try {
                            this.xwg.consumeContent();
                        } catch (IOException e2222) {
                            C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e2222, "", new Object[0]);
                        }
                    }
                    if (this.ptV != null) {
                        this.ptV.getConnectionManager().shutdown();
                    }
                    AppMethodBeat.m2505o(28867);
                    return valueOf;
                }
                valueOf = Integer.valueOf(-1);
                if (this.xwe != null) {
                    this.xwe.abort();
                }
                if (this.xwg != null) {
                    try {
                        this.xwg.consumeContent();
                    } catch (IOException e22222) {
                        C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e22222, "", new Object[0]);
                    }
                }
                if (this.ptV != null) {
                    this.ptV.getConnectionManager().shutdown();
                }
                AppMethodBeat.m2505o(28867);
                return valueOf;
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final void onCancelled() {
            AppMethodBeat.m2504i(28868);
            C4990ab.m7410d("MicroMsg.NetSceneGetUpdatePackFromCDN", "AsyncTask had been canceled.");
            if (this.xwe != null) {
                this.xwe.abort();
            }
            if (this.xwg != null) {
                try {
                    this.xwg.consumeContent();
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e, "", new Object[0]);
                }
            }
            if (this.ptV != null) {
                C4990ab.m7410d("MicroMsg.NetSceneGetUpdatePackFromCDN", "connection shutdown.");
                this.ptV.getConnectionManager().shutdown();
            }
            AppMethodBeat.m2505o(28868);
        }
    }

    public C40609c(int i, String str, int i2, String[] strArr, boolean z) {
        super(i, str, i2, z);
        AppMethodBeat.m2504i(28871);
        this.xvX = strArr;
        AppMethodBeat.m2505o(28871);
    }

    public C40609c(int i, String str, int i2, String str2, String str3, String str4, boolean z) {
        super(i, str, i2, z);
        AppMethodBeat.m2504i(28872);
        this.xvX = new String[]{str2};
        this.xvZ = true;
        this.cdy = str3;
        this.nun = str4;
        AppMethodBeat.m2505o(28872);
    }

    /* renamed from: a */
    public final void mo56706a(C30268a c30268a) {
        AppMethodBeat.m2504i(28873);
        this.xvR = c30268a;
        if (!C1448h.getExternalStorageState().equals("mounted")) {
            C4990ab.m7412e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard not available.");
            c30268a.mo27462b(-1, -1, null);
            AppMethodBeat.m2505o(28873);
        } else if (this.fIa) {
            C4990ab.m7412e("MicroMsg.NetSceneGetUpdatePackFromCDN", "netscene had been canceled.");
            c30268a.mo27462b(-1, -1, null);
            AppMethodBeat.m2505o(28873);
        } else if (dnf() || dnm() >= this.xvX.length) {
            C4990ab.m7412e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exceed max download url. url count = " + this.xvX.length);
            if (this.xvZ) {
                c30268a.mo27462b(1, -1, null);
                AppMethodBeat.m2505o(28873);
                return;
            }
            c30268a.mo27462b(-1, -1, null);
            AppMethodBeat.m2505o(28873);
        } else if (C1445f.m3072eW((long) this.xvx)) {
            this.xvY = new C40607a(this.xvx, C1173e.m2560cs(alN()), this.xwb);
            this.xvY.execute(new String[]{this.xvX[dnm()]});
            AppMethodBeat.m2505o(28873);
        } else {
            C4990ab.m7412e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard full");
            if (this.xvZ) {
                c30268a.mo27462b(13, -1, null);
                AppMethodBeat.m2505o(28873);
                return;
            }
            c30268a.mo27462b(-1, -1, null);
            AppMethodBeat.m2505o(28873);
        }
    }

    public final String alN() {
        AppMethodBeat.m2504i(28874);
        String str;
        if (this.xvZ) {
            str = xvv + this.cdy + ".temp";
            AppMethodBeat.m2505o(28874);
            return str;
        }
        str = super.alN();
        AppMethodBeat.m2505o(28874);
        return str;
    }

    public final String dne() {
        AppMethodBeat.m2504i(28875);
        String str;
        if (this.xvZ) {
            str = xvv + this.nun + ".apk";
            AppMethodBeat.m2505o(28875);
            return str;
        }
        str = xvv + this.xvz + ".apk";
        AppMethodBeat.m2505o(28875);
        return str;
    }

    public final void cancel() {
        AppMethodBeat.m2504i(28876);
        C4990ab.m7410d("MicroMsg.NetSceneGetUpdatePackFromCDN", "cancel netscene");
        this.fIa = true;
        if (!(this.xvY == null || this.xvY.isCancelled())) {
            this.xvY.cancel(true);
        }
        AppMethodBeat.m2505o(28876);
    }

    private int dnm() {
        AppMethodBeat.m2504i(28877);
        C4990ab.m7416i("MicroMsg.NetSceneGetUpdatePackFromCDN", "requestCount=" + this.exv + ", curLinkIdx = " + (this.exv / 5));
        int i = this.exv / 5;
        AppMethodBeat.m2505o(28877);
        return i;
    }

    /* renamed from: a */
    static /* synthetic */ void m70028a(C40609c c40609c, final btd btd) {
        AppMethodBeat.m2504i(28878);
        try {
            C4990ab.m7410d("MicroMsg.NetSceneGetUpdatePackFromCDN", "in genNewAPKInNewThread()");
            C7305d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(28857);
                    C4990ab.m7410d("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch start");
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.obj = btd;
                    Long valueOf = Long.valueOf(System.currentTimeMillis());
                    int g = C44212i.m79790g(C4996ah.getContext(), C40609c.this.alN(), C40609c.this.dne(), C40609c.this.nun);
                    C4990ab.m7416i("MicroMsg.NetSceneGetUpdatePackFromCDN", "gen new apk finish, time cost = " + (System.currentTimeMillis() - valueOf.longValue()));
                    if (g == 0) {
                        C4990ab.m7410d("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch ok");
                        obtain.arg1 = 0;
                        C40609c.this.xwa.sendMessage(obtain);
                        AppMethodBeat.m2505o(28857);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch error in genNewAPKInNewThread()");
                    File file = new File(C40609c.this.dne());
                    if (file.exists()) {
                        file.delete();
                    }
                    if (g == -1) {
                        C4990ab.m7410d("MicroMsg.NetSceneGetUpdatePackFromCDN", "RET_GEN_APK_ERR");
                        obtain.arg1 = 3;
                        C40609c.this.xwa.sendMessage(obtain);
                        AppMethodBeat.m2505o(28857);
                    } else if (g == -2) {
                        C4990ab.m7410d("MicroMsg.NetSceneGetUpdatePackFromCDN", "RET_APK_MD5_ERR");
                        obtain.arg1 = 4;
                        C40609c.this.xwa.sendMessage(obtain);
                        AppMethodBeat.m2505o(28857);
                    } else {
                        AppMethodBeat.m2505o(28857);
                    }
                }
            }, "NetSceneGetUpdatePackFromCDN_genApk");
            AppMethodBeat.m2505o(28878);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exception in genNewAPKInNewThread()");
            C4990ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e, "", new Object[0]);
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = 3;
            obtain.obj = btd;
            c40609c.xwa.sendMessage(obtain);
            AppMethodBeat.m2505o(28878);
        }
    }
}
