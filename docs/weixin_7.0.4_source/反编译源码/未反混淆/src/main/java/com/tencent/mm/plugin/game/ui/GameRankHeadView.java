package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.j;
import com.tencent.mm.plugin.game.model.j.a;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;

public class GameRankHeadView extends LinearLayout implements OnClickListener {
    private TextView gsf;
    private c mYa;
    a ngQ;
    private k ngS;
    private TextView ngo;
    private TextView nlM;
    private ImageView nlN;

    static /* synthetic */ void c(GameRankHeadView gameRankHeadView) {
        AppMethodBeat.i(112149);
        gameRankHeadView.bFm();
        AppMethodBeat.o(112149);
    }

    public GameRankHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(112145);
        super.onFinishInflate();
        this.gsf = (TextView) findViewById(R.id.c54);
        this.nlM = (TextView) findViewById(R.id.c55);
        this.ngo = (TextView) findViewById(R.id.c56);
        this.nlN = (ImageView) findViewById(R.id.c57);
        ab.i("MicroMsg.GameRankHeadView", "initView finished");
        AppMethodBeat.o(112145);
    }

    private void bFm() {
        AppMethodBeat.i(112146);
        if (g.a(getContext(), this.mYa)) {
            if (this.mYa.versionCode > com.tencent.mm.plugin.game.f.c.Or(this.mYa.field_packageName)) {
                this.ngo.setText(R.string.c55);
                AppMethodBeat.o(112146);
                return;
            }
            this.ngo.setText(R.string.c53);
            AppMethodBeat.o(112146);
            return;
        }
        switch (this.mYa.status) {
            case 0:
                if (this.ngS == null) {
                    this.ngo.setVisibility(8);
                    this.nlN.setVisibility(8);
                    AppMethodBeat.o(112146);
                    return;
                }
                this.ngo.setVisibility(0);
                this.nlN.setVisibility(0);
                switch (this.ngS.status) {
                    case 0:
                        this.ngo.setText(R.string.c50);
                        AppMethodBeat.o(112146);
                        return;
                    case 1:
                        this.ngo.setText(R.string.c51);
                        AppMethodBeat.o(112146);
                        return;
                    case 2:
                        this.ngo.setText(R.string.c4z);
                        AppMethodBeat.o(112146);
                        return;
                    case 3:
                        this.ngo.setText(R.string.c52);
                        break;
                }
                AppMethodBeat.o(112146);
                return;
            default:
                this.ngo.setText(R.string.c50);
                AppMethodBeat.o(112146);
                return;
        }
    }

    public void setData(GameDetailRankUI.a aVar) {
        AppMethodBeat.i(112147);
        this.gsf.setText(aVar.ngJ);
        this.nlM.setText(aVar.ngK);
        this.mYa = aVar.ngL;
        this.mYa.cKG = 1203;
        this.mYa.position = 2;
        if (this.ngS == null) {
            this.ngS = new k(this.mYa);
        }
        this.ngS.ei(getContext());
        this.ngS.biT();
        bFm();
        if (this.ngQ != null) {
            j.a(this.ngQ);
        } else {
            this.ngQ = new a() {
                public final void f(int i, String str, boolean z) {
                    AppMethodBeat.i(112144);
                    if (GameRankHeadView.this.mYa != null) {
                        GameRankHeadView.this.ngS.ei(GameRankHeadView.this.getContext());
                        GameRankHeadView.this.ngS.biT();
                        if (z) {
                            GameRankHeadView.c(GameRankHeadView.this);
                        }
                    }
                    AppMethodBeat.o(112144);
                }
            };
            j.a(this.ngQ);
        }
        this.ngo.setOnClickListener(this);
        AppMethodBeat.o(112147);
    }

    public void onClick(View view) {
        AppMethodBeat.i(112148);
        new d(getContext()).a(this.mYa, new k(this.mYa));
        AppMethodBeat.o(112148);
    }
}
