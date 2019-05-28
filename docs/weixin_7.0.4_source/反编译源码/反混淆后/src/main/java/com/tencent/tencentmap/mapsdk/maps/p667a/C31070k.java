package com.tencent.tencentmap.mapsdk.maps.p667a;

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

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.k */
public final class C31070k {
    /* renamed from: a */
    protected String f14302a = "GBK";
    /* renamed from: b */
    private ByteBuffer f14303b;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.k$a */
    public static class C31071a {
        /* renamed from: a */
        public byte f14304a;
        /* renamed from: b */
        public int f14305b;
    }

    public C31070k(byte[] bArr) {
        AppMethodBeat.m2504i(100157);
        this.f14303b = ByteBuffer.wrap(bArr);
        AppMethodBeat.m2505o(100157);
    }

    public C31070k(byte[] bArr, int i) {
        AppMethodBeat.m2504i(100158);
        this.f14303b = ByteBuffer.wrap(bArr);
        this.f14303b.position(i);
        AppMethodBeat.m2505o(100158);
    }

    /* renamed from: a */
    public final void mo50514a(byte[] bArr) {
        AppMethodBeat.m2504i(100159);
        this.f14303b = ByteBuffer.wrap(bArr);
        AppMethodBeat.m2505o(100159);
    }

    /* renamed from: a */
    public static int m50094a(C31071a c31071a, ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(100160);
        byte b = byteBuffer.get();
        c31071a.f14304a = (byte) (b & 15);
        c31071a.f14305b = (b & 240) >> 4;
        if (c31071a.f14305b == 15) {
            c31071a.f14305b = byteBuffer.get() & 255;
            AppMethodBeat.m2505o(100160);
            return 2;
        }
        AppMethodBeat.m2505o(100160);
        return 1;
    }

    /* renamed from: a */
    public final void mo50513a(C31071a c31071a) {
        AppMethodBeat.m2504i(100161);
        C31070k.m50094a(c31071a, this.f14303b);
        AppMethodBeat.m2505o(100161);
    }

    /* renamed from: b */
    private int m50097b(C31071a c31071a) {
        AppMethodBeat.m2504i(100162);
        int a = C31070k.m50094a(c31071a, this.f14303b.duplicate());
        AppMethodBeat.m2505o(100162);
        return a;
    }

    /* renamed from: b */
    private void m50099b(int i) {
        AppMethodBeat.m2504i(100163);
        this.f14303b.position(this.f14303b.position() + i);
        AppMethodBeat.m2505o(100163);
    }

    /* renamed from: a */
    public final boolean mo50515a(int i) {
        AppMethodBeat.m2504i(100164);
        try {
            C31071a c31071a = new C31071a();
            while (true) {
                int b = m50097b(c31071a);
                if (i > c31071a.f14305b && c31071a.f14304a != (byte) 11) {
                    m50099b(b);
                    m50096a(c31071a.f14304a);
                }
            }
            if (c31071a.f14304a == (byte) 11) {
                AppMethodBeat.m2505o(100164);
                return false;
            } else if (i == c31071a.f14305b) {
                AppMethodBeat.m2505o(100164);
                return true;
            } else {
                AppMethodBeat.m2505o(100164);
                return false;
            }
        } catch (C41058h | BufferUnderflowException e) {
            AppMethodBeat.m2505o(100164);
            return false;
        }
    }

    /* renamed from: a */
    public final void mo50512a() {
        AppMethodBeat.m2504i(100165);
        C31071a c31071a = new C31071a();
        do {
            mo50513a(c31071a);
            m50096a(c31071a.f14304a);
        } while (c31071a.f14304a != (byte) 11);
        AppMethodBeat.m2505o(100165);
    }

    /* renamed from: b */
    private void m50098b() {
        AppMethodBeat.m2504i(100166);
        C31071a c31071a = new C31071a();
        mo50513a(c31071a);
        m50096a(c31071a.f14304a);
        AppMethodBeat.m2505o(100166);
    }

