package com.tencent.p177mm.plugin.sns.abtest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.plugin.sns.storage.C46236n;

/* renamed from: com.tencent.mm.plugin.sns.abtest.NotInterestMenu */
public class NotInterestMenu extends LinearLayout {
    private static int[] qCt = new int[]{C25738R.string.el_, C25738R.string.el8, C25738R.string.el9};
    private Context mContext = null;
    private C46236n qBY = null;
    private ListView qCs;
    private C21864c qCu = null;
    private C21862b qCv = null;

    /* renamed from: com.tencent.mm.plugin.sns.abtest.NotInterestMenu$1 */
    class C218611 implements OnItemClickListener {
        C218611() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(35663);
            if (NotInterestMenu.this.qCv != null) {
                NotInterestMenu.this.qCv.clZ();
            }
            if (NotInterestMenu.this.qCu != null) {
                switch (i) {
                    case 0:
                        NotInterestMenu.this.qCu.mo37347c(NotInterestMenu.this.qBY);
                        AppMethodBeat.m2505o(35663);
                        return;
                    case 1:
                        NotInterestMenu.this.qCu.mo37348d(NotInterestMenu.this.qBY);
                        AppMethodBeat.m2505o(35663);
                        return;
                    case 2:
                        NotInterestMenu.this.qCu.mo37349e(NotInterestMenu.this.qBY);
                        break;
                }
            }
            AppMethodBeat.m2505o(35663);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.abtest.NotInterestMenu$b */
    public interface C21862b {
        void clZ();
    }

    /* renamed from: com.tencent.mm.plugin.sns.abtest.NotInterestMenu$a */
    class C21863a extends BaseAdapter {

        /* renamed from: com.tencent.mm.plugin.sns.abtest.NotInterestMenu$a$a */
        class C3864a {
            TextView qCx;

            C3864a() {
            }
        }

        C21863a() {
        }

        public final int getCount() {
            AppMethodBeat.m2504i(35664);
            int length = NotInterestMenu.qCt.length;
            AppMethodBeat.m2505o(35664);
            return length;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(35665);
            Integer valueOf = Integer.valueOf(NotInterestMenu.qCt[i]);
            AppMethodBeat.m2505o(35665);
            return valueOf;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(35666);
            if (view == null) {
                view = C5616v.m8409hu(NotInterestMenu.this.mContext).inflate(2130970311, viewGroup, false);
                C3864a c3864a = new C3864a();
                c3864a.qCx = (TextView) view.findViewById(2131826366);
                view.setTag(c3864a);
            }
            ((C3864a) view.getTag()).qCx.setText(NotInterestMenu.qCt[i]);
            AppMethodBeat.m2505o(35666);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.abtest.NotInterestMenu$c */
    public interface C21864c {
        /* renamed from: c */
        void mo37347c(C46236n c46236n);

        /* renamed from: d */
        void mo37348d(C46236n c46236n);

        /* renamed from: e */
        void mo37349e(C46236n c46236n);
    }

    public NotInterestMenu(Context context) {
        super(context);
        AppMethodBeat.m2504i(35667);
        this.mContext = context;
        init();
        AppMethodBeat.m2505o(35667);
    }

    public NotInterestMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(35668);
        this.mContext = context;
        init();
        AppMethodBeat.m2505o(35668);
    }

    public void setOnSelectMenuItemListener(C21864c c21864c) {
        this.qCu = c21864c;
    }

    public void setOnClickMenuListener(C21862b c21862b) {
        this.qCv = c21862b;
    }

    public void setSnsInfo(C46236n c46236n) {
        this.qBY = c46236n;
    }

    private void init() {
        AppMethodBeat.m2504i(35669);
        C5616v.m8409hu(this.mContext).inflate(2130970310, this);
        this.qCs = (ListView) findViewById(2131826365);
        this.qCs.setAdapter(new C21863a());
        this.qCs.setOnItemClickListener(new C218611());
        AppMethodBeat.m2505o(35669);
    }
}
