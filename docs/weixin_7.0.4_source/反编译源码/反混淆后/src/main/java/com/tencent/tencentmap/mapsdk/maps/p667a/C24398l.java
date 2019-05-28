package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.l */
public class C24398l {
    /* renamed from: a */
    protected String f4760a;
    /* renamed from: b */
    private ByteBuffer f4761b;
    /* renamed from: c */
    private C46807o f4762c;

    public C24398l(int i) {
        AppMethodBeat.m2504i(100297);
        this.f4760a = "GBK";
        this.f4761b = ByteBuffer.allocate(i);
        AppMethodBeat.m2505o(100297);
    }

    public C24398l() {
        this(128);
    }

    /* renamed from: a */
    public ByteBuffer mo40663a() {
        return this.f4761b;
    }

    /* renamed from: b */
    public byte[] mo40685b() {
        AppMethodBeat.m2504i(100298);
        byte[] bArr = new byte[this.f4761b.position()];
        System.arraycopy(this.f4761b.array(), 0, bArr, 0, this.f4761b.position());
        AppMethodBeat.m2505o(100298);
        return bArr;
    }

    /* renamed from: a */
    public void mo40667a(int i) {
        AppMethodBeat.m2504i(100299);
        if (this.f4761b.remaining() < i) {
            int capacity = (this.f4761b.capacity() + i) * 2;
            try {
                ByteBuffer allocate = ByteBuffer.allocate(capacity);
                allocate.put(this.f4761b.array(), 0, this.f4761b.position());
                this.f4761b = allocate;
            } catch (IllegalArgumentException e) {
                if (this.f4762c != null) {
                    this.f4762c.mo75544a(e, this.f4761b, i, capacity);
                }
                AppMethodBeat.m2505o(100299);
                throw e;
            }
        }
        AppMethodBeat.m2505o(100299);
    }

    /* renamed from: a */
    public void mo40664a(byte b, int i) {
        AppMethodBeat.m2504i(100300);
        if (i < 15) {
            this.f4761b.put((byte) ((i << 4) | b));
            AppMethodBeat.m2505o(100300);
        } else if (i < 256) {
            this.f4761b.put((byte) (b | 240));
            this.f4761b.put((byte) i);
            AppMethodBeat.m2505o(100300);
        } else {
            C5891j c5891j = new C5891j("tag is too large: ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(100300);
            throw c5891j;
        }
    }

    /* renamed from: a */
    public void mo40676a(boolean z, int i) {
        AppMethodBeat.m2504i(100301);
        mo40684b((byte) (z ? 1 : 0), i);
        AppMethodBeat.m2505o(100301);
    }

    /* renamed from: b */
    public void mo40684b(byte b, int i) {
        AppMethodBeat.m2504i(100302);
        mo40667a(3);
        if (b == (byte) 0) {
            mo40664a((byte) 12, i);
            AppMethodBeat.m2505o(100302);
            return;
        }
        mo40664a((byte) 0, i);
        this.f4761b.put(b);
        AppMethodBeat.m2505o(100302);
    }

    /* renamed from: a */
    public void mo40675a(short s, int i) {
        AppMethodBeat.m2504i(100303);
        mo40667a(4);
        if (s < (short) -128 || s > (short) 127) {
            mo40664a((byte) 1, i);
            this.f4761b.putShort(s);
            AppMethodBeat.m2505o(100303);
            return;
        }
        mo40684b((byte) s, i);
        AppMethodBeat.m2505o(100303);
    }

    /* renamed from: a */
    public void mo40668a(int i, int i2) {
        AppMethodBeat.m2504i(100304);
        mo40667a(6);
        if (i < -32768 || i > 32767) {
            mo40664a((byte) 2, i2);
            this.f4761b.putInt(i);
            AppMethodBeat.m2505o(100304);
            return;
        }
        mo40675a((short) i, i2);
        AppMethodBeat.m2505o(100304);
    }

    /* renamed from: a */
    public void mo40669a(long j, int i) {
        AppMethodBeat.m2504i(100305);
        mo40667a(10);
        if (j < -2147483648L || j > 2147483647L) {
            mo40664a((byte) 3, i);
            this.f4761b.putLong(j);
            AppMethodBeat.m2505o(100305);
            return;
        }
        mo40668a((int) j, i);
        AppMethodBeat.m2505o(100305);
    }

    /* renamed from: a */
    public void mo40666a(float f, int i) {
        AppMethodBeat.m2504i(100306);
        mo40667a(6);
        mo40664a((byte) 4, i);
        this.f4761b.putFloat(f);
        AppMethodBeat.m2505o(100306);
    }

    /* renamed from: a */
    public void mo40665a(double d, int i) {
        AppMethodBeat.m2504i(100307);
        mo40667a(10);
        mo40664a((byte) 5, i);
        this.f4761b.putDouble(d);
        AppMethodBeat.m2505o(100307);
    }

    /* renamed from: a */
    public void mo40672a(String str, int i) {
        byte[] bytes;
        AppMethodBeat.m2504i(100308);
        try {
            bytes = str.getBytes(this.f4760a);
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        mo40667a(bytes.length + 10);
        if (bytes.length > 255) {
            mo40664a((byte) 7, i);
            this.f4761b.putInt(bytes.length);
            this.f4761b.put(bytes);
            AppMethodBeat.m2505o(100308);
            return;
        }
        mo40664a((byte) 6, i);
        this.f4761b.put((byte) bytes.length);
        this.f4761b.put(bytes);
        AppMethodBeat.m2505o(100308);
    }

    /* renamed from: a */
    public <K, V> void mo40674a(Map<K, V> map, int i) {
        AppMethodBeat.m2504i(100309);
        mo40667a(8);
        mo40664a((byte) 8, i);
        mo40668a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                mo40671a(entry.getKey(), 0);
                mo40671a(entry.getValue(), 1);
            }
        }
        AppMethodBeat.m2505o(100309);
    }

