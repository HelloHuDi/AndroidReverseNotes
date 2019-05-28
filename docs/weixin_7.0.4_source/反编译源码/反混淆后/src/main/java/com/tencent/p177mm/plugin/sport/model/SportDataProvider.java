package com.tencent.p177mm.plugin.sport.model;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sport.model.SportDataProvider */
public class SportDataProvider extends ContentProvider {
    public boolean onCreate() {
        return true;
    }

    /* JADX WARNING: Missing block: B:7:0x0017, code skipped:
            switch(r0) {
                case 0: goto L_0x0055;
                case 1: goto L_0x0080;
                case 2: goto L_0x009a;
                case 3: goto L_0x00b9;
                case 4: goto L_0x00d2;
                default: goto L_0x001a;
            };
     */
    /* JADX WARNING: Missing block: B:25:0x0055, code skipped:
            r1 = new android.os.Bundle();
            r1.putLong("TodayStep", com.tencent.p177mm.plugin.sport.model.C22166g.cwn());
            r1.putLong("TodaySaveTime", com.tencent.p177mm.plugin.sport.model.C22166g.cwo());
            r0 = new com.tencent.p177mm.plugin.sport.model.C22170i(new java.lang.String[]{"Step"}, r1);
     */
    /* JADX WARNING: Missing block: B:26:0x007c, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(93684);
     */
    /* JADX WARNING: Missing block: B:29:0x0086, code skipped:
            if (com.tencent.p177mm.kernel.C1720g.m3530M(com.tencent.p177mm.plugin.sport.PluginSport.class) == null) goto L_0x001a;
     */
    /* JADX WARNING: Missing block: B:30:0x0088, code skipped:
            ((com.tencent.p177mm.plugin.sport.PluginSport) com.tencent.p177mm.kernel.C1720g.m3530M(com.tencent.p177mm.plugin.sport.PluginSport.class)).getSportFileStorage().reset();
     */
    /* JADX WARNING: Missing block: B:34:0x00a0, code skipped:
            if (com.tencent.p177mm.kernel.C1720g.m3530M(com.tencent.p177mm.plugin.sport.PluginSport.class) == null) goto L_0x001a;
     */
    /* JADX WARNING: Missing block: B:35:0x00a2, code skipped:
            com.tencent.p177mm.plugin.sport.model.C22168h.m33792ZS(r12[0]);
            ((com.tencent.p177mm.plugin.sport.PluginSport) com.tencent.p177mm.kernel.C1720g.m3530M(com.tencent.p177mm.plugin.sport.PluginSport.class)).getPushSportStepDetector().cwj();
     */
    /* JADX WARNING: Missing block: B:37:0x00bf, code skipped:
            if (com.tencent.p177mm.kernel.C1720g.m3530M(com.tencent.p177mm.plugin.sport.PluginSport.class) == null) goto L_0x001a;
     */
    /* JADX WARNING: Missing block: B:38:0x00c1, code skipped:
            ((com.tencent.p177mm.plugin.sport.PluginSport) com.tencent.p177mm.kernel.C1720g.m3530M(com.tencent.p177mm.plugin.sport.PluginSport.class)).getPushSportStepDetector().cwj();
     */
    /* JADX WARNING: Missing block: B:40:0x00d8, code skipped:
            if (com.tencent.p177mm.kernel.C1720g.m3530M(com.tencent.p177mm.plugin.sport.PluginSport.class) == null) goto L_0x001a;
     */
    /* JADX WARNING: Missing block: B:41:0x00da, code skipped:
            ((com.tencent.p177mm.plugin.sport.PluginSport) com.tencent.p177mm.kernel.C1720g.m3530M(com.tencent.p177mm.plugin.sport.PluginSport.class)).getPushSportStepDetector().mo37726b(java.lang.Long.valueOf(r12[0]).longValue(), java.lang.Long.valueOf(r12[1]).longValue(), "MM");
     */
    /* JADX WARNING: Missing block: B:43:?, code skipped:
            return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Object obj = null;
        AppMethodBeat.m2504i(93684);
        if (!C5046bo.isNullOrNil(str)) {
            try {
                switch (str.hashCode()) {
                    case -2048296977:
                        if (str.equals("clearConfig")) {
                            int obj2 = 1;
                            break;
                        }
                    case -1403048597:
                        if (str.equals("updateConfig")) {
                            obj2 = 2;
                            break;
                        }
                    case -295950539:
                        if (str.equals("updateStep")) {
                            obj2 = 3;
                            break;
                        }
                    case -102943798:
                        if (str.equals("Key_mmSensorChange")) {
                            obj2 = 4;
                            break;
                        }
                    case 1522180184:
                        if (str.equals("getTodayStepCount")) {
                            break;
                        }
                        obj2 = -1;
                        break;
                }
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(93684);
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
