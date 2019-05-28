package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.IDynamiteLoaderV2.Stub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

public final class DynamiteModule {
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzd();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zze();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzf();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION_NO_FORCE_STAGING = new zzg();
    public static final VersionPolicy PREFER_LOCAL = new zzc();
    public static final VersionPolicy PREFER_REMOTE = new zzb();
    @GuardedBy("DynamiteModule.class")
    private static Boolean zzabr;
    @GuardedBy("DynamiteModule.class")
    private static IDynamiteLoader zzabs;
    @GuardedBy("DynamiteModule.class")
    private static IDynamiteLoaderV2 zzabt;
    @GuardedBy("DynamiteModule.class")
    private static String zzabu;
    private static final ThreadLocal<zza> zzabv = new ThreadLocal();
    private static final IVersions zzabw = new zza();
    private final Context zzabx;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    public static class LoadingException extends Exception {
        private LoadingException(String str) {
            super(str);
        }

        private LoadingException(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zza zza) {
            this(str, th);
        }
    }

    public interface VersionPolicy {

        public interface IVersions {
            int getLocalVersion(Context context, String str);

            int getRemoteVersion(Context context, String str, boolean z);
        }

        public static class SelectionResult {
            public int localVersion = 0;
            public int remoteVersion = 0;
            public int selection = 0;
        }

        SelectionResult selectModule(Context context, String str, IVersions iVersions);
    }

    static class zza {
        public Cursor zzaby;

        private zza() {
        }

        /* synthetic */ zza(zza zza) {
            this();
        }
    }

    static class zzb implements IVersions {
        private final int zzabz;
        private final int zzaca = 0;

        public zzb(int i, int i2) {
            this.zzabz = i;
        }

        public final int getLocalVersion(Context context, String str) {
            return this.zzabz;
        }

        public final int getRemoteVersion(Context context, String str, boolean z) {
            return 0;
        }
    }

    static {
        AppMethodBeat.i(90442);
        AppMethodBeat.o(90442);
    }

    private DynamiteModule(Context context) {
        AppMethodBeat.i(90441);
        this.zzabx = (Context) Preconditions.checkNotNull(context);
        AppMethodBeat.o(90441);
    }

    public static int getLocalVersion(Context context, String str) {
        int i = 0;
        AppMethodBeat.i(90426);
        String valueOf;
        try {
            Class loadClass = context.getApplicationContext().getClassLoader().loadClass(new StringBuilder(String.valueOf(str).length() + 61).append("com.google.android.gms.dynamite.descriptors.").append(str).append(".ModuleDescriptor").toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                i = declaredField2.getInt(null);
                AppMethodBeat.o(90426);
            } else {
                valueOf = String.valueOf(declaredField.get(null));
                new StringBuilder((String.valueOf(valueOf).length() + 51) + String.valueOf(str).length()).append("Module descriptor id '").append(valueOf).append("' didn't match expected id '").append(str).append("'");
                AppMethodBeat.o(90426);
            }
        } catch (ClassNotFoundException e) {
            new StringBuilder(String.valueOf(str).length() + 45).append("Local module descriptor class for ").append(str).append(" not found.");
            AppMethodBeat.o(90426);
            return i;
        } catch (Exception e2) {
            String str2 = "Failed to load module descriptor class: ";
            valueOf = String.valueOf(e2.getMessage());
            if (valueOf.length() != 0) {
                str2.concat(valueOf);
            } else {
                valueOf = new String(str2);
            }
            AppMethodBeat.o(90426);
            return i;
        }
        return i;
    }

    public static Uri getQueryUri(String str, boolean z) {
        AppMethodBeat.i(90432);
        Object obj = z ? ProviderConstants.API_PATH_FORCE_STAGING : ProviderConstants.API_PATH;
        Uri parse = Uri.parse(new StringBuilder((String.valueOf(obj).length() + 42) + String.valueOf(str).length()).append("content://com.google.android.gms.chimera/").append(obj).append("/").append(str).toString());
        AppMethodBeat.o(90432);
        return parse;
    }

