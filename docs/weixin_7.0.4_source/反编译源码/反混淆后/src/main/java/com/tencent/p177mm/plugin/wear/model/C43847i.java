package com.tencent.p177mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.p183ai.C17891h;
import com.tencent.p177mm.p183ai.C17891h.C17889a;
import com.tencent.p177mm.p183ai.C17891h.C17892b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C7620bi;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.wear.model.i */
public final class C43847i {
    private C17889a czi = new C438461();
    private C17892b czj = new C438482();
    AudioManager eoY = ((AudioManager) C4996ah.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE));
    C14416a tYl;
    BroadcastReceiver tYm = new C144153();

    /* renamed from: com.tencent.mm.plugin.wear.model.i$3 */
    class C144153 extends BroadcastReceiver {
        C144153() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(26348);
            if (intent.hasExtra("state") && intent.getIntExtra("state", 2) == 0) {
                C43847i.this.cUu();
            }
            AppMethodBeat.m2505o(26348);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.i$a */
    class C14416a {
        C17891h mfO;
        LinkedList<C7620bi> tYo;
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.i$1 */
    class C438461 implements C17889a {
        C438461() {
        }

        /* renamed from: EA */
        public final void mo17611EA() {
            AppMethodBeat.m2504i(26346);
            C43847i.this.tYl.mfO.mo33400a(null);
            C43847i.this.tYl.mfO.mo33399a(null);
            C43847i.this.mo69530b(C43847i.this.tYl);
            AppMethodBeat.m2505o(26346);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.i$2 */
    class C438482 implements C17892b {
        C438482() {
        }

        public final void onError() {
            AppMethodBeat.m2504i(26347);
            C43847i.this.tYl.mfO.mo33400a(null);
            C43847i.this.tYl.mfO.mo33399a(null);
            C43847i.this.mo69530b(C43847i.this.tYl);
            AppMethodBeat.m2505o(26347);
        }
    }

    public C43847i() {
        AppMethodBeat.m2504i(26349);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        C4996ah.getContext().registerReceiver(this.tYm, intentFilter);
        AppMethodBeat.m2505o(26349);
    }

    public final void cUu() {
        AppMethodBeat.m2504i(26350);
        C43847i.m78630a(this.tYl);
        AppMethodBeat.m2505o(26350);
    }

    /* renamed from: a */
    private static C14416a m78630a(C14416a c14416a) {
        AppMethodBeat.m2504i(26351);
        if (c14416a != null) {
            c14416a.mfO.stop();
            c14416a.mfO.mo33400a(null);
            c14416a.mfO.mo33399a(null);
            c14416a.tYo.clear();
        }
        AppMethodBeat.m2505o(26351);
        return null;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo69530b(C14416a c14416a) {
        AppMethodBeat.m2504i(26352);
        while (c14416a != null) {
            if (c14416a.tYo.size() <= 0) {
                C43847i.m78630a(c14416a);
                break;
            }
            C7620bi c7620bi = (C7620bi) c14416a.tYo.getLast();
            c14416a.tYo.removeLast();
            C32850q.m53706M(c7620bi);
            C4990ab.m7417i("MicroMsg.Wear.WearVoicePlayLogic", "play: msgid=%d, fullpath=%s", Long.valueOf(c7620bi.field_msgId), C32850q.getFullPath(c7620bi.field_imgPath));
            if (c14416a.mfO.mo33404a(C32850q.getFullPath(c7620bi.field_imgPath), true, true, -1)) {
                c14416a.mfO.mo33399a(this.czi);
                c14416a.mfO.mo33400a(this.czj);
                AppMethodBeat.m2505o(26352);
                return;
            }
        }
        AppMethodBeat.m2505o(26352);
    }
}
