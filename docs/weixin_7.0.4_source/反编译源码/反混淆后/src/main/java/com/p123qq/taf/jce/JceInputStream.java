package com.p123qq.taf.jce;

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

/* renamed from: com.qq.taf.jce.JceInputStream */
public final class JceInputStream {
    /* renamed from: bs */
    private ByteBuffer f5225bs;
    protected String sServerEncoding = "GBK";

    /* renamed from: com.qq.taf.jce.JceInputStream$HeadData */
    public static class HeadData {
        public int tag;
        public byte type;

        public void clear() {
            this.type = (byte) 0;
            this.tag = 0;
        }
    }

    public JceInputStream(ByteBuffer byteBuffer) {
        this.f5225bs = byteBuffer;
    }

    public JceInputStream(byte[] bArr) {
        AppMethodBeat.m2504i(117142);
        this.f5225bs = ByteBuffer.wrap(bArr);
        AppMethodBeat.m2505o(117142);
    }

    public JceInputStream(byte[] bArr, int i) {
        AppMethodBeat.m2504i(117143);
        this.f5225bs = ByteBuffer.wrap(bArr);
        this.f5225bs.position(i);
        AppMethodBeat.m2505o(117143);
    }

    public final void warp(byte[] bArr) {
        AppMethodBeat.m2504i(117144);
        wrap(bArr);
        AppMethodBeat.m2505o(117144);
    }

    public final void wrap(byte[] bArr) {
        AppMethodBeat.m2504i(117145);
        this.f5225bs = ByteBuffer.wrap(bArr);
        AppMethodBeat.m2505o(117145);
    }

    public static int readHead(HeadData headData, ByteBuffer byteBuffer) {
        AppMethodBeat.m2504i(117146);
        byte b = byteBuffer.get();
        headData.type = (byte) (b & 15);
        headData.tag = (b & 240) >> 4;
        if (headData.tag == 15) {
            headData.tag = byteBuffer.get() & 255;
            AppMethodBeat.m2505o(117146);
            return 2;
        }
        AppMethodBeat.m2505o(117146);
        return 1;
    }

    public final void readHead(HeadData headData) {
        AppMethodBeat.m2504i(117147);
        JceInputStream.readHead(headData, this.f5225bs);
        AppMethodBeat.m2505o(117147);
    }

    private int peakHead(HeadData headData) {
        AppMethodBeat.m2504i(117148);
        int readHead = JceInputStream.readHead(headData, this.f5225bs.duplicate());
        AppMethodBeat.m2505o(117148);
        return readHead;
    }

    private void skip(int i) {
        AppMethodBeat.m2504i(117149);
        this.f5225bs.position(this.f5225bs.position() + i);
        AppMethodBeat.m2505o(117149);
    }

    public final boolean skipToTag(int i) {
        AppMethodBeat.m2504i(117150);
        try {
            HeadData headData = new HeadData();
            while (true) {
                int peakHead = peakHead(headData);
                if (i > headData.tag && headData.type != (byte) 11) {
                    skip(peakHead);
                    skipField(headData.type);
                }
            }
            if (i == headData.tag) {
                AppMethodBeat.m2505o(117150);
                return true;
            }
            AppMethodBeat.m2505o(117150);
            return false;
        } catch (JceDecodeException | BufferUnderflowException e) {
            AppMethodBeat.m2505o(117150);
            return false;
        }
    }

    public final void skipToStructEnd() {
        AppMethodBeat.m2504i(117151);
        HeadData headData = new HeadData();
        do {
            readHead(headData);
            skipField(headData.type);
        } while (headData.type != (byte) 11);
        AppMethodBeat.m2505o(117151);
    }

    private void skipField() {
        AppMethodBeat.m2504i(117152);
        HeadData headData = new HeadData();
        readHead(headData);
        skipField(headData.type);
        AppMethodBeat.m2505o(117152);
    }

