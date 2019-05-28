package com.p123qq.taf.jce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.qq.taf.jce.JceDisplayer */
public final class JceDisplayer {
    private int _level = 0;
    /* renamed from: sb */
    private StringBuilder f16877sb;

    /* renamed from: ps */
    private void m73044ps(String str) {
        AppMethodBeat.m2504i(117042);
        for (int i = 0; i < this._level; i++) {
            this.f16877sb.append(9);
        }
        if (str != null) {
            this.f16877sb.append(str).append(": ");
        }
        AppMethodBeat.m2505o(117042);
    }

    public JceDisplayer(StringBuilder stringBuilder, int i) {
        this.f16877sb = stringBuilder;
        this._level = i;
    }

    public JceDisplayer(StringBuilder stringBuilder) {
        this.f16877sb = stringBuilder;
    }

    public final JceDisplayer display(boolean z, String str) {
        AppMethodBeat.m2504i(117043);
        m73044ps(str);
        this.f16877sb.append(z ? 'T' : 'F').append(10);
        AppMethodBeat.m2505o(117043);
        return this;
    }

    public final JceDisplayer displaySimple(boolean z, boolean z2) {
        AppMethodBeat.m2504i(117044);
        this.f16877sb.append(z ? 'T' : 'F');
        if (z2) {
            this.f16877sb.append("|");
        }
        AppMethodBeat.m2505o(117044);
        return this;
    }

    public final JceDisplayer display(byte b, String str) {
        AppMethodBeat.m2504i(117045);
        m73044ps(str);
        this.f16877sb.append(b).append(10);
        AppMethodBeat.m2505o(117045);
        return this;
    }

    public final JceDisplayer displaySimple(byte b, boolean z) {
        AppMethodBeat.m2504i(117046);
        this.f16877sb.append(b);
        if (z) {
            this.f16877sb.append("|");
        }
        AppMethodBeat.m2505o(117046);
        return this;
    }

    public final JceDisplayer display(char c, String str) {
        AppMethodBeat.m2504i(117047);
        m73044ps(str);
        this.f16877sb.append(c).append(10);
        AppMethodBeat.m2505o(117047);
        return this;
    }

    public final JceDisplayer displaySimple(char c, boolean z) {
        AppMethodBeat.m2504i(117048);
        this.f16877sb.append(c);
        if (z) {
            this.f16877sb.append("|");
        }
        AppMethodBeat.m2505o(117048);
        return this;
    }

    public final JceDisplayer display(short s, String str) {
        AppMethodBeat.m2504i(117049);
        m73044ps(str);
        this.f16877sb.append(s).append(10);
        AppMethodBeat.m2505o(117049);
        return this;
    }

    public final JceDisplayer displaySimple(short s, boolean z) {
        AppMethodBeat.m2504i(117050);
        this.f16877sb.append(s);
        if (z) {
            this.f16877sb.append("|");
        }
        AppMethodBeat.m2505o(117050);
        return this;
    }

    public final JceDisplayer display(int i, String str) {
        AppMethodBeat.m2504i(117051);
        m73044ps(str);
        this.f16877sb.append(i).append(10);
        AppMethodBeat.m2505o(117051);
        return this;
    }

    public final JceDisplayer displaySimple(int i, boolean z) {
        AppMethodBeat.m2504i(117052);
        this.f16877sb.append(i);
        if (z) {
            this.f16877sb.append("|");
        }
        AppMethodBeat.m2505o(117052);
        return this;
    }

    public final JceDisplayer display(long j, String str) {
        AppMethodBeat.m2504i(117053);
        m73044ps(str);
        this.f16877sb.append(j).append(10);
        AppMethodBeat.m2505o(117053);
        return this;
    }

    public final JceDisplayer displaySimple(long j, boolean z) {
        AppMethodBeat.m2504i(117054);
        this.f16877sb.append(j);
        if (z) {
            this.f16877sb.append("|");
        }
        AppMethodBeat.m2505o(117054);
        return this;
    }

