package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.plugin.webview.modeltools.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.xweb.x5.a.a.a.a.b;
import java.lang.ref.WeakReference;

public class c extends b {
    private final WeakReference<WebViewUI> uqV;

    public c(WebViewUI webViewUI) {
        AppMethodBeat.i(7380);
        this.uqV = new WeakReference(webViewUI);
        AppMethodBeat.o(7380);
    }

    public Object onMiscCallBack(String str, Bundle bundle) {
        boolean z;
        OnCancelListener onCancelListener = null;
        AppMethodBeat.i(7381);
        String str2 = "MicroMsg.WebViewLongClickHelper";
        String str3 = "method = %s, bundler == null ? %b, invoker == null ? %b";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(bundle == null);
        if (cZv() == null || cZv().icy == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        ab.i(str2, str3, objArr);
        if (!(bo.isNullOrNil(str) || bundle == null)) {
            int i;
            if (cZv() == null || cZv().isFinishing()) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0 && cZv().icy != null) {
                String afk;
                try {
                    afk = cZv().icy.afk("WebviewEnableTbsDownload");
                } catch (Exception e) {
                    ab.e("MicroMsg.WebViewLongClickHelper", "get dynamic config failed");
                    Object afk2 = onCancelListener;
                }
                ab.i("MicroMsg.WebViewLongClickHelper", "enable value = %s", afk2);
                if (bo.isNullOrNil(afk2) || !afk2.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    Bundle g;
                    Object valueOf;
                    if (str.equals(JsApiAddDownloadTask.NAME)) {
                        try {
                            g = cZv().icy.g(14, bundle);
                            if (g != null) {
                                valueOf = Long.valueOf(g.getLong("download_id", 0));
                                AppMethodBeat.o(7381);
                                return valueOf;
                            }
                        } catch (RemoteException e2) {
                            ab.e("MicroMsg.WebViewLongClickHelper", "invoke the add downloadtask failed");
                        }
                    }
                    if (str.equals(JsApiCancelDownloadTask.NAME)) {
                        try {
                            g = cZv().icy.g(16, bundle);
                            if (g != null) {
                                valueOf = Boolean.valueOf(g.getBoolean("cancel_result", false));
                                AppMethodBeat.o(7381);
                                return valueOf;
                            }
                        } catch (RemoteException e3) {
                            ab.e("MicroMsg.WebViewLongClickHelper", "invoke the cancel downloadtask failed");
                        }
                    }
                    if (str.equals(JsApiQueryDownloadTask.NAME)) {
                        try {
                            g = cZv().icy.g(15, bundle);
                            if (g != null) {
                                valueOf = Integer.valueOf(g.getInt("download_state", 0));
                                AppMethodBeat.o(7381);
                                return valueOf;
                            }
                        } catch (RemoteException e4) {
                            ab.e("MicroMsg.WebViewLongClickHelper", "invoke the queryDownloadTask downloadtask failed");
                        }
                    }
                    if (str.equals(JsApiInstallDownloadTask.NAME)) {
                        try {
                            g = cZv().icy.g(17, bundle);
                            if (g != null) {
                                valueOf = Boolean.valueOf(g.getBoolean("install_result"));
                                AppMethodBeat.o(7381);
                                return valueOf;
                            }
                        } catch (RemoteException e5) {
                            ab.e("MicroMsg.WebViewLongClickHelper", "invoke the install downloadtask failed");
                        }
                    }
                    if (str.equals("getDrawable")) {
                        str2 = bundle.getString(DownloadInfoColumns.PACKAGENAME);
                        i = bundle.getInt("resourceId");
                        if (!bo.isNullOrNil(str2) && i > 0) {
                            try {
                                valueOf = com.tencent.mm.ca.b.e(ah.getContext().getPackageManager().getResourcesForApplication(str2), i);
                                AppMethodBeat.o(7381);
                                return valueOf;
                            } catch (Exception e6) {
                                ab.e("MicroMsg.WebViewLongClickHelper", "get resource for package : %s, fail, : %s", str2, e6.getMessage());
                            }
                        }
                    }
                    if (str.equals("getShareUrl")) {
                        try {
                            ab.i("MicroMsg.WebViewLongClickHelper", "getShareUrl by x5 core, shareurl = %s", cZv().icy.aek(cZv().pzf.getUrl()));
                            AppMethodBeat.o(7381);
                            return afk2;
                        } catch (Exception e7) {
                            ab.e("MicroMsg.WebViewLongClickHelper", "getShare url failed");
                        }
                    }
                    com.tencent.mm.plugin.webview.b bVar;
                    if (str.equals("smartPickWord")) {
                        valueOf = f.a(bundle, cZv().dae(), cZv().mController.getMMTitle() != null ? cZv().mController.getMMTitle().toString() : "");
                        AppMethodBeat.o(7381);
                        return valueOf;
                    } else if (str.equals("jumpToSos")) {
                        try {
                            f.U(bundle);
                            g = cZv().icy.g(104, bundle);
                            f.hc(bundle.getString(SearchIntents.EXTRA_QUERY), cZv().dae());
                            if (g != null) {
                                valueOf = Boolean.valueOf(g.getBoolean("open_result"));
                                AppMethodBeat.o(7381);
                                return valueOf;
                            }
                        } catch (RemoteException e8) {
                            ab.e("MicroMsg.WebViewLongClickHelper", "jumpToSos failed");
                        }
                        AppMethodBeat.o(7381);
                        return onCancelListener;
                    } else if (str.equals("supportSmartPickWord")) {
                        valueOf = Boolean.TRUE;
                        AppMethodBeat.o(7381);
                        return valueOf;
                    } else if (str.equals("onShowSos")) {
                        f.p(cZv().dae(), bundle);
                        AppMethodBeat.o(7381);
                        return onCancelListener;
                    } else if (str.equals("supportImagePreview")) {
                        valueOf = Boolean.TRUE;
                        AppMethodBeat.o(7381);
                        return valueOf;
                    } else if (str.equals("onClickCopyBtn")) {
                        f.aeU(cZv().dae());
                        AppMethodBeat.o(7381);
                        return onCancelListener;
                    } else if (str.equals("imagePreview")) {
                        j.a(bundle, cZv().umI, cZv().uvf);
                        valueOf = Boolean.TRUE;
                        AppMethodBeat.o(7381);
                        return valueOf;
                    } else if (str.equals("closeImagePreview")) {
                        j.d(cZv().icy);
                        valueOf = Boolean.TRUE;
                        AppMethodBeat.o(7381);
                        return valueOf;
                    } else if (str.equals("onTranslateFinish")) {
                        bVar = cZv().uwL;
                        if (bVar.tipDialog != null && bVar.tipDialog.isShowing()) {
                            bVar.tipDialog.dismiss();
                            bVar.tipDialog = onCancelListener;
                        }
                        AppMethodBeat.o(7381);
                        return onCancelListener;
                    } else if (str.equals("onTranslateStart")) {
                        bVar = cZv().uwL;
                        Context cZv = cZv();
                        if (bVar.tipDialog != null && bVar.tipDialog.isShowing()) {
                            bVar.tipDialog.dismiss();
                            bVar.tipDialog = onCancelListener;
                        }
                        cZv.getString(R.string.tz);
                        bVar.tipDialog = h.b(cZv, cZv.getString(R.string.fzb), true, onCancelListener);
                        AppMethodBeat.o(7381);
                        return onCancelListener;
                    } else {
                        AppMethodBeat.o(7381);
                        return onCancelListener;
                    }
                }
                ab.e("MicroMsg.WebViewLongClickHelper", "config closed, not allows tbs download");
                AppMethodBeat.o(7381);
                return onCancelListener;
            }
        }
        AppMethodBeat.o(7381);
        return onCancelListener;
    }

