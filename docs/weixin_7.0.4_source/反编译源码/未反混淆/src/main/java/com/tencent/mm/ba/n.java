package com.tencent.mm.ba;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.cd.h;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.ArrayList;
import junit.framework.Assert;

public final class n extends k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS packageinfo ( id int  PRIMARY KEY, version int  , name text  , size int  , packname text  , status int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) ", "CREATE TABLE IF NOT EXISTS packageinfo2 ( localId text  PRIMARY KEY , id int  , version int  , name text  , size int  , packname text  , status int  , type int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) "};
    private h fni;

    public n(h hVar) {
        this.fni = hVar;
    }

    public final boolean a(m mVar) {
        AppMethodBeat.i(78483);
        if (mVar == null) {
            AppMethodBeat.o(78483);
            return false;
        }
        mVar.bJt = -1;
        if (((int) this.fni.insert("packageinfo2", "localId", mVar.Hl())) != -1) {
            doNotify();
            AppMethodBeat.o(78483);
            return true;
        }
        AppMethodBeat.o(78483);
        return false;
    }

    public final boolean b(m mVar) {
        AppMethodBeat.i(78484);
        Assert.assertTrue(mVar != null);
        ContentValues Hl = mVar.Hl();
        if (Hl.size() > 0) {
            if (this.fni.update("packageinfo2", Hl, "id= ? and type =?", new String[]{mVar.id, mVar.cBc}) > 0) {
                doNotify();
                AppMethodBeat.o(78484);
                return true;
            }
        }
        doNotify();
        AppMethodBeat.o(78484);
        return false;
    }

    public final boolean lS(int i) {
        AppMethodBeat.i(78485);
        boolean hY = this.fni.hY("packageinfo2", "update packageinfo2 set status = 2 where status = 1 and type = " + i + ";");
        doNotify();
        AppMethodBeat.o(78485);
        return hY;
    }

    public final Cursor ait() {
        AppMethodBeat.i(78486);
        Cursor a = this.fni.a("select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.type=1", null, 0);
        AppMethodBeat.o(78486);
        return a;
    }

    public final m cv(int i, int i2) {
        m mVar = null;
        AppMethodBeat.i(78487);
        Cursor a = this.fni.a("select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.id = \"" + bo.vA(String.valueOf(i)) + "\" and packageinfo2.type = \"" + bo.vA(String.valueOf(i2)) + "\"", null, 2);
        if (a == null) {
            AppMethodBeat.o(78487);
        } else {
            if (a.moveToFirst()) {
                mVar = new m();
                mVar.d(a);
            }
            a.close();
            AppMethodBeat.o(78487);
        }
        return mVar;
    }

    public final boolean lT(int i) {
        AppMethodBeat.i(78488);
        if (this.fni.delete("packageinfo2", "type =?", new String[]{String.valueOf(i)}) > 0) {
            doNotify();
            AppMethodBeat.o(78488);
            return true;
        }
        AppMethodBeat.o(78488);
        return false;
    }

    public final m[] lU(int i) {
        AppMethodBeat.i(78489);
        Cursor a = this.fni.a("select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.type=".concat(String.valueOf(i)), null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            m mVar = new m();
            mVar.d(a);
            arrayList.add(mVar);
        }
        a.close();
        m[] mVarArr = (m[]) arrayList.toArray(new m[arrayList.size()]);
        AppMethodBeat.o(78489);
        return mVarArr;
    }

    public static String aiu() {
        AppMethodBeat.i(78490);
        String Yd = a.Yd();
        AppMethodBeat.o(78490);
        return Yd;
    }

    public static String cw(int i, int i2) {
        AppMethodBeat.i(78491);
        String str = i + "_" + i2 + "_thumb.jpg";
        AppMethodBeat.o(78491);
        return str;
    }

    public final String cx(int i, int i2) {
        AppMethodBeat.i(78492);
        String str;
        switch (i2) {
            case 0:
                str = "";
                AppMethodBeat.o(78492);
                return str;
            case 1:
                str = i + "_session_bg.zip";
                AppMethodBeat.o(78492);
                return str;
            case 2:
                str = i + "_emoji_art.temp";
                AppMethodBeat.o(78492);
                return str;
            case 5:
                str = "brand_i18n.apk";
                AppMethodBeat.o(78492);
                return str;
            case 7:
                str = i + "_configlist.cfg";
                AppMethodBeat.o(78492);
                return str;
            case 9:
                str = "_speex_upload.cfg";
                AppMethodBeat.o(78492);
                return str;
            case 12:
                str = "_rcpt_addr";
                AppMethodBeat.o(78492);
                return str;
            case 18:
                str = cv(i, i2).version + "_feature.zip";
                AppMethodBeat.o(78492);
                return str;
            case 19:
                str = "_report_reason.temp";
                AppMethodBeat.o(78492);
                return str;
            case 20:
                str = "_pluginDesc.cfg";
                AppMethodBeat.o(78492);
                return str;
            case 21:
                str = "_trace_config.cfg";
                AppMethodBeat.o(78492);
                return str;
            case 23:
                str = "permissioncfg.cfg";
                AppMethodBeat.o(78492);
                return str;
            case 26:
                str = "ipcallCountryCodeConfig.cfg";
                AppMethodBeat.o(78492);
                return str;
            case 36:
                str = i + "_sensewhere.xml";
                AppMethodBeat.o(78492);
                return str;
            default:
                str = "";
                AppMethodBeat.o(78492);
                return str;
        }
    }

    public final String cy(int i, int i2) {
        AppMethodBeat.i(78493);
        String str;
        switch (i2) {
            case 0:
                str = "";
                AppMethodBeat.o(78493);
                return str;
            case 1:
                str = a.Yd() + i + "_session_bg/";
                try {
                    File file = new File(str);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.PackageInfoStorage", "exception:%s", bo.l(e));
                    ab.e("MicroMsg.PackageInfoStorage", "can not create dir, dir = ".concat(String.valueOf(str)));
                }
                AppMethodBeat.o(78493);
                return str;
            case 2:
                str = "";
                AppMethodBeat.o(78493);
                return str;
            case 18:
                str = a.Yd() + cx(i, i2).replace(".zip", "");
                AppMethodBeat.o(78493);
                return str;
            default:
                str = "";
                AppMethodBeat.o(78493);
                return str;
        }
    }

    public final void cz(int i, int i2) {
        AppMethodBeat.i(78494);
        e.deleteFile(a.Yd() + cx(i, i2));
        m cv = cv(i, i2);
        if (cv != null) {
            cv.status = 5;
            r.aix().b(cv);
        }
        AppMethodBeat.o(78494);
    }

    public static int cb(Context context) {
        AppMethodBeat.i(78495);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels > displayMetrics.widthPixels ? 1 : 0;
        if (displayMetrics.density <= 1.0f) {
            if (i != 0) {
                AppMethodBeat.o(78495);
                return 4;
            }
            AppMethodBeat.o(78495);
            return 2;
        } else if (i != 0) {
            AppMethodBeat.o(78495);
            return 3;
        } else {
            AppMethodBeat.o(78495);
            return 1;
        }
    }

    public static String K(String str, boolean z) {
        AppMethodBeat.i(78496);
        String str2;
        if (z) {
            str2 = a.Yd() + str + "_chatting_bg_vertical.jpg";
            AppMethodBeat.o(78496);
            return str2;
        }
        str2 = a.Yd() + str + "_chatting_bg_horizontal.jpg";
        AppMethodBeat.o(78496);
        return str2;
    }

    public static String Z(String str, int i) {
        AppMethodBeat.i(78497);
        String K;
        switch (i) {
            case 1:
            case 2:
                K = K(str, false);
                AppMethodBeat.o(78497);
                return K;
            case 3:
            case 4:
                K = K(str, true);
                AppMethodBeat.o(78497);
                return K;
            default:
                AppMethodBeat.o(78497);
                return null;
        }
    }
}
