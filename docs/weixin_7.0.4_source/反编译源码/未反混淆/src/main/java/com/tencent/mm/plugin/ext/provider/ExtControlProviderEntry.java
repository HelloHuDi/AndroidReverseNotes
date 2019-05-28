package com.tencent.mm.plugin.ext.provider;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.google.android.gms.common.Scopes;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ext.b;
import com.tencent.mm.pluginsdk.d.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bz;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderEntry extends ExtContentProviderBase {
    private static final UriMatcher lQc;
    private String[] lPN;
    private int lPO;
    private boolean lQd;
    private Context lQe;

    static {
        AppMethodBeat.i(20347);
        UriMatcher uriMatcher = new UriMatcher(-1);
        lQc = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.entry", "view_profile", 2);
        lQc.addURI("com.tencent.mm.plugin.ext.entry", "to_chatting", 3);
        lQc.addURI("com.tencent.mm.plugin.ext.entry", "to_nearby", 4);
        lQc.addURI("com.tencent.mm.plugin.ext.entry", "sns_comment_detail", 5);
        lQc.addURI("com.tencent.mm.plugin.ext.entry", "share_time_line", 6);
        AppMethodBeat.o(20347);
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
        AppMethodBeat.i(20343);
        ab.i("MicroMsg.ExtControlEntryProvider", "ExtControlProviderEntry query() mIsLocalUsed :" + this.lQd);
        if (this.lQd) {
            a(uri, this.lQe, this.lPO, this.lPN);
            if (bo.isNullOrNil(this.lPW)) {
                ab.e("MicroMsg.ExtControlEntryProvider", "AppID == null");
                dZ(3, 7);
                MatrixCursor Kn2 = a.Kn(7);
                AppMethodBeat.o(20343);
                return Kn2;
            } else if (bo.isNullOrNil(brL())) {
                ab.e("MicroMsg.ExtControlEntryProvider", "PkgName == null");
                dZ(3, 6);
                Kn = a.Kn(6);
                AppMethodBeat.o(20343);
                return Kn;
            } else {
                int brM = brM();
                if (brM != 1) {
                    ab.e("MicroMsg.ExtControlEntryProvider", "invalid appid ! return code = ".concat(String.valueOf(brM)));
                    dZ(2, brM);
                    Kn = a.Kn(brM);
                    AppMethodBeat.o(20343);
                    return Kn;
                }
            }
        }
        this.lQe = getContext();
        a(uri, this.lQe, lQc);
        if (uri == null) {
            vf(3);
            AppMethodBeat.o(20343);
            return null;
        } else if (bo.isNullOrNil(this.lPW) || bo.isNullOrNil(brL())) {
            vf(3);
            Kn = a.Kn(3);
            AppMethodBeat.o(20343);
            return Kn;
        } else if (!aVl()) {
            vf(1);
            Kn = this.jDN;
            AppMethodBeat.o(20343);
            return Kn;
        } else if (!dJ(this.lQe)) {
            ab.w("MicroMsg.ExtControlEntryProvider", "invalid appid ! return null");
            vf(2);
            AppMethodBeat.o(20343);
            return null;
        }
        String nullAsNil = bo.nullAsNil(uri.getQueryParameter("source"));
        if (!this.lQd) {
            this.lPO = lQc.match(uri);
        }
        switch (this.lPO) {
            case 2:
                Kn = t(strArr2);
                AppMethodBeat.o(20343);
                return Kn;
            case 3:
                Kn = a(strArr2, nullAsNil);
                AppMethodBeat.o(20343);
                return Kn;
            case 4:
                if (this.lQe == null) {
                    vf(4);
                    AppMethodBeat.o(20343);
                    return null;
                }
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI"));
                intent.addFlags(268435456);
                this.lQe.startActivity(intent);
                vf(0);
                Kn = a.Kn(1);
                AppMethodBeat.o(20343);
                return Kn;
            case 5:
                Kn = u(strArr2);
                AppMethodBeat.o(20343);
                return Kn;
            case 6:
                if (strArr2 == null || strArr2.length <= 0) {
                    ab.w("MicroMsg.ExtControlEntryProvider", "wrong args");
                    vf(3);
                    AppMethodBeat.o(20343);
                    return null;
                } else if (this.lQe == null) {
                    vf(4);
                    AppMethodBeat.o(20343);
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
                    vf(0);
                    Kn = a.Kn(1);
                    AppMethodBeat.o(20343);
                    return Kn;
                }
            default:
                dZ(3, 15);
                AppMethodBeat.o(20343);
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

    private Cursor t(String[] strArr) {
        AppMethodBeat.i(20344);
        if (strArr == null || strArr.length <= 0) {
            ab.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            vf(3);
            AppMethodBeat.o(20344);
            return null;
        }
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            ab.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
            vf(3);
            AppMethodBeat.o(20344);
            return null;
        }
        try {
            aw.ZK();
            ad mQ = c.XM().mQ(com.tencent.mm.plugin.ext.a.a.Le(str));
            if (mQ == null || ((int) mQ.ewQ) <= 0 || this.lQe == null) {
                vf(3);
                AppMethodBeat.o(20344);
                return null;
            }
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.putExtra("Contact_User", mQ.field_username);
            d.b(this.lQe, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            vf(0);
            Cursor Kn = a.Kn(1);
            AppMethodBeat.o(20344);
            return Kn;
        } catch (Exception e) {
            ab.w("MicroMsg.ExtControlEntryProvider", e.getMessage());
            ab.printErrStackTrace("MicroMsg.ExtControlEntryProvider", e, "", new Object[0]);
            vf(3);
            AppMethodBeat.o(20344);
            return null;
        }
    }

    private Cursor a(String[] strArr, String str) {
        AppMethodBeat.i(20345);
        ab.i("MicroMsg.ExtControlEntryProvider", "toChattingUI");
        Cursor Kn;
        if (strArr == null || strArr.length <= 0) {
            ab.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            dZ(3, 3601);
            MatrixCursor Kn2 = a.Kn(3601);
            AppMethodBeat.o(20345);
            return Kn2;
        } else if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.ExtControlEntryProvider", "callSource == null");
            dZ(3, 3602);
            Kn = a.Kn(3602);
            AppMethodBeat.o(20345);
            return Kn;
        } else {
            String str2 = strArr[0];
            if (str2 == null || str2.length() <= 0) {
                ab.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
                dZ(3, 3603);
                Kn = a.Kn(3603);
                AppMethodBeat.o(20345);
                return Kn;
            }
            com.tencent.mm.n.a aoO;
            boolean z = str != null && str.equalsIgnoreCase("openapi");
            if (z) {
                try {
                    bz apZ = b.brB().apZ(str2);
                    if (apZ == null || bo.isNullOrNil(apZ.field_openId) || bo.isNullOrNil(apZ.field_username)) {
                        ab.e("MicroMsg.ExtControlEntryProvider", "openidInApp is null");
                        dZ(3, 3604);
                        Kn = a.Kn(3604);
                        AppMethodBeat.o(20345);
                        return Kn;
                    }
                    aw.ZK();
                    aoO = c.XM().aoO(apZ.field_username);
                } catch (Exception e) {
                    ab.w("MicroMsg.ExtControlEntryProvider", e.getMessage());
                    ab.printErrStackTrace("MicroMsg.ExtControlEntryProvider", e, "", new Object[0]);
                    T(5, 4, 12);
                    Kn = a.Kn(12);
                    AppMethodBeat.o(20345);
                    return Kn;
                }
            }
            aw.ZK();
            aoO = c.XM().mQ(com.tencent.mm.plugin.ext.a.a.Le(str2));
            if (aoO == null || ((int) aoO.ewQ) <= 0 || this.lQe == null) {
                ab.e("MicroMsg.ExtControlEntryProvider", "wrong args ct");
                dZ(3, 3605);
                Kn = a.Kn(3605);
                AppMethodBeat.o(20345);
                return Kn;
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.chatting.ChattingUI"));
            intent.putExtra("Chat_User", aoO.field_username);
            intent.putExtra("finish_direct", true);
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            this.lQe.startActivity(intent);
            T(4, 0, 1);
            Kn = a.Kn(1);
            AppMethodBeat.o(20345);
            return Kn;
        }
    }

    private Cursor u(String[] strArr) {
        AppMethodBeat.i(20346);
        if (strArr == null || strArr.length <= 0) {
            ab.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            vf(3);
            AppMethodBeat.o(20346);
            return null;
        }
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            ab.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            vf(3);
            AppMethodBeat.o(20346);
            return null;
        }
        try {
            long Le = com.tencent.mm.plugin.ext.a.a.Le(str);
            if (Le <= 0) {
                vf(3);
                AppMethodBeat.o(20346);
                return null;
            } else if (this.lQe == null) {
                vf(4);
                AppMethodBeat.o(20346);
                return null;
            } else {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI"));
                intent.putExtra("INTENT_SNS_LOCAL_ID", (int) Le);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addFlags(268435456);
                this.lQe.startActivity(intent);
                vf(0);
                Cursor Kn = a.Kn(1);
                AppMethodBeat.o(20346);
                return Kn;
            }
        } catch (Exception e) {
            ab.w("MicroMsg.ExtControlEntryProvider", e.getMessage());
            ab.printErrStackTrace("MicroMsg.ExtControlEntryProvider", e, "", new Object[0]);
            vf(3);
            AppMethodBeat.o(20346);
            return null;
        }
    }
}
