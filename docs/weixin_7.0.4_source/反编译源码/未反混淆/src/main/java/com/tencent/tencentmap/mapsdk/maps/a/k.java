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

public final class k {
    protected String a = "GBK";
    private ByteBuffer b;

    public static class a {
        public byte a;
        public int b;
    }

    public k(byte[] bArr) {
        AppMethodBeat.i(100157);
        this.b = ByteBuffer.wrap(bArr);
        AppMethodBeat.o(100157);
    }

    public k(byte[] bArr, int i) {
        AppMethodBeat.i(100158);
        this.b = ByteBuffer.wrap(bArr);
        this.b.position(i);
        AppMethodBeat.o(100158);
    }

    public final void a(byte[] bArr) {
        AppMethodBeat.i(100159);
        this.b = ByteBuffer.wrap(bArr);
        AppMethodBeat.o(100159);
    }

    public static int a(a aVar, ByteBuffer byteBuffer) {
        AppMethodBeat.i(100160);
        byte b = byteBuffer.get();
        aVar.a = (byte) (b & 15);
        aVar.b = (b & 240) >> 4;
        if (aVar.b == 15) {
            aVar.b = byteBuffer.get() & 255;
            AppMethodBeat.o(100160);
            return 2;
        }
        AppMethodBeat.o(100160);
        return 1;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(100161);
        a(aVar, this.b);
        AppMethodBeat.o(100161);
    }

    private int b(a aVar) {
        AppMethodBeat.i(100162);
        int a = a(aVar, this.b.duplicate());
        AppMethodBeat.o(100162);
        return a;
    }

    private void b(int i) {
        AppMethodBeat.i(100163);
        this.b.position(this.b.position() + i);
        AppMethodBeat.o(100163);
    }

    public final boolean a(int i) {
        AppMethodBeat.i(100164);
        try {
            a aVar = new a();
            while (true) {
                int b = b(aVar);
                if (i > aVar.b && aVar.a != (byte) 11) {
                    b(b);
                    a(aVar.a);
                }
            }
            if (aVar.a == (byte) 11) {
                AppMethodBeat.o(100164);
                return false;
            } else if (i == aVar.b) {
                AppMethodBeat.o(100164);
                return true;
            } else {
                AppMethodBeat.o(100164);
                return false;
            }
        } catch (h | BufferUnderflowException e) {
            AppMethodBeat.o(100164);
            return false;
        }
    }

    public final void a() {
        AppMethodBeat.i(100165);
        a aVar = new a();
        do {
            a(aVar);
            a(aVar.a);
        } while (aVar.a != (byte) 11);
        AppMethodBeat.o(100165);
    }

    private void b() {
        AppMethodBeat.i(100166);
        a aVar = new a();
        a(aVar);
        a(aVar.a);
        AppMethodBeat.o(100166);
    }

    private void a(byte b) {
        int i = 0;
        AppMethodBeat.i(100167);
        int a;
        h hVar;
        switch (b) {
            case (byte) 0:
                b(1);
                AppMethodBeat.o(100167);
                return;
            case (byte) 1:
                b(2);
                AppMethodBeat.o(100167);
                return;
            case (byte) 2:
                b(4);
                AppMethodBeat.o(100167);
                return;
            case (byte) 3:
                b(8);
                AppMethodBeat.o(100167);
                return;
            case (byte) 4:
                b(4);
                AppMethodBeat.o(100167);
                return;
            case (byte) 5:
                b(8);
                AppMethodBeat.o(100167);
                return;
            case (byte) 6:
                i = this.b.get();
                if (i < 0) {
                    i += 256;
                }
                b(i);
                AppMethodBeat.o(100167);
                return;
            case (byte) 7:
                b(this.b.getInt());
                AppMethodBeat.o(100167);
                return;
            case (byte) 8:
                a = a(0, 0, true);
                while (i < a * 2) {
                    b();
                    i++;
                }
                AppMethodBeat.o(100167);
                return;
            case (byte) 9:
                a = a(0, 0, true);
                while (i < a) {
                    b();
                    i++;
                }
                AppMethodBeat.o(100167);
                return;
            case (byte) 10:
                a();
                AppMethodBeat.o(100167);
                return;
            case (byte) 11:
            case (byte) 12:
                AppMethodBeat.o(100167);
                return;
            case (byte) 13:
                a aVar = new a();
                a(aVar);
                if (aVar.a != (byte) 0) {
                    hVar = new h("skipField with invalid type, type value: " + b + ", " + aVar.a);
                    AppMethodBeat.o(100167);
                    throw hVar;
                }
                b(a(0, 0, true));
                AppMethodBeat.o(100167);
                return;
            default:
                hVar = new h("invalid type.");
                AppMethodBeat.o(100167);
                throw hVar;
        }
    }

