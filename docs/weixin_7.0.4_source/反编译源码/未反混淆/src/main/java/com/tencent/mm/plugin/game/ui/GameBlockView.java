package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.ab;

public class GameBlockView extends LinearLayout {
    LayoutInflater mInflater;
    LinearLayout mpt;
    LayoutParams neY;
    k neZ;
    a nfa;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameBlockView$1 */
    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ int nfb;

        AnonymousClass1(int i) {
            this.nfb = i;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(111743);
            if (view.getTag() == null || !(view.getTag() instanceof String)) {
                AppMethodBeat.o(111743);
                return;
            }
            b.a(GameBlockView.this.getContext(), 10, 1002, 99, c.t(GameBlockView.this.getContext(), (String) view.getTag(), "game_center_mygame_more"), this.nfb, null);
            AppMethodBeat.o(111743);
        }
    }

    static class a {
        public ImageView neO;
        public TextView neP;
        public ViewGroup nfd;
        public TextView nfe;
        public GameDownloadView nff;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public GameBlockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(111744);
        super.onFinishInflate();
        setOrientation(1);
        this.mInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.neY = new LayoutParams(-1, -2);
        this.mpt = this;
        this.neZ = new k();
        ab.i("MicroMsg.GameBlockView", "initView finished");
        AppMethodBeat.o(111744);
    }
}
