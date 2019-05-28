package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

public class ReaderWizard {
    /* renamed from: a */
    private DexLoader f16265a;
    /* renamed from: b */
    private ReaderCallback f16266b;

    public ReaderWizard(ReaderCallback readerCallback) {
        AppMethodBeat.m2504i(64061);
        this.f16265a = null;
        this.f16266b = null;
        this.f16265a = m71048a();
        this.f16266b = readerCallback;
        AppMethodBeat.m2505o(64061);
    }

    /* renamed from: a */
    private static DexLoader m71048a() {
        AppMethodBeat.m2504i(64062);
        C30947bi c = C5818o.m8863a(true).mo12200c();
        DexLoader dexLoader = null;
        if (c != null) {
            dexLoader = c.mo50067b();
        }
        AppMethodBeat.m2505o(64062);
        return dexLoader;
    }

    public static Drawable getResDrawable(int i) {
        Drawable drawable;
        AppMethodBeat.m2504i(64059);
        DexLoader a = m71048a();
        if (a != null) {
            Object invokeStaticMethod = a.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResDrawable", new Class[]{Integer.class}, Integer.valueOf(i));
            if (invokeStaticMethod instanceof Drawable) {
                drawable = (Drawable) invokeStaticMethod;
                AppMethodBeat.m2505o(64059);
                return drawable;
            }
        }
        drawable = null;
        AppMethodBeat.m2505o(64059);
        return drawable;
    }

    public static String getResString(int i) {
        String str;
        AppMethodBeat.m2504i(64060);
        String str2 = "";
        DexLoader a = m71048a();
        if (a != null) {
            Object invokeStaticMethod = a.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResString", new Class[]{Integer.class}, Integer.valueOf(i));
            if (invokeStaticMethod instanceof String) {
                str = (String) invokeStaticMethod;
                AppMethodBeat.m2505o(64060);
                return str;
            }
        }
        str = str2;
        AppMethodBeat.m2505o(64060);
        return str;
    }

    public static boolean isSupportCurrentPlatform(Context context) {
        boolean booleanValue;
        AppMethodBeat.m2504i(64057);
        DexLoader a = m71048a();
        if (a != null) {
            Object invokeStaticMethod = a.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportCurrentPlatform", new Class[]{Context.class}, context);
            if (invokeStaticMethod instanceof Boolean) {
                booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
                AppMethodBeat.m2505o(64057);
                return booleanValue;
            }
        }
        booleanValue = false;
        AppMethodBeat.m2505o(64057);
        return booleanValue;
    }

    public static boolean isSupportExt(String str) {
        boolean booleanValue;
        AppMethodBeat.m2504i(64058);
        DexLoader a = m71048a();
        if (a != null) {
            Object invokeStaticMethod = a.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportExt", new Class[]{String.class}, str);
            if (invokeStaticMethod instanceof Boolean) {
                booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
                AppMethodBeat.m2505o(64058);
                return booleanValue;
            }
        }
        booleanValue = false;
        AppMethodBeat.m2505o(64058);
        return booleanValue;
    }

    public boolean checkPlugin(Object obj, Context context, String str, boolean z) {
        AppMethodBeat.m2504i(64065);
        if (this.f16265a == null) {
            AppMethodBeat.m2505o(64065);
            return false;
        }
        Object obj2 = obj;
        Object invokeMethod = this.f16265a.invokeMethod(obj2, "com.tencent.tbs.reader.TbsReader", "checkPlugin", new Class[]{Context.class, String.class, Boolean.class}, context, str, Boolean.valueOf(z));
        if (invokeMethod instanceof Boolean) {
            boolean booleanValue = ((Boolean) invokeMethod).booleanValue();
            AppMethodBeat.m2505o(64065);
            return booleanValue;
        }
        AppMethodBeat.m2505o(64065);
        return false;
    }

