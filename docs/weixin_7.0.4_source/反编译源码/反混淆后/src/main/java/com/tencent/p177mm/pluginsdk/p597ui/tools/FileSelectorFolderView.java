package com.tencent.p177mm.pluginsdk.p597ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView */
public class FileSelectorFolderView extends LinearLayout implements OnItemClickListener {
    boolean aej = false;
    private FrameLayout mQA;
    private View mQB;
    private ListView mQC;
    private boolean mQE = false;
    private C23339a vui = null;
    private C23340b vuj;

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView$1 */
    class C47661 implements AnimationListener {
        C47661() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(28158);
            FileSelectorFolderView.this.mQA.setVisibility(8);
            FileSelectorFolderView.this.aej = false;
            FileSelectorFolderView.this.mQE = false;
            AppMethodBeat.m2505o(28158);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView$2 */
    class C149592 implements AnimationListener {
        C149592() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(28159);
            FileSelectorFolderView.this.aej = true;
            FileSelectorFolderView.this.mQE = false;
            AppMethodBeat.m2505o(28159);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView$3 */
    class C149603 implements OnClickListener {
        C149603() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(28160);
            FileSelectorFolderView.m35846c(FileSelectorFolderView.this);
            AppMethodBeat.m2505o(28160);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView$a */
    public interface C23339a {
        /* renamed from: Ls */
        void mo39076Ls(int i);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView$b */
    public static class C23340b extends BaseAdapter {
        private Context mContext;

        public C23340b(Context context) {
            this.mContext = context;
        }

        public final int getCount() {
            return 2;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(28161);
            Integer valueOf = Integer.valueOf(i);
            AppMethodBeat.m2505o(28161);
            return valueOf;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C23341c c23341c;
            AppMethodBeat.m2504i(28162);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(this.mContext).inflate(2130969571, null);
                c23341c = new C23341c(view);
                view.setTag(c23341c);
            } else {
                c23341c = (C23341c) view.getTag();
            }
            switch (i) {
                case 0:
                    c23341c.gne.setText(C25738R.string.bsw);
                    break;
                case 1:
                    c23341c.gne.setText(C25738R.string.bsx);
                    break;
                default:
                    c23341c.gne.setText(C25738R.string.f9104pl);
                    break;
            }
            AppMethodBeat.m2505o(28162);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView$c */
    static class C23341c {
        TextView gne;

        C23341c(View view) {
            AppMethodBeat.m2504i(28163);
            this.gne = (TextView) view.findViewById(2131823564);
            AppMethodBeat.m2505o(28163);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m35846c(FileSelectorFolderView fileSelectorFolderView) {
        AppMethodBeat.m2504i(28169);
        fileSelectorFolderView.mo39073hE(false);
        AppMethodBeat.m2505o(28169);
    }

    public FileSelectorFolderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(28164);
        init();
        AppMethodBeat.m2505o(28164);
    }

    public FileSelectorFolderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(28165);
        init();
        AppMethodBeat.m2505o(28165);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: hE */
    public final void mo39073hE(boolean z) {
        AppMethodBeat.m2504i(28166);
        Animation loadAnimation;
        if (this.aej == z) {
            C4990ab.m7411d("MicroMsg.FileSelectorFolderView", "want to expand, but same status, expanded %B", Boolean.valueOf(this.aej));
            AppMethodBeat.m2505o(28166);
        } else if (this.mQE) {
            C4990ab.m7411d("MicroMsg.FileSelectorFolderView", "want to expand[%B], but now in animation", Boolean.valueOf(z));
            AppMethodBeat.m2505o(28166);
        } else if (this.aej) {
            this.mQE = true;
            loadAnimation = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8373ce);
            loadAnimation.setAnimationListener(new C47661());
            this.mQC.startAnimation(loadAnimation);
            this.mQB.startAnimation(AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8333b6));
            AppMethodBeat.m2505o(28166);
        } else {
            this.mQE = true;
            this.mQA.setVisibility(0);
            this.mQB.startAnimation(AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8332b5));
            loadAnimation = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8375cg);
            loadAnimation.setAnimationListener(new C149592());
            this.mQC.startAnimation(loadAnimation);
            AppMethodBeat.m2505o(28166);
        }
    }

    private void init() {
        AppMethodBeat.m2504i(28167);
        setOrientation(1);
        this.mQA = new FrameLayout(getContext());
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        this.mQA.setVisibility(8);
        addView(this.mQA, layoutParams);
        this.mQB = new View(getContext());
        this.mQB.setBackgroundColor(-872415232);
        this.mQB.setOnClickListener(new C149603());
        this.mQA.addView(this.mQB, new FrameLayout.LayoutParams(-1, -1));
        this.mQC = new ListView(getContext());
        this.mQC.setCacheColorHint(0);
        this.mQC.setBackgroundResource(C25738R.color.f12200vs);
        this.mQC.setSelector(C25738R.drawable.f6900uv);
        this.mQC.setOnItemClickListener(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f9979m4);
        this.mQC.setPadding(dimensionPixelSize, dimensionPixelSize / 3, dimensionPixelSize, 0);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = getResources().getDimensionPixelSize(C25738R.dimen.f9778fd);
        layoutParams2.gravity = 80;
        this.mQA.addView(this.mQC, layoutParams2);
        this.vuj = new C23340b(getContext());
        this.mQC.setAdapter(this.vuj);
        AppMethodBeat.m2505o(28167);
    }

    public void setListener(C23339a c23339a) {
        this.vui = c23339a;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(28168);
        if (this.vui != null) {
            this.vui.mo39076Ls(i);
        }
        this.mQB.performClick();
        AppMethodBeat.m2505o(28168);
    }
}
