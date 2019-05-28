package com.tencent.p177mm.plugin.sport.model;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C46633o;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.sport.p1302a.C39858b;
import com.tencent.p177mm.sdk.p609h.C4971b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.sport.model.n */
public final class C22172n {
    private static C46633o rPQ;
    private static final String[] rPR = new String[]{"_id", "_begin_time", "_end_time", "_mode", "_steps"};
    private static final Uri rPS = Uri.parse("content://com.miui.providers.steps/item");

    /* renamed from: com.tencent.mm.plugin.sport.model.n$1 */
    static class C137341 implements OnClickListener {
        C137341() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(93708);
            C43623k.m78066ab(5, 0);
            AppMethodBeat.m2505o(93708);
        }
    }

    public static long cwC() {
        AppMethodBeat.m2504i(93709);
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long timeInMillis = instance.getTimeInMillis();
        AppMethodBeat.m2505o(93709);
        return timeInMillis;
    }

    public static int cwD() {
        AppMethodBeat.m2504i(93710);
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset() / 1000;
        int i = (timeZone.useDaylightTime() && timeZone.inDaylightTime(new Date(System.currentTimeMillis()))) ? 1 : 0;
        i += rawOffset / 3600;
        AppMethodBeat.m2505o(93710);
        return i;
    }

    /* renamed from: fQ */
    public static final String m33800fQ(long j) {
        AppMethodBeat.m2504i(93711);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
        AppMethodBeat.m2505o(93711);
        return format;
    }

    /* renamed from: Y */
    public static boolean m33795Y(long j, long j2) {
        AppMethodBeat.m2504i(93712);
        long j3 = 3600000;
        try {
            JSONObject optJSONObject = C22168h.cwt().optJSONObject("stepCountUploadConfig");
            if (optJSONObject != null) {
                j3 = ((long) (optJSONObject.optInt("backgroundTimeInterval", 60) * 60)) * 1000;
            }
        } catch (Exception e) {
        }
        if (j2 - j >= j3) {
            AppMethodBeat.m2505o(93712);
            return true;
        }
        AppMethodBeat.m2505o(93712);
        return false;
    }

    /* renamed from: Z */
    public static boolean m33796Z(long j, long j2) {
        int i = 500;
        AppMethodBeat.m2504i(93713);
        if (j != 0 || j2 <= 0) {
            try {
                JSONObject optJSONObject = C22168h.cwt().optJSONObject("stepCountUploadConfig");
                if (optJSONObject != null) {
                    i = optJSONObject.optInt("backgroundStepCountInterval", 500);
                }
            } catch (Exception e) {
            }
            if (j2 - j >= ((long) i)) {
                AppMethodBeat.m2505o(93713);
                return true;
            }
            AppMethodBeat.m2505o(93713);
            return false;
        }
        AppMethodBeat.m2505o(93713);
        return true;
    }

    /* renamed from: eU */
    public static boolean m33799eU(Context context) {
        AppMethodBeat.m2504i(93714);
        if (C1443d.m3067fP(19)) {
            C4990ab.m7416i("MicroMsg.Sport.SportUtil", "Not Support SDK VERSION");
            AppMethodBeat.m2505o(93714);
            return false;
        } else if (!context.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")) {
            C4990ab.m7416i("MicroMsg.Sport.SportUtil", "Not Support FEATURE_SENSOR_STEP_COUNTER");
            AppMethodBeat.m2505o(93714);
            return false;
        } else if (((SensorManager) context.getSystemService("sensor")).getDefaultSensor(19) == null) {
            C4990ab.m7416i("MicroMsg.Sport.SportUtil", "Not Support can not get sensor");
            AppMethodBeat.m2505o(93714);
            return false;
        } else if (C22168h.cwt().optInt("deviceStepSwitch") != 1) {
            C4990ab.m7416i("MicroMsg.Sport.SportUtil", "Not Support deviceStepSwitch is off");
            AppMethodBeat.m2505o(93714);
            return false;
        } else {
            AppMethodBeat.m2505o(93714);
            return true;
        }
    }

    public static boolean cwE() {
        AppMethodBeat.m2504i(93715);
        if (C22168h.cwt().optInt("checkWeSportInstall") != 1) {
            C4990ab.m7416i("MicroMsg.Sport.SportUtil", "checkPushInstallWeSport is false");
            AppMethodBeat.m2505o(93715);
            return false;
        }
        AppMethodBeat.m2505o(93715);
        return true;
    }

    public static boolean cwF() {
        AppMethodBeat.m2504i(93716);
        if (C22168h.cwt().optInt("extStepApiSwitch") != 1) {
            C4990ab.m7416i("MicroMsg.Sport.SportUtil", "Not Support extStepApiSwitch is off");
            AppMethodBeat.m2505o(93716);
            return false;
        }
        AppMethodBeat.m2505o(93716);
        return true;
    }

    public static boolean cvY() {
        boolean jh;
        AppMethodBeat.m2504i(93717);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO("gh_43f2581f6fd6");
        if (aoO != null) {
            jh = C7486a.m12942jh(aoO.field_type);
        } else {
            jh = false;
        }
        if (!jh) {
            C4990ab.m7417i("MicroMsg.Sport.SportUtil", "checkUserInstallWeSportPlugin %b", Boolean.valueOf(jh));
        }
        AppMethodBeat.m2505o(93717);
        return jh;
    }

    /* renamed from: d */
    public static void m33798d(Activity activity, String str) {
        AppMethodBeat.m2504i(93718);
        if (rPQ != null && rPQ.isShowing()) {
            AppMethodBeat.m2505o(93718);
        } else if (C43623k.m78065aa(5, 1) == 0) {
            AppMethodBeat.m2505o(93718);
        } else {
            if (C1853r.m3846Yz().equals(str) && !((C39858b) C1720g.m3528K(C39858b.class)).mo63057eU(C4996ah.getContext())) {
                rPQ = C23639t.m36487a(activity, C4996ah.getContext().getString(C25738R.string.ern), new C137341());
            }
            AppMethodBeat.m2505o(93718);
        }
    }

    public static void cwG() {
        AppMethodBeat.m2504i(93719);
        if (rPQ != null) {
            rPQ.dismiss();
            rPQ = null;
        }
        AppMethodBeat.m2505o(93719);
    }

    /* renamed from: ZV */
    public static long[] m33797ZV(String str) {
        AppMethodBeat.m2504i(93720);
        String[] split = str.split(",");
        long[] jArr = new long[split.length];
        jArr[0] = C5046bo.getLong(split[0], 0);
        jArr[1] = C5046bo.getLong(split[1], 0);
        jArr[2] = C5046bo.getLong(split[2], 0);
        jArr[3] = C5046bo.getLong(split[3], 0);
        jArr[4] = C5046bo.getLong(split[4], 0);
        jArr[5] = C5046bo.getLong(split[5], 0);
        jArr[6] = C5046bo.getLong(split[6], 0);
        AppMethodBeat.m2505o(93720);
        return jArr;
    }

    static {
        AppMethodBeat.m2504i(93722);
        AppMethodBeat.m2505o(93722);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int cwH() {
        int i;
        Throwable e;
        Throwable th;
        AppMethodBeat.m2504i(93721);
        Cursor cursor = null;
        Cursor query;
        try {
            if (C4971b.dqw()) {
                Class cls = Class.forName("miui.util.FeatureParser");
                Object newInstance = cls.newInstance();
                Method declaredMethod = cls.getDeclaredMethod("getBoolean", new Class[]{String.class, Boolean.TYPE});
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(newInstance, new Object[]{"support_steps_provider", Boolean.FALSE});
                if ((invoke instanceof Boolean) && ((Boolean) invoke).booleanValue()) {
                    long cwC = C22172n.cwC();
                    ContentResolver contentResolver = C4996ah.getContext().getContentResolver();
                    if (contentResolver != null) {
                        query = contentResolver.query(rPS, rPR, "_begin_time >= ? AND _end_time <= ? AND (_mode = 2 OR _mode = 3)", new String[]{String.valueOf(cwC), String.valueOf(cwC + 86400000)}, "_id asc");
                        if (query != null) {
                            i = 0;
                            while (query.moveToNext()) {
                                try {
                                    i += query.getInt(4);
                                } catch (Exception e2) {
                                    e = e2;
                                    try {
                                        C4990ab.printErrStackTrace("MicroMsg.Sport.SportUtil", e, "getMIUIStep", new Object[0]);
                                        if (query != null) {
                                        }
                                        C4990ab.m7417i("MicroMsg.Sport.SportUtil", "getMIUIStep %d", Integer.valueOf(i));
                                        AppMethodBeat.m2505o(93721);
                                        return i;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        cursor = query;
                                        if (cursor != null) {
                                        }
                                        AppMethodBeat.m2505o(93721);
                                        throw th;
                                    }
                                }
                            }
                            cursor = query;
                        } else {
                            cursor = query;
                            i = 0;
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        C4990ab.m7417i("MicroMsg.Sport.SportUtil", "getMIUIStep %d", Integer.valueOf(i));
                        AppMethodBeat.m2505o(93721);
                        return i;
                    }
                }
            }
            i = 0;
            if (cursor != null) {
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            i = 0;
            C4990ab.printErrStackTrace("MicroMsg.Sport.SportUtil", e, "getMIUIStep", new Object[0]);
            if (query != null) {
                query.close();
            }
            C4990ab.m7417i("MicroMsg.Sport.SportUtil", "getMIUIStep %d", Integer.valueOf(i));
            AppMethodBeat.m2505o(93721);
            return i;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(93721);
            throw th;
        }
        C4990ab.m7417i("MicroMsg.Sport.SportUtil", "getMIUIStep %d", Integer.valueOf(i));
        AppMethodBeat.m2505o(93721);
        return i;
    }
}
