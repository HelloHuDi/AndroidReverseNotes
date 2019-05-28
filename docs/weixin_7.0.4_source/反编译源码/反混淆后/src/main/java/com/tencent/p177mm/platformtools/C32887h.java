package com.tencent.p177mm.platformtools;

import android.accounts.Account;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import android.os.RemoteException;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import com.google.android.gms.common.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18818b;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.platformtools.h */
public final class C32887h implements Runnable {
    private String cEr;
    private Account ggY;
    private C32888a ggZ;
    private Looper gha;
    private Context mContext;
    private String username;

    /* renamed from: com.tencent.mm.platformtools.h$a */
    public class C32888a {
        private final String TAG = "MicroMsg.BatchOperation";
        private final ContentResolver ghb;
        ArrayList<ContentProviderOperation> ghc;

        public C32888a(ContentResolver contentResolver) {
            AppMethodBeat.m2504i(124518);
            this.ghb = contentResolver;
            this.ghc = new ArrayList();
            AppMethodBeat.m2505o(124518);
        }

        /* renamed from: a */
        public final void mo53456a(ContentProviderOperation contentProviderOperation) {
            AppMethodBeat.m2504i(124519);
            this.ghc.add(contentProviderOperation);
            AppMethodBeat.m2505o(124519);
        }

        public final void execute() {
            AppMethodBeat.m2504i(124520);
            if (this.ghc.size() == 0) {
                C4990ab.m7410d("MicroMsg.BatchOperation", "no batch operation");
                AppMethodBeat.m2505o(124520);
            } else if (C35805b.m58714o(C32887h.this.mContext, "android.permission.READ_CONTACTS")) {
                try {
                    this.ghb.applyBatch("com.android.contacts", this.ghc);
                } catch (OperationApplicationException e) {
                    C4990ab.m7413e("MicroMsg.BatchOperation", "apply batch operation failed", e.toString());
                } catch (RemoteException e2) {
                    C4990ab.m7413e("MicroMsg.BatchOperation", "apply batch operation failed", e2.toString());
                } catch (Exception e3) {
                    C4990ab.m7413e("MicroMsg.BatchOperation", "apply batch operation failed", e3.toString());
                }
                this.ghc.clear();
                AppMethodBeat.m2505o(124520);
            } else {
                C4990ab.m7412e("MicroMsg.BatchOperation", "no contact permission");
                AppMethodBeat.m2505o(124520);
            }
        }
    }

    public C32887h(Context context, Account account) {
        this(context, account, null, null);
    }

    public C32887h(Context context, Account account, String str) {
        this(context, account, str, null);
    }

    public C32887h(Context context, Account account, String str, String str2) {
        AppMethodBeat.m2504i(124521);
        this.mContext = context;
        this.ggY = account;
        this.username = str;
        this.cEr = str2;
        C4990ab.m7416i("MicroMsg.ContactsOperations", "username = " + str + ", " + str2);
        AppMethodBeat.m2505o(124521);
    }

