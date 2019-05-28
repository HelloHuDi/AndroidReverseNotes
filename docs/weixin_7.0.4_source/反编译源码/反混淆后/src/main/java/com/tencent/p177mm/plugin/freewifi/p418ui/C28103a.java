package com.tencent.p177mm.plugin.freewifi.p418ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p230g.p231a.C6462bk;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C14933b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5698f;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/* renamed from: com.tencent.mm.plugin.freewifi.ui.a */
public final class C28103a extends C14933b {
    private static Date myi = null;
    private TextView gne;
    private boolean hasInit = false;
    private View jyC;
    private View jyD;
    private Runnable myj = new C208232();

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.a$2 */
    class C208232 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.freewifi.ui.a$2$3 */
        class C208263 implements C5681a<Boolean, Void> {
            C208263() {
            }

            public final /* synthetic */ Object call(Object obj) {
                boolean z;
                AppMethodBeat.m2504i(20926);
                if (C5023at.getNetType(C4996ah.getContext()) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                Boolean valueOf = Boolean.valueOf(z);
                AppMethodBeat.m2505o(20926);
                return valueOf;
            }
        }

        C208232() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20927);
            final View findViewById = C28103a.this.view.findViewById(2131824170);
            C5698f.dMn().mo15893d(new C208263()).mo15896f(new C5681a<Boolean, Boolean>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.m2504i(20925);
                    Boolean bool = (Boolean) obj;
                    if (bool.booleanValue()) {
                        findViewById.setVisibility(8);
                    }
                    AppMethodBeat.m2505o(20925);
                    return bool;
                }
            }).mo15893d(new C5681a<Object, Boolean>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.m2504i(20924);
                    final C6462bk c6462bk = new C6462bk();
                    long currentTimeMillis = System.currentTimeMillis();
                    C4879a.xxA.mo10055m(c6462bk);
                    C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiBanner", "summeranrt CheckWechatFreeWifiEvent take[%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(20923);
                            if (C5046bo.isNullOrNil(c6462bk.cuE.cuJ)) {
                                findViewById.setVisibility(8);
                                AppMethodBeat.m2505o(20923);
                                return;
                            }
                            C28103a.this.gne.setText(c6462bk.cuE.cuJ);
                            final String str = c6462bk.cuE.cuG;
                            Object obj = AppEventsConstants.EVENT_PARAM_VALUE_NO.equalsIgnoreCase(c6462bk.cuE.cuF) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1";
                            final String str2 = c6462bk.cuE.cuH;
                            final String str3 = c6462bk.cuE.ssid;
                            final String str4 = c6462bk.cuE.bssid;
                            final String str5 = c6462bk.cuE.cuI;
                            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=it tries to show bar. pingEnabled = %s,  pingUrl= %s", obj, str);
                            if ("1".equals(obj)) {
                                C7305d.xDH.mo10142ak(new Runnable() {

                                    /* renamed from: com.tencent.mm.plugin.freewifi.ui.a$2$1$1$1$1 */
                                    class C208221 implements Runnable {
                                        C208221() {
                                        }

                                        public final void run() {
                                            AppMethodBeat.m2504i(20921);
                                            findViewById.setVisibility(0);
                                            AppMethodBeat.m2505o(20921);
                                        }
                                    }

                                    /* JADX WARNING: Removed duplicated region for block: B:30:0x0174  */
                                    /* Code decompiled incorrectly, please refer to instructions dump. */
                                    public final void run() {
                                        Exception e;
                                        Throwable th;
                                        AppMethodBeat.m2504i(20922);
                                        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=it tries to ping. pingUrl= %s", str);
                                        HttpURLConnection httpURLConnection = null;
                                        try {
                                            URL url = new URL(str);
                                            long currentTimeMillis = System.currentTimeMillis();
                                            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                                            if (httpURLConnection2 != null) {
                                                try {
                                                    httpURLConnection2.setConnectTimeout(5000);
                                                    httpURLConnection2.setReadTimeout(5000);
                                                    httpURLConnection2.setInstanceFollowRedirects(false);
                                                    httpURLConnection2.setUseCaches(false);
                                                    httpURLConnection2.setRequestProperty("Pragma", "no-cache");
                                                    httpURLConnection2.setRequestProperty("Cache-Control", "no-cache");
                                                    int responseCode = httpURLConnection2.getResponseCode();
                                                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                                    C7060h.pYm.mo8381e(12907, str3, str4, str5, str2, "", Long.valueOf(currentTimeMillis2), Integer.valueOf(responseCode), "", "", "");
                                                    C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=ping ended. http response code = %d, cost=%d ms", Integer.valueOf(responseCode), Long.valueOf(currentTimeMillis2));
                                                    if (200 == responseCode) {
                                                        C5004al.m7441d(new C208221());
                                                    } else if (302 == responseCode) {
                                                        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=http response 302 location = %s", httpURLConnection2.getHeaderField("Location"));
                                                    }
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    httpURLConnection = httpURLConnection2;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    httpURLConnection = httpURLConnection2;
                                                    if (httpURLConnection != null) {
                                                    }
                                                    AppMethodBeat.m2505o(20922);
                                                    throw th;
                                                }
                                            }
                                            if (httpURLConnection2 != null) {
                                                httpURLConnection2.disconnect();
                                                AppMethodBeat.m2505o(20922);
                                                return;
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            try {
                                                StringWriter stringWriter = new StringWriter();
                                                e.printStackTrace(new PrintWriter(stringWriter));
                                                String stringWriter2 = stringWriter.toString();
                                                C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiBanner", "ping encounter exception. ".concat(String.valueOf(stringWriter2)));
                                                if (stringWriter2 == null) {
                                                    stringWriter2 = "";
                                                }
                                                C7060h c7060h = C7060h.pYm;
                                                Object[] objArr = new Object[10];
                                                objArr[0] = str3;
                                                objArr[1] = str4;
                                                objArr[2] = str5;
                                                objArr[3] = str2;
                                                objArr[4] = "";
                                                objArr[5] = Integer.valueOf(0);
                                                objArr[6] = Integer.valueOf(0);
                                                objArr[7] = "";
                                                objArr[8] = "";
                                                if (stringWriter2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                                                    stringWriter2 = stringWriter2.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                                                }
                                                objArr[9] = stringWriter2;
                                                c7060h.mo8381e(12907, objArr);
                                                if (httpURLConnection != null) {
                                                    httpURLConnection.disconnect();
                                                    AppMethodBeat.m2505o(20922);
                                                    return;
                                                }
                                                AppMethodBeat.m2505o(20922);
                                            } catch (Throwable th3) {
                                                th = th3;
                                                if (httpURLConnection != null) {
                                                    httpURLConnection.disconnect();
                                                }
                                                AppMethodBeat.m2505o(20922);
                                                throw th;
                                            }
                                        }
                                        AppMethodBeat.m2505o(20922);
                                    }
                                });
                                AppMethodBeat.m2505o(20923);
                                return;
                            }
                            findViewById.setVisibility(0);
                            AppMethodBeat.m2505o(20923);
                        }
                    });
                    AppMethodBeat.m2505o(20924);
                    return null;
                }
            });
            AppMethodBeat.m2505o(20927);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.a$1 */
    class C281041 implements OnClickListener {
        C281041() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20920);
            Date date = new Date();
            if (C28103a.myi == null || date.getTime() - C28103a.myi.getTime() >= 1000) {
                C28103a.myi = date;
                Intent intent = new Intent();
                intent.putExtra("free_wifi_source", 2);
                intent.addFlags(67108864);
                C25985d.m41467b((Context) C28103a.this.vlu.get(), "freewifi", ".ui.FreeWifiEntryUI", intent);
                AppMethodBeat.m2505o(20920);
                return;
            }
            AppMethodBeat.m2505o(20920);
        }
    }

    public C28103a(Context context) {
        super(context);
        AppMethodBeat.m2504i(20928);
        initialize();
        AppMethodBeat.m2505o(20928);
    }

    public final int getLayoutId() {
        return 2130969601;
    }

    private void initialize() {
        AppMethodBeat.m2504i(20929);
        if (this.view != null) {
            if (this.hasInit) {
                AppMethodBeat.m2505o(20929);
                return;
            }
            this.jyC = this.view.findViewById(2131824170);
            this.jyD = this.view.findViewById(2131821629);
            this.gne = (TextView) this.view.findViewById(2131824171);
            this.hasInit = true;
            this.jyC.setOnClickListener(new C281041());
            this.jyC.setVisibility(8);
        }
        AppMethodBeat.m2505o(20929);
    }

    public final void destroy() {
    }

    public final boolean aMN() {
        AppMethodBeat.m2504i(20930);
        if (this.nfA && this.eVH) {
            this.jyD.setBackgroundResource(C25738R.drawable.a3h);
            this.jyC.setBackground(null);
            this.gne.setBackground(null);
        } else if (this.nfA) {
            this.jyD.setBackgroundResource(C25738R.drawable.f6802r9);
            this.jyC.setBackgroundResource(C25738R.drawable.b7t);
            this.gne.setBackgroundResource(C25738R.drawable.a_q);
        } else if (this.eVH) {
            this.jyD.setBackgroundResource(C25738R.drawable.f6802r9);
            this.jyC.setBackgroundResource(C25738R.drawable.a_q);
            this.gne.setBackground(null);
        } else {
            this.jyD.setBackgroundResource(C25738R.drawable.f6802r9);
            this.jyC.setBackground(null);
            this.gne.setBackgroundResource(C25738R.drawable.a_q);
        }
        if (this.hasInit) {
            C5004al.m7439af(this.myj);
            C5004al.m7442n(this.myj, 500);
            AppMethodBeat.m2505o(20930);
            return true;
        }
        initialize();
        AppMethodBeat.m2505o(20930);
        return false;
    }
}
