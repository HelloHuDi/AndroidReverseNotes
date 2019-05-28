package com.tencent.p177mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.sdk.platformtools.y */
public final class C5069y {
    private ByteBuffer byteBuffer;
    private boolean xyz;

    /* renamed from: bW */
    private static int m7693bW(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return -1;
        }
        if (bArr[0] != (byte) 123) {
            return -2;
        }
        if (bArr[bArr.length - 1] != (byte) 125) {
            return -3;
        }
        return 0;
    }

    /* renamed from: bX */
    public final int mo10393bX(byte[] bArr) {
        AppMethodBeat.m2504i(52018);
        if (C5069y.m7693bW(bArr) != 0) {
            this.byteBuffer = null;
            AppMethodBeat.m2505o(52018);
            return -1;
        }
        this.byteBuffer = ByteBuffer.wrap(bArr);
        this.byteBuffer.position(1);
        this.xyz = false;
        AppMethodBeat.m2505o(52018);
        return 0;
    }

    public final int getInt() {
        AppMethodBeat.m2504i(52019);
        if (this.xyz) {
            Exception exception = new Exception("Buffer For Build");
            AppMethodBeat.m2505o(52019);
            throw exception;
        }
        int i = this.byteBuffer.getInt();
        AppMethodBeat.m2505o(52019);
        return i;
    }

    public final long getLong() {
        AppMethodBeat.m2504i(52020);
        if (this.xyz) {
            Exception exception = new Exception("Buffer For Build");
            AppMethodBeat.m2505o(52020);
            throw exception;
        }
        long j = this.byteBuffer.getLong();
        AppMethodBeat.m2505o(52020);
        return j;
    }

    public final byte[] getBuffer() {
        AppMethodBeat.m2504i(52021);
        Exception exception;
        if (this.xyz) {
            exception = new Exception("Buffer For Build");
            AppMethodBeat.m2505o(52021);
            throw exception;
        }
        short s = this.byteBuffer.getShort();
        byte[] bArr;
        if (s > (short) 2048) {
            this.byteBuffer = null;
            exception = new Exception("Buffer String Length Error");
            AppMethodBeat.m2505o(52021);
            throw exception;
        } else if (s == (short) 0) {
            bArr = new byte[0];
            AppMethodBeat.m2505o(52021);
            return bArr;
        } else {
            bArr = new byte[s];
            this.byteBuffer.get(bArr, 0, s);
            AppMethodBeat.m2505o(52021);
            return bArr;
        }
    }

    public final String getString() {
        AppMethodBeat.m2504i(52022);
        Exception exception;
        if (this.xyz) {
            exception = new Exception("Buffer For Build");
            AppMethodBeat.m2505o(52022);
            throw exception;
        }
        short s = this.byteBuffer.getShort();
        String str;
        if (s > (short) 2048) {
            this.byteBuffer = null;
            exception = new Exception("Buffer String Length Error");
            AppMethodBeat.m2505o(52022);
            throw exception;
        } else if (s == (short) 0) {
            str = "";
            AppMethodBeat.m2505o(52022);
            return str;
        } else {
            byte[] bArr = new byte[s];
            this.byteBuffer.get(bArr, 0, s);
            str = new String(bArr, "UTF-8");
            AppMethodBeat.m2505o(52022);
            return str;
        }
    }

    /* renamed from: LW */
    public final void mo10390LW(int i) {
        AppMethodBeat.m2504i(52023);
        ByteBuffer byteBuffer = this.byteBuffer;
        byteBuffer.position(byteBuffer.position() + i);
        AppMethodBeat.m2505o(52023);
    }

    public final void doe() {
        AppMethodBeat.m2504i(52024);
        Exception exception;
        if (this.xyz) {
            exception = new Exception("Buffer For Build");
            AppMethodBeat.m2505o(52024);
            throw exception;
        }
        short s = this.byteBuffer.getShort();
        if (s > (short) 2048) {
            this.byteBuffer = null;
            exception = new Exception("Buffer String Length Error");
            AppMethodBeat.m2505o(52024);
            throw exception;
        } else if (s == (short) 0) {
            AppMethodBeat.m2505o(52024);
        } else {
            this.byteBuffer.position(s + this.byteBuffer.position());
            AppMethodBeat.m2505o(52024);
        }
    }

    public final boolean dof() {
        AppMethodBeat.m2504i(52025);
        if (this.byteBuffer.limit() - this.byteBuffer.position() <= 1) {
            AppMethodBeat.m2505o(52025);
            return true;
        }
        AppMethodBeat.m2505o(52025);
        return false;
    }

    public final int dog() {
        AppMethodBeat.m2504i(52026);
        this.byteBuffer = ByteBuffer.allocate(4096);
        this.byteBuffer.put((byte) 123);
        this.xyz = true;
        AppMethodBeat.m2505o(52026);
        return 0;
    }

    /* renamed from: LX */
    private int m7692LX(int i) {
        AppMethodBeat.m2504i(52027);
        if (this.byteBuffer.limit() - this.byteBuffer.position() > i) {
            AppMethodBeat.m2505o(52027);
        } else {
            ByteBuffer allocate = ByteBuffer.allocate(this.byteBuffer.limit() + 4096);
            allocate.put(this.byteBuffer.array(), 0, this.byteBuffer.position());
            this.byteBuffer = allocate;
            AppMethodBeat.m2505o(52027);
        }
        return 0;
    }

    /* renamed from: LY */
    public final int mo10391LY(int i) {
        AppMethodBeat.m2504i(52028);
        if (this.xyz) {
            m7692LX(4);
            this.byteBuffer.putInt(i);
            AppMethodBeat.m2505o(52028);
            return 0;
        }
        Exception exception = new Exception("Buffer For Parse");
        AppMethodBeat.m2505o(52028);
        throw exception;
    }

    /* renamed from: mq */
    public final int mo10403mq(long j) {
        AppMethodBeat.m2504i(52029);
        if (this.xyz) {
            m7692LX(8);
            this.byteBuffer.putLong(j);
            AppMethodBeat.m2505o(52029);
            return 0;
        }
        Exception exception = new Exception("Buffer For Parse");
        AppMethodBeat.m2505o(52029);
        throw exception;
    }

    /* renamed from: bY */
    public final int mo10394bY(byte[] bArr) {
        AppMethodBeat.m2504i(52030);
        Exception exception;
        if (this.xyz) {
            byte[] bArr2 = null;
            if (bArr != null) {
                bArr2 = bArr;
            }
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            if (bArr2.length > 2048) {
                exception = new Exception("Buffer String Length Error");
                AppMethodBeat.m2505o(52030);
                throw exception;
            }
            m7692LX(bArr2.length + 2);
            this.byteBuffer.putShort((short) bArr2.length);
            if (bArr2.length > 0) {
                this.byteBuffer.put(bArr2);
            }
            AppMethodBeat.m2505o(52030);
            return 0;
        }
        exception = new Exception("Buffer For Parse");
        AppMethodBeat.m2505o(52030);
        throw exception;
    }

    public final int amu(String str) {
        AppMethodBeat.m2504i(52031);
        Exception exception;
        if (this.xyz) {
            byte[] bArr = null;
            if (str != null) {
                bArr = str.getBytes();
            }
            if (bArr == null) {
                bArr = new byte[0];
            }
            if (bArr.length > 2048) {
                exception = new Exception("Buffer String Length Error");
                AppMethodBeat.m2505o(52031);
                throw exception;
            }
            m7692LX(bArr.length + 2);
            this.byteBuffer.putShort((short) bArr.length);
            if (bArr.length > 0) {
                this.byteBuffer.put(bArr);
            }
            AppMethodBeat.m2505o(52031);
            return 0;
        }
        exception = new Exception("Buffer For Parse");
        AppMethodBeat.m2505o(52031);
        throw exception;
    }

    public final byte[] doh() {
        AppMethodBeat.m2504i(52032);
        if (this.xyz) {
            m7692LX(1);
            this.byteBuffer.put((byte) 125);
            byte[] bArr = new byte[this.byteBuffer.position()];
            System.arraycopy(this.byteBuffer.array(), 0, bArr, 0, bArr.length);
            AppMethodBeat.m2505o(52032);
            return bArr;
        }
        Exception exception = new Exception("Buffer For Parse");
        AppMethodBeat.m2505o(52032);
        throw exception;
    }
}
