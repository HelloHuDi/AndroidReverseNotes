package com.tencent.p177mm.plugin.emojicapture.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.emojicapture.model.p950a.C45865e;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import p000a.C0220l;
import p000a.p001a.C36913i;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J/\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\fJ\u001d\u0010\r\u001a\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\nH\u0002¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "TAG", "", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "stickerCommand", "([Ljava/lang/String;)Z", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.model.b */
public final class C2961b implements C44041a {
    private final String TAG = "MicroMsg.EmojiCaptureCommand";

    /* renamed from: a */
    public final boolean mo7165a(Context context, String[] strArr, String str) {
        AppMethodBeat.m2504i(2575);
        C25052j.m39376p(strArr, "args");
        C25052j.m39376p(str, "username");
        C4990ab.m7416i(this.TAG, "processCommand: " + C36913i.m61690a((Object[]) strArr, (CharSequence) " ", null, null, 0, null, null, 62));
        if (strArr.length <= 1) {
            AppMethodBeat.m2505o(2575);
            return false;
        }
        String str2 = strArr[1];
        switch (str2.hashCode()) {
            case -1890252483:
                if (str2.equals("sticker") && strArr.length > 2) {
                    str2 = strArr[2];
                    C45865e c45865e;
                    switch (str2.hashCode()) {
                        case -1408207997:
                            if (str2.equals("assets")) {
                                c45865e = C45865e.lii;
                                C5730e.m8629cu(C45865e.bnz());
                                c45865e = C45865e.lii;
                                C45865e.bnC();
                                break;
                            }
                            break;
                        case 94746185:
                            if (str2.equals("clean")) {
                                c45865e = C45865e.lii;
                                C5730e.m8629cu(C45865e.bnz());
                                break;
                            }
                            break;
                    }
                    AppMethodBeat.m2505o(2575);
                    return true;
                }
        }
        AppMethodBeat.m2505o(2575);
        return false;
    }
}
