package com.tencent.tinker.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.ArrayMap;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class TinkerResourcePatcher {
    private static Collection<WeakReference<Resources>> ACJ = null;
    private static Object ACK = null;
    private static AssetManager ACL = null;
    private static Method ACM = null;
    private static Method ACN = null;
    private static Field ACO = null;
    private static Field ACP = null;
    private static Field ACQ = null;
    private static Field ACR = null;
    private static Field ACS = null;
    private static Field ACT = null;
    private static Field ACU = null;

    TinkerResourcePatcher() {
    }

    /* renamed from: jd */
    public static void m9320jd(Context context) {
        Class cls;
        Class cls2 = Class.forName("android.app.ActivityThread");
        ACK = ShareReflectUtil.m9399d(context, cls2);
        try {
            cls = Class.forName("android.app.LoadedApk");
        } catch (ClassNotFoundException e) {
            cls = Class.forName("android.app.ActivityThread$PackageInfo");
        }
        ACQ = ShareReflectUtil.m9400d(cls, "mResDir");
        ACR = ShareReflectUtil.m9400d(cls2, "mPackages");
        if (VERSION.SDK_INT < 27) {
            ACS = ShareReflectUtil.m9400d(cls2, "mResourcePackages");
        }
        Object assets = context.getAssets();
        ACM = ShareReflectUtil.m9396b(assets, "addAssetPath", String.class);
        try {
            ACU = ShareReflectUtil.m9395b(assets, "mStringBlocks");
            ACN = ShareReflectUtil.m9396b(assets, "ensureStringBlocks", new Class[0]);
        } catch (Throwable th) {
        }
        ACL = (AssetManager) ShareReflectUtil.m9393a(assets, new Class[0]).newInstance(new Object[0]);
        if (VERSION.SDK_INT >= 19) {
            cls2 = Class.forName("android.app.ResourcesManager");
            Object invoke = ShareReflectUtil.m9398c(cls2, "getInstance", new Class[0]).invoke(null, new Object[0]);
            try {
                ACJ = ((ArrayMap) ShareReflectUtil.m9400d(cls2, "mActiveResources").get(invoke)).values();
            } catch (NoSuchFieldException e2) {
                ACJ = (Collection) ShareReflectUtil.m9400d(cls2, "mResourceReferences").get(invoke);
            }
        } else {
            ACJ = ((HashMap) ShareReflectUtil.m9400d(cls2, "mActiveResources").get(ACK)).values();
        }
        if (ACJ == null) {
            throw new IllegalStateException("resource references is null");
        }
        Resources resources = context.getResources();
        if (VERSION.SDK_INT >= 24) {
            try {
                ACP = ShareReflectUtil.m9395b(resources, "mResourcesImpl");
            } catch (Throwable th2) {
                ACO = ShareReflectUtil.m9395b(resources, "mAssets");
            }
        } else {
            ACO = ShareReflectUtil.m9395b(resources, "mAssets");
        }
        try {
            ACT = ShareReflectUtil.m9400d(ApplicationInfo.class, "publicSourceDir");
        } catch (NoSuchFieldException e3) {
        }
    }

    /* renamed from: cg */
    public static void m9318cg(Context context, String str) {
        if (str != null) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            Field[] fieldArr;
            if (VERSION.SDK_INT < 27) {
                fieldArr = new Field[]{ACR, ACS};
            } else {
                fieldArr = new Field[]{ACR};
            }
            for (Field field : fieldArr) {
                for (Entry value : ((Map) field.get(ACK)).entrySet()) {
                    Object obj = ((WeakReference) value.getValue()).get();
                    if (obj != null) {
                        if (applicationInfo.sourceDir.equals((String) ACQ.get(obj))) {
                            ACQ.set(obj, str);
                        }
                    }
                }
            }
            if (((Integer) ACM.invoke(ACL, new Object[]{str})).intValue() == 0) {
                throw new IllegalStateException("Could not create new AssetManager");
            }
            if (!(ACU == null || ACN == null)) {
                ACU.set(ACL, null);
                ACN.invoke(ACL, new Object[0]);
            }
            for (WeakReference weakReference : ACJ) {
                Resources resources = (Resources) weakReference.get();
                if (resources != null) {
                    try {
                        ACO.set(resources, ACL);
                    } catch (Throwable th) {
                        Object obj2 = ACP.get(resources);
                        ShareReflectUtil.m9395b(obj2, "mAssets").set(obj2, ACL);
                    }
                    m9319h(resources);
                    resources.updateConfiguration(resources.getConfiguration(), resources.getDisplayMetrics());
                }
            }
            if (VERSION.SDK_INT >= 24) {
                try {
                    if (ACT != null) {
                        ACT.set(context.getApplicationInfo(), str);
                    }
                } catch (Throwable th2) {
                }
            }
            if (!m9321je(context)) {
                throw new TinkerRuntimeException("checkResInstall failed");
            }
        }
    }

    /* renamed from: h */
    private static void m9319h(Resources resources) {
        try {
            Object obj = ShareReflectUtil.m9400d(Resources.class, "mTypedArrayPool").get(resources);
            do {
            } while (ShareReflectUtil.m9396b(obj, "acquire", new Class[0]).invoke(obj, new Object[0]) != null);
        } catch (Throwable th) {
            new StringBuilder("clearPreloadTypedArrayIssue failed, ignore error: ").append(th);
        }
    }

    /* renamed from: je */
    private static boolean m9321je(Context context) {
        Object open;
        Object obj = null;
        try {
            open = context.getAssets().open("only_use_to_test_tinker_resource.txt");
        } catch (Throwable th) {
            open = th;
            StringBuilder stringBuilder = new StringBuilder("checkResUpdate failed, can't find test resource assets file only_use_to_test_tinker_resource.txt e:");
            open = open.getMessage();
            stringBuilder.append(open);
            return false;
        } finally {
            SharePatchFileUtil.m9369ah(
/*
Method generation error in method: com.tencent.tinker.loader.TinkerResourcePatcher.je(android.content.Context):boolean, dex: classes.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0027: INVOKE  (wrap: java.lang.Object
  ?: MERGE  (r3_1 java.lang.Object) = (r3_0 'obj' java.lang.Object), (r0_5 'open' java.lang.Object)) com.tencent.tinker.loader.shareutil.SharePatchFileUtil.ah(java.lang.Object):void type: STATIC in method: com.tencent.tinker.loader.TinkerResourcePatcher.je(android.content.Context):boolean, dex: classes.dex
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
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r3_1 java.lang.Object) = (r3_0 'obj' java.lang.Object), (r0_5 'open' java.lang.Object) in method: com.tencent.tinker.loader.TinkerResourcePatcher.je(android.content.Context):boolean, dex: classes.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:101)
	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:688)
	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:658)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:340)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 20 more
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:213)
	... 25 more

*/
}
