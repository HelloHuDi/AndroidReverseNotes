package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteEditorVoiceBaseView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

public final class c extends i {
    private final ak uNR = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(27152);
            if (c.this.uUp.uOp) {
                c.this.uNR.removeMessages(4096);
                AppMethodBeat.o(27152);
                return;
            }
            c.this.uUo.setText(" " + a.B(ah.getContext(), c.this.uUp.uOB).toString());
            sendEmptyMessageDelayed(4096, 500);
            AppMethodBeat.o(27152);
        }
    };
    public LinearLayout uUj;
    public LinearLayout uUk;
    public NoteEditorVoiceBaseView uUl;
    public ImageView uUm;
    private TextView uUn;
    private TextView uUo;
    private l uUp;

    public c(View view, k kVar) {
        super(view, kVar);
        AppMethodBeat.i(27153);
        this.uUj = (LinearLayout) view.findViewById(R.id.dj3);
        this.uUk = (LinearLayout) view.findViewById(R.id.dj9);
        this.uUm = (ImageView) view.findViewById(R.id.dj4);
        this.uUn = (TextView) view.findViewById(R.id.dj5);
        this.uUo = (TextView) view.findViewById(R.id.dj6);
        this.uUl = (NoteEditorVoiceBaseView) view.findViewById(R.id.dj_);
        com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.dfY().a(this.uUl);
        this.gCe.setVisibility(0);
        this.uUj.setVisibility(8);
        this.uUk.setVisibility(0);
        this.cAw.setVisibility(8);
        this.uUB.setVisibility(8);
        this.gCe.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(27151);
                if (c.this.uUp != null && c.this.uUp.uOh.booleanValue()) {
                    c.this.uUp.uOi = Boolean.TRUE;
                }
                AppMethodBeat.o(27151);
            }
        });
        AppMethodBeat.o(27153);
    }

    public final void a(com.tencent.mm.plugin.wenote.model.a.c cVar, int i, int i2) {
        AppMethodBeat.i(27154);
        this.uUp = (l) cVar;
        if (this.uUp.uOp) {
            this.uUk.setVisibility(0);
            this.uUj.setVisibility(8);
            this.gCe.setPadding(0, 0, 0, 0);
            if (cVar.uOa) {
                this.uUl.setBackgroundResource(R.drawable.a70);
            } else {
                this.uUl.setBackgroundResource(R.drawable.a6z);
            }
            NoteEditorVoiceBaseView noteEditorVoiceBaseView = this.uUl;
            String str = this.uUp.cHg;
            int i3 = this.uUp.cAO;
            String str2 = this.uUp.uOC;
            noteEditorVoiceBaseView.path = bo.bc(str, "");
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
                this.uUn.setText(R.string.bsh);
                this.uUo.setText(" " + a.B(ah.getContext(), this.uUp.uOB).toString());
            } else {
                this.uUn.setText(R.string.bsg);
                this.uUo.setText(" " + a.B(ah.getContext(), (int) a.fY((long) this.uUp.cAP)).toString());
            }
        }
        super.a(cVar, i, i2);
        AppMethodBeat.o(27154);
    }

    public final int dfW() {
        return 20;
    }
}
