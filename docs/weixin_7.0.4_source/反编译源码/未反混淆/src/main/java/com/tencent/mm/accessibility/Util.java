package com.tencent.mm.accessibility;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.util.VideoMaterialUtil;

public class Util {
    public static Activity getActivityOfView(View view) {
        AppMethodBeat.i(118645);
        if (view == null) {
            AppMethodBeat.o(118645);
            return null;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                AppMethodBeat.o(118645);
                return activity;
            }
        }
        AppMethodBeat.o(118645);
        return null;
    }

    public static boolean resourceHasPackage(int i) {
        return (i >>> 24) != 0;
    }

    public static String getViewIdName(View view) {
        AppMethodBeat.i(118646);
        String str;
        if (view == null) {
            str = "NO_ID";
            AppMethodBeat.o(118646);
            return str;
        }
        int id = view.getId();
        StringBuilder stringBuilder = new StringBuilder(128);
        if (id != -1) {
            Resources resources = view.getResources();
            if (resourceHasPackage(id) && resources != null) {
                switch (WebView.NIGHT_MODE_COLOR & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (Throwable th) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        str = stringBuilder.toString();
        AppMethodBeat.o(118646);
        return str;
    }
}
