package com.eclipsesource.p097v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

/* renamed from: com.eclipsesource.v8.V8Object */
public class V8Object extends V8Value {

    /* renamed from: com.eclipsesource.v8.V8Object$Undefined */
    static class Undefined extends V8Object {
        public boolean isUndefined() {
            return true;
        }

        public boolean isReleased() {
            return false;
        }

        public void release() {
        }

        public Undefined twin() {
            AppMethodBeat.m2504i(75508);
            Undefined undefined = (Undefined) super.twin();
            AppMethodBeat.m2505o(75508);
            return undefined;
        }

        public String toString() {
            return "undefined";
        }

        public boolean equals(Object obj) {
            AppMethodBeat.m2504i(75509);
            if ((obj instanceof V8Object) && ((V8Object) obj).isUndefined()) {
                AppMethodBeat.m2505o(75509);
                return true;
            }
            AppMethodBeat.m2505o(75509);
            return false;
        }

        public int hashCode() {
            return 919;
        }

        public V8Object add(String str, boolean z) {
            AppMethodBeat.m2504i(75510);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75510);
            throw unsupportedOperationException;
        }

        public C45010V8 getRuntime() {
            AppMethodBeat.m2504i(75511);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75511);
            throw unsupportedOperationException;
        }

        public V8Object add(String str, double d) {
            AppMethodBeat.m2504i(75512);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75512);
            throw unsupportedOperationException;
        }

        public V8Object add(String str, int i) {
            AppMethodBeat.m2504i(75513);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75513);
            throw unsupportedOperationException;
        }

        public Object executeJSFunction(String str, Object... objArr) {
            AppMethodBeat.m2504i(75514);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75514);
            throw unsupportedOperationException;
        }

        public Object executeFunction(String str, V8Array v8Array) {
            AppMethodBeat.m2504i(75515);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75515);
            throw unsupportedOperationException;
        }

        public V8Object add(String str, String str2) {
            AppMethodBeat.m2504i(75516);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75516);
            throw unsupportedOperationException;
        }

        public V8Object add(String str, V8Value v8Value) {
            AppMethodBeat.m2504i(75517);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75517);
            throw unsupportedOperationException;
        }

        public V8Object addUndefined(String str) {
            AppMethodBeat.m2504i(75518);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75518);
            throw unsupportedOperationException;
        }

        public boolean contains(String str) {
            AppMethodBeat.m2504i(75519);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75519);
            throw unsupportedOperationException;
        }

        public V8Array executeArrayFunction(String str, V8Array v8Array) {
            AppMethodBeat.m2504i(75520);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75520);
            throw unsupportedOperationException;
        }

        public boolean executeBooleanFunction(String str, V8Array v8Array) {
            AppMethodBeat.m2504i(75521);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75521);
            throw unsupportedOperationException;
        }

        public double executeDoubleFunction(String str, V8Array v8Array) {
            AppMethodBeat.m2504i(75522);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75522);
            throw unsupportedOperationException;
        }

        public int executeIntegerFunction(String str, V8Array v8Array) {
            AppMethodBeat.m2504i(75523);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75523);
            throw unsupportedOperationException;
        }

        public V8Object executeObjectFunction(String str, V8Array v8Array) {
            AppMethodBeat.m2504i(75524);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75524);
            throw unsupportedOperationException;
        }

        public String executeStringFunction(String str, V8Array v8Array) {
            AppMethodBeat.m2504i(75525);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75525);
            throw unsupportedOperationException;
        }

        public void executeVoidFunction(String str, V8Array v8Array) {
            AppMethodBeat.m2504i(75526);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75526);
            throw unsupportedOperationException;
        }

        public V8Array getArray(String str) {
            AppMethodBeat.m2504i(75527);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75527);
            throw unsupportedOperationException;
        }

        public boolean getBoolean(String str) {
            AppMethodBeat.m2504i(75528);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75528);
            throw unsupportedOperationException;
        }

        public double getDouble(String str) {
            AppMethodBeat.m2504i(75529);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75529);
            throw unsupportedOperationException;
        }

        public int getInteger(String str) {
            AppMethodBeat.m2504i(75530);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75530);
            throw unsupportedOperationException;
        }

        public String[] getKeys() {
            AppMethodBeat.m2504i(75531);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75531);
            throw unsupportedOperationException;
        }

        public V8Object getObject(String str) {
            AppMethodBeat.m2504i(75532);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75532);
            throw unsupportedOperationException;
        }

        public String getString(String str) {
            AppMethodBeat.m2504i(75533);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75533);
            throw unsupportedOperationException;
        }

        public int getType(String str) {
            AppMethodBeat.m2504i(75534);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75534);
            throw unsupportedOperationException;
        }

        public V8Object registerJavaMethod(JavaCallback javaCallback, String str) {
            AppMethodBeat.m2504i(75535);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75535);
            throw unsupportedOperationException;
        }

        public V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str) {
            AppMethodBeat.m2504i(75536);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75536);
            throw unsupportedOperationException;
        }

        public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z) {
            AppMethodBeat.m2504i(75537);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75537);
            throw unsupportedOperationException;
        }

        public V8Object setPrototype(V8Object v8Object) {
            AppMethodBeat.m2504i(75538);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(75538);
            throw unsupportedOperationException;
        }
    }

    public V8Object(C45010V8 c45010v8) {
        this(c45010v8, null);
    }

    protected V8Object(C45010V8 c45010v8, Object obj) {
        super(c45010v8);
        AppMethodBeat.m2504i(75541);
        if (c45010v8 != null) {
            this.f14672v8.checkThread();
            initialize(this.f14672v8.getV8RuntimePtr(), obj);
        }
        AppMethodBeat.m2505o(75541);
    }

    protected V8Object() {
    }

    /* Access modifiers changed, original: protected */
    public V8Value createTwin() {
        AppMethodBeat.m2504i(75542);
        V8Object v8Object = new V8Object(this.f14672v8);
        AppMethodBeat.m2505o(75542);
        return v8Object;
    }

    public V8Object twin() {
        AppMethodBeat.m2504i(75543);
        V8Object v8Object = (V8Object) super.twin();
        AppMethodBeat.m2505o(75543);
        return v8Object;
    }

    public boolean contains(String str) {
        AppMethodBeat.m2504i(75544);
        this.f14672v8.checkThread();
        checkReleased();
        checkKey(str);
        boolean contains = this.f14672v8.contains(this.f14672v8.getV8RuntimePtr(), this.objectHandle, str);
        AppMethodBeat.m2505o(75544);
        return contains;
    }

    public String[] getKeys() {
        AppMethodBeat.m2504i(75545);
        this.f14672v8.checkThread();
        checkReleased();
        String[] keys = this.f14672v8.getKeys(this.f14672v8.getV8RuntimePtr(), this.objectHandle);
        AppMethodBeat.m2505o(75545);
        return keys;
    }

    public int getType(String str) {
        AppMethodBeat.m2504i(75546);
        this.f14672v8.checkThread();
        checkReleased();
        checkKey(str);
        int type = this.f14672v8.getType(this.f14672v8.getV8RuntimePtr(), this.objectHandle, str);
        AppMethodBeat.m2505o(75546);
        return type;
    }

    public Object get(String str) {
        AppMethodBeat.m2504i(75547);
        this.f14672v8.checkThread();
        checkReleased();
        checkKey(str);
        Object obj = this.f14672v8.get(this.f14672v8.getV8RuntimePtr(), 6, this.objectHandle, str);
        AppMethodBeat.m2505o(75547);
        return obj;
    }

    public int getInteger(String str) {
        AppMethodBeat.m2504i(75548);
        this.f14672v8.checkThread();
        checkReleased();
        checkKey(str);
        int integer = this.f14672v8.getInteger(this.f14672v8.getV8RuntimePtr(), this.objectHandle, str);
        AppMethodBeat.m2505o(75548);
        return integer;
    }

    public boolean getBoolean(String str) {
        AppMethodBeat.m2504i(75549);
        this.f14672v8.checkThread();
        checkReleased();
        checkKey(str);
        boolean z = this.f14672v8.getBoolean(this.f14672v8.getV8RuntimePtr(), this.objectHandle, str);
        AppMethodBeat.m2505o(75549);
        return z;
    }

    public double getDouble(String str) {
        AppMethodBeat.m2504i(75550);
        this.f14672v8.checkThread();
        checkReleased();
        checkKey(str);
        double d = this.f14672v8.getDouble(this.f14672v8.getV8RuntimePtr(), this.objectHandle, str);
        AppMethodBeat.m2505o(75550);
        return d;
    }

    public String getString(String str) {
        AppMethodBeat.m2504i(75551);
        this.f14672v8.checkThread();
        checkReleased();
        checkKey(str);
        String string = this.f14672v8.getString(this.f14672v8.getV8RuntimePtr(), this.objectHandle, str);
        AppMethodBeat.m2505o(75551);
        return string;
    }

    public V8Array getArray(String str) {
        AppMethodBeat.m2504i(75552);
        this.f14672v8.checkThread();
        checkReleased();
        checkKey(str);
        Object obj = this.f14672v8.get(this.f14672v8.getV8RuntimePtr(), 5, this.objectHandle, str);
        if (obj == null || (obj instanceof V8Array)) {
            V8Array v8Array = (V8Array) obj;
            AppMethodBeat.m2505o(75552);
            return v8Array;
        }
        V8ResultUndefined v8ResultUndefined = new V8ResultUndefined();
        AppMethodBeat.m2505o(75552);
        throw v8ResultUndefined;
    }

    public V8Object getObject(String str) {
        AppMethodBeat.m2504i(75553);
        this.f14672v8.checkThread();
        checkReleased();
        checkKey(str);
        Object obj = this.f14672v8.get(this.f14672v8.getV8RuntimePtr(), 6, this.objectHandle, str);
        if (obj == null || (obj instanceof V8Object)) {
            V8Object v8Object = (V8Object) obj;
            AppMethodBeat.m2505o(75553);
            return v8Object;
        }
        V8ResultUndefined v8ResultUndefined = new V8ResultUndefined();
        AppMethodBeat.m2505o(75553);
        throw v8ResultUndefined;
    }

    public int executeIntegerFunction(String str, V8Array v8Array) {
        AppMethodBeat.m2504i(75554);
        this.f14672v8.checkThread();
        checkReleased();
        this.f14672v8.checkRuntime(v8Array);
        int executeIntegerFunction = this.f14672v8.executeIntegerFunction(this.f14672v8.getV8RuntimePtr(), getHandle(), str, v8Array == null ? 0 : v8Array.getHandle());
        AppMethodBeat.m2505o(75554);
        return executeIntegerFunction;
    }

    public double executeDoubleFunction(String str, V8Array v8Array) {
        AppMethodBeat.m2504i(75555);
        this.f14672v8.checkThread();
        checkReleased();
        this.f14672v8.checkRuntime(v8Array);
        double executeDoubleFunction = this.f14672v8.executeDoubleFunction(this.f14672v8.getV8RuntimePtr(), getHandle(), str, v8Array == null ? 0 : v8Array.getHandle());
        AppMethodBeat.m2505o(75555);
        return executeDoubleFunction;
    }

    public String executeStringFunction(String str, V8Array v8Array) {
        AppMethodBeat.m2504i(75556);
        this.f14672v8.checkThread();
        checkReleased();
        this.f14672v8.checkRuntime(v8Array);
        String executeStringFunction = this.f14672v8.executeStringFunction(this.f14672v8.getV8RuntimePtr(), getHandle(), str, v8Array == null ? 0 : v8Array.getHandle());
        AppMethodBeat.m2505o(75556);
        return executeStringFunction;
    }

    public boolean executeBooleanFunction(String str, V8Array v8Array) {
        AppMethodBeat.m2504i(75557);
        this.f14672v8.checkThread();
        checkReleased();
        this.f14672v8.checkRuntime(v8Array);
        boolean executeBooleanFunction = this.f14672v8.executeBooleanFunction(this.f14672v8.getV8RuntimePtr(), getHandle(), str, v8Array == null ? 0 : v8Array.getHandle());
        AppMethodBeat.m2505o(75557);
        return executeBooleanFunction;
    }

    public V8Array executeArrayFunction(String str, V8Array v8Array) {
        AppMethodBeat.m2504i(75558);
        this.f14672v8.checkThread();
        checkReleased();
        this.f14672v8.checkRuntime(v8Array);
        Object executeFunction = this.f14672v8.executeFunction(this.f14672v8.getV8RuntimePtr(), 5, this.objectHandle, str, v8Array == null ? 0 : v8Array.getHandle());
        if (executeFunction instanceof V8Array) {
            V8Array v8Array2 = (V8Array) executeFunction;
            AppMethodBeat.m2505o(75558);
            return v8Array2;
        }
        V8ResultUndefined v8ResultUndefined = new V8ResultUndefined();
        AppMethodBeat.m2505o(75558);
        throw v8ResultUndefined;
    }

    public V8Object executeObjectFunction(String str, V8Array v8Array) {
        AppMethodBeat.m2504i(75559);
        this.f14672v8.checkThread();
        checkReleased();
        this.f14672v8.checkRuntime(v8Array);
        Object executeFunction = this.f14672v8.executeFunction(this.f14672v8.getV8RuntimePtr(), 6, this.objectHandle, str, v8Array == null ? 0 : v8Array.getHandle());
        if (executeFunction instanceof V8Object) {
            V8Object v8Object = (V8Object) executeFunction;
            AppMethodBeat.m2505o(75559);
            return v8Object;
        }
        V8ResultUndefined v8ResultUndefined = new V8ResultUndefined();
        AppMethodBeat.m2505o(75559);
        throw v8ResultUndefined;
    }

    public Object executeFunction(String str, V8Array v8Array) {
        AppMethodBeat.m2504i(75560);
        this.f14672v8.checkThread();
        checkReleased();
        this.f14672v8.checkRuntime(v8Array);
        Object executeFunction = this.f14672v8.executeFunction(this.f14672v8.getV8RuntimePtr(), 0, this.objectHandle, str, v8Array == null ? 0 : v8Array.getHandle());
        AppMethodBeat.m2505o(75560);
        return executeFunction;
    }

    public Object executeJSFunction(String str) {
        AppMethodBeat.m2504i(75561);
        Object executeFunction = executeFunction(str, null);
        AppMethodBeat.m2505o(75561);
        return executeFunction;
    }

    public Object executeJSFunction(String str, Object... objArr) {
        AppMethodBeat.m2504i(75562);
        Object executeFunction;
        if (objArr == null) {
            executeFunction = executeFunction(str, null);
            AppMethodBeat.m2505o(75562);
            return executeFunction;
        }
        V8Array v8Array = new V8Array(this.f14672v8.getRuntime());
        try {
            for (Object executeFunction2 : objArr) {
                if (executeFunction2 == null) {
                    v8Array.pushNull();
                } else if (executeFunction2 instanceof V8Value) {
                    v8Array.push((V8Value) executeFunction2);
                } else if (executeFunction2 instanceof Integer) {
                    v8Array.push((Integer) executeFunction2);
                } else if (executeFunction2 instanceof Double) {
                    v8Array.push((Double) executeFunction2);
                } else if (executeFunction2 instanceof Long) {
                    v8Array.push(((Long) executeFunction2).doubleValue());
                } else if (executeFunction2 instanceof Float) {
                    v8Array.push((double) ((Float) executeFunction2).floatValue());
                } else if (executeFunction2 instanceof Boolean) {
                    v8Array.push((Boolean) executeFunction2);
                } else if (executeFunction2 instanceof String) {
                    v8Array.push((String) executeFunction2);
                } else {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported Object of type: " + executeFunction2.getClass());
                    AppMethodBeat.m2505o(75562);
                    throw illegalArgumentException;
                }
            }
            executeFunction2 = executeFunction(str, v8Array);
            return executeFunction2;
        } finally {
            v8Array.release();
            AppMethodBeat.m2505o(75562);
        }
    }

    public void executeVoidFunction(String str, V8Array v8Array) {
        AppMethodBeat.m2504i(75563);
        this.f14672v8.checkThread();
        checkReleased();
        this.f14672v8.checkRuntime(v8Array);
        this.f14672v8.executeVoidFunction(this.f14672v8.getV8RuntimePtr(), this.objectHandle, str, v8Array == null ? 0 : v8Array.getHandle());
        AppMethodBeat.m2505o(75563);
    }

    public V8Object add(String str, int i) {
        AppMethodBeat.m2504i(75564);
        this.f14672v8.checkThread();
        checkReleased();
        this.f14672v8.add(this.f14672v8.getV8RuntimePtr(), this.objectHandle, str, i);
        AppMethodBeat.m2505o(75564);
        return this;
    }

    public V8Object add(String str, boolean z) {
        AppMethodBeat.m2504i(75565);
        this.f14672v8.checkThread();
        checkReleased();
        this.f14672v8.add(this.f14672v8.getV8RuntimePtr(), this.objectHandle, str, z);
        AppMethodBeat.m2505o(75565);
        return this;
    }

    public V8Object add(String str, double d) {
        AppMethodBeat.m2504i(75566);
        this.f14672v8.checkThread();
        checkReleased();
        this.f14672v8.add(this.f14672v8.getV8RuntimePtr(), this.objectHandle, str, d);
        AppMethodBeat.m2505o(75566);
        return this;
    }

    public V8Object add(String str, String str2) {
        AppMethodBeat.m2504i(75567);
        this.f14672v8.checkThread();
        checkReleased();
        if (str2 == null) {
            this.f14672v8.addNull(this.f14672v8.getV8RuntimePtr(), this.objectHandle, str);
        } else if (str2.equals(C45010V8.getUndefined())) {
            this.f14672v8.addUndefined(this.f14672v8.getV8RuntimePtr(), this.objectHandle, str);
        } else {
            this.f14672v8.add(this.f14672v8.getV8RuntimePtr(), this.objectHandle, str, str2);
        }
        AppMethodBeat.m2505o(75567);
        return this;
    }

    public V8Object add(String str, V8Value v8Value) {
        AppMethodBeat.m2504i(75568);
        this.f14672v8.checkThread();
        checkReleased();
        this.f14672v8.checkRuntime(v8Value);
        if (v8Value == null) {
            this.f14672v8.addNull(this.f14672v8.getV8RuntimePtr(), this.objectHandle, str);
        } else if (v8Value.equals(C45010V8.getUndefined())) {
            this.f14672v8.addUndefined(this.f14672v8.getV8RuntimePtr(), this.objectHandle, str);
        } else {
            this.f14672v8.addObject(this.f14672v8.getV8RuntimePtr(), this.objectHandle, str, v8Value.getHandle());
        }
        AppMethodBeat.m2505o(75568);
        return this;
    }

    public V8Object addUndefined(String str) {
        AppMethodBeat.m2504i(75569);
        this.f14672v8.checkThread();
        checkReleased();
        this.f14672v8.addUndefined(this.f14672v8.getV8RuntimePtr(), this.objectHandle, str);
        AppMethodBeat.m2505o(75569);
        return this;
    }

    public V8Object addNull(String str) {
        AppMethodBeat.m2504i(75570);
        this.f14672v8.checkThread();
        checkReleased();
        this.f14672v8.addNull(this.f14672v8.getV8RuntimePtr(), this.objectHandle, str);
        AppMethodBeat.m2505o(75570);
        return this;
    }

    public V8Object setPrototype(V8Object v8Object) {
        AppMethodBeat.m2504i(75571);
        this.f14672v8.checkThread();
        checkReleased();
        this.f14672v8.setPrototype(this.f14672v8.getV8RuntimePtr(), this.objectHandle, v8Object.getHandle());
        AppMethodBeat.m2505o(75571);
        return this;
    }

    public V8Object registerJavaMethod(JavaCallback javaCallback, String str) {
        AppMethodBeat.m2504i(75572);
        this.f14672v8.checkThread();
        checkReleased();
        this.f14672v8.registerCallback(javaCallback, getHandle(), str);
        AppMethodBeat.m2505o(75572);
        return this;
    }

    public V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str) {
        AppMethodBeat.m2504i(75573);
        this.f14672v8.checkThread();
        checkReleased();
        this.f14672v8.registerVoidCallback(javaVoidCallback, getHandle(), str);
        AppMethodBeat.m2505o(75573);
        return this;
    }

    public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr) {
        AppMethodBeat.m2504i(75574);
        V8Object registerJavaMethod = registerJavaMethod(obj, str, str2, clsArr, false);
        AppMethodBeat.m2505o(75574);
        return registerJavaMethod;
    }

    public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z) {
        IllegalStateException illegalStateException;
        AppMethodBeat.m2504i(75575);
        this.f14672v8.checkThread();
        checkReleased();
        try {
            Method method = obj.getClass().getMethod(str, clsArr);
            method.setAccessible(true);
            this.f14672v8.registerCallback(obj, method, getHandle(), str2, z);
            AppMethodBeat.m2505o(75575);
            return this;
        } catch (NoSuchMethodException e) {
            illegalStateException = new IllegalStateException(e);
            AppMethodBeat.m2505o(75575);
            throw illegalStateException;
        } catch (SecurityException e2) {
            illegalStateException = new IllegalStateException(e2);
            AppMethodBeat.m2505o(75575);
            throw illegalStateException;
        }
    }

    public String toString() {
        AppMethodBeat.m2504i(75576);
        String str;
        if (isReleased() || this.f14672v8.isReleased()) {
            str = "[Object released]";
            AppMethodBeat.m2505o(75576);
            return str;
        }
        this.f14672v8.checkThread();
        str = this.f14672v8.toString(this.f14672v8.getV8RuntimePtr(), getHandle());
        AppMethodBeat.m2505o(75576);
        return str;
    }

    private void checkKey(String str) {
        AppMethodBeat.m2504i(75577);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Key cannot be null");
            AppMethodBeat.m2505o(75577);
            throw illegalArgumentException;
        }
        AppMethodBeat.m2505o(75577);
    }
}
