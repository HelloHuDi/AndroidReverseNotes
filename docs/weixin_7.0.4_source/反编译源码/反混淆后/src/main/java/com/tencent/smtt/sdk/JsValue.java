package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory;
import java.nio.ByteBuffer;

public class JsValue {
    /* renamed from: a */
    private final JsContext f15118a;
    /* renamed from: b */
    private final IX5JsValue f15119b;

    /* renamed from: com.tencent.smtt.sdk.JsValue$a */
    static class C36423a implements JsValueFactory {
        private C36423a() {
        }

        /* synthetic */ C36423a(C364241 c364241) {
            this();
        }

        public String getJsValueClassName() {
            AppMethodBeat.m2504i(63929);
            String name = JsValue.class.getName();
            AppMethodBeat.m2505o(63929);
            return name;
        }

        public IX5JsValue unwrap(Object obj) {
            AppMethodBeat.m2504i(63930);
            if (obj == null || !(obj instanceof JsValue)) {
                AppMethodBeat.m2505o(63930);
                return null;
            }
            IX5JsValue a = ((JsValue) obj).f15119b;
            AppMethodBeat.m2505o(63930);
            return a;
        }

        public Object wrap(IX5JsValue iX5JsValue) {
            AppMethodBeat.m2504i(63931);
            if (iX5JsValue != null) {
                JsContext current = JsContext.current();
                if (current != null) {
                    JsValue jsValue = new JsValue(current, iX5JsValue);
                    AppMethodBeat.m2505o(63931);
                    return jsValue;
                }
            }
            AppMethodBeat.m2505o(63931);
            return null;
        }
    }

    protected JsValue(JsContext jsContext, IX5JsValue iX5JsValue) {
        this.f15118a = jsContext;
        this.f15119b = iX5JsValue;
    }

    /* renamed from: a */
    protected static JsValueFactory m60048a() {
        AppMethodBeat.m2504i(63932);
        C36423a c36423a = new C36423a();
        AppMethodBeat.m2505o(63932);
        return c36423a;
    }

    /* renamed from: a */
    private JsValue m60050a(IX5JsValue iX5JsValue) {
        AppMethodBeat.m2504i(63956);
        if (iX5JsValue == null) {
            AppMethodBeat.m2505o(63956);
            return null;
        }
        JsValue jsValue = new JsValue(this.f15118a, iX5JsValue);
        AppMethodBeat.m2505o(63956);
        return jsValue;
    }

    public JsValue call(Object... objArr) {
        AppMethodBeat.m2504i(63951);
        JsValue a = m60050a(this.f15119b.call(objArr));
        AppMethodBeat.m2505o(63951);
        return a;
    }

    public JsValue construct(Object... objArr) {
        AppMethodBeat.m2504i(63952);
        JsValue a = m60050a(this.f15119b.construct(objArr));
        AppMethodBeat.m2505o(63952);
        return a;
    }

    public JsContext context() {
        return this.f15118a;
    }

    public boolean isArray() {
        AppMethodBeat.m2504i(63935);
        boolean isArray = this.f15119b.isArray();
        AppMethodBeat.m2505o(63935);
        return isArray;
    }

    public boolean isArrayBufferOrArrayBufferView() {
        AppMethodBeat.m2504i(63948);
        boolean isArrayBufferOrArrayBufferView = this.f15119b.isArrayBufferOrArrayBufferView();
        AppMethodBeat.m2505o(63948);
        return isArrayBufferOrArrayBufferView;
    }

    public boolean isBoolean() {
        AppMethodBeat.m2504i(63936);
        boolean isBoolean = this.f15119b.isBoolean();
        AppMethodBeat.m2505o(63936);
        return isBoolean;
    }

    public boolean isFunction() {
        AppMethodBeat.m2504i(63950);
        boolean isFunction = this.f15119b.isFunction();
        AppMethodBeat.m2505o(63950);
        return isFunction;
    }

    public boolean isInteger() {
        AppMethodBeat.m2504i(63938);
        boolean isInteger = this.f15119b.isInteger();
        AppMethodBeat.m2505o(63938);
        return isInteger;
    }

    public boolean isJavascriptInterface() {
        AppMethodBeat.m2504i(63946);
        boolean isJavascriptInterface = this.f15119b.isJavascriptInterface();
        AppMethodBeat.m2505o(63946);
        return isJavascriptInterface;
    }

    public boolean isNull() {
        AppMethodBeat.m2504i(63934);
        boolean isNull = this.f15119b.isNull();
        AppMethodBeat.m2505o(63934);
        return isNull;
    }

    public boolean isNumber() {
        AppMethodBeat.m2504i(63940);
        boolean isNumber = this.f15119b.isNumber();
        AppMethodBeat.m2505o(63940);
        return isNumber;
    }

    public boolean isObject() {
        AppMethodBeat.m2504i(63944);
        boolean isObject = this.f15119b.isObject();
        AppMethodBeat.m2505o(63944);
        return isObject;
    }

    public boolean isPromise() {
        AppMethodBeat.m2504i(63953);
        boolean isPromise = this.f15119b.isPromise();
        AppMethodBeat.m2505o(63953);
        return isPromise;
    }

    public boolean isString() {
        AppMethodBeat.m2504i(63942);
        boolean isString = this.f15119b.isString();
        AppMethodBeat.m2505o(63942);
        return isString;
    }

    public boolean isUndefined() {
        AppMethodBeat.m2504i(63933);
        boolean isUndefined = this.f15119b.isUndefined();
        AppMethodBeat.m2505o(63933);
        return isUndefined;
    }

    public void reject(Object obj) {
        AppMethodBeat.m2504i(63955);
        this.f15119b.resolveOrReject(obj, false);
        AppMethodBeat.m2505o(63955);
    }

    public void resolve(Object obj) {
        AppMethodBeat.m2504i(63954);
        this.f15119b.resolveOrReject(obj, true);
        AppMethodBeat.m2505o(63954);
    }

    public boolean toBoolean() {
        AppMethodBeat.m2504i(63937);
        boolean toBoolean = this.f15119b.toBoolean();
        AppMethodBeat.m2505o(63937);
        return toBoolean;
    }

    public ByteBuffer toByteBuffer() {
        AppMethodBeat.m2504i(63949);
        ByteBuffer toByteBuffer = this.f15119b.toByteBuffer();
        AppMethodBeat.m2505o(63949);
        return toByteBuffer;
    }

    public int toInteger() {
        AppMethodBeat.m2504i(63939);
        int toInteger = this.f15119b.toInteger();
        AppMethodBeat.m2505o(63939);
        return toInteger;
    }

    public Object toJavascriptInterface() {
        AppMethodBeat.m2504i(63947);
        Object toJavascriptInterface = this.f15119b.toJavascriptInterface();
        AppMethodBeat.m2505o(63947);
        return toJavascriptInterface;
    }

    public Number toNumber() {
        AppMethodBeat.m2504i(63941);
        Number toNumber = this.f15119b.toNumber();
        AppMethodBeat.m2505o(63941);
        return toNumber;
    }

    public <T> T toObject(Class<T> cls) {
        AppMethodBeat.m2504i(63945);
        Object toObject = this.f15119b.toObject(cls);
        AppMethodBeat.m2505o(63945);
        return toObject;
    }

    public String toString() {
        AppMethodBeat.m2504i(63943);
        String iX5JsValue = this.f15119b.toString();
        AppMethodBeat.m2505o(63943);
        return iX5JsValue;
    }
}
