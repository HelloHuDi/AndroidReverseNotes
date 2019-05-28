package com.tencent.p177mm.plugin.story.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.story.api.n */
public final class C46270n {
    /* renamed from: n */
    public static void m86708n(Context context, long j) {
        AppMethodBeat.m2504i(56483);
        C46270n.m86704a(context, 1, j, -1);
        AppMethodBeat.m2505o(56483);
    }

    public static boolean isShowStoryCheck() {
        AppMethodBeat.m2504i(56484);
        boolean isShowStoryCheck = ((C35168e) C1720g.m3530M(C35168e.class)).isShowStoryCheck();
        AppMethodBeat.m2505o(56484);
        return isShowStoryCheck;
    }

    public static boolean cxe() {
        boolean z;
        AppMethodBeat.m2504i(56485);
        if (((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("StoryOpenRoomSync", 1) == 2) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("LaunchStory", "isOpenRoomSync %s", Boolean.valueOf(z));
        if (z) {
            AppMethodBeat.m2505o(56485);
            return false;
        }
        AppMethodBeat.m2505o(56485);
        return true;
    }

    public static boolean cxf() {
        boolean z;
        AppMethodBeat.m2504i(56486);
        if (((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("StoryOpenStrangerUserPage", 1) == 2) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("LaunchStory", "isOpenRoomSync %s", Boolean.valueOf(z));
        if (z) {
            AppMethodBeat.m2505o(56486);
            return false;
        }
        AppMethodBeat.m2505o(56486);
        return true;
    }

    /* renamed from: aT */
    public static void m86706aT(Context context, String str) {
        AppMethodBeat.m2504i(56488);
        try {
            Intent intent = new Intent(context, Class.forName("com.tencent.mm.plugin.story.ui.StoryBrowseUI"));
            intent.putExtra("username", str);
            context.startActivity(intent);
            AppMethodBeat.m2505o(56488);
        } catch (ClassNotFoundException e) {
            C4990ab.printErrStackTrace("LaunchStory", e, "startStoryBrowse failed", new Object[0]);
            AppMethodBeat.m2505o(56488);
        }
    }

    /* renamed from: ZX */
    public static void m86703ZX(String str) {
        AppMethodBeat.m2504i(56489);
        ((C35168e) C1720g.m3530M(C35168e.class)).preLoadVideoViewMgr(str);
        AppMethodBeat.m2505o(56489);
    }

    /* renamed from: bj */
    public static void m86707bj(int i, String str) {
        AppMethodBeat.m2504i(56490);
        ((C35168e) C1720g.m3530M(C35168e.class)).checkReportFromChatting(i, str);
        AppMethodBeat.m2505o(56490);
    }

    public static void enterGallery(List<String> list) {
        AppMethodBeat.m2504i(56491);
        ((C35168e) C1720g.m3530M(C35168e.class)).enterGallery(list);
        AppMethodBeat.m2505o(56491);
    }

    /* renamed from: a */
    public static void m86705a(Context context, List<String> list, String str, String str2) {
        AppMethodBeat.m2504i(56492);
        try {
            ArrayList arrayList = new ArrayList(list);
            Intent intent = new Intent(context, Class.forName("com.tencent.mm.plugin.story.ui.StoryBrowseUI"));
            intent.putExtra("user_list", arrayList);
            intent.putExtra("delete_when_first_empty", false);
            intent.putExtra("gallery_chat_room", str);
            intent.putExtra("gallery_session_id", str2);
            context.startActivity(intent);
            AppMethodBeat.m2505o(56492);
        } catch (ClassNotFoundException e) {
            C4990ab.printErrStackTrace("LaunchStory", e, "startStoryBrowse failed", new Object[0]);
            AppMethodBeat.m2505o(56492);
        }
    }

    /* renamed from: a */
    public static void m86704a(Context context, int i, long j, int i2) {
        AppMethodBeat.m2504i(56487);
        if (C35973a.m59178bI(context) || C35973a.m59179bJ(context) || C35973a.m59177bH(context)) {
            C4990ab.m7416i("LaunchStory", "startStoryCapture, voip or multitalk running");
            AppMethodBeat.m2505o(56487);
            return;
        }
        if (context instanceof Activity) {
            if (!C35805b.m58707a((Activity) context, "android.permission.CAMERA", 24, "", "")) {
                AppMethodBeat.m2505o(56487);
                return;
            } else if (!C35805b.m58707a((Activity) context, "android.permission.RECORD_AUDIO", 24, "", "")) {
                AppMethodBeat.m2505o(56487);
                return;
            } else if (!C35805b.m58707a((Activity) context, "android.permission.ACCESS_COARSE_LOCATION", 78, "", "")) {
                AppMethodBeat.m2505o(56487);
                return;
            }
        }
        C4990ab.m7417i("LaunchStory", "startStoryCapture %s", C5046bo.dpG().toString());
        try {
            Intent intent = new Intent(context, Class.forName("com.tencent.mm.plugin.story.ui.StoryCaptureUI"));
            intent.putExtra("jump_page_from", i);
            intent.putExtra("video_object_id", j);
            if (!(context instanceof Activity) || i2 < 0) {
                context.startActivity(intent);
                AppMethodBeat.m2505o(56487);
                return;
            }
            ((Activity) context).startActivityForResult(intent, i2);
            AppMethodBeat.m2505o(56487);
        } catch (ClassNotFoundException e) {
            C4990ab.printErrStackTrace("LaunchStory", e, "startStoryCapture failed", new Object[0]);
            AppMethodBeat.m2505o(56487);
        }
    }
}
