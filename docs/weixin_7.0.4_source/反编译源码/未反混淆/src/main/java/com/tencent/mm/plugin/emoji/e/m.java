package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.b;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class m {
    public static void a(Context context, EmotionSummary emotionSummary, int i, int i2, int i3, String str, int i4) {
        AppMethodBeat.i(52988);
        Intent intent = new Intent();
        intent.setClass(context, EmojiStoreDetailUI.class);
        if (emotionSummary != null) {
            intent.putExtra("extra_id", emotionSummary.ProductID);
            intent.putExtra("extra_name", emotionSummary.PackName);
            intent.putExtra("extra_copyright", emotionSummary.PackCopyright);
            intent.putExtra("extra_coverurl", emotionSummary.CoverUrl);
            intent.putExtra("extra_description", emotionSummary.PackDesc);
            intent.putExtra("extra_price", emotionSummary.PackPrice);
            intent.putExtra("extra_type", emotionSummary.PackType);
            intent.putExtra("extra_flag", emotionSummary.PackFlag);
            intent.putExtra("preceding_scence", i4);
            intent.putExtra("call_by", 1);
            intent.putExtra("check_clickflag", false);
            intent.putExtra("download_entrance_scene", i);
            if (i2 != -1) {
                intent.putExtra("extra_status", i2);
            }
            if (i3 != -1) {
                intent.putExtra("extra_progress", -1);
            }
            if (!bo.isNullOrNil(str)) {
                intent.putExtra("to_talker_name", str);
            }
        } else {
            ab.i("MicroMsg.emoji.EmojiUINavigatorMgr", "get detail intent failed. summary is null.");
        }
        context.startActivity(intent);
        AppMethodBeat.o(52988);
    }

    private static void a(Context context, EmotionBannerSet emotionBannerSet, int i, int i2) {
        AppMethodBeat.i(52989);
        Intent intent = new Intent();
        intent.setClass(context, EmojiStoreDetailUI.class);
        intent.putExtra("extra_id", emotionBannerSet.ProductID);
        intent.putExtra("extra_name", emotionBannerSet.Title);
        intent.putExtra("extra_description", emotionBannerSet.Desc);
        intent.putExtra("preceding_scence", i2);
        intent.putExtra("call_by", 1);
        intent.putExtra("download_entrance_scene", i);
        intent.putExtra("check_clickflag", true);
        context.startActivity(intent);
        AppMethodBeat.o(52989);
    }

    public static void a(Context context, EmotionBannerSet emotionBannerSet, boolean z) {
        AppMethodBeat.i(52990);
        if (emotionBannerSet == null) {
            ab.i("MicroMsg.emoji.EmojiUINavigatorMgr", "banner is null. do nothing");
            AppMethodBeat.o(52990);
            return;
        }
        switch (emotionBannerSet.SetType) {
            case 0:
                ab.i("MicroMsg.emoji.EmojiUINavigatorMgr", "MM_EMOTION_BANNER_SET_NULL do nothing");
                h.pYm.e(13223, Integer.valueOf(1), Integer.valueOf(emotionBannerSet.ID), emotionBannerSet.Title, Integer.valueOf(0), Integer.valueOf(0));
                AppMethodBeat.o(52990);
                return;
            case 1:
                if (z) {
                    a(context, emotionBannerSet, 15, 8);
                } else {
                    a(context, emotionBannerSet, 3, 5);
                }
                h.pYm.e(13223, Integer.valueOf(1), Integer.valueOf(emotionBannerSet.ID), emotionBannerSet.Title, Integer.valueOf(0), Integer.valueOf(4));
                AppMethodBeat.o(52990);
                return;
            case 2:
                s(context, emotionBannerSet.LocateUrl, emotionBannerSet.Title);
                h.pYm.e(13223, Integer.valueOf(1), Integer.valueOf(emotionBannerSet.ID), emotionBannerSet.Title, Integer.valueOf(0), Integer.valueOf(3));
                AppMethodBeat.o(52990);
                return;
            case 3:
                a(context, emotionBannerSet.ID, emotionBannerSet.Title, emotionBannerSet.Desc, emotionBannerSet.IconUrl, emotionBannerSet.SecondUrl, z);
                h.pYm.e(13223, Integer.valueOf(1), Integer.valueOf(emotionBannerSet.ID), emotionBannerSet.Title, Integer.valueOf(0), Integer.valueOf(2));
                AppMethodBeat.o(52990);
                return;
            case 4:
                a(context, emotionBannerSet.ID, emotionBannerSet.Title, emotionBannerSet.Desc, emotionBannerSet.IconUrl, emotionBannerSet.SecondUrl);
                h.pYm.e(13223, Integer.valueOf(1), Integer.valueOf(emotionBannerSet.ID), emotionBannerSet.Title, Integer.valueOf(0), Integer.valueOf(1));
                AppMethodBeat.o(52990);
                return;
            default:
                ab.i("MicroMsg.emoji.EmojiUINavigatorMgr", "Unkown type do nothing. SetType:%d", Integer.valueOf(emotionBannerSet.SetType));
                AppMethodBeat.o(52990);
                return;
        }
    }

    private static void a(Context context, int i, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(52991);
        Intent intent = new Intent();
        intent.putExtra("set_id", i);
        intent.putExtra("headurl", str4);
        intent.putExtra("set_title", str);
        intent.putExtra("set_iconURL", str3);
        intent.putExtra("set_desc", str2);
        intent.setClass(context, EmojiStoreV2SingleProductUI.class);
        context.startActivity(intent);
        AppMethodBeat.o(52991);
    }

    private static void a(Context context, int i, String str, String str2, String str3, String str4, boolean z) {
        AppMethodBeat.i(52992);
        Intent intent = new Intent();
        intent.setClass(context, EmojiStoreTopicUI.class);
        intent.putExtra("topic_id", i);
        intent.putExtra("topic_name", str);
        intent.putExtra("topic_ad_url", str4);
        intent.putExtra("topic_icon_url", str3);
        intent.putExtra("topic_desc", str2);
        if (z) {
            intent.putExtra("extra_scence", 15);
        } else {
            intent.putExtra("extra_scence", 3);
        }
        context.startActivity(intent);
        AppMethodBeat.o(52992);
    }

    private static void s(Context context, String str, String str2) {
        AppMethodBeat.i(52993);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("title", str2);
        b.gkE.i(intent, context);
        AppMethodBeat.o(52993);
    }
}
