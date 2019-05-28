package com.tencent.p177mm.plugin.ipcall.p438a.p983g;

import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Data;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.platformtools.C9790g;
import com.tencent.p177mm.plugin.ipcall.p1275b.C46041a;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.ipcall.a.g.b */
public final class C21082b {
    public static final String emJ = new String(Character.toChars(91));
    private static HashMap<String, C21083c> nzw = new HashMap();

    static {
        AppMethodBeat.m2504i(21920);
        AppMethodBeat.m2505o(21920);
    }

    public static ArrayList<C21083c> bHV() {
        AppMethodBeat.m2504i(21916);
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<C21083c> arrayList = new ArrayList();
        if (C35805b.m58714o(C4996ah.getContext(), "android.permission.READ_CONTACTS")) {
            Cursor query = C4996ah.getContext().getContentResolver().query(Data.CONTENT_URI, new String[]{"contact_id", SlookAirButtonFrequentContactAdapter.DISPLAY_NAME, "data1"}, "mimetype='vnd.android.cursor.item/phone_v2'", null, null);
            HashMap hashMap = new HashMap();
            C4990ab.m7410d("MicroMsg.IPCallAddressBookInfoExtracter", "query FromSystemPhoneBook, time: " + (System.currentTimeMillis() - currentTimeMillis));
            if (query == null) {
                AppMethodBeat.m2505o(21916);
                return arrayList;
            }
            try {
                C4990ab.m7411d("MicroMsg.IPCallAddressBookInfoExtracter", "getAllAddressItemFromSystemPhoneBook, count: %d", Integer.valueOf(query.getCount()));
                if (query.moveToFirst()) {
                    int columnIndex = query.getColumnIndex("contact_id");
                    int columnIndex2 = query.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
                    int columnIndex3 = query.getColumnIndex("data1");
                    while (!query.isAfterLast()) {
                        C21083c a = C21082b.m32389a(query, columnIndex, columnIndex2, columnIndex3);
                        if (!(a == null || a.nzx == null || a.nzx.size() <= 0 || C5046bo.isNullOrNil(a.field_contactId))) {
                            if (hashMap.containsKey(a.field_contactId)) {
                                C21083c c21083c = (C21083c) hashMap.get(a.field_contactId);
                                if (a.nzx.size() > 0 && !c21083c.nzx.contains(a.nzx.get(0))) {
                                    c21083c.nzx.add(a.nzx.get(0));
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
                C4990ab.m7413e("MicroMsg.IPCallAddressBookInfoExtracter", "getAllAddressItemFromSystemPhoneBook error: %s, class: %s", e.getMessage(), e.getClass().getSimpleName());
                query.close();
            } catch (Throwable th) {
                query.close();
                AppMethodBeat.m2505o(21916);
            }
            arrayList.addAll(hashMap.values());
            nzw = hashMap;
            long currentTimeMillis2 = System.currentTimeMillis();
            C4990ab.m7411d("MicroMsg.IPCallAddressBookInfoExtracter", "getAllAddressItemFromSystemPhoneBook, result size: %d, used %dms", Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
            AppMethodBeat.m2505o(21916);
            return arrayList;
        }
        C4990ab.m7412e("MicroMsg.IPCallAddressBookInfoExtracter", "no contact permission");
        AppMethodBeat.m2505o(21916);
        return arrayList;
    }

    public static HashMap<String, C21083c> bHW() {
        return nzw;
    }

    public static HashMap<String, C21083c> bHX() {
        AppMethodBeat.m2504i(21917);
        C21082b.bHV();
        HashMap hashMap = nzw;
        AppMethodBeat.m2505o(21917);
        return hashMap;
    }

    /* renamed from: OP */
    public static ArrayList<String> m32388OP(String str) {
        AppMethodBeat.m2504i(21918);
        ArrayList<String> arrayList = new ArrayList();
        if (C35805b.m58714o(C4996ah.getContext(), "android.permission.READ_CONTACTS")) {
            Cursor query = C4996ah.getContext().getContentResolver().query(Phone.CONTENT_URI, null, "contact_id=?", new String[]{str}, null);
            if (query == null) {
                AppMethodBeat.m2505o(21918);
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
                C4990ab.m7413e("MicroMsg.IPCallAddressBookInfoExtracter", "extractAddressItemFromCursor, error: %s, class: %s", e.getMessage(), e.getClass().getSimpleName());
                query.close();
            } catch (Throwable th) {
                query.close();
                AppMethodBeat.m2505o(21918);
            }
            AppMethodBeat.m2505o(21918);
            return arrayList;
        }
        C4990ab.m7412e("MicroMsg.IPCallAddressBookInfoExtracter", "no contact permission");
        AppMethodBeat.m2505o(21918);
        return arrayList;
    }

    /* renamed from: a */
    private static C21083c m32389a(Cursor cursor, int i, int i2, int i3) {
        String str = null;
        AppMethodBeat.m2504i(21919);
        if (C35805b.m58714o(C4996ah.getContext(), "android.permission.READ_CONTACTS")) {
            C21083c c21083c = new C21083c();
            c21083c.nzx = new ArrayList();
            String string = cursor.getString(i);
            String string2 = cursor.getString(i2);
            String string3 = cursor.getString(i3);
            c21083c.field_contactId = string;
            c21083c.field_systemAddressBookUsername = string2;
            if (!(C5046bo.isNullOrNil(string3) || c21083c.nzx.contains(string3))) {
                c21083c.nzx.add(string3);
            }
            if (C5046bo.isNullOrNil(c21083c.field_systemAddressBookUsername) && c21083c.nzx.size() > 0) {
                c21083c.field_systemAddressBookUsername = (String) c21083c.nzx.get(0);
            }
            Iterator it = c21083c.nzx.iterator();
            string2 = str;
            while (it.hasNext()) {
                string = C46041a.m85628Pn((String) it.next());
                if (C5046bo.isNullOrNil(string)) {
                    string = string2;
                } else if (!string.endsWith("@stranger")) {
                    break;
                }
                string2 = string;
            }
            string = string2;
            if (!C5046bo.isNullOrNil(string)) {
                c21083c.field_wechatUsername = string;
            }
            if (C5046bo.isNullOrNil(c21083c.field_systemAddressBookUsername)) {
                c21083c.field_sortKey = "";
            } else {
                try {
                    str = C9790g.m17432vo(c21083c.field_systemAddressBookUsername);
                } catch (Exception e) {
                    C4990ab.m7411d("MicroMsg.IPCallAddressBookInfoExtracter", "getFullSpell error: %s, class: %s", e.getMessage(), e.getClass().getSimpleName());
                }
                if (C5046bo.isNullOrNil(str)) {
                    c21083c.field_sortKey = "";
                } else if (Character.isLetter(str.charAt(0))) {
                    c21083c.field_sortKey = str.toUpperCase();
                } else {
                    c21083c.field_sortKey = emJ + str.toUpperCase();
                }
            }
            AppMethodBeat.m2505o(21919);
            return c21083c;
        }
        C4990ab.m7412e("MicroMsg.IPCallAddressBookInfoExtracter", "no contact permission");
        AppMethodBeat.m2505o(21919);
        return str;
    }
}
