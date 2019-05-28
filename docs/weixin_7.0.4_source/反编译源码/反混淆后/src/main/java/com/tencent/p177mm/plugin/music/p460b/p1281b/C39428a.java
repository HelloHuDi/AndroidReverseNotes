package com.tencent.p177mm.plugin.music.p460b.p1281b;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.music.b.b.a */
public final class C39428a {
    AudioManager eoY = ((AudioManager) C4996ah.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE));
    OnAudioFocusChangeListener mtx = new C213371();
    public boolean oKT = false;

    /* renamed from: com.tencent.mm.plugin.music.b.b.a$1 */
    class C213371 implements OnAudioFocusChangeListener {
        C213371() {
        }

        public final void onAudioFocusChange(int i) {
            AppMethodBeat.m2504i(137394);
            C4990ab.m7417i("MicroMsg.Music.MusicAudioFocusHelper", "focus change %d", Integer.valueOf(i));
            if (i == -2 || i == -3) {
                C4990ab.m7416i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus lossTransient");
                AppMethodBeat.m2505o(137394);
            } else if (i == 1 || i == 2 || i == 3) {
                C4990ab.m7416i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus gain");
                AppMethodBeat.m2505o(137394);
            } else {
                if (i == -1) {
                    C4990ab.m7416i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus loss, passive pause");
                    if (C39428a.this.eoY != null) {
                        C39428a.this.eoY.abandonAudioFocus(C39428a.this.mtx);
                    }
                    C39428a.this.oKT = false;
                }
                AppMethodBeat.m2505o(137394);
            }
        }
    }

    public C39428a() {
        AppMethodBeat.m2504i(137395);
        AppMethodBeat.m2505o(137395);
    }

    public final boolean requestFocus() {
        AppMethodBeat.m2504i(137396);
        if (this.eoY == null) {
            AppMethodBeat.m2505o(137396);
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
            this.oKT = true;
        }
        if (requestAudioFocus == 1) {
            AppMethodBeat.m2505o(137396);
            return true;
        }
        AppMethodBeat.m2505o(137396);
        return false;
    }

    public final void bSK() {
        AppMethodBeat.m2504i(137397);
        C4990ab.m7416i("MicroMsg.Music.MusicAudioFocusHelper", "abandonFocus");
        if (this.eoY == null) {
            AppMethodBeat.m2505o(137397);
            return;
        }
        this.eoY.abandonAudioFocus(this.mtx);
        this.oKT = false;
        AppMethodBeat.m2505o(137397);
    }
}
