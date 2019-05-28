package com.tencent.matrix.resource.p164c;

import com.tencent.matrix.resource.p164c.p165a.C1100a;
import com.tencent.matrix.resource.p164c.p165a.C1101b;
import com.tencent.matrix.resource.p164c.p165a.C1102c;
import com.tencent.matrix.resource.p164c.p166b.C1111a;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.C31128d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* renamed from: com.tencent.matrix.resource.c.e */
public final class C6288e extends C1114d {
    int bXj = 0;
    final OutputStream bXu;
    final ByteArrayOutputStream bXv = new ByteArrayOutputStream();

    /* renamed from: com.tencent.matrix.resource.c.e$a */
    class C6287a extends C1112b {
        private final int bXw;
        private final long bXx;
        private final int mTag;

        C6287a(int i, int i2, long j) {
            super(null);
            this.mTag = i;
            this.bXw = i2;
            this.bXx = j;
        }

        /* renamed from: a */
        public final void mo4315a(int i, C1101b c1101b) {
            try {
                C6288e.this.bXv.write(C31128d.MIC_PTU_ZIPAI_LIGHTRED);
                C1111a.m2435b(C6288e.this.bXv, i);
                C6288e.this.bXv.write(c1101b.bXC);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        /* renamed from: b */
        public final void mo4319b(int i, C1101b c1101b) {
            try {
                C6288e.this.bXv.write(i);
                C6288e.this.bXv.write(c1101b.bXC);
                if (i == 1) {
                    C1111a.m2436b(C6288e.this.bXv, (long) C6288e.this.bXj);
                }
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        /* renamed from: a */
        public final void mo4317a(C1101b c1101b, int i, int i2) {
            try {
                C6288e.this.bXv.write(2);
                C6288e.this.bXv.write(c1101b.bXC);
                C1111a.m2435b(C6288e.this.bXv, i);
                C1111a.m2435b(C6288e.this.bXv, i2);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        /* renamed from: b */
        public final void mo4321b(C1101b c1101b, int i, int i2) {
            try {
                C6288e.this.bXv.write(3);
                C6288e.this.bXv.write(c1101b.bXC);
                C1111a.m2435b(C6288e.this.bXv, i);
                C1111a.m2435b(C6288e.this.bXv, i2);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        /* renamed from: a */
        public final void mo4316a(C1101b c1101b, int i) {
            try {
                C6288e.this.bXv.write(4);
                C6288e.this.bXv.write(c1101b.bXC);
                C1111a.m2435b(C6288e.this.bXv, i);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        /* renamed from: b */
        public final void mo4320b(C1101b c1101b, int i) {
            try {
                C6288e.this.bXv.write(6);
                C6288e.this.bXv.write(c1101b.bXC);
                C1111a.m2435b(C6288e.this.bXv, i);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        /* renamed from: c */
        public final void mo4322c(C1101b c1101b, int i, int i2) {
            try {
                C6288e.this.bXv.write(8);
                C6288e.this.bXv.write(c1101b.bXC);
                C1111a.m2435b(C6288e.this.bXv, i);
                C1111a.m2435b(C6288e.this.bXv, i2);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        /* renamed from: a */
        public final void mo4313a(C1101b c1101b, int i, C1101b c1101b2, C1101b c1101b3, int i2, C1100a[] c1100aArr, C1100a[] c1100aArr2) {
            try {
                C6288e.this.bXv.write(32);
                C6288e.this.bXv.write(c1101b.bXC);
                C1111a.m2435b(C6288e.this.bXv, i);
                C6288e.this.bXv.write(c1101b2.bXC);
                C6288e.this.bXv.write(c1101b3.bXC);
                C1111a.m2436b(C6288e.this.bXv, (long) (C6288e.this.bXj << 2));
                C1111a.m2435b(C6288e.this.bXv, i2);
                C1111a.m2431a(C6288e.this.bXv, 0);
                C1111a.m2431a(C6288e.this.bXv, c1100aArr.length);
                for (C1100a c1100a : c1100aArr) {
                    C1111a.m2433a(C6288e.this.bXv, c1100a.bXA);
                    C6288e.this.bXv.write(c1100a.bXz);
                    OutputStream outputStream = C6288e.this.bXv;
                    Object obj = c1100a.bXB;
                    if (obj == null) {
                        throw new IllegalArgumentException("value is null.");
                    }
                    if (obj instanceof C1101b) {
                        C1111a.m2433a(outputStream, (C1101b) obj);
                    } else if ((obj instanceof Boolean) || Boolean.TYPE.isAssignableFrom(obj.getClass())) {
                        outputStream.write(((Boolean) obj).booleanValue() ? 1 : 0);
                    } else if ((obj instanceof Character) || Character.TYPE.isAssignableFrom(obj.getClass())) {
                        C1111a.m2431a(outputStream, ((Character) obj).charValue());
                    } else if ((obj instanceof Float) || Float.TYPE.isAssignableFrom(obj.getClass())) {
                        C1111a.m2435b(outputStream, Float.floatToRawIntBits(((Float) obj).floatValue()));
                    } else if ((obj instanceof Double) || Double.TYPE.isAssignableFrom(obj.getClass())) {
                        C1111a.m2432a(outputStream, Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                    } else if ((obj instanceof Byte) || Byte.TYPE.isAssignableFrom(obj.getClass())) {
                        outputStream.write(((Byte) obj).byteValue());
                    } else if ((obj instanceof Short) || Short.TYPE.isAssignableFrom(obj.getClass())) {
                        C1111a.m2431a(outputStream, ((Short) obj).shortValue());
                    } else if ((obj instanceof Integer) || Integer.TYPE.isAssignableFrom(obj.getClass())) {
                        C1111a.m2435b(outputStream, ((Integer) obj).intValue());
                    } else if ((obj instanceof Long) || Long.TYPE.isAssignableFrom(obj.getClass())) {
                        C1111a.m2432a(outputStream, ((Long) obj).longValue());
                    } else {
                        throw new IllegalArgumentException("bad value type: " + obj.getClass().getName());
                    }
                }
                C1111a.m2431a(C6288e.this.bXv, c1100aArr2.length);
                for (C1100a c1100a2 : c1100aArr2) {
                    C1111a.m2433a(C6288e.this.bXv, c1100a2.bXA);
                    C6288e.this.bXv.write(c1100a2.bXz);
                }
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        /* renamed from: a */
        public final void mo4309a(C1101b c1101b, int i, C1101b c1101b2, byte[] bArr) {
            try {
                C6288e.this.bXv.write(33);
                C6288e.this.bXv.write(c1101b.bXC);
                C1111a.m2435b(C6288e.this.bXv, i);
                C6288e.this.bXv.write(c1101b2.bXC);
                C1111a.m2435b(C6288e.this.bXv, bArr.length);
                C6288e.this.bXv.write(bArr);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        /* renamed from: a */
        public final void mo4318a(C1101b c1101b, int i, int i2, C1101b c1101b2, byte[] bArr) {
            try {
                C6288e.this.bXv.write(34);
                C6288e.this.bXv.write(c1101b.bXC);
                C1111a.m2435b(C6288e.this.bXv, i);
                C1111a.m2435b(C6288e.this.bXv, i2);
                C6288e.this.bXv.write(c1101b2.bXC);
                C6288e.this.bXv.write(bArr, 0, C6288e.this.bXj * i2);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        /* renamed from: a */
        public final void mo4308a(int i, C1101b c1101b, int i2, int i3, int i4, byte[] bArr) {
            try {
                C6288e.this.bXv.write(i);
                C6288e.this.bXv.write(c1101b.bXC);
                C1111a.m2435b(C6288e.this.bXv, i2);
                C1111a.m2435b(C6288e.this.bXv, i3);
                C6288e.this.bXv.write(i4);
                C6288e.this.bXv.write(bArr, 0, C1102c.m2413fW(i4).getSize(C6288e.this.bXj) * i3);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        /* renamed from: d */
        public final void mo4323d(C1101b c1101b, int i, int i2) {
            try {
                C6288e.this.bXv.write(ErrorCode.NEEDDOWNLOAD_3);
                C6288e.this.bXv.write(c1101b.bXC);
                C1111a.m2435b(C6288e.this.bXv, i);
                C1111a.m2435b(C6288e.this.bXv, i2);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        /* renamed from: zn */
        public final void mo4324zn() {
            try {
                C6288e.this.bXu.write(this.mTag);
                C1111a.m2435b(C6288e.this.bXu, this.bXw);
                C1111a.m2435b(C6288e.this.bXu, C6288e.this.bXv.size());
                C6288e.this.bXu.write(C6288e.this.bXv.toByteArray());
                C6288e.this.bXv.reset();
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }
    }

    public C6288e(OutputStream outputStream) {
        super(null);
        this.bXu = outputStream;
    }

    /* renamed from: a */
    public final void mo4312a(String str, int i, long j) {
        if (i <= 0 || i >= 1073741823) {
            try {
                throw new IOException("bad idSize: ".concat(String.valueOf(i)));
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        } else {
            this.bXj = i;
            OutputStream outputStream = this.bXu;
            outputStream.write(str.getBytes(Charset.forName("UTF-8")));
            outputStream.write(0);
            C1111a.m2435b(this.bXu, i);
            C1111a.m2432a(this.bXu, j);
        }
    }

    /* renamed from: a */
    public final void mo4311a(C1101b c1101b, String str, int i, long j) {
        try {
            this.bXu.write(1);
            C1111a.m2435b(this.bXu, i);
            C1111a.m2435b(this.bXu, (int) j);
            this.bXu.write(c1101b.bXC);
            this.bXu.write(str.getBytes(Charset.forName("UTF-8")), 0, str.length());
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }

    /* renamed from: a */
    public final void mo4310a(int i, C1101b c1101b, int i2, C1101b c1101b2, int i3, long j) {
        try {
            this.bXu.write(2);
            C1111a.m2435b(this.bXu, i3);
            C1111a.m2435b(this.bXu, (int) j);
            C1111a.m2435b(this.bXu, i);
            this.bXu.write(c1101b.bXC);
            C1111a.m2435b(this.bXu, i2);
            this.bXu.write(c1101b2.bXC);
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }

    /* renamed from: a */
    public final void mo4328a(C1101b c1101b, C1101b c1101b2, C1101b c1101b3, C1101b c1101b4, int i, int i2, int i3, long j) {
        try {
            this.bXu.write(4);
            C1111a.m2435b(this.bXu, i3);
            C1111a.m2435b(this.bXu, (int) j);
            this.bXu.write(c1101b.bXC);
            this.bXu.write(c1101b2.bXC);
            this.bXu.write(c1101b3.bXC);
            this.bXu.write(c1101b4.bXC);
            C1111a.m2435b(this.bXu, i);
            C1111a.m2435b(this.bXu, i2);
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }

    /* renamed from: a */
    public final void mo4327a(int i, int i2, C1101b[] c1101bArr, int i3, long j) {
        try {
            this.bXu.write(5);
            C1111a.m2435b(this.bXu, i3);
            C1111a.m2435b(this.bXu, (int) j);
            C1111a.m2435b(this.bXu, i);
            C1111a.m2435b(this.bXu, i2);
            C1111a.m2435b(this.bXu, c1101bArr.length);
            for (C1101b c1101b : c1101bArr) {
                this.bXu.write(c1101b.bXC);
            }
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }

    /* renamed from: b */
    private C6287a m10316b(int i, int i2, long j) {
        try {
            return new C6287a(i, i2, j);
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }

    /* renamed from: a */
    public final void mo4326a(int i, int i2, long j, byte[] bArr) {
        try {
            this.bXu.write(i);
            C1111a.m2435b(this.bXu, i2);
            C1111a.m2435b(this.bXu, (int) j);
            this.bXu.write(bArr, 0, (int) j);
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }

    /* renamed from: zn */
    public final void mo4314zn() {
        try {
            this.bXu.flush();
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }
}
