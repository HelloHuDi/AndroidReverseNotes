package com.tencent.p177mm.plugin.emoji;

import android.content.Context;
import android.content.IntentFilter;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C17918t;
import com.tencent.p177mm.api.C41757u;
import com.tencent.p177mm.api.C41757u.C17919a;
import com.tencent.p177mm.api.SmileyPanel;
import com.tencent.p177mm.emoji.sync.EmojiUpdateReceiver;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.kernel.p242c.C6625e;
import com.tencent.p177mm.p207by.C45274a;
import com.tencent.p177mm.p211cb.C26005f;
import com.tencent.p177mm.p211cb.C37626b;
import com.tencent.p177mm.p211cb.C9212g;
import com.tencent.p177mm.p612ui.p627e.p1346b.C24002c;
import com.tencent.p177mm.p612ui.p627e.p1346b.C44371a;
import com.tencent.p177mm.p612ui.p627e.p1346b.C44372b;
import com.tencent.p177mm.p612ui.p627e.p628c.C5508a;
import com.tencent.p177mm.p612ui.p627e.p628c.C5509b;
import com.tencent.p177mm.plugin.comm.p1247a.C27697a;
import com.tencent.p177mm.plugin.emoji.p725b.C20355b.C20356a;
import com.tencent.p177mm.plugin.emoji.p725b.C27730c;
import com.tencent.p177mm.plugin.emoji.p725b.C45845a;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.gif.C12215c;
import com.tencent.p177mm.plugin.gif.C34323b;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pluginsdk.p1336a.C44039e;
import com.tencent.p177mm.pluginsdk.p1336a.C44795d;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C24943k;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23303d.C23304a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C23505at;
import com.tencent.p177mm.storage.C44219aq;
import com.tencent.p177mm.storage.emotion.SmileyInfo;
import com.tencent.p177mm.view.C5740c;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.emoji.PluginEmoji */
public class PluginEmoji extends C7597f implements C6835d {
    private C44795d kRs;
    C44039e kRt;

    /* renamed from: com.tencent.mm.plugin.emoji.PluginEmoji$2 */
    class C203512 implements C5508a {
        C203512() {
        }

        /* renamed from: h */
        public final CharSequence mo11123h(CharSequence charSequence, int i) {
            AppMethodBeat.m2504i(62319);
            SpannableString o = C9212g.dqQ().mo20623o(charSequence, i);
            AppMethodBeat.m2505o(62319);
            return o;
        }

        /* renamed from: c */
        public final CharSequence mo11122c(Context context, CharSequence charSequence, float f) {
            AppMethodBeat.m2504i(62320);
            SpannableString b = C9212g.dqQ().mo20622b(charSequence, f);
            AppMethodBeat.m2505o(62320);
            return b;
        }

        /* renamed from: bV */
        public final int mo11121bV(String str, int i) {
            AppMethodBeat.m2504i(62321);
            C9212g.dqQ();
            C26005f dqL = C26005f.dqL();
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(62321);
                return i;
            }
            int length = str.length();
            if (i == 0 || i == length) {
                AppMethodBeat.m2505o(62321);
                return i;
            }
            int i2;
            if (C26005f.xGo == null) {
                StringBuilder stringBuilder = new StringBuilder();
                int length2 = dqL.xGe.length;
                for (i2 = 0; i2 < length2; i2++) {
                    stringBuilder.append(Pattern.quote(dqL.xGe[i2]));
                    if (i2 != length2 - 1) {
                        stringBuilder.append('|');
                    }
                }
                length2 = dqL.xGf.length;
                for (i2 = 0; i2 < length2; i2++) {
                    stringBuilder.append(Pattern.quote(dqL.xGf[i2]));
                    if (i2 != length2 - 1) {
                        stringBuilder.append('|');
                    }
                }
                length2 = dqL.xGg.length;
                for (i2 = 0; i2 < length2; i2++) {
                    stringBuilder.append(Pattern.quote(dqL.xGg[i2]));
                    if (i2 != length2 - 1) {
                        stringBuilder.append('|');
                    }
                }
                length2 = dqL.xGh.length;
                for (i2 = 0; i2 < length2; i2++) {
                    stringBuilder.append(Pattern.quote(dqL.xGh[i2]));
                    if (i2 != length2 - 1) {
                        stringBuilder.append('|');
                    }
                }
                length2 = dqL.xGi.length;
                for (i2 = 0; i2 < length2; i2++) {
                    stringBuilder.append(Pattern.quote(dqL.xGi[i2]));
                    if (i2 != length2 - 1) {
                        stringBuilder.append('|');
                    }
                }
                length2 = dqL.xGj.length;
                for (i2 = 0; i2 < length2; i2++) {
                    stringBuilder.append(Pattern.quote(dqL.xGj[i2]));
                    if (i2 != length2 - 1) {
                        stringBuilder.append('|');
                    }
                }
                if (!(dqL.xGk == null || dqL.xGk.isEmpty())) {
                    Iterator it = dqL.xGk.iterator();
                    while (it.hasNext()) {
                        SmileyInfo smileyInfo = (SmileyInfo) it.next();
                        stringBuilder.append(Pattern.quote(smileyInfo.field_key)).append("|");
                        if (!C5046bo.isNullOrNil(smileyInfo.field_cnValue)) {
                            stringBuilder.append(Pattern.quote(smileyInfo.field_cnValue)).append("|");
                        }
                        if (!C5046bo.isNullOrNil(smileyInfo.field_enValue)) {
                            stringBuilder.append(Pattern.quote(smileyInfo.field_enValue)).append("|");
                        }
                        if (!C5046bo.isNullOrNil(smileyInfo.field_qqValue)) {
                            stringBuilder.append(Pattern.quote(smileyInfo.field_qqValue)).append("|");
                        }
                        if (!C5046bo.isNullOrNil(smileyInfo.field_twValue)) {
                            stringBuilder.append(Pattern.quote(smileyInfo.field_twValue)).append("|");
                        }
                        if (!C5046bo.isNullOrNil(smileyInfo.field_thValue)) {
                            stringBuilder.append(Pattern.quote(smileyInfo.field_thValue)).append("|");
                        }
                    }
                }
                C26005f.xGo = Pattern.compile(stringBuilder.toString());
            }
            Matcher matcher = C26005f.xGo.matcher(str.substring(i < 6 ? 0 : i - 6, i + 6 >= length ? length - 1 : i + 6));
            while (matcher.find()) {
                if (6 > matcher.start() && 6 < matcher.end()) {
                    i2 = matcher.start();
                    break;
                }
            }
            i2 = 6;
            i += i2 + -6 > 0 ? i2 - 6 : 0;
            AppMethodBeat.m2505o(62321);
            return i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.PluginEmoji$3 */
    class C203523 implements C17919a {
        C203523() {
        }

