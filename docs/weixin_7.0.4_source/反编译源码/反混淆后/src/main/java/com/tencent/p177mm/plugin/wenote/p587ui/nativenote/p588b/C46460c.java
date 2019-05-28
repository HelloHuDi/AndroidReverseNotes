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
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.voiceview.NoteEditorVoiceBaseView;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.c */
public final class C46460c extends C14790i {
    private final C7306ak uNR = new C231882();
    public LinearLayout uUj;
    public LinearLayout uUk;
    public NoteEditorVoiceBaseView uUl;
    public ImageView uUm;
    private TextView uUn;
    private TextView uUo;
    private C44003l uUp;

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.c$1 */
    class C231871 implements OnClickListener {
        C231871() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27151);
            if (C46460c.this.uUp != null && C46460c.this.uUp.uOh.booleanValue()) {
                C46460c.this.uUp.uOi = Boolean.TRUE;
            }
            AppMethodBeat.m2505o(27151);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.c$2 */
    class C231882 extends C7306ak {
        C231882() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(27152);
            if (C46460c.this.uUp.uOp) {
                C46460c.this.uNR.removeMessages(4096);
                AppMethodBeat.m2505o(27152);
                return;
            }
            C46460c.this.uUo.setText(" " + C41793a.m73794B(C4996ah.getContext(), C46460c.this.uUp.uOB).toString());
            sendEmptyMessageDelayed(4096, 500);
            AppMethodBeat.m2505o(27152);
        }
    }

    public C46460c(View view, C46457k c46457k) {
        super(view, c46457k);
        AppMethodBeat.m2504i(27153);
        this.uUj = (LinearLayout) view.findViewById(2131826392);
        this.uUk = (LinearLayout) view.findViewById(2131826398);
        this.uUm = (ImageView) view.findViewById(2131826393);
        this.uUn = (TextView) view.findViewById(2131826394);
        this.uUo = (TextView) view.findViewById(2131826395);
        this.uUl = (NoteEditorVoiceBaseView) view.findViewById(2131826399);
        C44019a.dfY().mo69695a(this.uUl);
        this.gCe.setVisibility(0);
        this.uUj.setVisibility(8);
        this.uUk.setVisibility(0);
        this.cAw.setVisibility(8);
        this.uUB.setVisibility(8);
        this.gCe.setOnClickListener(new C231871());
        AppMethodBeat.m2505o(27153);
    }

    /* renamed from: a */
    public final void mo9809a(C44001c c44001c, int i, int i2) {
        AppMethodBeat.m2504i(27154);
        this.uUp = (C44003l) c44001c;
        if (this.uUp.uOp) {
            this.uUk.setVisibility(0);
            this.uUj.setVisibility(8);
            this.gCe.setPadding(0, 0, 0, 0);
            if (c44001c.uOa) {
                this.uUl.setBackgroundResource(C25738R.drawable.a70);
            } else {
                this.uUl.setBackgroundResource(C25738R.drawable.a6z);
            }
            NoteEditorVoiceBaseView noteEditorVoiceBaseView = this.uUl;
            String str = this.uUp.cHg;
            int i3 = this.uUp.cAO;
            String str2 = this.uUp.uOC;
            noteEditorVoiceBaseView.path = C5046bo.m7532bc(str, "");
            noteEditorVoiceBaseView.cAO = i3;
            noteEditorVoiceBaseView.setText(str2);
        } else {
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
        AppMethodBeat.m2505o(27154);
    }

    public final int dfW() {
        return 20;
    }
}