    /* renamed from: a */
    private void m50096a(byte b) {
        int i = 0;
        AppMethodBeat.m2504i(100167);
        int a;
        C41058h c41058h;
        switch (b) {
            case (byte) 0:
                m50099b(1);
                AppMethodBeat.m2505o(100167);
                return;
            case (byte) 1:
                m50099b(2);
                AppMethodBeat.m2505o(100167);
                return;
            case (byte) 2:
                m50099b(4);
                AppMethodBeat.m2505o(100167);
                return;
            case (byte) 3:
                m50099b(8);
                AppMethodBeat.m2505o(100167);
                return;
            case (byte) 4:
                m50099b(4);
                AppMethodBeat.m2505o(100167);
                return;
            case (byte) 5:
                m50099b(8);
                AppMethodBeat.m2505o(100167);
                return;
            case (byte) 6:
                i = this.f14303b.get();
                if (i < 0) {
                    i += 256;
                }
                m50099b(i);
                AppMethodBeat.m2505o(100167);
                return;
            case (byte) 7:
                m50099b(this.f14303b.getInt());
                AppMethodBeat.m2505o(100167);
                return;
            case (byte) 8:
                a = mo50503a(0, 0, true);
                while (i < a * 2) {
                    m50098b();
                    i++;
                }
                AppMethodBeat.m2505o(100167);
                return;
            case (byte) 9:
                a = mo50503a(0, 0, true);
                while (i < a) {
                    m50098b();
                    i++;
                }
                AppMethodBeat.m2505o(100167);
                return;
            case (byte) 10:
                mo50512a();
                AppMethodBeat.m2505o(100167);
                return;
            case (byte) 11:
            case (byte) 12:
                AppMethodBeat.m2505o(100167);
                return;
            case (byte) 13:
                C31071a c31071a = new C31071a();
                mo50513a(c31071a);
                if (c31071a.f14304a != (byte) 0) {
                    c41058h = new C41058h("skipField with invalid type, type value: " + b + ", " + c31071a.f14304a);
                    AppMethodBeat.m2505o(100167);
                    throw c41058h;
                }
                m50099b(mo50503a(0, 0, true));
                AppMethodBeat.m2505o(100167);
                return;
            default:
                c41058h = new C41058h("invalid type.");
                AppMethodBeat.m2505o(100167);
                throw c41058h;
        }
    }

    /* renamed from: a */
    public final boolean mo50516a(boolean z, int i, boolean z2) {
        AppMethodBeat.m2504i(100168);
        if (mo50500a((byte) 0, i, z2) != (byte) 0) {
            AppMethodBeat.m2505o(100168);
            return true;
        }
        AppMethodBeat.m2505o(100168);
        return false;
    }

    /* renamed from: a */
    public final byte mo50500a(byte b, int i, boolean z) {
        AppMethodBeat.m2504i(100169);
        C41058h c41058h;
        if (mo50515a(i)) {
            C31071a c31071a = new C31071a();
            mo50513a(c31071a);
            switch (c31071a.f14304a) {
                case (byte) 0:
                    b = this.f14303b.get();
                    break;
                case (byte) 12:
                    b = (byte) 0;
                    break;
                default:
                    c41058h = new C41058h("type mismatch.");
                    AppMethodBeat.m2505o(100169);
                    throw c41058h;
            }
        } else if (z) {
            c41058h = new C41058h("require field not exist.");
            AppMethodBeat.m2505o(100169);
            throw c41058h;
        }
        AppMethodBeat.m2505o(100169);
        return b;
    }

