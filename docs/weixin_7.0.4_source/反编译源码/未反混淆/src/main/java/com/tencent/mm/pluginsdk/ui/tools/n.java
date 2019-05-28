package com.tencent.mm.pluginsdk.ui.tools;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.MMFragment;
import java.io.File;

public final class n {
    private static String filePath = null;

    public static boolean a(Fragment fragment, Intent intent, String str, int i) {
        AppMethodBeat.i(70366);
        ab.i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 707, 4, "MicroMsg.TakePhotoUtil")));
        SightParams sightParams = new SightParams(1, i);
        String ug = t.ug(str);
        o.all();
        String uh = t.uh(ug);
        o.all();
        sightParams.q(ug, uh, t.ui(ug), e.euR + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
        intent.putExtra("KEY_SIGHT_PARAMS", sightParams);
        d.a(fragment, "mmsight", ".ui.SightCaptureUI", intent, 226);
        fragment.getActivity().overridePendingTransition(R.anim.d9, -1);
        AppMethodBeat.o(70366);
        return true;
    }

    public static boolean G(Context context, Intent intent) {
        AppMethodBeat.i(70367);
        boolean d = d(context, intent, "");
        AppMethodBeat.o(70367);
        return d;
    }

    public static boolean c(Context context, Intent intent, String str) {
        AppMethodBeat.i(139169);
        boolean d = d(context, intent, str);
        AppMethodBeat.o(139169);
        return d;
    }

    public static boolean a(Context context, int i, Intent intent, int i2, int i3) {
        AppMethodBeat.i(70369);
        boolean a = a(context, i, intent, i2, "", i3, "");
        AppMethodBeat.o(70369);
        return a;
    }

    private static boolean d(Context context, Intent intent, String str) {
        AppMethodBeat.i(70370);
        boolean a = a(context, 17, intent, 2, "", 0, str);
        AppMethodBeat.o(70370);
        return a;
    }

    public static boolean e(Context context, Intent intent, String str) {
        AppMethodBeat.i(70371);
        boolean a = a(context, 8, intent, 1, str, 0, "");
        AppMethodBeat.o(70371);
        return a;
    }

    private static boolean a(Context context, int i, Intent intent, int i2, String str, int i3, String str2) {
        AppMethodBeat.i(70372);
        ab.i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 707, 4, "MicroMsg.TakePhotoUtil")));
        SightParams sightParams = null;
        if (intent != null) {
            sightParams = (SightParams) intent.getParcelableExtra("KEY_SIGHT_PARAMS");
        }
        if (sightParams == null) {
            sightParams = new SightParams(i2, i3);
        }
        sightParams.osR = str2;
        if (i2 == 1) {
            String ug = t.ug(str);
            o.all();
            String uh = t.uh(ug);
            o.all();
            sightParams.q(ug, uh, t.ui(ug), e.euR + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
        }
        if (sightParams == null) {
            ab.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
        } else {
            intent.putExtra("KEY_SIGHT_PARAMS", sightParams);
        }
        d.b(context, "mmsight", ".ui.SightCaptureUI", intent, i);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(R.anim.d9, -1);
        }
        AppMethodBeat.o(70372);
        return true;
    }

    private static boolean g(Context context, Intent intent, String str) {
        AppMethodBeat.i(70374);
        SightParams sightParams = null;
        if (intent != null) {
            sightParams = (SightParams) intent.getParcelableExtra("KEY_SIGHT_PARAMS");
        }
        if (sightParams == null) {
            sightParams = new SightParams(2, 0);
        }
        sightParams.osR = str;
        if (sightParams == null) {
            ab.e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
        } else {
            String str2 = sightParams.osR;
            if (bo.isNullOrNil(str2)) {
                str2 = bo.anU() + "_" + bo.Mb(5);
            }
            ab.d("MicroMsg.TakePhotoUtil", "weishi_url = %s", new StringBuilder("weishi://camera?forceNoShowLogin=1").toString());
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(r1.toString()));
            intent.setPackage("com.tencent.weishi");
            intent.setFlags(268435456);
            context.getSharedPreferences("opensdk_shareTicket", 0).edit().putString(intent.getPackage(), str2).apply();
        }
        try {
            context.startActivity(intent);
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(R.anim.d9, -1);
            }
        } catch (Exception e) {
            ab.w("MicroMsg.TakePhotoUtil", "takeWeishiSight Exception: %s", e.getMessage());
        }
        AppMethodBeat.o(70374);
        return true;
    }

    public static boolean a(MMFragment mMFragment, String str, String str2) {
        AppMethodBeat.i(70375);
        ab.i("MicroMsg.TakePhotoUtil", "takePhoto(), dir = [%s], filename = [%s], cmd = [%s], result = [%s]", str, str2, Integer.valueOf(201), Boolean.valueOf(b(mMFragment, str, str2)));
        AppMethodBeat.o(70375);
        return b(mMFragment, str, str2);
    }

    private static boolean b(MMFragment mMFragment, String str, String str2) {
        AppMethodBeat.i(70376);
        if (mMFragment == null) {
            ab.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys fragment is null!");
            AppMethodBeat.o(70376);
            return false;
        } else if (a.bI(mMFragment.getContext()) || a.bH(mMFragment.getContext())) {
            AppMethodBeat.o(70376);
            return false;
        } else {
            filePath = str + str2;
            ab.i("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), filePath = " + filePath);
            bE(mMFragment.getContext(), filePath);
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.mkdirs();
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.TakePhotoUtil", e, "", new Object[0]);
                }
            }
            if (file.exists()) {
                intent.putExtra("output", k.d(mMFragment.getContext(), new File(filePath)));
                try {
                    mMFragment.startActivityForResult(intent, 201);
                    AppMethodBeat.o(70376);
                    return true;
                } catch (ActivityNotFoundException e2) {
                    ab.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), " + e2.getMessage());
                    AppMethodBeat.o(70376);
                    return false;
                }
            }
            ab.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), dir not exist. ".concat(String.valueOf(str)));
            AppMethodBeat.o(70376);
            return false;
        }
    }

    public static boolean c(Activity activity, String str, String str2, int i) {
        AppMethodBeat.i(70377);
        ab.i("MicroMsg.TakePhotoUtil", "takePhoto(), dir = [%s], filename = [%s], cmd = [%s], result = [%s]", str, str2, Integer.valueOf(i), Boolean.valueOf(d(activity, str, str2, i)));
        AppMethodBeat.o(70377);
        return d(activity, str, str2, i);
    }

    private static boolean d(Activity activity, String str, String str2, int i) {
        AppMethodBeat.i(70378);
        if (a.bI(activity) || a.bH(activity)) {
            AppMethodBeat.o(70378);
            return false;
        }
        int startPerformance = WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 707, 4, "MicroMsg.TakePhotoUtil");
        ab.i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", Integer.valueOf(startPerformance));
        filePath = str + str2;
        ab.i("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), filePath = " + filePath);
        bE(activity, filePath);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.TakePhotoUtil", e, "", new Object[0]);
            }
        }
        if (file.exists()) {
            intent.putExtra("output", k.d((Context) activity, new File(filePath)));
            try {
                activity.startActivityForResult(intent, i);
                AppMethodBeat.o(70378);
                return true;
            } catch (Exception e2) {
                ab.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), " + e2.getMessage());
                AppMethodBeat.o(70378);
                return false;
            }
        }
        ab.e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), dir not exist. ".concat(String.valueOf(str)));
        AppMethodBeat.o(70378);
        return false;
    }

    private static void bE(Context context, String str) {
        AppMethodBeat.i(70379);
        Editor edit = context.getSharedPreferences("system_config_prefs", 0).edit();
        edit.putString("camera_file_path", str);
        edit.commit();
        AppMethodBeat.o(70379);
    }

    public static boolean a(Activity activity, int i, Intent intent) {
        AppMethodBeat.i(70380);
        a(activity, i, 1, 0, intent);
        AppMethodBeat.o(70380);
        return true;
    }

    public static boolean aj(Activity activity) {
        AppMethodBeat.i(70381);
        a(activity, 2, 1, 0, 1, null);
        AppMethodBeat.o(70381);
        return true;
    }

    public static boolean ak(Activity activity) {
        AppMethodBeat.i(70382);
        a(activity, 205, 1, 11, null);
        AppMethodBeat.o(70382);
        return true;
    }

    public static boolean e(Fragment fragment) {
        AppMethodBeat.i(70383);
        a(fragment, 200, 1, 0, 1, "", "");
        AppMethodBeat.o(70383);
        return true;
    }

    public static boolean k(Activity activity, int i) {
        AppMethodBeat.i(70384);
        a(activity, i, 1, 5, null);
        AppMethodBeat.o(70384);
        return true;
    }

    public static void a(Fragment fragment, int i, String str, String str2) {
        AppMethodBeat.i(70385);
        a(fragment, 217, 9, i, 1, str, str2);
        AppMethodBeat.o(70385);
    }

    public static void b(Fragment fragment, int i, String str, String str2) {
        AppMethodBeat.i(70386);
        a(fragment, 217, 9, i, 3, str, str2);
        AppMethodBeat.o(70386);
    }

    public static void a(Activity activity, int i, int i2, int i3, Intent intent) {
        AppMethodBeat.i(70387);
        Intent intent2 = new Intent();
        if (intent != null) {
            intent2.putExtras(intent.getExtras());
        }
        intent2.putExtra("max_select_count", i2);
        intent2.putExtra("query_source_type", i3);
        intent2.addFlags(67108864);
        d.b((Context) activity, "gallery", ".ui.GalleryEntryUI", intent2, i);
        AppMethodBeat.o(70387);
    }

    public static void a(Activity activity, int i, int i2, int i3, int i4, Intent intent) {
        AppMethodBeat.i(70388);
        Intent intent2 = new Intent();
        if (intent != null) {
            intent2.putExtras(intent.getExtras());
        }
        intent2.putExtra("max_select_count", i2);
        intent2.putExtra("query_source_type", i3);
        intent2.putExtra("query_media_type", i4);
        intent2.putExtra("show_header_view", false);
        intent2.addFlags(67108864);
        d.b((Context) activity, "gallery", ".ui.GalleryEntryUI", intent2, i);
        AppMethodBeat.o(70388);
    }

    private static void a(Fragment fragment, int i, int i2, int i3, int i4, String str, String str2) {
        AppMethodBeat.i(70389);
        ab.i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 706, 4, "MicroMsg.TakePhotoUtil")));
        Intent intent = new Intent();
        if (!bo.isNullOrNil(str2)) {
            intent.putExtra("GalleryUI_FromUser", str);
            intent.putExtra("GalleryUI_ToUser", str2);
        }
        intent.putExtra("max_select_count", i2);
        intent.putExtra("query_source_type", i3);
        intent.putExtra("query_media_type", i4);
        if (ae.gjt) {
            intent.putExtra("show_header_view", true);
        } else {
            intent.putExtra("show_header_view", false);
        }
        intent.addFlags(67108864);
        d.a(fragment, "gallery", ".ui.AlbumPreviewUI", intent, i);
        AppMethodBeat.o(70389);
    }

    public static void e(Activity activity, int i, int i2, Intent intent) {
        AppMethodBeat.i(70390);
        intent.putExtra("max_select_count", i);
        intent.putExtra("query_media_type", 2);
        intent.putExtra("query_source_type", i2);
        intent.addFlags(67108864);
        d.b((Context) activity, "gallery", ".ui.GalleryEntryUI", intent, 4);
        AppMethodBeat.o(70390);
    }

    public static void a(Activity activity, String str, int i, int i2, int i3, boolean z) {
        AppMethodBeat.i(70391);
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        Intent intent = new Intent();
        intent.putExtra("output", k.d((Context) activity, file));
        intent.putExtra("android.intent.extra.videoQuality", i3);
        intent.putExtra("android.intent.extras.CAMERA_FACING", z ? 1 : 0);
        if (i2 > 0) {
            intent.putExtra("android.intent.extra.durationLimit", i2);
        }
        intent.setAction("android.media.action.VIDEO_CAPTURE");
        intent.addCategory("android.intent.category.DEFAULT");
        activity.startActivityForResult(intent, i);
        AppMethodBeat.o(70391);
    }

    public static String h(Context context, Intent intent, String str) {
        AppMethodBeat.i(70392);
        if (filePath == null) {
            filePath = context.getSharedPreferences("system_config_prefs", 0).getString("camera_file_path", null);
        }
        if (filePath == null || !com.tencent.mm.a.e.ct(filePath)) {
            filePath = com.tencent.mm.ui.tools.a.i(context, intent, str);
        }
        com.tencent.mm.sdk.f.a.a(filePath, context);
        String str2 = filePath;
        AppMethodBeat.o(70392);
        return str2;
    }

    public static void j(String str, Context context) {
        AppMethodBeat.i(70393);
        q.a(str, context, R.string.cdd);
        AppMethodBeat.o(70393);
    }

    @Deprecated
    public static String RL(String str) {
        AppMethodBeat.i(70394);
        String RL = com.tencent.mm.sdk.f.a.RL(str);
        AppMethodBeat.o(70394);
        return RL;
    }

    public static boolean f(Context context, Intent intent, String str) {
        AppMethodBeat.i(70373);
        boolean g = g(context, intent, str);
        AppMethodBeat.o(70373);
        return g;
    }

    public static void a(String str, Context context) {
        AppMethodBeat.i(139170);
        com.tencent.mm.sdk.f.a.a(str, context);
        AppMethodBeat.o(139170);
    }

    @TargetApi(8)
    public static String dly() {
        return e.euR;
    }

    public static String dlz() {
        AppMethodBeat.i(70396);
        String dlz = com.tencent.mm.sdk.f.a.dlz();
        AppMethodBeat.o(70396);
        return dlz;
    }
}
