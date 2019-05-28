package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings;
import com.tencent.smtt.utils.r;

public class WebSettings {
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;
    private IX5WebSettings a;
    private android.webkit.WebSettings b;
    private boolean c;

    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW;

        static {
            AppMethodBeat.o(64717);
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
            AppMethodBeat.o(64720);
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
            AppMethodBeat.o(64714);
        }
    }

    public enum ZoomDensity {
        FAR(150),
        MEDIUM(100),
        CLOSE(75);
        
        int value;

        static {
            AppMethodBeat.o(64723);
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
            AppMethodBeat.o(64711);
        }
    }

    WebSettings(android.webkit.WebSettings webSettings) {
        this.a = null;
        this.b = null;
        this.c = false;
        this.a = null;
        this.b = webSettings;
        this.c = false;
    }

    WebSettings(IX5WebSettings iX5WebSettings) {
        this.a = null;
        this.b = null;
        this.c = false;
        this.a = iX5WebSettings;
        this.b = null;
        this.c = true;
    }

    @TargetApi(17)
    public static String getDefaultUserAgent(Context context) {
        AppMethodBeat.i(64816);
        String i;
        if (bv.a().b()) {
            i = bv.a().c().i(context);
            AppMethodBeat.o(64816);
            return i;
        } else if (VERSION.SDK_INT < 17) {
            AppMethodBeat.o(64816);
            return null;
        } else {
            Object a = r.a(android.webkit.WebSettings.class, "getDefaultUserAgent", new Class[]{Context.class}, context);
            if (a == null) {
                AppMethodBeat.o(64816);
                return null;
            }
            i = (String) a;
            AppMethodBeat.o(64816);
            return i;
        }
    }

    @Deprecated
    public boolean enableSmoothTransition() {
        AppMethodBeat.i(64741);
        boolean enableSmoothTransition;
        if (this.c && this.a != null) {
            enableSmoothTransition = this.a.enableSmoothTransition();
            AppMethodBeat.o(64741);
            return enableSmoothTransition;
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64741);
            return false;
        } else if (VERSION.SDK_INT >= 11) {
            Object a = r.a(this.b, "enableSmoothTransition");
            if (a == null) {
                AppMethodBeat.o(64741);
                return false;
            }
            enableSmoothTransition = ((Boolean) a).booleanValue();
            AppMethodBeat.o(64741);
            return enableSmoothTransition;
        } else {
            AppMethodBeat.o(64741);
            return false;
        }
    }

    @TargetApi(11)
    public boolean getAllowContentAccess() {
        AppMethodBeat.i(64737);
        boolean allowContentAccess;
        if (this.c && this.a != null) {
            allowContentAccess = this.a.getAllowContentAccess();
            AppMethodBeat.o(64737);
            return allowContentAccess;
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64737);
            return false;
        } else if (VERSION.SDK_INT >= 11) {
            Object a = r.a(this.b, "getAllowContentAccess");
            if (a == null) {
                AppMethodBeat.o(64737);
                return false;
            }
            allowContentAccess = ((Boolean) a).booleanValue();
            AppMethodBeat.o(64737);
            return allowContentAccess;
        } else {
            AppMethodBeat.o(64737);
            return false;
        }
    }

    @TargetApi(3)
    public boolean getAllowFileAccess() {
        AppMethodBeat.i(64734);
        boolean allowFileAccess;
        if (this.c && this.a != null) {
            allowFileAccess = this.a.getAllowFileAccess();
            AppMethodBeat.o(64734);
            return allowFileAccess;
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64734);
            return false;
        } else {
            allowFileAccess = this.b.getAllowFileAccess();
            AppMethodBeat.o(64734);
            return allowFileAccess;
        }
    }

    public synchronized boolean getBlockNetworkImage() {
        boolean blockNetworkImage;
        AppMethodBeat.i(64788);
        if (this.c && this.a != null) {
            blockNetworkImage = this.a.getBlockNetworkImage();
            AppMethodBeat.o(64788);
        } else if (this.c || this.b == null) {
            blockNetworkImage = false;
            AppMethodBeat.o(64788);
        } else {
            blockNetworkImage = this.b.getBlockNetworkImage();
            AppMethodBeat.o(64788);
        }
        return blockNetworkImage;
    }

    @TargetApi(8)
    public synchronized boolean getBlockNetworkLoads() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(64790);
            if (this.c && this.a != null) {
                z = this.a.getBlockNetworkLoads();
                AppMethodBeat.o(64790);
            } else if (this.c || this.b == null) {
                AppMethodBeat.o(64790);
            } else if (VERSION.SDK_INT >= 8) {
                z = this.b.getBlockNetworkLoads();
                AppMethodBeat.o(64790);
            } else {
                AppMethodBeat.o(64790);
            }
        }
        return z;
    }

    @TargetApi(3)
    public boolean getBuiltInZoomControls() {
        AppMethodBeat.i(64730);
        boolean builtInZoomControls;
        if (this.c && this.a != null) {
            builtInZoomControls = this.a.getBuiltInZoomControls();
            AppMethodBeat.o(64730);
            return builtInZoomControls;
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64730);
            return false;
        } else {
            builtInZoomControls = this.b.getBuiltInZoomControls();
            AppMethodBeat.o(64730);
            return builtInZoomControls;
        }
    }

    public int getCacheMode() {
        AppMethodBeat.i(64822);
        int cacheMode;
        if (this.c && this.a != null) {
            cacheMode = this.a.getCacheMode();
            AppMethodBeat.o(64822);
            return cacheMode;
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64822);
            return 0;
        } else {
            cacheMode = this.b.getCacheMode();
            AppMethodBeat.o(64822);
            return cacheMode;
        }
    }

    public synchronized String getCursiveFontFamily() {
        String cursiveFontFamily;
        AppMethodBeat.i(64774);
        if (this.c && this.a != null) {
            cursiveFontFamily = this.a.getCursiveFontFamily();
            AppMethodBeat.o(64774);
        } else if (this.c || this.b == null) {
            cursiveFontFamily = "";
            AppMethodBeat.o(64774);
        } else {
            cursiveFontFamily = this.b.getCursiveFontFamily();
            AppMethodBeat.o(64774);
        }
        return cursiveFontFamily;
    }

    @TargetApi(5)
    public synchronized boolean getDatabaseEnabled() {
        boolean databaseEnabled;
        AppMethodBeat.i(64806);
        if (this.c && this.a != null) {
            databaseEnabled = this.a.getDatabaseEnabled();
            AppMethodBeat.o(64806);
        } else if (this.c || this.b == null) {
            databaseEnabled = false;
            AppMethodBeat.o(64806);
        } else {
            databaseEnabled = this.b.getDatabaseEnabled();
            AppMethodBeat.o(64806);
        }
        return databaseEnabled;
    }

    @TargetApi(5)
    public synchronized String getDatabasePath() {
        String databasePath;
        AppMethodBeat.i(64805);
        if (this.c && this.a != null) {
            databasePath = this.a.getDatabasePath();
            AppMethodBeat.o(64805);
        } else if (this.c || this.b == null) {
            databasePath = "";
            AppMethodBeat.o(64805);
        } else {
            databasePath = this.b.getDatabasePath();
            AppMethodBeat.o(64805);
        }
        return databasePath;
    }

    public synchronized int getDefaultFixedFontSize() {
        int defaultFixedFontSize;
        AppMethodBeat.i(64784);
        if (this.c && this.a != null) {
            defaultFixedFontSize = this.a.getDefaultFixedFontSize();
            AppMethodBeat.o(64784);
        } else if (this.c || this.b == null) {
            defaultFixedFontSize = 0;
            AppMethodBeat.o(64784);
        } else {
            defaultFixedFontSize = this.b.getDefaultFixedFontSize();
            AppMethodBeat.o(64784);
        }
        return defaultFixedFontSize;
    }

    public synchronized int getDefaultFontSize() {
        int defaultFontSize;
        AppMethodBeat.i(64782);
        if (this.c && this.a != null) {
            defaultFontSize = this.a.getDefaultFontSize();
            AppMethodBeat.o(64782);
        } else if (this.c || this.b == null) {
            defaultFontSize = 0;
            AppMethodBeat.o(64782);
        } else {
            defaultFontSize = this.b.getDefaultFontSize();
            AppMethodBeat.o(64782);
        }
        return defaultFontSize;
    }

    public synchronized String getDefaultTextEncodingName() {
        String defaultTextEncodingName;
        AppMethodBeat.i(64815);
        if (this.c && this.a != null) {
            defaultTextEncodingName = this.a.getDefaultTextEncodingName();
            AppMethodBeat.o(64815);
        } else if (this.c || this.b == null) {
            defaultTextEncodingName = "";
            AppMethodBeat.o(64815);
        } else {
            defaultTextEncodingName = this.b.getDefaultTextEncodingName();
            AppMethodBeat.o(64815);
        }
        return defaultTextEncodingName;
    }

    @TargetApi(7)
    public ZoomDensity getDefaultZoom() {
        AppMethodBeat.i(64753);
        ZoomDensity valueOf;
        if (this.c && this.a != null) {
            valueOf = ZoomDensity.valueOf(this.a.getDefaultZoom().name());
            AppMethodBeat.o(64753);
            return valueOf;
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64753);
            return null;
        } else {
            valueOf = ZoomDensity.valueOf(this.b.getDefaultZoom().name());
            AppMethodBeat.o(64753);
            return valueOf;
        }
    }

    @TargetApi(11)
    public boolean getDisplayZoomControls() {
        AppMethodBeat.i(64732);
        boolean displayZoomControls;
        if (this.c && this.a != null) {
            displayZoomControls = this.a.getDisplayZoomControls();
            AppMethodBeat.o(64732);
            return displayZoomControls;
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64732);
            return false;
        } else if (VERSION.SDK_INT >= 11) {
            Object a = r.a(this.b, "getDisplayZoomControls");
            if (a == null) {
                AppMethodBeat.o(64732);
                return false;
            }
            displayZoomControls = ((Boolean) a).booleanValue();
            AppMethodBeat.o(64732);
            return displayZoomControls;
        } else {
            AppMethodBeat.o(64732);
            return false;
        }
    }

    @TargetApi(7)
    public synchronized boolean getDomStorageEnabled() {
        boolean domStorageEnabled;
        AppMethodBeat.i(64804);
        if (this.c && this.a != null) {
            domStorageEnabled = this.a.getDomStorageEnabled();
            AppMethodBeat.o(64804);
        } else if (this.c || this.b == null) {
            domStorageEnabled = false;
            AppMethodBeat.o(64804);
        } else {
            domStorageEnabled = this.b.getDomStorageEnabled();
            AppMethodBeat.o(64804);
        }
        return domStorageEnabled;
    }

    public synchronized String getFantasyFontFamily() {
        String fantasyFontFamily;
        AppMethodBeat.i(64776);
        if (this.c && this.a != null) {
            fantasyFontFamily = this.a.getFantasyFontFamily();
            AppMethodBeat.o(64776);
        } else if (this.c || this.b == null) {
            fantasyFontFamily = "";
            AppMethodBeat.o(64776);
        } else {
            fantasyFontFamily = this.b.getFantasyFontFamily();
            AppMethodBeat.o(64776);
        }
        return fantasyFontFamily;
    }

    public synchronized String getFixedFontFamily() {
        String fixedFontFamily;
        AppMethodBeat.i(64768);
        if (this.c && this.a != null) {
            fixedFontFamily = this.a.getFixedFontFamily();
            AppMethodBeat.o(64768);
        } else if (this.c || this.b == null) {
            fixedFontFamily = "";
            AppMethodBeat.o(64768);
        } else {
            fixedFontFamily = this.b.getFixedFontFamily();
            AppMethodBeat.o(64768);
        }
        return fixedFontFamily;
    }

    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        boolean javaScriptCanOpenWindowsAutomatically;
        AppMethodBeat.i(64813);
        if (this.c && this.a != null) {
            javaScriptCanOpenWindowsAutomatically = this.a.getJavaScriptCanOpenWindowsAutomatically();
            AppMethodBeat.o(64813);
        } else if (this.c || this.b == null) {
            javaScriptCanOpenWindowsAutomatically = false;
            AppMethodBeat.o(64813);
        } else {
            javaScriptCanOpenWindowsAutomatically = this.b.getJavaScriptCanOpenWindowsAutomatically();
            AppMethodBeat.o(64813);
        }
        return javaScriptCanOpenWindowsAutomatically;
    }

    public synchronized boolean getJavaScriptEnabled() {
        boolean javaScriptEnabled;
        AppMethodBeat.i(64808);
        if (this.c && this.a != null) {
            javaScriptEnabled = this.a.getJavaScriptEnabled();
            AppMethodBeat.o(64808);
        } else if (this.c || this.b == null) {
            javaScriptEnabled = false;
            AppMethodBeat.o(64808);
        } else {
            javaScriptEnabled = this.b.getJavaScriptEnabled();
            AppMethodBeat.o(64808);
        }
        return javaScriptEnabled;
    }

    public synchronized LayoutAlgorithm getLayoutAlgorithm() {
        LayoutAlgorithm valueOf;
        AppMethodBeat.i(64764);
        if (this.c && this.a != null) {
            valueOf = LayoutAlgorithm.valueOf(this.a.getLayoutAlgorithm().name());
            AppMethodBeat.o(64764);
        } else if (this.c || this.b == null) {
            valueOf = null;
            AppMethodBeat.o(64764);
        } else {
            valueOf = LayoutAlgorithm.valueOf(this.b.getLayoutAlgorithm().name());
            AppMethodBeat.o(64764);
        }
        return valueOf;
    }

    public boolean getLightTouchEnabled() {
        AppMethodBeat.i(64755);
        boolean lightTouchEnabled;
        if (this.c && this.a != null) {
            lightTouchEnabled = this.a.getLightTouchEnabled();
            AppMethodBeat.o(64755);
            return lightTouchEnabled;
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64755);
            return false;
        } else {
            lightTouchEnabled = this.b.getLightTouchEnabled();
            AppMethodBeat.o(64755);
            return lightTouchEnabled;
        }
    }

    @TargetApi(7)
    public boolean getLoadWithOverviewMode() {
        AppMethodBeat.i(64739);
        boolean loadWithOverviewMode;
        if (this.c && this.a != null) {
            loadWithOverviewMode = this.a.getLoadWithOverviewMode();
            AppMethodBeat.o(64739);
            return loadWithOverviewMode;
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64739);
            return false;
        } else {
            loadWithOverviewMode = this.b.getLoadWithOverviewMode();
            AppMethodBeat.o(64739);
            return loadWithOverviewMode;
        }
    }

    public synchronized boolean getLoadsImagesAutomatically() {
        boolean loadsImagesAutomatically;
        AppMethodBeat.i(64786);
        if (this.c && this.a != null) {
            loadsImagesAutomatically = this.a.getLoadsImagesAutomatically();
            AppMethodBeat.o(64786);
        } else if (this.c || this.b == null) {
            loadsImagesAutomatically = false;
            AppMethodBeat.o(64786);
        } else {
            loadsImagesAutomatically = this.b.getLoadsImagesAutomatically();
            AppMethodBeat.o(64786);
        }
        return loadsImagesAutomatically;
    }

    @TargetApi(17)
    public boolean getMediaPlaybackRequiresUserGesture() {
        AppMethodBeat.i(64817);
        boolean mediaPlaybackRequiresUserGesture;
        if (this.c && this.a != null) {
            mediaPlaybackRequiresUserGesture = this.a.getMediaPlaybackRequiresUserGesture();
            AppMethodBeat.o(64817);
            return mediaPlaybackRequiresUserGesture;
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64817);
            return false;
        } else if (VERSION.SDK_INT < 17) {
            AppMethodBeat.o(64817);
            return false;
        } else {
            Object a = r.a(this.b, "getMediaPlaybackRequiresUserGesture");
            if (a == null) {
                AppMethodBeat.o(64817);
                return false;
            }
            mediaPlaybackRequiresUserGesture = ((Boolean) a).booleanValue();
            AppMethodBeat.o(64817);
            return mediaPlaybackRequiresUserGesture;
        }
    }

    public synchronized int getMinimumFontSize() {
        int minimumFontSize;
        AppMethodBeat.i(64778);
        if (this.c && this.a != null) {
            minimumFontSize = this.a.getMinimumFontSize();
            AppMethodBeat.o(64778);
        } else if (this.c || this.b == null) {
            minimumFontSize = 0;
            AppMethodBeat.o(64778);
        } else {
            minimumFontSize = this.b.getMinimumFontSize();
            AppMethodBeat.o(64778);
        }
        return minimumFontSize;
    }

    public synchronized int getMinimumLogicalFontSize() {
        int minimumLogicalFontSize;
        AppMethodBeat.i(64780);
        if (this.c && this.a != null) {
            minimumLogicalFontSize = this.a.getMinimumLogicalFontSize();
            AppMethodBeat.o(64780);
        } else if (this.c || this.b == null) {
            minimumLogicalFontSize = 0;
            AppMethodBeat.o(64780);
        } else {
            minimumLogicalFontSize = this.b.getMinimumLogicalFontSize();
            AppMethodBeat.o(64780);
        }
        return minimumLogicalFontSize;
    }

    public synchronized int getMixedContentMode() {
        int mixedContentMode;
        AppMethodBeat.i(64725);
        if (this.c && this.a != null) {
            try {
                mixedContentMode = this.a.getMixedContentMode();
                AppMethodBeat.o(64725);
            } catch (Throwable th) {
                AppMethodBeat.o(64725);
                mixedContentMode = -1;
            }
        } else if (VERSION.SDK_INT < 21) {
            AppMethodBeat.o(64725);
            mixedContentMode = -1;
        } else {
            Object a = r.a(this.b, "getMixedContentMode", new Class[0], new Object[0]);
            if (a == null) {
                AppMethodBeat.o(64725);
                mixedContentMode = -1;
            } else {
                mixedContentMode = ((Integer) a).intValue();
                AppMethodBeat.o(64725);
            }
        }
        return mixedContentMode;
    }

    public boolean getNavDump() {
        AppMethodBeat.i(64726);
        boolean navDump;
        if (this.c && this.a != null) {
            navDump = this.a.getNavDump();
            AppMethodBeat.o(64726);
            return navDump;
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64726);
            return false;
        } else {
            Object a = r.a(this.b, "getNavDump");
            if (a == null) {
                AppMethodBeat.o(64726);
                return false;
            }
            navDump = ((Boolean) a).booleanValue();
            AppMethodBeat.o(64726);
            return navDump;
        }
    }

    @TargetApi(8)
    @Deprecated
    public synchronized PluginState getPluginState() {
        PluginState valueOf;
        AppMethodBeat.i(64810);
        if (this.c && this.a != null) {
            valueOf = PluginState.valueOf(this.a.getPluginState().name());
            AppMethodBeat.o(64810);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64810);
            valueOf = null;
        } else if (VERSION.SDK_INT >= 8) {
            Object a = r.a(this.b, "getPluginState");
            if (a == null) {
                AppMethodBeat.o(64810);
                valueOf = null;
            } else {
                valueOf = PluginState.valueOf(((android.webkit.WebSettings.PluginState) a).name());
                AppMethodBeat.o(64810);
            }
        } else {
            AppMethodBeat.o(64810);
            valueOf = null;
        }
        return valueOf;
    }

    @TargetApi(8)
    @Deprecated
    public synchronized boolean getPluginsEnabled() {
        boolean pluginsEnabled;
        AppMethodBeat.i(64809);
        if (this.c && this.a != null) {
            pluginsEnabled = this.a.getPluginsEnabled();
            AppMethodBeat.o(64809);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64809);
            pluginsEnabled = false;
        } else if (VERSION.SDK_INT <= 17) {
            Object a = r.a(this.b, "getPluginsEnabled");
            if (a == null) {
                AppMethodBeat.o(64809);
                pluginsEnabled = false;
            } else {
                pluginsEnabled = ((Boolean) a).booleanValue();
                AppMethodBeat.o(64809);
            }
        } else if (VERSION.SDK_INT == 18) {
            if (android.webkit.WebSettings.PluginState.ON == this.b.getPluginState()) {
                pluginsEnabled = true;
                AppMethodBeat.o(64809);
            } else {
                AppMethodBeat.o(64809);
                pluginsEnabled = false;
            }
        } else {
            AppMethodBeat.o(64809);
            pluginsEnabled = false;
        }
        return pluginsEnabled;
    }

    @Deprecated
    public synchronized String getPluginsPath() {
        String pluginsPath;
        AppMethodBeat.i(64811);
        if (this.c && this.a != null) {
            pluginsPath = this.a.getPluginsPath();
            AppMethodBeat.o(64811);
        } else if (this.c || this.b == null) {
            pluginsPath = "";
            AppMethodBeat.o(64811);
        } else if (VERSION.SDK_INT <= 17) {
            Object a = r.a(this.b, "getPluginsPath");
            if (a == null) {
                pluginsPath = null;
                AppMethodBeat.o(64811);
            } else {
                pluginsPath = (String) a;
                AppMethodBeat.o(64811);
            }
        } else {
            pluginsPath = "";
            AppMethodBeat.o(64811);
        }
        return pluginsPath;
    }

    public synchronized String getSansSerifFontFamily() {
        String sansSerifFontFamily;
        AppMethodBeat.i(64770);
        if (this.c && this.a != null) {
            sansSerifFontFamily = this.a.getSansSerifFontFamily();
            AppMethodBeat.o(64770);
        } else if (this.c || this.b == null) {
            sansSerifFontFamily = "";
            AppMethodBeat.o(64770);
        } else {
            sansSerifFontFamily = this.b.getSansSerifFontFamily();
            AppMethodBeat.o(64770);
        }
        return sansSerifFontFamily;
    }

    public boolean getSaveFormData() {
        AppMethodBeat.i(64745);
        boolean saveFormData;
        if (this.c && this.a != null) {
            saveFormData = this.a.getSaveFormData();
            AppMethodBeat.o(64745);
            return saveFormData;
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64745);
            return false;
        } else {
            saveFormData = this.b.getSaveFormData();
            AppMethodBeat.o(64745);
            return saveFormData;
        }
    }

    public boolean getSavePassword() {
        AppMethodBeat.i(64747);
        boolean savePassword;
        if (this.c && this.a != null) {
            savePassword = this.a.getSavePassword();
            AppMethodBeat.o(64747);
            return savePassword;
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64747);
            return false;
        } else {
            savePassword = this.b.getSavePassword();
            AppMethodBeat.o(64747);
            return savePassword;
        }
    }

    public synchronized String getSerifFontFamily() {
        String serifFontFamily;
        AppMethodBeat.i(64772);
        if (this.c && this.a != null) {
            serifFontFamily = this.a.getSerifFontFamily();
            AppMethodBeat.o(64772);
        } else if (this.c || this.b == null) {
            serifFontFamily = "";
            AppMethodBeat.o(64772);
        } else {
            serifFontFamily = this.b.getSerifFontFamily();
            AppMethodBeat.o(64772);
        }
        return serifFontFamily;
    }

    public synchronized String getStandardFontFamily() {
        String standardFontFamily;
        AppMethodBeat.i(64766);
        if (this.c && this.a != null) {
            standardFontFamily = this.a.getStandardFontFamily();
            AppMethodBeat.o(64766);
        } else if (this.c || this.b == null) {
            standardFontFamily = "";
            AppMethodBeat.o(64766);
        } else {
            standardFontFamily = this.b.getStandardFontFamily();
            AppMethodBeat.o(64766);
        }
        return standardFontFamily;
    }

    public TextSize getTextSize() {
        AppMethodBeat.i(64751);
        TextSize valueOf;
        if (this.c && this.a != null) {
            valueOf = TextSize.valueOf(this.a.getTextSize().name());
            AppMethodBeat.o(64751);
            return valueOf;
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64751);
            return null;
        } else {
            valueOf = TextSize.valueOf(this.b.getTextSize().name());
            AppMethodBeat.o(64751);
            return valueOf;
        }
    }

    @TargetApi(14)
    public synchronized int getTextZoom() {
        int textZoom;
        AppMethodBeat.i(64749);
        if (this.c && this.a != null) {
            textZoom = this.a.getTextZoom();
            AppMethodBeat.o(64749);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64749);
            textZoom = 0;
        } else if (VERSION.SDK_INT < 14) {
            AppMethodBeat.o(64749);
            textZoom = 0;
        } else {
            try {
                textZoom = this.b.getTextZoom();
                AppMethodBeat.o(64749);
            } catch (Exception e) {
                Object a = r.a(this.b, "getTextZoom");
                if (a == null) {
                    AppMethodBeat.o(64749);
                    textZoom = 0;
                } else {
                    textZoom = ((Integer) a).intValue();
                    AppMethodBeat.o(64749);
                }
            }
        }
        return textZoom;
    }

    @Deprecated
    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        AppMethodBeat.i(64743);
        boolean useWebViewBackgroundForOverscrollBackground;
        if (this.c && this.a != null) {
            useWebViewBackgroundForOverscrollBackground = this.a.getUseWebViewBackgroundForOverscrollBackground();
            AppMethodBeat.o(64743);
            return useWebViewBackgroundForOverscrollBackground;
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64743);
            return false;
        } else {
            Object a = r.a(this.b, "getUseWebViewBackgroundForOverscrollBackground");
            if (a == null) {
                AppMethodBeat.o(64743);
                return false;
            }
            useWebViewBackgroundForOverscrollBackground = ((Boolean) a).booleanValue();
            AppMethodBeat.o(64743);
            return useWebViewBackgroundForOverscrollBackground;
        }
    }

    public synchronized boolean getUseWideViewPort() {
        boolean useWideViewPort;
        AppMethodBeat.i(64760);
        if (this.c && this.a != null) {
            useWideViewPort = this.a.getUseWideViewPort();
            AppMethodBeat.o(64760);
        } else if (this.c || this.b == null) {
            useWideViewPort = false;
            AppMethodBeat.o(64760);
        } else {
            useWideViewPort = this.b.getUseWideViewPort();
            AppMethodBeat.o(64760);
        }
        return useWideViewPort;
    }

    @TargetApi(3)
    public String getUserAgentString() {
        AppMethodBeat.i(64757);
        String userAgentString;
        if (this.c && this.a != null) {
            userAgentString = this.a.getUserAgentString();
            AppMethodBeat.o(64757);
            return userAgentString;
        } else if (this.c || this.b == null) {
            userAgentString = "";
            AppMethodBeat.o(64757);
            return userAgentString;
        } else {
            userAgentString = this.b.getUserAgentString();
            AppMethodBeat.o(64757);
            return userAgentString;
        }
    }

    @TargetApi(11)
    public void setAllowContentAccess(boolean z) {
        AppMethodBeat.i(64735);
        if (this.c && this.a != null) {
            this.a.setAllowContentAccess(z);
            AppMethodBeat.o(64735);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64735);
        } else if (VERSION.SDK_INT < 11) {
            AppMethodBeat.o(64735);
        } else {
            r.a(this.b, "setAllowContentAccess", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.o(64735);
        }
    }

    @TargetApi(3)
    public void setAllowFileAccess(boolean z) {
        AppMethodBeat.i(64733);
        if (this.c && this.a != null) {
            this.a.setAllowFileAccess(z);
            AppMethodBeat.o(64733);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64733);
        } else {
            this.b.setAllowFileAccess(z);
            AppMethodBeat.o(64733);
        }
    }

    @TargetApi(16)
    public void setAllowFileAccessFromFileURLs(boolean z) {
        AppMethodBeat.i(64793);
        if (this.c && this.a != null) {
            this.a.setAllowFileAccessFromFileURLs(z);
            AppMethodBeat.o(64793);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64793);
        } else {
            r.a(this.b, "setAllowFileAccessFromFileURLs", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.o(64793);
        }
    }

    @TargetApi(16)
    public void setAllowUniversalAccessFromFileURLs(boolean z) {
        AppMethodBeat.i(64792);
        if (this.c && this.a != null) {
            this.a.setAllowUniversalAccessFromFileURLs(z);
            AppMethodBeat.o(64792);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64792);
        } else {
            r.a(this.b, "setAllowUniversalAccessFromFileURLs", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.o(64792);
        }
    }

    @TargetApi(7)
    public void setAppCacheEnabled(boolean z) {
        AppMethodBeat.i(64799);
        if (this.c && this.a != null) {
            this.a.setAppCacheEnabled(z);
            AppMethodBeat.o(64799);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64799);
        } else {
            this.b.setAppCacheEnabled(z);
            AppMethodBeat.o(64799);
        }
    }

    @TargetApi(7)
    public void setAppCacheMaxSize(long j) {
        AppMethodBeat.i(64801);
        if (this.c && this.a != null) {
            this.a.setAppCacheMaxSize(j);
            AppMethodBeat.o(64801);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64801);
        } else {
            this.b.setAppCacheMaxSize(j);
            AppMethodBeat.o(64801);
        }
    }

    @TargetApi(7)
    public void setAppCachePath(String str) {
        AppMethodBeat.i(64800);
        if (this.c && this.a != null) {
            this.a.setAppCachePath(str);
            AppMethodBeat.o(64800);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64800);
        } else {
            this.b.setAppCachePath(str);
            AppMethodBeat.o(64800);
        }
    }

    public void setBlockNetworkImage(boolean z) {
        AppMethodBeat.i(64787);
        if (this.c && this.a != null) {
            this.a.setBlockNetworkImage(z);
            AppMethodBeat.o(64787);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64787);
        } else {
            this.b.setBlockNetworkImage(z);
            AppMethodBeat.o(64787);
        }
    }

    @TargetApi(8)
    public synchronized void setBlockNetworkLoads(boolean z) {
        AppMethodBeat.i(64789);
        if (this.c && this.a != null) {
            this.a.setBlockNetworkLoads(z);
            AppMethodBeat.o(64789);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64789);
        } else if (VERSION.SDK_INT >= 8) {
            this.b.setBlockNetworkLoads(z);
            AppMethodBeat.o(64789);
        } else {
            AppMethodBeat.o(64789);
        }
    }

    @TargetApi(3)
    public void setBuiltInZoomControls(boolean z) {
        AppMethodBeat.i(64729);
        if (this.c && this.a != null) {
            this.a.setBuiltInZoomControls(z);
            AppMethodBeat.o(64729);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64729);
        } else {
            this.b.setBuiltInZoomControls(z);
            AppMethodBeat.o(64729);
        }
    }

    public void setCacheMode(int i) {
        AppMethodBeat.i(64821);
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setCacheMode(i);
            }
            AppMethodBeat.o(64821);
            return;
        }
        this.a.setCacheMode(i);
        AppMethodBeat.o(64821);
    }

    public synchronized void setCursiveFontFamily(String str) {
        AppMethodBeat.i(64773);
        if (this.c && this.a != null) {
            this.a.setCursiveFontFamily(str);
            AppMethodBeat.o(64773);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64773);
        } else {
            this.b.setCursiveFontFamily(str);
            AppMethodBeat.o(64773);
        }
    }

    @TargetApi(5)
    public void setDatabaseEnabled(boolean z) {
        AppMethodBeat.i(64802);
        if (this.c && this.a != null) {
            this.a.setDatabaseEnabled(z);
            AppMethodBeat.o(64802);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64802);
        } else {
            this.b.setDatabaseEnabled(z);
            AppMethodBeat.o(64802);
        }
    }

    @TargetApi(5)
    @Deprecated
    public void setDatabasePath(String str) {
        AppMethodBeat.i(64797);
        if (this.c && this.a != null) {
            this.a.setDatabasePath(str);
            AppMethodBeat.o(64797);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64797);
        } else {
            r.a(this.b, "setDatabasePath", new Class[]{String.class}, str);
            AppMethodBeat.o(64797);
        }
    }

    public synchronized void setDefaultFixedFontSize(int i) {
        AppMethodBeat.i(64783);
        if (this.c && this.a != null) {
            this.a.setDefaultFixedFontSize(i);
            AppMethodBeat.o(64783);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64783);
        } else {
            this.b.setDefaultFixedFontSize(i);
            AppMethodBeat.o(64783);
        }
    }

    public synchronized void setDefaultFontSize(int i) {
        AppMethodBeat.i(64781);
        if (this.c && this.a != null) {
            this.a.setDefaultFontSize(i);
            AppMethodBeat.o(64781);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64781);
        } else {
            this.b.setDefaultFontSize(i);
            AppMethodBeat.o(64781);
        }
    }

    public synchronized void setDefaultTextEncodingName(String str) {
        AppMethodBeat.i(64814);
        if (this.c && this.a != null) {
            this.a.setDefaultTextEncodingName(str);
            AppMethodBeat.o(64814);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64814);
        } else {
            this.b.setDefaultTextEncodingName(str);
            AppMethodBeat.o(64814);
        }
    }

    @TargetApi(7)
    public void setDefaultZoom(ZoomDensity zoomDensity) {
        AppMethodBeat.i(64752);
        if (this.c && this.a != null) {
            this.a.setDefaultZoom(com.tencent.smtt.export.external.interfaces.IX5WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
            AppMethodBeat.o(64752);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64752);
        } else {
            this.b.setDefaultZoom(android.webkit.WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
            AppMethodBeat.o(64752);
        }
    }

    @TargetApi(11)
    public void setDisplayZoomControls(boolean z) {
        AppMethodBeat.i(64731);
        if (this.c && this.a != null) {
            this.a.setDisplayZoomControls(z);
            AppMethodBeat.o(64731);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64731);
        } else if (VERSION.SDK_INT < 11) {
            AppMethodBeat.o(64731);
        } else {
            r.a(this.b, "setDisplayZoomControls", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.o(64731);
        }
    }

    @TargetApi(7)
    public void setDomStorageEnabled(boolean z) {
        AppMethodBeat.i(64803);
        if (this.c && this.a != null) {
            this.a.setDomStorageEnabled(z);
            AppMethodBeat.o(64803);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64803);
        } else {
            this.b.setDomStorageEnabled(z);
            AppMethodBeat.o(64803);
        }
    }

    @TargetApi(11)
    @Deprecated
    public void setEnableSmoothTransition(boolean z) {
        AppMethodBeat.i(64740);
        if (this.c && this.a != null) {
            this.a.setEnableSmoothTransition(z);
            AppMethodBeat.o(64740);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64740);
        } else if (VERSION.SDK_INT >= 11) {
            r.a(this.b, "setEnableSmoothTransition", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.o(64740);
        } else {
            AppMethodBeat.o(64740);
        }
    }

    public synchronized void setFantasyFontFamily(String str) {
        AppMethodBeat.i(64775);
        if (this.c && this.a != null) {
            this.a.setFantasyFontFamily(str);
            AppMethodBeat.o(64775);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64775);
        } else {
            this.b.setFantasyFontFamily(str);
            AppMethodBeat.o(64775);
        }
    }

    public synchronized void setFixedFontFamily(String str) {
        AppMethodBeat.i(64767);
        if (this.c && this.a != null) {
            this.a.setFixedFontFamily(str);
            AppMethodBeat.o(64767);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64767);
        } else {
            this.b.setFixedFontFamily(str);
            AppMethodBeat.o(64767);
        }
    }

    @TargetApi(5)
    public void setGeolocationDatabasePath(String str) {
        AppMethodBeat.i(64798);
        if (this.c && this.a != null) {
            this.a.setGeolocationDatabasePath(str);
            AppMethodBeat.o(64798);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64798);
        } else {
            this.b.setGeolocationDatabasePath(str);
            AppMethodBeat.o(64798);
        }
    }

    @TargetApi(5)
    public void setGeolocationEnabled(boolean z) {
        AppMethodBeat.i(64807);
        if (this.c && this.a != null) {
            this.a.setGeolocationEnabled(z);
            AppMethodBeat.o(64807);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64807);
        } else {
            this.b.setGeolocationEnabled(z);
            AppMethodBeat.o(64807);
        }
    }

    public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        AppMethodBeat.i(64812);
        if (this.c && this.a != null) {
            this.a.setJavaScriptCanOpenWindowsAutomatically(z);
            AppMethodBeat.o(64812);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64812);
        } else {
            this.b.setJavaScriptCanOpenWindowsAutomatically(z);
            AppMethodBeat.o(64812);
        }
    }

    @Deprecated
    public void setJavaScriptEnabled(boolean z) {
        AppMethodBeat.i(64791);
        try {
            if (this.c && this.a != null) {
                this.a.setJavaScriptEnabled(z);
                AppMethodBeat.o(64791);
            } else if (this.c || this.b == null) {
                AppMethodBeat.o(64791);
            } else {
                this.b.setJavaScriptEnabled(z);
                AppMethodBeat.o(64791);
            }
        } catch (Throwable th) {
            AppMethodBeat.o(64791);
        }
    }

    public void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        AppMethodBeat.i(64763);
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
            }
            AppMethodBeat.o(64763);
            return;
        }
        this.a.setLayoutAlgorithm(com.tencent.smtt.export.external.interfaces.IX5WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
        AppMethodBeat.o(64763);
    }

    public void setLightTouchEnabled(boolean z) {
        AppMethodBeat.i(64754);
        if (this.c && this.a != null) {
            this.a.setLightTouchEnabled(z);
            AppMethodBeat.o(64754);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64754);
        } else {
            this.b.setLightTouchEnabled(z);
            AppMethodBeat.o(64754);
        }
    }

    @TargetApi(7)
    public void setLoadWithOverviewMode(boolean z) {
        AppMethodBeat.i(64738);
        if (this.c && this.a != null) {
            this.a.setLoadWithOverviewMode(z);
            AppMethodBeat.o(64738);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64738);
        } else {
            this.b.setLoadWithOverviewMode(z);
            AppMethodBeat.o(64738);
        }
    }

    public void setLoadsImagesAutomatically(boolean z) {
        AppMethodBeat.i(64785);
        if (this.c && this.a != null) {
            this.a.setLoadsImagesAutomatically(z);
            AppMethodBeat.o(64785);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64785);
        } else {
            this.b.setLoadsImagesAutomatically(z);
            AppMethodBeat.o(64785);
        }
    }

    @TargetApi(17)
    public void setMediaPlaybackRequiresUserGesture(boolean z) {
        AppMethodBeat.i(64818);
        if (this.c && this.a != null) {
            this.a.setMediaPlaybackRequiresUserGesture(z);
            AppMethodBeat.o(64818);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64818);
        } else if (VERSION.SDK_INT < 17) {
            AppMethodBeat.o(64818);
        } else {
            r.a(this.b, "setMediaPlaybackRequiresUserGesture", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.o(64818);
        }
    }

    public synchronized void setMinimumFontSize(int i) {
        AppMethodBeat.i(64777);
        if (this.c && this.a != null) {
            this.a.setMinimumFontSize(i);
            AppMethodBeat.o(64777);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64777);
        } else {
            this.b.setMinimumFontSize(i);
            AppMethodBeat.o(64777);
        }
    }

    public synchronized void setMinimumLogicalFontSize(int i) {
        AppMethodBeat.i(64779);
        if (this.c && this.a != null) {
            this.a.setMinimumLogicalFontSize(i);
            AppMethodBeat.o(64779);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64779);
        } else {
            this.b.setMinimumLogicalFontSize(i);
            AppMethodBeat.o(64779);
        }
    }

    @TargetApi(21)
    public void setMixedContentMode(int i) {
        AppMethodBeat.i(64736);
        if (this.c && this.a != null) {
            AppMethodBeat.o(64736);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64736);
        } else if (VERSION.SDK_INT < 21) {
            AppMethodBeat.o(64736);
        } else {
            r.a(this.b, "setMixedContentMode", new Class[]{Integer.TYPE}, Integer.valueOf(i));
            AppMethodBeat.o(64736);
        }
    }

    public void setNavDump(boolean z) {
        AppMethodBeat.i(64724);
        if (this.c && this.a != null) {
            this.a.setNavDump(z);
            AppMethodBeat.o(64724);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64724);
        } else {
            r.a(this.b, "setNavDump", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.o(64724);
        }
    }

    public void setNeedInitialFocus(boolean z) {
        AppMethodBeat.i(64819);
        if (this.c && this.a != null) {
            this.a.setNeedInitialFocus(z);
            AppMethodBeat.o(64819);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64819);
        } else {
            this.b.setNeedInitialFocus(z);
            AppMethodBeat.o(64819);
        }
    }

    @TargetApi(8)
    @Deprecated
    public synchronized void setPluginState(PluginState pluginState) {
        AppMethodBeat.i(64795);
        if (this.c && this.a != null) {
            this.a.setPluginState(com.tencent.smtt.export.external.interfaces.IX5WebSettings.PluginState.valueOf(pluginState.name()));
            AppMethodBeat.o(64795);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64795);
        } else if (VERSION.SDK_INT >= 8) {
            android.webkit.WebSettings.PluginState valueOf = android.webkit.WebSettings.PluginState.valueOf(pluginState.name());
            r.a(this.b, "setPluginState", new Class[]{android.webkit.WebSettings.PluginState.class}, valueOf);
            AppMethodBeat.o(64795);
        } else {
            AppMethodBeat.o(64795);
        }
    }

    @Deprecated
    public void setPluginsEnabled(boolean z) {
        AppMethodBeat.i(64794);
        if (this.c && this.a != null) {
            this.a.setPluginsEnabled(z);
            AppMethodBeat.o(64794);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64794);
        } else {
            r.a(this.b, "setPluginsEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.o(64794);
        }
    }

    @Deprecated
    public synchronized void setPluginsPath(String str) {
        AppMethodBeat.i(64796);
        if (this.c && this.a != null) {
            this.a.setPluginsPath(str);
            AppMethodBeat.o(64796);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64796);
        } else {
            r.a(this.b, "setPluginsPath", new Class[]{String.class}, str);
            AppMethodBeat.o(64796);
        }
    }

    public void setRenderPriority(RenderPriority renderPriority) {
        AppMethodBeat.i(64820);
        if (this.c && this.a != null) {
            this.a.setRenderPriority(com.tencent.smtt.export.external.interfaces.IX5WebSettings.RenderPriority.valueOf(renderPriority.name()));
            AppMethodBeat.o(64820);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64820);
        } else {
            this.b.setRenderPriority(android.webkit.WebSettings.RenderPriority.valueOf(renderPriority.name()));
            AppMethodBeat.o(64820);
        }
    }

    public synchronized void setSansSerifFontFamily(String str) {
        AppMethodBeat.i(64769);
        if (this.c && this.a != null) {
            this.a.setSansSerifFontFamily(str);
            AppMethodBeat.o(64769);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64769);
        } else {
            this.b.setSansSerifFontFamily(str);
            AppMethodBeat.o(64769);
        }
    }

    public void setSaveFormData(boolean z) {
        AppMethodBeat.i(64744);
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setSaveFormData(z);
            }
            AppMethodBeat.o(64744);
            return;
        }
        this.a.setSaveFormData(z);
        AppMethodBeat.o(64744);
    }

    public void setSavePassword(boolean z) {
        AppMethodBeat.i(64746);
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setSavePassword(z);
            }
            AppMethodBeat.o(64746);
            return;
        }
        this.a.setSavePassword(z);
        AppMethodBeat.o(64746);
    }

    public synchronized void setSerifFontFamily(String str) {
        AppMethodBeat.i(64771);
        if (this.c && this.a != null) {
            this.a.setSerifFontFamily(str);
            AppMethodBeat.o(64771);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64771);
        } else {
            this.b.setSerifFontFamily(str);
            AppMethodBeat.o(64771);
        }
    }

    public synchronized void setStandardFontFamily(String str) {
        AppMethodBeat.i(64765);
        if (this.c && this.a != null) {
            this.a.setStandardFontFamily(str);
            AppMethodBeat.o(64765);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64765);
        } else {
            this.b.setStandardFontFamily(str);
            AppMethodBeat.o(64765);
        }
    }

    public void setSupportMultipleWindows(boolean z) {
        AppMethodBeat.i(64761);
        if (this.c && this.a != null) {
            this.a.setSupportMultipleWindows(z);
            AppMethodBeat.o(64761);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64761);
        } else {
            this.b.setSupportMultipleWindows(z);
            AppMethodBeat.o(64761);
        }
    }

    public void setSupportZoom(boolean z) {
        AppMethodBeat.i(64727);
        if (this.c && this.a != null) {
            this.a.setSupportZoom(z);
            AppMethodBeat.o(64727);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64727);
        } else {
            this.b.setSupportZoom(z);
            AppMethodBeat.o(64727);
        }
    }

    public void setTextSize(TextSize textSize) {
        AppMethodBeat.i(64750);
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setTextSize(android.webkit.WebSettings.TextSize.valueOf(textSize.name()));
            }
            AppMethodBeat.o(64750);
            return;
        }
        this.a.setTextSize(com.tencent.smtt.export.external.interfaces.IX5WebSettings.TextSize.valueOf(textSize.name()));
        AppMethodBeat.o(64750);
    }

    @TargetApi(14)
    public synchronized void setTextZoom(int i) {
        AppMethodBeat.i(64748);
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                if (VERSION.SDK_INT < 14) {
                    AppMethodBeat.o(64748);
                } else {
                    try {
                        this.b.setTextZoom(i);
                        AppMethodBeat.o(64748);
                    } catch (Exception e) {
                        r.a(this.b, "setTextZoom", new Class[]{Integer.TYPE}, Integer.valueOf(i));
                    }
                }
            }
            AppMethodBeat.o(64748);
        } else {
            this.a.setTextZoom(i);
            AppMethodBeat.o(64748);
        }
    }

    @Deprecated
    public void setUseWebViewBackgroundForOverscrollBackground(boolean z) {
        AppMethodBeat.i(64742);
        if (this.c && this.a != null) {
            this.a.setUseWebViewBackgroundForOverscrollBackground(z);
            AppMethodBeat.o(64742);
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64742);
        } else {
            r.a(this.b, "setUseWebViewBackgroundForOverscrollBackground", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.o(64742);
        }
    }

    public void setUseWideViewPort(boolean z) {
        AppMethodBeat.i(64759);
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setUseWideViewPort(z);
            }
            AppMethodBeat.o(64759);
            return;
        }
        this.a.setUseWideViewPort(z);
        AppMethodBeat.o(64759);
    }

    public void setUserAgent(String str) {
        AppMethodBeat.i(64756);
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setUserAgentString(str);
            }
            AppMethodBeat.o(64756);
            return;
        }
        this.a.setUserAgent(str);
        AppMethodBeat.o(64756);
    }

    @TargetApi(3)
    public void setUserAgentString(String str) {
        AppMethodBeat.i(64758);
        if (!this.c || this.a == null) {
            if (!(this.c || this.b == null)) {
                this.b.setUserAgentString(str);
            }
            AppMethodBeat.o(64758);
            return;
        }
        this.a.setUserAgentString(str);
        AppMethodBeat.o(64758);
    }

    public synchronized boolean supportMultipleWindows() {
        boolean supportMultipleWindows;
        AppMethodBeat.i(64762);
        if (this.c && this.a != null) {
            supportMultipleWindows = this.a.supportMultipleWindows();
            AppMethodBeat.o(64762);
        } else if (this.c || this.b == null) {
            supportMultipleWindows = false;
            AppMethodBeat.o(64762);
        } else {
            supportMultipleWindows = this.b.supportMultipleWindows();
            AppMethodBeat.o(64762);
        }
        return supportMultipleWindows;
    }

    public boolean supportZoom() {
        AppMethodBeat.i(64728);
        boolean supportZoom;
        if (this.c && this.a != null) {
            supportZoom = this.a.supportZoom();
            AppMethodBeat.o(64728);
            return supportZoom;
        } else if (this.c || this.b == null) {
            AppMethodBeat.o(64728);
            return false;
        } else {
            supportZoom = this.b.supportZoom();
            AppMethodBeat.o(64728);
            return supportZoom;
        }
    }
}
