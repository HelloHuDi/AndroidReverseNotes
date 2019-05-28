package com.tencent.mm.w.a;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI;
import com.tencent.mm.plugin.fts.ui.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.RegionCodeDecoder;

public final class c extends b {
    public com.tencent.mm.plugin.account.friend.a.a eBs;
    public boolean eBt;
    private a eBu = new a();

    public class a extends b.b {
        public a() {
            super();
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(124494);
            c cVar = (c) aVar;
            Intent intent;
            if (cVar.eBs == null) {
                AppMethodBeat.o(124494);
            } else if (cVar.eBs.status == 1 || cVar.eBs.status == 2) {
                ab.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin On Or Weixin Friend");
                intent = new Intent();
                intent.putExtra("Contact_User", c.this.eBs.getUsername());
                intent.putExtra("Contact_Nick", c.this.eBs.apD());
                intent.putExtra("Contact_Mobile_MD5", c.this.eBs.Aq());
                intent.putExtra("Contact_Alias", c.this.eBs.guS);
                intent.putExtra("Contact_Sex", c.this.eBs.guN);
                intent.putExtra("Contact_Signature", c.this.eBs.guQ);
                intent.putExtra("Contact_RegionCode", RegionCodeDecoder.aC(c.this.eBs.guW, c.this.eBs.guO, c.this.eBs.guP));
                intent.putExtra("Contact_Scene", 13);
                intent.putExtra("Contact_ShowUserName", false);
                if (c.this.eBt) {
                    intent.putExtra("add_more_friend_search_scene", 1);
                }
                com.tencent.mm.plugin.account.a.a.gkE.c(intent, context);
                AppMethodBeat.o(124494);
            } else if (c.this.eBs.status == 0) {
                ab.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin Off");
                intent = new Intent(context, InviteFriendUI.class);
                intent.putExtra("friend_type", 1);
                intent.putExtra("friend_user_name", c.this.eBs.getUsername());
                intent.putExtra("friend_num", c.this.eBs.apG());
                intent.putExtra("friend_nick", c.this.eBs.apA());
                intent.putExtra("friend_weixin_nick", c.this.eBs.apD());
                intent.putExtra("friend_scene", 13);
                context.startActivity(intent);
                AppMethodBeat.o(124494);
            } else {
                ab.d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin status unknown");
                AppMethodBeat.o(124494);
            }
            return true;
        }
    }

    public c(int i) {
        super(i);
        AppMethodBeat.i(124495);
        AppMethodBeat.o(124495);
    }

    /* JADX WARNING: Missing block: B:6:0x007f, code skipped:
            if (r5 == 0) goto L_0x0106;
     */
    /* JADX WARNING: Missing block: B:7:0x0081, code skipped:
            r12.jMY = com.tencent.mm.pluginsdk.ui.e.j.b(r13, r9, com.tencent.mm.bz.a.al(r13, com.tencent.mm.R.dimen.m5));
            r12.jMY = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(r12.jMY, r12.mDz, r3, r0)).mDR;
     */
    /* JADX WARNING: Missing block: B:8:0x009b, code skipped:
            if (r4 == 0) goto L_0x00c5;
     */
    /* JADX WARNING: Missing block: B:9:0x009d, code skipped:
            r12.jMZ = com.tencent.mm.pluginsdk.ui.e.j.b(r13, r6, com.tencent.mm.bz.a.al(r13, com.tencent.mm.R.dimen.m5));
            r12.jMZ = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(r12.jMZ, r12.mDz, r3, r0)).mDR;
            r12.jMZ = android.text.TextUtils.concat(new java.lang.CharSequence[]{r8, r12.jMZ});
     */
    /* JADX WARNING: Missing block: B:10:0x00c5, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(124496);
     */
    /* JADX WARNING: Missing block: B:11:0x00cb, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:13:0x00cd, code skipped:
            r3 = true;
     */
    /* JADX WARNING: Missing block: B:14:0x00ce, code skipped:
            r6 = r12.eBs.apG();
            r4 = 0;
            r5 = 1;
            r8 = r13.getString(com.tencent.mm.R.string.e04);
     */
    /* JADX WARNING: Missing block: B:17:0x00f3, code skipped:
            r3 = true;
     */
    /* JADX WARNING: Missing block: B:18:0x00f4, code skipped:
            r6 = r12.eBs.apD();
            r4 = 1;
            r5 = 0;
            r8 = r13.getString(com.tencent.mm.R.string.e0_);
     */
    /* JADX WARNING: Missing block: B:19:0x0106, code skipped:
            r12.jMY = com.tencent.mm.pluginsdk.ui.e.j.b(r13, r9, com.tencent.mm.bz.a.al(r13, com.tencent.mm.R.dimen.m5));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, Object... objArr) {
        AppMethodBeat.i(124496);
        this.username = this.hpS.mDx;
        this.ehM = ((j) g.K(j.class)).XM().aoO(this.username);
        com.tencent.mm.plugin.account.friend.a.b bVar = (com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg();
        long j = this.hpS.mEB;
        com.tencent.mm.plugin.account.friend.a.a aVar2 = new com.tencent.mm.plugin.account.friend.a.a();
        Cursor a = bVar.fni.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 WHERE id=" + Long.toString(j) + ';', null, 2);
        if (a.moveToFirst()) {
            aVar2.d(a);
        }
        a.close();
        this.eBs = aVar2;
        CharSequence apA = this.eBs.apA();
        boolean z;
        boolean z2;
        CharSequence apG;
        int i;
        int i2;
        switch (this.hpS.mDw) {
            case 5:
                z = false;
                z2 = false;
                break;
            case 6:
                z = false;
                break;
            case 7:
                z = true;
                break;
            case 12:
                z = false;
                z2 = false;
                break;
            case 13:
                z = false;
                break;
            case 14:
                z = true;
                break;
            case 16:
                apG = this.eBs.apG();
                z = false;
                z2 = false;
                i = 1;
                i2 = 0;
                Object string = context.getString(R.string.e04);
                break;
            default:
                z = false;
                z2 = false;
                i = 0;
                i2 = 0;
                apG = null;
                CharSequence string2 = null;
                break;
        }
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b Ps() {
        return this.eBu;
    }
}
