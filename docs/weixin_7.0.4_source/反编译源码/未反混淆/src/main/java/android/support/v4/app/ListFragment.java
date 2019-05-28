package android.support.v4.app;

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

public class ListFragment extends Fragment {
    private final Runnable Eg = new Runnable() {
        public final void run() {
            ListFragment.this.Ej.focusableViewAvailable(ListFragment.this.Ej);
        }
    };
    private final OnItemClickListener Eh = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        }
    };
    ListAdapter Ei;
    ListView Ej;
    View Ek;
    TextView El;
    View Em;
    View En;
    boolean Eo;
    CharSequence mEmptyText;
    private final Handler mHandler = new Handler();

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
        dq();
    }

    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.Eg);
        this.Ej = null;
        this.Eo = false;
        this.En = null;
        this.Em = null;
        this.Ek = null;
        this.El = null;
        super.onDestroyView();
    }

    private void setListAdapter(ListAdapter listAdapter) {
        boolean z = false;
        boolean z2 = this.Ei != null;
        this.Ei = listAdapter;
        if (this.Ej != null) {
            this.Ej.setAdapter(listAdapter);
            if (!this.Eo && !z2) {
                if (getView().getWindowToken() != null) {
                    z = true;
                }
                e(true, z);
            }
        }
    }

    private void e(boolean z, boolean z2) {
        dq();
        if (this.Em == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        } else if (this.Eo != z) {
            this.Eo = z;
            if (z) {
                if (z2) {
                    this.Em.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
                    this.En.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                } else {
                    this.Em.clearAnimation();
                    this.En.clearAnimation();
                }
                this.Em.setVisibility(8);
                this.En.setVisibility(0);
                return;
            }
            if (z2) {
                this.Em.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                this.En.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
            } else {
                this.Em.clearAnimation();
                this.En.clearAnimation();
            }
            this.Em.setVisibility(0);
            this.En.setVisibility(8);
        }
    }

    private void dq() {
        if (this.Ej == null) {
            View view = getView();
            if (view == null) {
                throw new IllegalStateException("Content view not yet created");
            }
            if (view instanceof ListView) {
                this.Ej = (ListView) view;
            } else {
                this.El = (TextView) view.findViewById(16711681);
                if (this.El == null) {
                    this.Ek = view.findViewById(16908292);
                } else {
                    this.El.setVisibility(8);
                }
                this.Em = view.findViewById(16711682);
                this.En = view.findViewById(16711683);
                view = view.findViewById(16908298);
                if (view instanceof ListView) {
                    this.Ej = (ListView) view;
                    if (this.Ek != null) {
                        this.Ej.setEmptyView(this.Ek);
                    } else if (this.mEmptyText != null) {
                        this.El.setText(this.mEmptyText);
                        this.Ej.setEmptyView(this.El);
                    }
                } else if (view == null) {
                    throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                } else {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
            }
            this.Eo = true;
            this.Ej.setOnItemClickListener(this.Eh);
            if (this.Ei != null) {
                ListAdapter listAdapter = this.Ei;
                this.Ei = null;
                setListAdapter(listAdapter);
            } else if (this.Em != null) {
                e(false, false);
            }
            this.mHandler.post(this.Eg);
        }
    }
}