    public final void run() {
        AppMethodBeat.m2504i(124522);
        Looper.prepare();
        this.gha = Looper.myLooper();
        C4990ab.m7416i("MicroMsg.ContactsOperations", "start time:".concat(String.valueOf(System.currentTimeMillis())));
        if (C1720g.m3534RN().mo5161QY()) {
            C18817a vT;
            if (C5046bo.isNullOrNil(this.username) && C5046bo.isNullOrNil(this.cEr)) {
                anG();
            } else if (C5046bo.isNullOrNil(this.cEr)) {
                vT = ((C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg()).mo34089vT(this.username);
                if (!(vT == null || C5046bo.isNullOrNil(vT.guM))) {
                    m53825vq(vT.guM);
                }
                quit();
            } else {
                C18817a vT2;
                vT = ((C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg()).mo34089vT(this.username);
                if (vT == null || C5046bo.isNullOrNil(vT.guM)) {
                    vT2 = ((C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg()).mo34089vT(this.cEr);
                } else {
                    vT2 = vT;
                }
                if (vT2 == null || C5046bo.isNullOrNil(vT2.guM)) {
                    C4990ab.m7410d("MicroMsg.ContactsOperations", "query addrupload is null " + this.username);
                } else {
                    try {
                        if (C35805b.m58714o(this.mContext, "android.permission.READ_CONTACTS")) {
                            Cursor query = this.mContext.getContentResolver().query(RawContacts.CONTENT_URI.buildUpon().appendQueryParameter(Constants.KEY_ACCOUNT_NAME, this.ggY.name).appendQueryParameter("account_type", this.ggY.type).build(), new String[]{"sync1", "_id"}, "deleted=\"0\" AND sync1=\"" + vT2.guM + "\"", null, null);
                            if (query == null || query.getCount() == 0) {
                                String apD = C5046bo.isNullOrNil(vT2.apA()) ? vT2.apD() : vT2.apA();
                                this.ggZ = new C32888a(this.mContext.getContentResolver());
                                m53824e(apD, vT2.apG(), vT2.guM, this.username);
                                this.ggZ.execute();
                            }
                            if (query != null) {
                                query.close();
                            }
                        } else {
                            C4990ab.m7412e("MicroMsg.ContactsOperations", "no contact permission");
                        }
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.ContactsOperations", e, "", "");
                    }
                }
                quit();
            }
            C4990ab.m7416i("MicroMsg.ContactsOperations", "end time:" + System.currentTimeMillis());
            Looper.loop();
            AppMethodBeat.m2505o(124522);
            return;
        }
        C4990ab.m7420w("MicroMsg.ContactsOperations", "account not ready, quit this operation");
        quit();
        AppMethodBeat.m2505o(124522);
    }

    private void quit() {
        AppMethodBeat.m2504i(124523);
        if (this.gha != null) {
            this.gha.quit();
        }
        AppMethodBeat.m2505o(124523);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00dc A:{SYNTHETIC, Splitter:B:26:0x00dc} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00dc A:{SYNTHETIC, Splitter:B:26:0x00dc} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0109  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void anG() {
        Throwable e;
        Object obj;
        AppMethodBeat.m2504i(124524);
        if (C1720g.m3531RK()) {
            List<C18817a> vX = ((C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg()).mo34093vX("select  *  from addr_upload2 where ( addr_upload2.username IS NOT NULL AND addr_upload2.status!=\"0\" AND addr_upload2.username!=\"" + C5046bo.m7586vA("") + "\" )");
            if (vX.size() == 0) {
                C4990ab.m7412e("MicroMsg.ContactsOperations", "there is no wechat friend in this phone");
                quit();
                AppMethodBeat.m2505o(124524);
            } else {
                HashMap hashMap = new HashMap();
                Uri build = RawContacts.CONTENT_URI.buildUpon().appendQueryParameter(Constants.KEY_ACCOUNT_NAME, this.ggY.name).appendQueryParameter("account_type", this.ggY.type).build();
                if (C35805b.m58714o(this.mContext, "android.permission.READ_CONTACTS")) {
                    Cursor query;
                    try {
                        query = this.mContext.getContentResolver().query(build, new String[]{"sync1", "_id"}, "deleted=\"0\"", null, null);
                        if (query == null) {
                            try {
                                C4990ab.m7412e("MicroMsg.ContactsOperations", "query get no user");
                            } catch (Exception e2) {
                                e = e2;
                                C4990ab.printErrStackTrace("MicroMsg.ContactsOperations", e, "", "");
                                if (query != null) {
                                }
                                if (!m53826vr("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video")) {
                                }
                                obj = null;
                                this.ggZ = new C32888a(this.mContext.getContentResolver());
                                for (C18817a c18817a : vX) {
                                }
                                this.ggZ.execute();
                                quit();
                                AppMethodBeat.m2505o(124524);
                            }
                            if (query != null) {
                                query.close();
                            }
                            if (m53826vr("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video") || m53826vr("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip")) {
                                obj = null;
                            } else {
                                obj = 1;
                            }
                            this.ggZ = new C32888a(this.mContext.getContentResolver());
                            for (C18817a c18817a2 : vX) {
                                String username = c18817a2.getUsername();
                                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(username);
                                if (aoO == null || !C7486a.m12942jh(aoO.field_type)) {
                                    m53825vq(c18817a2.guM);
                                } else {
                                    String apD = C5046bo.isNullOrNil(c18817a2.apA()) ? c18817a2.apD() : c18817a2.apA();
                                    String apG = c18817a2.apG();
                                    String str = c18817a2.guM;
                                    if (hashMap.get(str) == null || obj != null) {
                                        if (hashMap.get(str) != null) {
                                            m53825vq(str);
                                        }
                                        m53824e(apD, apG, str, username);
                                    }
                                    this.ggZ.execute();
                                }
                            }
                            this.ggZ.execute();
                            quit();
                            AppMethodBeat.m2505o(124524);
                        } else {
                            if (query.moveToFirst()) {
                                do {
                                    hashMap.put(query.getString(0), Long.valueOf(query.getLong(1)));
                                } while (query.moveToNext());
                            }
                            if (query != null) {
                            }
                            if (m53826vr("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video")) {
                            }
                            obj = null;
                            this.ggZ = new C32888a(this.mContext.getContentResolver());
                            for (C18817a c18817a22 : vX) {
                            }
                            this.ggZ.execute();
                            quit();
                            AppMethodBeat.m2505o(124524);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        query = null;
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.ContactsOperations", "no contact permission");
                    AppMethodBeat.m2505o(124524);
                }
            }
        } else {
            C4990ab.m7410d("MicroMsg.ContactsOperations", "account not ready, quit this operation");
            quit();
            AppMethodBeat.m2505o(124524);
        }
    }

    /* renamed from: e */
    private void m53824e(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(124525);
        C4990ab.m7410d("MicroMsg.ContactsOperations", "add wechat contact: displayname:" + str + ", phoneNum:" + str2 + ", " + str3 + ", username:" + str4);
        Builder newInsert = ContentProviderOperation.newInsert(RawContacts.CONTENT_URI);
        newInsert.withValue(Constants.KEY_ACCOUNT_NAME, this.ggY.name);
        newInsert.withValue("account_type", this.ggY.type);
        newInsert.withValue("sync1", str3);
        this.ggZ.mo53456a(newInsert.build());
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/name");
        newInsert.withValue("data1", str);
        this.ggZ.mo53456a(newInsert.build());
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile");
        newInsert.withValue("data1", str2);
        newInsert.withValue("data2", this.mContext.getString(C25738R.string.f9176ru));
        newInsert.withValue("data3", this.mContext.getString(C25738R.string.b2p));
        newInsert.withValue("data4", str3);
        this.ggZ.mo53456a(newInsert.build());
        if ("1".equals(C26373g.m41964Nu().getValue("VOIPCallType"))) {
            newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", 0);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video");
            newInsert.withValue("data1", str2);
            newInsert.withValue("data2", this.mContext.getString(C25738R.string.f9176ru));
            newInsert.withValue("data3", this.mContext.getString(C25738R.string.b2r));
            newInsert.withValue("data4", str3);
            this.ggZ.mo53456a(newInsert.build());
        } else {
            newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", 0);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip");
            newInsert.withValue("data1", str2);
            newInsert.withValue("data2", this.mContext.getString(C25738R.string.f9176ru));
            newInsert.withValue("data3", this.mContext.getString(C25738R.string.b2q));
            newInsert.withValue("data4", str3);
            this.ggZ.mo53456a(newInsert.build());
        }
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline");
        newInsert.withValue("data1", str2);
        newInsert.withValue("data2", this.mContext.getString(C25738R.string.f9176ru));
        newInsert.withValue("data3", this.mContext.getString(C25738R.string.b2s));
        newInsert.withValue("data4", str3);
        this.ggZ.mo53456a(newInsert.build());
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction");
        newInsert.withValue("data1", str2);
        newInsert.withValue("data2", this.mContext.getString(C25738R.string.f9176ru));
        newInsert.withValue("data3", "");
        newInsert.withValue("data4", str3);
        this.ggZ.mo53456a(newInsert.build());
        AppMethodBeat.m2505o(124525);
    }

    /* renamed from: vq */
    private void m53825vq(String str) {
        AppMethodBeat.m2504i(124526);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.ContactsOperations", "delete wechat contact fail, phoneNum5 is null");
            AppMethodBeat.m2505o(124526);
        } else if (C35805b.m58714o(this.mContext, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                query = this.mContext.getContentResolver().query(Data.CONTENT_URI, new String[]{"contact_id", "_id"}, "(mimetype= ? or mimetype= ? or mimetype= ? or mimetype= ? or mimetype= ?) AND data4 = ?", new String[]{"vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile", "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction", str}, null);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.ContactsOperations", "query fail, match error %s \n %s", e.getMessage(), C5046bo.m7574l(e));
                query = null;
            }
            if (query == null) {
                C4990ab.m7412e("MicroMsg.ContactsOperations", "get null cursor");
                AppMethodBeat.m2505o(124526);
                return;
            }
            try {
                if (query.moveToFirst()) {
                    do {
                        int columnIndex = query.getColumnIndex("contact_id");
                        String string = columnIndex >= 0 ? query.getString(columnIndex) : "";
                        columnIndex = query.getColumnIndex("_id");
                        String string2 = columnIndex >= 0 ? query.getString(columnIndex) : "";
                        if (!(C5046bo.isNullOrNil(string) || C5046bo.isNullOrNil(string2))) {
                            this.mContext.getContentResolver().delete(Data.CONTENT_URI, "_id = ?", new String[]{string2});
                            this.mContext.getContentResolver().delete(RawContacts.CONTENT_URI, "contact_id = ? AND account_type = ?", new String[]{string, "com.tencent.mm.account"});
                        }
                    } while (query.moveToNext());
                }
            } catch (Exception e2) {
                C4990ab.m7412e("MicroMsg.ContactsOperations", "delete wechat contact failed : " + e2.getMessage());
            }
            query.close();
            AppMethodBeat.m2505o(124526);
        } else {
            C4990ab.m7412e("MicroMsg.ContactsOperations", "no contact permission");
            AppMethodBeat.m2505o(124526);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: vr */
    private boolean m53826vr(String str) {
        Exception e;
        boolean z = false;
        AppMethodBeat.m2504i(124527);
        if (C35805b.m58714o(this.mContext, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                boolean z2;
                query = this.mContext.getContentResolver().query(Data.CONTENT_URI, new String[]{"contact_id"}, "mimetype= ?", new String[]{str}, null);
                if (query != null) {
                    try {
                        if (query.getCount() > 0) {
                            C4990ab.m7410d("MicroMsg.ContactsOperations", "has minetype:".concat(String.valueOf(str)));
                            z2 = true;
                            z = z2;
                            if (query != null) {
                                query.close();
                            }
                            AppMethodBeat.m2505o(124527);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        C4990ab.m7412e("MicroMsg.ContactsOperations", "hasMIMEType search failed : " + e.getMessage());
                        z = true;
                        if (query != null) {
                        }
                        AppMethodBeat.m2505o(124527);
                        return z;
                    }
                }
                z2 = false;
                z = z2;
            } catch (Exception e3) {
                e = e3;
                query = null;
            }
            if (query != null) {
            }
            AppMethodBeat.m2505o(124527);
        } else {
            C4990ab.m7412e("MicroMsg.ContactsOperations", "no contact permission");
            AppMethodBeat.m2505o(124527);
        }
        return z;
    }
}
