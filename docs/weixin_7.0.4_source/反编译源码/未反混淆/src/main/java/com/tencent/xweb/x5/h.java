package com.tencent.xweb.x5;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsContext.ExceptionHandler;
import com.tencent.smtt.sdk.JsError;
import com.tencent.xweb.c.f;
import com.tencent.xweb.x5.a.d;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.xwalk.core.Log;

public final class h implements f {
    private JsContext AQB;
    private a AQC;
    com.tencent.xweb.f AQD;
    private Context mContext;

    public static class a {
        private static final AtomicInteger Nj = new AtomicInteger(1);
        HashMap<Integer, byte[]> ciD = new HashMap();

        public a() {
            AppMethodBeat.i(84837);
            AppMethodBeat.o(84837);
        }

        static {
            AppMethodBeat.i(84841);
            AppMethodBeat.o(84841);
        }

        @JavascriptInterface
        public final int getNativeBufferId() {
            int i;
            AppMethodBeat.i(84838);
            int i2;
            do {
                i = Nj.get();
                i2 = i + 1;
                if (i2 > 16777215) {
                    i2 = 1;
                }
            } while (!Nj.compareAndSet(i, i2));
            AppMethodBeat.o(84838);
            return i;
        }

        @JavascriptInterface
        public final void setNativeBuffer(int i, byte[] bArr) {
            AppMethodBeat.i(84839);
            this.ciD.put(Integer.valueOf(i), bArr);
            AppMethodBeat.o(84839);
        }

        @JavascriptInterface
        public final byte[] getNativeBuffer(int i) {
            AppMethodBeat.i(84840);
            byte[] bArr = (byte[]) this.ciD.remove(Integer.valueOf(i));
            AppMethodBeat.o(84840);
            return bArr;
        }
    }

    public h(Context context) {
        AppMethodBeat.i(84842);
        this.mContext = context;
        Log.i("MicroMsg.X5V8JsRuntime", "create X5V8JsRuntime");
        AppMethodBeat.o(84842);
    }

    public final void init(int i) {
        AppMethodBeat.i(84843);
        this.AQB = new JsContext(this.mContext);
        this.AQC = new a();
        this.AQB.addJavascriptInterface(this.AQC, "nativeBufferCompat");
        this.AQB.evaluateJavascript("function getNativeBufferId() {   if (nativeBufferCompat) {       return nativeBufferCompat.getNativeBufferId();   }   return -1;}function setNativeBuffer(id, bytes) {   if (nativeBufferCompat) {       return nativeBufferCompat.setNativeBuffer(id, bytes);   }}function getNativeBuffer(id) {   if (nativeBufferCompat) {       return nativeBufferCompat.getNativeBuffer(id);   }}", new d(new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                AppMethodBeat.i(84835);
                Log.i("MicroMsg.X5V8JsRuntime", "on inject nativeBufferCompat Object finished.");
                AppMethodBeat.o(84835);
            }
        }));
        this.AQB.setExceptionHandler(new ExceptionHandler() {
            public final void handleException(JsContext jsContext, JsError jsError) {
                AppMethodBeat.i(84836);
                if (jsError == null) {
                    Log.i("MicroMsg.X5V8JsRuntime", "jsError is null.");
                    AppMethodBeat.o(84836);
                    return;
                }
                Log.e("MicroMsg.X5V8JsRuntime", String.format("handleException(%s)", new Object[]{jsError.getMessage()}));
                if (h.this.AQD != null) {
                    h.this.AQD.C(r0, "");
                }
                AppMethodBeat.o(84836);
            }
        });
        AppMethodBeat.o(84843);
    }

    public final void pause() {
        AppMethodBeat.i(84844);
        this.AQB.virtualMachine().onPause();
        AppMethodBeat.o(84844);
    }

    public final void resume() {
        AppMethodBeat.i(84845);
        this.AQB.virtualMachine().onResume();
        AppMethodBeat.o(84845);
    }

    public final boolean dTW() {
        return true;
    }

    public final void cleanup() {
        AppMethodBeat.i(84846);
        this.AQB.destroy();
        this.AQC.ciD.clear();
        AppMethodBeat.o(84846);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(84847);
        this.AQB.evaluateJavascript(str, new d(valueCallback));
        AppMethodBeat.o(84847);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        AppMethodBeat.i(84848);
        Log.i("MicroMsg.X5V8JsRuntime", String.format("evaluateJavascriptWithURL(%s)", new Object[]{url}));
        this.AQB.evaluateJavascript(str, new d(valueCallback), url);
        AppMethodBeat.o(84848);
    }

    public final void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(84849);
        this.AQB.addJavascriptInterface(obj, str);
        AppMethodBeat.o(84849);
    }

    public final int getNativeBufferId() {
        AppMethodBeat.i(84850);
        int nativeBufferId = this.AQC.getNativeBufferId();
        AppMethodBeat.o(84850);
        return nativeBufferId;
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        byte[] bArr;
        AppMethodBeat.i(84851);
        a aVar = this.AQC;
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
        aVar.setNativeBuffer(i, bArr);
        AppMethodBeat.o(84851);
    }

    public final ByteBuffer getNativeBuffer(int i) {
        AppMethodBeat.i(84852);
        byte[] nativeBuffer = this.AQC.getNativeBuffer(i);
        if (nativeBuffer == null || nativeBuffer.length <= 0) {
            AppMethodBeat.o(84852);
            return null;
        }
        ByteBuffer wrap = ByteBuffer.wrap(nativeBuffer);
        AppMethodBeat.o(84852);
        return wrap;
    }

    public final boolean dUA() {
        return true;
    }

    public final void a(com.tencent.xweb.f fVar) {
        this.AQD = fVar;
    }
}
