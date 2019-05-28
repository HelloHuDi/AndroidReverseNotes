package com.tencent.p177mm.platformtools;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.Profile;
import android.telephony.TelephonyManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.network.C1937v;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/* renamed from: com.tencent.mm.platformtools.i */
public final class C32889i {
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0145 A:{SYNTHETIC, Splitter:B:50:0x0145} */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0386  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01f9 A:{SYNTHETIC, Splitter:B:83:0x01f9} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01f9 A:{SYNTHETIC, Splitter:B:83:0x01f9} */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0145 A:{SYNTHETIC, Splitter:B:50:0x0145} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0145 A:{SYNTHETIC, Splitter:B:50:0x0145} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x032e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @TargetApi(14)
    public static String getPhoneNum(Context context, String str) {
        String networkCountryIso;
        Throwable e;
        Throwable e2;
        Throwable th;
        Throwable e3;
        AppMethodBeat.m2504i(124528);
        C4990ab.m7417i("MicroMsg.ContactsUtil", "Get phone number. country code : %s", str);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.ContactsUtil", "The context is null.");
            AppMethodBeat.m2505o(124528);
            return null;
        }
        String str2;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        String str3 = null;
        String str4 = null;
        try {
            str3 = telephonyManager.getLine1Number();
            str4 = telephonyManager.getSimCountryIso();
            try {
                if (C5046bo.isNullOrNil(str4)) {
                    networkCountryIso = telephonyManager.getNetworkCountryIso();
                } else {
                    networkCountryIso = str4;
                }
            } catch (Exception e4) {
                e = e4;
                networkCountryIso = str4;
                C4990ab.printErrStackTrace("MicroMsg.ContactsUtil", e, "", new Object[0]);
                C4990ab.m7412e("MicroMsg.ContactsUtil", "get line number got exception");
                str2 = networkCountryIso;
                if (C5046bo.isNullOrNil(str3)) {
                }
            }
            try {
                if (C5046bo.isNullOrNil(networkCountryIso)) {
                    networkCountryIso = Locale.getDefault().getCountry();
                }
                str2 = networkCountryIso;
            } catch (Exception e5) {
                e = e5;
                C4990ab.printErrStackTrace("MicroMsg.ContactsUtil", e, "", new Object[0]);
                C4990ab.m7412e("MicroMsg.ContactsUtil", "get line number got exception");
                str2 = networkCountryIso;
                if (C5046bo.isNullOrNil(str3)) {
                }
            }
        } catch (Exception e6) {
            e = e6;
            networkCountryIso = str4;
        }
        if (C5046bo.isNullOrNil(str3)) {
            str3 = str3.trim();
            networkCountryIso = C5025av.m7484hR(str3, str2);
            C4990ab.m7417i("MicroMsg.ContactsUtil", "get num : %s, extract country code  : %s, iso : %s", str3, networkCountryIso, str2);
            if (C5046bo.isNullOrNil(networkCountryIso)) {
                networkCountryIso = str3;
            } else {
                networkCountryIso = str3.substring((str3.startsWith("+") ? 1 : 0) + networkCountryIso.length());
                C4990ab.m7417i("MicroMsg.ContactsUtil", "after deal, the num is %s", networkCountryIso);
            }
            C4990ab.m7416i("MicroMsg.ContactsUtil", "Got phone number by TelephonyManager.");
            AppMethodBeat.m2505o(124528);
            return networkCountryIso;
        } else if (C35805b.m58714o(context, "android.permission.READ_CONTACTS")) {
            int columnIndex;
            Cursor query;
            ContentResolver contentResolver = context.getContentResolver();
            Cursor cursor = null;
            String str5 = null;
            if (!C1443d.m3067fP(14)) {
                int i;
                C4990ab.m7416i("MicroMsg.ContactsUtil", "The device os API version is higher than 14.");
                try {
                    cursor = contentResolver.query(Profile.CONTENT_URI, new String[]{"has_phone_number"}, null, null, null);
                    if (cursor != null && cursor.moveToFirst()) {
                        columnIndex = cursor.getColumnIndex("has_phone_number");
                        if (columnIndex != -1) {
                            i = cursor.getInt(columnIndex);
                            C4990ab.m7416i("MicroMsg.ContactsUtil", "The phone count of the profile is ".concat(String.valueOf(i)));
                            if (!(cursor == null || cursor.isClosed())) {
                                cursor.close();
                            }
                            if (i > 0) {
                                try {
                                    query = contentResolver.query(Uri.withAppendedPath(Profile.CONTENT_URI, "data"), new String[]{"data1"}, "mimetype=?", new String[]{"vnd.android.cursor.item/phone_v2"}, null);
                                    if (query != null) {
                                        try {
                                            if (query.moveToFirst()) {
                                                columnIndex = query.getColumnIndex("data1");
                                                if (columnIndex != -1) {
                                                    str5 = query.getString(columnIndex);
                                                    try {
                                                        C4990ab.m7417i("MicroMsg.ContactsUtil", "Have got phone number from profile ,number is [%s]", str5);
                                                    } catch (Exception e7) {
                                                        e2 = e7;
                                                        str3 = str5;
                                                        try {
                                                            C4990ab.printErrStackTrace("MicroMsg.ContactsUtil", e2, "", new Object[0]);
                                                            C4990ab.m7410d("MicroMsg.ContactsUtil", "query crashed");
                                                            query.close();
                                                            str5 = str3;
                                                            cursor = query;
                                                            if (C5046bo.isNullOrNil(str5)) {
                                                            }
                                                            if (!C5046bo.isNullOrNil(str5)) {
                                                            }
                                                            AppMethodBeat.m2505o(124528);
                                                            return str5;
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                            query.close();
                                                            AppMethodBeat.m2505o(124528);
                                                            throw th;
                                                        }
                                                    }
                                                }
                                            }
                                            query.close();
                                            str3 = str5;
                                        } catch (Exception e8) {
                                            e2 = e8;
                                            str3 = null;
                                            C4990ab.printErrStackTrace("MicroMsg.ContactsUtil", e2, "", new Object[0]);
                                            C4990ab.m7410d("MicroMsg.ContactsUtil", "query crashed");
                                            if (!(query == null || query.isClosed())) {
                                                query.close();
                                                str5 = str3;
                                                cursor = query;
                                                if (C5046bo.isNullOrNil(str5)) {
                                                }
                                                if (C5046bo.isNullOrNil(str5)) {
                                                }
                                                AppMethodBeat.m2505o(124528);
                                                return str5;
                                            }
                                            str5 = str3;
                                            cursor = query;
                                            if (C5046bo.isNullOrNil(str5)) {
                                            }
                                            if (C5046bo.isNullOrNil(str5)) {
                                            }
                                            AppMethodBeat.m2505o(124528);
                                            return str5;
                                        }
                                    }
                                    str3 = null;
                                    if (!(query == null || query.isClosed())) {
                                        query.close();
                                        str5 = str3;
                                        cursor = query;
                                    }
                                } catch (Exception e9) {
                                    e2 = e9;
                                    str3 = null;
                                    query = cursor;
                                } catch (Throwable th3) {
                                    th = th3;
                                    query = cursor;
                                    if (!(query == null || query.isClosed())) {
                                        query.close();
                                    }
                                    AppMethodBeat.m2505o(124528);
                                    throw th;
                                }
                                str5 = str3;
                                cursor = query;
                            }
                        }
                    }
                    i = 0;
                    try {
                        C4990ab.m7416i("MicroMsg.ContactsUtil", "The phone count of the profile is ".concat(String.valueOf(i)));
                        cursor.close();
                    } catch (Exception e10) {
                        e3 = e10;
                        try {
                            C4990ab.printErrStackTrace("MicroMsg.ContactsUtil", e3, "", new Object[0]);
                            C4990ab.m7410d("MicroMsg.ContactsUtil", "query crashed");
                            if (!(cursor == null || cursor.isClosed())) {
                                cursor.close();
                            }
                            if (i > 0) {
                            }
                            if (C5046bo.isNullOrNil(str5)) {
                            }
                            if (C5046bo.isNullOrNil(str5)) {
                            }
                            AppMethodBeat.m2505o(124528);
                            return str5;
                        } catch (Throwable th4) {
                            if (!(cursor == null || cursor.isClosed())) {
                                cursor.close();
                            }
                            AppMethodBeat.m2505o(124528);
                        }
                    }
                } catch (Exception e11) {
                    e3 = e11;
                    i = 0;
                    C4990ab.printErrStackTrace("MicroMsg.ContactsUtil", e3, "", new Object[0]);
                    C4990ab.m7410d("MicroMsg.ContactsUtil", "query crashed");
                    cursor.close();
                    if (i > 0) {
                    }
                    if (C5046bo.isNullOrNil(str5)) {
                    }
                    if (C5046bo.isNullOrNil(str5)) {
                    }
                    AppMethodBeat.m2505o(124528);
                    return str5;
                }
                if (i > 0) {
                }
            }
            if (C5046bo.isNullOrNil(str5)) {
                if (!C5046bo.isNullOrNil(C32889i.m53828H(context, C26529w.m42363ct(context)))) {
                    try {
                        query = contentResolver.query(Contacts.CONTENT_URI, new String[]{"has_phone_number"}, "_id=?", new String[]{C32889i.m53828H(context, C26529w.m42363ct(context))}, null);
                        if (query != null) {
                            try {
                                if (query.moveToFirst()) {
                                    columnIndex = query.getInt(query.getColumnIndex("has_phone_number"));
                                    if (query == null) {
                                        query.close();
                                        cursor = query;
                                    } else {
                                        cursor = query;
                                    }
                                    C4990ab.m7416i("MicroMsg.ContactsUtil", "The phone count of the profile is ".concat(String.valueOf(columnIndex)));
                                    if (columnIndex > 0) {
                                        try {
                                            cursor = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1", "data2"}, "contact_id =?", new String[]{r10}, null);
                                            if (cursor != null && cursor.moveToFirst()) {
                                                do {
                                                    str5 = cursor.getString(cursor.getColumnIndex("data1"));
                                                    if (!C5046bo.isNullOrNil(str5)) {
                                                        C4990ab.m7417i("MicroMsg.ContactsUtil", "have got phone number from contacts ,number is [%s]", str5);
                                                        break;
                                                    }
                                                } while (cursor.moveToNext());
                                            }
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                        } catch (Exception e12) {
                                            C4990ab.printErrStackTrace("MicroMsg.ContactsUtil", e12, "", new Object[0]);
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                        } catch (Throwable th5) {
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            AppMethodBeat.m2505o(124528);
                                        }
                                    }
                                }
                            } catch (Exception e13) {
                                e3 = e13;
                                try {
                                    C4990ab.printErrStackTrace("MicroMsg.ContactsUtil", e3, "", new Object[0]);
                                    if (query != null) {
                                        query.close();
                                        columnIndex = 0;
                                        cursor = query;
                                    } else {
                                        columnIndex = 0;
                                        cursor = query;
                                    }
                                    C4990ab.m7416i("MicroMsg.ContactsUtil", "The phone count of the profile is ".concat(String.valueOf(columnIndex)));
                                    if (columnIndex > 0) {
                                    }
                                    if (C5046bo.isNullOrNil(str5)) {
                                    }
                                    AppMethodBeat.m2505o(124528);
                                    return str5;
                                } catch (Throwable th6) {
                                    th = th6;
                                    if (query != null) {
                                        query.close();
                                    }
                                    AppMethodBeat.m2505o(124528);
                                    throw th;
                                }
                            }
                        }
                        columnIndex = 0;
                        if (query == null) {
                        }
                    } catch (Exception e14) {
                        e3 = e14;
                        query = cursor;
                    } catch (Throwable th7) {
                        th = th7;
                        query = cursor;
                        if (query != null) {
                        }
                        AppMethodBeat.m2505o(124528);
                        throw th;
                    }
                    C4990ab.m7416i("MicroMsg.ContactsUtil", "The phone count of the profile is ".concat(String.valueOf(columnIndex)));
                    if (columnIndex > 0) {
                    }
                }
            }
            if (C5046bo.isNullOrNil(str5)) {
                networkCountryIso = C5025av.m7484hR(str5, str2);
                C4990ab.m7417i("MicroMsg.ContactsUtil", "get phone num : %s, extract country code  : %s iso : %s", str5, networkCountryIso, str2);
                if (!C5046bo.isNullOrNil(networkCountryIso)) {
                    if (str5.startsWith("+")) {
                        networkCountryIso = "+".concat(String.valueOf(networkCountryIso));
                    } else if (!str5.startsWith(networkCountryIso)) {
                        networkCountryIso = null;
                    }
                    if (networkCountryIso != null) {
                        str5 = str5.substring(networkCountryIso.length());
                    }
                }
                C4990ab.m7417i("MicroMsg.ContactsUtil", "after deal, the phone num is %s", str5);
            }
            AppMethodBeat.m2505o(124528);
            return str5;
        } else {
            C4990ab.m7412e("MicroMsg.ContactsUtil", "no contact permission");
            AppMethodBeat.m2505o(124528);
            return null;
        }
    }

    /* renamed from: H */
    private static String m53828H(Context context, String str) {
        String str2;
        Throwable e;
        String str3 = null;
        AppMethodBeat.m2504i(124529);
        C4990ab.m7417i("MicroMsg.ContactsUtil", "Get contactId by email, email = %s", str);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.ContactsUtil", "context is null.");
            AppMethodBeat.m2505o(124529);
            return null;
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.ContactsUtil", "email is null.");
            AppMethodBeat.m2505o(124529);
            return null;
        } else {
            try {
                Cursor query = context.getContentResolver().query(Email.CONTENT_URI, new String[]{"contact_id", "data1"}, "data1=?", new String[]{str}, null);
                if (query != null) {
                    if (query.moveToFirst()) {
                        do {
                            try {
                                str3 = query.getString(query.getColumnIndex("contact_id"));
                                if (!C5046bo.isNullOrNil(str3)) {
                                    C4990ab.m7417i("MicroMsg.ContactsUtil", "Have got contactId ,contactId is [%s]", str3);
                                    str2 = str3;
                                    break;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                str2 = str3;
                            }
                        } while (query.moveToNext());
                        str2 = str3;
                    } else {
                        str2 = null;
                    }
                    try {
                        query.close();
                    } catch (Exception e3) {
                        e = e3;
                        C4990ab.printErrStackTrace("MicroMsg.ContactsUtil", e, "getContactIdByEmail error", new Object[0]);
                        AppMethodBeat.m2505o(124529);
                        return str2;
                    }
                }
                str2 = null;
            } catch (Exception e4) {
                e = e4;
                str2 = null;
                C4990ab.printErrStackTrace("MicroMsg.ContactsUtil", e, "getContactIdByEmail error", new Object[0]);
                AppMethodBeat.m2505o(124529);
                return str2;
            }
            AppMethodBeat.m2505o(124529);
            return str2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @TargetApi(14)
    /* renamed from: cj */
    public static String m53829cj(Context context) {
        AppMethodBeat.m2504i(124530);
        C4990ab.m7416i("MicroMsg.ContactsUtil", "Get name of a contacts record or profile.");
        if (context == null) {
            C4990ab.m7412e("MicroMsg.ContactsUtil", "context is null.");
            AppMethodBeat.m2505o(124530);
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (C35805b.m58714o(context, "android.permission.READ_CONTACTS")) {
            String str;
            if (C1443d.m3068iW(14)) {
                Cursor query;
                C4990ab.m7416i("MicroMsg.ContactsUtil", "The Android API version is higher than 14.");
                try {
                    query = contentResolver.query(Profile.CONTENT_URI, new String[]{SlookAirButtonFrequentContactAdapter.DISPLAY_NAME}, null, null, null);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.ContactsUtil", e, "", new Object[0]);
                    C4990ab.m7410d("MicroMsg.ContactsUtil", "query crashed");
                    query = null;
                }
                if (query != null) {
                    String string;
                    if (query.moveToFirst()) {
                        string = query.getString(query.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME));
                        C4990ab.m7417i("MicroMsg.ContactsUtil", "Have got name from profile, name is %s", string);
                    } else {
                        string = null;
                    }
                    query.close();
                    str = string;
                    if (C5046bo.isNullOrNil(str)) {
                        if (C5046bo.isNullOrNil(C32889i.m53828H(context, C26529w.m42363ct(context)))) {
                            C4990ab.m7416i("MicroMsg.ContactsUtil", "contactId is null.");
                            AppMethodBeat.m2505o(124530);
                            return null;
                        }
                        Cursor query2 = contentResolver.query(Data.CONTENT_URI, new String[]{SlookAirButtonFrequentContactAdapter.DISPLAY_NAME}, "contact_id=?", new String[]{r5}, null);
                        if (query2 != null) {
                            if (query2.moveToFirst()) {
                                str = query2.getString(query2.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME));
                                C4990ab.m7417i("MicroMsg.ContactsUtil", "Have got name from contacts, name is %s", str);
                            }
                            query2.close();
                        }
                    }
                    AppMethodBeat.m2505o(124530);
                    return str;
                }
            }
            str = null;
            if (C5046bo.isNullOrNil(str)) {
            }
            AppMethodBeat.m2505o(124530);
            return str;
        }
        C4990ab.m7412e("MicroMsg.ContactsUtil", "no contact permission");
        AppMethodBeat.m2505o(124530);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x015f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @TargetApi(14)
    /* renamed from: ck */
    public static Bitmap m53830ck(Context context) {
        AppMethodBeat.m2504i(124531);
        C4990ab.m7416i("MicroMsg.ContactsUtil", "Get bitmap of a contacts record or profile.");
        if (context == null) {
            C4990ab.m7412e("MicroMsg.ContactsUtil", "context is null.");
            AppMethodBeat.m2505o(124531);
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Bitmap bitmap = null;
        if (C35805b.m58714o(context, "android.permission.READ_CONTACTS")) {
            int lastIndexOf;
            Bitmap vs;
            Cursor cursor = null;
            if (C1443d.m3068iW(14)) {
                C4990ab.m7416i("MicroMsg.ContactsUtil", "The Android API version is higher than 14.");
                try {
                    cursor = contentResolver.query(Profile.CONTENT_URI, new String[]{"_id"}, null, null, null);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.ContactsUtil", e, "", new Object[0]);
                    C4990ab.m7410d("MicroMsg.ContactsUtil", "query crashed");
                }
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        Cursor query;
                        cursor.close();
                        try {
                            query = contentResolver.query(Uri.withAppendedPath(Profile.CONTENT_URI, "data"), new String[]{"data15", "data_sync1"}, "mimetype=?", new String[]{"vnd.android.cursor.item/photo"}, null);
                        } catch (Exception e2) {
                            C4990ab.printErrStackTrace("MicroMsg.ContactsUtil", e2, "", new Object[0]);
                            C4990ab.m7410d("MicroMsg.ContactsUtil", "query crashed");
                            query = cursor;
                        }
                        if (query != null) {
                            if (query.moveToFirst()) {
                                if (C5023at.isWifi(context) || C5023at.is3G(context) || C5023at.is4G(context)) {
                                    C4990ab.m7416i("MicroMsg.ContactsUtil", "The network status is wifi or 3G or 4G.");
                                    String string = query.getString(query.getColumnIndex("data_sync1"));
                                    C4990ab.m7417i("MicroMsg.ContactsUtil", "get sync avatar url : [%s]", string);
                                    if (!C5046bo.isNullOrNil(string)) {
                                        lastIndexOf = string.lastIndexOf("https:");
                                        C4990ab.m7417i("MicroMsg.ContactsUtil", "check is exist https download url :[%d]", Integer.valueOf(lastIndexOf));
                                        if (lastIndexOf >= 0) {
                                            vs = C32889i.m53831vs(string.substring(lastIndexOf));
                                            C4990ab.m7417i("MicroMsg.ContactsUtil", "Get image from google sync account in profile,url:[%s]", r3);
                                            if (!(vs == null || vs.isRecycled())) {
                                                query.close();
                                                AppMethodBeat.m2505o(124531);
                                                return vs;
                                            }
                                            lastIndexOf = query.getColumnIndex("data15");
                                            if (lastIndexOf != -1) {
                                                byte[] blob = query.getBlob(lastIndexOf);
                                                C4990ab.m7417i("MicroMsg.ContactsUtil", "get bitmap data is null : [%b]", Boolean.valueOf(C5046bo.m7540cb(blob)));
                                                if (!C5046bo.m7540cb(blob)) {
                                                    C4990ab.m7416i("MicroMsg.ContactsUtil", "Get image from profile personal icon.");
                                                    vs = BitmapFactory.decodeByteArray(blob, 0, blob.length);
                                                }
                                            }
                                        }
                                    }
                                }
                                vs = null;
                                lastIndexOf = query.getColumnIndex("data15");
                                if (lastIndexOf != -1) {
                                }
                            } else {
                                vs = null;
                            }
                            query.close();
                            bitmap = vs;
                        }
                    } else {
                        cursor.close();
                    }
                }
            }
            if (bitmap == null || bitmap.isRecycled()) {
                String H = C32889i.m53828H(context, C26529w.m42363ct(context));
                if (C5046bo.isNullOrNil(H)) {
                    C4990ab.m7416i("MicroMsg.ContactsUtil", "contactId is null.");
                    AppMethodBeat.m2505o(124531);
                    return null;
                }
                Cursor query2 = contentResolver.query(Phone.CONTENT_URI, new String[]{"photo_id", "raw_contact_id"}, "contact_id=?", new String[]{H}, null);
                if (query2 != null) {
                    if (query2.moveToFirst()) {
                        while (true) {
                            long j;
                            if (C5023at.isWifi(context) || C5023at.is3G(context) || C5023at.is4G(context)) {
                                C4990ab.m7416i("MicroMsg.ContactsUtil", "The network status is wifi or 3G or 4G.");
                                String string2 = query2.getString(query2.getColumnIndex("raw_contact_id"));
                                Cursor query3 = contentResolver.query(Data.CONTENT_URI, new String[]{"data15", "data_sync1"}, "mimetype=? AND raw_contact_id=?", new String[]{"vnd.android.cursor.item/photo", string2}, null);
                                if (query3 != null) {
                                    if (query3.moveToFirst()) {
                                        int columnIndex = query3.getColumnIndex("data_sync1");
                                        if (columnIndex != -1) {
                                            String string3 = query3.getString(columnIndex);
                                            if (!C5046bo.isNullOrNil(string3)) {
                                                lastIndexOf = string3.lastIndexOf("https:");
                                                if (lastIndexOf >= 0) {
                                                    bitmap = C32889i.m53831vs(string3.substring(lastIndexOf));
                                                    if (!(bitmap == null || bitmap.isRecycled())) {
                                                        C4990ab.m7417i("MicroMsg.ContactsUtil", "Get image from google sync account in contacts,url:[%s]", string3);
                                                        query3.close();
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    query3.close();
                                }
                            }
                            C4990ab.m7416i("MicroMsg.ContactsUtil", "Get bitmap from contacts icon.");
                            int columnIndex2 = query2.getColumnIndex("photo_id");
                            if (columnIndex2 != -1) {
                                j = query2.getLong(columnIndex2);
                                C4990ab.m7416i("MicroMsg.ContactsUtil", "Have got photoId,photoId is ".concat(String.valueOf(j)));
                            } else {
                                j = 0;
                            }
                            if (j > 0) {
                                vs = BitmapFactory.decodeStream(Contacts.openContactPhotoInputStream(contentResolver, ContentUris.withAppendedId(Contacts.CONTENT_URI, C5046bo.getLong(H, 0))));
                                if (!(vs == null || vs.isRecycled())) {
                                    C4990ab.m7416i("MicroMsg.ContactsUtil", "Get image from contacts through google account.");
                                    bitmap = vs;
                                    break;
                                }
                            }
                            vs = bitmap;
                            if (!query2.moveToNext()) {
                                bitmap = vs;
                                break;
                            }
                            bitmap = vs;
                        }
                    }
                    query2.close();
                }
            }
            AppMethodBeat.m2505o(124531);
            return bitmap;
        }
        C4990ab.m7412e("MicroMsg.ContactsUtil", "no contact permission");
        AppMethodBeat.m2505o(124531);
        return null;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:54:0x0130=Splitter:B:54:0x0130, B:31:0x00a7=Splitter:B:31:0x00a7} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0151 A:{SYNTHETIC, Splitter:B:57:0x0151} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0158 A:{Catch:{ IOException -> 0x0160 }} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0184 A:{SYNTHETIC, Splitter:B:67:0x0184} */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x018b A:{Catch:{ IOException -> 0x0195 }} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0151 A:{SYNTHETIC, Splitter:B:57:0x0151} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0158 A:{Catch:{ IOException -> 0x0160 }} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0151 A:{SYNTHETIC, Splitter:B:57:0x0151} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0158 A:{Catch:{ IOException -> 0x0160 }} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0184 A:{SYNTHETIC, Splitter:B:67:0x0184} */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x018b A:{Catch:{ IOException -> 0x0195 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: vs */
    private static Bitmap m53831vs(String str) {
        IOException e;
        Bitmap bitmap;
        Exception e2;
        Throwable th;
        AppMethodBeat.m2504i(124532);
        C4990ab.m7417i("MicroMsg.ContactsUtil", "Get bitmap by HTTPS request. url = %s", str);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.ContactsUtil", "url is null or nil.");
            AppMethodBeat.m2505o(124532);
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("https:")) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            C1937v vb;
            InputStream inputStream;
            try {
                vb = C1897b.m4023vb(trim);
                try {
                    inputStream = vb.gdG.getInputStream();
                    if (inputStream == null) {
                        try {
                            C4990ab.m7413e("MicroMsg.ContactsUtil", "getInputStream failed. url:%s", trim);
                            try {
                                vb.gdG.disconnect();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                byteArrayOutputStream.close();
                            } catch (IOException e3) {
                                C4990ab.m7413e("MicroMsg.ContactsUtil", "disconnect failed, IOException : %s", e3.getMessage());
                                C4990ab.printErrStackTrace("MicroMsg.ContactsUtil", e3, "", new Object[0]);
                            }
                            AppMethodBeat.m2505o(124532);
                            return null;
                        } catch (IOException e4) {
                            e = e4;
                            bitmap = null;
                        } catch (Exception e5) {
                            e2 = e5;
                            bitmap = null;
                            C4990ab.m7413e("MicroMsg.ContactsUtil", "connect failed or url analyse failed, Exception : %s", e2.getMessage());
                            C4990ab.printErrStackTrace("MicroMsg.ContactsUtil", e2, "", new Object[0]);
                            if (vb != null) {
                                try {
                                    vb.gdG.disconnect();
                                } catch (IOException e6) {
                                    C4990ab.m7413e("MicroMsg.ContactsUtil", "disconnect failed, IOException : %s", e6.getMessage());
                                    C4990ab.printErrStackTrace("MicroMsg.ContactsUtil", e6, "", new Object[0]);
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            byteArrayOutputStream.close();
                            AppMethodBeat.m2505o(124532);
                            return bitmap;
                        }
                    }
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    bitmap = C5056d.m7652bQ(byteArrayOutputStream.toByteArray());
                    try {
                        byteArrayOutputStream.close();
                        try {
                            vb.gdG.disconnect();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        } catch (IOException e62) {
                            C4990ab.m7413e("MicroMsg.ContactsUtil", "disconnect failed, IOException : %s", e62.getMessage());
                            C4990ab.printErrStackTrace("MicroMsg.ContactsUtil", e62, "", new Object[0]);
                        }
                    } catch (IOException e622) {
                        e = e622;
                        try {
                            C4990ab.m7413e("MicroMsg.ContactsUtil", "connect failed or url analyse failed, IOException : %s", e.getMessage());
                            C4990ab.printErrStackTrace("MicroMsg.ContactsUtil", e, "", new Object[0]);
                            if (vb != null) {
                                try {
                                    vb.gdG.disconnect();
                                } catch (IOException e6222) {
                                    C4990ab.m7413e("MicroMsg.ContactsUtil", "disconnect failed, IOException : %s", e6222.getMessage());
                                    C4990ab.printErrStackTrace("MicroMsg.ContactsUtil", e6222, "", new Object[0]);
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            byteArrayOutputStream.close();
                            AppMethodBeat.m2505o(124532);
                            return bitmap;
                        } catch (Throwable th2) {
                            th = th2;
                            if (vb != null) {
                                try {
                                    vb.gdG.disconnect();
                                } catch (IOException e62222) {
                                    C4990ab.m7413e("MicroMsg.ContactsUtil", "disconnect failed, IOException : %s", e62222.getMessage());
                                    C4990ab.printErrStackTrace("MicroMsg.ContactsUtil", e62222, "", new Object[0]);
                                    AppMethodBeat.m2505o(124532);
                                    throw th;
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            byteArrayOutputStream.close();
                            AppMethodBeat.m2505o(124532);
                            throw th;
                        }
                    } catch (Exception e7) {
                        e2 = e7;
                        C4990ab.m7413e("MicroMsg.ContactsUtil", "connect failed or url analyse failed, Exception : %s", e2.getMessage());
                        C4990ab.printErrStackTrace("MicroMsg.ContactsUtil", e2, "", new Object[0]);
                        if (vb != null) {
                        }
                        if (inputStream != null) {
                        }
                        byteArrayOutputStream.close();
                        AppMethodBeat.m2505o(124532);
                        return bitmap;
                    }
                    AppMethodBeat.m2505o(124532);
                    return bitmap;
                } catch (IOException e8) {
                    e = e8;
                    inputStream = null;
                    bitmap = null;
                } catch (Exception e9) {
                    e2 = e9;
                    inputStream = null;
                    bitmap = null;
                    C4990ab.m7413e("MicroMsg.ContactsUtil", "connect failed or url analyse failed, Exception : %s", e2.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.ContactsUtil", e2, "", new Object[0]);
                    if (vb != null) {
                    }
                    if (inputStream != null) {
                    }
                    byteArrayOutputStream.close();
                    AppMethodBeat.m2505o(124532);
                    return bitmap;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    if (vb != null) {
                    }
                    if (inputStream != null) {
                    }
                    byteArrayOutputStream.close();
                    AppMethodBeat.m2505o(124532);
                    throw th;
                }
            } catch (IOException e10) {
                e = e10;
                vb = null;
                inputStream = null;
                bitmap = null;
            } catch (Exception e11) {
                e2 = e11;
                vb = null;
                inputStream = null;
                bitmap = null;
                C4990ab.m7413e("MicroMsg.ContactsUtil", "connect failed or url analyse failed, Exception : %s", e2.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.ContactsUtil", e2, "", new Object[0]);
                if (vb != null) {
                }
                if (inputStream != null) {
                }
                byteArrayOutputStream.close();
                AppMethodBeat.m2505o(124532);
                return bitmap;
            } catch (Throwable th4) {
                th = th4;
                vb = null;
                inputStream = null;
                if (vb != null) {
                }
                if (inputStream != null) {
                }
                byteArrayOutputStream.close();
                AppMethodBeat.m2505o(124532);
                throw th;
            }
        }
        C4990ab.m7412e("MicroMsg.ContactsUtil", "this is not the correct https url.");
        AppMethodBeat.m2505o(124532);
        return null;
    }
}
