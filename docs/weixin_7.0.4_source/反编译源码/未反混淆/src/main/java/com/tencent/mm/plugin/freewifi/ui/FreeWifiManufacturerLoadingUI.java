package com.tencent.mm.plugin.freewifi.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.freewifi.b;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

public class FreeWifiManufacturerLoadingUI extends MMActivity {
    private String bssid;
    private ap che;
    private final int mzA = 1;
    private final int mzB = 2;
    private final int mzC = 3;
    private int[] mzD = new int[]{R.drawable.aef, R.drawable.aeg, R.drawable.aeh, R.drawable.aei, R.drawable.aej};
    ak mzE = new ak() {
        int i = 0;

        public final void handleMessage(Message message) {
            AppMethodBeat.i(21008);
            if (message.what == 1) {
                if (this.i >= FreeWifiManufacturerLoadingUI.this.mzD.length) {
                    this.i = 0;
                }
                FreeWifiManufacturerLoadingUI.this.mzx.setImageResource(FreeWifiManufacturerLoadingUI.this.mzD[this.i]);
                this.i++;
            } else if (message.what == 2) {
                FreeWifiManufacturerLoadingUI.this.mzx.setImageResource(FreeWifiManufacturerLoadingUI.this.mzD[FreeWifiManufacturerLoadingUI.this.mzD.length - 1]);
            } else if (message.what == 3 && message.obj != null && (message.obj instanceof String)) {
                FreeWifiManufacturerLoadingUI.this.mzy.setText(message.obj.toString());
            }
            super.handleMessage(message);
            AppMethodBeat.o(21008);
        }
    };
    ak mzF = new ak();
    private ImageView mzx;
    private TextView mzy;
    private Button mzz;
    private String ssid;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FreeWifiManufacturerLoadingUI() {
        AppMethodBeat.i(21018);
        AppMethodBeat.o(21018);
    }

    static /* synthetic */ void a(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI, int i, String str) {
        AppMethodBeat.i(21027);
        freeWifiManufacturerLoadingUI.aJ(i, str);
        AppMethodBeat.o(21027);
    }

    static /* synthetic */ void a(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI, String str) {
        AppMethodBeat.i(21028);
        freeWifiManufacturerLoadingUI.MP(str);
        AppMethodBeat.o(21028);
    }

    static /* synthetic */ void e(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        AppMethodBeat.i(21031);
        freeWifiManufacturerLoadingUI.bzO();
        AppMethodBeat.o(21031);
    }

    private void bzO() {
        AppMethodBeat.i(21019);
        if (this.che != null) {
            this.che.stopTimer();
        }
        this.mzE.sendEmptyMessage(2);
        AppMethodBeat.o(21019);
    }

    public final int getLayoutId() {
        return R.layout.a0o;
    }

