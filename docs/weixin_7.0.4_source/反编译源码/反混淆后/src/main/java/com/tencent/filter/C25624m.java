package com.tencent.filter;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.util.C16371i;
import com.tencent.util.C36569b;
import com.tencent.util.C36572f;
import com.tencent.view.C41106g;
import com.tencent.view.C44569b;

/* renamed from: com.tencent.filter.m */
public abstract class C25624m {
    public int handle = -1;
    public String name;

    /* renamed from: com.tencent.filter.m$f */
    public static class C0933f extends C25624m {
        float value;

        public C0933f(String str, float f) {
            super(str);
            this.value = f;
        }

        public final void setParams(int i) {
            AppMethodBeat.m2504i(86399);
            if (this.handle < 0) {
                AppMethodBeat.m2505o(86399);
                return;
            }
            GLES20.glUniform1f(this.handle, this.value);
            C41106g.checkGlError("FloatParam setParams");
            AppMethodBeat.m2505o(86399);
        }

        public final String toString() {
            AppMethodBeat.m2504i(86400);
            String str = this.name + "=" + this.value;
            AppMethodBeat.m2505o(86400);
            return str;
        }
    }

    /* renamed from: com.tencent.filter.m$g */
    public static class C0934g extends C25624m {
        float[] bMQ;

        public C0934g(String str, float[] fArr) {
            super(str);
            AppMethodBeat.m2504i(86401);
            this.bMQ = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.bMQ[i] = fArr[i];
            }
            AppMethodBeat.m2505o(86401);
        }

        public final String toString() {
            AppMethodBeat.m2504i(86402);
            String str = this.name + "=" + this.bMQ.toString();
            AppMethodBeat.m2505o(86402);
            return str;
        }

        public final void setParams(int i) {
            AppMethodBeat.m2504i(86403);
            if (this.handle < 0) {
                AppMethodBeat.m2505o(86403);
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
            C41106g.checkGlError("FloatsParam setParams");
            AppMethodBeat.m2505o(86403);
        }
    }

    /* renamed from: com.tencent.filter.m$i */
    public static class C0935i extends C25624m {
        int value;

        public final String toString() {
            AppMethodBeat.m2504i(86407);
            String str = this.name + "=" + this.value;
            AppMethodBeat.m2505o(86407);
            return str;
        }

        public C0935i(String str, int i) {
            super(str);
            this.value = i;
        }

        public final void setParams(int i) {
            AppMethodBeat.m2504i(86408);
            if (this.handle < 0) {
                AppMethodBeat.m2505o(86408);
                return;
            }
            GLES20.glUniform1i(this.handle, this.value);
            C41106g.checkGlError("IntParam setParams");
            AppMethodBeat.m2505o(86408);
        }
    }

    /* renamed from: com.tencent.filter.m$o */
    public static class C0936o extends C25627n {
        String bMV = null;
        double bMW = 0.0d;
        int bMX = 0;

        public C0936o(String str, String str2, double d) {
            super(str, 0, 33986);
            this.bMV = str2;
            this.bMW = d;
        }

        public C0936o(String str, String str2, int i) {
            super(str, 0, i);
            this.bMV = str2;
        }

