package com.tencent.mm.plugin.exdevice.h;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public final class c extends j<b> {
    public static final String[] fnj = new String[]{j.a(b.ccO, "HardDeviceInfo")};
    private e bSd;

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.e.c cVar) {
        AppMethodBeat.i(19725);
        b bVar = (b) cVar;
        if (bVar == null || bo.isNullOrNil(bVar.field_brandName) || bo.isNullOrNil(bVar.field_deviceID)) {
            ab.w("MicroMsg.exdevice.HardDeviceInfoStorage", "wrong argument");
            AppMethodBeat.o(19725);
            return false;
        }
        ab.i("MicroMsg.exdevice.HardDeviceInfoStorage", "replace: brandName=%s, deviceId=%s, ret=%s ", bVar.field_brandName, bVar.field_deviceID, Boolean.valueOf(this.bSd.replace("HardDeviceInfo", b.ccO.xDc, bVar.Hl()) > 0));
        AppMethodBeat.o(19725);
        return this.bSd.replace("HardDeviceInfo", b.ccO.xDc, bVar.Hl()) > 0;
    }

    static {
        AppMethodBeat.i(19726);
        AppMethodBeat.o(19726);
    }

    public c(e eVar) {
        super(eVar, b.ccO, "HardDeviceInfo", null);
        AppMethodBeat.i(19712);
        this.bSd = eVar;
        eVar.hY("HardDeviceInfo", "CREATE INDEX IF NOT EXISTS hardDeviceUsernameIndex ON HardDeviceInfo ( brandName )");
        eVar.hY("HardDeviceInfo", "CREATE INDEX IF NOT EXISTS hardDeviceMacIndex ON HardDeviceInfo ( mac )");
        AppMethodBeat.o(19712);
    }

    public final b Ku(String str) {
        AppMethodBeat.i(19713);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(19713);
            return null;
        }
        Cursor a = this.bSd.a("HardDeviceInfo", null, "mac=?", new String[]{str}, null, null, null, 2);
        if (a == null) {
            AppMethodBeat.o(19713);
            return null;
        } else if (a.moveToFirst()) {
            b bVar = new b();
            bVar.d(a);
            a.close();
            AppMethodBeat.o(19713);
            return bVar;
        } else {
            ab.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with mac:".concat(String.valueOf(str)));
            a.close();
            AppMethodBeat.o(19713);
            return null;
        }
    }

    public final b id(long j) {
        b bVar = null;
        AppMethodBeat.i(19714);
        Cursor query = this.bSd.query("HardDeviceInfo", null, "mac=?", new String[]{String.valueOf(j)}, null, null, null);
        if (query == null) {
            AppMethodBeat.o(19714);
        } else {
            if (query.moveToFirst()) {
                bVar = new b();
                bVar.d(query);
            } else {
                ab.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with mac:".concat(String.valueOf(j)));
            }
            query.close();
            AppMethodBeat.o(19714);
        }
        return bVar;
    }

    public final b Kv(String str) {
        AppMethodBeat.i(19715);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(19715);
            return null;
        }
        Cursor a = this.bSd.a("HardDeviceInfo", null, "deviceID=?", new String[]{str}, null, null, null, 2);
        if (a == null) {
            AppMethodBeat.o(19715);
            return null;
        } else if (a.moveToFirst()) {
            b bVar = new b();
            bVar.d(a);
            a.close();
            AppMethodBeat.o(19715);
            return bVar;
        } else {
            ab.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with deviceId:".concat(String.valueOf(str)));
            a.close();
            AppMethodBeat.o(19715);
            return null;
        }
    }

    public final b dS(String str, String str2) {
        AppMethodBeat.i(19716);
        if (bo.isNullOrNil(str2) || bo.isNullOrNil(str)) {
            ab.e("MicroMsg.exdevice.HardDeviceInfoStorage", "deviceType(%s) or deviceId(%s) is null or nil.", str2, str);
            AppMethodBeat.o(19716);
            return null;
        }
        Cursor a = this.bSd.a("HardDeviceInfo", null, "deviceType=? and deviceID=?", new String[]{str2, str}, null, null, null, 2);
        if (a == null) {
            AppMethodBeat.o(19716);
            return null;
        } else if (a.moveToFirst()) {
            b bVar = new b();
            bVar.d(a);
            a.close();
            AppMethodBeat.o(19716);
            return bVar;
        } else {
            ab.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with deviceType:%s and deviceId:%s", str2, str);
            a.close();
            AppMethodBeat.o(19716);
            return null;
        }
    }

    public static boolean Kw(String str) {
        AppMethodBeat.i(19717);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.exdevice.HardDeviceInfoStorage", "Ability is null or nil.");
            AppMethodBeat.o(19717);
            return false;
        } else if (str.contains("wxmsg_music") || str.contains("wxmsg_poi") || str.contains("wxmsg_image") || str.contains("wxmsg_file") || str.contains("wxmsg_video") || str.contains("wxmsg_url")) {
            AppMethodBeat.o(19717);
            return true;
        } else {
            AppMethodBeat.o(19717);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<b> bpA() {
        AppMethodBeat.i(19718);
        LinkedList linkedList = new LinkedList();
        Cursor baR = baR();
        if (baR == null || !baR.moveToFirst()) {
            if (baR != null) {
                baR.close();
            }
            AppMethodBeat.o(19718);
            return linkedList;
        }
        do {
            b bVar = new b();
            bVar.d(baR);
            String str = bVar.dFr;
            if (str != null && Kw(str)) {
                linkedList.add(bVar);
            }
        } while (baR.moveToNext());
        if (baR != null) {
        }
        AppMethodBeat.o(19718);
        return linkedList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<b> bpB() {
        AppMethodBeat.i(19719);
        LinkedList linkedList = new LinkedList();
        Cursor baR = baR();
        if (baR == null || !baR.moveToFirst()) {
            if (baR != null) {
                baR.close();
            }
            AppMethodBeat.o(19719);
            return linkedList;
        }
        do {
            b bVar = new b();
            bVar.d(baR);
            String str = bVar.dFn;
            String str2 = bVar.iconUrl;
            String str3 = bVar.category;
            String str4 = bVar.field_brandName;
            if (!(bo.isNullOrNil(str3) || str3.equals("1") || str3.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) || bo.isNullOrNil(str4) || bo.isNullOrNil(str) || bo.isNullOrNil(str2))) {
                linkedList.add(bVar);
            }
        } while (baR.moveToNext());
        if (baR != null) {
        }
        AppMethodBeat.o(19719);
        return linkedList;
    }

    public final b dT(String str, String str2) {
        AppMethodBeat.i(19720);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.exdevice.HardDeviceInfoStorage", "brandName(%s) or deviceId(%s) is null or nil.", str, str2);
            AppMethodBeat.o(19720);
            return null;
        }
        Cursor a = this.bSd.a("HardDeviceInfo", null, "brandName=? and deviceID=?", new String[]{str, str2}, null, null, null, 2);
        if (a == null) {
            AppMethodBeat.o(19720);
            return null;
        } else if (a.moveToFirst()) {
            b bVar = new b();
            bVar.d(a);
            a.close();
            AppMethodBeat.o(19720);
            return bVar;
        } else {
            ab.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with brandName:".concat(String.valueOf(str)));
            a.close();
            AppMethodBeat.o(19720);
            return null;
        }
    }

    public final LinkedList<b> Kx(String str) {
        AppMethodBeat.i(19721);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.exdevice.HardDeviceInfoStorage", "The given brandName is null or nil.");
            AppMethodBeat.o(19721);
            return null;
        }
        LinkedList<b> linkedList = new LinkedList();
        Cursor a = this.bSd.a("HardDeviceInfo", null, "brandName=?", new String[]{str}, null, null, null, 2);
        if (a == null) {
            AppMethodBeat.o(19721);
            return linkedList;
        }
        if (a.moveToFirst()) {
            do {
                b bVar = new b();
                bVar.d(a);
                linkedList.add(bVar);
            } while (a.moveToNext());
        }
        a.close();
        AppMethodBeat.o(19721);
        return linkedList;
    }

    public final LinkedList<b> bpC() {
        AppMethodBeat.i(19722);
        LinkedList linkedList = new LinkedList();
        Cursor rawQuery = rawQuery("select * from HardDeviceInfo where mac > 0 and connProto like '3'", new String[0]);
        if (rawQuery == null) {
            ab.e("MicroMsg.exdevice.HardDeviceInfoStorage", "get cursor is null");
            AppMethodBeat.o(19722);
        } else {
            if (rawQuery.moveToFirst()) {
                do {
                    b bVar = new b();
                    bVar.d(rawQuery);
                    linkedList.add(bVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            AppMethodBeat.o(19722);
        }
        return linkedList;
    }

    public final boolean dU(String str, String str2) {
        AppMethodBeat.i(19723);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(19723);
            return false;
        }
        if (this.bSd.delete("HardDeviceInfo", "deviceID=? and deviceType=? ", new String[]{str, str2}) <= 0) {
            ab.i("MicroMsg.exdevice.HardDeviceInfoStorage", "delete hardDeviceInfo fail, deviceId = %s", str);
            AppMethodBeat.o(19723);
            return false;
        }
        ab.i("MicroMsg.exdevice.HardDeviceInfoStorage", "delete hardDeviceInfo ok, deviceId = %s", str);
        AppMethodBeat.o(19723);
        return true;
    }

    public final int e(b bVar) {
        int update;
        AppMethodBeat.i(19724);
        ContentValues Hl = bVar.Hl();
        if (Hl.size() > 0) {
            update = this.bSd.update("HardDeviceInfo", Hl, "deviceID = ? and deviceType = ? ", new String[]{bVar.field_deviceID, bVar.field_deviceType});
        } else {
            update = 0;
        }
        ab.i("MicroMsg.exdevice.HardDeviceInfoStorage", "update: deviceId = %s, deviceType = %s, ret = %s ", bVar.field_deviceID, bVar.field_deviceType, Integer.valueOf(update));
        AppMethodBeat.o(19724);
        return update;
    }
}
