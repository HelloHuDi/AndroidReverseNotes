package com.tencent.p177mm.plugin.ext.provider;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.google.android.gms.common.Scopes;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.ext.C6875b;
import com.tencent.p177mm.plugin.ext.p1398a.C27902a;
import com.tencent.p177mm.pluginsdk.p1568d.p1569a.C40420a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C23512bz;
import com.tencent.p177mm.storage.C7616ad;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
/* renamed from: com.tencent.mm.plugin.ext.provider.ExtControlProviderEntry */
public class ExtControlProviderEntry extends ExtContentProviderBase {
    private static final UriMatcher lQc;
    private String[] lPN;
    private int lPO;
    private boolean lQd;
    private Context lQe;

    static {
        AppMethodBeat.m2504i(20347);
        UriMatcher uriMatcher = new UriMatcher(-1);
        lQc = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.entry", "view_profile", 2);
        lQc.addURI("com.tencent.mm.plugin.ext.entry", "to_chatting", 3);
        lQc.addURI("com.tencent.mm.plugin.ext.entry", "to_nearby", 4);
        lQc.addURI("com.tencent.mm.plugin.ext.entry", "sns_comment_detail", 5);
        lQc.addURI("com.tencent.mm.plugin.ext.entry", "share_time_line", 6);
        AppMethodBeat.m2505o(20347);
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public ExtControlProviderEntry() {
        this.lQd = false;
        this.lPN = null;
        this.lPO = -1;
    }

    public ExtControlProviderEntry(String[] strArr, int i, Context context) {
        this.lQd = false;
        this.lPN = null;
        this.lPO = -1;
        this.lQd = true;
        this.lPN = strArr;
        this.lPO = i;
        this.lQe = context;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor Kn;
        AppMethodBeat.m2504i(20343);
        C4990ab.m7416i("MicroMsg.ExtControlEntryProvider", "ExtControlProviderEntry query() mIsLocalUsed :" + this.lQd);
        if (this.lQd) {
            mo61883a(uri, this.lQe, this.lPO, this.lPN);
            if (C5046bo.isNullOrNil(this.lPW)) {
                C4990ab.m7412e("MicroMsg.ExtControlEntryProvider", "AppID == null");
                mo61889dZ(3, 7);
                MatrixCursor Kn2 = C40420a.m69330Kn(7);
                AppMethodBeat.m2505o(20343);
                return Kn2;
            } else if (C5046bo.isNullOrNil(brL())) {
                C4990ab.m7412e("MicroMsg.ExtControlEntryProvider", "PkgName == null");
                mo61889dZ(3, 6);
                Kn = C40420a.m69330Kn(6);
                AppMethodBeat.m2505o(20343);
                return Kn;
            } else {
                int brM = brM();
                if (brM != 1) {
                    C4990ab.m7412e("MicroMsg.ExtControlEntryProvider", "invalid appid ! return code = ".concat(String.valueOf(brM)));
                    mo61889dZ(2, brM);
                    Kn = C40420a.m69330Kn(brM);
                    AppMethodBeat.m2505o(20343);
                    return Kn;
                }
            }
        }
        this.lQe = getContext();
        mo61884a(uri, this.lQe, lQc);
        if (uri == null) {
            mo61890vf(3);
            AppMethodBeat.m2505o(20343);
            return null;
        } else if (C5046bo.isNullOrNil(this.lPW) || C5046bo.isNullOrNil(brL())) {
            mo61890vf(3);
            Kn = C40420a.m69330Kn(3);
            AppMethodBeat.m2505o(20343);
            return Kn;
        } else if (!aVl()) {
            mo61890vf(1);
            Kn = this.jDN;
            AppMethodBeat.m2505o(20343);
            return Kn;
        } else if (!mo61888dJ(this.lQe)) {
            C4990ab.m7420w("MicroMsg.ExtControlEntryProvider", "invalid appid ! return null");
            mo61890vf(2);
            AppMethodBeat.m2505o(20343);
            return null;
        }
        String nullAsNil = C5046bo.nullAsNil(uri.getQueryParameter("source"));
        if (!this.lQd) {
            this.lPO = lQc.match(uri);
        }
        switch (this.lPO) {
            case 2:
                Kn = m55858t(strArr2);
                AppMethodBeat.m2505o(20343);
                return Kn;
            case 3:
                Kn = m55857a(strArr2, nullAsNil);
                AppMethodBeat.m2505o(20343);
                return Kn;
            case 4:
                if (this.lQe == null) {
                    mo61890vf(4);
                    AppMethodBeat.m2505o(20343);
                    return null;
                }
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI"));
                intent.addFlags(268435456);
                this.lQe.startActivity(intent);
                mo61890vf(0);
                Kn = C40420a.m69330Kn(1);
                AppMethodBeat.m2505o(20343);
                return Kn;
            case 5:
                Kn = m55859u(strArr2);
                AppMethodBeat.m2505o(20343);
                return Kn;
            case 6:
                if (strArr2 == null || strArr2.length <= 0) {
                    C4990ab.m7420w("MicroMsg.ExtControlEntryProvider", "wrong args");
                    mo61890vf(3);
                    AppMethodBeat.m2505o(20343);
                    return null;
                } else if (this.lQe == null) {
                    mo61890vf(4);
                    AppMethodBeat.m2505o(20343);
                    return null;
                } else {
                    Intent intent2 = new Intent();
                    intent2.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI"));
                    intent2.setAction("android.intent.action.SEND");
                    intent2.addCategory("android.intent.category.DEFAULT");
                    intent2.addFlags(268435456);
                    intent2.putExtra("android.intent.extra.TEXT", strArr2[1] == null ? "" : strArr2[1]);
                    if (strArr2[0] != null && strArr2[0].trim().length() > 0) {
                        intent2.putExtra("android.intent.extra.STREAM", Uri.parse(strArr2[0]));
                    }
                    intent2.putExtra("Ksnsupload_empty_img", true);
                    intent2.setType("image/*");
                    this.lQe.startActivity(intent2);
                    mo61890vf(0);
                    Kn = C40420a.m69330Kn(1);
                    AppMethodBeat.m2505o(20343);
                    return Kn;
                }
            default:
                mo61889dZ(3, 15);
                AppMethodBeat.m2505o(20343);
                return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    /* renamed from: t */
    private Cursor m55858t(String[] strArr) {
        AppMethodBeat.m2504i(20344);
        if (strArr == null || strArr.length <= 0) {
            C4990ab.m7420w("MicroMsg.ExtControlEntryProvider", "wrong args");
            mo61890vf(3);
            AppMethodBeat.m2505o(20344);
            return null;
        }
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            C4990ab.m7420w("MicroMsg.ExtControlEntryProvider", "contactId == null");
            mo61890vf(3);
            AppMethodBeat.m2505o(20344);
            return null;
        }
        try {
            C9638aw.m17190ZK();
            C7616ad mQ = C18628c.m29078XM().mo15763mQ(C27902a.m44381Le(str));
            if (mQ == null || ((int) mQ.ewQ) <= 0 || this.lQe == null) {
                mo61890vf(3);
                AppMethodBeat.m2505o(20344);
                return null;
            }
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.putExtra("Contact_User", mQ.field_username);
            C25985d.m41467b(this.lQe, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            mo61890vf(0);
            Cursor Kn = C40420a.m69330Kn(1);
            AppMethodBeat.m2505o(20344);
            return Kn;
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.ExtControlEntryProvider", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.ExtControlEntryProvider", e, "", new Object[0]);
            mo61890vf(3);
            AppMethodBeat.m2505o(20344);
            return null;
        }
    }

    /* renamed from: a */
    private Cursor m55857a(String[] strArr, String str) {
        AppMethodBeat.m2504i(20345);
        C4990ab.m7416i("MicroMsg.ExtControlEntryProvider", "toChattingUI");
        Cursor Kn;
        if (strArr == null || strArr.length <= 0) {
            C4990ab.m7420w("MicroMsg.ExtControlEntryProvider", "wrong args");
            mo61889dZ(3, 3601);
            MatrixCursor Kn2 = C40420a.m69330Kn(3601);
            AppMethodBeat.m2505o(20345);
            return Kn2;
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.ExtControlEntryProvider", "callSource == null");
            mo61889dZ(3, 3602);
            Kn = C40420a.m69330Kn(3602);
            AppMethodBeat.m2505o(20345);
            return Kn;
        } else {
            String str2 = strArr[0];
            if (str2 == null || str2.length() <= 0) {
                C4990ab.m7420w("MicroMsg.ExtControlEntryProvider", "contactId == null");
                mo61889dZ(3, 3603);
                Kn = C40420a.m69330Kn(3603);
                AppMethodBeat.m2505o(20345);
                return Kn;
            }
            C7486a aoO;
            boolean z = str != null && str.equalsIgnoreCase("openapi");
            if (z) {
                try {
                    C23512bz apZ = C6875b.brB().apZ(str2);
                    if (apZ == null || C5046bo.isNullOrNil(apZ.field_openId) || C5046bo.isNullOrNil(apZ.field_username)) {
                        C4990ab.m7412e("MicroMsg.ExtControlEntryProvider", "openidInApp is null");
                        mo61889dZ(3, 3604);
                        Kn = C40420a.m69330Kn(3604);
                        AppMethodBeat.m2505o(20345);
                        return Kn;
                    }
                    C9638aw.m17190ZK();
                    aoO = C18628c.m29078XM().aoO(apZ.field_username);
                } catch (Exception e) {
                    C4990ab.m7420w("MicroMsg.ExtControlEntryProvider", e.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.ExtControlEntryProvider", e, "", new Object[0]);
                    mo61881T(5, 4, 12);
                    Kn = C40420a.m69330Kn(12);
                    AppMethodBeat.m2505o(20345);
                    return Kn;
                }
            }
            C9638aw.m17190ZK();
            aoO = C18628c.m29078XM().mo15763mQ(C27902a.m44381Le(str2));
            if (aoO == null || ((int) aoO.ewQ) <= 0 || this.lQe == null) {
                C4990ab.m7412e("MicroMsg.ExtControlEntryProvider", "wrong args ct");
                mo61889dZ(3, 3605);
                Kn = C40420a.m69330Kn(3605);
                AppMethodBeat.m2505o(20345);
                return Kn;
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.chatting.ChattingUI"));
            intent.putExtra("Chat_User", aoO.field_username);
            intent.putExtra("finish_direct", true);
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            this.lQe.startActivity(intent);
            mo61881T(4, 0, 1);
            Kn = C40420a.m69330Kn(1);
            AppMethodBeat.m2505o(20345);
            return Kn;
        }
    }

    /* renamed from: u */
    private Cursor m55859u(String[] strArr) {
        AppMethodBeat.m2504i(20346);
        if (strArr == null || strArr.length <= 0) {
            C4990ab.m7420w("MicroMsg.ExtControlEntryProvider", "wrong args");
            mo61890vf(3);
            AppMethodBeat.m2505o(20346);
            return null;
        }
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            C4990ab.m7420w("MicroMsg.ExtControlEntryProvider", "wrong args");
            mo61890vf(3);
            AppMethodBeat.m2505o(20346);
            return null;
        }
        try {
            long Le = C27902a.m44381Le(str);
            if (Le <= 0) {
                mo61890vf(3);
                AppMethodBeat.m2505o(20346);
                return null;
            } else if (this.lQe == null) {
                mo61890vf(4);
                AppMethodBeat.m2505o(20346);
                return null;
            } else {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI"));
                intent.putExtra("INTENT_SNS_LOCAL_ID", (int) Le);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addFlags(268435456);
                this.lQe.startActivity(intent);
                mo61890vf(0);
                Cursor Kn = C40420a.m69330Kn(1);
                AppMethodBeat.m2505o(20346);
                return Kn;
            }
        } catch (Exception e) {
            C4990ab.m7420w("MicroMsg.ExtControlEntryProvider", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.ExtControlEntryProvider", e, "", new Object[0]);
            mo61890vf(3);
            AppMethodBeat.m2505o(20346);
            return null;
        }
    }
}