    /* renamed from: a */
    public final short mo50511a(short s, int i, boolean z) {
        AppMethodBeat.m2504i(100170);
        C41058h c41058h;
        if (mo50515a(i)) {
            C31071a c31071a = new C31071a();
            mo50513a(c31071a);
            switch (c31071a.f14304a) {
                case (byte) 0:
                    s = (short) this.f14303b.get();
                    break;
                case (byte) 1:
                    s = this.f14303b.getShort();
                    break;
                case (byte) 12:
                    s = (short) 0;
                    break;
                default:
                    c41058h = new C41058h("type mismatch.");
                    AppMethodBeat.m2505o(100170);
                    throw c41058h;
            }
        } else if (z) {
            c41058h = new C41058h("require field not exist.");
            AppMethodBeat.m2505o(100170);
            throw c41058h;
        }
        AppMethodBeat.m2505o(100170);
        return s;
    }

    /* renamed from: a */
    public final int mo50503a(int i, int i2, boolean z) {
        AppMethodBeat.m2504i(100171);
        C41058h c41058h;
        if (mo50515a(i2)) {
            C31071a c31071a = new C31071a();
            mo50513a(c31071a);
            switch (c31071a.f14304a) {
                case (byte) 0:
                    i = this.f14303b.get();
                    break;
                case (byte) 1:
                    i = this.f14303b.getShort();
                    break;
                case (byte) 2:
                    i = this.f14303b.getInt();
                    break;
                case (byte) 12:
                    i = 0;
                    break;
                default:
                    c41058h = new C41058h("type mismatch.");
                    AppMethodBeat.m2505o(100171);
                    throw c41058h;
            }
        } else if (z) {
            c41058h = new C41058h("require field not exist.");
            AppMethodBeat.m2505o(100171);
            throw c41058h;
        }
        AppMethodBeat.m2505o(100171);
        return i;
    }

    /* renamed from: a */
    public final long mo50505a(long j, int i, boolean z) {
        AppMethodBeat.m2504i(100172);
        C41058h c41058h;
        if (mo50515a(i)) {
            C31071a c31071a = new C31071a();
            mo50513a(c31071a);
            switch (c31071a.f14304a) {
                case (byte) 0:
                    j = (long) this.f14303b.get();
                    break;
                case (byte) 1:
                    j = (long) this.f14303b.getShort();
                    break;
                case (byte) 2:
                    j = (long) this.f14303b.getInt();
                    break;
                case (byte) 3:
                    j = this.f14303b.getLong();
                    break;
                case (byte) 12:
                    j = 0;
                    break;
                default:
                    c41058h = new C41058h("type mismatch.");
                    AppMethodBeat.m2505o(100172);
                    throw c41058h;
            }
        } else if (z) {
            c41058h = new C41058h("require field not exist.");
            AppMethodBeat.m2505o(100172);
            throw c41058h;
        }
        AppMethodBeat.m2505o(100172);
        return j;
    }

    /* renamed from: a */
    public final float mo50502a(float f, int i, boolean z) {
        AppMethodBeat.m2504i(100173);
        C41058h c41058h;
        if (mo50515a(i)) {
            C31071a c31071a = new C31071a();
            mo50513a(c31071a);
            switch (c31071a.f14304a) {
                case (byte) 4:
                    f = this.f14303b.getFloat();
                    break;
                case (byte) 12:
                    f = 0.0f;
                    break;
                default:
                    c41058h = new C41058h("type mismatch.");
                    AppMethodBeat.m2505o(100173);
                    throw c41058h;
            }
        } else if (z) {
            c41058h = new C41058h("require field not exist.");
            AppMethodBeat.m2505o(100173);
            throw c41058h;
        }
        AppMethodBeat.m2505o(100173);
        return f;
    }

