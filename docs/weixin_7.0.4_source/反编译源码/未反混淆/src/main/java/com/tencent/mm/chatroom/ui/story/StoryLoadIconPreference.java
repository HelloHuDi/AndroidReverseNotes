package com.tencent.mm.chatroom.ui.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.StoryAvatarDotsView;
import java.util.ArrayList;

public class StoryLoadIconPreference extends Preference {
    private StoryAvatarDotsView eon;
    private f eoo;
    private int eop;
    private int eoq;
    private int eor;
    private final int eos = -1;
    private int eot = -1;
    private ArrayList<String> eou = new ArrayList();
    private Context mContext;
    private View mView = null;

    public StoryLoadIconPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(104476);
        bA(context);
        AppMethodBeat.o(104476);
    }

    public StoryLoadIconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(104477);
        bA(context);
        AppMethodBeat.o(104477);
    }

    private void bA(Context context) {
        AppMethodBeat.i(104478);
        setLayoutResource(R.layout.ae4);
        this.mContext = context;
        AppMethodBeat.o(104478);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(104479);
        if (this.mView == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
            viewGroup2.removeAllViews();
            View.inflate(this.mContext, R.layout.ayw, viewGroup2);
            this.mView = onCreateView;
        }
        View view = this.mView;
        AppMethodBeat.o(104479);
        return view;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(104480);
        super.onBindView(view);
        this.eop = a.fromDPToPix(this.mContext, 21);
        this.eor = a.fromDPToPix(this.mContext, 2);
        this.eoq = a.fromDPToPix(this.mContext, this.eop);
        this.eon = (StoryAvatarDotsView) view.findViewById(R.id.eu_);
        this.eon.setIconSize(this.eop + (this.eor * 2));
        this.eon.setIconGap(this.eoq / 2);
        if (this.eon != null) {
            if (this.eou.size() > 0) {
                this.eon.setVisibility(0);
                this.eon.setIconLayerCount(Math.min(this.eou.size(), 3));
                if (this.eoo == null) {
                    this.eoo = new com.tencent.mm.plugin.appbrand.ui.widget.a(this.eop, this.eor);
                }
                for (int i = 0; i < this.eon.getChildCount(); i++) {
                    b.a(this.eon.qf(i), (String) this.eou.get(i), 0.5f, false);
                }
                AppMethodBeat.o(104480);
                return;
            }
            this.eon.setVisibility(8);
        }
        AppMethodBeat.o(104480);
    }
}
