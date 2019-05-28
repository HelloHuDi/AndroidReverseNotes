package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.os.Bundle;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.MRecyclerView;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandSharedMessageUI */
public class AppBrandSharedMessageUI extends MMActivity {
    private MRecyclerView iIE;
    private ListView mListView;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandSharedMessageUI$1 */
    class C24761 implements OnItemClickListener {
        C24761() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandSharedMessageUI$b */
    static class C10799b extends BaseAdapter {
        private LayoutInflater mInflater;

        public C10799b(LayoutInflater layoutInflater) {
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
            AppMethodBeat.m2504i(133096);
            int itemViewType = super.getItemViewType(i);
            AppMethodBeat.m2505o(133096);
            return itemViewType;
        }

        public final int getViewTypeCount() {
            return 4;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandSharedMessageUI$a */
    public static class C27321a extends C41523a {
        /* renamed from: a */
        public final C41531v mo4976a(ViewGroup viewGroup, int i) {
            return null;
        }

        /* renamed from: a */
        public final void mo4977a(C41531v c41531v, int i) {
        }

        public final int getItemCount() {
            return 0;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(133095);
            int itemViewType = super.getItemViewType(i);
            AppMethodBeat.m2505o(133095);
            return itemViewType;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130968732;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(133097);
        super.onCreate(bundle);
        this.mListView = (ListView) findViewById(2131821366);
        this.iIE = (MRecyclerView) findViewById(2131821367);
        this.mListView.setAdapter(new C10799b(getLayoutInflater()));
        this.mListView.setOnItemClickListener(new C24761());
        this.iIE.setLayoutManager(new LinearLayoutManager(1));
        this.iIE.setAdapter(new C27321a());
        this.iIE.addHeaderView(getLayoutInflater().inflate(2130968731, null));
        AppMethodBeat.m2505o(133097);
    }
}
