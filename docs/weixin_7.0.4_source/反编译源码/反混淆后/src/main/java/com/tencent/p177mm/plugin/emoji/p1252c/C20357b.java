package com.tencent.p177mm.plugin.emoji.p1252c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1177ao.C37462a;
import com.tencent.p177mm.p211cb.C37626b;
import com.tencent.p177mm.p230g.p231a.C32519bf;
import com.tencent.p177mm.plugin.emoji.p947e.C45852j;
import com.tencent.p177mm.plugin.emoji.p947e.C45852j.C27735a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.emoji.c.b */
public final class C20357b extends C4884c<C32519bf> {
    public C20357b() {
        AppMethodBeat.m2504i(52812);
        this.xxI = C32519bf.class.getName().hashCode();
        AppMethodBeat.m2505o(52812);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static boolean m31448a(C32519bf c32519bf) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(52813);
        if (c32519bf instanceof C32519bf) {
            if (c32519bf.cus.cut == 33) {
                C5728b c5728b = new C5728b(c32519bf.cus.filePath);
                if (c5728b.exists()) {
                    C4990ab.m7417i("MicroMsg.emoji.EmojiResUpdateListener", "checkResUpdateListener callback to update %s", c5728b.dME());
                    C5728b c5728b2 = new C5728b(C37462a.afU(), "temp");
                    C5728b c5728b3 = new C5728b(c5728b2, "emoji_template.zip");
                    c5728b2.mkdirs();
                    C5730e.m8644y(C5736j.m8649w(c5728b.dMD()), C5736j.m8649w(c5728b3.dMD()));
                    int i = 1;
                    if (C5730e.m8636iu(C5736j.m8649w(c5728b3.dMD()), C5736j.m8649w(c5728b2.dMD())) >= 0) {
                        Closeable closeable = null;
                        Closeable inputStreamReader;
                        Closeable bufferedReader;
                        try {
                            closeable = C5730e.m8638p(new C5728b(c5728b2, "config.conf"));
                            inputStreamReader = new InputStreamReader(closeable);
                            try {
                                bufferedReader = new BufferedReader(inputStreamReader);
                                try {
                                    String str = "";
                                    while (true) {
                                        String readLine = bufferedReader.readLine();
                                        if (readLine == null) {
                                            break;
                                        }
                                        str = str + readLine;
                                    }
                                    i = new JSONObject(str).getInt("version");
                                    C4990ab.m7411d("MicroMsg.emoji.EmojiResUpdateListener", "config file content:%s version:%d", str, Integer.valueOf(i));
                                    C5046bo.m7527b(closeable);
                                    C5046bo.m7527b(inputStreamReader);
                                    C5046bo.m7527b(bufferedReader);
                                } catch (Exception e2) {
                                    e = e2;
                                    try {
                                        C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", e, e.getMessage(), new Object[0]);
                                        C5046bo.m7527b(closeable);
                                        C5046bo.m7527b(inputStreamReader);
                                        C5046bo.m7527b(bufferedReader);
                                        C5730e.m8618N(C5736j.m8649w(c5728b2.mUri), true);
                                        C5730e.deleteFile(C5736j.m8649w(c5728b3.mUri));
                                        if (C37462a.fAH >= i) {
                                        }
                                        AppMethodBeat.m2505o(52813);
                                        return false;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        C5046bo.m7527b(closeable);
                                        C5046bo.m7527b(inputStreamReader);
                                        C5046bo.m7527b(bufferedReader);
                                        AppMethodBeat.m2505o(52813);
                                        throw th;
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                bufferedReader = null;
                                C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", e, e.getMessage(), new Object[0]);
                                C5046bo.m7527b(closeable);
                                C5046bo.m7527b(inputStreamReader);
                                C5046bo.m7527b(bufferedReader);
                                C5730e.m8618N(C5736j.m8649w(c5728b2.mUri), true);
                                C5730e.deleteFile(C5736j.m8649w(c5728b3.mUri));
                                if (C37462a.fAH >= i) {
                                }
                                AppMethodBeat.m2505o(52813);
                                return false;
                            } catch (Throwable th3) {
                                th = th3;
                                bufferedReader = null;
                                C5046bo.m7527b(closeable);
                                C5046bo.m7527b(inputStreamReader);
                                C5046bo.m7527b(bufferedReader);
                                AppMethodBeat.m2505o(52813);
                                throw th;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            bufferedReader = null;
                            inputStreamReader = null;
                            C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", e, e.getMessage(), new Object[0]);
                            C5046bo.m7527b(closeable);
                            C5046bo.m7527b(inputStreamReader);
                            C5046bo.m7527b(bufferedReader);
                            C5730e.m8618N(C5736j.m8649w(c5728b2.mUri), true);
                            C5730e.deleteFile(C5736j.m8649w(c5728b3.mUri));
                            if (C37462a.fAH >= i) {
                            }
                            AppMethodBeat.m2505o(52813);
                            return false;
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedReader = null;
                            inputStreamReader = null;
                            C5046bo.m7527b(closeable);
                            C5046bo.m7527b(inputStreamReader);
                            C5046bo.m7527b(bufferedReader);
                            AppMethodBeat.m2505o(52813);
                            throw th;
                        }
                    }
                    C5730e.m8618N(C5736j.m8649w(c5728b2.mUri), true);
                    C5730e.deleteFile(C5736j.m8649w(c5728b3.mUri));
                    if (C37462a.fAH >= i) {
                        C4990ab.m7417i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", Integer.valueOf(C37462a.fAH), Integer.valueOf(i));
                        C37462a.m63177d(c5728b);
                    } else {
                        C4990ab.m7417i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", Integer.valueOf(C37462a.fAH), Integer.valueOf(i));
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.emoji.EmojiResUpdateListener", "checkResUpdateListener file not exist");
                }
            } else if (c32519bf.cus.cut == 37) {
                C5728b c5728b4;
                if (c32519bf.cus.cuu == 1) {
                    C45852j.bkb();
                    C45852j.m84893a(c32519bf, false);
                } else if (c32519bf.cus.cuu == 2) {
                    C45852j.bkb();
                    C45852j.m84896b(c32519bf, false);
                } else if (c32519bf.cus.cuu == 3) {
                    C45852j.bkb();
                    if (!C45852j.m84894a(c32519bf, C27735a.SUGGEST)) {
                        C4990ab.m7416i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiSuggest need no update.");
                    } else if (C45852j.m84895a(c32519bf, C27735a.SUGGEST, C45852j.kUc)) {
                        c5728b4 = new C5728b(new C5728b(C45852j.getDataEmojiPath(), C45852j.kUc), C45852j.kUn);
                        if (c5728b4.exists()) {
                            C45852j.m84899h(c5728b4);
                        } else {
                            C4990ab.m7416i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiSuggest config don't exist.");
                        }
                    } else {
                        C4990ab.m7416i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiSuggest unzip file failed.");
                    }
                } else if (c32519bf.cus.cuu == 5) {
                    C45852j.bkb();
                    if (C45852j.m84894a(c32519bf, C27735a.EGG)) {
                        if (C45852j.m84895a(c32519bf, C27735a.EGG, C45852j.kUd)) {
                            c5728b4 = new C5728b(new C5728b(C45852j.getDataEmojiPath(), C45852j.kUd), C45852j.kUo);
                            if (c5728b4.exists()) {
                                C45852j.m84900i(c5728b4);
                            } else {
                                C4990ab.m7416i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiEgg unzip file failed.");
                            }
                        } else {
                            C4990ab.m7416i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiEgg unzip file failed.");
                        }
                    }
                } else if (c32519bf.cus.cuu == 4) {
                    C45852j.bkb();
                    C4990ab.m7410d("MicroMsg.emoji.EmojiResUpdateMgr", "updateAppleColorEmoji");
                    if (C45852j.m84897b(c32519bf)) {
                        C37626b.dqD();
                        String str2 = c32519bf.cus.filePath;
                        C37626b.dqE();
                        C5730e.m8644y(str2, C37626b.xFA);
                        C37626b.dqD().init();
                    }
                }
            }
        }
        AppMethodBeat.m2505o(52813);
        return false;
    }
}
