package com.tencent.mm.plugin.account.model;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b {

    public static final class b implements a {
        private String gyD;
        private int toScene;
        private Uri uri;

        public b(int i, String str, Uri uri) {
            this.toScene = i;
            this.gyD = str;
            this.uri = uri;
        }

        public final int cy(Context context) {
            AppMethodBeat.i(124659);
            g.RN();
            int columnIndex;
            if (!com.tencent.mm.kernel.a.QX() || com.tencent.mm.kernel.a.QT()) {
                ab.d("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "not login, start bind login");
                AppMethodBeat.o(124659);
                return 3;
            } else if (bo.isNullOrNil((String) g.RP().Ry().get(6, (Object) ""))) {
                ab.d("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "not bind mobile, start bind mobie");
                AppMethodBeat.o(124659);
                return 2;
            } else if (!com.tencent.mm.pluginsdk.permission.b.o(context, "android.permission.READ_CONTACTS")) {
                ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no contacts permission");
                AppMethodBeat.o(124659);
                return 1;
            } else if (this.uri != null) {
                Cursor query = context.getContentResolver().query(this.uri, new String[]{"contact_id", "_id", "data4"}, null, null, null);
                if (query == null) {
                    ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "query database err");
                    AppMethodBeat.o(124659);
                    return 1;
                } else if (query.moveToFirst()) {
                    columnIndex = query.getColumnIndex("data4");
                    if (columnIndex == -1) {
                        ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no data4 segment exist");
                        query.close();
                        AppMethodBeat.o(124659);
                        return 1;
                    }
                    String str = "";
                    String str2 = "";
                    String str3 = "";
                    try {
                        str = query.getString(columnIndex);
                        columnIndex = query.getColumnIndex("contact_id");
                        str2 = columnIndex >= 0 ? query.getString(columnIndex) : "";
                        columnIndex = query.getColumnIndex("_id");
                        String string = columnIndex >= 0 ? query.getString(columnIndex) : "";
                        query.close();
                        if (bo.isNullOrNil(str)) {
                            ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "null friendmobile");
                            AppMethodBeat.o(124659);
                            return 1;
                        }
                        columnIndex = d(context, str, string, str2);
                        AppMethodBeat.o(124659);
                        return columnIndex;
                    } catch (Exception e) {
                        ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "match error, %s\n%s", e.getMessage(), bo.l(e));
                        ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "result friendMobileMd5 %s contact_id %s data_id %s", str, str2, str3);
                        return 1;
                    } finally {
                        query.close();
                        AppMethodBeat.o(124659);
                    }
                } else {
                    ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "query database err, move to first fail");
                    query.close();
                    AppMethodBeat.o(124659);
                    return 1;
                }
            } else if (bo.isNullOrNil(this.gyD)) {
                ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "uri is null and the phone num is null");
                AppMethodBeat.o(124659);
                return 1;
            } else {
                columnIndex = d(context, com.tencent.mm.a.g.x(com.tencent.mm.pluginsdk.a.ws(this.gyD).getBytes()), null, null);
                AppMethodBeat.o(124659);
                return columnIndex;
            }
        }

        private int d(Context context, String str, String str2, String str3) {
            AppMethodBeat.i(124660);
            com.tencent.mm.plugin.account.friend.a.a vW = com.tencent.mm.plugin.account.a.getAddrUploadStg().vW(str);
            if (context == null) {
                ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "null context");
                AppMethodBeat.o(124660);
                return 1;
            } else if (vW == null) {
                ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "this user is not my friend");
                AppMethodBeat.o(124660);
                return 1;
            } else {
                String username = vW.getUsername();
                if (bo.isNullOrNil(username)) {
                    ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "get username failed, phonenum md5 is ".concat(String.valueOf(str)));
                    AppMethodBeat.o(124660);
                    return 1;
                }
                if (((j) g.K(j.class)).XM().aoJ(username)) {
                    h.pYm.e(11157, Integer.valueOf(this.toScene));
                    Intent intent;
                    ui uiVar;
                    switch (this.toScene) {
                        case 1:
                            intent = new Intent();
                            intent.putExtra("Chat_User", username);
                            intent.putExtra("finish_direct", true);
                            intent.addFlags(67108864);
                            com.tencent.mm.plugin.account.a.a.gkE.d(intent, context);
                            AppMethodBeat.o(124660);
                            return 0;
                        case 2:
                            intent = new Intent();
                            intent.putExtra("sns_userName", username);
                            intent.addFlags(67108864);
                            intent.putExtra("sns_adapter_type", 1);
                            d.b(context, "sns", ".ui.SnsTimeLineUserPagerUI", intent);
                            AppMethodBeat.o(124660);
                            return 0;
                        case 3:
                            uiVar = new ui();
                            uiVar.cQx.cAd = 5;
                            uiVar.cQx.talker = username;
                            uiVar.cQx.context = context;
                            uiVar.cQx.cQs = 3;
                            com.tencent.mm.sdk.b.a.xxA.m(uiVar);
                            AppMethodBeat.o(124660);
                            return 0;
                        case 4:
                            uiVar = new ui();
                            uiVar.cQx.cAd = 5;
                            uiVar.cQx.talker = username;
                            uiVar.cQx.context = context;
                            uiVar.cQx.cQs = 2;
                            com.tencent.mm.sdk.b.a.xxA.m(uiVar);
                            AppMethodBeat.o(124660);
                            return 0;
                    }
                } else if (!(bo.isNullOrNil(str3) || bo.isNullOrNil(str2))) {
                    if (com.tencent.mm.pluginsdk.permission.b.o(context, "android.permission.READ_CONTACTS")) {
                        Toast.makeText(context, context.getString(R.string.b2w), 1).show();
                        context.getContentResolver().delete(Data.CONTENT_URI, "_id = ?", new String[]{str2});
                        context.getContentResolver().delete(RawContacts.CONTENT_URI, "contact_id = ? AND account_type = ?", new String[]{str3, "com.tencent.mm.account"});
                    } else {
                        ab.e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no contact permission");
                        AppMethodBeat.o(124660);
                        return 1;
                    }
                }
                AppMethodBeat.o(124660);
                return 1;
            }
        }
    }

    public interface a {
        int cy(Context context);
    }
}
