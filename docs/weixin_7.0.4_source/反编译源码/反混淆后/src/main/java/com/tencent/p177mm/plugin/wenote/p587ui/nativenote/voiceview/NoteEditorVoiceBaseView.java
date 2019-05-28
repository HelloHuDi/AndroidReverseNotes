package com.tencent.p177mm.plugin.wenote.p587ui.nativenote.voiceview;

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
import com.tencent.p177mm.plugin.wenote.model.C40371k;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.voiceview.C44019a.C4692a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteEditorVoiceBaseView */
public class NoteEditorVoiceBaseView extends TextView implements C4692a {
    public int cAO;
    private Context context;
    private int duration = -1;
    private boolean isRunning = false;
    private AlphaAnimation mhK;
    private AnimationDrawable mhL;
    public String path = "";

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteEditorVoiceBaseView$1 */
    class C147961 implements OnClickListener {
        C147961() {
        }

        public final void onClick(View view) {
            String str;
            AppMethodBeat.m2504i(27188);
            String str2 = "MicroMsg.NoteEditorVoiceBaseView";
            String str3 = "clicked path:%s, player isPlay:%s, path:%s";
            Object[] objArr = new Object[3];
            objArr[0] = NoteEditorVoiceBaseView.this.path;
            if (C44019a.dfY().buH()) {
                str = "true";
            } else {
                str = "false";
            }
            objArr[1] = str;
            objArr[2] = C44019a.dfY().path;
            C4990ab.m7417i(str2, str3, objArr);
            if (C35973a.m59179bJ(NoteEditorVoiceBaseView.this.context) || C35973a.m59177bH(NoteEditorVoiceBaseView.this.context)) {
                AppMethodBeat.m2505o(27188);
            } else if (!C1445f.m3070Mn() && !C5046bo.isNullOrNil(NoteEditorVoiceBaseView.this.path)) {
                C23639t.m36492hO(view.getContext());
                AppMethodBeat.m2505o(27188);
            } else if (C40371k.ddK().miB) {
                AppMethodBeat.m2505o(27188);
            } else if (C5046bo.m7532bc(NoteEditorVoiceBaseView.this.path, "").equals(C44019a.dfY().path) && C44019a.dfY().buH()) {
                NoteEditorVoiceBaseView noteEditorVoiceBaseView = NoteEditorVoiceBaseView.this;
                C4990ab.m7410d("MicroMsg.NoteEditorVoiceBaseView", "stop play");
                noteEditorVoiceBaseView.ceT();
                C44019a.dfY().stopPlay();
                AppMethodBeat.m2505o(27188);
            } else {
                NoteEditorVoiceBaseView.m23024c(NoteEditorVoiceBaseView.this);
                AppMethodBeat.m2505o(27188);
            }
        }
    }

    public NoteEditorVoiceBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(27189);
        this.context = context;
        bvA();
        AppMethodBeat.m2505o(27189);
    }

    public NoteEditorVoiceBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(27190);
        this.context = context;
        bvA();
        AppMethodBeat.m2505o(27190);
    }

    private void bvA() {
        AppMethodBeat.m2504i(27191);
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
        AppMethodBeat.m2505o(27191);
    }

    public final void ceT() {
        AppMethodBeat.m2504i(27192);
        if (this.mhK != null && this.mhK.isInitialized()) {
            setAnimation(null);
        }
        this.isRunning = false;
        setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(C1318a.chatfrom_voice_playing_new), null, null, null);
        this.mhL.stop();
        AppMethodBeat.m2505o(27192);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(27193);
        super.onFinishInflate();
        setOnClickListener(new C147961());
        AppMethodBeat.m2505o(27193);
    }

    public final void ahs(String str) {
        AppMethodBeat.m2504i(27194);
        C4990ab.m7411d("MicroMsg.NoteEditorVoiceBaseView", "on play, my path %s, my duration %d, play path %s", this.path, Integer.valueOf(this.duration), str);
        if (!C5046bo.m7532bc(str, "").equals(this.path)) {
            ceT();
        }
        AppMethodBeat.m2505o(27194);
    }

    public final void dfX() {
        AppMethodBeat.m2504i(27195);
        ceT();
        AppMethodBeat.m2505o(27195);
    }

    /* renamed from: c */
    static /* synthetic */ void m23024c(NoteEditorVoiceBaseView noteEditorVoiceBaseView) {
        AppMethodBeat.m2504i(27196);
        C4990ab.m7411d("MicroMsg.NoteEditorVoiceBaseView", "start play, path[%s] voiceType[%d]", noteEditorVoiceBaseView.path, Integer.valueOf(noteEditorVoiceBaseView.cAO));
        if (C44019a.dfY().startPlay(noteEditorVoiceBaseView.path, noteEditorVoiceBaseView.cAO)) {
            if (!noteEditorVoiceBaseView.isRunning) {
                noteEditorVoiceBaseView.isRunning = true;
                noteEditorVoiceBaseView.setCompoundDrawablesWithIntrinsicBounds(noteEditorVoiceBaseView.mhL, null, null, null);
                noteEditorVoiceBaseView.mhL.stop();
                noteEditorVoiceBaseView.mhL.start();
            }
            AppMethodBeat.m2505o(27196);
            return;
        }
        Toast.makeText(noteEditorVoiceBaseView.getContext(), C25738R.string.bsb, 1).show();
        AppMethodBeat.m2505o(27196);
    }
}