    /* renamed from: a */
    public final double mo50501a(double d, int i, boolean z) {
        AppMethodBeat.m2504i(100174);
        C41058h c41058h;
        if (mo50515a(i)) {
            C31071a c31071a = new C31071a();
            mo50513a(c31071a);
            switch (c31071a.f14304a) {
                case (byte) 4:
                    d = (double) this.f14303b.getFloat();
                    break;
                case (byte) 5:
                    d = this.f14303b.getDouble();
                    break;
                case (byte) 12:
                    d = 0.0d;
                    break;
                default:
                    c41058h = new C41058h("type mismatch.");
                    AppMethodBeat.m2505o(100174);
                    throw c41058h;
            }
        } else if (z) {
            c41058h = new C41058h("require field not exist.");
            AppMethodBeat.m2505o(100174);
            throw c41058h;
        }
        AppMethodBeat.m2505o(100174);
        return d;
    }

    /* renamed from: a */
    public final String mo50508a(int i, boolean z) {
        AppMethodBeat.m2504i(100175);
        String str = null;
        C41058h c41058h;
        if (mo50515a(i)) {
            C31071a c31071a = new C31071a();
            mo50513a(c31071a);
            int i2;
            byte[] bArr;
            switch (c31071a.f14304a) {
                case (byte) 6:
                    i2 = this.f14303b.get();
                    if (i2 < 0) {
                        i2 += 256;
                    }
                    bArr = new byte[i2];
                    this.f14303b.get(bArr);
                    try {
                        str = new String(bArr, this.f14302a);
                        break;
                    } catch (UnsupportedEncodingException e) {
                        str = new String(bArr);
                        break;
                    }
                case (byte) 7:
                    i2 = this.f14303b.getInt();
                    if (i2 <= 104857600 && i2 >= 0 && i2 <= this.f14303b.capacity()) {
                        bArr = new byte[i2];
                        this.f14303b.get(bArr);
                        try {
                            str = new String(bArr, this.f14302a);
                            break;
                        } catch (UnsupportedEncodingException e2) {
                            str = new String(bArr);
                            break;
                        }
                    }
                    C41058h c41058h2 = new C41058h("String too long: ".concat(String.valueOf(i2)));
                    AppMethodBeat.m2505o(100175);
                    throw c41058h2;
                    break;
                default:
                    c41058h = new C41058h("type mismatch.");
                    AppMethodBeat.m2505o(100175);
                    throw c41058h;
            }
        } else if (z) {
            c41058h = new C41058h("require field not exist.");
            AppMethodBeat.m2505o(100175);
            throw c41058h;
        }
        AppMethodBeat.m2505o(100175);
        return str;
    }

    /* renamed from: a */
    public final <K, V> HashMap<K, V> mo50509a(Map<K, V> map, int i, boolean z) {
        AppMethodBeat.m2504i(100176);
        HashMap hashMap = (HashMap) m50095a(new HashMap(), map, i, z);
        AppMethodBeat.m2505o(100176);
        return hashMap;
    }

