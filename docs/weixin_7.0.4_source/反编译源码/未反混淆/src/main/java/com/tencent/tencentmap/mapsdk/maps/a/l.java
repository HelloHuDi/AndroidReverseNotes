package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class l {
    protected String a;
    private ByteBuffer b;
    private o c;

    public l(int i) {
        AppMethodBeat.i(100297);
        this.a = "GBK";
        this.b = ByteBuffer.allocate(i);
        AppMethodBeat.o(100297);
    }

    public l() {
        this(128);
    }

    public ByteBuffer a() {
        return this.b;
    }

    public byte[] b() {
        AppMethodBeat.i(100298);
        byte[] bArr = new byte[this.b.position()];
        System.arraycopy(this.b.array(), 0, bArr, 0, this.b.position());
        AppMethodBeat.o(100298);
        return bArr;
    }

    public void a(int i) {
        AppMethodBeat.i(100299);
        if (this.b.remaining() < i) {
            int capacity = (this.b.capacity() + i) * 2;
            try {
                ByteBuffer allocate = ByteBuffer.allocate(capacity);
                allocate.put(this.b.array(), 0, this.b.position());
                this.b = allocate;
            } catch (IllegalArgumentException e) {
                if (this.c != null) {
                    this.c.a(e, this.b, i, capacity);
                }
                AppMethodBeat.o(100299);
                throw e;
            }
        }
        AppMethodBeat.o(100299);
    }

    public void a(byte b, int i) {
        AppMethodBeat.i(100300);
        if (i < 15) {
            this.b.put((byte) ((i << 4) | b));
            AppMethodBeat.o(100300);
        } else if (i < 256) {
            this.b.put((byte) (b | 240));
            this.b.put((byte) i);
            AppMethodBeat.o(100300);
        } else {
            j jVar = new j("tag is too large: ".concat(String.valueOf(i)));
            AppMethodBeat.o(100300);
            throw jVar;
        }
    }

    public void a(boolean z, int i) {
        AppMethodBeat.i(100301);
        b((byte) (z ? 1 : 0), i);
        AppMethodBeat.o(100301);
    }

    public void b(byte b, int i) {
        AppMethodBeat.i(100302);
        a(3);
        if (b == (byte) 0) {
            a((byte) 12, i);
            AppMethodBeat.o(100302);
            return;
        }
        a((byte) 0, i);
        this.b.put(b);
        AppMethodBeat.o(100302);
    }

    public void a(short s, int i) {
        AppMethodBeat.i(100303);
        a(4);
        if (s < (short) -128 || s > (short) 127) {
            a((byte) 1, i);
            this.b.putShort(s);
            AppMethodBeat.o(100303);
            return;
        }
        b((byte) s, i);
        AppMethodBeat.o(100303);
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(100304);
        a(6);
        if (i < -32768 || i > 32767) {
            a((byte) 2, i2);
            this.b.putInt(i);
            AppMethodBeat.o(100304);
            return;
        }
        a((short) i, i2);
        AppMethodBeat.o(100304);
    }

    public void a(long j, int i) {
        AppMethodBeat.i(100305);
        a(10);
        if (j < -2147483648L || j > 2147483647L) {
            a((byte) 3, i);
            this.b.putLong(j);
            AppMethodBeat.o(100305);
            return;
        }
        a((int) j, i);
        AppMethodBeat.o(100305);
    }

    public void a(float f, int i) {
        AppMethodBeat.i(100306);
        a(6);
        a((byte) 4, i);
        this.b.putFloat(f);
        AppMethodBeat.o(100306);
    }

    public void a(double d, int i) {
        AppMethodBeat.i(100307);
        a(10);
        a((byte) 5, i);
        this.b.putDouble(d);
        AppMethodBeat.o(100307);
    }

    public void a(String str, int i) {
        byte[] bytes;
        AppMethodBeat.i(100308);
        try {
            bytes = str.getBytes(this.a);
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            a((byte) 7, i);
            this.b.putInt(bytes.length);
            this.b.put(bytes);
            AppMethodBeat.o(100308);
            return;
        }
        a((byte) 6, i);
        this.b.put((byte) bytes.length);
        this.b.put(bytes);
        AppMethodBeat.o(100308);
    }

    public <K, V> void a(Map<K, V> map, int i) {
        AppMethodBeat.i(100309);
        a(8);
        a((byte) 8, i);
        a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                a(entry.getKey(), 0);
                a(entry.getValue(), 1);
            }
        }
        AppMethodBeat.o(100309);
    }

    public void a(boolean[] zArr, int i) {
        AppMethodBeat.i(100310);
        a(8);
        a((byte) 9, i);
        a(zArr.length, 0);
        for (boolean a : zArr) {
            a(a, 0);
        }
        AppMethodBeat.o(100310);
    }

    public void a(byte[] bArr, int i) {
        AppMethodBeat.i(100311);
        a(bArr.length + 8);
        a((byte) 13, i);
        a((byte) 0, 0);
        a(bArr.length, 0);
        this.b.put(bArr);
        AppMethodBeat.o(100311);
    }

    public void a(short[] sArr, int i) {
        AppMethodBeat.i(100312);
        a(8);
        a((byte) 9, i);
        a(sArr.length, 0);
        for (short a : sArr) {
            a(a, 0);
        }
        AppMethodBeat.o(100312);
    }

    public void a(int[] iArr, int i) {
        AppMethodBeat.i(100313);
        a(8);
        a((byte) 9, i);
        a(iArr.length, 0);
        for (int a : iArr) {
            a(a, 0);
        }
        AppMethodBeat.o(100313);
    }

    public void a(long[] jArr, int i) {
        AppMethodBeat.i(100314);
        a(8);
        a((byte) 9, i);
        a(jArr.length, 0);
        for (long a : jArr) {
            a(a, 0);
        }
        AppMethodBeat.o(100314);
    }

    public void a(float[] fArr, int i) {
        AppMethodBeat.i(100315);
        a(8);
        a((byte) 9, i);
        a(fArr.length, 0);
        for (float a : fArr) {
            a(a, 0);
        }
        AppMethodBeat.o(100315);
    }

    public void a(double[] dArr, int i) {
        AppMethodBeat.i(100316);
        a(8);
        a((byte) 9, i);
        a(dArr.length, 0);
        for (double a : dArr) {
            a(a, 0);
        }
        AppMethodBeat.o(100316);
    }

    private void a(Object[] objArr, int i) {
        AppMethodBeat.i(100317);
        a(8);
        a((byte) 9, i);
        a(objArr.length, 0);
        for (Object a : objArr) {
            a(a, 0);
        }
        AppMethodBeat.o(100317);
    }

    public <T> void a(Collection<T> collection, int i) {
        AppMethodBeat.i(100318);
        a(8);
        a((byte) 9, i);
        a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            for (T a : collection) {
                a((Object) a, 0);
            }
        }
        AppMethodBeat.o(100318);
    }

    public void a(m mVar, int i) {
        AppMethodBeat.i(100319);
        a(2);
        a((byte) 10, i);
        mVar.writeTo(this);
        a(2);
        a((byte) 11, 0);
        AppMethodBeat.o(100319);
    }

    public void a(Object obj, int i) {
        AppMethodBeat.i(100320);
        if (obj instanceof Byte) {
            b(((Byte) obj).byteValue(), i);
            AppMethodBeat.o(100320);
        } else if (obj instanceof Boolean) {
            a(((Boolean) obj).booleanValue(), i);
            AppMethodBeat.o(100320);
        } else if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i);
            AppMethodBeat.o(100320);
        } else if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i);
            AppMethodBeat.o(100320);
        } else if (obj instanceof Long) {
            a(((Long) obj).longValue(), i);
            AppMethodBeat.o(100320);
        } else if (obj instanceof Float) {
            a(((Float) obj).floatValue(), i);
            AppMethodBeat.o(100320);
        } else if (obj instanceof Double) {
            a(((Double) obj).doubleValue(), i);
            AppMethodBeat.o(100320);
        } else if (obj instanceof String) {
            a((String) obj, i);
            AppMethodBeat.o(100320);
        } else if (obj instanceof Map) {
            a((Map) obj, i);
            AppMethodBeat.o(100320);
        } else if (obj instanceof List) {
            a((List) obj, i);
            AppMethodBeat.o(100320);
        } else if (obj instanceof m) {
            a((m) obj, i);
            AppMethodBeat.o(100320);
        } else if (obj instanceof byte[]) {
            a((byte[]) obj, i);
            AppMethodBeat.o(100320);
        } else if (obj instanceof boolean[]) {
            a((boolean[]) obj, i);
            AppMethodBeat.o(100320);
        } else if (obj instanceof short[]) {
            a((short[]) obj, i);
            AppMethodBeat.o(100320);
        } else if (obj instanceof int[]) {
            a((int[]) obj, i);
            AppMethodBeat.o(100320);
        } else if (obj instanceof long[]) {
            a((long[]) obj, i);
            AppMethodBeat.o(100320);
        } else if (obj instanceof float[]) {
            a((float[]) obj, i);
            AppMethodBeat.o(100320);
        } else if (obj instanceof double[]) {
            a((double[]) obj, i);
            AppMethodBeat.o(100320);
        } else if (obj.getClass().isArray()) {
            a((Object[]) obj, i);
            AppMethodBeat.o(100320);
        } else if (obj instanceof Collection) {
            a((Collection) obj, i);
            AppMethodBeat.o(100320);
        } else {
            j jVar = new j("write object error: unsupport type. " + obj.getClass());
            AppMethodBeat.o(100320);
            throw jVar;
        }
    }

    public int a(String str) {
        this.a = str;
        return 0;
    }
}
