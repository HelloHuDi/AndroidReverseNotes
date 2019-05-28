package com.tencent.luggage.sdk.launching;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import com.tencent.luggage.sdk.customize.C45127a;
import com.tencent.p177mm.modelappbrand.LaunchParamsOptional;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.p177mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Method;

/* renamed from: com.tencent.luggage.sdk.launching.a */
public abstract class C17828a implements C45127a {
    /* renamed from: b */
    public abstract boolean mo33004b(Context context, LaunchParcel launchParcel);

    /* renamed from: a */
    public final boolean mo33003a(Context context, String str, String str2, String str3, int i, int i2, AppBrandStatObject appBrandStatObject, AppBrandLaunchReferrer appBrandLaunchReferrer, LaunchParamsOptional launchParamsOptional) {
        LaunchParcel launchParcel = new LaunchParcel();
        launchParcel.username = str;
        launchParcel.appId = str2;
        launchParcel.hgC = str3 == null ? null : str3.trim();
        launchParcel.har = i;
        launchParcel.version = i2;
        launchParcel.ijy = appBrandStatObject;
        launchParcel.hgF = appBrandLaunchReferrer;
        launchParcel.ijz = launchParamsOptional;
        return mo33002a(context, launchParcel);
    }

    /* renamed from: a */
    public final boolean mo33002a(Context context, LaunchParcel launchParcel) {
        if (C5046bo.isNullOrNil(launchParcel.username) && C5046bo.isNullOrNil(launchParcel.appId)) {
            return false;
        }
        launchParcel.ijA = C5046bo.anU();
        if (context == null) {
            context = C4996ah.getContext();
        } else if (context instanceof Activity) {
            TypedArray typedArray = null;
            try {
                typedArray = context.obtainStyledAttributes(new int[]{16842840});
                if (!typedArray.getBoolean(0, false)) {
                    Activity activity = (Activity) context;
                    try {
                        Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(activity, new Object[0]);
                    } catch (Throwable th) {
                        C4990ab.printErrStackTrace("MicroMsg.AppBrand.Precondition.AbstractLaunchEntry", th, "call convertActivityFromTranslucent Fail: %s", th.getMessage());
                    }
                }
                if (typedArray != null) {
                    typedArray.recycle();
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrand.Precondition.AbstractLaunchEntry", e, "convertActivityFromTranslucent %s", context.getClass().getSimpleName());
                if (typedArray != null) {
                    typedArray.recycle();
                }
            } catch (Throwable th2) {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
        return mo33004b(context, launchParcel);
    }
}
