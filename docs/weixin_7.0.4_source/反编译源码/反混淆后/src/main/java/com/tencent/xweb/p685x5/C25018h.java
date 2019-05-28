package com.tencent.xweb.p685x5;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsContext.ExceptionHandler;
import com.tencent.smtt.sdk.JsError;
import com.tencent.xweb.C36586f;
import com.tencent.xweb.p1115c.C24525f;
import com.tencent.xweb.p685x5.C24535a.C24538d;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.xwalk.core.Log;

/* renamed from: com.tencent.xweb.x5.h */
public final class C25018h implements C24525f {
    private JsContext AQB;
    private C16406a AQC;
    C36586f AQD;
    private Context mContext;

    /* renamed from: com.tencent.xweb.x5.h$a */
    public static class C16406a {
        /* renamed from: Nj */
        private static final AtomicInteger f3500Nj = new AtomicInteger(1);
        HashMap<Integer, byte[]> ciD = new HashMap();

        public C16406a() {
            AppMethodBeat.m2504i(84837);
            AppMethodBeat.m2505o(84837);
        }

        static {
            AppMethodBeat.m2504i(84841);
            AppMethodBeat.m2505o(84841);
        }

        @JavascriptInterface
        public final int getNativeBufferId() {
            int i;
            AppMethodBeat.m2504i(84838);
            int i2;
            do {
                i = f3500Nj.get();
                i2 = i + 1;
                if (i2 > 16777215) {
                    i2 = 1;
                }
            } while (!f3500Nj.compareAndSet(i, i2));
            AppMethodBeat.m2505o(84838);
            return i;
        }

        @JavascriptInterface
        public final void setNativeBuffer(int i, byte[] bArr) {
            AppMethodBeat.m2504i(84839);
            this.ciD.put(Integer.valueOf(i), bArr);
            AppMethodBeat.m2505o(84839);
        }

        @JavascriptInterface
        public final byte[] getNativeBuffer(int i) {
            AppMethodBeat.m2504i(84840);
            byte[] bArr = (byte[]) this.ciD.remove(Integer.valueOf(i));
            AppMethodBeat.m2505o(84840);
            return bArr;
        }
    }

    /* renamed from: com.tencent.xweb.x5.h$1 */
    class C250191 implements ValueCallback<String> {
        C250191() {
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            AppMethodBeat.m2504i(84835);
            Log.m81049i("MicroMsg.X5V8JsRuntime", "on inject nativeBufferCompat Object finished.");
            AppMethodBeat.m2505o(84835);
        }
    }

    /* renamed from: com.tencent.xweb.x5.h$2 */
    class C250202 implements ExceptionHandler {
        C250202() {
        }

        public final void handleException(JsContext jsContext, JsError jsError) {
            AppMethodBeat.m2504i(84836);
            if (jsError == null) {
                Log.m81049i("MicroMsg.X5V8JsRuntime", "jsError is null.");
                AppMethodBeat.m2505o(84836);
                return;
            }
            Log.m81046e("MicroMsg.X5V8JsRuntime", String.format("handleException(%s)", new Object[]{jsError.getMessage()}));
            if (C25018h.this.AQD != null) {
                C25018h.this.AQD.mo21696C(r0, "");
            }
            AppMethodBeat.m2505o(84836);
        }
    }

    public C25018h(Context context) {
        AppMethodBeat.m2504i(84842);
        this.mContext = context;
        Log.m81049i("MicroMsg.X5V8JsRuntime", "create X5V8JsRuntime");
        AppMethodBeat.m2505o(84842);
    }

    public final void init(int i) {
        AppMethodBeat.m2504i(84843);
        this.AQB = new JsContext(this.mContext);
        this.AQC = new C16406a();
        this.AQB.addJavascriptInterface(this.AQC, "nativeBufferCompat");
        this.AQB.evaluateJavascript("function getNativeBufferId() {   if (nativeBufferCompat) {       return nativeBufferCompat.getNativeBufferId();   }   return -1;}function setNativeBuffer(id, bytes) {   if (nativeBufferCompat) {       return nativeBufferCompat.setNativeBuffer(id, bytes);   }}function getNativeBuffer(id) {   if (nativeBufferCompat) {       return nativeBufferCompat.getNativeBuffer(id);   }}", new C24538d(new C250191()));
        this.AQB.setExceptionHandler(new C250202());
        AppMethodBeat.m2505o(84843);
    }

    public final void pause() {
        AppMethodBeat.m2504i(84844);
        this.AQB.virtualMachine().onPause();
        AppMethodBeat.m2505o(84844);
    }

    public final void resume() {
        AppMethodBeat.m2504i(84845);
        this.AQB.virtualMachine().onResume();
        AppMethodBeat.m2505o(84845);
    }

    public final boolean dTW() {
        return true;
    }

    public final void cleanup() {
        AppMethodBeat.m2504i(84846);
        this.AQB.destroy();
        this.AQC.ciD.clear();
        AppMethodBeat.m2505o(84846);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(84847);
        this.AQB.evaluateJavascript(str, new C24538d(valueCallback));
        AppMethodBeat.m2505o(84847);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        AppMethodBeat.m2504i(84848);
        Log.m81049i("MicroMsg.X5V8JsRuntime", String.format("evaluateJavascriptWithURL(%s)", new Object[]{url}));
        this.AQB.evaluateJavascript(str, new C24538d(valueCallback), url);
        AppMethodBeat.m2505o(84848);
    }

    public final void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.m2504i(84849);
        this.AQB.addJavascriptInterface(obj, str);
        AppMethodBeat.m2505o(84849);
    }

    public final int getNativeBufferId() {
        AppMethodBeat.m2504i(84850);
        int nativeBufferId = this.AQC.getNativeBufferId();
        AppMethodBeat.m2505o(84850);
        return nativeBufferId;
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        byte[] bArr;
        AppMethodBeat.m2504i(84851);
        C16406a c16406a = this.AQC;
        if (byteBuffer == null) {
            bArr = new byte[0];
        } else if (byteBuffer.isDirect()) {
            int position = byteBuffer.position();
            byteBuffer.position(0);
            bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            byteBuffer.position(position);
        } else {
            bArr = byteBuffer.array();
        }
        c16406a.setNativeBuffer(i, bArr);
        AppMethodBeat.m2505o(84851);
    }

    public final ByteBuffer getNativeBuffer(int i) {
        AppMethodBeat.m2504i(84852);
        byte[] nativeBuffer = this.AQC.getNativeBuffer(i);
        if (nativeBuffer == null || nativeBuffer.length <= 0) {
            AppMethodBeat.m2505o(84852);
            return null;
        }
        ByteBuffer wrap = ByteBuffer.wrap(nativeBuffer);
        AppMethodBeat.m2505o(84852);
        return wrap;
    }

    public final boolean dUA() {
        return true;
    }

    /* renamed from: a */
    public final void mo41188a(C36586f c36586f) {
        this.AQD = c36586f;
    }
}
