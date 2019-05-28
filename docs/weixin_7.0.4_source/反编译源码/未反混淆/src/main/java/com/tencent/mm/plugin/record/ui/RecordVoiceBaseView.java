package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.record.b.s;
import com.tencent.mm.plugin.record.b.s.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;

public class RecordVoiceBaseView extends TextView implements a {
    public int cAO;
    private Context context;
    public int duration = -1;
    private boolean isRunning = false;
    private AlphaAnimation mhK;
    private AnimationDrawable mhL;
    private s pKR;
    public String path = "";

    public RecordVoiceBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(24325);
        this.context = context;
        bvA();
        AppMethodBeat.o(24325);
    }

    public RecordVoiceBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(24326);
        this.context = context;
        bvA();
        AppMethodBeat.o(24326);
    }

    private void bvA() {
        AppMethodBeat.i(24327);
        this.mhK = new AlphaAnimation(0.1f, 1.0f);
        this.mhK.setDuration(1000);
        this.mhK.setRepeatCount(-1);
        this.mhK.setRepeatMode(2);
        this.mhL = new AnimationDrawable();
        Drawable drawable = getResources().getDrawable(R.raw.chatfrom_voice_playing_new_f1);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.mhL.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.raw.chatfrom_voice_playing_new_f2);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.mhL.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.raw.chatfrom_voice_playing_new_f3);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.mhL.addFrame(drawable, 300);
        this.mhL.setOneShot(false);
        this.mhL.setVisible(true, true);
        AppMethodBeat.o(24327);
    }

    private void ceT() {
        AppMethodBeat.i(24328);
        if (this.mhK != null && this.mhK.isInitialized()) {
            setAnimation(null);
        }
        this.isRunning = false;
        setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.raw.chatfrom_voice_playing_new), null, null, null);
        this.mhL.stop();
        AppMethodBeat.o(24328);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(24329);
        super.onFinishInflate();
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(24324);
                ab.d("MicroMsg.RecordVoiceBaseView", "clicked path %s, isPlay %s", RecordVoiceBaseView.this.path, Boolean.valueOf(RecordVoiceBaseView.this.pKR.buH()));
                if (com.tencent.mm.r.a.bJ(RecordVoiceBaseView.this.context) || com.tencent.mm.r.a.bH(RecordVoiceBaseView.this.context)) {
                    AppMethodBeat.o(24324);
                } else if (!f.Mn() && !bo.isNullOrNil(RecordVoiceBaseView.this.path)) {
                    t.hO(view.getContext());
                    AppMethodBeat.o(24324);
                } else if (!bo.bc(RecordVoiceBaseView.this.path, "").equals(RecordVoiceBaseView.this.pKR.path)) {
                    RecordVoiceBaseView.d(RecordVoiceBaseView.this);
                    AppMethodBeat.o(24324);
                } else if (RecordVoiceBaseView.this.pKR.buH()) {
                    RecordVoiceBaseView.this.stopPlay();
                    AppMethodBeat.o(24324);
                } else {
                    if (!RecordVoiceBaseView.e(RecordVoiceBaseView.this)) {
                        RecordVoiceBaseView.d(RecordVoiceBaseView.this);
                    }
                    AppMethodBeat.o(24324);
                }
            }
        });
        AppMethodBeat.o(24329);
    }

    public void setVoiceHelper(s sVar) {
        AppMethodBeat.i(24330);
        this.pKR = sVar;
        s sVar2 = this.pKR;
        for (Object obj : sVar2.callbacks) {
            if (this == obj) {
                break;
            }
        }
        sVar2.callbacks.add(this);
        AppMethodBeat.o(24330);
    }

    public final void stopPlay() {
        AppMethodBeat.i(24331);
        ab.d("MicroMsg.RecordVoiceBaseView", "stop play");
        ceT();
        this.pKR.stopPlay();
        AppMethodBeat.o(24331);
    }

    public final void VJ(String str) {
        AppMethodBeat.i(24332);
        ab.d("MicroMsg.RecordVoiceBaseView", "on play, my path %s, my duration %d, play path %s", this.path, Integer.valueOf(this.duration), str);
        if (!bo.bc(str, "").equals(this.path)) {
            ceT();
        }
        AppMethodBeat.o(24332);
    }

    public final void onFinish() {
        AppMethodBeat.i(24333);
        stopPlay();
        AppMethodBeat.o(24333);
    }

    static /* synthetic */ void d(RecordVoiceBaseView recordVoiceBaseView) {
        AppMethodBeat.i(24334);
        ab.d("MicroMsg.RecordVoiceBaseView", "start play, path[%s] voiceType[%d]", recordVoiceBaseView.path, Integer.valueOf(recordVoiceBaseView.cAO));
        if (recordVoiceBaseView.pKR.startPlay(recordVoiceBaseView.path, recordVoiceBaseView.cAO)) {
            if (!recordVoiceBaseView.isRunning) {
                recordVoiceBaseView.isRunning = true;
                recordVoiceBaseView.setCompoundDrawablesWithIntrinsicBounds(recordVoiceBaseView.mhL, null, null, null);
                recordVoiceBaseView.mhL.stop();
                recordVoiceBaseView.mhL.start();
            }
            AppMethodBeat.o(24334);
            return;
        }
        Toast.makeText(recordVoiceBaseView.getContext(), R.string.bsb, 1).show();
        AppMethodBeat.o(24334);
    }

    static /* synthetic */ boolean e(RecordVoiceBaseView recordVoiceBaseView) {
        AppMethodBeat.i(24335);
        ab.i("MicroMsg.RecordVoiceBaseView", "resume play");
        s sVar = recordVoiceBaseView.pKR;
        ab.i("MicroMsg.RecordVoiceHelper", "resume play");
        aj.amA("keep_app_silent");
        if (sVar.mfO == null) {
            ab.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
            AppMethodBeat.o(24335);
            return false;
        }
        boolean Ew = sVar.mfO.Ew();
        AppMethodBeat.o(24335);
        return Ew;
    }
}
