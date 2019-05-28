package com.tencent.p177mm.plugin.freewifi.p418ui;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.freewifi.C11953b;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11968b;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.C45955h.C39112b;
import com.tencent.p177mm.plugin.freewifi.model.C11976j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

/* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI */
public class FreeWifiManufacturerLoadingUI extends MMActivity {
    private String bssid;
    private C7564ap che;
    private final int mzA = 1;
    private final int mzB = 2;
    private final int mzC = 3;
    private int[] mzD = new int[]{C25738R.drawable.aef, C25738R.drawable.aeg, C25738R.drawable.aeh, C25738R.drawable.aei, C25738R.drawable.aej};
    C7306ak mzE = new C119921();
    C7306ak mzF = new C7306ak();
    private ImageView mzx;
    private TextView mzy;
    private Button mzz;
    private String ssid;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI$2 */
    class C31492 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI$2$1 */
        class C31501 implements Runnable {
            C31501() {
            }

            public final void run() {
                AppMethodBeat.m2504i(21009);
                FreeWifiManufacturerLoadingUI.this.mzz.setVisibility(4);
                AppMethodBeat.m2505o(21009);
            }
        }

        C31492() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21010);
            FreeWifiManufacturerLoadingUI.this.mzF.postDelayed(new C31501(), 0);
            FreeWifiManufacturerLoadingUI.this.bzP();
            AppMethodBeat.m2505o(21010);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI$3 */
    class C31513 implements OnMenuItemClickListener {
        C31513() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(21011);
            FreeWifiManufacturerLoadingUI.this.finish();
            AppMethodBeat.m2505o(21011);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI$1 */
    class C119921 extends C7306ak {
        /* renamed from: i */
        int f2908i = 0;

        C119921() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(21008);
            if (message.what == 1) {
                if (this.f2908i >= FreeWifiManufacturerLoadingUI.this.mzD.length) {
                    this.f2908i = 0;
                }
                FreeWifiManufacturerLoadingUI.this.mzx.setImageResource(FreeWifiManufacturerLoadingUI.this.mzD[this.f2908i]);
                this.f2908i++;
            } else if (message.what == 2) {
                FreeWifiManufacturerLoadingUI.this.mzx.setImageResource(FreeWifiManufacturerLoadingUI.this.mzD[FreeWifiManufacturerLoadingUI.this.mzD.length - 1]);
            } else if (message.what == 3 && message.obj != null && (message.obj instanceof String)) {
                FreeWifiManufacturerLoadingUI.this.mzy.setText(message.obj.toString());
            }
            super.handleMessage(message);
            AppMethodBeat.m2505o(21008);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI$4 */
    class C280904 implements C5015a {
        C280904() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(21012);
            FreeWifiManufacturerLoadingUI.this.mzE.sendEmptyMessage(1);
            AppMethodBeat.m2505o(21012);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI$6 */
    class C280916 implements Runnable {
        C280916() {
        }

        public final void run() {
            AppMethodBeat.m2504i(21016);
            FreeWifiManufacturerLoadingUI.this.mzz.setVisibility(0);
            AppMethodBeat.m2505o(21016);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FreeWifiManufacturerLoadingUI() {
        AppMethodBeat.m2504i(21018);
        AppMethodBeat.m2505o(21018);
    }

    /* renamed from: a */
    static /* synthetic */ void m44643a(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI, int i, String str) {
        AppMethodBeat.m2504i(21027);
        freeWifiManufacturerLoadingUI.m44646aJ(i, str);
        AppMethodBeat.m2505o(21027);
    }

    /* renamed from: a */
    static /* synthetic */ void m44644a(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI, String str) {
        AppMethodBeat.m2504i(21028);
        freeWifiManufacturerLoadingUI.m44642MP(str);
        AppMethodBeat.m2505o(21028);
    }

    /* renamed from: e */
    static /* synthetic */ void m44652e(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        AppMethodBeat.m2504i(21031);
        freeWifiManufacturerLoadingUI.bzO();
        AppMethodBeat.m2505o(21031);
    }

    private void bzO() {
        AppMethodBeat.m2504i(21019);
        if (this.che != null) {
            this.che.stopTimer();
        }
        this.mzE.sendEmptyMessage(2);
        AppMethodBeat.m2505o(21019);
    }

    public final int getLayoutId() {
        return 2130969593;
    }

    public void finish() {
        AppMethodBeat.m2504i(21020);
        bzO();
        super.finish();
        AppMethodBeat.m2505o(21020);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(21021);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.c0t);
        this.ssid = getIntent().getStringExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Ssid");
        this.bssid = getIntent().getStringExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Bssid");
        this.mzx = (ImageView) findViewById(2131824144);
        this.mzy = (TextView) findViewById(2131824145);
        this.mzz = (Button) findViewById(2131824146);
        this.mzz.setOnClickListener(new C31492());
        setBackBtn(new C31513());
        bzP();
        AppMethodBeat.m2505o(21021);
    }

    public final void bzP() {
        AppMethodBeat.m2504i(21022);
        this.mzE.sendEmptyMessage(1);
        if (this.che != null) {
            this.che.stopTimer();
        }
        this.che = new C7564ap(new C280904(), true);
        this.che.mo16770ae(200, 200);
        m44641MO(this.ssid);
        AppMethodBeat.m2505o(21022);
    }

    /* renamed from: MO */
    private void m44641MO(final String str) {
        AppMethodBeat.m2504i(21023);
        C11976j.byZ().byI().post(new Runnable() {
            private int mzI = 0;
            private final int mzJ = 5;

            public final void run() {
                AppMethodBeat.m2504i(21013);
                Context context = C4996ah.getContext();
                if (context == null) {
                    FreeWifiManufacturerLoadingUI.m44643a(FreeWifiManufacturerLoadingUI.this, 1151, "Wechat hasn't started completely. Wait 5 seconds and retry.");
                    AppMethodBeat.m2505o(21013);
                    return;
                }
                if (!(C34189m.byu() && C34189m.m56059Mx("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI").equals(str))) {
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "It starts to connect portal ssid " + str);
                    FreeWifiManufacturerLoadingUI.m44644a(FreeWifiManufacturerLoadingUI.this, FreeWifiManufacturerLoadingUI.this.getString(C25738R.string.c0k));
                    int byd = new C11953b(str, context).byd();
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "connectRet=".concat(String.valueOf(byd)));
                    if (byd != 0) {
                        FreeWifiManufacturerLoadingUI.m44643a(FreeWifiManufacturerLoadingUI.this, byd, "An attempt to switch to special portal ap failed. connectRet=".concat(String.valueOf(byd)));
                        AppMethodBeat.m2505o(21013);
                        return;
                    }
                }
                bzR();
                AppMethodBeat.m2505o(21013);
            }

            private void bzQ() {
                AppMethodBeat.m2504i(21014);
                C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "_httpRequestForPortalUrl retry.");
                this.mzI++;
                try {
                    Thread.sleep(FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                } catch (InterruptedException e) {
                    C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "sleep exception. " + e.getMessage());
                }
                bzR();
                AppMethodBeat.m2505o(21014);
            }

            /* JADX WARNING: Removed duplicated region for block: B:73:0x020d  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private void bzR() {
                Exception e;
                Throwable th;
                AppMethodBeat.m2504i(21015);
                String byl = C39112b.mtY.byl();
                C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "http request url : ".concat(String.valueOf(byl)));
                FreeWifiManufacturerLoadingUI.m44644a(FreeWifiManufacturerLoadingUI.this, FreeWifiManufacturerLoadingUI.this.getString(C25738R.string.c0g));
                HttpURLConnection httpURLConnection = null;
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(byl).openConnection();
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.setConnectTimeout(5000);
                            httpURLConnection2.setReadTimeout(5000);
                            httpURLConnection2.setInstanceFollowRedirects(false);
                            httpURLConnection2.setUseCaches(false);
                            httpURLConnection2.setRequestProperty("Pragma", "no-cache");
                            httpURLConnection2.setRequestProperty("Cache-Control", "no-cache");
                            int responseCode = httpURLConnection2.getResponseCode();
                            C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "http resp code = ".concat(String.valueOf(responseCode)));
                            if (200 == responseCode) {
                                if (C34189m.m56059Mx("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI").equals(str)) {
                                    String C = FreeWifiManufacturerLoadingUI.m44640C(httpURLConnection2.getInputStream());
                                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "response body first line content=".concat(String.valueOf(C)));
                                    if (C.indexOf("wxwifiecho") == -1) {
                                        FreeWifiManufacturerLoadingUI.m44648b(FreeWifiManufacturerLoadingUI.this, byl);
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection2.disconnect();
                                        }
                                        AppMethodBeat.m2505o(21015);
                                        return;
                                    }
                                    FreeWifiManufacturerLoadingUI.m44643a(FreeWifiManufacturerLoadingUI.this, 0, "");
                                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "already connected.");
                                    FreeWifiManufacturerLoadingUI.m44643a(FreeWifiManufacturerLoadingUI.this, 0, "");
                                    FreeWifiManufacturerLoadingUI.m44644a(FreeWifiManufacturerLoadingUI.this, FreeWifiManufacturerLoadingUI.this.getString(C25738R.string.c0f));
                                    FreeWifiManufacturerLoadingUI.m44652e(FreeWifiManufacturerLoadingUI.this);
                                    FreeWifiManufacturerLoadingUI.m44653f(FreeWifiManufacturerLoadingUI.this);
                                } else {
                                    FreeWifiManufacturerLoadingUI.m44643a(FreeWifiManufacturerLoadingUI.this, 1150, "Target ssid is not connected.");
                                }
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                AppMethodBeat.m2505o(21015);
                                return;
                            } else if (302 == responseCode) {
                                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "desc=http response 302 location = %s", httpURLConnection2.getHeaderField("Location"));
                                byl = httpURLConnection2.getHeaderField("Location");
                                if (C34189m.isEmpty(byl)) {
                                    FreeWifiManufacturerLoadingUI.m44643a(FreeWifiManufacturerLoadingUI.this, 1146, "AP cannot response portal url properly.");
                                    if (httpURLConnection2 != null) {
                                        httpURLConnection2.disconnect();
                                    }
                                    AppMethodBeat.m2505o(21015);
                                    return;
                                }
                                FreeWifiManufacturerLoadingUI.m44648b(FreeWifiManufacturerLoadingUI.this, byl);
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                AppMethodBeat.m2505o(21015);
                                return;
                            } else {
                                FreeWifiManufacturerLoadingUI.m44643a(FreeWifiManufacturerLoadingUI.this, 1149, "Ap response code is neither 200 nor 302.");
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                AppMethodBeat.m2505o(21015);
                                return;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            httpURLConnection = httpURLConnection2;
                        } catch (Throwable th2) {
                            th = th2;
                            httpURLConnection = httpURLConnection2;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            AppMethodBeat.m2505o(21015);
                            throw th;
                        }
                    }
                    C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "httpUrlConnection is null. _httpRequestForPortalUrl _retryCount=%d, MaxRetryCount=%d", Integer.valueOf(this.mzI), Integer.valueOf(5));
                    if (this.mzI < 5) {
                        bzQ();
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        AppMethodBeat.m2505o(21015);
                        return;
                    }
                    FreeWifiManufacturerLoadingUI.m44643a(FreeWifiManufacturerLoadingUI.this, 1148, "An attempt to connect to ap failed.");
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    AppMethodBeat.m2505o(21015);
                } catch (Exception e3) {
                    e = e3;
                    try {
                        StringWriter stringWriter = new StringWriter();
                        e.printStackTrace(new PrintWriter(stringWriter));
                        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "ping encounter exception. ".concat(String.valueOf(stringWriter.toString())));
                        if (e instanceof UnknownHostException) {
                            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "httpUrlConnection throws exception. _httpRequestForPortalUrl _retryCount=%d, MaxRetryCount=%d", Integer.valueOf(this.mzI), Integer.valueOf(5));
                            if (this.mzI < 5) {
                                bzQ();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                AppMethodBeat.m2505o(21015);
                                return;
                            }
                        }
                        FreeWifiManufacturerLoadingUI.m44643a(FreeWifiManufacturerLoadingUI.this, 1153, "An attempt to connect to ap failed.");
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        AppMethodBeat.m2505o(21015);
                    } catch (Throwable th3) {
                        th = th3;
                        if (httpURLConnection != null) {
                        }
                        AppMethodBeat.m2505o(21015);
                        throw th;
                    }
                }
            }
        });
        AppMethodBeat.m2505o(21023);
    }

    /* renamed from: aJ */
    private void m44646aJ(int i, String str) {
        AppMethodBeat.m2504i(21024);
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "errcode=%d, errmsg=%s", Integer.valueOf(i), str);
        if (i != 0) {
            bzO();
            if (i == 1154) {
                m44642MP(getString(C25738R.string.c0i) + "(031" + C11968b.ManufacturerConnectLoading.muQ + "-" + Math.abs(i) + ")");
                AppMethodBeat.m2505o(21024);
                return;
            }
            m44642MP(getString(C25738R.string.c0h) + "(031" + C11968b.ManufacturerConnectLoading.muQ + "-" + Math.abs(i) + ")");
            this.mzF.postDelayed(new C280916(), 0);
        }
        AppMethodBeat.m2505o(21024);
    }

    /* renamed from: MP */
    private void m44642MP(String str) {
        AppMethodBeat.m2504i(21025);
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = str;
        this.mzE.sendMessage(obtain);
        AppMethodBeat.m2505o(21025);
    }

    /* renamed from: cc */
    private static String m44650cc(Context context) {
        AppMethodBeat.m2504i(21026);
        String className;
        try {
            className = ((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
            C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "top activity name =".concat(String.valueOf(className)));
            AppMethodBeat.m2505o(21026);
            return className;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", e, "", new Object[0]);
            className = "(null)";
            AppMethodBeat.m2505o(21026);
            return className;
        }
    }

    /* renamed from: C */
    static /* synthetic */ String m44640C(InputStream inputStream) {
        AppMethodBeat.m2504i(21029);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String readLine = bufferedReader.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(readLine);
        while (true) {
            String readLine2 = bufferedReader.readLine();
            if (readLine2 != null) {
                stringBuilder.append(readLine2);
            } else {
                C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "response body=" + stringBuilder.toString());
                String Mw = C34189m.m56058Mw(readLine);
                AppMethodBeat.m2505o(21029);
                return Mw;
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m44648b(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI, final String str) {
        AppMethodBeat.m2504i(21030);
        freeWifiManufacturerLoadingUI.m44646aJ(0, "");
        freeWifiManufacturerLoadingUI.m44642MP(freeWifiManufacturerLoadingUI.getString(C25738R.string.c0j));
        freeWifiManufacturerLoadingUI.bzO();
        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "opening url : ".concat(String.valueOf(str)));
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(21017);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("show_bottom", false);
                intent.putExtra("allow_wx_schema_url", true);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("stastic_scene", 7);
                intent.putExtra("neverBlockLocalRequest", true);
                if (FreeWifiManufacturerLoadingUI.m44654g(FreeWifiManufacturerLoadingUI.this)) {
                    C25985d.m41467b(C4996ah.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
                AppMethodBeat.m2505o(21017);
            }
        });
        AppMethodBeat.m2505o(21030);
    }

    /* renamed from: f */
    static /* synthetic */ void m44653f(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        AppMethodBeat.m2504i(21032);
        Intent intent = new Intent();
        intent.putExtra("free_wifi_channel_id", 10);
        intent.setClass(freeWifiManufacturerLoadingUI, FreeWifiSuccUI.class);
        freeWifiManufacturerLoadingUI.startActivity(intent);
        freeWifiManufacturerLoadingUI.finish();
        freeWifiManufacturerLoadingUI.overridePendingTransition(C25738R.anim.f8403df, C25738R.anim.f8402dc);
        AppMethodBeat.m2505o(21032);
    }

    /* renamed from: g */
    static /* synthetic */ boolean m44654g(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        AppMethodBeat.m2504i(21033);
        String cc = FreeWifiManufacturerLoadingUI.m44650cc(C4996ah.getContext());
        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "topActivityName : ".concat(String.valueOf(cc)));
        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "getClas().getName()=" + freeWifiManufacturerLoadingUI.getClass().getName());
        boolean z = cc != null && cc.equals(freeWifiManufacturerLoadingUI.getClass().getName());
        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "ret = ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(21033);
        return z;
    }
}