    /* renamed from: a */
    private <K, V> Map<K, V> m50095a(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        AppMethodBeat.m2504i(100177);
        if (map2 == null || map2.isEmpty()) {
            HashMap hashMap = new HashMap();
            AppMethodBeat.m2505o(100177);
            return hashMap;
        }
        Entry entry = (Entry) map2.entrySet().iterator().next();
        Object key = entry.getKey();
        Object value = entry.getValue();
        C41058h c41058h;
        if (mo50515a(i)) {
            C31071a c31071a = new C31071a();
            mo50513a(c31071a);
            switch (c31071a.f14304a) {
                case (byte) 8:
                    int a = mo50503a(0, 0, true);
                    if (a >= 0) {
                        for (int i2 = 0; i2 < a; i2++) {
                            map.put(mo50507a(key, 0, true), mo50507a(value, 1, true));
                        }
                        break;
                    }
                    c41058h = new C41058h("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.m2505o(100177);
                    throw c41058h;
                default:
                    c41058h = new C41058h("type mismatch.");
                    AppMethodBeat.m2505o(100177);
                    throw c41058h;
            }
        } else if (z) {
            c41058h = new C41058h("require field not exist.");
            AppMethodBeat.m2505o(100177);
            throw c41058h;
        }
        AppMethodBeat.m2505o(100177);
        return map;
    }

    /* renamed from: a */
    public final boolean[] mo50524a(boolean[] zArr, int i, boolean z) {
        AppMethodBeat.m2504i(100178);
        boolean[] zArr2 = null;
        C41058h c41058h;
        if (mo50515a(i)) {
            C31071a c31071a = new C31071a();
            mo50513a(c31071a);
            switch (c31071a.f14304a) {
                case (byte) 9:
                    int a = mo50503a(0, 0, true);
                    if (a >= 0) {
                        zArr2 = new boolean[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            zArr2[i2] = mo50516a(zArr2[0], 0, true);
                        }
                        break;
                    }
                    c41058h = new C41058h("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.m2505o(100178);
                    throw c41058h;
                default:
                    c41058h = new C41058h("type mismatch.");
                    AppMethodBeat.m2505o(100178);
                    throw c41058h;
            }
        } else if (z) {
            c41058h = new C41058h("require field not exist.");
            AppMethodBeat.m2505o(100178);
            throw c41058h;
        }
        AppMethodBeat.m2505o(100178);
        return zArr2;
    }

    /* renamed from: a */
    public final byte[] mo50517a(byte[] bArr, int i, boolean z) {
        AppMethodBeat.m2504i(100179);
        byte[] bArr2 = null;
        C41058h c41058h;
        if (mo50515a(i)) {
            C31071a c31071a = new C31071a();
            mo50513a(c31071a);
            switch (c31071a.f14304a) {
                case (byte) 9:
                    int a = mo50503a(0, 0, true);
                    if (a >= 0 && a <= this.f14303b.capacity()) {
                        bArr2 = new byte[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            bArr2[i2] = mo50500a(bArr2[0], 0, true);
                        }
                        break;
                    }
                    c41058h = new C41058h("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.m2505o(100179);
                    throw c41058h;
                    break;
                case (byte) 13:
                    C31071a c31071a2 = new C31071a();
                    mo50513a(c31071a2);
                    if (c31071a2.f14304a == (byte) 0) {
                        int a2 = mo50503a(0, 0, true);
                        if (a2 >= 0 && a2 <= this.f14303b.capacity()) {
                            bArr2 = new byte[a2];
                            this.f14303b.get(bArr2);
                            break;
                        }
                        C41058h c41058h2 = new C41058h("invalid size, tag: " + i + ", type: " + c31071a.f14304a + ", " + c31071a2.f14304a + ", size: " + a2);
                        AppMethodBeat.m2505o(100179);
                        throw c41058h2;
                    }
                    C41058h c41058h3 = new C41058h("type mismatch, tag: " + i + ", type: " + c31071a.f14304a + ", " + c31071a2.f14304a);
                    AppMethodBeat.m2505o(100179);
                    throw c41058h3;
                default:
                    c41058h = new C41058h("type mismatch.");
                    AppMethodBeat.m2505o(100179);
                    throw c41058h;
            }
        } else if (z) {
            c41058h = new C41058h("require field not exist.");
            AppMethodBeat.m2505o(100179);
            throw c41058h;
        }
        AppMethodBeat.m2505o(100179);
        return bArr2;
    }

    /* renamed from: a */
    public final short[] mo50523a(short[] sArr, int i, boolean z) {
        AppMethodBeat.m2504i(100180);
        short[] sArr2 = null;
        C41058h c41058h;
        if (mo50515a(i)) {
            C31071a c31071a = new C31071a();
            mo50513a(c31071a);
            switch (c31071a.f14304a) {
                case (byte) 9:
                    int a = mo50503a(0, 0, true);
                    if (a >= 0) {
                        sArr2 = new short[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            sArr2[i2] = mo50511a(sArr2[0], 0, true);
                        }
                        break;
                    }
                    c41058h = new C41058h("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.m2505o(100180);
                    throw c41058h;
                default:
                    c41058h = new C41058h("type mismatch.");
                    AppMethodBeat.m2505o(100180);
                    throw c41058h;
            }
        } else if (z) {
            c41058h = new C41058h("require field not exist.");
            AppMethodBeat.m2505o(100180);
            throw c41058h;
        }
        AppMethodBeat.m2505o(100180);
        return sArr2;
    }

    /* renamed from: a */
    public final int[] mo50520a(int[] iArr, int i, boolean z) {
        AppMethodBeat.m2504i(100181);
        int[] iArr2 = null;
        C41058h c41058h;
        if (mo50515a(i)) {
            C31071a c31071a = new C31071a();
            mo50513a(c31071a);
            switch (c31071a.f14304a) {
                case (byte) 9:
                    int a = mo50503a(0, 0, true);
                    if (a >= 0) {
                        iArr2 = new int[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            iArr2[i2] = mo50503a(iArr2[0], 0, true);
                        }
                        break;
                    }
                    c41058h = new C41058h("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.m2505o(100181);
                    throw c41058h;
                default:
                    c41058h = new C41058h("type mismatch.");
                    AppMethodBeat.m2505o(100181);
                    throw c41058h;
            }
        } else if (z) {
            c41058h = new C41058h("require field not exist.");
            AppMethodBeat.m2505o(100181);
            throw c41058h;
        }
        AppMethodBeat.m2505o(100181);
        return iArr2;
    }

    /* renamed from: a */
    public final long[] mo50521a(long[] jArr, int i, boolean z) {
        AppMethodBeat.m2504i(100182);
        long[] jArr2 = null;
        C41058h c41058h;
        if (mo50515a(i)) {
            C31071a c31071a = new C31071a();
            mo50513a(c31071a);
            switch (c31071a.f14304a) {
                case (byte) 9:
                    int a = mo50503a(0, 0, true);
                    if (a >= 0) {
                        jArr2 = new long[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            jArr2[i2] = mo50505a(jArr2[0], 0, true);
                        }
                        break;
                    }
                    c41058h = new C41058h("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.m2505o(100182);
                    throw c41058h;
                default:
                    c41058h = new C41058h("type mismatch.");
                    AppMethodBeat.m2505o(100182);
                    throw c41058h;
            }
        } else if (z) {
            c41058h = new C41058h("require field not exist.");
            AppMethodBeat.m2505o(100182);
            throw c41058h;
        }
        AppMethodBeat.m2505o(100182);
        return jArr2;
    }

    /* renamed from: a */
    public final float[] mo50519a(float[] fArr, int i, boolean z) {
        AppMethodBeat.m2504i(100183);
        float[] fArr2 = null;
        C41058h c41058h;
        if (mo50515a(i)) {
            C31071a c31071a = new C31071a();
            mo50513a(c31071a);
            switch (c31071a.f14304a) {
                case (byte) 9:
                    int a = mo50503a(0, 0, true);
                    if (a >= 0) {
                        fArr2 = new float[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            fArr2[i2] = mo50502a(fArr2[0], 0, true);
                        }
                        break;
                    }
                    c41058h = new C41058h("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.m2505o(100183);
                    throw c41058h;
                default:
                    c41058h = new C41058h("type mismatch.");
                    AppMethodBeat.m2505o(100183);
                    throw c41058h;
            }
        } else if (z) {
            c41058h = new C41058h("require field not exist.");
            AppMethodBeat.m2505o(100183);
            throw c41058h;
        }
        AppMethodBeat.m2505o(100183);
        return fArr2;
    }

    /* renamed from: a */
    public final double[] mo50518a(double[] dArr, int i, boolean z) {
        AppMethodBeat.m2504i(100184);
        double[] dArr2 = null;
        C41058h c41058h;
        if (mo50515a(i)) {
            C31071a c31071a = new C31071a();
            mo50513a(c31071a);
            switch (c31071a.f14304a) {
                case (byte) 9:
                    int a = mo50503a(0, 0, true);
                    if (a >= 0) {
                        dArr2 = new double[a];
                        for (int i2 = 0; i2 < a; i2++) {
                            dArr2[i2] = mo50501a(dArr2[0], 0, true);
                        }
                        break;
                    }
                    c41058h = new C41058h("size invalid: ".concat(String.valueOf(a)));
                    AppMethodBeat.m2505o(100184);
                    throw c41058h;
                default:
                    c41058h = new C41058h("type mismatch.");
                    AppMethodBeat.m2505o(100184);
                    throw c41058h;
            }
        } else if (z) {
            c41058h = new C41058h("require field not exist.");
            AppMethodBeat.m2505o(100184);
            throw c41058h;
        }
        AppMethodBeat.m2505o(100184);
        return dArr2;
    }

    /* renamed from: a */
    public final <T> T[] mo50522a(T[] tArr, int i, boolean z) {
        AppMethodBeat.m2504i(100185);
        if (tArr == null || tArr.length == 0) {
            C41058h c41058h = new C41058h("unable to get type of key and value.");
            AppMethodBeat.m2505o(100185);
            throw c41058h;
        }
        Object[] b = m50100b(tArr[0], i, z);
        AppMethodBeat.m2505o(100185);
        return b;
    }

    /* renamed from: a */
    public final <T> List<T> mo50510a(List<T> list, int i, boolean z) {
        int i2 = 0;
        AppMethodBeat.m2504i(100186);
        if (list == null || list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.m2505o(100186);
            return arrayList;
        }
        Object[] b = m50100b(list.get(0), i, z);
        if (b == null) {
            AppMethodBeat.m2505o(100186);
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        while (i2 < b.length) {
            arrayList2.add(b[i2]);
            i2++;
        }
        AppMethodBeat.m2505o(100186);
        return arrayList2;
    }

    /* renamed from: b */
    private <T> T[] m50100b(T t, int i, boolean z) {
        AppMethodBeat.m2504i(100187);
        C41058h c41058h;
        if (mo50515a(i)) {
            C31071a c31071a = new C31071a();
            mo50513a(c31071a);
            switch (c31071a.f14304a) {
                case (byte) 9:
                    int a = mo50503a(0, 0, true);
                    if (a < 0) {
                        c41058h = new C41058h("size invalid: ".concat(String.valueOf(a)));
                        AppMethodBeat.m2505o(100187);
                        throw c41058h;
                    }
                    Object[] objArr = (Object[]) Array.newInstance(t.getClass(), a);
                    for (int i2 = 0; i2 < a; i2++) {
                        objArr[i2] = mo50507a((Object) t, 0, true);
                    }
                    AppMethodBeat.m2505o(100187);
                    return objArr;
                default:
                    c41058h = new C41058h("type mismatch.");
                    AppMethodBeat.m2505o(100187);
                    throw c41058h;
            }
        } else if (z) {
            c41058h = new C41058h("require field not exist.");
            AppMethodBeat.m2505o(100187);
            throw c41058h;
        } else {
            AppMethodBeat.m2505o(100187);
            return null;
        }
    }

    /* renamed from: a */
    public final C46803m mo50506a(C46803m c46803m, int i, boolean z) {
        AppMethodBeat.m2504i(100188);
        C46803m c46803m2 = null;
        C41058h c41058h;
        if (mo50515a(i)) {
            try {
                c46803m2 = (C46803m) c46803m.getClass().newInstance();
                C31071a c31071a = new C31071a();
                mo50513a(c31071a);
                if (c31071a.f14304a != (byte) 10) {
                    c41058h = new C41058h("type mismatch.");
                    AppMethodBeat.m2505o(100188);
                    throw c41058h;
                }
                c46803m2.readFrom(this);
                mo50512a();
            } catch (Exception e) {
                C41058h c41058h2 = new C41058h(e.getMessage());
                AppMethodBeat.m2505o(100188);
                throw c41058h2;
            }
        } else if (z) {
            c41058h = new C41058h("require field not exist.");
            AppMethodBeat.m2505o(100188);
            throw c41058h;
        }
        AppMethodBeat.m2505o(100188);
        return c46803m2;
    }

    /* renamed from: a */
    public final <T> Object mo50507a(T t, int i, boolean z) {
        AppMethodBeat.m2504i(100189);
        Object valueOf;
        if (t instanceof Byte) {
            Byte valueOf2 = Byte.valueOf(mo50500a((byte) 0, i, z));
            AppMethodBeat.m2505o(100189);
            return valueOf2;
        } else if (t instanceof Boolean) {
            valueOf = Boolean.valueOf(mo50516a(false, i, z));
            AppMethodBeat.m2505o(100189);
            return valueOf;
        } else if (t instanceof Short) {
            valueOf = Short.valueOf(mo50511a((short) 0, i, z));
            AppMethodBeat.m2505o(100189);
            return valueOf;
        } else if (t instanceof Integer) {
            valueOf = Integer.valueOf(mo50503a(0, i, z));
            AppMethodBeat.m2505o(100189);
            return valueOf;
        } else if (t instanceof Long) {
            valueOf = Long.valueOf(mo50505a(0, i, z));
            AppMethodBeat.m2505o(100189);
            return valueOf;
        } else if (t instanceof Float) {
            valueOf = Float.valueOf(mo50502a(0.0f, i, z));
            AppMethodBeat.m2505o(100189);
            return valueOf;
        } else if (t instanceof Double) {
            valueOf = Double.valueOf(mo50501a(0.0d, i, z));
            AppMethodBeat.m2505o(100189);
            return valueOf;
        } else if (t instanceof String) {
            valueOf = mo50508a(i, z);
            AppMethodBeat.m2505o(100189);
            return valueOf;
        } else if (t instanceof Map) {
            valueOf = mo50509a((Map) t, i, z);
            AppMethodBeat.m2505o(100189);
            return valueOf;
        } else if (t instanceof List) {
            valueOf = mo50510a((List) t, i, z);
            AppMethodBeat.m2505o(100189);
            return valueOf;
        } else if (t instanceof C46803m) {
            valueOf = mo50506a((C46803m) t, i, z);
            AppMethodBeat.m2505o(100189);
            return valueOf;
        } else if (!t.getClass().isArray()) {
            C41058h c41058h = new C41058h("read object error: unsupport type.");
            AppMethodBeat.m2505o(100189);
            throw c41058h;
        } else if ((t instanceof byte[]) || (t instanceof Byte[])) {
            valueOf = mo50517a(null, i, z);
            AppMethodBeat.m2505o(100189);
            return valueOf;
        } else if (t instanceof boolean[]) {
            valueOf = mo50524a(null, i, z);
            AppMethodBeat.m2505o(100189);
            return valueOf;
        } else if (t instanceof short[]) {
            valueOf = mo50523a(null, i, z);
            AppMethodBeat.m2505o(100189);
            return valueOf;
        } else if (t instanceof int[]) {
            valueOf = mo50520a(null, i, z);
            AppMethodBeat.m2505o(100189);
            return valueOf;
        } else if (t instanceof long[]) {
            valueOf = mo50521a(null, i, z);
            AppMethodBeat.m2505o(100189);
            return valueOf;
        } else if (t instanceof float[]) {
            valueOf = mo50519a(null, i, z);
            AppMethodBeat.m2505o(100189);
            return valueOf;
        } else if (t instanceof double[]) {
            valueOf = mo50518a(null, i, z);
            AppMethodBeat.m2505o(100189);
            return valueOf;
        } else {
            valueOf = mo50522a((Object[]) t, i, z);
            AppMethodBeat.m2505o(100189);
            return valueOf;
        }
    }

    /* renamed from: a */
    public final int mo50504a(String str) {
        this.f14302a = str;
        return 0;
    }
}
