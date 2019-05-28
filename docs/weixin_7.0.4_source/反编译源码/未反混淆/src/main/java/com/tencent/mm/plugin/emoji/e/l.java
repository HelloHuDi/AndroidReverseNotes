package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.c;
import com.tencent.mm.at.o;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.py;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.opensdk.modelmsg.WXDesignerSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiPageSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXEmojiSharedObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;

public final class l {

    /* renamed from: com.tencent.mm.plugin.emoji.e.l$2 */
    public static class AnonymousClass2 implements a {
        final /* synthetic */ MMActivity cgq;
        final /* synthetic */ String hWg;
        final /* synthetic */ String kUN;
        final /* synthetic */ String kUP;
        final /* synthetic */ String kUQ;
        final /* synthetic */ int kUR;
        final /* synthetic */ String kUS;
        final /* synthetic */ String val$name;

        public AnonymousClass2(String str, String str2, String str3, int i, String str4, String str5, String str6, MMActivity mMActivity) {
            this.kUP = str;
            this.kUQ = str2;
            this.hWg = str3;
            this.kUR = i;
            this.kUN = str4;
            this.val$name = str5;
            this.kUS = str6;
            this.cgq = mMActivity;
        }

        public final void a(boolean z, String str, int i) {
            AppMethodBeat.i(52983);
            if (z) {
                String str2 = this.kUP;
                String str3 = this.kUQ;
                String str4 = this.hWg;
                int i2 = this.kUR;
                String str5 = this.kUN;
                String str6 = this.val$name;
                String str7 = this.kUS;
                ab.d("MicroMsg.emoji.EmojiSharedMgr", "shareToFriend");
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
                o.ahk();
                Bitmap kR = c.kR(str7);
                if (!(kR == null || kR.isRecycled())) {
                    ab.i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    kR.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                }
                py pyVar = new py();
                pyVar.cMe.cEl = wXMediaMessage;
                pyVar.cMe.toUser = str2;
                pyVar.cMe.cMf = 49;
                pyVar.cMe.cMg = str2;
                pyVar.cMe.cMh = "";
                com.tencent.mm.sdk.b.a.xxA.m(pyVar);
                if (!TextUtils.isEmpty(str)) {
                    qb qbVar = new qb();
                    qbVar.cMq.cMr = str2;
                    qbVar.cMq.content = str;
                    qbVar.cMq.type = t.nK(str2);
                    qbVar.cMq.flags = 0;
                    com.tencent.mm.sdk.b.a.xxA.m(qbVar);
                }
                h.bQ(this.cgq, this.cgq.getString(R.string.to));
            }
            AppMethodBeat.o(52983);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.e.l$1 */
    public static class AnonymousClass1 implements a {
        final /* synthetic */ MMActivity cgq;
        final /* synthetic */ String kUI;
        final /* synthetic */ String kUJ;
        final /* synthetic */ String kUK;
        final /* synthetic */ String kUL;
        final /* synthetic */ String kUM;
        final /* synthetic */ String kUN;
        final /* synthetic */ int kUO;

        public AnonymousClass1(String str, String str2, String str3, String str4, String str5, String str6, int i, MMActivity mMActivity) {
            this.kUI = str;
            this.kUJ = str2;
            this.kUK = str3;
            this.kUL = str4;
            this.kUM = str5;
            this.kUN = str6;
            this.kUO = i;
            this.cgq = mMActivity;
        }

        public final void a(boolean z, String str, int i) {
            AppMethodBeat.i(52982);
            if (z) {
                String str2 = this.kUI;
                String str3 = this.kUJ;
                String str4 = this.kUK;
                String str5 = this.kUL;
                String str6 = this.kUM;
                String str7 = this.kUN;
                int i2 = this.kUO;
                ab.d("MicroMsg.emoji.EmojiSharedMgr", "doSharedToFriend");
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.title = str4;
                wXMediaMessage.description = str5;
                WXEmojiSharedObject wXEmojiSharedObject = new WXEmojiSharedObject();
                wXEmojiSharedObject.packageflag = i2;
                wXEmojiSharedObject.packageid = str3;
                wXEmojiSharedObject.thumburl = str6;
                wXEmojiSharedObject.url = str7;
                wXMediaMessage.mediaObject = wXEmojiSharedObject;
                o.ahk();
                Bitmap kR = c.kR(str6);
                if (!(kR == null || kR.isRecycled())) {
                    ab.i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    kR.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                }
                py pyVar = new py();
                pyVar.cMe.cEl = wXMediaMessage;
                pyVar.cMe.toUser = str2;
                pyVar.cMe.cMf = 49;
                pyVar.cMe.cMg = str2;
                pyVar.cMe.cMh = "";
                com.tencent.mm.sdk.b.a.xxA.m(pyVar);
                if (!TextUtils.isEmpty(str)) {
                    qb qbVar = new qb();
                    qbVar.cMq.cMr = str2;
                    qbVar.cMq.content = str;
                    qbVar.cMq.type = t.nK(str2);
                    qbVar.cMq.flags = 0;
                    com.tencent.mm.sdk.b.a.xxA.m(qbVar);
                }
                com.tencent.mm.plugin.report.service.h.pYm.e(10993, Integer.valueOf(0), str3);
                h.bQ(this.cgq, this.cgq.getString(R.string.to));
            }
            AppMethodBeat.o(52982);
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, int i) {
        AppMethodBeat.i(52985);
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_title", str);
        intent.putExtra("KContentObjDesc", str2);
        intent.putExtra("Ksnsupload_imgurl", str3);
        intent.putExtra("Ksnsupload_link", str4);
        intent.putExtra("KUploadProduct_UserData", str5);
        intent.putExtra("Ksnsupload_type", i);
        String nW = v.nW("emoje_stroe");
        v.Zp().y(nW, true).j("prePublishId", "emoje_stroe");
        intent.putExtra("reportSessionId", nW);
        d.c(context, "sns", ".ui.SnsUploadUI", intent);
        AppMethodBeat.o(52985);
    }

    public static void dE(Context context) {
        AppMethodBeat.i(52986);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, R.anim.b5);
        intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, R.anim.ce);
        d.b(context, ".ui.transmit.SelectConversationUI", intent, 2002);
        AppMethodBeat.o(52986);
    }