    public static int getRemoteVersion(Context context, String str) {
        AppMethodBeat.i(90430);
        int remoteVersion = getRemoteVersion(context, str, false);
        AppMethodBeat.o(90430);
        return remoteVersion;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:47:0x00a0=Splitter:B:47:0x00a0, B:41:0x0098=Splitter:B:41:0x0098, B:34:0x007c=Splitter:B:34:0x007c, B:25:0x004d=Splitter:B:25:0x004d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getRemoteVersion(Context context, String str, boolean z) {
        String valueOf;
        AppMethodBeat.i(90427);
        synchronized (DynamiteModule.class) {
            try {
                Boolean bool = zzabr;
                if (bool == null) {
                    try {
                        Object equals;
                        Class loadClass = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName());
                        Field declaredField = loadClass.getDeclaredField("sClassLoader");
                        synchronized (loadClass) {
                            int zzb;
                            try {
                                ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                                if (classLoader != null) {
                                    declaredField = ClassLoader.getSystemClassLoader();
                                    if (classLoader == declaredField) {
                                        bool = Boolean.FALSE;
                                    } else {
                                        try {
                                            zza(classLoader);
                                        } catch (LoadingException e) {
                                        }
                                        bool = Boolean.TRUE;
                                    }
                                    zzabr = bool;
                                } else {
                                    equals = "com.google.android.gms".equals(context.getApplicationContext().getPackageName());
                                    if (equals != null) {
                                        declaredField.set(equals, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                        zzabr = bool;
                                    } else {
                                        equals = zzb(context, str, z);
                                        if (zzabu == null || zzabu.isEmpty()) {
                                        } else {
                                            zza(new zzh(zzabu, ClassLoader.getSystemClassLoader()));
                                            AppMethodBeat.o(90427);
                                            return zzb;
                                        }
                                    }
                                }
                            } catch (LoadingException e2) {
                                equals = e2;
                                declaredField.set(equals, ClassLoader.getSystemClassLoader());
                                bool = Boolean.FALSE;
                                zzabr = bool;
                                if (bool.booleanValue()) {
                                    try {
                                        zzb = zzb(context, str, z);
                                        return zzb;
                                    } catch (LoadingException e3) {
                                        String str2 = "Failed to retrieve remote module version: ";
                                        valueOf = String.valueOf(e3.getMessage());
                                        if (valueOf.length() != 0) {
                                            str2.concat(valueOf);
                                        } else {
                                            valueOf = new String(str2);
                                        }
                                        AppMethodBeat.o(90427);
                                        return 0;
                                    }
                                }
                                zzb = zza(context, str, z);
                                AppMethodBeat.o(90427);
                                return zzb;
                            } finally {
                                loadClass = 90427;
                                AppMethodBeat.o(90427);
                            }
                        }
                        AppMethodBeat.o(90427);
                        return equals;
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e4) {
                        valueOf = String.valueOf(e4);
                        new StringBuilder(String.valueOf(valueOf).length() + 30).append("Failed to load module via V2: ").append(valueOf);
                        bool = Boolean.FALSE;
                    }
                }
            } finally {
                AppMethodBeat.o(90427);
            }
        }
    }

    @VisibleForTesting
    public static synchronized Boolean getUseV2ForTesting() {
        Boolean bool;
        synchronized (DynamiteModule.class) {
            bool = zzabr;
        }
        return bool;
    }

    public static DynamiteModule load(Context context, VersionPolicy versionPolicy, String str) {
        AppMethodBeat.i(90425);
        zza zza = (zza) zzabv.get();
        zza zza2 = new zza();
        zzabv.set(zza2);
        SelectionResult selectModule;
        LoadingException loadingException;
        DynamiteModule zzd;
        try {
            selectModule = versionPolicy.selectModule(context, str, zzabw);
            int i = selectModule.localVersion;
            new StringBuilder((String.valueOf(str).length() + 68) + String.valueOf(str).length()).append("Considering local module ").append(str).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(i).append(" and remote module ").append(str).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(selectModule.remoteVersion);
            if (selectModule.selection == 0 || ((selectModule.selection == -1 && selectModule.localVersion == 0) || (selectModule.selection == 1 && selectModule.remoteVersion == 0))) {
                int i2 = selectModule.localVersion;
                loadingException = new LoadingException("No acceptable module found. Local version is " + i2 + " and remote version is " + selectModule.remoteVersion + ".", null);
                AppMethodBeat.o(90425);
                throw loadingException;
            } else if (selectModule.selection == -1) {
                zzd = zzd(context, str);
                if (zza2.zzaby != null) {
                    zza2.zzaby.close();
                }
                zzabv.set(zza);
                AppMethodBeat.o(90425);
                return zzd;
            } else if (selectModule.selection == 1) {
                zzd = zza(context, str, selectModule.remoteVersion);
                if (zza2.zzaby != null) {
                    zza2.zzaby.close();
                }
                zzabv.set(zza);
                AppMethodBeat.o(90425);
                return zzd;
            } else {
                loadingException = new LoadingException("VersionPolicy returned invalid code:" + selectModule.selection, null);
                AppMethodBeat.o(90425);
                throw loadingException;
            }
        } catch (LoadingException loadingException2) {
            String str2 = "Failed to load remote module: ";
            String valueOf = String.valueOf(loadingException2.getMessage());
            if (valueOf.length() != 0) {
                str2.concat(valueOf);
            } else {
                valueOf = new String(str2);
            }
            if (selectModule.localVersion == 0 || versionPolicy.selectModule(context, str, new zzb(selectModule.localVersion, 0)).selection != -1) {
                LoadingException loadingException3 = new LoadingException("Remote load failed. No local fallback found.", loadingException2, null);
                AppMethodBeat.o(90425);
                throw loadingException3;
            }
            zzd = zzd(context, str);
            if (zza2.zzaby != null) {
                zza2.zzaby.close();
            }
            zzabv.set(zza);
            AppMethodBeat.o(90425);
            return zzd;
        } catch (Throwable th) {
            if (zza2.zzaby != null) {
                zza2.zzaby.close();
            }
            zzabv.set(zza);
            AppMethodBeat.o(90425);
        }
    }

    public static Cursor queryForDynamiteModule(Context context, String str, boolean z) {
        AppMethodBeat.i(90431);
        Cursor query = context.getContentResolver().query(getQueryUri(str, z), null, null, null, null);
        AppMethodBeat.o(90431);
        return query;
    }

    @VisibleForTesting
    public static synchronized void resetInternalStateForTesting() {
        synchronized (DynamiteModule.class) {
            zzabs = null;
            zzabt = null;
            zzabu = null;
            zzabr = null;
            synchronized (DynamiteLoaderClassLoader.class) {
                DynamiteLoaderClassLoader.sClassLoader = null;
            }
        }
    }

    @VisibleForTesting
    public static synchronized void setUseV2ForTesting(Boolean bool) {
        synchronized (DynamiteModule.class) {
            zzabr = bool;
        }
    }

    private static int zza(Context context, String str, boolean z) {
        int i = 0;
        AppMethodBeat.i(90428);
        IDynamiteLoader zzg = zzg(context);
        if (zzg == null) {
            AppMethodBeat.o(90428);
        } else {
            try {
                i = zzg.getModuleVersion2(ObjectWrapper.wrap(context), str, z);
                AppMethodBeat.o(90428);
            } catch (RemoteException e) {
                String str2 = "Failed to retrieve remote module version: ";
                String valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() != 0) {
                    str2.concat(valueOf);
                } else {
                    valueOf = new String(str2);
                }
                AppMethodBeat.o(90428);
            }
        }
        return i;
    }

