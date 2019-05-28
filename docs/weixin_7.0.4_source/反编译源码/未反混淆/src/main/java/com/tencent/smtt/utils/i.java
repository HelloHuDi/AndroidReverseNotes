package com.tencent.smtt.utils;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.d.a;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

final class i extends Thread {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    i(String str, a aVar) {
        this.a = str;
        this.b = aVar;
    }

    public final void run() {
        InputStream inputStream;
        OutputStream d;
        Throwable e;
        AppMethodBeat.i(65203);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://soft.tbs.imtt.qq.com/17421/tbs_res_imtt_tbs_DebugPlugin_DebugPlugin.tbs").openConnection();
            int contentLength = httpURLConnection.getContentLength();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();
            inputStream = httpURLConnection.getInputStream();
            try {
                d = k.d(new File(this.a));
            } catch (Exception e2) {
                e = e2;
                d = null;
                try {
                    this.b.a(e);
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                    }
                    try {
                        d.close();
                    } catch (Exception e4) {
                    }
                    AppMethodBeat.o(65203);
                } catch (Throwable th) {
                    e = th;
                    try {
                        inputStream.close();
                    } catch (Exception e5) {
                    }
                    try {
                        d.close();
                    } catch (Exception e6) {
                    }
                    AppMethodBeat.o(65203);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                d = null;
                inputStream.close();
                d.close();
                AppMethodBeat.o(65203);
                throw e;
            }
            try {
                byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                int i = 0;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    i += read;
                    d.write(bArr, 0, read);
                    this.b.a((i * 100) / contentLength);
                }
                this.b.a();
                try {
                    inputStream.close();
                } catch (Exception e7) {
                }
                try {
                    d.close();
                } catch (Exception e8) {
                }
                AppMethodBeat.o(65203);
            } catch (Exception e9) {
                e = e9;
                this.b.a(e);
                inputStream.close();
                d.close();
                AppMethodBeat.o(65203);
            }
        } catch (Exception e10) {
            e = e10;
            d = null;
            inputStream = null;
        } catch (Throwable th3) {
            e = th3;
            d = null;
            inputStream = null;
            inputStream.close();
            d.close();
            AppMethodBeat.o(65203);
            throw e;
        }
    }
}
