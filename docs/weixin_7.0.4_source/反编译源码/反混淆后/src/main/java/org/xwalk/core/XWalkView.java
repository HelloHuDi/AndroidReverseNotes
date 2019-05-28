package org.xwalk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.ValueCallback;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C38317l;
import java.util.ArrayList;
import java.util.Map;
import org.xwalk.core.extension.XWalkExternalExtensionManagerImpl;

public class XWalkView extends AbsoluteLayout {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkView.class.desiredAssertionStatus());
    private static final String ANIMATABLE = "animatable";
    public static final int RELOAD_IGNORE_CACHE = 1;
    public static final int RELOAD_NORMAL = 0;
    public static final String SURFACE_VIEW = "SurfaceView";
    public static final String TEXTURE_VIEW = "TextureView";
    private static final String XWALK_ATTRS_NAMESPACE = "http://schemas.android.com/apk/res-auto";
    private ReflectMethod addJavascriptInterfaceObjectStringMethod;
    private ReflectMethod adjustSelectPositionlongStringintintMethod;
    private Object bridge;
    private ReflectMethod canZoomInMethod;
    private ReflectMethod canZoomOutMethod;
    private ReflectMethod captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod;
    private ReflectMethod clearCacheForSingleFileStringMethod;
    private ReflectMethod clearCachebooleanMethod;
    private ReflectMethod clearClientCertPreferencesRunnableMethod;
    private ReflectMethod clearFormDataMethod;
    private ReflectMethod clearMatchesMethod;
    private ReflectMethod clearSslPreferencesMethod;
    private ReflectMethod computeHorizontalScrollOffsetMethod;
    private ReflectMethod computeHorizontalScrollRangeMethod;
    private ReflectMethod computeVerticalScrollExtentMethod;
    private ReflectMethod computeVerticalScrollOffsetMethod;
    private ReflectMethod computeVerticalScrollRangeMethod;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod evaluateJavascriptStringValueCallbackMethod;
    private ReflectMethod findAllAsyncStringMethod;
    private ReflectMethod findNextbooleanMethod;
    private ReflectMethod getAPIVersionMethod;
    private ReflectMethod getCertificateMethod;
    private ReflectMethod getCompositingSurfaceTypeMethod;
    private ReflectMethod getContentHeightMethod;
    private ReflectMethod getExtensionManagerMethod;
    private ReflectMethod getFaviconMethod;
    private ReflectMethod getHitTestResultMethod;
    private ReflectMethod getNavigationHistoryMethod;
    private ReflectMethod getOriginalUrlMethod;
    private ReflectMethod getRefererUrlMethod;
    private ReflectMethod getRemoteDebuggingUrlMethod;
    private ReflectMethod getScalenMethod;
    private ReflectMethod getSettingsMethod;
    private ReflectMethod getTitleMethod;
    private ReflectMethod getUrlMethod;
    private ReflectMethod getUserAgentStringMethod;
    private ReflectMethod getXWalkContentViewMethod;
    private ReflectMethod getXWalkVersionMethod;
    private ReflectMethod hasEnteredFullscreenMethod;
    private ReflectMethod isSupportExtendPluginForAppbrandMethod;
    private ReflectMethod leaveFullscreenMethod;
    private ReflectMethod loadAppFromManifestStringStringMethod;
    private ReflectMethod loadDataStringStringStringMethod;
    private ReflectMethod loadDataWithBaseURLStringStringStringStringStringMethod;
    private ReflectMethod loadStringStringMapMethod;
    private ReflectMethod loadStringStringMethod;
    private ReflectMethod loadUrlStringMapMethod;
    private ReflectMethod loadUrlStringMethod;
    private String mAnimatable;
    private OverScrolledListener mOverScrolledListener;
    private ScrollChangedListener mScrollChangedListener;
    private ReflectMethod onActivityResultintintIntentMethod;
    private ReflectMethod onCreateInputConnectionEditorInfoMethod;
    private ReflectMethod onDestroyMethod;
    private ReflectMethod onHideMethod;
    private ReflectMethod onNewIntentIntentMethod;
    private ReflectMethod onPauseMethod;
    private ReflectMethod onResumeMethod;
    private ReflectMethod onShowMethod;
    private ReflectMethod onTouchEventMotionEventMethod;
    private ReflectMethod pauseTimersMethod;
    private ReflectMethod postWrapperMethod;
    private ReflectMethod reloadintMethod;
    private ReflectMethod removeJavascriptInterfaceStringMethod;
    private ReflectMethod restoreStateBundleMethod;
    private ReflectMethod resumeTimersMethod;
    private ReflectMethod savePageMethod;
    private ReflectMethod saveStateBundleMethod;
    private ReflectMethod scrollByintintMethod;
    private ReflectMethod scrollTointintMethod;
    private ReflectMethod setAcceptLanguagesStringMethod;
    private ReflectMethod setBackgroundColorintMethod;
    private ReflectMethod setDownloadListenerXWalkDownloadListenerInternalMethod;
    private ReflectMethod setExtendCanvasClientXWalkExtendCanvasClientInternalMethod;
    private ReflectMethod setExtendPluginClientXWalkExtendPluginClientInternalMethod;
    private ReflectMethod setFindListenerXWalkFindListenerInternalMethod;
    private ReflectMethod setHorizontalScrollBarEnablebooleanMethod;
    private ReflectMethod setInitialScaleintMethod;
    private ReflectMethod setNetworkAvailablebooleanMethod;
    private ReflectMethod setOnTouchListenerOnTouchListenerMethod;
    private ReflectMethod setOriginAccessWhitelistStringStringArrayMethod;
    private ReflectMethod setProxyWebViewClientExtensionInternalMethod;
    private ReflectMethod setResourceClientXWalkResourceClientInternalMethod;
    private ReflectMethod setSurfaceViewVisibilityintMethod;
    private ReflectMethod setUIClientXWalkUIClientInternalMethod;
    private ReflectMethod setUserAgentStringStringMethod;
    private ReflectMethod setVerticalScrollBarEnablebooleanMethod;
    private ReflectMethod setXWalkViewInternalVisibilityintMethod;
    private ReflectMethod setZOrderOnTopbooleanMethod;
    private ReflectMethod startActivityForResultIntentintBundleMethod;
    private ReflectMethod stopLoadingMethod;
    private ReflectMethod zoomByfloatMethod;
    private ReflectMethod zoomInMethod;
    private ReflectMethod zoomOutMethod;

    public interface OverScrolledListener {
        void onOverScrolled(boolean z);
    }

    public interface ScrollChangedListener {
        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    static {
        AppMethodBeat.m2504i(86044);
        AppMethodBeat.m2505o(86044);
    }

    /* Access modifiers changed, original: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkView(Context context) {
        super(context, null);
        AppMethodBeat.m2504i(85939);
        this.isSupportExtendPluginForAppbrandMethod = new ReflectMethod(null, "isSupportExtendPluginForAppbrand", new Class[0]);
        this.getXWalkContentViewMethod = new ReflectMethod(null, "getXWalkContentView", new Class[0]);
        this.loadStringStringMethod = new ReflectMethod(null, "load", new Class[0]);
        this.loadStringStringMapMethod = new ReflectMethod(null, "load", new Class[0]);
        this.loadDataStringStringStringMethod = new ReflectMethod(null, "loadData", new Class[0]);
        this.loadDataWithBaseURLStringStringStringStringStringMethod = new ReflectMethod(null, "loadDataWithBaseURL", new Class[0]);
        this.loadUrlStringMethod = new ReflectMethod(null, "loadUrl", new Class[0]);
        this.loadUrlStringMapMethod = new ReflectMethod(null, "loadUrl", new Class[0]);
        this.loadAppFromManifestStringStringMethod = new ReflectMethod(null, "loadAppFromManifest", new Class[0]);
        this.reloadintMethod = new ReflectMethod(null, "reload", new Class[0]);
        this.stopLoadingMethod = new ReflectMethod(null, "stopLoading", new Class[0]);
        this.getRefererUrlMethod = new ReflectMethod(null, "getRefererUrl", new Class[0]);
        this.getUrlMethod = new ReflectMethod(null, "getUrl", new Class[0]);
        this.savePageMethod = new ReflectMethod(null, "savePage", new Class[0]);
        this.getHitTestResultMethod = new ReflectMethod(null, "getHitTestResult", new Class[0]);
        this.getContentHeightMethod = new ReflectMethod(null, "getContentHeight", new Class[0]);
        this.getTitleMethod = new ReflectMethod(null, "getTitle", new Class[0]);
        this.getOriginalUrlMethod = new ReflectMethod(null, "getOriginalUrl", new Class[0]);
        this.getNavigationHistoryMethod = new ReflectMethod(null, "getNavigationHistory", new Class[0]);
        this.addJavascriptInterfaceObjectStringMethod = new ReflectMethod(null, "addJavascriptInterface", new Class[0]);
        this.removeJavascriptInterfaceStringMethod = new ReflectMethod(null, "removeJavascriptInterface", new Class[0]);
        this.evaluateJavascriptStringValueCallbackMethod = new ReflectMethod(null, "evaluateJavascript", new Class[0]);
        this.clearCachebooleanMethod = new ReflectMethod(null, "clearCache", new Class[0]);
        this.clearCacheForSingleFileStringMethod = new ReflectMethod(null, "clearCacheForSingleFile", new Class[0]);
        this.hasEnteredFullscreenMethod = new ReflectMethod(null, "hasEnteredFullscreen", new Class[0]);
        this.leaveFullscreenMethod = new ReflectMethod(null, "leaveFullscreen", new Class[0]);
        this.pauseTimersMethod = new ReflectMethod(null, "pauseTimers", new Class[0]);
        this.resumeTimersMethod = new ReflectMethod(null, "resumeTimers", new Class[0]);
        this.onPauseMethod = new ReflectMethod(null, "onPause", new Class[0]);
        this.onResumeMethod = new ReflectMethod(null, "onResume", new Class[0]);
        this.onHideMethod = new ReflectMethod(null, "onHide", new Class[0]);
        this.onShowMethod = new ReflectMethod(null, "onShow", new Class[0]);
        this.onDestroyMethod = new ReflectMethod(null, "onDestroy", new Class[0]);
        this.startActivityForResultIntentintBundleMethod = new ReflectMethod(null, "startActivityForResult", new Class[0]);
        this.onActivityResultintintIntentMethod = new ReflectMethod(null, "onActivityResult", new Class[0]);
        this.onNewIntentIntentMethod = new ReflectMethod(null, "onNewIntent", new Class[0]);
        this.saveStateBundleMethod = new ReflectMethod(null, "saveState", new Class[0]);
        this.restoreStateBundleMethod = new ReflectMethod(null, "restoreState", new Class[0]);
        this.getAPIVersionMethod = new ReflectMethod(null, "getAPIVersion", new Class[0]);
        this.getXWalkVersionMethod = new ReflectMethod(null, "getXWalkVersion", new Class[0]);
        this.setUIClientXWalkUIClientInternalMethod = new ReflectMethod(null, "setUIClient", new Class[0]);
        this.setExtendPluginClientXWalkExtendPluginClientInternalMethod = new ReflectMethod(null, "setExtendPluginClient", new Class[0]);
        this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod = new ReflectMethod(null, "setExtendCanvasClient", new Class[0]);
        this.setResourceClientXWalkResourceClientInternalMethod = new ReflectMethod(null, "setResourceClient", new Class[0]);
        this.setProxyWebViewClientExtensionInternalMethod = new ReflectMethod(null, "setProxyWebViewClientExtension", new Class[0]);
        this.setBackgroundColorintMethod = new ReflectMethod(null, C38317l.NAME, new Class[0]);
        this.setOriginAccessWhitelistStringStringArrayMethod = new ReflectMethod(null, "setOriginAccessWhitelist", new Class[0]);
        this.setUserAgentStringStringMethod = new ReflectMethod(null, "setUserAgentString", new Class[0]);
        this.getUserAgentStringMethod = new ReflectMethod(null, "getUserAgentString", new Class[0]);
        this.setAcceptLanguagesStringMethod = new ReflectMethod(null, "setAcceptLanguages", new Class[0]);
        this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod = new ReflectMethod(null, "captureBitmapAsync", new Class[0]);
        this.getSettingsMethod = new ReflectMethod(null, "getSettings", new Class[0]);
        this.setNetworkAvailablebooleanMethod = new ReflectMethod(null, "setNetworkAvailable", new Class[0]);
        this.getRemoteDebuggingUrlMethod = new ReflectMethod(null, "getRemoteDebuggingUrl", new Class[0]);
        this.zoomInMethod = new ReflectMethod(null, "zoomIn", new Class[0]);
        this.getScalenMethod = new ReflectMethod(null, "getScale", new Class[0]);
        this.zoomOutMethod = new ReflectMethod(null, "zoomOut", new Class[0]);
        this.zoomByfloatMethod = new ReflectMethod(null, "zoomBy", new Class[0]);
        this.canZoomInMethod = new ReflectMethod(null, "canZoomIn", new Class[0]);
        this.canZoomOutMethod = new ReflectMethod(null, "canZoomOut", new Class[0]);
        this.onCreateInputConnectionEditorInfoMethod = new ReflectMethod(null, "onCreateInputConnection", new Class[0]);
        this.setInitialScaleintMethod = new ReflectMethod(null, "setInitialScale", new Class[0]);
        this.getFaviconMethod = new ReflectMethod(null, "getFavicon", new Class[0]);
        this.setZOrderOnTopbooleanMethod = new ReflectMethod(null, "setZOrderOnTop", new Class[0]);
        this.clearFormDataMethod = new ReflectMethod(null, "clearFormData", new Class[0]);
        this.setSurfaceViewVisibilityintMethod = new ReflectMethod(null, "setSurfaceViewVisibility", new Class[0]);
        this.setXWalkViewInternalVisibilityintMethod = new ReflectMethod(null, "setXWalkViewInternalVisibility", new Class[0]);
        this.setDownloadListenerXWalkDownloadListenerInternalMethod = new ReflectMethod(null, "setDownloadListener", new Class[0]);
        this.onTouchEventMotionEventMethod = new ReflectMethod(null, "onTouchEvent", new Class[0]);
        this.setOnTouchListenerOnTouchListenerMethod = new ReflectMethod(null, "setOnTouchListener", new Class[0]);
        this.scrollTointintMethod = new ReflectMethod(null, "scrollTo", new Class[0]);
        this.scrollByintintMethod = new ReflectMethod(null, "scrollBy", new Class[0]);
        this.computeHorizontalScrollRangeMethod = new ReflectMethod(null, "computeHorizontalScrollRange", new Class[0]);
        this.computeHorizontalScrollOffsetMethod = new ReflectMethod(null, "computeHorizontalScrollOffset", new Class[0]);
        this.computeVerticalScrollRangeMethod = new ReflectMethod(null, "computeVerticalScrollRange", new Class[0]);
        this.computeVerticalScrollOffsetMethod = new ReflectMethod(null, "computeVerticalScrollOffset", new Class[0]);
        this.computeVerticalScrollExtentMethod = new ReflectMethod(null, "computeVerticalScrollExtent", new Class[0]);
        this.getExtensionManagerMethod = new ReflectMethod(null, "getExtensionManager", new Class[0]);
        this.clearSslPreferencesMethod = new ReflectMethod(null, "clearSslPreferences", new Class[0]);
        this.clearClientCertPreferencesRunnableMethod = new ReflectMethod(null, "clearClientCertPreferences", new Class[0]);
        this.getCertificateMethod = new ReflectMethod(null, "getCertificate", new Class[0]);
        this.setFindListenerXWalkFindListenerInternalMethod = new ReflectMethod(null, "setFindListener", new Class[0]);
        this.findAllAsyncStringMethod = new ReflectMethod(null, "findAllAsync", new Class[0]);
        this.findNextbooleanMethod = new ReflectMethod(null, "findNext", new Class[0]);
        this.clearMatchesMethod = new ReflectMethod(null, "clearMatches", new Class[0]);
        this.getCompositingSurfaceTypeMethod = new ReflectMethod(null, "getCompositingSurfaceType", new Class[0]);
        this.adjustSelectPositionlongStringintintMethod = new ReflectMethod(null, "adjustSelectPosition", new Class[0]);
        this.setVerticalScrollBarEnablebooleanMethod = new ReflectMethod(null, "setVerticalScrollBarEnable", new Class[0]);
        this.setHorizontalScrollBarEnablebooleanMethod = new ReflectMethod(null, "setHorizontalScrollBarEnable", new Class[0]);
        SurfaceView surfaceView = new SurfaceView(context);
        surfaceView.setLayoutParams(new LayoutParams(0, 0));
        addView(surfaceView);
        this.constructorTypes = new ArrayList();
        this.constructorTypes.add(Context.class);
        this.constructorParams = new ArrayList();
        this.constructorParams.add(context);
        this.postWrapperMethod = new ReflectMethod((Object) this, "postXWalkViewInternalContextConstructor", new Class[0]);
        reflectionInit();
        AppMethodBeat.m2505o(85939);
    }

    public void postXWalkViewInternalContextConstructor() {
        AppMethodBeat.m2504i(85940);
        addView((FrameLayout) this.bridge, new FrameLayout.LayoutParams(-1, -1));
        removeViewAt(0);
        XWalkExternalExtensionManagerImpl xWalkExternalExtensionManagerImpl = new XWalkExternalExtensionManagerImpl(this);
        AppMethodBeat.m2505o(85940);
    }

    public XWalkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(85941);
        this.isSupportExtendPluginForAppbrandMethod = new ReflectMethod(null, "isSupportExtendPluginForAppbrand", new Class[0]);
        this.getXWalkContentViewMethod = new ReflectMethod(null, "getXWalkContentView", new Class[0]);
        this.loadStringStringMethod = new ReflectMethod(null, "load", new Class[0]);
        this.loadStringStringMapMethod = new ReflectMethod(null, "load", new Class[0]);
        this.loadDataStringStringStringMethod = new ReflectMethod(null, "loadData", new Class[0]);
        this.loadDataWithBaseURLStringStringStringStringStringMethod = new ReflectMethod(null, "loadDataWithBaseURL", new Class[0]);
        this.loadUrlStringMethod = new ReflectMethod(null, "loadUrl", new Class[0]);
        this.loadUrlStringMapMethod = new ReflectMethod(null, "loadUrl", new Class[0]);
        this.loadAppFromManifestStringStringMethod = new ReflectMethod(null, "loadAppFromManifest", new Class[0]);
        this.reloadintMethod = new ReflectMethod(null, "reload", new Class[0]);
        this.stopLoadingMethod = new ReflectMethod(null, "stopLoading", new Class[0]);
        this.getRefererUrlMethod = new ReflectMethod(null, "getRefererUrl", new Class[0]);
        this.getUrlMethod = new ReflectMethod(null, "getUrl", new Class[0]);
        this.savePageMethod = new ReflectMethod(null, "savePage", new Class[0]);
        this.getHitTestResultMethod = new ReflectMethod(null, "getHitTestResult", new Class[0]);
        this.getContentHeightMethod = new ReflectMethod(null, "getContentHeight", new Class[0]);
        this.getTitleMethod = new ReflectMethod(null, "getTitle", new Class[0]);
        this.getOriginalUrlMethod = new ReflectMethod(null, "getOriginalUrl", new Class[0]);
        this.getNavigationHistoryMethod = new ReflectMethod(null, "getNavigationHistory", new Class[0]);
        this.addJavascriptInterfaceObjectStringMethod = new ReflectMethod(null, "addJavascriptInterface", new Class[0]);
        this.removeJavascriptInterfaceStringMethod = new ReflectMethod(null, "removeJavascriptInterface", new Class[0]);
        this.evaluateJavascriptStringValueCallbackMethod = new ReflectMethod(null, "evaluateJavascript", new Class[0]);
        this.clearCachebooleanMethod = new ReflectMethod(null, "clearCache", new Class[0]);
        this.clearCacheForSingleFileStringMethod = new ReflectMethod(null, "clearCacheForSingleFile", new Class[0]);
        this.hasEnteredFullscreenMethod = new ReflectMethod(null, "hasEnteredFullscreen", new Class[0]);
        this.leaveFullscreenMethod = new ReflectMethod(null, "leaveFullscreen", new Class[0]);
        this.pauseTimersMethod = new ReflectMethod(null, "pauseTimers", new Class[0]);
        this.resumeTimersMethod = new ReflectMethod(null, "resumeTimers", new Class[0]);
        this.onPauseMethod = new ReflectMethod(null, "onPause", new Class[0]);
        this.onResumeMethod = new ReflectMethod(null, "onResume", new Class[0]);
        this.onHideMethod = new ReflectMethod(null, "onHide", new Class[0]);
        this.onShowMethod = new ReflectMethod(null, "onShow", new Class[0]);
        this.onDestroyMethod = new ReflectMethod(null, "onDestroy", new Class[0]);
        this.startActivityForResultIntentintBundleMethod = new ReflectMethod(null, "startActivityForResult", new Class[0]);
        this.onActivityResultintintIntentMethod = new ReflectMethod(null, "onActivityResult", new Class[0]);
        this.onNewIntentIntentMethod = new ReflectMethod(null, "onNewIntent", new Class[0]);
        this.saveStateBundleMethod = new ReflectMethod(null, "saveState", new Class[0]);
        this.restoreStateBundleMethod = new ReflectMethod(null, "restoreState", new Class[0]);
        this.getAPIVersionMethod = new ReflectMethod(null, "getAPIVersion", new Class[0]);
        this.getXWalkVersionMethod = new ReflectMethod(null, "getXWalkVersion", new Class[0]);
        this.setUIClientXWalkUIClientInternalMethod = new ReflectMethod(null, "setUIClient", new Class[0]);
        this.setExtendPluginClientXWalkExtendPluginClientInternalMethod = new ReflectMethod(null, "setExtendPluginClient", new Class[0]);
        this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod = new ReflectMethod(null, "setExtendCanvasClient", new Class[0]);
        this.setResourceClientXWalkResourceClientInternalMethod = new ReflectMethod(null, "setResourceClient", new Class[0]);
        this.setProxyWebViewClientExtensionInternalMethod = new ReflectMethod(null, "setProxyWebViewClientExtension", new Class[0]);
        this.setBackgroundColorintMethod = new ReflectMethod(null, C38317l.NAME, new Class[0]);
        this.setOriginAccessWhitelistStringStringArrayMethod = new ReflectMethod(null, "setOriginAccessWhitelist", new Class[0]);
        this.setUserAgentStringStringMethod = new ReflectMethod(null, "setUserAgentString", new Class[0]);
        this.getUserAgentStringMethod = new ReflectMethod(null, "getUserAgentString", new Class[0]);
        this.setAcceptLanguagesStringMethod = new ReflectMethod(null, "setAcceptLanguages", new Class[0]);
        this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod = new ReflectMethod(null, "captureBitmapAsync", new Class[0]);
        this.getSettingsMethod = new ReflectMethod(null, "getSettings", new Class[0]);
        this.setNetworkAvailablebooleanMethod = new ReflectMethod(null, "setNetworkAvailable", new Class[0]);
        this.getRemoteDebuggingUrlMethod = new ReflectMethod(null, "getRemoteDebuggingUrl", new Class[0]);
        this.zoomInMethod = new ReflectMethod(null, "zoomIn", new Class[0]);
        this.getScalenMethod = new ReflectMethod(null, "getScale", new Class[0]);
        this.zoomOutMethod = new ReflectMethod(null, "zoomOut", new Class[0]);
        this.zoomByfloatMethod = new ReflectMethod(null, "zoomBy", new Class[0]);
        this.canZoomInMethod = new ReflectMethod(null, "canZoomIn", new Class[0]);
        this.canZoomOutMethod = new ReflectMethod(null, "canZoomOut", new Class[0]);
        this.onCreateInputConnectionEditorInfoMethod = new ReflectMethod(null, "onCreateInputConnection", new Class[0]);
        this.setInitialScaleintMethod = new ReflectMethod(null, "setInitialScale", new Class[0]);
        this.getFaviconMethod = new ReflectMethod(null, "getFavicon", new Class[0]);
        this.setZOrderOnTopbooleanMethod = new ReflectMethod(null, "setZOrderOnTop", new Class[0]);
        this.clearFormDataMethod = new ReflectMethod(null, "clearFormData", new Class[0]);
        this.setSurfaceViewVisibilityintMethod = new ReflectMethod(null, "setSurfaceViewVisibility", new Class[0]);
        this.setXWalkViewInternalVisibilityintMethod = new ReflectMethod(null, "setXWalkViewInternalVisibility", new Class[0]);
        this.setDownloadListenerXWalkDownloadListenerInternalMethod = new ReflectMethod(null, "setDownloadListener", new Class[0]);
        this.onTouchEventMotionEventMethod = new ReflectMethod(null, "onTouchEvent", new Class[0]);
        this.setOnTouchListenerOnTouchListenerMethod = new ReflectMethod(null, "setOnTouchListener", new Class[0]);
        this.scrollTointintMethod = new ReflectMethod(null, "scrollTo", new Class[0]);
        this.scrollByintintMethod = new ReflectMethod(null, "scrollBy", new Class[0]);
        this.computeHorizontalScrollRangeMethod = new ReflectMethod(null, "computeHorizontalScrollRange", new Class[0]);
        this.computeHorizontalScrollOffsetMethod = new ReflectMethod(null, "computeHorizontalScrollOffset", new Class[0]);
        this.computeVerticalScrollRangeMethod = new ReflectMethod(null, "computeVerticalScrollRange", new Class[0]);
        this.computeVerticalScrollOffsetMethod = new ReflectMethod(null, "computeVerticalScrollOffset", new Class[0]);
        this.computeVerticalScrollExtentMethod = new ReflectMethod(null, "computeVerticalScrollExtent", new Class[0]);
        this.getExtensionManagerMethod = new ReflectMethod(null, "getExtensionManager", new Class[0]);
        this.clearSslPreferencesMethod = new ReflectMethod(null, "clearSslPreferences", new Class[0]);
        this.clearClientCertPreferencesRunnableMethod = new ReflectMethod(null, "clearClientCertPreferences", new Class[0]);
        this.getCertificateMethod = new ReflectMethod(null, "getCertificate", new Class[0]);
        this.setFindListenerXWalkFindListenerInternalMethod = new ReflectMethod(null, "setFindListener", new Class[0]);
        this.findAllAsyncStringMethod = new ReflectMethod(null, "findAllAsync", new Class[0]);
        this.findNextbooleanMethod = new ReflectMethod(null, "findNext", new Class[0]);
        this.clearMatchesMethod = new ReflectMethod(null, "clearMatches", new Class[0]);
        this.getCompositingSurfaceTypeMethod = new ReflectMethod(null, "getCompositingSurfaceType", new Class[0]);
        this.adjustSelectPositionlongStringintintMethod = new ReflectMethod(null, "adjustSelectPosition", new Class[0]);
        this.setVerticalScrollBarEnablebooleanMethod = new ReflectMethod(null, "setVerticalScrollBarEnable", new Class[0]);
        this.setHorizontalScrollBarEnablebooleanMethod = new ReflectMethod(null, "setHorizontalScrollBarEnable", new Class[0]);
        if (isInEditMode()) {
            AppMethodBeat.m2505o(85941);
            return;
        }
        if (attributeSet != null) {
            this.mAnimatable = attributeSet.getAttributeValue(XWALK_ATTRS_NAMESPACE, ANIMATABLE);
        }
        SurfaceView surfaceView = new SurfaceView(context);
        surfaceView.setLayoutParams(new LayoutParams(0, 0));
        addView(surfaceView);
        this.constructorTypes = new ArrayList();
        this.constructorTypes.add(Context.class);
        this.constructorTypes.add(AttributeSet.class);
        this.constructorParams = new ArrayList();
        this.constructorParams.add(context);
        this.constructorParams.add(attributeSet);
        this.postWrapperMethod = new ReflectMethod((Object) this, "postXWalkViewInternalContextAttributeSetConstructor", new Class[0]);
        reflectionInit();
        AppMethodBeat.m2505o(85941);
    }

    public void postXWalkViewInternalContextAttributeSetConstructor() {
        AppMethodBeat.m2504i(85942);
        addView((FrameLayout) this.bridge, new FrameLayout.LayoutParams(-1, -1));
        removeViewAt(0);
        XWalkExternalExtensionManagerImpl xWalkExternalExtensionManagerImpl = new XWalkExternalExtensionManagerImpl(this);
        AppMethodBeat.m2505o(85942);
    }

    @Deprecated
    public XWalkView(Context context, Activity activity) {
        super(context, null);
        AppMethodBeat.m2504i(85943);
        this.isSupportExtendPluginForAppbrandMethod = new ReflectMethod(null, "isSupportExtendPluginForAppbrand", new Class[0]);
        this.getXWalkContentViewMethod = new ReflectMethod(null, "getXWalkContentView", new Class[0]);
        this.loadStringStringMethod = new ReflectMethod(null, "load", new Class[0]);
        this.loadStringStringMapMethod = new ReflectMethod(null, "load", new Class[0]);
        this.loadDataStringStringStringMethod = new ReflectMethod(null, "loadData", new Class[0]);
        this.loadDataWithBaseURLStringStringStringStringStringMethod = new ReflectMethod(null, "loadDataWithBaseURL", new Class[0]);
        this.loadUrlStringMethod = new ReflectMethod(null, "loadUrl", new Class[0]);
        this.loadUrlStringMapMethod = new ReflectMethod(null, "loadUrl", new Class[0]);
        this.loadAppFromManifestStringStringMethod = new ReflectMethod(null, "loadAppFromManifest", new Class[0]);
        this.reloadintMethod = new ReflectMethod(null, "reload", new Class[0]);
        this.stopLoadingMethod = new ReflectMethod(null, "stopLoading", new Class[0]);
        this.getRefererUrlMethod = new ReflectMethod(null, "getRefererUrl", new Class[0]);
        this.getUrlMethod = new ReflectMethod(null, "getUrl", new Class[0]);
        this.savePageMethod = new ReflectMethod(null, "savePage", new Class[0]);
        this.getHitTestResultMethod = new ReflectMethod(null, "getHitTestResult", new Class[0]);
        this.getContentHeightMethod = new ReflectMethod(null, "getContentHeight", new Class[0]);
        this.getTitleMethod = new ReflectMethod(null, "getTitle", new Class[0]);
        this.getOriginalUrlMethod = new ReflectMethod(null, "getOriginalUrl", new Class[0]);
        this.getNavigationHistoryMethod = new ReflectMethod(null, "getNavigationHistory", new Class[0]);
        this.addJavascriptInterfaceObjectStringMethod = new ReflectMethod(null, "addJavascriptInterface", new Class[0]);
        this.removeJavascriptInterfaceStringMethod = new ReflectMethod(null, "removeJavascriptInterface", new Class[0]);
        this.evaluateJavascriptStringValueCallbackMethod = new ReflectMethod(null, "evaluateJavascript", new Class[0]);
        this.clearCachebooleanMethod = new ReflectMethod(null, "clearCache", new Class[0]);
        this.clearCacheForSingleFileStringMethod = new ReflectMethod(null, "clearCacheForSingleFile", new Class[0]);
        this.hasEnteredFullscreenMethod = new ReflectMethod(null, "hasEnteredFullscreen", new Class[0]);
        this.leaveFullscreenMethod = new ReflectMethod(null, "leaveFullscreen", new Class[0]);
        this.pauseTimersMethod = new ReflectMethod(null, "pauseTimers", new Class[0]);
        this.resumeTimersMethod = new ReflectMethod(null, "resumeTimers", new Class[0]);
        this.onPauseMethod = new ReflectMethod(null, "onPause", new Class[0]);
        this.onResumeMethod = new ReflectMethod(null, "onResume", new Class[0]);
        this.onHideMethod = new ReflectMethod(null, "onHide", new Class[0]);
        this.onShowMethod = new ReflectMethod(null, "onShow", new Class[0]);
        this.onDestroyMethod = new ReflectMethod(null, "onDestroy", new Class[0]);
        this.startActivityForResultIntentintBundleMethod = new ReflectMethod(null, "startActivityForResult", new Class[0]);
        this.onActivityResultintintIntentMethod = new ReflectMethod(null, "onActivityResult", new Class[0]);
        this.onNewIntentIntentMethod = new ReflectMethod(null, "onNewIntent", new Class[0]);
        this.saveStateBundleMethod = new ReflectMethod(null, "saveState", new Class[0]);
        this.restoreStateBundleMethod = new ReflectMethod(null, "restoreState", new Class[0]);
        this.getAPIVersionMethod = new ReflectMethod(null, "getAPIVersion", new Class[0]);
        this.getXWalkVersionMethod = new ReflectMethod(null, "getXWalkVersion", new Class[0]);
        this.setUIClientXWalkUIClientInternalMethod = new ReflectMethod(null, "setUIClient", new Class[0]);
        this.setExtendPluginClientXWalkExtendPluginClientInternalMethod = new ReflectMethod(null, "setExtendPluginClient", new Class[0]);
        this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod = new ReflectMethod(null, "setExtendCanvasClient", new Class[0]);
        this.setResourceClientXWalkResourceClientInternalMethod = new ReflectMethod(null, "setResourceClient", new Class[0]);
        this.setProxyWebViewClientExtensionInternalMethod = new ReflectMethod(null, "setProxyWebViewClientExtension", new Class[0]);
        this.setBackgroundColorintMethod = new ReflectMethod(null, C38317l.NAME, new Class[0]);
        this.setOriginAccessWhitelistStringStringArrayMethod = new ReflectMethod(null, "setOriginAccessWhitelist", new Class[0]);
        this.setUserAgentStringStringMethod = new ReflectMethod(null, "setUserAgentString", new Class[0]);
        this.getUserAgentStringMethod = new ReflectMethod(null, "getUserAgentString", new Class[0]);
        this.setAcceptLanguagesStringMethod = new ReflectMethod(null, "setAcceptLanguages", new Class[0]);
        this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod = new ReflectMethod(null, "captureBitmapAsync", new Class[0]);
        this.getSettingsMethod = new ReflectMethod(null, "getSettings", new Class[0]);
        this.setNetworkAvailablebooleanMethod = new ReflectMethod(null, "setNetworkAvailable", new Class[0]);
        this.getRemoteDebuggingUrlMethod = new ReflectMethod(null, "getRemoteDebuggingUrl", new Class[0]);
        this.zoomInMethod = new ReflectMethod(null, "zoomIn", new Class[0]);
        this.getScalenMethod = new ReflectMethod(null, "getScale", new Class[0]);
        this.zoomOutMethod = new ReflectMethod(null, "zoomOut", new Class[0]);
        this.zoomByfloatMethod = new ReflectMethod(null, "zoomBy", new Class[0]);
        this.canZoomInMethod = new ReflectMethod(null, "canZoomIn", new Class[0]);
        this.canZoomOutMethod = new ReflectMethod(null, "canZoomOut", new Class[0]);
        this.onCreateInputConnectionEditorInfoMethod = new ReflectMethod(null, "onCreateInputConnection", new Class[0]);
        this.setInitialScaleintMethod = new ReflectMethod(null, "setInitialScale", new Class[0]);
        this.getFaviconMethod = new ReflectMethod(null, "getFavicon", new Class[0]);
        this.setZOrderOnTopbooleanMethod = new ReflectMethod(null, "setZOrderOnTop", new Class[0]);
        this.clearFormDataMethod = new ReflectMethod(null, "clearFormData", new Class[0]);
        this.setSurfaceViewVisibilityintMethod = new ReflectMethod(null, "setSurfaceViewVisibility", new Class[0]);
        this.setXWalkViewInternalVisibilityintMethod = new ReflectMethod(null, "setXWalkViewInternalVisibility", new Class[0]);
        this.setDownloadListenerXWalkDownloadListenerInternalMethod = new ReflectMethod(null, "setDownloadListener", new Class[0]);
        this.onTouchEventMotionEventMethod = new ReflectMethod(null, "onTouchEvent", new Class[0]);
        this.setOnTouchListenerOnTouchListenerMethod = new ReflectMethod(null, "setOnTouchListener", new Class[0]);
        this.scrollTointintMethod = new ReflectMethod(null, "scrollTo", new Class[0]);
        this.scrollByintintMethod = new ReflectMethod(null, "scrollBy", new Class[0]);
        this.computeHorizontalScrollRangeMethod = new ReflectMethod(null, "computeHorizontalScrollRange", new Class[0]);
        this.computeHorizontalScrollOffsetMethod = new ReflectMethod(null, "computeHorizontalScrollOffset", new Class[0]);
        this.computeVerticalScrollRangeMethod = new ReflectMethod(null, "computeVerticalScrollRange", new Class[0]);
        this.computeVerticalScrollOffsetMethod = new ReflectMethod(null, "computeVerticalScrollOffset", new Class[0]);
        this.computeVerticalScrollExtentMethod = new ReflectMethod(null, "computeVerticalScrollExtent", new Class[0]);
        this.getExtensionManagerMethod = new ReflectMethod(null, "getExtensionManager", new Class[0]);
        this.clearSslPreferencesMethod = new ReflectMethod(null, "clearSslPreferences", new Class[0]);
        this.clearClientCertPreferencesRunnableMethod = new ReflectMethod(null, "clearClientCertPreferences", new Class[0]);
        this.getCertificateMethod = new ReflectMethod(null, "getCertificate", new Class[0]);
        this.setFindListenerXWalkFindListenerInternalMethod = new ReflectMethod(null, "setFindListener", new Class[0]);
        this.findAllAsyncStringMethod = new ReflectMethod(null, "findAllAsync", new Class[0]);
        this.findNextbooleanMethod = new ReflectMethod(null, "findNext", new Class[0]);
        this.clearMatchesMethod = new ReflectMethod(null, "clearMatches", new Class[0]);
        this.getCompositingSurfaceTypeMethod = new ReflectMethod(null, "getCompositingSurfaceType", new Class[0]);
        this.adjustSelectPositionlongStringintintMethod = new ReflectMethod(null, "adjustSelectPosition", new Class[0]);
        this.setVerticalScrollBarEnablebooleanMethod = new ReflectMethod(null, "setVerticalScrollBarEnable", new Class[0]);
        this.setHorizontalScrollBarEnablebooleanMethod = new ReflectMethod(null, "setHorizontalScrollBarEnable", new Class[0]);
        SurfaceView surfaceView = new SurfaceView(context);
        surfaceView.setLayoutParams(new LayoutParams(0, 0));
        addView(surfaceView);
        this.constructorTypes = new ArrayList();
        this.constructorTypes.add(Context.class);
        this.constructorTypes.add(Activity.class);
        this.constructorParams = new ArrayList();
        this.constructorParams.add(context);
        this.constructorParams.add(activity);
        this.postWrapperMethod = new ReflectMethod((Object) this, "postXWalkViewInternalContextActivityConstructor", new Class[0]);
        reflectionInit();
        AppMethodBeat.m2505o(85943);
    }

    public boolean isSupportExtendPluginForAppbrand() {
        AppMethodBeat.m2504i(85944);
        try {
            boolean booleanValue = ((Boolean) this.isSupportExtendPluginForAppbrandMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85944);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85944);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85944);
            return false;
        }
    }

    public ViewGroup getXWalkContentView() {
        AppMethodBeat.m2504i(85945);
        try {
            ViewGroup viewGroup = (ViewGroup) this.getXWalkContentViewMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85945);
            return viewGroup;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85945);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85945);
            return null;
        }
    }

    public void setFocusable(boolean z) {
        AppMethodBeat.m2504i(85946);
        if (z) {
            setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            super.setFocusable(false);
            AppMethodBeat.m2505o(85946);
            return;
        }
        setDescendantFocusability(393216);
        super.setFocusable(false);
        AppMethodBeat.m2505o(85946);
    }

    public void setFocusableInTouchMode(boolean z) {
        AppMethodBeat.m2504i(85947);
        if (z) {
            setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            super.setFocusableInTouchMode(false);
            AppMethodBeat.m2505o(85947);
            return;
        }
        setDescendantFocusability(393216);
        super.setFocusableInTouchMode(false);
        AppMethodBeat.m2505o(85947);
    }

    public void postXWalkViewInternalContextActivityConstructor() {
        AppMethodBeat.m2504i(85948);
        addView((FrameLayout) this.bridge, new FrameLayout.LayoutParams(-1, -1));
        removeViewAt(0);
        XWalkExternalExtensionManagerImpl xWalkExternalExtensionManagerImpl = new XWalkExternalExtensionManagerImpl(this);
        AppMethodBeat.m2505o(85948);
    }

    @Deprecated
    public void load(String str, String str2) {
        AppMethodBeat.m2504i(85949);
        try {
            this.loadStringStringMethod.invoke(str, str2);
            AppMethodBeat.m2505o(85949);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85949);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85949);
        }
    }

    @Deprecated
    public void load(String str, String str2, Map<String, String> map) {
        AppMethodBeat.m2504i(85950);
        try {
            this.loadStringStringMapMethod.invoke(str, str2, map);
            AppMethodBeat.m2505o(85950);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85950);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85950);
        }
    }

    public void loadData(String str, String str2, String str3) {
        AppMethodBeat.m2504i(85951);
        try {
            this.loadDataStringStringStringMethod.invoke(str, str2, str3);
            AppMethodBeat.m2505o(85951);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85951);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85951);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(85952);
        try {
            this.loadDataWithBaseURLStringStringStringStringStringMethod.invoke(str, str2, str3, str4, str5);
            AppMethodBeat.m2505o(85952);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85952);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85952);
        }
    }

    public void loadUrl(String str) {
        AppMethodBeat.m2504i(85953);
        try {
            this.loadUrlStringMethod.invoke(str);
            AppMethodBeat.m2505o(85953);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85953);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85953);
        }
    }

    public void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(85954);
        try {
            this.loadUrlStringMapMethod.invoke(str, map);
            AppMethodBeat.m2505o(85954);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85954);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85954);
        }
    }

    public void loadAppFromManifest(String str, String str2) {
        AppMethodBeat.m2504i(85955);
        try {
            this.loadAppFromManifestStringStringMethod.invoke(str, str2);
            AppMethodBeat.m2505o(85955);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85955);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85955);
        }
    }

    public void reload(int i) {
        AppMethodBeat.m2504i(85956);
        try {
            this.reloadintMethod.invoke(Integer.valueOf(i));
            AppMethodBeat.m2505o(85956);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85956);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85956);
        }
    }

    public void stopLoading() {
        AppMethodBeat.m2504i(85957);
        try {
            this.stopLoadingMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85957);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85957);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85957);
        }
    }

    public String getRefererUrl() {
        AppMethodBeat.m2504i(85958);
        try {
            String str = (String) this.getRefererUrlMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85958);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85958);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85958);
            return null;
        }
    }

    public String getUrl() {
        AppMethodBeat.m2504i(85959);
        try {
            String str = (String) this.getUrlMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85959);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85959);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85959);
            return null;
        }
    }

    public boolean savePage(String str, String str2, int i) {
        AppMethodBeat.m2504i(85960);
        try {
            boolean booleanValue = ((Boolean) this.savePageMethod.invoke(str, str2, Integer.valueOf(i))).booleanValue();
            AppMethodBeat.m2505o(85960);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85960);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85960);
            return false;
        }
    }

    public XWalkHitTestResult getHitTestResult() {
        AppMethodBeat.m2504i(85961);
        try {
            XWalkHitTestResult xWalkHitTestResult = (XWalkHitTestResult) this.coreWrapper.getWrapperObject(this.getHitTestResultMethod.invoke(new Object[0]));
            AppMethodBeat.m2505o(85961);
            return xWalkHitTestResult;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85961);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85961);
            return null;
        }
    }

    public int getContentHeight() {
        AppMethodBeat.m2504i(85962);
        try {
            int intValue = ((Integer) this.getContentHeightMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.m2505o(85962);
            return intValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85962);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85962);
            return 0;
        }
    }

    public String getTitle() {
        AppMethodBeat.m2504i(85963);
        try {
            String str = (String) this.getTitleMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85963);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85963);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85963);
            return null;
        }
    }

    public String getOriginalUrl() {
        AppMethodBeat.m2504i(85964);
        try {
            String str = (String) this.getOriginalUrlMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85964);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85964);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85964);
            return null;
        }
    }

    public XWalkNavigationHistory getNavigationHistory() {
        AppMethodBeat.m2504i(85965);
        try {
            XWalkNavigationHistory xWalkNavigationHistory = (XWalkNavigationHistory) this.coreWrapper.getWrapperObject(this.getNavigationHistoryMethod.invoke(new Object[0]));
            AppMethodBeat.m2505o(85965);
            return xWalkNavigationHistory;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85965);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85965);
            return null;
        }
    }

    public void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.m2504i(85966);
        try {
            this.addJavascriptInterfaceObjectStringMethod.invoke(obj, str);
            AppMethodBeat.m2505o(85966);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                this.addJavascriptInterfaceObjectStringMethod.setArguments(obj, str);
                XWalkCoreWrapper.reserveReflectMethod(this.addJavascriptInterfaceObjectStringMethod);
                AppMethodBeat.m2505o(85966);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85966);
        }
    }

    public void removeJavascriptInterface(String str) {
        AppMethodBeat.m2504i(85967);
        try {
            this.removeJavascriptInterfaceStringMethod.invoke(str);
            AppMethodBeat.m2505o(85967);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                this.removeJavascriptInterfaceStringMethod.setArguments(str);
                XWalkCoreWrapper.reserveReflectMethod(this.removeJavascriptInterfaceStringMethod);
                AppMethodBeat.m2505o(85967);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85967);
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(85968);
        try {
            this.evaluateJavascriptStringValueCallbackMethod.invoke(str, valueCallback);
            AppMethodBeat.m2505o(85968);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85968);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85968);
        }
    }

    public void clearCache(boolean z) {
        AppMethodBeat.m2504i(85969);
        try {
            this.clearCachebooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85969);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85969);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85969);
        }
    }

    public void clearCacheForSingleFile(String str) {
        AppMethodBeat.m2504i(85970);
        try {
            this.clearCacheForSingleFileStringMethod.invoke(str);
            AppMethodBeat.m2505o(85970);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85970);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85970);
        }
    }

    public boolean hasEnteredFullscreen() {
        AppMethodBeat.m2504i(85971);
        try {
            boolean booleanValue = ((Boolean) this.hasEnteredFullscreenMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85971);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85971);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85971);
            return false;
        }
    }

    public void leaveFullscreen() {
        AppMethodBeat.m2504i(85972);
        try {
            this.leaveFullscreenMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85972);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85972);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85972);
        }
    }

    public void pauseTimers() {
        AppMethodBeat.m2504i(85973);
        try {
            this.pauseTimersMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85973);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85973);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85973);
        }
    }

    public void resumeTimers() {
        AppMethodBeat.m2504i(85974);
        try {
            this.resumeTimersMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85974);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85974);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85974);
        }
    }

    public void onPause() {
        AppMethodBeat.m2504i(85975);
        if (XWalkCoreWrapper.getInstance().hasFeature(1)) {
            try {
                this.onPauseMethod.invoke(new Object[0]);
                AppMethodBeat.m2505o(85975);
                return;
            } catch (UnsupportedOperationException e) {
                if (this.coreWrapper == null) {
                    RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                    AppMethodBeat.m2505o(85975);
                    throw runtimeException;
                }
                XWalkCoreWrapper.handleRuntimeError(e);
                AppMethodBeat.m2505o(85975);
                return;
            }
        }
        AppMethodBeat.m2505o(85975);
    }

    public void onResume() {
        AppMethodBeat.m2504i(85976);
        if (XWalkCoreWrapper.getInstance().hasFeature(1)) {
            try {
                this.onResumeMethod.invoke(new Object[0]);
                AppMethodBeat.m2505o(85976);
                return;
            } catch (UnsupportedOperationException e) {
                if (this.coreWrapper == null) {
                    RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                    AppMethodBeat.m2505o(85976);
                    throw runtimeException;
                }
                XWalkCoreWrapper.handleRuntimeError(e);
                AppMethodBeat.m2505o(85976);
                return;
            }
        }
        AppMethodBeat.m2505o(85976);
    }

    public void onHide() {
        AppMethodBeat.m2504i(85977);
        try {
            this.onHideMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85977);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85977);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85977);
        }
    }

    public void onShow() {
        AppMethodBeat.m2504i(85978);
        try {
            this.onShowMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85978);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85978);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85978);
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(85979);
        try {
            this.onDestroyMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85979);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85979);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85979);
        }
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        AppMethodBeat.m2504i(85980);
        try {
            this.startActivityForResultIntentintBundleMethod.invoke(intent, Integer.valueOf(i), bundle);
            AppMethodBeat.m2505o(85980);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85980);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85980);
        }
    }

    @Deprecated
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(85981);
        try {
            this.onActivityResultintintIntentMethod.invoke(Integer.valueOf(i), Integer.valueOf(i2), intent);
            AppMethodBeat.m2505o(85981);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85981);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85981);
        }
    }

    public boolean onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(85982);
        try {
            boolean booleanValue = ((Boolean) this.onNewIntentIntentMethod.invoke(intent)).booleanValue();
            AppMethodBeat.m2505o(85982);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85982);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85982);
            return false;
        }
    }

    public boolean saveState(Bundle bundle) {
        AppMethodBeat.m2504i(85983);
        try {
            boolean booleanValue = ((Boolean) this.saveStateBundleMethod.invoke(bundle)).booleanValue();
            AppMethodBeat.m2505o(85983);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85983);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85983);
            return false;
        }
    }

    public boolean restoreState(Bundle bundle) {
        AppMethodBeat.m2504i(85984);
        try {
            boolean booleanValue = ((Boolean) this.restoreStateBundleMethod.invoke(bundle)).booleanValue();
            AppMethodBeat.m2505o(85984);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85984);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85984);
            return false;
        }
    }

    public String getAPIVersion() {
        AppMethodBeat.m2504i(85985);
        try {
            String str = (String) this.getAPIVersionMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85985);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85985);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85985);
            return null;
        }
    }

    public String getXWalkVersion() {
        AppMethodBeat.m2504i(85986);
        try {
            String str = (String) this.getXWalkVersionMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85986);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85986);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85986);
            return null;
        }
    }

    public void setUIClient(XWalkUIClient xWalkUIClient) {
        AppMethodBeat.m2504i(85987);
        try {
            this.setUIClientXWalkUIClientInternalMethod.invoke(xWalkUIClient.getBridge());
            AppMethodBeat.m2505o(85987);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                this.setUIClientXWalkUIClientInternalMethod.setArguments(new ReflectMethod((Object) xWalkUIClient, "getBridge", new Class[0]));
                XWalkCoreWrapper.reserveReflectMethod(this.setUIClientXWalkUIClientInternalMethod);
                AppMethodBeat.m2505o(85987);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85987);
        }
    }

    public void setExtendPluginClient(XWalkExtendPluginClient xWalkExtendPluginClient) {
        AppMethodBeat.m2504i(85988);
        try {
            this.setExtendPluginClientXWalkExtendPluginClientInternalMethod.invoke(xWalkExtendPluginClient.getBridge());
            AppMethodBeat.m2505o(85988);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                this.setExtendPluginClientXWalkExtendPluginClientInternalMethod.setArguments(new ReflectMethod((Object) xWalkExtendPluginClient, "getBridge", new Class[0]));
                XWalkCoreWrapper.reserveReflectMethod(this.setExtendPluginClientXWalkExtendPluginClientInternalMethod);
                AppMethodBeat.m2505o(85988);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85988);
        }
    }

    public void setExtendCanvasClient(XWalkExtendCanvasClient xWalkExtendCanvasClient) {
        AppMethodBeat.m2504i(85989);
        try {
            this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod.invoke(xWalkExtendCanvasClient.getBridge());
            AppMethodBeat.m2505o(85989);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod.setArguments(new ReflectMethod((Object) xWalkExtendCanvasClient, "getBridge", new Class[0]));
                XWalkCoreWrapper.reserveReflectMethod(this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod);
                AppMethodBeat.m2505o(85989);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85989);
        }
    }

    public void setResourceClient(XWalkResourceClient xWalkResourceClient) {
        AppMethodBeat.m2504i(85990);
        try {
            this.setResourceClientXWalkResourceClientInternalMethod.invoke(xWalkResourceClient.getBridge());
            AppMethodBeat.m2505o(85990);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                this.setResourceClientXWalkResourceClientInternalMethod.setArguments(new ReflectMethod((Object) xWalkResourceClient, "getBridge", new Class[0]));
                XWalkCoreWrapper.reserveReflectMethod(this.setResourceClientXWalkResourceClientInternalMethod);
                AppMethodBeat.m2505o(85990);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85990);
        }
    }

    public void setProxyWebViewClientExtension(XWalkProxyWebViewClientExtension xWalkProxyWebViewClientExtension) {
        AppMethodBeat.m2504i(85991);
        try {
            this.setProxyWebViewClientExtensionInternalMethod.invoke(xWalkProxyWebViewClientExtension.getBridge());
            AppMethodBeat.m2505o(85991);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                this.setProxyWebViewClientExtensionInternalMethod.setArguments(new ReflectMethod((Object) xWalkProxyWebViewClientExtension, "getBridge", new Class[0]));
                XWalkCoreWrapper.reserveReflectMethod(this.setProxyWebViewClientExtensionInternalMethod);
                AppMethodBeat.m2505o(85991);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85991);
        }
    }

    public void setBackgroundColor(int i) {
        AppMethodBeat.m2504i(85992);
        try {
            this.setBackgroundColorintMethod.invoke(Integer.valueOf(i));
            AppMethodBeat.m2505o(85992);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85992);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85992);
        }
    }

    public void setOriginAccessWhitelist(String str, String[] strArr) {
        AppMethodBeat.m2504i(85993);
        try {
            this.setOriginAccessWhitelistStringStringArrayMethod.invoke(str, strArr);
            AppMethodBeat.m2505o(85993);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85993);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85993);
        }
    }

    public void setLayerType(int i, Paint paint) {
    }

    public void setUserAgentString(String str) {
        AppMethodBeat.m2504i(85994);
        try {
            this.setUserAgentStringStringMethod.invoke(str);
            AppMethodBeat.m2505o(85994);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85994);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85994);
        }
    }

    public String getUserAgentString() {
        AppMethodBeat.m2504i(85995);
        try {
            String str = (String) this.getUserAgentStringMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85995);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85995);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85995);
            return null;
        }
    }

    public void setAcceptLanguages(String str) {
        AppMethodBeat.m2504i(85996);
        try {
            this.setAcceptLanguagesStringMethod.invoke(str);
            AppMethodBeat.m2505o(85996);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85996);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85996);
        }
    }

    public void captureBitmapAsync(XWalkGetBitmapCallback xWalkGetBitmapCallback) {
        AppMethodBeat.m2504i(85997);
        try {
            this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod.invoke(xWalkGetBitmapCallback.getBridge());
            AppMethodBeat.m2505o(85997);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85997);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85997);
        }
    }

    public XWalkSettings getSettings() {
        AppMethodBeat.m2504i(85998);
        try {
            XWalkSettings xWalkSettings = (XWalkSettings) this.coreWrapper.getWrapperObject(this.getSettingsMethod.invoke(new Object[0]));
            AppMethodBeat.m2505o(85998);
            return xWalkSettings;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85998);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85998);
            return null;
        }
    }

    public void setNetworkAvailable(boolean z) {
        AppMethodBeat.m2504i(85999);
        try {
            this.setNetworkAvailablebooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85999);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85999);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85999);
        }
    }

    public Uri getRemoteDebuggingUrl() {
        AppMethodBeat.m2504i(86000);
        try {
            Uri uri = (Uri) this.getRemoteDebuggingUrlMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(86000);
            return uri;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86000);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86000);
            return null;
        }
    }

    public boolean zoomIn() {
        AppMethodBeat.m2504i(86001);
        try {
            boolean booleanValue = ((Boolean) this.zoomInMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(86001);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86001);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86001);
            return false;
        }
    }

    public float getScale() {
        AppMethodBeat.m2504i(86002);
        try {
            float floatValue = ((Float) this.getScalenMethod.invoke(new Object[0])).floatValue();
            AppMethodBeat.m2505o(86002);
            return floatValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86002);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86002);
            return 1.0f;
        }
    }

    public boolean zoomOut() {
        AppMethodBeat.m2504i(86003);
        try {
            boolean booleanValue = ((Boolean) this.zoomOutMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(86003);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86003);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86003);
            return false;
        }
    }

    public void zoomBy(float f) {
        AppMethodBeat.m2504i(86004);
        try {
            this.zoomByfloatMethod.invoke(Float.valueOf(f));
            AppMethodBeat.m2505o(86004);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86004);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86004);
        }
    }

    public boolean canZoomIn() {
        AppMethodBeat.m2504i(86005);
        try {
            boolean booleanValue = ((Boolean) this.canZoomInMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(86005);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86005);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86005);
            return false;
        }
    }

    public boolean canZoomOut() {
        AppMethodBeat.m2504i(86006);
        try {
            boolean booleanValue = ((Boolean) this.canZoomOutMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(86006);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86006);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86006);
            return false;
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        AppMethodBeat.m2504i(86007);
        try {
            InputConnection inputConnection = (InputConnection) this.onCreateInputConnectionEditorInfoMethod.invoke(editorInfo);
            AppMethodBeat.m2505o(86007);
            return inputConnection;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86007);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86007);
            return null;
        }
    }

    public void setInitialScale(int i) {
        AppMethodBeat.m2504i(86008);
        try {
            this.setInitialScaleintMethod.invoke(Integer.valueOf(i));
            AppMethodBeat.m2505o(86008);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86008);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86008);
        }
    }

    public Bitmap getFavicon() {
        AppMethodBeat.m2504i(86009);
        try {
            Bitmap bitmap = (Bitmap) this.getFaviconMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(86009);
            return bitmap;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86009);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86009);
            return null;
        }
    }

    public void setZOrderOnTop(boolean z) {
        AppMethodBeat.m2504i(86010);
        try {
            this.setZOrderOnTopbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(86010);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86010);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86010);
        }
    }

    public void clearFormData() {
        AppMethodBeat.m2504i(86011);
        try {
            this.clearFormDataMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(86011);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86011);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86011);
        }
    }

    public void setVisibility(int i) {
        AppMethodBeat.m2504i(86012);
        if (i == 4) {
            i = 8;
        }
        super.setVisibility(i);
        setXWalkViewInternalVisibility(i);
        setSurfaceViewVisibility(i);
        AppMethodBeat.m2505o(86012);
    }

    public void setSurfaceViewVisibility(int i) {
        AppMethodBeat.m2504i(86013);
        try {
            this.setSurfaceViewVisibilityintMethod.invoke(Integer.valueOf(i));
            AppMethodBeat.m2505o(86013);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                this.setSurfaceViewVisibilityintMethod.setArguments(Integer.valueOf(i));
                XWalkCoreWrapper.reserveReflectMethod(this.setSurfaceViewVisibilityintMethod);
                AppMethodBeat.m2505o(86013);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86013);
        }
    }

    public void setXWalkViewInternalVisibility(int i) {
        AppMethodBeat.m2504i(86014);
        try {
            this.setXWalkViewInternalVisibilityintMethod.invoke(Integer.valueOf(i));
            AppMethodBeat.m2505o(86014);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                this.setXWalkViewInternalVisibilityintMethod.setArguments(Integer.valueOf(i));
                XWalkCoreWrapper.reserveReflectMethod(this.setXWalkViewInternalVisibilityintMethod);
                AppMethodBeat.m2505o(86014);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86014);
        }
    }

    public void setDownloadListener(XWalkDownloadListener xWalkDownloadListener) {
        AppMethodBeat.m2504i(86015);
        try {
            this.setDownloadListenerXWalkDownloadListenerInternalMethod.invoke(xWalkDownloadListener.getBridge());
            AppMethodBeat.m2505o(86015);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                this.setDownloadListenerXWalkDownloadListenerInternalMethod.setArguments(new ReflectMethod((Object) xWalkDownloadListener, "getBridge", new Class[0]));
                XWalkCoreWrapper.reserveReflectMethod(this.setDownloadListenerXWalkDownloadListenerInternalMethod);
                AppMethodBeat.m2505o(86015);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86015);
        }
    }

    private boolean performLongClickDelegate() {
        AppMethodBeat.m2504i(86016);
        boolean performLongClick = performLongClick();
        AppMethodBeat.m2505o(86016);
        return performLongClick;
    }

    private boolean onTouchEventDelegate(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(86017);
        boolean onTouchEvent = onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(86017);
        return onTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(86018);
        try {
            boolean booleanValue = ((Boolean) this.onTouchEventMotionEventMethod.invoke(motionEvent)).booleanValue();
            AppMethodBeat.m2505o(86018);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86018);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86018);
            return false;
        }
    }

    public void setCustomOnScrollChangedListener(ScrollChangedListener scrollChangedListener) {
        this.mScrollChangedListener = scrollChangedListener;
    }

    public void onScrollChangedDelegate(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(86019);
        onScrollChanged(i, i2, i3, i4);
        if (this.mScrollChangedListener != null) {
            this.mScrollChangedListener.onScrollChanged(i, i2, i3, i4);
        }
        AppMethodBeat.m2505o(86019);
    }

    private void onFocusChangedDelegate(boolean z, int i, Rect rect) {
        AppMethodBeat.m2504i(86020);
        onFocusChanged(z, i, rect);
        AppMethodBeat.m2505o(86020);
    }

    public void setCustomOnOverScrolledListener(OverScrolledListener overScrolledListener) {
        this.mOverScrolledListener = overScrolledListener;
    }

    private void onOverScrolledDelegate(int i, int i2, boolean z, boolean z2) {
        AppMethodBeat.m2504i(86021);
        onOverScrolled(i, i2, z, z2);
        AppMethodBeat.m2505o(86021);
    }

    private void onOverscrollRefresh(boolean z) {
        AppMethodBeat.m2504i(86022);
        if (this.mOverScrolledListener != null) {
            this.mOverScrolledListener.onOverScrolled(z);
        }
        AppMethodBeat.m2505o(86022);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        AppMethodBeat.m2504i(86023);
        try {
            this.setOnTouchListenerOnTouchListenerMethod.invoke(onTouchListener);
            AppMethodBeat.m2505o(86023);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86023);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86023);
        }
    }

    public void scrollTo(int i, int i2) {
        AppMethodBeat.m2504i(86024);
        try {
            this.scrollTointintMethod.invoke(Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(86024);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86024);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86024);
        }
    }

    public void scrollBy(int i, int i2) {
        AppMethodBeat.m2504i(86025);
        try {
            this.scrollByintintMethod.invoke(Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(86025);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86025);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86025);
        }
    }

    public int computeHorizontalScrollRange() {
        AppMethodBeat.m2504i(86026);
        try {
            int intValue = ((Integer) this.computeHorizontalScrollRangeMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.m2505o(86026);
            return intValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86026);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86026);
            return 0;
        }
    }

    public int computeHorizontalScrollOffset() {
        AppMethodBeat.m2504i(86027);
        try {
            int intValue = ((Integer) this.computeHorizontalScrollOffsetMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.m2505o(86027);
            return intValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86027);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86027);
            return 0;
        }
    }

    public int computeVerticalScrollRange() {
        AppMethodBeat.m2504i(86028);
        try {
            int intValue = ((Integer) this.computeVerticalScrollRangeMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.m2505o(86028);
            return intValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86028);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86028);
            return 0;
        }
    }

    public int computeVerticalScrollOffset() {
        AppMethodBeat.m2504i(86029);
        try {
            int intValue = ((Integer) this.computeVerticalScrollOffsetMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.m2505o(86029);
            return intValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86029);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86029);
            return 0;
        }
    }

    public int computeVerticalScrollExtent() {
        AppMethodBeat.m2504i(86030);
        try {
            int intValue = ((Integer) this.computeVerticalScrollExtentMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.m2505o(86030);
            return intValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86030);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86030);
            return 0;
        }
    }

    public XWalkExternalExtensionManager getExtensionManager() {
        AppMethodBeat.m2504i(86031);
        try {
            XWalkExternalExtensionManager xWalkExternalExtensionManager = (XWalkExternalExtensionManager) this.coreWrapper.getWrapperObject(this.getExtensionManagerMethod.invoke(new Object[0]));
            AppMethodBeat.m2505o(86031);
            return xWalkExternalExtensionManager;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86031);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86031);
            return null;
        }
    }

    public void clearSslPreferences() {
        AppMethodBeat.m2504i(86032);
        try {
            this.clearSslPreferencesMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(86032);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86032);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86032);
        }
    }

    public void clearClientCertPreferences(Runnable runnable) {
        AppMethodBeat.m2504i(86033);
        try {
            this.clearClientCertPreferencesRunnableMethod.invoke(runnable);
            AppMethodBeat.m2505o(86033);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86033);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86033);
        }
    }

    public SslCertificate getCertificate() {
        AppMethodBeat.m2504i(86034);
        try {
            SslCertificate sslCertificate = (SslCertificate) this.getCertificateMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(86034);
            return sslCertificate;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86034);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86034);
            return null;
        }
    }

    public void setFindListener(XWalkFindListener xWalkFindListener) {
        AppMethodBeat.m2504i(86035);
        try {
            this.setFindListenerXWalkFindListenerInternalMethod.invoke(xWalkFindListener.getBridge());
            AppMethodBeat.m2505o(86035);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                this.setFindListenerXWalkFindListenerInternalMethod.setArguments(new ReflectMethod((Object) xWalkFindListener, "getBridge", new Class[0]));
                XWalkCoreWrapper.reserveReflectMethod(this.setFindListenerXWalkFindListenerInternalMethod);
                AppMethodBeat.m2505o(86035);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86035);
        }
    }

    public void findAllAsync(String str) {
        AppMethodBeat.m2504i(86036);
        try {
            this.findAllAsyncStringMethod.invoke(str);
            AppMethodBeat.m2505o(86036);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86036);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86036);
        }
    }

    public void findNext(boolean z) {
        AppMethodBeat.m2504i(86037);
        try {
            this.findNextbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(86037);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86037);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86037);
        }
    }

    public void clearMatches() {
        AppMethodBeat.m2504i(86038);
        try {
            this.clearMatchesMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(86038);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86038);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86038);
        }
    }

    public String getCompositingSurfaceType() {
        AppMethodBeat.m2504i(86039);
        try {
            String str = (String) this.getCompositingSurfaceTypeMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(86039);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86039);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86039);
            return null;
        }
    }

    public void adjustSelectPosition(long j, String str, int i, int i2) {
        AppMethodBeat.m2504i(86040);
        try {
            this.adjustSelectPositionlongStringintintMethod.invoke(Long.valueOf(j), str, Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(86040);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86040);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86040);
        }
    }

    public void setVerticalScrollBarEnable(boolean z) {
        AppMethodBeat.m2504i(86041);
        try {
            this.setVerticalScrollBarEnablebooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(86041);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86041);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86041);
        }
    }

    public void setHorizontalScrollBarEnable(boolean z) {
        AppMethodBeat.m2504i(86042);
        try {
            this.setHorizontalScrollBarEnablebooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(86042);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86042);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86042);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void reflectionInit() {
        AppMethodBeat.m2504i(86043);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.m2505o(86043);
            return;
        }
        int size = this.constructorTypes.size();
        Class[] clsArr = new Class[(size + 1)];
        for (int i = 0; i < size; i++) {
            Object obj = this.constructorTypes.get(i);
            if (obj instanceof String) {
                clsArr[i] = this.coreWrapper.getBridgeClass((String) obj);
                this.constructorParams.set(i, this.coreWrapper.getBridgeObject(this.constructorParams.get(i)));
            } else if (obj instanceof Class) {
                clsArr[i] = (Class) obj;
            } else if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.m2505o(86043);
                throw assertionError;
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkViewBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.loadStringStringMethod.init(this.bridge, null, "loadSuper", String.class, String.class);
            this.loadStringStringMapMethod.init(this.bridge, null, "loadSuper", String.class, String.class, Map.class);
            this.loadDataStringStringStringMethod.init(this.bridge, null, "loadDataSuper", String.class, String.class, String.class);
            this.loadDataWithBaseURLStringStringStringStringStringMethod.init(this.bridge, null, "loadDataWithBaseURLSuper", String.class, String.class, String.class, String.class, String.class);
            this.loadUrlStringMethod.init(this.bridge, null, "loadUrlSuper", String.class);
            this.loadUrlStringMapMethod.init(this.bridge, null, "loadUrlSuper", String.class, Map.class);
            this.loadAppFromManifestStringStringMethod.init(this.bridge, null, "loadAppFromManifestSuper", String.class, String.class);
            this.reloadintMethod.init(this.bridge, null, "reloadSuper", Integer.TYPE);
            this.stopLoadingMethod.init(this.bridge, null, "stopLoadingSuper", new Class[0]);
            this.getUrlMethod.init(this.bridge, null, "getUrlSuper", new Class[0]);
            this.savePageMethod.init(this.bridge, null, "savePageSuper", String.class, String.class, Integer.TYPE);
            this.getHitTestResultMethod.init(this.bridge, null, "getHitTestResultSuper", new Class[0]);
            this.getContentHeightMethod.init(this.bridge, null, "getContentHeightSuper", new Class[0]);
            this.getTitleMethod.init(this.bridge, null, "getTitleSuper", new Class[0]);
            this.getOriginalUrlMethod.init(this.bridge, null, "getOriginalUrlSuper", new Class[0]);
            this.getNavigationHistoryMethod.init(this.bridge, null, "getNavigationHistorySuper", new Class[0]);
            this.addJavascriptInterfaceObjectStringMethod.init(this.bridge, null, "addJavascriptInterfaceSuper", Object.class, String.class);
            this.removeJavascriptInterfaceStringMethod.init(this.bridge, null, "removeJavascriptInterfaceSuper", String.class);
            this.evaluateJavascriptStringValueCallbackMethod.init(this.bridge, null, "evaluateJavascriptSuper", String.class, ValueCallback.class);
            this.clearCachebooleanMethod.init(this.bridge, null, "clearCacheSuper", Boolean.TYPE);
            this.clearCacheForSingleFileStringMethod.init(this.bridge, null, "clearCacheForSingleFileSuper", String.class);
            this.hasEnteredFullscreenMethod.init(this.bridge, null, "hasEnteredFullscreenSuper", new Class[0]);
            this.leaveFullscreenMethod.init(this.bridge, null, "leaveFullscreenSuper", new Class[0]);
            this.pauseTimersMethod.init(this.bridge, null, "pauseTimersSuper", new Class[0]);
            this.resumeTimersMethod.init(this.bridge, null, "resumeTimersSuper", new Class[0]);
            this.onHideMethod.init(this.bridge, null, "onHideSuper", new Class[0]);
            this.onShowMethod.init(this.bridge, null, "onShowSuper", new Class[0]);
            if (XWalkCoreWrapper.getInstance().hasFeature(1)) {
                this.onPauseMethod.init(this.bridge, null, "onPauseSuper", new Class[0]);
                this.onResumeMethod.init(this.bridge, null, "onResumeSuper", new Class[0]);
            }
            this.onDestroyMethod.init(this.bridge, null, "onDestroySuper", new Class[0]);
            this.startActivityForResultIntentintBundleMethod.init(this.bridge, null, "startActivityForResultSuper", Intent.class, Integer.TYPE, Bundle.class);
            this.onActivityResultintintIntentMethod.init(this.bridge, null, "onActivityResultSuper", Integer.TYPE, Integer.TYPE, Intent.class);
            this.onNewIntentIntentMethod.init(this.bridge, null, "onNewIntentSuper", Intent.class);
            this.saveStateBundleMethod.init(this.bridge, null, "saveStateSuper", Bundle.class);
            this.restoreStateBundleMethod.init(this.bridge, null, "restoreStateSuper", Bundle.class);
            this.getAPIVersionMethod.init(this.bridge, null, "getAPIVersionSuper", new Class[0]);
            this.getXWalkVersionMethod.init(this.bridge, null, "getXWalkVersionSuper", new Class[0]);
            this.setUIClientXWalkUIClientInternalMethod.init(this.bridge, null, "setUIClientSuper", this.coreWrapper.getBridgeClass("XWalkUIClientBridge"));
            this.setExtendPluginClientXWalkExtendPluginClientInternalMethod.init(this.bridge, null, "setExtendPluginClientSuper", this.coreWrapper.getBridgeClass("XWalkExtendPluginClientBridge"));
            this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod.init(this.bridge, null, "setExtendCanvasClientSuper", this.coreWrapper.getBridgeClass("XWalkExtendCanvasClientBridge"));
            this.setResourceClientXWalkResourceClientInternalMethod.init(this.bridge, null, "setResourceClientSuper", this.coreWrapper.getBridgeClass("XWalkResourceClientBridge"));
            this.setProxyWebViewClientExtensionInternalMethod.init(this.bridge, null, "setProxyWebViewClientExtensionSuper", this.coreWrapper.getBridgeClass("XWalkProxyWebViewClientExtensionBridge"));
            this.setBackgroundColorintMethod.init(this.bridge, null, "setBackgroundColorSuper", Integer.TYPE);
            this.setOriginAccessWhitelistStringStringArrayMethod.init(this.bridge, null, "setOriginAccessWhitelistSuper", String.class, String[].class);
            this.setUserAgentStringStringMethod.init(this.bridge, null, "setUserAgentStringSuper", String.class);
            this.getUserAgentStringMethod.init(this.bridge, null, "getUserAgentStringSuper", new Class[0]);
            this.setAcceptLanguagesStringMethod.init(this.bridge, null, "setAcceptLanguagesSuper", String.class);
            this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod.init(this.bridge, null, "captureBitmapAsyncSuper", this.coreWrapper.getBridgeClass("XWalkGetBitmapCallbackBridge"));
            this.getSettingsMethod.init(this.bridge, null, "getSettingsSuper", new Class[0]);
            this.setNetworkAvailablebooleanMethod.init(this.bridge, null, "setNetworkAvailableSuper", Boolean.TYPE);
            this.getRemoteDebuggingUrlMethod.init(this.bridge, null, "getRemoteDebuggingUrlSuper", new Class[0]);
            this.getScalenMethod.init(this.bridge, null, "getScaleSuper", new Class[0]);
            this.zoomInMethod.init(this.bridge, null, "zoomInSuper", new Class[0]);
            this.zoomOutMethod.init(this.bridge, null, "zoomOutSuper", new Class[0]);
            this.zoomByfloatMethod.init(this.bridge, null, "zoomBySuper", Float.TYPE);
            this.canZoomInMethod.init(this.bridge, null, "canZoomInSuper", new Class[0]);
            this.canZoomOutMethod.init(this.bridge, null, "canZoomOutSuper", new Class[0]);
            this.onCreateInputConnectionEditorInfoMethod.init(this.bridge, null, "onCreateInputConnectionSuper", EditorInfo.class);
            this.setInitialScaleintMethod.init(this.bridge, null, "setInitialScaleSuper", Integer.TYPE);
            this.getFaviconMethod.init(this.bridge, null, "getFaviconSuper", new Class[0]);
            this.setZOrderOnTopbooleanMethod.init(this.bridge, null, "setZOrderOnTopSuper", Boolean.TYPE);
            this.clearFormDataMethod.init(this.bridge, null, "clearFormDataSuper", new Class[0]);
            this.setSurfaceViewVisibilityintMethod.init(this.bridge, null, "setSurfaceViewVisibilitySuper", Integer.TYPE);
            this.setXWalkViewInternalVisibilityintMethod.init(this.bridge, null, "setXWalkViewInternalVisibilitySuper", Integer.TYPE);
            this.setDownloadListenerXWalkDownloadListenerInternalMethod.init(this.bridge, null, "setDownloadListenerSuper", this.coreWrapper.getBridgeClass("XWalkDownloadListenerBridge"));
            this.onTouchEventMotionEventMethod.init(this.bridge, null, "onTouchEventSuper", MotionEvent.class);
            this.setOnTouchListenerOnTouchListenerMethod.init(this.bridge, null, "setOnTouchListenerSuper", OnTouchListener.class);
            this.scrollTointintMethod.init(this.bridge, null, "scrollToSuper", Integer.TYPE, Integer.TYPE);
            this.scrollByintintMethod.init(this.bridge, null, "scrollBySuper", Integer.TYPE, Integer.TYPE);
            this.computeHorizontalScrollRangeMethod.init(this.bridge, null, "computeHorizontalScrollRangeSuper", new Class[0]);
            this.computeHorizontalScrollOffsetMethod.init(this.bridge, null, "computeHorizontalScrollOffsetSuper", new Class[0]);
            this.computeVerticalScrollRangeMethod.init(this.bridge, null, "computeVerticalScrollRangeSuper", new Class[0]);
            this.computeVerticalScrollOffsetMethod.init(this.bridge, null, "computeVerticalScrollOffsetSuper", new Class[0]);
            this.computeVerticalScrollExtentMethod.init(this.bridge, null, "computeVerticalScrollExtentSuper", new Class[0]);
            this.getExtensionManagerMethod.init(this.bridge, null, "getExtensionManagerSuper", new Class[0]);
            this.clearSslPreferencesMethod.init(this.bridge, null, "clearSslPreferencesSuper", new Class[0]);
            this.clearClientCertPreferencesRunnableMethod.init(this.bridge, null, "clearClientCertPreferencesSuper", Runnable.class);
            this.getCertificateMethod.init(this.bridge, null, "getCertificateSuper", new Class[0]);
            this.setFindListenerXWalkFindListenerInternalMethod.init(this.bridge, null, "setFindListenerSuper", this.coreWrapper.getBridgeClass("XWalkFindListenerBridge"));
            this.findAllAsyncStringMethod.init(this.bridge, null, "findAllAsyncSuper", String.class);
            this.findNextbooleanMethod.init(this.bridge, null, "findNextSuper", Boolean.TYPE);
            this.clearMatchesMethod.init(this.bridge, null, "clearMatchesSuper", new Class[0]);
            this.getCompositingSurfaceTypeMethod.init(this.bridge, null, "getCompositingSurfaceTypeSuper", new Class[0]);
            this.getXWalkContentViewMethod.init(this.bridge, null, "getXWalkContentViewSuper", new Class[0]);
            this.adjustSelectPositionlongStringintintMethod.init(this.bridge, null, "adjustSelectPositionSuper", Long.TYPE, String.class, Integer.TYPE, Integer.TYPE);
            this.getRefererUrlMethod.init(this.bridge, null, "getRefererUrlSuper", new Class[0]);
            this.isSupportExtendPluginForAppbrandMethod.init(this.bridge, null, "isSupportExtendPluginForAppbrandSuper", new Class[0]);
            this.setVerticalScrollBarEnablebooleanMethod.init(this.bridge, null, "setVerticalScrollBarEnableSuper", Boolean.TYPE);
            this.setHorizontalScrollBarEnablebooleanMethod.init(this.bridge, null, "setHorizontalScrollBarEnableSuper", Boolean.TYPE);
            AppMethodBeat.m2505o(86043);
        } catch (UnsupportedOperationException e) {
            AppMethodBeat.m2505o(86043);
        }
    }
}