    private static Context zza(Context context, String str, int i, Cursor cursor, IDynamiteLoaderV2 iDynamiteLoaderV2) {
        AppMethodBeat.i(90438);
        try {
            Context context2 = (Context) ObjectWrapper.unwrap(iDynamiteLoaderV2.loadModule2(ObjectWrapper.wrap(context), str, i, ObjectWrapper.wrap(cursor)));
            AppMethodBeat.o(90438);
            return context2;
        } catch (Exception e) {
            String str2 = "Failed to load DynamiteLoader: ";
            String valueOf = String.valueOf(e.toString());
            if (valueOf.length() != 0) {
                str2.concat(valueOf);
            } else {
                valueOf = new String(str2);
            }
            AppMethodBeat.o(90438);
            return null;
        }
    }

    private static DynamiteModule zza(Context context, String str, int i) {
        Boolean bool;
        AppMethodBeat.i(90434);
        synchronized (DynamiteModule.class) {
            try {
                bool = zzabr;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(90434);
            }
        }
        DynamiteModule loadingException;
        if (bool == null) {
            loadingException = new LoadingException("Failed to determine which loading route to use.", null);
            throw loadingException;
        } else if (bool.booleanValue()) {
            loadingException = zzc(context, str, i);
            AppMethodBeat.o(90434);
            return loadingException;
        } else {
            loadingException = zzb(context, str, i);
            AppMethodBeat.o(90434);
            return loadingException;
        }
    }