    private void skipField(byte b) {
        int i = 0;
        AppMethodBeat.m2504i(117153);
        int read;
        JceDecodeException jceDecodeException;
        switch (b) {
            case (byte) 0:
                skip(1);
                AppMethodBeat.m2505o(117153);
                return;
            case (byte) 1:
                skip(2);
                AppMethodBeat.m2505o(117153);
                return;
            case (byte) 2:
                skip(4);
                AppMethodBeat.m2505o(117153);
                return;
            case (byte) 3:
                skip(8);
                AppMethodBeat.m2505o(117153);
                return;
            case (byte) 4:
                skip(4);
                AppMethodBeat.m2505o(117153);
                return;
            case (byte) 5:
                skip(8);
                AppMethodBeat.m2505o(117153);
                return;
            case (byte) 6:
                i = this.f5225bs.get();
                if (i < 0) {
                    i += 256;
                }
                skip(i);
                AppMethodBeat.m2505o(117153);
                return;
            case (byte) 7:
                skip(this.f5225bs.getInt());
                AppMethodBeat.m2505o(117153);
                return;
            case (byte) 8:
                read = read(0, 0, true);
                while (i < read * 2) {
                    skipField();
                    i++;
                }
                AppMethodBeat.m2505o(117153);
                return;
            case (byte) 9:
                read = read(0, 0, true);
                while (i < read) {
                    skipField();
                    i++;
                }
                AppMethodBeat.m2505o(117153);
                return;
            case (byte) 10:
                skipToStructEnd();
                AppMethodBeat.m2505o(117153);
                return;
            case (byte) 11:
            case (byte) 12:
                AppMethodBeat.m2505o(117153);
                return;
            case (byte) 13:
                HeadData headData = new HeadData();
                readHead(headData);
                if (headData.type != (byte) 0) {
                    jceDecodeException = new JceDecodeException("skipField with invalid type, type value: " + b + ", " + headData.type);
                    AppMethodBeat.m2505o(117153);
                    throw jceDecodeException;
                }
                skip(read(0, 0, true));
                AppMethodBeat.m2505o(117153);
                return;
            default:
                jceDecodeException = new JceDecodeException("invalid type.");
                AppMethodBeat.m2505o(117153);
                throw jceDecodeException;
        }
    }

    public final boolean read(boolean z, int i, boolean z2) {
        AppMethodBeat.m2504i(117154);
        if (read((byte) 0, i, z2) != (byte) 0) {
            AppMethodBeat.m2505o(117154);
            return true;
        }
        AppMethodBeat.m2505o(117154);
        return false;
    }

