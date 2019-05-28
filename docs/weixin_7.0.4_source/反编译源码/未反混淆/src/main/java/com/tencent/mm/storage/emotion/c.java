package com.tencent.mm.storage.emotion;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.cd.g.a;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class c extends j<b> implements a {
    public static final String[] fnj = new String[]{j.a(b.ccO, "EmojiInfoDesc")};
    public e bSd;
    public SharedPreferences yaX;

    public final /* synthetic */ boolean b(com.tencent.mm.sdk.e.c cVar) {
        AppMethodBeat.i(62799);
        b bVar = (b) cVar;
        if (bVar != null) {
            boolean z;
            if (bVar.Aq().length() == 32) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                bVar.field_md5_lang = bVar.field_md5 + bVar.field_lang;
                long replace = this.bSd.replace("EmojiInfoDesc", "md5_lang", bVar.Hl());
                if (replace != -1) {
                    anF(bVar.Aq());
                }
                if (replace >= 0) {
                    AppMethodBeat.o(62799);
                    return true;
                }
                AppMethodBeat.o(62799);
                return false;
            }
        }
        AppMethodBeat.o(62799);
        return false;
    }

    static {
        AppMethodBeat.i(62800);
        AppMethodBeat.o(62800);
    }

    public c(e eVar) {
        this(eVar, b.ccO, "EmojiInfoDesc");
    }

    private c(e eVar, com.tencent.mm.sdk.e.c.a aVar, String str) {
        super(eVar, aVar, str, null);
        AppMethodBeat.i(62794);
        this.bSd = eVar;
        this.yaX = PreferenceManager.getDefaultSharedPreferences(ah.getContext());
        AppMethodBeat.o(62794);
    }

    public final int a(g gVar) {
        this.bSd = gVar;
        return 0;
    }

    public final String Jh(String str) {
        AppMethodBeat.i(62795);
        String str2 = null;
        String format = String.format("select %s from %s where %s=?", new Object[]{"desc", "EmojiInfoDesc", "md5_lang"});
        Cursor a = this.bSd.a(format, new String[]{str + aa.dor().toLowerCase()}, 2);
        if (a.moveToFirst()) {
            str2 = a.getString(a.getColumnIndex("desc"));
        }
        a.close();
        if (bo.isNullOrNil(str2)) {
            Cursor a2 = this.bSd.a(format, new String[]{str + "default"}, 2);
            if (a2.moveToFirst()) {
                str2 = a2.getString(a2.getColumnIndex("desc"));
            }
            a2.close();
            AppMethodBeat.o(62795);
        } else {
            AppMethodBeat.o(62795);
        }
        return str2;
    }

    public final boolean aqf(String str) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(62796);
        Cursor cursor = null;
        try {
            cursor = this.bSd.a(String.format("select %s from %s where %s=?", new Object[]{"click_flag", "EmojiInfoDesc", "groupId"}), new String[]{str}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                if ((cursor.getInt(cursor.getColumnIndex("click_flag")) & 1) != 1) {
                    z = false;
                }
                z2 = z;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            ab.w("MicroMsg.emoji.EmojiInfoDescStorage", "[isPurChase] Exception:%s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62796);
        }
        AppMethodBeat.o(62796);
        return z2;
    }

    public final boolean aqg(String str) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(62797);
        Cursor cursor = null;
        try {
            cursor = this.bSd.a(String.format("select %s from %s where %s=?", new Object[]{"download_flag", "EmojiInfoDesc", "groupId"}), new String[]{str}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                if ((cursor.getInt(cursor.getColumnIndex("download_flag")) & 1) != 1) {
                    z = false;
                }
                z2 = z;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            ab.w("MicroMsg.emoji.EmojiInfoDescStorage", "[isPurChase] Exception:%s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(62797);
        }
        AppMethodBeat.o(62797);
        return z2;
    }

    public final boolean aqh(String str) {
        boolean z = false;
        AppMethodBeat.i(62798);
        if (b.JX(str)) {
            Cursor cursor = null;
            try {
                cursor = this.bSd.a(String.format("select %s from %s where %s=?", new Object[]{"desc", "EmojiInfoDesc", "groupId"}), new String[]{str}, 2);
                if (cursor != null && cursor.moveToFirst()) {
                    z = true;
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {
                ab.w("MicroMsg.emoji.EmojiInfoDescStorage", e.toString());
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(62798);
            }
        }
        AppMethodBeat.o(62798);
        return z;
    }
}
