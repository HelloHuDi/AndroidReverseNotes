package com.tencent.p177mm.plugin.account.model;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C46482a;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.model.b */
public final class C38041b {

    /* renamed from: com.tencent.mm.plugin.account.model.b$b */
    public static final class C18842b implements C26601a {
        private String gyD;
        private int toScene;
        private Uri uri;

        public C18842b(int i, String str, Uri uri) {
            this.toScene = i;
            this.gyD = str;
            this.uri = uri;
        }

        /* renamed from: cy */
        public final int mo5765cy(Context context) {
            AppMethodBeat.m2504i(124659);
            C1720g.m3534RN();
            int columnIndex;
            if (!C1668a.m3395QX() || C1668a.m3393QT()) {
                C4990ab.m7410d("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "not login, start bind login");
                AppMethodBeat.m2505o(124659);
                return 3;
            } else if (C5046bo.isNullOrNil((String) C1720g.m3536RP().mo5239Ry().get(6, (Object) ""))) {
                C4990ab.m7410d("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "not bind mobile, start bind mobie");
                AppMethodBeat.m2505o(124659);
                return 2;
            } else if (!C35805b.m58714o(context, "android.permission.READ_CONTACTS")) {
                C4990ab.m7412e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no contacts permission");
                AppMethodBeat.m2505o(124659);
                return 1;
            } else if (this.uri != null) {
                Cursor query = context.getContentResolver().query(this.uri, new String[]{"contact_id", "_id", "data4"}, null, null, null);
                if (query == null) {
                    C4990ab.m7412e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "query database err");
                    AppMethodBeat.m2505o(124659);
                    return 1;
                } else if (query.moveToFirst()) {
                    columnIndex = query.getColumnIndex("data4");
                    if (columnIndex == -1) {
                        C4990ab.m7412e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no data4 segment exist");
                        query.close();
                        AppMethodBeat.m2505o(124659);
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
                        if (C5046bo.isNullOrNil(str)) {
                            C4990ab.m7412e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "null friendmobile");
                            AppMethodBeat.m2505o(124659);
                            return 1;
                        }
                        columnIndex = m29430d(context, str, string, str2);
                        AppMethodBeat.m2505o(124659);
                        return columnIndex;
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "match error, %s\n%s", e.getMessage(), C5046bo.m7574l(e));
                        C4990ab.m7413e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "result friendMobileMd5 %s contact_id %s data_id %s", str, str2, str3);
                        return 1;
                    } finally {
                        query.close();
                        AppMethodBeat.m2505o(124659);
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "query database err, move to first fail");
                    query.close();
                    AppMethodBeat.m2505o(124659);
                    return 1;
                }
            } else if (C5046bo.isNullOrNil(this.gyD)) {
                C4990ab.m7412e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "uri is null and the phone num is null");
                AppMethodBeat.m2505o(124659);
                return 1;
            } else {
                columnIndex = m29430d(context, C1178g.m2591x(C46482a.m87698ws(this.gyD).getBytes()), null, null);
                AppMethodBeat.m2505o(124659);
                return columnIndex;
            }
        }

        /* renamed from: d */
        private int m29430d(Context context, String str, String str2, String str3) {
            AppMethodBeat.m2504i(124660);
            C18817a vW = C32923a.getAddrUploadStg().mo34092vW(str);
            if (context == null) {
                C4990ab.m7412e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "null context");
                AppMethodBeat.m2505o(124660);
                return 1;
            } else if (vW == null) {
                C4990ab.m7412e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "this user is not my friend");
                AppMethodBeat.m2505o(124660);
                return 1;
            } else {
                String username = vW.getUsername();
                if (C5046bo.isNullOrNil(username)) {
                    C4990ab.m7412e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "get username failed, phonenum md5 is ".concat(String.valueOf(str)));
                    AppMethodBeat.m2505o(124660);
                    return 1;
                }
                if (((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoJ(username)) {
                    C7060h.pYm.mo8381e(11157, Integer.valueOf(this.toScene));
                    Intent intent;
                    C26250ui c26250ui;
                    switch (this.toScene) {
                        case 1:
                            intent = new Intent();
                            intent.putExtra("Chat_User", username);
                            intent.putExtra("finish_direct", true);
                            intent.addFlags(67108864);
                            C24679a.gkE.mo38915d(intent, context);
                            AppMethodBeat.m2505o(124660);
                            return 0;
                        case 2:
                            intent = new Intent();
                            intent.putExtra("sns_userName", username);
                            intent.addFlags(67108864);
                            intent.putExtra("sns_adapter_type", 1);
                            C25985d.m41467b(context, "sns", ".ui.SnsTimeLineUserPagerUI", intent);
                            AppMethodBeat.m2505o(124660);
                            return 0;
                        case 3:
                            c26250ui = new C26250ui();
                            c26250ui.cQx.cAd = 5;
                            c26250ui.cQx.talker = username;
                            c26250ui.cQx.context = context;
                            c26250ui.cQx.cQs = 3;
                            C4879a.xxA.mo10055m(c26250ui);
                            AppMethodBeat.m2505o(124660);
                            return 0;
                        case 4:
                            c26250ui = new C26250ui();
                            c26250ui.cQx.cAd = 5;
                            c26250ui.cQx.talker = username;
                            c26250ui.cQx.context = context;
                            c26250ui.cQx.cQs = 2;
                            C4879a.xxA.mo10055m(c26250ui);
                            AppMethodBeat.m2505o(124660);
                            return 0;
                    }
                } else if (!(C5046bo.isNullOrNil(str3) || C5046bo.isNullOrNil(str2))) {
                    if (C35805b.m58714o(context, "android.permission.READ_CONTACTS")) {
                        Toast.makeText(context, context.getString(C25738R.string.b2w), 1).show();
                        context.getContentResolver().delete(Data.CONTENT_URI, "_id = ?", new String[]{str2});
                        context.getContentResolver().delete(RawContacts.CONTENT_URI, "contact_id = ? AND account_type = ?", new String[]{str3, "com.tencent.mm.account"});
                    } else {
                        C4990ab.m7412e("MicroMsg.ProcessorToChattingOrTimeLineByPhone", "no contact permission");
                        AppMethodBeat.m2505o(124660);
                        return 1;
                    }
                }
                AppMethodBeat.m2505o(124660);
                return 1;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.model.b$a */
    public interface C26601a {
        /* renamed from: cy */
        int mo5765cy(Context context);
    }
}
