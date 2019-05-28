package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkHitTestResult {
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod enumtypeClassValueOfMethod = new ReflectMethod();
    private ReflectMethod getExtraMethod = new ReflectMethod(null, "getExtra", new Class[0]);
    private ReflectMethod getTypeMethod = new ReflectMethod(null, "getType", new Class[0]);
    private ReflectMethod postWrapperMethod;

    public enum type {
        UNKNOWN_TYPE,
        ANCHOR_TYPE,
        PHONE_TYPE,
        GEO_TYPE,
        EMAIL_TYPE,
        IMAGE_TYPE,
        IMAGE_ANCHOR_TYPE,
        SRC_ANCHOR_TYPE,
        SRC_IMAGE_ANCHOR_TYPE,
        EDIT_TEXT_TYPE;

        static {
            AppMethodBeat.o(85644);
        }
    }

    private Object Converttype(type type) {
        AppMethodBeat.i(85645);
        Object invoke = this.enumtypeClassValueOfMethod.invoke(type.toString());
        AppMethodBeat.o(85645);
        return invoke;
    }

    /* Access modifiers changed, original: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkHitTestResult(Object obj) {
        AppMethodBeat.i(85646);
        this.bridge = obj;
        reflectionInit();
        AppMethodBeat.o(85646);
    }

    public type getType() {
        AppMethodBeat.i(85647);
        try {
            type valueOf = type.valueOf(this.getTypeMethod.invoke(new Object[0]).toString());
            AppMethodBeat.o(85647);
            return valueOf;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85647);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85647);
            return null;
        }
    }

    public String getExtra() {
        AppMethodBeat.i(85648);
        try {
            String str = (String) this.getExtraMethod.invoke(new Object[0]);
            AppMethodBeat.o(85648);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85648);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85648);
            return null;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void reflectionInit() {
        AppMethodBeat.i(85649);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(85649);
            return;
        }
        this.enumtypeClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkHitTestResultInternal$type"), "valueOf", String.class);
        this.getTypeMethod.init(this.bridge, null, "getTypeSuper", new Class[0]);
        this.getExtraMethod.init(this.bridge, null, "getExtraSuper", new Class[0]);
        AppMethodBeat.o(85649);
    }
}
