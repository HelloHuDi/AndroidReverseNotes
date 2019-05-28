package com.tencent.mm.opensdk.channel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.a.b;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class MMessageActV2 {
    public static final String DEFAULT_ENTRY_CLASS_NAME = ".wxapi.WXEntryActivity";
    public static final String MM_ENTRY_PACKAGE_NAME = "com.tencent.mm";
    public static final String MM_MSG_ENTRY_CLASS_NAME = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
    private static final String TAG = "MicroMsg.SDK.MMessageAct";

    public static class Args {
        public static final int INVALID_FLAGS = -1;
        public Bundle bundle;
        public String content;
        public int flags = -1;
        public String targetClassName;
        public String targetPkgName;
        public String token;

        public String toString() {
            AppMethodBeat.i(128141);
            String str = "targetPkgName:" + this.targetPkgName + ", targetClassName:" + this.targetClassName + ", content:" + this.content + ", flags:" + this.flags + ", bundle:" + this.bundle;
            AppMethodBeat.o(128141);
            return str;
        }
    }

    public static boolean send(Context context, Args args) {
        AppMethodBeat.i(128140);
        if (context == null || args == null) {
            Log.e(TAG, "send fail, invalid argument");
            AppMethodBeat.o(128140);
            return false;
        } else if (d.b(args.targetPkgName)) {
            Log.e(TAG, "send fail, invalid targetPkgName, targetPkgName = " + args.targetPkgName);
            AppMethodBeat.o(128140);
            return false;
        } else {
            if (d.b(args.targetClassName)) {
                args.targetClassName = args.targetPkgName + DEFAULT_ENTRY_CLASS_NAME;
            }
            Log.d(TAG, "send, targetPkgName = " + args.targetPkgName + ", targetClassName = " + args.targetClassName);
            Intent intent = new Intent();
            intent.setClassName(args.targetPkgName, args.targetClassName);
            if (args.bundle != null) {
                intent.putExtras(args.bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, args.content);
            intent.putExtra(ConstantsAPI.CHECK_SUM, b.a(args.content, Build.SDK_INT, packageName));
            intent.putExtra(ConstantsAPI.TOKEN, args.token);
            if (args.flags == -1) {
                intent.addFlags(268435456).addFlags(134217728);
            } else {
                intent.setFlags(args.flags);
            }
            try {
                context.startActivity(intent);
                Log.d(TAG, "send mm message, intent=".concat(String.valueOf(intent)));
                AppMethodBeat.o(128140);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "send fail, ex = " + e.getMessage());
                AppMethodBeat.o(128140);
                return false;
            }
        }
    }
}
