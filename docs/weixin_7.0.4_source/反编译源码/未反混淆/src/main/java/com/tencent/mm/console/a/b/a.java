package com.tencent.mm.console.a.b;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.e;
import com.tencent.mm.cd.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

public class a implements com.tencent.mm.pluginsdk.cmd.a {
    private static final int[] ewC = new int[]{0, 1};

    public interface a {
        void execute();
    }

    static /* synthetic */ int jg(int i) {
        AppMethodBeat.i(16166);
        int je = je(i);
        AppMethodBeat.o(16166);
        return je;
    }

    static {
        AppMethodBeat.i(16172);
        try {
            Object newInstance = Class.forName("com.tencent.mm.console.a.b.a").newInstance();
            if (newInstance != null && (newInstance instanceof com.tencent.mm.pluginsdk.cmd.a)) {
                b.a((com.tencent.mm.pluginsdk.cmd.a) newInstance, "//aging");
            }
            AppMethodBeat.o(16172);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.AgingTestCommand", th, "", new Object[0]);
            AppMethodBeat.o(16172);
        }
    }

    private a() {
    }

    public final boolean a(final Context context, final String[] strArr, String str) {
        AppMethodBeat.i(16159);
        if (ab.getLogLevel() > 1) {
            AppMethodBeat.o(16159);
            return false;
        } else if (strArr.length <= 1) {
            AppMethodBeat.o(16159);
            return false;
        } else {
            String Yz = r.Yz();
            final b bVar = new b();
            for (int i = ReaderCallback.HIDDEN_BAR; i <= 6000; i++) {
                bVar.ewK.add("rdgztest_atm".concat(String.valueOf(i)));
            }
            h bOy = ((j) g.K(j.class)).bOr().bOy();
            Cursor a = bOy.a("SELECT * FROM message WHERE talker=? AND (type=3 OR type=43 OR type=47) AND isSend=1", new String[]{Yz}, 0);
            while (a.moveToNext()) {
                bi biVar = new bi();
                biVar.d(a);
                Cursor a2;
                switch (biVar.getType()) {
                    case 3:
                        a2 = bOy.a("SELECT * FROM ImgInfo2 WHERE msgSvrId=?", new String[]{String.valueOf(biVar.field_msgSvrId)}, 0);
                        if (a2.moveToNext()) {
                            e eVar = new e();
                            eVar.d(a2);
                            bVar.ewL.add(new c(biVar, eVar));
                        }
                        a2.close();
                        break;
                    case 43:
                        a2 = bOy.a("SELECT * FROM videoinfo2 WHERE msgsvrid=?", new String[]{String.valueOf(biVar.field_msgSvrId)}, 0);
                        if (a2.moveToNext()) {
                            s sVar = new s();
                            sVar.d(a2);
                            bVar.ewM.add(new c(biVar, sVar));
                        }
                        a2.close();
                        break;
                    case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                        a2 = bOy.a("SELECT * FROM EmojiInfo WHERE md5=?", new String[]{biVar.field_imgPath}, 0);
                        if (a2.moveToNext()) {
                            EmojiInfo emojiInfo = new EmojiInfo();
                            emojiInfo.d(a2);
                            bVar.ewN.add(new c(biVar, emojiInfo));
                        }
                        a2.close();
                        break;
                    default:
                        break;
                }
            }
            a.close();
            if (bVar.ewL.isEmpty() && bVar.ewN.isEmpty() && bVar.ewM.isEmpty()) {
                Toast.makeText(context, "please send some data(img,video,emoji) to yourself", 1).show();
                AppMethodBeat.o(16159);
                return false;
            }
            ab.i("MicroMsg.AgingTestCommand", "[oneliang]username size:%s,image size:%s,emoji size:%s,video size:%s", Integer.valueOf(bVar.ewK.size()), Integer.valueOf(bVar.ewL.size()), Integer.valueOf(bVar.ewN.size()), Integer.valueOf(bVar.ewM.size()));
            if (strArr.length == 2) {
                Toast.makeText(context, "aging begin", 1).show();
                aw.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(16154);
                        a.R(bVar.ewK);
                        a.a(a.this, null, bo.getInt(strArr[1], 0), bVar);
                        a.a(a.this, context);
                        AppMethodBeat.o(16154);
                    }
                });
                AppMethodBeat.o(16159);
                return true;
            } else if (strArr.length < 3) {
                AppMethodBeat.o(16159);
                return false;
            } else {
                final int i2 = bo.getInt(strArr[2], 0);
                Yz = strArr[1];
                Object obj = -1;
                switch (Yz.hashCode()) {
                    case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                        if (Yz.equals("1")) {
                            obj = null;
                            break;
                        }
                        break;
                    case 50:
                        if (Yz.equals("2")) {
                            obj = 1;
                            break;
                        }
                        break;
                    case 51:
                        if (Yz.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                            obj = 2;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                        aw.RS().aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(16155);
                                a.jf(i2);
                                a.a(a.this, context);
                                AppMethodBeat.o(16155);
                            }
                        });
                        AppMethodBeat.o(16159);
                        return true;
                    case 1:
                        String str2 = null;
                        if (strArr.length == 4) {
                            str2 = strArr[3];
                        }
                        final Context context2 = context;
                        aw.RS().aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(16156);
                                a.a(a.this, str2, i2, bVar);
                                a.a(a.this, context2);
                                AppMethodBeat.o(16156);
                            }
                        });
                        AppMethodBeat.o(16159);
                        return true;
                    case 2:
                        AppMethodBeat.o(16159);
                        return true;
                    default:
                        AppMethodBeat.o(16159);
                        return true;
                }
            }
        }
    }

    private static int je(int i) {
        AppMethodBeat.i(16160);
        int random = (int) (Math.random() * ((double) i));
        if (random >= i) {
            random = 0;
        }
        AppMethodBeat.o(16160);
        return random;
    }

    private static ad G(String str, int i) {
        AppMethodBeat.i(16161);
        ad adVar = new ad();
        adVar.ewQ = (long) (100000 + i);
        adVar.setUsername(str);
        adVar.iy("alias_".concat(String.valueOf(i)));
        adVar.iB("nickName_".concat(String.valueOf(i)));
        adVar.iD("quanPin_".concat(String.valueOf(i)));
        adVar.iC("pyInitial_".concat(String.valueOf(i)));
        adVar.setType(3);
        AppMethodBeat.o(16161);
        return adVar;
    }

    private static byte[] eX(long j) {
        return new byte[]{(byte) ((int) (j & 255)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 24) & 255)), (byte) ((int) ((j >> 32) & 255)), (byte) ((int) ((j >> 40) & 255)), (byte) ((int) ((j >> 48) & 255)), (byte) ((int) ((j >> 56) & 255))};
    }

    static /* synthetic */ void R(List list) {
        AppMethodBeat.i(16162);
        if (list != null) {
            ab.i("MicroMsg.AgingTestCommand", "[oneliang]do insert contact by username list begin,count:" + list.size());
            for (int i = 0; i < list.size(); i++) {
                String str = (String) list.get(i);
                ad G = G(str, i);
                if (!((j) g.K(j.class)).XM().aoQ(str)) {
                    ((j) g.K(j.class)).XM().Z(G);
                }
            }
            ab.i("MicroMsg.AgingTestCommand", "[oneliang]do insert contact by username list end,count:%s", Integer.valueOf(list.size()));
        }
        AppMethodBeat.o(16162);
    }

    static /* synthetic */ void jf(int i) {
        AppMethodBeat.i(16165);
        ab.i("MicroMsg.AgingTestCommand", "[oneliang]do insert contact begin,count:%s", Integer.valueOf(i));
        ab.i("MicroMsg.AgingTestCommand", "[oneliang]get exists count:%s", Integer.valueOf(t.Zo()));
        int Zo = t.Zo();
        for (int i2 = Zo; i2 < i + Zo; i2++) {
            String concat = "rdgztest_atm".concat(String.valueOf(i2));
            ad G = G("rdgztest_atm".concat(String.valueOf(i2)), i2);
            if (!((j) g.K(j.class)).XM().aoQ(concat)) {
                ((j) g.K(j.class)).XM().Z(G);
            }
        }
        ab.i("MicroMsg.AgingTestCommand", "[oneliang]do insert contact end,count:%s", Integer.valueOf(i));
        AppMethodBeat.o(16165);
    }

    static /* synthetic */ bi b(String str, c cVar) {
        AppMethodBeat.i(16168);
        if (cVar == null) {
            AppMethodBeat.o(16168);
            return null;
        }
        bi biVar = (bi) cVar.ewO;
        String str2 = str + biVar.field_content.substring(biVar.field_content.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D));
        biVar = new bi();
        biVar.ju(str);
        biVar.setContent(str2);
        biVar.setType(43);
        int[] iArr = ewC;
        biVar.hO(iArr[je(iArr.length)]);
        if (biVar.field_isSend == 1) {
            biVar.setStatus(4);
        } else {
            biVar.setStatus(3);
        }
        biVar.I(bo.anf("7B00000000000000000000000000000000000000000000000100000000000000000000000000000000000000007D"));
        long currentTimeMillis = System.currentTimeMillis();
        biVar.eI(currentTimeMillis);
        biVar.eJ(currentTimeMillis);
        biVar.jv(com.tencent.mm.a.g.x(eX(currentTimeMillis)));
        AppMethodBeat.o(16168);
        return biVar;
    }

    static /* synthetic */ bi c(String str, c cVar) {
        AppMethodBeat.i(16169);
        if (cVar == null) {
            AppMethodBeat.o(16169);
            return null;
        }
        bi biVar = (bi) cVar.ewO;
        EmojiInfo emojiInfo = (EmojiInfo) cVar.ewP;
        String str2 = biVar.field_content;
        String str3 = str + str2.substring(str2.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D));
        String str4 = "7B00000000000000000000000000000000000000000000000100000000000000000000000000000000000000007D";
        bi biVar2 = new bi();
        biVar2.ju(str);
        biVar2.setContent(str3);
        biVar2.setType(47);
        int[] iArr = ewC;
        biVar2.hO(iArr[je(iArr.length)]);
        if (biVar2.field_isSend == 1) {
            biVar2.setStatus(4);
        } else {
            biVar2.setStatus(3);
        }
        biVar2.jv(biVar.field_imgPath);
        biVar2.I(bo.anf(str4));
        long currentTimeMillis = System.currentTimeMillis();
        biVar2.eI(currentTimeMillis);
        biVar2.eJ(currentTimeMillis);
        EmojiInfo emojiInfo2 = new EmojiInfo();
        emojiInfo2.field_md5 = emojiInfo.Aq();
        emojiInfo2.field_svrid = emojiInfo.duW();
        emojiInfo2.field_catalog = bo.a(Integer.valueOf(emojiInfo.field_catalog), 0);
        emojiInfo2.field_type = bo.a(Integer.valueOf(emojiInfo.field_type), 0);
        emojiInfo2.field_size = bo.a(Integer.valueOf(emojiInfo.field_size), 0);
        emojiInfo2.field_start = bo.a(Integer.valueOf(emojiInfo.field_start), 0);
        emojiInfo2.field_state = bo.a(Integer.valueOf(emojiInfo.field_state), 0);
        emojiInfo2.field_reserved3 = bo.a(Integer.valueOf(emojiInfo.field_reserved3), 0);
        emojiInfo2.field_reserved4 = bo.a(Integer.valueOf(emojiInfo.field_reserved4), 0);
        emojiInfo2.field_groupId = emojiInfo.field_groupId;
        emojiInfo2.field_lastUseTime = bo.a(Long.valueOf(emojiInfo.field_lastUseTime), 0);
        emojiInfo2.field_idx = bo.a(Integer.valueOf(emojiInfo.field_idx), 0);
        emojiInfo2.field_temp = bo.a(Integer.valueOf(emojiInfo.field_temp), 0);
        emojiInfo2.field_source = bo.a(Integer.valueOf(emojiInfo.field_source), 0);
        emojiInfo2.field_needupload = bo.a(Integer.valueOf(emojiInfo.field_needupload), 0);
        emojiInfo2.field_thumbUrl = emojiInfo.field_thumbUrl;
        emojiInfo2.field_cdnUrl = emojiInfo.field_cdnUrl;
        emojiInfo2.field_encrypturl = emojiInfo.field_encrypturl;
        emojiInfo2.field_aeskey = emojiInfo.field_aeskey;
        emojiInfo2.field_width = bo.a(Integer.valueOf(emojiInfo.field_width), 0);
        emojiInfo2.field_height = bo.a(Integer.valueOf(emojiInfo.field_height), 0);
        if (!com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().xYn.aql(emojiInfo.Aq())) {
            com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().xYn.F(emojiInfo2);
        }
        AppMethodBeat.o(16169);
        return biVar2;
    }

    static /* synthetic */ bi H(String str, int i) {
        AppMethodBeat.i(16170);
        bi biVar = new bi();
        biVar.ju(str);
        biVar.setContent("text_".concat(String.valueOf(i)));
        biVar.setType(1);
        int[] iArr = ewC;
        biVar.hO(iArr[je(iArr.length)]);
        if (biVar.field_isSend == 1) {
            biVar.setStatus(4);
        } else {
            biVar.setStatus(3);
        }
        long currentTimeMillis = System.currentTimeMillis();
        biVar.eI(currentTimeMillis);
        biVar.eJ(currentTimeMillis);
        AppMethodBeat.o(16170);
        return biVar;
    }
}
