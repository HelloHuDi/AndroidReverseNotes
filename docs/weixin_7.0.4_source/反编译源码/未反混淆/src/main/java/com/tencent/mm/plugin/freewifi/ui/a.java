package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.g.f;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public final class a extends b {
    private static Date myi = null;
    private TextView gne;
    private boolean hasInit = false;
    private View jyC;
    private View jyD;
    private Runnable myj = new Runnable() {
        public final void run() {
            AppMethodBeat.i(20927);
            final View findViewById = a.this.view.findViewById(R.id.bx0);
            f.dMn().d(new com.tencent.mm.vending.c.a<Boolean, Void>() {
                public final /* synthetic */ Object call(Object obj) {
                    boolean z;
                    AppMethodBeat.i(20926);
                    if (at.getNetType(ah.getContext()) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Boolean valueOf = Boolean.valueOf(z);
                    AppMethodBeat.o(20926);
                    return valueOf;
                }
            }).f(new com.tencent.mm.vending.c.a<Boolean, Boolean>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(20925);
                    Boolean bool = (Boolean) obj;
                    if (bool.booleanValue()) {
                        findViewById.setVisibility(8);
                    }
                    AppMethodBeat.o(20925);
                    return bool;
                }
            }).d(new com.tencent.mm.vending.c.a<Object, Boolean>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(20924);
                    final bk bkVar = new bk();
                    long currentTimeMillis = System.currentTimeMillis();
                    com.tencent.mm.sdk.b.a.xxA.m(bkVar);
                    ab.i("MicroMsg.FreeWifi.FreeWifiBanner", "summeranrt CheckWechatFreeWifiEvent take[%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(20923);
                            if (bo.isNullOrNil(bkVar.cuE.cuJ)) {
                                findViewById.setVisibility(8);
                                AppMethodBeat.o(20923);
                                return;
                            }
                            a.this.gne.setText(bkVar.cuE.cuJ);
                            final String str = bkVar.cuE.cuG;
                            Object obj = AppEventsConstants.EVENT_PARAM_VALUE_NO.equalsIgnoreCase(bkVar.cuE.cuF) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1";
                            final String str2 = bkVar.cuE.cuH;
                            final String str3 = bkVar.cuE.ssid;
                            final String str4 = bkVar.cuE.bssid;
                            final String str5 = bkVar.cuE.cuI;
                            ab.i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=it tries to show bar. pingEnabled = %s,  pingUrl= %s", obj, str);
                            if ("1".equals(obj)) {
                                d.xDH.ak(new Runnable() {
                                    /* JADX WARNING: Removed duplicated region for block: B:30:0x0174  */
                                    /* Code decompiled incorrectly, please refer to instructions dump. */
                                    public final void run() {
                                        Exception e;
                                        Throwable th;
                                        AppMethodBeat.i(20922);
                                        ab.i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=it tries to ping. pingUrl= %s", str);
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
                                                    h.pYm.e(12907, str3, str4, str5, str2, "", Long.valueOf(currentTimeMillis2), Integer.valueOf(responseCode), "", "", "");
                                                    ab.i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=ping ended. http response code = %d, cost=%d ms", Integer.valueOf(responseCode), Long.valueOf(currentTimeMillis2));
                                                    if (200 == responseCode) {
                                                        al.d(new Runnable() {
                                                            public final void run() {
                                                                AppMethodBeat.i(20921);
                                                                findViewById.setVisibility(0);
                                                                AppMethodBeat.o(20921);
                                                            }
                                                        });
                                                    } else if (302 == responseCode) {
                                                        ab.i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=http response 302 location = %s", httpURLConnection2.getHeaderField("Location"));
                                                    }
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    httpURLConnection = httpURLConnection2;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    httpURLConnection = httpURLConnection2;
                                                    if (httpURLConnection != null) {
                                                    }
                                                    AppMethodBeat.o(20922);
                                                    throw th;
                                                }
                                            }
                                            if (httpURLConnection2 != null) {
                                                httpURLConnection2.disconnect();
                                                AppMethodBeat.o(20922);
                                                return;
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            try {
                                                StringWriter stringWriter = new StringWriter();
                                                e.printStackTrace(new PrintWriter(stringWriter));
                                                String stringWriter2 = stringWriter.toString();
                                                ab.i("MicroMsg.FreeWifi.FreeWifiBanner", "ping encounter exception. ".concat(String.valueOf(stringWriter2)));
                                                if (stringWriter2 == null) {
                                                    stringWriter2 = "";
                                                }
                                                h hVar = h.pYm;
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
                                                hVar.e(12907, objArr);
                                                if (httpURLConnection != null) {
                                                    httpURLConnection.disconnect();
                                                    AppMethodBeat.o(20922);
                                                    return;
                                                }
                                                AppMethodBeat.o(20922);
                                            } catch (Throwable th3) {
                                                th = th3;
                                                if (httpURLConnection != null) {
                                                    httpURLConnection.disconnect();
                                                }
                                                AppMethodBeat.o(20922);
                                                throw th;
                                            }
                                        }
                                        AppMethodBeat.o(20922);
                                    }
                                });
                                AppMethodBeat.o(20923);
                                return;
                            }
                            findViewById.setVisibility(0);
                            AppMethodBeat.o(20923);
                        }
                    });
                    AppMethodBeat.o(20924);
                    return null;
                }
            });
            AppMethodBeat.o(20927);
        }
    };

    public a(Context context) {
        super(context);
        AppMethodBeat.i(20928);
        initialize();
        AppMethodBeat.o(20928);
    }

    public final int getLayoutId() {
        return R.layout.a0w;
    }

    private void initialize() {
        AppMethodBeat.i(20929);
        if (this.view != null) {
            if (this.hasInit) {
                AppMethodBeat.o(20929);
                return;
            }
            this.jyC = this.view.findViewById(R.id.bx0);
            this.jyD = this.view.findViewById(R.id.a2a);
            this.gne = (TextView) this.view.findViewById(R.id.bx1);
            this.hasInit = true;
            this.jyC.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(20920);
                    Date date = new Date();
                    if (a.myi == null || date.getTime() - a.myi.getTime() >= 1000) {
                        a.myi = date;
                        Intent intent = new Intent();
                        intent.putExtra("free_wifi_source", 2);
                        intent.addFlags(67108864);
                        com.tencent.mm.bp.d.b((Context) a.this.vlu.get(), "freewifi", ".ui.FreeWifiEntryUI", intent);
                        AppMethodBeat.o(20920);
                        return;
                    }
                    AppMethodBeat.o(20920);
                }
            });
            this.jyC.setVisibility(8);
        }
        AppMethodBeat.o(20929);
    }

    public final void destroy() {
    }

    public final boolean aMN() {
        AppMethodBeat.i(20930);
        if (this.nfA && this.eVH) {
            this.jyD.setBackgroundResource(R.drawable.a3h);
            this.jyC.setBackground(null);
            this.gne.setBackground(null);
        } else if (this.nfA) {
            this.jyD.setBackgroundResource(R.drawable.r9);
            this.jyC.setBackgroundResource(R.drawable.b7t);
            this.gne.setBackgroundResource(R.drawable.a_q);
        } else if (this.eVH) {
            this.jyD.setBackgroundResource(R.drawable.r9);
            this.jyC.setBackgroundResource(R.drawable.a_q);
            this.gne.setBackground(null);
        } else {
            this.jyD.setBackgroundResource(R.drawable.r9);
            this.jyC.setBackground(null);
            this.gne.setBackgroundResource(R.drawable.a_q);
        }
        if (this.hasInit) {
            al.af(this.myj);
            al.n(this.myj, 500);
            AppMethodBeat.o(20930);
            return true;
        }
        initialize();
        AppMethodBeat.o(20930);
        return false;
    }
}