        /* renamed from: aS */
        public final SmileyPanel mo33433aS(Context context) {
            AppMethodBeat.m2504i(62322);
            SmileyPanel j = mo33434j(context, false);
            AppMethodBeat.m2505o(62322);
            return j;
        }

        /* renamed from: j */
        public final SmileyPanel mo33434j(Context context, boolean z) {
            AppMethodBeat.m2504i(62323);
            C5740c c5740c = new C5740c(context, z);
            AppMethodBeat.m2505o(62323);
            return c5740c;
        }

        /* renamed from: AI */
        public final C17918t mo33432AI() {
            AppMethodBeat.m2504i(62324);
            C24943k c24943k = new C24943k();
            AppMethodBeat.m2505o(62324);
            return c24943k;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.PluginEmoji$1 */
    class C203531 implements C44372b {
        C203531() {
        }

        /* renamed from: dG */
        public final C44371a mo35587dG(String str, String str2) {
            AppMethodBeat.m2504i(62318);
            try {
                C34323b eD = C12215c.bFN().mo24060eD(str, str2);
                AppMethodBeat.m2505o(62318);
                return eD;
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.PluginEmoji", e, "", new Object[0]);
                AppMethodBeat.m2505o(62318);
                return null;
            }
        }
    }

    public String name() {
        return "plugin-emoji";
    }

    public void installed() {
        AppMethodBeat.m2504i(62325);
        alias(C6835d.class);
        AppMethodBeat.m2505o(62325);
    }

    public void dependency() {
        AppMethodBeat.m2504i(62326);
        dependsOn(C27697a.class);
        AppMethodBeat.m2505o(62326);
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(62327);
        C23304a.m35788a(C9212g.dqQ());
        C37626b.dqD();
        C14835h.dhT();
        C1720g.m3542a(C27730c.class, C45846d.biX());
        AppMethodBeat.m2505o(62327);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(62328);
        if (c1681g.mo5181SG()) {
            pin(C20371e.bjc());
            if (c1681g.mo5181SG()) {
                C1720g.m3543a(C45845a.class, new C6625e(new C42934a()));
            }
        } else if (c1681g.mo5183lQ(":tools")) {
            C4996ah.getContext().registerReceiver(new EmojiUpdateReceiver(), new IntentFilter(EmojiUpdateReceiver.ACTION));
        }
        C24002c.m36987a(new C203531());
        C5509b.m8293a(new C203512());
        C41757u.cda = new C203523();
        AppMethodBeat.m2505o(62328);
    }

    public void setEmojiMgr() {
        AppMethodBeat.m2504i(62329);
        if (this.kRs == null) {
            this.kRs = C20356a.kTl.getEmojiMgr();
        }
        AppMethodBeat.m2505o(62329);
    }

    public void removeEmojiMgr() {
        this.kRs = null;
    }

    public C44795d getEmojiMgr() {
        AppMethodBeat.m2504i(62330);
        setEmojiMgr();
        C44795d c44795d = this.kRs;
        AppMethodBeat.m2505o(62330);
        return c44795d;
    }

    public C44039e getProvider() {
        AppMethodBeat.m2504i(62331);
        if (this.kRt == null) {
            this.kRt = new C45274a();
        }
        C44039e c44039e = this.kRt;
        AppMethodBeat.m2505o(62331);
        return c44039e;
    }

    public C23505at getEmojiStorageMgr() {
        AppMethodBeat.m2504i(62332);
        C23505at emojiStorageMgr = C20356a.kTl.getEmojiStorageMgr();
        AppMethodBeat.m2505o(62332);
        return emojiStorageMgr;
    }

    public C44219aq getEmojiDescMgr() {
        AppMethodBeat.m2504i(62333);
        C44219aq emojiDescMgr = C20356a.kTl.getEmojiDescMgr();
        AppMethodBeat.m2505o(62333);
        return emojiDescMgr;
    }
}
