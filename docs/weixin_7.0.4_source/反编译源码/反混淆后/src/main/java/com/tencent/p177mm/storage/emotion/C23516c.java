package com.tencent.p177mm.storage.emotion;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C6398g;
import com.tencent.p177mm.p213cd.C6398g.C1361a;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.storage.emotion.c */
public final class C23516c extends C7563j<C41339b> implements C1361a {
    public static final String[] fnj = new String[]{C7563j.m13217a(C41339b.ccO, "EmojiInfoDesc")};
    public C4927e bSd;
    public SharedPreferences yaX;

    /* renamed from: b */
    public final /* synthetic */ boolean mo10101b(C4925c c4925c) {
        AppMethodBeat.m2504i(62799);
        C41339b c41339b = (C41339b) c4925c;
        if (c41339b != null) {
            boolean z;
            if (c41339b.mo65994Aq().length() == 32) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                c41339b.field_md5_lang = c41339b.field_md5 + c41339b.field_lang;
                long replace = this.bSd.replace("EmojiInfoDesc", "md5_lang", c41339b.mo10098Hl());
                if (replace != -1) {
                    anF(c41339b.mo65994Aq());
                }
                if (replace >= 0) {
                    AppMethodBeat.m2505o(62799);
                    return true;
                }
                AppMethodBeat.m2505o(62799);
                return false;
            }
        }
        AppMethodBeat.m2505o(62799);
        return false;
    }

    static {
        AppMethodBeat.m2504i(62800);
        AppMethodBeat.m2505o(62800);
    }

    public C23516c(C4927e c4927e) {
        this(c4927e, C41339b.ccO, "EmojiInfoDesc");
    }

    private C23516c(C4927e c4927e, C4924a c4924a, String str) {
        super(c4927e, c4924a, str, null);
        AppMethodBeat.m2504i(62794);
        this.bSd = c4927e;
        this.yaX = PreferenceManager.getDefaultSharedPreferences(C4996ah.getContext());
        AppMethodBeat.m2505o(62794);
    }

    /* renamed from: a */
    public final int mo4744a(C6398g c6398g) {
        this.bSd = c6398g;
        return 0;
    }

    /* renamed from: Jh */
    public final String mo39182Jh(String str) {
        AppMethodBeat.m2504i(62795);
        String str2 = null;
        String format = String.format("select %s from %s where %s=?", new Object[]{"desc", "EmojiInfoDesc", "md5_lang"});
        Cursor a = this.bSd.mo10104a(format, new String[]{str + C4988aa.dor().toLowerCase()}, 2);
        if (a.moveToFirst()) {
            str2 = a.getString(a.getColumnIndex("desc"));
        }
        a.close();
        if (C5046bo.isNullOrNil(str2)) {
            Cursor a2 = this.bSd.mo10104a(format, new String[]{str + "default"}, 2);
            if (a2.moveToFirst()) {
                str2 = a2.getString(a2.getColumnIndex("desc"));
            }
            a2.close();
            AppMethodBeat.m2505o(62795);
        } else {
            AppMethodBeat.m2505o(62795);
        }
        return str2;
    }

    public final boolean aqf(String str) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.m2504i(62796);
        Cursor cursor = null;
        try {
            cursor = this.bSd.mo10104a(String.format("select %s from %s where %s=?", new Object[]{"click_flag", "EmojiInfoDesc", "groupId"}), new String[]{str}, 2);
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
            C4990ab.m7421w("MicroMsg.emoji.EmojiInfoDescStorage", "[isPurChase] Exception:%s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(62796);
        }
        AppMethodBeat.m2505o(62796);
        return z2;
    }

    public final boolean aqg(String str) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.m2504i(62797);
        Cursor cursor = null;
        try {
            cursor = this.bSd.mo10104a(String.format("select %s from %s where %s=?", new Object[]{"download_flag", "EmojiInfoDesc", "groupId"}), new String[]{str}, 2);
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
            C4990ab.m7421w("MicroMsg.emoji.EmojiInfoDescStorage", "[isPurChase] Exception:%s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(62797);
        }
        AppMethodBeat.m2505o(62797);
        return z2;
    }

    public final boolean aqh(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(62798);
        if (C2933b.m5219JX(str)) {
            Cursor cursor = null;
            try {
                cursor = this.bSd.mo10104a(String.format("select %s from %s where %s=?", new Object[]{"desc", "EmojiInfoDesc", "groupId"}), new String[]{str}, 2);
                if (cursor != null && cursor.moveToFirst()) {
                    z = true;
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.emoji.EmojiInfoDescStorage", e.toString());
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.m2505o(62798);
            }
        }
        AppMethodBeat.m2505o(62798);
        return z;
    }
}
