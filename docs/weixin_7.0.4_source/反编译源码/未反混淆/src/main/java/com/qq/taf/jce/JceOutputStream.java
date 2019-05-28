package com.qq.taf.jce;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class JceOutputStream {
    private ByteBuffer bs;
    protected String sServerEncoding;

    public JceOutputStream(ByteBuffer byteBuffer) {
        this.sServerEncoding = "GBK";
        this.bs = byteBuffer;
    }

    public JceOutputStream(int i) {
        AppMethodBeat.i(117107);
        this.sServerEncoding = "GBK";
        this.bs = ByteBuffer.allocate(i);
        AppMethodBeat.o(117107);
    }

    public JceOutputStream() {
        this(128);
    }

    public ByteBuffer getByteBuffer() {
        return this.bs;
    }

    public byte[] toByteArray() {
        AppMethodBeat.i(117108);
        byte[] bArr = new byte[this.bs.position()];
        System.arraycopy(this.bs.array(), 0, bArr, 0, this.bs.position());
        AppMethodBeat.o(117108);
        return bArr;
    }

    public void reserve(int i) {
        AppMethodBeat.i(117109);
        if (this.bs.remaining() < i) {
            ByteBuffer allocate = ByteBuffer.allocate((this.bs.capacity() + i) * 2);
            allocate.put(this.bs.array(), 0, this.bs.position());
            this.bs = allocate;
        }
        AppMethodBeat.o(117109);
    }

    public void writeHead(byte b, int i) {
        AppMethodBeat.i(117110);
        if (i < 15) {
            this.bs.put((byte) ((i << 4) | b));
            AppMethodBeat.o(117110);
        } else if (i < 256) {
            this.bs.put((byte) (b | 240));
            this.bs.put((byte) i);
            AppMethodBeat.o(117110);
        } else {
            JceEncodeException jceEncodeException = new JceEncodeException("tag is too large: ".concat(String.valueOf(i)));
            AppMethodBeat.o(117110);
            throw jceEncodeException;
        }
    }

    public void write(boolean z, int i) {
        AppMethodBeat.i(117111);
        write((byte) (z ? 1 : 0), i);
        AppMethodBeat.o(117111);
    }

    public void write(byte b, int i) {
        AppMethodBeat.i(117112);
        reserve(3);
        if (b == (byte) 0) {
            writeHead((byte) 12, i);
            AppMethodBeat.o(117112);
            return;
        }
        writeHead((byte) 0, i);
        this.bs.put(b);
        AppMethodBeat.o(117112);
    }

    public void write(short s, int i) {
        AppMethodBeat.i(117113);
        reserve(4);
        if (s < (short) -128 || s > (short) 127) {
            writeHead((byte) 1, i);
            this.bs.putShort(s);
            AppMethodBeat.o(117113);
            return;
        }
        write((byte) s, i);
        AppMethodBeat.o(117113);
    }

    public void write(int i, int i2) {
        AppMethodBeat.i(117114);
        reserve(6);
        if (i < -32768 || i > 32767) {
            writeHead((byte) 2, i2);
            this.bs.putInt(i);
            AppMethodBeat.o(117114);
            return;
        }
        write((short) i, i2);
        AppMethodBeat.o(117114);
    }

    public void write(long j, int i) {
        AppMethodBeat.i(117115);
        reserve(10);
        if (j < -2147483648L || j > 2147483647L) {
            writeHead((byte) 3, i);
            this.bs.putLong(j);
            AppMethodBeat.o(117115);
            return;
        }
        write((int) j, i);
        AppMethodBeat.o(117115);
    }

    public void write(float f, int i) {
        AppMethodBeat.i(117116);
        reserve(6);
        writeHead((byte) 4, i);
        this.bs.putFloat(f);
        AppMethodBeat.o(117116);
    }

    public void write(double d, int i) {
        AppMethodBeat.i(117117);
        reserve(10);
        writeHead((byte) 5, i);
        this.bs.putDouble(d);
        AppMethodBeat.o(117117);
    }

    public void writeStringByte(String str, int i) {
        AppMethodBeat.i(117118);
        byte[] hexStr2Bytes = HexUtil.hexStr2Bytes(str);
        reserve(hexStr2Bytes.length + 10);
        if (hexStr2Bytes.length > 255) {
            writeHead((byte) 7, i);
            this.bs.putInt(hexStr2Bytes.length);
            this.bs.put(hexStr2Bytes);
            AppMethodBeat.o(117118);
            return;
        }
        writeHead((byte) 6, i);
        this.bs.put((byte) hexStr2Bytes.length);
        this.bs.put(hexStr2Bytes);
        AppMethodBeat.o(117118);
    }

    public void writeByteString(String str, int i) {
        AppMethodBeat.i(117119);
        reserve(str.length() + 10);
        byte[] hexStr2Bytes = HexUtil.hexStr2Bytes(str);
        if (hexStr2Bytes.length > 255) {
            writeHead((byte) 7, i);
            this.bs.putInt(hexStr2Bytes.length);
            this.bs.put(hexStr2Bytes);
            AppMethodBeat.o(117119);
            return;
        }
        writeHead((byte) 6, i);
        this.bs.put((byte) hexStr2Bytes.length);
        this.bs.put(hexStr2Bytes);
        AppMethodBeat.o(117119);
    }

    public void write(String str, int i) {
        byte[] bytes;
        AppMethodBeat.i(117120);
        try {
            bytes = str.getBytes(this.sServerEncoding);
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        reserve(bytes.length + 10);
        if (bytes.length > 255) {
            writeHead((byte) 7, i);
            this.bs.putInt(bytes.length);
            this.bs.put(bytes);
            AppMethodBeat.o(117120);
            return;
        }
        writeHead((byte) 6, i);
        this.bs.put((byte) bytes.length);
        this.bs.put(bytes);
        AppMethodBeat.o(117120);
    }

    public <K, V> void write(Map<K, V> map, int i) {
        AppMethodBeat.i(117121);
        reserve(8);
        writeHead((byte) 8, i);
        write(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                write(entry.getKey(), 0);
                write(entry.getValue(), 1);
            }
        }
        AppMethodBeat.o(117121);
    }

    public void write(boolean[] zArr, int i) {
        AppMethodBeat.i(117122);
        reserve(8);
        writeHead((byte) 9, i);
        write(zArr.length, 0);
        for (boolean write : zArr) {
            write(write, 0);
        }
        AppMethodBeat.o(117122);
    }

    public void write(byte[] bArr, int i) {
        AppMethodBeat.i(117123);
        reserve(bArr.length + 8);
        writeHead((byte) 13, i);
        writeHead((byte) 0, 0);
        write(bArr.length, 0);
        this.bs.put(bArr);
        AppMethodBeat.o(117123);
    }

    public void write(short[] sArr, int i) {
        AppMethodBeat.i(117124);
        reserve(8);
        writeHead((byte) 9, i);
        write(sArr.length, 0);
        for (short write : sArr) {
            write(write, 0);
        }
        AppMethodBeat.o(117124);
    }

    public void write(int[] iArr, int i) {
        AppMethodBeat.i(117125);
        reserve(8);
        writeHead((byte) 9, i);
        write(iArr.length, 0);
        for (int write : iArr) {
            write(write, 0);
        }
        AppMethodBeat.o(117125);
    }

    public void write(long[] jArr, int i) {
        AppMethodBeat.i(117126);
        reserve(8);
        writeHead((byte) 9, i);
        write(jArr.length, 0);
        for (long write : jArr) {
            write(write, 0);
        }
        AppMethodBeat.o(117126);
    }

    public void write(float[] fArr, int i) {
        AppMethodBeat.i(117127);
        reserve(8);
        writeHead((byte) 9, i);
        write(fArr.length, 0);
        for (float write : fArr) {
            write(write, 0);
        }
        AppMethodBeat.o(117127);
    }

    public void write(double[] dArr, int i) {
        AppMethodBeat.i(117128);
        reserve(8);
        writeHead((byte) 9, i);
        write(dArr.length, 0);
        for (double write : dArr) {
            write(write, 0);
        }
        AppMethodBeat.o(117128);
    }

    public <T> void write(T[] tArr, int i) {
        AppMethodBeat.i(117129);
        writeArray(tArr, i);
        AppMethodBeat.o(117129);
    }

    private void writeArray(Object[] objArr, int i) {
        AppMethodBeat.i(117130);
        reserve(8);
        writeHead((byte) 9, i);
        write(objArr.length, 0);
        for (Object write : objArr) {
            write(write, 0);
        }
        AppMethodBeat.o(117130);
    }

    public <T> void write(Collection<T> collection, int i) {
        AppMethodBeat.i(117131);
        reserve(8);
        writeHead((byte) 9, i);
        write(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            for (T write : collection) {
                write((Object) write, 0);
            }
        }
        AppMethodBeat.o(117131);
    }

    public void write(JceStruct jceStruct, int i) {
        AppMethodBeat.i(117132);
        reserve(2);
        writeHead((byte) 10, i);
        jceStruct.writeTo(this);
        reserve(2);
        writeHead((byte) 11, 0);
        AppMethodBeat.o(117132);
    }

    public void write(Byte b, int i) {
        AppMethodBeat.i(117133);
        write(b.byteValue(), i);
        AppMethodBeat.o(117133);
    }

    public void write(Boolean bool, int i) {
        AppMethodBeat.i(117134);
        write(bool.booleanValue(), i);
        AppMethodBeat.o(117134);
    }

    public void write(Short sh, int i) {
        AppMethodBeat.i(117135);
        write(sh.shortValue(), i);
        AppMethodBeat.o(117135);
    }

    public void write(Integer num, int i) {
        AppMethodBeat.i(117136);
        write(num.intValue(), i);
        AppMethodBeat.o(117136);
    }

    public void write(Long l, int i) {
        AppMethodBeat.i(117137);
        write(l.longValue(), i);
        AppMethodBeat.o(117137);
    }

    public void write(Float f, int i) {
        AppMethodBeat.i(117138);
        write(f.floatValue(), i);
        AppMethodBeat.o(117138);
    }

    public void write(Double d, int i) {
        AppMethodBeat.i(117139);
        write(d.doubleValue(), i);
        AppMethodBeat.o(117139);
    }

    public void write(Object obj, int i) {
        AppMethodBeat.i(117140);
        if (obj instanceof Byte) {
            write(((Byte) obj).byteValue(), i);
            AppMethodBeat.o(117140);
        } else if (obj instanceof Boolean) {
            write(((Boolean) obj).booleanValue(), i);
            AppMethodBeat.o(117140);
        } else if (obj instanceof Short) {
            write(((Short) obj).shortValue(), i);
            AppMethodBeat.o(117140);
        } else if (obj instanceof Integer) {
            write(((Integer) obj).intValue(), i);
            AppMethodBeat.o(117140);
        } else if (obj instanceof Long) {
            write(((Long) obj).longValue(), i);
            AppMethodBeat.o(117140);
        } else if (obj instanceof Float) {
            write(((Float) obj).floatValue(), i);
            AppMethodBeat.o(117140);
        } else if (obj instanceof Double) {
            write(((Double) obj).doubleValue(), i);
            AppMethodBeat.o(117140);
        } else if (obj instanceof String) {
            write((String) obj, i);
            AppMethodBeat.o(117140);
        } else if (obj instanceof Map) {
            write((Map) obj, i);
            AppMethodBeat.o(117140);
        } else if (obj instanceof List) {
            write((List) obj, i);
            AppMethodBeat.o(117140);
        } else if (obj instanceof JceStruct) {
            write((JceStruct) obj, i);
            AppMethodBeat.o(117140);
        } else if (obj instanceof byte[]) {
            write((byte[]) obj, i);
            AppMethodBeat.o(117140);
        } else if (obj instanceof boolean[]) {
            write((boolean[]) obj, i);
            AppMethodBeat.o(117140);
        } else if (obj instanceof short[]) {
            write((short[]) obj, i);
            AppMethodBeat.o(117140);
        } else if (obj instanceof int[]) {
            write((int[]) obj, i);
            AppMethodBeat.o(117140);
        } else if (obj instanceof long[]) {
            write((long[]) obj, i);
            AppMethodBeat.o(117140);
        } else if (obj instanceof float[]) {
            write((float[]) obj, i);
            AppMethodBeat.o(117140);
        } else if (obj instanceof double[]) {
            write((double[]) obj, i);
            AppMethodBeat.o(117140);
        } else if (obj.getClass().isArray()) {
            writeArray((Object[]) obj, i);
            AppMethodBeat.o(117140);
        } else if (obj instanceof Collection) {
            write((Collection) obj, i);
            AppMethodBeat.o(117140);
        } else {
            JceEncodeException jceEncodeException = new JceEncodeException("write object error: unsupport type. " + obj.getClass());
            AppMethodBeat.o(117140);
            throw jceEncodeException;
        }
    }

    public int setServerEncoding(String str) {
        this.sServerEncoding = str;
        return 0;
    }

    public static void main(String[] strArr) {
        AppMethodBeat.i(117141);
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.write(1311768467283714885L, 0);
        System.out.println(HexUtil.bytes2HexStr(jceOutputStream.getByteBuffer().array()));
        System.out.println(Arrays.toString(jceOutputStream.toByteArray()));
        AppMethodBeat.o(117141);
    }
}
