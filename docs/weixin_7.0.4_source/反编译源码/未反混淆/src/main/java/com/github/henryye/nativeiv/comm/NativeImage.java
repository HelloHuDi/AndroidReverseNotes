package com.github.henryye.nativeiv.comm;

import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.annotation.Keep;
import com.github.henryye.nativeiv.b.a;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;

@Keep
public class NativeImage implements IBitmap<NativeBitmapStruct> {
    private static final String TAG = "Ni.NativeImage";
    private a factory;
    private NativeImageJni jni;
    private long lastDecodeUsing = -1;
    private NativeBitmapStruct mNativeBitmapStruct = null;

    /* JADX WARNING: Missing block: B:24:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NativeImage(NativeImageJni nativeImageJni, a aVar) {
        int i = 115761;
        AppMethodBeat.i(115761);
        this.jni = nativeImageJni;
        this.factory = aVar;
        synchronized (this) {
            int valueOf;
            try {
                synchronized (aVar) {
                    HashMap hashMap = aVar.aMo;
                    valueOf = Integer.valueOf(hashCode());
                    hashMap.put(valueOf, this);
                }
            } catch (Throwable th) {
                while (true) {
                }
                valueOf = 115761;
            } finally {
                AppMethodBeat.o(
/*
Method generation error in method: com.github.henryye.nativeiv.comm.NativeImage.<init>(com.github.henryye.nativeiv.comm.NativeImageJni, com.github.henryye.nativeiv.comm.a):void, dex: classes7.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0034: INVOKE  (wrap: int
  ?: MERGE  (r2_1 int) = (r2_0 'i' int), (r1_4 'valueOf' int)) com.tencent.matrix.trace.core.AppMethodBeat.o(int):void type: STATIC in method: com.github.henryye.nativeiv.comm.NativeImage.<init>(com.github.henryye.nativeiv.comm.NativeImageJni, com.github.henryye.nativeiv.comm.a):void, dex: classes7.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:205)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:102)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:52)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:300)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:230)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:321)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:259)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:221)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r2_1 int) = (r2_0 'i' int), (r1_4 'valueOf' int) in method: com.github.henryye.nativeiv.comm.NativeImage.<init>(com.github.henryye.nativeiv.comm.NativeImageJni, com.github.henryye.nativeiv.comm.a):void, dex: classes7.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:101)
	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:688)
	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:658)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:340)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 27 more
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:213)
	... 32 more

*/

    @Keep
    public BitmapType getType() {
        return BitmapType.Native;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0090 A:{SYNTHETIC, Splitter:B:46:0x0090} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0041 A:{SYNTHETIC, Splitter:B:24:0x0041} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void decodeInputStream(InputStream inputStream, Config config, c cVar) {
        AppMethodBeat.i(115762);
        if (this.factory == null) {
            AppMethodBeat.o(115762);
        } else {
            int i;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (inputStream == null) {
                com.tencent.magicbrush.a.c.c.w(TAG, "hy: non stream, mark as request clear", new Object[0]);
                recycle();
            }
            ByteBuffer f = a.f(inputStream);
            if (!(config == null || config == Config.ARGB_8888 || config == Config.ARGB_4444 || config == Config.RGB_565)) {
                if (config == Config.ALPHA_8) {
                    i = 2;
                    if (f == null) {
                        try {
                            CommNativeBitmapStruct nativeDecodeNative;
                            NativeImageJni nativeImageJni = this.jni;
                            if (nativeImageJni.mNativeInst != 0) {
                                nativeDecodeNative = nativeImageJni.nativeDecodeNative(nativeImageJni.mNativeInst, f, i);
                            } else {
                                nativeDecodeNative = null;
                            }
                            if (nativeDecodeNative != null) {
                                this.mNativeBitmapStruct = nativeDecodeNative.convertToCommonStruct();
                            } else {
                                com.tencent.magicbrush.a.c.c.e(TAG, "hy: decode failed!!", new Object[0]);
                            }
                            f.clear();
                            this.lastDecodeUsing = SystemClock.elapsedRealtime() - elapsedRealtime;
                            AppMethodBeat.o(115762);
                        } catch (Throwable th) {
                            this.lastDecodeUsing = SystemClock.elapsedRealtime() - elapsedRealtime;
                            AppMethodBeat.o(115762);
                        }
                    } else {
                        com.tencent.magicbrush.a.c.c.w(TAG, "hy: decode error!", new Object[0]);
                        recycle();
                        IOException iOException = new IOException("decode error!");
                        AppMethodBeat.o(115762);
                        throw iOException;
                    }
                }
                i = VERSION.SDK_INT;
            }
            i = 4;
            if (f == null) {
            }
        }
    }

    public void decodeInputStreamRegion(InputStream inputStream, Rect rect, Config config, c cVar) {
        AppMethodBeat.i(115763);
        IOException iOException = new IOException("Stub!");
        AppMethodBeat.o(115763);
        throw iOException;
    }

    public void forceSet(NativeBitmapStruct nativeBitmapStruct) {
        this.mNativeBitmapStruct = nativeBitmapStruct;
    }

    public synchronized com.github.henryye.nativeiv.bitmap.a<Integer> dump() {
        com.github.henryye.nativeiv.bitmap.a aVar;
        AppMethodBeat.i(115764);
        aVar = new com.github.henryye.nativeiv.bitmap.a();
        if (this.mNativeBitmapStruct != null) {
            aVar.width = this.mNativeBitmapStruct.width;
            aVar.height = this.mNativeBitmapStruct.height;
            aVar.aMb = true;
            aVar.aMc = Integer.valueOf(this.mNativeBitmapStruct.glFormat);
            aVar.aMd = this.lastDecodeUsing;
        }
        AppMethodBeat.o(115764);
        return aVar;
    }

    public long getDecodeTime() {
        return this.lastDecodeUsing;
    }

    @Keep
    public NativeBitmapStruct provide() {
        return this.mNativeBitmapStruct;
    }

    @Keep
    public synchronized void recycle() {
        AppMethodBeat.i(115765);
        com.tencent.magicbrush.a.c.c.v(TAG, "hy: recycling %d", Integer.valueOf(hashCode()));
        if (!(this.mNativeBitmapStruct == null || this.mNativeBitmapStruct.ptr == -1)) {
            NativeImageJni nativeImageJni = this.jni;
            long j = this.mNativeBitmapStruct.ptr;
            if (nativeImageJni.mNativeInst != 0) {
                nativeImageJni.nativeRecycleNative(nativeImageJni.mNativeInst, j);
            }
            this.mNativeBitmapStruct = null;
        }
        if (this.factory != null) {
            a aVar = this.factory;
            synchronized (aVar) {
                try {
                    aVar.aMo.remove(Integer.valueOf(hashCode()));
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(115765);
                    }
                }
            }
            this.factory = null;
        }
        AppMethodBeat.o(115765);
    }
}