        public C0936o(String str, String str2, int i, byte b) {
            super(str, 0, 33986);
            this.bMV = str2;
            this.bMX = i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0100  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x009e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void initialParams(int i) {
            AppMethodBeat.m2504i(86422);
            super.initialParams(i);
            if (this.bMV == null) {
                AppMethodBeat.m2505o(86422);
                return;
            }
            Bitmap bitmap;
            GLES20.glActiveTexture(this.bMU);
            C36572f.dSJ().mo58338F(this.texture);
            GLES20.glBindTexture(3553, this.texture[0]);
            Bitmap vt = C44569b.m80951vt(this.bMV);
            Bitmap bitmap2 = null;
            if (vt == null) {
                C16371i.m25188m("Param", "lastBitmap is null " + this.bMV);
                bitmap = vt;
            } else if (this.bMW > 0.0d) {
                if (this.bMW < 1.0d) {
                    bitmap2 = C36569b.m60593g(vt, (int) (((double) vt.getHeight()) * this.bMW), vt.getHeight());
                } else {
                    bitmap2 = C36569b.m60593g(vt, vt.getWidth(), (int) (((double) vt.getWidth()) / this.bMW));
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
                bitmap2 = C36569b.m60592a(bitmap, bitmap.getWidth(), bitmap.getHeight(), matrix);
                if (bitmap2 != null) {
                    bitmap.recycle();
                }
                if (bitmap == null) {
                    GLUtils.texImage2D(3553, 0, bitmap, 0);
                    bitmap.recycle();
                } else {
                    C16371i.m25188m("Param", "bitmap is null");
                }
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
                AppMethodBeat.m2505o(86422);
            }
            bitmap = bitmap2;
            if (bitmap == null) {
            }
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            AppMethodBeat.m2505o(86422);
        }

        public final void clear() {
            AppMethodBeat.m2504i(86423);
            GLES20.glActiveTexture(this.bMU);
            C36572f.dSJ().mo58339G(this.texture);
            super.clear();
            AppMethodBeat.m2505o(86423);
        }
    }

    /* renamed from: com.tencent.filter.m$h */
    public static class C8786h extends C25624m {
        int[] value = new int[0];

        public C8786h(String str) {
            super(str);
            AppMethodBeat.m2504i(86404);
            AppMethodBeat.m2505o(86404);
        }

        public final void setParams(int i) {
            AppMethodBeat.m2504i(86405);
            if (this.handle < 0) {
                AppMethodBeat.m2505o(86405);
                return;
            }
            GLES20.glUniform1iv(this.handle, this.value.length, this.value, 0);
            C41106g.checkGlError("FloatParam setParams");
            AppMethodBeat.m2505o(86405);
        }

        public final String toString() {
            AppMethodBeat.m2504i(86406);
            String str = this.name + "=" + this.value;
            AppMethodBeat.m2505o(86406);
            return str;
        }
    }

    /* renamed from: com.tencent.filter.m$a */
    public static class C25625a extends C25624m {
        float[] bMQ;

        public C25625a(String str, float[] fArr) {
            super(str);
            AppMethodBeat.m2504i(86387);
            this.bMQ = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.bMQ[i] = fArr[i];
            }
            AppMethodBeat.m2505o(86387);
        }

        public final void setParams(int i) {
            AppMethodBeat.m2504i(86388);
            if (this.handle < 0) {
                AppMethodBeat.m2505o(86388);
                return;
            }
            GLES20.glUniform1fv(this.handle, this.bMQ.length, this.bMQ, 0);
            C41106g.checkGlError("FloatParam setParams");
            AppMethodBeat.m2505o(86388);
        }

        public final String toString() {
            AppMethodBeat.m2504i(86389);
            String str = this.name + "=" + this.bMQ;
            AppMethodBeat.m2505o(86389);
            return str;
        }
    }

    /* renamed from: com.tencent.filter.m$j */
    public static class C25626j extends C25624m {
        private final float[] bMR;

        public C25626j(String str, float[] fArr) {
            super(str);
            this.bMR = fArr;
        }

        public final void setParams(int i) {
            AppMethodBeat.m2504i(86409);
            GLES20.glUniformMatrix4fv(this.handle, 1, false, this.bMR, 0);
            AppMethodBeat.m2505o(86409);
        }
    }

    /* renamed from: com.tencent.filter.m$n */
    public static class C25627n extends C25624m {
        int bMU;
        int[] texture = new int[]{0};

        public C25627n(String str, int i, int i2) {
            super(str);
            AppMethodBeat.m2504i(86419);
            this.bMU = i2;
            this.texture[0] = i;
            AppMethodBeat.m2505o(86419);
        }

        public void clear() {
            AppMethodBeat.m2504i(86420);
            super.clear();
            this.texture[0] = 0;
            AppMethodBeat.m2505o(86420);
        }

        public void setParams(int i) {
            int i2 = 0;
            AppMethodBeat.m2504i(86421);
            if (this.handle < 0 || this.texture[0] == 0) {
                AppMethodBeat.m2505o(86421);
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
            C41106g.checkGlError("TextureParam setParams");
            AppMethodBeat.m2505o(86421);
        }
    }

