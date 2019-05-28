package com.tencent.p177mm.plugin.wenote.p587ui.nativenote.p588b;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p1593bk.C41793a;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C46457k;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44003l;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.voiceview.C44019a;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.voiceview.NoteVoiceView;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.voiceview.NoteVoiceView.C35751a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.o */
public final class C44017o extends C14790i {
    private LinearLayout gCe;
    private final C7306ak uNR = new C440162();
    public LinearLayout uUj;
    public LinearLayout uUk;
    public ImageView uUm;
    private TextView uUn;
    private TextView uUo;
    private C44003l uUp;
    public NoteVoiceView uVe;

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.o$2 */
    class C440162 extends C7306ak {
        C440162() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(27185);
            if (C44017o.this.uUp.uOp) {
                C44017o.this.uNR.removeMessages(4096);
                AppMethodBeat.m2505o(27185);
                return;
            }
            C44017o.this.uUo.setText(" " + C41793a.m73794B(C4996ah.getContext(), C44017o.this.uUp.uOB).toString());
            sendEmptyMessageDelayed(4096, 500);
            AppMethodBeat.m2505o(27185);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.o$1 */
    class C440181 implements OnClickListener {
        C440181() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27184);
            if (C44017o.this.uUp != null && C44017o.this.uUp.uOh.booleanValue()) {
                C44017o.this.uUp.uOi = Boolean.TRUE;
            }
            AppMethodBeat.m2505o(27184);
        }
    }

    public C44017o(View view, C46457k c46457k) {
        super(view, c46457k);
        AppMethodBeat.m2504i(27186);
        this.gCe = (LinearLayout) view.findViewById(2131826391);
        this.uUj = (LinearLayout) view.findViewById(2131826392);
        this.uUk = (LinearLayout) view.findViewById(2131826396);
        this.uUm = (ImageView) view.findViewById(2131826393);
        this.uUn = (TextView) view.findViewById(2131826394);
        this.uUo = (TextView) view.findViewById(2131826395);
        this.uVe = (NoteVoiceView) view.findViewById(2131826397);
        this.uVe.setVoiceHelper(C44019a.dfY());
        this.gCe.setVisibility(0);
        this.uUj.setVisibility(8);
        this.uUk.setVisibility(0);
        this.cAw.setVisibility(8);
        this.uUB.setVisibility(8);
        this.gCe.setOnClickListener(new C440181());
        AppMethodBeat.m2505o(27186);
    }

    /* renamed from: a */
    public final void mo9809a(C44001c c44001c, int i, int i2) {
        AppMethodBeat.m2504i(27187);
        this.uUp = (C44003l) c44001c;
        if (this.uUp.uOp) {
            boolean z;
            this.gCe.setBackgroundResource(0);
            this.uUk.setVisibility(0);
            this.uUj.setVisibility(8);
            this.gCe.setPadding(0, 0, 0, 0);
            if (c44001c.uOa) {
                z = true;
            } else {
                z = false;
            }
            NoteVoiceView noteVoiceView = this.uVe;
            String str = this.uUp.cHg;
            int i3 = this.uUp.cAO;
            int i4 = this.uUp.cAP;
            noteVoiceView.path = C5046bo.m7532bc(str, "");
            noteVoiceView.cAO = i3;
            noteVoiceView.duration = i4;
            if (z) {
                noteVoiceView.iVh.setVisibility(0);
            } else {
                noteVoiceView.iVh.setVisibility(8);
            }
            C35751a c35751a;
            if (!noteVoiceView.path.equals(noteVoiceView.uVk.path)) {
                noteVoiceView.uVl.mo56528vD(i4);
            } else if (noteVoiceView.uVk.buH()) {
                C4990ab.m7416i("MicroMsg.NoteVoiceView", "updateInfo .isPlay()");
                c35751a = noteVoiceView.uVl;
                noteVoiceView.uVk.mo69694Ez();
                c35751a.mo56526os(true);
            } else {
                C44019a c44019a = noteVoiceView.uVk;
                if (c44019a.mfO == null) {
                    C4990ab.m7420w("MicroMsg.RecordVoiceHelper", "check is pause, but player is null");
                    z = false;
                } else {
                    z = c44019a.mfO.mo33395DA();
                }
                if (z) {
                    C4990ab.m7416i("MicroMsg.NoteVoiceView", "updateInfo .isPause()");
                    c35751a = noteVoiceView.uVl;
                    noteVoiceView.uVk.mo69694Ez();
                    c35751a.mo56526os(false);
                } else {
                    noteVoiceView.uVl.mo56528vD(i4);
                }
            }
        } else {
            this.gCe.setBackgroundResource(C25738R.drawable.a7f);
            this.gCe.setPadding(26, 7, 0, 7);
            this.uUk.setVisibility(8);
            this.uUj.setVisibility(0);
            ImageView imageView = this.uUm;
            if (imageView.getAnimation() != null) {
                imageView.startAnimation(imageView.getAnimation());
            } else {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(500);
                alphaAnimation.setInterpolator(new LinearInterpolator());
                alphaAnimation.setRepeatCount(-1);
                alphaAnimation.setRepeatMode(2);
                imageView.startAnimation(alphaAnimation);
            }
            if (this.uUp.uOh.booleanValue()) {
                this.uNR.sendEmptyMessage(4096);
                this.uUn.setText(C25738R.string.bsh);
                this.uUo.setText(" " + C41793a.m73794B(C4996ah.getContext(), this.uUp.uOB).toString());
            } else {
                this.uUn.setText(C25738R.string.bsg);
                this.uUo.setText(" " + C41793a.m73794B(C4996ah.getContext(), (int) C41793a.m73795fY((long) this.uUp.cAP)).toString());
            }
        }
        super.mo9809a(c44001c, i, i2);
        AppMethodBeat.m2505o(27187);
    }

    public final int dfW() {
        return 4;
    }
}