    /* renamed from: a */
    public void mo40683a(boolean[] zArr, int i) {
        AppMethodBeat.m2504i(100310);
        mo40667a(8);
        mo40664a((byte) 9, i);
        mo40668a(zArr.length, 0);
        for (boolean a : zArr) {
            mo40676a(a, 0);
        }
        AppMethodBeat.m2505o(100310);
    }

    /* renamed from: a */
    public void mo40677a(byte[] bArr, int i) {
        AppMethodBeat.m2504i(100311);
        mo40667a(bArr.length + 8);
        mo40664a((byte) 13, i);
        mo40664a((byte) 0, 0);
        mo40668a(bArr.length, 0);
        this.f4761b.put(bArr);
        AppMethodBeat.m2505o(100311);
    }

    /* renamed from: a */
    public void mo40682a(short[] sArr, int i) {
        AppMethodBeat.m2504i(100312);
        mo40667a(8);
        mo40664a((byte) 9, i);
        mo40668a(sArr.length, 0);
        for (short a : sArr) {
            mo40675a(a, 0);
        }
        AppMethodBeat.m2505o(100312);
    }

    /* renamed from: a */
    public void mo40680a(int[] iArr, int i) {
        AppMethodBeat.m2504i(100313);
        mo40667a(8);
        mo40664a((byte) 9, i);
        mo40668a(iArr.length, 0);
        for (int a : iArr) {
            mo40668a(a, 0);
        }
        AppMethodBeat.m2505o(100313);
    }

    /* renamed from: a */
    public void mo40681a(long[] jArr, int i) {
        AppMethodBeat.m2504i(100314);
        mo40667a(8);
        mo40664a((byte) 9, i);
        mo40668a(jArr.length, 0);
        for (long a : jArr) {
            mo40669a(a, 0);
        }
        AppMethodBeat.m2505o(100314);
    }

    /* renamed from: a */
    public void mo40679a(float[] fArr, int i) {
        AppMethodBeat.m2504i(100315);
        mo40667a(8);
        mo40664a((byte) 9, i);
        mo40668a(fArr.length, 0);
        for (float a : fArr) {
            mo40666a(a, 0);
        }
        AppMethodBeat.m2505o(100315);
    }

    /* renamed from: a */
    public void mo40678a(double[] dArr, int i) {
        AppMethodBeat.m2504i(100316);
        mo40667a(8);
        mo40664a((byte) 9, i);
        mo40668a(dArr.length, 0);
        for (double a : dArr) {
            mo40665a(a, 0);
        }
        AppMethodBeat.m2505o(100316);
    }

