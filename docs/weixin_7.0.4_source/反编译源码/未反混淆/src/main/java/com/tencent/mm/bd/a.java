package com.tencent.mm.bd;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.appbrand.r.r;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;
import org.json.JSONObject;

public final class a {
    public static Map<String, String> cA(int i, int i2) {
        AppMethodBeat.i(91300);
        switch (i) {
            case 201:
                Map<String, String> d = r.d(i, false, i2);
                AppMethodBeat.o(91300);
                return d;
            default:
                Map d2 = aa.d(i, false, i2);
                AppMethodBeat.o(91300);
                return d2;
        }
    }

    public static String b(int i, Map<String, String> map) {
        AppMethodBeat.i(91301);
        String d;
        switch (i) {
            case 21:
                d = aa.d(map, 1);
                AppMethodBeat.o(91301);
                return d;
            case 201:
                d = r.E(map);
                AppMethodBeat.o(91301);
                return d;
            default:
                d = aa.E(map);
                AppMethodBeat.o(91301);
                return d;
        }
    }

    public static int a(JSONObject jSONObject, String str, Context context) {
        AppMethodBeat.i(91302);
        int optInt = jSONObject == null ? 0 : jSONObject.optInt("businessType");
        if (optInt == 0) {
            if (str.equals(context.getString(R.string.e0b))) {
                optInt = 2;
            } else if (str.equals(context.getString(R.string.e0f))) {
                optInt = 8;
            } else if (str.equals(context.getString(R.string.e0c))) {
                optInt = 1;
            } else {
                ab.i("MicroMsg.FTS.FTSExportLogic", "option " + str + " no type");
            }
        }
        AppMethodBeat.o(91302);
        return optInt;
    }

    public static Drawable b(int i, Context context) {
        AppMethodBeat.i(91303);
        int i2 = R.raw.sos_search_icon;
        switch (i) {
            case 1:
                i2 = R.raw.sos_offical_icon;
                break;
            case 2:
                i2 = R.raw.sos_article_icon;
                break;
            case 8:
                i2 = R.raw.sos_moments_icon;
                break;
            case 64:
                i2 = R.raw.sos_mini_program_icon;
                break;
            case 256:
            case 384:
                i2 = R.raw.sos_emoji_icon;
                break;
            case 512:
                i2 = R.raw.sos_music_icon;
                break;
            case WXMediaMessage.DESCRIPTION_LENGTH_LIMIT /*1024*/:
                i2 = R.raw.sos_novel_icon;
                break;
            case 12582912:
                i2 = R.raw.sos_video_icon;
                break;
            case 16777248:
                i2 = R.raw.sos_question_icon;
                break;
            case 16777728:
                i2 = R.raw.sos_wiki_icon;
                break;
        }
        Drawable drawable = context.getResources().getDrawable(i2);
        AppMethodBeat.o(91303);
        return drawable;
    }

    public static boolean aO(String str, String str2) {
        int i = 0;
        AppMethodBeat.i(91304);
        if (str == str2) {
            AppMethodBeat.o(91304);
            return true;
        } else if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(91304);
            return false;
        } else if (str.startsWith(str2)) {
            AppMethodBeat.o(91304);
            return true;
        } else {
            String str3;
            if (TextUtils.isEmpty(str)) {
                str3 = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder(str.length());
                while (i < str.length()) {
                    stringBuilder.append(SpellMap.r(str.charAt(i)));
                    i++;
                }
                str3 = stringBuilder.toString();
            }
            boolean startsWith = str3.startsWith(str2);
            AppMethodBeat.o(91304);
            return startsWith;
        }
    }
}
