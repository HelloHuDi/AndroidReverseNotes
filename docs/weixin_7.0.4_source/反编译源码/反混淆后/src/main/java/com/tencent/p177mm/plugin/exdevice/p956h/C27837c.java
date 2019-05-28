package com.tencent.p177mm.plugin.exdevice.p956h;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.exdevice.h.c */
public final class C27837c extends C7563j<C11648b> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C11648b.ccO, "HardDeviceInfo")};
    private C4927e bSd;

    /* renamed from: a */
    public final /* synthetic */ boolean mo10099a(C4925c c4925c) {
        AppMethodBeat.m2504i(19725);
        C11648b c11648b = (C11648b) c4925c;
        if (c11648b == null || C5046bo.isNullOrNil(c11648b.field_brandName) || C5046bo.isNullOrNil(c11648b.field_deviceID)) {
            C4990ab.m7420w("MicroMsg.exdevice.HardDeviceInfoStorage", "wrong argument");
            AppMethodBeat.m2505o(19725);
            return false;
        }
        C4990ab.m7417i("MicroMsg.exdevice.HardDeviceInfoStorage", "replace: brandName=%s, deviceId=%s, ret=%s ", c11648b.field_brandName, c11648b.field_deviceID, Boolean.valueOf(this.bSd.replace("HardDeviceInfo", C11648b.ccO.xDc, c11648b.mo10098Hl()) > 0));
        AppMethodBeat.m2505o(19725);
        return this.bSd.replace("HardDeviceInfo", C11648b.ccO.xDc, c11648b.mo10098Hl()) > 0;
    }

    static {
        AppMethodBeat.m2504i(19726);
        AppMethodBeat.m2505o(19726);
    }

    public C27837c(C4927e c4927e) {
        super(c4927e, C11648b.ccO, "HardDeviceInfo", null);
        AppMethodBeat.m2504i(19712);
        this.bSd = c4927e;
        c4927e.mo10108hY("HardDeviceInfo", "CREATE INDEX IF NOT EXISTS hardDeviceUsernameIndex ON HardDeviceInfo ( brandName )");
        c4927e.mo10108hY("HardDeviceInfo", "CREATE INDEX IF NOT EXISTS hardDeviceMacIndex ON HardDeviceInfo ( mac )");
        AppMethodBeat.m2505o(19712);
    }

    /* renamed from: Ku */
    public final C11648b mo45700Ku(String str) {
        AppMethodBeat.m2504i(19713);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(19713);
            return null;
        }
        Cursor a = this.bSd.mo10105a("HardDeviceInfo", null, "mac=?", new String[]{str}, null, null, null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(19713);
            return null;
        } else if (a.moveToFirst()) {
            C11648b c11648b = new C11648b();
            c11648b.mo8995d(a);
            a.close();
            AppMethodBeat.m2505o(19713);
            return c11648b;
        } else {
            C4990ab.m7420w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with mac:".concat(String.valueOf(str)));
            a.close();
            AppMethodBeat.m2505o(19713);
            return null;
        }
    }

    /* renamed from: id */
    public final C11648b mo45710id(long j) {
        C11648b c11648b = null;
        AppMethodBeat.m2504i(19714);
        Cursor query = this.bSd.query("HardDeviceInfo", null, "mac=?", new String[]{String.valueOf(j)}, null, null, null);
        if (query == null) {
            AppMethodBeat.m2505o(19714);
        } else {
            if (query.moveToFirst()) {
                c11648b = new C11648b();
                c11648b.mo8995d(query);
            } else {
                C4990ab.m7420w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with mac:".concat(String.valueOf(j)));
            }
            query.close();
            AppMethodBeat.m2505o(19714);
        }
        return c11648b;
    }

    /* renamed from: Kv */
    public final C11648b mo45701Kv(String str) {
        AppMethodBeat.m2504i(19715);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(19715);
            return null;
        }
        Cursor a = this.bSd.mo10105a("HardDeviceInfo", null, "deviceID=?", new String[]{str}, null, null, null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(19715);
            return null;
        } else if (a.moveToFirst()) {
            C11648b c11648b = new C11648b();
            c11648b.mo8995d(a);
            a.close();
            AppMethodBeat.m2505o(19715);
            return c11648b;
        } else {
            C4990ab.m7420w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with deviceId:".concat(String.valueOf(str)));
            a.close();
            AppMethodBeat.m2505o(19715);
            return null;
        }
    }

    /* renamed from: dS */
    public final C11648b mo45706dS(String str, String str2) {
        AppMethodBeat.m2504i(19716);
        if (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str)) {
            C4990ab.m7413e("MicroMsg.exdevice.HardDeviceInfoStorage", "deviceType(%s) or deviceId(%s) is null or nil.", str2, str);
            AppMethodBeat.m2505o(19716);
            return null;
        }
        Cursor a = this.bSd.mo10105a("HardDeviceInfo", null, "deviceType=? and deviceID=?", new String[]{str2, str}, null, null, null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(19716);
            return null;
        } else if (a.moveToFirst()) {
            C11648b c11648b = new C11648b();
            c11648b.mo8995d(a);
            a.close();
            AppMethodBeat.m2505o(19716);
            return c11648b;
        } else {
            C4990ab.m7421w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with deviceType:%s and deviceId:%s", str2, str);
            a.close();
            AppMethodBeat.m2505o(19716);
            return null;
        }
    }

    /* renamed from: Kw */
    public static boolean m44247Kw(String str) {
        AppMethodBeat.m2504i(19717);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.exdevice.HardDeviceInfoStorage", "Ability is null or nil.");
            AppMethodBeat.m2505o(19717);
            return false;
        } else if (str.contains("wxmsg_music") || str.contains("wxmsg_poi") || str.contains("wxmsg_image") || str.contains("wxmsg_file") || str.contains("wxmsg_video") || str.contains("wxmsg_url")) {
            AppMethodBeat.m2505o(19717);
            return true;
        } else {
            AppMethodBeat.m2505o(19717);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<C11648b> bpA() {
        AppMethodBeat.m2504i(19718);
        LinkedList linkedList = new LinkedList();
        Cursor baR = baR();
        if (baR == null || !baR.moveToFirst()) {
            if (baR != null) {
                baR.close();
            }
            AppMethodBeat.m2505o(19718);
            return linkedList;
        }
        do {
            C11648b c11648b = new C11648b();
            c11648b.mo8995d(baR);
            String str = c11648b.dFr;
            if (str != null && C27837c.m44247Kw(str)) {
                linkedList.add(c11648b);
            }
        } while (baR.moveToNext());
        if (baR != null) {
        }
        AppMethodBeat.m2505o(19718);
        return linkedList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<C11648b> bpB() {
        AppMethodBeat.m2504i(19719);
        LinkedList linkedList = new LinkedList();
        Cursor baR = baR();
        if (baR == null || !baR.moveToFirst()) {
            if (baR != null) {
                baR.close();
            }
            AppMethodBeat.m2505o(19719);
            return linkedList;
        }
        do {
            C11648b c11648b = new C11648b();
            c11648b.mo8995d(baR);
            String str = c11648b.dFn;
            String str2 = c11648b.iconUrl;
            String str3 = c11648b.category;
            String str4 = c11648b.field_brandName;
            if (!(C5046bo.isNullOrNil(str3) || str3.equals("1") || str3.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) || C5046bo.isNullOrNil(str4) || C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2))) {
                linkedList.add(c11648b);
            }
        } while (baR.moveToNext());
        if (baR != null) {
        }
        AppMethodBeat.m2505o(19719);
        return linkedList;
    }

    /* renamed from: dT */
    public final C11648b mo45707dT(String str, String str2) {
        AppMethodBeat.m2504i(19720);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            C4990ab.m7413e("MicroMsg.exdevice.HardDeviceInfoStorage", "brandName(%s) or deviceId(%s) is null or nil.", str, str2);
            AppMethodBeat.m2505o(19720);
            return null;
        }
        Cursor a = this.bSd.mo10105a("HardDeviceInfo", null, "brandName=? and deviceID=?", new String[]{str, str2}, null, null, null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(19720);
            return null;
        } else if (a.moveToFirst()) {
            C11648b c11648b = new C11648b();
            c11648b.mo8995d(a);
            a.close();
            AppMethodBeat.m2505o(19720);
            return c11648b;
        } else {
            C4990ab.m7420w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with brandName:".concat(String.valueOf(str)));
            a.close();
            AppMethodBeat.m2505o(19720);
            return null;
        }
    }

    /* renamed from: Kx */
    public final LinkedList<C11648b> mo45702Kx(String str) {
        AppMethodBeat.m2504i(19721);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.exdevice.HardDeviceInfoStorage", "The given brandName is null or nil.");
            AppMethodBeat.m2505o(19721);
            return null;
        }
        LinkedList<C11648b> linkedList = new LinkedList();
        Cursor a = this.bSd.mo10105a("HardDeviceInfo", null, "brandName=?", new String[]{str}, null, null, null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(19721);
            return linkedList;
        }
        if (a.moveToFirst()) {
            do {
                C11648b c11648b = new C11648b();
                c11648b.mo8995d(a);
                linkedList.add(c11648b);
            } while (a.moveToNext());
        }
        a.close();
        AppMethodBeat.m2505o(19721);
        return linkedList;
    }

    public final LinkedList<C11648b> bpC() {
        AppMethodBeat.m2504i(19722);
        LinkedList linkedList = new LinkedList();
        Cursor rawQuery = rawQuery("select * from HardDeviceInfo where mac > 0 and connProto like '3'", new String[0]);
        if (rawQuery == null) {
            C4990ab.m7412e("MicroMsg.exdevice.HardDeviceInfoStorage", "get cursor is null");
            AppMethodBeat.m2505o(19722);
        } else {
            if (rawQuery.moveToFirst()) {
                do {
                    C11648b c11648b = new C11648b();
                    c11648b.mo8995d(rawQuery);
                    linkedList.add(c11648b);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            AppMethodBeat.m2505o(19722);
        }
        return linkedList;
    }

    /* renamed from: dU */
    public final boolean mo45708dU(String str, String str2) {
        AppMethodBeat.m2504i(19723);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(19723);
            return false;
        }
        if (this.bSd.delete("HardDeviceInfo", "deviceID=? and deviceType=? ", new String[]{str, str2}) <= 0) {
            C4990ab.m7417i("MicroMsg.exdevice.HardDeviceInfoStorage", "delete hardDeviceInfo fail, deviceId = %s", str);
            AppMethodBeat.m2505o(19723);
            return false;
        }
        C4990ab.m7417i("MicroMsg.exdevice.HardDeviceInfoStorage", "delete hardDeviceInfo ok, deviceId = %s", str);
        AppMethodBeat.m2505o(19723);
        return true;
    }

    /* renamed from: e */
    public final int mo45709e(C11648b c11648b) {
        int update;
        AppMethodBeat.m2504i(19724);
        ContentValues Hl = c11648b.mo10098Hl();
        if (Hl.size() > 0) {
            update = this.bSd.update("HardDeviceInfo", Hl, "deviceID = ? and deviceType = ? ", new String[]{c11648b.field_deviceID, c11648b.field_deviceType});
        } else {
            update = 0;
        }
        C4990ab.m7417i("MicroMsg.exdevice.HardDeviceInfoStorage", "update: deviceId = %s, deviceType = %s, ret = %s ", c11648b.field_deviceID, c11648b.field_deviceType, Integer.valueOf(update));
        AppMethodBeat.m2505o(19724);
        return update;
    }
}
