package com.tencent.p177mm.plugin.emoji.p947e;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.emoji.C42935b;
import com.tencent.p177mm.plugin.emoji.p384ui.EmojiStoreDetailUI;
import com.tencent.p177mm.plugin.emoji.p384ui.EmojiStoreTopicUI;
import com.tencent.p177mm.plugin.emoji.p384ui.p385v2.EmojiStoreV2SingleProductUI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.p177mm.protocal.protobuf.EmotionSummary;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.emoji.e.m */
public final class C11553m {
    /* renamed from: a */
    public static void m19375a(Context context, EmotionSummary emotionSummary, int i, int i2, int i3, String str, int i4) {
        AppMethodBeat.m2504i(52988);
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
            if (!C5046bo.isNullOrNil(str)) {
                intent.putExtra("to_talker_name", str);
            }
        } else {
            C4990ab.m7416i("MicroMsg.emoji.EmojiUINavigatorMgr", "get detail intent failed. summary is null.");
        }
        context.startActivity(intent);
        AppMethodBeat.m2505o(52988);
    }

    /* renamed from: a */
    private static void m19373a(Context context, EmotionBannerSet emotionBannerSet, int i, int i2) {
        AppMethodBeat.m2504i(52989);
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
        AppMethodBeat.m2505o(52989);
    }

    /* renamed from: a */
    public static void m19374a(Context context, EmotionBannerSet emotionBannerSet, boolean z) {
        AppMethodBeat.m2504i(52990);
        if (emotionBannerSet == null) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiUINavigatorMgr", "banner is null. do nothing");
            AppMethodBeat.m2505o(52990);
            return;
        }
        switch (emotionBannerSet.SetType) {
            case 0:
                C4990ab.m7416i("MicroMsg.emoji.EmojiUINavigatorMgr", "MM_EMOTION_BANNER_SET_NULL do nothing");
                C7060h.pYm.mo8381e(13223, Integer.valueOf(1), Integer.valueOf(emotionBannerSet.f15073ID), emotionBannerSet.Title, Integer.valueOf(0), Integer.valueOf(0));
                AppMethodBeat.m2505o(52990);
                return;
            case 1:
                if (z) {
                    C11553m.m19373a(context, emotionBannerSet, 15, 8);
                } else {
                    C11553m.m19373a(context, emotionBannerSet, 3, 5);
                }
                C7060h.pYm.mo8381e(13223, Integer.valueOf(1), Integer.valueOf(emotionBannerSet.f15073ID), emotionBannerSet.Title, Integer.valueOf(0), Integer.valueOf(4));
                AppMethodBeat.m2505o(52990);
                return;
            case 2:
                C11553m.m19376s(context, emotionBannerSet.LocateUrl, emotionBannerSet.Title);
                C7060h.pYm.mo8381e(13223, Integer.valueOf(1), Integer.valueOf(emotionBannerSet.f15073ID), emotionBannerSet.Title, Integer.valueOf(0), Integer.valueOf(3));
                AppMethodBeat.m2505o(52990);
                return;
            case 3:
                C11553m.m19372a(context, emotionBannerSet.f15073ID, emotionBannerSet.Title, emotionBannerSet.Desc, emotionBannerSet.IconUrl, emotionBannerSet.SecondUrl, z);
                C7060h.pYm.mo8381e(13223, Integer.valueOf(1), Integer.valueOf(emotionBannerSet.f15073ID), emotionBannerSet.Title, Integer.valueOf(0), Integer.valueOf(2));
                AppMethodBeat.m2505o(52990);
                return;
            case 4:
                C11553m.m19371a(context, emotionBannerSet.f15073ID, emotionBannerSet.Title, emotionBannerSet.Desc, emotionBannerSet.IconUrl, emotionBannerSet.SecondUrl);
                C7060h.pYm.mo8381e(13223, Integer.valueOf(1), Integer.valueOf(emotionBannerSet.f15073ID), emotionBannerSet.Title, Integer.valueOf(0), Integer.valueOf(1));
                AppMethodBeat.m2505o(52990);
                return;
            default:
                C4990ab.m7417i("MicroMsg.emoji.EmojiUINavigatorMgr", "Unkown type do nothing. SetType:%d", Integer.valueOf(emotionBannerSet.SetType));
                AppMethodBeat.m2505o(52990);
                return;
        }
    }

    /* renamed from: a */
    private static void m19371a(Context context, int i, String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(52991);
        Intent intent = new Intent();
        intent.putExtra("set_id", i);
        intent.putExtra("headurl", str4);
        intent.putExtra("set_title", str);
        intent.putExtra("set_iconURL", str3);
        intent.putExtra("set_desc", str2);
        intent.setClass(context, EmojiStoreV2SingleProductUI.class);
        context.startActivity(intent);
        AppMethodBeat.m2505o(52991);
    }

    /* renamed from: a */
    private static void m19372a(Context context, int i, String str, String str2, String str3, String str4, boolean z) {
        AppMethodBeat.m2504i(52992);
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
        AppMethodBeat.m2505o(52992);
    }

    /* renamed from: s */
    private static void m19376s(Context context, String str, String str2) {
        AppMethodBeat.m2504i(52993);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("title", str2);
        C42935b.gkE.mo38924i(intent, context);
        AppMethodBeat.m2505o(52993);
    }
}