    @GuardedBy("DynamiteModule.class")
    private static void zza(ClassLoader classLoader) {
        AppMethodBeat.i(90439);
        try {
            zzabt = Stub.asInterface((IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]));
            AppMethodBeat.o(90439);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            LoadingException loadingException = new LoadingException("Failed to instantiate dynamite loader", e, null);
            AppMethodBeat.o(90439);
            throw loadingException;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzb(Context context, String str, boolean z) {
        Throwable e;
        AppMethodBeat.i(90429);
        Cursor queryForDynamiteModule;
        try {
            queryForDynamiteModule = queryForDynamiteModule(context, str, z);
            if (queryForDynamiteModule != null) {
                try {
                    if (queryForDynamiteModule.moveToFirst()) {
                        int i = queryForDynamiteModule.getInt(0);
                        if (i > 0) {
                            synchronized (DynamiteModule.class) {
                                zzabu = queryForDynamiteModule.getString(2);
                            }
                            zza zza = (zza) zzabv.get();
                            if (zza != null && zza.zzaby == null) {
                                zza.zzaby = queryForDynamiteModule;
                                queryForDynamiteModule = null;
                            }
                        }
                        if (queryForDynamiteModule != null) {
                            queryForDynamiteModule.close();
                        }
                        AppMethodBeat.o(90429);
                        return i;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        if (e instanceof LoadingException) {
                            AppMethodBeat.o(90429);
                            throw e;
                        }
                        LoadingException loadingException = new LoadingException("V2 version check failed", e, null);
                        AppMethodBeat.o(90429);
                        throw loadingException;
                    } catch (Throwable th) {
                        e = th;
                        if (queryForDynamiteModule != null) {
                        }
                        AppMethodBeat.o(90429);
                        throw e;
                    }
                } catch (Throwable th2) {
                    while (true) {
                        AppMethodBeat.o(90429);
                    }
                }
            }
            LoadingException loadingException2 = new LoadingException("Failed to connect to dynamite module ContentResolver.", null);
            AppMethodBeat.o(90429);
            throw loadingException2;
        } catch (Exception e3) {
            e = e3;
            queryForDynamiteModule = null;
        } catch (Throwable th3) {
            e = th3;
            queryForDynamiteModule = null;
            if (queryForDynamiteModule != null) {
                queryForDynamiteModule.close();
            }
            AppMethodBeat.o(90429);
            throw e;
        }
    }

    private static DynamiteModule zzb(Context context, String str, int i) {
        AppMethodBeat.i(90435);
        new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i);
        IDynamiteLoader zzg = zzg(context);
        LoadingException loadingException;
        if (zzg == null) {
            loadingException = new LoadingException("Failed to create IDynamiteLoader.", null);
            AppMethodBeat.o(90435);
            throw loadingException;
        }
        try {
            IObjectWrapper createModuleContext = zzg.createModuleContext(ObjectWrapper.wrap(context), str, i);
            if (ObjectWrapper.unwrap(createModuleContext) == null) {
                loadingException = new LoadingException("Failed to load remote module.", null);
                AppMethodBeat.o(90435);
                throw loadingException;
            }
            DynamiteModule dynamiteModule = new DynamiteModule((Context) ObjectWrapper.unwrap(createModuleContext));
            AppMethodBeat.o(90435);
            return dynamiteModule;
        } catch (RemoteException e) {
            LoadingException loadingException2 = new LoadingException("Failed to load remote module.", e, null);
            AppMethodBeat.o(90435);
            throw loadingException2;
        }
    }

