package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class aj {
    private ByteBuffer a;
    private String b;

    static {
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public aj(int i) {
        AppMethodBeat.i(98453);
        this.b = "GBK";
        this.a = ByteBuffer.allocate(i);
        AppMethodBeat.o(98453);
    }

    public aj() {
        this(128);
    }

    public final ByteBuffer a() {
        return this.a;
    }

    public final byte[] b() {
        AppMethodBeat.i(98454);
        byte[] bArr = new byte[this.a.position()];
        System.arraycopy(this.a.array(), 0, bArr, 0, this.a.position());
        AppMethodBeat.o(98454);
        return bArr;
    }

    private void a(int i) {
        AppMethodBeat.i(98455);
        if (this.a.remaining() < i) {
            try {
                ByteBuffer allocate = ByteBuffer.allocate((this.a.capacity() + i) << 1);
                allocate.put(this.a.array(), 0, this.a.position());
                this.a = allocate;
            } catch (IllegalArgumentException e) {
                AppMethodBeat.o(98455);
                throw e;
            }
        }
        AppMethodBeat.o(98455);
    }

    private void b(byte b, int i) {
        AppMethodBeat.i(98456);
        if (i < 15) {
            this.a.put((byte) ((i << 4) | b));
            AppMethodBeat.o(98456);
        } else if (i < 256) {
            this.a.put((byte) (b | 240));
            this.a.put((byte) i);
            AppMethodBeat.o(98456);
        } else {
            RuntimeException runtimeException = new RuntimeException("tag is too large: ".concat(String.valueOf(i)));
            AppMethodBeat.o(98456);
            throw runtimeException;
        }
    }

    public final void a(boolean z) {
        AppMethodBeat.i(98457);
        a((byte) (z ? 1 : 0), 3);
        AppMethodBeat.o(98457);
    }

    public final void a(byte b, int i) {
        AppMethodBeat.i(98458);
        a(3);
        if (b == (byte) 0) {
            b((byte) 12, i);
            AppMethodBeat.o(98458);
            return;
        }
        b((byte) 0, i);
        this.a.put(b);
        AppMethodBeat.o(98458);
    }

    public final void a(short s, int i) {
        AppMethodBeat.i(98459);
        a(4);
        if (s < (short) -128 || s > (short) 127) {
            b((byte) 1, i);
            this.a.putShort(s);
            AppMethodBeat.o(98459);
            return;
        }
        a((byte) s, i);
        AppMethodBeat.o(98459);
    }

    public final void a(int i, int i2) {
        AppMethodBeat.i(98460);
        a(6);
        if (i < -32768 || i > 32767) {
            b((byte) 2, i2);
            this.a.putInt(i);
            AppMethodBeat.o(98460);
            return;
        }
        a((short) i, i2);
        AppMethodBeat.o(98460);
    }

    public final void a(long j, int i) {
        AppMethodBeat.i(98461);
        a(10);
        if (j < -2147483648L || j > 2147483647L) {
            b((byte) 3, i);
            this.a.putLong(j);
            AppMethodBeat.o(98461);
            return;
        }
        a((int) j, i);
        AppMethodBeat.o(98461);
    }

    public final void a(String str, int i) {
        byte[] bytes;
        AppMethodBeat.i(98462);
        try {
            bytes = str.getBytes(this.b);
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            b((byte) 7, i);
            this.a.putInt(bytes.length);
            this.a.put(bytes);
            AppMethodBeat.o(98462);
            return;
        }
        b((byte) 6, i);
        this.a.put((byte) bytes.length);
        this.a.put(bytes);
        AppMethodBeat.o(98462);
    }

    public final <K, V> void a(Map<K, V> map, int i) {
        AppMethodBeat.i(98463);
        a(8);
        b((byte) 8, i);
        a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                a(entry.getKey(), 0);
                a(entry.getValue(), 1);
            }
        }
        AppMethodBeat.o(98463);
    }

    public final void a(byte[] bArr, int i) {
        AppMethodBeat.i(98464);
        a(bArr.length + 8);
        b((byte) 13, i);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.a.put(bArr);
        AppMethodBeat.o(98464);
    }

    public final <T> void a(Collection<T> collection, int i) {
        AppMethodBeat.i(98465);
        a(8);
        b((byte) 9, i);
        a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            for (T a : collection) {
                a((Object) a, 0);
            }
        }
        AppMethodBeat.o(98465);
    }

    public final void a(Object obj, int i) {
        int i2 = 0;
        AppMethodBeat.i(98466);
        if (obj instanceof Byte) {
            a(((Byte) obj).byteValue(), i);
            AppMethodBeat.o(98466);
        } else if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                i2 = 1;
            }
            a((byte) i2, i);
            AppMethodBeat.o(98466);
        } else if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i);
            AppMethodBeat.o(98466);
        } else if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i);
            AppMethodBeat.o(98466);
        } else if (obj instanceof Long) {
            a(((Long) obj).longValue(), i);
            AppMethodBeat.o(98466);
        } else if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            a(6);
            b((byte) 4, i);
            this.a.putFloat(floatValue);
            AppMethodBeat.o(98466);
        } else if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            a(10);
            b((byte) 5, i);
            this.a.putDouble(doubleValue);
            AppMethodBeat.o(98466);
        } else if (obj instanceof String) {
            a((String) obj, i);
            AppMethodBeat.o(98466);
        } else if (obj instanceof Map) {
            a((Map) obj, i);
            AppMethodBeat.o(98466);
        } else if (obj instanceof List) {
            a((List) obj, i);
            AppMethodBeat.o(98466);
        } else if (obj instanceof ak) {
            ak akVar = (ak) obj;
            a(2);
            b((byte) 10, i);
            akVar.a(this);
            a(2);
            b((byte) 11, 0);
            AppMethodBeat.o(98466);
        } else if (obj instanceof byte[]) {
            a((byte[]) obj, i);
            AppMethodBeat.o(98466);
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            a(8);
            b((byte) 9, i);
            a(zArr.length, 0);
            for (boolean z : zArr) {
                a((byte) (z ? 1 : 0), 0);
            }
            AppMethodBeat.o(98466);
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            a(8);
            b((byte) 9, i);
            a(sArr.length, 0);
            for (short a : sArr) {
                a(a, 0);
            }
            AppMethodBeat.o(98466);
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            a(8);
            b((byte) 9, i);
            a(iArr.length, 0);
            for (int a2 : iArr) {
                a(a2, 0);
            }
            AppMethodBeat.o(98466);
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            a(8);
            b((byte) 9, i);
            a(jArr.length, 0);
            for (long a3 : jArr) {
                a(a3, 0);
            }
            AppMethodBeat.o(98466);
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            a(8);
            b((byte) 9, i);
            a(fArr.length, 0);
            for (float f : fArr) {
                a(6);
                b((byte) 4, 0);
                this.a.putFloat(f);
            }
            AppMethodBeat.o(98466);
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            a(8);
            b((byte) 9, i);
            a(dArr.length, 0);
            for (double d : dArr) {
                a(10);
                b((byte) 5, 0);
                this.a.putDouble(d);
            }
            AppMethodBeat.o(98466);
        } else if (obj.getClass().isArray()) {
            Object[] objArr = (Object[]) obj;
            a(8);
            b((byte) 9, i);
            a(objArr.length, 0);
            for (Object a4 : objArr) {
                a(a4, 0);
            }
            AppMethodBeat.o(98466);
        } else if (obj instanceof Collection) {
            a((Collection) obj, i);
            AppMethodBeat.o(98466);
        } else {
            RuntimeException runtimeException = new RuntimeException("write object error: unsupport type. " + obj.getClass());
            AppMethodBeat.o(98466);
            throw runtimeException;
        }
    }

    public final int a(String str) {
        this.b = str;
        return 0;
    }
}
