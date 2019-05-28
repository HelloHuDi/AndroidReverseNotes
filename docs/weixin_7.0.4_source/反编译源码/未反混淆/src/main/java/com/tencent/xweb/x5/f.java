package com.tencent.xweb.x5;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.X5JsCore;
import com.tencent.xweb.x5.a.d;
import java.net.URL;
import java.nio.ByteBuffer;
import org.xwalk.core.Log;

public final class f implements com.tencent.xweb.c.f {
    private X5JsCore AQt;
    private Context mContext;

    public f(Context context) {
        AppMethodBeat.i(84808);
        this.mContext = context;
        Log.i("MicroMsg.X5JsRuntime", "create X5V8JsRuntime");
        AppMethodBeat.o(84808);
    }

    public final void init(int i) {
        AppMethodBeat.i(84809);
        this.AQt = new X5JsCore(this.mContext);
        AppMethodBeat.o(84809);
    }

    public final void pause() {
        AppMethodBeat.i(84810);
        this.AQt.pause();
        AppMethodBeat.o(84810);
    }

    public final void resume() {
        AppMethodBeat.i(84811);
        this.AQt.resume();
        AppMethodBeat.o(84811);
    }

    public final boolean dTW() {
        AppMethodBeat.i(84812);
        if (!X5JsCore.canUseX5JsCore(this.mContext) || QbSdk.getTbsVersion(this.mContext) < 43600) {
            AppMethodBeat.o(84812);
            return false;
        }
        AppMethodBeat.o(84812);
        return true;
    }

    public final void cleanup() {
        AppMethodBeat.i(84813);
        this.AQt.destroy();
        AppMethodBeat.o(84813);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(84814);
        this.AQt.evaluateJavascript(str, new d(valueCallback));
        AppMethodBeat.o(84814);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        AppMethodBeat.i(84815);
        this.AQt.evaluateJavascript(str, new d(valueCallback));
        AppMethodBeat.o(84815);
    }

    public final void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(84816);
        this.AQt.addJavascriptInterface(obj, str);
        AppMethodBeat.o(84816);
    }

    public final int getNativeBufferId() {
        AppMethodBeat.i(84817);
        int nativeBufferId = this.AQt.getNativeBufferId();
        AppMethodBeat.o(84817);
        return nativeBufferId;
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        AppMethodBeat.i(84818);
        this.AQt.setNativeBuffer(i, byteBuffer);
        AppMethodBeat.o(84818);
    }

    public final ByteBuffer getNativeBuffer(int i) {
        AppMethodBeat.i(84819);
        ByteBuffer nativeBuffer = this.AQt.getNativeBuffer(i);
        AppMethodBeat.o(84819);
        return nativeBuffer;
    }

    public final boolean dUA() {
        AppMethodBeat.i(84820);
        boolean canX5JsCoreUseNativeBuffer = X5JsCore.canX5JsCoreUseNativeBuffer(this.mContext);
        AppMethodBeat.o(84820);
        return canX5JsCoreUseNativeBuffer;
    }

    public final void a(com.tencent.xweb.f fVar) {
    }
}
