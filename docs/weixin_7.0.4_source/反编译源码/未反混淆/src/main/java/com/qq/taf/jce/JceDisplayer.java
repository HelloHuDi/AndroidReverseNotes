package com.qq.taf.jce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class JceDisplayer {
    private int _level = 0;
    private StringBuilder sb;

    private void ps(String str) {
        AppMethodBeat.i(117042);
        for (int i = 0; i < this._level; i++) {
            this.sb.append(9);
        }
        if (str != null) {
            this.sb.append(str).append(": ");
        }
        AppMethodBeat.o(117042);
    }

    public JceDisplayer(StringBuilder stringBuilder, int i) {
        this.sb = stringBuilder;
        this._level = i;
    }

    public JceDisplayer(StringBuilder stringBuilder) {
        this.sb = stringBuilder;
    }

    public final JceDisplayer display(boolean z, String str) {
        AppMethodBeat.i(117043);
        ps(str);
        this.sb.append(z ? 'T' : 'F').append(10);
        AppMethodBeat.o(117043);
        return this;
    }

    public final JceDisplayer displaySimple(boolean z, boolean z2) {
        AppMethodBeat.i(117044);
        this.sb.append(z ? 'T' : 'F');
        if (z2) {
            this.sb.append("|");
        }
        AppMethodBeat.o(117044);
        return this;
    }

    public final JceDisplayer display(byte b, String str) {
        AppMethodBeat.i(117045);
        ps(str);
        this.sb.append(b).append(10);
        AppMethodBeat.o(117045);
        return this;
    }

    public final JceDisplayer displaySimple(byte b, boolean z) {
        AppMethodBeat.i(117046);
        this.sb.append(b);
        if (z) {
            this.sb.append("|");
        }
        AppMethodBeat.o(117046);
        return this;
    }

    public final JceDisplayer display(char c, String str) {
        AppMethodBeat.i(117047);
        ps(str);
        this.sb.append(c).append(10);
        AppMethodBeat.o(117047);
        return this;
    }

    public final JceDisplayer displaySimple(char c, boolean z) {
        AppMethodBeat.i(117048);
        this.sb.append(c);
        if (z) {
            this.sb.append("|");
        }
        AppMethodBeat.o(117048);
        return this;
    }

    public final JceDisplayer display(short s, String str) {
        AppMethodBeat.i(117049);
        ps(str);
        this.sb.append(s).append(10);
        AppMethodBeat.o(117049);
        return this;
    }

    public final JceDisplayer displaySimple(short s, boolean z) {
        AppMethodBeat.i(117050);
        this.sb.append(s);
        if (z) {
            this.sb.append("|");
        }
        AppMethodBeat.o(117050);
        return this;
    }

    public final JceDisplayer display(int i, String str) {
        AppMethodBeat.i(117051);
        ps(str);
        this.sb.append(i).append(10);
        AppMethodBeat.o(117051);
        return this;
    }

    public final JceDisplayer displaySimple(int i, boolean z) {
        AppMethodBeat.i(117052);
        this.sb.append(i);
        if (z) {
            this.sb.append("|");
        }
        AppMethodBeat.o(117052);
        return this;
    }

    public final JceDisplayer display(long j, String str) {
        AppMethodBeat.i(117053);
        ps(str);
        this.sb.append(j).append(10);
        AppMethodBeat.o(117053);
        return this;
    }

    public final JceDisplayer displaySimple(long j, boolean z) {
        AppMethodBeat.i(117054);
        this.sb.append(j);
        if (z) {
            this.sb.append("|");
        }
        AppMethodBeat.o(117054);
        return this;
    }

    public final JceDisplayer display(float f, String str) {
        AppMethodBeat.i(117055);
        ps(str);
        this.sb.append(f).append(10);
        AppMethodBeat.o(117055);
        return this;
    }

    public final JceDisplayer displaySimple(float f, boolean z) {
        AppMethodBeat.i(117056);
        this.sb.append(f);
        if (z) {
            this.sb.append("|");
        }
        AppMethodBeat.o(117056);
        return this;
    }

    public final JceDisplayer display(double d, String str) {
        AppMethodBeat.i(117057);
        ps(str);
        this.sb.append(d).append(10);
        AppMethodBeat.o(117057);
        return this;
    }

    public final JceDisplayer displaySimple(double d, boolean z) {
        AppMethodBeat.i(117058);
        this.sb.append(d);
        if (z) {
            this.sb.append("|");
        }
        AppMethodBeat.o(117058);
        return this;
    }

    public final JceDisplayer display(String str, String str2) {
        AppMethodBeat.i(117059);
        ps(str2);
        if (str == null) {
            this.sb.append("null\n");
        } else {
            this.sb.append(str).append(10);
        }
        AppMethodBeat.o(117059);
        return this;
    }

    public final JceDisplayer displaySimple(String str, boolean z) {
        AppMethodBeat.i(117060);
        if (str == null) {
            this.sb.append(BuildConfig.COMMAND);
        } else {
            this.sb.append(str);
        }
        if (z) {
            this.sb.append("|");
        }
        AppMethodBeat.o(117060);
        return this;
    }

    public final JceDisplayer display(byte[] bArr, String str) {
        AppMethodBeat.i(117061);
        ps(str);
        if (bArr == null) {
            this.sb.append("null\n");
            AppMethodBeat.o(117061);
        } else if (bArr.length == 0) {
            this.sb.append(bArr.length).append(", []\n");
            AppMethodBeat.o(117061);
        } else {
            this.sb.append(bArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (byte display : bArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
            AppMethodBeat.o(117061);
        }
        return this;
    }

    public final JceDisplayer displaySimple(byte[] bArr, boolean z) {
        AppMethodBeat.i(117062);
        if (bArr == null || bArr.length == 0) {
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(117062);
        } else {
            this.sb.append(HexUtil.bytes2HexStr(bArr));
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(117062);
        }
        return this;
    }

    public final JceDisplayer display(char[] cArr, String str) {
        AppMethodBeat.i(117063);
        ps(str);
        if (cArr == null) {
            this.sb.append("null\n");
            AppMethodBeat.o(117063);
        } else if (cArr.length == 0) {
            this.sb.append(cArr.length).append(", []\n");
            AppMethodBeat.o(117063);
        } else {
            this.sb.append(cArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (char display : cArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
            AppMethodBeat.o(117063);
        }
        return this;
    }

    public final JceDisplayer displaySimple(char[] cArr, boolean z) {
        AppMethodBeat.i(117064);
        if (cArr == null || cArr.length == 0) {
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(117064);
        } else {
            this.sb.append(new String(cArr));
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(117064);
        }
        return this;
    }

    public final JceDisplayer display(short[] sArr, String str) {
        AppMethodBeat.i(117065);
        ps(str);
        if (sArr == null) {
            this.sb.append("null\n");
            AppMethodBeat.o(117065);
        } else if (sArr.length == 0) {
            this.sb.append(sArr.length).append(", []\n");
            AppMethodBeat.o(117065);
        } else {
            this.sb.append(sArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (short display : sArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
            AppMethodBeat.o(117065);
        }
        return this;
    }

    public final JceDisplayer displaySimple(short[] sArr, boolean z) {
        AppMethodBeat.i(117066);
        if (sArr == null || sArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(117066);
        } else {
            this.sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (int i = 0; i < sArr.length; i++) {
                short s = sArr[i];
                if (i != 0) {
                    this.sb.append("|");
                }
                jceDisplayer.displaySimple(s, false);
            }
            this.sb.append("]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(117066);
        }
        return this;
    }

    public final JceDisplayer display(int[] iArr, String str) {
        AppMethodBeat.i(117067);
        ps(str);
        if (iArr == null) {
            this.sb.append("null\n");
            AppMethodBeat.o(117067);
        } else if (iArr.length == 0) {
            this.sb.append(iArr.length).append(", []\n");
            AppMethodBeat.o(117067);
        } else {
            this.sb.append(iArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (int display : iArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
            AppMethodBeat.o(117067);
        }
        return this;
    }

    public final JceDisplayer displaySimple(int[] iArr, boolean z) {
        AppMethodBeat.i(117068);
        if (iArr == null || iArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(117068);
        } else {
            this.sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (int i = 0; i < iArr.length; i++) {
                int i2 = iArr[i];
                if (i != 0) {
                    this.sb.append("|");
                }
                jceDisplayer.displaySimple(i2, false);
            }
            this.sb.append("]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(117068);
        }
        return this;
    }

    public final JceDisplayer display(long[] jArr, String str) {
        AppMethodBeat.i(117069);
        ps(str);
        if (jArr == null) {
            this.sb.append("null\n");
            AppMethodBeat.o(117069);
        } else if (jArr.length == 0) {
            this.sb.append(jArr.length).append(", []\n");
            AppMethodBeat.o(117069);
        } else {
            this.sb.append(jArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (long display : jArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
            AppMethodBeat.o(117069);
        }
        return this;
    }

    public final JceDisplayer displaySimple(long[] jArr, boolean z) {
        AppMethodBeat.i(117070);
        if (jArr == null || jArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(117070);
        } else {
            this.sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (int i = 0; i < jArr.length; i++) {
                long j = jArr[i];
                if (i != 0) {
                    this.sb.append("|");
                }
                jceDisplayer.displaySimple(j, false);
            }
            this.sb.append("]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(117070);
        }
        return this;
    }

    public final JceDisplayer display(float[] fArr, String str) {
        AppMethodBeat.i(117071);
        ps(str);
        if (fArr == null) {
            this.sb.append("null\n");
            AppMethodBeat.o(117071);
        } else if (fArr.length == 0) {
            this.sb.append(fArr.length).append(", []\n");
            AppMethodBeat.o(117071);
        } else {
            this.sb.append(fArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (float display : fArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
            AppMethodBeat.o(117071);
        }
        return this;
    }

    public final JceDisplayer displaySimple(float[] fArr, boolean z) {
        AppMethodBeat.i(117072);
        if (fArr == null || fArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(117072);
        } else {
            this.sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (int i = 0; i < fArr.length; i++) {
                float f = fArr[i];
                if (i != 0) {
                    this.sb.append("|");
                }
                jceDisplayer.displaySimple(f, false);
            }
            this.sb.append("]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(117072);
        }
        return this;
    }

    public final JceDisplayer display(double[] dArr, String str) {
        AppMethodBeat.i(117073);
        ps(str);
        if (dArr == null) {
            this.sb.append("null\n");
            AppMethodBeat.o(117073);
        } else if (dArr.length == 0) {
            this.sb.append(dArr.length).append(", []\n");
            AppMethodBeat.o(117073);
        } else {
            this.sb.append(dArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (double display : dArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
            AppMethodBeat.o(117073);
        }
        return this;
    }

    public final JceDisplayer displaySimple(double[] dArr, boolean z) {
        AppMethodBeat.i(117074);
        if (dArr == null || dArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(117074);
        } else {
            this.sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (int i = 0; i < dArr.length; i++) {
                double d = dArr[i];
                if (i != 0) {
                    this.sb.append("|");
                }
                jceDisplayer.displaySimple(d, false);
            }
            this.sb.append("[");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(117074);
        }
        return this;
    }

    public final <K, V> JceDisplayer display(Map<K, V> map, String str) {
        AppMethodBeat.i(117075);
        ps(str);
        if (map == null) {
            this.sb.append("null\n");
            AppMethodBeat.o(117075);
        } else if (map.isEmpty()) {
            this.sb.append(map.size()).append(", {}\n");
            AppMethodBeat.o(117075);
        } else {
            this.sb.append(map.size()).append(", {\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            JceDisplayer jceDisplayer2 = new JceDisplayer(this.sb, this._level + 2);
            for (Entry entry : map.entrySet()) {
                jceDisplayer.display('(', null);
                jceDisplayer2.display(entry.getKey(), null);
                jceDisplayer2.display(entry.getValue(), null);
                jceDisplayer.display(')', null);
            }
            display('}', null);
            AppMethodBeat.o(117075);
        }
        return this;
    }

    public final <K, V> JceDisplayer displaySimple(Map<K, V> map, boolean z) {
        AppMethodBeat.i(117076);
        if (map == null || map.isEmpty()) {
            this.sb.append("{}");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(117076);
        } else {
            this.sb.append("{");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 2);
            boolean z2 = true;
            for (Entry entry : map.entrySet()) {
                if (!z2) {
                    this.sb.append(",");
                }
                jceDisplayer.displaySimple(entry.getKey(), true);
                jceDisplayer.displaySimple(entry.getValue(), false);
                z2 = false;
            }
            this.sb.append("}");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(117076);
        }
        return this;
    }

    public final <T> JceDisplayer display(T[] tArr, String str) {
        AppMethodBeat.i(117077);
        ps(str);
        if (tArr == null) {
            this.sb.append("null\n");
            AppMethodBeat.o(117077);
        } else if (tArr.length == 0) {
            this.sb.append(tArr.length).append(", []\n");
            AppMethodBeat.o(117077);
        } else {
            this.sb.append(tArr.length).append(", [\n");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (Object display : tArr) {
                jceDisplayer.display(display, null);
            }
            display(']', null);
            AppMethodBeat.o(117077);
        }
        return this;
    }

    public final <T> JceDisplayer displaySimple(T[] tArr, boolean z) {
        AppMethodBeat.i(117078);
        if (tArr == null || tArr.length == 0) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(117078);
        } else {
            this.sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.sb, this._level + 1);
            for (int i = 0; i < tArr.length; i++) {
                Object obj = tArr[i];
                if (i != 0) {
                    this.sb.append("|");
                }
                jceDisplayer.displaySimple(obj, false);
            }
            this.sb.append("]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(117078);
        }
        return this;
    }

    public final <T> JceDisplayer display(Collection<T> collection, String str) {
        AppMethodBeat.i(117079);
        if (collection == null) {
            ps(str);
            this.sb.append("null\t");
            AppMethodBeat.o(117079);
            return this;
        }
        this = display(collection.toArray(), str);
        AppMethodBeat.o(117079);
        return this;
    }

    public final <T> JceDisplayer displaySimple(Collection<T> collection, boolean z) {
        AppMethodBeat.i(117080);
        if (collection == null) {
            this.sb.append("[]");
            if (z) {
                this.sb.append("|");
            }
            AppMethodBeat.o(117080);
            return this;
        }
        this = displaySimple(collection.toArray(), z);
        AppMethodBeat.o(117080);
        return this;
    }

    public final <T> JceDisplayer display(T t, String str) {
        AppMethodBeat.i(117081);
        if (t == null) {
            this.sb.append("null\n");
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
            AppMethodBeat.o(117081);
            throw jceEncodeException;
        }
        AppMethodBeat.o(117081);
        return this;
    }

    public final <T> JceDisplayer displaySimple(T t, boolean z) {
        AppMethodBeat.i(117082);
        if (t == null) {
            this.sb.append("null\n");
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
            AppMethodBeat.o(117082);
            throw jceEncodeException;
        }
        AppMethodBeat.o(117082);
        return this;
    }

    public final JceDisplayer display(JceStruct jceStruct, String str) {
        AppMethodBeat.i(117083);
        display('{', str);
        if (jceStruct == null) {
            this.sb.append(9).append(BuildConfig.COMMAND);
        } else {
            jceStruct.display(this.sb, this._level + 1);
        }
        display('}', null);
        AppMethodBeat.o(117083);
        return this;
    }

    public final JceDisplayer displaySimple(JceStruct jceStruct, boolean z) {
        AppMethodBeat.i(117084);
        this.sb.append("{");
        if (jceStruct == null) {
            this.sb.append(9).append(BuildConfig.COMMAND);
        } else {
            jceStruct.displaySimple(this.sb, this._level + 1);
        }
        this.sb.append("}");
        if (z) {
            this.sb.append("|");
        }
        AppMethodBeat.o(117084);
        return this;
    }

    public static void main(String[] strArr) {
        AppMethodBeat.i(117085);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1.2d);
        System.out.println(stringBuilder.toString());
        AppMethodBeat.o(117085);
    }
}
