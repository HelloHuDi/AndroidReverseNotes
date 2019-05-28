package com.tencent.xweb.xwalk;

import android.os.Handler;
import android.os.HandlerThread;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.f;
import java.net.URL;
import java.nio.ByteBuffer;
import org.xwalk.core.XWalkV8;

public final class h implements f {
    XWalkV8 ASa;
    HandlerThread ASb = new HandlerThread("j2v8");
    private Handler ASc;

    public h() {
        AppMethodBeat.i(85241);
        this.ASb.start();
        this.ASc = new Handler(this.ASb.getLooper());
        AppMethodBeat.o(85241);
    }

    public final void init(final int i) {
        AppMethodBeat.i(85242);
        this.ASc.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(85237);
                if (h.this.ASa != null) {
                    AppMethodBeat.o(85237);
                    return;
                }
                h.this.ASa = new XWalkV8();
                h.this.ASa.init(i);
                AppMethodBeat.o(85237);
            }
        });
        AppMethodBeat.o(85242);
    }

    public final void pause() {
    }

    public final void resume() {
    }

    public final void cleanup() {
        AppMethodBeat.i(85243);
        this.ASc.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(85238);
                if (h.this.ASa == null) {
                    AppMethodBeat.o(85238);
                    return;
                }
                h.this.ASa.cleanup();
                h.this.ASa = null;
                h.this.ASb.getLooper().quit();
                h.this.ASb = null;
                AppMethodBeat.o(85238);
            }
        });
        AppMethodBeat.o(85243);
    }

    public final boolean dTW() {
        return false;
    }

    public final void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        AppMethodBeat.i(85244);
        this.ASc.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(85239);
                if (h.this.ASa == null) {
                    AppMethodBeat.o(85239);
                    return;
                }
                h.this.ASa.evaluateJavascript(str, valueCallback);
                AppMethodBeat.o(85239);
            }
        });
        AppMethodBeat.o(85244);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        AppMethodBeat.i(85245);
        evaluateJavascript(str, valueCallback);
        AppMethodBeat.o(85245);
    }

    public final void addJavascriptInterface(final Object obj, final String str) {
        AppMethodBeat.i(85246);
        this.ASc.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(85240);
                if (h.this.ASa == null) {
                    AppMethodBeat.o(85240);
                    return;
                }
                h.this.ASa.addJavascriptInterface(obj, str);
                AppMethodBeat.o(85240);
            }
        });
        AppMethodBeat.o(85246);
    }

    public final int getNativeBufferId() {
        return 0;
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
    }

    public final ByteBuffer getNativeBuffer(int i) {
        return null;
    }

    public final boolean dUA() {
        return false;
    }

    public final void a(com.tencent.xweb.f fVar) {
    }
}
