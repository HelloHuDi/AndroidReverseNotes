package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Data;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class b {
    public static final String emJ = new String(Character.toChars(91));
    private static HashMap<String, c> nzw = new HashMap();

    static {
        AppMethodBeat.i(21920);
        AppMethodBeat.o(21920);
    }

    public static ArrayList<c> bHV() {
        AppMethodBeat.i(21916);
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<c> arrayList = new ArrayList();
        if (com.tencent.mm.pluginsdk.permission.b.o(ah.getContext(), "android.permission.READ_CONTACTS")) {
            Cursor query = ah.getContext().getContentResolver().query(Data.CONTENT_URI, new String[]{"contact_id", SlookAirButtonFrequentContactAdapter.DISPLAY_NAME, "data1"}, "mimetype='vnd.android.cursor.item/phone_v2'", null, null);
            HashMap hashMap = new HashMap();
            ab.d("MicroMsg.IPCallAddressBookInfoExtracter", "query FromSystemPhoneBook, time: " + (System.currentTimeMillis() - currentTimeMillis));
            if (query == null) {
                AppMethodBeat.o(21916);
                return arrayList;
            }
            try {
                ab.d("MicroMsg.IPCallAddressBookInfoExtracter", "getAllAddressItemFromSystemPhoneBook, count: %d", Integer.valueOf(query.getCount()));
                if (query.moveToFirst()) {
                    int columnIndex = query.getColumnIndex("contact_id");
                    int columnIndex2 = query.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
                    int columnIndex3 = query.getColumnIndex("data1");
                    while (!query.isAfterLast()) {
                        c a = a(query, columnIndex, columnIndex2, columnIndex3);
                        if (!(a == null || a.nzx == null || a.nzx.size() <= 0 || bo.isNullOrNil(a.field_contactId))) {
                            if (hashMap.containsKey(a.field_contactId)) {
                                c cVar = (c) hashMap.get(a.field_contactId);
                                if (a.nzx.size() > 0 && !cVar.nzx.contains(a.nzx.get(0))) {
                                    cVar.nzx.add(a.nzx.get(0));
                                }
                            } else {
                                hashMap.put(a.field_contactId, a);
                            }
                        }
                        query.moveToNext();
                    }
                }
                query.close();
            } catch (Exception e) {
                ab.e("MicroMsg.IPCallAddressBookInfoExtracter", "getAllAddressItemFromSystemPhoneBook error: %s, class: %s", e.getMessage(), e.getClass().getSimpleName());
                query.close();
            } catch (Throwable th) {
                query.close();
                AppMethodBeat.o(21916);
            }
            arrayList.addAll(hashMap.values());
            nzw = hashMap;
            long currentTimeMillis2 = System.currentTimeMillis();
            ab.d("MicroMsg.IPCallAddressBookInfoExtracter", "getAllAddressItemFromSystemPhoneBook, result size: %d, used %dms", Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
            AppMethodBeat.o(21916);
            return arrayList;
        }
        ab.e("MicroMsg.IPCallAddressBookInfoExtracter", "no contact permission");
        AppMethodBeat.o(21916);
        return arrayList;
    }

    public static HashMap<String, c> bHW() {
        return nzw;
    }

    public static HashMap<String, c> bHX() {
        AppMethodBeat.i(21917);
        bHV();
        HashMap hashMap = nzw;
        AppMethodBeat.o(21917);
        return hashMap;
    }

    public static ArrayList<String> OP(String str) {
        AppMethodBeat.i(21918);
        ArrayList<String> arrayList = new ArrayList();
        if (com.tencent.mm.pluginsdk.permission.b.o(ah.getContext(), "android.permission.READ_CONTACTS")) {
            Cursor query = ah.getContext().getContentResolver().query(Phone.CONTENT_URI, null, "contact_id=?", new String[]{str}, null);
            if (query == null) {
                AppMethodBeat.o(21918);
                return arrayList;
            }
            try {
                if (query.moveToFirst()) {
                    while (!query.isAfterLast()) {
                        arrayList.add(query.getString(query.getColumnIndex("data1")));
                        query.moveToNext();
                    }
                }
                query.close();
            } catch (Exception e) {
                ab.e("MicroMsg.IPCallAddressBookInfoExtracter", "extractAddressItemFromCursor, error: %s, class: %s", e.getMessage(), e.getClass().getSimpleName());
                query.close();
            } catch (Throwable th) {
                query.close();
                AppMethodBeat.o(21918);
            }
            AppMethodBeat.o(21918);
            return arrayList;
        }
        ab.e("MicroMsg.IPCallAddressBookInfoExtracter", "no contact permission");
        AppMethodBeat.o(21918);
        return arrayList;
    }

    private static c a(Cursor cursor, int i, int i2, int i3) {
        String str = null;
        AppMethodBeat.i(21919);
        if (com.tencent.mm.pluginsdk.permission.b.o(ah.getContext(), "android.permission.READ_CONTACTS")) {
            c cVar = new c();
            cVar.nzx = new ArrayList();
            String string = cursor.getString(i);
            String string2 = cursor.getString(i2);
            String string3 = cursor.getString(i3);
            cVar.field_contactId = string;
            cVar.field_systemAddressBookUsername = string2;
            if (!(bo.isNullOrNil(string3) || cVar.nzx.contains(string3))) {
                cVar.nzx.add(string3);
            }
            if (bo.isNullOrNil(cVar.field_systemAddressBookUsername) && cVar.nzx.size() > 0) {
                cVar.field_systemAddressBookUsername = (String) cVar.nzx.get(0);
            }
            Iterator it = cVar.nzx.iterator();
            string2 = str;
            while (it.hasNext()) {
                string = a.Pn((String) it.next());
                if (bo.isNullOrNil(string)) {
                    string = string2;
                } else if (!string.endsWith("@stranger")) {
                    break;
                }
                string2 = string;
            }
            string = string2;
            if (!bo.isNullOrNil(string)) {
                cVar.field_wechatUsername = string;
            }
            if (bo.isNullOrNil(cVar.field_systemAddressBookUsername)) {
                cVar.field_sortKey = "";
            } else {
                try {
                    str = g.vo(cVar.field_systemAddressBookUsername);
                } catch (Exception e) {
                    ab.d("MicroMsg.IPCallAddressBookInfoExtracter", "getFullSpell error: %s, class: %s", e.getMessage(), e.getClass().getSimpleName());
                }
                if (bo.isNullOrNil(str)) {
                    cVar.field_sortKey = "";
                } else if (Character.isLetter(str.charAt(0))) {
                    cVar.field_sortKey = str.toUpperCase();
                } else {
                    cVar.field_sortKey = emJ + str.toUpperCase();
                }
            }
            AppMethodBeat.o(21919);
            return cVar;
        }
        ab.e("MicroMsg.IPCallAddressBookInfoExtracter", "no contact permission");
        AppMethodBeat.o(21919);
        return str;
    }
}
