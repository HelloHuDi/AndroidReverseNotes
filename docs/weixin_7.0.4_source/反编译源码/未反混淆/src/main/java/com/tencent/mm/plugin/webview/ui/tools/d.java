package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.http.SslCertificate;
import android.net.http.SslCertificate.DName;
import android.net.http.SslError;
import android.util.Base64;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.xweb.WebView;
import com.tencent.xweb.j;
import java.lang.reflect.Field;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20141210", reviewer = 20, vComment = {EType.HTTPSCHECK})
public final class d {
    Context context;
    private c gLj = null;
    private List<String> ipm = null;
    private KeyStore ipn = null;
    private final SimpleDateFormat pJi = new SimpleDateFormat("yyyy-MM-dd HH:mmZ", Locale.getDefault());
    WebView urJ;
    Map<String, List<j>> urK;
    Map<String, Boolean> urL;

    public d(Context context, WebView webView) {
        AppMethodBeat.i(7408);
        this.context = context;
        this.urJ = webView;
        this.urK = new HashMap();
        this.urL = new HashMap();
        AppMethodBeat.o(7408);
    }

    private boolean b(SslCertificate sslCertificate) {
        AppMethodBeat.i(7409);
        if (sslCertificate == null) {
            ab.i("MicroMsg.WebView.MMSslErrorHandler", "isUserCertificates sslCertificate is null");
            AppMethodBeat.o(7409);
            return false;
        }
        boolean z;
        ab.i("MicroMsg.WebView.MMSslErrorHandler", "isUserCertificates dnName = %s", sslCertificate.getIssuedBy().getDName());
        try {
            String str;
            Field declaredField = sslCertificate.getClass().getDeclaredField("mX509Certificate");
            declaredField.setAccessible(true);
            X509Certificate x509Certificate = (X509Certificate) declaredField.get(sslCertificate);
            if (this.ipn == null) {
                this.ipn = KeyStore.getInstance("AndroidCAStore");
                this.ipn.load(null, null);
            }
            if (this.ipm == null) {
                this.ipm = new ArrayList();
                Enumeration aliases = this.ipn.aliases();
                while (aliases.hasMoreElements()) {
                    str = (String) aliases.nextElement();
                    if (str != null && str.startsWith("user:")) {
                        this.ipm.add(str);
                    }
                }
            }
            for (String str2 : this.ipm) {
                try {
                    x509Certificate.verify(((X509Certificate) this.ipn.getCertificate(str2)).getPublicKey());
                    z = true;
                    break;
                } catch (Exception e) {
                }
            }
            z = false;
        } catch (Exception e2) {
            ab.e("MicroMsg.WebView.MMSslErrorHandler", "isUserCertificates ex %s", e2.getMessage());
            z = false;
        }
        AppMethodBeat.o(7409);
        return z;
    }

