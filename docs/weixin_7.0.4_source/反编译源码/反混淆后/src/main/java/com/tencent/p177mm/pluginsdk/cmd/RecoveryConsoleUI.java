package com.tencent.p177mm.pluginsdk.cmd;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.pluginsdk.cmd.C44042b.C44043a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.pluginsdk.cmd.RecoveryConsoleUI */
public class RecoveryConsoleUI extends MMActivity implements OnItemClickListener {
    /* renamed from: Ej */
    ListView f2969Ej;
    List<Map<String, String>> kSg;
    List<C44043a> vaC;
    SimpleAdapter vaD;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(79197);
        super.onCreate(bundle);
        setTitle("Recovery Console");
        this.vaC = C44042b.dgV();
        this.kSg = new ArrayList(this.vaC.size());
        for (C44043a c44043a : this.vaC) {
            HashMap hashMap = new HashMap();
            hashMap.put("title", getString(c44043a.vaH));
            this.kSg.add(hashMap);
        }
        this.vaD = new SimpleAdapter(this, this.kSg, 2130970127, new String[]{"title"}, new int[]{16908310});
        this.f2969Ej = (ListView) findViewById(16908298);
        this.f2969Ej.setAdapter(this.vaD);
        this.f2969Ej.setOnItemClickListener(this);
        AppMethodBeat.m2505o(79197);
    }

    public final int getLayoutId() {
        return 2130970193;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(79198);
        C44043a c44043a = (C44043a) this.vaC.get(i);
        if (c44043a.vaI != null) {
            c44043a.vaI.mo7165a(this, c44043a.cSD.split(" +"), "");
            AppMethodBeat.m2505o(79198);
            return;
        }
        C44042b.m79161B(this, c44043a.cSD, "");
        AppMethodBeat.m2505o(79198);
    }
}
