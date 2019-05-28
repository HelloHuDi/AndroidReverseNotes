package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.cd.h;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoFilterUtil;

public final class b extends k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS massendinfo ( clientid text  PRIMARY KEY , status int  , createtime long  , lastmodifytime long  , filename text  , thumbfilename text  , tolist text  , tolistcount int  , msgtype int  , mediatime int  , datanetoffset int  , datalen int  , thumbnetoffset int  , thumbtotallen int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  massendinfostatus_index ON massendinfo ( status )"};
    public h fni;

    public b(h hVar) {
        this.fni = hVar;
    }

    public final Cursor xm(int i) {
        AppMethodBeat.i(22723);
        String str = "select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   ORDER BY createtime ASC  LIMIT " + i + " offset (SELECT count(*) FROM massendinfo ) -" + i;
        ab.v("MicroMsg.MasSendInfoStorage", "getCursor sql:".concat(String.valueOf(str)));
        Cursor a = this.fni.a(str, null, 0);
        AppMethodBeat.o(22723);
        return a;
    }

    public final int bNz() {
        int i = 0;
        AppMethodBeat.i(22724);
        Cursor a = this.fni.a("SELECT count(*) FROM massendinfo", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.o(22724);
        return i;
    }

    public static Bitmap g(String str, float f) {
        AppMethodBeat.i(22725);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(22725);
            return null;
        }
        String trim = str.trim();
        StringBuilder stringBuilder = new StringBuilder();
        aw.ZK();
        Bitmap i = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.i(stringBuilder.append(c.XW()).append(trim).toString(), f);
        if (i != null) {
            i = Bitmap.createScaledBitmap(i, (int) (((float) i.getWidth()) * f), (int) (((float) i.getHeight()) * f), true);
        }
        AppMethodBeat.o(22725);
        return i;
    }

    public static Bitmap Qr(String str) {
        AppMethodBeat.i(22726);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(22726);
            return null;
        }
        String trim = str.trim();
        StringBuilder stringBuilder = new StringBuilder();
        aw.ZK();
        Bitmap vv = x.vv(stringBuilder.append(c.XW()).append(trim).toString());
        AppMethodBeat.o(22726);
        return vv;
    }

    public static a i(String str, String str2, int i, int i2) {
        AppMethodBeat.i(22727);
        if (e.ct(str)) {
            aw.ZK();
            String XW = c.XW();
            int bJ = ExifHelper.bJ(str);
            String x = g.x((str + System.currentTimeMillis()).getBytes());
            ab.d("MicroMsg.MasSendInfoStorage", "insert : original img path = ".concat(String.valueOf(str)));
            Options amj = d.amj(str);
            if (i2 != 0 || (e.asZ(str) <= 204800 && (amj == null || (amj.outHeight <= VideoFilterUtil.IMAGE_HEIGHT && amj.outWidth <= VideoFilterUtil.IMAGE_HEIGHT)))) {
                String str3 = XW + x + FileUtils.PIC_POSTFIX_JPEG;
                byte[] e = e.e(str, 0, -1);
                e.a(str3, e, e.length);
            } else {
                if (d.a(str, (int) VideoFilterUtil.IMAGE_HEIGHT, (int) VideoFilterUtil.IMAGE_HEIGHT, CompressFormat.JPEG, 70, XW, x)) {
                    e.h(XW, x, x + FileUtils.PIC_POSTFIX_JPEG);
                } else {
                    AppMethodBeat.o(22727);
                    return null;
                }
            }
            String str4 = x + FileUtils.PIC_POSTFIX_JPEG;
            ab.d("MicroMsg.MasSendInfoStorage", "insert: compressed bigImgPath = ".concat(String.valueOf(str4)));
            if (i2 != 0 || bJ == 0 || d.a(XW + str4, bJ, CompressFormat.JPEG, XW, x + FileUtils.PIC_POSTFIX_JPEG)) {
                x = g.x((str4 + System.currentTimeMillis()).getBytes());
                if (d.a(XW + str4, 120, 120, CompressFormat.JPEG, 90, XW, x)) {
                    ab.d("MicroMsg.MasSendInfoStorage", "insert: thumbName = ".concat(String.valueOf(x)));
                    a aVar = new a();
                    aVar.msgType = 3;
                    aVar.onZ = str2;
                    aVar.ooa = i;
                    aVar.onY = x;
                    aVar.filename = str4;
                    AppMethodBeat.o(22727);
                    return aVar;
                }
                AppMethodBeat.o(22727);
                return null;
            }
            AppMethodBeat.o(22727);
            return null;
        }
        AppMethodBeat.o(22727);
        return null;
    }

    public final a Qs(String str) {
        a aVar = null;
        AppMethodBeat.i(22729);
        Cursor a = this.fni.a("select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   where massendinfo.clientid = \"" + bo.vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            AppMethodBeat.o(22729);
        } else {
            if (a.moveToFirst()) {
                aVar = new a();
                aVar.d(a);
            }
            a.close();
            AppMethodBeat.o(22729);
        }
        return aVar;
    }

    public static String a(a aVar) {
        AppMethodBeat.i(22728);
        String bNw;
        switch (aVar.msgType) {
            case 1:
                bNw = aVar.bNw();
                AppMethodBeat.o(22728);
                return bNw;
            case 3:
                bNw = ah.getContext().getResources().getString(R.string.sn);
                AppMethodBeat.o(22728);
                return bNw;
            case 34:
                bNw = ah.getContext().getResources().getString(R.string.ug);
                AppMethodBeat.o(22728);
                return bNw;
            case 43:
                bNw = ah.getContext().getResources().getString(R.string.ud);
                AppMethodBeat.o(22728);
                return bNw;
            default:
                bNw = ah.getContext().getResources().getString(R.string.axn);
                AppMethodBeat.o(22728);
                return bNw;
        }
    }
}
