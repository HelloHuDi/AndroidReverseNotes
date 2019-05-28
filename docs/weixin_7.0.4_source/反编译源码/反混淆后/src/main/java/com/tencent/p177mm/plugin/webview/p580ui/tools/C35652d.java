package com.tencent.p177mm.plugin.webview.p580ui.tools;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.http.SslCertificate;
import android.net.http.SslCertificate.DName;
import android.net.http.SslError;
import android.util.Base64;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.modeltools.C35618a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.xweb.C36588j;
import com.tencent.xweb.WebView;
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
/* renamed from: com.tencent.mm.plugin.webview.ui.tools.d */
public final class C35652d {
    Context context;
    private C5653c gLj = null;
    private List<String> ipm = null;
    private KeyStore ipn = null;
    private final SimpleDateFormat pJi = new SimpleDateFormat("yyyy-MM-dd HH:mmZ", Locale.getDefault());
    WebView urJ;
    Map<String, List<C36588j>> urK;
    Map<String, Boolean> urL;

    public C35652d(Context context, WebView webView) {
        AppMethodBeat.m2504i(7408);
        this.context = context;
        this.urJ = webView;
        this.urK = new HashMap();
        this.urL = new HashMap();
        AppMethodBeat.m2505o(7408);
    }

    /* renamed from: b */
    private boolean m58506b(SslCertificate sslCertificate) {
        AppMethodBeat.m2504i(7409);
        if (sslCertificate == null) {
            C4990ab.m7416i("MicroMsg.WebView.MMSslErrorHandler", "isUserCertificates sslCertificate is null");
            AppMethodBeat.m2505o(7409);
            return false;
        }
        boolean z;
        C4990ab.m7417i("MicroMsg.WebView.MMSslErrorHandler", "isUserCertificates dnName = %s", sslCertificate.getIssuedBy().getDName());
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
            C4990ab.m7413e("MicroMsg.WebView.MMSslErrorHandler", "isUserCertificates ex %s", e2.getMessage());
            z = false;
        }
        AppMethodBeat.m2505o(7409);
        return z;
    }

    /* renamed from: a */
    public final void mo56360a(final String str, C36588j c36588j, SslError sslError) {
        AppMethodBeat.m2504i(7410);
        C4990ab.m7413e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError, currentUrl = %s", str);
        if (this.urJ == null) {
            C4990ab.m7412e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError fail, has been detached");
            AppMethodBeat.m2505o(7410);
        } else if (C5046bo.isNullOrNil(str)) {
            c36588j.cancel();
            AppMethodBeat.m2505o(7410);
        } else {
            Boolean bool = (Boolean) this.urL.get(str);
            if (bool != null) {
                C4990ab.m7419v("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError, already selected = %b", bool);
                if (bool.booleanValue()) {
                    c36588j.proceed();
                    AppMethodBeat.m2505o(7410);
                    return;
                }
                c36588j.cancel();
                AppMethodBeat.m2505o(7410);
                return;
            }
            try {
                C4990ab.m7417i("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError skipUserCert = %d", Integer.valueOf(((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_webview_skip_user_cert, 1)));
                if (((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_webview_skip_user_cert, 1) == 1 && m58506b(sslError.getCertificate())) {
                    C4990ab.m7416i("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError use user certificatess");
                    this.urL.put(str, Boolean.TRUE);
                    c36588j.proceed();
                    AppMethodBeat.m2505o(7410);
                    return;
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError : " + e.getLocalizedMessage());
            }
            try {
                URL url = new URL(str);
                if (((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_webview_show_ssl_dialog, 1) == 1 && url.getHost().endsWith(".qq.com")) {
                    List list = (List) this.urK.get(str);
                    if (list == null || list.size() == 0) {
                        m58504a(str, sslError);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(c36588j);
                        this.urK.put(str, arrayList);
                        if (this.gLj == null || !this.gLj.isShowing()) {
                            this.gLj = C30379h.m48453a(this.context, false, this.context.getString(C25738R.string.g1t, new Object[]{url.getHost()}), this.context.getString(C25738R.string.g1u), this.context.getString(C25738R.string.f9081ox), this.context.getString(C25738R.string.f8823g1), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(7406);
                                    List<C36588j> list = (List) C35652d.this.urK.get(str);
                                    if (list == null) {
                                        C4990ab.m7412e("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, continue selected, list should not be null");
                                        AppMethodBeat.m2505o(7406);
                                        return;
                                    }
                                    C35652d.this.urL.put(str, Boolean.FALSE);
                                    C4990ab.m7417i("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, continue selected, list size = %d", Integer.valueOf(list.size()));
                                    for (C36588j cancel : list) {
                                        cancel.cancel();
                                    }
                                    list.clear();
                                    C35652d.this.urJ.clearSslPreferences();
                                    C35618a c35618a = new C35618a();
                                    C35618a.m58463e((Activity) C35652d.this.context, str);
                                    AppMethodBeat.m2505o(7406);
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(7407);
                                    List<C36588j> list = (List) C35652d.this.urK.get(str);
                                    if (list == null) {
                                        C4990ab.m7412e("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, cancel selected, list should not be null");
                                        AppMethodBeat.m2505o(7407);
                                        return;
                                    }
                                    C35652d.this.urL.put(str, Boolean.FALSE);
                                    C4990ab.m7417i("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, cancel selected, list size = %d", Integer.valueOf(list.size()));
                                    for (C36588j cancel : list) {
                                        cancel.cancel();
                                    }
                                    list.clear();
                                    C35652d.this.urJ.clearSslPreferences();
                                    AppMethodBeat.m2505o(7407);
                                }
                            });
                            AppMethodBeat.m2505o(7410);
                            return;
                        }
                        c36588j.cancel();
                        AppMethodBeat.m2505o(7410);
                        return;
                    }
                    list.add(c36588j);
                    AppMethodBeat.m2505o(7410);
                    return;
                }
                C4990ab.m7410d("MicroMsg.WebView.MMSslErrorHandler", "host = " + url.getHost() + ", but it not end with '.qq.com'");
                c36588j.cancel();
                AppMethodBeat.m2505o(7410);
            } catch (Exception e2) {
                C4990ab.m7412e("MicroMsg.WebView.MMSslErrorHandler", "create url fail : " + e2.getLocalizedMessage());
                AppMethodBeat.m2505o(7410);
            }
        }
    }

    @TargetApi(8)
    /* renamed from: a */
    private void m58504a(String str, SslError sslError) {
        AppMethodBeat.m2504i(7411);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1");
        stringBuilder.append(",");
        stringBuilder.append(m58505b(str, sslError));
        C4990ab.m7417i("MicroMsg.WebView.MMSslErrorHandler", "reportWebViewSslError, value = %s", stringBuilder.toString());
        C7060h.pYm.mo8374X(11098, r0);
        AppMethodBeat.m2505o(7411);
    }

    @TargetApi(14)
    /* renamed from: b */
    private String m58505b(String str, SslError sslError) {
        AppMethodBeat.m2504i(7412);
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
            if (!C5046bo.isNullOrNil(str)) {
                stringBuilder.append(C5046bo.ani(str));
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
            AppMethodBeat.m2505o(7412);
            return validNotBefore;
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.WebView.MMSslErrorHandler", "buildXml ex = %s", e.getMessage());
            validNotBefore = "";
            AppMethodBeat.m2505o(7412);
            return validNotBefore;
        }
    }
}