    /* renamed from: com.tencent.filter.m$k */
    public static class C25628k extends C25627n {
        Bitmap bMS;
        boolean bMT = false;

        public C25628k(String str, Bitmap bitmap, int i, boolean z) {
            super(str, 0, i);
            this.bMT = z;
            this.bMS = bitmap;
        }

        public final void clear() {
            AppMethodBeat.m2504i(86410);
            GLES20.glActiveTexture(this.bMU);
            C36572f.dSJ().mo58339G(this.texture);
            super.clear();
            if (this.bMT && this.bMS != null) {
                this.bMS.recycle();
                this.bMS = null;
            }
            AppMethodBeat.m2505o(86410);
        }

        public final void initialParams(int i) {
            AppMethodBeat.m2504i(86411);
            super.initialParams(i);
            if (this.bMS == null || this.bMS.isRecycled()) {
                AppMethodBeat.m2505o(86411);
                return;
            }
            GLES20.glActiveTexture(this.bMU);
            C36572f.dSJ().mo58338F(this.texture);
            GLES20.glBindTexture(3553, this.texture[0]);
            GLUtils.texImage2D(3553, 0, this.bMS, 0);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            AppMethodBeat.m2505o(86411);
        }

        /* renamed from: m */
        public final void mo43360m(Bitmap bitmap) {
            AppMethodBeat.m2504i(86412);
            if (!(!this.bMT || this.bMS == null || this.bMS.isRecycled())) {
                this.bMS.recycle();
            }
            this.bMS = bitmap;
            if (this.bMS == null || this.bMS.isRecycled()) {
                AppMethodBeat.m2505o(86412);
                return;
            }
            GLES20.glActiveTexture(this.bMU);
            GLES20.glBindTexture(3553, this.texture[0]);
            GLUtils.texImage2D(3553, 0, this.bMS, 0);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            AppMethodBeat.m2505o(86412);
        }
    }

    /* renamed from: com.tencent.filter.m$b */
    public static class C25629b extends C25624m {
        /* renamed from: x */
        float f5227x;
        /* renamed from: y */
        float f5228y;

        public C25629b(String str, float f, float f2) {
            super(str);
            this.f5227x = f;
            this.f5228y = f2;
        }

        public final void setParams(int i) {
            AppMethodBeat.m2504i(86390);
            if (this.handle < 0) {
                AppMethodBeat.m2505o(86390);
                return;
            }
            GLES20.glUniform2f(this.handle, this.f5227x, this.f5228y);
            C41106g.checkGlError("Float2fParam setParams");
            AppMethodBeat.m2505o(86390);
        }

        public final String toString() {
            AppMethodBeat.m2504i(86391);
            String str = this.name + "=" + this.f5227x + ", " + this.f5228y;
            AppMethodBeat.m2505o(86391);
            return str;
        }
    }

    /* renamed from: com.tencent.filter.m$d */
    public static class C25630d extends C25624m {
        /* renamed from: x */
        float f5229x;
        /* renamed from: y */
        float f5230y;
        /* renamed from: z */
        float f5231z;

        public C25630d(String str, float f, float f2, float f3) {
            super(str);
            this.f5229x = f;
            this.f5230y = f2;
            this.f5231z = f3;
        }

        public final void setParams(int i) {
            AppMethodBeat.m2504i(86395);
            if (this.handle < 0) {
                AppMethodBeat.m2505o(86395);
                return;
            }
            GLES20.glUniform3f(this.handle, this.f5229x, this.f5230y, this.f5231z);
            C41106g.checkGlError("Float3fParam setParams");
            AppMethodBeat.m2505o(86395);
        }

        public final String toString() {
            AppMethodBeat.m2504i(86396);
            String str = this.name + "=" + this.f5229x + ", " + this.f5230y + ", " + this.f5231z;
            AppMethodBeat.m2505o(86396);
            return str;
        }
    }

    /* renamed from: com.tencent.filter.m$m */
    public static class C25631m extends C25627n {
        int[] value;

