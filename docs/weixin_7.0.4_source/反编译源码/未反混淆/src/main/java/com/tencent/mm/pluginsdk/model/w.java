package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.m.g;
import com.tencent.mm.pluginsdk.model.s.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class w extends r {
    public final boolean fE(Context context) {
        AppMethodBeat.i(125836);
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("sosomap://type=nav")), 0);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            int size = queryIntentActivities.size();
            int i = 0;
            while (i < size) {
                ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
                if (resolveInfo == null || resolveInfo.activityInfo == null || !"com.tencent.map".equals(resolveInfo.activityInfo.packageName)) {
                    i++;
                } else {
                    AppMethodBeat.o(125836);
                    return true;
                }
            }
        }
        AppMethodBeat.o(125836);
        return false;
    }

    public final boolean aix(String str) {
        AppMethodBeat.i(125837);
        if (str == null || !"com.tencent.map".equals(str)) {
            AppMethodBeat.o(125837);
            return false;
        }
        AppMethodBeat.o(125837);
        return true;
    }

    public final String anK() {
        return "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client";
    }

    public final String dgX() {
        return "TencentMap.apk";
    }

    public final a dgY() {
        AppMethodBeat.i(125838);
        a aVar = new a();
        aVar.vbD = R.string.evj;
        String value = g.Nu().getValue("QQMapDownloadTips");
        if (!bo.isNullOrNil(value)) {
            aVar.vbE = value;
        }
        aVar.vbF = R.string.evo;
        aVar.vbC = R.drawable.icon_tencent_map;
        AppMethodBeat.o(125838);
        return aVar;
    }

    public final String a(Context context, ResolveInfo resolveInfo) {
        AppMethodBeat.i(125839);
        if (context == null || resolveInfo == null || resolveInfo.activityInfo == null) {
            AppMethodBeat.o(125839);
            return null;
        }
        CharSequence loadLabel = resolveInfo.activityInfo.loadLabel(context.getPackageManager());
        if (loadLabel != null) {
            Matcher matcher = Pattern.compile("\\(.*推荐.*\\)", 2).matcher(loadLabel.toString());
            String replaceAll;
            if (matcher.find()) {
                replaceAll = matcher.replaceAll("");
                AppMethodBeat.o(125839);
                return replaceAll;
            }
            replaceAll = loadLabel.toString();
            AppMethodBeat.o(125839);
            return replaceAll;
        }
        AppMethodBeat.o(125839);
        return null;
    }
}