    public final JceDisplayer display(float f, String str) {
        AppMethodBeat.m2504i(117055);
        m73044ps(str);
        this.f16877sb.append(f).append(10);
        AppMethodBeat.m2505o(117055);
        return this;
    }

    public final JceDisplayer displaySimple(float f, boolean z) {
        AppMethodBeat.m2504i(117056);
        this.f16877sb.append(f);
        if (z) {
            this.f16877sb.append("|");
        }
        AppMethodBeat.m2505o(117056);
        return this;
    }

    public final JceDisplayer display(double d, String str) {
        AppMethodBeat.m2504i(117057);
        m73044ps(str);
        this.f16877sb.append(d).append(10);
        AppMethodBeat.m2505o(117057);
        return this;
    }

    public final JceDisplayer displaySimple(double d, boolean z) {
        AppMethodBeat.m2504i(117058);
        this.f16877sb.append(d);
        if (z) {
            this.f16877sb.append("|");
        }
        AppMethodBeat.m2505o(117058);
        return this;
    }

    public final JceDisplayer display(String str, String str2) {
        AppMethodBeat.m2504i(117059);
        m73044ps(str2);
        if (str == null) {
            this.f16877sb.append("null\n");
        } else {
            this.f16877sb.append(str).append(10);
        }
        AppMethodBeat.m2505o(117059);
        return this;
    }

    public final JceDisplayer displaySimple(String str, boolean z) {
        AppMethodBeat.m2504i(117060);
        if (str == null) {
            this.f16877sb.append(BuildConfig.COMMAND);
        } else {
            this.f16877sb.append(str);
        }
        if (z) {
            this.f16877sb.append("|");
        }
        AppMethodBeat.m2505o(117060);
        return this;
    }

