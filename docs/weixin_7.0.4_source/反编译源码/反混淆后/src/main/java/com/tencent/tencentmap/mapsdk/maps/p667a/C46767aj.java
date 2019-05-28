package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.aj */
public final class C46767aj {
    /* renamed from: a */
    private ByteBuffer f18063a;
    /* renamed from: b */
    private String f18064b;

    static {
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public C46767aj(int i) {
        AppMethodBeat.m2504i(98453);
        this.f18064b = "GBK";
        this.f18063a = ByteBuffer.allocate(i);
        AppMethodBeat.m2505o(98453);
    }

    public C46767aj() {
        this(128);
    }

    /* renamed from: a */
    public final ByteBuffer mo75324a() {
        return this.f18063a;
    }

    /* renamed from: b */
    public final byte[] mo75335b() {
        AppMethodBeat.m2504i(98454);
        byte[] bArr = new byte[this.f18063a.position()];
        System.arraycopy(this.f18063a.array(), 0, bArr, 0, this.f18063a.position());
        AppMethodBeat.m2505o(98454);
        return bArr;
    }

    /* renamed from: a */
    private void m88683a(int i) {
        AppMethodBeat.m2504i(98455);
        if (this.f18063a.remaining() < i) {
            try {
                ByteBuffer allocate = ByteBuffer.allocate((this.f18063a.capacity() + i) << 1);
                allocate.put(this.f18063a.array(), 0, this.f18063a.position());
                this.f18063a = allocate;
            } catch (IllegalArgumentException e) {
                AppMethodBeat.m2505o(98455);
                throw e;
            }
        }
        AppMethodBeat.m2505o(98455);
    }

    /* renamed from: b */
    private void m88684b(byte b, int i) {
        AppMethodBeat.m2504i(98456);
        if (i < 15) {
            this.f18063a.put((byte) ((i << 4) | b));
            AppMethodBeat.m2505o(98456);
        } else if (i < 256) {
            this.f18063a.put((byte) (b | 240));
            this.f18063a.put((byte) i);
            AppMethodBeat.m2505o(98456);
        } else {
            RuntimeException runtimeException = new RuntimeException("tag is too large: ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(98456);
            throw runtimeException;
        }
    }

    /* renamed from: a */
    public final void mo75333a(boolean z) {
        AppMethodBeat.m2504i(98457);
        mo75325a((byte) (z ? 1 : 0), 3);
        AppMethodBeat.m2505o(98457);
    }

    /* renamed from: a */
    public final void mo75325a(byte b, int i) {
        AppMethodBeat.m2504i(98458);
        m88683a(3);
        if (b == (byte) 0) {
            m88684b((byte) 12, i);
            AppMethodBeat.m2505o(98458);
            return;
        }
        m88684b((byte) 0, i);
        this.f18063a.put(b);
        AppMethodBeat.m2505o(98458);
    }

    /* renamed from: a */
    public final void mo75332a(short s, int i) {
        AppMethodBeat.m2504i(98459);
        m88683a(4);
        if (s < (short) -128 || s > (short) 127) {
            m88684b((byte) 1, i);
            this.f18063a.putShort(s);
            AppMethodBeat.m2505o(98459);
            return;
        }
        mo75325a((byte) s, i);
        AppMethodBeat.m2505o(98459);
    }

    /* renamed from: a */
    public final void mo75326a(int i, int i2) {
        AppMethodBeat.m2504i(98460);
        m88683a(6);
        if (i < -32768 || i > 32767) {
            m88684b((byte) 2, i2);
            this.f18063a.putInt(i);
            AppMethodBeat.m2505o(98460);
            return;
        }
        mo75332a((short) i, i2);
        AppMethodBeat.m2505o(98460);
    }

    /* renamed from: a */
    public final void mo75327a(long j, int i) {
        AppMethodBeat.m2504i(98461);
        m88683a(10);
        if (j < -2147483648L || j > 2147483647L) {
            m88684b((byte) 3, i);
            this.f18063a.putLong(j);
            AppMethodBeat.m2505o(98461);
            return;
        }
        mo75326a((int) j, i);
        AppMethodBeat.m2505o(98461);
    }

    /* renamed from: a */
    public final void mo75329a(String str, int i) {
        byte[] bytes;
        AppMethodBeat.m2504i(98462);
        try {
            bytes = str.getBytes(this.f18064b);
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        m88683a(bytes.length + 10);
        if (bytes.length > 255) {
            m88684b((byte) 7, i);
            this.f18063a.putInt(bytes.length);
            this.f18063a.put(bytes);
            AppMethodBeat.m2505o(98462);
            return;
        }
        m88684b((byte) 6, i);
        this.f18063a.put((byte) bytes.length);
        this.f18063a.put(bytes);
        AppMethodBeat.m2505o(98462);
    }

    /* renamed from: a */
    public final <K, V> void mo75331a(Map<K, V> map, int i) {
        AppMethodBeat.m2504i(98463);
        m88683a(8);
        m88684b((byte) 8, i);
        mo75326a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                mo75328a(entry.getKey(), 0);
                mo75328a(entry.getValue(), 1);
            }
        }
        AppMethodBeat.m2505o(98463);
    }

    /* renamed from: a */
    public final void mo75334a(byte[] bArr, int i) {
        AppMethodBeat.m2504i(98464);
        m88683a(bArr.length + 8);
        m88684b((byte) 13, i);
        m88684b((byte) 0, 0);
        mo75326a(bArr.length, 0);
        this.f18063a.put(bArr);
        AppMethodBeat.m2505o(98464);
    }

    /* renamed from: a */
    public final <T> void mo75330a(Collection<T> collection, int i) {
        AppMethodBeat.m2504i(98465);
        m88683a(8);
        m88684b((byte) 9, i);
        mo75326a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            for (T a : collection) {
                mo75328a((Object) a, 0);
            }
        }
        AppMethodBeat.m2505o(98465);
    }

