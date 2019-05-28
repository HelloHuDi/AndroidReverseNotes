package org.xwalk.core;

import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkExtendPluginClient {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkExtendPluginClient.class.desiredAssertionStatus());
    private static final String TAG = "XWalkExtendPluginClient";
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes = new ArrayList();
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod postWrapperMethod;
    private ReflectMethod setPluginTextureScaleStringintfloatfloatMethod = new ReflectMethod(null, "setPluginTextureScale", new Class[0]);

    static {
        AppMethodBeat.m2504i(85633);
        AppMethodBeat.m2505o(85633);
    }

    /* Access modifiers changed, original: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkExtendPluginClient(XWalkView xWalkView) {
        AppMethodBeat.m2504i(85630);
        this.constructorTypes.add("XWalkViewBridge");
        this.constructorParams = new ArrayList();
        this.constructorParams.add(xWalkView);
        reflectionInit();
        AppMethodBeat.m2505o(85630);
    }

    public void onPluginReady(String str, int i, SurfaceTexture surfaceTexture) {
    }

    public void onPluginDestroy(String str, int i) {
    }

    public void onPluginTouch(String str, int i, String str2) {
    }

    public void onPluginTouch(String str, int i, MotionEvent motionEvent) {
    }

    public void setPluginTextureScale(String str, int i, float f, float f2) {
        AppMethodBeat.m2504i(85631);
        try {
            Log.m81049i(TAG, "setPluginTextureScale embed_type:" + str + ",embed_id:" + i + ",xScale:" + f + ",yScale:" + f2);
            this.setPluginTextureScaleStringintfloatfloatMethod.invoke(str, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2));
            AppMethodBeat.m2505o(85631);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85631);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85631);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void reflectionInit() {
        AppMethodBeat.m2504i(85632);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.m2505o(85632);
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
                AppMethodBeat.m2505o(85632);
                throw assertionError;
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkExtendPluginClientBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.setPluginTextureScaleStringintfloatfloatMethod.init(this.bridge, null, "setPluginTextureScale", String.class, Integer.TYPE, Float.TYPE, Float.TYPE);
            AppMethodBeat.m2505o(85632);
        } catch (UnsupportedOperationException e) {
            AppMethodBeat.m2505o(85632);
        }
    }
}
