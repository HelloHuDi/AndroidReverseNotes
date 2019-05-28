package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzabm {
    private static final Logger logger = Logger.getLogger(zzabm.class.getName());
    private static final Class<?> zzbqv = zzyv.zzsw();
    private static final Unsafe zzbtj = zzur();
    private static final boolean zzbun = zzk(Long.TYPE);
    private static final boolean zzbuo = zzk(Integer.TYPE);
    private static final zzd zzbup;
    private static final boolean zzbuq = zzut();
    private static final boolean zzbur = zzus();
    private static final long zzbus = ((long) zzi(byte[].class));
    private static final long zzbut = ((long) zzi(boolean[].class));
    private static final long zzbuu = ((long) zzj(boolean[].class));
    private static final long zzbuv = ((long) zzi(int[].class));
    private static final long zzbuw = ((long) zzj(int[].class));
    private static final long zzbux = ((long) zzi(long[].class));
    private static final long zzbuy = ((long) zzj(long[].class));
    private static final long zzbuz = ((long) zzi(float[].class));
    private static final long zzbva = ((long) zzj(float[].class));
    private static final long zzbvb = ((long) zzi(double[].class));
    private static final long zzbvc = ((long) zzj(double[].class));
    private static final long zzbvd = ((long) zzi(Object[].class));
    private static final long zzbve = ((long) zzj(Object[].class));
    private static final long zzbvf = zza(zzuu());
    private static final long zzbvg;
    private static final boolean zzbvh = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    static abstract class zzd {
        Unsafe zzbvi;

        zzd(Unsafe unsafe) {
            this.zzbvi = unsafe;
        }
    }

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }
    }

    static {
        Field field = null;
        AppMethodBeat.m2504i(3424);
        zzd zzb = zzbtj == null ? null : zzyv.zzsv() ? zzbun ? new zzb(zzbtj) : zzbuo ? new zza(zzbtj) : null : new zzc(zzbtj);
        zzbup = zzb;
        Field zza = zza(String.class, "value");
        if (zza != null && zza.getType() == char[].class) {
            field = zza;
        }
        zzbvg = zza(field);
        AppMethodBeat.m2505o(3424);
    }

    private zzabm() {
    }

    private static long zza(Field field) {
        AppMethodBeat.m2504i(3422);
        if (field == null || zzbup == null) {
            AppMethodBeat.m2505o(3422);
            return -1;
        }
        long objectFieldOffset = zzbup.zzbvi.objectFieldOffset(field);
        AppMethodBeat.m2505o(3422);
        return objectFieldOffset;
    }

    private static Field zza(Class<?> cls, String str) {
        Field declaredField;
        AppMethodBeat.m2504i(3423);
        try {
            declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
        } catch (Throwable th) {
            declaredField = null;
        }
        AppMethodBeat.m2505o(3423);
        return declaredField;
    }

    private static int zzi(Class<?> cls) {
        AppMethodBeat.m2504i(3415);
        if (zzbur) {
            int arrayBaseOffset = zzbup.zzbvi.arrayBaseOffset(cls);
            AppMethodBeat.m2505o(3415);
            return arrayBaseOffset;
        }
        AppMethodBeat.m2505o(3415);
        return -1;
    }

    private static int zzj(Class<?> cls) {
        AppMethodBeat.m2504i(3416);
        if (zzbur) {
            int arrayIndexScale = zzbup.zzbvi.arrayIndexScale(cls);
            AppMethodBeat.m2505o(3416);
            return arrayIndexScale;
        }
        AppMethodBeat.m2505o(3416);
        return -1;
    }

    private static boolean zzk(Class<?> cls) {
        AppMethodBeat.m2504i(3420);
        if (zzyv.zzsv()) {
            try {
                Class cls2 = zzbqv;
                cls2.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
                cls2.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
                cls2.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
                cls2.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
                cls2.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
                cls2.getMethod("peekByte", new Class[]{cls});
                cls2.getMethod("pokeByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
                cls2.getMethod("peekByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
                AppMethodBeat.m2505o(3420);
                return true;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(3420);
                return false;
            }
        }
        AppMethodBeat.m2505o(3420);
        return false;
    }

    static Unsafe zzur() {
        Unsafe unsafe;
        AppMethodBeat.m2504i(3417);
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new zzabn());
        } catch (Throwable th) {
            unsafe = null;
        }
        AppMethodBeat.m2505o(3417);
        return unsafe;
    }

    private static boolean zzus() {
        AppMethodBeat.m2504i(3418);
        if (zzbtj == null) {
            AppMethodBeat.m2505o(3418);
            return false;
        }
        try {
            Class cls = zzbtj.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (zzyv.zzsv()) {
                AppMethodBeat.m2505o(3418);
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            AppMethodBeat.m2505o(3418);
            return true;
        } catch (Throwable th) {
            String valueOf = String.valueOf(th);
            logger.logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", new StringBuilder(String.valueOf(valueOf).length() + 71).append("platform method missing - proto runtime falling back to safer methods: ").append(valueOf).toString());
            AppMethodBeat.m2505o(3418);
            return false;
        }
    }

    private static boolean zzut() {
        AppMethodBeat.m2504i(3419);
        if (zzbtj == null) {
            AppMethodBeat.m2505o(3419);
            return false;
        }
        try {
            Class cls = zzbtj.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (zzuu() == null) {
                AppMethodBeat.m2505o(3419);
                return false;
            } else if (zzyv.zzsv()) {
                AppMethodBeat.m2505o(3419);
                return true;
            } else {
                cls.getMethod("getByte", new Class[]{Long.TYPE});
                cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
                cls.getMethod("getInt", new Class[]{Long.TYPE});
                cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
                cls.getMethod("getLong", new Class[]{Long.TYPE});
                cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
                cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                cls.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
                AppMethodBeat.m2505o(3419);
                return true;
            }
        } catch (Throwable th) {
            String valueOf = String.valueOf(th);
            logger.logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", new StringBuilder(String.valueOf(valueOf).length() + 71).append("platform method missing - proto runtime falling back to safer methods: ").append(valueOf).toString());
            AppMethodBeat.m2505o(3419);
            return false;
        }
    }

    private static Field zzuu() {
        Field zza;
        AppMethodBeat.m2504i(3421);
        if (zzyv.zzsv()) {
            zza = zza(Buffer.class, "effectiveDirectAddress");
            if (zza != null) {
                AppMethodBeat.m2505o(3421);
                return zza;
            }
        }
        zza = zza(Buffer.class, "address");
        if (zza == null || zza.getType() != Long.TYPE) {
            AppMethodBeat.m2505o(3421);
            return null;
        }
        AppMethodBeat.m2505o(3421);
        return zza;
    }
}
