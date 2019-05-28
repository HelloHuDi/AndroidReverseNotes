package com.tencent.matrix.resource.c;

import com.tencent.matrix.resource.c.a.b;
import com.tencent.matrix.resource.c.a.c;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class e extends d {
    int bXj = 0;
    final OutputStream bXu;
    final ByteArrayOutputStream bXv = new ByteArrayOutputStream();

    class a extends b {
        private final int bXw;
        private final long bXx;
        private final int mTag;

        a(int i, int i2, long j) {
            super(null);
            this.mTag = i;
            this.bXw = i2;
            this.bXx = j;
        }

        public final void a(int i, b bVar) {
            try {
                e.this.bXv.write(d.MIC_PTU_ZIPAI_LIGHTRED);
                com.tencent.matrix.resource.c.b.a.b(e.this.bXv, i);
                e.this.bXv.write(bVar.bXC);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void b(int i, b bVar) {
            try {
                e.this.bXv.write(i);
                e.this.bXv.write(bVar.bXC);
                if (i == 1) {
                    com.tencent.matrix.resource.c.b.a.b(e.this.bXv, (long) e.this.bXj);
                }
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void a(b bVar, int i, int i2) {
            try {
                e.this.bXv.write(2);
                e.this.bXv.write(bVar.bXC);
                com.tencent.matrix.resource.c.b.a.b(e.this.bXv, i);
                com.tencent.matrix.resource.c.b.a.b(e.this.bXv, i2);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void b(b bVar, int i, int i2) {
            try {
                e.this.bXv.write(3);
                e.this.bXv.write(bVar.bXC);
                com.tencent.matrix.resource.c.b.a.b(e.this.bXv, i);
                com.tencent.matrix.resource.c.b.a.b(e.this.bXv, i2);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void a(b bVar, int i) {
            try {
                e.this.bXv.write(4);
                e.this.bXv.write(bVar.bXC);
                com.tencent.matrix.resource.c.b.a.b(e.this.bXv, i);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void b(b bVar, int i) {
            try {
                e.this.bXv.write(6);
                e.this.bXv.write(bVar.bXC);
                com.tencent.matrix.resource.c.b.a.b(e.this.bXv, i);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void c(b bVar, int i, int i2) {
            try {
                e.this.bXv.write(8);
                e.this.bXv.write(bVar.bXC);
                com.tencent.matrix.resource.c.b.a.b(e.this.bXv, i);
                com.tencent.matrix.resource.c.b.a.b(e.this.bXv, i2);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void a(b bVar, int i, b bVar2, b bVar3, int i2, com.tencent.matrix.resource.c.a.a[] aVarArr, com.tencent.matrix.resource.c.a.a[] aVarArr2) {
            try {
                e.this.bXv.write(32);
                e.this.bXv.write(bVar.bXC);
                com.tencent.matrix.resource.c.b.a.b(e.this.bXv, i);
                e.this.bXv.write(bVar2.bXC);
                e.this.bXv.write(bVar3.bXC);
                com.tencent.matrix.resource.c.b.a.b(e.this.bXv, (long) (e.this.bXj << 2));
                com.tencent.matrix.resource.c.b.a.b(e.this.bXv, i2);
                com.tencent.matrix.resource.c.b.a.a(e.this.bXv, 0);
                com.tencent.matrix.resource.c.b.a.a(e.this.bXv, aVarArr.length);
                for (com.tencent.matrix.resource.c.a.a aVar : aVarArr) {
                    com.tencent.matrix.resource.c.b.a.a(e.this.bXv, aVar.bXA);
                    e.this.bXv.write(aVar.bXz);
                    OutputStream outputStream = e.this.bXv;
                    Object obj = aVar.bXB;
                    if (obj == null) {
                        throw new IllegalArgumentException("value is null.");
                    }
                    if (obj instanceof b) {
                        com.tencent.matrix.resource.c.b.a.a(outputStream, (b) obj);
                    } else if ((obj instanceof Boolean) || Boolean.TYPE.isAssignableFrom(obj.getClass())) {
                        outputStream.write(((Boolean) obj).booleanValue() ? 1 : 0);
                    } else if ((obj instanceof Character) || Character.TYPE.isAssignableFrom(obj.getClass())) {
                        com.tencent.matrix.resource.c.b.a.a(outputStream, ((Character) obj).charValue());
                    } else if ((obj instanceof Float) || Float.TYPE.isAssignableFrom(obj.getClass())) {
                        com.tencent.matrix.resource.c.b.a.b(outputStream, Float.floatToRawIntBits(((Float) obj).floatValue()));
                    } else if ((obj instanceof Double) || Double.TYPE.isAssignableFrom(obj.getClass())) {
                        com.tencent.matrix.resource.c.b.a.a(outputStream, Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                    } else if ((obj instanceof Byte) || Byte.TYPE.isAssignableFrom(obj.getClass())) {
                        outputStream.write(((Byte) obj).byteValue());
                    } else if ((obj instanceof Short) || Short.TYPE.isAssignableFrom(obj.getClass())) {
                        com.tencent.matrix.resource.c.b.a.a(outputStream, ((Short) obj).shortValue());
                    } else if ((obj instanceof Integer) || Integer.TYPE.isAssignableFrom(obj.getClass())) {
                        com.tencent.matrix.resource.c.b.a.b(outputStream, ((Integer) obj).intValue());
                    } else if ((obj instanceof Long) || Long.TYPE.isAssignableFrom(obj.getClass())) {
                        com.tencent.matrix.resource.c.b.a.a(outputStream, ((Long) obj).longValue());
                    } else {
                        throw new IllegalArgumentException("bad value type: " + obj.getClass().getName());
                    }
                }
                com.tencent.matrix.resource.c.b.a.a(e.this.bXv, aVarArr2.length);
                for (com.tencent.matrix.resource.c.a.a aVar2 : aVarArr2) {
                    com.tencent.matrix.resource.c.b.a.a(e.this.bXv, aVar2.bXA);
                    e.this.bXv.write(aVar2.bXz);
                }
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void a(b bVar, int i, b bVar2, byte[] bArr) {
            try {
                e.this.bXv.write(33);
                e.this.bXv.write(bVar.bXC);
                com.tencent.matrix.resource.c.b.a.b(e.this.bXv, i);
                e.this.bXv.write(bVar2.bXC);
                com.tencent.matrix.resource.c.b.a.b(e.this.bXv, bArr.length);
                e.this.bXv.write(bArr);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void a(b bVar, int i, int i2, b bVar2, byte[] bArr) {
            try {
                e.this.bXv.write(34);
                e.this.bXv.write(bVar.bXC);
                com.tencent.matrix.resource.c.b.a.b(e.this.bXv, i);
                com.tencent.matrix.resource.c.b.a.b(e.this.bXv, i2);
                e.this.bXv.write(bVar2.bXC);
                e.this.bXv.write(bArr, 0, e.this.bXj * i2);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void a(int i, b bVar, int i2, int i3, int i4, byte[] bArr) {
            try {
                e.this.bXv.write(i);
                e.this.bXv.write(bVar.bXC);
                com.tencent.matrix.resource.c.b.a.b(e.this.bXv, i2);
                com.tencent.matrix.resource.c.b.a.b(e.this.bXv, i3);
                e.this.bXv.write(i4);
                e.this.bXv.write(bArr, 0, c.fW(i4).getSize(e.this.bXj) * i3);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void d(b bVar, int i, int i2) {
            try {
                e.this.bXv.write(ErrorCode.NEEDDOWNLOAD_3);
                e.this.bXv.write(bVar.bXC);
                com.tencent.matrix.resource.c.b.a.b(e.this.bXv, i);
                com.tencent.matrix.resource.c.b.a.b(e.this.bXv, i2);
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }

        public final void zn() {
            try {
                e.this.bXu.write(this.mTag);
                com.tencent.matrix.resource.c.b.a.b(e.this.bXu, this.bXw);
                com.tencent.matrix.resource.c.b.a.b(e.this.bXu, e.this.bXv.size());
                e.this.bXu.write(e.this.bXv.toByteArray());
                e.this.bXv.reset();
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException(th);
            }
        }
    }

    public e(OutputStream outputStream) {
        super(null);
        this.bXu = outputStream;
    }

    public final void a(String str, int i, long j) {
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
            com.tencent.matrix.resource.c.b.a.b(this.bXu, i);
            com.tencent.matrix.resource.c.b.a.a(this.bXu, j);
        }
    }

    public final void a(b bVar, String str, int i, long j) {
        try {
            this.bXu.write(1);
            com.tencent.matrix.resource.c.b.a.b(this.bXu, i);
            com.tencent.matrix.resource.c.b.a.b(this.bXu, (int) j);
            this.bXu.write(bVar.bXC);
            this.bXu.write(str.getBytes(Charset.forName("UTF-8")), 0, str.length());
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }

    public final void a(int i, b bVar, int i2, b bVar2, int i3, long j) {
        try {
            this.bXu.write(2);
            com.tencent.matrix.resource.c.b.a.b(this.bXu, i3);
            com.tencent.matrix.resource.c.b.a.b(this.bXu, (int) j);
            com.tencent.matrix.resource.c.b.a.b(this.bXu, i);
            this.bXu.write(bVar.bXC);
            com.tencent.matrix.resource.c.b.a.b(this.bXu, i2);
            this.bXu.write(bVar2.bXC);
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }

    public final void a(b bVar, b bVar2, b bVar3, b bVar4, int i, int i2, int i3, long j) {
        try {
            this.bXu.write(4);
            com.tencent.matrix.resource.c.b.a.b(this.bXu, i3);
            com.tencent.matrix.resource.c.b.a.b(this.bXu, (int) j);
            this.bXu.write(bVar.bXC);
            this.bXu.write(bVar2.bXC);
            this.bXu.write(bVar3.bXC);
            this.bXu.write(bVar4.bXC);
            com.tencent.matrix.resource.c.b.a.b(this.bXu, i);
            com.tencent.matrix.resource.c.b.a.b(this.bXu, i2);
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }

    public final void a(int i, int i2, b[] bVarArr, int i3, long j) {
        try {
            this.bXu.write(5);
            com.tencent.matrix.resource.c.b.a.b(this.bXu, i3);
            com.tencent.matrix.resource.c.b.a.b(this.bXu, (int) j);
            com.tencent.matrix.resource.c.b.a.b(this.bXu, i);
            com.tencent.matrix.resource.c.b.a.b(this.bXu, i2);
            com.tencent.matrix.resource.c.b.a.b(this.bXu, bVarArr.length);
            for (b bVar : bVarArr) {
                this.bXu.write(bVar.bXC);
            }
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }

    private a b(int i, int i2, long j) {
        try {
            return new a(i, i2, j);
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }

    public final void a(int i, int i2, long j, byte[] bArr) {
        try {
            this.bXu.write(i);
            com.tencent.matrix.resource.c.b.a.b(this.bXu, i2);
            com.tencent.matrix.resource.c.b.a.b(this.bXu, (int) j);
            this.bXu.write(bArr, 0, (int) j);
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }

    public final void zn() {
        try {
            this.bXu.flush();
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }
}
