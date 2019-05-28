package android.support.p057v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

/* renamed from: android.support.v4.app.ListFragment */
public class ListFragment extends Fragment {
    /* renamed from: Eg */
    private final Runnable f17678Eg = new C174291();
    /* renamed from: Eh */
    private final OnItemClickListener f17679Eh = new C318552();
    /* renamed from: Ei */
    ListAdapter f17680Ei;
    /* renamed from: Ej */
    ListView f17681Ej;
    /* renamed from: Ek */
    View f17682Ek;
    /* renamed from: El */
    TextView f17683El;
    /* renamed from: Em */
    View f17684Em;
    /* renamed from: En */
    View f17685En;
    /* renamed from: Eo */
    boolean f17686Eo;
    CharSequence mEmptyText;
    private final Handler mHandler = new Handler();

    /* renamed from: android.support.v4.app.ListFragment$1 */
    class C174291 implements Runnable {
        C174291() {
        }

        public final void run() {
            ListFragment.this.f17681Ej.focusableViewAvailable(ListFragment.this.f17681Ej);
        }
    }

    /* renamed from: android.support.v4.app.ListFragment$2 */
    class C318552 implements OnItemClickListener {
        C318552() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context = getContext();
        FrameLayout frameLayout = new FrameLayout(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(context, null, 16842874), new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(context);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(context);
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new LayoutParams(-1, -1));
        ListView listView = new ListView(context);
        listView.setId(16908298);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        return frameLayout;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m82249dq();
    }

    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.f17678Eg);
        this.f17681Ej = null;
        this.f17686Eo = false;
        this.f17685En = null;
        this.f17684Em = null;
        this.f17682Ek = null;
        this.f17683El = null;
        super.onDestroyView();
    }

    private void setListAdapter(ListAdapter listAdapter) {
        boolean z = false;
        boolean z2 = this.f17680Ei != null;
        this.f17680Ei = listAdapter;
        if (this.f17681Ej != null) {
            this.f17681Ej.setAdapter(listAdapter);
            if (!this.f17686Eo && !z2) {
                if (getView().getWindowToken() != null) {
                    z = true;
                }
                m82250e(true, z);
            }
        }
    }

    /* renamed from: e */
    private void m82250e(boolean z, boolean z2) {
        m82249dq();
        if (this.f17684Em == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        } else if (this.f17686Eo != z) {
            this.f17686Eo = z;
            if (z) {
                if (z2) {
                    this.f17684Em.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
                    this.f17685En.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                } else {
                    this.f17684Em.clearAnimation();
                    this.f17685En.clearAnimation();
                }
                this.f17684Em.setVisibility(8);
                this.f17685En.setVisibility(0);
                return;
            }
            if (z2) {
                this.f17684Em.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                this.f17685En.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
            } else {
                this.f17684Em.clearAnimation();
                this.f17685En.clearAnimation();
            }
            this.f17684Em.setVisibility(0);
            this.f17685En.setVisibility(8);
        }
    }

    /* renamed from: dq */
    private void m82249dq() {
        if (this.f17681Ej == null) {
            View view = getView();
            if (view == null) {
                throw new IllegalStateException("Content view not yet created");
            }
            if (view instanceof ListView) {
                this.f17681Ej = (ListView) view;
            } else {
                this.f17683El = (TextView) view.findViewById(16711681);
                if (this.f17683El == null) {
                    this.f17682Ek = view.findViewById(16908292);
                } else {
                    this.f17683El.setVisibility(8);
                }
                this.f17684Em = view.findViewById(16711682);
                this.f17685En = view.findViewById(16711683);
                view = view.findViewById(16908298);
                if (view instanceof ListView) {
                    this.f17681Ej = (ListView) view;
                    if (this.f17682Ek != null) {
                        this.f17681Ej.setEmptyView(this.f17682Ek);
                    } else if (this.mEmptyText != null) {
                        this.f17683El.setText(this.mEmptyText);
                        this.f17681Ej.setEmptyView(this.f17683El);
                    }
                } else if (view == null) {
                    throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                } else {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
            }
            this.f17686Eo = true;
            this.f17681Ej.setOnItemClickListener(this.f17679Eh);
            if (this.f17680Ei != null) {
                ListAdapter listAdapter = this.f17680Ei;
                this.f17680Ei = null;
                setListAdapter(listAdapter);
            } else if (this.f17684Em != null) {
                m82250e(false, false);
            }
            this.mHandler.post(this.f17678Eg);
        }
    }
}
