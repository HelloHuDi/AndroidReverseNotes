package com.tencent.p177mm.plugin.game.p433ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.game.model.C28219aa;
import com.tencent.p177mm.plugin.game.model.C28219aa.C28220a;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p731d.C39198dk;
import com.tencent.p177mm.plugin.game.p731d.C45996dj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.game.ui.GameDetailRankLikeView */
public class GameDetailRankLikeView extends LinearLayout implements OnClickListener {
    String mAppId;
    private int mXC;
    C28219aa ngr;
    C28220a ngs;
    private Drawable ngt;
    private Drawable ngu;
    private Animation ngv;
    private ImageView ngw;
    private TextView ngx;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDetailRankLikeView$1 */
    class C282401 implements C1224a {
        C282401() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(111817);
            if (i == 0 && i2 == 0) {
                AppMethodBeat.m2505o(111817);
            } else {
                C4990ab.m7413e("MicroMsg.GameDetailRankLikeView", "CGI return is not OK. (%d, %d)(%s)", Integer.valueOf(i), Integer.valueOf(i2), str);
                AppMethodBeat.m2505o(111817);
            }
            return 0;
        }
    }

    public GameDetailRankLikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(111818);
        super.onFinishInflate();
        this.ngt = getContext().getResources().getDrawable(C25738R.drawable.aga);
        this.ngu = getContext().getResources().getDrawable(C25738R.drawable.ag_);
        this.ngv = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8389cw);
        GameDetailRankLikeView.inflate(getContext(), 2130969695, this);
        setOnClickListener(this);
        this.ngw = (ImageView) findViewById(2131824459);
        this.ngx = (TextView) findViewById(2131824460);
        AppMethodBeat.m2505o(111818);
    }

    /* Access modifiers changed, original: final */
    public final void resetState() {
        AppMethodBeat.m2504i(111819);
        if (this.ngs != null) {
            m44824hU(this.ngs.mXR);
            setCount(this.ngs.mXQ);
            AppMethodBeat.m2505o(111819);
            return;
        }
        setVisibility(8);
        AppMethodBeat.m2505o(111819);
    }

    /* renamed from: hU */
    private void m44824hU(boolean z) {
        AppMethodBeat.m2504i(111820);
        if (z) {
            this.ngw.setImageDrawable(this.ngt);
            AppMethodBeat.m2505o(111820);
            return;
        }
        this.ngw.setImageDrawable(this.ngu);
        AppMethodBeat.m2505o(111820);
    }

    private void setCount(int i) {
        AppMethodBeat.m2504i(111821);
        if (i > 99) {
            this.ngx.setText("99+");
            AppMethodBeat.m2505o(111821);
        } else if (i == 0) {
            this.ngx.setText("");
            AppMethodBeat.m2505o(111821);
        } else {
            this.ngx.setText(String.valueOf(i));
            AppMethodBeat.m2505o(111821);
        }
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(111822);
        if (C1853r.m3846Yz().equals(this.ngs.cIS)) {
            if (this.ngs.mXQ > 0) {
                Intent intent = new Intent(getContext(), GameDetailRankLikedUI.class);
                intent.putExtra("extra_appdi", this.mAppId);
                getContext().startActivity(intent);
                AppMethodBeat.m2505o(111822);
                return;
            }
        } else if (!this.ngs.mXR) {
            this.ngs.mXR = true;
            C28220a c28220a = this.ngs;
            c28220a.mXQ++;
            this.ngr.bEI();
            String str = this.mAppId;
            String str2 = this.ngs.cIS;
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new C45996dj();
            c1196a.fsK = new C39198dk();
            c1196a.uri = "/cgi-bin/mmgame-bin/upfriend";
            c1196a.fsI = 1330;
            C7472b acD = c1196a.acD();
            C45996dj c45996dj = (C45996dj) acD.fsG.fsP;
            c45996dj.mZr = str;
            c45996dj.ndF = str2;
            C1226w.m2654a(acD, new C282401());
            C34277b.m56211a(getContext(), 12, 1203, 1, 2, this.mAppId, this.mXC, null);
            resetState();
            this.ngw.startAnimation(this.ngv);
        }
        AppMethodBeat.m2505o(111822);
    }

    public void setSourceScene(int i) {
        this.mXC = i;
    }
}
