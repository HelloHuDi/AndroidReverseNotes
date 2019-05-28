package com.tencent.p177mm.p612ui.base.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.base.preference.KeyValuePreference */
public class KeyValuePreference extends Preference {
    private View contentView;
    protected TextView gne;
    public float nnX;
    protected TextView pnu;
    public boolean yCj;
    private boolean yCk;
    private boolean yCl;
    private boolean yCm;
    private int yCn;
    private int yCo;
    public int yCp;
    protected ImageView yCq;
    public Drawable yCr;
    private List<View> yCs;
    public int yCt;
    int yCu;
    public String ylA;

    /* renamed from: com.tencent.mm.ui.base.preference.KeyValuePreference$2 */
    class C249472 implements OnLongClickListener {
        C249472() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(107200);
            boolean cbK = KeyValuePreference.this.yCY.cbK();
            AppMethodBeat.m2505o(107200);
            return cbK;
        }
    }

    /* renamed from: com.tencent.mm.ui.base.preference.KeyValuePreference$1 */
    class C249481 implements OnClickListener {
        C249481() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(107199);
            KeyValuePreference.this.yCX.car();
            AppMethodBeat.m2505o(107199);
        }
    }

    public KeyValuePreference(Context context) {
        this(context, null);
    }

    public KeyValuePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KeyValuePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(107201);
        this.yCj = true;
        this.yCk = false;
        this.ylA = null;
        this.yCl = false;
        this.yCm = false;
        this.yCn = 17;
        this.yCo = 17;
        this.yCp = 0;
        this.yCq = null;
        this.yCr = null;
        this.yCs = new LinkedList();
        setLayoutResource(2130970127);
        AppMethodBeat.m2505o(107201);
    }

    /* Access modifiers changed, original: protected */
    public View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(107202);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130970153, viewGroup2);
        AppMethodBeat.m2505o(107202);
        return onCreateView;
    }

    public void onBindView(View view) {
        LinearLayout linearLayout;
        AppMethodBeat.m2504i(107203);
        super.onBindView(view);
        this.contentView = view.findViewById(2131821019);
        if (this.yCX != null) {
            this.contentView.setOnClickListener(new C249481());
        }
        if (this.yCY != null) {
            view.setOnLongClickListener(new C249472());
        }
        this.pnu = (TextView) view.findViewById(16908304);
        if (this.pnu != null) {
            this.pnu.setSingleLine(this.yCj);
            if (this.yCm) {
                this.pnu.setGravity(this.yCo);
            }
        }
        if (this.yCk) {
            setWidgetLayoutResource(2130970202);
        }
        this.gne = (TextView) view.findViewById(16908310);
        if (!C5046bo.isNullOrNil(this.ylA)) {
            this.gne.setText(this.ylA);
        }
        if (this.gne != null) {
            LayoutParams layoutParams = this.gne.getLayoutParams();
            layoutParams.width = this.yCt == 0 ? C1338a.m2856al(this.mContext, C25738R.dimen.f9862i8) : this.yCt;
            this.gne.setLayoutParams(layoutParams);
        }
        this.yCq = (ImageView) view.findViewById(2131822184);
        if (this.yCr != null) {
            this.yCq.setVisibility(this.yCp);
            this.yCq.setImageDrawable(this.yCr);
        } else {
            this.yCq.setVisibility(8);
        }
        if (this.yCl) {
            linearLayout = (LinearLayout) view.findViewById(2131821064);
            if (linearLayout != null) {
                linearLayout.setGravity(this.yCn);
            }
        }
        if (this.yCs.size() > 0) {
            linearLayout = (LinearLayout) view.findViewById(2131826040);
            linearLayout.removeAllViews();
            for (View view2 : this.yCs) {
                ViewGroup viewGroup = (ViewGroup) view2.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view2);
                }
                linearLayout.addView(view2);
            }
        }
        if (this.nnX != 0.0f) {
            this.gne.setTextSize(this.nnX);
            this.pnu.setTextSize(this.nnX);
        }
        if (this.yCu > 0) {
            this.pnu.setMaxLines(this.yCu);
        }
        AppMethodBeat.m2505o(107203);
    }

    /* renamed from: NT */
    public final void mo41839NT(int i) {
        AppMethodBeat.m2504i(107204);
        this.yCu = i;
        if (this.pnu != null) {
            this.pnu.setMaxLines(this.yCu);
        }
        AppMethodBeat.m2505o(107204);
    }

    /* renamed from: qi */
    public final void mo41844qi(boolean z) {
        AppMethodBeat.m2504i(107205);
        this.yCk = z;
        if (this.yCk) {
            setWidgetLayoutResource(2130970202);
        }
        AppMethodBeat.m2505o(107205);
    }

    public final void dAB() {
        this.yCm = true;
        this.yCo = 5;
    }

    public final void dAC() {
        AppMethodBeat.m2504i(107206);
        this.yCs.clear();
        AppMethodBeat.m2505o(107206);
    }

    /* renamed from: eI */
    public final void mo41843eI(View view) {
        AppMethodBeat.m2504i(107207);
        this.yCs.add(view);
        AppMethodBeat.m2505o(107207);
    }

    public final void dAD() {
        this.yCl = true;
        this.yCn = 49;
    }
}
