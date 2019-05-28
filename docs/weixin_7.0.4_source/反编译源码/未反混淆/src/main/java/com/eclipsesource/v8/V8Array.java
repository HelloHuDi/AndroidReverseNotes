package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class V8Array extends V8Object {

    static class Undefined extends V8Array {
        public boolean isUndefined() {
            return true;
        }

        public boolean isReleased() {
            return false;
        }

        public void release() {
        }

        public Undefined twin() {
            AppMethodBeat.i(75344);
            Undefined undefined = (Undefined) super.twin();
            AppMethodBeat.o(75344);
            return undefined;
        }

        public String toString() {
            return "undefined";
        }

        public boolean equals(Object obj) {
            AppMethodBeat.i(75345);
            if ((obj instanceof V8Object) && ((V8Object) obj).isUndefined()) {
                AppMethodBeat.o(75345);
                return true;
            }
            AppMethodBeat.o(75345);
            return false;
        }

        public int hashCode() {
            return 919;
        }

        public V8 getRuntime() {
            AppMethodBeat.i(75346);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75346);
            throw unsupportedOperationException;
        }

        public V8Object add(String str, boolean z) {
            AppMethodBeat.i(75347);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75347);
            throw unsupportedOperationException;
        }

        public V8Object add(String str, double d) {
            AppMethodBeat.i(75348);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75348);
            throw unsupportedOperationException;
        }

        public V8Object add(String str, int i) {
            AppMethodBeat.i(75349);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75349);
            throw unsupportedOperationException;
        }

        public V8Object add(String str, String str2) {
            AppMethodBeat.i(75350);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75350);
            throw unsupportedOperationException;
        }

        public V8Object add(String str, V8Value v8Value) {
            AppMethodBeat.i(75351);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75351);
            throw unsupportedOperationException;
        }

        public V8Object addUndefined(String str) {
            AppMethodBeat.i(75352);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75352);
            throw unsupportedOperationException;
        }

        public boolean contains(String str) {
            AppMethodBeat.i(75353);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75353);
            throw unsupportedOperationException;
        }

        public V8Array executeArrayFunction(String str, V8Array v8Array) {
            AppMethodBeat.i(75354);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75354);
            throw unsupportedOperationException;
        }

        public boolean executeBooleanFunction(String str, V8Array v8Array) {
            AppMethodBeat.i(75355);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75355);
            throw unsupportedOperationException;
        }

        public double executeDoubleFunction(String str, V8Array v8Array) {
            AppMethodBeat.i(75356);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75356);
            throw unsupportedOperationException;
        }

        public int executeIntegerFunction(String str, V8Array v8Array) {
            AppMethodBeat.i(75357);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75357);
            throw unsupportedOperationException;
        }

        public V8Object executeObjectFunction(String str, V8Array v8Array) {
            AppMethodBeat.i(75358);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75358);
            throw unsupportedOperationException;
        }

        public String executeStringFunction(String str, V8Array v8Array) {
            AppMethodBeat.i(75359);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75359);
            throw unsupportedOperationException;
        }

        public void executeVoidFunction(String str, V8Array v8Array) {
            AppMethodBeat.i(75360);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75360);
            throw unsupportedOperationException;
        }

        public V8Array getArray(String str) {
            AppMethodBeat.i(75361);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75361);
            throw unsupportedOperationException;
        }

        public boolean getBoolean(String str) {
            AppMethodBeat.i(75362);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75362);
            throw unsupportedOperationException;
        }

        public double getDouble(String str) {
            AppMethodBeat.i(75363);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75363);
            throw unsupportedOperationException;
        }

        public int getInteger(String str) {
            AppMethodBeat.i(75364);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75364);
            throw unsupportedOperationException;
        }

        public String[] getKeys() {
            AppMethodBeat.i(75365);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75365);
            throw unsupportedOperationException;
        }

        public V8Object getObject(String str) {
            AppMethodBeat.i(75366);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75366);
            throw unsupportedOperationException;
        }

        public String getString(String str) {
            AppMethodBeat.i(75367);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75367);
            throw unsupportedOperationException;
        }

        public int getType(String str) {
            AppMethodBeat.i(75368);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75368);
            throw unsupportedOperationException;
        }

        public V8Object registerJavaMethod(JavaCallback javaCallback, String str) {
            AppMethodBeat.i(75369);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75369);
            throw unsupportedOperationException;
        }

        public V8Object registerJavaMethod(JavaVoidCallback javaVoidCallback, String str) {
            AppMethodBeat.i(75370);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75370);
            throw unsupportedOperationException;
        }

        public V8Object registerJavaMethod(Object obj, String str, String str2, Class<?>[] clsArr, boolean z) {
            AppMethodBeat.i(75371);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75371);
            throw unsupportedOperationException;
        }

        public V8Object setPrototype(V8Object v8Object) {
            AppMethodBeat.i(75372);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75372);
            throw unsupportedOperationException;
        }

        public Object get(int i) {
            AppMethodBeat.i(75373);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75373);
            throw unsupportedOperationException;
        }

        public V8Array getArray(int i) {
            AppMethodBeat.i(75374);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75374);
            throw unsupportedOperationException;
        }

        public boolean getBoolean(int i) {
            AppMethodBeat.i(75375);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75375);
            throw unsupportedOperationException;
        }

        public boolean[] getBooleans(int i, int i2) {
            AppMethodBeat.i(75376);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75376);
            throw unsupportedOperationException;
        }

        public byte[] getBytes(int i, int i2) {
            AppMethodBeat.i(75377);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75377);
            throw unsupportedOperationException;
        }

        public int getBytes(int i, int i2, byte[] bArr) {
            AppMethodBeat.i(75378);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75378);
            throw unsupportedOperationException;
        }

        public byte getByte(int i) {
            AppMethodBeat.i(75379);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75379);
            throw unsupportedOperationException;
        }

        public int getBooleans(int i, int i2, boolean[] zArr) {
            AppMethodBeat.i(75380);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75380);
            throw unsupportedOperationException;
        }

        public double getDouble(int i) {
            AppMethodBeat.i(75381);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75381);
            throw unsupportedOperationException;
        }

        public double[] getDoubles(int i, int i2) {
            AppMethodBeat.i(75382);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75382);
            throw unsupportedOperationException;
        }

        public int getDoubles(int i, int i2, double[] dArr) {
            AppMethodBeat.i(75383);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75383);
            throw unsupportedOperationException;
        }

        public int getInteger(int i) {
            AppMethodBeat.i(75384);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75384);
            throw unsupportedOperationException;
        }

        public int[] getIntegers(int i, int i2) {
            AppMethodBeat.i(75385);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75385);
            throw unsupportedOperationException;
        }

        public int getIntegers(int i, int i2, int[] iArr) {
            AppMethodBeat.i(75386);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75386);
            throw unsupportedOperationException;
        }

        public V8Object getObject(int i) {
            AppMethodBeat.i(75387);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75387);
            throw unsupportedOperationException;
        }

        public String getString(int i) {
            AppMethodBeat.i(75388);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75388);
            throw unsupportedOperationException;
        }

        public String[] getStrings(int i, int i2) {
            AppMethodBeat.i(75389);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75389);
            throw unsupportedOperationException;
        }

        public int getStrings(int i, int i2, String[] strArr) {
            AppMethodBeat.i(75390);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75390);
            throw unsupportedOperationException;
        }

        public int getType() {
            AppMethodBeat.i(75391);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75391);
            throw unsupportedOperationException;
        }

        public int getType(int i) {
            AppMethodBeat.i(75392);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75392);
            throw unsupportedOperationException;
        }

        public int getType(int i, int i2) {
            AppMethodBeat.i(75393);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75393);
            throw unsupportedOperationException;
        }

        public int length() {
            AppMethodBeat.i(75394);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75394);
            throw unsupportedOperationException;
        }

        public V8Array push(boolean z) {
            AppMethodBeat.i(75395);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75395);
            throw unsupportedOperationException;
        }

        public V8Array push(double d) {
            AppMethodBeat.i(75396);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75396);
            throw unsupportedOperationException;
        }

        public V8Array push(int i) {
            AppMethodBeat.i(75397);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75397);
            throw unsupportedOperationException;
        }

        public V8Array push(String str) {
            AppMethodBeat.i(75398);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75398);
            throw unsupportedOperationException;
        }

        public V8Array push(V8Value v8Value) {
            AppMethodBeat.i(75399);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75399);
            throw unsupportedOperationException;
        }

        public V8Array pushUndefined() {
            AppMethodBeat.i(75400);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(75400);
            throw unsupportedOperationException;
        }
    }

    protected V8Array() {
    }

    public V8Array(V8 v8) {
        super(v8);
        AppMethodBeat.i(75404);
        v8.checkThread();
        AppMethodBeat.o(75404);
    }

    protected V8Array(V8 v8, Object obj) {
        super(v8, obj);
    }

    /* Access modifiers changed, original: protected */
    public V8Value createTwin() {
        AppMethodBeat.i(75405);
        V8Array v8Array = new V8Array(this.v8);
        AppMethodBeat.o(75405);
        return v8Array;
    }

    public V8Array twin() {
        AppMethodBeat.i(75406);
        V8Array v8Array = (V8Array) super.twin();
        AppMethodBeat.o(75406);
        return v8Array;
    }

    public String toString() {
        AppMethodBeat.i(75407);
        String str;
        if (this.released || this.v8.isReleased()) {
            str = "[Array released]";
            AppMethodBeat.o(75407);
            return str;
        }
        str = super.toString();
        AppMethodBeat.o(75407);
        return str;
    }

    /* Access modifiers changed, original: protected */
    public void initialize(long j, Object obj) {
        AppMethodBeat.i(75408);
        long initNewV8Array = this.v8.initNewV8Array(j);
        this.released = false;
        addObjectReference(initNewV8Array);
        AppMethodBeat.o(75408);
    }

    public int length() {
        AppMethodBeat.i(75409);
        this.v8.checkThread();
        checkReleased();
        int arrayGetSize = this.v8.arrayGetSize(this.v8.getV8RuntimePtr(), getHandle());
        AppMethodBeat.o(75409);
        return arrayGetSize;
    }

    public int getType(int i) {
        AppMethodBeat.i(75410);
        this.v8.checkThread();
        checkReleased();
        int type = this.v8.getType(this.v8.getV8RuntimePtr(), getHandle(), i);
        AppMethodBeat.o(75410);
        return type;
    }

    public int getType() {
        AppMethodBeat.i(75411);
        this.v8.checkThread();
        checkReleased();
        int arrayType = this.v8.getArrayType(this.v8.getV8RuntimePtr(), getHandle());
        AppMethodBeat.o(75411);
        return arrayType;
    }

    public int getType(int i, int i2) {
        AppMethodBeat.i(75412);
        this.v8.checkThread();
        checkReleased();
        int type = this.v8.getType(this.v8.getV8RuntimePtr(), getHandle(), i, i2);
        AppMethodBeat.o(75412);
        return type;
    }

    public int getInteger(int i) {
        AppMethodBeat.i(75413);
        this.v8.checkThread();
        checkReleased();
        int arrayGetInteger = this.v8.arrayGetInteger(this.v8.getV8RuntimePtr(), getHandle(), i);
        AppMethodBeat.o(75413);
        return arrayGetInteger;
    }

    public boolean getBoolean(int i) {
        AppMethodBeat.i(75414);
        this.v8.checkThread();
        checkReleased();
        boolean arrayGetBoolean = this.v8.arrayGetBoolean(this.v8.getV8RuntimePtr(), getHandle(), i);
        AppMethodBeat.o(75414);
        return arrayGetBoolean;
    }

    public byte getByte(int i) {
        AppMethodBeat.i(75415);
        this.v8.checkThread();
        checkReleased();
        byte arrayGetByte = this.v8.arrayGetByte(this.v8.getV8RuntimePtr(), getHandle(), i);
        AppMethodBeat.o(75415);
        return arrayGetByte;
    }

    public double getDouble(int i) {
        AppMethodBeat.i(75416);
        this.v8.checkThread();
        checkReleased();
        double arrayGetDouble = this.v8.arrayGetDouble(this.v8.getV8RuntimePtr(), getHandle(), i);
        AppMethodBeat.o(75416);
        return arrayGetDouble;
    }

    public String getString(int i) {
        AppMethodBeat.i(75417);
        this.v8.checkThread();
        checkReleased();
        String arrayGetString = this.v8.arrayGetString(this.v8.getV8RuntimePtr(), getHandle(), i);
        AppMethodBeat.o(75417);
        return arrayGetString;
    }

    public int[] getIntegers(int i, int i2) {
        AppMethodBeat.i(75418);
        this.v8.checkThread();
        checkReleased();
        int[] arrayGetIntegers = this.v8.arrayGetIntegers(this.v8.getV8RuntimePtr(), getHandle(), i, i2);
        AppMethodBeat.o(75418);
        return arrayGetIntegers;
    }

    public int getIntegers(int i, int i2, int[] iArr) {
        AppMethodBeat.i(75419);
        this.v8.checkThread();
        checkReleased();
        if (i2 > iArr.length) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.o(75419);
            throw indexOutOfBoundsException;
        }
        int arrayGetIntegers = this.v8.arrayGetIntegers(this.v8.getV8RuntimePtr(), getHandle(), i, i2, iArr);
        AppMethodBeat.o(75419);
        return arrayGetIntegers;
    }

    public double[] getDoubles(int i, int i2) {
        AppMethodBeat.i(75420);
        this.v8.checkThread();
        checkReleased();
        double[] arrayGetDoubles = this.v8.arrayGetDoubles(this.v8.getV8RuntimePtr(), getHandle(), i, i2);
        AppMethodBeat.o(75420);
        return arrayGetDoubles;
    }

    public int getDoubles(int i, int i2, double[] dArr) {
        AppMethodBeat.i(75421);
        this.v8.checkThread();
        checkReleased();
        if (i2 > dArr.length) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.o(75421);
            throw indexOutOfBoundsException;
        }
        int arrayGetDoubles = this.v8.arrayGetDoubles(this.v8.getV8RuntimePtr(), getHandle(), i, i2, dArr);
        AppMethodBeat.o(75421);
        return arrayGetDoubles;
    }

    public boolean[] getBooleans(int i, int i2) {
        AppMethodBeat.i(75422);
        this.v8.checkThread();
        checkReleased();
        boolean[] arrayGetBooleans = this.v8.arrayGetBooleans(this.v8.getV8RuntimePtr(), getHandle(), i, i2);
        AppMethodBeat.o(75422);
        return arrayGetBooleans;
    }

    public byte[] getBytes(int i, int i2) {
        AppMethodBeat.i(75423);
        this.v8.checkThread();
        checkReleased();
        byte[] arrayGetBytes = this.v8.arrayGetBytes(this.v8.getV8RuntimePtr(), getHandle(), i, i2);
        AppMethodBeat.o(75423);
        return arrayGetBytes;
    }

    public int getBooleans(int i, int i2, boolean[] zArr) {
        AppMethodBeat.i(75424);
        this.v8.checkThread();
        checkReleased();
        if (i2 > zArr.length) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.o(75424);
            throw indexOutOfBoundsException;
        }
        int arrayGetBooleans = this.v8.arrayGetBooleans(this.v8.getV8RuntimePtr(), getHandle(), i, i2, zArr);
        AppMethodBeat.o(75424);
        return arrayGetBooleans;
    }

    public int getBytes(int i, int i2, byte[] bArr) {
        AppMethodBeat.i(75425);
        this.v8.checkThread();
        checkReleased();
        if (i2 > bArr.length) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.o(75425);
            throw indexOutOfBoundsException;
        }
        int arrayGetBytes = this.v8.arrayGetBytes(this.v8.getV8RuntimePtr(), getHandle(), i, i2, bArr);
        AppMethodBeat.o(75425);
        return arrayGetBytes;
    }

    public String[] getStrings(int i, int i2) {
        AppMethodBeat.i(75426);
        this.v8.checkThread();
        checkReleased();
        String[] arrayGetStrings = this.v8.arrayGetStrings(this.v8.getV8RuntimePtr(), getHandle(), i, i2);
        AppMethodBeat.o(75426);
        return arrayGetStrings;
    }

    public int getStrings(int i, int i2, String[] strArr) {
        AppMethodBeat.i(75427);
        this.v8.checkThread();
        checkReleased();
        if (i2 > strArr.length) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.o(75427);
            throw indexOutOfBoundsException;
        }
        int arrayGetStrings = this.v8.arrayGetStrings(this.v8.getV8RuntimePtr(), getHandle(), i, i2, strArr);
        AppMethodBeat.o(75427);
        return arrayGetStrings;
    }

    public Object get(int i) {
        AppMethodBeat.i(75428);
        this.v8.checkThread();
        checkReleased();
        Object arrayGet = this.v8.arrayGet(this.v8.getV8RuntimePtr(), 6, this.objectHandle, i);
        AppMethodBeat.o(75428);
        return arrayGet;
    }

    public V8Array getArray(int i) {
        AppMethodBeat.i(75429);
        this.v8.checkThread();
        checkReleased();
        Object arrayGet = this.v8.arrayGet(this.v8.getV8RuntimePtr(), 5, this.objectHandle, i);
        if (arrayGet == null || (arrayGet instanceof V8Array)) {
            V8Array v8Array = (V8Array) arrayGet;
            AppMethodBeat.o(75429);
            return v8Array;
        }
        V8ResultUndefined v8ResultUndefined = new V8ResultUndefined();
        AppMethodBeat.o(75429);
        throw v8ResultUndefined;
    }

    public V8Object getObject(int i) {
        AppMethodBeat.i(75430);
        this.v8.checkThread();
        checkReleased();
        Object arrayGet = this.v8.arrayGet(this.v8.getV8RuntimePtr(), 6, this.objectHandle, i);
        if (arrayGet == null || (arrayGet instanceof V8Object)) {
            V8Object v8Object = (V8Object) arrayGet;
            AppMethodBeat.o(75430);
            return v8Object;
        }
        V8ResultUndefined v8ResultUndefined = new V8ResultUndefined();
        AppMethodBeat.o(75430);
        throw v8ResultUndefined;
    }

    public V8Array push(int i) {
        AppMethodBeat.i(75431);
        this.v8.checkThread();
        checkReleased();
        this.v8.addArrayIntItem(this.v8.getV8RuntimePtr(), getHandle(), i);
        AppMethodBeat.o(75431);
        return this;
    }

    public V8Array push(boolean z) {
        AppMethodBeat.i(75432);
        this.v8.checkThread();
        checkReleased();
        this.v8.addArrayBooleanItem(this.v8.getV8RuntimePtr(), getHandle(), z);
        AppMethodBeat.o(75432);
        return this;
    }

    public V8Array push(double d) {
        AppMethodBeat.i(75433);
        this.v8.checkThread();
        checkReleased();
        this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), d);
        AppMethodBeat.o(75433);
        return this;
    }

    public V8Array push(String str) {
        AppMethodBeat.i(75434);
        this.v8.checkThread();
        checkReleased();
        if (str == null) {
            this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
        } else if (str.equals(V8.getUndefined())) {
            this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
        } else {
            this.v8.addArrayStringItem(this.v8.getV8RuntimePtr(), getHandle(), str);
        }
        AppMethodBeat.o(75434);
        return this;
    }

    public V8Array push(V8Value v8Value) {
        AppMethodBeat.i(75435);
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Value);
        if (v8Value == null) {
            this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
        } else if (v8Value.equals(V8.getUndefined())) {
            this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
        } else {
            this.v8.addArrayObjectItem(this.v8.getV8RuntimePtr(), getHandle(), v8Value.getHandle());
        }
        AppMethodBeat.o(75435);
        return this;
    }

    public V8Array push(Object obj) {
        AppMethodBeat.i(75436);
        this.v8.checkThread();
        checkReleased();
        if (obj instanceof V8Value) {
            this.v8.checkRuntime((V8Value) obj);
        }
        if (obj == null) {
            this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
        } else if (obj.equals(V8.getUndefined())) {
            this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
        } else if (obj instanceof Double) {
            this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), ((Double) obj).doubleValue());
        } else if (obj instanceof Integer) {
            this.v8.addArrayIntItem(this.v8.getV8RuntimePtr(), getHandle(), ((Integer) obj).intValue());
        } else if (obj instanceof Float) {
            this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), ((Float) obj).doubleValue());
        } else if (obj instanceof Number) {
            this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), ((Number) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            this.v8.addArrayBooleanItem(this.v8.getV8RuntimePtr(), getHandle(), ((Boolean) obj).booleanValue());
        } else if (obj instanceof String) {
            this.v8.addArrayStringItem(this.v8.getV8RuntimePtr(), getHandle(), (String) obj);
        } else if (obj instanceof V8Value) {
            this.v8.addArrayObjectItem(this.v8.getV8RuntimePtr(), getHandle(), ((V8Value) obj).getHandle());
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(75436);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(75436);
        return this;
    }

    public V8Array pushNull() {
        AppMethodBeat.i(75437);
        this.v8.checkThread();
        checkReleased();
        this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
        AppMethodBeat.o(75437);
        return this;
    }

    public V8Array pushUndefined() {
        AppMethodBeat.i(75438);
        this.v8.checkThread();
        checkReleased();
        this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
        AppMethodBeat.o(75438);
        return this;
    }
}
