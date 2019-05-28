package org.xwalk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;

public abstract class XWalkExternalExtensionManager {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkExternalExtensionManager.class.desiredAssertionStatus());
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes = new ArrayList();
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod getViewActivityMethod = new ReflectMethod(null, "getViewActivity", new Class[0]);
    private ReflectMethod getViewContextMethod = new ReflectMethod(null, "getViewContext", new Class[0]);
    private ReflectMethod loadExtensionStringMethod = new ReflectMethod(null, "loadExtension", new Class[0]);
    private ReflectMethod onActivityResultintintIntentMethod = new ReflectMethod(null, "onActivityResult", new Class[0]);
    private ReflectMethod onDestroyMethod = new ReflectMethod(null, "onDestroy", new Class[0]);
    private ReflectMethod onPauseMethod = new ReflectMethod(null, "onPause", new Class[0]);
    private ReflectMethod onResumeMethod = new ReflectMethod(null, "onResume", new Class[0]);
    private ReflectMethod onStartMethod = new ReflectMethod(null, "onStart", new Class[0]);
    private ReflectMethod onStopMethod = new ReflectMethod(null, "onStop", new Class[0]);
    private ReflectMethod postWrapperMethod;

    public abstract void onNewIntent(Intent intent);

    /* Access modifiers changed, original: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkExternalExtensionManager(XWalkView xWalkView) {
        this.constructorTypes.add("XWalkViewBridge");
        this.constructorParams = new ArrayList();
        this.constructorParams.add(xWalkView);
        reflectionInit();
    }

    @Deprecated
    public Activity getViewActivity() {
        try {
            return (Activity) this.getViewActivityMethod.invoke(new Object[0]);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public Context getViewContext() {
        try {
            return (Context) this.getViewContextMethod.invoke(new Object[0]);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public void loadExtension(String str) {
        try {
            this.loadExtensionStringMethod.invoke(str);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onStart() {
        try {
            this.onStartMethod.invoke(new Object[0]);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onResume() {
        try {
            this.onResumeMethod.invoke(new Object[0]);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onPause() {
        try {
            this.onPauseMethod.invoke(new Object[0]);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onStop() {
        try {
            this.onStopMethod.invoke(new Object[0]);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void onDestroy() {
        try {
            this.onDestroyMethod.invoke(new Object[0]);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    @Deprecated
    public void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.onActivityResultintintIntentMethod.invoke(Integer.valueOf(i), Integer.valueOf(i2), intent);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void reflectionInit() {
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
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
                throw new AssertionError();
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkExternalExtensionManagerBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.getViewActivityMethod.init(this.bridge, null, "getViewActivitySuper", new Class[0]);
            this.getViewContextMethod.init(this.bridge, null, "getViewContextSuper", new Class[0]);
            this.loadExtensionStringMethod.init(this.bridge, null, "loadExtensionSuper", String.class);
            this.onStartMethod.init(this.bridge, null, "onStartSuper", new Class[0]);
            this.onResumeMethod.init(this.bridge, null, "onResumeSuper", new Class[0]);
            this.onPauseMethod.init(this.bridge, null, "onPauseSuper", new Class[0]);
            this.onStopMethod.init(this.bridge, null, "onStopSuper", new Class[0]);
            this.onDestroyMethod.init(this.bridge, null, "onDestroySuper", new Class[0]);
            this.onActivityResultintintIntentMethod.init(this.bridge, null, "onActivityResultSuper", Integer.TYPE, Integer.TYPE, Intent.class);
        } catch (UnsupportedOperationException e) {
        }
    }
}
