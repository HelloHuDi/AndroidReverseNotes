package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings;
import com.tencent.smtt.utils.C30951r;

public class WebSettings {
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;
    /* renamed from: a */
    private IX5WebSettings f3015a;
    /* renamed from: b */
    private android.webkit.WebSettings f3016b;
    /* renamed from: c */
    private boolean f3017c;

    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW;

        static {
            AppMethodBeat.m2505o(64717);
        }
    }

    public enum TextSize {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGER(125),
        LARGEST(150);
        
        int value;

        static {
            AppMethodBeat.m2505o(64720);
        }

        private TextSize(int i) {
            this.value = i;
        }
    }

    public enum PluginState {
        ON,
        ON_DEMAND,
        OFF;

        static {
            AppMethodBeat.m2505o(64714);
        }
    }

    public enum ZoomDensity {
        FAR(150),
        MEDIUM(100),
        CLOSE(75);
        
        int value;

        static {
            AppMethodBeat.m2505o(64723);
        }

        private ZoomDensity(int i) {
            this.value = i;
        }
    }

    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS;

        static {
            AppMethodBeat.m2505o(64711);
        }
    }

    WebSettings(android.webkit.WebSettings webSettings) {
        this.f3015a = null;
        this.f3016b = null;
        this.f3017c = false;
        this.f3015a = null;
        this.f3016b = webSettings;
        this.f3017c = false;
    }

    WebSettings(IX5WebSettings iX5WebSettings) {
        this.f3015a = null;
        this.f3016b = null;
        this.f3017c = false;
        this.f3015a = iX5WebSettings;
        this.f3016b = null;
        this.f3017c = true;
    }

    @TargetApi(17)
    public static String getDefaultUserAgent(Context context) {
        AppMethodBeat.m2504i(64816);
        String i;
        if (C40978bv.m71073a().mo64921b()) {
            i = C40978bv.m71073a().mo64922c().mo57599i(context);
            AppMethodBeat.m2505o(64816);
            return i;
        } else if (VERSION.SDK_INT < 17) {
            AppMethodBeat.m2505o(64816);
            return null;
        } else {
            Object a = C30951r.m49576a(android.webkit.WebSettings.class, "getDefaultUserAgent", new Class[]{Context.class}, context);
            if (a == null) {
                AppMethodBeat.m2505o(64816);
                return null;
            }
            i = (String) a;
            AppMethodBeat.m2505o(64816);
            return i;
        }
    }

    @Deprecated
    public boolean enableSmoothTransition() {
        AppMethodBeat.m2504i(64741);
        boolean enableSmoothTransition;
        if (this.f3017c && this.f3015a != null) {
            enableSmoothTransition = this.f3015a.enableSmoothTransition();
            AppMethodBeat.m2505o(64741);
            return enableSmoothTransition;
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64741);
            return false;
        } else if (VERSION.SDK_INT >= 11) {
            Object a = C30951r.m49577a(this.f3016b, "enableSmoothTransition");
            if (a == null) {
                AppMethodBeat.m2505o(64741);
                return false;
            }
            enableSmoothTransition = ((Boolean) a).booleanValue();
            AppMethodBeat.m2505o(64741);
            return enableSmoothTransition;
        } else {
            AppMethodBeat.m2505o(64741);
            return false;
        }
    }

    @TargetApi(11)
    public boolean getAllowContentAccess() {
        AppMethodBeat.m2504i(64737);
        boolean allowContentAccess;
        if (this.f3017c && this.f3015a != null) {
            allowContentAccess = this.f3015a.getAllowContentAccess();
            AppMethodBeat.m2505o(64737);
            return allowContentAccess;
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64737);
            return false;
        } else if (VERSION.SDK_INT >= 11) {
            Object a = C30951r.m49577a(this.f3016b, "getAllowContentAccess");
            if (a == null) {
                AppMethodBeat.m2505o(64737);
                return false;
            }
            allowContentAccess = ((Boolean) a).booleanValue();
            AppMethodBeat.m2505o(64737);
            return allowContentAccess;
        } else {
            AppMethodBeat.m2505o(64737);
            return false;
        }
    }

    @TargetApi(3)
    public boolean getAllowFileAccess() {
        AppMethodBeat.m2504i(64734);
        boolean allowFileAccess;
        if (this.f3017c && this.f3015a != null) {
            allowFileAccess = this.f3015a.getAllowFileAccess();
            AppMethodBeat.m2505o(64734);
            return allowFileAccess;
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64734);
            return false;
        } else {
            allowFileAccess = this.f3016b.getAllowFileAccess();
            AppMethodBeat.m2505o(64734);
            return allowFileAccess;
        }
    }

    public synchronized boolean getBlockNetworkImage() {
        boolean blockNetworkImage;
        AppMethodBeat.m2504i(64788);
        if (this.f3017c && this.f3015a != null) {
            blockNetworkImage = this.f3015a.getBlockNetworkImage();
            AppMethodBeat.m2505o(64788);
        } else if (this.f3017c || this.f3016b == null) {
            blockNetworkImage = false;
            AppMethodBeat.m2505o(64788);
        } else {
            blockNetworkImage = this.f3016b.getBlockNetworkImage();
            AppMethodBeat.m2505o(64788);
        }
        return blockNetworkImage;
    }

    @TargetApi(8)
    public synchronized boolean getBlockNetworkLoads() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(64790);
            if (this.f3017c && this.f3015a != null) {
                z = this.f3015a.getBlockNetworkLoads();
                AppMethodBeat.m2505o(64790);
            } else if (this.f3017c || this.f3016b == null) {
                AppMethodBeat.m2505o(64790);
            } else if (VERSION.SDK_INT >= 8) {
                z = this.f3016b.getBlockNetworkLoads();
                AppMethodBeat.m2505o(64790);
            } else {
                AppMethodBeat.m2505o(64790);
            }
        }
        return z;
    }

    @TargetApi(3)
    public boolean getBuiltInZoomControls() {
        AppMethodBeat.m2504i(64730);
        boolean builtInZoomControls;
        if (this.f3017c && this.f3015a != null) {
            builtInZoomControls = this.f3015a.getBuiltInZoomControls();
            AppMethodBeat.m2505o(64730);
            return builtInZoomControls;
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64730);
            return false;
        } else {
            builtInZoomControls = this.f3016b.getBuiltInZoomControls();
            AppMethodBeat.m2505o(64730);
            return builtInZoomControls;
        }
    }

    public int getCacheMode() {
        AppMethodBeat.m2504i(64822);
        int cacheMode;
        if (this.f3017c && this.f3015a != null) {
            cacheMode = this.f3015a.getCacheMode();
            AppMethodBeat.m2505o(64822);
            return cacheMode;
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64822);
            return 0;
        } else {
            cacheMode = this.f3016b.getCacheMode();
            AppMethodBeat.m2505o(64822);
            return cacheMode;
        }
    }

    public synchronized String getCursiveFontFamily() {
        String cursiveFontFamily;
        AppMethodBeat.m2504i(64774);
        if (this.f3017c && this.f3015a != null) {
            cursiveFontFamily = this.f3015a.getCursiveFontFamily();
            AppMethodBeat.m2505o(64774);
        } else if (this.f3017c || this.f3016b == null) {
            cursiveFontFamily = "";
            AppMethodBeat.m2505o(64774);
        } else {
            cursiveFontFamily = this.f3016b.getCursiveFontFamily();
            AppMethodBeat.m2505o(64774);
        }
        return cursiveFontFamily;
    }

    @TargetApi(5)
    public synchronized boolean getDatabaseEnabled() {
        boolean databaseEnabled;
        AppMethodBeat.m2504i(64806);
        if (this.f3017c && this.f3015a != null) {
            databaseEnabled = this.f3015a.getDatabaseEnabled();
            AppMethodBeat.m2505o(64806);
        } else if (this.f3017c || this.f3016b == null) {
            databaseEnabled = false;
            AppMethodBeat.m2505o(64806);
        } else {
            databaseEnabled = this.f3016b.getDatabaseEnabled();
            AppMethodBeat.m2505o(64806);
        }
        return databaseEnabled;
    }

    @TargetApi(5)
    public synchronized String getDatabasePath() {
        String databasePath;
        AppMethodBeat.m2504i(64805);
        if (this.f3017c && this.f3015a != null) {
            databasePath = this.f3015a.getDatabasePath();
            AppMethodBeat.m2505o(64805);
        } else if (this.f3017c || this.f3016b == null) {
            databasePath = "";
            AppMethodBeat.m2505o(64805);
        } else {
            databasePath = this.f3016b.getDatabasePath();
            AppMethodBeat.m2505o(64805);
        }
        return databasePath;
    }

    public synchronized int getDefaultFixedFontSize() {
        int defaultFixedFontSize;
        AppMethodBeat.m2504i(64784);
        if (this.f3017c && this.f3015a != null) {
            defaultFixedFontSize = this.f3015a.getDefaultFixedFontSize();
            AppMethodBeat.m2505o(64784);
        } else if (this.f3017c || this.f3016b == null) {
            defaultFixedFontSize = 0;
            AppMethodBeat.m2505o(64784);
        } else {
            defaultFixedFontSize = this.f3016b.getDefaultFixedFontSize();
            AppMethodBeat.m2505o(64784);
        }
        return defaultFixedFontSize;
    }

    public synchronized int getDefaultFontSize() {
        int defaultFontSize;
        AppMethodBeat.m2504i(64782);
        if (this.f3017c && this.f3015a != null) {
            defaultFontSize = this.f3015a.getDefaultFontSize();
            AppMethodBeat.m2505o(64782);
        } else if (this.f3017c || this.f3016b == null) {
            defaultFontSize = 0;
            AppMethodBeat.m2505o(64782);
        } else {
            defaultFontSize = this.f3016b.getDefaultFontSize();
            AppMethodBeat.m2505o(64782);
        }
        return defaultFontSize;
    }

    public synchronized String getDefaultTextEncodingName() {
        String defaultTextEncodingName;
        AppMethodBeat.m2504i(64815);
        if (this.f3017c && this.f3015a != null) {
            defaultTextEncodingName = this.f3015a.getDefaultTextEncodingName();
            AppMethodBeat.m2505o(64815);
        } else if (this.f3017c || this.f3016b == null) {
            defaultTextEncodingName = "";
            AppMethodBeat.m2505o(64815);
        } else {
            defaultTextEncodingName = this.f3016b.getDefaultTextEncodingName();
            AppMethodBeat.m2505o(64815);
        }
        return defaultTextEncodingName;
    }

    @TargetApi(7)
    public ZoomDensity getDefaultZoom() {
        AppMethodBeat.m2504i(64753);
        ZoomDensity valueOf;
        if (this.f3017c && this.f3015a != null) {
            valueOf = ZoomDensity.valueOf(this.f3015a.getDefaultZoom().name());
            AppMethodBeat.m2505o(64753);
            return valueOf;
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64753);
            return null;
        } else {
            valueOf = ZoomDensity.valueOf(this.f3016b.getDefaultZoom().name());
            AppMethodBeat.m2505o(64753);
            return valueOf;
        }
    }

    @TargetApi(11)
    public boolean getDisplayZoomControls() {
        AppMethodBeat.m2504i(64732);
        boolean displayZoomControls;
        if (this.f3017c && this.f3015a != null) {
            displayZoomControls = this.f3015a.getDisplayZoomControls();
            AppMethodBeat.m2505o(64732);
            return displayZoomControls;
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64732);
            return false;
        } else if (VERSION.SDK_INT >= 11) {
            Object a = C30951r.m49577a(this.f3016b, "getDisplayZoomControls");
            if (a == null) {
                AppMethodBeat.m2505o(64732);
                return false;
            }
            displayZoomControls = ((Boolean) a).booleanValue();
            AppMethodBeat.m2505o(64732);
            return displayZoomControls;
        } else {
            AppMethodBeat.m2505o(64732);
            return false;
        }
    }

    @TargetApi(7)
    public synchronized boolean getDomStorageEnabled() {
        boolean domStorageEnabled;
        AppMethodBeat.m2504i(64804);
        if (this.f3017c && this.f3015a != null) {
            domStorageEnabled = this.f3015a.getDomStorageEnabled();
            AppMethodBeat.m2505o(64804);
        } else if (this.f3017c || this.f3016b == null) {
            domStorageEnabled = false;
            AppMethodBeat.m2505o(64804);
        } else {
            domStorageEnabled = this.f3016b.getDomStorageEnabled();
            AppMethodBeat.m2505o(64804);
        }
        return domStorageEnabled;
    }

    public synchronized String getFantasyFontFamily() {
        String fantasyFontFamily;
        AppMethodBeat.m2504i(64776);
        if (this.f3017c && this.f3015a != null) {
            fantasyFontFamily = this.f3015a.getFantasyFontFamily();
            AppMethodBeat.m2505o(64776);
        } else if (this.f3017c || this.f3016b == null) {
            fantasyFontFamily = "";
            AppMethodBeat.m2505o(64776);
        } else {
            fantasyFontFamily = this.f3016b.getFantasyFontFamily();
            AppMethodBeat.m2505o(64776);
        }
        return fantasyFontFamily;
    }

    public synchronized String getFixedFontFamily() {
        String fixedFontFamily;
        AppMethodBeat.m2504i(64768);
        if (this.f3017c && this.f3015a != null) {
            fixedFontFamily = this.f3015a.getFixedFontFamily();
            AppMethodBeat.m2505o(64768);
        } else if (this.f3017c || this.f3016b == null) {
            fixedFontFamily = "";
            AppMethodBeat.m2505o(64768);
        } else {
            fixedFontFamily = this.f3016b.getFixedFontFamily();
            AppMethodBeat.m2505o(64768);
        }
        return fixedFontFamily;
    }

    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        boolean javaScriptCanOpenWindowsAutomatically;
        AppMethodBeat.m2504i(64813);
        if (this.f3017c && this.f3015a != null) {
            javaScriptCanOpenWindowsAutomatically = this.f3015a.getJavaScriptCanOpenWindowsAutomatically();
            AppMethodBeat.m2505o(64813);
        } else if (this.f3017c || this.f3016b == null) {
            javaScriptCanOpenWindowsAutomatically = false;
            AppMethodBeat.m2505o(64813);
        } else {
            javaScriptCanOpenWindowsAutomatically = this.f3016b.getJavaScriptCanOpenWindowsAutomatically();
            AppMethodBeat.m2505o(64813);
        }
        return javaScriptCanOpenWindowsAutomatically;
    }

    public synchronized boolean getJavaScriptEnabled() {
        boolean javaScriptEnabled;
        AppMethodBeat.m2504i(64808);
        if (this.f3017c && this.f3015a != null) {
            javaScriptEnabled = this.f3015a.getJavaScriptEnabled();
            AppMethodBeat.m2505o(64808);
        } else if (this.f3017c || this.f3016b == null) {
            javaScriptEnabled = false;
            AppMethodBeat.m2505o(64808);
        } else {
            javaScriptEnabled = this.f3016b.getJavaScriptEnabled();
            AppMethodBeat.m2505o(64808);
        }
        return javaScriptEnabled;
    }

    public synchronized LayoutAlgorithm getLayoutAlgorithm() {
        LayoutAlgorithm valueOf;
        AppMethodBeat.m2504i(64764);
        if (this.f3017c && this.f3015a != null) {
            valueOf = LayoutAlgorithm.valueOf(this.f3015a.getLayoutAlgorithm().name());
            AppMethodBeat.m2505o(64764);
        } else if (this.f3017c || this.f3016b == null) {
            valueOf = null;
            AppMethodBeat.m2505o(64764);
        } else {
            valueOf = LayoutAlgorithm.valueOf(this.f3016b.getLayoutAlgorithm().name());
            AppMethodBeat.m2505o(64764);
        }
        return valueOf;
    }

    public boolean getLightTouchEnabled() {
        AppMethodBeat.m2504i(64755);
        boolean lightTouchEnabled;
        if (this.f3017c && this.f3015a != null) {
            lightTouchEnabled = this.f3015a.getLightTouchEnabled();
            AppMethodBeat.m2505o(64755);
            return lightTouchEnabled;
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64755);
            return false;
        } else {
            lightTouchEnabled = this.f3016b.getLightTouchEnabled();
            AppMethodBeat.m2505o(64755);
            return lightTouchEnabled;
        }
    }

    @TargetApi(7)
    public boolean getLoadWithOverviewMode() {
        AppMethodBeat.m2504i(64739);
        boolean loadWithOverviewMode;
        if (this.f3017c && this.f3015a != null) {
            loadWithOverviewMode = this.f3015a.getLoadWithOverviewMode();
            AppMethodBeat.m2505o(64739);
            return loadWithOverviewMode;
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64739);
            return false;
        } else {
            loadWithOverviewMode = this.f3016b.getLoadWithOverviewMode();
            AppMethodBeat.m2505o(64739);
            return loadWithOverviewMode;
        }
    }

    public synchronized boolean getLoadsImagesAutomatically() {
        boolean loadsImagesAutomatically;
        AppMethodBeat.m2504i(64786);
        if (this.f3017c && this.f3015a != null) {
            loadsImagesAutomatically = this.f3015a.getLoadsImagesAutomatically();
            AppMethodBeat.m2505o(64786);
        } else if (this.f3017c || this.f3016b == null) {
            loadsImagesAutomatically = false;
            AppMethodBeat.m2505o(64786);
        } else {
            loadsImagesAutomatically = this.f3016b.getLoadsImagesAutomatically();
            AppMethodBeat.m2505o(64786);
        }
        return loadsImagesAutomatically;
    }

    @TargetApi(17)
    public boolean getMediaPlaybackRequiresUserGesture() {
        AppMethodBeat.m2504i(64817);
        boolean mediaPlaybackRequiresUserGesture;
        if (this.f3017c && this.f3015a != null) {
            mediaPlaybackRequiresUserGesture = this.f3015a.getMediaPlaybackRequiresUserGesture();
            AppMethodBeat.m2505o(64817);
            return mediaPlaybackRequiresUserGesture;
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64817);
            return false;
        } else if (VERSION.SDK_INT < 17) {
            AppMethodBeat.m2505o(64817);
            return false;
        } else {
            Object a = C30951r.m49577a(this.f3016b, "getMediaPlaybackRequiresUserGesture");
            if (a == null) {
                AppMethodBeat.m2505o(64817);
                return false;
            }
            mediaPlaybackRequiresUserGesture = ((Boolean) a).booleanValue();
            AppMethodBeat.m2505o(64817);
            return mediaPlaybackRequiresUserGesture;
        }
    }

    public synchronized int getMinimumFontSize() {
        int minimumFontSize;
        AppMethodBeat.m2504i(64778);
        if (this.f3017c && this.f3015a != null) {
            minimumFontSize = this.f3015a.getMinimumFontSize();
            AppMethodBeat.m2505o(64778);
        } else if (this.f3017c || this.f3016b == null) {
            minimumFontSize = 0;
            AppMethodBeat.m2505o(64778);
        } else {
            minimumFontSize = this.f3016b.getMinimumFontSize();
            AppMethodBeat.m2505o(64778);
        }
        return minimumFontSize;
    }

    public synchronized int getMinimumLogicalFontSize() {
        int minimumLogicalFontSize;
        AppMethodBeat.m2504i(64780);
        if (this.f3017c && this.f3015a != null) {
            minimumLogicalFontSize = this.f3015a.getMinimumLogicalFontSize();
            AppMethodBeat.m2505o(64780);
        } else if (this.f3017c || this.f3016b == null) {
            minimumLogicalFontSize = 0;
            AppMethodBeat.m2505o(64780);
        } else {
            minimumLogicalFontSize = this.f3016b.getMinimumLogicalFontSize();
            AppMethodBeat.m2505o(64780);
        }
        return minimumLogicalFontSize;
    }

    public synchronized int getMixedContentMode() {
        int mixedContentMode;
        AppMethodBeat.m2504i(64725);
        if (this.f3017c && this.f3015a != null) {
            try {
                mixedContentMode = this.f3015a.getMixedContentMode();
                AppMethodBeat.m2505o(64725);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(64725);
                mixedContentMode = -1;
            }
        } else if (VERSION.SDK_INT < 21) {
            AppMethodBeat.m2505o(64725);
            mixedContentMode = -1;
        } else {
            Object a = C30951r.m49578a(this.f3016b, "getMixedContentMode", new Class[0], new Object[0]);
            if (a == null) {
                AppMethodBeat.m2505o(64725);
                mixedContentMode = -1;
            } else {
                mixedContentMode = ((Integer) a).intValue();
                AppMethodBeat.m2505o(64725);
            }
        }
        return mixedContentMode;
    }

    public boolean getNavDump() {
        AppMethodBeat.m2504i(64726);
        boolean navDump;
        if (this.f3017c && this.f3015a != null) {
            navDump = this.f3015a.getNavDump();
            AppMethodBeat.m2505o(64726);
            return navDump;
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64726);
            return false;
        } else {
            Object a = C30951r.m49577a(this.f3016b, "getNavDump");
            if (a == null) {
                AppMethodBeat.m2505o(64726);
                return false;
            }
            navDump = ((Boolean) a).booleanValue();
            AppMethodBeat.m2505o(64726);
            return navDump;
        }
    }

    @TargetApi(8)
    @Deprecated
    public synchronized PluginState getPluginState() {
        PluginState valueOf;
        AppMethodBeat.m2504i(64810);
        if (this.f3017c && this.f3015a != null) {
            valueOf = PluginState.valueOf(this.f3015a.getPluginState().name());
            AppMethodBeat.m2505o(64810);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64810);
            valueOf = null;
        } else if (VERSION.SDK_INT >= 8) {
            Object a = C30951r.m49577a(this.f3016b, "getPluginState");
            if (a == null) {
                AppMethodBeat.m2505o(64810);
                valueOf = null;
            } else {
                valueOf = PluginState.valueOf(((android.webkit.WebSettings.PluginState) a).name());
                AppMethodBeat.m2505o(64810);
            }
        } else {
            AppMethodBeat.m2505o(64810);
            valueOf = null;
        }
        return valueOf;
    }

    @TargetApi(8)
    @Deprecated
    public synchronized boolean getPluginsEnabled() {
        boolean pluginsEnabled;
        AppMethodBeat.m2504i(64809);
        if (this.f3017c && this.f3015a != null) {
            pluginsEnabled = this.f3015a.getPluginsEnabled();
            AppMethodBeat.m2505o(64809);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64809);
            pluginsEnabled = false;
        } else if (VERSION.SDK_INT <= 17) {
            Object a = C30951r.m49577a(this.f3016b, "getPluginsEnabled");
            if (a == null) {
                AppMethodBeat.m2505o(64809);
                pluginsEnabled = false;
            } else {
                pluginsEnabled = ((Boolean) a).booleanValue();
                AppMethodBeat.m2505o(64809);
            }
        } else if (VERSION.SDK_INT == 18) {
            if (android.webkit.WebSettings.PluginState.ON == this.f3016b.getPluginState()) {
                pluginsEnabled = true;
                AppMethodBeat.m2505o(64809);
            } else {
                AppMethodBeat.m2505o(64809);
                pluginsEnabled = false;
            }
        } else {
            AppMethodBeat.m2505o(64809);
            pluginsEnabled = false;
        }
        return pluginsEnabled;
    }

    @Deprecated
    public synchronized String getPluginsPath() {
        String pluginsPath;
        AppMethodBeat.m2504i(64811);
        if (this.f3017c && this.f3015a != null) {
            pluginsPath = this.f3015a.getPluginsPath();
            AppMethodBeat.m2505o(64811);
        } else if (this.f3017c || this.f3016b == null) {
            pluginsPath = "";
            AppMethodBeat.m2505o(64811);
        } else if (VERSION.SDK_INT <= 17) {
            Object a = C30951r.m49577a(this.f3016b, "getPluginsPath");
            if (a == null) {
                pluginsPath = null;
                AppMethodBeat.m2505o(64811);
            } else {
                pluginsPath = (String) a;
                AppMethodBeat.m2505o(64811);
            }
        } else {
            pluginsPath = "";
            AppMethodBeat.m2505o(64811);
        }
        return pluginsPath;
    }

    public synchronized String getSansSerifFontFamily() {
        String sansSerifFontFamily;
        AppMethodBeat.m2504i(64770);
        if (this.f3017c && this.f3015a != null) {
            sansSerifFontFamily = this.f3015a.getSansSerifFontFamily();
            AppMethodBeat.m2505o(64770);
        } else if (this.f3017c || this.f3016b == null) {
            sansSerifFontFamily = "";
            AppMethodBeat.m2505o(64770);
        } else {
            sansSerifFontFamily = this.f3016b.getSansSerifFontFamily();
            AppMethodBeat.m2505o(64770);
        }
        return sansSerifFontFamily;
    }

    public boolean getSaveFormData() {
        AppMethodBeat.m2504i(64745);
        boolean saveFormData;
        if (this.f3017c && this.f3015a != null) {
            saveFormData = this.f3015a.getSaveFormData();
            AppMethodBeat.m2505o(64745);
            return saveFormData;
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64745);
            return false;
        } else {
            saveFormData = this.f3016b.getSaveFormData();
            AppMethodBeat.m2505o(64745);
            return saveFormData;
        }
    }

    public boolean getSavePassword() {
        AppMethodBeat.m2504i(64747);
        boolean savePassword;
        if (this.f3017c && this.f3015a != null) {
            savePassword = this.f3015a.getSavePassword();
            AppMethodBeat.m2505o(64747);
            return savePassword;
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64747);
            return false;
        } else {
            savePassword = this.f3016b.getSavePassword();
            AppMethodBeat.m2505o(64747);
            return savePassword;
        }
    }

    public synchronized String getSerifFontFamily() {
        String serifFontFamily;
        AppMethodBeat.m2504i(64772);
        if (this.f3017c && this.f3015a != null) {
            serifFontFamily = this.f3015a.getSerifFontFamily();
            AppMethodBeat.m2505o(64772);
        } else if (this.f3017c || this.f3016b == null) {
            serifFontFamily = "";
            AppMethodBeat.m2505o(64772);
        } else {
            serifFontFamily = this.f3016b.getSerifFontFamily();
            AppMethodBeat.m2505o(64772);
        }
        return serifFontFamily;
    }

    public synchronized String getStandardFontFamily() {
        String standardFontFamily;
        AppMethodBeat.m2504i(64766);
        if (this.f3017c && this.f3015a != null) {
            standardFontFamily = this.f3015a.getStandardFontFamily();
            AppMethodBeat.m2505o(64766);
        } else if (this.f3017c || this.f3016b == null) {
            standardFontFamily = "";
            AppMethodBeat.m2505o(64766);
        } else {
            standardFontFamily = this.f3016b.getStandardFontFamily();
            AppMethodBeat.m2505o(64766);
        }
        return standardFontFamily;
    }

    public TextSize getTextSize() {
        AppMethodBeat.m2504i(64751);
        TextSize valueOf;
        if (this.f3017c && this.f3015a != null) {
            valueOf = TextSize.valueOf(this.f3015a.getTextSize().name());
            AppMethodBeat.m2505o(64751);
            return valueOf;
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64751);
            return null;
        } else {
            valueOf = TextSize.valueOf(this.f3016b.getTextSize().name());
            AppMethodBeat.m2505o(64751);
            return valueOf;
        }
    }

    @TargetApi(14)
    public synchronized int getTextZoom() {
        int textZoom;
        AppMethodBeat.m2504i(64749);
        if (this.f3017c && this.f3015a != null) {
            textZoom = this.f3015a.getTextZoom();
            AppMethodBeat.m2505o(64749);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64749);
            textZoom = 0;
        } else if (VERSION.SDK_INT < 14) {
            AppMethodBeat.m2505o(64749);
            textZoom = 0;
        } else {
            try {
                textZoom = this.f3016b.getTextZoom();
                AppMethodBeat.m2505o(64749);
            } catch (Exception e) {
                Object a = C30951r.m49577a(this.f3016b, "getTextZoom");
                if (a == null) {
                    AppMethodBeat.m2505o(64749);
                    textZoom = 0;
                } else {
                    textZoom = ((Integer) a).intValue();
                    AppMethodBeat.m2505o(64749);
                }
            }
        }
        return textZoom;
    }

    @Deprecated
    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        AppMethodBeat.m2504i(64743);
        boolean useWebViewBackgroundForOverscrollBackground;
        if (this.f3017c && this.f3015a != null) {
            useWebViewBackgroundForOverscrollBackground = this.f3015a.getUseWebViewBackgroundForOverscrollBackground();
            AppMethodBeat.m2505o(64743);
            return useWebViewBackgroundForOverscrollBackground;
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64743);
            return false;
        } else {
            Object a = C30951r.m49577a(this.f3016b, "getUseWebViewBackgroundForOverscrollBackground");
            if (a == null) {
                AppMethodBeat.m2505o(64743);
                return false;
            }
            useWebViewBackgroundForOverscrollBackground = ((Boolean) a).booleanValue();
            AppMethodBeat.m2505o(64743);
            return useWebViewBackgroundForOverscrollBackground;
        }
    }

    public synchronized boolean getUseWideViewPort() {
        boolean useWideViewPort;
        AppMethodBeat.m2504i(64760);
        if (this.f3017c && this.f3015a != null) {
            useWideViewPort = this.f3015a.getUseWideViewPort();
            AppMethodBeat.m2505o(64760);
        } else if (this.f3017c || this.f3016b == null) {
            useWideViewPort = false;
            AppMethodBeat.m2505o(64760);
        } else {
            useWideViewPort = this.f3016b.getUseWideViewPort();
            AppMethodBeat.m2505o(64760);
        }
        return useWideViewPort;
    }

    @TargetApi(3)
    public String getUserAgentString() {
        AppMethodBeat.m2504i(64757);
        String userAgentString;
        if (this.f3017c && this.f3015a != null) {
            userAgentString = this.f3015a.getUserAgentString();
            AppMethodBeat.m2505o(64757);
            return userAgentString;
        } else if (this.f3017c || this.f3016b == null) {
            userAgentString = "";
            AppMethodBeat.m2505o(64757);
            return userAgentString;
        } else {
            userAgentString = this.f3016b.getUserAgentString();
            AppMethodBeat.m2505o(64757);
            return userAgentString;
        }
    }

    @TargetApi(11)
    public void setAllowContentAccess(boolean z) {
        AppMethodBeat.m2504i(64735);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setAllowContentAccess(z);
            AppMethodBeat.m2505o(64735);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64735);
        } else if (VERSION.SDK_INT < 11) {
            AppMethodBeat.m2505o(64735);
        } else {
            C30951r.m49578a(this.f3016b, "setAllowContentAccess", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.m2505o(64735);
        }
    }

    @TargetApi(3)
    public void setAllowFileAccess(boolean z) {
        AppMethodBeat.m2504i(64733);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setAllowFileAccess(z);
            AppMethodBeat.m2505o(64733);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64733);
        } else {
            this.f3016b.setAllowFileAccess(z);
            AppMethodBeat.m2505o(64733);
        }
    }

    @TargetApi(16)
    public void setAllowFileAccessFromFileURLs(boolean z) {
        AppMethodBeat.m2504i(64793);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setAllowFileAccessFromFileURLs(z);
            AppMethodBeat.m2505o(64793);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64793);
        } else {
            C30951r.m49578a(this.f3016b, "setAllowFileAccessFromFileURLs", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.m2505o(64793);
        }
    }

    @TargetApi(16)
    public void setAllowUniversalAccessFromFileURLs(boolean z) {
        AppMethodBeat.m2504i(64792);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setAllowUniversalAccessFromFileURLs(z);
            AppMethodBeat.m2505o(64792);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64792);
        } else {
            C30951r.m49578a(this.f3016b, "setAllowUniversalAccessFromFileURLs", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.m2505o(64792);
        }
    }

    @TargetApi(7)
    public void setAppCacheEnabled(boolean z) {
        AppMethodBeat.m2504i(64799);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setAppCacheEnabled(z);
            AppMethodBeat.m2505o(64799);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64799);
        } else {
            this.f3016b.setAppCacheEnabled(z);
            AppMethodBeat.m2505o(64799);
        }
    }

    @TargetApi(7)
    public void setAppCacheMaxSize(long j) {
        AppMethodBeat.m2504i(64801);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setAppCacheMaxSize(j);
            AppMethodBeat.m2505o(64801);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64801);
        } else {
            this.f3016b.setAppCacheMaxSize(j);
            AppMethodBeat.m2505o(64801);
        }
    }

    @TargetApi(7)
    public void setAppCachePath(String str) {
        AppMethodBeat.m2504i(64800);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setAppCachePath(str);
            AppMethodBeat.m2505o(64800);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64800);
        } else {
            this.f3016b.setAppCachePath(str);
            AppMethodBeat.m2505o(64800);
        }
    }

    public void setBlockNetworkImage(boolean z) {
        AppMethodBeat.m2504i(64787);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setBlockNetworkImage(z);
            AppMethodBeat.m2505o(64787);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64787);
        } else {
            this.f3016b.setBlockNetworkImage(z);
            AppMethodBeat.m2505o(64787);
        }
    }

    @TargetApi(8)
    public synchronized void setBlockNetworkLoads(boolean z) {
        AppMethodBeat.m2504i(64789);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setBlockNetworkLoads(z);
            AppMethodBeat.m2505o(64789);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64789);
        } else if (VERSION.SDK_INT >= 8) {
            this.f3016b.setBlockNetworkLoads(z);
            AppMethodBeat.m2505o(64789);
        } else {
            AppMethodBeat.m2505o(64789);
        }
    }

    @TargetApi(3)
    public void setBuiltInZoomControls(boolean z) {
        AppMethodBeat.m2504i(64729);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setBuiltInZoomControls(z);
            AppMethodBeat.m2505o(64729);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64729);
        } else {
            this.f3016b.setBuiltInZoomControls(z);
            AppMethodBeat.m2505o(64729);
        }
    }

    public void setCacheMode(int i) {
        AppMethodBeat.m2504i(64821);
        if (!this.f3017c || this.f3015a == null) {
            if (!(this.f3017c || this.f3016b == null)) {
                this.f3016b.setCacheMode(i);
            }
            AppMethodBeat.m2505o(64821);
            return;
        }
        this.f3015a.setCacheMode(i);
        AppMethodBeat.m2505o(64821);
    }

    public synchronized void setCursiveFontFamily(String str) {
        AppMethodBeat.m2504i(64773);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setCursiveFontFamily(str);
            AppMethodBeat.m2505o(64773);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64773);
        } else {
            this.f3016b.setCursiveFontFamily(str);
            AppMethodBeat.m2505o(64773);
        }
    }

    @TargetApi(5)
    public void setDatabaseEnabled(boolean z) {
        AppMethodBeat.m2504i(64802);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setDatabaseEnabled(z);
            AppMethodBeat.m2505o(64802);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64802);
        } else {
            this.f3016b.setDatabaseEnabled(z);
            AppMethodBeat.m2505o(64802);
        }
    }

    @TargetApi(5)
    @Deprecated
    public void setDatabasePath(String str) {
        AppMethodBeat.m2504i(64797);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setDatabasePath(str);
            AppMethodBeat.m2505o(64797);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64797);
        } else {
            C30951r.m49578a(this.f3016b, "setDatabasePath", new Class[]{String.class}, str);
            AppMethodBeat.m2505o(64797);
        }
    }

    public synchronized void setDefaultFixedFontSize(int i) {
        AppMethodBeat.m2504i(64783);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setDefaultFixedFontSize(i);
            AppMethodBeat.m2505o(64783);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64783);
        } else {
            this.f3016b.setDefaultFixedFontSize(i);
            AppMethodBeat.m2505o(64783);
        }
    }

    public synchronized void setDefaultFontSize(int i) {
        AppMethodBeat.m2504i(64781);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setDefaultFontSize(i);
            AppMethodBeat.m2505o(64781);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64781);
        } else {
            this.f3016b.setDefaultFontSize(i);
            AppMethodBeat.m2505o(64781);
        }
    }

    public synchronized void setDefaultTextEncodingName(String str) {
        AppMethodBeat.m2504i(64814);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setDefaultTextEncodingName(str);
            AppMethodBeat.m2505o(64814);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64814);
        } else {
            this.f3016b.setDefaultTextEncodingName(str);
            AppMethodBeat.m2505o(64814);
        }
    }

    @TargetApi(7)
    public void setDefaultZoom(ZoomDensity zoomDensity) {
        AppMethodBeat.m2504i(64752);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setDefaultZoom(com.tencent.smtt.export.external.interfaces.IX5WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
            AppMethodBeat.m2505o(64752);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64752);
        } else {
            this.f3016b.setDefaultZoom(android.webkit.WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
            AppMethodBeat.m2505o(64752);
        }
    }

    @TargetApi(11)
    public void setDisplayZoomControls(boolean z) {
        AppMethodBeat.m2504i(64731);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setDisplayZoomControls(z);
            AppMethodBeat.m2505o(64731);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64731);
        } else if (VERSION.SDK_INT < 11) {
            AppMethodBeat.m2505o(64731);
        } else {
            C30951r.m49578a(this.f3016b, "setDisplayZoomControls", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.m2505o(64731);
        }
    }

    @TargetApi(7)
    public void setDomStorageEnabled(boolean z) {
        AppMethodBeat.m2504i(64803);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setDomStorageEnabled(z);
            AppMethodBeat.m2505o(64803);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64803);
        } else {
            this.f3016b.setDomStorageEnabled(z);
            AppMethodBeat.m2505o(64803);
        }
    }

    @TargetApi(11)
    @Deprecated
    public void setEnableSmoothTransition(boolean z) {
        AppMethodBeat.m2504i(64740);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setEnableSmoothTransition(z);
            AppMethodBeat.m2505o(64740);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64740);
        } else if (VERSION.SDK_INT >= 11) {
            C30951r.m49578a(this.f3016b, "setEnableSmoothTransition", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.m2505o(64740);
        } else {
            AppMethodBeat.m2505o(64740);
        }
    }

    public synchronized void setFantasyFontFamily(String str) {
        AppMethodBeat.m2504i(64775);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setFantasyFontFamily(str);
            AppMethodBeat.m2505o(64775);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64775);
        } else {
            this.f3016b.setFantasyFontFamily(str);
            AppMethodBeat.m2505o(64775);
        }
    }

    public synchronized void setFixedFontFamily(String str) {
        AppMethodBeat.m2504i(64767);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setFixedFontFamily(str);
            AppMethodBeat.m2505o(64767);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64767);
        } else {
            this.f3016b.setFixedFontFamily(str);
            AppMethodBeat.m2505o(64767);
        }
    }

    @TargetApi(5)
    public void setGeolocationDatabasePath(String str) {
        AppMethodBeat.m2504i(64798);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setGeolocationDatabasePath(str);
            AppMethodBeat.m2505o(64798);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64798);
        } else {
            this.f3016b.setGeolocationDatabasePath(str);
            AppMethodBeat.m2505o(64798);
        }
    }

    @TargetApi(5)
    public void setGeolocationEnabled(boolean z) {
        AppMethodBeat.m2504i(64807);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setGeolocationEnabled(z);
            AppMethodBeat.m2505o(64807);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64807);
        } else {
            this.f3016b.setGeolocationEnabled(z);
            AppMethodBeat.m2505o(64807);
        }
    }

    public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        AppMethodBeat.m2504i(64812);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setJavaScriptCanOpenWindowsAutomatically(z);
            AppMethodBeat.m2505o(64812);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64812);
        } else {
            this.f3016b.setJavaScriptCanOpenWindowsAutomatically(z);
            AppMethodBeat.m2505o(64812);
        }
    }

    @Deprecated
    public void setJavaScriptEnabled(boolean z) {
        AppMethodBeat.m2504i(64791);
        try {
            if (this.f3017c && this.f3015a != null) {
                this.f3015a.setJavaScriptEnabled(z);
                AppMethodBeat.m2505o(64791);
            } else if (this.f3017c || this.f3016b == null) {
                AppMethodBeat.m2505o(64791);
            } else {
                this.f3016b.setJavaScriptEnabled(z);
                AppMethodBeat.m2505o(64791);
            }
        } catch (Throwable th) {
            AppMethodBeat.m2505o(64791);
        }
    }

    public void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        AppMethodBeat.m2504i(64763);
        if (!this.f3017c || this.f3015a == null) {
            if (!(this.f3017c || this.f3016b == null)) {
                this.f3016b.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
            }
            AppMethodBeat.m2505o(64763);
            return;
        }
        this.f3015a.setLayoutAlgorithm(com.tencent.smtt.export.external.interfaces.IX5WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
        AppMethodBeat.m2505o(64763);
    }

    public void setLightTouchEnabled(boolean z) {
        AppMethodBeat.m2504i(64754);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setLightTouchEnabled(z);
            AppMethodBeat.m2505o(64754);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64754);
        } else {
            this.f3016b.setLightTouchEnabled(z);
            AppMethodBeat.m2505o(64754);
        }
    }

    @TargetApi(7)
    public void setLoadWithOverviewMode(boolean z) {
        AppMethodBeat.m2504i(64738);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setLoadWithOverviewMode(z);
            AppMethodBeat.m2505o(64738);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64738);
        } else {
            this.f3016b.setLoadWithOverviewMode(z);
            AppMethodBeat.m2505o(64738);
        }
    }

    public void setLoadsImagesAutomatically(boolean z) {
        AppMethodBeat.m2504i(64785);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setLoadsImagesAutomatically(z);
            AppMethodBeat.m2505o(64785);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64785);
        } else {
            this.f3016b.setLoadsImagesAutomatically(z);
            AppMethodBeat.m2505o(64785);
        }
    }

    @TargetApi(17)
    public void setMediaPlaybackRequiresUserGesture(boolean z) {
        AppMethodBeat.m2504i(64818);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setMediaPlaybackRequiresUserGesture(z);
            AppMethodBeat.m2505o(64818);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64818);
        } else if (VERSION.SDK_INT < 17) {
            AppMethodBeat.m2505o(64818);
        } else {
            C30951r.m49578a(this.f3016b, "setMediaPlaybackRequiresUserGesture", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.m2505o(64818);
        }
    }

    public synchronized void setMinimumFontSize(int i) {
        AppMethodBeat.m2504i(64777);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setMinimumFontSize(i);
            AppMethodBeat.m2505o(64777);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64777);
        } else {
            this.f3016b.setMinimumFontSize(i);
            AppMethodBeat.m2505o(64777);
        }
    }

    public synchronized void setMinimumLogicalFontSize(int i) {
        AppMethodBeat.m2504i(64779);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setMinimumLogicalFontSize(i);
            AppMethodBeat.m2505o(64779);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64779);
        } else {
            this.f3016b.setMinimumLogicalFontSize(i);
            AppMethodBeat.m2505o(64779);
        }
    }

    @TargetApi(21)
    public void setMixedContentMode(int i) {
        AppMethodBeat.m2504i(64736);
        if (this.f3017c && this.f3015a != null) {
            AppMethodBeat.m2505o(64736);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64736);
        } else if (VERSION.SDK_INT < 21) {
            AppMethodBeat.m2505o(64736);
        } else {
            C30951r.m49578a(this.f3016b, "setMixedContentMode", new Class[]{Integer.TYPE}, Integer.valueOf(i));
            AppMethodBeat.m2505o(64736);
        }
    }

    public void setNavDump(boolean z) {
        AppMethodBeat.m2504i(64724);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setNavDump(z);
            AppMethodBeat.m2505o(64724);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64724);
        } else {
            C30951r.m49578a(this.f3016b, "setNavDump", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.m2505o(64724);
        }
    }

    public void setNeedInitialFocus(boolean z) {
        AppMethodBeat.m2504i(64819);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setNeedInitialFocus(z);
            AppMethodBeat.m2505o(64819);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64819);
        } else {
            this.f3016b.setNeedInitialFocus(z);
            AppMethodBeat.m2505o(64819);
        }
    }

    @TargetApi(8)
    @Deprecated
    public synchronized void setPluginState(PluginState pluginState) {
        AppMethodBeat.m2504i(64795);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setPluginState(com.tencent.smtt.export.external.interfaces.IX5WebSettings.PluginState.valueOf(pluginState.name()));
            AppMethodBeat.m2505o(64795);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64795);
        } else if (VERSION.SDK_INT >= 8) {
            android.webkit.WebSettings.PluginState valueOf = android.webkit.WebSettings.PluginState.valueOf(pluginState.name());
            C30951r.m49578a(this.f3016b, "setPluginState", new Class[]{android.webkit.WebSettings.PluginState.class}, valueOf);
            AppMethodBeat.m2505o(64795);
        } else {
            AppMethodBeat.m2505o(64795);
        }
    }

    @Deprecated
    public void setPluginsEnabled(boolean z) {
        AppMethodBeat.m2504i(64794);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setPluginsEnabled(z);
            AppMethodBeat.m2505o(64794);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64794);
        } else {
            C30951r.m49578a(this.f3016b, "setPluginsEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.m2505o(64794);
        }
    }

    @Deprecated
    public synchronized void setPluginsPath(String str) {
        AppMethodBeat.m2504i(64796);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setPluginsPath(str);
            AppMethodBeat.m2505o(64796);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64796);
        } else {
            C30951r.m49578a(this.f3016b, "setPluginsPath", new Class[]{String.class}, str);
            AppMethodBeat.m2505o(64796);
        }
    }

    public void setRenderPriority(RenderPriority renderPriority) {
        AppMethodBeat.m2504i(64820);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setRenderPriority(com.tencent.smtt.export.external.interfaces.IX5WebSettings.RenderPriority.valueOf(renderPriority.name()));
            AppMethodBeat.m2505o(64820);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64820);
        } else {
            this.f3016b.setRenderPriority(android.webkit.WebSettings.RenderPriority.valueOf(renderPriority.name()));
            AppMethodBeat.m2505o(64820);
        }
    }

    public synchronized void setSansSerifFontFamily(String str) {
        AppMethodBeat.m2504i(64769);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setSansSerifFontFamily(str);
            AppMethodBeat.m2505o(64769);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64769);
        } else {
            this.f3016b.setSansSerifFontFamily(str);
            AppMethodBeat.m2505o(64769);
        }
    }

    public void setSaveFormData(boolean z) {
        AppMethodBeat.m2504i(64744);
        if (!this.f3017c || this.f3015a == null) {
            if (!(this.f3017c || this.f3016b == null)) {
                this.f3016b.setSaveFormData(z);
            }
            AppMethodBeat.m2505o(64744);
            return;
        }
        this.f3015a.setSaveFormData(z);
        AppMethodBeat.m2505o(64744);
    }

    public void setSavePassword(boolean z) {
        AppMethodBeat.m2504i(64746);
        if (!this.f3017c || this.f3015a == null) {
            if (!(this.f3017c || this.f3016b == null)) {
                this.f3016b.setSavePassword(z);
            }
            AppMethodBeat.m2505o(64746);
            return;
        }
        this.f3015a.setSavePassword(z);
        AppMethodBeat.m2505o(64746);
    }

    public synchronized void setSerifFontFamily(String str) {
        AppMethodBeat.m2504i(64771);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setSerifFontFamily(str);
            AppMethodBeat.m2505o(64771);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64771);
        } else {
            this.f3016b.setSerifFontFamily(str);
            AppMethodBeat.m2505o(64771);
        }
    }

    public synchronized void setStandardFontFamily(String str) {
        AppMethodBeat.m2504i(64765);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setStandardFontFamily(str);
            AppMethodBeat.m2505o(64765);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64765);
        } else {
            this.f3016b.setStandardFontFamily(str);
            AppMethodBeat.m2505o(64765);
        }
    }

    public void setSupportMultipleWindows(boolean z) {
        AppMethodBeat.m2504i(64761);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setSupportMultipleWindows(z);
            AppMethodBeat.m2505o(64761);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64761);
        } else {
            this.f3016b.setSupportMultipleWindows(z);
            AppMethodBeat.m2505o(64761);
        }
    }

    public void setSupportZoom(boolean z) {
        AppMethodBeat.m2504i(64727);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setSupportZoom(z);
            AppMethodBeat.m2505o(64727);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64727);
        } else {
            this.f3016b.setSupportZoom(z);
            AppMethodBeat.m2505o(64727);
        }
    }

    public void setTextSize(TextSize textSize) {
        AppMethodBeat.m2504i(64750);
        if (!this.f3017c || this.f3015a == null) {
            if (!(this.f3017c || this.f3016b == null)) {
                this.f3016b.setTextSize(android.webkit.WebSettings.TextSize.valueOf(textSize.name()));
            }
            AppMethodBeat.m2505o(64750);
            return;
        }
        this.f3015a.setTextSize(com.tencent.smtt.export.external.interfaces.IX5WebSettings.TextSize.valueOf(textSize.name()));
        AppMethodBeat.m2505o(64750);
    }

    @TargetApi(14)
    public synchronized void setTextZoom(int i) {
        AppMethodBeat.m2504i(64748);
        if (!this.f3017c || this.f3015a == null) {
            if (!(this.f3017c || this.f3016b == null)) {
                if (VERSION.SDK_INT < 14) {
                    AppMethodBeat.m2505o(64748);
                } else {
                    try {
                        this.f3016b.setTextZoom(i);
                        AppMethodBeat.m2505o(64748);
                    } catch (Exception e) {
                        C30951r.m49578a(this.f3016b, "setTextZoom", new Class[]{Integer.TYPE}, Integer.valueOf(i));
                    }
                }
            }
            AppMethodBeat.m2505o(64748);
        } else {
            this.f3015a.setTextZoom(i);
            AppMethodBeat.m2505o(64748);
        }
    }

    @Deprecated
    public void setUseWebViewBackgroundForOverscrollBackground(boolean z) {
        AppMethodBeat.m2504i(64742);
        if (this.f3017c && this.f3015a != null) {
            this.f3015a.setUseWebViewBackgroundForOverscrollBackground(z);
            AppMethodBeat.m2505o(64742);
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64742);
        } else {
            C30951r.m49578a(this.f3016b, "setUseWebViewBackgroundForOverscrollBackground", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.m2505o(64742);
        }
    }

    public void setUseWideViewPort(boolean z) {
        AppMethodBeat.m2504i(64759);
        if (!this.f3017c || this.f3015a == null) {
            if (!(this.f3017c || this.f3016b == null)) {
                this.f3016b.setUseWideViewPort(z);
            }
            AppMethodBeat.m2505o(64759);
            return;
        }
        this.f3015a.setUseWideViewPort(z);
        AppMethodBeat.m2505o(64759);
    }

    public void setUserAgent(String str) {
        AppMethodBeat.m2504i(64756);
        if (!this.f3017c || this.f3015a == null) {
            if (!(this.f3017c || this.f3016b == null)) {
                this.f3016b.setUserAgentString(str);
            }
            AppMethodBeat.m2505o(64756);
            return;
        }
        this.f3015a.setUserAgent(str);
        AppMethodBeat.m2505o(64756);
    }

    @TargetApi(3)
    public void setUserAgentString(String str) {
        AppMethodBeat.m2504i(64758);
        if (!this.f3017c || this.f3015a == null) {
            if (!(this.f3017c || this.f3016b == null)) {
                this.f3016b.setUserAgentString(str);
            }
            AppMethodBeat.m2505o(64758);
            return;
        }
        this.f3015a.setUserAgentString(str);
        AppMethodBeat.m2505o(64758);
    }

    public synchronized boolean supportMultipleWindows() {
        boolean supportMultipleWindows;
        AppMethodBeat.m2504i(64762);
        if (this.f3017c && this.f3015a != null) {
            supportMultipleWindows = this.f3015a.supportMultipleWindows();
            AppMethodBeat.m2505o(64762);
        } else if (this.f3017c || this.f3016b == null) {
            supportMultipleWindows = false;
            AppMethodBeat.m2505o(64762);
        } else {
            supportMultipleWindows = this.f3016b.supportMultipleWindows();
            AppMethodBeat.m2505o(64762);
        }
        return supportMultipleWindows;
    }

    public boolean supportZoom() {
        AppMethodBeat.m2504i(64728);
        boolean supportZoom;
        if (this.f3017c && this.f3015a != null) {
            supportZoom = this.f3015a.supportZoom();
            AppMethodBeat.m2505o(64728);
            return supportZoom;
        } else if (this.f3017c || this.f3016b == null) {
            AppMethodBeat.m2505o(64728);
            return false;
        } else {
            supportZoom = this.f3016b.supportZoom();
            AppMethodBeat.m2505o(64728);
            return supportZoom;
        }
    }
}
