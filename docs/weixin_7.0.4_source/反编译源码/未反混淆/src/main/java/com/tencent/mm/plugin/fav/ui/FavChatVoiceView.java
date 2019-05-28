package com.tencent.mm.plugin.fav.ui;

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
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;

public class FavChatVoiceView extends TextView implements a {
    private int cAO;
    private Context context;
    private int duration = -1;
    private boolean isRunning = false;
    private n mgA;
    private AlphaAnimation mhK;
    private AnimationDrawable mhL;
    private String path = "";

    public FavChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(73938);
        this.context = context;
        bvA();
        AppMethodBeat.o(73938);
    }

    public FavChatVoiceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(73939);
        this.context = context;
        bvA();
        AppMethodBeat.o(73939);
    }

    private void bvA() {
        AppMethodBeat.i(73940);
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
        AppMethodBeat.o(73940);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(73941);
        super.onFinishInflate();
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                String str;
                AppMethodBeat.i(73937);
                String str2 = "MicroMsg.FavChatVoiceView";
                String str3 = "clicked path:%s, player isPlay:%s, path:%s";
                Object[] objArr = new Object[3];
                objArr[0] = FavChatVoiceView.this.path;
                if (FavChatVoiceView.this.mgA.buH()) {
                    str = "true";
                } else {
                    str = "false";
                }
                objArr[1] = str;
                objArr[2] = FavChatVoiceView.this.mgA.path;
                ab.i(str2, str3, objArr);
                if (com.tencent.mm.r.a.bJ(FavChatVoiceView.this.context) || com.tencent.mm.r.a.bH(FavChatVoiceView.this.context)) {
                    AppMethodBeat.o(73937);
                } else if (!f.Mn() && !bo.isNullOrNil(FavChatVoiceView.this.path)) {
                    t.hO(view.getContext());
                    AppMethodBeat.o(73937);
                } else if (bo.bc(FavChatVoiceView.this.path, "").equals(FavChatVoiceView.this.mgA.path) && FavChatVoiceView.this.mgA.buH()) {
                    FavChatVoiceView.this.stopPlay();
                    AppMethodBeat.o(73937);
                } else {
                    FavChatVoiceView.d(FavChatVoiceView.this);
                    AppMethodBeat.o(73937);
                }
            }
        });
        AppMethodBeat.o(73941);
    }

    public final void t(String str, int i, String str2) {
        AppMethodBeat.i(73942);
        this.path = bo.bc(str, "");
        this.cAO = i;
        setText(str2);
        AppMethodBeat.o(73942);
    }

    public final void stopPlay() {
        AppMethodBeat.i(73943);
        ab.d("MicroMsg.FavChatVoiceView", "stop play");
        if (this.mhK != null && this.mhK.isInitialized()) {
            setAnimation(null);
        }
        this.isRunning = false;
        setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.raw.chatfrom_voice_playing_new), null, null, null);
        this.mhL.stop();
        this.mgA.stopPlay();
        AppMethodBeat.o(73943);
    }

    public void setVoiceHelper(n nVar) {
        AppMethodBeat.i(73944);
        this.mgA = nVar;
        this.mgA.a(this);
        AppMethodBeat.o(73944);
    }

    public final void bI(String str, int i) {
        AppMethodBeat.i(73945);
        if (!this.path.equals(str)) {
            stopPlay();
        }
        AppMethodBeat.o(73945);
    }

    public final void onFinish() {
        AppMethodBeat.i(73946);
        stopPlay();
        AppMethodBeat.o(73946);
    }

    public final void onPause() {
        AppMethodBeat.i(73947);
        stopPlay();
        AppMethodBeat.o(73947);
    }

    static /* synthetic */ void d(FavChatVoiceView favChatVoiceView) {
        AppMethodBeat.i(73948);
        ab.d("MicroMsg.FavChatVoiceView", "start play, path[%s] voiceType[%d]", favChatVoiceView.path, Integer.valueOf(favChatVoiceView.cAO));
        if (favChatVoiceView.mgA.startPlay(favChatVoiceView.path, favChatVoiceView.cAO)) {
            if (!favChatVoiceView.isRunning) {
                favChatVoiceView.isRunning = true;
                favChatVoiceView.setCompoundDrawablesWithIntrinsicBounds(favChatVoiceView.mhL, null, null, null);
                favChatVoiceView.mhL.stop();
                favChatVoiceView.mhL.start();
            }
            AppMethodBeat.o(73948);
            return;
        }
        Toast.makeText(favChatVoiceView.getContext(), R.string.bsb, 1).show();
        AppMethodBeat.o(73948);
    }
}
