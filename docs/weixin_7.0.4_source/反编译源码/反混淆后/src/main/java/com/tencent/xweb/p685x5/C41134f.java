package com.tencent.xweb.p685x5;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.X5JsCore;
import com.tencent.xweb.C36586f;
import com.tencent.xweb.p1115c.C24525f;
import com.tencent.xweb.p685x5.C24535a.C24538d;
import java.net.URL;
import java.nio.ByteBuffer;
import org.xwalk.core.Log;

/* renamed from: com.tencent.xweb.x5.f */
public final class C41134f implements C24525f {
    private X5JsCore AQt;
    private Context mContext;

    public C41134f(Context context) {
        AppMethodBeat.m2504i(84808);
        this.mContext = context;
        Log.m81049i("MicroMsg.X5JsRuntime", "create X5V8JsRuntime");
        AppMethodBeat.m2505o(84808);
    }

    public final void init(int i) {
        AppMethodBeat.m2504i(84809);
        this.AQt = new X5JsCore(this.mContext);
        AppMethodBeat.m2505o(84809);
    }

    public final void pause() {
        AppMethodBeat.m2504i(84810);
        this.AQt.pause();
        AppMethodBeat.m2505o(84810);
    }

    public final void resume() {
        AppMethodBeat.m2504i(84811);
        this.AQt.resume();
        AppMethodBeat.m2505o(84811);
    }

    public final boolean dTW() {
        AppMethodBeat.m2504i(84812);
        if (!X5JsCore.canUseX5JsCore(this.mContext) || QbSdk.getTbsVersion(this.mContext) < 43600) {
            AppMethodBeat.m2505o(84812);
            return false;
        }
        AppMethodBeat.m2505o(84812);
        return true;
    }

    public final void cleanup() {
        AppMethodBeat.m2504i(84813);
        this.AQt.destroy();
        AppMethodBeat.m2505o(84813);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(84814);
        this.AQt.evaluateJavascript(str, new C24538d(valueCallback));
        AppMethodBeat.m2505o(84814);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        AppMethodBeat.m2504i(84815);
        this.AQt.evaluateJavascript(str, new C24538d(valueCallback));
        AppMethodBeat.m2505o(84815);
    }

    public final void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.m2504i(84816);
        this.AQt.addJavascriptInterface(obj, str);
        AppMethodBeat.m2505o(84816);
    }

    public final int getNativeBufferId() {
        AppMethodBeat.m2504i(84817);
        int nativeBufferId = this.AQt.getNativeBufferId();
        AppMethodBeat.m2505o(84817);
        return nativeBufferId;
    }

    public final void setNativeBuffer(int i, ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(84818);
        this.AQt.setNativeBuffer(i, byteBuffer);
        AppMethodBeat.m2505o(84818);
    }

    public final ByteBuffer getNativeBuffer(int i) {
        AppMethodBeat.m2504i(84819);
        ByteBuffer nativeBuffer = this.AQt.getNativeBuffer(i);
        AppMethodBeat.m2505o(84819);
        return nativeBuffer;
    }

    public final boolean dUA() {
        AppMethodBeat.m2504i(84820);
        boolean canX5JsCoreUseNativeBuffer = X5JsCore.canX5JsCoreUseNativeBuffer(this.mContext);
        AppMethodBeat.m2505o(84820);
        return canX5JsCoreUseNativeBuffer;
    }

    /* renamed from: a */
    public final void mo41188a(C36586f c36586f) {
    }
}
