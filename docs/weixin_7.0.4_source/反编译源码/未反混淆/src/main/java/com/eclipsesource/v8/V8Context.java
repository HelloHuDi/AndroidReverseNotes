package com.eclipsesource.v8;

import java.nio.ByteBuffer;

public interface V8Context {
    V8Object add(String str, double d);

    V8Object add(String str, int i);

    V8Object add(String str, V8Value v8Value);

    V8Object add(String str, String str2);

    V8Object add(String str, boolean z);

    V8Object addNull(String str);

    V8Object addUndefined(String str);

    boolean contains(String str);

    V8Array executeArrayFunction(String str, V8Array v8Array);

    V8Array executeArrayScript(String str);

    V8Array executeArrayScript(String str, String str2, int i);

    V8Array executeArrayScript(String str, String str2, int i, String str3, String str4);

    boolean executeBooleanFunction(String str, V8Array v8Array);

    boolean executeBooleanScript(String str);

    boolean executeBooleanScript(String str, String str2, int i);

    boolean executeBooleanScript(String str, String str2, int i, String str3, String str4);

    String executeDebugScript(String str, String str2);

    double executeDoubleFunction(String str, V8Array v8Array);

    double executeDoubleScript(String str);

    double executeDoubleScript(String str, String str2, int i);

    double executeDoubleScript(String str, String str2, int i, String str3, String str4);

    Object executeFunction(String str, V8Array v8Array);

    int executeIntegerFunction(String str, V8Array v8Array);

    int executeIntegerScript(String str);

    int executeIntegerScript(String str, String str2, int i);

    int executeIntegerScript(String str, String str2, int i, String str3, String str4);

    Object executeJSFunction(String str);

    Object executeJSFunction(String str, Object... objArr);

    V8Object executeObjectFunction(String str, V8Array v8Array);

    V8Object executeObjectScript(String str);

    V8Object executeObjectScript(String str, String str2, int i);

    V8Object executeObjectScript(String str, String str2, int i, String str3, String str4);

    Object executeScript(String str);

    Object executeScript(String str, String str2, int i);

    Object executeScript(String str, String str2, int i, String str3, String str4);

    String executeStringFunction(String str, V8Array v8Array);

    String executeStringScript(String str);

    String executeStringScript(String str, String str2, int i);

    String executeStringScript(String str, String str2, int i, String str3, String str4);

    void executeVoidFunction(String str, V8Array v8Array);

    void executeVoidScript(String str);

    void executeVoidScript(String str, String str2, int i);

    void executeVoidScript(String str, String str2, int i, String str3, String str4);

    Object get(String str);

    V8Array getArray(String str);

    boolean getBoolean(String str);

    double getDouble(String str);

    V8Object getGlobalObject();

    int getInteger(String str);

    String[] getKeys();

    V8Object getObject(String str);

    long getPtr();

    String getString(String str);

    int getType(String str);

    boolean isReleased();

    SharedV8ArrayBuffer newSharedV8ArrayBuffer(ByteBuffer byteBuffer);

    V8Array newV8Array();

    V8ArrayBuffer newV8ArrayBuffer(int i);

    V8ArrayBuffer newV8ArrayBuffer(ByteBuffer byteBuffer);

    V8Function newV8Function(JavaCallback javaCallback);

    V8Object newV8Object();

    V8TypedArray newV8TypedArray(V8ArrayBuffer v8ArrayBuffer, int i, int i2, int i3);

    V8Object registerJavaMethod(JavaCallback javaCallback, String str);

    V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str);

    V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr);

    V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z);

    void release();

    void shareObject(String str, V8Context v8Context);

    void shareObject(String str, V8Context v8Context, String str2);
}
