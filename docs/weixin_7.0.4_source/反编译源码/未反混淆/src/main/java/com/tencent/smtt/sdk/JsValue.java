package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory;
import java.nio.ByteBuffer;

public class JsValue {
    private final JsContext a;
    private final IX5JsValue b;

    static class a implements JsValueFactory {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        public String getJsValueClassName() {
            AppMethodBeat.i(63929);
            String name = JsValue.class.getName();
            AppMethodBeat.o(63929);
            return name;
        }

        public IX5JsValue unwrap(Object obj) {
            AppMethodBeat.i(63930);
            if (obj == null || !(obj instanceof JsValue)) {
                AppMethodBeat.o(63930);
                return null;
            }
            IX5JsValue a = ((JsValue) obj).b;
            AppMethodBeat.o(63930);
            return a;
        }

        public Object wrap(IX5JsValue iX5JsValue) {
            AppMethodBeat.i(63931);
            if (iX5JsValue != null) {
                JsContext current = JsContext.current();
                if (current != null) {
                    JsValue jsValue = new JsValue(current, iX5JsValue);
                    AppMethodBeat.o(63931);
                    return jsValue;
                }
            }
            AppMethodBeat.o(63931);
            return null;
        }
    }

    protected JsValue(JsContext jsContext, IX5JsValue iX5JsValue) {
        this.a = jsContext;
        this.b = iX5JsValue;
    }

    protected static JsValueFactory a() {
        AppMethodBeat.i(63932);
        a aVar = new a();
        AppMethodBeat.o(63932);
        return aVar;
    }

    private JsValue a(IX5JsValue iX5JsValue) {
        AppMethodBeat.i(63956);
        if (iX5JsValue == null) {
            AppMethodBeat.o(63956);
            return null;
        }
        JsValue jsValue = new JsValue(this.a, iX5JsValue);
        AppMethodBeat.o(63956);
        return jsValue;
    }

    public JsValue call(Object... objArr) {
        AppMethodBeat.i(63951);
        JsValue a = a(this.b.call(objArr));
        AppMethodBeat.o(63951);
        return a;
    }

    public JsValue construct(Object... objArr) {
        AppMethodBeat.i(63952);
        JsValue a = a(this.b.construct(objArr));
        AppMethodBeat.o(63952);
        return a;
    }

    public JsContext context() {
        return this.a;
    }

    public boolean isArray() {
        AppMethodBeat.i(63935);
        boolean isArray = this.b.isArray();
        AppMethodBeat.o(63935);
        return isArray;
    }

    public boolean isArrayBufferOrArrayBufferView() {
        AppMethodBeat.i(63948);
        boolean isArrayBufferOrArrayBufferView = this.b.isArrayBufferOrArrayBufferView();
        AppMethodBeat.o(63948);
        return isArrayBufferOrArrayBufferView;
    }

    public boolean isBoolean() {
        AppMethodBeat.i(63936);
        boolean isBoolean = this.b.isBoolean();
        AppMethodBeat.o(63936);
        return isBoolean;
    }

    public boolean isFunction() {
        AppMethodBeat.i(63950);
        boolean isFunction = this.b.isFunction();
        AppMethodBeat.o(63950);
        return isFunction;
    }

    public boolean isInteger() {
        AppMethodBeat.i(63938);
        boolean isInteger = this.b.isInteger();
        AppMethodBeat.o(63938);
        return isInteger;
    }

    public boolean isJavascriptInterface() {
        AppMethodBeat.i(63946);
        boolean isJavascriptInterface = this.b.isJavascriptInterface();
        AppMethodBeat.o(63946);
        return isJavascriptInterface;
    }

    public boolean isNull() {
        AppMethodBeat.i(63934);
        boolean isNull = this.b.isNull();
        AppMethodBeat.o(63934);
        return isNull;
    }

    public boolean isNumber() {
        AppMethodBeat.i(63940);
        boolean isNumber = this.b.isNumber();
        AppMethodBeat.o(63940);
        return isNumber;
    }

    public boolean isObject() {
        AppMethodBeat.i(63944);
        boolean isObject = this.b.isObject();
        AppMethodBeat.o(63944);
        return isObject;
    }

    public boolean isPromise() {
        AppMethodBeat.i(63953);
        boolean isPromise = this.b.isPromise();
        AppMethodBeat.o(63953);
        return isPromise;
    }

    public boolean isString() {
        AppMethodBeat.i(63942);
        boolean isString = this.b.isString();
        AppMethodBeat.o(63942);
        return isString;
    }

    public boolean isUndefined() {
        AppMethodBeat.i(63933);
        boolean isUndefined = this.b.isUndefined();
        AppMethodBeat.o(63933);
        return isUndefined;
    }

    public void reject(Object obj) {
        AppMethodBeat.i(63955);
        this.b.resolveOrReject(obj, false);
        AppMethodBeat.o(63955);
    }

    public void resolve(Object obj) {
        AppMethodBeat.i(63954);
        this.b.resolveOrReject(obj, true);
        AppMethodBeat.o(63954);
    }

    public boolean toBoolean() {
        AppMethodBeat.i(63937);
        boolean toBoolean = this.b.toBoolean();
        AppMethodBeat.o(63937);
        return toBoolean;
    }

    public ByteBuffer toByteBuffer() {
        AppMethodBeat.i(63949);
        ByteBuffer toByteBuffer = this.b.toByteBuffer();
        AppMethodBeat.o(63949);
        return toByteBuffer;
    }

    public int toInteger() {
        AppMethodBeat.i(63939);
        int toInteger = this.b.toInteger();
        AppMethodBeat.o(63939);
        return toInteger;
    }

    public Object toJavascriptInterface() {
        AppMethodBeat.i(63947);
        Object toJavascriptInterface = this.b.toJavascriptInterface();
        AppMethodBeat.o(63947);
        return toJavascriptInterface;
    }

    public Number toNumber() {
        AppMethodBeat.i(63941);
        Number toNumber = this.b.toNumber();
        AppMethodBeat.o(63941);
        return toNumber;
    }

    public <T> T toObject(Class<T> cls) {
        AppMethodBeat.i(63945);
        Object toObject = this.b.toObject(cls);
        AppMethodBeat.o(63945);
        return toObject;
    }

    public String toString() {
        AppMethodBeat.i(63943);
        String iX5JsValue = this.b.toString();
        AppMethodBeat.o(63943);
        return iX5JsValue;
    }
}
