package com.tencent.mm.pluginsdk.cmd;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecoveryConsoleUI extends MMActivity implements OnItemClickListener {
    ListView Ej;
    List<Map<String, String>> kSg;
    List<a> vaC;
    SimpleAdapter vaD;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(79197);
        super.onCreate(bundle);
        setTitle("Recovery Console");
        this.vaC = b.dgV();
        this.kSg = new ArrayList(this.vaC.size());
        for (a aVar : this.vaC) {
            HashMap hashMap = new HashMap();
            hashMap.put("title", getString(aVar.vaH));
            this.kSg.add(hashMap);
        }
        this.vaD = new SimpleAdapter(this, this.kSg, R.layout.ae4, new String[]{"title"}, new int[]{16908310});
        this.Ej = (ListView) findViewById(16908298);
        this.Ej.setAdapter(this.vaD);
        this.Ej.setOnItemClickListener(this);
        AppMethodBeat.o(79197);
    }

    public final int getLayoutId() {
        return R.layout.afw;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(79198);
        a aVar = (a) this.vaC.get(i);
        if (aVar.vaI != null) {
            aVar.vaI.a(this, aVar.cSD.split(" +"), "");
            AppMethodBeat.o(79198);
            return;
        }
        b.B(this, aVar.cSD, "");
        AppMethodBeat.o(79198);
    }
}
