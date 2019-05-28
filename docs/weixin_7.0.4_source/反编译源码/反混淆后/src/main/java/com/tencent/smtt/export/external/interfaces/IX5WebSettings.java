package com.tencent.smtt.export.external.interfaces;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface IX5WebSettings {
    public static final int DEFAULT_CACHE_CAPACITY = 15;
    public static final int LOAD_CACHE_AD = 100;
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;

    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS;

        static {
            AppMethodBeat.m2505o(63803);
        }
    }

    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW;

        static {
            AppMethodBeat.m2505o(63809);
        }
    }

    public enum PluginState {
        ON,
        ON_DEMAND,
        OFF;

        static {
            AppMethodBeat.m2505o(63806);
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
            AppMethodBeat.m2505o(63812);
        }

        private TextSize(int i) {
            this.value = i;
        }
    }

    public enum ZoomDensity {
        FAR(150),
        MEDIUM(100),
        CLOSE(75);
        
        int value;

        static {
            AppMethodBeat.m2505o(63815);
        }

        private ZoomDensity(int i) {
            this.value = i;
        }
    }

    boolean enableSmoothTransition();

    boolean getAllowContentAccess();

    boolean getAllowFileAccess();

    boolean getBlockNetworkImage();

    boolean getBlockNetworkLoads();

    boolean getBuiltInZoomControls();

    int getCacheMode();

    String getCursiveFontFamily();

    boolean getDatabaseEnabled();

    String getDatabasePath();

    int getDefaultFixedFontSize();

    int getDefaultFontSize();

    String getDefaultTextEncodingName();

    ZoomDensity getDefaultZoom();

    boolean getDisplayZoomControls();

    boolean getDomStorageEnabled();

    String getFantasyFontFamily();

    String getFixedFontFamily();

    boolean getJavaScriptCanOpenWindowsAutomatically();

    boolean getJavaScriptEnabled();

    LayoutAlgorithm getLayoutAlgorithm();

    boolean getLightTouchEnabled();

    boolean getLoadWithOverviewMode();

    boolean getLoadsImagesAutomatically();

    boolean getMediaPlaybackRequiresUserGesture();

    int getMinimumFontSize();

    int getMinimumLogicalFontSize();

    int getMixedContentMode();

    boolean getNavDump();

    PluginState getPluginState();

    boolean getPluginsEnabled();

    String getPluginsPath();

    String getSansSerifFontFamily();

    boolean getSaveFormData();

    boolean getSavePassword();

    String getSerifFontFamily();

    String getStandardFontFamily();

    TextSize getTextSize();

    int getTextZoom();

    boolean getUseWebViewBackgroundForOverscrollBackground();

    boolean getUseWideViewPort();

    String getUserAgent();

    String getUserAgentString();

    void setAllowContentAccess(boolean z);

    void setAllowFileAccess(boolean z);

    void setAllowFileAccessFromFileURLs(boolean z);

    void setAllowUniversalAccessFromFileURLs(boolean z);

    void setAppCacheEnabled(boolean z);

    void setAppCacheMaxSize(long j);

    void setAppCachePath(String str);

    void setBlockNetworkImage(boolean z);

    void setBlockNetworkLoads(boolean z);

    void setBuiltInZoomControls(boolean z);

    void setCacheMode(int i);

    void setCursiveFontFamily(String str);

    void setDatabaseEnabled(boolean z);

    void setDatabasePath(String str);

    void setDefaultDatabasePath(boolean z);

    void setDefaultFixedFontSize(int i);

    void setDefaultFontSize(int i);

    void setDefaultTextEncodingName(String str);

    void setDefaultZoom(ZoomDensity zoomDensity);

    void setDisplayZoomControls(boolean z);

    void setDomStorageEnabled(boolean z);

    void setEnableSmoothTransition(boolean z);

    void setFantasyFontFamily(String str);

    void setFixedFontFamily(String str);

    void setGeolocationDatabasePath(String str);

    void setGeolocationEnabled(boolean z);

    void setJavaScriptCanOpenWindowsAutomatically(boolean z);

    void setJavaScriptEnabled(boolean z);

    void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm);

    void setLightTouchEnabled(boolean z);

    void setLoadWithOverviewMode(boolean z);

    void setLoadsImagesAutomatically(boolean z);

    void setMediaPlaybackRequiresUserGesture(boolean z);

    void setMinimumFontSize(int i);

    void setMinimumLogicalFontSize(int i);

    void setNavDump(boolean z);

    void setNeedInitialFocus(boolean z);

    void setPluginEnabled(boolean z);

    void setPluginState(PluginState pluginState);

    void setPluginsEnabled(boolean z);

    void setPluginsPath(String str);

    void setRenderPriority(RenderPriority renderPriority);

    void setSansSerifFontFamily(String str);

    void setSaveFormData(boolean z);

    void setSavePassword(boolean z);

    void setSerifFontFamily(String str);

    void setStandardFontFamily(String str);

    void setSupportMultipleWindows(boolean z);

    void setSupportZoom(boolean z);

    void setTextSize(TextSize textSize);

    void setTextZoom(int i);

    void setUseWebViewBackgroundForOverscrollBackground(boolean z);

    void setUseWideViewPort(boolean z);

    void setUserAgent(String str);

    void setUserAgent(String str, boolean z);

    void setUserAgentString(String str);

    boolean supportMultipleWindows();

    boolean supportZoom();
}
