package org.xwalk.core;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkUIClient {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkUIClient.class.desiredAssertionStatus());
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes = new ArrayList();
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod enumConsoleMessageTypeClassValueOfMethod = new ReflectMethod();
    private ReflectMethod enumInitiateByClassValueOfMethod = new ReflectMethod();
    private ReflectMethod enumJavascriptMessageTypeClassValueOfMethod = new ReflectMethod();
    private ReflectMethod enumLoadStatusClassValueOfMethod = new ReflectMethod();
    private ReflectMethod getVideoLoadingProgressViewMethod = new ReflectMethod(null, "getVideoLoadingProgressView", new Class[0]);
    private ReflectMethod isSearchableMethod = new ReflectMethod(null, "isSearchable", new Class[0]);
    private ReflectMethod onConsoleMessageXWalkViewInternalStringintStringConsoleMessageTypeMethod = new ReflectMethod(null, "onConsoleMessage", new Class[0]);
    private ReflectMethod onCreateWindowRequestedXWalkViewInternalInitiateByInternalValueCallbackMethod = new ReflectMethod(null, "onCreateWindowRequested", new Class[0]);
    private ReflectMethod onDidChangeThemeColorXWalkViewInternalStringMessageMethod = new ReflectMethod(null, "onDidChangeThemeColor", new Class[0]);
    private ReflectMethod onFullscreenToggledXWalkViewInternalbooleanMethod = new ReflectMethod(null, "onFullscreenToggled", new Class[0]);
    private ReflectMethod onGeolocationPermissionsHidePromptMethod = new ReflectMethod(null, "onGeolocationPermissionsHidePrompt", new Class[0]);
    private ReflectMethod onGeolocationPermissionsShowPromptStringXWalkGeolocationPermissionsCallbackInternalMethod = new ReflectMethod(null, "onGeolocationPermissionsShowPrompt", new Class[0]);
    private ReflectMethod onHideCustomViewMethod = new ReflectMethod(null, "onHideCustomView", new Class[0]);
    private ReflectMethod onIconAvailableXWalkViewInternalStringMessageMethod = new ReflectMethod(null, "onIconAvailable", new Class[0]);
    private ReflectMethod onJavascriptCloseWindowXWalkViewInternalMethod = new ReflectMethod(null, "onJavascriptCloseWindow", new Class[0]);
    private ReflectMethod onJavascriptModalDialogXWalkViewInternalJavascriptMessageTypeInternalStringStringStringXWalkJavascriptResultInternalMethod = new ReflectMethod(null, "onJavascriptModalDialog", new Class[0]);
    private ReflectMethod onJsAlertXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod = new ReflectMethod(null, "onJsAlert", new Class[0]);
    private ReflectMethod onJsConfirmXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod = new ReflectMethod(null, "onJsConfirm", new Class[0]);
    private ReflectMethod onJsPromptXWalkViewInternalStringStringStringXWalkJavascriptResultInternalMethod = new ReflectMethod(null, "onJsPrompt", new Class[0]);
    private ReflectMethod onPageLoadStartedXWalkViewInternalStringMethod = new ReflectMethod(null, "onPageLoadStarted", new Class[0]);
    private ReflectMethod onPageLoadStoppedXWalkViewInternalStringLoadStatusInternalMethod = new ReflectMethod(null, "onPageLoadStopped", new Class[0]);
    private ReflectMethod onReceivedIconXWalkViewInternalStringBitmapMethod = new ReflectMethod(null, "onReceivedIcon", new Class[0]);
    private ReflectMethod onReceivedTitleXWalkViewInternalStringMethod = new ReflectMethod(null, "onReceivedTitle", new Class[0]);
    private ReflectMethod onRequestFocusXWalkViewInternalMethod = new ReflectMethod(null, "onRequestFocus", new Class[0]);
    private ReflectMethod onScaleChangedXWalkViewInternalfloatfloatMethod = new ReflectMethod(null, "onScaleChanged", new Class[0]);
    private ReflectMethod onSearchWordXWalkViewInternalStringStringStringCallbackMethod = new ReflectMethod(null, "onSearchWord", new Class[0]);
    private ReflectMethod onSelectInfoChangedXWalkViewInternallongStringStringStringCallbackMethod = new ReflectMethod(null, "onSelectInfoChanged", new Class[0]);
    private ReflectMethod onShowCustomViewViewCustomViewCallbackInternalMethod = new ReflectMethod(null, "onShowCustomView", new Class[0]);
    private ReflectMethod onShowCustomViewViewintCustomViewCallbackInternalMethod = new ReflectMethod(null, "onShowCustomView", new Class[0]);
    private ReflectMethod onShowSosMethod = new ReflectMethod(null, "onShowSos", new Class[0]);
    private ReflectMethod onUnhandledKeyEventXWalkViewInternalKeyEventMethod = new ReflectMethod(null, "onUnhandledKeyEvent", new Class[0]);
    private ReflectMethod openFileChooserXWalkViewInternalValueCallbackStringStringMethod = new ReflectMethod(null, "openFileChooser", new Class[0]);
    private ReflectMethod postWrapperMethod;
    private ReflectMethod shouldOverrideKeyEventXWalkViewInternalKeyEventMethod = new ReflectMethod(null, "shouldOverrideKeyEvent", new Class[0]);

    public enum InitiateBy {
        BY_USER_GESTURE,
        BY_JAVASCRIPT;

        static {
            AppMethodBeat.o(85853);
        }
    }

    public enum JavascriptMessageType {
        JAVASCRIPT_ALERT,
        JAVASCRIPT_CONFIRM,
        JAVASCRIPT_PROMPT,
        JAVASCRIPT_BEFOREUNLOAD;

        static {
            AppMethodBeat.o(85856);
        }
    }

    public enum ConsoleMessageType {
        DEBUG,
        ERROR,
        LOG,
        INFO,
        WARNING;

        static {
            AppMethodBeat.o(85850);
        }
    }

    public enum LoadStatus {
        FINISHED,
        FAILED,
        CANCELLED;

        static {
            AppMethodBeat.o(85859);
        }
    }

    static {
        AppMethodBeat.i(85895);
        AppMethodBeat.o(85895);
    }

    private Object ConvertJavascriptMessageType(JavascriptMessageType javascriptMessageType) {
        AppMethodBeat.i(85860);
        Object invoke = this.enumJavascriptMessageTypeClassValueOfMethod.invoke(javascriptMessageType.toString());
        AppMethodBeat.o(85860);
        return invoke;
    }

    private Object ConvertConsoleMessageType(ConsoleMessageType consoleMessageType) {
        AppMethodBeat.i(85861);
        Object invoke = this.enumConsoleMessageTypeClassValueOfMethod.invoke(consoleMessageType.toString());
        AppMethodBeat.o(85861);
        return invoke;
    }

    private Object ConvertInitiateBy(InitiateBy initiateBy) {
        AppMethodBeat.i(85862);
        Object invoke = this.enumInitiateByClassValueOfMethod.invoke(initiateBy.toString());
        AppMethodBeat.o(85862);
        return invoke;
    }

    private Object ConvertLoadStatus(LoadStatus loadStatus) {
        AppMethodBeat.i(85863);
        Object invoke = this.enumLoadStatusClassValueOfMethod.invoke(loadStatus.toString());
        AppMethodBeat.o(85863);
        return invoke;
    }

    /* Access modifiers changed, original: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkUIClient(XWalkView xWalkView) {
        AppMethodBeat.i(85864);
        this.constructorTypes.add("XWalkViewBridge");
        this.constructorParams = new ArrayList();
        this.constructorParams.add(xWalkView);
        reflectionInit();
        AppMethodBeat.o(85864);
    }

    public boolean onSelectInfoChanged(XWalkView xWalkView, long j, String str, String str2, String str3) {
        AppMethodBeat.i(85865);
        try {
            boolean booleanValue = ((Boolean) this.onSelectInfoChangedXWalkViewInternallongStringStringStringCallbackMethod.invoke(xWalkView.getBridge(), Long.valueOf(j), str, str2, str3)).booleanValue();
            AppMethodBeat.o(85865);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85865);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85865);
            return false;
        }
    }

    public boolean isSearchable() {
        AppMethodBeat.i(85866);
        try {
            boolean booleanValue = ((Boolean) this.isSearchableMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.o(85866);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85866);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85866);
            return false;
        }
    }

    public void onShowSos() {
        AppMethodBeat.i(85867);
        try {
            this.onShowSosMethod.invoke(new Object[0]);
            AppMethodBeat.o(85867);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85867);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85867);
        }
    }

    public boolean onSearchWord(XWalkView xWalkView, String str, String str2, String str3) {
        AppMethodBeat.i(85868);
        try {
            boolean booleanValue = ((Boolean) this.onSearchWordXWalkViewInternalStringStringStringCallbackMethod.invoke(xWalkView.getBridge(), str, str2, str3)).booleanValue();
            AppMethodBeat.o(85868);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85868);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85868);
            return false;
        }
    }

    public boolean onCreateWindowRequested(XWalkView xWalkView, InitiateBy initiateBy, ValueCallback<XWalkView> valueCallback) {
        AppMethodBeat.i(85869);
        try {
            boolean booleanValue = ((Boolean) this.onCreateWindowRequestedXWalkViewInternalInitiateByInternalValueCallbackMethod.invoke(xWalkView.getBridge(), ConvertInitiateBy(initiateBy), valueCallback)).booleanValue();
            AppMethodBeat.o(85869);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85869);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85869);
            return false;
        }
    }

    public void onDidChangeThemeColor(XWalkView xWalkView, int i) {
        AppMethodBeat.i(85870);
        try {
            this.onDidChangeThemeColorXWalkViewInternalStringMessageMethod.invoke(xWalkView.getBridge(), Integer.valueOf(i));
            AppMethodBeat.o(85870);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85870);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85870);
        }
    }

    public boolean shouldDiscardCurrentPage() {
        return false;
    }

    public void onClearCurrentPage() {
    }

    public void onIconAvailable(XWalkView xWalkView, String str, Message message) {
        AppMethodBeat.i(85871);
        try {
            this.onIconAvailableXWalkViewInternalStringMessageMethod.invoke(xWalkView.getBridge(), str, message);
            AppMethodBeat.o(85871);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85871);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85871);
        }
    }

    public void onReceivedIcon(XWalkView xWalkView, String str, Bitmap bitmap) {
        AppMethodBeat.i(85872);
        try {
            this.onReceivedIconXWalkViewInternalStringBitmapMethod.invoke(xWalkView.getBridge(), str, bitmap);
            AppMethodBeat.o(85872);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85872);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85872);
        }
    }

    public void onRequestFocus(XWalkView xWalkView) {
        AppMethodBeat.i(85873);
        try {
            this.onRequestFocusXWalkViewInternalMethod.invoke(xWalkView.getBridge());
            AppMethodBeat.o(85873);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85873);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85873);
        }
    }

    public void onJavascriptCloseWindow(XWalkView xWalkView) {
        AppMethodBeat.i(85874);
        try {
            this.onJavascriptCloseWindowXWalkViewInternalMethod.invoke(xWalkView.getBridge());
            AppMethodBeat.o(85874);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85874);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85874);
        }
    }

    public boolean onJavascriptModalDialog(XWalkView xWalkView, JavascriptMessageType javascriptMessageType, String str, String str2, String str3, XWalkJavascriptResult xWalkJavascriptResult) {
        AppMethodBeat.i(85875);
        try {
            boolean booleanValue = ((Boolean) this.onJavascriptModalDialogXWalkViewInternalJavascriptMessageTypeInternalStringStringStringXWalkJavascriptResultInternalMethod.invoke(xWalkView.getBridge(), ConvertJavascriptMessageType(javascriptMessageType), str, str2, str3, ((XWalkJavascriptResultHandler) xWalkJavascriptResult).getBridge())).booleanValue();
            AppMethodBeat.o(85875);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85875);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85875);
            return false;
        }
    }

    public void onFullscreenToggled(XWalkView xWalkView, boolean z) {
        AppMethodBeat.i(85876);
        try {
            this.onFullscreenToggledXWalkViewInternalbooleanMethod.invoke(xWalkView.getBridge(), Boolean.valueOf(z));
            AppMethodBeat.o(85876);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85876);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85876);
        }
    }

    public void openFileChooser(XWalkView xWalkView, ValueCallback<Uri> valueCallback, String str, String str2) {
        AppMethodBeat.i(85877);
        try {
            this.openFileChooserXWalkViewInternalValueCallbackStringStringMethod.invoke(xWalkView.getBridge(), valueCallback, str, str2);
            AppMethodBeat.o(85877);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85877);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85877);
        }
    }

    public void onScaleChanged(XWalkView xWalkView, float f, float f2) {
        AppMethodBeat.i(85878);
        try {
            this.onScaleChangedXWalkViewInternalfloatfloatMethod.invoke(xWalkView.getBridge(), Float.valueOf(f), Float.valueOf(f2));
            AppMethodBeat.o(85878);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85878);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85878);
        }
    }

    public boolean shouldOverrideKeyEvent(XWalkView xWalkView, KeyEvent keyEvent) {
        AppMethodBeat.i(85879);
        try {
            boolean booleanValue = ((Boolean) this.shouldOverrideKeyEventXWalkViewInternalKeyEventMethod.invoke(xWalkView.getBridge(), keyEvent)).booleanValue();
            AppMethodBeat.o(85879);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85879);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85879);
            return false;
        }
    }

    public void onUnhandledKeyEvent(XWalkView xWalkView, KeyEvent keyEvent) {
        AppMethodBeat.i(85880);
        try {
            this.onUnhandledKeyEventXWalkViewInternalKeyEventMethod.invoke(xWalkView.getBridge(), keyEvent);
            AppMethodBeat.o(85880);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85880);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85880);
        }
    }

    public boolean onConsoleMessage(XWalkView xWalkView, String str, int i, String str2, ConsoleMessageType consoleMessageType) {
        AppMethodBeat.i(85881);
        try {
            boolean booleanValue = ((Boolean) this.onConsoleMessageXWalkViewInternalStringintStringConsoleMessageTypeMethod.invoke(xWalkView.getBridge(), str, Integer.valueOf(i), str2, ConvertConsoleMessageType(consoleMessageType))).booleanValue();
            AppMethodBeat.o(85881);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85881);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85881);
            return false;
        }
    }

    public void onReceivedTitle(XWalkView xWalkView, String str) {
        AppMethodBeat.i(85882);
        try {
            this.onReceivedTitleXWalkViewInternalStringMethod.invoke(xWalkView.getBridge(), str);
            AppMethodBeat.o(85882);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85882);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85882);
        }
    }

    public void onPageLoadStarted(XWalkView xWalkView, String str) {
        AppMethodBeat.i(85883);
        try {
            this.onPageLoadStartedXWalkViewInternalStringMethod.invoke(xWalkView.getBridge(), str);
            AppMethodBeat.o(85883);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85883);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85883);
        }
    }

    public void onPageLoadStopped(XWalkView xWalkView, String str, LoadStatus loadStatus) {
        AppMethodBeat.i(85884);
        try {
            this.onPageLoadStoppedXWalkViewInternalStringLoadStatusInternalMethod.invoke(xWalkView.getBridge(), str, ConvertLoadStatus(loadStatus));
            AppMethodBeat.o(85884);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85884);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85884);
        }
    }

    public boolean onJsAlert(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
        AppMethodBeat.i(85885);
        try {
            boolean booleanValue = ((Boolean) this.onJsAlertXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.invoke(xWalkView.getBridge(), str, str2, ((XWalkJavascriptResultHandler) xWalkJavascriptResult).getBridge())).booleanValue();
            AppMethodBeat.o(85885);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85885);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85885);
            return false;
        }
    }

    public boolean onJsConfirm(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
        AppMethodBeat.i(85886);
        try {
            boolean booleanValue = ((Boolean) this.onJsConfirmXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.invoke(xWalkView.getBridge(), str, str2, ((XWalkJavascriptResultHandler) xWalkJavascriptResult).getBridge())).booleanValue();
            AppMethodBeat.o(85886);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85886);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85886);
            return false;
        }
    }

    public boolean onJsPrompt(XWalkView xWalkView, String str, String str2, String str3, XWalkJavascriptResult xWalkJavascriptResult) {
        AppMethodBeat.i(85887);
        try {
            boolean booleanValue = ((Boolean) this.onJsPromptXWalkViewInternalStringStringStringXWalkJavascriptResultInternalMethod.invoke(xWalkView.getBridge(), str, str2, str3, ((XWalkJavascriptResultHandler) xWalkJavascriptResult).getBridge())).booleanValue();
            AppMethodBeat.o(85887);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85887);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85887);
            return false;
        }
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        AppMethodBeat.i(85888);
        try {
            this.onShowCustomViewViewCustomViewCallbackInternalMethod.invoke(view, ((CustomViewCallbackHandler) customViewCallback).getBridge());
            AppMethodBeat.o(85888);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85888);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85888);
        }
    }

    public void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        AppMethodBeat.i(85889);
        try {
            this.onShowCustomViewViewintCustomViewCallbackInternalMethod.invoke(view, Integer.valueOf(i), ((CustomViewCallbackHandler) customViewCallback).getBridge());
            AppMethodBeat.o(85889);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85889);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85889);
        }
    }

    public void onHideCustomView() {
        AppMethodBeat.i(85890);
        try {
            this.onHideCustomViewMethod.invoke(new Object[0]);
            AppMethodBeat.o(85890);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85890);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85890);
        }
    }

    public void onGeolocationPermissionsShowPrompt(String str, XWalkGeolocationPermissionsCallback xWalkGeolocationPermissionsCallback) {
        AppMethodBeat.i(85891);
        try {
            this.onGeolocationPermissionsShowPromptStringXWalkGeolocationPermissionsCallbackInternalMethod.invoke(str, ((XWalkGeolocationPermissionsCallbackHandler) xWalkGeolocationPermissionsCallback).getBridge());
            AppMethodBeat.o(85891);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85891);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85891);
        }
    }

    public void onGeolocationPermissionsHidePrompt() {
        AppMethodBeat.i(85892);
        try {
            this.onGeolocationPermissionsHidePromptMethod.invoke(new Object[0]);
            AppMethodBeat.o(85892);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85892);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85892);
        }
    }

    public View getVideoLoadingProgressView() {
        AppMethodBeat.i(85893);
        try {
            View view = (View) this.getVideoLoadingProgressViewMethod.invoke(new Object[0]);
            AppMethodBeat.o(85893);
            return view;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85893);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85893);
            return null;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void reflectionInit() {
        AppMethodBeat.i(85894);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.o(85894);
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
                AppMethodBeat.o(85894);
                throw assertionError;
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkUIClientBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.enumJavascriptMessageTypeClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$JavascriptMessageTypeInternal"), "valueOf", String.class);
            this.enumConsoleMessageTypeClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$ConsoleMessageType"), "valueOf", String.class);
            this.enumInitiateByClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$InitiateByInternal"), "valueOf", String.class);
            this.enumLoadStatusClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$LoadStatusInternal"), "valueOf", String.class);
            this.onCreateWindowRequestedXWalkViewInternalInitiateByInternalValueCallbackMethod.init(this.bridge, null, "onCreateWindowRequestedSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkUIClientInternal$InitiateByInternal"), ValueCallback.class);
            this.onDidChangeThemeColorXWalkViewInternalStringMessageMethod.init(this.bridge, null, "onDidChangeThemeColorSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), Integer.TYPE);
            this.onIconAvailableXWalkViewInternalStringMessageMethod.init(this.bridge, null, "onIconAvailableSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Message.class);
            this.onReceivedIconXWalkViewInternalStringBitmapMethod.init(this.bridge, null, "onReceivedIconSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Bitmap.class);
            this.onRequestFocusXWalkViewInternalMethod.init(this.bridge, null, "onRequestFocusSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"));
            this.onJavascriptCloseWindowXWalkViewInternalMethod.init(this.bridge, null, "onJavascriptCloseWindowSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"));
            this.onJavascriptModalDialogXWalkViewInternalJavascriptMessageTypeInternalStringStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, null, "onJavascriptModalDialogSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkUIClientInternal$JavascriptMessageTypeInternal"), String.class, String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge"));
            this.onFullscreenToggledXWalkViewInternalbooleanMethod.init(this.bridge, null, "onFullscreenToggledSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), Boolean.TYPE);
            this.openFileChooserXWalkViewInternalValueCallbackStringStringMethod.init(this.bridge, null, "openFileChooserSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), ValueCallback.class, String.class, String.class);
            this.onScaleChangedXWalkViewInternalfloatfloatMethod.init(this.bridge, null, "onScaleChangedSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), Float.TYPE, Float.TYPE);
            this.shouldOverrideKeyEventXWalkViewInternalKeyEventMethod.init(this.bridge, null, "shouldOverrideKeyEventSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), KeyEvent.class);
            this.onUnhandledKeyEventXWalkViewInternalKeyEventMethod.init(this.bridge, null, "onUnhandledKeyEventSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), KeyEvent.class);
            this.onConsoleMessageXWalkViewInternalStringintStringConsoleMessageTypeMethod.init(this.bridge, null, "onConsoleMessageSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Integer.TYPE, String.class, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$ConsoleMessageType"));
            this.onReceivedTitleXWalkViewInternalStringMethod.init(this.bridge, null, "onReceivedTitleSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class);
            this.onPageLoadStartedXWalkViewInternalStringMethod.init(this.bridge, null, "onPageLoadStartedSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class);
            this.onPageLoadStoppedXWalkViewInternalStringLoadStatusInternalMethod.init(this.bridge, null, "onPageLoadStoppedSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$LoadStatusInternal"));
            this.onJsAlertXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, null, "onJsAlertSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge"));
            this.onJsConfirmXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, null, "onJsConfirmSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge"));
            this.onJsPromptXWalkViewInternalStringStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, null, "onJsPromptSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge"));
            this.onShowCustomViewViewCustomViewCallbackInternalMethod.init(this.bridge, null, "onShowCustomViewSuper", View.class, this.coreWrapper.getBridgeClass("CustomViewCallbackHandlerBridge"));
            this.onShowCustomViewViewintCustomViewCallbackInternalMethod.init(this.bridge, null, "onShowCustomViewSuper", View.class, Integer.TYPE, this.coreWrapper.getBridgeClass("CustomViewCallbackHandlerBridge"));
            this.onHideCustomViewMethod.init(this.bridge, null, "onHideCustomViewSuper", new Class[0]);
            this.onGeolocationPermissionsShowPromptStringXWalkGeolocationPermissionsCallbackInternalMethod.init(this.bridge, null, "onGeolocationPermissionsShowPromptSuper", String.class, this.coreWrapper.getBridgeClass("XWalkGeolocationPermissionsCallbackHandlerBridge"));
            this.onGeolocationPermissionsHidePromptMethod.init(this.bridge, null, "onGeolocationPermissionsHidePromptSuper", new Class[0]);
            this.getVideoLoadingProgressViewMethod.init(this.bridge, null, "getVideoLoadingProgressView", new Class[0]);
            this.onSelectInfoChangedXWalkViewInternallongStringStringStringCallbackMethod.init(this.bridge, null, "onSelectInfoChanged", this.coreWrapper.getBridgeClass("XWalkViewBridge"), Long.TYPE, String.class, String.class, String.class);
            this.isSearchableMethod.init(this.bridge, null, "isSearchable", new Class[0]);
            this.onShowSosMethod.init(this.bridge, null, "onShowSos", new Class[0]);
            this.onSearchWordXWalkViewInternalStringStringStringCallbackMethod.init(this.bridge, null, "onSearchWord", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, String.class, String.class);
            AppMethodBeat.o(85894);
        } catch (UnsupportedOperationException e) {
            AppMethodBeat.o(85894);
        }
    }
}
