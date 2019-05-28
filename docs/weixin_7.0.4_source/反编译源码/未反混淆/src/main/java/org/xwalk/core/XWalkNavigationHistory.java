package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkNavigationHistory {
    private Object bridge;
    private ReflectMethod canGoBackMethod = new ReflectMethod(null, "canGoBack", new Class[0]);
    private ReflectMethod canGoForwardMethod = new ReflectMethod(null, "canGoForward", new Class[0]);
    private ReflectMethod clearMethod = new ReflectMethod(null, "clear", new Class[0]);
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod enumDirectionClassValueOfMethod = new ReflectMethod();
    private ReflectMethod getCurrentIndexMethod = new ReflectMethod(null, "getCurrentIndex", new Class[0]);
    private ReflectMethod getCurrentItemMethod = new ReflectMethod(null, "getCurrentItem", new Class[0]);
    private ReflectMethod getItemAtintMethod = new ReflectMethod(null, "getItemAt", new Class[0]);
    private ReflectMethod hasItemAtintMethod = new ReflectMethod(null, "hasItemAt", new Class[0]);
    private ReflectMethod navigateDirectionInternalintMethod = new ReflectMethod(null, "navigate", new Class[0]);
    private ReflectMethod postWrapperMethod;
    private ReflectMethod sizeMethod = new ReflectMethod(null, "size", new Class[0]);

    public enum Direction {
        BACKWARD,
        FORWARD;

        static {
            AppMethodBeat.o(85716);
        }
    }

    private Object ConvertDirection(Direction direction) {
        AppMethodBeat.i(85717);
        Object invoke = this.enumDirectionClassValueOfMethod.invoke(direction.toString());
        AppMethodBeat.o(85717);
        return invoke;
    }

    /* Access modifiers changed, original: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkNavigationHistory(Object obj) {
        AppMethodBeat.i(85718);
        this.bridge = obj;
        reflectionInit();
        AppMethodBeat.o(85718);
    }

    public int size() {
        AppMethodBeat.i(85719);
        try {
            int intValue = ((Integer) this.sizeMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.o(85719);
            return intValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85719);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85719);
            return 0;
        }
    }

    public boolean hasItemAt(int i) {
        AppMethodBeat.i(85720);
        try {
            boolean booleanValue = ((Boolean) this.hasItemAtintMethod.invoke(Integer.valueOf(i))).booleanValue();
            AppMethodBeat.o(85720);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85720);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85720);
            return false;
        }
    }

    public XWalkNavigationItem getItemAt(int i) {
        AppMethodBeat.i(85721);
        try {
            XWalkNavigationItem xWalkNavigationItem = (XWalkNavigationItem) this.coreWrapper.getWrapperObject(this.getItemAtintMethod.invoke(Integer.valueOf(i)));
            AppMethodBeat.o(85721);
            return xWalkNavigationItem;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85721);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85721);
            return null;
        }
    }

    public XWalkNavigationItem getCurrentItem() {
        AppMethodBeat.i(85722);
        try {
            XWalkNavigationItem xWalkNavigationItem = (XWalkNavigationItem) this.coreWrapper.getWrapperObject(this.getCurrentItemMethod.invoke(new Object[0]));
            AppMethodBeat.o(85722);
            return xWalkNavigationItem;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85722);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85722);
            return null;
        }
    }

    public boolean canGoBack() {
        AppMethodBeat.i(85723);
        try {
            boolean booleanValue = ((Boolean) this.canGoBackMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(85723);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85723);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85723);
            return false;
        }
    }

    public boolean canGoForward() {
        AppMethodBeat.i(85724);
        try {
            boolean booleanValue = ((Boolean) this.canGoForwardMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(85724);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85724);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85724);
            return false;
        }
    }

    public void navigate(Direction direction, int i) {
        AppMethodBeat.i(85725);
        try {
            this.navigateDirectionInternalintMethod.invoke(ConvertDirection(direction), Integer.valueOf(i));
            AppMethodBeat.o(85725);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85725);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85725);
        }
    }

    public int getCurrentIndex() {
        AppMethodBeat.i(85726);
        try {
            int intValue = ((Integer) this.getCurrentIndexMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.o(85726);
            return intValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85726);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85726);
            return 0;
        }
    }

    public void clear() {
        AppMethodBeat.i(85727);
        try {
            this.clearMethod.invoke(new Object[0]);
            AppMethodBeat.o(85727);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85727);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85727);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void reflectionInit() {
        AppMethodBeat.i(85728);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(85728);
            return;
        }
        this.enumDirectionClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkNavigationHistoryInternal$DirectionInternal"), "valueOf", String.class);
        this.sizeMethod.init(this.bridge, null, "sizeSuper", new Class[0]);
        this.hasItemAtintMethod.init(this.bridge, null, "hasItemAtSuper", Integer.TYPE);
        this.getItemAtintMethod.init(this.bridge, null, "getItemAtSuper", Integer.TYPE);
        this.getCurrentItemMethod.init(this.bridge, null, "getCurrentItemSuper", new Class[0]);
        this.canGoBackMethod.init(this.bridge, null, "canGoBackSuper", new Class[0]);
        this.canGoForwardMethod.init(this.bridge, null, "canGoForwardSuper", new Class[0]);
        this.navigateDirectionInternalintMethod.init(this.bridge, null, "navigateSuper", this.coreWrapper.getBridgeClass("XWalkNavigationHistoryInternal$DirectionInternal"), Integer.TYPE);
        this.getCurrentIndexMethod.init(this.bridge, null, "getCurrentIndexSuper", new Class[0]);
        this.clearMethod.init(this.bridge, null, "clearSuper", new Class[0]);
        AppMethodBeat.o(85728);
    }
}
