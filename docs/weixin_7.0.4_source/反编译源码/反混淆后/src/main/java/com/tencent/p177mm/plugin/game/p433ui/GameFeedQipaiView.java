package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.model.C28226d;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C28203e;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p731d.C12110ad;
import com.tencent.p177mm.plugin.game.p731d.C6933an;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.game.ui.GameFeedQipaiView */
public class GameFeedQipaiView extends LinearLayout implements OnClickListener {
    private TextView iDT;
    private TextView niH;
    private ImageView niI;
    private LinearLayout niJ;
    private C12110ad niK;

    public GameFeedQipaiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(111945);
        super.onFinishInflate();
        this.iDT = (TextView) findViewById(2131820678);
        this.niH = (TextView) findViewById(2131824497);
        this.niI = (ImageView) findViewById(2131824210);
        this.niJ = (LinearLayout) findViewById(2131824498);
        this.niH.setOnClickListener(this);
        AppMethodBeat.m2505o(111945);
    }

    public void setData(C28226d c28226d) {
        AppMethodBeat.m2504i(111946);
        if (c28226d == null || c28226d.mVH == null || c28226d.mVH.naJ == null) {
            setVisibility(8);
            AppMethodBeat.m2505o(111946);
            return;
        }
        C12110ad c12110ad = c28226d.mVH;
        setVisibility(0);
        this.niK = c12110ad;
        if (C5046bo.isNullOrNil(c12110ad.naJ.Title)) {
            this.iDT.setVisibility(8);
        } else {
            this.iDT.setText(c12110ad.naJ.Title);
            this.iDT.setVisibility(0);
        }
        if (C5046bo.isNullOrNil(c12110ad.naJ.naP)) {
            this.niH.setVisibility(8);
            this.niI.setVisibility(8);
        } else {
            this.niI.setVisibility(0);
            this.niH.setVisibility(0);
            this.niH.setText(c12110ad.naJ.naP);
        }
        this.niJ.removeAllViews();
        if (!C5046bo.m7548ek(c12110ad.naJ.mZK)) {
            Iterator it = c12110ad.naJ.mZK.iterator();
            while (it.hasNext()) {
                C6933an c6933an = (C6933an) it.next();
                View inflate = LayoutInflater.from(getContext()).inflate(2130969664, this, false);
                inflate.setOnClickListener(this);
                inflate.setTag(Integer.valueOf(c12110ad.naJ.mZK.indexOf(c6933an)));
                this.niJ.addView(inflate, new LayoutParams(-1, -2, 1.0f));
                TextView textView = (TextView) inflate.findViewById(2131824324);
                ImageView imageView = (ImageView) inflate.findViewById(2131824325);
                TextView textView2 = (TextView) inflate.findViewById(2131824326);
                TextView textView3 = (TextView) inflate.findViewById(2131824327);
                textView.setVisibility(8);
                C28203e.bFH().mo46100h(imageView, c6933an.nbe);
                textView2.setText(c6933an.Title);
                textView3.setText(c6933an.Desc);
            }
        }
        if (!c28226d.mVJ) {
            C34276a.m56205a(getContext(), 10, FilterEnum4Shaka.MIC_SHAKA_ADD_4, c28226d.position, c28226d.mVH.fKh, GameIndexListView.getSourceScene(), C34276a.m56208kY(c28226d.mVH.mZL));
            c28226d.mVJ = true;
        }
        AppMethodBeat.m2505o(111946);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(111947);
        if (this.niK == null) {
            AppMethodBeat.m2505o(111947);
        } else if (view.getId() == 2131824497) {
            if (!C5046bo.isNullOrNil(this.niK.naJ.nbi)) {
                C34277b.m56211a(getContext(), 10, FilterEnum4Shaka.MIC_SHAKA_ADD_4, 999, C46001c.m85455ax(getContext(), this.niK.naJ.nbi), null, GameIndexListView.getSourceScene(), C34276a.m56208kY(this.niK.mZL));
            }
            AppMethodBeat.m2505o(111947);
        } else {
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue < 0 || intValue > this.niK.naJ.mZK.size() - 1) {
                AppMethodBeat.m2505o(111947);
                return;
            }
            C6933an c6933an = (C6933an) this.niK.naJ.mZK.get(intValue);
            if (!C5046bo.isNullOrNil(c6933an.mZj)) {
                C34277b.m56211a(getContext(), 10, FilterEnum4Shaka.MIC_SHAKA_ADD_4, intValue + 1, C46001c.m85455ax(getContext(), c6933an.mZj), c6933an.fKh, GameIndexListView.getSourceScene(), C34276a.m56208kY(this.niK.mZL));
            }
            AppMethodBeat.m2505o(111947);
        }
    }
}
