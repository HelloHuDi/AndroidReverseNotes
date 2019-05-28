package com.tencent.p177mm.plugin.emojicapture.model.p950a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C32519bf;
import com.tencent.p177mm.plugin.emojicapture.model.p1254c.C20433d;
import com.tencent.p177mm.plugin.emojicapture.model.p1254c.C38918b;
import com.tencent.p177mm.plugin.emojicapture.model.p1254c.C45869a;
import com.tencent.p177mm.plugin.emojicapture.model.p1254c.C45869a.C20432a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\b\u0010\u0013\u001a\u00020\rH\u0002J\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerResListener;", "", "()V", "RES_TYPE", "", "TAG", "", "fileUpdateListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "getFileUpdateListener", "()Lcom/tencent/mm/sdk/event/IListener;", "broadcastResult", "", "subType", "result", "", "checkResUpdate", "version", "compareWithLocal", "destroy", "init", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.model.a.g */
public final class C11613g {
    public static final String TAG = TAG;
    private static final C4884c<C32519bf> lij = new C11614a();
    public static final C11613g lik = new C11613g();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerResListener$fileUpdateListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "callback", "", "event", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.a.g$a */
    public static final class C11614a extends C4884c<C32519bf> {
        C11614a() {
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(2652);
            C32519bf c32519bf = (C32519bf) c4883b;
            C25052j.m39376p(c32519bf, "event");
            C11613g c11613g = C11613g.lik;
            C4990ab.m7416i(C11613g.TAG, "fileUpdateListener: type: " + c32519bf.cus.cut + ", " + c32519bf.cus.cuu + ' ' + "filepath: " + c32519bf.cus.filePath);
            if (c32519bf.cus.cut == 59) {
                String str = c32519bf.cus.filePath;
                C45865e c45865e = C45865e.lii;
                C5046bo.m7570hU(str, C45865e.bnA());
                if (c32519bf.cus.cuu == 0) {
                    c11613g = C11613g.lik;
                    C11613g.bnE();
                }
                c11613g = C11613g.lik;
                C11613g.m19434uz(c32519bf.cus.cuu);
                AppMethodBeat.m2505o(2652);
                return true;
            }
            AppMethodBeat.m2505o(2652);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(2656);
        AppMethodBeat.m2505o(2656);
    }

    private C11613g() {
    }

    /* renamed from: uz */
    public static final /* synthetic */ void m19434uz(int i) {
        AppMethodBeat.m2504i(2658);
        C11613g.m19433uy(i);
        AppMethodBeat.m2505o(2658);
    }

    public static void init() {
        AppMethodBeat.m2504i(2653);
        lij.dnU();
        AppMethodBeat.m2505o(2653);
    }

    public static void destroy() {
        AppMethodBeat.m2504i(2654);
        lij.dead();
        AppMethodBeat.m2505o(2654);
    }

    /* renamed from: uy */
    public static void m19433uy(int i) {
        AppMethodBeat.m2504i(2655);
        C4990ab.m7416i(TAG, "broadcastResult: " + i + ", true");
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.Emoji_Capture_Res");
        intent.putExtra("res_sub_type", i);
        intent.putExtra("res_result", true);
        C4996ah.getContext().sendBroadcast(intent);
        AppMethodBeat.m2505o(2655);
    }

    public static final /* synthetic */ void bnE() {
        AppMethodBeat.m2504i(2657);
        C38918b c38918b = new C38918b();
        C20432a c20432a = C45869a.ljn;
        C45865e c45865e = C45865e.lii;
        C20432a.m31586a(C45865e.bnB(), c38918b);
        Iterable iterable = c38918b.ewZ;
        Collection arrayList = new ArrayList();
        for (Object next : iterable) {
            if ((!C38908d.m66044a((C20433d) next) ? 1 : null) != null) {
                arrayList.add(next);
            }
        }
        for (C20433d c20433d : (List) arrayList) {
            C4990ab.m7416i(TAG, "compareWithLocal: invalid " + c20433d.ljp);
        }
        AppMethodBeat.m2505o(2657);
    }
}