    public static void a(MMActivity mMActivity, String str, int i, int i2, String str2, String str3, String str4, String str5, int i3, String str6) {
        AppMethodBeat.i(52987);
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
        ((i) g.K(i.class)).b(mMActivity.mController, str2, str4, str3, "", mMActivity.getString(R.string.tf), new a() {
            public final void a(boolean z, String str, int i) {
                AppMethodBeat.i(52984);
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
                    ab.d("MicroMsg.emoji.EmojiSharedMgr", "doSharedToFriend");
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
                    o.ahk();
                    Bitmap kR = c.kR(str5);
                    if (!(kR == null || kR.isRecycled())) {
                        ab.i("MicroMsg.emoji.EmojiSharedMgr", "thumb image is not null");
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        kR.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                        wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                    }
                    py pyVar = new py();
                    pyVar.cMe.cEl = wXMediaMessage;
                    pyVar.cMe.toUser = str2;
                    pyVar.cMe.cMf = 49;
                    pyVar.cMe.cMg = str2;
                    pyVar.cMe.cMh = "";
                    com.tencent.mm.sdk.b.a.xxA.m(pyVar);
                    if (!TextUtils.isEmpty(str)) {
                        qb qbVar = new qb();
                        qbVar.cMq.cMr = str2;
                        qbVar.cMq.content = str;
                        qbVar.cMq.type = t.nK(str2);
                        qbVar.cMq.flags = 0;
                        com.tencent.mm.sdk.b.a.xxA.m(qbVar);
                    }
                    h.bQ(mMActivity2, mMActivity2.getString(R.string.to));
                    AppMethodBeat.o(52984);
                    return;
                }
                AppMethodBeat.o(52984);
            }
        });
        AppMethodBeat.o(52987);
    }
}
