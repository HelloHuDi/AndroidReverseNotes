package com.tencent.p177mm.plugin.emoji.p947e;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.opensdk.modelmsg.WXDesignerSharedObject;
import com.tencent.p177mm.opensdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.p177mm.opensdk.modelmsg.WXEmojiSharedObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p190at.C17937c;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p230g.p231a.C18372qb;
import com.tencent.p177mm.p230g.p231a.C26217py;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C40437i;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.ByteArrayOutputStream;

/* renamed from: com.tencent.mm.plugin.emoji.e.l */
public final class C45854l {

    /* renamed from: com.tencent.mm.plugin.emoji.e.l$2 */
    public static class C203702 implements C30111a {
        final /* synthetic */ MMActivity cgq;
        final /* synthetic */ String hWg;
        final /* synthetic */ String kUN;
        final /* synthetic */ String kUP;
        final /* synthetic */ String kUQ;
        final /* synthetic */ int kUR;
        final /* synthetic */ String kUS;
        final /* synthetic */ String val$name;

        public C203702(String str, String str2, String str3, int i, String str4, String str5, String str6, MMActivity mMActivity) {
            this.kUP = str;
            this.kUQ = str2;
            this.hWg = str3;
            this.kUR = i;
            this.kUN = str4;
            this.val$name = str5;
            this.kUS = str6;
            this.cgq = mMActivity;
        }

        /* renamed from: a */
        public final void mo6399a(boolean z, String str, int i) {
            AppMethodBeat.m2504i(52983);
            if (z) {
                String str2 = this.kUP;
                String str3 = this.kUQ;
                String str4 = this.hWg;
                int i2 = this.kUR;
                String str5 = this.kUN;
                String str6 = this.val$name;
                String str7 = this.kUS;
                C4990ab.m7410d("MicroMsg.emoji.EmojiSharedMgr", "shareToFriend");
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.title = str3;
                wXMediaMessage.description = str4;
                WXDesignerSharedObject wXDesignerSharedObject = new WXDesignerSharedObject();
                wXDesignerSharedObject.designerUIN = i2;
                wXDesignerSharedObject.thumburl = str7;
                wXDesignerSharedObject.url = str5;
                wXDesignerSharedObject.designerName = str6;
                wXDesignerSharedObject.designerRediretctUrl = str7;
                wXMediaMessage.mediaObject = wXDesignerSharedObject;
                C32291o.ahk();
                Bitmap kR = C17937c.m28186kR(str7);
                if (!(kR == null || kR.isRecycled())) {
                    C4990ab.m7416i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    kR.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                }
                C26217py c26217py = new C26217py();
                c26217py.cMe.cEl = wXMediaMessage;
                c26217py.cMe.toUser = str2;
                c26217py.cMe.cMf = 49;
                c26217py.cMe.cMg = str2;
                c26217py.cMe.cMh = "";
                C4879a.xxA.mo10055m(c26217py);
                if (!TextUtils.isEmpty(str)) {
                    C18372qb c18372qb = new C18372qb();
                    c18372qb.cMq.cMr = str2;
                    c18372qb.cMq.content = str;
                    c18372qb.cMq.type = C1855t.m3925nK(str2);
                    c18372qb.cMq.flags = 0;
                    C4879a.xxA.mo10055m(c18372qb);
                }
                C30379h.m48465bQ(this.cgq, this.cgq.getString(C25738R.string.f9229to));
            }
            AppMethodBeat.m2505o(52983);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.e.l$1 */
    public static class C313501 implements C30111a {
        final /* synthetic */ MMActivity cgq;
        final /* synthetic */ String kUI;
        final /* synthetic */ String kUJ;
        final /* synthetic */ String kUK;
        final /* synthetic */ String kUL;
        final /* synthetic */ String kUM;
        final /* synthetic */ String kUN;
        final /* synthetic */ int kUO;

        public C313501(String str, String str2, String str3, String str4, String str5, String str6, int i, MMActivity mMActivity) {
            this.kUI = str;
            this.kUJ = str2;
            this.kUK = str3;
            this.kUL = str4;
            this.kUM = str5;
            this.kUN = str6;
            this.kUO = i;
            this.cgq = mMActivity;
        }

        /* renamed from: a */
        public final void mo6399a(boolean z, String str, int i) {
            AppMethodBeat.m2504i(52982);
            if (z) {
                String str2 = this.kUI;
                String str3 = this.kUJ;
                String str4 = this.kUK;
                String str5 = this.kUL;
                String str6 = this.kUM;
                String str7 = this.kUN;
                int i2 = this.kUO;
                C4990ab.m7410d("MicroMsg.emoji.EmojiSharedMgr", "doSharedToFriend");
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.title = str4;
                wXMediaMessage.description = str5;
                WXEmojiSharedObject wXEmojiSharedObject = new WXEmojiSharedObject();
                wXEmojiSharedObject.packageflag = i2;
                wXEmojiSharedObject.packageid = str3;
                wXEmojiSharedObject.thumburl = str6;
                wXEmojiSharedObject.url = str7;
                wXMediaMessage.mediaObject = wXEmojiSharedObject;
                C32291o.ahk();
                Bitmap kR = C17937c.m28186kR(str6);
                if (!(kR == null || kR.isRecycled())) {
                    C4990ab.m7416i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    kR.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                }
                C26217py c26217py = new C26217py();
                c26217py.cMe.cEl = wXMediaMessage;
                c26217py.cMe.toUser = str2;
                c26217py.cMe.cMf = 49;
                c26217py.cMe.cMg = str2;
                c26217py.cMe.cMh = "";
                C4879a.xxA.mo10055m(c26217py);
                if (!TextUtils.isEmpty(str)) {
                    C18372qb c18372qb = new C18372qb();
                    c18372qb.cMq.cMr = str2;
                    c18372qb.cMq.content = str;
                    c18372qb.cMq.type = C1855t.m3925nK(str2);
                    c18372qb.cMq.flags = 0;
                    C4879a.xxA.mo10055m(c18372qb);
                }
                C7060h.pYm.mo8381e(10993, Integer.valueOf(0), str3);
                C30379h.m48465bQ(this.cgq, this.cgq.getString(C25738R.string.f9229to));
            }
            AppMethodBeat.m2505o(52982);
        }
    }

    /* renamed from: a */
    public static void m84902a(Context context, String str, String str2, String str3, String str4, String str5, int i) {
        AppMethodBeat.m2504i(52985);
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_title", str);
        intent.putExtra("KContentObjDesc", str2);
        intent.putExtra("Ksnsupload_imgurl", str3);
        intent.putExtra("Ksnsupload_link", str4);
        intent.putExtra("KUploadProduct_UserData", str5);
        intent.putExtra("Ksnsupload_type", i);
        String nW = C37922v.m64078nW("emoje_stroe");
        C37922v.m64076Zp().mo60676y(nW, true).mo53356j("prePublishId", "emoje_stroe");
        intent.putExtra("reportSessionId", nW);
        C25985d.m41472c(context, "sns", ".ui.SnsUploadUI", intent);
        AppMethodBeat.m2505o(52985);
    }

    /* renamed from: dE */
    public static void m84904dE(Context context) {
        AppMethodBeat.m2504i(52986);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, C25738R.anim.f8332b5);
        intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, C25738R.anim.f8373ce);
        C25985d.m41466b(context, ".ui.transmit.SelectConversationUI", intent, 2002);
        AppMethodBeat.m2505o(52986);
    }