    public final byte read(byte b, int i, boolean z) {
        AppMethodBeat.m2504i(117155);
        JceDecodeException jceDecodeException;
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case (byte) 0:
                    b = this.f5225bs.get();
                    break;
                case (byte) 12:
                    b = (byte) 0;
                    break;
                default:
                    jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.m2505o(117155);
                    throw jceDecodeException;
            }
        } else if (z) {
            jceDecodeException = new JceDecodeException("require field not exist.");
            AppMethodBeat.m2505o(117155);
            throw jceDecodeException;
        }
        AppMethodBeat.m2505o(117155);
        return b;
    }

    public final short read(short s, int i, boolean z) {
        AppMethodBeat.m2504i(117156);
        JceDecodeException jceDecodeException;
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case (byte) 0:
                    s = (short) this.f5225bs.get();
                    break;
                case (byte) 1:
                    s = this.f5225bs.getShort();
                    break;
                case (byte) 12:
                    s = (short) 0;
                    break;
                default:
                    jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.m2505o(117156);
                    throw jceDecodeException;
            }
        } else if (z) {
            jceDecodeException = new JceDecodeException("require field not exist.");
            AppMethodBeat.m2505o(117156);
            throw jceDecodeException;
        }
        AppMethodBeat.m2505o(117156);
        return s;
    }

    public final int read(int i, int i2, boolean z) {
        AppMethodBeat.m2504i(117157);
        JceDecodeException jceDecodeException;
        if (skipToTag(i2)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case (byte) 0:
                    i = this.f5225bs.get();
                    break;
                case (byte) 1:
                    i = this.f5225bs.getShort();
                    break;
                case (byte) 2:
                    i = this.f5225bs.getInt();
                    break;
                case (byte) 12:
                    i = 0;
                    break;
                default:
                    jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.m2505o(117157);
                    throw jceDecodeException;
            }
        } else if (z) {
            jceDecodeException = new JceDecodeException("require field not exist.");
            AppMethodBeat.m2505o(117157);
            throw jceDecodeException;
        }
        AppMethodBeat.m2505o(117157);
        return i;
    }

    public final long read(long j, int i, boolean z) {
        AppMethodBeat.m2504i(117158);
        JceDecodeException jceDecodeException;
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case (byte) 0:
                    j = (long) this.f5225bs.get();
                    break;
                case (byte) 1:
                    j = (long) this.f5225bs.getShort();
                    break;
                case (byte) 2:
                    j = (long) this.f5225bs.getInt();
                    break;
                case (byte) 3:
                    j = this.f5225bs.getLong();
                    break;
                case (byte) 12:
                    j = 0;
                    break;
                default:
                    jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.m2505o(117158);
                    throw jceDecodeException;
            }
        } else if (z) {
            jceDecodeException = new JceDecodeException("require field not exist.");
            AppMethodBeat.m2505o(117158);
            throw jceDecodeException;
        }
        AppMethodBeat.m2505o(117158);
        return j;
    }

    public final float read(float f, int i, boolean z) {
        AppMethodBeat.m2504i(117159);
        JceDecodeException jceDecodeException;
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case (byte) 4:
                    f = this.f5225bs.getFloat();
                    break;
                case (byte) 12:
                    f = 0.0f;
                    break;
                default:
                    jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.m2505o(117159);
                    throw jceDecodeException;
            }
        } else if (z) {
            jceDecodeException = new JceDecodeException("require field not exist.");
            AppMethodBeat.m2505o(117159);
            throw jceDecodeException;
        }
        AppMethodBeat.m2505o(117159);
        return f;
    }

    public final double read(double d, int i, boolean z) {
        AppMethodBeat.m2504i(117160);
        JceDecodeException jceDecodeException;
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case (byte) 4:
                    d = (double) this.f5225bs.getFloat();
                    break;
                case (byte) 5:
                    d = this.f5225bs.getDouble();
                    break;
                case (byte) 12:
                    d = 0.0d;
                    break;
                default:
                    jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.m2505o(117160);
                    throw jceDecodeException;
            }
        } else if (z) {
            jceDecodeException = new JceDecodeException("require field not exist.");
            AppMethodBeat.m2505o(117160);
            throw jceDecodeException;
        }
        AppMethodBeat.m2505o(117160);
        return d;
    }

    public final String readByteString(String str, int i, boolean z) {
        AppMethodBeat.m2504i(117161);
        JceDecodeException jceDecodeException;
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            int i2;
            byte[] bArr;
            switch (headData.type) {
                case (byte) 6:
                    i2 = this.f5225bs.get();
                    if (i2 < 0) {
                        i2 += 256;
                    }
                    bArr = new byte[i2];
                    this.f5225bs.get(bArr);
                    str = HexUtil.bytes2HexStr(bArr);
                    break;
                case (byte) 7:
                    i2 = this.f5225bs.getInt();
                    if (i2 <= 104857600 && i2 >= 0) {
                        bArr = new byte[i2];
                        this.f5225bs.get(bArr);
                        str = HexUtil.bytes2HexStr(bArr);
                        break;
                    }
                    JceDecodeException jceDecodeException2 = new JceDecodeException("String too long: ".concat(String.valueOf(i2)));
                    AppMethodBeat.m2505o(117161);
                    throw jceDecodeException2;
                    break;
                default:
                    jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.m2505o(117161);
                    throw jceDecodeException;
            }
        } else if (z) {
            jceDecodeException = new JceDecodeException("require field not exist.");
            AppMethodBeat.m2505o(117161);
            throw jceDecodeException;
        }
        AppMethodBeat.m2505o(117161);
        return str;
    }

    public final String read(String str, int i, boolean z) {
        AppMethodBeat.m2504i(117162);
        JceDecodeException jceDecodeException;
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            int i2;
            byte[] bArr;
            switch (headData.type) {
                case (byte) 6:
                    i2 = this.f5225bs.get();
                    if (i2 < 0) {
                        i2 += 256;
                    }
                    bArr = new byte[i2];
                    this.f5225bs.get(bArr);
                    try {
                        str = new String(bArr, this.sServerEncoding);
                        break;
                    } catch (UnsupportedEncodingException e) {
                        str = new String(bArr);
                        break;
                    }
                case (byte) 7:
                    i2 = this.f5225bs.getInt();
                    if (i2 <= 104857600 && i2 >= 0) {
                        bArr = new byte[i2];
                        this.f5225bs.get(bArr);
                        try {
                            str = new String(bArr, this.sServerEncoding);
                            break;
                        } catch (UnsupportedEncodingException e2) {
                            str = new String(bArr);
                            break;
                        }
                    }
                    JceDecodeException jceDecodeException2 = new JceDecodeException("String too long: ".concat(String.valueOf(i2)));
                    AppMethodBeat.m2505o(117162);
                    throw jceDecodeException2;
                    break;
                default:
                    jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.m2505o(117162);
                    throw jceDecodeException;
            }
        } else if (z) {
            jceDecodeException = new JceDecodeException("require field not exist.");
            AppMethodBeat.m2505o(117162);
            throw jceDecodeException;
        }
        AppMethodBeat.m2505o(117162);
        return str;
    }

    public final String readString(int i, boolean z) {
        AppMethodBeat.m2504i(117163);
        String str = null;
        JceDecodeException jceDecodeException;
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            int i2;
            byte[] bArr;
            switch (headData.type) {
                case (byte) 6:
                    i2 = this.f5225bs.get();
                    if (i2 < 0) {
                        i2 += 256;
                    }
                    bArr = new byte[i2];
                    this.f5225bs.get(bArr);
                    try {
                        str = new String(bArr, this.sServerEncoding);
                        break;
                    } catch (UnsupportedEncodingException e) {
                        str = new String(bArr);
                        break;
                    }
                case (byte) 7:
                    i2 = this.f5225bs.getInt();
                    if (i2 <= 104857600 && i2 >= 0) {
                        bArr = new byte[i2];
                        this.f5225bs.get(bArr);
                        try {
                            str = new String(bArr, this.sServerEncoding);
                            break;
                        } catch (UnsupportedEncodingException e2) {
                            str = new String(bArr);
                            break;
                        }
                    }
                    JceDecodeException jceDecodeException2 = new JceDecodeException("String too long: ".concat(String.valueOf(i2)));
                    AppMethodBeat.m2505o(117163);
                    throw jceDecodeException2;
                    break;
                default:
                    jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.m2505o(117163);
                    throw jceDecodeException;
            }
        } else if (z) {
            jceDecodeException = new JceDecodeException("require field not exist.");
            AppMethodBeat.m2505o(117163);
            throw jceDecodeException;
        }
        AppMethodBeat.m2505o(117163);
        return str;
    }

    public final String[] read(String[] strArr, int i, boolean z) {
        AppMethodBeat.m2504i(117164);
        String[] strArr2 = (String[]) readArray((Object[]) strArr, i, z);
        AppMethodBeat.m2505o(117164);
        return strArr2;
    }

    public final Map<String, String> readStringMap(int i, boolean z) {
        AppMethodBeat.m2504i(117165);
        HashMap hashMap = new HashMap();
        JceDecodeException jceDecodeException;
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case (byte) 8:
                    int read = read(0, 0, true);
                    if (read >= 0) {
                        for (int i2 = 0; i2 < read; i2++) {
                            hashMap.put(readString(0, true), readString(1, true));
                        }
                        break;
                    }
                    jceDecodeException = new JceDecodeException("size invalid: ".concat(String.valueOf(read)));
                    AppMethodBeat.m2505o(117165);
                    throw jceDecodeException;
                default:
                    jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.m2505o(117165);
                    throw jceDecodeException;
            }
        } else if (z) {
            jceDecodeException = new JceDecodeException("require field not exist.");
            AppMethodBeat.m2505o(117165);
            throw jceDecodeException;
        }
        AppMethodBeat.m2505o(117165);
        return hashMap;
    }

    public final <K, V> HashMap<K, V> readMap(Map<K, V> map, int i, boolean z) {
        AppMethodBeat.m2504i(117166);
        HashMap hashMap = (HashMap) readMap(new HashMap(), map, i, z);
        AppMethodBeat.m2505o(117166);
        return hashMap;
    }

    private <K, V> Map<K, V> readMap(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        AppMethodBeat.m2504i(117167);
        if (map2 == null || map2.isEmpty()) {
            HashMap hashMap = new HashMap();
            AppMethodBeat.m2505o(117167);
            return hashMap;
        }
        Entry entry = (Entry) map2.entrySet().iterator().next();
        Object key = entry.getKey();
        Object value = entry.getValue();
        JceDecodeException jceDecodeException;
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case (byte) 8:
                    int read = read(0, 0, true);
                    if (read >= 0) {
                        for (int i2 = 0; i2 < read; i2++) {
                            map.put(read(key, 0, true), read(value, 1, true));
                        }
                        break;
                    }
                    jceDecodeException = new JceDecodeException("size invalid: ".concat(String.valueOf(read)));
                    AppMethodBeat.m2505o(117167);
                    throw jceDecodeException;
                default:
                    jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.m2505o(117167);
                    throw jceDecodeException;
            }
        } else if (z) {
            jceDecodeException = new JceDecodeException("require field not exist.");
            AppMethodBeat.m2505o(117167);
            throw jceDecodeException;
        }
        AppMethodBeat.m2505o(117167);
        return map;
    }

    public final List readList(int i, boolean z) {
        AppMethodBeat.m2504i(117168);
        ArrayList arrayList = new ArrayList();
        JceDecodeException jceDecodeException;
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case (byte) 9:
                    int read = read(0, 0, true);
                    if (read >= 0) {
                        for (int i2 = 0; i2 < read; i2++) {
                            headData = new HeadData();
                            readHead(headData);
                            switch (headData.type) {
                                case (byte) 0:
                                    skip(1);
                                    break;
                                case (byte) 1:
                                    skip(2);
                                    break;
                                case (byte) 2:
                                    skip(4);
                                    break;
                                case (byte) 3:
                                    skip(8);
                                    break;
                                case (byte) 4:
                                    skip(4);
                                    break;
                                case (byte) 5:
                                    skip(8);
                                    break;
                                case (byte) 6:
                                    int i3 = this.f5225bs.get();
                                    if (i3 < 0) {
                                        i3 += 256;
                                    }
                                    skip(i3);
                                    break;
                                case (byte) 7:
                                    skip(this.f5225bs.getInt());
                                    break;
                                case (byte) 8:
                                case (byte) 9:
                                    break;
                                case (byte) 10:
                                    try {
                                        JceStruct jceStruct = (JceStruct) Class.forName(JceStruct.class.getName()).getConstructor(new Class[0]).newInstance(new Object[0]);
                                        jceStruct.readFrom(this);
                                        skipToStructEnd();
                                        arrayList.add(jceStruct);
                                        break;
                                    } catch (Exception e) {
                                        JceDecodeException jceDecodeException2 = new JceDecodeException("type mismatch.".concat(String.valueOf(e)));
                                        AppMethodBeat.m2505o(117168);
                                        throw jceDecodeException2;
                                    }
                                case (byte) 12:
                                    arrayList.add(Integer.valueOf(0));
                                    break;
                                default:
                                    jceDecodeException = new JceDecodeException("type mismatch.");
                                    AppMethodBeat.m2505o(117168);
                                    throw jceDecodeException;
                            }
                        }
                        break;
                    }
                    jceDecodeException = new JceDecodeException("size invalid: ".concat(String.valueOf(read)));
                    AppMethodBeat.m2505o(117168);
                    throw jceDecodeException;
                default:
                    jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.m2505o(117168);
                    throw jceDecodeException;
            }
        } else if (z) {
            jceDecodeException = new JceDecodeException("require field not exist.");
            AppMethodBeat.m2505o(117168);
            throw jceDecodeException;
        }
        AppMethodBeat.m2505o(117168);
        return arrayList;
    }

    public final boolean[] read(boolean[] zArr, int i, boolean z) {
        AppMethodBeat.m2504i(117169);
        boolean[] zArr2 = null;
        JceDecodeException jceDecodeException;
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case (byte) 9:
                    int read = read(0, 0, true);
                    if (read >= 0) {
                        zArr2 = new boolean[read];
                        for (int i2 = 0; i2 < read; i2++) {
                            zArr2[i2] = read(zArr2[0], 0, true);
                        }
                        break;
                    }
                    jceDecodeException = new JceDecodeException("size invalid: ".concat(String.valueOf(read)));
                    AppMethodBeat.m2505o(117169);
                    throw jceDecodeException;
                default:
                    jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.m2505o(117169);
                    throw jceDecodeException;
            }
        } else if (z) {
            jceDecodeException = new JceDecodeException("require field not exist.");
            AppMethodBeat.m2505o(117169);
            throw jceDecodeException;
        }
        AppMethodBeat.m2505o(117169);
        return zArr2;
    }

    public final byte[] read(byte[] bArr, int i, boolean z) {
        AppMethodBeat.m2504i(117170);
        byte[] bArr2 = null;
        JceDecodeException jceDecodeException;
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case (byte) 9:
                    int read = read(0, 0, true);
                    if (read >= 0) {
                        bArr2 = new byte[read];
                        for (int i2 = 0; i2 < read; i2++) {
                            bArr2[i2] = read(bArr2[0], 0, true);
                        }
                        break;
                    }
                    jceDecodeException = new JceDecodeException("size invalid: ".concat(String.valueOf(read)));
                    AppMethodBeat.m2505o(117170);
                    throw jceDecodeException;
                case (byte) 13:
                    HeadData headData2 = new HeadData();
                    readHead(headData2);
                    if (headData2.type == (byte) 0) {
                        int read2 = read(0, 0, true);
                        if (read2 >= 0) {
                            bArr2 = new byte[read2];
                            this.f5225bs.get(bArr2);
                            break;
                        }
                        JceDecodeException jceDecodeException2 = new JceDecodeException("invalid size, tag: " + i + ", type: " + headData.type + ", " + headData2.type + ", size: " + read2);
                        AppMethodBeat.m2505o(117170);
                        throw jceDecodeException2;
                    }
                    JceDecodeException jceDecodeException3 = new JceDecodeException("type mismatch, tag: " + i + ", type: " + headData.type + ", " + headData2.type);
                    AppMethodBeat.m2505o(117170);
                    throw jceDecodeException3;
                default:
                    jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.m2505o(117170);
                    throw jceDecodeException;
            }
        } else if (z) {
            jceDecodeException = new JceDecodeException("require field not exist.");
            AppMethodBeat.m2505o(117170);
            throw jceDecodeException;
        }
        AppMethodBeat.m2505o(117170);
        return bArr2;
    }

    public final short[] read(short[] sArr, int i, boolean z) {
        AppMethodBeat.m2504i(117171);
        short[] sArr2 = null;
        JceDecodeException jceDecodeException;
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case (byte) 9:
                    int read = read(0, 0, true);
                    if (read >= 0) {
                        sArr2 = new short[read];
                        for (int i2 = 0; i2 < read; i2++) {
                            sArr2[i2] = read(sArr2[0], 0, true);
                        }
                        break;
                    }
                    jceDecodeException = new JceDecodeException("size invalid: ".concat(String.valueOf(read)));
                    AppMethodBeat.m2505o(117171);
                    throw jceDecodeException;
                default:
                    jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.m2505o(117171);
                    throw jceDecodeException;
            }
        } else if (z) {
            jceDecodeException = new JceDecodeException("require field not exist.");
            AppMethodBeat.m2505o(117171);
            throw jceDecodeException;
        }
        AppMethodBeat.m2505o(117171);
        return sArr2;
    }

    public final int[] read(int[] iArr, int i, boolean z) {
        AppMethodBeat.m2504i(117172);
        int[] iArr2 = null;
        JceDecodeException jceDecodeException;
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case (byte) 9:
                    int read = read(0, 0, true);
                    if (read >= 0) {
                        iArr2 = new int[read];
                        for (int i2 = 0; i2 < read; i2++) {
                            iArr2[i2] = read(iArr2[0], 0, true);
                        }
                        break;
                    }
                    jceDecodeException = new JceDecodeException("size invalid: ".concat(String.valueOf(read)));
                    AppMethodBeat.m2505o(117172);
                    throw jceDecodeException;
                default:
                    jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.m2505o(117172);
                    throw jceDecodeException;
            }
        } else if (z) {
            jceDecodeException = new JceDecodeException("require field not exist.");
            AppMethodBeat.m2505o(117172);
            throw jceDecodeException;
        }
        AppMethodBeat.m2505o(117172);
        return iArr2;
    }

    public final long[] read(long[] jArr, int i, boolean z) {
        AppMethodBeat.m2504i(117173);
        long[] jArr2 = null;
        JceDecodeException jceDecodeException;
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case (byte) 9:
                    int read = read(0, 0, true);
                    if (read >= 0) {
                        jArr2 = new long[read];
                        for (int i2 = 0; i2 < read; i2++) {
                            jArr2[i2] = read(jArr2[0], 0, true);
                        }
                        break;
                    }
                    jceDecodeException = new JceDecodeException("size invalid: ".concat(String.valueOf(read)));
                    AppMethodBeat.m2505o(117173);
                    throw jceDecodeException;
                default:
                    jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.m2505o(117173);
                    throw jceDecodeException;
            }
        } else if (z) {
            jceDecodeException = new JceDecodeException("require field not exist.");
            AppMethodBeat.m2505o(117173);
            throw jceDecodeException;
        }
        AppMethodBeat.m2505o(117173);
        return jArr2;
    }

    public final float[] read(float[] fArr, int i, boolean z) {
        AppMethodBeat.m2504i(117174);
        float[] fArr2 = null;
        JceDecodeException jceDecodeException;
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case (byte) 9:
                    int read = read(0, 0, true);
                    if (read >= 0) {
                        fArr2 = new float[read];
                        for (int i2 = 0; i2 < read; i2++) {
                            fArr2[i2] = read(fArr2[0], 0, true);
                        }
                        break;
                    }
                    jceDecodeException = new JceDecodeException("size invalid: ".concat(String.valueOf(read)));
                    AppMethodBeat.m2505o(117174);
                    throw jceDecodeException;
                default:
                    jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.m2505o(117174);
                    throw jceDecodeException;
            }
        } else if (z) {
            jceDecodeException = new JceDecodeException("require field not exist.");
            AppMethodBeat.m2505o(117174);
            throw jceDecodeException;
        }
        AppMethodBeat.m2505o(117174);
        return fArr2;
    }

    public final double[] read(double[] dArr, int i, boolean z) {
        AppMethodBeat.m2504i(117175);
        double[] dArr2 = null;
        JceDecodeException jceDecodeException;
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case (byte) 9:
                    int read = read(0, 0, true);
                    if (read >= 0) {
                        dArr2 = new double[read];
                        for (int i2 = 0; i2 < read; i2++) {
                            dArr2[i2] = read(dArr2[0], 0, true);
                        }
                        break;
                    }
                    jceDecodeException = new JceDecodeException("size invalid: ".concat(String.valueOf(read)));
                    AppMethodBeat.m2505o(117175);
                    throw jceDecodeException;
                default:
                    jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.m2505o(117175);
                    throw jceDecodeException;
            }
        } else if (z) {
            jceDecodeException = new JceDecodeException("require field not exist.");
            AppMethodBeat.m2505o(117175);
            throw jceDecodeException;
        }
        AppMethodBeat.m2505o(117175);
        return dArr2;
    }

    public final <T> T[] readArray(T[] tArr, int i, boolean z) {
        AppMethodBeat.m2504i(117176);
        if (tArr == null || tArr.length == 0) {
            JceDecodeException jceDecodeException = new JceDecodeException("unable to get type of key and value.");
            AppMethodBeat.m2505o(117176);
            throw jceDecodeException;
        }
        Object[] readArrayImpl = readArrayImpl(tArr[0], i, z);
        AppMethodBeat.m2505o(117176);
        return readArrayImpl;
    }

    public final <T> List<T> readArray(List<T> list, int i, boolean z) {
        int i2 = 0;
        AppMethodBeat.m2504i(117177);
        if (list == null || list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.m2505o(117177);
            return arrayList;
        }
        Object[] readArrayImpl = readArrayImpl(list.get(0), i, z);
        if (readArrayImpl == null) {
            AppMethodBeat.m2505o(117177);
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        while (i2 < readArrayImpl.length) {
            arrayList2.add(readArrayImpl[i2]);
            i2++;
        }
        AppMethodBeat.m2505o(117177);
        return arrayList2;
    }

    private <T> T[] readArrayImpl(T t, int i, boolean z) {
        AppMethodBeat.m2504i(117178);
        JceDecodeException jceDecodeException;
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            switch (headData.type) {
                case (byte) 9:
                    int read = read(0, 0, true);
                    if (read < 0) {
                        jceDecodeException = new JceDecodeException("size invalid: ".concat(String.valueOf(read)));
                        AppMethodBeat.m2505o(117178);
                        throw jceDecodeException;
                    }
                    Object[] objArr = (Object[]) Array.newInstance(t.getClass(), read);
                    for (int i2 = 0; i2 < read; i2++) {
                        objArr[i2] = read((Object) t, 0, true);
                    }
                    AppMethodBeat.m2505o(117178);
                    return objArr;
                default:
                    jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.m2505o(117178);
                    throw jceDecodeException;
            }
        } else if (z) {
            jceDecodeException = new JceDecodeException("require field not exist.");
            AppMethodBeat.m2505o(117178);
            throw jceDecodeException;
        } else {
            AppMethodBeat.m2505o(117178);
            return null;
        }
    }

    public final JceStruct directRead(JceStruct jceStruct, int i, boolean z) {
        AppMethodBeat.m2504i(117179);
        JceStruct jceStruct2 = null;
        JceDecodeException jceDecodeException;
        if (skipToTag(i)) {
            try {
                jceStruct2 = jceStruct.newInit();
                HeadData headData = new HeadData();
                readHead(headData);
                if (headData.type != (byte) 10) {
                    jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.m2505o(117179);
                    throw jceDecodeException;
                }
                jceStruct2.readFrom(this);
                skipToStructEnd();
            } catch (Exception e) {
                JceDecodeException jceDecodeException2 = new JceDecodeException(e.getMessage());
                AppMethodBeat.m2505o(117179);
                throw jceDecodeException2;
            }
        } else if (z) {
            jceDecodeException = new JceDecodeException("require field not exist.");
            AppMethodBeat.m2505o(117179);
            throw jceDecodeException;
        }
        AppMethodBeat.m2505o(117179);
        return jceStruct2;
    }

    public final JceStruct read(JceStruct jceStruct, int i, boolean z) {
        AppMethodBeat.m2504i(117180);
        JceStruct jceStruct2 = null;
        JceDecodeException jceDecodeException;
        if (skipToTag(i)) {
            try {
                jceStruct2 = (JceStruct) jceStruct.getClass().newInstance();
                HeadData headData = new HeadData();
                readHead(headData);
                if (headData.type != (byte) 10) {
                    jceDecodeException = new JceDecodeException("type mismatch.");
                    AppMethodBeat.m2505o(117180);
                    throw jceDecodeException;
                }
                jceStruct2.readFrom(this);
                skipToStructEnd();
            } catch (Exception e) {
                JceDecodeException jceDecodeException2 = new JceDecodeException(e.getMessage());
                AppMethodBeat.m2505o(117180);
                throw jceDecodeException2;
            }
        } else if (z) {
            jceDecodeException = new JceDecodeException("require field not exist.");
            AppMethodBeat.m2505o(117180);
            throw jceDecodeException;
        }
        AppMethodBeat.m2505o(117180);
        return jceStruct2;
    }

    public final JceStruct[] read(JceStruct[] jceStructArr, int i, boolean z) {
        AppMethodBeat.m2504i(117181);
        JceStruct[] jceStructArr2 = (JceStruct[]) readArray((Object[]) jceStructArr, i, z);
        AppMethodBeat.m2505o(117181);
        return jceStructArr2;
    }

    public final <T> Object read(T t, int i, boolean z) {
        AppMethodBeat.m2504i(117182);
        Object valueOf;
        if (t instanceof Byte) {
            Byte valueOf2 = Byte.valueOf(read((byte) 0, i, z));
            AppMethodBeat.m2505o(117182);
            return valueOf2;
        } else if (t instanceof Boolean) {
            valueOf = Boolean.valueOf(read(false, i, z));
            AppMethodBeat.m2505o(117182);
            return valueOf;
        } else if (t instanceof Short) {
            valueOf = Short.valueOf(read((short) 0, i, z));
            AppMethodBeat.m2505o(117182);
            return valueOf;
        } else if (t instanceof Integer) {
            valueOf = Integer.valueOf(read(0, i, z));
            AppMethodBeat.m2505o(117182);
            return valueOf;
        } else if (t instanceof Long) {
            valueOf = Long.valueOf(read(0, i, z));
            AppMethodBeat.m2505o(117182);
            return valueOf;
        } else if (t instanceof Float) {
            valueOf = Float.valueOf(read(0.0f, i, z));
            AppMethodBeat.m2505o(117182);
            return valueOf;
        } else if (t instanceof Double) {
            valueOf = Double.valueOf(read(0.0d, i, z));
            AppMethodBeat.m2505o(117182);
            return valueOf;
        } else if (t instanceof String) {
            valueOf = readString(i, z);
            AppMethodBeat.m2505o(117182);
            return valueOf;
        } else if (t instanceof Map) {
            valueOf = readMap((Map) t, i, z);
            AppMethodBeat.m2505o(117182);
            return valueOf;
        } else if (t instanceof List) {
            valueOf = readArray((List) t, i, z);
            AppMethodBeat.m2505o(117182);
            return valueOf;
        } else if (t instanceof JceStruct) {
            valueOf = read((JceStruct) t, i, z);
            AppMethodBeat.m2505o(117182);
            return valueOf;
        } else if (!t.getClass().isArray()) {
            JceDecodeException jceDecodeException = new JceDecodeException("read object error: unsupport type.");
            AppMethodBeat.m2505o(117182);
            throw jceDecodeException;
        } else if ((t instanceof byte[]) || (t instanceof Byte[])) {
            valueOf = read(null, i, z);
            AppMethodBeat.m2505o(117182);
            return valueOf;
        } else if (t instanceof boolean[]) {
            valueOf = read(null, i, z);
            AppMethodBeat.m2505o(117182);
            return valueOf;
        } else if (t instanceof short[]) {
            valueOf = read(null, i, z);
            AppMethodBeat.m2505o(117182);
            return valueOf;
        } else if (t instanceof int[]) {
            valueOf = read(null, i, z);
            AppMethodBeat.m2505o(117182);
            return valueOf;
        } else if (t instanceof long[]) {
            valueOf = read(null, i, z);
            AppMethodBeat.m2505o(117182);
            return valueOf;
        } else if (t instanceof float[]) {
            valueOf = read(null, i, z);
            AppMethodBeat.m2505o(117182);
            return valueOf;
        } else if (t instanceof double[]) {
            valueOf = read(null, i, z);
            AppMethodBeat.m2505o(117182);
            return valueOf;
        } else {
            valueOf = readArray((Object[]) t, i, z);
            AppMethodBeat.m2505o(117182);
            return valueOf;
        }
    }

    public final int setServerEncoding(String str) {
        this.sServerEncoding = str;
        return 0;
    }

    public static void main(String[] strArr) {
    }

    public final ByteBuffer getBs() {
        return this.f5225bs;
    }
}
