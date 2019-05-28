package com.tencent.p177mm.plugin.webview.p580ui.tools.widget;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.GeolocationPermissions.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.xweb.C41127g;
import com.tencent.xweb.C46945h;
import com.tencent.xweb.C6031l;
import com.tencent.xweb.WebView;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.i */
public class C14672i extends C6031l {
    private Activity czX;
    private int uwu = 0;

    public C14672i(MMWebViewWithJsApi mMWebViewWithJsApi) {
        AppMethodBeat.m2504i(9912);
        this.czX = (Activity) mMWebViewWithJsApi.getContext();
        AppMethodBeat.m2505o(9912);
    }

    /* renamed from: d */
    public void mo7557d(WebView webView, String str) {
        AppMethodBeat.m2504i(9913);
        super.mo7557d(webView, str);
        AppMethodBeat.m2505o(9913);
    }

    public final void onGeolocationPermissionsShowPrompt(final String str, final Callback callback) {
        AppMethodBeat.m2504i(9914);
        C30379h.m48453a(this.czX, false, this.czX.getString(C25738R.string.g2e, new Object[]{str}), this.czX.getString(C25738R.string.g2f), this.czX.getString(C25738R.string.f9187s6), this.czX.getString(C25738R.string.f9076or), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(9903);
                callback.invoke(str, true, true);
                AppMethodBeat.m2505o(9903);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(9904);
                callback.invoke(str, false, false);
                AppMethodBeat.m2505o(9904);
            }
        });
        AppMethodBeat.m2505o(9914);
    }

    /* renamed from: a */
    public final boolean mo13207a(WebView webView, String str, String str2, final C46945h c46945h) {
        C5653c a;
        AppMethodBeat.m2504i(9915);
        this.uwu++;
        if (this.uwu > 2) {
            a = C30379h.m48444a(this.czX, str2, "", this.czX.getString(C25738R.string.g28), this.czX.getString(C25738R.string.f9187s6), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(9905);
                    c46945h.cancel();
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    C14672i.this.onClose();
                    AppMethodBeat.m2505o(9905);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(9906);
                    c46945h.confirm();
                    AppMethodBeat.m2505o(9906);
                }
            }, (int) C25738R.color.f12123t7);
        } else {
            a = C30379h.m48443a(this.czX, str2, "", this.czX.getString(C25738R.string.f9187s6), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(9907);
                    c46945h.confirm();
                    AppMethodBeat.m2505o(9907);
                }
            });
        }
        if (a != null) {
            a.setCanceledOnTouchOutside(false);
            a.mo11498qZ(false);
            AppMethodBeat.m2505o(9915);
            return true;
        }
        boolean a2 = super.mo13207a(webView, str, str2, c46945h);
        AppMethodBeat.m2505o(9915);
        return a2;
    }

    /* renamed from: b */
    public final boolean mo13211b(WebView webView, String str, String str2, final C46945h c46945h) {
        C5653c a;
        AppMethodBeat.m2504i(9916);
        this.uwu++;
        if (this.uwu > 2) {
            a = C30379h.m48444a(this.czX, str2, "", this.czX.getString(C25738R.string.g28), this.czX.getString(C25738R.string.f9187s6), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(9908);
                    c46945h.cancel();
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    C14672i.this.onClose();
                    AppMethodBeat.m2505o(9908);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(9909);
                    c46945h.confirm();
                    AppMethodBeat.m2505o(9909);
                }
            }, (int) C25738R.color.f11809hy);
        } else {
            a = C30379h.m48453a(this.czX, false, str2, "", this.czX.getString(C25738R.string.f9187s6), this.czX.getString(C25738R.string.f9076or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(9910);
                    c46945h.confirm();
                    AppMethodBeat.m2505o(9910);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(9911);
                    c46945h.cancel();
                    AppMethodBeat.m2505o(9911);
                }
            });
        }
        if (a != null) {
            a.setCancelable(false);
            a.setCanceledOnTouchOutside(false);
            AppMethodBeat.m2505o(9916);
            return true;
        }
        boolean b = super.mo13211b(webView, str, str2, c46945h);
        AppMethodBeat.m2505o(9916);
        return b;
    }

    /* renamed from: a */
    public final boolean mo13208a(WebView webView, String str, String str2, String str3, C41127g c41127g) {
        AppMethodBeat.m2504i(9917);
        boolean a = super.mo13208a(webView, str, str2, str3, c41127g);
        AppMethodBeat.m2505o(9917);
        return a;
    }

    /* Access modifiers changed, original: protected */
    public void onClose() {
        AppMethodBeat.m2504i(9918);
        this.czX.finish();
        AppMethodBeat.m2505o(9918);
    }
}
