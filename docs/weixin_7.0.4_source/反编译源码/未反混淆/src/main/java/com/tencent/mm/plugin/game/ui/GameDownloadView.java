package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.j;
import com.tencent.mm.plugin.game.model.j.a;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public class GameDownloadView extends FrameLayout implements OnClickListener {
    private a ngQ = new a() {
        public final void f(int i, String str, boolean z) {
            AppMethodBeat.i(111895);
            if (!z || bo.isNullOrNil(str)) {
                AppMethodBeat.o(111895);
            } else if (GameDownloadView.this.ngS == null || GameDownloadView.this.ngS.mVZ == null || !GameDownloadView.this.ngS.mVZ.field_appId.equals(str)) {
                AppMethodBeat.o(111895);
            } else {
                GameDownloadView.this.refresh();
                AppMethodBeat.o(111895);
            }
        }
    };
    private k ngS;
    private Button nhX;
    private TextProgressBar nhY;
    private d nhZ;

    static /* synthetic */ void a(GameDownloadView gameDownloadView) {
        AppMethodBeat.i(111904);
        gameDownloadView.bFm();
        AppMethodBeat.o(111904);
    }

    public GameDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(111896);
        AppMethodBeat.o(111896);
    }

    public void onFinishInflate() {
        AppMethodBeat.i(111897);
        super.onFinishInflate();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.a3o, this, true);
        this.nhX = (Button) inflate.findViewById(R.id.c39);
        this.nhY = (TextProgressBar) inflate.findViewById(R.id.c3_);
        this.nhY.setTextSize(14);
        this.nhX.setOnClickListener(this);
        this.nhY.setOnClickListener(this);
        this.nhZ = new d(getContext());
        this.nhZ.neA = new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(111892);
                GameDownloadView.a(GameDownloadView.this);
                AppMethodBeat.o(111892);
            }
        };
        AppMethodBeat.o(111897);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(111898);
        super.onDetachedFromWindow();
        j.b(this.ngQ);
        AppMethodBeat.o(111898);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.i(111899);
        super.onAttachedToWindow();
        j.a(this.ngQ);
        AppMethodBeat.o(111899);
    }

    public final void refresh() {
        AppMethodBeat.i(111900);
        if (this.ngS != null) {
            this.ngS.ei(ah.getContext());
            this.ngS.biT();
            bFm();
        }
        AppMethodBeat.o(111900);
    }

    public void setDownloadInfo(k kVar) {
        AppMethodBeat.i(111901);
        this.ngS = kVar;
        c.aNS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(111893);
                GameDownloadView.this.ngS.ei(ah.getContext());
                GameDownloadView.this.ngS.biT();
                GameDownloadView.a(GameDownloadView.this);
                AppMethodBeat.o(111893);
            }
        });
        bFm();
        AppMethodBeat.o(111901);
    }

    private void bFm() {
        AppMethodBeat.i(111902);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(111894);
                GameDownloadView.this.nhZ.a(GameDownloadView.this.nhY, GameDownloadView.this.nhX, GameDownloadView.this.ngS.mVZ, GameDownloadView.this.ngS);
                AppMethodBeat.o(111894);
            }
        });
        AppMethodBeat.o(111902);
    }

    public void onClick(View view) {
        AppMethodBeat.i(111903);
        this.ngS.ei(ah.getContext());
        this.nhZ.a(this.ngS.mVZ, this.ngS);
        AppMethodBeat.o(111903);
    }
}
