package com.tencent.mm.plugin.account.model;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.DataUsageFeedback;
import com.google.android.search.verification.client.SearchActionVerificationClientService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.account.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class VoiceActionService extends SearchActionVerificationClientService {
    public final boolean a(Intent intent, boolean z) {
        AppMethodBeat.i(124711);
        if (z) {
            String stringExtra = intent.getStringExtra("com.google.android.voicesearch.extra.RECIPIENT_CONTACT_CHAT_ID");
            String stringExtra2 = intent.getStringExtra("android.intent.extra.TEXT");
            String username = a.getAddrUploadStg().vW(g.x(com.tencent.mm.pluginsdk.a.ws(stringExtra).getBytes())).getUsername();
            com.tencent.mm.plugin.messenger.a.g.bOk().F(username, stringExtra2, t.nK(username));
            try {
                String str;
                String[] split = intent.getStringExtra("com.google.android.voicesearch.extra.RECIPIENT_CONTACT_URI").split("/");
                if (split == null || split.length <= 0) {
                    str = "";
                } else {
                    str = split[split.length - 1];
                }
                if (bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.VoiceActionService", "extract contact Id error, %s %s", username, stringExtra);
                } else if (b.o(this, "android.permission.READ_CONTACTS")) {
                    Cursor query = getContentResolver().query(Data.CONTENT_URI, new String[]{"_id"}, "contact_id=? AND data1=? AND account_type=? AND mimetype=?", new String[]{str, stringExtra, "com.tencent.mm.account", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction"}, null);
                    if (query == null || query.getCount() <= 0) {
                        ab.i("MicroMsg.VoiceActionService", "updateContactMarked: false");
                    } else {
                        query.moveToNext();
                        boolean z2 = getContentResolver().update(DataUsageFeedback.FEEDBACK_URI.buildUpon().appendPath(String.valueOf(query.getLong(0))).appendQueryParameter("type", "short_text").build(), new ContentValues(), null, null) > 0;
                        ab.i("MicroMsg.VoiceActionService", "updateContactMarked: %b", Boolean.valueOf(z2));
                    }
                    if (query != null) {
                        query.close();
                    }
                } else {
                    ab.e("MicroMsg.VoiceActionService", "no contacts permission");
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.VoiceActionService", e, "updateContactMarked error", new Object[0]);
            }
            AppMethodBeat.o(124711);
            return true;
        }
        ab.i("MicroMsg.VoiceActionService", "Action is not verified");
        AppMethodBeat.o(124711);
        return false;
    }
}
