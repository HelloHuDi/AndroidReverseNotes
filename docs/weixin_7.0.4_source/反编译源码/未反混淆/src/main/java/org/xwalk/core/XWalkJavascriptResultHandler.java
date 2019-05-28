package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkJavascriptResultHandler implements XWalkJavascriptResult {
    private Object bridge;
    private ReflectMethod cancelMethod = new ReflectMethod(null, "cancel", new Class[0]);
    private ReflectMethod confirmMethod = new ReflectMethod(null, "confirm", new Class[0]);
    private ReflectMethod confirmWithResultStringMethod = new ReflectMethod(null, "confirmWithResult", new Class[0]);
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod postWrapperMethod;

    /* Access modifiers changed, original: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkJavascriptResultHandler(Object obj) {
        AppMethodBeat.i(85666);
        this.bridge = obj;
        reflectionInit();
        AppMethodBeat.o(85666);
    }

    public void confirm() {
        AppMethodBeat.i(85667);
        try {
            this.confirmMethod.invoke(new Object[0]);
            AppMethodBeat.o(85667);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85667);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85667);
        }
    }

    public void confirmWithResult(String str) {
        AppMethodBeat.i(85668);
        try {
            this.confirmWithResultStringMethod.invoke(str);
            AppMethodBeat.o(85668);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85668);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85668);
        }
    }

    public void cancel() {
        AppMethodBeat.i(85669);
        try {
            this.cancelMethod.invoke(new Object[0]);
            AppMethodBeat.o(85669);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85669);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85669);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void reflectionInit() {
        AppMethodBeat.i(85670);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(85670);
            return;
        }
        this.confirmMethod.init(this.bridge, null, "confirmSuper", new Class[0]);
        this.confirmWithResultStringMethod.init(this.bridge, null, "confirmWithResultSuper", String.class);
        this.cancelMethod.init(this.bridge, null, "cancelSuper", new Class[0]);
        AppMethodBeat.o(85670);
    }
}