    /* renamed from: a */
    public static void m84903a(MMActivity mMActivity, String str, int i, int i2, String str2, String str3, String str4, String str5, int i3, String str6) {
        AppMethodBeat.m2504i(52987);
        final String str7 = str;
        final int i4 = i;
        final int i5 = i2;
        final String str8 = str2;
        final String str9 = str3;
        final String str10 = str4;
        final String str11 = str5;
        final int i6 = i3;
        final String str12 = str6;
        final MMActivity mMActivity2 = mMActivity;
        ((C40437i) C1720g.m3528K(C40437i.class)).mo56648b(mMActivity.mController, str2, str4, str3, "", mMActivity.getString(C25738R.string.f9221tf), new C30111a() {
            /* renamed from: a */
            public final void mo6399a(boolean z, String str, int i) {
                AppMethodBeat.m2504i(52984);
                if (z) {
                    String str2 = str7;
                    int i2 = i4;
                    int i3 = i5;
                    String str3 = str8;
                    String str4 = str9;
                    String str5 = str10;
                    String str6 = str11;
                    int i4 = i6;
                    String str7 = str12;
                    C4990ab.m7410d("MicroMsg.emoji.EmojiSharedMgr", "doSharedToFriend");
                    WXMediaMessage wXMediaMessage = new WXMediaMessage();
                    wXMediaMessage.title = str3;
                    wXMediaMessage.description = str4;
                    WXEmojiPageSharedObject wXEmojiPageSharedObject = new WXEmojiPageSharedObject();
                    wXEmojiPageSharedObject.type = i2;
                    wXEmojiPageSharedObject.tid = i3;
                    wXEmojiPageSharedObject.title = str3;
                    wXEmojiPageSharedObject.desc = str4;
                    wXEmojiPageSharedObject.iconUrl = str5;
                    wXEmojiPageSharedObject.secondUrl = str6;
                    wXEmojiPageSharedObject.pageType = i4;
                    wXEmojiPageSharedObject.url = str7;
                    wXMediaMessage.mediaObject = wXEmojiPageSharedObject;
                    C32291o.ahk();
                    Bitmap kR = C17937c.m28186kR(str5);
                    if (!(kR == null || kR.isRecycled())) {
                        C4990ab.m7416i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        kR.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                        wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                    }
                    C26217py c26217py = new C26217py();
                    c26217py.cMe.cEl = wXMediaMessage;
                    c26217py.cMe.toUser = str2;
                    c26217py.cMe.cMf = 49;
                    c26217py.cMe.cMg = str2;
                    c26217py.cMe.cMh = "";
                    C4879a.xxA.mo10055m(c26217py);
                    if (!TextUtils.isEmpty(str)) {
                        C18372qb c18372qb = new C18372qb();
                        c18372qb.cMq.cMr = str2;
                        c18372qb.cMq.content = str;
                        c18372qb.cMq.type = C1855t.m3925nK(str2);
                        c18372qb.cMq.flags = 0;
                        C4879a.xxA.mo10055m(c18372qb);
                    }
                    C30379h.m48465bQ(mMActivity2, mMActivity2.getString(C25738R.string.f9229to));
                    AppMethodBeat.m2505o(52984);
                    return;
                }
                AppMethodBeat.m2505o(52984);
            }
        });
        AppMethodBeat.m2505o(52987);
    }
}