    private static DynamiteModule zzc(Context context, String str, int i) {
        IDynamiteLoaderV2 iDynamiteLoaderV2;
        AppMethodBeat.i(90437);
        new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i);
        synchronized (DynamiteModule.class) {
            try {
                iDynamiteLoaderV2 = zzabt;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(90437);
            }
        }
        if (iDynamiteLoaderV2 == null) {
            DynamiteModule loadingException = new LoadingException("DynamiteLoaderV2 was not cached.", null);
            throw loadingException;
        }
        zza zza = (zza) zzabv.get();
        LoadingException loadingException2;
        if (zza == null || zza.zzaby == null) {
            loadingException2 = new LoadingException("No result cursor", null);
            AppMethodBeat.o(90437);
            throw loadingException2;
        }
        Context zza2 = zza(context.getApplicationContext(), str, i, zza.zzaby, iDynamiteLoaderV2);
        if (zza2 == null) {
            loadingException2 = new LoadingException("Failed to get module context", null);
            AppMethodBeat.o(90437);
            throw loadingException2;
        }
        DynamiteModule dynamiteModule = new DynamiteModule(zza2);
        AppMethodBeat.o(90437);
        return dynamiteModule;
    }

    private static DynamiteModule zzd(Context context, String str) {
        AppMethodBeat.i(90433);
        String str2 = "Selected local version of ";
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2.concat(valueOf);
        } else {
            valueOf = new String(str2);
        }
        DynamiteModule dynamiteModule = new DynamiteModule(context.getApplicationContext());
        AppMethodBeat.o(90433);
        return dynamiteModule;
    }

    /* JADX WARNING: Missing block: B:26:0x0061, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(90436);
     */
    /* JADX WARNING: Missing block: B:36:?, code skipped:
            return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static IDynamiteLoader zzg(Context context) {
        AppMethodBeat.i(90436);
        synchronized (DynamiteModule.class) {
            try {
                IDynamiteLoader iDynamiteLoader;
                if (zzabs != null) {
                    iDynamiteLoader = zzabs;
                    AppMethodBeat.o(90436);
                    return iDynamiteLoader;
                } else if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context) != 0) {
                    AppMethodBeat.o(90436);
                    return null;
                } else {
                    iDynamiteLoader = IDynamiteLoader.Stub.asInterface((IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance());
                    if (iDynamiteLoader != null) {
                        zzabs = iDynamiteLoader;
                        AppMethodBeat.o(90436);
                        return iDynamiteLoader;
                    }
                }
            } catch (Exception e) {
                String str = "Failed to load IDynamiteLoader from GmsCore: ";
                String valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() != 0) {
                    str.concat(valueOf);
                } else {
                    valueOf = new String(str);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(90436);
            }
        }
    }

    public final Context getModuleContext() {
        return this.zzabx;
    }

    public final IBinder instantiate(String str) {
        AppMethodBeat.i(90440);
        try {
            IBinder iBinder = (IBinder) this.zzabx.getClassLoader().loadClass(str).newInstance();
            AppMethodBeat.o(90440);
            return iBinder;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String str2 = "Failed to instantiate module class: ";
            String valueOf = String.valueOf(str);
            LoadingException loadingException = new LoadingException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e, null);
            AppMethodBeat.o(90440);
            throw loadingException;
        }
    }
}
