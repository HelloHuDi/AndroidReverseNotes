package com.tencent.mm.plugin.emoji;

import android.content.Context;
import android.content.IntentFilter;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.t;
import com.tencent.mm.api.u;
import com.tencent.mm.cb.b;
import com.tencent.mm.emoji.sync.EmojiUpdateReceiver;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.chat.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.SmileyInfo;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PluginEmoji extends f implements d {
    private com.tencent.mm.pluginsdk.a.d kRs;
    e kRt;

    public String name() {
        return "plugin-emoji";
    }

    public void installed() {
        AppMethodBeat.i(62325);
        alias(d.class);
        AppMethodBeat.o(62325);
    }

    public void dependency() {
        AppMethodBeat.i(62326);
        dependsOn(a.class);
        AppMethodBeat.o(62326);
    }

    public void configure(g gVar) {
        AppMethodBeat.i(62327);
        com.tencent.mm.pluginsdk.ui.e.d.a.a(com.tencent.mm.cb.g.dqQ());
        b.dqD();
        h.dhT();
        com.tencent.mm.kernel.g.a(c.class, d.biX());
        AppMethodBeat.o(62327);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(62328);
        if (gVar.SG()) {
            pin(e.bjc());
            if (gVar.SG()) {
                com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.emoji.b.a.class, new com.tencent.mm.kernel.c.e(new a()));
            }
        } else if (gVar.lQ(":tools")) {
            ah.getContext().registerReceiver(new EmojiUpdateReceiver(), new IntentFilter(EmojiUpdateReceiver.ACTION));
        }
        com.tencent.mm.ui.e.b.c.a(new com.tencent.mm.ui.e.b.b() {
            public final com.tencent.mm.ui.e.b.a dG(String str, String str2) {
                AppMethodBeat.i(62318);
                try {
                    com.tencent.mm.plugin.gif.b eD = com.tencent.mm.plugin.gif.c.bFN().eD(str, str2);
                    AppMethodBeat.o(62318);
                    return eD;
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.PluginEmoji", e, "", new Object[0]);
                    AppMethodBeat.o(62318);
                    return null;
                }
            }
        });
        com.tencent.mm.ui.e.c.b.a(new com.tencent.mm.ui.e.c.a() {
            public final CharSequence h(CharSequence charSequence, int i) {
                AppMethodBeat.i(62319);
                SpannableString o = com.tencent.mm.cb.g.dqQ().o(charSequence, i);
                AppMethodBeat.o(62319);
                return o;
            }

            public final CharSequence c(Context context, CharSequence charSequence, float f) {
                AppMethodBeat.i(62320);
                SpannableString b = com.tencent.mm.cb.g.dqQ().b(charSequence, f);
                AppMethodBeat.o(62320);
                return b;
            }

            public final int bV(String str, int i) {
                AppMethodBeat.i(62321);
                com.tencent.mm.cb.g.dqQ();
                com.tencent.mm.cb.f dqL = com.tencent.mm.cb.f.dqL();
                if (bo.isNullOrNil(str)) {
                    AppMethodBeat.o(62321);
                    return i;
                }
                int length = str.length();
                if (i == 0 || i == length) {
                    AppMethodBeat.o(62321);
                    return i;
                }
                int i2;
                if (com.tencent.mm.cb.f.xGo == null) {
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
                            if (!bo.isNullOrNil(smileyInfo.field_cnValue)) {
                                stringBuilder.append(Pattern.quote(smileyInfo.field_cnValue)).append("|");
                            }
                            if (!bo.isNullOrNil(smileyInfo.field_enValue)) {
                                stringBuilder.append(Pattern.quote(smileyInfo.field_enValue)).append("|");
                            }
                            if (!bo.isNullOrNil(smileyInfo.field_qqValue)) {
                                stringBuilder.append(Pattern.quote(smileyInfo.field_qqValue)).append("|");
                            }
                            if (!bo.isNullOrNil(smileyInfo.field_twValue)) {
                                stringBuilder.append(Pattern.quote(smileyInfo.field_twValue)).append("|");
                            }
                            if (!bo.isNullOrNil(smileyInfo.field_thValue)) {
                                stringBuilder.append(Pattern.quote(smileyInfo.field_thValue)).append("|");
                            }
                        }
                    }
                    com.tencent.mm.cb.f.xGo = Pattern.compile(stringBuilder.toString());
                }
                Matcher matcher = com.tencent.mm.cb.f.xGo.matcher(str.substring(i < 6 ? 0 : i - 6, i + 6 >= length ? length - 1 : i + 6));
                while (matcher.find()) {
                    if (6 > matcher.start() && 6 < matcher.end()) {
                        i2 = matcher.start();
                        break;
                    }
                }
                i2 = 6;
                i += i2 + -6 > 0 ? i2 - 6 : 0;
                AppMethodBeat.o(62321);
                return i;
            }
        });
        u.cda = new u.a() {
            public final SmileyPanel aS(Context context) {
                AppMethodBeat.i(62322);
                SmileyPanel j = j(context, false);
                AppMethodBeat.o(62322);
                return j;
            }

            public final SmileyPanel j(Context context, boolean z) {
                AppMethodBeat.i(62323);
                com.tencent.mm.view.c cVar = new com.tencent.mm.view.c(context, z);
                AppMethodBeat.o(62323);
                return cVar;
            }

            public final t AI() {
                AppMethodBeat.i(62324);
                k kVar = new k();
                AppMethodBeat.o(62324);
                return kVar;
            }
        };
        AppMethodBeat.o(62328);
    }

    public void setEmojiMgr() {
        AppMethodBeat.i(62329);
        if (this.kRs == null) {
            this.kRs = com.tencent.mm.plugin.emoji.b.b.a.kTl.getEmojiMgr();
        }
        AppMethodBeat.o(62329);
    }

    public void removeEmojiMgr() {
        this.kRs = null;
    }

    public com.tencent.mm.pluginsdk.a.d getEmojiMgr() {
        AppMethodBeat.i(62330);
        setEmojiMgr();
        com.tencent.mm.pluginsdk.a.d dVar = this.kRs;
        AppMethodBeat.o(62330);
        return dVar;
    }

    public e getProvider() {
        AppMethodBeat.i(62331);
        if (this.kRt == null) {
            this.kRt = new com.tencent.mm.by.a();
        }
        e eVar = this.kRt;
        AppMethodBeat.o(62331);
        return eVar;
    }

    public at getEmojiStorageMgr() {
        AppMethodBeat.i(62332);
        at emojiStorageMgr = com.tencent.mm.plugin.emoji.b.b.a.kTl.getEmojiStorageMgr();
        AppMethodBeat.o(62332);
        return emojiStorageMgr;
    }

    public aq getEmojiDescMgr() {
        AppMethodBeat.i(62333);
        aq emojiDescMgr = com.tencent.mm.plugin.emoji.b.b.a.kTl.getEmojiDescMgr();
        AppMethodBeat.o(62333);
        return emojiDescMgr;
    }
}