    public final void a(final String str, j jVar, SslError sslError) {
        AppMethodBeat.i(7410);
        ab.e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError, currentUrl = %s", str);
        if (this.urJ == null) {
            ab.e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError fail, has been detached");
            AppMethodBeat.o(7410);
        } else if (bo.isNullOrNil(str)) {
            jVar.cancel();
            AppMethodBeat.o(7410);
        } else {
            Boolean bool = (Boolean) this.urL.get(str);
            if (bool != null) {
                ab.v("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError, already selected = %b", bool);
                if (bool.booleanValue()) {
                    jVar.proceed();
                    AppMethodBeat.o(7410);
                    return;
                }
                jVar.cancel();
                AppMethodBeat.o(7410);
                return;
            }
            try {
                ab.i("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError skipUserCert = %d", Integer.valueOf(((a) g.K(a.class)).a(a.a.clicfg_webview_skip_user_cert, 1)));
                if (((a) g.K(a.class)).a(a.a.clicfg_webview_skip_user_cert, 1) == 1 && b(sslError.getCertificate())) {
                    ab.i("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError use user certificatess");
                    this.urL.put(str, Boolean.TRUE);
                    jVar.proceed();
                    AppMethodBeat.o(7410);
                    return;
                }
            } catch (Exception e) {
                ab.e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError : " + e.getLocalizedMessage());
            }
            try {
                URL url = new URL(str);
                if (((a) g.K(a.class)).a(a.a.clicfg_webview_show_ssl_dialog, 1) == 1 && url.getHost().endsWith(".qq.com")) {
                    List list = (List) this.urK.get(str);
                    if (list == null || list.size() == 0) {
                        a(str, sslError);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(jVar);
                        this.urK.put(str, arrayList);
                        if (this.gLj == null || !this.gLj.isShowing()) {
                            this.gLj = h.a(this.context, false, this.context.getString(R.string.g1t, new Object[]{url.getHost()}), this.context.getString(R.string.g1u), this.context.getString(R.string.ox), this.context.getString(R.string.g1), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(7406);
                                    List<j> list = (List) d.this.urK.get(str);
                                    if (list == null) {
                                        ab.e("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, continue selected, list should not be null");
                                        AppMethodBeat.o(7406);
                                        return;
                                    }
                                    d.this.urL.put(str, Boolean.FALSE);
                                    ab.i("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, continue selected, list size = %d", Integer.valueOf(list.size()));
                                    for (j cancel : list) {
                                        cancel.cancel();
                                    }
                                    list.clear();
                                    d.this.urJ.clearSslPreferences();
                                    com.tencent.mm.plugin.webview.modeltools.a aVar = new com.tencent.mm.plugin.webview.modeltools.a();
                                    com.tencent.mm.plugin.webview.modeltools.a.e((Activity) d.this.context, str);
                                    AppMethodBeat.o(7406);
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(7407);
                                    List<j> list = (List) d.this.urK.get(str);
                                    if (list == null) {
                                        ab.e("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, cancel selected, list should not be null");
                                        AppMethodBeat.o(7407);
                                        return;
                                    }
                                    d.this.urL.put(str, Boolean.FALSE);
                                    ab.i("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, cancel selected, list size = %d", Integer.valueOf(list.size()));
                                    for (j cancel : list) {
                                        cancel.cancel();
                                    }
                                    list.clear();
                                    d.this.urJ.clearSslPreferences();
                                    AppMethodBeat.o(7407);
                                }
                            });
                            AppMethodBeat.o(7410);
                            return;
                        }
                        jVar.cancel();
                        AppMethodBeat.o(7410);
                        return;
                    }
                    list.add(jVar);
                    AppMethodBeat.o(7410);
                    return;
                }
                ab.d("MicroMsg.WebView.MMSslErrorHandler", "host = " + url.getHost() + ", but it not end with '.qq.com'");
                jVar.cancel();
                AppMethodBeat.o(7410);
            } catch (Exception e2) {
                ab.e("MicroMsg.WebView.MMSslErrorHandler", "create url fail : " + e2.getLocalizedMessage());
                AppMethodBeat.o(7410);
            }
        }
    }

    @TargetApi(8)
    private void a(String str, SslError sslError) {
        AppMethodBeat.i(7411);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1");
        stringBuilder.append(",");
        stringBuilder.append(b(str, sslError));
        ab.i("MicroMsg.WebView.MMSslErrorHandler", "reportWebViewSslError, value = %s", stringBuilder.toString());
        com.tencent.mm.plugin.report.service.h.pYm.X(11098, r0);
        AppMethodBeat.o(7411);
    }

    @TargetApi(14)
    private String b(String str, SslError sslError) {
        AppMethodBeat.i(7412);
        String validNotBefore;
        try {
            Object obj;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<sslerror>");
            stringBuilder.append("<primaryerror>");
            if (sslError == null) {
                obj = "-1";
            } else {
                obj = Integer.valueOf(sslError.getPrimaryError());
            }
            stringBuilder.append(obj);
            stringBuilder.append("</primaryerror>");
            stringBuilder.append("<clienttime>");
            stringBuilder.append(Base64.encodeToString(this.pJi.format(new Date()).getBytes(), 0));
            stringBuilder.append("</clienttime>");
            stringBuilder.append("<currenturl>");
            if (!bo.isNullOrNil(str)) {
                stringBuilder.append(bo.ani(str));
            }
            stringBuilder.append("</currenturl>");
            SslCertificate certificate = sslError == null ? null : sslError.getCertificate();
            if (certificate != null) {
                DName issuedBy = certificate.getIssuedBy();
                if (issuedBy != null) {
                    stringBuilder.append("<issuedby>");
                    if (issuedBy.getDName() != null) {
                        stringBuilder.append(Base64.encodeToString(issuedBy.getDName().getBytes(), 0));
                    }
                    stringBuilder.append("</issuedby>");
                }
                issuedBy = certificate.getIssuedTo();
                if (issuedBy != null) {
                    stringBuilder.append("<issuedto>");
                    if (issuedBy.getDName() != null) {
                        stringBuilder.append(Base64.encodeToString(issuedBy.getDName().getBytes(), 0));
                    }
                    stringBuilder.append("</issuedto>");
                }
                String validNotAfter = certificate.getValidNotAfter();
                if (validNotAfter != null) {
                    stringBuilder.append("<getvalidnotafter>");
                    stringBuilder.append(Base64.encodeToString(validNotAfter.getBytes(), 0));
                    stringBuilder.append("</getvalidnotafter>");
                }
                validNotBefore = certificate.getValidNotBefore();
                if (validNotBefore != null) {
                    stringBuilder.append("<getvalidnotbefore>");
                    stringBuilder.append(Base64.encodeToString(validNotBefore.getBytes(), 0));
                    stringBuilder.append("</getvalidnotbefore>");
                }
            }
            stringBuilder.append("</sslerror>");
            validNotBefore = stringBuilder.toString();
            AppMethodBeat.o(7412);
            return validNotBefore;
        } catch (Exception e) {
            ab.w("MicroMsg.WebView.MMSslErrorHandler", "buildXml ex = %s", e.getMessage());
            validNotBefore = "";
            AppMethodBeat.o(7412);
            return validNotBefore;
        }
    }
}
