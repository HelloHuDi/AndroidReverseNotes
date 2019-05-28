package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

public class ClientCertRequestHandler implements ClientCertRequest {
    private Object bridge;
    private ReflectMethod cancelMethod = new ReflectMethod(null, "cancel", new Class[0]);
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod getHostMethod = new ReflectMethod(null, "getHost", new Class[0]);
    private ReflectMethod getKeyTypesMethod = new ReflectMethod(null, "getKeyTypes", new Class[0]);
    private ReflectMethod getPortMethod = new ReflectMethod(null, "getPort", new Class[0]);
    private ReflectMethod getPrincipalsMethod = new ReflectMethod(null, "getPrincipals", new Class[0]);
    private ReflectMethod ignoreMethod = new ReflectMethod(null, "ignore", new Class[0]);
    private ReflectMethod postWrapperMethod;
    private ReflectMethod proceedPrivateKeyListMethod = new ReflectMethod(null, "proceed", new Class[0]);

    /* Access modifiers changed, original: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public ClientCertRequestHandler(Object obj) {
        AppMethodBeat.i(85500);
        this.bridge = obj;
        reflectionInit();
        AppMethodBeat.o(85500);
    }

    public void proceed(PrivateKey privateKey, List<X509Certificate> list) {
        AppMethodBeat.i(85501);
        try {
            this.proceedPrivateKeyListMethod.invoke(privateKey, list);
            AppMethodBeat.o(85501);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85501);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85501);
        }
    }

    public void ignore() {
        AppMethodBeat.i(85502);
        try {
            this.ignoreMethod.invoke(new Object[0]);
            AppMethodBeat.o(85502);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85502);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85502);
        }
    }

    public void cancel() {
        AppMethodBeat.i(85503);
        try {
            this.cancelMethod.invoke(new Object[0]);
            AppMethodBeat.o(85503);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85503);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85503);
        }
    }

    public String getHost() {
        AppMethodBeat.i(85504);
        try {
            String str = (String) this.getHostMethod.invoke(new Object[0]);
            AppMethodBeat.o(85504);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85504);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85504);
            return null;
        }
    }

    public int getPort() {
        AppMethodBeat.i(85505);
        try {
            int intValue = ((Integer) this.getPortMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.o(85505);
            return intValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85505);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85505);
            return 0;
        }
    }

    public String[] getKeyTypes() {
        AppMethodBeat.i(85506);
        try {
            String[] strArr = (String[]) this.getKeyTypesMethod.invoke(new Object[0]);
            AppMethodBeat.o(85506);
            return strArr;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85506);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85506);
            return null;
        }
    }

    public Principal[] getPrincipals() {
        AppMethodBeat.i(85507);
        try {
            Principal[] principalArr = (Principal[]) this.getPrincipalsMethod.invoke(new Object[0]);
            AppMethodBeat.o(85507);
            return principalArr;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85507);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85507);
            return null;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void reflectionInit() {
        AppMethodBeat.i(85508);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(85508);
            return;
        }
        this.proceedPrivateKeyListMethod.init(this.bridge, null, "proceedSuper", PrivateKey.class, List.class);
        this.ignoreMethod.init(this.bridge, null, "ignoreSuper", new Class[0]);
        this.cancelMethod.init(this.bridge, null, "cancelSuper", new Class[0]);
        this.getHostMethod.init(this.bridge, null, "getHostSuper", new Class[0]);
        this.getPortMethod.init(this.bridge, null, "getPortSuper", new Class[0]);
        this.getKeyTypesMethod.init(this.bridge, null, "getKeyTypesSuper", new Class[0]);
        this.getPrincipalsMethod.init(this.bridge, null, "getPrincipalsSuper", new Class[0]);
        AppMethodBeat.o(85508);
    }
}
