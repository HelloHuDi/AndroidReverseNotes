package com.tencent.p177mm.compatible.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C45293b.C32474a;
import com.tencent.p177mm.compatible.util.C45293b.C37658b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@TargetApi(8)
/* renamed from: com.tencent.mm.compatible.util.c */
public final class C32475c implements C37658b {
    private Context context;
    private AudioManager euK;
    C32474a euL;
    private OnAudioFocusChangeListener euM = new C260521();

    /* renamed from: com.tencent.mm.compatible.util.c$1 */
    class C260521 implements OnAudioFocusChangeListener {
        C260521() {
        }

        public final void onAudioFocusChange(int i) {
            AppMethodBeat.m2504i(93064);
            if (C32475c.this.euL != null) {
                C4990ab.m7411d("MicroMsg.AudioFocusHelper", "jacks change: %d", Integer.valueOf(i));
                C32475c.this.euL.mo4587gF(i);
            }
            AppMethodBeat.m2505o(93064);
        }
    }

    /* renamed from: a */
    public final void mo53113a(C32474a c32474a) {
        this.euL = c32474a;
    }

    public C32475c(Context context) {
        AppMethodBeat.m2504i(93065);
        this.context = context;
        AppMethodBeat.m2505o(93065);
    }

    public final boolean requestFocus() {
        AppMethodBeat.m2504i(93066);
        if (this.euK == null && this.context != null) {
            this.euK = (AudioManager) this.context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        boolean z = this.euK != null ? 1 == this.euK.requestAudioFocus(this.euM, 3, 2) : false;
        C4990ab.m7409c("MicroMsg.AudioFocusHelper", "jacks requestFocus: %B, %x", Boolean.valueOf(z), Integer.valueOf(this.euM.hashCode()));
        AppMethodBeat.m2505o(93066);
        return z;
    }

    /* renamed from: Mm */
    public final boolean mo53112Mm() {
        AppMethodBeat.m2504i(93067);
        if (this.euK == null && this.context != null) {
            this.euK = (AudioManager) this.context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        boolean z = this.euK != null ? 1 == this.euK.abandonAudioFocus(this.euM) : false;
        C4990ab.m7409c("MicroMsg.AudioFocusHelper", "jacks abandonFocus: %B, %x", Boolean.valueOf(z), Integer.valueOf(this.euM.hashCode()));
        AppMethodBeat.m2505o(93067);
        return z;
    }
}