    /* renamed from: a */
    public final void mo75328a(Object obj, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(98466);
        if (obj instanceof Byte) {
            mo75325a(((Byte) obj).byteValue(), i);
            AppMethodBeat.m2505o(98466);
        } else if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                i2 = 1;
            }
            mo75325a((byte) i2, i);
            AppMethodBeat.m2505o(98466);
        } else if (obj instanceof Short) {
            mo75332a(((Short) obj).shortValue(), i);
            AppMethodBeat.m2505o(98466);
        } else if (obj instanceof Integer) {
            mo75326a(((Integer) obj).intValue(), i);
            AppMethodBeat.m2505o(98466);
        } else if (obj instanceof Long) {
            mo75327a(((Long) obj).longValue(), i);
            AppMethodBeat.m2505o(98466);
        } else if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            m88683a(6);
            m88684b((byte) 4, i);
            this.f18063a.putFloat(floatValue);
            AppMethodBeat.m2505o(98466);
        } else if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            m88683a(10);
            m88684b((byte) 5, i);
            this.f18063a.putDouble(doubleValue);
            AppMethodBeat.m2505o(98466);
        } else if (obj instanceof String) {
            mo75329a((String) obj, i);
            AppMethodBeat.m2505o(98466);
        } else if (obj instanceof Map) {
            mo75331a((Map) obj, i);
            AppMethodBeat.m2505o(98466);
        } else if (obj instanceof List) {
            mo75330a((List) obj, i);
            AppMethodBeat.m2505o(98466);
        } else if (obj instanceof C41029ak) {
            C41029ak c41029ak = (C41029ak) obj;
            m88683a(2);
            m88684b((byte) 10, i);
            c41029ak.mo12388a(this);
            m88683a(2);
            m88684b((byte) 11, 0);
            AppMethodBeat.m2505o(98466);
        } else if (obj instanceof byte[]) {
            mo75334a((byte[]) obj, i);
            AppMethodBeat.m2505o(98466);
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            m88683a(8);
            m88684b((byte) 9, i);
            mo75326a(zArr.length, 0);
            for (boolean z : zArr) {
                mo75325a((byte) (z ? 1 : 0), 0);
            }
            AppMethodBeat.m2505o(98466);
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            m88683a(8);
            m88684b((byte) 9, i);
            mo75326a(sArr.length, 0);
            for (short a : sArr) {
                mo75332a(a, 0);
            }
            AppMethodBeat.m2505o(98466);
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            m88683a(8);
            m88684b((byte) 9, i);
            mo75326a(iArr.length, 0);
            for (int a2 : iArr) {
                mo75326a(a2, 0);
            }
            AppMethodBeat.m2505o(98466);
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            m88683a(8);
            m88684b((byte) 9, i);
            mo75326a(jArr.length, 0);
            for (long a3 : jArr) {
                mo75327a(a3, 0);
            }
            AppMethodBeat.m2505o(98466);
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            m88683a(8);
            m88684b((byte) 9, i);
            mo75326a(fArr.length, 0);
            for (float f : fArr) {
                m88683a(6);
                m88684b((byte) 4, 0);
                this.f18063a.putFloat(f);
            }
            AppMethodBeat.m2505o(98466);
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            m88683a(8);
            m88684b((byte) 9, i);
            mo75326a(dArr.length, 0);
            for (double d : dArr) {
                m88683a(10);
                m88684b((byte) 5, 0);
                this.f18063a.putDouble(d);
            }
            AppMethodBeat.m2505o(98466);
        } else if (obj.getClass().isArray()) {
            Object[] objArr = (Object[]) obj;
            m88683a(8);
            m88684b((byte) 9, i);
            mo75326a(objArr.length, 0);
            for (Object a4 : objArr) {
                mo75328a(a4, 0);
            }
            AppMethodBeat.m2505o(98466);
        } else if (obj instanceof Collection) {
            mo75330a((Collection) obj, i);
            AppMethodBeat.m2505o(98466);
        } else {
            RuntimeException runtimeException = new RuntimeException("write object error: unsupport type. " + obj.getClass());
            AppMethodBeat.m2505o(98466);
            throw runtimeException;
        }
    }

    /* renamed from: a */
    public final int mo75323a(String str) {
        this.f18064b = str;
        return 0;
    }
}
