package com.tencent.p177mm.p207by;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.p227a.C32497a;
import com.tencent.p177mm.jniinterface.AesEcb;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p827a.C17926b.C17925a;
import com.tencent.p177mm.p249m.C1767e;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.emojicapture.api.EmojiCaptureUploadManager.UploadTask;
import com.tencent.p177mm.pluginsdk.p1336a.C44039e;
import com.tencent.p177mm.protocal.protobuf.cab;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.emotion.C15438t;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.storage.emotion.SmileyInfo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.view.p1628d.C44419a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.by.a */
public final class C45274a implements C44039e {
    public static C1335a xul = new C1335a();
    public static C1336b xum = new C1336b();
    public static C18119c xun = new C18119c();
    private C25815a luu;
    private String xug;
    private ArrayList<EmojiInfo> xuh = new ArrayList();
    private ArrayList<EmojiInfo> xui = new ArrayList();
    private HashMap<String, ArrayList<EmojiInfo>> xuj = new HashMap();
    private ArrayList<EmojiGroupInfo> xuk = new ArrayList();

    /* renamed from: com.tencent.mm.by.a$a */
    public static class C1335a {
    }

    /* renamed from: com.tencent.mm.by.a$b */
    public static class C1336b {
        /* renamed from: LR */
        public static boolean m2854LR(int i) {
            AppMethodBeat.m2504i(62590);
            Bundle bundle = new Bundle();
            bundle.putInt("key", i);
            boolean z = C45274a.call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/userinfo/"), "ConfigStorage.getBoolean", null, bundle).getBoolean("key", false);
            AppMethodBeat.m2505o(62590);
            return z;
        }

        /* renamed from: bJ */
        public static String m2855bJ(int i, String str) {
            AppMethodBeat.m2504i(62591);
            Bundle bundle = new Bundle();
            bundle.putInt("key", i);
            String string = C45274a.call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/userinfo/"), "ConfigStorage.getString", null, bundle).getString("key", str);
            AppMethodBeat.m2505o(62591);
            return string;
        }

        public static void alW(String str) {
            AppMethodBeat.m2504i(62592);
            ContentValues contentValues = new ContentValues();
            contentValues.put("type", Integer.valueOf(-29414086));
            contentValues.put("value", str);
            C45274a.m83448a(Uri.parse("content://com.tencent.mm.storage.provider.emotion/userinfo/"), contentValues);
            AppMethodBeat.m2505o(62592);
        }
    }

    /* renamed from: com.tencent.mm.by.a$c */
    public static class C18119c extends C1767e {
        /* renamed from: sg */
        public final synchronized void mo5312sg() {
            AppMethodBeat.m2504i(62593);
            this.ewc = true;
            C45274a.dmE();
            C1336b c1336b = C45274a.xum;
            mo5310p(C1336b.m2855bJ(278529, null), false);
            C45274a.dmE();
            c1336b = C45274a.xum;
            mo5310p(C1336b.m2855bJ(278530, null), false);
            AppMethodBeat.m2505o(62593);
        }
    }

    public C45274a() {
        AppMethodBeat.m2504i(62594);
        AppMethodBeat.m2505o(62594);
    }

