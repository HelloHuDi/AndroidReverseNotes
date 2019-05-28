package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.game.d.dj;
import com.tencent.mm.plugin.game.d.dk;
import com.tencent.mm.plugin.game.model.aa;
import com.tencent.mm.plugin.game.model.aa.a;
import com.tencent.mm.sdk.platformtools.ab;

public class GameDetailRankLikeView extends LinearLayout implements OnClickListener {
    String mAppId;
    private int mXC;
    aa ngr;
    a ngs;
    private Drawable ngt;
    private Drawable ngu;
    private Animation ngv;
    private ImageView ngw;
    private TextView ngx;

    public GameDetailRankLikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(111818);
        super.onFinishInflate();
        this.ngt = getContext().getResources().getDrawable(R.drawable.aga);
        this.ngu = getContext().getResources().getDrawable(R.drawable.ag_);
        this.ngv = AnimationUtils.loadAnimation(getContext(), R.anim.cw);
        inflate(getContext(), R.layout.a3f, this);
        setOnClickListener(this);
        this.ngw = (ImageView) findViewById(R.id.c4t);
        this.ngx = (TextView) findViewById(R.id.c4u);
        AppMethodBeat.o(111818);
    }

    /* Access modifiers changed, original: final */
    public final void resetState() {
        AppMethodBeat.i(111819);
        if (this.ngs != null) {
            hU(this.ngs.mXR);
            setCount(this.ngs.mXQ);
            AppMethodBeat.o(111819);
            return;
        }
        setVisibility(8);
        AppMethodBeat.o(111819);
    }

    private void hU(boolean z) {
        AppMethodBeat.i(111820);
        if (z) {
            this.ngw.setImageDrawable(this.ngt);
            AppMethodBeat.o(111820);
            return;
        }
        this.ngw.setImageDrawable(this.ngu);
        AppMethodBeat.o(111820);
    }

    private void setCount(int i) {
        AppMethodBeat.i(111821);
        if (i > 99) {
            this.ngx.setText("99+");
            AppMethodBeat.o(111821);
        } else if (i == 0) {
            this.ngx.setText("");
            AppMethodBeat.o(111821);
        } else {
            this.ngx.setText(String.valueOf(i));
            AppMethodBeat.o(111821);
        }
    }

    public void onClick(View view) {
        AppMethodBeat.i(111822);
        if (r.Yz().equals(this.ngs.cIS)) {
            if (this.ngs.mXQ > 0) {
                Intent intent = new Intent(getContext(), GameDetailRankLikedUI.class);
                intent.putExtra("extra_appdi", this.mAppId);
                getContext().startActivity(intent);
                AppMethodBeat.o(111822);
                return;
            }
        } else if (!this.ngs.mXR) {
            this.ngs.mXR = true;
            a aVar = this.ngs;
            aVar.mXQ++;
            this.ngr.bEI();
            String str = this.mAppId;
            String str2 = this.ngs.cIS;
            b.a aVar2 = new b.a();
            aVar2.fsJ = new dj();
            aVar2.fsK = new dk();
            aVar2.uri = "/cgi-bin/mmgame-bin/upfriend";
            aVar2.fsI = 1330;
            b acD = aVar2.acD();
            dj djVar = (dj) acD.fsG.fsP;
            djVar.mZr = str;
            djVar.ndF = str2;
            w.a(acD, new w.a() {
                public final int a(int i, int i2, String str, b bVar, m mVar) {
                    AppMethodBeat.i(111817);
                    if (i == 0 && i2 == 0) {
                        AppMethodBeat.o(111817);
                    } else {
                        ab.e("MicroMsg.GameDetailRankLikeView", "CGI return is not OK. (%d, %d)(%s)", Integer.valueOf(i), Integer.valueOf(i2), str);
                        AppMethodBeat.o(111817);
                    }
                    return 0;
                }
            });
            com.tencent.mm.plugin.game.e.b.a(getContext(), 12, 1203, 1, 2, this.mAppId, this.mXC, null);
            resetState();
            this.ngw.startAnimation(this.ngv);
        }
        AppMethodBeat.o(111822);
    }

    public void setSourceScene(int i) {
        this.mXC = i;
    }
}
