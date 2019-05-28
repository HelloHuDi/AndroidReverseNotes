package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkSettings {
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NO_CACHE = 2;
    private ReflectMethod SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod = new ReflectMethod(null, "SetJSExceptionCallBack", new Class[0]);
    private ReflectMethod SetLogCallBackXWalkLogMessageListenerInternalMethod = new ReflectMethod(null, "SetLogCallBack", new Class[0]);
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod enumLayoutAlgorithmClassValueOfMethod = new ReflectMethod();
    private ReflectMethod getAcceptLanguagesMethod = new ReflectMethod(null, "getAcceptLanguages", new Class[0]);
    private ReflectMethod getAllowContentAccessMethod = new ReflectMethod(null, "getAllowContentAccess", new Class[0]);
    private ReflectMethod getAllowFileAccessFromFileURLsMethod = new ReflectMethod(null, "getAllowFileAccessFromFileURLs", new Class[0]);
    private ReflectMethod getAllowFileAccessMethod = new ReflectMethod(null, "getAllowFileAccess", new Class[0]);
    private ReflectMethod getAllowUniversalAccessFromFileURLsMethod = new ReflectMethod(null, "getAllowUniversalAccessFromFileURLs", new Class[0]);
    private ReflectMethod getBlockNetworkImageMethod = new ReflectMethod(null, "getBlockNetworkImage", new Class[0]);
    private ReflectMethod getBlockNetworkLoadsMethod = new ReflectMethod(null, "getBlockNetworkLoads", new Class[0]);
    private ReflectMethod getBuiltInZoomControlsMethod = new ReflectMethod(null, "getBuiltInZoomControls", new Class[0]);
    private ReflectMethod getCacheModeMethod = new ReflectMethod(null, "getCacheMode", new Class[0]);
    private ReflectMethod getCursiveFontFamilyMethod = new ReflectMethod(null, "getCursiveFontFamily", new Class[0]);
    private ReflectMethod getDatabaseEnabledMethod = new ReflectMethod(null, "getDatabaseEnabled", new Class[0]);
    private ReflectMethod getDefaultFixedFontSizeMethod = new ReflectMethod(null, "getDefaultFixedFontSize", new Class[0]);
    private ReflectMethod getDefaultFontSizeMethod = new ReflectMethod(null, "getDefaultFontSize", new Class[0]);
    private ReflectMethod getDomStorageEnabledMethod = new ReflectMethod(null, "getDomStorageEnabled", new Class[0]);
    private ReflectMethod getFantasyFontFamilyMethod = new ReflectMethod(null, "getFantasyFontFamily", new Class[0]);
    private ReflectMethod getFixedFontFamilyMethod = new ReflectMethod(null, "getFixedFontFamily", new Class[0]);
    private ReflectMethod getJavaScriptCanOpenWindowsAutomaticallyMethod = new ReflectMethod(null, "getJavaScriptCanOpenWindowsAutomatically", new Class[0]);
    private ReflectMethod getJavaScriptEnabledMethod = new ReflectMethod(null, "getJavaScriptEnabled", new Class[0]);
    private ReflectMethod getLayoutAlgorithmMethod = new ReflectMethod(null, "getLayoutAlgorithm", new Class[0]);
    private ReflectMethod getLoadWithOverviewModeMethod = new ReflectMethod(null, "getLoadWithOverviewMode", new Class[0]);
    private ReflectMethod getLoadsImagesAutomaticallyMethod = new ReflectMethod(null, "getLoadsImagesAutomatically", new Class[0]);
    private ReflectMethod getMediaPlaybackRequiresUserGestureMethod = new ReflectMethod(null, "getMediaPlaybackRequiresUserGesture", new Class[0]);
    private ReflectMethod getMinimumFontSizeMethod = new ReflectMethod(null, "getMinimumFontSize", new Class[0]);
    private ReflectMethod getMinimumLogicalFontSizeMethod = new ReflectMethod(null, "getMinimumLogicalFontSize", new Class[0]);
    private ReflectMethod getSansSerifFontFamilyMethod = new ReflectMethod(null, "getSansSerifFontFamily", new Class[0]);
    private ReflectMethod getSaveFormDataMethod = new ReflectMethod(null, "getSaveFormData", new Class[0]);
    private ReflectMethod getSerifFontFamilyMethod = new ReflectMethod(null, "getSerifFontFamily", new Class[0]);
    private ReflectMethod getStandardFontFamilyMethod = new ReflectMethod(null, "getStandardFontFamily", new Class[0]);
    private ReflectMethod getSupportQuirksModeMethod = new ReflectMethod(null, "getSupportQuirksMode", new Class[0]);
    private ReflectMethod getSupportSpatialNavigationMethod = new ReflectMethod(null, "getSupportSpatialNavigation", new Class[0]);
    private ReflectMethod getTextZoomMethod = new ReflectMethod(null, "getTextZoom", new Class[0]);
    private ReflectMethod getUseWideViewPortMethod = new ReflectMethod(null, "getUseWideViewPort", new Class[0]);
    private ReflectMethod getUserAgentStringMethod = new ReflectMethod(null, "getUserAgentString", new Class[0]);
    private ReflectMethod getUsingForAppBrandMethod = new ReflectMethod(null, "getUsingForAppBrand", new Class[0]);
    private ReflectMethod postWrapperMethod;
    private ReflectMethod setAcceptLanguagesStringMethod = new ReflectMethod(null, "setAcceptLanguages", new Class[0]);
    private ReflectMethod setAllowContentAccessbooleanMethod = new ReflectMethod(null, "setAllowContentAccess", new Class[0]);
    private ReflectMethod setAllowFileAccessFromFileURLsbooleanMethod = new ReflectMethod(null, "setAllowFileAccessFromFileURLs", new Class[0]);
    private ReflectMethod setAllowFileAccessbooleanMethod = new ReflectMethod(null, "setAllowFileAccess", new Class[0]);
    private ReflectMethod setAllowUniversalAccessFromFileURLsbooleanMethod = new ReflectMethod(null, "setAllowUniversalAccessFromFileURLs", new Class[0]);
    private ReflectMethod setAppCacheEnabledbooleanMethod = new ReflectMethod(null, "setAppCacheEnabled", new Class[0]);
    private ReflectMethod setAppCachePathStringMethod = new ReflectMethod(null, "setAppCachePath", new Class[0]);
    private ReflectMethod setBlockNetworkImagebooleanMethod = new ReflectMethod(null, "setBlockNetworkImage", new Class[0]);
    private ReflectMethod setBlockNetworkLoadsbooleanMethod = new ReflectMethod(null, "setBlockNetworkLoads", new Class[0]);
    private ReflectMethod setBuiltInZoomControlsbooleanMethod = new ReflectMethod(null, "setBuiltInZoomControls", new Class[0]);
    private ReflectMethod setCacheModeintMethod = new ReflectMethod(null, "setCacheMode", new Class[0]);
    private ReflectMethod setCursiveFontFamilyStringMethod = new ReflectMethod(null, "setCursiveFontFamily", new Class[0]);
    private ReflectMethod setDatabaseEnabledbooleanMethod = new ReflectMethod(null, "setDatabaseEnabled", new Class[0]);
    private ReflectMethod setDefaultFixedFontSizeintMethod = new ReflectMethod(null, "setDefaultFixedFontSize", new Class[0]);
    private ReflectMethod setDefaultFontSizeintMethod = new ReflectMethod(null, "setDefaultFontSize", new Class[0]);
    private ReflectMethod setDomStorageEnabledbooleanMethod = new ReflectMethod(null, "setDomStorageEnabled", new Class[0]);
    private ReflectMethod setFantasyFontFamilyStringMethod = new ReflectMethod(null, "setFantasyFontFamily", new Class[0]);
    private ReflectMethod setFixedFontFamilyStringMethod = new ReflectMethod(null, "setFixedFontFamily", new Class[0]);
    private ReflectMethod setInitialPageScalefloatMethod = new ReflectMethod(null, "setInitialPageScale", new Class[0]);
    private ReflectMethod setJavaScriptCanOpenWindowsAutomaticallybooleanMethod = new ReflectMethod(null, "setJavaScriptCanOpenWindowsAutomatically", new Class[0]);
    private ReflectMethod setJavaScriptEnabledbooleanMethod = new ReflectMethod(null, "setJavaScriptEnabled", new Class[0]);
    private ReflectMethod setLayoutAlgorithmLayoutAlgorithmInternalMethod = new ReflectMethod(null, "setLayoutAlgorithm", new Class[0]);
    private ReflectMethod setLoadWithOverviewModebooleanMethod = new ReflectMethod(null, "setLoadWithOverviewMode", new Class[0]);
    private ReflectMethod setLoadsImagesAutomaticallybooleanMethod = new ReflectMethod(null, "setLoadsImagesAutomatically", new Class[0]);
    private ReflectMethod setMediaPlaybackRequiresUserGesturebooleanMethod = new ReflectMethod(null, "setMediaPlaybackRequiresUserGesture", new Class[0]);
    private ReflectMethod setMinimumFontSizeIntMethod = new ReflectMethod(null, "setMinimumFontSize", new Class[0]);
    private ReflectMethod setMinimumLogicalFontSizeIntMethod = new ReflectMethod(null, "setMinimumLogicalFontSize", new Class[0]);
    private ReflectMethod setSansSerifFontFamilyStringMethod = new ReflectMethod(null, "setSansSerifFontFamily", new Class[0]);
    private ReflectMethod setSaveFormDatabooleanMethod = new ReflectMethod(null, "setSaveFormData", new Class[0]);
    private ReflectMethod setSerifFontFamilyStringMethod = new ReflectMethod(null, "setSerifFontFamily", new Class[0]);
    private ReflectMethod setStandardFontFamilyStringMethod = new ReflectMethod(null, "setStandardFontFamily", new Class[0]);
    private ReflectMethod setSupportMultipleWindowsbooleanMethod = new ReflectMethod(null, "setSupportMultipleWindows", new Class[0]);
    private ReflectMethod setSupportQuirksModebooleanMethod = new ReflectMethod(null, "setSupportQuirksMode", new Class[0]);
    private ReflectMethod setSupportSpatialNavigationbooleanMethod = new ReflectMethod(null, "setSupportSpatialNavigation", new Class[0]);
    private ReflectMethod setSupportZoombooleanMethod = new ReflectMethod(null, "setSupportZoom", new Class[0]);
    private ReflectMethod setTextZoomintMethod = new ReflectMethod(null, "setTextZoom", new Class[0]);
    private ReflectMethod setUseWideViewPortbooleanMethod = new ReflectMethod(null, "setUseWideViewPort", new Class[0]);
    private ReflectMethod setUserAgentStringStringMethod = new ReflectMethod(null, "setUserAgentString", new Class[0]);
    private ReflectMethod setUsingForAppBrandMethod = new ReflectMethod(null, "setUsingForAppBrand", new Class[0]);
    private ReflectMethod supportMultipleWindowsMethod = new ReflectMethod(null, "supportMultipleWindows", new Class[0]);
    private ReflectMethod supportZoomMethod = new ReflectMethod(null, "supportZoom", new Class[0]);
    private ReflectMethod supportsMultiTouchZoomForTestMethod = new ReflectMethod(null, "supportsMultiTouchZoomForTest", new Class[0]);

    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS,
        TEXT_AUTOSIZING;

        static {
            AppMethodBeat.m2505o(85766);
        }
    }

    private Object ConvertLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        AppMethodBeat.m2504i(85767);
        Object invoke = this.enumLayoutAlgorithmClassValueOfMethod.invoke(layoutAlgorithm.toString());
        AppMethodBeat.m2505o(85767);
        return invoke;
    }

    /* Access modifiers changed, original: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkSettings(Object obj) {
        AppMethodBeat.m2504i(85768);
        this.bridge = obj;
        reflectionInit();
        AppMethodBeat.m2505o(85768);
    }

    public void setCacheMode(int i) {
        AppMethodBeat.m2504i(85769);
        try {
            this.setCacheModeintMethod.invoke(Integer.valueOf(i));
            AppMethodBeat.m2505o(85769);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85769);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85769);
        }
    }

    public int getCacheMode() {
        AppMethodBeat.m2504i(85770);
        try {
            int intValue = ((Integer) this.getCacheModeMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.m2505o(85770);
            return intValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85770);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85770);
            return 0;
        }
    }

    public void setBlockNetworkLoads(boolean z) {
        AppMethodBeat.m2504i(85771);
        try {
            this.setBlockNetworkLoadsbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85771);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85771);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85771);
        }
    }

    public boolean getBlockNetworkLoads() {
        AppMethodBeat.m2504i(85772);
        try {
            boolean booleanValue = ((Boolean) this.getBlockNetworkLoadsMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85772);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85772);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85772);
            return false;
        }
    }

    public void setAllowFileAccess(boolean z) {
        AppMethodBeat.m2504i(85773);
        try {
            this.setAllowFileAccessbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85773);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85773);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85773);
        }
    }

    public boolean getAllowFileAccess() {
        AppMethodBeat.m2504i(85774);
        try {
            boolean booleanValue = ((Boolean) this.getAllowFileAccessMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85774);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85774);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85774);
            return false;
        }
    }

    public void setAllowContentAccess(boolean z) {
        AppMethodBeat.m2504i(85775);
        try {
            this.setAllowContentAccessbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85775);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85775);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85775);
        }
    }

    public boolean getAllowContentAccess() {
        AppMethodBeat.m2504i(85776);
        try {
            boolean booleanValue = ((Boolean) this.getAllowContentAccessMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85776);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85776);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85776);
            return false;
        }
    }

    public void setJavaScriptEnabled(boolean z) {
        AppMethodBeat.m2504i(85777);
        try {
            this.setJavaScriptEnabledbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85777);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85777);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85777);
        }
    }

    public void setStandardFontFamily(String str) {
        AppMethodBeat.m2504i(85778);
        try {
            this.setStandardFontFamilyStringMethod.invoke(str);
            AppMethodBeat.m2505o(85778);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85778);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85778);
        }
    }

    public void setFixedFontFamily(String str) {
        AppMethodBeat.m2504i(85779);
        try {
            this.setFixedFontFamilyStringMethod.invoke(str);
            AppMethodBeat.m2505o(85779);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85779);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85779);
        }
    }

    public void setSansSerifFontFamily(String str) {
        AppMethodBeat.m2504i(85780);
        try {
            this.setSansSerifFontFamilyStringMethod.invoke(str);
            AppMethodBeat.m2505o(85780);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85780);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85780);
        }
    }

    public void setSerifFontFamily(String str) {
        AppMethodBeat.m2504i(85781);
        try {
            this.setSerifFontFamilyStringMethod.invoke(str);
            AppMethodBeat.m2505o(85781);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85781);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85781);
        }
    }

    public void setCursiveFontFamily(String str) {
        AppMethodBeat.m2504i(85782);
        try {
            this.setCursiveFontFamilyStringMethod.invoke(str);
            AppMethodBeat.m2505o(85782);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85782);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85782);
        }
    }

    public void setFantasyFontFamily(String str) {
        AppMethodBeat.m2504i(85783);
        try {
            this.setFantasyFontFamilyStringMethod.invoke(str);
            AppMethodBeat.m2505o(85783);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85783);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85783);
        }
    }

    public void setMinimumFontSize(int i) {
        AppMethodBeat.m2504i(85784);
        try {
            this.setMinimumFontSizeIntMethod.invoke(Integer.valueOf(i));
            AppMethodBeat.m2505o(85784);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85784);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85784);
        }
    }

    public void setMinimumLogicalFontSize(int i) {
        AppMethodBeat.m2504i(85785);
        try {
            this.setMinimumLogicalFontSizeIntMethod.invoke(Integer.valueOf(i));
            AppMethodBeat.m2505o(85785);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85785);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85785);
        }
    }

    public void setAllowUniversalAccessFromFileURLs(boolean z) {
        AppMethodBeat.m2504i(85786);
        try {
            this.setAllowUniversalAccessFromFileURLsbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85786);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85786);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85786);
        }
    }

    public void setAllowFileAccessFromFileURLs(boolean z) {
        AppMethodBeat.m2504i(85787);
        try {
            this.setAllowFileAccessFromFileURLsbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85787);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85787);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85787);
        }
    }

    public void setLoadsImagesAutomatically(boolean z) {
        AppMethodBeat.m2504i(85788);
        try {
            this.setLoadsImagesAutomaticallybooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85788);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85788);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85788);
        }
    }

    public boolean getLoadsImagesAutomatically() {
        AppMethodBeat.m2504i(85789);
        try {
            boolean booleanValue = ((Boolean) this.getLoadsImagesAutomaticallyMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85789);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85789);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85789);
            return false;
        }
    }

    public void setBlockNetworkImage(boolean z) {
        AppMethodBeat.m2504i(85790);
        try {
            this.setBlockNetworkImagebooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85790);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85790);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85790);
        }
    }

    public boolean getBlockNetworkImage() {
        AppMethodBeat.m2504i(85791);
        try {
            boolean booleanValue = ((Boolean) this.getBlockNetworkImageMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85791);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85791);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85791);
            return false;
        }
    }

    public boolean getJavaScriptEnabled() {
        AppMethodBeat.m2504i(85792);
        try {
            boolean booleanValue = ((Boolean) this.getJavaScriptEnabledMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85792);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85792);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85792);
            return false;
        }
    }

    public String getStandardFontFamily() {
        AppMethodBeat.m2504i(85793);
        String str;
        try {
            str = (String) this.getStandardFontFamilyMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85793);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85793);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            str = "";
            AppMethodBeat.m2505o(85793);
            return str;
        }
    }

    public String getFixedFontFamily() {
        AppMethodBeat.m2504i(85794);
        String str;
        try {
            str = (String) this.getFixedFontFamilyMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85794);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85794);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            str = "";
            AppMethodBeat.m2505o(85794);
            return str;
        }
    }

    public String getSansSerifFontFamily() {
        AppMethodBeat.m2504i(85795);
        String str;
        try {
            str = (String) this.getSansSerifFontFamilyMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85795);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85795);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            str = "";
            AppMethodBeat.m2505o(85795);
            return str;
        }
    }

    public String getSerifFontFamily() {
        AppMethodBeat.m2504i(85796);
        String str;
        try {
            str = (String) this.getSerifFontFamilyMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85796);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85796);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            str = "";
            AppMethodBeat.m2505o(85796);
            return str;
        }
    }

    public String getCursiveFontFamily() {
        AppMethodBeat.m2504i(85797);
        String str;
        try {
            str = (String) this.getCursiveFontFamilyMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85797);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85797);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            str = "";
            AppMethodBeat.m2505o(85797);
            return str;
        }
    }

    public String getFantasyFontFamily() {
        AppMethodBeat.m2504i(85798);
        String str;
        try {
            str = (String) this.getFantasyFontFamilyMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85798);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85798);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            str = "";
            AppMethodBeat.m2505o(85798);
            return str;
        }
    }

    public int getMinimumFontSize() {
        AppMethodBeat.m2504i(85799);
        try {
            int intValue = ((Integer) this.getMinimumFontSizeMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.m2505o(85799);
            return intValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85799);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85799);
            return 0;
        }
    }

    public int getMinimumLogicalFontSize() {
        AppMethodBeat.m2504i(85800);
        try {
            int intValue = ((Integer) this.getMinimumLogicalFontSizeMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.m2505o(85800);
            return intValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85800);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85800);
            return 0;
        }
    }

    public boolean getAllowUniversalAccessFromFileURLs() {
        AppMethodBeat.m2504i(85801);
        try {
            boolean booleanValue = ((Boolean) this.getAllowUniversalAccessFromFileURLsMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85801);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85801);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85801);
            return false;
        }
    }

    public boolean getAllowFileAccessFromFileURLs() {
        AppMethodBeat.m2504i(85802);
        try {
            boolean booleanValue = ((Boolean) this.getAllowFileAccessFromFileURLsMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85802);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85802);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85802);
            return false;
        }
    }

    public void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        AppMethodBeat.m2504i(85803);
        try {
            this.setJavaScriptCanOpenWindowsAutomaticallybooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85803);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85803);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85803);
        }
    }

    public boolean getJavaScriptCanOpenWindowsAutomatically() {
        AppMethodBeat.m2504i(85804);
        try {
            boolean booleanValue = ((Boolean) this.getJavaScriptCanOpenWindowsAutomaticallyMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85804);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85804);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85804);
            return false;
        }
    }

    public void setSupportMultipleWindows(boolean z) {
        AppMethodBeat.m2504i(85805);
        try {
            this.setSupportMultipleWindowsbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85805);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85805);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85805);
        }
    }

    public boolean supportMultipleWindows() {
        AppMethodBeat.m2504i(85806);
        try {
            boolean booleanValue = ((Boolean) this.supportMultipleWindowsMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85806);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85806);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85806);
            return false;
        }
    }

    public void setUseWideViewPort(boolean z) {
        AppMethodBeat.m2504i(85807);
        try {
            this.setUseWideViewPortbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85807);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85807);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85807);
        }
    }

    public boolean getUseWideViewPort() {
        AppMethodBeat.m2504i(85808);
        try {
            boolean booleanValue = ((Boolean) this.getUseWideViewPortMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85808);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85808);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85808);
            return false;
        }
    }

    public void setAppCacheEnabled(boolean z) {
        AppMethodBeat.m2504i(85809);
        try {
            this.setAppCacheEnabledbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85809);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85809);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85809);
        }
    }

    public void setAppCachePath(String str) {
        AppMethodBeat.m2504i(85810);
        try {
            this.setAppCachePathStringMethod.invoke(str);
            AppMethodBeat.m2505o(85810);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85810);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85810);
        }
    }

    public void setDomStorageEnabled(boolean z) {
        AppMethodBeat.m2504i(85811);
        try {
            this.setDomStorageEnabledbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85811);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85811);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85811);
        }
    }

    public boolean getDomStorageEnabled() {
        AppMethodBeat.m2504i(85812);
        try {
            boolean booleanValue = ((Boolean) this.getDomStorageEnabledMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85812);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85812);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85812);
            return false;
        }
    }

    public void setDatabaseEnabled(boolean z) {
        AppMethodBeat.m2504i(85813);
        try {
            this.setDatabaseEnabledbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85813);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85813);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85813);
        }
    }

    public boolean getDatabaseEnabled() {
        AppMethodBeat.m2504i(85814);
        try {
            boolean booleanValue = ((Boolean) this.getDatabaseEnabledMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85814);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85814);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85814);
            return false;
        }
    }

    public void setMediaPlaybackRequiresUserGesture(boolean z) {
        AppMethodBeat.m2504i(85815);
        try {
            this.setMediaPlaybackRequiresUserGesturebooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85815);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85815);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85815);
        }
    }

    public boolean getMediaPlaybackRequiresUserGesture() {
        AppMethodBeat.m2504i(85816);
        try {
            boolean booleanValue = ((Boolean) this.getMediaPlaybackRequiresUserGestureMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85816);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85816);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85816);
            return false;
        }
    }

    public void setUsingForAppBrand(int i) {
        AppMethodBeat.m2504i(85817);
        try {
            this.setUsingForAppBrandMethod.invoke(Integer.valueOf(i));
            AppMethodBeat.m2505o(85817);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85817);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85817);
        }
    }

    public int getUsingForAppBrand() {
        AppMethodBeat.m2504i(85818);
        try {
            int intValue = ((Integer) this.getUsingForAppBrandMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.m2505o(85818);
            return intValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85818);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85818);
            return 0;
        }
    }

    public void setUserAgentString(String str) {
        AppMethodBeat.m2504i(85819);
        try {
            this.setUserAgentStringStringMethod.invoke(str);
            AppMethodBeat.m2505o(85819);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85819);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85819);
        }
    }

    public String getUserAgentString() {
        AppMethodBeat.m2504i(85820);
        try {
            String str = (String) this.getUserAgentStringMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85820);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85820);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85820);
            return null;
        }
    }

    public void setAcceptLanguages(String str) {
        AppMethodBeat.m2504i(85821);
        try {
            this.setAcceptLanguagesStringMethod.invoke(str);
            AppMethodBeat.m2505o(85821);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85821);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85821);
        }
    }

    public String getAcceptLanguages() {
        AppMethodBeat.m2504i(85822);
        try {
            String str = (String) this.getAcceptLanguagesMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85822);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85822);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85822);
            return null;
        }
    }

    public void setSaveFormData(boolean z) {
        AppMethodBeat.m2504i(85823);
        try {
            this.setSaveFormDatabooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85823);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85823);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85823);
        }
    }

    public boolean getSaveFormData() {
        AppMethodBeat.m2504i(85824);
        try {
            boolean booleanValue = ((Boolean) this.getSaveFormDataMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85824);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85824);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85824);
            return false;
        }
    }

    public void setInitialPageScale(float f) {
        AppMethodBeat.m2504i(85825);
        try {
            this.setInitialPageScalefloatMethod.invoke(Float.valueOf(f));
            AppMethodBeat.m2505o(85825);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85825);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85825);
        }
    }

    public void setTextZoom(int i) {
        AppMethodBeat.m2504i(85826);
        try {
            this.setTextZoomintMethod.invoke(Integer.valueOf(i));
            AppMethodBeat.m2505o(85826);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85826);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85826);
        }
    }

    public int getTextZoom() {
        AppMethodBeat.m2504i(85827);
        try {
            int intValue = ((Integer) this.getTextZoomMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.m2505o(85827);
            return intValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85827);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85827);
            return 0;
        }
    }

    public void setDefaultFontSize(int i) {
        AppMethodBeat.m2504i(85828);
        try {
            this.setDefaultFontSizeintMethod.invoke(Integer.valueOf(i));
            AppMethodBeat.m2505o(85828);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85828);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85828);
        }
    }

    public int getDefaultFontSize() {
        AppMethodBeat.m2504i(85829);
        try {
            int intValue = ((Integer) this.getDefaultFontSizeMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.m2505o(85829);
            return intValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85829);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85829);
            return 0;
        }
    }

    public void setDefaultFixedFontSize(int i) {
        AppMethodBeat.m2504i(85830);
        try {
            this.setDefaultFixedFontSizeintMethod.invoke(Integer.valueOf(i));
            AppMethodBeat.m2505o(85830);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85830);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85830);
        }
    }

    public int getDefaultFixedFontSize() {
        AppMethodBeat.m2504i(85831);
        try {
            int intValue = ((Integer) this.getDefaultFixedFontSizeMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.m2505o(85831);
            return intValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85831);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85831);
            return 0;
        }
    }

    public void setSupportZoom(boolean z) {
        AppMethodBeat.m2504i(85832);
        try {
            this.setSupportZoombooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85832);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85832);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85832);
        }
    }

    public boolean supportZoom() {
        AppMethodBeat.m2504i(85833);
        try {
            boolean booleanValue = ((Boolean) this.supportZoomMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85833);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85833);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85833);
            return false;
        }
    }

    public void setBuiltInZoomControls(boolean z) {
        AppMethodBeat.m2504i(85834);
        try {
            this.setBuiltInZoomControlsbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85834);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85834);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85834);
        }
    }

    public boolean getBuiltInZoomControls() {
        AppMethodBeat.m2504i(85835);
        try {
            boolean booleanValue = ((Boolean) this.getBuiltInZoomControlsMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85835);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85835);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85835);
            return false;
        }
    }

    public boolean supportsMultiTouchZoomForTest() {
        AppMethodBeat.m2504i(85836);
        try {
            boolean booleanValue = ((Boolean) this.supportsMultiTouchZoomForTestMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85836);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85836);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85836);
            return false;
        }
    }

    public void setSupportSpatialNavigation(boolean z) {
        AppMethodBeat.m2504i(85837);
        try {
            this.setSupportSpatialNavigationbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85837);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85837);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85837);
        }
    }

    public boolean getSupportSpatialNavigation() {
        AppMethodBeat.m2504i(85838);
        try {
            boolean booleanValue = ((Boolean) this.getSupportSpatialNavigationMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85838);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85838);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85838);
            return false;
        }
    }

    public void setSupportQuirksMode(boolean z) {
        AppMethodBeat.m2504i(85839);
        try {
            this.setSupportQuirksModebooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85839);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85839);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85839);
        }
    }

    public boolean getSupportQuirksMode() {
        AppMethodBeat.m2504i(85840);
        try {
            boolean booleanValue = ((Boolean) this.getSupportQuirksModeMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85840);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85840);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85840);
            return false;
        }
    }

    public void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        AppMethodBeat.m2504i(85841);
        try {
            this.setLayoutAlgorithmLayoutAlgorithmInternalMethod.invoke(ConvertLayoutAlgorithm(layoutAlgorithm));
            AppMethodBeat.m2505o(85841);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85841);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85841);
        }
    }

    public LayoutAlgorithm getLayoutAlgorithm() {
        AppMethodBeat.m2504i(85842);
        try {
            LayoutAlgorithm valueOf = LayoutAlgorithm.valueOf(this.getLayoutAlgorithmMethod.invoke(new Object[0]).toString());
            AppMethodBeat.m2505o(85842);
            return valueOf;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85842);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85842);
            return null;
        }
    }

    public void setLoadWithOverviewMode(boolean z) {
        AppMethodBeat.m2504i(85843);
        try {
            this.setLoadWithOverviewModebooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85843);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85843);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85843);
        }
    }

    public boolean getLoadWithOverviewMode() {
        AppMethodBeat.m2504i(85844);
        try {
            boolean booleanValue = ((Boolean) this.getLoadWithOverviewModeMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85844);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85844);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85844);
            return false;
        }
    }

    public void SetLogCallBack(XWalkLogMessageListener xWalkLogMessageListener) {
        AppMethodBeat.m2504i(85845);
        try {
            this.SetLogCallBackXWalkLogMessageListenerInternalMethod.invoke(xWalkLogMessageListener.getBridge());
            AppMethodBeat.m2505o(85845);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                this.SetLogCallBackXWalkLogMessageListenerInternalMethod.setArguments(new ReflectMethod((Object) xWalkLogMessageListener, "getBridge", new Class[0]));
                XWalkCoreWrapper.reserveReflectMethod(this.SetLogCallBackXWalkLogMessageListenerInternalMethod);
                AppMethodBeat.m2505o(85845);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85845);
        }
    }

    public void SetJSExceptionCallBack(XWalkJSExceptionListener xWalkJSExceptionListener) {
        AppMethodBeat.m2504i(85846);
        try {
            this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod.invoke(xWalkJSExceptionListener.getBridge());
            AppMethodBeat.m2505o(85846);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod.setArguments(new ReflectMethod((Object) xWalkJSExceptionListener, "getBridge", new Class[0]));
                XWalkCoreWrapper.reserveReflectMethod(this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod);
                AppMethodBeat.m2505o(85846);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85846);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void reflectionInit() {
        AppMethodBeat.m2504i(85847);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.m2505o(85847);
            return;
        }
        this.enumLayoutAlgorithmClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkSettingsInternal$LayoutAlgorithmInternal"), "valueOf", String.class);
        this.setCacheModeintMethod.init(this.bridge, null, "setCacheModeSuper", Integer.TYPE);
        this.getCacheModeMethod.init(this.bridge, null, "getCacheModeSuper", new Class[0]);
        this.setBlockNetworkLoadsbooleanMethod.init(this.bridge, null, "setBlockNetworkLoadsSuper", Boolean.TYPE);
        this.getBlockNetworkLoadsMethod.init(this.bridge, null, "getBlockNetworkLoadsSuper", new Class[0]);
        this.setAllowFileAccessbooleanMethod.init(this.bridge, null, "setAllowFileAccessSuper", Boolean.TYPE);
        this.getAllowFileAccessMethod.init(this.bridge, null, "getAllowFileAccessSuper", new Class[0]);
        this.setAllowContentAccessbooleanMethod.init(this.bridge, null, "setAllowContentAccessSuper", Boolean.TYPE);
        this.getAllowContentAccessMethod.init(this.bridge, null, "getAllowContentAccessSuper", new Class[0]);
        this.setJavaScriptEnabledbooleanMethod.init(this.bridge, null, "setJavaScriptEnabledSuper", Boolean.TYPE);
        this.setAllowUniversalAccessFromFileURLsbooleanMethod.init(this.bridge, null, "setAllowUniversalAccessFromFileURLsSuper", Boolean.TYPE);
        this.setAllowFileAccessFromFileURLsbooleanMethod.init(this.bridge, null, "setAllowFileAccessFromFileURLsSuper", Boolean.TYPE);
        this.setLoadsImagesAutomaticallybooleanMethod.init(this.bridge, null, "setLoadsImagesAutomaticallySuper", Boolean.TYPE);
        this.getLoadsImagesAutomaticallyMethod.init(this.bridge, null, "getLoadsImagesAutomaticallySuper", new Class[0]);
        this.setBlockNetworkImagebooleanMethod.init(this.bridge, null, "setBlockNetworkImageSuper", Boolean.TYPE);
        this.getBlockNetworkImageMethod.init(this.bridge, null, "getBlockNetworkImageSuper", new Class[0]);
        this.getJavaScriptEnabledMethod.init(this.bridge, null, "getJavaScriptEnabledSuper", new Class[0]);
        this.getAllowUniversalAccessFromFileURLsMethod.init(this.bridge, null, "getAllowUniversalAccessFromFileURLsSuper", new Class[0]);
        this.getAllowFileAccessFromFileURLsMethod.init(this.bridge, null, "getAllowFileAccessFromFileURLsSuper", new Class[0]);
        this.setJavaScriptCanOpenWindowsAutomaticallybooleanMethod.init(this.bridge, null, "setJavaScriptCanOpenWindowsAutomaticallySuper", Boolean.TYPE);
        this.getJavaScriptCanOpenWindowsAutomaticallyMethod.init(this.bridge, null, "getJavaScriptCanOpenWindowsAutomaticallySuper", new Class[0]);
        this.setSupportMultipleWindowsbooleanMethod.init(this.bridge, null, "setSupportMultipleWindowsSuper", Boolean.TYPE);
        this.supportMultipleWindowsMethod.init(this.bridge, null, "supportMultipleWindowsSuper", new Class[0]);
        this.setUseWideViewPortbooleanMethod.init(this.bridge, null, "setUseWideViewPortSuper", Boolean.TYPE);
        this.getUseWideViewPortMethod.init(this.bridge, null, "getUseWideViewPortSuper", new Class[0]);
        this.setAppCacheEnabledbooleanMethod.init(this.bridge, null, "setAppCacheEnabledSuper", Boolean.TYPE);
        this.setAppCachePathStringMethod.init(this.bridge, null, "setAppCachePathSuper", String.class);
        this.setDomStorageEnabledbooleanMethod.init(this.bridge, null, "setDomStorageEnabledSuper", Boolean.TYPE);
        this.getDomStorageEnabledMethod.init(this.bridge, null, "getDomStorageEnabledSuper", new Class[0]);
        this.setDatabaseEnabledbooleanMethod.init(this.bridge, null, "setDatabaseEnabledSuper", Boolean.TYPE);
        this.getDatabaseEnabledMethod.init(this.bridge, null, "getDatabaseEnabledSuper", new Class[0]);
        this.setMediaPlaybackRequiresUserGesturebooleanMethod.init(this.bridge, null, "setMediaPlaybackRequiresUserGestureSuper", Boolean.TYPE);
        this.getMediaPlaybackRequiresUserGestureMethod.init(this.bridge, null, "getMediaPlaybackRequiresUserGestureSuper", new Class[0]);
        this.setUsingForAppBrandMethod.init(this.bridge, null, "setUsingForAppBrandSuper", Integer.TYPE);
        this.getUsingForAppBrandMethod.init(this.bridge, null, "getUsingForAppBrandSuper", new Class[0]);
        this.setUserAgentStringStringMethod.init(this.bridge, null, "setUserAgentStringSuper", String.class);
        this.getUserAgentStringMethod.init(this.bridge, null, "getUserAgentStringSuper", new Class[0]);
        this.setAcceptLanguagesStringMethod.init(this.bridge, null, "setAcceptLanguagesSuper", String.class);
        this.getAcceptLanguagesMethod.init(this.bridge, null, "getAcceptLanguagesSuper", new Class[0]);
        this.setSaveFormDatabooleanMethod.init(this.bridge, null, "setSaveFormDataSuper", Boolean.TYPE);
        this.getSaveFormDataMethod.init(this.bridge, null, "getSaveFormDataSuper", new Class[0]);
        this.setInitialPageScalefloatMethod.init(this.bridge, null, "setInitialPageScaleSuper", Float.TYPE);
        this.setTextZoomintMethod.init(this.bridge, null, "setTextZoomSuper", Integer.TYPE);
        this.getTextZoomMethod.init(this.bridge, null, "getTextZoomSuper", new Class[0]);
        this.setDefaultFontSizeintMethod.init(this.bridge, null, "setDefaultFontSizeSuper", Integer.TYPE);
        this.getDefaultFontSizeMethod.init(this.bridge, null, "getDefaultFontSizeSuper", new Class[0]);
        this.setDefaultFixedFontSizeintMethod.init(this.bridge, null, "setDefaultFixedFontSizeSuper", Integer.TYPE);
        this.getDefaultFixedFontSizeMethod.init(this.bridge, null, "getDefaultFixedFontSizeSuper", new Class[0]);
        this.setSupportZoombooleanMethod.init(this.bridge, null, "setSupportZoomSuper", Boolean.TYPE);
        this.supportZoomMethod.init(this.bridge, null, "supportZoomSuper", new Class[0]);
        this.setBuiltInZoomControlsbooleanMethod.init(this.bridge, null, "setBuiltInZoomControlsSuper", Boolean.TYPE);
        this.getBuiltInZoomControlsMethod.init(this.bridge, null, "getBuiltInZoomControlsSuper", new Class[0]);
        this.supportsMultiTouchZoomForTestMethod.init(this.bridge, null, "supportsMultiTouchZoomForTestSuper", new Class[0]);
        this.setSupportSpatialNavigationbooleanMethod.init(this.bridge, null, "setSupportSpatialNavigationSuper", Boolean.TYPE);
        this.getSupportSpatialNavigationMethod.init(this.bridge, null, "getSupportSpatialNavigationSuper", new Class[0]);
        this.setSupportQuirksModebooleanMethod.init(this.bridge, null, "setSupportQuirksModeSuper", Boolean.TYPE);
        this.getSupportQuirksModeMethod.init(this.bridge, null, "getSupportQuirksModeSuper", new Class[0]);
        this.setLayoutAlgorithmLayoutAlgorithmInternalMethod.init(this.bridge, null, "setLayoutAlgorithmSuper", this.coreWrapper.getBridgeClass("XWalkSettingsInternal$LayoutAlgorithmInternal"));
        this.getLayoutAlgorithmMethod.init(this.bridge, null, "getLayoutAlgorithmSuper", new Class[0]);
        this.setLoadWithOverviewModebooleanMethod.init(this.bridge, null, "setLoadWithOverviewModeSuper", Boolean.TYPE);
        this.getLoadWithOverviewModeMethod.init(this.bridge, null, "getLoadWithOverviewModeSuper", new Class[0]);
        this.SetLogCallBackXWalkLogMessageListenerInternalMethod.init(this.bridge, null, "SetLogCallBackSuper", this.coreWrapper.getBridgeClass("XWalkLogMessageListenerBridge"));
        this.setStandardFontFamilyStringMethod.init(this.bridge, null, "setStandardFontFamilySuper", String.class);
        this.setFixedFontFamilyStringMethod.init(this.bridge, null, "setFixedFontFamilySuper", String.class);
        this.setSansSerifFontFamilyStringMethod.init(this.bridge, null, "setSansSerifFontFamilySuper", String.class);
        this.setSerifFontFamilyStringMethod.init(this.bridge, null, "setSerifFontFamilySuper", String.class);
        this.setCursiveFontFamilyStringMethod.init(this.bridge, null, "setCursiveFontFamilySuper", String.class);
        this.setFantasyFontFamilyStringMethod.init(this.bridge, null, "setFantasyFontFamilySuper", String.class);
        this.setMinimumFontSizeIntMethod.init(this.bridge, null, "setMinimumFontSizeSuper", Integer.TYPE);
        this.setMinimumLogicalFontSizeIntMethod.init(this.bridge, null, "setMinimumLogicalFontSizeSuper", Integer.TYPE);
        this.getStandardFontFamilyMethod.init(this.bridge, null, "getStandardFontFamilySuper", new Class[0]);
        this.getFixedFontFamilyMethod.init(this.bridge, null, "getFixedFontFamilySuper", new Class[0]);
        this.getSansSerifFontFamilyMethod.init(this.bridge, null, "getSansSerifFontFamilySuper", new Class[0]);
        this.getSerifFontFamilyMethod.init(this.bridge, null, "getSerifFontFamilySuper", new Class[0]);
        this.getCursiveFontFamilyMethod.init(this.bridge, null, "getCursiveFontFamilySuper", new Class[0]);
        this.getFantasyFontFamilyMethod.init(this.bridge, null, "getFantasyFontFamilySuper", new Class[0]);
        this.getMinimumFontSizeMethod.init(this.bridge, null, "getMinimumFontSizeSuper", new Class[0]);
        this.getMinimumLogicalFontSizeMethod.init(this.bridge, null, "getMinimumLogicalFontSizeSuper", new Class[0]);
        this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod.init(this.bridge, null, "SetJSExceptionCallBackSuper", this.coreWrapper.getBridgeClass("XWalkJSExceptionListenerBridge"));
        AppMethodBeat.m2505o(85847);
    }
}
