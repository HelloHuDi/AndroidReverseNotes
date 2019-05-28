package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.compatible.util.b.b;
import com.tencent.mm.sdk.platformtools.ab;

@TargetApi(8)
public final class c implements b {
    private Context context;
    private AudioManager euK;
    a euL;
    private OnAudioFocusChangeListener euM = new OnAudioFocusChangeListener() {
        public final void onAudioFocusChange(int i) {
            AppMethodBeat.i(93064);
            if (c.this.euL != null) {
                ab.d("MicroMsg.AudioFocusHelper", "jacks change: %d", Integer.valueOf(i));
                c.this.euL.gF(i);
            }
            AppMethodBeat.o(93064);
        }
    };

    public final void a(a aVar) {
        this.euL = aVar;
    }

    public c(Context context) {
        AppMethodBeat.i(93065);
        this.context = context;
        AppMethodBeat.o(93065);
    }

    public final boolean requestFocus() {
        AppMethodBeat.i(93066);
        if (this.euK == null && this.context != null) {
            this.euK = (AudioManager) this.context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        boolean z = this.euK != null ? 1 == this.euK.requestAudioFocus(this.euM, 3, 2) : false;
        ab.c("MicroMsg.AudioFocusHelper", "jacks requestFocus: %B, %x", Boolean.valueOf(z), Integer.valueOf(this.euM.hashCode()));
        AppMethodBeat.o(93066);
        return z;
    }

    public final boolean Mm() {
        AppMethodBeat.i(93067);
        if (this.euK == null && this.context != null) {
            this.euK = (AudioManager) this.context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        boolean z = this.euK != null ? 1 == this.euK.abandonAudioFocus(this.euM) : false;
        ab.c("MicroMsg.AudioFocusHelper", "jacks abandonFocus: %B, %x", Boolean.valueOf(z), Integer.valueOf(this.euM.hashCode()));
        AppMethodBeat.o(93067);
        return z;
    }
}
