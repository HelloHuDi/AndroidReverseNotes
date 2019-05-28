package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

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
import com.tencent.mm.plugin.wenote.model.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;

public class NoteEditorVoiceBaseView extends TextView implements a {
    public int cAO;
    private Context context;
    private int duration = -1;
    private boolean isRunning = false;
    private AlphaAnimation mhK;
    private AnimationDrawable mhL;
    public String path = "";

    public NoteEditorVoiceBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(27189);
        this.context = context;
        bvA();
        AppMethodBeat.o(27189);
    }

    public NoteEditorVoiceBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(27190);
        this.context = context;
        bvA();
        AppMethodBeat.o(27190);
    }

    private void bvA() {
        AppMethodBeat.i(27191);
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
        AppMethodBeat.o(27191);
    }

    public final void ceT() {
        AppMethodBeat.i(27192);
        if (this.mhK != null && this.mhK.isInitialized()) {
            setAnimation(null);
        }
        this.isRunning = false;
        setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.raw.chatfrom_voice_playing_new), null, null, null);
        this.mhL.stop();
        AppMethodBeat.o(27192);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(27193);
        super.onFinishInflate();
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                String str;
                AppMethodBeat.i(27188);
                String str2 = "MicroMsg.NoteEditorVoiceBaseView";
                String str3 = "clicked path:%s, player isPlay:%s, path:%s";
                Object[] objArr = new Object[3];
                objArr[0] = NoteEditorVoiceBaseView.this.path;
                if (a.dfY().buH()) {
                    str = "true";
                } else {
                    str = "false";
                }
                objArr[1] = str;
                objArr[2] = a.dfY().path;
                ab.i(str2, str3, objArr);
                if (com.tencent.mm.r.a.bJ(NoteEditorVoiceBaseView.this.context) || com.tencent.mm.r.a.bH(NoteEditorVoiceBaseView.this.context)) {
                    AppMethodBeat.o(27188);
                } else if (!f.Mn() && !bo.isNullOrNil(NoteEditorVoiceBaseView.this.path)) {
                    t.hO(view.getContext());
                    AppMethodBeat.o(27188);
                } else if (k.ddK().miB) {
                    AppMethodBeat.o(27188);
                } else if (bo.bc(NoteEditorVoiceBaseView.this.path, "").equals(a.dfY().path) && a.dfY().buH()) {
                    NoteEditorVoiceBaseView noteEditorVoiceBaseView = NoteEditorVoiceBaseView.this;
                    ab.d("MicroMsg.NoteEditorVoiceBaseView", "stop play");
                    noteEditorVoiceBaseView.ceT();
                    a.dfY().stopPlay();
                    AppMethodBeat.o(27188);
                } else {
                    NoteEditorVoiceBaseView.c(NoteEditorVoiceBaseView.this);
                    AppMethodBeat.o(27188);
                }
            }
        });
        AppMethodBeat.o(27193);
    }

    public final void ahs(String str) {
        AppMethodBeat.i(27194);
        ab.d("MicroMsg.NoteEditorVoiceBaseView", "on play, my path %s, my duration %d, play path %s", this.path, Integer.valueOf(this.duration), str);
        if (!bo.bc(str, "").equals(this.path)) {
            ceT();
        }
        AppMethodBeat.o(27194);
    }

    public final void dfX() {
        AppMethodBeat.i(27195);
        ceT();
        AppMethodBeat.o(27195);
    }

    static /* synthetic */ void c(NoteEditorVoiceBaseView noteEditorVoiceBaseView) {
        AppMethodBeat.i(27196);
        ab.d("MicroMsg.NoteEditorVoiceBaseView", "start play, path[%s] voiceType[%d]", noteEditorVoiceBaseView.path, Integer.valueOf(noteEditorVoiceBaseView.cAO));
        if (a.dfY().startPlay(noteEditorVoiceBaseView.path, noteEditorVoiceBaseView.cAO)) {
            if (!noteEditorVoiceBaseView.isRunning) {
                noteEditorVoiceBaseView.isRunning = true;
                noteEditorVoiceBaseView.setCompoundDrawablesWithIntrinsicBounds(noteEditorVoiceBaseView.mhL, null, null, null);
                noteEditorVoiceBaseView.mhL.stop();
                noteEditorVoiceBaseView.mhL.start();
            }
            AppMethodBeat.o(27196);
            return;
        }
        Toast.makeText(noteEditorVoiceBaseView.getContext(), R.string.bsb, 1).show();
        AppMethodBeat.o(27196);
    }
}
