package com.tencent.p177mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.pluginsdk.model.C14893s.C14894a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.pluginsdk.model.w */
public final class C40446w extends C30081r {
    /* renamed from: fE */
    public final boolean mo27192fE(Context context) {
        AppMethodBeat.m2504i(125836);
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("sosomap://type=nav")), 0);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            int size = queryIntentActivities.size();
            int i = 0;
            while (i < size) {
                ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
                if (resolveInfo == null || resolveInfo.activityInfo == null || !"com.tencent.map".equals(resolveInfo.activityInfo.packageName)) {
                    i++;
                } else {
                    AppMethodBeat.m2505o(125836);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(125836);
        return false;
    }

    public final boolean aix(String str) {
        AppMethodBeat.m2504i(125837);
        if (str == null || !"com.tencent.map".equals(str)) {
            AppMethodBeat.m2505o(125837);
            return false;
        }
        AppMethodBeat.m2505o(125837);
        return true;
    }

    public final String anK() {
        return "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client";
    }

    public final String dgX() {
        return "TencentMap.apk";
    }

    public final C14894a dgY() {
        AppMethodBeat.m2504i(125838);
        C14894a c14894a = new C14894a();
        c14894a.vbD = C25738R.string.evj;
        String value = C26373g.m41964Nu().getValue("QQMapDownloadTips");
        if (!C5046bo.isNullOrNil(value)) {
            c14894a.vbE = value;
        }
        c14894a.vbF = C25738R.string.evo;
        c14894a.vbC = C25738R.drawable.icon_tencent_map;
        AppMethodBeat.m2505o(125838);
        return c14894a;
    }

    /* renamed from: a */
    public final String mo27187a(Context context, ResolveInfo resolveInfo) {
        AppMethodBeat.m2504i(125839);
        if (context == null || resolveInfo == null || resolveInfo.activityInfo == null) {
            AppMethodBeat.m2505o(125839);
            return null;
        }
        CharSequence loadLabel = resolveInfo.activityInfo.loadLabel(context.getPackageManager());
        if (loadLabel != null) {
            Matcher matcher = Pattern.compile("\\(.*推荐.*\\)", 2).matcher(loadLabel.toString());
            String replaceAll;
            if (matcher.find()) {
                replaceAll = matcher.replaceAll("");
                AppMethodBeat.m2505o(125839);
                return replaceAll;
            }
            replaceAll = loadLabel.toString();
            AppMethodBeat.m2505o(125839);
            return replaceAll;
        }
        AppMethodBeat.m2505o(125839);
        return null;
    }
}
