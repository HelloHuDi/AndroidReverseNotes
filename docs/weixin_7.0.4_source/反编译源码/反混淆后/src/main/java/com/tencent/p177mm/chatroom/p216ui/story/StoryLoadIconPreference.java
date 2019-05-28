package com.tencent.p177mm.chatroom.p216ui.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37932f;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.widget.StoryAvatarDotsView;
import com.tencent.p177mm.plugin.appbrand.p336ui.widget.C10929a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.chatroom.ui.story.StoryLoadIconPreference */
public class StoryLoadIconPreference extends Preference {
    private StoryAvatarDotsView eon;
    private C37932f eoo;
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
        AppMethodBeat.m2504i(104476);
        m2929bA(context);
        AppMethodBeat.m2505o(104476);
    }

    public StoryLoadIconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(104477);
        m2929bA(context);
        AppMethodBeat.m2505o(104477);
    }

    /* renamed from: bA */
    private void m2929bA(Context context) {
        AppMethodBeat.m2504i(104478);
        setLayoutResource(2130970127);
        this.mContext = context;
        AppMethodBeat.m2505o(104478);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(104479);
        if (this.mView == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
            viewGroup2.removeAllViews();
            View.inflate(this.mContext, 2130970896, viewGroup2);
            this.mView = onCreateView;
        }
        View view = this.mView;
        AppMethodBeat.m2505o(104479);
        return view;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(104480);
        super.onBindView(view);
        this.eop = C1338a.fromDPToPix(this.mContext, 21);
        this.eor = C1338a.fromDPToPix(this.mContext, 2);
        this.eoq = C1338a.fromDPToPix(this.mContext, this.eop);
        this.eon = (StoryAvatarDotsView) view.findViewById(2131828175);
        this.eon.setIconSize(this.eop + (this.eor * 2));
        this.eon.setIconGap(this.eoq / 2);
        if (this.eon != null) {
            if (this.eou.size() > 0) {
                this.eon.setVisibility(0);
                this.eon.setIconLayerCount(Math.min(this.eou.size(), 3));
                if (this.eoo == null) {
                    this.eoo = new C10929a(this.eop, this.eor);
                }
                for (int i = 0; i < this.eon.getChildCount(); i++) {
                    C40460b.m69433a(this.eon.mo28298qf(i), (String) this.eou.get(i), 0.5f, false);
                }
                AppMethodBeat.m2505o(104480);
                return;
            }
            this.eon.setVisibility(8);
        }
        AppMethodBeat.m2505o(104480);
    }
}
