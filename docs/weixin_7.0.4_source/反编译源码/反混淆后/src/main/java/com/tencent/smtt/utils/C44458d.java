package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.smtt.utils.d */
public class C44458d {
    /* renamed from: b */
    private static DexClassLoader f17305b = null;
    /* renamed from: c */
    private static Looper f17306c = null;
    /* renamed from: d */
    private static C44458d f17307d = null;
    /* renamed from: a */
    public String f17308a = "";

    /* renamed from: com.tencent.smtt.utils.d$a */
    public interface C36444a {
        /* renamed from: a */
        void mo57628a();

        /* renamed from: a */
        void mo57629a(int i);

        /* renamed from: a */
        void mo57630a(Throwable th);
    }

    private C44458d(Context context) {
        AppMethodBeat.m2504i(65204);
        this.f17308a = context.getDir("debugtbs", 0).getAbsolutePath() + File.separator + "plugin";
        AppMethodBeat.m2505o(65204);
    }

    /* renamed from: a */
    public static C44458d m80441a(Context context) {
        AppMethodBeat.m2504i(65205);
        if (f17307d == null) {
            f17307d = new C44458d(context);
        }
        C44458d c44458d = f17307d;
        AppMethodBeat.m2505o(65205);
        return c44458d;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m80442a(String str, C36444a c36444a) {
        AppMethodBeat.m2504i(65207);
        new C24275i(str, c36444a).start();
        AppMethodBeat.m2505o(65207);
    }

    /* renamed from: a */
    public void mo70633a(String str, WebView webView, Context context) {
        AppMethodBeat.m2504i(65206);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        TextView textView = new TextView(context);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(13);
        textView.setText("加载中，请稍后...");
        relativeLayout.addView(textView, layoutParams);
        webView.addView(relativeLayout, new FrameLayout.LayoutParams(-1, -1));
        String str2 = this.f17308a + File.separator + "DebugPlugin.tbs";
        C30950k.m49564b(new File(str2));
        C44458d.m80442a(str2, new C44459e(this, webView, context, relativeLayout, str, textView));
        AppMethodBeat.m2505o(65206);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void mo70634a(String str, WebView webView, Context context, Looper looper) {
        AppMethodBeat.m2504i(65208);
        TbsLog.m80434i("debugtbs", "showPluginView -- url: " + str + "; webview: " + webView + "; context: " + context);
        String str2 = this.f17308a + File.separator + "DebugPlugin.tbs";
        String str3 = this.f17308a + File.separator + "DebugPlugin.apk";
        File file = new File(str2);
        File file2 = new File(str3);
        f17306c = looper;
        if (file.exists()) {
            file2.delete();
            file.renameTo(file2);
        }
        if (file2.exists()) {
            try {
                str2 = C36443b.m60180a(context, true, new File(str3));
                if ("308203773082025fa003020102020448bb959d300d06092a864886f70d01010b0500306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e673020170d3136303532313039353730335a180f32303731303232323039353730335a306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e6730820122300d06092a864886f70d01010105000382010f003082010a02820101008c58deabefe95f699c6322f9a75620873b490d26520c7267eb8382a91da625a5876b2bd617116eb40b371c4f88c988c1ba73052caaa9964873c94b7755c3429fca47a6677229fb2e72908d3b17df82f1ebe70447b94c1e5b0a763dad8948312180322657325306f01e423e0409ef3a59e5c0e0b9c765a2322699a2dec2d4dbe58ec15f41752516192169d9596169f5bf08eaf8aab9893240ad679e82fc92b97d2ae98b28021dc5a752f0a69437ea603c541e6753cea52dbc8e8043fe21fd5da46066c92e0714905dfad3116f35aca52b13871c57481459aa4ca255a6482ba972bd17af90d0d2c21a57ef65376bbd4ce7078e6047060640669f3867fdc69fbb750203010001a321301f301d0603551d0e0416041450fb9b6362e829797b1b29ca55e6d5e082e93ff3300d06092a864886f70d01010b050003820101004952ffbfba7c00ee9b84f44b05ec62bc2400dc769fb2e83f80395e3fbb54e44d56e16527413d144f42bf8f21fa443bc42a7a732de9d5124df906c6d728e75ca94eefc918080876bd3ce6cb5f7f2d9cc8d8e708033afc1295c7f347fb2d2098be2e4a79220e9552171d5b5f8f59cff4c6478cc41dce24cbe942305757488d37659d3265838ee54ebe44fccbd1bec93d809f950034f5ef292f20179554d22f5856c03b4d44997fcb9b3579e16a49218fce0e2e6bfe1fd4aa0ab39f548344c244c171c203baff1a730883aaf4506b6865a45c3c9aba40c6326d4152b6ce09cc058864bec1d6422e83dad9496b83fb252b4bfb30d3a6badf996099793e11f9af618d".equals(str2)) {
                    str2 = this.f17308a + File.separator + "opt";
                    file = new File(str2);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    if (f17305b == null) {
                        f17305b = new DexClassLoader(str3, str2, null, context.getClassLoader());
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("url", str);
                    hashMap.put("tbs_version", WebView.getTbsSDKVersion(context));
                    hashMap.put("tbs_core_version", WebView.getTbsCoreVersion(context));
                    if (f17306c != null) {
                        hashMap.put("looper", looper);
                    }
                    Object newInstance = f17305b.loadClass("com.tencent.tbs.debug.plugin.DebugView").getConstructor(new Class[]{Context.class, Map.class}).newInstance(new Object[]{context, hashMap});
                    if (newInstance instanceof FrameLayout) {
                        FrameLayout frameLayout = (FrameLayout) newInstance;
                        webView.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                        TbsLog.m80434i("debugtbs", "show " + frameLayout + " successful in " + webView);
                        AppMethodBeat.m2505o(65208);
                        return;
                    }
                    TbsLog.m80432e("debugtbs", "get debugview failure: ".concat(String.valueOf(newInstance)));
                    AppMethodBeat.m2505o(65208);
                    return;
                }
                TbsLog.m80432e("debugtbs", "verifyPlugin apk: " + str3 + " signature failed - sig: " + str2);
                Toast.makeText(context, "插件校验失败，请重试", 0).show();
                file.delete();
                file2.delete();
                AppMethodBeat.m2505o(65208);
                return;
            } catch (Exception e) {
                C30950k.m49564b(file2);
                AppMethodBeat.m2505o(65208);
                return;
            }
        }
        TbsLog.m80434i("debugtbs", "showPluginView - going to download plugin...");
        mo70633a(str, webView, context);
        AppMethodBeat.m2505o(65208);
    }
}
