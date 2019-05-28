package com.tencent.mm.plugin.appbrand.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.appbrand.aa;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.ui.ae;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public final class AppBrandNearbyWebViewUI extends WebViewUI {
    private static Boolean evG = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(17067);
        if (getIntent() != null) {
            getIntent().putExtra("forceHideShare", true);
            getIntent().putExtra("disable_bounce_scroll", true);
            getIntent().putExtra("show_long_click_popup_menu", false);
            getIntent().putExtra("key_load_js_without_delay", true);
            getIntent().putExtra("geta8key_scene", 41);
        }
        super.onCreate(bundle);
        setResult(-1);
        AppMethodBeat.o(17067);
    }

    public final void setMMTitle(String str) {
        AppMethodBeat.i(17068);
        super.setMMTitle(str);
        ta(WebView.NIGHT_MODE_COLOR);
        AppMethodBeat.o(17068);
    }

    public final void initView() {
        AppMethodBeat.i(17069);
        super.initView();
        AppMethodBeat.o(17069);
    }

    public final void aMh() {
        AppMethodBeat.i(17070);
        super.aMh();
        xE(-855310);
        AppMethodBeat.o(17070);
    }

    public final int aMi() {
        AppMethodBeat.i(17071);
        int i;
        if (VERSION.SDK_INT >= 23 && (!h.Ms() || !Mt())) {
            ae.f(getWindow());
            AppMethodBeat.o(17071);
            return -855310;
        } else if (VERSION.SDK_INT >= 21) {
            i = aa.gQs;
            AppMethodBeat.o(17071);
            return i;
        } else {
            i = super.aMi();
            AppMethodBeat.o(17071);
            return i;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f A:{SYNTHETIC, Splitter:B:16:0x004f} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005a A:{SYNTHETIC, Splitter:B:22:0x005a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean Mt() {
        boolean booleanValue;
        Throwable th;
        FileInputStream fileInputStream;
        AppMethodBeat.i(17072);
        if (evG == null) {
            FileInputStream fileInputStream2;
            try {
                fileInputStream2 = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                try {
                    Properties properties = new Properties();
                    properties.load(fileInputStream2);
                    evG = Boolean.valueOf(properties.getProperty("ro.miui.ui.version.name", "").contains("V8"));
                    try {
                        fileInputStream2.close();
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    try {
                        evG = Boolean.FALSE;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e3) {
                            }
                        }
                        booleanValue = evG.booleanValue();
                        AppMethodBeat.o(17072);
                        return booleanValue;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        AppMethodBeat.o(17072);
                        throw th;
                    }
                }
            } catch (Exception e5) {
                fileInputStream2 = null;
                evG = Boolean.FALSE;
                if (fileInputStream2 != null) {
                }
                booleanValue = evG.booleanValue();
                AppMethodBeat.o(17072);
                return booleanValue;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                }
                AppMethodBeat.o(17072);
                throw th;
            }
        }
        booleanValue = evG.booleanValue();
        AppMethodBeat.o(17072);
        return booleanValue;
    }

    public final boolean aMj() {
        return true;
    }
}
