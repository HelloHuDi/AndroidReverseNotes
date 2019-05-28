package com.tencent.recovery.option;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.recovery.ConstantsRecovery.DefaultProcessOptions;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.util.Util;

public class OptionFactory {
    private static IOptionsCreator Art;

    /* renamed from: eN */
    public static ProcessOptions m8721eN(String str, int i) {
        ProcessOptions processOptions = null;
        if (Art != null) {
            processOptions = Art.createProcessOptions(str, i);
        }
        if (processOptions != null) {
            return processOptions;
        }
        RecoveryLog.m8712i("Recovery.OptionFactory", "not found custom process options, use default %d", Integer.valueOf(i));
        if (i == 1) {
            return DefaultProcessOptions.AqP;
        }
        return DefaultProcessOptions.AqN;
    }

    /* renamed from: iz */
    public static CommonOptions m8722iz(Context context) {
        CommonOptions commonOptions = null;
        if (Art != null) {
            commonOptions = Art.createCommonOptions(context);
        }
        if (commonOptions != null) {
            return commonOptions;
        }
        RecoveryLog.m8712i("Recovery.OptionFactory", "not found custom custom options, use default", new Object[0]);
        Builder builder = new Builder();
        builder.Arl = "";
        builder.Arq = false;
        builder.eCq = String.valueOf(Util.m8736iB(context));
        try {
            builder.clientVersion = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
        }
        builder.Arr = 600000;
        builder.Ars = 600000;
        return builder.dQg();
    }
}
