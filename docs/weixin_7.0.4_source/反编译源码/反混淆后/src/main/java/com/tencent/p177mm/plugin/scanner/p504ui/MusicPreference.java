package com.tencent.p177mm.plugin.scanner.p504ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.plugin.scanner.ui.MusicPreference */
public class MusicPreference extends Preference {
    private boolean isPlaying;
    private View mView;
    private OnClickListener pLd;
    public String pZl;
    public String pZm;
    public String pZn;
    C28903a qcA;
    private ImageButton qcz;

    /* renamed from: com.tencent.mm.plugin.scanner.ui.MusicPreference$a */
    public interface C28903a {
        /* renamed from: d */
        void mo37172d(MusicPreference musicPreference);
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.MusicPreference$1 */
    class C289041 implements OnClickListener {
        C289041() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(81035);
            if (MusicPreference.this.qcA == null) {
                AppMethodBeat.m2505o(81035);
                return;
            }
            if (view.getId() == 2131826075) {
                if (MusicPreference.this.isPlaying) {
                    MusicPreference.this.isPlaying = false;
                    MusicPreference.this.qcz.setImageResource(C25738R.drawable.f6968x5);
                } else {
                    MusicPreference.this.isPlaying = true;
                    MusicPreference.this.qcz.setImageResource(C25738R.drawable.f6969x6);
                }
                MusicPreference.this.qcA.mo37172d(MusicPreference.this);
            }
            AppMethodBeat.m2505o(81035);
        }
    }

    public MusicPreference(Context context) {
        this(context, null);
    }

    public MusicPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MusicPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(81036);
        this.mView = null;
        this.qcz = null;
        this.pZl = "";
        this.pZm = "";
        this.pZn = "";
        setLayoutResource(2130970195);
        AppMethodBeat.m2505o(81036);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(81037);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.m2505o(81037);
        return view2;
    }

    /* renamed from: kk */
    public final void mo47018kk(boolean z) {
        AppMethodBeat.m2504i(81038);
        this.isPlaying = z;
        if (this.qcz != null) {
            if (z) {
                this.qcz.setImageResource(C25738R.drawable.f6969x6);
                AppMethodBeat.m2505o(81038);
                return;
            }
            this.qcz.setImageResource(C25738R.drawable.f6968x5);
        }
        AppMethodBeat.m2505o(81038);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(81039);
        super.onBindView(view);
        if (this.pLd == null) {
            this.pLd = new C289041();
        }
        this.qcz = (ImageButton) view.findViewById(2131826075);
        this.qcz.setOnClickListener(this.pLd);
        if (this.isPlaying) {
            this.qcz.setImageResource(C25738R.drawable.f6969x6);
            AppMethodBeat.m2505o(81039);
            return;
        }
        this.qcz.setImageResource(C25738R.drawable.f6968x5);
        AppMethodBeat.m2505o(81039);
    }
}
