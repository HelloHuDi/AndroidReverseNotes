package com.tencent.p177mm.plugin.game.p433ui;

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
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.game.ui.GameBlockView */
public class GameBlockView extends LinearLayout {
    LayoutInflater mInflater;
    LinearLayout mpt;
    LayoutParams neY;
    C21031k neZ;
    C21009a nfa;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameBlockView$1 */
    class C210081 implements OnClickListener {
        final /* synthetic */ int nfb;

        C210081(int i) {
            this.nfb = i;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(111743);
            if (view.getTag() == null || !(view.getTag() instanceof String)) {
                AppMethodBeat.m2505o(111743);
                return;
            }
            C34277b.m56209a(GameBlockView.this.getContext(), 10, 1002, 99, C46001c.m85464t(GameBlockView.this.getContext(), (String) view.getTag(), "game_center_mygame_more"), this.nfb, null);
            AppMethodBeat.m2505o(111743);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameBlockView$a */
    static class C21009a {
        public ImageView neO;
        public TextView neP;
        public ViewGroup nfd;
        public TextView nfe;
        public GameDownloadView nff;

        private C21009a() {
        }

        /* synthetic */ C21009a(byte b) {
            this();
        }
    }

    public GameBlockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(111744);
        super.onFinishInflate();
        setOrientation(1);
        this.mInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.neY = new LayoutParams(-1, -2);
        this.mpt = this;
        this.neZ = new C21031k();
        C4990ab.m7416i("MicroMsg.GameBlockView", "initView finished");
        AppMethodBeat.m2505o(111744);
    }
}
