package com.tencent.p177mm.plugin.nearlife.p471ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.nearlife.ui.NearLifeErrorContent */
public class NearLifeErrorContent extends FrameLayout {
    private View contentView;
    private ListView gKd;
    private Context mContext;
    private TextView oSL;
    private View oSM;

    public NearLifeErrorContent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(22990);
        this.mContext = context;
        init();
        AppMethodBeat.m2505o(22990);
    }

    public NearLifeErrorContent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(22991);
        this.mContext = context;
        init();
        AppMethodBeat.m2505o(22991);
    }

    private void init() {
        AppMethodBeat.m2504i(22992);
        this.contentView = View.inflate(this.mContext, 2130970283, this);
        this.oSL = (TextView) this.contentView.findViewById(2131826287);
        this.oSM = this.contentView.findViewById(2131826288);
        AppMethodBeat.m2505o(22992);
    }

    public void setListView(ListView listView) {
        this.gKd = listView;
    }

    /* renamed from: Af */
    public final void mo8077Af(int i) {
        AppMethodBeat.m2504i(22993);
        switch (i) {
            case 0:
                this.oSL.setVisibility(8);
                this.oSM.setVisibility(8);
                this.gKd.setVisibility(0);
                AppMethodBeat.m2505o(22993);
                return;
            case 1:
                this.oSL.setVisibility(0);
                this.oSM.setVisibility(8);
                this.gKd.setVisibility(8);
                AppMethodBeat.m2505o(22993);
                return;
            case 2:
                this.oSL.setVisibility(8);
                this.oSM.setVisibility(0);
                this.gKd.setVisibility(8);
                break;
        }
        AppMethodBeat.m2505o(22993);
    }
}