    public void finish() {
        AppMethodBeat.i(21020);
        bzO();
        super.finish();
        AppMethodBeat.o(21020);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21021);
        super.onCreate(bundle);
        setMMTitle((int) R.string.c0t);
        this.ssid = getIntent().getStringExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Ssid");
        this.bssid = getIntent().getStringExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Bssid");
        this.mzx = (ImageView) findViewById(R.id.bwa);
        this.mzy = (TextView) findViewById(R.id.bwb);
        this.mzz = (Button) findViewById(R.id.bwc);
        this.mzz.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(21010);
                FreeWifiManufacturerLoadingUI.this.mzF.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(21009);
                        FreeWifiManufacturerLoadingUI.this.mzz.setVisibility(4);
                        AppMethodBeat.o(21009);
                    }
                }, 0);
                FreeWifiManufacturerLoadingUI.this.bzP();
                AppMethodBeat.o(21010);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21011);
                FreeWifiManufacturerLoadingUI.this.finish();
                AppMethodBeat.o(21011);
                return true;
            }
        });
        bzP();
        AppMethodBeat.o(21021);
    }

    public final void bzP() {
        AppMethodBeat.i(21022);
        this.mzE.sendEmptyMessage(1);
        if (this.che != null) {
            this.che.stopTimer();
        }
        this.che = new ap(new a() {
            public final boolean BI() {
                AppMethodBeat.i(21012);
                FreeWifiManufacturerLoadingUI.this.mzE.sendEmptyMessage(1);
                AppMethodBeat.o(21012);
                return true;
            }
        }, true);
        this.che.ae(200, 200);
        MO(this.ssid);
        AppMethodBeat.o(21022);
    }

    private void MO(final String str) {
        AppMethodBeat.i(21023);
        j.byZ().byI().post(new Runnable() {
            private int mzI = 0;
            private final int mzJ = 5;

            public final void run() {
                AppMethodBeat.i(21013);
                Context context = ah.getContext();
                if (context == null) {
                    FreeWifiManufacturerLoadingUI.a(FreeWifiManufacturerLoadingUI.this, 1151, "Wechat hasn't started completely. Wait 5 seconds and retry.");
                    AppMethodBeat.o(21013);
                    return;
                }
                if (!(m.byu() && m.Mx("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI").equals(str))) {
                    ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "It starts to connect portal ssid " + str);
                    FreeWifiManufacturerLoadingUI.a(FreeWifiManufacturerLoadingUI.this, FreeWifiManufacturerLoadingUI.this.getString(R.string.c0k));
                    int byd = new b(str, context).byd();
                    ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "connectRet=".concat(String.valueOf(byd)));
                    if (byd != 0) {
                        FreeWifiManufacturerLoadingUI.a(FreeWifiManufacturerLoadingUI.this, byd, "An attempt to switch to special portal ap failed. connectRet=".concat(String.valueOf(byd)));
                        AppMethodBeat.o(21013);
                        return;
                    }
                }
                bzR();
                AppMethodBeat.o(21013);
            }

            private void bzQ() {
                AppMethodBeat.i(21014);
                ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "_httpRequestForPortalUrl retry.");
                this.mzI++;
                try {
                    Thread.sleep(FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                } catch (InterruptedException e) {
                    ab.e("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "sleep exception. " + e.getMessage());
                }
                bzR();
                AppMethodBeat.o(21014);
            }

            /* JADX WARNING: Removed duplicated region for block: B:73:0x020d  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private void bzR() {
                Exception e;
                Throwable th;
                AppMethodBeat.i(21015);
                String byl = h.b.mtY.byl();
                ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "http request url : ".concat(String.valueOf(byl)));
                FreeWifiManufacturerLoadingUI.a(FreeWifiManufacturerLoadingUI.this, FreeWifiManufacturerLoadingUI.this.getString(R.string.c0g));
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
                            ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "http resp code = ".concat(String.valueOf(responseCode)));
                            if (200 == responseCode) {
                                if (m.Mx("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI").equals(str)) {
                                    String C = FreeWifiManufacturerLoadingUI.C(httpURLConnection2.getInputStream());
                                    ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "response body first line content=".concat(String.valueOf(C)));
                                    if (C.indexOf("wxwifiecho") == -1) {
                                        FreeWifiManufacturerLoadingUI.b(FreeWifiManufacturerLoadingUI.this, byl);
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection2.disconnect();
                                        }
                                        AppMethodBeat.o(21015);
                                        return;
                                    }
                                    FreeWifiManufacturerLoadingUI.a(FreeWifiManufacturerLoadingUI.this, 0, "");
                                    ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "already connected.");
                                    FreeWifiManufacturerLoadingUI.a(FreeWifiManufacturerLoadingUI.this, 0, "");
                                    FreeWifiManufacturerLoadingUI.a(FreeWifiManufacturerLoadingUI.this, FreeWifiManufacturerLoadingUI.this.getString(R.string.c0f));
                                    FreeWifiManufacturerLoadingUI.e(FreeWifiManufacturerLoadingUI.this);
                                    FreeWifiManufacturerLoadingUI.f(FreeWifiManufacturerLoadingUI.this);
                                } else {
                                    FreeWifiManufacturerLoadingUI.a(FreeWifiManufacturerLoadingUI.this, 1150, "Target ssid is not connected.");
                                }
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                AppMethodBeat.o(21015);
                                return;
                            } else if (302 == responseCode) {
                                ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "desc=http response 302 location = %s", httpURLConnection2.getHeaderField("Location"));
                                byl = httpURLConnection2.getHeaderField("Location");
                                if (m.isEmpty(byl)) {
                                    FreeWifiManufacturerLoadingUI.a(FreeWifiManufacturerLoadingUI.this, 1146, "AP cannot response portal url properly.");
                                    if (httpURLConnection2 != null) {
                                        httpURLConnection2.disconnect();
                                    }
                                    AppMethodBeat.o(21015);
                                    return;
                                }
                                FreeWifiManufacturerLoadingUI.b(FreeWifiManufacturerLoadingUI.this, byl);
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                AppMethodBeat.o(21015);
                                return;
                            } else {
                                FreeWifiManufacturerLoadingUI.a(FreeWifiManufacturerLoadingUI.this, 1149, "Ap response code is neither 200 nor 302.");
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                AppMethodBeat.o(21015);
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
                            AppMethodBeat.o(21015);
                            throw th;
                        }
                    }
                    ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "httpUrlConnection is null. _httpRequestForPortalUrl _retryCount=%d, MaxRetryCount=%d", Integer.valueOf(this.mzI), Integer.valueOf(5));
                    if (this.mzI < 5) {
                        bzQ();
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        AppMethodBeat.o(21015);
                        return;
                    }
                    FreeWifiManufacturerLoadingUI.a(FreeWifiManufacturerLoadingUI.this, 1148, "An attempt to connect to ap failed.");
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    AppMethodBeat.o(21015);
                } catch (Exception e3) {
                    e = e3;
                    try {
                        StringWriter stringWriter = new StringWriter();
                        e.printStackTrace(new PrintWriter(stringWriter));
                        ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "ping encounter exception. ".concat(String.valueOf(stringWriter.toString())));
                        if (e instanceof UnknownHostException) {
                            ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "httpUrlConnection throws exception. _httpRequestForPortalUrl _retryCount=%d, MaxRetryCount=%d", Integer.valueOf(this.mzI), Integer.valueOf(5));
                            if (this.mzI < 5) {
                                bzQ();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                AppMethodBeat.o(21015);
                                return;
                            }
                        }
                        FreeWifiManufacturerLoadingUI.a(FreeWifiManufacturerLoadingUI.this, 1153, "An attempt to connect to ap failed.");
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        AppMethodBeat.o(21015);
                    } catch (Throwable th3) {
                        th = th3;
                        if (httpURLConnection != null) {
                        }
                        AppMethodBeat.o(21015);
                        throw th;
                    }
                }
            }
        });
        AppMethodBeat.o(21023);
    }

    private void aJ(int i, String str) {
        AppMethodBeat.i(21024);
        ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "errcode=%d, errmsg=%s", Integer.valueOf(i), str);
        if (i != 0) {
            bzO();
            if (i == 1154) {
                MP(getString(R.string.c0i) + "(031" + k.b.ManufacturerConnectLoading.muQ + "-" + Math.abs(i) + ")");
                AppMethodBeat.o(21024);
                return;
            }
            MP(getString(R.string.c0h) + "(031" + k.b.ManufacturerConnectLoading.muQ + "-" + Math.abs(i) + ")");
            this.mzF.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(21016);
                    FreeWifiManufacturerLoadingUI.this.mzz.setVisibility(0);
                    AppMethodBeat.o(21016);
                }
            }, 0);
        }
        AppMethodBeat.o(21024);
    }

    private void MP(String str) {
        AppMethodBeat.i(21025);
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = str;
        this.mzE.sendMessage(obtain);
        AppMethodBeat.o(21025);
    }

    private static String cc(Context context) {
        AppMethodBeat.i(21026);
        String className;
        try {
            className = ((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
            ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "top activity name =".concat(String.valueOf(className)));
            AppMethodBeat.o(21026);
            return className;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", e, "", new Object[0]);
            className = "(null)";
            AppMethodBeat.o(21026);
            return className;
        }
    }

    static /* synthetic */ String C(InputStream inputStream) {
        AppMethodBeat.i(21029);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String readLine = bufferedReader.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(readLine);
        while (true) {
            String readLine2 = bufferedReader.readLine();
            if (readLine2 != null) {
                stringBuilder.append(readLine2);
            } else {
                ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "response body=" + stringBuilder.toString());
                String Mw = m.Mw(readLine);
                AppMethodBeat.o(21029);
                return Mw;
            }
        }
    }

    static /* synthetic */ void b(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI, final String str) {
        AppMethodBeat.i(21030);
        freeWifiManufacturerLoadingUI.aJ(0, "");
        freeWifiManufacturerLoadingUI.MP(freeWifiManufacturerLoadingUI.getString(R.string.c0j));
        freeWifiManufacturerLoadingUI.bzO();
        ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "opening url : ".concat(String.valueOf(str)));
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(21017);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("show_bottom", false);
                intent.putExtra("allow_wx_schema_url", true);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("stastic_scene", 7);
                intent.putExtra("neverBlockLocalRequest", true);
                if (FreeWifiManufacturerLoadingUI.g(FreeWifiManufacturerLoadingUI.this)) {
                    d.b(ah.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
                AppMethodBeat.o(21017);
            }
        });
        AppMethodBeat.o(21030);
    }

    static /* synthetic */ void f(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        AppMethodBeat.i(21032);
        Intent intent = new Intent();
        intent.putExtra("free_wifi_channel_id", 10);
        intent.setClass(freeWifiManufacturerLoadingUI, FreeWifiSuccUI.class);
        freeWifiManufacturerLoadingUI.startActivity(intent);
        freeWifiManufacturerLoadingUI.finish();
        freeWifiManufacturerLoadingUI.overridePendingTransition(R.anim.df, R.anim.dc);
        AppMethodBeat.o(21032);
    }

    static /* synthetic */ boolean g(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        AppMethodBeat.i(21033);
        String cc = cc(ah.getContext());
        ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "topActivityName : ".concat(String.valueOf(cc)));
        ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "getClas().getName()=" + freeWifiManufacturerLoadingUI.getClass().getName());
        boolean z = cc != null && cc.equals(freeWifiManufacturerLoadingUI.getClass().getName());
        ab.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "ret = ".concat(String.valueOf(z)));
        AppMethodBeat.o(21033);
        return z;
    }
}
