package com.tencent.mm.plugin.music.b.b;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class a {
    AudioManager eoY = ((AudioManager) ah.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE));
    OnAudioFocusChangeListener mtx = new OnAudioFocusChangeListener() {
        public final void onAudioFocusChange(int i) {
            AppMethodBeat.i(137394);
            ab.i("MicroMsg.Music.MusicAudioFocusHelper", "focus change %d", Integer.valueOf(i));
            if (i == -2 || i == -3) {
                ab.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus lossTransient");
                AppMethodBeat.o(137394);
            } else if (i == 1 || i == 2 || i == 3) {
                ab.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus gain");
                AppMethodBeat.o(137394);
            } else {
                if (i == -1) {
                    ab.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus loss, passive pause");
                    if (a.this.eoY != null) {
                        a.this.eoY.abandonAudioFocus(a.this.mtx);
                    }
                    a.this.oKT = false;
                }
                AppMethodBeat.o(137394);
            }
        }
    };
    public boolean oKT = false;

    public a() {
        AppMethodBeat.i(137395);
        AppMethodBeat.o(137395);
    }

    public final boolean requestFocus() {
        AppMethodBeat.i(137396);
        if (this.eoY == null) {
            AppMethodBeat.o(137396);
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
        ab.i(str, str2, objArr);
        if (requestAudioFocus == 1) {
            this.oKT = true;
        }
        if (requestAudioFocus == 1) {
            AppMethodBeat.o(137396);
            return true;
        }
        AppMethodBeat.o(137396);
        return false;
    }

    public final void bSK() {
        AppMethodBeat.i(137397);
        ab.i("MicroMsg.Music.MusicAudioFocusHelper", "abandonFocus");
        if (this.eoY == null) {
            AppMethodBeat.o(137397);
            return;
        }
        this.eoY.abandonAudioFocus(this.mtx);
        this.oKT = false;
        AppMethodBeat.o(137397);
    }
}