    /* renamed from: Jh */
    public final String mo35600Jh(String str) {
        AppMethodBeat.m2504i(62595);
        String Jh;
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            Jh = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35600Jh(str);
            AppMethodBeat.m2505o(62595);
            return Jh;
        }
        Jh = C45274a.call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getCurLangDesc", str, null).getString("data", "");
        AppMethodBeat.m2505o(62595);
        return Jh;
    }

    /* renamed from: j */
    public final EmojiInfo mo35651j(String str, int i, int i2, int i3) {
        AppMethodBeat.m2504i(62596);
        EmojiInfo a;
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            a = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35615a(str, "", i, i2, i3, "");
            AppMethodBeat.m2505o(62596);
            return a;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_md5", str);
        bundle.putInt("key_group", i);
        bundle.putInt("key_type", i2);
        bundle.putInt("key_size", i3);
        bundle = C45274a.call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "createEmojiInfo", null, bundle);
        if (bundle != null) {
            bundle.setClassLoader(EmojiInfo.class.getClassLoader());
            a = (EmojiInfo) bundle.getParcelable("key_emoji_info");
            AppMethodBeat.m2505o(62596);
            return a;
        }
        AppMethodBeat.m2505o(62596);
        return null;
    }

    public final void updateEmojiInfo(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(62597);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().updateEmojiInfo(emojiInfo);
            AppMethodBeat.m2505o(62597);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.setClassLoader(EmojiInfo.class.getClassLoader());
        bundle.putParcelable("key_emoji_info", emojiInfo);
        C45274a.call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "updateEmojiInfo", null, bundle);
        AppMethodBeat.m2505o(62597);
    }

    public final cab bjU() {
        AppMethodBeat.m2504i(62598);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            cab bjU = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().bjU();
            AppMethodBeat.m2505o(62598);
            return bjU;
        }
        AppMethodBeat.m2505o(62598);
        return null;
    }

    /* renamed from: a */
    public final void mo35619a(cab cab) {
        AppMethodBeat.m2504i(62599);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35619a(cab);
        }
        AppMethodBeat.m2505o(62599);
    }

    /* renamed from: y */
    public final int mo35667y(boolean z, boolean z2) {
        AppMethodBeat.m2504i(62600);
        int y;
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            y = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35667y(z, z2);
            AppMethodBeat.m2505o(62600);
            return y;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("withSystem", z);
        bundle.putBoolean("onlySuccess", z2);
        y = C45274a.call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "countCustomEmoji", null, bundle).getInt("data", 0);
        AppMethodBeat.m2505o(62600);
        return y;
    }

    /* renamed from: Jp */
    public final int mo35608Jp(String str) {
        AppMethodBeat.m2504i(62601);
        int Jp;
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            Jp = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35608Jp(str);
            AppMethodBeat.m2505o(62601);
            return Jp;
        }
        Jp = C45274a.call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "countProductId", str, null).getInt("data", 0);
        AppMethodBeat.m2505o(62601);
        return Jp;
    }

    public final int bjV() {
        AppMethodBeat.m2504i(62602);
        int bjV;
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            bjV = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().bjV();
            AppMethodBeat.m2505o(62602);
            return bjV;
        }
        bjV = C45274a.call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getDownloadedCount", null, null).getInt("data", 0);
        AppMethodBeat.m2505o(62602);
        return bjV;
    }

    /* renamed from: a */
    public final boolean mo35622a(EmojiGroupInfo emojiGroupInfo) {
        AppMethodBeat.m2504i(62603);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            boolean a = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35622a(emojiGroupInfo);
            AppMethodBeat.m2505o(62603);
            return a;
        }
        AppMethodBeat.m2505o(62603);
        return false;
    }

    /* renamed from: OD */
    public final ArrayList<EmojiGroupInfo> mo35612OD() {
        AppMethodBeat.m2504i(62604);
        ArrayList OD = C32497a.m53203OB().mo53135OD();
        AppMethodBeat.m2505o(62604);
        return OD;
    }

    /* renamed from: bY */
    public final ArrayList<EmojiInfo> mo35625bY(boolean z) {
        AppMethodBeat.m2504i(62605);
        ArrayList bY = C32497a.m53203OB().mo53136bY(z);
        AppMethodBeat.m2505o(62605);
        return bY;
    }

    /* renamed from: OC */
    public final ArrayList<EmojiInfo> mo35611OC() {
        AppMethodBeat.m2504i(62606);
        ArrayList OC = C32497a.m53203OB().mo53134OC();
        AppMethodBeat.m2505o(62606);
        return OC;
    }

    /* renamed from: kS */
    public final ArrayList<EmojiInfo> mo35654kS(String str) {
        AppMethodBeat.m2504i(62607);
        ArrayList kS = C32497a.m53203OB().mo53142kS(str);
        AppMethodBeat.m2505o(62607);
        return kS;
    }

    public final C25815a bjW() {
        AppMethodBeat.m2504i(62608);
        C25815a bjW;
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            bjW = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().bjW();
            AppMethodBeat.m2505o(62608);
            return bjW;
        }
        if (this.luu == null) {
            C17925a c17925a = new C17925a(C4996ah.getContext());
            c17925a.fGT = new C44419a();
            this.luu = new C25815a(c17925a.ahx());
        }
        bjW = this.luu;
        AppMethodBeat.m2505o(62608);
        return bjW;
    }

    /* renamed from: g */
    public final void mo35647g(C4931a c4931a) {
        AppMethodBeat.m2504i(62609);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35647g(c4931a);
        }
        AppMethodBeat.m2505o(62609);
    }

    /* renamed from: l */
    public final byte[] mo35656l(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(62610);
        byte[] l;
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            l = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35656l(emojiInfo);
            AppMethodBeat.m2505o(62610);
            return l;
        }
        l = C45274a.m83447C(emojiInfo);
        AppMethodBeat.m2505o(62610);
        return l;
    }

    /* renamed from: h */
    public final void mo35649h(C4931a c4931a) {
        AppMethodBeat.m2504i(62611);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35649h(c4931a);
        }
        AppMethodBeat.m2505o(62611);
    }

    /* renamed from: i */
    public final void mo35650i(C4931a c4931a) {
        AppMethodBeat.m2504i(62612);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35650i(c4931a);
        }
        AppMethodBeat.m2505o(62612);
    }

    /* renamed from: j */
    public final void mo35652j(C4931a c4931a) {
        AppMethodBeat.m2504i(62613);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35652j(c4931a);
        }
        AppMethodBeat.m2505o(62613);
    }

    /* renamed from: Je */
    public final EmojiInfo mo35597Je(String str) {
        AppMethodBeat.m2504i(62614);
        EmojiInfo Je;
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            Je = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35597Je(str);
            AppMethodBeat.m2505o(62614);
            return Je;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_md5", str);
        bundle = C45274a.call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getEmojiByMd5", null, bundle);
        if (bundle != null) {
            bundle.setClassLoader(EmojiInfo.class.getClassLoader());
            Je = (EmojiInfo) bundle.getParcelable("key_emoji_info");
            AppMethodBeat.m2505o(62614);
            return Je;
        }
        AppMethodBeat.m2505o(62614);
        return null;
    }

    /* renamed from: n */
    public final EmojiInfo mo35657n(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(62615);
        EmojiInfo n;
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            n = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35657n(emojiInfo);
            AppMethodBeat.m2505o(62615);
            return n;
        }
        Bundle bundle = new Bundle(EmojiInfo.class.getClassLoader());
        bundle.putParcelable("emoji", emojiInfo);
        bundle = C4996ah.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getRandomEmoji", null, bundle);
        if (bundle == null) {
            C4990ab.m7412e("MicroMsg.EmotionStorageResolver", "[getRandomEmoji] bunndle is null! ");
            AppMethodBeat.m2505o(62615);
            return null;
        }
        bundle.setClassLoader(EmojiInfo.class.getClassLoader());
        if (bundle.containsKey("data")) {
            n = (EmojiInfo) bundle.getParcelable("data");
            AppMethodBeat.m2505o(62615);
            return n;
        }
        boolean z;
        String str = "MicroMsg.EmotionStorageResolver";
        String str2 = "[getRandomEmoji] bundle is null?";
        Object[] objArr = new Object[1];
        if (bundle == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7413e(str, str2, objArr);
        AppMethodBeat.m2505o(62615);
        return null;
    }

    /* renamed from: C */
    private static byte[] m83447C(EmojiInfo emojiInfo) {
        byte[] bArr = null;
        AppMethodBeat.m2504i(138408);
        if (emojiInfo == null) {
            C4990ab.m7420w("MicroMsg.EmotionStorageResolver", "[decodeEmojiDataExport] failed. emoji is null.");
            AppMethodBeat.m2505o(138408);
            return bArr;
        }
        String dve = emojiInfo.dve();
        byte[] e = C5730e.m8632e(dve, 0, -1);
        if (C5730e.asZ(dve) <= 0 || e == null || e.length < 10) {
            C4990ab.m7417i("MicroMsg.EmotionStorageResolver", "decode emoji file failed. path is no exist :%s ", dve);
            AppMethodBeat.m2505o(138408);
            return bArr;
        }
        byte[] bArr2 = new byte[10];
        System.arraycopy(e, 0, bArr2, 0, 10);
        if ((emojiInfo.field_reserved4 & EmojiInfo.zZi) != EmojiInfo.zZi || C5063r.m7678bT(bArr2)) {
            AppMethodBeat.m2505o(138408);
            return e;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int asZ = (int) C5730e.asZ(dve);
        if (asZ > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            asZ = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        }
        byte[] e2 = C5730e.m8632e(dve, 0, asZ);
        if (!C5046bo.isNullOrNil(C45274a.bjL())) {
            try {
                bArr = AesEcb.aesCryptEcb(e2, C45274a.bjL().getBytes(), false, false);
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.EmotionStorageResolver", th, "", new Object[0]);
            }
        }
        if (C5046bo.m7540cb(bArr) || C5046bo.m7540cb(e)) {
            C4990ab.m7417i("MicroMsg.EmotionStorageResolver", "decode emoji file failed. path:%s return original ", dve);
            AppMethodBeat.m2505o(138408);
            return e;
        }
        System.arraycopy(bArr, 0, e, 0, asZ);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        C4990ab.m7411d("MicroMsg.EmotionStorageResolver", "decode emoji file length:%d use time:%d", Integer.valueOf(e.length), Long.valueOf(currentTimeMillis2));
        AppMethodBeat.m2505o(138408);
        return e;
    }

    public final String getAccPath() {
        AppMethodBeat.m2504i(62617);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            this.xug = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().getAccPath();
        } else if (C5046bo.isNullOrNil(this.xug)) {
            this.xug = C45274a.call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getAccPath", null, null).getString("path");
        }
        String str = this.xug;
        AppMethodBeat.m2505o(62617);
        return str;
    }

    public static Uri getUri() {
        AppMethodBeat.m2504i(139077);
        Uri parse = Uri.parse("content://com.tencent.mm.storage.provider.emotion/");
        AppMethodBeat.m2505o(139077);
        return parse;
    }

    static {
        AppMethodBeat.m2504i(62641);
        AppMethodBeat.m2505o(62641);
    }

    public static C1335a dmE() {
        return xul;
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(62619);
        this.xuk.clear();
        AppMethodBeat.m2505o(62619);
    }

    public final boolean bjX() {
        AppMethodBeat.m2504i(62620);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            boolean bjX = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().bjX();
            AppMethodBeat.m2505o(62620);
            return bjX;
        }
        Bundle call = C45274a.call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "isEnableHEVCDecode", null, null);
        if (call == null || !call.getBoolean("key_data")) {
            AppMethodBeat.m2505o(62620);
            return false;
        }
        AppMethodBeat.m2505o(62620);
        return true;
    }

    /* renamed from: OS */
    public final boolean mo35613OS() {
        AppMethodBeat.m2504i(62621);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            boolean OS = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35613OS();
            AppMethodBeat.m2505o(62621);
            return OS;
        }
        Bundle call = C45274a.call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "isEnableHevcUpload", null, null);
        if (call == null || !call.getBoolean("key_data")) {
            AppMethodBeat.m2505o(62621);
            return false;
        }
        AppMethodBeat.m2505o(62621);
        return true;
    }

    /* renamed from: OT */
    public final boolean mo35614OT() {
        AppMethodBeat.m2504i(62622);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            boolean OT = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35614OT();
            AppMethodBeat.m2505o(62622);
            return OT;
        }
        AppMethodBeat.m2505o(62622);
        return false;
    }

    /* renamed from: bZ */
    public final void mo35626bZ(String str, int i) {
        AppMethodBeat.m2504i(62623);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35626bZ(str, i);
        }
        AppMethodBeat.m2505o(62623);
    }

    public final List<C15438t> bjY() {
        AppMethodBeat.m2504i(62624);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            List bjY = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().bjY();
            AppMethodBeat.m2505o(62624);
            return bjY;
        }
        AppMethodBeat.m2505o(62624);
        return null;
    }

    public final void bjZ() {
        AppMethodBeat.m2504i(62625);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().bjZ();
        }
        AppMethodBeat.m2505o(62625);
    }

    /* renamed from: c */
    public final <T> T mo35641c(C5127a c5127a, T t) {
        AppMethodBeat.m2504i(62626);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            Object c = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35641c(c5127a, t);
            AppMethodBeat.m2505o(62626);
            return c;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_config_key", c5127a);
        bundle = C45274a.call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getConfig", null, bundle);
        if (bundle != null) {
            T t2 = bundle.get("key_config_value");
            if (t2 != null) {
                AppMethodBeat.m2505o(62626);
                return t2;
            }
        }
        AppMethodBeat.m2505o(62626);
        return t;
    }

    /* renamed from: d */
    public final void mo35644d(C5127a c5127a, Object obj) {
        AppMethodBeat.m2504i(62627);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35644d(c5127a, obj);
            AppMethodBeat.m2505o(62627);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_config_key", c5127a);
        bundle.putSerializable("key_config_value", (Serializable) obj);
        C45274a.call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "setConfig", null, bundle);
        AppMethodBeat.m2505o(62627);
    }

    /* renamed from: k */
    public final void mo35653k(C4931a c4931a) {
        AppMethodBeat.m2504i(62628);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35655l(c4931a);
        }
        AppMethodBeat.m2505o(62628);
    }

    /* renamed from: Jq */
    public final boolean mo35609Jq(String str) {
        AppMethodBeat.m2504i(62629);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            boolean Jq = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35609Jq(str);
            AppMethodBeat.m2505o(62629);
            return Jq;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_path", str);
        bundle = C45274a.call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "checkGifFile", null, bundle);
        if (bundle == null || !bundle.getBoolean("key_data")) {
            AppMethodBeat.m2505o(62629);
            return false;
        }
        AppMethodBeat.m2505o(62629);
        return true;
    }

    public final boolean bka() {
        AppMethodBeat.m2504i(62630);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            boolean bka = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().bka();
            AppMethodBeat.m2505o(62630);
            return bka;
        }
        AppMethodBeat.m2505o(62630);
        return false;
    }

    public final ArrayList<SmileyInfo> bjO() {
        AppMethodBeat.m2504i(62631);
        if (!((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            Bundle call = C45274a.call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getSmileyInfoList", null, null);
            if (call != null) {
                call.setClassLoader(SmileyInfo.class.getClassLoader());
                Serializable serializable = call.getSerializable("key_data");
                if (serializable instanceof ArrayList) {
                    ArrayList<SmileyInfo> arrayList = (ArrayList) serializable;
                    AppMethodBeat.m2505o(62631);
                    return arrayList;
                }
            }
        } else if (C1720g.m3534RN().mo5161QY()) {
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().bjO();
        }
        AppMethodBeat.m2505o(62631);
        return null;
    }

    public final void bjT() {
        AppMethodBeat.m2504i(62632);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG() && C1720g.m3534RN().mo5161QY()) {
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().bjT();
        }
        AppMethodBeat.m2505o(62632);
    }

    /* renamed from: l */
    public final void mo35655l(C4931a c4931a) {
        AppMethodBeat.m2504i(62633);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35653k(c4931a);
        }
        AppMethodBeat.m2505o(62633);
    }

    public static Bundle call(Uri uri, String str, String str2, Bundle bundle) {
        Bundle call;
        AppMethodBeat.m2504i(62634);
        try {
            call = C4996ah.getContext().getContentResolver().call(uri, str, str2, bundle);
        } catch (IllegalArgumentException | NullPointerException e) {
            C4990ab.printErrStackTrace("MicroMsg.EmotionStorageResolver", e, "", new Object[0]);
            call = null;
        }
        if (call != null) {
            AppMethodBeat.m2505o(62634);
            return call;
        }
        call = new Bundle();
        AppMethodBeat.m2505o(62634);
        return call;
    }

    /* renamed from: Jr */
    public final void mo35610Jr(String str) {
        AppMethodBeat.m2504i(62635);
        if (!((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            C4996ah.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "deleteLoadingCaptureEmoji", str, null);
        } else if (C1720g.m3534RN().mo5161QY()) {
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35610Jr(str);
            AppMethodBeat.m2505o(62635);
            return;
        }
        AppMethodBeat.m2505o(62635);
    }

    /* renamed from: a */
    public final void mo35618a(UploadTask uploadTask) {
        AppMethodBeat.m2504i(62636);
        if (!((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            Bundle bundle = new Bundle();
            bundle.putString("emojiMd5", uploadTask.lgZ);
            bundle.putParcelable("reporter", uploadTask.lha);
            C4996ah.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "uploadEmojiRemote", null, bundle);
        } else if (C1720g.m3534RN().mo5161QY()) {
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35618a(uploadTask);
            AppMethodBeat.m2505o(62636);
            return;
        }
        AppMethodBeat.m2505o(62636);
    }

    /* renamed from: q */
    public final void mo35661q(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(62637);
        if (!((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("emojiInfo", emojiInfo);
            C4996ah.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "showCaptureEmojiInPanel", null, bundle);
        } else if (C1720g.m3534RN().mo5161QY()) {
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35661q(emojiInfo);
            AppMethodBeat.m2505o(62637);
            return;
        }
        AppMethodBeat.m2505o(62637);
    }

    /* renamed from: r */
    public final void mo35662r(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(62638);
        if (!((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("emojiInfo", emojiInfo);
            C4996ah.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "showCaptureEmojiDefaultErrorDialog", null, bundle);
        } else if (C1720g.m3534RN().mo5161QY()) {
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35662r(emojiInfo);
            AppMethodBeat.m2505o(62638);
            return;
        }
        AppMethodBeat.m2505o(62638);
    }

    /* renamed from: b */
    public final void mo35624b(UploadTask uploadTask) {
        AppMethodBeat.m2504i(62639);
        if (!((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("uploadTask", uploadTask);
            C4996ah.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "addCaptureEmojiUploadTask", null, bundle);
        } else if (C1720g.m3534RN().mo5161QY()) {
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35624b(uploadTask);
            AppMethodBeat.m2505o(62639);
            return;
        }
        AppMethodBeat.m2505o(62639);
    }

    private static String bjL() {
        AppMethodBeat.m2504i(62616);
        String string = C45274a.call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getEmojiKey", null, null).getString("key", "");
        AppMethodBeat.m2505o(62616);
        return string;
    }

    /* renamed from: a */
    static /* synthetic */ void m83448a(Uri uri, ContentValues contentValues) {
        AppMethodBeat.m2504i(62640);
        try {
            C4996ah.getContext().getContentResolver().update(uri, contentValues, null, null);
            AppMethodBeat.m2505o(62640);
        } catch (IllegalArgumentException e) {
            C4990ab.printErrStackTrace("MicroMsg.EmotionStorageResolver", e, "", new Object[0]);
            AppMethodBeat.m2505o(62640);
        }
    }
}
