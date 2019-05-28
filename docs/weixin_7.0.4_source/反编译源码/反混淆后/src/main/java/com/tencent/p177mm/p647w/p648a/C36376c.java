package com.tencent.p177mm.p647w.p648a;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18818b;
import com.tencent.p177mm.plugin.account.friend.p273ui.InviteFriendUI;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3155a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a.C3156b;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C20869b;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C20869b.C20870b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.RegionCodeDecoder;

/* renamed from: com.tencent.mm.w.a.c */
public final class C36376c extends C20869b {
    public C18817a eBs;
    public boolean eBt;
    private C30849a eBu = new C30849a();

    /* renamed from: com.tencent.mm.w.a.c$a */
    public class C30849a extends C20870b {
        public C30849a() {
            super();
        }

        /* renamed from: a */
        public final boolean mo7422a(Context context, C3154a c3154a) {
            AppMethodBeat.m2504i(124494);
            C36376c c36376c = (C36376c) c3154a;
            Intent intent;
            if (c36376c.eBs == null) {
                AppMethodBeat.m2505o(124494);
            } else if (c36376c.eBs.status == 1 || c36376c.eBs.status == 2) {
                C4990ab.m7410d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin On Or Weixin Friend");
                intent = new Intent();
                intent.putExtra("Contact_User", C36376c.this.eBs.getUsername());
                intent.putExtra("Contact_Nick", C36376c.this.eBs.apD());
                intent.putExtra("Contact_Mobile_MD5", C36376c.this.eBs.mo34067Aq());
                intent.putExtra("Contact_Alias", C36376c.this.eBs.guS);
                intent.putExtra("Contact_Sex", C36376c.this.eBs.guN);
                intent.putExtra("Contact_Signature", C36376c.this.eBs.guQ);
                intent.putExtra("Contact_RegionCode", RegionCodeDecoder.m7796aC(C36376c.this.eBs.guW, C36376c.this.eBs.guO, C36376c.this.eBs.guP));
                intent.putExtra("Contact_Scene", 13);
                intent.putExtra("Contact_ShowUserName", false);
                if (C36376c.this.eBt) {
                    intent.putExtra("add_more_friend_search_scene", 1);
                }
                C24679a.gkE.mo38912c(intent, context);
                AppMethodBeat.m2505o(124494);
            } else if (C36376c.this.eBs.status == 0) {
                C4990ab.m7410d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin Off");
                intent = new Intent(context, InviteFriendUI.class);
                intent.putExtra("friend_type", 1);
                intent.putExtra("friend_user_name", C36376c.this.eBs.getUsername());
                intent.putExtra("friend_num", C36376c.this.eBs.apG());
                intent.putExtra("friend_nick", C36376c.this.eBs.apA());
                intent.putExtra("friend_weixin_nick", C36376c.this.eBs.apD());
                intent.putExtra("friend_scene", 13);
                context.startActivity(intent);
                AppMethodBeat.m2505o(124494);
            } else {
                C4990ab.m7410d("MicroMsg.FTS.FTSMobileContactDataItem", "Click Mobile Contact Weixin status unknown");
                AppMethodBeat.m2505o(124494);
            }
            return true;
        }
    }

    public C36376c(int i) {
        super(i);
        AppMethodBeat.m2504i(124495);
        AppMethodBeat.m2505o(124495);
    }

    /* JADX WARNING: Missing block: B:6:0x007f, code skipped:
            if (r5 == 0) goto L_0x0106;
     */
    /* JADX WARNING: Missing block: B:7:0x0081, code skipped:
            r12.jMY = com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j.m79294b(r13, r9, com.tencent.p177mm.p208bz.C1338a.m2856al(r13, com.tencent.p177mm.C25738R.dimen.f9980m5));
            r12.jMY = com.tencent.p177mm.plugin.fts.p419a.C34204f.m56086a(com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d.m66568a(r12.jMY, r12.mDz, r3, r0)).mDR;
     */
    /* JADX WARNING: Missing block: B:8:0x009b, code skipped:
            if (r4 == 0) goto L_0x00c5;
     */
    /* JADX WARNING: Missing block: B:9:0x009d, code skipped:
            r12.jMZ = com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j.m79294b(r13, r6, com.tencent.p177mm.p208bz.C1338a.m2856al(r13, com.tencent.p177mm.C25738R.dimen.f9980m5));
            r12.jMZ = com.tencent.p177mm.plugin.fts.p419a.C34204f.m56086a(com.tencent.p177mm.plugin.fts.p419a.p420a.C39127d.m66568a(r12.jMZ, r12.mDz, r3, r0)).mDR;
            r12.jMZ = android.text.TextUtils.concat(new java.lang.CharSequence[]{r8, r12.jMZ});
     */
    /* JADX WARNING: Missing block: B:10:0x00c5, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(124496);
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
            r8 = r13.getString(com.tencent.p177mm.C25738R.string.e04);
     */
    /* JADX WARNING: Missing block: B:17:0x00f3, code skipped:
            r3 = true;
     */
    /* JADX WARNING: Missing block: B:18:0x00f4, code skipped:
            r6 = r12.eBs.apD();
            r4 = 1;
            r5 = 0;
            r8 = r13.getString(com.tencent.p177mm.C25738R.string.e0_);
     */
    /* JADX WARNING: Missing block: B:19:0x0106, code skipped:
            r12.jMY = com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j.m79294b(r13, r9, com.tencent.p177mm.p208bz.C1338a.m2856al(r13, com.tencent.p177mm.C25738R.dimen.f9980m5));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo7413a(Context context, C3155a c3155a, Object... objArr) {
        AppMethodBeat.m2504i(124496);
        this.username = this.hpS.mDx;
        this.ehM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(this.username);
        C18818b c18818b = (C18818b) ((C7599a) C1720g.m3530M(C7599a.class)).getAddrUploadStg();
        long j = this.hpS.mEB;
        C18817a c18817a = new C18817a();
        Cursor a = c18818b.fni.mo10104a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 WHERE id=" + Long.toString(j) + ';', null, 2);
        if (a.moveToFirst()) {
            c18817a.mo34080d(a);
        }
        a.close();
        this.eBs = c18817a;
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
                Object string = context.getString(C25738R.string.e04);
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

    /* renamed from: Ps */
    public final C3156b mo7412Ps() {
        return this.eBu;
    }
}
