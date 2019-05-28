package com.tencent.mm.plugin.sns.abtest;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.ui.v;

public class NotInterestMenu extends LinearLayout {
    private static int[] qCt = new int[]{R.string.el_, R.string.el8, R.string.el9};
    private Context mContext = null;
    private n qBY = null;
    private ListView qCs;
    private c qCu = null;
    private b qCv = null;

    public interface b {
        void clZ();
    }

    class a extends BaseAdapter {

        class a {
            TextView qCx;

            a() {
            }
        }

        a() {
        }

        public final int getCount() {
            AppMethodBeat.i(35664);
            int length = NotInterestMenu.qCt.length;
            AppMethodBeat.o(35664);
            return length;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(35665);
            Integer valueOf = Integer.valueOf(NotInterestMenu.qCt[i]);
            AppMethodBeat.o(35665);
            return valueOf;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(35666);
            if (view == null) {
                view = v.hu(NotInterestMenu.this.mContext).inflate(R.layout.aj3, viewGroup, false);
                a aVar = new a();
                aVar.qCx = (TextView) view.findViewById(R.id.did);
                view.setTag(aVar);
            }
            ((a) view.getTag()).qCx.setText(NotInterestMenu.qCt[i]);
            AppMethodBeat.o(35666);
            return view;
        }
    }

    public interface c {
        void c(n nVar);

        void d(n nVar);

        void e(n nVar);
    }

    public NotInterestMenu(Context context) {
        super(context);
        AppMethodBeat.i(35667);
        this.mContext = context;
        init();
        AppMethodBeat.o(35667);
    }

    public NotInterestMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(35668);
        this.mContext = context;
        init();
        AppMethodBeat.o(35668);
    }

    public void setOnSelectMenuItemListener(c cVar) {
        this.qCu = cVar;
    }

    public void setOnClickMenuListener(b bVar) {
        this.qCv = bVar;
    }

    public void setSnsInfo(n nVar) {
        this.qBY = nVar;
    }

    private void init() {
        AppMethodBeat.i(35669);
        v.hu(this.mContext).inflate(R.layout.aj2, this);
        this.qCs = (ListView) findViewById(R.id.dic);
        this.qCs.setAdapter(new a());
        this.qCs.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(35663);
                if (NotInterestMenu.this.qCv != null) {
                    NotInterestMenu.this.qCv.clZ();
                }
                if (NotInterestMenu.this.qCu != null) {
                    switch (i) {
                        case 0:
                            NotInterestMenu.this.qCu.c(NotInterestMenu.this.qBY);
                            AppMethodBeat.o(35663);
                            return;
                        case 1:
                            NotInterestMenu.this.qCu.d(NotInterestMenu.this.qBY);
                            AppMethodBeat.o(35663);
                            return;
                        case 2:
                            NotInterestMenu.this.qCu.e(NotInterestMenu.this.qBY);
                            break;
                    }
                }
                AppMethodBeat.o(35663);
            }
        });
        AppMethodBeat.o(35669);
    }
}
