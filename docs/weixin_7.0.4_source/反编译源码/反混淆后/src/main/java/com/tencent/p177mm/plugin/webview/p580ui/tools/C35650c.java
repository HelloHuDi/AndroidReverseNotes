package com.tencent.p177mm.plugin.webview.p580ui.tools;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p210ca.C18121b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.p177mm.plugin.webview.C14447b;
import com.tencent.p177mm.plugin.webview.modeltools.C14539f;
import com.tencent.p177mm.plugin.webview.modeltools.C46431j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.xweb.p685x5.p1116a.p1117a.p1118a.p1119a.C16404b;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.c */
public class C35650c extends C16404b {
    private final WeakReference<WebViewUI> uqV;

    public C35650c(WebViewUI webViewUI) {
        AppMethodBeat.m2504i(7380);
        this.uqV = new WeakReference(webViewUI);
        AppMethodBeat.m2505o(7380);
    }

    public Object onMiscCallBack(String str, Bundle bundle) {
        boolean z;
        OnCancelListener onCancelListener = null;
        AppMethodBeat.m2504i(7381);
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
        C4990ab.m7417i(str2, str3, objArr);
        if (!(C5046bo.isNullOrNil(str) || bundle == null)) {
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
                    C4990ab.m7412e("MicroMsg.WebViewLongClickHelper", "get dynamic config failed");
                    Object afk2 = onCancelListener;
                }
                C4990ab.m7417i("MicroMsg.WebViewLongClickHelper", "enable value = %s", afk2);
                if (C5046bo.isNullOrNil(afk2) || !afk2.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    Bundle g;
                    Object valueOf;
                    if (str.equals(JsApiAddDownloadTask.NAME)) {
                        try {
                            g = cZv().icy.mo15575g(14, bundle);
                            if (g != null) {
                                valueOf = Long.valueOf(g.getLong("download_id", 0));
                                AppMethodBeat.m2505o(7381);
                                return valueOf;
                            }
                        } catch (RemoteException e2) {
                            C4990ab.m7412e("MicroMsg.WebViewLongClickHelper", "invoke the add downloadtask failed");
                        }
                    }
                    if (str.equals(JsApiCancelDownloadTask.NAME)) {
                        try {
                            g = cZv().icy.mo15575g(16, bundle);
                            if (g != null) {
                                valueOf = Boolean.valueOf(g.getBoolean("cancel_result", false));
                                AppMethodBeat.m2505o(7381);
                                return valueOf;
                            }
                        } catch (RemoteException e3) {
                            C4990ab.m7412e("MicroMsg.WebViewLongClickHelper", "invoke the cancel downloadtask failed");
                        }
                    }
                    if (str.equals(JsApiQueryDownloadTask.NAME)) {
                        try {
                            g = cZv().icy.mo15575g(15, bundle);
                            if (g != null) {
                                valueOf = Integer.valueOf(g.getInt("download_state", 0));
                                AppMethodBeat.m2505o(7381);
                                return valueOf;
                            }
                        } catch (RemoteException e4) {
                            C4990ab.m7412e("MicroMsg.WebViewLongClickHelper", "invoke the queryDownloadTask downloadtask failed");
                        }
                    }
                    if (str.equals(JsApiInstallDownloadTask.NAME)) {
                        try {
                            g = cZv().icy.mo15575g(17, bundle);
                            if (g != null) {
                                valueOf = Boolean.valueOf(g.getBoolean("install_result"));
                                AppMethodBeat.m2505o(7381);
                                return valueOf;
                            }
                        } catch (RemoteException e5) {
                            C4990ab.m7412e("MicroMsg.WebViewLongClickHelper", "invoke the install downloadtask failed");
                        }
                    }
                    if (str.equals("getDrawable")) {
                        str2 = bundle.getString(DownloadInfoColumns.PACKAGENAME);
                        i = bundle.getInt("resourceId");
                        if (!C5046bo.isNullOrNil(str2) && i > 0) {
                            try {
                                valueOf = C18121b.m28551e(C4996ah.getContext().getPackageManager().getResourcesForApplication(str2), i);
                                AppMethodBeat.m2505o(7381);
                                return valueOf;
                            } catch (Exception e6) {
                                C4990ab.m7413e("MicroMsg.WebViewLongClickHelper", "get resource for package : %s, fail, : %s", str2, e6.getMessage());
                            }
                        }
                    }
                    if (str.equals("getShareUrl")) {
                        try {
                            C4990ab.m7417i("MicroMsg.WebViewLongClickHelper", "getShareUrl by x5 core, shareurl = %s", cZv().icy.aek(cZv().pzf.getUrl()));
                            AppMethodBeat.m2505o(7381);
                            return afk2;
                        } catch (Exception e7) {
                            C4990ab.m7412e("MicroMsg.WebViewLongClickHelper", "getShare url failed");
                        }
                    }
                    C14447b c14447b;
                    if (str.equals("smartPickWord")) {
                        valueOf = C14539f.m22741a(bundle, cZv().dae(), cZv().mController.getMMTitle() != null ? cZv().mController.getMMTitle().toString() : "");
                        AppMethodBeat.m2505o(7381);
                        return valueOf;
                    } else if (str.equals("jumpToSos")) {
                        try {
                            C14539f.m22739U(bundle);
                            g = cZv().icy.mo15575g(104, bundle);
                            C14539f.m22743hc(bundle.getString(SearchIntents.EXTRA_QUERY), cZv().dae());
                            if (g != null) {
                                valueOf = Boolean.valueOf(g.getBoolean("open_result"));
                                AppMethodBeat.m2505o(7381);
                                return valueOf;
                            }
                        } catch (RemoteException e8) {
                            C4990ab.m7412e("MicroMsg.WebViewLongClickHelper", "jumpToSos failed");
                        }
                        AppMethodBeat.m2505o(7381);
                        return onCancelListener;
                    } else if (str.equals("supportSmartPickWord")) {
                        valueOf = Boolean.TRUE;
                        AppMethodBeat.m2505o(7381);
                        return valueOf;
                    } else if (str.equals("onShowSos")) {
                        C14539f.m22744p(cZv().dae(), bundle);
                        AppMethodBeat.m2505o(7381);
                        return onCancelListener;
                    } else if (str.equals("supportImagePreview")) {
                        valueOf = Boolean.TRUE;
                        AppMethodBeat.m2505o(7381);
                        return valueOf;
                    } else if (str.equals("onClickCopyBtn")) {
                        C14539f.aeU(cZv().dae());
                        AppMethodBeat.m2505o(7381);
                        return onCancelListener;
                    } else if (str.equals("imagePreview")) {
                        C46431j.m87454a(bundle, cZv().umI, cZv().uvf);
                        valueOf = Boolean.TRUE;
                        AppMethodBeat.m2505o(7381);
                        return valueOf;
                    } else if (str.equals("closeImagePreview")) {
                        C46431j.m87455d(cZv().icy);
                        valueOf = Boolean.TRUE;
                        AppMethodBeat.m2505o(7381);
                        return valueOf;
                    } else if (str.equals("onTranslateFinish")) {
                        c14447b = cZv().uwL;
                        if (c14447b.tipDialog != null && c14447b.tipDialog.isShowing()) {
                            c14447b.tipDialog.dismiss();
                            c14447b.tipDialog = onCancelListener;
                        }
                        AppMethodBeat.m2505o(7381);
                        return onCancelListener;
                    } else if (str.equals("onTranslateStart")) {
                        c14447b = cZv().uwL;
                        Context cZv = cZv();
                        if (c14447b.tipDialog != null && c14447b.tipDialog.isShowing()) {
                            c14447b.tipDialog.dismiss();
                            c14447b.tipDialog = onCancelListener;
                        }
                        cZv.getString(C25738R.string.f9238tz);
                        c14447b.tipDialog = C30379h.m48458b(cZv, cZv.getString(C25738R.string.fzb), true, onCancelListener);
                        AppMethodBeat.m2505o(7381);
                        return onCancelListener;
                    } else {
                        AppMethodBeat.m2505o(7381);
                        return onCancelListener;
                    }
                }
                C4990ab.m7412e("MicroMsg.WebViewLongClickHelper", "config closed, not allows tbs download");
                AppMethodBeat.m2505o(7381);
                return onCancelListener;
            }
        }
        AppMethodBeat.m2505o(7381);
        return onCancelListener;
    }

    public boolean onTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.m2504i(7382);
        boolean A = cZv().uwQ.mo31055A(motionEvent);
        AppMethodBeat.m2505o(7382);
        return A;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.m2504i(7383);
        boolean C = cZv().uwQ.mo31057C(motionEvent);
        AppMethodBeat.m2505o(7383);
        return C;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.m2504i(7384);
        boolean B = cZv().uwQ.mo31056B(motionEvent);
        AppMethodBeat.m2505o(7384);
        return B;
    }

    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
        AppMethodBeat.m2504i(7385);
        boolean b = cZv().uwQ.mo31059b(i, i2, i3, i4, i5, i6, i7, i8, z);
        AppMethodBeat.m2505o(7385);
        return b;
    }

    public void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        AppMethodBeat.m2504i(7386);
        cZv().uwQ.onScrollChanged(i, i2, i3, i4, view);
        AppMethodBeat.m2505o(7386);
    }

    public void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
        AppMethodBeat.m2504i(7387);
        cZv().uwQ.mo31060d(i, i2, z, z2);
        AppMethodBeat.m2505o(7387);
    }

    public void computeScroll(View view) {
        AppMethodBeat.m2504i(7388);
        cZv().uwQ.aGs();
        AppMethodBeat.m2505o(7388);
    }

    public void invalidate() {
    }

    private WebViewUI cZv() {
        AppMethodBeat.m2504i(7390);
        WebViewUI webViewUI = (WebViewUI) this.uqV.get();
        AppMethodBeat.m2505o(7390);
        return webViewUI;
    }

    public boolean onShowLongClickPopupMenu() {
        AppMethodBeat.m2504i(7389);
        if (cZv().getIntent().getBooleanExtra("show_long_click_popup_menu", true)) {
            AppMethodBeat.m2505o(7389);
            return false;
        }
        AppMethodBeat.m2505o(7389);
        return true;
    }
}
