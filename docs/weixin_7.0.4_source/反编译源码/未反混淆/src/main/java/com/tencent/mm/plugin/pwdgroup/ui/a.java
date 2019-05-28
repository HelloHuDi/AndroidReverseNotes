package com.tencent.mm.plugin.pwdgroup.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;

public final class a extends BaseAdapter {
    private LinkedList<aan> lei = new LinkedList();
    private Context mContext;
    private Animation nCY;
    private Animation prN;
    private Animation prO;
    private HashMap<String, Boolean> prP = new HashMap();

    class a {
        TextView gsf;
        ImageView iNr;

        public a(View view) {
            AppMethodBeat.i(24032);
            this.iNr = (ImageView) view.findViewById(R.id.bp3);
            this.gsf = (TextView) view.findViewById(R.id.bp4);
            AppMethodBeat.o(24032);
        }
    }

    public a(Context context) {
        AppMethodBeat.i(24033);
        this.mContext = context;
        this.nCY = AnimationUtils.loadAnimation(this.mContext, R.anim.n);
        this.prO = AnimationUtils.loadAnimation(this.mContext, R.anim.n);
        this.prN = AnimationUtils.loadAnimation(this.mContext, R.anim.o);
        this.nCY.setInterpolator(new AccelerateDecelerateInterpolator());
        this.prO.setInterpolator(new AccelerateInterpolator());
        this.prN.setInterpolator(new AccelerateDecelerateInterpolator());
        this.nCY.setDuration(300);
        this.prO.setDuration(1000);
        this.prN.setDuration(1000);
        AppMethodBeat.o(24033);
    }

    public final void setData(LinkedList<aan> linkedList) {
        AppMethodBeat.i(24034);
        this.lei = linkedList;
        if (this.lei != null && this.lei.size() > 0) {
            int size = this.lei.size();
            for (int i = 0; i < size; i++) {
                String a = a((aan) this.lei.get(i));
                if (!this.prP.containsKey(a)) {
                    this.prP.put(a, Boolean.FALSE);
                }
            }
        }
        notifyDataSetChanged();
        AppMethodBeat.o(24034);
    }

    public final int getCount() {
        AppMethodBeat.i(24035);
        if (this.lei == null) {
            AppMethodBeat.o(24035);
            return 1;
        }
        int size = this.lei.size() + 1;
        AppMethodBeat.o(24035);
        return size;
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(24036);
        if (this.lei == null) {
            AppMethodBeat.o(24036);
            return null;
        } else if (i >= this.lei.size()) {
            AppMethodBeat.o(24036);
            return null;
        } else {
            Object obj = this.lei.get(i);
            AppMethodBeat.o(24036);
            return obj;
        }
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(24037);
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.xy, null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aan aan = (aan) getItem(i);
        if (aan != null) {
            if (bo.isNullOrNil(aan.jCH)) {
                aVar.gsf.setText(aan.jBB);
            } else {
                aVar.gsf.setText(aan.jCH);
            }
            if (bo.isNullOrNil(aan.jBB)) {
                com.tencent.mm.plugin.pwdgroup.b.a.b(aVar.iNr, aan.wfK);
            } else {
                com.tencent.mm.plugin.pwdgroup.b.a.b(aVar.iNr, aan.jBB);
            }
            String a = a(aan);
            view.clearAnimation();
            if (this.prP.containsKey(a) && !((Boolean) this.prP.get(a)).booleanValue()) {
                view.startAnimation(this.nCY);
                this.prP.put(a, Boolean.TRUE);
            }
        }
        if (i + 1 == getCount()) {
            aVar.gsf.setText("");
            aVar.iNr.setImageResource(R.drawable.aum);
            if (view != null) {
                this.prO.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(24030);
                        view.startAnimation(a.this.prN);
                        AppMethodBeat.o(24030);
                    }
                });
                this.prN.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(24031);
                        view.startAnimation(a.this.prO);
                        AppMethodBeat.o(24031);
                    }
                });
                view.startAnimation(this.prO);
            }
        }
        AppMethodBeat.o(24037);
        return view;
    }

    private static String a(aan aan) {
        AppMethodBeat.i(24038);
        String str;
        if (aan == null) {
            str = "";
            AppMethodBeat.o(24038);
            return str;
        } else if (bo.isNullOrNil(aan.jBB)) {
            str = aan.wfK;
            AppMethodBeat.o(24038);
            return str;
        } else {
            str = aan.jBB;
            AppMethodBeat.o(24038);
            return str;
        }
    }
}
