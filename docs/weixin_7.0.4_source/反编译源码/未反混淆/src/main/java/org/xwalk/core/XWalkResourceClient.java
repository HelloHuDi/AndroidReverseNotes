package org.xwalk.core;

import android.net.http.SslError;
import android.webkit.ValueCallback;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

public class XWalkResourceClient {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkResourceClient.class.desiredAssertionStatus());
    public static final int ERROR_AUTHENTICATION = -4;
    public static final int ERROR_BAD_URL = -12;
    public static final int ERROR_CONNECT = -6;
    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    public static final int ERROR_FILE = -13;
    public static final int ERROR_FILE_NOT_FOUND = -14;
    public static final int ERROR_HOST_LOOKUP = -2;
    public static final int ERROR_IO = -7;
    public static final int ERROR_OK = 0;
    public static final int ERROR_PROXY_AUTHENTICATION = -5;
    public static final int ERROR_REDIRECT_LOOP = -9;
    public static final int ERROR_TIMEOUT = -8;
    public static final int ERROR_TOO_MANY_REQUESTS = -15;
    public static final int ERROR_UNKNOWN = -1;
    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    public static final int ERROR_UNSUPPORTED_SCHEME = -10;
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes = new ArrayList();
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod createXWalkWebResourceResponseStringStringInputStreamMethod = new ReflectMethod(null, "createXWalkWebResourceResponse", new Class[0]);
    private ReflectMethod createXWalkWebResourceResponseStringStringInputStreamintStringMapMethod = new ReflectMethod(null, "createXWalkWebResourceResponse", new Class[0]);
    private ReflectMethod doUpdateVisitedHistoryXWalkViewInternalStringbooleanMethod = new ReflectMethod(null, "doUpdateVisitedHistory", new Class[0]);
    private ReflectMethod onDocumentLoadedInFrameXWalkViewInternallongMethod = new ReflectMethod(null, "onDocumentLoadedInFrame", new Class[0]);
    private ReflectMethod onLoadFinishedXWalkViewInternalStringMethod = new ReflectMethod(null, "onLoadFinished", new Class[0]);
    private ReflectMethod onLoadStartedXWalkViewInternalStringMethod = new ReflectMethod(null, "onLoadStarted", new Class[0]);
    private ReflectMethod onProgressChangedXWalkViewInternalintMethod = new ReflectMethod(null, "onProgressChanged", new Class[0]);
    private ReflectMethod onReceivedClientCertRequestXWalkViewInternalClientCertRequestInternalMethod = new ReflectMethod(null, "onReceivedClientCertRequest", new Class[0]);
    private ReflectMethod onReceivedHttpAuthRequestXWalkViewInternalXWalkHttpAuthHandlerInternalStringStringMethod = new ReflectMethod(null, "onReceivedHttpAuthRequest", new Class[0]);
    private ReflectMethod onReceivedLoadErrorXWalkViewInternalintStringStringMethod = new ReflectMethod(null, "onReceivedLoadError", new Class[0]);
    private ReflectMethod onReceivedResponseHeadersXWalkViewInternalXWalkWebResourceRequestInternalXWalkWebResourceResponseInternalMethod = new ReflectMethod(null, "onReceivedResponseHeaders", new Class[0]);
    private ReflectMethod onReceivedSslErrorXWalkViewInternalValueCallbackSslErrorMethod = new ReflectMethod(null, "onReceivedSslError", new Class[0]);
    private ReflectMethod postWrapperMethod;
    private ReflectMethod shouldInterceptLoadRequestXWalkViewInternalStringMethod = new ReflectMethod(null, "shouldInterceptLoadRequest", new Class[0]);
    private ReflectMethod shouldInterceptLoadRequestXWalkViewInternalXWalkWebResourceRequestInternalMethod = new ReflectMethod(null, "shouldInterceptLoadRequest", new Class[0]);
    private ReflectMethod shouldOverrideUrlLoadingXWalkViewInternalStringMethod = new ReflectMethod(null, "shouldOverrideUrlLoading", new Class[0]);

    static {
        AppMethodBeat.i(85763);
        AppMethodBeat.o(85763);
    }

    /* Access modifiers changed, original: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkResourceClient(XWalkView xWalkView) {
        AppMethodBeat.i(85746);
        this.constructorTypes.add("XWalkViewBridge");
        this.constructorParams = new ArrayList();
        this.constructorParams.add(xWalkView);
        reflectionInit();
        AppMethodBeat.o(85746);
    }

    public void onDocumentLoadedInFrame(XWalkView xWalkView, long j) {
        AppMethodBeat.i(85747);
        try {
            this.onDocumentLoadedInFrameXWalkViewInternallongMethod.invoke(xWalkView.getBridge(), Long.valueOf(j));
            AppMethodBeat.o(85747);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85747);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85747);
        }
    }

    public void onLoadStarted(XWalkView xWalkView, String str) {
        AppMethodBeat.i(85748);
        try {
            this.onLoadStartedXWalkViewInternalStringMethod.invoke(xWalkView.getBridge(), str);
            AppMethodBeat.o(85748);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85748);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85748);
        }
    }

    public void onLoadFinished(XWalkView xWalkView, String str) {
        AppMethodBeat.i(85749);
        try {
            this.onLoadFinishedXWalkViewInternalStringMethod.invoke(xWalkView.getBridge(), str);
            AppMethodBeat.o(85749);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85749);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85749);
        }
    }

    public void onProgressChanged(XWalkView xWalkView, int i) {
        AppMethodBeat.i(85750);
        try {
            this.onProgressChangedXWalkViewInternalintMethod.invoke(xWalkView.getBridge(), Integer.valueOf(i));
            AppMethodBeat.o(85750);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85750);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85750);
        }
    }

    public WebResourceResponse shouldInterceptLoadRequest(XWalkView xWalkView, String str) {
        AppMethodBeat.i(85751);
        try {
            WebResourceResponse webResourceResponse = (WebResourceResponse) this.shouldInterceptLoadRequestXWalkViewInternalStringMethod.invoke(xWalkView.getBridge(), str);
            AppMethodBeat.o(85751);
            return webResourceResponse;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85751);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85751);
            return null;
        }
    }

    public XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView xWalkView, XWalkWebResourceRequest xWalkWebResourceRequest) {
        AppMethodBeat.i(85752);
        try {
            XWalkWebResourceResponse xWalkWebResourceResponse = (XWalkWebResourceResponse) this.coreWrapper.getWrapperObject(this.shouldInterceptLoadRequestXWalkViewInternalXWalkWebResourceRequestInternalMethod.invoke(xWalkView.getBridge(), ((XWalkWebResourceRequestHandler) xWalkWebResourceRequest).getBridge()));
            AppMethodBeat.o(85752);
            return xWalkWebResourceResponse;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85752);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85752);
            return null;
        }
    }

    public void onReceivedLoadError(XWalkView xWalkView, int i, String str, String str2) {
        AppMethodBeat.i(85753);
        try {
            this.onReceivedLoadErrorXWalkViewInternalintStringStringMethod.invoke(xWalkView.getBridge(), Integer.valueOf(i), str, str2);
            AppMethodBeat.o(85753);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85753);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85753);
        }
    }

    public boolean shouldOverrideUrlLoading(XWalkView xWalkView, String str) {
        AppMethodBeat.i(85754);
        try {
            boolean booleanValue = ((Boolean) this.shouldOverrideUrlLoadingXWalkViewInternalStringMethod.invoke(xWalkView.getBridge(), str)).booleanValue();
            AppMethodBeat.o(85754);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85754);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85754);
            return false;
        }
    }

    public void onReceivedSslError(XWalkView xWalkView, ValueCallback<Boolean> valueCallback, SslError sslError) {
        AppMethodBeat.i(85755);
        try {
            this.onReceivedSslErrorXWalkViewInternalValueCallbackSslErrorMethod.invoke(xWalkView.getBridge(), valueCallback, sslError);
            AppMethodBeat.o(85755);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85755);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85755);
        }
    }

    public void onReceivedClientCertRequest(XWalkView xWalkView, ClientCertRequest clientCertRequest) {
        AppMethodBeat.i(85756);
        try {
            this.onReceivedClientCertRequestXWalkViewInternalClientCertRequestInternalMethod.invoke(xWalkView.getBridge(), ((ClientCertRequestHandler) clientCertRequest).getBridge());
            AppMethodBeat.o(85756);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85756);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85756);
        }
    }

    public void onReceivedResponseHeaders(XWalkView xWalkView, XWalkWebResourceRequest xWalkWebResourceRequest, XWalkWebResourceResponse xWalkWebResourceResponse) {
        AppMethodBeat.i(85757);
        try {
            this.onReceivedResponseHeadersXWalkViewInternalXWalkWebResourceRequestInternalXWalkWebResourceResponseInternalMethod.invoke(xWalkView.getBridge(), ((XWalkWebResourceRequestHandler) xWalkWebResourceRequest).getBridge(), xWalkWebResourceResponse.getBridge());
            AppMethodBeat.o(85757);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85757);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85757);
        }
    }

    public void doUpdateVisitedHistory(XWalkView xWalkView, String str, boolean z) {
        AppMethodBeat.i(85758);
        try {
            this.doUpdateVisitedHistoryXWalkViewInternalStringbooleanMethod.invoke(xWalkView.getBridge(), str, Boolean.valueOf(z));
            AppMethodBeat.o(85758);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85758);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85758);
        }
    }

    public void onReceivedHttpAuthRequest(XWalkView xWalkView, XWalkHttpAuthHandler xWalkHttpAuthHandler, String str, String str2) {
        AppMethodBeat.i(85759);
        try {
            this.onReceivedHttpAuthRequestXWalkViewInternalXWalkHttpAuthHandlerInternalStringStringMethod.invoke(xWalkView.getBridge(), xWalkHttpAuthHandler.getBridge(), str, str2);
            AppMethodBeat.o(85759);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85759);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85759);
        }
    }

    public XWalkWebResourceResponse createXWalkWebResourceResponse(String str, String str2, InputStream inputStream) {
        AppMethodBeat.i(85760);
        try {
            XWalkWebResourceResponse xWalkWebResourceResponse = (XWalkWebResourceResponse) this.coreWrapper.getWrapperObject(this.createXWalkWebResourceResponseStringStringInputStreamMethod.invoke(str, str2, inputStream));
            AppMethodBeat.o(85760);
            return xWalkWebResourceResponse;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85760);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85760);
            return null;
        }
    }

    public XWalkWebResourceResponse createXWalkWebResourceResponse(String str, String str2, InputStream inputStream, int i, String str3, Map<String, String> map) {
        AppMethodBeat.i(85761);
        try {
            XWalkWebResourceResponse xWalkWebResourceResponse = (XWalkWebResourceResponse) this.coreWrapper.getWrapperObject(this.createXWalkWebResourceResponseStringStringInputStreamintStringMapMethod.invoke(str, str2, inputStream, Integer.valueOf(i), str3, map));
            AppMethodBeat.o(85761);
            return xWalkWebResourceResponse;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85761);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85761);
            return null;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void reflectionInit() {
        AppMethodBeat.i(85762);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(85762);
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
                AppMethodBeat.o(85762);
                throw assertionError;
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkResourceClientBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.onDocumentLoadedInFrameXWalkViewInternallongMethod.init(this.bridge, null, "onDocumentLoadedInFrameSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), Long.TYPE);
            this.onLoadStartedXWalkViewInternalStringMethod.init(this.bridge, null, "onLoadStartedSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class);
            this.onLoadFinishedXWalkViewInternalStringMethod.init(this.bridge, null, "onLoadFinishedSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class);
            this.onProgressChangedXWalkViewInternalintMethod.init(this.bridge, null, "onProgressChangedSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), Integer.TYPE);
            this.shouldInterceptLoadRequestXWalkViewInternalStringMethod.init(this.bridge, null, "shouldInterceptLoadRequestSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class);
            this.shouldInterceptLoadRequestXWalkViewInternalXWalkWebResourceRequestInternalMethod.init(this.bridge, null, "shouldInterceptLoadRequestSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkWebResourceRequestHandlerBridge"));
            this.onReceivedLoadErrorXWalkViewInternalintStringStringMethod.init(this.bridge, null, "onReceivedLoadErrorSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), Integer.TYPE, String.class, String.class);
            this.shouldOverrideUrlLoadingXWalkViewInternalStringMethod.init(this.bridge, null, "shouldOverrideUrlLoadingSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class);
            this.onReceivedSslErrorXWalkViewInternalValueCallbackSslErrorMethod.init(this.bridge, null, "onReceivedSslErrorSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), ValueCallback.class, SslError.class);
            this.onReceivedClientCertRequestXWalkViewInternalClientCertRequestInternalMethod.init(this.bridge, null, "onReceivedClientCertRequestSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("ClientCertRequestHandlerBridge"));
            this.onReceivedResponseHeadersXWalkViewInternalXWalkWebResourceRequestInternalXWalkWebResourceResponseInternalMethod.init(this.bridge, null, "onReceivedResponseHeadersSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkWebResourceRequestHandlerBridge"), this.coreWrapper.getBridgeClass("XWalkWebResourceResponseBridge"));
            this.doUpdateVisitedHistoryXWalkViewInternalStringbooleanMethod.init(this.bridge, null, "doUpdateVisitedHistorySuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Boolean.TYPE);
            this.onReceivedHttpAuthRequestXWalkViewInternalXWalkHttpAuthHandlerInternalStringStringMethod.init(this.bridge, null, "onReceivedHttpAuthRequestSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkHttpAuthHandlerBridge"), String.class, String.class);
            this.createXWalkWebResourceResponseStringStringInputStreamMethod.init(this.bridge, null, "createXWalkWebResourceResponseSuper", String.class, String.class, InputStream.class);
            this.createXWalkWebResourceResponseStringStringInputStreamintStringMapMethod.init(this.bridge, null, "createXWalkWebResourceResponseSuper", String.class, String.class, InputStream.class, Integer.TYPE, String.class, Map.class);
            AppMethodBeat.o(85762);
        } catch (UnsupportedOperationException e) {
            AppMethodBeat.o(85762);
        }
    }
}
