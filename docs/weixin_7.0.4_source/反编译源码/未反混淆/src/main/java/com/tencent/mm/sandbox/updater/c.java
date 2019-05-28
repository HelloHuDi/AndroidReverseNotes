package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public final class c extends com.tencent.mm.sandbox.monitor.c {
    private String cdy;
    private int exv = 0;
    private boolean fIa = false;
    private String nun;
    private com.tencent.mm.sandbox.b.a xvR;
    private String[] xvX;
    private a xvY = null;
    private boolean xvZ = false;
    private ak xwa = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(28856);
            if (1 == message.what && !c.this.fIa) {
                new File(c.this.alN()).delete();
                if (message.arg1 == 0) {
                    ab.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "patch ok");
                    c.this.xvR.b(200, 0, (btd) message.obj);
                } else if (message.arg1 == 3) {
                    c.this.xvR.b(3, -1, (btd) message.obj);
                } else if (message.arg1 == 4) {
                    c.this.xvR.b(4, -1, (btd) message.obj);
                }
            }
            super.handleMessage(message);
            AppMethodBeat.o(28856);
        }
    };
    private com.tencent.mm.sandbox.b.a xwb = new com.tencent.mm.sandbox.b.a() {
        public final void dN(int i, int i2) {
            AppMethodBeat.i(28858);
            ab.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "progress, total=" + i + ", offset=" + i2);
            c.this.xvR.dN(i, i2);
            AppMethodBeat.o(28858);
        }

        public final void b(int i, int i2, btd btd) {
            AppMethodBeat.i(28859);
            if (i != 0) {
                ab.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene error. netRet=".concat(String.valueOf(i)));
                if (i == -2) {
                    new File(c.this.alN()).delete();
                }
                c.this.exv = c.this.exv + 1;
                c.this.a(c.this.xvR);
                AppMethodBeat.o(28859);
                return;
            }
            ab.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene success");
            try {
                if (e.cs(c.this.alN()) < c.this.xvx) {
                    ab.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene continue;");
                    c.this.a(c.this.xvR);
                    AppMethodBeat.o(28859);
                } else if (c.this.xvZ) {
                    if (c.this.cdy.equalsIgnoreCase(g.cz(c.this.alN()))) {
                        c.a(c.this, btd);
                        AppMethodBeat.o(28859);
                        return;
                    }
                    ab.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "pack md5 check error");
                    new File(c.this.alN()).delete();
                    c.this.xvR.b(2, -1, btd);
                    AppMethodBeat.o(28859);
                } else if (c.this.xvz.equalsIgnoreCase(g.cz(c.this.alN()))) {
                    e.h(com.tencent.mm.sandbox.monitor.c.xvv, c.this.xvz + ".temp", c.this.xvz + ".apk");
                    c.this.xvR.b(200, 0, btd);
                    AppMethodBeat.o(28859);
                } else {
                    ab.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "update pack check error");
                    new File(c.this.alN()).delete();
                    c.this.xvR.b(-1, -1, btd);
                    AppMethodBeat.o(28859);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "error occured during pack processing");
                ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e, "", new Object[0]);
                c.this.xvR.b(-1, -1, btd);
                AppMethodBeat.o(28859);
            }
        }

        public final void mm(long j) {
            AppMethodBeat.i(28860);
            c.this.xvR.mm(j);
            AppMethodBeat.o(28860);
        }

        public final void mn(long j) {
            AppMethodBeat.i(28861);
            c.this.xvR.mn(j);
            AppMethodBeat.o(28861);
        }
    };

    class a extends AsyncTask<String, Integer, Integer> {
        private int bIF;
        private HttpClient ptV = null;
        private OutputStream sOI = new OutputStream() {
            private ak handler = new ak(Looper.getMainLooper());
            private ByteArrayOutputStream xwh = new ByteArrayOutputStream();

            {
                AppMethodBeat.i(28863);
                AppMethodBeat.o(28863);
            }

            public final void write(byte[] bArr, int i, int i2) {
                AppMethodBeat.i(28864);
                this.xwh.write(bArr, i, i2);
                if (this.xwh.size() >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || a.this.bIF + this.xwh.size() >= a.this.size) {
                    final int size = this.xwh.size();
                    int a = e.a(c.this.alN(), this.xwh.toByteArray(), size);
                    this.xwh.reset();
                    IOException iOException;
                    if (a != 0) {
                        iOException = new IOException("appendToFile failed :".concat(String.valueOf(a)));
                        AppMethodBeat.o(28864);
                        throw iOException;
                    }
                    a.this.bIF = a.this.bIF + size;
                    this.handler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(28862);
                            if (a.this.bIF <= a.this.size) {
                                a.this.xvR.dN(a.this.size, a.this.bIF);
                            }
                            a.this.xvR.mn((long) size);
                            AppMethodBeat.o(28862);
                        }
                    });
                    if (c.this.fIa) {
                        iOException = new IOException("manual force cancel!");
                        AppMethodBeat.o(28864);
                        throw iOException;
                    }
                    AppMethodBeat.o(28864);
                    return;
                }
                AppMethodBeat.o(28864);
            }

            public final void write(int i) {
                AppMethodBeat.i(28865);
                IOException iOException = new IOException("unexpected operation");
                AppMethodBeat.o(28865);
                throw iOException;
            }
        };
        private int size;
        private com.tencent.mm.sandbox.b.a xvR;
        private HttpGet xwe = null;
        private HttpResponse xwf = null;
        private HttpEntity xwg = null;

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.i(28870);
            Integer O = O((String[]) objArr);
            AppMethodBeat.o(28870);
            return O;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(28869);
            this.xvR.b(((Integer) obj).intValue(), 0, null);
            AppMethodBeat.o(28869);
        }

        public a(int i, int i2, com.tencent.mm.sandbox.b.a aVar) {
            AppMethodBeat.i(28866);
            this.size = i;
            this.bIF = i2;
            this.xvR = aVar;
            AppMethodBeat.o(28866);
        }

        private Integer O(String... strArr) {
            AppMethodBeat.i(28867);
            String str = strArr[0];
            Integer valueOf;
            if (str == null || str.length() == 0) {
                valueOf = Integer.valueOf(-1);
                AppMethodBeat.o(28867);
                return valueOf;
            }
            ab.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "current download url=" + str + ", range=" + this.bIF);
            this.ptV = new DefaultHttpClient();
            this.ptV.getParams().setIntParameter("http.connection.timeout", 15000);
            this.xwe = new HttpGet(str);
            this.xwe.addHeader("RANGE", "bytes=" + this.bIF + "-" + (this.size - this.bIF > 1048576 ? Integer.valueOf((this.bIF + 1048576) - 1) : ""));
            this.xvR.mm(50);
            this.xwf = this.ptV.execute(this.xwe);
            int statusCode = this.xwf.getStatusLine().getStatusCode();
            if (statusCode == 200 || statusCode == 206) {
                try {
                    if (c.this.xvZ && ae.gio && Math.random() > 0.2d) {
                        ab.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "simulateNetworkFault");
                        valueOf = Integer.valueOf(-1);
                        if (this.xwe != null) {
                            this.xwe.abort();
                        }
                        if (this.xwg != null) {
                            try {
                                this.xwg.consumeContent();
                            } catch (IOException e) {
                                ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e, "", new Object[0]);
                            }
                        }
                        if (this.ptV != null) {
                            this.ptV.getConnectionManager().shutdown();
                        }
                        AppMethodBeat.o(28867);
                        return valueOf;
                    }
                    this.xwf.getHeaders("Content-Length");
                    if (this.bIF > this.size) {
                        ab.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "range out of size");
                        valueOf = Integer.valueOf(-2);
                        if (this.xwe != null) {
                            this.xwe.abort();
                        }
                        if (this.xwg != null) {
                            try {
                                this.xwg.consumeContent();
                            } catch (IOException e2) {
                                ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e2, "", new Object[0]);
                            }
                        }
                        if (this.ptV != null) {
                            this.ptV.getConnectionManager().shutdown();
                        }
                        AppMethodBeat.o(28867);
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
                            ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e22, "", new Object[0]);
                        }
                    }
                    if (this.ptV != null) {
                        this.ptV.getConnectionManager().shutdown();
                    }
                    AppMethodBeat.o(28867);
                    return valueOf;
                } catch (Exception e3) {
                    ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e3, "", new Object[0]);
                    ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e3, "exception current in download pack", new Object[0]);
                    if (this.xwe != null) {
                        this.xwe.abort();
                    }
                    if (this.xwg != null) {
                        try {
                            this.xwg.consumeContent();
                        } catch (IOException e4) {
                            ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e4, "", new Object[0]);
                        }
                    }
                    if (this.ptV != null) {
                        this.ptV.getConnectionManager().shutdown();
                    }
                    valueOf = Integer.valueOf(-1);
                    AppMethodBeat.o(28867);
                    return valueOf;
                } catch (Throwable th) {
                    if (this.xwe != null) {
                        this.xwe.abort();
                    }
                    if (this.xwg != null) {
                        try {
                            this.xwg.consumeContent();
                        } catch (IOException e222) {
                            ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e222, "", new Object[0]);
                        }
                    }
                    if (this.ptV != null) {
                        this.ptV.getConnectionManager().shutdown();
                    }
                    AppMethodBeat.o(28867);
                }
            } else {
                ab.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "HttpClient return code:".concat(String.valueOf(statusCode)));
                if (statusCode == 416) {
                    valueOf = Integer.valueOf(-2);
                    if (this.xwe != null) {
                        this.xwe.abort();
                    }
                    if (this.xwg != null) {
                        try {
                            this.xwg.consumeContent();
                        } catch (IOException e2222) {
                            ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e2222, "", new Object[0]);
                        }
                    }
                    if (this.ptV != null) {
                        this.ptV.getConnectionManager().shutdown();
                    }
                    AppMethodBeat.o(28867);
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
                        ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e22222, "", new Object[0]);
                    }
                }
                if (this.ptV != null) {
                    this.ptV.getConnectionManager().shutdown();
                }
                AppMethodBeat.o(28867);
                return valueOf;
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final void onCancelled() {
            AppMethodBeat.i(28868);
            ab.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "AsyncTask had been canceled.");
            if (this.xwe != null) {
                this.xwe.abort();
            }
            if (this.xwg != null) {
                try {
                    this.xwg.consumeContent();
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e, "", new Object[0]);
                }
            }
            if (this.ptV != null) {
                ab.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "connection shutdown.");
                this.ptV.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(28868);
        }
    }

    public c(int i, String str, int i2, String[] strArr, boolean z) {
        super(i, str, i2, z);
        AppMethodBeat.i(28871);
        this.xvX = strArr;
        AppMethodBeat.o(28871);
    }

    public c(int i, String str, int i2, String str2, String str3, String str4, boolean z) {
        super(i, str, i2, z);
        AppMethodBeat.i(28872);
        this.xvX = new String[]{str2};
        this.xvZ = true;
        this.cdy = str3;
        this.nun = str4;
        AppMethodBeat.o(28872);
    }

    public final void a(com.tencent.mm.sandbox.b.a aVar) {
        AppMethodBeat.i(28873);
        this.xvR = aVar;
        if (!h.getExternalStorageState().equals("mounted")) {
            ab.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard not available.");
            aVar.b(-1, -1, null);
            AppMethodBeat.o(28873);
        } else if (this.fIa) {
            ab.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "netscene had been canceled.");
            aVar.b(-1, -1, null);
            AppMethodBeat.o(28873);
        } else if (dnf() || dnm() >= this.xvX.length) {
            ab.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exceed max download url. url count = " + this.xvX.length);
            if (this.xvZ) {
                aVar.b(1, -1, null);
                AppMethodBeat.o(28873);
                return;
            }
            aVar.b(-1, -1, null);
            AppMethodBeat.o(28873);
        } else if (f.eW((long) this.xvx)) {
            this.xvY = new a(this.xvx, e.cs(alN()), this.xwb);
            this.xvY.execute(new String[]{this.xvX[dnm()]});
            AppMethodBeat.o(28873);
        } else {
            ab.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard full");
            if (this.xvZ) {
                aVar.b(13, -1, null);
                AppMethodBeat.o(28873);
                return;
            }
            aVar.b(-1, -1, null);
            AppMethodBeat.o(28873);
        }
    }

    public final String alN() {
        AppMethodBeat.i(28874);
        String str;
        if (this.xvZ) {
            str = xvv + this.cdy + ".temp";
            AppMethodBeat.o(28874);
            return str;
        }
        str = super.alN();
        AppMethodBeat.o(28874);
        return str;
    }

    public final String dne() {
        AppMethodBeat.i(28875);
        String str;
        if (this.xvZ) {
            str = xvv + this.nun + ".apk";
            AppMethodBeat.o(28875);
            return str;
        }
        str = xvv + this.xvz + ".apk";
        AppMethodBeat.o(28875);
        return str;
    }

    public final void cancel() {
        AppMethodBeat.i(28876);
        ab.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "cancel netscene");
        this.fIa = true;
        if (!(this.xvY == null || this.xvY.isCancelled())) {
            this.xvY.cancel(true);
        }
        AppMethodBeat.o(28876);
    }

    private int dnm() {
        AppMethodBeat.i(28877);
        ab.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "requestCount=" + this.exv + ", curLinkIdx = " + (this.exv / 5));
        int i = this.exv / 5;
        AppMethodBeat.o(28877);
        return i;
    }

    static /* synthetic */ void a(c cVar, final btd btd) {
        AppMethodBeat.i(28878);
        try {
            ab.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "in genNewAPKInNewThread()");
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(28857);
                    ab.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch start");
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.obj = btd;
                    Long valueOf = Long.valueOf(System.currentTimeMillis());
                    int g = i.g(ah.getContext(), c.this.alN(), c.this.dne(), c.this.nun);
                    ab.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "gen new apk finish, time cost = " + (System.currentTimeMillis() - valueOf.longValue()));
                    if (g == 0) {
                        ab.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch ok");
                        obtain.arg1 = 0;
                        c.this.xwa.sendMessage(obtain);
                        AppMethodBeat.o(28857);
                        return;
                    }
                    ab.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "updateByPatch error in genNewAPKInNewThread()");
                    File file = new File(c.this.dne());
                    if (file.exists()) {
                        file.delete();
                    }
                    if (g == -1) {
                        ab.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "RET_GEN_APK_ERR");
                        obtain.arg1 = 3;
                        c.this.xwa.sendMessage(obtain);
                        AppMethodBeat.o(28857);
                    } else if (g == -2) {
                        ab.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "RET_APK_MD5_ERR");
                        obtain.arg1 = 4;
                        c.this.xwa.sendMessage(obtain);
                        AppMethodBeat.o(28857);
                    } else {
                        AppMethodBeat.o(28857);
                    }
                }
            }, "NetSceneGetUpdatePackFromCDN_genApk");
            AppMethodBeat.o(28878);
        } catch (Exception e) {
            ab.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exception in genNewAPKInNewThread()");
            ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e, "", new Object[0]);
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = 3;
            obtain.obj = btd;
            cVar.xwa.sendMessage(obtain);
            AppMethodBeat.o(28878);
        }
    }
}
