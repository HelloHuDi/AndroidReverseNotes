package com.tencent.p177mm.plugin.fav.p410ui;

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
import com.tencent.p177mm.plugin.fav.p407a.C36764n;
import com.tencent.p177mm.plugin.fav.p407a.C36764n.C27973a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.fav.ui.FavChatVoiceView */
public class FavChatVoiceView extends TextView implements C27973a {
    private int cAO;
    private Context context;
    private int duration = -1;
    private boolean isRunning = false;
    private C36764n mgA;
    private AlphaAnimation mhK;
    private AnimationDrawable mhL;
    private String path = "";

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavChatVoiceView$1 */
    class C341411 implements OnClickListener {
        C341411() {
        }

        public final void onClick(View view) {
            String str;
            AppMethodBeat.m2504i(73937);
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
            C4990ab.m7417i(str2, str3, objArr);
            if (C35973a.m59179bJ(FavChatVoiceView.this.context) || C35973a.m59177bH(FavChatVoiceView.this.context)) {
                AppMethodBeat.m2505o(73937);
            } else if (!C1445f.m3070Mn() && !C5046bo.isNullOrNil(FavChatVoiceView.this.path)) {
                C23639t.m36492hO(view.getContext());
                AppMethodBeat.m2505o(73937);
            } else if (C5046bo.m7532bc(FavChatVoiceView.this.path, "").equals(FavChatVoiceView.this.mgA.path) && FavChatVoiceView.this.mgA.buH()) {
                FavChatVoiceView.this.stopPlay();
                AppMethodBeat.m2505o(73937);
            } else {
                FavChatVoiceView.m55976d(FavChatVoiceView.this);
                AppMethodBeat.m2505o(73937);
            }
        }
    }

    public FavChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(73938);
        this.context = context;
        bvA();
        AppMethodBeat.m2505o(73938);
    }

    public FavChatVoiceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(73939);
        this.context = context;
        bvA();
        AppMethodBeat.m2505o(73939);
    }

    private void bvA() {
        AppMethodBeat.m2504i(73940);
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
        AppMethodBeat.m2505o(73940);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(73941);
        super.onFinishInflate();
        setOnClickListener(new C341411());
        AppMethodBeat.m2505o(73941);
    }

    /* renamed from: t */
    public final void mo54711t(String str, int i, String str2) {
        AppMethodBeat.m2504i(73942);
        this.path = C5046bo.m7532bc(str, "");
        this.cAO = i;
        setText(str2);
        AppMethodBeat.m2505o(73942);
    }

    public final void stopPlay() {
        AppMethodBeat.m2504i(73943);
        C4990ab.m7410d("MicroMsg.FavChatVoiceView", "stop play");
        if (this.mhK != null && this.mhK.isInitialized()) {
            setAnimation(null);
        }
        this.isRunning = false;
        setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(C1318a.chatfrom_voice_playing_new), null, null, null);
        this.mhL.stop();
        this.mgA.stopPlay();
        AppMethodBeat.m2505o(73943);
    }

    public void setVoiceHelper(C36764n c36764n) {
        AppMethodBeat.m2504i(73944);
        this.mgA = c36764n;
        this.mgA.mo58605a(this);
        AppMethodBeat.m2505o(73944);
    }

    /* renamed from: bI */
    public final void mo6771bI(String str, int i) {
        AppMethodBeat.m2504i(73945);
        if (!this.path.equals(str)) {
            stopPlay();
        }
        AppMethodBeat.m2505o(73945);
    }

    public final void onFinish() {
        AppMethodBeat.m2504i(73946);
        stopPlay();
        AppMethodBeat.m2505o(73946);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(73947);
        stopPlay();
        AppMethodBeat.m2505o(73947);
    }

    /* renamed from: d */
    static /* synthetic */ void m55976d(FavChatVoiceView favChatVoiceView) {
        AppMethodBeat.m2504i(73948);
        C4990ab.m7411d("MicroMsg.FavChatVoiceView", "start play, path[%s] voiceType[%d]", favChatVoiceView.path, Integer.valueOf(favChatVoiceView.cAO));
        if (favChatVoiceView.mgA.startPlay(favChatVoiceView.path, favChatVoiceView.cAO)) {
            if (!favChatVoiceView.isRunning) {
                favChatVoiceView.isRunning = true;
                favChatVoiceView.setCompoundDrawablesWithIntrinsicBounds(favChatVoiceView.mhL, null, null, null);
                favChatVoiceView.mhL.stop();
                favChatVoiceView.mhL.start();
            }
            AppMethodBeat.m2505o(73948);
            return;
        }
        Toast.makeText(favChatVoiceView.getContext(), C25738R.string.bsb, 1).show();
        AppMethodBeat.m2505o(73948);
    }
}