    public final boolean a(boolean z, int i, boolean z2) {
        AppMethodBeat.i(100168);
        if (a((byte) 0, i, z2) != (byte) 0) {
            AppMethodBeat.o(100168);
            return true;
        }
        AppMethodBeat.o(100168);
        return false;
    }

    public final byte a(byte b, int i, boolean z) {
        AppMethodBeat.i(100169);
        h hVar;
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 0:
                    b = this.b.get();
                    break;
                case (byte) 12:
                    b = (byte) 0;
                    break;
                default:
                    hVar = new h("type mismatch.");
                    AppMethodBeat.o(100169);
                    throw hVar;
            }
        } else if (z) {
            hVar = new h("require field not exist.");
            AppMethodBeat.o(100169);
            throw hVar;
        }
        AppMethodBeat.o(100169);
        return b;
    }

    public final short a(short s, int i, boolean z) {
        AppMethodBeat.i(100170);
        h hVar;
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 0:
                    s = (short) this.b.get();
                    break;
                case (byte) 1:
                    s = this.b.getShort();
                    break;
                case (byte) 12:
                    s = (short) 0;
                    break;
                default:
                    hVar = new h("type mismatch.");
                    AppMethodBeat.o(100170);
                    throw hVar;
            }
        } else if (z) {
            hVar = new h("require field not exist.");
            AppMethodBeat.o(100170);
            throw hVar;
        }
        AppMethodBeat.o(100170);
        return s;
    }

    public final int a(int i, int i2, boolean z) {
        AppMethodBeat.i(100171);
        h hVar;
        if (a(i2)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 0:
                    i = this.b.get();
                    break;
                case (byte) 1:
                    i = this.b.getShort();
                    break;
                case (byte) 2:
                    i = this.b.getInt();
                    break;
                case (byte) 12:
                    i = 0;
                    break;
                default:
                    hVar = new h("type mismatch.");
                    AppMethodBeat.o(100171);
                    throw hVar;
            }
        } else if (z) {
            hVar = new h("require field not exist.");
            AppMethodBeat.o(100171);
            throw hVar;
        }
        AppMethodBeat.o(100171);
        return i;
    }

    public final long a(long j, int i, boolean z) {
        AppMethodBeat.i(100172);
        h hVar;
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 0:
                    j = (long) this.b.get();
                    break;
                case (byte) 1:
                    j = (long) this.b.getShort();
                    break;
                case (byte) 2:
                    j = (long) this.b.getInt();
                    break;
                case (byte) 3:
                    j = this.b.getLong();
                    break;
                case (byte) 12:
                    j = 0;
                    break;
                default:
                    hVar = new h("type mismatch.");
                    AppMethodBeat.o(100172);
                    throw hVar;
            }
        } else if (z) {
            hVar = new h("require field not exist.");
            AppMethodBeat.o(100172);
            throw hVar;
        }
        AppMethodBeat.o(100172);
        return j;
    }

    public final float a(float f, int i, boolean z) {
        AppMethodBeat.i(100173);
        h hVar;
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 4:
                    f = this.b.getFloat();
                    break;
                case (byte) 12:
                    f = 0.0f;
                    break;
                default:
                    hVar = new h("type mismatch.");
                    AppMethodBeat.o(100173);
                    throw hVar;
            }
        } else if (z) {
            hVar = new h("require field not exist.");
            AppMethodBeat.o(100173);
            throw hVar;
        }
        AppMethodBeat.o(100173);
        return f;
    }

    public final double a(double d, int i, boolean z) {
        AppMethodBeat.i(100174);
        h hVar;
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 4:
                    d = (double) this.b.getFloat();
                    break;
                case (byte) 5:
                    d = this.b.getDouble();
                    break;
                case (byte) 12:
                    d = 0.0d;
                    break;
                default:
                    hVar = new h("type mismatch.");
                    AppMethodBeat.o(100174);
                    throw hVar;
            }
        } else if (z) {
            hVar = new h("require field not exist.");
            AppMethodBeat.o(100174);
            throw hVar;
        }
        AppMethodBeat.o(100174);
        return d;
    }

    public final String a(int i, boolean z) {
        AppMethodBeat.i(100175);
        String str = null;
        h hVar;
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            int i2;
            byte[] bArr;
            switch (aVar.a) {
                case (byte) 6:
                    i2 = this.b.get();
                    if (i2 < 0) {
                        i2 += 256;
                    }
                    bArr = new byte[i2];
                    this.b.get(bArr);
                    try {
                        str = new String(bArr, this.a);
                        break;
                    } catch (UnsupportedEncodingException e) {
                        str = new String(bArr);
                        break;
                    }
                case (byte) 7:
                    i2 = this.b.getInt();
                    if (i2 <= 104857600 && i2 >= 0 && i2 <= this.b.capacity()) {
                        bArr = new byte[i2];
                        this.b.get(bArr);
                        try {
                            str = new String(bArr, this.a);
                            break;
                        } catch (UnsupportedEncodingException e2) {
                            str = new String(bArr);
                            break;
                        }
                    }
                    h hVar2 = new h("String too long: ".concat(String.valueOf(i2)));
                    AppMethodBeat.o(100175);
                    throw hVar2;
                    break;
                default:
                    hVar = new h("type mismatch.");
                    AppMethodBeat.o(100175);
                    throw hVar;
            }
        } else if (z) {
            hVar = new h("require field not exist.");
            AppMethodBeat.o(100175);
            throw hVar;
        }
        AppMethodBeat.o(100175);
        return str;
    }

    public final <K, V> HashMap<K, V> a(Map<K, V> map, int i, boolean z) {
        AppMethodBeat.i(100176);
        HashMap hashMap = (HashMap) a(new HashMap(), map, i, z);
        AppMethodBeat.o(100176);
        return hashMap;
    }

    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        AppMethodBeat.i(100177);
        if (map2 == null || map2.isEmpty()) {
            HashMap hashMap = new HashMap();
            AppMethodBeat.o(100177);
            return hashMap;
        }
        Entry entry = (Entry) map2.entrySet().iterator().next();
        Object key = entry.getKey();
        Object value = entry.getValue();
        h hVar;
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 8:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        for (int i2 = 0; i2 < a; i2++) {
                            map.put(a(key, 0, true), a(value, 1, true));
                        }
                        break;
                    }
                    hVar = new h("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.o(100177);
                    throw hVar;
                default:
                    hVar = new h("type mismatch.");
                    AppMethodBeat.o(100177);
                    throw hVar;
            }
        } else if (z) {
            hVar = new h("require field not exist.");
            AppMethodBeat.o(100177);
            throw hVar;
        }
        AppMethodBeat.o(100177);
        return map;
    }

    public final boolean[] a(boolean[] zArr, int i, boolean z) {
        AppMethodBeat.i(100178);
        boolean[] zArr2 = null;
        h hVar;
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        zArr2 = new boolean[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            zArr2[i2] = a(zArr2[0], 0, true);
                        }
                        break;
                    }
                    hVar = new h("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.o(100178);
                    throw hVar;
                default:
                    hVar = new h("type mismatch.");
                    AppMethodBeat.o(100178);
                    throw hVar;
            }
        } else if (z) {
            hVar = new h("require field not exist.");
            AppMethodBeat.o(100178);
            throw hVar;
        }
        AppMethodBeat.o(100178);
        return zArr2;
    }

    public final byte[] a(byte[] bArr, int i, boolean z) {
        AppMethodBeat.i(100179);
        byte[] bArr2 = null;
        h hVar;
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0 && a <= this.b.capacity()) {
                        bArr2 = new byte[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            bArr2[i2] = a(bArr2[0], 0, true);
                        }
                        break;
                    }
                    hVar = new h("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.o(100179);
                    throw hVar;
                    break;
                case (byte) 13:
                    a aVar2 = new a();
                    a(aVar2);
                    if (aVar2.a == (byte) 0) {
                        int a2 = a(0, 0, true);
                        if (a2 >= 0 && a2 <= this.b.capacity()) {
                            bArr2 = new byte[a2];
                            this.b.get(bArr2);
                            break;
                        }
                        h hVar2 = new h("invalid size, tag: " + i + ", type: " + aVar.a + ", " + aVar2.a + ", size: " + a2);
                        AppMethodBeat.o(100179);
                        throw hVar2;
                    }
                    h hVar3 = new h("type mismatch, tag: " + i + ", type: " + aVar.a + ", " + aVar2.a);
                    AppMethodBeat.o(100179);
                    throw hVar3;
                default:
                    hVar = new h("type mismatch.");
                    AppMethodBeat.o(100179);
                    throw hVar;
            }
        } else if (z) {
            hVar = new h("require field not exist.");
            AppMethodBeat.o(100179);
            throw hVar;
        }
        AppMethodBeat.o(100179);
        return bArr2;
    }

    public final short[] a(short[] sArr, int i, boolean z) {
        AppMethodBeat.i(100180);
        short[] sArr2 = null;
        h hVar;
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        sArr2 = new short[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            sArr2[i2] = a(sArr2[0], 0, true);
                        }
                        break;
                    }
                    hVar = new h("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.o(100180);
                    throw hVar;
                default:
                    hVar = new h("type mismatch.");
                    AppMethodBeat.o(100180);
                    throw hVar;
            }
        } else if (z) {
            hVar = new h("require field not exist.");
            AppMethodBeat.o(100180);
            throw hVar;
        }
        AppMethodBeat.o(100180);
        return sArr2;
    }

    public final int[] a(int[] iArr, int i, boolean z) {
        AppMethodBeat.i(100181);
        int[] iArr2 = null;
        h hVar;
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        iArr2 = new int[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            iArr2[i2] = a(iArr2[0], 0, true);
                        }
                        break;
                    }
                    hVar = new h("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.o(100181);
                    throw hVar;
                default:
                    hVar = new h("type mismatch.");
                    AppMethodBeat.o(100181);
                    throw hVar;
            }
        } else if (z) {
            hVar = new h("require field not exist.");
            AppMethodBeat.o(100181);
            throw hVar;
        }
        AppMethodBeat.o(100181);
        return iArr2;
    }

    public final long[] a(long[] jArr, int i, boolean z) {
        AppMethodBeat.i(100182);
        long[] jArr2 = null;
        h hVar;
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        jArr2 = new long[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            jArr2[i2] = a(jArr2[0], 0, true);
                        }
                        break;
                    }
                    hVar = new h("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.o(100182);
                    throw hVar;
                default:
                    hVar = new h("type mismatch.");
                    AppMethodBeat.o(100182);
                    throw hVar;
            }
        } else if (z) {
            hVar = new h("require field not exist.");
            AppMethodBeat.o(100182);
            throw hVar;
        }
        AppMethodBeat.o(100182);
        return jArr2;
    }

    public final float[] a(float[] fArr, int i, boolean z) {
        AppMethodBeat.i(100183);
        float[] fArr2 = null;
        h hVar;
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        fArr2 = new float[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            fArr2[i2] = a(fArr2[0], 0, true);
                        }
                        break;
                    }
                    hVar = new h("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.o(100183);
                    throw hVar;
                default:
                    hVar = new h("type mismatch.");
                    AppMethodBeat.o(100183);
                    throw hVar;
            }
        } else if (z) {
            hVar = new h("require field not exist.");
            AppMethodBeat.o(100183);
            throw hVar;
        }
        AppMethodBeat.o(100183);
        return fArr2;
    }

    public final double[] a(double[] dArr, int i, boolean z) {
        AppMethodBeat.i(100184);
        double[] dArr2 = null;
        h hVar;
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a >= 0) {
                        dArr2 = new double[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            dArr2[i2] = a(dArr2[0], 0, true);
                        }
                        break;
                    }
                    hVar = new h("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.o(100184);
                    throw hVar;
                default:
                    hVar = new h("type mismatch.");
                    AppMethodBeat.o(100184);
                    throw hVar;
            }
        } else if (z) {
            hVar = new h("require field not exist.");
            AppMethodBeat.o(100184);
            throw hVar;
        }
        AppMethodBeat.o(100184);
        return dArr2;
    }

    public final <T> T[] a(T[] tArr, int i, boolean z) {
        AppMethodBeat.i(100185);
        if (tArr == null || tArr.length == 0) {
            h hVar = new h("unable to get type of key and value.");
            AppMethodBeat.o(100185);
            throw hVar;
        }
        Object[] b = b(tArr[0], i, z);
        AppMethodBeat.o(100185);
        return b;
    }

    public final <T> List<T> a(List<T> list, int i, boolean z) {
        int i2 = 0;
        AppMethodBeat.i(100186);
        if (list == null || list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.o(100186);
            return arrayList;
        }
        Object[] b = b(list.get(0), i, z);
        if (b == null) {
            AppMethodBeat.o(100186);
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        while (i2 < b.length) {
            arrayList2.add(b[i2]);
            i2++;
        }
        AppMethodBeat.o(100186);
        return arrayList2;
    }

    private <T> T[] b(T t, int i, boolean z) {
        AppMethodBeat.i(100187);
        h hVar;
        if (a(i)) {
            a aVar = new a();
            a(aVar);
            switch (aVar.a) {
                case (byte) 9:
                    int a = a(0, 0, true);
                    if (a < 0) {
                        hVar = new h("size invalid: ".concat(String.valueOf(a)));
                        AppMethodBeat.o(100187);
                        throw hVar;
                    }
                    Object[] objArr = (Object[]) Array.newInstance(t.getClass(), a);
                    for (int i2 = 0; i2 < a; i2++) {
                        objArr[i2] = a((Object) t, 0, true);
                    }
                    AppMethodBeat.o(100187);
                    return objArr;
                default:
                    hVar = new h("type mismatch.");
                    AppMethodBeat.o(100187);
                    throw hVar;
            }
        } else if (z) {
            hVar = new h("require field not exist.");
            AppMethodBeat.o(100187);
            throw hVar;
        } else {
            AppMethodBeat.o(100187);
            return null;
        }
    }

    public final m a(m mVar, int i, boolean z) {
        AppMethodBeat.i(100188);
        m mVar2 = null;
        h hVar;
        if (a(i)) {
            try {
                mVar2 = (m) mVar.getClass().newInstance();
                a aVar = new a();
                a(aVar);
                if (aVar.a != (byte) 10) {
                    hVar = new h("type mismatch.");
                    AppMethodBeat.o(100188);
                    throw hVar;
                }
                mVar2.readFrom(this);
                a();
            } catch (Exception e) {
                h hVar2 = new h(e.getMessage());
                AppMethodBeat.o(100188);
                throw hVar2;
            }
        } else if (z) {
            hVar = new h("require field not exist.");
            AppMethodBeat.o(100188);
            throw hVar;
        }
        AppMethodBeat.o(100188);
        return mVar2;
    }

    public final <T> Object a(T t, int i, boolean z) {
        AppMethodBeat.i(100189);
        Object valueOf;
        if (t instanceof Byte) {
            Byte valueOf2 = Byte.valueOf(a((byte) 0, i, z));
            AppMethodBeat.o(100189);
            return valueOf2;
        } else if (t instanceof Boolean) {
            valueOf = Boolean.valueOf(a(false, i, z));
            AppMethodBeat.o(100189);
            return valueOf;
        } else if (t instanceof Short) {
            valueOf = Short.valueOf(a((short) 0, i, z));
            AppMethodBeat.o(100189);
            return valueOf;
        } else if (t instanceof Integer) {
            valueOf = Integer.valueOf(a(0, i, z));
            AppMethodBeat.o(100189);
            return valueOf;
        } else if (t instanceof Long) {
            valueOf = Long.valueOf(a(0, i, z));
            AppMethodBeat.o(100189);
            return valueOf;
        } else if (t instanceof Float) {
            valueOf = Float.valueOf(a(0.0f, i, z));
            AppMethodBeat.o(100189);
            return valueOf;
        } else if (t instanceof Double) {
            valueOf = Double.valueOf(a(0.0d, i, z));
            AppMethodBeat.o(100189);
            return valueOf;
        } else if (t instanceof String) {
            valueOf = a(i, z);
            AppMethodBeat.o(100189);
            return valueOf;
        } else if (t instanceof Map) {
            valueOf = a((Map) t, i, z);
            AppMethodBeat.o(100189);
            return valueOf;
        } else if (t instanceof List) {
            valueOf = a((List) t, i, z);
            AppMethodBeat.o(100189);
            return valueOf;
        } else if (t instanceof m) {
            valueOf = a((m) t, i, z);
            AppMethodBeat.o(100189);
            return valueOf;
        } else if (!t.getClass().isArray()) {
            h hVar = new h("read object error: unsupport type.");
            AppMethodBeat.o(100189);
            throw hVar;
        } else if ((t instanceof byte[]) || (t instanceof Byte[])) {
            valueOf = a(null, i, z);
            AppMethodBeat.o(100189);
            return valueOf;
        } else if (t instanceof boolean[]) {
            valueOf = a(null, i, z);
            AppMethodBeat.o(100189);
            return valueOf;
        } else if (t instanceof short[]) {
            valueOf = a(null, i, z);
            AppMethodBeat.o(100189);
            return valueOf;
        } else if (t instanceof int[]) {
            valueOf = a(null, i, z);
            AppMethodBeat.o(100189);
            return valueOf;
        } else if (t instanceof long[]) {
            valueOf = a(null, i, z);
            AppMethodBeat.o(100189);
            return valueOf;
        } else if (t instanceof float[]) {
            valueOf = a(null, i, z);
            AppMethodBeat.o(100189);
            return valueOf;
        } else if (t instanceof double[]) {
            valueOf = a(null, i, z);
            AppMethodBeat.o(100189);
            return valueOf;
        } else {
            valueOf = a((Object[]) t, i, z);
            AppMethodBeat.o(100189);
            return valueOf;
        }
    }

    public final int a(String str) {
        this.a = str;
        return 0;
    }
}
