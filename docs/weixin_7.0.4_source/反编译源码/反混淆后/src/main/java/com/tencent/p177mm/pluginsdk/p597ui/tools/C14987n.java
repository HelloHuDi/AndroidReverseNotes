package com.tencent.p177mm.pluginsdk.p597ui.tools;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.support.p057v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.tools.C36338a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.platformtools.C45477q;
import com.tencent.p177mm.plugin.mmsight.SightParams;
import com.tencent.p177mm.sdk.p1574f.C40612a;
import com.tencent.p177mm.sdk.platformtools.C15429k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.n */
public final class C14987n {
    private static String filePath = null;

    /* renamed from: a */
    public static boolean m23304a(Fragment fragment, Intent intent, String str, int i) {
        AppMethodBeat.m2504i(70366);
        C4990ab.m7417i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 707, 4, "MicroMsg.TakePhotoUtil")));
        SightParams sightParams = new SightParams(1, i);
        String ug = C9720t.m17302ug(str);
        C37961o.all();
        String uh = C9720t.m17303uh(ug);
        C37961o.all();
        sightParams.mo36644q(ug, uh, C9720t.m17304ui(ug), C6457e.euR + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
        intent.putExtra("KEY_SIGHT_PARAMS", sightParams);
        C25985d.m41458a(fragment, "mmsight", ".ui.SightCaptureUI", intent, 226);
        fragment.getActivity().overridePendingTransition(C25738R.anim.f8398d9, -1);
        AppMethodBeat.m2505o(70366);
        return true;
    }

    /* renamed from: G */
    public static boolean m23293G(Context context, Intent intent) {
        AppMethodBeat.m2504i(70367);
        boolean d = C14987n.m23314d(context, intent, "");
        AppMethodBeat.m2505o(70367);
        return d;
    }

    /* renamed from: c */
    public static boolean m23312c(Context context, Intent intent, String str) {
        AppMethodBeat.m2504i(139169);
        boolean d = C14987n.m23314d(context, intent, str);
        AppMethodBeat.m2505o(139169);
        return d;
    }

    /* renamed from: a */
    public static boolean m23302a(Context context, int i, Intent intent, int i2, int i3) {
        AppMethodBeat.m2504i(70369);
        boolean a = C14987n.m23303a(context, i, intent, i2, "", i3, "");
        AppMethodBeat.m2505o(70369);
        return a;
    }

    /* renamed from: d */
    private static boolean m23314d(Context context, Intent intent, String str) {
        AppMethodBeat.m2504i(70370);
        boolean a = C14987n.m23303a(context, 17, intent, 2, "", 0, str);
        AppMethodBeat.m2505o(70370);
        return a;
    }

    /* renamed from: e */
    public static boolean m23316e(Context context, Intent intent, String str) {
        AppMethodBeat.m2504i(70371);
        boolean a = C14987n.m23303a(context, 8, intent, 1, str, 0, "");
        AppMethodBeat.m2505o(70371);
        return a;
    }

    /* renamed from: a */
    private static boolean m23303a(Context context, int i, Intent intent, int i2, String str, int i3, String str2) {
        AppMethodBeat.m2504i(70372);
        C4990ab.m7417i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 707, 4, "MicroMsg.TakePhotoUtil")));
        SightParams sightParams = null;
        if (intent != null) {
            sightParams = (SightParams) intent.getParcelableExtra("KEY_SIGHT_PARAMS");
        }
        if (sightParams == null) {
            sightParams = new SightParams(i2, i3);
        }
        sightParams.osR = str2;
        if (i2 == 1) {
            String ug = C9720t.m17302ug(str);
            C37961o.all();
            String uh = C9720t.m17303uh(ug);
            C37961o.all();
            sightParams.mo36644q(ug, uh, C9720t.m17304ui(ug), C6457e.euR + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
        }
        if (sightParams == null) {
            C4990ab.m7412e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
        } else {
            intent.putExtra("KEY_SIGHT_PARAMS", sightParams);
        }
        C25985d.m41468b(context, "mmsight", ".ui.SightCaptureUI", intent, i);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(C25738R.anim.f8398d9, -1);
        }
        AppMethodBeat.m2505o(70372);
        return true;
    }

    /* renamed from: g */
    private static boolean m23319g(Context context, Intent intent, String str) {
        AppMethodBeat.m2504i(70374);
        SightParams sightParams = null;
        if (intent != null) {
            sightParams = (SightParams) intent.getParcelableExtra("KEY_SIGHT_PARAMS");
        }
        if (sightParams == null) {
            sightParams = new SightParams(2, 0);
        }
        sightParams.osR = str;
        if (sightParams == null) {
            C4990ab.m7412e("MicroMsg.TakePhotoUtil", "videoParams takeMMSight is null");
        } else {
            String str2 = sightParams.osR;
            if (C5046bo.isNullOrNil(str2)) {
                str2 = C5046bo.anU() + "_" + C5046bo.m7507Mb(5);
            }
            C4990ab.m7411d("MicroMsg.TakePhotoUtil", "weishi_url = %s", new StringBuilder("weishi://camera?forceNoShowLogin=1").toString());
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(r1.toString()));
            intent.setPackage("com.tencent.weishi");
            intent.setFlags(268435456);
            context.getSharedPreferences("opensdk_shareTicket", 0).edit().putString(intent.getPackage(), str2).apply();
        }
        try {
            context.startActivity(intent);
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(C25738R.anim.f8398d9, -1);
            }
        } catch (Exception e) {
            C4990ab.m7421w("MicroMsg.TakePhotoUtil", "takeWeishiSight Exception: %s", e.getMessage());
        }
        AppMethodBeat.m2505o(70374);
        return true;
    }

    /* renamed from: a */
    public static boolean m23305a(MMFragment mMFragment, String str, String str2) {
        AppMethodBeat.m2504i(70375);
        C4990ab.m7417i("MicroMsg.TakePhotoUtil", "takePhoto(), dir = [%s], filename = [%s], cmd = [%s], result = [%s]", str, str2, Integer.valueOf(201), Boolean.valueOf(C14987n.m23309b(mMFragment, str, str2)));
        AppMethodBeat.m2505o(70375);
        return C14987n.m23309b(mMFragment, str, str2);
    }

    /* renamed from: b */
    private static boolean m23309b(MMFragment mMFragment, String str, String str2) {
        AppMethodBeat.m2504i(70376);
        if (mMFragment == null) {
            C4990ab.m7412e("MicroMsg.TakePhotoUtil", "takePhotoFromSys fragment is null!");
            AppMethodBeat.m2505o(70376);
            return false;
        } else if (C35973a.m59178bI(mMFragment.getContext()) || C35973a.m59177bH(mMFragment.getContext())) {
            AppMethodBeat.m2505o(70376);
            return false;
        } else {
            filePath = str + str2;
            C4990ab.m7416i("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), filePath = " + filePath);
            C14987n.m23310bE(mMFragment.getContext(), filePath);
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.mkdirs();
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.TakePhotoUtil", e, "", new Object[0]);
                }
            }
            if (file.exists()) {
                intent.putExtra("output", C15429k.m23714d(mMFragment.getContext(), new File(filePath)));
                try {
                    mMFragment.startActivityForResult(intent, 201);
                    AppMethodBeat.m2505o(70376);
                    return true;
                } catch (ActivityNotFoundException e2) {
                    C4990ab.m7412e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), " + e2.getMessage());
                    AppMethodBeat.m2505o(70376);
                    return false;
                }
            }
            C4990ab.m7412e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), dir not exist. ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(70376);
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m23311c(Activity activity, String str, String str2, int i) {
        AppMethodBeat.m2504i(70377);
        C4990ab.m7417i("MicroMsg.TakePhotoUtil", "takePhoto(), dir = [%s], filename = [%s], cmd = [%s], result = [%s]", str, str2, Integer.valueOf(i), Boolean.valueOf(C14987n.m23313d(activity, str, str2, i)));
        AppMethodBeat.m2505o(70377);
        return C14987n.m23313d(activity, str, str2, i);
    }

    /* renamed from: d */
    private static boolean m23313d(Activity activity, String str, String str2, int i) {
        AppMethodBeat.m2504i(70378);
        if (C35973a.m59178bI(activity) || C35973a.m59177bH(activity)) {
            AppMethodBeat.m2505o(70378);
            return false;
        }
        int startPerformance = WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 707, 4, "MicroMsg.TakePhotoUtil");
        C4990ab.m7417i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", Integer.valueOf(startPerformance));
        filePath = str + str2;
        C4990ab.m7416i("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), filePath = " + filePath);
        C14987n.m23310bE(activity, filePath);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.TakePhotoUtil", e, "", new Object[0]);
            }
        }
        if (file.exists()) {
            intent.putExtra("output", C15429k.m23714d((Context) activity, new File(filePath)));
            try {
                activity.startActivityForResult(intent, i);
                AppMethodBeat.m2505o(70378);
                return true;
            } catch (Exception e2) {
                C4990ab.m7412e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), " + e2.getMessage());
                AppMethodBeat.m2505o(70378);
                return false;
            }
        }
        C4990ab.m7412e("MicroMsg.TakePhotoUtil", "takePhotoFromSys(), dir not exist. ".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(70378);
        return false;
    }

    /* renamed from: bE */
    private static void m23310bE(Context context, String str) {
        AppMethodBeat.m2504i(70379);
        Editor edit = context.getSharedPreferences("system_config_prefs", 0).edit();
        edit.putString("camera_file_path", str);
        edit.commit();
        AppMethodBeat.m2505o(70379);
    }

    /* renamed from: a */
    public static boolean m23301a(Activity activity, int i, Intent intent) {
        AppMethodBeat.m2504i(70380);
        C14987n.m23296a(activity, i, 1, 0, intent);
        AppMethodBeat.m2505o(70380);
        return true;
    }

    /* renamed from: aj */
    public static boolean m23306aj(Activity activity) {
        AppMethodBeat.m2504i(70381);
        C14987n.m23295a(activity, 2, 1, 0, 1, null);
        AppMethodBeat.m2505o(70381);
        return true;
    }

    /* renamed from: ak */
    public static boolean m23307ak(Activity activity) {
        AppMethodBeat.m2504i(70382);
        C14987n.m23296a(activity, 205, 1, 11, null);
        AppMethodBeat.m2505o(70382);
        return true;
    }

    /* renamed from: e */
    public static boolean m23317e(Fragment fragment) {
        AppMethodBeat.m2504i(70383);
        C14987n.m23298a(fragment, 200, 1, 0, 1, "", "");
        AppMethodBeat.m2505o(70383);
        return true;
    }

    /* renamed from: k */
    public static boolean m23322k(Activity activity, int i) {
        AppMethodBeat.m2504i(70384);
        C14987n.m23296a(activity, i, 1, 5, null);
        AppMethodBeat.m2505o(70384);
        return true;
    }

    /* renamed from: a */
    public static void m23299a(Fragment fragment, int i, String str, String str2) {
        AppMethodBeat.m2504i(70385);
        C14987n.m23298a(fragment, 217, 9, i, 1, str, str2);
        AppMethodBeat.m2505o(70385);
    }

    /* renamed from: b */
    public static void m23308b(Fragment fragment, int i, String str, String str2) {
        AppMethodBeat.m2504i(70386);
        C14987n.m23298a(fragment, 217, 9, i, 3, str, str2);
        AppMethodBeat.m2505o(70386);
    }

    /* renamed from: a */
    public static void m23296a(Activity activity, int i, int i2, int i3, Intent intent) {
        AppMethodBeat.m2504i(70387);
        Intent intent2 = new Intent();
        if (intent != null) {
            intent2.putExtras(intent.getExtras());
        }
        intent2.putExtra("max_select_count", i2);
        intent2.putExtra("query_source_type", i3);
        intent2.addFlags(67108864);
        C25985d.m41468b((Context) activity, "gallery", ".ui.GalleryEntryUI", intent2, i);
        AppMethodBeat.m2505o(70387);
    }

    /* renamed from: a */
    public static void m23295a(Activity activity, int i, int i2, int i3, int i4, Intent intent) {
        AppMethodBeat.m2504i(70388);
        Intent intent2 = new Intent();
        if (intent != null) {
            intent2.putExtras(intent.getExtras());
        }
        intent2.putExtra("max_select_count", i2);
        intent2.putExtra("query_source_type", i3);
        intent2.putExtra("query_media_type", i4);
        intent2.putExtra("show_header_view", false);
        intent2.addFlags(67108864);
        C25985d.m41468b((Context) activity, "gallery", ".ui.GalleryEntryUI", intent2, i);
        AppMethodBeat.m2505o(70388);
    }

    /* renamed from: a */
    private static void m23298a(Fragment fragment, int i, int i2, int i3, int i4, String str, String str2) {
        AppMethodBeat.m2504i(70389);
        C4990ab.m7417i("MicroMsg.TakePhotoUtil", "summerhardcoder startPerformance[%s]", Integer.valueOf(WXHardCoderJNI.startPerformance(true, 0, 1, 1, 0, 2000, 706, 4, "MicroMsg.TakePhotoUtil")));
        Intent intent = new Intent();
        if (!C5046bo.isNullOrNil(str2)) {
            intent.putExtra("GalleryUI_FromUser", str);
            intent.putExtra("GalleryUI_ToUser", str2);
        }
        intent.putExtra("max_select_count", i2);
        intent.putExtra("query_source_type", i3);
        intent.putExtra("query_media_type", i4);
        if (C1947ae.gjt) {
            intent.putExtra("show_header_view", true);
        } else {
            intent.putExtra("show_header_view", false);
        }
        intent.addFlags(67108864);
        C25985d.m41458a(fragment, "gallery", ".ui.AlbumPreviewUI", intent, i);
        AppMethodBeat.m2505o(70389);
    }

    /* renamed from: e */
    public static void m23315e(Activity activity, int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(70390);
        intent.putExtra("max_select_count", i);
        intent.putExtra("query_media_type", 2);
        intent.putExtra("query_source_type", i2);
        intent.addFlags(67108864);
        C25985d.m41468b((Context) activity, "gallery", ".ui.GalleryEntryUI", intent, 4);
        AppMethodBeat.m2505o(70390);
    }

    /* renamed from: a */
    public static void m23297a(Activity activity, String str, int i, int i2, int i3, boolean z) {
        AppMethodBeat.m2504i(70391);
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        Intent intent = new Intent();
        intent.putExtra("output", C15429k.m23714d((Context) activity, file));
        intent.putExtra("android.intent.extra.videoQuality", i3);
        intent.putExtra("android.intent.extras.CAMERA_FACING", z ? 1 : 0);
        if (i2 > 0) {
            intent.putExtra("android.intent.extra.durationLimit", i2);
        }
        intent.setAction("android.media.action.VIDEO_CAPTURE");
        intent.addCategory("android.intent.category.DEFAULT");
        activity.startActivityForResult(intent, i);
        AppMethodBeat.m2505o(70391);
    }

    /* renamed from: h */
    public static String m23320h(Context context, Intent intent, String str) {
        AppMethodBeat.m2504i(70392);
        if (filePath == null) {
            filePath = context.getSharedPreferences("system_config_prefs", 0).getString("camera_file_path", null);
        }
        if (filePath == null || !C1173e.m2561ct(filePath)) {
            filePath = C36338a.m59824i(context, intent, str);
        }
        C40612a.m70043a(filePath, context);
        String str2 = filePath;
        AppMethodBeat.m2505o(70392);
        return str2;
    }

    /* renamed from: j */
    public static void m23321j(String str, Context context) {
        AppMethodBeat.m2504i(70393);
        C45477q.m83806a(str, context, C25738R.string.cdd);
        AppMethodBeat.m2505o(70393);
    }

    @Deprecated
    /* renamed from: RL */
    public static String m23294RL(String str) {
        AppMethodBeat.m2504i(70394);
        String RL = C40612a.m70042RL(str);
        AppMethodBeat.m2505o(70394);
        return RL;
    }

    /* renamed from: f */
    public static boolean m23318f(Context context, Intent intent, String str) {
        AppMethodBeat.m2504i(70373);
        boolean g = C14987n.m23319g(context, intent, str);
        AppMethodBeat.m2505o(70373);
        return g;
    }

    /* renamed from: a */
    public static void m23300a(String str, Context context) {
        AppMethodBeat.m2504i(139170);
        C40612a.m70043a(str, context);
        AppMethodBeat.m2505o(139170);
    }

    @TargetApi(8)
    public static String dly() {
        return C6457e.euR;
    }

    public static String dlz() {
        AppMethodBeat.m2504i(70396);
        String dlz = C40612a.dlz();
        AppMethodBeat.m2505o(70396);
        return dlz;
    }
}
