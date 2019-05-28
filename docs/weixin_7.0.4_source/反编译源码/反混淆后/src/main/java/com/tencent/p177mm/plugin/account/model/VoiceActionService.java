package com.tencent.p177mm.plugin.account.model;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.DataUsageFeedback;
import com.google.android.search.verification.client.SearchActionVerificationClientService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.pluginsdk.C46482a;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.model.VoiceActionService */
public class VoiceActionService extends SearchActionVerificationClientService {
    /* renamed from: a */
    public final boolean mo21263a(Intent intent, boolean z) {
        AppMethodBeat.m2504i(124711);
        if (z) {
            String stringExtra = intent.getStringExtra("com.google.android.voicesearch.extra.RECIPIENT_CONTACT_CHAT_ID");
            String stringExtra2 = intent.getStringExtra("android.intent.extra.TEXT");
            String username = C32923a.getAddrUploadStg().mo34092vW(C1178g.m2591x(C46482a.m87698ws(stringExtra).getBytes())).getUsername();
            C12519g.bOk().mo46456F(username, stringExtra2, C1855t.m3925nK(username));
            try {
                String str;
                String[] split = intent.getStringExtra("com.google.android.voicesearch.extra.RECIPIENT_CONTACT_URI").split("/");
                if (split == null || split.length <= 0) {
                    str = "";
                } else {
                    str = split[split.length - 1];
                }
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7413e("MicroMsg.VoiceActionService", "extract contact Id error, %s %s", username, stringExtra);
                } else if (C35805b.m58714o(this, "android.permission.READ_CONTACTS")) {
                    Cursor query = getContentResolver().query(Data.CONTENT_URI, new String[]{"_id"}, "contact_id=? AND data1=? AND account_type=? AND mimetype=?", new String[]{str, stringExtra, "com.tencent.mm.account", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction"}, null);
                    if (query == null || query.getCount() <= 0) {
                        C4990ab.m7416i("MicroMsg.VoiceActionService", "updateContactMarked: false");
                    } else {
                        query.moveToNext();
                        boolean z2 = getContentResolver().update(DataUsageFeedback.FEEDBACK_URI.buildUpon().appendPath(String.valueOf(query.getLong(0))).appendQueryParameter("type", "short_text").build(), new ContentValues(), null, null) > 0;
                        C4990ab.m7417i("MicroMsg.VoiceActionService", "updateContactMarked: %b", Boolean.valueOf(z2));
                    }
                    if (query != null) {
                        query.close();
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.VoiceActionService", "no contacts permission");
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.VoiceActionService", e, "updateContactMarked error", new Object[0]);
            }
            AppMethodBeat.m2505o(124711);
            return true;
        }
        C4990ab.m7416i("MicroMsg.VoiceActionService", "Action is not verified");
        AppMethodBeat.m2505o(124711);
        return false;
    }
}
