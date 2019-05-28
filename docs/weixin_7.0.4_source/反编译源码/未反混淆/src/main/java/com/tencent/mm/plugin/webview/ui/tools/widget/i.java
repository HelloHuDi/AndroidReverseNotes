package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.GeolocationPermissions.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.xweb.WebView;
import com.tencent.xweb.g;
import com.tencent.xweb.l;

public class i extends l {
    private Activity czX;
    private int uwu = 0;

    public i(MMWebViewWithJsApi mMWebViewWithJsApi) {
        AppMethodBeat.i(9912);
        this.czX = (Activity) mMWebViewWithJsApi.getContext();
        AppMethodBeat.o(9912);
    }

    public void d(WebView webView, String str) {
        AppMethodBeat.i(9913);
        super.d(webView, str);
        AppMethodBeat.o(9913);
    }

    public final void onGeolocationPermissionsShowPrompt(final String str, final Callback callback) {
        AppMethodBeat.i(9914);
        h.a(this.czX, false, this.czX.getString(R.string.g2e, new Object[]{str}), this.czX.getString(R.string.g2f), this.czX.getString(R.string.s6), this.czX.getString(R.string.or), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(9903);
                callback.invoke(str, true, true);
                AppMethodBeat.o(9903);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(9904);
                callback.invoke(str, false, false);
                AppMethodBeat.o(9904);
            }
        });
        AppMethodBeat.o(9914);
    }

    public final boolean a(WebView webView, String str, String str2, final com.tencent.xweb.h hVar) {
        c a;
        AppMethodBeat.i(9915);
        this.uwu++;
        if (this.uwu > 2) {
            a = h.a(this.czX, str2, "", this.czX.getString(R.string.g28), this.czX.getString(R.string.s6), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(9905);
                    hVar.cancel();
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    i.this.onClose();
                    AppMethodBeat.o(9905);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(9906);
                    hVar.confirm();
                    AppMethodBeat.o(9906);
                }
            }, (int) R.color.t7);
        } else {
            a = h.a(this.czX, str2, "", this.czX.getString(R.string.s6), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(9907);
                    hVar.confirm();
                    AppMethodBeat.o(9907);
                }
            });
        }
        if (a != null) {
            a.setCanceledOnTouchOutside(false);
            a.qZ(false);
            AppMethodBeat.o(9915);
            return true;
        }
        boolean a2 = super.a(webView, str, str2, hVar);
        AppMethodBeat.o(9915);
        return a2;
    }

    public final boolean b(WebView webView, String str, String str2, final com.tencent.xweb.h hVar) {
        c a;
        AppMethodBeat.i(9916);
        this.uwu++;
        if (this.uwu > 2) {
            a = h.a(this.czX, str2, "", this.czX.getString(R.string.g28), this.czX.getString(R.string.s6), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(9908);
                    hVar.cancel();
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    i.this.onClose();
                    AppMethodBeat.o(9908);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(9909);
                    hVar.confirm();
                    AppMethodBeat.o(9909);
                }
            }, (int) R.color.hy);
        } else {
            a = h.a(this.czX, false, str2, "", this.czX.getString(R.string.s6), this.czX.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(9910);
                    hVar.confirm();
                    AppMethodBeat.o(9910);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(9911);
                    hVar.cancel();
                    AppMethodBeat.o(9911);
                }
            });
        }
        if (a != null) {
            a.setCancelable(false);
            a.setCanceledOnTouchOutside(false);
            AppMethodBeat.o(9916);
            return true;
        }
        boolean b = super.b(webView, str, str2, hVar);
        AppMethodBeat.o(9916);
        return b;
    }

    public final boolean a(WebView webView, String str, String str2, String str3, g gVar) {
        AppMethodBeat.i(9917);
        boolean a = super.a(webView, str, str2, str3, gVar);
        AppMethodBeat.o(9917);
        return a;
    }

    /* Access modifiers changed, original: protected */
    public void onClose() {
        AppMethodBeat.i(9918);
        this.czX.finish();
        AppMethodBeat.o(9918);
    }
}
