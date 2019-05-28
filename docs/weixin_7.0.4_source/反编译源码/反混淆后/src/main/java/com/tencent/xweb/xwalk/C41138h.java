package com.tencent.xweb.xwalk;

import android.os.Handler;
import android.os.HandlerThread;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.C36586f;
import com.tencent.xweb.p1115c.C24525f;
import java.net.URL;
import java.nio.ByteBuffer;
import org.xwalk.core.XWalkV8;

/* renamed from: com.tencent.xweb.xwalk.h */
public final class C41138h implements C24525f {
    XWalkV8 ASa;
    HandlerThread ASb = new HandlerThread("j2v8");
    private Handler ASc;

    /* renamed from: com.tencent.xweb.xwalk.h$2 */
    class C411402 implements Runnable {
        C411402() {
        }

        public final void run() {
            AppMethodBeat.m2504i(85238);
            if (C41138h.this.ASa == null) {
                AppMethodBeat.m2505o(85238);
                return;
            }
            C41138h.this.ASa.cleanup();
            C41138h.this.ASa = null;
            C41138h.this.ASb.getLooper().quit();
            C41138h.this.ASb = null;
            AppMethodBeat.m2505o(85238);
        }
    }

    public C41138h() {
        AppMethodBeat.m2504i(85241);
        this.ASb.start();
        this.ASc = new Handler(this.ASb.getLooper());
        AppMethodBeat.m2505o(85241);
    }

    public final void init(final int i) {
        AppMethodBeat.m2504i(85242);
        this.ASc.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(85237);
                if (C41138h.this.ASa != null) {
                    AppMethodBeat.m2505o(85237);
                    return;
                }
                C41138h.this.ASa = new XWalkV8();
                C41138h.this.ASa.init(i);
                AppMethodBeat.m2505o(85237);
            }
        });
        AppMethodBeat.m2505o(85242);
    }

    public final void pause() {
    }

    public final void resume() {
    }

    public final void cleanup() {
        AppMethodBeat.m2504i(85243);
        this.ASc.post(new C411402());
        AppMethodBeat.m2505o(85243);
    }

    public final boolean dTW() {
        return false;
    }

    public final void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(85244);
        this.ASc.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(85239);
                if (C41138h.this.ASa == null) {
                    AppMethodBeat.m2505o(85239);
                    return;
                }
                C41138h.this.ASa.evaluateJavascript(str, valueCallback);
                AppMethodBeat.m2505o(85239);
            }
        });
        AppMethodBeat.m2505o(85244);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        AppMethodBeat.m2504i(85245);
        evaluateJavascript(str, valueCallback);
        AppMethodBeat.m2505o(85245);
    }

    public final void addJavascriptInterface(final Object obj, final String str) {
        AppMethodBeat.m2504i(85246);
        this.ASc.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(85240);
                if (C41138h.this.ASa == null) {
                    AppMethodBeat.m2505o(85240);
                    return;
                }
                C41138h.this.ASa.addJavascriptInterface(obj, str);
                AppMethodBeat.m2505o(85240);
            }
        });
        AppMethodBeat.m2505o(85246);
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

    /* renamed from: a */
    public final void mo41188a(C36586f c36586f) {
    }
}
