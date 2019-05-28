package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.h;
import com.tencent.mm.ai.h.b;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.bi;
import java.util.LinkedList;

public final class i {
    private com.tencent.mm.ai.h.a czi = new com.tencent.mm.ai.h.a() {
        public final void EA() {
            AppMethodBeat.i(26346);
            i.this.tYl.mfO.a(null);
            i.this.tYl.mfO.a(null);
            i.this.b(i.this.tYl);
            AppMethodBeat.o(26346);
        }
    };
    private b czj = new b() {
        public final void onError() {
            AppMethodBeat.i(26347);
            i.this.tYl.mfO.a(null);
            i.this.tYl.mfO.a(null);
            i.this.b(i.this.tYl);
            AppMethodBeat.o(26347);
        }
    };
    AudioManager eoY = ((AudioManager) ah.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE));
    a tYl;
    BroadcastReceiver tYm = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(26348);
            if (intent.hasExtra("state") && intent.getIntExtra("state", 2) == 0) {
                i.this.cUu();
            }
            AppMethodBeat.o(26348);
        }
    };

    class a {
        h mfO;
        LinkedList<bi> tYo;
    }

    public i() {
        AppMethodBeat.i(26349);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        ah.getContext().registerReceiver(this.tYm, intentFilter);
        AppMethodBeat.o(26349);
    }

    public final void cUu() {
        AppMethodBeat.i(26350);
        a(this.tYl);
        AppMethodBeat.o(26350);
    }

    private static a a(a aVar) {
        AppMethodBeat.i(26351);
        if (aVar != null) {
            aVar.mfO.stop();
            aVar.mfO.a(null);
            aVar.mfO.a(null);
            aVar.tYo.clear();
        }
        AppMethodBeat.o(26351);
        return null;
    }

    /* Access modifiers changed, original: final */
    public final void b(a aVar) {
        AppMethodBeat.i(26352);
        while (aVar != null) {
            if (aVar.tYo.size() <= 0) {
                a(aVar);
                break;
            }
            bi biVar = (bi) aVar.tYo.getLast();
            aVar.tYo.removeLast();
            q.M(biVar);
            ab.i("MicroMsg.Wear.WearVoicePlayLogic", "play: msgid=%d, fullpath=%s", Long.valueOf(biVar.field_msgId), q.getFullPath(biVar.field_imgPath));
            if (aVar.mfO.a(q.getFullPath(biVar.field_imgPath), true, true, -1)) {
                aVar.mfO.a(this.czi);
                aVar.mfO.a(this.czj);
                AppMethodBeat.o(26352);
                return;
            }
        }
        AppMethodBeat.o(26352);
    }
}
