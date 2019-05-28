package com.tencent.p177mm.plugin.record.p493ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.plugin.record.p492b.C39577s;
import com.tencent.p177mm.plugin.record.p492b.C39577s.C34796a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4997aj;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.record.ui.RecordVoiceBaseView */
public class RecordVoiceBaseView extends TextView implements C34796a {
    public int cAO;
    private Context context;
    public int duration = -1;
    private boolean isRunning = false;
    private AlphaAnimation mhK;
    private AnimationDrawable mhL;
    private C39577s pKR;
    public String path = "";

    /* renamed from: com.tencent.mm.plugin.record.ui.RecordVoiceBaseView$1 */
    class C216181 implements OnClickListener {
        C216181() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(24324);
            C4990ab.m7411d("MicroMsg.RecordVoiceBaseView", "clicked path %s, isPlay %s", RecordVoiceBaseView.this.path, Boolean.valueOf(RecordVoiceBaseView.this.pKR.buH()));
            if (C35973a.m59179bJ(RecordVoiceBaseView.this.context) || C35973a.m59177bH(RecordVoiceBaseView.this.context)) {
                AppMethodBeat.m2505o(24324);
            } else if (!C1445f.m3070Mn() && !C5046bo.isNullOrNil(RecordVoiceBaseView.this.path)) {
                C23639t.m36492hO(view.getContext());
                AppMethodBeat.m2505o(24324);
            } else if (!C5046bo.m7532bc(RecordVoiceBaseView.this.path, "").equals(RecordVoiceBaseView.this.pKR.path)) {
                RecordVoiceBaseView.m86194d(RecordVoiceBaseView.this);
                AppMethodBeat.m2505o(24324);
            } else if (RecordVoiceBaseView.this.pKR.buH()) {
                RecordVoiceBaseView.this.stopPlay();
                AppMethodBeat.m2505o(24324);
            } else {
                if (!RecordVoiceBaseView.m86195e(RecordVoiceBaseView.this)) {
                    RecordVoiceBaseView.m86194d(RecordVoiceBaseView.this);
                }
                AppMethodBeat.m2505o(24324);
            }
        }
    }

    public RecordVoiceBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(24325);
        this.context = context;
        bvA();
        AppMethodBeat.m2505o(24325);
    }

    public RecordVoiceBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(24326);
        this.context = context;
        bvA();
        AppMethodBeat.m2505o(24326);
    }

    private void bvA() {
        AppMethodBeat.m2504i(24327);
        this.mhK = new AlphaAnimation(0.1f, 1.0f);
        this.mhK.setDuration(1000);
        this.mhK.setRepeatCount(-1);
        this.mhK.setRepeatMode(2);
        this.mhL = new AnimationDrawable();
        Drawable drawable = getResources().getDrawable(C1318a.chatfrom_voice_playing_new_f1);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.mhL.addFrame(drawable, 300);
        drawable = getResources().getDrawable(C1318a.chatfrom_voice_playing_new_f2);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.mhL.addFrame(drawable, 300);
        drawable = getResources().getDrawable(C1318a.chatfrom_voice_playing_new_f3);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.mhL.addFrame(drawable, 300);
        this.mhL.setOneShot(false);
        this.mhL.setVisible(true, true);
        AppMethodBeat.m2505o(24327);
    }

    private void ceT() {
        AppMethodBeat.m2504i(24328);
        if (this.mhK != null && this.mhK.isInitialized()) {
            setAnimation(null);
        }
        this.isRunning = false;
        setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(C1318a.chatfrom_voice_playing_new), null, null, null);
        this.mhL.stop();
        AppMethodBeat.m2505o(24328);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(24329);
        super.onFinishInflate();
        setOnClickListener(new C216181());
        AppMethodBeat.m2505o(24329);
    }

    public void setVoiceHelper(C39577s c39577s) {
        AppMethodBeat.m2504i(24330);
        this.pKR = c39577s;
        C39577s c39577s2 = this.pKR;
        for (Object obj : c39577s2.callbacks) {
            if (this == obj) {
                break;
            }
        }
        c39577s2.callbacks.add(this);
        AppMethodBeat.m2505o(24330);
    }

    public final void stopPlay() {
        AppMethodBeat.m2504i(24331);
        C4990ab.m7410d("MicroMsg.RecordVoiceBaseView", "stop play");
        ceT();
        this.pKR.stopPlay();
        AppMethodBeat.m2505o(24331);
    }

    /* renamed from: VJ */
    public final void mo55409VJ(String str) {
        AppMethodBeat.m2504i(24332);
        C4990ab.m7411d("MicroMsg.RecordVoiceBaseView", "on play, my path %s, my duration %d, play path %s", this.path, Integer.valueOf(this.duration), str);
        if (!C5046bo.m7532bc(str, "").equals(this.path)) {
            ceT();
        }
        AppMethodBeat.m2505o(24332);
    }

    public final void onFinish() {
        AppMethodBeat.m2504i(24333);
        stopPlay();
        AppMethodBeat.m2505o(24333);
    }

    /* renamed from: d */
    static /* synthetic */ void m86194d(RecordVoiceBaseView recordVoiceBaseView) {
        AppMethodBeat.m2504i(24334);
        C4990ab.m7411d("MicroMsg.RecordVoiceBaseView", "start play, path[%s] voiceType[%d]", recordVoiceBaseView.path, Integer.valueOf(recordVoiceBaseView.cAO));
        if (recordVoiceBaseView.pKR.startPlay(recordVoiceBaseView.path, recordVoiceBaseView.cAO)) {
            if (!recordVoiceBaseView.isRunning) {
                recordVoiceBaseView.isRunning = true;
                recordVoiceBaseView.setCompoundDrawablesWithIntrinsicBounds(recordVoiceBaseView.mhL, null, null, null);
                recordVoiceBaseView.mhL.stop();
                recordVoiceBaseView.mhL.start();
            }
            AppMethodBeat.m2505o(24334);
            return;
        }
        Toast.makeText(recordVoiceBaseView.getContext(), C25738R.string.bsb, 1).show();
        AppMethodBeat.m2505o(24334);
    }

    /* renamed from: e */
    static /* synthetic */ boolean m86195e(RecordVoiceBaseView recordVoiceBaseView) {
        AppMethodBeat.m2504i(24335);
        C4990ab.m7416i("MicroMsg.RecordVoiceBaseView", "resume play");
        C39577s c39577s = recordVoiceBaseView.pKR;
        C4990ab.m7416i("MicroMsg.RecordVoiceHelper", "resume play");
        C4997aj.amA("keep_app_silent");
        if (c39577s.mfO == null) {
            C4990ab.m7420w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
            AppMethodBeat.m2505o(24335);
            return false;
        }
        boolean Ew = c39577s.mfO.mo33396Ew();
        AppMethodBeat.m2505o(24335);
        return Ew;
    }
}
