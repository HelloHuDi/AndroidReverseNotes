package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.i */
public final class C16278i {
    /* renamed from: a */
    private StringBuilder f3414a;
    /* renamed from: b */
    private int f3415b = 0;

    /* renamed from: a */
    private void m24992a(String str) {
        AppMethodBeat.m2504i(99705);
        for (int i = 0; i < this.f3415b; i++) {
            this.f3414a.append(9);
        }
        if (str != null) {
            this.f3414a.append(str).append(": ");
        }
        AppMethodBeat.m2505o(99705);
    }

    public C16278i(StringBuilder stringBuilder, int i) {
        this.f3414a = stringBuilder;
        this.f3415b = i;
    }

    /* renamed from: a */
    public final C16278i mo29485a(boolean z, String str) {
        AppMethodBeat.m2504i(99706);
        m24992a(str);
        this.f3414a.append(z ? 'T' : 'F').append(10);
        AppMethodBeat.m2505o(99706);
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29486a(boolean z, boolean z2) {
        AppMethodBeat.m2504i(99707);
        this.f3414a.append(z ? 'T' : 'F');
        if (z2) {
            this.f3414a.append("|");
        }
        AppMethodBeat.m2505o(99707);
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29462a(byte b, String str) {
        AppMethodBeat.m2504i(99708);
        m24992a(str);
        this.f3414a.append(b).append(10);
        AppMethodBeat.m2505o(99708);
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29463a(byte b, boolean z) {
        AppMethodBeat.m2504i(99709);
        this.f3414a.append(b);
        if (z) {
            this.f3414a.append("|");
        }
        AppMethodBeat.m2505o(99709);
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29464a(char c, String str) {
        AppMethodBeat.m2504i(99710);
        m24992a(str);
        this.f3414a.append(c).append(10);
        AppMethodBeat.m2505o(99710);
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29483a(short s, String str) {
        AppMethodBeat.m2504i(99711);
        m24992a(str);
        this.f3414a.append(s).append(10);
        AppMethodBeat.m2505o(99711);
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29484a(short s, boolean z) {
        AppMethodBeat.m2504i(99712);
        this.f3414a.append(s);
        if (z) {
            this.f3414a.append("|");
        }
        AppMethodBeat.m2505o(99712);
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29469a(int i, String str) {
        AppMethodBeat.m2504i(99713);
        m24992a(str);
        this.f3414a.append(i).append(10);
        AppMethodBeat.m2505o(99713);
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29470a(int i, boolean z) {
        AppMethodBeat.m2504i(99714);
        this.f3414a.append(i);
        if (z) {
            this.f3414a.append("|");
        }
        AppMethodBeat.m2505o(99714);
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29471a(long j, String str) {
        AppMethodBeat.m2504i(99715);
        m24992a(str);
        this.f3414a.append(j).append(10);
        AppMethodBeat.m2505o(99715);
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29472a(long j, boolean z) {
        AppMethodBeat.m2504i(99716);
        this.f3414a.append(j);
        if (z) {
            this.f3414a.append("|");
        }
        AppMethodBeat.m2505o(99716);
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29467a(float f, String str) {
        AppMethodBeat.m2504i(99717);
        m24992a(str);
        this.f3414a.append(f).append(10);
        AppMethodBeat.m2505o(99717);
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29468a(float f, boolean z) {
        AppMethodBeat.m2504i(99718);
        this.f3414a.append(f);
        if (z) {
            this.f3414a.append("|");
        }
        AppMethodBeat.m2505o(99718);
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29465a(double d, String str) {
        AppMethodBeat.m2504i(99719);
        m24992a(str);
        this.f3414a.append(d).append(10);
        AppMethodBeat.m2505o(99719);
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29466a(double d, boolean z) {
        AppMethodBeat.m2504i(99720);
        this.f3414a.append(d);
        if (z) {
            this.f3414a.append("|");
        }
        AppMethodBeat.m2505o(99720);
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29477a(String str, String str2) {
        AppMethodBeat.m2504i(99721);
        m24992a(str2);
        if (str == null) {
            this.f3414a.append("null\n");
        } else {
            this.f3414a.append(str).append(10);
        }
        AppMethodBeat.m2505o(99721);
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29478a(String str, boolean z) {
        AppMethodBeat.m2504i(99722);
        if (str == null) {
            this.f3414a.append(BuildConfig.COMMAND);
        } else {
            this.f3414a.append(str);
        }
        if (z) {
            this.f3414a.append("|");
        }
        AppMethodBeat.m2505o(99722);
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29487a(byte[] bArr, String str) {
        AppMethodBeat.m2504i(99723);
        m24992a(str);
        if (bArr == null) {
            this.f3414a.append("null\n");
            AppMethodBeat.m2505o(99723);
        } else if (bArr.length == 0) {
            this.f3414a.append(bArr.length).append(", []\n");
            AppMethodBeat.m2505o(99723);
        } else {
            this.f3414a.append(bArr.length).append(", [\n");
            C16278i c16278i = new C16278i(this.f3414a, this.f3415b + 1);
            for (byte a : bArr) {
                c16278i.mo29462a(a, null);
            }
            mo29464a(']', null);
            AppMethodBeat.m2505o(99723);
        }
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29488a(byte[] bArr, boolean z) {
        AppMethodBeat.m2504i(99724);
        if (bArr == null || bArr.length == 0) {
            if (z) {
                this.f3414a.append("|");
            }
            AppMethodBeat.m2505o(99724);
        } else {
            this.f3414a.append(C36511g.m60418a(bArr));
            if (z) {
                this.f3414a.append("|");
            }
            AppMethodBeat.m2505o(99724);
        }
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29499a(short[] sArr, String str) {
        AppMethodBeat.m2504i(99725);
        m24992a(str);
        if (sArr == null) {
            this.f3414a.append("null\n");
            AppMethodBeat.m2505o(99725);
        } else if (sArr.length == 0) {
            this.f3414a.append(sArr.length).append(", []\n");
            AppMethodBeat.m2505o(99725);
        } else {
            this.f3414a.append(sArr.length).append(", [\n");
            C16278i c16278i = new C16278i(this.f3414a, this.f3415b + 1);
            for (short a : sArr) {
                c16278i.mo29483a(a, null);
            }
            mo29464a(']', null);
            AppMethodBeat.m2505o(99725);
        }
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29500a(short[] sArr, boolean z) {
        AppMethodBeat.m2504i(99726);
        if (sArr == null || sArr.length == 0) {
            this.f3414a.append("[]");
            if (z) {
                this.f3414a.append("|");
            }
            AppMethodBeat.m2505o(99726);
        } else {
            this.f3414a.append("[");
            C16278i c16278i = new C16278i(this.f3414a, this.f3415b + 1);
            for (int i = 0; i < sArr.length; i++) {
                short s = sArr[i];
                if (i != 0) {
                    this.f3414a.append("|");
                }
                c16278i.mo29484a(s, false);
            }
            this.f3414a.append("]");
            if (z) {
                this.f3414a.append("|");
            }
            AppMethodBeat.m2505o(99726);
        }
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29493a(int[] iArr, String str) {
        AppMethodBeat.m2504i(99727);
        m24992a(str);
        if (iArr == null) {
            this.f3414a.append("null\n");
            AppMethodBeat.m2505o(99727);
        } else if (iArr.length == 0) {
            this.f3414a.append(iArr.length).append(", []\n");
            AppMethodBeat.m2505o(99727);
        } else {
            this.f3414a.append(iArr.length).append(", [\n");
            C16278i c16278i = new C16278i(this.f3414a, this.f3415b + 1);
            for (int a : iArr) {
                c16278i.mo29469a(a, null);
            }
            mo29464a(']', null);
            AppMethodBeat.m2505o(99727);
        }
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29494a(int[] iArr, boolean z) {
        AppMethodBeat.m2504i(99728);
        if (iArr == null || iArr.length == 0) {
            this.f3414a.append("[]");
            if (z) {
                this.f3414a.append("|");
            }
            AppMethodBeat.m2505o(99728);
        } else {
            this.f3414a.append("[");
            C16278i c16278i = new C16278i(this.f3414a, this.f3415b + 1);
            for (int i = 0; i < iArr.length; i++) {
                int i2 = iArr[i];
                if (i != 0) {
                    this.f3414a.append("|");
                }
                c16278i.mo29470a(i2, false);
            }
            this.f3414a.append("]");
            if (z) {
                this.f3414a.append("|");
            }
            AppMethodBeat.m2505o(99728);
        }
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29495a(long[] jArr, String str) {
        AppMethodBeat.m2504i(99729);
        m24992a(str);
        if (jArr == null) {
            this.f3414a.append("null\n");
            AppMethodBeat.m2505o(99729);
        } else if (jArr.length == 0) {
            this.f3414a.append(jArr.length).append(", []\n");
            AppMethodBeat.m2505o(99729);
        } else {
            this.f3414a.append(jArr.length).append(", [\n");
            C16278i c16278i = new C16278i(this.f3414a, this.f3415b + 1);
            for (long a : jArr) {
                c16278i.mo29471a(a, null);
            }
            mo29464a(']', null);
            AppMethodBeat.m2505o(99729);
        }
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29496a(long[] jArr, boolean z) {
        AppMethodBeat.m2504i(99730);
        if (jArr == null || jArr.length == 0) {
            this.f3414a.append("[]");
            if (z) {
                this.f3414a.append("|");
            }
            AppMethodBeat.m2505o(99730);
        } else {
            this.f3414a.append("[");
            C16278i c16278i = new C16278i(this.f3414a, this.f3415b + 1);
            for (int i = 0; i < jArr.length; i++) {
                long j = jArr[i];
                if (i != 0) {
                    this.f3414a.append("|");
                }
                c16278i.mo29472a(j, false);
            }
            this.f3414a.append("]");
            if (z) {
                this.f3414a.append("|");
            }
            AppMethodBeat.m2505o(99730);
        }
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29491a(float[] fArr, String str) {
        AppMethodBeat.m2504i(99731);
        m24992a(str);
        if (fArr == null) {
            this.f3414a.append("null\n");
            AppMethodBeat.m2505o(99731);
        } else if (fArr.length == 0) {
            this.f3414a.append(fArr.length).append(", []\n");
            AppMethodBeat.m2505o(99731);
        } else {
            this.f3414a.append(fArr.length).append(", [\n");
            C16278i c16278i = new C16278i(this.f3414a, this.f3415b + 1);
            for (float a : fArr) {
                c16278i.mo29467a(a, null);
            }
            mo29464a(']', null);
            AppMethodBeat.m2505o(99731);
        }
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29492a(float[] fArr, boolean z) {
        AppMethodBeat.m2504i(99732);
        if (fArr == null || fArr.length == 0) {
            this.f3414a.append("[]");
            if (z) {
                this.f3414a.append("|");
            }
            AppMethodBeat.m2505o(99732);
        } else {
            this.f3414a.append("[");
            C16278i c16278i = new C16278i(this.f3414a, this.f3415b + 1);
            for (int i = 0; i < fArr.length; i++) {
                float f = fArr[i];
                if (i != 0) {
                    this.f3414a.append("|");
                }
                c16278i.mo29468a(f, false);
            }
            this.f3414a.append("]");
            if (z) {
                this.f3414a.append("|");
            }
            AppMethodBeat.m2505o(99732);
        }
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29489a(double[] dArr, String str) {
        AppMethodBeat.m2504i(99733);
        m24992a(str);
        if (dArr == null) {
            this.f3414a.append("null\n");
            AppMethodBeat.m2505o(99733);
        } else if (dArr.length == 0) {
            this.f3414a.append(dArr.length).append(", []\n");
            AppMethodBeat.m2505o(99733);
        } else {
            this.f3414a.append(dArr.length).append(", [\n");
            C16278i c16278i = new C16278i(this.f3414a, this.f3415b + 1);
            for (double a : dArr) {
                c16278i.mo29465a(a, null);
            }
            mo29464a(']', null);
            AppMethodBeat.m2505o(99733);
        }
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29490a(double[] dArr, boolean z) {
        AppMethodBeat.m2504i(99734);
        if (dArr == null || dArr.length == 0) {
            this.f3414a.append("[]");
            if (z) {
                this.f3414a.append("|");
            }
            AppMethodBeat.m2505o(99734);
        } else {
            this.f3414a.append("[");
            C16278i c16278i = new C16278i(this.f3414a, this.f3415b + 1);
            for (int i = 0; i < dArr.length; i++) {
                double d = dArr[i];
                if (i != 0) {
                    this.f3414a.append("|");
                }
                c16278i.mo29466a(d, false);
            }
            this.f3414a.append("[");
            if (z) {
                this.f3414a.append("|");
            }
            AppMethodBeat.m2505o(99734);
        }
        return this;
    }

    /* renamed from: a */
    public final <K, V> C16278i mo29481a(Map<K, V> map, String str) {
        AppMethodBeat.m2504i(99735);
        m24992a(str);
        if (map == null) {
            this.f3414a.append("null\n");
            AppMethodBeat.m2505o(99735);
        } else if (map.isEmpty()) {
            this.f3414a.append(map.size()).append(", {}\n");
            AppMethodBeat.m2505o(99735);
        } else {
            this.f3414a.append(map.size()).append(", {\n");
            C16278i c16278i = new C16278i(this.f3414a, this.f3415b + 1);
            C16278i c16278i2 = new C16278i(this.f3414a, this.f3415b + 2);
            for (Entry entry : map.entrySet()) {
                c16278i.mo29464a('(', null);
                c16278i2.mo29475a(entry.getKey(), null);
                c16278i2.mo29475a(entry.getValue(), null);
                c16278i.mo29464a(')', null);
            }
            mo29464a('}', null);
            AppMethodBeat.m2505o(99735);
        }
        return this;
    }

    /* renamed from: a */
    public final <K, V> C16278i mo29482a(Map<K, V> map, boolean z) {
        AppMethodBeat.m2504i(99736);
        if (map == null || map.isEmpty()) {
            this.f3414a.append("{}");
            if (z) {
                this.f3414a.append("|");
            }
            AppMethodBeat.m2505o(99736);
        } else {
            this.f3414a.append("{");
            C16278i c16278i = new C16278i(this.f3414a, this.f3415b + 2);
            boolean z2 = true;
            for (Entry entry : map.entrySet()) {
                if (!z2) {
                    this.f3414a.append(",");
                }
                c16278i.mo29476a(entry.getKey(), true);
                c16278i.mo29476a(entry.getValue(), false);
                z2 = false;
            }
            this.f3414a.append("}");
            if (z) {
                this.f3414a.append("|");
            }
            AppMethodBeat.m2505o(99736);
        }
        return this;
    }

    /* renamed from: a */
    public final <T> C16278i mo29497a(T[] tArr, String str) {
        AppMethodBeat.m2504i(99737);
        m24992a(str);
        if (tArr == null) {
            this.f3414a.append("null\n");
            AppMethodBeat.m2505o(99737);
        } else if (tArr.length == 0) {
            this.f3414a.append(tArr.length).append(", []\n");
            AppMethodBeat.m2505o(99737);
        } else {
            this.f3414a.append(tArr.length).append(", [\n");
            C16278i c16278i = new C16278i(this.f3414a, this.f3415b + 1);
            for (Object a : tArr) {
                c16278i.mo29475a(a, null);
            }
            mo29464a(']', null);
            AppMethodBeat.m2505o(99737);
        }
        return this;
    }

    /* renamed from: a */
    public final <T> C16278i mo29498a(T[] tArr, boolean z) {
        AppMethodBeat.m2504i(99738);
        if (tArr == null || tArr.length == 0) {
            this.f3414a.append("[]");
            if (z) {
                this.f3414a.append("|");
            }
            AppMethodBeat.m2505o(99738);
        } else {
            this.f3414a.append("[");
            C16278i c16278i = new C16278i(this.f3414a, this.f3415b + 1);
            for (int i = 0; i < tArr.length; i++) {
                Object obj = tArr[i];
                if (i != 0) {
                    this.f3414a.append("|");
                }
                c16278i.mo29476a(obj, false);
            }
            this.f3414a.append("]");
            if (z) {
                this.f3414a.append("|");
            }
            AppMethodBeat.m2505o(99738);
        }
        return this;
    }

    /* renamed from: a */
    public final <T> C16278i mo29479a(Collection<T> collection, String str) {
        AppMethodBeat.m2504i(99739);
        if (collection == null) {
            m24992a(str);
            this.f3414a.append("null\t");
            AppMethodBeat.m2505o(99739);
            return this;
        }
        this = mo29497a(collection.toArray(), str);
        AppMethodBeat.m2505o(99739);
        return this;
    }

    /* renamed from: a */
    public final <T> C16278i mo29480a(Collection<T> collection, boolean z) {
        AppMethodBeat.m2504i(99740);
        if (collection == null) {
            this.f3414a.append("[]");
            if (z) {
                this.f3414a.append("|");
            }
            AppMethodBeat.m2505o(99740);
            return this;
        }
        this = mo29498a(collection.toArray(), z);
        AppMethodBeat.m2505o(99740);
        return this;
    }

    /* renamed from: a */
    public final <T> C16278i mo29475a(T t, String str) {
        AppMethodBeat.m2504i(99741);
        if (t == null) {
            this.f3414a.append("null\n");
        } else if (t instanceof Byte) {
            mo29462a(((Byte) t).byteValue(), str);
        } else if (t instanceof Boolean) {
            mo29485a(((Boolean) t).booleanValue(), str);
        } else if (t instanceof Short) {
            mo29483a(((Short) t).shortValue(), str);
        } else if (t instanceof Integer) {
            mo29469a(((Integer) t).intValue(), str);
        } else if (t instanceof Long) {
            mo29471a(((Long) t).longValue(), str);
        } else if (t instanceof Float) {
            mo29467a(((Float) t).floatValue(), str);
        } else if (t instanceof Double) {
            mo29465a(((Double) t).doubleValue(), str);
        } else if (t instanceof String) {
            mo29477a((String) t, str);
        } else if (t instanceof Map) {
            mo29481a((Map) t, str);
        } else if (t instanceof List) {
            mo29479a((List) t, str);
        } else if (t instanceof C46803m) {
            mo29473a((C46803m) t, str);
        } else if (t instanceof byte[]) {
            mo29487a((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            mo29475a((Object) (boolean[]) t, str);
        } else if (t instanceof short[]) {
            mo29499a((short[]) t, str);
        } else if (t instanceof int[]) {
            mo29493a((int[]) t, str);
        } else if (t instanceof long[]) {
            mo29495a((long[]) t, str);
        } else if (t instanceof float[]) {
            mo29491a((float[]) t, str);
        } else if (t instanceof double[]) {
            mo29489a((double[]) t, str);
        } else if (t.getClass().isArray()) {
            mo29497a((Object[]) t, str);
        } else {
            C5891j c5891j = new C5891j("write object error: unsupport type.");
            AppMethodBeat.m2505o(99741);
            throw c5891j;
        }
        AppMethodBeat.m2505o(99741);
        return this;
    }

    /* renamed from: a */
    public final <T> C16278i mo29476a(T t, boolean z) {
        AppMethodBeat.m2504i(99742);
        if (t == null) {
            this.f3414a.append("null\n");
        } else if (t instanceof Byte) {
            mo29463a(((Byte) t).byteValue(), z);
        } else if (t instanceof Boolean) {
            mo29486a(((Boolean) t).booleanValue(), z);
        } else if (t instanceof Short) {
            mo29484a(((Short) t).shortValue(), z);
        } else if (t instanceof Integer) {
            mo29470a(((Integer) t).intValue(), z);
        } else if (t instanceof Long) {
            mo29472a(((Long) t).longValue(), z);
        } else if (t instanceof Float) {
            mo29468a(((Float) t).floatValue(), z);
        } else if (t instanceof Double) {
            mo29466a(((Double) t).doubleValue(), z);
        } else if (t instanceof String) {
            mo29478a((String) t, z);
        } else if (t instanceof Map) {
            mo29482a((Map) t, z);
        } else if (t instanceof List) {
            mo29480a((List) t, z);
        } else if (t instanceof C46803m) {
            mo29474a((C46803m) t, z);
        } else if (t instanceof byte[]) {
            mo29488a((byte[]) t, z);
        } else if (t instanceof boolean[]) {
            mo29476a((Object) (boolean[]) t, z);
        } else if (t instanceof short[]) {
            mo29500a((short[]) t, z);
        } else if (t instanceof int[]) {
            mo29494a((int[]) t, z);
        } else if (t instanceof long[]) {
            mo29496a((long[]) t, z);
        } else if (t instanceof float[]) {
            mo29492a((float[]) t, z);
        } else if (t instanceof double[]) {
            mo29490a((double[]) t, z);
        } else if (t.getClass().isArray()) {
            mo29498a((Object[]) t, z);
        } else {
            C5891j c5891j = new C5891j("write object error: unsupport type.");
            AppMethodBeat.m2505o(99742);
            throw c5891j;
        }
        AppMethodBeat.m2505o(99742);
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29473a(C46803m c46803m, String str) {
        AppMethodBeat.m2504i(99743);
        mo29464a('{', str);
        if (c46803m == null) {
            this.f3414a.append(9).append(BuildConfig.COMMAND);
        } else {
            c46803m.display(this.f3414a, this.f3415b + 1);
        }
        mo29464a('}', null);
        AppMethodBeat.m2505o(99743);
        return this;
    }

    /* renamed from: a */
    public final C16278i mo29474a(C46803m c46803m, boolean z) {
        AppMethodBeat.m2504i(99744);
        this.f3414a.append("{");
        if (c46803m == null) {
            this.f3414a.append(9).append(BuildConfig.COMMAND);
        } else {
            c46803m.displaySimple(this.f3414a, this.f3415b + 1);
        }
        this.f3414a.append("}");
        if (z) {
            this.f3414a.append("|");
        }
        AppMethodBeat.m2505o(99744);
        return this;
    }
}
