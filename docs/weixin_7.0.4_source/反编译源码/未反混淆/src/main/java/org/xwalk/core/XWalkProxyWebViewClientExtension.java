package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.x5.a.a.a.a.b;
import java.util.ArrayList;

public class XWalkProxyWebViewClientExtension extends b {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkProxyWebViewClientExtension.class.desiredAssertionStatus());
    private static final String TAG = "XWalkProxyWebViewClientExtension";
    private Object bridge;
    private ArrayList<Object> constructorParams = new ArrayList();
    private ArrayList<Object> constructorTypes = new ArrayList();
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod postWrapperMethod;

    static {
        AppMethodBeat.i(85745);
        AppMethodBeat.o(85745);
    }

    /* Access modifiers changed, original: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkProxyWebViewClientExtension() {
        AppMethodBeat.i(85743);
        reflectionInit();
        AppMethodBeat.o(85743);
    }

    /* Access modifiers changed, original: 0000 */
    public void reflectionInit() {
        AppMethodBeat.i(85744);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(85744);
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
                AppMethodBeat.o(85744);
                throw assertionError;
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkProxyWebViewClientExtensionBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            AppMethodBeat.o(85744);
        } catch (UnsupportedOperationException e) {
            AppMethodBeat.o(85744);
        }
    }
}
