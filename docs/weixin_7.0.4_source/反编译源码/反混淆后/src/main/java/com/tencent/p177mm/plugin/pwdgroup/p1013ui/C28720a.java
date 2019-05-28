package com.tencent.p177mm.plugin.pwdgroup.p1013ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.pwdgroup.C34742b.C21505a;
import com.tencent.p177mm.protocal.protobuf.aan;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.pwdgroup.ui.a */
public final class C28720a extends BaseAdapter {
    private LinkedList<aan> lei = new LinkedList();
    private Context mContext;
    private Animation nCY;
    private Animation prN;
    private Animation prO;
    private HashMap<String, Boolean> prP = new HashMap();

    /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.a$a */
    class C28721a {
        TextView gsf;
        ImageView iNr;

        public C28721a(View view) {
            AppMethodBeat.m2504i(24032);
            this.iNr = (ImageView) view.findViewById(2131823877);
            this.gsf = (TextView) view.findViewById(2131823878);
            AppMethodBeat.m2505o(24032);
        }
    }

    public C28720a(Context context) {
        AppMethodBeat.m2504i(24033);
        this.mContext = context;
        this.nCY = AnimationUtils.loadAnimation(this.mContext, C25738R.anim.f8288n);
        this.prO = AnimationUtils.loadAnimation(this.mContext, C25738R.anim.f8288n);
        this.prN = AnimationUtils.loadAnimation(this.mContext, C25738R.anim.f8289o);
        this.nCY.setInterpolator(new AccelerateDecelerateInterpolator());
        this.prO.setInterpolator(new AccelerateInterpolator());
        this.prN.setInterpolator(new AccelerateDecelerateInterpolator());
        this.nCY.setDuration(300);
        this.prO.setDuration(1000);
        this.prN.setDuration(1000);
        AppMethodBeat.m2505o(24033);
    }

    public final void setData(LinkedList<aan> linkedList) {
        AppMethodBeat.m2504i(24034);
        this.lei = linkedList;
        if (this.lei != null && this.lei.size() > 0) {
            int size = this.lei.size();
            for (int i = 0; i < size; i++) {
                String a = C28720a.m45639a((aan) this.lei.get(i));
                if (!this.prP.containsKey(a)) {
                    this.prP.put(a, Boolean.FALSE);
                }
            }
        }
        notifyDataSetChanged();
        AppMethodBeat.m2505o(24034);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(24035);
        if (this.lei == null) {
            AppMethodBeat.m2505o(24035);
            return 1;
        }
        int size = this.lei.size() + 1;
        AppMethodBeat.m2505o(24035);
        return size;
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(24036);
        if (this.lei == null) {
            AppMethodBeat.m2505o(24036);
            return null;
        } else if (i >= this.lei.size()) {
            AppMethodBeat.m2505o(24036);
            return null;
        } else {
            Object obj = this.lei.get(i);
            AppMethodBeat.m2505o(24036);
            return obj;
        }
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C28721a c28721a;
        AppMethodBeat.m2504i(24037);
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(2130969490, null);
            C28721a c28721a2 = new C28721a(view);
            view.setTag(c28721a2);
            c28721a = c28721a2;
        } else {
            c28721a = (C28721a) view.getTag();
        }
        aan aan = (aan) getItem(i);
        if (aan != null) {
            if (C5046bo.isNullOrNil(aan.jCH)) {
                c28721a.gsf.setText(aan.jBB);
            } else {
                c28721a.gsf.setText(aan.jCH);
            }
            if (C5046bo.isNullOrNil(aan.jBB)) {
                C21505a.m32967b(c28721a.iNr, aan.wfK);
            } else {
                C21505a.m32967b(c28721a.iNr, aan.jBB);
            }
            String a = C28720a.m45639a(aan);
            view.clearAnimation();
            if (this.prP.containsKey(a) && !((Boolean) this.prP.get(a)).booleanValue()) {
                view.startAnimation(this.nCY);
                this.prP.put(a, Boolean.TRUE);
            }
        }
        if (i + 1 == getCount()) {
            c28721a.gsf.setText("");
            c28721a.iNr.setImageResource(C25738R.drawable.aum);
            if (view != null) {
                this.prO.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.m2504i(24030);
                        view.startAnimation(C28720a.this.prN);
                        AppMethodBeat.m2505o(24030);
                    }
                });
                this.prN.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.m2504i(24031);
                        view.startAnimation(C28720a.this.prO);
                        AppMethodBeat.m2505o(24031);
                    }
                });
                view.startAnimation(this.prO);
            }
        }
        AppMethodBeat.m2505o(24037);
        return view;
    }

    /* renamed from: a */
    private static String m45639a(aan aan) {
        AppMethodBeat.m2504i(24038);
        String str;
        if (aan == null) {
            str = "";
            AppMethodBeat.m2505o(24038);
            return str;
        } else if (C5046bo.isNullOrNil(aan.jBB)) {
            str = aan.wfK;
            AppMethodBeat.m2505o(24038);
            return str;
        } else {
            str = aan.jBB;
            AppMethodBeat.m2505o(24038);
            return str;
        }
    }
}
