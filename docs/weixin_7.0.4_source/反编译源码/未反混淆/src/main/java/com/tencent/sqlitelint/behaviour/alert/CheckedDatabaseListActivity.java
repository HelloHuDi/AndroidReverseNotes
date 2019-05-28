package com.tencent.sqlitelint.behaviour.alert;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.sqlitelint.behaviour.persistence.SQLiteLintDbHelper;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.util.List;

public class CheckedDatabaseListActivity extends SQLiteLintBaseActivity {
    private static final String TAG = "SQLiteLint.CheckedDatabaseListActivity";
    private CheckedDatabaseListAdapter mListAdapter;
    private ListView mListView;

    static class CheckedDatabaseListAdapter extends BaseAdapter {
        private List<String> mDefectiveDbList;
        private final LayoutInflater mInflater;

        CheckedDatabaseListAdapter(Context context) {
            AppMethodBeat.i(94047);
            this.mInflater = LayoutInflater.from(context);
            AppMethodBeat.o(94047);
        }

        public void setData(List<String> list) {
            AppMethodBeat.i(94048);
            this.mDefectiveDbList = list;
            notifyDataSetChanged();
            AppMethodBeat.o(94048);
        }

        public int getCount() {
            AppMethodBeat.i(94049);
            if (this.mDefectiveDbList == null) {
                AppMethodBeat.o(94049);
                return 0;
            }
            int size = this.mDefectiveDbList.size();
            AppMethodBeat.o(94049);
            return size;
        }

        public String getItem(int i) {
            AppMethodBeat.i(94050);
            String str = (String) this.mDefectiveDbList.get(i);
            AppMethodBeat.o(94050);
            return str;
        }

        public long getItemId(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            AppMethodBeat.i(94051);
            if (view == null) {
                view = this.mInflater.inflate(R.layout.b1n, viewGroup, false);
                ViewHolder viewHolder2 = new ViewHolder();
                viewHolder2.dbPathTv = (TextView) view.findViewById(R.id.f18);
                view.setTag(viewHolder2);
                viewHolder = viewHolder2;
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.dbPathTv.setText(getItem(i));
            AppMethodBeat.o(94051);
            return view;
        }
    }

    static class ViewHolder {
        public TextView dbPathTv;

        ViewHolder() {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(94053);
        super.onCreate(bundle);
        SQLiteLintDbHelper.INSTANCE.initialize(this);
        initView();
        AppMethodBeat.o(94053);
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        AppMethodBeat.i(94054);
        super.onResume();
        refreshView();
        AppMethodBeat.o(94054);
    }

    /* Access modifiers changed, original: protected */
    public int getLayoutId() {
        return R.layout.ak;
    }

    private void initView() {
        AppMethodBeat.i(94055);
        setTitle(getString(R.string.g6i));
        this.mListView = (ListView) findViewById(R.id.l9);
        this.mListAdapter = new CheckedDatabaseListAdapter(this);
        this.mListView.setAdapter(this.mListAdapter);
        this.mListView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(94046);
                String str = (String) adapterView.getItemAtPosition(i);
                if (SQLiteLintUtil.isNullOrNil(str)) {
                    AppMethodBeat.o(94046);
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(CheckedDatabaseListActivity.this, CheckResultActivity.class);
                intent.putExtra(CheckResultActivity.KEY_DB_LABEL, str);
                CheckedDatabaseListActivity.this.startActivity(intent);
                AppMethodBeat.o(94046);
            }
        });
        AppMethodBeat.o(94055);
    }

    private void refreshView() {
        AppMethodBeat.i(94056);
        SLog.i(TAG, "refreshView defectiveDbList is %d", Integer.valueOf(IssueStorage.getDbPathList().size()));
        this.mListAdapter.setData(r0);
        AppMethodBeat.o(94056);
    }
}
