package com.tencent.mm.plugin.story.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class n {
    public static void n(Context context, long j) {
        AppMethodBeat.i(56483);
        a(context, 1, j, -1);
        AppMethodBeat.o(56483);
    }

    public static boolean isShowStoryCheck() {
        AppMethodBeat.i(56484);
        boolean isShowStoryCheck = ((e) g.M(e.class)).isShowStoryCheck();
        AppMethodBeat.o(56484);
        return isShowStoryCheck;
    }

    public static boolean cxe() {
        boolean z;
        AppMethodBeat.i(56485);
        if (((a) g.K(a.class)).Nu().getInt("StoryOpenRoomSync", 1) == 2) {
            z = true;
        } else {
            z = false;
        }
        ab.i("LaunchStory", "isOpenRoomSync %s", Boolean.valueOf(z));
        if (z) {
            AppMethodBeat.o(56485);
            return false;
        }
        AppMethodBeat.o(56485);
        return true;
    }

    public static boolean cxf() {
        boolean z;
        AppMethodBeat.i(56486);
        if (((a) g.K(a.class)).Nu().getInt("StoryOpenStrangerUserPage", 1) == 2) {
            z = true;
        } else {
            z = false;
        }
        ab.i("LaunchStory", "isOpenRoomSync %s", Boolean.valueOf(z));
        if (z) {
            AppMethodBeat.o(56486);
            return false;
        }
        AppMethodBeat.o(56486);
        return true;
    }

    public static void aT(Context context, String str) {
        AppMethodBeat.i(56488);
        try {
            Intent intent = new Intent(context, Class.forName("com.tencent.mm.plugin.story.ui.StoryBrowseUI"));
            intent.putExtra("username", str);
            context.startActivity(intent);
            AppMethodBeat.o(56488);
        } catch (ClassNotFoundException e) {
            ab.printErrStackTrace("LaunchStory", e, "startStoryBrowse failed", new Object[0]);
            AppMethodBeat.o(56488);
        }
    }

    public static void ZX(String str) {
        AppMethodBeat.i(56489);
        ((e) g.M(e.class)).preLoadVideoViewMgr(str);
        AppMethodBeat.o(56489);
    }

    public static void bj(int i, String str) {
        AppMethodBeat.i(56490);
        ((e) g.M(e.class)).checkReportFromChatting(i, str);
        AppMethodBeat.o(56490);
    }

    public static void enterGallery(List<String> list) {
        AppMethodBeat.i(56491);
        ((e) g.M(e.class)).enterGallery(list);
        AppMethodBeat.o(56491);
    }

    public static void a(Context context, List<String> list, String str, String str2) {
        AppMethodBeat.i(56492);
        try {
            ArrayList arrayList = new ArrayList(list);
            Intent intent = new Intent(context, Class.forName("com.tencent.mm.plugin.story.ui.StoryBrowseUI"));
            intent.putExtra("user_list", arrayList);
            intent.putExtra("delete_when_first_empty", false);
            intent.putExtra("gallery_chat_room", str);
            intent.putExtra("gallery_session_id", str2);
            context.startActivity(intent);
            AppMethodBeat.o(56492);
        } catch (ClassNotFoundException e) {
            ab.printErrStackTrace("LaunchStory", e, "startStoryBrowse failed", new Object[0]);
            AppMethodBeat.o(56492);
        }
    }

    public static void a(Context context, int i, long j, int i2) {
        AppMethodBeat.i(56487);
        if (com.tencent.mm.r.a.bI(context) || com.tencent.mm.r.a.bJ(context) || com.tencent.mm.r.a.bH(context)) {
            ab.i("LaunchStory", "startStoryCapture, voip or multitalk running");
            AppMethodBeat.o(56487);
            return;
        }
        if (context instanceof Activity) {
            if (!b.a((Activity) context, "android.permission.CAMERA", 24, "", "")) {
                AppMethodBeat.o(56487);
                return;
            } else if (!b.a((Activity) context, "android.permission.RECORD_AUDIO", 24, "", "")) {
                AppMethodBeat.o(56487);
                return;
            } else if (!b.a((Activity) context, "android.permission.ACCESS_COARSE_LOCATION", 78, "", "")) {
                AppMethodBeat.o(56487);
                return;
            }
        }
        ab.i("LaunchStory", "startStoryCapture %s", bo.dpG().toString());
        try {
            Intent intent = new Intent(context, Class.forName("com.tencent.mm.plugin.story.ui.StoryCaptureUI"));
            intent.putExtra("jump_page_from", i);
            intent.putExtra("video_object_id", j);
            if (!(context instanceof Activity) || i2 < 0) {
                context.startActivity(intent);
                AppMethodBeat.o(56487);
                return;
            }
            ((Activity) context).startActivityForResult(intent, i2);
            AppMethodBeat.o(56487);
        } catch (ClassNotFoundException e) {
            ab.printErrStackTrace("LaunchStory", e, "startStoryCapture failed", new Object[0]);
            AppMethodBeat.o(56487);
        }
    }
}