    public final JceDisplayer display(byte[] bArr, String str) {
        AppMethodBeat.m2504i(117061);
        m73044ps(str);
        if (bArr == null) {
            this.f16877sb.append("null\n");
            AppMethodBeat.m2505o(117061);
        } else if (bArr.length == 0) {
            this.f16877sb.append(bArr.length).append(", []\n");
            AppMethodBeat.m2505o(117061);
        } else {
            this.f16877sb.append(bArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.f16877sb, this._level + 1);
            for (byte display : bArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
            AppMethodBeat.m2505o(117061);
        }
        return this;
    }

    public final JceDisplayer displaySimple(byte[] bArr, boolean z) {
        AppMethodBeat.m2504i(117062);
        if (bArr == null || bArr.length == 0) {
            if (z) {
                this.f16877sb.append("|");
            }
            AppMethodBeat.m2505o(117062);
        } else {
            this.f16877sb.append(HexUtil.bytes2HexStr(bArr));
            if (z) {
                this.f16877sb.append("|");
            }
            AppMethodBeat.m2505o(117062);
        }
        return this;
    }

    public final JceDisplayer display(char[] cArr, String str) {
        AppMethodBeat.m2504i(117063);
        m73044ps(str);
        if (cArr == null) {
            this.f16877sb.append("null\n");
            AppMethodBeat.m2505o(117063);
        } else if (cArr.length == 0) {
            this.f16877sb.append(cArr.length).append(", []\n");
            AppMethodBeat.m2505o(117063);
        } else {
            this.f16877sb.append(cArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.f16877sb, this._level + 1);
            for (char display : cArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
            AppMethodBeat.m2505o(117063);
        }
        return this;
    }

    public final JceDisplayer displaySimple(char[] cArr, boolean z) {
        AppMethodBeat.m2504i(117064);
        if (cArr == null || cArr.length == 0) {
            if (z) {
                this.f16877sb.append("|");
            }
            AppMethodBeat.m2505o(117064);
        } else {
            this.f16877sb.append(new String(cArr));
            if (z) {
                this.f16877sb.append("|");
            }
            AppMethodBeat.m2505o(117064);
        }
        return this;
    }

    public final JceDisplayer display(short[] sArr, String str) {
        AppMethodBeat.m2504i(117065);
        m73044ps(str);
        if (sArr == null) {
            this.f16877sb.append("null\n");
            AppMethodBeat.m2505o(117065);
        } else if (sArr.length == 0) {
            this.f16877sb.append(sArr.length).append(", []\n");
            AppMethodBeat.m2505o(117065);
        } else {
            this.f16877sb.append(sArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.f16877sb, this._level + 1);
            for (short display : sArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
            AppMethodBeat.m2505o(117065);
        }
        return this;
    }

    public final JceDisplayer displaySimple(short[] sArr, boolean z) {
        AppMethodBeat.m2504i(117066);
        if (sArr == null || sArr.length == 0) {
            this.f16877sb.append("[]");
            if (z) {
                this.f16877sb.append("|");
            }
            AppMethodBeat.m2505o(117066);
        } else {
            this.f16877sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.f16877sb, this._level + 1);
            for (int i = 0; i < sArr.length; i++) {
                short s = sArr[i];
                if (i != 0) {
                    this.f16877sb.append("|");
                }
                jceDisplayer.displaySimple(s, false);
            }
            this.f16877sb.append("]");
            if (z) {
                this.f16877sb.append("|");
            }
            AppMethodBeat.m2505o(117066);
        }
        return this;
    }

    public final JceDisplayer display(int[] iArr, String str) {
        AppMethodBeat.m2504i(117067);
        m73044ps(str);
        if (iArr == null) {
            this.f16877sb.append("null\n");
            AppMethodBeat.m2505o(117067);
        } else if (iArr.length == 0) {
            this.f16877sb.append(iArr.length).append(", []\n");
            AppMethodBeat.m2505o(117067);
        } else {
            this.f16877sb.append(iArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.f16877sb, this._level + 1);
            for (int display : iArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
            AppMethodBeat.m2505o(117067);
        }
        return this;
    }

    public final JceDisplayer displaySimple(int[] iArr, boolean z) {
        AppMethodBeat.m2504i(117068);
        if (iArr == null || iArr.length == 0) {
            this.f16877sb.append("[]");
            if (z) {
                this.f16877sb.append("|");
            }
            AppMethodBeat.m2505o(117068);
        } else {
            this.f16877sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.f16877sb, this._level + 1);
            for (int i = 0; i < iArr.length; i++) {
                int i2 = iArr[i];
                if (i != 0) {
                    this.f16877sb.append("|");
                }
                jceDisplayer.displaySimple(i2, false);
            }
            this.f16877sb.append("]");
            if (z) {
                this.f16877sb.append("|");
            }
            AppMethodBeat.m2505o(117068);
        }
        return this;
    }

    public final JceDisplayer display(long[] jArr, String str) {
        AppMethodBeat.m2504i(117069);
        m73044ps(str);
        if (jArr == null) {
            this.f16877sb.append("null\n");
            AppMethodBeat.m2505o(117069);
        } else if (jArr.length == 0) {
            this.f16877sb.append(jArr.length).append(", []\n");
            AppMethodBeat.m2505o(117069);
        } else {
            this.f16877sb.append(jArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.f16877sb, this._level + 1);
            for (long display : jArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
            AppMethodBeat.m2505o(117069);
        }
        return this;
    }

    public final JceDisplayer displaySimple(long[] jArr, boolean z) {
        AppMethodBeat.m2504i(117070);
        if (jArr == null || jArr.length == 0) {
            this.f16877sb.append("[]");
            if (z) {
                this.f16877sb.append("|");
            }
            AppMethodBeat.m2505o(117070);
        } else {
            this.f16877sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.f16877sb, this._level + 1);
            for (int i = 0; i < jArr.length; i++) {
                long j = jArr[i];
                if (i != 0) {
                    this.f16877sb.append("|");
                }
                jceDisplayer.displaySimple(j, false);
            }
            this.f16877sb.append("]");
            if (z) {
                this.f16877sb.append("|");
            }
            AppMethodBeat.m2505o(117070);
        }
        return this;
    }

    public final JceDisplayer display(float[] fArr, String str) {
        AppMethodBeat.m2504i(117071);
        m73044ps(str);
        if (fArr == null) {
            this.f16877sb.append("null\n");
            AppMethodBeat.m2505o(117071);
        } else if (fArr.length == 0) {
            this.f16877sb.append(fArr.length).append(", []\n");
            AppMethodBeat.m2505o(117071);
        } else {
            this.f16877sb.append(fArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.f16877sb, this._level + 1);
            for (float display : fArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
            AppMethodBeat.m2505o(117071);
        }
        return this;
    }

    public final JceDisplayer displaySimple(float[] fArr, boolean z) {
        AppMethodBeat.m2504i(117072);
        if (fArr == null || fArr.length == 0) {
            this.f16877sb.append("[]");
            if (z) {
                this.f16877sb.append("|");
            }
            AppMethodBeat.m2505o(117072);
        } else {
            this.f16877sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.f16877sb, this._level + 1);
            for (int i = 0; i < fArr.length; i++) {
                float f = fArr[i];
                if (i != 0) {
                    this.f16877sb.append("|");
                }
                jceDisplayer.displaySimple(f, false);
            }
            this.f16877sb.append("]");
            if (z) {
                this.f16877sb.append("|");
            }
            AppMethodBeat.m2505o(117072);
        }
        return this;
    }

    public final JceDisplayer display(double[] dArr, String str) {
        AppMethodBeat.m2504i(117073);
        m73044ps(str);
        if (dArr == null) {
            this.f16877sb.append("null\n");
            AppMethodBeat.m2505o(117073);
        } else if (dArr.length == 0) {
            this.f16877sb.append(dArr.length).append(", []\n");
            AppMethodBeat.m2505o(117073);
        } else {
            this.f16877sb.append(dArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.f16877sb, this._level + 1);
            for (double display : dArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
            AppMethodBeat.m2505o(117073);
        }
        return this;
    }

    public final JceDisplayer displaySimple(double[] dArr, boolean z) {
        AppMethodBeat.m2504i(117074);
        if (dArr == null || dArr.length == 0) {
            this.f16877sb.append("[]");
            if (z) {
                this.f16877sb.append("|");
            }
            AppMethodBeat.m2505o(117074);
        } else {
            this.f16877sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.f16877sb, this._level + 1);
            for (int i = 0; i < dArr.length; i++) {
                double d = dArr[i];
                if (i != 0) {
                    this.f16877sb.append("|");
                }
                jceDisplayer.displaySimple(d, false);
            }
            this.f16877sb.append("[");
            if (z) {
                this.f16877sb.append("|");
            }
            AppMethodBeat.m2505o(117074);
        }
        return this;
    }

    public final <K, V> JceDisplayer display(Map<K, V> map, String str) {
        AppMethodBeat.m2504i(117075);
        m73044ps(str);
        if (map == null) {
            this.f16877sb.append("null\n");
            AppMethodBeat.m2505o(117075);
        } else if (map.isEmpty()) {
            this.f16877sb.append(map.size()).append(", {}\n");
            AppMethodBeat.m2505o(117075);
        } else {
            this.f16877sb.append(map.size()).append(", {\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.f16877sb, this._level + 1);
            JceDisplayer jceDisplayer2 = new JceDisplayer(this.f16877sb, this._level + 2);
            for (Entry entry : map.entrySet()) {
                jceDisplayer.display('(', null);
                jceDisplayer2.display(entry.getKey(), null);
                jceDisplayer2.display(entry.getValue(), null);
                jceDisplayer.display(')', null);
            }
            display('}', null);
            AppMethodBeat.m2505o(117075);
        }
        return this;
    }

    public final <K, V> JceDisplayer displaySimple(Map<K, V> map, boolean z) {
        AppMethodBeat.m2504i(117076);
        if (map == null || map.isEmpty()) {
            this.f16877sb.append("{}");
            if (z) {
                this.f16877sb.append("|");
            }
            AppMethodBeat.m2505o(117076);
        } else {
            this.f16877sb.append("{");
            JceDisplayer jceDisplayer = new JceDisplayer(this.f16877sb, this._level + 2);
            boolean z2 = true;
            for (Entry entry : map.entrySet()) {
                if (!z2) {
                    this.f16877sb.append(",");
                }
                jceDisplayer.displaySimple(entry.getKey(), true);
                jceDisplayer.displaySimple(entry.getValue(), false);
                z2 = false;
            }
            this.f16877sb.append("}");
            if (z) {
                this.f16877sb.append("|");
            }
            AppMethodBeat.m2505o(117076);
        }
        return this;
    }

    public final <T> JceDisplayer display(T[] tArr, String str) {
        AppMethodBeat.m2504i(117077);
        m73044ps(str);
        if (tArr == null) {
            this.f16877sb.append("null\n");
            AppMethodBeat.m2505o(117077);
        } else if (tArr.length == 0) {
            this.f16877sb.append(tArr.length).append(", []\n");
            AppMethodBeat.m2505o(117077);
        } else {
            this.f16877sb.append(tArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.f16877sb, this._level + 1);
            for (Object display : tArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
            AppMethodBeat.m2505o(117077);
        }
        return this;
    }

    public final <T> JceDisplayer displaySimple(T[] tArr, boolean z) {
        AppMethodBeat.m2504i(117078);
        if (tArr == null || tArr.length == 0) {
            this.f16877sb.append("[]");
            if (z) {
                this.f16877sb.append("|");
            }
            AppMethodBeat.m2505o(117078);
        } else {
            this.f16877sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.f16877sb, this._level + 1);
            for (int i = 0; i < tArr.length; i++) {
                Object obj = tArr[i];
                if (i != 0) {
                    this.f16877sb.append("|");
                }
                jceDisplayer.displaySimple(obj, false);
            }
            this.f16877sb.append("]");
            if (z) {
                this.f16877sb.append("|");
            }
            AppMethodBeat.m2505o(117078);
        }
        return this;
    }

    public final <T> JceDisplayer display(Collection<T> collection, String str) {
        AppMethodBeat.m2504i(117079);
        if (collection == null) {
            m73044ps(str);
            this.f16877sb.append("null\t");
            AppMethodBeat.m2505o(117079);
            return this;
        }
        this = display(collection.toArray(), str);
        AppMethodBeat.m2505o(117079);
        return this;
    }

    public final <T> JceDisplayer displaySimple(Collection<T> collection, boolean z) {
        AppMethodBeat.m2504i(117080);
        if (collection == null) {
            this.f16877sb.append("[]");
            if (z) {
                this.f16877sb.append("|");
            }
            AppMethodBeat.m2505o(117080);
            return this;
        }
        this = displaySimple(collection.toArray(), z);
        AppMethodBeat.m2505o(117080);
        return this;
    }

    public final <T> JceDisplayer display(T t, String str) {
        AppMethodBeat.m2504i(117081);
        if (t == null) {
            this.f16877sb.append("null\n");
        } else if (t instanceof Byte) {
            display(((Byte) t).byteValue(), str);
        } else if (t instanceof Boolean) {
            display(((Boolean) t).booleanValue(), str);
        } else if (t instanceof Short) {
            display(((Short) t).shortValue(), str);
        } else if (t instanceof Integer) {
            display(((Integer) t).intValue(), str);
        } else if (t instanceof Long) {
            display(((Long) t).longValue(), str);
        } else if (t instanceof Float) {
            display(((Float) t).floatValue(), str);
        } else if (t instanceof Double) {
            display(((Double) t).doubleValue(), str);
        } else if (t instanceof String) {
            display((String) t, str);
        } else if (t instanceof Map) {
            display((Map) t, str);
        } else if (t instanceof List) {
            display((List) t, str);
        } else if (t instanceof JceStruct) {
            display((JceStruct) t, str);
        } else if (t instanceof byte[]) {
            display((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            display((boolean[]) t, str);
        } else if (t instanceof short[]) {
            display((short[]) t, str);
        } else if (t instanceof int[]) {
            display((int[]) t, str);
        } else if (t instanceof long[]) {
            display((long[]) t, str);
        } else if (t instanceof float[]) {
            display((float[]) t, str);
        } else if (t instanceof double[]) {
            display((double[]) t, str);
        } else if (t.getClass().isArray()) {
            display((Object[]) t, str);
        } else {
            JceEncodeException jceEncodeException = new JceEncodeException("write object error: unsupport type.");
            AppMethodBeat.m2505o(117081);
            throw jceEncodeException;
        }
        AppMethodBeat.m2505o(117081);
        return this;
    }

    public final <T> JceDisplayer displaySimple(T t, boolean z) {
        AppMethodBeat.m2504i(117082);
        if (t == null) {
            this.f16877sb.append("null\n");
        } else if (t instanceof Byte) {
            displaySimple(((Byte) t).byteValue(), z);
        } else if (t instanceof Boolean) {
            displaySimple(((Boolean) t).booleanValue(), z);
        } else if (t instanceof Short) {
            displaySimple(((Short) t).shortValue(), z);
        } else if (t instanceof Integer) {
            displaySimple(((Integer) t).intValue(), z);
        } else if (t instanceof Long) {
            displaySimple(((Long) t).longValue(), z);
        } else if (t instanceof Float) {
            displaySimple(((Float) t).floatValue(), z);
        } else if (t instanceof Double) {
            displaySimple(((Double) t).doubleValue(), z);
        } else if (t instanceof String) {
            displaySimple((String) t, z);
        } else if (t instanceof Map) {
            displaySimple((Map) t, z);
        } else if (t instanceof List) {
            displaySimple((List) t, z);
        } else if (t instanceof JceStruct) {
            displaySimple((JceStruct) t, z);
        } else if (t instanceof byte[]) {
            displaySimple((byte[]) t, z);
        } else if (t instanceof boolean[]) {
            displaySimple((boolean[]) t, z);
        } else if (t instanceof short[]) {
            displaySimple((short[]) t, z);
        } else if (t instanceof int[]) {
            displaySimple((int[]) t, z);
        } else if (t instanceof long[]) {
            displaySimple((long[]) t, z);
        } else if (t instanceof float[]) {
            displaySimple((float[]) t, z);
        } else if (t instanceof double[]) {
            displaySimple((double[]) t, z);
        } else if (t.getClass().isArray()) {
            displaySimple((Object[]) t, z);
        } else {
            JceEncodeException jceEncodeException = new JceEncodeException("write object error: unsupport type.");
            AppMethodBeat.m2505o(117082);
            throw jceEncodeException;
        }
        AppMethodBeat.m2505o(117082);
        return this;
    }

    public final JceDisplayer display(JceStruct jceStruct, String str) {
        AppMethodBeat.m2504i(117083);
        display('{', str);
        if (jceStruct == null) {
            this.f16877sb.append(9).append(BuildConfig.COMMAND);
        } else {
            jceStruct.display(this.f16877sb, this._level + 1);
        }
        display('}', null);
        AppMethodBeat.m2505o(117083);
        return this;
    }

    public final JceDisplayer displaySimple(JceStruct jceStruct, boolean z) {
        AppMethodBeat.m2504i(117084);
        this.f16877sb.append("{");
        if (jceStruct == null) {
            this.f16877sb.append(9).append(BuildConfig.COMMAND);
        } else {
            jceStruct.displaySimple(this.f16877sb, this._level + 1);
        }
        this.f16877sb.append("}");
        if (z) {
            this.f16877sb.append("|");
        }
        AppMethodBeat.m2505o(117084);
        return this;
    }

    public static void main(String[] strArr) {
        AppMethodBeat.m2504i(117085);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1.2d);
        System.out.println(stringBuilder.toString());
        AppMethodBeat.m2505o(117085);
    }
}
