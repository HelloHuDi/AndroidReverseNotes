package com.tencent.p177mm.p835bd;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.platformtools.SpellMap;
import com.tencent.p177mm.plugin.appbrand.p328r.C27278r;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.bd.a */
public final class C17977a {
    /* renamed from: cA */
    public static Map<String, String> m28292cA(int i, int i2) {
        AppMethodBeat.m2504i(91300);
        switch (i) {
            case 201:
                Map<String, String> d = C27278r.m43309d(i, false, i2);
                AppMethodBeat.m2505o(91300);
                return d;
            default:
                Map d2 = C46400aa.m87334d(i, false, i2);
                AppMethodBeat.m2505o(91300);
                return d2;
        }
    }

    /* renamed from: b */
    public static String m28291b(int i, Map<String, String> map) {
        AppMethodBeat.m2504i(91301);
        String d;
        switch (i) {
            case 21:
                d = C46400aa.m87333d(map, 1);
                AppMethodBeat.m2505o(91301);
                return d;
            case 201:
                d = C27278r.m43306E(map);
                AppMethodBeat.m2505o(91301);
                return d;
            default:
                d = C46400aa.m87298E(map);
                AppMethodBeat.m2505o(91301);
                return d;
        }
    }

    /* renamed from: a */
    public static int m28288a(JSONObject jSONObject, String str, Context context) {
        AppMethodBeat.m2504i(91302);
        int optInt = jSONObject == null ? 0 : jSONObject.optInt("businessType");
        if (optInt == 0) {
            if (str.equals(context.getString(C25738R.string.e0b))) {
                optInt = 2;
            } else if (str.equals(context.getString(C25738R.string.e0f))) {
                optInt = 8;
            } else if (str.equals(context.getString(C25738R.string.e0c))) {
                optInt = 1;
            } else {
                C4990ab.m7416i("MicroMsg.FTS.FTSExportLogic", "option " + str + " no type");
            }
        }
        AppMethodBeat.m2505o(91302);
        return optInt;
    }

    /* renamed from: b */
    public static Drawable m28290b(int i, Context context) {
        AppMethodBeat.m2504i(91303);
        int i2 = C1318a.sos_search_icon;
        switch (i) {
            case 1:
                i2 = C1318a.sos_offical_icon;
                break;
            case 2:
                i2 = C1318a.sos_article_icon;
                break;
            case 8:
                i2 = C1318a.sos_moments_icon;
                break;
            case 64:
                i2 = C1318a.sos_mini_program_icon;
                break;
            case 256:
            case 384:
                i2 = C1318a.sos_emoji_icon;
                break;
            case 512:
                i2 = C1318a.sos_music_icon;
                break;
            case WXMediaMessage.DESCRIPTION_LENGTH_LIMIT /*1024*/:
                i2 = C1318a.sos_novel_icon;
                break;
            case 12582912:
                i2 = C1318a.sos_video_icon;
                break;
            case 16777248:
                i2 = C1318a.sos_question_icon;
                break;
            case 16777728:
                i2 = C1318a.sos_wiki_icon;
                break;
        }
        Drawable drawable = context.getResources().getDrawable(i2);
        AppMethodBeat.m2505o(91303);
        return drawable;
    }

    /* renamed from: aO */
    public static boolean m28289aO(String str, String str2) {
        int i = 0;
        AppMethodBeat.m2504i(91304);
        if (str == str2) {
            AppMethodBeat.m2505o(91304);
            return true;
        } else if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(91304);
            return false;
        } else if (str.startsWith(str2)) {
            AppMethodBeat.m2505o(91304);
            return true;
        } else {
            String str3;
            if (TextUtils.isEmpty(str)) {
                str3 = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder(str.length());
                while (i < str.length()) {
                    stringBuilder.append(SpellMap.m42342r(str.charAt(i)));
                    i++;
                }
                str3 = stringBuilder.toString();
            }
            boolean startsWith = str3.startsWith(str2);
            AppMethodBeat.m2505o(91304);
            return startsWith;
        }
    }
}
