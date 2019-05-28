package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class ai {
    private ByteBuffer a;
    private String b = "GBK";

    public static class a {
        public byte a;
        public int b;
    }

    public ai(byte[] bArr) {
        AppMethodBeat.i(98427);
        this.a = ByteBuffer.wrap(bArr);
        AppMethodBeat.o(98427);
    }

    public ai(byte[] bArr, byte b) {
        AppMethodBeat.i(98428);
        this.a = ByteBuffer.wrap(bArr);
        this.a.position(4);
        AppMethodBeat.o(98428);
    }

    public final void a(byte[] bArr) {
        AppMethodBeat.i(98429);
        this.a = ByteBuffer.wrap(bArr);
        AppMethodBeat.o(98429);
    }

    private static int a(a aVar, ByteBuffer byteBuffer) {
        AppMethodBeat.i(98430);
        byte b = byteBuffer.get();
        aVar.a = (byte) (b & 15);
        aVar.b = (b & 240) >> 4;
        if (aVar.b == 15) {
            aVar.b = byteBuffer.get() & 255;
            AppMethodBeat.o(98430);
            return 2;
        }
        AppMethodBeat.o(98430);
        return 1;
    }

    private boolean a(int i) {
        AppMethodBeat.i(98431);
        try {
            a aVar = new a();
            while (true) {
                int a = a(aVar, this.a.duplicate());
                if (aVar.a == (byte) 11) {
                    AppMethodBeat.o(98431);
                    return false;
                } else if (i > aVar.b) {
                    this.a.position(a + this.a.position());
                    a(aVar.a);
                } else if (i == aVar.b) {
                    AppMethodBeat.o(98431);
                    return true;
                } else {
                    AppMethodBeat.o(98431);
                    return false;
                }
            }
        } catch (RuntimeException | BufferUnderflowException e) {
            AppMethodBeat.o(98431);
            return false;
        }
    }

    private void a() {
        AppMethodBeat.i(98432);
        a aVar = new a();
        do {
            a(aVar, this.a);
            a(aVar.a);
        } while (aVar.a != (byte) 11);
        AppMethodBeat.o(98432);
    }

    private void a(byte b) {
        int i = 0;
        AppMethodBeat.i(98433);
        int a;
        a aVar;
        RuntimeException runtimeException;
        switch (b) {
            case (byte) 0:
                this.a.position(this.a.position() + 1);
                AppMethodBeat.o(98433);
                return;
            case (byte) 1:
                this.a.position(this.a.position() + 2);
                AppMethodBeat.o(98433);
                return;
            case (byte) 2:
                this.a.position(this.a.position() + 4);
                AppMethodBeat.o(98433);
                return;
            case (byte) 3:
                this.a.position(this.a.position() + 8);
                AppMethodBeat.o(98433);
                return;
            case (byte) 4:
                this.a.position(this.a.position() + 4);
                AppMethodBeat.o(98433);
                return;
            case (byte) 5:
                this.a.position(this.a.position() + 8);
                AppMethodBeat.o(98433);
                return;
            case (byte) 6:
                i = this.a.get();
                if (i < 0) {
                    i += 256;
                }
                this.a.position(i + this.a.position());
                AppMethodBeat.o(98433);
                return;
            case (byte) 7:
                this.a.position(this.a.getInt() + this.a.position());
                AppMethodBeat.o(98433);
                return;
            case (byte) 8:
                a = a(0, 0, true);
                while (i < (a << 1)) {
                    aVar = new a();
                    a(aVar, this.a);
                    a(aVar.a);
                    i++;
                }
                AppMethodBeat.o(98433);
                return;
            case (byte) 9:
                a = a(0, 0, true);
                while (i < a) {
                    aVar = new a();
                    a(aVar, this.a);
                    a(aVar.a);
                    i++;
                }
                AppMethodBeat.o(98433);
                return;
            case (byte) 10:
                a();
                AppMethodBeat.o(98433);
                return;
            case (byte) 11:
            case (byte) 12:
                AppMethodBeat.o(98433);
                return;
            case (byte) 13:
                a aVar2 = new a();
                a(aVar2, this.a);
                if (aVar2.a != (byte) 0) {
                    runtimeException = new RuntimeException("skipField with invalid type, type value: " + b + ", " + aVar2.a);
                    AppMethodBeat.o(98433);
                    throw runtimeException;
                }
                this.a.position(a(0, 0, true) + this.a.position());
                AppMethodBeat.o(98433);
                return;
            default:
                runtimeException = new RuntimeException("invalid type.");
                AppMethodBeat.o(98433);
                throw runtimeException;
        }
    }

    public final byte a(byte b, int i, boolean z) {
        AppMethodBeat.i(98434);
        RuntimeException runtimeException;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 0:
                    b = this.a.get();
                    break;
                case (byte) 12:
                    b = (byte) 0;
                    break;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.o(98434);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.o(98434);
            throw runtimeException;
        }
        AppMethodBeat.o(98434);
        return b;
    }

    public final short a(short s, int i, boolean z) {
        AppMethodBeat.i(98435);
        RuntimeException runtimeException;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 0:
                    s = (short) this.a.get();
                    break;
                case (byte) 1:
                    s = this.a.getShort();
                    break;
                case (byte) 12:
                    s = (short) 0;
                    break;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.o(98435);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.o(98435);
            throw runtimeException;
        }
        AppMethodBeat.o(98435);
        return s;
    }

    public final int a(int i, int i2, boolean z) {
        AppMethodBeat.i(98436);
        RuntimeException runtimeException;
        if (a(i2)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 0:
                    i = this.a.get();
                    break;
                case (byte) 1:
                    i = this.a.getShort();
                    break;
                case (byte) 2:
                    i = this.a.getInt();
                    break;
                case (byte) 12:
                    i = 0;
                    break;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.o(98436);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.o(98436);
            throw runtimeException;
        }
        AppMethodBeat.o(98436);
        return i;
    }

    public final long a(long j, int i, boolean z) {
        AppMethodBeat.i(98437);
        RuntimeException runtimeException;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 0:
                    j = (long) this.a.get();
                    break;
                case (byte) 1:
                    j = (long) this.a.getShort();
                    break;
                case (byte) 2:
                    j = (long) this.a.getInt();
                    break;
                case (byte) 3:
                    j = this.a.getLong();
                    break;
                case (byte) 12:
                    j = 0;
                    break;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.o(98437);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.o(98437);
            throw runtimeException;
        }
        AppMethodBeat.o(98437);
        return j;
    }

    private float a(float f, int i, boolean z) {
        AppMethodBeat.i(98438);
        RuntimeException runtimeException;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 4:
                    f = this.a.getFloat();
                    break;
                case (byte) 12:
                    f = 0.0f;
                    break;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.o(98438);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.o(98438);
            throw runtimeException;
        }
        AppMethodBeat.o(98438);
        return f;
    }

    private double a(double d, int i, boolean z) {
        AppMethodBeat.i(98439);
        RuntimeException runtimeException;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 4:
                    d = (double) this.a.getFloat();
                    break;
                case (byte) 5:
                    d = this.a.getDouble();
                    break;
                case (byte) 12:
                    d = 0.0d;
                    break;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.o(98439);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.o(98439);
            throw runtimeException;
        }
        AppMethodBeat.o(98439);
        return d;
    }

    public final String a(int i, boolean z) {
        AppMethodBeat.i(98440);
        String str = null;
        RuntimeException runtimeException;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            int i2;
            byte[] bArr;
            switch (aVar.a) {
                case (byte) 6:
                    i2 = this.a.get();
                    if (i2 < 0) {
                        i2 += 256;
                    }
                    bArr = new byte[i2];
                    this.a.get(bArr);
                    try {
                        str = new String(bArr, this.b);
                        break;
                    } catch (UnsupportedEncodingException e) {
                        str = new String(bArr);
                        break;
                    }
                case (byte) 7:
                    i2 = this.a.getInt();
                    if (i2 <= 104857600 && i2 >= 0 && i2 <= this.a.capacity()) {
                        bArr = new byte[i2];
                        this.a.get(bArr);
                        try {
                            str = new String(bArr, this.b);
                            break;
                        } catch (UnsupportedEncodingException e2) {
                            str = new String(bArr);
                            break;
                        }
                    }
                    RuntimeException runtimeException2 = new RuntimeException("String too long: ".concat(String.valueOf(i2)));
                    AppMethodBeat.o(98440);
                    throw runtimeException2;
                    break;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.o(98440);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.o(98440);
            throw runtimeException;
        }
        AppMethodBeat.o(98440);
        return str;
    }

    public final <K, V> HashMap<K, V> a(Map<K, V> map) {
        AppMethodBeat.i(98441);
        HashMap hashMap = (HashMap) a(new HashMap(), map, 0, false);
        AppMethodBeat.o(98441);
        return hashMap;
    }

    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        AppMethodBeat.i(98442);
        if (map2 == null || map2.isEmpty()) {
            HashMap hashMap = new HashMap();
            AppMethodBeat.o(98442);
            return hashMap;
        }
        Entry entry = (Entry) map2.entrySet().iterator().next();
        Object key = entry.getKey();
        Object value = entry.getValue();
        RuntimeException runtimeException;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 8:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        for (int i2 = 0; i2 < a; i2++) {
                            map.put(a(key, 0, true), a(value, 1, true));
                        }
                        break;
                    }
                    runtimeException = new RuntimeException("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.o(98442);
                    throw runtimeException;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.o(98442);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.o(98442);
            throw runtimeException;
        }
        AppMethodBeat.o(98442);
        return map;
    }

    private boolean[] c(int i, boolean z) {
        AppMethodBeat.i(98443);
        boolean[] zArr = null;
        RuntimeException runtimeException;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        boolean[] zArr2 = new boolean[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            boolean z2;
                            if (a((byte) 0, 0, true) != (byte) 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            zArr2[i2] = z2;
                        }
                        zArr = zArr2;
                        break;
                    }
                    runtimeException = new RuntimeException("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.o(98443);
                    throw runtimeException;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.o(98443);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.o(98443);
            throw runtimeException;
        }
        AppMethodBeat.o(98443);
        return zArr;
    }

    public final byte[] b(int i, boolean z) {
        AppMethodBeat.i(98444);
        byte[] bArr = null;
        RuntimeException runtimeException;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0 && a <= this.a.capacity()) {
                        bArr = new byte[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            bArr[i2] = a(bArr[0], 0, true);
                        }
                        break;
                    }
                    runtimeException = new RuntimeException("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.o(98444);
                    throw runtimeException;
                    break;
                case (byte) 13:
                    a aVar2 = new a();
                    a(aVar2, this.a);
                    if (aVar2.a == (byte) 0) {
                        int a2 = a(0, 0, true);
                        if (a2 >= 0 && a2 <= this.a.capacity()) {
                            bArr = new byte[a2];
                            this.a.get(bArr);
                            break;
                        }
                        RuntimeException runtimeException2 = new RuntimeException("invalid size, tag: " + i + ", type: " + aVar.a + ", " + aVar2.a + ", size: " + a2);
                        AppMethodBeat.o(98444);
                        throw runtimeException2;
                    }
                    RuntimeException runtimeException3 = new RuntimeException("type mismatch, tag: " + i + ", type: " + aVar.a + ", " + aVar2.a);
                    AppMethodBeat.o(98444);
                    throw runtimeException3;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.o(98444);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.o(98444);
            throw runtimeException;
        }
        AppMethodBeat.o(98444);
        return bArr;
    }

    private short[] d(int i, boolean z) {
        AppMethodBeat.i(98445);
        short[] sArr = null;
        RuntimeException runtimeException;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        sArr = new short[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            sArr[i2] = a(sArr[0], 0, true);
                        }
                        break;
                    }
                    runtimeException = new RuntimeException("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.o(98445);
                    throw runtimeException;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.o(98445);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.o(98445);
            throw runtimeException;
        }
        AppMethodBeat.o(98445);
        return sArr;
    }

    private int[] e(int i, boolean z) {
        AppMethodBeat.i(98446);
        int[] iArr = null;
        RuntimeException runtimeException;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        iArr = new int[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            iArr[i2] = a(iArr[0], 0, true);
                        }
                        break;
                    }
                    runtimeException = new RuntimeException("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.o(98446);
                    throw runtimeException;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.o(98446);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.o(98446);
            throw runtimeException;
        }
        AppMethodBeat.o(98446);
        return iArr;
    }

    private long[] f(int i, boolean z) {
        AppMethodBeat.i(98447);
        long[] jArr = null;
        RuntimeException runtimeException;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        jArr = new long[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            jArr[i2] = a(jArr[0], 0, true);
                        }
                        break;
                    }
                    runtimeException = new RuntimeException("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.o(98447);
                    throw runtimeException;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.o(98447);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.o(98447);
            throw runtimeException;
        }
        AppMethodBeat.o(98447);
        return jArr;
    }

    private float[] g(int i, boolean z) {
        AppMethodBeat.i(98448);
        float[] fArr = null;
        RuntimeException runtimeException;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        fArr = new float[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            fArr[i2] = a(fArr[0], 0, true);
                        }
                        break;
                    }
                    runtimeException = new RuntimeException("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.o(98448);
                    throw runtimeException;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.o(98448);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.o(98448);
            throw runtimeException;
        }
        AppMethodBeat.o(98448);
        return fArr;
    }

    private double[] h(int i, boolean z) {
        AppMethodBeat.i(98449);
        double[] dArr = null;
        RuntimeException runtimeException;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        dArr = new double[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            dArr[i2] = a(dArr[0], 0, true);
                        }
                        break;
                    }
                    runtimeException = new RuntimeException("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.o(98449);
                    throw runtimeException;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.o(98449);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.o(98449);
            throw runtimeException;
        }
        AppMethodBeat.o(98449);
        return dArr;
    }

    private <T> T[] b(T t, int i, boolean z) {
        AppMethodBeat.i(98450);
        RuntimeException runtimeException;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a < 0) {
                        runtimeException = new RuntimeException("size invalid: ".concat(String.valueOf(a)));
                        AppMethodBeat.o(98450);
                        throw runtimeException;
                    }
                    Object[] objArr = (Object[]) Array.newInstance(t.getClass(), a);
                    for (int i2 = 0; i2 < a; i2++) {
                        objArr[i2] = a((Object) t, 0, true);
                    }
                    AppMethodBeat.o(98450);
                    return objArr;
                default:
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.o(98450);
                    throw runtimeException;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.o(98450);
            throw runtimeException;
        } else {
            AppMethodBeat.o(98450);
            return null;
        }
    }

    private ak a(ak akVar, int i, boolean z) {
        AppMethodBeat.i(98451);
        ak akVar2 = null;
        RuntimeException runtimeException;
        if (a(i)) {
            try {
                akVar2 = (ak) akVar.getClass().newInstance();
                a aVar = new a();
                a(aVar, this.a);
                if (aVar.a != (byte) 10) {
                    runtimeException = new RuntimeException("type mismatch.");
                    AppMethodBeat.o(98451);
                    throw runtimeException;
                }
                akVar2.a(this);
                a();
            } catch (Exception e) {
                RuntimeException runtimeException2 = new RuntimeException(e.getMessage());
                AppMethodBeat.o(98451);
                throw runtimeException2;
            }
        } else if (z) {
            runtimeException = new RuntimeException("require field not exist.");
            AppMethodBeat.o(98451);
            throw runtimeException;
        }
        AppMethodBeat.o(98451);
        return akVar2;
    }

    public final <T> Object a(T t, int i, boolean z) {
        int i2 = 0;
        AppMethodBeat.i(98452);
        Object valueOf;
        RuntimeException runtimeException;
        if (t instanceof Byte) {
            Byte valueOf2 = Byte.valueOf(a((byte) 0, i, z));
            AppMethodBeat.o(98452);
            return valueOf2;
        } else if (t instanceof Boolean) {
            boolean z2;
            if (a((byte) 0, i, z) != (byte) 0) {
                z2 = true;
            }
            valueOf = Boolean.valueOf(z2);
            AppMethodBeat.o(98452);
            return valueOf;
        } else if (t instanceof Short) {
            valueOf = Short.valueOf(a((short) 0, i, z));
            AppMethodBeat.o(98452);
            return valueOf;
        } else if (t instanceof Integer) {
            valueOf = Integer.valueOf(a(0, i, z));
            AppMethodBeat.o(98452);
            return valueOf;
        } else if (t instanceof Long) {
            valueOf = Long.valueOf(a(0, i, z));
            AppMethodBeat.o(98452);
            return valueOf;
        } else if (t instanceof Float) {
            valueOf = Float.valueOf(a(0.0f, i, z));
            AppMethodBeat.o(98452);
            return valueOf;
        } else if (t instanceof Double) {
            valueOf = Double.valueOf(a(0.0d, i, z));
            AppMethodBeat.o(98452);
            return valueOf;
        } else if (t instanceof String) {
            valueOf = a(i, z);
            AppMethodBeat.o(98452);
            return valueOf;
        } else if (t instanceof Map) {
            HashMap hashMap = (HashMap) a(new HashMap(), (Map) t, i, z);
            AppMethodBeat.o(98452);
            return hashMap;
        } else if (t instanceof List) {
            List list = (List) t;
            if (list == null || list.isEmpty()) {
                valueOf = new ArrayList();
                AppMethodBeat.o(98452);
                return valueOf;
            }
            Object[] b = b(list.get(0), i, z);
            if (b == null) {
                AppMethodBeat.o(98452);
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (i2 < b.length) {
                arrayList.add(b[i2]);
                i2++;
            }
            AppMethodBeat.o(98452);
            return arrayList;
        } else if (t instanceof ak) {
            valueOf = a((ak) t, i, z);
            AppMethodBeat.o(98452);
            return valueOf;
        } else if (!t.getClass().isArray()) {
            runtimeException = new RuntimeException("read object error: unsupport type.");
            AppMethodBeat.o(98452);
            throw runtimeException;
        } else if ((t instanceof byte[]) || (t instanceof Byte[])) {
            valueOf = b(i, z);
            AppMethodBeat.o(98452);
            return valueOf;
        } else if (t instanceof boolean[]) {
            valueOf = c(i, z);
            AppMethodBeat.o(98452);
            return valueOf;
        } else if (t instanceof short[]) {
            valueOf = d(i, z);
            AppMethodBeat.o(98452);
            return valueOf;
        } else if (t instanceof int[]) {
            valueOf = e(i, z);
            AppMethodBeat.o(98452);
            return valueOf;
        } else if (t instanceof long[]) {
            valueOf = f(i, z);
            AppMethodBeat.o(98452);
            return valueOf;
        } else if (t instanceof float[]) {
            valueOf = g(i, z);
            AppMethodBeat.o(98452);
            return valueOf;
        } else if (t instanceof double[]) {
            valueOf = h(i, z);
            AppMethodBeat.o(98452);
            return valueOf;
        } else {
            Object[] objArr = (Object[]) t;
            if (objArr == null || objArr.length == 0) {
                runtimeException = new RuntimeException("unable to get type of key and value.");
                AppMethodBeat.o(98452);
                throw runtimeException;
            }
            valueOf = b(objArr[0], i, z);
            AppMethodBeat.o(98452);
            return valueOf;
        }
    }

    public final int a(String str) {
        this.b = str;
        return 0;
    }
}
