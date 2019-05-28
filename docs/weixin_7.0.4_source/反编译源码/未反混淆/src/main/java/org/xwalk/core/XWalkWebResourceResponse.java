package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

public class XWalkWebResourceResponse {
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod getDataMethod = new ReflectMethod(null, "getData", new Class[0]);
    private ReflectMethod getEncodingMethod = new ReflectMethod(null, "getEncoding", new Class[0]);
    private ReflectMethod getMimeTypeMethod = new ReflectMethod(null, "getMimeType", new Class[0]);
    private ReflectMethod getReasonPhraseMethod = new ReflectMethod(null, "getReasonPhrase", new Class[0]);
    private ReflectMethod getResponseHeadersMethod = new ReflectMethod(null, "getResponseHeaders", new Class[0]);
    private ReflectMethod getStatusCodeMethod = new ReflectMethod(null, "getStatusCode", new Class[0]);
    private ReflectMethod postWrapperMethod;
    private ReflectMethod setDataInputStreamMethod = new ReflectMethod(null, "setData", new Class[0]);
    private ReflectMethod setEncodingStringMethod = new ReflectMethod(null, "setEncoding", new Class[0]);
    private ReflectMethod setMimeTypeStringMethod = new ReflectMethod(null, "setMimeType", new Class[0]);
    private ReflectMethod setResponseHeadersMapMethod = new ReflectMethod(null, "setResponseHeaders", new Class[0]);
    private ReflectMethod setStatusCodeAndReasonPhraseintStringMethod = new ReflectMethod(null, "setStatusCodeAndReasonPhrase", new Class[0]);

    /* Access modifiers changed, original: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkWebResourceResponse(Object obj) {
        AppMethodBeat.i(86056);
        this.bridge = obj;
        reflectionInit();
        AppMethodBeat.o(86056);
    }

    public void setMimeType(String str) {
        AppMethodBeat.i(86057);
        try {
            this.setMimeTypeStringMethod.invoke(str);
            AppMethodBeat.o(86057);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(86057);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(86057);
        }
    }

    public String getMimeType() {
        AppMethodBeat.i(86058);
        try {
            String str = (String) this.getMimeTypeMethod.invoke(new Object[0]);
            AppMethodBeat.o(86058);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(86058);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(86058);
            return null;
        }
    }

    public void setEncoding(String str) {
        AppMethodBeat.i(86059);
        try {
            this.setEncodingStringMethod.invoke(str);
            AppMethodBeat.o(86059);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(86059);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(86059);
        }
    }

    public String getEncoding() {
        AppMethodBeat.i(86060);
        try {
            String str = (String) this.getEncodingMethod.invoke(new Object[0]);
            AppMethodBeat.o(86060);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(86060);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(86060);
            return null;
        }
    }

    public void setData(InputStream inputStream) {
        AppMethodBeat.i(86061);
        try {
            this.setDataInputStreamMethod.invoke(inputStream);
            AppMethodBeat.o(86061);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(86061);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(86061);
        }
    }

    public InputStream getData() {
        AppMethodBeat.i(86062);
        try {
            InputStream inputStream = (InputStream) this.getDataMethod.invoke(new Object[0]);
            AppMethodBeat.o(86062);
            return inputStream;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(86062);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(86062);
            return null;
        }
    }

    public void setStatusCodeAndReasonPhrase(int i, String str) {
        AppMethodBeat.i(86063);
        try {
            this.setStatusCodeAndReasonPhraseintStringMethod.invoke(Integer.valueOf(i), str);
            AppMethodBeat.o(86063);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(86063);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(86063);
        }
    }

    public int getStatusCode() {
        AppMethodBeat.i(86064);
        try {
            int intValue = ((Integer) this.getStatusCodeMethod.invoke(new Object[0])).intValue();
            AppMethodBeat.o(86064);
            return intValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(86064);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(86064);
            return 0;
        }
    }

    public String getReasonPhrase() {
        AppMethodBeat.i(86065);
        try {
            String str = (String) this.getReasonPhraseMethod.invoke(new Object[0]);
            AppMethodBeat.o(86065);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(86065);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(86065);
            return null;
        }
    }

    public void setResponseHeaders(Map<String, String> map) {
        AppMethodBeat.i(86066);
        try {
            this.setResponseHeadersMapMethod.invoke(map);
            AppMethodBeat.o(86066);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(86066);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(86066);
        }
    }

    public Map<String, String> getResponseHeaders() {
        AppMethodBeat.i(86067);
        try {
            Map map = (Map) this.getResponseHeadersMethod.invoke(new Object[0]);
            AppMethodBeat.o(86067);
            return map;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(86067);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(86067);
            return null;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void reflectionInit() {
        AppMethodBeat.i(86068);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(86068);
            return;
        }
        this.setMimeTypeStringMethod.init(this.bridge, null, "setMimeTypeSuper", String.class);
        this.getMimeTypeMethod.init(this.bridge, null, "getMimeTypeSuper", new Class[0]);
        this.setEncodingStringMethod.init(this.bridge, null, "setEncodingSuper", String.class);
        this.getEncodingMethod.init(this.bridge, null, "getEncodingSuper", new Class[0]);
        this.setDataInputStreamMethod.init(this.bridge, null, "setDataSuper", InputStream.class);
        this.getDataMethod.init(this.bridge, null, "getDataSuper", new Class[0]);
        this.setStatusCodeAndReasonPhraseintStringMethod.init(this.bridge, null, "setStatusCodeAndReasonPhraseSuper", Integer.TYPE, String.class);
        this.getStatusCodeMethod.init(this.bridge, null, "getStatusCodeSuper", new Class[0]);
        this.getReasonPhraseMethod.init(this.bridge, null, "getReasonPhraseSuper", new Class[0]);
        this.setResponseHeadersMapMethod.init(this.bridge, null, "setResponseHeadersSuper", Map.class);
        this.getResponseHeadersMethod.init(this.bridge, null, "getResponseHeadersSuper", new Class[0]);
        AppMethodBeat.o(86068);
    }
}
