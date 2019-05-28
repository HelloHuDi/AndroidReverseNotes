package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.ui.MMActivity;

public class AppBrandSharedMessageUI extends MMActivity {
    private MRecyclerView iIE;
    private ListView mListView;

    static class b extends BaseAdapter {
        private LayoutInflater mInflater;

        public b(LayoutInflater layoutInflater) {
            this.mInflater = layoutInflater;
        }

        public final int getCount() {
            return 0;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(133096);
            int itemViewType = super.getItemViewType(i);
            AppMethodBeat.o(133096);
            return itemViewType;
        }

        public final int getViewTypeCount() {
            return 4;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }

    public static class a extends android.support.v7.widget.RecyclerView.a {
        public final v a(ViewGroup viewGroup, int i) {
            return null;
        }

        public final void a(v vVar, int i) {
        }

        public final int getItemCount() {
            return 0;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(133095);
            int itemViewType = super.getItemViewType(i);
            AppMethodBeat.o(133095);
            return itemViewType;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.di;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(133097);
        super.onCreate(bundle);
        this.mListView = (ListView) findViewById(R.id.vi);
        this.iIE = (MRecyclerView) findViewById(R.id.vj);
        this.mListView.setAdapter(new b(getLayoutInflater()));
        this.mListView.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.iIE.setLayoutManager(new LinearLayoutManager(1));
        this.iIE.setAdapter(new a());
        this.iIE.addHeaderView(getLayoutInflater().inflate(R.layout.dh, null));
        AppMethodBeat.o(133097);
    }
}
