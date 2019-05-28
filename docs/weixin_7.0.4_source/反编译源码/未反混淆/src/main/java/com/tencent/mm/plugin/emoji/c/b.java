package com.tencent.mm.plugin.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.a;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import org.json.JSONObject;

public final class b extends c<bf> {
    public b() {
        AppMethodBeat.i(52812);
        this.xxI = bf.class.getName().hashCode();
        AppMethodBeat.o(52812);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(bf bfVar) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(52813);
        if (bfVar instanceof bf) {
            if (bfVar.cus.cut == 33) {
                com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(bfVar.cus.filePath);
                if (bVar.exists()) {
                    ab.i("MicroMsg.emoji.EmojiResUpdateListener", "checkResUpdateListener callback to update %s", bVar.dME());
                    com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(a.afU(), "temp");
                    com.tencent.mm.vfs.b bVar3 = new com.tencent.mm.vfs.b(bVar2, "emoji_template.zip");
                    bVar2.mkdirs();
                    e.y(j.w(bVar.dMD()), j.w(bVar3.dMD()));
                    int i = 1;
                    if (e.iu(j.w(bVar3.dMD()), j.w(bVar2.dMD())) >= 0) {
                        Closeable closeable = null;
                        Closeable inputStreamReader;
                        Closeable bufferedReader;
                        try {
                            closeable = e.p(new com.tencent.mm.vfs.b(bVar2, "config.conf"));
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
                                    ab.d("MicroMsg.emoji.EmojiResUpdateListener", "config file content:%s version:%d", str, Integer.valueOf(i));
                                    bo.b(closeable);
                                    bo.b(inputStreamReader);
                                    bo.b(bufferedReader);
                                } catch (Exception e2) {
                                    e = e2;
                                    try {
                                        ab.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", e, e.getMessage(), new Object[0]);
                                        bo.b(closeable);
                                        bo.b(inputStreamReader);
                                        bo.b(bufferedReader);
                                        e.N(j.w(bVar2.mUri), true);
                                        e.deleteFile(j.w(bVar3.mUri));
                                        if (a.fAH >= i) {
                                        }
                                        AppMethodBeat.o(52813);
                                        return false;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        bo.b(closeable);
                                        bo.b(inputStreamReader);
                                        bo.b(bufferedReader);
                                        AppMethodBeat.o(52813);
                                        throw th;
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                bufferedReader = null;
                                ab.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", e, e.getMessage(), new Object[0]);
                                bo.b(closeable);
                                bo.b(inputStreamReader);
                                bo.b(bufferedReader);
                                e.N(j.w(bVar2.mUri), true);
                                e.deleteFile(j.w(bVar3.mUri));
                                if (a.fAH >= i) {
                                }
                                AppMethodBeat.o(52813);
                                return false;
                            } catch (Throwable th3) {
                                th = th3;
                                bufferedReader = null;
                                bo.b(closeable);
                                bo.b(inputStreamReader);
                                bo.b(bufferedReader);
                                AppMethodBeat.o(52813);
                                throw th;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            bufferedReader = null;
                            inputStreamReader = null;
                            ab.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", e, e.getMessage(), new Object[0]);
                            bo.b(closeable);
                            bo.b(inputStreamReader);
                            bo.b(bufferedReader);
                            e.N(j.w(bVar2.mUri), true);
                            e.deleteFile(j.w(bVar3.mUri));
                            if (a.fAH >= i) {
                            }
                            AppMethodBeat.o(52813);
                            return false;
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedReader = null;
                            inputStreamReader = null;
                            bo.b(closeable);
                            bo.b(inputStreamReader);
                            bo.b(bufferedReader);
                            AppMethodBeat.o(52813);
                            throw th;
                        }
                    }
                    e.N(j.w(bVar2.mUri), true);
                    e.deleteFile(j.w(bVar3.mUri));
                    if (a.fAH >= i) {
                        ab.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", Integer.valueOf(a.fAH), Integer.valueOf(i));
                        a.d(bVar);
                    } else {
                        ab.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", Integer.valueOf(a.fAH), Integer.valueOf(i));
                    }
                } else {
                    ab.e("MicroMsg.emoji.EmojiResUpdateListener", "checkResUpdateListener file not exist");
                }
            } else if (bfVar.cus.cut == 37) {
                com.tencent.mm.vfs.b bVar4;
                if (bfVar.cus.cuu == 1) {
                    com.tencent.mm.plugin.emoji.e.j.bkb();
                    com.tencent.mm.plugin.emoji.e.j.a(bfVar, false);
                } else if (bfVar.cus.cuu == 2) {
                    com.tencent.mm.plugin.emoji.e.j.bkb();
                    com.tencent.mm.plugin.emoji.e.j.b(bfVar, false);
                } else if (bfVar.cus.cuu == 3) {
                    com.tencent.mm.plugin.emoji.e.j.bkb();
                    if (!com.tencent.mm.plugin.emoji.e.j.a(bfVar, com.tencent.mm.plugin.emoji.e.j.a.SUGGEST)) {
                        ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiSuggest need no update.");
                    } else if (com.tencent.mm.plugin.emoji.e.j.a(bfVar, com.tencent.mm.plugin.emoji.e.j.a.SUGGEST, com.tencent.mm.plugin.emoji.e.j.kUc)) {
                        bVar4 = new com.tencent.mm.vfs.b(new com.tencent.mm.vfs.b(com.tencent.mm.plugin.emoji.e.j.getDataEmojiPath(), com.tencent.mm.plugin.emoji.e.j.kUc), com.tencent.mm.plugin.emoji.e.j.kUn);
                        if (bVar4.exists()) {
                            com.tencent.mm.plugin.emoji.e.j.h(bVar4);
                        } else {
                            ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiSuggest config don't exist.");
                        }
                    } else {
                        ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiSuggest unzip file failed.");
                    }
                } else if (bfVar.cus.cuu == 5) {
                    com.tencent.mm.plugin.emoji.e.j.bkb();
                    if (com.tencent.mm.plugin.emoji.e.j.a(bfVar, com.tencent.mm.plugin.emoji.e.j.a.EGG)) {
                        if (com.tencent.mm.plugin.emoji.e.j.a(bfVar, com.tencent.mm.plugin.emoji.e.j.a.EGG, com.tencent.mm.plugin.emoji.e.j.kUd)) {
                            bVar4 = new com.tencent.mm.vfs.b(new com.tencent.mm.vfs.b(com.tencent.mm.plugin.emoji.e.j.getDataEmojiPath(), com.tencent.mm.plugin.emoji.e.j.kUd), com.tencent.mm.plugin.emoji.e.j.kUo);
                            if (bVar4.exists()) {
                                com.tencent.mm.plugin.emoji.e.j.i(bVar4);
                            } else {
                                ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiEgg unzip file failed.");
                            }
                        } else {
                            ab.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiEgg unzip file failed.");
                        }
                    }
                } else if (bfVar.cus.cuu == 4) {
                    com.tencent.mm.plugin.emoji.e.j.bkb();
                    ab.d("MicroMsg.emoji.EmojiResUpdateMgr", "updateAppleColorEmoji");
                    if (com.tencent.mm.plugin.emoji.e.j.b(bfVar)) {
                        com.tencent.mm.cb.b.dqD();
                        String str2 = bfVar.cus.filePath;
                        com.tencent.mm.cb.b.dqE();
                        e.y(str2, com.tencent.mm.cb.b.xFA);
                        com.tencent.mm.cb.b.dqD().init();
                    }
                }
            }
        }
        AppMethodBeat.o(52813);
        return false;
    }
}