    /* renamed from: a */
    private void m37883a(Object[] objArr, int i) {
        AppMethodBeat.m2504i(100317);
        mo40667a(8);
        mo40664a((byte) 9, i);
        mo40668a(objArr.length, 0);
        for (Object a : objArr) {
            mo40671a(a, 0);
        }
        AppMethodBeat.m2505o(100317);
    }

    /* renamed from: a */
    public <T> void mo40673a(Collection<T> collection, int i) {
        AppMethodBeat.m2504i(100318);
        mo40667a(8);
        mo40664a((byte) 9, i);
        mo40668a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            for (T a : collection) {
                mo40671a((Object) a, 0);
            }
        }
        AppMethodBeat.m2505o(100318);
    }

    /* renamed from: a */
    public void mo40670a(C46803m c46803m, int i) {
        AppMethodBeat.m2504i(100319);
        mo40667a(2);
        mo40664a((byte) 10, i);
        c46803m.writeTo(this);
        mo40667a(2);
        mo40664a((byte) 11, 0);
        AppMethodBeat.m2505o(100319);
    }

    /* renamed from: a */
    public void mo40671a(Object obj, int i) {
        AppMethodBeat.m2504i(100320);
        if (obj instanceof Byte) {
            mo40684b(((Byte) obj).byteValue(), i);
            AppMethodBeat.m2505o(100320);
        } else if (obj instanceof Boolean) {
            mo40676a(((Boolean) obj).booleanValue(), i);
            AppMethodBeat.m2505o(100320);
        } else if (obj instanceof Short) {
            mo40675a(((Short) obj).shortValue(), i);
            AppMethodBeat.m2505o(100320);
        } else if (obj instanceof Integer) {
            mo40668a(((Integer) obj).intValue(), i);
            AppMethodBeat.m2505o(100320);
        } else if (obj instanceof Long) {
            mo40669a(((Long) obj).longValue(), i);
            AppMethodBeat.m2505o(100320);
        } else if (obj instanceof Float) {
            mo40666a(((Float) obj).floatValue(), i);
            AppMethodBeat.m2505o(100320);
        } else if (obj instanceof Double) {
            mo40665a(((Double) obj).doubleValue(), i);
            AppMethodBeat.m2505o(100320);
        } else if (obj instanceof String) {
            mo40672a((String) obj, i);
            AppMethodBeat.m2505o(100320);
        } else if (obj instanceof Map) {
            mo40674a((Map) obj, i);
            AppMethodBeat.m2505o(100320);
        } else if (obj instanceof List) {
            mo40673a((List) obj, i);
            AppMethodBeat.m2505o(100320);
        } else if (obj instanceof C46803m) {
            mo40670a((C46803m) obj, i);
            AppMethodBeat.m2505o(100320);
        } else if (obj instanceof byte[]) {
            mo40677a((byte[]) obj, i);
            AppMethodBeat.m2505o(100320);
        } else if (obj instanceof boolean[]) {
            mo40683a((boolean[]) obj, i);
            AppMethodBeat.m2505o(100320);
        } else if (obj instanceof short[]) {
            mo40682a((short[]) obj, i);
            AppMethodBeat.m2505o(100320);
        } else if (obj instanceof int[]) {
            mo40680a((int[]) obj, i);
            AppMethodBeat.m2505o(100320);
        } else if (obj instanceof long[]) {
            mo40681a((long[]) obj, i);
            AppMethodBeat.m2505o(100320);
        } else if (obj instanceof float[]) {
            mo40679a((float[]) obj, i);
            AppMethodBeat.m2505o(100320);
        } else if (obj instanceof double[]) {
            mo40678a((double[]) obj, i);
            AppMethodBeat.m2505o(100320);
        } else if (obj.getClass().isArray()) {
            m37883a((Object[]) obj, i);
            AppMethodBeat.m2505o(100320);
        } else if (obj instanceof Collection) {
            mo40673a((Collection) obj, i);
            AppMethodBeat.m2505o(100320);
        } else {
            C5891j c5891j = new C5891j("write object error: unsupport type. " + obj.getClass());
            AppMethodBeat.m2505o(100320);
            throw c5891j;
        }
    }

    /* renamed from: a */
    public int mo40662a(String str) {
        this.f4760a = str;
        return 0;
    }
}
