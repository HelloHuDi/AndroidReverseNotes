package com.tencent.mm.plugin.game.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.ad;
import com.tencent.mm.plugin.game.d.an;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.Iterator;

public class GameFeedQipaiView extends LinearLayout implements OnClickListener {
    private TextView iDT;
    private TextView niH;
    private ImageView niI;
    private LinearLayout niJ;
    private ad niK;

    public GameFeedQipaiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(111945);
        super.onFinishInflate();
        this.iDT = (TextView) findViewById(R.id.cx);
        this.niH = (TextView) findViewById(R.id.c5u);
        this.niI = (ImageView) findViewById(R.id.by3);
        this.niJ = (LinearLayout) findViewById(R.id.c5v);
        this.niH.setOnClickListener(this);
        AppMethodBeat.o(111945);
    }

    public void setData(d dVar) {
        AppMethodBeat.i(111946);
        if (dVar == null || dVar.mVH == null || dVar.mVH.naJ == null) {
            setVisibility(8);
            AppMethodBeat.o(111946);
            return;
        }
        ad adVar = dVar.mVH;
        setVisibility(0);
        this.niK = adVar;
        if (bo.isNullOrNil(adVar.naJ.Title)) {
            this.iDT.setVisibility(8);
        } else {
            this.iDT.setText(adVar.naJ.Title);
            this.iDT.setVisibility(0);
        }
        if (bo.isNullOrNil(adVar.naJ.naP)) {
            this.niH.setVisibility(8);
            this.niI.setVisibility(8);
        } else {
            this.niI.setVisibility(0);
            this.niH.setVisibility(0);
            this.niH.setText(adVar.naJ.naP);
        }
        this.niJ.removeAllViews();
        if (!bo.ek(adVar.naJ.mZK)) {
            Iterator it = adVar.naJ.mZK.iterator();
            while (it.hasNext()) {
                an anVar = (an) it.next();
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.a2l, this, false);
                inflate.setOnClickListener(this);
                inflate.setTag(Integer.valueOf(adVar.naJ.mZK.indexOf(anVar)));
                this.niJ.addView(inflate, new LayoutParams(-1, -2, 1.0f));
                TextView textView = (TextView) inflate.findViewById(R.id.c16);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.c17);
                TextView textView2 = (TextView) inflate.findViewById(R.id.c18);
                TextView textView3 = (TextView) inflate.findViewById(R.id.c19);
                textView.setVisibility(8);
                e.bFH().h(imageView, anVar.nbe);
                textView2.setText(anVar.Title);
                textView3.setText(anVar.Desc);
            }
        }
        if (!dVar.mVJ) {
            a.a(getContext(), 10, FilterEnum4Shaka.MIC_SHAKA_ADD_4, dVar.position, dVar.mVH.fKh, GameIndexListView.getSourceScene(), a.kY(dVar.mVH.mZL));
            dVar.mVJ = true;
        }
        AppMethodBeat.o(111946);
    }

    public void onClick(View view) {
        AppMethodBeat.i(111947);
        if (this.niK == null) {
            AppMethodBeat.o(111947);
        } else if (view.getId() == R.id.c5u) {
            if (!bo.isNullOrNil(this.niK.naJ.nbi)) {
                b.a(getContext(), 10, FilterEnum4Shaka.MIC_SHAKA_ADD_4, 999, c.ax(getContext(), this.niK.naJ.nbi), null, GameIndexListView.getSourceScene(), a.kY(this.niK.mZL));
            }
            AppMethodBeat.o(111947);
        } else {
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue < 0 || intValue > this.niK.naJ.mZK.size() - 1) {
                AppMethodBeat.o(111947);
                return;
            }
            an anVar = (an) this.niK.naJ.mZK.get(intValue);
            if (!bo.isNullOrNil(anVar.mZj)) {
                b.a(getContext(), 10, FilterEnum4Shaka.MIC_SHAKA_ADD_4, intValue + 1, c.ax(getContext(), anVar.mZj), anVar.fKh, GameIndexListView.getSourceScene(), a.kY(this.niK.mZL));
            }
            AppMethodBeat.o(111947);
        }
    }
}
