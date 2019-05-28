package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class i {
    private StringBuilder a;
    private int b = 0;

    private void a(String str) {
        AppMethodBeat.i(99705);
        for (int i = 0; i < this.b; i++) {
            this.a.append(9);
        }
        if (str != null) {
            this.a.append(str).append(": ");
        }
        AppMethodBeat.o(99705);
    }

    public i(StringBuilder stringBuilder, int i) {
        this.a = stringBuilder;
        this.b = i;
    }

    public final i a(boolean z, String str) {
        AppMethodBeat.i(99706);
        a(str);
        this.a.append(z ? 'T' : 'F').append(10);
        AppMethodBeat.o(99706);
        return this;
    }

    public final i a(boolean z, boolean z2) {
        AppMethodBeat.i(99707);
        this.a.append(z ? 'T' : 'F');
        if (z2) {
            this.a.append("|");
        }
        AppMethodBeat.o(99707);
        return this;
    }

    public final i a(byte b, String str) {
        AppMethodBeat.i(99708);
        a(str);
        this.a.append(b).append(10);
        AppMethodBeat.o(99708);
        return this;
    }

    public final i a(byte b, boolean z) {
        AppMethodBeat.i(99709);
        this.a.append(b);
        if (z) {
            this.a.append("|");
        }
        AppMethodBeat.o(99709);
        return this;
    }

    public final i a(char c, String str) {
        AppMethodBeat.i(99710);
        a(str);
        this.a.append(c).append(10);
        AppMethodBeat.o(99710);
        return this;
    }

    public final i a(short s, String str) {
        AppMethodBeat.i(99711);
        a(str);
        this.a.append(s).append(10);
        AppMethodBeat.o(99711);
        return this;
    }

    public final i a(short s, boolean z) {
        AppMethodBeat.i(99712);
        this.a.append(s);
        if (z) {
            this.a.append("|");
        }
        AppMethodBeat.o(99712);
        return this;
    }

    public final i a(int i, String str) {
        AppMethodBeat.i(99713);
        a(str);
        this.a.append(i).append(10);
        AppMethodBeat.o(99713);
        return this;
    }

    public final i a(int i, boolean z) {
        AppMethodBeat.i(99714);
        this.a.append(i);
        if (z) {
            this.a.append("|");
        }
        AppMethodBeat.o(99714);
        return this;
    }

    public final i a(long j, String str) {
        AppMethodBeat.i(99715);
        a(str);
        this.a.append(j).append(10);
        AppMethodBeat.o(99715);
        return this;
    }

    public final i a(long j, boolean z) {
        AppMethodBeat.i(99716);
        this.a.append(j);
        if (z) {
            this.a.append("|");
        }
        AppMethodBeat.o(99716);
        return this;
    }

    public final i a(float f, String str) {
        AppMethodBeat.i(99717);
        a(str);
        this.a.append(f).append(10);
        AppMethodBeat.o(99717);
        return this;
    }

    public final i a(float f, boolean z) {
        AppMethodBeat.i(99718);
        this.a.append(f);
        if (z) {
            this.a.append("|");
        }
        AppMethodBeat.o(99718);
        return this;
    }

    public final i a(double d, String str) {
        AppMethodBeat.i(99719);
        a(str);
        this.a.append(d).append(10);
        AppMethodBeat.o(99719);
        return this;
    }

    public final i a(double d, boolean z) {
        AppMethodBeat.i(99720);
        this.a.append(d);
        if (z) {
            this.a.append("|");
        }
        AppMethodBeat.o(99720);
        return this;
    }

    public final i a(String str, String str2) {
        AppMethodBeat.i(99721);
        a(str2);
        if (str == null) {
            this.a.append("null\n");
        } else {
            this.a.append(str).append(10);
        }
        AppMethodBeat.o(99721);
        return this;
    }

    public final i a(String str, boolean z) {
        AppMethodBeat.i(99722);
        if (str == null) {
            this.a.append(BuildConfig.COMMAND);
        } else {
            this.a.append(str);
        }
        if (z) {
            this.a.append("|");
        }
        AppMethodBeat.o(99722);
        return this;
    }

    public final i a(byte[] bArr, String str) {
        AppMethodBeat.i(99723);
        a(str);
        if (bArr == null) {
            this.a.append("null\n");
            AppMethodBeat.o(99723);
        } else if (bArr.length == 0) {
            this.a.append(bArr.length).append(", []\n");
            AppMethodBeat.o(99723);
        } else {
            this.a.append(bArr.length).append(", [\n");
            i iVar = new i(this.a, this.b + 1);
            for (byte a : bArr) {
                iVar.a(a, null);
            }
            a(']', null);
            AppMethodBeat.o(99723);
        }
        return this;
    }

    public final i a(byte[] bArr, boolean z) {
        AppMethodBeat.i(99724);
        if (bArr == null || bArr.length == 0) {
            if (z) {
                this.a.append("|");
            }
            AppMethodBeat.o(99724);
        } else {
            this.a.append(g.a(bArr));
            if (z) {
                this.a.append("|");
            }
            AppMethodBeat.o(99724);
        }
        return this;
    }

    public final i a(short[] sArr, String str) {
        AppMethodBeat.i(99725);
        a(str);
        if (sArr == null) {
            this.a.append("null\n");
            AppMethodBeat.o(99725);
        } else if (sArr.length == 0) {
            this.a.append(sArr.length).append(", []\n");
            AppMethodBeat.o(99725);
        } else {
            this.a.append(sArr.length).append(", [\n");
            i iVar = new i(this.a, this.b + 1);
            for (short a : sArr) {
                iVar.a(a, null);
            }
            a(']', null);
            AppMethodBeat.o(99725);
        }
        return this;
    }

    public final i a(short[] sArr, boolean z) {
        AppMethodBeat.i(99726);
        if (sArr == null || sArr.length == 0) {
            this.a.append("[]");
            if (z) {
                this.a.append("|");
            }
            AppMethodBeat.o(99726);
        } else {
            this.a.append("[");
            i iVar = new i(this.a, this.b + 1);
            for (int i = 0; i < sArr.length; i++) {
                short s = sArr[i];
                if (i != 0) {
                    this.a.append("|");
                }
                iVar.a(s, false);
            }
            this.a.append("]");
            if (z) {
                this.a.append("|");
            }
            AppMethodBeat.o(99726);
        }
        return this;
    }

    public final i a(int[] iArr, String str) {
        AppMethodBeat.i(99727);
        a(str);
        if (iArr == null) {
            this.a.append("null\n");
            AppMethodBeat.o(99727);
        } else if (iArr.length == 0) {
            this.a.append(iArr.length).append(", []\n");
            AppMethodBeat.o(99727);
        } else {
            this.a.append(iArr.length).append(", [\n");
            i iVar = new i(this.a, this.b + 1);
            for (int a : iArr) {
                iVar.a(a, null);
            }
            a(']', null);
            AppMethodBeat.o(99727);
        }
        return this;
    }

    public final i a(int[] iArr, boolean z) {
        AppMethodBeat.i(99728);
        if (iArr == null || iArr.length == 0) {
            this.a.append("[]");
            if (z) {
                this.a.append("|");
            }
            AppMethodBeat.o(99728);
        } else {
            this.a.append("[");
            i iVar = new i(this.a, this.b + 1);
            for (int i = 0; i < iArr.length; i++) {
                int i2 = iArr[i];
                if (i != 0) {
                    this.a.append("|");
                }
                iVar.a(i2, false);
            }
            this.a.append("]");
            if (z) {
                this.a.append("|");
            }
            AppMethodBeat.o(99728);
        }
        return this;
    }

    public final i a(long[] jArr, String str) {
        AppMethodBeat.i(99729);
        a(str);
        if (jArr == null) {
            this.a.append("null\n");
            AppMethodBeat.o(99729);
        } else if (jArr.length == 0) {
            this.a.append(jArr.length).append(", []\n");
            AppMethodBeat.o(99729);
        } else {
            this.a.append(jArr.length).append(", [\n");
            i iVar = new i(this.a, this.b + 1);
            for (long a : jArr) {
                iVar.a(a, null);
            }
            a(']', null);
            AppMethodBeat.o(99729);
        }
        return this;
    }

    public final i a(long[] jArr, boolean z) {
        AppMethodBeat.i(99730);
        if (jArr == null || jArr.length == 0) {
            this.a.append("[]");
            if (z) {
                this.a.append("|");
            }
            AppMethodBeat.o(99730);
        } else {
            this.a.append("[");
            i iVar = new i(this.a, this.b + 1);
            for (int i = 0; i < jArr.length; i++) {
                long j = jArr[i];
                if (i != 0) {
                    this.a.append("|");
                }
                iVar.a(j, false);
            }
            this.a.append("]");
            if (z) {
                this.a.append("|");
            }
            AppMethodBeat.o(99730);
        }
        return this;
    }

    public final i a(float[] fArr, String str) {
        AppMethodBeat.i(99731);
        a(str);
        if (fArr == null) {
            this.a.append("null\n");
            AppMethodBeat.o(99731);
        } else if (fArr.length == 0) {
            this.a.append(fArr.length).append(", []\n");
            AppMethodBeat.o(99731);
        } else {
            this.a.append(fArr.length).append(", [\n");
            i iVar = new i(this.a, this.b + 1);
            for (float a : fArr) {
                iVar.a(a, null);
            }
            a(']', null);
            AppMethodBeat.o(99731);
        }
        return this;
    }

    public final i a(float[] fArr, boolean z) {
        AppMethodBeat.i(99732);
        if (fArr == null || fArr.length == 0) {
            this.a.append("[]");
            if (z) {
                this.a.append("|");
            }
            AppMethodBeat.o(99732);
        } else {
            this.a.append("[");
            i iVar = new i(this.a, this.b + 1);
            for (int i = 0; i < fArr.length; i++) {
                float f = fArr[i];
                if (i != 0) {
                    this.a.append("|");
                }
                iVar.a(f, false);
            }
            this.a.append("]");
            if (z) {
                this.a.append("|");
            }
            AppMethodBeat.o(99732);
        }
        return this;
    }

    public final i a(double[] dArr, String str) {
        AppMethodBeat.i(99733);
        a(str);
        if (dArr == null) {
            this.a.append("null\n");
            AppMethodBeat.o(99733);
        } else if (dArr.length == 0) {
            this.a.append(dArr.length).append(", []\n");
            AppMethodBeat.o(99733);
        } else {
            this.a.append(dArr.length).append(", [\n");
            i iVar = new i(this.a, this.b + 1);
            for (double a : dArr) {
                iVar.a(a, null);
            }
            a(']', null);
            AppMethodBeat.o(99733);
        }
        return this;
    }

    public final i a(double[] dArr, boolean z) {
        AppMethodBeat.i(99734);
        if (dArr == null || dArr.length == 0) {
            this.a.append("[]");
            if (z) {
                this.a.append("|");
            }
            AppMethodBeat.o(99734);
        } else {
            this.a.append("[");
            i iVar = new i(this.a, this.b + 1);
            for (int i = 0; i < dArr.length; i++) {
                double d = dArr[i];
                if (i != 0) {
                    this.a.append("|");
                }
                iVar.a(d, false);
            }
            this.a.append("[");
            if (z) {
                this.a.append("|");
            }
            AppMethodBeat.o(99734);
        }
        return this;
    }

    public final <K, V> i a(Map<K, V> map, String str) {
        AppMethodBeat.i(99735);
        a(str);
        if (map == null) {
            this.a.append("null\n");
            AppMethodBeat.o(99735);
        } else if (map.isEmpty()) {
            this.a.append(map.size()).append(", {}\n");
            AppMethodBeat.o(99735);
        } else {
            this.a.append(map.size()).append(", {\n");
            i iVar = new i(this.a, this.b + 1);
            i iVar2 = new i(this.a, this.b + 2);
            for (Entry entry : map.entrySet()) {
                iVar.a('(', null);
                iVar2.a(entry.getKey(), null);
                iVar2.a(entry.getValue(), null);
                iVar.a(')', null);
            }
            a('}', null);
            AppMethodBeat.o(99735);
        }
        return this;
    }

    public final <K, V> i a(Map<K, V> map, boolean z) {
        AppMethodBeat.i(99736);
        if (map == null || map.isEmpty()) {
            this.a.append("{}");
            if (z) {
                this.a.append("|");
            }
            AppMethodBeat.o(99736);
        } else {
            this.a.append("{");
            i iVar = new i(this.a, this.b + 2);
            boolean z2 = true;
            for (Entry entry : map.entrySet()) {
                if (!z2) {
                    this.a.append(",");
                }
                iVar.a(entry.getKey(), true);
                iVar.a(entry.getValue(), false);
                z2 = false;
            }
            this.a.append("}");
            if (z) {
                this.a.append("|");
            }
            AppMethodBeat.o(99736);
        }
        return this;
    }

    public final <T> i a(T[] tArr, String str) {
        AppMethodBeat.i(99737);
        a(str);
        if (tArr == null) {
            this.a.append("null\n");
            AppMethodBeat.o(99737);
        } else if (tArr.length == 0) {
            this.a.append(tArr.length).append(", []\n");
            AppMethodBeat.o(99737);
        } else {
            this.a.append(tArr.length).append(", [\n");
            i iVar = new i(this.a, this.b + 1);
            for (Object a : tArr) {
                iVar.a(a, null);
            }
            a(']', null);
            AppMethodBeat.o(99737);
        }
        return this;
    }

    public final <T> i a(T[] tArr, boolean z) {
        AppMethodBeat.i(99738);
        if (tArr == null || tArr.length == 0) {
            this.a.append("[]");
            if (z) {
                this.a.append("|");
            }
            AppMethodBeat.o(99738);
        } else {
            this.a.append("[");
            i iVar = new i(this.a, this.b + 1);
            for (int i = 0; i < tArr.length; i++) {
                Object obj = tArr[i];
                if (i != 0) {
                    this.a.append("|");
                }
                iVar.a(obj, false);
            }
            this.a.append("]");
            if (z) {
                this.a.append("|");
            }
            AppMethodBeat.o(99738);
        }
        return this;
    }

    public final <T> i a(Collection<T> collection, String str) {
        AppMethodBeat.i(99739);
        if (collection == null) {
            a(str);
            this.a.append("null\t");
            AppMethodBeat.o(99739);
            return this;
        }
        this = a(collection.toArray(), str);
        AppMethodBeat.o(99739);
        return this;
    }

    public final <T> i a(Collection<T> collection, boolean z) {
        AppMethodBeat.i(99740);
        if (collection == null) {
            this.a.append("[]");
            if (z) {
                this.a.append("|");
            }
            AppMethodBeat.o(99740);
            return this;
        }
        this = a(collection.toArray(), z);
        AppMethodBeat.o(99740);
        return this;
    }

    public final <T> i a(T t, String str) {
        AppMethodBeat.i(99741);
        if (t == null) {
            this.a.append("null\n");
        } else if (t instanceof Byte) {
            a(((Byte) t).byteValue(), str);
        } else if (t instanceof Boolean) {
            a(((Boolean) t).booleanValue(), str);
        } else if (t instanceof Short) {
            a(((Short) t).shortValue(), str);
        } else if (t instanceof Integer) {
            a(((Integer) t).intValue(), str);
        } else if (t instanceof Long) {
            a(((Long) t).longValue(), str);
        } else if (t instanceof Float) {
            a(((Float) t).floatValue(), str);
        } else if (t instanceof Double) {
            a(((Double) t).doubleValue(), str);
        } else if (t instanceof String) {
            a((String) t, str);
        } else if (t instanceof Map) {
            a((Map) t, str);
        } else if (t instanceof List) {
            a((List) t, str);
        } else if (t instanceof m) {
            a((m) t, str);
        } else if (t instanceof byte[]) {
            a((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            a((Object) (boolean[]) t, str);
        } else if (t instanceof short[]) {
            a((short[]) t, str);
        } else if (t instanceof int[]) {
            a((int[]) t, str);
        } else if (t instanceof long[]) {
            a((long[]) t, str);
        } else if (t instanceof float[]) {
            a((float[]) t, str);
        } else if (t instanceof double[]) {
            a((double[]) t, str);
        } else if (t.getClass().isArray()) {
            a((Object[]) t, str);
        } else {
            j jVar = new j("write object error: unsupport type.");
            AppMethodBeat.o(99741);
            throw jVar;
        }
        AppMethodBeat.o(99741);
        return this;
    }

    public final <T> i a(T t, boolean z) {
        AppMethodBeat.i(99742);
        if (t == null) {
            this.a.append("null\n");
        } else if (t instanceof Byte) {
            a(((Byte) t).byteValue(), z);
        } else if (t instanceof Boolean) {
            a(((Boolean) t).booleanValue(), z);
        } else if (t instanceof Short) {
            a(((Short) t).shortValue(), z);
        } else if (t instanceof Integer) {
            a(((Integer) t).intValue(), z);
        } else if (t instanceof Long) {
            a(((Long) t).longValue(), z);
        } else if (t instanceof Float) {
            a(((Float) t).floatValue(), z);
        } else if (t instanceof Double) {
            a(((Double) t).doubleValue(), z);
        } else if (t instanceof String) {
            a((String) t, z);
        } else if (t instanceof Map) {
            a((Map) t, z);
        } else if (t instanceof List) {
            a((List) t, z);
        } else if (t instanceof m) {
            a((m) t, z);
        } else if (t instanceof byte[]) {
            a((byte[]) t, z);
        } else if (t instanceof boolean[]) {
            a((Object) (boolean[]) t, z);
        } else if (t instanceof short[]) {
            a((short[]) t, z);
        } else if (t instanceof int[]) {
            a((int[]) t, z);
        } else if (t instanceof long[]) {
            a((long[]) t, z);
        } else if (t instanceof float[]) {
            a((float[]) t, z);
        } else if (t instanceof double[]) {
            a((double[]) t, z);
        } else if (t.getClass().isArray()) {
            a((Object[]) t, z);
        } else {
            j jVar = new j("write object error: unsupport type.");
            AppMethodBeat.o(99742);
            throw jVar;
        }
        AppMethodBeat.o(99742);
        return this;
    }

    public final i a(m mVar, String str) {
        AppMethodBeat.i(99743);
        a('{', str);
        if (mVar == null) {
            this.a.append(9).append(BuildConfig.COMMAND);
        } else {
            mVar.display(this.a, this.b + 1);
        }
        a('}', null);
        AppMethodBeat.o(99743);
        return this;
    }

    public final i a(m mVar, boolean z) {
        AppMethodBeat.i(99744);
        this.a.append("{");
        if (mVar == null) {
            this.a.append(9).append(BuildConfig.COMMAND);
        } else {
            mVar.displaySimple(this.a, this.b + 1);
        }
        this.a.append("}");
        if (z) {
            this.a.append("|");
        }
        AppMethodBeat.o(99744);
        return this;
    }
}
