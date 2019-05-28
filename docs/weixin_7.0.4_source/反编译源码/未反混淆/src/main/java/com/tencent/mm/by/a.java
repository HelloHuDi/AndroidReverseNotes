package com.tencent.mm.by;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureUploadManager.UploadTask;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.protocal.protobuf.cab;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.t;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class a implements e {
    public static a xul = new a();
    public static b xum = new b();
    public static c xun = new c();
    private com.tencent.mm.at.a.a luu;
    private String xug;
    private ArrayList<EmojiInfo> xuh = new ArrayList();
    private ArrayList<EmojiInfo> xui = new ArrayList();
    private HashMap<String, ArrayList<EmojiInfo>> xuj = new HashMap();
    private ArrayList<EmojiGroupInfo> xuk = new ArrayList();

    public static class a {
    }

    public static class b {
        public static boolean LR(int i) {
            AppMethodBeat.i(62590);
            Bundle bundle = new Bundle();
            bundle.putInt("key", i);
            boolean z = a.call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/userinfo/"), "ConfigStorage.getBoolean", null, bundle).getBoolean("key", false);
            AppMethodBeat.o(62590);
            return z;
        }

        public static String bJ(int i, String str) {
            AppMethodBeat.i(62591);
            Bundle bundle = new Bundle();
            bundle.putInt("key", i);
            String string = a.call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/userinfo/"), "ConfigStorage.getString", null, bundle).getString("key", str);
            AppMethodBeat.o(62591);
            return string;
        }

        public static void alW(String str) {
            AppMethodBeat.i(62592);
            ContentValues contentValues = new ContentValues();
            contentValues.put("type", Integer.valueOf(-29414086));
            contentValues.put("value", str);
            a.a(Uri.parse("content://com.tencent.mm.storage.provider.emotion/userinfo/"), contentValues);
            AppMethodBeat.o(62592);
        }
    }

    public static class c extends com.tencent.mm.m.e {
        public final synchronized void sg() {
            AppMethodBeat.i(62593);
            this.ewc = true;
            a.dmE();
            b bVar = a.xum;
            p(b.bJ(278529, null), false);
            a.dmE();
            bVar = a.xum;
            p(b.bJ(278530, null), false);
            AppMethodBeat.o(62593);
        }
    }

    public a() {
        AppMethodBeat.i(62594);
        AppMethodBeat.o(62594);
    }

    public final String Jh(String str) {
        AppMethodBeat.i(62595);
        String Jh;
        if (((h) g.RM().Rn()).SG()) {
            Jh = ((d) g.M(d.class)).getEmojiMgr().Jh(str);
            AppMethodBeat.o(62595);
            return Jh;
        }
        Jh = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getCurLangDesc", str, null).getString("data", "");
        AppMethodBeat.o(62595);
        return Jh;
    }

    public final EmojiInfo j(String str, int i, int i2, int i3) {
        AppMethodBeat.i(62596);
        EmojiInfo a;
        if (((h) g.RM().Rn()).SG()) {
            a = ((d) g.M(d.class)).getEmojiMgr().a(str, "", i, i2, i3, "");
            AppMethodBeat.o(62596);
            return a;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_md5", str);
        bundle.putInt("key_group", i);
        bundle.putInt("key_type", i2);
        bundle.putInt("key_size", i3);
        bundle = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "createEmojiInfo", null, bundle);
        if (bundle != null) {
            bundle.setClassLoader(EmojiInfo.class.getClassLoader());
            a = (EmojiInfo) bundle.getParcelable("key_emoji_info");
            AppMethodBeat.o(62596);
            return a;
        }
        AppMethodBeat.o(62596);
        return null;
    }

    public final void updateEmojiInfo(EmojiInfo emojiInfo) {
        AppMethodBeat.i(62597);
        if (((h) g.RM().Rn()).SG()) {
            ((d) g.M(d.class)).getEmojiMgr().updateEmojiInfo(emojiInfo);
            AppMethodBeat.o(62597);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.setClassLoader(EmojiInfo.class.getClassLoader());
        bundle.putParcelable("key_emoji_info", emojiInfo);
        call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "updateEmojiInfo", null, bundle);
        AppMethodBeat.o(62597);
    }

    public final cab bjU() {
        AppMethodBeat.i(62598);
        if (((h) g.RM().Rn()).SG()) {
            cab bjU = ((d) g.M(d.class)).getEmojiMgr().bjU();
            AppMethodBeat.o(62598);
            return bjU;
        }
        AppMethodBeat.o(62598);
        return null;
    }

    public final void a(cab cab) {
        AppMethodBeat.i(62599);
        if (((h) g.RM().Rn()).SG()) {
            ((d) g.M(d.class)).getEmojiMgr().a(cab);
        }
        AppMethodBeat.o(62599);
    }

    public final int y(boolean z, boolean z2) {
        AppMethodBeat.i(62600);
        int y;
        if (((h) g.RM().Rn()).SG()) {
            y = ((d) g.M(d.class)).getEmojiMgr().y(z, z2);
            AppMethodBeat.o(62600);
            return y;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("withSystem", z);
        bundle.putBoolean("onlySuccess", z2);
        y = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "countCustomEmoji", null, bundle).getInt("data", 0);
        AppMethodBeat.o(62600);
        return y;
    }

    public final int Jp(String str) {
        AppMethodBeat.i(62601);
        int Jp;
        if (((h) g.RM().Rn()).SG()) {
            Jp = ((d) g.M(d.class)).getEmojiMgr().Jp(str);
            AppMethodBeat.o(62601);
            return Jp;
        }
        Jp = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "countProductId", str, null).getInt("data", 0);
        AppMethodBeat.o(62601);
        return Jp;
    }

    public final int bjV() {
        AppMethodBeat.i(62602);
        int bjV;
        if (((h) g.RM().Rn()).SG()) {
            bjV = ((d) g.M(d.class)).getEmojiMgr().bjV();
            AppMethodBeat.o(62602);
            return bjV;
        }
        bjV = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getDownloadedCount", null, null).getInt("data", 0);
        AppMethodBeat.o(62602);
        return bjV;
    }

    public final boolean a(EmojiGroupInfo emojiGroupInfo) {
        AppMethodBeat.i(62603);
        if (((h) g.RM().Rn()).SG()) {
            boolean a = ((d) g.M(d.class)).getEmojiMgr().a(emojiGroupInfo);
            AppMethodBeat.o(62603);
            return a;
        }
        AppMethodBeat.o(62603);
        return false;
    }

    public final ArrayList<EmojiGroupInfo> OD() {
        AppMethodBeat.i(62604);
        ArrayList OD = com.tencent.mm.emoji.a.a.OB().OD();
        AppMethodBeat.o(62604);
        return OD;
    }

    public final ArrayList<EmojiInfo> bY(boolean z) {
        AppMethodBeat.i(62605);
        ArrayList bY = com.tencent.mm.emoji.a.a.OB().bY(z);
        AppMethodBeat.o(62605);
        return bY;
    }

    public final ArrayList<EmojiInfo> OC() {
        AppMethodBeat.i(62606);
        ArrayList OC = com.tencent.mm.emoji.a.a.OB().OC();
        AppMethodBeat.o(62606);
        return OC;
    }

    public final ArrayList<EmojiInfo> kS(String str) {
        AppMethodBeat.i(62607);
        ArrayList kS = com.tencent.mm.emoji.a.a.OB().kS(str);
        AppMethodBeat.o(62607);
        return kS;
    }

    public final com.tencent.mm.at.a.a bjW() {
        AppMethodBeat.i(62608);
        com.tencent.mm.at.a.a bjW;
        if (((h) g.RM().Rn()).SG()) {
            bjW = ((d) g.M(d.class)).getEmojiMgr().bjW();
            AppMethodBeat.o(62608);
            return bjW;
        }
        if (this.luu == null) {
            com.tencent.mm.at.a.a.b.a aVar = new com.tencent.mm.at.a.a.b.a(ah.getContext());
            aVar.fGT = new com.tencent.mm.view.d.a();
            this.luu = new com.tencent.mm.at.a.a(aVar.ahx());
        }
        bjW = this.luu;
        AppMethodBeat.o(62608);
        return bjW;
    }

    public final void g(com.tencent.mm.sdk.e.k.a aVar) {
        AppMethodBeat.i(62609);
        if (((h) g.RM().Rn()).SG()) {
            ((d) g.M(d.class)).getEmojiMgr().g(aVar);
        }
        AppMethodBeat.o(62609);
    }

    public final byte[] l(EmojiInfo emojiInfo) {
        AppMethodBeat.i(62610);
        byte[] l;
        if (((h) g.RM().Rn()).SG()) {
            l = ((d) g.M(d.class)).getEmojiMgr().l(emojiInfo);
            AppMethodBeat.o(62610);
            return l;
        }
        l = C(emojiInfo);
        AppMethodBeat.o(62610);
        return l;
    }

    public final void h(com.tencent.mm.sdk.e.k.a aVar) {
        AppMethodBeat.i(62611);
        if (((h) g.RM().Rn()).SG()) {
            ((d) g.M(d.class)).getEmojiMgr().h(aVar);
        }
        AppMethodBeat.o(62611);
    }

    public final void i(com.tencent.mm.sdk.e.k.a aVar) {
        AppMethodBeat.i(62612);
        if (((h) g.RM().Rn()).SG()) {
            ((d) g.M(d.class)).getEmojiMgr().i(aVar);
        }
        AppMethodBeat.o(62612);
    }

    public final void j(com.tencent.mm.sdk.e.k.a aVar) {
        AppMethodBeat.i(62613);
        if (((h) g.RM().Rn()).SG()) {
            ((d) g.M(d.class)).getEmojiMgr().j(aVar);
        }
        AppMethodBeat.o(62613);
    }

    public final EmojiInfo Je(String str) {
        AppMethodBeat.i(62614);
        EmojiInfo Je;
        if (((h) g.RM().Rn()).SG()) {
            Je = ((d) g.M(d.class)).getEmojiMgr().Je(str);
            AppMethodBeat.o(62614);
            return Je;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_md5", str);
        bundle = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getEmojiByMd5", null, bundle);
        if (bundle != null) {
            bundle.setClassLoader(EmojiInfo.class.getClassLoader());
            Je = (EmojiInfo) bundle.getParcelable("key_emoji_info");
            AppMethodBeat.o(62614);
            return Je;
        }
        AppMethodBeat.o(62614);
        return null;
    }

    public final EmojiInfo n(EmojiInfo emojiInfo) {
        AppMethodBeat.i(62615);
        EmojiInfo n;
        if (((h) g.RM().Rn()).SG()) {
            n = ((d) g.M(d.class)).getEmojiMgr().n(emojiInfo);
            AppMethodBeat.o(62615);
            return n;
        }
        Bundle bundle = new Bundle(EmojiInfo.class.getClassLoader());
        bundle.putParcelable("emoji", emojiInfo);
        bundle = ah.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getRandomEmoji", null, bundle);
        if (bundle == null) {
            ab.e("MicroMsg.EmotionStorageResolver", "[getRandomEmoji] bunndle is null! ");
            AppMethodBeat.o(62615);
            return null;
        }
        bundle.setClassLoader(EmojiInfo.class.getClassLoader());
        if (bundle.containsKey("data")) {
            n = (EmojiInfo) bundle.getParcelable("data");
            AppMethodBeat.o(62615);
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
        ab.e(str, str2, objArr);
        AppMethodBeat.o(62615);
        return null;
    }

    private static byte[] C(EmojiInfo emojiInfo) {
        byte[] bArr = null;
        AppMethodBeat.i(138408);
        if (emojiInfo == null) {
            ab.w("MicroMsg.EmotionStorageResolver", "[decodeEmojiDataExport] failed. emoji is null.");
            AppMethodBeat.o(138408);
            return bArr;
        }
        String dve = emojiInfo.dve();
        byte[] e = com.tencent.mm.vfs.e.e(dve, 0, -1);
        if (com.tencent.mm.vfs.e.asZ(dve) <= 0 || e == null || e.length < 10) {
            ab.i("MicroMsg.EmotionStorageResolver", "decode emoji file failed. path is no exist :%s ", dve);
            AppMethodBeat.o(138408);
            return bArr;
        }
        byte[] bArr2 = new byte[10];
        System.arraycopy(e, 0, bArr2, 0, 10);
        if ((emojiInfo.field_reserved4 & EmojiInfo.zZi) != EmojiInfo.zZi || r.bT(bArr2)) {
            AppMethodBeat.o(138408);
            return e;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int asZ = (int) com.tencent.mm.vfs.e.asZ(dve);
        if (asZ > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            asZ = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        }
        byte[] e2 = com.tencent.mm.vfs.e.e(dve, 0, asZ);
        if (!bo.isNullOrNil(bjL())) {
            try {
                bArr = AesEcb.aesCryptEcb(e2, bjL().getBytes(), false, false);
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.EmotionStorageResolver", th, "", new Object[0]);
            }
        }
        if (bo.cb(bArr) || bo.cb(e)) {
            ab.i("MicroMsg.EmotionStorageResolver", "decode emoji file failed. path:%s return original ", dve);
            AppMethodBeat.o(138408);
            return e;
        }
        System.arraycopy(bArr, 0, e, 0, asZ);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        ab.d("MicroMsg.EmotionStorageResolver", "decode emoji file length:%d use time:%d", Integer.valueOf(e.length), Long.valueOf(currentTimeMillis2));
        AppMethodBeat.o(138408);
        return e;
    }

    public final String getAccPath() {
        AppMethodBeat.i(62617);
        if (((h) g.RM().Rn()).SG()) {
            this.xug = ((d) g.M(d.class)).getEmojiMgr().getAccPath();
        } else if (bo.isNullOrNil(this.xug)) {
            this.xug = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getAccPath", null, null).getString("path");
        }
        String str = this.xug;
        AppMethodBeat.o(62617);
        return str;
    }

    public static Uri getUri() {
        AppMethodBeat.i(139077);
        Uri parse = Uri.parse("content://com.tencent.mm.storage.provider.emotion/");
        AppMethodBeat.o(139077);
        return parse;
    }

    static {
        AppMethodBeat.i(62641);
        AppMethodBeat.o(62641);
    }

    public static a dmE() {
        return xul;
    }

    public final void onDestroy() {
        AppMethodBeat.i(62619);
        this.xuk.clear();
        AppMethodBeat.o(62619);
    }

    public final boolean bjX() {
        AppMethodBeat.i(62620);
        if (((h) g.RM().Rn()).SG()) {
            boolean bjX = ((d) g.M(d.class)).getEmojiMgr().bjX();
            AppMethodBeat.o(62620);
            return bjX;
        }
        Bundle call = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "isEnableHEVCDecode", null, null);
        if (call == null || !call.getBoolean("key_data")) {
            AppMethodBeat.o(62620);
            return false;
        }
        AppMethodBeat.o(62620);
        return true;
    }

    public final boolean OS() {
        AppMethodBeat.i(62621);
        if (((h) g.RM().Rn()).SG()) {
            boolean OS = ((d) g.M(d.class)).getEmojiMgr().OS();
            AppMethodBeat.o(62621);
            return OS;
        }
        Bundle call = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "isEnableHevcUpload", null, null);
        if (call == null || !call.getBoolean("key_data")) {
            AppMethodBeat.o(62621);
            return false;
        }
        AppMethodBeat.o(62621);
        return true;
    }

    public final boolean OT() {
        AppMethodBeat.i(62622);
        if (((h) g.RM().Rn()).SG()) {
            boolean OT = ((d) g.M(d.class)).getEmojiMgr().OT();
            AppMethodBeat.o(62622);
            return OT;
        }
        AppMethodBeat.o(62622);
        return false;
    }

    public final void bZ(String str, int i) {
        AppMethodBeat.i(62623);
        if (((h) g.RM().Rn()).SG()) {
            ((d) g.M(d.class)).getEmojiMgr().bZ(str, i);
        }
        AppMethodBeat.o(62623);
    }

    public final List<t> bjY() {
        AppMethodBeat.i(62624);
        if (((h) g.RM().Rn()).SG()) {
            List bjY = ((d) g.M(d.class)).getEmojiMgr().bjY();
            AppMethodBeat.o(62624);
            return bjY;
        }
        AppMethodBeat.o(62624);
        return null;
    }

    public final void bjZ() {
        AppMethodBeat.i(62625);
        if (((h) g.RM().Rn()).SG()) {
            ((d) g.M(d.class)).getEmojiMgr().bjZ();
        }
        AppMethodBeat.o(62625);
    }

    public final <T> T c(com.tencent.mm.storage.ac.a aVar, T t) {
        AppMethodBeat.i(62626);
        if (((h) g.RM().Rn()).SG()) {
            Object c = ((d) g.M(d.class)).getEmojiMgr().c(aVar, t);
            AppMethodBeat.o(62626);
            return c;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_config_key", aVar);
        bundle = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getConfig", null, bundle);
        if (bundle != null) {
            T t2 = bundle.get("key_config_value");
            if (t2 != null) {
                AppMethodBeat.o(62626);
                return t2;
            }
        }
        AppMethodBeat.o(62626);
        return t;
    }

    public final void d(com.tencent.mm.storage.ac.a aVar, Object obj) {
        AppMethodBeat.i(62627);
        if (((h) g.RM().Rn()).SG()) {
            ((d) g.M(d.class)).getEmojiMgr().d(aVar, obj);
            AppMethodBeat.o(62627);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_config_key", aVar);
        bundle.putSerializable("key_config_value", (Serializable) obj);
        call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "setConfig", null, bundle);
        AppMethodBeat.o(62627);
    }

    public final void k(com.tencent.mm.sdk.e.k.a aVar) {
        AppMethodBeat.i(62628);
        if (((h) g.RM().Rn()).SG()) {
            ((d) g.M(d.class)).getEmojiMgr().l(aVar);
        }
        AppMethodBeat.o(62628);
    }

    public final boolean Jq(String str) {
        AppMethodBeat.i(62629);
        if (((h) g.RM().Rn()).SG()) {
            boolean Jq = ((d) g.M(d.class)).getEmojiMgr().Jq(str);
            AppMethodBeat.o(62629);
            return Jq;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_path", str);
        bundle = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "checkGifFile", null, bundle);
        if (bundle == null || !bundle.getBoolean("key_data")) {
            AppMethodBeat.o(62629);
            return false;
        }
        AppMethodBeat.o(62629);
        return true;
    }

    public final boolean bka() {
        AppMethodBeat.i(62630);
        if (((h) g.RM().Rn()).SG()) {
            boolean bka = ((d) g.M(d.class)).getEmojiMgr().bka();
            AppMethodBeat.o(62630);
            return bka;
        }
        AppMethodBeat.o(62630);
        return false;
    }

    public final ArrayList<SmileyInfo> bjO() {
        AppMethodBeat.i(62631);
        if (!((h) g.RM().Rn()).SG()) {
            Bundle call = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getSmileyInfoList", null, null);
            if (call != null) {
                call.setClassLoader(SmileyInfo.class.getClassLoader());
                Serializable serializable = call.getSerializable("key_data");
                if (serializable instanceof ArrayList) {
                    ArrayList<SmileyInfo> arrayList = (ArrayList) serializable;
                    AppMethodBeat.o(62631);
                    return arrayList;
                }
            }
        } else if (g.RN().QY()) {
            ((d) g.M(d.class)).getEmojiMgr().bjO();
        }
        AppMethodBeat.o(62631);
        return null;
    }

    public final void bjT() {
        AppMethodBeat.i(62632);
        if (((h) g.RM().Rn()).SG() && g.RN().QY()) {
            ((d) g.M(d.class)).getEmojiMgr().bjT();
        }
        AppMethodBeat.o(62632);
    }

    public final void l(com.tencent.mm.sdk.e.k.a aVar) {
        AppMethodBeat.i(62633);
        if (((h) g.RM().Rn()).SG()) {
            ((d) g.M(d.class)).getEmojiMgr().k(aVar);
        }
        AppMethodBeat.o(62633);
    }

    public static Bundle call(Uri uri, String str, String str2, Bundle bundle) {
        Bundle call;
        AppMethodBeat.i(62634);
        try {
            call = ah.getContext().getContentResolver().call(uri, str, str2, bundle);
        } catch (IllegalArgumentException | NullPointerException e) {
            ab.printErrStackTrace("MicroMsg.EmotionStorageResolver", e, "", new Object[0]);
            call = null;
        }
        if (call != null) {
            AppMethodBeat.o(62634);
            return call;
        }
        call = new Bundle();
        AppMethodBeat.o(62634);
        return call;
    }

    public final void Jr(String str) {
        AppMethodBeat.i(62635);
        if (!((h) g.RM().Rn()).SG()) {
            ah.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "deleteLoadingCaptureEmoji", str, null);
        } else if (g.RN().QY()) {
            ((d) g.M(d.class)).getEmojiMgr().Jr(str);
            AppMethodBeat.o(62635);
            return;
        }
        AppMethodBeat.o(62635);
    }

    public final void a(UploadTask uploadTask) {
        AppMethodBeat.i(62636);
        if (!((h) g.RM().Rn()).SG()) {
            Bundle bundle = new Bundle();
            bundle.putString("emojiMd5", uploadTask.lgZ);
            bundle.putParcelable("reporter", uploadTask.lha);
            ah.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "uploadEmojiRemote", null, bundle);
        } else if (g.RN().QY()) {
            ((d) g.M(d.class)).getEmojiMgr().a(uploadTask);
            AppMethodBeat.o(62636);
            return;
        }
        AppMethodBeat.o(62636);
    }

    public final void q(EmojiInfo emojiInfo) {
        AppMethodBeat.i(62637);
        if (!((h) g.RM().Rn()).SG()) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("emojiInfo", emojiInfo);
            ah.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "showCaptureEmojiInPanel", null, bundle);
        } else if (g.RN().QY()) {
            ((d) g.M(d.class)).getEmojiMgr().q(emojiInfo);
            AppMethodBeat.o(62637);
            return;
        }
        AppMethodBeat.o(62637);
    }

    public final void r(EmojiInfo emojiInfo) {
        AppMethodBeat.i(62638);
        if (!((h) g.RM().Rn()).SG()) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("emojiInfo", emojiInfo);
            ah.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "showCaptureEmojiDefaultErrorDialog", null, bundle);
        } else if (g.RN().QY()) {
            ((d) g.M(d.class)).getEmojiMgr().r(emojiInfo);
            AppMethodBeat.o(62638);
            return;
        }
        AppMethodBeat.o(62638);
    }

    public final void b(UploadTask uploadTask) {
        AppMethodBeat.i(62639);
        if (!((h) g.RM().Rn()).SG()) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("uploadTask", uploadTask);
            ah.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "addCaptureEmojiUploadTask", null, bundle);
        } else if (g.RN().QY()) {
            ((d) g.M(d.class)).getEmojiMgr().b(uploadTask);
            AppMethodBeat.o(62639);
            return;
        }
        AppMethodBeat.o(62639);
    }

    private static String bjL() {
        AppMethodBeat.i(62616);
        String string = call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getEmojiKey", null, null).getString("key", "");
        AppMethodBeat.o(62616);
        return string;
    }

    static /* synthetic */ void a(Uri uri, ContentValues contentValues) {
        AppMethodBeat.i(62640);
        try {
            ah.getContext().getContentResolver().update(uri, contentValues, null, null);
            AppMethodBeat.o(62640);
        } catch (IllegalArgumentException e) {
            ab.printErrStackTrace("MicroMsg.EmotionStorageResolver", e, "", new Object[0]);
            AppMethodBeat.o(62640);
        }
    }
}