        public C25631m(String str, int[] iArr, int i) {
            super(str, 0, i);
            this.value = iArr;
        }

        public final void clear() {
            AppMethodBeat.m2504i(86417);
            GLES20.glActiveTexture(this.bMU);
            C36572f.dSJ().mo58339G(this.texture);
            super.clear();
            AppMethodBeat.m2505o(86417);
        }

        public final void initialParams(int i) {
            AppMethodBeat.m2504i(86418);
            super.initialParams(i);
            if (this.value == null) {
                AppMethodBeat.m2505o(86418);
                return;
            }
            GLES20.glActiveTexture(this.bMU);
            C36572f.dSJ().mo58338F(this.texture);
            GLSLRender.nativeTextCure(this.value, this.texture[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            AppMethodBeat.m2505o(86418);
        }
    }

    /* renamed from: com.tencent.filter.m$c */
    public static class C25632c extends C25624m {
        float[] bMQ;

        public C25632c(String str, float[] fArr) {
            super(str);
            AppMethodBeat.m2504i(86392);
            this.bMQ = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.bMQ[i] = fArr[i];
            }
            AppMethodBeat.m2505o(86392);
        }

        public final void setParams(int i) {
            AppMethodBeat.m2504i(86393);
            if (this.handle < 0) {
                AppMethodBeat.m2505o(86393);
                return;
            }
            GLES20.glUniform2fv(this.handle, this.bMQ.length / 2, this.bMQ, 0);
            C41106g.checkGlError("Float2sParam setParams");
            AppMethodBeat.m2505o(86393);
        }

        public final String toString() {
            AppMethodBeat.m2504i(86394);
            String str = this.name + "=" + this.bMQ;
            AppMethodBeat.m2505o(86394);
            return str;
        }
    }

    /* renamed from: com.tencent.filter.m$e */
    public static class C25633e extends C25624m {
        /* renamed from: w */
        float f5232w;
        /* renamed from: x */
        float f5233x;
        /* renamed from: y */
        float f5234y;
        /* renamed from: z */
        float f5235z;

        public C25633e(String str, float f, float f2, float f3, float f4) {
            super(str);
            this.f5233x = f;
            this.f5234y = f2;
            this.f5235z = f3;
            this.f5232w = f4;
        }

        public final void setParams(int i) {
            AppMethodBeat.m2504i(86397);
            if (this.handle < 0) {
                AppMethodBeat.m2505o(86397);
                return;
            }
            GLES20.glUniform4f(this.handle, this.f5233x, this.f5234y, this.f5235z, this.f5232w);
            C41106g.checkGlError("Float4fParam setParams");
            AppMethodBeat.m2505o(86397);
        }

        public final String toString() {
            AppMethodBeat.m2504i(86398);
            String str = this.name + "=" + this.f5233x + ", " + this.f5234y + ", " + this.f5235z + ", " + this.f5232w;
            AppMethodBeat.m2505o(86398);
            return str;
        }
    }

    /* renamed from: com.tencent.filter.m$l */
    public static class C25634l extends C25627n {
        public Bitmap bMS = null;
        public boolean update;

        public C25634l(String str) {
            boolean z = false;
            super(str, 0, 33987);
            AppMethodBeat.m2504i(86413);
            if (!(this.bMS == null || this.bMS.isRecycled())) {
                z = true;
            }
            this.update = z;
            AppMethodBeat.m2505o(86413);
        }

        public final void clear() {
            AppMethodBeat.m2504i(86414);
            GLES20.glActiveTexture(this.bMU);
            C36572f.dSJ().mo58339G(this.texture);
            super.clear();
            AppMethodBeat.m2505o(86414);
        }

        public final void initialParams(int i) {
            AppMethodBeat.m2504i(86415);
            super.initialParams(i);
            GLES20.glActiveTexture(this.bMU);
            C36572f.dSJ().mo58338F(this.texture);
            AppMethodBeat.m2505o(86415);
        }

        public final void setParams(int i) {
            AppMethodBeat.m2504i(86416);
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
            AppMethodBeat.m2505o(86416);
        }
    }

    public abstract void setParams(int i);

    public C25624m(String str) {
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
