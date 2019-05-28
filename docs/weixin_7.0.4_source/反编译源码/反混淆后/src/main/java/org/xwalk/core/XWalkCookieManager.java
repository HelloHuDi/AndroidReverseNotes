package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import org.xwalk.core.util.WebAddress;

public class XWalkCookieManager {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkCookieManager.class.desiredAssertionStatus());
    private static final String TAG = "XWalkCookieManager";
    private ReflectMethod acceptCookieMethod = new ReflectMethod(null, "acceptCookie", new Class[0]);
    private ReflectMethod allowFileSchemeCookiesMethod = new ReflectMethod(null, "allowFileSchemeCookies", new Class[0]);
    private Object bridge;
    private ArrayList<Object> constructorParams = new ArrayList();
    private ArrayList<Object> constructorTypes = new ArrayList();
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod flushCookieStoreMethod = new ReflectMethod(null, "flushCookieStore", new Class[0]);
    private ReflectMethod getCookieStringMethod = new ReflectMethod(null, "getCookie", new Class[0]);
    private ReflectMethod hasCookiesMethod = new ReflectMethod(null, "hasCookies", new Class[0]);
    private ReflectMethod postWrapperMethod;
    private ReflectMethod removeAllCookieMethod = new ReflectMethod(null, "removeAllCookie", new Class[0]);
    private ReflectMethod removeExpiredCookieMethod = new ReflectMethod(null, "removeExpiredCookie", new Class[0]);
    private ReflectMethod removeSessionCookieMethod = new ReflectMethod(null, "removeSessionCookie", new Class[0]);
    private ReflectMethod setAcceptCookiebooleanMethod = new ReflectMethod(null, "setAcceptCookie", new Class[0]);
    private ReflectMethod setAcceptFileSchemeCookiesbooleanMethod = new ReflectMethod(null, "setAcceptFileSchemeCookies", new Class[0]);
    private ReflectMethod setCookieStringStringMethod = new ReflectMethod(null, "setCookie", new Class[0]);

    static {
        AppMethodBeat.m2504i(85552);
        AppMethodBeat.m2505o(85552);
    }

    /* Access modifiers changed, original: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkCookieManager() {
        AppMethodBeat.m2504i(85539);
        reflectionInit();
        AppMethodBeat.m2505o(85539);
    }

    public void setAcceptCookie(boolean z) {
        AppMethodBeat.m2504i(85540);
        try {
            this.setAcceptCookiebooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85540);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85540);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85540);
        }
    }

    public boolean acceptCookie() {
        AppMethodBeat.m2504i(85541);
        try {
            boolean booleanValue = ((Boolean) this.acceptCookieMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85541);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85541);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85541);
            return false;
        }
    }

    public void setCookie(String str, String str2) {
        AppMethodBeat.m2504i(85542);
        try {
            str = new WebAddress(str).toString();
        } catch (Exception e) {
            Log.m81046e(TAG, "setCookie transform url to WebAddress failed");
        }
        try {
            this.setCookieStringStringMethod.invoke(str, str2);
            AppMethodBeat.m2505o(85542);
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85542);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.m2505o(85542);
        }
    }

    public String getCookie(String str) {
        AppMethodBeat.m2504i(85543);
        try {
            str = new WebAddress(str).toString();
        } catch (Exception e) {
            Log.m81046e(TAG, "getCookie transform url to WebAddress failed");
        }
        try {
            String str2 = (String) this.getCookieStringMethod.invoke(str);
            AppMethodBeat.m2505o(85543);
            return str2;
        } catch (UnsupportedOperationException e2) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85543);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e2);
            AppMethodBeat.m2505o(85543);
            return null;
        }
    }

    public void removeSessionCookie() {
        AppMethodBeat.m2504i(85544);
        try {
            this.removeSessionCookieMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85544);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85544);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85544);
        }
    }

    public void removeAllCookie() {
        AppMethodBeat.m2504i(85545);
        try {
            this.removeAllCookieMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85545);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85545);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85545);
        }
    }

    public boolean hasCookies() {
        AppMethodBeat.m2504i(85546);
        try {
            boolean booleanValue = ((Boolean) this.hasCookiesMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85546);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85546);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85546);
            return false;
        }
    }

    public void removeExpiredCookie() {
        AppMethodBeat.m2504i(85547);
        try {
            this.removeExpiredCookieMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85547);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85547);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85547);
        }
    }

    public void flushCookieStore() {
        AppMethodBeat.m2504i(85548);
        try {
            this.flushCookieStoreMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85548);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85548);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85548);
        }
    }

    public boolean allowFileSchemeCookies() {
        AppMethodBeat.m2504i(85549);
        try {
            boolean booleanValue = ((Boolean) this.allowFileSchemeCookiesMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85549);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85549);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85549);
            return false;
        }
    }

    public void setAcceptFileSchemeCookies(boolean z) {
        AppMethodBeat.m2504i(85550);
        try {
            this.setAcceptFileSchemeCookiesbooleanMethod.invoke(Boolean.valueOf(z));
            AppMethodBeat.m2505o(85550);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85550);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85550);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void reflectionInit() {
        AppMethodBeat.m2504i(85551);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.m2505o(85551);
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
                AppMethodBeat.m2505o(85551);
                throw assertionError;
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkCookieManagerBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.setAcceptCookiebooleanMethod.init(this.bridge, null, "setAcceptCookieSuper", Boolean.TYPE);
            this.acceptCookieMethod.init(this.bridge, null, "acceptCookieSuper", new Class[0]);
            this.setCookieStringStringMethod.init(this.bridge, null, "setCookieSuper", String.class, String.class);
            this.getCookieStringMethod.init(this.bridge, null, "getCookieSuper", String.class);
            this.removeSessionCookieMethod.init(this.bridge, null, "removeSessionCookieSuper", new Class[0]);
            this.removeAllCookieMethod.init(this.bridge, null, "removeAllCookieSuper", new Class[0]);
            this.hasCookiesMethod.init(this.bridge, null, "hasCookiesSuper", new Class[0]);
            this.removeExpiredCookieMethod.init(this.bridge, null, "removeExpiredCookieSuper", new Class[0]);
            this.flushCookieStoreMethod.init(this.bridge, null, "flushCookieStoreSuper", new Class[0]);
            this.allowFileSchemeCookiesMethod.init(this.bridge, null, "allowFileSchemeCookiesSuper", new Class[0]);
            this.setAcceptFileSchemeCookiesbooleanMethod.init(this.bridge, null, "setAcceptFileSchemeCookiesSuper", Boolean.TYPE);
            AppMethodBeat.m2505o(85551);
        } catch (UnsupportedOperationException e) {
            AppMethodBeat.m2505o(85551);
        }
    }
}