    public boolean onTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(7382);
        boolean A = cZv().uwQ.A(motionEvent);
        AppMethodBeat.o(7382);
        return A;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(7383);
        boolean C = cZv().uwQ.C(motionEvent);
        AppMethodBeat.o(7383);
        return C;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(7384);
        boolean B = cZv().uwQ.B(motionEvent);
        AppMethodBeat.o(7384);
        return B;
    }

    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
        AppMethodBeat.i(7385);
        boolean b = cZv().uwQ.b(i, i2, i3, i4, i5, i6, i7, i8, z);
        AppMethodBeat.o(7385);
        return b;
    }

    public void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        AppMethodBeat.i(7386);
        cZv().uwQ.onScrollChanged(i, i2, i3, i4, view);
        AppMethodBeat.o(7386);
    }

    public void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
        AppMethodBeat.i(7387);
        cZv().uwQ.d(i, i2, z, z2);
        AppMethodBeat.o(7387);
    }

    public void computeScroll(View view) {
        AppMethodBeat.i(7388);
        cZv().uwQ.aGs();
        AppMethodBeat.o(7388);
    }

    public void invalidate() {
    }

    private WebViewUI cZv() {
        AppMethodBeat.i(7390);
        WebViewUI webViewUI = (WebViewUI) this.uqV.get();
        AppMethodBeat.o(7390);
        return webViewUI;
    }

    public boolean onShowLongClickPopupMenu() {
        AppMethodBeat.i(7389);
        if (cZv().getIntent().getBooleanExtra("show_long_click_popup_menu", true)) {
            AppMethodBeat.o(7389);
            return false;
        }
        AppMethodBeat.o(7389);
        return true;
    }
}
