package com.tencent.p177mm.plugin.masssend.p992a;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoFilterUtil;

/* renamed from: com.tencent.mm.plugin.masssend.a.b */
public final class C46069b extends C7296k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS massendinfo ( clientid text  PRIMARY KEY , status int  , createtime long  , lastmodifytime long  , filename text  , thumbfilename text  , tolist text  , tolistcount int  , msgtype int  , mediatime int  , datanetoffset int  , datalen int  , thumbnetoffset int  , thumbtotallen int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  massendinfostatus_index ON massendinfo ( status )"};
    public C7480h fni;

    public C46069b(C7480h c7480h) {
        this.fni = c7480h;
    }

    /* renamed from: xm */
    public final Cursor mo73990xm(int i) {
        AppMethodBeat.m2504i(22723);
        String str = "select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   ORDER BY createtime ASC  LIMIT " + i + " offset (SELECT count(*) FROM massendinfo ) -" + i;
        C4990ab.m7418v("MicroMsg.MasSendInfoStorage", "getCursor sql:".concat(String.valueOf(str)));
        Cursor a = this.fni.mo10104a(str, null, 0);
        AppMethodBeat.m2505o(22723);
        return a;
    }

    public final int bNz() {
        int i = 0;
        AppMethodBeat.m2504i(22724);
        Cursor a = this.fni.mo10104a("SELECT count(*) FROM massendinfo", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.m2505o(22724);
        return i;
    }

    /* renamed from: g */
    public static Bitmap m85833g(String str, float f) {
        AppMethodBeat.m2504i(22725);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(22725);
            return null;
        }
        String trim = str.trim();
        StringBuilder stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        Bitmap i = C4977b.m7374i(stringBuilder.append(C18628c.m29088XW()).append(trim).toString(), f);
        if (i != null) {
            i = Bitmap.createScaledBitmap(i, (int) (((float) i.getWidth()) * f), (int) (((float) i.getHeight()) * f), true);
        }
        AppMethodBeat.m2505o(22725);
        return i;
    }

    /* renamed from: Qr */
    public static Bitmap m85831Qr(String str) {
        AppMethodBeat.m2504i(22726);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(22726);
            return null;
        }
        String trim = str.trim();
        StringBuilder stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        Bitmap vv = C18764x.m29333vv(stringBuilder.append(C18628c.m29088XW()).append(trim).toString());
        AppMethodBeat.m2505o(22726);
        return vv;
    }

    /* renamed from: i */
    public static C39356a m85834i(String str, String str2, int i, int i2) {
        AppMethodBeat.m2504i(22727);
        if (C5730e.m8628ct(str)) {
            C9638aw.m17190ZK();
            String XW = C18628c.m29088XW();
            int bJ = ExifHelper.m7368bJ(str);
            String x = C1178g.m2591x((str + System.currentTimeMillis()).getBytes());
            C4990ab.m7410d("MicroMsg.MasSendInfoStorage", "insert : original img path = ".concat(String.valueOf(str)));
            Options amj = C5056d.amj(str);
            if (i2 != 0 || (C5730e.asZ(str) <= 204800 && (amj == null || (amj.outHeight <= VideoFilterUtil.IMAGE_HEIGHT && amj.outWidth <= VideoFilterUtil.IMAGE_HEIGHT)))) {
                String str3 = XW + x + FileUtils.PIC_POSTFIX_JPEG;
                byte[] e = C5730e.m8632e(str, 0, -1);
                C5730e.m8619a(str3, e, e.length);
            } else {
                if (C5056d.m7629a(str, (int) VideoFilterUtil.IMAGE_HEIGHT, (int) VideoFilterUtil.IMAGE_HEIGHT, CompressFormat.JPEG, 70, XW, x)) {
                    C5730e.m8633h(XW, x, x + FileUtils.PIC_POSTFIX_JPEG);
                } else {
                    AppMethodBeat.m2505o(22727);
                    return null;
                }
            }
            String str4 = x + FileUtils.PIC_POSTFIX_JPEG;
            C4990ab.m7410d("MicroMsg.MasSendInfoStorage", "insert: compressed bigImgPath = ".concat(String.valueOf(str4)));
            if (i2 != 0 || bJ == 0 || C5056d.m7634a(XW + str4, bJ, CompressFormat.JPEG, XW, x + FileUtils.PIC_POSTFIX_JPEG)) {
                x = C1178g.m2591x((str4 + System.currentTimeMillis()).getBytes());
                if (C5056d.m7629a(XW + str4, 120, 120, CompressFormat.JPEG, 90, XW, x)) {
                    C4990ab.m7410d("MicroMsg.MasSendInfoStorage", "insert: thumbName = ".concat(String.valueOf(x)));
                    C39356a c39356a = new C39356a();
                    c39356a.msgType = 3;
                    c39356a.onZ = str2;
                    c39356a.ooa = i;
                    c39356a.onY = x;
                    c39356a.filename = str4;
                    AppMethodBeat.m2505o(22727);
                    return c39356a;
                }
                AppMethodBeat.m2505o(22727);
                return null;
            }
            AppMethodBeat.m2505o(22727);
            return null;
        }
        AppMethodBeat.m2505o(22727);
        return null;
    }

    /* renamed from: Qs */
    public final C39356a mo73988Qs(String str) {
        C39356a c39356a = null;
        AppMethodBeat.m2504i(22729);
        Cursor a = this.fni.mo10104a("select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   where massendinfo.clientid = \"" + C5046bo.m7586vA(String.valueOf(str)) + "\"", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(22729);
        } else {
            if (a.moveToFirst()) {
                c39356a = new C39356a();
                c39356a.mo62252d(a);
            }
            a.close();
            AppMethodBeat.m2505o(22729);
        }
        return c39356a;
    }

    /* renamed from: a */
    public static String m85832a(C39356a c39356a) {
        AppMethodBeat.m2504i(22728);
        String bNw;
        switch (c39356a.msgType) {
            case 1:
                bNw = c39356a.bNw();
                AppMethodBeat.m2505o(22728);
                return bNw;
            case 3:
                bNw = C4996ah.getContext().getResources().getString(C25738R.string.f9199sn);
                AppMethodBeat.m2505o(22728);
                return bNw;
            case 34:
                bNw = C4996ah.getContext().getResources().getString(C25738R.string.f9256ug);
                AppMethodBeat.m2505o(22728);
                return bNw;
            case 43:
                bNw = C4996ah.getContext().getResources().getString(C25738R.string.f9253ud);
                AppMethodBeat.m2505o(22728);
                return bNw;
            default:
                bNw = C4996ah.getContext().getResources().getString(C25738R.string.axn);
                AppMethodBeat.m2505o(22728);
                return bNw;
        }
    }
}
