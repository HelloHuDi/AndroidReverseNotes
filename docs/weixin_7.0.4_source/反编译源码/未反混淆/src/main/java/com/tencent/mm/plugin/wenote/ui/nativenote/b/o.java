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
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteVoiceView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

public final class o extends i {
    private LinearLayout gCe;
    private final ak uNR = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(27185);
            if (o.this.uUp.uOp) {
                o.this.uNR.removeMessages(4096);
                AppMethodBeat.o(27185);
                return;
            }
            o.this.uUo.setText(" " + a.B(ah.getContext(), o.this.uUp.uOB).toString());
            sendEmptyMessageDelayed(4096, 500);
            AppMethodBeat.o(27185);
        }
    };
    public LinearLayout uUj;
    public LinearLayout uUk;
    public ImageView uUm;
    private TextView uUn;
    private TextView uUo;
    private l uUp;
    public NoteVoiceView uVe;

    public o(View view, k kVar) {
        super(view, kVar);
        AppMethodBeat.i(27186);
        this.gCe = (LinearLayout) view.findViewById(R.id.dj2);
        this.uUj = (LinearLayout) view.findViewById(R.id.dj3);
        this.uUk = (LinearLayout) view.findViewById(R.id.dj7);
        this.uUm = (ImageView) view.findViewById(R.id.dj4);
        this.uUn = (TextView) view.findViewById(R.id.dj5);
        this.uUo = (TextView) view.findViewById(R.id.dj6);
        this.uVe = (NoteVoiceView) view.findViewById(R.id.dj8);
        this.uVe.setVoiceHelper(com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.dfY());
        this.gCe.setVisibility(0);
        this.uUj.setVisibility(8);
        this.uUk.setVisibility(0);
        this.cAw.setVisibility(8);
        this.uUB.setVisibility(8);
        this.gCe.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(27184);
                if (o.this.uUp != null && o.this.uUp.uOh.booleanValue()) {
                    o.this.uUp.uOi = Boolean.TRUE;
                }
                AppMethodBeat.o(27184);
            }
        });
        AppMethodBeat.o(27186);
    }

    public final void a(c cVar, int i, int i2) {
        AppMethodBeat.i(27187);
        this.uUp = (l) cVar;
        if (this.uUp.uOp) {
            boolean z;
            this.gCe.setBackgroundResource(0);
            this.uUk.setVisibility(0);
            this.uUj.setVisibility(8);
            this.gCe.setPadding(0, 0, 0, 0);
            if (cVar.uOa) {
                z = true;
            } else {
                z = false;
            }
            NoteVoiceView noteVoiceView = this.uVe;
            String str = this.uUp.cHg;
            int i3 = this.uUp.cAO;
            int i4 = this.uUp.cAP;
            noteVoiceView.path = bo.bc(str, "");
            noteVoiceView.cAO = i3;
            noteVoiceView.duration = i4;
            if (z) {
                noteVoiceView.iVh.setVisibility(0);
            } else {
                noteVoiceView.iVh.setVisibility(8);
            }
            NoteVoiceView.a aVar;
            if (!noteVoiceView.path.equals(noteVoiceView.uVk.path)) {
                noteVoiceView.uVl.vD(i4);
            } else if (noteVoiceView.uVk.buH()) {
                ab.i("MicroMsg.NoteVoiceView", "updateInfo .isPlay()");
                aVar = noteVoiceView.uVl;
                noteVoiceView.uVk.Ez();
                aVar.os(true);
            } else {
                com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a aVar2 = noteVoiceView.uVk;
                if (aVar2.mfO == null) {
                    ab.w("MicroMsg.RecordVoiceHelper", "check is pause, but player is null");
                    z = false;
                } else {
                    z = aVar2.mfO.DA();
                }
                if (z) {
                    ab.i("MicroMsg.NoteVoiceView", "updateInfo .isPause()");
                    aVar = noteVoiceView.uVl;
                    noteVoiceView.uVk.Ez();
                    aVar.os(false);
                } else {
                    noteVoiceView.uVl.vD(i4);
                }
            }
        } else {
            this.gCe.setBackgroundResource(R.drawable.a7f);
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
        AppMethodBeat.o(27187);
    }

    public final int dfW() {
        return 4;
    }
}
