package com.tencent.mm.platformtools;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class h implements Runnable {
    private String cEr;
    private Account ggY;
    private a ggZ;
    private Looper gha;
    private Context mContext;
    private String username;

    public class a {
        private final String TAG = "MicroMsg.BatchOperation";
        private final ContentResolver ghb;
        ArrayList<ContentProviderOperation> ghc;

        public a(ContentResolver contentResolver) {
            AppMethodBeat.i(124518);
            this.ghb = contentResolver;
            this.ghc = new ArrayList();
            AppMethodBeat.o(124518);
        }

        public final void a(ContentProviderOperation contentProviderOperation) {
            AppMethodBeat.i(124519);
            this.ghc.add(contentProviderOperation);
            AppMethodBeat.o(124519);
        }

        public final void execute() {
            AppMethodBeat.i(124520);
            if (this.ghc.size() == 0) {
                ab.d("MicroMsg.BatchOperation", "no batch operation");
                AppMethodBeat.o(124520);
            } else if (b.o(h.this.mContext, "android.permission.READ_CONTACTS")) {
                try {
                    this.ghb.applyBatch("com.android.contacts", this.ghc);
                } catch (OperationApplicationException e) {
                    ab.e("MicroMsg.BatchOperation", "apply batch operation failed", e.toString());
                } catch (RemoteException e2) {
                    ab.e("MicroMsg.BatchOperation", "apply batch operation failed", e2.toString());
                } catch (Exception e3) {
                    ab.e("MicroMsg.BatchOperation", "apply batch operation failed", e3.toString());
                }
                this.ghc.clear();
                AppMethodBeat.o(124520);
            } else {
                ab.e("MicroMsg.BatchOperation", "no contact permission");
                AppMethodBeat.o(124520);
            }
        }
    }

    public h(Context context, Account account) {
        this(context, account, null, null);
    }

    public h(Context context, Account account, String str) {
        this(context, account, str, null);
    }

    public h(Context context, Account account, String str, String str2) {
        AppMethodBeat.i(124521);
        this.mContext = context;
        this.ggY = account;
        this.username = str;
        this.cEr = str2;
        ab.i("MicroMsg.ContactsOperations", "username = " + str + ", " + str2);
        AppMethodBeat.o(124521);
    }

    public final void run() {
        AppMethodBeat.i(124522);
        Looper.prepare();
        this.gha = Looper.myLooper();
        ab.i("MicroMsg.ContactsOperations", "start time:".concat(String.valueOf(System.currentTimeMillis())));
        if (g.RN().QY()) {
            com.tencent.mm.plugin.account.friend.a.a vT;
            if (bo.isNullOrNil(this.username) && bo.isNullOrNil(this.cEr)) {
                anG();
            } else if (bo.isNullOrNil(this.cEr)) {
                vT = ((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).vT(this.username);
                if (!(vT == null || bo.isNullOrNil(vT.guM))) {
                    vq(vT.guM);
                }
                quit();
            } else {
                com.tencent.mm.plugin.account.friend.a.a vT2;
                vT = ((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).vT(this.username);
                if (vT == null || bo.isNullOrNil(vT.guM)) {
                    vT2 = ((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).vT(this.cEr);
                } else {
                    vT2 = vT;
                }
                if (vT2 == null || bo.isNullOrNil(vT2.guM)) {
                    ab.d("MicroMsg.ContactsOperations", "query addrupload is null " + this.username);
                } else {
                    try {
                        if (b.o(this.mContext, "android.permission.READ_CONTACTS")) {
                            Cursor query = this.mContext.getContentResolver().query(RawContacts.CONTENT_URI.buildUpon().appendQueryParameter(Constants.KEY_ACCOUNT_NAME, this.ggY.name).appendQueryParameter("account_type", this.ggY.type).build(), new String[]{"sync1", "_id"}, "deleted=\"0\" AND sync1=\"" + vT2.guM + "\"", null, null);
                            if (query == null || query.getCount() == 0) {
                                String apD = bo.isNullOrNil(vT2.apA()) ? vT2.apD() : vT2.apA();
                                this.ggZ = new a(this.mContext.getContentResolver());
                                e(apD, vT2.apG(), vT2.guM, this.username);
                                this.ggZ.execute();
                            }
                            if (query != null) {
                                query.close();
                            }
                        } else {
                            ab.e("MicroMsg.ContactsOperations", "no contact permission");
                        }
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.ContactsOperations", e, "", "");
                    }
                }
                quit();
            }
            ab.i("MicroMsg.ContactsOperations", "end time:" + System.currentTimeMillis());
            Looper.loop();
            AppMethodBeat.o(124522);
            return;
        }
        ab.w("MicroMsg.ContactsOperations", "account not ready, quit this operation");
        quit();
        AppMethodBeat.o(124522);
    }

    private void quit() {
        AppMethodBeat.i(124523);
        if (this.gha != null) {
            this.gha.quit();
        }
        AppMethodBeat.o(124523);
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
        AppMethodBeat.i(124524);
        if (g.RK()) {
            List<com.tencent.mm.plugin.account.friend.a.a> vX = ((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).vX("select  *  from addr_upload2 where ( addr_upload2.username IS NOT NULL AND addr_upload2.status!=\"0\" AND addr_upload2.username!=\"" + bo.vA("") + "\" )");
            if (vX.size() == 0) {
                ab.e("MicroMsg.ContactsOperations", "there is no wechat friend in this phone");
                quit();
                AppMethodBeat.o(124524);
            } else {
                HashMap hashMap = new HashMap();
                Uri build = RawContacts.CONTENT_URI.buildUpon().appendQueryParameter(Constants.KEY_ACCOUNT_NAME, this.ggY.name).appendQueryParameter("account_type", this.ggY.type).build();
                if (b.o(this.mContext, "android.permission.READ_CONTACTS")) {
                    Cursor query;
                    try {
                        query = this.mContext.getContentResolver().query(build, new String[]{"sync1", "_id"}, "deleted=\"0\"", null, null);
                        if (query == null) {
                            try {
                                ab.e("MicroMsg.ContactsOperations", "query get no user");
                            } catch (Exception e2) {
                                e = e2;
                                ab.printErrStackTrace("MicroMsg.ContactsOperations", e, "", "");
                                if (query != null) {
                                }
                                if (!vr("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video")) {
                                }
                                obj = null;
                                this.ggZ = new a(this.mContext.getContentResolver());
                                for (com.tencent.mm.plugin.account.friend.a.a aVar : vX) {
                                }
                                this.ggZ.execute();
                                quit();
                                AppMethodBeat.o(124524);
                            }
                            if (query != null) {
                                query.close();
                            }
                            if (vr("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video") || vr("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip")) {
                                obj = null;
                            } else {
                                obj = 1;
                            }
                            this.ggZ = new a(this.mContext.getContentResolver());
                            for (com.tencent.mm.plugin.account.friend.a.a aVar2 : vX) {
                                String username = aVar2.getUsername();
                                ad aoO = ((j) g.K(j.class)).XM().aoO(username);
                                if (aoO == null || !com.tencent.mm.n.a.jh(aoO.field_type)) {
                                    vq(aVar2.guM);
                                } else {
                                    String apD = bo.isNullOrNil(aVar2.apA()) ? aVar2.apD() : aVar2.apA();
                                    String apG = aVar2.apG();
                                    String str = aVar2.guM;
                                    if (hashMap.get(str) == null || obj != null) {
                                        if (hashMap.get(str) != null) {
                                            vq(str);
                                        }
                                        e(apD, apG, str, username);
                                    }
                                    this.ggZ.execute();
                                }
                            }
                            this.ggZ.execute();
                            quit();
                            AppMethodBeat.o(124524);
                        } else {
                            if (query.moveToFirst()) {
                                do {
                                    hashMap.put(query.getString(0), Long.valueOf(query.getLong(1)));
                                } while (query.moveToNext());
                            }
                            if (query != null) {
                            }
                            if (vr("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video")) {
                            }
                            obj = null;
                            this.ggZ = new a(this.mContext.getContentResolver());
                            for (com.tencent.mm.plugin.account.friend.a.a aVar22 : vX) {
                            }
                            this.ggZ.execute();
                            quit();
                            AppMethodBeat.o(124524);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        query = null;
                    }
                } else {
                    ab.e("MicroMsg.ContactsOperations", "no contact permission");
                    AppMethodBeat.o(124524);
                }
            }
        } else {
            ab.d("MicroMsg.ContactsOperations", "account not ready, quit this operation");
            quit();
            AppMethodBeat.o(124524);
        }
    }

    private void e(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(124525);
        ab.d("MicroMsg.ContactsOperations", "add wechat contact: displayname:" + str + ", phoneNum:" + str2 + ", " + str3 + ", username:" + str4);
        Builder newInsert = ContentProviderOperation.newInsert(RawContacts.CONTENT_URI);
        newInsert.withValue(Constants.KEY_ACCOUNT_NAME, this.ggY.name);
        newInsert.withValue("account_type", this.ggY.type);
        newInsert.withValue("sync1", str3);
        this.ggZ.a(newInsert.build());
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/name");
        newInsert.withValue("data1", str);
        this.ggZ.a(newInsert.build());
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile");
        newInsert.withValue("data1", str2);
        newInsert.withValue("data2", this.mContext.getString(R.string.ru));
        newInsert.withValue("data3", this.mContext.getString(R.string.b2p));
        newInsert.withValue("data4", str3);
        this.ggZ.a(newInsert.build());
        if ("1".equals(com.tencent.mm.m.g.Nu().getValue("VOIPCallType"))) {
            newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", 0);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video");
            newInsert.withValue("data1", str2);
            newInsert.withValue("data2", this.mContext.getString(R.string.ru));
            newInsert.withValue("data3", this.mContext.getString(R.string.b2r));
            newInsert.withValue("data4", str3);
            this.ggZ.a(newInsert.build());
        } else {
            newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", 0);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip");
            newInsert.withValue("data1", str2);
            newInsert.withValue("data2", this.mContext.getString(R.string.ru));
            newInsert.withValue("data3", this.mContext.getString(R.string.b2q));
            newInsert.withValue("data4", str3);
            this.ggZ.a(newInsert.build());
        }
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline");
        newInsert.withValue("data1", str2);
        newInsert.withValue("data2", this.mContext.getString(R.string.ru));
        newInsert.withValue("data3", this.mContext.getString(R.string.b2s));
        newInsert.withValue("data4", str3);
        this.ggZ.a(newInsert.build());
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction");
        newInsert.withValue("data1", str2);
        newInsert.withValue("data2", this.mContext.getString(R.string.ru));
        newInsert.withValue("data3", "");
        newInsert.withValue("data4", str3);
        this.ggZ.a(newInsert.build());
        AppMethodBeat.o(124525);
    }

    private void vq(String str) {
        AppMethodBeat.i(124526);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.ContactsOperations", "delete wechat contact fail, phoneNum5 is null");
            AppMethodBeat.o(124526);
        } else if (b.o(this.mContext, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                query = this.mContext.getContentResolver().query(Data.CONTENT_URI, new String[]{"contact_id", "_id"}, "(mimetype= ? or mimetype= ? or mimetype= ? or mimetype= ? or mimetype= ?) AND data4 = ?", new String[]{"vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile", "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction", str}, null);
            } catch (Exception e) {
                ab.e("MicroMsg.ContactsOperations", "query fail, match error %s \n %s", e.getMessage(), bo.l(e));
                query = null;
            }
            if (query == null) {
                ab.e("MicroMsg.ContactsOperations", "get null cursor");
                AppMethodBeat.o(124526);
                return;
            }
            try {
                if (query.moveToFirst()) {
                    do {
                        int columnIndex = query.getColumnIndex("contact_id");
                        String string = columnIndex >= 0 ? query.getString(columnIndex) : "";
                        columnIndex = query.getColumnIndex("_id");
                        String string2 = columnIndex >= 0 ? query.getString(columnIndex) : "";
                        if (!(bo.isNullOrNil(string) || bo.isNullOrNil(string2))) {
                            this.mContext.getContentResolver().delete(Data.CONTENT_URI, "_id = ?", new String[]{string2});
                            this.mContext.getContentResolver().delete(RawContacts.CONTENT_URI, "contact_id = ? AND account_type = ?", new String[]{string, "com.tencent.mm.account"});
                        }
                    } while (query.moveToNext());
                }
            } catch (Exception e2) {
                ab.e("MicroMsg.ContactsOperations", "delete wechat contact failed : " + e2.getMessage());
            }
            query.close();
            AppMethodBeat.o(124526);
        } else {
            ab.e("MicroMsg.ContactsOperations", "no contact permission");
            AppMethodBeat.o(124526);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean vr(String str) {
        Exception e;
        boolean z = false;
        AppMethodBeat.i(124527);
        if (b.o(this.mContext, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                boolean z2;
                query = this.mContext.getContentResolver().query(Data.CONTENT_URI, new String[]{"contact_id"}, "mimetype= ?", new String[]{str}, null);
                if (query != null) {
                    try {
                        if (query.getCount() > 0) {
                            ab.d("MicroMsg.ContactsOperations", "has minetype:".concat(String.valueOf(str)));
                            z2 = true;
                            z = z2;
                            if (query != null) {
                                query.close();
                            }
                            AppMethodBeat.o(124527);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        ab.e("MicroMsg.ContactsOperations", "hasMIMEType search failed : " + e.getMessage());
                        z = true;
                        if (query != null) {
                        }
                        AppMethodBeat.o(124527);
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
            AppMethodBeat.o(124527);
        } else {
            ab.e("MicroMsg.ContactsOperations", "no contact permission");
            AppMethodBeat.o(124527);
        }
        return z;
    }
}
