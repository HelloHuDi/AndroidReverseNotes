package com.tencent.p177mm.p707ba;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.p980h.C12217a;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.util.ArrayList;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ba.n */
public final class C9067n extends C7296k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS packageinfo ( id int  PRIMARY KEY, version int  , name text  , size int  , packname text  , status int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) ", "CREATE TABLE IF NOT EXISTS packageinfo2 ( localId text  PRIMARY KEY , id int  , version int  , name text  , size int  , packname text  , status int  , type int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) "};
    private C7480h fni;

    public C9067n(C7480h c7480h) {
        this.fni = c7480h;
    }

    /* renamed from: a */
    public final boolean mo20538a(C25854m c25854m) {
        AppMethodBeat.m2504i(78483);
        if (c25854m == null) {
            AppMethodBeat.m2505o(78483);
            return false;
        }
        c25854m.bJt = -1;
        if (((int) this.fni.insert("packageinfo2", "localId", c25854m.mo43840Hl())) != -1) {
            doNotify();
            AppMethodBeat.m2505o(78483);
            return true;
        }
        AppMethodBeat.m2505o(78483);
        return false;
    }

    /* renamed from: b */
    public final boolean mo20540b(C25854m c25854m) {
        AppMethodBeat.m2504i(78484);
        Assert.assertTrue(c25854m != null);
        ContentValues Hl = c25854m.mo43840Hl();
        if (Hl.size() > 0) {
            if (this.fni.update("packageinfo2", Hl, "id= ? and type =?", new String[]{c25854m.f13661id, c25854m.cBc}) > 0) {
                doNotify();
                AppMethodBeat.m2505o(78484);
                return true;
            }
        }
        doNotify();
        AppMethodBeat.m2505o(78484);
        return false;
    }

    /* renamed from: lS */
    public final boolean mo20545lS(int i) {
        AppMethodBeat.m2504i(78485);
        boolean hY = this.fni.mo10108hY("packageinfo2", "update packageinfo2 set status = 2 where status = 1 and type = " + i + ";");
        doNotify();
        AppMethodBeat.m2505o(78485);
        return hY;
    }

    public final Cursor ait() {
        AppMethodBeat.m2504i(78486);
        Cursor a = this.fni.mo10104a("select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.type=1", null, 0);
        AppMethodBeat.m2505o(78486);
        return a;
    }

    /* renamed from: cv */
    public final C25854m mo20541cv(int i, int i2) {
        C25854m c25854m = null;
        AppMethodBeat.m2504i(78487);
        Cursor a = this.fni.mo10104a("select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.id = \"" + C5046bo.m7586vA(String.valueOf(i)) + "\" and packageinfo2.type = \"" + C5046bo.m7586vA(String.valueOf(i2)) + "\"", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(78487);
        } else {
            if (a.moveToFirst()) {
                c25854m = new C25854m();
                c25854m.mo43842d(a);
            }
            a.close();
            AppMethodBeat.m2505o(78487);
        }
        return c25854m;
    }

    /* renamed from: lT */
    public final boolean mo20546lT(int i) {
        AppMethodBeat.m2504i(78488);
        if (this.fni.delete("packageinfo2", "type =?", new String[]{String.valueOf(i)}) > 0) {
            doNotify();
            AppMethodBeat.m2505o(78488);
            return true;
        }
        AppMethodBeat.m2505o(78488);
        return false;
    }

    /* renamed from: lU */
    public final C25854m[] mo20547lU(int i) {
        AppMethodBeat.m2504i(78489);
        Cursor a = this.fni.mo10104a("select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.type=".concat(String.valueOf(i)), null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            C25854m c25854m = new C25854m();
            c25854m.mo43842d(a);
            arrayList.add(c25854m);
        }
        a.close();
        C25854m[] c25854mArr = (C25854m[]) arrayList.toArray(new C25854m[arrayList.size()]);
        AppMethodBeat.m2505o(78489);
        return c25854mArr;
    }

    public static String aiu() {
        AppMethodBeat.m2504i(78490);
        String Yd = C12217a.m20142Yd();
        AppMethodBeat.m2505o(78490);
        return Yd;
    }

    /* renamed from: cw */
    public static String m16440cw(int i, int i2) {
        AppMethodBeat.m2504i(78491);
        String str = i + "_" + i2 + "_thumb.jpg";
        AppMethodBeat.m2505o(78491);
        return str;
    }

    /* renamed from: cx */
    public final String mo20542cx(int i, int i2) {
        AppMethodBeat.m2504i(78492);
        String str;
        switch (i2) {
            case 0:
                str = "";
                AppMethodBeat.m2505o(78492);
                return str;
            case 1:
                str = i + "_session_bg.zip";
                AppMethodBeat.m2505o(78492);
                return str;
            case 2:
                str = i + "_emoji_art.temp";
                AppMethodBeat.m2505o(78492);
                return str;
            case 5:
                str = "brand_i18n.apk";
                AppMethodBeat.m2505o(78492);
                return str;
            case 7:
                str = i + "_configlist.cfg";
                AppMethodBeat.m2505o(78492);
                return str;
            case 9:
                str = "_speex_upload.cfg";
                AppMethodBeat.m2505o(78492);
                return str;
            case 12:
                str = "_rcpt_addr";
                AppMethodBeat.m2505o(78492);
                return str;
            case 18:
                str = mo20541cv(i, i2).version + "_feature.zip";
                AppMethodBeat.m2505o(78492);
                return str;
            case 19:
                str = "_report_reason.temp";
                AppMethodBeat.m2505o(78492);
                return str;
            case 20:
                str = "_pluginDesc.cfg";
                AppMethodBeat.m2505o(78492);
                return str;
            case 21:
                str = "_trace_config.cfg";
                AppMethodBeat.m2505o(78492);
                return str;
            case 23:
                str = "permissioncfg.cfg";
                AppMethodBeat.m2505o(78492);
                return str;
            case 26:
                str = "ipcallCountryCodeConfig.cfg";
                AppMethodBeat.m2505o(78492);
                return str;
            case 36:
                str = i + "_sensewhere.xml";
                AppMethodBeat.m2505o(78492);
                return str;
            default:
                str = "";
                AppMethodBeat.m2505o(78492);
                return str;
        }
    }

    /* renamed from: cy */
    public final String mo20543cy(int i, int i2) {
        AppMethodBeat.m2504i(78493);
        String str;
        switch (i2) {
            case 0:
                str = "";
                AppMethodBeat.m2505o(78493);
                return str;
            case 1:
                str = C12217a.m20142Yd() + i + "_session_bg/";
                try {
                    File file = new File(str);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.PackageInfoStorage", "exception:%s", C5046bo.m7574l(e));
                    C4990ab.m7412e("MicroMsg.PackageInfoStorage", "can not create dir, dir = ".concat(String.valueOf(str)));
                }
                AppMethodBeat.m2505o(78493);
                return str;
            case 2:
                str = "";
                AppMethodBeat.m2505o(78493);
                return str;
            case 18:
                str = C12217a.m20142Yd() + mo20542cx(i, i2).replace(".zip", "");
                AppMethodBeat.m2505o(78493);
                return str;
            default:
                str = "";
                AppMethodBeat.m2505o(78493);
                return str;
        }
    }

    /* renamed from: cz */
    public final void mo20544cz(int i, int i2) {
        AppMethodBeat.m2504i(78494);
        C1173e.deleteFile(C12217a.m20142Yd() + mo20542cx(i, i2));
        C25854m cv = mo20541cv(i, i2);
        if (cv != null) {
            cv.status = 5;
            C41787r.aix().mo20540b(cv);
        }
        AppMethodBeat.m2505o(78494);
    }

    /* renamed from: cb */
    public static int m16439cb(Context context) {
        AppMethodBeat.m2504i(78495);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels > displayMetrics.widthPixels ? 1 : 0;
        if (displayMetrics.density <= 1.0f) {
            if (i != 0) {
                AppMethodBeat.m2505o(78495);
                return 4;
            }
            AppMethodBeat.m2505o(78495);
            return 2;
        } else if (i != 0) {
            AppMethodBeat.m2505o(78495);
            return 3;
        } else {
            AppMethodBeat.m2505o(78495);
            return 1;
        }
    }

    /* renamed from: K */
    public static String m16437K(String str, boolean z) {
        AppMethodBeat.m2504i(78496);
        String str2;
        if (z) {
            str2 = C12217a.m20142Yd() + str + "_chatting_bg_vertical.jpg";
            AppMethodBeat.m2505o(78496);
            return str2;
        }
        str2 = C12217a.m20142Yd() + str + "_chatting_bg_horizontal.jpg";
        AppMethodBeat.m2505o(78496);
        return str2;
    }

    /* renamed from: Z */
    public static String m16438Z(String str, int i) {
        AppMethodBeat.m2504i(78497);
        String K;
        switch (i) {
            case 1:
            case 2:
                K = C9067n.m16437K(str, false);
                AppMethodBeat.m2505o(78497);
                return K;
            case 3:
            case 4:
                K = C9067n.m16437K(str, true);
                AppMethodBeat.m2505o(78497);
                return K;
            default:
                AppMethodBeat.m2505o(78497);
                return null;
        }
    }
}