    public void destroy(Object obj) {
        AppMethodBeat.m2504i(64070);
        this.f16266b = null;
        if (this.f16265a == null || obj == null) {
            AppMethodBeat.m2505o(64070);
            return;
        }
        this.f16265a.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "destroy", new Class[0], new Object[0]);
        AppMethodBeat.m2505o(64070);
    }

    public void doCommand(Object obj, Integer num, Object obj2, Object obj3) {
        AppMethodBeat.m2504i(64069);
        if (this.f16265a == null) {
            AppMethodBeat.m2505o(64069);
            return;
        }
        Object[] objArr = new Object[]{new Integer(num.intValue()), obj2, obj3};
        Object obj4 = obj;
        this.f16265a.invokeMethod(obj4, "com.tencent.tbs.reader.TbsReader", "doCommand", new Class[]{Integer.class, Object.class, Object.class}, objArr);
        AppMethodBeat.m2505o(64069);
    }

    public Object getTbsReader() {
        AppMethodBeat.m2504i(64063);
        Object newInstance = this.f16265a.newInstance("com.tencent.tbs.reader.TbsReader", new Class[0], new Object[0]);
        AppMethodBeat.m2505o(64063);
        return newInstance;
    }

    public boolean initTbsReader(Object obj, Context context) {
        AppMethodBeat.m2504i(64064);
        if (this.f16265a == null || obj == null) {
            AppMethodBeat.m2505o(64064);
            return false;
        }
        Object obj2 = obj;
        Object invokeMethod = this.f16265a.invokeMethod(obj2, "com.tencent.tbs.reader.TbsReader", "init", new Class[]{Context.class, DexLoader.class, Object.class}, context, this.f16265a, this);
        if (invokeMethod instanceof Boolean) {
            boolean booleanValue = ((Boolean) invokeMethod).booleanValue();
            AppMethodBeat.m2505o(64064);
            return booleanValue;
        }
        AppMethodBeat.m2505o(64064);
        return false;
    }

    public void onCallBackAction(Integer num, Object obj, Object obj2) {
        AppMethodBeat.m2504i(64068);
        if (this.f16266b != null) {
            this.f16266b.onCallBackAction(num, obj, obj2);
        }
        AppMethodBeat.m2505o(64068);
    }

    public void onSizeChanged(Object obj, int i, int i2) {
        AppMethodBeat.m2504i(64067);
        if (this.f16265a == null) {
            AppMethodBeat.m2505o(64067);
            return;
        }
        Object obj2 = obj;
        this.f16265a.invokeMethod(obj2, "com.tencent.tbs.reader.TbsReader", "onSizeChanged", new Class[]{Integer.class, Integer.class}, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(64067);
    }

    public boolean openFile(Object obj, Context context, Bundle bundle, FrameLayout frameLayout) {
        AppMethodBeat.m2504i(64066);
        if (this.f16265a == null) {
            AppMethodBeat.m2505o(64066);
            return false;
        }
        Object obj2 = obj;
        Object invokeMethod = this.f16265a.invokeMethod(obj2, "com.tencent.tbs.reader.TbsReader", "openFile", new Class[]{Context.class, Bundle.class, FrameLayout.class}, context, bundle, frameLayout);
        if (invokeMethod instanceof Boolean) {
            boolean booleanValue = ((Boolean) invokeMethod).booleanValue();
            AppMethodBeat.m2505o(64066);
            return booleanValue;
        }
        AppMethodBeat.m2505o(64066);
        return false;
    }

    public void userStatistics(Object obj, String str) {
        AppMethodBeat.m2504i(64071);
        if (this.f16265a == null) {
            AppMethodBeat.m2505o(64071);
            return;
        }
        Object obj2 = obj;
        this.f16265a.invokeMethod(obj2, "com.tencent.tbs.reader.TbsReader", "userStatistics", new Class[]{String.class}, str);
        AppMethodBeat.m2505o(64071);
    }
}
