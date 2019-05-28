package org.xwalk.core;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WebViewExtension {
    static final /* synthetic */ boolean $assertionsDisabled = (!WebViewExtension.class.desiredAssertionStatus());
    public static final String EXTENSION_ADD_FILTER_RESOURCES = "AddFilterResources";
    private static final String TAG = "XWalkLib.WebViewExtension";
    private static WebViewExtensionInterface mWebViewExtensionInterface;
    private static WebViewExtensionListener mWebViewExtensionListener;
    private static WebViewExtension sInstance;
    private ReflectMethod SetExtensionMethod = new ReflectMethod(null, "SetExtension", new Class[0]);
    private Object bridge;
    private ArrayList<Object> constructorParams = new ArrayList();
    private ArrayList<Object> constructorTypes = new ArrayList();
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod postWrapperMethod;

    static {
        AppMethodBeat.i(85534);
        AppMethodBeat.o(85534);
    }

    /* Access modifiers changed, original: protected */
    public Object getBridge() {
        return this.bridge;
    }

    private static WebViewExtension getInstance() {
        AppMethodBeat.i(85527);
        if (sInstance == null) {
            sInstance = new WebViewExtension();
        }
        WebViewExtension webViewExtension = sInstance;
        AppMethodBeat.o(85527);
        return webViewExtension;
    }

    public WebViewExtension() {
        AppMethodBeat.i(85528);
        reflectionInit();
        AppMethodBeat.o(85528);
    }

    public static void SetExtension(WebViewExtensionListener webViewExtensionListener) {
        AppMethodBeat.i(85529);
        Log.i(TAG, "SetExtension WebViewExtensionInterface");
        mWebViewExtensionListener = webViewExtensionListener;
        try {
            updateExtension(true);
            AppMethodBeat.o(85529);
        } catch (Exception e) {
            Log.i(TAG, "SetExtension refelction not ready, updateExtension when available:" + e.getMessage());
            AppMethodBeat.o(85529);
        }
    }

    public static void updateExtension(boolean z) {
        AppMethodBeat.i(85530);
        if (mWebViewExtensionListener != null && (z || mWebViewExtensionInterface == null)) {
            getInstance();
            Log.i(TAG, "updateExtension");
            mWebViewExtensionInterface = new WebViewExtensionInterface() {
                public final Object onMiscCallBack(String str, Object... objArr) {
                    AppMethodBeat.i(85525);
                    if (WebViewExtension.mWebViewExtensionListener != null) {
                        Object onMiscCallBack = WebViewExtension.mWebViewExtensionListener.onMiscCallBack(str, objArr);
                        AppMethodBeat.o(85525);
                        return onMiscCallBack;
                    }
                    AppMethodBeat.o(85525);
                    return null;
                }

                public final int getHostByName(String str, List<String> list) {
                    AppMethodBeat.i(85526);
                    if (WebViewExtension.mWebViewExtensionListener != null) {
                        int hostByName = WebViewExtension.mWebViewExtensionListener.getHostByName(str, list);
                        AppMethodBeat.o(85526);
                        return hostByName;
                    }
                    AppMethodBeat.o(85526);
                    return 0;
                }
            };
            getInstance().SetExtensionMethod.invoke(mWebViewExtensionInterface.getBridge());
        }
        AppMethodBeat.o(85530);
    }

    public static boolean addFilterResources(Resources resources, Map<Long, Integer> map) {
        AppMethodBeat.i(85531);
        boolean invokeExtensionMethod = invokeExtensionMethod(EXTENSION_ADD_FILTER_RESOURCES, resources, map);
        AppMethodBeat.o(85531);
        return invokeExtensionMethod;
    }

    public static boolean invokeExtensionMethod(String str, Object... objArr) {
        AppMethodBeat.i(85532);
        if (mWebViewExtensionListener != null) {
            mWebViewExtensionListener.onMiscCallBack(str, objArr);
            AppMethodBeat.o(85532);
            return true;
        }
        Log.e(TAG, "InvokeExtensionMethod interface is null,method:".concat(String.valueOf(str)));
        AppMethodBeat.o(85532);
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public void reflectionInit() {
        AppMethodBeat.i(85533);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(85533);
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
                AppMethodBeat.o(85533);
                throw assertionError;
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("WebViewExtensionBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.SetExtensionMethod.init(this.bridge, null, "SetExtensionSuper", this.coreWrapper.getBridgeClass("WebViewExtensionInterfaceBridge"));
            AppMethodBeat.o(85533);
        } catch (UnsupportedOperationException e) {
            AppMethodBeat.o(85533);
        }
    }
}
