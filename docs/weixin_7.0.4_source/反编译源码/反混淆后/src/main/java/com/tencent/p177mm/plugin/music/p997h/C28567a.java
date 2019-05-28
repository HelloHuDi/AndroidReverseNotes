package com.tencent.p177mm.plugin.music.p997h;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.music.p462e.C28562h;
import com.tencent.p177mm.plugin.music.p462e.C39435k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.music.h.a */
public final class C28567a {
    AudioManager eoY = ((AudioManager) C4996ah.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE));
    OnAudioFocusChangeListener mtx = new C285681();

    /* renamed from: com.tencent.mm.plugin.music.h.a$1 */
    class C285681 implements OnAudioFocusChangeListener {
        C285681() {
        }

        public final void onAudioFocusChange(int i) {
            AppMethodBeat.m2504i(137686);
            C4990ab.m7417i("MicroMsg.Music.MusicAudioFocusHelper", "focus change %d", Integer.valueOf(i));
            if (i == -2 || i == -3) {
                C4990ab.m7416i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus lossTransient");
                if (C39435k.bUf().bTS().aig()) {
                    C39435k.bUf().bTS().bSN();
                    AppMethodBeat.m2505o(137686);
                    return;
                }
            } else if (i == 1 || i == 2 || i == 3) {
                C4990ab.m7416i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus gain");
                if (C39435k.bUf().bTS().aig()) {
                    C39435k.bUf().bTS().resume();
                    AppMethodBeat.m2505o(137686);
                    return;
                }
            } else if (i == -1) {
                C4990ab.m7416i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus loss, passive pause");
                if (C39435k.bUf().bTS().aig()) {
                    C39435k.bUf().bTS().bSN();
                    C39435k.bUf();
                    C28562h.bUe();
                    C39435k.bUf().mo46678zI(600000);
                }
                if (C28567a.this.eoY != null) {
                    C28567a.this.eoY.abandonAudioFocus(C28567a.this.mtx);
                }
            }
            AppMethodBeat.m2505o(137686);
        }
    }

    public C28567a() {
        AppMethodBeat.m2504i(137687);
        AppMethodBeat.m2505o(137687);
    }

    public final boolean requestFocus() {
        AppMethodBeat.m2504i(137688);
        if (this.eoY == null) {
            AppMethodBeat.m2505o(137688);
            return false;
        }
        boolean z;
        int requestAudioFocus = this.eoY.requestAudioFocus(this.mtx, 3, 2);
        String str = "MicroMsg.Music.MusicAudioFocusHelper";
        String str2 = "request audio focus %b";
        Object[] objArr = new Object[1];
        if (requestAudioFocus == 1) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        if (requestAudioFocus == 1) {
            AppMethodBeat.m2505o(137688);
            return true;
        }
        AppMethodBeat.m2505o(137688);
        return false;
    }

    public final void bSK() {
        AppMethodBeat.m2504i(137689);
        C4990ab.m7416i("MicroMsg.Music.MusicAudioFocusHelper", "abandonFocus");
        if (this.eoY == null) {
            AppMethodBeat.m2505o(137689);
            return;
        }
        this.eoY.abandonAudioFocus(this.mtx);
        AppMethodBeat.m2505o(137689);
    }
}
