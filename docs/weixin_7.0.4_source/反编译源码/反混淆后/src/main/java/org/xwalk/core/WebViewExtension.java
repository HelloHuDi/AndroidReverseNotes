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

    /* renamed from: org.xwalk.core.WebViewExtension$1 */
    static class C312091 extends WebViewExtensionInterface {
        C312091() {
        }

        public final Object onMiscCallBack(String str, Object... objArr) {
            AppMethodBeat.m2504i(85525);
            if (WebViewExtension.mWebViewExtensionListener != null) {
                Object onMiscCallBack = WebViewExtension.mWebViewExtensionListener.onMiscCallBack(str, objArr);
                AppMethodBeat.m2505o(85525);
                return onMiscCallBack;
            }
            AppMethodBeat.m2505o(85525);
            return null;
        }

        public final int getHostByName(String str, List<String> list) {
            AppMethodBeat.m2504i(85526);
            if (WebViewExtension.mWebViewExtensionListener != null) {
                int hostByName = WebViewExtension.mWebViewExtensionListener.getHostByName(str, list);
                AppMethodBeat.m2505o(85526);
                return hostByName;
            }
            AppMethodBeat.m2505o(85526);
            return 0;
        }
    }

    static {
        AppMethodBeat.m2504i(85534);
        AppMethodBeat.m2505o(85534);
    }

    /* Access modifiers changed, original: protected */
    public Object getBridge() {
        return this.bridge;
    }

    private static WebViewExtension getInstance() {
        AppMethodBeat.m2504i(85527);
        if (sInstance == null) {
            sInstance = new WebViewExtension();
        }
        WebViewExtension webViewExtension = sInstance;
        AppMethodBeat.m2505o(85527);
        return webViewExtension;
    }

    public WebViewExtension() {
        AppMethodBeat.m2504i(85528);
        reflectionInit();
        AppMethodBeat.m2505o(85528);
    }

    public static void SetExtension(WebViewExtensionListener webViewExtensionListener) {
        AppMethodBeat.m2504i(85529);
        Log.m81049i(TAG, "SetExtension WebViewExtensionInterface");
        mWebViewExtensionListener = webViewExtensionListener;
        try {
            updateExtension(true);
            AppMethodBeat.m2505o(85529);
        } catch (Exception e) {
            Log.m81049i(TAG, "SetExtension refelction not ready, updateExtension when available:" + e.getMessage());
            AppMethodBeat.m2505o(85529);
        }
    }

    public static void updateExtension(boolean z) {
        AppMethodBeat.m2504i(85530);
        if (mWebViewExtensionListener != null && (z || mWebViewExtensionInterface == null)) {
            getInstance();
            Log.m81049i(TAG, "updateExtension");
            mWebViewExtensionInterface = new C312091();
            getInstance().SetExtensionMethod.invoke(mWebViewExtensionInterface.getBridge());
        }
        AppMethodBeat.m2505o(85530);
    }

    public static boolean addFilterResources(Resources resources, Map<Long, Integer> map) {
        AppMethodBeat.m2504i(85531);
        boolean invokeExtensionMethod = invokeExtensionMethod(EXTENSION_ADD_FILTER_RESOURCES, resources, map);
        AppMethodBeat.m2505o(85531);
        return invokeExtensionMethod;
    }

    public static boolean invokeExtensionMethod(String str, Object... objArr) {
        AppMethodBeat.m2504i(85532);
        if (mWebViewExtensionListener != null) {
            mWebViewExtensionListener.onMiscCallBack(str, objArr);
            AppMethodBeat.m2505o(85532);
            return true;
        }
        Log.m81046e(TAG, "InvokeExtensionMethod interface is null,method:".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(85532);
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public void reflectionInit() {
        AppMethodBeat.m2504i(85533);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.m2505o(85533);
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
                AppMethodBeat.m2505o(85533);
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
            AppMethodBeat.m2505o(85533);
        } catch (UnsupportedOperationException e) {
            AppMethodBeat.m2505o(85533);
        }
    }
}
