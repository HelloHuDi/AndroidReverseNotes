package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkNavigationItem {
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod getOriginalUrlMethod = new ReflectMethod(null, "getOriginalUrl", new Class[0]);
    private ReflectMethod getTitleMethod = new ReflectMethod(null, "getTitle", new Class[0]);
    private ReflectMethod getUrlMethod = new ReflectMethod(null, "getUrl", new Class[0]);
    private ReflectMethod postWrapperMethod;

    /* Access modifiers changed, original: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkNavigationItem(Object obj) {
        AppMethodBeat.i(85729);
        this.bridge = obj;
        reflectionInit();
        AppMethodBeat.o(85729);
    }

    public String getUrl() {
        AppMethodBeat.i(85730);
        try {
            String str = (String) this.getUrlMethod.invoke(new Object[0]);
            AppMethodBeat.o(85730);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85730);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85730);
            return null;
        }
    }

    public String getOriginalUrl() {
        AppMethodBeat.i(85731);
        try {
            String str = (String) this.getOriginalUrlMethod.invoke(new Object[0]);
            AppMethodBeat.o(85731);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85731);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85731);
            return null;
        }
    }

    public String getTitle() {
        AppMethodBeat.i(85732);
        try {
            String str = (String) this.getTitleMethod.invoke(new Object[0]);
            AppMethodBeat.o(85732);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85732);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85732);
            return null;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void reflectionInit() {
        AppMethodBeat.i(85733);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(85733);
            return;
        }
        this.getUrlMethod.init(this.bridge, null, "getUrlSuper", new Class[0]);
        this.getOriginalUrlMethod.init(this.bridge, null, "getOriginalUrlSuper", new Class[0]);
        this.getTitleMethod.init(this.bridge, null, "getTitleSuper", new Class[0]);
        AppMethodBeat.o(85733);
    }
}
