package com.tencent.p177mm.console.p845a.p846b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.console.a.b.a */
public class C45297a implements C44041a {
    private static final int[] ewC = new int[]{0, 1};

    /* renamed from: com.tencent.mm.console.a.b.a$5 */
    class C92515 implements OnClickListener {
        C92515() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(16158);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(16158);
        }
    }

    /* renamed from: com.tencent.mm.console.a.b.a$a */
    public interface C26057a {
        void execute();
    }

    /* renamed from: jg */
    static /* synthetic */ int m83536jg(int i) {
        AppMethodBeat.m2504i(16166);
        int je = C45297a.m83534je(i);
        AppMethodBeat.m2505o(16166);
        return je;
    }

    static {
        AppMethodBeat.m2504i(16172);
        try {
            Object newInstance = Class.forName("com.tencent.mm.console.a.b.a").newInstance();
            if (newInstance != null && (newInstance instanceof C44041a)) {
                C44042b.m79163a((C44041a) newInstance, "//aging");
            }
            AppMethodBeat.m2505o(16172);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.AgingTestCommand", th, "", new Object[0]);
            AppMethodBeat.m2505o(16172);
        }
    }

    private C45297a() {
    }

    /* renamed from: a */
    public final boolean mo7165a(final Context context, final String[] strArr, String str) {
        AppMethodBeat.m2504i(16159);
        if (C4990ab.getLogLevel() > 1) {
            AppMethodBeat.m2505o(16159);
            return false;
        } else if (strArr.length <= 1) {
            AppMethodBeat.m2505o(16159);
            return false;
        } else {
            String Yz = C1853r.m3846Yz();
            final C41945b c41945b = new C41945b();
            for (int i = ReaderCallback.HIDDEN_BAR; i <= 6000; i++) {
                c41945b.ewK.add("rdgztest_atm".concat(String.valueOf(i)));
            }
            C7480h bOy = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().bOy();
            Cursor a = bOy.mo10104a("SELECT * FROM message WHERE talker=? AND (type=3 OR type=43 OR type=47) AND isSend=1", new String[]{Yz}, 0);
            while (a.moveToNext()) {
                C7620bi c7620bi = new C7620bi();
                c7620bi.mo8995d(a);
                Cursor a2;
                switch (c7620bi.getType()) {
                    case 3:
                        a2 = bOy.mo10104a("SELECT * FROM ImgInfo2 WHERE msgSvrId=?", new String[]{String.valueOf(c7620bi.field_msgSvrId)}, 0);
                        if (a2.moveToNext()) {
                            C25822e c25822e = new C25822e();
                            c25822e.mo43791d(a2);
                            c41945b.ewL.add(new C41946c(c7620bi, c25822e));
                        }
                        a2.close();
                        break;
                    case 43:
                        a2 = bOy.mo10104a("SELECT * FROM videoinfo2 WHERE msgsvrid=?", new String[]{String.valueOf(c7620bi.field_msgSvrId)}, 0);
                        if (a2.moveToNext()) {
                            C26493s c26493s = new C26493s();
                            c26493s.mo44274d(a2);
                            c41945b.ewM.add(new C41946c(c7620bi, c26493s));
                        }
                        a2.close();
                        break;
                    case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                        a2 = bOy.mo10104a("SELECT * FROM EmojiInfo WHERE md5=?", new String[]{c7620bi.field_imgPath}, 0);
                        if (a2.moveToNext()) {
                            EmojiInfo emojiInfo = new EmojiInfo();
                            emojiInfo.mo8995d(a2);
                            c41945b.ewN.add(new C41946c(c7620bi, emojiInfo));
                        }
                        a2.close();
                        break;
                    default:
                        break;
                }
            }
            a.close();
            if (c41945b.ewL.isEmpty() && c41945b.ewN.isEmpty() && c41945b.ewM.isEmpty()) {
                Toast.makeText(context, "please send some data(img,video,emoji) to yourself", 1).show();
                AppMethodBeat.m2505o(16159);
                return false;
            }
            C4990ab.m7417i("MicroMsg.AgingTestCommand", "[oneliang]username size:%s,image size:%s,emoji size:%s,video size:%s", Integer.valueOf(c41945b.ewK.size()), Integer.valueOf(c41945b.ewL.size()), Integer.valueOf(c41945b.ewN.size()), Integer.valueOf(c41945b.ewM.size()));
            if (strArr.length == 2) {
                Toast.makeText(context, "aging begin", 1).show();
                C9638aw.m17180RS().mo10302aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(16154);
                        C45297a.m83526R(c41945b.ewK);
                        C45297a.m83530a(C45297a.this, null, C5046bo.getInt(strArr[1], 0), c41945b);
                        C45297a.m83529a(C45297a.this, context);
                        AppMethodBeat.m2505o(16154);
                    }
                });
                AppMethodBeat.m2505o(16159);
                return true;
            } else if (strArr.length < 3) {
                AppMethodBeat.m2505o(16159);
                return false;
            } else {
                final int i2 = C5046bo.getInt(strArr[2], 0);
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
                        C9638aw.m17180RS().mo10302aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(16155);
                                C45297a.m83535jf(i2);
                                C45297a.m83529a(C45297a.this, context);
                                AppMethodBeat.m2505o(16155);
                            }
                        });
                        AppMethodBeat.m2505o(16159);
                        return true;
                    case 1:
                        String str2 = null;
                        if (strArr.length == 4) {
                            str2 = strArr[3];
                        }
                        final Context context2 = context;
                        C9638aw.m17180RS().mo10302aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(16156);
                                C45297a.m83530a(C45297a.this, str2, i2, c41945b);
                                C45297a.m83529a(C45297a.this, context2);
                                AppMethodBeat.m2505o(16156);
                            }
                        });
                        AppMethodBeat.m2505o(16159);
                        return true;
                    case 2:
                        AppMethodBeat.m2505o(16159);
                        return true;
                    default:
                        AppMethodBeat.m2505o(16159);
                        return true;
                }
            }
        }
    }

    /* renamed from: je */
    private static int m83534je(int i) {
        AppMethodBeat.m2504i(16160);
        int random = (int) (Math.random() * ((double) i));
        if (random >= i) {
            random = 0;
        }
        AppMethodBeat.m2505o(16160);
        return random;
    }

    /* renamed from: G */
    private static C7616ad m83524G(String str, int i) {
        AppMethodBeat.m2504i(16161);
        C7616ad c7616ad = new C7616ad();
        c7616ad.ewQ = (long) (100000 + i);
        c7616ad.setUsername(str);
        c7616ad.mo14728iy("alias_".concat(String.valueOf(i)));
        c7616ad.mo14703iB("nickName_".concat(String.valueOf(i)));
        c7616ad.mo14705iD("quanPin_".concat(String.valueOf(i)));
        c7616ad.mo14704iC("pyInitial_".concat(String.valueOf(i)));
        c7616ad.setType(3);
        AppMethodBeat.m2505o(16161);
        return c7616ad;
    }

    /* renamed from: eX */
    private static byte[] m83533eX(long j) {
        return new byte[]{(byte) ((int) (j & 255)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 24) & 255)), (byte) ((int) ((j >> 32) & 255)), (byte) ((int) ((j >> 40) & 255)), (byte) ((int) ((j >> 48) & 255)), (byte) ((int) ((j >> 56) & 255))};
    }

    /* renamed from: R */
    static /* synthetic */ void m83526R(List list) {
        AppMethodBeat.m2504i(16162);
        if (list != null) {
            C4990ab.m7416i("MicroMsg.AgingTestCommand", "[oneliang]do insert contact by username list begin,count:" + list.size());
            for (int i = 0; i < list.size(); i++) {
                String str = (String) list.get(i);
                C7616ad G = C45297a.m83524G(str, i);
                if (!((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoQ(str)) {
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15702Z(G);
                }
            }
            C4990ab.m7417i("MicroMsg.AgingTestCommand", "[oneliang]do insert contact by username list end,count:%s", Integer.valueOf(list.size()));
        }
        AppMethodBeat.m2505o(16162);
    }

    /* renamed from: jf */
    static /* synthetic */ void m83535jf(int i) {
        AppMethodBeat.m2504i(16165);
        C4990ab.m7417i("MicroMsg.AgingTestCommand", "[oneliang]do insert contact begin,count:%s", Integer.valueOf(i));
        C4990ab.m7417i("MicroMsg.AgingTestCommand", "[oneliang]get exists count:%s", Integer.valueOf(C1855t.m3878Zo()));
        int Zo = C1855t.m3878Zo();
        for (int i2 = Zo; i2 < i + Zo; i2++) {
            String concat = "rdgztest_atm".concat(String.valueOf(i2));
            C7616ad G = C45297a.m83524G("rdgztest_atm".concat(String.valueOf(i2)), i2);
            if (!((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoQ(concat)) {
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15702Z(G);
            }
        }
        C4990ab.m7417i("MicroMsg.AgingTestCommand", "[oneliang]do insert contact end,count:%s", Integer.valueOf(i));
        AppMethodBeat.m2505o(16165);
    }

    /* renamed from: b */
    static /* synthetic */ C7620bi m83531b(String str, C41946c c41946c) {
        AppMethodBeat.m2504i(16168);
        if (c41946c == null) {
            AppMethodBeat.m2505o(16168);
            return null;
        }
        C7620bi c7620bi = (C7620bi) c41946c.ewO;
        String str2 = str + c7620bi.field_content.substring(c7620bi.field_content.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D));
        c7620bi = new C7620bi();
        c7620bi.mo14794ju(str);
        c7620bi.setContent(str2);
        c7620bi.setType(43);
        int[] iArr = ewC;
        c7620bi.mo14781hO(iArr[C45297a.m83534je(iArr.length)]);
        if (c7620bi.field_isSend == 1) {
            c7620bi.setStatus(4);
        } else {
            c7620bi.setStatus(3);
        }
        c7620bi.mo14773I(C5046bo.anf("7B00000000000000000000000000000000000000000000000100000000000000000000000000000000000000007D"));
        long currentTimeMillis = System.currentTimeMillis();
        c7620bi.mo14774eI(currentTimeMillis);
        c7620bi.mo14775eJ(currentTimeMillis);
        c7620bi.mo14795jv(C1178g.m2591x(C45297a.m83533eX(currentTimeMillis)));
        AppMethodBeat.m2505o(16168);
        return c7620bi;
    }

    /* renamed from: c */
    static /* synthetic */ C7620bi m83532c(String str, C41946c c41946c) {
        AppMethodBeat.m2504i(16169);
        if (c41946c == null) {
            AppMethodBeat.m2505o(16169);
            return null;
        }
        C7620bi c7620bi = (C7620bi) c41946c.ewO;
        EmojiInfo emojiInfo = (EmojiInfo) c41946c.ewP;
        String str2 = c7620bi.field_content;
        String str3 = str + str2.substring(str2.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D));
        String str4 = "7B00000000000000000000000000000000000000000000000100000000000000000000000000000000000000007D";
        C7620bi c7620bi2 = new C7620bi();
        c7620bi2.mo14794ju(str);
        c7620bi2.setContent(str3);
        c7620bi2.setType(47);
        int[] iArr = ewC;
        c7620bi2.mo14781hO(iArr[C45297a.m83534je(iArr.length)]);
        if (c7620bi2.field_isSend == 1) {
            c7620bi2.setStatus(4);
        } else {
            c7620bi2.setStatus(3);
        }
        c7620bi2.mo14795jv(c7620bi.field_imgPath);
        c7620bi2.mo14773I(C5046bo.anf(str4));
        long currentTimeMillis = System.currentTimeMillis();
        c7620bi2.mo14774eI(currentTimeMillis);
        c7620bi2.mo14775eJ(currentTimeMillis);
        EmojiInfo emojiInfo2 = new EmojiInfo();
        emojiInfo2.field_md5 = emojiInfo.mo20410Aq();
        emojiInfo2.field_svrid = emojiInfo.duW();
        emojiInfo2.field_catalog = C5046bo.m7512a(Integer.valueOf(emojiInfo.field_catalog), 0);
        emojiInfo2.field_type = C5046bo.m7512a(Integer.valueOf(emojiInfo.field_type), 0);
        emojiInfo2.field_size = C5046bo.m7512a(Integer.valueOf(emojiInfo.field_size), 0);
        emojiInfo2.field_start = C5046bo.m7512a(Integer.valueOf(emojiInfo.field_start), 0);
        emojiInfo2.field_state = C5046bo.m7512a(Integer.valueOf(emojiInfo.field_state), 0);
        emojiInfo2.field_reserved3 = C5046bo.m7512a(Integer.valueOf(emojiInfo.field_reserved3), 0);
        emojiInfo2.field_reserved4 = C5046bo.m7512a(Integer.valueOf(emojiInfo.field_reserved4), 0);
        emojiInfo2.field_groupId = emojiInfo.field_groupId;
        emojiInfo2.field_lastUseTime = C5046bo.m7514a(Long.valueOf(emojiInfo.field_lastUseTime), 0);
        emojiInfo2.field_idx = C5046bo.m7512a(Integer.valueOf(emojiInfo.field_idx), 0);
        emojiInfo2.field_temp = C5046bo.m7512a(Integer.valueOf(emojiInfo.field_temp), 0);
        emojiInfo2.field_source = C5046bo.m7512a(Integer.valueOf(emojiInfo.field_source), 0);
        emojiInfo2.field_needupload = C5046bo.m7512a(Integer.valueOf(emojiInfo.field_needupload), 0);
        emojiInfo2.field_thumbUrl = emojiInfo.field_thumbUrl;
        emojiInfo2.field_cdnUrl = emojiInfo.field_cdnUrl;
        emojiInfo2.field_encrypturl = emojiInfo.field_encrypturl;
        emojiInfo2.field_aeskey = emojiInfo.field_aeskey;
        emojiInfo2.field_width = C5046bo.m7512a(Integer.valueOf(emojiInfo.field_width), 0);
        emojiInfo2.field_height = C5046bo.m7512a(Integer.valueOf(emojiInfo.field_height), 0);
        if (!C42952j.getEmojiStorageMgr().xYn.aql(emojiInfo.mo20410Aq())) {
            C42952j.getEmojiStorageMgr().xYn.mo48554F(emojiInfo2);
        }
        AppMethodBeat.m2505o(16169);
        return c7620bi2;
    }

    /* renamed from: H */
    static /* synthetic */ C7620bi m83525H(String str, int i) {
        AppMethodBeat.m2504i(16170);
        C7620bi c7620bi = new C7620bi();
        c7620bi.mo14794ju(str);
        c7620bi.setContent("text_".concat(String.valueOf(i)));
        c7620bi.setType(1);
        int[] iArr = ewC;
        c7620bi.mo14781hO(iArr[C45297a.m83534je(iArr.length)]);
        if (c7620bi.field_isSend == 1) {
            c7620bi.setStatus(4);
        } else {
            c7620bi.setStatus(3);
        }
        long currentTimeMillis = System.currentTimeMillis();
        c7620bi.mo14774eI(currentTimeMillis);
        c7620bi.mo14775eJ(currentTimeMillis);
        AppMethodBeat.m2505o(16170);
        return c7620bi;
    }
}
