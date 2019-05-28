package com.tencent.mm.pluginsdk.ui.tools;

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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;

public class FileSelectorFolderView extends LinearLayout implements OnItemClickListener {
    boolean aej = false;
    private FrameLayout mQA;
    private View mQB;
    private ListView mQC;
    private boolean mQE = false;
    private a vui = null;
    private b vuj;

    public interface a {
        void Ls(int i);
    }

    public static class b extends BaseAdapter {
        private Context mContext;

        public b(Context context) {
            this.mContext = context;
        }

        public final int getCount() {
            return 2;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(28161);
            Integer valueOf = Integer.valueOf(i);
            AppMethodBeat.o(28161);
            return valueOf;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            AppMethodBeat.i(28162);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.a03, null);
                cVar = new c(view);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            switch (i) {
                case 0:
                    cVar.gne.setText(R.string.bsw);
                    break;
                case 1:
                    cVar.gne.setText(R.string.bsx);
                    break;
                default:
                    cVar.gne.setText(R.string.pl);
                    break;
            }
            AppMethodBeat.o(28162);
            return view;
        }
    }

    static class c {
        TextView gne;

        c(View view) {
            AppMethodBeat.i(28163);
            this.gne = (TextView) view.findViewById(R.id.bgm);
            AppMethodBeat.o(28163);
        }
    }

    static /* synthetic */ void c(FileSelectorFolderView fileSelectorFolderView) {
        AppMethodBeat.i(28169);
        fileSelectorFolderView.hE(false);
        AppMethodBeat.o(28169);
    }

    public FileSelectorFolderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(28164);
        init();
        AppMethodBeat.o(28164);
    }

    public FileSelectorFolderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(28165);
        init();
        AppMethodBeat.o(28165);
    }

    /* Access modifiers changed, original: final */
    public final void hE(boolean z) {
        AppMethodBeat.i(28166);
        Animation loadAnimation;
        if (this.aej == z) {
            ab.d("MicroMsg.FileSelectorFolderView", "want to expand, but same status, expanded %B", Boolean.valueOf(this.aej));
            AppMethodBeat.o(28166);
        } else if (this.mQE) {
            ab.d("MicroMsg.FileSelectorFolderView", "want to expand[%B], but now in animation", Boolean.valueOf(z));
            AppMethodBeat.o(28166);
        } else if (this.aej) {
            this.mQE = true;
            loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.ce);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(28158);
                    FileSelectorFolderView.this.mQA.setVisibility(8);
                    FileSelectorFolderView.this.aej = false;
                    FileSelectorFolderView.this.mQE = false;
                    AppMethodBeat.o(28158);
                }
            });
            this.mQC.startAnimation(loadAnimation);
            this.mQB.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.b6));
            AppMethodBeat.o(28166);
        } else {
            this.mQE = true;
            this.mQA.setVisibility(0);
            this.mQB.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.b5));
            loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.cg);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(28159);
                    FileSelectorFolderView.this.aej = true;
                    FileSelectorFolderView.this.mQE = false;
                    AppMethodBeat.o(28159);
                }
            });
            this.mQC.startAnimation(loadAnimation);
            AppMethodBeat.o(28166);
        }
    }

    private void init() {
        AppMethodBeat.i(28167);
        setOrientation(1);
        this.mQA = new FrameLayout(getContext());
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        this.mQA.setVisibility(8);
        addView(this.mQA, layoutParams);
        this.mQB = new View(getContext());
        this.mQB.setBackgroundColor(-872415232);
        this.mQB.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(28160);
                FileSelectorFolderView.c(FileSelectorFolderView.this);
                AppMethodBeat.o(28160);
            }
        });
        this.mQA.addView(this.mQB, new FrameLayout.LayoutParams(-1, -1));
        this.mQC = new ListView(getContext());
        this.mQC.setCacheColorHint(0);
        this.mQC.setBackgroundResource(R.color.vs);
        this.mQC.setSelector(R.drawable.uv);
        this.mQC.setOnItemClickListener(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.m4);
        this.mQC.setPadding(dimensionPixelSize, dimensionPixelSize / 3, dimensionPixelSize, 0);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.fd);
        layoutParams2.gravity = 80;
        this.mQA.addView(this.mQC, layoutParams2);
        this.vuj = new b(getContext());
        this.mQC.setAdapter(this.vuj);
        AppMethodBeat.o(28167);
    }

    public void setListener(a aVar) {
        this.vui = aVar;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(28168);
        if (this.vui != null) {
            this.vui.Ls(i);
        }
        this.mQB.performClick();
        AppMethodBeat.o(28168);
    }
}
