package com.tencent.filter;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class m {
    public int handle = -1;
    public String name;

    public static class f extends m {
        float value;

        public f(String str, float f) {
            super(str);
            this.value = f;
        }

        public final void setParams(int i) {
            AppMethodBeat.i(86399);
            if (this.handle < 0) {
                AppMethodBeat.o(86399);
                return;
            }
            GLES20.glUniform1f(this.handle, this.value);
            com.tencent.view.g.checkGlError("FloatParam setParams");
            AppMethodBeat.o(86399);
        }

        public final String toString() {
            AppMethodBeat.i(86400);
            String str = this.name + "=" + this.value;
            AppMethodBeat.o(86400);
            return str;
        }
    }

    public static class g extends m {
        float[] bMQ;

        public g(String str, float[] fArr) {
            super(str);
            AppMethodBeat.i(86401);
            this.bMQ = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.bMQ[i] = fArr[i];
            }
            AppMethodBeat.o(86401);
        }

        public final String toString() {
            AppMethodBeat.i(86402);
            String str = this.name + "=" + this.bMQ.toString();
            AppMethodBeat.o(86402);
            return str;
        }

        public final void setParams(int i) {
            AppMethodBeat.i(86403);
            if (this.handle < 0) {
                AppMethodBeat.o(86403);
                return;
            }
            switch (this.bMQ.length) {
                case 1:
                    GLES20.glUniform1f(this.handle, this.bMQ[0]);
                    break;
                case 2:
                    GLES20.glUniform2fv(this.handle, 1, this.bMQ, 0);
                    break;
                case 3:
                    GLES20.glUniform3fv(this.handle, 1, this.bMQ, 0);
                    break;
                case 4:
                    GLES20.glUniform4fv(this.handle, 1, this.bMQ, 0);
                    break;
                case 9:
                    GLES20.glUniformMatrix3fv(this.handle, 1, false, this.bMQ, 0);
                    break;
                case 16:
                    GLES20.glUniformMatrix4fv(this.handle, 1, false, this.bMQ, 0);
                    break;
                default:
                    GLES20.glUniform1fv(this.handle, this.bMQ.length, this.bMQ, 0);
                    break;
            }
            com.tencent.view.g.checkGlError("FloatsParam setParams");
            AppMethodBeat.o(86403);
        }
    }

    public static class i extends m {
        int value;

        public final String toString() {
            AppMethodBeat.i(86407);
            String str = this.name + "=" + this.value;
            AppMethodBeat.o(86407);
            return str;
        }

        public i(String str, int i) {
            super(str);
            this.value = i;
        }

        public final void setParams(int i) {
            AppMethodBeat.i(86408);
            if (this.handle < 0) {
                AppMethodBeat.o(86408);
                return;
            }
            GLES20.glUniform1i(this.handle, this.value);
            com.tencent.view.g.checkGlError("IntParam setParams");
            AppMethodBeat.o(86408);
        }
    }

    public static class o extends n {
        String bMV = null;
        double bMW = 0.0d;
        int bMX = 0;

        public o(String str, String str2, double d) {
            super(str, 0, 33986);
            this.bMV = str2;
            this.bMW = d;
        }

        public o(String str, String str2, int i) {
            super(str, 0, i);
            this.bMV = str2;
        }

        public o(String str, String str2, int i, byte b) {
            super(str, 0, 33986);
            this.bMV = str2;
            this.bMX = i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0100  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x009e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void initialParams(int i) {
            AppMethodBeat.i(86422);
            super.initialParams(i);
            if (this.bMV == null) {
                AppMethodBeat.o(86422);
                return;
            }
            Bitmap bitmap;
            GLES20.glActiveTexture(this.bMU);
            com.tencent.util.f.dSJ().F(this.texture);
            GLES20.glBindTexture(3553, this.texture[0]);
            Bitmap vt = com.tencent.view.b.vt(this.bMV);
            Bitmap bitmap2 = null;
            if (vt == null) {
                com.tencent.util.i.m("Param", "lastBitmap is null " + this.bMV);
                bitmap = vt;
            } else if (this.bMW > 0.0d) {
                if (this.bMW < 1.0d) {
                    bitmap2 = com.tencent.util.b.g(vt, (int) (((double) vt.getHeight()) * this.bMW), vt.getHeight());
                } else {
                    bitmap2 = com.tencent.util.b.g(vt, vt.getWidth(), (int) (((double) vt.getWidth()) / this.bMW));
                }
                vt.recycle();
                bitmap = null;
            } else {
                bitmap2 = vt;
                bitmap = vt;
            }
            if (this.bMX == 1) {
                Matrix matrix = new Matrix();
                matrix.setValues(new float[]{1.0f, 0.0f, 0.0f, 0.0f, -1.0f, (float) bitmap.getHeight(), 0.0f, 0.0f, 1.0f});
                bitmap2 = com.tencent.util.b.a(bitmap, bitmap.getWidth(), bitmap.getHeight(), matrix);
                if (bitmap2 != null) {
                    bitmap.recycle();
                }
                if (bitmap == null) {
                    GLUtils.texImage2D(3553, 0, bitmap, 0);
                    bitmap.recycle();
                } else {
                    com.tencent.util.i.m("Param", "bitmap is null");
                }
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
                AppMethodBeat.o(86422);
            }
            bitmap = bitmap2;
            if (bitmap == null) {
            }
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            AppMethodBeat.o(86422);
        }

        public final void clear() {
            AppMethodBeat.i(86423);
            GLES20.glActiveTexture(this.bMU);
            com.tencent.util.f.dSJ().G(this.texture);
            super.clear();
            AppMethodBeat.o(86423);
        }
    }

    public static class h extends m {
        int[] value = new int[0];

        public h(String str) {
            super(str);
            AppMethodBeat.i(86404);
            AppMethodBeat.o(86404);
        }

        public final void setParams(int i) {
            AppMethodBeat.i(86405);
            if (this.handle < 0) {
                AppMethodBeat.o(86405);
                return;
            }
            GLES20.glUniform1iv(this.handle, this.value.length, this.value, 0);
            com.tencent.view.g.checkGlError("FloatParam setParams");
            AppMethodBeat.o(86405);
        }

        public final String toString() {
            AppMethodBeat.i(86406);
            String str = this.name + "=" + this.value;
            AppMethodBeat.o(86406);
            return str;
        }
    }

    public static class a extends m {
        float[] bMQ;

        public a(String str, float[] fArr) {
            super(str);
            AppMethodBeat.i(86387);
            this.bMQ = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.bMQ[i] = fArr[i];
            }
            AppMethodBeat.o(86387);
        }

        public final void setParams(int i) {
            AppMethodBeat.i(86388);
            if (this.handle < 0) {
                AppMethodBeat.o(86388);
                return;
            }
            GLES20.glUniform1fv(this.handle, this.bMQ.length, this.bMQ, 0);
            com.tencent.view.g.checkGlError("FloatParam setParams");
            AppMethodBeat.o(86388);
        }

        public final String toString() {
            AppMethodBeat.i(86389);
            String str = this.name + "=" + this.bMQ;
            AppMethodBeat.o(86389);
            return str;
        }
    }

    public static class j extends m {
        private final float[] bMR;

        public j(String str, float[] fArr) {
            super(str);
            this.bMR = fArr;
        }

        public final void setParams(int i) {
            AppMethodBeat.i(86409);
            GLES20.glUniformMatrix4fv(this.handle, 1, false, this.bMR, 0);
            AppMethodBeat.o(86409);
        }
    }

    public static class n extends m {
        int bMU;
        int[] texture = new int[]{0};

        public n(String str, int i, int i2) {
            super(str);
            AppMethodBeat.i(86419);
            this.bMU = i2;
            this.texture[0] = i;
            AppMethodBeat.o(86419);
        }

        public void clear() {
            AppMethodBeat.i(86420);
            super.clear();
            this.texture[0] = 0;
            AppMethodBeat.o(86420);
        }

        public void setParams(int i) {
            int i2 = 0;
            AppMethodBeat.i(86421);
            if (this.handle < 0 || this.texture[0] == 0) {
                AppMethodBeat.o(86421);
                return;
            }
            GLES20.glActiveTexture(this.bMU);
            GLES20.glBindTexture(3553, this.texture[0]);
            switch (this.bMU) {
                case 33985:
                    i2 = 1;
                    break;
                case 33986:
                    i2 = 2;
                    break;
                case 33987:
                    i2 = 3;
                    break;
                case 33988:
                    i2 = 4;
                    break;
                case 33989:
                    i2 = 5;
                    break;
                case 33990:
                    i2 = 6;
                    break;
                case 33991:
                    i2 = 7;
                    break;
            }
            GLES20.glUniform1i(this.handle, i2);
            com.tencent.view.g.checkGlError("TextureParam setParams");
            AppMethodBeat.o(86421);
        }
    }

    public static class k extends n {
        Bitmap bMS;
        boolean bMT = false;

        public k(String str, Bitmap bitmap, int i, boolean z) {
            super(str, 0, i);
            this.bMT = z;
            this.bMS = bitmap;
        }

        public final void clear() {
            AppMethodBeat.i(86410);
            GLES20.glActiveTexture(this.bMU);
            com.tencent.util.f.dSJ().G(this.texture);
            super.clear();
            if (this.bMT && this.bMS != null) {
                this.bMS.recycle();
                this.bMS = null;
            }
            AppMethodBeat.o(86410);
        }

        public final void initialParams(int i) {
            AppMethodBeat.i(86411);
            super.initialParams(i);
            if (this.bMS == null || this.bMS.isRecycled()) {
                AppMethodBeat.o(86411);
                return;
            }
            GLES20.glActiveTexture(this.bMU);
            com.tencent.util.f.dSJ().F(this.texture);
            GLES20.glBindTexture(3553, this.texture[0]);
            GLUtils.texImage2D(3553, 0, this.bMS, 0);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            AppMethodBeat.o(86411);
        }

        public final void m(Bitmap bitmap) {
            AppMethodBeat.i(86412);
            if (!(!this.bMT || this.bMS == null || this.bMS.isRecycled())) {
                this.bMS.recycle();
            }
            this.bMS = bitmap;
            if (this.bMS == null || this.bMS.isRecycled()) {
                AppMethodBeat.o(86412);
                return;
            }
            GLES20.glActiveTexture(this.bMU);
            GLES20.glBindTexture(3553, this.texture[0]);
            GLUtils.texImage2D(3553, 0, this.bMS, 0);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            AppMethodBeat.o(86412);
        }
    }

    public static class b extends m {
        float x;
        float y;

        public b(String str, float f, float f2) {
            super(str);
            this.x = f;
            this.y = f2;
        }

        public final void setParams(int i) {
            AppMethodBeat.i(86390);
            if (this.handle < 0) {
                AppMethodBeat.o(86390);
                return;
            }
            GLES20.glUniform2f(this.handle, this.x, this.y);
            com.tencent.view.g.checkGlError("Float2fParam setParams");
            AppMethodBeat.o(86390);
        }

        public final String toString() {
            AppMethodBeat.i(86391);
            String str = this.name + "=" + this.x + ", " + this.y;
            AppMethodBeat.o(86391);
            return str;
        }
    }

    public static class d extends m {
        float x;
        float y;
        float z;

        public d(String str, float f, float f2, float f3) {
            super(str);
            this.x = f;
            this.y = f2;
            this.z = f3;
        }

        public final void setParams(int i) {
            AppMethodBeat.i(86395);
            if (this.handle < 0) {
                AppMethodBeat.o(86395);
                return;
            }
            GLES20.glUniform3f(this.handle, this.x, this.y, this.z);
            com.tencent.view.g.checkGlError("Float3fParam setParams");
            AppMethodBeat.o(86395);
        }

        public final String toString() {
            AppMethodBeat.i(86396);
            String str = this.name + "=" + this.x + ", " + this.y + ", " + this.z;
            AppMethodBeat.o(86396);
            return str;
        }
    }

    public static class m extends n {
        int[] value;

        public m(String str, int[] iArr, int i) {
            super(str, 0, i);
            this.value = iArr;
        }

        public final void clear() {
            AppMethodBeat.i(86417);
            GLES20.glActiveTexture(this.bMU);
            com.tencent.util.f.dSJ().G(this.texture);
            super.clear();
            AppMethodBeat.o(86417);
        }

        public final void initialParams(int i) {
            AppMethodBeat.i(86418);
            super.initialParams(i);
            if (this.value == null) {
                AppMethodBeat.o(86418);
                return;
            }
            GLES20.glActiveTexture(this.bMU);
            com.tencent.util.f.dSJ().F(this.texture);
            GLSLRender.nativeTextCure(this.value, this.texture[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            AppMethodBeat.o(86418);
        }
    }

    public static class c extends m {
        float[] bMQ;

        public c(String str, float[] fArr) {
            super(str);
            AppMethodBeat.i(86392);
            this.bMQ = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.bMQ[i] = fArr[i];
            }
            AppMethodBeat.o(86392);
        }

        public final void setParams(int i) {
            AppMethodBeat.i(86393);
            if (this.handle < 0) {
                AppMethodBeat.o(86393);
                return;
            }
            GLES20.glUniform2fv(this.handle, this.bMQ.length / 2, this.bMQ, 0);
            com.tencent.view.g.checkGlError("Float2sParam setParams");
            AppMethodBeat.o(86393);
        }

        public final String toString() {
            AppMethodBeat.i(86394);
            String str = this.name + "=" + this.bMQ;
            AppMethodBeat.o(86394);
            return str;
        }
    }

    public static class e extends m {
        float w;
        float x;
        float y;
        float z;

        public e(String str, float f, float f2, float f3, float f4) {
            super(str);
            this.x = f;
            this.y = f2;
            this.z = f3;
            this.w = f4;
        }

        public final void setParams(int i) {
            AppMethodBeat.i(86397);
            if (this.handle < 0) {
                AppMethodBeat.o(86397);
                return;
            }
            GLES20.glUniform4f(this.handle, this.x, this.y, this.z, this.w);
            com.tencent.view.g.checkGlError("Float4fParam setParams");
            AppMethodBeat.o(86397);
        }

        public final String toString() {
            AppMethodBeat.i(86398);
            String str = this.name + "=" + this.x + ", " + this.y + ", " + this.z + ", " + this.w;
            AppMethodBeat.o(86398);
            return str;
        }
    }

    public static class l extends n {
        public Bitmap bMS = null;
        public boolean update;

        public l(String str) {
            boolean z = false;
            super(str, 0, 33987);
            AppMethodBeat.i(86413);
            if (!(this.bMS == null || this.bMS.isRecycled())) {
                z = true;
            }
            this.update = z;
            AppMethodBeat.o(86413);
        }

        public final void clear() {
            AppMethodBeat.i(86414);
            GLES20.glActiveTexture(this.bMU);
            com.tencent.util.f.dSJ().G(this.texture);
            super.clear();
            AppMethodBeat.o(86414);
        }

        public final void initialParams(int i) {
            AppMethodBeat.i(86415);
            super.initialParams(i);
            GLES20.glActiveTexture(this.bMU);
            com.tencent.util.f.dSJ().F(this.texture);
            AppMethodBeat.o(86415);
        }

        public final void setParams(int i) {
            AppMethodBeat.i(86416);
            if (this.update) {
                GLES20.glActiveTexture(this.bMU);
                GLES20.glBindTexture(3553, this.texture[0]);
                try {
                    GLUtils.texImage2D(3553, 0, this.bMS, 0);
                } catch (IllegalArgumentException e) {
                }
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
            }
            super.setParams(i);
            this.update = false;
            AppMethodBeat.o(86416);
        }
    }

    public abstract void setParams(int i);

    public m(String str) {
        this.name = str;
    }

    public void initialParams(int i) {
        this.handle = GLES20.glGetUniformLocation(i, this.name);
    }

    public void clear() {
        this.handle = -1;
    }

    public String toString() {
        return this.name;
    }
}
